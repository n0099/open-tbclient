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
import com.repackage.dv4;
import com.repackage.h9;
import com.repackage.hx;
import com.repackage.nn4;
import com.repackage.pi;
import com.repackage.ur4;
import com.repackage.xl6;
import java.util.List;
import tbclient.ItemInfo;
import tbclient.ItemPoint;
import tbclient.ItemTable;
/* loaded from: classes3.dex */
public class CardItemRecommendLayout extends LinearLayout implements hx {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public EMTextView a;
    public BdRecyclerView b;
    public c c;
    public List<ItemInfo> d;
    public final Point e;

    /* loaded from: classes3.dex */
    public class a extends RecyclerView.ItemDecoration {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CardItemRecommendLayout a;

        public a(CardItemRecommendLayout cardItemRecommendLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cardItemRecommendLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cardItemRecommendLayout;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(@NonNull Rect rect, int i, @NonNull RecyclerView recyclerView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, rect, i, recyclerView) == null) {
                rect.set(0, 0, pi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.M_W_X006), 0);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements BdRecyclerView.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CardItemRecommendLayout a;

        public b(CardItemRecommendLayout cardItemRecommendLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cardItemRecommendLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cardItemRecommendLayout;
        }

        @Override // com.baidu.adp.widget.ListView.BdRecyclerView.i
        public void b(ViewGroup viewGroup, View view2, Object obj, int i, long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{viewGroup, view2, obj, Integer.valueOf(i), Long.valueOf(j)}) == null) || ListUtils.getItem(this.a.d, i) == null) {
                return;
            }
            ItemClickJumpUtil.itemClickJump(((ItemInfo) ListUtils.getItem(this.a.d, i)).forum_name, String.valueOf(((ItemInfo) ListUtils.getItem(this.a.d, i)).id), 0);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921573, new dv4(3, i + 1, 2)));
        }
    }

    /* loaded from: classes3.dex */
    public class c extends RecyclerView.Adapter<d> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CardItemRecommendLayout a;

        public c(CardItemRecommendLayout cardItemRecommendLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cardItemRecommendLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cardItemRecommendLayout;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: d */
        public void onBindViewHolder(@NonNull d dVar, int i) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(1048576, this, dVar, i) == null) || ListUtils.getItem(this.a.d, i) == null) {
                return;
            }
            dVar.b((ItemInfo) ListUtils.getItem(this.a.d, i));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921573, new dv4(3, i + 1, 1)));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NonNull
        /* renamed from: e */
        public d onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup, i)) == null) {
                d dVar = new d(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.obfuscated_res_0x7f0d0326, (ViewGroup) null));
                dVar.c(TbadkCoreApplication.getInst().getSkinType());
                return dVar;
            }
            return (d) invokeLI.objValue;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                if (this.a.d == null) {
                    return 0;
                }
                return this.a.d.size();
            }
            return invokeV.intValue;
        }
    }

    /* loaded from: classes3.dex */
    public static class d extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final BarImageView a;
        public final EMTextView b;
        public final ImageView c;
        public final TextView d;
        public boolean e;
        public ItemInfo f;

        /* loaded from: classes3.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ d a;

            public a(d dVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = dVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.f == null) {
                    return;
                }
                ItemClickJumpUtil.itemClickJump(this.a.f.forum_name, String.valueOf(this.a.f.id), 0);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(@NonNull View view2) {
            super(view2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view2};
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
            BarImageView barImageView = (BarImageView) view2.findViewById(R.id.obfuscated_res_0x7f090b2c);
            this.a = barImageView;
            barImageView.setConrers(15);
            this.a.setRadiusById(R.string.J_X05);
            this.a.setDrawCorner(true);
            this.a.setShowOuterBorder(true);
            this.a.setPlaceHolder(3);
            this.a.setPageId(h9.a(view2.getContext()).getUniqueId());
            this.b = (EMTextView) view2.findViewById(R.id.obfuscated_res_0x7f090b2d);
            this.c = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090b2f);
            this.d = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090b2e);
            this.itemView.setOnClickListener(new a(this));
        }

        public void b(ItemInfo itemInfo) {
            double d;
            List<ItemPoint> list;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, itemInfo) == null) || itemInfo == null) {
                return;
            }
            this.f = itemInfo;
            this.a.J(itemInfo.icon_url, 10, false);
            if (StringHelper.getChineseAndEnglishLength(itemInfo.name) <= 10) {
                this.b.setText(itemInfo.name);
            } else {
                this.b.setText(StringHelper.cutChineseAndEnglishWithSuffix(itemInfo.name, 8, StringHelper.STRING_MORE));
            }
            ItemTable itemTable = itemInfo.score;
            if (itemTable != null && (list = itemTable.item_point) != null) {
                for (ItemPoint itemPoint : list) {
                    if (itemPoint != null && "all".equals(itemPoint.time_intval)) {
                        d = itemPoint.point.doubleValue();
                        break;
                    }
                }
            }
            d = 0.0d;
            if (d > 0.0d && d <= 10.0d) {
                this.c.setVisibility(0);
                this.d.setText(String.valueOf(d));
                this.e = true;
            } else {
                this.d.setText(R.string.obfuscated_res_0x7f0f06cb);
                this.c.setVisibility(8);
                this.e = false;
            }
            c(TbadkCoreApplication.getInst().getSkinType());
        }

        public void c(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                ImageView imageView = this.c;
                int i2 = R.color.CAM_X0305;
                WebPManager.setPureDrawable(imageView, R.drawable.obfuscated_res_0x7f0809b3, R.color.CAM_X0305, null);
                ur4.d(this.b).v(R.color.CAM_X0105);
                TextView textView = this.d;
                if (!this.e) {
                    i2 = R.color.CAM_X0109;
                }
                SkinManager.setViewTextColor(textView, i2);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = new Point();
        b();
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            setOrientation(1);
            EMTextView eMTextView = new EMTextView(getContext());
            this.a = eMTextView;
            eMTextView.setGravity(16);
            this.a.setText(R.string.obfuscated_res_0x7f0f070e);
            ur4 d2 = ur4.d(this.a);
            d2.A(R.string.F_X02);
            d2.z(R.dimen.T_X07);
            this.a.setPadding(pi.f(getContext(), R.dimen.M_W_X005), pi.f(getContext(), R.dimen.M_H_X004), pi.f(getContext(), R.dimen.M_W_X005), pi.f(getContext(), R.dimen.M_H_X008));
            addView(this.a, new LinearLayout.LayoutParams(-1, -2));
            BdRecyclerView bdRecyclerView = new BdRecyclerView(getContext());
            this.b = bdRecyclerView;
            bdRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
            this.b.setPadding(pi.f(getContext(), R.dimen.M_W_X004), 0, pi.f(getContext(), R.dimen.M_W_X005), 0);
            this.b.addItemDecoration(new a(this));
            this.b.setOnItemClickListener(new b(this));
            addView(this.b, new LinearLayout.LayoutParams(-1, -2));
            c cVar = new c(this);
            this.c = cVar;
            this.b.setAdapter(cVar);
        }
    }

    @Override // com.repackage.hx
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext, i) == null) {
            this.c.notifyDataSetChanged();
            ur4.d(this.a).v(R.color.CAM_X0105);
            ur4 d2 = ur4.d(this);
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
                    this.e.set((int) motionEvent.getX(), (int) motionEvent.getY());
                    if (this.b.getFirstCompletelyVisiblePosition() != 0 && (getContext() instanceof BaseFragmentActivity) && ((BaseFragmentActivity) getContext()).isSwipeBackEnabled()) {
                        ((BaseFragmentActivity) getContext()).disableSwipeJustOnce();
                    }
                } else {
                    boolean z = false;
                    if (motionEvent.getAction() == 2) {
                        boolean z2 = (getContext() instanceof BaseFragmentActivity) && ((BaseFragmentActivity) getContext()).isSwipeBackEnabled();
                        ViewParent parent = getParent();
                        if (!z2 && Math.abs(this.e.x - motionEvent.getX()) > Math.abs(this.e.y - motionEvent.getY())) {
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

    public void setData(nn4 nn4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, nn4Var) == null) && (nn4Var instanceof xl6)) {
            xl6 xl6Var = (xl6) nn4Var;
            if (xl6Var.c() == null) {
                return;
            }
            this.d = xl6Var.c();
            this.c.notifyDataSetChanged();
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
        this.e = new Point();
        b();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardItemRecommendLayout(Context context, AttributeSet attributeSet, int i) {
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
        this.e = new Point();
        b();
    }
}
