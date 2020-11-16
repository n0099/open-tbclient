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
/* loaded from: classes21.dex */
public class HotTopicHeaderView extends LinearLayout {
    protected f aiR;
    private RelativeLayout jCb;
    private HotTopicTabRankListLayout jCc;
    private EMTextView jCd;
    private EMTextView jCe;
    private com.baidu.tieba.homepage.hotTopic.tab.view.a jCf;
    private LinearLayout jCg;
    private EMTextView jol;
    private int mSkinType;

    public void setOnItemCoverListener(f fVar) {
        this.aiR = fVar;
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
        this.jCb = new RelativeLayout(getContext());
        int dimenPixelSize3 = UtilHelper.getDimenPixelSize(R.dimen.M_W_X003);
        int dimenPixelSize4 = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
        int dimenPixelSize5 = UtilHelper.getDimenPixelSize(R.dimen.M_W_X007);
        int dimenPixelSize6 = UtilHelper.getDimenPixelSize(R.dimen.M_W_X005);
        int dimenPixelSize7 = UtilHelper.getDimenPixelSize(R.dimen.M_H_X005);
        int dimenPixelSize8 = UtilHelper.getDimenPixelSize(R.dimen.M_H_X004);
        this.jCd = new EMTextView(getContext());
        this.jCd.setId(R.id.title_id);
        com.baidu.tbadk.core.elementsMaven.c.bj(this.jCd).oT(R.color.CAM_X0105).oU(R.dimen.T_X07).oV(R.string.F_X02);
        this.jCd.setText(getString(R.string.hot_topic_tab_rank_list_title));
        this.jCd.setMaxLines(1);
        this.jCd.setEllipsize(TextUtils.TruncateAt.END);
        if (d.bhw()) {
            this.jCd.setPadding(dimenPixelSize5, dimenPixelSize7, dimenPixelSize5, dimenPixelSize8);
        } else {
            this.jCd.setPadding(dimenPixelSize6, dimenPixelSize7, dimenPixelSize6, dimenPixelSize8);
        }
        this.jCb.addView(this.jCd, new RelativeLayout.LayoutParams(-1, -2));
        this.jCc = new HotTopicTabRankListLayout(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(3, R.id.title_id);
        this.jCb.addView(this.jCc, layoutParams);
        com.baidu.tbadk.core.elementsMaven.c.bj(this.jCb).pb(d.bhw() ? R.string.J_X02 : R.string.J_X06).setBackGroundColor(R.color.CAM_X0205);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        if (d.bhw()) {
            layoutParams2.topMargin = 0;
            this.jCb.setPadding(0, UtilHelper.getDimenPixelSize(R.dimen.M_H_X001), 0, dimenPixelSize8);
        } else {
            layoutParams2.topMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X003);
            this.jCb.setPadding(0, 0, 0, dimenPixelSize8);
        }
        addView(this.jCb, layoutParams2);
        this.jCg = new LinearLayout(getContext());
        this.jCg.setOrientation(0);
        EMTextView eMTextView = new EMTextView(getContext());
        com.baidu.tbadk.core.elementsMaven.c.bj(eMTextView).oU(R.dimen.T_X07).oT(R.color.CAM_X0105).oV(R.string.F_X02);
        eMTextView.setText(getString(R.string.hot_topic_hot_tie_title));
        eMTextView.setMaxLines(1);
        eMTextView.setEllipsize(TextUtils.TruncateAt.END);
        if (d.bhw()) {
            eMTextView.setPadding(dimenPixelSize5, 0, dimenPixelSize3, 0);
        } else {
            eMTextView.setPadding(dimenPixelSize5 - dimenPixelSize4, 0, dimenPixelSize3, 0);
        }
        this.jCg.addView(eMTextView);
        this.jol = eMTextView;
        EMTextView eMTextView2 = new EMTextView(getContext());
        com.baidu.tbadk.core.elementsMaven.c.bj(eMTextView2).oU(R.dimen.T_X09).oT(R.color.CAM_X0109).oV(R.string.F_X01);
        eMTextView2.setText(getString(R.string.hot_topic_hot_tie_sub_title));
        eMTextView2.setMaxLines(1);
        eMTextView2.setEllipsize(TextUtils.TruncateAt.END);
        eMTextView2.setPadding(0, UtilHelper.getDimenPixelSize(R.dimen.M_H_X006) - dimenPixelSize7, 0, 0);
        this.jCg.addView(eMTextView2);
        this.jCe = eMTextView2;
        this.jCg.setPadding(0, dimenPixelSize7, 0, dimenPixelSize8);
        if (d.bhw()) {
            com.baidu.tbadk.core.elementsMaven.c.bj(this.jCg).setBackGroundColor(R.color.CAM_X0205);
        }
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        if (d.bhw()) {
            dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_H_X002);
        } else {
            dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_H_X003);
        }
        layoutParams3.topMargin = dimenPixelSize;
        addView(this.jCg, layoutParams3);
        this.jCf = new com.baidu.tieba.homepage.hotTopic.tab.view.a(getContext());
        addView(this.jCf.cKi());
        LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) this.jCf.cKi().getLayoutParams();
        layoutParams4.weight = -1.0f;
        if (d.bhw()) {
            dimenPixelSize2 = UtilHelper.getDimenPixelSize(R.dimen.tbds122);
        } else {
            dimenPixelSize2 = UtilHelper.getDimenPixelSize(R.dimen.tbds106);
        }
        layoutParams4.height = dimenPixelSize2;
        this.jCf.cKi().requestLayout();
    }

    private String getString(int i) {
        return TbadkCoreApplication.getInst().getString(i);
    }

    public void setData(HotThreadListResIdl hotThreadListResIdl) {
        if (hotThreadListResIdl != null && hotThreadListResIdl.data != null && !y.isEmpty(hotThreadListResIdl.data.topic_list)) {
            this.jCd.setVisibility(0);
            this.jCc.setVisibility(0);
            this.jCc.setOnItemCoverListener(this.aiR);
            this.jCc.a(new com.baidu.tieba.homepage.hotTopic.tab.b.d(hotThreadListResIdl.data.topic_list));
        } else {
            this.jCd.setVisibility(8);
            this.jCc.setVisibility(8);
        }
        this.jol.setVisibility(0);
        this.jCe.setVisibility(0);
        this.jCf.a(c.dJ((hotThreadListResIdl == null || hotThreadListResIdl.data == null) ? null : hotThreadListResIdl.data.hot_thread_tab_info).cyx());
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setOnTabSelectedListener(TabLayout.OnTabSelectedListener onTabSelectedListener) {
        this.jCf.setOnTabSelectedListener(onTabSelectedListener);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            ap.setViewTextColor(this.jCd, R.color.CAM_X0105);
            ap.setViewTextColor(this.jol, R.color.CAM_X0105);
            ap.setViewTextColor(this.jCe, R.color.CAM_X0109);
            com.baidu.tbadk.core.elementsMaven.c.bj(this.jCb).pb(d.bhw() ? R.string.J_X02 : R.string.J_X06).setBackGroundColor(R.color.CAM_X0205);
            if (d.bhw()) {
                com.baidu.tbadk.core.elementsMaven.c.bj(this.jCg).setBackGroundColor(R.color.CAM_X0205);
            }
            if (this.jCc != null) {
                this.jCc.onChangeSkinType(i);
            }
            if (this.jCf != null) {
                this.jCf.onChangeSkinType(i);
            }
        }
    }
}
