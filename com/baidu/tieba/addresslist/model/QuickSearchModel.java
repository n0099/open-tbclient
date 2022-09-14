package com.baidu.tieba.addresslist.model;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.addresslist.QuickSearchActivity;
import com.baidu.tieba.i25;
import com.baidu.tieba.kp5;
import com.baidu.tieba.r9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class QuickSearchModel extends BdBaseModel<QuickSearchActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public kp5 a;
    public byte[] b;

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
                super((r9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = new byte[0];
        this.a = kp5.d();
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
    public List<i25> z(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            synchronized (this.b) {
                ArrayList arrayList = new ArrayList();
                if (TextUtils.isEmpty(str)) {
                    return arrayList;
                }
                List<i25> c = this.a.c();
                if (c == null) {
                    return arrayList;
                }
                for (i25 i25Var : c) {
                    String e = i25Var.e();
                    String c2 = i25Var.c();
                    if (!TextUtils.isEmpty(e) && e.toLowerCase().startsWith(str.toLowerCase())) {
                        arrayList.add(i25Var);
                    } else if (!TextUtils.isEmpty(c2) && c2.toLowerCase().startsWith(str.toLowerCase())) {
                        arrayList.add(i25Var);
                    }
                }
                for (i25 i25Var2 : c) {
                    String e2 = i25Var2.e();
                    String c3 = i25Var2.c();
                    if (!arrayList.contains(i25Var2)) {
                        if (!TextUtils.isEmpty(e2) && e2.toLowerCase().contains(str.toLowerCase())) {
                            arrayList.add(i25Var2);
                        } else if (!TextUtils.isEmpty(c3) && c3.toLowerCase().contains(str.toLowerCase())) {
                            arrayList.add(i25Var2);
                        }
                    }
                }
                return arrayList;
            }
        }
        return (List) invokeL.objValue;
    }
}
