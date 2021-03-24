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
import d.b.b.e.p.l;
import d.b.i0.z0.j.a.c.b;
import d.b.i0.z0.j.a.c.f;
/* loaded from: classes4.dex */
public class TopicDetailHeadView extends RelativeLayout {

    /* renamed from: e  reason: collision with root package name */
    public int f17390e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f17391f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f17392g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f17393h;
    public TbImageView i;
    public View j;
    public TopicPkView k;
    public TopicTimelineView l;

    public TopicDetailHeadView(Context context) {
        super(context);
        this.f17390e = 3;
        a(context);
    }

    public final void a(Context context) {
        LayoutInflater.from(context).inflate(R.layout.topic_detail_head_view_layout, (ViewGroup) this, true);
        TbImageView tbImageView = (TbImageView) findViewById(R.id.topic_detail_head_bg);
        this.f17391f = tbImageView;
        tbImageView.setDrawingCacheEnabled(true);
        this.f17392g = (TextView) findViewById(R.id.topic_detail_head_des);
        this.f17393h = (LinearLayout) findViewById(R.id.topic_detail_head_img_layout);
        this.i = (TbImageView) findViewById(R.id.topic_detail_head_img);
        this.j = findViewById(R.id.topic_detail_head_img_placeholder);
        this.k = (TopicPkView) findViewById(R.id.topic_detail_head_pk);
        this.l = (TopicTimelineView) findViewById(R.id.topic_detail_head_timeline);
        ViewGroup.LayoutParams layoutParams = this.i.getLayoutParams();
        layoutParams.height = ((l.k(getContext()) - l.g(getContext(), R.dimen.tbds88)) * 9) / 16;
        this.i.setLayoutParams(layoutParams);
        this.i.setRadius(l.g(context, R.dimen.tbds10));
        this.i.setConrers(15);
        this.i.setPlaceHolder(3);
        b();
    }

    public void b() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType == this.f17390e) {
            return;
        }
        this.f17390e = skinType;
        this.f17391f.setIsNight(skinType == 1);
        SkinManager.setViewTextColor(this.f17392g, R.color.CAM_X0101);
        this.i.setIsNight(this.f17390e == 1);
        this.k.q();
        this.l.b();
    }

    public TbImageView getmBgImg() {
        return this.f17391f;
    }

    public void setData(b bVar) {
        if (bVar == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        if (bVar.f63315e == null && StringUtils.isNull(bVar.f63313c)) {
            ((LinearLayout.LayoutParams) this.f17392g.getLayoutParams()).bottomMargin = l.g(getContext(), R.dimen.tbds130);
        }
        this.f17392g.setText(bVar.f63312b);
        if (StringUtils.isNull(bVar.f63313c)) {
            this.f17393h.setVisibility(8);
            this.f17391f.setDefaultBgResource(R.drawable.topic_detail_default_bg);
        } else {
            this.f17393h.setVisibility(0);
            this.i.W(bVar.f63313c, 10, false);
            this.f17391f.setDefaultBgResource(R.drawable.topic_detail_img_default_bg);
        }
        if (bVar.f63315e == null) {
            this.j.setVisibility(8);
            this.k.setVisibility(8);
        } else {
            this.j.setVisibility(0);
            this.k.setVisibility(0);
            this.k.setData(bVar.f63315e);
        }
        f fVar = bVar.f63316f;
        if (fVar != null && !ListUtils.isEmpty(fVar.f63332b)) {
            this.l.setVisibility(0);
            this.l.setData(bVar.f63316f);
        } else {
            this.l.setVisibility(8);
        }
        this.f17391f.W(bVar.f63314d, 10, false);
    }

    public TopicDetailHeadView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f17390e = 3;
        a(context);
    }

    public TopicDetailHeadView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f17390e = 3;
        a(context);
    }
}
