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
import com.baidu.tbadk.core.data.GroupData;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.bg;
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
import com.baidu.tieba.im.model.bb;
import com.baidu.tieba.im.updategroup.UpdateGroupActivity;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class GroupInfoActivity extends BaseActivity implements View.OnClickListener, View.OnLongClickListener, ad, ae {
    private r b;
    private com.baidu.tieba.im.model.k c;
    private bb d;
    private p e;
    private int a = 0;
    private final DialogInterface.OnClickListener f = new j(this);
    private final ac g = new k(this);
    private final CustomMessageListener h = new l(this, 0);
    private final CustomMessageListener i = new m(this, 0);

    static {
        a();
        b();
    }

    private static void a() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2008011, new n());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void b() {
        bg.a().a(new o());
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
        this.e = new p(this);
        registerListener(103004, this.e);
        registerListener(2001102, this.h);
        registerListener(103102, this.e);
        registerListener(103112, this.e);
        registerListener(103110, this.e);
        registerListener(103120, this.e);
        registerListener(103121, this.e);
        registerListener(2001132, this.i);
        registerListener(2001130, this.i);
        registerListener(2001134, this.i);
        registerListener(103104, this.e);
        registerListener(2001141, this.i);
        registerListener(2001139, this.i);
        registerListener(103105, this.e);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.c.b(bundle);
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
        this.c.cancelMessage();
        MessageManager.getInstance().unRegisterListener(this.i);
        if (this.b != null) {
            this.b.v();
        }
    }

    private void d() {
        this.b = new r(this);
        this.b.a(this.f);
        this.b.a(this.g);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.b != null) {
            this.b.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.b.q();
        this.c.b(this.c.d(), this.c.e());
        this.c.a(this.c.d(), this.c.e());
    }

    public void a(Bundle bundle, Intent intent) {
        this.c = new com.baidu.tieba.im.model.k(this);
        this.c.setUniqueId(getUniqueId());
        if (bundle == null) {
            com.baidu.tieba.im.model.k kVar = this.c;
            if (intent == null) {
                intent = getIntent();
            }
            kVar.a(intent);
        } else {
            this.c.a(bundle);
        }
        this.d = new bb(this);
        this.d.setUniqueId(getUniqueId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        onChangeSkinType(TbadkApplication.m252getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        if (this.b != null) {
            this.b.a(i);
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: long : 0x01d0: INVOKE  (r2v35 long A[REMOVE]) = 
      (wrap: com.baidu.tieba.im.model.k : 0x01ce: IGET  (r2v34 com.baidu.tieba.im.model.k A[REMOVE]) = (r9v0 'this' com.baidu.tieba.im.groupInfo.GroupInfoActivity A[IMMUTABLE_TYPE, THIS]) com.baidu.tieba.im.groupInfo.GroupInfoActivity.c com.baidu.tieba.im.model.k)
     type: VIRTUAL call: com.baidu.tieba.im.model.k.d():long)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: long : 0x0214: INVOKE  (r2v31 long A[REMOVE]) = 
      (wrap: com.baidu.tieba.im.model.k : 0x0212: IGET  (r2v30 com.baidu.tieba.im.model.k A[REMOVE]) = (r9v0 'this' com.baidu.tieba.im.groupInfo.GroupInfoActivity A[IMMUTABLE_TYPE, THIS]) com.baidu.tieba.im.groupInfo.GroupInfoActivity.c com.baidu.tieba.im.model.k)
     type: VIRTUAL call: com.baidu.tieba.im.model.k.d():long)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: long : 0x02c7: INVOKE  (r3v2 long A[REMOVE]) = 
      (wrap: com.baidu.tieba.im.model.k : 0x02c5: IGET  (r3v1 com.baidu.tieba.im.model.k A[REMOVE]) = (r9v0 'this' com.baidu.tieba.im.groupInfo.GroupInfoActivity A[IMMUTABLE_TYPE, THIS]) com.baidu.tieba.im.groupInfo.GroupInfoActivity.c com.baidu.tieba.im.model.k)
     type: VIRTUAL call: com.baidu.tieba.im.model.k.d():long)] */
    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.b.r()) {
            if (this.c.f().h()) {
                com.baidu.tbadk.core.f.a(this, "edit_place_at_groupinfo");
                GroupAddressLocateActivity.a(this, 21001, this.c.f().b().getPosition(), this.c.f().b().getBusiness(), (this.c.f().b().getFlag() & 1) == 1);
            }
        } else if (view == this.b.o()) {
            closeActivity();
        } else if (view == this.b.c()) {
            if (this.c.f() != null && this.c.f().b() != null) {
                sendMessage(new CustomMessage(2002001, new com.baidu.tbadk.core.atomData.t(this, String.valueOf(this.c.f().b().getForumId()), this.c.f().i() ? false : true)));
            }
        } else if (view == this.b.l()) {
            if (this.c.f() != null && this.c.f().b() != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new com.baidu.tbadk.core.atomData.bg(this, String.valueOf(this.c.f().b().getAuthorId()), this.c.f().b().getAuthorName())));
            }
        } else if (view == this.b.m()) {
            GroupLevelActivity.a(this, this.c.d(), this.c.f().j());
        } else if (view == this.b.k()) {
            if (TextUtils.isEmpty(TbadkApplication.getCurrentAccount())) {
                LoginActivity.a((Activity) this, "", true, 3);
            } else if (this.c.f() != null) {
                if (this.c.f().g()) {
                    if (this.c.f().b() != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new com.baidu.tbadk.core.atomData.x(this, (int) this.c.d(), this.c.f().b().getName(), this.c.f().b().getAuthorId(), "group_info")));
                    }
                } else if (this.c.l()) {
                    showToast(com.baidu.tieba.x.has_recent_join);
                } else if (this.c.f() != null) {
                    if (this.c.f().f() <= 0) {
                        showToast(com.baidu.tieba.x.add_group_max);
                    } else if (com.baidu.tbadk.core.atomData.c.a == this.c.a()) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2008014, new com.baidu.tbadk.core.atomData.c(this, new StringBuilder().append(this.c.d()).toString(), this.c.f().e(), this.c.f().f())));
                    } else if (com.baidu.tbadk.core.atomData.c.b == this.c.a()) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2008014, new com.baidu.tbadk.core.atomData.c(this, new StringBuilder().append(this.c.d()).toString(), this.c.f().e(), this.c.f().f(), this.c.b(), this.c.c())));
                    }
                }
            }
        } else if (view == this.b.e()) {
            if (this.c.f() != null && this.c.f().b() != null) {
                GroupCardActivity.a(this, this.c.d(), this.c.f().b().getName(), this.c.f().b().getPortrait());
            }
        } else if (view == this.b.j()) {
            if (this.c.f() != null && this.c.f().b() != null) {
                GroupSettingActivity.a(this, 4, this.c.f().b().getName(), new StringBuilder().append(this.c.d()).toString(), this.c.f().h(), this.c.f().b().getFlag());
            }
        } else if (view == this.b.h()) {
            if (this.c.f() != null && this.c.f().b() != null) {
                UpdateGroupActivity.a(this, 1, (int) this.c.d(), 1, this.c.f().b().getName());
            }
        } else if (view == this.b.g()) {
            if (this.c.f().h() && this.c.f() != null && this.c.f().b() != null) {
                UpdateGroupActivity.a(this, 2, (int) this.c.d(), 2, this.c.f().b().getIntro());
            }
        } else if (view == this.b.n() || view == this.b.d()) {
            MembersActivity.a(this, this.c.d());
        } else if (view == this.b.f()) {
            InviteFriendListActivity.a(this, 0, (int) this.c.d());
        } else if (view == this.b.i() && this.c.f() != null && this.c.f().g()) {
            GroupActivityData a = this.c.f().a();
            if (a != null) {
                GroupActivityActivity.a(this, a.getActivityId(), this.c.d(), 0);
            } else {
                CreateGroupActivityActivity.a(this, (int) this.c.d());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void closeActivity() {
        setResult(-1);
        finish();
    }

    @Override // com.baidu.tieba.im.groupInfo.ae
    public void a(View view, Object obj, int i) {
        this.b.a(obj, i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        if (view == this.b.b()) {
            if (this.c.f() == null || this.c.f().b() == null) {
                return false;
            }
            this.b.e(String.valueOf(this.c.f().b().getGroupId()));
            return false;
        } else if (view != this.b.g() || this.c.f().h()) {
            return false;
        } else {
            if (this.c.f() != null && this.c.f().b() != null) {
                this.b.d(String.valueOf(this.c.f().b().getIntro()));
            }
            return true;
        }
    }

    @Override // com.baidu.tieba.im.groupInfo.ad
    public void onClick(View view, int i, Object obj, int i2) {
        if (i == 2) {
            this.b.t();
        } else if (i == 1) {
            ArrayList<String> g = this.c.g();
            if (obj != null && (obj instanceof PhotoUrlData) && g != null) {
                GroupImageActivity.a(this, ((PhotoUrlData) obj).getBigurl(), g, this.c.d());
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
                        if (this.b != null) {
                            this.b.a(stringExtra);
                        }
                        if (this.c != null && this.c.f() != null && this.c.f().b() != null) {
                            this.c.f().b().setName(stringExtra);
                            return;
                        }
                        return;
                    }
                    return;
                case 2:
                    if (intent != null) {
                        String stringExtra2 = intent.getStringExtra("group_text");
                        if (this.b != null) {
                            this.b.b(stringExtra2);
                        }
                        if (this.c != null && this.c.f() != null && this.c.f().b() != null) {
                            this.c.f().b().setIntro(stringExtra2);
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
                        if (this.c != null && this.c.f() != null && this.c.f().b() != null) {
                            this.c.f().b().setFlag(intExtra);
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
                        ar.a().b(photoUrlData.getSmallurl(), com.baidu.tbadk.core.util.s.c(TbConfig.GROUP_HEAD_FILE), true, false, true);
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
                ax.a(this);
            } else if (i == 12009) {
                ax.b(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(PhotoUrlData photoUrlData) {
        this.a = 2;
        if (photoUrlData != null) {
            a(this.c.b(photoUrlData));
        }
    }

    private void b(PhotoUrlData photoUrlData) {
        this.a = 1;
        if (photoUrlData != null) {
            String c = this.c.c(photoUrlData);
            if (!TextUtils.isEmpty(c)) {
                a(c);
            }
        }
    }

    private void a(int i, String str, String str2) {
        this.a = 4;
        if (this.d != null) {
            this.d.a(this.c.d());
            this.d.b(i);
            this.d.d(str);
            this.d.e(str2);
            this.d.c(5);
            this.b.q();
        }
    }

    private void a(String str) {
        if (this.d != null) {
            this.d.a(this.c.d());
            this.d.f(str);
            this.d.c(3);
            this.b.q();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Object obj) {
        com.baidu.tieba.im.groupCard.b.a();
        this.a = 3;
        if (obj != null && (obj instanceof PhotoUrlData)) {
            PhotoUrlData photoUrlData = (PhotoUrlData) obj;
            this.c.a(photoUrlData);
            String picId = photoUrlData.getPicId();
            if (this.d != null) {
                this.d.a(this.c.d());
                this.d.c(picId);
                this.d.c(4);
                this.b.q();
            }
        }
    }

    public void a(GroupNewsPojo groupNewsPojo) {
        if (groupNewsPojo != null && this.c != null && this.c.f() != null) {
            try {
                JSONObject jSONObject = new JSONObject(groupNewsPojo.getContent());
                String string = jSONObject.getJSONObject("eventParam").getString("groupId");
                if (jSONObject.getString("eventId").equals("003") && string.equals(String.valueOf(this.c.d())) && this.c.f().g()) {
                    this.c.f().a(false);
                    GroupData b = this.c.f().b();
                    if (b != null && b.getMemberNum() > 1) {
                        b.setMemberNum(b.getMemberNum() - 1);
                    }
                    this.b.a(this.c.f(), true);
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
            if (!TextUtils.isEmpty(optString) && this.c != null && optString.equals(String.valueOf(this.c.d())) && this.c.f() != null) {
                this.c.f().a(true);
                if (this.b != null) {
                    this.b.s();
                    g();
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(GroupNewsPojo groupNewsPojo) {
        if (groupNewsPojo != null && this.c != null && this.c.f() != null) {
            try {
                JSONObject jSONObject = new JSONObject(groupNewsPojo.getContent());
                JSONObject jSONObject2 = jSONObject.getJSONObject("eventParam");
                String string = jSONObject2.getString("groupId");
                if (jSONObject.getString("eventId").equals("101") && string.equals(String.valueOf(this.c.d()))) {
                    String string2 = jSONObject2.getString("groupName");
                    if (!TextUtils.isEmpty(string2)) {
                        this.b.a(string2);
                        if (this.c.f() != null && this.c.f().b() != null) {
                            this.c.f().b().setName(string2);
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
        if (groupNewsPojo != null && this.c != null) {
            try {
                JSONObject jSONObject = new JSONObject(groupNewsPojo.getContent());
                String string = jSONObject.getJSONObject("eventParam").getString("groupId");
                if (jSONObject.getString("eventId").equals("107") && string.equals(String.valueOf(this.c.d()))) {
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
    public void g() {
        if (this.c != null) {
            this.c.b(String.valueOf(this.c.d()));
        }
    }
}
