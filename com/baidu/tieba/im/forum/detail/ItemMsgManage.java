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
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.coreExtra.view.SettingTextSwitchView;
import com.baidu.tbadk.util.m;
import com.baidu.tieba.R;
import com.baidu.tieba.im.settingcache.d;
import tbclient.GetForumDetail.ManagerApplyInfo;
import tbclient.GetForumDetail.ManagerElectionTab;
import tbclient.PriManagerApplyInfo;
import tbclient.RecommendForumInfo;
/* loaded from: classes7.dex */
public class ItemMsgManage extends LinearLayout {
    private SettingTextSwitchView kJp;
    private RelativeLayout kJq;
    private RelativeLayout kJr;
    private RelativeLayout kJs;
    private RelativeLayout kJt;
    private TextView kJu;
    private RelativeLayout kJv;
    private RelativeLayout kJw;
    private TextView kJx;

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
        this.kJp = (SettingTextSwitchView) findViewById(R.id.bar_notify);
        this.kJp.setTextLeftMargin(R.dimen.ds20);
        this.kJq = (RelativeLayout) findViewById(R.id.bar_info_clean_lay);
        this.kJr = (RelativeLayout) findViewById(R.id.bar_info_history_lay);
        this.kJs = (RelativeLayout) findViewById(R.id.bar_info_member_lay);
        this.kJt = (RelativeLayout) findViewById(R.id.bar_info_manager_lay);
        this.kJu = (TextView) findViewById(R.id.bar_info_member_status);
        this.kJv = (RelativeLayout) findViewById(R.id.bar_info_complaint_lay);
        this.kJw = (RelativeLayout) findViewById(R.id.bar_manager_apply_lay);
        this.kJx = (TextView) findViewById(R.id.bar_manager_apply_status);
        setVisibility(8);
    }

    public void setData(RecommendForumInfo recommendForumInfo, boolean z, boolean z2, ManagerApplyInfo managerApplyInfo, PriManagerApplyInfo priManagerApplyInfo, ManagerElectionTab managerElectionTab) {
        boolean z3 = recommendForumInfo.is_private_forum.intValue() != 0;
        setShowState(recommendForumInfo);
        if (!TbadkApplication.isLogin()) {
            setVisibility(8);
        } else {
            this.kJv.setVisibility(z2 ? 0 : 8);
            if (recommendForumInfo.is_like.intValue() == 0) {
                this.kJp.setVisibility(8);
                this.kJq.setVisibility(8);
                this.kJr.setVisibility(8);
                this.kJv.setVisibility(8);
            }
            this.kJt.setVisibility(z ? 0 : 8);
            findViewById(R.id.bar_info_manager_divider).setVisibility(z ? 0 : 8);
            if (managerElectionTab != null) {
                if (managerElectionTab.is_new_strategy.intValue() == 1) {
                    this.kJw.setVisibility(0);
                    this.kJx.setText(managerElectionTab.new_strategy_text);
                } else {
                    this.kJw.setVisibility(8);
                }
            }
            setVisibility(0);
        }
        if (z3) {
            if (priManagerApplyInfo != null) {
                int intValue = priManagerApplyInfo.assist_apply_status.intValue();
                int intValue2 = priManagerApplyInfo.assist_left_num.intValue();
                this.kJu.setVisibility(0);
                if (intValue == -1) {
                    String format = String.format(getResources().getString(R.string.forum_detail_private_apply_left_num_tip), au.numberUniformFormat(intValue2));
                    if (intValue2 > 0) {
                        this.kJu.setText(format);
                    } else {
                        this.kJu.setVisibility(8);
                    }
                } else if (intValue == 1) {
                    this.kJu.setText(getResources().getString(R.string.forum_detail_private_applying));
                } else if (intValue == 2) {
                    this.kJu.setText(getResources().getString(R.string.forum_detail_private_apply_failed));
                } else {
                    this.kJu.setVisibility(8);
                }
            }
        } else {
            this.kJu.setVisibility(8);
        }
        d.cYh().a(TbadkApplication.getCurrentAccount(), String.valueOf(recommendForumInfo.forum_id), new m<Boolean>() { // from class: com.baidu.tieba.im.forum.detail.ItemMsgManage.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.m
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
                this.kJp.setVisibility(8);
                this.kJq.setVisibility(8);
                this.kJr.setVisibility(8);
            } else if (intValue == 1) {
                setVisibility(0);
                this.kJp.setVisibility(0);
                this.kJq.setVisibility(0);
                this.kJr.setVisibility(0);
            } else if (intValue == 2) {
                this.kJr.setVisibility(8);
                this.kJq.setVisibility(0);
                this.kJp.setVisibility(0);
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
            this.kJp.getSwitchView().turnOnNoCallback();
        } else {
            this.kJp.getSwitchView().turnOffNoCallback();
        }
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
    }

    public void setMsgOnClickListener(View.OnClickListener onClickListener) {
        this.kJq.setOnClickListener(onClickListener);
        this.kJr.setOnClickListener(onClickListener);
        this.kJs.setOnClickListener(onClickListener);
        this.kJt.setOnClickListener(onClickListener);
        this.kJv.setOnClickListener(onClickListener);
        this.kJw.setOnClickListener(onClickListener);
    }

    public void setSwitchChangeListener(BdSwitchView.a aVar) {
        this.kJp.setSwitchStateChangeListener(aVar);
    }

    public void a(ForumDetailActivity forumDetailActivity, int i) {
        forumDetailActivity.getLayoutMode().setNightMode(i == 1);
        forumDetailActivity.getLayoutMode().onModeChanged(this);
        this.kJp.qK(i);
    }
}
