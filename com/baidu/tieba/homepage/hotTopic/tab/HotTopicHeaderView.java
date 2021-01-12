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
    protected f ajB;
    private EMTextView jJL;
    private RelativeLayout jYo;
    private HotTopicTabRankListLayout jYp;
    private EMTextView jYq;
    private EMTextView jYr;
    private com.baidu.tieba.homepage.hotTopic.tab.view.a jYs;
    private LinearLayout jYt;
    private int mSkinType;

    public void setOnItemCoverListener(f fVar) {
        this.ajB = fVar;
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
        this.jYo = new RelativeLayout(getContext());
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X003);
        int dimenPixelSize2 = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
        int dimenPixelSize3 = UtilHelper.getDimenPixelSize(R.dimen.M_W_X007);
        int dimenPixelSize4 = UtilHelper.getDimenPixelSize(R.dimen.M_W_X005);
        int dimenPixelSize5 = UtilHelper.getDimenPixelSize(R.dimen.M_H_X005);
        int dimenPixelSize6 = UtilHelper.getDimenPixelSize(R.dimen.M_H_X004);
        this.jYq = new EMTextView(getContext());
        this.jYq.setId(R.id.title_id);
        com.baidu.tbadk.core.elementsMaven.c.bv(this.jYq).nV(R.color.CAM_X0105).nW(R.dimen.T_X07).nX(R.string.F_X02);
        this.jYq.setText(getString(R.string.hot_topic_tab_rank_list_title));
        this.jYq.setMaxLines(1);
        this.jYq.setEllipsize(TextUtils.TruncateAt.END);
        this.jYq.setPadding(dimenPixelSize4, dimenPixelSize5, dimenPixelSize4, dimenPixelSize6);
        this.jYo.addView(this.jYq, new RelativeLayout.LayoutParams(-1, -2));
        this.jYp = new HotTopicTabRankListLayout(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(3, R.id.title_id);
        this.jYo.addView(this.jYp, layoutParams);
        com.baidu.tbadk.core.elementsMaven.c.bv(this.jYo).od(R.string.J_X06).setBackGroundColor(R.color.CAM_X0205);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X003);
        this.jYo.setPadding(0, 0, 0, dimenPixelSize6);
        addView(this.jYo, layoutParams2);
        this.jYt = new LinearLayout(getContext());
        this.jYt.setOrientation(0);
        EMTextView eMTextView = new EMTextView(getContext());
        com.baidu.tbadk.core.elementsMaven.c.bv(eMTextView).nW(R.dimen.T_X07).nV(R.color.CAM_X0105).nX(R.string.F_X02);
        eMTextView.setText(getString(R.string.hot_topic_hot_tie_title));
        eMTextView.setMaxLines(1);
        eMTextView.setEllipsize(TextUtils.TruncateAt.END);
        eMTextView.setPadding(dimenPixelSize3 - dimenPixelSize2, 0, dimenPixelSize, 0);
        this.jYt.addView(eMTextView);
        this.jJL = eMTextView;
        EMTextView eMTextView2 = new EMTextView(getContext());
        com.baidu.tbadk.core.elementsMaven.c.bv(eMTextView2).nW(R.dimen.T_X09).nV(R.color.CAM_X0109).nX(R.string.F_X01);
        eMTextView2.setText(getString(R.string.hot_topic_hot_tie_sub_title));
        eMTextView2.setMaxLines(1);
        eMTextView2.setEllipsize(TextUtils.TruncateAt.END);
        eMTextView2.setPadding(0, UtilHelper.getDimenPixelSize(R.dimen.M_H_X006) - dimenPixelSize5, 0, 0);
        this.jYt.addView(eMTextView2);
        this.jYr = eMTextView2;
        this.jYt.setPadding(0, dimenPixelSize5, 0, dimenPixelSize6);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams3.topMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X003);
        addView(this.jYt, layoutParams3);
        this.jYs = new com.baidu.tieba.homepage.hotTopic.tab.view.a(getContext());
        addView(this.jYs.cON());
        LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) this.jYs.cON().getLayoutParams();
        layoutParams4.weight = -1.0f;
        layoutParams4.height = UtilHelper.getDimenPixelSize(R.dimen.tbds106);
        this.jYs.cON().requestLayout();
    }

    private String getString(int i) {
        return TbadkCoreApplication.getInst().getString(i);
    }

    public void setData(HotThreadListResIdl hotThreadListResIdl) {
        if (hotThreadListResIdl != null && hotThreadListResIdl.data != null && !x.isEmpty(hotThreadListResIdl.data.topic_list)) {
            this.jYq.setVisibility(0);
            this.jYp.setVisibility(0);
            this.jYp.setOnItemCoverListener(this.ajB);
            this.jYp.a(new d(hotThreadListResIdl.data.topic_list));
        } else {
            this.jYq.setVisibility(8);
            this.jYp.setVisibility(8);
        }
        this.jJL.setVisibility(0);
        this.jYr.setVisibility(0);
        this.jYs.a(c.eb((hotThreadListResIdl == null || hotThreadListResIdl.data == null) ? null : hotThreadListResIdl.data.hot_thread_tab_info).cBS());
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setOnTabSelectedListener(TabLayout.OnTabSelectedListener onTabSelectedListener) {
        this.jYs.setOnTabSelectedListener(onTabSelectedListener);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            ao.setViewTextColor(this.jYq, R.color.CAM_X0105);
            ao.setViewTextColor(this.jJL, R.color.CAM_X0105);
            ao.setViewTextColor(this.jYr, R.color.CAM_X0109);
            com.baidu.tbadk.core.elementsMaven.c.bv(this.jYo).od(R.string.J_X06).setBackGroundColor(R.color.CAM_X0205);
            if (this.jYp != null) {
                this.jYp.onChangeSkinType(i);
            }
            if (this.jYs != null) {
                this.jYs.onChangeSkinType(i);
            }
        }
    }
}
