package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes4.dex */
public class ih5 implements fh5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public double c;
    public boolean d;

    public ih5(int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 3;
        this.b = 3;
        this.d = true;
        if (i > 0) {
            this.b = i;
        }
    }

    @Override // com.baidu.tieba.fh5
    public int a(ConstrainImageLayout constrainImageLayout, List<MediaData> list, int i, int i2) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLII = interceptable.invokeLLII(1048576, this, constrainImageLayout, list, i, i2)) == null) ? ListUtils.getCount(list) <= 0 ? i2 : e(constrainImageLayout, list, i2) : invokeLLII.intValue;
    }

    @Override // com.baidu.tieba.fh5
    public int b(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            return 1;
        }
        return invokeI.intValue;
    }

    public final double c(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            TbadkCoreApplication.getInst();
            if (i == 1) {
                return 0.5625d;
            }
            double d = this.c;
            if (d > 0.0d) {
                return d;
            }
            return 0.6666666666666666d;
        }
        return invokeI.doubleValue;
    }

    public void d(double d) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Double.valueOf(d)}) == null) {
            this.c = d;
        }
    }

    public int e(ConstrainImageLayout constrainImageLayout, List<MediaData> list, int i) {
        InterceptResult invokeLLI;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048580, this, constrainImageLayout, list, i)) == null) {
            if (constrainImageLayout == null || ListUtils.isEmpty(list)) {
                return i;
            }
            int count = ListUtils.getCount(list);
            if (count >= 2) {
                constrainImageLayout.setImageMaxChildCount(this.a);
                constrainImageLayout.setCanCenterStart(false);
            } else {
                constrainImageLayout.setImageMaxChildCount(-1);
                constrainImageLayout.setCanCenterStart(true);
            }
            int i3 = this.b;
            int i4 = count - i3;
            if (i4 > 0) {
                i2 = i3 + i;
                List<MediaData> subList = ListUtils.subList(list, i, i2);
                constrainImageLayout.setExtraCenterText(this.d ? TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f043f, new Object[]{Integer.valueOf(i4)}) : null);
                constrainImageLayout.setUrls(subList, i, true, this.d);
            } else {
                constrainImageLayout.setUrls(ListUtils.subList(list, i, count), i);
                constrainImageLayout.setExtraCenterText(null);
                i2 = count;
            }
            constrainImageLayout.setSingleImageRatio(c(count));
            return i2;
        }
        return invokeLLI.intValue;
    }
}
