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
import com.baidu.d.a.a;
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
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.k;
import com.baidu.tbadk.coreExtra.data.PhotoUrlData;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.util.h;
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
/* loaded from: classes3.dex */
public class GroupInfoActivity extends BaseActivity<GroupInfoActivity> implements View.OnClickListener, View.OnLongClickListener, a.InterfaceC0056a, c, d {
    private com.baidu.tbadk.core.util.b.a bQG;
    private com.baidu.tieba.im.groupInfo.a eGY;
    private GroupInfoModel eGZ;
    private a eHa;
    private UpdateGroupModel evo;
    private int type = 0;
    private final WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private long eHb = -1;
    private long eHc = -1;
    private final b.InterfaceC0097b eHd = new b.InterfaceC0097b() { // from class: com.baidu.tieba.im.groupInfo.GroupInfoActivity.1
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0097b
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
    private final b eHe = new b() { // from class: com.baidu.tieba.im.groupInfo.GroupInfoActivity.2
        @Override // com.baidu.tieba.im.groupInfo.b
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, Object obj, int i2) {
            bVar.dismiss();
            if (i == 0) {
                if (i2 != 0) {
                    GroupInfoActivity.this.ba(obj);
                } else {
                    GroupInfoActivity.this.showToast(GroupInfoActivity.this.getPageContext().getString(d.j.has_set_portrait));
                }
            } else if (i == 1) {
                if (i2 == 0) {
                    GroupInfoActivity.this.showToast(GroupInfoActivity.this.getPageContext().getString(d.j.group_portrait_cant_del));
                } else if (obj != null && (obj instanceof PhotoUrlData)) {
                    GroupInfoActivity.this.a((PhotoUrlData) obj);
                }
            } else if (i == 2) {
                GroupInfoActivity.this.eGY.aKm();
            }
        }
    };
    private final CustomMessageListener mCustomListener = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.groupInfo.GroupInfoActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null) {
                GroupInfoActivity.this.eGY.aKh();
                GroupInfoActivity.this.showToast(d.j.neterror);
            } else if (customResponsedMessage.getCmd() == 2001102) {
                if (!(customResponsedMessage instanceof ResponseGroupInfoLocalMessage)) {
                    GroupInfoActivity.this.eGZ.sendMessage(GroupInfoActivity.this.eGZ.getGroupId(), GroupInfoActivity.this.eGZ.getFrom());
                    return;
                }
                ResponseGroupInfoLocalMessage responseGroupInfoLocalMessage = (ResponseGroupInfoLocalMessage) customResponsedMessage;
                if (responseGroupInfoLocalMessage.getOrginalMessage() == null || ((RequestGroupInfoLocalMessage) responseGroupInfoLocalMessage.getOrginalMessage()).getGroupId() == GroupInfoActivity.this.eGZ.getGroupId()) {
                    if (responseGroupInfoLocalMessage.getError() != 0) {
                        GroupInfoActivity.this.eGZ.sendMessage(GroupInfoActivity.this.eGZ.getGroupId(), GroupInfoActivity.this.eGZ.getFrom());
                        return;
                    }
                    GroupInfoActivity.this.asa();
                    GroupInfoActivity.this.eGZ.setData(responseGroupInfoLocalMessage.getData());
                    GroupInfoActivity.this.eGY.setData(responseGroupInfoLocalMessage.getData());
                    GroupInfoActivity.this.aJS();
                }
            }
        }
    };
    private final CustomMessageListener eEv = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.groupInfo.GroupInfoActivity.4
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
        aJS();
        startLoading();
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        a((Bundle) null, intent);
        this.eHc = this.eGZ.getGroupId();
        startLoading();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJS() {
        if (this.eGZ != null) {
            long groupId = this.eGZ.getGroupId();
            this.eHc = groupId;
            this.eHb = groupId;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJT() {
        if (this.eHb != this.eHc) {
            initUI();
            aJS();
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void initListener() {
        this.eHa = new a();
        registerListener(103004, this.eHa);
        registerListener(2001102, this.mCustomListener);
        registerListener(103102, this.eHa);
        registerListener(103112, this.eHa);
        registerListener(103110, this.eHa);
        registerListener(103120, this.eHa);
        registerListener(103121, this.eHa);
        registerListener(2001128, this.eEv);
        registerListener(2001126, this.eEv);
        registerListener(2001130, this.eEv);
        registerListener(103104, this.eHa);
        registerListener(2001137, this.eEv);
        registerListener(2001135, this.eEv);
        registerListener(103105, this.eHa);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.eGZ.saveInstance(bundle);
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
        this.eGZ.cancelMessage();
        MessageManager.getInstance().unRegisterListener(this.eEv);
        if (this.eGY != null) {
            this.eGY.onDestory();
        }
    }

    private void initUI() {
        this.eGY = new com.baidu.tieba.im.groupInfo.a(this);
        this.eGY.a(this.eHe);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startLoading() {
        this.eGY.aKi();
        this.eGZ.sendLocalMessage(this.eGZ.getGroupId(), this.eGZ.getFrom());
        this.eGZ.sendMessage(this.eGZ.getGroupId(), this.eGZ.getFrom());
    }

    public void a(Bundle bundle, Intent intent) {
        this.eGZ = new GroupInfoModel(this);
        this.eGZ.setUniqueId(getUniqueId());
        if (bundle == null) {
            GroupInfoModel groupInfoModel = this.eGZ;
            if (intent == null) {
                intent = getIntent();
            }
            groupInfoModel.initWithIntent(intent);
        } else {
            this.eGZ.initWithBundle(bundle);
        }
        this.evo = new UpdateGroupModel(getPageContext());
        this.evo.setUniqueId(getUniqueId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void asa() {
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
        if (this.eGY != null) {
            this.eGY.changeSkinType(i);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.eGY.aKj()) {
            if (this.eGZ.getData() != null && this.eGZ.getData().aKW()) {
                TiebaStatic.log("edit_place_at_groupinfo");
                sendMessage(new CustomMessage(2002001, new GroupAddressLocateActivityConfig(getPageContext().getPageActivity(), 21001, this.eGZ.getData().getGroup().getPosition(), this.eGZ.getData().getGroup().getBusiness(), (this.eGZ.getData().getGroup().getFlag() & 1) == 1)));
            }
        } else if (view == this.eGY.aIQ()) {
            closeActivity();
        } else if (view != this.eGY.aJW()) {
            if (view == this.eGY.aKe()) {
                if (this.eGZ.getData() != null && this.eGZ.getData().getGroup() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), String.valueOf(this.eGZ.getData().getGroup().getAuthorId()), this.eGZ.getData().getGroup().getAuthorName())));
                }
            } else if (view == this.eGY.aKf()) {
                if (this.eGZ != null && this.eGZ.getData() != null) {
                    sendMessage(new CustomMessage(2002001, new GroupLevelActivityConfig(getPageContext().getPageActivity(), this.eGZ.getGroupId(), this.eGZ.getData().isMemGroup())));
                }
            } else if (view == this.eGY.aKd()) {
                if (TextUtils.isEmpty(TbadkApplication.getCurrentAccount())) {
                    TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig((Context) getPageContext().getPageActivity(), "", true, 3)));
                } else if (this.eGZ.getData() != null) {
                    if (this.eGZ.getData().aKV()) {
                        if (this.eGZ.getData().getGroup() != null) {
                            TiebaStatic.log(new ak("c10334").ab("obj_type", String.valueOf(this.eGZ.getData().getGroup().getGroupId())));
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(getPageContext().getPageActivity(), (int) this.eGZ.getGroupId(), this.eGZ.getData().getGroup().getName(), this.eGZ.getData().getGroup().getAuthorId(), "group_info")));
                        }
                    } else if (this.eGZ.hasRecentJoin()) {
                        showToast(d.j.has_recent_join);
                    } else if (this.eGZ.getData() != null) {
                        if (this.eGZ.getData().aKU() <= 0) {
                            showToast(d.j.add_group_max);
                        } else if (ApplyJoinGroupActivityConfig.JOINTYPE_DEFAULT == this.eGZ.getJoinType()) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2008014, new ApplyJoinGroupActivityConfig(getPageContext().getPageActivity(), "" + this.eGZ.getGroupId(), this.eGZ.getData().aKT(), this.eGZ.getData().aKU())));
                        } else if (ApplyJoinGroupActivityConfig.JOINTYPE_INVITE == this.eGZ.getJoinType()) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2008014, new ApplyJoinGroupActivityConfig(getPageContext().getPageActivity(), "" + this.eGZ.getGroupId(), this.eGZ.getData().aKT(), this.eGZ.getData().aKU(), this.eGZ.getInviteUserId(), this.eGZ.getDefaultUserMsg())));
                        }
                    }
                }
            } else if (view == this.eGY.aKc()) {
                if (this.eGZ.getData() != null && this.eGZ.getData().getGroup() != null) {
                    sendMessage(new CustomMessage(2002001, new GroupSettingActivityConfig(getPageContext().getPageActivity(), 4, this.eGZ.getData().getGroup().getName(), "" + this.eGZ.getGroupId(), this.eGZ.getData().aKW(), this.eGZ.getData().getGroup().getFlag())));
                }
            } else if (view == this.eGY.aKa()) {
                if (this.eGZ.getData() != null && this.eGZ.getData().getGroup() != null) {
                    sendMessage(new CustomMessage(2002001, new UpdateGroupActivityConfig(getPageContext().getPageActivity(), 1, (int) this.eGZ.getGroupId(), 1, this.eGZ.getData().getGroup().getName())));
                }
            } else if (view == this.eGY.aJZ()) {
                if (this.eGZ.getData() != null && this.eGZ.getData().aKW() && this.eGZ.getData().getGroup() != null) {
                    sendMessage(new CustomMessage(2002001, new UpdateGroupActivityConfig(getPageContext().getPageActivity(), 2, (int) this.eGZ.getGroupId(), 2, this.eGZ.getData().getGroup().getIntro())));
                }
            } else if (view == this.eGY.aKg() || view == this.eGY.aJX()) {
                MembersActivity.f(getPageContext().getPageActivity(), this.eGZ.getGroupId());
            } else if (view == this.eGY.aJY()) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new InviteFriendListActivityConfig(getPageContext().getPageActivity(), 0, (int) this.eGZ.getGroupId())));
            } else if (view == this.eGY.aKb() && this.eGZ.getData() != null && this.eGZ.getData().aKV()) {
                GroupActivityData aKQ = this.eGZ.getData().aKQ();
                if (aKQ != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupActivityActivityConfig(getPageContext().getPageActivity(), aKQ.getActivityId(), this.eGZ.getGroupId(), 0)));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CreateGroupActivityActivityConfig(getPageContext().getPageActivity(), (int) this.eGZ.getGroupId())));
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
        this.eGY.j(obj, i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        if (view == this.eGY.aJV()) {
            if (this.eGZ.getData() == null || this.eGZ.getData().getGroup() == null) {
                return false;
            }
            this.eGY.nD(String.valueOf(this.eGZ.getData().getGroup().getGroupId()));
            return false;
        } else if (view != this.eGY.aJZ() || this.eGZ.getData().aKW()) {
            return false;
        } else {
            if (this.eGZ.getData() != null && this.eGZ.getData().getGroup() != null) {
                this.eGY.nC(String.valueOf(this.eGZ.getData().getGroup().getIntro()));
            }
            return true;
        }
    }

    @Override // com.baidu.tieba.im.groupInfo.c
    public void a(View view, int i, Object obj, int i2) {
        if (i == 2) {
            Activity pageActivity = getPageContext().getPageActivity();
            if (this.bQG == null) {
                this.bQG = new com.baidu.tbadk.core.util.b.a();
            }
            this.bQG.DI();
            this.bQG.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.bQG.v(pageActivity)) {
                AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true);
                albumActivityConfig.setRequestCode(IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK);
                albumActivityConfig.setResourceType(2);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
            }
        } else if (i == 1) {
            ArrayList<String> bigUrlList = this.eGZ.getBigUrlList();
            HashMap<String, ImageUrlData> assistUrls = this.eGZ.getAssistUrls();
            if (obj != null && (obj instanceof PhotoUrlData) && bigUrlList != null) {
                sendMessage(new CustomMessage(2002001, new GroupImageActivityConfig(getPageContext().getPageActivity(), ((PhotoUrlData) obj).getBigurl(), bigUrlList, this.eGZ.getGroupId(), assistUrls)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void takePhoto() {
        if (!ab.e(getPageContext().getPageActivity(), 1)) {
            ai.b(getPageContext());
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
                        if (this.eGY != null) {
                            this.eGY.setGroupName(stringExtra);
                        }
                        if (this.eGZ != null && this.eGZ.getData() != null && this.eGZ.getData().getGroup() != null) {
                            this.eGZ.getData().getGroup().setName(stringExtra);
                            return;
                        }
                        return;
                    }
                    return;
                case 2:
                    if (intent != null) {
                        String stringExtra2 = intent.getStringExtra(UpdateGroupActivityConfig.GROUP_TEXT);
                        if (this.eGY != null) {
                            this.eGY.nA(stringExtra2);
                        }
                        if (this.eGZ != null && this.eGZ.getData() != null && this.eGZ.getData().getGroup() != null) {
                            this.eGZ.getData().getGroup().setIntro(stringExtra2);
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
                        if (this.eGZ != null && this.eGZ.getData() != null && this.eGZ.getData().getGroup() != null) {
                            this.eGZ.getData().getGroup().setFlag(intExtra);
                            return;
                        }
                        return;
                    }
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK /* 12002 */:
                    if (intent != null) {
                        intent.getBooleanExtra(AlbumActivityConfig.CAMERA_RESULT, false);
                        P(intent);
                        break;
                    } else {
                        return;
                    }
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_DYNAMIC_PWD /* 12009 */:
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_LOGIN_PROXY_RESULT /* 12010 */:
                    break;
                case 21001:
                    f(intent.getBooleanExtra("ResultDataIsHiddenAddress", true) ? 1 : 0, intent.getStringExtra("ResultDataAddress"), intent.getStringExtra("ResultDataSelectedBusiness"));
                    return;
                default:
                    return;
            }
            PhotoUrlData photoUrlData = (PhotoUrlData) intent.getSerializableExtra(EditHeadActivityConfig.PIC_INFO);
            if (photoUrlData != null) {
                ac.CL().c(photoUrlData.getSmallurl(), k.dB(TbConfig.GROUP_HEAD_FILE), true, false, true);
            }
            b(photoUrlData);
        } else if (i2 == 0 && i == 12010) {
            takePhoto();
        }
    }

    private void P(Intent intent) {
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
            ny(this.eGZ.generateDeleAlbum(photoUrlData));
        }
    }

    private void b(PhotoUrlData photoUrlData) {
        this.type = 1;
        if (photoUrlData != null) {
            String generateAddAlbum = this.eGZ.generateAddAlbum(photoUrlData);
            if (!TextUtils.isEmpty(generateAddAlbum)) {
                ny(generateAddAlbum);
            }
        }
    }

    private void f(int i, String str, String str2) {
        this.type = 4;
        if (this.evo != null) {
            this.evo.setGroupId(this.eGZ.getGroupId());
            this.evo.setFlag(i);
            this.evo.setPosition(str);
            this.evo.setBusiness(str2);
            this.evo.sendMessage(5);
            this.eGY.aKi();
        }
    }

    private void ny(String str) {
        if (this.evo != null) {
            this.evo.setGroupId(this.eGZ.getGroupId());
            this.evo.setAlbum(str);
            this.evo.sendMessage(3);
            this.eGY.aKi();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ba(Object obj) {
        GroupCardModel.aJI();
        this.type = 3;
        if (obj != null && (obj instanceof PhotoUrlData)) {
            PhotoUrlData photoUrlData = (PhotoUrlData) obj;
            this.eGZ.setChangePhotoUrlData(photoUrlData);
            String picId = photoUrlData.getPicId();
            if (this.evo != null) {
                this.evo.setGroupId(this.eGZ.getGroupId());
                this.evo.setPortrait(picId);
                this.evo.sendMessage(4);
                this.eGY.aKi();
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
                GroupInfoActivity.this.eGY.aKh();
                GroupInfoActivity.this.showToast(d.j.neterror);
            } else if (socketResponsedMessage.getCmd() == 103004) {
                GroupInfoActivity.this.eGY.aKh();
                final ResponseGroupInfoMessage responseGroupInfoMessage = (ResponseGroupInfoMessage) socketResponsedMessage;
                if (GroupInfoActivity.this.eGZ.getSendMsg() == responseGroupInfoMessage.getOrginalMessage()) {
                    if (responseGroupInfoMessage.getError() == 2230101) {
                        GroupInfoActivity.this.showToast(StringUtils.isNull(responseGroupInfoMessage.getErrorString()) ? GroupInfoActivity.this.getResources().getString(d.j.neterror) : responseGroupInfoMessage.getErrorString(), false);
                        GroupInfoActivity.this.finish();
                    } else if (responseGroupInfoMessage.getData() != null && responseGroupInfoMessage.getError() == 0) {
                        GroupInfoActivity.this.aJS();
                        GroupInfoActivity.this.asa();
                        GroupInfoActivity.this.eGZ.setData(responseGroupInfoMessage.getData());
                        if (responseGroupInfoMessage == null || responseGroupInfoMessage.getData().aKV()) {
                            GroupInfoActivity.this.eGY.a(responseGroupInfoMessage.getData(), false);
                            return;
                        }
                        GroupInfoActivity.this.eGY.aKi();
                        com.baidu.tieba.im.settingcache.b.aLU().a(TbadkApplication.getCurrentAccount(), String.valueOf(GroupInfoActivity.this.eGZ.getGroupId()), 60000L, new h<Boolean>() { // from class: com.baidu.tieba.im.groupInfo.GroupInfoActivity.a.1
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.tbadk.util.h
                            public void onReturnDataInUI(Boolean bool) {
                                if (bool == null) {
                                    bool = false;
                                }
                                GroupInfoActivity.this.eGY.aKh();
                                GroupInfoActivity.this.eGY.a(responseGroupInfoMessage.getData(), bool.booleanValue());
                                GroupInfoActivity.this.eGZ.setHasRecentJoin(bool.booleanValue() ? false : true);
                            }
                        });
                    } else {
                        GroupInfoActivity.this.showToast(d.j.neterror);
                        GroupInfoActivity.this.aJT();
                    }
                }
            } else if (socketResponsedMessage.getCmd() == 103110) {
                if (socketResponsedMessage instanceof ResponseJoinGroupMessage) {
                    ResponseJoinGroupMessage responseJoinGroupMessage = (ResponseJoinGroupMessage) socketResponsedMessage;
                    if (responseJoinGroupMessage.getError() == 0 && (orginalMessage2 = responseJoinGroupMessage.getOrginalMessage()) != null && (orginalMessage2 instanceof RequestJoinGroupMessage) && ((RequestJoinGroupMessage) orginalMessage2).getGroupId() == GroupInfoActivity.this.eGZ.getGroupId()) {
                        GroupInfoActivity.this.eGY.aKn();
                        GroupInfoActivity.this.eGZ.setHasRecentJoin(true);
                        GroupInfoActivity.this.aJU();
                    }
                }
            } else if (socketResponsedMessage.getCmd() == 103102) {
                GroupInfoActivity.this.eGY.aKh();
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
                                GroupInfoActivity.this.eGZ.addPhotoData();
                                GroupInfoActivity.this.eGY.a(GroupInfoActivity.this.eGZ.getData());
                                return;
                            }
                            return;
                        case 2:
                            if (type == 3) {
                                GroupInfoActivity.this.eGZ.delePhotoData();
                                GroupInfoActivity.this.eGY.a(GroupInfoActivity.this.eGZ.getData());
                                return;
                            }
                            return;
                        case 3:
                            if (type == 4) {
                                GroupInfoActivity.this.eGZ.updataPortraitData();
                                GroupInfoActivity.this.eGY.a(GroupInfoActivity.this.eGZ.getData());
                                return;
                            }
                            return;
                        case 4:
                            GroupInfoActivity.this.eGZ.getData().getGroup().setFlag(GroupInfoActivity.this.evo.getFlag());
                            GroupInfoActivity.this.eGZ.getData().getGroup().setPosition(GroupInfoActivity.this.evo.getPosition());
                            GroupInfoActivity.this.eGZ.getData().getGroup().setBusiness(GroupInfoActivity.this.evo.getBusiness());
                            if ((GroupInfoActivity.this.eGZ.getData().getGroup().getFlag() & 1) == 1) {
                                GroupInfoActivity.this.eGY.hL(GroupInfoActivity.this.eGZ.getData().aKW());
                            } else {
                                String position = GroupInfoActivity.this.eGZ.getData().getGroup().getPosition();
                                String business = GroupInfoActivity.this.eGZ.getData().getGroup().getBusiness();
                                StringBuffer stringBuffer = new StringBuffer();
                                if (position != null) {
                                    stringBuffer.append(position);
                                }
                                if (business != null) {
                                    stringBuffer.append(business);
                                }
                                GroupInfoActivity.this.eGY.g(GroupInfoActivity.this.eGZ.getData().aKW(), stringBuffer.toString());
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
                        if (requestRemoveMembersMessage.getGroupId() == GroupInfoActivity.this.eGZ.getGroupId()) {
                            String userIds = requestRemoveMembersMessage.getUserIds();
                            if (!TextUtils.isEmpty(userIds) && (split = userIds.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) != null && split.length != 0) {
                                String id = TbadkApplication.getCurrentAccountObj().getID();
                                if (!TextUtils.isEmpty(id)) {
                                    for (String str : split) {
                                        if (id.equals(str)) {
                                            ResponseGroupInfoLocalMessage.a data = GroupInfoActivity.this.eGZ.getData();
                                            data.qr(data.aKU() + 1);
                                            data.hS(false);
                                            GroupInfoActivity.this.eGZ.setHasRecentJoin(false);
                                            GroupInfoActivity.this.eGY.a(data, true);
                                            GroupInfoActivity.this.eGY.nB(str);
                                            GroupInfoActivity.this.aJU();
                                            return;
                                        }
                                        if (GroupInfoActivity.this.eGZ.removeMemberByUid(str)) {
                                            GroupInfoActivity.this.eGY.nB(str);
                                            GroupData group = GroupInfoActivity.this.eGZ.getData().getGroup();
                                            if (group != null && group.getMemberNum() > 1) {
                                                group.setMemberNum(group.getMemberNum() - 1);
                                            }
                                            GroupInfoActivity.this.eGY.setData(GroupInfoActivity.this.eGZ.getData());
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
                    if (responseDismissGroupMessage.getError() == 0 && GroupInfoActivity.this.eGZ.getGroupId() == responseDismissGroupMessage.getGroupId()) {
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
        if (groupNewsPojo != null && this.eGZ != null && this.eGZ.getData() != null) {
            try {
                JSONObject jSONObject = new JSONObject(groupNewsPojo.getContent());
                String string = jSONObject.getJSONObject("eventParam").getString("groupId");
                if (jSONObject.getString("eventId").equals("003") && string.equals(String.valueOf(this.eGZ.getGroupId())) && this.eGZ.getData().aKV()) {
                    this.eGZ.getData().hS(false);
                    GroupData group = this.eGZ.getData().getGroup();
                    if (group != null && group.getMemberNum() > 1) {
                        group.setMemberNum(group.getMemberNum() - 1);
                    }
                    this.eGY.a(this.eGZ.getData(), true);
                    aJU();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void f(GroupNewsPojo groupNewsPojo) {
        try {
            String optString = new JSONObject(groupNewsPojo.getContent()).optJSONObject("eventParam").optString("groupId");
            if (!TextUtils.isEmpty(optString) && this.eGZ != null && optString.equals(String.valueOf(this.eGZ.getGroupId())) && this.eGZ.getData() != null) {
                this.eGZ.getData().hS(true);
                if (this.eGY != null) {
                    this.eGY.hN(true);
                    this.eGY.aKk();
                    aJU();
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(GroupNewsPojo groupNewsPojo) {
        if (groupNewsPojo != null && this.eGZ != null && this.eGZ.getData() != null) {
            try {
                JSONObject jSONObject = new JSONObject(groupNewsPojo.getContent());
                JSONObject jSONObject2 = jSONObject.getJSONObject("eventParam");
                String string = jSONObject2.getString("groupId");
                if (jSONObject.getString("eventId").equals("101") && string.equals(String.valueOf(this.eGZ.getGroupId()))) {
                    String string2 = jSONObject2.getString("groupName");
                    if (!TextUtils.isEmpty(string2)) {
                        this.eGY.setGroupName(string2);
                        if (this.eGZ.getData() != null && this.eGZ.getData().getGroup() != null) {
                            this.eGZ.getData().getGroup().setName(string2);
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
        if (groupNewsPojo != null && this.eGZ != null) {
            try {
                JSONObject jSONObject = new JSONObject(groupNewsPojo.getContent());
                String string = jSONObject.getJSONObject("eventParam").getString("groupId");
                if (jSONObject.getString("eventId").equals("107") && string.equals(String.valueOf(this.eGZ.getGroupId()))) {
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
    public void aJU() {
        if (this.eGZ != null) {
            this.eGZ.clearGroupInfoCache(String.valueOf(this.eGZ.getGroupId()));
        }
    }

    @Override // android.app.Activity, com.baidu.d.a.a.InterfaceC0056a
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 1) {
            if (ab.aT(getApplicationContext())) {
                ai.b(getPageContext());
            } else {
                showToast(d.j.system_permission_prompt_camera);
            }
            ArrayMap<String, Boolean> a2 = ab.a(strArr, iArr);
            if (a2.containsKey("android.permission.WRITE_EXTERNAL_STORAGE") && !a2.get("android.permission.WRITE_EXTERNAL_STORAGE").booleanValue()) {
                showToast(d.j.sdcard_permission_denied_advert_for_camera);
            }
        }
    }
}
