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
import com.baidu.tbadk.core.util.at;
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
    /* renamed from: aQ */
    public C0703a c(ViewGroup viewGroup) {
        return new C0703a(LayoutInflater.from(this.mContext).inflate(R.layout.ala_enter_effect_item_layout, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, AlaEnterEffectData alaEnterEffectData, C0703a c0703a) {
        c0703a.hGZ.startLoad(alaEnterEffectData.thumbnail_url, 10, false);
        c0703a.hHa.setText(alaEnterEffectData.name);
        if (alaEnterEffectData.isUsing()) {
            ap.setViewTextColor(c0703a.hHb, R.color.live_cp_other_b, 1, this.mSkinType);
            ap.setBackgroundResource(c0703a.hHb, R.drawable.ala_enter_effect_use_bg, this.mSkinType);
            c0703a.hHb.setText(this.mContext.getString(R.string.ala_enter_effect_use));
            c0703a.hGZ.setAlpha(1.0f);
        } else if (alaEnterEffectData.isOwn) {
            ap.setViewTextColor(c0703a.hHb, R.color.cp_link_tip_a, 1, this.mSkinType);
            ap.setBackgroundResource(c0703a.hHb, R.drawable.ala_enter_effect_own_bg, this.mSkinType);
            c0703a.hHb.setText(this.mContext.getString(R.string.ala_enter_effect_own));
            c0703a.hGZ.setAlpha(1.0f);
        } else {
            ap.setViewTextColor(c0703a.hHb, R.color.cp_cont_d, 1, this.mSkinType);
            ap.setBackgroundResource(c0703a.hHb, R.drawable.ala_enter_effect_not_own_bg, this.mSkinType);
            c0703a.hHb.setText(this.mContext.getString(R.string.ala_enter_effect_not_own));
            c0703a.hGZ.setAlpha(0.7f);
        }
        c0703a.hHc.setText(this.mContext.getResources().getString(R.string.ala_left_time, at.ds((alaEnterEffectData.end_time * 1000) - System.currentTimeMillis())));
        if (alaEnterEffectData.downLoadStatus == 100) {
            c0703a.hHd.setVisibility(0);
            c0703a.gBO.setVisibility(8);
        } else if (alaEnterEffectData.downLoadStatus == 102) {
            c0703a.hHd.setVisibility(8);
            c0703a.gBO.setVisibility(0);
        } else {
            c0703a.hHd.setVisibility(8);
            c0703a.gBO.setVisibility(8);
        }
        c0703a.hHe.setBackgroundColor(Color.parseColor(alaEnterEffectData.color));
        ap.setViewTextColor(c0703a.eSW, R.color.cp_cont_d, 1, this.mSkinType);
        if (2 == alaEnterEffectData.categoryType) {
            ap.setViewTextColor(c0703a.eSW, R.color.cp_link_tip_d, 1, this.mSkinType);
            c0703a.eSW.setText(this.mContext.getString(R.string.ala_enter_effect_tdou_des, AlaStringHelper.formatLowercasekDou(alaEnterEffectData.price), alaEnterEffectData.time));
            Drawable drawable = ap.getDrawable(R.drawable.icon_huobi_tdou);
            int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds24);
            drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            c0703a.eSW.setCompoundDrawablePadding(this.mContext.getResources().getDimensionPixelSize(R.dimen.ds4));
            c0703a.eSW.setCompoundDrawables(drawable, null, null, null);
        } else {
            c0703a.eSW.setText(alaEnterEffectData.obtain_way);
            c0703a.eSW.setCompoundDrawables(null, null, null, null);
        }
        a(c0703a);
        return c0703a.getView();
    }

    private void a(C0703a c0703a) {
        if (c0703a != null) {
            ap.setBackgroundResource(c0703a.getView(), R.color.cp_bg_line_d);
            ap.setViewTextColor(c0703a.hHc, R.color.cp_cont_d, 1, this.mSkinType);
            ap.setViewTextColor(c0703a.hHa, R.color.cp_cont_b, 1, this.mSkinType);
            if (this.mSkinType == 1) {
                c0703a.hbj.setVisibility(0);
            } else {
                c0703a.hbj.setVisibility(8);
            }
        }
    }

    /* renamed from: com.baidu.tieba.ala.personcenter.privilege.entereffect.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0703a extends af.a {
        public TextView eSW;
        public ProgressBar gBO;
        public TbImageView hGZ;
        public TextView hHa;
        public TextView hHb;
        public TextView hHc;
        public ImageView hHd;
        public View hHe;
        public View hbj;

        public C0703a(View view) {
            super(view);
            initView();
        }

        private void initView() {
            this.hGZ = (TbImageView) getView().findViewById(R.id.ala_enter_effect_img);
            this.hGZ.setAutoChangeStyle(false);
            this.hHa = (TextView) getView().findViewById(R.id.ala_enter_effect_name);
            this.hHb = (TextView) getView().findViewById(R.id.ala_enter_effect_status);
            this.hHc = (TextView) getView().findViewById(R.id.ala_enter_effect_time_limit);
            this.hHd = (ImageView) getView().findViewById(R.id.ala_enter_effect_download_img);
            this.gBO = (ProgressBar) getView().findViewById(R.id.ala_enter_effect_loading);
            this.hbj = getView().findViewById(R.id.ala_header_cover);
            this.hHe = getView().findViewById(R.id.ala_enter_effect_img_layout);
            this.eSW = (TextView) getView().findViewById(R.id.ala_enter_effect_description);
        }
    }
}
