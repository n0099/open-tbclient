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
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.ItemClickJumpUtil;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.aq7;
import com.baidu.tieba.l9;
import com.baidu.tieba.la5;
import com.baidu.tieba.ux;
import com.baidu.tieba.w05;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import tbclient.ItemInfo;
import tbclient.ItemPoint;
import tbclient.ItemTable;
/* loaded from: classes5.dex */
public class CardItemRecommendLayout extends LinearLayout implements ux {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public EMTextView a;
    public BdRecyclerView b;
    public c c;
    public List<ItemInfo> d;
    public final Point e;

    /* loaded from: classes5.dex */
    public static class d extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final BarImageView a;
        public final EMTextView b;
        public final ImageView c;
        public final TextView d;
        public boolean e;
        public ItemInfo f;

        /* loaded from: classes5.dex */
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
                if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || this.a.f == null) {
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
            BarImageView barImageView = (BarImageView) view2.findViewById(R.id.obfuscated_res_0x7f090cfa);
            this.a = barImageView;
            barImageView.setConrers(15);
            this.a.setRadiusById(R.string.J_X05);
            this.a.setDrawCorner(true);
            this.a.setShowOuterBorder(true);
            this.a.setPlaceHolder(3);
            this.a.setPageId(l9.a(view2.getContext()).getUniqueId());
            this.b = (EMTextView) view2.findViewById(R.id.obfuscated_res_0x7f090cfb);
            this.c = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090cfd);
            this.d = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090cfc);
            this.itemView.setOnClickListener(new a(this));
        }

        public void c(ItemInfo itemInfo) {
            double d;
            List<ItemPoint> list;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, itemInfo) != null) || itemInfo == null) {
                return;
            }
            this.f = itemInfo;
            this.a.startLoad(itemInfo.icon_url, 10, false);
            if (StringHelper.getChineseAndEnglishLength(itemInfo.name) <= 10) {
                this.b.setText(itemInfo.name);
            } else {
                this.b.setText(StringHelper.cutChineseAndEnglishWithSuffix(itemInfo.name, 8, "..."));
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
                this.d.setText(R.string.frs_evaluate_exception);
                this.c.setVisibility(8);
                this.e = false;
            }
            d(TbadkCoreApplication.getInst().getSkinType());
        }

        public void d(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                ImageView imageView = this.c;
                int i2 = R.color.CAM_X0305;
                WebPManager.setPureDrawable(imageView, R.drawable.icon_pure_small_star, R.color.CAM_X0305, null);
                EMManager.from(this.b).setTextColor(R.color.CAM_X0105);
                TextView textView = this.d;
                if (!this.e) {
                    i2 = R.color.CAM_X0109;
                }
                SkinManager.setViewTextColor(textView, i2);
            }
        }
    }

    /* loaded from: classes5.dex */
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
                rect.set(0, 0, BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.M_W_X006), 0);
            }
        }
    }

    /* loaded from: classes5.dex */
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
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{viewGroup, view2, obj, Integer.valueOf(i), Long.valueOf(j)}) == null) && ListUtils.getItem(this.a.d, i) != null) {
                ItemClickJumpUtil.itemClickJump(((ItemInfo) ListUtils.getItem(this.a.d, i)).forum_name, String.valueOf(((ItemInfo) ListUtils.getItem(this.a.d, i)).id), 0);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921573, new la5(3, i + 1, 2)));
            }
        }
    }

    /* loaded from: classes5.dex */
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

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.a.d == null) {
                    return 0;
                }
                return this.a.d.size();
            }
            return invokeV.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: l */
        public void onBindViewHolder(@NonNull d dVar, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar, i) == null) && ListUtils.getItem(this.a.d, i) != null) {
                dVar.c((ItemInfo) ListUtils.getItem(this.a.d, i));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921573, new la5(3, i + 1, 1)));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NonNull
        /* renamed from: m */
        public d onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, viewGroup, i)) == null) {
                d dVar = new d(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.obfuscated_res_0x7f0d0382, (ViewGroup) null));
                dVar.d(TbadkCoreApplication.getInst().getSkinType());
                return dVar;
            }
            return (d) invokeLI.objValue;
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

    public void setData(w05 w05Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, w05Var) == null) && (w05Var instanceof aq7)) {
            aq7 aq7Var = (aq7) w05Var;
            if (aq7Var.c() != null) {
                this.d = aq7Var.c();
                this.c.notifyDataSetChanged();
            }
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            setOrientation(1);
            EMTextView eMTextView = new EMTextView(getContext());
            this.a = eMTextView;
            eMTextView.setGravity(16);
            this.a.setText(R.string.obfuscated_res_0x7f0f0844);
            EMManager.from(this.a).setTextStyle(R.string.F_X02).setTextSize(R.dimen.T_X07);
            this.a.setPadding(BdUtilHelper.getDimens(getContext(), R.dimen.M_W_X005), BdUtilHelper.getDimens(getContext(), R.dimen.M_H_X004), BdUtilHelper.getDimens(getContext(), R.dimen.M_W_X005), BdUtilHelper.getDimens(getContext(), R.dimen.M_H_X008));
            addView(this.a, new LinearLayout.LayoutParams(-1, -2));
            BdRecyclerView bdRecyclerView = new BdRecyclerView(getContext());
            this.b = bdRecyclerView;
            bdRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
            this.b.setPadding(BdUtilHelper.getDimens(getContext(), R.dimen.M_W_X004), 0, BdUtilHelper.getDimens(getContext(), R.dimen.M_W_X005), 0);
            this.b.addItemDecoration(new a(this));
            this.b.setOnItemClickListener(new b(this));
            addView(this.b, new LinearLayout.LayoutParams(-1, -2));
            c cVar = new c(this);
            this.c = cVar;
            this.b.setAdapter(cVar);
        }
    }

    @Override // com.baidu.tieba.ux
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext, i) == null) {
            this.c.notifyDataSetChanged();
            EMManager.from(this.a).setTextColor(R.color.CAM_X0105);
            EMManager.from(this).setCorner(R.string.J_X06).setBackGroundColor(R.color.CAM_X0205);
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
                    this.e.set((int) motionEvent.getX(), (int) motionEvent.getY());
                    if (this.b.getFirstCompletelyVisiblePosition() != 0 && (getContext() instanceof BaseFragmentActivity) && ((BaseFragmentActivity) getContext()).isSwipeBackEnabled()) {
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
                        if (!z && Math.abs(this.e.x - motionEvent.getX()) > Math.abs(this.e.y - motionEvent.getY())) {
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
