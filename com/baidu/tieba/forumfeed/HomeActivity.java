package com.baidu.tieba.forumfeed;

import android.app.Activity;
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
    private int a = 0;
    private BaseFragmentActivity b;
    private p c;

    @Override // com.baidu.tieba.BaseFragment, android.support.v4.app.Fragment
    public void a(Activity activity) {
        super.a(activity);
        this.b = (BaseFragmentActivity) activity;
    }

    @Override // com.baidu.tieba.BaseFragment, android.support.v4.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.home_activity, (ViewGroup) null);
    }

    @Override // com.baidu.tieba.BaseFragment, android.support.v4.app.Fragment
    public void a(Bundle bundle) {
        super.a(bundle);
        new IntentFilter().addAction("com.baidu.tieba.SHOWSQUARE");
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
    }

    @Override // android.support.v4.app.Fragment
    public void e(Bundle bundle) {
        if (this.a != -1) {
            bundle.putInt("type", this.a);
        } else {
            bundle.putInt("type", 0);
        }
        super.e(bundle);
    }

    private void c(Bundle bundle) {
        this.c = new p(this.b, this);
        this.c.e().check(R.id.radio_square);
    }

    private void d(int i) {
        int i2 = 0;
        switch (i) {
            case R.id.radio_square /* 2131100820 */:
                this.c.a().setVisibility(0);
                break;
            case R.id.radio_forumfeed /* 2131100821 */:
                i2 = 1;
                this.c.a().setVisibility(4);
                break;
        }
        if (i2 != this.a) {
            this.a = i2;
            this.c.f().setCurrentItem(i2);
        }
    }

    private void e(int i) {
        int i2 = R.id.radio_square;
        switch (i) {
            case 1:
                i2 = R.id.radio_forumfeed;
                break;
        }
        this.c.e().check(i2);
    }

    @Override // com.baidu.tieba.BaseFragment
    public void c(int i) {
        this.c.a(i);
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
