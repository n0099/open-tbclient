package com.baidu.tieba.im.forum.detail;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.coreExtra.view.SettingTextSwitchView;
import com.baidu.tbadk.util.h;
import com.baidu.tieba.e;
import com.baidu.tieba.im.settingcache.d;
import tbclient.ManagerApplyInfo;
import tbclient.RecommendForumInfo;
/* loaded from: classes3.dex */
public class ItemMsgManage extends LinearLayout {
    private SettingTextSwitchView eyS;
    private RelativeLayout eyT;
    private RelativeLayout eyU;
    private RelativeLayout eyV;
    private RelativeLayout eyW;
    private TextView eyX;

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
        LayoutInflater.from(context).inflate(e.h.forum_detail_msg_manage, (ViewGroup) this, true);
        this.eyS = (SettingTextSwitchView) findViewById(e.g.bar_notify);
        this.eyS.setTextLeftMargin(e.C0141e.ds20);
        this.eyT = (RelativeLayout) findViewById(e.g.bar_info_clean_lay);
        this.eyU = (RelativeLayout) findViewById(e.g.bar_info_history_lay);
        this.eyV = (RelativeLayout) findViewById(e.g.bar_info_member_lay);
        this.eyW = (RelativeLayout) findViewById(e.g.bar_info_manager_lay);
        this.eyX = (TextView) findViewById(e.g.bar_info_member_status);
        setVisibility(8);
    }

    public void setData(RecommendForumInfo recommendForumInfo, boolean z, ManagerApplyInfo managerApplyInfo) {
        setShowState(recommendForumInfo);
        if (!TbadkApplication.isLogin()) {
            setVisibility(8);
        } else {
            if (recommendForumInfo.is_like.intValue() == 0) {
                this.eyS.setVisibility(8);
                this.eyT.setVisibility(8);
                this.eyU.setVisibility(8);
            }
            this.eyW.setVisibility(z ? 0 : 8);
            findViewById(e.g.bar_info_manager_divider).setVisibility(z ? 0 : 8);
            setVisibility(0);
        }
        if (managerApplyInfo != null) {
            this.eyX.setVisibility(0);
            if (managerApplyInfo.manager_apply_status.intValue() == -1) {
                String format = String.format(getResources().getString(e.j.forum_detail_apply_left_num_tip), ao.E(managerApplyInfo.manager_left_num.intValue()));
                if (managerApplyInfo.manager_left_num.intValue() > 0) {
                    this.eyX.setText(format);
                } else {
                    this.eyX.setVisibility(8);
                }
            } else if (managerApplyInfo.manager_apply_status.intValue() == 1) {
                this.eyX.setText(getResources().getString(e.j.forum_detail_applying));
            } else if (managerApplyInfo.manager_apply_status.intValue() == 2) {
                this.eyX.setText(getResources().getString(e.j.forum_detail_apply_failed));
            } else {
                this.eyX.setVisibility(8);
            }
        }
        d.aPH().a(TbadkApplication.getCurrentAccount(), String.valueOf(recommendForumInfo.forum_id), new h<Boolean>() { // from class: com.baidu.tieba.im.forum.detail.ItemMsgManage.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.h
            public void onReturnDataInUI(Boolean bool) {
                if (bool != null) {
                    ItemMsgManage.this.setSwitch(bool.booleanValue());
                }
            }
        });
    }

    private void setShowState(RecommendForumInfo recommendForumInfo) {
        if (recommendForumInfo != null) {
            int intValue = recommendForumInfo.forum_type.intValue();
            if (intValue == 0) {
                this.eyS.setVisibility(8);
                this.eyT.setVisibility(8);
                this.eyU.setVisibility(8);
            } else if (intValue == 1) {
                setVisibility(0);
                this.eyS.setVisibility(0);
                this.eyT.setVisibility(0);
                this.eyU.setVisibility(0);
            } else if (intValue == 2) {
                this.eyU.setVisibility(8);
                this.eyT.setVisibility(0);
                this.eyS.setVisibility(0);
                setVisibility(0);
            }
        }
    }

    public void setShowState(RecommendForumInfo recommendForumInfo, boolean z) {
        setShowState(recommendForumInfo);
        if (!z) {
            setVisibility(8);
        }
    }

    public void setSwitch(boolean z) {
        if (z) {
            this.eyS.getSwitchView().nI();
        } else {
            this.eyS.getSwitchView().nJ();
        }
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
    }

    public void setMsgOnClickListener(View.OnClickListener onClickListener) {
        this.eyT.setOnClickListener(onClickListener);
        this.eyU.setOnClickListener(onClickListener);
        this.eyV.setOnClickListener(onClickListener);
        this.eyW.setOnClickListener(onClickListener);
    }

    public void setSwitchChangeListener(BdSwitchView.a aVar) {
        this.eyS.setSwitchStateChangeListener(aVar);
    }

    public void a(ForumDetailActivity forumDetailActivity, int i) {
        forumDetailActivity.getLayoutMode().setNightMode(i == 1);
        forumDetailActivity.getLayoutMode().onModeChanged(this);
        this.eyS.eJ(i);
    }
}
