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
import com.baidu.tbadk.core.util.ac;
import com.baidu.tbadk.core.util.ad;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.l;
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
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class GroupInfoActivity extends BaseActivity<GroupInfoActivity> implements View.OnClickListener, View.OnLongClickListener, a.InterfaceC0061a, c, d {
    private com.baidu.tbadk.core.util.b.a biP;
    private UpdateGroupModel ecl;
    private com.baidu.tieba.im.groupInfo.a enW;
    private GroupInfoModel enX;
    private a enY;
    private int type = 0;
    private final WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private long enZ = -1;
    private long eoa = -1;
    private final b.InterfaceC0103b eob = new b.InterfaceC0103b() { // from class: com.baidu.tieba.im.groupInfo.GroupInfoActivity.1
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0103b
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
    private final b eoc = new b() { // from class: com.baidu.tieba.im.groupInfo.GroupInfoActivity.2
        @Override // com.baidu.tieba.im.groupInfo.b
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, Object obj, int i2) {
            bVar.dismiss();
            if (i == 0) {
                if (i2 != 0) {
                    GroupInfoActivity.this.Y(obj);
                } else {
                    GroupInfoActivity.this.showToast(GroupInfoActivity.this.getPageContext().getString(d.k.has_set_portrait));
                }
            } else if (i == 1) {
                if (i2 == 0) {
                    GroupInfoActivity.this.showToast(GroupInfoActivity.this.getPageContext().getString(d.k.group_portrait_cant_del));
                } else if (obj != null && (obj instanceof PhotoUrlData)) {
                    GroupInfoActivity.this.a((PhotoUrlData) obj);
                }
            } else if (i == 2) {
                GroupInfoActivity.this.enW.aKc();
            }
        }
    };
    private final CustomMessageListener mCustomListener = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.groupInfo.GroupInfoActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null) {
                GroupInfoActivity.this.enW.aJX();
                GroupInfoActivity.this.showToast(d.k.neterror);
            } else if (customResponsedMessage.getCmd() == 2001102) {
                if (!(customResponsedMessage instanceof ResponseGroupInfoLocalMessage)) {
                    GroupInfoActivity.this.enX.sendMessage(GroupInfoActivity.this.enX.getGroupId(), GroupInfoActivity.this.enX.getFrom());
                    return;
                }
                ResponseGroupInfoLocalMessage responseGroupInfoLocalMessage = (ResponseGroupInfoLocalMessage) customResponsedMessage;
                if (responseGroupInfoLocalMessage.getOrginalMessage() == null || ((RequestGroupInfoLocalMessage) responseGroupInfoLocalMessage.getOrginalMessage()).getGroupId() == GroupInfoActivity.this.enX.getGroupId()) {
                    if (responseGroupInfoLocalMessage.getError() != 0) {
                        GroupInfoActivity.this.enX.sendMessage(GroupInfoActivity.this.enX.getGroupId(), GroupInfoActivity.this.enX.getFrom());
                        return;
                    }
                    GroupInfoActivity.this.loadImage();
                    GroupInfoActivity.this.enX.setData(responseGroupInfoLocalMessage.getData());
                    GroupInfoActivity.this.enW.setData(responseGroupInfoLocalMessage.getData());
                    GroupInfoActivity.this.aJI();
                }
            }
        }
    };
    private final CustomMessageListener elq = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.groupInfo.GroupInfoActivity.4
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
        aJI();
        startLoading();
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        a((Bundle) null, intent);
        this.eoa = this.enX.getGroupId();
        startLoading();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJI() {
        if (this.enX != null) {
            long groupId = this.enX.getGroupId();
            this.eoa = groupId;
            this.enZ = groupId;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJJ() {
        if (this.enZ != this.eoa) {
            initUI();
            aJI();
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void initListener() {
        this.enY = new a();
        registerListener(103004, this.enY);
        registerListener(2001102, this.mCustomListener);
        registerListener(103102, this.enY);
        registerListener(103112, this.enY);
        registerListener(103110, this.enY);
        registerListener(103120, this.enY);
        registerListener(103121, this.enY);
        registerListener(2001128, this.elq);
        registerListener(2001126, this.elq);
        registerListener(2001130, this.elq);
        registerListener(103104, this.enY);
        registerListener(2001137, this.elq);
        registerListener(2001135, this.elq);
        registerListener(103105, this.enY);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.enX.saveInstance(bundle);
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
        this.enX.cancelMessage();
        MessageManager.getInstance().unRegisterListener(this.elq);
        if (this.enW != null) {
            this.enW.onDestory();
        }
    }

    private void initUI() {
        this.enW = new com.baidu.tieba.im.groupInfo.a(this);
        this.enW.a(this.eoc);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startLoading() {
        this.enW.aJY();
        this.enX.sendLocalMessage(this.enX.getGroupId(), this.enX.getFrom());
        this.enX.sendMessage(this.enX.getGroupId(), this.enX.getFrom());
    }

    public void a(Bundle bundle, Intent intent) {
        this.enX = new GroupInfoModel(this);
        this.enX.setUniqueId(getUniqueId());
        if (bundle == null) {
            GroupInfoModel groupInfoModel = this.enX;
            if (intent == null) {
                intent = getIntent();
            }
            groupInfoModel.initWithIntent(intent);
        } else {
            this.enX.initWithBundle(bundle);
        }
        this.ecl = new UpdateGroupModel(getPageContext());
        this.ecl.setUniqueId(getUniqueId());
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
        if (this.enW != null) {
            this.enW.changeSkinType(i);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.enW.aJZ()) {
            if (this.enX.getData() != null && this.enX.getData().aKM()) {
                TiebaStatic.log("edit_place_at_groupinfo");
                sendMessage(new CustomMessage(2002001, new GroupAddressLocateActivityConfig(getPageContext().getPageActivity(), 21001, this.enX.getData().getGroup().getPosition(), this.enX.getData().getGroup().getBusiness(), (this.enX.getData().getGroup().getFlag() & 1) == 1)));
            }
        } else if (view == this.enW.aIG()) {
            closeActivity();
        } else if (view != this.enW.aJM()) {
            if (view == this.enW.aJU()) {
                if (this.enX.getData() != null && this.enX.getData().getGroup() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), String.valueOf(this.enX.getData().getGroup().getAuthorId()), this.enX.getData().getGroup().getAuthorName())));
                }
            } else if (view == this.enW.aJV()) {
                if (this.enX != null && this.enX.getData() != null) {
                    sendMessage(new CustomMessage(2002001, new GroupLevelActivityConfig(getPageContext().getPageActivity(), this.enX.getGroupId(), this.enX.getData().isMemGroup())));
                }
            } else if (view == this.enW.aJT()) {
                if (TextUtils.isEmpty(TbadkApplication.getCurrentAccount())) {
                    TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig((Context) getPageContext().getPageActivity(), "", true, 3)));
                } else if (this.enX.getData() != null) {
                    if (this.enX.getData().aKL()) {
                        if (this.enX.getData().getGroup() != null) {
                            TiebaStatic.log(new am("c10334").ah("obj_type", String.valueOf(this.enX.getData().getGroup().getGroupId())));
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(getPageContext().getPageActivity(), this.enX.getGroupId(), this.enX.getData().getGroup().getName(), this.enX.getData().getGroup().getAuthorId(), "group_info")));
                        }
                    } else if (this.enX.hasRecentJoin()) {
                        showToast(d.k.has_recent_join);
                    } else if (this.enX.getData() != null) {
                        if (this.enX.getData().aKK() <= 0) {
                            showToast(d.k.add_group_max);
                        } else if (ApplyJoinGroupActivityConfig.JOINTYPE_DEFAULT == this.enX.getJoinType()) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2008014, new ApplyJoinGroupActivityConfig(getPageContext().getPageActivity(), "" + this.enX.getGroupId(), this.enX.getData().aKJ(), this.enX.getData().aKK())));
                        } else if (ApplyJoinGroupActivityConfig.JOINTYPE_INVITE == this.enX.getJoinType()) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2008014, new ApplyJoinGroupActivityConfig(getPageContext().getPageActivity(), "" + this.enX.getGroupId(), this.enX.getData().aKJ(), this.enX.getData().aKK(), this.enX.getInviteUserId(), this.enX.getDefaultUserMsg())));
                        }
                    }
                }
            } else if (view == this.enW.aJS()) {
                if (this.enX.getData() != null && this.enX.getData().getGroup() != null) {
                    sendMessage(new CustomMessage(2002001, new GroupSettingActivityConfig(getPageContext().getPageActivity(), 4, this.enX.getData().getGroup().getName(), "" + this.enX.getGroupId(), this.enX.getData().aKM(), this.enX.getData().getGroup().getFlag())));
                }
            } else if (view == this.enW.aJQ()) {
                if (this.enX.getData() != null && this.enX.getData().getGroup() != null) {
                    sendMessage(new CustomMessage(2002001, new UpdateGroupActivityConfig(getPageContext().getPageActivity(), 1, this.enX.getGroupId(), 1, this.enX.getData().getGroup().getName())));
                }
            } else if (view == this.enW.aJP()) {
                if (this.enX.getData() != null && this.enX.getData().aKM() && this.enX.getData().getGroup() != null) {
                    sendMessage(new CustomMessage(2002001, new UpdateGroupActivityConfig(getPageContext().getPageActivity(), 2, this.enX.getGroupId(), 2, this.enX.getData().getGroup().getIntro())));
                }
            } else if (view == this.enW.aJW() || view == this.enW.aJN()) {
                MembersActivity.e(getPageContext().getPageActivity(), this.enX.getGroupId());
            } else if (view == this.enW.aJO()) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new InviteFriendListActivityConfig(getPageContext().getPageActivity(), 0L, this.enX.getGroupId())));
            } else if (view == this.enW.aJR() && this.enX.getData() != null && this.enX.getData().aKL()) {
                GroupActivityData aKG = this.enX.getData().aKG();
                if (aKG != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupActivityActivityConfig(getPageContext().getPageActivity(), aKG.getActivityId(), this.enX.getGroupId(), 0)));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CreateGroupActivityActivityConfig(getPageContext().getPageActivity(), this.enX.getGroupId())));
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
        this.enW.d(obj, i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        if (view == this.enW.aJL()) {
            if (this.enX.getData() == null || this.enX.getData().getGroup() == null) {
                return false;
            }
            this.enW.oy(String.valueOf(this.enX.getData().getGroup().getGroupId()));
            return false;
        } else if (view != this.enW.aJP() || this.enX.getData().aKM()) {
            return false;
        } else {
            if (this.enX.getData() != null && this.enX.getData().getGroup() != null) {
                this.enW.ox(String.valueOf(this.enX.getData().getGroup().getIntro()));
            }
            return true;
        }
    }

    @Override // com.baidu.tieba.im.groupInfo.c
    public void a(View view, int i, Object obj, int i2) {
        if (i == 2) {
            Activity pageActivity = getPageContext().getPageActivity();
            if (this.biP == null) {
                this.biP = new com.baidu.tbadk.core.util.b.a();
            }
            this.biP.zU();
            this.biP.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.biP.u(pageActivity)) {
                AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true);
                albumActivityConfig.setRequestCode(IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK);
                albumActivityConfig.setResourceType(2);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
            }
        } else if (i == 1) {
            ArrayList<String> bigUrlList = this.enX.getBigUrlList();
            HashMap<String, ImageUrlData> assistUrls = this.enX.getAssistUrls();
            if (obj != null && (obj instanceof PhotoUrlData) && bigUrlList != null) {
                sendMessage(new CustomMessage(2002001, new GroupImageActivityConfig(getPageContext().getPageActivity(), ((PhotoUrlData) obj).getBigurl(), bigUrlList, this.enX.getGroupId(), assistUrls)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void takePhoto() {
        if (!ac.e(getPageContext().getPageActivity(), 1)) {
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
                        if (this.enW != null) {
                            this.enW.setGroupName(stringExtra);
                        }
                        if (this.enX != null && this.enX.getData() != null && this.enX.getData().getGroup() != null) {
                            this.enX.getData().getGroup().setName(stringExtra);
                            return;
                        }
                        return;
                    }
                    return;
                case 2:
                    if (intent != null) {
                        String stringExtra2 = intent.getStringExtra(UpdateGroupActivityConfig.GROUP_TEXT);
                        if (this.enW != null) {
                            this.enW.ov(stringExtra2);
                        }
                        if (this.enX != null && this.enX.getData() != null && this.enX.getData().getGroup() != null) {
                            this.enX.getData().getGroup().setIntro(stringExtra2);
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
                        if (this.enX != null && this.enX.getData() != null && this.enX.getData().getGroup() != null) {
                            this.enX.getData().getGroup().setFlag(intExtra);
                            return;
                        }
                        return;
                    }
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK /* 12002 */:
                    if (intent != null) {
                        intent.getBooleanExtra(AlbumActivityConfig.CAMERA_RESULT, false);
                        O(intent);
                        break;
                    } else {
                        return;
                    }
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_DYNAMIC_PWD /* 12009 */:
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_LOGIN_PROXY_RESULT /* 12010 */:
                    break;
                case 21001:
                    e(intent.getBooleanExtra("ResultDataIsHiddenAddress", true) ? 1 : 0, intent.getStringExtra("ResultDataAddress"), intent.getStringExtra("ResultDataSelectedBusiness"));
                    return;
                default:
                    return;
            }
            PhotoUrlData photoUrlData = (PhotoUrlData) intent.getSerializableExtra(EditHeadActivityConfig.PIC_INFO);
            if (photoUrlData != null) {
                ad.yV().c(photoUrlData.getSmallurl(), l.dT(TbConfig.GROUP_HEAD_FILE), true, false, true);
            }
            b(photoUrlData);
        } else if (i2 == 0 && i == 12010) {
            takePhoto();
        }
    }

    private void O(Intent intent) {
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
            ot(this.enX.generateDeleAlbum(photoUrlData));
        }
    }

    private void b(PhotoUrlData photoUrlData) {
        this.type = 1;
        if (photoUrlData != null) {
            String generateAddAlbum = this.enX.generateAddAlbum(photoUrlData);
            if (!TextUtils.isEmpty(generateAddAlbum)) {
                ot(generateAddAlbum);
            }
        }
    }

    private void e(int i, String str, String str2) {
        this.type = 4;
        if (this.ecl != null) {
            this.ecl.setGroupId(this.enX.getGroupId());
            this.ecl.setFlag(i);
            this.ecl.setPosition(str);
            this.ecl.setBusiness(str2);
            this.ecl.sendMessage(5);
            this.enW.aJY();
        }
    }

    private void ot(String str) {
        if (this.ecl != null) {
            this.ecl.setGroupId(this.enX.getGroupId());
            this.ecl.setAlbum(str);
            this.ecl.sendMessage(3);
            this.enW.aJY();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y(Object obj) {
        GroupCardModel.aJy();
        this.type = 3;
        if (obj != null && (obj instanceof PhotoUrlData)) {
            PhotoUrlData photoUrlData = (PhotoUrlData) obj;
            this.enX.setChangePhotoUrlData(photoUrlData);
            String picId = photoUrlData.getPicId();
            if (this.ecl != null) {
                this.ecl.setGroupId(this.enX.getGroupId());
                this.ecl.setPortrait(picId);
                this.ecl.sendMessage(4);
                this.enW.aJY();
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
                GroupInfoActivity.this.enW.aJX();
                GroupInfoActivity.this.showToast(d.k.neterror);
            } else if (socketResponsedMessage.getCmd() == 103004) {
                GroupInfoActivity.this.enW.aJX();
                final ResponseGroupInfoMessage responseGroupInfoMessage = (ResponseGroupInfoMessage) socketResponsedMessage;
                if (GroupInfoActivity.this.enX.getSendMsg() == responseGroupInfoMessage.getOrginalMessage()) {
                    if (responseGroupInfoMessage.getError() == 2230101) {
                        GroupInfoActivity.this.showToast(StringUtils.isNull(responseGroupInfoMessage.getErrorString()) ? GroupInfoActivity.this.getResources().getString(d.k.neterror) : responseGroupInfoMessage.getErrorString(), false);
                        GroupInfoActivity.this.finish();
                    } else if (responseGroupInfoMessage.getData() != null && responseGroupInfoMessage.getError() == 0) {
                        GroupInfoActivity.this.aJI();
                        GroupInfoActivity.this.loadImage();
                        GroupInfoActivity.this.enX.setData(responseGroupInfoMessage.getData());
                        if (responseGroupInfoMessage == null || responseGroupInfoMessage.getData().aKL()) {
                            GroupInfoActivity.this.enW.a(responseGroupInfoMessage.getData(), false);
                            return;
                        }
                        GroupInfoActivity.this.enW.aJY();
                        com.baidu.tieba.im.settingcache.b.aLN().a(TbadkApplication.getCurrentAccount(), String.valueOf(GroupInfoActivity.this.enX.getGroupId()), 60000L, new h<Boolean>() { // from class: com.baidu.tieba.im.groupInfo.GroupInfoActivity.a.1
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.tbadk.util.h
                            public void onReturnDataInUI(Boolean bool) {
                                if (bool == null) {
                                    bool = false;
                                }
                                GroupInfoActivity.this.enW.aJX();
                                GroupInfoActivity.this.enW.a(responseGroupInfoMessage.getData(), bool.booleanValue());
                                GroupInfoActivity.this.enX.setHasRecentJoin(bool.booleanValue() ? false : true);
                            }
                        });
                    } else {
                        GroupInfoActivity.this.showToast(d.k.neterror);
                        GroupInfoActivity.this.aJJ();
                    }
                }
            } else if (socketResponsedMessage.getCmd() == 103110) {
                if (socketResponsedMessage instanceof ResponseJoinGroupMessage) {
                    ResponseJoinGroupMessage responseJoinGroupMessage = (ResponseJoinGroupMessage) socketResponsedMessage;
                    if (responseJoinGroupMessage.getError() == 0 && (orginalMessage2 = responseJoinGroupMessage.getOrginalMessage()) != null && (orginalMessage2 instanceof RequestJoinGroupMessage) && ((RequestJoinGroupMessage) orginalMessage2).getGroupId() == GroupInfoActivity.this.enX.getGroupId()) {
                        GroupInfoActivity.this.enW.aKd();
                        GroupInfoActivity.this.enX.setHasRecentJoin(true);
                        GroupInfoActivity.this.aJK();
                    }
                }
            } else if (socketResponsedMessage.getCmd() == 103102) {
                GroupInfoActivity.this.enW.aJX();
                if (socketResponsedMessage.getError() != 0) {
                    GroupInfoActivity.this.showToast(d.k.neterror);
                    return;
                }
                ResponseUpdateGroupMessage responseUpdateGroupMessage = (ResponseUpdateGroupMessage) socketResponsedMessage;
                if (responseUpdateGroupMessage.getError() != 0) {
                    GroupInfoActivity.this.showToast(StringUtils.isNull(responseUpdateGroupMessage.getErrorString()) ? GroupInfoActivity.this.getResources().getString(d.k.neterror) : responseUpdateGroupMessage.getErrorString());
                } else if (responseUpdateGroupMessage.getOrginalMessage() instanceof RequestUpdateGroupMessage) {
                    int type = ((RequestUpdateGroupMessage) responseUpdateGroupMessage.getOrginalMessage()).getType();
                    switch (GroupInfoActivity.this.type) {
                        case 1:
                            if (type == 3) {
                                GroupInfoActivity.this.enX.addPhotoData();
                                GroupInfoActivity.this.enW.a(GroupInfoActivity.this.enX.getData());
                                return;
                            }
                            return;
                        case 2:
                            if (type == 3) {
                                GroupInfoActivity.this.enX.delePhotoData();
                                GroupInfoActivity.this.enW.a(GroupInfoActivity.this.enX.getData());
                                return;
                            }
                            return;
                        case 3:
                            if (type == 4) {
                                GroupInfoActivity.this.enX.updataPortraitData();
                                GroupInfoActivity.this.enW.a(GroupInfoActivity.this.enX.getData());
                                return;
                            }
                            return;
                        case 4:
                            GroupInfoActivity.this.enX.getData().getGroup().setFlag(GroupInfoActivity.this.ecl.getFlag());
                            GroupInfoActivity.this.enX.getData().getGroup().setPosition(GroupInfoActivity.this.ecl.getPosition());
                            GroupInfoActivity.this.enX.getData().getGroup().setBusiness(GroupInfoActivity.this.ecl.getBusiness());
                            if ((GroupInfoActivity.this.enX.getData().getGroup().getFlag() & 1) == 1) {
                                GroupInfoActivity.this.enW.hs(GroupInfoActivity.this.enX.getData().aKM());
                            } else {
                                String position = GroupInfoActivity.this.enX.getData().getGroup().getPosition();
                                String business = GroupInfoActivity.this.enX.getData().getGroup().getBusiness();
                                StringBuffer stringBuffer = new StringBuffer();
                                if (position != null) {
                                    stringBuffer.append(position);
                                }
                                if (business != null) {
                                    stringBuffer.append(business);
                                }
                                GroupInfoActivity.this.enW.j(GroupInfoActivity.this.enX.getData().aKM(), stringBuffer.toString());
                            }
                            GroupInfoActivity.this.showToast(d.k.operation_success);
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
                        if (requestRemoveMembersMessage.getGroupId() == GroupInfoActivity.this.enX.getGroupId()) {
                            String userIds = requestRemoveMembersMessage.getUserIds();
                            if (!TextUtils.isEmpty(userIds) && (split = userIds.split(",")) != null && split.length != 0) {
                                String id = TbadkApplication.getCurrentAccountObj().getID();
                                if (!TextUtils.isEmpty(id)) {
                                    for (String str : split) {
                                        if (id.equals(str)) {
                                            ResponseGroupInfoLocalMessage.a data = GroupInfoActivity.this.enX.getData();
                                            data.nZ(data.aKK() + 1);
                                            data.hz(false);
                                            GroupInfoActivity.this.enX.setHasRecentJoin(false);
                                            GroupInfoActivity.this.enW.a(data, true);
                                            GroupInfoActivity.this.enW.ow(str);
                                            GroupInfoActivity.this.aJK();
                                            return;
                                        }
                                        if (GroupInfoActivity.this.enX.removeMemberByUid(str)) {
                                            GroupInfoActivity.this.enW.ow(str);
                                            GroupData group = GroupInfoActivity.this.enX.getData().getGroup();
                                            if (group != null && group.getMemberNum() > 1) {
                                                group.setMemberNum(group.getMemberNum() - 1);
                                            }
                                            GroupInfoActivity.this.enW.setData(GroupInfoActivity.this.enX.getData());
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
                    if (responseDismissGroupMessage.getError() == 0 && GroupInfoActivity.this.enX.getGroupId() == responseDismissGroupMessage.getGroupId()) {
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
        if (groupNewsPojo != null && this.enX != null && this.enX.getData() != null) {
            try {
                JSONObject jSONObject = new JSONObject(groupNewsPojo.getContent());
                String string = jSONObject.getJSONObject("eventParam").getString("groupId");
                if (jSONObject.getString("eventId").equals("003") && string.equals(String.valueOf(this.enX.getGroupId())) && this.enX.getData().aKL()) {
                    this.enX.getData().hz(false);
                    GroupData group = this.enX.getData().getGroup();
                    if (group != null && group.getMemberNum() > 1) {
                        group.setMemberNum(group.getMemberNum() - 1);
                    }
                    this.enW.a(this.enX.getData(), true);
                    aJK();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void f(GroupNewsPojo groupNewsPojo) {
        try {
            String optString = new JSONObject(groupNewsPojo.getContent()).optJSONObject("eventParam").optString("groupId");
            if (!TextUtils.isEmpty(optString) && this.enX != null && optString.equals(String.valueOf(this.enX.getGroupId())) && this.enX.getData() != null) {
                this.enX.getData().hz(true);
                if (this.enW != null) {
                    this.enW.hu(true);
                    this.enW.aKa();
                    aJK();
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(GroupNewsPojo groupNewsPojo) {
        if (groupNewsPojo != null && this.enX != null && this.enX.getData() != null) {
            try {
                JSONObject jSONObject = new JSONObject(groupNewsPojo.getContent());
                JSONObject jSONObject2 = jSONObject.getJSONObject("eventParam");
                String string = jSONObject2.getString("groupId");
                if (jSONObject.getString("eventId").equals("101") && string.equals(String.valueOf(this.enX.getGroupId()))) {
                    String string2 = jSONObject2.getString("groupName");
                    if (!TextUtils.isEmpty(string2)) {
                        this.enW.setGroupName(string2);
                        if (this.enX.getData() != null && this.enX.getData().getGroup() != null) {
                            this.enX.getData().getGroup().setName(string2);
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
        if (groupNewsPojo != null && this.enX != null) {
            try {
                JSONObject jSONObject = new JSONObject(groupNewsPojo.getContent());
                String string = jSONObject.getJSONObject("eventParam").getString("groupId");
                if (jSONObject.getString("eventId").equals("107") && string.equals(String.valueOf(this.enX.getGroupId()))) {
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
    public void aJK() {
        if (this.enX != null) {
            this.enX.clearGroupInfoCache(String.valueOf(this.enX.getGroupId()));
        }
    }

    @Override // android.app.Activity, com.baidu.d.a.a.InterfaceC0061a
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 1) {
            if (ac.aN(getApplicationContext())) {
                ak.b(getPageContext());
            } else {
                showToast(d.k.system_permission_prompt_camera);
            }
            ArrayMap<String, Boolean> b = ac.b(strArr, iArr);
            if (b.containsKey("android.permission.WRITE_EXTERNAL_STORAGE") && !b.get("android.permission.WRITE_EXTERNAL_STORAGE").booleanValue()) {
                showToast(d.k.sdcard_permission_denied_advert_for_camera);
            }
        }
    }
}
