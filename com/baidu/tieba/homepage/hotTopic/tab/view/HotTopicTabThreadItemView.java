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
    private f<com.baidu.tieba.homepage.hotTopic.tab.b.f> aiL;
    private TextView ajk;
    private TextView ajl;
    private TextView egP;
    private View jiN;
    private int jjB;
    private TbImageView jjJ;
    private View jjK;
    private View jjL;
    private ImageView jjM;
    private TextView jjN;
    private View jjO;
    private TextView jjR;
    private com.baidu.tieba.homepage.hotTopic.tab.b.f jjS;
    private final View.OnClickListener mOnClickListener;

    public HotTopicTabThreadItemView(Context context) {
        super(context);
        this.jjB = 3;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.hotTopic.tab.view.HotTopicTabThreadItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HotTopicTabThreadItemView.this.jjS != null && HotTopicTabThreadItemView.this.jjS.eji != null) {
                    bw bwVar = HotTopicTabThreadItemView.this.jjS.eji;
                    if (view == HotTopicTabThreadItemView.this.jjO) {
                        if (HotTopicTabThreadItemView.this.aiL != null) {
                            HotTopicTabThreadItemView.this.aiL.a(view, HotTopicTabThreadItemView.this.jjS, HotTopicTabThreadItemView.this.jjS.index, HotTopicTabThreadItemView.this.jjS.index);
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
        this.jjB = 3;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.hotTopic.tab.view.HotTopicTabThreadItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HotTopicTabThreadItemView.this.jjS != null && HotTopicTabThreadItemView.this.jjS.eji != null) {
                    bw bwVar = HotTopicTabThreadItemView.this.jjS.eji;
                    if (view == HotTopicTabThreadItemView.this.jjO) {
                        if (HotTopicTabThreadItemView.this.aiL != null) {
                            HotTopicTabThreadItemView.this.aiL.a(view, HotTopicTabThreadItemView.this.jjS, HotTopicTabThreadItemView.this.jjS.index, HotTopicTabThreadItemView.this.jjS.index);
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
        this.jjB = 3;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.hotTopic.tab.view.HotTopicTabThreadItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HotTopicTabThreadItemView.this.jjS != null && HotTopicTabThreadItemView.this.jjS.eji != null) {
                    bw bwVar = HotTopicTabThreadItemView.this.jjS.eji;
                    if (view == HotTopicTabThreadItemView.this.jjO) {
                        if (HotTopicTabThreadItemView.this.aiL != null) {
                            HotTopicTabThreadItemView.this.aiL.a(view, HotTopicTabThreadItemView.this.jjS, HotTopicTabThreadItemView.this.jjS.index, HotTopicTabThreadItemView.this.jjS.index);
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
        this.jjJ = (TbImageView) findViewById(R.id.coverView);
        this.jjK = findViewById(R.id.coverGradientMask);
        this.jjL = findViewById(R.id.videoTimeContainer);
        this.jjM = (ImageView) findViewById(R.id.videoPlayIcon);
        this.jjN = (TextView) findViewById(R.id.videoPlayTime);
        this.ajk = (TextView) findViewById(R.id.indexView);
        this.egP = (TextView) findViewById(R.id.titleView);
        this.ajl = (TextView) findViewById(R.id.tagView);
        this.jjR = (TextView) findViewById(R.id.forumView);
        this.jiN = findViewById(R.id.dividerView);
        this.jjJ.setDrawBorder(true);
        this.jjJ.setBorderSurroundContent(true);
        this.jjJ.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.jjJ.setBorderColor(ap.getColor(R.color.cp_border_a));
        this.jjJ.setPlaceHolder(2);
        this.jjJ.setRadius(l.getDimens(getContext(), R.dimen.tbds21));
        this.jjJ.setConrers(15);
        this.jjO = findViewById(R.id.rootLayout);
        this.jjO.setOnClickListener(this.mOnClickListener);
    }

    public void setOnItemCoverListener(f<com.baidu.tieba.homepage.hotTopic.tab.b.f> fVar) {
        this.aiL = fVar;
    }

    public void a(com.baidu.tieba.homepage.hotTopic.tab.b.f fVar) {
        if (fVar != null) {
            this.jjS = fVar;
            if (TextUtils.isEmpty(fVar.cover)) {
                this.jjJ.setVisibility(8);
                this.jjK.setVisibility(8);
                this.jjL.setVisibility(8);
            } else {
                this.jjJ.startLoad(fVar.cover, 10, false);
                this.jjJ.setVisibility(0);
                if (fVar.time > 0) {
                    this.jjL.setVisibility(0);
                    this.jjK.setVisibility(0);
                    this.jjN.setText(StringUtils.translateSecondsToString(fVar.time));
                } else {
                    this.jjL.setVisibility(8);
                    this.jjK.setVisibility(8);
                }
            }
            this.egP.setText(fVar.title);
            if (!TextUtils.isEmpty(fVar.forumName)) {
                this.jjR.setVisibility(0);
                this.jjR.setText(UtilHelper.getForumNameWithBar(fVar.forumName, 7, true));
            } else {
                this.jjR.setVisibility(8);
            }
            this.ajl.setText(this.ajl.getContext().getResources().getString(R.string.hot_topic_thread_item_tag, at.da(fVar.esS >= 1000 ? fVar.esS : 1000)));
            this.ajk.setText(String.valueOf(fVar.index));
            cEX();
            if (this.aiL != null && fVar != null) {
                this.aiL.b(this, fVar, fVar.index, fVar.index);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void cEX() {
        if (this.jjS != null) {
            int oJ = TagTextHelper.oJ(this.jjS.index);
            Drawable background = this.ajk.getBackground();
            DrawableCompat.setTint(background, ap.getColor(oJ));
            this.ajk.setBackgroundDrawable(background);
            this.ajl.setCompoundDrawablePadding(l.getDimens(getContext(), R.dimen.tbds8));
            int color = ap.getColor(oJ);
            Drawable mutate = ap.getDrawable(R.drawable.icon_pure_topic_hot).mutate();
            int dimens = l.getDimens(getContext(), R.dimen.tbds31);
            mutate.setBounds(0, 0, dimens, dimens);
            DrawableCompat.setTint(mutate, color);
            this.ajl.setCompoundDrawables(mutate, null, null, null);
            this.ajl.setBackgroundDrawable(null);
            ap.setViewTextColor(this.ajl, oJ);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.jjB != i) {
            com.baidu.tbadk.core.util.e.a.g(this.jjO, R.color.cp_bg_line_e, R.color.cp_bg_line_c);
            ap.setViewTextColor(this.egP, R.color.cp_cont_b);
            ap.setViewTextColor(this.ajk, R.color.cp_cont_a);
            ap.setViewTextColor(this.jjN, R.color.cp_cont_a);
            ap.setViewTextColor(this.jjR, R.color.cp_cont_d);
            ap.setBackgroundColor(this.jiN, R.color.cp_bg_line_b);
            SvgManager.bmU().a(this.jjM, R.drawable.ic_icon_pure_video_play12_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
            cEX();
            this.jjB = i;
        }
    }
}
