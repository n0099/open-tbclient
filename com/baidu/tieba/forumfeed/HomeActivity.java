package com.baidu.tieba.forumfeed;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.view.bq;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import com.baidu.tieba.BaseFragment;
import com.baidu.tieba.BaseFragmentActivity;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class HomeActivity extends BaseFragment implements bq, RadioGroup.OnCheckedChangeListener {
    private BaseFragmentActivity c;
    private q d;
    private int b = 0;
    public BroadcastReceiver a = new p(this);

    @Override // com.baidu.tieba.BaseFragment, android.support.v4.app.Fragment
    public void a(Activity activity) {
        super.a(activity);
        this.c = (BaseFragmentActivity) activity;
    }

    @Override // com.baidu.tieba.BaseFragment, android.support.v4.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.home_activity, (ViewGroup) null);
    }

    @Override // com.baidu.tieba.BaseFragment, android.support.v4.app.Fragment
    public void a(Bundle bundle) {
        super.a(bundle);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.baidu.tieba.SHOWSQUARE");
        this.c.registerReceiver(this.a, intentFilter);
    }

    @Override // com.baidu.tieba.BaseFragment, android.support.v4.app.Fragment
    public void d(Bundle bundle) {
        super.d(bundle);
        c(bundle);
    }

    @Override // com.baidu.tieba.BaseFragment, android.support.v4.app.Fragment
    public void r() {
        super.r();
    }

    @Override // com.baidu.tieba.BaseFragment, android.support.v4.app.Fragment
    public void t() {
        super.t();
        this.c.unregisterReceiver(this.a);
    }

    @Override // android.support.v4.app.Fragment
    public void e(Bundle bundle) {
        if (this.b != -1) {
            bundle.putInt("type", this.b);
        } else {
            bundle.putInt("type", 0);
        }
        super.e(bundle);
    }

    private void c(Bundle bundle) {
        this.d = new q(this.c, this);
        this.d.e().check(R.id.radio_square);
    }

    private void d(int i) {
        int i2 = 0;
        switch (i) {
            case R.id.radio_square /* 2131100719 */:
                this.d.a().setVisibility(0);
                break;
            case R.id.radio_forumfeed /* 2131100720 */:
                i2 = 1;
                this.d.a().setVisibility(4);
                break;
        }
        if (i2 != this.b) {
            this.b = i2;
            this.d.f().setCurrentItem(i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(int i) {
        int i2 = R.id.radio_square;
        switch (i) {
            case 1:
                i2 = R.id.radio_forumfeed;
                break;
        }
        this.d.e().check(i2);
    }

    @Override // com.baidu.tieba.BaseFragment
    public void c(int i) {
        this.d.a(i);
    }

    @Override // android.support.v4.view.bq
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.bq
    public void onPageSelected(int i) {
        e(i);
    }

    @Override // android.support.v4.view.bq
    public void onPageScrollStateChanged(int i) {
    }

    @Override // android.widget.RadioGroup.OnCheckedChangeListener
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        d(i);
    }
}
