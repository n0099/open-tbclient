package com.baidu.tieba;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.editortools.view.CommonTabHost;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class ik8 extends ad5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ik8(Context context) {
        super(context, context.getString(R.string.editor_privilege), 12);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (String) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = R.drawable.icon_pure_post_bubble24;
        this.h = R.drawable.icon_pure_post_more_bubble64;
        this.e = R.drawable.icon_mask_post_keyboard24_selection;
        this.r = R.drawable.icon_pure_pic_vip64;
        this.i = false;
        this.j = true;
        this.o = true;
        CommonTabHost commonTabHost = new CommonTabHost(context);
        this.m = commonTabHost;
        commonTabHost.h(new hk8());
        this.n = 6;
        this.p = new int[]{1};
    }

    @Override // com.baidu.tieba.ad5
    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            TiebaStatic.log(new StatisticItem("c15104").param("uid", TbadkCoreApplication.getCurrentAccount()));
            return super.a();
        }
        return invokeV.booleanValue;
    }
}
