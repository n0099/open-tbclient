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
    private MultiPickerDialog.Builder bCv;
    private BdMultiPicker.OnMultiSelectedChangedListener bCw;
    private InterfaceC0161a bCx;
    private AiAppAlertDialog mMultiPickerDialog;
    private JSONArray mDataArray = new JSONArray();
    private JSONArray mDataIndex = new JSONArray();
    private List<d> bBU = new ArrayList();
    private List<d> bCt = new ArrayList();
    private List<d> bCu = new ArrayList();
    private Map<d, List<d>> bBV = new HashMap();
    private Map<d, List<d>> bBW = new HashMap();

    /* renamed from: com.baidu.tieba.aiapps.apps.address.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0161a {
        void am(List<d> list);
    }

    public a(Context context) {
        initData(context);
    }

    private void initData(Context context) {
        this.bBU = c.WD().WF();
        this.bBV = c.WD().WG();
        this.bBW = c.WD().WH();
        WN();
        WO();
        this.bCv = new MultiPickerDialog.Builder(context);
        this.bCw = new BdMultiPicker.OnMultiSelectedChangedListener() { // from class: com.baidu.tieba.aiapps.apps.address.view.a.1
            @Override // com.baidu.searchbox.ng.ai.apps.res.ui.BdMultiPicker.OnMultiSelectedChangedListener
            public void onMultiSelectedChanged(BdMultiPicker bdMultiPicker, JSONObject jSONObject) {
                if (jSONObject != null) {
                    int optInt = jSONObject.optInt("column");
                    int optInt2 = jSONObject.optInt("current");
                    if (optInt != a.this.mDataArray.length() - 1) {
                        a.this.ab(optInt, optInt2);
                    }
                }
            }
        };
    }

    private void WN() {
        this.mDataIndex.put(0);
        this.mDataIndex.put(0);
        this.mDataIndex.put(0);
    }

    private void WO() {
        if (this.bBU.size() > 0) {
            this.mDataArray.put(aq(this.bBU));
        }
        aa(0, this.mDataIndex.optInt(0));
        aa(1, this.mDataIndex.optInt(1));
    }

    private void Z(int i, int i2) {
        JSONArray optJSONArray;
        if (this.mMultiPickerDialog != null && (optJSONArray = this.mDataArray.optJSONArray(i)) != null) {
            ((MultiPickerDialog) this.mMultiPickerDialog).updateWheel(i, optJSONArray, i2);
        }
    }

    private void aa(int i, int i2) {
        JSONArray jSONArray;
        JSONArray jSONArray2 = null;
        if (i == 0) {
            this.bCt = this.bBV.get(this.bBU.get(i2));
            if (this.bCt.size() <= 0) {
                jSONArray = null;
            } else {
                jSONArray = aq(this.bCt);
            }
            jSONArray2 = jSONArray;
        } else if (i == 1) {
            this.bCu = this.bBW.get(this.bCt.get(i2));
            if (this.bCu.size() > 0) {
                jSONArray2 = aq(this.bCu);
            }
        }
        if (jSONArray2 != null) {
            try {
                this.mDataArray.put(i + 1, jSONArray2);
            } catch (JSONException e) {
            }
        }
    }

    private JSONArray aq(List<d> list) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (d dVar : list) {
            jSONArray.put(dVar.name);
        }
        return jSONArray;
    }

    public void WP() {
        if (this.mMultiPickerDialog == null) {
            this.mMultiPickerDialog = this.bCv.setDataArray(this.mDataArray).setDataIndex(this.mDataIndex).setMultiSelectedListener(this.bCw).setTitle("城市选择").setPositiveButton(R.string.aiapps_ok, new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.address.view.a.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    a.this.a(dialogInterface);
                    List<d> n = a.this.n(((MultiPickerDialog) dialogInterface).getCurrentIndex());
                    if (a.this.bCx != null) {
                        a.this.bCx.am(n);
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
    public List<d> n(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(this.bBU.get(jSONArray.optInt(0)));
        arrayList.add(this.bCt.get(jSONArray.optInt(1)));
        arrayList.add(this.bCu.get(jSONArray.optInt(2)));
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DialogInterface dialogInterface) {
        dialogInterface.dismiss();
        this.mMultiPickerDialog = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ab(int i, int i2) {
        int i3 = i;
        while (i3 < this.mDataArray.length() - 1) {
            aa(i3, i3 == i ? i2 : 0);
            Z(i3 + 1, 0);
            i3++;
        }
    }

    public void a(InterfaceC0161a interfaceC0161a) {
        this.bCx = interfaceC0161a;
    }
}
