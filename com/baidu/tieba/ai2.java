package com.baidu.tieba;

import com.baidu.tieba.xj2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
/* loaded from: classes3.dex */
public class ai2 extends hh2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public xj2.a h;

    /* loaded from: classes3.dex */
    public class a implements xj2.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(ai2 ai2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ai2Var};
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
    public ai2(xj2 xj2Var) {
        super(xj2Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {xj2Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((jh2) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        a aVar = new a(this);
        this.h = aVar;
        xj2Var.Z(aVar);
        this.a.a(new ni2());
        this.a.a(new oi2());
        this.a.a(new pi2());
        this.a.a(new ri2());
        this.a.a(new ti2());
        this.a.a(new ui2());
        this.a.a(new vi2());
        this.a.a(new wi2());
        this.a.a(new xi2());
        this.a.a(new yi2());
        this.a.a(new qi2());
        this.a.a(new si2());
        this.a.a(new aj2());
        this.a.a(new bj2());
        this.a.a(new cj2());
        this.a.a(new ej2());
        this.a.a(new dj2());
        this.a.a(new fj2());
        this.a.a(new gj2());
        this.a.a(new hj2());
        this.a.a(new ij2());
        this.a.a(new jj2());
        this.a.a(new kj2());
        this.a.a(new lj2());
        this.a.a(new mj2());
        this.a.a(new nj2());
        this.a.a(new oj2());
        this.a.a(new pj2());
        this.a.a(new qj2());
        this.a.a(new rj2());
        this.a.a(new sj2());
        this.a.a(new uj2());
        this.a.a(new tj2());
        this.a.a(new zi2());
    }

    @Override // com.baidu.tieba.hh2, com.baidu.webkit.sdk.plugin.ZeusPlugin
    public void sendCommand(ZeusPlugin.Command command) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, command) == null) {
            if (command == null) {
                str = "";
            } else {
                str = command.what;
            }
            if (((xj2) this.c).q()) {
                m02.i("InlineRtcRoomController", "isReleased command：" + str);
                return;
            }
            m02.i("InlineRtcRoomController", "authorize type：" + ((xj2) this.c).a() + " command：" + str);
            super.sendCommand(command);
        }
    }
}
