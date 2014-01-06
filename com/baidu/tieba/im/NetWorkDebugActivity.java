package com.baidu.tieba.im;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tieba.im.message.cc;
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
    public void a(com.baidu.tieba.im.message.o oVar) {
        if (oVar instanceof cc) {
            cc ccVar = (cc) oVar;
            int j = ccVar.j();
            String k = ccVar.k();
            if (oVar.u() == 1001) {
                if (ccVar.i()) {
                    a("on msg acked:" + ccVar + "\nerrCode:" + ccVar.j() + "\nerrMsg:" + ccVar.k());
                } else {
                    a("failed to send msg:" + oVar + "\nerrCode:" + j + "\nerrMsg:" + k);
                }
            } else if (oVar.u() == 202001) {
                if (ccVar.i()) {
                    a("failed to send msg:" + oVar + "\nerrCode:" + j + "\nerrMsg:" + k);
                } else {
                    a("on msg acked:" + ccVar);
                }
            } else if (oVar.u() == 205001) {
                if (ccVar.i()) {
                    a("failed to send msg:" + oVar + "\nerrCode:" + j + "\nerrMsg:" + k);
                } else {
                    a("on msg acked:" + ccVar);
                }
            }
        }
    }
}
