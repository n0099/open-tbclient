package com.baidu.tieba;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class bj7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;
    public BarImageView b;
    public TextView c;
    public TextView d;
    public TextView e;
    public EntelechyUserLikeButton f;
    public View g;

    public bj7(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = view2;
        this.b = (BarImageView) view2.findViewById(R.id.obfuscated_res_0x7f090c9d);
        this.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090ca0);
        this.d = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090c9e);
        this.e = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090c9f);
        this.f = (EntelechyUserLikeButton) view2.findViewById(R.id.obfuscated_res_0x7f090c9b);
        this.g = view2.findViewById(R.id.obfuscated_res_0x7f090c9c);
    }
}
