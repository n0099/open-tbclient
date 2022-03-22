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
import c.a.d.a.d;
import c.a.d.f.p.n;
import c.a.o0.c1.k0;
import c.a.o0.c1.n0;
import c.a.p0.u1.f.j.f;
import c.a.p0.u1.h.l;
import c.a.p0.u1.l.c.a;
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
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
/* loaded from: classes5.dex */
public class OfficialBarFeedMsglistView extends d<OfficialBarFeedActivity> implements OfficialBarFeedMsglistAdapter.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseActivity<OfficialBarFeedActivity> a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext<OfficialBarFeedActivity> f33720b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f33721c;

    /* renamed from: d  reason: collision with root package name */
    public OfficialBarFeedMsglistAdapter f33722d;

    /* renamed from: e  reason: collision with root package name */
    public RecyclerView f33723e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f33724f;

    /* renamed from: g  reason: collision with root package name */
    public View f33725g;

    /* renamed from: h  reason: collision with root package name */
    public NavigationBar f33726h;
    public View i;
    public View j;
    public View k;
    public ViewGroup l;
    public f m;
    public BdTypeListView n;
    public boolean o;
    public String p;
    public TextView q;
    public NoDataView r;
    public FrameLayout s;
    public View.OnClickListener t;

    /* loaded from: classes5.dex */
    public class a extends RecyclerView.ItemDecoration {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ OfficialBarFeedMsglistView a;

        public a(OfficialBarFeedMsglistView officialBarFeedMsglistView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {officialBarFeedMsglistView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = officialBarFeedMsglistView;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLL(1048576, this, rect, view, recyclerView, state) == null) {
                super.getItemOffsets(rect, view, recyclerView, state);
                if (recyclerView.getChildLayoutPosition(view) == 0) {
                    rect.left = n.f(this.a.mContext.getPageActivity(), R.dimen.tbds19);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends k0<Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ long f33727b;

        public b(OfficialBarFeedMsglistView officialBarFeedMsglistView, String str, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {officialBarFeedMsglistView, str, Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.f33727b = j;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.o0.c1.k0
        /* renamed from: a */
        public Void doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (StringUtils.isNull(this.a)) {
                    return null;
                }
                l.t().w(Long.parseLong(this.a), this.f33727b);
                return null;
            }
            return (Void) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ OfficialBarFeedMsglistView a;

        public c(OfficialBarFeedMsglistView officialBarFeedMsglistView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {officialBarFeedMsglistView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = officialBarFeedMsglistView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                OfficialBarFeedMsglistView officialBarFeedMsglistView = this.a;
                officialBarFeedMsglistView.h(view, officialBarFeedMsglistView.f33720b.getPageActivity());
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((BaseActivity) objArr2[0], ((Boolean) objArr2[1]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.officialBar.OfficialBarFeedMsglistAdapter.c
    public void a(View view, Object obj, int i, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, obj, Integer.valueOf(i), Long.valueOf(j)}) == null) {
            if (obj instanceof OfficialBarFeedMsglistAdapter.a) {
                OfficialBarFeedMsglistAdapter.a aVar = (OfficialBarFeedMsglistAdapter.a) obj;
                SingleForumBroadcastFeedActivityConfig singleForumBroadcastFeedActivityConfig = new SingleForumBroadcastFeedActivityConfig(this.f33720b.getPageActivity(), String.valueOf(aVar.c()), aVar.b());
                singleForumBroadcastFeedActivityConfig.setSource((byte) 1);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, singleForumBroadcastFeedActivityConfig));
                StatisticItem statisticItem = new StatisticItem("c13862");
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("fid", aVar.c());
                TiebaStatic.log(statisticItem);
            } else if (obj instanceof a.C1417a) {
                g((a.C1417a) obj, this.f33720b.getPageActivity());
            }
        }
    }

    public final void g(a.C1417a c1417a, Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, c1417a, context) == null) || c1417a == null) {
            return;
        }
        p(c1417a.f18837e, System.currentTimeMillis());
        if (StringUtils.isNull(c1417a.f18836d)) {
            return;
        }
        if (c1417a.f18836d.startsWith("web:http")) {
            c1417a.f18836d = c1417a.f18836d.replaceFirst(UrlSchemaHelper.SCHEMA_TYPE_WEB, "");
        }
        if (c1417a.f18836d.contains("?")) {
            c1417a.f18836d = String.format(Locale.US, "%s&broadcast_id=%d", c1417a.f18836d, Long.valueOf(c1417a.f18840h));
        } else {
            c1417a.f18836d = String.format(Locale.US, "%s?broadcast_id=%d", c1417a.f18836d, Long.valueOf(c1417a.f18840h));
        }
        if (c1417a.f18836d.contains(UrlSchemaHelper.SCHEMA_TYPE_DEEPLINK_TOPIC)) {
            try {
                context.startActivity(Intent.parseUri(c1417a.f18836d, 1));
            } catch (URISyntaxException e2) {
                e2.printStackTrace();
            }
        }
        if (!URLUtil.isHttpUrl(c1417a.f18836d) && !URLUtil.isHttpsUrl(c1417a.f18836d) && !c1417a.f18836d.startsWith(UrlSchemaHelper.SCHEMA_TB_FLUTTER)) {
            Uri parse = Uri.parse(c1417a.f18836d);
            if (parse != null) {
                UtilHelper.dealOneScheme(context, parse.toString());
            }
        } else {
            UrlManager.getInstance().dealOneLink(this.f33720b, new String[]{c1417a.f18836d});
        }
        StatisticItem statisticItem = new StatisticItem(this.o ? "c13866" : "c13864");
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        statisticItem.param("fid", c1417a.f18837e);
        String str = c1417a.n;
        statisticItem.param("tid", str != null ? str : "");
        TiebaStatic.log(statisticItem);
    }

    public void h(View view, Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view, activity) == null) {
            if (view == this.f33721c) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2008022, new OfficialBarTipActivityConfig(getPageContext().getPageActivity())));
            } else if (view == this.j) {
                activity.finish();
            } else if (view == this.q) {
                this.mContext.sendMessage(new CustomMessage<>(2003000, new FrsActivityConfig(this.mContext.getPageActivity()).createNormalCfg(this.p, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND).setCallFrom(3)));
                if (activity.getIntent() != null) {
                    StatisticItem statisticItem = new StatisticItem("c13867");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem.param("fid", activity.getIntent().getStringExtra("key_uid"));
                    TiebaStatic.log(statisticItem);
                }
            }
        }
    }

    public final void i() {
        NoDataView noDataView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (noDataView = this.r) != null && noDataView.getVisibility() == 0) {
            this.r.setVisibility(8);
        }
    }

    public final void j(BaseActivity<OfficialBarFeedActivity> baseActivity) {
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, baseActivity) == null) {
            NavigationBar navigationBar = (NavigationBar) baseActivity.findViewById(R.id.obfuscated_res_0x7f0911b9);
            this.f33726h = navigationBar;
            View addSystemImageButton = navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.t);
            this.j = addSystemImageButton;
            addSystemImageButton.setOnClickListener(this.t);
            this.p = baseActivity.getIntent() != null ? baseActivity.getIntent().getStringExtra("forum_name") : "";
            if (this.o) {
                string = this.p + baseActivity.getString(R.string.obfuscated_res_0x7f0f063c);
            } else {
                string = baseActivity.getPageContext().getString(R.string.obfuscated_res_0x7f0f11ee);
            }
            this.f33726h.setCenterTextTitle(string);
            this.f33726h.showBottomLine();
            if (this.o) {
                TextView addTextButton = this.f33726h.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, baseActivity.getString(R.string.enter_forum));
                this.q = addTextButton;
                addTextButton.setOnClickListener(this.t);
                return;
            }
            View addCustomView = this.f33726h.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.obfuscated_res_0x7f0d0639, this.t);
            this.i = addCustomView;
            ImageView imageView = (ImageView) addCustomView.findViewById(R.id.obfuscated_res_0x7f090988);
            this.f33721c = imageView;
            imageView.setClickable(true);
            this.f33721c.setOnClickListener(this.t);
        }
    }

    public final void k(BaseActivity baseActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, baseActivity) == null) {
            this.s = (FrameLayout) baseActivity.findViewById(R.id.obfuscated_res_0x7f0911e8);
            BdTypeListView bdTypeListView = (BdTypeListView) baseActivity.findViewById(R.id.obfuscated_res_0x7f091276);
            this.n = bdTypeListView;
            if (this.o) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) bdTypeListView.getLayoutParams();
                layoutParams.topMargin = n.f(this.mContext.getPageActivity(), R.dimen.tbds_7);
                this.n.setLayoutParams(layoutParams);
            }
            f fVar = new f(this.f33720b, this.n, this);
            this.m = fVar;
            fVar.d(this.o);
            ((ProgressBar) baseActivity.findViewById(R.id.obfuscated_res_0x7f09145b)).setVisibility(8);
            this.n.setItemsCanFocus(true);
            this.n.setFocusable(false);
            this.n.setFocusableInTouchMode(false);
            this.n.setClickable(false);
            if (!this.o) {
                View inflate = View.inflate(baseActivity, R.layout.obfuscated_res_0x7f0d0637, null);
                this.k = inflate;
                this.f33725g = inflate.findViewById(R.id.obfuscated_res_0x7f0915e8);
                this.f33724f = (TextView) this.k.findViewById(R.id.obfuscated_res_0x7f0915f3);
                RecyclerView recyclerView = (RecyclerView) this.k.findViewById(R.id.obfuscated_res_0x7f0915f4);
                this.f33723e = recyclerView;
                recyclerView.setLayoutManager(new LinearLayoutManager(baseActivity, 0, false));
                OfficialBarFeedMsglistAdapter officialBarFeedMsglistAdapter = new OfficialBarFeedMsglistAdapter(baseActivity.getPageContext(), this);
                this.f33722d = officialBarFeedMsglistAdapter;
                this.f33723e.setAdapter(officialBarFeedMsglistAdapter);
                this.f33723e.setClipChildren(false);
                this.f33723e.addItemDecoration(new a(this), 0);
            }
            this.n.setAdapter((ListAdapter) this.m);
        }
    }

    public void l(List<c.a.p0.u1.l.c.b> list, List<c.a.p0.u1.h.o.a> list2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, list, list2) == null) {
            this.m.c(list);
            if (this.o) {
                BdTypeListView bdTypeListView = this.n;
                bdTypeListView.setSelection(bdTypeListView.getBottom());
            }
            this.a.hideLoadingView(this.l);
            if (!ListUtils.isEmpty(list)) {
                i();
            } else if (ListUtils.isEmpty(list2)) {
                n(454);
            } else {
                n(854);
            }
            if (ListUtils.isEmpty(list2)) {
                return;
            }
            ArrayList<? extends c.a.o0.k0.b.a> arrayList = new ArrayList<>(10);
            for (int i = 0; i < 10 && i < list2.size(); i++) {
                c.a.p0.u1.h.o.a aVar = list2.get(i);
                OfficialBarFeedMsglistAdapter.a aVar2 = new OfficialBarFeedMsglistAdapter.a();
                aVar2.g(aVar.c());
                aVar2.h(aVar.a());
                aVar2.k(aVar.d());
                aVar2.l(aVar.e());
                aVar2.i(Long.parseLong(aVar.b()));
                aVar2.m(aVar.f());
                arrayList.add(aVar2);
            }
            this.f33722d.e(arrayList);
            if (this.k == null || this.n.getHeaderViewsCount() > 0) {
                return;
            }
            this.n.addHeaderView(this.k);
        }
    }

    public void m(LongSparseArray<c.a.p0.u1.i.a.b.b> longSparseArray) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, longSparseArray) == null) || longSparseArray == null || longSparseArray.size() <= 0) {
            return;
        }
        this.m.e(longSparseArray);
    }

    public final void n(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            if (this.r == null) {
                this.r = NoDataViewFactory.a(this.f33720b.getPageActivity(), this.l, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, i), NoDataViewFactory.e.a(R.string.obfuscated_res_0x7f0f0ca5), null);
                NoDataViewFactory.d.a aVar = new NoDataViewFactory.d.a();
                aVar.i(NoDataViewFactory.ImgType.CREATE);
                this.r.setImgOption(aVar.f());
            }
            if (this.r.getVisibility() == 0) {
                return;
            }
            this.r.f(this.f33720b, TbadkApplication.getInst().getSkinType());
            this.r.setVisibility(0);
        }
    }

    public void o(boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048585, this, z, str) == null) {
            BdTopToast bdTopToast = new BdTopToast(this.a);
            bdTopToast.i(z);
            bdTopToast.h(str);
            bdTopToast.j(this.l);
        }
    }

    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            this.f33726h.onChangeSkinType(getPageContext(), i);
            this.f33726h.onBackBtnOnChangeSkin();
            SkinManager.setViewTextColor(this.f33721c, R.color.CAM_X0302, 1);
            SkinManager.setViewTextColor(this.f33724f, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.q, (int) R.color.CAM_X0105);
            SkinManager.setBackgroundColor(this.s, R.color.CAM_X0204);
            if (this.f33725g != null) {
                TBSelector.makeShadowDrawable().setBgColor(R.color.CAM_X0205).setShapeRadius(n.f(this.f33720b.getPageActivity(), R.dimen.tbds31)).setShadowColor(R.color.CAM_X0804).setShadowSide(ShadowDrawable.ALL).setShadowRadius(n.f(this.f33720b.getPageActivity(), R.dimen.tbds10)).setOffsetX(0).setOffsetY(n.f(this.f33720b.getPageActivity(), R.dimen.tbds5)).into(this.f33725g);
            }
            NoDataView noDataView = this.r;
            if (noDataView != null) {
                noDataView.f(this.f33720b, i);
            }
            if (this.f33721c != null) {
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f33721c, R.drawable.obfuscated_res_0x7f08091c, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            f fVar = this.m;
            if (fVar != null) {
                fVar.notifyDataSetChanged();
            }
        }
    }

    public void p(String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048587, this, str, j) == null) {
            n0.c(new b(this, str, j), null);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((c.a.d.a.f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f33726h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.t = new c(this);
        this.a = baseActivity;
        this.o = z;
        this.f33720b = baseActivity.getPageContext();
        baseActivity.setContentView((int) R.layout.obfuscated_res_0x7f0d0561);
        ViewGroup viewGroup = (ViewGroup) baseActivity.findViewById(R.id.obfuscated_res_0x7f09145f);
        this.l = viewGroup;
        baseActivity.showLoadingView(viewGroup);
        j(baseActivity);
        k(baseActivity);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }
}
