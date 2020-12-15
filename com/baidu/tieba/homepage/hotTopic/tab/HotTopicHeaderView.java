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
    private EMTextView jBP;
    private RelativeLayout jPF;
    private HotTopicTabRankListLayout jPG;
    private EMTextView jPH;
    private EMTextView jPI;
    private com.baidu.tieba.homepage.hotTopic.tab.view.a jPJ;
    private LinearLayout jPK;
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
        this.jPF = new RelativeLayout(getContext());
        int dimenPixelSize3 = UtilHelper.getDimenPixelSize(R.dimen.M_W_X003);
        int dimenPixelSize4 = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
        int dimenPixelSize5 = UtilHelper.getDimenPixelSize(R.dimen.M_W_X007);
        int dimenPixelSize6 = UtilHelper.getDimenPixelSize(R.dimen.M_W_X005);
        int dimenPixelSize7 = UtilHelper.getDimenPixelSize(R.dimen.M_H_X005);
        int dimenPixelSize8 = UtilHelper.getDimenPixelSize(R.dimen.M_H_X004);
        this.jPH = new EMTextView(getContext());
        this.jPH.setId(R.id.title_id);
        com.baidu.tbadk.core.elementsMaven.c.bm(this.jPH).ps(R.color.CAM_X0105).pt(R.dimen.T_X07).pu(R.string.F_X02);
        this.jPH.setText(getString(R.string.hot_topic_tab_rank_list_title));
        this.jPH.setMaxLines(1);
        this.jPH.setEllipsize(TextUtils.TruncateAt.END);
        if (d.bkA()) {
            this.jPH.setPadding(dimenPixelSize5, dimenPixelSize7, dimenPixelSize5, dimenPixelSize8);
        } else {
            this.jPH.setPadding(dimenPixelSize6, dimenPixelSize7, dimenPixelSize6, dimenPixelSize8);
        }
        this.jPF.addView(this.jPH, new RelativeLayout.LayoutParams(-1, -2));
        this.jPG = new HotTopicTabRankListLayout(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(3, R.id.title_id);
        this.jPF.addView(this.jPG, layoutParams);
        com.baidu.tbadk.core.elementsMaven.c.bm(this.jPF).pA(d.bkA() ? R.string.J_X02 : R.string.J_X06).setBackGroundColor(R.color.CAM_X0205);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        if (d.bkA()) {
            layoutParams2.topMargin = 0;
            this.jPF.setPadding(0, UtilHelper.getDimenPixelSize(R.dimen.M_H_X001), 0, dimenPixelSize8);
        } else {
            layoutParams2.topMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X003);
            this.jPF.setPadding(0, 0, 0, dimenPixelSize8);
        }
        addView(this.jPF, layoutParams2);
        this.jPK = new LinearLayout(getContext());
        this.jPK.setOrientation(0);
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
        this.jPK.addView(eMTextView);
        this.jBP = eMTextView;
        EMTextView eMTextView2 = new EMTextView(getContext());
        com.baidu.tbadk.core.elementsMaven.c.bm(eMTextView2).pt(R.dimen.T_X09).ps(R.color.CAM_X0109).pu(R.string.F_X01);
        eMTextView2.setText(getString(R.string.hot_topic_hot_tie_sub_title));
        eMTextView2.setMaxLines(1);
        eMTextView2.setEllipsize(TextUtils.TruncateAt.END);
        eMTextView2.setPadding(0, UtilHelper.getDimenPixelSize(R.dimen.M_H_X006) - dimenPixelSize7, 0, 0);
        this.jPK.addView(eMTextView2);
        this.jPI = eMTextView2;
        this.jPK.setPadding(0, dimenPixelSize7, 0, dimenPixelSize8);
        if (d.bkA()) {
            com.baidu.tbadk.core.elementsMaven.c.bm(this.jPK).setBackGroundColor(R.color.CAM_X0205);
        }
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        if (d.bkA()) {
            dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_H_X002);
        } else {
            dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_H_X003);
        }
        layoutParams3.topMargin = dimenPixelSize;
        addView(this.jPK, layoutParams3);
        this.jPJ = new com.baidu.tieba.homepage.hotTopic.tab.view.a(getContext());
        addView(this.jPJ.cPy());
        LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) this.jPJ.cPy().getLayoutParams();
        layoutParams4.weight = -1.0f;
        if (d.bkA()) {
            dimenPixelSize2 = UtilHelper.getDimenPixelSize(R.dimen.tbds122);
        } else {
            dimenPixelSize2 = UtilHelper.getDimenPixelSize(R.dimen.tbds106);
        }
        layoutParams4.height = dimenPixelSize2;
        this.jPJ.cPy().requestLayout();
    }

    private String getString(int i) {
        return TbadkCoreApplication.getInst().getString(i);
    }

    public void setData(HotThreadListResIdl hotThreadListResIdl) {
        if (hotThreadListResIdl != null && hotThreadListResIdl.data != null && !y.isEmpty(hotThreadListResIdl.data.topic_list)) {
            this.jPH.setVisibility(0);
            this.jPG.setVisibility(0);
            this.jPG.setOnItemCoverListener(this.ajQ);
            this.jPG.a(new com.baidu.tieba.homepage.hotTopic.tab.b.d(hotThreadListResIdl.data.topic_list));
        } else {
            this.jPH.setVisibility(8);
            this.jPG.setVisibility(8);
        }
        this.jBP.setVisibility(0);
        this.jPI.setVisibility(0);
        this.jPJ.a(c.dU((hotThreadListResIdl == null || hotThreadListResIdl.data == null) ? null : hotThreadListResIdl.data.hot_thread_tab_info).cCP());
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setOnTabSelectedListener(TabLayout.OnTabSelectedListener onTabSelectedListener) {
        this.jPJ.setOnTabSelectedListener(onTabSelectedListener);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            ap.setViewTextColor(this.jPH, R.color.CAM_X0105);
            ap.setViewTextColor(this.jBP, R.color.CAM_X0105);
            ap.setViewTextColor(this.jPI, R.color.CAM_X0109);
            com.baidu.tbadk.core.elementsMaven.c.bm(this.jPF).pA(d.bkA() ? R.string.J_X02 : R.string.J_X06).setBackGroundColor(R.color.CAM_X0205);
            if (d.bkA()) {
                com.baidu.tbadk.core.elementsMaven.c.bm(this.jPK).setBackGroundColor(R.color.CAM_X0205);
            }
            if (this.jPG != null) {
                this.jPG.onChangeSkinType(i);
            }
            if (this.jPJ != null) {
                this.jPJ.onChangeSkinType(i);
            }
        }
    }
}
