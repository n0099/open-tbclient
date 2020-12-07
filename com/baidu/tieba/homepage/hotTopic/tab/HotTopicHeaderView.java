package com.baidu.tieba.homepage.hotTopic.tab;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.tbadk.a.d;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.h.f;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.hotTopic.tab.view.HotTopicTabRankListLayout;
import tbclient.HotThreadList.HotThreadListResIdl;
/* loaded from: classes22.dex */
public class HotTopicHeaderView extends LinearLayout {
    protected f ajQ;
    private EMTextView jBN;
    private RelativeLayout jPD;
    private HotTopicTabRankListLayout jPE;
    private EMTextView jPF;
    private EMTextView jPG;
    private com.baidu.tieba.homepage.hotTopic.tab.view.a jPH;
    private LinearLayout jPI;
    private int mSkinType;

    public void setOnItemCoverListener(f fVar) {
        this.ajQ = fVar;
    }

    public HotTopicHeaderView(Context context) {
        super(context);
        this.mSkinType = 3;
        initView();
    }

    public HotTopicHeaderView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        initView();
    }

    public HotTopicHeaderView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        initView();
    }

    private void initView() {
        int dimenPixelSize;
        int dimenPixelSize2;
        setOrientation(1);
        this.jPD = new RelativeLayout(getContext());
        int dimenPixelSize3 = UtilHelper.getDimenPixelSize(R.dimen.M_W_X003);
        int dimenPixelSize4 = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
        int dimenPixelSize5 = UtilHelper.getDimenPixelSize(R.dimen.M_W_X007);
        int dimenPixelSize6 = UtilHelper.getDimenPixelSize(R.dimen.M_W_X005);
        int dimenPixelSize7 = UtilHelper.getDimenPixelSize(R.dimen.M_H_X005);
        int dimenPixelSize8 = UtilHelper.getDimenPixelSize(R.dimen.M_H_X004);
        this.jPF = new EMTextView(getContext());
        this.jPF.setId(R.id.title_id);
        com.baidu.tbadk.core.elementsMaven.c.bm(this.jPF).ps(R.color.CAM_X0105).pt(R.dimen.T_X07).pu(R.string.F_X02);
        this.jPF.setText(getString(R.string.hot_topic_tab_rank_list_title));
        this.jPF.setMaxLines(1);
        this.jPF.setEllipsize(TextUtils.TruncateAt.END);
        if (d.bkA()) {
            this.jPF.setPadding(dimenPixelSize5, dimenPixelSize7, dimenPixelSize5, dimenPixelSize8);
        } else {
            this.jPF.setPadding(dimenPixelSize6, dimenPixelSize7, dimenPixelSize6, dimenPixelSize8);
        }
        this.jPD.addView(this.jPF, new RelativeLayout.LayoutParams(-1, -2));
        this.jPE = new HotTopicTabRankListLayout(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(3, R.id.title_id);
        this.jPD.addView(this.jPE, layoutParams);
        com.baidu.tbadk.core.elementsMaven.c.bm(this.jPD).pA(d.bkA() ? R.string.J_X02 : R.string.J_X06).setBackGroundColor(R.color.CAM_X0205);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        if (d.bkA()) {
            layoutParams2.topMargin = 0;
            this.jPD.setPadding(0, UtilHelper.getDimenPixelSize(R.dimen.M_H_X001), 0, dimenPixelSize8);
        } else {
            layoutParams2.topMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X003);
            this.jPD.setPadding(0, 0, 0, dimenPixelSize8);
        }
        addView(this.jPD, layoutParams2);
        this.jPI = new LinearLayout(getContext());
        this.jPI.setOrientation(0);
        EMTextView eMTextView = new EMTextView(getContext());
        com.baidu.tbadk.core.elementsMaven.c.bm(eMTextView).pt(R.dimen.T_X07).ps(R.color.CAM_X0105).pu(R.string.F_X02);
        eMTextView.setText(getString(R.string.hot_topic_hot_tie_title));
        eMTextView.setMaxLines(1);
        eMTextView.setEllipsize(TextUtils.TruncateAt.END);
        if (d.bkA()) {
            eMTextView.setPadding(dimenPixelSize5, 0, dimenPixelSize3, 0);
        } else {
            eMTextView.setPadding(dimenPixelSize5 - dimenPixelSize4, 0, dimenPixelSize3, 0);
        }
        this.jPI.addView(eMTextView);
        this.jBN = eMTextView;
        EMTextView eMTextView2 = new EMTextView(getContext());
        com.baidu.tbadk.core.elementsMaven.c.bm(eMTextView2).pt(R.dimen.T_X09).ps(R.color.CAM_X0109).pu(R.string.F_X01);
        eMTextView2.setText(getString(R.string.hot_topic_hot_tie_sub_title));
        eMTextView2.setMaxLines(1);
        eMTextView2.setEllipsize(TextUtils.TruncateAt.END);
        eMTextView2.setPadding(0, UtilHelper.getDimenPixelSize(R.dimen.M_H_X006) - dimenPixelSize7, 0, 0);
        this.jPI.addView(eMTextView2);
        this.jPG = eMTextView2;
        this.jPI.setPadding(0, dimenPixelSize7, 0, dimenPixelSize8);
        if (d.bkA()) {
            com.baidu.tbadk.core.elementsMaven.c.bm(this.jPI).setBackGroundColor(R.color.CAM_X0205);
        }
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        if (d.bkA()) {
            dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_H_X002);
        } else {
            dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_H_X003);
        }
        layoutParams3.topMargin = dimenPixelSize;
        addView(this.jPI, layoutParams3);
        this.jPH = new com.baidu.tieba.homepage.hotTopic.tab.view.a(getContext());
        addView(this.jPH.cPx());
        LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) this.jPH.cPx().getLayoutParams();
        layoutParams4.weight = -1.0f;
        if (d.bkA()) {
            dimenPixelSize2 = UtilHelper.getDimenPixelSize(R.dimen.tbds122);
        } else {
            dimenPixelSize2 = UtilHelper.getDimenPixelSize(R.dimen.tbds106);
        }
        layoutParams4.height = dimenPixelSize2;
        this.jPH.cPx().requestLayout();
    }

    private String getString(int i) {
        return TbadkCoreApplication.getInst().getString(i);
    }

    public void setData(HotThreadListResIdl hotThreadListResIdl) {
        if (hotThreadListResIdl != null && hotThreadListResIdl.data != null && !y.isEmpty(hotThreadListResIdl.data.topic_list)) {
            this.jPF.setVisibility(0);
            this.jPE.setVisibility(0);
            this.jPE.setOnItemCoverListener(this.ajQ);
            this.jPE.a(new com.baidu.tieba.homepage.hotTopic.tab.b.d(hotThreadListResIdl.data.topic_list));
        } else {
            this.jPF.setVisibility(8);
            this.jPE.setVisibility(8);
        }
        this.jBN.setVisibility(0);
        this.jPG.setVisibility(0);
        this.jPH.a(c.dU((hotThreadListResIdl == null || hotThreadListResIdl.data == null) ? null : hotThreadListResIdl.data.hot_thread_tab_info).cCO());
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setOnTabSelectedListener(TabLayout.OnTabSelectedListener onTabSelectedListener) {
        this.jPH.setOnTabSelectedListener(onTabSelectedListener);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            ap.setViewTextColor(this.jPF, R.color.CAM_X0105);
            ap.setViewTextColor(this.jBN, R.color.CAM_X0105);
            ap.setViewTextColor(this.jPG, R.color.CAM_X0109);
            com.baidu.tbadk.core.elementsMaven.c.bm(this.jPD).pA(d.bkA() ? R.string.J_X02 : R.string.J_X06).setBackGroundColor(R.color.CAM_X0205);
            if (d.bkA()) {
                com.baidu.tbadk.core.elementsMaven.c.bm(this.jPI).setBackGroundColor(R.color.CAM_X0205);
            }
            if (this.jPE != null) {
                this.jPE.onChangeSkinType(i);
            }
            if (this.jPH != null) {
                this.jPH.onChangeSkinType(i);
            }
        }
    }
}
