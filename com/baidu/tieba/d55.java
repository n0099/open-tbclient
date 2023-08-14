package com.baidu.tieba;

import android.app.Activity;
import androidx.annotation.NonNull;
import com.baidu.adp.log.DefaultLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.dialog.yun.YunDialogManager;
import com.baidu.tbadk.data.HotEventData;
import com.baidu.tieba.b55;
import com.baidu.tieba.log.TbLog;
import com.baidu.tieba.lr6;
import com.baidu.tieba.statemachine.animationtip.SpriteAnimationTipManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class d55 extends b55 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final HotEventData c;
    public vd5 d;
    public SpriteAnimationTipManager e;

    /* loaded from: classes5.dex */
    public class a implements lr6.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d55 a;

        public a(d55 d55Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d55Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = d55Var;
        }

        @Override // com.baidu.tieba.lr6.e
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.c();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements lr6.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d55 a;

        public b(d55 d55Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d55Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = d55Var;
        }

        @Override // com.baidu.tieba.lr6.e
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.c();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d55(Activity activity, HotEventData hotEventData) {
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

    @Override // com.baidu.tieba.b55
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            vd5 vd5Var = this.d;
            if (vd5Var != null) {
                vd5Var.m();
            }
            SpriteAnimationTipManager spriteAnimationTipManager = this.e;
            if (spriteAnimationTipManager != null) {
                spriteAnimationTipManager.p();
            }
            hf5.s(false);
            sr6.b().b(new h9a(null, 1));
        }
    }

    @Override // com.baidu.tieba.b55
    public void d(@NonNull b55.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            if (YunDialogManager.isShowingDialog()) {
                aVar.callback(false);
                TbLog defaultLog = DefaultLog.getInstance();
                defaultLog.e("HotEventTip", "S级事件弹窗无法展示，云弹窗正在展示：" + YunDialogManager.getShowingDialog());
            } else if (2 == dha.a().b().a().c && 1 == dha.a().b().b().c && 6 == dha.a().b().c().c) {
                DefaultLog.getInstance().e("HotEventTip", "直播tab不展示S级事件");
                aVar.callback(false);
            } else {
                aVar.callback(true);
            }
        }
    }

    @Override // com.baidu.tieba.b55
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (wn5.a().a()) {
                DefaultLog.getInstance().e("HotEventTip", "展示精灵动画提示控件形式的S级事件弹窗");
                this.e = hf5.t(this.c, new a(this));
                return;
            }
            DefaultLog.getInstance().e("HotEventTip", "展示页面顶部提示控件形式的S级事件弹窗");
            this.d = hf5.p(this.c, new b(this));
        }
    }
}
