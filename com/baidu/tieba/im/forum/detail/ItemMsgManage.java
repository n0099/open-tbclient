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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.coreExtra.view.SettingTextSwitchView;
import com.baidu.tbadk.util.h;
import com.baidu.tieba.d;
import tbclient.ManagerApplyInfo;
import tbclient.RecommendForumInfo;
/* loaded from: classes3.dex */
public class ItemMsgManage extends LinearLayout {
    private SettingTextSwitchView enJ;
    private RelativeLayout enK;
    private RelativeLayout enL;
    private RelativeLayout enM;
    private RelativeLayout enN;
    private TextView enO;

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
        LayoutInflater.from(context).inflate(d.i.forum_detail_msg_manage, (ViewGroup) this, true);
        this.enJ = (SettingTextSwitchView) findViewById(d.g.bar_notify);
        this.enJ.setTextLeftMargin(d.e.ds20);
        this.enK = (RelativeLayout) findViewById(d.g.bar_info_clean_lay);
        this.enL = (RelativeLayout) findViewById(d.g.bar_info_history_lay);
        this.enM = (RelativeLayout) findViewById(d.g.bar_info_member_lay);
        this.enN = (RelativeLayout) findViewById(d.g.bar_info_manager_lay);
        this.enO = (TextView) findViewById(d.g.bar_info_member_status);
        setVisibility(8);
    }

    public void setData(RecommendForumInfo recommendForumInfo, boolean z, ManagerApplyInfo managerApplyInfo) {
        setShowState(recommendForumInfo);
        if (!TbadkApplication.isLogin()) {
            setVisibility(8);
        } else {
            if (recommendForumInfo.is_like.intValue() == 0) {
                this.enJ.setVisibility(8);
                this.enK.setVisibility(8);
                this.enL.setVisibility(8);
            }
            this.enN.setVisibility(z ? 0 : 8);
            findViewById(d.g.bar_info_manager_divider).setVisibility(z ? 0 : 8);
            setVisibility(0);
        }
        if (managerApplyInfo != null) {
            this.enO.setVisibility(0);
            if (managerApplyInfo.manager_apply_status.intValue() == -1) {
                String format = String.format(getResources().getString(d.k.forum_detail_apply_left_num_tip), ap.z(managerApplyInfo.manager_left_num.intValue()));
                if (managerApplyInfo.manager_left_num.intValue() > 0) {
                    this.enO.setText(format);
                } else {
                    this.enO.setVisibility(8);
                }
            } else if (managerApplyInfo.manager_apply_status.intValue() == 1) {
                this.enO.setText(getResources().getString(d.k.forum_detail_applying));
            } else if (managerApplyInfo.manager_apply_status.intValue() == 2) {
                this.enO.setText(getResources().getString(d.k.forum_detail_apply_failed));
            } else {
                this.enO.setVisibility(8);
            }
        }
        com.baidu.tieba.im.settingcache.d.aMv().a(TbadkApplication.getCurrentAccount(), String.valueOf(recommendForumInfo.forum_id), new h<Boolean>() { // from class: com.baidu.tieba.im.forum.detail.ItemMsgManage.1
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
                this.enJ.setVisibility(8);
                this.enK.setVisibility(8);
                this.enL.setVisibility(8);
            } else if (intValue == 1) {
                setVisibility(0);
                this.enJ.setVisibility(0);
                this.enK.setVisibility(0);
                this.enL.setVisibility(0);
            } else if (intValue == 2) {
                this.enL.setVisibility(8);
                this.enK.setVisibility(0);
                this.enJ.setVisibility(0);
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
            this.enJ.getSwitchView().mA();
        } else {
            this.enJ.getSwitchView().mB();
        }
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
    }

    public void setMsgOnClickListener(View.OnClickListener onClickListener) {
        this.enK.setOnClickListener(onClickListener);
        this.enL.setOnClickListener(onClickListener);
        this.enM.setOnClickListener(onClickListener);
        this.enN.setOnClickListener(onClickListener);
    }

    public void setSwitchChangeListener(BdSwitchView.a aVar) {
        this.enJ.setSwitchStateChangeListener(aVar);
    }

    public void a(ForumDetailActivity forumDetailActivity, int i) {
        forumDetailActivity.getLayoutMode().setNightMode(i == 1);
        forumDetailActivity.getLayoutMode().onModeChanged(this);
        this.enJ.ev(i);
    }
}
