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
/* loaded from: classes5.dex */
public class ManagerApplyViewHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f32217b;

    /* renamed from: c  reason: collision with root package name */
    public RelativeLayout f32218c;

    /* renamed from: d  reason: collision with root package name */
    public LinearLayout f32219d;

    /* renamed from: e  reason: collision with root package name */
    public int f32220e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ManagerApplyViewHolder(View view) {
        super(view);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view};
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
        this.f32220e = 3;
        this.f32219d = (LinearLayout) view.findViewById(R.id.obfuscated_res_0x7f091ae9);
        this.a = (TextView) view.findViewById(R.id.obfuscated_res_0x7f0902ad);
        this.f32217b = (TextView) view.findViewById(R.id.obfuscated_res_0x7f0902ae);
        this.f32218c = (RelativeLayout) view.findViewById(R.id.obfuscated_res_0x7f0902ac);
    }
}
