package com.baidu.tieba.chat;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ImageView;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.NetWorkCore;
/* loaded from: classes.dex */
public class ChatListActivity extends com.baidu.tieba.g implements com.baidu.tbadk.a.d {
    private v a = null;
    private com.baidu.tieba.model.c b = null;
    private int c = 1;
    private Handler d = null;
    private Runnable e = null;
    private com.baidu.tieba.data.a.g f = null;
    private int g = 3;
    private View.OnClickListener j = new l(this);
    private AdapterView.OnItemClickListener k = new m(this);
    private AdapterView.OnItemLongClickListener l = new n(this);
    private com.baidu.adp.widget.ListView.b m = new o(this);
    private AbsListView.OnScrollListener n = new p(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        c();
        a(bundle);
        if (TiebaApplication.f().t()) {
            StatService.onEvent(this, "enter_chatlist", "chatlistclick", 1);
        }
    }

    public static void a(Context context) {
        context.startActivity(new Intent(context, ChatListActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, int i2) {
        if (i >= 1) {
            this.c = i;
            this.g = i2;
            if (this.g == 1) {
                this.a.d().a(true);
            } else if (this.g == 2) {
                this.a.d().b(true);
            }
            this.a.d().notifyDataSetChanged();
            this.b.a(TiebaApplication.E(), String.valueOf(this.c));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, android.app.Activity
    public void onResume() {
        b(this.c, 3);
        this.e.run();
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, android.app.Activity
    public void onPause() {
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, android.app.Activity
    public void onDestroy() {
        if (this.a.d().a() != null) {
            this.a.d().a().b();
            this.a.d().b();
        }
        if (this.d != null) {
            this.d.removeCallbacks(this.e);
        }
        super.onDestroy();
    }

    private void a(Bundle bundle) {
        this.b = new com.baidu.tieba.model.c();
        this.b.setLoadDataCallBack(new q(this));
        this.a.a(this.b.c(TiebaApplication.E()));
        b();
    }

    private void c() {
        this.a = new v(this, this.j);
        this.a.a(this.k);
        this.a.a(this.n);
        this.a.a(this.l);
        this.a.a(this.m);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        String c;
        NetWorkCore.NetworkStateInfo c2 = NetWorkCore.c(this);
        this.a.e().a();
        boolean z = c2 == NetWorkCore.NetworkStateInfo.WIFI || c2 == NetWorkCore.NetworkStateInfo.ThreeG;
        this.a.e().a(z);
        int c3 = this.a.c();
        this.a.e().a();
        int i = 0;
        for (int b = this.a.b(); b < this.a.d().getCount(); b++) {
            if (z || b <= c3) {
                if ((this.a.d().getItem(b) instanceof com.baidu.tieba.data.a.g) && i < 13 && (c = ((com.baidu.tieba.data.a.g) this.a.d().getItem(b)).c()) != null && !c.equals("")) {
                    i++;
                    this.a.e().b(c, this);
                }
                if (i >= 30) {
                    return;
                }
            } else {
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g
    public void a(int i) {
        super.a(i);
        this.a.a(i);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 1200011:
                    String stringExtra = intent.getStringExtra("id");
                    String stringExtra2 = intent.getStringExtra("name");
                    String stringExtra3 = intent.getStringExtra("portrait");
                    if (stringExtra2 != null && stringExtra != null) {
                        ChatActivity.a(this, stringExtra, stringExtra2, stringExtra3, null, null);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.data.a.g gVar) {
        this.a.a(new r(this));
        this.a.a();
    }

    @Override // com.baidu.tbadk.a.d
    public void a(com.baidu.adp.widget.a.b bVar, String str, boolean z) {
        ImageView imageView;
        if (bVar != null && this.a.f() != null && (imageView = (ImageView) this.a.f().findViewWithTag(str)) != null) {
            bVar.b(imageView);
            imageView.invalidate();
        }
    }

    public void b() {
        this.d = new Handler();
        this.e = new s(this);
    }
}
