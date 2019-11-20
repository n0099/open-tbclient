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
    private ListView dnb;
    private com.baidu.tieba.aiapps.apps.address.a.b dnc;

    public EditAddressView(Context context, com.baidu.tieba.aiapps.apps.address.c.b bVar) {
        super(context);
        a(context, bVar);
    }

    private void a(Context context, com.baidu.tieba.aiapps.apps.address.c.b bVar) {
        setBackgroundColor(0);
        this.dnb = new ListView(context);
        this.dnb.setDividerHeight(0);
        gk(com.baidu.swan.apps.u.a.JE().Kd());
        this.dnc = new com.baidu.tieba.aiapps.apps.address.a.b(context);
        g(bVar);
        this.dnb.setAdapter((ListAdapter) this.dnc);
        addView(this.dnb, new LinearLayout.LayoutParams(-1, -1));
    }

    public void gk(boolean z) {
        if (z) {
            this.dnb.setBackgroundColor(Color.parseColor("#161616"));
        } else {
            this.dnb.setBackgroundColor(Color.parseColor("#0D000000"));
        }
    }

    public Map<String, Object> getDeliveryEditData() {
        return this.dnc.getDeliveryEditData();
    }

    public com.baidu.tieba.aiapps.apps.address.a.b getEditAdapter() {
        return this.dnc;
    }

    public void g(com.baidu.tieba.aiapps.apps.address.c.b bVar) {
        if (bVar != null) {
            this.dnc.setData(com.baidu.tieba.aiapps.apps.address.c.b.e(bVar));
            this.dnc.q(com.baidu.tieba.aiapps.apps.address.c.b.b(bVar));
            this.dnc.r(new HashMap(4));
        }
    }

    public void setDeliveryEditChangedListener(b.a aVar) {
        this.dnc.setDeliveryEditChangedListener(aVar);
    }
}
