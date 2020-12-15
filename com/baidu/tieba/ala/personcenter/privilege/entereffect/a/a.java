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
/* loaded from: classes6.dex */
public class a extends com.baidu.adp.widget.ListView.a<AlaEnterEffectData, C0716a> {
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
    public C0716a c(ViewGroup viewGroup) {
        return new C0716a(LayoutInflater.from(this.mContext).inflate(R.layout.ala_enter_effect_item_layout, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, AlaEnterEffectData alaEnterEffectData, C0716a c0716a) {
        c0716a.hQp.startLoad(alaEnterEffectData.thumbnail_url, 10, false);
        c0716a.hQq.setText(alaEnterEffectData.name);
        if (alaEnterEffectData.isUsing()) {
            ap.setViewTextColor(c0716a.hQr, R.color.live_cp_other_b, 1, this.mSkinType);
            ap.setBackgroundResource(c0716a.hQr, R.drawable.ala_enter_effect_use_bg, this.mSkinType);
            c0716a.hQr.setText(this.mContext.getString(R.string.ala_enter_effect_use));
            c0716a.hQp.setAlpha(1.0f);
        } else if (alaEnterEffectData.isOwn) {
            ap.setViewTextColor(c0716a.hQr, R.color.CAM_X0302, 1, this.mSkinType);
            ap.setBackgroundResource(c0716a.hQr, R.drawable.ala_enter_effect_own_bg, this.mSkinType);
            c0716a.hQr.setText(this.mContext.getString(R.string.ala_enter_effect_own));
            c0716a.hQp.setAlpha(1.0f);
        } else {
            ap.setViewTextColor(c0716a.hQr, R.color.CAM_X0109, 1, this.mSkinType);
            ap.setBackgroundResource(c0716a.hQr, R.drawable.ala_enter_effect_not_own_bg, this.mSkinType);
            c0716a.hQr.setText(this.mContext.getString(R.string.ala_enter_effect_not_own));
            c0716a.hQp.setAlpha(0.7f);
        }
        c0716a.hQs.setText(this.mContext.getResources().getString(R.string.ala_left_time, au.dR((alaEnterEffectData.end_time * 1000) - System.currentTimeMillis())));
        if (alaEnterEffectData.downLoadStatus == 100) {
            c0716a.hQt.setVisibility(0);
            c0716a.gKu.setVisibility(8);
        } else if (alaEnterEffectData.downLoadStatus == 102) {
            c0716a.hQt.setVisibility(8);
            c0716a.gKu.setVisibility(0);
        } else {
            c0716a.hQt.setVisibility(8);
            c0716a.gKu.setVisibility(8);
        }
        c0716a.hQu.setBackgroundColor(Color.parseColor(alaEnterEffectData.color));
        ap.setViewTextColor(c0716a.eZq, R.color.CAM_X0109, 1, this.mSkinType);
        if (2 == alaEnterEffectData.categoryType) {
            ap.setViewTextColor(c0716a.eZq, R.color.CAM_X0305, 1, this.mSkinType);
            c0716a.eZq.setText(this.mContext.getString(R.string.ala_enter_effect_tdou_des, AlaStringHelper.formatLowercasekDou(alaEnterEffectData.price), alaEnterEffectData.time));
            Drawable drawable = ap.getDrawable(R.drawable.icon_huobi_tdou);
            int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds24);
            drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            c0716a.eZq.setCompoundDrawablePadding(this.mContext.getResources().getDimensionPixelSize(R.dimen.ds4));
            c0716a.eZq.setCompoundDrawables(drawable, null, null, null);
        } else {
            c0716a.eZq.setText(alaEnterEffectData.obtain_way);
            c0716a.eZq.setCompoundDrawables(null, null, null, null);
        }
        a(c0716a);
        return c0716a.getView();
    }

    private void a(C0716a c0716a) {
        if (c0716a != null) {
            ap.setBackgroundResource(c0716a.getView(), R.color.CAM_X0201);
            ap.setViewTextColor(c0716a.hQs, R.color.CAM_X0109, 1, this.mSkinType);
            ap.setViewTextColor(c0716a.hQq, R.color.CAM_X0105, 1, this.mSkinType);
            if (this.mSkinType == 1) {
                c0716a.hkB.setVisibility(0);
            } else {
                c0716a.hkB.setVisibility(8);
            }
        }
    }

    /* renamed from: com.baidu.tieba.ala.personcenter.privilege.entereffect.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0716a extends af.a {
        public TextView eZq;
        public ProgressBar gKu;
        public TbImageView hQp;
        public TextView hQq;
        public TextView hQr;
        public TextView hQs;
        public ImageView hQt;
        public View hQu;
        public View hkB;

        public C0716a(View view) {
            super(view);
            initView();
        }

        private void initView() {
            this.hQp = (TbImageView) getView().findViewById(R.id.ala_enter_effect_img);
            this.hQp.setAutoChangeStyle(false);
            this.hQq = (TextView) getView().findViewById(R.id.ala_enter_effect_name);
            this.hQr = (TextView) getView().findViewById(R.id.ala_enter_effect_status);
            this.hQs = (TextView) getView().findViewById(R.id.ala_enter_effect_time_limit);
            this.hQt = (ImageView) getView().findViewById(R.id.ala_enter_effect_download_img);
            this.gKu = (ProgressBar) getView().findViewById(R.id.ala_enter_effect_loading);
            this.hkB = getView().findViewById(R.id.ala_header_cover);
            this.hQu = getView().findViewById(R.id.ala_enter_effect_img_layout);
            this.eZq = (TextView) getView().findViewById(R.id.ala_enter_effect_description);
        }
    }
}
