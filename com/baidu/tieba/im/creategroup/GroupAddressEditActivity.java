package com.baidu.tieba.im.creategroup;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.BaseActivity;
import java.util.List;
/* loaded from: classes.dex */
public class GroupAddressEditActivity extends BaseActivity implements AdapterView.OnItemClickListener, com.baidu.adp.widget.BdSwitchView.c {
    p a = null;
    private String[] b = null;
    private boolean c = false;
    private int d = -1;

    public static void a(Activity activity, int i, List<String> list, int i2, boolean z) {
        Intent intent = new Intent(activity, GroupAddressEditActivity.class);
        String[] strArr = new String[list.size()];
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 < list.size()) {
                strArr[i4] = list.get(i4);
                i3 = i4 + 1;
            } else {
                intent.putExtra("GroupAdressList", strArr);
                intent.putExtra("HiddenAddress", z);
                intent.putExtra("IntentSelectedIndex", i2);
                activity.startActivityForResult(intent, i);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent != null) {
            this.b = intent.getStringArrayExtra("GroupAdressList");
            this.d = intent.getIntExtra("IntentSelectedIndex", 0);
            this.c = intent.getBooleanExtra("HiddenAddress", false);
        }
        this.a = new p(this, this.b, this.c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.a.a(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.a.a() || view == this.a.b()) {
            Intent intent = new Intent();
            if (this.d > -1 && this.d < this.b.length) {
                intent.putExtra("Selected_Business", this.b[this.d]);
            }
            intent.putExtra("Hidden_Address_Flag", this.c);
            setResult(-1, intent);
            finish();
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.c
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (switchState == BdSwitchView.SwitchState.ON) {
            this.c = true;
        } else {
            this.c = false;
        }
    }

    public int a() {
        return this.d;
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.d = i;
        this.a.c();
    }
}
