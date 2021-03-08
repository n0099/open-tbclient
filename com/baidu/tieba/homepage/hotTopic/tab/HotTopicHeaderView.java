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
    protected f akI;
    private EMTextView jSF;
    private RelativeLayout kih;
    private HotTopicTabRankListLayout kii;
    private EMTextView kij;
    private EMTextView kik;
    private com.baidu.tieba.homepage.hotTopic.tab.view.a kil;
    private p kim;
    private LinearLayout kin;
    private int mSkinType;

    public void setOnItemCoverListener(f fVar) {
        this.akI = fVar;
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
        this.kih = new RelativeLayout(getContext());
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X003);
        int dimenPixelSize2 = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
        int dimenPixelSize3 = UtilHelper.getDimenPixelSize(R.dimen.M_W_X007);
        int dimenPixelSize4 = UtilHelper.getDimenPixelSize(R.dimen.M_W_X005);
        int dimenPixelSize5 = UtilHelper.getDimenPixelSize(R.dimen.M_H_X005);
        int dimenPixelSize6 = UtilHelper.getDimenPixelSize(R.dimen.M_H_X004);
        this.kij = new EMTextView(getContext());
        this.kij.setId(R.id.title_id);
        com.baidu.tbadk.core.elementsMaven.c.br(this.kij).nZ(R.color.CAM_X0105).oa(R.dimen.T_X07).ob(R.string.F_X02);
        this.kij.setText(getString(R.string.hot_topic_tab_rank_list_title));
        this.kij.setMaxLines(1);
        this.kij.setEllipsize(TextUtils.TruncateAt.END);
        this.kij.setPadding(dimenPixelSize4, dimenPixelSize5, dimenPixelSize4, dimenPixelSize6);
        this.kih.addView(this.kij, new RelativeLayout.LayoutParams(-1, -2));
        this.kii = new HotTopicTabRankListLayout(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(3, R.id.title_id);
        this.kih.addView(this.kii, layoutParams);
        com.baidu.tbadk.core.elementsMaven.c.br(this.kih).oh(R.string.J_X06).setBackGroundColor(R.color.CAM_X0205);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X003);
        this.kih.setPadding(0, 0, 0, dimenPixelSize6);
        addView(this.kih, layoutParams2);
        this.kim = new p(getContext());
        this.kim.setFrom("from_hottop");
        this.kim.IY("2");
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams3.topMargin = UtilHelper.getDimenPixelSize(R.dimen.tbds5);
        addView(this.kim.getView(), layoutParams3);
        this.kin = new LinearLayout(getContext());
        this.kin.setOrientation(0);
        EMTextView eMTextView = new EMTextView(getContext());
        com.baidu.tbadk.core.elementsMaven.c.br(eMTextView).oa(R.dimen.T_X07).nZ(R.color.CAM_X0105).ob(R.string.F_X02);
        eMTextView.setText(getString(R.string.hot_topic_hot_tie_title));
        eMTextView.setMaxLines(1);
        eMTextView.setEllipsize(TextUtils.TruncateAt.END);
        eMTextView.setPadding(dimenPixelSize3 - dimenPixelSize2, 0, dimenPixelSize, 0);
        this.kin.addView(eMTextView);
        this.jSF = eMTextView;
        EMTextView eMTextView2 = new EMTextView(getContext());
        com.baidu.tbadk.core.elementsMaven.c.br(eMTextView2).oa(R.dimen.T_X09).nZ(R.color.CAM_X0109).ob(R.string.F_X01);
        eMTextView2.setText(getString(R.string.hot_topic_hot_tie_sub_title));
        eMTextView2.setMaxLines(1);
        eMTextView2.setEllipsize(TextUtils.TruncateAt.END);
        eMTextView2.setPadding(0, UtilHelper.getDimenPixelSize(R.dimen.M_H_X006) - dimenPixelSize5, 0, 0);
        this.kin.addView(eMTextView2);
        this.kik = eMTextView2;
        this.kin.setPadding(0, dimenPixelSize5, 0, dimenPixelSize6);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams4.topMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X003);
        addView(this.kin, layoutParams4);
        this.kil = new com.baidu.tieba.homepage.hotTopic.tab.view.a(getContext());
        addView(this.kil.cQY());
        LinearLayout.LayoutParams layoutParams5 = (LinearLayout.LayoutParams) this.kil.cQY().getLayoutParams();
        layoutParams5.weight = -1.0f;
        layoutParams5.height = UtilHelper.getDimenPixelSize(R.dimen.tbds106);
        this.kil.cQY().requestLayout();
    }

    private String getString(int i) {
        return TbadkCoreApplication.getInst().getString(i);
    }

    public void setData(HotThreadListResIdl hotThreadListResIdl) {
        if (hotThreadListResIdl != null && hotThreadListResIdl.data != null && !y.isEmpty(hotThreadListResIdl.data.topic_list)) {
            this.kij.setVisibility(0);
            this.kii.setVisibility(0);
            this.kii.setOnItemCoverListener(this.akI);
            this.kii.a(new d(hotThreadListResIdl.data.topic_list));
        } else {
            this.kij.setVisibility(8);
            this.kii.setVisibility(8);
        }
        if (this.kim != null) {
            this.kim.getView().setVisibility(0);
        }
        this.jSF.setVisibility(0);
        this.kik.setVisibility(0);
        this.kil.a(c.dY((hotThreadListResIdl == null || hotThreadListResIdl.data == null) ? null : hotThreadListResIdl.data.hot_thread_tab_info).cDr());
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setOnTabSelectedListener(TabLayout.OnTabSelectedListener onTabSelectedListener) {
        this.kil.setOnTabSelectedListener(onTabSelectedListener);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            ap.setViewTextColor(this.kij, R.color.CAM_X0105);
            ap.setViewTextColor(this.jSF, R.color.CAM_X0105);
            ap.setViewTextColor(this.kik, R.color.CAM_X0109);
            com.baidu.tbadk.core.elementsMaven.c.br(this.kih).oh(R.string.J_X06).setBackGroundColor(R.color.CAM_X0205);
            if (this.kii != null) {
                this.kii.onChangeSkinType(i);
            }
            if (this.kil != null) {
                this.kil.onChangeSkinType(i);
            }
            if (this.kim != null) {
                this.kim.onChangeSkinType(i);
            }
        }
    }
}
