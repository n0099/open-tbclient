package com.baidu.tieba.downloadmanager.ui.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import c.a.d.f.p.n;
import c.a.d.o.e.a;
import c.a.o0.r.v.c;
import c.a.p0.r0.a.b;
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
/* loaded from: classes5.dex */
public class ItemCardViewWrapperAdapter extends a<b, ItemCardViewWrapperViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int i;
    public int j;
    public int k;
    public BdTypeRecyclerView l;

    /* loaded from: classes5.dex */
    public class ItemCardViewWrapperViewHolder extends TypeAdapter.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ItemCardView a;

        /* renamed from: b  reason: collision with root package name */
        public View f31768b;

        /* renamed from: c  reason: collision with root package name */
        public EMTextView f31769c;

        /* renamed from: d  reason: collision with root package name */
        public View f31770d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ItemCardViewWrapperAdapter f31771e;

        /* loaded from: classes5.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ int a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ c.a.p0.r0.a.b f31772b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ ItemCardViewWrapperViewHolder f31773c;

            public a(ItemCardViewWrapperViewHolder itemCardViewWrapperViewHolder, int i, c.a.p0.r0.a.b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {itemCardViewWrapperViewHolder, Integer.valueOf(i), bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f31773c = itemCardViewWrapperViewHolder;
                this.a = i;
                this.f31772b = bVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    int i = this.f31773c.f31771e.j;
                    int i2 = this.a;
                    c.a.p0.r0.a.b bVar = this.f31772b;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001440, new c.a.p0.r0.a.a(i, i2, bVar.f17906b, bVar.a.mTitle, view)));
                }
            }
        }

        /* loaded from: classes5.dex */
        public class b implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c.a.p0.r0.a.b a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ int f31774b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ ItemCardViewWrapperViewHolder f31775c;

            public b(ItemCardViewWrapperViewHolder itemCardViewWrapperViewHolder, c.a.p0.r0.a.b bVar, int i) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {itemCardViewWrapperViewHolder, bVar, Integer.valueOf(i)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f31775c = itemCardViewWrapperViewHolder;
                this.a = bVar;
                this.f31774b = i;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    ItemData itemData = this.a.a;
                    ItemClickJumpUtil.itemClickJump(itemData.forumName, String.valueOf(itemData.itemId), -1, 15);
                    if (3 == this.f31775c.f31771e.j) {
                        int i = this.f31775c.f31771e.j;
                        int i2 = this.f31774b;
                        int z = this.f31775c.a.z(this.a.a);
                        int i3 = this.a.f17906b;
                        ItemCardHelper.f(i, i2, z, 2, this.a.a.mTitle, false);
                    }
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ItemCardViewWrapperViewHolder(ItemCardViewWrapperAdapter itemCardViewWrapperAdapter, View view) {
            super(view);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {itemCardViewWrapperAdapter, view};
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
            this.f31771e = itemCardViewWrapperAdapter;
            ViewGroup viewGroup = (ViewGroup) view;
            this.a = (ItemCardView) viewGroup.getChildAt(0);
            this.f31768b = viewGroup.getChildAt(2);
            this.f31769c = (EMTextView) viewGroup.getChildAt(1);
            this.f31770d = viewGroup.getChildAt(3);
        }

        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.d(this.f31770d).f(R.color.CAM_X0203);
                this.a.G();
                this.a.setBackground(null);
                SkinManager.setBackgroundColor(this.f31768b, R.color.CAM_X0204);
                c d2 = c.d(this.f31769c);
                d2.z(R.dimen.T_X06);
                d2.A(R.string.F_X02);
                d2.v(R.color.CAM_X0105);
                this.f31769c.setBackground(null);
            }
        }

        public void e(c.a.p0.r0.a.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
                if (!bVar.f17908d) {
                    this.f31770d.setVisibility(8);
                } else {
                    this.f31770d.setVisibility(0);
                }
                if (bVar.a == null) {
                    this.f31771e.i = getLayoutPosition();
                    this.a.setVisibility(8);
                    this.f31769c.setVisibility(0);
                    this.f31768b.setVisibility(0);
                    return;
                }
                int layoutPosition = getLayoutPosition();
                if (this.f31771e.i == -1 || layoutPosition <= this.f31771e.i) {
                    layoutPosition++;
                }
                if (this.f31771e.l.getHeaderViewsCount() != 0 && layoutPosition > this.f31771e.i) {
                    layoutPosition--;
                }
                if (layoutPosition == 1 && this.f31771e.l.getHeaderViewsCount() == 0) {
                    this.f31768b.setVisibility(0);
                    ((FrameLayout.LayoutParams) this.a.getLayoutParams()).setMargins(0, n.f(this.f31771e.a, R.dimen.tbds21), 0, 0);
                } else {
                    this.f31768b.setVisibility(8);
                    ((FrameLayout.LayoutParams) this.a.getLayoutParams()).setMargins(0, 0, 0, 0);
                }
                this.f31769c.setVisibility(8);
                this.a.setVisibility(0);
                int i = bVar.f17906b;
                if (i == 1) {
                    this.a.setData(bVar.a, 10, true, this.f31771e.j, layoutPosition);
                } else if (i == 2) {
                    this.a.setData(bVar.a, 10, true, bVar.f17907c, this.f31771e.j, layoutPosition);
                } else {
                    this.a.setData(bVar.a, 10, true, this.f31771e.j, layoutPosition);
                }
                this.a.setOnClickListenerOfRightBtn(new a(this, layoutPosition, bVar));
                this.a.setOnClickListener(new b(this, bVar, layoutPosition));
                if (bVar.a != null) {
                    StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_DOWNLOAD_MANAGER_SHOW);
                    statisticItem.addParam("uid", TbadkCoreApplication.getCurrentAccountId());
                    statisticItem.addParam("obj_locate", this.f31771e.j);
                    statisticItem.addParam("obj_source", this.f31771e.k);
                    statisticItem.addParam("obj_name", bVar.a.itemId);
                    statisticItem.addParam("obj_type", this.a.z(bVar.a));
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
    @Override // c.a.d.o.e.a
    public /* bridge */ /* synthetic */ View S(int i, View view, ViewGroup viewGroup, b bVar, ItemCardViewWrapperViewHolder itemCardViewWrapperViewHolder) {
        g0(i, view, viewGroup, bVar, itemCardViewWrapperViewHolder);
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.o.e.a
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
            itemCardView.setPadding(n.f(this.a, R.dimen.tbds18), n.f(this.a, R.dimen.tbds26), n.f(this.a, R.dimen.tbds4), n.f(this.a, R.dimen.tbds18));
            frameLayout.addView(itemCardView, layoutParams);
            EMTextView eMTextView = new EMTextView(this.a);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
            layoutParams2.setMargins(0, n.f(this.a, R.dimen.tbds21), 0, 0);
            eMTextView.setPadding(n.f(this.a, R.dimen.M_W_X007), n.f(this.a, R.dimen.tbds44), 0, 0);
            eMTextView.setText(R.string.obfuscated_res_0x7f0f0f54);
            frameLayout.addView(eMTextView, layoutParams2);
            frameLayout.addView(new View(this.a), new ViewGroup.LayoutParams(-1, n.f(this.a, R.dimen.tbds21)));
            View view = new View(this.a);
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, n.f(this.a, R.dimen.tbds1));
            layoutParams3.setMargins(n.f(this.a, R.dimen.tbds221), 0, n.f(this.a, R.dimen.M_W_X007), 0);
            layoutParams3.gravity = 80;
            frameLayout.addView(view, layoutParams3);
            return new ItemCardViewWrapperViewHolder(this, frameLayout);
        }
        return (ItemCardViewWrapperViewHolder) invokeL.objValue;
    }

    public View g0(int i, View view, ViewGroup viewGroup, b bVar, ItemCardViewWrapperViewHolder itemCardViewWrapperViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view, viewGroup, bVar, itemCardViewWrapperViewHolder})) == null) {
            if (bVar != null) {
                itemCardViewWrapperViewHolder.e(bVar);
            }
            itemCardViewWrapperViewHolder.d();
            return view;
        }
        return (View) invokeCommon.objValue;
    }
}
