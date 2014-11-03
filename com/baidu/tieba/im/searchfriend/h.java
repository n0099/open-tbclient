package com.baidu.tieba.im.searchfriend;

import android.content.Context;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
/* loaded from: classes.dex */
public class h {
    private EditText bia;
    private TextView bib;
    private ImageView bic;
    private k bie;
    private View.OnClickListener bif = new i(this);
    private Context context;

    public void ds(boolean z) {
        this.bib.setClickable(z);
    }

    public void gC(String str) {
        this.bia.setText(str);
    }

    public h(Context context, View view) {
        this.context = context;
        this.bia = (EditText) view.findViewById(v.new_search_friend_input);
        this.bib = (TextView) view.findViewById(v.new_search_friend_search);
        this.bic = (ImageView) view.findViewById(v.new_search_friend_del);
        this.bib.setOnClickListener(this.bif);
        this.bic.setOnClickListener(this.bif);
        this.bia.addTextChangedListener(new j(this));
        bM(TbadkApplication.m251getInst().getSkinType());
    }

    public void Ry() {
        com.baidu.adp.lib.util.m.b(this.context, this.bia);
    }

    public void a(k kVar) {
        this.bie = kVar;
    }

    public void bM(int i) {
        aw.b(this.bib, com.baidu.tieba.s.cp_cont_g, 1);
        this.bia.setHintTextColor(aw.getColor(com.baidu.tieba.s.cp_cont_e));
        aw.c(this.bic, u.icon_search_close);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fz(String str) {
        if (this.bie != null) {
            this.bie.gB(str);
        }
    }
}
