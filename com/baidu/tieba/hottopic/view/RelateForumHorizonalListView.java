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
import b.a.e.e.p.k;
import b.a.r0.j1.e;
import b.a.r0.j1.f;
import b.a.r0.j1.h;
import b.a.r0.l3.x;
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
/* loaded from: classes9.dex */
public class RelateForumHorizonalListView extends MyHorizontalScrollView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f50070e;

    /* renamed from: f  reason: collision with root package name */
    public final ArrayList<ItemViewHolder> f50071f;

    /* renamed from: g  reason: collision with root package name */
    public int f50072g;

    /* renamed from: h  reason: collision with root package name */
    public TbPageContext<?> f50073h;

    /* renamed from: i  reason: collision with root package name */
    public View.OnClickListener f50074i;
    public View j;
    public BdUniqueId k;
    public String l;
    public CustomMessageListener m;
    public CustomMessageListener n;
    public View.OnClickListener o;
    public View.OnClickListener p;

    /* loaded from: classes9.dex */
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

    /* loaded from: classes9.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ RelateForumHorizonalListView f50075a;

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
            this.f50075a = relateForumHorizonalListView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                this.f50075a.l(((Long) customResponsedMessage.getData()).longValue(), false);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ RelateForumHorizonalListView f50076a;

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
            this.f50076a = relateForumHorizonalListView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                this.f50076a.l(((Long) customResponsedMessage.getData()).longValue(), true);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ RelateForumHorizonalListView f50077e;

        /* loaded from: classes9.dex */
        public class a extends b.a.e.a.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ LikeModel f50078a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ TextView f50079b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ c f50080c;

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
                this.f50080c = cVar;
                this.f50078a = likeModel;
                this.f50079b = textView;
            }

            @Override // b.a.e.a.e
            public void c(Object obj) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                    if ((obj instanceof x) && this.f50078a.getErrorCode() == 0) {
                        x xVar = (x) obj;
                        xVar.v(1);
                        this.f50080c.f50077e.k(this.f50079b, xVar.l() == 1);
                    } else if (AntiHelper.m(this.f50078a.getErrorCode(), this.f50078a.getErrorString())) {
                        AntiHelper.u(this.f50080c.f50077e.f50073h.getPageActivity(), this.f50078a.getErrorString());
                    } else {
                        this.f50080c.f50077e.f50073h.showToast(this.f50078a.getErrorString());
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
            this.f50077e = relateForumHorizonalListView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (!ViewHelper.checkUpIsLogin(this.f50077e.getContext())) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
                    return;
                }
                String str2 = (String) view.getTag(e.tag_forum_name);
                String valueOf = String.valueOf(view.getTag(e.tag_forum_id));
                TextView textView = (TextView) view;
                if (k.isForumName(str2)) {
                    Object orignalPage = this.f50077e.f50073h.getOrignalPage();
                    String str3 = "";
                    if (orignalPage instanceof HotTopicActivity) {
                        HotTopicActivity hotTopicActivity = (HotTopicActivity) orignalPage;
                        str3 = hotTopicActivity.getTopicName();
                        str = hotTopicActivity.getHotTopicId();
                    } else {
                        str = "";
                    }
                    TiebaStatic.log(new StatisticItem("c10815").param("obj_locate", 2).param("obj_name", str3).param("topic_id", str));
                    LikeModel likeModel = new LikeModel(this.f50077e.f50073h);
                    likeModel.setLoadDataCallBack(new a(this, likeModel, textView));
                    likeModel.L(str2, valueOf);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ RelateForumHorizonalListView f50081e;

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
            this.f50081e = relateForumHorizonalListView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                String str2 = (String) view.getTag(e.tag_forum_name);
                if (k.isForumName(str2)) {
                    Object orignalPage = this.f50081e.f50073h.getOrignalPage();
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
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f50081e.f50073h.getPageActivity()).createNormalCfg(str2, this.f50081e.getFrom())));
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
        this.f50071f = new ArrayList<>();
        this.f50072g = 3;
        this.f50074i = null;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? View.inflate(this.f50073h.getPageActivity(), f.extend_forum_item, null) : (View) invokeV.objValue;
    }

    @SuppressLint({"ResourceAsColor"})
    public final void e(ItemViewHolder itemViewHolder) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, itemViewHolder) == null) || itemViewHolder == null) {
            return;
        }
        this.j = itemViewHolder.getView();
        itemViewHolder.mAddLoveBtnTextView.setVisibility(8);
        itemViewHolder.mForumNameTextView.setText(this.f50073h.getPageActivity().getResources().getString(h.recommend_frs_hot_thread_more));
        itemViewHolder.mForumAvatarImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        SkinManager.setImageResource(itemViewHolder.mForumAvatarImageView, b.a.r0.j1.d.icon_pic_more);
        SkinManager.setViewTextColor(itemViewHolder.mForumNameTextView, b.a.r0.j1.b.CAM_X0105, 1);
        SkinManager.setBackgroundResource(itemViewHolder.mForumAvatarImageView, b.a.r0.j1.d.selector_load_more_bg);
        this.j.setClickable(true);
        this.j.setOnClickListener(this.f50074i);
    }

    public final void f(View view, b.a.q0.f1.g.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view, aVar) == null) || aVar == null || view == null || view.getTag() == null) {
            return;
        }
        ItemViewHolder itemViewHolder = (ItemViewHolder) view.getTag();
        itemViewHolder.mForumAvatarImageView.setTag(aVar.f12325b);
        itemViewHolder.mForumAvatarImageView.startLoad(aVar.f12325b, 10, false);
        itemViewHolder.mForumNameTextView.setText(g(aVar.f12326c, 8));
        itemViewHolder.mForumNameTextView.setTag(e.tag_forum_id, Long.valueOf(aVar.f12327d));
        itemViewHolder.mAddLoveBtnTextView.setTag(e.tag_forum_id, Long.valueOf(aVar.f12327d));
        itemViewHolder.mAddLoveBtnTextView.setTag(e.tag_forum_name, aVar.f12326c);
        itemViewHolder.getView().setTag(e.tag_forum_id, Long.valueOf(aVar.f12327d));
        itemViewHolder.getView().setTag(e.tag_forum_name, aVar.f12326c);
        k(itemViewHolder.mAddLoveBtnTextView, aVar.f12328e);
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
            if (this.f50073h != null) {
                return substring + this.f50073h.getString(h.ellipsis);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.j : (View) invokeV.objValue;
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
        SkinManager.setViewTextColor(itemViewHolder.mForumNameTextView, b.a.r0.j1.b.CAM_X0105, 1);
    }

    public final void i(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, context) == null) {
            setHorizontalFadingEdgeEnabled(false);
            setVerticalFadingEdgeEnabled(false);
            setHorizontalScrollBarEnabled(false);
            setVerticalScrollBarEnabled(false);
            LinearLayout linearLayout = new LinearLayout(context);
            this.f50070e = linearLayout;
            linearLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
            this.f50070e.setOrientation(0);
            addView(this.f50070e);
        }
    }

    public final void j(View view, b.a.q0.f1.g.a aVar) {
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
                SkinManager.setViewTextColor(textView, b.a.r0.j1.b.CAM_X0109, 1);
                textView.setText(TbadkCoreApplication.getInst().getString(h.relate_forum_is_followed));
                textView.setBackgroundDrawable(null);
                textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                textView.setPadding(0, 0, 0, 0);
                return;
            }
            SkinManager.setViewTextColor(textView, b.a.r0.j1.b.btn_forum_focus_color, 1);
            textView.setText(TbadkCoreApplication.getInst().getString(h.attention));
            textView.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(b.a.r0.j1.d.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
            textView.setEnabled(true);
            textView.setPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(b.a.r0.j1.c.ds18), 0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(b.a.r0.j1.c.ds10), 0);
        }
    }

    public final void l(long j, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Long.valueOf(j), Boolean.valueOf(z)}) == null) {
            Iterator<ItemViewHolder> it = this.f50071f.iterator();
            while (it.hasNext()) {
                ItemViewHolder next = it.next();
                if (next != null && next.getView() != null && next.mForumNameTextView.getTag(e.tag_forum_id) != null) {
                    TextView textView = next.mAddLoveBtnTextView;
                    if (((Long) next.mForumNameTextView.getTag(e.tag_forum_id)).longValue() == j) {
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
        if (!(interceptable == null || interceptable.invokeI(1048589, this, i2) == null) || this.f50072g == i2) {
            return;
        }
        Iterator<ItemViewHolder> it = this.f50071f.iterator();
        while (it.hasNext()) {
            ItemViewHolder next = it.next();
            if (next != null) {
                h(next, i2);
            }
        }
        View view = this.j;
        if (view != null) {
            BarImageView barImageView = (BarImageView) view.findViewById(e.forum_avatar);
            SkinManager.setBackgroundResource(barImageView, b.a.r0.j1.d.selector_load_more_bg);
            SkinManager.setImageResource(barImageView, b.a.r0.j1.d.icon_pic_more);
            SkinManager.setViewTextColor((TextView) this.j.findViewById(e.m_forum_name_textview), b.a.r0.j1.b.CAM_X0105, 1);
        }
        this.f50072g = i2;
    }

    public void setData(List<b.a.q0.f1.g.a> list, TbPageContext<?> tbPageContext, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(1048590, this, list, tbPageContext, z) == null) || ListUtils.getCount(list) <= 0 || tbPageContext == null) {
            return;
        }
        this.f50073h = tbPageContext;
        if (z) {
            list.add(new b.a.q0.f1.g.a());
        }
        int count = ListUtils.getCount(this.f50071f);
        int count2 = ListUtils.getCount(list);
        if (count > count2) {
            for (int i2 = 0; i2 < count - count2; i2++) {
                TypeAdapter.ViewHolder viewHolder = (TypeAdapter.ViewHolder) ListUtils.getItem(this.f50071f, i2);
                if (viewHolder != null) {
                    this.f50070e.removeView(viewHolder.getView());
                }
                this.f50071f.remove(viewHolder);
            }
        }
        for (int i3 = 0; i3 < count2; i3++) {
            b.a.q0.f1.g.a aVar = (b.a.q0.f1.g.a) ListUtils.getItem(list, i3);
            ItemViewHolder itemViewHolder = (ItemViewHolder) ListUtils.getItem(this.f50071f, i3);
            if (itemViewHolder != null) {
                f(itemViewHolder.getView(), aVar);
            } else {
                View d2 = d();
                if (d2 != null) {
                    ItemViewHolder itemViewHolder2 = new ItemViewHolder(d2);
                    this.f50071f.add(itemViewHolder2);
                    f(itemViewHolder2.getView(), aVar);
                    this.f50070e.addView(d2);
                }
            }
            int i4 = count2 - 1;
            if (i3 == i4 && z) {
                e(this.f50071f.get(i4));
            }
        }
        this.f50073h.registerListener(this.m);
        this.f50073h.registerListener(this.n);
        if (getTag() != null) {
            this.m.setTag(getTag());
            this.n.setTag(getTag());
        }
        onSkinTypeChanged(this.f50072g);
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
            this.f50074i = onClickListener;
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
        this.f50071f = new ArrayList<>();
        this.f50072g = 3;
        this.f50074i = null;
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
        this.f50071f = new ArrayList<>();
        this.f50072g = 3;
        this.f50074i = null;
        this.k = null;
        this.m = new a(this, 2001336);
        this.n = new b(this, 2001335);
        this.o = new c(this);
        this.p = new d(this);
        i(context);
    }
}
