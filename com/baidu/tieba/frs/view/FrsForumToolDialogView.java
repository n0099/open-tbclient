package com.baidu.tieba.frs.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import d.b.h0.r.u.c;
/* loaded from: classes4.dex */
public class FrsForumToolDialogView extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public TextView f16386e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f16387f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f16388g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f16389h;

    public FrsForumToolDialogView(Context context) {
        super(context);
        a(context);
    }

    public final void a(Context context) {
        LayoutInflater.from(context).inflate(R.layout.frs_forum_tool_dialog, this);
        this.f16388g = (TbImageView) findViewById(R.id.iv_image);
        this.f16387f = (TextView) findViewById(R.id.tv_content);
        this.f16386e = (TextView) findViewById(R.id.btn_cancle);
        this.f16389h = (TextView) findViewById(R.id.btn_more);
        this.f16386e.setText(R.string.cancel);
        this.f16389h.setText(R.string.know_more);
        this.f16388g.setPlaceHolder(3);
        this.f16388g.setDrawCorner(true);
        this.f16388g.setAutoChangeStyle(true);
        this.f16388g.setConrers(3);
        this.f16388g.setRadiusById(R.string.J_X06);
        c d2 = c.d(this.f16387f);
        d2.q(R.color.CAM_X0107);
        d2.r(R.dimen.M_T_X001);
        d2.u(R.dimen.T_X06);
        c d3 = c.d(this.f16386e);
        d3.q(R.color.CAM_X0105);
        d3.k(R.string.J_X07);
        d3.i(R.dimen.L_X02);
        d3.u(R.dimen.T_X08);
        d3.h(R.color.CAM_X0902);
        d3.f(R.color.CAM_X0201);
        c d4 = c.d(this.f16389h);
        d4.q(R.color.CAM_X0302);
        d4.k(R.string.J_X07);
        d4.u(R.dimen.T_X08);
        d4.i(R.dimen.L_X02);
        d4.e(R.string.A_X07);
        d4.h(R.color.CAM_X0302);
        d4.f(R.color.CAM_X0201);
        c d5 = c.d(this);
        d5.k(R.string.J_X06);
        d5.j(0);
        d5.f(R.color.CAM_X0201);
    }

    public void setCancleButtonListener(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.f16386e.setOnClickListener(onClickListener);
        }
    }

    public void setConfirmButtonListener(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.f16389h.setOnClickListener(onClickListener);
        }
    }

    public void setContent(String str) {
        this.f16387f.setText(str);
    }

    public void setStartLoadUrl(int i, String str) {
        if (i != 1 && i != 2) {
            this.f16388g.W(str, 10, false);
        } else {
            this.f16388g.W(str, 24, false);
        }
    }
}
