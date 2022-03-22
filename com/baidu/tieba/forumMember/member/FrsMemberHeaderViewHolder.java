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
/* loaded from: classes5.dex */
public class FrsMemberHeaderViewHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f32203b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f32204c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f32205d;

    /* renamed from: e  reason: collision with root package name */
    public View f32206e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f32207f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f32208g;

    /* renamed from: h  reason: collision with root package name */
    public NoPressedLinearLayout f32209h;
    public View i;
    public TextView j;
    public ImageView k;
    public ImageView l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsMemberHeaderViewHolder(View view, View.OnClickListener onClickListener) {
        super(view);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view, onClickListener};
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
        this.a = (TextView) view.findViewById(R.id.obfuscated_res_0x7f09124d);
        this.f32203b = (TextView) view.findViewById(R.id.obfuscated_res_0x7f091241);
        this.f32204c = (ImageView) view.findViewById(R.id.obfuscated_res_0x7f090d3c);
        this.f32205d = (TextView) view.findViewById(R.id.obfuscated_res_0x7f0922b8);
        this.f32206e = view.findViewById(R.id.obfuscated_res_0x7f090d38);
        this.f32207f = (LinearLayout) view.findViewById(R.id.obfuscated_res_0x7f0923bd);
        this.f32208g = (TextView) view.findViewById(R.id.obfuscated_res_0x7f092011);
        this.f32209h = (NoPressedLinearLayout) view.findViewById(R.id.obfuscated_res_0x7f091ae3);
        this.i = view.findViewById(R.id.obfuscated_res_0x7f090d39);
        this.j = (TextView) view.findViewById(R.id.obfuscated_res_0x7f092010);
        this.k = (ImageView) view.findViewById(R.id.obfuscated_res_0x7f091353);
        this.l = (ImageView) view.findViewById(R.id.obfuscated_res_0x7f091352);
        this.a.setOnClickListener(onClickListener);
        this.f32205d.setOnClickListener(onClickListener);
    }
}
