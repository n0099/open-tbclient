package com.baidu.tieba.aiapps.apps.address.view;

import android.content.Context;
import android.graphics.Color;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.baidu.searchbox.ng.ai.apps.skin.AiAppNightModeHelper;
import com.baidu.tieba.aiapps.apps.address.a.b;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public class EditAddressView extends LinearLayout {
    private ListView bCr;
    private b bCs;

    public EditAddressView(Context context, com.baidu.tieba.aiapps.apps.address.c.b bVar) {
        super(context);
        a(context, bVar);
    }

    private void a(Context context, com.baidu.tieba.aiapps.apps.address.c.b bVar) {
        setBackgroundColor(0);
        this.bCr = new ListView(context);
        this.bCr.setDividerHeight(0);
        onNightModeChanged(AiAppNightModeHelper.getNightModeSwitcherState());
        this.bCs = new b(context);
        g(bVar);
        this.bCr.setAdapter((ListAdapter) this.bCs);
        addView(this.bCr, new LinearLayout.LayoutParams(-1, -1));
    }

    public void onNightModeChanged(boolean z) {
        if (z) {
            this.bCr.setBackgroundColor(Color.parseColor("#161616"));
        } else {
            this.bCr.setBackgroundColor(Color.parseColor("#0D000000"));
        }
    }

    public Map<String, Object> getDeliveryEditData() {
        return this.bCs.getDeliveryEditData();
    }

    public b getEditAdapter() {
        return this.bCs;
    }

    public void g(com.baidu.tieba.aiapps.apps.address.c.b bVar) {
        if (bVar != null) {
            this.bCs.setData(com.baidu.tieba.aiapps.apps.address.c.b.e(bVar));
            this.bCs.l(com.baidu.tieba.aiapps.apps.address.c.b.b(bVar));
            this.bCs.m(new HashMap(4));
        }
    }

    public void setDeliveryEditChangedListener(b.a aVar) {
        this.bCs.setDeliveryEditChangedListener(aVar);
    }
}
