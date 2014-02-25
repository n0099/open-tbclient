package com.baidu.tieba.im.groupInfo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.bq;
import com.baidu.tieba.view.NavigationBar;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class ApplyJoinGroupActivity extends com.baidu.tieba.f implements com.baidu.tieba.im.messageCenter.g {
    public static int p = 0;
    public static int q = 1;
    View a;
    EditText b;
    TextView c;
    TextView d;
    ImageView e;
    TextView f;
    Button g;
    Button h;
    View.OnClickListener i;
    TextWatcher j;
    String k;
    int l;
    int m;
    long n;
    String o;
    int r;
    private NavigationBar s = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        b();
        c();
        a();
        d();
    }

    private void d() {
        e();
    }

    private void e() {
        if (this.m == 0 && this.l == 0) {
            this.d.setText("");
            return;
        }
        String string = getString(R.string.group_join_limit_str1);
        String valueOf = String.valueOf(this.l);
        String string2 = getString(R.string.group_join_limit_str3);
        String valueOf2 = String.valueOf(this.m);
        String string3 = getString(R.string.group_join_limit_str5);
        int i = f() ? R.color.edit_exceed_1 : R.color.edit_exceed;
        int i2 = f() ? R.color.edit_normal_1 : R.color.edit_normal;
        SpannableString a = a(valueOf, getResources().getColor(i));
        SpannableString a2 = a(valueOf2, getResources().getColor(i));
        this.d.setTextColor(getResources().getColor(i2));
        this.d.setText("");
        this.d.append(string);
        this.d.append(a);
        this.d.append(string2);
        this.d.append(a2);
        this.d.append(string3);
        this.d.setVisibility(0);
    }

    public static SpannableString a(String str, int i) {
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new ForegroundColorSpan(i), 0, str.length(), 33);
        return spannableString;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f, android.app.Activity
    public void onPause() {
        super.onPause();
        com.baidu.tieba.im.messageCenter.e.a().a(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f, android.app.Activity
    public void onResume() {
        super.onResume();
        com.baidu.tieba.im.messageCenter.e.a().a(103110, this);
        if (TextUtils.isEmpty(this.b.getText())) {
            this.f.setEnabled(false);
        } else {
            this.f.setEnabled(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f, com.baidu.adp.a.a, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.b != null) {
            this.b.removeTextChangedListener(this.j);
        }
    }

    public static void a(Context context, String str, int i, int i2) {
        if (context != null) {
            Intent intent = new Intent(context, ApplyJoinGroupActivity.class);
            intent.putExtra("groupID", str);
            intent.putExtra("alreadJoinCount", i);
            intent.putExtra("canJoinCount", i2);
            com.baidu.adp.lib.util.f.e("get intent groupID:" + str);
            context.startActivity(intent);
        }
    }

    public static void a(Context context, String str, int i, int i2, long j, String str2) {
        if (context != null) {
            Intent intent = new Intent(context, ApplyJoinGroupActivity.class);
            intent.putExtra("groupID", str);
            intent.putExtra("alreadJoinCount", i);
            intent.putExtra("canJoinCount", i2);
            intent.putExtra("inviteUserId", j);
            intent.putExtra("defaultUserMsg", str2);
            intent.putExtra("joinType", q);
            com.baidu.adp.lib.util.f.e("get intent groupID:" + str);
            context.startActivity(intent);
        }
    }

    public static void a(Context context, String str, long j, String str2) {
        if (context != null) {
            Intent intent = new Intent(context, ApplyJoinGroupActivity.class);
            intent.putExtra("groupID", str);
            intent.putExtra("inviteUserId", j);
            intent.putExtra("defaultUserMsg", str2);
            intent.putExtra("joinType", q);
            com.baidu.adp.lib.util.f.e("get intent groupID:" + str);
            context.startActivity(intent);
        }
    }

    void a() {
        this.a = View.inflate(this, R.layout.group_apply_activity, null);
        setContentView(this.a);
        this.s = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.s.a(R.string.group_apply_join);
        this.e = this.s.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f = this.s.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getString(R.string.group_apply_send));
        this.e.setOnClickListener(this.i);
        this.b = (EditText) this.a.findViewById(R.id.et_content);
        this.b.setText(this.o);
        this.c = (TextView) this.a.findViewById(R.id.tv_word_count);
        int length = 30 - this.o.length();
        if (length < 0) {
            length = 0;
        }
        this.c.setText(String.valueOf(length) + "/30");
        this.d = (TextView) this.a.findViewById(R.id.tv_add_limit);
        this.d.setVisibility(8);
        this.f.setOnClickListener(this.i);
        this.g = (Button) this.a.findViewById(R.id.btn_agree);
        this.g.setOnClickListener(this.i);
        this.h = (Button) this.a.findViewById(R.id.btn_disagree);
        this.h.setOnClickListener(this.i);
        this.g.setVisibility(8);
        this.h.setVisibility(8);
        this.b.addTextChangedListener(this.j);
        ShowSoftKeyPadDelay(this.b, 500);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().a(i == 1);
        getLayoutMode().a(this.a);
        this.s.c(i);
        bq.g(this.f, 0);
    }

    private boolean f() {
        return TiebaApplication.g().al() == 1;
    }

    void b() {
        Intent intent = getIntent();
        if (intent != null) {
            this.k = intent.getStringExtra("groupID");
            this.l = intent.getIntExtra("alreadJoinCount", 0);
            this.m = intent.getIntExtra("canJoinCount", 0);
            this.n = intent.getLongExtra("inviteUserId", 0L);
            this.o = intent.getStringExtra("defaultUserMsg");
            this.r = intent.getIntExtra("joinType", p);
        }
        if (this.o == null) {
            this.o = "";
        }
    }

    void c() {
        this.j = new a(this);
        this.i = new b(this);
    }

    @Override // com.baidu.tieba.im.messageCenter.g
    public void a(com.baidu.tieba.im.message.s sVar) {
        if (sVar != null && (sVar instanceof ak)) {
            ak akVar = (ak) sVar;
            int m = akVar.m();
            String n = akVar.n();
            if (akVar.l()) {
                String string = TextUtils.isEmpty(n) ? getString(R.string.group_apply_fail) : n;
                com.baidu.adp.lib.util.f.e("apply add group" + sVar.toString() + "err:" + m + " errMsg" + string);
                this.f.setEnabled(true);
                showToast(string);
                return;
            }
            if (TextUtils.isEmpty(n)) {
                n = getString(R.string.group_apply_succ);
            }
            showToast(n, false);
            if (m == 0) {
                v.a(TiebaApplication.A(), this.k, true);
                finish();
            }
        }
    }
}
