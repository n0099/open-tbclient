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
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TagTextHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.h.f;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.hotTopic.tab.b.e;
/* loaded from: classes22.dex */
public class HotTopicTabThreadItem extends RelativeLayout {
    private f<e> ajQ;
    private TextView akp;
    private TextView akq;
    private TextView eAz;
    private TbImageView jQE;
    private View jQF;
    private View jQG;
    private ImageView jQH;
    private TextView jQI;
    private View jQJ;
    private e jQK;
    private int jQw;

    public HotTopicTabThreadItem(Context context) {
        super(context);
        this.jQw = 3;
        initView();
    }

    public HotTopicTabThreadItem(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jQw = 3;
        initView();
    }

    public HotTopicTabThreadItem(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jQw = 3;
        initView();
    }

    private void initView() {
        LayoutInflater.from(getContext()).inflate(R.layout.hot_topic_tab_thread_item, (ViewGroup) this, true);
        this.jQE = (TbImageView) findViewById(R.id.coverView);
        this.jQF = findViewById(R.id.coverGradientMask);
        this.jQG = findViewById(R.id.videoTimeContainer);
        this.jQH = (ImageView) findViewById(R.id.videoPlayIcon);
        this.jQI = (TextView) findViewById(R.id.videoPlayTime);
        this.akp = (TextView) findViewById(R.id.indexView);
        this.eAz = (TextView) findViewById(R.id.titleView);
        this.akq = (TextView) findViewById(R.id.tagView);
        this.jQE.setPlaceHolder(2);
        this.jQE.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
        this.jQE.setConrers(15);
        this.jQJ = findViewById(R.id.rootLayout);
        this.jQJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.hotTopic.tab.view.HotTopicTabThreadItem.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HotTopicTabThreadItem.this.jQK != null && HotTopicTabThreadItem.this.jQK.eCR != null) {
                    if (HotTopicTabThreadItem.this.ajQ != null) {
                        HotTopicTabThreadItem.this.ajQ.a(view, HotTopicTabThreadItem.this.jQK, HotTopicTabThreadItem.this.jQK.index, HotTopicTabThreadItem.this.jQK.index);
                    }
                    az.a((com.baidu.tbadk.core.data.a) HotTopicTabThreadItem.this.jQK.eCR, view.getContext(), 2, false, true);
                }
            }
        });
    }

    public void setOnItemCoverListener(f<e> fVar) {
        this.ajQ = fVar;
    }

    public void a(e eVar) {
        if (eVar != null) {
            this.jQK = eVar;
            if (TextUtils.isEmpty(eVar.cover)) {
                this.jQE.setVisibility(8);
                this.jQF.setVisibility(8);
                this.jQG.setVisibility(8);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.akq.getLayoutParams();
                layoutParams.addRule(8, 0);
                layoutParams.addRule(3, R.id.titleView);
                this.akq.setLayoutParams(layoutParams);
            } else {
                this.jQE.startLoad(eVar.cover, 10, false);
                this.jQE.setVisibility(0);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.akq.getLayoutParams();
                layoutParams2.addRule(8, R.id.coverView);
                layoutParams2.addRule(3, 0);
                this.akq.setLayoutParams(layoutParams2);
                if (eVar.time > 0) {
                    this.jQG.setVisibility(0);
                    this.jQF.setVisibility(0);
                    this.jQI.setText(StringUtils.translateSecondsToString(eVar.time));
                } else {
                    this.jQG.setVisibility(8);
                    this.jQF.setVisibility(8);
                }
            }
            this.eAz.setText(eVar.title);
            this.akq.setText(this.akq.getContext().getResources().getString(R.string.hot_topic_thread_item_tag, au.dX(eVar.eMB < 1000 ? 1000 : eVar.eMB)));
            this.akp.setText(String.valueOf(eVar.index));
            cPA();
            if (this.ajQ != null && this.jQK != null) {
                this.ajQ.b(this, this.jQK, this.jQK.index, this.jQK.index);
            }
        }
    }

    private void cPA() {
        if (this.jQK != null) {
            int qa = TagTextHelper.qa(this.jQK.index);
            Drawable background = this.akq.getBackground();
            DrawableCompat.setTint(background, ap.getColor(qa));
            background.setAlpha(40);
            this.akq.setBackgroundDrawable(background);
            ap.setViewTextColor(this.akq, qa);
            Drawable background2 = this.akp.getBackground();
            DrawableCompat.setTint(background2, ap.getColor(qa));
            this.akp.setBackgroundDrawable(background2);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.jQw != i) {
            com.baidu.tbadk.core.util.e.a.g(this.jQJ, R.color.CAM_X0205, R.color.CAM_X0204);
            ap.setViewTextColor(this.eAz, R.color.CAM_X0105);
            ap.setViewTextColor(this.akp, R.color.CAM_X0101);
            ap.setViewTextColor(this.jQI, R.color.CAM_X0101);
            this.jQH.setImageDrawable(SvgManager.btW().a(R.drawable.ic_icon_pure_video_play12_svg, R.color.CAM_X0101, (SvgManager.SvgResourceStateType) null));
            cPA();
            this.jQw = i;
        }
    }
}
