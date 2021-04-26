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
    public TbPageContext f15604e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f15605f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f15606g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f15607h;

    /* renamed from: i  reason: collision with root package name */
    public EmotionCenterData.EmotionForumData f15608i;

    public EmotionCenterForumView(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.f15604e = tbPageContext;
        a();
    }

    public final void a() {
        LayoutInflater.from(getContext()).inflate(R.layout.emotion_forum_layout, this);
        this.f15605f = (TextView) findViewById(R.id.forum_title_tv);
        this.f15606g = (TextView) findViewById(R.id.forum_recommend_tv);
        this.f15607h = (ImageView) findViewById(R.id.forum_arrow);
        setOnClickListener(this);
    }

    public void b(int i2) {
        SkinManager.setViewTextColor(this.f15605f, R.color.CAM_X0105, i2);
        SkinManager.setViewTextColor(this.f15606g, R.color.cp_cont_r, i2);
        SkinManager.setBackgroundResource(this.f15607h, R.drawable.emotion_center_arrow, i2);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != this || this.f15608i == null) {
            return;
        }
        this.f15604e.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f15604e.getPageActivity()).createNormalCfg(this.f15608i.forum_name, null)));
    }

    public void setData(EmotionCenterData.EmotionForumData emotionForumData) {
        b(TbadkCoreApplication.getInst().getSkinType());
        this.f15608i = emotionForumData;
    }

    public EmotionCenterForumView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public EmotionCenterForumView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a();
    }
}
