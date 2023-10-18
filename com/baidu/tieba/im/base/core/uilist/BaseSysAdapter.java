package com.baidu.tieba.im.base.core.uilist;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ga8;
import com.baidu.tieba.im.base.core.uilist.BaseItem;
import com.baidu.tieba.im.base.core.uilist.BaseViewHolder;
import com.baidu.tieba.im.lib.socket.msg.TbSysMsg;
import com.baidu.tieba.la8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collections;
import java.util.List;
/* loaded from: classes6.dex */
public abstract class BaseSysAdapter<ChildItemData extends BaseItem<? extends TbSysMsg>, ChildViewHolder extends BaseViewHolder> extends ga8<ChildItemData, Holder<ChildViewHolder>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public abstract ChildViewHolder L(@NonNull ViewGroup viewGroup);

    public abstract void N(int i, @NonNull ViewGroup viewGroup, @NonNull ChildItemData childitemdata, @NonNull ChildViewHolder childviewholder, @NonNull List<Object> list, int i2);

    /* loaded from: classes6.dex */
    public static class Holder<ChildViewHolder extends BaseViewHolder> extends BaseViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ChildViewHolder a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Holder(@NonNull View view2, @NonNull ChildViewHolder childviewholder) {
            super(view2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view2, childviewholder};
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
            c(this);
            this.a = childviewholder;
            childviewholder.c(this);
        }

        @Override // com.baidu.tieba.im.base.core.uilist.BaseViewHolder
        public void a(@Nullable View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, onClickListener) == null) {
                super.a(onClickListener);
                this.a.a(onClickListener);
            }
        }

        @Override // com.baidu.tieba.im.base.core.uilist.BaseViewHolder
        public void b(@Nullable View.OnLongClickListener onLongClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, onLongClickListener) == null) {
                super.b(onLongClickListener);
                this.a.b(onLongClickListener);
            }
        }

        @Override // com.baidu.tieba.im.base.core.uilist.BaseViewHolder
        public void d(@NonNull la8 la8Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, la8Var) == null) {
                super.d(la8Var);
                this.a.d(la8Var);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseSysAdapter(@NonNull TbPageContext<?> tbPageContext, @NonNull BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.tieba.im.base.core.uilist.BaseSysAdapter<ChildItemData extends com.baidu.tieba.im.base.core.uilist.BaseItem<? extends com.baidu.tieba.im.lib.socket.msg.TbSysMsg>, ChildViewHolder extends com.baidu.tieba.im.base.core.uilist.BaseViewHolder> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.lh
    public /* bridge */ /* synthetic */ View onFillViewHolder(int i, View view2, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        O(i, view2, viewGroup, (BaseItem) obj, (Holder) viewHolder);
        return view2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lh
    /* renamed from: M */
    public final Holder<ChildViewHolder> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            FrameLayout frameLayout = new FrameLayout(viewGroup.getContext());
            frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            ChildViewHolder L = L(frameLayout);
            frameLayout.addView(L.itemView);
            Holder<ChildViewHolder> holder = new Holder<>(frameLayout, L);
            J(holder);
            return holder;
        }
        return (Holder) invokeL.objValue;
    }

    public final View O(int i, View view2, ViewGroup viewGroup, ChildItemData childitemdata, Holder<ChildViewHolder> holder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), view2, viewGroup, childitemdata, holder})) == null) {
            onFillViewHolder(i, viewGroup, holder, childitemdata, Collections.EMPTY_LIST);
            return view2;
        }
        return (View) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ga8, com.baidu.tieba.lh
    /* renamed from: P */
    public void onFillViewHolder(int i, ViewGroup viewGroup, Holder<ChildViewHolder> holder, ChildItemData childitemdata, @NonNull List<Object> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), viewGroup, holder, childitemdata, list}) == null) {
            super.onFillViewHolder(i, viewGroup, holder, childitemdata, list);
            N(i, viewGroup, childitemdata, holder.a, list, TbadkCoreApplication.getInst().getSkinType());
        }
    }
}
