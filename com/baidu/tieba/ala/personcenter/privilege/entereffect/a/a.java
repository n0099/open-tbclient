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
public class a extends com.baidu.adp.widget.ListView.a<AlaEnterEffectData, C0475a> {
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
    /* renamed from: aw */
    public C0475a b(ViewGroup viewGroup) {
        return new C0475a(LayoutInflater.from(this.mContext).inflate(R.layout.ala_enter_effect_item_layout, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, AlaEnterEffectData alaEnterEffectData, C0475a c0475a) {
        c0475a.fuB.startLoad(alaEnterEffectData.thumbnail_url, 10, false);
        c0475a.fuC.setText(alaEnterEffectData.name);
        if (alaEnterEffectData.isUsing()) {
            am.setViewTextColor(c0475a.fuD, R.color.live_cp_other_b, 1, this.mSkinType);
            am.setBackgroundResource(c0475a.fuD, R.drawable.ala_enter_effect_use_bg, this.mSkinType);
            c0475a.fuD.setText(this.mContext.getString(R.string.ala_enter_effect_use));
            c0475a.fuB.setAlpha(1.0f);
        } else if (alaEnterEffectData.isOwn) {
            am.setViewTextColor(c0475a.fuD, R.color.cp_link_tip_a, 1, this.mSkinType);
            am.setBackgroundResource(c0475a.fuD, R.drawable.ala_enter_effect_own_bg, this.mSkinType);
            c0475a.fuD.setText(this.mContext.getString(R.string.ala_enter_effect_own));
            c0475a.fuB.setAlpha(1.0f);
        } else {
            am.setViewTextColor(c0475a.fuD, R.color.cp_cont_d, 1, this.mSkinType);
            am.setBackgroundResource(c0475a.fuD, R.drawable.ala_enter_effect_not_own_bg, this.mSkinType);
            c0475a.fuD.setText(this.mContext.getString(R.string.ala_enter_effect_not_own));
            c0475a.fuB.setAlpha(0.7f);
        }
        c0475a.fuE.setText(this.mContext.getResources().getString(R.string.ala_left_time, aq.by((alaEnterEffectData.end_time * 1000) - System.currentTimeMillis())));
        if (alaEnterEffectData.downLoadStatus == 100) {
            c0475a.fuF.setVisibility(0);
            c0475a.fuG.setVisibility(8);
        } else if (alaEnterEffectData.downLoadStatus == 102) {
            c0475a.fuF.setVisibility(8);
            c0475a.fuG.setVisibility(0);
        } else {
            c0475a.fuF.setVisibility(8);
            c0475a.fuG.setVisibility(8);
        }
        c0475a.fuH.setBackgroundColor(Color.parseColor(alaEnterEffectData.color));
        am.setViewTextColor(c0475a.fuI, R.color.cp_cont_d, 1, this.mSkinType);
        if (2 == alaEnterEffectData.categoryType) {
            am.setViewTextColor(c0475a.fuI, R.color.cp_link_tip_d, 1, this.mSkinType);
            c0475a.fuI.setText(this.mContext.getString(R.string.ala_enter_effect_tdou_des, AlaStringHelper.formatLowercasekDou(alaEnterEffectData.price), alaEnterEffectData.time));
            Drawable drawable = am.getDrawable(R.drawable.icon_huobi_tdou);
            int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds24);
            drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            c0475a.fuI.setCompoundDrawablePadding(this.mContext.getResources().getDimensionPixelSize(R.dimen.ds4));
            c0475a.fuI.setCompoundDrawables(drawable, null, null, null);
        } else {
            c0475a.fuI.setText(alaEnterEffectData.obtain_way);
            c0475a.fuI.setCompoundDrawables(null, null, null, null);
        }
        a(c0475a);
        return c0475a.getView();
    }

    private void a(C0475a c0475a) {
        if (c0475a != null) {
            am.setBackgroundResource(c0475a.getView(), R.color.cp_bg_line_d);
            am.setViewTextColor(c0475a.fuE, R.color.cp_cont_d, 1, this.mSkinType);
            am.setViewTextColor(c0475a.fuC, R.color.cp_cont_b, 1, this.mSkinType);
            if (this.mSkinType == 1) {
                c0475a.eRf.setVisibility(0);
            } else {
                c0475a.eRf.setVisibility(8);
            }
        }
    }

    /* renamed from: com.baidu.tieba.ala.personcenter.privilege.entereffect.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0475a extends v.a {
        public View eRf;
        public TbImageView fuB;
        public TextView fuC;
        public TextView fuD;
        public TextView fuE;
        public ImageView fuF;
        public ProgressBar fuG;
        public View fuH;
        public TextView fuI;

        public C0475a(View view) {
            super(view);
            initView();
        }

        private void initView() {
            this.fuB = (TbImageView) getView().findViewById(R.id.ala_enter_effect_img);
            this.fuB.setAutoChangeStyle(false);
            this.fuC = (TextView) getView().findViewById(R.id.ala_enter_effect_name);
            this.fuD = (TextView) getView().findViewById(R.id.ala_enter_effect_status);
            this.fuE = (TextView) getView().findViewById(R.id.ala_enter_effect_time_limit);
            this.fuF = (ImageView) getView().findViewById(R.id.ala_enter_effect_download_img);
            this.fuG = (ProgressBar) getView().findViewById(R.id.ala_enter_effect_loading);
            this.eRf = getView().findViewById(R.id.ala_header_cover);
            this.fuH = getView().findViewById(R.id.ala_enter_effect_img_layout);
            this.fuI = (TextView) getView().findViewById(R.id.ala_enter_effect_description);
        }
    }
}
