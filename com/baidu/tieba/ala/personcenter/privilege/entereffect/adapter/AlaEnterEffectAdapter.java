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
import d.b.c.j.e.a;
/* loaded from: classes4.dex */
public class AlaEnterEffectAdapter extends a<AlaEnterEffectData, ViewHolder> {
    public Context m;
    public int n;

    /* loaded from: classes4.dex */
    public static class ViewHolder extends TypeAdapter.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public TbImageView f14747a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f14748b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f14749c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f14750d;

        /* renamed from: e  reason: collision with root package name */
        public ImageView f14751e;

        /* renamed from: f  reason: collision with root package name */
        public ProgressBar f14752f;

        /* renamed from: g  reason: collision with root package name */
        public View f14753g;

        /* renamed from: h  reason: collision with root package name */
        public View f14754h;
        public TextView i;

        public ViewHolder(View view) {
            super(view);
            b();
        }

        public final void b() {
            TbImageView tbImageView = (TbImageView) a().findViewById(R.id.ala_enter_effect_img);
            this.f14747a = tbImageView;
            tbImageView.setAutoChangeStyle(false);
            this.f14748b = (TextView) a().findViewById(R.id.ala_enter_effect_name);
            this.f14749c = (TextView) a().findViewById(R.id.ala_enter_effect_status);
            this.f14750d = (TextView) a().findViewById(R.id.ala_enter_effect_time_limit);
            this.f14751e = (ImageView) a().findViewById(R.id.ala_enter_effect_download_img);
            this.f14752f = (ProgressBar) a().findViewById(R.id.ala_enter_effect_loading);
            this.f14753g = a().findViewById(R.id.ala_header_cover);
            this.f14754h = a().findViewById(R.id.ala_enter_effect_img_layout);
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
        SkinManager.setViewTextColor(viewHolder.f14750d, R.color.CAM_X0109, 1, this.n);
        SkinManager.setViewTextColor(viewHolder.f14748b, R.color.CAM_X0105, 1, this.n);
        if (this.n == 1) {
            viewHolder.f14753g.setVisibility(0);
        } else {
            viewHolder.f14753g.setVisibility(8);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: i0 */
    public ViewHolder R(ViewGroup viewGroup) {
        return new ViewHolder(LayoutInflater.from(this.m).inflate(R.layout.ala_enter_effect_item_layout, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: j0 */
    public View X(int i, View view, ViewGroup viewGroup, AlaEnterEffectData alaEnterEffectData, ViewHolder viewHolder) {
        viewHolder.f14747a.W(alaEnterEffectData.thumbnail_url, 10, false);
        viewHolder.f14748b.setText(alaEnterEffectData.name);
        if (alaEnterEffectData.isUsing()) {
            SkinManager.setViewTextColor(viewHolder.f14749c, R.color.live_cp_other_b, 1, this.n);
            SkinManager.setBackgroundResource(viewHolder.f14749c, R.drawable.ala_enter_effect_use_bg, this.n);
            viewHolder.f14749c.setText(this.m.getString(R.string.ala_enter_effect_use));
            viewHolder.f14747a.setAlpha(1.0f);
        } else if (alaEnterEffectData.isOwn) {
            SkinManager.setViewTextColor(viewHolder.f14749c, R.color.CAM_X0302, 1, this.n);
            SkinManager.setBackgroundResource(viewHolder.f14749c, R.drawable.ala_enter_effect_own_bg, this.n);
            viewHolder.f14749c.setText(this.m.getString(R.string.ala_enter_effect_own));
            viewHolder.f14747a.setAlpha(1.0f);
        } else {
            SkinManager.setViewTextColor(viewHolder.f14749c, R.color.CAM_X0109, 1, this.n);
            SkinManager.setBackgroundResource(viewHolder.f14749c, R.drawable.ala_enter_effect_not_own_bg, this.n);
            viewHolder.f14749c.setText(this.m.getString(R.string.ala_enter_effect_not_own));
            viewHolder.f14747a.setAlpha(0.7f);
        }
        viewHolder.f14750d.setText(this.m.getResources().getString(R.string.ala_left_time, StringHelper.formatDayTime((alaEnterEffectData.end_time * 1000) - System.currentTimeMillis())));
        int i2 = alaEnterEffectData.downLoadStatus;
        if (i2 == 100) {
            viewHolder.f14751e.setVisibility(0);
            viewHolder.f14752f.setVisibility(8);
        } else if (i2 == 102) {
            viewHolder.f14751e.setVisibility(8);
            viewHolder.f14752f.setVisibility(0);
        } else {
            viewHolder.f14751e.setVisibility(8);
            viewHolder.f14752f.setVisibility(8);
        }
        viewHolder.f14754h.setBackgroundColor(Color.parseColor(alaEnterEffectData.color));
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
