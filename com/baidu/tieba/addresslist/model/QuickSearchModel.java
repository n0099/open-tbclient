package com.baidu.tieba.addresslist.model;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.base.BdPageContext;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.addresslist.QuickSearchActivity;
import com.baidu.tieba.k36;
import com.baidu.tieba.sa5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class QuickSearchModel extends BdBaseModel<QuickSearchActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public k36 a;
    public byte[] b;

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QuickSearchModel(QuickSearchActivity quickSearchActivity) {
        super(quickSearchActivity.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {quickSearchActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((BdPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = new byte[0];
        this.a = k36.d();
    }

    @SuppressLint({"DefaultLocale"})
    public List<sa5> O(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            synchronized (this.b) {
                ArrayList arrayList = new ArrayList();
                if (TextUtils.isEmpty(str)) {
                    return arrayList;
                }
                List<sa5> c = this.a.c();
                if (c == null) {
                    return arrayList;
                }
                for (sa5 sa5Var : c) {
                    String e = sa5Var.e();
                    String c2 = sa5Var.c();
                    if (!TextUtils.isEmpty(e) && e.toLowerCase().startsWith(str.toLowerCase())) {
                        arrayList.add(sa5Var);
                    } else if (!TextUtils.isEmpty(c2) && c2.toLowerCase().startsWith(str.toLowerCase())) {
                        arrayList.add(sa5Var);
                    }
                }
                for (sa5 sa5Var2 : c) {
                    String e2 = sa5Var2.e();
                    String c3 = sa5Var2.c();
                    if (!arrayList.contains(sa5Var2)) {
                        if (!TextUtils.isEmpty(e2) && e2.toLowerCase().contains(str.toLowerCase())) {
                            arrayList.add(sa5Var2);
                        } else if (!TextUtils.isEmpty(c3) && c3.toLowerCase().contains(str.toLowerCase())) {
                            arrayList.add(sa5Var2);
                        }
                    }
                }
                return arrayList;
            }
        }
        return (List) invokeL.objValue;
    }
}
