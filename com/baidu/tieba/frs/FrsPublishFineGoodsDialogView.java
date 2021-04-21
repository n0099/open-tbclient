package com.baidu.tieba.frs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tieba.R;
import d.b.c.e.p.l;
import d.b.i0.r.w.b.d;
import d.b.j0.q0.h;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class FrsPublishFineGoodsDialogView extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f15749e;

    /* renamed from: f  reason: collision with root package name */
    public Context f15750f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f15751g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f15752h;
    public TextView i;
    public LocalBannerLayout j;
    public d k;

    /* loaded from: classes4.dex */
    public class a implements d {
        public a() {
        }

        @Override // d.b.i0.r.w.b.d
        public void a(int i, d.b.i0.r.w.b.a aVar) {
            FrsPublishFineGoodsDialogView.this.c(i);
        }

        @Override // d.b.i0.r.w.b.d
        public void b(int i, String str) {
        }
    }

    public FrsPublishFineGoodsDialogView(Context context) {
        super(context);
        this.k = new a();
        this.f15750f = context;
        b(context);
    }

    public final void b(Context context) {
        LayoutInflater.from(context).inflate(R.layout.frs_publish_major_fine_goods_dialog, this);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.frs_broadcast_guide_main);
        this.f15749e = linearLayout;
        this.f15751g = (TextView) linearLayout.findViewById(R.id.frs_shop_guide_title);
        this.f15752h = (TextView) this.f15749e.findViewById(R.id.frs_shop_guide_content);
        this.j = (LocalBannerLayout) this.f15749e.findViewById(R.id.banner_layout);
        TextView textView = (TextView) this.f15749e.findViewById(R.id.to_next_tv);
        this.i = textView;
        textView.setText(R.string.forum_broadcast_major_history_known);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new h(String.valueOf(R.drawable.pic_good_guide1)));
        arrayList.add(new h(String.valueOf(R.drawable.pic_good_guide2)));
        arrayList.add(new h(String.valueOf(R.drawable.pic_good_guide3)));
        this.j.setData(arrayList);
        this.j.setOnCoverViewCallback(this.k);
        SkinManager.setViewTextColor(this.f15751g, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f15752h, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.i, R.color.CAM_X0302);
        TBSelector.makeDrawableSelector().setShape(0).defaultColor(R.color.CAM_X0211).blRadius(l.g(this.f15750f, R.dimen.tbds30)).brRadius(l.g(this.f15750f, R.dimen.tbds30)).tlRadius(l.g(this.f15750f, R.dimen.tbds32)).trRadius(l.g(this.f15750f, R.dimen.tbds32)).into(this.f15749e);
    }

    public final void c(int i) {
        if (i == 0 || i == 3) {
            this.f15751g.setText(getResources().getString(R.string.frs_goods_dialog_first_title));
            this.f15752h.setText(getResources().getString(R.string.frs_goods_dialog_first_content));
        } else if (i == 1) {
            this.f15751g.setText(getResources().getString(R.string.frs_goods_dialog_second_title));
            this.f15752h.setText(getResources().getString(R.string.frs_goods_dialog_second_content));
        } else if (i == 2) {
            this.f15751g.setText(getResources().getString(R.string.frs_goods_dialog_third_title));
            this.f15752h.setText(getResources().getString(R.string.frs_goods_dialog_third_content));
        }
    }

    public void setConfirmButtonListener(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.i.setOnClickListener(onClickListener);
        }
    }
}
