package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.tieba.am2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
/* loaded from: classes5.dex */
public class dk2 extends kj2<am2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public am2.a h;

    /* loaded from: classes5.dex */
    public class a implements am2.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(dk2 dk2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dk2Var};
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
    public dk2(@NonNull am2 am2Var) {
        super(am2Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {am2Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((mj2) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        a aVar = new a(this);
        this.h = aVar;
        am2Var.Y(aVar);
        this.a.a(new qk2());
        this.a.a(new rk2());
        this.a.a(new sk2());
        this.a.a(new uk2());
        this.a.a(new wk2());
        this.a.a(new xk2());
        this.a.a(new yk2());
        this.a.a(new zk2());
        this.a.a(new al2());
        this.a.a(new bl2());
        this.a.a(new tk2());
        this.a.a(new vk2());
        this.a.a(new dl2());
        this.a.a(new el2());
        this.a.a(new fl2());
        this.a.a(new hl2());
        this.a.a(new gl2());
        this.a.a(new il2());
        this.a.a(new jl2());
        this.a.a(new kl2());
        this.a.a(new ll2());
        this.a.a(new ml2());
        this.a.a(new nl2());
        this.a.a(new ol2());
        this.a.a(new pl2());
        this.a.a(new ql2());
        this.a.a(new rl2());
        this.a.a(new sl2());
        this.a.a(new tl2());
        this.a.a(new ul2());
        this.a.a(new vl2());
        this.a.a(new xl2());
        this.a.a(new wl2());
        this.a.a(new cl2());
    }

    @Override // com.baidu.tieba.kj2, com.baidu.webkit.sdk.plugin.ZeusPlugin
    public void sendCommand(ZeusPlugin.Command command) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, command) == null) {
            if (command == null) {
                str = "";
            } else {
                str = command.what;
            }
            if (((am2) this.c).q()) {
                p22.i("InlineRtcRoomController", "isReleased command：" + str);
                return;
            }
            p22.i("InlineRtcRoomController", "authorize type：" + ((am2) this.c).a() + " command：" + str);
            super.sendCommand(command);
        }
    }
}
