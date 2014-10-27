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
import com.baidu.tbadk.core.util.bf;
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
public class GroupInfoActivity extends BaseActivity implements View.OnClickListener, View.OnLongClickListener, ae, af {
    private UpdateGroupModel aOj;
    private s bai;
    private GroupInfoModel baj;
    private q bak;
    private int type = 0;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private final DialogInterface.OnClickListener bal = new k(this);
    private final ad bam = new l(this);
    private final CustomMessageListener mCustomListener = new m(this, 0);
    private final CustomMessageListener aXM = new n(this, 0);

    static {
        Kj();
        Fm();
    }

    private static void Kj() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2008011, new o());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void Fm() {
        bf.mR().a(new p());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        HJ();
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

    private void HJ() {
        this.bak = new q(this);
        registerListener(103004, this.bak);
        registerListener(2001102, this.mCustomListener);
        registerListener(103102, this.bak);
        registerListener(103112, this.bak);
        registerListener(103110, this.bak);
        registerListener(103120, this.bak);
        registerListener(103121, this.bak);
        registerListener(2001132, this.aXM);
        registerListener(2001130, this.aXM);
        registerListener(2001134, this.aXM);
        registerListener(103104, this.bak);
        registerListener(2001141, this.aXM);
        registerListener(2001139, this.aXM);
        registerListener(103105, this.bak);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.baj.saveInstance(bundle);
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
        this.baj.cancelMessage();
        MessageManager.getInstance().unRegisterListener(this.aXM);
        if (this.bai != null) {
            this.bai.onDestory();
        }
    }

    private void initUI() {
        this.bai = new s(this);
        this.bai.e(this.bal);
        this.bai.a(this.bam);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.bai != null) {
            this.bai.onPause();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startLoading() {
        this.bai.OU();
        this.baj.sendLocalMessage(this.baj.getGroupId(), this.baj.getFrom());
        this.baj.sendMessage(this.baj.getGroupId(), this.baj.getFrom());
    }

    public void a(Bundle bundle, Intent intent) {
        this.baj = new GroupInfoModel(this);
        this.baj.setUniqueId(getUniqueId());
        if (bundle == null) {
            GroupInfoModel groupInfoModel = this.baj;
            if (intent == null) {
                intent = getIntent();
            }
            groupInfoModel.initWithIntent(intent);
        } else {
            this.baj.initWithBundle(bundle);
        }
        this.aOj = new UpdateGroupModel(this);
        this.aOj.setUniqueId(getUniqueId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void De() {
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
        if (this.bai != null) {
            this.bai.changeSkinType(i);
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: long : 0x01cd: INVOKE  (r2v35 long A[REMOVE]) = 
      (wrap: com.baidu.tieba.im.model.GroupInfoModel : 0x01cb: IGET  (r2v34 com.baidu.tieba.im.model.GroupInfoModel A[REMOVE]) = (r9v0 'this' com.baidu.tieba.im.groupInfo.GroupInfoActivity A[IMMUTABLE_TYPE, THIS]) com.baidu.tieba.im.groupInfo.GroupInfoActivity.baj com.baidu.tieba.im.model.GroupInfoModel)
     type: VIRTUAL call: com.baidu.tieba.im.model.GroupInfoModel.getGroupId():long)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: long : 0x0211: INVOKE  (r2v31 long A[REMOVE]) = 
      (wrap: com.baidu.tieba.im.model.GroupInfoModel : 0x020f: IGET  (r2v30 com.baidu.tieba.im.model.GroupInfoModel A[REMOVE]) = (r9v0 'this' com.baidu.tieba.im.groupInfo.GroupInfoActivity A[IMMUTABLE_TYPE, THIS]) com.baidu.tieba.im.groupInfo.GroupInfoActivity.baj com.baidu.tieba.im.model.GroupInfoModel)
     type: VIRTUAL call: com.baidu.tieba.im.model.GroupInfoModel.getGroupId():long)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: long : 0x02c4: INVOKE  (r3v2 long A[REMOVE]) = 
      (wrap: com.baidu.tieba.im.model.GroupInfoModel : 0x02c2: IGET  (r3v1 com.baidu.tieba.im.model.GroupInfoModel A[REMOVE]) = (r9v0 'this' com.baidu.tieba.im.groupInfo.GroupInfoActivity A[IMMUTABLE_TYPE, THIS]) com.baidu.tieba.im.groupInfo.GroupInfoActivity.baj com.baidu.tieba.im.model.GroupInfoModel)
     type: VIRTUAL call: com.baidu.tieba.im.model.GroupInfoModel.getGroupId():long)] */
    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bai.OV()) {
            if (this.baj.getData().Qd()) {
                com.baidu.tbadk.core.i.l(this, "edit_place_at_groupinfo");
                GroupAddressLocateActivity.a(this, 21001, this.baj.getData().getGroup().getPosition(), this.baj.getData().getGroup().getBusiness(), (this.baj.getData().getGroup().getFlag() & 1) == 1);
            }
        } else if (view == this.bai.Nw()) {
            closeActivity();
        } else if (view == this.bai.OH()) {
            if (this.baj.getData() != null && this.baj.getData().getGroup() != null) {
                sendMessage(new CustomMessage(2002001, new FrsGroupActivityConfig(this, String.valueOf(this.baj.getData().getGroup().getForumId()), this.baj.getData().Qe() ? false : true)));
            }
        } else if (view == this.bai.OQ()) {
            if (this.baj.getData() != null && this.baj.getData().getGroup() != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this, String.valueOf(this.baj.getData().getGroup().getAuthorId()), this.baj.getData().getGroup().getAuthorName())));
            }
        } else if (view == this.bai.OR()) {
            GroupLevelActivity.a(this, this.baj.getGroupId(), this.baj.getData().isMemGroup());
        } else if (view == this.bai.OP()) {
            if (TextUtils.isEmpty(TbadkApplication.getCurrentAccount())) {
                LoginActivity.a((Activity) this, "", true, 3);
            } else if (this.baj.getData() != null) {
                if (this.baj.getData().Qc()) {
                    if (this.baj.getData().getGroup() != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(this, (int) this.baj.getGroupId(), this.baj.getData().getGroup().getName(), this.baj.getData().getGroup().getAuthorId(), "group_info")));
                    }
                } else if (this.baj.hasRecentJoin()) {
                    showToast(com.baidu.tieba.y.has_recent_join);
                } else if (this.baj.getData() != null) {
                    if (this.baj.getData().Qb() <= 0) {
                        showToast(com.baidu.tieba.y.add_group_max);
                    } else if (ApplyJoinGroupActivityConfig.JOINTYPE_DEFAULT == this.baj.getJoinType()) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2008014, new ApplyJoinGroupActivityConfig(this, new StringBuilder().append(this.baj.getGroupId()).toString(), this.baj.getData().Qa(), this.baj.getData().Qb())));
                    } else if (ApplyJoinGroupActivityConfig.JOINTYPE_INVITE == this.baj.getJoinType()) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2008014, new ApplyJoinGroupActivityConfig(this, new StringBuilder().append(this.baj.getGroupId()).toString(), this.baj.getData().Qa(), this.baj.getData().Qb(), this.baj.getInviteUserId(), this.baj.getDefaultUserMsg())));
                    }
                }
            }
        } else if (view == this.bai.OJ()) {
            if (this.baj.getData() != null && this.baj.getData().getGroup() != null) {
                GroupCardActivity.a(this, this.baj.getGroupId(), this.baj.getData().getGroup().getName(), this.baj.getData().getGroup().getPortrait());
            }
        } else if (view == this.bai.OO()) {
            if (this.baj.getData() != null && this.baj.getData().getGroup() != null) {
                GroupSettingActivity.a(this, 4, this.baj.getData().getGroup().getName(), new StringBuilder().append(this.baj.getGroupId()).toString(), this.baj.getData().Qd(), this.baj.getData().getGroup().getFlag());
            }
        } else if (view == this.bai.OM()) {
            if (this.baj.getData() != null && this.baj.getData().getGroup() != null) {
                UpdateGroupActivity.a(this, 1, (int) this.baj.getGroupId(), 1, this.baj.getData().getGroup().getName());
            }
        } else if (view == this.bai.OL()) {
            if (this.baj.getData().Qd() && this.baj.getData() != null && this.baj.getData().getGroup() != null) {
                UpdateGroupActivity.a(this, 2, (int) this.baj.getGroupId(), 2, this.baj.getData().getGroup().getIntro());
            }
        } else if (view == this.bai.OS() || view == this.bai.OI()) {
            MembersActivity.a(this, this.baj.getGroupId());
        } else if (view == this.bai.OK()) {
            InviteFriendListActivity.a(this, 0, (int) this.baj.getGroupId());
        } else if (view == this.bai.ON() && this.baj.getData() != null && this.baj.getData().Qc()) {
            GroupActivityData PX = this.baj.getData().PX();
            if (PX != null) {
                GroupActivityActivity.a(this, PX.getActivityId(), this.baj.getGroupId(), 0);
            } else {
                CreateGroupActivityActivity.j(this, (int) this.baj.getGroupId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void closeActivity() {
        setResult(-1);
        finish();
    }

    @Override // com.baidu.tieba.im.groupInfo.af
    public void a(View view, Object obj, int i) {
        this.bai.a(obj, i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        if (view == this.bai.OG()) {
            if (this.baj.getData() == null || this.baj.getData().getGroup() == null) {
                return false;
            }
            this.bai.gm(String.valueOf(this.baj.getData().getGroup().getGroupId()));
            return false;
        } else if (view != this.bai.OL() || this.baj.getData().Qd()) {
            return false;
        } else {
            if (this.baj.getData() != null && this.baj.getData().getGroup() != null) {
                this.bai.gl(String.valueOf(this.baj.getData().getGroup().getIntro()));
            }
            return true;
        }
    }

    @Override // com.baidu.tieba.im.groupInfo.ae
    public void onClick(View view, int i, Object obj, int i2) {
        if (i == 2) {
            this.bai.OY();
        } else if (i == 1) {
            ArrayList<String> bigUrlList = this.baj.getBigUrlList();
            if (obj != null && (obj instanceof PhotoUrlData) && bigUrlList != null) {
                GroupImageActivity.a(this, ((PhotoUrlData) obj).getBigurl(), bigUrlList, this.baj.getGroupId());
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
                        if (this.bai != null) {
                            this.bai.setGroupName(stringExtra2);
                        }
                        if (this.baj != null && this.baj.getData() != null && this.baj.getData().getGroup() != null) {
                            this.baj.getData().getGroup().setName(stringExtra2);
                            return;
                        }
                        return;
                    }
                    return;
                case 2:
                    if (intent != null) {
                        String stringExtra3 = intent.getStringExtra("group_text");
                        if (this.bai != null) {
                            this.bai.gj(stringExtra3);
                        }
                        if (this.baj != null && this.baj.getData() != null && this.baj.getData().getGroup() != null) {
                            this.baj.getData().getGroup().setIntro(stringExtra3);
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
                        if (this.baj != null && this.baj.getData() != null && this.baj.getData().getGroup() != null) {
                            this.baj.getData().getGroup().setFlag(intExtra);
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
                    PhotoUrlData photoUrlData = (PhotoUrlData) intent.getSerializableExtra(EditHeadActivity.Jw);
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
            gh(this.baj.generateDeleAlbum(photoUrlData));
        }
    }

    private void b(PhotoUrlData photoUrlData) {
        this.type = 1;
        if (photoUrlData != null) {
            String generateAddAlbum = this.baj.generateAddAlbum(photoUrlData);
            if (!TextUtils.isEmpty(generateAddAlbum)) {
                gh(generateAddAlbum);
            }
        }
    }

    private void c(int i, String str, String str2) {
        this.type = 4;
        if (this.aOj != null) {
            this.aOj.setGroupId(this.baj.getGroupId());
            this.aOj.setFlag(i);
            this.aOj.setPosition(str);
            this.aOj.setBusiness(str2);
            this.aOj.sendMessage(5);
            this.bai.OU();
        }
    }

    private void gh(String str) {
        if (this.aOj != null) {
            this.aOj.setGroupId(this.baj.getGroupId());
            this.aOj.setAlbum(str);
            this.aOj.sendMessage(3);
            this.bai.OU();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(Object obj) {
        com.baidu.tieba.im.groupCard.b.Op();
        this.type = 3;
        if (obj != null && (obj instanceof PhotoUrlData)) {
            PhotoUrlData photoUrlData = (PhotoUrlData) obj;
            this.baj.setChangePhotoUrlData(photoUrlData);
            String picId = photoUrlData.getPicId();
            if (this.aOj != null) {
                this.aOj.setGroupId(this.baj.getGroupId());
                this.aOj.setPortrait(picId);
                this.aOj.sendMessage(4);
                this.bai.OU();
            }
        }
    }

    public void a(GroupNewsPojo groupNewsPojo) {
        if (groupNewsPojo != null && this.baj != null && this.baj.getData() != null) {
            try {
                JSONObject jSONObject = new JSONObject(groupNewsPojo.getContent());
                String string = jSONObject.getJSONObject("eventParam").getString("groupId");
                if (jSONObject.getString("eventId").equals("003") && string.equals(String.valueOf(this.baj.getGroupId())) && this.baj.getData().Qc()) {
                    this.baj.getData().dj(false);
                    GroupData group = this.baj.getData().getGroup();
                    if (group != null && group.getMemberNum() > 1) {
                        group.setMemberNum(group.getMemberNum() - 1);
                    }
                    this.bai.a(this.baj.getData(), true);
                    OB();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void e(GroupNewsPojo groupNewsPojo) {
        try {
            String optString = new JSONObject(groupNewsPojo.getContent()).optJSONObject("eventParam").optString("groupId");
            if (!TextUtils.isEmpty(optString) && this.baj != null && optString.equals(String.valueOf(this.baj.getGroupId())) && this.baj.getData() != null) {
                this.baj.getData().dj(true);
                if (this.bai != null) {
                    this.bai.OW();
                    OB();
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(GroupNewsPojo groupNewsPojo) {
        if (groupNewsPojo != null && this.baj != null && this.baj.getData() != null) {
            try {
                JSONObject jSONObject = new JSONObject(groupNewsPojo.getContent());
                JSONObject jSONObject2 = jSONObject.getJSONObject("eventParam");
                String string = jSONObject2.getString("groupId");
                if (jSONObject.getString("eventId").equals("101") && string.equals(String.valueOf(this.baj.getGroupId()))) {
                    String string2 = jSONObject2.getString("groupName");
                    if (!TextUtils.isEmpty(string2)) {
                        this.bai.setGroupName(string2);
                        if (this.baj.getData() != null && this.baj.getData().getGroup() != null) {
                            this.baj.getData().getGroup().setName(string2);
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
        if (groupNewsPojo != null && this.baj != null) {
            try {
                JSONObject jSONObject = new JSONObject(groupNewsPojo.getContent());
                String string = jSONObject.getJSONObject("eventParam").getString("groupId");
                if (jSONObject.getString("eventId").equals("107") && string.equals(String.valueOf(this.baj.getGroupId()))) {
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
    public void OB() {
        if (this.baj != null) {
            this.baj.clearGroupInfoCache(String.valueOf(this.baj.getGroupId()));
        }
    }
}
