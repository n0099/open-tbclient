package com.baidu.tieba.im.groupInfo;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.account.LoginActivity;
import com.baidu.tieba.im.chat.GroupSettingActivity;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.data.PhotoUrlData;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.im.frsgroup.FrsGroupActivity;
import com.baidu.tieba.im.frsgroup.GroupLevelActivity;
import com.baidu.tieba.im.frsgroup.MembersActivity;
import com.baidu.tieba.im.groupCard.GroupCardActivity;
import com.baidu.tieba.im.updategroup.UpdateGroupActivity;
import com.baidu.tieba.person.EditHeadActivity;
import com.baidu.tieba.person.PersonInfoActivity;
import com.baidu.tieba.util.af;
import com.baidu.tieba.write.bd;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class GroupInfoActivity extends com.baidu.tieba.j implements View.OnClickListener, View.OnLongClickListener, aa, z, com.baidu.tieba.im.pushNotify.m {
    private n f;
    private com.baidu.tieba.im.model.c g;
    private com.baidu.tieba.im.model.x h;
    private l i;

    /* renamed from: a  reason: collision with root package name */
    private final int f1669a = 1;
    private final int b = 2;
    private final int c = 3;
    private final int d = 4;
    private int e = 0;
    private final DialogInterface.OnClickListener j = new i(this);
    private DialogInterface.OnClickListener k = new j(this);
    private y l = new k(this);

    public static void a(Context context, long j, int i) {
        Intent intent = new Intent(context, GroupInfoActivity.class);
        intent.putExtra("group_id", j);
        intent.putExtra("activity_from", i);
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
        this.i = new l(this, null);
        com.baidu.tieba.im.messageCenter.f.a().a(103004, this.i);
        com.baidu.tieba.im.messageCenter.f.a().a(-102, this.i);
        com.baidu.tieba.im.messageCenter.f.a().a(103102, this.i);
        com.baidu.tieba.im.messageCenter.f.a().a(103112, this.i);
        com.baidu.tieba.im.messageCenter.f.a().a(103110, this.i);
        com.baidu.tieba.im.pushNotify.n.a().a("kick_out", this);
        com.baidu.tieba.im.pushNotify.n.a().a("apply_join_success", this);
        com.baidu.tieba.im.pushNotify.n.a().a("group_name_change", this);
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
        this.g.c();
        com.baidu.tieba.im.pushNotify.n.a().a(this);
        com.baidu.tieba.im.messageCenter.f.a().a(this.i);
        com.baidu.tieba.im.pushNotify.n.a().a(this);
        if (this.f != null) {
            this.f.v();
        }
    }

    private void b() {
        this.f = new n(this);
        this.f.a(this.k);
        this.f.a(this.l);
        this.f.b(this.j);
    }

    private void c() {
        this.f.q();
        this.g.b(this.g.a(), this.g.b());
    }

    public void a(Bundle bundle, Intent intent) {
        this.g = new com.baidu.tieba.im.model.c();
        if (bundle == null) {
            com.baidu.tieba.im.model.c cVar = this.g;
            if (intent == null) {
                intent = getIntent();
            }
            cVar.a(intent);
        } else {
            this.g.a(bundle);
        }
        this.h = new com.baidu.tieba.im.model.x();
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
        if (view == this.f.r()) {
            if (this.g.d().isGroupManager()) {
                this.f.w();
            }
        } else if (view == this.f.o()) {
            closeActivity();
        } else if (view == this.f.e()) {
            if (this.g.d() != null && this.g.d().getGroup() != null) {
                FrsGroupActivity.a(this, String.valueOf(this.g.d().getGroup().getForumId()), this.g.d().isHideRecommendGroup() ? false : true);
            }
        } else if (view == this.f.l()) {
            if (this.g.d() != null && this.g.d().getGroup() != null) {
                PersonInfoActivity.a(this, String.valueOf(this.g.d().getGroup().getAuthorId()), this.g.d().getGroup().getAuthorName());
            }
        } else if (view == this.f.m()) {
            GroupLevelActivity.a(this, this.g.a());
        } else if (view == this.f.k()) {
            com.baidu.adp.lib.h.d.d("botton click");
            if (TextUtils.isEmpty(TiebaApplication.A())) {
                LoginActivity.a((Activity) this, "", true, 3);
            } else if (this.g.d() != null) {
                if (this.g.d().isJoin()) {
                    if (this.g.d().getGroup() != null) {
                        MsglistActivity.a(this, (int) this.g.a(), this.g.d().getGroup().getName(), this.g.d().getGroup().getAuthorId(), "group_info");
                    }
                } else if (this.g.k()) {
                    showToast(R.string.has_recent_join);
                } else if (this.g.d() != null) {
                    if (this.g.d().getCanJoinGroupNum() <= 0) {
                        showToast(R.string.add_group_max);
                    } else {
                        ApplyJoinGroupActivity.a(this, "" + this.g.a(), this.g.d().getJoinGroupNum(), this.g.d().getCanJoinGroupNum());
                    }
                }
            }
        } else if (view == this.f.g()) {
            if (this.g.d() != null && this.g.d().getGroup() != null) {
                GroupCardActivity.a(this, this.g.a(), this.g.d().getGroup().getName(), this.g.d().getGroup().getPortrait());
            }
        } else if (view == this.f.j()) {
            if (this.g.d() != null && this.g.d().getGroup() != null) {
                GroupSettingActivity.a(this, 4, this.g.d().getGroup().getName(), "" + this.g.a(), this.g.d().isGroupManager(), this.g.d().getGroup().getFlag());
            }
        } else if (view == this.f.i()) {
            if (this.g.d() != null && this.g.d().getGroup() != null) {
                UpdateGroupActivity.a(this, 1, (int) this.g.a(), 1, this.g.d().getGroup().getName());
            }
        } else if (view == this.f.h()) {
            if (this.g.d().isGroupManager() && this.g.d() != null && this.g.d().getGroup() != null) {
                UpdateGroupActivity.a(this, 2, (int) this.g.a(), 2, this.g.d().getGroup().getIntro());
            }
        } else if (view == this.f.n() || view == this.f.f()) {
            MembersActivity.a(this, this.g.a());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j
    public void closeActivity() {
        finish();
    }

    @Override // com.baidu.tieba.im.groupInfo.aa
    public void a(View view, Object obj, int i) {
        this.f.a(obj, i);
    }

    @Override // com.baidu.adp.a.a, android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        if (view == this.f.a()) {
            if (this.g.d() == null || this.g.d().getGroup() == null) {
                return false;
            }
            this.f.e(String.valueOf(this.g.d().getGroup().getGroupId()));
            return false;
        } else if (view != this.f.h() || this.g.d().isGroupManager()) {
            return false;
        } else {
            if (this.g.d() != null && this.g.d().getGroup() != null) {
                this.f.d(String.valueOf(this.g.d().getGroup().getIntro()));
            }
            return true;
        }
    }

    @Override // com.baidu.tieba.im.groupInfo.z
    public void onClick(View view, int i, Object obj, int i2) {
        if (i == 2) {
            this.f.t();
        } else if (i == 1) {
            ArrayList<String> e = this.g.e();
            if (obj != null && (obj instanceof PhotoUrlData) && e != null) {
                GroupImageActivity.a(this, ((PhotoUrlData) obj).getBigurl(), e, this.g.a());
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
                        if (this.g != null && this.g.d() != null && this.g.d().getGroup() != null) {
                            this.g.d().getGroup().setName(stringExtra);
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
                        if (this.g != null && this.g.d() != null && this.g.d().getGroup() != null) {
                            this.g.d().getGroup().setIntro(stringExtra2);
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
                        if (this.g != null && this.g.d() != null && this.g.d().getGroup() != null) {
                            this.g.d().getGroup().setFlag(intExtra);
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
                        com.baidu.tieba.util.a.c.a(photoUrlData.getSmallurl(), af.c("tieba_group_image"), true, false, true);
                    }
                    b(photoUrlData);
                    return;
                default:
                    return;
            }
        } else if (i2 == 0) {
            if (i == 12010) {
                bd.a(this);
            } else if (i == 12009) {
                bd.b(this);
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

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        this.e = 4;
        if (this.h != null) {
            this.h.a(this.g.a());
            this.h.a(i);
            this.h.b(5);
            this.f.q();
        }
    }

    private void a(String str) {
        if (this.h != null) {
            this.h.a(this.g.a());
            this.h.d(str);
            this.h.b(3);
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
                this.h.a(this.g.a());
                this.h.c(picId);
                this.h.b(4);
                this.f.q();
            }
        }
    }

    @Override // com.baidu.tieba.im.pushNotify.m
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
                }
            }
        }
    }

    public void b(GroupNewsPojo groupNewsPojo) {
        if (groupNewsPojo != null && this.g != null && this.g.d() != null) {
            try {
                JSONObject jSONObject = new JSONObject(groupNewsPojo.getContent());
                String string = jSONObject.getJSONObject("eventParam").getString("groupId");
                if (jSONObject.getString("eventId").equals("003") && string.equals(String.valueOf(this.g.a())) && this.g.d().isJoin()) {
                    this.g.d().setJoin(false);
                    this.f.a(this.g.d(), true);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void c(GroupNewsPojo groupNewsPojo) {
        try {
            String optString = new JSONObject(groupNewsPojo.getContent()).optJSONObject("eventParam").optString("groupId");
            if (!TextUtils.isEmpty(optString) && this.g != null && optString.equals(String.valueOf(this.g.a())) && this.g.d() != null) {
                this.g.d().setJoin(true);
                if (this.f != null) {
                    this.f.s();
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void d(GroupNewsPojo groupNewsPojo) {
        if (groupNewsPojo != null && this.g != null && this.g.d() != null) {
            try {
                JSONObject jSONObject = new JSONObject(groupNewsPojo.getContent());
                JSONObject jSONObject2 = jSONObject.getJSONObject("eventParam");
                String string = jSONObject2.getString("groupId");
                if (jSONObject.getString("eventId").equals("101") && string.equals(String.valueOf(this.g.a()))) {
                    String string2 = jSONObject2.getString("groupName");
                    if (!TextUtils.isEmpty(string2)) {
                        this.f.a(string2);
                        if (this.g.d() != null && this.g.d().getGroup() != null) {
                            this.g.d().getGroup().setName(string2);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
