package com.baidu.tieba.forumMember.member;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class ComplaintBarlordViewHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public RelativeLayout b;
    public View c;
    public TextView d;
    public ImageView e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ComplaintBarlordViewHolder(View view2) {
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
        this.a = 3;
        this.b = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f09034b);
        this.c = view2.findViewById(R.id.obfuscated_res_0x7f0910d9);
        this.d = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09034c);
        this.e = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f09034a);
    }
}
