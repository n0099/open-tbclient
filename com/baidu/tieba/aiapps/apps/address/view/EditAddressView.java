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
    private ListView dbf;
    private com.baidu.tieba.aiapps.apps.address.a.b dbg;

    public EditAddressView(Context context, com.baidu.tieba.aiapps.apps.address.c.b bVar) {
        super(context);
        a(context, bVar);
    }

    private void a(Context context, com.baidu.tieba.aiapps.apps.address.c.b bVar) {
        setBackgroundColor(0);
        this.dbf = new ListView(context);
        this.dbf.setDividerHeight(0);
        go(com.baidu.swan.apps.u.a.DW().Ev());
        this.dbg = new com.baidu.tieba.aiapps.apps.address.a.b(context);
        g(bVar);
        this.dbf.setAdapter((ListAdapter) this.dbg);
        addView(this.dbf, new LinearLayout.LayoutParams(-1, -1));
    }

    public void go(boolean z) {
        if (z) {
            this.dbf.setBackgroundColor(Color.parseColor("#161616"));
        } else {
            this.dbf.setBackgroundColor(Color.parseColor("#0D000000"));
        }
    }

    public Map<String, Object> getDeliveryEditData() {
        return this.dbg.getDeliveryEditData();
    }

    public com.baidu.tieba.aiapps.apps.address.a.b getEditAdapter() {
        return this.dbg;
    }

    public void g(com.baidu.tieba.aiapps.apps.address.c.b bVar) {
        if (bVar != null) {
            this.dbg.setData(com.baidu.tieba.aiapps.apps.address.c.b.e(bVar));
            this.dbg.p(com.baidu.tieba.aiapps.apps.address.c.b.b(bVar));
            this.dbg.q(new HashMap(4));
        }
    }

    public void setDeliveryEditChangedListener(b.a aVar) {
        this.dbg.setDeliveryEditChangedListener(aVar);
    }
}
