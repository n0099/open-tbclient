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
    private ListView dcF;
    private com.baidu.tieba.aiapps.apps.address.a.b dcG;

    public EditAddressView(Context context, com.baidu.tieba.aiapps.apps.address.c.b bVar) {
        super(context);
        a(context, bVar);
    }

    private void a(Context context, com.baidu.tieba.aiapps.apps.address.c.b bVar) {
        setBackgroundColor(0);
        this.dcF = new ListView(context);
        this.dcF.setDividerHeight(0);
        gs(com.baidu.swan.apps.u.a.EF().Fe());
        this.dcG = new com.baidu.tieba.aiapps.apps.address.a.b(context);
        g(bVar);
        this.dcF.setAdapter((ListAdapter) this.dcG);
        addView(this.dcF, new LinearLayout.LayoutParams(-1, -1));
    }

    public void gs(boolean z) {
        if (z) {
            this.dcF.setBackgroundColor(Color.parseColor("#161616"));
        } else {
            this.dcF.setBackgroundColor(Color.parseColor("#0D000000"));
        }
    }

    public Map<String, Object> getDeliveryEditData() {
        return this.dcG.getDeliveryEditData();
    }

    public com.baidu.tieba.aiapps.apps.address.a.b getEditAdapter() {
        return this.dcG;
    }

    public void g(com.baidu.tieba.aiapps.apps.address.c.b bVar) {
        if (bVar != null) {
            this.dcG.setData(com.baidu.tieba.aiapps.apps.address.c.b.e(bVar));
            this.dcG.p(com.baidu.tieba.aiapps.apps.address.c.b.b(bVar));
            this.dcG.q(new HashMap(4));
        }
    }

    public void setDeliveryEditChangedListener(b.a aVar) {
        this.dcG.setDeliveryEditChangedListener(aVar);
    }
}
