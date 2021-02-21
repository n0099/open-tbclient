package com.baidu.tieba.homepage.hotTopic.tab.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.graphics.drawable.DrawableCompat;
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
/* loaded from: classes2.dex */
public class HotTopicTabThreadItem extends RelativeLayout {
    private TextView ajP;
    private TextView ajQ;
    private f<e> ajq;
    private TextView eHx;
    private int kgW;
    private TbImageView khe;
    private View khf;
    private View khg;
    private ImageView khh;
    private TextView khi;
    private View khj;
    private e khk;

    public HotTopicTabThreadItem(Context context) {
        super(context);
        this.kgW = 3;
        initView();
    }

    public HotTopicTabThreadItem(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.kgW = 3;
        initView();
    }

    public HotTopicTabThreadItem(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kgW = 3;
        initView();
    }

    private void initView() {
        LayoutInflater.from(getContext()).inflate(R.layout.hot_topic_tab_thread_item, (ViewGroup) this, true);
        this.khe = (TbImageView) findViewById(R.id.coverView);
        this.khf = findViewById(R.id.coverGradientMask);
        this.khg = findViewById(R.id.videoTimeContainer);
        this.khh = (ImageView) findViewById(R.id.videoPlayIcon);
        this.khi = (TextView) findViewById(R.id.videoPlayTime);
        this.ajP = (TextView) findViewById(R.id.indexView);
        this.eHx = (TextView) findViewById(R.id.titleView);
        this.ajQ = (TextView) findViewById(R.id.tagView);
        this.khe.setPlaceHolder(2);
        this.khe.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
        this.khe.setConrers(15);
        this.khj = findViewById(R.id.rootLayout);
        this.khj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.hotTopic.tab.view.HotTopicTabThreadItem.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HotTopicTabThreadItem.this.khk != null && HotTopicTabThreadItem.this.khk.eJQ != null) {
                    if (HotTopicTabThreadItem.this.ajq != null) {
                        HotTopicTabThreadItem.this.ajq.a(view, HotTopicTabThreadItem.this.khk, HotTopicTabThreadItem.this.khk.index, HotTopicTabThreadItem.this.khk.index);
                    }
                    az.a((com.baidu.tbadk.core.data.a) HotTopicTabThreadItem.this.khk.eJQ, view.getContext(), 2, false, true);
                }
            }
        });
    }

    public void setOnItemCoverListener(f<e> fVar) {
        this.ajq = fVar;
    }

    public void a(e eVar) {
        if (eVar != null) {
            this.khk = eVar;
            if (TextUtils.isEmpty(eVar.cover)) {
                this.khe.setVisibility(8);
                this.khf.setVisibility(8);
                this.khg.setVisibility(8);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ajQ.getLayoutParams();
                layoutParams.addRule(8, 0);
                layoutParams.addRule(3, R.id.titleView);
                this.ajQ.setLayoutParams(layoutParams);
            } else {
                this.khe.startLoad(eVar.cover, 10, false);
                this.khe.setVisibility(0);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.ajQ.getLayoutParams();
                layoutParams2.addRule(8, R.id.coverView);
                layoutParams2.addRule(3, 0);
                this.ajQ.setLayoutParams(layoutParams2);
                if (eVar.time > 0) {
                    this.khg.setVisibility(0);
                    this.khf.setVisibility(0);
                    this.khi.setText(StringUtils.translateSecondsToString(eVar.time));
                } else {
                    this.khg.setVisibility(8);
                    this.khf.setVisibility(8);
                }
            }
            this.eHx.setText(eVar.title);
            this.ajQ.setText(this.ajQ.getContext().getResources().getString(R.string.hot_topic_thread_item_tag, au.ed(eVar.eTZ < 1000 ? 1000 : eVar.eTZ)));
            this.ajP.setText(String.valueOf(eVar.index));
            cQT();
            if (this.ajq != null && this.khk != null) {
                this.ajq.b(this, this.khk, this.khk.index, this.khk.index);
            }
        }
    }

    private void cQT() {
        if (this.khk != null) {
            int oJ = TagTextHelper.oJ(this.khk.index);
            Drawable background = this.ajQ.getBackground();
            DrawableCompat.setTint(background, ap.getColor(oJ));
            background.setAlpha(40);
            this.ajQ.setBackgroundDrawable(background);
            ap.setViewTextColor(this.ajQ, oJ);
            Drawable background2 = this.ajP.getBackground();
            DrawableCompat.setTint(background2, ap.getColor(oJ));
            this.ajP.setBackgroundDrawable(background2);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.kgW != i) {
            com.baidu.tbadk.core.util.f.a.m(this.khj, R.color.CAM_X0205, R.color.CAM_X0204);
            ap.setViewTextColor(this.eHx, R.color.CAM_X0105);
            ap.setViewTextColor(this.ajP, R.color.CAM_X0101);
            ap.setViewTextColor(this.khi, R.color.CAM_X0101);
            this.khh.setImageDrawable(SvgManager.bsR().a(R.drawable.ic_icon_pure_video_play12_svg, R.color.CAM_X0101, (SvgManager.SvgResourceStateType) null));
            cQT();
            this.kgW = i;
        }
    }
}
