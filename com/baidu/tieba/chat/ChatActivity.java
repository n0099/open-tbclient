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
public class ChatActivity extends com.baidu.tieba.e implements com.baidu.tbadk.widget.richText.h {
    private ad c = null;
    private w d = null;
    private aa e = null;
    private com.baidu.tieba.a.a.d f = null;
    private boolean g = false;
    private boolean h = false;
    private boolean i = false;
    private Handler j = null;
    private com.baidu.adp.lib.c.b k = TbRichTextView.a(this, 8);
    private com.baidu.adp.lib.c.b l = new com.baidu.adp.lib.c.b(new a(this), 8, 0);
    private Runnable m = new b(this);
    private DialogInterface.OnClickListener n = new c(this);
    private com.baidu.adp.widget.ListView.b o = new d(this);
    private ac p = new e(this);
    private y q = new g(this);
    private com.baidu.tieba.view.af r = new h(this);

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
    @Override // com.baidu.tieba.e, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.j = new Handler();
        q();
        a(bundle);
        a(R.drawable.tips_chat_page, 3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onPause() {
        super.onPause();
        this.j.removeCallbacks(this.m);
        this.g = true;
        if (this.h) {
            TiebaApplication.d().Z();
            this.h = false;
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.d != null) {
            this.d.b(bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onResume() {
        super.onResume();
        this.g = false;
        this.j.removeCallbacks(this.m);
        if (this.i) {
            this.j.post(this.m);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.d.o();
        this.e.e();
        this.c.p();
        this.j.removeCallbacks(this.m);
    }

    @Override // com.baidu.adp.a.a, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
    }

    @Override // com.baidu.adp.a.a, android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        if (view.getId() == this.c.s()) {
            this.f = (com.baidu.tieba.a.a.d) view.getTag();
            if (this.f != null) {
                this.c.a(this.n);
            }
            return true;
        }
        return false;
    }

    @Override // com.baidu.adp.a.a, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.c.a()) {
            f();
        } else if (view == this.c.b()) {
            this.c.m();
        } else if (view == this.c.c()) {
            String B = TiebaApplication.B();
            if (B == null || B.length() <= 0) {
                LoginActivity.a((Activity) this, getString(R.string.login_to_use), true, 1100031);
            } else {
                m();
            }
        } else if (view.getId() == this.c.d()) {
            String userId = ((HeadImageView) view).getUserId();
            if (userId != null) {
                PersonInfoActivity.a(this, userId, null);
            }
        } else if (view == this.c.e()) {
            String B2 = TiebaApplication.B();
            if (B2 == null || B2.length() <= 0) {
                LoginActivity.a((Activity) this, getString(R.string.login_to_use), true, 1100032);
            } else {
                n();
            }
        }
    }

    private void m() {
        com.baidu.tieba.a.a.e eVar = new com.baidu.tieba.a.a.e();
        String j = this.c.j();
        eVar.b(this.d.e());
        eVar.c(this.d.f());
        eVar.a(j);
        eVar.a(this.d.g());
        this.e.a(eVar);
        this.e.d();
    }

    private void n() {
        this.c.n();
        if (this.d.j()) {
            this.c.k();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        if (!this.d.m()) {
            this.j.removeCallbacks(this.m);
            this.j.postDelayed(this.m, 30000L);
        }
    }

    private void p() {
        if (!this.d.l()) {
            this.j.removeCallbacks(this.m);
            this.j.postDelayed(this.m, 0L);
        }
    }

    @Override // com.baidu.adp.a.a, android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView adapterView, View view, int i, long j) {
        com.baidu.tieba.a.a.c d = this.d.d();
        if (d != null) {
            this.f = d.a(i);
            if (this.f != null) {
                this.c.a(this.n);
                return true;
            }
            return true;
        }
        return true;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.c.b c() {
        return this.l;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.c.b d() {
        return this.k;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e
    public void b(int i) {
        this.c.a(i);
    }

    private void q() {
        this.c = new ad(this);
        this.c.a(this.o);
        this.c.a(this.r);
    }

    private void a(Bundle bundle) {
        this.d = new w();
        if (bundle == null) {
            this.d.a(getIntent());
        } else {
            this.d.a(bundle);
        }
        this.c.a(this.d.d());
        this.d.a(this.q);
        this.e = new aa();
        this.e.a(this.p);
        String B = TiebaApplication.B();
        if (B == null || B.length() <= 0) {
            LoginActivity.a((Activity) this, getString(R.string.login_to_use), true, 11000230);
        } else {
            p();
        }
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public ListView a() {
        return this.c.r();
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public int b() {
        return this.c.s();
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void a(Context context, String str) {
        PersonInfoActivity.a(this, str, null);
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void b(Context context, String str) {
        com.baidu.tieba.d.ag.c(this, str);
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void c(Context context, String str) {
        com.baidu.tieba.d.ag.c(this, str);
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
