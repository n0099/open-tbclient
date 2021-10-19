package com.baidu.tieba.downloadmanager.ui.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import c.a.e.e.p.l;
import c.a.e.l.e.a;
import c.a.q0.s.u.c;
import c.a.r0.j0.b.b;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.ItemCardView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class ItemCardViewWrapperAdapter extends a<b, ItemCardViewWrapperViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int m;
    public int n;
    public BdTypeRecyclerView o;

    /* loaded from: classes7.dex */
    public class ItemCardViewWrapperViewHolder extends TypeAdapter.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public ItemCardView f50115a;

        /* renamed from: b  reason: collision with root package name */
        public View f50116b;

        /* renamed from: c  reason: collision with root package name */
        public EMTextView f50117c;

        /* renamed from: d  reason: collision with root package name */
        public View f50118d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ItemCardViewWrapperAdapter f50119e;

        /* loaded from: classes7.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f50120e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ b f50121f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ ItemCardViewWrapperViewHolder f50122g;

            public a(ItemCardViewWrapperViewHolder itemCardViewWrapperViewHolder, int i2, b bVar) {
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
                this.f50122g = itemCardViewWrapperViewHolder;
                this.f50120e = i2;
                this.f50121f = bVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    int i2 = this.f50122g.f50119e.n;
                    int i3 = this.f50120e;
                    b bVar = this.f50121f;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001440, new c.a.r0.j0.b.a(i2, i3, bVar.f19310f, bVar.f19309e.mTitle, view)));
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
            this.f50119e = itemCardViewWrapperAdapter;
            ViewGroup viewGroup = (ViewGroup) view;
            this.f50115a = (ItemCardView) viewGroup.getChildAt(0);
            this.f50116b = viewGroup.getChildAt(2);
            this.f50117c = (EMTextView) viewGroup.getChildAt(1);
            this.f50118d = viewGroup.getChildAt(3);
        }

        public void onChangeSkinType() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.d(this.f50118d).f(R.color.CAM_X0203);
                this.f50115a.onChangeSkinType();
                this.f50115a.setBackground(null);
                SkinManager.setBackgroundColor(this.f50116b, R.color.CAM_X0204);
                c d2 = c.d(this.f50117c);
                d2.z(R.dimen.T_X06);
                d2.A(R.string.F_X02);
                d2.v(R.color.CAM_X0105);
                this.f50117c.setBackground(null);
            }
        }

        public void setData(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
                if (!bVar.f19312h) {
                    this.f50118d.setVisibility(8);
                } else {
                    this.f50118d.setVisibility(0);
                }
                if (bVar.f19309e == null) {
                    this.f50119e.m = getLayoutPosition();
                    this.f50115a.setVisibility(8);
                    this.f50117c.setVisibility(0);
                    this.f50116b.setVisibility(0);
                    return;
                }
                int layoutPosition = getLayoutPosition();
                if (this.f50119e.m == -1 || layoutPosition <= this.f50119e.m) {
                    layoutPosition++;
                }
                if (this.f50119e.o.getHeaderViewsCount() != 0 && layoutPosition > this.f50119e.m) {
                    layoutPosition--;
                }
                if (layoutPosition == 1 && this.f50119e.o.getHeaderViewsCount() == 0) {
                    this.f50116b.setVisibility(0);
                    ((FrameLayout.LayoutParams) this.f50115a.getLayoutParams()).setMargins(0, l.g(this.f50119e.f2958e, R.dimen.tbds21), 0, 0);
                } else {
                    this.f50116b.setVisibility(8);
                    ((FrameLayout.LayoutParams) this.f50115a.getLayoutParams()).setMargins(0, 0, 0, 0);
                }
                this.f50117c.setVisibility(8);
                this.f50115a.setVisibility(0);
                int i2 = bVar.f19310f;
                if (i2 == 1) {
                    this.f50115a.setData(bVar.f19309e, 10, true, this.f50119e.n, layoutPosition);
                } else if (i2 == 2) {
                    this.f50115a.setData(bVar.f19309e, 10, true, bVar.f19311g, this.f50119e.n, layoutPosition);
                } else {
                    this.f50115a.setData(bVar.f19309e, 10, true, this.f50119e.n, layoutPosition);
                }
                this.f50115a.setOnClickListenerOfRightBtn(new a(this, layoutPosition, bVar));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ItemCardViewWrapperAdapter(Context context, BdUniqueId bdUniqueId, int i2, BdTypeRecyclerView bdTypeRecyclerView) {
        super(context, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, bdUniqueId, Integer.valueOf(i2), bdTypeRecyclerView};
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
        this.m = -1;
        this.n = i2;
        this.o = bdTypeRecyclerView;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // c.a.e.l.e.a
    public /* bridge */ /* synthetic */ View a0(int i2, View view, ViewGroup viewGroup, b bVar, ItemCardViewWrapperViewHolder itemCardViewWrapperViewHolder) {
        n0(i2, view, viewGroup, bVar, itemCardViewWrapperViewHolder);
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.e.l.e.a
    /* renamed from: m0 */
    public ItemCardViewWrapperViewHolder U(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            FrameLayout frameLayout = new FrameLayout(this.f2958e);
            frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
            ItemCardView itemCardView = new ItemCardView(this.f2958e);
            itemCardView.setIsShowRightBtn(true);
            itemCardView.setRadius(0);
            itemCardView.setItemImageViewRadius(R.string.J_X05);
            itemCardView.setFirstLineTextColor(R.color.CAM_X0105);
            itemCardView.setPosition(7);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            itemCardView.setPadding(l.g(this.f2958e, R.dimen.tbds18), l.g(this.f2958e, R.dimen.tbds26), l.g(this.f2958e, R.dimen.tbds4), l.g(this.f2958e, R.dimen.tbds18));
            frameLayout.addView(itemCardView, layoutParams);
            EMTextView eMTextView = new EMTextView(this.f2958e);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
            layoutParams2.setMargins(0, l.g(this.f2958e, R.dimen.tbds21), 0, 0);
            eMTextView.setPadding(l.g(this.f2958e, R.dimen.M_W_X007), l.g(this.f2958e, R.dimen.tbds44), 0, 0);
            eMTextView.setText(R.string.recommend_list_title);
            frameLayout.addView(eMTextView, layoutParams2);
            frameLayout.addView(new View(this.f2958e), new ViewGroup.LayoutParams(-1, l.g(this.f2958e, R.dimen.tbds21)));
            View view = new View(this.f2958e);
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, l.g(this.f2958e, R.dimen.tbds1));
            layoutParams3.setMargins(l.g(this.f2958e, R.dimen.tbds221), 0, l.g(this.f2958e, R.dimen.M_W_X007), 0);
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
