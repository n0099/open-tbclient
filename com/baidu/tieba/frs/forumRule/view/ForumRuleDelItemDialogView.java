package com.baidu.tieba.frs.forumRule.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import d.a.m0.r.u.c;
/* loaded from: classes4.dex */
public class ForumRuleDelItemDialogView extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f15382e;

    /* renamed from: f  reason: collision with root package name */
    public Context f15383f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f15384g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f15385h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f15386i;
    public TextView j;

    public ForumRuleDelItemDialogView(Context context) {
        super(context);
        this.f15383f = context;
        a(context);
    }

    public final void a(Context context) {
        LayoutInflater.from(context).inflate(R.layout.forum_rule_del_dialog, this);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.ll_main);
        this.f15382e = linearLayout;
        this.f15384g = (TextView) linearLayout.findViewById(R.id.dialog_title);
        this.f15385h = (TextView) this.f15382e.findViewById(R.id.dialog_content);
        this.f15386i = (TextView) this.f15382e.findViewById(R.id.next_time);
        this.j = (TextView) this.f15382e.findViewById(R.id.del_tv);
        this.f15384g.setText(R.string.forum_rule_item_del_dialog_title);
        this.f15385h.setText(R.string.forum_rule_item_del_dialog_abstract);
        this.f15386i.setText(R.string.next_time);
        this.j.setText(R.string.del_post);
        SkinManager.setBackgroundResource(this.f15382e, R.drawable.bg_frs_private_dialog);
        c d2 = c.d(this.f15384g);
        d2.s(R.color.CAM_X0105);
        d2.x(R.string.F_X02);
        d2.w(R.dimen.T_X06);
        c d3 = c.d(this.f15385h);
        d3.s(R.color.CAM_X0107);
        d3.w(R.dimen.T_X07);
        c d4 = c.d(this.f15386i);
        d4.s(R.color.CAM_X0105);
        d4.m(R.string.J_X07);
        d4.k(R.dimen.L_X02);
        d4.w(R.dimen.T_X08);
        d4.j(R.color.CAM_X0902);
        d4.f(R.color.CAM_X0201);
        c d5 = c.d(this.j);
        d5.s(R.color.CAM_X0302);
        d5.m(R.string.J_X07);
        d5.w(R.dimen.T_X08);
        d5.k(R.dimen.L_X02);
        d5.e(R.string.A_X07);
        d5.j(R.color.CAM_X0302);
        d5.f(R.color.CAM_X0201);
    }

    public void setConfirmButtonListener(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.f15386i.setOnClickListener(onClickListener);
        }
    }

    public void setpostButtonListener(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.j.setOnClickListener(onClickListener);
        }
    }
}
