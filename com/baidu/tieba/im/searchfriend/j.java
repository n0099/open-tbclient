package com.baidu.tieba.im.searchfriend;

import android.content.Context;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class j {
    private EditText bnZ;
    private TextView boa;
    private ImageView bob;
    private m boc;
    private View.OnClickListener bod = new k(this);
    private Context context;
    private TbPageContext<?> mPageContext;

    public void dk(boolean z) {
        this.boa.setClickable(z);
    }

    public void hi(String str) {
        this.bnZ.setText(str);
    }

    public j(TbPageContext<?> tbPageContext, View view) {
        this.mPageContext = tbPageContext;
        this.context = this.mPageContext.getPageActivity();
        this.bnZ = (EditText) view.findViewById(w.new_search_friend_input);
        this.boa = (TextView) view.findViewById(w.new_search_friend_search);
        this.bob = (ImageView) view.findViewById(w.new_search_friend_del);
        this.boa.setOnClickListener(this.bod);
        this.bob.setOnClickListener(this.bod);
        this.bnZ.addTextChangedListener(new l(this));
        cs(TbadkCoreApplication.m255getInst().getSkinType());
    }

    public void hideSoftKeyboard() {
        com.baidu.adp.lib.util.l.c(this.context, this.bnZ);
    }

    public void a(m mVar) {
        this.boc = mVar;
    }

    public void cs(int i) {
        bc.b(this.boa, com.baidu.tieba.t.cp_cont_g, 1);
        this.bnZ.setHintTextColor(bc.getColor(com.baidu.tieba.t.cp_cont_e));
        bc.c(this.bob, com.baidu.tieba.v.icon_search_close);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fT(String str) {
        if (this.boc != null) {
            this.boc.hh(str);
        }
    }
}
