package com.baidu.tieba.frs.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.view.GroupAdapter;
import com.baidu.tieba.yi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tbclient.FrsPage.FeedGroupInfo;
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0010\b\u0002\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004¢\u0006\u0002\u0010\u0006J\b\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\rH\u0016J\u0018\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\rH\u0016J\u0010\u0010\u0016\u001a\u00020\u000f2\b\u0010\u0017\u001a\u0004\u0018\u00010\bR\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\u0006¨\u0006\u0018"}, d2 = {"Lcom/baidu/tieba/frs/view/GroupAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/baidu/tieba/frs/view/GroupItemHolder;", "list", "", "Ltbclient/FrsPage/FeedGroupInfo;", "(Ljava/util/List;)V", TTDownloadField.TT_ITEM_CLICK_LISTENER, "Landroid/view/View$OnClickListener;", "getList", "()Ljava/util/List;", "setList", "getItemCount", "", "onBindViewHolder", "", "holder", CriusAttrConstants.POSITION, "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setItemClickListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "frs_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GroupAdapter extends RecyclerView.Adapter<GroupItemHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<FeedGroupInfo> a;
    public View.OnClickListener b;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GroupAdapter() {
        this(null, 1, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr = newInitContext.callArgs;
                this((List) objArr[0], ((Integer) objArr[1]).intValue(), (DefaultConstructorMarker) objArr[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public GroupAdapter(List<FeedGroupInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = list;
    }

    public final void o(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, onClickListener) == null) {
            this.b = onClickListener;
        }
    }

    public final void setList(List<FeedGroupInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, list) == null) {
            this.a = list;
        }
    }

    public /* synthetic */ GroupAdapter(List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : list);
    }

    public static final void n(GroupAdapter this$0, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, this$0, view2) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            View.OnClickListener onClickListener = this$0.b;
            if (onClickListener != null) {
                onClickListener.onClick(view2);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            List<FeedGroupInfo> list = this.a;
            if (list != null) {
                return list.size();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: l */
    public void onBindViewHolder(GroupItemHolder holder, int i) {
        FeedGroupInfo feedGroupInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, holder, i) == null) {
            Intrinsics.checkNotNullParameter(holder, "holder");
            List<FeedGroupInfo> list = this.a;
            if (list != null && (feedGroupInfo = list.get(i)) != null) {
                holder.c().setText(feedGroupInfo.name);
                holder.b().setTag(feedGroupInfo);
            }
            holder.d();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: m */
    public GroupItemHolder onCreateViewHolder(ViewGroup parent, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, parent, i)) == null) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            LinearLayout linearLayout = new LinearLayout(parent.getContext());
            ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-2, yi.g(parent.getContext(), R.dimen.tbds75));
            marginLayoutParams.leftMargin = yi.g(parent.getContext(), R.dimen.M_W_X006);
            linearLayout.setLayoutParams(marginLayoutParams);
            linearLayout.setPadding(yi.g(parent.getContext(), R.dimen.M_W_X006), 0, yi.g(parent.getContext(), R.dimen.M_W_X004), 0);
            linearLayout.setGravity(16);
            TextView textView = new TextView(parent.getContext());
            textView.setPadding(0, 0, 0, yi.g(parent.getContext(), R.dimen.tbds2));
            linearLayout.addView(textView);
            ImageView imageView = new ImageView(parent.getContext());
            imageView.setPadding(0, yi.g(parent.getContext(), R.dimen.tbds1), 0, 0);
            imageView.setAlpha(0.6f);
            linearLayout.addView(imageView);
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ax7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        GroupAdapter.n(GroupAdapter.this, view2);
                    }
                }
            });
            return new GroupItemHolder(linearLayout, textView, imageView);
        }
        return (GroupItemHolder) invokeLI.objValue;
    }
}
