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
import c.a.d.f.p.n;
import c.a.l.q;
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
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.data.FlutterOpenData;
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
/* loaded from: classes5.dex */
public class CardItemInfoTagLayout extends FrameLayout implements q {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public BdRecyclerView f42245e;

    /* renamed from: f  reason: collision with root package name */
    public b f42246f;

    /* renamed from: g  reason: collision with root package name */
    public View f42247g;

    /* renamed from: h  reason: collision with root package name */
    public final Point f42248h;

    /* renamed from: i  reason: collision with root package name */
    public List<TagInfo> f42249i;

    /* renamed from: j  reason: collision with root package name */
    public ItemInfo f42250j;

    /* loaded from: classes5.dex */
    public class a extends RecyclerView.ItemDecoration {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CardItemInfoTagLayout a;

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
            this.a = cardItemInfoTagLayout;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(@NonNull Rect rect, int i2, @NonNull RecyclerView recyclerView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, rect, i2, recyclerView) == null) {
                if (i2 != 0) {
                    if (i2 == this.a.f42249i.size() - 1) {
                        rect.set(0, 0, n.f(TbadkCoreApplication.getInst().getContext(), R.dimen.M_W_X005), 0);
                        return;
                    } else {
                        rect.set(0, 0, n.f(TbadkCoreApplication.getInst().getContext(), R.dimen.M_W_X006), 0);
                        return;
                    }
                }
                rect.set(n.f(TbadkCoreApplication.getInst().getContext(), R.dimen.M_W_X005), 0, n.f(TbadkCoreApplication.getInst().getContext(), R.dimen.M_W_X006), 0);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends RecyclerView.Adapter<a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CardItemInfoTagLayout a;

        /* loaded from: classes5.dex */
        public class a extends RecyclerView.ViewHolder {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final TBSpecificationBtn a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ b f42251b;

            /* renamed from: com.baidu.tieba.frs.itemtab.card.CardItemInfoTagLayout$b$a$a  reason: collision with other inner class name */
            /* loaded from: classes5.dex */
            public class View$OnClickListenerC1906a implements View.OnClickListener {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ View f42252e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ a f42253f;

                public View$OnClickListenerC1906a(a aVar, b bVar, View view) {
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
                    this.f42253f = aVar;
                    this.f42252e = view;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                        Integer valueOf = Integer.valueOf(this.f42253f.f42251b.a.f42245e.getChildLayoutPosition(this.f42252e) + 1);
                        if (view instanceof TBSpecificationBtn) {
                            TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) view;
                            if (tBSpecificationBtn.btnState instanceof HashMap) {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new FlutterOpenData(TbadkApplication.getInst().getApplicationContext(), "CatetoryRecommendList", (HashMap) tBSpecificationBtn.btnState)));
                                if (valueOf instanceof Integer) {
                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921573, new c.a.q0.r.l0.p.b(2, valueOf.intValue())));
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
                this.f42251b = bVar;
                FrameLayout frameLayout = (FrameLayout) view;
                c.a.q0.r.l0.n.b bVar2 = new c.a.q0.r.l0.n.b();
                bVar2.i(0, R.drawable.icon_pure_arrow12_right, TBSpecificationButtonConfig.IconType.WEBP);
                bVar2.h(R.color.CAM_X0107);
                bVar2.g(n.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds31));
                bVar2.f(0);
                bVar2.t(R.color.CAM_X0105);
                bVar2.j(1, 0);
                bVar2.n(n.f(TbadkCoreApplication.getInst().getContext(), R.dimen.M_H_X003));
                bVar2.m(n.f(TbadkCoreApplication.getInst().getContext(), R.dimen.M_W_X006), n.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds24));
                TBSpecificationBtn tBSpecificationBtn = new TBSpecificationBtn(view.getContext());
                this.a = tBSpecificationBtn;
                tBSpecificationBtn.setConfig(bVar2);
                if (this.a.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                    ((ViewGroup.MarginLayoutParams) this.a.getLayoutParams()).rightMargin = TbadkApplication.getInst().getResources().getDimensionPixelSize(R.dimen.M_W_X006);
                }
                this.a.setOnClickListener(new View$OnClickListenerC1906a(this, bVar, view));
                frameLayout.addView(this.a);
            }

            public void a(TagInfo tagInfo) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, tagInfo) == null) || tagInfo == null || this.f42251b.a.f42250j == null) {
                    return;
                }
                HashMap hashMap = new HashMap();
                hashMap.put("tab_id", String.valueOf(tagInfo.tab_id));
                hashMap.put("tab_name", tagInfo.tag_name);
                hashMap.put("rank_type", String.valueOf(tagInfo.rank_type));
                hashMap.put("class_id", String.valueOf(tagInfo.class_id));
                hashMap.put("home_tab_name", this.f42251b.a.f42250j.template_name);
                this.a.setText(tagInfo.tag_name);
                TBSpecificationBtn tBSpecificationBtn = this.a;
                tBSpecificationBtn.btnState = hashMap;
                tBSpecificationBtn.changeSkinType();
                this.a.requestLayout();
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
            this.a = cardItemInfoTagLayout;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: a */
        public void onBindViewHolder(@NonNull a aVar, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(1048576, this, aVar, i2) == null) || ListUtils.getItem(this.a.f42249i, i2) == null) {
                return;
            }
            aVar.a((TagInfo) ListUtils.getItem(this.a.f42249i, i2));
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
                if (this.a.f42249i == null) {
                    return 0;
                }
                return this.a.f42249i.size();
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
        this.f42248h = new Point();
        this.f42249i = new ArrayList();
        d();
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
            setPadding(0, n.f(TbadkCoreApplication.getInst().getContext(), R.dimen.M_H_X004), 0, 0);
            BdRecyclerView bdRecyclerView = new BdRecyclerView(getContext());
            this.f42245e = bdRecyclerView;
            bdRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
            this.f42245e.addItemDecoration(new a(this));
            this.f42245e.setNestedScrollingEnabled(false);
            addView(this.f42245e, new FrameLayout.LayoutParams(-1, -2));
            this.f42247g = new View(getContext());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(n.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds52), -1);
            layoutParams.gravity = 5;
            this.f42247g.setLayoutParams(layoutParams);
            addView(this.f42247g);
            b bVar = new b(this);
            this.f42246f = bVar;
            this.f42245e.setAdapter(bVar);
        }
    }

    @Override // c.a.l.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext, i2) == null) {
            SkinManager.setBackgroundColor(this, R.color.CAM_X0205);
            SkinManager.setBackgroundColor(this.f42245e, R.color.CAM_X0205);
            SkinManager.setBackgroundResource(this.f42247g, R.drawable.bg_gradient_card_item_info_tag);
            this.f42246f.notifyDataSetChanged();
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, motionEvent)) == null) {
            if (motionEvent != null) {
                if (motionEvent.getAction() == 0) {
                    this.f42248h.set((int) motionEvent.getX(), (int) motionEvent.getY());
                    if (this.f42245e.getFirstCompletelyVisiblePosition() != 0 && (getContext() instanceof BaseFragmentActivity) && ((BaseFragmentActivity) getContext()).isSwipeBackEnabled()) {
                        ((BaseFragmentActivity) getContext()).disableSwipeJustOnce();
                    }
                } else {
                    boolean z = false;
                    if (motionEvent.getAction() == 2) {
                        boolean z2 = (getContext() instanceof BaseFragmentActivity) && ((BaseFragmentActivity) getContext()).isSwipeBackEnabled();
                        ViewParent parent = getParent();
                        if (!z2 && Math.abs(this.f42248h.x - motionEvent.getX()) > Math.abs(this.f42248h.y - motionEvent.getY())) {
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
        this.f42250j = itemInfo;
        this.f42249i = itemInfo.tag_info;
        this.f42246f.notifyDataSetChanged();
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
        this.f42248h = new Point();
        this.f42249i = new ArrayList();
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
        this.f42248h = new Point();
        this.f42249i = new ArrayList();
        d();
    }
}
