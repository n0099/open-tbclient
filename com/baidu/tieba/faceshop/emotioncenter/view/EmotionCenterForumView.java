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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
import com.baidu.tieba.faceshop.emotioncenter.data.EmotionCenterData;
/* loaded from: classes9.dex */
public class EmotionCenterForumView extends RelativeLayout implements View.OnClickListener {
    private TbPageContext eXu;
    private TextView iXI;
    private TextView iXJ;
    private EmotionCenterData.EmotionForumData iXK;
    private ImageView mArrow;

    public EmotionCenterForumView(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.eXu = tbPageContext;
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
        this.iXI = (TextView) findViewById(R.id.forum_title_tv);
        this.iXJ = (TextView) findViewById(R.id.forum_recommend_tv);
        this.mArrow = (ImageView) findViewById(R.id.forum_arrow);
        setOnClickListener(this);
    }

    public void setData(EmotionCenterData.EmotionForumData emotionForumData) {
        onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
        this.iXK = emotionForumData;
    }

    public void onChangeSkin(int i) {
        ao.setViewTextColor(this.iXI, R.color.CAM_X0105, i);
        ao.setViewTextColor(this.iXJ, R.color.cp_cont_r, i);
        ao.setBackgroundResource(this.mArrow, R.drawable.emotion_center_arrow, i);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this && this.iXK != null) {
            this.eXu.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.eXu.getPageActivity()).createNormalCfg(this.iXK.forum_name, null)));
        }
    }
}
