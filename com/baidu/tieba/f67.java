package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.PreLoadImageProvider;
import com.baidu.tieba.feed.log.FeedStat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class f67 extends n57 implements g77, oa7, PreLoadImageProvider, wb7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.rb7
    @NonNull
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "common_card" : (String) invokeV.objValue;
    }

    public f67() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.tieba.oa7
    public void d(@NonNull Object obj) {
        w57<?> w57Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) && (w57Var = this.c) != null) {
            w57Var.d(obj);
        }
    }

    @Override // com.baidu.tieba.wb7
    public void e(@NonNull FeedStat.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
            for (rb7<? extends Object> rb7Var : this.c.c()) {
                if (rb7Var.b() instanceof wb7) {
                    ((wb7) rb7Var.b()).e(aVar);
                }
            }
        }
    }

    @Override // com.baidu.tieba.g77
    public void setPosition(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            this.c.t(i);
            for (rb7<? extends Object> rb7Var : this.c.c()) {
                if (rb7Var.b() instanceof g77) {
                    ((g77) rb7Var.b()).setPosition(i);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.util.PreLoadImageProvider
    public ArrayList<PreLoadImageInfo> getImages() {
        InterceptResult invokeV;
        ArrayList<PreLoadImageInfo> images;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.c != null) {
                ArrayList<PreLoadImageInfo> arrayList = new ArrayList<>();
                for (rb7<? extends Object> rb7Var : this.c.c()) {
                    if ((rb7Var instanceof PreLoadImageProvider) && (images = ((PreLoadImageProvider) rb7Var).getImages()) != null && images.size() > 0) {
                        arrayList.addAll(images);
                    }
                }
                return arrayList;
            }
            return null;
        }
        return (ArrayList) invokeV.objValue;
    }
}
