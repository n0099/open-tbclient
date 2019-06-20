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
import com.baidu.e.a.a;
import com.baidu.sapi2.passhost.pluginsdk.service.IEventCenterService;
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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.coreExtra.data.PhotoUrlData;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.util.k;
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
/* loaded from: classes5.dex */
public class GroupInfoActivity extends BaseActivity<GroupInfoActivity> implements View.OnClickListener, View.OnLongClickListener, a.InterfaceC0041a, c, d {
    private com.baidu.tieba.im.groupInfo.a gDE;
    private GroupInfoModel gDF;
    private a gDG;
    private UpdateGroupModel grW;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgement;
    private int type = 0;
    private final WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private long gDH = -1;
    private long gDI = -1;
    private final b.a gDJ = new b.a() { // from class: com.baidu.tieba.im.groupInfo.GroupInfoActivity.1
        @Override // com.baidu.tbadk.core.dialog.b.a
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            bVar.dismiss();
            if (i == 0) {
                GroupInfoActivity.this.takePhoto();
            } else if (i == 1) {
                AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(GroupInfoActivity.this.getPageContext().getPageActivity(), GroupInfoActivity.this.writeImagesInfo.toJsonString());
                albumActivityConfig.setRequestCode(IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
            }
        }
    };
    private final b gDK = new b() { // from class: com.baidu.tieba.im.groupInfo.GroupInfoActivity.2
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
                GroupInfoActivity.this.gDE.bCa();
                GroupInfoActivity.this.showToast(R.string.neterror);
            } else if (customResponsedMessage.getCmd() == 2001102) {
                if (!(customResponsedMessage instanceof ResponseGroupInfoLocalMessage)) {
                    GroupInfoActivity.this.gDF.sendMessage(GroupInfoActivity.this.gDF.getGroupId(), GroupInfoActivity.this.gDF.getFrom());
                    return;
                }
                ResponseGroupInfoLocalMessage responseGroupInfoLocalMessage = (ResponseGroupInfoLocalMessage) customResponsedMessage;
                if (responseGroupInfoLocalMessage.getOrginalMessage() == null || ((RequestGroupInfoLocalMessage) responseGroupInfoLocalMessage.getOrginalMessage()).getGroupId() == GroupInfoActivity.this.gDF.getGroupId()) {
                    if (responseGroupInfoLocalMessage.getError() != 0) {
                        GroupInfoActivity.this.gDF.sendMessage(GroupInfoActivity.this.gDF.getGroupId(), GroupInfoActivity.this.gDF.getFrom());
                        return;
                    }
                    GroupInfoActivity.this.loadImage();
                    GroupInfoActivity.this.gDF.setData(responseGroupInfoLocalMessage.getData());
                    GroupInfoActivity.this.gDE.setData(responseGroupInfoLocalMessage.getData());
                    GroupInfoActivity.this.bBL();
                }
            }
        }
    };
    private final CustomMessageListener gBc = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.groupInfo.GroupInfoActivity.4
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
        bBL();
        startLoading();
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        a((Bundle) null, intent);
        this.gDI = this.gDF.getGroupId();
        startLoading();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBL() {
        if (this.gDF != null) {
            long groupId = this.gDF.getGroupId();
            this.gDI = groupId;
            this.gDH = groupId;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBM() {
        if (this.gDH != this.gDI) {
            initUI();
            bBL();
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void initListener() {
        this.gDG = new a();
        registerListener(103004, this.gDG);
        registerListener(2001102, this.mCustomListener);
        registerListener(103102, this.gDG);
        registerListener(103112, this.gDG);
        registerListener(103110, this.gDG);
        registerListener(103120, this.gDG);
        registerListener(103121, this.gDG);
        registerListener(2001128, this.gBc);
        registerListener(2001126, this.gBc);
        registerListener(2001130, this.gBc);
        registerListener(103104, this.gDG);
        registerListener(2001137, this.gBc);
        registerListener(2001135, this.gBc);
        registerListener(103105, this.gDG);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.gDF.saveInstance(bundle);
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
        this.gDF.cancelMessage();
        MessageManager.getInstance().unRegisterListener(this.gBc);
        if (this.gDE != null) {
            this.gDE.onDestory();
        }
    }

    private void initUI() {
        this.gDE = new com.baidu.tieba.im.groupInfo.a(this);
        this.gDE.a(this.gDK);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startLoading() {
        this.gDE.bCb();
        this.gDF.sendLocalMessage(this.gDF.getGroupId(), this.gDF.getFrom());
        this.gDF.sendMessage(this.gDF.getGroupId(), this.gDF.getFrom());
    }

    public void a(Bundle bundle, Intent intent) {
        this.gDF = new GroupInfoModel(this);
        this.gDF.setUniqueId(getUniqueId());
        if (bundle == null) {
            GroupInfoModel groupInfoModel = this.gDF;
            if (intent == null) {
                intent = getIntent();
            }
            groupInfoModel.initWithIntent(intent);
        } else {
            this.gDF.initWithBundle(bundle);
        }
        this.grW = new UpdateGroupModel(getPageContext());
        this.grW.setUniqueId(getUniqueId());
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
        if (this.gDE != null) {
            this.gDE.changeSkinType(i);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gDE.bCc()) {
            if (this.gDF.getData() != null && this.gDF.getData().bCN()) {
                TiebaStatic.log("edit_place_at_groupinfo");
                sendMessage(new CustomMessage(2002001, new GroupAddressLocateActivityConfig(getPageContext().getPageActivity(), 21001, this.gDF.getData().getGroup().getPosition(), this.gDF.getData().getGroup().getBusiness(), (this.gDF.getData().getGroup().getFlag() & 1) == 1)));
            }
        } else if (view == this.gDE.bAJ()) {
            closeActivity();
        } else if (view != this.gDE.bBP()) {
            if (view == this.gDE.bBX()) {
                if (this.gDF.getData() != null && this.gDF.getData().getGroup() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), String.valueOf(this.gDF.getData().getGroup().getAuthorId()), this.gDF.getData().getGroup().getAuthorName())));
                }
            } else if (view == this.gDE.bBY()) {
                if (this.gDF != null && this.gDF.getData() != null) {
                    sendMessage(new CustomMessage(2002001, new GroupLevelActivityConfig(getPageContext().getPageActivity(), this.gDF.getGroupId(), this.gDF.getData().isMemGroup())));
                }
            } else if (view == this.gDE.bBW()) {
                if (TextUtils.isEmpty(TbadkApplication.getCurrentAccount())) {
                    TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 3)));
                } else if (this.gDF.getData() != null) {
                    if (this.gDF.getData().bCM()) {
                        if (this.gDF.getData().getGroup() != null) {
                            TiebaStatic.log(new am("c10334").bT("obj_type", String.valueOf(this.gDF.getData().getGroup().getGroupId())));
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(getPageContext().getPageActivity(), this.gDF.getGroupId(), this.gDF.getData().getGroup().getName(), this.gDF.getData().getGroup().getAuthorId(), "group_info")));
                        }
                    } else if (this.gDF.hasRecentJoin()) {
                        showToast(R.string.has_recent_join);
                    } else if (this.gDF.getData() != null) {
                        if (this.gDF.getData().bCL() <= 0) {
                            showToast(R.string.add_group_max);
                        } else if (ApplyJoinGroupActivityConfig.JOINTYPE_DEFAULT == this.gDF.getJoinType()) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2008014, new ApplyJoinGroupActivityConfig(getPageContext().getPageActivity(), "" + this.gDF.getGroupId(), this.gDF.getData().bCK(), this.gDF.getData().bCL())));
                        } else if (ApplyJoinGroupActivityConfig.JOINTYPE_INVITE == this.gDF.getJoinType()) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2008014, new ApplyJoinGroupActivityConfig(getPageContext().getPageActivity(), "" + this.gDF.getGroupId(), this.gDF.getData().bCK(), this.gDF.getData().bCL(), this.gDF.getInviteUserId(), this.gDF.getDefaultUserMsg())));
                        }
                    }
                }
            } else if (view == this.gDE.bBV()) {
                if (this.gDF.getData() != null && this.gDF.getData().getGroup() != null) {
                    sendMessage(new CustomMessage(2002001, new GroupSettingActivityConfig(getPageContext().getPageActivity(), 4, this.gDF.getData().getGroup().getName(), "" + this.gDF.getGroupId(), this.gDF.getData().bCN(), this.gDF.getData().getGroup().getFlag())));
                }
            } else if (view == this.gDE.bBT()) {
                if (this.gDF.getData() != null && this.gDF.getData().getGroup() != null) {
                    sendMessage(new CustomMessage(2002001, new UpdateGroupActivityConfig(getPageContext().getPageActivity(), 1, this.gDF.getGroupId(), 1, this.gDF.getData().getGroup().getName())));
                }
            } else if (view == this.gDE.bBS()) {
                if (this.gDF.getData() != null && this.gDF.getData().bCN() && this.gDF.getData().getGroup() != null) {
                    sendMessage(new CustomMessage(2002001, new UpdateGroupActivityConfig(getPageContext().getPageActivity(), 2, this.gDF.getGroupId(), 2, this.gDF.getData().getGroup().getIntro())));
                }
            } else if (view == this.gDE.bBZ() || view == this.gDE.bBQ()) {
                MembersActivity.e(getPageContext().getPageActivity(), this.gDF.getGroupId());
            } else if (view == this.gDE.bBR()) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new InviteFriendListActivityConfig(getPageContext().getPageActivity(), 0L, this.gDF.getGroupId())));
            } else if (view == this.gDE.bBU() && this.gDF.getData() != null && this.gDF.getData().bCM()) {
                GroupActivityData bCH = this.gDF.getData().bCH();
                if (bCH != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupActivityActivityConfig(getPageContext().getPageActivity(), bCH.getActivityId(), this.gDF.getGroupId(), 0)));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CreateGroupActivityActivityConfig(getPageContext().getPageActivity(), this.gDF.getGroupId())));
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
        this.gDE.d(obj, i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        if (view == this.gDE.bBO()) {
            if (this.gDF.getData() == null || this.gDF.getData().getGroup() == null) {
                return false;
            }
            this.gDE.yA(String.valueOf(this.gDF.getData().getGroup().getGroupId()));
            return false;
        } else if (view != this.gDE.bBS() || this.gDF.getData().bCN()) {
            return false;
        } else {
            if (this.gDF.getData() != null && this.gDF.getData().getGroup() != null) {
                this.gDE.yz(String.valueOf(this.gDF.getData().getGroup().getIntro()));
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
            this.mPermissionJudgement.aiM();
            this.mPermissionJudgement.e(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgement.aa(pageActivity)) {
                AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true);
                albumActivityConfig.setRequestCode(IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK);
                albumActivityConfig.setResourceType(2);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
            }
        } else if (i == 1) {
            ArrayList<String> bigUrlList = this.gDF.getBigUrlList();
            HashMap<String, ImageUrlData> assistUrls = this.gDF.getAssistUrls();
            if (obj != null && (obj instanceof PhotoUrlData) && bigUrlList != null) {
                sendMessage(new CustomMessage(2002001, new GroupImageActivityConfig(getPageContext().getPageActivity(), ((PhotoUrlData) obj).getBigurl(), bigUrlList, this.gDF.getGroupId(), assistUrls)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void takePhoto() {
        if (!ab.e(getPageContext().getPageActivity(), 1)) {
            ak.c(getPageContext());
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
                        if (this.gDE != null) {
                            this.gDE.setGroupName(stringExtra);
                        }
                        if (this.gDF != null && this.gDF.getData() != null && this.gDF.getData().getGroup() != null) {
                            this.gDF.getData().getGroup().setName(stringExtra);
                            return;
                        }
                        return;
                    }
                    return;
                case 2:
                    if (intent != null) {
                        String stringExtra2 = intent.getStringExtra(UpdateGroupActivityConfig.GROUP_TEXT);
                        if (this.gDE != null) {
                            this.gDE.yx(stringExtra2);
                        }
                        if (this.gDF != null && this.gDF.getData() != null && this.gDF.getData().getGroup() != null) {
                            this.gDF.getData().getGroup().setIntro(stringExtra2);
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
                        if (this.gDF != null && this.gDF.getData() != null && this.gDF.getData().getGroup() != null) {
                            this.gDF.getData().getGroup().setFlag(intExtra);
                            return;
                        }
                        return;
                    }
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK /* 12002 */:
                    if (intent != null) {
                        intent.getBooleanExtra(AlbumActivityConfig.CAMERA_RESULT, false);
                        am(intent);
                        break;
                    } else {
                        return;
                    }
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_DYNAMIC_PWD /* 12009 */:
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_LOGIN_PROXY_RESULT /* 12010 */:
                    break;
                case 21001:
                    j(intent.getBooleanExtra("ResultDataIsHiddenAddress", true) ? 1 : 0, intent.getStringExtra("ResultDataAddress"), intent.getStringExtra("ResultDataSelectedBusiness"));
                    return;
                default:
                    return;
            }
            PhotoUrlData photoUrlData = (PhotoUrlData) intent.getSerializableExtra(EditHeadActivityConfig.PIC_INFO);
            if (photoUrlData != null) {
                ac.ahO().d(photoUrlData.getSmallurl(), m.mX(TbConfig.GROUP_HEAD_FILE), true, false, true);
            }
            b(photoUrlData);
        } else if (i2 == 0 && i == 12010) {
            takePhoto();
        }
    }

    private void am(Intent intent) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) != null) {
            this.writeImagesInfo.parseJson(stringExtra);
            this.writeImagesInfo.updateQuality();
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                sendMessage(new CustomMessage(2002001, new EditHeadActivityConfig(getPageContext().getPageActivity(), (int) IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK, (int) IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_DYNAMIC_PWD, intent.getData(), TbadkApplication.getCurrentAccountObj(), 2, this.writeImagesInfo.getChosedFiles().get(0).getFilePath(), 1.0f)));
            }
            this.writeImagesInfo.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(PhotoUrlData photoUrlData) {
        this.type = 2;
        if (photoUrlData != null) {
            yv(this.gDF.generateDeleAlbum(photoUrlData));
        }
    }

    private void b(PhotoUrlData photoUrlData) {
        this.type = 1;
        if (photoUrlData != null) {
            String generateAddAlbum = this.gDF.generateAddAlbum(photoUrlData);
            if (!TextUtils.isEmpty(generateAddAlbum)) {
                yv(generateAddAlbum);
            }
        }
    }

    private void j(int i, String str, String str2) {
        this.type = 4;
        if (this.grW != null) {
            this.grW.setGroupId(this.gDF.getGroupId());
            this.grW.setFlag(i);
            this.grW.setPosition(str);
            this.grW.setBusiness(str2);
            this.grW.sendMessage(5);
            this.gDE.bCb();
        }
    }

    private void yv(String str) {
        if (this.grW != null) {
            this.grW.setGroupId(this.gDF.getGroupId());
            this.grW.setAlbum(str);
            this.grW.sendMessage(3);
            this.gDE.bCb();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void au(Object obj) {
        GroupCardModel.bBB();
        this.type = 3;
        if (obj != null && (obj instanceof PhotoUrlData)) {
            PhotoUrlData photoUrlData = (PhotoUrlData) obj;
            this.gDF.setChangePhotoUrlData(photoUrlData);
            String picId = photoUrlData.getPicId();
            if (this.grW != null) {
                this.grW.setGroupId(this.gDF.getGroupId());
                this.grW.setPortrait(picId);
                this.grW.sendMessage(4);
                this.gDE.bCb();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
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
                GroupInfoActivity.this.gDE.bCa();
                GroupInfoActivity.this.showToast(R.string.neterror);
            } else if (socketResponsedMessage.getCmd() == 103004) {
                GroupInfoActivity.this.gDE.bCa();
                final ResponseGroupInfoMessage responseGroupInfoMessage = (ResponseGroupInfoMessage) socketResponsedMessage;
                if (GroupInfoActivity.this.gDF.getSendMsg() == responseGroupInfoMessage.getOrginalMessage()) {
                    if (responseGroupInfoMessage.getError() == 2230101) {
                        GroupInfoActivity.this.showToast(StringUtils.isNull(responseGroupInfoMessage.getErrorString()) ? GroupInfoActivity.this.getResources().getString(R.string.neterror) : responseGroupInfoMessage.getErrorString(), false);
                        GroupInfoActivity.this.finish();
                    } else if (responseGroupInfoMessage.getData() != null && responseGroupInfoMessage.getError() == 0) {
                        GroupInfoActivity.this.bBL();
                        GroupInfoActivity.this.loadImage();
                        GroupInfoActivity.this.gDF.setData(responseGroupInfoMessage.getData());
                        if (responseGroupInfoMessage == null || responseGroupInfoMessage.getData().bCM()) {
                            GroupInfoActivity.this.gDE.a(responseGroupInfoMessage.getData(), false);
                            return;
                        }
                        GroupInfoActivity.this.gDE.bCb();
                        com.baidu.tieba.im.settingcache.b.bDJ().a(TbadkApplication.getCurrentAccount(), String.valueOf(GroupInfoActivity.this.gDF.getGroupId()), 60000L, new k<Boolean>() { // from class: com.baidu.tieba.im.groupInfo.GroupInfoActivity.a.1
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.tbadk.util.k
                            public void onReturnDataInUI(Boolean bool) {
                                if (bool == null) {
                                    bool = false;
                                }
                                GroupInfoActivity.this.gDE.bCa();
                                GroupInfoActivity.this.gDE.a(responseGroupInfoMessage.getData(), bool.booleanValue());
                                GroupInfoActivity.this.gDF.setHasRecentJoin(bool.booleanValue() ? false : true);
                            }
                        });
                    } else {
                        GroupInfoActivity.this.showToast(R.string.neterror);
                        GroupInfoActivity.this.bBM();
                    }
                }
            } else if (socketResponsedMessage.getCmd() == 103110) {
                if (socketResponsedMessage instanceof ResponseJoinGroupMessage) {
                    ResponseJoinGroupMessage responseJoinGroupMessage = (ResponseJoinGroupMessage) socketResponsedMessage;
                    if (responseJoinGroupMessage.getError() == 0 && (orginalMessage2 = responseJoinGroupMessage.getOrginalMessage()) != null && (orginalMessage2 instanceof RequestJoinGroupMessage) && ((RequestJoinGroupMessage) orginalMessage2).getGroupId() == GroupInfoActivity.this.gDF.getGroupId()) {
                        GroupInfoActivity.this.gDE.bCf();
                        GroupInfoActivity.this.gDF.setHasRecentJoin(true);
                        GroupInfoActivity.this.bBN();
                    }
                }
            } else if (socketResponsedMessage.getCmd() == 103102) {
                GroupInfoActivity.this.gDE.bCa();
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
                                GroupInfoActivity.this.gDF.addPhotoData();
                                GroupInfoActivity.this.gDE.a(GroupInfoActivity.this.gDF.getData());
                                return;
                            }
                            return;
                        case 2:
                            if (type == 3) {
                                GroupInfoActivity.this.gDF.delePhotoData();
                                GroupInfoActivity.this.gDE.a(GroupInfoActivity.this.gDF.getData());
                                return;
                            }
                            return;
                        case 3:
                            if (type == 4) {
                                GroupInfoActivity.this.gDF.updataPortraitData();
                                GroupInfoActivity.this.gDE.a(GroupInfoActivity.this.gDF.getData());
                                return;
                            }
                            return;
                        case 4:
                            GroupInfoActivity.this.gDF.getData().getGroup().setFlag(GroupInfoActivity.this.grW.getFlag());
                            GroupInfoActivity.this.gDF.getData().getGroup().setPosition(GroupInfoActivity.this.grW.getPosition());
                            GroupInfoActivity.this.gDF.getData().getGroup().setBusiness(GroupInfoActivity.this.grW.getBusiness());
                            if ((GroupInfoActivity.this.gDF.getData().getGroup().getFlag() & 1) == 1) {
                                GroupInfoActivity.this.gDE.ma(GroupInfoActivity.this.gDF.getData().bCN());
                            } else {
                                String position = GroupInfoActivity.this.gDF.getData().getGroup().getPosition();
                                String business = GroupInfoActivity.this.gDF.getData().getGroup().getBusiness();
                                StringBuffer stringBuffer = new StringBuffer();
                                if (position != null) {
                                    stringBuffer.append(position);
                                }
                                if (business != null) {
                                    stringBuffer.append(business);
                                }
                                GroupInfoActivity.this.gDE.l(GroupInfoActivity.this.gDF.getData().bCN(), stringBuffer.toString());
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
                        if (requestRemoveMembersMessage.getGroupId() == GroupInfoActivity.this.gDF.getGroupId()) {
                            String userIds = requestRemoveMembersMessage.getUserIds();
                            if (!TextUtils.isEmpty(userIds) && (split = userIds.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) != null && split.length != 0) {
                                String id = TbadkApplication.getCurrentAccountObj().getID();
                                if (!TextUtils.isEmpty(id)) {
                                    for (String str : split) {
                                        if (id.equals(str)) {
                                            ResponseGroupInfoLocalMessage.a data = GroupInfoActivity.this.gDF.getData();
                                            data.vk(data.bCL() + 1);
                                            data.mh(false);
                                            GroupInfoActivity.this.gDF.setHasRecentJoin(false);
                                            GroupInfoActivity.this.gDE.a(data, true);
                                            GroupInfoActivity.this.gDE.yy(str);
                                            GroupInfoActivity.this.bBN();
                                            return;
                                        }
                                        if (GroupInfoActivity.this.gDF.removeMemberByUid(str)) {
                                            GroupInfoActivity.this.gDE.yy(str);
                                            GroupData group = GroupInfoActivity.this.gDF.getData().getGroup();
                                            if (group != null && group.getMemberNum() > 1) {
                                                group.setMemberNum(group.getMemberNum() - 1);
                                            }
                                            GroupInfoActivity.this.gDE.setData(GroupInfoActivity.this.gDF.getData());
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
                    if (responseDismissGroupMessage.getError() == 0 && GroupInfoActivity.this.gDF.getGroupId() == responseDismissGroupMessage.getGroupId()) {
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
        if (groupNewsPojo != null && this.gDF != null && this.gDF.getData() != null) {
            try {
                JSONObject jSONObject = new JSONObject(groupNewsPojo.getContent());
                String string = jSONObject.getJSONObject("eventParam").getString("groupId");
                if (jSONObject.getString("eventId").equals("003") && string.equals(String.valueOf(this.gDF.getGroupId())) && this.gDF.getData().bCM()) {
                    this.gDF.getData().mh(false);
                    GroupData group = this.gDF.getData().getGroup();
                    if (group != null && group.getMemberNum() > 1) {
                        group.setMemberNum(group.getMemberNum() - 1);
                    }
                    this.gDE.a(this.gDF.getData(), true);
                    bBN();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void f(GroupNewsPojo groupNewsPojo) {
        try {
            String optString = new JSONObject(groupNewsPojo.getContent()).optJSONObject("eventParam").optString("groupId");
            if (!TextUtils.isEmpty(optString) && this.gDF != null && optString.equals(String.valueOf(this.gDF.getGroupId())) && this.gDF.getData() != null) {
                this.gDF.getData().mh(true);
                if (this.gDE != null) {
                    this.gDE.mc(true);
                    this.gDE.bCd();
                    bBN();
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(GroupNewsPojo groupNewsPojo) {
        if (groupNewsPojo != null && this.gDF != null && this.gDF.getData() != null) {
            try {
                JSONObject jSONObject = new JSONObject(groupNewsPojo.getContent());
                JSONObject jSONObject2 = jSONObject.getJSONObject("eventParam");
                String string = jSONObject2.getString("groupId");
                if (jSONObject.getString("eventId").equals("101") && string.equals(String.valueOf(this.gDF.getGroupId()))) {
                    String string2 = jSONObject2.getString("groupName");
                    if (!TextUtils.isEmpty(string2)) {
                        this.gDE.setGroupName(string2);
                        if (this.gDF.getData() != null && this.gDF.getData().getGroup() != null) {
                            this.gDF.getData().getGroup().setName(string2);
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
        if (groupNewsPojo != null && this.gDF != null) {
            try {
                JSONObject jSONObject = new JSONObject(groupNewsPojo.getContent());
                String string = jSONObject.getJSONObject("eventParam").getString("groupId");
                if (jSONObject.getString("eventId").equals("107") && string.equals(String.valueOf(this.gDF.getGroupId()))) {
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
    public void bBN() {
        if (this.gDF != null) {
            this.gDF.clearGroupInfoCache(String.valueOf(this.gDF.getGroupId()));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 1) {
            if (ab.cx(getApplicationContext())) {
                ak.c(getPageContext());
            } else {
                showToast(R.string.system_permission_prompt_camera);
            }
            ArrayMap<String, Boolean> b = ab.b(strArr, iArr);
            if (b.containsKey("android.permission.WRITE_EXTERNAL_STORAGE") && !b.get("android.permission.WRITE_EXTERNAL_STORAGE").booleanValue()) {
                showToast(R.string.sdcard_permission_denied_advert_for_camera);
            }
        }
    }
}
