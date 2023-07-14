package com.baidu.tieba;

import android.app.Activity;
import androidx.annotation.NonNull;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tieba.f65;
import com.baidu.tieba.tblauncher.MainTabActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class eia extends f65 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final MainTabActivity c;
    public final pfa d;

    @Override // com.baidu.tieba.f65
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public eia(@NonNull MainTabActivity mainTabActivity, @NonNull pfa pfaVar) {
        super(mainTabActivity);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mainTabActivity, pfaVar};
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
        this.d = pfaVar;
        this.c = mainTabActivity;
    }

    @Override // com.baidu.tieba.f65
    public void d(@NonNull f65.a aVar) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            boolean z2 = false;
            if (this.d.y() != null && this.d.y().getCurrentTabType() != 2) {
                aVar.callback(false);
                return;
            }
            boolean l = da5.p().l(da5.t("key_new_god_pop_is_show"), false);
            if (TbSingleton.getInstance().getNewGodData() != null) {
                z = true;
            } else {
                z = false;
            }
            if (l && z) {
                z2 = true;
            }
            aVar.callback(z2);
        }
    }

    @Override // com.baidu.tieba.f65
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            TbWebViewActivityConfig h = nx4.h(this.c, "", "https://tieba.baidu.com/mo/q/hybrid/popups?page=god-invite", false, true, true);
            h.setPageTranslucent(TbWebViewActivityConfig.PAGE_TYPE_BLACK_TRANSLUCENT);
            h.setWebDialogName("newGod");
            this.c.sendMessage(new CustomMessage(2002001, h));
            da5.p().A(da5.t("key_new_god_pop_is_show"), false);
            m65.n("newGod");
        }
    }
}
