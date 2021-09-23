package com.baidu.tieba.enterForum.view;

import android.content.Context;
import android.view.View;
import c.a.e.e.p.j;
import c.a.e.e.p.l;
import c.a.q0.k0.c.b;
import c.a.q0.s.s.i;
import c.a.r0.n0.d.f;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.dialog.PopupDialog;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class ForumManagerDialog extends PopupDialog {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext n;
    public Context o;
    public ViewEventCenter p;
    public final i q;
    public f r;
    public final List<c.a.q0.s.s.f> s;
    public final i.e t;

    /* loaded from: classes7.dex */
    public class a implements i.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ForumManagerDialog f50472e;

        public a(ForumManagerDialog forumManagerDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumManagerDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50472e = forumManagerDialog;
        }

        @Override // c.a.q0.s.s.i.e
        public void onItemClick(i iVar, int i2, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, iVar, i2, view) == null) {
                this.f50472e.dismiss();
                if (!j.z()) {
                    l.L(this.f50472e.o, R.string.network_not_available);
                } else if (i2 == 2) {
                    this.f50472e.p.dispatchMvcEvent(new b(4, this.f50472e.r, null, null));
                } else if (i2 == 1) {
                    this.f50472e.p.dispatchMvcEvent(new b(13, this.f50472e.r, null, null));
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ForumManagerDialog(TbPageContext tbPageContext, ViewEventCenter viewEventCenter) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, viewEventCenter};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((c.a.e.a.f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.t = new a(this);
        this.n = tbPageContext;
        this.o = tbPageContext.getPageActivity();
        this.p = viewEventCenter;
        this.s = new ArrayList();
        i iVar = new i(this.o);
        this.q = iVar;
        iVar.n(this.t);
        setContentView(this.q);
    }

    public final void i() {
        List<c.a.q0.s.s.f> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.r == null || (list = this.s) == null || this.q == null) {
            return;
        }
        list.clear();
        this.s.add(new c.a.q0.s.s.f(1, j(this.r.q() == 1 ? R.string.cancel_top : R.string.top, new Object[0]), this.q));
        this.s.add(new c.a.q0.s.s.f(2, j(R.string.delete, new Object[0]), this.q));
        this.q.k(this.s);
    }

    public final String j(int i2, Object... objArr) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, objArr)) == null) {
            Context context = this.o;
            if (context == null) {
                return null;
            }
            return context.getString(i2, objArr);
        }
        return (String) invokeIL.objValue;
    }

    public void onChangeSkinType() {
        i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (iVar = this.q) == null) {
            return;
        }
        iVar.j();
    }

    public void setData(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, fVar) == null) {
            this.r = fVar;
            i();
        }
    }
}
