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
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TagTextHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.h.f;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes21.dex */
public class HotTopicTabThreadItemView extends RelativeLayout {
    private f<com.baidu.tieba.homepage.hotTopic.tab.b.f> aiR;
    private TextView ajq;
    private TextView ajr;
    private TextView etx;
    private int jCS;
    private TbImageView jDa;
    private View jDb;
    private View jDc;
    private ImageView jDd;
    private TextView jDe;
    private View jDf;
    private TextView jDi;
    private View jDj;
    private com.baidu.tieba.homepage.hotTopic.tab.b.f jDk;
    private final View.OnClickListener mOnClickListener;

    public HotTopicTabThreadItemView(Context context) {
        super(context);
        this.jCS = 3;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.hotTopic.tab.view.HotTopicTabThreadItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HotTopicTabThreadItemView.this.jDk != null && HotTopicTabThreadItemView.this.jDk.evQ != null) {
                    bx bxVar = HotTopicTabThreadItemView.this.jDk.evQ;
                    if (view == HotTopicTabThreadItemView.this.jDf) {
                        if (HotTopicTabThreadItemView.this.aiR != null) {
                            HotTopicTabThreadItemView.this.aiR.a(view, HotTopicTabThreadItemView.this.jDk, HotTopicTabThreadItemView.this.jDk.index, HotTopicTabThreadItemView.this.jDk.index);
                        }
                        az.a((com.baidu.tbadk.core.data.a) bxVar, view.getContext(), 0, false, true);
                    }
                }
            }
        };
        initView();
    }

    public HotTopicTabThreadItemView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jCS = 3;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.hotTopic.tab.view.HotTopicTabThreadItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HotTopicTabThreadItemView.this.jDk != null && HotTopicTabThreadItemView.this.jDk.evQ != null) {
                    bx bxVar = HotTopicTabThreadItemView.this.jDk.evQ;
                    if (view == HotTopicTabThreadItemView.this.jDf) {
                        if (HotTopicTabThreadItemView.this.aiR != null) {
                            HotTopicTabThreadItemView.this.aiR.a(view, HotTopicTabThreadItemView.this.jDk, HotTopicTabThreadItemView.this.jDk.index, HotTopicTabThreadItemView.this.jDk.index);
                        }
                        az.a((com.baidu.tbadk.core.data.a) bxVar, view.getContext(), 0, false, true);
                    }
                }
            }
        };
        initView();
    }

    public HotTopicTabThreadItemView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jCS = 3;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.hotTopic.tab.view.HotTopicTabThreadItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HotTopicTabThreadItemView.this.jDk != null && HotTopicTabThreadItemView.this.jDk.evQ != null) {
                    bx bxVar = HotTopicTabThreadItemView.this.jDk.evQ;
                    if (view == HotTopicTabThreadItemView.this.jDf) {
                        if (HotTopicTabThreadItemView.this.aiR != null) {
                            HotTopicTabThreadItemView.this.aiR.a(view, HotTopicTabThreadItemView.this.jDk, HotTopicTabThreadItemView.this.jDk.index, HotTopicTabThreadItemView.this.jDk.index);
                        }
                        az.a((com.baidu.tbadk.core.data.a) bxVar, view.getContext(), 0, false, true);
                    }
                }
            }
        };
        initView();
    }

    private void initView() {
        LayoutInflater.from(getContext()).inflate(R.layout.hot_topic_tab_thread_item_view_a, (ViewGroup) this, true);
        this.jDa = (TbImageView) findViewById(R.id.coverView);
        this.jDb = findViewById(R.id.coverGradientMask);
        this.jDc = findViewById(R.id.videoTimeContainer);
        this.jDd = (ImageView) findViewById(R.id.videoPlayIcon);
        this.jDe = (TextView) findViewById(R.id.videoPlayTime);
        this.ajq = (TextView) findViewById(R.id.indexView);
        this.etx = (TextView) findViewById(R.id.titleView);
        this.ajr = (TextView) findViewById(R.id.tagView);
        this.jDi = (TextView) findViewById(R.id.forumView);
        this.jDj = findViewById(R.id.dividerView);
        this.jDa.setDrawBorder(true);
        this.jDa.setBorderSurroundContent(true);
        this.jDa.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.jDa.setBorderColor(ap.getColor(R.color.CAM_X0401));
        this.jDa.setPlaceHolder(2);
        this.jDa.setRadius(l.getDimens(getContext(), R.dimen.tbds21));
        this.jDa.setConrers(15);
        this.jDf = findViewById(R.id.rootLayout);
        this.jDf.setOnClickListener(this.mOnClickListener);
    }

    public void setOnItemCoverListener(f<com.baidu.tieba.homepage.hotTopic.tab.b.f> fVar) {
        this.aiR = fVar;
    }

    public void a(com.baidu.tieba.homepage.hotTopic.tab.b.f fVar) {
        if (fVar != null) {
            this.jDk = fVar;
            if (TextUtils.isEmpty(fVar.cover)) {
                this.jDa.setVisibility(8);
                this.jDb.setVisibility(8);
                this.jDc.setVisibility(8);
            } else {
                this.jDa.startLoad(fVar.cover, 10, false);
                this.jDa.setVisibility(0);
                if (fVar.time > 0) {
                    this.jDc.setVisibility(0);
                    this.jDb.setVisibility(0);
                    this.jDe.setText(StringUtils.translateSecondsToString(fVar.time));
                } else {
                    this.jDc.setVisibility(8);
                    this.jDb.setVisibility(8);
                }
            }
            this.etx.setText(fVar.title);
            if (!TextUtils.isEmpty(fVar.forumName)) {
                this.jDi.setVisibility(0);
                this.jDi.setText(UtilHelper.getForumNameWithBar(fVar.forumName, 7, true));
            } else {
                this.jDi.setVisibility(8);
            }
            this.ajr.setText(this.ajr.getContext().getResources().getString(R.string.hot_topic_thread_item_tag, au.dy(fVar.eFz >= 1000 ? fVar.eFz : 1000)));
            this.ajq.setText(String.valueOf(fVar.index));
            cKk();
            if (this.aiR != null && fVar != null) {
                this.aiR.b(this, fVar, fVar.index, fVar.index);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void cKk() {
        if (this.jDk != null) {
            int pA = TagTextHelper.pA(this.jDk.index);
            Drawable background = this.ajq.getBackground();
            DrawableCompat.setTint(background, ap.getColor(pA));
            this.ajq.setBackgroundDrawable(background);
            this.ajr.setCompoundDrawablePadding(l.getDimens(getContext(), R.dimen.tbds8));
            int color = ap.getColor(pA);
            Drawable mutate = ap.getDrawable(R.drawable.icon_pure_topic_hot).mutate();
            int dimens = l.getDimens(getContext(), R.dimen.tbds31);
            mutate.setBounds(0, 0, dimens, dimens);
            DrawableCompat.setTint(mutate, color);
            this.ajr.setCompoundDrawables(mutate, null, null, null);
            this.ajr.setBackgroundDrawable(null);
            ap.setViewTextColor(this.ajr, pA);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.jCS != i) {
            com.baidu.tbadk.core.util.e.a.h(this.jDf, R.color.CAM_X0205, R.color.CAM_X0204);
            ap.setViewTextColor(this.etx, R.color.CAM_X0105);
            ap.setViewTextColor(this.ajq, R.color.CAM_X0101);
            ap.setViewTextColor(this.jDe, R.color.CAM_X0101);
            ap.setViewTextColor(this.jDi, R.color.CAM_X0109);
            ap.setBackgroundColor(this.jDj, R.color.CAM_X0203);
            SvgManager.bqB().a(this.jDd, R.drawable.ic_icon_pure_video_play12_svg, R.color.CAM_X0101, (SvgManager.SvgResourceStateType) null);
            cKk();
            this.jCS = i;
        }
    }
}
