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
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TagTextHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.h.f;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes22.dex */
public class HotTopicTabThreadItemView extends RelativeLayout {
    private f<com.baidu.tieba.homepage.hotTopic.tab.b.f> ajQ;
    private TextView akp;
    private TextView akq;
    private TextView eAz;
    private TbImageView jQC;
    private View jQD;
    private View jQE;
    private ImageView jQF;
    private TextView jQG;
    private View jQH;
    private TextView jQK;
    private View jQL;
    private com.baidu.tieba.homepage.hotTopic.tab.b.f jQM;
    private int jQu;
    private final View.OnClickListener mOnClickListener;

    public HotTopicTabThreadItemView(Context context) {
        super(context);
        this.jQu = 3;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.hotTopic.tab.view.HotTopicTabThreadItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HotTopicTabThreadItemView.this.jQM != null && HotTopicTabThreadItemView.this.jQM.eCR != null) {
                    by byVar = HotTopicTabThreadItemView.this.jQM.eCR;
                    if (view == HotTopicTabThreadItemView.this.jQH) {
                        if (HotTopicTabThreadItemView.this.ajQ != null) {
                            HotTopicTabThreadItemView.this.ajQ.a(view, HotTopicTabThreadItemView.this.jQM, HotTopicTabThreadItemView.this.jQM.index, HotTopicTabThreadItemView.this.jQM.index);
                        }
                        az.a((com.baidu.tbadk.core.data.a) byVar, view.getContext(), 0, false, true);
                    }
                }
            }
        };
        initView();
    }

    public HotTopicTabThreadItemView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jQu = 3;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.hotTopic.tab.view.HotTopicTabThreadItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HotTopicTabThreadItemView.this.jQM != null && HotTopicTabThreadItemView.this.jQM.eCR != null) {
                    by byVar = HotTopicTabThreadItemView.this.jQM.eCR;
                    if (view == HotTopicTabThreadItemView.this.jQH) {
                        if (HotTopicTabThreadItemView.this.ajQ != null) {
                            HotTopicTabThreadItemView.this.ajQ.a(view, HotTopicTabThreadItemView.this.jQM, HotTopicTabThreadItemView.this.jQM.index, HotTopicTabThreadItemView.this.jQM.index);
                        }
                        az.a((com.baidu.tbadk.core.data.a) byVar, view.getContext(), 0, false, true);
                    }
                }
            }
        };
        initView();
    }

    public HotTopicTabThreadItemView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jQu = 3;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.hotTopic.tab.view.HotTopicTabThreadItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HotTopicTabThreadItemView.this.jQM != null && HotTopicTabThreadItemView.this.jQM.eCR != null) {
                    by byVar = HotTopicTabThreadItemView.this.jQM.eCR;
                    if (view == HotTopicTabThreadItemView.this.jQH) {
                        if (HotTopicTabThreadItemView.this.ajQ != null) {
                            HotTopicTabThreadItemView.this.ajQ.a(view, HotTopicTabThreadItemView.this.jQM, HotTopicTabThreadItemView.this.jQM.index, HotTopicTabThreadItemView.this.jQM.index);
                        }
                        az.a((com.baidu.tbadk.core.data.a) byVar, view.getContext(), 0, false, true);
                    }
                }
            }
        };
        initView();
    }

    private void initView() {
        LayoutInflater.from(getContext()).inflate(R.layout.hot_topic_tab_thread_item_view_a, (ViewGroup) this, true);
        this.jQC = (TbImageView) findViewById(R.id.coverView);
        this.jQD = findViewById(R.id.coverGradientMask);
        this.jQE = findViewById(R.id.videoTimeContainer);
        this.jQF = (ImageView) findViewById(R.id.videoPlayIcon);
        this.jQG = (TextView) findViewById(R.id.videoPlayTime);
        this.akp = (TextView) findViewById(R.id.indexView);
        this.eAz = (TextView) findViewById(R.id.titleView);
        this.akq = (TextView) findViewById(R.id.tagView);
        this.jQK = (TextView) findViewById(R.id.forumView);
        this.jQL = findViewById(R.id.dividerView);
        this.jQC.setDrawBorder(true);
        this.jQC.setBorderSurroundContent(true);
        this.jQC.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.jQC.setBorderColor(ap.getColor(R.color.CAM_X0401));
        this.jQC.setPlaceHolder(2);
        this.jQC.setRadius(l.getDimens(getContext(), R.dimen.tbds21));
        this.jQC.setConrers(15);
        this.jQH = findViewById(R.id.rootLayout);
        this.jQH.setOnClickListener(this.mOnClickListener);
    }

    public void setOnItemCoverListener(f<com.baidu.tieba.homepage.hotTopic.tab.b.f> fVar) {
        this.ajQ = fVar;
    }

    public void a(com.baidu.tieba.homepage.hotTopic.tab.b.f fVar) {
        if (fVar != null) {
            this.jQM = fVar;
            if (TextUtils.isEmpty(fVar.cover)) {
                this.jQC.setVisibility(8);
                this.jQD.setVisibility(8);
                this.jQE.setVisibility(8);
            } else {
                this.jQC.startLoad(fVar.cover, 10, false);
                this.jQC.setVisibility(0);
                if (fVar.time > 0) {
                    this.jQE.setVisibility(0);
                    this.jQD.setVisibility(0);
                    this.jQG.setText(StringUtils.translateSecondsToString(fVar.time));
                } else {
                    this.jQE.setVisibility(8);
                    this.jQD.setVisibility(8);
                }
            }
            this.eAz.setText(fVar.title);
            if (!TextUtils.isEmpty(fVar.forumName)) {
                this.jQK.setVisibility(0);
                this.jQK.setText(UtilHelper.getForumNameWithBar(fVar.forumName, 7, true));
            } else {
                this.jQK.setVisibility(8);
            }
            this.akq.setText(this.akq.getContext().getResources().getString(R.string.hot_topic_thread_item_tag, au.dX(fVar.eMB >= 1000 ? fVar.eMB : 1000)));
            this.akp.setText(String.valueOf(fVar.index));
            cPz();
            if (this.ajQ != null && fVar != null) {
                this.ajQ.b(this, fVar, fVar.index, fVar.index);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void cPz() {
        if (this.jQM != null) {
            int qa = TagTextHelper.qa(this.jQM.index);
            Drawable background = this.akp.getBackground();
            DrawableCompat.setTint(background, ap.getColor(qa));
            this.akp.setBackgroundDrawable(background);
            this.akq.setCompoundDrawablePadding(l.getDimens(getContext(), R.dimen.tbds8));
            int color = ap.getColor(qa);
            Drawable mutate = ap.getDrawable(R.drawable.icon_pure_topic_hot).mutate();
            int dimens = l.getDimens(getContext(), R.dimen.tbds31);
            mutate.setBounds(0, 0, dimens, dimens);
            DrawableCompat.setTint(mutate, color);
            this.akq.setCompoundDrawables(mutate, null, null, null);
            this.akq.setBackgroundDrawable(null);
            ap.setViewTextColor(this.akq, qa);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.jQu != i) {
            com.baidu.tbadk.core.util.e.a.g(this.jQH, R.color.CAM_X0205, R.color.CAM_X0204);
            ap.setViewTextColor(this.eAz, R.color.CAM_X0105);
            ap.setViewTextColor(this.akp, R.color.CAM_X0101);
            ap.setViewTextColor(this.jQG, R.color.CAM_X0101);
            ap.setViewTextColor(this.jQK, R.color.CAM_X0109);
            ap.setBackgroundColor(this.jQL, R.color.CAM_X0203);
            SvgManager.btW().a(this.jQF, R.drawable.ic_icon_pure_video_play12_svg, R.color.CAM_X0101, (SvgManager.SvgResourceStateType) null);
            cPz();
            this.jQu = i;
        }
    }
}
