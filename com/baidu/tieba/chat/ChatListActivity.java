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
import com.tencent.mm.sdk.platformtools.LocaleUtil;
/* loaded from: classes.dex */
public class ChatListActivity extends com.baidu.tieba.g implements com.baidu.tbadk.a.d {

    /* renamed from: a  reason: collision with root package name */
    private v f924a = null;
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
    public void a(int i, int i2) {
        if (i >= 1) {
            this.c = i;
            this.g = i2;
            if (this.g == 1) {
                this.f924a.d().a(true);
            } else if (this.g == 2) {
                this.f924a.d().b(true);
            }
            this.f924a.d().notifyDataSetChanged();
            this.b.a(TiebaApplication.E(), String.valueOf(this.c));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, android.app.Activity
    public void onResume() {
        a(this.c, 3);
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
        if (this.f924a.d().a() != null) {
            this.f924a.d().a().b();
            this.f924a.d().b();
        }
        if (this.d != null) {
            this.d.removeCallbacks(this.e);
        }
        super.onDestroy();
    }

    private void a(Bundle bundle) {
        this.b = new com.baidu.tieba.model.c();
        this.b.setLoadDataCallBack(new q(this));
        this.f924a.a(this.b.c(TiebaApplication.E()));
        b();
    }

    private void c() {
        this.f924a = new v(this, this.j);
        this.f924a.a(this.k);
        this.f924a.a(this.n);
        this.f924a.a(this.l);
        this.f924a.a(this.m);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        String c;
        NetWorkCore.NetworkStateInfo c2 = NetWorkCore.c(this);
        this.f924a.e().a();
        boolean z = c2 == NetWorkCore.NetworkStateInfo.WIFI || c2 == NetWorkCore.NetworkStateInfo.ThreeG;
        this.f924a.e().a(z);
        int c3 = this.f924a.c();
        this.f924a.e().a();
        int i = 0;
        for (int b = this.f924a.b(); b < this.f924a.d().getCount(); b++) {
            if (z || b <= c3) {
                if ((this.f924a.d().getItem(b) instanceof com.baidu.tieba.data.a.g) && i < 13 && (c = ((com.baidu.tieba.data.a.g) this.f924a.d().getItem(b)).c()) != null && !c.equals("")) {
                    i++;
                    this.f924a.e().b(c, this);
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
        this.f924a.a(i);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 12011:
                    String stringExtra = intent.getStringExtra(LocaleUtil.INDONESIAN);
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
        this.f924a.a(new r(this));
        this.f924a.a();
    }

    @Override // com.baidu.tbadk.a.d
    public void a(com.baidu.adp.widget.a.b bVar, String str, boolean z) {
        ImageView imageView;
        if (bVar != null && this.f924a.f() != null && (imageView = (ImageView) this.f924a.f().findViewWithTag(str)) != null) {
            bVar.b(imageView);
            imageView.invalidate();
        }
    }

    public void b() {
        this.d = new Handler();
        this.e = new s(this);
    }
}
