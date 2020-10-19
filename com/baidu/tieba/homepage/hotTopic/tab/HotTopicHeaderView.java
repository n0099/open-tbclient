package com.baidu.tieba.homepage.hotTopic.tab;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.h.f;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.hotTopic.tab.b.d;
import com.baidu.tieba.homepage.hotTopic.tab.view.HotTopicTabRankListLayout;
import tbclient.HotThreadList.HotThreadListResIdl;
/* loaded from: classes22.dex */
public class HotTopicHeaderView extends LinearLayout {
    protected f aiL;
    private HotTopicTabRankListLayout jiL;
    private TextView jiM;
    private View jiN;
    private TextView jiO;
    private com.baidu.tieba.homepage.hotTopic.tab.view.a jiP;
    private int mSkinType;
    private TextView mTitleView;

    public void setOnItemCoverListener(f fVar) {
        this.aiL = fVar;
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
        int dimens = l.getDimens(getContext(), R.dimen.tbds44);
        int dimens2 = l.getDimens(getContext(), R.dimen.tbds38);
        int dimens3 = l.getDimens(getContext(), R.dimen.tbds25);
        this.jiM = new TextView(getContext());
        this.jiM.setTextColor(getContext().getResources().getColor(R.color.cp_cont_b));
        this.jiM.setTextSize(0, l.getDimens(getContext(), R.dimen.tbds44));
        this.jiM.setTypeface(Typeface.DEFAULT_BOLD);
        this.jiM.setIncludeFontPadding(false);
        this.jiM.setSingleLine();
        this.jiM.setEllipsize(TextUtils.TruncateAt.END);
        this.jiM.setGravity(16);
        this.jiM.setPadding(dimens, dimens2, dimens, dimens3);
        addView(this.jiM);
        this.jiL = new HotTopicTabRankListLayout(getContext());
        this.jiL.setPadding(0, 0, 0, dimens3);
        addView(this.jiL);
        this.jiN = new View(getContext());
        this.jiN.setLayoutParams(new LinearLayout.LayoutParams(-1, l.getDimens(getContext(), R.dimen.tbds17)));
        addView(this.jiN);
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        linearLayout.setPadding(dimens, dimens2, dimens, dimens3);
        TextView textView = new TextView(getContext());
        textView.setTextColor(getContext().getResources().getColor(R.color.cp_cont_b));
        textView.setTextSize(0, l.getDimens(getContext(), R.dimen.tbds44));
        textView.setTypeface(Typeface.DEFAULT_BOLD);
        textView.setIncludeFontPadding(false);
        textView.setSingleLine();
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setGravity(16);
        linearLayout.addView(textView);
        this.mTitleView = textView;
        TextView textView2 = new TextView(getContext());
        textView2.setPadding(l.getDimens(getContext(), R.dimen.tbds10), 0, 0, 0);
        textView2.setTextColor(getContext().getResources().getColor(R.color.cp_cont_d));
        textView2.setTextSize(0, l.getDimens(getContext(), R.dimen.tbds31));
        textView2.setIncludeFontPadding(false);
        textView2.setSingleLine();
        textView2.setEllipsize(TextUtils.TruncateAt.END);
        textView2.setGravity(16);
        linearLayout.addView(textView2);
        this.jiO = textView2;
        addView(linearLayout);
        this.jiP = new com.baidu.tieba.homepage.hotTopic.tab.view.a(getContext());
        this.jiP.cEV().setLayoutParams(new LinearLayout.LayoutParams(-1, l.getDimens(getContext(), R.dimen.tbds138)));
        addView(this.jiP.cEV());
        this.jiM.setText(getString(R.string.hot_topic_tab_rank_list_title));
        this.mTitleView.setText(getString(R.string.hot_topic_hot_tie_title));
        this.jiO.setText(getString(R.string.hot_topic_hot_tie_sub_title));
    }

    private String getString(int i) {
        return TbadkCoreApplication.getInst().getString(i);
    }

    public void setData(HotThreadListResIdl hotThreadListResIdl) {
        if (hotThreadListResIdl != null && hotThreadListResIdl.data != null && !y.isEmpty(hotThreadListResIdl.data.topic_list)) {
            this.jiM.setVisibility(0);
            this.jiL.setVisibility(0);
            this.jiL.setOnItemCoverListener(this.aiL);
            this.jiL.a(new d(hotThreadListResIdl.data.topic_list));
        } else {
            this.jiM.setVisibility(8);
            this.jiL.setVisibility(8);
        }
        this.mTitleView.setVisibility(0);
        this.jiO.setVisibility(0);
        this.jiP.a(c.ds((hotThreadListResIdl == null || hotThreadListResIdl.data == null) ? null : hotThreadListResIdl.data.hot_thread_tab_info).ctm());
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setOnTabSelectedListener(TabLayout.OnTabSelectedListener onTabSelectedListener) {
        this.jiP.setOnTabSelectedListener(onTabSelectedListener);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            ap.setViewTextColor(this.jiM, R.color.cp_cont_b);
            ap.setViewTextColor(this.mTitleView, R.color.cp_cont_b);
            ap.setViewTextColor(this.jiO, R.color.cp_cont_d);
            ap.setBackgroundColor(this.jiN, R.color.cp_bg_line_c);
            if (this.jiL != null) {
                this.jiL.onChangeSkinType(i);
            }
            if (this.jiP != null) {
                this.jiP.onChangeSkinType(i);
            }
        }
    }
}
