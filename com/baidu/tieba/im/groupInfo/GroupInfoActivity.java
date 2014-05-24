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
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.at;
import com.baidu.tbadk.core.data.GroupData;
import com.baidu.tbadk.core.frameworkData.MessageTypes;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.core.util.bi;
import com.baidu.tbadk.coreExtra.act.EditHeadActivity;
import com.baidu.tbadk.coreExtra.act.LoginActivity;
import com.baidu.tbadk.coreExtra.data.PhotoUrlData;
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
import com.baidu.tieba.im.model.by;
import com.baidu.tieba.im.updategroup.UpdateGroupActivity;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class GroupInfoActivity extends BaseActivity implements View.OnClickListener, View.OnLongClickListener, ae, af {
    private r f;
    private com.baidu.tieba.im.model.m g;
    private by h;
    private p i;
    private final int a = 1;
    private final int b = 2;
    private final int c = 3;
    private final int d = 4;
    private int e = 0;
    private final DialogInterface.OnClickListener j = new j(this);
    private final ad k = new k(this);
    private final CustomMessageListener l = new l(this, 0);
    private final CustomMessageListener m = new m(this, 0);

    static {
        a();
        b();
    }

    private static void a() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2010011, new n());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void b() {
        bi.a().a(new o());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        c();
        a(bundle, (Intent) null);
        d();
        e();
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        a((Bundle) null, intent);
        d();
        e();
    }

    private void c() {
        this.i = new p(this);
        MessageManager.getInstance().registerListener(MessageTypes.CMD_REQUEST_GROUP_INFO_BY_ID, this.i);
        MessageManager.getInstance().registerListener(MessageTypes.CMD_REQUEST_GROUP_INFO_BY_ID_LOCAL, this.l);
        MessageManager.getInstance().registerListener(MessageTypes.CMD_UPDATE_GROUP, this.i);
        MessageManager.getInstance().registerListener(MessageTypes.CMD_REMOVE_MEMBERS, this.i);
        MessageManager.getInstance().registerListener(MessageTypes.CMD_JOIN_GROUP, this.i);
        MessageManager.getInstance().registerListener(MessageTypes.CMD_CREATE_GROUP_ACTIVITY, this.i);
        MessageManager.getInstance().registerListener(MessageTypes.CMD_DEL_GROUP_ACTIVITY, this.i);
        MessageManager.getInstance().registerListener(MessageTypes.CMD_IM_PUSH_NOTIFY_KICK_OUT, this.m);
        MessageManager.getInstance().registerListener(MessageTypes.CMD_IM_PUSH_NOTIFY_APPLY_JOIN_SUCCESS, this.m);
        MessageManager.getInstance().registerListener(MessageTypes.CMD_IM_PUSH_NOTIFY_GROUP_NAME_CHANGE, this.m);
        MessageManager.getInstance().registerListener(MessageTypes.CMD_DISSMISS_GROUP, this.i);
        MessageManager.getInstance().registerListener(MessageTypes.CMD_IM_PUSH_NOTIFY_DISMISS_GROUP, this.m);
        MessageManager.getInstance().registerListener(MessageTypes.CMD_IM_PUSH_NOTIFY_GROUP_ACTIVITYS_CHANGE, this.m);
        MessageManager.getInstance().registerListener(MessageTypes.CMD_UPGRADE_MEMBER_GROUP, this.i);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.g.b(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.g.cancelMessage();
        MessageManager.getInstance().unRegisterListener(this.m);
        if (this.f != null) {
            this.f.v();
        }
    }

    private void d() {
        this.f = new r(this);
        this.f.a(this.j);
        this.f.a(this.k);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.f != null) {
            this.f.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.f.q();
        this.g.b(this.g.d(), this.g.e());
    }

    public void a(Bundle bundle, Intent intent) {
        this.g = new com.baidu.tieba.im.model.m();
        this.g.setUniqueId(getUniqueId());
        if (bundle == null) {
            com.baidu.tieba.im.model.m mVar = this.g;
            if (intent == null) {
                intent = getIntent();
            }
            mVar.a(intent);
        } else {
            this.g.a(bundle);
        }
        this.h = new by();
        this.h.setUniqueId(getUniqueId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        onChangeSkinType(TbadkApplication.m252getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        if (this.f != null) {
            this.f.a(i);
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: long : 0x01cc: INVOKE  (r2v35 long A[REMOVE]) = 
      (wrap: com.baidu.tieba.im.model.m : 0x01ca: IGET  (r2v34 com.baidu.tieba.im.model.m A[REMOVE]) = (r9v0 'this' com.baidu.tieba.im.groupInfo.GroupInfoActivity A[IMMUTABLE_TYPE, THIS]) com.baidu.tieba.im.groupInfo.GroupInfoActivity.g com.baidu.tieba.im.model.m)
     type: VIRTUAL call: com.baidu.tieba.im.model.m.d():long)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: long : 0x0210: INVOKE  (r2v31 long A[REMOVE]) = 
      (wrap: com.baidu.tieba.im.model.m : 0x020e: IGET  (r2v30 com.baidu.tieba.im.model.m A[REMOVE]) = (r9v0 'this' com.baidu.tieba.im.groupInfo.GroupInfoActivity A[IMMUTABLE_TYPE, THIS]) com.baidu.tieba.im.groupInfo.GroupInfoActivity.g com.baidu.tieba.im.model.m)
     type: VIRTUAL call: com.baidu.tieba.im.model.m.d():long)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: long : 0x02c3: INVOKE  (r3v2 long A[REMOVE]) = 
      (wrap: com.baidu.tieba.im.model.m : 0x02c1: IGET  (r3v1 com.baidu.tieba.im.model.m A[REMOVE]) = (r9v0 'this' com.baidu.tieba.im.groupInfo.GroupInfoActivity A[IMMUTABLE_TYPE, THIS]) com.baidu.tieba.im.groupInfo.GroupInfoActivity.g com.baidu.tieba.im.model.m)
     type: VIRTUAL call: com.baidu.tieba.im.model.m.d():long)] */
    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f.r()) {
            if (this.g.f().h()) {
                com.baidu.tbadk.core.f.a(this, "edit_place_at_groupinfo");
                GroupAddressLocateActivity.a(this, 21001, this.g.f().b().getPosition(), this.g.f().b().getBusiness(), (this.g.f().b().getFlag() & 1) == 1);
            }
        } else if (view == this.f.o()) {
            closeActivity();
        } else if (view == this.f.c()) {
            if (this.g.f() != null && this.g.f().b() != null) {
                sendMessage(new CustomMessage(2003001, new com.baidu.tbadk.core.atomData.n(this, String.valueOf(this.g.f().b().getForumId()), this.g.f().i() ? false : true)));
            }
        } else if (view == this.f.l()) {
            if (this.g.f() != null && this.g.f().b() != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2003003, new at(this, String.valueOf(this.g.f().b().getAuthorId()), this.g.f().b().getAuthorName())));
            }
        } else if (view == this.f.m()) {
            GroupLevelActivity.a(this, this.g.d());
        } else if (view == this.f.k()) {
            BdLog.d("botton click");
            if (TextUtils.isEmpty(TbadkApplication.getCurrentAccount())) {
                LoginActivity.a((Activity) this, "", true, 3);
            } else if (this.g.f() != null) {
                if (this.g.f().g()) {
                    if (this.g.f().b() != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2003001, new com.baidu.tbadk.core.atomData.p(this, (int) this.g.d(), this.g.f().b().getName(), this.g.f().b().getAuthorId(), "group_info")));
                    }
                } else if (this.g.l()) {
                    showToast(com.baidu.tieba.y.has_recent_join);
                } else if (this.g.f() != null) {
                    if (this.g.f().f() <= 0) {
                        showToast(com.baidu.tieba.y.add_group_max);
                    } else if (com.baidu.tbadk.core.atomData.b.a == this.g.a()) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2010014, new com.baidu.tbadk.core.atomData.b(this, new StringBuilder().append(this.g.d()).toString(), this.g.f().e(), this.g.f().f())));
                    } else if (com.baidu.tbadk.core.atomData.b.b == this.g.a()) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2010014, new com.baidu.tbadk.core.atomData.b(this, new StringBuilder().append(this.g.d()).toString(), this.g.f().e(), this.g.f().f(), this.g.b(), this.g.c())));
                    }
                }
            }
        } else if (view == this.f.e()) {
            if (this.g.f() != null && this.g.f().b() != null) {
                GroupCardActivity.a(this, this.g.d(), this.g.f().b().getName(), this.g.f().b().getPortrait());
            }
        } else if (view == this.f.j()) {
            if (this.g.f() != null && this.g.f().b() != null) {
                GroupSettingActivity.a(this, 4, this.g.f().b().getName(), new StringBuilder().append(this.g.d()).toString(), this.g.f().h(), this.g.f().b().getFlag());
            }
        } else if (view == this.f.h()) {
            if (this.g.f() != null && this.g.f().b() != null) {
                UpdateGroupActivity.a(this, 1, (int) this.g.d(), 1, this.g.f().b().getName());
            }
        } else if (view == this.f.g()) {
            if (this.g.f().h() && this.g.f() != null && this.g.f().b() != null) {
                UpdateGroupActivity.a(this, 2, (int) this.g.d(), 2, this.g.f().b().getIntro());
            }
        } else if (view == this.f.n() || view == this.f.d()) {
            MembersActivity.a(this, this.g.d());
        } else if (view == this.f.f()) {
            InviteFriendListActivity.a(this, 0, (int) this.g.d());
        } else if (view == this.f.i() && this.g.f() != null && this.g.f().g()) {
            GroupActivityData a = this.g.f().a();
            if (a != null) {
                GroupActivityActivity.a(this, a.getActivityId(), this.g.d(), 0);
            } else {
                CreateGroupActivityActivity.a(this, (int) this.g.d());
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
        this.f.a(obj, i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        if (view == this.f.b()) {
            if (this.g.f() == null || this.g.f().b() == null) {
                return false;
            }
            this.f.e(String.valueOf(this.g.f().b().getGroupId()));
            return false;
        } else if (view != this.f.g() || this.g.f().h()) {
            return false;
        } else {
            if (this.g.f() != null && this.g.f().b() != null) {
                this.f.d(String.valueOf(this.g.f().b().getIntro()));
            }
            return true;
        }
    }

    @Override // com.baidu.tieba.im.groupInfo.ae
    public void onClick(View view, int i, Object obj, int i2) {
        if (i == 2) {
            this.f.t();
        } else if (i == 1) {
            ArrayList<String> g = this.g.g();
            if (obj != null && (obj instanceof PhotoUrlData) && g != null) {
                GroupImageActivity.a(this, ((PhotoUrlData) obj).getBigurl(), g, this.g.d());
            }
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 1:
                    if (intent != null) {
                        String stringExtra = intent.getStringExtra("group_text");
                        if (this.f != null) {
                            this.f.a(stringExtra);
                        }
                        if (this.g != null && this.g.f() != null && this.g.f().b() != null) {
                            this.g.f().b().setName(stringExtra);
                            return;
                        }
                        return;
                    }
                    return;
                case 2:
                    if (intent != null) {
                        String stringExtra2 = intent.getStringExtra("group_text");
                        if (this.f != null) {
                            this.f.b(stringExtra2);
                        }
                        if (this.g != null && this.g.f() != null && this.g.f().b() != null) {
                            this.g.f().b().setIntro(stringExtra2);
                            return;
                        }
                        return;
                    }
                    return;
                case 3:
                    e();
                    return;
                case 4:
                    if (intent != null) {
                        int intExtra = intent.getIntExtra("intent_data_group_flag", 0);
                        if (this.g != null && this.g.f() != null && this.g.f().b() != null) {
                            this.g.f().b().setFlag(intExtra);
                            return;
                        }
                        return;
                    }
                    return;
                case 12001:
                    EditHeadActivity.a(this, 12001, 12010, null, TbadkApplication.getCurrentAccountObj(), 2);
                    return;
                case 12002:
                    if (intent != null) {
                        EditHeadActivity.a(this, 12002, 12009, intent.getData(), TbadkApplication.getCurrentAccountObj(), 2);
                        return;
                    }
                    return;
                case 12009:
                case 12010:
                    PhotoUrlData photoUrlData = (PhotoUrlData) intent.getSerializableExtra(EditHeadActivity.b);
                    if (photoUrlData != null) {
                        aw.a().b(photoUrlData.getSmallurl(), com.baidu.tbadk.core.util.x.c(TbConfig.GROUP_HEAD_FILE), true, false, true);
                    }
                    b(photoUrlData);
                    return;
                case 21001:
                    a(intent.getBooleanExtra("ResultDataIsHiddenAddress", true) ? 1 : 0, intent.getStringExtra("ResultDataAddress"), intent.getStringExtra("ResultDataSelectedBusiness"));
                    return;
                default:
                    return;
            }
        } else if (i2 == 0) {
            if (i == 12010) {
                bb.a(this);
            } else if (i == 12009) {
                bb.b(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(PhotoUrlData photoUrlData) {
        this.e = 2;
        if (photoUrlData != null) {
            a(this.g.b(photoUrlData));
        }
    }

    private void b(PhotoUrlData photoUrlData) {
        this.e = 1;
        if (photoUrlData != null) {
            String c = this.g.c(photoUrlData);
            if (!TextUtils.isEmpty(c)) {
                a(c);
            }
        }
    }

    private void a(int i, String str, String str2) {
        this.e = 4;
        if (this.h != null) {
            this.h.a(this.g.d());
            this.h.b(i);
            this.h.d(str);
            this.h.e(str2);
            this.h.c(5);
            this.f.q();
        }
    }

    private void a(String str) {
        if (this.h != null) {
            this.h.a(this.g.d());
            this.h.f(str);
            this.h.c(3);
            this.f.q();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Object obj) {
        com.baidu.tieba.im.groupCard.b.a();
        this.e = 3;
        if (obj != null && (obj instanceof PhotoUrlData)) {
            PhotoUrlData photoUrlData = (PhotoUrlData) obj;
            this.g.a(photoUrlData);
            String picId = photoUrlData.getPicId();
            if (this.h != null) {
                this.h.a(this.g.d());
                this.h.c(picId);
                this.h.c(4);
                this.f.q();
            }
        }
    }

    public void a(GroupNewsPojo groupNewsPojo) {
        if (groupNewsPojo != null && this.g != null && this.g.f() != null) {
            try {
                JSONObject jSONObject = new JSONObject(groupNewsPojo.getContent());
                String string = jSONObject.getJSONObject("eventParam").getString("groupId");
                if (jSONObject.getString("eventId").equals("003") && string.equals(String.valueOf(this.g.d())) && this.g.f().g()) {
                    this.g.f().a(false);
                    GroupData b = this.g.f().b();
                    if (b != null && b.getMemberNum() > 1) {
                        b.setMemberNum(b.getMemberNum() - 1);
                    }
                    this.f.a(this.g.f(), true);
                    g();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void b(GroupNewsPojo groupNewsPojo) {
        try {
            String optString = new JSONObject(groupNewsPojo.getContent()).optJSONObject("eventParam").optString("groupId");
            if (!TextUtils.isEmpty(optString) && this.g != null && optString.equals(String.valueOf(this.g.d())) && this.g.f() != null) {
                this.g.f().a(true);
                if (this.f != null) {
                    this.f.s();
                    g();
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(GroupNewsPojo groupNewsPojo) {
        if (groupNewsPojo != null && this.g != null && this.g.f() != null) {
            try {
                JSONObject jSONObject = new JSONObject(groupNewsPojo.getContent());
                JSONObject jSONObject2 = jSONObject.getJSONObject("eventParam");
                String string = jSONObject2.getString("groupId");
                if (jSONObject.getString("eventId").equals("101") && string.equals(String.valueOf(this.g.d()))) {
                    String string2 = jSONObject2.getString("groupName");
                    if (!TextUtils.isEmpty(string2)) {
                        this.f.a(string2);
                        if (this.g.f() != null && this.g.f().b() != null) {
                            this.g.f().b().setName(string2);
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
        if (groupNewsPojo != null && this.g != null) {
            try {
                JSONObject jSONObject = new JSONObject(groupNewsPojo.getContent());
                String string = jSONObject.getJSONObject("eventParam").getString("groupId");
                if (jSONObject.getString("eventId").equals("107") && string.equals(String.valueOf(this.g.d()))) {
                    finish();
                    BdLog.d("dismiss suc");
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
    public void g() {
        if (this.g != null) {
            this.g.b(String.valueOf(this.g.d()));
        }
    }
}
