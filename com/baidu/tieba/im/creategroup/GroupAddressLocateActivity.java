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
/* loaded from: classes17.dex */
public class GroupAddressLocateActivity extends BaseActivity<GroupAddressLocateActivity> implements AdapterView.OnItemClickListener, BdSwitchView.a, b.a {
    private boolean jlf = false;
    private boolean jlr = false;
    private String jls = null;
    private String jlt = null;
    private String[] jlu = null;
    private String jlv = "";
    private int jdt = -1;
    private n jlw = null;
    a.b jlx = new a.b() { // from class: com.baidu.tieba.im.creategroup.GroupAddressLocateActivity.1
        @Override // com.baidu.tbadk.core.dialog.a.b
        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
            aVar.dismiss();
            GroupAddressLocateActivity.this.cDF();
        }
    };
    a.b jly = new a.b() { // from class: com.baidu.tieba.im.creategroup.GroupAddressLocateActivity.2
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
            this.jls = intent.getStringExtra(GroupAddressLocateActivityConfig.INTENT_DATA_OLD_ADDRESS);
            this.jlt = intent.getStringExtra(GroupAddressLocateActivityConfig.INTENT_DATA_OLD_BUSINESS);
            this.jlf = intent.getBooleanExtra(GroupAddressLocateActivityConfig.INTENT_DATA_IS_HIDDEN_ADDRESS, false);
            this.jlr = this.jlf;
        }
        this.jlw = new n(this, this.jls, this.jlt, this.jlf);
        this.jlw.b(this.jly);
        this.jlw.c(this.jlx);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.jlw != null) {
            this.jlw.cDr();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.jlw.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getRepeatCount() == 0 && cDE()) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.jlw.cDC()) {
            cDF();
        } else if (view == this.jlw.getBackButton()) {
            if (!cDE()) {
                finish();
            }
        } else if (view == this.jlw.cDL()) {
            this.jlw.cDD();
            this.jlw.cDH();
            this.jdt = -1;
        } else if (view == this.jlw.cDM()) {
            switch (this.jlw.cCA()) {
                case 1:
                    startActivityForResult(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"), RequestResponseCode.REQUEST_SETTING_LOCATION_SOURCE);
                    return;
                case 2:
                    this.jlw.cDI();
                    this.jlw.cDq();
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
            this.jlw.cDI();
            this.jlw.cDq();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i == 25044) {
            this.jlw.cDq();
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (switchState == BdSwitchView.SwitchState.ON) {
            this.jlf = true;
        } else {
            this.jlf = false;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.jlw.cDD();
        this.jlw.cDG();
        this.jdt = i;
    }

    public int getSelectedPosition() {
        return this.jdt;
    }

    @Override // com.baidu.tieba.im.util.b.a
    public void a(String str, List<String> list, double d, double d2) {
        this.jlw.Kh(String.valueOf(d));
        this.jlw.Kg(String.valueOf(d2));
        this.jlv = str;
        if (list != null && list.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (String str2 : list) {
                arrayList.add(str2);
            }
            arrayList.remove(this.jlt);
            this.jlu = new String[arrayList.size()];
            for (int i = 0; i < arrayList.size(); i++) {
                this.jlu[i] = (String) arrayList.get(i);
            }
            this.jlw.J(this.jlu);
        } else if (this.jlv.equals(this.jls)) {
            this.jlw.J(new String[0]);
        } else {
            this.jlw.J(new String[]{this.jlv});
        }
    }

    @Override // com.baidu.tieba.im.util.b.a
    public void cCW() {
        this.jlw.cDJ();
    }

    @Override // com.baidu.tieba.im.util.b.a
    public void cCX() {
        this.jlw.cCC();
    }

    private boolean cDE() {
        if (this.jlf != this.jlr || this.jdt > -1) {
            this.jlw.Nv();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cDF() {
        Intent intent = new Intent();
        if (this.jlu == null) {
            if (this.jdt > -1) {
                intent.putExtra("ResultDataSelectedBusiness", "");
                intent.putExtra("ResultDataAddress", this.jlv);
            } else {
                intent.putExtra("ResultDataSelectedBusiness", this.jlt);
                intent.putExtra("ResultDataAddress", this.jls);
            }
        } else if (this.jdt > -1 && this.jdt < this.jlu.length) {
            intent.putExtra("ResultDataSelectedBusiness", this.jlu[this.jdt]);
            intent.putExtra("ResultDataAddress", this.jlv);
        } else {
            intent.putExtra("ResultDataSelectedBusiness", this.jlt);
            intent.putExtra("ResultDataAddress", this.jls);
        }
        intent.putExtra("ResultDataIsHiddenAddress", this.jlf);
        setResult(-1, intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.jlw.onChangeSkinType(i);
    }
}
