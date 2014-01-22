package com.baidu.tieba.im;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tieba.im.message.cr;
import com.baidu.tieba.im.message.q;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class NetWorkDebugActivity extends Activity implements com.baidu.tieba.im.messageCenter.g {
    public static NetWorkDebugActivity a;
    LinearLayout b;
    TextView c;
    EditText d;
    Handler e = new c(this);

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_main);
        a = this;
        this.b = (LinearLayout) findViewById(R.id.action_layout);
        this.c = (TextView) findViewById(R.id.tv);
        this.d = new EditText(this);
        this.b.addView(this.d, new LinearLayout.LayoutParams(-2, -2));
        this.d.setText(j.a);
        com.baidu.tieba.im.messageCenter.e.a().a(1001, this);
        com.baidu.tieba.im.messageCenter.e.a().a(202001, this);
        a("closeConnect", new d(this));
        b();
        c();
        a();
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        com.baidu.tieba.im.messageCenter.e.a().a(this);
    }

    private void a() {
        a("send msg", new e(this));
    }

    private void b() {
        a("conncet", new f(this));
    }

    private void c() {
        a("Online", new g(this));
    }

    private void a(String str, View.OnClickListener onClickListener) {
        Button button = new Button(this);
        button.setText(str);
        button.setOnClickListener(onClickListener);
        this.b.addView(button, new LinearLayout.LayoutParams(-2, -2));
    }

    public static void a(String str) {
        if (a != null) {
            a.e.sendMessage(a.e.obtainMessage(0, str));
        }
    }

    @Override // com.baidu.tieba.im.messageCenter.g
    public void a(q qVar) {
        if (qVar instanceof cr) {
            cr crVar = (cr) qVar;
            int l = crVar.l();
            String m = crVar.m();
            if (qVar.w() == 1001) {
                if (crVar.k()) {
                    a("on msg acked:" + crVar + "\nerrCode:" + crVar.l() + "\nerrMsg:" + crVar.m());
                } else {
                    a("failed to send msg:" + qVar + "\nerrCode:" + l + "\nerrMsg:" + m);
                }
            } else if (qVar.w() == 202001) {
                if (crVar.k()) {
                    a("failed to send msg:" + qVar + "\nerrCode:" + l + "\nerrMsg:" + m);
                } else {
                    a("on msg acked:" + crVar);
                }
            } else if (qVar.w() == 205001) {
                if (crVar.k()) {
                    a("failed to send msg:" + qVar + "\nerrCode:" + l + "\nerrMsg:" + m);
                } else {
                    a("on msg acked:" + crVar);
                }
            }
        }
    }
}
