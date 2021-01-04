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
        viewHolder.icL.startLoad(alaEnterEffectData.thumbnail_url, 10, false);
        viewHolder.icM.setText(alaEnterEffectData.name);
        if (alaEnterEffectData.isUsing()) {
            ao.setViewTextColor(viewHolder.icN, R.color.live_cp_other_b, 1, this.mSkinType);
            ao.setBackgroundResource(viewHolder.icN, R.drawable.ala_enter_effect_use_bg, this.mSkinType);
            viewHolder.icN.setText(this.mContext.getString(R.string.ala_enter_effect_use));
            viewHolder.icL.setAlpha(1.0f);
        } else if (alaEnterEffectData.isOwn) {
            ao.setViewTextColor(viewHolder.icN, R.color.CAM_X0302, 1, this.mSkinType);
            ao.setBackgroundResource(viewHolder.icN, R.drawable.ala_enter_effect_own_bg, this.mSkinType);
            viewHolder.icN.setText(this.mContext.getString(R.string.ala_enter_effect_own));
            viewHolder.icL.setAlpha(1.0f);
        } else {
            ao.setViewTextColor(viewHolder.icN, R.color.CAM_X0109, 1, this.mSkinType);
            ao.setBackgroundResource(viewHolder.icN, R.drawable.ala_enter_effect_not_own_bg, this.mSkinType);
            viewHolder.icN.setText(this.mContext.getString(R.string.ala_enter_effect_not_own));
            viewHolder.icL.setAlpha(0.7f);
        }
        viewHolder.icO.setText(this.mContext.getResources().getString(R.string.ala_left_time, at.dR((alaEnterEffectData.end_time * 1000) - System.currentTimeMillis())));
        if (alaEnterEffectData.downLoadStatus == 100) {
            viewHolder.icP.setVisibility(0);
            viewHolder.gWg.setVisibility(8);
        } else if (alaEnterEffectData.downLoadStatus == 102) {
            viewHolder.icP.setVisibility(8);
            viewHolder.gWg.setVisibility(0);
        } else {
            viewHolder.icP.setVisibility(8);
            viewHolder.gWg.setVisibility(8);
        }
        viewHolder.icQ.setBackgroundColor(Color.parseColor(alaEnterEffectData.color));
        ao.setViewTextColor(viewHolder.fiU, R.color.CAM_X0109, 1, this.mSkinType);
        if (2 == alaEnterEffectData.categoryType) {
            ao.setViewTextColor(viewHolder.fiU, R.color.CAM_X0305, 1, this.mSkinType);
            viewHolder.fiU.setText(this.mContext.getString(R.string.ala_enter_effect_tdou_des, AlaStringHelper.formatLowercasekDou(alaEnterEffectData.price), alaEnterEffectData.time));
            Drawable drawable = ao.getDrawable(R.drawable.icon_huobi_tdou);
            int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds24);
            drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            viewHolder.fiU.setCompoundDrawablePadding(this.mContext.getResources().getDimensionPixelSize(R.dimen.ds4));
            viewHolder.fiU.setCompoundDrawables(drawable, null, null, null);
        } else {
            viewHolder.fiU.setText(alaEnterEffectData.obtain_way);
            viewHolder.fiU.setCompoundDrawables(null, null, null, null);
        }
        a(viewHolder);
        return viewHolder.getView();
    }

    private void a(ViewHolder viewHolder) {
        if (viewHolder != null) {
            ao.setBackgroundResource(viewHolder.getView(), R.color.CAM_X0201);
            ao.setViewTextColor(viewHolder.icO, R.color.CAM_X0109, 1, this.mSkinType);
            ao.setViewTextColor(viewHolder.icM, R.color.CAM_X0105, 1, this.mSkinType);
            if (this.mSkinType == 1) {
                viewHolder.hww.setVisibility(0);
            } else {
                viewHolder.hww.setVisibility(8);
            }
        }
    }

    /* loaded from: classes10.dex */
    public static class ViewHolder extends TypeAdapter.ViewHolder {
        public TextView fiU;
        public ProgressBar gWg;
        public View hww;
        public TbImageView icL;
        public TextView icM;
        public TextView icN;
        public TextView icO;
        public ImageView icP;
        public View icQ;

        public ViewHolder(View view) {
            super(view);
            initView();
        }

        private void initView() {
            this.icL = (TbImageView) getView().findViewById(R.id.ala_enter_effect_img);
            this.icL.setAutoChangeStyle(false);
            this.icM = (TextView) getView().findViewById(R.id.ala_enter_effect_name);
            this.icN = (TextView) getView().findViewById(R.id.ala_enter_effect_status);
            this.icO = (TextView) getView().findViewById(R.id.ala_enter_effect_time_limit);
            this.icP = (ImageView) getView().findViewById(R.id.ala_enter_effect_download_img);
            this.gWg = (ProgressBar) getView().findViewById(R.id.ala_enter_effect_loading);
            this.hww = getView().findViewById(R.id.ala_header_cover);
            this.icQ = getView().findViewById(R.id.ala_enter_effect_img_layout);
            this.fiU = (TextView) getView().findViewById(R.id.ala_enter_effect_description);
        }
    }
}
