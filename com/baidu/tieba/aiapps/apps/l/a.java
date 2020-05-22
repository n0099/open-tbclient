package com.baidu.tieba.aiapps.apps.l;

import android.os.Parcelable;
import android.util.Log;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation;
import com.baidu.swan.apps.aq.n;
import com.baidu.swan.apps.media.chooser.model.MediaModel;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes12.dex */
public class a extends ActivityDelegation {
    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation
    protected boolean onExec() {
        n.postOnIO(new b(getAgent(), this.mParams, new com.baidu.swan.apps.media.chooser.c.d() { // from class: com.baidu.tieba.aiapps.apps.l.a.1
            @Override // com.baidu.swan.apps.media.chooser.c.d
            public void a(boolean z, String str, Object obj) {
                if (z && (obj instanceof ArrayList)) {
                    ArrayList<? extends Parcelable> arrayList = (ArrayList) obj;
                    if (com.baidu.swan.apps.media.chooser.b.c.DEBUG) {
                        Iterator<? extends Parcelable> it = arrayList.iterator();
                        while (it.hasNext()) {
                            Log.d(getClass().getSimpleName(), "tempPath = " + ((MediaModel) it.next()).ajc());
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
