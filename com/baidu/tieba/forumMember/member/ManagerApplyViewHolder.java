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
/* loaded from: classes4.dex */
public class ManagerApplyViewHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TextView f15257a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f15258b;

    /* renamed from: c  reason: collision with root package name */
    public RelativeLayout f15259c;

    /* renamed from: d  reason: collision with root package name */
    public LinearLayout f15260d;

    /* renamed from: e  reason: collision with root package name */
    public int f15261e;

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
        this.f15261e = 3;
        this.f15260d = (LinearLayout) view.findViewById(R.id.root_member_manager_apply);
        this.f15257a = (TextView) view.findViewById(R.id.assist_apply_tip);
        this.f15258b = (TextView) view.findViewById(R.id.assist_left_tv);
        this.f15259c = (RelativeLayout) view.findViewById(R.id.assist_apply_layout);
    }
}
