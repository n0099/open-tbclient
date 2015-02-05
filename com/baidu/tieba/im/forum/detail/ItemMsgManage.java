package com.baidu.tieba.im.forum.detail;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.coreExtra.view.SettingTextSwitchView;
import tbclient.RecommendForumInfo;
/* loaded from: classes.dex */
public class ItemMsgManage extends LinearLayout {
    private SettingTextSwitchView bbn;
    private RelativeLayout bbo;
    private RelativeLayout bbp;

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
        com.baidu.adp.lib.g.b.ei().a(context, com.baidu.tieba.x.forum_detail_msg_manage, this, true);
        setVisibility(8);
        this.bbn = (SettingTextSwitchView) findViewById(com.baidu.tieba.w.bar_notify);
        this.bbo = (RelativeLayout) findViewById(com.baidu.tieba.w.bar_info_clean_lay);
        this.bbp = (RelativeLayout) findViewById(com.baidu.tieba.w.bar_info_history_lay);
    }

    public void setData(RecommendForumInfo recommendForumInfo) {
        setShowState(recommendForumInfo);
        if (recommendForumInfo.is_like.intValue() == 0) {
            setVisibility(8);
        }
        com.baidu.tieba.im.settingcache.h.To().a(TbadkApplication.getCurrentAccount(), String.valueOf(recommendForumInfo.forum_id), new y(this));
    }

    private void setShowState(RecommendForumInfo recommendForumInfo) {
        if (recommendForumInfo != null) {
            int intValue = recommendForumInfo.forum_type.intValue();
            if (intValue == 0) {
                setVisibility(8);
            } else if (intValue == 1) {
                setVisibility(0);
            } else if (intValue == 2) {
                this.bbp.setVisibility(8);
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
            this.bbn.getSwitchView().iC();
        } else {
            this.bbn.getSwitchView().iD();
        }
    }

    public void setMsgOnClickListener(View.OnClickListener onClickListener) {
        this.bbo.setOnClickListener(onClickListener);
        this.bbp.setOnClickListener(onClickListener);
    }

    public void setSwitchChangeListener(com.baidu.adp.widget.BdSwitchView.c cVar) {
        this.bbn.setSwitchStateChangeListener(cVar);
    }

    public void a(ForumDetailActivity forumDetailActivity, int i) {
        forumDetailActivity.getLayoutMode().ab(i == 1);
        forumDetailActivity.getLayoutMode().h(this);
        this.bbn.da(i);
    }
}
