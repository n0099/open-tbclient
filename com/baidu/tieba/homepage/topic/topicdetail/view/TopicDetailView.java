package com.baidu.tieba.homepage.topic.topicdetail.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.topic.topicdetail.TopicDetailActivity;
import com.baidu.tieba.homepage.topic.topictab.view.TopicPkView;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.l;
import d.a.c.k.e.n;
import d.a.o0.r.q.b2;
import d.a.o0.s.c.i0;
import d.a.p0.e1.k.a.d.a;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class TopicDetailView extends RelativeLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public d.a.p0.e1.k.a.c.a A;
    public boolean B;
    public int C;
    public d.a.p0.e1.k.a.d.a D;
    public a.b E;
    public int F;
    public int G;
    public NoNetworkView.b H;
    public d.a.o0.w.w.b I;
    public NewWriteModel.g J;
    public final RecyclerView.OnScrollListener K;
    public BdListView.p L;

    /* renamed from: e  reason: collision with root package name */
    public int f16922e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<?> f16923f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.p0.e1.k.a.a f16924g;

    /* renamed from: h  reason: collision with root package name */
    public NavigationBar f16925h;

    /* renamed from: i  reason: collision with root package name */
    public View f16926i;
    public ImageView j;
    public ImageView k;
    public TopicDetailHeadView l;
    public BdTypeRecyclerView m;
    public d.a.p0.e1.k.a.b.b n;
    public PbListView o;
    public NoNetworkView p;
    public d.a.o0.d0.g q;
    public d.a.o0.d0.h r;
    public View s;
    public View t;
    public TextView u;
    public TextView v;
    public d.a.p0.e1.k.a.e.a w;
    public View x;
    public d.a.p0.a4.c y;
    public EditText z;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TopicDetailView f16927e;

        public a(TopicDetailView topicDetailView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {topicDetailView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16927e = topicDetailView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && d.a.c.e.p.j.A() && this.f16927e.f16924g != null) {
                this.f16927e.f16924g.loadData();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements NoNetworkView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TopicDetailView f16928e;

        public b(TopicDetailView topicDetailView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {topicDetailView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16928e = topicDetailView;
        }

        @Override // com.baidu.tbadk.core.view.NoNetworkView.b
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && z && this.f16928e.A == null && this.f16928e.f16924g != null) {
                this.f16928e.f16924g.loadData();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TopicDetailView f16929e;

        public c(TopicDetailView topicDetailView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {topicDetailView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16929e = topicDetailView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f16929e.o();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements TopicPkView.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TopicDetailView f16930a;

        public d(TopicDetailView topicDetailView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {topicDetailView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16930a = topicDetailView;
        }

        @Override // com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.f
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                this.f16930a.J(i2);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TopicDetailView f16931e;

        public e(TopicDetailView topicDetailView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {topicDetailView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16931e = topicDetailView;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, editable) == null) || this.f16931e.y == null) {
                return;
            }
            if (!this.f16931e.y.e()) {
                this.f16931e.n(false);
            }
            this.f16931e.y.l(false);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i2, i3, i4) == null) {
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i2, i3, i4) == null) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements d.a.o0.w.w.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TopicDetailView f16932a;

        public f(TopicDetailView topicDetailView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {topicDetailView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16932a = topicDetailView;
        }

        @Override // d.a.o0.w.w.b
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.f16932a.y.d()) {
                    this.f16932a.f16923f.showToast(this.f16932a.y.c());
                    this.f16932a.n(true);
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class g implements NewWriteModel.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TopicDetailView f16933a;

        public g(TopicDetailView topicDetailView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {topicDetailView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16933a = topicDetailView;
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.g
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, i0 i0Var, WriteData writeData, AntiData antiData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, i0Var, writeData, antiData}) == null) {
                if (z && this.f16933a.w != null && this.f16933a.w.a() != null) {
                    this.f16933a.w.a().o();
                }
                if (z) {
                    this.f16933a.y.n(null);
                    this.f16933a.y.i(null);
                    this.f16933a.y.k(false);
                    if (postWriteCallBackData != null) {
                        long f2 = d.a.c.e.m.b.f(postWriteCallBackData.getPostId(), 0L);
                        long f3 = d.a.c.e.m.b.f(postWriteCallBackData.getThreadId(), 0L);
                        if (f2 == 0 || f3 == 0) {
                            return;
                        }
                        this.f16933a.E = this.f16933a.D.c(f2, f3);
                        d.a.c.e.m.e.a().postDelayed(this.f16933a.E, 500L);
                    }
                } else if (postWriteCallBackData == null || !postWriteCallBackData.isSensitiveError()) {
                } else {
                    this.f16933a.y.i(postWriteCallBackData.getSensitiveWords());
                    this.f16933a.y.n(postWriteCallBackData.getErrorString());
                    if (ListUtils.isEmpty(this.f16933a.y.a())) {
                        return;
                    }
                    this.f16933a.n(true);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TopicDetailView f16934a;

        public h(TopicDetailView topicDetailView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {topicDetailView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16934a = topicDetailView;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i2) == null) {
                if (i2 != 0 && this.f16934a.w != null) {
                    this.f16934a.w.u();
                    this.f16934a.setEditorTopViewAboveEditor();
                }
                super.onScrollStateChanged(this.f16934a.m, i2);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i2, i3) == null) {
                super.onScrolled(recyclerView, i2, i3);
                this.f16934a.F += i3;
                this.f16934a.I();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TopicDetailView f16935e;

        public i(TopicDetailView topicDetailView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {topicDetailView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16935e = topicDetailView;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f16935e.B) {
                if (!l.D()) {
                    this.f16935e.q();
                    return;
                }
                int size = this.f16935e.A.f55761f.size() - 1;
                if (this.f16935e.A.f55761f.get(size) instanceof d.a.p0.e1.k.a.c.c) {
                    ((TopicDetailActivity) this.f16935e.f16923f.getPageActivity()).requestNextPageThreadData(((d.a.p0.e1.k.a.c.c) this.f16935e.A.f55761f.get(size)).f55771e);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class j implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ShareItem f16936e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ TopicDetailView f16937f;

        public j(TopicDetailView topicDetailView, ShareItem shareItem) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {topicDetailView, shareItem};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16937f = topicDetailView;
            this.f16936e = shareItem;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                d.a.c.e.p.a.a(this.f16936e.t);
                l.M(this.f16937f.getContext(), view.getResources().getString(R.string.copy_pb_url_success));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TopicDetailView(TbPageContext<?> tbPageContext, d.a.p0.e1.k.a.a aVar, Bundle bundle) {
        super(tbPageContext.getPageActivity());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, aVar, bundle};
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
        this.f16922e = 3;
        this.t = null;
        this.u = null;
        this.v = null;
        this.B = true;
        this.F = 0;
        this.G = 44;
        this.H = new b(this);
        this.I = new f(this);
        this.J = new g(this);
        this.K = new h(this);
        this.L = new i(this);
        this.f16923f = tbPageContext;
        this.f16924g = aVar;
        t(bundle);
        x();
    }

    public void A(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || v()) {
            return;
        }
        if (this.q == null) {
            d.a.o0.d0.g gVar = new d.a.o0.d0.g(getContext());
            this.q = gVar;
            gVar.onChangeSkinType();
        }
        this.q.attachView(this, z);
    }

    public void B(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) || w()) {
            return;
        }
        if (this.r == null) {
            this.r = new d.a.o0.d0.h(getContext(), new a(this));
        }
        this.r.j(this.f16923f.getResources().getDimensionPixelSize(R.dimen.tbds506));
        this.r.attachView(this, z);
        this.r.o();
        this.m.setVisibility(8);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.j, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.m.setNextPage(this.o);
            this.o.f();
        }
    }

    public final void G() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.A == null || getContext() == null) {
            return;
        }
        String valueOf = String.valueOf(this.A.f55756a);
        d.a.p0.e1.k.a.c.a aVar = this.A;
        String str = aVar.f55757b;
        String str2 = aVar.f55758c;
        if (!TextUtils.isEmpty(valueOf) && !TextUtils.isEmpty(str)) {
            String str3 = "http://tieba.baidu.com/mo/q/newtopic/detail?topic_id=" + valueOf + "/";
            Uri parse = StringUtils.isNull(this.A.f55759d) ? null : Uri.parse(this.A.f55759d);
            ShareItem shareItem = new ShareItem();
            shareItem.r = str;
            shareItem.s = str2;
            shareItem.t = str3;
            shareItem.f12846i = true;
            shareItem.q = valueOf;
            shareItem.v = parse;
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(getContext(), shareItem, true, true);
            shareDialogConfig.setIsCopyLink(true);
            shareDialogConfig.setCopyLinkListener(new j(this, shareItem));
            this.f16923f.sendMessage(new CustomMessage(2001276, shareDialogConfig));
            return;
        }
        this.f16923f.showToast(getContext().getString(R.string.no_hot_topic_data));
    }

    public Bitmap H() {
        InterceptResult invokeV;
        Bitmap drawingCache;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            d.a.c.k.d.a bdImage = this.l.getmBgImg().getBdImage();
            if (bdImage != null) {
                drawingCache = bdImage.p();
            } else {
                drawingCache = this.l.getmBgImg().getDrawingCache();
            }
            int width = this.f16923f.getPageActivity().getWindowManager().getDefaultDisplay().getWidth();
            int height = this.f16925h.getHeight();
            return (drawingCache == null || drawingCache.getWidth() < width || drawingCache.getHeight() < height) ? drawingCache : Bitmap.createBitmap(drawingCache, 0, 0, width, height);
        }
        return (Bitmap) invokeV.objValue;
    }

    public final void I() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.A == null || this.l == null) {
            return;
        }
        if (this.F > this.G) {
            this.f16925h.getBarBgView().setAlpha(1.0f);
            this.f16925h.getBarBgView().setBackgroundDrawable(new BitmapDrawable(H()));
            return;
        }
        SkinManager.setBackgroundColor(this.f16925h.getBarBgView(), R.color.transparent);
        this.f16925h.getBarBgView().setAlpha(0.0f);
    }

    public final void J(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.C = i2;
            this.v.setVisibility(0);
            if (i2 == 1) {
                this.v.setText(R.string.topic_detail_pk_support);
                SkinManager.setBackgroundResource(this.v, R.drawable.topic_discuss_support_bg);
            } else if (i2 == 2) {
                this.v.setText(R.string.topic_detail_pk_oppose);
                SkinManager.setBackgroundResource(this.v, R.drawable.topic_discuss_oppose_bg);
            } else {
                this.v.setText(R.string.topic_detail_pk_chigua);
                SkinManager.setBackgroundResource(this.v, R.drawable.topic_discuss_opinion_bg);
            }
            int i3 = this.f16922e;
            if (i3 != 1 && i3 != 4) {
                SkinManager.setViewTextColor(this.v, R.color.CAM_X0101);
            } else {
                this.v.setTextColor(-2130706433);
            }
        }
    }

    public d.a.p0.e1.k.a.e.a getEditor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.w : (d.a.p0.e1.k.a.e.a) invokeV.objValue;
    }

    public void n(boolean z) {
        EditText editText;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) || (editText = this.z) == null || editText.getText() == null) {
            return;
        }
        int selectionEnd = this.z.getSelectionEnd();
        SpannableStringBuilder f2 = this.y.f(this.z.getText());
        if (f2 != null) {
            this.y.l(true);
            this.z.setText(f2);
            if (z && this.y.b() >= 0) {
                this.z.requestFocus();
                this.z.setSelection(this.y.b());
            } else {
                this.z.setSelection(selectionEnd);
            }
            d.a.p0.a4.c cVar = this.y;
            cVar.k(cVar.b() >= 0);
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            if (ViewHelper.checkUpIsLogin(getContext())) {
                this.w.M();
                setEditorTopViewAboveEditor();
            }
            if (this.A != null) {
                TiebaStatic.log(new StatisticItem("c13359").param("topic_id", String.valueOf(this.A.f55756a)));
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        d.a.p0.e1.k.a.c.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, view) == null) {
            if (view == this.f16926i) {
                this.f16923f.getPageActivity().finish();
            } else if (view != this.k || (aVar = this.A) == null || aVar.f55756a <= 0) {
            } else {
                G();
                TiebaStatic.log(new StatisticItem("c13364").param("topic_id", String.valueOf(this.A.f55756a)));
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            p();
            super.onDetachedFromWindow();
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.m.setOnSrollToBottomListener(null);
            NoNetworkView noNetworkView = this.p;
            if (noNetworkView != null) {
                noNetworkView.d(this.H);
            }
            d.a.p0.e1.k.a.e.a aVar = this.w;
            if (aVar != null) {
                aVar.x();
            }
            if (this.E != null) {
                d.a.c.e.m.e.a().removeCallbacks(this.E);
            }
            r();
            s();
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.m.setNextPage(null);
        }
    }

    public void r() {
        d.a.o0.d0.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || (gVar = this.q) == null) {
            return;
        }
        gVar.dettachView(this);
        this.q = null;
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            d.a.o0.d0.h hVar = this.r;
            if (hVar != null) {
                hVar.dettachView(this);
                this.r = null;
            }
            this.m.setVisibility(0);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.j, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public void setData(d.a.p0.e1.k.a.c.a aVar) {
        int g2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048592, this, aVar) == null) || aVar == null) {
            return;
        }
        this.A = aVar;
        boolean z = aVar.f55762g;
        this.B = z;
        if (z && aVar.f55761f.size() <= 4) {
            this.B = false;
            F();
        } else if (!this.B) {
            F();
        } else {
            z();
        }
        if (!StringUtils.isNull(aVar.f55757b)) {
            this.f16925h.setCenterTextTitle(String.format(getContext().getString(R.string.daily_topic_name), StringHelper.cutChineseAndEnglishWithSuffix(aVar.f55757b, 14, StringHelper.STRING_MORE)));
        }
        this.l.setData(aVar.f55760e);
        this.m.s(this.l);
        this.n.c(aVar.f55761f);
        d.a.p0.e1.k.b.c.b bVar = this.A.f55760e.f55769e;
        if (bVar != null) {
            if (bVar.f55812d.f55819e) {
                J(1);
            } else if (bVar.f55813e.f55819e) {
                J(2);
            } else {
                J(0);
            }
            g2 = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds140);
        } else {
            g2 = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds50);
            this.v.setVisibility(8);
        }
        this.u.setPadding(g2, 0, 0, 0);
        I();
    }

    public void setEditorTopViewAboveEditor() {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (view = this.x) == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            if (this.w.a().v()) {
                layoutParams2.addRule(2, this.w.a().getId());
            } else {
                layoutParams2.addRule(2, this.s.getId());
            }
            this.x.setLayoutParams(layoutParams2);
        }
    }

    public void setNextData(int i2, boolean z, List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), list}) == null) {
            this.B = z;
            if (!z) {
                F();
            } else {
                z();
            }
            if (i2 != 0 || list == null || ListUtils.isEmpty(list)) {
                return;
            }
            for (n nVar : list) {
                if (nVar instanceof d.a.p0.e1.k.a.c.c) {
                    ((d.a.p0.e1.k.a.c.c) nVar).j = this.A.a();
                }
            }
            this.A.f55761f.addAll(list);
            this.m.setData(this.A.f55761f);
        }
    }

    public final void t(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, bundle) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.activity_topic_detail_layout, (ViewGroup) this, true);
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.activity_topic_detail_navigation);
            this.f16925h = navigationBar;
            if (this.f16926i == null) {
                View addSystemImageButton = navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
                this.f16926i = addSystemImageButton;
                addSystemImageButton.setOnClickListener(this);
                this.j = (ImageView) this.f16926i.findViewById(R.id.widget_navi_back_button);
            }
            this.k = (ImageView) this.f16925h.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.topic_detail_share_layout, this);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.k, R.drawable.icon_pure_topbar_share44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SkinManager.setViewTextColor(this.f16925h.mCenterText, R.color.CAM_X0101);
            this.f16925h.mCenterText.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.tbds52));
            this.f16925h.mCenterText.setTypeface(Typeface.defaultFromStyle(1));
            NoNetworkView noNetworkView = (NoNetworkView) findViewById(R.id.activity_topic_detail_no_network_view);
            this.p = noNetworkView;
            noNetworkView.a(this.H);
            this.t = findViewById(R.id.pb_editor_tool_comment);
            TextView textView = (TextView) findViewById(R.id.topic_editor_tool_comment_reply_text);
            this.u = textView;
            textView.setOnClickListener(new c(this));
            this.v = (TextView) findViewById(R.id.editor_tool_opinion_text_view);
            this.s = findViewById(R.id.activity_topic_detail_editor);
            u(bundle);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            addView(this.w.a(), layoutParams);
            this.y = new d.a.p0.a4.c();
            this.x = findViewById(R.id.activity_topic_detail_editor_top);
            BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) findViewById(R.id.activity_topic_detail_list);
            this.m = bdTypeRecyclerView;
            bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            this.m.setFadingEdgeLength(0);
            this.m.setOverScrollMode(2);
            this.m.setOnSrollToBottomListener(this.L);
            this.m.addOnScrollListener(this.K);
            SkinManager.setBackgroundColor(this.m, R.color.CAM_X0201);
            this.n = new d.a.p0.e1.k.a.b.b(this.f16923f, this.m);
            TopicDetailHeadView topicDetailHeadView = new TopicDetailHeadView(getContext());
            this.l = topicDetailHeadView;
            topicDetailHeadView.k.setPkClickListener(new d(this));
            if (this.q == null) {
                PbListView pbListView = new PbListView(this.f16923f.getPageActivity());
                this.o = pbListView;
                pbListView.b();
            }
            this.o.o(R.color.CAM_X0205);
            this.o.r(l.g(this.f16923f.getPageActivity(), R.dimen.tbds182));
            this.o.E(R.dimen.tbfontsize33);
            this.o.y(R.color.CAM_X0110);
            this.o.C(SkinManager.getColor(R.color.CAM_X0110));
            this.o.o(SkinManager.getColor(R.color.CAM_X0201));
            this.o.u(SkinManager.getColor(R.color.CAM_X0204));
            this.o.A(getResources().getString(R.string.list_has_no_more));
            this.o.b().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            if (this.D == null) {
                d.a.p0.e1.k.a.d.a aVar = new d.a.p0.e1.k.a.d.a(this);
                this.D = aVar;
                aVar.f(this.f16923f.getUniqueId());
            }
        }
    }

    public final void u(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, bundle) == null) {
            d.a.p0.e1.k.a.e.a aVar = (d.a.p0.e1.k.a.e.a) new d.a.p0.e1.k.a.e.b().a(getContext());
            this.w = aVar;
            if (aVar == null) {
                return;
            }
            aVar.F(this.f16923f);
            this.w.G(this.J);
            this.w.E(this.I);
            this.w.a().C(true);
            this.w.a().setBarBackgroundColorId(R.color.CAM_X0207);
            this.w.v((BaseActivity) getContext(), bundle);
            this.w.u();
            this.w.a().setId(R.id.topic_editor);
            EditText g2 = this.w.o().g();
            this.z = g2;
            g2.addTextChangedListener(new e(this));
        }
    }

    public boolean v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            d.a.o0.d0.g gVar = this.q;
            if (gVar != null) {
                return gVar.isViewAttached();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            d.a.o0.d0.h hVar = this.r;
            if (hVar != null) {
                return hVar.isViewAttached();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void x() {
        int skinType;
        NoNetworkView noNetworkView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048599, this) == null) || (skinType = TbadkCoreApplication.getInst().getSkinType()) == this.f16922e) {
            return;
        }
        this.f16922e = skinType;
        I();
        SkinManager.setViewTextColor(this.f16925h.mCenterText, R.color.CAM_X0101);
        SkinManager.setBackgroundResource(this.t, R.color.CAM_X0207);
        SkinManager.setViewTextColor(this.u, R.color.CAM_X0109);
        this.u.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(l.g(this.f16923f.getPageActivity(), R.dimen.tbds47), SkinManager.getColor(R.color.CAM_X0209)));
        J(this.C);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.j, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        if (this.k != null) {
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.k, R.drawable.icon_pure_topbar_share44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        TbPageContext<?> tbPageContext = this.f16923f;
        if (tbPageContext != null && (noNetworkView = this.p) != null) {
            noNetworkView.c(tbPageContext, this.f16922e);
        }
        d.a.o0.d0.g gVar = this.q;
        if (gVar != null) {
            gVar.onChangeSkinType();
        }
        d.a.o0.d0.h hVar = this.r;
        if (hVar != null) {
            hVar.onChangeSkinType();
        }
        d.a.p0.e1.k.a.e.a aVar = this.w;
        if (aVar != null && aVar.a() != null) {
            this.w.a().w(this.f16922e);
        }
        PbListView pbListView = this.o;
        if (pbListView != null) {
            pbListView.y(R.color.CAM_X0110);
            this.o.C(SkinManager.getColor(R.color.CAM_X0110));
            this.o.o(SkinManager.getColor(R.color.CAM_X0201));
            this.o.u(SkinManager.getColor(R.color.CAM_X0204));
        }
        TopicDetailHeadView topicDetailHeadView = this.l;
        if (topicDetailHeadView != null) {
            topicDetailHeadView.b();
        }
        d.a.p0.e1.k.a.b.b bVar = this.n;
        if (bVar != null) {
            bVar.b();
        }
        SkinManager.setBackgroundColor(this.m, R.color.CAM_X0205);
    }

    public void y(b2 b2Var) {
        d.a.p0.e1.k.a.c.c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, b2Var) == null) {
            Iterator<n> it = this.A.f55761f.iterator();
            int i2 = 0;
            while (true) {
                if (!it.hasNext()) {
                    cVar = null;
                    break;
                }
                n next = it.next();
                if (next instanceof d.a.p0.e1.k.a.c.c) {
                    cVar = (d.a.p0.e1.k.a.c.c) next;
                    break;
                }
                i2++;
            }
            if (cVar != null) {
                d.a.p0.e1.k.a.c.c cVar2 = new d.a.p0.e1.k.a.c.c();
                cVar2.f55771e = cVar.f55771e;
                cVar2.f55772f = b2Var;
                cVar2.f55775i = 2;
                cVar2.f55774h = this.C;
                d.a.p0.e1.k.a.c.a aVar = this.A;
                cVar2.f55773g = aVar.f55756a;
                cVar2.j = aVar.a();
                this.A.f55761f.add(i2, cVar2);
                this.n.c(this.A.f55761f);
            }
        }
    }

    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            this.B = true;
            this.m.setNextPage(this.o);
            this.o.O();
        }
    }
}
