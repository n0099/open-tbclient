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
import com.baidu.adp.widget.ListView.af;
import com.baidu.ala.utils.AlaStringHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.personcenter.privilege.entereffect.data.AlaEnterEffectData;
/* loaded from: classes4.dex */
public class a extends com.baidu.adp.widget.ListView.a<AlaEnterEffectData, C0703a> {
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
    public C0703a c(ViewGroup viewGroup) {
        return new C0703a(LayoutInflater.from(this.mContext).inflate(R.layout.ala_enter_effect_item_layout, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, AlaEnterEffectData alaEnterEffectData, C0703a c0703a) {
        c0703a.hGG.startLoad(alaEnterEffectData.thumbnail_url, 10, false);
        c0703a.hGH.setText(alaEnterEffectData.name);
        if (alaEnterEffectData.isUsing()) {
            ap.setViewTextColor(c0703a.hGI, R.color.live_cp_other_b, 1, this.mSkinType);
            ap.setBackgroundResource(c0703a.hGI, R.drawable.ala_enter_effect_use_bg, this.mSkinType);
            c0703a.hGI.setText(this.mContext.getString(R.string.ala_enter_effect_use));
            c0703a.hGG.setAlpha(1.0f);
        } else if (alaEnterEffectData.isOwn) {
            ap.setViewTextColor(c0703a.hGI, R.color.CAM_X0302, 1, this.mSkinType);
            ap.setBackgroundResource(c0703a.hGI, R.drawable.ala_enter_effect_own_bg, this.mSkinType);
            c0703a.hGI.setText(this.mContext.getString(R.string.ala_enter_effect_own));
            c0703a.hGG.setAlpha(1.0f);
        } else {
            ap.setViewTextColor(c0703a.hGI, R.color.CAM_X0109, 1, this.mSkinType);
            ap.setBackgroundResource(c0703a.hGI, R.drawable.ala_enter_effect_not_own_bg, this.mSkinType);
            c0703a.hGI.setText(this.mContext.getString(R.string.ala_enter_effect_not_own));
            c0703a.hGG.setAlpha(0.7f);
        }
        c0703a.hGJ.setText(this.mContext.getResources().getString(R.string.ala_left_time, au.ds((alaEnterEffectData.end_time * 1000) - System.currentTimeMillis())));
        if (alaEnterEffectData.downLoadStatus == 100) {
            c0703a.hGK.setVisibility(0);
            c0703a.gBv.setVisibility(8);
        } else if (alaEnterEffectData.downLoadStatus == 102) {
            c0703a.hGK.setVisibility(8);
            c0703a.gBv.setVisibility(0);
        } else {
            c0703a.hGK.setVisibility(8);
            c0703a.gBv.setVisibility(8);
        }
        c0703a.hGL.setBackgroundColor(Color.parseColor(alaEnterEffectData.color));
        ap.setViewTextColor(c0703a.eRY, R.color.CAM_X0109, 1, this.mSkinType);
        if (2 == alaEnterEffectData.categoryType) {
            ap.setViewTextColor(c0703a.eRY, R.color.CAM_X0305, 1, this.mSkinType);
            c0703a.eRY.setText(this.mContext.getString(R.string.ala_enter_effect_tdou_des, AlaStringHelper.formatLowercasekDou(alaEnterEffectData.price), alaEnterEffectData.time));
            Drawable drawable = ap.getDrawable(R.drawable.icon_huobi_tdou);
            int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds24);
            drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            c0703a.eRY.setCompoundDrawablePadding(this.mContext.getResources().getDimensionPixelSize(R.dimen.ds4));
            c0703a.eRY.setCompoundDrawables(drawable, null, null, null);
        } else {
            c0703a.eRY.setText(alaEnterEffectData.obtain_way);
            c0703a.eRY.setCompoundDrawables(null, null, null, null);
        }
        a(c0703a);
        return c0703a.getView();
    }

    private void a(C0703a c0703a) {
        if (c0703a != null) {
            ap.setBackgroundResource(c0703a.getView(), R.color.CAM_X0201);
            ap.setViewTextColor(c0703a.hGJ, R.color.CAM_X0109, 1, this.mSkinType);
            ap.setViewTextColor(c0703a.hGH, R.color.CAM_X0105, 1, this.mSkinType);
            if (this.mSkinType == 1) {
                c0703a.haQ.setVisibility(0);
            } else {
                c0703a.haQ.setVisibility(8);
            }
        }
    }

    /* renamed from: com.baidu.tieba.ala.personcenter.privilege.entereffect.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0703a extends af.a {
        public TextView eRY;
        public ProgressBar gBv;
        public TbImageView hGG;
        public TextView hGH;
        public TextView hGI;
        public TextView hGJ;
        public ImageView hGK;
        public View hGL;
        public View haQ;

        public C0703a(View view) {
            super(view);
            initView();
        }

        private void initView() {
            this.hGG = (TbImageView) getView().findViewById(R.id.ala_enter_effect_img);
            this.hGG.setAutoChangeStyle(false);
            this.hGH = (TextView) getView().findViewById(R.id.ala_enter_effect_name);
            this.hGI = (TextView) getView().findViewById(R.id.ala_enter_effect_status);
            this.hGJ = (TextView) getView().findViewById(R.id.ala_enter_effect_time_limit);
            this.hGK = (ImageView) getView().findViewById(R.id.ala_enter_effect_download_img);
            this.gBv = (ProgressBar) getView().findViewById(R.id.ala_enter_effect_loading);
            this.haQ = getView().findViewById(R.id.ala_header_cover);
            this.hGL = getView().findViewById(R.id.ala_enter_effect_img_layout);
            this.eRY = (TextView) getView().findViewById(R.id.ala_enter_effect_description);
        }
    }
}
