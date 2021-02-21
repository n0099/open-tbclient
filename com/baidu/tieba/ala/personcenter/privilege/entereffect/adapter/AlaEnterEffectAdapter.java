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
/* loaded from: classes10.dex */
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
        viewHolder.icM.startLoad(alaEnterEffectData.thumbnail_url, 10, false);
        viewHolder.icN.setText(alaEnterEffectData.name);
        if (alaEnterEffectData.isUsing()) {
            ap.setViewTextColor(viewHolder.icO, R.color.live_cp_other_b, 1, this.mSkinType);
            ap.setBackgroundResource(viewHolder.icO, R.drawable.ala_enter_effect_use_bg, this.mSkinType);
            viewHolder.icO.setText(this.mContext.getString(R.string.ala_enter_effect_use));
            viewHolder.icM.setAlpha(1.0f);
        } else if (alaEnterEffectData.isOwn) {
            ap.setViewTextColor(viewHolder.icO, R.color.CAM_X0302, 1, this.mSkinType);
            ap.setBackgroundResource(viewHolder.icO, R.drawable.ala_enter_effect_own_bg, this.mSkinType);
            viewHolder.icO.setText(this.mContext.getString(R.string.ala_enter_effect_own));
            viewHolder.icM.setAlpha(1.0f);
        } else {
            ap.setViewTextColor(viewHolder.icO, R.color.CAM_X0109, 1, this.mSkinType);
            ap.setBackgroundResource(viewHolder.icO, R.drawable.ala_enter_effect_not_own_bg, this.mSkinType);
            viewHolder.icO.setText(this.mContext.getString(R.string.ala_enter_effect_not_own));
            viewHolder.icM.setAlpha(0.7f);
        }
        viewHolder.icP.setText(this.mContext.getResources().getString(R.string.ala_left_time, au.dX((alaEnterEffectData.end_time * 1000) - System.currentTimeMillis())));
        if (alaEnterEffectData.downLoadStatus == 100) {
            viewHolder.icQ.setVisibility(0);
            viewHolder.gUy.setVisibility(8);
        } else if (alaEnterEffectData.downLoadStatus == 102) {
            viewHolder.icQ.setVisibility(8);
            viewHolder.gUy.setVisibility(0);
        } else {
            viewHolder.icQ.setVisibility(8);
            viewHolder.gUy.setVisibility(8);
        }
        viewHolder.icR.setBackgroundColor(Color.parseColor(alaEnterEffectData.color));
        ap.setViewTextColor(viewHolder.fgy, R.color.CAM_X0109, 1, this.mSkinType);
        if (2 == alaEnterEffectData.categoryType) {
            ap.setViewTextColor(viewHolder.fgy, R.color.CAM_X0305, 1, this.mSkinType);
            viewHolder.fgy.setText(this.mContext.getString(R.string.ala_enter_effect_tdou_des, AlaStringHelper.formatLowercasekDou(alaEnterEffectData.price), alaEnterEffectData.time));
            Drawable drawable = ap.getDrawable(R.drawable.icon_huobi_tdou);
            int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds24);
            drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            viewHolder.fgy.setCompoundDrawablePadding(this.mContext.getResources().getDimensionPixelSize(R.dimen.ds4));
            viewHolder.fgy.setCompoundDrawables(drawable, null, null, null);
        } else {
            viewHolder.fgy.setText(alaEnterEffectData.obtain_way);
            viewHolder.fgy.setCompoundDrawables(null, null, null, null);
        }
        a(viewHolder);
        return viewHolder.getView();
    }

    private void a(ViewHolder viewHolder) {
        if (viewHolder != null) {
            ap.setBackgroundResource(viewHolder.getView(), R.color.CAM_X0201);
            ap.setViewTextColor(viewHolder.icP, R.color.CAM_X0109, 1, this.mSkinType);
            ap.setViewTextColor(viewHolder.icN, R.color.CAM_X0105, 1, this.mSkinType);
            if (this.mSkinType == 1) {
                viewHolder.hwo.setVisibility(0);
            } else {
                viewHolder.hwo.setVisibility(8);
            }
        }
    }

    /* loaded from: classes10.dex */
    public static class ViewHolder extends TypeAdapter.ViewHolder {
        public TextView fgy;
        public ProgressBar gUy;
        public View hwo;
        public TbImageView icM;
        public TextView icN;
        public TextView icO;
        public TextView icP;
        public ImageView icQ;
        public View icR;

        public ViewHolder(View view) {
            super(view);
            initView();
        }

        private void initView() {
            this.icM = (TbImageView) getView().findViewById(R.id.ala_enter_effect_img);
            this.icM.setAutoChangeStyle(false);
            this.icN = (TextView) getView().findViewById(R.id.ala_enter_effect_name);
            this.icO = (TextView) getView().findViewById(R.id.ala_enter_effect_status);
            this.icP = (TextView) getView().findViewById(R.id.ala_enter_effect_time_limit);
            this.icQ = (ImageView) getView().findViewById(R.id.ala_enter_effect_download_img);
            this.gUy = (ProgressBar) getView().findViewById(R.id.ala_enter_effect_loading);
            this.hwo = getView().findViewById(R.id.ala_header_cover);
            this.icR = getView().findViewById(R.id.ala_enter_effect_img_layout);
            this.fgy = (TextView) getView().findViewById(R.id.ala_enter_effect_description);
        }
    }
}
