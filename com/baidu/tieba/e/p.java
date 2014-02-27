package com.baidu.tieba.e;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import com.baidu.tieba.util.cc;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public final class p extends com.baidu.tieba.j implements ViewPager.OnPageChangeListener, RadioGroup.OnCheckedChangeListener {
    private com.baidu.tieba.k d;
    private s e;
    private int c = 0;
    public BroadcastReceiver b = new q(this);

    @Override // com.baidu.tieba.j, android.support.v4.app.Fragment
    public final void onAttach(Activity activity) {
        super.onAttach(activity);
        this.d = (com.baidu.tieba.k) activity;
    }

    @Override // com.baidu.tieba.j, android.support.v4.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.home_activity, (ViewGroup) null);
    }

    @Override // com.baidu.tieba.j, android.support.v4.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.baidu.tieba.SHOWSQUARE");
        this.d.registerReceiver(this.b, intentFilter);
    }

    @Override // com.baidu.tieba.j, android.support.v4.app.Fragment
    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.e = new s(this.d, this);
        this.e.a().check(R.id.radio_square);
    }

    @Override // com.baidu.tieba.j, android.support.v4.app.Fragment
    public final void onResume() {
        super.onResume();
    }

    @Override // com.baidu.tieba.j, android.support.v4.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        this.d.unregisterReceiver(this.b);
    }

    @Override // android.support.v4.app.Fragment
    public final void onSaveInstanceState(Bundle bundle) {
        if (this.c != -1) {
            bundle.putInt("type", this.c);
        } else {
            bundle.putInt("type", 0);
        }
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(int i) {
        Fragment item;
        int i2 = R.id.radio_square;
        switch (i) {
            case 1:
                i2 = R.id.radio_forumfeed;
                break;
        }
        if (this.e != null && this.e.a() != null) {
            this.e.a().check(i2);
        }
        if (this.e != null && this.e.e() != null && (item = this.e.e().getItem(i)) != null) {
            cc.a(item.getClass().getName());
        }
    }

    @Override // com.baidu.tieba.j
    public final void c(int i) {
        this.e.a(i);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public final void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public final void onPageSelected(int i) {
        d(i);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public final void onPageScrollStateChanged(int i) {
    }

    @Override // android.widget.RadioGroup.OnCheckedChangeListener
    public final void onCheckedChanged(RadioGroup radioGroup, int i) {
        int i2 = 0;
        switch (i) {
            case R.id.radio_forumfeed /* 2131101118 */:
                i2 = 1;
                break;
        }
        if (i2 != this.c) {
            this.c = i2;
            this.e.d().setCurrentItem(i2);
        }
    }
}
