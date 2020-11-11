package com.baidu.tieba.im.creategroup;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.GroupAddressEditActivityConfig;
/* loaded from: classes23.dex */
public class GroupAddressEditActivity extends BaseActivity<GroupAddressEditActivity> implements AdapterView.OnItemClickListener, BdSwitchView.a {
    k kbn = null;
    private String[] addresses = null;
    private boolean kbo = false;
    private int kbp = -1;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent != null) {
            this.addresses = intent.getStringArrayExtra(GroupAddressEditActivityConfig.INTENT_GROUP_ADRESS_LIST);
            this.kbp = intent.getIntExtra(GroupAddressEditActivityConfig.INTENT_GROUP_SELECTEDINDEX, 0);
            this.kbo = intent.getBooleanExtra(GroupAddressEditActivityConfig.INTENT_GROUP_ADDRESS_ISHIDDEN, false);
        }
        this.kbn = new k(getPageContext(), this.addresses, this.kbo);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.kbn.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.kbn.cQA() || view == this.kbn.getBackButton()) {
            Intent intent = new Intent();
            if (this.kbp > -1 && this.kbp < this.addresses.length) {
                intent.putExtra("Selected_Business", this.addresses[this.kbp]);
            }
            intent.putExtra("Hidden_Address_Flag", this.kbo);
            setResult(-1, intent);
            finish();
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (switchState == BdSwitchView.SwitchState.ON) {
            this.kbo = true;
        } else {
            this.kbo = false;
        }
    }

    public int cQz() {
        return this.kbp;
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.kbp = i;
        this.kbn.cQB();
    }
}
