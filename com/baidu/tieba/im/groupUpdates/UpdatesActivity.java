package com.baidu.tieba.im.groupUpdates;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AbsListView;
import android.widget.CompoundButton;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.im.frsgroup.GroupLevelActivity;
import com.baidu.tieba.im.groupInfo.GroupInfoActivity;
import com.baidu.tieba.im.groupInfo.RequestDelSystemMessage;
import com.baidu.tieba.im.groupInfo.ResponseDelSystemMessage;
import com.baidu.tieba.im.message.Message;
import com.baidu.tieba.im.message.ResponsedMessage;
import com.baidu.tieba.mention.t;
import com.baidu.tieba.util.UtilHelper;
import com.slidingmenu.lib.R;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class UpdatesActivity extends com.baidu.tieba.j implements AbsListView.OnScrollListener, com.baidu.tieba.im.messageCenter.h, com.baidu.tieba.im.pushNotify.m {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f1619a = false;
    private n b;
    private AlertDialog c;
    private com.baidu.tieba.im.a<LinkedList<GroupNewsPojo>> d;
    private com.baidu.tieba.im.a<Boolean> e;
    private Runnable f;
    private com.baidu.tieba.util.a g;
    private boolean j = false;
    private UpdatesItemData k;
    private m l;

    public static void a(Context context) {
        if (context != null) {
            context.startActivity(new Intent(context, UpdatesActivity.class));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.l = new m();
        this.b = new n(this);
        d();
        this.g = new com.baidu.tieba.util.a(this);
        this.g.d(true);
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < 100; i++) {
            UpdatesItemData updatesItemData = new UpdatesItemData();
            updatesItemData.setGroupId("1212");
            updatesItemData.setGroupName("groupName" + i);
            updatesItemData.setShown(Math.random() > 0.6d);
            if (Math.random() > 0.5d) {
                updatesItemData.setContent("一二三四五六七八九十一二三四五六七八九十一二三四五六七八九十");
            } else {
                updatesItemData.setContent("一二三四五六七八九十");
            }
            updatesItemData.setNotice_id("" + i);
            updatesItemData.setTitle("提醒");
            updatesItemData.setTime(System.currentTimeMillis());
            GroupNewsPojo groupNewsPojo = new GroupNewsPojo(updatesItemData);
            groupNewsPojo.setCmd("group_intro_change");
            linkedList.add(groupNewsPojo);
        }
        com.baidu.tieba.im.pushNotify.n.a().a("group_intro_change", this);
        com.baidu.tieba.im.pushNotify.n.a().a("group_level_up", this);
        com.baidu.tieba.im.pushNotify.n.a().a("group_name_change", this);
        com.baidu.tieba.im.pushNotify.n.a().a("group_notice_change", this);
        this.b.a(true);
        m.b(this.d);
        com.baidu.tieba.im.messageCenter.f.a().a(202004, this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onResume() {
        super.onResume();
        f1619a = true;
        t.a().a(2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onStop() {
        super.onStop();
        f1619a = false;
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        f1619a = true;
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        f1619a = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onPause() {
        super.onPause();
        f1619a = false;
    }

    private void d() {
        this.e = new a(this);
        this.d = new b(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.b != null) {
            this.b.c();
        }
        if (this.l != null) {
            this.l.c();
        }
        this.k = null;
        com.baidu.tieba.im.pushNotify.n.a().a(this);
    }

    @Override // com.baidu.adp.a.a, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null && this.b != null) {
            if (view.equals(this.b.h())) {
                finish();
            } else if (view.equals(this.b.j())) {
                a(true);
                this.b.e();
            } else if (view.equals(this.b.k())) {
                a(false);
                this.b.f();
                this.l.b();
                m.b(this.d);
            } else if (view.equals(this.b.l())) {
                this.b.a(true);
                String a2 = this.l.a();
                if (!TextUtils.isEmpty(a2)) {
                    c(a2);
                } else {
                    this.b.a(false);
                }
            }
        }
    }

    @Override // com.baidu.tieba.j, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent == null) {
            return super.onKeyDown(i, keyEvent);
        }
        if (4 == i && keyEvent.getAction() == 0 && this.j) {
            a(false);
            this.l.b();
            this.b.a(this.l.d());
            this.b.f();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(UpdatesItemData updatesItemData) {
        if (!UtilHelper.b()) {
            b(R.string.neterror);
        } else if (updatesItemData != null && !TextUtils.isEmpty(com.baidu.tieba.im.pushNotify.n.a().d()) && TextUtils.isDigitsOnly(com.baidu.tieba.im.pushNotify.n.a().d()) && !TextUtils.isEmpty(updatesItemData.getNotice_id()) && TextUtils.isDigitsOnly(updatesItemData.getNotice_id())) {
            try {
                this.b.a(true);
                RequestDelSystemMessage requestDelSystemMessage = new RequestDelSystemMessage();
                requestDelSystemMessage.setGroupId(Long.parseLong(com.baidu.tieba.im.pushNotify.n.a().d()));
                requestDelSystemMessage.setMsgIds("" + (Long.parseLong(updatesItemData.getNotice_id()) / 100));
                com.baidu.adp.lib.h.d.d("del group info request: gid" + updatesItemData.getGroupId() + " msgid:" + updatesItemData.getNotice_id() + " systemGid:" + requestDelSystemMessage.getGroupId());
                com.baidu.tieba.im.messageCenter.f.a().a(requestDelSystemMessage);
            } catch (Exception e) {
                e.printStackTrace();
                com.baidu.adp.lib.h.d.a(e.getMessage());
            }
        }
    }

    private void c(String str) {
        if (!UtilHelper.b()) {
            b(R.string.neterror);
        } else if (!TextUtils.isEmpty(str)) {
            String d = com.baidu.tieba.im.pushNotify.n.a().d();
            if (!TextUtils.isEmpty(d) && TextUtils.isDigitsOnly(d)) {
                this.b.a(true);
                RequestDelSystemMessage requestDelSystemMessage = new RequestDelSystemMessage();
                requestDelSystemMessage.setGroupId(Long.parseLong(d));
                requestDelSystemMessage.setMsgIds(str);
                com.baidu.adp.lib.h.d.d("del group info request: " + str);
                com.baidu.tieba.im.messageCenter.f.a().a(requestDelSystemMessage);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j
    public void a(int i) {
        super.a(i);
        if (this.b != null) {
            this.b.b(i);
        }
    }

    @Override // com.baidu.tieba.im.pushNotify.m
    public void a(GroupNewsPojo groupNewsPojo) {
        m.b(this.d);
    }

    public void a(View view, int i, int i2, long j, UpdatesItemData updatesItemData) {
        if (updatesItemData != null && 101 == i && !c()) {
            String groupId = updatesItemData.getGroupId();
            com.baidu.adp.lib.h.d.d("go to level gid:" + groupId);
            String updatesType = updatesItemData.getUpdatesType();
            com.baidu.adp.lib.h.d.d("updateType:" + updatesType);
            if (!TextUtils.isEmpty(updatesType)) {
                try {
                    if (updatesType.equals("group_level_up")) {
                        GroupLevelActivity.a(this, Long.parseLong(groupId));
                    } else {
                        GroupInfoActivity.a(this, Long.parseLong(groupId), 0);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void a(CompoundButton compoundButton, boolean z, UpdatesItemData updatesItemData) {
        if (updatesItemData != null) {
            if (z) {
                this.l.a(updatesItemData);
                updatesItemData.setSelected(true);
                if (this.l.d() > 100) {
                    this.l.b(updatesItemData);
                    updatesItemData.setSelected(false);
                    b(R.string.updates_activity_del_limit);
                }
            } else {
                this.l.b(updatesItemData);
                updatesItemData.setSelected(false);
            }
            this.b.a(this.l.d());
            this.b.g();
        }
    }

    public void b(View view, int i, int i2, long j, UpdatesItemData updatesItemData) {
        if (view != null && updatesItemData != null && 200 == i && !c()) {
            if (this.c == null) {
                this.k = updatesItemData;
                e();
            }
            this.c.show();
        }
    }

    private void e() {
        String string = getString(R.string.delete_user_chat);
        c cVar = new c(this);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.operation);
        builder.setItems(new String[]{string}, cVar);
        this.c = builder.create();
        this.c.setCanceledOnTouchOutside(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        if (this.b.i() != null) {
            n();
            this.b.i().removeCallbacks(this.f);
            this.b.i().post(this.f);
        }
    }

    private void n() {
        if (this.f == null) {
            this.f = new d(this);
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 0) {
            f();
        }
    }

    public com.baidu.tieba.util.a b() {
        return this.g;
    }

    public boolean c() {
        return this.j;
    }

    public void a(boolean z) {
        this.j = z;
    }

    @Override // com.baidu.tieba.im.messageCenter.h
    public void a(Message message) {
        this.b.a(false);
        if (message != null && (message instanceof ResponsedMessage) && 202004 == message.getCmd()) {
            ResponseDelSystemMessage responseDelSystemMessage = (ResponseDelSystemMessage) message;
            RequestDelSystemMessage requestDelSystemMessage = (RequestDelSystemMessage) responseDelSystemMessage.getOrginalMessage();
            if (responseDelSystemMessage.hasError()) {
                com.baidu.adp.lib.h.d.a("del group info err:" + responseDelSystemMessage.getErrMsg());
                return;
            }
            com.baidu.adp.lib.h.d.d("del group info: gid" + requestDelSystemMessage.getGroupId() + " msgid:" + requestDelSystemMessage.getMsgIds());
            if (this.k != null) {
                m.a(this.k, this.e);
                this.k = null;
            }
            if (this.l != null && this.l.d() > 0) {
                this.l.a(this.e);
            }
            com.baidu.tieba.im.validate.k.a(this.d);
            com.baidu.tieba.im.pushNotify.a.a(false, (com.baidu.tieba.im.a<Void>) null);
        }
    }
}
