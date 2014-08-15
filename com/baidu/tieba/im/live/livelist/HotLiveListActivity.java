package com.baidu.tieba.im.live.livelist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.RadioGroup;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes.dex */
public class HotLiveListActivity extends BaseFragmentActivity implements ViewPager.OnPageChangeListener, View.OnClickListener, RadioGroup.OnCheckedChangeListener {
    private ad d;
    private com.baidu.tieba.im.model.n e;
    private boolean f;
    private boolean g;
    private boolean h = TbadkApplication.m252getInst().isLiveRecordOpen();

    static {
        TbadkApplication.m252getInst().RegisterIntent(com.baidu.tbadk.core.atomData.aa.class, HotLiveListActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a(bundle, (Intent) null);
        a(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        b(TbadkApplication.m252getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        this.e.b(bundle);
    }

    private void a(Bundle bundle) {
        this.d = new ad(this, this.h);
        this.d.c();
        if (bundle != null) {
            this.d.c(this.e.c());
        }
        this.d.a(i());
        this.d.b();
    }

    public com.baidu.tieba.im.model.n g() {
        return this.e;
    }

    public ad h() {
        return this.d;
    }

    public void a(Bundle bundle, Intent intent) {
        this.e = new com.baidu.tieba.im.model.n(this);
        if (bundle == null) {
            com.baidu.tieba.im.model.n nVar = this.e;
            if (intent == null) {
                intent = getIntent();
            }
            nVar.a(intent);
        } else {
            this.e.a(bundle);
        }
        this.e.a(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void b(int i) {
        this.d.d(i);
    }

    public int i() {
        if (this.h) {
            return this.e.c() - 1;
        }
        switch (this.e.c()) {
            case 1:
            case 2:
            default:
                return 0;
            case 3:
                return 1;
        }
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // android.widget.RadioGroup.OnCheckedChangeListener
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        if (!this.g) {
            this.f = true;
            if (i == com.baidu.tieba.u.radio_living) {
                com.baidu.tbadk.core.f.a(this, "hot_now_list");
                this.e.a(1);
            } else if (i == com.baidu.tieba.u.radio_review) {
                com.baidu.tbadk.core.f.a(this, "hot_past_list");
                this.e.a(2);
            } else if (i == com.baidu.tieba.u.radio_foreshow) {
                this.e.a(3);
            } else {
                com.baidu.tbadk.core.f.a(this, "hot_now_list");
                this.e.a(1);
            }
            this.d.a(i());
            this.d.d().setCurrentItem(i());
            this.f = false;
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        int i2;
        if (!this.f) {
            this.g = true;
            if (!this.h) {
                switch (i) {
                    case 0:
                        i2 = 1;
                        break;
                    case 1:
                        i2 = 3;
                        break;
                    default:
                        i2 = 0;
                        break;
                }
            } else {
                i2 = i + 1;
            }
            if (i2 == 1) {
                com.baidu.tbadk.core.f.a(this, "hot_now_list");
                this.e.a(1);
            } else if (i2 == 2) {
                com.baidu.tbadk.core.f.a(this, "hot_past_list");
                this.e.a(2);
            } else if (i2 == 3) {
                this.e.a(3);
            } else {
                com.baidu.tbadk.core.f.a(this, "hot_now_list");
                this.e.a(1);
            }
            this.d.c(i2);
            this.d.a(i());
            this.g = false;
        }
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity
    public BdListView p_() {
        z a;
        if (this.d == null || (a = this.d.a()) == null) {
            return null;
        }
        return a.f();
    }
}
