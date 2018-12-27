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
    private b bGA;
    private ListView bGz;

    public EditAddressView(Context context, com.baidu.tieba.aiapps.apps.address.c.b bVar) {
        super(context);
        a(context, bVar);
    }

    private void a(Context context, com.baidu.tieba.aiapps.apps.address.c.b bVar) {
        setBackgroundColor(0);
        this.bGz = new ListView(context);
        this.bGz.setDividerHeight(0);
        onNightModeChanged(AiAppNightModeHelper.getNightModeSwitcherState());
        this.bGA = new b(context);
        g(bVar);
        this.bGz.setAdapter((ListAdapter) this.bGA);
        addView(this.bGz, new LinearLayout.LayoutParams(-1, -1));
    }

    public void onNightModeChanged(boolean z) {
        if (z) {
            this.bGz.setBackgroundColor(Color.parseColor("#161616"));
        } else {
            this.bGz.setBackgroundColor(Color.parseColor("#0D000000"));
        }
    }

    public Map<String, Object> getDeliveryEditData() {
        return this.bGA.getDeliveryEditData();
    }

    public b getEditAdapter() {
        return this.bGA;
    }

    public void g(com.baidu.tieba.aiapps.apps.address.c.b bVar) {
        if (bVar != null) {
            this.bGA.setData(com.baidu.tieba.aiapps.apps.address.c.b.e(bVar));
            this.bGA.o(com.baidu.tieba.aiapps.apps.address.c.b.b(bVar));
            this.bGA.p(new HashMap(4));
        }
    }

    public void setDeliveryEditChangedListener(b.a aVar) {
        this.bGA.setDeliveryEditChangedListener(aVar);
    }
}
