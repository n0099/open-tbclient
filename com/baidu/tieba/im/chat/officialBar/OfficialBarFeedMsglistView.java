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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdTypeListView;
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
import d.b.c.a.d;
import d.b.c.e.p.l;
import d.b.h0.z0.f0;
import d.b.h0.z0.h0;
import d.b.i0.e1.f.j.f;
import d.b.i0.e1.l.c.a;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
/* loaded from: classes4.dex */
public class OfficialBarFeedMsglistView extends d<OfficialBarFeedActivity> implements OfficialBarFeedMsglistAdapter.c {

    /* renamed from: e  reason: collision with root package name */
    public BaseActivity<OfficialBarFeedActivity> f17511e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<OfficialBarFeedActivity> f17512f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f17513g;

    /* renamed from: h  reason: collision with root package name */
    public OfficialBarFeedMsglistAdapter f17514h;
    public RecyclerView i;
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
        public a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            super.getItemOffsets(rect, view, recyclerView, state);
            if (recyclerView.getChildLayoutPosition(view) == 0) {
                rect.left = l.g(OfficialBarFeedMsglistView.this.mContext.getPageActivity(), R.dimen.tbds19);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends f0<Void> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f17516a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ long f17517b;

        public b(OfficialBarFeedMsglistView officialBarFeedMsglistView, String str, long j) {
            this.f17516a = str;
            this.f17517b = j;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.z0.f0
        /* renamed from: a */
        public Void doInBackground() {
            if (StringUtils.isNull(this.f17516a)) {
                return null;
            }
            d.b.i0.e1.h.l.t().w(Long.parseLong(this.f17516a), this.f17517b);
            return null;
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            OfficialBarFeedMsglistView officialBarFeedMsglistView = OfficialBarFeedMsglistView.this;
            officialBarFeedMsglistView.g(view, officialBarFeedMsglistView.f17512f.getPageActivity());
        }
    }

    public OfficialBarFeedMsglistView(BaseActivity<OfficialBarFeedActivity> baseActivity) {
        this(baseActivity, false);
    }

    @Override // com.baidu.tieba.im.chat.officialBar.OfficialBarFeedMsglistAdapter.c
    public void a(View view, Object obj, int i, long j) {
        if (obj instanceof OfficialBarFeedMsglistAdapter.a) {
            OfficialBarFeedMsglistAdapter.a aVar = (OfficialBarFeedMsglistAdapter.a) obj;
            SingleForumBroadcastFeedActivityConfig singleForumBroadcastFeedActivityConfig = new SingleForumBroadcastFeedActivityConfig(this.f17512f.getPageActivity(), String.valueOf(aVar.d()), aVar.c());
            singleForumBroadcastFeedActivityConfig.setSource((byte) 1);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, singleForumBroadcastFeedActivityConfig));
            StatisticItem statisticItem = new StatisticItem("c13862");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("fid", aVar.d());
            TiebaStatic.log(statisticItem);
        } else if (obj instanceof a.C1266a) {
            f((a.C1266a) obj, this.f17512f.getPageActivity());
        }
    }

    public final void f(a.C1266a c1266a, Context context) {
        if (c1266a == null) {
            return;
        }
        q(c1266a.f55433e, System.currentTimeMillis());
        if (StringUtils.isNull(c1266a.f55432d)) {
            return;
        }
        if (c1266a.f55432d.startsWith("web:http")) {
            c1266a.f55432d = c1266a.f55432d.replaceFirst(UrlSchemaHelper.SCHEMA_TYPE_WEB, "");
        }
        if (c1266a.f55432d.contains("?")) {
            c1266a.f55432d = String.format(Locale.US, "%s&broadcast_id=%d", c1266a.f55432d, Long.valueOf(c1266a.f55436h));
        } else {
            c1266a.f55432d = String.format(Locale.US, "%s?broadcast_id=%d", c1266a.f55432d, Long.valueOf(c1266a.f55436h));
        }
        if (c1266a.f55432d.contains(UrlSchemaHelper.SCHEMA_TYPE_DEEPLINK_TOPIC)) {
            try {
                context.startActivity(Intent.parseUri(c1266a.f55432d, 1));
            } catch (URISyntaxException e2) {
                e2.printStackTrace();
            }
        }
        if (!URLUtil.isHttpUrl(c1266a.f55432d) && !URLUtil.isHttpsUrl(c1266a.f55432d) && !c1266a.f55432d.startsWith(UrlSchemaHelper.SCHEMA_TB_FLUTTER)) {
            Uri parse = Uri.parse(c1266a.f55432d);
            if (parse != null) {
                UtilHelper.dealOneScheme(context, parse.toString());
            }
        } else {
            UrlManager.getInstance().dealOneLink(this.f17512f, new String[]{c1266a.f55432d});
        }
        StatisticItem statisticItem = new StatisticItem(this.s ? "c13866" : "c13864");
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        statisticItem.param("fid", c1266a.f55433e);
        String str = c1266a.n;
        statisticItem.param("tid", str != null ? str : "");
        TiebaStatic.log(statisticItem);
    }

    public void g(View view, Activity activity) {
        if (view == this.f17513g) {
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

    public final void h() {
        NoDataView noDataView = this.v;
        if (noDataView == null || noDataView.getVisibility() != 0) {
            return;
        }
        this.v.setVisibility(8);
    }

    public final void i(BaseActivity<OfficialBarFeedActivity> baseActivity) {
        String string;
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
        this.f17513g = imageView;
        imageView.setClickable(true);
        this.f17513g.setOnClickListener(this.x);
    }

    public final void k(BaseActivity baseActivity) {
        this.w = (FrameLayout) baseActivity.findViewById(R.id.layout_main);
        BdTypeListView bdTypeListView = (BdTypeListView) baseActivity.findViewById(R.id.lis_msg);
        this.r = bdTypeListView;
        if (this.s) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) bdTypeListView.getLayoutParams();
            layoutParams.topMargin = l.g(this.mContext.getPageActivity(), R.dimen.tbds_7);
            this.r.setLayoutParams(layoutParams);
        }
        f fVar = new f(this.f17512f, this.r, this);
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
            this.i = recyclerView;
            recyclerView.setLayoutManager(new LinearLayoutManager(baseActivity, 0, false));
            OfficialBarFeedMsglistAdapter officialBarFeedMsglistAdapter = new OfficialBarFeedMsglistAdapter(baseActivity.getPageContext(), this);
            this.f17514h = officialBarFeedMsglistAdapter;
            this.i.setAdapter(officialBarFeedMsglistAdapter);
            this.i.setClipChildren(false);
            this.i.addItemDecoration(new a(), 0);
        }
        this.r.setAdapter((ListAdapter) this.q);
    }

    public void l(List<d.b.i0.e1.l.c.b> list, List<d.b.i0.e1.h.o.a> list2) {
        this.q.c(list);
        if (this.s) {
            BdTypeListView bdTypeListView = this.r;
            bdTypeListView.setSelection(bdTypeListView.getBottom());
        }
        this.f17511e.hideLoadingView(this.p);
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
        ArrayList<? extends d.b.h0.g0.b.a> arrayList = new ArrayList<>(10);
        for (int i = 0; i < 10 && i < list2.size(); i++) {
            d.b.i0.e1.h.o.a aVar = list2.get(i);
            OfficialBarFeedMsglistAdapter.a aVar2 = new OfficialBarFeedMsglistAdapter.a();
            aVar2.h(aVar.c());
            aVar2.i(aVar.a());
            aVar2.m(aVar.d());
            aVar2.n(aVar.e());
            aVar2.j(Long.parseLong(aVar.b()));
            aVar2.o(aVar.f());
            arrayList.add(aVar2);
        }
        this.f17514h.d(arrayList);
        if (this.o == null || this.r.getHeaderViewsCount() > 0) {
            return;
        }
        this.r.addHeaderView(this.o);
    }

    public void m(LongSparseArray<d.b.i0.e1.i.a.b.b> longSparseArray) {
        if (longSparseArray == null || longSparseArray.size() <= 0) {
            return;
        }
        this.q.e(longSparseArray);
    }

    public final void n(int i) {
        if (this.v == null) {
            this.v = NoDataViewFactory.a(this.f17512f.getPageActivity(), this.p, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, i), NoDataViewFactory.e.a(R.string.official_feed_no_data), null);
            NoDataViewFactory.d.a aVar = new NoDataViewFactory.d.a();
            aVar.i(NoDataViewFactory.ImgType.CREATE);
            this.v.setImgOption(aVar.f());
        }
        if (this.v.getVisibility() == 0) {
            return;
        }
        this.v.f(this.f17512f, TbadkApplication.getInst().getSkinType());
        this.v.setVisibility(0);
    }

    public void o(boolean z, String str) {
        BdTopToast bdTopToast = new BdTopToast(this.f17511e);
        bdTopToast.i(z);
        bdTopToast.h(str);
        bdTopToast.j(this.p);
    }

    public void onChangeSkinType(int i) {
        this.l.onChangeSkinType(getPageContext(), i);
        this.l.onBackBtnOnChangeSkin();
        SkinManager.setViewTextColor(this.f17513g, R.color.CAM_X0302, 1);
        SkinManager.setViewTextColor(this.j, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.u, R.color.CAM_X0105);
        SkinManager.setBackgroundColor(this.w, R.color.CAM_X0204);
        if (this.k != null) {
            TBSelector.makeShadowDrawable().setBgColor(R.color.CAM_X0205).setShapeRadius(l.g(this.f17512f.getPageActivity(), R.dimen.tbds31)).setShadowColor(R.color.CAM_X0804).setShadowSide(ShadowDrawable.ALL).setShadowRadius(l.g(this.f17512f.getPageActivity(), R.dimen.tbds10)).setOffsetX(0).setOffsetY(l.g(this.f17512f.getPageActivity(), R.dimen.tbds5)).into(this.k);
        }
        NoDataView noDataView = this.v;
        if (noDataView != null) {
            noDataView.f(this.f17512f, i);
        }
        if (this.f17513g != null) {
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f17513g, R.drawable.icon_pure_more_administration44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        f fVar = this.q;
        if (fVar != null) {
            fVar.notifyDataSetChanged();
        }
    }

    public void q(String str, long j) {
        h0.c(new b(this, str, j), null);
    }

    public OfficialBarFeedMsglistView(BaseActivity<OfficialBarFeedActivity> baseActivity, boolean z) {
        super(baseActivity.getPageContext());
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = null;
        this.x = new c();
        this.f17511e = baseActivity;
        this.s = z;
        this.f17512f = baseActivity.getPageContext();
        baseActivity.setContentView(R.layout.msg_msglist_activity);
        ViewGroup viewGroup = (ViewGroup) baseActivity.findViewById(R.id.msg_root_view);
        this.p = viewGroup;
        baseActivity.showLoadingView(viewGroup);
        i(baseActivity);
        k(baseActivity);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }
}
