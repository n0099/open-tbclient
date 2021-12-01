package com.baidu.tieba.downloadmanager.ui.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import c.a.d.f.p.l;
import c.a.d.m.e.a;
import c.a.q0.s.u.c;
import c.a.r0.p0.b.b;
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
/* loaded from: classes10.dex */
public class ItemCardViewWrapperAdapter extends a<b, ItemCardViewWrapperViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int m;
    public int n;
    public int o;
    public BdTypeRecyclerView p;

    /* loaded from: classes10.dex */
    public class ItemCardViewWrapperViewHolder extends TypeAdapter.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ItemCardView a;

        /* renamed from: b  reason: collision with root package name */
        public View f43409b;

        /* renamed from: c  reason: collision with root package name */
        public EMTextView f43410c;

        /* renamed from: d  reason: collision with root package name */
        public View f43411d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ItemCardViewWrapperAdapter f43412e;

        /* loaded from: classes10.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f43413e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ c.a.r0.p0.b.b f43414f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ ItemCardViewWrapperViewHolder f43415g;

            public a(ItemCardViewWrapperViewHolder itemCardViewWrapperViewHolder, int i2, c.a.r0.p0.b.b bVar) {
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
                this.f43415g = itemCardViewWrapperViewHolder;
                this.f43413e = i2;
                this.f43414f = bVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    int i2 = this.f43415g.f43412e.n;
                    int i3 = this.f43413e;
                    c.a.r0.p0.b.b bVar = this.f43414f;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001440, new c.a.r0.p0.b.a(i2, i3, bVar.f21007f, bVar.f21006e.mTitle, view)));
                }
            }
        }

        /* loaded from: classes10.dex */
        public class b implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.r0.p0.b.b f43416e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ int f43417f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ ItemCardViewWrapperViewHolder f43418g;

            public b(ItemCardViewWrapperViewHolder itemCardViewWrapperViewHolder, c.a.r0.p0.b.b bVar, int i2) {
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
                this.f43418g = itemCardViewWrapperViewHolder;
                this.f43416e = bVar;
                this.f43417f = i2;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    ItemData itemData = this.f43416e.f21006e;
                    ItemClickJumpUtil.itemClickJump(itemData.forumName, String.valueOf(itemData.itemId), -1, 15);
                    if (3 == this.f43418g.f43412e.n) {
                        int i2 = this.f43418g.f43412e.n;
                        int i3 = this.f43417f;
                        int buttonState = this.f43418g.a.getButtonState(this.f43416e.f21006e);
                        int i4 = this.f43416e.f21007f;
                        ItemCardHelper.f(i2, i3, buttonState, 2, this.f43416e.f21006e.mTitle, false);
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
            this.f43412e = itemCardViewWrapperAdapter;
            ViewGroup viewGroup = (ViewGroup) view;
            this.a = (ItemCardView) viewGroup.getChildAt(0);
            this.f43409b = viewGroup.getChildAt(2);
            this.f43410c = (EMTextView) viewGroup.getChildAt(1);
            this.f43411d = viewGroup.getChildAt(3);
        }

        public void onChangeSkinType() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.d(this.f43411d).f(R.color.CAM_X0203);
                this.a.onChangeSkinType();
                this.a.setBackground(null);
                SkinManager.setBackgroundColor(this.f43409b, R.color.CAM_X0204);
                c d2 = c.d(this.f43410c);
                d2.z(R.dimen.T_X06);
                d2.A(R.string.F_X02);
                d2.v(R.color.CAM_X0105);
                this.f43410c.setBackground(null);
            }
        }

        public void setData(c.a.r0.p0.b.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
                if (!bVar.f21009h) {
                    this.f43411d.setVisibility(8);
                } else {
                    this.f43411d.setVisibility(0);
                }
                if (bVar.f21006e == null) {
                    this.f43412e.m = getLayoutPosition();
                    this.a.setVisibility(8);
                    this.f43410c.setVisibility(0);
                    this.f43409b.setVisibility(0);
                    return;
                }
                int layoutPosition = getLayoutPosition();
                if (this.f43412e.m == -1 || layoutPosition <= this.f43412e.m) {
                    layoutPosition++;
                }
                if (this.f43412e.p.getHeaderViewsCount() != 0 && layoutPosition > this.f43412e.m) {
                    layoutPosition--;
                }
                if (layoutPosition == 1 && this.f43412e.p.getHeaderViewsCount() == 0) {
                    this.f43409b.setVisibility(0);
                    ((FrameLayout.LayoutParams) this.a.getLayoutParams()).setMargins(0, l.f(this.f43412e.f2907e, R.dimen.tbds21), 0, 0);
                } else {
                    this.f43409b.setVisibility(8);
                    ((FrameLayout.LayoutParams) this.a.getLayoutParams()).setMargins(0, 0, 0, 0);
                }
                this.f43410c.setVisibility(8);
                this.a.setVisibility(0);
                int i2 = bVar.f21007f;
                if (i2 == 1) {
                    this.a.setData(bVar.f21006e, 10, true, this.f43412e.n, layoutPosition);
                } else if (i2 == 2) {
                    this.a.setData(bVar.f21006e, 10, true, bVar.f21008g, this.f43412e.n, layoutPosition);
                } else {
                    this.a.setData(bVar.f21006e, 10, true, this.f43412e.n, layoutPosition);
                }
                this.a.setOnClickListenerOfRightBtn(new a(this, layoutPosition, bVar));
                this.a.setOnClickListener(new b(this, bVar, layoutPosition));
                if (bVar.f21006e != null) {
                    StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_DOWNLOAD_MANAGER_SHOW);
                    statisticItem.addParam("uid", TbadkCoreApplication.getCurrentAccountId());
                    statisticItem.addParam("obj_locate", this.f43412e.n);
                    statisticItem.addParam("obj_source", this.f43412e.o);
                    statisticItem.addParam("obj_name", bVar.f21006e.itemId);
                    statisticItem.addParam("obj_type", this.a.getButtonState(bVar.f21006e));
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
    @Override // c.a.d.m.e.a
    public /* bridge */ /* synthetic */ View Z(int i2, View view, ViewGroup viewGroup, b bVar, ItemCardViewWrapperViewHolder itemCardViewWrapperViewHolder) {
        n0(i2, view, viewGroup, bVar, itemCardViewWrapperViewHolder);
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.m.e.a
    /* renamed from: m0 */
    public ItemCardViewWrapperViewHolder S(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            FrameLayout frameLayout = new FrameLayout(this.f2907e);
            frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
            ItemCardView itemCardView = new ItemCardView(this.f2907e);
            itemCardView.setIsShowRightBtn(true);
            itemCardView.setRadius(0);
            itemCardView.setItemImageViewRadius(R.string.J_X05);
            itemCardView.setFirstLineTextColor(R.color.CAM_X0105);
            itemCardView.setPosition(7);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            itemCardView.setPadding(l.f(this.f2907e, R.dimen.tbds18), l.f(this.f2907e, R.dimen.tbds26), l.f(this.f2907e, R.dimen.tbds4), l.f(this.f2907e, R.dimen.tbds18));
            frameLayout.addView(itemCardView, layoutParams);
            EMTextView eMTextView = new EMTextView(this.f2907e);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
            layoutParams2.setMargins(0, l.f(this.f2907e, R.dimen.tbds21), 0, 0);
            eMTextView.setPadding(l.f(this.f2907e, R.dimen.M_W_X007), l.f(this.f2907e, R.dimen.tbds44), 0, 0);
            eMTextView.setText(R.string.recommend_list_title);
            frameLayout.addView(eMTextView, layoutParams2);
            frameLayout.addView(new View(this.f2907e), new ViewGroup.LayoutParams(-1, l.f(this.f2907e, R.dimen.tbds21)));
            View view = new View(this.f2907e);
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, l.f(this.f2907e, R.dimen.tbds1));
            layoutParams3.setMargins(l.f(this.f2907e, R.dimen.tbds221), 0, l.f(this.f2907e, R.dimen.M_W_X007), 0);
            layoutParams3.gravity = 80;
            frameLayout.addView(view, layoutParams3);
            return new ItemCardViewWrapperViewHolder(this, frameLayout);
        }
        return (ItemCardViewWrapperViewHolder) invokeL.objValue;
    }

    public View n0(int i2, View view, ViewGroup viewGroup, b bVar, ItemCardViewWrapperViewHolder itemCardViewWrapperViewHolder) {
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
