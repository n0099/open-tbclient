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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
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
        viewHolder.iez.startLoad(alaEnterEffectData.thumbnail_url, 10, false);
        viewHolder.ieA.setText(alaEnterEffectData.name);
        if (alaEnterEffectData.isUsing()) {
            ap.setViewTextColor(viewHolder.ieB, R.color.live_cp_other_b, 1, this.mSkinType);
            ap.setBackgroundResource(viewHolder.ieB, R.drawable.ala_enter_effect_use_bg, this.mSkinType);
            viewHolder.ieB.setText(this.mContext.getString(R.string.ala_enter_effect_use));
            viewHolder.iez.setAlpha(1.0f);
        } else if (alaEnterEffectData.isOwn) {
            ap.setViewTextColor(viewHolder.ieB, R.color.CAM_X0302, 1, this.mSkinType);
            ap.setBackgroundResource(viewHolder.ieB, R.drawable.ala_enter_effect_own_bg, this.mSkinType);
            viewHolder.ieB.setText(this.mContext.getString(R.string.ala_enter_effect_own));
            viewHolder.iez.setAlpha(1.0f);
        } else {
            ap.setViewTextColor(viewHolder.ieB, R.color.CAM_X0109, 1, this.mSkinType);
            ap.setBackgroundResource(viewHolder.ieB, R.drawable.ala_enter_effect_not_own_bg, this.mSkinType);
            viewHolder.ieB.setText(this.mContext.getString(R.string.ala_enter_effect_not_own));
            viewHolder.iez.setAlpha(0.7f);
        }
        viewHolder.ieC.setText(this.mContext.getResources().getString(R.string.ala_left_time, au.dX((alaEnterEffectData.end_time * 1000) - System.currentTimeMillis())));
        if (alaEnterEffectData.downLoadStatus == 100) {
            viewHolder.ieD.setVisibility(0);
            viewHolder.gWh.setVisibility(8);
        } else if (alaEnterEffectData.downLoadStatus == 102) {
            viewHolder.ieD.setVisibility(8);
            viewHolder.gWh.setVisibility(0);
        } else {
            viewHolder.ieD.setVisibility(8);
            viewHolder.gWh.setVisibility(8);
        }
        viewHolder.ieE.setBackgroundColor(Color.parseColor(alaEnterEffectData.color));
        ap.setViewTextColor(viewHolder.fhX, R.color.CAM_X0109, 1, this.mSkinType);
        if (2 == alaEnterEffectData.categoryType) {
            ap.setViewTextColor(viewHolder.fhX, R.color.CAM_X0305, 1, this.mSkinType);
            viewHolder.fhX.setText(this.mContext.getString(R.string.ala_enter_effect_tdou_des, AlaStringHelper.formatLowercasekDou(alaEnterEffectData.price), alaEnterEffectData.time));
            Drawable drawable = ap.getDrawable(R.drawable.icon_huobi_tdou);
            int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds24);
            drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            viewHolder.fhX.setCompoundDrawablePadding(this.mContext.getResources().getDimensionPixelSize(R.dimen.ds4));
            viewHolder.fhX.setCompoundDrawables(drawable, null, null, null);
        } else {
            viewHolder.fhX.setText(alaEnterEffectData.obtain_way);
            viewHolder.fhX.setCompoundDrawables(null, null, null, null);
        }
        a(viewHolder);
        return viewHolder.getView();
    }

    private void a(ViewHolder viewHolder) {
        if (viewHolder != null) {
            ap.setBackgroundResource(viewHolder.getView(), R.color.CAM_X0201);
            ap.setViewTextColor(viewHolder.ieC, R.color.CAM_X0109, 1, this.mSkinType);
            ap.setViewTextColor(viewHolder.ieA, R.color.CAM_X0105, 1, this.mSkinType);
            if (this.mSkinType == 1) {
                viewHolder.hxX.setVisibility(0);
            } else {
                viewHolder.hxX.setVisibility(8);
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class ViewHolder extends TypeAdapter.ViewHolder {
        public TextView fhX;
        public ProgressBar gWh;
        public View hxX;
        public TextView ieA;
        public TextView ieB;
        public TextView ieC;
        public ImageView ieD;
        public View ieE;
        public TbImageView iez;

        public ViewHolder(View view) {
            super(view);
            initView();
        }

        private void initView() {
            this.iez = (TbImageView) getView().findViewById(R.id.ala_enter_effect_img);
            this.iez.setAutoChangeStyle(false);
            this.ieA = (TextView) getView().findViewById(R.id.ala_enter_effect_name);
            this.ieB = (TextView) getView().findViewById(R.id.ala_enter_effect_status);
            this.ieC = (TextView) getView().findViewById(R.id.ala_enter_effect_time_limit);
            this.ieD = (ImageView) getView().findViewById(R.id.ala_enter_effect_download_img);
            this.gWh = (ProgressBar) getView().findViewById(R.id.ala_enter_effect_loading);
            this.hxX = getView().findViewById(R.id.ala_header_cover);
            this.ieE = getView().findViewById(R.id.ala_enter_effect_img_layout);
            this.fhX = (TextView) getView().findViewById(R.id.ala_enter_effect_description);
        }
    }
}
