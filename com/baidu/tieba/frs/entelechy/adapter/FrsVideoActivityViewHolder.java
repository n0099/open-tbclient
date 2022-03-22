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

    /* renamed from: b  reason: collision with root package name */
    public ImageView f32452b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f32453c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f32454d;

    /* renamed from: e  reason: collision with root package name */
    public View f32455e;

    /* renamed from: f  reason: collision with root package name */
    public View f32456f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsVideoActivityViewHolder(View view) {
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
        if (view != null) {
            this.a = (TextView) view.findViewById(R.id.obfuscated_res_0x7f092305);
            this.f32452b = (ImageView) view.findViewById(R.id.obfuscated_res_0x7f092304);
            this.f32453c = (TextView) view.findViewById(R.id.obfuscated_res_0x7f092306);
            this.f32454d = (ImageView) view.findViewById(R.id.obfuscated_res_0x7f092303);
            this.f32455e = view.findViewById(R.id.obfuscated_res_0x7f0920b2);
            this.f32456f = view.findViewById(R.id.obfuscated_res_0x7f0903c2);
        }
    }
}
