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
/* loaded from: classes22.dex */
public class HotTopicTabThreadItemView extends RelativeLayout {
    private f<com.baidu.tieba.homepage.hotTopic.tab.b.f> aiM;
    private TextView ajl;
    private TextView ajm;
    private TextView evg;
    private int jBV;
    private View jBh;
    private TbImageView jCd;
    private View jCe;
    private View jCf;
    private ImageView jCg;
    private TextView jCh;
    private View jCi;
    private TextView jCl;
    private com.baidu.tieba.homepage.hotTopic.tab.b.f jCm;
    private final View.OnClickListener mOnClickListener;

    public HotTopicTabThreadItemView(Context context) {
        super(context);
        this.jBV = 3;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.hotTopic.tab.view.HotTopicTabThreadItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HotTopicTabThreadItemView.this.jCm != null && HotTopicTabThreadItemView.this.jCm.exA != null) {
                    bw bwVar = HotTopicTabThreadItemView.this.jCm.exA;
                    if (view == HotTopicTabThreadItemView.this.jCi) {
                        if (HotTopicTabThreadItemView.this.aiM != null) {
                            HotTopicTabThreadItemView.this.aiM.a(view, HotTopicTabThreadItemView.this.jCm, HotTopicTabThreadItemView.this.jCm.index, HotTopicTabThreadItemView.this.jCm.index);
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
        this.jBV = 3;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.hotTopic.tab.view.HotTopicTabThreadItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HotTopicTabThreadItemView.this.jCm != null && HotTopicTabThreadItemView.this.jCm.exA != null) {
                    bw bwVar = HotTopicTabThreadItemView.this.jCm.exA;
                    if (view == HotTopicTabThreadItemView.this.jCi) {
                        if (HotTopicTabThreadItemView.this.aiM != null) {
                            HotTopicTabThreadItemView.this.aiM.a(view, HotTopicTabThreadItemView.this.jCm, HotTopicTabThreadItemView.this.jCm.index, HotTopicTabThreadItemView.this.jCm.index);
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
        this.jBV = 3;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.hotTopic.tab.view.HotTopicTabThreadItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HotTopicTabThreadItemView.this.jCm != null && HotTopicTabThreadItemView.this.jCm.exA != null) {
                    bw bwVar = HotTopicTabThreadItemView.this.jCm.exA;
                    if (view == HotTopicTabThreadItemView.this.jCi) {
                        if (HotTopicTabThreadItemView.this.aiM != null) {
                            HotTopicTabThreadItemView.this.aiM.a(view, HotTopicTabThreadItemView.this.jCm, HotTopicTabThreadItemView.this.jCm.index, HotTopicTabThreadItemView.this.jCm.index);
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
        this.jCd = (TbImageView) findViewById(R.id.coverView);
        this.jCe = findViewById(R.id.coverGradientMask);
        this.jCf = findViewById(R.id.videoTimeContainer);
        this.jCg = (ImageView) findViewById(R.id.videoPlayIcon);
        this.jCh = (TextView) findViewById(R.id.videoPlayTime);
        this.ajl = (TextView) findViewById(R.id.indexView);
        this.evg = (TextView) findViewById(R.id.titleView);
        this.ajm = (TextView) findViewById(R.id.tagView);
        this.jCl = (TextView) findViewById(R.id.forumView);
        this.jBh = findViewById(R.id.dividerView);
        this.jCd.setDrawBorder(true);
        this.jCd.setBorderSurroundContent(true);
        this.jCd.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.jCd.setBorderColor(ap.getColor(R.color.cp_border_a));
        this.jCd.setPlaceHolder(2);
        this.jCd.setRadius(l.getDimens(getContext(), R.dimen.tbds21));
        this.jCd.setConrers(15);
        this.jCi = findViewById(R.id.rootLayout);
        this.jCi.setOnClickListener(this.mOnClickListener);
    }

    public void setOnItemCoverListener(f<com.baidu.tieba.homepage.hotTopic.tab.b.f> fVar) {
        this.aiM = fVar;
    }

    public void a(com.baidu.tieba.homepage.hotTopic.tab.b.f fVar) {
        if (fVar != null) {
            this.jCm = fVar;
            if (TextUtils.isEmpty(fVar.cover)) {
                this.jCd.setVisibility(8);
                this.jCe.setVisibility(8);
                this.jCf.setVisibility(8);
            } else {
                this.jCd.startLoad(fVar.cover, 10, false);
                this.jCd.setVisibility(0);
                if (fVar.time > 0) {
                    this.jCf.setVisibility(0);
                    this.jCe.setVisibility(0);
                    this.jCh.setText(StringUtils.translateSecondsToString(fVar.time));
                } else {
                    this.jCf.setVisibility(8);
                    this.jCe.setVisibility(8);
                }
            }
            this.evg.setText(fVar.title);
            if (!TextUtils.isEmpty(fVar.forumName)) {
                this.jCl.setVisibility(0);
                this.jCl.setText(UtilHelper.getForumNameWithBar(fVar.forumName, 7, true));
            } else {
                this.jCl.setVisibility(8);
            }
            this.ajm.setText(this.ajm.getContext().getResources().getString(R.string.hot_topic_thread_item_tag, at.dy(fVar.eHh >= 1000 ? fVar.eHh : 1000)));
            this.ajl.setText(String.valueOf(fVar.index));
            cKF();
            if (this.aiM != null && fVar != null) {
                this.aiM.b(this, fVar, fVar.index, fVar.index);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void cKF() {
        if (this.jCm != null) {
            int pe = TagTextHelper.pe(this.jCm.index);
            Drawable background = this.ajl.getBackground();
            DrawableCompat.setTint(background, ap.getColor(pe));
            this.ajl.setBackgroundDrawable(background);
            this.ajm.setCompoundDrawablePadding(l.getDimens(getContext(), R.dimen.tbds8));
            int color = ap.getColor(pe);
            Drawable mutate = ap.getDrawable(R.drawable.icon_pure_topic_hot).mutate();
            int dimens = l.getDimens(getContext(), R.dimen.tbds31);
            mutate.setBounds(0, 0, dimens, dimens);
            DrawableCompat.setTint(mutate, color);
            this.ajm.setCompoundDrawables(mutate, null, null, null);
            this.ajm.setBackgroundDrawable(null);
            ap.setViewTextColor(this.ajm, pe);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.jBV != i) {
            com.baidu.tbadk.core.util.e.a.g(this.jCi, R.color.cp_bg_line_e, R.color.cp_bg_line_c);
            ap.setViewTextColor(this.evg, R.color.cp_cont_b);
            ap.setViewTextColor(this.ajl, R.color.cp_cont_a);
            ap.setViewTextColor(this.jCh, R.color.cp_cont_a);
            ap.setViewTextColor(this.jCl, R.color.cp_cont_d);
            ap.setBackgroundColor(this.jBh, R.color.cp_bg_line_b);
            SvgManager.brn().a(this.jCg, R.drawable.ic_icon_pure_video_play12_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
            cKF();
            this.jBV = i;
        }
    }
}
