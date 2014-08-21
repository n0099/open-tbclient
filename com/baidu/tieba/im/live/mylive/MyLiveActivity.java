package com.baidu.tieba.im.live.mylive;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.RadioGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.am;
import com.baidu.tbadk.core.atomData.ax;
import com.baidu.tbadk.core.data.LiveCardData;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class MyLiveActivity extends BaseFragmentActivity implements ViewPager.OnPageChangeListener, View.OnClickListener, RadioGroup.OnCheckedChangeListener {
    private l d;
    private boolean e = false;
    private boolean f = false;
    private LiveCardData g = null;

    static {
        TbadkApplication.m252getInst().RegisterIntent(ax.class, MyLiveActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a(bundle);
    }

    private void a(Bundle bundle) {
        this.d = new l(this);
        this.d.c();
    }

    public l g() {
        return this.d;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void b(int i) {
        this.d.d(i);
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.d.d()) {
            this.d.b();
        }
    }

    @Override // android.widget.RadioGroup.OnCheckedChangeListener
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        if (!this.f) {
            this.e = true;
            if (i == u.mylive_activity_radio_mymark) {
                this.d.b(0);
                this.d.c(0);
                this.d.a(0);
            } else if (i == u.mylive_activity_radio_mylive) {
                this.d.b(1);
                this.d.c(1);
                this.d.a(1);
            }
            this.e = false;
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        if (!this.e) {
            this.f = true;
            this.d.b(i);
            this.d.a(i);
            this.f = false;
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    public void a(LiveCardData liveCardData) {
        this.g = liveCardData;
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new am(this, liveCardData.getGroupId())));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.g != null && i2 == -1 && !intent.getBooleanExtra("subcribed", true)) {
            this.d.a(this.g);
        }
    }
}
