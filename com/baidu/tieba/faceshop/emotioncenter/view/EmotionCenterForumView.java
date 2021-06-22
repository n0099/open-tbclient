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
    public TbPageContext f14961e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f14962f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f14963g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f14964h;

    /* renamed from: i  reason: collision with root package name */
    public EmotionCenterData.EmotionForumData f14965i;

    public EmotionCenterForumView(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.f14961e = tbPageContext;
        a();
    }

    public final void a() {
        LayoutInflater.from(getContext()).inflate(R.layout.emotion_forum_layout, this);
        this.f14962f = (TextView) findViewById(R.id.forum_title_tv);
        this.f14963g = (TextView) findViewById(R.id.forum_recommend_tv);
        this.f14964h = (ImageView) findViewById(R.id.forum_arrow);
        setOnClickListener(this);
    }

    public void b(int i2) {
        SkinManager.setViewTextColor(this.f14962f, R.color.CAM_X0105, i2);
        SkinManager.setViewTextColor(this.f14963g, R.color.cp_cont_r, i2);
        SkinManager.setBackgroundResource(this.f14964h, R.drawable.emotion_center_arrow, i2);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != this || this.f14965i == null) {
            return;
        }
        this.f14961e.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f14961e.getPageActivity()).createNormalCfg(this.f14965i.forum_name, null)));
    }

    public void setData(EmotionCenterData.EmotionForumData emotionForumData) {
        b(TbadkCoreApplication.getInst().getSkinType());
        this.f14965i = emotionForumData;
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
