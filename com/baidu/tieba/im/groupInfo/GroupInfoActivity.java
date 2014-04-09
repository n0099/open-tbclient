package com.baidu.tieba.im.groupInfo;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.GroupData;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.az;
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
import com.baidu.tieba.im.model.bs;
import com.baidu.tieba.im.updategroup.UpdateGroupActivity;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class GroupInfoActivity extends com.baidu.tbadk.a implements View.OnClickListener, View.OnLongClickListener, ae, af {
    private r f;
    private com.baidu.tieba.im.model.l g;
    private bs h;
    private p i;
    private final int a = 1;
    private final int b = 2;
    private final int c = 3;
    private final int d = 4;
    private int e = 0;
    private final DialogInterface.OnClickListener j = new j(this);
    private final ad k = new k(this);
    private final com.baidu.adp.framework.c.a l = new l(this, 0);
    private final com.baidu.adp.framework.c.a m = new m(this, 0);

    static {
        CustomMessageTask customMessageTask = new CustomMessageTask(2008011, new n());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        com.baidu.adp.framework.c.a().a(customMessageTask);
        bg.a().a(new o());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.i = new p(this);
        com.baidu.adp.framework.c.a().a(103004, this.i);
        com.baidu.adp.framework.c.a().a(2001102, this.l);
        com.baidu.adp.framework.c.a().a(103102, this.i);
        com.baidu.adp.framework.c.a().a(103112, this.i);
        com.baidu.adp.framework.c.a().a(103110, this.i);
        com.baidu.adp.framework.c.a().a(103120, this.i);
        com.baidu.adp.framework.c.a().a(103121, this.i);
        com.baidu.adp.framework.c.a().a(2001132, this.m);
        com.baidu.adp.framework.c.a().a(2001130, this.m);
        com.baidu.adp.framework.c.a().a(2001134, this.m);
        com.baidu.adp.framework.c.a().a(103104, this.i);
        com.baidu.adp.framework.c.a().a(2001141, this.m);
        com.baidu.adp.framework.c.a().a(2001139, this.m);
        com.baidu.adp.framework.c.a().a(103105, this.i);
        a(bundle, (Intent) null);
        a();
        b();
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        a((Bundle) null, intent);
        a();
        b();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.g.b(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a, android.app.Activity
    public void onStop() {
        super.onStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a, com.baidu.adp.a.a, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.g.cancelMessage();
        com.baidu.adp.framework.c.a().b(this.m);
        if (this.f != null) {
            this.f.x();
        }
    }

    private void a() {
        this.f = new r(this);
        this.f.a(this.j);
        this.f.a(this.k);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.f != null) {
            this.f.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        this.f.s();
        this.g.b(this.g.d(), this.g.e());
    }

    private void a(Bundle bundle, Intent intent) {
        this.g = new com.baidu.tieba.im.model.l();
        this.g.setUniqueId(getUniqueId());
        if (bundle == null) {
            com.baidu.tieba.im.model.l lVar = this.g;
            if (intent == null) {
                intent = getIntent();
            }
            lVar.a(intent);
        } else {
            this.g.a(bundle);
        }
        this.h = new bs();
        this.h.setUniqueId(getUniqueId());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void c(GroupInfoActivity groupInfoActivity) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a, android.app.Activity
    public void onResume() {
        super.onResume();
        onChangeSkinType(TbadkApplication.j().l());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a
    public void onChangeSkinType(int i) {
        if (this.f != null) {
            this.f.a(i);
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: long : 0x01c8: INVOKE  (r2v35 long A[REMOVE]) = 
      (wrap: com.baidu.tieba.im.model.l : 0x01c6: IGET  (r2v34 com.baidu.tieba.im.model.l A[REMOVE]) = (r9v0 'this' com.baidu.tieba.im.groupInfo.GroupInfoActivity A[IMMUTABLE_TYPE, THIS]) com.baidu.tieba.im.groupInfo.GroupInfoActivity.g com.baidu.tieba.im.model.l)
     type: VIRTUAL call: com.baidu.tieba.im.model.l.d():long)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: long : 0x020c: INVOKE  (r2v31 long A[REMOVE]) = 
      (wrap: com.baidu.tieba.im.model.l : 0x020a: IGET  (r2v30 com.baidu.tieba.im.model.l A[REMOVE]) = (r9v0 'this' com.baidu.tieba.im.groupInfo.GroupInfoActivity A[IMMUTABLE_TYPE, THIS]) com.baidu.tieba.im.groupInfo.GroupInfoActivity.g com.baidu.tieba.im.model.l)
     type: VIRTUAL call: com.baidu.tieba.im.model.l.d():long)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: long : 0x02bf: INVOKE  (r3v2 long A[REMOVE]) = 
      (wrap: com.baidu.tieba.im.model.l : 0x02bd: IGET  (r3v1 com.baidu.tieba.im.model.l A[REMOVE]) = (r9v0 'this' com.baidu.tieba.im.groupInfo.GroupInfoActivity A[IMMUTABLE_TYPE, THIS]) com.baidu.tieba.im.groupInfo.GroupInfoActivity.g com.baidu.tieba.im.model.l)
     type: VIRTUAL call: com.baidu.tieba.im.model.l.d():long)] */
    @Override // com.baidu.adp.a.a, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f.t()) {
            if (this.g.f().h()) {
                com.baidu.tbadk.core.g.a(this, "edit_place_at_groupinfo");
                GroupAddressLocateActivity.a(this, 21001, this.g.f().b().getPosition(), this.g.f().b().getBusiness(), (this.g.f().b().getFlag() & 1) == 1);
            }
        } else if (view == this.f.q()) {
            closeActivity();
        } else if (view == this.f.e()) {
            if (this.g.f() != null && this.g.f().b() != null) {
                sendMessage(new com.baidu.adp.framework.message.a(2001001, new com.baidu.tbadk.core.b.m(this, String.valueOf(this.g.f().b().getForumId()), this.g.f().i() ? false : true)));
            }
        } else if (view == this.f.n()) {
            if (this.g.f() != null && this.g.f().b() != null) {
                com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2001003, new com.baidu.tbadk.core.b.ag(this, String.valueOf(this.g.f().b().getAuthorId()), this.g.f().b().getAuthorName())));
            }
        } else if (view == this.f.o()) {
            GroupLevelActivity.a(this, this.g.d());
        } else if (view == this.f.m()) {
            com.baidu.adp.lib.util.f.e("botton click");
            if (TextUtils.isEmpty(TbadkApplication.E())) {
                LoginActivity.a((Activity) this, "", true, 3);
            } else if (this.g.f() != null) {
                if (this.g.f().g()) {
                    if (this.g.f().b() != null) {
                        com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2001001, new com.baidu.tbadk.core.b.n(this, (int) this.g.d(), this.g.f().b().getName(), this.g.f().b().getAuthorId(), "group_info")));
                    }
                } else if (this.g.l()) {
                    showToast(com.baidu.tieba.im.j.has_recent_join);
                } else if (this.g.f() != null) {
                    if (this.g.f().f() <= 0) {
                        showToast(com.baidu.tieba.im.j.add_group_max);
                    } else if (com.baidu.tbadk.core.b.b.a == this.g.a()) {
                        com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2008014, new com.baidu.tbadk.core.b.b(this, new StringBuilder().append(this.g.d()).toString(), this.g.f().e(), this.g.f().f())));
                    } else if (com.baidu.tbadk.core.b.b.b == this.g.a()) {
                        com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2008014, new com.baidu.tbadk.core.b.b(this, new StringBuilder().append(this.g.d()).toString(), this.g.f().e(), this.g.f().f(), this.g.b(), this.g.c())));
                    }
                }
            }
        } else if (view == this.f.g()) {
            if (this.g.f() != null && this.g.f().b() != null) {
                GroupCardActivity.a(this, this.g.d(), this.g.f().b().getName(), this.g.f().b().getPortrait());
            }
        } else if (view == this.f.l()) {
            if (this.g.f() != null && this.g.f().b() != null) {
                GroupSettingActivity.a(this, 4, this.g.f().b().getName(), new StringBuilder().append(this.g.d()).toString(), this.g.f().h(), this.g.f().b().getFlag());
            }
        } else if (view == this.f.j()) {
            if (this.g.f() != null && this.g.f().b() != null) {
                UpdateGroupActivity.a(this, 1, (int) this.g.d(), 1, this.g.f().b().getName());
            }
        } else if (view == this.f.i()) {
            if (this.g.f().h() && this.g.f() != null && this.g.f().b() != null) {
                UpdateGroupActivity.a(this, 2, (int) this.g.d(), 2, this.g.f().b().getIntro());
            }
        } else if (view == this.f.p() || view == this.f.f()) {
            MembersActivity.a(this, this.g.d());
        } else if (view == this.f.h()) {
            InviteFriendListActivity.a(this, 0, (int) this.g.d());
        } else if (view == this.f.k() && this.g.f() != null && this.g.f().g()) {
            GroupActivityData a = this.g.f().a();
            if (a != null) {
                GroupActivityActivity.a(this, a.getActivityId(), this.g.d(), 0);
            } else {
                CreateGroupActivityActivity.a(this, (int) this.g.d());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a
    public void closeActivity() {
        setResult(-1);
        finish();
    }

    @Override // com.baidu.tieba.im.groupInfo.af
    public final void a(Object obj, int i) {
        this.f.a(obj, i);
    }

    @Override // com.baidu.adp.a.a, android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        if (view == this.f.d()) {
            if (this.g.f() == null || this.g.f().b() == null) {
                return false;
            }
            this.f.e(String.valueOf(this.g.f().b().getGroupId()));
            return false;
        } else if (view != this.f.i() || this.g.f().h()) {
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
            this.f.v();
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
                    b();
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
                    EditHeadActivity.a(this, 12001, 12010, null, TbadkApplication.N(), 2);
                    return;
                case 12002:
                    if (intent != null) {
                        EditHeadActivity.a(this, 12002, 12009, intent.getData(), TbadkApplication.N(), 2);
                        return;
                    }
                    return;
                case 12009:
                case 12010:
                    PhotoUrlData photoUrlData = (PhotoUrlData) intent.getSerializableExtra(EditHeadActivity.b);
                    if (photoUrlData != null) {
                        av a = av.a();
                        photoUrlData.getSmallurl();
                        String c = com.baidu.tbadk.core.util.w.c("tieba_group_image");
                        new aw(a, c, c, true, true, true).execute(new String[0]);
                    }
                    this.e = 1;
                    if (photoUrlData != null) {
                        String c2 = this.g.c(photoUrlData);
                        if (!TextUtils.isEmpty(c2)) {
                            a(c2);
                            return;
                        }
                        return;
                    }
                    return;
                case 21001:
                    int i3 = intent.getBooleanExtra("ResultDataIsHiddenAddress", true) ? 1 : 0;
                    String stringExtra3 = intent.getStringExtra("ResultDataSelectedBusiness");
                    String stringExtra4 = intent.getStringExtra("ResultDataAddress");
                    this.e = 4;
                    if (this.h != null) {
                        this.h.a(this.g.d());
                        this.h.b(i3);
                        this.h.d(stringExtra4);
                        this.h.e(stringExtra3);
                        this.h.c(5);
                        this.f.s();
                        return;
                    }
                    return;
                default:
                    return;
            }
        } else if (i2 == 0) {
            if (i == 12010) {
                az.a(this);
            } else if (i == 12009) {
                az.b(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(GroupInfoActivity groupInfoActivity, PhotoUrlData photoUrlData) {
        groupInfoActivity.e = 2;
        if (photoUrlData != null) {
            groupInfoActivity.a(groupInfoActivity.g.b(photoUrlData));
        }
    }

    private void a(String str) {
        if (this.h != null) {
            this.h.a(this.g.d());
            this.h.f(str);
            this.h.c(3);
            this.f.s();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(GroupInfoActivity groupInfoActivity, Object obj) {
        com.baidu.tieba.im.groupCard.b.a();
        groupInfoActivity.e = 3;
        if (obj == null || !(obj instanceof PhotoUrlData)) {
            return;
        }
        PhotoUrlData photoUrlData = (PhotoUrlData) obj;
        groupInfoActivity.g.a(photoUrlData);
        String picId = photoUrlData.getPicId();
        if (groupInfoActivity.h != null) {
            groupInfoActivity.h.a(groupInfoActivity.g.d());
            groupInfoActivity.h.c(picId);
            groupInfoActivity.h.c(4);
            groupInfoActivity.f.s();
        }
    }

    public final void a(GroupNewsPojo groupNewsPojo) {
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
                    c();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public final void b(GroupNewsPojo groupNewsPojo) {
        try {
            String optString = new JSONObject(groupNewsPojo.getContent()).optJSONObject("eventParam").optString("groupId");
            if (!TextUtils.isEmpty(optString) && this.g != null && optString.equals(String.valueOf(this.g.d())) && this.g.f() != null) {
                this.g.f().a(true);
                if (this.f != null) {
                    this.f.u();
                    c();
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(GroupInfoActivity groupInfoActivity, GroupNewsPojo groupNewsPojo) {
        if (groupNewsPojo == null || groupInfoActivity.g == null || groupInfoActivity.g.f() == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(groupNewsPojo.getContent());
            JSONObject jSONObject2 = jSONObject.getJSONObject("eventParam");
            String string = jSONObject2.getString("groupId");
            if (jSONObject.getString("eventId").equals("101") && string.equals(String.valueOf(groupInfoActivity.g.d()))) {
                String string2 = jSONObject2.getString("groupName");
                if (TextUtils.isEmpty(string2)) {
                    return;
                }
                groupInfoActivity.f.a(string2);
                if (groupInfoActivity.g.f() == null || groupInfoActivity.g.f().b() == null) {
                    return;
                }
                groupInfoActivity.g.f().b().setName(string2);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void b(GroupInfoActivity groupInfoActivity, GroupNewsPojo groupNewsPojo) {
        if (groupNewsPojo == null || groupInfoActivity.g == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(groupNewsPojo.getContent());
            String string = jSONObject.getJSONObject("eventParam").getString("groupId");
            if (jSONObject.getString("eventId").equals("107") && string.equals(String.valueOf(groupInfoActivity.g.d()))) {
                groupInfoActivity.finish();
                com.baidu.adp.lib.util.f.e("dismiss suc");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override // com.baidu.tbadk.a, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            closeActivity();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (this.g != null) {
            this.g.b(String.valueOf(this.g.d()));
        }
    }
}
