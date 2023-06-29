package com.baidu.tieba;

import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.graphic.apng.APNGDrawable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class cl5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(@NonNull ImageView imageView, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, imageView, str) == null) {
            imageView.setImageDrawable(APNGDrawable.i(TbadkApplication.getInst().getContext(), str));
        }
    }
}
