package com.baidu.tieba.im.creategroup;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.GroupAddressLocateActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.im.util.b;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class GroupAddressLocateActivity extends BaseActivity<GroupAddressLocateActivity> implements AdapterView.OnItemClickListener, BdSwitchView.a, b.a {
    private boolean gxg = false;
    private boolean gxs = false;
    private String gxt = null;
    private String gxu = null;
    private String[] gxv = null;
    private String gxw = "";
    private int gqq = -1;
    private n gxx = null;
    a.b gxy = new a.b() { // from class: com.baidu.tieba.im.creategroup.GroupAddressLocateActivity.1
        @Override // com.baidu.tbadk.core.dialog.a.b
        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
            aVar.dismiss();
            GroupAddressLocateActivity.this.bzy();
        }
    };
    a.b gxz = new a.b() { // from class: com.baidu.tieba.im.creategroup.GroupAddressLocateActivity.2
        @Override // com.baidu.tbadk.core.dialog.a.b
        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
            GroupAddressLocateActivity.this.setResult(0);
            aVar.dismiss();
            GroupAddressLocateActivity.this.finish();
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent != null) {
            this.gxt = intent.getStringExtra(GroupAddressLocateActivityConfig.INTENT_DATA_OLD_ADDRESS);
            this.gxu = intent.getStringExtra(GroupAddressLocateActivityConfig.INTENT_DATA_OLD_BUSINESS);
            this.gxg = intent.getBooleanExtra(GroupAddressLocateActivityConfig.INTENT_DATA_IS_HIDDEN_ADDRESS, false);
            this.gxs = this.gxg;
        }
        this.gxx = new n(this, this.gxt, this.gxu, this.gxg);
        this.gxx.b(this.gxz);
        this.gxx.c(this.gxy);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.gxx != null) {
            this.gxx.bzk();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.gxx.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getRepeatCount() == 0 && bzx()) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.gxx.bzv()) {
            bzy();
        } else if (view == this.gxx.getBackButton()) {
            if (!bzx()) {
                finish();
            }
        } else if (view == this.gxx.bzE()) {
            this.gxx.bzw();
            this.gxx.bzA();
            this.gqq = -1;
        } else if (view == this.gxx.bzF()) {
            switch (this.gxx.bys()) {
                case 1:
                    startActivityForResult(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"), 22001);
                    return;
                case 2:
                    this.gxx.bzB();
                    this.gxx.bzj();
                    return;
                case 3:
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 22001) {
            this.gxx.bzB();
            this.gxx.bzj();
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (switchState == BdSwitchView.SwitchState.ON) {
            this.gxg = true;
        } else {
            this.gxg = false;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.gxx.bzw();
        this.gxx.bzz();
        this.gqq = i;
    }

    public int getSelectedPosition() {
        return this.gqq;
    }

    @Override // com.baidu.tieba.im.util.b.a
    public void a(String str, List<String> list, double d, double d2) {
        this.gxx.xQ(String.valueOf(d));
        this.gxx.xP(String.valueOf(d2));
        this.gxw = str;
        if (list != null && list.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (String str2 : list) {
                arrayList.add(str2);
            }
            arrayList.remove(this.gxu);
            this.gxv = new String[arrayList.size()];
            for (int i = 0; i < arrayList.size(); i++) {
                this.gxv[i] = (String) arrayList.get(i);
            }
            this.gxx.x(this.gxv);
        } else if (this.gxw.equals(this.gxt)) {
            this.gxx.x(new String[0]);
        } else {
            this.gxx.x(new String[]{this.gxw});
        }
    }

    @Override // com.baidu.tieba.im.util.b.a
    public void byO() {
        this.gxx.bzC();
    }

    @Override // com.baidu.tieba.im.util.b.a
    public void byP() {
        this.gxx.byu();
    }

    private boolean bzx() {
        if (this.gxg != this.gxs || this.gqq > -1) {
            this.gxx.showDialog();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bzy() {
        Intent intent = new Intent();
        if (this.gxv == null) {
            if (this.gqq > -1) {
                intent.putExtra("ResultDataSelectedBusiness", "");
                intent.putExtra("ResultDataAddress", this.gxw);
            } else {
                intent.putExtra("ResultDataSelectedBusiness", this.gxu);
                intent.putExtra("ResultDataAddress", this.gxt);
            }
        } else if (this.gqq > -1 && this.gqq < this.gxv.length) {
            intent.putExtra("ResultDataSelectedBusiness", this.gxv[this.gqq]);
            intent.putExtra("ResultDataAddress", this.gxw);
        } else {
            intent.putExtra("ResultDataSelectedBusiness", this.gxu);
            intent.putExtra("ResultDataAddress", this.gxt);
        }
        intent.putExtra("ResultDataIsHiddenAddress", this.gxg);
        setResult(-1, intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.gxx.onChangeSkinType(i);
    }
}
