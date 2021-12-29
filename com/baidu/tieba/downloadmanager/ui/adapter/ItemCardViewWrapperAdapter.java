package com.baidu.tieba.downloadmanager.ui.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import c.a.d.f.p.n;
import c.a.d.n.e.a;
import c.a.s0.s.u.c;
import c.a.t0.p0.b.b;
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
/* loaded from: classes12.dex */
public class ItemCardViewWrapperAdapter extends a<b, ItemCardViewWrapperViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int m;
    public int n;
    public int o;
    public BdTypeRecyclerView p;

    /* loaded from: classes12.dex */
    public class ItemCardViewWrapperViewHolder extends TypeAdapter.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ItemCardView a;

        /* renamed from: b  reason: collision with root package name */
        public View f44087b;

        /* renamed from: c  reason: collision with root package name */
        public EMTextView f44088c;

        /* renamed from: d  reason: collision with root package name */
        public View f44089d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ItemCardViewWrapperAdapter f44090e;

        /* loaded from: classes12.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f44091e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ c.a.t0.p0.b.b f44092f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ ItemCardViewWrapperViewHolder f44093g;

            public a(ItemCardViewWrapperViewHolder itemCardViewWrapperViewHolder, int i2, c.a.t0.p0.b.b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {itemCardViewWrapperViewHolder, Integer.valueOf(i2), bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f44093g = itemCardViewWrapperViewHolder;
                this.f44091e = i2;
                this.f44092f = bVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    int i2 = this.f44093g.f44090e.n;
                    int i3 = this.f44091e;
                    c.a.t0.p0.b.b bVar = this.f44092f;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001440, new c.a.t0.p0.b.a(i2, i3, bVar.f21942f, bVar.f21941e.mTitle, view)));
                }
            }
        }

        /* loaded from: classes12.dex */
        public class b implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.t0.p0.b.b f44094e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ int f44095f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ ItemCardViewWrapperViewHolder f44096g;

            public b(ItemCardViewWrapperViewHolder itemCardViewWrapperViewHolder, c.a.t0.p0.b.b bVar, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {itemCardViewWrapperViewHolder, bVar, Integer.valueOf(i2)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f44096g = itemCardViewWrapperViewHolder;
                this.f44094e = bVar;
                this.f44095f = i2;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    ItemData itemData = this.f44094e.f21941e;
                    ItemClickJumpUtil.itemClickJump(itemData.forumName, String.valueOf(itemData.itemId), -1, 15);
                    if (3 == this.f44096g.f44090e.n) {
                        int i2 = this.f44096g.f44090e.n;
                        int i3 = this.f44095f;
                        int buttonState = this.f44096g.a.getButtonState(this.f44094e.f21941e);
                        int i4 = this.f44094e.f21942f;
                        ItemCardHelper.f(i2, i3, buttonState, 2, this.f44094e.f21941e.mTitle, false);
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((View) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f44090e = itemCardViewWrapperAdapter;
            ViewGroup viewGroup = (ViewGroup) view;
            this.a = (ItemCardView) viewGroup.getChildAt(0);
            this.f44087b = viewGroup.getChildAt(2);
            this.f44088c = (EMTextView) viewGroup.getChildAt(1);
            this.f44089d = viewGroup.getChildAt(3);
        }

        public void onChangeSkinType() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.d(this.f44089d).f(R.color.CAM_X0203);
                this.a.onChangeSkinType();
                this.a.setBackground(null);
                SkinManager.setBackgroundColor(this.f44087b, R.color.CAM_X0204);
                c d2 = c.d(this.f44088c);
                d2.z(R.dimen.T_X06);
                d2.A(R.string.F_X02);
                d2.v(R.color.CAM_X0105);
                this.f44088c.setBackground(null);
            }
        }

        public void setData(c.a.t0.p0.b.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
                if (!bVar.f21944h) {
                    this.f44089d.setVisibility(8);
                } else {
                    this.f44089d.setVisibility(0);
                }
                if (bVar.f21941e == null) {
                    this.f44090e.m = getLayoutPosition();
                    this.a.setVisibility(8);
                    this.f44088c.setVisibility(0);
                    this.f44087b.setVisibility(0);
                    return;
                }
                int layoutPosition = getLayoutPosition();
                if (this.f44090e.m == -1 || layoutPosition <= this.f44090e.m) {
                    layoutPosition++;
                }
                if (this.f44090e.p.getHeaderViewsCount() != 0 && layoutPosition > this.f44090e.m) {
                    layoutPosition--;
                }
                if (layoutPosition == 1 && this.f44090e.p.getHeaderViewsCount() == 0) {
                    this.f44087b.setVisibility(0);
                    ((FrameLayout.LayoutParams) this.a.getLayoutParams()).setMargins(0, n.f(this.f44090e.f3299e, R.dimen.tbds21), 0, 0);
                } else {
                    this.f44087b.setVisibility(8);
                    ((FrameLayout.LayoutParams) this.a.getLayoutParams()).setMargins(0, 0, 0, 0);
                }
                this.f44088c.setVisibility(8);
                this.a.setVisibility(0);
                int i2 = bVar.f21942f;
                if (i2 == 1) {
                    this.a.setData(bVar.f21941e, 10, true, this.f44090e.n, layoutPosition);
                } else if (i2 == 2) {
                    this.a.setData(bVar.f21941e, 10, true, bVar.f21943g, this.f44090e.n, layoutPosition);
                } else {
                    this.a.setData(bVar.f21941e, 10, true, this.f44090e.n, layoutPosition);
                }
                this.a.setOnClickListenerOfRightBtn(new a(this, layoutPosition, bVar));
                this.a.setOnClickListener(new b(this, bVar, layoutPosition));
                if (bVar.f21941e != null) {
                    StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_DOWNLOAD_MANAGER_SHOW);
                    statisticItem.addParam("uid", TbadkCoreApplication.getCurrentAccountId());
                    statisticItem.addParam("obj_locate", this.f44090e.n);
                    statisticItem.addParam("obj_source", this.f44090e.o);
                    statisticItem.addParam("obj_name", bVar.f21941e.itemId);
                    statisticItem.addParam("obj_type", this.a.getButtonState(bVar.f21941e));
                    TiebaStatic.log(statisticItem);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ItemCardViewWrapperAdapter(Context context, BdUniqueId bdUniqueId, int i2, BdTypeRecyclerView bdTypeRecyclerView, int i3) {
        super(context, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, bdUniqueId, Integer.valueOf(i2), bdTypeRecyclerView, Integer.valueOf(i3)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.m = -1;
        this.n = i2;
        this.o = i3;
        this.p = bdTypeRecyclerView;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // c.a.d.n.e.a
    public /* bridge */ /* synthetic */ View S(int i2, View view, ViewGroup viewGroup, b bVar, ItemCardViewWrapperViewHolder itemCardViewWrapperViewHolder) {
        g0(i2, view, viewGroup, bVar, itemCardViewWrapperViewHolder);
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.n.e.a
    /* renamed from: f0 */
    public ItemCardViewWrapperViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            FrameLayout frameLayout = new FrameLayout(this.f3299e);
            frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
            ItemCardView itemCardView = new ItemCardView(this.f3299e);
            itemCardView.setIsShowRightBtn(true);
            itemCardView.setRadius(0);
            itemCardView.setItemImageViewRadius(R.string.J_X05);
            itemCardView.setFirstLineTextColor(R.color.CAM_X0105);
            itemCardView.setPosition(7);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            itemCardView.setPadding(n.f(this.f3299e, R.dimen.tbds18), n.f(this.f3299e, R.dimen.tbds26), n.f(this.f3299e, R.dimen.tbds4), n.f(this.f3299e, R.dimen.tbds18));
            frameLayout.addView(itemCardView, layoutParams);
            EMTextView eMTextView = new EMTextView(this.f3299e);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
            layoutParams2.setMargins(0, n.f(this.f3299e, R.dimen.tbds21), 0, 0);
            eMTextView.setPadding(n.f(this.f3299e, R.dimen.M_W_X007), n.f(this.f3299e, R.dimen.tbds44), 0, 0);
            eMTextView.setText(R.string.recommend_list_title);
            frameLayout.addView(eMTextView, layoutParams2);
            frameLayout.addView(new View(this.f3299e), new ViewGroup.LayoutParams(-1, n.f(this.f3299e, R.dimen.tbds21)));
            View view = new View(this.f3299e);
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, n.f(this.f3299e, R.dimen.tbds1));
            layoutParams3.setMargins(n.f(this.f3299e, R.dimen.tbds221), 0, n.f(this.f3299e, R.dimen.M_W_X007), 0);
            layoutParams3.gravity = 80;
            frameLayout.addView(view, layoutParams3);
            return new ItemCardViewWrapperViewHolder(this, frameLayout);
        }
        return (ItemCardViewWrapperViewHolder) invokeL.objValue;
    }

    public View g0(int i2, View view, ViewGroup viewGroup, b bVar, ItemCardViewWrapperViewHolder itemCardViewWrapperViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), view, viewGroup, bVar, itemCardViewWrapperViewHolder})) == null) {
            if (bVar != null) {
                itemCardViewWrapperViewHolder.setData(bVar);
            }
            itemCardViewWrapperViewHolder.onChangeSkinType();
            return view;
        }
        return (View) invokeCommon.objValue;
    }
}
