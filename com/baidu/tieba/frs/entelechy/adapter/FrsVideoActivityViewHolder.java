package com.baidu.tieba.frs.entelechy.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class FrsVideoActivityViewHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView a;
    public ImageView b;
    public TextView c;
    public ImageView d;
    public View e;
    public View f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsVideoActivityViewHolder(View view2) {
        super(view2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((View) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (view2 != null) {
            this.a = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0928f2);
            this.b = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0928f1);
            this.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0928f3);
            this.d = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0928f0);
            this.e = view2.findViewById(R.id.obfuscated_res_0x7f092664);
            this.f = view2.findViewById(R.id.bottom_divider_line);
        }
    }
}
