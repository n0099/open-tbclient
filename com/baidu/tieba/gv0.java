package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.searchbox.player.event.ControlEvent;
import com.baidu.searchbox.player.event.PlayerEvent;
import com.baidu.searchbox.player.event.StatisticsEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@Singleton
@Service
/* loaded from: classes4.dex */
public class gv0 implements pu0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;

    public gv0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 0;
        this.b = 0;
    }

    @Override // com.baidu.tieba.pu0
    public void a(ix0 ix0Var) {
        int i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, ix0Var) == null) || ix0Var == null || TextUtils.isEmpty(ix0Var.g)) {
            return;
        }
        ClogBuilder clogBuilder = new ClogBuilder();
        if (!TextUtils.isEmpty(ix0Var.f)) {
            clogBuilder.v(ix0Var.f);
        }
        clogBuilder.p(ix0Var.g);
        String c = ix0Var.a.c();
        char c2 = 65535;
        switch (c.hashCode()) {
            case -1530009462:
                if (c.equals(ControlEvent.ACTION_SYNC_PROGRESS)) {
                    c2 = 5;
                    break;
                }
                break;
            case 154871702:
                if (c.equals(PlayerEvent.ACTION_ON_COMPLETE)) {
                    c2 = 4;
                    break;
                }
                break;
            case 720027695:
                if (c.equals(ControlEvent.ACTION_PAUSE)) {
                    c2 = 1;
                    break;
                }
                break;
            case 723345051:
                if (c.equals(ControlEvent.ACTION_START)) {
                    c2 = 0;
                    break;
                }
                break;
            case 906917140:
                if (c.equals(ControlEvent.ACTION_RESUME)) {
                    c2 = 2;
                    break;
                }
                break;
            case 2145795460:
                if (c.equals(StatisticsEvent.ACTION_PLAYER_STOP)) {
                    c2 = 3;
                    break;
                }
                break;
        }
        if (c2 == 0) {
            clogBuilder.y(ClogBuilder.LogType.VIDEO_START).k(ix0Var.b).m(ix0Var.d);
            this.b = 0;
            this.a++;
            h01.b(clogBuilder);
        } else if (c2 == 1) {
            boolean d = ix0Var.a.d(7);
            clogBuilder.l(ix0Var.c).m(ix0Var.d).n(ix0Var.e);
            if (d) {
                clogBuilder.y(ClogBuilder.LogType.VIDEO_PAUSE);
            } else {
                clogBuilder.y(ClogBuilder.LogType.VIDEO_COMPLETED).o("1");
            }
            h01.b(clogBuilder);
        } else if (c2 == 2) {
            clogBuilder.y(ClogBuilder.LogType.VIDEO_RESUME).k(ix0Var.b).m(ix0Var.d);
            h01.b(clogBuilder);
        } else if (c2 == 3 || c2 == 4) {
            if (this.a < 1) {
                return;
            }
            try {
                if (this.b > Integer.parseInt(ix0Var.c)) {
                    clogBuilder.l(ix0Var.d);
                } else {
                    clogBuilder.l(ix0Var.c);
                }
            } catch (NumberFormatException unused) {
                clogBuilder.l(ix0Var.c);
            }
            clogBuilder.y(ClogBuilder.LogType.VIDEO_COMPLETED).m(ix0Var.d).n(ix0Var.e).o("0");
            this.a--;
            h01.b(clogBuilder);
        } else if (c2 != 5) {
        } else {
            int g = ix0Var.a.g(1);
            int g2 = ix0Var.a.g(2);
            if (g == 0 && g2 != 0 && (i = this.b) != 0 && i >= g2 - 2) {
                clogBuilder.y(ClogBuilder.LogType.VIDEO_COMPLETED).l(String.valueOf(g2)).m(String.valueOf(g2)).n(ix0Var.e);
                h01.b(clogBuilder);
                ClogBuilder p = new ClogBuilder().y(ClogBuilder.LogType.VIDEO_START).k(ix0Var.b).m(ix0Var.d).p(ix0Var.g);
                if (!TextUtils.isEmpty(ix0Var.f)) {
                    p.v(ix0Var.f);
                }
                h01.b(p);
            }
            this.b = g;
        }
    }

    @Override // com.baidu.tieba.pu0
    public void b(ix0 ix0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ix0Var) == null) || ix0Var == null || ix0Var.a == null || TextUtils.isEmpty(ix0Var.g)) {
            return;
        }
        String c = ix0Var.a.c();
        char c2 = 65535;
        int hashCode = c.hashCode();
        if (hashCode != 154871702) {
            if (hashCode != 1370689931) {
                if (hashCode == 2145795460 && c.equals(StatisticsEvent.ACTION_PLAYER_STOP)) {
                    c2 = 1;
                }
            } else if (c.equals(PlayerEvent.ACTION_ON_INFO)) {
                c2 = 0;
            }
        } else if (c.equals(PlayerEvent.ACTION_ON_COMPLETE)) {
            c2 = 2;
        }
        if (c2 != 0) {
            if (c2 == 1 || c2 == 2) {
                jx0.b.b();
                return;
            }
            return;
        }
        ox0 a = jx0.b.a();
        if (a != null) {
            a.c(ix0Var.g);
            a.e(ix0Var.b);
            a.d(ix0Var.h);
            a.b(ix0Var.d);
            jx0.b.c(a);
        }
    }
}
