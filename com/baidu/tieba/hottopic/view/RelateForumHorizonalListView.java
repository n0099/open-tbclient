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
import c.a.d.f.p.m;
import c.a.t0.q1.e;
import c.a.t0.q1.f;
import c.a.t0.q1.h;
import c.a.t0.w3.x;
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
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
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
public class RelateForumHorizonalListView extends MyHorizontalScrollView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f44711e;

    /* renamed from: f  reason: collision with root package name */
    public final ArrayList<ItemViewHolder> f44712f;

    /* renamed from: g  reason: collision with root package name */
    public int f44713g;

    /* renamed from: h  reason: collision with root package name */
    public TbPageContext<?> f44714h;

    /* renamed from: i  reason: collision with root package name */
    public View.OnClickListener f44715i;

    /* renamed from: j  reason: collision with root package name */
    public View f44716j;
    public BdUniqueId k;
    public String l;
    public CustomMessageListener m;
    public CustomMessageListener n;
    public View.OnClickListener o;
    public View.OnClickListener p;

    /* loaded from: classes12.dex */
    public static class ItemViewHolder extends TypeAdapter.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView mAddLoveBtnTextView;
        public BarImageView mForumAvatarImageView;
        public TextView mForumNameTextView;

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
            this.mAddLoveBtnTextView = null;
            BarImageView barImageView = (BarImageView) view.findViewById(e.forum_avatar);
            this.mForumAvatarImageView = barImageView;
            barImageView.setGifIconSupport(false);
            this.mForumNameTextView = (TextView) view.findViewById(e.m_forum_name_textview);
            this.mAddLoveBtnTextView = (TextView) view.findViewById(e.forum_add_love);
        }
    }

    /* loaded from: classes12.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RelateForumHorizonalListView a;

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
            this.a = relateForumHorizonalListView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                this.a.l(((Long) customResponsedMessage.getData()).longValue(), false);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RelateForumHorizonalListView a;

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
            this.a = relateForumHorizonalListView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                this.a.l(((Long) customResponsedMessage.getData()).longValue(), true);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ RelateForumHorizonalListView f44717e;

        /* loaded from: classes12.dex */
        public class a extends c.a.d.a.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ LikeModel a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ TextView f44718b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ c f44719c;

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
                this.f44719c = cVar;
                this.a = likeModel;
                this.f44718b = textView;
            }

            @Override // c.a.d.a.e
            public void c(Object obj) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                    if ((obj instanceof x) && this.a.getErrorCode() == 0) {
                        x xVar = (x) obj;
                        xVar.v(1);
                        this.f44719c.f44717e.k(this.f44718b, xVar.l() == 1);
                    } else if (AntiHelper.m(this.a.getErrorCode(), this.a.getErrorString())) {
                        AntiHelper.u(this.f44719c.f44717e.f44714h.getPageActivity(), this.a.getErrorString());
                    } else {
                        this.f44719c.f44717e.f44714h.showToast(this.a.getErrorString());
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
            this.f44717e = relateForumHorizonalListView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (!ViewHelper.checkUpIsLogin(this.f44717e.getContext())) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
                    return;
                }
                String str2 = (String) view.getTag(e.tag_forum_name);
                String valueOf = String.valueOf(view.getTag(e.tag_forum_id));
                TextView textView = (TextView) view;
                if (m.isForumName(str2)) {
                    Object orignalPage = this.f44717e.f44714h.getOrignalPage();
                    String str3 = "";
                    if (orignalPage instanceof HotTopicActivity) {
                        HotTopicActivity hotTopicActivity = (HotTopicActivity) orignalPage;
                        str3 = hotTopicActivity.getTopicName();
                        str = hotTopicActivity.getHotTopicId();
                    } else {
                        str = "";
                    }
                    TiebaStatic.log(new StatisticItem("c10815").param("obj_locate", 2).param("obj_name", str3).param("topic_id", str));
                    LikeModel likeModel = new LikeModel(this.f44717e.f44714h);
                    likeModel.setLoadDataCallBack(new a(this, likeModel, textView));
                    likeModel.L(str2, valueOf);
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ RelateForumHorizonalListView f44720e;

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
            this.f44720e = relateForumHorizonalListView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                String str2 = (String) view.getTag(e.tag_forum_name);
                if (m.isForumName(str2)) {
                    Object orignalPage = this.f44720e.f44714h.getOrignalPage();
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
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f44720e.f44714h.getPageActivity()).createNormalCfg(str2, this.f44720e.getFrom())));
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
        this.f44712f = new ArrayList<>();
        this.f44713g = 3;
        this.f44715i = null;
        this.k = null;
        this.m = new a(this, 2001336);
        this.n = new b(this, 2001335);
        this.o = new c(this);
        this.p = new d(this);
        i(context);
    }

    public final View d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? View.inflate(this.f44714h.getPageActivity(), f.extend_forum_item, null) : (View) invokeV.objValue;
    }

    @SuppressLint({"ResourceAsColor"})
    public final void e(ItemViewHolder itemViewHolder) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, itemViewHolder) == null) || itemViewHolder == null) {
            return;
        }
        this.f44716j = itemViewHolder.getView();
        itemViewHolder.mAddLoveBtnTextView.setVisibility(8);
        itemViewHolder.mForumNameTextView.setText(this.f44714h.getPageActivity().getResources().getString(h.recommend_frs_hot_thread_more));
        itemViewHolder.mForumAvatarImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        SkinManager.setImageResource(itemViewHolder.mForumAvatarImageView, c.a.t0.q1.d.icon_pic_more);
        SkinManager.setViewTextColor(itemViewHolder.mForumNameTextView, c.a.t0.q1.b.CAM_X0105, 1);
        SkinManager.setBackgroundResource(itemViewHolder.mForumAvatarImageView, c.a.t0.q1.d.selector_load_more_bg);
        this.f44716j.setClickable(true);
        this.f44716j.setOnClickListener(this.f44715i);
    }

    public final void f(View view, c.a.s0.g1.g.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view, aVar) == null) || aVar == null || view == null || view.getTag() == null) {
            return;
        }
        ItemViewHolder itemViewHolder = (ItemViewHolder) view.getTag();
        itemViewHolder.mForumAvatarImageView.setTag(aVar.f12576b);
        itemViewHolder.mForumAvatarImageView.startLoad(aVar.f12576b, 10, false);
        itemViewHolder.mForumNameTextView.setText(g(aVar.f12577c, 8));
        itemViewHolder.mForumNameTextView.setTag(e.tag_forum_id, Long.valueOf(aVar.f12578d));
        itemViewHolder.mAddLoveBtnTextView.setTag(e.tag_forum_id, Long.valueOf(aVar.f12578d));
        itemViewHolder.mAddLoveBtnTextView.setTag(e.tag_forum_name, aVar.f12577c);
        itemViewHolder.getView().setTag(e.tag_forum_id, Long.valueOf(aVar.f12578d));
        itemViewHolder.getView().setTag(e.tag_forum_name, aVar.f12577c);
        k(itemViewHolder.mAddLoveBtnTextView, aVar.f12579e);
        j(view, aVar);
    }

    public final String g(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, str, i2)) == null) {
            if (StringUtils.isNull(str)) {
                return "";
            }
            if (str.length() <= i2) {
                return str;
            }
            String substring = str.substring(0, i2 - 1);
            if (this.f44714h != null) {
                return substring + this.f44714h.getString(h.ellipsis);
            }
            return substring;
        }
        return (String) invokeLI.objValue;
    }

    public String getFrom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.l : (String) invokeV.objValue;
    }

    public View getLastItemView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f44716j : (View) invokeV.objValue;
    }

    @SuppressLint({"ResourceAsColor"})
    public final void h(ItemViewHolder itemViewHolder, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, itemViewHolder, i2) == null) || itemViewHolder == null || itemViewHolder.getView() == null) {
            return;
        }
        if (itemViewHolder.mAddLoveBtnTextView.getTag(e.forum_follow) != null && (itemViewHolder.mAddLoveBtnTextView.getTag(e.forum_follow) instanceof Boolean)) {
            k(itemViewHolder.mAddLoveBtnTextView, ((Boolean) itemViewHolder.mAddLoveBtnTextView.getTag(e.forum_follow)).booleanValue());
        }
        SkinManager.setViewTextColor(itemViewHolder.mForumNameTextView, c.a.t0.q1.b.CAM_X0105, 1);
    }

    public final void i(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, context) == null) {
            setHorizontalFadingEdgeEnabled(false);
            setVerticalFadingEdgeEnabled(false);
            setHorizontalScrollBarEnabled(false);
            setVerticalScrollBarEnabled(false);
            LinearLayout linearLayout = new LinearLayout(context);
            this.f44711e = linearLayout;
            linearLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
            this.f44711e.setOrientation(0);
            addView(this.f44711e);
        }
    }

    public final void j(View view, c.a.s0.g1.g.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048586, this, view, aVar) == null) || view == null || view.getTag() == null || aVar == null) {
            return;
        }
        ItemViewHolder itemViewHolder = (ItemViewHolder) view.getTag();
        itemViewHolder.mAddLoveBtnTextView.setClickable(true);
        itemViewHolder.mAddLoveBtnTextView.setOnClickListener(this.o);
        view.setClickable(true);
        view.setOnClickListener(this.p);
    }

    @SuppressLint({"ResourceAsColor"})
    public final void k(TextView textView, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048587, this, textView, z) == null) {
            textView.setTag(e.forum_follow, Boolean.valueOf(z));
            if (z) {
                textView.setEnabled(false);
                SkinManager.setViewTextColor(textView, c.a.t0.q1.b.CAM_X0109, 1);
                textView.setText(TbadkCoreApplication.getInst().getString(h.relate_forum_is_followed));
                textView.setBackgroundDrawable(null);
                textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                textView.setPadding(0, 0, 0, 0);
                return;
            }
            SkinManager.setViewTextColor(textView, c.a.t0.q1.b.btn_forum_focus_color, 1);
            textView.setText(TbadkCoreApplication.getInst().getString(h.attention));
            textView.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(c.a.t0.q1.d.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
            textView.setEnabled(true);
            textView.setPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(c.a.t0.q1.c.ds18), 0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(c.a.t0.q1.c.ds10), 0);
        }
    }

    public final void l(long j2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Long.valueOf(j2), Boolean.valueOf(z)}) == null) {
            Iterator<ItemViewHolder> it = this.f44712f.iterator();
            while (it.hasNext()) {
                ItemViewHolder next = it.next();
                if (next != null && next.getView() != null && next.mForumNameTextView.getTag(e.tag_forum_id) != null) {
                    TextView textView = next.mAddLoveBtnTextView;
                    if (((Long) next.mForumNameTextView.getTag(e.tag_forum_id)).longValue() == j2) {
                        k(textView, z);
                        return;
                    }
                }
            }
        }
    }

    @SuppressLint({"ResourceAsColor"})
    public void onSkinTypeChanged(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048589, this, i2) == null) || this.f44713g == i2) {
            return;
        }
        Iterator<ItemViewHolder> it = this.f44712f.iterator();
        while (it.hasNext()) {
            ItemViewHolder next = it.next();
            if (next != null) {
                h(next, i2);
            }
        }
        View view = this.f44716j;
        if (view != null) {
            BarImageView barImageView = (BarImageView) view.findViewById(e.forum_avatar);
            SkinManager.setBackgroundResource(barImageView, c.a.t0.q1.d.selector_load_more_bg);
            SkinManager.setImageResource(barImageView, c.a.t0.q1.d.icon_pic_more);
            SkinManager.setViewTextColor((TextView) this.f44716j.findViewById(e.m_forum_name_textview), c.a.t0.q1.b.CAM_X0105, 1);
        }
        this.f44713g = i2;
    }

    public void setData(List<c.a.s0.g1.g.a> list, TbPageContext<?> tbPageContext, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(1048590, this, list, tbPageContext, z) == null) || ListUtils.getCount(list) <= 0 || tbPageContext == null) {
            return;
        }
        this.f44714h = tbPageContext;
        if (z) {
            list.add(new c.a.s0.g1.g.a());
        }
        int count = ListUtils.getCount(this.f44712f);
        int count2 = ListUtils.getCount(list);
        if (count > count2) {
            for (int i2 = 0; i2 < count - count2; i2++) {
                TypeAdapter.ViewHolder viewHolder = (TypeAdapter.ViewHolder) ListUtils.getItem(this.f44712f, i2);
                if (viewHolder != null) {
                    this.f44711e.removeView(viewHolder.getView());
                }
                this.f44712f.remove(viewHolder);
            }
        }
        for (int i3 = 0; i3 < count2; i3++) {
            c.a.s0.g1.g.a aVar = (c.a.s0.g1.g.a) ListUtils.getItem(list, i3);
            ItemViewHolder itemViewHolder = (ItemViewHolder) ListUtils.getItem(this.f44712f, i3);
            if (itemViewHolder != null) {
                f(itemViewHolder.getView(), aVar);
            } else {
                View d2 = d();
                if (d2 != null) {
                    ItemViewHolder itemViewHolder2 = new ItemViewHolder(d2);
                    this.f44712f.add(itemViewHolder2);
                    f(itemViewHolder2.getView(), aVar);
                    this.f44711e.addView(d2);
                }
            }
            int i4 = count2 - 1;
            if (i3 == i4 && z) {
                e(this.f44712f.get(i4));
            }
        }
        this.f44714h.registerListener(this.m);
        this.f44714h.registerListener(this.n);
        if (getTag() != null) {
            this.m.setTag(getTag());
            this.n.setTag(getTag());
        }
        onSkinTypeChanged(this.f44713g);
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
            this.f44715i = onClickListener;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.k : (BdUniqueId) invokeV.objValue;
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
        this.f44712f = new ArrayList<>();
        this.f44713g = 3;
        this.f44715i = null;
        this.k = null;
        this.m = new a(this, 2001336);
        this.n = new b(this, 2001335);
        this.o = new c(this);
        this.p = new d(this);
        i(context);
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
        this.f44712f = new ArrayList<>();
        this.f44713g = 3;
        this.f44715i = null;
        this.k = null;
        this.m = new a(this, 2001336);
        this.n = new b(this, 2001335);
        this.o = new c(this);
        this.p = new d(this);
        i(context);
    }
}
