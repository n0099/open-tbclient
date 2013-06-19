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
/* loaded from: classes.dex */
public class ChatListActivity extends com.baidu.tieba.e implements com.baidu.tbadk.a.d {
    private v c = null;
    private com.baidu.tieba.c.c d = null;
    private int e = 1;
    private Handler f = null;
    private Runnable g = null;
    private com.baidu.tieba.a.a.g h = null;
    private int i = 3;
    private View.OnClickListener j = new l(this);
    private AdapterView.OnItemClickListener k = new m(this);
    private AdapterView.OnItemLongClickListener l = new n(this);
    private com.baidu.adp.widget.ListView.b m = new o(this);
    private AbsListView.OnScrollListener n = new p(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        c();
        a(bundle);
        if (TiebaApplication.e().p()) {
            StatService.onEvent(this, "enter_chatlist", "chatlistclick", 1);
        }
    }

    public static void a(Context context) {
        context.startActivity(new Intent(context, ChatListActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, int i2) {
        if (i >= 1) {
            this.e = i;
            this.i = i2;
            if (this.i == 1) {
                this.c.d().a(true);
            } else if (this.i == 2) {
                this.c.d().b(true);
            }
            this.c.d().notifyDataSetChanged();
            this.d.a(TiebaApplication.C(), String.valueOf(this.e));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onResume() {
        b(this.e, 3);
        this.g.run();
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onPause() {
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onDestroy() {
        if (this.c.d().a() != null) {
            this.c.d().a().b();
            this.c.d().b();
        }
        if (this.f != null) {
            this.f.removeCallbacks(this.g);
        }
        super.onDestroy();
    }

    private void a(Bundle bundle) {
        this.d = new com.baidu.tieba.c.c();
        this.d.a(new q(this));
        this.c.a(this.d.d(TiebaApplication.C()));
        b();
    }

    private void c() {
        this.c = new v(this, this.j);
        this.c.a(this.k);
        this.c.a(this.n);
        this.c.a(this.l);
        this.c.a(this.m);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        String c;
        com.baidu.tieba.d.z c2 = com.baidu.tieba.d.w.c(this);
        this.c.e().a();
        boolean z = c2 == com.baidu.tieba.d.z.WIFI || c2 == com.baidu.tieba.d.z.ThreeG;
        this.c.e().a(z);
        int c3 = this.c.c();
        this.c.e().a();
        int i = 0;
        for (int b = this.c.b(); b < this.c.d().getCount(); b++) {
            if (z || b <= c3) {
                if ((this.c.d().getItem(b) instanceof com.baidu.tieba.a.a.g) && i < 13 && (c = ((com.baidu.tieba.a.a.g) this.c.d().getItem(b)).c()) != null && !c.equals("")) {
                    i++;
                    this.c.e().b(c, this);
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
    @Override // com.baidu.tieba.e
    public void b(int i) {
        super.b(i);
        this.c.a(i);
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
    public void a(com.baidu.tieba.a.a.g gVar) {
        this.c.a(new r(this));
        this.c.a();
    }

    @Override // com.baidu.tbadk.a.d
    public void a(com.baidu.adp.widget.a.b bVar, String str, boolean z) {
        ImageView imageView;
        if (bVar != null && this.c.f() != null && (imageView = (ImageView) this.c.f().findViewWithTag(str)) != null) {
            bVar.b(imageView);
            imageView.invalidate();
        }
    }

    public void b() {
        this.f = new Handler();
        this.g = new s(this);
    }
}
