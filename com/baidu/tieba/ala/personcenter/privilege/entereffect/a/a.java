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
import com.baidu.adp.widget.ListView.y;
import com.baidu.ala.utils.AlaStringHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.personcenter.privilege.entereffect.data.AlaEnterEffectData;
/* loaded from: classes3.dex */
public class a extends com.baidu.adp.widget.ListView.a<AlaEnterEffectData, C0540a> {
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
    /* renamed from: ay */
    public C0540a b(ViewGroup viewGroup) {
        return new C0540a(LayoutInflater.from(this.mContext).inflate(R.layout.ala_enter_effect_item_layout, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, AlaEnterEffectData alaEnterEffectData, C0540a c0540a) {
        c0540a.gcB.startLoad(alaEnterEffectData.thumbnail_url, 10, false);
        c0540a.gcC.setText(alaEnterEffectData.name);
        if (alaEnterEffectData.isUsing()) {
            am.setViewTextColor(c0540a.gcD, R.color.live_cp_other_b, 1, this.mSkinType);
            am.setBackgroundResource(c0540a.gcD, R.drawable.ala_enter_effect_use_bg, this.mSkinType);
            c0540a.gcD.setText(this.mContext.getString(R.string.ala_enter_effect_use));
            c0540a.gcB.setAlpha(1.0f);
        } else if (alaEnterEffectData.isOwn) {
            am.setViewTextColor(c0540a.gcD, R.color.cp_link_tip_a, 1, this.mSkinType);
            am.setBackgroundResource(c0540a.gcD, R.drawable.ala_enter_effect_own_bg, this.mSkinType);
            c0540a.gcD.setText(this.mContext.getString(R.string.ala_enter_effect_own));
            c0540a.gcB.setAlpha(1.0f);
        } else {
            am.setViewTextColor(c0540a.gcD, R.color.cp_cont_d, 1, this.mSkinType);
            am.setBackgroundResource(c0540a.gcD, R.drawable.ala_enter_effect_not_own_bg, this.mSkinType);
            c0540a.gcD.setText(this.mContext.getString(R.string.ala_enter_effect_not_own));
            c0540a.gcB.setAlpha(0.7f);
        }
        c0540a.gcE.setText(this.mContext.getResources().getString(R.string.ala_left_time, aq.ci((alaEnterEffectData.end_time * 1000) - System.currentTimeMillis())));
        if (alaEnterEffectData.downLoadStatus == 100) {
            c0540a.gcF.setVisibility(0);
            c0540a.gcG.setVisibility(8);
        } else if (alaEnterEffectData.downLoadStatus == 102) {
            c0540a.gcF.setVisibility(8);
            c0540a.gcG.setVisibility(0);
        } else {
            c0540a.gcF.setVisibility(8);
            c0540a.gcG.setVisibility(8);
        }
        c0540a.gcH.setBackgroundColor(Color.parseColor(alaEnterEffectData.color));
        am.setViewTextColor(c0540a.gcI, R.color.cp_cont_d, 1, this.mSkinType);
        if (2 == alaEnterEffectData.categoryType) {
            am.setViewTextColor(c0540a.gcI, R.color.cp_link_tip_d, 1, this.mSkinType);
            c0540a.gcI.setText(this.mContext.getString(R.string.ala_enter_effect_tdou_des, AlaStringHelper.formatLowercasekDou(alaEnterEffectData.price), alaEnterEffectData.time));
            Drawable drawable = am.getDrawable(R.drawable.icon_huobi_tdou);
            int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds24);
            drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            c0540a.gcI.setCompoundDrawablePadding(this.mContext.getResources().getDimensionPixelSize(R.dimen.ds4));
            c0540a.gcI.setCompoundDrawables(drawable, null, null, null);
        } else {
            c0540a.gcI.setText(alaEnterEffectData.obtain_way);
            c0540a.gcI.setCompoundDrawables(null, null, null, null);
        }
        a(c0540a);
        return c0540a.getView();
    }

    private void a(C0540a c0540a) {
        if (c0540a != null) {
            am.setBackgroundResource(c0540a.getView(), R.color.cp_bg_line_d);
            am.setViewTextColor(c0540a.gcE, R.color.cp_cont_d, 1, this.mSkinType);
            am.setViewTextColor(c0540a.gcC, R.color.cp_cont_b, 1, this.mSkinType);
            if (this.mSkinType == 1) {
                c0540a.fAb.setVisibility(0);
            } else {
                c0540a.fAb.setVisibility(8);
            }
        }
    }

    /* renamed from: com.baidu.tieba.ala.personcenter.privilege.entereffect.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0540a extends y.a {
        public View fAb;
        public TbImageView gcB;
        public TextView gcC;
        public TextView gcD;
        public TextView gcE;
        public ImageView gcF;
        public ProgressBar gcG;
        public View gcH;
        public TextView gcI;

        public C0540a(View view) {
            super(view);
            initView();
        }

        private void initView() {
            this.gcB = (TbImageView) getView().findViewById(R.id.ala_enter_effect_img);
            this.gcB.setAutoChangeStyle(false);
            this.gcC = (TextView) getView().findViewById(R.id.ala_enter_effect_name);
            this.gcD = (TextView) getView().findViewById(R.id.ala_enter_effect_status);
            this.gcE = (TextView) getView().findViewById(R.id.ala_enter_effect_time_limit);
            this.gcF = (ImageView) getView().findViewById(R.id.ala_enter_effect_download_img);
            this.gcG = (ProgressBar) getView().findViewById(R.id.ala_enter_effect_loading);
            this.fAb = getView().findViewById(R.id.ala_header_cover);
            this.gcH = getView().findViewById(R.id.ala_enter_effect_img_layout);
            this.gcI = (TextView) getView().findViewById(R.id.ala_enter_effect_description);
        }
    }
}
