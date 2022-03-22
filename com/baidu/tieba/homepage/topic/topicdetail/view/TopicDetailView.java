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
import c.a.d.f.p.l;
import c.a.d.f.p.n;
import c.a.o0.s.c.l0;
import c.a.p0.q1.l.b.d.a;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.player.widget.BdThumbSeekBarView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ThreadData;
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
import java.util.Iterator;
import java.util.List;
/* loaded from: classes5.dex */
public class TopicDetailView extends RelativeLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public a.b A;
    public int B;
    public int C;
    public NoNetworkView.b D;
    public c.a.o0.w.y.b E;
    public NewWriteModel.g F;
    public final RecyclerView.OnScrollListener G;
    public BdListView.p H;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext<?> f33540b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.p0.q1.l.b.a f33541c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f33542d;

    /* renamed from: e  reason: collision with root package name */
    public View f33543e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f33544f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f33545g;

    /* renamed from: h  reason: collision with root package name */
    public TopicDetailHeadView f33546h;
    public BdTypeRecyclerView i;
    public c.a.p0.q1.l.b.b.b j;
    public PbListView k;
    public NoNetworkView l;
    public c.a.o0.f0.g m;
    public c.a.o0.f0.h n;
    public View o;
    public View p;
    public TextView q;
    public TextView r;
    public c.a.p0.q1.l.b.e.a s;
    public View t;
    public c.a.p0.s4.c u;
    public EditText v;
    public c.a.p0.q1.l.b.c.a w;
    public boolean x;
    public int y;
    public c.a.p0.q1.l.b.d.a z;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TopicDetailView a;

        public a(TopicDetailView topicDetailView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {topicDetailView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = topicDetailView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && l.A() && this.a.f33541c != null) {
                this.a.f33541c.loadData();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements NoNetworkView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TopicDetailView a;

        public b(TopicDetailView topicDetailView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {topicDetailView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = topicDetailView;
        }

        @Override // com.baidu.tbadk.core.view.NoNetworkView.b
        public void f(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && z && this.a.w == null && this.a.f33541c != null) {
                this.a.f33541c.loadData();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TopicDetailView a;

        public c(TopicDetailView topicDetailView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {topicDetailView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = topicDetailView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.a.o();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements TopicPkView.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TopicDetailView a;

        public d(TopicDetailView topicDetailView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {topicDetailView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = topicDetailView;
        }

        @Override // com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.f
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                this.a.G(i);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TopicDetailView a;

        public e(TopicDetailView topicDetailView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {topicDetailView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = topicDetailView;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, editable) == null) || this.a.u == null) {
                return;
            }
            if (!this.a.u.e()) {
                this.a.n(false);
            }
            this.a.u.l(false);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i, i2, i3) == null) {
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i, i2, i3) == null) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements c.a.o0.w.y.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TopicDetailView a;

        public f(TopicDetailView topicDetailView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {topicDetailView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = topicDetailView;
        }

        @Override // c.a.o0.w.y.b
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.a.u.d()) {
                    this.a.f33540b.showToast(this.a.u.c());
                    this.a.n(true);
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class g implements NewWriteModel.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TopicDetailView a;

        public g(TopicDetailView topicDetailView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {topicDetailView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = topicDetailView;
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.g
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, l0 l0Var, WriteData writeData, AntiData antiData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, l0Var, writeData, antiData}) == null) {
                if (z && this.a.s != null && this.a.s.a() != null) {
                    this.a.s.a().o();
                }
                if (z) {
                    this.a.u.n(null);
                    this.a.u.i(null);
                    this.a.u.k(false);
                    if (postWriteCallBackData != null) {
                        long g2 = c.a.d.f.m.b.g(postWriteCallBackData.getPostId(), 0L);
                        long g3 = c.a.d.f.m.b.g(postWriteCallBackData.getThreadId(), 0L);
                        if (g2 == 0 || g3 == 0) {
                            return;
                        }
                        this.a.A = this.a.z.c(g2, g3);
                        c.a.d.f.m.e.a().postDelayed(this.a.A, 500L);
                    }
                } else if (postWriteCallBackData == null || !postWriteCallBackData.isSensitiveError()) {
                } else {
                    this.a.u.i(postWriteCallBackData.getSensitiveWords());
                    this.a.u.n(postWriteCallBackData.getErrorString());
                    if (ListUtils.isEmpty(this.a.u.a())) {
                        return;
                    }
                    this.a.n(true);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TopicDetailView a;

        public h(TopicDetailView topicDetailView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {topicDetailView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = topicDetailView;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i) == null) {
                if (i != 0 && this.a.s != null) {
                    this.a.s.t();
                    this.a.setEditorTopViewAboveEditor();
                }
                super.onScrollStateChanged(this.a.i, i);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i, i2) == null) {
                super.onScrolled(recyclerView, i, i2);
                this.a.B += i2;
                this.a.F();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TopicDetailView a;

        public i(TopicDetailView topicDetailView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {topicDetailView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = topicDetailView;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.x) {
                if (!n.C()) {
                    this.a.q();
                    return;
                }
                int size = this.a.w.f17550f.size() - 1;
                if (this.a.w.f17550f.get(size) instanceof c.a.p0.q1.l.b.c.c) {
                    ((TopicDetailActivity) this.a.f33540b.getPageActivity()).requestNextPageThreadData(((c.a.p0.q1.l.b.c.c) this.a.w.f17550f.get(size)).a);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class j implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ShareItem a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ TopicDetailView f33547b;

        public j(TopicDetailView topicDetailView, ShareItem shareItem) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {topicDetailView, shareItem};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f33547b = topicDetailView;
            this.a = shareItem;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                c.a.d.f.p.c.a(this.a.t);
                n.N(this.f33547b.getContext(), view.getResources().getString(R.string.obfuscated_res_0x7f0f0438));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TopicDetailView(TbPageContext<?> tbPageContext, c.a.p0.q1.l.b.a aVar, Bundle bundle) {
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
        this.a = 3;
        this.p = null;
        this.q = null;
        this.r = null;
        this.x = true;
        this.B = 0;
        this.C = 44;
        this.D = new b(this);
        this.E = new f(this);
        this.F = new g(this);
        this.G = new h(this);
        this.H = new i(this);
        this.f33540b = tbPageContext;
        this.f33541c = aVar;
        t(bundle);
        x();
    }

    public void A(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || v()) {
            return;
        }
        if (this.m == null) {
            c.a.o0.f0.g gVar = new c.a.o0.f0.g(getContext());
            this.m = gVar;
            gVar.onChangeSkinType();
        }
        this.m.attachView(this, z);
    }

    public void B(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) || w()) {
            return;
        }
        if (this.n == null) {
            this.n = new c.a.o0.f0.h(getContext(), new a(this));
        }
        this.n.k(this.f33540b.getResources().getDimensionPixelSize(R.dimen.tbds506));
        this.n.attachView(this, z);
        this.n.p();
        this.i.setVisibility(8);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f33544f, R.drawable.obfuscated_res_0x7f080624, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.i.setNextPage(this.k);
            this.k.f();
        }
    }

    public final void D() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.w == null || getContext() == null) {
            return;
        }
        String valueOf = String.valueOf(this.w.a);
        c.a.p0.q1.l.b.c.a aVar = this.w;
        String str = aVar.f17546b;
        String str2 = aVar.f17547c;
        if (!TextUtils.isEmpty(valueOf) && !TextUtils.isEmpty(str)) {
            String str3 = "http://tieba.baidu.com/mo/q/newtopic/detail?topic_id=" + valueOf + "/";
            Uri parse = StringUtils.isNull(this.w.f17548d) ? null : Uri.parse(this.w.f17548d);
            ShareItem shareItem = new ShareItem();
            shareItem.r = str;
            shareItem.s = str2;
            shareItem.t = str3;
            shareItem.i = true;
            shareItem.q = valueOf;
            shareItem.v = parse;
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(getContext(), shareItem, true, true);
            shareDialogConfig.setIsCopyLink(true);
            shareDialogConfig.setCopyLinkListener(new j(this, shareItem));
            this.f33540b.sendMessage(new CustomMessage(2001276, shareDialogConfig));
            return;
        }
        this.f33540b.showToast(getContext().getString(R.string.obfuscated_res_0x7f0f0c3e));
    }

    public Bitmap E() {
        InterceptResult invokeV;
        Bitmap drawingCache;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            c.a.d.o.d.a bdImage = this.f33546h.getmBgImg().getBdImage();
            if (bdImage != null) {
                drawingCache = bdImage.p();
            } else {
                drawingCache = this.f33546h.getmBgImg().getDrawingCache();
            }
            int width = this.f33540b.getPageActivity().getWindowManager().getDefaultDisplay().getWidth();
            int height = this.f33542d.getHeight();
            return (drawingCache == null || drawingCache.getWidth() < width || drawingCache.getHeight() < height) ? drawingCache : Bitmap.createBitmap(drawingCache, 0, 0, width, height);
        }
        return (Bitmap) invokeV.objValue;
    }

    public final void F() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.w == null || this.f33546h == null) {
            return;
        }
        if (this.B > this.C) {
            this.f33542d.getBarBgView().setAlpha(1.0f);
            this.f33542d.getBarBgView().setBackgroundDrawable(new BitmapDrawable(E()));
            return;
        }
        SkinManager.setBackgroundColor(this.f33542d.getBarBgView(), R.color.transparent);
        this.f33542d.getBarBgView().setAlpha(0.0f);
    }

    public final void G(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.y = i2;
            this.r.setVisibility(0);
            if (i2 == 1) {
                this.r.setText(R.string.obfuscated_res_0x7f0f1403);
                SkinManager.setBackgroundResource(this.r, R.drawable.topic_discuss_support_bg);
            } else if (i2 == 2) {
                this.r.setText(R.string.obfuscated_res_0x7f0f1402);
                SkinManager.setBackgroundResource(this.r, R.drawable.topic_discuss_oppose_bg);
            } else {
                this.r.setText(R.string.obfuscated_res_0x7f0f1401);
                SkinManager.setBackgroundResource(this.r, R.drawable.topic_discuss_opinion_bg);
            }
            int i3 = this.a;
            if (i3 != 1 && i3 != 4) {
                SkinManager.setViewTextColor(this.r, (int) R.color.CAM_X0101);
            } else {
                this.r.setTextColor(BdThumbSeekBarView.UI_DRAG_TRACE_COLOR);
            }
        }
    }

    public c.a.p0.q1.l.b.e.a getEditor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.s : (c.a.p0.q1.l.b.e.a) invokeV.objValue;
    }

    public void n(boolean z) {
        EditText editText;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) || (editText = this.v) == null || editText.getText() == null) {
            return;
        }
        int selectionEnd = this.v.getSelectionEnd();
        SpannableStringBuilder f2 = this.u.f(this.v.getText());
        if (f2 != null) {
            this.u.l(true);
            this.v.setText(f2);
            if (z && this.u.b() >= 0) {
                this.v.requestFocus();
                this.v.setSelection(this.u.b());
            } else {
                this.v.setSelection(selectionEnd);
            }
            c.a.p0.s4.c cVar = this.u;
            cVar.k(cVar.b() >= 0);
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            if (ViewHelper.checkUpIsLogin(getContext())) {
                this.s.L();
                setEditorTopViewAboveEditor();
            }
            if (this.w != null) {
                TiebaStatic.log(new StatisticItem("c13359").param("topic_id", String.valueOf(this.w.a)));
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        c.a.p0.q1.l.b.c.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, view) == null) {
            if (view == this.f33543e) {
                this.f33540b.getPageActivity().finish();
            } else if (view != this.f33545g || (aVar = this.w) == null || aVar.a <= 0) {
            } else {
                D();
                TiebaStatic.log(new StatisticItem("c13364").param("topic_id", String.valueOf(this.w.a)));
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
            this.i.setOnSrollToBottomListener(null);
            NoNetworkView noNetworkView = this.l;
            if (noNetworkView != null) {
                noNetworkView.d(this.D);
            }
            c.a.p0.q1.l.b.e.a aVar = this.s;
            if (aVar != null) {
                aVar.w();
            }
            if (this.A != null) {
                c.a.d.f.m.e.a().removeCallbacks(this.A);
            }
            r();
            s();
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.i.setNextPage(null);
        }
    }

    public void r() {
        c.a.o0.f0.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || (gVar = this.m) == null) {
            return;
        }
        gVar.dettachView(this);
        this.m = null;
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            c.a.o0.f0.h hVar = this.n;
            if (hVar != null) {
                hVar.dettachView(this);
                this.n = null;
            }
            this.i.setVisibility(0);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f33544f, R.drawable.obfuscated_res_0x7f080624, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public void setData(c.a.p0.q1.l.b.c.a aVar) {
        int f2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048592, this, aVar) == null) || aVar == null) {
            return;
        }
        this.w = aVar;
        boolean z = aVar.f17551g;
        this.x = z;
        if (z && aVar.f17550f.size() <= 4) {
            this.x = false;
            C();
        } else if (!this.x) {
            C();
        } else {
            z();
        }
        if (!StringUtils.isNull(aVar.f17546b)) {
            this.f33542d.setCenterTextTitle(String.format(getContext().getString(R.string.obfuscated_res_0x7f0f0469), StringHelper.cutChineseAndEnglishWithSuffix(aVar.f17546b, 14, StringHelper.STRING_MORE)));
        }
        this.f33546h.setData(aVar.f17549e);
        this.i.s(this.f33546h);
        this.j.c(aVar.f17550f);
        c.a.p0.q1.l.c.c.b bVar = this.w.f17549e.f17556e;
        if (bVar != null) {
            if (bVar.f17591d.f17597e) {
                G(1);
            } else if (bVar.f17592e.f17597e) {
                G(2);
            } else {
                G(0);
            }
            f2 = n.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds140);
        } else {
            f2 = n.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds50);
            this.r.setVisibility(8);
        }
        this.q.setPadding(f2, 0, 0, 0);
        F();
    }

    public void setEditorTopViewAboveEditor() {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (view = this.t) == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            if (this.s.a().v()) {
                layoutParams2.addRule(2, this.s.a().getId());
            } else {
                layoutParams2.addRule(2, this.o.getId());
            }
            this.t.setLayoutParams(layoutParams2);
        }
    }

    public void setNextData(int i2, boolean z, List<c.a.d.o.e.n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), list}) == null) {
            this.x = z;
            if (!z) {
                C();
            } else {
                z();
            }
            if (i2 != 0 || list == null || ListUtils.isEmpty(list)) {
                return;
            }
            for (c.a.d.o.e.n nVar : list) {
                if (nVar instanceof c.a.p0.q1.l.b.c.c) {
                    ((c.a.p0.q1.l.b.c.c) nVar).f17563f = this.w.a();
                }
            }
            this.w.f17550f.addAll(list);
            this.i.setData(this.w.f17550f);
        }
    }

    public final void t(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, bundle) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d0058, (ViewGroup) this, true);
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.obfuscated_res_0x7f09007e);
            this.f33542d = navigationBar;
            if (this.f33543e == null) {
                View addSystemImageButton = navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
                this.f33543e = addSystemImageButton;
                addSystemImageButton.setOnClickListener(this);
                this.f33544f = (ImageView) this.f33543e.findViewById(R.id.obfuscated_res_0x7f09246f);
            }
            this.f33545g = (ImageView) this.f33542d.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.obfuscated_res_0x7f0d0844, this);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f33545g, R.drawable.obfuscated_res_0x7f0809c4, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SkinManager.setViewTextColor(this.f33542d.mCenterText, (int) R.color.CAM_X0101);
            this.f33542d.mCenterText.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.tbds52));
            this.f33542d.mCenterText.setTypeface(Typeface.defaultFromStyle(1));
            NoNetworkView noNetworkView = (NoNetworkView) findViewById(R.id.obfuscated_res_0x7f09007f);
            this.l = noNetworkView;
            noNetworkView.a(this.D);
            this.p = findViewById(R.id.obfuscated_res_0x7f0916a4);
            TextView textView = (TextView) findViewById(R.id.obfuscated_res_0x7f0920eb);
            this.q = textView;
            textView.setOnClickListener(new c(this));
            this.r = (TextView) findViewById(R.id.obfuscated_res_0x7f090866);
            this.o = findViewById(R.id.obfuscated_res_0x7f09007b);
            u(bundle);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            addView(this.s.a(), layoutParams);
            this.u = new c.a.p0.s4.c();
            this.t = findViewById(R.id.obfuscated_res_0x7f09007c);
            BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) findViewById(R.id.obfuscated_res_0x7f09007d);
            this.i = bdTypeRecyclerView;
            bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            this.i.setFadingEdgeLength(0);
            this.i.setOverScrollMode(2);
            this.i.setOnSrollToBottomListener(this.H);
            this.i.addOnScrollListener(this.G);
            SkinManager.setBackgroundColor(this.i, R.color.CAM_X0201);
            this.j = new c.a.p0.q1.l.b.b.b(this.f33540b, this.i);
            TopicDetailHeadView topicDetailHeadView = new TopicDetailHeadView(getContext());
            this.f33546h = topicDetailHeadView;
            topicDetailHeadView.f33538g.setPkClickListener(new d(this));
            if (this.m == null) {
                PbListView pbListView = new PbListView(this.f33540b.getPageActivity());
                this.k = pbListView;
                pbListView.b();
            }
            this.k.p(R.color.CAM_X0205);
            this.k.t(n.f(this.f33540b.getPageActivity(), R.dimen.tbds182));
            this.k.H(R.dimen.tbfontsize33);
            this.k.B(R.color.CAM_X0110);
            this.k.F(SkinManager.getColor(R.color.CAM_X0110));
            this.k.p(SkinManager.getColor(R.color.CAM_X0201));
            this.k.x(SkinManager.getColor(R.color.CAM_X0204));
            this.k.D(getResources().getString(R.string.obfuscated_res_0x7f0f09e6));
            this.k.b().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            if (this.z == null) {
                c.a.p0.q1.l.b.d.a aVar = new c.a.p0.q1.l.b.d.a(this);
                this.z = aVar;
                aVar.f(this.f33540b.getUniqueId());
            }
        }
    }

    public final void u(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, bundle) == null) {
            c.a.p0.q1.l.b.e.a aVar = (c.a.p0.q1.l.b.e.a) new c.a.p0.q1.l.b.e.b().a(getContext());
            this.s = aVar;
            if (aVar == null) {
                return;
            }
            aVar.E(this.f33540b);
            this.s.F(this.F);
            this.s.D(this.E);
            this.s.a().C(true);
            this.s.a().setBarBackgroundColorId(R.color.CAM_X0207);
            this.s.u((BaseActivity) getContext(), bundle);
            this.s.t();
            this.s.a().setId(R.id.obfuscated_res_0x7f0920ea);
            EditText f2 = this.s.n().f();
            this.v = f2;
            f2.addTextChangedListener(new e(this));
        }
    }

    public boolean v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            c.a.o0.f0.g gVar = this.m;
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
            c.a.o0.f0.h hVar = this.n;
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
        if (!(interceptable == null || interceptable.invokeV(1048599, this) == null) || (skinType = TbadkCoreApplication.getInst().getSkinType()) == this.a) {
            return;
        }
        this.a = skinType;
        F();
        SkinManager.setViewTextColor(this.f33542d.mCenterText, (int) R.color.CAM_X0101);
        SkinManager.setBackgroundResource(this.p, R.color.CAM_X0207);
        SkinManager.setViewTextColor(this.q, (int) R.color.CAM_X0109);
        this.q.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(n.f(this.f33540b.getPageActivity(), R.dimen.tbds47), SkinManager.getColor(R.color.CAM_X0209)));
        G(this.y);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f33544f, R.drawable.obfuscated_res_0x7f080624, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        if (this.f33545g != null) {
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f33545g, R.drawable.obfuscated_res_0x7f0809c4, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        TbPageContext<?> tbPageContext = this.f33540b;
        if (tbPageContext != null && (noNetworkView = this.l) != null) {
            noNetworkView.c(tbPageContext, this.a);
        }
        c.a.o0.f0.g gVar = this.m;
        if (gVar != null) {
            gVar.onChangeSkinType();
        }
        c.a.o0.f0.h hVar = this.n;
        if (hVar != null) {
            hVar.onChangeSkinType();
        }
        c.a.p0.q1.l.b.e.a aVar = this.s;
        if (aVar != null && aVar.a() != null) {
            this.s.a().w(this.a);
        }
        PbListView pbListView = this.k;
        if (pbListView != null) {
            pbListView.B(R.color.CAM_X0110);
            this.k.F(SkinManager.getColor(R.color.CAM_X0110));
            this.k.p(SkinManager.getColor(R.color.CAM_X0201));
            this.k.x(SkinManager.getColor(R.color.CAM_X0204));
        }
        TopicDetailHeadView topicDetailHeadView = this.f33546h;
        if (topicDetailHeadView != null) {
            topicDetailHeadView.b();
        }
        c.a.p0.q1.l.b.b.b bVar = this.j;
        if (bVar != null) {
            bVar.b();
        }
        SkinManager.setBackgroundColor(this.i, R.color.CAM_X0205);
    }

    public void y(ThreadData threadData) {
        c.a.p0.q1.l.b.c.c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, threadData) == null) {
            Iterator<c.a.d.o.e.n> it = this.w.f17550f.iterator();
            int i2 = 0;
            while (true) {
                if (!it.hasNext()) {
                    cVar = null;
                    break;
                }
                c.a.d.o.e.n next = it.next();
                if (next instanceof c.a.p0.q1.l.b.c.c) {
                    cVar = (c.a.p0.q1.l.b.c.c) next;
                    break;
                }
                i2++;
            }
            if (cVar != null) {
                c.a.p0.q1.l.b.c.c cVar2 = new c.a.p0.q1.l.b.c.c();
                cVar2.a = cVar.a;
                cVar2.f17559b = threadData;
                cVar2.f17562e = 2;
                cVar2.f17561d = this.y;
                c.a.p0.q1.l.b.c.a aVar = this.w;
                cVar2.f17560c = aVar.a;
                cVar2.f17563f = aVar.a();
                this.w.f17550f.add(i2, cVar2);
                this.j.c(this.w.f17550f);
            }
        }
    }

    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            this.x = true;
            this.i.setNextPage(this.k);
            this.k.R();
        }
    }
}
