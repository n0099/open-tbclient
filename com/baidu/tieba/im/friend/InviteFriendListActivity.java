package com.baidu.tieba.im.friend;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.ag;
import com.baidu.tbadk.core.atomData.bj;
import com.baidu.tbadk.core.view.TbCheckBox;
import com.baidu.tbadk.coreExtra.relationship.GetContactListRequestMessage;
import com.baidu.tieba.x;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public class InviteFriendListActivity extends BaseActivity implements View.OnClickListener, AdapterView.OnItemClickListener {
    private s b;
    private w c;
    private boolean d;
    private boolean f;
    public List<com.baidu.tbadk.coreExtra.relationship.b> a = null;
    private LinkedList<com.baidu.tbadk.coreExtra.relationship.b> e = new LinkedList<>();
    private final AtomicBoolean g = new AtomicBoolean(false);
    private CustomMessageListener h = new k(this, 2001188);
    private final com.baidu.adp.framework.listener.d i = new l(this, 205002);

    static {
        TbadkApplication.m252getInst().RegisterIntent(ag.class, InviteFriendListActivity.class);
    }

    public static void a(Context context, int i, int i2) {
        Intent intent = new Intent(context, InviteFriendListActivity.class);
        intent.putExtra("gid", i);
        intent.putExtra("groupid", i2);
        context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.i);
        registerListener(this.h);
        Intent intent = getIntent();
        b();
        if (intent != null) {
            this.d = intent.getBooleanExtra("isfrominvitechat", false);
            this.c.a(intent);
        } else {
            this.d = bundle.getBoolean("isfrominvitechat", false);
            this.c.a(bundle);
        }
        c();
        d();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.c.b(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.c.cancelLoadData();
    }

    private void b() {
        this.c = new w(this);
    }

    private void c() {
        this.b = new s(this, this.d);
        this.b.a(100);
        this.b.a(new n(this));
    }

    private void d() {
        e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        String trim;
        if (!isFinishing()) {
            if (this.a == null) {
                if (!this.g.get()) {
                    this.g.set(true);
                    a();
                    this.b.g();
                    super.sendMessage(new GetContactListRequestMessage());
                    return;
                }
                return;
            }
            String d = this.b.d();
            if (d == null) {
                trim = "";
            } else {
                trim = d.trim();
            }
            if (this.a.isEmpty() && trim.length() > 0) {
                showToast(getString(x.invite_friend_no_data_now));
            }
            if (trim.length() == 0) {
                this.f = false;
                this.b.a(this.a, false);
                return;
            }
            this.e.clear();
            for (com.baidu.tbadk.coreExtra.relationship.b bVar : this.a) {
                String a = bVar.a();
                if (a != null && a.contains(trim)) {
                    this.e.add(bVar);
                }
            }
            this.f = true;
            this.b.a((List<com.baidu.tbadk.coreExtra.relationship.b>) this.e, true);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.b != null) {
            this.b.f();
            if (view.getId() == this.b.c()) {
                a();
                this.c.a(this.b.e());
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        Object tag;
        com.baidu.tbadk.coreExtra.relationship.b bVar;
        super.onItemClick(adapterView, view, i, j);
        if (this.d) {
            if (this.f) {
                if (this.e != null && i < this.e.size()) {
                    bVar = this.e.get(i);
                }
                bVar = null;
            } else {
                if (this.a != null && i < this.a.size()) {
                    bVar = this.a.get(i);
                }
                bVar = null;
            }
            if (bVar != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new bj(this, bVar.c(), bVar.b(), bVar.d(), 0)));
            }
        } else if (view != null && (tag = view.getTag()) != null && (tag instanceof q)) {
            TbCheckBox tbCheckBox = ((q) tag).d;
            tbCheckBox.setChecked(tbCheckBox.b() ? false : true);
        }
    }

    public void a() {
        showLoadingDialog(null, new o(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.b.a();
    }
}
