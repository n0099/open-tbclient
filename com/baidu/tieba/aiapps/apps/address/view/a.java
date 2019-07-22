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
    private e.a dcJ;
    private BdMultiPicker.b dcK;
    private InterfaceC0278a dcL;
    private JSONArray aIq = new JSONArray();
    private JSONArray aIr = new JSONArray();
    private List<d> dch = new ArrayList();
    private List<d> dcH = new ArrayList();
    private List<d> dcI = new ArrayList();
    private Map<d, List<d>> dci = new HashMap();
    private Map<d, List<d>> dcj = new HashMap();

    /* renamed from: com.baidu.tieba.aiapps.apps.address.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0278a {
        void aG(List<d> list);
    }

    public a(Context context) {
        initData(context);
    }

    private void initData(Context context) {
        this.dch = c.aES().aEU();
        this.dci = c.aES().aEV();
        this.dcj = c.aES().aEW();
        aFc();
        aFd();
        this.dcJ = new e.a(context);
        this.dcK = new BdMultiPicker.b() { // from class: com.baidu.tieba.aiapps.apps.address.view.a.1
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

    private void aFc() {
        this.aIr.put(0);
        this.aIr.put(0);
        this.aIr.put(0);
    }

    private void aFd() {
        if (this.dch.size() > 0) {
            this.aIq.put(aK(this.dch));
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
            this.dcH = this.dci.get(this.dch.get(i2));
            if (this.dcH.size() <= 0) {
                jSONArray = null;
            } else {
                jSONArray = aK(this.dcH);
            }
            jSONArray2 = jSONArray;
        } else if (i == 1) {
            this.dcI = this.dcj.get(this.dcH.get(i2));
            if (this.dcI.size() > 0) {
                jSONArray2 = aK(this.dcI);
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

    public void aFe() {
        if (this.aRN == null) {
            this.aRN = this.dcJ.h(this.aIq).i(this.aIr).a(this.dcK).d("城市选择").b(R.string.aiapps_ok, new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.address.view.a.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    a.this.a(dialogInterface);
                    List<d> F = a.this.F(((e) dialogInterface).getCurrentIndex());
                    if (a.this.dcL != null) {
                        a.this.dcL.aG(F);
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
        arrayList.add(this.dch.get(jSONArray.optInt(0)));
        arrayList.add(this.dcH.get(jSONArray.optInt(1)));
        arrayList.add(this.dcI.get(jSONArray.optInt(2)));
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

    public void a(InterfaceC0278a interfaceC0278a) {
        this.dcL = interfaceC0278a;
    }
}
