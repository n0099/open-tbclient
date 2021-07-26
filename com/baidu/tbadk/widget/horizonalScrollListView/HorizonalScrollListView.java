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
import d.a.d.a.e;
import d.a.d.e.p.k;
import d.a.q0.h3.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class HorizonalScrollListView extends MyHorizontalScrollView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f13375e;

    /* renamed from: f  reason: collision with root package name */
    public final ArrayList<ItemViewHolder> f13376f;

    /* renamed from: g  reason: collision with root package name */
    public int f13377g;

    /* renamed from: h  reason: collision with root package name */
    public TbPageContext<?> f13378h;

    /* renamed from: i  reason: collision with root package name */
    public View.OnClickListener f13379i;
    public View j;
    public String k;
    public String l;
    public BdUniqueId m;
    public String n;
    public CustomMessageListener o;
    public CustomMessageListener p;
    public View.OnClickListener q;
    public View.OnClickListener r;

    /* loaded from: classes3.dex */
    public static class ItemViewHolder extends TypeAdapter.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public BarImageView f13380a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f13381b;

        /* renamed from: c  reason: collision with root package name */
        public TbImageView f13382c;

        /* renamed from: d  reason: collision with root package name */
        public EntelechyUserLikeButton f13383d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ItemViewHolder(View view) {
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
            this.f13380a = null;
            this.f13381b = null;
            this.f13382c = null;
            this.f13383d = null;
            BarImageView barImageView = (BarImageView) view.findViewById(R.id.forum_avatar);
            this.f13380a = barImageView;
            barImageView.setGifIconSupport(false);
            this.f13381b = (TextView) view.findViewById(R.id.m_forum_name_textview);
            this.f13382c = (TbImageView) view.findViewById(R.id.hot_rank);
            this.f13383d = (EntelechyUserLikeButton) view.findViewById(R.id.forum_add_love);
        }
    }

    /* loaded from: classes3.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ HorizonalScrollListView f13384a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(HorizonalScrollListView horizonalScrollListView, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {horizonalScrollListView, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13384a = horizonalScrollListView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                this.f13384a.p(((Long) customResponsedMessage.getData()).longValue(), false);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ HorizonalScrollListView f13385a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(HorizonalScrollListView horizonalScrollListView, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {horizonalScrollListView, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13385a = horizonalScrollListView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                this.f13385a.p(((Long) customResponsedMessage.getData()).longValue(), true);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HorizonalScrollListView f13386e;

        /* loaded from: classes3.dex */
        public class a extends e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ LikeModel f13387a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ EntelechyUserLikeButton f13388b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ c f13389c;

            public a(c cVar, LikeModel likeModel, EntelechyUserLikeButton entelechyUserLikeButton) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, likeModel, entelechyUserLikeButton};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f13389c = cVar;
                this.f13387a = likeModel;
                this.f13388b = entelechyUserLikeButton;
            }

            @Override // d.a.d.a.e
            public void c(Object obj) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                    if ((obj instanceof w) && this.f13387a.getErrorCode() == 0) {
                        w wVar = (w) obj;
                        wVar.v(1);
                        this.f13389c.f13386e.o(this.f13388b, wVar.l() == 1);
                    } else if (AntiHelper.m(this.f13387a.getErrorCode(), this.f13387a.getErrorString())) {
                        AntiHelper.u(this.f13389c.f13386e.f13378h.getPageActivity(), this.f13387a.getErrorString());
                    } else {
                        this.f13389c.f13386e.f13378h.showToast(this.f13387a.getErrorString());
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13386e = horizonalScrollListView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && ViewHelper.checkUpIsLogin(this.f13386e.getContext())) {
                String str = (String) view.getTag(R.id.tag_forum_name);
                String valueOf = String.valueOf(view.getTag(R.id.tag_forum_id));
                EntelechyUserLikeButton entelechyUserLikeButton = (EntelechyUserLikeButton) view;
                if (k.isForumName(str)) {
                    if (!TextUtils.isEmpty(this.f13386e.k)) {
                        TiebaStatic.log(new StatisticItem(this.f13386e.k).param("obj_type", 1).param("fid", valueOf));
                    }
                    LikeModel likeModel = new LikeModel(this.f13386e.f13378h);
                    likeModel.setLoadDataCallBack(new a(this, likeModel, entelechyUserLikeButton));
                    likeModel.L(str, valueOf);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HorizonalScrollListView f13390e;

        public d(HorizonalScrollListView horizonalScrollListView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {horizonalScrollListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13390e = horizonalScrollListView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                String str = (String) view.getTag(R.id.tag_forum_name);
                String valueOf = String.valueOf(view.getTag(R.id.tag_forum_id));
                if (k.isForumName(str)) {
                    if (!TextUtils.isEmpty(this.f13390e.l)) {
                        TiebaStatic.log(new StatisticItem(this.f13390e.l).param("fid", valueOf));
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f13390e.f13378h.getPageActivity()).createNormalCfg(str, this.f13390e.getFrom())));
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f13376f = new ArrayList<>();
        this.f13377g = 3;
        this.f13379i = null;
        this.m = null;
        this.o = new a(this, 2001336);
        this.p = new b(this, 2001335);
        this.q = new c(this);
        this.r = new d(this);
        l(context);
    }

    public String getFrom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.n : (String) invokeV.objValue;
    }

    public View getLastItemView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.j : (View) invokeV.objValue;
    }

    public final View h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? View.inflate(this.f13378h.getPageActivity(), R.layout.widget_hot_forum_list_item, null) : (View) invokeV.objValue;
    }

    public final void i(ItemViewHolder itemViewHolder) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, itemViewHolder) == null) || itemViewHolder == null) {
            return;
        }
        this.j = itemViewHolder.a();
        itemViewHolder.f13383d.setVisibility(8);
        itemViewHolder.f13381b.setText(this.f13378h.getPageActivity().getResources().getString(R.string.recommend_frs_hot_thread_more));
        itemViewHolder.f13382c.setVisibility(8);
        itemViewHolder.f13380a.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        SkinManager.setImageResource(itemViewHolder.f13380a, R.drawable.icon_pic_more);
        SkinManager.setViewTextColor(itemViewHolder.f13381b, R.color.CAM_X0105, 1);
        SkinManager.setBackgroundResource(itemViewHolder.f13380a, R.drawable.selector_load_more_bg);
        this.j.setClickable(true);
        this.j.setOnClickListener(this.f13379i);
    }

    public final void j(View view, d.a.p0.d1.g.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048582, this, view, aVar) == null) || aVar == null || view == null || view.getTag() == null) {
            return;
        }
        ItemViewHolder itemViewHolder = (ItemViewHolder) view.getTag();
        itemViewHolder.f13380a.setTag(aVar.f52308b);
        itemViewHolder.f13380a.M(aVar.f52308b, 10, false);
        itemViewHolder.f13381b.setText(aVar.f52309c);
        itemViewHolder.f13381b.setTag(R.id.tag_forum_id, Long.valueOf(aVar.f52310d));
        itemViewHolder.f13382c.setDefaultBgResource(0);
        itemViewHolder.f13382c.setDefaultResource(0);
        itemViewHolder.f13383d.setTag(R.id.tag_forum_id, Long.valueOf(aVar.f52310d));
        itemViewHolder.f13383d.setTag(R.id.tag_forum_name, aVar.f52309c);
        itemViewHolder.a().setTag(R.id.tag_forum_id, Long.valueOf(aVar.f52310d));
        itemViewHolder.a().setTag(R.id.tag_forum_name, aVar.f52309c);
        o(itemViewHolder.f13383d, aVar.f52311e);
        int i2 = aVar.f52307a;
        if (i2 == 1) {
            itemViewHolder.f13382c.setVisibility(0);
            SkinManager.setImageResource(itemViewHolder.f13382c, R.drawable.icon_grade_shaitu1);
        } else if (i2 == 2) {
            itemViewHolder.f13382c.setVisibility(0);
            SkinManager.setImageResource(itemViewHolder.f13382c, R.drawable.icon_grade_shaitu2);
        } else if (i2 != 3) {
            itemViewHolder.f13382c.setVisibility(8);
        } else {
            itemViewHolder.f13382c.setVisibility(0);
            SkinManager.setImageResource(itemViewHolder.f13382c, R.drawable.icon_grade_shaitu3);
        }
        n(view, aVar);
    }

    @SuppressLint({"ResourceAsColor"})
    public final void k(ItemViewHolder itemViewHolder, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048583, this, itemViewHolder, i2) == null) || itemViewHolder == null || itemViewHolder.a() == null) {
            return;
        }
        if (itemViewHolder.f13383d.getTag(R.id.forum_follow) != null && (itemViewHolder.f13383d.getTag(R.id.forum_follow) instanceof Boolean)) {
            o(itemViewHolder.f13383d, ((Boolean) itemViewHolder.f13383d.getTag(R.id.forum_follow)).booleanValue());
        }
        SkinManager.setViewTextColor(itemViewHolder.f13381b, R.color.CAM_X0105, 1);
    }

    public final void l(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context) == null) {
            setHorizontalFadingEdgeEnabled(false);
            setVerticalFadingEdgeEnabled(false);
            setHorizontalScrollBarEnabled(false);
            setVerticalScrollBarEnabled(false);
            LinearLayout linearLayout = new LinearLayout(context);
            this.f13375e = linearLayout;
            linearLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
            this.f13375e.setOrientation(0);
            addView(this.f13375e);
        }
    }

    public void m(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048585, this, i2) == null) || this.f13377g == i2) {
            return;
        }
        Iterator<ItemViewHolder> it = this.f13376f.iterator();
        while (it.hasNext()) {
            ItemViewHolder next = it.next();
            if (next != null) {
                k(next, i2);
            }
        }
        View view = this.j;
        if (view != null) {
            BarImageView barImageView = (BarImageView) view.findViewById(R.id.forum_avatar);
            SkinManager.setBackgroundResource(barImageView, R.drawable.selector_load_more_bg);
            SkinManager.setImageResource(barImageView, R.drawable.icon_pic_more);
            SkinManager.setViewTextColor((TextView) this.j.findViewById(R.id.m_forum_name_textview), R.color.CAM_X0105, 1);
        }
        int count = ListUtils.getCount(this.f13376f);
        for (int i3 = 0; i3 < 3 && i3 < count; i3++) {
            ItemViewHolder itemViewHolder = (ItemViewHolder) ListUtils.getItem(this.f13376f, i3);
            if (itemViewHolder != null) {
                int i4 = i3 + 1;
                if (i4 == 1) {
                    SkinManager.setImageResource(itemViewHolder.f13382c, R.drawable.icon_grade_shaitu1);
                } else if (i4 == 2) {
                    SkinManager.setImageResource(itemViewHolder.f13382c, R.drawable.icon_grade_shaitu2);
                } else if (i4 == 3) {
                    SkinManager.setImageResource(itemViewHolder.f13382c, R.drawable.icon_grade_shaitu3);
                }
            }
        }
        this.f13377g = i2;
    }

    public final void n(View view, d.a.p0.d1.g.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048586, this, view, aVar) == null) || view == null || view.getTag() == null || aVar == null) {
            return;
        }
        ItemViewHolder itemViewHolder = (ItemViewHolder) view.getTag();
        itemViewHolder.f13383d.setClickable(true);
        itemViewHolder.f13383d.setOnClickListener(this.q);
        view.setClickable(true);
        view.setOnClickListener(this.r);
    }

    @SuppressLint({"ResourceAsColor"})
    public final void o(EntelechyUserLikeButton entelechyUserLikeButton, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048587, this, entelechyUserLikeButton, z) == null) || entelechyUserLikeButton == null) {
            return;
        }
        entelechyUserLikeButton.setTag(R.id.forum_follow, Boolean.valueOf(z));
        entelechyUserLikeButton.h(z);
    }

    public final void p(long j, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Long.valueOf(j), Boolean.valueOf(z)}) == null) {
            Iterator<ItemViewHolder> it = this.f13376f.iterator();
            while (it.hasNext()) {
                ItemViewHolder next = it.next();
                if (next != null && next.a() != null && next.f13381b.getTag(R.id.tag_forum_id) != null) {
                    EntelechyUserLikeButton entelechyUserLikeButton = next.f13383d;
                    if (((Long) next.f13381b.getTag(R.id.tag_forum_id)).longValue() == j) {
                        o(entelechyUserLikeButton, z);
                        return;
                    }
                }
            }
        }
    }

    public void setData(List<d.a.p0.d1.g.a> list, TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048589, this, list, tbPageContext) == null) || ListUtils.getCount(list) <= 0 || tbPageContext == null) {
            return;
        }
        this.f13378h = tbPageContext;
        list.add(new d.a.p0.d1.g.a());
        int count = ListUtils.getCount(this.f13376f);
        int count2 = ListUtils.getCount(list);
        if (count > count2) {
            for (int i2 = 0; i2 < count - count2; i2++) {
                TypeAdapter.ViewHolder viewHolder = (TypeAdapter.ViewHolder) ListUtils.getItem(this.f13376f, i2);
                if (viewHolder != null) {
                    this.f13375e.removeView(viewHolder.a());
                }
                this.f13376f.remove(viewHolder);
            }
        }
        for (int i3 = 0; i3 < count2; i3++) {
            d.a.p0.d1.g.a aVar = (d.a.p0.d1.g.a) ListUtils.getItem(list, i3);
            ItemViewHolder itemViewHolder = (ItemViewHolder) ListUtils.getItem(this.f13376f, i3);
            if (itemViewHolder != null) {
                j(itemViewHolder.a(), aVar);
            } else {
                View h2 = h();
                if (h2 != null) {
                    ItemViewHolder itemViewHolder2 = new ItemViewHolder(h2);
                    this.f13376f.add(itemViewHolder2);
                    j(itemViewHolder2.a(), aVar);
                    this.f13375e.addView(h2);
                }
            }
            int i4 = count2 - 1;
            if (i3 == i4) {
                i(this.f13376f.get(i4));
            }
        }
        this.f13378h.registerListener(this.o);
        this.f13378h.registerListener(this.p);
        if (getTag() != null) {
            this.o.setTag(getTag());
            this.p.setTag(getTag());
        }
        m(this.f13377g);
    }

    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            this.n = str;
        }
    }

    public void setLoadMoreClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, onClickListener) == null) {
            this.f13379i = onClickListener;
        }
    }

    public void setStatKey(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, str, str2) == null) {
            this.k = str;
            this.l = str2;
        }
    }

    public void setTag(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, bdUniqueId) == null) {
            this.m = bdUniqueId;
            if (bdUniqueId == null) {
                return;
            }
            CustomMessageListener customMessageListener = this.p;
            if (customMessageListener != null) {
                customMessageListener.setTag(bdUniqueId);
            }
            CustomMessageListener customMessageListener2 = this.o;
            if (customMessageListener2 != null) {
                customMessageListener2.setTag(this.m);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.view.View
    public BdUniqueId getTag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.m : (BdUniqueId) invokeV.objValue;
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
        this.f13376f = new ArrayList<>();
        this.f13377g = 3;
        this.f13379i = null;
        this.m = null;
        this.o = new a(this, 2001336);
        this.p = new b(this, 2001335);
        this.q = new c(this);
        this.r = new d(this);
        l(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HorizonalScrollListView(Context context, AttributeSet attributeSet, int i2) {
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
        this.f13376f = new ArrayList<>();
        this.f13377g = 3;
        this.f13379i = null;
        this.m = null;
        this.o = new a(this, 2001336);
        this.p = new b(this, 2001335);
        this.q = new c(this);
        this.r = new d(this);
        l(context);
    }
}
