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

    /* renamed from: a  reason: collision with root package name */
    public TextView f15218a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f15219b;

    /* renamed from: c  reason: collision with root package name */
    public RelativeLayout f15220c;

    /* renamed from: d  reason: collision with root package name */
    public LinearLayout f15221d;

    /* renamed from: e  reason: collision with root package name */
    public int f15222e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ManagerApplyViewHolder(View view) {
        super(view);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((View) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f15222e = 3;
        this.f15221d = (LinearLayout) view.findViewById(R.id.root_member_manager_apply);
        this.f15218a = (TextView) view.findViewById(R.id.assist_apply_tip);
        this.f15219b = (TextView) view.findViewById(R.id.assist_left_tv);
        this.f15220c = (RelativeLayout) view.findViewById(R.id.assist_apply_layout);
    }
}
