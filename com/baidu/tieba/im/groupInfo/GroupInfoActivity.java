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
/* loaded from: classes10.dex */
public class GroupInfoActivity extends BaseActivity<GroupInfoActivity> implements View.OnClickListener, View.OnLongClickListener, a.InterfaceC0078a, c, d {
    private com.baidu.tieba.im.groupInfo.a hFb;
    private GroupInfoModel hFc;
    private a hFd;
    private UpdateGroupModel htw;
    private PermissionJudgePolicy mPermissionJudgement;
    private int type = 0;
    private final WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private long hFe = -1;
    private long hFf = -1;
    private final b.a hFg = new b.a() { // from class: com.baidu.tieba.im.groupInfo.GroupInfoActivity.1
        @Override // com.baidu.tbadk.core.dialog.b.a
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            bVar.dismiss();
            if (i == 0) {
                GroupInfoActivity.this.bEB();
            } else if (i == 1) {
                AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(GroupInfoActivity.this.getPageContext().getPageActivity(), GroupInfoActivity.this.writeImagesInfo.toJsonString());
                albumActivityConfig.setRequestCode(RequestResponseCode.REQUEST_ALBUM_IMAGE);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
            }
        }
    };
    private final b hFh = new b() { // from class: com.baidu.tieba.im.groupInfo.GroupInfoActivity.2
        @Override // com.baidu.tieba.im.groupInfo.b
        public void a(i iVar, int i, Object obj, int i2) {
            if (iVar != null && iVar.isShowing()) {
                iVar.dismiss();
            }
            if (i == 0) {
                if (i2 != 0) {
                    GroupInfoActivity.this.aw(obj);
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
                GroupInfoActivity.this.hFb.bWK();
                GroupInfoActivity.this.showToast(R.string.neterror);
            } else if (customResponsedMessage.getCmd() == 2001102) {
                if (!(customResponsedMessage instanceof ResponseGroupInfoLocalMessage)) {
                    GroupInfoActivity.this.hFc.sendMessage(GroupInfoActivity.this.hFc.getGroupId(), GroupInfoActivity.this.hFc.getFrom());
                    return;
                }
                ResponseGroupInfoLocalMessage responseGroupInfoLocalMessage = (ResponseGroupInfoLocalMessage) customResponsedMessage;
                if (responseGroupInfoLocalMessage.getOrginalMessage() == null || ((RequestGroupInfoLocalMessage) responseGroupInfoLocalMessage.getOrginalMessage()).getGroupId() == GroupInfoActivity.this.hFc.getGroupId()) {
                    if (responseGroupInfoLocalMessage.getError() != 0) {
                        GroupInfoActivity.this.hFc.sendMessage(GroupInfoActivity.this.hFc.getGroupId(), GroupInfoActivity.this.hFc.getFrom());
                        return;
                    }
                    GroupInfoActivity.this.loadImage();
                    GroupInfoActivity.this.hFc.setData(responseGroupInfoLocalMessage.getData());
                    GroupInfoActivity.this.hFb.setData(responseGroupInfoLocalMessage.getData());
                    GroupInfoActivity.this.bWv();
                }
            }
        }
    };
    private final CustomMessageListener hCx = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.groupInfo.GroupInfoActivity.4
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
        bWv();
        startLoading();
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        a((Bundle) null, intent);
        this.hFf = this.hFc.getGroupId();
        startLoading();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bWv() {
        if (this.hFc != null) {
            long groupId = this.hFc.getGroupId();
            this.hFf = groupId;
            this.hFe = groupId;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bWw() {
        if (this.hFe != this.hFf) {
            initUI();
            bWv();
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void initListener() {
        this.hFd = new a();
        registerListener(CmdConfigSocket.CMD_REQUEST_GROUP_INFO_BY_ID, this.hFd);
        registerListener(CmdConfigCustom.CMD_REQUEST_GROUP_INFO_BY_ID_LOCAL, this.mCustomListener);
        registerListener(CmdConfigSocket.CMD_UPDATE_GROUP, this.hFd);
        registerListener(CmdConfigSocket.CMD_REMOVE_MEMBERS, this.hFd);
        registerListener(CmdConfigSocket.CMD_JOIN_GROUP, this.hFd);
        registerListener(CmdConfigSocket.CMD_CREATE_GROUP_ACTIVITY, this.hFd);
        registerListener(CmdConfigSocket.CMD_DEL_GROUP_ACTIVITY, this.hFd);
        registerListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_KICK_OUT, this.hCx);
        registerListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_APPLY_JOIN_SUCCESS, this.hCx);
        registerListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_GROUP_NAME_CHANGE, this.hCx);
        registerListener(CmdConfigSocket.CMD_DISSMISS_GROUP, this.hFd);
        registerListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_DISMISS_GROUP, this.hCx);
        registerListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_GROUP_ACTIVITYS_CHANGE, this.hCx);
        registerListener(CmdConfigSocket.CMD_UPGRADE_MEMBER_GROUP, this.hFd);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.hFc.saveInstance(bundle);
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
        this.hFc.cancelMessage();
        MessageManager.getInstance().unRegisterListener(this.hCx);
        if (this.hFb != null) {
            this.hFb.onDestory();
        }
    }

    private void initUI() {
        this.hFb = new com.baidu.tieba.im.groupInfo.a(this);
        this.hFb.a(this.hFh);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startLoading() {
        this.hFb.bWL();
        this.hFc.sendLocalMessage(this.hFc.getGroupId(), this.hFc.getFrom());
        this.hFc.sendMessage(this.hFc.getGroupId(), this.hFc.getFrom());
    }

    public void a(Bundle bundle, Intent intent) {
        this.hFc = new GroupInfoModel(this);
        this.hFc.setUniqueId(getUniqueId());
        if (bundle == null) {
            GroupInfoModel groupInfoModel = this.hFc;
            if (intent == null) {
                intent = getIntent();
            }
            groupInfoModel.initWithIntent(intent);
        } else {
            this.hFc.initWithBundle(bundle);
        }
        this.htw = new UpdateGroupModel(getPageContext());
        this.htw.setUniqueId(getUniqueId());
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
        if (this.hFb != null) {
            this.hFb.changeSkinType(i);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hFb.bWM()) {
            if (this.hFc.getData() != null && this.hFc.getData().bXw()) {
                TiebaStatic.log("edit_place_at_groupinfo");
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupAddressLocateActivityConfig(getPageContext().getPageActivity(), RequestResponseCode.REQUEST_ADDRESS_VIEW, this.hFc.getData().getGroup().getPosition(), this.hFc.getData().getGroup().getBusiness(), (this.hFc.getData().getGroup().getFlag() & 1) == 1)));
            }
        } else if (view == this.hFb.bVs()) {
            closeActivity();
        } else if (view != this.hFb.bWz()) {
            if (view == this.hFb.bWH()) {
                if (this.hFc.getData() != null && this.hFc.getData().getGroup() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), String.valueOf(this.hFc.getData().getGroup().getAuthorId()), this.hFc.getData().getGroup().getAuthorName())));
                }
            } else if (view == this.hFb.bWI()) {
                if (this.hFc != null && this.hFc.getData() != null) {
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupLevelActivityConfig(getPageContext().getPageActivity(), this.hFc.getGroupId(), this.hFc.getData().isMemGroup())));
                }
            } else if (view == this.hFb.bWG()) {
                if (TextUtils.isEmpty(TbadkApplication.getCurrentAccount())) {
                    TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getPageContext().getPageActivity(), true, 3)));
                } else if (this.hFc.getData() != null) {
                    if (this.hFc.getData().bXv()) {
                        if (this.hFc.getData().getGroup() != null) {
                            TiebaStatic.log(new an("c10334").cx("obj_type", String.valueOf(this.hFc.getData().getGroup().getGroupId())));
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(getPageContext().getPageActivity(), this.hFc.getGroupId(), this.hFc.getData().getGroup().getName(), this.hFc.getData().getGroup().getAuthorId(), "group_info")));
                        }
                    } else if (this.hFc.hasRecentJoin()) {
                        showToast(R.string.has_recent_join);
                    } else if (this.hFc.getData() != null) {
                        if (this.hFc.getData().bXu() <= 0) {
                            showToast(R.string.add_group_max);
                        } else if (ApplyJoinGroupActivityConfig.JOINTYPE_DEFAULT == this.hFc.getJoinType()) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IM_APPLE_JOIN_GROUP_ACTIVITY_START, new ApplyJoinGroupActivityConfig(getPageContext().getPageActivity(), "" + this.hFc.getGroupId(), this.hFc.getData().bXt(), this.hFc.getData().bXu())));
                        } else if (ApplyJoinGroupActivityConfig.JOINTYPE_INVITE == this.hFc.getJoinType()) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IM_APPLE_JOIN_GROUP_ACTIVITY_START, new ApplyJoinGroupActivityConfig(getPageContext().getPageActivity(), "" + this.hFc.getGroupId(), this.hFc.getData().bXt(), this.hFc.getData().bXu(), this.hFc.getInviteUserId(), this.hFc.getDefaultUserMsg())));
                        }
                    }
                }
            } else if (view == this.hFb.bWF()) {
                if (this.hFc.getData() != null && this.hFc.getData().getGroup() != null) {
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupSettingActivityConfig(getPageContext().getPageActivity(), 4, this.hFc.getData().getGroup().getName(), "" + this.hFc.getGroupId(), this.hFc.getData().bXw(), this.hFc.getData().getGroup().getFlag())));
                }
            } else if (view == this.hFb.bWD()) {
                if (this.hFc.getData() != null && this.hFc.getData().getGroup() != null) {
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UpdateGroupActivityConfig(getPageContext().getPageActivity(), 1, this.hFc.getGroupId(), 1, this.hFc.getData().getGroup().getName())));
                }
            } else if (view == this.hFb.bWC()) {
                if (this.hFc.getData() != null && this.hFc.getData().bXw() && this.hFc.getData().getGroup() != null) {
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UpdateGroupActivityConfig(getPageContext().getPageActivity(), 2, this.hFc.getGroupId(), 2, this.hFc.getData().getGroup().getIntro())));
                }
            } else if (view == this.hFb.bWJ() || view == this.hFb.bWA()) {
                MembersActivity.e(getPageContext().getPageActivity(), this.hFc.getGroupId());
            } else if (view == this.hFb.bWB()) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new InviteFriendListActivityConfig(getPageContext().getPageActivity(), 0L, this.hFc.getGroupId())));
            } else if (view == this.hFb.bWE() && this.hFc.getData() != null && this.hFc.getData().bXv()) {
                GroupActivityData bXq = this.hFc.getData().bXq();
                if (bXq != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupActivityActivityConfig(getPageContext().getPageActivity(), bXq.getActivityId(), this.hFc.getGroupId(), 0)));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CreateGroupActivityActivityConfig(getPageContext().getPageActivity(), this.hFc.getGroupId())));
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
        this.hFb.c(obj, i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        if (view == this.hFb.bWy()) {
            if (this.hFc.getData() == null || this.hFc.getData().getGroup() == null) {
                return false;
            }
            this.hFb.Dn(String.valueOf(this.hFc.getData().getGroup().getGroupId()));
            return false;
        } else if (view != this.hFb.bWC() || this.hFc.getData().bXw()) {
            return false;
        } else {
            if (this.hFc.getData() != null && this.hFc.getData().getGroup() != null) {
                this.hFb.Dm(String.valueOf(this.hFc.getData().getGroup().getIntro()));
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
            ArrayList<String> bigUrlList = this.hFc.getBigUrlList();
            HashMap<String, ImageUrlData> assistUrls = this.hFc.getAssistUrls();
            if (obj != null && (obj instanceof PhotoUrlData) && bigUrlList != null) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupImageActivityConfig(getPageContext().getPageActivity(), ((PhotoUrlData) obj).getBigurl(), bigUrlList, this.hFc.getGroupId(), assistUrls)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEB() {
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
                        if (this.hFb != null) {
                            this.hFb.setGroupName(stringExtra);
                        }
                        if (this.hFc != null && this.hFc.getData() != null && this.hFc.getData().getGroup() != null) {
                            this.hFc.getData().getGroup().setName(stringExtra);
                            return;
                        }
                        return;
                    }
                    return;
                case 2:
                    if (intent != null) {
                        String stringExtra2 = intent.getStringExtra(UpdateGroupActivityConfig.GROUP_TEXT);
                        if (this.hFb != null) {
                            this.hFb.Dk(stringExtra2);
                        }
                        if (this.hFc != null && this.hFc.getData() != null && this.hFc.getData().getGroup() != null) {
                            this.hFc.getData().getGroup().setIntro(stringExtra2);
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
                        if (this.hFc != null && this.hFc.getData() != null && this.hFc.getData().getGroup() != null) {
                            this.hFc.getData().getGroup().setFlag(intExtra);
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
                ac.aGq().c(photoUrlData.getSmallurl(), m.getFileDireciory(TbConfig.GROUP_HEAD_FILE), true, false, true);
            }
            b(photoUrlData);
        } else if (i2 == 0 && i == 12010) {
            bEB();
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
            Di(this.hFc.generateDeleAlbum(photoUrlData));
        }
    }

    private void b(PhotoUrlData photoUrlData) {
        this.type = 1;
        if (photoUrlData != null) {
            String generateAddAlbum = this.hFc.generateAddAlbum(photoUrlData);
            if (!TextUtils.isEmpty(generateAddAlbum)) {
                Di(generateAddAlbum);
            }
        }
    }

    private void j(int i, String str, String str2) {
        this.type = 4;
        if (this.htw != null) {
            this.htw.setGroupId(this.hFc.getGroupId());
            this.htw.setFlag(i);
            this.htw.setPosition(str);
            this.htw.setBusiness(str2);
            this.htw.sendMessage(5);
            this.hFb.bWL();
        }
    }

    private void Di(String str) {
        if (this.htw != null) {
            this.htw.setGroupId(this.hFc.getGroupId());
            this.htw.setAlbum(str);
            this.htw.sendMessage(3);
            this.hFb.bWL();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aw(Object obj) {
        GroupCardModel.bWl();
        this.type = 3;
        if (obj != null && (obj instanceof PhotoUrlData)) {
            PhotoUrlData photoUrlData = (PhotoUrlData) obj;
            this.hFc.setChangePhotoUrlData(photoUrlData);
            String picId = photoUrlData.getPicId();
            if (this.htw != null) {
                this.htw.setGroupId(this.hFc.getGroupId());
                this.htw.setPortrait(picId);
                this.htw.sendMessage(4);
                this.hFb.bWL();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
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
                GroupInfoActivity.this.hFb.bWK();
                GroupInfoActivity.this.showToast(R.string.neterror);
            } else if (socketResponsedMessage.getCmd() == 103004) {
                GroupInfoActivity.this.hFb.bWK();
                final ResponseGroupInfoMessage responseGroupInfoMessage = (ResponseGroupInfoMessage) socketResponsedMessage;
                if (GroupInfoActivity.this.hFc.getSendMsg() == responseGroupInfoMessage.getOrginalMessage()) {
                    if (responseGroupInfoMessage.getError() == 2230101) {
                        GroupInfoActivity.this.showToast(StringUtils.isNull(responseGroupInfoMessage.getErrorString()) ? GroupInfoActivity.this.getResources().getString(R.string.neterror) : responseGroupInfoMessage.getErrorString(), false);
                        GroupInfoActivity.this.finish();
                    } else if (responseGroupInfoMessage.getData() != null && responseGroupInfoMessage.getError() == 0) {
                        GroupInfoActivity.this.bWv();
                        GroupInfoActivity.this.loadImage();
                        GroupInfoActivity.this.hFc.setData(responseGroupInfoMessage.getData());
                        if (responseGroupInfoMessage == null || responseGroupInfoMessage.getData().bXv()) {
                            GroupInfoActivity.this.hFb.a(responseGroupInfoMessage.getData(), false);
                            return;
                        }
                        GroupInfoActivity.this.hFb.bWL();
                        com.baidu.tieba.im.settingcache.b.bYs().a(TbadkApplication.getCurrentAccount(), String.valueOf(GroupInfoActivity.this.hFc.getGroupId()), 60000L, new l<Boolean>() { // from class: com.baidu.tieba.im.groupInfo.GroupInfoActivity.a.1
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.tbadk.util.l
                            public void onReturnDataInUI(Boolean bool) {
                                if (bool == null) {
                                    bool = false;
                                }
                                GroupInfoActivity.this.hFb.bWK();
                                GroupInfoActivity.this.hFb.a(responseGroupInfoMessage.getData(), bool.booleanValue());
                                GroupInfoActivity.this.hFc.setHasRecentJoin(bool.booleanValue() ? false : true);
                            }
                        });
                    } else {
                        GroupInfoActivity.this.showToast(R.string.neterror);
                        GroupInfoActivity.this.bWw();
                    }
                }
            } else if (socketResponsedMessage.getCmd() == 103110) {
                if (socketResponsedMessage instanceof ResponseJoinGroupMessage) {
                    ResponseJoinGroupMessage responseJoinGroupMessage = (ResponseJoinGroupMessage) socketResponsedMessage;
                    if (responseJoinGroupMessage.getError() == 0 && (orginalMessage2 = responseJoinGroupMessage.getOrginalMessage()) != null && (orginalMessage2 instanceof RequestJoinGroupMessage) && ((RequestJoinGroupMessage) orginalMessage2).getGroupId() == GroupInfoActivity.this.hFc.getGroupId()) {
                        GroupInfoActivity.this.hFb.bWP();
                        GroupInfoActivity.this.hFc.setHasRecentJoin(true);
                        GroupInfoActivity.this.bWx();
                    }
                }
            } else if (socketResponsedMessage.getCmd() == 103102) {
                GroupInfoActivity.this.hFb.bWK();
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
                                GroupInfoActivity.this.hFc.addPhotoData();
                                GroupInfoActivity.this.hFb.a(GroupInfoActivity.this.hFc.getData());
                                return;
                            }
                            return;
                        case 2:
                            if (type == 3) {
                                GroupInfoActivity.this.hFc.delePhotoData();
                                GroupInfoActivity.this.hFb.a(GroupInfoActivity.this.hFc.getData());
                                return;
                            }
                            return;
                        case 3:
                            if (type == 4) {
                                GroupInfoActivity.this.hFc.updataPortraitData();
                                GroupInfoActivity.this.hFb.a(GroupInfoActivity.this.hFc.getData());
                                return;
                            }
                            return;
                        case 4:
                            GroupInfoActivity.this.hFc.getData().getGroup().setFlag(GroupInfoActivity.this.htw.getFlag());
                            GroupInfoActivity.this.hFc.getData().getGroup().setPosition(GroupInfoActivity.this.htw.getPosition());
                            GroupInfoActivity.this.hFc.getData().getGroup().setBusiness(GroupInfoActivity.this.htw.getBusiness());
                            if ((GroupInfoActivity.this.hFc.getData().getGroup().getFlag() & 1) == 1) {
                                GroupInfoActivity.this.hFb.nM(GroupInfoActivity.this.hFc.getData().bXw());
                            } else {
                                String position = GroupInfoActivity.this.hFc.getData().getGroup().getPosition();
                                String business = GroupInfoActivity.this.hFc.getData().getGroup().getBusiness();
                                StringBuffer stringBuffer = new StringBuffer();
                                if (position != null) {
                                    stringBuffer.append(position);
                                }
                                if (business != null) {
                                    stringBuffer.append(business);
                                }
                                GroupInfoActivity.this.hFb.n(GroupInfoActivity.this.hFc.getData().bXw(), stringBuffer.toString());
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
                        if (requestRemoveMembersMessage.getGroupId() == GroupInfoActivity.this.hFc.getGroupId()) {
                            String userIds = requestRemoveMembersMessage.getUserIds();
                            if (!TextUtils.isEmpty(userIds) && (split = userIds.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) != null && split.length != 0) {
                                String id = TbadkApplication.getCurrentAccountObj().getID();
                                if (!TextUtils.isEmpty(id)) {
                                    for (String str : split) {
                                        if (id.equals(str)) {
                                            ResponseGroupInfoLocalMessage.a data = GroupInfoActivity.this.hFc.getData();
                                            data.wR(data.bXu() + 1);
                                            data.nT(false);
                                            GroupInfoActivity.this.hFc.setHasRecentJoin(false);
                                            GroupInfoActivity.this.hFb.a(data, true);
                                            GroupInfoActivity.this.hFb.Dl(str);
                                            GroupInfoActivity.this.bWx();
                                            return;
                                        }
                                        if (GroupInfoActivity.this.hFc.removeMemberByUid(str)) {
                                            GroupInfoActivity.this.hFb.Dl(str);
                                            GroupData group = GroupInfoActivity.this.hFc.getData().getGroup();
                                            if (group != null && group.getMemberNum() > 1) {
                                                group.setMemberNum(group.getMemberNum() - 1);
                                            }
                                            GroupInfoActivity.this.hFb.setData(GroupInfoActivity.this.hFc.getData());
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
                    if (responseDismissGroupMessage.getError() == 0 && GroupInfoActivity.this.hFc.getGroupId() == responseDismissGroupMessage.getGroupId()) {
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
        if (groupNewsPojo != null && this.hFc != null && this.hFc.getData() != null) {
            try {
                JSONObject jSONObject = new JSONObject(groupNewsPojo.getContent());
                String string = jSONObject.getJSONObject(TbEnum.SystemMessage.KEY_EVENT_PARAM).getString(TbEnum.SystemMessage.KEY_GROUP_ID);
                if (jSONObject.getString(TbEnum.SystemMessage.KEY_EVENT_ID).equals(TbEnum.SystemMessage.EVENT_ID_KICKED_OUT) && string.equals(String.valueOf(this.hFc.getGroupId())) && this.hFc.getData().bXv()) {
                    this.hFc.getData().nT(false);
                    GroupData group = this.hFc.getData().getGroup();
                    if (group != null && group.getMemberNum() > 1) {
                        group.setMemberNum(group.getMemberNum() - 1);
                    }
                    this.hFb.a(this.hFc.getData(), true);
                    bWx();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void f(GroupNewsPojo groupNewsPojo) {
        try {
            String optString = new JSONObject(groupNewsPojo.getContent()).optJSONObject(TbEnum.SystemMessage.KEY_EVENT_PARAM).optString(TbEnum.SystemMessage.KEY_GROUP_ID);
            if (!TextUtils.isEmpty(optString) && this.hFc != null && optString.equals(String.valueOf(this.hFc.getGroupId())) && this.hFc.getData() != null) {
                this.hFc.getData().nT(true);
                if (this.hFb != null) {
                    this.hFb.nO(true);
                    this.hFb.bWN();
                    bWx();
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(GroupNewsPojo groupNewsPojo) {
        if (groupNewsPojo != null && this.hFc != null && this.hFc.getData() != null) {
            try {
                JSONObject jSONObject = new JSONObject(groupNewsPojo.getContent());
                JSONObject jSONObject2 = jSONObject.getJSONObject(TbEnum.SystemMessage.KEY_EVENT_PARAM);
                String string = jSONObject2.getString(TbEnum.SystemMessage.KEY_GROUP_ID);
                if (jSONObject.getString(TbEnum.SystemMessage.KEY_EVENT_ID).equals(TbEnum.SystemMessage.EVENT_ID_GROUP_NAME_MODIFY) && string.equals(String.valueOf(this.hFc.getGroupId()))) {
                    String string2 = jSONObject2.getString(TbEnum.SystemMessage.KEY_GROUP_NAME);
                    if (!TextUtils.isEmpty(string2)) {
                        this.hFb.setGroupName(string2);
                        if (this.hFc.getData() != null && this.hFc.getData().getGroup() != null) {
                            this.hFc.getData().getGroup().setName(string2);
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
        if (groupNewsPojo != null && this.hFc != null) {
            try {
                JSONObject jSONObject = new JSONObject(groupNewsPojo.getContent());
                String string = jSONObject.getJSONObject(TbEnum.SystemMessage.KEY_EVENT_PARAM).getString(TbEnum.SystemMessage.KEY_GROUP_ID);
                if (jSONObject.getString(TbEnum.SystemMessage.KEY_EVENT_ID).equals(TbEnum.SystemMessage.EVENT_ID_DISMISS_GROUP) && string.equals(String.valueOf(this.hFc.getGroupId()))) {
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
    public void bWx() {
        if (this.hFc != null) {
            this.hFc.clearGroupInfoCache(String.valueOf(this.hFc.getGroupId()));
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
