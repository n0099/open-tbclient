package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.PreLoadImageProvider;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class i77 extends w67 implements a87, ja7, PreLoadImageProvider {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.jb7
    @NonNull
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "common_card" : (String) invokeV.objValue;
    }

    public i77() {
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

    @Override // com.baidu.tieba.ja7
    public void d(@NonNull Object obj) {
        b77<?> b77Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) && (b77Var = this.c) != null) {
            b77Var.d(obj);
        }
    }

    @Override // com.baidu.tbadk.core.util.PreLoadImageProvider
    public ArrayList<PreLoadImageInfo> getImages() {
        InterceptResult invokeV;
        ArrayList<PreLoadImageInfo> images;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.c != null) {
                ArrayList<PreLoadImageInfo> arrayList = new ArrayList<>();
                for (jb7<? extends Object> jb7Var : this.c.b()) {
                    if ((jb7Var instanceof PreLoadImageProvider) && (images = ((PreLoadImageProvider) jb7Var).getImages()) != null && images.size() > 0) {
                        arrayList.addAll(images);
                    }
                }
                return arrayList;
            }
            return null;
        }
        return (ArrayList) invokeV.objValue;
    }

    @Override // com.baidu.tieba.a87
    public void setPosition(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            for (jb7<? extends Object> jb7Var : this.c.b()) {
                if (jb7Var.b() instanceof a87) {
                    ((a87) jb7Var.b()).setPosition(i);
                }
            }
        }
    }
}
