package com.baidu.tieba.im.groupInfo;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.ApplyJoinGroupActivityConfig;
import com.baidu.tbadk.core.atomData.FrsGroupActivityConfig;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.GroupData;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.coreExtra.act.EditHeadActivity;
import com.baidu.tbadk.coreExtra.act.LoginActivity;
import com.baidu.tbadk.coreExtra.data.PhotoUrlData;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.im.chat.GroupSettingActivity;
import com.baidu.tieba.im.creategroup.GroupAddressLocateActivity;
import com.baidu.tieba.im.data.GroupActivityData;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.im.friend.InviteFriendListActivity;
import com.baidu.tieba.im.frsgroup.GroupLevelActivity;
import com.baidu.tieba.im.frsgroup.MembersActivity;
import com.baidu.tieba.im.groupActivity.CreateGroupActivityActivity;
import com.baidu.tieba.im.groupActivity.GroupActivityActivity;
import com.baidu.tieba.im.groupCard.GroupCardActivity;
import com.baidu.tieba.im.model.GroupInfoModel;
import com.baidu.tieba.im.model.UpdateGroupModel;
import com.baidu.tieba.im.updategroup.UpdateGroupActivity;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class GroupInfoActivity extends BaseActivity implements View.OnClickListener, View.OnLongClickListener, af, ag {
    private UpdateGroupModel aOx;
    private t bax;
    private GroupInfoModel bay;
    private r baz;
    private int type = 0;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private final DialogInterface.OnClickListener baA = new l(this);
    private final ae baB = new m(this);
    private final CustomMessageListener mCustomListener = new n(this, 0);
    private final CustomMessageListener aYa = new o(this, 0);

    static {
        Kn();
        Fo();
    }

    private static void Kn() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2008011, new p());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void Fo() {
        bg.mR().a(new q());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        HN();
        a(bundle, (Intent) null);
        initUI();
        startLoading();
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        a((Bundle) null, intent);
        initUI();
        startLoading();
    }

    private void HN() {
        this.baz = new r(this);
        registerListener(103004, this.baz);
        registerListener(2001102, this.mCustomListener);
        registerListener(103102, this.baz);
        registerListener(103112, this.baz);
        registerListener(103110, this.baz);
        registerListener(103120, this.baz);
        registerListener(103121, this.baz);
        registerListener(2001132, this.aYa);
        registerListener(2001130, this.aYa);
        registerListener(2001134, this.aYa);
        registerListener(103104, this.baz);
        registerListener(2001141, this.aYa);
        registerListener(2001139, this.aYa);
        registerListener(103105, this.baz);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.bay.saveInstance(bundle);
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
        this.bay.cancelMessage();
        MessageManager.getInstance().unRegisterListener(this.aYa);
        if (this.bax != null) {
            this.bax.onDestory();
        }
    }

    private void initUI() {
        this.bax = new t(this);
        this.bax.e(this.baA);
        this.bax.a(this.baB);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.bax != null) {
            this.bax.onPause();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startLoading() {
        this.bax.OX();
        this.bay.sendLocalMessage(this.bay.getGroupId(), this.bay.getFrom());
        this.bay.sendMessage(this.bay.getGroupId(), this.bay.getFrom());
    }

    public void a(Bundle bundle, Intent intent) {
        this.bay = new GroupInfoModel(this);
        this.bay.setUniqueId(getUniqueId());
        if (bundle == null) {
            GroupInfoModel groupInfoModel = this.bay;
            if (intent == null) {
                intent = getIntent();
            }
            groupInfoModel.initWithIntent(intent);
        } else {
            this.bay.initWithBundle(bundle);
        }
        this.aOx = new UpdateGroupModel(this);
        this.aOx.setUniqueId(getUniqueId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Dg() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        onChangeSkinType(TbadkApplication.m251getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        if (this.bax != null) {
            this.bax.changeSkinType(i);
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: long : 0x01cd: INVOKE  (r2v35 long A[REMOVE]) = 
      (wrap: com.baidu.tieba.im.model.GroupInfoModel : 0x01cb: IGET  (r2v34 com.baidu.tieba.im.model.GroupInfoModel A[REMOVE]) = (r9v0 'this' com.baidu.tieba.im.groupInfo.GroupInfoActivity A[IMMUTABLE_TYPE, THIS]) com.baidu.tieba.im.groupInfo.GroupInfoActivity.bay com.baidu.tieba.im.model.GroupInfoModel)
     type: VIRTUAL call: com.baidu.tieba.im.model.GroupInfoModel.getGroupId():long)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: long : 0x0211: INVOKE  (r2v31 long A[REMOVE]) = 
      (wrap: com.baidu.tieba.im.model.GroupInfoModel : 0x020f: IGET  (r2v30 com.baidu.tieba.im.model.GroupInfoModel A[REMOVE]) = (r9v0 'this' com.baidu.tieba.im.groupInfo.GroupInfoActivity A[IMMUTABLE_TYPE, THIS]) com.baidu.tieba.im.groupInfo.GroupInfoActivity.bay com.baidu.tieba.im.model.GroupInfoModel)
     type: VIRTUAL call: com.baidu.tieba.im.model.GroupInfoModel.getGroupId():long)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: long : 0x02c4: INVOKE  (r3v2 long A[REMOVE]) = 
      (wrap: com.baidu.tieba.im.model.GroupInfoModel : 0x02c2: IGET  (r3v1 com.baidu.tieba.im.model.GroupInfoModel A[REMOVE]) = (r9v0 'this' com.baidu.tieba.im.groupInfo.GroupInfoActivity A[IMMUTABLE_TYPE, THIS]) com.baidu.tieba.im.groupInfo.GroupInfoActivity.bay com.baidu.tieba.im.model.GroupInfoModel)
     type: VIRTUAL call: com.baidu.tieba.im.model.GroupInfoModel.getGroupId():long)] */
    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bax.OY()) {
            if (this.bay.getData().Qg()) {
                com.baidu.tbadk.core.j.l(this, "edit_place_at_groupinfo");
                GroupAddressLocateActivity.a(this, 21001, this.bay.getData().getGroup().getPosition(), this.bay.getData().getGroup().getBusiness(), (this.bay.getData().getGroup().getFlag() & 1) == 1);
            }
        } else if (view == this.bax.NA()) {
            closeActivity();
        } else if (view == this.bax.OK()) {
            if (this.bay.getData() != null && this.bay.getData().getGroup() != null) {
                sendMessage(new CustomMessage(2002001, new FrsGroupActivityConfig(this, String.valueOf(this.bay.getData().getGroup().getForumId()), this.bay.getData().Qh() ? false : true)));
            }
        } else if (view == this.bax.OT()) {
            if (this.bay.getData() != null && this.bay.getData().getGroup() != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this, String.valueOf(this.bay.getData().getGroup().getAuthorId()), this.bay.getData().getGroup().getAuthorName())));
            }
        } else if (view == this.bax.OU()) {
            GroupLevelActivity.a(this, this.bay.getGroupId(), this.bay.getData().isMemGroup());
        } else if (view == this.bax.OS()) {
            if (TextUtils.isEmpty(TbadkApplication.getCurrentAccount())) {
                LoginActivity.a((Activity) this, "", true, 3);
            } else if (this.bay.getData() != null) {
                if (this.bay.getData().Qf()) {
                    if (this.bay.getData().getGroup() != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(this, (int) this.bay.getGroupId(), this.bay.getData().getGroup().getName(), this.bay.getData().getGroup().getAuthorId(), "group_info")));
                    }
                } else if (this.bay.hasRecentJoin()) {
                    showToast(com.baidu.tieba.y.has_recent_join);
                } else if (this.bay.getData() != null) {
                    if (this.bay.getData().Qe() <= 0) {
                        showToast(com.baidu.tieba.y.add_group_max);
                    } else if (ApplyJoinGroupActivityConfig.JOINTYPE_DEFAULT == this.bay.getJoinType()) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2008014, new ApplyJoinGroupActivityConfig(this, new StringBuilder().append(this.bay.getGroupId()).toString(), this.bay.getData().Qd(), this.bay.getData().Qe())));
                    } else if (ApplyJoinGroupActivityConfig.JOINTYPE_INVITE == this.bay.getJoinType()) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2008014, new ApplyJoinGroupActivityConfig(this, new StringBuilder().append(this.bay.getGroupId()).toString(), this.bay.getData().Qd(), this.bay.getData().Qe(), this.bay.getInviteUserId(), this.bay.getDefaultUserMsg())));
                    }
                }
            }
        } else if (view == this.bax.OM()) {
            if (this.bay.getData() != null && this.bay.getData().getGroup() != null) {
                GroupCardActivity.a(this, this.bay.getGroupId(), this.bay.getData().getGroup().getName(), this.bay.getData().getGroup().getPortrait());
            }
        } else if (view == this.bax.OR()) {
            if (this.bay.getData() != null && this.bay.getData().getGroup() != null) {
                GroupSettingActivity.a(this, 4, this.bay.getData().getGroup().getName(), new StringBuilder().append(this.bay.getGroupId()).toString(), this.bay.getData().Qg(), this.bay.getData().getGroup().getFlag());
            }
        } else if (view == this.bax.OP()) {
            if (this.bay.getData() != null && this.bay.getData().getGroup() != null) {
                UpdateGroupActivity.a(this, 1, (int) this.bay.getGroupId(), 1, this.bay.getData().getGroup().getName());
            }
        } else if (view == this.bax.OO()) {
            if (this.bay.getData().Qg() && this.bay.getData() != null && this.bay.getData().getGroup() != null) {
                UpdateGroupActivity.a(this, 2, (int) this.bay.getGroupId(), 2, this.bay.getData().getGroup().getIntro());
            }
        } else if (view == this.bax.OV() || view == this.bax.OL()) {
            MembersActivity.a(this, this.bay.getGroupId());
        } else if (view == this.bax.ON()) {
            InviteFriendListActivity.a(this, 0, (int) this.bay.getGroupId());
        } else if (view == this.bax.OQ() && this.bay.getData() != null && this.bay.getData().Qf()) {
            GroupActivityData Qa = this.bay.getData().Qa();
            if (Qa != null) {
                GroupActivityActivity.a(this, Qa.getActivityId(), this.bay.getGroupId(), 0);
            } else {
                CreateGroupActivityActivity.j(this, (int) this.bay.getGroupId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void closeActivity() {
        setResult(-1);
        finish();
    }

    @Override // com.baidu.tieba.im.groupInfo.ag
    public void a(View view, Object obj, int i) {
        this.bax.a(obj, i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        if (view == this.bax.OJ()) {
            if (this.bay.getData() == null || this.bay.getData().getGroup() == null) {
                return false;
            }
            this.bax.gm(String.valueOf(this.bay.getData().getGroup().getGroupId()));
            return false;
        } else if (view != this.bax.OO() || this.bay.getData().Qg()) {
            return false;
        } else {
            if (this.bay.getData() != null && this.bay.getData().getGroup() != null) {
                this.bax.gl(String.valueOf(this.bay.getData().getGroup().getIntro()));
            }
            return true;
        }
    }

    @Override // com.baidu.tieba.im.groupInfo.af
    public void onClick(View view, int i, Object obj, int i2) {
        if (i == 2) {
            this.bax.Pb();
        } else if (i == 1) {
            ArrayList<String> bigUrlList = this.bay.getBigUrlList();
            if (obj != null && (obj instanceof PhotoUrlData) && bigUrlList != null) {
                GroupImageActivity.a(this, ((PhotoUrlData) obj).getBigurl(), bigUrlList, this.bay.getGroupId());
            }
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        String stringExtra;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 1:
                    if (intent != null) {
                        String stringExtra2 = intent.getStringExtra("group_text");
                        if (this.bax != null) {
                            this.bax.setGroupName(stringExtra2);
                        }
                        if (this.bay != null && this.bay.getData() != null && this.bay.getData().getGroup() != null) {
                            this.bay.getData().getGroup().setName(stringExtra2);
                            return;
                        }
                        return;
                    }
                    return;
                case 2:
                    if (intent != null) {
                        String stringExtra3 = intent.getStringExtra("group_text");
                        if (this.bax != null) {
                            this.bax.gj(stringExtra3);
                        }
                        if (this.bay != null && this.bay.getData() != null && this.bay.getData().getGroup() != null) {
                            this.bay.getData().getGroup().setIntro(stringExtra3);
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
                        int intExtra = intent.getIntExtra("intent_data_group_flag", 0);
                        if (this.bay != null && this.bay.getData() != null && this.bay.getData().getGroup() != null) {
                            this.bay.getData().getGroup().setFlag(intExtra);
                            return;
                        }
                        return;
                    }
                    return;
                case 12001:
                    EditHeadActivity.a(this, 12001, 12010, null, TbadkApplication.getCurrentAccountObj(), 2);
                    return;
                case 12002:
                    if (intent != null && (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) != null) {
                        this.writeImagesInfo.parseJson(stringExtra);
                        this.writeImagesInfo.updateQuality();
                        if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                            EditHeadActivity.a(this, 12002, 12009, intent.getData(), TbadkApplication.getCurrentAccountObj(), 2, this.writeImagesInfo.getChosedFiles().get(0).getFilePath());
                        }
                        this.writeImagesInfo.clear();
                        return;
                    }
                    return;
                case 12009:
                case 12010:
                    PhotoUrlData photoUrlData = (PhotoUrlData) intent.getSerializableExtra(EditHeadActivity.Jx);
                    if (photoUrlData != null) {
                        ap.mw().b(photoUrlData.getSmallurl(), com.baidu.tbadk.core.util.s.bq(TbConfig.GROUP_HEAD_FILE), true, false, true);
                    }
                    b(photoUrlData);
                    return;
                case 21001:
                    c(intent.getBooleanExtra("ResultDataIsHiddenAddress", true) ? 1 : 0, intent.getStringExtra("ResultDataAddress"), intent.getStringExtra("ResultDataSelectedBusiness"));
                    return;
                default:
                    return;
            }
        } else if (i2 == 0 && i == 12010) {
            av.h(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(PhotoUrlData photoUrlData) {
        this.type = 2;
        if (photoUrlData != null) {
            gh(this.bay.generateDeleAlbum(photoUrlData));
        }
    }

    private void b(PhotoUrlData photoUrlData) {
        this.type = 1;
        if (photoUrlData != null) {
            String generateAddAlbum = this.bay.generateAddAlbum(photoUrlData);
            if (!TextUtils.isEmpty(generateAddAlbum)) {
                gh(generateAddAlbum);
            }
        }
    }

    private void c(int i, String str, String str2) {
        this.type = 4;
        if (this.aOx != null) {
            this.aOx.setGroupId(this.bay.getGroupId());
            this.aOx.setFlag(i);
            this.aOx.setPosition(str);
            this.aOx.setBusiness(str2);
            this.aOx.sendMessage(5);
            this.bax.OX();
        }
    }

    private void gh(String str) {
        if (this.aOx != null) {
            this.aOx.setGroupId(this.bay.getGroupId());
            this.aOx.setAlbum(str);
            this.aOx.sendMessage(3);
            this.bax.OX();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(Object obj) {
        com.baidu.tieba.im.groupCard.b.Os();
        this.type = 3;
        if (obj != null && (obj instanceof PhotoUrlData)) {
            PhotoUrlData photoUrlData = (PhotoUrlData) obj;
            this.bay.setChangePhotoUrlData(photoUrlData);
            String picId = photoUrlData.getPicId();
            if (this.aOx != null) {
                this.aOx.setGroupId(this.bay.getGroupId());
                this.aOx.setPortrait(picId);
                this.aOx.sendMessage(4);
                this.bax.OX();
            }
        }
    }

    public void a(GroupNewsPojo groupNewsPojo) {
        if (groupNewsPojo != null && this.bay != null && this.bay.getData() != null) {
            try {
                JSONObject jSONObject = new JSONObject(groupNewsPojo.getContent());
                String string = jSONObject.getJSONObject("eventParam").getString("groupId");
                if (jSONObject.getString("eventId").equals("003") && string.equals(String.valueOf(this.bay.getGroupId())) && this.bay.getData().Qf()) {
                    this.bay.getData().dj(false);
                    GroupData group = this.bay.getData().getGroup();
                    if (group != null && group.getMemberNum() > 1) {
                        group.setMemberNum(group.getMemberNum() - 1);
                    }
                    this.bax.a(this.bay.getData(), true);
                    OE();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void e(GroupNewsPojo groupNewsPojo) {
        try {
            String optString = new JSONObject(groupNewsPojo.getContent()).optJSONObject("eventParam").optString("groupId");
            if (!TextUtils.isEmpty(optString) && this.bay != null && optString.equals(String.valueOf(this.bay.getGroupId())) && this.bay.getData() != null) {
                this.bay.getData().dj(true);
                if (this.bax != null) {
                    this.bax.OZ();
                    OE();
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(GroupNewsPojo groupNewsPojo) {
        if (groupNewsPojo != null && this.bay != null && this.bay.getData() != null) {
            try {
                JSONObject jSONObject = new JSONObject(groupNewsPojo.getContent());
                JSONObject jSONObject2 = jSONObject.getJSONObject("eventParam");
                String string = jSONObject2.getString("groupId");
                if (jSONObject.getString("eventId").equals("101") && string.equals(String.valueOf(this.bay.getGroupId()))) {
                    String string2 = jSONObject2.getString("groupName");
                    if (!TextUtils.isEmpty(string2)) {
                        this.bax.setGroupName(string2);
                        if (this.bay.getData() != null && this.bay.getData().getGroup() != null) {
                            this.bay.getData().getGroup().setName(string2);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(GroupNewsPojo groupNewsPojo) {
        if (groupNewsPojo != null && this.bay != null) {
            try {
                JSONObject jSONObject = new JSONObject(groupNewsPojo.getContent());
                String string = jSONObject.getJSONObject("eventParam").getString("groupId");
                if (jSONObject.getString("eventId").equals("107") && string.equals(String.valueOf(this.bay.getGroupId()))) {
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
    public void OE() {
        if (this.bay != null) {
            this.bay.clearGroupInfoCache(String.valueOf(this.bay.getGroupId()));
        }
    }
}
