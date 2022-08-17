package com.baidu.tbadk.widget.horizonalScrollListView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.bk8;
import com.repackage.c9;
import com.repackage.pg5;
import com.repackage.pi;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class HorizonalScrollListView extends MyHorizontalScrollView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinearLayout a;
    public final ArrayList<ItemViewHolder> b;
    public int c;
    public TbPageContext<?> d;
    public View.OnClickListener e;
    public View f;
    public String g;
    public String h;
    public BdUniqueId i;
    public String j;
    public CustomMessageListener k;
    public CustomMessageListener l;
    public View.OnClickListener m;
    public View.OnClickListener n;

    /* loaded from: classes3.dex */
    public static class ItemViewHolder extends TypeAdapter.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public BarImageView a;
        public TextView b;
        public TbImageView c;
        public EntelechyUserLikeButton d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ItemViewHolder(View view2) {
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
            this.a = null;
            this.b = null;
            this.c = null;
            this.d = null;
            BarImageView barImageView = (BarImageView) view2.findViewById(R.id.obfuscated_res_0x7f090a30);
            this.a = barImageView;
            barImageView.setGifIconSupport(false);
            this.b = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091451);
            this.c = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f090db6);
            this.d = (EntelechyUserLikeButton) view2.findViewById(R.id.obfuscated_res_0x7f090a2b);
        }
    }

    /* loaded from: classes3.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HorizonalScrollListView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(HorizonalScrollListView horizonalScrollListView, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {horizonalScrollListView, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = horizonalScrollListView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                this.a.p(((Long) customResponsedMessage.getData()).longValue(), false);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HorizonalScrollListView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(HorizonalScrollListView horizonalScrollListView, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {horizonalScrollListView, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = horizonalScrollListView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                this.a.p(((Long) customResponsedMessage.getData()).longValue(), true);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HorizonalScrollListView a;

        /* loaded from: classes3.dex */
        public class a extends c9 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ LikeModel a;
            public final /* synthetic */ EntelechyUserLikeButton b;
            public final /* synthetic */ c c;

            public a(c cVar, LikeModel likeModel, EntelechyUserLikeButton entelechyUserLikeButton) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, likeModel, entelechyUserLikeButton};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.c = cVar;
                this.a = likeModel;
                this.b = entelechyUserLikeButton;
            }

            @Override // com.repackage.c9
            public void c(Object obj) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                    if ((obj instanceof bk8) && this.a.getErrorCode() == 0) {
                        bk8 bk8Var = (bk8) obj;
                        bk8Var.x(1);
                        this.c.a.o(this.b, bk8Var.m() == 1);
                    } else if (AntiHelper.m(this.a.getErrorCode(), this.a.getErrorString())) {
                        AntiHelper.u(this.c.a.d.getPageActivity(), this.a.getErrorString());
                    } else {
                        this.c.a.d.showToast(this.a.getErrorString());
                    }
                }
            }
        }

        public c(HorizonalScrollListView horizonalScrollListView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {horizonalScrollListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = horizonalScrollListView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && ViewHelper.checkUpIsLogin(this.a.getContext())) {
                String str = (String) view2.getTag(R.id.obfuscated_res_0x7f091ffa);
                String valueOf = String.valueOf(view2.getTag(R.id.obfuscated_res_0x7f091ff9));
                EntelechyUserLikeButton entelechyUserLikeButton = (EntelechyUserLikeButton) view2;
                if (pi.isForumName(str)) {
                    if (!TextUtils.isEmpty(this.a.g)) {
                        TiebaStatic.log(new StatisticItem(this.a.g).param("obj_type", 1).param("fid", valueOf));
                    }
                    LikeModel likeModel = new LikeModel(this.a.d);
                    likeModel.setLoadDataCallBack(new a(this, likeModel, entelechyUserLikeButton));
                    likeModel.Q(str, valueOf);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HorizonalScrollListView a;

        public d(HorizonalScrollListView horizonalScrollListView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {horizonalScrollListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = horizonalScrollListView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                String str = (String) view2.getTag(R.id.obfuscated_res_0x7f091ffa);
                String valueOf = String.valueOf(view2.getTag(R.id.obfuscated_res_0x7f091ff9));
                if (pi.isForumName(str)) {
                    if (!TextUtils.isEmpty(this.a.h)) {
                        TiebaStatic.log(new StatisticItem(this.a.h).param("fid", valueOf));
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.a.d.getPageActivity()).createNormalCfg(str, this.a.getFrom())));
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HorizonalScrollListView(Context context) {
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
        this.b = new ArrayList<>();
        this.c = 3;
        this.e = null;
        this.i = null;
        this.k = new a(this, 2001336);
        this.l = new b(this, 2001335);
        this.m = new c(this);
        this.n = new d(this);
        l(context);
    }

    public String getFrom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.j : (String) invokeV.objValue;
    }

    public View getLastItemView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f : (View) invokeV.objValue;
    }

    public final View h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? View.inflate(this.d.getPageActivity(), R.layout.obfuscated_res_0x7f0d08f9, null) : (View) invokeV.objValue;
    }

    public final void i(ItemViewHolder itemViewHolder) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, itemViewHolder) == null) || itemViewHolder == null) {
            return;
        }
        this.f = itemViewHolder.getView();
        itemViewHolder.d.setVisibility(8);
        itemViewHolder.b.setText(this.d.getPageActivity().getResources().getString(R.string.obfuscated_res_0x7f0f0fa0));
        itemViewHolder.c.setVisibility(8);
        itemViewHolder.a.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        SkinManager.setImageResource(itemViewHolder.a, R.drawable.icon_pic_more);
        SkinManager.setViewTextColor(itemViewHolder.b, R.color.CAM_X0105, 1);
        SkinManager.setBackgroundResource(itemViewHolder.a, R.drawable.selector_load_more_bg);
        this.f.setClickable(true);
        this.f.setOnClickListener(this.e);
    }

    public final void j(View view2, pg5 pg5Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048582, this, view2, pg5Var) == null) || pg5Var == null || view2 == null || view2.getTag() == null) {
            return;
        }
        ItemViewHolder itemViewHolder = (ItemViewHolder) view2.getTag();
        itemViewHolder.a.setTag(pg5Var.b);
        itemViewHolder.a.K(pg5Var.b, 10, false);
        itemViewHolder.b.setText(pg5Var.c);
        itemViewHolder.b.setTag(R.id.obfuscated_res_0x7f091ff9, Long.valueOf(pg5Var.d));
        itemViewHolder.c.setDefaultBgResource(0);
        itemViewHolder.c.setDefaultResource(0);
        itemViewHolder.d.setTag(R.id.obfuscated_res_0x7f091ff9, Long.valueOf(pg5Var.d));
        itemViewHolder.d.setTag(R.id.obfuscated_res_0x7f091ffa, pg5Var.c);
        itemViewHolder.getView().setTag(R.id.obfuscated_res_0x7f091ff9, Long.valueOf(pg5Var.d));
        itemViewHolder.getView().setTag(R.id.obfuscated_res_0x7f091ffa, pg5Var.c);
        o(itemViewHolder.d, pg5Var.e);
        int i = pg5Var.a;
        if (i == 1) {
            itemViewHolder.c.setVisibility(0);
            SkinManager.setImageResource(itemViewHolder.c, R.drawable.icon_grade_shaitu1);
        } else if (i == 2) {
            itemViewHolder.c.setVisibility(0);
            SkinManager.setImageResource(itemViewHolder.c, R.drawable.icon_grade_shaitu2);
        } else if (i != 3) {
            itemViewHolder.c.setVisibility(8);
        } else {
            itemViewHolder.c.setVisibility(0);
            SkinManager.setImageResource(itemViewHolder.c, R.drawable.icon_grade_shaitu3);
        }
        n(view2, pg5Var);
    }

    @SuppressLint({"ResourceAsColor"})
    public final void k(ItemViewHolder itemViewHolder, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048583, this, itemViewHolder, i) == null) || itemViewHolder == null || itemViewHolder.getView() == null) {
            return;
        }
        if (itemViewHolder.d.getTag(R.id.obfuscated_res_0x7f090a52) != null && (itemViewHolder.d.getTag(R.id.obfuscated_res_0x7f090a52) instanceof Boolean)) {
            o(itemViewHolder.d, ((Boolean) itemViewHolder.d.getTag(R.id.obfuscated_res_0x7f090a52)).booleanValue());
        }
        SkinManager.setViewTextColor(itemViewHolder.b, R.color.CAM_X0105, 1);
    }

    public final void l(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context) == null) {
            setHorizontalFadingEdgeEnabled(false);
            setVerticalFadingEdgeEnabled(false);
            setHorizontalScrollBarEnabled(false);
            setVerticalScrollBarEnabled(false);
            LinearLayout linearLayout = new LinearLayout(context);
            this.a = linearLayout;
            linearLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
            this.a.setOrientation(0);
            addView(this.a);
        }
    }

    public void m(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048585, this, i) == null) || this.c == i) {
            return;
        }
        Iterator<ItemViewHolder> it = this.b.iterator();
        while (it.hasNext()) {
            ItemViewHolder next = it.next();
            if (next != null) {
                k(next, i);
            }
        }
        View view2 = this.f;
        if (view2 != null) {
            BarImageView barImageView = (BarImageView) view2.findViewById(R.id.obfuscated_res_0x7f090a30);
            SkinManager.setBackgroundResource(barImageView, R.drawable.selector_load_more_bg);
            SkinManager.setImageResource(barImageView, R.drawable.icon_pic_more);
            SkinManager.setViewTextColor((TextView) this.f.findViewById(R.id.obfuscated_res_0x7f091451), R.color.CAM_X0105, 1);
        }
        int count = ListUtils.getCount(this.b);
        for (int i2 = 0; i2 < 3 && i2 < count; i2++) {
            ItemViewHolder itemViewHolder = (ItemViewHolder) ListUtils.getItem(this.b, i2);
            if (itemViewHolder != null) {
                int i3 = i2 + 1;
                if (i3 == 1) {
                    SkinManager.setImageResource(itemViewHolder.c, R.drawable.icon_grade_shaitu1);
                } else if (i3 == 2) {
                    SkinManager.setImageResource(itemViewHolder.c, R.drawable.icon_grade_shaitu2);
                } else if (i3 == 3) {
                    SkinManager.setImageResource(itemViewHolder.c, R.drawable.icon_grade_shaitu3);
                }
            }
        }
        this.c = i;
    }

    public final void n(View view2, pg5 pg5Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048586, this, view2, pg5Var) == null) || view2 == null || view2.getTag() == null || pg5Var == null) {
            return;
        }
        ItemViewHolder itemViewHolder = (ItemViewHolder) view2.getTag();
        itemViewHolder.d.setClickable(true);
        itemViewHolder.d.setOnClickListener(this.m);
        view2.setClickable(true);
        view2.setOnClickListener(this.n);
    }

    @SuppressLint({"ResourceAsColor"})
    public final void o(EntelechyUserLikeButton entelechyUserLikeButton, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048587, this, entelechyUserLikeButton, z) == null) || entelechyUserLikeButton == null) {
            return;
        }
        entelechyUserLikeButton.setTag(R.id.obfuscated_res_0x7f090a52, Boolean.valueOf(z));
        entelechyUserLikeButton.h(z);
    }

    public final void p(long j, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Long.valueOf(j), Boolean.valueOf(z)}) == null) {
            Iterator<ItemViewHolder> it = this.b.iterator();
            while (it.hasNext()) {
                ItemViewHolder next = it.next();
                if (next != null && next.getView() != null && next.b.getTag(R.id.obfuscated_res_0x7f091ff9) != null) {
                    EntelechyUserLikeButton entelechyUserLikeButton = next.d;
                    if (((Long) next.b.getTag(R.id.obfuscated_res_0x7f091ff9)).longValue() == j) {
                        o(entelechyUserLikeButton, z);
                        return;
                    }
                }
            }
        }
    }

    public void setData(List<pg5> list, TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048589, this, list, tbPageContext) == null) || ListUtils.getCount(list) <= 0 || tbPageContext == null) {
            return;
        }
        this.d = tbPageContext;
        list.add(new pg5());
        int count = ListUtils.getCount(this.b);
        int count2 = ListUtils.getCount(list);
        if (count > count2) {
            for (int i = 0; i < count - count2; i++) {
                TypeAdapter.ViewHolder viewHolder = (TypeAdapter.ViewHolder) ListUtils.getItem(this.b, i);
                if (viewHolder != null) {
                    this.a.removeView(viewHolder.getView());
                }
                this.b.remove(viewHolder);
            }
        }
        for (int i2 = 0; i2 < count2; i2++) {
            pg5 pg5Var = (pg5) ListUtils.getItem(list, i2);
            ItemViewHolder itemViewHolder = (ItemViewHolder) ListUtils.getItem(this.b, i2);
            if (itemViewHolder != null) {
                j(itemViewHolder.getView(), pg5Var);
            } else {
                View h = h();
                if (h != null) {
                    ItemViewHolder itemViewHolder2 = new ItemViewHolder(h);
                    this.b.add(itemViewHolder2);
                    j(itemViewHolder2.getView(), pg5Var);
                    this.a.addView(h);
                }
            }
            int i3 = count2 - 1;
            if (i2 == i3) {
                i(this.b.get(i3));
            }
        }
        this.d.registerListener(this.k);
        this.d.registerListener(this.l);
        if (getTag() != null) {
            this.k.setTag(getTag());
            this.l.setTag(getTag());
        }
        m(this.c);
    }

    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            this.j = str;
        }
    }

    public void setLoadMoreClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, onClickListener) == null) {
            this.e = onClickListener;
        }
    }

    public void setStatKey(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, str, str2) == null) {
            this.g = str;
            this.h = str2;
        }
    }

    public void setTag(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, bdUniqueId) == null) {
            this.i = bdUniqueId;
            if (bdUniqueId == null) {
                return;
            }
            CustomMessageListener customMessageListener = this.l;
            if (customMessageListener != null) {
                customMessageListener.setTag(bdUniqueId);
            }
            CustomMessageListener customMessageListener2 = this.k;
            if (customMessageListener2 != null) {
                customMessageListener2.setTag(this.i);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.view.View
    public BdUniqueId getTag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.i : (BdUniqueId) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HorizonalScrollListView(Context context, AttributeSet attributeSet) {
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
        this.b = new ArrayList<>();
        this.c = 3;
        this.e = null;
        this.i = null;
        this.k = new a(this, 2001336);
        this.l = new b(this, 2001335);
        this.m = new c(this);
        this.n = new d(this);
        l(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HorizonalScrollListView(Context context, AttributeSet attributeSet, int i) {
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
        this.b = new ArrayList<>();
        this.c = 3;
        this.e = null;
        this.i = null;
        this.k = new a(this, 2001336);
        this.l = new b(this, 2001335);
        this.m = new c(this);
        this.n = new d(this);
        l(context);
    }
}
