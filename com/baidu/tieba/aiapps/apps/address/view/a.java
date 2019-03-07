package com.baidu.tieba.aiapps.apps.address.view;

import android.content.Context;
import android.content.DialogInterface;
import com.baidu.swan.apps.c;
import com.baidu.swan.apps.res.ui.BdMultiPicker;
import com.baidu.swan.apps.res.widget.dialog.d;
import com.baidu.swan.apps.res.widget.dialog.e;
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
    private static final boolean DEBUG = c.DEBUG;
    private e aOU;
    private d.a cSO;
    private BdMultiPicker.b cSP;
    private InterfaceC0227a cSQ;
    private JSONArray aFK = new JSONArray();
    private JSONArray aFL = new JSONArray();
    private List<com.baidu.tieba.aiapps.apps.address.c.d> cSn = new ArrayList();
    private List<com.baidu.tieba.aiapps.apps.address.c.d> cSM = new ArrayList();
    private List<com.baidu.tieba.aiapps.apps.address.c.d> cSN = new ArrayList();
    private Map<com.baidu.tieba.aiapps.apps.address.c.d, List<com.baidu.tieba.aiapps.apps.address.c.d>> cSo = new HashMap();
    private Map<com.baidu.tieba.aiapps.apps.address.c.d, List<com.baidu.tieba.aiapps.apps.address.c.d>> cSp = new HashMap();

    /* renamed from: com.baidu.tieba.aiapps.apps.address.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0227a {
        void az(List<com.baidu.tieba.aiapps.apps.address.c.d> list);
    }

    public a(Context context) {
        initData(context);
    }

    private void initData(Context context) {
        this.cSn = com.baidu.tieba.aiapps.apps.address.b.c.ayu().ayw();
        this.cSo = com.baidu.tieba.aiapps.apps.address.b.c.ayu().ayx();
        this.cSp = com.baidu.tieba.aiapps.apps.address.b.c.ayu().ayy();
        ayE();
        ayF();
        this.cSO = new d.a(context);
        this.cSP = new BdMultiPicker.b() { // from class: com.baidu.tieba.aiapps.apps.address.view.a.1
            @Override // com.baidu.swan.apps.res.ui.BdMultiPicker.b
            public void a(BdMultiPicker bdMultiPicker, JSONObject jSONObject) {
                if (jSONObject != null) {
                    int optInt = jSONObject.optInt("column");
                    int optInt2 = jSONObject.optInt("current");
                    if (optInt != a.this.aFK.length() - 1) {
                        a.this.aC(optInt, optInt2);
                    }
                }
            }
        };
    }

    private void ayE() {
        this.aFL.put(0);
        this.aFL.put(0);
        this.aFL.put(0);
    }

    private void ayF() {
        if (this.cSn.size() > 0) {
            this.aFK.put(aD(this.cSn));
        }
        aB(0, this.aFL.optInt(0));
        aB(1, this.aFL.optInt(1));
    }

    private void aA(int i, int i2) {
        JSONArray optJSONArray;
        if (this.aOU != null && (optJSONArray = this.aFK.optJSONArray(i)) != null) {
            ((d) this.aOU).a(i, optJSONArray, i2);
        }
    }

    private void aB(int i, int i2) {
        JSONArray jSONArray;
        JSONArray jSONArray2 = null;
        if (i == 0) {
            this.cSM = this.cSo.get(this.cSn.get(i2));
            if (this.cSM.size() <= 0) {
                jSONArray = null;
            } else {
                jSONArray = aD(this.cSM);
            }
            jSONArray2 = jSONArray;
        } else if (i == 1) {
            this.cSN = this.cSp.get(this.cSM.get(i2));
            if (this.cSN.size() > 0) {
                jSONArray2 = aD(this.cSN);
            }
        }
        if (jSONArray2 != null) {
            try {
                this.aFK.put(i + 1, jSONArray2);
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
        if (this.aOU == null) {
            this.aOU = this.cSO.j(this.aFK).k(this.aFL).a(this.cSP).d("城市选择").b(d.j.aiapps_ok, new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.address.view.a.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    a.this.a(dialogInterface);
                    List<com.baidu.tieba.aiapps.apps.address.c.d> E = a.this.E(((com.baidu.swan.apps.res.widget.dialog.d) dialogInterface).getCurrentIndex());
                    if (a.this.cSQ != null) {
                        a.this.cSQ.az(E);
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
        arrayList.add(this.cSn.get(jSONArray.optInt(0)));
        arrayList.add(this.cSM.get(jSONArray.optInt(1)));
        arrayList.add(this.cSN.get(jSONArray.optInt(2)));
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DialogInterface dialogInterface) {
        dialogInterface.dismiss();
        this.aOU = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aC(int i, int i2) {
        int i3 = i;
        while (i3 < this.aFK.length() - 1) {
            aB(i3, i3 == i ? i2 : 0);
            aA(i3 + 1, 0);
            i3++;
        }
    }

    public void a(InterfaceC0227a interfaceC0227a) {
        this.cSQ = interfaceC0227a;
    }
}
