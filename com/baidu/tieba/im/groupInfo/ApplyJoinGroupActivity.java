package com.baidu.tieba.im.groupInfo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.browser.explorer.BdWebErrorView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.message.Message;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class ApplyJoinGroupActivity extends com.baidu.tieba.j implements com.baidu.tieba.im.messageCenter.h {

    /* renamed from: a  reason: collision with root package name */
    View f1588a;
    EditText b;
    TextView c;
    TextView d;
    ImageView e;
    Button f;
    Button g;
    Button j;
    View.OnClickListener k;
    TextWatcher l;
    String m;
    int n;
    int o;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        c();
        d();
        b();
        e();
    }

    private void e() {
        f();
    }

    private void f() {
        this.d.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onPause() {
        super.onPause();
        com.baidu.tieba.im.messageCenter.f.a().a(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onResume() {
        super.onResume();
        com.baidu.tieba.im.messageCenter.f.a().a(103110, this);
        if (TextUtils.isEmpty(this.b.getText())) {
            this.f.setEnabled(false);
        } else {
            this.f.setEnabled(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.b != null) {
            this.b.removeTextChangedListener(this.l);
        }
    }

    public static void a(Context context, String str, int i, int i2) {
        if (context != null) {
            Intent intent = new Intent(context, ApplyJoinGroupActivity.class);
            intent.putExtra("groupID", str);
            intent.putExtra("alreadJoinCount", i);
            intent.putExtra("canJoinCount", i2);
            com.baidu.adp.lib.h.d.d("get intent groupID:" + str);
            context.startActivity(intent);
        }
    }

    void b() {
        this.f1588a = View.inflate(this, R.layout.group_apply_activity, null);
        setContentView(this.f1588a);
        this.e = (ImageView) findViewById(R.id.back);
        this.e.setOnClickListener(this.k);
        this.b = (EditText) this.f1588a.findViewById(R.id.et_content);
        this.c = (TextView) this.f1588a.findViewById(R.id.tv_word_count);
        this.d = (TextView) this.f1588a.findViewById(R.id.tv_add_limit);
        this.d.setVisibility(8);
        this.f = (Button) this.f1588a.findViewById(R.id.btn_send);
        this.f.setOnClickListener(this.k);
        this.g = (Button) this.f1588a.findViewById(R.id.btn_agree);
        this.g.setOnClickListener(this.k);
        this.j = (Button) this.f1588a.findViewById(R.id.btn_disagree);
        this.j.setOnClickListener(this.k);
        this.g.setVisibility(8);
        this.j.setVisibility(8);
        this.b.addTextChangedListener(this.l);
        a(this.b, BdWebErrorView.ERROR_CODE_500);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j
    public void a(int i) {
        super.a(i);
        m().a(i == 1);
        m().a(this.f1588a);
    }

    void c() {
        Intent intent = getIntent();
        if (intent != null) {
            this.m = intent.getStringExtra("groupID");
            this.n = intent.getIntExtra("alreadJoinCount", 0);
            this.o = intent.getIntExtra("canJoinCount", 0);
        }
    }

    void d() {
        this.l = new a(this);
        this.k = new b(this);
    }

    @Override // com.baidu.tieba.im.messageCenter.h
    public void a(Message message) {
        if (message != null && (message instanceof ResponseJoinGroupMessage)) {
            ResponseJoinGroupMessage responseJoinGroupMessage = (ResponseJoinGroupMessage) message;
            int errNo = responseJoinGroupMessage.getErrNo();
            String errMsg = responseJoinGroupMessage.getErrMsg();
            if (responseJoinGroupMessage.hasError()) {
                String string = TextUtils.isEmpty(errMsg) ? getString(R.string.group_apply_fail) : errMsg;
                com.baidu.adp.lib.h.d.d("apply add group" + message.toString() + "err:" + errNo + " errMsg" + string);
                this.f.setEnabled(true);
                a(string);
                return;
            }
            if (TextUtils.isEmpty(errMsg)) {
                errMsg = getString(R.string.group_apply_succ);
            }
            a(errMsg);
            if (errNo == 0) {
                v.a(TiebaApplication.C(), this.m, true);
                finish();
            }
        }
    }
}
