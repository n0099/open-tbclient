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
import com.baidu.k.a.a;
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
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.ac;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.m;
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
/* loaded from: classes8.dex */
public class GroupInfoActivity extends BaseActivity<GroupInfoActivity> implements View.OnClickListener, View.OnLongClickListener, a.InterfaceC0072a, c, d {
    private com.baidu.tieba.im.groupInfo.a hBo;
    private GroupInfoModel hBp;
    private a hBq;
    private UpdateGroupModel hpJ;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgement;
    private int type = 0;
    private final WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private long hBr = -1;
    private long hBs = -1;
    private final b.a hBt = new b.a() { // from class: com.baidu.tieba.im.groupInfo.GroupInfoActivity.1
        @Override // com.baidu.tbadk.core.dialog.b.a
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            bVar.dismiss();
            if (i == 0) {
                GroupInfoActivity.this.bCM();
            } else if (i == 1) {
                AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(GroupInfoActivity.this.getPageContext().getPageActivity(), GroupInfoActivity.this.writeImagesInfo.toJsonString());
                albumActivityConfig.setRequestCode(RequestResponseCode.REQUEST_ALBUM_IMAGE);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
            }
        }
    };
    private final b hBu = new b() { // from class: com.baidu.tieba.im.groupInfo.GroupInfoActivity.2
        @Override // com.baidu.tieba.im.groupInfo.b
        public void a(i iVar, int i, Object obj, int i2) {
            if (iVar != null && iVar.isShowing()) {
                iVar.dismiss();
            }
            if (i == 0) {
                if (i2 != 0) {
                    GroupInfoActivity.this.au(obj);
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
                GroupInfoActivity.this.hBo.bUO();
                GroupInfoActivity.this.showToast(R.string.neterror);
            } else if (customResponsedMessage.getCmd() == 2001102) {
                if (!(customResponsedMessage instanceof ResponseGroupInfoLocalMessage)) {
                    GroupInfoActivity.this.hBp.sendMessage(GroupInfoActivity.this.hBp.getGroupId(), GroupInfoActivity.this.hBp.getFrom());
                    return;
                }
                ResponseGroupInfoLocalMessage responseGroupInfoLocalMessage = (ResponseGroupInfoLocalMessage) customResponsedMessage;
                if (responseGroupInfoLocalMessage.getOrginalMessage() == null || ((RequestGroupInfoLocalMessage) responseGroupInfoLocalMessage.getOrginalMessage()).getGroupId() == GroupInfoActivity.this.hBp.getGroupId()) {
                    if (responseGroupInfoLocalMessage.getError() != 0) {
                        GroupInfoActivity.this.hBp.sendMessage(GroupInfoActivity.this.hBp.getGroupId(), GroupInfoActivity.this.hBp.getFrom());
                        return;
                    }
                    GroupInfoActivity.this.loadImage();
                    GroupInfoActivity.this.hBp.setData(responseGroupInfoLocalMessage.getData());
                    GroupInfoActivity.this.hBo.setData(responseGroupInfoLocalMessage.getData());
                    GroupInfoActivity.this.bUz();
                }
            }
        }
    };
    private final CustomMessageListener hyK = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.groupInfo.GroupInfoActivity.4
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
        bUz();
        startLoading();
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        a((Bundle) null, intent);
        this.hBs = this.hBp.getGroupId();
        startLoading();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bUz() {
        if (this.hBp != null) {
            long groupId = this.hBp.getGroupId();
            this.hBs = groupId;
            this.hBr = groupId;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bUA() {
        if (this.hBr != this.hBs) {
            initUI();
            bUz();
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void initListener() {
        this.hBq = new a();
        registerListener(CmdConfigSocket.CMD_REQUEST_GROUP_INFO_BY_ID, this.hBq);
        registerListener(CmdConfigCustom.CMD_REQUEST_GROUP_INFO_BY_ID_LOCAL, this.mCustomListener);
        registerListener(CmdConfigSocket.CMD_UPDATE_GROUP, this.hBq);
        registerListener(CmdConfigSocket.CMD_REMOVE_MEMBERS, this.hBq);
        registerListener(CmdConfigSocket.CMD_JOIN_GROUP, this.hBq);
        registerListener(CmdConfigSocket.CMD_CREATE_GROUP_ACTIVITY, this.hBq);
        registerListener(CmdConfigSocket.CMD_DEL_GROUP_ACTIVITY, this.hBq);
        registerListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_KICK_OUT, this.hyK);
        registerListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_APPLY_JOIN_SUCCESS, this.hyK);
        registerListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_GROUP_NAME_CHANGE, this.hyK);
        registerListener(CmdConfigSocket.CMD_DISSMISS_GROUP, this.hBq);
        registerListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_DISMISS_GROUP, this.hyK);
        registerListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_GROUP_ACTIVITYS_CHANGE, this.hyK);
        registerListener(CmdConfigSocket.CMD_UPGRADE_MEMBER_GROUP, this.hBq);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.hBp.saveInstance(bundle);
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
        this.hBp.cancelMessage();
        MessageManager.getInstance().unRegisterListener(this.hyK);
        if (this.hBo != null) {
            this.hBo.onDestory();
        }
    }

    private void initUI() {
        this.hBo = new com.baidu.tieba.im.groupInfo.a(this);
        this.hBo.a(this.hBu);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startLoading() {
        this.hBo.bUP();
        this.hBp.sendLocalMessage(this.hBp.getGroupId(), this.hBp.getFrom());
        this.hBp.sendMessage(this.hBp.getGroupId(), this.hBp.getFrom());
    }

    public void a(Bundle bundle, Intent intent) {
        this.hBp = new GroupInfoModel(this);
        this.hBp.setUniqueId(getUniqueId());
        if (bundle == null) {
            GroupInfoModel groupInfoModel = this.hBp;
            if (intent == null) {
                intent = getIntent();
            }
            groupInfoModel.initWithIntent(intent);
        } else {
            this.hBp.initWithBundle(bundle);
        }
        this.hpJ = new UpdateGroupModel(getPageContext());
        this.hpJ.setUniqueId(getUniqueId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadImage() {
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
        if (this.hBo != null) {
            this.hBo.changeSkinType(i);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hBo.bUQ()) {
            if (this.hBp.getData() != null && this.hBp.getData().bVA()) {
                TiebaStatic.log("edit_place_at_groupinfo");
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupAddressLocateActivityConfig(getPageContext().getPageActivity(), RequestResponseCode.REQUEST_ADDRESS_VIEW, this.hBp.getData().getGroup().getPosition(), this.hBp.getData().getGroup().getBusiness(), (this.hBp.getData().getGroup().getFlag() & 1) == 1)));
            }
        } else if (view == this.hBo.bTw()) {
            closeActivity();
        } else if (view != this.hBo.bUD()) {
            if (view == this.hBo.bUL()) {
                if (this.hBp.getData() != null && this.hBp.getData().getGroup() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), String.valueOf(this.hBp.getData().getGroup().getAuthorId()), this.hBp.getData().getGroup().getAuthorName())));
                }
            } else if (view == this.hBo.bUM()) {
                if (this.hBp != null && this.hBp.getData() != null) {
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupLevelActivityConfig(getPageContext().getPageActivity(), this.hBp.getGroupId(), this.hBp.getData().isMemGroup())));
                }
            } else if (view == this.hBo.bUK()) {
                if (TextUtils.isEmpty(TbadkApplication.getCurrentAccount())) {
                    TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getPageContext().getPageActivity(), true, 3)));
                } else if (this.hBp.getData() != null) {
                    if (this.hBp.getData().bVz()) {
                        if (this.hBp.getData().getGroup() != null) {
                            TiebaStatic.log(new an("c10334").cp("obj_type", String.valueOf(this.hBp.getData().getGroup().getGroupId())));
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(getPageContext().getPageActivity(), this.hBp.getGroupId(), this.hBp.getData().getGroup().getName(), this.hBp.getData().getGroup().getAuthorId(), "group_info")));
                        }
                    } else if (this.hBp.hasRecentJoin()) {
                        showToast(R.string.has_recent_join);
                    } else if (this.hBp.getData() != null) {
                        if (this.hBp.getData().bVy() <= 0) {
                            showToast(R.string.add_group_max);
                        } else if (ApplyJoinGroupActivityConfig.JOINTYPE_DEFAULT == this.hBp.getJoinType()) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IM_APPLE_JOIN_GROUP_ACTIVITY_START, new ApplyJoinGroupActivityConfig(getPageContext().getPageActivity(), "" + this.hBp.getGroupId(), this.hBp.getData().bVx(), this.hBp.getData().bVy())));
                        } else if (ApplyJoinGroupActivityConfig.JOINTYPE_INVITE == this.hBp.getJoinType()) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IM_APPLE_JOIN_GROUP_ACTIVITY_START, new ApplyJoinGroupActivityConfig(getPageContext().getPageActivity(), "" + this.hBp.getGroupId(), this.hBp.getData().bVx(), this.hBp.getData().bVy(), this.hBp.getInviteUserId(), this.hBp.getDefaultUserMsg())));
                        }
                    }
                }
            } else if (view == this.hBo.bUJ()) {
                if (this.hBp.getData() != null && this.hBp.getData().getGroup() != null) {
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupSettingActivityConfig(getPageContext().getPageActivity(), 4, this.hBp.getData().getGroup().getName(), "" + this.hBp.getGroupId(), this.hBp.getData().bVA(), this.hBp.getData().getGroup().getFlag())));
                }
            } else if (view == this.hBo.bUH()) {
                if (this.hBp.getData() != null && this.hBp.getData().getGroup() != null) {
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UpdateGroupActivityConfig(getPageContext().getPageActivity(), 1, this.hBp.getGroupId(), 1, this.hBp.getData().getGroup().getName())));
                }
            } else if (view == this.hBo.bUG()) {
                if (this.hBp.getData() != null && this.hBp.getData().bVA() && this.hBp.getData().getGroup() != null) {
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UpdateGroupActivityConfig(getPageContext().getPageActivity(), 2, this.hBp.getGroupId(), 2, this.hBp.getData().getGroup().getIntro())));
                }
            } else if (view == this.hBo.bUN() || view == this.hBo.bUE()) {
                MembersActivity.e(getPageContext().getPageActivity(), this.hBp.getGroupId());
            } else if (view == this.hBo.bUF()) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new InviteFriendListActivityConfig(getPageContext().getPageActivity(), 0L, this.hBp.getGroupId())));
            } else if (view == this.hBo.bUI() && this.hBp.getData() != null && this.hBp.getData().bVz()) {
                GroupActivityData bVu = this.hBp.getData().bVu();
                if (bVu != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupActivityActivityConfig(getPageContext().getPageActivity(), bVu.getActivityId(), this.hBp.getGroupId(), 0)));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CreateGroupActivityActivityConfig(getPageContext().getPageActivity(), this.hBp.getGroupId())));
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
    public void b(View view, Object obj, int i) {
        this.hBo.c(obj, i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        if (view == this.hBo.bUC()) {
            if (this.hBp.getData() == null || this.hBp.getData().getGroup() == null) {
                return false;
            }
            this.hBo.CW(String.valueOf(this.hBp.getData().getGroup().getGroupId()));
            return false;
        } else if (view != this.hBo.bUG() || this.hBp.getData().bVA()) {
            return false;
        } else {
            if (this.hBp.getData() != null && this.hBp.getData().getGroup() != null) {
                this.hBo.CV(String.valueOf(this.hBp.getData().getGroup().getIntro()));
            }
            return true;
        }
    }

    @Override // com.baidu.tieba.im.groupInfo.c
    public void a(View view, int i, Object obj, int i2) {
        if (i == 2) {
            Activity pageActivity = getPageContext().getPageActivity();
            if (this.mPermissionJudgement == null) {
                this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
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
            ArrayList<String> bigUrlList = this.hBp.getBigUrlList();
            HashMap<String, ImageUrlData> assistUrls = this.hBp.getAssistUrls();
            if (obj != null && (obj instanceof PhotoUrlData) && bigUrlList != null) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupImageActivityConfig(getPageContext().getPageActivity(), ((PhotoUrlData) obj).getBigurl(), bigUrlList, this.hBp.getGroupId(), assistUrls)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bCM() {
        if (!ab.requestWriteExternalStorgeAndCameraPermission(getPageContext().getPageActivity(), 1)) {
            al.e(getPageContext());
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
                        if (this.hBo != null) {
                            this.hBo.setGroupName(stringExtra);
                        }
                        if (this.hBp != null && this.hBp.getData() != null && this.hBp.getData().getGroup() != null) {
                            this.hBp.getData().getGroup().setName(stringExtra);
                            return;
                        }
                        return;
                    }
                    return;
                case 2:
                    if (intent != null) {
                        String stringExtra2 = intent.getStringExtra(UpdateGroupActivityConfig.GROUP_TEXT);
                        if (this.hBo != null) {
                            this.hBo.CT(stringExtra2);
                        }
                        if (this.hBp != null && this.hBp.getData() != null && this.hBp.getData().getGroup() != null) {
                            this.hBp.getData().getGroup().setIntro(stringExtra2);
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
                        if (this.hBp != null && this.hBp.getData() != null && this.hBp.getData().getGroup() != null) {
                            this.hBp.getData().getGroup().setFlag(intExtra);
                            return;
                        }
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_ALBUM_IMAGE /* 12002 */:
                    if (intent != null) {
                        intent.getBooleanExtra("camera_result", false);
                        ap(intent);
                        break;
                    } else {
                        return;
                    }
                case RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW /* 12009 */:
                case RequestResponseCode.REQUEST_CAMERA_VIEW /* 12010 */:
                    break;
                case RequestResponseCode.REQUEST_ADDRESS_VIEW /* 21001 */:
                    j(intent.getBooleanExtra("ResultDataIsHiddenAddress", true) ? 1 : 0, intent.getStringExtra("ResultDataAddress"), intent.getStringExtra("ResultDataSelectedBusiness"));
                    return;
                default:
                    return;
            }
            PhotoUrlData photoUrlData = (PhotoUrlData) intent.getSerializableExtra(EditHeadActivityConfig.PIC_INFO);
            if (photoUrlData != null) {
                ac.aEa().c(photoUrlData.getSmallurl(), m.getFileDireciory(TbConfig.GROUP_HEAD_FILE), true, false, true);
            }
            b(photoUrlData);
        } else if (i2 == 0 && i == 12010) {
            bCM();
        }
    }

    private void ap(Intent intent) {
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
            CR(this.hBp.generateDeleAlbum(photoUrlData));
        }
    }

    private void b(PhotoUrlData photoUrlData) {
        this.type = 1;
        if (photoUrlData != null) {
            String generateAddAlbum = this.hBp.generateAddAlbum(photoUrlData);
            if (!TextUtils.isEmpty(generateAddAlbum)) {
                CR(generateAddAlbum);
            }
        }
    }

    private void j(int i, String str, String str2) {
        this.type = 4;
        if (this.hpJ != null) {
            this.hpJ.setGroupId(this.hBp.getGroupId());
            this.hpJ.setFlag(i);
            this.hpJ.setPosition(str);
            this.hpJ.setBusiness(str2);
            this.hpJ.sendMessage(5);
            this.hBo.bUP();
        }
    }

    private void CR(String str) {
        if (this.hpJ != null) {
            this.hpJ.setGroupId(this.hBp.getGroupId());
            this.hpJ.setAlbum(str);
            this.hpJ.sendMessage(3);
            this.hBo.bUP();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void au(Object obj) {
        GroupCardModel.bUp();
        this.type = 3;
        if (obj != null && (obj instanceof PhotoUrlData)) {
            PhotoUrlData photoUrlData = (PhotoUrlData) obj;
            this.hBp.setChangePhotoUrlData(photoUrlData);
            String picId = photoUrlData.getPicId();
            if (this.hpJ != null) {
                this.hpJ.setGroupId(this.hBp.getGroupId());
                this.hpJ.setPortrait(picId);
                this.hpJ.sendMessage(4);
                this.hBo.bUP();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
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
                GroupInfoActivity.this.hBo.bUO();
                GroupInfoActivity.this.showToast(R.string.neterror);
            } else if (socketResponsedMessage.getCmd() == 103004) {
                GroupInfoActivity.this.hBo.bUO();
                final ResponseGroupInfoMessage responseGroupInfoMessage = (ResponseGroupInfoMessage) socketResponsedMessage;
                if (GroupInfoActivity.this.hBp.getSendMsg() == responseGroupInfoMessage.getOrginalMessage()) {
                    if (responseGroupInfoMessage.getError() == 2230101) {
                        GroupInfoActivity.this.showToast(StringUtils.isNull(responseGroupInfoMessage.getErrorString()) ? GroupInfoActivity.this.getResources().getString(R.string.neterror) : responseGroupInfoMessage.getErrorString(), false);
                        GroupInfoActivity.this.finish();
                    } else if (responseGroupInfoMessage.getData() != null && responseGroupInfoMessage.getError() == 0) {
                        GroupInfoActivity.this.bUz();
                        GroupInfoActivity.this.loadImage();
                        GroupInfoActivity.this.hBp.setData(responseGroupInfoMessage.getData());
                        if (responseGroupInfoMessage == null || responseGroupInfoMessage.getData().bVz()) {
                            GroupInfoActivity.this.hBo.a(responseGroupInfoMessage.getData(), false);
                            return;
                        }
                        GroupInfoActivity.this.hBo.bUP();
                        com.baidu.tieba.im.settingcache.b.bWw().a(TbadkApplication.getCurrentAccount(), String.valueOf(GroupInfoActivity.this.hBp.getGroupId()), 60000L, new l<Boolean>() { // from class: com.baidu.tieba.im.groupInfo.GroupInfoActivity.a.1
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.tbadk.util.l
                            public void onReturnDataInUI(Boolean bool) {
                                if (bool == null) {
                                    bool = false;
                                }
                                GroupInfoActivity.this.hBo.bUO();
                                GroupInfoActivity.this.hBo.a(responseGroupInfoMessage.getData(), bool.booleanValue());
                                GroupInfoActivity.this.hBp.setHasRecentJoin(bool.booleanValue() ? false : true);
                            }
                        });
                    } else {
                        GroupInfoActivity.this.showToast(R.string.neterror);
                        GroupInfoActivity.this.bUA();
                    }
                }
            } else if (socketResponsedMessage.getCmd() == 103110) {
                if (socketResponsedMessage instanceof ResponseJoinGroupMessage) {
                    ResponseJoinGroupMessage responseJoinGroupMessage = (ResponseJoinGroupMessage) socketResponsedMessage;
                    if (responseJoinGroupMessage.getError() == 0 && (orginalMessage2 = responseJoinGroupMessage.getOrginalMessage()) != null && (orginalMessage2 instanceof RequestJoinGroupMessage) && ((RequestJoinGroupMessage) orginalMessage2).getGroupId() == GroupInfoActivity.this.hBp.getGroupId()) {
                        GroupInfoActivity.this.hBo.bUT();
                        GroupInfoActivity.this.hBp.setHasRecentJoin(true);
                        GroupInfoActivity.this.bUB();
                    }
                }
            } else if (socketResponsedMessage.getCmd() == 103102) {
                GroupInfoActivity.this.hBo.bUO();
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
                                GroupInfoActivity.this.hBp.addPhotoData();
                                GroupInfoActivity.this.hBo.a(GroupInfoActivity.this.hBp.getData());
                                return;
                            }
                            return;
                        case 2:
                            if (type == 3) {
                                GroupInfoActivity.this.hBp.delePhotoData();
                                GroupInfoActivity.this.hBo.a(GroupInfoActivity.this.hBp.getData());
                                return;
                            }
                            return;
                        case 3:
                            if (type == 4) {
                                GroupInfoActivity.this.hBp.updataPortraitData();
                                GroupInfoActivity.this.hBo.a(GroupInfoActivity.this.hBp.getData());
                                return;
                            }
                            return;
                        case 4:
                            GroupInfoActivity.this.hBp.getData().getGroup().setFlag(GroupInfoActivity.this.hpJ.getFlag());
                            GroupInfoActivity.this.hBp.getData().getGroup().setPosition(GroupInfoActivity.this.hpJ.getPosition());
                            GroupInfoActivity.this.hBp.getData().getGroup().setBusiness(GroupInfoActivity.this.hpJ.getBusiness());
                            if ((GroupInfoActivity.this.hBp.getData().getGroup().getFlag() & 1) == 1) {
                                GroupInfoActivity.this.hBo.nE(GroupInfoActivity.this.hBp.getData().bVA());
                            } else {
                                String position = GroupInfoActivity.this.hBp.getData().getGroup().getPosition();
                                String business = GroupInfoActivity.this.hBp.getData().getGroup().getBusiness();
                                StringBuffer stringBuffer = new StringBuffer();
                                if (position != null) {
                                    stringBuffer.append(position);
                                }
                                if (business != null) {
                                    stringBuffer.append(business);
                                }
                                GroupInfoActivity.this.hBo.m(GroupInfoActivity.this.hBp.getData().bVA(), stringBuffer.toString());
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
                        if (requestRemoveMembersMessage.getGroupId() == GroupInfoActivity.this.hBp.getGroupId()) {
                            String userIds = requestRemoveMembersMessage.getUserIds();
                            if (!TextUtils.isEmpty(userIds) && (split = userIds.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) != null && split.length != 0) {
                                String id = TbadkApplication.getCurrentAccountObj().getID();
                                if (!TextUtils.isEmpty(id)) {
                                    for (String str : split) {
                                        if (id.equals(str)) {
                                            ResponseGroupInfoLocalMessage.a data = GroupInfoActivity.this.hBp.getData();
                                            data.wD(data.bVy() + 1);
                                            data.nL(false);
                                            GroupInfoActivity.this.hBp.setHasRecentJoin(false);
                                            GroupInfoActivity.this.hBo.a(data, true);
                                            GroupInfoActivity.this.hBo.CU(str);
                                            GroupInfoActivity.this.bUB();
                                            return;
                                        }
                                        if (GroupInfoActivity.this.hBp.removeMemberByUid(str)) {
                                            GroupInfoActivity.this.hBo.CU(str);
                                            GroupData group = GroupInfoActivity.this.hBp.getData().getGroup();
                                            if (group != null && group.getMemberNum() > 1) {
                                                group.setMemberNum(group.getMemberNum() - 1);
                                            }
                                            GroupInfoActivity.this.hBo.setData(GroupInfoActivity.this.hBp.getData());
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
                    if (responseDismissGroupMessage.getError() == 0 && GroupInfoActivity.this.hBp.getGroupId() == responseDismissGroupMessage.getGroupId()) {
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
        if (groupNewsPojo != null && this.hBp != null && this.hBp.getData() != null) {
            try {
                JSONObject jSONObject = new JSONObject(groupNewsPojo.getContent());
                String string = jSONObject.getJSONObject(TbEnum.SystemMessage.KEY_EVENT_PARAM).getString(TbEnum.SystemMessage.KEY_GROUP_ID);
                if (jSONObject.getString(TbEnum.SystemMessage.KEY_EVENT_ID).equals(TbEnum.SystemMessage.EVENT_ID_KICKED_OUT) && string.equals(String.valueOf(this.hBp.getGroupId())) && this.hBp.getData().bVz()) {
                    this.hBp.getData().nL(false);
                    GroupData group = this.hBp.getData().getGroup();
                    if (group != null && group.getMemberNum() > 1) {
                        group.setMemberNum(group.getMemberNum() - 1);
                    }
                    this.hBo.a(this.hBp.getData(), true);
                    bUB();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void f(GroupNewsPojo groupNewsPojo) {
        try {
            String optString = new JSONObject(groupNewsPojo.getContent()).optJSONObject(TbEnum.SystemMessage.KEY_EVENT_PARAM).optString(TbEnum.SystemMessage.KEY_GROUP_ID);
            if (!TextUtils.isEmpty(optString) && this.hBp != null && optString.equals(String.valueOf(this.hBp.getGroupId())) && this.hBp.getData() != null) {
                this.hBp.getData().nL(true);
                if (this.hBo != null) {
                    this.hBo.nG(true);
                    this.hBo.bUR();
                    bUB();
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(GroupNewsPojo groupNewsPojo) {
        if (groupNewsPojo != null && this.hBp != null && this.hBp.getData() != null) {
            try {
                JSONObject jSONObject = new JSONObject(groupNewsPojo.getContent());
                JSONObject jSONObject2 = jSONObject.getJSONObject(TbEnum.SystemMessage.KEY_EVENT_PARAM);
                String string = jSONObject2.getString(TbEnum.SystemMessage.KEY_GROUP_ID);
                if (jSONObject.getString(TbEnum.SystemMessage.KEY_EVENT_ID).equals(TbEnum.SystemMessage.EVENT_ID_GROUP_NAME_MODIFY) && string.equals(String.valueOf(this.hBp.getGroupId()))) {
                    String string2 = jSONObject2.getString(TbEnum.SystemMessage.KEY_GROUP_NAME);
                    if (!TextUtils.isEmpty(string2)) {
                        this.hBo.setGroupName(string2);
                        if (this.hBp.getData() != null && this.hBp.getData().getGroup() != null) {
                            this.hBp.getData().getGroup().setName(string2);
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
        if (groupNewsPojo != null && this.hBp != null) {
            try {
                JSONObject jSONObject = new JSONObject(groupNewsPojo.getContent());
                String string = jSONObject.getJSONObject(TbEnum.SystemMessage.KEY_EVENT_PARAM).getString(TbEnum.SystemMessage.KEY_GROUP_ID);
                if (jSONObject.getString(TbEnum.SystemMessage.KEY_EVENT_ID).equals(TbEnum.SystemMessage.EVENT_ID_DISMISS_GROUP) && string.equals(String.valueOf(this.hBp.getGroupId()))) {
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
    public void bUB() {
        if (this.hBp != null) {
            this.hBp.clearGroupInfoCache(String.valueOf(this.hBp.getGroupId()));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 1) {
            if (ab.checkCamera(getApplicationContext())) {
                al.e(getPageContext());
            } else {
                showToast(R.string.system_permission_prompt_camera);
            }
            ArrayMap<String, Boolean> transformPermissionResult = ab.transformPermissionResult(strArr, iArr);
            if (transformPermissionResult.containsKey("android.permission.WRITE_EXTERNAL_STORAGE") && !transformPermissionResult.get("android.permission.WRITE_EXTERNAL_STORAGE").booleanValue()) {
                showToast(R.string.sdcard_permission_denied_advert_for_camera);
            }
        }
    }
}
