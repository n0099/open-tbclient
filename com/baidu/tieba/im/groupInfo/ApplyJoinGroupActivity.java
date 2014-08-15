package com.baidu.tieba.im.groupInfo;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.NavigationBar;
/* loaded from: classes.dex */
public class ApplyJoinGroupActivity extends BaseActivity {
    View a;
    EditText b;
    TextView c;
    TextView d;
    View e;
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
    int p;
    private NavigationBar q = null;
    private com.baidu.adp.framework.listener.d r = new a(this, 103110);

    static {
        d();
    }

    private static void d() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2008014, new b());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        b();
        c();
        a();
        e();
    }

    private void e() {
        f();
    }

    private void f() {
        if (this.m == 0 && this.l == 0) {
            this.d.setText("");
            return;
        }
        String string = getString(com.baidu.tieba.x.group_join_limit_str1);
        String valueOf = String.valueOf(this.l);
        String string2 = getString(com.baidu.tieba.x.group_join_limit_str3);
        String valueOf2 = String.valueOf(this.m);
        String string3 = getString(com.baidu.tieba.x.group_join_limit_str5);
        int i = g() ? com.baidu.tieba.r.edit_exceed_1 : com.baidu.tieba.r.edit_exceed;
        int i2 = g() ? com.baidu.tieba.r.edit_normal_1 : com.baidu.tieba.r.edit_normal;
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
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        MessageManager.getInstance().unRegisterListener(this.r);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        registerListener(this.r);
        if (TextUtils.isEmpty(this.b.getText())) {
            this.f.setEnabled(false);
        } else {
            this.f.setEnabled(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.b != null) {
            this.b.removeTextChangedListener(this.j);
        }
    }

    void a() {
        this.a = View.inflate(this, com.baidu.tieba.v.group_apply_activity, null);
        setContentView(this.a);
        this.q = (NavigationBar) findViewById(com.baidu.tieba.u.view_navigation_bar);
        this.q.a(com.baidu.tieba.x.group_apply_join);
        this.e = this.q.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f = this.q.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getString(com.baidu.tieba.x.group_apply_send));
        this.e.setOnClickListener(this.i);
        this.b = (EditText) this.a.findViewById(com.baidu.tieba.u.et_content);
        this.b.setText(this.o);
        this.b.setSelection(this.o.length());
        this.c = (TextView) this.a.findViewById(com.baidu.tieba.u.tv_word_count);
        int length = 30 - this.o.length();
        if (length < 0) {
            length = 0;
        }
        this.c.setText(String.valueOf(length) + "/30");
        this.d = (TextView) this.a.findViewById(com.baidu.tieba.u.tv_add_limit);
        this.d.setVisibility(8);
        this.f.setOnClickListener(this.i);
        this.g = (Button) this.a.findViewById(com.baidu.tieba.u.btn_agree);
        this.g.setOnClickListener(this.i);
        this.h = (Button) this.a.findViewById(com.baidu.tieba.u.btn_disagree);
        this.h.setOnClickListener(this.i);
        this.g.setVisibility(8);
        this.h.setVisibility(8);
        this.b.addTextChangedListener(this.j);
        ShowSoftKeyPadDelay(this.b, 500);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().a(i == 1);
        getLayoutMode().a(this.a);
        this.q.c(i);
        ay.f(this.f, 0);
    }

    private boolean g() {
        return TbadkApplication.m252getInst().getSkinType() == 1;
    }

    void b() {
        Intent intent = getIntent();
        if (intent != null) {
            this.k = intent.getStringExtra("groupID");
            this.l = intent.getIntExtra("alreadJoinCount", 0);
            this.m = intent.getIntExtra("canJoinCount", 0);
            this.n = intent.getLongExtra("inviteUserId", 0L);
            this.o = intent.getStringExtra("defaultUserMsg");
            this.p = intent.getIntExtra("joinType", com.baidu.tbadk.core.atomData.c.a);
        }
        if (this.o == null) {
            this.o = "";
        }
    }

    void c() {
        this.j = new c(this);
        this.i = new d(this);
    }
}
