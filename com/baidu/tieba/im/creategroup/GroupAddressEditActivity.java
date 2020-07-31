package com.baidu.tieba.im.creategroup;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.GroupAddressEditActivityConfig;
/* loaded from: classes17.dex */
public class GroupAddressEditActivity extends BaseActivity<GroupAddressEditActivity> implements AdapterView.OnItemClickListener, BdSwitchView.a {
    k iWj = null;
    private String[] addresses = null;
    private boolean iWk = false;
    private int iWl = -1;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent != null) {
            this.addresses = intent.getStringArrayExtra(GroupAddressEditActivityConfig.INTENT_GROUP_ADRESS_LIST);
            this.iWl = intent.getIntExtra(GroupAddressEditActivityConfig.INTENT_GROUP_SELECTEDINDEX, 0);
            this.iWk = intent.getBooleanExtra(GroupAddressEditActivityConfig.INTENT_GROUP_ADDRESS_ISHIDDEN, false);
        }
        this.iWj = new k(getPageContext(), this.addresses, this.iWk);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.iWj.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.iWj.csL() || view == this.iWj.getBackButton()) {
            Intent intent = new Intent();
            if (this.iWl > -1 && this.iWl < this.addresses.length) {
                intent.putExtra("Selected_Business", this.addresses[this.iWl]);
            }
            intent.putExtra("Hidden_Address_Flag", this.iWk);
            setResult(-1, intent);
            finish();
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (switchState == BdSwitchView.SwitchState.ON) {
            this.iWk = true;
        } else {
            this.iWk = false;
        }
    }

    public int csK() {
        return this.iWl;
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.iWl = i;
        this.iWj.csM();
    }
}
