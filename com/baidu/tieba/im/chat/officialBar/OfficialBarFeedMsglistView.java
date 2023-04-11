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
import com.baidu.tieba.a9;
import com.baidu.tieba.b08;
import com.baidu.tieba.c08;
import com.baidu.tieba.cr5;
import com.baidu.tieba.dk5;
import com.baidu.tieba.gr5;
import com.baidu.tieba.gy7;
import com.baidu.tieba.ii;
import com.baidu.tieba.im.chat.officialBar.OfficialBarFeedMsglistAdapter;
import com.baidu.tieba.jz7;
import com.baidu.tieba.nz7;
import com.baidu.tieba.qz7;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.tieba.view.RoundRelativeLayout;
import com.baidu.tieba.y8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
/* loaded from: classes4.dex */
public class OfficialBarFeedMsglistView extends y8<OfficialBarFeedActivity> implements OfficialBarFeedMsglistAdapter.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseActivity<OfficialBarFeedActivity> a;
    public TbPageContext<OfficialBarFeedActivity> b;
    public ImageView c;
    public OfficialBarFeedMsglistAdapter d;
    public RecyclerView e;
    public TextView f;
    public View g;
    public NavigationBar h;
    public View i;
    public View j;
    public View k;
    public ViewGroup l;
    public gy7 m;
    public BdTypeListView n;
    public boolean o;
    public String p;
    public TextView q;
    public NoDataView r;
    public FrameLayout s;
    public RoundRelativeLayout t;
    public View.OnClickListener u;

    /* loaded from: classes4.dex */
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
        public void getItemOffsets(Rect rect, View view2, RecyclerView recyclerView, RecyclerView.State state) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLL(1048576, this, rect, view2, recyclerView, state) == null) {
                super.getItemOffsets(rect, view2, recyclerView, state);
                if (recyclerView.getChildLayoutPosition(view2) == 0) {
                    rect.left = ii.g(this.a.mContext.getPageActivity(), R.dimen.tbds19);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends cr5<Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ long b;

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
            this.b = j;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.cr5
        /* renamed from: a */
        public Void doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (!StringUtils.isNull(this.a)) {
                    jz7.w().z(Long.parseLong(this.a), this.b);
                    return null;
                }
                return null;
            }
            return (Void) invokeV.objValue;
        }
    }

    /* loaded from: classes4.dex */
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
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                OfficialBarFeedMsglistView officialBarFeedMsglistView = this.a;
                officialBarFeedMsglistView.z(view2, officialBarFeedMsglistView.b.getPageActivity());
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
                super((a9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.u = new c(this);
        this.a = baseActivity;
        this.o = z;
        this.b = baseActivity.getPageContext();
        baseActivity.setContentView((int) R.layout.msg_msglist_activity);
        ViewGroup viewGroup = (ViewGroup) baseActivity.findViewById(R.id.msg_root_view);
        this.l = viewGroup;
        baseActivity.showLoadingView(viewGroup);
        B(baseActivity);
        C(baseActivity);
        D(baseActivity);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void z(View view2, Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, view2, activity) == null) {
            if (view2 == this.c) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2008022, new OfficialBarTipActivityConfig(getPageContext().getPageActivity())));
            } else if (view2 == this.j) {
                activity.finish();
            } else if (view2 == this.q) {
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

    public final void D(BaseActivity baseActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, baseActivity) == null) {
            RoundRelativeLayout roundRelativeLayout = (RoundRelativeLayout) baseActivity.findViewById(R.id.origin_list_container);
            this.t = roundRelativeLayout;
            roundRelativeLayout.setAllCornerRound(0.0f);
        }
    }

    public void F(LongSparseArray<qz7> longSparseArray) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, longSparseArray) == null) && longSparseArray != null && longSparseArray.size() > 0) {
            this.m.e(longSparseArray);
        }
    }

    public final void A() {
        NoDataView noDataView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (noDataView = this.r) != null && noDataView.getVisibility() == 0) {
            this.r.setVisibility(8);
        }
    }

    public final void B(BaseActivity<OfficialBarFeedActivity> baseActivity) {
        String str;
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, baseActivity) == null) {
            NavigationBar navigationBar = (NavigationBar) baseActivity.findViewById(R.id.lay_title_bar);
            this.h = navigationBar;
            View addSystemImageButton = navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.u);
            this.j = addSystemImageButton;
            addSystemImageButton.setOnClickListener(this.u);
            if (baseActivity.getIntent() != null) {
                str = baseActivity.getIntent().getStringExtra("forum_name");
            } else {
                str = "";
            }
            this.p = str;
            if (this.o) {
                string = this.p + baseActivity.getString(R.string.obfuscated_res_0x7f0f06b5);
            } else {
                string = baseActivity.getPageContext().getString(R.string.subscribe_bar_title);
            }
            this.h.setCenterTextTitle(string);
            this.h.showBottomLine();
            if (this.o) {
                TextView addTextButton = this.h.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, baseActivity.getString(R.string.enter_forum));
                this.q = addTextButton;
                addTextButton.setOnClickListener(this.u);
                return;
            }
            View addCustomView = this.h.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.obfuscated_res_0x7f0d06d4, this.u);
            this.i = addCustomView;
            ImageView imageView = (ImageView) addCustomView.findViewById(R.id.obfuscated_res_0x7f090a9e);
            this.c = imageView;
            imageView.setClickable(true);
            this.c.setOnClickListener(this.u);
        }
    }

    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            this.h.onChangeSkinType(getPageContext(), i);
            this.h.onBackBtnOnChangeSkin();
            SkinManager.setViewTextColor(this.c, R.color.CAM_X0302, 1);
            SkinManager.setViewTextColor(this.f, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.q, (int) R.color.CAM_X0105);
            SkinManager.setBackgroundColor(this.s, R.color.CAM_X0204);
            if (this.g != null) {
                TBSelector.makeShadowDrawable().setBgColor(R.color.CAM_X0205).setShapeRadius(ii.g(this.b.getPageActivity(), R.dimen.tbds31)).setShadowColor(R.color.CAM_X0804).setShadowSide(ShadowDrawable.ALL).setShadowRadius(ii.g(this.b.getPageActivity(), R.dimen.tbds10)).setOffsetX(0).setOffsetY(ii.g(this.b.getPageActivity(), R.dimen.tbds5)).into(this.g);
            }
            NoDataView noDataView = this.r;
            if (noDataView != null) {
                noDataView.f(this.b, i);
            }
            if (this.c != null) {
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.c, R.drawable.obfuscated_res_0x7f0809d0, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            gy7 gy7Var = this.m;
            if (gy7Var != null) {
                gy7Var.notifyDataSetChanged();
            }
        }
    }

    public final void C(BaseActivity baseActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, baseActivity) == null) {
            this.s = (FrameLayout) baseActivity.findViewById(R.id.layout_main);
            BdTypeListView bdTypeListView = (BdTypeListView) baseActivity.findViewById(R.id.lis_msg);
            this.n = bdTypeListView;
            if (this.o) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) bdTypeListView.getLayoutParams();
                layoutParams.topMargin = ii.g(this.mContext.getPageActivity(), R.dimen.tbds_7);
                this.n.setLayoutParams(layoutParams);
            }
            gy7 gy7Var = new gy7(this.b, this.n, this);
            this.m = gy7Var;
            gy7Var.d(this.o);
            ((ProgressBar) baseActivity.findViewById(R.id.msg_progress)).setVisibility(8);
            this.n.setItemsCanFocus(true);
            this.n.setFocusable(false);
            this.n.setFocusableInTouchMode(false);
            this.n.setClickable(false);
            if (!this.o) {
                View inflate = View.inflate(baseActivity, R.layout.obfuscated_res_0x7f0d06d2, null);
                this.k = inflate;
                this.g = inflate.findViewById(R.id.obfuscated_res_0x7f0918b2);
                this.f = (TextView) this.k.findViewById(R.id.obfuscated_res_0x7f0918bd);
                RecyclerView recyclerView = (RecyclerView) this.k.findViewById(R.id.obfuscated_res_0x7f0918be);
                this.e = recyclerView;
                recyclerView.setLayoutManager(new LinearLayoutManager(baseActivity, 0, false));
                OfficialBarFeedMsglistAdapter officialBarFeedMsglistAdapter = new OfficialBarFeedMsglistAdapter(baseActivity.getPageContext(), this);
                this.d = officialBarFeedMsglistAdapter;
                this.e.setAdapter(officialBarFeedMsglistAdapter);
                this.e.setClipChildren(false);
                this.e.addItemDecoration(new a(this), 0);
            }
            this.n.setAdapter((ListAdapter) this.m);
        }
    }

    public void E(List<c08> list, List<nz7> list2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, list, list2) == null) {
            this.m.c(list);
            if (this.o) {
                BdTypeListView bdTypeListView = this.n;
                bdTypeListView.setSelection(bdTypeListView.getBottom());
            }
            this.a.hideLoadingView(this.l);
            if (!ListUtils.isEmpty(list)) {
                A();
            } else if (ListUtils.isEmpty(list2)) {
                G(454);
            } else {
                G(854);
            }
            if (ListUtils.isEmpty(list2)) {
                return;
            }
            HashSet hashSet = new HashSet();
            if (list != null) {
                for (c08 c08Var : list) {
                    if (c08Var.c() != null) {
                        hashSet.add(c08Var.c().b());
                    }
                }
            }
            ArrayList<? extends dk5> arrayList = new ArrayList<>(10);
            for (int i = 0; i < 10 && i < list2.size(); i++) {
                nz7 nz7Var = list2.get(i);
                OfficialBarFeedMsglistAdapter.a aVar = new OfficialBarFeedMsglistAdapter.a();
                aVar.f(nz7Var.c());
                aVar.g(nz7Var.a());
                aVar.i(nz7Var.d());
                if (!hashSet.contains(nz7Var.b())) {
                    aVar.i(0);
                }
                aVar.j(nz7Var.e());
                aVar.h(Long.parseLong(nz7Var.b()));
                aVar.k(nz7Var.f());
                arrayList.add(aVar);
            }
            this.d.l(arrayList);
            if (this.k != null && this.n.getHeaderViewsCount() <= 0) {
                this.n.addHeaderView(this.k);
            }
        }
    }

    public final void y(b08.a aVar, Context context) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048587, this, aVar, context) != null) || aVar == null) {
            return;
        }
        I(aVar.e, System.currentTimeMillis());
        if (StringUtils.isNull(aVar.d)) {
            return;
        }
        String str2 = "";
        if (aVar.d.startsWith("web:http")) {
            aVar.d = aVar.d.replaceFirst(UrlSchemaHelper.SCHEMA_TYPE_WEB, "");
        }
        if (aVar.d.contains("?")) {
            aVar.d = String.format(Locale.US, "%s&broadcast_id=%d", aVar.d, Long.valueOf(aVar.h));
        } else {
            aVar.d = String.format(Locale.US, "%s?broadcast_id=%d", aVar.d, Long.valueOf(aVar.h));
        }
        if (aVar.d.contains(UrlSchemaHelper.SCHEMA_TYPE_DEEPLINK_TOPIC)) {
            try {
                context.startActivity(Intent.parseUri(aVar.d, 1));
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        }
        if (!URLUtil.isHttpUrl(aVar.d) && !URLUtil.isHttpsUrl(aVar.d) && !aVar.d.startsWith(UrlSchemaHelper.SCHEMA_TB_FLUTTER)) {
            Uri parse = Uri.parse(aVar.d);
            if (parse != null) {
                UtilHelper.dealOneScheme(context, parse.toString());
            }
        } else {
            UrlManager.getInstance().dealOneLink(this.b, new String[]{aVar.d});
        }
        if (this.o) {
            str = "c13866";
        } else {
            str = "c13864";
        }
        StatisticItem statisticItem = new StatisticItem(str);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        statisticItem.param("fid", aVar.e);
        String str3 = aVar.n;
        if (str3 != null) {
            str2 = str3;
        }
        statisticItem.param("tid", str2);
        TiebaStatic.log(statisticItem);
    }

    public final void G(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            if (this.r == null) {
                this.r = NoDataViewFactory.a(this.b.getPageActivity(), this.l, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, i), NoDataViewFactory.e.a(R.string.official_feed_no_data), null);
                NoDataViewFactory.d.a aVar = new NoDataViewFactory.d.a();
                aVar.i(NoDataViewFactory.ImgType.CREATE);
                this.r.setImgOption(aVar.f());
            }
            if (this.r.getVisibility() == 0) {
                return;
            }
            this.r.f(this.b, TbadkApplication.getInst().getSkinType());
            this.r.setVisibility(0);
        }
    }

    public void H(boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048583, this, z, str) == null) {
            BdTopToast bdTopToast = new BdTopToast(this.a);
            bdTopToast.h(z);
            bdTopToast.g(str);
            bdTopToast.i(this.l);
        }
    }

    public void I(String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, j) == null) {
            gr5.c(new b(this, str, j), null);
        }
    }

    @Override // com.baidu.tieba.im.chat.officialBar.OfficialBarFeedMsglistAdapter.c
    public void d(View view2, Object obj, int i, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{view2, obj, Integer.valueOf(i), Long.valueOf(j)}) == null) {
            if (obj instanceof OfficialBarFeedMsglistAdapter.a) {
                OfficialBarFeedMsglistAdapter.a aVar = (OfficialBarFeedMsglistAdapter.a) obj;
                SingleForumBroadcastFeedActivityConfig singleForumBroadcastFeedActivityConfig = new SingleForumBroadcastFeedActivityConfig(this.b.getPageActivity(), String.valueOf(aVar.c()), aVar.b());
                singleForumBroadcastFeedActivityConfig.setSource((byte) 1);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, singleForumBroadcastFeedActivityConfig));
                StatisticItem statisticItem = new StatisticItem("c13862");
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("fid", aVar.c());
                TiebaStatic.log(statisticItem);
            } else if (obj instanceof b08.a) {
                y((b08.a) obj, this.b.getPageActivity());
            }
        }
    }
}
