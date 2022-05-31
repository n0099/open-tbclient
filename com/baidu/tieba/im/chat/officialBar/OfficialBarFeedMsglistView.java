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
import com.repackage.b37;
import com.repackage.b9;
import com.repackage.d47;
import com.repackage.h47;
import com.repackage.k47;
import com.repackage.li;
import com.repackage.mc5;
import com.repackage.pc5;
import com.repackage.u47;
import com.repackage.v47;
import com.repackage.w55;
import com.repackage.z8;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
/* loaded from: classes3.dex */
public class OfficialBarFeedMsglistView extends z8<OfficialBarFeedActivity> implements OfficialBarFeedMsglistAdapter.c {
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
    public b37 m;
    public BdTypeListView n;
    public boolean o;
    public String p;
    public TextView q;
    public NoDataView r;
    public FrameLayout s;
    public View.OnClickListener t;

    /* loaded from: classes3.dex */
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
                    rect.left = li.f(this.a.mContext.getPageActivity(), R.dimen.tbds19);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends mc5<Void> {
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
        @Override // com.repackage.mc5
        /* renamed from: a */
        public Void doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (StringUtils.isNull(this.a)) {
                    return null;
                }
                d47.v().y(Long.parseLong(this.a), this.b);
                return null;
            }
            return (Void) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
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
                officialBarFeedMsglistView.h(view2, officialBarFeedMsglistView.b.getPageActivity());
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
    public void a(View view2, Object obj, int i, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, obj, Integer.valueOf(i), Long.valueOf(j)}) == null) {
            if (obj instanceof OfficialBarFeedMsglistAdapter.a) {
                OfficialBarFeedMsglistAdapter.a aVar = (OfficialBarFeedMsglistAdapter.a) obj;
                SingleForumBroadcastFeedActivityConfig singleForumBroadcastFeedActivityConfig = new SingleForumBroadcastFeedActivityConfig(this.b.getPageActivity(), String.valueOf(aVar.c()), aVar.b());
                singleForumBroadcastFeedActivityConfig.setSource((byte) 1);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, singleForumBroadcastFeedActivityConfig));
                StatisticItem statisticItem = new StatisticItem("c13862");
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("fid", aVar.c());
                TiebaStatic.log(statisticItem);
            } else if (obj instanceof u47.a) {
                g((u47.a) obj, this.b.getPageActivity());
            }
        }
    }

    public final void g(u47.a aVar, Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, context) == null) || aVar == null) {
            return;
        }
        q(aVar.e, System.currentTimeMillis());
        if (StringUtils.isNull(aVar.d)) {
            return;
        }
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
        StatisticItem statisticItem = new StatisticItem(this.o ? "c13866" : "c13864");
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        statisticItem.param("fid", aVar.e);
        String str = aVar.n;
        statisticItem.param("tid", str != null ? str : "");
        TiebaStatic.log(statisticItem);
    }

    public void h(View view2, Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view2, activity) == null) {
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
            NavigationBar navigationBar = (NavigationBar) baseActivity.findViewById(R.id.obfuscated_res_0x7f091181);
            this.h = navigationBar;
            View addSystemImageButton = navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.t);
            this.j = addSystemImageButton;
            addSystemImageButton.setOnClickListener(this.t);
            this.p = baseActivity.getIntent() != null ? baseActivity.getIntent().getStringExtra("forum_name") : "";
            if (this.o) {
                string = this.p + baseActivity.getString(R.string.obfuscated_res_0x7f0f0652);
            } else {
                string = baseActivity.getPageContext().getString(R.string.obfuscated_res_0x7f0f1225);
            }
            this.h.setCenterTextTitle(string);
            this.h.showBottomLine();
            if (this.o) {
                TextView addTextButton = this.h.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, baseActivity.getString(R.string.enter_forum));
                this.q = addTextButton;
                addTextButton.setOnClickListener(this.t);
                return;
            }
            View addCustomView = this.h.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.obfuscated_res_0x7f0d061f, this.t);
            this.i = addCustomView;
            ImageView imageView = (ImageView) addCustomView.findViewById(R.id.obfuscated_res_0x7f090973);
            this.c = imageView;
            imageView.setClickable(true);
            this.c.setOnClickListener(this.t);
        }
    }

    public final void k(BaseActivity baseActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, baseActivity) == null) {
            this.s = (FrameLayout) baseActivity.findViewById(R.id.obfuscated_res_0x7f0911af);
            BdTypeListView bdTypeListView = (BdTypeListView) baseActivity.findViewById(R.id.obfuscated_res_0x7f09123b);
            this.n = bdTypeListView;
            if (this.o) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) bdTypeListView.getLayoutParams();
                layoutParams.topMargin = li.f(this.mContext.getPageActivity(), R.dimen.tbds_7);
                this.n.setLayoutParams(layoutParams);
            }
            b37 b37Var = new b37(this.b, this.n, this);
            this.m = b37Var;
            b37Var.d(this.o);
            ((ProgressBar) baseActivity.findViewById(R.id.obfuscated_res_0x7f091431)).setVisibility(8);
            this.n.setItemsCanFocus(true);
            this.n.setFocusable(false);
            this.n.setFocusableInTouchMode(false);
            this.n.setClickable(false);
            if (!this.o) {
                View inflate = View.inflate(baseActivity, R.layout.obfuscated_res_0x7f0d061d, null);
                this.k = inflate;
                this.g = inflate.findViewById(R.id.obfuscated_res_0x7f0915b0);
                this.f = (TextView) this.k.findViewById(R.id.obfuscated_res_0x7f0915bb);
                RecyclerView recyclerView = (RecyclerView) this.k.findViewById(R.id.obfuscated_res_0x7f0915bc);
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

    public void l(List<v47> list, List<h47> list2) {
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
            ArrayList<? extends w55> arrayList = new ArrayList<>(10);
            for (int i = 0; i < 10 && i < list2.size(); i++) {
                h47 h47Var = list2.get(i);
                OfficialBarFeedMsglistAdapter.a aVar = new OfficialBarFeedMsglistAdapter.a();
                aVar.g(h47Var.c());
                aVar.h(h47Var.a());
                aVar.k(h47Var.d());
                aVar.l(h47Var.e());
                aVar.i(Long.parseLong(h47Var.b()));
                aVar.m(h47Var.f());
                arrayList.add(aVar);
            }
            this.d.e(arrayList);
            if (this.k == null || this.n.getHeaderViewsCount() > 0) {
                return;
            }
            this.n.addHeaderView(this.k);
        }
    }

    public void m(LongSparseArray<k47> longSparseArray) {
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
                this.r = NoDataViewFactory.a(this.b.getPageActivity(), this.l, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, i), NoDataViewFactory.e.a(R.string.obfuscated_res_0x7f0f0cc5), null);
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
            this.h.onChangeSkinType(getPageContext(), i);
            this.h.onBackBtnOnChangeSkin();
            SkinManager.setViewTextColor(this.c, R.color.CAM_X0302, 1);
            SkinManager.setViewTextColor(this.f, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.q, (int) R.color.CAM_X0105);
            SkinManager.setBackgroundColor(this.s, R.color.CAM_X0204);
            if (this.g != null) {
                TBSelector.makeShadowDrawable().setBgColor(R.color.CAM_X0205).setShapeRadius(li.f(this.b.getPageActivity(), R.dimen.tbds31)).setShadowColor(R.color.CAM_X0804).setShadowSide(ShadowDrawable.ALL).setShadowRadius(li.f(this.b.getPageActivity(), R.dimen.tbds10)).setOffsetX(0).setOffsetY(li.f(this.b.getPageActivity(), R.dimen.tbds5)).into(this.g);
            }
            NoDataView noDataView = this.r;
            if (noDataView != null) {
                noDataView.f(this.b, i);
            }
            if (this.c != null) {
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.c, R.drawable.obfuscated_res_0x7f080946, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            b37 b37Var = this.m;
            if (b37Var != null) {
                b37Var.notifyDataSetChanged();
            }
        }
    }

    public void q(String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048587, this, str, j) == null) {
            pc5.c(new b(this, str, j), null);
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
                super((b9) newInitContext.callArgs[0]);
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
        this.t = new c(this);
        this.a = baseActivity;
        this.o = z;
        this.b = baseActivity.getPageContext();
        baseActivity.setContentView((int) R.layout.obfuscated_res_0x7f0d0546);
        ViewGroup viewGroup = (ViewGroup) baseActivity.findViewById(R.id.obfuscated_res_0x7f091433);
        this.l = viewGroup;
        baseActivity.showLoadingView(viewGroup);
        j(baseActivity);
        k(baseActivity);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }
}
