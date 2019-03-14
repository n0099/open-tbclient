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
import com.baidu.tbadk.util.k;
import com.baidu.tieba.d;
import tbclient.ManagerApplyInfo;
import tbclient.PriManagerApplyInfo;
import tbclient.RecommendForumInfo;
/* loaded from: classes3.dex */
public class ItemMsgManage extends LinearLayout {
    private TextView giA;
    private RelativeLayout giB;
    private SettingTextSwitchView giv;
    private RelativeLayout giw;
    private RelativeLayout gix;
    private RelativeLayout giy;
    private RelativeLayout giz;

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
        LayoutInflater.from(context).inflate(d.h.forum_detail_msg_manage, (ViewGroup) this, true);
        this.giv = (SettingTextSwitchView) findViewById(d.g.bar_notify);
        this.giv.setTextLeftMargin(d.e.ds20);
        this.giw = (RelativeLayout) findViewById(d.g.bar_info_clean_lay);
        this.gix = (RelativeLayout) findViewById(d.g.bar_info_history_lay);
        this.giy = (RelativeLayout) findViewById(d.g.bar_info_member_lay);
        this.giz = (RelativeLayout) findViewById(d.g.bar_info_manager_lay);
        this.giA = (TextView) findViewById(d.g.bar_info_member_status);
        this.giB = (RelativeLayout) findViewById(d.g.bar_info_complaint_lay);
        setVisibility(8);
    }

    public void setData(RecommendForumInfo recommendForumInfo, boolean z, boolean z2, ManagerApplyInfo managerApplyInfo, PriManagerApplyInfo priManagerApplyInfo) {
        boolean z3 = recommendForumInfo.is_private_forum.intValue() != 0;
        setShowState(recommendForumInfo);
        if (!TbadkApplication.isLogin()) {
            setVisibility(8);
        } else {
            this.giB.setVisibility(z2 ? 0 : 8);
            if (recommendForumInfo.is_like.intValue() == 0) {
                this.giv.setVisibility(8);
                this.giw.setVisibility(8);
                this.gix.setVisibility(8);
                this.giB.setVisibility(8);
            }
            this.giz.setVisibility(z ? 0 : 8);
            findViewById(d.g.bar_info_manager_divider).setVisibility(z ? 0 : 8);
            setVisibility(0);
        }
        if (z3) {
            if (priManagerApplyInfo != null) {
                int intValue = priManagerApplyInfo.assist_apply_status.intValue();
                int intValue2 = priManagerApplyInfo.assist_left_num.intValue();
                this.giA.setVisibility(0);
                if (intValue == -1) {
                    String format = String.format(getResources().getString(d.j.forum_detail_private_apply_left_num_tip), ap.as(intValue2));
                    if (intValue2 > 0) {
                        this.giA.setText(format);
                    } else {
                        this.giA.setVisibility(8);
                    }
                } else if (intValue == 1) {
                    this.giA.setText(getResources().getString(d.j.forum_detail_private_applying));
                } else if (intValue == 2) {
                    this.giA.setText(getResources().getString(d.j.forum_detail_private_apply_failed));
                } else {
                    this.giA.setVisibility(8);
                }
            }
        } else if (managerApplyInfo != null) {
            this.giA.setVisibility(0);
            if (managerApplyInfo.manager_apply_status.intValue() == -1) {
                String format2 = String.format(getResources().getString(d.j.forum_detail_apply_left_num_tip), ap.as(managerApplyInfo.manager_left_num.intValue()));
                if (managerApplyInfo.manager_left_num.intValue() > 0) {
                    this.giA.setText(format2);
                } else {
                    this.giA.setVisibility(8);
                }
            } else if (managerApplyInfo.manager_apply_status.intValue() == 1) {
                this.giA.setText(getResources().getString(d.j.forum_detail_applying));
            } else if (managerApplyInfo.manager_apply_status.intValue() == 2) {
                this.giA.setText(getResources().getString(d.j.forum_detail_apply_failed));
            } else {
                this.giA.setVisibility(8);
            }
        }
        com.baidu.tieba.im.settingcache.d.bwc().a(TbadkApplication.getCurrentAccount(), String.valueOf(recommendForumInfo.forum_id), new k<Boolean>() { // from class: com.baidu.tieba.im.forum.detail.ItemMsgManage.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.k
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
                this.giv.setVisibility(8);
                this.giw.setVisibility(8);
                this.gix.setVisibility(8);
            } else if (intValue == 1) {
                setVisibility(0);
                this.giv.setVisibility(0);
                this.giw.setVisibility(0);
                this.gix.setVisibility(0);
            } else if (intValue == 2) {
                this.gix.setVisibility(8);
                this.giw.setVisibility(0);
                this.giv.setVisibility(0);
                setVisibility(0);
            }
        }
    }

    public void setShowState(RecommendForumInfo recommendForumInfo, boolean z) {
        setShowState(recommendForumInfo);
        if (!z) {
            setVisibility(8);
        } else {
            setVisibility(0);
        }
    }

    public void setSwitch(boolean z) {
        if (z) {
            this.giv.getSwitchView().nY();
        } else {
            this.giv.getSwitchView().nZ();
        }
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
    }

    public void setMsgOnClickListener(View.OnClickListener onClickListener) {
        this.giw.setOnClickListener(onClickListener);
        this.gix.setOnClickListener(onClickListener);
        this.giy.setOnClickListener(onClickListener);
        this.giz.setOnClickListener(onClickListener);
        this.giB.setOnClickListener(onClickListener);
    }

    public void setSwitchChangeListener(BdSwitchView.a aVar) {
        this.giv.setSwitchStateChangeListener(aVar);
    }

    public void a(ForumDetailActivity forumDetailActivity, int i) {
        forumDetailActivity.getLayoutMode().setNightMode(i == 1);
        forumDetailActivity.getLayoutMode().onModeChanged(this);
        this.giv.jg(i);
    }
}
