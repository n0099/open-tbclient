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
    private boolean gxh = false;
    private boolean gxt = false;
    private String gxu = null;
    private String gxv = null;
    private String[] gxw = null;
    private String gxx = "";
    private int gqr = -1;
    private n gxy = null;
    a.b gxz = new a.b() { // from class: com.baidu.tieba.im.creategroup.GroupAddressLocateActivity.1
        @Override // com.baidu.tbadk.core.dialog.a.b
        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
            aVar.dismiss();
            GroupAddressLocateActivity.this.bzB();
        }
    };
    a.b gxA = new a.b() { // from class: com.baidu.tieba.im.creategroup.GroupAddressLocateActivity.2
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
            this.gxu = intent.getStringExtra(GroupAddressLocateActivityConfig.INTENT_DATA_OLD_ADDRESS);
            this.gxv = intent.getStringExtra(GroupAddressLocateActivityConfig.INTENT_DATA_OLD_BUSINESS);
            this.gxh = intent.getBooleanExtra(GroupAddressLocateActivityConfig.INTENT_DATA_IS_HIDDEN_ADDRESS, false);
            this.gxt = this.gxh;
        }
        this.gxy = new n(this, this.gxu, this.gxv, this.gxh);
        this.gxy.b(this.gxA);
        this.gxy.c(this.gxz);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.gxy != null) {
            this.gxy.bzn();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.gxy.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getRepeatCount() == 0 && bzA()) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.gxy.bzy()) {
            bzB();
        } else if (view == this.gxy.getBackButton()) {
            if (!bzA()) {
                finish();
            }
        } else if (view == this.gxy.bzH()) {
            this.gxy.bzz();
            this.gxy.bzD();
            this.gqr = -1;
        } else if (view == this.gxy.bzI()) {
            switch (this.gxy.byv()) {
                case 1:
                    startActivityForResult(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"), 22001);
                    return;
                case 2:
                    this.gxy.bzE();
                    this.gxy.bzm();
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
            this.gxy.bzE();
            this.gxy.bzm();
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (switchState == BdSwitchView.SwitchState.ON) {
            this.gxh = true;
        } else {
            this.gxh = false;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.gxy.bzz();
        this.gxy.bzC();
        this.gqr = i;
    }

    public int getSelectedPosition() {
        return this.gqr;
    }

    @Override // com.baidu.tieba.im.util.b.a
    public void a(String str, List<String> list, double d, double d2) {
        this.gxy.xQ(String.valueOf(d));
        this.gxy.xP(String.valueOf(d2));
        this.gxx = str;
        if (list != null && list.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (String str2 : list) {
                arrayList.add(str2);
            }
            arrayList.remove(this.gxv);
            this.gxw = new String[arrayList.size()];
            for (int i = 0; i < arrayList.size(); i++) {
                this.gxw[i] = (String) arrayList.get(i);
            }
            this.gxy.x(this.gxw);
        } else if (this.gxx.equals(this.gxu)) {
            this.gxy.x(new String[0]);
        } else {
            this.gxy.x(new String[]{this.gxx});
        }
    }

    @Override // com.baidu.tieba.im.util.b.a
    public void byR() {
        this.gxy.bzF();
    }

    @Override // com.baidu.tieba.im.util.b.a
    public void byS() {
        this.gxy.byx();
    }

    private boolean bzA() {
        if (this.gxh != this.gxt || this.gqr > -1) {
            this.gxy.showDialog();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bzB() {
        Intent intent = new Intent();
        if (this.gxw == null) {
            if (this.gqr > -1) {
                intent.putExtra("ResultDataSelectedBusiness", "");
                intent.putExtra("ResultDataAddress", this.gxx);
            } else {
                intent.putExtra("ResultDataSelectedBusiness", this.gxv);
                intent.putExtra("ResultDataAddress", this.gxu);
            }
        } else if (this.gqr > -1 && this.gqr < this.gxw.length) {
            intent.putExtra("ResultDataSelectedBusiness", this.gxw[this.gqr]);
            intent.putExtra("ResultDataAddress", this.gxx);
        } else {
            intent.putExtra("ResultDataSelectedBusiness", this.gxv);
            intent.putExtra("ResultDataAddress", this.gxu);
        }
        intent.putExtra("ResultDataIsHiddenAddress", this.gxh);
        setResult(-1, intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.gxy.onChangeSkinType(i);
    }
}
