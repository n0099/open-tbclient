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
import com.baidu.tbadk.util.l;
import com.baidu.tieba.R;
import com.baidu.tieba.im.settingcache.d;
import tbclient.GetForumDetail.ManagerApplyInfo;
import tbclient.GetForumDetail.ManagerElectionTab;
import tbclient.PriManagerApplyInfo;
import tbclient.RecommendForumInfo;
/* loaded from: classes8.dex */
public class ItemMsgManage extends LinearLayout {
    private RelativeLayout kDA;
    private RelativeLayout kDB;
    private RelativeLayout kDC;
    private RelativeLayout kDD;
    private TextView kDE;
    private RelativeLayout kDF;
    private RelativeLayout kDG;
    private TextView kDH;
    private SettingTextSwitchView kDz;

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
        this.kDz = (SettingTextSwitchView) findViewById(R.id.bar_notify);
        this.kDz.setTextLeftMargin(R.dimen.ds20);
        this.kDA = (RelativeLayout) findViewById(R.id.bar_info_clean_lay);
        this.kDB = (RelativeLayout) findViewById(R.id.bar_info_history_lay);
        this.kDC = (RelativeLayout) findViewById(R.id.bar_info_member_lay);
        this.kDD = (RelativeLayout) findViewById(R.id.bar_info_manager_lay);
        this.kDE = (TextView) findViewById(R.id.bar_info_member_status);
        this.kDF = (RelativeLayout) findViewById(R.id.bar_info_complaint_lay);
        this.kDG = (RelativeLayout) findViewById(R.id.bar_manager_apply_lay);
        this.kDH = (TextView) findViewById(R.id.bar_manager_apply_status);
        setVisibility(8);
    }

    public void setData(RecommendForumInfo recommendForumInfo, boolean z, boolean z2, ManagerApplyInfo managerApplyInfo, PriManagerApplyInfo priManagerApplyInfo, ManagerElectionTab managerElectionTab) {
        boolean z3 = recommendForumInfo.is_private_forum.intValue() != 0;
        setShowState(recommendForumInfo);
        if (!TbadkApplication.isLogin()) {
            setVisibility(8);
        } else {
            this.kDF.setVisibility(z2 ? 0 : 8);
            if (recommendForumInfo.is_like.intValue() == 0) {
                this.kDz.setVisibility(8);
                this.kDA.setVisibility(8);
                this.kDB.setVisibility(8);
                this.kDF.setVisibility(8);
            }
            this.kDD.setVisibility(z ? 0 : 8);
            findViewById(R.id.bar_info_manager_divider).setVisibility(z ? 0 : 8);
            if (managerElectionTab != null) {
                if (managerElectionTab.is_new_strategy.intValue() == 1) {
                    this.kDG.setVisibility(0);
                    this.kDH.setText(managerElectionTab.new_strategy_text);
                } else {
                    this.kDG.setVisibility(8);
                }
            }
            setVisibility(0);
        }
        if (z3) {
            if (priManagerApplyInfo != null) {
                int intValue = priManagerApplyInfo.assist_apply_status.intValue();
                int intValue2 = priManagerApplyInfo.assist_left_num.intValue();
                this.kDE.setVisibility(0);
                if (intValue == -1) {
                    String format = String.format(getResources().getString(R.string.forum_detail_private_apply_left_num_tip), at.numberUniformFormat(intValue2));
                    if (intValue2 > 0) {
                        this.kDE.setText(format);
                    } else {
                        this.kDE.setVisibility(8);
                    }
                } else if (intValue == 1) {
                    this.kDE.setText(getResources().getString(R.string.forum_detail_private_applying));
                } else if (intValue == 2) {
                    this.kDE.setText(getResources().getString(R.string.forum_detail_private_apply_failed));
                } else {
                    this.kDE.setVisibility(8);
                }
            }
        } else {
            this.kDE.setVisibility(8);
        }
        d.cZM().a(TbadkApplication.getCurrentAccount(), String.valueOf(recommendForumInfo.forum_id), new l<Boolean>() { // from class: com.baidu.tieba.im.forum.detail.ItemMsgManage.1
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
                this.kDz.setVisibility(8);
                this.kDA.setVisibility(8);
                this.kDB.setVisibility(8);
            } else if (intValue == 1) {
                setVisibility(0);
                this.kDz.setVisibility(0);
                this.kDA.setVisibility(0);
                this.kDB.setVisibility(0);
            } else if (intValue == 2) {
                this.kDB.setVisibility(8);
                this.kDA.setVisibility(0);
                this.kDz.setVisibility(0);
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
            this.kDz.getSwitchView().turnOnNoCallback();
        } else {
            this.kDz.getSwitchView().turnOffNoCallback();
        }
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
    }

    public void setMsgOnClickListener(View.OnClickListener onClickListener) {
        this.kDA.setOnClickListener(onClickListener);
        this.kDB.setOnClickListener(onClickListener);
        this.kDC.setOnClickListener(onClickListener);
        this.kDD.setOnClickListener(onClickListener);
        this.kDF.setOnClickListener(onClickListener);
        this.kDG.setOnClickListener(onClickListener);
    }

    public void setSwitchChangeListener(BdSwitchView.a aVar) {
        this.kDz.setSwitchStateChangeListener(aVar);
    }

    public void a(ForumDetailActivity forumDetailActivity, int i) {
        forumDetailActivity.getLayoutMode().setNightMode(i == 1);
        forumDetailActivity.getLayoutMode().onModeChanged(this);
        this.kDz.sk(i);
    }
}
