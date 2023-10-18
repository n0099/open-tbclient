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
public class dt0 implements ms0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;

    public dt0() {
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

    @Override // com.baidu.tieba.ms0
    public void a(bv0 bv0Var) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, bv0Var) == null) && bv0Var != null && !TextUtils.isEmpty(bv0Var.g)) {
            ClogBuilder clogBuilder = new ClogBuilder();
            if (!TextUtils.isEmpty(bv0Var.f)) {
                clogBuilder.v(bv0Var.f);
            }
            clogBuilder.p(bv0Var.g);
            String c = bv0Var.a.c();
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
                                int g = bv0Var.a.g(1);
                                int g2 = bv0Var.a.g(2);
                                if (g == 0 && g2 != 0 && (i = this.b) != 0 && i >= g2 - 2) {
                                    clogBuilder.y(ClogBuilder.LogType.VIDEO_COMPLETED).l(String.valueOf(g2)).m(String.valueOf(g2)).n(bv0Var.e);
                                    jy0.e(clogBuilder);
                                    ClogBuilder p = new ClogBuilder().y(ClogBuilder.LogType.VIDEO_START).k(bv0Var.b).m(bv0Var.d).p(bv0Var.g);
                                    if (!TextUtils.isEmpty(bv0Var.f)) {
                                        p.v(bv0Var.f);
                                    }
                                    jy0.e(p);
                                }
                                this.b = g;
                                return;
                            }
                            return;
                        } else if (this.a < 1) {
                            return;
                        } else {
                            try {
                                if (this.b > Integer.parseInt(bv0Var.c)) {
                                    clogBuilder.l(bv0Var.d);
                                } else {
                                    clogBuilder.l(bv0Var.c);
                                }
                            } catch (NumberFormatException unused) {
                                clogBuilder.l(bv0Var.c);
                            }
                            clogBuilder.y(ClogBuilder.LogType.VIDEO_COMPLETED).m(bv0Var.d).n(bv0Var.e).o("0");
                            this.a--;
                            jy0.e(clogBuilder);
                            return;
                        }
                    }
                    clogBuilder.y(ClogBuilder.LogType.VIDEO_RESUME).k(bv0Var.b).m(bv0Var.d);
                    jy0.e(clogBuilder);
                    return;
                }
                boolean d = bv0Var.a.d(7);
                clogBuilder.l(bv0Var.c).m(bv0Var.d).n(bv0Var.e);
                if (d) {
                    clogBuilder.y(ClogBuilder.LogType.VIDEO_PAUSE);
                } else {
                    clogBuilder.y(ClogBuilder.LogType.VIDEO_COMPLETED).o("1");
                }
                jy0.e(clogBuilder);
                return;
            }
            clogBuilder.y(ClogBuilder.LogType.VIDEO_START).k(bv0Var.b).m(bv0Var.d);
            this.b = 0;
            this.a++;
            jy0.e(clogBuilder);
        }
    }

    @Override // com.baidu.tieba.ms0
    public void b(bv0 bv0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bv0Var) == null) && bv0Var != null && bv0Var.a != null && !TextUtils.isEmpty(bv0Var.g)) {
            String c = bv0Var.a.c();
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
                    cv0.b.b();
                    return;
                }
                return;
            }
            hv0 a = cv0.b.a();
            if (a != null) {
                a.c(bv0Var.g);
                a.e(bv0Var.b);
                a.d(bv0Var.h);
                a.b(bv0Var.d);
                cv0.b.c(a);
            }
        }
    }
}
