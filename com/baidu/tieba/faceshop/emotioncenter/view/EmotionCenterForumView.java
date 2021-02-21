package com.baidu.tieba.faceshop.emotioncenter.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import com.baidu.tieba.faceshop.emotioncenter.data.EmotionCenterData;
/* loaded from: classes9.dex */
public class EmotionCenterForumView extends RelativeLayout implements View.OnClickListener {
    private TbPageContext eUY;
    private TextView iYW;
    private TextView iYX;
    private EmotionCenterData.EmotionForumData iYY;
    private ImageView mArrow;

    public EmotionCenterForumView(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.eUY = tbPageContext;
        initView();
    }

    public EmotionCenterForumView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initView();
    }

    public EmotionCenterForumView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView();
    }

    private void initView() {
        LayoutInflater.from(getContext()).inflate(R.layout.emotion_forum_layout, this);
        this.iYW = (TextView) findViewById(R.id.forum_title_tv);
        this.iYX = (TextView) findViewById(R.id.forum_recommend_tv);
        this.mArrow = (ImageView) findViewById(R.id.forum_arrow);
        setOnClickListener(this);
    }

    public void setData(EmotionCenterData.EmotionForumData emotionForumData) {
        onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
        this.iYY = emotionForumData;
    }

    public void onChangeSkin(int i) {
        ap.setViewTextColor(this.iYW, R.color.CAM_X0105, i);
        ap.setViewTextColor(this.iYX, R.color.cp_cont_r, i);
        ap.setBackgroundResource(this.mArrow, R.drawable.emotion_center_arrow, i);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this && this.iYY != null) {
            this.eUY.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.eUY.getPageActivity()).createNormalCfg(this.iYY.forum_name, null)));
        }
    }
}
