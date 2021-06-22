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
import d.a.c.e.p.l;
import d.a.o0.b1.k.a.c.e;
/* loaded from: classes4.dex */
public class TopicTimelineCellCardView extends LinearLayout implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public int f16763e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f16764f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f16765g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f16766h;

    /* renamed from: i  reason: collision with root package name */
    public int f16767i;
    public int j;
    public e k;

    public TopicTimelineCellCardView(Context context) {
        super(context);
        this.f16763e = 3;
        a(context);
    }

    public final void a(Context context) {
        setOrientation(1);
        LayoutInflater.from(context).inflate(R.layout.card_topic_timeline_cell_view, (ViewGroup) this, true);
        this.f16764f = (LinearLayout) findViewById(R.id.card_topic_timeline_cell_date);
        this.f16765g = (TextView) findViewById(R.id.card_topic_timeline_cell_time);
        this.f16766h = (TextView) findViewById(R.id.card_topic_timeline_cell_title);
        this.f16767i = l.g(context, R.dimen.tbds340);
        this.j = l.g(context, R.dimen.tbds230);
        setOnClickListener(this);
        b();
    }

    public void b() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType == this.f16763e) {
            return;
        }
        this.f16763e = skinType;
        SkinManager.setViewTextColor(this.f16765g, R.color.cp_cont_m);
        SkinManager.setBackgroundResource(this.f16766h, R.drawable.topic_timeline_shade_bg);
        SkinManager.setViewTextColor(this.f16766h, R.color.CAM_X0106);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.k == null) {
            return;
        }
        TiebaStatic.log(new StatisticItem("c13353").param("tid", this.k.f55771b).param("topic_id", this.k.f55770a).param("obj_locate", this.k.f55775f + 1));
        MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(getContext()).createNormalCfg(String.valueOf(this.k.f55771b), "", "")));
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        setMeasuredDimension(this.f16767i, this.j);
    }

    public void setData(e eVar) {
        if (eVar == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.k = eVar;
        this.f16765g.setText(eVar.f55773d);
        this.f16766h.setText(eVar.f55772c);
        if (StringUtils.isNull(eVar.f55774e)) {
            int i2 = eVar.f55775f;
            if (i2 == 0) {
                SkinManager.setBackgroundResource(this.f16764f, R.drawable.topic_timeline_bg_one);
                return;
            } else if (i2 == 1) {
                SkinManager.setBackgroundResource(this.f16764f, R.drawable.topic_timeline_bg_two);
                return;
            } else {
                SkinManager.setBackgroundResource(this.f16764f, R.drawable.topic_timeline_bg_three);
                return;
            }
        }
        try {
            GradientDrawable gradientDrawable = (GradientDrawable) getResources().getDrawable(R.drawable.topic_timeline_bg);
            gradientDrawable.setColor(Color.parseColor(eVar.f55774e));
            this.f16764f.setBackgroundDrawable(gradientDrawable);
        } catch (Exception unused) {
            int i3 = eVar.f55775f;
            if (i3 == 0) {
                SkinManager.setBackgroundResource(this.f16764f, R.drawable.topic_timeline_bg_one);
            } else if (i3 == 1) {
                SkinManager.setBackgroundResource(this.f16764f, R.drawable.topic_timeline_bg_two);
            } else {
                SkinManager.setBackgroundResource(this.f16764f, R.drawable.topic_timeline_bg_three);
            }
        }
    }

    public TopicTimelineCellCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f16763e = 3;
        a(context);
    }

    public TopicTimelineCellCardView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f16763e = 3;
        a(context);
    }
}
