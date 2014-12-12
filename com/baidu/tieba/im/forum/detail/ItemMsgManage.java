package com.baidu.tieba.im.forum.detail;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.coreExtra.view.SettingTextSwitchView;
import com.baidu.tieba.x;
import tbclient.RecommendForumInfo;
/* loaded from: classes.dex */
public class ItemMsgManage extends LinearLayout {
    private SettingTextSwitchView aZR;
    private RelativeLayout aZS;
    private RelativeLayout aZT;

    public ItemMsgManage(Context context) {
        super(context);
        init(context);
    }

    public ItemMsgManage(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public void init(Context context) {
        setOrientation(1);
        com.baidu.adp.lib.g.b.ek().a(context, x.forum_detail_msg_manage, this, true);
        setVisibility(8);
        this.aZR = (SettingTextSwitchView) findViewById(com.baidu.tieba.w.bar_notify);
        this.aZS = (RelativeLayout) findViewById(com.baidu.tieba.w.bar_info_clean_lay);
        this.aZT = (RelativeLayout) findViewById(com.baidu.tieba.w.bar_info_history_lay);
    }

    public void setData(RecommendForumInfo recommendForumInfo) {
        setShowState(recommendForumInfo);
        if (recommendForumInfo.is_like.intValue() == 0) {
            setVisibility(8);
        }
        com.baidu.tieba.im.settingcache.h.SX().a(TbadkApplication.getCurrentAccount(), String.valueOf(recommendForumInfo.forum_id), new w(this));
    }

    private void setShowState(RecommendForumInfo recommendForumInfo) {
        if (recommendForumInfo != null) {
            int intValue = recommendForumInfo.forum_type.intValue();
            if (intValue == 0) {
                setVisibility(8);
            } else if (intValue == 1) {
                setVisibility(0);
            } else if (intValue == 2) {
                this.aZT.setVisibility(8);
                setVisibility(0);
            }
        }
    }

    public void b(RecommendForumInfo recommendForumInfo, boolean z) {
        setShowState(recommendForumInfo);
        if (!z) {
            setVisibility(8);
        }
    }

    public void setSwitch(boolean z) {
        if (z) {
            this.aZR.getSwitchView().iI();
        } else {
            this.aZR.getSwitchView().iJ();
        }
    }

    public void setMsgOnClickListener(View.OnClickListener onClickListener) {
        this.aZS.setOnClickListener(onClickListener);
        this.aZT.setOnClickListener(onClickListener);
    }

    public void setSwitchChangeListener(com.baidu.adp.widget.BdSwitchView.c cVar) {
        this.aZR.setSwitchStateChangeListener(cVar);
    }

    public void a(ForumDetailActivity forumDetailActivity, int i) {
        forumDetailActivity.getLayoutMode().ab(i == 1);
        forumDetailActivity.getLayoutMode().h(this);
        this.aZR.cT(i);
    }
}
