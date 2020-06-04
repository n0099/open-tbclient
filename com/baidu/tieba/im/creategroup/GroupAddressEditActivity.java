package com.baidu.tieba.im.creategroup;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.GroupAddressEditActivityConfig;
/* loaded from: classes10.dex */
public class GroupAddressEditActivity extends BaseActivity<GroupAddressEditActivity> implements AdapterView.OnItemClickListener, BdSwitchView.a {
    k iyb = null;
    private String[] addresses = null;
    private boolean iyc = false;
    private int iyd = -1;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent != null) {
            this.addresses = intent.getStringArrayExtra(GroupAddressEditActivityConfig.INTENT_GROUP_ADRESS_LIST);
            this.iyd = intent.getIntExtra(GroupAddressEditActivityConfig.INTENT_GROUP_SELECTEDINDEX, 0);
            this.iyc = intent.getBooleanExtra(GroupAddressEditActivityConfig.INTENT_GROUP_ADDRESS_ISHIDDEN, false);
        }
        this.iyb = new k(getPageContext(), this.addresses, this.iyc);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.iyb.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.iyb.clq() || view == this.iyb.getBackButton()) {
            Intent intent = new Intent();
            if (this.iyd > -1 && this.iyd < this.addresses.length) {
                intent.putExtra("Selected_Business", this.addresses[this.iyd]);
            }
            intent.putExtra("Hidden_Address_Flag", this.iyc);
            setResult(-1, intent);
            finish();
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (switchState == BdSwitchView.SwitchState.ON) {
            this.iyc = true;
        } else {
            this.iyc = false;
        }
    }

    public int clp() {
        return this.iyd;
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.iyd = i;
        this.iyb.clr();
    }
}
