package com.baidu.tieba.im.chat;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.data.IconData;
import com.baidu.tieba.im.view.HeadImageShaderView;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class MsgleftView extends ch {
    private static final String q = MsgleftView.class.getName();
    View.OnLongClickListener p;
    private HeadImageShaderView r;
    private TextView s;
    private ImageView t;
    private ViewGroup u;
    private UserIconBox v;
    private final TouchType w;

    public MsgleftView(Context context) {
        super(context, com.baidu.tieba.im.i.msg_msgleft_view);
        this.w = new TouchType();
        this.p = new co(this);
        d();
        this.s = (TextView) a(com.baidu.tieba.im.h.tex_msgitem_name);
        this.t = (ImageView) a(com.baidu.tieba.im.h.iv_sex);
        this.u = (ViewGroup) a(com.baidu.tieba.im.h.box_msgitem_bubble);
        this.r = (HeadImageShaderView) a(com.baidu.tieba.im.h.img_msgitem_photo);
        this.r.setAutoChangeStyle(false);
        this.v = (UserIconBox) a(com.baidu.tieba.im.h.user_tshow_icon_box);
        this.r.setOnClickListener(new cp(this));
        this.r.setLongClickable(true);
        this.r.setOnLongClickListener(this.p);
        this.r.setOnTouchListener(new cq(this));
    }

    @Override // com.baidu.tieba.im.chat.ch
    public final void a(View view, com.baidu.tieba.im.message.a.a aVar) {
        String str = null;
        super.a(view, aVar);
        LinkedList<IconData> tShowInfo = aVar != null ? aVar.r().getTShowInfo() : null;
        if (this.o) {
            this.s.setVisibility(0);
            this.t.setVisibility(0);
            this.v.setVisibility(0);
        } else {
            this.t.setVisibility(8);
            this.s.setVisibility(8);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.u.getLayoutParams();
            marginLayoutParams.topMargin = 0;
            this.u.setLayoutParams(marginLayoutParams);
            this.v.setVisibility(8);
        }
        if (this.v != null && this.o) {
            this.v.setVisibility(0);
            this.v.a(tShowInfo, 2, this.b.getResources().getDimensionPixelSize(com.baidu.tieba.im.f.small_icon_width), this.b.getResources().getDimensionPixelSize(com.baidu.tieba.im.f.small_icon_height), this.b.getResources().getDimensionPixelSize(com.baidu.tieba.im.f.small_icon_margin), true);
        }
        if (aVar == null) {
            this.s.setText((CharSequence) null);
            this.j.setVisibility(0);
            this.j.setText(null);
            c(8);
            this.k.setTag(null);
            this.l.setVisibility(8);
            this.l.setTag(null);
            this.n.setVisibility(8);
            this.n.setTag(null);
            return;
        }
        c(aVar);
        if (aVar != null) {
            if (this.o) {
                this.t.setVisibility(0);
                UserData r = aVar.r();
                if (r != null) {
                    int sex = r.getSex();
                    if (sex == 1) {
                        this.t.setImageResource(com.baidu.tieba.im.g.icon_pop_qz_boy);
                        this.t.setVisibility(0);
                    } else if (sex == 2) {
                        this.t.setImageResource(com.baidu.tieba.im.g.icon_pop_qz_girl);
                        this.t.setVisibility(0);
                    }
                }
            }
            this.t.setVisibility(8);
        }
        this.s.setText("");
        try {
            if (aVar.r() != null) {
                this.s.setText(aVar.r().getUserName());
                this.r.setUserId(aVar.r().getUserId());
                str = aVar.r().getPortrait();
            }
            if (aVar.r().getUserType() == 1) {
                this.e.b(str, new cr(this));
            } else {
                this.e.c(str, new cs(this));
            }
            this.j.setVisibility(8);
            c(8);
            this.l.setVisibility(8);
            this.m.setVisibility(8);
            this.n.setVisibility(8);
            switch (aVar.t()) {
                case 1:
                    a(aVar, q);
                    return;
                case 2:
                    a(view, aVar, q);
                    return;
                case 3:
                    b(aVar, q);
                    return;
                case 4:
                    a(aVar, false);
                    return;
                case 5:
                    b(view, aVar, q);
                    return;
                default:
                    return;
            }
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b("MsgleftView", "setData", "error = " + e.getMessage());
            e.printStackTrace();
        }
    }
}
