package com.baidu.tieba.chat;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.account.LoginActivity;
import com.baidu.tieba.data.chat.ChatData;
import com.baidu.tieba.data.chat.ChatMessageData;
import com.baidu.tieba.data.chat.ChatPostData;
import com.baidu.tieba.person.PersonInfoActivity;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.view.HeadImageView;
import com.baidu.tieba.view.ao;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class ChatActivity extends com.baidu.tieba.j implements com.baidu.tbadk.widget.richText.h {

    /* renamed from: a  reason: collision with root package name */
    private ai f1083a = null;
    private ab b = null;
    private af c = null;
    private ChatMessageData d = null;
    private boolean e = false;
    private boolean f = false;
    private boolean g = false;
    private Handler j = null;
    private com.baidu.adp.lib.d.b<TextView> k = TbRichTextView.a(this, 8);
    private com.baidu.adp.lib.d.b<ImageView> l = new com.baidu.adp.lib.d.b<>(new a(this), 8, 0);
    private Runnable m = new b(this);
    private DialogInterface.OnClickListener n = new c(this);
    private com.baidu.adp.widget.ListView.b o = new d(this);
    private ah p = new e(this);
    private ad q = new g(this);
    private ao r = new h(this);

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
    @Override // com.baidu.tieba.j, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.j = new Handler();
        r();
        a(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onPause() {
        super.onPause();
        this.j.removeCallbacks(this.m);
        this.e = true;
        if (this.f) {
            com.baidu.tieba.mention.t.a().i();
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
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onResume() {
        super.onResume();
        this.e = false;
        this.j.removeCallbacks(this.m);
        if (this.g) {
            this.j.post(this.m);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.b.cancelLoadData();
        this.c.cancelLoadData();
        this.f1083a.s();
        this.j.removeCallbacks(this.m);
    }

    @Override // com.baidu.adp.a.a, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
    }

    @Override // com.baidu.adp.a.a, android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        if (view.getId() == this.f1083a.v()) {
            this.d = (ChatMessageData) view.getTag();
            if (this.d != null) {
                this.f1083a.a(this.n);
            }
            return true;
        }
        return false;
    }

    @Override // com.baidu.adp.a.a, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f1083a.a()) {
            h();
        } else if (view == this.f1083a.e()) {
            this.f1083a.p();
        } else if (view == this.f1083a.f()) {
            String C = TiebaApplication.C();
            if (C == null || C.length() <= 0) {
                LoginActivity.a((Activity) this, getString(R.string.login_to_use), true, 11031);
            } else {
                n();
            }
        } else if (view.getId() == this.f1083a.g()) {
            String userId = ((HeadImageView) view).getUserId();
            if (userId != null) {
                PersonInfoActivity.a(this, userId, null);
            }
        } else if (view == this.f1083a.h()) {
            String C2 = TiebaApplication.C();
            if (C2 == null || C2.length() <= 0) {
                LoginActivity.a((Activity) this, getString(R.string.login_to_use), true, 11032);
            } else {
                o();
            }
        }
    }

    private void n() {
        ChatPostData chatPostData = new ChatPostData();
        String m = this.f1083a.m();
        chatPostData.setFriendID(this.b.b());
        chatPostData.setUserID(this.b.c());
        chatPostData.setConent(m);
        chatPostData.setLastMsgID(this.b.d());
        this.c.a(chatPostData);
        this.c.LoadData();
    }

    private void o() {
        this.f1083a.q();
        if (this.b.g()) {
            this.f1083a.n();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        if (!this.b.j()) {
            this.j.removeCallbacks(this.m);
            this.j.postDelayed(this.m, 30000L);
        }
    }

    private void q() {
        if (!this.b.i()) {
            this.j.removeCallbacks(this.m);
            this.j.postDelayed(this.m, 0L);
        }
    }

    @Override // com.baidu.adp.a.a, android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        ChatData a2 = this.b.a();
        if (a2 != null) {
            this.d = a2.getMsg(i);
            if (this.d != null) {
                this.f1083a.a(this.n);
                return true;
            }
            return true;
        }
        return true;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<ImageView> c() {
        return this.l;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<TextView> d() {
        return this.k;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j
    public void a(int i) {
        this.f1083a.a(i);
    }

    private void r() {
        this.f1083a = new ai(this);
        this.f1083a.a(this.o);
        this.f1083a.a(this.r);
    }

    private void a(Bundle bundle) {
        this.b = new ab();
        if (bundle == null) {
            this.b.a(getIntent());
        } else {
            this.b.a(bundle);
        }
        this.f1083a.a(this.b.a());
        this.b.a(this.q);
        this.c = new af();
        this.c.a(this.p);
        String C = TiebaApplication.C();
        if (C == null || C.length() <= 0) {
            LoginActivity.a((Activity) this, getString(R.string.login_to_use), true, 11023);
        } else {
            q();
        }
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public ListView a() {
        return this.f1083a.u();
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public int b() {
        return this.f1083a.v();
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void a(Context context, String str) {
        PersonInfoActivity.a(this, str, null);
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void b(Context context, String str) {
        UtilHelper.c(this, str);
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void c(Context context, String str) {
        UtilHelper.c(this, str);
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
                case 11023:
                    q();
                    return;
                case 11029:
                    p();
                    return;
                case 11031:
                    n();
                    return;
                case 11032:
                    o();
                    return;
                default:
                    return;
            }
        }
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void a(Context context, String str, String str2) {
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<View> e() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<LinearLayout> f() {
        return null;
    }
}
