package com.baidu.tieba.frs.itemtab.card;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import c.a.e.a.j;
import c.a.e.e.p.l;
import c.a.l.q;
import c.a.r0.x0.b2.g.e;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.ItemClickJumpUtil;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import tbclient.ItemInfo;
import tbclient.ItemPoint;
import tbclient.ItemTable;
/* loaded from: classes7.dex */
public class CardItemRecommendLayout extends LinearLayout implements q {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public EMTextView f51528e;

    /* renamed from: f  reason: collision with root package name */
    public BdRecyclerView f51529f;

    /* renamed from: g  reason: collision with root package name */
    public c f51530g;

    /* renamed from: h  reason: collision with root package name */
    public List<ItemInfo> f51531h;

    /* renamed from: i  reason: collision with root package name */
    public final Point f51532i;

    /* loaded from: classes7.dex */
    public class a extends RecyclerView.ItemDecoration {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CardItemRecommendLayout f51533a;

        public a(CardItemRecommendLayout cardItemRecommendLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cardItemRecommendLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51533a = cardItemRecommendLayout;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(@NonNull Rect rect, int i2, @NonNull RecyclerView recyclerView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, rect, i2, recyclerView) == null) {
                rect.set(0, 0, l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.M_W_X006), 0);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements BdRecyclerView.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CardItemRecommendLayout f51534e;

        public b(CardItemRecommendLayout cardItemRecommendLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cardItemRecommendLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51534e = cardItemRecommendLayout;
        }

