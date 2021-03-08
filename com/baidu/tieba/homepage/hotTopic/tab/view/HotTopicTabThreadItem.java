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
    private f<e> akI;
    private TextView alh;
    private TextView ali;
    private TextView eIY;
    private int kiZ;
    private TbImageView kjh;
    private View kji;
    private View kjj;
    private ImageView kjk;
    private TextView kjl;
    private View kjm;
    private e kjn;

    public HotTopicTabThreadItem(Context context) {
        super(context);
        this.kiZ = 3;
        initView();
    }

    public HotTopicTabThreadItem(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.kiZ = 3;
        initView();
    }

    public HotTopicTabThreadItem(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kiZ = 3;
        initView();
    }

    private void initView() {
        LayoutInflater.from(getContext()).inflate(R.layout.hot_topic_tab_thread_item, (ViewGroup) this, true);
        this.kjh = (TbImageView) findViewById(R.id.coverView);
        this.kji = findViewById(R.id.coverGradientMask);
        this.kjj = findViewById(R.id.videoTimeContainer);
        this.kjk = (ImageView) findViewById(R.id.videoPlayIcon);
        this.kjl = (TextView) findViewById(R.id.videoPlayTime);
        this.alh = (TextView) findViewById(R.id.indexView);
        this.eIY = (TextView) findViewById(R.id.titleView);
        this.ali = (TextView) findViewById(R.id.tagView);
        this.kjh.setPlaceHolder(2);
        this.kjh.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
        this.kjh.setConrers(15);
        this.kjm = findViewById(R.id.rootLayout);
        this.kjm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.hotTopic.tab.view.HotTopicTabThreadItem.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HotTopicTabThreadItem.this.kjn != null && HotTopicTabThreadItem.this.kjn.eLr != null) {
                    if (HotTopicTabThreadItem.this.akI != null) {
                        HotTopicTabThreadItem.this.akI.a(view, HotTopicTabThreadItem.this.kjn, HotTopicTabThreadItem.this.kjn.index, HotTopicTabThreadItem.this.kjn.index);
                    }
                    az.a((com.baidu.tbadk.core.data.a) HotTopicTabThreadItem.this.kjn.eLr, view.getContext(), 2, false, true);
                }
            }
        });
    }

    public void setOnItemCoverListener(f<e> fVar) {
        this.akI = fVar;
    }

    public void a(e eVar) {
        if (eVar != null) {
            this.kjn = eVar;
            if (TextUtils.isEmpty(eVar.cover)) {
                this.kjh.setVisibility(8);
                this.kji.setVisibility(8);
                this.kjj.setVisibility(8);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ali.getLayoutParams();
                layoutParams.addRule(8, 0);
                layoutParams.addRule(3, R.id.titleView);
                this.ali.setLayoutParams(layoutParams);
            } else {
                this.kjh.startLoad(eVar.cover, 10, false);
                this.kjh.setVisibility(0);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.ali.getLayoutParams();
                layoutParams2.addRule(8, R.id.coverView);
                layoutParams2.addRule(3, 0);
                this.ali.setLayoutParams(layoutParams2);
                if (eVar.time > 0) {
                    this.kjj.setVisibility(0);
                    this.kji.setVisibility(0);
                    this.kjl.setText(StringUtils.translateSecondsToString(eVar.time));
                } else {
                    this.kjj.setVisibility(8);
                    this.kji.setVisibility(8);
                }
            }
            this.eIY.setText(eVar.title);
            this.ali.setText(this.ali.getContext().getResources().getString(R.string.hot_topic_thread_item_tag, au.ed(eVar.eVA < 1000 ? 1000 : eVar.eVA)));
            this.alh.setText(String.valueOf(eVar.index));
            cRa();
            if (this.akI != null && this.kjn != null) {
                this.akI.b(this, this.kjn, this.kjn.index, this.kjn.index);
            }
        }
    }

    private void cRa() {
        if (this.kjn != null) {
            int oK = TagTextHelper.oK(this.kjn.index);
            Drawable background = this.ali.getBackground();
            DrawableCompat.setTint(background, ap.getColor(oK));
            background.setAlpha(40);
            this.ali.setBackgroundDrawable(background);
            ap.setViewTextColor(this.ali, oK);
            Drawable background2 = this.alh.getBackground();
            DrawableCompat.setTint(background2, ap.getColor(oK));
            this.alh.setBackgroundDrawable(background2);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.kiZ != i) {
            com.baidu.tbadk.core.util.f.a.m(this.kjm, R.color.CAM_X0205, R.color.CAM_X0204);
            ap.setViewTextColor(this.eIY, R.color.CAM_X0105);
            ap.setViewTextColor(this.alh, R.color.CAM_X0101);
            ap.setViewTextColor(this.kjl, R.color.CAM_X0101);
            this.kjk.setImageDrawable(SvgManager.bsU().a(R.drawable.ic_icon_pure_video_play12_svg, R.color.CAM_X0101, (SvgManager.SvgResourceStateType) null));
            cRa();
            this.kiZ = i;
        }
    }
}
