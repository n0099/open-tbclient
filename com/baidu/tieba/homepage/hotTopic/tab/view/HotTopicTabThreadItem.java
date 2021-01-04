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
    private TextView akR;
    private TextView akS;
    private f<e> aks;
    private TextView eKc;
    private int kdK;
    private TbImageView kdS;
    private View kdT;
    private View kdU;
    private ImageView kdV;
    private TextView kdW;
    private View kdX;
    private e kdY;

    public HotTopicTabThreadItem(Context context) {
        super(context);
        this.kdK = 3;
        initView();
    }

    public HotTopicTabThreadItem(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.kdK = 3;
        initView();
    }

    public HotTopicTabThreadItem(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kdK = 3;
        initView();
    }

    private void initView() {
        LayoutInflater.from(getContext()).inflate(R.layout.hot_topic_tab_thread_item, (ViewGroup) this, true);
        this.kdS = (TbImageView) findViewById(R.id.coverView);
        this.kdT = findViewById(R.id.coverGradientMask);
        this.kdU = findViewById(R.id.videoTimeContainer);
        this.kdV = (ImageView) findViewById(R.id.videoPlayIcon);
        this.kdW = (TextView) findViewById(R.id.videoPlayTime);
        this.akR = (TextView) findViewById(R.id.indexView);
        this.eKc = (TextView) findViewById(R.id.titleView);
        this.akS = (TextView) findViewById(R.id.tagView);
        this.kdS.setPlaceHolder(2);
        this.kdS.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
        this.kdS.setConrers(15);
        this.kdX = findViewById(R.id.rootLayout);
        this.kdX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.hotTopic.tab.view.HotTopicTabThreadItem.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HotTopicTabThreadItem.this.kdY != null && HotTopicTabThreadItem.this.kdY.eMv != null) {
                    if (HotTopicTabThreadItem.this.aks != null) {
                        HotTopicTabThreadItem.this.aks.a(view, HotTopicTabThreadItem.this.kdY, HotTopicTabThreadItem.this.kdY.index, HotTopicTabThreadItem.this.kdY.index);
                    }
                    ay.a((com.baidu.tbadk.core.data.a) HotTopicTabThreadItem.this.kdY.eMv, view.getContext(), 2, false, true);
                }
            }
        });
    }

    public void setOnItemCoverListener(f<e> fVar) {
        this.aks = fVar;
    }

    public void a(e eVar) {
        if (eVar != null) {
            this.kdY = eVar;
            if (TextUtils.isEmpty(eVar.cover)) {
                this.kdS.setVisibility(8);
                this.kdT.setVisibility(8);
                this.kdU.setVisibility(8);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.akS.getLayoutParams();
                layoutParams.addRule(8, 0);
                layoutParams.addRule(3, R.id.titleView);
                this.akS.setLayoutParams(layoutParams);
            } else {
                this.kdS.startLoad(eVar.cover, 10, false);
                this.kdS.setVisibility(0);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.akS.getLayoutParams();
                layoutParams2.addRule(8, R.id.coverView);
                layoutParams2.addRule(3, 0);
                this.akS.setLayoutParams(layoutParams2);
                if (eVar.time > 0) {
                    this.kdU.setVisibility(0);
                    this.kdT.setVisibility(0);
                    this.kdW.setText(StringUtils.translateSecondsToString(eVar.time));
                } else {
                    this.kdU.setVisibility(8);
                    this.kdT.setVisibility(8);
                }
            }
            this.eKc.setText(eVar.title);
            this.akS.setText(this.akS.getContext().getResources().getString(R.string.hot_topic_thread_item_tag, at.dX(eVar.eWw < 1000 ? 1000 : eVar.eWw)));
            this.akR.setText(String.valueOf(eVar.index));
            cSG();
            if (this.aks != null && this.kdY != null) {
                this.aks.b(this, this.kdY, this.kdY.index, this.kdY.index);
            }
        }
    }

    private void cSG() {
        if (this.kdY != null) {
            int ql = TagTextHelper.ql(this.kdY.index);
            Drawable background = this.akS.getBackground();
            DrawableCompat.setTint(background, ao.getColor(ql));
            background.setAlpha(40);
            this.akS.setBackgroundDrawable(background);
            ao.setViewTextColor(this.akS, ql);
            Drawable background2 = this.akR.getBackground();
            DrawableCompat.setTint(background2, ao.getColor(ql));
            this.akR.setBackgroundDrawable(background2);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.kdK != i) {
            com.baidu.tbadk.core.util.f.a.m(this.kdX, R.color.CAM_X0205, R.color.CAM_X0204);
            ao.setViewTextColor(this.eKc, R.color.CAM_X0105);
            ao.setViewTextColor(this.akR, R.color.CAM_X0101);
            ao.setViewTextColor(this.kdW, R.color.CAM_X0101);
            this.kdV.setImageDrawable(SvgManager.bwq().a(R.drawable.ic_icon_pure_video_play12_svg, R.color.CAM_X0101, (SvgManager.SvgResourceStateType) null));
            cSG();
            this.kdK = i;
        }
    }
}
