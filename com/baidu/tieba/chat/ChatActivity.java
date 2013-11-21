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
public class ChatActivity extends com.baidu.tieba.j implements com.baidu.tbadk.widget.richText.i {

    /* renamed from: a  reason: collision with root package name */
    private ai f1122a = null;
    private ab b = null;
    private af c = null;
    private ChatMessageData d = null;
    private boolean e = false;
    private boolean f = false;
    private boolean g = false;
    private Handler h = null;
    private com.baidu.adp.lib.d.b<TextView> i = TbRichTextView.a(this, 8);
    private com.baidu.adp.lib.d.b<ImageView> j = new com.baidu.adp.lib.d.b<>(new a(this), 8, 0);
    private Runnable k = new b(this);
    private DialogInterface.OnClickListener l = new c(this);
    private com.baidu.adp.widget.ListView.b m = new d(this);
    private ah n = new e(this);
    private ad o = new g(this);
    private ao p = new h(this);

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
        this.h = new Handler();
        k();
        a(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onPause() {
        super.onPause();
        this.h.removeCallbacks(this.k);
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
        this.h.removeCallbacks(this.k);
        if (this.g) {
            this.h.post(this.k);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.b.cancelLoadData();
        this.c.cancelLoadData();
        this.f1122a.s();
        this.h.removeCallbacks(this.k);
    }

    @Override // com.baidu.adp.a.a, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
    }

    @Override // com.baidu.adp.a.a, android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        if (view.getId() == this.f1122a.v()) {
            this.d = (ChatMessageData) view.getTag();
            if (this.d != null) {
                this.f1122a.a(this.l);
            }
            return true;
        }
        return false;
    }

    @Override // com.baidu.adp.a.a, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f1122a.a()) {
            closeActivity();
        } else if (view == this.f1122a.e()) {
            this.f1122a.p();
        } else if (view == this.f1122a.f()) {
            String A = TiebaApplication.A();
            if (A == null || A.length() <= 0) {
                LoginActivity.a((Activity) this, getString(R.string.login_to_use), true, 11031);
            } else {
                a();
            }
        } else if (view.getId() == this.f1122a.g()) {
            String userId = ((HeadImageView) view).getUserId();
            if (userId != null) {
                PersonInfoActivity.a(this, userId, (String) null);
            }
        } else if (view == this.f1122a.h()) {
            String A2 = TiebaApplication.A();
            if (A2 == null || A2.length() <= 0) {
                LoginActivity.a((Activity) this, getString(R.string.login_to_use), true, 11032);
            } else {
                b();
            }
        }
    }

    private void a() {
        ChatPostData chatPostData = new ChatPostData();
        String m = this.f1122a.m();
        chatPostData.setFriendID(this.b.b());
        chatPostData.setUserID(this.b.c());
        chatPostData.setConent(m);
        chatPostData.setLastMsgID(this.b.d());
        this.c.a(chatPostData);
        this.c.LoadData();
    }

    private void b() {
        this.f1122a.q();
        if (this.b.g()) {
            this.f1122a.n();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        if (!this.b.j()) {
            this.h.removeCallbacks(this.k);
            this.h.postDelayed(this.k, 30000L);
        }
    }

    private void j() {
        if (!this.b.i()) {
            this.h.removeCallbacks(this.k);
            this.h.postDelayed(this.k, 0L);
        }
    }

    @Override // com.baidu.adp.a.a, android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        ChatData a2 = this.b.a();
        if (a2 != null) {
            this.d = a2.getMsg(i);
            if (this.d != null) {
                this.f1122a.a(this.l);
                return true;
            }
            return true;
        }
        return true;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<ImageView> e() {
        return this.j;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<TextView> f() {
        return this.i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j
    public void onChangeSkinType(int i) {
        this.f1122a.a(i);
    }

    private void k() {
        this.f1122a = new ai(this);
        this.f1122a.a(this.m);
        this.f1122a.a(this.p);
    }

    private void a(Bundle bundle) {
        this.b = new ab();
        if (bundle == null) {
            this.b.a(getIntent());
        } else {
            this.b.a(bundle);
        }
        this.f1122a.a(this.b.a());
        this.b.a(this.o);
        this.c = new af();
        this.c.a(this.n);
        String A = TiebaApplication.A();
        if (A == null || A.length() <= 0) {
            LoginActivity.a((Activity) this, getString(R.string.login_to_use), true, 11023);
        } else {
            j();
        }
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public ListView c() {
        return this.f1122a.u();
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public int d() {
        return this.f1122a.v();
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void a(Context context, String str) {
        PersonInfoActivity.a(this, str, (String) null);
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void b(Context context, String str) {
        UtilHelper.c(this, str);
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void c(Context context, String str) {
        UtilHelper.c(this, str);
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void e(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void d(Context context, String str) {
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 11023:
                    j();
                    return;
                case 11029:
                    i();
                    return;
                case 11031:
                    a();
                    return;
                case 11032:
                    b();
                    return;
                default:
                    return;
            }
        }
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void a(Context context, String str, String str2) {
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<View> d_() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<LinearLayout> h() {
        return null;
    }
}
