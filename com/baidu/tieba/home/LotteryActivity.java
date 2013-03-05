package com.baidu.tieba.home;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.TextView;
import com.baidu.browser.explorer.BdWebErrorView;
import com.baidu.location.LocationClientOption;
import com.baidu.loginshare.Token;
import com.baidu.tieba.R;
import com.baidu.tieba.account.LoginActivity;
import com.baidu.tieba.pb.WebActivity;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class LotteryActivity extends WebActivity implements SensorEventListener {
    private static int i = 80;
    private static int j = 15;
    private static int k = LocationClientOption.MIN_SCAN_SPAN;
    private static int l = 4;
    private static int m = BdWebErrorView.ERROR_CODE_500;
    private SensorManager n = null;
    private TextView o = null;
    private Vibrator p = null;
    private long q = 0;
    private float r = 0.0f;
    private float s = 0.0f;
    private float t = 0.0f;
    private int u = 0;
    private long v = 0;
    private boolean w = false;
    private boolean x = true;
    private int y = 0;
    private Pattern z = Pattern.compile("http://.*?baidu.com.*?/f/q.*?/award\\?client=1.*");
    private Pattern A = Pattern.compile("http://.*?baidu.com.*?/f/q.*?m\\?kz=([\\d]*)");
    private Pattern B = Pattern.compile("http://.*?baidu.com.*?/f/q.*?m\\?.*?kw=(.*)");

    public static void a(Context context, String str, String str2, String str3, String str4, String str5) {
        Intent intent = new Intent(context, LotteryActivity.class);
        intent.putExtra("url", str);
        intent.putExtra("bduss", str3);
        intent.putExtra("ptoken", str4);
        intent.putExtra("lottery_url", str2);
        intent.putExtra("tbs", str5);
        context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.WebActivity, com.baidu.tieba.e, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        k();
        View decorView = getWindow().getDecorView();
        if (decorView != null) {
            decorView.measure(0, View.MeasureSpec.makeMeasureSpec(com.baidu.tieba.c.ai.b((Context) this), 1073741824));
            View findViewById = decorView.findViewById(R.id.webview);
            if (findViewById != null) {
                this.y = findViewById.getMeasuredHeight();
            }
            if (this.y > 0 && this.z.matcher(this.e).find()) {
                this.e = com.baidu.tieba.c.ai.a(this.e, "h=" + String.valueOf(this.y));
            }
        }
        this.n = (SensorManager) getSystemService("sensor");
        this.p = (Vibrator) getSystemService("vibrator");
        this.x = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.WebActivity, com.baidu.tieba.e, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    private void k() {
        this.o = (TextView) findViewById(R.id.title_text);
        this.o.setVisibility(0);
        this.o.setText(R.string.lottery);
        j();
        this.d.setBackgroundResource(R.drawable.title_comm);
        this.d.setText(getString(R.string.close));
        a(new aa(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.WebActivity, com.baidu.tieba.e, android.app.Activity
    public void onResume() {
        super.onResume();
        this.n.registerListener(this, this.n.getDefaultSensor(1), 3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.WebActivity, com.baidu.tieba.e, android.app.Activity
    public void onPause() {
        super.onPause();
        this.n.unregisterListener(this);
        this.w = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onStop() {
        super.onStop();
        this.n.unregisterListener(this);
        this.w = false;
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i2) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType() == 1 && sensorEvent.values != null && sensorEvent.values.length >= 3) {
            float f = sensorEvent.values[0];
            float f2 = sensorEvent.values[1];
            float f3 = sensorEvent.values[2];
            float f4 = f - this.r;
            float f5 = f2 - this.s;
            float f6 = f3 - this.t;
            this.r = f;
            this.s = f2;
            this.t = f3;
            if (this.x) {
                if (!this.w) {
                    this.w = true;
                } else if ((f4 * f4) + (f5 * f5) + (f6 * f6) >= i) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - this.v <= m) {
                        this.u++;
                    } else {
                        this.u = 1;
                    }
                    if (Math.abs(f5) >= j || Math.abs(f4) >= j || Math.abs(f6) >= j) {
                        this.u = l;
                    }
                    this.v = currentTimeMillis;
                    if (this.u >= l && currentTimeMillis - this.q > k) {
                        this.q = currentTimeMillis;
                        this.p.vibrate(100L);
                        if (this.f != null && this.f.length() > 0) {
                            l();
                        } else {
                            LoginActivity.a((Activity) this, getString(R.string.login_to_lottery), true, 1100023);
                        }
                    }
                }
            }
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i2, int i3, Intent intent) {
        Token b;
        super.onActivityResult(i2, i3, intent);
        if (i3 == -1) {
            switch (i2) {
                case 1100023:
                    if (intent != null && (b = com.baidu.tieba.account.a.b(intent.getStringExtra("BDUSS"))) != null) {
                        this.f = b.mBduss;
                        this.g = b.mPtoken;
                        i();
                        l();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private void l() {
        String a = com.baidu.tieba.c.ai.a(com.baidu.tieba.c.ai.a(getIntent().getStringExtra("lottery_url"), "tbs=" + getIntent().getStringExtra("tbs")), "h=" + String.valueOf(this.y));
        if (a != null) {
            this.c.loadUrl(a);
            this.o.setText((CharSequence) null);
            this.x = false;
        }
    }
}
