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
/* loaded from: classes22.dex */
public class HotTopicTabThreadItem extends RelativeLayout {
    private f<e> aiL;
    private TextView ajk;
    private TextView ajl;
    private TextView egP;
    private int jjB;
    private TbImageView jjJ;
    private View jjK;
    private View jjL;
    private ImageView jjM;
    private TextView jjN;
    private View jjO;
    private e jjP;

    public HotTopicTabThreadItem(Context context) {
        super(context);
        this.jjB = 3;
        initView();
    }

    public HotTopicTabThreadItem(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jjB = 3;
        initView();
    }

    public HotTopicTabThreadItem(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jjB = 3;
        initView();
    }

    private void initView() {
        LayoutInflater.from(getContext()).inflate(R.layout.hot_topic_tab_thread_item, (ViewGroup) this, true);
        this.jjJ = (TbImageView) findViewById(R.id.coverView);
        this.jjK = findViewById(R.id.coverGradientMask);
        this.jjL = findViewById(R.id.videoTimeContainer);
        this.jjM = (ImageView) findViewById(R.id.videoPlayIcon);
        this.jjN = (TextView) findViewById(R.id.videoPlayTime);
        this.ajk = (TextView) findViewById(R.id.indexView);
        this.egP = (TextView) findViewById(R.id.titleView);
        this.ajl = (TextView) findViewById(R.id.tagView);
        this.jjJ.setPlaceHolder(2);
        this.jjJ.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
        this.jjJ.setConrers(15);
        this.jjO = findViewById(R.id.rootLayout);
        this.jjO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.hotTopic.tab.view.HotTopicTabThreadItem.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HotTopicTabThreadItem.this.jjP != null && HotTopicTabThreadItem.this.jjP.eji != null) {
                    if (HotTopicTabThreadItem.this.aiL != null) {
                        HotTopicTabThreadItem.this.aiL.a(view, HotTopicTabThreadItem.this.jjP, HotTopicTabThreadItem.this.jjP.index, HotTopicTabThreadItem.this.jjP.index);
                    }
                    ay.a((AbsThreadDataSupport) HotTopicTabThreadItem.this.jjP.eji, view.getContext(), 2, false, true);
                }
            }
        });
    }

    public void setOnItemCoverListener(f<e> fVar) {
        this.aiL = fVar;
    }

    public void a(e eVar) {
        if (eVar != null) {
            this.jjP = eVar;
            if (TextUtils.isEmpty(eVar.cover)) {
                this.jjJ.setVisibility(8);
                this.jjK.setVisibility(8);
                this.jjL.setVisibility(8);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ajl.getLayoutParams();
                layoutParams.addRule(8, 0);
                layoutParams.addRule(3, R.id.titleView);
                this.ajl.setLayoutParams(layoutParams);
            } else {
                this.jjJ.startLoad(eVar.cover, 10, false);
                this.jjJ.setVisibility(0);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.ajl.getLayoutParams();
                layoutParams2.addRule(8, R.id.coverView);
                layoutParams2.addRule(3, 0);
                this.ajl.setLayoutParams(layoutParams2);
                if (eVar.time > 0) {
                    this.jjL.setVisibility(0);
                    this.jjK.setVisibility(0);
                    this.jjN.setText(StringUtils.translateSecondsToString(eVar.time));
                } else {
                    this.jjL.setVisibility(8);
                    this.jjK.setVisibility(8);
                }
            }
            this.egP.setText(eVar.title);
            this.ajl.setText(this.ajl.getContext().getResources().getString(R.string.hot_topic_thread_item_tag, at.da(eVar.esS < 1000 ? 1000 : eVar.esS)));
            this.ajk.setText(String.valueOf(eVar.index));
            cEX();
            if (this.aiL != null && this.jjP != null) {
                this.aiL.b(this, this.jjP, this.jjP.index, this.jjP.index);
            }
        }
    }

    private void cEX() {
        if (this.jjP != null) {
            int oJ = TagTextHelper.oJ(this.jjP.index);
            Drawable background = this.ajl.getBackground();
            DrawableCompat.setTint(background, ap.getColor(oJ));
            background.setAlpha(40);
            this.ajl.setBackgroundDrawable(background);
            ap.setViewTextColor(this.ajl, oJ);
            Drawable background2 = this.ajk.getBackground();
            DrawableCompat.setTint(background2, ap.getColor(oJ));
            this.ajk.setBackgroundDrawable(background2);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.jjB != i) {
            com.baidu.tbadk.core.util.e.a.g(this.jjO, R.color.cp_bg_line_e, R.color.cp_bg_line_c);
            ap.setViewTextColor(this.egP, R.color.cp_cont_b);
            ap.setViewTextColor(this.ajk, R.color.cp_cont_a);
            ap.setViewTextColor(this.jjN, R.color.cp_cont_a);
            this.jjM.setImageDrawable(SvgManager.bmU().a(R.drawable.ic_icon_pure_video_play12_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null));
            cEX();
            this.jjB = i;
        }
    }
}
