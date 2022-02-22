package com.baidu.tieba.addresslist.model;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import c.a.d.a.f;
import c.a.u0.x.d.a;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.addresslist.QuickSearchActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes12.dex */
public class QuickSearchModel extends BdBaseModel<QuickSearchActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public a f42057e;

    /* renamed from: f  reason: collision with root package name */
    public byte[] f42058f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QuickSearchModel(QuickSearchActivity quickSearchActivity) {
        super(quickSearchActivity.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {quickSearchActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f42058f = new byte[0];
        this.f42057e = a.d();
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @SuppressLint({"DefaultLocale"})
    public List<c.a.t0.t.f.a> w(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            synchronized (this.f42058f) {
                ArrayList arrayList = new ArrayList();
                if (TextUtils.isEmpty(str)) {
                    return arrayList;
                }
                List<c.a.t0.t.f.a> c2 = this.f42057e.c();
                if (c2 == null) {
                    return arrayList;
                }
                for (c.a.t0.t.f.a aVar : c2) {
                    String f2 = aVar.f();
                    String d2 = aVar.d();
                    if (!TextUtils.isEmpty(f2) && f2.toLowerCase().startsWith(str.toLowerCase())) {
                        arrayList.add(aVar);
                    } else if (!TextUtils.isEmpty(d2) && d2.toLowerCase().startsWith(str.toLowerCase())) {
                        arrayList.add(aVar);
                    }
                }
                for (c.a.t0.t.f.a aVar2 : c2) {
                    String f3 = aVar2.f();
                    String d3 = aVar2.d();
                    if (!arrayList.contains(aVar2)) {
                        if (!TextUtils.isEmpty(f3) && f3.toLowerCase().contains(str.toLowerCase())) {
                            arrayList.add(aVar2);
                        } else if (!TextUtils.isEmpty(d3) && d3.toLowerCase().contains(str.toLowerCase())) {
                            arrayList.add(aVar2);
                        }
                    }
                }
                return arrayList;
            }
        }
        return (List) invokeL.objValue;
    }
}
