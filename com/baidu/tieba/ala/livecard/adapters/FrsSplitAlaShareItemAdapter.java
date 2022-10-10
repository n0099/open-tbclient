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
import com.baidu.tieba.bu4;
import com.baidu.tieba.ch6;
import com.baidu.tieba.dh6;
import com.baidu.tieba.g26;
import com.baidu.tieba.i26;
import com.baidu.tieba.so5;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.to5;
import com.baidu.tieba.zx5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class FrsSplitAlaShareItemAdapter extends dh6<bu4, FrsPageAlaShareHolder> implements g26, to5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String l;
    public zx5 m;
    public String n;
    public i26<ThreadData> o;

    /* loaded from: classes3.dex */
    public static class FrsPageAlaShareHolder extends TypeAdapter.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public zx5 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FrsPageAlaShareHolder(zx5 zx5Var) {
            super(zx5Var.h());
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zx5Var};
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
            this.a = zx5Var;
        }
    }

    /* loaded from: classes3.dex */
    public class a extends i26<ThreadData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsSplitAlaShareItemAdapter b;

        public a(FrsSplitAlaShareItemAdapter frsSplitAlaShareItemAdapter) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsSplitAlaShareItemAdapter};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = frsSplitAlaShareItemAdapter;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.i26
        /* renamed from: d */
        public void a(View view2, ThreadData threadData) {
            CustomMessage customMessage;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, threadData) == null) {
                if (view2.getId() == R.id.obfuscated_res_0x7f0912a7) {
                    customMessage = new CustomMessage(2921018);
                } else if (view2.getId() != R.id.obfuscated_res_0x7f09054e && view2.getId() != R.id.obfuscated_res_0x7f09054a) {
                    customMessage = view2.getId() == R.id.obfuscated_res_0x7f092516 ? new CustomMessage(2921019) : null;
                } else {
                    customMessage = new CustomMessage(2921016);
                }
                if (customMessage == null || this.b.c == null) {
                    return;
                }
                customMessage.setData(threadData);
                this.b.c.sendMessage(customMessage);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsSplitAlaShareItemAdapter(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
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
        this.o = new a(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.qn
    /* renamed from: G */
    public FrsPageAlaShareHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, viewGroup)) == null) {
            TbPageContext<?> tbPageContext = this.c;
            if (tbPageContext == null) {
                return null;
            }
            zx5 zx5Var = new zx5(tbPageContext, this.mPageId);
            this.m = zx5Var;
            zx5Var.T(this.mPageId);
            this.m.a(this.l);
            this.m.n(this.o);
            return new FrsPageAlaShareHolder(this.m);
        }
        return (FrsPageAlaShareHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.dh6, com.baidu.tieba.qn
    /* renamed from: H */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, bu4 bu4Var, FrsPageAlaShareHolder frsPageAlaShareHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), view2, viewGroup, bu4Var, frsPageAlaShareHolder})) == null) {
            CustomMessage customMessage = new CustomMessage(2921017);
            FrsViewData frsViewData = this.b;
            int topThreadSize = frsViewData != null ? frsViewData.getTopThreadSize() : 0;
            ThreadData threadData = bu4Var.t;
            threadData.statFloor = (bu4Var.position + 1) - topThreadSize;
            customMessage.setData(threadData);
            this.c.sendMessage(customMessage);
            if (bu4Var != null) {
                zx5 zx5Var = frsPageAlaShareHolder.a;
                if (zx5Var instanceof so5) {
                    zx5Var.b(this.n);
                }
                frsPageAlaShareHolder.a.a(this.l);
                ch6.j(frsPageAlaShareHolder.a.M(), this.b);
                ch6.j(frsPageAlaShareHolder.a.O(), this.b);
                frsPageAlaShareHolder.a.i(bu4Var.t);
                bu4Var.t.updateShowStatus();
            }
            return frsPageAlaShareHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    @Override // com.baidu.tieba.g26
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.l = str;
        }
    }

    @Override // com.baidu.tieba.to5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.n = str;
        }
    }

    @Override // com.baidu.tieba.g26
    public void p(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
        }
    }
}
