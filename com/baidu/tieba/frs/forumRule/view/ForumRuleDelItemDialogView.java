package com.baidu.tieba.frs.forumRule.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import d.b.h0.r.u.c;
/* loaded from: classes4.dex */
public class ForumRuleDelItemDialogView extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f16299e;

    /* renamed from: f  reason: collision with root package name */
    public Context f16300f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f16301g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f16302h;
    public TextView i;
    public TextView j;

    public ForumRuleDelItemDialogView(Context context) {
        super(context);
        this.f16300f = context;
        a(context);
    }

    public final void a(Context context) {
        LayoutInflater.from(context).inflate(R.layout.forum_rule_del_dialog, this);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.ll_main);
        this.f16299e = linearLayout;
        this.f16301g = (TextView) linearLayout.findViewById(R.id.dialog_title);
        this.f16302h = (TextView) this.f16299e.findViewById(R.id.dialog_content);
        this.i = (TextView) this.f16299e.findViewById(R.id.next_time);
        this.j = (TextView) this.f16299e.findViewById(R.id.del_tv);
        this.f16301g.setText(R.string.forum_rule_item_del_dialog_title);
        this.f16302h.setText(R.string.forum_rule_item_del_dialog_abstract);
        this.i.setText(R.string.next_time);
        this.j.setText(R.string.del_post);
        SkinManager.setBackgroundResource(this.f16299e, R.drawable.bg_frs_private_dialog);
        c a2 = c.a(this.f16301g);
        a2.n(R.color.CAM_X0105);
        a2.s(R.string.F_X02);
        a2.r(R.dimen.T_X06);
        c a3 = c.a(this.f16302h);
        a3.n(R.color.CAM_X0107);
        a3.r(R.dimen.T_X07);
        c a4 = c.a(this.i);
        a4.n(R.color.CAM_X0105);
        a4.h(R.string.J_X07);
        a4.f(R.dimen.L_X02);
        a4.r(R.dimen.T_X08);
        a4.e(R.color.CAM_X0902);
        a4.c(R.color.CAM_X0201);
        c a5 = c.a(this.j);
        a5.n(R.color.CAM_X0302);
        a5.h(R.string.J_X07);
        a5.r(R.dimen.T_X08);
        a5.f(R.dimen.L_X02);
        a5.b(R.string.A_X07);
        a5.e(R.color.CAM_X0302);
        a5.c(R.color.CAM_X0201);
    }

    public void setConfirmButtonListener(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.i.setOnClickListener(onClickListener);
        }
    }

    public void setpostButtonListener(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.j.setOnClickListener(onClickListener);
        }
    }
}
