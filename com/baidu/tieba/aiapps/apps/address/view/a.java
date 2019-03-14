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
    private e aOV;
    private d.a cSK;
    private BdMultiPicker.b cSL;
    private InterfaceC0266a cSM;
    private JSONArray aFL = new JSONArray();
    private JSONArray aFM = new JSONArray();
    private List<com.baidu.tieba.aiapps.apps.address.c.d> cSj = new ArrayList();
    private List<com.baidu.tieba.aiapps.apps.address.c.d> cSI = new ArrayList();
    private List<com.baidu.tieba.aiapps.apps.address.c.d> cSJ = new ArrayList();
    private Map<com.baidu.tieba.aiapps.apps.address.c.d, List<com.baidu.tieba.aiapps.apps.address.c.d>> cSk = new HashMap();
    private Map<com.baidu.tieba.aiapps.apps.address.c.d, List<com.baidu.tieba.aiapps.apps.address.c.d>> cSl = new HashMap();

    /* renamed from: com.baidu.tieba.aiapps.apps.address.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0266a {
        void az(List<com.baidu.tieba.aiapps.apps.address.c.d> list);
    }

    public a(Context context) {
        initData(context);
    }

    private void initData(Context context) {
        this.cSj = c.ayu().ayw();
        this.cSk = c.ayu().ayx();
        this.cSl = c.ayu().ayy();
        ayE();
        ayF();
        this.cSK = new d.a(context);
        this.cSL = new BdMultiPicker.b() { // from class: com.baidu.tieba.aiapps.apps.address.view.a.1
            @Override // com.baidu.swan.apps.res.ui.BdMultiPicker.b
            public void a(BdMultiPicker bdMultiPicker, JSONObject jSONObject) {
                if (jSONObject != null) {
                    int optInt = jSONObject.optInt("column");
                    int optInt2 = jSONObject.optInt("current");
                    if (optInt != a.this.aFL.length() - 1) {
                        a.this.aC(optInt, optInt2);
                    }
                }
            }
        };
    }

    private void ayE() {
        this.aFM.put(0);
        this.aFM.put(0);
        this.aFM.put(0);
    }

    private void ayF() {
        if (this.cSj.size() > 0) {
            this.aFL.put(aD(this.cSj));
        }
        aB(0, this.aFM.optInt(0));
        aB(1, this.aFM.optInt(1));
    }

    private void aA(int i, int i2) {
        JSONArray optJSONArray;
        if (this.aOV != null && (optJSONArray = this.aFL.optJSONArray(i)) != null) {
            ((d) this.aOV).a(i, optJSONArray, i2);
        }
    }

    private void aB(int i, int i2) {
        JSONArray jSONArray;
        JSONArray jSONArray2 = null;
        if (i == 0) {
            this.cSI = this.cSk.get(this.cSj.get(i2));
            if (this.cSI.size() <= 0) {
                jSONArray = null;
            } else {
                jSONArray = aD(this.cSI);
            }
            jSONArray2 = jSONArray;
        } else if (i == 1) {
            this.cSJ = this.cSl.get(this.cSI.get(i2));
            if (this.cSJ.size() > 0) {
                jSONArray2 = aD(this.cSJ);
            }
        }
        if (jSONArray2 != null) {
            try {
                this.aFL.put(i + 1, jSONArray2);
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

    public void ayG() {
        if (this.aOV == null) {
            this.aOV = this.cSK.j(this.aFL).k(this.aFM).a(this.cSL).d("城市选择").b(d.j.aiapps_ok, new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.address.view.a.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    a.this.a(dialogInterface);
                    List<com.baidu.tieba.aiapps.apps.address.c.d> E = a.this.E(((com.baidu.swan.apps.res.widget.dialog.d) dialogInterface).getCurrentIndex());
                    if (a.this.cSM != null) {
                        a.this.cSM.az(E);
                    }
                }
            }).c(d.j.aiapps_cancel, new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.address.view.a.2
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    a.this.a(dialogInterface);
                }
            }).Iu();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<com.baidu.tieba.aiapps.apps.address.c.d> E(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(this.cSj.get(jSONArray.optInt(0)));
        arrayList.add(this.cSI.get(jSONArray.optInt(1)));
        arrayList.add(this.cSJ.get(jSONArray.optInt(2)));
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DialogInterface dialogInterface) {
        dialogInterface.dismiss();
        this.aOV = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aC(int i, int i2) {
        int i3 = i;
        while (i3 < this.aFL.length() - 1) {
            aB(i3, i3 == i ? i2 : 0);
            aA(i3 + 1, 0);
            i3++;
        }
    }

    public void a(InterfaceC0266a interfaceC0266a) {
        this.cSM = interfaceC0266a;
    }
}
