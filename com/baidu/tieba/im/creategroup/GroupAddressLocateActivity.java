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
    private boolean gxj = false;
    private boolean gxv = false;
    private String gxw = null;
    private String gxx = null;
    private String[] gxy = null;
    private String gxz = "";
    private int gqt = -1;
    private n gxA = null;
    a.b gxB = new a.b() { // from class: com.baidu.tieba.im.creategroup.GroupAddressLocateActivity.1
        @Override // com.baidu.tbadk.core.dialog.a.b
        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
            aVar.dismiss();
            GroupAddressLocateActivity.this.bzC();
        }
    };
    a.b gxC = new a.b() { // from class: com.baidu.tieba.im.creategroup.GroupAddressLocateActivity.2
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
            this.gxw = intent.getStringExtra(GroupAddressLocateActivityConfig.INTENT_DATA_OLD_ADDRESS);
            this.gxx = intent.getStringExtra(GroupAddressLocateActivityConfig.INTENT_DATA_OLD_BUSINESS);
            this.gxj = intent.getBooleanExtra(GroupAddressLocateActivityConfig.INTENT_DATA_IS_HIDDEN_ADDRESS, false);
            this.gxv = this.gxj;
        }
        this.gxA = new n(this, this.gxw, this.gxx, this.gxj);
        this.gxA.b(this.gxC);
        this.gxA.c(this.gxB);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.gxA != null) {
            this.gxA.bzo();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.gxA.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getRepeatCount() == 0 && bzB()) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.gxA.bzz()) {
            bzC();
        } else if (view == this.gxA.getBackButton()) {
            if (!bzB()) {
                finish();
            }
        } else if (view == this.gxA.bzI()) {
            this.gxA.bzA();
            this.gxA.bzE();
            this.gqt = -1;
        } else if (view == this.gxA.bzJ()) {
            switch (this.gxA.byw()) {
                case 1:
                    startActivityForResult(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"), 22001);
                    return;
                case 2:
                    this.gxA.bzF();
                    this.gxA.bzn();
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
            this.gxA.bzF();
            this.gxA.bzn();
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (switchState == BdSwitchView.SwitchState.ON) {
            this.gxj = true;
        } else {
            this.gxj = false;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.gxA.bzA();
        this.gxA.bzD();
        this.gqt = i;
    }

    public int getSelectedPosition() {
        return this.gqt;
    }

    @Override // com.baidu.tieba.im.util.b.a
    public void a(String str, List<String> list, double d, double d2) {
        this.gxA.xS(String.valueOf(d));
        this.gxA.xR(String.valueOf(d2));
        this.gxz = str;
        if (list != null && list.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (String str2 : list) {
                arrayList.add(str2);
            }
            arrayList.remove(this.gxx);
            this.gxy = new String[arrayList.size()];
            for (int i = 0; i < arrayList.size(); i++) {
                this.gxy[i] = (String) arrayList.get(i);
            }
            this.gxA.x(this.gxy);
        } else if (this.gxz.equals(this.gxw)) {
            this.gxA.x(new String[0]);
        } else {
            this.gxA.x(new String[]{this.gxz});
        }
    }

    @Override // com.baidu.tieba.im.util.b.a
    public void byS() {
        this.gxA.bzG();
    }

    @Override // com.baidu.tieba.im.util.b.a
    public void byT() {
        this.gxA.byy();
    }

    private boolean bzB() {
        if (this.gxj != this.gxv || this.gqt > -1) {
            this.gxA.showDialog();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bzC() {
        Intent intent = new Intent();
        if (this.gxy == null) {
            if (this.gqt > -1) {
                intent.putExtra("ResultDataSelectedBusiness", "");
                intent.putExtra("ResultDataAddress", this.gxz);
            } else {
                intent.putExtra("ResultDataSelectedBusiness", this.gxx);
                intent.putExtra("ResultDataAddress", this.gxw);
            }
        } else if (this.gqt > -1 && this.gqt < this.gxy.length) {
            intent.putExtra("ResultDataSelectedBusiness", this.gxy[this.gqt]);
            intent.putExtra("ResultDataAddress", this.gxz);
        } else {
            intent.putExtra("ResultDataSelectedBusiness", this.gxx);
            intent.putExtra("ResultDataAddress", this.gxw);
        }
        intent.putExtra("ResultDataIsHiddenAddress", this.gxj);
        setResult(-1, intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.gxA.onChangeSkinType(i);
    }
}
