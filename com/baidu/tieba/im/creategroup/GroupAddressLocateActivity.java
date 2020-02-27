package com.baidu.tieba.im.creategroup;

import android.content.Intent;
import android.os.Bundle;
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
    private boolean hwT = false;
    private boolean hxf = false;
    private String hxg = null;
    private String hxh = null;
    private String[] hxi = null;
    private String hxj = "";
    private int hqf = -1;
    private n hxk = null;
    a.b hxl = new a.b() { // from class: com.baidu.tieba.im.creategroup.GroupAddressLocateActivity.1
        @Override // com.baidu.tbadk.core.dialog.a.b
        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
            aVar.dismiss();
            GroupAddressLocateActivity.this.bTS();
        }
    };
    a.b hxm = new a.b() { // from class: com.baidu.tieba.im.creategroup.GroupAddressLocateActivity.2
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
            this.hxg = intent.getStringExtra(GroupAddressLocateActivityConfig.INTENT_DATA_OLD_ADDRESS);
            this.hxh = intent.getStringExtra(GroupAddressLocateActivityConfig.INTENT_DATA_OLD_BUSINESS);
            this.hwT = intent.getBooleanExtra(GroupAddressLocateActivityConfig.INTENT_DATA_IS_HIDDEN_ADDRESS, false);
            this.hxf = this.hwT;
        }
        this.hxk = new n(this, this.hxg, this.hxh, this.hwT);
        this.hxk.b(this.hxm);
        this.hxk.c(this.hxl);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.hxk != null) {
            this.hxk.bTE();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.hxk.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getRepeatCount() == 0 && bTR()) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.hxk.bTP()) {
            bTS();
        } else if (view == this.hxk.getBackButton()) {
            if (!bTR()) {
                finish();
            }
        } else if (view == this.hxk.bTY()) {
            this.hxk.bTQ();
            this.hxk.bTU();
            this.hqf = -1;
        } else if (view == this.hxk.bTZ()) {
            switch (this.hxk.bSM()) {
                case 1:
                    startActivityForResult(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"), RequestResponseCode.REQUEST_SETTING_LOCATION_SOURCE);
                    return;
                case 2:
                    this.hxk.bTV();
                    this.hxk.bTD();
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
            this.hxk.bTV();
            this.hxk.bTD();
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (switchState == BdSwitchView.SwitchState.ON) {
            this.hwT = true;
        } else {
            this.hwT = false;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.hxk.bTQ();
        this.hxk.bTT();
        this.hqf = i;
    }

    public int getSelectedPosition() {
        return this.hqf;
    }

    @Override // com.baidu.tieba.im.util.b.a
    public void a(String str, List<String> list, double d, double d2) {
        this.hxk.CE(String.valueOf(d));
        this.hxk.CD(String.valueOf(d2));
        this.hxj = str;
        if (list != null && list.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (String str2 : list) {
                arrayList.add(str2);
            }
            arrayList.remove(this.hxh);
            this.hxi = new String[arrayList.size()];
            for (int i = 0; i < arrayList.size(); i++) {
                this.hxi[i] = (String) arrayList.get(i);
            }
            this.hxk.I(this.hxi);
        } else if (this.hxj.equals(this.hxg)) {
            this.hxk.I(new String[0]);
        } else {
            this.hxk.I(new String[]{this.hxj});
        }
    }

    @Override // com.baidu.tieba.im.util.b.a
    public void onLoadFailed() {
        this.hxk.bTW();
    }

    @Override // com.baidu.tieba.im.util.b.a
    public void bTj() {
        this.hxk.bSO();
    }

    private boolean bTR() {
        if (this.hwT != this.hxf || this.hqf > -1) {
            this.hxk.showDialog();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bTS() {
        Intent intent = new Intent();
        if (this.hxi == null) {
            if (this.hqf > -1) {
                intent.putExtra("ResultDataSelectedBusiness", "");
                intent.putExtra("ResultDataAddress", this.hxj);
            } else {
                intent.putExtra("ResultDataSelectedBusiness", this.hxh);
                intent.putExtra("ResultDataAddress", this.hxg);
            }
        } else if (this.hqf > -1 && this.hqf < this.hxi.length) {
            intent.putExtra("ResultDataSelectedBusiness", this.hxi[this.hqf]);
            intent.putExtra("ResultDataAddress", this.hxj);
        } else {
            intent.putExtra("ResultDataSelectedBusiness", this.hxh);
            intent.putExtra("ResultDataAddress", this.hxg);
        }
        intent.putExtra("ResultDataIsHiddenAddress", this.hwT);
        setResult(-1, intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.hxk.onChangeSkinType(i);
    }
}
