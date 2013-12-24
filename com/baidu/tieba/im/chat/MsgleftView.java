package com.baidu.tieba.im.chat;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tieba.data.UserData;
import com.baidu.tieba.view.HeadImageView;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class MsgleftView extends at {
    private static final String o = MsgleftView.class.getName();
    View.OnLongClickListener n;
    private HeadImageView p;
    private TextView q;
    private ImageView r;
    private ViewGroup s;
    private final TouchType t;
    private int u;

    public MsgleftView(Context context, int i) {
        super(context, R.layout.msg_msgleft_view);
        this.t = new TouchType();
        this.u = 0;
        this.n = new ba(this);
        e();
        this.q = (TextView) a(R.id.tex_msgitem_name);
        this.r = (ImageView) a(R.id.iv_sex);
        this.s = (ViewGroup) a(R.id.box_msgitem_bubble);
        this.p = (HeadImageView) a(R.id.img_msgitem_photo);
        this.p.setAutoChangeStyle(false);
        this.p.setOnClickListener(new ay(this));
        this.p.setLongClickable(true);
        this.p.setOnLongClickListener(this.n);
        this.p.setOnTouchListener(new az(this));
        d(i);
    }

    @Override // com.baidu.tieba.im.chat.at
    public void b(View view, com.baidu.tieba.im.message.b bVar) {
        String str = null;
        super.b(view, bVar);
        if (bVar == null) {
            this.q.setText((CharSequence) null);
            this.j.setVisibility(0);
            this.j.setText(null);
            c(8);
            this.k.setTag(null);
            this.l.setVisibility(8);
            this.l.setTag(null);
            this.m.setVisibility(8);
            this.m.setTag(null);
            return;
        }
        a(bVar);
        b(bVar);
        this.q.setText("");
        try {
            if (bVar.f() != null) {
                this.q.setText(bVar.f().getName());
                this.p.setUserId(bVar.f().getId());
                str = bVar.f().getPortrait();
            }
            com.baidu.adp.widget.ImageView.e c = this.e.c(str);
            if (c != null) {
                c.a(this.p);
            } else {
                this.e.b(str, new bb(this));
            }
            this.j.setVisibility(8);
            c(8);
            this.l.setVisibility(8);
            this.m.setVisibility(8);
            switch (bVar.h()) {
                case 1:
                    a(bVar, o);
                    return;
                case 2:
                    a(view, bVar, o);
                    return;
                case 3:
                    b(bVar, o);
                    return;
                case 4:
                default:
                    return;
                case 5:
                    b(view, bVar, o);
                    return;
            }
        } catch (Exception e) {
            com.baidu.adp.lib.h.e.b("MsgleftView", "setData", "error = " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void b(com.baidu.tieba.im.message.b bVar) {
        if (bVar != null) {
            if (this.u != 0) {
                this.r.setVisibility(8);
                return;
            }
            this.r.setVisibility(0);
            UserData f = bVar.f();
            if (f == null) {
                this.r.setVisibility(8);
                return;
            }
            int sex = f.getSex();
            if (sex == 1) {
                this.r.setImageResource(R.drawable.icon_pop_qz_boy);
                this.r.setVisibility(0);
            } else if (sex == 2) {
                this.r.setImageResource(R.drawable.icon_pop_qz_girl);
                this.r.setVisibility(0);
            } else {
                this.r.setVisibility(8);
            }
        }
    }

    public void d(int i) {
        this.u = i;
        if (this.u != 0) {
            this.r.setVisibility(8);
            this.q.setVisibility(8);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.s.getLayoutParams();
            marginLayoutParams.topMargin = 0;
            this.s.setLayoutParams(marginLayoutParams);
            return;
        }
        this.q.setVisibility(0);
        this.r.setVisibility(0);
    }
}
