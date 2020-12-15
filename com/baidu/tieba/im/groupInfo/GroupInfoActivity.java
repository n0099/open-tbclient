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
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.n.a.a;
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
import com.baidu.tbadk.core.util.ae;
import com.baidu.tbadk.core.util.af;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.coreExtra.data.PhotoUrlData;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.util.m;
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
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes23.dex */
public class GroupInfoActivity extends BaseActivity<GroupInfoActivity> implements View.OnClickListener, View.OnLongClickListener, a.InterfaceC0276a, c, d {
    private UpdateGroupModel kjr;
    private com.baidu.tieba.im.groupInfo.a kwQ;
    private GroupInfoModel kwR;
    private a kwS;
    private PermissionJudgePolicy mPermissionJudgement;
    private int type = 0;
    private final WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private long kwT = -1;
    private long kwU = -1;
    private final b.InterfaceC0586b kwV = new b.InterfaceC0586b() { // from class: com.baidu.tieba.im.groupInfo.GroupInfoActivity.1
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0586b
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            bVar.dismiss();
            if (i == 0) {
                GroupInfoActivity.this.cCM();
            } else if (i == 1) {
                AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(GroupInfoActivity.this.getPageContext().getPageActivity(), GroupInfoActivity.this.writeImagesInfo.toJsonString());
                albumActivityConfig.setRequestCode(RequestResponseCode.REQUEST_ALBUM_IMAGE);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
            }
        }
    };
    private final b kwW = new b() { // from class: com.baidu.tieba.im.groupInfo.GroupInfoActivity.2
        @Override // com.baidu.tieba.im.groupInfo.b
        public void a(i iVar, int i, Object obj, int i2) {
            if (iVar != null && iVar.isShowing()) {
                iVar.dismiss();
            }
            if (i == 0) {
                if (i2 != 0) {
                    GroupInfoActivity.this.aM(obj);
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
                GroupInfoActivity.this.kwQ.cYm();
                GroupInfoActivity.this.showToast(R.string.neterror);
            } else if (customResponsedMessage.getCmd() == 2001102) {
                if (!(customResponsedMessage instanceof ResponseGroupInfoLocalMessage)) {
                    GroupInfoActivity.this.kwR.sendMessage(GroupInfoActivity.this.kwR.getGroupId(), GroupInfoActivity.this.kwR.getFrom());
                    return;
                }
                ResponseGroupInfoLocalMessage responseGroupInfoLocalMessage = (ResponseGroupInfoLocalMessage) customResponsedMessage;
                if (responseGroupInfoLocalMessage.getOrginalMessage() == null || ((RequestGroupInfoLocalMessage) responseGroupInfoLocalMessage.getOrginalMessage()).getGroupId() == GroupInfoActivity.this.kwR.getGroupId()) {
                    if (responseGroupInfoLocalMessage.getError() != 0) {
                        GroupInfoActivity.this.kwR.sendMessage(GroupInfoActivity.this.kwR.getGroupId(), GroupInfoActivity.this.kwR.getFrom());
                        return;
                    }
                    GroupInfoActivity.this.Yq();
                    GroupInfoActivity.this.kwR.setData(responseGroupInfoLocalMessage.getData());
                    GroupInfoActivity.this.kwQ.setData(responseGroupInfoLocalMessage.getData());
                    GroupInfoActivity.this.cXX();
                }
            }
        }
    };
    private final CustomMessageListener kuo = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.groupInfo.GroupInfoActivity.4
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
        cXX();
        startLoading();
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        a((Bundle) null, intent);
        this.kwU = this.kwR.getGroupId();
        startLoading();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cXX() {
        if (this.kwR != null) {
            long groupId = this.kwR.getGroupId();
            this.kwU = groupId;
            this.kwT = groupId;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cXY() {
        if (this.kwT != this.kwU) {
            initUI();
            cXX();
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void initListener() {
        this.kwS = new a();
        registerListener(CmdConfigSocket.CMD_REQUEST_GROUP_INFO_BY_ID, this.kwS);
        registerListener(CmdConfigCustom.CMD_REQUEST_GROUP_INFO_BY_ID_LOCAL, this.mCustomListener);
        registerListener(CmdConfigSocket.CMD_UPDATE_GROUP, this.kwS);
        registerListener(CmdConfigSocket.CMD_REMOVE_MEMBERS, this.kwS);
        registerListener(CmdConfigSocket.CMD_JOIN_GROUP, this.kwS);
        registerListener(CmdConfigSocket.CMD_CREATE_GROUP_ACTIVITY, this.kwS);
        registerListener(CmdConfigSocket.CMD_DEL_GROUP_ACTIVITY, this.kwS);
        registerListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_KICK_OUT, this.kuo);
        registerListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_APPLY_JOIN_SUCCESS, this.kuo);
        registerListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_GROUP_NAME_CHANGE, this.kuo);
        registerListener(CmdConfigSocket.CMD_DISSMISS_GROUP, this.kwS);
        registerListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_DISMISS_GROUP, this.kuo);
        registerListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_GROUP_ACTIVITYS_CHANGE, this.kuo);
        registerListener(CmdConfigSocket.CMD_UPGRADE_MEMBER_GROUP, this.kwS);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.kwR.saveInstance(bundle);
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
        this.kwR.cancelMessage();
        MessageManager.getInstance().unRegisterListener(this.kuo);
        if (this.kwQ != null) {
            this.kwQ.onDestory();
        }
    }

    private void initUI() {
        this.kwQ = new com.baidu.tieba.im.groupInfo.a(this);
        this.kwQ.a(this.kwW);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startLoading() {
        this.kwQ.cYn();
        this.kwR.sendLocalMessage(this.kwR.getGroupId(), this.kwR.getFrom());
        this.kwR.sendMessage(this.kwR.getGroupId(), this.kwR.getFrom());
    }

    public void a(Bundle bundle, Intent intent) {
        this.kwR = new GroupInfoModel(this);
        this.kwR.setUniqueId(getUniqueId());
        if (bundle == null) {
            GroupInfoModel groupInfoModel = this.kwR;
            if (intent == null) {
                intent = getIntent();
            }
            groupInfoModel.initWithIntent(intent);
        } else {
            this.kwR.initWithBundle(bundle);
        }
        this.kjr = new UpdateGroupModel(getPageContext());
        this.kjr.setUniqueId(getUniqueId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Yq() {
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
        if (this.kwQ != null) {
            this.kwQ.changeSkinType(i);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.kwQ.cYo()) {
            if (this.kwR.getData() != null && this.kwR.getData().cYY()) {
                TiebaStatic.log("edit_place_at_groupinfo");
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupAddressLocateActivityConfig(getPageContext().getPageActivity(), RequestResponseCode.REQUEST_ADDRESS_VIEW, this.kwR.getData().getGroup().getPosition(), this.kwR.getData().getGroup().getBusiness(), (this.kwR.getData().getGroup().getFlag() & 1) == 1)));
            }
        } else if (view == this.kwQ.cWU()) {
            closeActivity();
        } else if (view != this.kwQ.cYb()) {
            if (view == this.kwQ.cYj()) {
                if (this.kwR.getData() != null && this.kwR.getData().getGroup() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), String.valueOf(this.kwR.getData().getGroup().getAuthorId()), this.kwR.getData().getGroup().getAuthorName())));
                }
            } else if (view == this.kwQ.cYk()) {
                if (this.kwR != null && this.kwR.getData() != null) {
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupLevelActivityConfig(getPageContext().getPageActivity(), this.kwR.getGroupId(), this.kwR.getData().isMemGroup())));
                }
            } else if (view == this.kwQ.cYi()) {
                if (TextUtils.isEmpty(TbadkApplication.getCurrentAccount())) {
                    TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getPageContext().getPageActivity(), true, 3)));
                } else if (this.kwR.getData() != null) {
                    if (this.kwR.getData().cYX()) {
                        if (this.kwR.getData().getGroup() != null) {
                            TiebaStatic.log(new ar("c10334").dY("obj_type", String.valueOf(this.kwR.getData().getGroup().getGroupId())));
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(getPageContext().getPageActivity(), this.kwR.getGroupId(), this.kwR.getData().getGroup().getName(), this.kwR.getData().getGroup().getAuthorId(), "group_info")));
                        }
                    } else if (this.kwR.hasRecentJoin()) {
                        showToast(R.string.has_recent_join);
                    } else if (this.kwR.getData() != null) {
                        if (this.kwR.getData().cYW() <= 0) {
                            showToast(R.string.add_group_max);
                        } else if (ApplyJoinGroupActivityConfig.JOINTYPE_DEFAULT == this.kwR.getJoinType()) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IM_APPLE_JOIN_GROUP_ACTIVITY_START, new ApplyJoinGroupActivityConfig(getPageContext().getPageActivity(), "" + this.kwR.getGroupId(), this.kwR.getData().cYV(), this.kwR.getData().cYW())));
                        } else if (ApplyJoinGroupActivityConfig.JOINTYPE_INVITE == this.kwR.getJoinType()) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IM_APPLE_JOIN_GROUP_ACTIVITY_START, new ApplyJoinGroupActivityConfig(getPageContext().getPageActivity(), "" + this.kwR.getGroupId(), this.kwR.getData().cYV(), this.kwR.getData().cYW(), this.kwR.getInviteUserId(), this.kwR.getDefaultUserMsg())));
                        }
                    }
                }
            } else if (view == this.kwQ.cYh()) {
                if (this.kwR.getData() != null && this.kwR.getData().getGroup() != null) {
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupSettingActivityConfig(getPageContext().getPageActivity(), 4, this.kwR.getData().getGroup().getName(), "" + this.kwR.getGroupId(), this.kwR.getData().cYY(), this.kwR.getData().getGroup().getFlag())));
                }
            } else if (view == this.kwQ.cYf()) {
                if (this.kwR.getData() != null && this.kwR.getData().getGroup() != null) {
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UpdateGroupActivityConfig(getPageContext().getPageActivity(), 1, this.kwR.getGroupId(), 1, this.kwR.getData().getGroup().getName())));
                }
            } else if (view == this.kwQ.cYe()) {
                if (this.kwR.getData() != null && this.kwR.getData().cYY() && this.kwR.getData().getGroup() != null) {
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UpdateGroupActivityConfig(getPageContext().getPageActivity(), 2, this.kwR.getGroupId(), 2, this.kwR.getData().getGroup().getIntro())));
                }
            } else if (view == this.kwQ.cYl() || view == this.kwQ.cYc()) {
                MembersActivity.f(getPageContext().getPageActivity(), this.kwR.getGroupId());
            } else if (view == this.kwQ.cYd()) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new InviteFriendListActivityConfig(getPageContext().getPageActivity(), 0L, this.kwR.getGroupId())));
            } else if (view == this.kwQ.cYg() && this.kwR.getData() != null && this.kwR.getData().cYX()) {
                GroupActivityData cYS = this.kwR.getData().cYS();
                if (cYS != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupActivityActivityConfig(getPageContext().getPageActivity(), cYS.getActivityId(), this.kwR.getGroupId(), 0)));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CreateGroupActivityActivityConfig(getPageContext().getPageActivity(), this.kwR.getGroupId())));
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
    public void a(View view, Object obj, int i) {
        this.kwQ.d(obj, i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        if (view == this.kwQ.cYa()) {
            if (this.kwR.getData() == null || this.kwR.getData().getGroup() == null) {
                return false;
            }
            this.kwQ.NG(String.valueOf(this.kwR.getData().getGroup().getGroupId()));
            return false;
        } else if (view != this.kwQ.cYe() || this.kwR.getData().cYY()) {
            return false;
        } else {
            if (this.kwR.getData() != null && this.kwR.getData().getGroup() != null) {
                this.kwQ.NF(String.valueOf(this.kwR.getData().getGroup().getIntro()));
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
            ArrayList<String> bigUrlList = this.kwR.getBigUrlList();
            HashMap<String, ImageUrlData> assistUrls = this.kwR.getAssistUrls();
            if (obj != null && (obj instanceof PhotoUrlData) && bigUrlList != null) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupImageActivityConfig(getPageContext().getPageActivity(), ((PhotoUrlData) obj).getBigurl(), bigUrlList, this.kwR.getGroupId(), assistUrls)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cCM() {
        if (!ae.requestWriteExternalStorgeAndCameraPermission(getPageContext().getPageActivity(), 1)) {
            ao.g(getPageContext());
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
                        if (this.kwQ != null) {
                            this.kwQ.setGroupName(stringExtra);
                        }
                        if (this.kwR != null && this.kwR.getData() != null && this.kwR.getData().getGroup() != null) {
                            this.kwR.getData().getGroup().setName(stringExtra);
                            return;
                        }
                        return;
                    }
                    return;
                case 2:
                    if (intent != null) {
                        String stringExtra2 = intent.getStringExtra(UpdateGroupActivityConfig.GROUP_TEXT);
                        if (this.kwQ != null) {
                            this.kwQ.ND(stringExtra2);
                        }
                        if (this.kwR != null && this.kwR.getData() != null && this.kwR.getData().getGroup() != null) {
                            this.kwR.getData().getGroup().setIntro(stringExtra2);
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
                        if (this.kwR != null && this.kwR.getData() != null && this.kwR.getData().getGroup() != null) {
                            this.kwR.getData().getGroup().setFlag(intExtra);
                            return;
                        }
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_ALBUM_IMAGE /* 12002 */:
                    if (intent != null) {
                        intent.getBooleanExtra("camera_result", false);
                        Y(intent);
                        break;
                    } else {
                        return;
                    }
                case RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW /* 12009 */:
                case RequestResponseCode.REQUEST_CAMERA_VIEW /* 12010 */:
                    break;
                case RequestResponseCode.REQUEST_ADDRESS_VIEW /* 21001 */:
                    n(intent.getBooleanExtra("ResultDataIsHiddenAddress", true) ? 1 : 0, intent.getStringExtra("ResultDataAddress"), intent.getStringExtra("ResultDataSelectedBusiness"));
                    return;
                default:
                    return;
            }
            PhotoUrlData photoUrlData = (PhotoUrlData) intent.getSerializableExtra(EditHeadActivityConfig.PIC_INFO);
            if (photoUrlData != null) {
                af.btE().c(photoUrlData.getSmallurl(), n.getFileDireciory(TbConfig.GROUP_HEAD_FILE), true, false, true);
            }
            b(photoUrlData);
        } else if (i2 == 0 && i == 12010) {
            cCM();
        }
    }

    private void Y(Intent intent) {
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
            NB(this.kwR.generateDeleAlbum(photoUrlData));
        }
    }

    private void b(PhotoUrlData photoUrlData) {
        this.type = 1;
        if (photoUrlData != null) {
            String generateAddAlbum = this.kwR.generateAddAlbum(photoUrlData);
            if (!TextUtils.isEmpty(generateAddAlbum)) {
                NB(generateAddAlbum);
            }
        }
    }

    private void n(int i, String str, String str2) {
        this.type = 4;
        if (this.kjr != null) {
            this.kjr.setGroupId(this.kwR.getGroupId());
            this.kjr.setFlag(i);
            this.kjr.setPosition(str);
            this.kjr.setBusiness(str2);
            this.kjr.sendMessage(5);
            this.kwQ.cYn();
        }
    }

    private void NB(String str) {
        if (this.kjr != null) {
            this.kjr.setGroupId(this.kwR.getGroupId());
            this.kjr.setAlbum(str);
            this.kjr.sendMessage(3);
            this.kwQ.cYn();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aM(Object obj) {
        GroupCardModel.cXN();
        this.type = 3;
        if (obj != null && (obj instanceof PhotoUrlData)) {
            PhotoUrlData photoUrlData = (PhotoUrlData) obj;
            this.kwR.setChangePhotoUrlData(photoUrlData);
            String picId = photoUrlData.getPicId();
            if (this.kjr != null) {
                this.kjr.setGroupId(this.kwR.getGroupId());
                this.kjr.setPortrait(picId);
                this.kjr.sendMessage(4);
                this.kwQ.cYn();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes23.dex */
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
                GroupInfoActivity.this.kwQ.cYm();
                GroupInfoActivity.this.showToast(R.string.neterror);
            } else if (socketResponsedMessage.getCmd() == 103004) {
                GroupInfoActivity.this.kwQ.cYm();
                final ResponseGroupInfoMessage responseGroupInfoMessage = (ResponseGroupInfoMessage) socketResponsedMessage;
                if (GroupInfoActivity.this.kwR.getSendMsg() == responseGroupInfoMessage.getOrginalMessage()) {
                    if (responseGroupInfoMessage.getError() == 2230101) {
                        GroupInfoActivity.this.showToast(StringUtils.isNull(responseGroupInfoMessage.getErrorString()) ? GroupInfoActivity.this.getResources().getString(R.string.neterror) : responseGroupInfoMessage.getErrorString(), false);
                        GroupInfoActivity.this.finish();
                    } else if (responseGroupInfoMessage.getData() != null && responseGroupInfoMessage.getError() == 0) {
                        GroupInfoActivity.this.cXX();
                        GroupInfoActivity.this.Yq();
                        GroupInfoActivity.this.kwR.setData(responseGroupInfoMessage.getData());
                        if (responseGroupInfoMessage == null || responseGroupInfoMessage.getData().cYX()) {
                            GroupInfoActivity.this.kwQ.a(responseGroupInfoMessage.getData(), false);
                            return;
                        }
                        GroupInfoActivity.this.kwQ.cYn();
                        com.baidu.tieba.im.settingcache.b.cZX().a(TbadkApplication.getCurrentAccount(), String.valueOf(GroupInfoActivity.this.kwR.getGroupId()), 60000L, new m<Boolean>() { // from class: com.baidu.tieba.im.groupInfo.GroupInfoActivity.a.1
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.tbadk.util.m
                            public void onReturnDataInUI(Boolean bool) {
                                if (bool == null) {
                                    bool = false;
                                }
                                GroupInfoActivity.this.kwQ.cYm();
                                GroupInfoActivity.this.kwQ.a(responseGroupInfoMessage.getData(), bool.booleanValue());
                                GroupInfoActivity.this.kwR.setHasRecentJoin(bool.booleanValue() ? false : true);
                            }
                        });
                    } else {
                        GroupInfoActivity.this.showToast(R.string.neterror);
                        GroupInfoActivity.this.cXY();
                    }
                }
            } else if (socketResponsedMessage.getCmd() == 103110) {
                if (socketResponsedMessage instanceof ResponseJoinGroupMessage) {
                    ResponseJoinGroupMessage responseJoinGroupMessage = (ResponseJoinGroupMessage) socketResponsedMessage;
                    if (responseJoinGroupMessage.getError() == 0 && (orginalMessage2 = responseJoinGroupMessage.getOrginalMessage()) != null && (orginalMessage2 instanceof RequestJoinGroupMessage) && ((RequestJoinGroupMessage) orginalMessage2).getGroupId() == GroupInfoActivity.this.kwR.getGroupId()) {
                        GroupInfoActivity.this.kwQ.cYr();
                        GroupInfoActivity.this.kwR.setHasRecentJoin(true);
                        GroupInfoActivity.this.cXZ();
                    }
                }
            } else if (socketResponsedMessage.getCmd() == 103102) {
                GroupInfoActivity.this.kwQ.cYm();
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
                                GroupInfoActivity.this.kwR.addPhotoData();
                                GroupInfoActivity.this.kwQ.a(GroupInfoActivity.this.kwR.getData());
                                return;
                            }
                            return;
                        case 2:
                            if (type == 3) {
                                GroupInfoActivity.this.kwR.delePhotoData();
                                GroupInfoActivity.this.kwQ.a(GroupInfoActivity.this.kwR.getData());
                                return;
                            }
                            return;
                        case 3:
                            if (type == 4) {
                                GroupInfoActivity.this.kwR.updataPortraitData();
                                GroupInfoActivity.this.kwQ.a(GroupInfoActivity.this.kwR.getData());
                                return;
                            }
                            return;
                        case 4:
                            GroupInfoActivity.this.kwR.getData().getGroup().setFlag(GroupInfoActivity.this.kjr.getFlag());
                            GroupInfoActivity.this.kwR.getData().getGroup().setPosition(GroupInfoActivity.this.kjr.getPosition());
                            GroupInfoActivity.this.kwR.getData().getGroup().setBusiness(GroupInfoActivity.this.kjr.getBusiness());
                            if ((GroupInfoActivity.this.kwR.getData().getGroup().getFlag() & 1) == 1) {
                                GroupInfoActivity.this.kwQ.sF(GroupInfoActivity.this.kwR.getData().cYY());
                            } else {
                                String position = GroupInfoActivity.this.kwR.getData().getGroup().getPosition();
                                String business = GroupInfoActivity.this.kwR.getData().getGroup().getBusiness();
                                StringBuffer stringBuffer = new StringBuffer();
                                if (position != null) {
                                    stringBuffer.append(position);
                                }
                                if (business != null) {
                                    stringBuffer.append(business);
                                }
                                GroupInfoActivity.this.kwQ.u(GroupInfoActivity.this.kwR.getData().cYY(), stringBuffer.toString());
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
                        if (requestRemoveMembersMessage.getGroupId() == GroupInfoActivity.this.kwR.getGroupId()) {
                            String userIds = requestRemoveMembersMessage.getUserIds();
                            if (!TextUtils.isEmpty(userIds) && (split = userIds.split(",")) != null && split.length != 0) {
                                String id = TbadkApplication.getCurrentAccountObj().getID();
                                if (!TextUtils.isEmpty(id)) {
                                    for (String str : split) {
                                        if (id.equals(str)) {
                                            ResponseGroupInfoLocalMessage.a data = GroupInfoActivity.this.kwR.getData();
                                            data.Ey(data.cYW() + 1);
                                            data.sM(false);
                                            GroupInfoActivity.this.kwR.setHasRecentJoin(false);
                                            GroupInfoActivity.this.kwQ.a(data, true);
                                            GroupInfoActivity.this.kwQ.NE(str);
                                            GroupInfoActivity.this.cXZ();
                                            return;
                                        }
                                        if (GroupInfoActivity.this.kwR.removeMemberByUid(str)) {
                                            GroupInfoActivity.this.kwQ.NE(str);
                                            GroupData group = GroupInfoActivity.this.kwR.getData().getGroup();
                                            if (group != null && group.getMemberNum() > 1) {
                                                group.setMemberNum(group.getMemberNum() - 1);
                                            }
                                            GroupInfoActivity.this.kwQ.setData(GroupInfoActivity.this.kwR.getData());
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
                    if (responseDismissGroupMessage.getError() == 0 && GroupInfoActivity.this.kwR.getGroupId() == responseDismissGroupMessage.getGroupId()) {
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
        if (groupNewsPojo != null && this.kwR != null && this.kwR.getData() != null) {
            try {
                JSONObject jSONObject = new JSONObject(groupNewsPojo.getContent());
                String string = jSONObject.getJSONObject(TbEnum.SystemMessage.KEY_EVENT_PARAM).getString(TbEnum.SystemMessage.KEY_GROUP_ID);
                if (jSONObject.getString(TbEnum.SystemMessage.KEY_EVENT_ID).equals(TbEnum.SystemMessage.EVENT_ID_KICKED_OUT) && string.equals(String.valueOf(this.kwR.getGroupId())) && this.kwR.getData().cYX()) {
                    this.kwR.getData().sM(false);
                    GroupData group = this.kwR.getData().getGroup();
                    if (group != null && group.getMemberNum() > 1) {
                        group.setMemberNum(group.getMemberNum() - 1);
                    }
                    this.kwQ.a(this.kwR.getData(), true);
                    cXZ();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void f(GroupNewsPojo groupNewsPojo) {
        try {
            String optString = new JSONObject(groupNewsPojo.getContent()).optJSONObject(TbEnum.SystemMessage.KEY_EVENT_PARAM).optString(TbEnum.SystemMessage.KEY_GROUP_ID);
            if (!TextUtils.isEmpty(optString) && this.kwR != null && optString.equals(String.valueOf(this.kwR.getGroupId())) && this.kwR.getData() != null) {
                this.kwR.getData().sM(true);
                if (this.kwQ != null) {
                    this.kwQ.sH(true);
                    this.kwQ.cYp();
                    cXZ();
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(GroupNewsPojo groupNewsPojo) {
        if (groupNewsPojo != null && this.kwR != null && this.kwR.getData() != null) {
            try {
                JSONObject jSONObject = new JSONObject(groupNewsPojo.getContent());
                JSONObject jSONObject2 = jSONObject.getJSONObject(TbEnum.SystemMessage.KEY_EVENT_PARAM);
                String string = jSONObject2.getString(TbEnum.SystemMessage.KEY_GROUP_ID);
                if (jSONObject.getString(TbEnum.SystemMessage.KEY_EVENT_ID).equals(TbEnum.SystemMessage.EVENT_ID_GROUP_NAME_MODIFY) && string.equals(String.valueOf(this.kwR.getGroupId()))) {
                    String string2 = jSONObject2.getString(TbEnum.SystemMessage.KEY_GROUP_NAME);
                    if (!TextUtils.isEmpty(string2)) {
                        this.kwQ.setGroupName(string2);
                        if (this.kwR.getData() != null && this.kwR.getData().getGroup() != null) {
                            this.kwR.getData().getGroup().setName(string2);
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
        if (groupNewsPojo != null && this.kwR != null) {
            try {
                JSONObject jSONObject = new JSONObject(groupNewsPojo.getContent());
                String string = jSONObject.getJSONObject(TbEnum.SystemMessage.KEY_EVENT_PARAM).getString(TbEnum.SystemMessage.KEY_GROUP_ID);
                if (jSONObject.getString(TbEnum.SystemMessage.KEY_EVENT_ID).equals(TbEnum.SystemMessage.EVENT_ID_DISMISS_GROUP) && string.equals(String.valueOf(this.kwR.getGroupId()))) {
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
    public void cXZ() {
        if (this.kwR != null) {
            this.kwR.clearGroupInfoCache(String.valueOf(this.kwR.getGroupId()));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 1) {
            if (ae.checkCamera(getApplicationContext())) {
                ao.g(getPageContext());
            } else {
                showToast(R.string.system_permission_prompt_camera);
            }
            ArrayMap<String, Boolean> transformPermissionResult = ae.transformPermissionResult(strArr, iArr);
            if (transformPermissionResult.containsKey("android.permission.WRITE_EXTERNAL_STORAGE") && !transformPermissionResult.get("android.permission.WRITE_EXTERNAL_STORAGE").booleanValue()) {
                showToast(R.string.sdcard_permission_denied_advert_for_camera);
            }
        }
    }
}
