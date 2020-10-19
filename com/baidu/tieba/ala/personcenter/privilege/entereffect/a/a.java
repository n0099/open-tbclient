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
public class a extends com.baidu.adp.widget.ListView.a<AlaEnterEffectData, C0673a> {
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
    /* renamed from: aO */
    public C0673a c(ViewGroup viewGroup) {
        return new C0673a(LayoutInflater.from(this.mContext).inflate(R.layout.ala_enter_effect_item_layout, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, AlaEnterEffectData alaEnterEffectData, C0673a c0673a) {
        c0673a.hph.startLoad(alaEnterEffectData.thumbnail_url, 10, false);
        c0673a.hpi.setText(alaEnterEffectData.name);
        if (alaEnterEffectData.isUsing()) {
            ap.setViewTextColor(c0673a.hpj, R.color.live_cp_other_b, 1, this.mSkinType);
            ap.setBackgroundResource(c0673a.hpj, R.drawable.ala_enter_effect_use_bg, this.mSkinType);
            c0673a.hpj.setText(this.mContext.getString(R.string.ala_enter_effect_use));
            c0673a.hph.setAlpha(1.0f);
        } else if (alaEnterEffectData.isOwn) {
            ap.setViewTextColor(c0673a.hpj, R.color.cp_link_tip_a, 1, this.mSkinType);
            ap.setBackgroundResource(c0673a.hpj, R.drawable.ala_enter_effect_own_bg, this.mSkinType);
            c0673a.hpj.setText(this.mContext.getString(R.string.ala_enter_effect_own));
            c0673a.hph.setAlpha(1.0f);
        } else {
            ap.setViewTextColor(c0673a.hpj, R.color.cp_cont_d, 1, this.mSkinType);
            ap.setBackgroundResource(c0673a.hpj, R.drawable.ala_enter_effect_not_own_bg, this.mSkinType);
            c0673a.hpj.setText(this.mContext.getString(R.string.ala_enter_effect_not_own));
            c0673a.hph.setAlpha(0.7f);
        }
        c0673a.hpk.setText(this.mContext.getResources().getString(R.string.ala_left_time, at.cU((alaEnterEffectData.end_time * 1000) - System.currentTimeMillis())));
        if (alaEnterEffectData.downLoadStatus == 100) {
            c0673a.hpl.setVisibility(0);
            c0673a.glV.setVisibility(8);
        } else if (alaEnterEffectData.downLoadStatus == 102) {
            c0673a.hpl.setVisibility(8);
            c0673a.glV.setVisibility(0);
        } else {
            c0673a.hpl.setVisibility(8);
            c0673a.glV.setVisibility(8);
        }
        c0673a.hpm.setBackgroundColor(Color.parseColor(alaEnterEffectData.color));
        ap.setViewTextColor(c0673a.eEL, R.color.cp_cont_d, 1, this.mSkinType);
        if (2 == alaEnterEffectData.categoryType) {
            ap.setViewTextColor(c0673a.eEL, R.color.cp_link_tip_d, 1, this.mSkinType);
            c0673a.eEL.setText(this.mContext.getString(R.string.ala_enter_effect_tdou_des, AlaStringHelper.formatLowercasekDou(alaEnterEffectData.price), alaEnterEffectData.time));
            Drawable drawable = ap.getDrawable(R.drawable.icon_huobi_tdou);
            int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds24);
            drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            c0673a.eEL.setCompoundDrawablePadding(this.mContext.getResources().getDimensionPixelSize(R.dimen.ds4));
            c0673a.eEL.setCompoundDrawables(drawable, null, null, null);
        } else {
            c0673a.eEL.setText(alaEnterEffectData.obtain_way);
            c0673a.eEL.setCompoundDrawables(null, null, null, null);
        }
        a(c0673a);
        return c0673a.getView();
    }

    private void a(C0673a c0673a) {
        if (c0673a != null) {
            ap.setBackgroundResource(c0673a.getView(), R.color.cp_bg_line_d);
            ap.setViewTextColor(c0673a.hpk, R.color.cp_cont_d, 1, this.mSkinType);
            ap.setViewTextColor(c0673a.hpi, R.color.cp_cont_b, 1, this.mSkinType);
            if (this.mSkinType == 1) {
                c0673a.gJq.setVisibility(0);
            } else {
                c0673a.gJq.setVisibility(8);
            }
        }
    }

    /* renamed from: com.baidu.tieba.ala.personcenter.privilege.entereffect.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0673a extends af.a {
        public TextView eEL;
        public View gJq;
        public ProgressBar glV;
        public TbImageView hph;
        public TextView hpi;
        public TextView hpj;
        public TextView hpk;
        public ImageView hpl;
        public View hpm;

        public C0673a(View view) {
            super(view);
            initView();
        }

        private void initView() {
            this.hph = (TbImageView) getView().findViewById(R.id.ala_enter_effect_img);
            this.hph.setAutoChangeStyle(false);
            this.hpi = (TextView) getView().findViewById(R.id.ala_enter_effect_name);
            this.hpj = (TextView) getView().findViewById(R.id.ala_enter_effect_status);
            this.hpk = (TextView) getView().findViewById(R.id.ala_enter_effect_time_limit);
            this.hpl = (ImageView) getView().findViewById(R.id.ala_enter_effect_download_img);
            this.glV = (ProgressBar) getView().findViewById(R.id.ala_enter_effect_loading);
            this.gJq = getView().findViewById(R.id.ala_header_cover);
            this.hpm = getView().findViewById(R.id.ala_enter_effect_img_layout);
            this.eEL = (TextView) getView().findViewById(R.id.ala_enter_effect_description);
        }
    }
}
