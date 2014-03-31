package com.baidu.tieba.forumfeed;

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
import com.baidu.tbadk.core.util.be;
/* loaded from: classes.dex */
public final class p extends com.baidu.tbadk.core.d implements ViewPager.OnPageChangeListener, RadioGroup.OnCheckedChangeListener {
    private com.baidu.tbadk.core.e c;
    private s d;
    private int b = 0;
    public BroadcastReceiver a = new q(this);

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public final void onAttach(Activity activity) {
        super.onAttach(activity);
        this.c = (com.baidu.tbadk.core.e) activity;
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(com.baidu.tieba.a.i.home_activity, (ViewGroup) null);
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.baidu.tieba.SHOWSQUARE");
        this.c.registerReceiver(this.a, intentFilter);
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.d = new s(this.c, this);
        this.d.a().check(com.baidu.tieba.a.h.radio_square);
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public final void onResume() {
        super.onResume();
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        this.c.unregisterReceiver(this.a);
    }

    @Override // android.support.v4.app.Fragment
    public final void onSaveInstanceState(Bundle bundle) {
        if (this.b != -1) {
            bundle.putInt("type", this.b);
        } else {
            bundle.putInt("type", 0);
        }
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        int i2;
        Fragment item;
        switch (i) {
            case 0:
                i2 = com.baidu.tieba.a.h.radio_square;
                break;
            case 1:
                i2 = com.baidu.tieba.a.h.radio_forumfeed;
                break;
            default:
                i2 = com.baidu.tieba.a.h.radio_square;
                break;
        }
        if (this.d != null && this.d.a() != null) {
            this.d.a().check(i2);
        }
        if (this.d != null && this.d.e() != null && (item = this.d.e().getItem(i)) != null) {
            be.a(item.getClass().getName());
        }
    }

    @Override // com.baidu.tbadk.core.d
    public final void onChangeSkinType(int i) {
        this.d.a(i);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public final void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public final void onPageSelected(int i) {
        a(i);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public final void onPageScrollStateChanged(int i) {
    }

    @Override // android.widget.RadioGroup.OnCheckedChangeListener
    public final void onCheckedChanged(RadioGroup radioGroup, int i) {
        int i2 = (i == com.baidu.tieba.a.h.radio_square || i != com.baidu.tieba.a.h.radio_forumfeed) ? 0 : 1;
        if (i2 != this.b) {
            this.b = i2;
            this.d.d().setCurrentItem(i2);
        }
    }
}
