package com.baidu.tieba.frs.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
/* loaded from: classes4.dex */
public class FrsBroadcastCopyGuideDialogView extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f16616e;

    /* renamed from: f  reason: collision with root package name */
    public Context f16617f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f16618g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f16619h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f16620i;
    public TextView j;

    public FrsBroadcastCopyGuideDialogView(Context context) {
        super(context);
        this.f16617f = context;
        a(context);
    }

    public final void a(Context context) {
        LayoutInflater.from(context).inflate(R.layout.frs_broadcast_major_copy_guide_dialog, this);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.frs_broadcast_guide_main);
        this.f16616e = linearLayout;
        this.f16618g = (TextView) linearLayout.findViewById(R.id.frs_broadcast_guide_title);
        this.f16619h = (TextView) this.f16616e.findViewById(R.id.frs_broadcast_guide_content);
        this.f16620i = (ImageView) this.f16616e.findViewById(R.id.guide_iv);
        this.j = (TextView) this.f16616e.findViewById(R.id.to_next_tv);
        this.f16618g.setText(R.string.forum_broadcast_copy_guide_title);
        this.f16619h.setText(R.string.forum_broadcast_copy_guide_hint);
        this.j.setText(R.string.comment_tab_dialog_botton_text);
        SkinManager.setViewTextColor(this.f16618g, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f16619h, R.color.CAM_X0107);
        SkinManager.setViewTextColor(this.j, R.color.CAM_X0302);
        SkinManager.setImageResource(this.f16620i, R.drawable.pic_frs_guide_copylink);
        TBSelector.makeDrawableSelector().setShape(0).defaultColor(R.color.CAM_X0211).blRadius(l.g(this.f16617f, R.dimen.tbds30)).brRadius(l.g(this.f16617f, R.dimen.tbds30)).tlRadius(l.g(this.f16617f, R.dimen.tbds32)).trRadius(l.g(this.f16617f, R.dimen.tbds32)).into(this.f16616e);
    }

    public void setConfirmButtonListener(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.j.setOnClickListener(onClickListener);
        }
    }
}
