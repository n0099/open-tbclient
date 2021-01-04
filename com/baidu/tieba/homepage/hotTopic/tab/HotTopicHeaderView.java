package com.baidu.tieba.homepage.hotTopic.tab;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.h.f;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.hotTopic.tab.b.d;
import com.baidu.tieba.homepage.hotTopic.tab.view.HotTopicTabRankListLayout;
import com.google.android.material.tabs.TabLayout;
import tbclient.HotThreadList.HotThreadListResIdl;
/* loaded from: classes2.dex */
public class HotTopicHeaderView extends LinearLayout {
    protected f aks;
    private EMTextView jOr;
    private RelativeLayout kcT;
    private HotTopicTabRankListLayout kcU;
    private EMTextView kcV;
    private EMTextView kcW;
    private com.baidu.tieba.homepage.hotTopic.tab.view.a kcX;
    private LinearLayout kcY;
    private int mSkinType;

    public void setOnItemCoverListener(f fVar) {
        this.aks = fVar;
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
        setOrientation(1);
        this.kcT = new RelativeLayout(getContext());
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X003);
        int dimenPixelSize2 = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
        int dimenPixelSize3 = UtilHelper.getDimenPixelSize(R.dimen.M_W_X007);
        int dimenPixelSize4 = UtilHelper.getDimenPixelSize(R.dimen.M_W_X005);
        int dimenPixelSize5 = UtilHelper.getDimenPixelSize(R.dimen.M_H_X005);
        int dimenPixelSize6 = UtilHelper.getDimenPixelSize(R.dimen.M_H_X004);
        this.kcV = new EMTextView(getContext());
        this.kcV.setId(R.id.title_id);
        com.baidu.tbadk.core.elementsMaven.c.bv(this.kcV).pC(R.color.CAM_X0105).pD(R.dimen.T_X07).pE(R.string.F_X02);
        this.kcV.setText(getString(R.string.hot_topic_tab_rank_list_title));
        this.kcV.setMaxLines(1);
        this.kcV.setEllipsize(TextUtils.TruncateAt.END);
        this.kcV.setPadding(dimenPixelSize4, dimenPixelSize5, dimenPixelSize4, dimenPixelSize6);
        this.kcT.addView(this.kcV, new RelativeLayout.LayoutParams(-1, -2));
        this.kcU = new HotTopicTabRankListLayout(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(3, R.id.title_id);
        this.kcT.addView(this.kcU, layoutParams);
        com.baidu.tbadk.core.elementsMaven.c.bv(this.kcT).pK(R.string.J_X06).setBackGroundColor(R.color.CAM_X0205);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X003);
        this.kcT.setPadding(0, 0, 0, dimenPixelSize6);
        addView(this.kcT, layoutParams2);
        this.kcY = new LinearLayout(getContext());
        this.kcY.setOrientation(0);
        EMTextView eMTextView = new EMTextView(getContext());
        com.baidu.tbadk.core.elementsMaven.c.bv(eMTextView).pD(R.dimen.T_X07).pC(R.color.CAM_X0105).pE(R.string.F_X02);
        eMTextView.setText(getString(R.string.hot_topic_hot_tie_title));
        eMTextView.setMaxLines(1);
        eMTextView.setEllipsize(TextUtils.TruncateAt.END);
        eMTextView.setPadding(dimenPixelSize3 - dimenPixelSize2, 0, dimenPixelSize, 0);
        this.kcY.addView(eMTextView);
        this.jOr = eMTextView;
        EMTextView eMTextView2 = new EMTextView(getContext());
        com.baidu.tbadk.core.elementsMaven.c.bv(eMTextView2).pD(R.dimen.T_X09).pC(R.color.CAM_X0109).pE(R.string.F_X01);
        eMTextView2.setText(getString(R.string.hot_topic_hot_tie_sub_title));
        eMTextView2.setMaxLines(1);
        eMTextView2.setEllipsize(TextUtils.TruncateAt.END);
        eMTextView2.setPadding(0, UtilHelper.getDimenPixelSize(R.dimen.M_H_X006) - dimenPixelSize5, 0, 0);
        this.kcY.addView(eMTextView2);
        this.kcW = eMTextView2;
        this.kcY.setPadding(0, dimenPixelSize5, 0, dimenPixelSize6);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams3.topMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X003);
        addView(this.kcY, layoutParams3);
        this.kcX = new com.baidu.tieba.homepage.hotTopic.tab.view.a(getContext());
        addView(this.kcX.cSE());
        LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) this.kcX.cSE().getLayoutParams();
        layoutParams4.weight = -1.0f;
        layoutParams4.height = UtilHelper.getDimenPixelSize(R.dimen.tbds106);
        this.kcX.cSE().requestLayout();
    }

    private String getString(int i) {
        return TbadkCoreApplication.getInst().getString(i);
    }

    public void setData(HotThreadListResIdl hotThreadListResIdl) {
        if (hotThreadListResIdl != null && hotThreadListResIdl.data != null && !x.isEmpty(hotThreadListResIdl.data.topic_list)) {
            this.kcV.setVisibility(0);
            this.kcU.setVisibility(0);
            this.kcU.setOnItemCoverListener(this.aks);
            this.kcU.a(new d(hotThreadListResIdl.data.topic_list));
        } else {
            this.kcV.setVisibility(8);
            this.kcU.setVisibility(8);
        }
        this.jOr.setVisibility(0);
        this.kcW.setVisibility(0);
        this.kcX.a(c.eb((hotThreadListResIdl == null || hotThreadListResIdl.data == null) ? null : hotThreadListResIdl.data.hot_thread_tab_info).cFJ());
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setOnTabSelectedListener(TabLayout.OnTabSelectedListener onTabSelectedListener) {
        this.kcX.setOnTabSelectedListener(onTabSelectedListener);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            ao.setViewTextColor(this.kcV, R.color.CAM_X0105);
            ao.setViewTextColor(this.jOr, R.color.CAM_X0105);
            ao.setViewTextColor(this.kcW, R.color.CAM_X0109);
            com.baidu.tbadk.core.elementsMaven.c.bv(this.kcT).pK(R.string.J_X06).setBackGroundColor(R.color.CAM_X0205);
            if (this.kcU != null) {
                this.kcU.onChangeSkinType(i);
            }
            if (this.kcX != null) {
                this.kcX.onChangeSkinType(i);
            }
        }
    }
}
