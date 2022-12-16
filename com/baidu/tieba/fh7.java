package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.imMessageCenter.chatgroup.chatbox.adapter.ChatRoomRecycleAdapter;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes4.dex */
public class fh7 extends wg7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final boolean a;
    public final String b;
    public String c;
    public List<wg7> d;
    public RecyclerView.Adapter e;
    public boolean f;

    @Override // com.baidu.tieba.wg7
    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public fh7(List<gh7> list, String str, String str2, boolean z, boolean z2, @NonNull TbPageContext tbPageContext, ch7 ch7Var) {
        this(list, str, str2, z, false, z2, tbPageContext, ch7Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list, str, str2, Boolean.valueOf(z), Boolean.valueOf(z2), tbPageContext, ch7Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((List) objArr2[0], (String) objArr2[1], (String) objArr2[2], ((Boolean) objArr2[3]).booleanValue(), ((Boolean) objArr2[4]).booleanValue(), ((Boolean) objArr2[5]).booleanValue(), (TbPageContext) objArr2[6], (ch7) objArr2[7]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public fh7(List<gh7> list, String str, String str2, boolean z, boolean z2, boolean z3, @NonNull TbPageContext tbPageContext, ch7 ch7Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list, str, str2, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), tbPageContext, ch7Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = z2;
        this.b = str;
        this.c = str2;
        this.f = z;
        tg7 tg7Var = new tg7(tbPageContext, -1L, !z2, z3);
        this.d = new ArrayList();
        if (!ListUtils.isEmpty(list)) {
            this.d.addAll(list);
        }
        this.e = new ChatRoomRecycleAdapter(new ug7(ch7Var), tg7Var, tbPageContext);
        tg7Var.h(e());
    }

    public RecyclerView.Adapter b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.e;
        }
        return (RecyclerView.Adapter) invokeV.objValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.c;
        }
        return (String) invokeV.objValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.b;
        }
        return (String) invokeV.objValue;
    }

    public List<wg7> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return Collections.unmodifiableList(this.d);
        }
        return (List) invokeV.objValue;
    }

    public final int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            List<wg7> list = this.d;
            if (list != null) {
                return list.size();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.f;
        }
        return invokeV.booleanValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.a;
        }
        return invokeV.booleanValue;
    }

    public void i() {
        RecyclerView.Adapter adapter;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && (adapter = this.e) != null) {
            adapter.notifyItemRangeChanged(0, f());
        }
    }

    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.f = z;
        }
    }
}
