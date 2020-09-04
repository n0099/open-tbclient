package com.baidu.tieba.homepage.hotTopic.tab.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TagTextHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.h.f;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes16.dex */
public class HotTopicTabThreadItemView extends RelativeLayout {
    private f<com.baidu.tieba.homepage.hotTopic.tab.b.f> ahY;
    private TextView aiy;
    private TextView aiz;
    private TextView dSD;
    private int iLX;
    private View iLj;
    private TbImageView iMf;
    private View iMg;
    private View iMh;
    private ImageView iMi;
    private TextView iMj;
    private View iMk;
    private TextView iMn;
    private com.baidu.tieba.homepage.hotTopic.tab.b.f iMo;
    private final View.OnClickListener mOnClickListener;

    public HotTopicTabThreadItemView(Context context) {
        super(context);
        this.iLX = 3;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.hotTopic.tab.view.HotTopicTabThreadItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HotTopicTabThreadItemView.this.iMo != null && HotTopicTabThreadItemView.this.iMo.dUW != null) {
                    bw bwVar = HotTopicTabThreadItemView.this.iMo.dUW;
                    if (view == HotTopicTabThreadItemView.this.iMk) {
                        if (HotTopicTabThreadItemView.this.ahY != null) {
                            HotTopicTabThreadItemView.this.ahY.a(view, HotTopicTabThreadItemView.this.iMo, HotTopicTabThreadItemView.this.iMo.index, HotTopicTabThreadItemView.this.iMo.index);
                        }
                        ay.a((AbsThreadDataSupport) bwVar, view.getContext(), 0, false, true);
                    }
                }
            }
        };
        initView();
    }

    public HotTopicTabThreadItemView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iLX = 3;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.hotTopic.tab.view.HotTopicTabThreadItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HotTopicTabThreadItemView.this.iMo != null && HotTopicTabThreadItemView.this.iMo.dUW != null) {
                    bw bwVar = HotTopicTabThreadItemView.this.iMo.dUW;
                    if (view == HotTopicTabThreadItemView.this.iMk) {
                        if (HotTopicTabThreadItemView.this.ahY != null) {
                            HotTopicTabThreadItemView.this.ahY.a(view, HotTopicTabThreadItemView.this.iMo, HotTopicTabThreadItemView.this.iMo.index, HotTopicTabThreadItemView.this.iMo.index);
                        }
                        ay.a((AbsThreadDataSupport) bwVar, view.getContext(), 0, false, true);
                    }
                }
            }
        };
        initView();
    }

    public HotTopicTabThreadItemView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iLX = 3;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.hotTopic.tab.view.HotTopicTabThreadItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HotTopicTabThreadItemView.this.iMo != null && HotTopicTabThreadItemView.this.iMo.dUW != null) {
                    bw bwVar = HotTopicTabThreadItemView.this.iMo.dUW;
                    if (view == HotTopicTabThreadItemView.this.iMk) {
                        if (HotTopicTabThreadItemView.this.ahY != null) {
                            HotTopicTabThreadItemView.this.ahY.a(view, HotTopicTabThreadItemView.this.iMo, HotTopicTabThreadItemView.this.iMo.index, HotTopicTabThreadItemView.this.iMo.index);
                        }
                        ay.a((AbsThreadDataSupport) bwVar, view.getContext(), 0, false, true);
                    }
                }
            }
        };
        initView();
    }

    private void initView() {
        LayoutInflater.from(getContext()).inflate(R.layout.hot_topic_tab_thread_item_view_a, (ViewGroup) this, true);
        this.iMf = (TbImageView) findViewById(R.id.coverView);
        this.iMg = findViewById(R.id.coverGradientMask);
        this.iMh = findViewById(R.id.videoTimeContainer);
        this.iMi = (ImageView) findViewById(R.id.videoPlayIcon);
        this.iMj = (TextView) findViewById(R.id.videoPlayTime);
        this.aiy = (TextView) findViewById(R.id.indexView);
        this.dSD = (TextView) findViewById(R.id.titleView);
        this.aiz = (TextView) findViewById(R.id.tagView);
        this.iMn = (TextView) findViewById(R.id.forumView);
        this.iLj = findViewById(R.id.dividerView);
        this.iMf.setDrawBorder(true);
        this.iMf.setBorderSurroundContent(true);
        this.iMf.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.iMf.setBorderColor(ap.getColor(R.color.cp_border_a));
        this.iMf.setPlaceHolder(2);
        this.iMf.setRadius(l.getDimens(getContext(), R.dimen.tbds21));
        this.iMf.setConrers(15);
        this.iMk = findViewById(R.id.rootLayout);
        this.iMk.setOnClickListener(this.mOnClickListener);
    }

    public void setOnItemCoverListener(f<com.baidu.tieba.homepage.hotTopic.tab.b.f> fVar) {
        this.ahY = fVar;
    }

    public void a(com.baidu.tieba.homepage.hotTopic.tab.b.f fVar) {
        if (fVar != null) {
            this.iMo = fVar;
            if (TextUtils.isEmpty(fVar.cover)) {
                this.iMf.setVisibility(8);
                this.iMg.setVisibility(8);
                this.iMh.setVisibility(8);
            } else {
                this.iMf.startLoad(fVar.cover, 10, false);
                this.iMf.setVisibility(0);
                if (fVar.time > 0) {
                    this.iMh.setVisibility(0);
                    this.iMg.setVisibility(0);
                    this.iMj.setText(StringUtils.translateSecondsToString(fVar.time));
                } else {
                    this.iMh.setVisibility(8);
                    this.iMg.setVisibility(8);
                }
            }
            this.dSD.setText(fVar.title);
            if (!TextUtils.isEmpty(fVar.forumName)) {
                this.iMn.setVisibility(0);
                this.iMn.setText(UtilHelper.getForumNameWithBar(fVar.forumName, 7, true));
            } else {
                this.iMn.setVisibility(8);
            }
            this.aiz.setText(this.aiz.getContext().getResources().getString(R.string.hot_topic_thread_item_tag, at.cR(fVar.eeD >= 1000 ? fVar.eeD : 1000)));
            this.aiy.setText(String.valueOf(fVar.index));
            cxI();
            if (this.ahY != null && fVar != null) {
                this.ahY.b(this, fVar, fVar.index, fVar.index);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void cxI() {
        if (this.iMo != null) {
            int oa = TagTextHelper.oa(this.iMo.index);
            Drawable background = this.aiy.getBackground();
            DrawableCompat.setTint(background, ap.getColor(oa));
            this.aiy.setBackgroundDrawable(background);
            this.aiz.setCompoundDrawablePadding(l.getDimens(getContext(), R.dimen.tbds8));
            int color = ap.getColor(oa);
            Drawable mutate = ap.getDrawable(R.drawable.icon_pure_topic_hot).mutate();
            int dimens = l.getDimens(getContext(), R.dimen.tbds31);
            mutate.setBounds(0, 0, dimens, dimens);
            DrawableCompat.setTint(mutate, color);
            this.aiz.setCompoundDrawables(mutate, null, null, null);
            this.aiz.setBackgroundDrawable(null);
            ap.setViewTextColor(this.aiz, oa);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.iLX != i) {
            com.baidu.tbadk.core.util.e.a.g(this.iMk, R.color.cp_bg_line_e, R.color.cp_bg_line_c);
            ap.setViewTextColor(this.dSD, R.color.cp_cont_b);
            ap.setViewTextColor(this.aiy, R.color.cp_cont_a);
            ap.setViewTextColor(this.iMj, R.color.cp_cont_a);
            ap.setViewTextColor(this.iMn, R.color.cp_cont_d);
            ap.setBackgroundColor(this.iLj, R.color.cp_bg_line_b);
            SvgManager.bjq().a(this.iMi, R.drawable.ic_icon_pure_video_play12_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
            cxI();
            this.iLX = i;
        }
    }
}
