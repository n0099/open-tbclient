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
import c.a.u0.z3.y;
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
/* loaded from: classes12.dex */
public class HorizonalScrollListView extends MyHorizontalScrollView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f41529e;

    /* renamed from: f  reason: collision with root package name */
    public final ArrayList<ItemViewHolder> f41530f;

    /* renamed from: g  reason: collision with root package name */
    public int f41531g;

    /* renamed from: h  reason: collision with root package name */
    public TbPageContext<?> f41532h;

    /* renamed from: i  reason: collision with root package name */
    public View.OnClickListener f41533i;

    /* renamed from: j  reason: collision with root package name */
    public View f41534j;
    public String k;
    public String l;
    public BdUniqueId m;
    public String n;
    public CustomMessageListener o;
    public CustomMessageListener p;
    public View.OnClickListener q;
    public View.OnClickListener r;

    /* loaded from: classes12.dex */
    public static class ItemViewHolder extends TypeAdapter.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public EntelechyUserLikeButton mAddLoveBtnTextView;
        public BarImageView mForumAvatarImageView;
        public TextView mForumNameTextView;
        public TbImageView mForumRankImageView;

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
            this.mForumAvatarImageView = null;
            this.mForumNameTextView = null;
            this.mForumRankImageView = null;
            this.mAddLoveBtnTextView = null;
            BarImageView barImageView = (BarImageView) view.findViewById(R.id.forum_avatar);
            this.mForumAvatarImageView = barImageView;
            barImageView.setGifIconSupport(false);
            this.mForumNameTextView = (TextView) view.findViewById(R.id.m_forum_name_textview);
            this.mForumRankImageView = (TbImageView) view.findViewById(R.id.hot_rank);
            this.mAddLoveBtnTextView = (EntelechyUserLikeButton) view.findViewById(R.id.forum_add_love);
        }
    }

    /* loaded from: classes12.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HorizonalScrollListView a;

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
            this.a = horizonalScrollListView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                this.a.m(((Long) customResponsedMessage.getData()).longValue(), false);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HorizonalScrollListView a;

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
            this.a = horizonalScrollListView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                this.a.m(((Long) customResponsedMessage.getData()).longValue(), true);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HorizonalScrollListView f41535e;

        /* loaded from: classes12.dex */
        public class a extends e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ LikeModel a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ EntelechyUserLikeButton f41536b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ c f41537c;

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
                this.f41537c = cVar;
                this.a = likeModel;
                this.f41536b = entelechyUserLikeButton;
            }

            @Override // c.a.d.a.e
            public void c(Object obj) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                    if ((obj instanceof y) && this.a.getErrorCode() == 0) {
                        y yVar = (y) obj;
                        yVar.x(1);
                        this.f41537c.f41535e.l(this.f41536b, yVar.m() == 1);
                    } else if (AntiHelper.m(this.a.getErrorCode(), this.a.getErrorString())) {
                        AntiHelper.u(this.f41537c.f41535e.f41532h.getPageActivity(), this.a.getErrorString());
                    } else {
                        this.f41537c.f41535e.f41532h.showToast(this.a.getErrorString());
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
            this.f41535e = horizonalScrollListView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && ViewHelper.checkUpIsLogin(this.f41535e.getContext())) {
                String str = (String) view.getTag(R.id.tag_forum_name);
                String valueOf = String.valueOf(view.getTag(R.id.tag_forum_id));
                EntelechyUserLikeButton entelechyUserLikeButton = (EntelechyUserLikeButton) view;
                if (m.isForumName(str)) {
                    if (!TextUtils.isEmpty(this.f41535e.k)) {
                        TiebaStatic.log(new StatisticItem(this.f41535e.k).param("obj_type", 1).param("fid", valueOf));
                    }
                    LikeModel likeModel = new LikeModel(this.f41535e.f41532h);
                    likeModel.setLoadDataCallBack(new a(this, likeModel, entelechyUserLikeButton));
                    likeModel.N(str, valueOf);
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HorizonalScrollListView f41538e;

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
            this.f41538e = horizonalScrollListView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                String str = (String) view.getTag(R.id.tag_forum_name);
                String valueOf = String.valueOf(view.getTag(R.id.tag_forum_id));
                if (m.isForumName(str)) {
                    if (!TextUtils.isEmpty(this.f41538e.l)) {
                        TiebaStatic.log(new StatisticItem(this.f41538e.l).param("fid", valueOf));
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f41538e.f41532h.getPageActivity()).createNormalCfg(str, this.f41538e.getFrom())));
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
        this.f41530f = new ArrayList<>();
        this.f41531g = 3;
        this.f41533i = null;
        this.m = null;
        this.o = new a(this, 2001336);
        this.p = new b(this, 2001335);
        this.q = new c(this);
        this.r = new d(this);
        j(context);
    }

    public final View f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? View.inflate(this.f41532h.getPageActivity(), R.layout.widget_hot_forum_list_item, null) : (View) invokeV.objValue;
    }

    public final void g(ItemViewHolder itemViewHolder) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, itemViewHolder) == null) || itemViewHolder == null) {
            return;
        }
        this.f41534j = itemViewHolder.getView();
        itemViewHolder.mAddLoveBtnTextView.setVisibility(8);
        itemViewHolder.mForumNameTextView.setText(this.f41532h.getPageActivity().getResources().getString(R.string.recommend_frs_hot_thread_more));
        itemViewHolder.mForumRankImageView.setVisibility(8);
        itemViewHolder.mForumAvatarImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        SkinManager.setImageResource(itemViewHolder.mForumAvatarImageView, R.drawable.icon_pic_more);
        SkinManager.setViewTextColor(itemViewHolder.mForumNameTextView, R.color.CAM_X0105, 1);
        SkinManager.setBackgroundResource(itemViewHolder.mForumAvatarImageView, R.drawable.selector_load_more_bg);
        this.f41534j.setClickable(true);
        this.f41534j.setOnClickListener(this.f41533i);
    }

    public String getFrom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.n : (String) invokeV.objValue;
    }

    public View getLastItemView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f41534j : (View) invokeV.objValue;
    }

    public final void h(View view, c.a.t0.f1.g.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048582, this, view, aVar) == null) || aVar == null || view == null || view.getTag() == null) {
            return;
        }
        ItemViewHolder itemViewHolder = (ItemViewHolder) view.getTag();
        itemViewHolder.mForumAvatarImageView.setTag(aVar.f12945b);
        itemViewHolder.mForumAvatarImageView.startLoad(aVar.f12945b, 10, false);
        itemViewHolder.mForumNameTextView.setText(aVar.f12946c);
        itemViewHolder.mForumNameTextView.setTag(R.id.tag_forum_id, Long.valueOf(aVar.f12947d));
        itemViewHolder.mForumRankImageView.setDefaultBgResource(0);
        itemViewHolder.mForumRankImageView.setDefaultResource(0);
        itemViewHolder.mAddLoveBtnTextView.setTag(R.id.tag_forum_id, Long.valueOf(aVar.f12947d));
        itemViewHolder.mAddLoveBtnTextView.setTag(R.id.tag_forum_name, aVar.f12946c);
        itemViewHolder.getView().setTag(R.id.tag_forum_id, Long.valueOf(aVar.f12947d));
        itemViewHolder.getView().setTag(R.id.tag_forum_name, aVar.f12946c);
        l(itemViewHolder.mAddLoveBtnTextView, aVar.f12948e);
        int i2 = aVar.a;
        if (i2 == 1) {
            itemViewHolder.mForumRankImageView.setVisibility(0);
            SkinManager.setImageResource(itemViewHolder.mForumRankImageView, R.drawable.icon_grade_shaitu1);
        } else if (i2 == 2) {
            itemViewHolder.mForumRankImageView.setVisibility(0);
            SkinManager.setImageResource(itemViewHolder.mForumRankImageView, R.drawable.icon_grade_shaitu2);
        } else if (i2 != 3) {
            itemViewHolder.mForumRankImageView.setVisibility(8);
        } else {
            itemViewHolder.mForumRankImageView.setVisibility(0);
            SkinManager.setImageResource(itemViewHolder.mForumRankImageView, R.drawable.icon_grade_shaitu3);
        }
        k(view, aVar);
    }

    @SuppressLint({"ResourceAsColor"})
    public final void i(ItemViewHolder itemViewHolder, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048583, this, itemViewHolder, i2) == null) || itemViewHolder == null || itemViewHolder.getView() == null) {
            return;
        }
        if (itemViewHolder.mAddLoveBtnTextView.getTag(R.id.forum_follow) != null && (itemViewHolder.mAddLoveBtnTextView.getTag(R.id.forum_follow) instanceof Boolean)) {
            l(itemViewHolder.mAddLoveBtnTextView, ((Boolean) itemViewHolder.mAddLoveBtnTextView.getTag(R.id.forum_follow)).booleanValue());
        }
        SkinManager.setViewTextColor(itemViewHolder.mForumNameTextView, R.color.CAM_X0105, 1);
    }

    public final void j(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context) == null) {
            setHorizontalFadingEdgeEnabled(false);
            setVerticalFadingEdgeEnabled(false);
            setHorizontalScrollBarEnabled(false);
            setVerticalScrollBarEnabled(false);
            LinearLayout linearLayout = new LinearLayout(context);
            this.f41529e = linearLayout;
            linearLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
            this.f41529e.setOrientation(0);
            addView(this.f41529e);
        }
    }

    public final void k(View view, c.a.t0.f1.g.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048585, this, view, aVar) == null) || view == null || view.getTag() == null || aVar == null) {
            return;
        }
        ItemViewHolder itemViewHolder = (ItemViewHolder) view.getTag();
        itemViewHolder.mAddLoveBtnTextView.setClickable(true);
        itemViewHolder.mAddLoveBtnTextView.setOnClickListener(this.q);
        view.setClickable(true);
        view.setOnClickListener(this.r);
    }

    @SuppressLint({"ResourceAsColor"})
    public final void l(EntelechyUserLikeButton entelechyUserLikeButton, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048586, this, entelechyUserLikeButton, z) == null) || entelechyUserLikeButton == null) {
            return;
        }
        entelechyUserLikeButton.setTag(R.id.forum_follow, Boolean.valueOf(z));
        entelechyUserLikeButton.updateLikeStatus(z);
    }

    public final void m(long j2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Long.valueOf(j2), Boolean.valueOf(z)}) == null) {
            Iterator<ItemViewHolder> it = this.f41530f.iterator();
            while (it.hasNext()) {
                ItemViewHolder next = it.next();
                if (next != null && next.getView() != null && next.mForumNameTextView.getTag(R.id.tag_forum_id) != null) {
                    EntelechyUserLikeButton entelechyUserLikeButton = next.mAddLoveBtnTextView;
                    if (((Long) next.mForumNameTextView.getTag(R.id.tag_forum_id)).longValue() == j2) {
                        l(entelechyUserLikeButton, z);
                        return;
                    }
                }
            }
        }
    }

    public void onSkinTypeChanged(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048588, this, i2) == null) || this.f41531g == i2) {
            return;
        }
        Iterator<ItemViewHolder> it = this.f41530f.iterator();
        while (it.hasNext()) {
            ItemViewHolder next = it.next();
            if (next != null) {
                i(next, i2);
            }
        }
        View view = this.f41534j;
        if (view != null) {
            BarImageView barImageView = (BarImageView) view.findViewById(R.id.forum_avatar);
            SkinManager.setBackgroundResource(barImageView, R.drawable.selector_load_more_bg);
            SkinManager.setImageResource(barImageView, R.drawable.icon_pic_more);
            SkinManager.setViewTextColor((TextView) this.f41534j.findViewById(R.id.m_forum_name_textview), R.color.CAM_X0105, 1);
        }
        int count = ListUtils.getCount(this.f41530f);
        for (int i3 = 0; i3 < 3 && i3 < count; i3++) {
            ItemViewHolder itemViewHolder = (ItemViewHolder) ListUtils.getItem(this.f41530f, i3);
            if (itemViewHolder != null) {
                int i4 = i3 + 1;
                if (i4 == 1) {
                    SkinManager.setImageResource(itemViewHolder.mForumRankImageView, R.drawable.icon_grade_shaitu1);
                } else if (i4 == 2) {
                    SkinManager.setImageResource(itemViewHolder.mForumRankImageView, R.drawable.icon_grade_shaitu2);
                } else if (i4 == 3) {
                    SkinManager.setImageResource(itemViewHolder.mForumRankImageView, R.drawable.icon_grade_shaitu3);
                }
            }
        }
        this.f41531g = i2;
    }

    public void setData(List<c.a.t0.f1.g.a> list, TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048589, this, list, tbPageContext) == null) || ListUtils.getCount(list) <= 0 || tbPageContext == null) {
            return;
        }
        this.f41532h = tbPageContext;
        list.add(new c.a.t0.f1.g.a());
        int count = ListUtils.getCount(this.f41530f);
        int count2 = ListUtils.getCount(list);
        if (count > count2) {
            for (int i2 = 0; i2 < count - count2; i2++) {
                TypeAdapter.ViewHolder viewHolder = (TypeAdapter.ViewHolder) ListUtils.getItem(this.f41530f, i2);
                if (viewHolder != null) {
                    this.f41529e.removeView(viewHolder.getView());
                }
                this.f41530f.remove(viewHolder);
            }
        }
        for (int i3 = 0; i3 < count2; i3++) {
            c.a.t0.f1.g.a aVar = (c.a.t0.f1.g.a) ListUtils.getItem(list, i3);
            ItemViewHolder itemViewHolder = (ItemViewHolder) ListUtils.getItem(this.f41530f, i3);
            if (itemViewHolder != null) {
                h(itemViewHolder.getView(), aVar);
            } else {
                View f2 = f();
                if (f2 != null) {
                    ItemViewHolder itemViewHolder2 = new ItemViewHolder(f2);
                    this.f41530f.add(itemViewHolder2);
                    h(itemViewHolder2.getView(), aVar);
                    this.f41529e.addView(f2);
                }
            }
            int i4 = count2 - 1;
            if (i3 == i4) {
                g(this.f41530f.get(i4));
            }
        }
        this.f41532h.registerListener(this.o);
        this.f41532h.registerListener(this.p);
        if (getTag() != null) {
            this.o.setTag(getTag());
            this.p.setTag(getTag());
        }
        onSkinTypeChanged(this.f41531g);
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
            this.f41533i = onClickListener;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.m : (BdUniqueId) invokeV.objValue;
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
        this.f41530f = new ArrayList<>();
        this.f41531g = 3;
        this.f41533i = null;
        this.m = null;
        this.o = new a(this, 2001336);
        this.p = new b(this, 2001335);
        this.q = new c(this);
        this.r = new d(this);
        j(context);
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
        this.f41530f = new ArrayList<>();
        this.f41531g = 3;
        this.f41533i = null;
        this.m = null;
        this.o = new a(this, 2001336);
        this.p = new b(this, 2001335);
        this.q = new c(this);
        this.r = new d(this);
        j(context);
    }
}
