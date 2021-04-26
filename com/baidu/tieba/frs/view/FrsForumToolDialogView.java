package com.baidu.tieba.frs.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import d.a.i0.r.u.c;
/* loaded from: classes4.dex */
public class FrsForumToolDialogView extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public TextView f16621e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f16622f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f16623g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f16624h;

    public FrsForumToolDialogView(Context context) {
        super(context);
        a(context);
    }

    public final void a(Context context) {
        LayoutInflater.from(context).inflate(R.layout.frs_forum_tool_dialog, this);
        this.f16623g = (TbImageView) findViewById(R.id.iv_image);
        this.f16622f = (TextView) findViewById(R.id.tv_content);
        this.f16621e = (TextView) findViewById(R.id.btn_cancle);
        this.f16624h = (TextView) findViewById(R.id.btn_more);
        this.f16621e.setText(R.string.cancel);
        this.f16624h.setText(R.string.know_more);
        this.f16623g.setPlaceHolder(3);
        this.f16623g.setDrawCorner(true);
        this.f16623g.setAutoChangeStyle(true);
        this.f16623g.setConrers(3);
        this.f16623g.setRadiusById(R.string.J_X06);
        c d2 = c.d(this.f16622f);
        d2.q(R.color.CAM_X0107);
        d2.r(R.dimen.M_T_X001);
        d2.u(R.dimen.T_X06);
        c d3 = c.d(this.f16621e);
        d3.q(R.color.CAM_X0105);
        d3.k(R.string.J_X07);
        d3.i(R.dimen.L_X02);
        d3.u(R.dimen.T_X08);
        d3.h(R.color.CAM_X0902);
        d3.f(R.color.CAM_X0201);
        c d4 = c.d(this.f16624h);
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
            this.f16621e.setOnClickListener(onClickListener);
        }
    }

    public void setConfirmButtonListener(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.f16624h.setOnClickListener(onClickListener);
        }
    }

    public void setContent(String str) {
        this.f16622f.setText(str);
    }

    public void setStartLoadUrl(int i2, String str) {
        if (i2 != 1 && i2 != 2) {
            this.f16623g.V(str, 10, false);
        } else {
            this.f16623g.V(str, 24, false);
        }
    }
}
