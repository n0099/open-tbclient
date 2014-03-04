package com.baidu.tieba.im.friend;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.tieba.im.message.bq;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class InviteFriendListActivity extends com.baidu.tieba.f implements View.OnClickListener, com.baidu.tieba.im.messageCenter.g {
    private u a;
    private com.baidu.tieba.im.model.h b;
    private com.baidu.adp.a.g c = new k(this);

    public static void a(Context context, int i, int i2) {
        Intent intent = new Intent(context, InviteFriendListActivity.class);
        intent.putExtra(PushConstants.EXTRA_GID, 0);
        intent.putExtra("groupid", i2);
        context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.baidu.tieba.im.messageCenter.d.a().a(205002, this);
        Intent intent = getIntent();
        this.b = new com.baidu.tieba.im.model.h();
        this.b.setLoadDataCallBack(this.c);
        if (intent != null) {
            this.b.a(intent);
        } else {
            this.b.a(bundle);
        }
        this.a = new u(this);
        this.a.a(100);
        this.a.a(new l(this));
        this.b.a((String) null);
        this.a.j();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.b.b(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f, com.baidu.adp.a.a, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        com.baidu.tieba.im.messageCenter.d.a().a(this);
        this.b.cancelLoadData();
    }

    @Override // com.baidu.adp.a.a, android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.a != null) {
            this.a.i();
            if (view.getId() == this.a.e()) {
                a();
                this.b.b(this.a.h());
            } else if (view.getId() == this.a.f()) {
                this.b.a(this.a.g());
                a();
            }
        }
    }

    public final void a() {
        showLoadingDialog(null, new m(this));
    }

    @Override // com.baidu.tieba.im.messageCenter.g
    public final void a(com.baidu.tieba.im.message.s sVar) {
        closeLoadingDialog();
        if (sVar != null && sVar.v() == 205002 && (sVar instanceof bq)) {
            try {
                bq bqVar = (bq) sVar;
                if (bqVar.l()) {
                    showToast(bqVar.n());
                } else {
                    showToast(getString(R.string.send_success), false);
                    new Handler().postDelayed(new n(this), 400L);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f
    public void onChangeSkinType(int i) {
        this.a.a();
    }
}
