package com.baidu.tieba.homepage.topic.topicdetail.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import d.b.b.e.p.l;
import d.b.i0.z0.j.a.c.e;
/* loaded from: classes3.dex */
public class TopicTimelineCellCardView extends LinearLayout implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public int f17410e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f17411f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f17412g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f17413h;
    public int i;
    public int j;
    public e k;

    public TopicTimelineCellCardView(Context context) {
        super(context);
        this.f17410e = 3;
        a(context);
    }

    public final void a(Context context) {
        setOrientation(1);
        LayoutInflater.from(context).inflate(R.layout.card_topic_timeline_cell_view, (ViewGroup) this, true);
        this.f17411f = (LinearLayout) findViewById(R.id.card_topic_timeline_cell_date);
        this.f17412g = (TextView) findViewById(R.id.card_topic_timeline_cell_time);
        this.f17413h = (TextView) findViewById(R.id.card_topic_timeline_cell_title);
        this.i = l.g(context, R.dimen.tbds340);
        this.j = l.g(context, R.dimen.tbds230);
        setOnClickListener(this);
        b();
    }

    public void b() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType == this.f17410e) {
            return;
        }
        this.f17410e = skinType;
        SkinManager.setViewTextColor(this.f17412g, R.color.cp_cont_m);
        SkinManager.setBackgroundResource(this.f17413h, R.drawable.topic_timeline_shade_bg);
        SkinManager.setViewTextColor(this.f17413h, R.color.CAM_X0106);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.k == null) {
            return;
        }
        TiebaStatic.log(new StatisticItem("c13353").param("tid", this.k.f63327b).param("topic_id", this.k.f63326a).param("obj_locate", this.k.f63331f + 1));
        MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(getContext()).createNormalCfg(String.valueOf(this.k.f63327b), "", "")));
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(this.i, this.j);
    }

    public void setData(e eVar) {
        if (eVar == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.k = eVar;
        this.f17412g.setText(eVar.f63329d);
        this.f17413h.setText(eVar.f63328c);
        if (StringUtils.isNull(eVar.f63330e)) {
            int i = eVar.f63331f;
            if (i == 0) {
                SkinManager.setBackgroundResource(this.f17411f, R.drawable.topic_timeline_bg_one);
                return;
            } else if (i == 1) {
                SkinManager.setBackgroundResource(this.f17411f, R.drawable.topic_timeline_bg_two);
                return;
            } else {
                SkinManager.setBackgroundResource(this.f17411f, R.drawable.topic_timeline_bg_three);
                return;
            }
        }
        try {
            GradientDrawable gradientDrawable = (GradientDrawable) getResources().getDrawable(R.drawable.topic_timeline_bg);
            gradientDrawable.setColor(Color.parseColor(eVar.f63330e));
            this.f17411f.setBackgroundDrawable(gradientDrawable);
        } catch (Exception unused) {
            int i2 = eVar.f63331f;
            if (i2 == 0) {
                SkinManager.setBackgroundResource(this.f17411f, R.drawable.topic_timeline_bg_one);
            } else if (i2 == 1) {
                SkinManager.setBackgroundResource(this.f17411f, R.drawable.topic_timeline_bg_two);
            } else {
                SkinManager.setBackgroundResource(this.f17411f, R.drawable.topic_timeline_bg_three);
            }
        }
    }

    public TopicTimelineCellCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f17410e = 3;
        a(context);
    }

    public TopicTimelineCellCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f17410e = 3;
        a(context);
    }
}
