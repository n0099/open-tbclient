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
    private g bkX;
    private e.a dnf;
    private BdMultiPicker.b dng;
    private InterfaceC0325a dnh;
    private JSONArray bbK = new JSONArray();
    private JSONArray bbL = new JSONArray();
    private List<d> dmE = new ArrayList();
    private List<d> dnd = new ArrayList();
    private List<d> dne = new ArrayList();
    private Map<d, List<d>> dmF = new HashMap();
    private Map<d, List<d>> dmG = new HashMap();

    /* renamed from: com.baidu.tieba.aiapps.apps.address.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0325a {
        void aZ(List<d> list);
    }

    public a(Context context) {
        initData(context);
    }

    private void initData(Context context) {
        this.dmE = c.aFI().aFK();
        this.dmF = c.aFI().aFL();
        this.dmG = c.aFI().aFM();
        aFT();
        aFU();
        this.dnf = new e.a(context);
        this.dng = new BdMultiPicker.b() { // from class: com.baidu.tieba.aiapps.apps.address.view.a.1
            @Override // com.baidu.swan.apps.res.ui.BdMultiPicker.b
            public void a(BdMultiPicker bdMultiPicker, JSONObject jSONObject) {
                if (jSONObject != null) {
                    int optInt = jSONObject.optInt("column");
                    int optInt2 = jSONObject.optInt("current");
                    if (optInt != a.this.bbK.length() - 1) {
                        a.this.aG(optInt, optInt2);
                    }
                }
            }
        };
    }

    private void aFT() {
        this.bbL.put(0);
        this.bbL.put(0);
        this.bbL.put(0);
    }

    private void aFU() {
        if (this.dmE.size() > 0) {
            this.bbK.put(bd(this.dmE));
        }
        aF(0, this.bbL.optInt(0));
        aF(1, this.bbL.optInt(1));
    }

    private void aE(int i, int i2) {
        JSONArray optJSONArray;
        if (this.bkX != null && (optJSONArray = this.bbK.optJSONArray(i)) != null) {
            ((e) this.bkX).a(i, optJSONArray, i2);
        }
    }

    private void aF(int i, int i2) {
        JSONArray jSONArray;
        JSONArray jSONArray2 = null;
        if (i == 0) {
            this.dnd = this.dmF.get(this.dmE.get(i2));
            if (this.dnd.size() <= 0) {
                jSONArray = null;
            } else {
                jSONArray = bd(this.dnd);
            }
            jSONArray2 = jSONArray;
        } else if (i == 1) {
            this.dne = this.dmG.get(this.dnd.get(i2));
            if (this.dne.size() > 0) {
                jSONArray2 = bd(this.dne);
            }
        }
        if (jSONArray2 != null) {
            try {
                this.bbK.put(i + 1, jSONArray2);
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    private JSONArray bd(List<d> list) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (d dVar : list) {
            jSONArray.put(dVar.name);
        }
        return jSONArray;
    }

    public void aFV() {
        if (this.bkX == null) {
            this.bkX = this.dnf.p(this.bbK).q(this.bbL).a(this.dng).d("城市选择").b(R.string.aiapps_ok, new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.address.view.a.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    a.this.a(dialogInterface);
                    List<d> N = a.this.N(((e) dialogInterface).getCurrentIndex());
                    if (a.this.dnh != null) {
                        a.this.dnh.aZ(N);
                    }
                }
            }).c(R.string.aiapps_cancel, new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.address.view.a.2
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    a.this.a(dialogInterface);
                }
            }).Qv();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<d> N(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(this.dmE.get(jSONArray.optInt(0)));
        arrayList.add(this.dnd.get(jSONArray.optInt(1)));
        arrayList.add(this.dne.get(jSONArray.optInt(2)));
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DialogInterface dialogInterface) {
        dialogInterface.dismiss();
        this.bkX = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aG(int i, int i2) {
        int i3 = i;
        while (i3 < this.bbK.length() - 1) {
            aF(i3, i3 == i ? i2 : 0);
            aE(i3 + 1, 0);
            i3++;
        }
    }

    public void a(InterfaceC0325a interfaceC0325a) {
        this.dnh = interfaceC0325a;
    }
}
