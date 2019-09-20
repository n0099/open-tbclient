package com.baidu.tieba.aiapps.apps.address.view;

import android.content.Context;
import android.graphics.Color;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.baidu.swan.apps.b;
import com.baidu.tieba.aiapps.apps.address.a.b;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public class EditAddressView extends LinearLayout {
    private static final boolean DEBUG = b.DEBUG;
    private com.baidu.tieba.aiapps.apps.address.a.b deA;
    private ListView dez;

    public EditAddressView(Context context, com.baidu.tieba.aiapps.apps.address.c.b bVar) {
        super(context);
        a(context, bVar);
    }

    private void a(Context context, com.baidu.tieba.aiapps.apps.address.c.b bVar) {
        setBackgroundColor(0);
        this.dez = new ListView(context);
        this.dez.setDividerHeight(0);
        gv(com.baidu.swan.apps.u.a.EJ().Fi());
        this.deA = new com.baidu.tieba.aiapps.apps.address.a.b(context);
        g(bVar);
        this.dez.setAdapter((ListAdapter) this.deA);
        addView(this.dez, new LinearLayout.LayoutParams(-1, -1));
    }

    public void gv(boolean z) {
        if (z) {
            this.dez.setBackgroundColor(Color.parseColor("#161616"));
        } else {
            this.dez.setBackgroundColor(Color.parseColor("#0D000000"));
        }
    }

    public Map<String, Object> getDeliveryEditData() {
        return this.deA.getDeliveryEditData();
    }

    public com.baidu.tieba.aiapps.apps.address.a.b getEditAdapter() {
        return this.deA;
    }

    public void g(com.baidu.tieba.aiapps.apps.address.c.b bVar) {
        if (bVar != null) {
            this.deA.setData(com.baidu.tieba.aiapps.apps.address.c.b.e(bVar));
            this.deA.p(com.baidu.tieba.aiapps.apps.address.c.b.b(bVar));
            this.deA.q(new HashMap(4));
        }
    }

    public void setDeliveryEditChangedListener(b.a aVar) {
        this.deA.setDeliveryEditChangedListener(aVar);
    }
}