        @Override // com.baidu.adp.widget.ListView.BdRecyclerView.i
        public void b(ViewGroup viewGroup, View view, Object obj, int i2, long j2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{viewGroup, view, obj, Integer.valueOf(i2), Long.valueOf(j2)}) == null) || ListUtils.getItem(this.f51534e.f51531h, i2) == null) {
                return;
            }
            ItemClickJumpUtil.itemClickJump(((ItemInfo) ListUtils.getItem(this.f51534e.f51531h, i2)).forum_name, String.valueOf(((ItemInfo) ListUtils.getItem(this.f51534e.f51531h, i2)).id), 0);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921573, new c.a.q0.s.f0.p.b(3, i2 + 1, 2)));
        }
    }

    /* loaded from: classes7.dex */
    public class c extends RecyclerView.Adapter<d> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CardItemRecommendLayout f51535a;

        public c(CardItemRecommendLayout cardItemRecommendLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cardItemRecommendLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51535a = cardItemRecommendLayout;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: a */
        public void onBindViewHolder(@NonNull d dVar, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(1048576, this, dVar, i2) == null) || ListUtils.getItem(this.f51535a.f51531h, i2) == null) {
                return;
            }
            dVar.b((ItemInfo) ListUtils.getItem(this.f51535a.f51531h, i2));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921573, new c.a.q0.s.f0.p.b(3, i2 + 1, 1)));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NonNull
        /* renamed from: c */
        public d onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup, i2)) == null) {
                d dVar = new d(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.frs_item_recommend_view, (ViewGroup) null));
                dVar.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                return dVar;
            }
            return (d) invokeLI.objValue;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                if (this.f51535a.f51531h == null) {
                    return 0;
                }
                return this.f51535a.f51531h.size();
            }
            return invokeV.intValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class d extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final BarImageView f51536a;

        /* renamed from: b  reason: collision with root package name */
        public final EMTextView f51537b;

        /* renamed from: c  reason: collision with root package name */
        public final ImageView f51538c;

        /* renamed from: d  reason: collision with root package name */
        public final TextView f51539d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f51540e;

        /* renamed from: f  reason: collision with root package name */
        public ItemInfo f51541f;

        /* loaded from: classes7.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d f51542e;

            public a(d dVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f51542e = dVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f51542e.f51541f == null) {
                    return;
                }
                ItemClickJumpUtil.itemClickJump(this.f51542e.f51541f.forum_name, String.valueOf(this.f51542e.f51541f.id), 0);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(@NonNull View view) {
            super(view);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view};
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
            BarImageView barImageView = (BarImageView) view.findViewById(R.id.frs_item_recommend_image);
            this.f51536a = barImageView;
            barImageView.setConrers(15);
            this.f51536a.setRadiusById(R.string.J_X05);
            this.f51536a.setDrawCorner(true);
            this.f51536a.setShowOuterBorder(true);
            this.f51536a.setPlaceHolder(3);
            this.f51536a.setPageId(j.a(view.getContext()).getUniqueId());
            this.f51537b = (EMTextView) view.findViewById(R.id.frs_item_recommend_name);
            this.f51538c = (ImageView) view.findViewById(R.id.frs_item_recommend_star);
            this.f51539d = (TextView) view.findViewById(R.id.frs_item_recommend_score);
            this.itemView.setOnClickListener(new a(this));
        }

        public void b(ItemInfo itemInfo) {
            double d2;
            List<ItemPoint> list;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, itemInfo) == null) || itemInfo == null) {
                return;
            }
            this.f51541f = itemInfo;
            this.f51536a.startLoad(itemInfo.icon_url, 10, false);
            if (StringHelper.getChineseAndEnglishLength(itemInfo.name) <= 10) {
                this.f51537b.setText(itemInfo.name);
            } else {
                this.f51537b.setText(StringHelper.cutChineseAndEnglishWithSuffix(itemInfo.name, 8, "..."));
            }
            ItemTable itemTable = itemInfo.score;
            if (itemTable != null && (list = itemTable.item_point) != null) {
                for (ItemPoint itemPoint : list) {
                    if (itemPoint != null && "all".equals(itemPoint.time_intval)) {
                        d2 = itemPoint.point.doubleValue();
                        break;
                    }
                }
            }
            d2 = 0.0d;
            if (d2 > 0.0d && d2 <= 10.0d) {
                this.f51538c.setVisibility(0);
                this.f51539d.setText(String.valueOf(d2));
                this.f51540e = true;
            } else {
                this.f51539d.setText(R.string.frs_evaluate_exception);
                this.f51538c.setVisibility(8);
                this.f51540e = false;
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }

        public void onChangeSkinType(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                WebPManager.setPureDrawable(this.f51538c, R.drawable.icon_pure_star_16, R.color.CAM_X0305, null);
                c.a.q0.s.u.c.d(this.f51537b).v(R.color.CAM_X0105);
                SkinManager.setViewTextColor(this.f51539d, this.f51540e ? R.color.CAM_X0305 : R.color.CAM_X0109);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardItemRecommendLayout(Context context) {
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
        this.f51532i = new Point();
        b();
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            setOrientation(1);
            EMTextView eMTextView = new EMTextView(getContext());
            this.f51528e = eMTextView;
            eMTextView.setGravity(16);
            this.f51528e.setText(R.string.frs_item_tab_recommend_title);
            c.a.q0.s.u.c d2 = c.a.q0.s.u.c.d(this.f51528e);
            d2.A(R.string.F_X02);
            d2.z(R.dimen.T_X07);
            this.f51528e.setPadding(l.g(getContext(), R.dimen.M_W_X005), l.g(getContext(), R.dimen.M_H_X004), l.g(getContext(), R.dimen.M_W_X005), l.g(getContext(), R.dimen.M_H_X008));
            addView(this.f51528e, new LinearLayout.LayoutParams(-1, -2));
            BdRecyclerView bdRecyclerView = new BdRecyclerView(getContext());
            this.f51529f = bdRecyclerView;
            bdRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
            this.f51529f.setPadding(l.g(getContext(), R.dimen.M_W_X004), 0, l.g(getContext(), R.dimen.M_W_X005), 0);
            this.f51529f.addItemDecoration(new a(this));
            this.f51529f.setOnItemClickListener(new b(this));
            addView(this.f51529f, new LinearLayout.LayoutParams(-1, -2));
            c cVar = new c(this);
            this.f51530g = cVar;
            this.f51529f.setAdapter(cVar);
        }
    }

    @Override // c.a.l.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext, i2) == null) {
            this.f51530g.notifyDataSetChanged();
            c.a.q0.s.u.c.d(this.f51528e).v(R.color.CAM_X0105);
            c.a.q0.s.u.c d2 = c.a.q0.s.u.c.d(this);
            d2.n(R.string.J_X06);
            d2.f(R.color.CAM_X0205);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, motionEvent)) == null) {
            if (motionEvent != null) {
                if (motionEvent.getAction() == 0) {
                    this.f51532i.set((int) motionEvent.getX(), (int) motionEvent.getY());
                    if (this.f51529f.getFirstCompletelyVisiblePosition() != 0 && (getContext() instanceof BaseFragmentActivity) && ((BaseFragmentActivity) getContext()).isSwipeBackEnabled()) {
                        ((BaseFragmentActivity) getContext()).disableSwipeJustOnce();
                    }
                } else {
                    boolean z = false;
                    if (motionEvent.getAction() == 2) {
                        boolean z2 = (getContext() instanceof BaseFragmentActivity) && ((BaseFragmentActivity) getContext()).isSwipeBackEnabled();
                        ViewParent parent = getParent();
                        if (!z2 && Math.abs(this.f51532i.x - motionEvent.getX()) > Math.abs(this.f51532i.y - motionEvent.getY())) {
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

    public void setData(c.a.q0.s.q.a aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) && (aVar instanceof e)) {
            e eVar = (e) aVar;
            if (eVar.g() == null) {
                return;
            }
            this.f51531h = eVar.g();
            this.f51530g.notifyDataSetChanged();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardItemRecommendLayout(Context context, AttributeSet attributeSet) {
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
        this.f51532i = new Point();
        b();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardItemRecommendLayout(Context context, AttributeSet attributeSet, int i2) {
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
        this.f51532i = new Point();
        b();
    }
}
