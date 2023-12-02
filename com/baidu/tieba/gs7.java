package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.adp.widget.ListView.TypeAdapter.ViewHolder;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public abstract class gs7<T, V extends TypeAdapter.ViewHolder> extends ci<T, V> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public FrsViewData b;
    public TbPageContext<?> c;
    public bs7 d;
    public vi e;
    public int f;
    public es7 g;
    public boolean h;
    public mm6 i;
    public TbPageTag j;
    public boolean k;

    public void G(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
        }
    }

    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947804574, "Lcom/baidu/tieba/gs7;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947804574, "Lcom/baidu/tieba/gs7;");
                return;
            }
        }
        Resources resources = TbadkCoreApplication.getInst().getContext().getResources();
        resources.getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07041d);
        resources.getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701be);
        resources.getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070198);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public gs7(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(r1, bdUniqueId);
        Activity pageActivity;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        if (tbPageContext == null) {
            pageActivity = null;
        } else {
            pageActivity = tbPageContext.getPageActivity();
        }
        this.a = false;
        this.j = null;
        n(tbPageContext, tbPageContext != null ? tbPageContext.getUniqueId() : null);
    }

    public View t(ViewGroup viewGroup, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048587, this, viewGroup, i)) == null) {
            if (viewGroup == null) {
                return null;
            }
            if (viewGroup instanceof ListView) {
                ListView listView = (ListView) viewGroup;
                return listView.getChildAt(i - (listView.getFirstVisiblePosition() - listView.getHeaderViewsCount()));
            } else if (viewGroup instanceof BdRecyclerView) {
                BdRecyclerView bdRecyclerView = (BdRecyclerView) viewGroup;
                return bdRecyclerView.findViewHolderForAdapterPosition(i - (bdRecyclerView.getFirstVisiblePosition() - bdRecyclerView.getHeaderViewsCount())).itemView;
            } else if (!(viewGroup instanceof RecyclerView)) {
                return null;
            } else {
                return ((RecyclerView) viewGroup).findViewHolderForAdapterPosition(i).itemView;
            }
        }
        return (View) invokeLI.objValue;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public gs7(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(r1, bdUniqueId, bdUniqueId2);
        Activity pageActivity;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId, bdUniqueId2};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BdUniqueId) objArr2[1], (BdUniqueId) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        if (tbPageContext == null) {
            pageActivity = null;
        } else {
            pageActivity = tbPageContext.getPageActivity();
        }
        this.a = false;
        this.j = null;
        n(tbPageContext, bdUniqueId2);
    }

    public void A(bs7 bs7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bs7Var) == null) {
            this.d = bs7Var;
        }
    }

    public void B(FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, frsViewData) == null) {
            this.b = frsViewData;
        }
    }

    public void C(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.k = z;
        }
    }

    public void D(vi viVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, viVar) == null) {
            this.e = viVar;
        }
    }

    public void E(mm6 mm6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, mm6Var) == null) {
            this.i = mm6Var;
        }
    }

    public void F(TbPageTag tbPageTag) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, tbPageTag) == null) {
            this.j = tbPageTag;
        }
    }

    public void setFromCDN(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.a = z;
        }
    }

    public void z(es7 es7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, es7Var) == null) {
            this.g = es7Var;
        }
    }

    public void n(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048583, this, tbPageContext, bdUniqueId) == null) && tbPageContext != null) {
            this.mContext = tbPageContext.getPageActivity();
            this.c = tbPageContext;
            this.mPageId = bdUniqueId;
        }
    }

    @Override // com.baidu.tieba.ci
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, T t, V v) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i), view2, viewGroup, t, v})) == null) {
            this.f = TbadkCoreApplication.getInst().getSkinType();
            this.e = (vi) viewGroup;
            if (t instanceof mz4) {
                ((mz4) t).t.setResource(2);
                return null;
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }

    public TbPageTag u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.j;
        }
        return (TbPageTag) invokeV.objValue;
    }

    public boolean x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.h;
        }
        return invokeV.booleanValue;
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.mContext = null;
            this.c = null;
            this.d = null;
            this.mAdapterItemClickListener = null;
            this.mAdapterItemLongClickListener = null;
            es7 es7Var = this.g;
            if (es7Var != null) {
                es7Var.a();
                this.g = null;
            }
        }
    }
}
