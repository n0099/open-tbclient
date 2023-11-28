package com.baidu.tieba.forum.template;

import android.annotation.SuppressLint;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.statistics.UbcRemoteStat;
import com.baidu.tieba.do7;
import com.baidu.tieba.feed.list.FeedTemplateAdapter;
import com.baidu.tieba.ka7;
import com.baidu.tieba.nb7;
import com.baidu.tieba.pj7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006J\u001a\u0010\n\u001a\u00020\b2\u0012\u0010\u000b\u001a\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r\u0018\u00010\fJ\u0006\u0010\u000e\u001a\u00020\bJ\u000e\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u0004J\u0006\u0010\u0011\u001a\u00020\bJ\u000e\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0004J\u001c\u0010\u0014\u001a\u00020\b2\u0012\u0010\u000b\u001a\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r\u0018\u00010\fH\u0007J\u0006\u0010\u0015\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/baidu/tieba/forum/template/FrsTemplateAdapter;", "Lcom/baidu/tieba/feed/list/FeedTemplateAdapter;", "()V", "loadMoreCurCount", "", "recyclerView", "Lcom/baidu/adp/widget/ListView/BdRecyclerView;", UbcRemoteStat.BIND_SERVICE, "", "view", "loadMoreRefreshList", "newList", "", "Lcom/baidu/tieba/feed/list/TemplateData;", "notifyChangeSkin", "notifyFormPosition", "changeStartIndex", "notifyFormVisiblePosition", "notifyInsertIndex", "insertIndex", "refreshList", "resetLoadMoreCurCount", "forum_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class FrsTemplateAdapter extends FeedTemplateAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdRecyclerView m;
    public int n;

    public FrsTemplateAdapter() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public final void B() {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            List<? extends nb7<?>> list = this.a;
            if (list != null) {
                i = list.size();
            } else {
                i = 0;
            }
            this.n = i;
        }
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            BdRecyclerView bdRecyclerView = this.m;
            if (bdRecyclerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                bdRecyclerView = null;
            }
            x(bdRecyclerView.getFirstVisiblePosition());
        }
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public final void A(List<? extends nb7<?>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
            this.a = list;
            notifyDataSetChanged();
        }
    }

    public final void s(BdRecyclerView view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2) == null) {
            Intrinsics.checkNotNullParameter(view2, "view");
            e(view2);
            this.m = view2;
        }
    }

    public final void z(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            if (i < 0) {
                do7.a("插入数据数据异常，insertIndex<0，请检查调用逻辑！");
            } else {
                notifyItemInserted(i);
            }
        }
    }

    public final void t(List<? extends nb7<?>> list) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            if (list != null && !list.isEmpty()) {
                z = false;
            } else {
                z = true;
            }
            if (!z && list.size() >= this.n) {
                int size = list.size();
                int i = this.n;
                if (size == i) {
                    this.a = list;
                    notifyItemChanged(list.size() - 1);
                    return;
                }
                this.a = list;
                notifyItemRangeInserted(i, list.size() - i);
                return;
            }
            A(list);
            do7.a("加载更多数据异常，请检查调用逻辑！");
        }
    }

    public final void u() {
        List<? extends nb7<?>> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (list = this.a) != null) {
            for (nb7<?> nb7Var : list) {
                if (nb7Var instanceof ka7) {
                    ((ka7) nb7Var).d(new pj7());
                }
            }
        }
    }

    public final void x(int i) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            if (i <= 0) {
                notifyDataSetChanged();
                return;
            }
            List<? extends nb7<?>> list = this.a;
            if (list != null) {
                i2 = list.size();
            } else {
                i2 = 0;
            }
            int i3 = i2 - i;
            if (i3 <= 0) {
                notifyDataSetChanged();
                return;
            }
            BdRecyclerView bdRecyclerView = this.m;
            if (bdRecyclerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                bdRecyclerView = null;
            }
            if (bdRecyclerView.getFirstVisiblePosition() <= 0) {
                notifyDataSetChanged();
            } else {
                notifyItemRangeChanged(i, i3);
            }
        }
    }
}
