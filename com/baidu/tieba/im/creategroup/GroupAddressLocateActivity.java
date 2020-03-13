package com.baidu.tieba.im.creategroup;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.GroupAddressLocateActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.im.util.b;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class GroupAddressLocateActivity extends BaseActivity<GroupAddressLocateActivity> implements AdapterView.OnItemClickListener, BdSwitchView.a, b.a {
    private boolean hxh = false;
    private boolean hxt = false;
    private String hxu = null;
    private String hxv = null;
    private String[] hxw = null;
    private String hxx = "";
    private int hqt = -1;
    private n hxy = null;
    a.b hxz = new a.b() { // from class: com.baidu.tieba.im.creategroup.GroupAddressLocateActivity.1
        @Override // com.baidu.tbadk.core.dialog.a.b
        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
            aVar.dismiss();
            GroupAddressLocateActivity.this.bTV();
        }
    };
    a.b hxA = new a.b() { // from class: com.baidu.tieba.im.creategroup.GroupAddressLocateActivity.2
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
            this.hxu = intent.getStringExtra(GroupAddressLocateActivityConfig.INTENT_DATA_OLD_ADDRESS);
            this.hxv = intent.getStringExtra(GroupAddressLocateActivityConfig.INTENT_DATA_OLD_BUSINESS);
            this.hxh = intent.getBooleanExtra(GroupAddressLocateActivityConfig.INTENT_DATA_IS_HIDDEN_ADDRESS, false);
            this.hxt = this.hxh;
        }
        this.hxy = new n(this, this.hxu, this.hxv, this.hxh);
        this.hxy.b(this.hxA);
        this.hxy.c(this.hxz);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.hxy != null) {
            this.hxy.bTH();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.hxy.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getRepeatCount() == 0 && bTU()) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.hxy.bTS()) {
            bTV();
        } else if (view == this.hxy.getBackButton()) {
            if (!bTU()) {
                finish();
            }
        } else if (view == this.hxy.bUb()) {
            this.hxy.bTT();
            this.hxy.bTX();
            this.hqt = -1;
        } else if (view == this.hxy.bUc()) {
            switch (this.hxy.bSP()) {
                case 1:
                    startActivityForResult(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"), RequestResponseCode.REQUEST_SETTING_LOCATION_SOURCE);
                    return;
                case 2:
                    this.hxy.bTY();
                    this.hxy.bTG();
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
            this.hxy.bTY();
            this.hxy.bTG();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i == 25044) {
            this.hxy.bTG();
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (switchState == BdSwitchView.SwitchState.ON) {
            this.hxh = true;
        } else {
            this.hxh = false;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.hxy.bTT();
        this.hxy.bTW();
        this.hqt = i;
    }

    public int getSelectedPosition() {
        return this.hqt;
    }

    @Override // com.baidu.tieba.im.util.b.a
    public void a(String str, List<String> list, double d, double d2) {
        this.hxy.CF(String.valueOf(d));
        this.hxy.CE(String.valueOf(d2));
        this.hxx = str;
        if (list != null && list.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (String str2 : list) {
                arrayList.add(str2);
            }
            arrayList.remove(this.hxv);
            this.hxw = new String[arrayList.size()];
            for (int i = 0; i < arrayList.size(); i++) {
                this.hxw[i] = (String) arrayList.get(i);
            }
            this.hxy.I(this.hxw);
        } else if (this.hxx.equals(this.hxu)) {
            this.hxy.I(new String[0]);
        } else {
            this.hxy.I(new String[]{this.hxx});
        }
    }

    @Override // com.baidu.tieba.im.util.b.a
    public void onLoadFailed() {
        this.hxy.bTZ();
    }

    @Override // com.baidu.tieba.im.util.b.a
    public void bTm() {
        this.hxy.bSR();
    }

    private boolean bTU() {
        if (this.hxh != this.hxt || this.hqt > -1) {
            this.hxy.showDialog();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bTV() {
        Intent intent = new Intent();
        if (this.hxw == null) {
            if (this.hqt > -1) {
                intent.putExtra("ResultDataSelectedBusiness", "");
                intent.putExtra("ResultDataAddress", this.hxx);
            } else {
                intent.putExtra("ResultDataSelectedBusiness", this.hxv);
                intent.putExtra("ResultDataAddress", this.hxu);
            }
        } else if (this.hqt > -1 && this.hqt < this.hxw.length) {
            intent.putExtra("ResultDataSelectedBusiness", this.hxw[this.hqt]);
            intent.putExtra("ResultDataAddress", this.hxx);
        } else {
            intent.putExtra("ResultDataSelectedBusiness", this.hxv);
            intent.putExtra("ResultDataAddress", this.hxu);
        }
        intent.putExtra("ResultDataIsHiddenAddress", this.hxh);
        setResult(-1, intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.hxy.onChangeSkinType(i);
    }
}
