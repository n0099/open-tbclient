package com.baidu.tieba.aiapps.apps.address.view;

import android.content.Context;
import android.content.DialogInterface;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.res.ui.BdMultiPicker;
import com.baidu.swan.apps.res.widget.dialog.e;
import com.baidu.swan.apps.res.widget.dialog.g;
import com.baidu.tieba.R;
import com.baidu.tieba.aiapps.apps.address.b.c;
import com.baidu.tieba.aiapps.apps.address.c.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;
    private g aRN;
    private e.a dcQ;
    private BdMultiPicker.b dcR;
    private InterfaceC0284a dcS;
    private JSONArray aIq = new JSONArray();
    private JSONArray aIr = new JSONArray();
    private List<d> dco = new ArrayList();
    private List<d> dcO = new ArrayList();
    private List<d> dcP = new ArrayList();
    private Map<d, List<d>> dcp = new HashMap();
    private Map<d, List<d>> dcq = new HashMap();

    /* renamed from: com.baidu.tieba.aiapps.apps.address.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0284a {
        void aG(List<d> list);
    }

    public a(Context context) {
        initData(context);
    }

    private void initData(Context context) {
        this.dco = c.aEU().aEW();
        this.dcp = c.aEU().aEX();
        this.dcq = c.aEU().aEY();
        aFe();
        aFf();
        this.dcQ = new e.a(context);
        this.dcR = new BdMultiPicker.b() { // from class: com.baidu.tieba.aiapps.apps.address.view.a.1
            @Override // com.baidu.swan.apps.res.ui.BdMultiPicker.b
            public void a(BdMultiPicker bdMultiPicker, JSONObject jSONObject) {
                if (jSONObject != null) {
                    int optInt = jSONObject.optInt("column");
                    int optInt2 = jSONObject.optInt("current");
                    if (optInt != a.this.aIq.length() - 1) {
                        a.this.aH(optInt, optInt2);
                    }
                }
            }
        };
    }

    private void aFe() {
        this.aIr.put(0);
        this.aIr.put(0);
        this.aIr.put(0);
    }

    private void aFf() {
        if (this.dco.size() > 0) {
            this.aIq.put(aK(this.dco));
        }
        aG(0, this.aIr.optInt(0));
        aG(1, this.aIr.optInt(1));
    }

    private void aF(int i, int i2) {
        JSONArray optJSONArray;
        if (this.aRN != null && (optJSONArray = this.aIq.optJSONArray(i)) != null) {
            ((e) this.aRN).a(i, optJSONArray, i2);
        }
    }

    private void aG(int i, int i2) {
        JSONArray jSONArray;
        JSONArray jSONArray2 = null;
        if (i == 0) {
            this.dcO = this.dcp.get(this.dco.get(i2));
            if (this.dcO.size() <= 0) {
                jSONArray = null;
            } else {
                jSONArray = aK(this.dcO);
            }
            jSONArray2 = jSONArray;
        } else if (i == 1) {
            this.dcP = this.dcq.get(this.dcO.get(i2));
            if (this.dcP.size() > 0) {
                jSONArray2 = aK(this.dcP);
            }
        }
        if (jSONArray2 != null) {
            try {
                this.aIq.put(i + 1, jSONArray2);
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    private JSONArray aK(List<d> list) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (d dVar : list) {
            jSONArray.put(dVar.name);
        }
        return jSONArray;
    }

    public void aFg() {
        if (this.aRN == null) {
            this.aRN = this.dcQ.h(this.aIq).i(this.aIr).a(this.dcR).d("城市选择").b(R.string.aiapps_ok, new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.address.view.a.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    a.this.a(dialogInterface);
                    List<d> F = a.this.F(((e) dialogInterface).getCurrentIndex());
                    if (a.this.dcS != null) {
                        a.this.dcS.aG(F);
                    }
                }
            }).c(R.string.aiapps_cancel, new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.address.view.a.2
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    a.this.a(dialogInterface);
                }
            }).Lx();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<d> F(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(this.dco.get(jSONArray.optInt(0)));
        arrayList.add(this.dcO.get(jSONArray.optInt(1)));
        arrayList.add(this.dcP.get(jSONArray.optInt(2)));
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DialogInterface dialogInterface) {
        dialogInterface.dismiss();
        this.aRN = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aH(int i, int i2) {
        int i3 = i;
        while (i3 < this.aIq.length() - 1) {
            aG(i3, i3 == i ? i2 : 0);
            aF(i3 + 1, 0);
            i3++;
        }
    }

    public void a(InterfaceC0284a interfaceC0284a) {
        this.dcS = interfaceC0284a;
    }
}
