package com.baidu.tbadk.editortools.editorinfotool;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import c.a.d.f.p.n;
import c.a.t0.s.l0.n.b;
import c.a.u0.a4.d;
import c.a.u0.a4.e;
import c.a.u0.a4.f;
import c.a.u0.a4.j;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes11.dex */
public class LocationInfoView extends LinearLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int STATE_INIT = 0;
    public static final int STATE_LOADING = 1;
    public static final int STATE_RESULT = 2;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TBSpecificationBtn f41184e;

    /* renamed from: f  reason: collision with root package name */
    public a f41185f;

    /* renamed from: g  reason: collision with root package name */
    public int f41186g;

    /* loaded from: classes11.dex */
    public interface a {
        void a();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LocationInfoView(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            setOrientation(0);
            setGravity(16);
            b bVar = new b();
            bVar.p(d.CAM_X0209, d.CAM_X0105);
            bVar.i(f.ic_icon_pure_post_location12, 0, TBSpecificationButtonConfig.IconType.WEBP);
            bVar.h(d.CAM_X0110);
            bVar.f(UtilHelper.getDimenPixelSize(e.M_W_X002));
            bVar.m(n.f(getContext(), e.M_W_X004), n.f(getContext(), e.M_W_X004));
            bVar.n(n.f(getContext(), e.M_H_X002));
            bVar.g(UtilHelper.getDimenPixelSize(e.tbds31));
            TBSpecificationBtn tBSpecificationBtn = new TBSpecificationBtn(getContext());
            this.f41184e = tBSpecificationBtn;
            tBSpecificationBtn.setConfig(bVar);
            this.f41184e.setTextSize(e.T_X09);
            this.f41184e.setOnClickListener(this);
            this.f41184e.setText(getContext().getString(j.location_where_are_you));
            addView(this.f41184e, new LinearLayout.LayoutParams(-2, n.f(getContext(), e.tbds62)));
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public TBSpecificationBtn getLocationBtn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f41184e : (TBSpecificationBtn) invokeV.objValue;
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) || this.f41186g == i2) {
            return;
        }
        this.f41184e.changeSkinType();
        this.f41186g = i2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, view) == null) || (aVar = this.f41185f) == null) {
            return;
        }
        aVar.a();
    }

    public void setLocationClickListener(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
            this.f41185f = aVar;
        }
    }

    public void setState(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048581, this, i2, str) == null) {
            if (!StringUtils.isNull(str)) {
                if (str.contains("·")) {
                    int indexOf = str.indexOf("·");
                    str = str.substring(0, indexOf) + str.substring(indexOf + 1, str.length());
                }
                this.f41184e.setText(StringHelper.cutChineseAndEnglishWithSuffix(str, 8, "..."));
            } else if (i2 == 1) {
                this.f41184e.setText(getContext().getString(j.location_loading));
            } else {
                this.f41184e.setText(getContext().getString(j.location_where_are_you));
            }
            this.f41184e.btnState = Integer.valueOf(i2);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LocationInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f41186g = 3;
        a();
    }
}
