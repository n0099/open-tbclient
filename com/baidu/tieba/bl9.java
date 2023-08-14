package com.baidu.tieba;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.pb.pb.sub.NewSubPbActivity;
import com.baidu.tieba.pb.pb.sub.adapter.SubPbReplyAdapter;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class bl9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public fl9 a;
    public SubPbReplyAdapter b;
    public NewSubPbActivity c;
    public BdTypeListView d;
    public List<lm> e;
    public View.OnClickListener f;
    public boolean g;
    public boolean h;

    public bl9(NewSubPbActivity newSubPbActivity, BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {newSubPbActivity, bdTypeListView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = new ArrayList();
        this.f = null;
        this.g = false;
        this.h = true;
        this.c = newSubPbActivity;
        this.d = bdTypeListView;
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.g;
        }
        return invokeV.booleanValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.d.getAdapter2() != null) {
            this.d.getAdapter2().notifyDataSetChanged();
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            fl9 fl9Var = new fl9(this.c, rba.W0);
            this.a = fl9Var;
            fl9Var.e(this.f);
            this.a.setFromCDN(this.h);
            this.e.add(this.a);
            SubPbReplyAdapter subPbReplyAdapter = new SubPbReplyAdapter(this.c, il9.b);
            this.b = subPbReplyAdapter;
            this.e.add(subPbReplyAdapter);
            this.e.add(new gl9(this.c, hl9.a));
            this.d.addAdapters(this.e);
        }
    }

    public void d(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, onClickListener) == null) {
            this.f = onClickListener;
        }
    }

    public void f(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.h = z;
        }
    }

    public void g(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.g = z;
        }
    }

    public void h(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, onLongClickListener) == null) {
            this.a.d(onLongClickListener);
        }
    }

    public void i(boolean z) {
        fl9 fl9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) && (fl9Var = this.a) != null) {
            fl9Var.I(z);
        }
    }

    public void j(TbRichTextView.z zVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, zVar) == null) {
            this.a.n(zVar);
        }
    }

    public void e(ThreadData threadData, List<ym> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, threadData, list) == null) {
            this.a.K(threadData);
            if (!bi.isEmpty(this.c.I3().E0())) {
                this.a.J(this.c.I3().E0());
            }
            NewSubPbActivity newSubPbActivity = this.c;
            if (newSubPbActivity != null && newSubPbActivity.I3() != null) {
                this.a.H(this.c.I3().b1());
            }
            this.d.setData(list);
            this.d.getAdapter2().notifyDataSetChanged();
        }
    }
}
