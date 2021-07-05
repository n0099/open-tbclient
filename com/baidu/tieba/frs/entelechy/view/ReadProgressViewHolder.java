package com.baidu.tieba.frs.entelechy.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.s0.u0.u;
/* loaded from: classes5.dex */
public class ReadProgressViewHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static final int f15565d;

    /* renamed from: e  reason: collision with root package name */
    public static final int f15566e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public View f15567a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f15568b;

    /* renamed from: c  reason: collision with root package name */
    public Context f15569c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1076632639, "Lcom/baidu/tieba/frs/entelechy/view/ReadProgressViewHolder;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1076632639, "Lcom/baidu/tieba/frs/entelechy/view/ReadProgressViewHolder;");
                return;
            }
        }
        UtilHelper.getDimenPixelSize(R.dimen.M_H_X002);
        f15565d = UtilHelper.getDimenPixelSize(R.dimen.M_H_X003);
        f15566e = UtilHelper.getDimenPixelSize(R.dimen.M_H_X005);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReadProgressViewHolder(View view, Context context) {
        super(view);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view, context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((View) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f15567a = view;
        TextView textView = (TextView) view.findViewById(R.id.view_frs_read_progress);
        this.f15568b = textView;
        int i4 = f15566e;
        textView.setPadding(0, i4, 0, i4 - f15565d);
        this.f15569c = context;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            SkinManager.setViewTextColor(this.f15568b, R.color.CAM_X0304);
            Drawable pureDrawable = WebPManager.getPureDrawable(R.drawable.icon_pure_card_refresh16, SkinManager.getColor(R.color.CAM_X0304), WebPManager.ResourceStateType.NORMAL);
            pureDrawable.setBounds(0, 0, UtilHelper.getDimenPixelSize(R.dimen.tbds42), UtilHelper.getDimenPixelSize(R.dimen.tbds42));
            this.f15568b.setCompoundDrawables(pureDrawable, null, null, null);
        }
    }

    public void c(u uVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, uVar) == null) || uVar == null) {
            return;
        }
        this.f15568b.setText(R.string.read_here);
        b();
    }
}
