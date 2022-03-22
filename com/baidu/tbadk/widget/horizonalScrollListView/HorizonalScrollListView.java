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
import c.a.d.a.e;
import c.a.d.f.p.m;
import c.a.p0.a4.y;
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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes5.dex */
public class HorizonalScrollListView extends MyHorizontalScrollView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinearLayout a;

    /* renamed from: b  reason: collision with root package name */
    public final ArrayList<ItemViewHolder> f30769b;

    /* renamed from: c  reason: collision with root package name */
    public int f30770c;

    /* renamed from: d  reason: collision with root package name */
    public TbPageContext<?> f30771d;

    /* renamed from: e  reason: collision with root package name */
    public View.OnClickListener f30772e;

    /* renamed from: f  reason: collision with root package name */
    public View f30773f;

    /* renamed from: g  reason: collision with root package name */
    public String f30774g;

    /* renamed from: h  reason: collision with root package name */
    public String f30775h;
    public BdUniqueId i;
    public String j;
    public CustomMessageListener k;
    public CustomMessageListener l;
    public View.OnClickListener m;
    public View.OnClickListener n;

    /* loaded from: classes5.dex */
    public static class ItemViewHolder extends TypeAdapter.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public BarImageView a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f30776b;

        /* renamed from: c  reason: collision with root package name */
        public TbImageView f30777c;

        /* renamed from: d  reason: collision with root package name */
        public EntelechyUserLikeButton f30778d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ItemViewHolder(View view) {
            super(view);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view};
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
            this.f30776b = null;
            this.f30777c = null;
            this.f30778d = null;
            BarImageView barImageView = (BarImageView) view.findViewById(R.id.obfuscated_res_0x7f090a1e);
            this.a = barImageView;
            barImageView.setGifIconSupport(false);
            this.f30776b = (TextView) view.findViewById(R.id.obfuscated_res_0x7f091366);
            this.f30777c = (TbImageView) view.findViewById(R.id.obfuscated_res_0x7f090db9);
            this.f30778d = (EntelechyUserLikeButton) view.findViewById(R.id.obfuscated_res_0x7f090a19);
        }
    }

    /* loaded from: classes5.dex */
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

    /* loaded from: classes5.dex */
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

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HorizonalScrollListView a;

        /* loaded from: classes5.dex */
        public class a extends e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ LikeModel a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ EntelechyUserLikeButton f30779b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ c f30780c;

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
                this.f30780c = cVar;
                this.a = likeModel;
                this.f30779b = entelechyUserLikeButton;
            }

            @Override // c.a.d.a.e
            public void c(Object obj) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                    if ((obj instanceof y) && this.a.getErrorCode() == 0) {
                        y yVar = (y) obj;
                        yVar.y(1);
                        this.f30780c.a.o(this.f30779b, yVar.n() == 1);
                    } else if (AntiHelper.m(this.a.getErrorCode(), this.a.getErrorString())) {
                        AntiHelper.u(this.f30780c.a.f30771d.getPageActivity(), this.a.getErrorString());
                    } else {
                        this.f30780c.a.f30771d.showToast(this.a.getErrorString());
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
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && ViewHelper.checkUpIsLogin(this.a.getContext())) {
                String str = (String) view.getTag(R.id.obfuscated_res_0x7f091e7b);
                String valueOf = String.valueOf(view.getTag(R.id.obfuscated_res_0x7f091e7a));
                EntelechyUserLikeButton entelechyUserLikeButton = (EntelechyUserLikeButton) view;
                if (m.isForumName(str)) {
                    if (!TextUtils.isEmpty(this.a.f30774g)) {
                        TiebaStatic.log(new StatisticItem(this.a.f30774g).param("obj_type", 1).param("fid", valueOf));
                    }
                    LikeModel likeModel = new LikeModel(this.a.f30771d);
                    likeModel.setLoadDataCallBack(new a(this, likeModel, entelechyUserLikeButton));
                    likeModel.P(str, valueOf);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
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
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                String str = (String) view.getTag(R.id.obfuscated_res_0x7f091e7b);
                String valueOf = String.valueOf(view.getTag(R.id.obfuscated_res_0x7f091e7a));
                if (m.isForumName(str)) {
                    if (!TextUtils.isEmpty(this.a.f30775h)) {
                        TiebaStatic.log(new StatisticItem(this.a.f30775h).param("fid", valueOf));
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.a.f30771d.getPageActivity()).createNormalCfg(str, this.a.getFrom())));
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
        this.f30769b = new ArrayList<>();
        this.f30770c = 3;
        this.f30772e = null;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f30773f : (View) invokeV.objValue;
    }

    public final View h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? View.inflate(this.f30771d.getPageActivity(), R.layout.obfuscated_res_0x7f0d08c6, null) : (View) invokeV.objValue;
    }

    public final void i(ItemViewHolder itemViewHolder) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, itemViewHolder) == null) || itemViewHolder == null) {
            return;
        }
        this.f30773f = itemViewHolder.b();
        itemViewHolder.f30778d.setVisibility(8);
        itemViewHolder.f30776b.setText(this.f30771d.getPageActivity().getResources().getString(R.string.obfuscated_res_0x7f0f0f4a));
        itemViewHolder.f30777c.setVisibility(8);
        itemViewHolder.a.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        SkinManager.setImageResource(itemViewHolder.a, R.drawable.icon_pic_more);
        SkinManager.setViewTextColor(itemViewHolder.f30776b, R.color.CAM_X0105, 1);
        SkinManager.setBackgroundResource(itemViewHolder.a, R.drawable.selector_load_more_bg);
        this.f30773f.setClickable(true);
        this.f30773f.setOnClickListener(this.f30772e);
    }

    public final void j(View view, c.a.o0.e1.g.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048582, this, view, aVar) == null) || aVar == null || view == null || view.getTag() == null) {
            return;
        }
        ItemViewHolder itemViewHolder = (ItemViewHolder) view.getTag();
        itemViewHolder.a.setTag(aVar.f10091b);
        itemViewHolder.a.J(aVar.f10091b, 10, false);
        itemViewHolder.f30776b.setText(aVar.f10092c);
        itemViewHolder.f30776b.setTag(R.id.obfuscated_res_0x7f091e7a, Long.valueOf(aVar.f10093d));
        itemViewHolder.f30777c.setDefaultBgResource(0);
        itemViewHolder.f30777c.setDefaultResource(0);
        itemViewHolder.f30778d.setTag(R.id.obfuscated_res_0x7f091e7a, Long.valueOf(aVar.f10093d));
        itemViewHolder.f30778d.setTag(R.id.obfuscated_res_0x7f091e7b, aVar.f10092c);
        itemViewHolder.b().setTag(R.id.obfuscated_res_0x7f091e7a, Long.valueOf(aVar.f10093d));
        itemViewHolder.b().setTag(R.id.obfuscated_res_0x7f091e7b, aVar.f10092c);
        o(itemViewHolder.f30778d, aVar.f10094e);
        int i = aVar.a;
        if (i == 1) {
            itemViewHolder.f30777c.setVisibility(0);
            SkinManager.setImageResource(itemViewHolder.f30777c, R.drawable.icon_grade_shaitu1);
        } else if (i == 2) {
            itemViewHolder.f30777c.setVisibility(0);
            SkinManager.setImageResource(itemViewHolder.f30777c, R.drawable.icon_grade_shaitu2);
        } else if (i != 3) {
            itemViewHolder.f30777c.setVisibility(8);
        } else {
            itemViewHolder.f30777c.setVisibility(0);
            SkinManager.setImageResource(itemViewHolder.f30777c, R.drawable.icon_grade_shaitu3);
        }
        n(view, aVar);
    }

    @SuppressLint({"ResourceAsColor"})
    public final void k(ItemViewHolder itemViewHolder, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048583, this, itemViewHolder, i) == null) || itemViewHolder == null || itemViewHolder.b() == null) {
            return;
        }
        if (itemViewHolder.f30778d.getTag(R.id.obfuscated_res_0x7f090a3f) != null && (itemViewHolder.f30778d.getTag(R.id.obfuscated_res_0x7f090a3f) instanceof Boolean)) {
            o(itemViewHolder.f30778d, ((Boolean) itemViewHolder.f30778d.getTag(R.id.obfuscated_res_0x7f090a3f)).booleanValue());
        }
        SkinManager.setViewTextColor(itemViewHolder.f30776b, R.color.CAM_X0105, 1);
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
        if (!(interceptable == null || interceptable.invokeI(1048585, this, i) == null) || this.f30770c == i) {
            return;
        }
        Iterator<ItemViewHolder> it = this.f30769b.iterator();
        while (it.hasNext()) {
            ItemViewHolder next = it.next();
            if (next != null) {
                k(next, i);
            }
        }
        View view = this.f30773f;
        if (view != null) {
            BarImageView barImageView = (BarImageView) view.findViewById(R.id.obfuscated_res_0x7f090a1e);
            SkinManager.setBackgroundResource(barImageView, R.drawable.selector_load_more_bg);
            SkinManager.setImageResource(barImageView, R.drawable.icon_pic_more);
            SkinManager.setViewTextColor((TextView) this.f30773f.findViewById(R.id.obfuscated_res_0x7f091366), R.color.CAM_X0105, 1);
        }
        int count = ListUtils.getCount(this.f30769b);
        for (int i2 = 0; i2 < 3 && i2 < count; i2++) {
            ItemViewHolder itemViewHolder = (ItemViewHolder) ListUtils.getItem(this.f30769b, i2);
            if (itemViewHolder != null) {
                int i3 = i2 + 1;
                if (i3 == 1) {
                    SkinManager.setImageResource(itemViewHolder.f30777c, R.drawable.icon_grade_shaitu1);
                } else if (i3 == 2) {
                    SkinManager.setImageResource(itemViewHolder.f30777c, R.drawable.icon_grade_shaitu2);
                } else if (i3 == 3) {
                    SkinManager.setImageResource(itemViewHolder.f30777c, R.drawable.icon_grade_shaitu3);
                }
            }
        }
        this.f30770c = i;
    }

    public final void n(View view, c.a.o0.e1.g.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048586, this, view, aVar) == null) || view == null || view.getTag() == null || aVar == null) {
            return;
        }
        ItemViewHolder itemViewHolder = (ItemViewHolder) view.getTag();
        itemViewHolder.f30778d.setClickable(true);
        itemViewHolder.f30778d.setOnClickListener(this.m);
        view.setClickable(true);
        view.setOnClickListener(this.n);
    }

    @SuppressLint({"ResourceAsColor"})
    public final void o(EntelechyUserLikeButton entelechyUserLikeButton, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048587, this, entelechyUserLikeButton, z) == null) || entelechyUserLikeButton == null) {
            return;
        }
        entelechyUserLikeButton.setTag(R.id.obfuscated_res_0x7f090a3f, Boolean.valueOf(z));
        entelechyUserLikeButton.h(z);
    }

    public final void p(long j, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Long.valueOf(j), Boolean.valueOf(z)}) == null) {
            Iterator<ItemViewHolder> it = this.f30769b.iterator();
            while (it.hasNext()) {
                ItemViewHolder next = it.next();
                if (next != null && next.b() != null && next.f30776b.getTag(R.id.obfuscated_res_0x7f091e7a) != null) {
                    EntelechyUserLikeButton entelechyUserLikeButton = next.f30778d;
                    if (((Long) next.f30776b.getTag(R.id.obfuscated_res_0x7f091e7a)).longValue() == j) {
                        o(entelechyUserLikeButton, z);
                        return;
                    }
                }
            }
        }
    }

    public void setData(List<c.a.o0.e1.g.a> list, TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048589, this, list, tbPageContext) == null) || ListUtils.getCount(list) <= 0 || tbPageContext == null) {
            return;
        }
        this.f30771d = tbPageContext;
        list.add(new c.a.o0.e1.g.a());
        int count = ListUtils.getCount(this.f30769b);
        int count2 = ListUtils.getCount(list);
        if (count > count2) {
            for (int i = 0; i < count - count2; i++) {
                TypeAdapter.ViewHolder viewHolder = (TypeAdapter.ViewHolder) ListUtils.getItem(this.f30769b, i);
                if (viewHolder != null) {
                    this.a.removeView(viewHolder.b());
                }
                this.f30769b.remove(viewHolder);
            }
        }
        for (int i2 = 0; i2 < count2; i2++) {
            c.a.o0.e1.g.a aVar = (c.a.o0.e1.g.a) ListUtils.getItem(list, i2);
            ItemViewHolder itemViewHolder = (ItemViewHolder) ListUtils.getItem(this.f30769b, i2);
            if (itemViewHolder != null) {
                j(itemViewHolder.b(), aVar);
            } else {
                View h2 = h();
                if (h2 != null) {
                    ItemViewHolder itemViewHolder2 = new ItemViewHolder(h2);
                    this.f30769b.add(itemViewHolder2);
                    j(itemViewHolder2.b(), aVar);
                    this.a.addView(h2);
                }
            }
            int i3 = count2 - 1;
            if (i2 == i3) {
                i(this.f30769b.get(i3));
            }
        }
        this.f30771d.registerListener(this.k);
        this.f30771d.registerListener(this.l);
        if (getTag() != null) {
            this.k.setTag(getTag());
            this.l.setTag(getTag());
        }
        m(this.f30770c);
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
            this.f30772e = onClickListener;
        }
    }

    public void setStatKey(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, str, str2) == null) {
            this.f30774g = str;
            this.f30775h = str2;
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
        this.f30769b = new ArrayList<>();
        this.f30770c = 3;
        this.f30772e = null;
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
        this.f30769b = new ArrayList<>();
        this.f30770c = 3;
        this.f30772e = null;
        this.i = null;
        this.k = new a(this, 2001336);
        this.l = new b(this, 2001335);
        this.m = new c(this);
        this.n = new d(this);
        l(context);
    }
}
