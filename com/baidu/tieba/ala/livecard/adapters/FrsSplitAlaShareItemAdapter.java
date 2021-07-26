package com.baidu.tieba.ala.livecard.adapters;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.p0.s.q.a2;
import d.a.p0.s.q.b2;
import d.a.q0.a0.b0;
import d.a.q0.a0.z;
import d.a.q0.o.e;
import d.a.q0.o.f;
import d.a.q0.u0.j;
import d.a.q0.u0.k;
import d.a.q0.v.i.e.c;
/* loaded from: classes4.dex */
public class FrsSplitAlaShareItemAdapter extends k<a2, FrsPageAlaShareHolder> implements z, f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public b0<b2> A;
    public String x;
    public c y;
    public String z;

    /* loaded from: classes4.dex */
    public static class FrsPageAlaShareHolder extends TypeAdapter.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public c f14312a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FrsPageAlaShareHolder(c cVar) {
            super(cVar.k());
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((View) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14312a = cVar;
        }
    }

    /* loaded from: classes4.dex */
    public class a extends b0<b2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ FrsSplitAlaShareItemAdapter f14313b;

        public a(FrsSplitAlaShareItemAdapter frsSplitAlaShareItemAdapter) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsSplitAlaShareItemAdapter};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14313b = frsSplitAlaShareItemAdapter;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.q0.a0.b0
        /* renamed from: d */
        public void a(View view, b2 b2Var) {
            CustomMessage customMessage;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, b2Var) == null) {
                if (view.getId() == R.id.layout_root) {
                    customMessage = new CustomMessage(2921018);
                } else if (view.getId() != R.id.card_home_page_normal_thread_user_name && view.getId() != R.id.card_home_page_normal_thread_user_header) {
                    customMessage = view.getId() == R.id.video_container ? new CustomMessage(2921019) : null;
                } else {
                    customMessage = new CustomMessage(2921016);
                }
                if (customMessage == null || this.f14313b.o == null) {
                    return;
                }
                customMessage.setData(b2Var);
                this.f14313b.o.sendMessage(customMessage);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (BdUniqueId) objArr2[1], (BdUniqueId) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.A = new a(this);
    }

    @Override // d.a.q0.a0.z
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.x = str;
        }
    }

    @Override // d.a.q0.o.f
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.z = str;
        }
    }

    @Override // d.a.q0.a0.z
    public void r(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.d.k.e.a
    /* renamed from: w0 */
    public FrsPageAlaShareHolder Q(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, viewGroup)) == null) {
            TbPageContext<?> tbPageContext = this.o;
            if (tbPageContext == null) {
                return null;
            }
            c cVar = new c(tbPageContext, this.f42345i);
            this.y = cVar;
            cVar.S(this.f42345i);
            this.y.a(this.x);
            this.y.n(this.A);
            return new FrsPageAlaShareHolder(this.y);
        }
        return (FrsPageAlaShareHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.q0.u0.k, d.a.d.k.e.a
    /* renamed from: x0 */
    public View X(int i2, View view, ViewGroup viewGroup, a2 a2Var, FrsPageAlaShareHolder frsPageAlaShareHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i2), view, viewGroup, a2Var, frsPageAlaShareHolder})) == null) {
            CustomMessage customMessage = new CustomMessage(2921017);
            FrsViewData frsViewData = this.n;
            int topThreadSize = frsViewData != null ? frsViewData.getTopThreadSize() : 0;
            b2 b2Var = a2Var.w;
            b2Var.P1 = (a2Var.position + 1) - topThreadSize;
            customMessage.setData(b2Var);
            this.o.sendMessage(customMessage);
            if (a2Var != null) {
                c cVar = frsPageAlaShareHolder.f14312a;
                if (cVar instanceof e) {
                    cVar.setPage(this.z);
                }
                frsPageAlaShareHolder.f14312a.a(this.x);
                j.h(frsPageAlaShareHolder.f14312a.L(), this.n);
                j.h(frsPageAlaShareHolder.f14312a.N(), this.n);
                frsPageAlaShareHolder.f14312a.l(a2Var.w);
                a2Var.w.t4();
            }
            return frsPageAlaShareHolder.a();
        }
        return (View) invokeCommon.objValue;
    }
}
