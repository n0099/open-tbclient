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
    private ListView dcM;
    private com.baidu.tieba.aiapps.apps.address.a.b dcN;

    public EditAddressView(Context context, com.baidu.tieba.aiapps.apps.address.c.b bVar) {
        super(context);
        a(context, bVar);
    }

    private void a(Context context, com.baidu.tieba.aiapps.apps.address.c.b bVar) {
        setBackgroundColor(0);
        this.dcM = new ListView(context);
        this.dcM.setDividerHeight(0);
        gs(com.baidu.swan.apps.u.a.EF().Fe());
        this.dcN = new com.baidu.tieba.aiapps.apps.address.a.b(context);
        g(bVar);
        this.dcM.setAdapter((ListAdapter) this.dcN);
        addView(this.dcM, new LinearLayout.LayoutParams(-1, -1));
    }

    public void gs(boolean z) {
        if (z) {
            this.dcM.setBackgroundColor(Color.parseColor("#161616"));
        } else {
            this.dcM.setBackgroundColor(Color.parseColor("#0D000000"));
        }
    }

    public Map<String, Object> getDeliveryEditData() {
        return this.dcN.getDeliveryEditData();
    }

    public com.baidu.tieba.aiapps.apps.address.a.b getEditAdapter() {
        return this.dcN;
    }

    public void g(com.baidu.tieba.aiapps.apps.address.c.b bVar) {
        if (bVar != null) {
            this.dcN.setData(com.baidu.tieba.aiapps.apps.address.c.b.e(bVar));
            this.dcN.p(com.baidu.tieba.aiapps.apps.address.c.b.b(bVar));
            this.dcN.q(new HashMap(4));
        }
    }

    public void setDeliveryEditChangedListener(b.a aVar) {
        this.dcN.setDeliveryEditChangedListener(aVar);
    }
}
