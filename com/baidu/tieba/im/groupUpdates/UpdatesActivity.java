package com.baidu.tieba.im.groupUpdates;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AbsListView;
import cn.jingling.lib.file.Shared;
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
public class UpdatesActivity extends com.baidu.tieba.j implements AbsListView.OnScrollListener, com.baidu.tieba.im.messageCenter.g, com.baidu.tieba.im.pushNotify.k {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f1764a = false;
    private n b;
    private AlertDialog c;
    private com.baidu.tieba.im.a<LinkedList<GroupNewsPojo>> d;
    private com.baidu.tieba.im.a<Boolean> e;
    private Runnable f;
    private com.baidu.tieba.util.i g;
    private boolean h = false;
    private UpdatesItemData i;
    private m j;

    public static void a(Context context) {
        if (context != null) {
            context.startActivity(new Intent(context, UpdatesActivity.class));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.j = new m();
        this.b = new n(this);
        c();
        this.g = new com.baidu.tieba.util.i(this);
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
        com.baidu.tieba.im.pushNotify.l.a().a("group_intro_change", this);
        com.baidu.tieba.im.pushNotify.l.a().a("group_level_up", this);
        com.baidu.tieba.im.pushNotify.l.a().a("group_name_change", this);
        com.baidu.tieba.im.pushNotify.l.a().a("group_notice_change", this);
        com.baidu.tieba.im.pushNotify.l.a().a("dismiss_group", this);
        this.b.a(true);
        m.b(this.d);
        com.baidu.tieba.im.messageCenter.e.a().a(202004, this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onResume() {
        super.onResume();
        f1764a = true;
        t.a().a(2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onStop() {
        super.onStop();
        f1764a = false;
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        f1764a = true;
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        f1764a = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onPause() {
        super.onPause();
        f1764a = false;
    }

    private void c() {
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
        if (this.j != null) {
            this.j.c();
        }
        this.i = null;
        com.baidu.tieba.im.pushNotify.l.a().a(this);
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
                this.j.b();
                m.b(this.d);
            } else if (view.equals(this.b.l())) {
                this.b.a(true);
                String a2 = this.j.a();
                if (!TextUtils.isEmpty(a2)) {
                    a(a2);
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
        if (4 == i && keyEvent.getAction() == 0 && this.h) {
            a(false);
            this.j.b();
            this.b.a(this.j.d());
            this.b.f();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(UpdatesItemData updatesItemData) {
        if (!UtilHelper.b()) {
            showToast(R.string.neterror);
        } else if (updatesItemData != null && !TextUtils.isEmpty(com.baidu.tieba.im.pushNotify.l.a().d()) && TextUtils.isDigitsOnly(com.baidu.tieba.im.pushNotify.l.a().d()) && !TextUtils.isEmpty(updatesItemData.getNotice_id()) && TextUtils.isDigitsOnly(updatesItemData.getNotice_id())) {
            try {
                this.b.a(true);
                RequestDelSystemMessage requestDelSystemMessage = new RequestDelSystemMessage();
                requestDelSystemMessage.setGroupId(Long.parseLong(com.baidu.tieba.im.pushNotify.l.a().d()));
                requestDelSystemMessage.setMsgIds("" + (Long.parseLong(updatesItemData.getNotice_id()) / 100));
                com.baidu.adp.lib.h.e.d("del group info request: gid" + updatesItemData.getGroupId() + " msgid:" + updatesItemData.getNotice_id() + " systemGid:" + requestDelSystemMessage.getGroupId());
                com.baidu.tieba.im.messageCenter.e.a().a(requestDelSystemMessage);
            } catch (Exception e) {
                e.printStackTrace();
                com.baidu.adp.lib.h.e.a(e.getMessage());
            }
        }
    }

    private void a(String str) {
        if (!UtilHelper.b()) {
            showToast(R.string.neterror);
        } else if (!TextUtils.isEmpty(str)) {
            String d = com.baidu.tieba.im.pushNotify.l.a().d();
            if (!TextUtils.isEmpty(d) && TextUtils.isDigitsOnly(d)) {
                this.b.a(true);
                RequestDelSystemMessage requestDelSystemMessage = new RequestDelSystemMessage();
                requestDelSystemMessage.setGroupId(Long.parseLong(d));
                requestDelSystemMessage.setMsgIds(str);
                com.baidu.adp.lib.h.e.d("del group info request: " + str);
                com.baidu.tieba.im.messageCenter.e.a().a(requestDelSystemMessage);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.b != null) {
            this.b.b(i);
        }
    }

    @Override // com.baidu.tieba.im.pushNotify.k
    public void a(GroupNewsPojo groupNewsPojo) {
        m.b(this.d);
    }

    public void a(View view, int i, int i2, long j, UpdatesItemData updatesItemData) {
        if (updatesItemData != null && 101 == i && !b()) {
            String groupId = updatesItemData.getGroupId();
            com.baidu.adp.lib.h.e.d("go to level gid:" + groupId);
            String updatesType = updatesItemData.getUpdatesType();
            com.baidu.adp.lib.h.e.d("updateType:" + updatesType);
            if (!TextUtils.isEmpty(updatesType)) {
                try {
                    if (updatesType.equals("group_level_up")) {
                        GroupLevelActivity.a(this, Long.parseLong(groupId));
                    } else if (!updatesType.equals("dismiss_group")) {
                        GroupInfoActivity.a(this, Long.parseLong(groupId), 0);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void a(View view, boolean z, UpdatesItemData updatesItemData) {
        if (updatesItemData != null) {
            if (z) {
                this.j.a(updatesItemData);
                updatesItemData.setSelected(true);
                if (this.j.d() > 100) {
                    this.j.b(updatesItemData);
                    updatesItemData.setSelected(false);
                    showToast(R.string.updates_activity_del_limit);
                }
            } else {
                this.j.b(updatesItemData);
                updatesItemData.setSelected(false);
            }
            this.b.a(this.j.d());
            this.b.g();
        }
    }

    public void b(View view, int i, int i2, long j, UpdatesItemData updatesItemData) {
        if (view != null && updatesItemData != null && 200 == i && !b()) {
            if (this.c == null) {
                this.i = updatesItemData;
                d();
            }
            this.c.show();
        }
    }

    private void d() {
        String string = getString(R.string.delete_user_chat);
        c cVar = new c(this);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.operation);
        builder.setItems(new String[]{string}, cVar);
        this.c = builder.create();
        this.c.setCanceledOnTouchOutside(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.b.i() != null) {
            f();
            this.b.i().removeCallbacks(this.f);
            this.b.i().post(this.f);
        }
    }

    private void f() {
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
            e();
        }
    }

    public com.baidu.tieba.util.i a() {
        return this.g;
    }

    public boolean b() {
        return this.h;
    }

    public void a(boolean z) {
        this.h = z;
    }

    @Override // com.baidu.tieba.im.messageCenter.g
    public void a(Message message) {
        this.b.a(false);
        if (message != null && (message instanceof ResponsedMessage) && 202004 == message.getCmd()) {
            ResponseDelSystemMessage responseDelSystemMessage = (ResponseDelSystemMessage) message;
            RequestDelSystemMessage requestDelSystemMessage = (RequestDelSystemMessage) responseDelSystemMessage.getOrginalMessage();
            if (responseDelSystemMessage.hasError()) {
                com.baidu.adp.lib.h.e.a("del group info err:" + responseDelSystemMessage.getErrMsg());
                return;
            }
            com.baidu.adp.lib.h.e.d("del group info: gid" + requestDelSystemMessage.getGroupId() + " msgid:" + requestDelSystemMessage.getMsgIds());
            if (this.i != null) {
                m.a(this.i, this.e);
                this.i = null;
            }
            if (this.j != null && this.j.d() > 0) {
                this.j.a(this.e);
            }
            com.baidu.tieba.im.validate.l.a(Shared.INFINITY, 0, this.d);
            com.baidu.tieba.im.pushNotify.a.a(false, (com.baidu.tieba.im.a<Void>) null);
        }
    }
}
