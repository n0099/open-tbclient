package com.baidu.tieba;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.base.BdActivityStack;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.DownloadManagerActivityConfig;
import com.baidu.tieba.view.ScreenTopToast;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class df7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<String> a;
    public String b;
    public String c;
    public View.OnClickListener d;

    public df7() {
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
        this.a = CollectionsKt__CollectionsKt.mutableListOf("DownloadManagerActivity");
        String string = TbadkCoreApplication.getInst().getString(R.string.item_first_use_download_manager_toast);
        Intrinsics.checkNotNullExpressionValue(string, "getInst().getString(R.st…e_download_manager_toast)");
        this.b = string;
        String string2 = TbadkCoreApplication.getInst().getString(R.string.dialog_confirm_see);
        Intrinsics.checkNotNullExpressionValue(string2, "getInst().getString(R.string.dialog_confirm_see)");
        this.c = string2;
        this.d = new View.OnClickListener() { // from class: com.baidu.tieba.cf7
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                    df7.b(view2);
                }
            }
        };
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            Activity curGlobalActivity = TbadkCoreApplication.getInst().getCurGlobalActivity();
            if (curGlobalActivity == null) {
                curGlobalActivity = BdActivityStack.getInst().currentActivity();
            }
            if (curGlobalActivity == null || this.a.contains(curGlobalActivity.getClass().getSimpleName())) {
                return;
            }
            ScreenTopToast screenTopToast = new ScreenTopToast(curGlobalActivity);
            screenTopToast.m(this.b);
            screenTopToast.k(this.c);
            screenTopToast.j(this.d);
            screenTopToast.n(this.d);
            screenTopToast.o((ViewGroup) curGlobalActivity.findViewById(16908290));
        }
    }

    public static final void b(View view2) {
        Activity curGlobalActivity;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65537, null, view2) != null) || (curGlobalActivity = TbadkCoreApplication.getInst().getCurGlobalActivity()) == null) {
            return;
        }
        DownloadManagerActivityConfig downloadManagerActivityConfig = new DownloadManagerActivityConfig(curGlobalActivity, 3);
        downloadManagerActivityConfig.setCurrentTab(3);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, downloadManagerActivityConfig));
    }

    public final df7 c(String text) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, text)) == null) {
            Intrinsics.checkNotNullParameter(text, "text");
            if (text.length() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                this.b = text;
            }
            return this;
        }
        return (df7) invokeL.objValue;
    }
}
