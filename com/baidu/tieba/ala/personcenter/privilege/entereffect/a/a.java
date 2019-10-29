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
/* loaded from: classes6.dex */
public class a extends com.baidu.adp.widget.ListView.a<AlaEnterEffectData, C0387a> {
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
    /* renamed from: at */
    public C0387a b(ViewGroup viewGroup) {
        return new C0387a(LayoutInflater.from(this.mContext).inflate(R.layout.ala_enter_effect_item_layout, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, AlaEnterEffectData alaEnterEffectData, C0387a c0387a) {
        c0387a.eAI.startLoad(alaEnterEffectData.thumbnail_url, 10, false);
        c0387a.eAJ.setText(alaEnterEffectData.name);
        if (alaEnterEffectData.isUsing()) {
            am.setViewTextColor(c0387a.eAK, R.color.live_cp_other_b, 1, this.mSkinType);
            am.setBackgroundResource(c0387a.eAK, R.drawable.ala_enter_effect_use_bg, this.mSkinType);
            c0387a.eAK.setText(this.mContext.getString(R.string.ala_enter_effect_use));
            c0387a.eAI.setAlpha(1.0f);
        } else if (alaEnterEffectData.isOwn) {
            am.setViewTextColor(c0387a.eAK, R.color.cp_link_tip_a, 1, this.mSkinType);
            am.setBackgroundResource(c0387a.eAK, R.drawable.ala_enter_effect_own_bg, this.mSkinType);
            c0387a.eAK.setText(this.mContext.getString(R.string.ala_enter_effect_own));
            c0387a.eAI.setAlpha(1.0f);
        } else {
            am.setViewTextColor(c0387a.eAK, R.color.cp_cont_d, 1, this.mSkinType);
            am.setBackgroundResource(c0387a.eAK, R.drawable.ala_enter_effect_not_own_bg, this.mSkinType);
            c0387a.eAK.setText(this.mContext.getString(R.string.ala_enter_effect_not_own));
            c0387a.eAI.setAlpha(0.7f);
        }
        c0387a.eAL.setText(this.mContext.getResources().getString(R.string.ala_left_time, aq.aR((alaEnterEffectData.end_time * 1000) - System.currentTimeMillis())));
        if (alaEnterEffectData.downLoadStatus == 100) {
            c0387a.eAM.setVisibility(0);
            c0387a.eAN.setVisibility(8);
        } else if (alaEnterEffectData.downLoadStatus == 102) {
            c0387a.eAM.setVisibility(8);
            c0387a.eAN.setVisibility(0);
        } else {
            c0387a.eAM.setVisibility(8);
            c0387a.eAN.setVisibility(8);
        }
        c0387a.eAO.setBackgroundColor(Color.parseColor(alaEnterEffectData.color));
        am.setViewTextColor(c0387a.eAP, R.color.cp_cont_d, 1, this.mSkinType);
        if (2 == alaEnterEffectData.categoryType) {
            am.setViewTextColor(c0387a.eAP, R.color.cp_link_tip_d, 1, this.mSkinType);
            c0387a.eAP.setText(this.mContext.getString(R.string.ala_enter_effect_tdou_des, AlaStringHelper.formatLowercasekDou(alaEnterEffectData.price), alaEnterEffectData.time));
            Drawable drawable = am.getDrawable(R.drawable.icon_huobi_tdou);
            int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds24);
            drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            c0387a.eAP.setCompoundDrawablePadding(this.mContext.getResources().getDimensionPixelSize(R.dimen.ds4));
            c0387a.eAP.setCompoundDrawables(drawable, null, null, null);
        } else {
            c0387a.eAP.setText(alaEnterEffectData.obtain_way);
            c0387a.eAP.setCompoundDrawables(null, null, null, null);
        }
        a(c0387a);
        return c0387a.getView();
    }

    private void a(C0387a c0387a) {
        if (c0387a != null) {
            am.setBackgroundResource(c0387a.getView(), R.color.cp_bg_line_d);
            am.setViewTextColor(c0387a.eAL, R.color.cp_cont_d, 1, this.mSkinType);
            am.setViewTextColor(c0387a.eAJ, R.color.cp_cont_b, 1, this.mSkinType);
            if (this.mSkinType == 1) {
                c0387a.eaA.setVisibility(0);
            } else {
                c0387a.eaA.setVisibility(8);
            }
        }
    }

    /* renamed from: com.baidu.tieba.ala.personcenter.privilege.entereffect.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0387a extends v.a {
        public TbImageView eAI;
        public TextView eAJ;
        public TextView eAK;
        public TextView eAL;
        public ImageView eAM;
        public ProgressBar eAN;
        public View eAO;
        public TextView eAP;
        public View eaA;

        public C0387a(View view) {
            super(view);
            initView();
        }

        private void initView() {
            this.eAI = (TbImageView) getView().findViewById(R.id.ala_enter_effect_img);
            this.eAI.setAutoChangeStyle(false);
            this.eAJ = (TextView) getView().findViewById(R.id.ala_enter_effect_name);
            this.eAK = (TextView) getView().findViewById(R.id.ala_enter_effect_status);
            this.eAL = (TextView) getView().findViewById(R.id.ala_enter_effect_time_limit);
            this.eAM = (ImageView) getView().findViewById(R.id.ala_enter_effect_download_img);
            this.eAN = (ProgressBar) getView().findViewById(R.id.ala_enter_effect_loading);
            this.eaA = getView().findViewById(R.id.ala_header_cover);
            this.eAO = getView().findViewById(R.id.ala_enter_effect_img_layout);
            this.eAP = (TextView) getView().findViewById(R.id.ala_enter_effect_description);
        }
    }
}
