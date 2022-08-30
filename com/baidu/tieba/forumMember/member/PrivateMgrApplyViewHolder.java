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
/* loaded from: classes4.dex */
public class PrivateMgrApplyViewHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView a;
    public TextView b;
    public RelativeLayout c;
    public View d;
    public LinearLayout e;
    public int f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PrivateMgrApplyViewHolder(View view2) {
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
        this.f = 3;
        this.e = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f091c30);
        this.d = view2.findViewById(R.id.obfuscated_res_0x7f091a47);
        this.a = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091a48);
        this.b = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091a4b);
        this.c = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f091a46);
    }
}
