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
import com.baidu.tbadk.util.g;
import com.baidu.tieba.f;
import com.baidu.tieba.im.settingcache.d;
import tbclient.ManagerApplyInfo;
import tbclient.RecommendForumInfo;
/* loaded from: classes3.dex */
public class ItemMsgManage extends LinearLayout {
    private RelativeLayout erA;
    private RelativeLayout erB;
    private RelativeLayout erC;
    private TextView erD;
    private SettingTextSwitchView ery;
    private RelativeLayout erz;

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
        LayoutInflater.from(context).inflate(f.h.forum_detail_msg_manage, (ViewGroup) this, true);
        this.ery = (SettingTextSwitchView) findViewById(f.g.bar_notify);
        this.ery.setTextLeftMargin(f.e.ds20);
        this.erz = (RelativeLayout) findViewById(f.g.bar_info_clean_lay);
        this.erA = (RelativeLayout) findViewById(f.g.bar_info_history_lay);
        this.erB = (RelativeLayout) findViewById(f.g.bar_info_member_lay);
        this.erC = (RelativeLayout) findViewById(f.g.bar_info_manager_lay);
        this.erD = (TextView) findViewById(f.g.bar_info_member_status);
        setVisibility(8);
    }

    public void setData(RecommendForumInfo recommendForumInfo, boolean z, ManagerApplyInfo managerApplyInfo) {
        setShowState(recommendForumInfo);
        if (!TbadkApplication.isLogin()) {
            setVisibility(8);
        } else {
            if (recommendForumInfo.is_like.intValue() == 0) {
                this.ery.setVisibility(8);
                this.erz.setVisibility(8);
                this.erA.setVisibility(8);
            }
            this.erC.setVisibility(z ? 0 : 8);
            findViewById(f.g.bar_info_manager_divider).setVisibility(z ? 0 : 8);
            setVisibility(0);
        }
        if (managerApplyInfo != null) {
            this.erD.setVisibility(0);
            if (managerApplyInfo.manager_apply_status.intValue() == -1) {
                String format = String.format(getResources().getString(f.j.forum_detail_apply_left_num_tip), ap.A(managerApplyInfo.manager_left_num.intValue()));
                if (managerApplyInfo.manager_left_num.intValue() > 0) {
                    this.erD.setText(format);
                } else {
                    this.erD.setVisibility(8);
                }
            } else if (managerApplyInfo.manager_apply_status.intValue() == 1) {
                this.erD.setText(getResources().getString(f.j.forum_detail_applying));
            } else if (managerApplyInfo.manager_apply_status.intValue() == 2) {
                this.erD.setText(getResources().getString(f.j.forum_detail_apply_failed));
            } else {
                this.erD.setVisibility(8);
            }
        }
        d.aNs().a(TbadkApplication.getCurrentAccount(), String.valueOf(recommendForumInfo.forum_id), new g<Boolean>() { // from class: com.baidu.tieba.im.forum.detail.ItemMsgManage.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.g
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
                this.ery.setVisibility(8);
                this.erz.setVisibility(8);
                this.erA.setVisibility(8);
            } else if (intValue == 1) {
                setVisibility(0);
                this.ery.setVisibility(0);
                this.erz.setVisibility(0);
                this.erA.setVisibility(0);
            } else if (intValue == 2) {
                this.erA.setVisibility(8);
                this.erz.setVisibility(0);
                this.ery.setVisibility(0);
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
            this.ery.getSwitchView().mC();
        } else {
            this.ery.getSwitchView().mD();
        }
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
    }

    public void setMsgOnClickListener(View.OnClickListener onClickListener) {
        this.erz.setOnClickListener(onClickListener);
        this.erA.setOnClickListener(onClickListener);
        this.erB.setOnClickListener(onClickListener);
        this.erC.setOnClickListener(onClickListener);
    }

    public void setSwitchChangeListener(BdSwitchView.a aVar) {
        this.ery.setSwitchStateChangeListener(aVar);
    }

    public void a(ForumDetailActivity forumDetailActivity, int i) {
        forumDetailActivity.getLayoutMode().setNightMode(i == 1);
        forumDetailActivity.getLayoutMode().onModeChanged(this);
        this.ery.ex(i);
    }
}
