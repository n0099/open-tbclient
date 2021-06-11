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
import com.baidu.tieba.wallet.CurrencySwitchUtil;
import d.a.c.k.e.a;
/* loaded from: classes4.dex */
public class AlaEnterEffectAdapter extends a<AlaEnterEffectData, ViewHolder> {
    public Context m;
    public int n;

    /* loaded from: classes4.dex */
    public static class ViewHolder extends TypeAdapter.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public TbImageView f14114a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f14115b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f14116c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f14117d;

        /* renamed from: e  reason: collision with root package name */
        public ImageView f14118e;

        /* renamed from: f  reason: collision with root package name */
        public ProgressBar f14119f;

        /* renamed from: g  reason: collision with root package name */
        public View f14120g;

        /* renamed from: h  reason: collision with root package name */
        public View f14121h;

        /* renamed from: i  reason: collision with root package name */
        public TextView f14122i;

        public ViewHolder(View view) {
            super(view);
            b();
        }

        public final void b() {
            TbImageView tbImageView = (TbImageView) a().findViewById(R.id.ala_enter_effect_img);
            this.f14114a = tbImageView;
            tbImageView.setAutoChangeStyle(false);
            this.f14115b = (TextView) a().findViewById(R.id.ala_enter_effect_name);
            this.f14116c = (TextView) a().findViewById(R.id.ala_enter_effect_status);
            this.f14117d = (TextView) a().findViewById(R.id.ala_enter_effect_time_limit);
            this.f14118e = (ImageView) a().findViewById(R.id.ala_enter_effect_download_img);
            this.f14119f = (ProgressBar) a().findViewById(R.id.ala_enter_effect_loading);
            this.f14120g = a().findViewById(R.id.ala_header_cover);
            this.f14121h = a().findViewById(R.id.ala_enter_effect_img_layout);
            this.f14122i = (TextView) a().findViewById(R.id.ala_enter_effect_description);
        }
    }

    public AlaEnterEffectAdapter(Context context) {
        super(context, AlaEnterEffectData.TYPE_ENTER_EFFECT_DATA);
        this.m = context;
        this.n = TbadkCoreApplication.getInst().getSkinType();
    }

    public final void e0(ViewHolder viewHolder) {
        if (viewHolder == null) {
            return;
        }
        SkinManager.setBackgroundResource(viewHolder.a(), R.color.CAM_X0201);
        SkinManager.setViewTextColor(viewHolder.f14117d, R.color.CAM_X0109, 1, this.n);
        SkinManager.setViewTextColor(viewHolder.f14115b, R.color.CAM_X0105, 1, this.n);
        if (this.n == 1) {
            viewHolder.f14120g.setVisibility(0);
        } else {
            viewHolder.f14120g.setVisibility(8);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: g0 */
    public ViewHolder Q(ViewGroup viewGroup) {
        return new ViewHolder(LayoutInflater.from(this.m).inflate(R.layout.ala_enter_effect_item_layout, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: h0 */
    public View X(int i2, View view, ViewGroup viewGroup, AlaEnterEffectData alaEnterEffectData, ViewHolder viewHolder) {
        viewHolder.f14114a.U(alaEnterEffectData.thumbnail_url, 10, false);
        viewHolder.f14115b.setText(alaEnterEffectData.name);
        if (alaEnterEffectData.isUsing()) {
            SkinManager.setViewTextColor(viewHolder.f14116c, R.color.live_cp_other_b, 1, this.n);
            SkinManager.setBackgroundResource(viewHolder.f14116c, R.drawable.ala_enter_effect_use_bg, this.n);
            viewHolder.f14116c.setText(this.m.getString(R.string.ala_enter_effect_use));
            viewHolder.f14114a.setAlpha(1.0f);
        } else if (alaEnterEffectData.isOwn) {
            SkinManager.setViewTextColor(viewHolder.f14116c, R.color.CAM_X0302, 1, this.n);
            SkinManager.setBackgroundResource(viewHolder.f14116c, R.drawable.ala_enter_effect_own_bg, this.n);
            viewHolder.f14116c.setText(this.m.getString(R.string.ala_enter_effect_own));
            viewHolder.f14114a.setAlpha(1.0f);
        } else {
            SkinManager.setViewTextColor(viewHolder.f14116c, R.color.CAM_X0109, 1, this.n);
            SkinManager.setBackgroundResource(viewHolder.f14116c, R.drawable.ala_enter_effect_not_own_bg, this.n);
            viewHolder.f14116c.setText(this.m.getString(R.string.ala_enter_effect_not_own));
            viewHolder.f14114a.setAlpha(0.7f);
        }
        viewHolder.f14117d.setText(this.m.getResources().getString(R.string.ala_left_time, StringHelper.formatDayTime((alaEnterEffectData.end_time * 1000) - System.currentTimeMillis())));
        int i3 = alaEnterEffectData.downLoadStatus;
        if (i3 == 100) {
            viewHolder.f14118e.setVisibility(0);
            viewHolder.f14119f.setVisibility(8);
        } else if (i3 == 102) {
            viewHolder.f14118e.setVisibility(8);
            viewHolder.f14119f.setVisibility(0);
        } else {
            viewHolder.f14118e.setVisibility(8);
            viewHolder.f14119f.setVisibility(8);
        }
        viewHolder.f14121h.setBackgroundColor(Color.parseColor(alaEnterEffectData.color));
        SkinManager.setViewTextColor(viewHolder.f14122i, R.color.CAM_X0109, 1, this.n);
        if (2 == alaEnterEffectData.categoryType) {
            SkinManager.setViewTextColor(viewHolder.f14122i, R.color.CAM_X0305, 1, this.n);
            viewHolder.f14122i.setText(this.m.getString(R.string.ala_enter_effect_tdou_des, AlaStringHelper.formatLowercasekDou((float) alaEnterEffectData.price), alaEnterEffectData.time));
            Drawable moneyIcon = CurrencySwitchUtil.getMoneyIcon();
            int dimensionPixelSize = this.m.getResources().getDimensionPixelSize(R.dimen.ds24);
            moneyIcon.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            viewHolder.f14122i.setCompoundDrawablePadding(this.m.getResources().getDimensionPixelSize(R.dimen.ds4));
            viewHolder.f14122i.setCompoundDrawables(moneyIcon, null, null, null);
        } else {
            viewHolder.f14122i.setText(alaEnterEffectData.obtain_way);
            viewHolder.f14122i.setCompoundDrawables(null, null, null, null);
        }
        e0(viewHolder);
        return viewHolder.a();
    }
}
