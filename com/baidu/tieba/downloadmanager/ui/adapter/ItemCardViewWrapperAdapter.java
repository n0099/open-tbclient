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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.a36;
import com.repackage.eo;
import com.repackage.gs4;
import com.repackage.mi;
import com.repackage.z26;
/* loaded from: classes3.dex */
public class ItemCardViewWrapperAdapter extends eo<a36, ItemCardViewWrapperViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int i;
    public int j;
    public int k;
    public BdTypeRecyclerView l;

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
            public final /* synthetic */ a36 b;
            public final /* synthetic */ ItemCardViewWrapperViewHolder c;

            public a(ItemCardViewWrapperViewHolder itemCardViewWrapperViewHolder, int i, a36 a36Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {itemCardViewWrapperViewHolder, Integer.valueOf(i), a36Var};
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
                this.b = a36Var;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                    int i = this.c.e.j;
                    int i2 = this.a;
                    a36 a36Var = this.b;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001440, new z26(i, i2, a36Var.b, a36Var.a.mTitle, view2)));
                }
            }
        }

        /* loaded from: classes3.dex */
        public class b implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a36 a;
            public final /* synthetic */ int b;
            public final /* synthetic */ ItemCardViewWrapperViewHolder c;

            public b(ItemCardViewWrapperViewHolder itemCardViewWrapperViewHolder, a36 a36Var, int i) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {itemCardViewWrapperViewHolder, a36Var, Integer.valueOf(i)};
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
                this.a = a36Var;
                this.b = i;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                    ItemData itemData = this.a.a;
                    ItemClickJumpUtil.itemClickJump(itemData.forumName, String.valueOf(itemData.itemId), -1, 15);
                    if (3 == this.c.e.j) {
                        int i = this.c.e.j;
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

        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                gs4.d(this.d).f(R.color.CAM_X0203);
                this.a.G();
                this.a.setBackground(null);
                SkinManager.setBackgroundColor(this.b, R.color.CAM_X0204);
                gs4 d = gs4.d(this.c);
                d.z(R.dimen.T_X06);
                d.A(R.string.F_X02);
                d.v(R.color.CAM_X0105);
                this.c.setBackground(null);
            }
        }

        public void e(a36 a36Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, a36Var) == null) {
                if (!a36Var.d) {
                    this.d.setVisibility(8);
                } else {
                    this.d.setVisibility(0);
                }
                if (a36Var.a == null) {
                    this.e.i = getLayoutPosition();
                    this.a.setVisibility(8);
                    this.c.setVisibility(0);
                    this.b.setVisibility(0);
                    return;
                }
                int layoutPosition = getLayoutPosition();
                if (this.e.i == -1 || layoutPosition <= this.e.i) {
                    layoutPosition++;
                }
                if (this.e.l.getHeaderViewsCount() != 0 && layoutPosition > this.e.i) {
                    layoutPosition--;
                }
                if (layoutPosition == 1 && this.e.l.getHeaderViewsCount() == 0) {
                    this.b.setVisibility(0);
                    ((FrameLayout.LayoutParams) this.a.getLayoutParams()).setMargins(0, mi.f(this.e.a, R.dimen.tbds21), 0, 0);
                } else {
                    this.b.setVisibility(8);
                    ((FrameLayout.LayoutParams) this.a.getLayoutParams()).setMargins(0, 0, 0, 0);
                }
                this.c.setVisibility(8);
                this.a.setVisibility(0);
                int i = a36Var.b;
                if (i == 1) {
                    this.a.setData(a36Var.a, 10, true, this.e.j, layoutPosition);
                } else if (i == 2) {
                    this.a.setData(a36Var.a, 10, true, a36Var.c, this.e.j, layoutPosition);
                } else {
                    this.a.setData(a36Var.a, 10, true, this.e.j, layoutPosition);
                }
                this.a.setOnClickListenerOfRightBtn(new a(this, layoutPosition, a36Var));
                this.a.setOnClickListener(new b(this, a36Var, layoutPosition));
                if (a36Var.a != null) {
                    StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_DOWNLOAD_MANAGER_SHOW);
                    statisticItem.addParam("uid", TbadkCoreApplication.getCurrentAccountId());
                    statisticItem.addParam("obj_locate", this.e.j);
                    statisticItem.addParam("obj_source", this.e.k);
                    statisticItem.addParam("obj_name", a36Var.a.itemId);
                    statisticItem.addParam("obj_type", this.a.z(a36Var.a));
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
        this.i = -1;
        this.j = i;
        this.k = i2;
        this.l = bdTypeRecyclerView;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // com.repackage.eo
    public /* bridge */ /* synthetic */ View S(int i, View view2, ViewGroup viewGroup, a36 a36Var, ItemCardViewWrapperViewHolder itemCardViewWrapperViewHolder) {
        g0(i, view2, viewGroup, a36Var, itemCardViewWrapperViewHolder);
        return view2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.eo
    /* renamed from: f0 */
    public ItemCardViewWrapperViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            FrameLayout frameLayout = new FrameLayout(this.a);
            frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
            ItemCardView itemCardView = new ItemCardView(this.a);
            itemCardView.setIsShowRightBtn(true);
            itemCardView.setRadius(0);
            itemCardView.setItemImageViewRadius(R.string.J_X05);
            itemCardView.setFirstLineTextColor(R.color.CAM_X0105);
            itemCardView.setPosition(7);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            itemCardView.setPadding(mi.f(this.a, R.dimen.tbds18), mi.f(this.a, R.dimen.tbds26), mi.f(this.a, R.dimen.tbds4), mi.f(this.a, R.dimen.tbds18));
            frameLayout.addView(itemCardView, layoutParams);
            EMTextView eMTextView = new EMTextView(this.a);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
            layoutParams2.setMargins(0, mi.f(this.a, R.dimen.tbds21), 0, 0);
            eMTextView.setPadding(mi.f(this.a, R.dimen.M_W_X007), mi.f(this.a, R.dimen.tbds44), 0, 0);
            eMTextView.setText(R.string.obfuscated_res_0x7f0f0f74);
            frameLayout.addView(eMTextView, layoutParams2);
            frameLayout.addView(new View(this.a), new ViewGroup.LayoutParams(-1, mi.f(this.a, R.dimen.tbds21)));
            View view2 = new View(this.a);
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, mi.f(this.a, R.dimen.tbds1));
            layoutParams3.setMargins(mi.f(this.a, R.dimen.tbds221), 0, mi.f(this.a, R.dimen.M_W_X007), 0);
            layoutParams3.gravity = 80;
            frameLayout.addView(view2, layoutParams3);
            return new ItemCardViewWrapperViewHolder(this, frameLayout);
        }
        return (ItemCardViewWrapperViewHolder) invokeL.objValue;
    }

    public View g0(int i, View view2, ViewGroup viewGroup, a36 a36Var, ItemCardViewWrapperViewHolder itemCardViewWrapperViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, a36Var, itemCardViewWrapperViewHolder})) == null) {
            if (a36Var != null) {
                itemCardViewWrapperViewHolder.e(a36Var);
            }
            itemCardViewWrapperViewHolder.d();
            return view2;
        }
        return (View) invokeCommon.objValue;
    }
}
