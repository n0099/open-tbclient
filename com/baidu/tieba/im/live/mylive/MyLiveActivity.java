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
import com.baidu.tbadk.core.atomData.ad;
import com.baidu.tbadk.core.atomData.am;
import com.baidu.tbadk.core.data.LiveCardData;
import com.baidu.tieba.v;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public class MyLiveActivity extends BaseFragmentActivity implements ViewPager.OnPageChangeListener, View.OnClickListener, RadioGroup.OnCheckedChangeListener {
    private k c;
    private boolean d = false;
    private boolean e = false;
    private LiveCardData f = null;

    static {
        TbadkApplication.m252getInst().RegisterIntent(am.class, MyLiveActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a(bundle);
    }

    private void a(Bundle bundle) {
        this.c = new k(this);
        this.c.a();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void b(int i) {
        this.c.e(i);
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.c.b()) {
            String string = getString(y.members_edit);
            String string2 = getString(y.group_create_step_done_tip);
            String charSequence = this.c.b().getText().toString();
            if (charSequence != null) {
                if (charSequence.equals(string)) {
                    this.c.b().setText(string2);
                    this.c.a(true);
                } else if (charSequence.equals(string2)) {
                    this.c.b().setText(string);
                    this.c.a(false);
                }
            }
        }
    }

    @Override // android.widget.RadioGroup.OnCheckedChangeListener
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        if (!this.e) {
            this.d = true;
            if (i == v.mylive_activity_radio_mylive) {
                this.c.b(0);
                this.c.c(0);
                this.c.a(0);
            } else if (i == v.mylive_activity_radio_mymark) {
                this.c.b(1);
                this.c.c(1);
                this.c.a(1);
            }
            this.d = false;
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        if (!this.d) {
            this.e = true;
            this.c.b(i);
            this.c.d(i);
            this.c.a(i);
            this.e = false;
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    public void a(LiveCardData liveCardData) {
        this.f = liveCardData;
        MessageManager.getInstance().sendMessage(new CustomMessage(2003001, new ad(this, liveCardData.getGroupId())));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.f != null && i2 == -1 && !intent.getBooleanExtra("subcribed", true)) {
            this.c.a(this.f);
        }
    }
}
