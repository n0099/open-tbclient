package com.baidu.tieba.im.groupInfo;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import com.baidu.sapi2.shell.SapiErrorCode;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.account.LoginActivity;
import com.baidu.tieba.im.chat.GroupSettingActivity;
import com.baidu.tieba.im.creategroup.GroupAddressLocateActivity;
import com.baidu.tieba.im.data.GroupActivityData;
import com.baidu.tieba.im.data.GroupData;
import com.baidu.tieba.im.data.PhotoUrlData;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.im.friend.InviteFriendListActivity;
import com.baidu.tieba.im.frsgroup.GroupLevelActivity;
import com.baidu.tieba.im.frsgroup.MembersActivity;
import com.baidu.tieba.im.groupActivity.CreateGroupActivityActivity;
import com.baidu.tieba.im.groupActivity.GroupActivityActivity;
import com.baidu.tieba.im.groupCard.GroupCardActivity;
import com.baidu.tieba.im.model.ao;
import com.baidu.tieba.im.updategroup.UpdateGroupActivity;
import com.baidu.tieba.person.EditHeadActivity;
import com.baidu.tieba.person.cm;
import com.baidu.tieba.util.bm;
import com.baidu.tieba.write.bz;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class GroupInfoActivity extends com.baidu.tieba.f implements View.OnClickListener, View.OnLongClickListener, aa, z, com.baidu.tieba.im.messageCenter.g {
    private m f;
    private com.baidu.tieba.im.model.e g;
    private ao h;
    private k i;
    private final int a = 1;
    private final int b = 2;
    private final int c = 3;
    private final int d = 4;
    private int e = 0;
    private final DialogInterface.OnClickListener j = new i(this);
    private final y k = new j(this);

    public static void a(Context context, long j, int i) {
        Intent intent = new Intent(context, GroupInfoActivity.class);
        intent.putExtra("group_id", j);
        intent.putExtra("activity_from", i);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
    }

    public static void a(Context context, long j, int i, String str, long j2) {
        Intent intent = new Intent(context, GroupInfoActivity.class);
        intent.putExtra("group_id", j);
        intent.putExtra("activity_from", i);
        intent.putExtra("default_invite_msg", str);
        intent.putExtra("inviter_user_id", j2);
        intent.putExtra("join_type", ApplyJoinGroupActivity.q);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a();
        a(bundle, (Intent) null);
        b();
        c();
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        a((Bundle) null, intent);
        b();
        c();
    }

    private void a() {
        this.i = new k(this, null);
        com.baidu.tieba.im.messageCenter.e.a().a(103004, this.i);
        com.baidu.tieba.im.messageCenter.e.a().a(SapiErrorCode.NOT_INIT, this.i);
        com.baidu.tieba.im.messageCenter.e.a().a(103102, this.i);
        com.baidu.tieba.im.messageCenter.e.a().a(103112, this.i);
        com.baidu.tieba.im.messageCenter.e.a().a(103110, this.i);
        com.baidu.tieba.im.messageCenter.e.a().a(103120, this.i);
        com.baidu.tieba.im.messageCenter.e.a().a(103121, this.i);
        com.baidu.tieba.im.messageCenter.e.a().a(-132, this);
        com.baidu.tieba.im.messageCenter.e.a().a(-130, this);
        com.baidu.tieba.im.messageCenter.e.a().a(-134, this);
        com.baidu.tieba.im.messageCenter.e.a().a(103104, this.i);
        com.baidu.tieba.im.messageCenter.e.a().a(-141, this);
        com.baidu.tieba.im.messageCenter.e.a().a(-139, this);
        com.baidu.tieba.im.messageCenter.e.a().a(103105, this.i);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.g.b(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f, android.app.Activity
    public void onStop() {
        super.onStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f, com.baidu.adp.a.a, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.g.f();
        com.baidu.tieba.im.messageCenter.e.a().a(this.i);
        com.baidu.tieba.im.messageCenter.e.a().a(this);
        if (this.f != null) {
            this.f.x();
        }
    }

    private void b() {
        this.f = new m(this);
        this.f.a(this.j);
        this.f.a(this.k);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        this.f.s();
        this.g.b(this.g.d(), this.g.e());
    }

    public void a(Bundle bundle, Intent intent) {
        this.g = new com.baidu.tieba.im.model.e();
        if (bundle == null) {
            com.baidu.tieba.im.model.e eVar = this.g;
            if (intent == null) {
                intent = getIntent();
            }
            eVar.a(intent);
        } else {
            this.g.a(bundle);
        }
        this.h = new ao();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f
    public void onChangeSkinType(int i) {
        if (this.f != null) {
            this.f.a(i);
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: long : 0x01b7: INVOKE  (r1v25 long A[REMOVE]) = 
      (wrap: com.baidu.tieba.im.model.e : 0x01b5: IGET  (r1v24 com.baidu.tieba.im.model.e A[REMOVE]) = (r7v0 'this' com.baidu.tieba.im.groupInfo.GroupInfoActivity A[IMMUTABLE_TYPE, THIS]) com.baidu.tieba.im.groupInfo.GroupInfoActivity.g com.baidu.tieba.im.model.e)
     type: VIRTUAL call: com.baidu.tieba.im.model.e.d():long)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: long : 0x01ed: INVOKE  (r1v22 long A[REMOVE]) = 
      (wrap: com.baidu.tieba.im.model.e : 0x01eb: IGET  (r1v21 com.baidu.tieba.im.model.e A[REMOVE]) = (r7v0 'this' com.baidu.tieba.im.groupInfo.GroupInfoActivity A[IMMUTABLE_TYPE, THIS]) com.baidu.tieba.im.groupInfo.GroupInfoActivity.g com.baidu.tieba.im.model.e)
     type: VIRTUAL call: com.baidu.tieba.im.model.e.d():long)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: long : 0x0294: INVOKE  (r3v2 long A[REMOVE]) = 
      (wrap: com.baidu.tieba.im.model.e : 0x0292: IGET  (r3v1 com.baidu.tieba.im.model.e A[REMOVE]) = (r7v0 'this' com.baidu.tieba.im.groupInfo.GroupInfoActivity A[IMMUTABLE_TYPE, THIS]) com.baidu.tieba.im.groupInfo.GroupInfoActivity.g com.baidu.tieba.im.model.e)
     type: VIRTUAL call: com.baidu.tieba.im.model.e.d():long)] */
    @Override // com.baidu.adp.a.a, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f.t()) {
            if (this.g.g().h()) {
                com.baidu.tieba.ai.a(this, "edit_place_at_groupinfo");
                GroupAddressLocateActivity.a(this, 21001, this.g.g().b().getPosition(), this.g.g().b().getBusiness(), (this.g.g().b().getFlag() & 1) == 1);
            }
        } else if (view == this.f.q()) {
            closeActivity();
        } else if (view == this.f.e()) {
            if (this.g.g() != null && this.g.g().b() != null) {
                sendMessage(new com.baidu.adp.framework.message.a(2001001, new com.baidu.tieba.a.a(this, String.valueOf(this.g.g().b().getForumId()), this.g.g().i() ? false : true)));
            }
        } else if (view == this.f.n()) {
            if (this.g.g() != null && this.g.g().b() != null) {
                cm.a(this, String.valueOf(this.g.g().b().getAuthorId()), this.g.g().b().getAuthorName());
            }
        } else if (view == this.f.o()) {
            GroupLevelActivity.a(this, this.g.d());
        } else if (view == this.f.m()) {
            com.baidu.adp.lib.util.f.e("botton click");
            if (TextUtils.isEmpty(TiebaApplication.A())) {
                LoginActivity.a((Activity) this, "", true, 3);
            } else if (this.g.g() != null) {
                if (this.g.g().g()) {
                    if (this.g.g().b() != null) {
                        com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2001003, new com.baidu.tieba.a.b(this, (int) this.g.d(), this.g.g().b().getName(), this.g.g().b().getAuthorId(), "group_info")));
                    }
                } else if (this.g.n()) {
                    showToast(R.string.has_recent_join);
                } else if (this.g.g() != null) {
                    if (this.g.g().f() <= 0) {
                        showToast(R.string.add_group_max);
                    } else if (ApplyJoinGroupActivity.p == this.g.a()) {
                        ApplyJoinGroupActivity.a(this, new StringBuilder().append(this.g.d()).toString(), this.g.g().e(), this.g.g().f());
                    } else if (ApplyJoinGroupActivity.q == this.g.a()) {
                        ApplyJoinGroupActivity.a(this, new StringBuilder().append(this.g.d()).toString(), this.g.g().e(), this.g.g().f(), this.g.b(), this.g.c());
                    }
                }
            }
        } else if (view == this.f.g()) {
            if (this.g.g() != null && this.g.g().b() != null) {
                GroupCardActivity.a(this, this.g.d(), this.g.g().b().getName(), this.g.g().b().getPortrait());
            }
        } else if (view == this.f.l()) {
            if (this.g.g() != null && this.g.g().b() != null) {
                GroupSettingActivity.a(this, 4, this.g.g().b().getName(), new StringBuilder().append(this.g.d()).toString(), this.g.g().h(), this.g.g().b().getFlag());
            }
        } else if (view == this.f.j()) {
            if (this.g.g() != null && this.g.g().b() != null) {
                UpdateGroupActivity.a(this, 1, (int) this.g.d(), 1, this.g.g().b().getName());
            }
        } else if (view == this.f.i()) {
            if (this.g.g().h() && this.g.g() != null && this.g.g().b() != null) {
                UpdateGroupActivity.a(this, 2, (int) this.g.d(), 2, this.g.g().b().getIntro());
            }
        } else if (view == this.f.p() || view == this.f.f()) {
            MembersActivity.a(this, this.g.d());
        } else if (view == this.f.h()) {
            InviteFriendListActivity.a(this, 0, (int) this.g.d());
        } else if (view == this.f.k() && this.g.g() != null) {
            GroupActivityData a = this.g.g().a();
            if (a != null) {
                GroupActivityActivity.a(this, a.getActivityId(), this.g.d(), 0);
            } else {
                CreateGroupActivityActivity.a(this, (int) this.g.d());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f
    public void closeActivity() {
        setResult(-1);
        finish();
    }

    @Override // com.baidu.tieba.im.groupInfo.aa
    public void a(View view, Object obj, int i) {
        this.f.a(obj, i);
    }

    @Override // com.baidu.adp.a.a, android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        if (view == this.f.a()) {
            if (this.g.g() == null || this.g.g().b() == null) {
                return false;
            }
            this.f.e(String.valueOf(this.g.g().b().getGroupId()));
            return false;
        } else if (view != this.f.i() || this.g.g().h()) {
            return false;
        } else {
            if (this.g.g() != null && this.g.g().b() != null) {
                this.f.d(String.valueOf(this.g.g().b().getIntro()));
            }
            return true;
        }
    }

    @Override // com.baidu.tieba.im.groupInfo.z
    public void onClick(View view, int i, Object obj, int i2) {
        if (i == 2) {
            this.f.v();
        } else if (i == 1) {
            ArrayList<String> h = this.g.h();
            if (obj != null && (obj instanceof PhotoUrlData) && h != null) {
                GroupImageActivity.a(this, ((PhotoUrlData) obj).getBigurl(), h, this.g.d());
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
                        if (this.g != null && this.g.g() != null && this.g.g().b() != null) {
                            this.g.g().b().setName(stringExtra);
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
                        if (this.g != null && this.g.g() != null && this.g.g().b() != null) {
                            this.g.g().b().setIntro(stringExtra2);
                            return;
                        }
                        return;
                    }
                    return;
                case 3:
                    c();
                    return;
                case 4:
                    if (intent != null) {
                        int intExtra = intent.getIntExtra("intent_data_group_flag", 0);
                        if (this.g != null && this.g.g() != null && this.g.g().b() != null) {
                            this.g.g().b().setFlag(intExtra);
                            return;
                        }
                        return;
                    }
                    return;
                case 12001:
                    EditHeadActivity.a(this, 12001, 12010, null, TiebaApplication.E(), 2);
                    return;
                case 12002:
                    if (intent != null) {
                        EditHeadActivity.a(this, 12002, 12009, intent.getData(), TiebaApplication.E(), 2);
                        return;
                    }
                    return;
                case 12009:
                case 12010:
                    PhotoUrlData photoUrlData = (PhotoUrlData) intent.getSerializableExtra(EditHeadActivity.b);
                    if (photoUrlData != null) {
                        bm.a().b(photoUrlData.getSmallurl(), com.baidu.tieba.util.af.c("tieba_group_image"), true, false, true);
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
                bz.a(this);
            } else if (i == 12009) {
                bz.b(this);
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
            this.f.s();
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
                this.f.s();
            }
        }
    }

    public void a(GroupNewsPojo groupNewsPojo) {
        if (groupNewsPojo != null && this.g != null && this.g.g() != null) {
            try {
                JSONObject jSONObject = new JSONObject(groupNewsPojo.getContent());
                String string = jSONObject.getJSONObject("eventParam").getString("groupId");
                if (jSONObject.getString("eventId").equals("003") && string.equals(String.valueOf(this.g.d())) && this.g.g().g()) {
                    this.g.g().a(false);
                    GroupData b = this.g.g().b();
                    if (b != null && b.getMemberNum() > 1) {
                        b.setMemberNum(b.getMemberNum() - 1);
                    }
                    this.f.a(this.g.g(), true);
                    e();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void b(GroupNewsPojo groupNewsPojo) {
        try {
            String optString = new JSONObject(groupNewsPojo.getContent()).optJSONObject("eventParam").optString("groupId");
            if (!TextUtils.isEmpty(optString) && this.g != null && optString.equals(String.valueOf(this.g.d())) && this.g.g() != null) {
                this.g.g().a(true);
                if (this.f != null) {
                    this.f.u();
                    e();
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void c(GroupNewsPojo groupNewsPojo) {
        if (groupNewsPojo != null && this.g != null && this.g.g() != null) {
            try {
                JSONObject jSONObject = new JSONObject(groupNewsPojo.getContent());
                JSONObject jSONObject2 = jSONObject.getJSONObject("eventParam");
                String string = jSONObject2.getString("groupId");
                if (jSONObject.getString("eventId").equals("101") && string.equals(String.valueOf(this.g.d()))) {
                    String string2 = jSONObject2.getString("groupName");
                    if (!TextUtils.isEmpty(string2)) {
                        this.f.a(string2);
                        if (this.g.g() != null && this.g.g().b() != null) {
                            this.g.g().b().setName(string2);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void d(GroupNewsPojo groupNewsPojo) {
        if (groupNewsPojo != null && this.g != null) {
            try {
                JSONObject jSONObject = new JSONObject(groupNewsPojo.getContent());
                String string = jSONObject.getJSONObject("eventParam").getString("groupId");
                if (jSONObject.getString("eventId").equals("107") && string.equals(String.valueOf(this.g.d()))) {
                    finish();
                    com.baidu.adp.lib.util.f.e("dismiss suc");
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.f, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            closeActivity();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.g != null) {
            this.g.b(String.valueOf(this.g.d()));
        }
    }

    @Override // com.baidu.tieba.im.messageCenter.g
    public void a(com.baidu.tieba.im.message.s sVar) {
        GroupNewsPojo a;
        if (sVar != null && (sVar instanceof com.baidu.tieba.im.message.aa) && (a = ((com.baidu.tieba.im.message.aa) sVar).a()) != null) {
            String cmd = a.getCmd();
            if (!TextUtils.isEmpty(cmd)) {
                if (cmd.equals("apply_join_success")) {
                    b(a);
                } else if (cmd.equals("kick_out")) {
                    a(a);
                } else if (cmd.equals("group_name_change")) {
                    c(a);
                } else if (cmd.equals("dismiss_group")) {
                    d(a);
                } else if (cmd.equals("group_activitys_change")) {
                    c();
                }
            }
        }
    }
}
