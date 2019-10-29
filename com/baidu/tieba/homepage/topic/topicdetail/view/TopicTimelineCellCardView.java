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
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class TopicTimelineCellCardView extends LinearLayout implements View.OnClickListener {
    private LinearLayout eOc;
    private TextView exe;
    private com.baidu.tieba.homepage.topic.topicdetail.b.e gpb;
    private int mHeight;
    private int mSkinType;
    private TextView mTitleView;
    private int mWidth;

    public TopicTimelineCellCardView(Context context) {
        super(context);
        this.mSkinType = 3;
        init(context);
    }

    public TopicTimelineCellCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        init(context);
    }

    public TopicTimelineCellCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        init(context);
    }

    private void init(Context context) {
        setOrientation(1);
        LayoutInflater.from(context).inflate(R.layout.card_topic_timeline_cell_view, (ViewGroup) this, true);
        this.eOc = (LinearLayout) findViewById(R.id.card_topic_timeline_cell_date);
        this.exe = (TextView) findViewById(R.id.card_topic_timeline_cell_time);
        this.mTitleView = (TextView) findViewById(R.id.card_topic_timeline_cell_title);
        this.mWidth = l.getDimens(context, R.dimen.tbds340);
        this.mHeight = l.getDimens(context, R.dimen.tbds230);
        setOnClickListener(this);
        onChangeSkinType();
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(this.mWidth, this.mHeight);
    }

    public void setData(com.baidu.tieba.homepage.topic.topicdetail.b.e eVar) {
        if (eVar == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.gpb = eVar;
        this.exe.setText(eVar.gnY);
        this.mTitleView.setText(eVar.title);
        if (StringUtils.isNull(eVar.TW)) {
            if (eVar.index == 0) {
                am.setBackgroundResource(this.eOc, R.drawable.topic_timeline_bg_one);
                return;
            } else if (eVar.index == 1) {
                am.setBackgroundResource(this.eOc, R.drawable.topic_timeline_bg_two);
                return;
            } else {
                am.setBackgroundResource(this.eOc, R.drawable.topic_timeline_bg_three);
                return;
            }
        }
        try {
            GradientDrawable gradientDrawable = (GradientDrawable) getResources().getDrawable(R.drawable.topic_timeline_bg);
            gradientDrawable.setColor(Color.parseColor(eVar.TW));
            this.eOc.setBackgroundDrawable(gradientDrawable);
        } catch (Exception e) {
            if (eVar.index == 0) {
                am.setBackgroundResource(this.eOc, R.drawable.topic_timeline_bg_one);
            } else if (eVar.index == 1) {
                am.setBackgroundResource(this.eOc, R.drawable.topic_timeline_bg_two);
            } else {
                am.setBackgroundResource(this.eOc, R.drawable.topic_timeline_bg_three);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.gpb != null) {
            TiebaStatic.log(new an("c13353").p("tid", this.gpb.tid).p("topic_id", this.gpb.topicId).O("obj_locate", this.gpb.index + 1));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(getContext()).createNormalCfg(String.valueOf(this.gpb.tid), "", "")));
        }
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            am.setViewTextColor(this.exe, (int) R.color.cp_cont_m);
            am.setBackgroundResource(this.mTitleView, R.drawable.topic_timeline_shade_bg);
            am.setViewTextColor(this.mTitleView, (int) R.color.cp_cont_f);
        }
    }
}
