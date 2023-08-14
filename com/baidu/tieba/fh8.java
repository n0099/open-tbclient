package com.baidu.tieba;

import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.immessagecenter.chatgroup.data.ChatRoomInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes5.dex */
public class fh8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinearLayoutManager a;
    public jh8 b;
    public long c;
    public sg8 d;
    public boolean e;
    public int f;
    public int g;
    public int h;
    public ci8 i;
    public bi8 j;
    public RecyclerView k;
    public final RecyclerView.OnScrollListener l;
    public Runnable m;

    /* loaded from: classes5.dex */
    public class a extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fh8 a;

        public a(fh8 fh8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fh8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fh8Var;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NonNull RecyclerView recyclerView, int i, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLII(1048576, this, recyclerView, i, i2) != null) || !this.a.e || this.a.b.n() == null) {
                return;
            }
            this.a.e = false;
            if (this.a.a.findViewByPosition(this.a.g) != null) {
                fh8 fh8Var = this.a;
                fh8Var.h = fh8Var.a.findViewByPosition(this.a.g).getTop();
            }
            this.a.b.n().scrollBy(0, (this.a.p() - this.a.n()) + this.a.h);
            this.a.h = 0;
            this.a.q();
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fh8 a;

        public b(fh8 fh8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fh8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fh8Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.k != null && this.a.i != null && this.a.i.a() != null) {
                this.a.i.a().setLocationScrolled(false);
                this.a.k.getAdapter().notifyItemChanged(this.a.f);
            }
        }
    }

    public fh8(@NonNull LinearLayoutManager linearLayoutManager, jh8 jh8Var, long j, sg8 sg8Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {linearLayoutManager, jh8Var, Long.valueOf(j), sg8Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = false;
        this.f = 0;
        this.g = 0;
        this.h = 0;
        this.k = null;
        this.l = new a(this);
        this.m = new b(this);
        this.a = linearLayoutManager;
        this.b = jh8Var;
        this.c = j;
        this.d = sg8Var;
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.c = -1L;
            this.e = false;
        }
    }

    public void r() {
        Runnable runnable;
        RecyclerView recyclerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (runnable = this.m) != null && (recyclerView = this.k) != null) {
            recyclerView.removeCallbacks(runnable);
        }
    }

    public final int n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.b.r() != null && this.b.n() != null) {
                return (this.b.r().getHeight() / 2) - this.b.n().getTop();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public final int o() {
        InterceptResult invokeV;
        sg8 sg8Var;
        ci8 ci8Var;
        ChatRoomInfo a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.c > 0 && (sg8Var = this.d) != null && !ListUtils.isEmpty(sg8Var.d())) {
                List<ug8> d = this.d.d();
                for (ug8 ug8Var : d) {
                    if (ug8Var != null && (ug8Var instanceof bi8)) {
                        bi8 bi8Var = (bi8) ug8Var;
                        List<ug8> subItems = bi8Var.getSubItems();
                        if (ListUtils.isEmpty(subItems)) {
                            continue;
                        } else {
                            for (ug8 ug8Var2 : subItems) {
                                if (ug8Var2 != null && (ug8Var2 instanceof ci8) && (a2 = (ci8Var = (ci8) ug8Var2).a()) != null && this.c == a2.getRoomId()) {
                                    this.f = subItems.indexOf(ug8Var2);
                                    this.g = d.indexOf(ug8Var);
                                    this.i = ci8Var;
                                    this.j = bi8Var;
                                    bi8Var.g(false);
                                    return d.indexOf(ug8Var);
                                }
                            }
                            continue;
                        }
                    }
                }
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public final int p() {
        InterceptResult invokeV;
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.d.getItemsCount() <= 0 || this.f <= 0 || this.b.n() == null || (viewGroup = (ViewGroup) this.b.n().getChildAt(0)) == null || viewGroup.findViewById(R.id.obfuscated_res_0x7f090eaf) == null || (viewGroup2 = (ViewGroup) viewGroup.findViewById(R.id.obfuscated_res_0x7f090eaf)) == null || viewGroup2.getChildAt(0) == null) {
                return 0;
            }
            return viewGroup2.getChildAt(0).getHeight() * (this.f + 1);
        }
        return invokeV.intValue;
    }

    public final void q() {
        ViewGroup viewGroup;
        ci8 ci8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (viewGroup = (ViewGroup) this.a.findViewByPosition(this.g)) != null) {
            RecyclerView recyclerView = (RecyclerView) viewGroup.findViewById(R.id.obfuscated_res_0x7f090eaf);
            this.k = recyclerView;
            if (recyclerView != null && recyclerView.getChildAt(this.f) != null && (ci8Var = this.i) != null && ci8Var.a() != null) {
                this.i.a().setLocationScrolled(true);
                this.k.getAdapter().notifyItemChanged(this.f);
                this.k.postDelayed(this.m, 3000L);
            }
        }
    }

    public void s() {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            int o = o();
            if (o >= 0 && this.b.n() != null) {
                int findFirstVisibleItemPosition = this.a.findFirstVisibleItemPosition();
                int findLastVisibleItemPosition = this.a.findLastVisibleItemPosition();
                if (o >= findFirstVisibleItemPosition && o <= findLastVisibleItemPosition) {
                    this.e = false;
                    if (this.a.findViewByPosition(o) != null) {
                        i = this.a.findViewByPosition(o).getTop();
                    } else {
                        i = 0;
                    }
                    this.b.n().scrollBy(0, (i - n()) + p());
                    q();
                    return;
                }
                this.e = true;
                this.a.scrollToPosition(o);
            } else if (this.a != null && this.b.n() != null) {
                this.a.scrollToPosition(0);
            }
        }
    }
}
