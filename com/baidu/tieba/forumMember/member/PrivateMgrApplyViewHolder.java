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

    /* renamed from: a  reason: collision with root package name */
    public TextView f15223a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f15224b;

    /* renamed from: c  reason: collision with root package name */
    public RelativeLayout f15225c;

    /* renamed from: d  reason: collision with root package name */
    public View f15226d;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f15227e;

    /* renamed from: f  reason: collision with root package name */
    public int f15228f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PrivateMgrApplyViewHolder(View view) {
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
        this.f15228f = 3;
        this.f15227e = (LinearLayout) view.findViewById(R.id.root_private_member_apply);
        this.f15226d = view.findViewById(R.id.private_apply_line);
        this.f15223a = (TextView) view.findViewById(R.id.private_apply_tip);
        this.f15224b = (TextView) view.findViewById(R.id.private_left_tv);
        this.f15225c = (RelativeLayout) view.findViewById(R.id.private_apply_layout);
    }
}
