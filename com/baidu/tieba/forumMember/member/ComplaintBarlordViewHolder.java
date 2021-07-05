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

    /* renamed from: a  reason: collision with root package name */
    public int f15192a;

    /* renamed from: b  reason: collision with root package name */
    public RelativeLayout f15193b;

    /* renamed from: c  reason: collision with root package name */
    public View f15194c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f15195d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f15196e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ComplaintBarlordViewHolder(View view) {
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
        this.f15192a = 3;
        this.f15193b = (RelativeLayout) view.findViewById(R.id.bar_info_complaint_lay);
        this.f15194c = view.findViewById(R.id.info_complaint_diver_top);
        this.f15195d = (TextView) view.findViewById(R.id.bar_info_complaint_tv);
        this.f15196e = (ImageView) view.findViewById(R.id.bar_info_complaint_img);
    }
}
