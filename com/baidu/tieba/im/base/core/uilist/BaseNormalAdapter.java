package com.baidu.tieba.im.base.core.uilist;

import android.content.Context;
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
import com.baidu.tieba.cu5;
import com.baidu.tieba.im.base.core.uilist.BaseItem;
import com.baidu.tieba.im.base.core.uilist.BaseNormalAdapter.SelfHolder;
import com.baidu.tieba.im.base.core.uilist.BaseViewHolder;
import com.baidu.tieba.im.lib.socket.msg.TbNormalMsg;
import com.baidu.tieba.iq8;
import com.baidu.tieba.nq8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collections;
import java.util.List;
/* loaded from: classes6.dex */
public abstract class BaseNormalAdapter<ChildItemData extends BaseItem<? extends TbNormalMsg>, ChildViewHolder extends BaseViewHolder, ChildExtraHolder extends BaseViewHolder, BaseStyleHolder extends SelfHolder> extends iq8<ChildItemData, Holder<ChildViewHolder, ChildExtraHolder, BaseStyleHolder>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public MsgSender<? extends BaseNormalAdapter, ChildItemData> l;

    /* loaded from: classes6.dex */
    public static abstract class NonExtraHolder extends BaseViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    @Nullable
    public ChildExtraHolder N(@NonNull ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            return null;
        }
        return (ChildExtraHolder) invokeL.objValue;
    }

    @NonNull
    public abstract ChildViewHolder O(@NonNull ViewGroup viewGroup);

    @Nullable
    public ChildExtraHolder P(@NonNull ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, viewGroup)) == null) {
            return null;
        }
        return (ChildExtraHolder) invokeL.objValue;
    }

    @NonNull
    public abstract ChildViewHolder Q(@NonNull ViewGroup viewGroup);

    public abstract BaseStyleHolder R(@NonNull ViewGroup viewGroup);

    public abstract BaseStyleHolder S(@NonNull ViewGroup viewGroup);

    public void U(int i, @NonNull ViewGroup viewGroup, @NonNull ChildItemData childitemdata, @NonNull ChildExtraHolder childextraholder, @NonNull List<Object> list, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Integer.valueOf(i), viewGroup, childitemdata, childextraholder, list, Integer.valueOf(i2)}) == null) {
        }
    }

    public abstract void V(int i, @NonNull ViewGroup viewGroup, @NonNull ChildItemData childitemdata, @NonNull ChildViewHolder childviewholder, @NonNull List<Object> list, int i2);

    public abstract void W(int i, @NonNull ViewGroup viewGroup, @NonNull ChildItemData childitemdata, @NonNull BaseStyleHolder basestyleholder, @NonNull List<Object> list, int i2);

    /* loaded from: classes6.dex */
    public static class Holder<ChildViewHolder extends BaseViewHolder, ChildExtraHolder extends BaseViewHolder, BaseStyleHolder extends BaseViewHolder> extends BaseViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public BaseStyleHolder a;
        public BaseStyleHolder b;
        public ChildViewHolder c;
        public ChildViewHolder d;
        @Nullable
        public ChildExtraHolder e;
        @Nullable
        public ChildExtraHolder f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Holder(@NonNull View view2, @NonNull BaseStyleHolder basestyleholder, @NonNull BaseStyleHolder basestyleholder2, @NonNull ChildViewHolder childviewholder, @NonNull ChildViewHolder childviewholder2, @Nullable ChildExtraHolder childextraholder, @Nullable ChildExtraHolder childextraholder2) {
            super(view2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view2, basestyleholder, basestyleholder2, childviewholder, childviewholder2, childextraholder, childextraholder2};
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
            this.a = basestyleholder;
            this.b = basestyleholder2;
            basestyleholder.c(this);
            basestyleholder2.c(this);
            this.c = childviewholder;
            this.d = childviewholder2;
            childviewholder.c(this);
            childviewholder2.c(this);
            this.e = childextraholder;
            this.f = childextraholder2;
            if (e()) {
                this.e.c(this);
                this.f.c(this);
            }
        }

        @Override // com.baidu.tieba.im.base.core.uilist.BaseViewHolder
        public void a(@Nullable View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, onClickListener) == null) {
                this.a.a(onClickListener);
                this.b.a(onClickListener);
                this.c.a(onClickListener);
                this.d.a(onClickListener);
                if (e()) {
                    this.e.a(onClickListener);
                    this.f.a(onClickListener);
                }
            }
        }

        @Override // com.baidu.tieba.im.base.core.uilist.BaseViewHolder
        public void b(@Nullable View.OnLongClickListener onLongClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, onLongClickListener) == null) {
                super.b(onLongClickListener);
                this.a.b(onLongClickListener);
                this.b.b(onLongClickListener);
                this.c.b(onLongClickListener);
                this.d.b(onLongClickListener);
                if (e()) {
                    this.e.b(onLongClickListener);
                    this.f.b(onLongClickListener);
                }
            }
        }

        @Override // com.baidu.tieba.im.base.core.uilist.BaseViewHolder
        public void d(@NonNull nq8 nq8Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, nq8Var) == null) {
                super.d(nq8Var);
                this.a.d(nq8Var);
                this.b.d(nq8Var);
                this.c.d(nq8Var);
                this.d.d(nq8Var);
                if (e()) {
                    this.e.d(nq8Var);
                    this.f.d(nq8Var);
                }
            }
        }

        public final boolean e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                if (this.e != null && this.f != null) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public static abstract class SelfHolder extends BaseViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @NonNull
        public abstract ViewGroup e();

        @Nullable
        public ViewGroup f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return null;
            }
            return (ViewGroup) invokeV.objValue;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SelfHolder(@NonNull View view2) {
            super(view2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view2};
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
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseNormalAdapter(@NonNull TbPageContext<?> tbPageContext, @NonNull BdUniqueId bdUniqueId) {
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

    @Override // com.baidu.tieba.iq8
    @NonNull
    public Context D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.mContext;
        }
        return (Context) invokeV.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.tieba.im.base.core.uilist.BaseNormalAdapter<ChildItemData extends com.baidu.tieba.im.base.core.uilist.BaseItem<? extends com.baidu.tieba.im.lib.socket.msg.TbNormalMsg>, ChildViewHolder extends com.baidu.tieba.im.base.core.uilist.BaseViewHolder, ChildExtraHolder extends com.baidu.tieba.im.base.core.uilist.BaseViewHolder, BaseStyleHolder extends com.baidu.tieba.im.base.core.uilist.BaseNormalAdapter$SelfHolder> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.ci
    public /* bridge */ /* synthetic */ View onFillViewHolder(int i, View view2, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        X(i, view2, viewGroup, (BaseItem) obj, (Holder) viewHolder);
        return view2;
    }

    public <T extends BaseNormalAdapter> void M(@NonNull MsgSender<T, ChildItemData> msgSender) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, msgSender) == null) {
            this.l = msgSender;
            msgSender.f(this);
            this.a.c(msgSender);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ci
    /* renamed from: T */
    public final Holder<ChildViewHolder, ChildExtraHolder, BaseStyleHolder> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        boolean z;
        boolean z2;
        ChildExtraHolder childextraholder;
        boolean z3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, viewGroup)) == null) {
            FrameLayout frameLayout = new FrameLayout(viewGroup.getContext());
            frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            BaseStyleHolder R = R(viewGroup);
            BaseStyleHolder S = S(viewGroup);
            ChildViewHolder O = O(R.e());
            ChildViewHolder Q = Q(S.e());
            boolean z4 = true;
            if (O.itemView.getParent() == null) {
                z = true;
            } else {
                z = false;
            }
            cu5.e(z, "子类视图不需要手动添加到父布局中");
            if (Q.itemView.getParent() == null) {
                z2 = true;
            } else {
                z2 = false;
            }
            cu5.e(z2, "子类视图不需要手动添加到父布局中");
            R.e().addView(O.itemView);
            S.e().addView(Q.itemView);
            ViewGroup f = R.f();
            ViewGroup f2 = S.f();
            ChildExtraHolder childextraholder2 = null;
            if (f != null && f2 != null) {
                ChildExtraHolder N = N(f);
                ChildExtraHolder P = P(f2);
                if (N != null && P != null) {
                    if (N.itemView.getParent() == null) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    cu5.e(z3, "子类扩展区视图不需要手动添加到父布局中");
                    if (P.itemView.getParent() != null) {
                        z4 = false;
                    }
                    cu5.e(z4, "子类扩展区视图不需要手动添加到父布局中");
                    f.addView(N.itemView);
                    f2.addView(P.itemView);
                }
                childextraholder = N;
                childextraholder2 = P;
            } else {
                childextraholder = null;
            }
            frameLayout.addView(R.itemView);
            frameLayout.addView(S.itemView);
            Holder<ChildViewHolder, ChildExtraHolder, BaseStyleHolder> holder = new Holder<>(frameLayout, R, S, O, Q, childextraholder, childextraholder2);
            K(holder);
            return holder;
        }
        return (Holder) invokeL.objValue;
    }

    public View X(int i, View view2, ViewGroup viewGroup, ChildItemData childitemdata, Holder<ChildViewHolder, ChildExtraHolder, BaseStyleHolder> holder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{Integer.valueOf(i), view2, viewGroup, childitemdata, holder})) == null) {
            onFillViewHolder(i, viewGroup, holder, childitemdata, Collections.EMPTY_LIST);
            return view2;
        }
        return (View) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.iq8, com.baidu.tieba.ci
    /* renamed from: Y */
    public void onFillViewHolder(int i, ViewGroup viewGroup, Holder<ChildViewHolder, ChildExtraHolder, BaseStyleHolder> holder, ChildItemData childitemdata, @NonNull List<Object> list) {
        BaseStyleHolder basestyleholder;
        ChildViewHolder childviewholder;
        ChildExtraHolder childextraholder;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Integer.valueOf(i), viewGroup, holder, childitemdata, list}) == null) {
            super.onFillViewHolder(i, viewGroup, holder, childitemdata, list);
            boolean isLeft = childitemdata.isLeft();
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (isLeft) {
                holder.a.itemView.setVisibility(0);
                holder.b.itemView.setVisibility(8);
            } else {
                holder.a.itemView.setVisibility(8);
                holder.b.itemView.setVisibility(0);
            }
            if (isLeft) {
                basestyleholder = holder.a;
            } else {
                basestyleholder = holder.b;
            }
            BaseStyleHolder basestyleholder2 = basestyleholder;
            W(i, (ViewGroup) holder.itemView, childitemdata, basestyleholder2, list, skinType);
            ViewGroup e = basestyleholder2.e();
            if (isLeft) {
                childviewholder = holder.c;
            } else {
                childviewholder = holder.d;
            }
            V(i, e, childitemdata, childviewholder, list, skinType);
            ViewGroup f = basestyleholder2.f();
            if (isLeft) {
                childextraholder = holder.e;
            } else {
                childextraholder = holder.f;
            }
            ChildExtraHolder childextraholder2 = childextraholder;
            if (f != null && childextraholder2 != null) {
                U(i, f, childitemdata, childextraholder2, list, skinType);
            }
            cu5.c(this.l, "必须绑定消费发送帮助器");
            if (childitemdata.getSendStatus() == 0) {
                this.l.m(childitemdata, i);
            }
        }
    }
}
