package com.baidu.tieba.addresslist.model;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.addresslist.QuickSearchActivity;
import com.baidu.tieba.b05;
import com.baidu.tieba.bn5;
import com.baidu.tieba.d9;
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
    public bn5 a;
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
                super((d9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = new byte[0];
        this.a = bn5.d();
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
    public List<b05> z(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            synchronized (this.b) {
                ArrayList arrayList = new ArrayList();
                if (TextUtils.isEmpty(str)) {
                    return arrayList;
                }
                List<b05> c = this.a.c();
                if (c == null) {
                    return arrayList;
                }
                for (b05 b05Var : c) {
                    String e = b05Var.e();
                    String c2 = b05Var.c();
                    if (!TextUtils.isEmpty(e) && e.toLowerCase().startsWith(str.toLowerCase())) {
                        arrayList.add(b05Var);
                    } else if (!TextUtils.isEmpty(c2) && c2.toLowerCase().startsWith(str.toLowerCase())) {
                        arrayList.add(b05Var);
                    }
                }
                for (b05 b05Var2 : c) {
                    String e2 = b05Var2.e();
                    String c3 = b05Var2.c();
                    if (!arrayList.contains(b05Var2)) {
                        if (!TextUtils.isEmpty(e2) && e2.toLowerCase().contains(str.toLowerCase())) {
                            arrayList.add(b05Var2);
                        } else if (!TextUtils.isEmpty(c3) && c3.toLowerCase().contains(str.toLowerCase())) {
                            arrayList.add(b05Var2);
                        }
                    }
                }
                return arrayList;
            }
        }
        return (List) invokeL.objValue;
    }
}
