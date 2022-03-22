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

    /* renamed from: b  reason: collision with root package name */
    public RelativeLayout f32199b;

    /* renamed from: c  reason: collision with root package name */
    public View f32200c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f32201d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f32202e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ComplaintBarlordViewHolder(View view) {
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
        this.a = 3;
        this.f32199b = (RelativeLayout) view.findViewById(R.id.obfuscated_res_0x7f090311);
        this.f32200c = view.findViewById(R.id.obfuscated_res_0x7f090ef6);
        this.f32201d = (TextView) view.findViewById(R.id.obfuscated_res_0x7f090312);
        this.f32202e = (ImageView) view.findViewById(R.id.obfuscated_res_0x7f090310);
    }
}
