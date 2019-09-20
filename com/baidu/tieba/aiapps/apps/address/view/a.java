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
    private g aSl;
    private e.a deD;
    private BdMultiPicker.b deE;
    private InterfaceC0293a deF;
    private JSONArray aIO = new JSONArray();
    private JSONArray aIP = new JSONArray();
    private List<d> deb = new ArrayList();
    private List<d> deB = new ArrayList();
    private List<d> deC = new ArrayList();
    private Map<d, List<d>> dec = new HashMap();
    private Map<d, List<d>> ded = new HashMap();

    /* renamed from: com.baidu.tieba.aiapps.apps.address.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0293a {
        void aG(List<d> list);
    }

    public a(Context context) {
        initData(context);
    }

    private void initData(Context context) {
        this.deb = c.aFy().aFA();
        this.dec = c.aFy().aFB();
        this.ded = c.aFy().aFC();
        aFI();
        aFJ();
        this.deD = new e.a(context);
        this.deE = new BdMultiPicker.b() { // from class: com.baidu.tieba.aiapps.apps.address.view.a.1
            @Override // com.baidu.swan.apps.res.ui.BdMultiPicker.b
            public void a(BdMultiPicker bdMultiPicker, JSONObject jSONObject) {
                if (jSONObject != null) {
                    int optInt = jSONObject.optInt("column");
                    int optInt2 = jSONObject.optInt("current");
                    if (optInt != a.this.aIO.length() - 1) {
                        a.this.aH(optInt, optInt2);
                    }
                }
            }
        };
    }

    private void aFI() {
        this.aIP.put(0);
        this.aIP.put(0);
        this.aIP.put(0);
    }

    private void aFJ() {
        if (this.deb.size() > 0) {
            this.aIO.put(aK(this.deb));
        }
        aG(0, this.aIP.optInt(0));
        aG(1, this.aIP.optInt(1));
    }

    private void aF(int i, int i2) {
        JSONArray optJSONArray;
        if (this.aSl != null && (optJSONArray = this.aIO.optJSONArray(i)) != null) {
            ((e) this.aSl).a(i, optJSONArray, i2);
        }
    }

    private void aG(int i, int i2) {
        JSONArray jSONArray;
        JSONArray jSONArray2 = null;
        if (i == 0) {
            this.deB = this.dec.get(this.deb.get(i2));
            if (this.deB.size() <= 0) {
                jSONArray = null;
            } else {
                jSONArray = aK(this.deB);
            }
            jSONArray2 = jSONArray;
        } else if (i == 1) {
            this.deC = this.ded.get(this.deB.get(i2));
            if (this.deC.size() > 0) {
                jSONArray2 = aK(this.deC);
            }
        }
        if (jSONArray2 != null) {
            try {
                this.aIO.put(i + 1, jSONArray2);
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

    public void aFK() {
        if (this.aSl == null) {
            this.aSl = this.deD.h(this.aIO).i(this.aIP).a(this.deE).d("城市选择").b(R.string.aiapps_ok, new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.address.view.a.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    a.this.a(dialogInterface);
                    List<d> F = a.this.F(((e) dialogInterface).getCurrentIndex());
                    if (a.this.deF != null) {
                        a.this.deF.aG(F);
                    }
                }
            }).c(R.string.aiapps_cancel, new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.address.view.a.2
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    a.this.a(dialogInterface);
                }
            }).LB();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<d> F(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(this.deb.get(jSONArray.optInt(0)));
        arrayList.add(this.deB.get(jSONArray.optInt(1)));
        arrayList.add(this.deC.get(jSONArray.optInt(2)));
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DialogInterface dialogInterface) {
        dialogInterface.dismiss();
        this.aSl = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aH(int i, int i2) {
        int i3 = i;
        while (i3 < this.aIO.length() - 1) {
            aG(i3, i3 == i ? i2 : 0);
            aF(i3 + 1, 0);
            i3++;
        }
    }

    public void a(InterfaceC0293a interfaceC0293a) {
        this.deF = interfaceC0293a;
    }
}
