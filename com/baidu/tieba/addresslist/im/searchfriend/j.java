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
    private EditText aAS;
    private TextView aAT;
    private ImageView aAU;
    private m aAV;
    private View.OnClickListener aAW = new k(this);
    private Context context;
    private TbPageContext<?> mPageContext;

    public void bx(boolean z) {
        this.aAT.setClickable(z);
    }

    public void fD(String str) {
        this.aAS.setText(str);
    }

    public j(TbPageContext<?> tbPageContext, View view) {
        this.mPageContext = tbPageContext;
        this.context = this.mPageContext.getPageActivity();
        this.aAS = (EditText) view.findViewById(com.baidu.tieba.q.new_search_friend_input);
        this.aAT = (TextView) view.findViewById(com.baidu.tieba.q.new_search_friend_search);
        this.aAU = (ImageView) view.findViewById(com.baidu.tieba.q.new_search_friend_del);
        this.aAT.setOnClickListener(this.aAW);
        this.aAU.setOnClickListener(this.aAW);
        this.aAS.addTextChangedListener(new l(this));
        cy(TbadkCoreApplication.m411getInst().getSkinType());
    }

    public void hideSoftKeyboard() {
        com.baidu.adp.lib.util.n.c(this.context, this.aAS);
    }

    public void a(m mVar) {
        this.aAV = mVar;
    }

    public void cy(int i) {
        ay.b(this.aAT, com.baidu.tieba.n.cp_cont_g, 1);
        this.aAS.setHintTextColor(ay.getColor(com.baidu.tieba.n.cp_cont_e));
        ay.c(this.aAU, com.baidu.tieba.p.icon_search_close);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fE(String str) {
        if (this.aAV != null) {
            this.aAV.fC(str);
        }
    }
}
