package com.baidu.tieba.aiapps.apps.h;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.baidu.swan.apps.api.SwanApi$$ModulesProvider;
import com.baidu.swan.apps.scheme.j;
import com.baidu.swan.bdprivate.extensions.a.g;
import com.baidu.swan.bdprivate.extensions.a.i;
import java.util.Map;
/* loaded from: classes25.dex */
public class c implements com.baidu.swan.facade.a.b {
    @Override // com.baidu.swan.facade.a.d
    public void a(j jVar) {
        if (jVar != null) {
            jVar.a(new e(jVar));
            jVar.a(new com.baidu.tieba.aiapps.apps.g.a(jVar));
            jVar.a(new com.baidu.swan.bdprivate.extensions.a.c(jVar));
            jVar.a(new com.baidu.swan.bdprivate.extensions.a.e(jVar));
            jVar.a(new g(jVar));
            jVar.a(new com.baidu.swan.apps.scheme.actions.c.a(jVar));
            jVar.a(new com.baidu.swan.apps.scheme.actions.c.b(jVar));
            jVar.a(new com.baidu.swan.bdprivate.extensions.c.b(jVar));
            jVar.a(new i(jVar));
            jVar.a(new com.baidu.swan.apps.adlanding.a(jVar));
            jVar.a(new b(jVar));
        }
    }

    @Override // com.baidu.swan.facade.a.d
    @Nullable
    public Map<String, Object> getWebviewApiModules(@NonNull com.baidu.swan.apps.api.a.b bVar) {
        return SwanApi$$ModulesProvider.getWebviewApiModules(bVar);
    }

    @Override // com.baidu.swan.facade.a.d
    @Nullable
    public Map<String, Object> getV8ApiModules(@NonNull com.baidu.swan.apps.api.a.b bVar) {
        return SwanApi$$ModulesProvider.getV8ApiModules(bVar);
    }
}
