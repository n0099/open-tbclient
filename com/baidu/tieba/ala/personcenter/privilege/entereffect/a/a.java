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
public class a extends com.baidu.adp.widget.ListView.a<AlaEnterEffectData, C0519a> {
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
    public C0519a b(ViewGroup viewGroup) {
        return new C0519a(LayoutInflater.from(this.mContext).inflate(R.layout.ala_enter_effect_item_layout, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, AlaEnterEffectData alaEnterEffectData, C0519a c0519a) {
        c0519a.gcw.startLoad(alaEnterEffectData.thumbnail_url, 10, false);
        c0519a.gcx.setText(alaEnterEffectData.name);
        if (alaEnterEffectData.isUsing()) {
            am.setViewTextColor(c0519a.gcy, R.color.live_cp_other_b, 1, this.mSkinType);
            am.setBackgroundResource(c0519a.gcy, R.drawable.ala_enter_effect_use_bg, this.mSkinType);
            c0519a.gcy.setText(this.mContext.getString(R.string.ala_enter_effect_use));
            c0519a.gcw.setAlpha(1.0f);
        } else if (alaEnterEffectData.isOwn) {
            am.setViewTextColor(c0519a.gcy, R.color.cp_link_tip_a, 1, this.mSkinType);
            am.setBackgroundResource(c0519a.gcy, R.drawable.ala_enter_effect_own_bg, this.mSkinType);
            c0519a.gcy.setText(this.mContext.getString(R.string.ala_enter_effect_own));
            c0519a.gcw.setAlpha(1.0f);
        } else {
            am.setViewTextColor(c0519a.gcy, R.color.cp_cont_d, 1, this.mSkinType);
            am.setBackgroundResource(c0519a.gcy, R.drawable.ala_enter_effect_not_own_bg, this.mSkinType);
            c0519a.gcy.setText(this.mContext.getString(R.string.ala_enter_effect_not_own));
            c0519a.gcw.setAlpha(0.7f);
        }
        c0519a.gcz.setText(this.mContext.getResources().getString(R.string.ala_left_time, aq.ci((alaEnterEffectData.end_time * 1000) - System.currentTimeMillis())));
        if (alaEnterEffectData.downLoadStatus == 100) {
            c0519a.gcA.setVisibility(0);
            c0519a.gcB.setVisibility(8);
        } else if (alaEnterEffectData.downLoadStatus == 102) {
            c0519a.gcA.setVisibility(8);
            c0519a.gcB.setVisibility(0);
        } else {
            c0519a.gcA.setVisibility(8);
            c0519a.gcB.setVisibility(8);
        }
        c0519a.gcC.setBackgroundColor(Color.parseColor(alaEnterEffectData.color));
        am.setViewTextColor(c0519a.gcD, R.color.cp_cont_d, 1, this.mSkinType);
        if (2 == alaEnterEffectData.categoryType) {
            am.setViewTextColor(c0519a.gcD, R.color.cp_link_tip_d, 1, this.mSkinType);
            c0519a.gcD.setText(this.mContext.getString(R.string.ala_enter_effect_tdou_des, AlaStringHelper.formatLowercasekDou(alaEnterEffectData.price), alaEnterEffectData.time));
            Drawable drawable = am.getDrawable(R.drawable.icon_huobi_tdou);
            int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds24);
            drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            c0519a.gcD.setCompoundDrawablePadding(this.mContext.getResources().getDimensionPixelSize(R.dimen.ds4));
            c0519a.gcD.setCompoundDrawables(drawable, null, null, null);
        } else {
            c0519a.gcD.setText(alaEnterEffectData.obtain_way);
            c0519a.gcD.setCompoundDrawables(null, null, null, null);
        }
        a(c0519a);
        return c0519a.getView();
    }

    private void a(C0519a c0519a) {
        if (c0519a != null) {
            am.setBackgroundResource(c0519a.getView(), R.color.cp_bg_line_d);
            am.setViewTextColor(c0519a.gcz, R.color.cp_cont_d, 1, this.mSkinType);
            am.setViewTextColor(c0519a.gcx, R.color.cp_cont_b, 1, this.mSkinType);
            if (this.mSkinType == 1) {
                c0519a.fzW.setVisibility(0);
            } else {
                c0519a.fzW.setVisibility(8);
            }
        }
    }

    /* renamed from: com.baidu.tieba.ala.personcenter.privilege.entereffect.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0519a extends y.a {
        public View fzW;
        public ImageView gcA;
        public ProgressBar gcB;
        public View gcC;
        public TextView gcD;
        public TbImageView gcw;
        public TextView gcx;
        public TextView gcy;
        public TextView gcz;

        public C0519a(View view) {
            super(view);
            initView();
        }

        private void initView() {
            this.gcw = (TbImageView) getView().findViewById(R.id.ala_enter_effect_img);
            this.gcw.setAutoChangeStyle(false);
            this.gcx = (TextView) getView().findViewById(R.id.ala_enter_effect_name);
            this.gcy = (TextView) getView().findViewById(R.id.ala_enter_effect_status);
            this.gcz = (TextView) getView().findViewById(R.id.ala_enter_effect_time_limit);
            this.gcA = (ImageView) getView().findViewById(R.id.ala_enter_effect_download_img);
            this.gcB = (ProgressBar) getView().findViewById(R.id.ala_enter_effect_loading);
            this.fzW = getView().findViewById(R.id.ala_header_cover);
            this.gcC = getView().findViewById(R.id.ala_enter_effect_img_layout);
            this.gcD = (TextView) getView().findViewById(R.id.ala_enter_effect_description);
        }
    }
}
