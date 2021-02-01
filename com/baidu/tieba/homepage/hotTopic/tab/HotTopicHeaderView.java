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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.h.f;
import com.baidu.tieba.R;
import com.baidu.tieba.card.p;
import com.baidu.tieba.homepage.hotTopic.tab.b.d;
import com.baidu.tieba.homepage.hotTopic.tab.view.HotTopicTabRankListLayout;
import com.google.android.material.tabs.TabLayout;
import tbclient.HotThreadList.HotThreadListResIdl;
/* loaded from: classes2.dex */
public class HotTopicHeaderView extends LinearLayout {
    protected f ajq;
    private EMTextView jQI;
    private RelativeLayout kfQ;
    private HotTopicTabRankListLayout kfR;
    private EMTextView kfS;
    private EMTextView kfT;
    private com.baidu.tieba.homepage.hotTopic.tab.view.a kfU;
    private p kfV;
    private LinearLayout kfW;
    private int mSkinType;

    public void setOnItemCoverListener(f fVar) {
        this.ajq = fVar;
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
        this.kfQ = new RelativeLayout(getContext());
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X003);
        int dimenPixelSize2 = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
        int dimenPixelSize3 = UtilHelper.getDimenPixelSize(R.dimen.M_W_X007);
        int dimenPixelSize4 = UtilHelper.getDimenPixelSize(R.dimen.M_W_X005);
        int dimenPixelSize5 = UtilHelper.getDimenPixelSize(R.dimen.M_H_X005);
        int dimenPixelSize6 = UtilHelper.getDimenPixelSize(R.dimen.M_H_X004);
        this.kfS = new EMTextView(getContext());
        this.kfS.setId(R.id.title_id);
        com.baidu.tbadk.core.elementsMaven.c.br(this.kfS).nY(R.color.CAM_X0105).nZ(R.dimen.T_X07).oa(R.string.F_X02);
        this.kfS.setText(getString(R.string.hot_topic_tab_rank_list_title));
        this.kfS.setMaxLines(1);
        this.kfS.setEllipsize(TextUtils.TruncateAt.END);
        this.kfS.setPadding(dimenPixelSize4, dimenPixelSize5, dimenPixelSize4, dimenPixelSize6);
        this.kfQ.addView(this.kfS, new RelativeLayout.LayoutParams(-1, -2));
        this.kfR = new HotTopicTabRankListLayout(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(3, R.id.title_id);
        this.kfQ.addView(this.kfR, layoutParams);
        com.baidu.tbadk.core.elementsMaven.c.br(this.kfQ).og(R.string.J_X06).setBackGroundColor(R.color.CAM_X0205);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X003);
        this.kfQ.setPadding(0, 0, 0, dimenPixelSize6);
        addView(this.kfQ, layoutParams2);
        this.kfV = new p(getContext());
        this.kfV.setFrom("from_hottop");
        this.kfV.IO("2");
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams3.topMargin = UtilHelper.getDimenPixelSize(R.dimen.tbds5);
        addView(this.kfV.getView(), layoutParams3);
        this.kfW = new LinearLayout(getContext());
        this.kfW.setOrientation(0);
        EMTextView eMTextView = new EMTextView(getContext());
        com.baidu.tbadk.core.elementsMaven.c.br(eMTextView).nZ(R.dimen.T_X07).nY(R.color.CAM_X0105).oa(R.string.F_X02);
        eMTextView.setText(getString(R.string.hot_topic_hot_tie_title));
        eMTextView.setMaxLines(1);
        eMTextView.setEllipsize(TextUtils.TruncateAt.END);
        eMTextView.setPadding(dimenPixelSize3 - dimenPixelSize2, 0, dimenPixelSize, 0);
        this.kfW.addView(eMTextView);
        this.jQI = eMTextView;
        EMTextView eMTextView2 = new EMTextView(getContext());
        com.baidu.tbadk.core.elementsMaven.c.br(eMTextView2).nZ(R.dimen.T_X09).nY(R.color.CAM_X0109).oa(R.string.F_X01);
        eMTextView2.setText(getString(R.string.hot_topic_hot_tie_sub_title));
        eMTextView2.setMaxLines(1);
        eMTextView2.setEllipsize(TextUtils.TruncateAt.END);
        eMTextView2.setPadding(0, UtilHelper.getDimenPixelSize(R.dimen.M_H_X006) - dimenPixelSize5, 0, 0);
        this.kfW.addView(eMTextView2);
        this.kfT = eMTextView2;
        this.kfW.setPadding(0, dimenPixelSize5, 0, dimenPixelSize6);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams4.topMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X003);
        addView(this.kfW, layoutParams4);
        this.kfU = new com.baidu.tieba.homepage.hotTopic.tab.view.a(getContext());
        addView(this.kfU.cQK());
        LinearLayout.LayoutParams layoutParams5 = (LinearLayout.LayoutParams) this.kfU.cQK().getLayoutParams();
        layoutParams5.weight = -1.0f;
        layoutParams5.height = UtilHelper.getDimenPixelSize(R.dimen.tbds106);
        this.kfU.cQK().requestLayout();
    }

    private String getString(int i) {
        return TbadkCoreApplication.getInst().getString(i);
    }

    public void setData(HotThreadListResIdl hotThreadListResIdl) {
        if (hotThreadListResIdl != null && hotThreadListResIdl.data != null && !y.isEmpty(hotThreadListResIdl.data.topic_list)) {
            this.kfS.setVisibility(0);
            this.kfR.setVisibility(0);
            this.kfR.setOnItemCoverListener(this.ajq);
            this.kfR.a(new d(hotThreadListResIdl.data.topic_list));
        } else {
            this.kfS.setVisibility(8);
            this.kfR.setVisibility(8);
        }
        if (this.kfV != null) {
            this.kfV.getView().setVisibility(0);
        }
        this.jQI.setVisibility(0);
        this.kfT.setVisibility(0);
        this.kfU.a(c.dY((hotThreadListResIdl == null || hotThreadListResIdl.data == null) ? null : hotThreadListResIdl.data.hot_thread_tab_info).cDe());
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setOnTabSelectedListener(TabLayout.OnTabSelectedListener onTabSelectedListener) {
        this.kfU.setOnTabSelectedListener(onTabSelectedListener);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            ap.setViewTextColor(this.kfS, R.color.CAM_X0105);
            ap.setViewTextColor(this.jQI, R.color.CAM_X0105);
            ap.setViewTextColor(this.kfT, R.color.CAM_X0109);
            com.baidu.tbadk.core.elementsMaven.c.br(this.kfQ).og(R.string.J_X06).setBackGroundColor(R.color.CAM_X0205);
            if (this.kfR != null) {
                this.kfR.onChangeSkinType(i);
            }
            if (this.kfU != null) {
                this.kfU.onChangeSkinType(i);
            }
            if (this.kfV != null) {
                this.kfV.onChangeSkinType(i);
            }
        }
    }
}
