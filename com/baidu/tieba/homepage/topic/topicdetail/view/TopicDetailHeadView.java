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
import d.b.c.e.p.l;
import d.b.j0.a1.j.a.c.b;
import d.b.j0.a1.j.a.c.f;
/* loaded from: classes4.dex */
public class TopicDetailHeadView extends RelativeLayout {

    /* renamed from: e  reason: collision with root package name */
    public int f17076e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f17077f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f17078g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f17079h;
    public TbImageView i;
    public View j;
    public TopicPkView k;
    public TopicTimelineView l;

    public TopicDetailHeadView(Context context) {
        super(context);
        this.f17076e = 3;
        a(context);
    }

    public final void a(Context context) {
        LayoutInflater.from(context).inflate(R.layout.topic_detail_head_view_layout, (ViewGroup) this, true);
        TbImageView tbImageView = (TbImageView) findViewById(R.id.topic_detail_head_bg);
        this.f17077f = tbImageView;
        tbImageView.setDrawingCacheEnabled(true);
        this.f17078g = (TextView) findViewById(R.id.topic_detail_head_des);
        this.f17079h = (LinearLayout) findViewById(R.id.topic_detail_head_img_layout);
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
        if (skinType == this.f17076e) {
            return;
        }
        this.f17076e = skinType;
        this.f17077f.setIsNight(skinType == 1);
        SkinManager.setViewTextColor(this.f17078g, R.color.CAM_X0101);
        this.i.setIsNight(this.f17076e == 1);
        this.k.q();
        this.l.b();
    }

    public TbImageView getmBgImg() {
        return this.f17077f;
    }

    public void setData(b bVar) {
        if (bVar == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        if (bVar.f53356e == null && StringUtils.isNull(bVar.f53354c)) {
            ((LinearLayout.LayoutParams) this.f17078g.getLayoutParams()).bottomMargin = l.g(getContext(), R.dimen.tbds130);
        }
        this.f17078g.setText(bVar.f53353b);
        if (StringUtils.isNull(bVar.f53354c)) {
            this.f17079h.setVisibility(8);
            this.f17077f.setDefaultBgResource(R.drawable.topic_detail_default_bg);
        } else {
            this.f17079h.setVisibility(0);
            this.i.W(bVar.f53354c, 10, false);
            this.f17077f.setDefaultBgResource(R.drawable.topic_detail_img_default_bg);
        }
        if (bVar.f53356e == null) {
            this.j.setVisibility(8);
            this.k.setVisibility(8);
        } else {
            this.j.setVisibility(0);
            this.k.setVisibility(0);
            this.k.setData(bVar.f53356e);
        }
        f fVar = bVar.f53357f;
        if (fVar != null && !ListUtils.isEmpty(fVar.f53373b)) {
            this.l.setVisibility(0);
            this.l.setData(bVar.f53357f);
        } else {
            this.l.setVisibility(8);
        }
        this.f17077f.W(bVar.f53355d, 10, false);
    }

    public TopicDetailHeadView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f17076e = 3;
        a(context);
    }

    public TopicDetailHeadView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f17076e = 3;
        a(context);
    }
}
