package com.baidu.tieba.addresslist.im.searchfriend;

import android.content.Context;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ba;
/* loaded from: classes.dex */
public class j {
    private EditText ayY;
    private TextView ayZ;
    private ImageView aza;
    private m azb;
    private View.OnClickListener azc = new k(this);
    private Context context;
    private TbPageContext<?> mPageContext;

    public void bo(boolean z) {
        this.ayZ.setClickable(z);
    }

    public void ff(String str) {
        this.ayY.setText(str);
    }

    public j(TbPageContext<?> tbPageContext, View view) {
        this.mPageContext = tbPageContext;
        this.context = this.mPageContext.getPageActivity();
        this.ayY = (EditText) view.findViewById(com.baidu.tieba.v.new_search_friend_input);
        this.ayZ = (TextView) view.findViewById(com.baidu.tieba.v.new_search_friend_search);
        this.aza = (ImageView) view.findViewById(com.baidu.tieba.v.new_search_friend_del);
        this.ayZ.setOnClickListener(this.azc);
        this.aza.setOnClickListener(this.azc);
        this.ayY.addTextChangedListener(new l(this));
        ct(TbadkCoreApplication.m411getInst().getSkinType());
    }

    public void hideSoftKeyboard() {
        com.baidu.adp.lib.util.n.c(this.context, this.ayY);
    }

    public void a(m mVar) {
        this.azb = mVar;
    }

    public void ct(int i) {
        ba.b(this.ayZ, com.baidu.tieba.s.cp_cont_g, 1);
        this.ayY.setHintTextColor(ba.getColor(com.baidu.tieba.s.cp_cont_e));
        ba.c(this.aza, com.baidu.tieba.u.icon_search_close);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fg(String str) {
        if (this.azb != null) {
            this.azb.fe(str);
        }
    }
}
