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
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TagTextHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.h.f;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.hotTopic.tab.b.e;
/* loaded from: classes21.dex */
public class HotTopicTabThreadItem extends RelativeLayout {
    private TextView aiS;
    private TextView aiT;
    private f<e> ait;
    private TextView dUN;
    private int iUD;
    private TbImageView iUL;
    private View iUM;
    private View iUN;
    private ImageView iUO;
    private TextView iUP;
    private View iUQ;
    private e iUR;

    public HotTopicTabThreadItem(Context context) {
        super(context);
        this.iUD = 3;
        initView();
    }

    public HotTopicTabThreadItem(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iUD = 3;
        initView();
    }

    public HotTopicTabThreadItem(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iUD = 3;
        initView();
    }

    private void initView() {
        LayoutInflater.from(getContext()).inflate(R.layout.hot_topic_tab_thread_item, (ViewGroup) this, true);
        this.iUL = (TbImageView) findViewById(R.id.coverView);
        this.iUM = findViewById(R.id.coverGradientMask);
        this.iUN = findViewById(R.id.videoTimeContainer);
        this.iUO = (ImageView) findViewById(R.id.videoPlayIcon);
        this.iUP = (TextView) findViewById(R.id.videoPlayTime);
        this.aiS = (TextView) findViewById(R.id.indexView);
        this.dUN = (TextView) findViewById(R.id.titleView);
        this.aiT = (TextView) findViewById(R.id.tagView);
        this.iUL.setPlaceHolder(2);
        this.iUL.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
        this.iUL.setConrers(15);
        this.iUQ = findViewById(R.id.rootLayout);
        this.iUQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.hotTopic.tab.view.HotTopicTabThreadItem.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HotTopicTabThreadItem.this.iUR != null && HotTopicTabThreadItem.this.iUR.dXg != null) {
                    if (HotTopicTabThreadItem.this.ait != null) {
                        HotTopicTabThreadItem.this.ait.a(view, HotTopicTabThreadItem.this.iUR, HotTopicTabThreadItem.this.iUR.index, HotTopicTabThreadItem.this.iUR.index);
                    }
                    ay.a((AbsThreadDataSupport) HotTopicTabThreadItem.this.iUR.dXg, view.getContext(), 2, false, true);
                }
            }
        });
    }

    public void setOnItemCoverListener(f<e> fVar) {
        this.ait = fVar;
    }

    public void a(e eVar) {
        if (eVar != null) {
            this.iUR = eVar;
            if (TextUtils.isEmpty(eVar.cover)) {
                this.iUL.setVisibility(8);
                this.iUM.setVisibility(8);
                this.iUN.setVisibility(8);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aiT.getLayoutParams();
                layoutParams.addRule(8, 0);
                layoutParams.addRule(3, R.id.titleView);
                this.aiT.setLayoutParams(layoutParams);
            } else {
                this.iUL.startLoad(eVar.cover, 10, false);
                this.iUL.setVisibility(0);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.aiT.getLayoutParams();
                layoutParams2.addRule(8, R.id.coverView);
                layoutParams2.addRule(3, 0);
                this.aiT.setLayoutParams(layoutParams2);
                if (eVar.time > 0) {
                    this.iUN.setVisibility(0);
                    this.iUM.setVisibility(0);
                    this.iUP.setText(StringUtils.translateSecondsToString(eVar.time));
                } else {
                    this.iUN.setVisibility(8);
                    this.iUM.setVisibility(8);
                }
            }
            this.dUN.setText(eVar.title);
            this.aiT.setText(this.aiT.getContext().getResources().getString(R.string.hot_topic_thread_item_tag, at.cS(eVar.egM < 1000 ? 1000 : eVar.egM)));
            this.aiS.setText(String.valueOf(eVar.index));
            cBq();
            if (this.ait != null && this.iUR != null) {
                this.ait.b(this, this.iUR, this.iUR.index, this.iUR.index);
            }
        }
    }

    private void cBq() {
        if (this.iUR != null) {
            int om = TagTextHelper.om(this.iUR.index);
            Drawable background = this.aiT.getBackground();
            DrawableCompat.setTint(background, ap.getColor(om));
            background.setAlpha(40);
            this.aiT.setBackgroundDrawable(background);
            ap.setViewTextColor(this.aiT, om);
            Drawable background2 = this.aiS.getBackground();
            DrawableCompat.setTint(background2, ap.getColor(om));
            this.aiS.setBackgroundDrawable(background2);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.iUD != i) {
            com.baidu.tbadk.core.util.e.a.g(this.iUQ, R.color.cp_bg_line_e, R.color.cp_bg_line_c);
            ap.setViewTextColor(this.dUN, R.color.cp_cont_b);
            ap.setViewTextColor(this.aiS, R.color.cp_cont_a);
            ap.setViewTextColor(this.iUP, R.color.cp_cont_a);
            this.iUO.setImageDrawable(SvgManager.bkl().a(R.drawable.ic_icon_pure_video_play12_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null));
            cBq();
            this.iUD = i;
        }
    }
}
