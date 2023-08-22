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
/* loaded from: classes5.dex */
public class ey0 implements nx0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;

    public ey0() {
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

    @Override // com.baidu.tieba.nx0
    public void a(g01 g01Var) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, g01Var) == null) && g01Var != null && !TextUtils.isEmpty(g01Var.g)) {
            ClogBuilder clogBuilder = new ClogBuilder();
            if (!TextUtils.isEmpty(g01Var.f)) {
                clogBuilder.v(g01Var.f);
            }
            clogBuilder.p(g01Var.g);
            String c = g01Var.a.c();
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
            if (c2 != 0) {
                if (c2 != 1) {
                    if (c2 != 2) {
                        if (c2 != 3 && c2 != 4) {
                            if (c2 == 5) {
                                int g = g01Var.a.g(1);
                                int g2 = g01Var.a.g(2);
                                if (g == 0 && g2 != 0 && (i = this.b) != 0 && i >= g2 - 2) {
                                    clogBuilder.y(ClogBuilder.LogType.VIDEO_COMPLETED).l(String.valueOf(g2)).m(String.valueOf(g2)).n(g01Var.e);
                                    t31.e(clogBuilder);
                                    ClogBuilder p = new ClogBuilder().y(ClogBuilder.LogType.VIDEO_START).k(g01Var.b).m(g01Var.d).p(g01Var.g);
                                    if (!TextUtils.isEmpty(g01Var.f)) {
                                        p.v(g01Var.f);
                                    }
                                    t31.e(p);
                                }
                                this.b = g;
                                return;
                            }
                            return;
                        } else if (this.a < 1) {
                            return;
                        } else {
                            try {
                                if (this.b > Integer.parseInt(g01Var.c)) {
                                    clogBuilder.l(g01Var.d);
                                } else {
                                    clogBuilder.l(g01Var.c);
                                }
                            } catch (NumberFormatException unused) {
                                clogBuilder.l(g01Var.c);
                            }
                            clogBuilder.y(ClogBuilder.LogType.VIDEO_COMPLETED).m(g01Var.d).n(g01Var.e).o("0");
                            this.a--;
                            t31.e(clogBuilder);
                            return;
                        }
                    }
                    clogBuilder.y(ClogBuilder.LogType.VIDEO_RESUME).k(g01Var.b).m(g01Var.d);
                    t31.e(clogBuilder);
                    return;
                }
                boolean d = g01Var.a.d(7);
                clogBuilder.l(g01Var.c).m(g01Var.d).n(g01Var.e);
                if (d) {
                    clogBuilder.y(ClogBuilder.LogType.VIDEO_PAUSE);
                } else {
                    clogBuilder.y(ClogBuilder.LogType.VIDEO_COMPLETED).o("1");
                }
                t31.e(clogBuilder);
                return;
            }
            clogBuilder.y(ClogBuilder.LogType.VIDEO_START).k(g01Var.b).m(g01Var.d);
            this.b = 0;
            this.a++;
            t31.e(clogBuilder);
        }
    }

    @Override // com.baidu.tieba.nx0
    public void b(g01 g01Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, g01Var) == null) && g01Var != null && g01Var.a != null && !TextUtils.isEmpty(g01Var.g)) {
            String c = g01Var.a.c();
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
                    h01.b.b();
                    return;
                }
                return;
            }
            m01 a = h01.b.a();
            if (a != null) {
                a.c(g01Var.g);
                a.e(g01Var.b);
                a.d(g01Var.h);
                a.b(g01Var.d);
                h01.b.c(a);
            }
        }
    }
}
