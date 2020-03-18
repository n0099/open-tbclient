package com.baidu.tieba.aiapps.apps.g;

import android.util.SparseArray;
import com.baidu.swan.apps.as.ai;
import com.baidu.swan.menu.i;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes12.dex */
public class a implements com.baidu.swan.menu.b {
    private SparseArray<String> egk = new SparseArray<>();

    public a() {
        this.egk.put(38, "favor");
        this.egk.put(35, "launcher");
    }

    @Override // com.baidu.swan.menu.b
    public void f(int i, List<i> list) {
    }

    @Override // com.baidu.swan.menu.b
    public void g(int i, List<i> list) {
    }

    @Override // com.baidu.swan.menu.b
    public void h(int i, List<i> list) {
        i(i, list);
    }

    @Override // com.baidu.swan.menu.b
    public boolean d(i iVar) {
        return false;
    }

    private void i(int i, List<i> list) {
        if (!ai.ahl() && list != null && list.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (i iVar : list) {
                if (this.egk.get(iVar.getItemId()) != null) {
                    arrayList.add(iVar);
                }
            }
            if (arrayList.size() > 0) {
                list.removeAll(arrayList);
            }
        }
    }
}
