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
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig;
import com.baidu.tieba.R;
import com.baidu.tieba.ii;
import com.baidu.tieba.ix;
import com.baidu.tieba.n55;
import com.baidu.tieba.tbadkCore.data.FlutterOpenData;
import com.baidu.tieba.v55;
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
/* loaded from: classes4.dex */
public class CardItemInfoTagLayout extends FrameLayout implements ix {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdRecyclerView a;
    public b b;
    public View c;
    public final Point d;
    public List<TagInfo> e;
    public ItemInfo f;

    /* loaded from: classes4.dex */
    public class b extends RecyclerView.Adapter<a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CardItemInfoTagLayout a;

        /* loaded from: classes4.dex */
        public class a extends RecyclerView.ViewHolder {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final TBSpecificationBtn a;
            public final /* synthetic */ b b;

            /* renamed from: com.baidu.tieba.frs.itemtab.card.CardItemInfoTagLayout$b$a$a  reason: collision with other inner class name */
            /* loaded from: classes4.dex */
            public class View$OnClickListenerC0274a implements View.OnClickListener {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ View a;
                public final /* synthetic */ a b;

                public View$OnClickListenerC0274a(a aVar, b bVar, View view2) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {aVar, bVar, view2};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.b = aVar;
                    this.a = view2;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                        Integer valueOf = Integer.valueOf(this.b.b.a.a.getChildLayoutPosition(this.a) + 1);
                        if (view2 instanceof TBSpecificationBtn) {
                            TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) view2;
                            if (tBSpecificationBtn.a instanceof HashMap) {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new FlutterOpenData(TbadkApplication.getInst().getApplicationContext(), "CatetoryRecommendList", (HashMap) tBSpecificationBtn.a)));
                                if (valueOf instanceof Integer) {
                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921573, new v55(2, valueOf.intValue())));
                                }
                            }
                        }
                    }
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(@NonNull b bVar, View view2) {
                super(view2);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, view2};
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
                this.b = bVar;
                FrameLayout frameLayout = (FrameLayout) view2;
                n55 n55Var = new n55();
                n55Var.i(0, R.drawable.icon_pure_arrow12_right, TBSpecificationButtonConfig.IconType.WEBP);
                n55Var.h(R.color.CAM_X0107);
                n55Var.g(ii.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds31));
                n55Var.f(0);
                n55Var.v(R.color.CAM_X0105);
                n55Var.j(1, 0);
                n55Var.o(ii.g(TbadkCoreApplication.getInst().getContext(), R.dimen.M_H_X003));
                n55Var.n(ii.g(TbadkCoreApplication.getInst().getContext(), R.dimen.M_W_X006), ii.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds24));
                TBSpecificationBtn tBSpecificationBtn = new TBSpecificationBtn(view2.getContext());
                this.a = tBSpecificationBtn;
                tBSpecificationBtn.setConfig(n55Var);
                if (this.a.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                    ((ViewGroup.MarginLayoutParams) this.a.getLayoutParams()).rightMargin = TbadkApplication.getInst().getResources().getDimensionPixelSize(R.dimen.M_W_X006);
                }
                this.a.setOnClickListener(new View$OnClickListenerC0274a(this, bVar, view2));
                frameLayout.addView(this.a);
            }

            public void a(TagInfo tagInfo) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, tagInfo) == null) && tagInfo != null && this.b.a.f != null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(TiebaStatic.Params.TAB_ID, String.valueOf(tagInfo.tab_id));
                    hashMap.put("tab_name", tagInfo.tag_name);
                    hashMap.put("rank_type", String.valueOf(tagInfo.rank_type));
                    hashMap.put("class_id", String.valueOf(tagInfo.class_id));
                    hashMap.put("home_tab_name", this.b.a.f.template_name);
                    this.a.setText(tagInfo.tag_name);
                    TBSpecificationBtn tBSpecificationBtn = this.a;
                    tBSpecificationBtn.a = hashMap;
                    tBSpecificationBtn.k();
                    this.a.requestLayout();
                }
            }
        }

        public b(CardItemInfoTagLayout cardItemInfoTagLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cardItemInfoTagLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cardItemInfoTagLayout;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.a.e == null) {
                    return 0;
                }
                return this.a.e.size();
            }
            return invokeV.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: k */
        public void onBindViewHolder(@NonNull a aVar, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, i) == null) && ListUtils.getItem(this.a.e, i) != null) {
                aVar.a((TagInfo) ListUtils.getItem(this.a.e, i));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NonNull
        /* renamed from: l */
        public a onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, viewGroup, i)) == null) {
                return new a(this, new FrameLayout(viewGroup.getContext()));
            }
            return (a) invokeLI.objValue;
        }
    }

    /* loaded from: classes4.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cardItemInfoTagLayout;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(@NonNull Rect rect, int i, @NonNull RecyclerView recyclerView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, rect, i, recyclerView) == null) {
                if (i == 0) {
                    rect.set(ii.g(TbadkCoreApplication.getInst().getContext(), R.dimen.M_W_X005), 0, ii.g(TbadkCoreApplication.getInst().getContext(), R.dimen.M_W_X006), 0);
                } else if (i == this.a.e.size() - 1) {
                    rect.set(0, 0, ii.g(TbadkCoreApplication.getInst().getContext(), R.dimen.M_W_X005), 0);
                } else {
                    rect.set(0, 0, ii.g(TbadkCoreApplication.getInst().getContext(), R.dimen.M_W_X006), 0);
                }
            }
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = new Point();
        this.e = new ArrayList();
        d();
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.d = new Point();
        this.e = new ArrayList();
        d();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardItemInfoTagLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.d = new Point();
        this.e = new ArrayList();
        d();
    }

    public void setData(ItemInfo itemInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, itemInfo) == null) && itemInfo != null && !ListUtils.isEmpty(itemInfo.tag_info)) {
            this.f = itemInfo;
            this.e = itemInfo.tag_info;
            this.b.notifyDataSetChanged();
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
            setPadding(0, ii.g(TbadkCoreApplication.getInst().getContext(), R.dimen.M_H_X004), 0, 0);
            BdRecyclerView bdRecyclerView = new BdRecyclerView(getContext());
            this.a = bdRecyclerView;
            bdRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
            this.a.addItemDecoration(new a(this));
            this.a.setNestedScrollingEnabled(false);
            addView(this.a, new FrameLayout.LayoutParams(-1, -2));
            this.c = new View(getContext());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(ii.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds52), -1);
            layoutParams.gravity = 5;
            this.c.setLayoutParams(layoutParams);
            addView(this.c);
            b bVar = new b(this);
            this.b = bVar;
            this.a.setAdapter(bVar);
        }
    }

    @Override // com.baidu.tieba.ix
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext, i) == null) {
            SkinManager.setBackgroundColor(this, R.color.CAM_X0205);
            SkinManager.setBackgroundColor(this.a, R.color.CAM_X0205);
            SkinManager.setBackgroundResource(this.c, R.drawable.bg_gradient_card_item_info_tag);
            this.b.notifyDataSetChanged();
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, motionEvent)) == null) {
            if (motionEvent != null) {
                if (motionEvent.getAction() == 0) {
                    this.d.set((int) motionEvent.getX(), (int) motionEvent.getY());
                    if (this.a.getFirstCompletelyVisiblePosition() != 0 && (getContext() instanceof BaseFragmentActivity) && ((BaseFragmentActivity) getContext()).isSwipeBackEnabled()) {
                        ((BaseFragmentActivity) getContext()).disableSwipeJustOnce();
                    }
                } else {
                    boolean z2 = false;
                    if (motionEvent.getAction() == 2) {
                        if ((getContext() instanceof BaseFragmentActivity) && ((BaseFragmentActivity) getContext()).isSwipeBackEnabled()) {
                            z = true;
                        } else {
                            z = false;
                        }
                        ViewParent parent = getParent();
                        if (!z && Math.abs(this.d.x - motionEvent.getX()) > Math.abs(this.d.y - motionEvent.getY())) {
                            z2 = true;
                        }
                        parent.requestDisallowInterceptTouchEvent(z2);
                    } else {
                        getParent().requestDisallowInterceptTouchEvent(false);
                    }
                }
            }
            return super.onInterceptTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }
}
