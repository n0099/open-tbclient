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
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.coreExtra.view.SettingTextSwitchView;
import com.baidu.tbadk.util.l;
import com.baidu.tieba.R;
import com.baidu.tieba.im.settingcache.d;
import tbclient.GetForumDetail.ManagerApplyInfo;
import tbclient.GetForumDetail.ManagerElectionTab;
import tbclient.PriManagerApplyInfo;
import tbclient.RecommendForumInfo;
/* loaded from: classes20.dex */
public class ItemMsgManage extends LinearLayout {
    private RelativeLayout iZA;
    private TextView iZB;
    private RelativeLayout iZC;
    private RelativeLayout iZD;
    private TextView iZE;
    private SettingTextSwitchView iZw;
    private RelativeLayout iZx;
    private RelativeLayout iZy;
    private RelativeLayout iZz;

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
        LayoutInflater.from(context).inflate(R.layout.forum_detail_msg_manage, (ViewGroup) this, true);
        this.iZw = (SettingTextSwitchView) findViewById(R.id.bar_notify);
        this.iZw.setTextLeftMargin(R.dimen.ds20);
        this.iZx = (RelativeLayout) findViewById(R.id.bar_info_clean_lay);
        this.iZy = (RelativeLayout) findViewById(R.id.bar_info_history_lay);
        this.iZz = (RelativeLayout) findViewById(R.id.bar_info_member_lay);
        this.iZA = (RelativeLayout) findViewById(R.id.bar_info_manager_lay);
        this.iZB = (TextView) findViewById(R.id.bar_info_member_status);
        this.iZC = (RelativeLayout) findViewById(R.id.bar_info_complaint_lay);
        this.iZD = (RelativeLayout) findViewById(R.id.bar_manager_apply_lay);
        this.iZE = (TextView) findViewById(R.id.bar_manager_apply_status);
        setVisibility(8);
    }

    public void setData(RecommendForumInfo recommendForumInfo, boolean z, boolean z2, ManagerApplyInfo managerApplyInfo, PriManagerApplyInfo priManagerApplyInfo, ManagerElectionTab managerElectionTab) {
        boolean z3 = recommendForumInfo.is_private_forum.intValue() != 0;
        setShowState(recommendForumInfo);
        if (!TbadkApplication.isLogin()) {
            setVisibility(8);
        } else {
            this.iZC.setVisibility(z2 ? 0 : 8);
            if (recommendForumInfo.is_like.intValue() == 0) {
                this.iZw.setVisibility(8);
                this.iZx.setVisibility(8);
                this.iZy.setVisibility(8);
                this.iZC.setVisibility(8);
            }
            this.iZA.setVisibility(z ? 0 : 8);
            findViewById(R.id.bar_info_manager_divider).setVisibility(z ? 0 : 8);
            if (managerElectionTab != null) {
                if (managerElectionTab.is_new_strategy.intValue() == 1) {
                    this.iZD.setVisibility(0);
                    this.iZE.setText(managerElectionTab.new_strategy_text);
                } else {
                    this.iZD.setVisibility(8);
                }
            }
            setVisibility(0);
        }
        if (z3) {
            if (priManagerApplyInfo != null) {
                int intValue = priManagerApplyInfo.assist_apply_status.intValue();
                int intValue2 = priManagerApplyInfo.assist_left_num.intValue();
                this.iZB.setVisibility(0);
                if (intValue == -1) {
                    String format = String.format(getResources().getString(R.string.forum_detail_private_apply_left_num_tip), as.numberUniformFormat(intValue2));
                    if (intValue2 > 0) {
                        this.iZB.setText(format);
                    } else {
                        this.iZB.setVisibility(8);
                    }
                } else if (intValue == 1) {
                    this.iZB.setText(getResources().getString(R.string.forum_detail_private_applying));
                } else if (intValue == 2) {
                    this.iZB.setText(getResources().getString(R.string.forum_detail_private_apply_failed));
                } else {
                    this.iZB.setVisibility(8);
                }
            }
        } else {
            this.iZB.setVisibility(8);
        }
        d.cxs().a(TbadkApplication.getCurrentAccount(), String.valueOf(recommendForumInfo.forum_id), new l<Boolean>() { // from class: com.baidu.tieba.im.forum.detail.ItemMsgManage.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.l
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
                this.iZw.setVisibility(8);
                this.iZx.setVisibility(8);
                this.iZy.setVisibility(8);
            } else if (intValue == 1) {
                setVisibility(0);
                this.iZw.setVisibility(0);
                this.iZx.setVisibility(0);
                this.iZy.setVisibility(0);
            } else if (intValue == 2) {
                this.iZy.setVisibility(8);
                this.iZx.setVisibility(0);
                this.iZw.setVisibility(0);
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
            this.iZw.getSwitchView().turnOnNoCallback();
        } else {
            this.iZw.getSwitchView().turnOffNoCallback();
        }
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
    }

    public void setMsgOnClickListener(View.OnClickListener onClickListener) {
        this.iZx.setOnClickListener(onClickListener);
        this.iZy.setOnClickListener(onClickListener);
        this.iZz.setOnClickListener(onClickListener);
        this.iZA.setOnClickListener(onClickListener);
        this.iZC.setOnClickListener(onClickListener);
        this.iZD.setOnClickListener(onClickListener);
    }

    public void setSwitchChangeListener(BdSwitchView.a aVar) {
        this.iZw.setSwitchStateChangeListener(aVar);
    }

    public void a(ForumDetailActivity forumDetailActivity, int i) {
        forumDetailActivity.getLayoutMode().setNightMode(i == 1);
        forumDetailActivity.getLayoutMode().onModeChanged(this);
        this.iZw.nI(i);
    }
}
