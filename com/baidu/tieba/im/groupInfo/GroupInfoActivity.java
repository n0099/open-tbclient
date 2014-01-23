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
import com.baidu.tieba.im.chat.GroupChatActivity;
import com.baidu.tieba.im.chat.GroupSettingActivity;
import com.baidu.tieba.im.creategroup.GroupAddressLocateActivity;
import com.baidu.tieba.im.data.GroupData;
import com.baidu.tieba.im.data.PhotoUrlData;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.im.friend.InviteFriendListActivity;
import com.baidu.tieba.im.frsgroup.FrsGroupActivity;
import com.baidu.tieba.im.frsgroup.GroupLevelActivity;
import com.baidu.tieba.im.frsgroup.MembersActivity;
import com.baidu.tieba.im.groupCard.GroupCardActivity;
import com.baidu.tieba.im.model.ao;
import com.baidu.tieba.im.updategroup.UpdateGroupActivity;
import com.baidu.tieba.person.EditHeadActivity;
import com.baidu.tieba.person.PersonInfoActivity;
import com.baidu.tieba.util.bo;
import com.baidu.tieba.write.bb;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class GroupInfoActivity extends com.baidu.tieba.j implements View.OnClickListener, View.OnLongClickListener, com.baidu.tieba.im.c.l, y, z {
    private m f;
    private com.baidu.tieba.im.model.e g;
    private ao h;
    private k i;
    private final int a = 1;
    private final int b = 2;
    private final int c = 3;
    private final int d = 4;
    private int e = 0;
    private DialogInterface.OnClickListener j = new i(this);
    private x k = new j(this);

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
    @Override // com.baidu.tieba.j, com.baidu.adp.a.a, android.app.Activity
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
        com.baidu.tieba.im.c.m.a().a("kick_out", this);
        com.baidu.tieba.im.c.m.a().a("apply_join_success", this);
        com.baidu.tieba.im.c.m.a().a("group_name_change", this);
        com.baidu.tieba.im.messageCenter.e.a().a(103104, this.i);
        com.baidu.tieba.im.c.m.a().a("dismiss_group", this);
        com.baidu.tieba.im.messageCenter.e.a().a(103105, this.i);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.g.b(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onStop() {
        super.onStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.g.f();
        com.baidu.tieba.im.c.m.a().a(this);
        com.baidu.tieba.im.messageCenter.e.a().a(this.i);
        com.baidu.tieba.im.c.m.a().a(this);
        if (this.f != null) {
            this.f.w();
        }
    }

    private void b() {
        this.f = new m(this);
        this.f.a(this.j);
        this.f.a(this.k);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        this.f.r();
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
    @Override // com.baidu.tieba.j
    public void onChangeSkinType(int i) {
        if (this.f != null) {
            this.f.a(i);
        }
    }

    @Override // com.baidu.adp.a.a, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f.s()) {
            if (this.g.g().g()) {
                com.baidu.tieba.ao.a(this, "edit_place_at_groupinfo");
                GroupAddressLocateActivity.a(this, 21001, this.g.g().a().getPosition(), this.g.g().a().getBusiness(), (this.g.g().a().getFlag() & 1) == 1);
            }
        } else if (view == this.f.p()) {
            closeActivity();
        } else if (view == this.f.e()) {
            if (this.g.g() != null && this.g.g().a() != null) {
                FrsGroupActivity.a(this, String.valueOf(this.g.g().a().getForumId()), this.g.g().h() ? false : true);
            }
        } else if (view == this.f.m()) {
            if (this.g.g() != null && this.g.g().a() != null) {
                PersonInfoActivity.a(this, String.valueOf(this.g.g().a().getAuthorId()), this.g.g().a().getAuthorName());
            }
        } else if (view == this.f.n()) {
            GroupLevelActivity.a(this, this.g.d());
        } else if (view == this.f.l()) {
            com.baidu.adp.lib.g.e.d("botton click");
            if (TextUtils.isEmpty(TiebaApplication.A())) {
                LoginActivity.a((Activity) this, "", true, 3);
            } else if (this.g.g() != null) {
                if (this.g.g().f()) {
                    if (this.g.g().a() != null) {
                        GroupChatActivity.a(this, (int) this.g.d(), this.g.g().a().getName(), this.g.g().a().getAuthorId(), "group_info");
                    }
                } else if (this.g.n()) {
                    showToast(R.string.has_recent_join);
                } else if (this.g.g() != null) {
                    if (this.g.g().e() <= 0) {
                        showToast(R.string.add_group_max);
                    } else if (ApplyJoinGroupActivity.p == this.g.a()) {
                        ApplyJoinGroupActivity.a(this, "" + this.g.d(), this.g.g().d(), this.g.g().e());
                    } else if (ApplyJoinGroupActivity.q == this.g.a()) {
                        ApplyJoinGroupActivity.a(this, "" + this.g.d(), this.g.g().d(), this.g.g().e(), this.g.b(), this.g.c());
                    }
                }
            }
        } else if (view == this.f.g()) {
            if (this.g.g() != null && this.g.g().a() != null) {
                GroupCardActivity.a(this, this.g.d(), this.g.g().a().getName(), this.g.g().a().getPortrait());
            }
        } else if (view == this.f.k()) {
            if (this.g.g() != null && this.g.g().a() != null) {
                GroupSettingActivity.a(this, 4, this.g.g().a().getName(), "" + this.g.d(), this.g.g().g(), this.g.g().a().getFlag());
            }
        } else if (view == this.f.j()) {
            if (this.g.g() != null && this.g.g().a() != null) {
                UpdateGroupActivity.a(this, 1, (int) this.g.d(), 1, this.g.g().a().getName());
            }
        } else if (view == this.f.i()) {
            if (this.g.g().g() && this.g.g() != null && this.g.g().a() != null) {
                UpdateGroupActivity.a(this, 2, (int) this.g.d(), 2, this.g.g().a().getIntro());
            }
        } else if (view == this.f.o() || view == this.f.f()) {
            MembersActivity.a(this, this.g.d());
        } else if (view == this.f.h()) {
            InviteFriendListActivity.a(this, 0, (int) this.g.d());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j
    public void closeActivity() {
        setResult(-1);
        finish();
    }

    @Override // com.baidu.tieba.im.groupInfo.z
    public void a(View view, Object obj, int i) {
        this.f.a(obj, i);
    }

    @Override // com.baidu.adp.a.a, android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        if (view == this.f.a()) {
            if (this.g.g() == null || this.g.g().a() == null) {
                return false;
            }
            this.f.e(String.valueOf(this.g.g().a().getGroupId()));
            return false;
        } else if (view != this.f.i() || this.g.g().g()) {
            return false;
        } else {
            if (this.g.g() != null && this.g.g().a() != null) {
                this.f.d(String.valueOf(this.g.g().a().getIntro()));
            }
            return true;
        }
    }

    @Override // com.baidu.tieba.im.groupInfo.y
    public void onClick(View view, int i, Object obj, int i2) {
        if (i == 2) {
            this.f.u();
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
                        if (this.g != null && this.g.g() != null && this.g.g().a() != null) {
                            this.g.g().a().setName(stringExtra);
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
                        if (this.g != null && this.g.g() != null && this.g.g().a() != null) {
                            this.g.g().a().setIntro(stringExtra2);
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
                        if (this.g != null && this.g.g() != null && this.g.g().a() != null) {
                            this.g.g().a().setFlag(intExtra);
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
                        bo.a().b(photoUrlData.getSmallurl(), com.baidu.tieba.util.ad.c("tieba_group_image"), true, false, true);
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
            this.f.r();
        }
    }

    private void a(String str) {
        if (this.h != null) {
            this.h.a(this.g.d());
            this.h.f(str);
            this.h.c(3);
            this.f.r();
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
                this.f.r();
            }
        }
    }

    @Override // com.baidu.tieba.im.c.l
    public void a(GroupNewsPojo groupNewsPojo) {
        if (groupNewsPojo != null) {
            String cmd = groupNewsPojo.getCmd();
            if (!TextUtils.isEmpty(cmd)) {
                if (cmd.equals("apply_join_success")) {
                    c(groupNewsPojo);
                } else if (cmd.equals("kick_out")) {
                    b(groupNewsPojo);
                } else if (cmd.equals("group_name_change")) {
                    d(groupNewsPojo);
                } else if (cmd.equals("dismiss_group")) {
                    e(groupNewsPojo);
                }
            }
        }
    }

    public void b(GroupNewsPojo groupNewsPojo) {
        if (groupNewsPojo != null && this.g != null && this.g.g() != null) {
            try {
                JSONObject jSONObject = new JSONObject(groupNewsPojo.getContent());
                String string = jSONObject.getJSONObject("eventParam").getString("groupId");
                if (jSONObject.getString("eventId").equals("003") && string.equals(String.valueOf(this.g.d())) && this.g.g().f()) {
                    this.g.g().a(false);
                    GroupData a = this.g.g().a();
                    if (a != null && a.getMemberNum() > 1) {
                        a.setMemberNum(a.getMemberNum() - 1);
                    }
                    this.f.a(this.g.g(), true);
                    e();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void c(GroupNewsPojo groupNewsPojo) {
        try {
            String optString = new JSONObject(groupNewsPojo.getContent()).optJSONObject("eventParam").optString("groupId");
            if (!TextUtils.isEmpty(optString) && this.g != null && optString.equals(String.valueOf(this.g.d())) && this.g.g() != null) {
                this.g.g().a(true);
                if (this.f != null) {
                    this.f.t();
                    e();
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void d(GroupNewsPojo groupNewsPojo) {
        if (groupNewsPojo != null && this.g != null && this.g.g() != null) {
            try {
                JSONObject jSONObject = new JSONObject(groupNewsPojo.getContent());
                JSONObject jSONObject2 = jSONObject.getJSONObject("eventParam");
                String string = jSONObject2.getString("groupId");
                if (jSONObject.getString("eventId").equals("101") && string.equals(String.valueOf(this.g.d()))) {
                    String string2 = jSONObject2.getString("groupName");
                    if (!TextUtils.isEmpty(string2)) {
                        this.f.a(string2);
                        if (this.g.g() != null && this.g.g().a() != null) {
                            this.g.g().a().setName(string2);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void e(GroupNewsPojo groupNewsPojo) {
        if (groupNewsPojo != null && this.g != null) {
            try {
                JSONObject jSONObject = new JSONObject(groupNewsPojo.getContent());
                String string = jSONObject.getJSONObject("eventParam").getString("groupId");
                if (jSONObject.getString("eventId").equals("107") && string.equals(String.valueOf(this.g.d()))) {
                    finish();
                    com.baidu.adp.lib.g.e.d("dismiss suc");
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.j, android.app.Activity, android.view.KeyEvent.Callback
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
}
