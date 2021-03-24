package com.baidu.tieba.ala.personcenter.privilege.entereffect.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.ala.utils.AlaStringHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.personcenter.privilege.entereffect.data.AlaEnterEffectData;
import d.b.b.j.e.a;
/* loaded from: classes4.dex */
public class AlaEnterEffectAdapter extends a<AlaEnterEffectData, ViewHolder> {
    public Context m;
    public int n;

    /* loaded from: classes4.dex */
    public static class ViewHolder extends TypeAdapter.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public TbImageView f15083a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f15084b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f15085c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f15086d;

        /* renamed from: e  reason: collision with root package name */
        public ImageView f15087e;

        /* renamed from: f  reason: collision with root package name */
        public ProgressBar f15088f;

        /* renamed from: g  reason: collision with root package name */
        public View f15089g;

        /* renamed from: h  reason: collision with root package name */
        public View f15090h;
        public TextView i;

        public ViewHolder(View view) {
            super(view);
            b();
        }

        public final void b() {
            TbImageView tbImageView = (TbImageView) a().findViewById(R.id.ala_enter_effect_img);
            this.f15083a = tbImageView;
            tbImageView.setAutoChangeStyle(false);
            this.f15084b = (TextView) a().findViewById(R.id.ala_enter_effect_name);
            this.f15085c = (TextView) a().findViewById(R.id.ala_enter_effect_status);
            this.f15086d = (TextView) a().findViewById(R.id.ala_enter_effect_time_limit);
            this.f15087e = (ImageView) a().findViewById(R.id.ala_enter_effect_download_img);
            this.f15088f = (ProgressBar) a().findViewById(R.id.ala_enter_effect_loading);
            this.f15089g = a().findViewById(R.id.ala_header_cover);
            this.f15090h = a().findViewById(R.id.ala_enter_effect_img_layout);
            this.i = (TextView) a().findViewById(R.id.ala_enter_effect_description);
        }
    }

    public AlaEnterEffectAdapter(Context context) {
        super(context, AlaEnterEffectData.TYPE_ENTER_EFFECT_DATA);
        this.m = context;
        this.n = TbadkCoreApplication.getInst().getSkinType();
    }

    public final void h0(ViewHolder viewHolder) {
        if (viewHolder == null) {
            return;
        }
        SkinManager.setBackgroundResource(viewHolder.a(), R.color.CAM_X0201);
        SkinManager.setViewTextColor(viewHolder.f15086d, R.color.CAM_X0109, 1, this.n);
        SkinManager.setViewTextColor(viewHolder.f15084b, R.color.CAM_X0105, 1, this.n);
        if (this.n == 1) {
            viewHolder.f15089g.setVisibility(0);
        } else {
            viewHolder.f15089g.setVisibility(8);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.j.e.a
    /* renamed from: i0 */
    public ViewHolder R(ViewGroup viewGroup) {
        return new ViewHolder(LayoutInflater.from(this.m).inflate(R.layout.ala_enter_effect_item_layout, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.j.e.a
    /* renamed from: j0 */
    public View X(int i, View view, ViewGroup viewGroup, AlaEnterEffectData alaEnterEffectData, ViewHolder viewHolder) {
        viewHolder.f15083a.W(alaEnterEffectData.thumbnail_url, 10, false);
        viewHolder.f15084b.setText(alaEnterEffectData.name);
        if (alaEnterEffectData.isUsing()) {
            SkinManager.setViewTextColor(viewHolder.f15085c, R.color.live_cp_other_b, 1, this.n);
            SkinManager.setBackgroundResource(viewHolder.f15085c, R.drawable.ala_enter_effect_use_bg, this.n);
            viewHolder.f15085c.setText(this.m.getString(R.string.ala_enter_effect_use));
            viewHolder.f15083a.setAlpha(1.0f);
        } else if (alaEnterEffectData.isOwn) {
            SkinManager.setViewTextColor(viewHolder.f15085c, R.color.CAM_X0302, 1, this.n);
            SkinManager.setBackgroundResource(viewHolder.f15085c, R.drawable.ala_enter_effect_own_bg, this.n);
            viewHolder.f15085c.setText(this.m.getString(R.string.ala_enter_effect_own));
            viewHolder.f15083a.setAlpha(1.0f);
        } else {
            SkinManager.setViewTextColor(viewHolder.f15085c, R.color.CAM_X0109, 1, this.n);
            SkinManager.setBackgroundResource(viewHolder.f15085c, R.drawable.ala_enter_effect_not_own_bg, this.n);
            viewHolder.f15085c.setText(this.m.getString(R.string.ala_enter_effect_not_own));
            viewHolder.f15083a.setAlpha(0.7f);
        }
        viewHolder.f15086d.setText(this.m.getResources().getString(R.string.ala_left_time, StringHelper.formatDayTime((alaEnterEffectData.end_time * 1000) - System.currentTimeMillis())));
        int i2 = alaEnterEffectData.downLoadStatus;
        if (i2 == 100) {
            viewHolder.f15087e.setVisibility(0);
            viewHolder.f15088f.setVisibility(8);
        } else if (i2 == 102) {
            viewHolder.f15087e.setVisibility(8);
            viewHolder.f15088f.setVisibility(0);
        } else {
            viewHolder.f15087e.setVisibility(8);
            viewHolder.f15088f.setVisibility(8);
        }
        viewHolder.f15090h.setBackgroundColor(Color.parseColor(alaEnterEffectData.color));
        SkinManager.setViewTextColor(viewHolder.i, R.color.CAM_X0109, 1, this.n);
        if (2 == alaEnterEffectData.categoryType) {
            SkinManager.setViewTextColor(viewHolder.i, R.color.CAM_X0305, 1, this.n);
            viewHolder.i.setText(this.m.getString(R.string.ala_enter_effect_tdou_des, AlaStringHelper.formatLowercasekDou(alaEnterEffectData.price), alaEnterEffectData.time));
            Drawable drawable = SkinManager.getDrawable(R.drawable.icon_huobi_tdou);
            int dimensionPixelSize = this.m.getResources().getDimensionPixelSize(R.dimen.ds24);
            drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            viewHolder.i.setCompoundDrawablePadding(this.m.getResources().getDimensionPixelSize(R.dimen.ds4));
            viewHolder.i.setCompoundDrawables(drawable, null, null, null);
        } else {
            viewHolder.i.setText(alaEnterEffectData.obtain_way);
            viewHolder.i.setCompoundDrawables(null, null, null, null);
        }
        h0(viewHolder);
        return viewHolder.a();
    }
}
