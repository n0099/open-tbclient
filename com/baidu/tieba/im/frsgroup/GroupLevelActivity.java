package com.baidu.tieba.im.frsgroup;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.d;
import com.baidu.tieba.im.data.GroupLevelInfo;
import com.baidu.tieba.im.message.RequestUpgradeMemberGroupMessage;
import com.baidu.tieba.im.message.ResponseGroupLevelMessage;
import com.baidu.tieba.im.message.ResponseUpgradeMemberGroupMessage;
import com.baidu.tieba.im.model.GroupLevelModel;
import java.util.List;
/* loaded from: classes3.dex */
public class GroupLevelActivity extends BaseActivity<GroupLevelActivity> {
    private GroupLevelModel eoJ;
    private k eoK;
    private com.baidu.tbadk.core.dialog.a eoL;
    private a.b eoM = new a.b() { // from class: com.baidu.tieba.im.frsgroup.GroupLevelActivity.1
        @Override // com.baidu.tbadk.core.dialog.a.b
        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
            RequestUpgradeMemberGroupMessage requestUpgradeMemberGroupMessage = new RequestUpgradeMemberGroupMessage();
            requestUpgradeMemberGroupMessage.setGroupId(GroupLevelActivity.this.eoJ.getGroupId());
            requestUpgradeMemberGroupMessage.setUpOrDown(true);
            GroupLevelActivity.this.sendMessage(requestUpgradeMemberGroupMessage);
            aVar.dismiss();
        }
    };
    private a.b eoN = new a.b() { // from class: com.baidu.tieba.im.frsgroup.GroupLevelActivity.2
        @Override // com.baidu.tbadk.core.dialog.a.b
        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
            aVar.dismiss();
        }
    };
    private com.baidu.adp.framework.listener.c efV = new com.baidu.adp.framework.listener.c(0) { // from class: com.baidu.tieba.im.frsgroup.GroupLevelActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            GroupLevelInfo.LevelInfo levelInfo;
            GroupLevelActivity.this.eoK.ht(false);
            if (socketResponsedMessage == null) {
                GroupLevelActivity.this.showToast(d.k.neterror);
            } else if (socketResponsedMessage instanceof ResponseGroupLevelMessage) {
                ResponseGroupLevelMessage responseGroupLevelMessage = (ResponseGroupLevelMessage) socketResponsedMessage;
                if (responseGroupLevelMessage.getError() != 0) {
                    if (responseGroupLevelMessage.getError() > 0) {
                        GroupLevelActivity.this.showToast(StringUtils.isNull(responseGroupLevelMessage.getErrorString()) ? GroupLevelActivity.this.getResources().getString(d.k.neterror) : responseGroupLevelMessage.getErrorString());
                        return;
                    } else {
                        GroupLevelActivity.this.showToast(d.k.neterror);
                        return;
                    }
                }
                GroupLevelInfo groupLevelInfo = responseGroupLevelMessage.getGroupLevelInfo();
                if (groupLevelInfo != null) {
                    int grade = groupLevelInfo.getGrade();
                    List<GroupLevelInfo.LevelInfo> levelInfos = groupLevelInfo.getLevelInfos();
                    List<GroupLevelInfo.LevelInfo> vipLevelInfos = groupLevelInfo.getVipLevelInfos();
                    if (levelInfos.size() >= 4 && vipLevelInfos.size() >= 4) {
                        if (groupLevelInfo.isMemGroup()) {
                            levelInfo = vipLevelInfos.get(grade);
                        } else {
                            levelInfo = levelInfos.get(grade);
                        }
                        int activeDay = groupLevelInfo.getActiveDay();
                        int thresholdDay = levelInfo.getThresholdDay();
                        String intro = levelInfo.getIntro();
                        GroupLevelActivity.this.eoK.x(grade, groupLevelInfo.isMemGroup());
                        GroupLevelActivity.this.eoK.aJr().setText(intro);
                        GroupLevelActivity.this.eoK.N(grade, activeDay, thresholdDay);
                        GroupLevelActivity.this.eoK.a(groupLevelInfo.isMemGroup(), groupLevelInfo.isGroupAuthor(), groupLevelInfo.isCanCreateMember(), groupLevelInfo.getLeftCreateMemGroup());
                        TextView[] aJp = GroupLevelActivity.this.eoK.aJp();
                        for (int i = 1; i < levelInfos.size(); i++) {
                            int maxMemberNum = levelInfos.get(i).getMaxMemberNum();
                            if (i <= aJp.length) {
                                aJp[i].setText(GroupLevelActivity.this.getPageContext().getContext().getString(d.k.grouplevel_level_condition, String.valueOf(maxMemberNum)));
                            }
                        }
                        TextView[] aJq = GroupLevelActivity.this.eoK.aJq();
                        for (int i2 = 1; i2 < vipLevelInfos.size(); i2++) {
                            int maxMemberNum2 = vipLevelInfos.get(i2).getMaxMemberNum();
                            if (i2 <= aJq.length) {
                                aJq[i2].setText(GroupLevelActivity.this.getPageContext().getContext().getString(d.k.grouplevel_level_condition, String.valueOf(maxMemberNum2)));
                            }
                        }
                    }
                }
            } else if (socketResponsedMessage instanceof ResponseUpgradeMemberGroupMessage) {
                ResponseUpgradeMemberGroupMessage responseUpgradeMemberGroupMessage = (ResponseUpgradeMemberGroupMessage) socketResponsedMessage;
                if (responseUpgradeMemberGroupMessage.getError() == 0) {
                    GroupLevelActivity.this.startLoading();
                } else if (responseUpgradeMemberGroupMessage.getError() == 2230110) {
                    GroupLevelActivity.this.showToast(responseUpgradeMemberGroupMessage.getErrorString());
                    GroupLevelActivity.this.startLoading();
                } else {
                    GroupLevelActivity.this.showToast(responseUpgradeMemberGroupMessage.getErrorString());
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        TiebaStatic.log("im_group_level_visit");
        initData(bundle);
        r(bundle);
        startLoading();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startLoading() {
        this.eoK.ht(true);
        this.eoJ.sendMessage(this.eoJ.getGroupId(), getUniqueId());
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.eoJ.saveInstance(bundle);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.eoK.aJn()) {
            closeActivity();
        } else if (view == this.eoK.aJo()) {
            TiebaStatic.log("im_group_level_upgrade_mem");
            this.eoL.xn();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.eoK.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    public void initData(Bundle bundle) {
        this.eoJ = new GroupLevelModel(this);
        if (bundle == null) {
            this.eoJ.initWithIntent(getIntent());
        } else {
            this.eoJ.initWithBundle(bundle);
        }
        registerListener(103006, this.efV);
        registerListener(103105, this.efV);
    }

    private void r(Bundle bundle) {
        this.eoK = new k(this, this.eoJ.isMem());
        this.eoL = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.eoL.cd(d.k.upgrade_mem_group_if_up);
        this.eoL.a(d.k.confirm, this.eoM);
        this.eoL.b(d.k.cancel, this.eoN);
        this.eoL.b(getPageContext());
    }
}
