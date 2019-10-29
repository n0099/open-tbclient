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
    private g blp;
    private e.a dnX;
    private BdMultiPicker.b dnY;
    private InterfaceC0325a dnZ;
    private JSONArray bcc = new JSONArray();
    private JSONArray bcd = new JSONArray();
    private List<d> dnw = new ArrayList();
    private List<d> dnV = new ArrayList();
    private List<d> dnW = new ArrayList();
    private Map<d, List<d>> dnx = new HashMap();
    private Map<d, List<d>> dny = new HashMap();

    /* renamed from: com.baidu.tieba.aiapps.apps.address.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0325a {
        void aZ(List<d> list);
    }

    public a(Context context) {
        initData(context);
    }

    private void initData(Context context) {
        this.dnw = c.aFK().aFM();
        this.dnx = c.aFK().aFN();
        this.dny = c.aFK().aFO();
        aFV();
        aFW();
        this.dnX = new e.a(context);
        this.dnY = new BdMultiPicker.b() { // from class: com.baidu.tieba.aiapps.apps.address.view.a.1
            @Override // com.baidu.swan.apps.res.ui.BdMultiPicker.b
            public void a(BdMultiPicker bdMultiPicker, JSONObject jSONObject) {
                if (jSONObject != null) {
                    int optInt = jSONObject.optInt("column");
                    int optInt2 = jSONObject.optInt("current");
                    if (optInt != a.this.bcc.length() - 1) {
                        a.this.aI(optInt, optInt2);
                    }
                }
            }
        };
    }

    private void aFV() {
        this.bcd.put(0);
        this.bcd.put(0);
        this.bcd.put(0);
    }

    private void aFW() {
        if (this.dnw.size() > 0) {
            this.bcc.put(bd(this.dnw));
        }
        aH(0, this.bcd.optInt(0));
        aH(1, this.bcd.optInt(1));
    }

    private void aG(int i, int i2) {
        JSONArray optJSONArray;
        if (this.blp != null && (optJSONArray = this.bcc.optJSONArray(i)) != null) {
            ((e) this.blp).a(i, optJSONArray, i2);
        }
    }

    private void aH(int i, int i2) {
        JSONArray jSONArray;
        JSONArray jSONArray2 = null;
        if (i == 0) {
            this.dnV = this.dnx.get(this.dnw.get(i2));
            if (this.dnV.size() <= 0) {
                jSONArray = null;
            } else {
                jSONArray = bd(this.dnV);
            }
            jSONArray2 = jSONArray;
        } else if (i == 1) {
            this.dnW = this.dny.get(this.dnV.get(i2));
            if (this.dnW.size() > 0) {
                jSONArray2 = bd(this.dnW);
            }
        }
        if (jSONArray2 != null) {
            try {
                this.bcc.put(i + 1, jSONArray2);
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

    public void aFX() {
        if (this.blp == null) {
            this.blp = this.dnX.p(this.bcc).q(this.bcd).a(this.dnY).d("城市选择").b(R.string.aiapps_ok, new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.address.view.a.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    a.this.a(dialogInterface);
                    List<d> N = a.this.N(((e) dialogInterface).getCurrentIndex());
                    if (a.this.dnZ != null) {
                        a.this.dnZ.aZ(N);
                    }
                }
            }).c(R.string.aiapps_cancel, new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.address.view.a.2
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    a.this.a(dialogInterface);
                }
            }).Qu();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<d> N(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(this.dnw.get(jSONArray.optInt(0)));
        arrayList.add(this.dnV.get(jSONArray.optInt(1)));
        arrayList.add(this.dnW.get(jSONArray.optInt(2)));
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DialogInterface dialogInterface) {
        dialogInterface.dismiss();
        this.blp = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aI(int i, int i2) {
        int i3 = i;
        while (i3 < this.bcc.length() - 1) {
            aH(i3, i3 == i ? i2 : 0);
            aG(i3 + 1, 0);
            i3++;
        }
    }

    public void a(InterfaceC0325a interfaceC0325a) {
        this.dnZ = interfaceC0325a;
    }
}
