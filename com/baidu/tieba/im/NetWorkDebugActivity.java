package com.baidu.tieba.im;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tieba.im.message.Message;
import com.baidu.tieba.im.message.ResponsedMessage;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class NetWorkDebugActivity extends Activity implements com.baidu.tieba.im.messageCenter.h {

    /* renamed from: a  reason: collision with root package name */
    public static NetWorkDebugActivity f1463a;
    LinearLayout b;
    TextView c;
    EditText d;
    Handler e = new c(this);

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_main);
        f1463a = this;
        this.b = (LinearLayout) findViewById(R.id.action_layout);
        this.c = (TextView) findViewById(R.id.tv);
        this.d = new EditText(this);
        this.b.addView(this.d, new LinearLayout.LayoutParams(-2, -2));
        this.d.setText(j.f1713a);
        com.baidu.tieba.im.messageCenter.f.a().a(1001, this);
        com.baidu.tieba.im.messageCenter.f.a().a(202001, this);
        a("closeConnect", new d(this));
        b();
        c();
        a();
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        com.baidu.tieba.im.messageCenter.f.a().a(this);
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
        if (f1463a != null) {
            f1463a.e.sendMessage(f1463a.e.obtainMessage(0, str));
        }
    }

    @Override // com.baidu.tieba.im.messageCenter.h
    public void a(Message message) {
        if (message instanceof ResponsedMessage) {
            ResponsedMessage responsedMessage = (ResponsedMessage) message;
            int errNo = responsedMessage.getErrNo();
            String errMsg = responsedMessage.getErrMsg();
            if (message.getCmd() == 1001) {
                if (responsedMessage.hasError()) {
                    a("on msg acked:" + responsedMessage + "\nerrCode:" + responsedMessage.getErrNo() + "\nerrMsg:" + responsedMessage.getErrMsg());
                } else {
                    a("failed to send msg:" + message + "\nerrCode:" + errNo + "\nerrMsg:" + errMsg);
                }
            } else if (message.getCmd() == 202001) {
                if (responsedMessage.hasError()) {
                    a("failed to send msg:" + message + "\nerrCode:" + errNo + "\nerrMsg:" + errMsg);
                } else {
                    a("on msg acked:" + responsedMessage);
                }
            }
        }
    }
}
