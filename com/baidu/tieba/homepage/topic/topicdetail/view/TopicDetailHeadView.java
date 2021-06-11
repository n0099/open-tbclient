package com.baidu.tieba.homepage.topic.topicdetail.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.topic.topictab.view.TopicPkView;
import d.a.c.e.p.l;
import d.a.n0.b1.k.a.c.b;
import d.a.n0.b1.k.a.c.f;
/* loaded from: classes4.dex */
public class TopicDetailHeadView extends RelativeLayout {

    /* renamed from: e  reason: collision with root package name */
    public int f16660e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f16661f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f16662g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f16663h;

    /* renamed from: i  reason: collision with root package name */
    public TbImageView f16664i;
    public View j;
    public TopicPkView k;
    public TopicTimelineView l;

    public TopicDetailHeadView(Context context) {
        super(context);
        this.f16660e = 3;
        a(context);
    }

    public final void a(Context context) {
        LayoutInflater.from(context).inflate(R.layout.topic_detail_head_view_layout, (ViewGroup) this, true);
        TbImageView tbImageView = (TbImageView) findViewById(R.id.topic_detail_head_bg);
        this.f16661f = tbImageView;
        tbImageView.setDrawingCacheEnabled(true);
        this.f16662g = (TextView) findViewById(R.id.topic_detail_head_des);
        this.f16663h = (LinearLayout) findViewById(R.id.topic_detail_head_img_layout);
        this.f16664i = (TbImageView) findViewById(R.id.topic_detail_head_img);
        this.j = findViewById(R.id.topic_detail_head_img_placeholder);
        this.k = (TopicPkView) findViewById(R.id.topic_detail_head_pk);
        this.l = (TopicTimelineView) findViewById(R.id.topic_detail_head_timeline);
        ViewGroup.LayoutParams layoutParams = this.f16664i.getLayoutParams();
        layoutParams.height = ((l.k(getContext()) - l.g(getContext(), R.dimen.tbds88)) * 9) / 16;
        this.f16664i.setLayoutParams(layoutParams);
        this.f16664i.setRadius(l.g(context, R.dimen.tbds10));
        this.f16664i.setConrers(15);
        this.f16664i.setPlaceHolder(3);
        b();
    }

    public void b() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType == this.f16660e) {
            return;
        }
        this.f16660e = skinType;
        this.f16661f.setIsNight(skinType == 1);
        SkinManager.setViewTextColor(this.f16662g, R.color.CAM_X0101);
        this.f16664i.setIsNight(this.f16660e == 1);
        this.k.q();
        this.l.b();
    }

    public TbImageView getmBgImg() {
        return this.f16661f;
    }

    public void setData(b bVar) {
        if (bVar == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        if (bVar.f55633e == null && StringUtils.isNull(bVar.f55631c)) {
            ((LinearLayout.LayoutParams) this.f16662g.getLayoutParams()).bottomMargin = l.g(getContext(), R.dimen.tbds130);
        }
        this.f16662g.setText(bVar.f55630b);
        if (StringUtils.isNull(bVar.f55631c)) {
            this.f16663h.setVisibility(8);
            this.f16661f.setDefaultBgResource(R.drawable.topic_detail_default_bg);
        } else {
            this.f16663h.setVisibility(0);
            this.f16664i.U(bVar.f55631c, 10, false);
            this.f16661f.setDefaultBgResource(R.drawable.topic_detail_img_default_bg);
        }
        if (bVar.f55633e == null) {
            this.j.setVisibility(8);
            this.k.setVisibility(8);
        } else {
            this.j.setVisibility(0);
            this.k.setVisibility(0);
            this.k.setData(bVar.f55633e);
        }
        f fVar = bVar.f55634f;
        if (fVar != null && !ListUtils.isEmpty(fVar.f55652b)) {
            this.l.setVisibility(0);
            this.l.setData(bVar.f55634f);
        } else {
            this.l.setVisibility(8);
        }
        this.f16661f.U(bVar.f55632d, 10, false);
    }

    public TopicDetailHeadView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f16660e = 3;
        a(context);
    }

    public TopicDetailHeadView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f16660e = 3;
        a(context);
    }
}
