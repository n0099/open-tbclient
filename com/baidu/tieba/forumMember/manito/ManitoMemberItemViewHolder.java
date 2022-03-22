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

    /* renamed from: b  reason: collision with root package name */
    public TextView f32194b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f32195c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f32196d;

    /* renamed from: e  reason: collision with root package name */
    public View f32197e;

    /* renamed from: f  reason: collision with root package name */
    public int f32198f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ManitoMemberItemViewHolder(View view) {
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
        this.f32198f = 3;
        GodHeadImageView godHeadImageView = (GodHeadImageView) view.findViewById(R.id.obfuscated_res_0x7f090f75);
        this.a = godHeadImageView;
        godHeadImageView.setShapeType(0);
        this.a.setShowType(1);
        this.a.setRadius(14);
        this.f32194b = (TextView) view.findViewById(R.id.obfuscated_res_0x7f090f84);
        this.f32195c = (TextView) view.findViewById(R.id.obfuscated_res_0x7f090f83);
        this.f32196d = (TextView) view.findViewById(R.id.obfuscated_res_0x7f090f82);
        this.f32197e = view.findViewById(R.id.obfuscated_res_0x7f0907f4);
    }
}
