package com.baidu.tieba.downloadmanager.ui.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ItemData;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.ItemClickJumpUtil;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.ItemCardView;
import com.baidu.tbadk.core.view.itemcard.ItemCardHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.fj;
import com.baidu.tieba.nv4;
import com.baidu.tieba.q76;
import com.baidu.tieba.r76;
import com.baidu.tieba.rn;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class ItemCardViewWrapperAdapter extends rn {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public int c;
    public BdTypeRecyclerView d;

    /* loaded from: classes3.dex */
    public class ItemCardViewWrapperViewHolder extends TypeAdapter.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ItemCardView a;
        public View b;
        public EMTextView c;
        public View d;
        public final /* synthetic */ ItemCardViewWrapperAdapter e;

        /* loaded from: classes3.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ int a;
            public final /* synthetic */ r76 b;
            public final /* synthetic */ ItemCardViewWrapperViewHolder c;

            public a(ItemCardViewWrapperViewHolder itemCardViewWrapperViewHolder, int i, r76 r76Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {itemCardViewWrapperViewHolder, Integer.valueOf(i), r76Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.c = itemCardViewWrapperViewHolder;
                this.a = i;
                this.b = r76Var;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                    int i = this.c.e.b;
                    int i2 = this.a;
                    r76 r76Var = this.b;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001440, new q76(i, i2, r76Var.b, r76Var.a.mTitle, view2)));
                }
            }
        }

        /* loaded from: classes3.dex */
        public class b implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ r76 a;
            public final /* synthetic */ int b;
            public final /* synthetic */ ItemCardViewWrapperViewHolder c;

            public b(ItemCardViewWrapperViewHolder itemCardViewWrapperViewHolder, r76 r76Var, int i) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {itemCardViewWrapperViewHolder, r76Var, Integer.valueOf(i)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.c = itemCardViewWrapperViewHolder;
                this.a = r76Var;
                this.b = i;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                    ItemData itemData = this.a.a;
                    ItemClickJumpUtil.itemClickJump(itemData.forumName, String.valueOf(itemData.itemId), -1, 15);
                    if (3 == this.c.e.b) {
                        int i = this.c.e.b;
                        int i2 = this.b;
                        int z = this.c.a.z(this.a.a);
                        int i3 = this.a.b;
                        ItemCardHelper.f(i, i2, z, 2, this.a.a.mTitle, false);
                    }
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ItemCardViewWrapperViewHolder(ItemCardViewWrapperAdapter itemCardViewWrapperAdapter, View view2) {
            super(view2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {itemCardViewWrapperAdapter, view2};
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
            this.e = itemCardViewWrapperAdapter;
            ViewGroup viewGroup = (ViewGroup) view2;
            this.a = (ItemCardView) viewGroup.getChildAt(0);
            this.b = viewGroup.getChildAt(2);
            this.c = (EMTextView) viewGroup.getChildAt(1);
            this.d = viewGroup.getChildAt(3);
        }

        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                nv4.d(this.d).f(R.color.CAM_X0203);
                this.a.G();
                this.a.setBackground(null);
                SkinManager.setBackgroundColor(this.b, R.color.CAM_X0204);
                nv4 d = nv4.d(this.c);
                d.z(R.dimen.T_X06);
                d.A(R.string.F_X02);
                d.v(R.color.CAM_X0105);
                this.c.setBackground(null);
            }
        }

        public void c(r76 r76Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, r76Var) == null) {
                if (!r76Var.d) {
                    this.d.setVisibility(8);
                } else {
                    this.d.setVisibility(0);
                }
                if (r76Var.a == null) {
                    this.e.a = getLayoutPosition();
                    this.a.setVisibility(8);
                    this.c.setVisibility(0);
                    this.b.setVisibility(0);
                    return;
                }
                int layoutPosition = getLayoutPosition();
                if (this.e.a == -1 || layoutPosition <= this.e.a) {
                    layoutPosition++;
                }
                if (this.e.d.getHeaderViewsCount() != 0 && layoutPosition > this.e.a) {
                    layoutPosition--;
                }
                if (layoutPosition == 1 && this.e.d.getHeaderViewsCount() == 0) {
                    this.b.setVisibility(0);
                    ((FrameLayout.LayoutParams) this.a.getLayoutParams()).setMargins(0, fj.f(this.e.mContext, R.dimen.tbds21), 0, 0);
                } else {
                    this.b.setVisibility(8);
                    ((FrameLayout.LayoutParams) this.a.getLayoutParams()).setMargins(0, 0, 0, 0);
                }
                this.c.setVisibility(8);
                this.a.setVisibility(0);
                int i = r76Var.b;
                if (i == 1) {
                    this.a.setData(r76Var.a, 10, true, this.e.b, layoutPosition);
                } else if (i == 2) {
                    this.a.setData(r76Var.a, 10, true, r76Var.c, this.e.b, layoutPosition);
                } else {
                    this.a.setData(r76Var.a, 10, true, this.e.b, layoutPosition);
                }
                this.a.setOnClickListenerOfRightBtn(new a(this, layoutPosition, r76Var));
                this.a.setOnClickListener(new b(this, r76Var, layoutPosition));
                if (r76Var.a != null) {
                    StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_DOWNLOAD_MANAGER_SHOW);
                    statisticItem.addParam("uid", TbadkCoreApplication.getCurrentAccountId());
                    statisticItem.addParam("obj_locate", this.e.b);
                    statisticItem.addParam("obj_source", this.e.c);
                    statisticItem.addParam("obj_name", r76Var.a.itemId);
                    statisticItem.addParam("obj_type", this.a.z(r76Var.a));
                    TiebaStatic.log(statisticItem);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ItemCardViewWrapperAdapter(Context context, BdUniqueId bdUniqueId, int i, BdTypeRecyclerView bdTypeRecyclerView, int i2) {
        super(context, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, bdUniqueId, Integer.valueOf(i), bdTypeRecyclerView, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = -1;
        this.b = i;
        this.c = i2;
        this.d = bdTypeRecyclerView;
    }

    @Override // com.baidu.tieba.rn
    public /* bridge */ /* synthetic */ View onFillViewHolder(int i, View view2, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        z(i, view2, viewGroup, (r76) obj, (ItemCardViewWrapperViewHolder) viewHolder);
        return view2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.rn
    /* renamed from: y */
    public ItemCardViewWrapperViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            FrameLayout frameLayout = new FrameLayout(this.mContext);
            frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
            ItemCardView itemCardView = new ItemCardView(this.mContext);
            itemCardView.setIsShowRightBtn(true);
            itemCardView.setRadius(0);
            itemCardView.setItemImageViewRadius(R.string.J_X05);
            itemCardView.setFirstLineTextColor(R.color.CAM_X0105);
            itemCardView.setPosition(7);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            itemCardView.setPadding(fj.f(this.mContext, R.dimen.tbds18), fj.f(this.mContext, R.dimen.tbds26), fj.f(this.mContext, R.dimen.tbds4), fj.f(this.mContext, R.dimen.tbds18));
            frameLayout.addView(itemCardView, layoutParams);
            EMTextView eMTextView = new EMTextView(this.mContext);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
            layoutParams2.setMargins(0, fj.f(this.mContext, R.dimen.tbds21), 0, 0);
            eMTextView.setPadding(fj.f(this.mContext, R.dimen.M_W_X007), fj.f(this.mContext, R.dimen.tbds44), 0, 0);
            eMTextView.setText(R.string.obfuscated_res_0x7f0f0fdd);
            frameLayout.addView(eMTextView, layoutParams2);
            frameLayout.addView(new View(this.mContext), new ViewGroup.LayoutParams(-1, fj.f(this.mContext, R.dimen.tbds21)));
            View view2 = new View(this.mContext);
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, fj.f(this.mContext, R.dimen.tbds1));
            layoutParams3.setMargins(fj.f(this.mContext, R.dimen.tbds221), 0, fj.f(this.mContext, R.dimen.M_W_X007), 0);
            layoutParams3.gravity = 80;
            frameLayout.addView(view2, layoutParams3);
            return new ItemCardViewWrapperViewHolder(this, frameLayout);
        }
        return (ItemCardViewWrapperViewHolder) invokeL.objValue;
    }

    public View z(int i, View view2, ViewGroup viewGroup, r76 r76Var, ItemCardViewWrapperViewHolder itemCardViewWrapperViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, r76Var, itemCardViewWrapperViewHolder})) == null) {
            if (r76Var != null) {
                itemCardViewWrapperViewHolder.c(r76Var);
            }
            itemCardViewWrapperViewHolder.b();
            return view2;
        }
        return (View) invokeCommon.objValue;
    }
}
