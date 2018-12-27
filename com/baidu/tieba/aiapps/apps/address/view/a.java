package com.baidu.tieba.aiapps.apps.address.view;

import android.content.Context;
import android.content.DialogInterface;
import com.baidu.searchbox.ng.ai.apps.R;
import com.baidu.searchbox.ng.ai.apps.res.ui.BdMultiPicker;
import com.baidu.searchbox.ng.ai.apps.res.widget.dialog.AiAppAlertDialog;
import com.baidu.searchbox.ng.ai.apps.res.widget.dialog.MultiPickerDialog;
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
    private MultiPickerDialog.Builder bGD;
    private BdMultiPicker.OnMultiSelectedChangedListener bGE;
    private InterfaceC0196a bGF;
    private AiAppAlertDialog mMultiPickerDialog;
    private JSONArray mDataArray = new JSONArray();
    private JSONArray mDataIndex = new JSONArray();
    private List<d> bGc = new ArrayList();
    private List<d> bGB = new ArrayList();
    private List<d> bGC = new ArrayList();
    private Map<d, List<d>> bGd = new HashMap();
    private Map<d, List<d>> bGe = new HashMap();

    /* renamed from: com.baidu.tieba.aiapps.apps.address.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0196a {
        void al(List<d> list);
    }

    public a(Context context) {
        initData(context);
    }

    private void initData(Context context) {
        this.bGc = c.XT().XV();
        this.bGd = c.XT().XW();
        this.bGe = c.XT().XX();
        Yd();
        Ye();
        this.bGD = new MultiPickerDialog.Builder(context);
        this.bGE = new BdMultiPicker.OnMultiSelectedChangedListener() { // from class: com.baidu.tieba.aiapps.apps.address.view.a.1
            @Override // com.baidu.searchbox.ng.ai.apps.res.ui.BdMultiPicker.OnMultiSelectedChangedListener
            public void onMultiSelectedChanged(BdMultiPicker bdMultiPicker, JSONObject jSONObject) {
                if (jSONObject != null) {
                    int optInt = jSONObject.optInt("column");
                    int optInt2 = jSONObject.optInt("current");
                    if (optInt != a.this.mDataArray.length() - 1) {
                        a.this.ad(optInt, optInt2);
                    }
                }
            }
        };
    }

    private void Yd() {
        this.mDataIndex.put(0);
        this.mDataIndex.put(0);
        this.mDataIndex.put(0);
    }

    private void Ye() {
        if (this.bGc.size() > 0) {
            this.mDataArray.put(ap(this.bGc));
        }
        ac(0, this.mDataIndex.optInt(0));
        ac(1, this.mDataIndex.optInt(1));
    }

    private void ab(int i, int i2) {
        JSONArray optJSONArray;
        if (this.mMultiPickerDialog != null && (optJSONArray = this.mDataArray.optJSONArray(i)) != null) {
            ((MultiPickerDialog) this.mMultiPickerDialog).updateWheel(i, optJSONArray, i2);
        }
    }

    private void ac(int i, int i2) {
        JSONArray jSONArray;
        JSONArray jSONArray2 = null;
        if (i == 0) {
            this.bGB = this.bGd.get(this.bGc.get(i2));
            if (this.bGB.size() <= 0) {
                jSONArray = null;
            } else {
                jSONArray = ap(this.bGB);
            }
            jSONArray2 = jSONArray;
        } else if (i == 1) {
            this.bGC = this.bGe.get(this.bGB.get(i2));
            if (this.bGC.size() > 0) {
                jSONArray2 = ap(this.bGC);
            }
        }
        if (jSONArray2 != null) {
            try {
                this.mDataArray.put(i + 1, jSONArray2);
            } catch (JSONException e) {
            }
        }
    }

    private JSONArray ap(List<d> list) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (d dVar : list) {
            jSONArray.put(dVar.name);
        }
        return jSONArray;
    }

    public void Yf() {
        if (this.mMultiPickerDialog == null) {
            this.mMultiPickerDialog = this.bGD.setDataArray(this.mDataArray).setDataIndex(this.mDataIndex).setMultiSelectedListener(this.bGE).setTitle("城市选择").setPositiveButton(R.string.aiapps_ok, new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.address.view.a.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    a.this.a(dialogInterface);
                    List<d> p = a.this.p(((MultiPickerDialog) dialogInterface).getCurrentIndex());
                    if (a.this.bGF != null) {
                        a.this.bGF.al(p);
                    }
                }
            }).setNegativeButton(R.string.aiapps_cancel, new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.address.view.a.2
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    a.this.a(dialogInterface);
                }
            }).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<d> p(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(this.bGc.get(jSONArray.optInt(0)));
        arrayList.add(this.bGB.get(jSONArray.optInt(1)));
        arrayList.add(this.bGC.get(jSONArray.optInt(2)));
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DialogInterface dialogInterface) {
        dialogInterface.dismiss();
        this.mMultiPickerDialog = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ad(int i, int i2) {
        int i3 = i;
        while (i3 < this.mDataArray.length() - 1) {
            ac(i3, i3 == i ? i2 : 0);
            ab(i3 + 1, 0);
            i3++;
        }
    }

    public void a(InterfaceC0196a interfaceC0196a) {
        this.bGF = interfaceC0196a;
    }
}
