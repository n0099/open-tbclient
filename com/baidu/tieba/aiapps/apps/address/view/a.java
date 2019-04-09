package com.baidu.tieba.aiapps.apps.address.view;

import android.content.Context;
import android.content.DialogInterface;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.res.ui.BdMultiPicker;
import com.baidu.swan.apps.res.widget.dialog.d;
import com.baidu.swan.apps.res.widget.dialog.e;
import com.baidu.tieba.aiapps.apps.address.b.c;
import com.baidu.tieba.d;
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
    private e aOZ;
    private d.a cSN;
    private BdMultiPicker.b cSO;
    private InterfaceC0266a cSP;
    private JSONArray aFP = new JSONArray();
    private JSONArray aFQ = new JSONArray();
    private List<com.baidu.tieba.aiapps.apps.address.c.d> cSm = new ArrayList();
    private List<com.baidu.tieba.aiapps.apps.address.c.d> cSL = new ArrayList();
    private List<com.baidu.tieba.aiapps.apps.address.c.d> cSM = new ArrayList();
    private Map<com.baidu.tieba.aiapps.apps.address.c.d, List<com.baidu.tieba.aiapps.apps.address.c.d>> cSn = new HashMap();
    private Map<com.baidu.tieba.aiapps.apps.address.c.d, List<com.baidu.tieba.aiapps.apps.address.c.d>> cSo = new HashMap();

    /* renamed from: com.baidu.tieba.aiapps.apps.address.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0266a {
        void az(List<com.baidu.tieba.aiapps.apps.address.c.d> list);
    }

    public a(Context context) {
        initData(context);
    }

    private void initData(Context context) {
        this.cSm = c.ayr().ayt();
        this.cSn = c.ayr().ayu();
        this.cSo = c.ayr().ayv();
        ayB();
        ayC();
        this.cSN = new d.a(context);
        this.cSO = new BdMultiPicker.b() { // from class: com.baidu.tieba.aiapps.apps.address.view.a.1
            @Override // com.baidu.swan.apps.res.ui.BdMultiPicker.b
            public void a(BdMultiPicker bdMultiPicker, JSONObject jSONObject) {
                if (jSONObject != null) {
                    int optInt = jSONObject.optInt("column");
                    int optInt2 = jSONObject.optInt("current");
                    if (optInt != a.this.aFP.length() - 1) {
                        a.this.aC(optInt, optInt2);
                    }
                }
            }
        };
    }

    private void ayB() {
        this.aFQ.put(0);
        this.aFQ.put(0);
        this.aFQ.put(0);
    }

    private void ayC() {
        if (this.cSm.size() > 0) {
            this.aFP.put(aD(this.cSm));
        }
        aB(0, this.aFQ.optInt(0));
        aB(1, this.aFQ.optInt(1));
    }

    private void aA(int i, int i2) {
        JSONArray optJSONArray;
        if (this.aOZ != null && (optJSONArray = this.aFP.optJSONArray(i)) != null) {
            ((d) this.aOZ).a(i, optJSONArray, i2);
        }
    }

    private void aB(int i, int i2) {
        JSONArray jSONArray;
        JSONArray jSONArray2 = null;
        if (i == 0) {
            this.cSL = this.cSn.get(this.cSm.get(i2));
            if (this.cSL.size() <= 0) {
                jSONArray = null;
            } else {
                jSONArray = aD(this.cSL);
            }
            jSONArray2 = jSONArray;
        } else if (i == 1) {
            this.cSM = this.cSo.get(this.cSL.get(i2));
            if (this.cSM.size() > 0) {
                jSONArray2 = aD(this.cSM);
            }
        }
        if (jSONArray2 != null) {
            try {
                this.aFP.put(i + 1, jSONArray2);
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    private JSONArray aD(List<com.baidu.tieba.aiapps.apps.address.c.d> list) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (com.baidu.tieba.aiapps.apps.address.c.d dVar : list) {
            jSONArray.put(dVar.name);
        }
        return jSONArray;
    }

    public void ayD() {
        if (this.aOZ == null) {
            this.aOZ = this.cSN.j(this.aFP).k(this.aFQ).a(this.cSO).d("城市选择").b(d.j.aiapps_ok, new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.address.view.a.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    a.this.a(dialogInterface);
                    List<com.baidu.tieba.aiapps.apps.address.c.d> E = a.this.E(((com.baidu.swan.apps.res.widget.dialog.d) dialogInterface).getCurrentIndex());
                    if (a.this.cSP != null) {
                        a.this.cSP.az(E);
                    }
                }
            }).c(d.j.aiapps_cancel, new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.address.view.a.2
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    a.this.a(dialogInterface);
                }
            }).Is();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<com.baidu.tieba.aiapps.apps.address.c.d> E(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(this.cSm.get(jSONArray.optInt(0)));
        arrayList.add(this.cSL.get(jSONArray.optInt(1)));
        arrayList.add(this.cSM.get(jSONArray.optInt(2)));
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DialogInterface dialogInterface) {
        dialogInterface.dismiss();
        this.aOZ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aC(int i, int i2) {
        int i3 = i;
        while (i3 < this.aFP.length() - 1) {
            aB(i3, i3 == i ? i2 : 0);
            aA(i3 + 1, 0);
            i3++;
        }
    }

    public void a(InterfaceC0266a interfaceC0266a) {
        this.cSP = interfaceC0266a;
    }
}
