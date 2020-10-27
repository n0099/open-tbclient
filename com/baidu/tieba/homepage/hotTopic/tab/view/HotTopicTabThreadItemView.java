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
    private TextView epn;
    private int jvY;
    private View jvk;
    private TbImageView jwg;
    private View jwh;
    private View jwi;
    private ImageView jwj;
    private TextView jwk;
    private View jwl;
    private TextView jwo;
    private com.baidu.tieba.homepage.hotTopic.tab.b.f jwp;
    private final View.OnClickListener mOnClickListener;

    public HotTopicTabThreadItemView(Context context) {
        super(context);
        this.jvY = 3;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.hotTopic.tab.view.HotTopicTabThreadItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HotTopicTabThreadItemView.this.jwp != null && HotTopicTabThreadItemView.this.jwp.erH != null) {
                    bw bwVar = HotTopicTabThreadItemView.this.jwp.erH;
                    if (view == HotTopicTabThreadItemView.this.jwl) {
                        if (HotTopicTabThreadItemView.this.aiM != null) {
                            HotTopicTabThreadItemView.this.aiM.a(view, HotTopicTabThreadItemView.this.jwp, HotTopicTabThreadItemView.this.jwp.index, HotTopicTabThreadItemView.this.jwp.index);
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
        this.jvY = 3;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.hotTopic.tab.view.HotTopicTabThreadItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HotTopicTabThreadItemView.this.jwp != null && HotTopicTabThreadItemView.this.jwp.erH != null) {
                    bw bwVar = HotTopicTabThreadItemView.this.jwp.erH;
                    if (view == HotTopicTabThreadItemView.this.jwl) {
                        if (HotTopicTabThreadItemView.this.aiM != null) {
                            HotTopicTabThreadItemView.this.aiM.a(view, HotTopicTabThreadItemView.this.jwp, HotTopicTabThreadItemView.this.jwp.index, HotTopicTabThreadItemView.this.jwp.index);
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
        this.jvY = 3;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.hotTopic.tab.view.HotTopicTabThreadItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HotTopicTabThreadItemView.this.jwp != null && HotTopicTabThreadItemView.this.jwp.erH != null) {
                    bw bwVar = HotTopicTabThreadItemView.this.jwp.erH;
                    if (view == HotTopicTabThreadItemView.this.jwl) {
                        if (HotTopicTabThreadItemView.this.aiM != null) {
                            HotTopicTabThreadItemView.this.aiM.a(view, HotTopicTabThreadItemView.this.jwp, HotTopicTabThreadItemView.this.jwp.index, HotTopicTabThreadItemView.this.jwp.index);
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
        this.jwg = (TbImageView) findViewById(R.id.coverView);
        this.jwh = findViewById(R.id.coverGradientMask);
        this.jwi = findViewById(R.id.videoTimeContainer);
        this.jwj = (ImageView) findViewById(R.id.videoPlayIcon);
        this.jwk = (TextView) findViewById(R.id.videoPlayTime);
        this.ajl = (TextView) findViewById(R.id.indexView);
        this.epn = (TextView) findViewById(R.id.titleView);
        this.ajm = (TextView) findViewById(R.id.tagView);
        this.jwo = (TextView) findViewById(R.id.forumView);
        this.jvk = findViewById(R.id.dividerView);
        this.jwg.setDrawBorder(true);
        this.jwg.setBorderSurroundContent(true);
        this.jwg.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.jwg.setBorderColor(ap.getColor(R.color.cp_border_a));
        this.jwg.setPlaceHolder(2);
        this.jwg.setRadius(l.getDimens(getContext(), R.dimen.tbds21));
        this.jwg.setConrers(15);
        this.jwl = findViewById(R.id.rootLayout);
        this.jwl.setOnClickListener(this.mOnClickListener);
    }

    public void setOnItemCoverListener(f<com.baidu.tieba.homepage.hotTopic.tab.b.f> fVar) {
        this.aiM = fVar;
    }

    public void a(com.baidu.tieba.homepage.hotTopic.tab.b.f fVar) {
        if (fVar != null) {
            this.jwp = fVar;
            if (TextUtils.isEmpty(fVar.cover)) {
                this.jwg.setVisibility(8);
                this.jwh.setVisibility(8);
                this.jwi.setVisibility(8);
            } else {
                this.jwg.startLoad(fVar.cover, 10, false);
                this.jwg.setVisibility(0);
                if (fVar.time > 0) {
                    this.jwi.setVisibility(0);
                    this.jwh.setVisibility(0);
                    this.jwk.setText(StringUtils.translateSecondsToString(fVar.time));
                } else {
                    this.jwi.setVisibility(8);
                    this.jwh.setVisibility(8);
                }
            }
            this.epn.setText(fVar.title);
            if (!TextUtils.isEmpty(fVar.forumName)) {
                this.jwo.setVisibility(0);
                this.jwo.setText(UtilHelper.getForumNameWithBar(fVar.forumName, 7, true));
            } else {
                this.jwo.setVisibility(8);
            }
            this.ajm.setText(this.ajm.getContext().getResources().getString(R.string.hot_topic_thread_item_tag, at.dc(fVar.eBs >= 1000 ? fVar.eBs : 1000)));
            this.ajl.setText(String.valueOf(fVar.index));
            cIe();
            if (this.aiM != null && fVar != null) {
                this.aiM.b(this, fVar, fVar.index, fVar.index);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void cIe() {
        if (this.jwp != null) {
            int oU = TagTextHelper.oU(this.jwp.index);
            Drawable background = this.ajl.getBackground();
            DrawableCompat.setTint(background, ap.getColor(oU));
            this.ajl.setBackgroundDrawable(background);
            this.ajm.setCompoundDrawablePadding(l.getDimens(getContext(), R.dimen.tbds8));
            int color = ap.getColor(oU);
            Drawable mutate = ap.getDrawable(R.drawable.icon_pure_topic_hot).mutate();
            int dimens = l.getDimens(getContext(), R.dimen.tbds31);
            mutate.setBounds(0, 0, dimens, dimens);
            DrawableCompat.setTint(mutate, color);
            this.ajm.setCompoundDrawables(mutate, null, null, null);
            this.ajm.setBackgroundDrawable(null);
            ap.setViewTextColor(this.ajm, oU);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.jvY != i) {
            com.baidu.tbadk.core.util.e.a.g(this.jwl, R.color.cp_bg_line_e, R.color.cp_bg_line_c);
            ap.setViewTextColor(this.epn, R.color.cp_cont_b);
            ap.setViewTextColor(this.ajl, R.color.cp_cont_a);
            ap.setViewTextColor(this.jwk, R.color.cp_cont_a);
            ap.setViewTextColor(this.jwo, R.color.cp_cont_d);
            ap.setBackgroundColor(this.jvk, R.color.cp_bg_line_b);
            SvgManager.boN().a(this.jwj, R.drawable.ic_icon_pure_video_play12_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
            cIe();
            this.jvY = i;
        }
    }
}
