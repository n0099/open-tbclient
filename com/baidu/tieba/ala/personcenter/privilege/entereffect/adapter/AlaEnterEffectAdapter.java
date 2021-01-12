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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.personcenter.privilege.entereffect.data.AlaEnterEffectData;
/* loaded from: classes9.dex */
public class AlaEnterEffectAdapter extends com.baidu.adp.widget.ListView.a<AlaEnterEffectData, ViewHolder> {
    private Context mContext;
    private int mSkinType;

    public AlaEnterEffectAdapter(Context context) {
        super(context, AlaEnterEffectData.TYPE_ENTER_EFFECT_DATA);
        this.mContext = context;
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aY */
    public ViewHolder e(ViewGroup viewGroup) {
        return new ViewHolder(LayoutInflater.from(this.mContext).inflate(R.layout.ala_enter_effect_item_layout, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, AlaEnterEffectData alaEnterEffectData, ViewHolder viewHolder) {
        viewHolder.hYe.startLoad(alaEnterEffectData.thumbnail_url, 10, false);
        viewHolder.hYf.setText(alaEnterEffectData.name);
        if (alaEnterEffectData.isUsing()) {
            ao.setViewTextColor(viewHolder.hYg, R.color.live_cp_other_b, 1, this.mSkinType);
            ao.setBackgroundResource(viewHolder.hYg, R.drawable.ala_enter_effect_use_bg, this.mSkinType);
            viewHolder.hYg.setText(this.mContext.getString(R.string.ala_enter_effect_use));
            viewHolder.hYe.setAlpha(1.0f);
        } else if (alaEnterEffectData.isOwn) {
            ao.setViewTextColor(viewHolder.hYg, R.color.CAM_X0302, 1, this.mSkinType);
            ao.setBackgroundResource(viewHolder.hYg, R.drawable.ala_enter_effect_own_bg, this.mSkinType);
            viewHolder.hYg.setText(this.mContext.getString(R.string.ala_enter_effect_own));
            viewHolder.hYe.setAlpha(1.0f);
        } else {
            ao.setViewTextColor(viewHolder.hYg, R.color.CAM_X0109, 1, this.mSkinType);
            ao.setBackgroundResource(viewHolder.hYg, R.drawable.ala_enter_effect_not_own_bg, this.mSkinType);
            viewHolder.hYg.setText(this.mContext.getString(R.string.ala_enter_effect_not_own));
            viewHolder.hYe.setAlpha(0.7f);
        }
        viewHolder.hYh.setText(this.mContext.getResources().getString(R.string.ala_left_time, at.dR((alaEnterEffectData.end_time * 1000) - System.currentTimeMillis())));
        if (alaEnterEffectData.downLoadStatus == 100) {
            viewHolder.hYi.setVisibility(0);
            viewHolder.gRA.setVisibility(8);
        } else if (alaEnterEffectData.downLoadStatus == 102) {
            viewHolder.hYi.setVisibility(8);
            viewHolder.gRA.setVisibility(0);
        } else {
            viewHolder.hYi.setVisibility(8);
            viewHolder.gRA.setVisibility(8);
        }
        viewHolder.hYj.setBackgroundColor(Color.parseColor(alaEnterEffectData.color));
        ao.setViewTextColor(viewHolder.fej, R.color.CAM_X0109, 1, this.mSkinType);
        if (2 == alaEnterEffectData.categoryType) {
            ao.setViewTextColor(viewHolder.fej, R.color.CAM_X0305, 1, this.mSkinType);
            viewHolder.fej.setText(this.mContext.getString(R.string.ala_enter_effect_tdou_des, AlaStringHelper.formatLowercasekDou(alaEnterEffectData.price), alaEnterEffectData.time));
            Drawable drawable = ao.getDrawable(R.drawable.icon_huobi_tdou);
            int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds24);
            drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            viewHolder.fej.setCompoundDrawablePadding(this.mContext.getResources().getDimensionPixelSize(R.dimen.ds4));
            viewHolder.fej.setCompoundDrawables(drawable, null, null, null);
        } else {
            viewHolder.fej.setText(alaEnterEffectData.obtain_way);
            viewHolder.fej.setCompoundDrawables(null, null, null, null);
        }
        a(viewHolder);
        return viewHolder.getView();
    }

    private void a(ViewHolder viewHolder) {
        if (viewHolder != null) {
            ao.setBackgroundResource(viewHolder.getView(), R.color.CAM_X0201);
            ao.setViewTextColor(viewHolder.hYh, R.color.CAM_X0109, 1, this.mSkinType);
            ao.setViewTextColor(viewHolder.hYf, R.color.CAM_X0105, 1, this.mSkinType);
            if (this.mSkinType == 1) {
                viewHolder.hrQ.setVisibility(0);
            } else {
                viewHolder.hrQ.setVisibility(8);
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class ViewHolder extends TypeAdapter.ViewHolder {
        public TextView fej;
        public ProgressBar gRA;
        public TbImageView hYe;
        public TextView hYf;
        public TextView hYg;
        public TextView hYh;
        public ImageView hYi;
        public View hYj;
        public View hrQ;

        public ViewHolder(View view) {
            super(view);
            initView();
        }

        private void initView() {
            this.hYe = (TbImageView) getView().findViewById(R.id.ala_enter_effect_img);
            this.hYe.setAutoChangeStyle(false);
            this.hYf = (TextView) getView().findViewById(R.id.ala_enter_effect_name);
            this.hYg = (TextView) getView().findViewById(R.id.ala_enter_effect_status);
            this.hYh = (TextView) getView().findViewById(R.id.ala_enter_effect_time_limit);
            this.hYi = (ImageView) getView().findViewById(R.id.ala_enter_effect_download_img);
            this.gRA = (ProgressBar) getView().findViewById(R.id.ala_enter_effect_loading);
            this.hrQ = getView().findViewById(R.id.ala_header_cover);
            this.hYj = getView().findViewById(R.id.ala_enter_effect_img_layout);
            this.fej = (TextView) getView().findViewById(R.id.ala_enter_effect_description);
        }
    }
}
