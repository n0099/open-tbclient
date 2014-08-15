package com.baidu.tieba.im.searchfriend;

import android.content.Context;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class h {
    private EditText a;
    private TextView b;
    private ImageView c;
    private k d;
    private Context e;
    private View.OnClickListener f = new i(this);

    public void a(boolean z) {
        this.b.setClickable(z);
    }

    public void a(String str) {
        this.a.setText(str);
    }

    public h(Context context, View view) {
        this.e = context;
        this.a = (EditText) view.findViewById(u.new_search_friend_input);
        this.b = (TextView) view.findViewById(u.new_search_friend_search);
        this.c = (ImageView) view.findViewById(u.new_search_friend_del);
        this.b.setOnClickListener(this.f);
        this.c.setOnClickListener(this.f);
        this.a.addTextChangedListener(new j(this));
        a(TbadkApplication.m252getInst().getSkinType());
    }

    public void a() {
        com.baidu.adp.lib.util.j.a(this.e, this.a);
    }

    public void a(k kVar) {
        this.d = kVar;
    }

    public void a(int i) {
        if (i == 1) {
            this.b.setTextColor(this.e.getResources().getColor(com.baidu.tieba.r.cp_cont_g_1));
            this.a.setHintTextColor(this.e.getResources().getColor(com.baidu.tieba.r.cp_cont_e_1));
            this.c.setImageResource(com.baidu.tieba.t.icon_search_close_1);
            return;
        }
        this.b.setTextColor(this.e.getResources().getColor(com.baidu.tieba.r.cp_cont_g));
        this.a.setHintTextColor(this.e.getResources().getColor(com.baidu.tieba.r.cp_cont_e));
        this.c.setImageResource(com.baidu.tieba.t.icon_search_close);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        if (this.d != null) {
            this.d.a(str);
        }
    }
}
