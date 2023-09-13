package com.baidu.tieba;

import android.os.Bundle;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.util.DataExt;
import com.baidu.tieba.person.PersonMoreData;
import com.baidu.tieba.person.PersonMoreItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class ft9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public gt9 a;
    public TbPageContext b;
    public List<cn> c;
    public PersonMoreData d;

    public ft9(TbPageContext tbPageContext, Bundle bundle, mp6<gu9> mp6Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bundle, mp6Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = tbPageContext;
        gt9 gt9Var = new gt9(tbPageContext);
        this.a = gt9Var;
        gt9Var.f(mp6Var);
        a(bundle);
    }

    public final void a(Bundle bundle) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) && bundle != null && (bundle.get(PersonMoreData.URL_MAPS) instanceof ArrayList)) {
            this.d = new PersonMoreData();
            this.d.mUrlMaps.addAll(DataExt.toEntityList(bundle.getStringArrayList(PersonMoreData.URL_MAPS).toString(), PersonMoreItemData.class));
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.c = new ArrayList();
            PersonMoreData personMoreData = this.d;
            if (personMoreData != null && !ListUtils.isEmpty(personMoreData.mUrlMaps)) {
                for (PersonMoreItemData personMoreItemData : this.d.mUrlMaps) {
                    if (personMoreItemData != null && !StringUtils.isNull(personMoreItemData.mUrl)) {
                        gu9 gu9Var = new gu9();
                        gu9Var.e = personMoreItemData.mName;
                        gu9Var.a = 36;
                        gu9Var.f = personMoreItemData.mUrl;
                        gu9Var.j = personMoreItemData.mId;
                        this.c.add(gu9Var);
                    }
                }
            }
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.b.getPageActivity().setContentView(R.layout.obfuscated_res_0x7f0d07de);
            this.a.c(this.b.getPageActivity().findViewById(R.id.obfuscated_res_0x7f091c5a));
            b();
            this.a.e(this.c);
        }
    }

    public void d() {
        gt9 gt9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (gt9Var = this.a) != null) {
            gt9Var.d();
        }
    }
}
