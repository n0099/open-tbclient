package com.baidu.tieba.frs.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import d.a.m0.r.u.c;
/* loaded from: classes4.dex */
public class FrsForumToolDialogView extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public TextView f15839e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f15840f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f15841g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f15842h;

    public FrsForumToolDialogView(Context context) {
        super(context);
        a(context);
    }

    public final void a(Context context) {
        LayoutInflater.from(context).inflate(R.layout.frs_forum_tool_dialog, this);
        this.f15841g = (TbImageView) findViewById(R.id.iv_image);
        this.f15840f = (TextView) findViewById(R.id.tv_content);
        this.f15839e = (TextView) findViewById(R.id.btn_cancle);
        this.f15842h = (TextView) findViewById(R.id.btn_more);
        this.f15839e.setText(R.string.cancel);
        this.f15842h.setText(R.string.know_more);
        this.f15841g.setPlaceHolder(3);
        this.f15841g.setDrawCorner(true);
        this.f15841g.setAutoChangeStyle(true);
        this.f15841g.setConrers(3);
        this.f15841g.setRadiusById(R.string.J_X06);
        c d2 = c.d(this.f15840f);
        d2.s(R.color.CAM_X0107);
        d2.t(R.dimen.M_T_X001);
        d2.w(R.dimen.T_X06);
        c d3 = c.d(this.f15839e);
        d3.s(R.color.CAM_X0105);
        d3.m(R.string.J_X07);
        d3.k(R.dimen.L_X02);
        d3.w(R.dimen.T_X08);
        d3.j(R.color.CAM_X0902);
        d3.f(R.color.CAM_X0201);
        c d4 = c.d(this.f15842h);
        d4.s(R.color.CAM_X0302);
        d4.m(R.string.J_X07);
        d4.w(R.dimen.T_X08);
        d4.k(R.dimen.L_X02);
        d4.e(R.string.A_X07);
        d4.j(R.color.CAM_X0302);
        d4.f(R.color.CAM_X0201);
        c d5 = c.d(this);
        d5.m(R.string.J_X06);
        d5.l(0);
        d5.f(R.color.CAM_X0201);
    }

    public void setCancleButtonListener(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.f15839e.setOnClickListener(onClickListener);
        }
    }

    public void setConfirmButtonListener(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.f15842h.setOnClickListener(onClickListener);
        }
    }

    public void setContent(String str) {
        this.f15840f.setText(str);
    }

    public void setStartLoadUrl(int i2, String str) {
        if (i2 != 1 && i2 != 2) {
            this.f15841g.V(str, 10, false);
        } else {
            this.f15841g.V(str, 24, false);
        }
    }
}
