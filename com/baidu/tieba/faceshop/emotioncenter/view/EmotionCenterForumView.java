package com.baidu.tieba.faceshop.emotioncenter.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.faceshop.emotioncenter.data.EmotionCenterData;
/* loaded from: classes4.dex */
public class EmotionCenterForumView extends RelativeLayout implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext f15450e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f15451f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f15452g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f15453h;
    public EmotionCenterData.EmotionForumData i;

    public EmotionCenterForumView(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.f15450e = tbPageContext;
        a();
    }

    public final void a() {
        LayoutInflater.from(getContext()).inflate(R.layout.emotion_forum_layout, this);
        this.f15451f = (TextView) findViewById(R.id.forum_title_tv);
        this.f15452g = (TextView) findViewById(R.id.forum_recommend_tv);
        this.f15453h = (ImageView) findViewById(R.id.forum_arrow);
        setOnClickListener(this);
    }

    public void b(int i) {
        SkinManager.setViewTextColor(this.f15451f, R.color.CAM_X0105, i);
        SkinManager.setViewTextColor(this.f15452g, R.color.cp_cont_r, i);
        SkinManager.setBackgroundResource(this.f15453h, R.drawable.emotion_center_arrow, i);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != this || this.i == null) {
            return;
        }
        this.f15450e.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f15450e.getPageActivity()).createNormalCfg(this.i.forum_name, null)));
    }

    public void setData(EmotionCenterData.EmotionForumData emotionForumData) {
        b(TbadkCoreApplication.getInst().getSkinType());
        this.i = emotionForumData;
    }

    public EmotionCenterForumView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public EmotionCenterForumView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }
}
