package com.baidu.tieba;

import androidx.fragment.app.FragmentActivity;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.mvc.message.ReadCacheMessage;
import com.baidu.tbadk.mvc.message.ReadCacheRespMsg;
import com.baidu.tbadk.mvc.message.WriteCacheMessage;
import com.baidu.tbadk.mvc.message.WriteCacheRespMsg;
import com.baidu.tbadk.mvc.model.CacheModel;
import com.baidu.tieba.forum.view.TopCardView;
import com.baidu.tieba.myCollection.baseHistory.PbHistoryCacheModel;
import com.baidu.tieba.myCollection.baseHistory.PbHistoryData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class eh7 extends pg7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final FragmentActivity b;
    public TopCardView c;
    public List<r77> d;
    public int e;
    public boolean f;
    public String g;
    public List<? extends PbHistoryData> h;
    public final Object i;
    public final a j;

    /* loaded from: classes5.dex */
    public static final class a implements CacheModel.CacheModelCallback<PbHistoryData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ eh7 a;

        @Override // com.baidu.tbadk.mvc.model.CacheModel.CacheModelCallback
        public void onCacheDataWrite(WriteCacheRespMsg<List<PbHistoryData>> writeCacheRespMsg, WriteCacheMessage<PbHistoryData> writeCacheMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, writeCacheRespMsg, writeCacheMessage) == null) {
            }
        }

        public a(eh7 eh7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eh7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eh7Var;
        }

        @Override // com.baidu.tbadk.mvc.model.CacheModel.CacheModelCallback
        public void onCacheDataGet(ReadCacheRespMsg<List<PbHistoryData>> readCacheRespMsg, ReadCacheMessage<PbHistoryData> readCacheMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, readCacheRespMsg, readCacheMessage) == null) && readCacheRespMsg != null && readCacheRespMsg.getData() != null) {
                eh7 eh7Var = this.a;
                List<PbHistoryData> data = readCacheRespMsg.getData();
                Intrinsics.checkNotNull(data);
                eh7Var.h = data;
                eh7 eh7Var2 = this.a;
                eh7Var2.A(eh7Var2.d);
                TopCardView topCardView = this.a.c;
                if (topCardView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTopCardView");
                    topCardView = null;
                }
                topCardView.m(this.a.d, this.a.e, this.a.f, this.a.g);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class b extends qq6<ih5> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ eh7 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(eh7 eh7Var, Class<ih5> cls) {
            super(cls);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eh7Var, cls};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Class) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = eh7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.qq6
        public void onEvent(ih5 event) {
            TopCardView topCardView;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, event) == null) {
                Intrinsics.checkNotNullParameter(event, "event");
                if (StringUtils.isNotNull(event.a())) {
                    Iterator it = this.b.d.iterator();
                    while (true) {
                        topCardView = null;
                        String str = null;
                        if (!it.hasNext()) {
                            break;
                        }
                        r77 r77Var = (r77) it.next();
                        String a = event.a();
                        l77 h = r77Var.h();
                        if (h != null) {
                            str = h.c;
                        }
                        if (Intrinsics.areEqual(a, str)) {
                            r77Var.l(true);
                        }
                    }
                    TopCardView topCardView2 = this.b.c;
                    if (topCardView2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mTopCardView");
                    } else {
                        topCardView = topCardView2;
                    }
                    topCardView.l(this.b.d, event.a());
                }
            }
        }
    }

    public eh7(FragmentActivity activity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.b = activity;
        this.d = new ArrayList();
        this.g = "";
        this.h = new ArrayList();
        this.i = new Object();
        this.j = new a(this);
    }

    @Override // com.baidu.tieba.pg7
    public void i(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            TopCardView topCardView = this.c;
            if (topCardView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTopCardView");
                topCardView = null;
            }
            topCardView.r();
        }
    }

    public final boolean y(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            for (PbHistoryData pbHistoryData : this.h) {
                if (pbHistoryData.getThreadId().equals(str)) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void z(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            this.e = i;
        }
    }

    public final void A(List<r77> list) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
            for (r77 r77Var : list) {
                l77 h = r77Var.h();
                if (h != null) {
                    str = h.c;
                } else {
                    str = null;
                }
                r77Var.l(y(str.toString()));
            }
        }
    }

    @Override // com.baidu.tieba.pg7
    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.l();
            nq6.b().a(this.i);
        }
    }

    public final void w(TopCardView topCardView, u47 uiState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, topCardView, uiState) == null) {
            Intrinsics.checkNotNullParameter(topCardView, "topCardView");
            Intrinsics.checkNotNullParameter(uiState, "uiState");
            this.c = topCardView;
            this.d = uiState.n();
            this.e = uiState.l();
            this.f = uiState.o();
            this.g = uiState.m();
        }
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            PbHistoryCacheModel pbHistoryCacheModel = new PbHistoryCacheModel(yl7.a(this.b));
            pbHistoryCacheModel.setCallback(this.j);
            pbHistoryCacheModel.loadCache();
            nq6.b().b(this.i, new b(this, ih5.class));
        }
    }
}
