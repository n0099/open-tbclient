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
/* loaded from: classes16.dex */
public class HotTopicHeaderView extends LinearLayout {
    protected f ahW;
    private HotTopicTabRankListLayout iLb;
    private TextView iLc;
    private View iLd;
    private TextView iLe;
    private com.baidu.tieba.homepage.hotTopic.tab.view.a iLf;
    private int mSkinType;
    private TextView mTitleView;

    public void setOnItemCoverListener(f fVar) {
        this.ahW = fVar;
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
        this.iLc = new TextView(getContext());
        this.iLc.setTextColor(getContext().getResources().getColor(R.color.cp_cont_b));
        this.iLc.setTextSize(0, l.getDimens(getContext(), R.dimen.tbds44));
        this.iLc.setTypeface(Typeface.DEFAULT_BOLD);
        this.iLc.setIncludeFontPadding(false);
        this.iLc.setSingleLine();
        this.iLc.setEllipsize(TextUtils.TruncateAt.END);
        this.iLc.setGravity(16);
        this.iLc.setPadding(dimens, dimens2, dimens, dimens3);
        addView(this.iLc);
        this.iLb = new HotTopicTabRankListLayout(getContext());
        this.iLb.setPadding(0, 0, 0, dimens3);
        addView(this.iLb);
        this.iLd = new View(getContext());
        this.iLd.setLayoutParams(new LinearLayout.LayoutParams(-1, l.getDimens(getContext(), R.dimen.tbds17)));
        addView(this.iLd);
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
        this.iLe = textView2;
        addView(linearLayout);
        this.iLf = new com.baidu.tieba.homepage.hotTopic.tab.view.a(getContext());
        this.iLf.cxF().setLayoutParams(new LinearLayout.LayoutParams(-1, l.getDimens(getContext(), R.dimen.tbds138)));
        addView(this.iLf.cxF());
        this.iLc.setText(getString(R.string.hot_topic_tab_rank_list_title));
        this.mTitleView.setText(getString(R.string.hot_topic_hot_tie_title));
        this.iLe.setText(getString(R.string.hot_topic_hot_tie_sub_title));
    }

    private String getString(int i) {
        return TbadkCoreApplication.getInst().getString(i);
    }

    public void setData(HotThreadListResIdl hotThreadListResIdl) {
        if (hotThreadListResIdl != null && hotThreadListResIdl.data != null && !y.isEmpty(hotThreadListResIdl.data.topic_list)) {
            this.iLc.setVisibility(0);
            this.iLb.setVisibility(0);
            this.iLb.setOnItemCoverListener(this.ahW);
            this.iLb.a(new d(hotThreadListResIdl.data.topic_list));
        } else {
            this.iLc.setVisibility(8);
            this.iLb.setVisibility(8);
        }
        this.mTitleView.setVisibility(0);
        this.iLe.setVisibility(0);
        this.iLf.a(c.dh((hotThreadListResIdl == null || hotThreadListResIdl.data == null) ? null : hotThreadListResIdl.data.hot_thread_tab_info).cmB());
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setOnTabSelectedListener(TabLayout.OnTabSelectedListener onTabSelectedListener) {
        this.iLf.setOnTabSelectedListener(onTabSelectedListener);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            ap.setViewTextColor(this.iLc, R.color.cp_cont_b);
            ap.setViewTextColor(this.mTitleView, R.color.cp_cont_b);
            ap.setViewTextColor(this.iLe, R.color.cp_cont_d);
            ap.setBackgroundColor(this.iLd, R.color.cp_bg_line_c);
            if (this.iLb != null) {
                this.iLb.onChangeSkinType(i);
            }
            if (this.iLf != null) {
                this.iLf.onChangeSkinType(i);
            }
        }
    }
}
