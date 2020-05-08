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
    private GroupLevelModel ilO;
    private k ilP;
    private com.baidu.tbadk.core.dialog.a ilQ;
    private a.b ilR = new a.b() { // from class: com.baidu.tieba.im.frsgroup.GroupLevelActivity.1
        @Override // com.baidu.tbadk.core.dialog.a.b
        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
            RequestUpgradeMemberGroupMessage requestUpgradeMemberGroupMessage = new RequestUpgradeMemberGroupMessage();
            requestUpgradeMemberGroupMessage.setGroupId(GroupLevelActivity.this.ilO.getGroupId());
            requestUpgradeMemberGroupMessage.setUpOrDown(true);
            GroupLevelActivity.this.sendMessage(requestUpgradeMemberGroupMessage);
            aVar.dismiss();
        }
    };
    private a.b ilS = new a.b() { // from class: com.baidu.tieba.im.frsgroup.GroupLevelActivity.2
        @Override // com.baidu.tbadk.core.dialog.a.b
        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
            aVar.dismiss();
        }
    };
    private com.baidu.adp.framework.listener.c idb = new com.baidu.adp.framework.listener.c(0) { // from class: com.baidu.tieba.im.frsgroup.GroupLevelActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            GroupLevelInfo.LevelInfo levelInfo;
            GroupLevelActivity.this.ilP.oI(false);
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
                        GroupLevelActivity.this.ilP.Q(grade, groupLevelInfo.isMemGroup());
                        GroupLevelActivity.this.ilP.cfV().setText(intro);
                        GroupLevelActivity.this.ilP.T(grade, activeDay, thresholdDay);
                        GroupLevelActivity.this.ilP.a(groupLevelInfo.isMemGroup(), groupLevelInfo.isGroupAuthor(), groupLevelInfo.isCanCreateMember(), groupLevelInfo.getLeftCreateMemGroup());
                        TextView[] cfT = GroupLevelActivity.this.ilP.cfT();
                        for (int i = 1; i < levelInfos.size(); i++) {
                            int maxMemberNum = levelInfos.get(i).getMaxMemberNum();
                            if (i <= cfT.length) {
                                cfT[i].setText(GroupLevelActivity.this.getPageContext().getContext().getString(R.string.grouplevel_level_condition, String.valueOf(maxMemberNum)));
                            }
                        }
                        TextView[] cfU = GroupLevelActivity.this.ilP.cfU();
                        for (int i2 = 1; i2 < vipLevelInfos.size(); i2++) {
                            int maxMemberNum2 = vipLevelInfos.get(i2).getMaxMemberNum();
                            if (i2 <= cfU.length) {
                                cfU[i2].setText(GroupLevelActivity.this.getPageContext().getContext().getString(R.string.grouplevel_level_condition, String.valueOf(maxMemberNum2)));
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
        ap(bundle);
        startLoading();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startLoading() {
        this.ilP.oI(true);
        this.ilO.sendMessage(this.ilO.getGroupId(), getUniqueId());
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.ilO.saveInstance(bundle);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.ilP.cfR()) {
            closeActivity();
        } else if (view == this.ilP.cfS()) {
            TiebaStatic.log("im_group_level_upgrade_mem");
            this.ilQ.aMS();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.ilP.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    public void initData(Bundle bundle) {
        this.ilO = new GroupLevelModel(this);
        if (bundle == null) {
            this.ilO.initWithIntent(getIntent());
        } else {
            this.ilO.initWithBundle(bundle);
        }
        registerListener(CmdConfigSocket.CMD_REQUEST_GROUPLEVEL_BY_ID, this.idb);
        registerListener(CmdConfigSocket.CMD_UPGRADE_MEMBER_GROUP, this.idb);
    }

    private void ap(Bundle bundle) {
        this.ilP = new k(this, this.ilO.isMem());
        this.ilQ = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.ilQ.kd(R.string.upgrade_mem_group_if_up);
        this.ilQ.a(R.string.confirm, this.ilR);
        this.ilQ.b(R.string.cancel, this.ilS);
        this.ilQ.b(getPageContext());
    }
}
