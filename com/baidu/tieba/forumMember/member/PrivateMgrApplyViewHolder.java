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
public class PrivateMgrApplyViewHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f32221b;

    /* renamed from: c  reason: collision with root package name */
    public RelativeLayout f32222c;

    /* renamed from: d  reason: collision with root package name */
    public View f32223d;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f32224e;

    /* renamed from: f  reason: collision with root package name */
    public int f32225f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PrivateMgrApplyViewHolder(View view) {
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
        this.f32225f = 3;
        this.f32224e = (LinearLayout) view.findViewById(R.id.obfuscated_res_0x7f091aeb);
        this.f32223d = view.findViewById(R.id.obfuscated_res_0x7f0918fa);
        this.a = (TextView) view.findViewById(R.id.obfuscated_res_0x7f0918fb);
        this.f32221b = (TextView) view.findViewById(R.id.obfuscated_res_0x7f0918fe);
        this.f32222c = (RelativeLayout) view.findViewById(R.id.obfuscated_res_0x7f0918f9);
    }
}
