package com.baidu.tieba;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.memberCenter.tail.tool.TailToolController;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class e69 extends xh5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e69(Context context, int i) {
        super(context, TbadkCoreApplication.getInst().getString(R.string.tail_web_view_title), 16, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (String) objArr2[1], ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = R.drawable.icon_mask_post_keyboard24_selection;
        this.e = R.drawable.icon_mask_post_keyboard24_selection;
        this.h = R.drawable.icon_pure_post_more_tail64;
        this.r = R.drawable.icon_pure_pic_vip64;
        this.i = false;
        this.j = true;
        this.m = new TailToolController(context);
        this.o = true;
        this.n = 6;
        this.p = new int[]{1};
    }

    @Override // com.baidu.tieba.xh5
    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            TiebaStatic.log(new StatisticItem("c15166").param("uid", TbadkCoreApplication.getCurrentAccount()));
            return super.a();
        }
        return invokeV.booleanValue;
    }
}
