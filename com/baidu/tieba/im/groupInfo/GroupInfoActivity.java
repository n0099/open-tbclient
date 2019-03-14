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
import com.baidu.tbadk.core.dialog.g;
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
import com.baidu.tieba.d;
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
public class GroupInfoActivity extends BaseActivity<GroupInfoActivity> implements View.OnClickListener, View.OnLongClickListener, a.InterfaceC0042a, c, d {
    private UpdateGroupModel gaP;
    private com.baidu.tieba.im.groupInfo.a gmA;
    private GroupInfoModel gmB;
    private a gmC;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgement;
    private int type = 0;
    private final WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private long gmD = -1;
    private long gmE = -1;
    private final b.InterfaceC0225b gmF = new b.InterfaceC0225b() { // from class: com.baidu.tieba.im.groupInfo.GroupInfoActivity.1
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0225b
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
    private final b gmG = new b() { // from class: com.baidu.tieba.im.groupInfo.GroupInfoActivity.2
        @Override // com.baidu.tieba.im.groupInfo.b
        public void a(g gVar, int i, Object obj, int i2) {
            if (gVar != null && gVar.isShowing()) {
                gVar.dismiss();
            }
            if (i == 0) {
                if (i2 != 0) {
                    GroupInfoActivity.this.aw(obj);
                } else {
                    GroupInfoActivity.this.showToast(GroupInfoActivity.this.getPageContext().getString(d.j.has_set_portrait));
                }
            } else if (i == 1) {
                if (i2 == 0) {
                    GroupInfoActivity.this.showToast(GroupInfoActivity.this.getPageContext().getString(d.j.group_portrait_cant_del));
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
                GroupInfoActivity.this.gmA.bun();
                GroupInfoActivity.this.showToast(d.j.neterror);
            } else if (customResponsedMessage.getCmd() == 2001102) {
                if (!(customResponsedMessage instanceof ResponseGroupInfoLocalMessage)) {
                    GroupInfoActivity.this.gmB.sendMessage(GroupInfoActivity.this.gmB.getGroupId(), GroupInfoActivity.this.gmB.getFrom());
                    return;
                }
                ResponseGroupInfoLocalMessage responseGroupInfoLocalMessage = (ResponseGroupInfoLocalMessage) customResponsedMessage;
                if (responseGroupInfoLocalMessage.getOrginalMessage() == null || ((RequestGroupInfoLocalMessage) responseGroupInfoLocalMessage.getOrginalMessage()).getGroupId() == GroupInfoActivity.this.gmB.getGroupId()) {
                    if (responseGroupInfoLocalMessage.getError() != 0) {
                        GroupInfoActivity.this.gmB.sendMessage(GroupInfoActivity.this.gmB.getGroupId(), GroupInfoActivity.this.gmB.getFrom());
                        return;
                    }
                    GroupInfoActivity.this.loadImage();
                    GroupInfoActivity.this.gmB.setData(responseGroupInfoLocalMessage.getData());
                    GroupInfoActivity.this.gmA.setData(responseGroupInfoLocalMessage.getData());
                    GroupInfoActivity.this.btY();
                }
            }
        }
    };
    private final CustomMessageListener gjY = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.groupInfo.GroupInfoActivity.4
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
        btY();
        startLoading();
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        a((Bundle) null, intent);
        this.gmE = this.gmB.getGroupId();
        startLoading();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btY() {
        if (this.gmB != null) {
            long groupId = this.gmB.getGroupId();
            this.gmE = groupId;
            this.gmD = groupId;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btZ() {
        if (this.gmD != this.gmE) {
            initUI();
            btY();
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void initListener() {
        this.gmC = new a();
        registerListener(103004, this.gmC);
        registerListener(2001102, this.mCustomListener);
        registerListener(103102, this.gmC);
        registerListener(103112, this.gmC);
        registerListener(103110, this.gmC);
        registerListener(103120, this.gmC);
        registerListener(103121, this.gmC);
        registerListener(2001128, this.gjY);
        registerListener(2001126, this.gjY);
        registerListener(2001130, this.gjY);
        registerListener(103104, this.gmC);
        registerListener(2001137, this.gjY);
        registerListener(2001135, this.gjY);
        registerListener(103105, this.gmC);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.gmB.saveInstance(bundle);
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
        this.gmB.cancelMessage();
        MessageManager.getInstance().unRegisterListener(this.gjY);
        if (this.gmA != null) {
            this.gmA.onDestory();
        }
    }

    private void initUI() {
        this.gmA = new com.baidu.tieba.im.groupInfo.a(this);
        this.gmA.a(this.gmG);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startLoading() {
        this.gmA.buo();
        this.gmB.sendLocalMessage(this.gmB.getGroupId(), this.gmB.getFrom());
        this.gmB.sendMessage(this.gmB.getGroupId(), this.gmB.getFrom());
    }

    public void a(Bundle bundle, Intent intent) {
        this.gmB = new GroupInfoModel(this);
        this.gmB.setUniqueId(getUniqueId());
        if (bundle == null) {
            GroupInfoModel groupInfoModel = this.gmB;
            if (intent == null) {
                intent = getIntent();
            }
            groupInfoModel.initWithIntent(intent);
        } else {
            this.gmB.initWithBundle(bundle);
        }
        this.gaP = new UpdateGroupModel(getPageContext());
        this.gaP.setUniqueId(getUniqueId());
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
        if (this.gmA != null) {
            this.gmA.changeSkinType(i);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gmA.bup()) {
            if (this.gmB.getData() != null && this.gmB.getData().bva()) {
                TiebaStatic.log("edit_place_at_groupinfo");
                sendMessage(new CustomMessage(2002001, new GroupAddressLocateActivityConfig(getPageContext().getPageActivity(), 21001, this.gmB.getData().getGroup().getPosition(), this.gmB.getData().getGroup().getBusiness(), (this.gmB.getData().getGroup().getFlag() & 1) == 1)));
            }
        } else if (view == this.gmA.bsW()) {
            closeActivity();
        } else if (view != this.gmA.buc()) {
            if (view == this.gmA.buk()) {
                if (this.gmB.getData() != null && this.gmB.getData().getGroup() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), String.valueOf(this.gmB.getData().getGroup().getAuthorId()), this.gmB.getData().getGroup().getAuthorName())));
                }
            } else if (view == this.gmA.bul()) {
                if (this.gmB != null && this.gmB.getData() != null) {
                    sendMessage(new CustomMessage(2002001, new GroupLevelActivityConfig(getPageContext().getPageActivity(), this.gmB.getGroupId(), this.gmB.getData().isMemGroup())));
                }
            } else if (view == this.gmA.buj()) {
                if (TextUtils.isEmpty(TbadkApplication.getCurrentAccount())) {
                    TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 3)));
                } else if (this.gmB.getData() != null) {
                    if (this.gmB.getData().buZ()) {
                        if (this.gmB.getData().getGroup() != null) {
                            TiebaStatic.log(new am("c10334").bJ("obj_type", String.valueOf(this.gmB.getData().getGroup().getGroupId())));
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(getPageContext().getPageActivity(), this.gmB.getGroupId(), this.gmB.getData().getGroup().getName(), this.gmB.getData().getGroup().getAuthorId(), "group_info")));
                        }
                    } else if (this.gmB.hasRecentJoin()) {
                        showToast(d.j.has_recent_join);
                    } else if (this.gmB.getData() != null) {
                        if (this.gmB.getData().buY() <= 0) {
                            showToast(d.j.add_group_max);
                        } else if (ApplyJoinGroupActivityConfig.JOINTYPE_DEFAULT == this.gmB.getJoinType()) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2008014, new ApplyJoinGroupActivityConfig(getPageContext().getPageActivity(), "" + this.gmB.getGroupId(), this.gmB.getData().buX(), this.gmB.getData().buY())));
                        } else if (ApplyJoinGroupActivityConfig.JOINTYPE_INVITE == this.gmB.getJoinType()) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2008014, new ApplyJoinGroupActivityConfig(getPageContext().getPageActivity(), "" + this.gmB.getGroupId(), this.gmB.getData().buX(), this.gmB.getData().buY(), this.gmB.getInviteUserId(), this.gmB.getDefaultUserMsg())));
                        }
                    }
                }
            } else if (view == this.gmA.bui()) {
                if (this.gmB.getData() != null && this.gmB.getData().getGroup() != null) {
                    sendMessage(new CustomMessage(2002001, new GroupSettingActivityConfig(getPageContext().getPageActivity(), 4, this.gmB.getData().getGroup().getName(), "" + this.gmB.getGroupId(), this.gmB.getData().bva(), this.gmB.getData().getGroup().getFlag())));
                }
            } else if (view == this.gmA.bug()) {
                if (this.gmB.getData() != null && this.gmB.getData().getGroup() != null) {
                    sendMessage(new CustomMessage(2002001, new UpdateGroupActivityConfig(getPageContext().getPageActivity(), 1, this.gmB.getGroupId(), 1, this.gmB.getData().getGroup().getName())));
                }
            } else if (view == this.gmA.buf()) {
                if (this.gmB.getData() != null && this.gmB.getData().bva() && this.gmB.getData().getGroup() != null) {
                    sendMessage(new CustomMessage(2002001, new UpdateGroupActivityConfig(getPageContext().getPageActivity(), 2, this.gmB.getGroupId(), 2, this.gmB.getData().getGroup().getIntro())));
                }
            } else if (view == this.gmA.bum() || view == this.gmA.bud()) {
                MembersActivity.i(getPageContext().getPageActivity(), this.gmB.getGroupId());
            } else if (view == this.gmA.bue()) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new InviteFriendListActivityConfig(getPageContext().getPageActivity(), 0L, this.gmB.getGroupId())));
            } else if (view == this.gmA.buh() && this.gmB.getData() != null && this.gmB.getData().buZ()) {
                GroupActivityData buU = this.gmB.getData().buU();
                if (buU != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupActivityActivityConfig(getPageContext().getPageActivity(), buU.getActivityId(), this.gmB.getGroupId(), 0)));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CreateGroupActivityActivityConfig(getPageContext().getPageActivity(), this.gmB.getGroupId())));
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
        this.gmA.d(obj, i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        if (view == this.gmA.bub()) {
            if (this.gmB.getData() == null || this.gmB.getData().getGroup() == null) {
                return false;
            }
            this.gmA.xk(String.valueOf(this.gmB.getData().getGroup().getGroupId()));
            return false;
        } else if (view != this.gmA.buf() || this.gmB.getData().bva()) {
            return false;
        } else {
            if (this.gmB.getData() != null && this.gmB.getData().getGroup() != null) {
                this.gmA.xj(String.valueOf(this.gmB.getData().getGroup().getIntro()));
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
            this.mPermissionJudgement.adQ();
            this.mPermissionJudgement.e(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgement.Y(pageActivity)) {
                AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true);
                albumActivityConfig.setRequestCode(IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK);
                albumActivityConfig.setResourceType(2);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
            }
        } else if (i == 1) {
            ArrayList<String> bigUrlList = this.gmB.getBigUrlList();
            HashMap<String, ImageUrlData> assistUrls = this.gmB.getAssistUrls();
            if (obj != null && (obj instanceof PhotoUrlData) && bigUrlList != null) {
                sendMessage(new CustomMessage(2002001, new GroupImageActivityConfig(getPageContext().getPageActivity(), ((PhotoUrlData) obj).getBigurl(), bigUrlList, this.gmB.getGroupId(), assistUrls)));
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
                        if (this.gmA != null) {
                            this.gmA.setGroupName(stringExtra);
                        }
                        if (this.gmB != null && this.gmB.getData() != null && this.gmB.getData().getGroup() != null) {
                            this.gmB.getData().getGroup().setName(stringExtra);
                            return;
                        }
                        return;
                    }
                    return;
                case 2:
                    if (intent != null) {
                        String stringExtra2 = intent.getStringExtra(UpdateGroupActivityConfig.GROUP_TEXT);
                        if (this.gmA != null) {
                            this.gmA.xh(stringExtra2);
                        }
                        if (this.gmB != null && this.gmB.getData() != null && this.gmB.getData().getGroup() != null) {
                            this.gmB.getData().getGroup().setIntro(stringExtra2);
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
                        if (this.gmB != null && this.gmB.getData() != null && this.gmB.getData().getGroup() != null) {
                            this.gmB.getData().getGroup().setFlag(intExtra);
                            return;
                        }
                        return;
                    }
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK /* 12002 */:
                    if (intent != null) {
                        intent.getBooleanExtra(AlbumActivityConfig.CAMERA_RESULT, false);
                        aj(intent);
                        break;
                    } else {
                        return;
                    }
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_DYNAMIC_PWD /* 12009 */:
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_LOGIN_PROXY_RESULT /* 12010 */:
                    break;
                case 21001:
                    h(intent.getBooleanExtra("ResultDataIsHiddenAddress", true) ? 1 : 0, intent.getStringExtra("ResultDataAddress"), intent.getStringExtra("ResultDataSelectedBusiness"));
                    return;
                default:
                    return;
            }
            PhotoUrlData photoUrlData = (PhotoUrlData) intent.getSerializableExtra(EditHeadActivityConfig.PIC_INFO);
            if (photoUrlData != null) {
                ac.acT().d(photoUrlData.getSmallurl(), m.lP(TbConfig.GROUP_HEAD_FILE), true, false, true);
            }
            b(photoUrlData);
        } else if (i2 == 0 && i == 12010) {
            takePhoto();
        }
    }

    private void aj(Intent intent) {
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
            xf(this.gmB.generateDeleAlbum(photoUrlData));
        }
    }

    private void b(PhotoUrlData photoUrlData) {
        this.type = 1;
        if (photoUrlData != null) {
            String generateAddAlbum = this.gmB.generateAddAlbum(photoUrlData);
            if (!TextUtils.isEmpty(generateAddAlbum)) {
                xf(generateAddAlbum);
            }
        }
    }

    private void h(int i, String str, String str2) {
        this.type = 4;
        if (this.gaP != null) {
            this.gaP.setGroupId(this.gmB.getGroupId());
            this.gaP.setFlag(i);
            this.gaP.setPosition(str);
            this.gaP.setBusiness(str2);
            this.gaP.sendMessage(5);
            this.gmA.buo();
        }
    }

    private void xf(String str) {
        if (this.gaP != null) {
            this.gaP.setGroupId(this.gmB.getGroupId());
            this.gaP.setAlbum(str);
            this.gaP.sendMessage(3);
            this.gmA.buo();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aw(Object obj) {
        GroupCardModel.btO();
        this.type = 3;
        if (obj != null && (obj instanceof PhotoUrlData)) {
            PhotoUrlData photoUrlData = (PhotoUrlData) obj;
            this.gmB.setChangePhotoUrlData(photoUrlData);
            String picId = photoUrlData.getPicId();
            if (this.gaP != null) {
                this.gaP.setGroupId(this.gmB.getGroupId());
                this.gaP.setPortrait(picId);
                this.gaP.sendMessage(4);
                this.gmA.buo();
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
                GroupInfoActivity.this.gmA.bun();
                GroupInfoActivity.this.showToast(d.j.neterror);
            } else if (socketResponsedMessage.getCmd() == 103004) {
                GroupInfoActivity.this.gmA.bun();
                final ResponseGroupInfoMessage responseGroupInfoMessage = (ResponseGroupInfoMessage) socketResponsedMessage;
                if (GroupInfoActivity.this.gmB.getSendMsg() == responseGroupInfoMessage.getOrginalMessage()) {
                    if (responseGroupInfoMessage.getError() == 2230101) {
                        GroupInfoActivity.this.showToast(StringUtils.isNull(responseGroupInfoMessage.getErrorString()) ? GroupInfoActivity.this.getResources().getString(d.j.neterror) : responseGroupInfoMessage.getErrorString(), false);
                        GroupInfoActivity.this.finish();
                    } else if (responseGroupInfoMessage.getData() != null && responseGroupInfoMessage.getError() == 0) {
                        GroupInfoActivity.this.btY();
                        GroupInfoActivity.this.loadImage();
                        GroupInfoActivity.this.gmB.setData(responseGroupInfoMessage.getData());
                        if (responseGroupInfoMessage == null || responseGroupInfoMessage.getData().buZ()) {
                            GroupInfoActivity.this.gmA.a(responseGroupInfoMessage.getData(), false);
                            return;
                        }
                        GroupInfoActivity.this.gmA.buo();
                        com.baidu.tieba.im.settingcache.b.bwa().a(TbadkApplication.getCurrentAccount(), String.valueOf(GroupInfoActivity.this.gmB.getGroupId()), 60000L, new k<Boolean>() { // from class: com.baidu.tieba.im.groupInfo.GroupInfoActivity.a.1
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.tbadk.util.k
                            public void onReturnDataInUI(Boolean bool) {
                                if (bool == null) {
                                    bool = false;
                                }
                                GroupInfoActivity.this.gmA.bun();
                                GroupInfoActivity.this.gmA.a(responseGroupInfoMessage.getData(), bool.booleanValue());
                                GroupInfoActivity.this.gmB.setHasRecentJoin(bool.booleanValue() ? false : true);
                            }
                        });
                    } else {
                        GroupInfoActivity.this.showToast(d.j.neterror);
                        GroupInfoActivity.this.btZ();
                    }
                }
            } else if (socketResponsedMessage.getCmd() == 103110) {
                if (socketResponsedMessage instanceof ResponseJoinGroupMessage) {
                    ResponseJoinGroupMessage responseJoinGroupMessage = (ResponseJoinGroupMessage) socketResponsedMessage;
                    if (responseJoinGroupMessage.getError() == 0 && (orginalMessage2 = responseJoinGroupMessage.getOrginalMessage()) != null && (orginalMessage2 instanceof RequestJoinGroupMessage) && ((RequestJoinGroupMessage) orginalMessage2).getGroupId() == GroupInfoActivity.this.gmB.getGroupId()) {
                        GroupInfoActivity.this.gmA.bus();
                        GroupInfoActivity.this.gmB.setHasRecentJoin(true);
                        GroupInfoActivity.this.bua();
                    }
                }
            } else if (socketResponsedMessage.getCmd() == 103102) {
                GroupInfoActivity.this.gmA.bun();
                if (socketResponsedMessage.getError() != 0) {
                    GroupInfoActivity.this.showToast(d.j.neterror);
                    return;
                }
                ResponseUpdateGroupMessage responseUpdateGroupMessage = (ResponseUpdateGroupMessage) socketResponsedMessage;
                if (responseUpdateGroupMessage.getError() != 0) {
                    GroupInfoActivity.this.showToast(StringUtils.isNull(responseUpdateGroupMessage.getErrorString()) ? GroupInfoActivity.this.getResources().getString(d.j.neterror) : responseUpdateGroupMessage.getErrorString());
                } else if (responseUpdateGroupMessage.getOrginalMessage() instanceof RequestUpdateGroupMessage) {
                    int type = ((RequestUpdateGroupMessage) responseUpdateGroupMessage.getOrginalMessage()).getType();
                    switch (GroupInfoActivity.this.type) {
                        case 1:
                            if (type == 3) {
                                GroupInfoActivity.this.gmB.addPhotoData();
                                GroupInfoActivity.this.gmA.a(GroupInfoActivity.this.gmB.getData());
                                return;
                            }
                            return;
                        case 2:
                            if (type == 3) {
                                GroupInfoActivity.this.gmB.delePhotoData();
                                GroupInfoActivity.this.gmA.a(GroupInfoActivity.this.gmB.getData());
                                return;
                            }
                            return;
                        case 3:
                            if (type == 4) {
                                GroupInfoActivity.this.gmB.updataPortraitData();
                                GroupInfoActivity.this.gmA.a(GroupInfoActivity.this.gmB.getData());
                                return;
                            }
                            return;
                        case 4:
                            GroupInfoActivity.this.gmB.getData().getGroup().setFlag(GroupInfoActivity.this.gaP.getFlag());
                            GroupInfoActivity.this.gmB.getData().getGroup().setPosition(GroupInfoActivity.this.gaP.getPosition());
                            GroupInfoActivity.this.gmB.getData().getGroup().setBusiness(GroupInfoActivity.this.gaP.getBusiness());
                            if ((GroupInfoActivity.this.gmB.getData().getGroup().getFlag() & 1) == 1) {
                                GroupInfoActivity.this.gmA.lk(GroupInfoActivity.this.gmB.getData().bva());
                            } else {
                                String position = GroupInfoActivity.this.gmB.getData().getGroup().getPosition();
                                String business = GroupInfoActivity.this.gmB.getData().getGroup().getBusiness();
                                StringBuffer stringBuffer = new StringBuffer();
                                if (position != null) {
                                    stringBuffer.append(position);
                                }
                                if (business != null) {
                                    stringBuffer.append(business);
                                }
                                GroupInfoActivity.this.gmA.m(GroupInfoActivity.this.gmB.getData().bva(), stringBuffer.toString());
                            }
                            GroupInfoActivity.this.showToast(d.j.operation_success);
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
                        if (requestRemoveMembersMessage.getGroupId() == GroupInfoActivity.this.gmB.getGroupId()) {
                            String userIds = requestRemoveMembersMessage.getUserIds();
                            if (!TextUtils.isEmpty(userIds) && (split = userIds.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) != null && split.length != 0) {
                                String id = TbadkApplication.getCurrentAccountObj().getID();
                                if (!TextUtils.isEmpty(id)) {
                                    for (String str : split) {
                                        if (id.equals(str)) {
                                            ResponseGroupInfoLocalMessage.a data = GroupInfoActivity.this.gmB.getData();
                                            data.uh(data.buY() + 1);
                                            data.lr(false);
                                            GroupInfoActivity.this.gmB.setHasRecentJoin(false);
                                            GroupInfoActivity.this.gmA.a(data, true);
                                            GroupInfoActivity.this.gmA.xi(str);
                                            GroupInfoActivity.this.bua();
                                            return;
                                        }
                                        if (GroupInfoActivity.this.gmB.removeMemberByUid(str)) {
                                            GroupInfoActivity.this.gmA.xi(str);
                                            GroupData group = GroupInfoActivity.this.gmB.getData().getGroup();
                                            if (group != null && group.getMemberNum() > 1) {
                                                group.setMemberNum(group.getMemberNum() - 1);
                                            }
                                            GroupInfoActivity.this.gmA.setData(GroupInfoActivity.this.gmB.getData());
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
                    if (responseDismissGroupMessage.getError() == 0 && GroupInfoActivity.this.gmB.getGroupId() == responseDismissGroupMessage.getGroupId()) {
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
        if (groupNewsPojo != null && this.gmB != null && this.gmB.getData() != null) {
            try {
                JSONObject jSONObject = new JSONObject(groupNewsPojo.getContent());
                String string = jSONObject.getJSONObject("eventParam").getString("groupId");
                if (jSONObject.getString("eventId").equals("003") && string.equals(String.valueOf(this.gmB.getGroupId())) && this.gmB.getData().buZ()) {
                    this.gmB.getData().lr(false);
                    GroupData group = this.gmB.getData().getGroup();
                    if (group != null && group.getMemberNum() > 1) {
                        group.setMemberNum(group.getMemberNum() - 1);
                    }
                    this.gmA.a(this.gmB.getData(), true);
                    bua();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void f(GroupNewsPojo groupNewsPojo) {
        try {
            String optString = new JSONObject(groupNewsPojo.getContent()).optJSONObject("eventParam").optString("groupId");
            if (!TextUtils.isEmpty(optString) && this.gmB != null && optString.equals(String.valueOf(this.gmB.getGroupId())) && this.gmB.getData() != null) {
                this.gmB.getData().lr(true);
                if (this.gmA != null) {
                    this.gmA.lm(true);
                    this.gmA.buq();
                    bua();
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(GroupNewsPojo groupNewsPojo) {
        if (groupNewsPojo != null && this.gmB != null && this.gmB.getData() != null) {
            try {
                JSONObject jSONObject = new JSONObject(groupNewsPojo.getContent());
                JSONObject jSONObject2 = jSONObject.getJSONObject("eventParam");
                String string = jSONObject2.getString("groupId");
                if (jSONObject.getString("eventId").equals("101") && string.equals(String.valueOf(this.gmB.getGroupId()))) {
                    String string2 = jSONObject2.getString("groupName");
                    if (!TextUtils.isEmpty(string2)) {
                        this.gmA.setGroupName(string2);
                        if (this.gmB.getData() != null && this.gmB.getData().getGroup() != null) {
                            this.gmB.getData().getGroup().setName(string2);
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
        if (groupNewsPojo != null && this.gmB != null) {
            try {
                JSONObject jSONObject = new JSONObject(groupNewsPojo.getContent());
                String string = jSONObject.getJSONObject("eventParam").getString("groupId");
                if (jSONObject.getString("eventId").equals("107") && string.equals(String.valueOf(this.gmB.getGroupId()))) {
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
    public void bua() {
        if (this.gmB != null) {
            this.gmB.clearGroupInfoCache(String.valueOf(this.gmB.getGroupId()));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 1) {
            if (ab.cS(getApplicationContext())) {
                ak.c(getPageContext());
            } else {
                showToast(d.j.system_permission_prompt_camera);
            }
            ArrayMap<String, Boolean> b = ab.b(strArr, iArr);
            if (b.containsKey("android.permission.WRITE_EXTERNAL_STORAGE") && !b.get("android.permission.WRITE_EXTERNAL_STORAGE").booleanValue()) {
                showToast(d.j.sdcard_permission_denied_advert_for_camera);
            }
        }
    }
}
