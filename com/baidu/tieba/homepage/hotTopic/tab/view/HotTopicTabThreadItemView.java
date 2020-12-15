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
    private TbImageView jQE;
    private View jQF;
    private View jQG;
    private ImageView jQH;
    private TextView jQI;
    private View jQJ;
    private TextView jQM;
    private View jQN;
    private com.baidu.tieba.homepage.hotTopic.tab.b.f jQO;
    private int jQw;
    private final View.OnClickListener mOnClickListener;

    public HotTopicTabThreadItemView(Context context) {
        super(context);
        this.jQw = 3;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.hotTopic.tab.view.HotTopicTabThreadItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HotTopicTabThreadItemView.this.jQO != null && HotTopicTabThreadItemView.this.jQO.eCR != null) {
                    by byVar = HotTopicTabThreadItemView.this.jQO.eCR;
                    if (view == HotTopicTabThreadItemView.this.jQJ) {
                        if (HotTopicTabThreadItemView.this.ajQ != null) {
                            HotTopicTabThreadItemView.this.ajQ.a(view, HotTopicTabThreadItemView.this.jQO, HotTopicTabThreadItemView.this.jQO.index, HotTopicTabThreadItemView.this.jQO.index);
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
        this.jQw = 3;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.hotTopic.tab.view.HotTopicTabThreadItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HotTopicTabThreadItemView.this.jQO != null && HotTopicTabThreadItemView.this.jQO.eCR != null) {
                    by byVar = HotTopicTabThreadItemView.this.jQO.eCR;
                    if (view == HotTopicTabThreadItemView.this.jQJ) {
                        if (HotTopicTabThreadItemView.this.ajQ != null) {
                            HotTopicTabThreadItemView.this.ajQ.a(view, HotTopicTabThreadItemView.this.jQO, HotTopicTabThreadItemView.this.jQO.index, HotTopicTabThreadItemView.this.jQO.index);
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
        this.jQw = 3;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.hotTopic.tab.view.HotTopicTabThreadItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HotTopicTabThreadItemView.this.jQO != null && HotTopicTabThreadItemView.this.jQO.eCR != null) {
                    by byVar = HotTopicTabThreadItemView.this.jQO.eCR;
                    if (view == HotTopicTabThreadItemView.this.jQJ) {
                        if (HotTopicTabThreadItemView.this.ajQ != null) {
                            HotTopicTabThreadItemView.this.ajQ.a(view, HotTopicTabThreadItemView.this.jQO, HotTopicTabThreadItemView.this.jQO.index, HotTopicTabThreadItemView.this.jQO.index);
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
        this.jQE = (TbImageView) findViewById(R.id.coverView);
        this.jQF = findViewById(R.id.coverGradientMask);
        this.jQG = findViewById(R.id.videoTimeContainer);
        this.jQH = (ImageView) findViewById(R.id.videoPlayIcon);
        this.jQI = (TextView) findViewById(R.id.videoPlayTime);
        this.akp = (TextView) findViewById(R.id.indexView);
        this.eAz = (TextView) findViewById(R.id.titleView);
        this.akq = (TextView) findViewById(R.id.tagView);
        this.jQM = (TextView) findViewById(R.id.forumView);
        this.jQN = findViewById(R.id.dividerView);
        this.jQE.setDrawBorder(true);
        this.jQE.setBorderSurroundContent(true);
        this.jQE.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.jQE.setBorderColor(ap.getColor(R.color.CAM_X0401));
        this.jQE.setPlaceHolder(2);
        this.jQE.setRadius(l.getDimens(getContext(), R.dimen.tbds21));
        this.jQE.setConrers(15);
        this.jQJ = findViewById(R.id.rootLayout);
        this.jQJ.setOnClickListener(this.mOnClickListener);
    }

    public void setOnItemCoverListener(f<com.baidu.tieba.homepage.hotTopic.tab.b.f> fVar) {
        this.ajQ = fVar;
    }

    public void a(com.baidu.tieba.homepage.hotTopic.tab.b.f fVar) {
        if (fVar != null) {
            this.jQO = fVar;
            if (TextUtils.isEmpty(fVar.cover)) {
                this.jQE.setVisibility(8);
                this.jQF.setVisibility(8);
                this.jQG.setVisibility(8);
            } else {
                this.jQE.startLoad(fVar.cover, 10, false);
                this.jQE.setVisibility(0);
                if (fVar.time > 0) {
                    this.jQG.setVisibility(0);
                    this.jQF.setVisibility(0);
                    this.jQI.setText(StringUtils.translateSecondsToString(fVar.time));
                } else {
                    this.jQG.setVisibility(8);
                    this.jQF.setVisibility(8);
                }
            }
            this.eAz.setText(fVar.title);
            if (!TextUtils.isEmpty(fVar.forumName)) {
                this.jQM.setVisibility(0);
                this.jQM.setText(UtilHelper.getForumNameWithBar(fVar.forumName, 7, true));
            } else {
                this.jQM.setVisibility(8);
            }
            this.akq.setText(this.akq.getContext().getResources().getString(R.string.hot_topic_thread_item_tag, au.dX(fVar.eMB >= 1000 ? fVar.eMB : 1000)));
            this.akp.setText(String.valueOf(fVar.index));
            cPA();
            if (this.ajQ != null && fVar != null) {
                this.ajQ.b(this, fVar, fVar.index, fVar.index);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void cPA() {
        if (this.jQO != null) {
            int qa = TagTextHelper.qa(this.jQO.index);
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
        if (this.jQw != i) {
            com.baidu.tbadk.core.util.e.a.g(this.jQJ, R.color.CAM_X0205, R.color.CAM_X0204);
            ap.setViewTextColor(this.eAz, R.color.CAM_X0105);
            ap.setViewTextColor(this.akp, R.color.CAM_X0101);
            ap.setViewTextColor(this.jQI, R.color.CAM_X0101);
            ap.setViewTextColor(this.jQM, R.color.CAM_X0109);
            ap.setBackgroundColor(this.jQN, R.color.CAM_X0203);
            SvgManager.btW().a(this.jQH, R.drawable.ic_icon_pure_video_play12_svg, R.color.CAM_X0101, (SvgManager.SvgResourceStateType) null);
            cPA();
            this.jQw = i;
        }
    }
}
