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
    private ListView cSI;
    private com.baidu.tieba.aiapps.apps.address.a.b cSJ;

    public EditAddressView(Context context, com.baidu.tieba.aiapps.apps.address.c.b bVar) {
        super(context);
        a(context, bVar);
    }

    private void a(Context context, com.baidu.tieba.aiapps.apps.address.c.b bVar) {
        setBackgroundColor(0);
        this.cSI = new ListView(context);
        this.cSI.setDividerHeight(0);
        fR(com.baidu.swan.apps.u.a.CR().Dq());
        this.cSJ = new com.baidu.tieba.aiapps.apps.address.a.b(context);
        g(bVar);
        this.cSI.setAdapter((ListAdapter) this.cSJ);
        addView(this.cSI, new LinearLayout.LayoutParams(-1, -1));
    }

    public void fR(boolean z) {
        if (z) {
            this.cSI.setBackgroundColor(Color.parseColor("#161616"));
        } else {
            this.cSI.setBackgroundColor(Color.parseColor("#0D000000"));
        }
    }

    public Map<String, Object> getDeliveryEditData() {
        return this.cSJ.getDeliveryEditData();
    }

    public com.baidu.tieba.aiapps.apps.address.a.b getEditAdapter() {
        return this.cSJ;
    }

    public void g(com.baidu.tieba.aiapps.apps.address.c.b bVar) {
        if (bVar != null) {
            this.cSJ.setData(com.baidu.tieba.aiapps.apps.address.c.b.e(bVar));
            this.cSJ.p(com.baidu.tieba.aiapps.apps.address.c.b.b(bVar));
            this.cSJ.q(new HashMap(4));
        }
    }

    public void setDeliveryEditChangedListener(b.a aVar) {
        this.cSJ.setDeliveryEditChangedListener(aVar);
    }
}
