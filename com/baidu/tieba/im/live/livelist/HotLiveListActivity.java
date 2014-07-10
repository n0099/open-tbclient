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
    private ad c;
    private com.baidu.tieba.im.model.n d;
    private boolean e;
    private boolean f;
    private boolean g = TbadkApplication.m252getInst().isLiveRecordOpen();

    static {
        TbadkApplication.m252getInst().RegisterIntent(com.baidu.tbadk.core.atomData.x.class, HotLiveListActivity.class);
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
        this.d.b(bundle);
    }

    private void a(Bundle bundle) {
        this.c = new ad(this, this.g);
        this.c.c();
        if (bundle != null) {
            this.c.c(this.d.c());
        }
        this.c.a(i());
        this.c.b();
    }

    public com.baidu.tieba.im.model.n g() {
        return this.d;
    }

    public ad h() {
        return this.c;
    }

    public void a(Bundle bundle, Intent intent) {
        this.d = new com.baidu.tieba.im.model.n(this);
        if (bundle == null) {
            com.baidu.tieba.im.model.n nVar = this.d;
            if (intent == null) {
                intent = getIntent();
            }
            nVar.a(intent);
        } else {
            this.d.a(bundle);
        }
        this.d.a(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void b(int i) {
        this.c.d(i);
    }

    public int i() {
        if (this.g) {
            return this.d.c() - 1;
        }
        switch (this.d.c()) {
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
        if (!this.f) {
            this.e = true;
            if (i == com.baidu.tieba.v.radio_living) {
                com.baidu.tbadk.core.f.a(this, "hot_now_list");
                this.d.a(1);
            } else if (i == com.baidu.tieba.v.radio_review) {
                com.baidu.tbadk.core.f.a(this, "hot_past_list");
                this.d.a(2);
            } else if (i == com.baidu.tieba.v.radio_foreshow) {
                this.d.a(3);
            } else {
                com.baidu.tbadk.core.f.a(this, "hot_now_list");
                this.d.a(1);
            }
            this.c.a(i());
            this.c.d().setCurrentItem(i());
            this.e = false;
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
        if (!this.e) {
            this.f = true;
            if (!this.g) {
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
                this.d.a(1);
            } else if (i2 == 2) {
                com.baidu.tbadk.core.f.a(this, "hot_past_list");
                this.d.a(2);
            } else if (i2 == 3) {
                this.d.a(3);
            } else {
                com.baidu.tbadk.core.f.a(this, "hot_now_list");
                this.d.a(1);
            }
            this.c.c(i2);
            this.c.a(i());
            this.f = false;
        }
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity
    public BdListView h_() {
        z a;
        if (this.c == null || (a = this.c.a()) == null) {
            return null;
        }
        return a.f();
    }
}
