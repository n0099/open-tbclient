package com.baidu.tieba.hottopic.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
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
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.widget.horizonalScrollListView.MyHorizontalScrollView;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.a.e;
import d.a.c.e.p.k;
import d.a.s0.h3.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes5.dex */
public class RelateForumHorizonalListView extends MyHorizontalScrollView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f17155e;

    /* renamed from: f  reason: collision with root package name */
    public final ArrayList<ItemViewHolder> f17156f;

    /* renamed from: g  reason: collision with root package name */
    public int f17157g;

    /* renamed from: h  reason: collision with root package name */
    public TbPageContext<?> f17158h;

    /* renamed from: i  reason: collision with root package name */
    public View.OnClickListener f17159i;
    public View j;
    public BdUniqueId k;
    public String l;
    public CustomMessageListener m;
    public CustomMessageListener n;
    public View.OnClickListener o;
    public View.OnClickListener p;

    /* loaded from: classes5.dex */
    public static class ItemViewHolder extends TypeAdapter.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public BarImageView f17160a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f17161b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f17162c;

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
            this.f17160a = null;
            this.f17161b = null;
            this.f17162c = null;
            BarImageView barImageView = (BarImageView) view.findViewById(R.id.forum_avatar);
            this.f17160a = barImageView;
            barImageView.setGifIconSupport(false);
            this.f17161b = (TextView) view.findViewById(R.id.m_forum_name_textview);
            this.f17162c = (TextView) view.findViewById(R.id.forum_add_love);
        }
    }

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ RelateForumHorizonalListView f17163a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(RelateForumHorizonalListView relateForumHorizonalListView, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {relateForumHorizonalListView, Integer.valueOf(i2)};
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
            this.f17163a = relateForumHorizonalListView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                this.f17163a.o(((Long) customResponsedMessage.getData()).longValue(), false);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ RelateForumHorizonalListView f17164a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(RelateForumHorizonalListView relateForumHorizonalListView, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {relateForumHorizonalListView, Integer.valueOf(i2)};
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
            this.f17164a = relateForumHorizonalListView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                this.f17164a.o(((Long) customResponsedMessage.getData()).longValue(), true);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ RelateForumHorizonalListView f17165e;

        /* loaded from: classes5.dex */
        public class a extends e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ LikeModel f17166a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ TextView f17167b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ c f17168c;

            public a(c cVar, LikeModel likeModel, TextView textView) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, likeModel, textView};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f17168c = cVar;
                this.f17166a = likeModel;
                this.f17167b = textView;
            }

            @Override // d.a.c.a.e
            public void c(Object obj) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                    if ((obj instanceof w) && this.f17166a.getErrorCode() == 0) {
                        w wVar = (w) obj;
                        wVar.v(1);
                        this.f17168c.f17165e.n(this.f17167b, wVar.l() == 1);
                    } else if (AntiHelper.m(this.f17166a.getErrorCode(), this.f17166a.getErrorString())) {
                        AntiHelper.u(this.f17168c.f17165e.f17158h.getPageActivity(), this.f17166a.getErrorString());
                    } else {
                        this.f17168c.f17165e.f17158h.showToast(this.f17166a.getErrorString());
                    }
                }
            }
        }

        public c(RelateForumHorizonalListView relateForumHorizonalListView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {relateForumHorizonalListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17165e = relateForumHorizonalListView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (!ViewHelper.checkUpIsLogin(this.f17165e.getContext())) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
                    return;
                }
                String str2 = (String) view.getTag(R.id.tag_forum_name);
                String valueOf = String.valueOf(view.getTag(R.id.tag_forum_id));
                TextView textView = (TextView) view;
                if (k.isForumName(str2)) {
                    Object orignalPage = this.f17165e.f17158h.getOrignalPage();
                    String str3 = "";
                    if (orignalPage instanceof HotTopicActivity) {
                        HotTopicActivity hotTopicActivity = (HotTopicActivity) orignalPage;
                        str3 = hotTopicActivity.getTopicName();
                        str = hotTopicActivity.getHotTopicId();
                    } else {
                        str = "";
                    }
                    TiebaStatic.log(new StatisticItem("c10815").param("obj_locate", 2).param("obj_name", str3).param("topic_id", str));
                    LikeModel likeModel = new LikeModel(this.f17165e.f17158h);
                    likeModel.setLoadDataCallBack(new a(this, likeModel, textView));
                    likeModel.L(str2, valueOf);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ RelateForumHorizonalListView f17169e;

        public d(RelateForumHorizonalListView relateForumHorizonalListView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {relateForumHorizonalListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17169e = relateForumHorizonalListView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                String str2 = (String) view.getTag(R.id.tag_forum_name);
                if (k.isForumName(str2)) {
                    Object orignalPage = this.f17169e.f17158h.getOrignalPage();
                    String str3 = "";
                    if (orignalPage instanceof HotTopicActivity) {
                        HotTopicActivity hotTopicActivity = (HotTopicActivity) orignalPage;
                        str3 = hotTopicActivity.getTopicName();
                        str = hotTopicActivity.getHotTopicId();
                    } else {
                        str = "";
                    }
                    TiebaStatic.log(new StatisticItem("c10815").param("obj_locate", 1).param("obj_name", str3).param("topic_id", str));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f17169e.f17158h.getPageActivity()).createNormalCfg(str2, this.f17169e.getFrom())));
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RelateForumHorizonalListView(Context context) {
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
        this.f17156f = new ArrayList<>();
        this.f17157g = 3;
        this.f17159i = null;
        this.k = null;
        this.m = new a(this, 2001336);
        this.n = new b(this, 2001335);
        this.o = new c(this);
        this.p = new d(this);
        k(context);
    }

    public final View f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? View.inflate(this.f17158h.getPageActivity(), R.layout.extend_forum_item, null) : (View) invokeV.objValue;
    }

    @SuppressLint({"ResourceAsColor"})
    public final void g(ItemViewHolder itemViewHolder) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, itemViewHolder) == null) || itemViewHolder == null) {
            return;
        }
        this.j = itemViewHolder.a();
        itemViewHolder.f17162c.setVisibility(8);
        itemViewHolder.f17161b.setText(this.f17158h.getPageActivity().getResources().getString(R.string.recommend_frs_hot_thread_more));
        itemViewHolder.f17160a.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        SkinManager.setImageResource(itemViewHolder.f17160a, R.drawable.icon_pic_more);
        SkinManager.setViewTextColor(itemViewHolder.f17161b, R.color.CAM_X0105, 1);
        SkinManager.setBackgroundResource(itemViewHolder.f17160a, R.drawable.selector_load_more_bg);
        this.j.setClickable(true);
        this.j.setOnClickListener(this.f17159i);
    }

    public String getFrom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.l : (String) invokeV.objValue;
    }

    public View getLastItemView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.j : (View) invokeV.objValue;
    }

    public final void h(View view, d.a.r0.b1.g.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048582, this, view, aVar) == null) || aVar == null || view == null || view.getTag() == null) {
            return;
        }
        ItemViewHolder itemViewHolder = (ItemViewHolder) view.getTag();
        itemViewHolder.f17160a.setTag(aVar.f54940b);
        itemViewHolder.f17160a.M(aVar.f54940b, 10, false);
        itemViewHolder.f17161b.setText(i(aVar.f54941c, 8));
        itemViewHolder.f17161b.setTag(R.id.tag_forum_id, Long.valueOf(aVar.f54942d));
        itemViewHolder.f17162c.setTag(R.id.tag_forum_id, Long.valueOf(aVar.f54942d));
        itemViewHolder.f17162c.setTag(R.id.tag_forum_name, aVar.f54941c);
        itemViewHolder.a().setTag(R.id.tag_forum_id, Long.valueOf(aVar.f54942d));
        itemViewHolder.a().setTag(R.id.tag_forum_name, aVar.f54941c);
        n(itemViewHolder.f17162c, aVar.f54943e);
        m(view, aVar);
    }

    public final String i(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048583, this, str, i2)) == null) {
            if (StringUtils.isNull(str)) {
                return "";
            }
            if (str.length() <= i2) {
                return str;
            }
            String substring = str.substring(0, i2 - 1);
            if (this.f17158h != null) {
                return substring + this.f17158h.getString(R.string.ellipsis);
            }
            return substring;
        }
        return (String) invokeLI.objValue;
    }

    @SuppressLint({"ResourceAsColor"})
    public final void j(ItemViewHolder itemViewHolder, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, itemViewHolder, i2) == null) || itemViewHolder == null || itemViewHolder.a() == null) {
            return;
        }
        if (itemViewHolder.f17162c.getTag(R.id.forum_follow) != null && (itemViewHolder.f17162c.getTag(R.id.forum_follow) instanceof Boolean)) {
            n(itemViewHolder.f17162c, ((Boolean) itemViewHolder.f17162c.getTag(R.id.forum_follow)).booleanValue());
        }
        SkinManager.setViewTextColor(itemViewHolder.f17161b, R.color.CAM_X0105, 1);
    }

    public final void k(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, context) == null) {
            setHorizontalFadingEdgeEnabled(false);
            setVerticalFadingEdgeEnabled(false);
            setHorizontalScrollBarEnabled(false);
            setVerticalScrollBarEnabled(false);
            LinearLayout linearLayout = new LinearLayout(context);
            this.f17155e = linearLayout;
            linearLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
            this.f17155e.setOrientation(0);
            addView(this.f17155e);
        }
    }

    @SuppressLint({"ResourceAsColor"})
    public void l(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048586, this, i2) == null) || this.f17157g == i2) {
            return;
        }
        Iterator<ItemViewHolder> it = this.f17156f.iterator();
        while (it.hasNext()) {
            ItemViewHolder next = it.next();
            if (next != null) {
                j(next, i2);
            }
        }
        View view = this.j;
        if (view != null) {
            BarImageView barImageView = (BarImageView) view.findViewById(R.id.forum_avatar);
            SkinManager.setBackgroundResource(barImageView, R.drawable.selector_load_more_bg);
            SkinManager.setImageResource(barImageView, R.drawable.icon_pic_more);
            SkinManager.setViewTextColor((TextView) this.j.findViewById(R.id.m_forum_name_textview), R.color.CAM_X0105, 1);
        }
        this.f17157g = i2;
    }

    public final void m(View view, d.a.r0.b1.g.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048587, this, view, aVar) == null) || view == null || view.getTag() == null || aVar == null) {
            return;
        }
        ItemViewHolder itemViewHolder = (ItemViewHolder) view.getTag();
        itemViewHolder.f17162c.setClickable(true);
        itemViewHolder.f17162c.setOnClickListener(this.o);
        view.setClickable(true);
        view.setOnClickListener(this.p);
    }

    @SuppressLint({"ResourceAsColor"})
    public final void n(TextView textView, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048588, this, textView, z) == null) {
            textView.setTag(R.id.forum_follow, Boolean.valueOf(z));
            if (z) {
                textView.setEnabled(false);
                SkinManager.setViewTextColor(textView, R.color.CAM_X0109, 1);
                textView.setText(TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed));
                textView.setBackgroundDrawable(null);
                textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                textView.setPadding(0, 0, 0, 0);
                return;
            }
            SkinManager.setViewTextColor(textView, R.color.btn_forum_focus_color, 1);
            textView.setText(TbadkCoreApplication.getInst().getString(R.string.attention));
            textView.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(R.drawable.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
            textView.setEnabled(true);
            textView.setPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds18), 0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds10), 0);
        }
    }

    public final void o(long j, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Long.valueOf(j), Boolean.valueOf(z)}) == null) {
            Iterator<ItemViewHolder> it = this.f17156f.iterator();
            while (it.hasNext()) {
                ItemViewHolder next = it.next();
                if (next != null && next.a() != null && next.f17161b.getTag(R.id.tag_forum_id) != null) {
                    TextView textView = next.f17162c;
                    if (((Long) next.f17161b.getTag(R.id.tag_forum_id)).longValue() == j) {
                        n(textView, z);
                        return;
                    }
                }
            }
        }
    }

    public void setData(List<d.a.r0.b1.g.a> list, TbPageContext<?> tbPageContext, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(1048590, this, list, tbPageContext, z) == null) || ListUtils.getCount(list) <= 0 || tbPageContext == null) {
            return;
        }
        this.f17158h = tbPageContext;
        if (z) {
            list.add(new d.a.r0.b1.g.a());
        }
        int count = ListUtils.getCount(this.f17156f);
        int count2 = ListUtils.getCount(list);
        if (count > count2) {
            for (int i2 = 0; i2 < count - count2; i2++) {
                TypeAdapter.ViewHolder viewHolder = (TypeAdapter.ViewHolder) ListUtils.getItem(this.f17156f, i2);
                if (viewHolder != null) {
                    this.f17155e.removeView(viewHolder.a());
                }
                this.f17156f.remove(viewHolder);
            }
        }
        for (int i3 = 0; i3 < count2; i3++) {
            d.a.r0.b1.g.a aVar = (d.a.r0.b1.g.a) ListUtils.getItem(list, i3);
            ItemViewHolder itemViewHolder = (ItemViewHolder) ListUtils.getItem(this.f17156f, i3);
            if (itemViewHolder != null) {
                h(itemViewHolder.a(), aVar);
            } else {
                View f2 = f();
                if (f2 != null) {
                    ItemViewHolder itemViewHolder2 = new ItemViewHolder(f2);
                    this.f17156f.add(itemViewHolder2);
                    h(itemViewHolder2.a(), aVar);
                    this.f17155e.addView(f2);
                }
            }
            int i4 = count2 - 1;
            if (i3 == i4 && z) {
                g(this.f17156f.get(i4));
            }
        }
        this.f17158h.registerListener(this.m);
        this.f17158h.registerListener(this.n);
        if (getTag() != null) {
            this.m.setTag(getTag());
            this.n.setTag(getTag());
        }
        l(this.f17157g);
    }

    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            this.l = str;
        }
    }

    public void setLoadMoreClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, onClickListener) == null) {
            this.f17159i = onClickListener;
        }
    }

    public void setTag(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, bdUniqueId) == null) {
            this.k = bdUniqueId;
            if (bdUniqueId == null) {
                return;
            }
            CustomMessageListener customMessageListener = this.n;
            if (customMessageListener != null) {
                customMessageListener.setTag(bdUniqueId);
            }
            CustomMessageListener customMessageListener2 = this.m;
            if (customMessageListener2 != null) {
                customMessageListener2.setTag(this.k);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.view.View
    public BdUniqueId getTag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.k : (BdUniqueId) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RelateForumHorizonalListView(Context context, AttributeSet attributeSet) {
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
        this.f17156f = new ArrayList<>();
        this.f17157g = 3;
        this.f17159i = null;
        this.k = null;
        this.m = new a(this, 2001336);
        this.n = new b(this, 2001335);
        this.o = new c(this);
        this.p = new d(this);
        k(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RelateForumHorizonalListView(Context context, AttributeSet attributeSet, int i2) {
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
        this.f17156f = new ArrayList<>();
        this.f17157g = 3;
        this.f17159i = null;
        this.k = null;
        this.m = new a(this, 2001336);
        this.n = new b(this, 2001335);
        this.o = new c(this);
        this.p = new d(this);
        k(context);
    }
}
