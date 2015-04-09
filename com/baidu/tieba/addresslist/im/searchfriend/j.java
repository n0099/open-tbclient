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
    private EditText azg;
    private TextView azh;
    private ImageView azi;
    private m azj;
    private View.OnClickListener azk = new k(this);
    private Context context;
    private TbPageContext<?> mPageContext;

    public void bo(boolean z) {
        this.azh.setClickable(z);
    }

    public void fi(String str) {
        this.azg.setText(str);
    }

    public j(TbPageContext<?> tbPageContext, View view) {
        this.mPageContext = tbPageContext;
        this.context = this.mPageContext.getPageActivity();
        this.azg = (EditText) view.findViewById(com.baidu.tieba.v.new_search_friend_input);
        this.azh = (TextView) view.findViewById(com.baidu.tieba.v.new_search_friend_search);
        this.azi = (ImageView) view.findViewById(com.baidu.tieba.v.new_search_friend_del);
        this.azh.setOnClickListener(this.azk);
        this.azi.setOnClickListener(this.azk);
        this.azg.addTextChangedListener(new l(this));
        ct(TbadkCoreApplication.m411getInst().getSkinType());
    }

    public void hideSoftKeyboard() {
        com.baidu.adp.lib.util.n.c(this.context, this.azg);
    }

    public void a(m mVar) {
        this.azj = mVar;
    }

    public void ct(int i) {
        ba.b(this.azh, com.baidu.tieba.s.cp_cont_g, 1);
        this.azg.setHintTextColor(ba.getColor(com.baidu.tieba.s.cp_cont_e));
        ba.c(this.azi, com.baidu.tieba.u.icon_search_close);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fj(String str) {
        if (this.azj != null) {
            this.azj.fh(str);
        }
    }
}
