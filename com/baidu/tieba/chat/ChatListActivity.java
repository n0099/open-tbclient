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
import com.baidu.tieba.util.UtilHelper;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
/* loaded from: classes.dex */
public class ChatListActivity extends com.baidu.tieba.g implements com.baidu.tbadk.a.d {

    /* renamed from: a  reason: collision with root package name */
    private v f934a = null;
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
        if (TiebaApplication.g().u()) {
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
                this.f934a.h().a(true);
            } else if (this.g == 2) {
                this.f934a.h().b(true);
            }
            this.f934a.h().notifyDataSetChanged();
            this.b.a(TiebaApplication.E(), String.valueOf(this.c));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, android.app.Activity
    public void onResume() {
        super.onResume();
        if (TiebaApplication.F()) {
            this.f934a.a();
            a(this.c, 3);
            this.e.run();
            return;
        }
        this.f934a.b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, android.app.Activity
    public void onPause() {
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, android.app.Activity
    public void onDestroy() {
        if (this.f934a.h().a() != null) {
            this.f934a.h().a().b();
            this.f934a.h().b();
        }
        if (this.d != null) {
            this.d.removeCallbacks(this.e);
        }
        super.onDestroy();
    }

    private void a(Bundle bundle) {
        this.b = new com.baidu.tieba.model.c();
        this.b.setLoadDataCallBack(new q(this));
        this.f934a.a(this.b.c(TiebaApplication.E()));
        b();
    }

    private void c() {
        this.f934a = new v(this, this.j);
        this.f934a.a(this.k);
        this.f934a.a(this.n);
        this.f934a.a(this.l);
        this.f934a.a(this.m);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        String c;
        UtilHelper.NetworkStateInfo i = UtilHelper.i(this);
        this.f934a.i().a();
        boolean z = i == UtilHelper.NetworkStateInfo.WIFI || i == UtilHelper.NetworkStateInfo.ThreeG;
        this.f934a.i().a(z);
        int g = this.f934a.g();
        this.f934a.i().a();
        int i2 = 0;
        for (int f = this.f934a.f(); f < this.f934a.h().getCount(); f++) {
            if (z || f <= g) {
                if ((this.f934a.h().getItem(f) instanceof com.baidu.tieba.data.a.g) && i2 < 13 && (c = ((com.baidu.tieba.data.a.g) this.f934a.h().getItem(f)).c()) != null && !c.equals("")) {
                    i2++;
                    this.f934a.i().b(c, this);
                }
                if (i2 >= 30) {
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
        this.f934a.a(i);
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        this.f934a.c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, android.app.Activity
    public void onStop() {
        super.onStop();
        this.f934a.d();
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
        this.f934a.a(new r(this));
        this.f934a.e();
    }

    @Override // com.baidu.tbadk.a.d
    public void a(com.baidu.adp.widget.a.b bVar, String str, boolean z) {
        ImageView imageView;
        if (bVar != null && this.f934a.j() != null && (imageView = (ImageView) this.f934a.j().findViewWithTag(str)) != null) {
            bVar.a(imageView);
            imageView.invalidate();
        }
    }

    public void b() {
        this.d = new Handler();
        this.e = new s(this);
    }
}
