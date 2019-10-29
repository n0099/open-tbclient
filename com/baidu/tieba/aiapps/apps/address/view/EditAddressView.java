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
    private ListView dnT;
    private com.baidu.tieba.aiapps.apps.address.a.b dnU;

    public EditAddressView(Context context, com.baidu.tieba.aiapps.apps.address.c.b bVar) {
        super(context);
        a(context, bVar);
    }

    private void a(Context context, com.baidu.tieba.aiapps.apps.address.c.b bVar) {
        setBackgroundColor(0);
        this.dnT = new ListView(context);
        this.dnT.setDividerHeight(0);
        gk(com.baidu.swan.apps.u.a.JD().Kc());
        this.dnU = new com.baidu.tieba.aiapps.apps.address.a.b(context);
        g(bVar);
        this.dnT.setAdapter((ListAdapter) this.dnU);
        addView(this.dnT, new LinearLayout.LayoutParams(-1, -1));
    }

    public void gk(boolean z) {
        if (z) {
            this.dnT.setBackgroundColor(Color.parseColor("#161616"));
        } else {
            this.dnT.setBackgroundColor(Color.parseColor("#0D000000"));
        }
    }

    public Map<String, Object> getDeliveryEditData() {
        return this.dnU.getDeliveryEditData();
    }

    public com.baidu.tieba.aiapps.apps.address.a.b getEditAdapter() {
        return this.dnU;
    }

    public void g(com.baidu.tieba.aiapps.apps.address.c.b bVar) {
        if (bVar != null) {
            this.dnU.setData(com.baidu.tieba.aiapps.apps.address.c.b.e(bVar));
            this.dnU.q(com.baidu.tieba.aiapps.apps.address.c.b.b(bVar));
            this.dnU.r(new HashMap(4));
        }
    }

    public void setDeliveryEditChangedListener(b.a aVar) {
        this.dnU.setDeliveryEditChangedListener(aVar);
    }
}
