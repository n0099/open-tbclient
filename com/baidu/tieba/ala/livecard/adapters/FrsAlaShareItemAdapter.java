package com.baidu.tieba.ala.livecard.adapters;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.au5;
import com.repackage.bd6;
import com.repackage.bk5;
import com.repackage.cd6;
import com.repackage.ck5;
import com.repackage.hy5;
import com.repackage.jy5;
/* loaded from: classes3.dex */
public class FrsAlaShareItemAdapter extends cd6<ThreadData, FrsPageAlaShareHolder> implements hy5, ck5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String t;
    public au5 u;
    public String v;
    public jy5<ThreadData> w;

    /* loaded from: classes3.dex */
    public static class FrsPageAlaShareHolder extends TypeAdapter.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public au5 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FrsPageAlaShareHolder(au5 au5Var) {
            super(au5Var.h());
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {au5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((View) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = au5Var;
        }
    }

    /* loaded from: classes3.dex */
    public class a extends jy5<ThreadData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsAlaShareItemAdapter b;

        public a(FrsAlaShareItemAdapter frsAlaShareItemAdapter) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsAlaShareItemAdapter};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = frsAlaShareItemAdapter;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.jy5
        /* renamed from: d */
        public void a(View view2, ThreadData threadData) {
            CustomMessage customMessage;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, threadData) == null) {
                if (view2.getId() == R.id.obfuscated_res_0x7f091251) {
                    customMessage = new CustomMessage(2921018);
                } else if (view2.getId() != R.id.obfuscated_res_0x7f090524 && view2.getId() != R.id.obfuscated_res_0x7f090520) {
                    customMessage = view2.getId() == R.id.obfuscated_res_0x7f09238b ? new CustomMessage(2921019) : null;
                } else {
                    customMessage = new CustomMessage(2921016);
                }
                if (customMessage == null || this.b.k == null) {
                    return;
                }
                customMessage.setData(threadData);
                this.b.k.sendMessage(customMessage);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsAlaShareItemAdapter(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId, bdUniqueId2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (BdUniqueId) objArr2[1], (BdUniqueId) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.w = new a(this);
    }

    @Override // com.repackage.hy5
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.t = str;
        }
    }

    @Override // com.repackage.ck5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.v = str;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.an
    /* renamed from: n0 */
    public FrsPageAlaShareHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, viewGroup)) == null) {
            TbPageContext<?> tbPageContext = this.k;
            if (tbPageContext == null) {
                return null;
            }
            au5 au5Var = new au5(tbPageContext, this.e);
            this.u = au5Var;
            au5Var.T(this.e);
            this.u.a(this.t);
            this.u.n(this.w);
            return new FrsPageAlaShareHolder(this.u);
        }
        return (FrsPageAlaShareHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.cd6, com.repackage.an
    /* renamed from: o0 */
    public View S(int i, View view2, ViewGroup viewGroup, ThreadData threadData, FrsPageAlaShareHolder frsPageAlaShareHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), view2, viewGroup, threadData, frsPageAlaShareHolder})) == null) {
            CustomMessage customMessage = new CustomMessage(2921017);
            FrsViewData frsViewData = this.j;
            threadData.statFloor = (i + 1) - (frsViewData != null ? frsViewData.getTopThreadSize() : 0);
            customMessage.setData(threadData);
            this.k.sendMessage(customMessage);
            if (threadData != null) {
                au5 au5Var = frsPageAlaShareHolder.a;
                if (au5Var instanceof bk5) {
                    au5Var.b(this.v);
                }
                frsPageAlaShareHolder.a.a(this.t);
                bd6.j(frsPageAlaShareHolder.a.M(), this.j);
                bd6.j(frsPageAlaShareHolder.a.O(), this.j);
                frsPageAlaShareHolder.a.i(threadData);
                threadData.updateShowStatus();
            }
            return frsPageAlaShareHolder.b();
        }
        return (View) invokeCommon.objValue;
    }

    @Override // com.repackage.hy5
    public void q(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
        }
    }
}
