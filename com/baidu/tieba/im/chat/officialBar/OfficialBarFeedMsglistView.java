package com.baidu.tieba.im.chat.officialBar;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.net.Uri;
import android.util.LongSparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.OfficialBarTipActivityConfig;
import com.baidu.tbadk.core.atomData.SingleForumBroadcastFeedActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tbadk.core.util.tbselector.shadow.ShadowDrawable;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.R;
import com.baidu.tieba.im.chat.officialBar.OfficialBarFeedMsglistAdapter;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.a.d;
import d.a.c.e.p.l;
import d.a.o0.z0.f0;
import d.a.o0.z0.i0;
import d.a.p0.i1.f.j.f;
import d.a.p0.i1.l.c.a;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
/* loaded from: classes4.dex */
public class OfficialBarFeedMsglistView extends d<OfficialBarFeedActivity> implements OfficialBarFeedMsglistAdapter.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public BaseActivity<OfficialBarFeedActivity> f17382e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<OfficialBarFeedActivity> f17383f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f17384g;

    /* renamed from: h  reason: collision with root package name */
    public OfficialBarFeedMsglistAdapter f17385h;

    /* renamed from: i  reason: collision with root package name */
    public RecyclerView f17386i;
    public TextView j;
    public View k;
    public NavigationBar l;
    public View m;
    public View n;
    public View o;
    public ViewGroup p;
    public f q;
    public BdTypeListView r;
    public boolean s;
    public String t;
    public TextView u;
    public NoDataView v;
    public FrameLayout w;
    public View.OnClickListener x;

    /* loaded from: classes4.dex */
    public class a extends RecyclerView.ItemDecoration {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ OfficialBarFeedMsglistView f17387a;

        public a(OfficialBarFeedMsglistView officialBarFeedMsglistView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {officialBarFeedMsglistView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17387a = officialBarFeedMsglistView;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLL(1048576, this, rect, view, recyclerView, state) == null) {
                super.getItemOffsets(rect, view, recyclerView, state);
                if (recyclerView.getChildLayoutPosition(view) == 0) {
                    rect.left = l.g(this.f17387a.mContext.getPageActivity(), R.dimen.tbds19);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends f0<Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f17388a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ long f17389b;

        public b(OfficialBarFeedMsglistView officialBarFeedMsglistView, String str, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {officialBarFeedMsglistView, str, Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17388a = str;
            this.f17389b = j;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.o0.z0.f0
        /* renamed from: a */
        public Void doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (StringUtils.isNull(this.f17388a)) {
                    return null;
                }
                d.a.p0.i1.h.l.t().w(Long.parseLong(this.f17388a), this.f17389b);
                return null;
            }
            return (Void) invokeV.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ OfficialBarFeedMsglistView f17390e;

        public c(OfficialBarFeedMsglistView officialBarFeedMsglistView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {officialBarFeedMsglistView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17390e = officialBarFeedMsglistView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                OfficialBarFeedMsglistView officialBarFeedMsglistView = this.f17390e;
                officialBarFeedMsglistView.g(view, officialBarFeedMsglistView.f17383f.getPageActivity());
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public OfficialBarFeedMsglistView(BaseActivity<OfficialBarFeedActivity> baseActivity) {
        this(baseActivity, false);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((BaseActivity) objArr2[0], ((Boolean) objArr2[1]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.officialBar.OfficialBarFeedMsglistAdapter.c
    public void a(View view, Object obj, int i2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, obj, Integer.valueOf(i2), Long.valueOf(j)}) == null) {
            if (obj instanceof OfficialBarFeedMsglistAdapter.a) {
                OfficialBarFeedMsglistAdapter.a aVar = (OfficialBarFeedMsglistAdapter.a) obj;
                SingleForumBroadcastFeedActivityConfig singleForumBroadcastFeedActivityConfig = new SingleForumBroadcastFeedActivityConfig(this.f17383f.getPageActivity(), String.valueOf(aVar.d()), aVar.c());
                singleForumBroadcastFeedActivityConfig.setSource((byte) 1);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, singleForumBroadcastFeedActivityConfig));
                StatisticItem statisticItem = new StatisticItem("c13862");
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("fid", aVar.d());
                TiebaStatic.log(statisticItem);
            } else if (obj instanceof a.C1468a) {
                f((a.C1468a) obj, this.f17383f.getPageActivity());
            }
        }
    }

    public final void f(a.C1468a c1468a, Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, c1468a, context) == null) || c1468a == null) {
            return;
        }
        p(c1468a.f58533e, System.currentTimeMillis());
        if (StringUtils.isNull(c1468a.f58532d)) {
            return;
        }
        if (c1468a.f58532d.startsWith("web:http")) {
            c1468a.f58532d = c1468a.f58532d.replaceFirst(UrlSchemaHelper.SCHEMA_TYPE_WEB, "");
        }
        if (c1468a.f58532d.contains("?")) {
            c1468a.f58532d = String.format(Locale.US, "%s&broadcast_id=%d", c1468a.f58532d, Long.valueOf(c1468a.f58536h));
        } else {
            c1468a.f58532d = String.format(Locale.US, "%s?broadcast_id=%d", c1468a.f58532d, Long.valueOf(c1468a.f58536h));
        }
        if (c1468a.f58532d.contains(UrlSchemaHelper.SCHEMA_TYPE_DEEPLINK_TOPIC)) {
            try {
                context.startActivity(Intent.parseUri(c1468a.f58532d, 1));
            } catch (URISyntaxException e2) {
                e2.printStackTrace();
            }
        }
        if (!URLUtil.isHttpUrl(c1468a.f58532d) && !URLUtil.isHttpsUrl(c1468a.f58532d) && !c1468a.f58532d.startsWith(UrlSchemaHelper.SCHEMA_TB_FLUTTER)) {
            Uri parse = Uri.parse(c1468a.f58532d);
            if (parse != null) {
                UtilHelper.dealOneScheme(context, parse.toString());
            }
        } else {
            UrlManager.getInstance().dealOneLink(this.f17383f, new String[]{c1468a.f58532d});
        }
        StatisticItem statisticItem = new StatisticItem(this.s ? "c13866" : "c13864");
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        statisticItem.param("fid", c1468a.f58533e);
        String str = c1468a.n;
        statisticItem.param("tid", str != null ? str : "");
        TiebaStatic.log(statisticItem);
    }

    public void g(View view, Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view, activity) == null) {
            if (view == this.f17384g) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2008022, new OfficialBarTipActivityConfig(getPageContext().getPageActivity())));
            } else if (view == this.n) {
                activity.finish();
            } else if (view == this.u) {
                this.mContext.sendMessage(new CustomMessage<>(2003000, new FrsActivityConfig(this.mContext.getPageActivity()).createNormalCfg(this.t, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND).setCallFrom(3)));
                if (activity.getIntent() != null) {
                    StatisticItem statisticItem = new StatisticItem("c13867");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem.param("fid", activity.getIntent().getStringExtra("key_uid"));
                    TiebaStatic.log(statisticItem);
                }
            }
        }
    }

    public final void h() {
        NoDataView noDataView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (noDataView = this.v) != null && noDataView.getVisibility() == 0) {
            this.v.setVisibility(8);
        }
    }

    public final void j(BaseActivity<OfficialBarFeedActivity> baseActivity) {
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, baseActivity) == null) {
            NavigationBar navigationBar = (NavigationBar) baseActivity.findViewById(R.id.lay_title_bar);
            this.l = navigationBar;
            View addSystemImageButton = navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.x);
            this.n = addSystemImageButton;
            addSystemImageButton.setOnClickListener(this.x);
            this.t = baseActivity.getIntent() != null ? baseActivity.getIntent().getStringExtra("forum_name") : "";
            if (this.s) {
                string = this.t + baseActivity.getString(R.string.forum);
            } else {
                string = baseActivity.getPageContext().getString(R.string.subscribe_bar_title);
            }
            this.l.setCenterTextTitle(string);
            this.l.showBottomLine();
            if (this.s) {
                TextView addTextButton = this.l.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, baseActivity.getString(R.string.enter_forum));
                this.u = addTextButton;
                addTextButton.setOnClickListener(this.x);
                return;
            }
            View addCustomView = this.l.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.official_bar_feed_natigation_icon, this.x);
            this.m = addCustomView;
            ImageView imageView = (ImageView) addCustomView.findViewById(R.id.feed_header_icon);
            this.f17384g = imageView;
            imageView.setClickable(true);
            this.f17384g.setOnClickListener(this.x);
        }
    }

    public final void k(BaseActivity baseActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, baseActivity) == null) {
            this.w = (FrameLayout) baseActivity.findViewById(R.id.layout_main);
            BdTypeListView bdTypeListView = (BdTypeListView) baseActivity.findViewById(R.id.lis_msg);
            this.r = bdTypeListView;
            if (this.s) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) bdTypeListView.getLayoutParams();
                layoutParams.topMargin = l.g(this.mContext.getPageActivity(), R.dimen.tbds_7);
                this.r.setLayoutParams(layoutParams);
            }
            f fVar = new f(this.f17383f, this.r, this);
            this.q = fVar;
            fVar.d(this.s);
            ((ProgressBar) baseActivity.findViewById(R.id.msg_progress)).setVisibility(8);
            this.r.setItemsCanFocus(true);
            this.r.setFocusable(false);
            this.r.setFocusableInTouchMode(false);
            this.r.setClickable(false);
            if (!this.s) {
                View inflate = View.inflate(baseActivity, R.layout.official_bar_feed_header, null);
                this.o = inflate;
                this.k = inflate.findViewById(R.id.official_bar_feed_header_view);
                this.j = (TextView) this.o.findViewById(R.id.official_feed_recent);
                RecyclerView recyclerView = (RecyclerView) this.o.findViewById(R.id.official_feed_recent_recyclerview);
                this.f17386i = recyclerView;
                recyclerView.setLayoutManager(new LinearLayoutManager(baseActivity, 0, false));
                OfficialBarFeedMsglistAdapter officialBarFeedMsglistAdapter = new OfficialBarFeedMsglistAdapter(baseActivity.getPageContext(), this);
                this.f17385h = officialBarFeedMsglistAdapter;
                this.f17386i.setAdapter(officialBarFeedMsglistAdapter);
                this.f17386i.setClipChildren(false);
                this.f17386i.addItemDecoration(new a(this), 0);
            }
            this.r.setAdapter((ListAdapter) this.q);
        }
    }

    public void l(List<d.a.p0.i1.l.c.b> list, List<d.a.p0.i1.h.o.a> list2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, list, list2) == null) {
            this.q.c(list);
            if (this.s) {
                BdTypeListView bdTypeListView = this.r;
                bdTypeListView.setSelection(bdTypeListView.getBottom());
            }
            this.f17382e.hideLoadingView(this.p);
            if (!ListUtils.isEmpty(list)) {
                h();
            } else if (ListUtils.isEmpty(list2)) {
                n(454);
            } else {
                n(854);
            }
            if (ListUtils.isEmpty(list2)) {
                return;
            }
            ArrayList<? extends d.a.o0.g0.b.a> arrayList = new ArrayList<>(10);
            for (int i2 = 0; i2 < 10 && i2 < list2.size(); i2++) {
                d.a.p0.i1.h.o.a aVar = list2.get(i2);
                OfficialBarFeedMsglistAdapter.a aVar2 = new OfficialBarFeedMsglistAdapter.a();
                aVar2.g(aVar.c());
                aVar2.h(aVar.a());
                aVar2.k(aVar.d());
                aVar2.m(aVar.e());
                aVar2.j(Long.parseLong(aVar.b()));
                aVar2.o(aVar.f());
                arrayList.add(aVar2);
            }
            this.f17385h.e(arrayList);
            if (this.o == null || this.r.getHeaderViewsCount() > 0) {
                return;
            }
            this.r.addHeaderView(this.o);
        }
    }

    public void m(LongSparseArray<d.a.p0.i1.i.a.b.b> longSparseArray) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, longSparseArray) == null) || longSparseArray == null || longSparseArray.size() <= 0) {
            return;
        }
        this.q.e(longSparseArray);
    }

    public final void n(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            if (this.v == null) {
                this.v = NoDataViewFactory.a(this.f17383f.getPageActivity(), this.p, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, i2), NoDataViewFactory.e.a(R.string.official_feed_no_data), null);
                NoDataViewFactory.d.a aVar = new NoDataViewFactory.d.a();
                aVar.i(NoDataViewFactory.ImgType.CREATE);
                this.v.setImgOption(aVar.f());
            }
            if (this.v.getVisibility() == 0) {
                return;
            }
            this.v.f(this.f17383f, TbadkApplication.getInst().getSkinType());
            this.v.setVisibility(0);
        }
    }

    public void o(boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048585, this, z, str) == null) {
            BdTopToast bdTopToast = new BdTopToast(this.f17382e);
            bdTopToast.i(z);
            bdTopToast.h(str);
            bdTopToast.j(this.p);
        }
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            this.l.onChangeSkinType(getPageContext(), i2);
            this.l.onBackBtnOnChangeSkin();
            SkinManager.setViewTextColor(this.f17384g, R.color.CAM_X0302, 1);
            SkinManager.setViewTextColor(this.j, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.u, R.color.CAM_X0105);
            SkinManager.setBackgroundColor(this.w, R.color.CAM_X0204);
            if (this.k != null) {
                TBSelector.makeShadowDrawable().setBgColor(R.color.CAM_X0205).setShapeRadius(l.g(this.f17383f.getPageActivity(), R.dimen.tbds31)).setShadowColor(R.color.CAM_X0804).setShadowSide(ShadowDrawable.ALL).setShadowRadius(l.g(this.f17383f.getPageActivity(), R.dimen.tbds10)).setOffsetX(0).setOffsetY(l.g(this.f17383f.getPageActivity(), R.dimen.tbds5)).into(this.k);
            }
            NoDataView noDataView = this.v;
            if (noDataView != null) {
                noDataView.f(this.f17383f, i2);
            }
            if (this.f17384g != null) {
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f17384g, R.drawable.icon_pure_more_administration44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            f fVar = this.q;
            if (fVar != null) {
                fVar.notifyDataSetChanged();
            }
        }
    }

    public void p(String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048587, this, str, j) == null) {
            i0.c(new b(this, str, j), null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OfficialBarFeedMsglistView(BaseActivity<OfficialBarFeedActivity> baseActivity, boolean z) {
        super(baseActivity.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseActivity, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((d.a.c.a.f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = null;
        this.x = new c(this);
        this.f17382e = baseActivity;
        this.s = z;
        this.f17383f = baseActivity.getPageContext();
        baseActivity.setContentView(R.layout.msg_msglist_activity);
        ViewGroup viewGroup = (ViewGroup) baseActivity.findViewById(R.id.msg_root_view);
        this.p = viewGroup;
        baseActivity.showLoadingView(viewGroup);
        j(baseActivity);
        k(baseActivity);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }
}
