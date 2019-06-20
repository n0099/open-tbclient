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
    private g aRd;
    private e.a dbk;
    private BdMultiPicker.b dbl;
    private InterfaceC0281a dbm;
    private JSONArray aHI = new JSONArray();
    private JSONArray aHJ = new JSONArray();
    private List<d> daJ = new ArrayList();
    private List<d> dbi = new ArrayList();
    private List<d> dbj = new ArrayList();
    private Map<d, List<d>> daK = new HashMap();
    private Map<d, List<d>> daL = new HashMap();

    /* renamed from: com.baidu.tieba.aiapps.apps.address.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0281a {
        void aG(List<d> list);
    }

    public a(Context context) {
        initData(context);
    }

    private void initData(Context context) {
        this.daJ = c.aDC().aDE();
        this.daK = c.aDC().aDF();
        this.daL = c.aDC().aDG();
        aDM();
        aDN();
        this.dbk = new e.a(context);
        this.dbl = new BdMultiPicker.b() { // from class: com.baidu.tieba.aiapps.apps.address.view.a.1
            @Override // com.baidu.swan.apps.res.ui.BdMultiPicker.b
            public void a(BdMultiPicker bdMultiPicker, JSONObject jSONObject) {
                if (jSONObject != null) {
                    int optInt = jSONObject.optInt("column");
                    int optInt2 = jSONObject.optInt("current");
                    if (optInt != a.this.aHI.length() - 1) {
                        a.this.aC(optInt, optInt2);
                    }
                }
            }
        };
    }

    private void aDM() {
        this.aHJ.put(0);
        this.aHJ.put(0);
        this.aHJ.put(0);
    }

    private void aDN() {
        if (this.daJ.size() > 0) {
            this.aHI.put(aK(this.daJ));
        }
        aB(0, this.aHJ.optInt(0));
        aB(1, this.aHJ.optInt(1));
    }

    private void aA(int i, int i2) {
        JSONArray optJSONArray;
        if (this.aRd != null && (optJSONArray = this.aHI.optJSONArray(i)) != null) {
            ((e) this.aRd).a(i, optJSONArray, i2);
        }
    }

    private void aB(int i, int i2) {
        JSONArray jSONArray;
        JSONArray jSONArray2 = null;
        if (i == 0) {
            this.dbi = this.daK.get(this.daJ.get(i2));
            if (this.dbi.size() <= 0) {
                jSONArray = null;
            } else {
                jSONArray = aK(this.dbi);
            }
            jSONArray2 = jSONArray;
        } else if (i == 1) {
            this.dbj = this.daL.get(this.dbi.get(i2));
            if (this.dbj.size() > 0) {
                jSONArray2 = aK(this.dbj);
            }
        }
        if (jSONArray2 != null) {
            try {
                this.aHI.put(i + 1, jSONArray2);
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

    public void aDO() {
        if (this.aRd == null) {
            this.aRd = this.dbk.h(this.aHI).i(this.aHJ).a(this.dbl).d("城市选择").b(R.string.aiapps_ok, new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.address.view.a.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    a.this.a(dialogInterface);
                    List<d> F = a.this.F(((e) dialogInterface).getCurrentIndex());
                    if (a.this.dbm != null) {
                        a.this.dbm.aG(F);
                    }
                }
            }).c(R.string.aiapps_cancel, new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.address.view.a.2
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    a.this.a(dialogInterface);
                }
            }).KK();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<d> F(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(this.daJ.get(jSONArray.optInt(0)));
        arrayList.add(this.dbi.get(jSONArray.optInt(1)));
        arrayList.add(this.dbj.get(jSONArray.optInt(2)));
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DialogInterface dialogInterface) {
        dialogInterface.dismiss();
        this.aRd = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aC(int i, int i2) {
        int i3 = i;
        while (i3 < this.aHI.length() - 1) {
            aB(i3, i3 == i ? i2 : 0);
            aA(i3 + 1, 0);
            i3++;
        }
    }

    public void a(InterfaceC0281a interfaceC0281a) {
        this.dbm = interfaceC0281a;
    }
}
