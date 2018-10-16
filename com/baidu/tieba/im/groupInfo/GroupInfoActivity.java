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
import com.baidu.f.a.a;
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
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.ac;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.l;
import com.baidu.tbadk.coreExtra.data.PhotoUrlData;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.util.h;
import com.baidu.tieba.e;
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
/* loaded from: classes3.dex */
public class GroupInfoActivity extends BaseActivity<GroupInfoActivity> implements View.OnClickListener, View.OnLongClickListener, a.InterfaceC0073a, c, d {
    private com.baidu.tbadk.core.util.b.a buX;
    private com.baidu.tieba.im.groupInfo.a eKH;
    private GroupInfoModel eKI;
    private a eKJ;
    private UpdateGroupModel ezb;
    private int type = 0;
    private final WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private long eKK = -1;
    private long eKL = -1;
    private final b.InterfaceC0124b eKM = new b.InterfaceC0124b() { // from class: com.baidu.tieba.im.groupInfo.GroupInfoActivity.1
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0124b
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
    private final b eKN = new b() { // from class: com.baidu.tieba.im.groupInfo.GroupInfoActivity.2
        @Override // com.baidu.tieba.im.groupInfo.b
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, Object obj, int i2) {
            bVar.dismiss();
            if (i == 0) {
                if (i2 != 0) {
                    GroupInfoActivity.this.ah(obj);
                } else {
                    GroupInfoActivity.this.showToast(GroupInfoActivity.this.getPageContext().getString(e.j.has_set_portrait));
                }
            } else if (i == 1) {
                if (i2 == 0) {
                    GroupInfoActivity.this.showToast(GroupInfoActivity.this.getPageContext().getString(e.j.group_portrait_cant_del));
                } else if (obj != null && (obj instanceof PhotoUrlData)) {
                    GroupInfoActivity.this.a((PhotoUrlData) obj);
                }
            } else if (i == 2) {
                GroupInfoActivity.this.eKH.aRl();
            }
        }
    };
    private final CustomMessageListener mCustomListener = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.groupInfo.GroupInfoActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null) {
                GroupInfoActivity.this.eKH.aRg();
                GroupInfoActivity.this.showToast(e.j.neterror);
            } else if (customResponsedMessage.getCmd() == 2001102) {
                if (!(customResponsedMessage instanceof ResponseGroupInfoLocalMessage)) {
                    GroupInfoActivity.this.eKI.sendMessage(GroupInfoActivity.this.eKI.getGroupId(), GroupInfoActivity.this.eKI.getFrom());
                    return;
                }
                ResponseGroupInfoLocalMessage responseGroupInfoLocalMessage = (ResponseGroupInfoLocalMessage) customResponsedMessage;
                if (responseGroupInfoLocalMessage.getOrginalMessage() == null || ((RequestGroupInfoLocalMessage) responseGroupInfoLocalMessage.getOrginalMessage()).getGroupId() == GroupInfoActivity.this.eKI.getGroupId()) {
                    if (responseGroupInfoLocalMessage.getError() != 0) {
                        GroupInfoActivity.this.eKI.sendMessage(GroupInfoActivity.this.eKI.getGroupId(), GroupInfoActivity.this.eKI.getFrom());
                        return;
                    }
                    GroupInfoActivity.this.loadImage();
                    GroupInfoActivity.this.eKI.setData(responseGroupInfoLocalMessage.getData());
                    GroupInfoActivity.this.eKH.setData(responseGroupInfoLocalMessage.getData());
                    GroupInfoActivity.this.aQR();
                }
            }
        }
    };
    private final CustomMessageListener eIe = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.groupInfo.GroupInfoActivity.4
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
        aQR();
        startLoading();
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        a((Bundle) null, intent);
        this.eKL = this.eKI.getGroupId();
        startLoading();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQR() {
        if (this.eKI != null) {
            long groupId = this.eKI.getGroupId();
            this.eKL = groupId;
            this.eKK = groupId;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQS() {
        if (this.eKK != this.eKL) {
            initUI();
            aQR();
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void initListener() {
        this.eKJ = new a();
        registerListener(103004, this.eKJ);
        registerListener(2001102, this.mCustomListener);
        registerListener(103102, this.eKJ);
        registerListener(103112, this.eKJ);
        registerListener(103110, this.eKJ);
        registerListener(103120, this.eKJ);
        registerListener(103121, this.eKJ);
        registerListener(2001128, this.eIe);
        registerListener(2001126, this.eIe);
        registerListener(2001130, this.eIe);
        registerListener(103104, this.eKJ);
        registerListener(2001137, this.eIe);
        registerListener(2001135, this.eIe);
        registerListener(103105, this.eKJ);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.eKI.saveInstance(bundle);
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
        this.eKI.cancelMessage();
        MessageManager.getInstance().unRegisterListener(this.eIe);
        if (this.eKH != null) {
            this.eKH.onDestory();
        }
    }

    private void initUI() {
        this.eKH = new com.baidu.tieba.im.groupInfo.a(this);
        this.eKH.a(this.eKN);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startLoading() {
        this.eKH.aRh();
        this.eKI.sendLocalMessage(this.eKI.getGroupId(), this.eKI.getFrom());
        this.eKI.sendMessage(this.eKI.getGroupId(), this.eKI.getFrom());
    }

    public void a(Bundle bundle, Intent intent) {
        this.eKI = new GroupInfoModel(this);
        this.eKI.setUniqueId(getUniqueId());
        if (bundle == null) {
            GroupInfoModel groupInfoModel = this.eKI;
            if (intent == null) {
                intent = getIntent();
            }
            groupInfoModel.initWithIntent(intent);
        } else {
            this.eKI.initWithBundle(bundle);
        }
        this.ezb = new UpdateGroupModel(getPageContext());
        this.ezb.setUniqueId(getUniqueId());
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
        if (this.eKH != null) {
            this.eKH.changeSkinType(i);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.eKH.aRi()) {
            if (this.eKI.getData() != null && this.eKI.getData().aRT()) {
                TiebaStatic.log("edit_place_at_groupinfo");
                sendMessage(new CustomMessage(2002001, new GroupAddressLocateActivityConfig(getPageContext().getPageActivity(), 21001, this.eKI.getData().getGroup().getPosition(), this.eKI.getData().getGroup().getBusiness(), (this.eKI.getData().getGroup().getFlag() & 1) == 1)));
            }
        } else if (view == this.eKH.aPP()) {
            closeActivity();
        } else if (view != this.eKH.aQV()) {
            if (view == this.eKH.aRd()) {
                if (this.eKI.getData() != null && this.eKI.getData().getGroup() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), String.valueOf(this.eKI.getData().getGroup().getAuthorId()), this.eKI.getData().getGroup().getAuthorName())));
                }
            } else if (view == this.eKH.aRe()) {
                if (this.eKI != null && this.eKI.getData() != null) {
                    sendMessage(new CustomMessage(2002001, new GroupLevelActivityConfig(getPageContext().getPageActivity(), this.eKI.getGroupId(), this.eKI.getData().isMemGroup())));
                }
            } else if (view == this.eKH.aRc()) {
                if (TextUtils.isEmpty(TbadkApplication.getCurrentAccount())) {
                    TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 3)));
                } else if (this.eKI.getData() != null) {
                    if (this.eKI.getData().aRS()) {
                        if (this.eKI.getData().getGroup() != null) {
                            TiebaStatic.log(new am("c10334").ax("obj_type", String.valueOf(this.eKI.getData().getGroup().getGroupId())));
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(getPageContext().getPageActivity(), this.eKI.getGroupId(), this.eKI.getData().getGroup().getName(), this.eKI.getData().getGroup().getAuthorId(), "group_info")));
                        }
                    } else if (this.eKI.hasRecentJoin()) {
                        showToast(e.j.has_recent_join);
                    } else if (this.eKI.getData() != null) {
                        if (this.eKI.getData().aRR() <= 0) {
                            showToast(e.j.add_group_max);
                        } else if (ApplyJoinGroupActivityConfig.JOINTYPE_DEFAULT == this.eKI.getJoinType()) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2008014, new ApplyJoinGroupActivityConfig(getPageContext().getPageActivity(), "" + this.eKI.getGroupId(), this.eKI.getData().aRQ(), this.eKI.getData().aRR())));
                        } else if (ApplyJoinGroupActivityConfig.JOINTYPE_INVITE == this.eKI.getJoinType()) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2008014, new ApplyJoinGroupActivityConfig(getPageContext().getPageActivity(), "" + this.eKI.getGroupId(), this.eKI.getData().aRQ(), this.eKI.getData().aRR(), this.eKI.getInviteUserId(), this.eKI.getDefaultUserMsg())));
                        }
                    }
                }
            } else if (view == this.eKH.aRb()) {
                if (this.eKI.getData() != null && this.eKI.getData().getGroup() != null) {
                    sendMessage(new CustomMessage(2002001, new GroupSettingActivityConfig(getPageContext().getPageActivity(), 4, this.eKI.getData().getGroup().getName(), "" + this.eKI.getGroupId(), this.eKI.getData().aRT(), this.eKI.getData().getGroup().getFlag())));
                }
            } else if (view == this.eKH.aQZ()) {
                if (this.eKI.getData() != null && this.eKI.getData().getGroup() != null) {
                    sendMessage(new CustomMessage(2002001, new UpdateGroupActivityConfig(getPageContext().getPageActivity(), 1, this.eKI.getGroupId(), 1, this.eKI.getData().getGroup().getName())));
                }
            } else if (view == this.eKH.aQY()) {
                if (this.eKI.getData() != null && this.eKI.getData().aRT() && this.eKI.getData().getGroup() != null) {
                    sendMessage(new CustomMessage(2002001, new UpdateGroupActivityConfig(getPageContext().getPageActivity(), 2, this.eKI.getGroupId(), 2, this.eKI.getData().getGroup().getIntro())));
                }
            } else if (view == this.eKH.aRf() || view == this.eKH.aQW()) {
                MembersActivity.i(getPageContext().getPageActivity(), this.eKI.getGroupId());
            } else if (view == this.eKH.aQX()) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new InviteFriendListActivityConfig(getPageContext().getPageActivity(), 0L, this.eKI.getGroupId())));
            } else if (view == this.eKH.aRa() && this.eKI.getData() != null && this.eKI.getData().aRS()) {
                GroupActivityData aRN = this.eKI.getData().aRN();
                if (aRN != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupActivityActivityConfig(getPageContext().getPageActivity(), aRN.getActivityId(), this.eKI.getGroupId(), 0)));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CreateGroupActivityActivityConfig(getPageContext().getPageActivity(), this.eKI.getGroupId())));
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
        this.eKH.c(obj, i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        if (view == this.eKH.aQU()) {
            if (this.eKI.getData() == null || this.eKI.getData().getGroup() == null) {
                return false;
            }
            this.eKH.pK(String.valueOf(this.eKI.getData().getGroup().getGroupId()));
            return false;
        } else if (view != this.eKH.aQY() || this.eKI.getData().aRT()) {
            return false;
        } else {
            if (this.eKI.getData() != null && this.eKI.getData().getGroup() != null) {
                this.eKH.pJ(String.valueOf(this.eKI.getData().getGroup().getIntro()));
            }
            return true;
        }
    }

    @Override // com.baidu.tieba.im.groupInfo.c
    public void a(View view, int i, Object obj, int i2) {
        if (i == 2) {
            Activity pageActivity = getPageContext().getPageActivity();
            if (this.buX == null) {
                this.buX = new com.baidu.tbadk.core.util.b.a();
            }
            this.buX.Di();
            this.buX.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.buX.z(pageActivity)) {
                AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true);
                albumActivityConfig.setRequestCode(IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK);
                albumActivityConfig.setResourceType(2);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
            }
        } else if (i == 1) {
            ArrayList<String> bigUrlList = this.eKI.getBigUrlList();
            HashMap<String, ImageUrlData> assistUrls = this.eKI.getAssistUrls();
            if (obj != null && (obj instanceof PhotoUrlData) && bigUrlList != null) {
                sendMessage(new CustomMessage(2002001, new GroupImageActivityConfig(getPageContext().getPageActivity(), ((PhotoUrlData) obj).getBigurl(), bigUrlList, this.eKI.getGroupId(), assistUrls)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void takePhoto() {
        if (!ab.e(getPageContext().getPageActivity(), 1)) {
            ak.b(getPageContext());
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
                        if (this.eKH != null) {
                            this.eKH.setGroupName(stringExtra);
                        }
                        if (this.eKI != null && this.eKI.getData() != null && this.eKI.getData().getGroup() != null) {
                            this.eKI.getData().getGroup().setName(stringExtra);
                            return;
                        }
                        return;
                    }
                    return;
                case 2:
                    if (intent != null) {
                        String stringExtra2 = intent.getStringExtra(UpdateGroupActivityConfig.GROUP_TEXT);
                        if (this.eKH != null) {
                            this.eKH.pH(stringExtra2);
                        }
                        if (this.eKI != null && this.eKI.getData() != null && this.eKI.getData().getGroup() != null) {
                            this.eKI.getData().getGroup().setIntro(stringExtra2);
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
                        if (this.eKI != null && this.eKI.getData() != null && this.eKI.getData().getGroup() != null) {
                            this.eKI.getData().getGroup().setFlag(intExtra);
                            return;
                        }
                        return;
                    }
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK /* 12002 */:
                    if (intent != null) {
                        intent.getBooleanExtra(AlbumActivityConfig.CAMERA_RESULT, false);
                        S(intent);
                        break;
                    } else {
                        return;
                    }
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_DYNAMIC_PWD /* 12009 */:
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_LOGIN_PROXY_RESULT /* 12010 */:
                    break;
                case 21001:
                    g(intent.getBooleanExtra("ResultDataIsHiddenAddress", true) ? 1 : 0, intent.getStringExtra("ResultDataAddress"), intent.getStringExtra("ResultDataSelectedBusiness"));
                    return;
                default:
                    return;
            }
            PhotoUrlData photoUrlData = (PhotoUrlData) intent.getSerializableExtra(EditHeadActivityConfig.PIC_INFO);
            if (photoUrlData != null) {
                ac.Ck().d(photoUrlData.getSmallurl(), l.eB(TbConfig.GROUP_HEAD_FILE), true, false, true);
            }
            b(photoUrlData);
        } else if (i2 == 0 && i == 12010) {
            takePhoto();
        }
    }

    private void S(Intent intent) {
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
            pF(this.eKI.generateDeleAlbum(photoUrlData));
        }
    }

    private void b(PhotoUrlData photoUrlData) {
        this.type = 1;
        if (photoUrlData != null) {
            String generateAddAlbum = this.eKI.generateAddAlbum(photoUrlData);
            if (!TextUtils.isEmpty(generateAddAlbum)) {
                pF(generateAddAlbum);
            }
        }
    }

    private void g(int i, String str, String str2) {
        this.type = 4;
        if (this.ezb != null) {
            this.ezb.setGroupId(this.eKI.getGroupId());
            this.ezb.setFlag(i);
            this.ezb.setPosition(str);
            this.ezb.setBusiness(str2);
            this.ezb.sendMessage(5);
            this.eKH.aRh();
        }
    }

    private void pF(String str) {
        if (this.ezb != null) {
            this.ezb.setGroupId(this.eKI.getGroupId());
            this.ezb.setAlbum(str);
            this.ezb.sendMessage(3);
            this.eKH.aRh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ah(Object obj) {
        GroupCardModel.aQH();
        this.type = 3;
        if (obj != null && (obj instanceof PhotoUrlData)) {
            PhotoUrlData photoUrlData = (PhotoUrlData) obj;
            this.eKI.setChangePhotoUrlData(photoUrlData);
            String picId = photoUrlData.getPicId();
            if (this.ezb != null) {
                this.ezb.setGroupId(this.eKI.getGroupId());
                this.ezb.setPortrait(picId);
                this.ezb.sendMessage(4);
                this.eKH.aRh();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
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
                GroupInfoActivity.this.eKH.aRg();
                GroupInfoActivity.this.showToast(e.j.neterror);
            } else if (socketResponsedMessage.getCmd() == 103004) {
                GroupInfoActivity.this.eKH.aRg();
                final ResponseGroupInfoMessage responseGroupInfoMessage = (ResponseGroupInfoMessage) socketResponsedMessage;
                if (GroupInfoActivity.this.eKI.getSendMsg() == responseGroupInfoMessage.getOrginalMessage()) {
                    if (responseGroupInfoMessage.getError() == 2230101) {
                        GroupInfoActivity.this.showToast(StringUtils.isNull(responseGroupInfoMessage.getErrorString()) ? GroupInfoActivity.this.getResources().getString(e.j.neterror) : responseGroupInfoMessage.getErrorString(), false);
                        GroupInfoActivity.this.finish();
                    } else if (responseGroupInfoMessage.getData() != null && responseGroupInfoMessage.getError() == 0) {
                        GroupInfoActivity.this.aQR();
                        GroupInfoActivity.this.loadImage();
                        GroupInfoActivity.this.eKI.setData(responseGroupInfoMessage.getData());
                        if (responseGroupInfoMessage == null || responseGroupInfoMessage.getData().aRS()) {
                            GroupInfoActivity.this.eKH.a(responseGroupInfoMessage.getData(), false);
                            return;
                        }
                        GroupInfoActivity.this.eKH.aRh();
                        com.baidu.tieba.im.settingcache.b.aST().a(TbadkApplication.getCurrentAccount(), String.valueOf(GroupInfoActivity.this.eKI.getGroupId()), 60000L, new h<Boolean>() { // from class: com.baidu.tieba.im.groupInfo.GroupInfoActivity.a.1
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.tbadk.util.h
                            public void onReturnDataInUI(Boolean bool) {
                                if (bool == null) {
                                    bool = false;
                                }
                                GroupInfoActivity.this.eKH.aRg();
                                GroupInfoActivity.this.eKH.a(responseGroupInfoMessage.getData(), bool.booleanValue());
                                GroupInfoActivity.this.eKI.setHasRecentJoin(bool.booleanValue() ? false : true);
                            }
                        });
                    } else {
                        GroupInfoActivity.this.showToast(e.j.neterror);
                        GroupInfoActivity.this.aQS();
                    }
                }
            } else if (socketResponsedMessage.getCmd() == 103110) {
                if (socketResponsedMessage instanceof ResponseJoinGroupMessage) {
                    ResponseJoinGroupMessage responseJoinGroupMessage = (ResponseJoinGroupMessage) socketResponsedMessage;
                    if (responseJoinGroupMessage.getError() == 0 && (orginalMessage2 = responseJoinGroupMessage.getOrginalMessage()) != null && (orginalMessage2 instanceof RequestJoinGroupMessage) && ((RequestJoinGroupMessage) orginalMessage2).getGroupId() == GroupInfoActivity.this.eKI.getGroupId()) {
                        GroupInfoActivity.this.eKH.aRm();
                        GroupInfoActivity.this.eKI.setHasRecentJoin(true);
                        GroupInfoActivity.this.aQT();
                    }
                }
            } else if (socketResponsedMessage.getCmd() == 103102) {
                GroupInfoActivity.this.eKH.aRg();
                if (socketResponsedMessage.getError() != 0) {
                    GroupInfoActivity.this.showToast(e.j.neterror);
                    return;
                }
                ResponseUpdateGroupMessage responseUpdateGroupMessage = (ResponseUpdateGroupMessage) socketResponsedMessage;
                if (responseUpdateGroupMessage.getError() != 0) {
                    GroupInfoActivity.this.showToast(StringUtils.isNull(responseUpdateGroupMessage.getErrorString()) ? GroupInfoActivity.this.getResources().getString(e.j.neterror) : responseUpdateGroupMessage.getErrorString());
                } else if (responseUpdateGroupMessage.getOrginalMessage() instanceof RequestUpdateGroupMessage) {
                    int type = ((RequestUpdateGroupMessage) responseUpdateGroupMessage.getOrginalMessage()).getType();
                    switch (GroupInfoActivity.this.type) {
                        case 1:
                            if (type == 3) {
                                GroupInfoActivity.this.eKI.addPhotoData();
                                GroupInfoActivity.this.eKH.a(GroupInfoActivity.this.eKI.getData());
                                return;
                            }
                            return;
                        case 2:
                            if (type == 3) {
                                GroupInfoActivity.this.eKI.delePhotoData();
                                GroupInfoActivity.this.eKH.a(GroupInfoActivity.this.eKI.getData());
                                return;
                            }
                            return;
                        case 3:
                            if (type == 4) {
                                GroupInfoActivity.this.eKI.updataPortraitData();
                                GroupInfoActivity.this.eKH.a(GroupInfoActivity.this.eKI.getData());
                                return;
                            }
                            return;
                        case 4:
                            GroupInfoActivity.this.eKI.getData().getGroup().setFlag(GroupInfoActivity.this.ezb.getFlag());
                            GroupInfoActivity.this.eKI.getData().getGroup().setPosition(GroupInfoActivity.this.ezb.getPosition());
                            GroupInfoActivity.this.eKI.getData().getGroup().setBusiness(GroupInfoActivity.this.ezb.getBusiness());
                            if ((GroupInfoActivity.this.eKI.getData().getGroup().getFlag() & 1) == 1) {
                                GroupInfoActivity.this.eKH.iv(GroupInfoActivity.this.eKI.getData().aRT());
                            } else {
                                String position = GroupInfoActivity.this.eKI.getData().getGroup().getPosition();
                                String business = GroupInfoActivity.this.eKI.getData().getGroup().getBusiness();
                                StringBuffer stringBuffer = new StringBuffer();
                                if (position != null) {
                                    stringBuffer.append(position);
                                }
                                if (business != null) {
                                    stringBuffer.append(business);
                                }
                                GroupInfoActivity.this.eKH.i(GroupInfoActivity.this.eKI.getData().aRT(), stringBuffer.toString());
                            }
                            GroupInfoActivity.this.showToast(e.j.operation_success);
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
                        if (requestRemoveMembersMessage.getGroupId() == GroupInfoActivity.this.eKI.getGroupId()) {
                            String userIds = requestRemoveMembersMessage.getUserIds();
                            if (!TextUtils.isEmpty(userIds) && (split = userIds.split(",")) != null && split.length != 0) {
                                String id = TbadkApplication.getCurrentAccountObj().getID();
                                if (!TextUtils.isEmpty(id)) {
                                    for (String str : split) {
                                        if (id.equals(str)) {
                                            ResponseGroupInfoLocalMessage.a data = GroupInfoActivity.this.eKI.getData();
                                            data.pw(data.aRR() + 1);
                                            data.iC(false);
                                            GroupInfoActivity.this.eKI.setHasRecentJoin(false);
                                            GroupInfoActivity.this.eKH.a(data, true);
                                            GroupInfoActivity.this.eKH.pI(str);
                                            GroupInfoActivity.this.aQT();
                                            return;
                                        }
                                        if (GroupInfoActivity.this.eKI.removeMemberByUid(str)) {
                                            GroupInfoActivity.this.eKH.pI(str);
                                            GroupData group = GroupInfoActivity.this.eKI.getData().getGroup();
                                            if (group != null && group.getMemberNum() > 1) {
                                                group.setMemberNum(group.getMemberNum() - 1);
                                            }
                                            GroupInfoActivity.this.eKH.setData(GroupInfoActivity.this.eKI.getData());
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
                    if (responseDismissGroupMessage.getError() == 0 && GroupInfoActivity.this.eKI.getGroupId() == responseDismissGroupMessage.getGroupId()) {
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
        if (groupNewsPojo != null && this.eKI != null && this.eKI.getData() != null) {
            try {
                JSONObject jSONObject = new JSONObject(groupNewsPojo.getContent());
                String string = jSONObject.getJSONObject("eventParam").getString("groupId");
                if (jSONObject.getString("eventId").equals("003") && string.equals(String.valueOf(this.eKI.getGroupId())) && this.eKI.getData().aRS()) {
                    this.eKI.getData().iC(false);
                    GroupData group = this.eKI.getData().getGroup();
                    if (group != null && group.getMemberNum() > 1) {
                        group.setMemberNum(group.getMemberNum() - 1);
                    }
                    this.eKH.a(this.eKI.getData(), true);
                    aQT();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void f(GroupNewsPojo groupNewsPojo) {
        try {
            String optString = new JSONObject(groupNewsPojo.getContent()).optJSONObject("eventParam").optString("groupId");
            if (!TextUtils.isEmpty(optString) && this.eKI != null && optString.equals(String.valueOf(this.eKI.getGroupId())) && this.eKI.getData() != null) {
                this.eKI.getData().iC(true);
                if (this.eKH != null) {
                    this.eKH.ix(true);
                    this.eKH.aRj();
                    aQT();
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(GroupNewsPojo groupNewsPojo) {
        if (groupNewsPojo != null && this.eKI != null && this.eKI.getData() != null) {
            try {
                JSONObject jSONObject = new JSONObject(groupNewsPojo.getContent());
                JSONObject jSONObject2 = jSONObject.getJSONObject("eventParam");
                String string = jSONObject2.getString("groupId");
                if (jSONObject.getString("eventId").equals("101") && string.equals(String.valueOf(this.eKI.getGroupId()))) {
                    String string2 = jSONObject2.getString("groupName");
                    if (!TextUtils.isEmpty(string2)) {
                        this.eKH.setGroupName(string2);
                        if (this.eKI.getData() != null && this.eKI.getData().getGroup() != null) {
                            this.eKI.getData().getGroup().setName(string2);
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
        if (groupNewsPojo != null && this.eKI != null) {
            try {
                JSONObject jSONObject = new JSONObject(groupNewsPojo.getContent());
                String string = jSONObject.getJSONObject("eventParam").getString("groupId");
                if (jSONObject.getString("eventId").equals("107") && string.equals(String.valueOf(this.eKI.getGroupId()))) {
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
    public void aQT() {
        if (this.eKI != null) {
            this.eKI.clearGroupInfoCache(String.valueOf(this.eKI.getGroupId()));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 1) {
            if (ab.aX(getApplicationContext())) {
                ak.b(getPageContext());
            } else {
                showToast(e.j.system_permission_prompt_camera);
            }
            ArrayMap<String, Boolean> b = ab.b(strArr, iArr);
            if (b.containsKey("android.permission.WRITE_EXTERNAL_STORAGE") && !b.get("android.permission.WRITE_EXTERNAL_STORAGE").booleanValue()) {
                showToast(e.j.sdcard_permission_denied_advert_for_camera);
            }
        }
    }
}
