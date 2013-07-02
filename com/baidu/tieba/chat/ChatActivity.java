package com.baidu.tieba.chat;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.account.LoginActivity;
import com.baidu.tieba.person.PersonInfoActivity;
import com.baidu.tieba.view.HeadImageView;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class ChatActivity extends com.baidu.tieba.g implements com.baidu.tbadk.widget.richText.h {
    private ad a = null;
    private w b = null;
    private aa c = null;
    private com.baidu.tieba.data.a.d d = null;
    private boolean e = false;
    private boolean f = false;
    private boolean g = false;
    private Handler j = null;
    private com.baidu.adp.lib.a.b k = TbRichTextView.a(this, 8);
    private com.baidu.adp.lib.a.b l = new com.baidu.adp.lib.a.b(new a(this), 8, 0);
    private Runnable m = new b(this);
    private DialogInterface.OnClickListener n = new c(this);
    private com.baidu.adp.widget.ListView.b o = new d(this);
    private ac p = new e(this);
    private y q = new g(this);
    private com.baidu.tieba.view.ae r = new h(this);

    public static void a(Context context, String str, String str2, String str3, String str4, String str5) {
        if (str != null && str.length() >= 1) {
            Intent intent = new Intent(context, ChatActivity.class);
            intent.putExtra("chat_com_id", str);
            intent.putExtra("chat_com_name", str2);
            intent.putExtra("chat_st_type", str5);
            intent.putExtra("chat_com_portrait", str3);
            intent.putExtra("chat_my_portrait", str4);
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            context.startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.j = new Handler();
        q();
        a(bundle);
        a(R.drawable.tips_chat_page, 3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, android.app.Activity
    public void onPause() {
        super.onPause();
        this.j.removeCallbacks(this.m);
        this.e = true;
        if (this.f) {
            TiebaApplication.f().ab();
            this.f = false;
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.b != null) {
            this.b.b(bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, android.app.Activity
    public void onResume() {
        super.onResume();
        this.e = false;
        this.j.removeCallbacks(this.m);
        if (this.g) {
            this.j.post(this.m);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.b.cancelLoadData();
        this.c.cancelLoadData();
        this.a.p();
        this.j.removeCallbacks(this.m);
    }

    @Override // com.baidu.adp.a.a, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
    }

    @Override // com.baidu.adp.a.a, android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        if (view.getId() == this.a.s()) {
            this.d = (com.baidu.tieba.data.a.d) view.getTag();
            if (this.d != null) {
                this.a.a(this.n);
            }
            return true;
        }
        return false;
    }

    @Override // com.baidu.adp.a.a, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.a.a()) {
            f();
        } else if (view == this.a.b()) {
            this.a.m();
        } else if (view == this.a.c()) {
            String E = TiebaApplication.E();
            if (E == null || E.length() <= 0) {
                LoginActivity.a((Activity) this, getString(R.string.login_to_use), true, 1100031);
            } else {
                m();
            }
        } else if (view.getId() == this.a.d()) {
            String userId = ((HeadImageView) view).getUserId();
            if (userId != null) {
                PersonInfoActivity.a(this, userId, null);
            }
        } else if (view == this.a.e()) {
            String E2 = TiebaApplication.E();
            if (E2 == null || E2.length() <= 0) {
                LoginActivity.a((Activity) this, getString(R.string.login_to_use), true, 1100032);
            } else {
                n();
            }
        }
    }

    private void m() {
        com.baidu.tieba.data.a.e eVar = new com.baidu.tieba.data.a.e();
        String j = this.a.j();
        eVar.b(this.b.b());
        eVar.c(this.b.c());
        eVar.a(j);
        eVar.a(this.b.d());
        this.c.a(eVar);
        this.c.LoadData();
    }

    private void n() {
        this.a.n();
        if (this.b.g()) {
            this.a.k();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        if (!this.b.j()) {
            this.j.removeCallbacks(this.m);
            this.j.postDelayed(this.m, 30000L);
        }
    }

    private void p() {
        if (!this.b.i()) {
            this.j.removeCallbacks(this.m);
            this.j.postDelayed(this.m, 0L);
        }
    }

    @Override // com.baidu.adp.a.a, android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView adapterView, View view, int i, long j) {
        com.baidu.tieba.data.a.c a = this.b.a();
        if (a != null) {
            this.d = a.a(i);
            if (this.d != null) {
                this.a.a(this.n);
                return true;
            }
            return true;
        }
        return true;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.a.b c() {
        return this.l;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.a.b d() {
        return this.k;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g
    public void a(int i) {
        this.a.a(i);
    }

    private void q() {
        this.a = new ad(this);
        this.a.a(this.o);
        this.a.a(this.r);
    }

    private void a(Bundle bundle) {
        this.b = new w();
        if (bundle == null) {
            this.b.a(getIntent());
        } else {
            this.b.a(bundle);
        }
        this.a.a(this.b.a());
        this.b.a(this.q);
        this.c = new aa();
        this.c.a(this.p);
        String E = TiebaApplication.E();
        if (E == null || E.length() <= 0) {
            LoginActivity.a((Activity) this, getString(R.string.login_to_use), true, 11000230);
        } else {
            p();
        }
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public ListView a() {
        return this.a.r();
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public int b() {
        return this.a.s();
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void a(Context context, String str) {
        PersonInfoActivity.a(this, str, null);
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void b(Context context, String str) {
        com.baidu.tieba.util.ab.c(this, str);
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void c(Context context, String str) {
        com.baidu.tieba.util.ab.c(this, str);
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void e(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void d(Context context, String str) {
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 1100029:
                    o();
                    return;
                case 1100031:
                    m();
                    return;
                case 1100032:
                    n();
                    return;
                case 11000230:
                    p();
                    return;
                default:
                    return;
            }
        }
    }
}
