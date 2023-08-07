package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.RawLayout;
import com.baidu.tbadk.editortools.emotiontool.EmotionNoLaunchView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class ci5 extends xh5 {
    public static /* synthetic */ Interceptable $ic;
    public static final int t;
    public static final int u;
    public static final int v;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947675738, "Lcom/baidu/tieba/ci5;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947675738, "Lcom/baidu/tieba/ci5;");
                return;
            }
        }
        t = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X007);
        u = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds46);
        v = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds68);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ci5(Context context) {
        super(context, (String) null, 37);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (String) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.o = true;
        this.n = 8;
        this.m = new EmotionNoLaunchView(context);
        int i3 = v;
        RawLayout.LayoutParams layoutParams = new RawLayout.LayoutParams(t + i3, i3 + (u * 2));
        ((LinearLayout.LayoutParams) layoutParams).gravity = 80;
        ((View) this.m).setLayoutParams(layoutParams);
        int i4 = t;
        int i5 = u;
        ((View) this.m).setPadding(i4, i5, 0, i5);
        this.p = new int[]{1, 5};
    }
}
