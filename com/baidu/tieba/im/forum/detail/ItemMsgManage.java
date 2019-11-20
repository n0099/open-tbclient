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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.coreExtra.view.SettingTextSwitchView;
import com.baidu.tbadk.util.j;
import com.baidu.tieba.R;
import com.baidu.tieba.im.settingcache.d;
import tbclient.GetForumDetail.ManagerApplyInfo;
import tbclient.GetForumDetail.ManagerElectionTab;
import tbclient.PriManagerApplyInfo;
import tbclient.RecommendForumInfo;
/* loaded from: classes3.dex */
public class ItemMsgManage extends LinearLayout {
    private RelativeLayout gFA;
    private RelativeLayout gFB;
    private RelativeLayout gFC;
    private TextView gFD;
    private RelativeLayout gFE;
    private RelativeLayout gFF;
    private TextView gFG;
    private SettingTextSwitchView gFy;
    private RelativeLayout gFz;

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
        this.gFy = (SettingTextSwitchView) findViewById(R.id.bar_notify);
        this.gFy.setTextLeftMargin(R.dimen.ds20);
        this.gFz = (RelativeLayout) findViewById(R.id.bar_info_clean_lay);
        this.gFA = (RelativeLayout) findViewById(R.id.bar_info_history_lay);
        this.gFB = (RelativeLayout) findViewById(R.id.bar_info_member_lay);
        this.gFC = (RelativeLayout) findViewById(R.id.bar_info_manager_lay);
        this.gFD = (TextView) findViewById(R.id.bar_info_member_status);
        this.gFE = (RelativeLayout) findViewById(R.id.bar_info_complaint_lay);
        this.gFF = (RelativeLayout) findViewById(R.id.bar_manager_apply_lay);
        this.gFG = (TextView) findViewById(R.id.bar_manager_apply_status);
        setVisibility(8);
    }

    public void setData(RecommendForumInfo recommendForumInfo, boolean z, boolean z2, ManagerApplyInfo managerApplyInfo, PriManagerApplyInfo priManagerApplyInfo, ManagerElectionTab managerElectionTab) {
        boolean z3 = recommendForumInfo.is_private_forum.intValue() != 0;
        setShowState(recommendForumInfo);
        if (!TbadkApplication.isLogin()) {
            setVisibility(8);
        } else {
            this.gFE.setVisibility(z2 ? 0 : 8);
            if (recommendForumInfo.is_like.intValue() == 0) {
                this.gFy.setVisibility(8);
                this.gFz.setVisibility(8);
                this.gFA.setVisibility(8);
                this.gFE.setVisibility(8);
            }
            this.gFC.setVisibility(z ? 0 : 8);
            findViewById(R.id.bar_info_manager_divider).setVisibility(z ? 0 : 8);
            if (managerElectionTab != null) {
                if (managerElectionTab.is_new_strategy.intValue() == 1) {
                    this.gFF.setVisibility(0);
                    this.gFG.setText(managerElectionTab.new_strategy_text);
                } else {
                    this.gFF.setVisibility(8);
                }
            }
            setVisibility(0);
        }
        if (z3) {
            if (priManagerApplyInfo != null) {
                int intValue = priManagerApplyInfo.assist_apply_status.intValue();
                int intValue2 = priManagerApplyInfo.assist_left_num.intValue();
                this.gFD.setVisibility(0);
                if (intValue == -1) {
                    String format = String.format(getResources().getString(R.string.forum_detail_private_apply_left_num_tip), aq.numberUniformFormat(intValue2));
                    if (intValue2 > 0) {
                        this.gFD.setText(format);
                    } else {
                        this.gFD.setVisibility(8);
                    }
                } else if (intValue == 1) {
                    this.gFD.setText(getResources().getString(R.string.forum_detail_private_applying));
                } else if (intValue == 2) {
                    this.gFD.setText(getResources().getString(R.string.forum_detail_private_apply_failed));
                } else {
                    this.gFD.setVisibility(8);
                }
            }
        } else {
            this.gFD.setVisibility(8);
        }
        d.bEd().a(TbadkApplication.getCurrentAccount(), String.valueOf(recommendForumInfo.forum_id), new j<Boolean>() { // from class: com.baidu.tieba.im.forum.detail.ItemMsgManage.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.j
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
                this.gFy.setVisibility(8);
                this.gFz.setVisibility(8);
                this.gFA.setVisibility(8);
            } else if (intValue == 1) {
                setVisibility(0);
                this.gFy.setVisibility(0);
                this.gFz.setVisibility(0);
                this.gFA.setVisibility(0);
            } else if (intValue == 2) {
                this.gFA.setVisibility(8);
                this.gFz.setVisibility(0);
                this.gFy.setVisibility(0);
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
            this.gFy.getSwitchView().turnOnNoCallback();
        } else {
            this.gFy.getSwitchView().turnOffNoCallback();
        }
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
    }

    public void setMsgOnClickListener(View.OnClickListener onClickListener) {
        this.gFz.setOnClickListener(onClickListener);
        this.gFA.setOnClickListener(onClickListener);
        this.gFB.setOnClickListener(onClickListener);
        this.gFC.setOnClickListener(onClickListener);
        this.gFE.setOnClickListener(onClickListener);
        this.gFF.setOnClickListener(onClickListener);
    }

    public void setSwitchChangeListener(BdSwitchView.a aVar) {
        this.gFy.setSwitchStateChangeListener(aVar);
    }

    public void a(ForumDetailActivity forumDetailActivity, int i) {
        forumDetailActivity.getLayoutMode().setNightMode(i == 1);
        forumDetailActivity.getLayoutMode().onModeChanged(this);
        this.gFy.jz(i);
    }
}
