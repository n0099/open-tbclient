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
    private ListView cSG;
    private com.baidu.tieba.aiapps.apps.address.a.b cSH;

    public EditAddressView(Context context, com.baidu.tieba.aiapps.apps.address.c.b bVar) {
        super(context);
        a(context, bVar);
    }

    private void a(Context context, com.baidu.tieba.aiapps.apps.address.c.b bVar) {
        setBackgroundColor(0);
        this.cSG = new ListView(context);
        this.cSG.setDividerHeight(0);
        fR(com.baidu.swan.apps.u.a.CT().Ds());
        this.cSH = new com.baidu.tieba.aiapps.apps.address.a.b(context);
        g(bVar);
        this.cSG.setAdapter((ListAdapter) this.cSH);
        addView(this.cSG, new LinearLayout.LayoutParams(-1, -1));
    }

    public void fR(boolean z) {
        if (z) {
            this.cSG.setBackgroundColor(Color.parseColor("#161616"));
        } else {
            this.cSG.setBackgroundColor(Color.parseColor("#0D000000"));
        }
    }

    public Map<String, Object> getDeliveryEditData() {
        return this.cSH.getDeliveryEditData();
    }

    public com.baidu.tieba.aiapps.apps.address.a.b getEditAdapter() {
        return this.cSH;
    }

    public void g(com.baidu.tieba.aiapps.apps.address.c.b bVar) {
        if (bVar != null) {
            this.cSH.setData(com.baidu.tieba.aiapps.apps.address.c.b.e(bVar));
            this.cSH.p(com.baidu.tieba.aiapps.apps.address.c.b.b(bVar));
            this.cSH.q(new HashMap(4));
        }
    }

    public void setDeliveryEditChangedListener(b.a aVar) {
        this.cSH.setDeliveryEditChangedListener(aVar);
    }
}
