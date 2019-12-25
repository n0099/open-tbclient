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
import com.baidu.adp.widget.ListView.v;
import com.baidu.ala.utils.AlaStringHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.personcenter.privilege.entereffect.data.AlaEnterEffectData;
/* loaded from: classes2.dex */
public class a extends com.baidu.adp.widget.ListView.a<AlaEnterEffectData, C0471a> {
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
    /* renamed from: as */
    public C0471a b(ViewGroup viewGroup) {
        return new C0471a(LayoutInflater.from(this.mContext).inflate(R.layout.ala_enter_effect_item_layout, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, AlaEnterEffectData alaEnterEffectData, C0471a c0471a) {
        c0471a.frr.startLoad(alaEnterEffectData.thumbnail_url, 10, false);
        c0471a.frt.setText(alaEnterEffectData.name);
        if (alaEnterEffectData.isUsing()) {
            am.setViewTextColor(c0471a.fru, R.color.live_cp_other_b, 1, this.mSkinType);
            am.setBackgroundResource(c0471a.fru, R.drawable.ala_enter_effect_use_bg, this.mSkinType);
            c0471a.fru.setText(this.mContext.getString(R.string.ala_enter_effect_use));
            c0471a.frr.setAlpha(1.0f);
        } else if (alaEnterEffectData.isOwn) {
            am.setViewTextColor(c0471a.fru, R.color.cp_link_tip_a, 1, this.mSkinType);
            am.setBackgroundResource(c0471a.fru, R.drawable.ala_enter_effect_own_bg, this.mSkinType);
            c0471a.fru.setText(this.mContext.getString(R.string.ala_enter_effect_own));
            c0471a.frr.setAlpha(1.0f);
        } else {
            am.setViewTextColor(c0471a.fru, R.color.cp_cont_d, 1, this.mSkinType);
            am.setBackgroundResource(c0471a.fru, R.drawable.ala_enter_effect_not_own_bg, this.mSkinType);
            c0471a.fru.setText(this.mContext.getString(R.string.ala_enter_effect_not_own));
            c0471a.frr.setAlpha(0.7f);
        }
        c0471a.frv.setText(this.mContext.getResources().getString(R.string.ala_left_time, aq.bv((alaEnterEffectData.end_time * 1000) - System.currentTimeMillis())));
        if (alaEnterEffectData.downLoadStatus == 100) {
            c0471a.frw.setVisibility(0);
            c0471a.frx.setVisibility(8);
        } else if (alaEnterEffectData.downLoadStatus == 102) {
            c0471a.frw.setVisibility(8);
            c0471a.frx.setVisibility(0);
        } else {
            c0471a.frw.setVisibility(8);
            c0471a.frx.setVisibility(8);
        }
        c0471a.fry.setBackgroundColor(Color.parseColor(alaEnterEffectData.color));
        am.setViewTextColor(c0471a.frz, R.color.cp_cont_d, 1, this.mSkinType);
        if (2 == alaEnterEffectData.categoryType) {
            am.setViewTextColor(c0471a.frz, R.color.cp_link_tip_d, 1, this.mSkinType);
            c0471a.frz.setText(this.mContext.getString(R.string.ala_enter_effect_tdou_des, AlaStringHelper.formatLowercasekDou(alaEnterEffectData.price), alaEnterEffectData.time));
            Drawable drawable = am.getDrawable(R.drawable.icon_huobi_tdou);
            int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds24);
            drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            c0471a.frz.setCompoundDrawablePadding(this.mContext.getResources().getDimensionPixelSize(R.dimen.ds4));
            c0471a.frz.setCompoundDrawables(drawable, null, null, null);
        } else {
            c0471a.frz.setText(alaEnterEffectData.obtain_way);
            c0471a.frz.setCompoundDrawables(null, null, null, null);
        }
        a(c0471a);
        return c0471a.getView();
    }

    private void a(C0471a c0471a) {
        if (c0471a != null) {
            am.setBackgroundResource(c0471a.getView(), R.color.cp_bg_line_d);
            am.setViewTextColor(c0471a.frv, R.color.cp_cont_d, 1, this.mSkinType);
            am.setViewTextColor(c0471a.frt, R.color.cp_cont_b, 1, this.mSkinType);
            if (this.mSkinType == 1) {
                c0471a.ePG.setVisibility(0);
            } else {
                c0471a.ePG.setVisibility(8);
            }
        }
    }

    /* renamed from: com.baidu.tieba.ala.personcenter.privilege.entereffect.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0471a extends v.a {
        public View ePG;
        public TbImageView frr;
        public TextView frt;
        public TextView fru;
        public TextView frv;
        public ImageView frw;
        public ProgressBar frx;
        public View fry;
        public TextView frz;

        public C0471a(View view) {
            super(view);
            initView();
        }

        private void initView() {
            this.frr = (TbImageView) getView().findViewById(R.id.ala_enter_effect_img);
            this.frr.setAutoChangeStyle(false);
            this.frt = (TextView) getView().findViewById(R.id.ala_enter_effect_name);
            this.fru = (TextView) getView().findViewById(R.id.ala_enter_effect_status);
            this.frv = (TextView) getView().findViewById(R.id.ala_enter_effect_time_limit);
            this.frw = (ImageView) getView().findViewById(R.id.ala_enter_effect_download_img);
            this.frx = (ProgressBar) getView().findViewById(R.id.ala_enter_effect_loading);
            this.ePG = getView().findViewById(R.id.ala_header_cover);
            this.fry = getView().findViewById(R.id.ala_enter_effect_img_layout);
            this.frz = (TextView) getView().findViewById(R.id.ala_enter_effect_description);
        }
    }
}
