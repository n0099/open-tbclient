package com.baidu.tieba.im.frsgroup;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.im.data.GroupLevelInfo;
import com.baidu.tieba.im.message.RequestUpgradeMemberGroupMessage;
import com.baidu.tieba.im.message.ResponseGroupLevelMessage;
import com.baidu.tieba.im.message.ResponseUpgradeMemberGroupMessage;
import com.baidu.tieba.im.model.GroupLevelModel;
import java.util.List;
/* loaded from: classes10.dex */
public class GroupLevelActivity extends BaseActivity<GroupLevelActivity> {
    private GroupLevelModel iSo;
    private k iSp;
    private com.baidu.tbadk.core.dialog.a iSq;
    private a.b iSr = new a.b() { // from class: com.baidu.tieba.im.frsgroup.GroupLevelActivity.1
        @Override // com.baidu.tbadk.core.dialog.a.b
        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
            RequestUpgradeMemberGroupMessage requestUpgradeMemberGroupMessage = new RequestUpgradeMemberGroupMessage();
            requestUpgradeMemberGroupMessage.setGroupId(GroupLevelActivity.this.iSo.getGroupId());
            requestUpgradeMemberGroupMessage.setUpOrDown(true);
            GroupLevelActivity.this.sendMessage(requestUpgradeMemberGroupMessage);
            aVar.dismiss();
        }
    };
    private a.b iSs = new a.b() { // from class: com.baidu.tieba.im.frsgroup.GroupLevelActivity.2
        @Override // com.baidu.tbadk.core.dialog.a.b
        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
            aVar.dismiss();
        }
    };
    private com.baidu.adp.framework.listener.c iJH = new com.baidu.adp.framework.listener.c(0) { // from class: com.baidu.tieba.im.frsgroup.GroupLevelActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            GroupLevelInfo.LevelInfo levelInfo;
            GroupLevelActivity.this.iSp.po(false);
            if (socketResponsedMessage == null) {
                GroupLevelActivity.this.showToast(R.string.neterror);
            } else if (socketResponsedMessage instanceof ResponseGroupLevelMessage) {
                ResponseGroupLevelMessage responseGroupLevelMessage = (ResponseGroupLevelMessage) socketResponsedMessage;
                if (responseGroupLevelMessage.getError() != 0) {
                    if (responseGroupLevelMessage.getError() > 0) {
                        GroupLevelActivity.this.showToast(StringUtils.isNull(responseGroupLevelMessage.getErrorString()) ? GroupLevelActivity.this.getResources().getString(R.string.neterror) : responseGroupLevelMessage.getErrorString());
                        return;
                    } else {
                        GroupLevelActivity.this.showToast(R.string.neterror);
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
                        GroupLevelActivity.this.iSp.W(grade, groupLevelInfo.isMemGroup());
                        GroupLevelActivity.this.iSp.cqs().setText(intro);
                        GroupLevelActivity.this.iSp.T(grade, activeDay, thresholdDay);
                        GroupLevelActivity.this.iSp.a(groupLevelInfo.isMemGroup(), groupLevelInfo.isGroupAuthor(), groupLevelInfo.isCanCreateMember(), groupLevelInfo.getLeftCreateMemGroup());
                        TextView[] cqq = GroupLevelActivity.this.iSp.cqq();
                        for (int i = 1; i < levelInfos.size(); i++) {
                            int maxMemberNum = levelInfos.get(i).getMaxMemberNum();
                            if (i <= cqq.length) {
                                cqq[i].setText(GroupLevelActivity.this.getPageContext().getContext().getString(R.string.grouplevel_level_condition, String.valueOf(maxMemberNum)));
                            }
                        }
                        TextView[] cqr = GroupLevelActivity.this.iSp.cqr();
                        for (int i2 = 1; i2 < vipLevelInfos.size(); i2++) {
                            int maxMemberNum2 = vipLevelInfos.get(i2).getMaxMemberNum();
                            if (i2 <= cqr.length) {
                                cqr[i2].setText(GroupLevelActivity.this.getPageContext().getContext().getString(R.string.grouplevel_level_condition, String.valueOf(maxMemberNum2)));
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
        aw(bundle);
        startLoading();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startLoading() {
        this.iSp.po(true);
        this.iSo.sendMessage(this.iSo.getGroupId(), getUniqueId());
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.iSo.saveInstance(bundle);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.iSp.cqo()) {
            closeActivity();
        } else if (view == this.iSp.cqp()) {
            TiebaStatic.log("im_group_level_upgrade_mem");
            this.iSq.aUN();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.iSp.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    public void initData(Bundle bundle) {
        this.iSo = new GroupLevelModel(this);
        if (bundle == null) {
            this.iSo.initWithIntent(getIntent());
        } else {
            this.iSo.initWithBundle(bundle);
        }
        registerListener(CmdConfigSocket.CMD_REQUEST_GROUPLEVEL_BY_ID, this.iJH);
        registerListener(CmdConfigSocket.CMD_UPGRADE_MEMBER_GROUP, this.iJH);
    }

    private void aw(Bundle bundle) {
        this.iSp = new k(this, this.iSo.isMem());
        this.iSq = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.iSq.kT(R.string.upgrade_mem_group_if_up);
        this.iSq.a(R.string.confirm, this.iSr);
        this.iSq.b(R.string.cancel, this.iSs);
        this.iSq.b(getPageContext());
    }
}
