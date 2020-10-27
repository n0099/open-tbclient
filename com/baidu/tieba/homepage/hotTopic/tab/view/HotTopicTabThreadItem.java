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
    private f<e> aiM;
    private TextView ajl;
    private TextView ajm;
    private TextView epn;
    private int jvY;
    private TbImageView jwg;
    private View jwh;
    private View jwi;
    private ImageView jwj;
    private TextView jwk;
    private View jwl;
    private e jwm;

    public HotTopicTabThreadItem(Context context) {
        super(context);
        this.jvY = 3;
        initView();
    }

    public HotTopicTabThreadItem(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jvY = 3;
        initView();
    }

    public HotTopicTabThreadItem(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jvY = 3;
        initView();
    }

    private void initView() {
        LayoutInflater.from(getContext()).inflate(R.layout.hot_topic_tab_thread_item, (ViewGroup) this, true);
        this.jwg = (TbImageView) findViewById(R.id.coverView);
        this.jwh = findViewById(R.id.coverGradientMask);
        this.jwi = findViewById(R.id.videoTimeContainer);
        this.jwj = (ImageView) findViewById(R.id.videoPlayIcon);
        this.jwk = (TextView) findViewById(R.id.videoPlayTime);
        this.ajl = (TextView) findViewById(R.id.indexView);
        this.epn = (TextView) findViewById(R.id.titleView);
        this.ajm = (TextView) findViewById(R.id.tagView);
        this.jwg.setPlaceHolder(2);
        this.jwg.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
        this.jwg.setConrers(15);
        this.jwl = findViewById(R.id.rootLayout);
        this.jwl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.hotTopic.tab.view.HotTopicTabThreadItem.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HotTopicTabThreadItem.this.jwm != null && HotTopicTabThreadItem.this.jwm.erH != null) {
                    if (HotTopicTabThreadItem.this.aiM != null) {
                        HotTopicTabThreadItem.this.aiM.a(view, HotTopicTabThreadItem.this.jwm, HotTopicTabThreadItem.this.jwm.index, HotTopicTabThreadItem.this.jwm.index);
                    }
                    ay.a((AbsThreadDataSupport) HotTopicTabThreadItem.this.jwm.erH, view.getContext(), 2, false, true);
                }
            }
        });
    }

    public void setOnItemCoverListener(f<e> fVar) {
        this.aiM = fVar;
    }

    public void a(e eVar) {
        if (eVar != null) {
            this.jwm = eVar;
            if (TextUtils.isEmpty(eVar.cover)) {
                this.jwg.setVisibility(8);
                this.jwh.setVisibility(8);
                this.jwi.setVisibility(8);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ajm.getLayoutParams();
                layoutParams.addRule(8, 0);
                layoutParams.addRule(3, R.id.titleView);
                this.ajm.setLayoutParams(layoutParams);
            } else {
                this.jwg.startLoad(eVar.cover, 10, false);
                this.jwg.setVisibility(0);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.ajm.getLayoutParams();
                layoutParams2.addRule(8, R.id.coverView);
                layoutParams2.addRule(3, 0);
                this.ajm.setLayoutParams(layoutParams2);
                if (eVar.time > 0) {
                    this.jwi.setVisibility(0);
                    this.jwh.setVisibility(0);
                    this.jwk.setText(StringUtils.translateSecondsToString(eVar.time));
                } else {
                    this.jwi.setVisibility(8);
                    this.jwh.setVisibility(8);
                }
            }
            this.epn.setText(eVar.title);
            this.ajm.setText(this.ajm.getContext().getResources().getString(R.string.hot_topic_thread_item_tag, at.dc(eVar.eBs < 1000 ? 1000 : eVar.eBs)));
            this.ajl.setText(String.valueOf(eVar.index));
            cIe();
            if (this.aiM != null && this.jwm != null) {
                this.aiM.b(this, this.jwm, this.jwm.index, this.jwm.index);
            }
        }
    }

    private void cIe() {
        if (this.jwm != null) {
            int oU = TagTextHelper.oU(this.jwm.index);
            Drawable background = this.ajm.getBackground();
            DrawableCompat.setTint(background, ap.getColor(oU));
            background.setAlpha(40);
            this.ajm.setBackgroundDrawable(background);
            ap.setViewTextColor(this.ajm, oU);
            Drawable background2 = this.ajl.getBackground();
            DrawableCompat.setTint(background2, ap.getColor(oU));
            this.ajl.setBackgroundDrawable(background2);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.jvY != i) {
            com.baidu.tbadk.core.util.e.a.g(this.jwl, R.color.cp_bg_line_e, R.color.cp_bg_line_c);
            ap.setViewTextColor(this.epn, R.color.cp_cont_b);
            ap.setViewTextColor(this.ajl, R.color.cp_cont_a);
            ap.setViewTextColor(this.jwk, R.color.cp_cont_a);
            this.jwj.setImageDrawable(SvgManager.boN().a(R.drawable.ic_icon_pure_video_play12_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null));
            cIe();
            this.jvY = i;
        }
    }
}
