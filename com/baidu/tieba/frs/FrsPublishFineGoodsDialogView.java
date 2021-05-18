package com.baidu.tieba.frs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
import d.a.j0.r.w.b.d;
import d.a.k0.q0.h;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class FrsPublishFineGoodsDialogView extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f15234e;

    /* renamed from: f  reason: collision with root package name */
    public Context f15235f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f15236g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f15237h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f15238i;
    public LocalBannerLayout j;
    public d k;

    /* loaded from: classes4.dex */
    public class a implements d {
        public a() {
        }

        @Override // d.a.j0.r.w.b.d
        public void a(int i2, d.a.j0.r.w.b.a aVar) {
            FrsPublishFineGoodsDialogView.this.c(i2);
        }

        @Override // d.a.j0.r.w.b.d
        public void b(int i2, String str) {
        }
    }

    public FrsPublishFineGoodsDialogView(Context context) {
        super(context);
        this.k = new a();
        this.f15235f = context;
        b(context);
    }

    public final void b(Context context) {
        LayoutInflater.from(context).inflate(R.layout.frs_publish_major_fine_goods_dialog, this);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.frs_broadcast_guide_main);
        this.f15234e = linearLayout;
        this.f15236g = (TextView) linearLayout.findViewById(R.id.frs_shop_guide_title);
        this.f15237h = (TextView) this.f15234e.findViewById(R.id.frs_shop_guide_content);
        this.j = (LocalBannerLayout) this.f15234e.findViewById(R.id.banner_layout);
        TextView textView = (TextView) this.f15234e.findViewById(R.id.to_next_tv);
        this.f15238i = textView;
        textView.setText(R.string.forum_broadcast_major_history_known);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new h(String.valueOf(R.drawable.pic_good_guide1)));
        arrayList.add(new h(String.valueOf(R.drawable.pic_good_guide2)));
        arrayList.add(new h(String.valueOf(R.drawable.pic_good_guide3)));
        this.j.setData(arrayList);
        this.j.setOnCoverViewCallback(this.k);
        SkinManager.setViewTextColor(this.f15236g, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f15237h, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.f15238i, R.color.CAM_X0302);
        TBSelector.makeDrawableSelector().setShape(0).defaultColor(R.color.CAM_X0211).blRadius(l.g(this.f15235f, R.dimen.tbds30)).brRadius(l.g(this.f15235f, R.dimen.tbds30)).tlRadius(l.g(this.f15235f, R.dimen.tbds32)).trRadius(l.g(this.f15235f, R.dimen.tbds32)).into(this.f15234e);
    }

    public final void c(int i2) {
        if (i2 == 0 || i2 == 3) {
            this.f15236g.setText(getResources().getString(R.string.frs_goods_dialog_first_title));
            this.f15237h.setText(getResources().getString(R.string.frs_goods_dialog_first_content));
        } else if (i2 == 1) {
            this.f15236g.setText(getResources().getString(R.string.frs_goods_dialog_second_title));
            this.f15237h.setText(getResources().getString(R.string.frs_goods_dialog_second_content));
        } else if (i2 == 2) {
            this.f15236g.setText(getResources().getString(R.string.frs_goods_dialog_third_title));
            this.f15237h.setText(getResources().getString(R.string.frs_goods_dialog_third_content));
        }
    }

    public void setConfirmButtonListener(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.f15238i.setOnClickListener(onClickListener);
        }
    }
}
