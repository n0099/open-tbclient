package com.baidu.tieba.ala.personcenter.privilege.entereffect.a;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.ad;
import com.baidu.ala.utils.AlaStringHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.personcenter.privilege.entereffect.data.AlaEnterEffectData;
/* loaded from: classes4.dex */
public class a extends com.baidu.adp.widget.ListView.a<AlaEnterEffectData, C0608a> {
    private Context mContext;
    private int mSkinType;

    public a(Context context) {
        super(context, AlaEnterEffectData.TYPE_ENTER_EFFECT_DATA);
        this.mContext = context;
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aM */
    public C0608a b(ViewGroup viewGroup) {
        return new C0608a(LayoutInflater.from(this.mContext).inflate(R.layout.ala_enter_effect_item_layout, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, AlaEnterEffectData alaEnterEffectData, C0608a c0608a) {
        c0608a.gJS.startLoad(alaEnterEffectData.thumbnail_url, 10, false);
        c0608a.gJT.setText(alaEnterEffectData.name);
        if (alaEnterEffectData.isUsing()) {
            ao.setViewTextColor(c0608a.gJU, R.color.live_cp_other_b, 1, this.mSkinType);
            ao.setBackgroundResource(c0608a.gJU, R.drawable.ala_enter_effect_use_bg, this.mSkinType);
            c0608a.gJU.setText(this.mContext.getString(R.string.ala_enter_effect_use));
            c0608a.gJS.setAlpha(1.0f);
        } else if (alaEnterEffectData.isOwn) {
            ao.setViewTextColor(c0608a.gJU, R.color.cp_link_tip_a, 1, this.mSkinType);
            ao.setBackgroundResource(c0608a.gJU, R.drawable.ala_enter_effect_own_bg, this.mSkinType);
            c0608a.gJU.setText(this.mContext.getString(R.string.ala_enter_effect_own));
            c0608a.gJS.setAlpha(1.0f);
        } else {
            ao.setViewTextColor(c0608a.gJU, R.color.cp_cont_d, 1, this.mSkinType);
            ao.setBackgroundResource(c0608a.gJU, R.drawable.ala_enter_effect_not_own_bg, this.mSkinType);
            c0608a.gJU.setText(this.mContext.getString(R.string.ala_enter_effect_not_own));
            c0608a.gJS.setAlpha(0.7f);
        }
        c0608a.gJV.setText(this.mContext.getResources().getString(R.string.ala_left_time, as.cA((alaEnterEffectData.end_time * 1000) - System.currentTimeMillis())));
        if (alaEnterEffectData.downLoadStatus == 100) {
            c0608a.gJW.setVisibility(0);
            c0608a.gJX.setVisibility(8);
        } else if (alaEnterEffectData.downLoadStatus == 102) {
            c0608a.gJW.setVisibility(8);
            c0608a.gJX.setVisibility(0);
        } else {
            c0608a.gJW.setVisibility(8);
            c0608a.gJX.setVisibility(8);
        }
        c0608a.gJY.setBackgroundColor(Color.parseColor(alaEnterEffectData.color));
        ao.setViewTextColor(c0608a.egK, R.color.cp_cont_d, 1, this.mSkinType);
        if (2 == alaEnterEffectData.categoryType) {
            ao.setViewTextColor(c0608a.egK, R.color.cp_link_tip_d, 1, this.mSkinType);
            c0608a.egK.setText(this.mContext.getString(R.string.ala_enter_effect_tdou_des, AlaStringHelper.formatLowercasekDou(alaEnterEffectData.price), alaEnterEffectData.time));
            Drawable drawable = ao.getDrawable(R.drawable.icon_huobi_tdou);
            int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds24);
            drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            c0608a.egK.setCompoundDrawablePadding(this.mContext.getResources().getDimensionPixelSize(R.dimen.ds4));
            c0608a.egK.setCompoundDrawables(drawable, null, null, null);
        } else {
            c0608a.egK.setText(alaEnterEffectData.obtain_way);
            c0608a.egK.setCompoundDrawables(null, null, null, null);
        }
        a(c0608a);
        return c0608a.getView();
    }

    private void a(C0608a c0608a) {
        if (c0608a != null) {
            ao.setBackgroundResource(c0608a.getView(), R.color.cp_bg_line_d);
            ao.setViewTextColor(c0608a.gJV, R.color.cp_cont_d, 1, this.mSkinType);
            ao.setViewTextColor(c0608a.gJT, R.color.cp_cont_b, 1, this.mSkinType);
            if (this.mSkinType == 1) {
                c0608a.gfn.setVisibility(0);
            } else {
                c0608a.gfn.setVisibility(8);
            }
        }
    }

    /* renamed from: com.baidu.tieba.ala.personcenter.privilege.entereffect.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0608a extends ad.a {
        public TextView egK;
        public TbImageView gJS;
        public TextView gJT;
        public TextView gJU;
        public TextView gJV;
        public ImageView gJW;
        public ProgressBar gJX;
        public View gJY;
        public View gfn;

        public C0608a(View view) {
            super(view);
            initView();
        }

        private void initView() {
            this.gJS = (TbImageView) getView().findViewById(R.id.ala_enter_effect_img);
            this.gJS.setAutoChangeStyle(false);
            this.gJT = (TextView) getView().findViewById(R.id.ala_enter_effect_name);
            this.gJU = (TextView) getView().findViewById(R.id.ala_enter_effect_status);
            this.gJV = (TextView) getView().findViewById(R.id.ala_enter_effect_time_limit);
            this.gJW = (ImageView) getView().findViewById(R.id.ala_enter_effect_download_img);
            this.gJX = (ProgressBar) getView().findViewById(R.id.ala_enter_effect_loading);
            this.gfn = getView().findViewById(R.id.ala_header_cover);
            this.gJY = getView().findViewById(R.id.ala_enter_effect_img_layout);
            this.egK = (TextView) getView().findViewById(R.id.ala_enter_effect_description);
        }
    }
}
