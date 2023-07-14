package com.baidu.tieba;

import android.app.Activity;
import androidx.annotation.NonNull;
import com.baidu.adp.log.DefaultLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.data.HotEventData;
import com.baidu.tieba.du6;
import com.baidu.tieba.f65;
import com.baidu.tieba.statemachine.animationtip.SpriteAnimationTipManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class h65 extends f65 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final HotEventData c;
    public hf5 d;
    public SpriteAnimationTipManager e;

    /* loaded from: classes6.dex */
    public class a implements du6.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h65 a;

        public a(h65 h65Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h65Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = h65Var;
        }

        @Override // com.baidu.tieba.du6.e
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.c();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements du6.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h65 a;

        public b(h65 h65Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h65Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = h65Var;
        }

        @Override // com.baidu.tieba.du6.e
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.c();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h65(Activity activity, HotEventData hotEventData) {
        super(activity);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, hotEventData};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Activity) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = hotEventData;
    }

    @Override // com.baidu.tieba.f65
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            hf5 hf5Var = this.d;
            if (hf5Var != null) {
                hf5Var.m();
            }
            SpriteAnimationTipManager spriteAnimationTipManager = this.e;
            if (spriteAnimationTipManager != null) {
                spriteAnimationTipManager.p();
            }
            wg5.s(false);
            lu6.b().b(new naa(null, 1));
        }
    }

    @Override // com.baidu.tieba.f65
    public void d(@NonNull f65.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            if (m65.k()) {
                aVar.callback(false);
                h29 defaultLog = DefaultLog.getInstance();
                defaultLog.b("HotEventTip", "S级事件弹窗无法展示，云弹窗正在展示：" + m65.i());
            } else if (2 == kia.a().b().a().c && 1 == kia.a().b().b().c && 6 == kia.a().b().c().c) {
                DefaultLog.getInstance().b("HotEventTip", "直播tab不展示S级事件");
                aVar.callback(false);
            } else {
                aVar.callback(true);
            }
        }
    }

    @Override // com.baidu.tieba.f65
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (rp5.a().a()) {
                DefaultLog.getInstance().b("HotEventTip", "展示精灵动画提示控件形式的S级事件弹窗");
                this.e = wg5.t(this.c, new a(this));
                return;
            }
            DefaultLog.getInstance().b("HotEventTip", "展示页面顶部提示控件形式的S级事件弹窗");
            this.d = wg5.p(this.c, new b(this));
        }
    }
}
