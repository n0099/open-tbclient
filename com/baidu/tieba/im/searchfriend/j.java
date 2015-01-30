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
    private EditText boa;
    private TextView bob;
    private ImageView boc;
    private m bod;
    private View.OnClickListener boe = new k(this);
    private Context context;
    private TbPageContext<?> mPageContext;

    public void dk(boolean z) {
        this.bob.setClickable(z);
    }

    public void hl(String str) {
        this.boa.setText(str);
    }

    public j(TbPageContext<?> tbPageContext, View view) {
        this.mPageContext = tbPageContext;
        this.context = this.mPageContext.getPageActivity();
        this.boa = (EditText) view.findViewById(w.new_search_friend_input);
        this.bob = (TextView) view.findViewById(w.new_search_friend_search);
        this.boc = (ImageView) view.findViewById(w.new_search_friend_del);
        this.bob.setOnClickListener(this.boe);
        this.boc.setOnClickListener(this.boe);
        this.boa.addTextChangedListener(new l(this));
        cs(TbadkCoreApplication.m255getInst().getSkinType());
    }

    public void hideSoftKeyboard() {
        com.baidu.adp.lib.util.l.c(this.context, this.boa);
    }

    public void a(m mVar) {
        this.bod = mVar;
    }

    public void cs(int i) {
        bc.b(this.bob, com.baidu.tieba.t.cp_cont_g, 1);
        this.boa.setHintTextColor(bc.getColor(com.baidu.tieba.t.cp_cont_e));
        bc.c(this.boc, com.baidu.tieba.v.icon_search_close);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fW(String str) {
        if (this.bod != null) {
            this.bod.hk(str);
        }
    }
}
