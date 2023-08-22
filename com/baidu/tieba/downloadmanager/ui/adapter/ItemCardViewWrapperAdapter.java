package com.baidu.tieba.downloadmanager.ui.adapter;

import android.animation.ValueAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ItemData;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.ItemClickJumpUtil;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.ItemCardView;
import com.baidu.tbadk.core.view.itemcard.ItemCardHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.downloadmanager.data.DownloadManageModeCardType;
import com.baidu.tieba.nx6;
import com.baidu.tieba.om;
import com.baidu.tieba.ox6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class ItemCardViewWrapperAdapter extends om<ox6, ItemCardViewWrapperViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public int c;
    public BdTypeRecyclerView d;
    public int e;
    public b f;
    public float g;
    public DownloadManageModeCardType h;

    /* loaded from: classes5.dex */
    public interface b {
        void a(ox6 ox6Var);
    }

    /* loaded from: classes5.dex */
    public class ItemCardViewWrapperViewHolder extends TypeAdapter.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ItemCardView a;
        public View b;
        public EMTextView c;
        public View d;
        public final /* synthetic */ ItemCardViewWrapperAdapter e;

        /* loaded from: classes5.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ int a;
            public final /* synthetic */ ox6 b;
            public final /* synthetic */ ItemCardViewWrapperViewHolder c;

            public a(ItemCardViewWrapperViewHolder itemCardViewWrapperViewHolder, int i, ox6 ox6Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {itemCardViewWrapperViewHolder, Integer.valueOf(i), ox6Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.c = itemCardViewWrapperViewHolder;
                this.a = i;
                this.b = ox6Var;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                    int i = this.c.e.b;
                    int i2 = this.a;
                    ox6 ox6Var = this.b;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001440, new nx6(i, i2, ox6Var.b, ox6Var.a.mTitle, view2)));
                }
            }
        }

        /* loaded from: classes5.dex */
        public class b implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ox6 a;
            public final /* synthetic */ ItemCardViewWrapperViewHolder b;

            public b(ItemCardViewWrapperViewHolder itemCardViewWrapperViewHolder, ox6 ox6Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {itemCardViewWrapperViewHolder, ox6Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = itemCardViewWrapperViewHolder;
                this.a = ox6Var;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                    ox6 ox6Var = this.a;
                    ox6Var.e = !ox6Var.e;
                    this.b.a.setRadioSelected(this.a.e);
                    if (this.b.e.f != null) {
                        this.b.e.f.a(this.a);
                    }
                }
            }
        }

        /* loaded from: classes5.dex */
        public class c implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ox6 a;
            public final /* synthetic */ int b;
            public final /* synthetic */ ItemCardViewWrapperViewHolder c;

            public c(ItemCardViewWrapperViewHolder itemCardViewWrapperViewHolder, ox6 ox6Var, int i) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {itemCardViewWrapperViewHolder, ox6Var, Integer.valueOf(i)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.c = itemCardViewWrapperViewHolder;
                this.a = ox6Var;
                this.b = i;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || TextUtils.isEmpty(this.a.a.forumName)) {
                    return;
                }
                ItemData itemData = this.a.a;
                ItemClickJumpUtil.itemClickJump(itemData.forumName, String.valueOf(itemData.itemId), -1, 15);
                if (3 == this.c.e.b) {
                    int i = this.c.e.b;
                    int i2 = this.b;
                    int E = this.c.a.E(this.a.a);
                    int i3 = this.a.b;
                    ItemCardHelper.f(i, i2, E, 2, this.a.a.mTitle, false);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ItemCardViewWrapperViewHolder(ItemCardViewWrapperAdapter itemCardViewWrapperAdapter, View view2) {
            super(view2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {itemCardViewWrapperAdapter, view2};
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
            this.e = itemCardViewWrapperAdapter;
            ViewGroup viewGroup = (ViewGroup) view2;
            this.a = (ItemCardView) viewGroup.getChildAt(0);
            this.b = viewGroup.getChildAt(2);
            this.c = (EMTextView) viewGroup.getChildAt(1);
            this.d = viewGroup.getChildAt(3);
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                EMManager.from(this.d).setBackGroundColor(R.color.CAM_X0203);
                this.a.N();
                this.a.setBackground(null);
                SkinManager.setBackgroundColor(this.b, R.color.CAM_X0204);
                EMManager.from(this.c).setTextSize(R.dimen.T_X06).setTextStyle(R.string.F_X02).setTextColor(R.color.CAM_X0105);
                this.c.setBackground(null);
            }
        }

        public void c(ox6 ox6Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ox6Var) == null) {
                if (!ox6Var.d) {
                    this.d.setVisibility(8);
                } else {
                    this.d.setVisibility(0);
                }
                if (ox6Var.a == null) {
                    this.e.a = getLayoutPosition();
                    this.a.setVisibility(8);
                    this.c.setVisibility(0);
                    this.b.setVisibility(0);
                    return;
                }
                int layoutPosition = getLayoutPosition();
                if (this.e.a == -1 || layoutPosition <= this.e.a) {
                    layoutPosition++;
                }
                if (this.e.d.getHeaderViewsCount() != 0 && layoutPosition > this.e.a) {
                    layoutPosition--;
                }
                if (layoutPosition == 1 && this.e.d.getHeaderViewsCount() == 0) {
                    this.b.setVisibility(0);
                    ((FrameLayout.LayoutParams) this.a.getLayoutParams()).setMargins(0, BdUtilHelper.getDimens(this.e.mContext, R.dimen.tbds21), 0, 0);
                } else {
                    this.b.setVisibility(8);
                    ((FrameLayout.LayoutParams) this.a.getLayoutParams()).setMargins(0, 0, 0, 0);
                }
                this.c.setVisibility(8);
                this.a.setVisibility(0);
                this.a.setSource(ox6Var.b);
                int i = ox6Var.b;
                if (i == 1) {
                    this.a.setData(ox6Var.a, 10, true, this.e.b, layoutPosition);
                } else if (i == 2) {
                    this.a.setData(ox6Var.a, 10, true, ox6Var.c, this.e.b, layoutPosition);
                } else {
                    this.a.setData(ox6Var.a, 10, true, this.e.b, layoutPosition);
                }
                this.a.setOnClickListenerOfRightBtn(new a(this, layoutPosition, ox6Var));
                if (this.e.h == DownloadManageModeCardType.ENTER_MANAGE_MODE && ox6Var.f) {
                    this.a.setRadioSelected(ox6Var.e);
                    this.a.setOnClickListener(new b(this, ox6Var));
                } else {
                    this.a.setOnClickListener(new c(this, ox6Var, layoutPosition));
                }
                if (this.e.h == DownloadManageModeCardType.ENTER_MANAGE_MODE && ox6Var.f) {
                    this.a.V(this.e.g);
                } else if (this.e.h == DownloadManageModeCardType.EXIT_MANAGE_MODE && ox6Var.f) {
                    this.a.H(this.e.g);
                } else {
                    this.a.D();
                }
                if (ox6Var.a != null) {
                    StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_DOWNLOAD_MANAGER_SHOW);
                    statisticItem.addParam("uid", TbadkCoreApplication.getCurrentAccountId());
                    statisticItem.addParam("obj_locate", this.e.b);
                    statisticItem.addParam("obj_source", this.e.c);
                    statisticItem.addParam("obj_name", ox6Var.a.itemId);
                    statisticItem.addParam("obj_type", this.a.E(ox6Var.a));
                    TiebaStatic.log(statisticItem);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ItemCardViewWrapperAdapter a;

        public a(ItemCardViewWrapperAdapter itemCardViewWrapperAdapter) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {itemCardViewWrapperAdapter};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = itemCardViewWrapperAdapter;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                this.a.g = ((Float) valueAnimator.getAnimatedValue()).floatValue();
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
        this.a = -1;
        this.e = 300;
        this.g = 0.0f;
        this.h = DownloadManageModeCardType.INITIALIZE;
        this.b = i;
        this.c = i2;
        this.d = bdTypeRecyclerView;
    }

    public void H(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) {
            this.f = bVar;
        }
    }

    public void E(DownloadManageModeCardType downloadManageModeCardType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, downloadManageModeCardType) == null) {
            this.h = downloadManageModeCardType;
            notifyDataSetChanged();
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, this.e);
            ofFloat.setDuration(this.e);
            ofFloat.addUpdateListener(new a(this));
            ofFloat.start();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.om
    /* renamed from: F */
    public ItemCardViewWrapperViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup)) == null) {
            FrameLayout frameLayout = new FrameLayout(this.mContext);
            frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
            ItemCardView itemCardView = new ItemCardView(this.mContext);
            itemCardView.setIsShowRightBtn(true);
            itemCardView.setRadius(0);
            itemCardView.setItemImageViewRadius(R.string.J_X05);
            itemCardView.setFirstLineTextColor(R.color.CAM_X0105);
            itemCardView.setPosition(7);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            itemCardView.setPadding(BdUtilHelper.getDimens(this.mContext, R.dimen.tbds18), BdUtilHelper.getDimens(this.mContext, R.dimen.tbds26), BdUtilHelper.getDimens(this.mContext, R.dimen.tbds4), BdUtilHelper.getDimens(this.mContext, R.dimen.tbds18));
            frameLayout.addView(itemCardView, layoutParams);
            EMTextView eMTextView = new EMTextView(this.mContext);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
            layoutParams2.setMargins(0, BdUtilHelper.getDimens(this.mContext, R.dimen.tbds21), 0, 0);
            eMTextView.setPadding(BdUtilHelper.getDimens(this.mContext, R.dimen.M_W_X007), BdUtilHelper.getDimens(this.mContext, R.dimen.tbds44), 0, 0);
            eMTextView.setText(R.string.obfuscated_res_0x7f0f11fa);
            frameLayout.addView(eMTextView, layoutParams2);
            frameLayout.addView(new View(this.mContext), new ViewGroup.LayoutParams(-1, BdUtilHelper.getDimens(this.mContext, R.dimen.tbds21)));
            View view2 = new View(this.mContext);
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, BdUtilHelper.getDimens(this.mContext, R.dimen.tbds1));
            layoutParams3.setMargins(BdUtilHelper.getDimens(this.mContext, R.dimen.tbds221), 0, BdUtilHelper.getDimens(this.mContext, R.dimen.M_W_X007), 0);
            layoutParams3.gravity = 80;
            frameLayout.addView(view2, layoutParams3);
            return new ItemCardViewWrapperViewHolder(this, frameLayout);
        }
        return (ItemCardViewWrapperViewHolder) invokeL.objValue;
    }

    public View G(int i, View view2, ViewGroup viewGroup, ox6 ox6Var, ItemCardViewWrapperViewHolder itemCardViewWrapperViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), view2, viewGroup, ox6Var, itemCardViewWrapperViewHolder})) == null) {
            if (ox6Var != null) {
                itemCardViewWrapperViewHolder.c(ox6Var);
            }
            itemCardViewWrapperViewHolder.a();
            return view2;
        }
        return (View) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // com.baidu.tieba.om
    public /* bridge */ /* synthetic */ View onFillViewHolder(int i, View view2, ViewGroup viewGroup, ox6 ox6Var, ItemCardViewWrapperViewHolder itemCardViewWrapperViewHolder) {
        G(i, view2, viewGroup, ox6Var, itemCardViewWrapperViewHolder);
        return view2;
    }
}
