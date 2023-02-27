package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.tieba.xp2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
/* loaded from: classes3.dex */
public class ao2 extends hn2<xp2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public xp2.a h;

    /* loaded from: classes3.dex */
    public class a implements xp2.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(ao2 ao2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ao2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ao2(@NonNull xp2 xp2Var) {
        super(xp2Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {xp2Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((jn2) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        a aVar = new a(this);
        this.h = aVar;
        xp2Var.Y(aVar);
        this.a.a(new no2());
        this.a.a(new oo2());
        this.a.a(new po2());
        this.a.a(new ro2());
        this.a.a(new to2());
        this.a.a(new uo2());
        this.a.a(new vo2());
        this.a.a(new wo2());
        this.a.a(new xo2());
        this.a.a(new yo2());
        this.a.a(new qo2());
        this.a.a(new so2());
        this.a.a(new ap2());
        this.a.a(new bp2());
        this.a.a(new cp2());
        this.a.a(new ep2());
        this.a.a(new dp2());
        this.a.a(new fp2());
        this.a.a(new gp2());
        this.a.a(new hp2());
        this.a.a(new ip2());
        this.a.a(new jp2());
        this.a.a(new kp2());
        this.a.a(new lp2());
        this.a.a(new mp2());
        this.a.a(new np2());
        this.a.a(new op2());
        this.a.a(new pp2());
        this.a.a(new qp2());
        this.a.a(new rp2());
        this.a.a(new sp2());
        this.a.a(new up2());
        this.a.a(new tp2());
        this.a.a(new zo2());
    }

    @Override // com.baidu.tieba.hn2, com.baidu.webkit.sdk.plugin.ZeusPlugin
    public void sendCommand(ZeusPlugin.Command command) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, command) == null) {
            if (command == null) {
                str = "";
            } else {
                str = command.what;
            }
            if (((xp2) this.c).q()) {
                m62.i("InlineRtcRoomController", "isReleased command：" + str);
                return;
            }
            m62.i("InlineRtcRoomController", "authorize type：" + ((xp2) this.c).a() + " command：" + str);
            super.sendCommand(command);
        }
    }
}
