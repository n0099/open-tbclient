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
    protected f aiM;
    private HotTopicTabRankListLayout jBf;
    private TextView jBg;
    private View jBh;
    private TextView jBi;
    private com.baidu.tieba.homepage.hotTopic.tab.view.a jBj;
    private int mSkinType;
    private TextView mTitleView;

    public void setOnItemCoverListener(f fVar) {
        this.aiM = fVar;
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
        this.jBg = new TextView(getContext());
        this.jBg.setTextColor(getContext().getResources().getColor(R.color.cp_cont_b));
        this.jBg.setTextSize(0, l.getDimens(getContext(), R.dimen.tbds44));
        this.jBg.setTypeface(Typeface.DEFAULT_BOLD);
        this.jBg.setIncludeFontPadding(false);
        this.jBg.setSingleLine();
        this.jBg.setEllipsize(TextUtils.TruncateAt.END);
        this.jBg.setGravity(16);
        this.jBg.setPadding(dimens, dimens2, dimens, dimens3);
        addView(this.jBg);
        this.jBf = new HotTopicTabRankListLayout(getContext());
        this.jBf.setPadding(0, 0, 0, dimens3);
        addView(this.jBf);
        this.jBh = new View(getContext());
        this.jBh.setLayoutParams(new LinearLayout.LayoutParams(-1, l.getDimens(getContext(), R.dimen.tbds17)));
        addView(this.jBh);
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
        this.jBi = textView2;
        addView(linearLayout);
        this.jBj = new com.baidu.tieba.homepage.hotTopic.tab.view.a(getContext());
        this.jBj.cKD().setLayoutParams(new LinearLayout.LayoutParams(-1, l.getDimens(getContext(), R.dimen.tbds138)));
        addView(this.jBj.cKD());
        this.jBg.setText(getString(R.string.hot_topic_tab_rank_list_title));
        this.mTitleView.setText(getString(R.string.hot_topic_hot_tie_title));
        this.jBi.setText(getString(R.string.hot_topic_hot_tie_sub_title));
    }

    private String getString(int i) {
        return TbadkCoreApplication.getInst().getString(i);
    }

    public void setData(HotThreadListResIdl hotThreadListResIdl) {
        if (hotThreadListResIdl != null && hotThreadListResIdl.data != null && !y.isEmpty(hotThreadListResIdl.data.topic_list)) {
            this.jBg.setVisibility(0);
            this.jBf.setVisibility(0);
            this.jBf.setOnItemCoverListener(this.aiM);
            this.jBf.a(new d(hotThreadListResIdl.data.topic_list));
        } else {
            this.jBg.setVisibility(8);
            this.jBf.setVisibility(8);
        }
        this.mTitleView.setVisibility(0);
        this.jBi.setVisibility(0);
        this.jBj.a(c.dJ((hotThreadListResIdl == null || hotThreadListResIdl.data == null) ? null : hotThreadListResIdl.data.hot_thread_tab_info).cyU());
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setOnTabSelectedListener(TabLayout.OnTabSelectedListener onTabSelectedListener) {
        this.jBj.setOnTabSelectedListener(onTabSelectedListener);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            ap.setViewTextColor(this.jBg, R.color.cp_cont_b);
            ap.setViewTextColor(this.mTitleView, R.color.cp_cont_b);
            ap.setViewTextColor(this.jBi, R.color.cp_cont_d);
            ap.setBackgroundColor(this.jBh, R.color.cp_bg_line_c);
            if (this.jBf != null) {
                this.jBf.onChangeSkinType(i);
            }
            if (this.jBj != null) {
                this.jBj.onChangeSkinType(i);
            }
        }
    }
}
