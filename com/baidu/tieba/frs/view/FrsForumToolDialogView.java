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
    public TextView f16725e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f16726f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f16727g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f16728h;

    public FrsForumToolDialogView(Context context) {
        super(context);
        a(context);
    }

    public final void a(Context context) {
        LayoutInflater.from(context).inflate(R.layout.frs_forum_tool_dialog, this);
        this.f16727g = (TbImageView) findViewById(R.id.iv_image);
        this.f16726f = (TextView) findViewById(R.id.tv_content);
        this.f16725e = (TextView) findViewById(R.id.btn_cancle);
        this.f16728h = (TextView) findViewById(R.id.btn_more);
        this.f16725e.setText(R.string.cancel);
        this.f16728h.setText(R.string.know_more);
        this.f16727g.setPlaceHolder(3);
        this.f16727g.setDrawCorner(true);
        this.f16727g.setAutoChangeStyle(true);
        this.f16727g.setConrers(3);
        this.f16727g.setRadiusById(R.string.J_X06);
        c a2 = c.a(this.f16726f);
        a2.n(R.color.CAM_X0107);
        a2.o(R.dimen.M_T_X001);
        a2.r(R.dimen.T_X06);
        c a3 = c.a(this.f16725e);
        a3.n(R.color.CAM_X0105);
        a3.h(R.string.J_X07);
        a3.f(R.dimen.L_X02);
        a3.r(R.dimen.T_X08);
        a3.e(R.color.CAM_X0902);
        a3.c(R.color.CAM_X0201);
        c a4 = c.a(this.f16728h);
        a4.n(R.color.CAM_X0302);
        a4.h(R.string.J_X07);
        a4.r(R.dimen.T_X08);
        a4.f(R.dimen.L_X02);
        a4.b(R.string.A_X07);
        a4.e(R.color.CAM_X0302);
        a4.c(R.color.CAM_X0201);
        c a5 = c.a(this);
        a5.h(R.string.J_X06);
        a5.g(0);
        a5.c(R.color.CAM_X0201);
    }

    public void setCancleButtonListener(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.f16725e.setOnClickListener(onClickListener);
        }
    }

    public void setConfirmButtonListener(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.f16728h.setOnClickListener(onClickListener);
        }
    }

    public void setContent(String str) {
        this.f16726f.setText(str);
    }

    public void setStartLoadUrl(int i, String str) {
        if (i != 1 && i != 2) {
            this.f16727g.W(str, 10, false);
        } else {
            this.f16727g.W(str, 24, false);
        }
    }
}
