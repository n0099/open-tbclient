package com.baidu.tieba.ala.livecard.adapters;

import android.view.View;
import android.view.ViewGroup;
import c.a.q0.s.q.d2;
import c.a.r0.b0.a0;
import c.a.r0.b0.c0;
import c.a.r0.p.e;
import c.a.r0.p.f;
import c.a.r0.w.k.e.c;
import c.a.r0.x0.j;
import c.a.r0.x0.k;
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
/* loaded from: classes7.dex */
public class FrsAlaShareItemAdapter extends k<d2, FrsPageAlaShareHolder> implements a0, f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c0<d2> A;
    public String x;
    public c y;
    public String z;

    /* loaded from: classes7.dex */
    public static class FrsPageAlaShareHolder extends TypeAdapter.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public c mView;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FrsPageAlaShareHolder(c cVar) {
            super(cVar.j());
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
            this.mView = cVar;
        }
    }

    /* loaded from: classes7.dex */
    public class a extends c0<d2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ FrsAlaShareItemAdapter f49726b;

        public a(FrsAlaShareItemAdapter frsAlaShareItemAdapter) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsAlaShareItemAdapter};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49726b = frsAlaShareItemAdapter;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.r0.b0.c0
        /* renamed from: d */
        public void a(View view, d2 d2Var) {
            CustomMessage customMessage;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, d2Var) == null) {
                if (view.getId() == R.id.layout_root) {
                    customMessage = new CustomMessage(2921018);
                } else if (view.getId() != R.id.card_home_page_normal_thread_user_name && view.getId() != R.id.card_home_page_normal_thread_user_header) {
                    customMessage = view.getId() == R.id.video_container ? new CustomMessage(2921019) : null;
                } else {
                    customMessage = new CustomMessage(2921016);
                }
                if (customMessage == null || this.f49726b.o == null) {
                    return;
                }
                customMessage.setData(d2Var);
                this.f49726b.o.sendMessage(customMessage);
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

    @Override // c.a.r0.b0.a0
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            this.x = str;
        }
    }

    @Override // c.a.r0.p.f
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.z = str;
        }
    }

    @Override // c.a.r0.b0.a0
    public void r(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.e.l.e.a
    /* renamed from: w0 */
    public FrsPageAlaShareHolder U(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, viewGroup)) == null) {
            TbPageContext<?> tbPageContext = this.o;
            if (tbPageContext == null) {
                return null;
            }
            c cVar = new c(tbPageContext, this.f2962i);
            this.y = cVar;
            cVar.Y(this.f2962i);
            this.y.a(this.x);
            this.y.m(this.A);
            return new FrsPageAlaShareHolder(this.y);
        }
        return (FrsPageAlaShareHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.r0.x0.k, c.a.e.l.e.a
    /* renamed from: x0 */
    public View a0(int i2, View view, ViewGroup viewGroup, d2 d2Var, FrsPageAlaShareHolder frsPageAlaShareHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i2), view, viewGroup, d2Var, frsPageAlaShareHolder})) == null) {
            CustomMessage customMessage = new CustomMessage(2921017);
            FrsViewData frsViewData = this.n;
            d2Var.T1 = (i2 + 1) - (frsViewData != null ? frsViewData.getTopThreadSize() : 0);
            customMessage.setData(d2Var);
            this.o.sendMessage(customMessage);
            if (d2Var != null) {
                c cVar = frsPageAlaShareHolder.mView;
                if (cVar instanceof e) {
                    cVar.setPage(this.z);
                }
                frsPageAlaShareHolder.mView.a(this.x);
                j.j(frsPageAlaShareHolder.mView.R(), this.n);
                j.j(frsPageAlaShareHolder.mView.T(), this.n);
                frsPageAlaShareHolder.mView.k(d2Var);
                d2Var.M4();
            }
            return frsPageAlaShareHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }
}
