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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.h.f;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.hotTopic.tab.b.e;
/* loaded from: classes2.dex */
public class HotTopicTabThreadItem extends RelativeLayout {
    private f<e> ajB;
    private TextView aka;
    private TextView akb;
    private TextView eFr;
    private int jZf;
    private TbImageView jZn;
    private View jZo;
    private View jZp;
    private ImageView jZq;
    private TextView jZr;
    private View jZs;
    private e jZt;

    public HotTopicTabThreadItem(Context context) {
        super(context);
        this.jZf = 3;
        initView();
    }

    public HotTopicTabThreadItem(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jZf = 3;
        initView();
    }

    public HotTopicTabThreadItem(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jZf = 3;
        initView();
    }

    private void initView() {
        LayoutInflater.from(getContext()).inflate(R.layout.hot_topic_tab_thread_item, (ViewGroup) this, true);
        this.jZn = (TbImageView) findViewById(R.id.coverView);
        this.jZo = findViewById(R.id.coverGradientMask);
        this.jZp = findViewById(R.id.videoTimeContainer);
        this.jZq = (ImageView) findViewById(R.id.videoPlayIcon);
        this.jZr = (TextView) findViewById(R.id.videoPlayTime);
        this.aka = (TextView) findViewById(R.id.indexView);
        this.eFr = (TextView) findViewById(R.id.titleView);
        this.akb = (TextView) findViewById(R.id.tagView);
        this.jZn.setPlaceHolder(2);
        this.jZn.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
        this.jZn.setConrers(15);
        this.jZs = findViewById(R.id.rootLayout);
        this.jZs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.hotTopic.tab.view.HotTopicTabThreadItem.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HotTopicTabThreadItem.this.jZt != null && HotTopicTabThreadItem.this.jZt.eHK != null) {
                    if (HotTopicTabThreadItem.this.ajB != null) {
                        HotTopicTabThreadItem.this.ajB.a(view, HotTopicTabThreadItem.this.jZt, HotTopicTabThreadItem.this.jZt.index, HotTopicTabThreadItem.this.jZt.index);
                    }
                    ay.a((com.baidu.tbadk.core.data.a) HotTopicTabThreadItem.this.jZt.eHK, view.getContext(), 2, false, true);
                }
            }
        });
    }

    public void setOnItemCoverListener(f<e> fVar) {
        this.ajB = fVar;
    }

    public void a(e eVar) {
        if (eVar != null) {
            this.jZt = eVar;
            if (TextUtils.isEmpty(eVar.cover)) {
                this.jZn.setVisibility(8);
                this.jZo.setVisibility(8);
                this.jZp.setVisibility(8);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.akb.getLayoutParams();
                layoutParams.addRule(8, 0);
                layoutParams.addRule(3, R.id.titleView);
                this.akb.setLayoutParams(layoutParams);
            } else {
                this.jZn.startLoad(eVar.cover, 10, false);
                this.jZn.setVisibility(0);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.akb.getLayoutParams();
                layoutParams2.addRule(8, R.id.coverView);
                layoutParams2.addRule(3, 0);
                this.akb.setLayoutParams(layoutParams2);
                if (eVar.time > 0) {
                    this.jZp.setVisibility(0);
                    this.jZo.setVisibility(0);
                    this.jZr.setText(StringUtils.translateSecondsToString(eVar.time));
                } else {
                    this.jZp.setVisibility(8);
                    this.jZo.setVisibility(8);
                }
            }
            this.eFr.setText(eVar.title);
            this.akb.setText(this.akb.getContext().getResources().getString(R.string.hot_topic_thread_item_tag, at.dX(eVar.eRL < 1000 ? 1000 : eVar.eRL)));
            this.aka.setText(String.valueOf(eVar.index));
            cOP();
            if (this.ajB != null && this.jZt != null) {
                this.ajB.b(this, this.jZt, this.jZt.index, this.jZt.index);
            }
        }
    }

    private void cOP() {
        if (this.jZt != null) {
            int oE = TagTextHelper.oE(this.jZt.index);
            Drawable background = this.akb.getBackground();
            DrawableCompat.setTint(background, ao.getColor(oE));
            background.setAlpha(40);
            this.akb.setBackgroundDrawable(background);
            ao.setViewTextColor(this.akb, oE);
            Drawable background2 = this.aka.getBackground();
            DrawableCompat.setTint(background2, ao.getColor(oE));
            this.aka.setBackgroundDrawable(background2);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.jZf != i) {
            com.baidu.tbadk.core.util.f.a.m(this.jZs, R.color.CAM_X0205, R.color.CAM_X0204);
            ao.setViewTextColor(this.eFr, R.color.CAM_X0105);
            ao.setViewTextColor(this.aka, R.color.CAM_X0101);
            ao.setViewTextColor(this.jZr, R.color.CAM_X0101);
            this.jZq.setImageDrawable(SvgManager.bsx().a(R.drawable.ic_icon_pure_video_play12_svg, R.color.CAM_X0101, (SvgManager.SvgResourceStateType) null));
            cOP();
            this.jZf = i;
        }
    }
}
