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
    private MultiPickerDialog.Builder bHq;
    private BdMultiPicker.OnMultiSelectedChangedListener bHr;
    private InterfaceC0196a bHs;
    private AiAppAlertDialog mMultiPickerDialog;
    private JSONArray mDataArray = new JSONArray();
    private JSONArray mDataIndex = new JSONArray();
    private List<d> bGP = new ArrayList();
    private List<d> bHo = new ArrayList();
    private List<d> bHp = new ArrayList();
    private Map<d, List<d>> bGQ = new HashMap();
    private Map<d, List<d>> bGR = new HashMap();

    /* renamed from: com.baidu.tieba.aiapps.apps.address.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0196a {
        void am(List<d> list);
    }

    public a(Context context) {
        initData(context);
    }

    private void initData(Context context) {
        this.bGP = c.Yq().Ys();
        this.bGQ = c.Yq().Yt();
        this.bGR = c.Yq().Yu();
        YA();
        YB();
        this.bHq = new MultiPickerDialog.Builder(context);
        this.bHr = new BdMultiPicker.OnMultiSelectedChangedListener() { // from class: com.baidu.tieba.aiapps.apps.address.view.a.1
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

    private void YA() {
        this.mDataIndex.put(0);
        this.mDataIndex.put(0);
        this.mDataIndex.put(0);
    }

    private void YB() {
        if (this.bGP.size() > 0) {
            this.mDataArray.put(aq(this.bGP));
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
            this.bHo = this.bGQ.get(this.bGP.get(i2));
            if (this.bHo.size() <= 0) {
                jSONArray = null;
            } else {
                jSONArray = aq(this.bHo);
            }
            jSONArray2 = jSONArray;
        } else if (i == 1) {
            this.bHp = this.bGR.get(this.bHo.get(i2));
            if (this.bHp.size() > 0) {
                jSONArray2 = aq(this.bHp);
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

    public void YC() {
        if (this.mMultiPickerDialog == null) {
            this.mMultiPickerDialog = this.bHq.setDataArray(this.mDataArray).setDataIndex(this.mDataIndex).setMultiSelectedListener(this.bHr).setTitle("城市选择").setPositiveButton(R.string.aiapps_ok, new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.address.view.a.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    a.this.a(dialogInterface);
                    List<d> p = a.this.p(((MultiPickerDialog) dialogInterface).getCurrentIndex());
                    if (a.this.bHs != null) {
                        a.this.bHs.am(p);
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
        arrayList.add(this.bGP.get(jSONArray.optInt(0)));
        arrayList.add(this.bHo.get(jSONArray.optInt(1)));
        arrayList.add(this.bHp.get(jSONArray.optInt(2)));
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
        this.bHs = interfaceC0196a;
    }
}
