package com.baidu.tieba.im.creategroup;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tieba.util.bq;
import com.slidingmenu.lib.R;
import java.util.List;
/* loaded from: classes.dex */
public class GroupAddressEditActivity extends com.baidu.tieba.f implements AdapterView.OnItemClickListener, com.baidu.adp.widget.BdSwitchView.c {
    p a = null;
    private String[] b = null;
    private boolean c = false;
    private int d = -1;

    public static void a(Activity activity, int i, List<String> list, int i2, boolean z) {
        Intent intent = new Intent(activity, GroupAddressEditActivity.class);
        String[] strArr = new String[list.size()];
        for (int i3 = 0; i3 < list.size(); i3++) {
            strArr[i3] = list.get(i3);
        }
        intent.putExtra("GroupAdressList", strArr);
        intent.putExtra("HiddenAddress", false);
        intent.putExtra("IntentSelectedIndex", i2);
        activity.startActivityForResult(intent, 21001);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f, com.baidu.adp.a.a, android.app.Activity
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
    @Override // com.baidu.tieba.f
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        p pVar = this.a;
        pVar.d.getLayoutMode().a(i == 1);
        pVar.d.getLayoutMode().a(pVar.c);
        bq.b(pVar.c, i);
        pVar.a.b(i);
        if (i == 1) {
            pVar.c.setBackgroundResource(R.color.group_info_bg_1);
        } else {
            pVar.c.setBackgroundResource(R.color.group_info_bg);
        }
    }

    @Override // com.baidu.adp.a.a, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.a.e || view == this.a.a()) {
            Intent intent = new Intent();
            if (this.d >= 0 && this.d < this.b.length) {
                intent.putExtra("Selected_Business", this.b[this.d]);
            }
            intent.putExtra("Hidden_Address_Flag", this.c);
            setResult(-1, intent);
            finish();
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.c
    public final void a(View view, BdSwitchView.SwitchState switchState) {
        if (switchState == BdSwitchView.SwitchState.ON) {
            this.c = true;
        } else {
            this.c = false;
        }
    }

    public final int a() {
        return this.d;
    }

    @Override // com.baidu.adp.a.a, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.d = i;
        this.a.g.notifyDataSetChanged();
    }
}
