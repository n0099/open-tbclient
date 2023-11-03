package com.baidu.tieba.forumMember.member;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.core.view.NoPressedLinearLayout;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class FrsMemberHeaderViewHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView a;
    public TextView b;
    public ImageView c;
    public TextView d;
    public View e;
    public LinearLayout f;
    public TextView g;
    public NoPressedLinearLayout h;
    public View i;
    public TextView j;
    public ImageView k;
    public ImageView l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsMemberHeaderViewHolder(View view2, View.OnClickListener onClickListener) {
        super(view2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view2, onClickListener};
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
        this.a = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091570);
        this.b = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091562);
        this.c = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090f6e);
        this.d = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0928b2);
        this.e = view2.findViewById(R.id.obfuscated_res_0x7f090f69);
        this.f = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f0929c4);
        this.g = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0925e4);
        this.h = (NoPressedLinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f091ffe);
        this.i = view2.findViewById(R.id.obfuscated_res_0x7f090f6a);
        this.j = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0925e3);
        this.k = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0916e0);
        this.l = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0916df);
        this.a.setOnClickListener(onClickListener);
        this.d.setOnClickListener(onClickListener);
    }
}
