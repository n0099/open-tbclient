package com.baidu.tieba.im.groupInfo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.i.a.a;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.ApplyJoinGroupActivityConfig;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import com.baidu.tbadk.core.atomData.EditHeadActivityConfig;
import com.baidu.tbadk.core.atomData.GroupActivityActivityConfig;
import com.baidu.tbadk.core.atomData.GroupAddressLocateActivityConfig;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.atomData.GroupImageActivityConfig;
import com.baidu.tbadk.core.atomData.GroupLevelActivityConfig;
import com.baidu.tbadk.core.atomData.GroupSettingActivityConfig;
import com.baidu.tbadk.core.atomData.InviteFriendListActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.UpdateGroupActivityConfig;
import com.baidu.tbadk.core.data.GroupData;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.dialog.i;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ad;
import com.baidu.tbadk.core.util.ae;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.coreExtra.data.PhotoUrlData;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.util.l;
import com.baidu.tieba.R;
import com.baidu.tieba.im.data.GroupActivityData;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.im.frsgroup.MembersActivity;
import com.baidu.tieba.im.groupCard.GroupCardModel;
import com.baidu.tieba.im.message.PushMessage;
import com.baidu.tieba.im.message.RequestGroupInfoLocalMessage;
import com.baidu.tieba.im.message.RequestRemoveMembersMessage;
import com.baidu.tieba.im.message.RequestUpdateGroupMessage;
import com.baidu.tieba.im.message.ResponseCreateGroupActivityMessage;
import com.baidu.tieba.im.message.ResponseDelGroupActivityMessage;
import com.baidu.tieba.im.message.ResponseDismissGroupMessage;
import com.baidu.tieba.im.message.ResponseGroupInfoLocalMessage;
import com.baidu.tieba.im.message.ResponseGroupInfoMessage;
import com.baidu.tieba.im.message.ResponseRemoveMembersMessage;
import com.baidu.tieba.im.message.ResponseUpdateGroupMessage;
import com.baidu.tieba.im.message.ResponseUpgradeMemberGroupMessage;
import com.baidu.tieba.im.model.GroupInfoModel;
import com.baidu.tieba.im.model.UpdateGroupModel;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes17.dex */
public class GroupInfoActivity extends BaseActivity<GroupInfoActivity> implements View.OnClickListener, View.OnLongClickListener, a.InterfaceC0153a, c, d {
    private UpdateGroupModel iPW;
    private com.baidu.tieba.im.groupInfo.a jdE;
    private GroupInfoModel jdF;
    private a jdG;
    private PermissionJudgePolicy mPermissionJudgement;
    private int type = 0;
    private final WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private long jdH = -1;
    private long jdI = -1;
    private final b.InterfaceC0492b jdJ = new b.InterfaceC0492b() { // from class: com.baidu.tieba.im.groupInfo.GroupInfoActivity.1
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0492b
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            bVar.dismiss();
            if (i == 0) {
                GroupInfoActivity.this.ccb();
            } else if (i == 1) {
                AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(GroupInfoActivity.this.getPageContext().getPageActivity(), GroupInfoActivity.this.writeImagesInfo.toJsonString());
                albumActivityConfig.setRequestCode(RequestResponseCode.REQUEST_ALBUM_IMAGE);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
            }
        }
    };
    private final b jdK = new b() { // from class: com.baidu.tieba.im.groupInfo.GroupInfoActivity.2
        @Override // com.baidu.tieba.im.groupInfo.b
        public void a(i iVar, int i, Object obj, int i2) {
            if (iVar != null && iVar.isShowing()) {
                iVar.dismiss();
            }
            if (i == 0) {
                if (i2 != 0) {
                    GroupInfoActivity.this.aD(obj);
                } else {
                    GroupInfoActivity.this.showToast(GroupInfoActivity.this.getPageContext().getString(R.string.has_set_portrait));
                }
            } else if (i == 1) {
                if (i2 == 0) {
                    GroupInfoActivity.this.showToast(GroupInfoActivity.this.getPageContext().getString(R.string.group_portrait_cant_del));
                } else if (obj != null && (obj instanceof PhotoUrlData)) {
                    GroupInfoActivity.this.a((PhotoUrlData) obj);
                }
            }
        }
    };
    private final CustomMessageListener mCustomListener = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.groupInfo.GroupInfoActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null) {
                GroupInfoActivity.this.jdE.cvE();
                GroupInfoActivity.this.showToast(R.string.neterror);
            } else if (customResponsedMessage.getCmd() == 2001102) {
                if (!(customResponsedMessage instanceof ResponseGroupInfoLocalMessage)) {
                    GroupInfoActivity.this.jdF.sendMessage(GroupInfoActivity.this.jdF.getGroupId(), GroupInfoActivity.this.jdF.getFrom());
                    return;
                }
                ResponseGroupInfoLocalMessage responseGroupInfoLocalMessage = (ResponseGroupInfoLocalMessage) customResponsedMessage;
                if (responseGroupInfoLocalMessage.getOrginalMessage() == null || ((RequestGroupInfoLocalMessage) responseGroupInfoLocalMessage.getOrginalMessage()).getGroupId() == GroupInfoActivity.this.jdF.getGroupId()) {
                    if (responseGroupInfoLocalMessage.getError() != 0) {
                        GroupInfoActivity.this.jdF.sendMessage(GroupInfoActivity.this.jdF.getGroupId(), GroupInfoActivity.this.jdF.getFrom());
                        return;
                    }
                    GroupInfoActivity.this.KG();
                    GroupInfoActivity.this.jdF.setData(responseGroupInfoLocalMessage.getData());
                    GroupInfoActivity.this.jdE.setData(responseGroupInfoLocalMessage.getData());
                    GroupInfoActivity.this.cvp();
                }
            }
        }
    };
    private final CustomMessageListener jbb = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.groupInfo.GroupInfoActivity.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            GroupNewsPojo p;
            if (customResponsedMessage != null && (customResponsedMessage instanceof PushMessage) && (p = ((PushMessage) customResponsedMessage).getP()) != null) {
                String cmd = p.getCmd();
                if (!TextUtils.isEmpty(cmd)) {
                    if (cmd.equals("apply_join_success")) {
                        GroupInfoActivity.this.f(p);
                    } else if (cmd.equals("kick_out")) {
                        GroupInfoActivity.this.b(p);
                    } else if (cmd.equals("group_name_change")) {
                        GroupInfoActivity.this.c(p);
                    } else if (cmd.equals("dismiss_group")) {
                        GroupInfoActivity.this.d(p);
                    } else if (cmd.equals("group_activitys_change")) {
                        GroupInfoActivity.this.startLoading();
                    }
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initListener();
        a(bundle, (Intent) null);
        initUI();
        cvp();
        startLoading();
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        a((Bundle) null, intent);
        this.jdI = this.jdF.getGroupId();
        startLoading();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cvp() {
        if (this.jdF != null) {
            long groupId = this.jdF.getGroupId();
            this.jdI = groupId;
            this.jdH = groupId;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cvq() {
        if (this.jdH != this.jdI) {
            initUI();
            cvp();
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void initListener() {
        this.jdG = new a();
        registerListener(CmdConfigSocket.CMD_REQUEST_GROUP_INFO_BY_ID, this.jdG);
        registerListener(CmdConfigCustom.CMD_REQUEST_GROUP_INFO_BY_ID_LOCAL, this.mCustomListener);
        registerListener(CmdConfigSocket.CMD_UPDATE_GROUP, this.jdG);
        registerListener(CmdConfigSocket.CMD_REMOVE_MEMBERS, this.jdG);
        registerListener(CmdConfigSocket.CMD_JOIN_GROUP, this.jdG);
        registerListener(CmdConfigSocket.CMD_CREATE_GROUP_ACTIVITY, this.jdG);
        registerListener(CmdConfigSocket.CMD_DEL_GROUP_ACTIVITY, this.jdG);
        registerListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_KICK_OUT, this.jbb);
        registerListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_APPLY_JOIN_SUCCESS, this.jbb);
        registerListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_GROUP_NAME_CHANGE, this.jbb);
        registerListener(CmdConfigSocket.CMD_DISSMISS_GROUP, this.jdG);
        registerListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_DISMISS_GROUP, this.jbb);
        registerListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_GROUP_ACTIVITYS_CHANGE, this.jbb);
        registerListener(CmdConfigSocket.CMD_UPGRADE_MEMBER_GROUP, this.jdG);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.jdF.saveInstance(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.jdF.cancelMessage();
        MessageManager.getInstance().unRegisterListener(this.jbb);
        if (this.jdE != null) {
            this.jdE.onDestory();
        }
    }

    private void initUI() {
        this.jdE = new com.baidu.tieba.im.groupInfo.a(this);
        this.jdE.a(this.jdK);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startLoading() {
        this.jdE.cvF();
        this.jdF.sendLocalMessage(this.jdF.getGroupId(), this.jdF.getFrom());
        this.jdF.sendMessage(this.jdF.getGroupId(), this.jdF.getFrom());
    }

    public void a(Bundle bundle, Intent intent) {
        this.jdF = new GroupInfoModel(this);
        this.jdF.setUniqueId(getUniqueId());
        if (bundle == null) {
            GroupInfoModel groupInfoModel = this.jdF;
            if (intent == null) {
                intent = getIntent();
            }
            groupInfoModel.initWithIntent(intent);
        } else {
            this.jdF.initWithBundle(bundle);
        }
        this.iPW = new UpdateGroupModel(getPageContext());
        this.iPW.setUniqueId(getUniqueId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KG() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        onChangeSkinType(TbadkApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        if (this.jdE != null) {
            this.jdE.changeSkinType(i);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.jdE.cvG()) {
            if (this.jdF.getData() != null && this.jdF.getData().cwq()) {
                TiebaStatic.log("edit_place_at_groupinfo");
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupAddressLocateActivityConfig(getPageContext().getPageActivity(), RequestResponseCode.REQUEST_ADDRESS_VIEW, this.jdF.getData().getGroup().getPosition(), this.jdF.getData().getGroup().getBusiness(), (this.jdF.getData().getGroup().getFlag() & 1) == 1)));
            }
        } else if (view == this.jdE.cum()) {
            closeActivity();
        } else if (view != this.jdE.cvt()) {
            if (view == this.jdE.cvB()) {
                if (this.jdF.getData() != null && this.jdF.getData().getGroup() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), String.valueOf(this.jdF.getData().getGroup().getAuthorId()), this.jdF.getData().getGroup().getAuthorName())));
                }
            } else if (view == this.jdE.cvC()) {
                if (this.jdF != null && this.jdF.getData() != null) {
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupLevelActivityConfig(getPageContext().getPageActivity(), this.jdF.getGroupId(), this.jdF.getData().isMemGroup())));
                }
            } else if (view == this.jdE.cvA()) {
                if (TextUtils.isEmpty(TbadkApplication.getCurrentAccount())) {
                    TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getPageContext().getPageActivity(), true, 3)));
                } else if (this.jdF.getData() != null) {
                    if (this.jdF.getData().cwp()) {
                        if (this.jdF.getData().getGroup() != null) {
                            TiebaStatic.log(new ap("c10334").dn("obj_type", String.valueOf(this.jdF.getData().getGroup().getGroupId())));
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(getPageContext().getPageActivity(), this.jdF.getGroupId(), this.jdF.getData().getGroup().getName(), this.jdF.getData().getGroup().getAuthorId(), "group_info")));
                        }
                    } else if (this.jdF.hasRecentJoin()) {
                        showToast(R.string.has_recent_join);
                    } else if (this.jdF.getData() != null) {
                        if (this.jdF.getData().cwo() <= 0) {
                            showToast(R.string.add_group_max);
                        } else if (ApplyJoinGroupActivityConfig.JOINTYPE_DEFAULT == this.jdF.getJoinType()) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IM_APPLE_JOIN_GROUP_ACTIVITY_START, new ApplyJoinGroupActivityConfig(getPageContext().getPageActivity(), "" + this.jdF.getGroupId(), this.jdF.getData().cwn(), this.jdF.getData().cwo())));
                        } else if (ApplyJoinGroupActivityConfig.JOINTYPE_INVITE == this.jdF.getJoinType()) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IM_APPLE_JOIN_GROUP_ACTIVITY_START, new ApplyJoinGroupActivityConfig(getPageContext().getPageActivity(), "" + this.jdF.getGroupId(), this.jdF.getData().cwn(), this.jdF.getData().cwo(), this.jdF.getInviteUserId(), this.jdF.getDefaultUserMsg())));
                        }
                    }
                }
            } else if (view == this.jdE.cvz()) {
                if (this.jdF.getData() != null && this.jdF.getData().getGroup() != null) {
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupSettingActivityConfig(getPageContext().getPageActivity(), 4, this.jdF.getData().getGroup().getName(), "" + this.jdF.getGroupId(), this.jdF.getData().cwq(), this.jdF.getData().getGroup().getFlag())));
                }
            } else if (view == this.jdE.cvx()) {
                if (this.jdF.getData() != null && this.jdF.getData().getGroup() != null) {
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UpdateGroupActivityConfig(getPageContext().getPageActivity(), 1, this.jdF.getGroupId(), 1, this.jdF.getData().getGroup().getName())));
                }
            } else if (view == this.jdE.cvw()) {
                if (this.jdF.getData() != null && this.jdF.getData().cwq() && this.jdF.getData().getGroup() != null) {
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UpdateGroupActivityConfig(getPageContext().getPageActivity(), 2, this.jdF.getGroupId(), 2, this.jdF.getData().getGroup().getIntro())));
                }
            } else if (view == this.jdE.cvD() || view == this.jdE.cvu()) {
                MembersActivity.d(getPageContext().getPageActivity(), this.jdF.getGroupId());
            } else if (view == this.jdE.cvv()) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new InviteFriendListActivityConfig(getPageContext().getPageActivity(), 0L, this.jdF.getGroupId())));
            } else if (view == this.jdE.cvy() && this.jdF.getData() != null && this.jdF.getData().cwp()) {
                GroupActivityData cwk = this.jdF.getData().cwk();
                if (cwk != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupActivityActivityConfig(getPageContext().getPageActivity(), cwk.getActivityId(), this.jdF.getGroupId(), 0)));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CreateGroupActivityActivityConfig(getPageContext().getPageActivity(), this.jdF.getGroupId())));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void closeActivity() {
        setResult(-1);
        finish();
    }

    @Override // com.baidu.tieba.im.groupInfo.d
    public void c(View view, Object obj, int i) {
        this.jdE.d(obj, i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        if (view == this.jdE.cvs()) {
            if (this.jdF.getData() == null || this.jdF.getData().getGroup() == null) {
                return false;
            }
            this.jdE.HY(String.valueOf(this.jdF.getData().getGroup().getGroupId()));
            return false;
        } else if (view != this.jdE.cvw() || this.jdF.getData().cwq()) {
            return false;
        } else {
            if (this.jdF.getData() != null && this.jdF.getData().getGroup() != null) {
                this.jdE.HX(String.valueOf(this.jdF.getData().getGroup().getIntro()));
            }
            return true;
        }
    }

    @Override // com.baidu.tieba.im.groupInfo.c
    public void a(View view, int i, Object obj, int i2) {
        if (i == 2) {
            Activity pageActivity = getPageContext().getPageActivity();
            if (this.mPermissionJudgement == null) {
                this.mPermissionJudgement = new PermissionJudgePolicy();
            }
            this.mPermissionJudgement.clearRequestPermissionList();
            this.mPermissionJudgement.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgement.startRequestPermission(pageActivity)) {
                AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true);
                albumActivityConfig.setRequestCode(RequestResponseCode.REQUEST_ALBUM_IMAGE);
                albumActivityConfig.setResourceType(2);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
            }
        } else if (i == 1) {
            ArrayList<String> bigUrlList = this.jdF.getBigUrlList();
            HashMap<String, ImageUrlData> assistUrls = this.jdF.getAssistUrls();
            if (obj != null && (obj instanceof PhotoUrlData) && bigUrlList != null) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupImageActivityConfig(getPageContext().getPageActivity(), ((PhotoUrlData) obj).getBigurl(), bigUrlList, this.jdF.getGroupId(), assistUrls)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ccb() {
        if (!ad.requestWriteExternalStorgeAndCameraPermission(getPageContext().getPageActivity(), 1)) {
            an.g(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 1:
                    if (intent != null) {
                        String stringExtra = intent.getStringExtra(UpdateGroupActivityConfig.GROUP_TEXT);
                        if (this.jdE != null) {
                            this.jdE.setGroupName(stringExtra);
                        }
                        if (this.jdF != null && this.jdF.getData() != null && this.jdF.getData().getGroup() != null) {
                            this.jdF.getData().getGroup().setName(stringExtra);
                            return;
                        }
                        return;
                    }
                    return;
                case 2:
                    if (intent != null) {
                        String stringExtra2 = intent.getStringExtra(UpdateGroupActivityConfig.GROUP_TEXT);
                        if (this.jdE != null) {
                            this.jdE.HV(stringExtra2);
                        }
                        if (this.jdF != null && this.jdF.getData() != null && this.jdF.getData().getGroup() != null) {
                            this.jdF.getData().getGroup().setIntro(stringExtra2);
                            return;
                        }
                        return;
                    }
                    return;
                case 3:
                    startLoading();
                    return;
                case 4:
                    if (intent != null) {
                        int intExtra = intent.getIntExtra(GroupSettingActivityConfig.INTENT_DATA_GROUP_FLAG, 0);
                        if (this.jdF != null && this.jdF.getData() != null && this.jdF.getData().getGroup() != null) {
                            this.jdF.getData().getGroup().setFlag(intExtra);
                            return;
                        }
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_ALBUM_IMAGE /* 12002 */:
                    if (intent != null) {
                        intent.getBooleanExtra("camera_result", false);
                        Z(intent);
                        break;
                    } else {
                        return;
                    }
                case RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW /* 12009 */:
                case RequestResponseCode.REQUEST_CAMERA_VIEW /* 12010 */:
                    break;
                case RequestResponseCode.REQUEST_ADDRESS_VIEW /* 21001 */:
                    k(intent.getBooleanExtra("ResultDataIsHiddenAddress", true) ? 1 : 0, intent.getStringExtra("ResultDataAddress"), intent.getStringExtra("ResultDataSelectedBusiness"));
                    return;
                default:
                    return;
            }
            PhotoUrlData photoUrlData = (PhotoUrlData) intent.getSerializableExtra(EditHeadActivityConfig.PIC_INFO);
            if (photoUrlData != null) {
                ae.baB().c(photoUrlData.getSmallurl(), n.getFileDireciory(TbConfig.GROUP_HEAD_FILE), true, false, true);
            }
            b(photoUrlData);
        } else if (i2 == 0 && i == 12010) {
            ccb();
        }
    }

    private void Z(Intent intent) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra("album_result")) != null) {
            this.writeImagesInfo.parseJson(stringExtra);
            this.writeImagesInfo.updateQuality();
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), (int) RequestResponseCode.REQUEST_ALBUM_IMAGE, (int) RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW, intent.getData(), TbadkApplication.getCurrentAccountObj(), 2, this.writeImagesInfo.getChosedFiles().get(0).getFilePath(), 1.0f)));
            }
            this.writeImagesInfo.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(PhotoUrlData photoUrlData) {
        this.type = 2;
        if (photoUrlData != null) {
            HT(this.jdF.generateDeleAlbum(photoUrlData));
        }
    }

    private void b(PhotoUrlData photoUrlData) {
        this.type = 1;
        if (photoUrlData != null) {
            String generateAddAlbum = this.jdF.generateAddAlbum(photoUrlData);
            if (!TextUtils.isEmpty(generateAddAlbum)) {
                HT(generateAddAlbum);
            }
        }
    }

    private void k(int i, String str, String str2) {
        this.type = 4;
        if (this.iPW != null) {
            this.iPW.setGroupId(this.jdF.getGroupId());
            this.iPW.setFlag(i);
            this.iPW.setPosition(str);
            this.iPW.setBusiness(str2);
            this.iPW.sendMessage(5);
            this.jdE.cvF();
        }
    }

    private void HT(String str) {
        if (this.iPW != null) {
            this.iPW.setGroupId(this.jdF.getGroupId());
            this.iPW.setAlbum(str);
            this.iPW.sendMessage(3);
            this.jdE.cvF();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aD(Object obj) {
        GroupCardModel.cvf();
        this.type = 3;
        if (obj != null && (obj instanceof PhotoUrlData)) {
            PhotoUrlData photoUrlData = (PhotoUrlData) obj;
            this.jdF.setChangePhotoUrlData(photoUrlData);
            String picId = photoUrlData.getPicId();
            if (this.iPW != null) {
                this.iPW.setGroupId(this.jdF.getGroupId());
                this.iPW.setPortrait(picId);
                this.iPW.sendMessage(4);
                this.jdE.cvF();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes17.dex */
    public class a extends com.baidu.adp.framework.listener.c {
        public a() {
            super(0);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            Message<?> orginalMessage;
            String[] split;
            Message<?> orginalMessage2;
            if (socketResponsedMessage == null) {
                GroupInfoActivity.this.jdE.cvE();
                GroupInfoActivity.this.showToast(R.string.neterror);
            } else if (socketResponsedMessage.getCmd() == 103004) {
                GroupInfoActivity.this.jdE.cvE();
                final ResponseGroupInfoMessage responseGroupInfoMessage = (ResponseGroupInfoMessage) socketResponsedMessage;
                if (GroupInfoActivity.this.jdF.getSendMsg() == responseGroupInfoMessage.getOrginalMessage()) {
                    if (responseGroupInfoMessage.getError() == 2230101) {
                        GroupInfoActivity.this.showToast(StringUtils.isNull(responseGroupInfoMessage.getErrorString()) ? GroupInfoActivity.this.getResources().getString(R.string.neterror) : responseGroupInfoMessage.getErrorString(), false);
                        GroupInfoActivity.this.finish();
                    } else if (responseGroupInfoMessage.getData() != null && responseGroupInfoMessage.getError() == 0) {
                        GroupInfoActivity.this.cvp();
                        GroupInfoActivity.this.KG();
                        GroupInfoActivity.this.jdF.setData(responseGroupInfoMessage.getData());
                        if (responseGroupInfoMessage == null || responseGroupInfoMessage.getData().cwp()) {
                            GroupInfoActivity.this.jdE.a(responseGroupInfoMessage.getData(), false);
                            return;
                        }
                        GroupInfoActivity.this.jdE.cvF();
                        com.baidu.tieba.im.settingcache.b.cxq().a(TbadkApplication.getCurrentAccount(), String.valueOf(GroupInfoActivity.this.jdF.getGroupId()), 60000L, new l<Boolean>() { // from class: com.baidu.tieba.im.groupInfo.GroupInfoActivity.a.1
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.tbadk.util.l
                            public void onReturnDataInUI(Boolean bool) {
                                if (bool == null) {
                                    bool = false;
                                }
                                GroupInfoActivity.this.jdE.cvE();
                                GroupInfoActivity.this.jdE.a(responseGroupInfoMessage.getData(), bool.booleanValue());
                                GroupInfoActivity.this.jdF.setHasRecentJoin(bool.booleanValue() ? false : true);
                            }
                        });
                    } else {
                        GroupInfoActivity.this.showToast(R.string.neterror);
                        GroupInfoActivity.this.cvq();
                    }
                }
            } else if (socketResponsedMessage.getCmd() == 103110) {
                if (socketResponsedMessage instanceof ResponseJoinGroupMessage) {
                    ResponseJoinGroupMessage responseJoinGroupMessage = (ResponseJoinGroupMessage) socketResponsedMessage;
                    if (responseJoinGroupMessage.getError() == 0 && (orginalMessage2 = responseJoinGroupMessage.getOrginalMessage()) != null && (orginalMessage2 instanceof RequestJoinGroupMessage) && ((RequestJoinGroupMessage) orginalMessage2).getGroupId() == GroupInfoActivity.this.jdF.getGroupId()) {
                        GroupInfoActivity.this.jdE.cvJ();
                        GroupInfoActivity.this.jdF.setHasRecentJoin(true);
                        GroupInfoActivity.this.cvr();
                    }
                }
            } else if (socketResponsedMessage.getCmd() == 103102) {
                GroupInfoActivity.this.jdE.cvE();
                if (socketResponsedMessage.getError() != 0) {
                    GroupInfoActivity.this.showToast(R.string.neterror);
                    return;
                }
                ResponseUpdateGroupMessage responseUpdateGroupMessage = (ResponseUpdateGroupMessage) socketResponsedMessage;
                if (responseUpdateGroupMessage.getError() != 0) {
                    GroupInfoActivity.this.showToast(StringUtils.isNull(responseUpdateGroupMessage.getErrorString()) ? GroupInfoActivity.this.getResources().getString(R.string.neterror) : responseUpdateGroupMessage.getErrorString());
                } else if (responseUpdateGroupMessage.getOrginalMessage() instanceof RequestUpdateGroupMessage) {
                    int type = ((RequestUpdateGroupMessage) responseUpdateGroupMessage.getOrginalMessage()).getType();
                    switch (GroupInfoActivity.this.type) {
                        case 1:
                            if (type == 3) {
                                GroupInfoActivity.this.jdF.addPhotoData();
                                GroupInfoActivity.this.jdE.a(GroupInfoActivity.this.jdF.getData());
                                return;
                            }
                            return;
                        case 2:
                            if (type == 3) {
                                GroupInfoActivity.this.jdF.delePhotoData();
                                GroupInfoActivity.this.jdE.a(GroupInfoActivity.this.jdF.getData());
                                return;
                            }
                            return;
                        case 3:
                            if (type == 4) {
                                GroupInfoActivity.this.jdF.updataPortraitData();
                                GroupInfoActivity.this.jdE.a(GroupInfoActivity.this.jdF.getData());
                                return;
                            }
                            return;
                        case 4:
                            GroupInfoActivity.this.jdF.getData().getGroup().setFlag(GroupInfoActivity.this.iPW.getFlag());
                            GroupInfoActivity.this.jdF.getData().getGroup().setPosition(GroupInfoActivity.this.iPW.getPosition());
                            GroupInfoActivity.this.jdF.getData().getGroup().setBusiness(GroupInfoActivity.this.iPW.getBusiness());
                            if ((GroupInfoActivity.this.jdF.getData().getGroup().getFlag() & 1) == 1) {
                                GroupInfoActivity.this.jdE.qd(GroupInfoActivity.this.jdF.getData().cwq());
                            } else {
                                String position = GroupInfoActivity.this.jdF.getData().getGroup().getPosition();
                                String business = GroupInfoActivity.this.jdF.getData().getGroup().getBusiness();
                                StringBuffer stringBuffer = new StringBuffer();
                                if (position != null) {
                                    stringBuffer.append(position);
                                }
                                if (business != null) {
                                    stringBuffer.append(business);
                                }
                                GroupInfoActivity.this.jdE.q(GroupInfoActivity.this.jdF.getData().cwq(), stringBuffer.toString());
                            }
                            GroupInfoActivity.this.showToast(R.string.operation_success);
                            return;
                        default:
                            return;
                    }
                }
            } else if (socketResponsedMessage.getCmd() == 103112) {
                if (socketResponsedMessage instanceof ResponseRemoveMembersMessage) {
                    ResponseRemoveMembersMessage responseRemoveMembersMessage = (ResponseRemoveMembersMessage) socketResponsedMessage;
                    if (responseRemoveMembersMessage.getError() == 0 && (orginalMessage = responseRemoveMembersMessage.getOrginalMessage()) != null && (orginalMessage instanceof RequestRemoveMembersMessage)) {
                        RequestRemoveMembersMessage requestRemoveMembersMessage = (RequestRemoveMembersMessage) orginalMessage;
                        if (requestRemoveMembersMessage.getGroupId() == GroupInfoActivity.this.jdF.getGroupId()) {
                            String userIds = requestRemoveMembersMessage.getUserIds();
                            if (!TextUtils.isEmpty(userIds) && (split = userIds.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) != null && split.length != 0) {
                                String id = TbadkApplication.getCurrentAccountObj().getID();
                                if (!TextUtils.isEmpty(id)) {
                                    for (String str : split) {
                                        if (id.equals(str)) {
                                            ResponseGroupInfoLocalMessage.a data = GroupInfoActivity.this.jdF.getData();
                                            data.zf(data.cwo() + 1);
                                            data.qk(false);
                                            GroupInfoActivity.this.jdF.setHasRecentJoin(false);
                                            GroupInfoActivity.this.jdE.a(data, true);
                                            GroupInfoActivity.this.jdE.HW(str);
                                            GroupInfoActivity.this.cvr();
                                            return;
                                        }
                                        if (GroupInfoActivity.this.jdF.removeMemberByUid(str)) {
                                            GroupInfoActivity.this.jdE.HW(str);
                                            GroupData group = GroupInfoActivity.this.jdF.getData().getGroup();
                                            if (group != null && group.getMemberNum() > 1) {
                                                group.setMemberNum(group.getMemberNum() - 1);
                                            }
                                            GroupInfoActivity.this.jdE.setData(GroupInfoActivity.this.jdF.getData());
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            } else if (socketResponsedMessage.getCmd() == 103104) {
                if (socketResponsedMessage instanceof ResponseDismissGroupMessage) {
                    ResponseDismissGroupMessage responseDismissGroupMessage = (ResponseDismissGroupMessage) socketResponsedMessage;
                    if (responseDismissGroupMessage.getError() == 0 && GroupInfoActivity.this.jdF.getGroupId() == responseDismissGroupMessage.getGroupId()) {
                        GroupInfoActivity.this.finish();
                    }
                }
            } else if (socketResponsedMessage.getCmd() == 103105) {
                if (socketResponsedMessage instanceof ResponseUpgradeMemberGroupMessage) {
                    ResponseUpgradeMemberGroupMessage responseUpgradeMemberGroupMessage = (ResponseUpgradeMemberGroupMessage) socketResponsedMessage;
                    if (responseUpgradeMemberGroupMessage.getError() == 0 || responseUpgradeMemberGroupMessage.getError() == 2230110) {
                        GroupInfoActivity.this.startLoading();
                    }
                }
            } else if (socketResponsedMessage.getCmd() == 103120) {
                if (socketResponsedMessage instanceof ResponseCreateGroupActivityMessage) {
                    GroupInfoActivity.this.startLoading();
                }
            } else if (socketResponsedMessage.getCmd() == 103121 && (socketResponsedMessage instanceof ResponseDelGroupActivityMessage)) {
                GroupInfoActivity.this.startLoading();
            }
        }
    }

    public void b(GroupNewsPojo groupNewsPojo) {
        if (groupNewsPojo != null && this.jdF != null && this.jdF.getData() != null) {
            try {
                JSONObject jSONObject = new JSONObject(groupNewsPojo.getContent());
                String string = jSONObject.getJSONObject(TbEnum.SystemMessage.KEY_EVENT_PARAM).getString(TbEnum.SystemMessage.KEY_GROUP_ID);
                if (jSONObject.getString(TbEnum.SystemMessage.KEY_EVENT_ID).equals(TbEnum.SystemMessage.EVENT_ID_KICKED_OUT) && string.equals(String.valueOf(this.jdF.getGroupId())) && this.jdF.getData().cwp()) {
                    this.jdF.getData().qk(false);
                    GroupData group = this.jdF.getData().getGroup();
                    if (group != null && group.getMemberNum() > 1) {
                        group.setMemberNum(group.getMemberNum() - 1);
                    }
                    this.jdE.a(this.jdF.getData(), true);
                    cvr();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void f(GroupNewsPojo groupNewsPojo) {
        try {
            String optString = new JSONObject(groupNewsPojo.getContent()).optJSONObject(TbEnum.SystemMessage.KEY_EVENT_PARAM).optString(TbEnum.SystemMessage.KEY_GROUP_ID);
            if (!TextUtils.isEmpty(optString) && this.jdF != null && optString.equals(String.valueOf(this.jdF.getGroupId())) && this.jdF.getData() != null) {
                this.jdF.getData().qk(true);
                if (this.jdE != null) {
                    this.jdE.qf(true);
                    this.jdE.cvH();
                    cvr();
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(GroupNewsPojo groupNewsPojo) {
        if (groupNewsPojo != null && this.jdF != null && this.jdF.getData() != null) {
            try {
                JSONObject jSONObject = new JSONObject(groupNewsPojo.getContent());
                JSONObject jSONObject2 = jSONObject.getJSONObject(TbEnum.SystemMessage.KEY_EVENT_PARAM);
                String string = jSONObject2.getString(TbEnum.SystemMessage.KEY_GROUP_ID);
                if (jSONObject.getString(TbEnum.SystemMessage.KEY_EVENT_ID).equals(TbEnum.SystemMessage.EVENT_ID_GROUP_NAME_MODIFY) && string.equals(String.valueOf(this.jdF.getGroupId()))) {
                    String string2 = jSONObject2.getString(TbEnum.SystemMessage.KEY_GROUP_NAME);
                    if (!TextUtils.isEmpty(string2)) {
                        this.jdE.setGroupName(string2);
                        if (this.jdF.getData() != null && this.jdF.getData().getGroup() != null) {
                            this.jdF.getData().getGroup().setName(string2);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(GroupNewsPojo groupNewsPojo) {
        if (groupNewsPojo != null && this.jdF != null) {
            try {
                JSONObject jSONObject = new JSONObject(groupNewsPojo.getContent());
                String string = jSONObject.getJSONObject(TbEnum.SystemMessage.KEY_EVENT_PARAM).getString(TbEnum.SystemMessage.KEY_GROUP_ID);
                if (jSONObject.getString(TbEnum.SystemMessage.KEY_EVENT_ID).equals(TbEnum.SystemMessage.EVENT_ID_DISMISS_GROUP) && string.equals(String.valueOf(this.jdF.getGroupId()))) {
                    finish();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            closeActivity();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cvr() {
        if (this.jdF != null) {
            this.jdF.clearGroupInfoCache(String.valueOf(this.jdF.getGroupId()));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 1) {
            if (ad.checkCamera(getApplicationContext())) {
                an.g(getPageContext());
            } else {
                showToast(R.string.system_permission_prompt_camera);
            }
            ArrayMap<String, Boolean> transformPermissionResult = ad.transformPermissionResult(strArr, iArr);
            if (transformPermissionResult.containsKey("android.permission.WRITE_EXTERNAL_STORAGE") && !transformPermissionResult.get("android.permission.WRITE_EXTERNAL_STORAGE").booleanValue()) {
                showToast(R.string.sdcard_permission_denied_advert_for_camera);
            }
        }
    }
}
