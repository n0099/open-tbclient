package com.baidu.tieba.aiapps.apps.i;

import android.content.Context;
import com.baidu.swan.apps.u.b.o;
import com.baidu.swan.apps.x.a.c;
import com.baidu.swan.apps.x.a.e;
import com.baidu.swan.apps.x.a.f;
import com.baidu.swan.apps.x.a.g;
/* loaded from: classes4.dex */
public class a implements o {
    private static o dpt;

    public static void a(o oVar) {
        dpt = oVar;
    }

    @Override // com.baidu.swan.apps.u.b.o
    public boolean a(Context context, c cVar, com.baidu.swan.apps.x.b bVar, com.baidu.swan.apps.ae.b bVar2) {
        if (dpt == null) {
            return false;
        }
        return dpt.a(context, cVar, bVar, bVar2);
    }

    @Override // com.baidu.swan.apps.u.b.o
    public boolean b(Context context, c cVar, com.baidu.swan.apps.x.b bVar, com.baidu.swan.apps.ae.b bVar2) {
        if (dpt == null) {
            return false;
        }
        return dpt.b(context, cVar, bVar, bVar2);
    }

    @Override // com.baidu.swan.apps.u.b.o
    public boolean c(Context context, c cVar, com.baidu.swan.apps.x.b bVar, com.baidu.swan.apps.ae.b bVar2) {
        if (dpt == null) {
            return false;
        }
        return dpt.c(context, cVar, bVar, bVar2);
    }

    @Override // com.baidu.swan.apps.u.b.o
    public boolean a(Context context, f fVar, com.baidu.swan.apps.x.b bVar, com.baidu.swan.apps.ae.b bVar2) {
        if (dpt == null) {
            return false;
        }
        return dpt.a(context, fVar, bVar, bVar2);
    }

    @Override // com.baidu.swan.apps.u.b.o
    public boolean a(Context context, e eVar, com.baidu.swan.apps.x.b bVar, com.baidu.swan.apps.ae.b bVar2) {
        if (dpt == null) {
            return false;
        }
        return dpt.a(context, eVar, bVar, bVar2);
    }

    @Override // com.baidu.swan.apps.u.b.o
    public boolean d(Context context, c cVar, com.baidu.swan.apps.x.b bVar, com.baidu.swan.apps.ae.b bVar2) {
        if (dpt == null) {
            return false;
        }
        return dpt.d(context, cVar, bVar, bVar2);
    }

    @Override // com.baidu.swan.apps.u.b.o
    public boolean a(Context context, com.baidu.swan.apps.x.a.b bVar, com.baidu.swan.apps.x.b bVar2, com.baidu.swan.apps.ae.b bVar3) {
        if (dpt == null) {
            return false;
        }
        return dpt.a(context, bVar, bVar2, bVar3);
    }

    @Override // com.baidu.swan.apps.u.b.o
    public boolean e(Context context, c cVar, com.baidu.swan.apps.x.b bVar, com.baidu.swan.apps.ae.b bVar2) {
        if (dpt == null) {
            return false;
        }
        return dpt.e(context, cVar, bVar, bVar2);
    }

    @Override // com.baidu.swan.apps.u.b.o
    public boolean f(Context context, c cVar, com.baidu.swan.apps.x.b bVar, com.baidu.swan.apps.ae.b bVar2) {
        if (dpt == null) {
            return false;
        }
        return dpt.f(context, cVar, bVar, bVar2);
    }

    @Override // com.baidu.swan.apps.u.b.o
    public boolean g(Context context, c cVar, com.baidu.swan.apps.x.b bVar, com.baidu.swan.apps.ae.b bVar2) {
        if (dpt == null) {
            return false;
        }
        return dpt.g(context, cVar, bVar, bVar2);
    }

    @Override // com.baidu.swan.apps.u.b.o
    public boolean a(Context context, com.baidu.swan.apps.x.a.a aVar, com.baidu.swan.apps.x.b bVar, com.baidu.swan.apps.ae.b bVar2) {
        if (dpt == null) {
            return false;
        }
        return dpt.a(context, aVar, bVar, bVar2);
    }

    @Override // com.baidu.swan.apps.u.b.o
    public boolean a(Context context, g gVar, com.baidu.swan.apps.x.b bVar, com.baidu.swan.apps.ae.b bVar2) {
        if (dpt == null) {
            return false;
        }
        return dpt.a(context, gVar, bVar, bVar2);
    }

    @Override // com.baidu.swan.apps.u.b.o
    public void c(com.baidu.swan.apps.b.c.c cVar) {
        if (dpt != null) {
            dpt.c(cVar);
        }
    }

    @Override // com.baidu.swan.apps.u.b.o
    public void d(com.baidu.swan.apps.b.c.c cVar) {
        if (dpt != null) {
            dpt.d(cVar);
        }
    }

    @Override // com.baidu.swan.apps.u.b.o
    public void e(com.baidu.swan.apps.b.c.c cVar) {
        if (dpt != null) {
            dpt.e(cVar);
        }
    }
}
