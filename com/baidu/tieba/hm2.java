package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.tieba.eo2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
/* loaded from: classes4.dex */
public class hm2 extends ol2<eo2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public eo2.a h;

    /* loaded from: classes4.dex */
    public class a implements eo2.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(hm2 hm2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hm2Var};
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
    public hm2(@NonNull eo2 eo2Var) {
        super(eo2Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eo2Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((ql2) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        a aVar = new a(this);
        this.h = aVar;
        eo2Var.Y(aVar);
        this.a.a(new um2());
        this.a.a(new vm2());
        this.a.a(new wm2());
        this.a.a(new ym2());
        this.a.a(new an2());
        this.a.a(new bn2());
        this.a.a(new cn2());
        this.a.a(new dn2());
        this.a.a(new en2());
        this.a.a(new fn2());
        this.a.a(new xm2());
        this.a.a(new zm2());
        this.a.a(new hn2());
        this.a.a(new in2());
        this.a.a(new jn2());
        this.a.a(new ln2());
        this.a.a(new kn2());
        this.a.a(new mn2());
        this.a.a(new nn2());
        this.a.a(new on2());
        this.a.a(new pn2());
        this.a.a(new qn2());
        this.a.a(new rn2());
        this.a.a(new sn2());
        this.a.a(new tn2());
        this.a.a(new un2());
        this.a.a(new vn2());
        this.a.a(new wn2());
        this.a.a(new xn2());
        this.a.a(new yn2());
        this.a.a(new zn2());
        this.a.a(new bo2());
        this.a.a(new ao2());
        this.a.a(new gn2());
    }

    @Override // com.baidu.tieba.ol2, com.baidu.webkit.sdk.plugin.ZeusPlugin
    public void sendCommand(ZeusPlugin.Command command) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, command) == null) {
            if (command == null) {
                str = "";
            } else {
                str = command.what;
            }
            if (((eo2) this.c).q()) {
                t42.i("InlineRtcRoomController", "isReleased command：" + str);
                return;
            }
            t42.i("InlineRtcRoomController", "authorize type：" + ((eo2) this.c).a() + " command：" + str);
            super.sendCommand(command);
        }
    }
}
