package com.baidu.tieba.frs.itemtab.card;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import b.a.e.f.p.l;
import b.a.l.q;
import b.a.r0.m3.j0.n;
import b.a.r0.x0.c1;
import b.a.r0.x0.d1;
import b.a.r0.x0.e1;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import tbclient.ItemInfo;
import tbclient.TagInfo;
/* loaded from: classes9.dex */
public class CardItemInfoTagLayout extends FrameLayout implements q {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public BdRecyclerView f49700e;

    /* renamed from: f  reason: collision with root package name */
    public b f49701f;

    /* renamed from: g  reason: collision with root package name */
    public View f49702g;

    /* renamed from: h  reason: collision with root package name */
    public final Point f49703h;

    /* renamed from: i  reason: collision with root package name */
    public List<TagInfo> f49704i;
    public ItemInfo j;

    /* loaded from: classes9.dex */
    public class a extends RecyclerView.ItemDecoration {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CardItemInfoTagLayout f49705a;

        public a(CardItemInfoTagLayout cardItemInfoTagLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cardItemInfoTagLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49705a = cardItemInfoTagLayout;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(@NonNull Rect rect, int i2, @NonNull RecyclerView recyclerView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, rect, i2, recyclerView) == null) {
                if (i2 != 0) {
                    if (i2 == this.f49705a.f49704i.size() - 1) {
                        rect.set(0, 0, l.g(TbadkCoreApplication.getInst().getContext(), d1.M_W_X005), 0);
                        return;
                    } else {
                        rect.set(0, 0, l.g(TbadkCoreApplication.getInst().getContext(), d1.M_W_X006), 0);
                        return;
                    }
                }
                rect.set(l.g(TbadkCoreApplication.getInst().getContext(), d1.M_W_X005), 0, l.g(TbadkCoreApplication.getInst().getContext(), d1.M_W_X006), 0);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b extends RecyclerView.Adapter<a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CardItemInfoTagLayout f49706a;

        /* loaded from: classes9.dex */
        public class a extends RecyclerView.ViewHolder {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final TBSpecificationBtn f49707a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ b f49708b;

            /* renamed from: com.baidu.tieba.frs.itemtab.card.CardItemInfoTagLayout$b$a$a  reason: collision with other inner class name */
            /* loaded from: classes9.dex */
            public class View$OnClickListenerC1761a implements View.OnClickListener {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ View f49709e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ a f49710f;

                public View$OnClickListenerC1761a(a aVar, b bVar, View view) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {aVar, bVar, view};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f49710f = aVar;
                    this.f49709e = view;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                        Integer valueOf = Integer.valueOf(this.f49710f.f49708b.f49706a.f49700e.getChildLayoutPosition(this.f49709e) + 1);
                        if (view instanceof TBSpecificationBtn) {
                            TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) view;
                            if (tBSpecificationBtn.btnState instanceof HashMap) {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new n(TbadkApplication.getInst().getApplicationContext(), "CatetoryRecommendList", (HashMap) tBSpecificationBtn.btnState)));
                                if (valueOf instanceof Integer) {
                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921573, new b.a.q0.s.g0.p.b(2, valueOf.intValue())));
                                }
                            }
                        }
                    }
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(@NonNull b bVar, View view) {
                super(view);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, view};
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
                this.f49708b = bVar;
                FrameLayout frameLayout = (FrameLayout) view;
                b.a.q0.s.g0.n.b bVar2 = new b.a.q0.s.g0.n.b();
                bVar2.i(0, e1.icon_pure_arrow12_right, TBSpecificationButtonConfig.IconType.WEBP);
                bVar2.h(c1.CAM_X0107);
                bVar2.g(l.g(TbadkCoreApplication.getInst().getContext(), d1.tbds31));
                bVar2.f(0);
                bVar2.s(c1.CAM_X0105);
                bVar2.j(1, 0);
                bVar2.n(l.g(TbadkCoreApplication.getInst().getContext(), d1.M_H_X003));
                bVar2.m(l.g(TbadkCoreApplication.getInst().getContext(), d1.M_W_X006), l.g(TbadkCoreApplication.getInst().getContext(), d1.tbds24));
                TBSpecificationBtn tBSpecificationBtn = new TBSpecificationBtn(view.getContext());
                this.f49707a = tBSpecificationBtn;
                tBSpecificationBtn.setConfig(bVar2);
                if (this.f49707a.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                    ((ViewGroup.MarginLayoutParams) this.f49707a.getLayoutParams()).rightMargin = TbadkApplication.getInst().getResources().getDimensionPixelSize(d1.M_W_X006);
                }
                this.f49707a.setOnClickListener(new View$OnClickListenerC1761a(this, bVar, view));
                frameLayout.addView(this.f49707a);
            }

            public void a(TagInfo tagInfo) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, tagInfo) == null) || tagInfo == null || this.f49708b.f49706a.j == null) {
                    return;
                }
                HashMap hashMap = new HashMap();
                hashMap.put("tab_id", String.valueOf(tagInfo.tab_id));
                hashMap.put("tab_name", tagInfo.tag_name);
                hashMap.put("rank_type", String.valueOf(tagInfo.rank_type));
                hashMap.put("class_id", String.valueOf(tagInfo.class_id));
                hashMap.put("home_tab_name", this.f49708b.f49706a.j.template_name);
                this.f49707a.setText(tagInfo.tag_name);
                TBSpecificationBtn tBSpecificationBtn = this.f49707a;
                tBSpecificationBtn.btnState = hashMap;
                tBSpecificationBtn.changeSkinType();
                this.f49707a.requestLayout();
            }
        }

        public b(CardItemInfoTagLayout cardItemInfoTagLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cardItemInfoTagLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49706a = cardItemInfoTagLayout;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: a */
        public void onBindViewHolder(@NonNull a aVar, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(1048576, this, aVar, i2) == null) || ListUtils.getItem(this.f49706a.f49704i, i2) == null) {
                return;
            }
            aVar.a((TagInfo) ListUtils.getItem(this.f49706a.f49704i, i2));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NonNull
        /* renamed from: c */
        public a onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup, i2)) == null) ? new a(this, new FrameLayout(viewGroup.getContext())) : (a) invokeLI.objValue;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                if (this.f49706a.f49704i == null) {
                    return 0;
                }
                return this.f49706a.f49704i.size();
            }
            return invokeV.intValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardItemInfoTagLayout(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f49703h = new Point();
        this.f49704i = new ArrayList();
        d();
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
            setPadding(0, l.g(TbadkCoreApplication.getInst().getContext(), d1.M_H_X004), 0, 0);
            BdRecyclerView bdRecyclerView = new BdRecyclerView(getContext());
            this.f49700e = bdRecyclerView;
            bdRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
            this.f49700e.addItemDecoration(new a(this));
            this.f49700e.setNestedScrollingEnabled(false);
            addView(this.f49700e, new FrameLayout.LayoutParams(-1, -2));
            this.f49702g = new View(getContext());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(l.g(TbadkCoreApplication.getInst().getContext(), d1.tbds52), -1);
            layoutParams.gravity = 5;
            this.f49702g.setLayoutParams(layoutParams);
            addView(this.f49702g);
            b bVar = new b(this);
            this.f49701f = bVar;
            this.f49700e.setAdapter(bVar);
        }
    }

    @Override // b.a.l.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext, i2) == null) {
            SkinManager.setBackgroundColor(this, c1.CAM_X0205);
            SkinManager.setBackgroundColor(this.f49700e, c1.CAM_X0205);
            SkinManager.setBackgroundResource(this.f49702g, e1.bg_gradient_card_item_info_tag);
            this.f49701f.notifyDataSetChanged();
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, motionEvent)) == null) {
            if (motionEvent != null) {
                if (motionEvent.getAction() == 0) {
                    this.f49703h.set((int) motionEvent.getX(), (int) motionEvent.getY());
                    if (this.f49700e.getFirstCompletelyVisiblePosition() != 0 && (getContext() instanceof BaseFragmentActivity) && ((BaseFragmentActivity) getContext()).isSwipeBackEnabled()) {
                        ((BaseFragmentActivity) getContext()).disableSwipeJustOnce();
                    }
                } else {
                    boolean z = false;
                    if (motionEvent.getAction() == 2) {
                        boolean z2 = (getContext() instanceof BaseFragmentActivity) && ((BaseFragmentActivity) getContext()).isSwipeBackEnabled();
                        ViewParent parent = getParent();
                        if (!z2 && Math.abs(this.f49703h.x - motionEvent.getX()) > Math.abs(this.f49703h.y - motionEvent.getY())) {
                            z = true;
                        }
                        parent.requestDisallowInterceptTouchEvent(z);
                    } else {
                        getParent().requestDisallowInterceptTouchEvent(false);
                    }
                }
            }
            return super.onInterceptTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    public void setData(ItemInfo itemInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, itemInfo) == null) || itemInfo == null || ListUtils.isEmpty(itemInfo.tag_info)) {
            return;
        }
        this.j = itemInfo;
        this.f49704i = itemInfo.tag_info;
        this.f49701f.notifyDataSetChanged();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardItemInfoTagLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f49703h = new Point();
        this.f49704i = new ArrayList();
        d();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardItemInfoTagLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f49703h = new Point();
        this.f49704i = new ArrayList();
        d();
    }
}
