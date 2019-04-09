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
/* loaded from: classes5.dex */
public class GroupLevelActivity extends BaseActivity<GroupLevelActivity> {
    private GroupLevelModel gjj;
    private k gjk;
    private com.baidu.tbadk.core.dialog.a gjl;
    private a.b gjm = new a.b() { // from class: com.baidu.tieba.im.frsgroup.GroupLevelActivity.1
        @Override // com.baidu.tbadk.core.dialog.a.b
        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
            RequestUpgradeMemberGroupMessage requestUpgradeMemberGroupMessage = new RequestUpgradeMemberGroupMessage();
            requestUpgradeMemberGroupMessage.setGroupId(GroupLevelActivity.this.gjj.getGroupId());
            requestUpgradeMemberGroupMessage.setUpOrDown(true);
            GroupLevelActivity.this.sendMessage(requestUpgradeMemberGroupMessage);
            aVar.dismiss();
        }
    };
    private a.b gjn = new a.b() { // from class: com.baidu.tieba.im.frsgroup.GroupLevelActivity.2
        @Override // com.baidu.tbadk.core.dialog.a.b
        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
            aVar.dismiss();
        }
    };
    private com.baidu.adp.framework.listener.c gat = new com.baidu.adp.framework.listener.c(0) { // from class: com.baidu.tieba.im.frsgroup.GroupLevelActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            GroupLevelInfo.LevelInfo levelInfo;
            GroupLevelActivity.this.gjk.lb(false);
            if (socketResponsedMessage == null) {
                GroupLevelActivity.this.showToast(d.j.neterror);
            } else if (socketResponsedMessage instanceof ResponseGroupLevelMessage) {
                ResponseGroupLevelMessage responseGroupLevelMessage = (ResponseGroupLevelMessage) socketResponsedMessage;
                if (responseGroupLevelMessage.getError() != 0) {
                    if (responseGroupLevelMessage.getError() > 0) {
                        GroupLevelActivity.this.showToast(StringUtils.isNull(responseGroupLevelMessage.getErrorString()) ? GroupLevelActivity.this.getResources().getString(d.j.neterror) : responseGroupLevelMessage.getErrorString());
                        return;
                    } else {
                        GroupLevelActivity.this.showToast(d.j.neterror);
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
                        GroupLevelActivity.this.gjk.D(grade, groupLevelInfo.isMemGroup());
                        GroupLevelActivity.this.gjk.bsX().setText(intro);
                        GroupLevelActivity.this.gjk.V(grade, activeDay, thresholdDay);
                        GroupLevelActivity.this.gjk.a(groupLevelInfo.isMemGroup(), groupLevelInfo.isGroupAuthor(), groupLevelInfo.isCanCreateMember(), groupLevelInfo.getLeftCreateMemGroup());
                        TextView[] bsV = GroupLevelActivity.this.gjk.bsV();
                        for (int i = 1; i < levelInfos.size(); i++) {
                            int maxMemberNum = levelInfos.get(i).getMaxMemberNum();
                            if (i <= bsV.length) {
                                bsV[i].setText(GroupLevelActivity.this.getPageContext().getContext().getString(d.j.grouplevel_level_condition, String.valueOf(maxMemberNum)));
                            }
                        }
                        TextView[] bsW = GroupLevelActivity.this.gjk.bsW();
                        for (int i2 = 1; i2 < vipLevelInfos.size(); i2++) {
                            int maxMemberNum2 = vipLevelInfos.get(i2).getMaxMemberNum();
                            if (i2 <= bsW.length) {
                                bsW[i2].setText(GroupLevelActivity.this.getPageContext().getContext().getString(d.j.grouplevel_level_condition, String.valueOf(maxMemberNum2)));
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
        W(bundle);
        startLoading();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startLoading() {
        this.gjk.lb(true);
        this.gjj.sendMessage(this.gjj.getGroupId(), getUniqueId());
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.gjj.saveInstance(bundle);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gjk.bsT()) {
            closeActivity();
        } else if (view == this.gjk.bsU()) {
            TiebaStatic.log("im_group_level_upgrade_mem");
            this.gjl.aaW();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.gjk.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    public void initData(Bundle bundle) {
        this.gjj = new GroupLevelModel(this);
        if (bundle == null) {
            this.gjj.initWithIntent(getIntent());
        } else {
            this.gjj.initWithBundle(bundle);
        }
        registerListener(103006, this.gat);
        registerListener(103105, this.gat);
    }

    private void W(Bundle bundle) {
        this.gjk = new k(this, this.gjj.isMem());
        this.gjl = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.gjl.gC(d.j.upgrade_mem_group_if_up);
        this.gjl.a(d.j.confirm, this.gjm);
        this.gjl.b(d.j.cancel, this.gjn);
        this.gjl.b(getPageContext());
    }
}
