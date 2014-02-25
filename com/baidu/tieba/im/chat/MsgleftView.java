package com.baidu.tieba.im.chat;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.data.IconData;
import com.baidu.tieba.data.UserData;
import com.baidu.tieba.view.HeadImageShaderView;
import com.baidu.tieba.view.UserIconBox;
import com.slidingmenu.lib.R;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class MsgleftView extends bs {
    private static final String p = MsgleftView.class.getName();
    View.OnLongClickListener o;
    private HeadImageShaderView q;
    private TextView r;
    private ImageView s;
    private ViewGroup t;
    private UserIconBox u;
    private final TouchType v;
    private int w;

    public MsgleftView(Context context, int i) {
        super(context, R.layout.msg_msgleft_view);
        this.v = new TouchType();
        this.w = 0;
        this.o = new bz(this);
        e();
        this.r = (TextView) a(R.id.tex_msgitem_name);
        this.s = (ImageView) a(R.id.iv_sex);
        this.t = (ViewGroup) a(R.id.box_msgitem_bubble);
        this.q = (HeadImageShaderView) a(R.id.img_msgitem_photo);
        this.q.setAutoChangeStyle(false);
        this.u = (UserIconBox) a(R.id.user_tshow_icon_box);
        this.q.setOnClickListener(new ca(this));
        this.q.setLongClickable(true);
        this.q.setOnLongClickListener(this.o);
        this.q.setOnTouchListener(new cb(this));
        d(i);
    }

    @Override // com.baidu.tieba.im.chat.bs
    public void b(View view, com.baidu.tieba.im.message.b bVar) {
        String str = null;
        super.b(view, bVar);
        LinkedList<IconData> tShowInfo = bVar != null ? bVar.g().getTShowInfo() : null;
        if (this.u != null && (this.w == 0 || this.w == 2)) {
            this.u.setVisibility(0);
            this.u.a(tShowInfo, 2, this.b.getResources().getDimensionPixelSize(R.dimen.small_icon_width), this.b.getResources().getDimensionPixelSize(R.dimen.small_icon_height), this.b.getResources().getDimensionPixelSize(R.dimen.small_icon_margin), true);
        }
        if (bVar == null) {
            this.r.setText((CharSequence) null);
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
        b(bVar);
        a(bVar);
        this.r.setText("");
        try {
            if (bVar.g() != null) {
                this.r.setText(bVar.g().getUserName());
                this.q.setUserId(bVar.g().getUserId());
                str = bVar.g().getPortrait();
            }
            this.e.c(str, new cc(this));
            this.j.setVisibility(8);
            c(8);
            this.l.setVisibility(8);
            this.m.setVisibility(8);
            this.n.setVisibility(8);
            switch (bVar.i()) {
                case 1:
                    a(bVar, p);
                    return;
                case 2:
                    a(view, bVar, p);
                    return;
                case 3:
                    b(bVar, p);
                    return;
                case 4:
                    a(bVar, false);
                    return;
                case 5:
                    b(view, bVar, p);
                    return;
                default:
                    return;
            }
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b("MsgleftView", "setData", "error = " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void a(com.baidu.tieba.im.message.b bVar) {
        if (bVar != null) {
            if (this.w == 1) {
                this.s.setVisibility(8);
                return;
            }
            this.s.setVisibility(0);
            UserData g = bVar.g();
            if (g == null) {
                this.s.setVisibility(8);
                return;
            }
            int sex = g.getSex();
            if (sex == 1) {
                this.s.setImageResource(R.drawable.icon_pop_qz_boy);
                this.s.setVisibility(0);
            } else if (sex == 2) {
                this.s.setImageResource(R.drawable.icon_pop_qz_girl);
                this.s.setVisibility(0);
            } else {
                this.s.setVisibility(8);
            }
        }
    }

    public void d(int i) {
        this.w = i;
        if (this.w == 1) {
            this.s.setVisibility(8);
            this.r.setVisibility(8);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.t.getLayoutParams();
            marginLayoutParams.topMargin = 0;
            this.t.setLayoutParams(marginLayoutParams);
            this.u.setVisibility(8);
            return;
        }
        this.r.setVisibility(0);
        this.s.setVisibility(0);
        this.u.setVisibility(0);
    }
}
