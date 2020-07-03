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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.personcenter.privilege.entereffect.data.AlaEnterEffectData;
/* loaded from: classes3.dex */
public class a extends com.baidu.adp.widget.ListView.a<AlaEnterEffectData, C0599a> {
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
    /* renamed from: aL */
    public C0599a b(ViewGroup viewGroup) {
        return new C0599a(LayoutInflater.from(this.mContext).inflate(R.layout.ala_enter_effect_item_layout, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, AlaEnterEffectData alaEnterEffectData, C0599a c0599a) {
        c0599a.gEv.startLoad(alaEnterEffectData.thumbnail_url, 10, false);
        c0599a.gEw.setText(alaEnterEffectData.name);
        if (alaEnterEffectData.isUsing()) {
            an.setViewTextColor(c0599a.gEx, R.color.live_cp_other_b, 1, this.mSkinType);
            an.setBackgroundResource(c0599a.gEx, R.drawable.ala_enter_effect_use_bg, this.mSkinType);
            c0599a.gEx.setText(this.mContext.getString(R.string.ala_enter_effect_use));
            c0599a.gEv.setAlpha(1.0f);
        } else if (alaEnterEffectData.isOwn) {
            an.setViewTextColor(c0599a.gEx, R.color.cp_link_tip_a, 1, this.mSkinType);
            an.setBackgroundResource(c0599a.gEx, R.drawable.ala_enter_effect_own_bg, this.mSkinType);
            c0599a.gEx.setText(this.mContext.getString(R.string.ala_enter_effect_own));
            c0599a.gEv.setAlpha(1.0f);
        } else {
            an.setViewTextColor(c0599a.gEx, R.color.cp_cont_d, 1, this.mSkinType);
            an.setBackgroundResource(c0599a.gEx, R.drawable.ala_enter_effect_not_own_bg, this.mSkinType);
            c0599a.gEx.setText(this.mContext.getString(R.string.ala_enter_effect_not_own));
            c0599a.gEv.setAlpha(0.7f);
        }
        c0599a.gEy.setText(this.mContext.getResources().getString(R.string.ala_left_time, ar.cj((alaEnterEffectData.end_time * 1000) - System.currentTimeMillis())));
        if (alaEnterEffectData.downLoadStatus == 100) {
            c0599a.gEz.setVisibility(0);
            c0599a.gEA.setVisibility(8);
        } else if (alaEnterEffectData.downLoadStatus == 102) {
            c0599a.gEz.setVisibility(8);
            c0599a.gEA.setVisibility(0);
        } else {
            c0599a.gEz.setVisibility(8);
            c0599a.gEA.setVisibility(8);
        }
        c0599a.gEB.setBackgroundColor(Color.parseColor(alaEnterEffectData.color));
        an.setViewTextColor(c0599a.eaz, R.color.cp_cont_d, 1, this.mSkinType);
        if (2 == alaEnterEffectData.categoryType) {
            an.setViewTextColor(c0599a.eaz, R.color.cp_link_tip_d, 1, this.mSkinType);
            c0599a.eaz.setText(this.mContext.getString(R.string.ala_enter_effect_tdou_des, AlaStringHelper.formatLowercasekDou(alaEnterEffectData.price), alaEnterEffectData.time));
            Drawable drawable = an.getDrawable(R.drawable.icon_huobi_tdou);
            int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds24);
            drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            c0599a.eaz.setCompoundDrawablePadding(this.mContext.getResources().getDimensionPixelSize(R.dimen.ds4));
            c0599a.eaz.setCompoundDrawables(drawable, null, null, null);
        } else {
            c0599a.eaz.setText(alaEnterEffectData.obtain_way);
            c0599a.eaz.setCompoundDrawables(null, null, null, null);
        }
        a(c0599a);
        return c0599a.getView();
    }

    private void a(C0599a c0599a) {
        if (c0599a != null) {
            an.setBackgroundResource(c0599a.getView(), R.color.cp_bg_line_d);
            an.setViewTextColor(c0599a.gEy, R.color.cp_cont_d, 1, this.mSkinType);
            an.setViewTextColor(c0599a.gEw, R.color.cp_cont_b, 1, this.mSkinType);
            if (this.mSkinType == 1) {
                c0599a.gaf.setVisibility(0);
            } else {
                c0599a.gaf.setVisibility(8);
            }
        }
    }

    /* renamed from: com.baidu.tieba.ala.personcenter.privilege.entereffect.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0599a extends ad.a {
        public TextView eaz;
        public ProgressBar gEA;
        public View gEB;
        public TbImageView gEv;
        public TextView gEw;
        public TextView gEx;
        public TextView gEy;
        public ImageView gEz;
        public View gaf;

        public C0599a(View view) {
            super(view);
            initView();
        }

        private void initView() {
            this.gEv = (TbImageView) getView().findViewById(R.id.ala_enter_effect_img);
            this.gEv.setAutoChangeStyle(false);
            this.gEw = (TextView) getView().findViewById(R.id.ala_enter_effect_name);
            this.gEx = (TextView) getView().findViewById(R.id.ala_enter_effect_status);
            this.gEy = (TextView) getView().findViewById(R.id.ala_enter_effect_time_limit);
            this.gEz = (ImageView) getView().findViewById(R.id.ala_enter_effect_download_img);
            this.gEA = (ProgressBar) getView().findViewById(R.id.ala_enter_effect_loading);
            this.gaf = getView().findViewById(R.id.ala_header_cover);
            this.gEB = getView().findViewById(R.id.ala_enter_effect_img_layout);
            this.eaz = (TextView) getView().findViewById(R.id.ala_enter_effect_description);
        }
    }
}
