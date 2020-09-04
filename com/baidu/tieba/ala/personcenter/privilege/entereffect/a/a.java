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
public class a extends com.baidu.adp.widget.ListView.a<AlaEnterEffectData, C0658a> {
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
    public C0658a b(ViewGroup viewGroup) {
        return new C0658a(LayoutInflater.from(this.mContext).inflate(R.layout.ala_enter_effect_item_layout, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, AlaEnterEffectData alaEnterEffectData, C0658a c0658a) {
        c0658a.gWz.startLoad(alaEnterEffectData.thumbnail_url, 10, false);
        c0658a.gWA.setText(alaEnterEffectData.name);
        if (alaEnterEffectData.isUsing()) {
            ap.setViewTextColor(c0658a.gWB, R.color.live_cp_other_b, 1, this.mSkinType);
            ap.setBackgroundResource(c0658a.gWB, R.drawable.ala_enter_effect_use_bg, this.mSkinType);
            c0658a.gWB.setText(this.mContext.getString(R.string.ala_enter_effect_use));
            c0658a.gWz.setAlpha(1.0f);
        } else if (alaEnterEffectData.isOwn) {
            ap.setViewTextColor(c0658a.gWB, R.color.cp_link_tip_a, 1, this.mSkinType);
            ap.setBackgroundResource(c0658a.gWB, R.drawable.ala_enter_effect_own_bg, this.mSkinType);
            c0658a.gWB.setText(this.mContext.getString(R.string.ala_enter_effect_own));
            c0658a.gWz.setAlpha(1.0f);
        } else {
            ap.setViewTextColor(c0658a.gWB, R.color.cp_cont_d, 1, this.mSkinType);
            ap.setBackgroundResource(c0658a.gWB, R.drawable.ala_enter_effect_not_own_bg, this.mSkinType);
            c0658a.gWB.setText(this.mContext.getString(R.string.ala_enter_effect_not_own));
            c0658a.gWz.setAlpha(0.7f);
        }
        c0658a.gWC.setText(this.mContext.getResources().getString(R.string.ala_left_time, at.cL((alaEnterEffectData.end_time * 1000) - System.currentTimeMillis())));
        if (alaEnterEffectData.downLoadStatus == 100) {
            c0658a.gWD.setVisibility(0);
            c0658a.fWq.setVisibility(8);
        } else if (alaEnterEffectData.downLoadStatus == 102) {
            c0658a.gWD.setVisibility(8);
            c0658a.fWq.setVisibility(0);
        } else {
            c0658a.gWD.setVisibility(8);
            c0658a.fWq.setVisibility(8);
        }
        c0658a.gWE.setBackgroundColor(Color.parseColor(alaEnterEffectData.color));
        ap.setViewTextColor(c0658a.eqv, R.color.cp_cont_d, 1, this.mSkinType);
        if (2 == alaEnterEffectData.categoryType) {
            ap.setViewTextColor(c0658a.eqv, R.color.cp_link_tip_d, 1, this.mSkinType);
            c0658a.eqv.setText(this.mContext.getString(R.string.ala_enter_effect_tdou_des, AlaStringHelper.formatLowercasekDou(alaEnterEffectData.price), alaEnterEffectData.time));
            Drawable drawable = ap.getDrawable(R.drawable.icon_huobi_tdou);
            int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds24);
            drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            c0658a.eqv.setCompoundDrawablePadding(this.mContext.getResources().getDimensionPixelSize(R.dimen.ds4));
            c0658a.eqv.setCompoundDrawables(drawable, null, null, null);
        } else {
            c0658a.eqv.setText(alaEnterEffectData.obtain_way);
            c0658a.eqv.setCompoundDrawables(null, null, null, null);
        }
        a(c0658a);
        return c0658a.getView();
    }

    private void a(C0658a c0658a) {
        if (c0658a != null) {
            ap.setBackgroundResource(c0658a.getView(), R.color.cp_bg_line_d);
            ap.setViewTextColor(c0658a.gWC, R.color.cp_cont_d, 1, this.mSkinType);
            ap.setViewTextColor(c0658a.gWA, R.color.cp_cont_b, 1, this.mSkinType);
            if (this.mSkinType == 1) {
                c0658a.grz.setVisibility(0);
            } else {
                c0658a.grz.setVisibility(8);
            }
        }
    }

    /* renamed from: com.baidu.tieba.ala.personcenter.privilege.entereffect.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0658a extends af.a {
        public TextView eqv;
        public ProgressBar fWq;
        public TextView gWA;
        public TextView gWB;
        public TextView gWC;
        public ImageView gWD;
        public View gWE;
        public TbImageView gWz;
        public View grz;

        public C0658a(View view) {
            super(view);
            initView();
        }

        private void initView() {
            this.gWz = (TbImageView) getView().findViewById(R.id.ala_enter_effect_img);
            this.gWz.setAutoChangeStyle(false);
            this.gWA = (TextView) getView().findViewById(R.id.ala_enter_effect_name);
            this.gWB = (TextView) getView().findViewById(R.id.ala_enter_effect_status);
            this.gWC = (TextView) getView().findViewById(R.id.ala_enter_effect_time_limit);
            this.gWD = (ImageView) getView().findViewById(R.id.ala_enter_effect_download_img);
            this.fWq = (ProgressBar) getView().findViewById(R.id.ala_enter_effect_loading);
            this.grz = getView().findViewById(R.id.ala_header_cover);
            this.gWE = getView().findViewById(R.id.ala_enter_effect_img_layout);
            this.eqv = (TextView) getView().findViewById(R.id.ala_enter_effect_description);
        }
    }
}
