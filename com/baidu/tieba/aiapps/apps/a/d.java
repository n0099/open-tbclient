package com.baidu.tieba.aiapps.apps.a;

import android.os.Bundle;
import android.support.annotation.NonNull;
import com.baidu.searchbox.common.runtime.AppRuntime;
/* loaded from: classes4.dex */
public class d extends com.baidu.swan.apps.process.b.a.a {
    @Override // com.baidu.swan.apps.process.b.a.a
    public void t(@NonNull Bundle bundle) {
        String[] stringArray = bundle.getStringArray("key_param_tpl_list");
        if (stringArray == null || stringArray.length < 1) {
            finish();
        } else {
            a.a(AppRuntime.getAppContext(), new com.baidu.swan.apps.an.c.a<Bundle>() { // from class: com.baidu.tieba.aiapps.apps.a.d.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.an.c.a
                /* renamed from: o */
                public void D(Bundle bundle2) {
                    d.this.aED.putBundle("key_result_stokent", bundle2);
                    d.this.finish();
                }
            }, stringArray);
        }
    }
}
