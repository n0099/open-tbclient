package com.baidu.tieba.frs.forumRule.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import d.a.i0.r.u.c;
/* loaded from: classes4.dex */
public class ForumRuleDelItemDialogView extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f16164e;

    /* renamed from: f  reason: collision with root package name */
    public Context f16165f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f16166g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f16167h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f16168i;
    public TextView j;

    public ForumRuleDelItemDialogView(Context context) {
        super(context);
        this.f16165f = context;
        a(context);
    }

    public final void a(Context context) {
        LayoutInflater.from(context).inflate(R.layout.forum_rule_del_dialog, this);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.ll_main);
        this.f16164e = linearLayout;
        this.f16166g = (TextView) linearLayout.findViewById(R.id.dialog_title);
        this.f16167h = (TextView) this.f16164e.findViewById(R.id.dialog_content);
        this.f16168i = (TextView) this.f16164e.findViewById(R.id.next_time);
        this.j = (TextView) this.f16164e.findViewById(R.id.del_tv);
        this.f16166g.setText(R.string.forum_rule_item_del_dialog_title);
        this.f16167h.setText(R.string.forum_rule_item_del_dialog_abstract);
        this.f16168i.setText(R.string.next_time);
        this.j.setText(R.string.del_post);
        SkinManager.setBackgroundResource(this.f16164e, R.drawable.bg_frs_private_dialog);
        c d2 = c.d(this.f16166g);
        d2.q(R.color.CAM_X0105);
        d2.v(R.string.F_X02);
        d2.u(R.dimen.T_X06);
        c d3 = c.d(this.f16167h);
        d3.q(R.color.CAM_X0107);
        d3.u(R.dimen.T_X07);
        c d4 = c.d(this.f16168i);
        d4.q(R.color.CAM_X0105);
        d4.k(R.string.J_X07);
        d4.i(R.dimen.L_X02);
        d4.u(R.dimen.T_X08);
        d4.h(R.color.CAM_X0902);
        d4.f(R.color.CAM_X0201);
        c d5 = c.d(this.j);
        d5.q(R.color.CAM_X0302);
        d5.k(R.string.J_X07);
        d5.u(R.dimen.T_X08);
        d5.i(R.dimen.L_X02);
        d5.e(R.string.A_X07);
        d5.h(R.color.CAM_X0302);
        d5.f(R.color.CAM_X0201);
    }

    public void setConfirmButtonListener(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.f16168i.setOnClickListener(onClickListener);
        }
    }

    public void setpostButtonListener(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.j.setOnClickListener(onClickListener);
        }
    }
}
