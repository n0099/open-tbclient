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
    private MultiPickerDialog.Builder bDh;
    private BdMultiPicker.OnMultiSelectedChangedListener bDi;
    private InterfaceC0186a bDj;
    private AiAppAlertDialog mMultiPickerDialog;
    private JSONArray mDataArray = new JSONArray();
    private JSONArray mDataIndex = new JSONArray();
    private List<d> bCG = new ArrayList();
    private List<d> bDf = new ArrayList();
    private List<d> bDg = new ArrayList();
    private Map<d, List<d>> bCH = new HashMap();
    private Map<d, List<d>> bCI = new HashMap();

    /* renamed from: com.baidu.tieba.aiapps.apps.address.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0186a {
        void al(List<d> list);
    }

    public a(Context context) {
        initData(context);
    }

    private void initData(Context context) {
        this.bCG = c.WO().WQ();
        this.bCH = c.WO().WR();
        this.bCI = c.WO().WS();
        WY();
        WZ();
        this.bDh = new MultiPickerDialog.Builder(context);
        this.bDi = new BdMultiPicker.OnMultiSelectedChangedListener() { // from class: com.baidu.tieba.aiapps.apps.address.view.a.1
            @Override // com.baidu.searchbox.ng.ai.apps.res.ui.BdMultiPicker.OnMultiSelectedChangedListener
            public void onMultiSelectedChanged(BdMultiPicker bdMultiPicker, JSONObject jSONObject) {
                if (jSONObject != null) {
                    int optInt = jSONObject.optInt("column");
                    int optInt2 = jSONObject.optInt("current");
                    if (optInt != a.this.mDataArray.length() - 1) {
                        a.this.ac(optInt, optInt2);
                    }
                }
            }
        };
    }

    private void WY() {
        this.mDataIndex.put(0);
        this.mDataIndex.put(0);
        this.mDataIndex.put(0);
    }

    private void WZ() {
        if (this.bCG.size() > 0) {
            this.mDataArray.put(ap(this.bCG));
        }
        ab(0, this.mDataIndex.optInt(0));
        ab(1, this.mDataIndex.optInt(1));
    }

    private void aa(int i, int i2) {
        JSONArray optJSONArray;
        if (this.mMultiPickerDialog != null && (optJSONArray = this.mDataArray.optJSONArray(i)) != null) {
            ((MultiPickerDialog) this.mMultiPickerDialog).updateWheel(i, optJSONArray, i2);
        }
    }

    private void ab(int i, int i2) {
        JSONArray jSONArray;
        JSONArray jSONArray2 = null;
        if (i == 0) {
            this.bDf = this.bCH.get(this.bCG.get(i2));
            if (this.bDf.size() <= 0) {
                jSONArray = null;
            } else {
                jSONArray = ap(this.bDf);
            }
            jSONArray2 = jSONArray;
        } else if (i == 1) {
            this.bDg = this.bCI.get(this.bDf.get(i2));
            if (this.bDg.size() > 0) {
                jSONArray2 = ap(this.bDg);
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

    public void Xa() {
        if (this.mMultiPickerDialog == null) {
            this.mMultiPickerDialog = this.bDh.setDataArray(this.mDataArray).setDataIndex(this.mDataIndex).setMultiSelectedListener(this.bDi).setTitle("城市选择").setPositiveButton(R.string.aiapps_ok, new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.address.view.a.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    a.this.a(dialogInterface);
                    List<d> p = a.this.p(((MultiPickerDialog) dialogInterface).getCurrentIndex());
                    if (a.this.bDj != null) {
                        a.this.bDj.al(p);
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
        arrayList.add(this.bCG.get(jSONArray.optInt(0)));
        arrayList.add(this.bDf.get(jSONArray.optInt(1)));
        arrayList.add(this.bDg.get(jSONArray.optInt(2)));
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DialogInterface dialogInterface) {
        dialogInterface.dismiss();
        this.mMultiPickerDialog = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ac(int i, int i2) {
        int i3 = i;
        while (i3 < this.mDataArray.length() - 1) {
            ab(i3, i3 == i ? i2 : 0);
            aa(i3 + 1, 0);
            i3++;
        }
    }

    public void a(InterfaceC0186a interfaceC0186a) {
        this.bDj = interfaceC0186a;
    }
}
