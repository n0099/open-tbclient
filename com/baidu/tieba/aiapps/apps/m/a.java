package com.baidu.tieba.aiapps.apps.m;

import android.os.Parcelable;
import android.util.Log;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation;
import com.baidu.swan.apps.ao.p;
import com.baidu.swan.apps.media.chooser.model.MediaModel;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes8.dex */
public class a extends ActivityDelegation {
    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation
    protected boolean onExec() {
        p.a(new b(getAgent(), this.mParams, new com.baidu.swan.apps.media.chooser.listener.d() { // from class: com.baidu.tieba.aiapps.apps.m.a.1
            @Override // com.baidu.swan.apps.media.chooser.listener.d
            public void a(boolean z, String str, Object obj) {
                if (z && (obj instanceof ArrayList)) {
                    ArrayList<? extends Parcelable> arrayList = (ArrayList) obj;
                    if (com.baidu.swan.apps.media.chooser.b.c.DEBUG) {
                        Iterator<? extends Parcelable> it = arrayList.iterator();
                        while (it.hasNext()) {
                            Log.d(getClass().getSimpleName(), "tempPath = " + ((MediaModel) it.next()).aBB());
                        }
                    }
                    a.this.mResult.putParcelableArrayList("mediaModels", arrayList);
                }
                a.this.finish();
            }
        }), "delegation compress files");
        return false;
    }
}
