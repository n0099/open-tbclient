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
import d.a.j0.a1.j.a.c.b;
import d.a.j0.a1.j.a.c.f;
/* loaded from: classes4.dex */
public class TopicDetailHeadView extends RelativeLayout {

    /* renamed from: e  reason: collision with root package name */
    public int f17359e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f17360f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f17361g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f17362h;

    /* renamed from: i  reason: collision with root package name */
    public TbImageView f17363i;
    public View j;
    public TopicPkView k;
    public TopicTimelineView l;

    public TopicDetailHeadView(Context context) {
        super(context);
        this.f17359e = 3;
        a(context);
    }

    public final void a(Context context) {
        LayoutInflater.from(context).inflate(R.layout.topic_detail_head_view_layout, (ViewGroup) this, true);
        TbImageView tbImageView = (TbImageView) findViewById(R.id.topic_detail_head_bg);
        this.f17360f = tbImageView;
        tbImageView.setDrawingCacheEnabled(true);
        this.f17361g = (TextView) findViewById(R.id.topic_detail_head_des);
        this.f17362h = (LinearLayout) findViewById(R.id.topic_detail_head_img_layout);
        this.f17363i = (TbImageView) findViewById(R.id.topic_detail_head_img);
        this.j = findViewById(R.id.topic_detail_head_img_placeholder);
        this.k = (TopicPkView) findViewById(R.id.topic_detail_head_pk);
        this.l = (TopicTimelineView) findViewById(R.id.topic_detail_head_timeline);
        ViewGroup.LayoutParams layoutParams = this.f17363i.getLayoutParams();
        layoutParams.height = ((l.k(getContext()) - l.g(getContext(), R.dimen.tbds88)) * 9) / 16;
        this.f17363i.setLayoutParams(layoutParams);
        this.f17363i.setRadius(l.g(context, R.dimen.tbds10));
        this.f17363i.setConrers(15);
        this.f17363i.setPlaceHolder(3);
        b();
    }

    public void b() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType == this.f17359e) {
            return;
        }
        this.f17359e = skinType;
        this.f17360f.setIsNight(skinType == 1);
        SkinManager.setViewTextColor(this.f17361g, R.color.CAM_X0101);
        this.f17363i.setIsNight(this.f17359e == 1);
        this.k.q();
        this.l.b();
    }

    public TbImageView getmBgImg() {
        return this.f17360f;
    }

    public void setData(b bVar) {
        if (bVar == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        if (bVar.f51078e == null && StringUtils.isNull(bVar.f51076c)) {
            ((LinearLayout.LayoutParams) this.f17361g.getLayoutParams()).bottomMargin = l.g(getContext(), R.dimen.tbds130);
        }
        this.f17361g.setText(bVar.f51075b);
        if (StringUtils.isNull(bVar.f51076c)) {
            this.f17362h.setVisibility(8);
            this.f17360f.setDefaultBgResource(R.drawable.topic_detail_default_bg);
        } else {
            this.f17362h.setVisibility(0);
            this.f17363i.V(bVar.f51076c, 10, false);
            this.f17360f.setDefaultBgResource(R.drawable.topic_detail_img_default_bg);
        }
        if (bVar.f51078e == null) {
            this.j.setVisibility(8);
            this.k.setVisibility(8);
        } else {
            this.j.setVisibility(0);
            this.k.setVisibility(0);
            this.k.setData(bVar.f51078e);
        }
        f fVar = bVar.f51079f;
        if (fVar != null && !ListUtils.isEmpty(fVar.f51097b)) {
            this.l.setVisibility(0);
            this.l.setData(bVar.f51079f);
        } else {
            this.l.setVisibility(8);
        }
        this.f17360f.V(bVar.f51077d, 10, false);
    }

    public TopicDetailHeadView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f17359e = 3;
        a(context);
    }

    public TopicDetailHeadView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f17359e = 3;
        a(context);
    }
}
