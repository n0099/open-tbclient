package com.baidu.tieba.forumMember.member;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class ManagerApplyViewHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView a;
    public TextView b;
    public RelativeLayout c;
    public LinearLayout d;
    public int e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ManagerApplyViewHolder(View view2) {
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
        this.e = 3;
        this.d = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f091ad6);
        this.a = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0902aa);
        this.b = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0902ab);
        this.c = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f0902a9);
    }
}
