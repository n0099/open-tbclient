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
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.coreExtra.view.SettingTextSwitchView;
import com.baidu.tbadk.util.m;
import com.baidu.tieba.R;
import com.baidu.tieba.im.settingcache.d;
import tbclient.GetForumDetail.ManagerApplyInfo;
import tbclient.GetForumDetail.ManagerElectionTab;
import tbclient.PriManagerApplyInfo;
import tbclient.RecommendForumInfo;
/* loaded from: classes26.dex */
public class ItemMsgManage extends LinearLayout {
    private SettingTextSwitchView jMe;
    private RelativeLayout jMf;
    private RelativeLayout jMg;
    private RelativeLayout jMh;
    private RelativeLayout jMi;
    private TextView jMj;
    private RelativeLayout jMk;
    private RelativeLayout jMl;
    private TextView jMm;

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
        this.jMe = (SettingTextSwitchView) findViewById(R.id.bar_notify);
        this.jMe.setTextLeftMargin(R.dimen.ds20);
        this.jMf = (RelativeLayout) findViewById(R.id.bar_info_clean_lay);
        this.jMg = (RelativeLayout) findViewById(R.id.bar_info_history_lay);
        this.jMh = (RelativeLayout) findViewById(R.id.bar_info_member_lay);
        this.jMi = (RelativeLayout) findViewById(R.id.bar_info_manager_lay);
        this.jMj = (TextView) findViewById(R.id.bar_info_member_status);
        this.jMk = (RelativeLayout) findViewById(R.id.bar_info_complaint_lay);
        this.jMl = (RelativeLayout) findViewById(R.id.bar_manager_apply_lay);
        this.jMm = (TextView) findViewById(R.id.bar_manager_apply_status);
        setVisibility(8);
    }

    public void setData(RecommendForumInfo recommendForumInfo, boolean z, boolean z2, ManagerApplyInfo managerApplyInfo, PriManagerApplyInfo priManagerApplyInfo, ManagerElectionTab managerElectionTab) {
        boolean z3 = recommendForumInfo.is_private_forum.intValue() != 0;
        setShowState(recommendForumInfo);
        if (!TbadkApplication.isLogin()) {
            setVisibility(8);
        } else {
            this.jMk.setVisibility(z2 ? 0 : 8);
            if (recommendForumInfo.is_like.intValue() == 0) {
                this.jMe.setVisibility(8);
                this.jMf.setVisibility(8);
                this.jMg.setVisibility(8);
                this.jMk.setVisibility(8);
            }
            this.jMi.setVisibility(z ? 0 : 8);
            findViewById(R.id.bar_info_manager_divider).setVisibility(z ? 0 : 8);
            if (managerElectionTab != null) {
                if (managerElectionTab.is_new_strategy.intValue() == 1) {
                    this.jMl.setVisibility(0);
                    this.jMm.setText(managerElectionTab.new_strategy_text);
                } else {
                    this.jMl.setVisibility(8);
                }
            }
            setVisibility(0);
        }
        if (z3) {
            if (priManagerApplyInfo != null) {
                int intValue = priManagerApplyInfo.assist_apply_status.intValue();
                int intValue2 = priManagerApplyInfo.assist_left_num.intValue();
                this.jMj.setVisibility(0);
                if (intValue == -1) {
                    String format = String.format(getResources().getString(R.string.forum_detail_private_apply_left_num_tip), at.numberUniformFormat(intValue2));
                    if (intValue2 > 0) {
                        this.jMj.setText(format);
                    } else {
                        this.jMj.setVisibility(8);
                    }
                } else if (intValue == 1) {
                    this.jMj.setText(getResources().getString(R.string.forum_detail_private_applying));
                } else if (intValue == 2) {
                    this.jMj.setText(getResources().getString(R.string.forum_detail_private_apply_failed));
                } else {
                    this.jMj.setVisibility(8);
                }
            }
        } else {
            this.jMj.setVisibility(8);
        }
        d.cPy().a(TbadkApplication.getCurrentAccount(), String.valueOf(recommendForumInfo.forum_id), new m<Boolean>() { // from class: com.baidu.tieba.im.forum.detail.ItemMsgManage.1
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
                this.jMe.setVisibility(8);
                this.jMf.setVisibility(8);
                this.jMg.setVisibility(8);
            } else if (intValue == 1) {
                setVisibility(0);
                this.jMe.setVisibility(0);
                this.jMf.setVisibility(0);
                this.jMg.setVisibility(0);
            } else if (intValue == 2) {
                this.jMg.setVisibility(8);
                this.jMf.setVisibility(0);
                this.jMe.setVisibility(0);
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
            this.jMe.getSwitchView().turnOnNoCallback();
        } else {
            this.jMe.getSwitchView().turnOffNoCallback();
        }
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
    }

    public void setMsgOnClickListener(View.OnClickListener onClickListener) {
        this.jMf.setOnClickListener(onClickListener);
        this.jMg.setOnClickListener(onClickListener);
        this.jMh.setOnClickListener(onClickListener);
        this.jMi.setOnClickListener(onClickListener);
        this.jMk.setOnClickListener(onClickListener);
        this.jMl.setOnClickListener(onClickListener);
    }

    public void setSwitchChangeListener(BdSwitchView.a aVar) {
        this.jMe.setSwitchStateChangeListener(aVar);
    }

    public void a(ForumDetailActivity forumDetailActivity, int i) {
        forumDetailActivity.getLayoutMode().setNightMode(i == 1);
        forumDetailActivity.getLayoutMode().onModeChanged(this);
        this.jMe.qE(i);
    }
}
