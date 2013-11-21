package com.baidu.tieba.im.creategroup;

import android.content.Intent;
import android.location.Address;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
/* loaded from: classes.dex */
public class GroupAddressActivity extends com.baidu.tieba.j implements AdapterView.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    o f1571a = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f1571a = new o(this);
        Intent intent = getIntent();
        if (intent != null) {
            this.f1571a.a(intent.getStringExtra("addressLine"));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.f1571a.b(i);
    }

    @Override // com.baidu.adp.a.a, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.f1571a.a()) {
            Address e = this.f1571a.e();
            Intent intent = new Intent();
            if (e != null) {
                intent.putExtra("Longitude", e.getLongitude());
                intent.putExtra("Latitude", e.getLatitude());
                intent.putExtra("addressline", e.getAddressLine(0));
            }
            setResult(-1, intent);
            finish();
        }
    }

    @Override // com.baidu.adp.a.a, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.f1571a.a(i);
    }
}
