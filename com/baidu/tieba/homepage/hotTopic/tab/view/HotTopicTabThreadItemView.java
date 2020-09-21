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
/* loaded from: classes21.dex */
public class HotTopicTabThreadItemView extends RelativeLayout {
    private TextView aiS;
    private TextView aiT;
    private f<com.baidu.tieba.homepage.hotTopic.tab.b.f> ait;
    private TextView dUN;
    private View iTP;
    private int iUD;
    private TbImageView iUL;
    private View iUM;
    private View iUN;
    private ImageView iUO;
    private TextView iUP;
    private View iUQ;
    private TextView iUT;
    private com.baidu.tieba.homepage.hotTopic.tab.b.f iUU;
    private final View.OnClickListener mOnClickListener;

    public HotTopicTabThreadItemView(Context context) {
        super(context);
        this.iUD = 3;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.hotTopic.tab.view.HotTopicTabThreadItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HotTopicTabThreadItemView.this.iUU != null && HotTopicTabThreadItemView.this.iUU.dXg != null) {
                    bw bwVar = HotTopicTabThreadItemView.this.iUU.dXg;
                    if (view == HotTopicTabThreadItemView.this.iUQ) {
                        if (HotTopicTabThreadItemView.this.ait != null) {
                            HotTopicTabThreadItemView.this.ait.a(view, HotTopicTabThreadItemView.this.iUU, HotTopicTabThreadItemView.this.iUU.index, HotTopicTabThreadItemView.this.iUU.index);
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
        this.iUD = 3;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.hotTopic.tab.view.HotTopicTabThreadItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HotTopicTabThreadItemView.this.iUU != null && HotTopicTabThreadItemView.this.iUU.dXg != null) {
                    bw bwVar = HotTopicTabThreadItemView.this.iUU.dXg;
                    if (view == HotTopicTabThreadItemView.this.iUQ) {
                        if (HotTopicTabThreadItemView.this.ait != null) {
                            HotTopicTabThreadItemView.this.ait.a(view, HotTopicTabThreadItemView.this.iUU, HotTopicTabThreadItemView.this.iUU.index, HotTopicTabThreadItemView.this.iUU.index);
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
        this.iUD = 3;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.hotTopic.tab.view.HotTopicTabThreadItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HotTopicTabThreadItemView.this.iUU != null && HotTopicTabThreadItemView.this.iUU.dXg != null) {
                    bw bwVar = HotTopicTabThreadItemView.this.iUU.dXg;
                    if (view == HotTopicTabThreadItemView.this.iUQ) {
                        if (HotTopicTabThreadItemView.this.ait != null) {
                            HotTopicTabThreadItemView.this.ait.a(view, HotTopicTabThreadItemView.this.iUU, HotTopicTabThreadItemView.this.iUU.index, HotTopicTabThreadItemView.this.iUU.index);
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
        this.iUL = (TbImageView) findViewById(R.id.coverView);
        this.iUM = findViewById(R.id.coverGradientMask);
        this.iUN = findViewById(R.id.videoTimeContainer);
        this.iUO = (ImageView) findViewById(R.id.videoPlayIcon);
        this.iUP = (TextView) findViewById(R.id.videoPlayTime);
        this.aiS = (TextView) findViewById(R.id.indexView);
        this.dUN = (TextView) findViewById(R.id.titleView);
        this.aiT = (TextView) findViewById(R.id.tagView);
        this.iUT = (TextView) findViewById(R.id.forumView);
        this.iTP = findViewById(R.id.dividerView);
        this.iUL.setDrawBorder(true);
        this.iUL.setBorderSurroundContent(true);
        this.iUL.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.iUL.setBorderColor(ap.getColor(R.color.cp_border_a));
        this.iUL.setPlaceHolder(2);
        this.iUL.setRadius(l.getDimens(getContext(), R.dimen.tbds21));
        this.iUL.setConrers(15);
        this.iUQ = findViewById(R.id.rootLayout);
        this.iUQ.setOnClickListener(this.mOnClickListener);
    }

    public void setOnItemCoverListener(f<com.baidu.tieba.homepage.hotTopic.tab.b.f> fVar) {
        this.ait = fVar;
    }

    public void a(com.baidu.tieba.homepage.hotTopic.tab.b.f fVar) {
        if (fVar != null) {
            this.iUU = fVar;
            if (TextUtils.isEmpty(fVar.cover)) {
                this.iUL.setVisibility(8);
                this.iUM.setVisibility(8);
                this.iUN.setVisibility(8);
            } else {
                this.iUL.startLoad(fVar.cover, 10, false);
                this.iUL.setVisibility(0);
                if (fVar.time > 0) {
                    this.iUN.setVisibility(0);
                    this.iUM.setVisibility(0);
                    this.iUP.setText(StringUtils.translateSecondsToString(fVar.time));
                } else {
                    this.iUN.setVisibility(8);
                    this.iUM.setVisibility(8);
                }
            }
            this.dUN.setText(fVar.title);
            if (!TextUtils.isEmpty(fVar.forumName)) {
                this.iUT.setVisibility(0);
                this.iUT.setText(UtilHelper.getForumNameWithBar(fVar.forumName, 7, true));
            } else {
                this.iUT.setVisibility(8);
            }
            this.aiT.setText(this.aiT.getContext().getResources().getString(R.string.hot_topic_thread_item_tag, at.cS(fVar.egM >= 1000 ? fVar.egM : 1000)));
            this.aiS.setText(String.valueOf(fVar.index));
            cBq();
            if (this.ait != null && fVar != null) {
                this.ait.b(this, fVar, fVar.index, fVar.index);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void cBq() {
        if (this.iUU != null) {
            int om = TagTextHelper.om(this.iUU.index);
            Drawable background = this.aiS.getBackground();
            DrawableCompat.setTint(background, ap.getColor(om));
            this.aiS.setBackgroundDrawable(background);
            this.aiT.setCompoundDrawablePadding(l.getDimens(getContext(), R.dimen.tbds8));
            int color = ap.getColor(om);
            Drawable mutate = ap.getDrawable(R.drawable.icon_pure_topic_hot).mutate();
            int dimens = l.getDimens(getContext(), R.dimen.tbds31);
            mutate.setBounds(0, 0, dimens, dimens);
            DrawableCompat.setTint(mutate, color);
            this.aiT.setCompoundDrawables(mutate, null, null, null);
            this.aiT.setBackgroundDrawable(null);
            ap.setViewTextColor(this.aiT, om);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.iUD != i) {
            com.baidu.tbadk.core.util.e.a.g(this.iUQ, R.color.cp_bg_line_e, R.color.cp_bg_line_c);
            ap.setViewTextColor(this.dUN, R.color.cp_cont_b);
            ap.setViewTextColor(this.aiS, R.color.cp_cont_a);
            ap.setViewTextColor(this.iUP, R.color.cp_cont_a);
            ap.setViewTextColor(this.iUT, R.color.cp_cont_d);
            ap.setBackgroundColor(this.iTP, R.color.cp_bg_line_b);
            SvgManager.bkl().a(this.iUO, R.drawable.ic_icon_pure_video_play12_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
            cBq();
            this.iUD = i;
        }
    }
}
