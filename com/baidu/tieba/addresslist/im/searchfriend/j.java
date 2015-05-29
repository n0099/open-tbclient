package com.baidu.tieba.addresslist.im.searchfriend;

import android.content.Context;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ay;
/* loaded from: classes.dex */
public class j {
    private EditText aAR;
    private TextView aAS;
    private ImageView aAT;
    private m aAU;
    private View.OnClickListener aAV = new k(this);
    private Context context;
    private TbPageContext<?> mPageContext;

    public void bx(boolean z) {
        this.aAS.setClickable(z);
    }

    public void fD(String str) {
        this.aAR.setText(str);
    }

    public j(TbPageContext<?> tbPageContext, View view) {
        this.mPageContext = tbPageContext;
        this.context = this.mPageContext.getPageActivity();
        this.aAR = (EditText) view.findViewById(com.baidu.tieba.q.new_search_friend_input);
        this.aAS = (TextView) view.findViewById(com.baidu.tieba.q.new_search_friend_search);
        this.aAT = (ImageView) view.findViewById(com.baidu.tieba.q.new_search_friend_del);
        this.aAS.setOnClickListener(this.aAV);
        this.aAT.setOnClickListener(this.aAV);
        this.aAR.addTextChangedListener(new l(this));
        cy(TbadkCoreApplication.m411getInst().getSkinType());
    }

    public void hideSoftKeyboard() {
        com.baidu.adp.lib.util.n.c(this.context, this.aAR);
    }

    public void a(m mVar) {
        this.aAU = mVar;
    }

    public void cy(int i) {
        ay.b(this.aAS, com.baidu.tieba.n.cp_cont_g, 1);
        this.aAR.setHintTextColor(ay.getColor(com.baidu.tieba.n.cp_cont_e));
        ay.c(this.aAT, com.baidu.tieba.p.icon_search_close);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fE(String str) {
        if (this.aAU != null) {
            this.aAU.fC(str);
        }
    }
}
