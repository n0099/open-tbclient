package com.baidu.tieba.aiapps.apps.address.view;

import android.content.Context;
import android.graphics.Color;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.baidu.swan.apps.c;
import com.baidu.tieba.aiapps.apps.address.a.b;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public class EditAddressView extends LinearLayout {
    private static final boolean DEBUG = c.DEBUG;
    private ListView cSK;
    private b cSL;

    public EditAddressView(Context context, com.baidu.tieba.aiapps.apps.address.c.b bVar) {
        super(context);
        a(context, bVar);
    }

    private void a(Context context, com.baidu.tieba.aiapps.apps.address.c.b bVar) {
        setBackgroundColor(0);
        this.cSK = new ListView(context);
        this.cSK.setDividerHeight(0);
        fR(com.baidu.swan.apps.u.a.CT().Ds());
        this.cSL = new b(context);
        g(bVar);
        this.cSK.setAdapter((ListAdapter) this.cSL);
        addView(this.cSK, new LinearLayout.LayoutParams(-1, -1));
    }

    public void fR(boolean z) {
        if (z) {
            this.cSK.setBackgroundColor(Color.parseColor("#161616"));
        } else {
            this.cSK.setBackgroundColor(Color.parseColor("#0D000000"));
        }
    }

    public Map<String, Object> getDeliveryEditData() {
        return this.cSL.getDeliveryEditData();
    }

    public b getEditAdapter() {
        return this.cSL;
    }

    public void g(com.baidu.tieba.aiapps.apps.address.c.b bVar) {
        if (bVar != null) {
            this.cSL.setData(com.baidu.tieba.aiapps.apps.address.c.b.e(bVar));
            this.cSL.p(com.baidu.tieba.aiapps.apps.address.c.b.b(bVar));
            this.cSL.q(new HashMap(4));
        }
    }

    public void setDeliveryEditChangedListener(b.a aVar) {
        this.cSL.setDeliveryEditChangedListener(aVar);
    }
}
