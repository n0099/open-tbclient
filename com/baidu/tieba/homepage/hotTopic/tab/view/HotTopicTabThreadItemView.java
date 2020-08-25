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
    private f<com.baidu.tieba.homepage.hotTopic.tab.b.f> ahW;
    private TextView aiw;
    private TextView aix;
    private TextView dSz;
    private int iLR;
    private TbImageView iLZ;
    private View iLd;
    private View iMa;
    private View iMb;
    private ImageView iMc;
    private TextView iMd;
    private View iMe;
    private TextView iMh;
    private com.baidu.tieba.homepage.hotTopic.tab.b.f iMi;
    private final View.OnClickListener mOnClickListener;

    public HotTopicTabThreadItemView(Context context) {
        super(context);
        this.iLR = 3;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.hotTopic.tab.view.HotTopicTabThreadItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HotTopicTabThreadItemView.this.iMi != null && HotTopicTabThreadItemView.this.iMi.dUS != null) {
                    bw bwVar = HotTopicTabThreadItemView.this.iMi.dUS;
                    if (view == HotTopicTabThreadItemView.this.iMe) {
                        if (HotTopicTabThreadItemView.this.ahW != null) {
                            HotTopicTabThreadItemView.this.ahW.a(view, HotTopicTabThreadItemView.this.iMi, HotTopicTabThreadItemView.this.iMi.index, HotTopicTabThreadItemView.this.iMi.index);
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
        this.iLR = 3;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.hotTopic.tab.view.HotTopicTabThreadItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HotTopicTabThreadItemView.this.iMi != null && HotTopicTabThreadItemView.this.iMi.dUS != null) {
                    bw bwVar = HotTopicTabThreadItemView.this.iMi.dUS;
                    if (view == HotTopicTabThreadItemView.this.iMe) {
                        if (HotTopicTabThreadItemView.this.ahW != null) {
                            HotTopicTabThreadItemView.this.ahW.a(view, HotTopicTabThreadItemView.this.iMi, HotTopicTabThreadItemView.this.iMi.index, HotTopicTabThreadItemView.this.iMi.index);
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
        this.iLR = 3;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.hotTopic.tab.view.HotTopicTabThreadItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HotTopicTabThreadItemView.this.iMi != null && HotTopicTabThreadItemView.this.iMi.dUS != null) {
                    bw bwVar = HotTopicTabThreadItemView.this.iMi.dUS;
                    if (view == HotTopicTabThreadItemView.this.iMe) {
                        if (HotTopicTabThreadItemView.this.ahW != null) {
                            HotTopicTabThreadItemView.this.ahW.a(view, HotTopicTabThreadItemView.this.iMi, HotTopicTabThreadItemView.this.iMi.index, HotTopicTabThreadItemView.this.iMi.index);
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
        this.iLZ = (TbImageView) findViewById(R.id.coverView);
        this.iMa = findViewById(R.id.coverGradientMask);
        this.iMb = findViewById(R.id.videoTimeContainer);
        this.iMc = (ImageView) findViewById(R.id.videoPlayIcon);
        this.iMd = (TextView) findViewById(R.id.videoPlayTime);
        this.aiw = (TextView) findViewById(R.id.indexView);
        this.dSz = (TextView) findViewById(R.id.titleView);
        this.aix = (TextView) findViewById(R.id.tagView);
        this.iMh = (TextView) findViewById(R.id.forumView);
        this.iLd = findViewById(R.id.dividerView);
        this.iLZ.setDrawBorder(true);
        this.iLZ.setBorderSurroundContent(true);
        this.iLZ.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.iLZ.setBorderColor(ap.getColor(R.color.cp_border_a));
        this.iLZ.setPlaceHolder(2);
        this.iLZ.setRadius(l.getDimens(getContext(), R.dimen.tbds21));
        this.iLZ.setConrers(15);
        this.iMe = findViewById(R.id.rootLayout);
        this.iMe.setOnClickListener(this.mOnClickListener);
    }

    public void setOnItemCoverListener(f<com.baidu.tieba.homepage.hotTopic.tab.b.f> fVar) {
        this.ahW = fVar;
    }

    public void a(com.baidu.tieba.homepage.hotTopic.tab.b.f fVar) {
        if (fVar != null) {
            this.iMi = fVar;
            if (TextUtils.isEmpty(fVar.cover)) {
                this.iLZ.setVisibility(8);
                this.iMa.setVisibility(8);
                this.iMb.setVisibility(8);
            } else {
                this.iLZ.startLoad(fVar.cover, 10, false);
                this.iLZ.setVisibility(0);
                if (fVar.time > 0) {
                    this.iMb.setVisibility(0);
                    this.iMa.setVisibility(0);
                    this.iMd.setText(StringUtils.translateSecondsToString(fVar.time));
                } else {
                    this.iMb.setVisibility(8);
                    this.iMa.setVisibility(8);
                }
            }
            this.dSz.setText(fVar.title);
            if (!TextUtils.isEmpty(fVar.forumName)) {
                this.iMh.setVisibility(0);
                this.iMh.setText(UtilHelper.getForumNameWithBar(fVar.forumName, 7, true));
            } else {
                this.iMh.setVisibility(8);
            }
            this.aix.setText(this.aix.getContext().getResources().getString(R.string.hot_topic_thread_item_tag, at.cR(fVar.eez >= 1000 ? fVar.eez : 1000)));
            this.aiw.setText(String.valueOf(fVar.index));
            cxH();
            if (this.ahW != null && fVar != null) {
                this.ahW.b(this, fVar, fVar.index, fVar.index);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void cxH() {
        if (this.iMi != null) {
            int oa = TagTextHelper.oa(this.iMi.index);
            Drawable background = this.aiw.getBackground();
            DrawableCompat.setTint(background, ap.getColor(oa));
            this.aiw.setBackgroundDrawable(background);
            this.aix.setCompoundDrawablePadding(l.getDimens(getContext(), R.dimen.tbds8));
            int color = ap.getColor(oa);
            Drawable mutate = ap.getDrawable(R.drawable.icon_pure_topic_hot).mutate();
            int dimens = l.getDimens(getContext(), R.dimen.tbds31);
            mutate.setBounds(0, 0, dimens, dimens);
            DrawableCompat.setTint(mutate, color);
            this.aix.setCompoundDrawables(mutate, null, null, null);
            this.aix.setBackgroundDrawable(null);
            ap.setViewTextColor(this.aix, oa);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.iLR != i) {
            com.baidu.tbadk.core.util.e.a.g(this.iMe, R.color.cp_bg_line_e, R.color.cp_bg_line_c);
            ap.setViewTextColor(this.dSz, R.color.cp_cont_b);
            ap.setViewTextColor(this.aiw, R.color.cp_cont_a);
            ap.setViewTextColor(this.iMd, R.color.cp_cont_a);
            ap.setViewTextColor(this.iMh, R.color.cp_cont_d);
            ap.setBackgroundColor(this.iLd, R.color.cp_bg_line_b);
            SvgManager.bjq().a(this.iMc, R.drawable.ic_icon_pure_video_play12_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
            cxH();
            this.iLR = i;
        }
    }
}
