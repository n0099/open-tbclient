package com.baidu.tieba.aiapps.apps.h;

import android.content.Context;
import com.baidu.swan.apps.u.b.o;
import com.baidu.swan.apps.x.a.c;
import com.baidu.swan.apps.x.a.e;
import com.baidu.swan.apps.x.a.f;
import com.baidu.swan.apps.x.a.g;
/* loaded from: classes4.dex */
public class a implements o {
    private static o cUS;

    public static void a(o oVar) {
        cUS = oVar;
    }

    @Override // com.baidu.swan.apps.u.b.o
    public boolean a(Context context, c cVar, com.baidu.swan.apps.x.b bVar, com.baidu.swan.apps.ae.b bVar2) {
        if (cUS == null) {
            return false;
        }
        return cUS.a(context, cVar, bVar, bVar2);
    }

    @Override // com.baidu.swan.apps.u.b.o
    public boolean b(Context context, c cVar, com.baidu.swan.apps.x.b bVar, com.baidu.swan.apps.ae.b bVar2) {
        if (cUS == null) {
            return false;
        }
        return cUS.b(context, cVar, bVar, bVar2);
    }

    @Override // com.baidu.swan.apps.u.b.o
    public boolean c(Context context, c cVar, com.baidu.swan.apps.x.b bVar, com.baidu.swan.apps.ae.b bVar2) {
        if (cUS == null) {
            return false;
        }
        return cUS.c(context, cVar, bVar, bVar2);
    }

    @Override // com.baidu.swan.apps.u.b.o
    public boolean a(Context context, f fVar, com.baidu.swan.apps.x.b bVar, com.baidu.swan.apps.ae.b bVar2) {
        if (cUS == null) {
            return false;
        }
        return cUS.a(context, fVar, bVar, bVar2);
    }

    @Override // com.baidu.swan.apps.u.b.o
    public boolean a(Context context, e eVar, com.baidu.swan.apps.x.b bVar, com.baidu.swan.apps.ae.b bVar2) {
        if (cUS == null) {
            return false;
        }
        return cUS.a(context, eVar, bVar, bVar2);
    }

    @Override // com.baidu.swan.apps.u.b.o
    public boolean d(Context context, c cVar, com.baidu.swan.apps.x.b bVar, com.baidu.swan.apps.ae.b bVar2) {
        if (cUS == null) {
            return false;
        }
        return cUS.d(context, cVar, bVar, bVar2);
    }

    @Override // com.baidu.swan.apps.u.b.o
    public boolean a(Context context, com.baidu.swan.apps.x.a.b bVar, com.baidu.swan.apps.x.b bVar2, com.baidu.swan.apps.ae.b bVar3) {
        if (cUS == null) {
            return false;
        }
        return cUS.a(context, bVar, bVar2, bVar3);
    }

    @Override // com.baidu.swan.apps.u.b.o
    public boolean e(Context context, c cVar, com.baidu.swan.apps.x.b bVar, com.baidu.swan.apps.ae.b bVar2) {
        if (cUS == null) {
            return false;
        }
        return cUS.e(context, cVar, bVar, bVar2);
    }

    @Override // com.baidu.swan.apps.u.b.o
    public boolean f(Context context, c cVar, com.baidu.swan.apps.x.b bVar, com.baidu.swan.apps.ae.b bVar2) {
        if (cUS == null) {
            return false;
        }
        return cUS.f(context, cVar, bVar, bVar2);
    }

    @Override // com.baidu.swan.apps.u.b.o
    public boolean g(Context context, c cVar, com.baidu.swan.apps.x.b bVar, com.baidu.swan.apps.ae.b bVar2) {
        if (cUS == null) {
            return false;
        }
        return cUS.g(context, cVar, bVar, bVar2);
    }

    @Override // com.baidu.swan.apps.u.b.o
    public boolean a(Context context, com.baidu.swan.apps.x.a.a aVar, com.baidu.swan.apps.x.b bVar, com.baidu.swan.apps.ae.b bVar2) {
        if (cUS == null) {
            return false;
        }
        return cUS.a(context, aVar, bVar, bVar2);
    }

    @Override // com.baidu.swan.apps.u.b.o
    public boolean a(Context context, g gVar, com.baidu.swan.apps.x.b bVar, com.baidu.swan.apps.ae.b bVar2) {
        if (cUS == null) {
            return false;
        }
        return cUS.a(context, gVar, bVar, bVar2);
    }

    @Override // com.baidu.swan.apps.u.b.o
    public void c(com.baidu.swan.apps.b.c.c cVar) {
        if (cUS != null) {
            cUS.c(cVar);
        }
    }

    @Override // com.baidu.swan.apps.u.b.o
    public void d(com.baidu.swan.apps.b.c.c cVar) {
        if (cUS != null) {
            cUS.d(cVar);
        }
    }

    @Override // com.baidu.swan.apps.u.b.o
    public void e(com.baidu.swan.apps.b.c.c cVar) {
        if (cUS != null) {
            cUS.e(cVar);
        }
    }
}
