package com.baidu.tieba.forumMember.manito;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tieba.R;
import com.baidu.tieba.forumMember.view.GodHeadImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class ManitoMemberItemViewHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public GodHeadImageView a;
    public TextView b;
    public TextView c;
    public TextView d;
    public View e;
    public int f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ManitoMemberItemViewHolder(View view2) {
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
        GodHeadImageView godHeadImageView = (GodHeadImageView) view2.findViewById(R.id.obfuscated_res_0x7f0911bc);
        this.a = godHeadImageView;
        godHeadImageView.setShapeType(0);
        this.a.setShowType(1);
        this.a.setRadius(14);
        this.b = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0911cb);
        this.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0911ca);
        this.d = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0911c9);
        this.e = view2.findViewById(R.id.obfuscated_res_0x7f090905);
    }
}
