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
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.util.AndroidUtils;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ImageView.BdImage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.player.widget.BdThumbSeekBarView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
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
import com.baidu.tbadk.loading.LoadingView;
import com.baidu.tieba.R;
import com.baidu.tieba.b78;
import com.baidu.tieba.f78;
import com.baidu.tieba.g78;
import com.baidu.tieba.h78;
import com.baidu.tieba.homepage.topic.topicdetail.TopicDetailActivity;
import com.baidu.tieba.homepage.topic.topictab.view.TopicPkView;
import com.baidu.tieba.jd5;
import com.baidu.tieba.mj5;
import com.baidu.tieba.om5;
import com.baidu.tieba.p78;
import com.baidu.tieba.qsa;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.v68;
import com.baidu.tieba.x68;
import com.baidu.tieba.ym;
import com.baidu.tieba.z68;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes6.dex */
public class TopicDetailView extends RelativeLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public f78.b A;
    public int B;
    public int C;
    public NoNetworkView.b D;
    public mj5 E;
    public NewWriteModel.d F;
    public final RecyclerView.OnScrollListener G;
    public BdListView.p H;
    public int a;
    public TbPageContext<?> b;
    public v68 c;
    public NavigationBar d;
    public View e;
    public ImageView f;
    public ImageView g;
    public TopicDetailHeadView h;
    public BdTypeRecyclerView i;
    public x68 j;
    public PbListView k;
    public NoNetworkView l;
    public LoadingView m;
    public om5 n;
    public View o;
    public View p;
    public TextView q;
    public TextView r;
    public g78 s;
    public View t;
    public qsa u;
    public EditText v;
    public z68 w;
    public boolean x;
    public int y;
    public f78 z;

    /* loaded from: classes6.dex */
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
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && BdNetTypeUtil.isNetworkAvailableForImmediately() && this.a.c != null) {
                this.a.c.b();
            }
        }
    }

    /* loaded from: classes6.dex */
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
        public void k(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && z && this.a.w == null && this.a.c != null) {
                this.a.c.b();
            }
        }
    }

    /* loaded from: classes6.dex */
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
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.o();
            }
        }
    }

    /* loaded from: classes6.dex */
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
            if (interceptable != null && interceptable.invokeI(1048576, this, i) != null) {
                return;
            }
            this.a.I(i);
        }
    }

    /* loaded from: classes6.dex */
    public class e implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TopicDetailView a;

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
            if ((interceptable != null && interceptable.invokeL(1048576, this, editable) != null) || this.a.u == null) {
                return;
            }
            if (!this.a.u.e()) {
                this.a.n(false);
            }
            this.a.u.l(false);
        }
    }

    /* loaded from: classes6.dex */
    public class f implements mj5 {
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

        @Override // com.baidu.tieba.mj5
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.a.u.d()) {
                    this.a.b.showToast(this.a.u.c());
                    this.a.n(true);
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class g implements NewWriteModel.d {
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

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, jd5 jd5Var, WriteData writeData, AntiData antiData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, jd5Var, writeData, antiData}) == null) {
                if (z && this.a.s != null && this.a.s.b() != null) {
                    this.a.s.b().q();
                }
                if (z) {
                    this.a.u.n(null);
                    this.a.u.i(null);
                    this.a.u.k(false);
                    if (postWriteCallBackData != null) {
                        long j = JavaTypesHelper.toLong(postWriteCallBackData.getPostId(), 0L);
                        long j2 = JavaTypesHelper.toLong(postWriteCallBackData.getThreadId(), 0L);
                        if (j != 0 && j2 != 0) {
                            this.a.A = this.a.z.c(j, j2);
                            SafeHandler.getInst().postDelayed(this.a.A, 500L);
                        }
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
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

    /* loaded from: classes6.dex */
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
                    this.a.s.u();
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
                this.a.H();
            }
        }
    }

    /* loaded from: classes6.dex */
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
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || !this.a.x) {
                return;
            }
            if (!BdUtilHelper.isNetOk()) {
                this.a.q();
                return;
            }
            int size = this.a.w.f.size() - 1;
            if (this.a.w.f.get(size) instanceof b78) {
                ((TopicDetailActivity) this.a.b.getPageActivity()).w1(((b78) this.a.w.f.get(size)).a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class j implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ShareItem a;
        public final /* synthetic */ TopicDetailView b;

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
            this.b = topicDetailView;
            this.a = shareItem;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                AndroidUtils.copyToClipboard(this.a.linkUrl);
                BdUtilHelper.showToast(this.b.getContext(), view2.getResources().getString(R.string.copy_pb_url_success));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TopicDetailView(TbPageContext<?> tbPageContext, v68 v68Var, Bundle bundle) {
        super(tbPageContext.getPageActivity());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, v68Var, bundle};
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
        this.b = tbPageContext;
        this.c = v68Var;
        t(bundle);
        z();
    }

    public void setNextData(int i2, boolean z, List<ym> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048596, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), list}) == null) {
            this.x = z;
            if (!z) {
                E();
            } else {
                B();
            }
            if (i2 == 0 && list != null && !ListUtils.isEmpty(list)) {
                for (ym ymVar : list) {
                    if (ymVar instanceof b78) {
                        ((b78) ymVar).f = this.w.a();
                    }
                }
                this.w.f.addAll(list);
                this.i.setData(this.w.f);
            }
        }
    }

    public void C(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) != null) || x()) {
            return;
        }
        if (this.m == null) {
            LoadingView loadingView = new LoadingView(getContext());
            this.m = loadingView;
            loadingView.onChangeSkinType();
        }
        this.m.attachView(this, z);
    }

    public void A(ThreadData threadData) {
        b78 b78Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, threadData) == null) {
            Iterator<ym> it = this.w.f.iterator();
            int i2 = 0;
            while (true) {
                if (it.hasNext()) {
                    ym next = it.next();
                    if (next instanceof b78) {
                        b78Var = (b78) next;
                        break;
                    }
                    i2++;
                } else {
                    b78Var = null;
                    break;
                }
            }
            if (b78Var != null) {
                b78 b78Var2 = new b78();
                b78Var2.a = b78Var.a;
                b78Var2.b = threadData;
                b78Var2.e = 2;
                b78Var2.d = this.y;
                z68 z68Var = this.w;
                b78Var2.c = z68Var.a;
                b78Var2.f = z68Var.a();
                this.w.f.add(i2, b78Var2);
                this.j.c(this.w.f);
            }
        }
    }

    public void D(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048579, this, z) != null) || y()) {
            return;
        }
        if (this.n == null) {
            this.n = new om5(getContext(), new a(this));
        }
        this.n.j(this.b.getResources().getDimensionPixelSize(R.dimen.tbds506));
        this.n.attachView(this, z);
        this.n.o();
        this.i.setVisibility(8);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        z68 z68Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, view2) == null) {
            if (view2 == this.e) {
                this.b.getPageActivity().finish();
            } else if (view2 == this.g && (z68Var = this.w) != null && z68Var.a > 0) {
                F();
                TiebaStatic.log(new StatisticItem("c13364").param("topic_id", String.valueOf(this.w.a)));
            }
        }
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.x = true;
            this.i.setNextPage(this.k);
            this.k.U();
        }
    }

    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.i.setNextPage(this.k);
            this.k.g();
        }
    }

    public g78 getEditor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.s;
        }
        return (g78) invokeV.objValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            p();
            super.onDetachedFromWindow();
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.i.setNextPage(null);
        }
    }

    public void r() {
        LoadingView loadingView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && (loadingView = this.m) != null) {
            loadingView.dettachView(this);
            this.m = null;
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            om5 om5Var = this.n;
            if (om5Var != null) {
                om5Var.dettachView(this);
                this.n = null;
            }
            this.i.setVisibility(0);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public boolean x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            LoadingView loadingView = this.m;
            if (loadingView != null) {
                return loadingView.isViewAttached();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            om5 om5Var = this.n;
            if (om5Var != null) {
                return om5Var.isViewAttached();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void F() {
        Uri parse;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && this.w != null && getContext() != null) {
            String valueOf = String.valueOf(this.w.a);
            z68 z68Var = this.w;
            String str = z68Var.b;
            String str2 = z68Var.c;
            if (!TextUtils.isEmpty(valueOf) && !TextUtils.isEmpty(str)) {
                String str3 = TbConfig.TIEBA_ADDRESS + "mo/q/newtopic/detail?topic_id=" + valueOf + "/";
                if (StringUtils.isNull(this.w.d)) {
                    parse = null;
                } else {
                    parse = Uri.parse(this.w.d);
                }
                ShareItem shareItem = new ShareItem();
                shareItem.title = str;
                shareItem.content = str2;
                shareItem.linkUrl = str3;
                shareItem.isFromTopicDetail = true;
                shareItem.extData = valueOf;
                shareItem.imageUri = parse;
                ShareDialogConfig shareDialogConfig = new ShareDialogConfig(getContext(), shareItem, true, true);
                shareDialogConfig.setIsCopyLink(true);
                shareDialogConfig.setCopyLinkListener(new j(this, shareItem));
                this.b.sendMessage(new CustomMessage(2001276, shareDialogConfig));
                return;
            }
            this.b.showToast(getContext().getString(R.string.no_hot_topic_data));
        }
    }

    public Bitmap G() {
        InterceptResult invokeV;
        Bitmap drawingCache;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            BdImage bdImage = this.h.getmBgImg().getBdImage();
            if (bdImage != null) {
                drawingCache = bdImage.getRawBitmap();
            } else {
                drawingCache = this.h.getmBgImg().getDrawingCache();
            }
            int width = this.b.getPageActivity().getWindowManager().getDefaultDisplay().getWidth();
            int height = this.d.getHeight();
            if (drawingCache != null && drawingCache.getWidth() >= width && drawingCache.getHeight() >= height) {
                return Bitmap.createBitmap(drawingCache, 0, 0, width, height);
            }
            return drawingCache;
        }
        return (Bitmap) invokeV.objValue;
    }

    public final void H() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && this.w != null && this.h != null) {
            if (this.B > this.C) {
                this.d.getBarBgView().setAlpha(1.0f);
                this.d.getBarBgView().setBackgroundDrawable(new BitmapDrawable(G()));
                return;
            }
            SkinManager.setBackgroundColor(this.d.getBarBgView(), R.color.transparent);
            this.d.getBarBgView().setAlpha(0.0f);
        }
    }

    public void setEditorTopViewAboveEditor() {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048595, this) == null) && (view2 = this.t) != null) {
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                if (this.s.b().y()) {
                    layoutParams2.addRule(2, this.s.b().getId());
                } else {
                    layoutParams2.addRule(2, this.o.getId());
                }
                this.t.setLayoutParams(layoutParams2);
            }
        }
    }

    public final void I(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.y = i2;
            this.r.setVisibility(0);
            if (i2 == 1) {
                this.r.setText(R.string.obfuscated_res_0x7f0f16ba);
                SkinManager.setBackgroundResource(this.r, R.drawable.topic_discuss_support_bg);
            } else if (i2 == 2) {
                this.r.setText(R.string.obfuscated_res_0x7f0f16b9);
                SkinManager.setBackgroundResource(this.r, R.drawable.topic_discuss_oppose_bg);
            } else {
                this.r.setText(R.string.obfuscated_res_0x7f0f16b8);
                SkinManager.setBackgroundResource(this.r, R.drawable.topic_discuss_opinion_bg);
            }
            if (this.a == 4) {
                this.r.setTextColor(BdThumbSeekBarView.UI_DRAG_TRACE_COLOR);
            } else {
                SkinManager.setViewTextColor(this.r, (int) R.color.CAM_X0101);
            }
        }
    }

    public void n(boolean z) {
        EditText editText;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048586, this, z) == null) && (editText = this.v) != null && editText.getText() != null) {
            int selectionEnd = this.v.getSelectionEnd();
            SpannableStringBuilder f2 = this.u.f(this.v.getText());
            if (f2 != null) {
                boolean z2 = true;
                this.u.l(true);
                this.v.setText(f2);
                if (z && this.u.b() >= 0) {
                    this.v.requestFocus();
                    this.v.setSelection(this.u.b());
                } else {
                    this.v.setSelection(selectionEnd);
                }
                qsa qsaVar = this.u;
                if (qsaVar.b() < 0) {
                    z2 = false;
                }
                qsaVar.k(z2);
            }
        }
    }

    public final void u(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, bundle) == null) {
            g78 g78Var = (g78) new h78().a(getContext());
            this.s = g78Var;
            if (g78Var == null) {
                return;
            }
            g78Var.F(this.b);
            this.s.G(this.F);
            this.s.E(this.E);
            this.s.b().F(true);
            this.s.b().setBarBackgroundColorId(R.color.CAM_X0207);
            this.s.v((BaseActivity) getContext(), bundle);
            this.s.u();
            this.s.b().setId(R.id.obfuscated_res_0x7f09262d);
            EditText g2 = this.s.o().g();
            this.v = g2;
            g2.addTextChangedListener(new e(this));
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            if (ViewHelper.checkUpIsLogin(getContext())) {
                this.s.M();
                setEditorTopViewAboveEditor();
            }
            if (this.w != null) {
                TiebaStatic.log(new StatisticItem("c13359").param("topic_id", String.valueOf(this.w.a)));
            }
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.i.setOnSrollToBottomListener(null);
            NoNetworkView noNetworkView = this.l;
            if (noNetworkView != null) {
                noNetworkView.removeNetworkChangeListener(this.D);
            }
            g78 g78Var = this.s;
            if (g78Var != null) {
                g78Var.x();
            }
            if (this.A != null) {
                SafeHandler.getInst().removeCallbacks(this.A);
            }
            r();
            s();
        }
    }

    public void setData(z68 z68Var) {
        int dimens;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048594, this, z68Var) != null) || z68Var == null) {
            return;
        }
        this.w = z68Var;
        boolean z = z68Var.g;
        this.x = z;
        if (z && z68Var.f.size() <= 4) {
            this.x = false;
            E();
        } else if (!this.x) {
            E();
        } else {
            B();
        }
        if (!StringUtils.isNull(z68Var.b)) {
            this.d.setCenterTextTitle(String.format(getContext().getString(R.string.obfuscated_res_0x7f0f051d), StringHelper.cutChineseAndEnglishWithSuffix(z68Var.b, 14, "...")));
        }
        this.h.setData(z68Var.e);
        this.i.addHeaderView(this.h);
        this.j.c(z68Var.f);
        p78 p78Var = this.w.e.e;
        if (p78Var != null) {
            if (p78Var.d.e) {
                I(1);
            } else if (p78Var.e.e) {
                I(2);
            } else {
                I(0);
            }
            dimens = BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds140);
        } else {
            dimens = BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds50);
            this.r.setVisibility(8);
        }
        this.q.setPadding(dimens, 0, 0, 0);
        H();
    }

    public final void t(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, bundle) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d005a, (ViewGroup) this, true);
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.obfuscated_res_0x7f090091);
            this.d = navigationBar;
            if (this.e == null) {
                View addSystemImageButton = navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
                this.e = addSystemImageButton;
                addSystemImageButton.setOnClickListener(this);
                this.f = (ImageView) this.e.findViewById(R.id.widget_navi_back_button);
            }
            this.g = (ImageView) this.d.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.obfuscated_res_0x7f0d099b, this);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.g, R.drawable.icon_pure_topbar_share44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SkinManager.setViewTextColor(this.d.mCenterText, (int) R.color.CAM_X0101);
            this.d.mCenterText.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.tbds52));
            this.d.mCenterText.setTypeface(Typeface.defaultFromStyle(1));
            NoNetworkView noNetworkView = (NoNetworkView) findViewById(R.id.obfuscated_res_0x7f090092);
            this.l = noNetworkView;
            noNetworkView.addNetworkChangeListener(this.D);
            this.p = findViewById(R.id.obfuscated_res_0x7f091a93);
            TextView textView = (TextView) findViewById(R.id.obfuscated_res_0x7f09262e);
            this.q = textView;
            textView.setOnClickListener(new c(this));
            this.r = (TextView) findViewById(R.id.obfuscated_res_0x7f090990);
            this.o = findViewById(R.id.obfuscated_res_0x7f09008e);
            u(bundle);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            addView(this.s.b(), layoutParams);
            this.u = new qsa();
            this.t = findViewById(R.id.obfuscated_res_0x7f09008f);
            BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) findViewById(R.id.obfuscated_res_0x7f090090);
            this.i = bdTypeRecyclerView;
            bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            this.i.setFadingEdgeLength(0);
            this.i.setOverScrollMode(2);
            this.i.setOnSrollToBottomListener(this.H);
            this.i.addOnScrollListener(this.G);
            SkinManager.setBackgroundColor(this.i, R.color.CAM_X0201);
            this.j = new x68(this.b, this.i);
            TopicDetailHeadView topicDetailHeadView = new TopicDetailHeadView(getContext());
            this.h = topicDetailHeadView;
            topicDetailHeadView.g.setPkClickListener(new d(this));
            if (this.m == null) {
                PbListView pbListView = new PbListView(this.b.getPageActivity());
                this.k = pbListView;
                pbListView.c();
            }
            this.k.s(R.color.CAM_X0205);
            this.k.w(BdUtilHelper.getDimens(this.b.getPageActivity(), R.dimen.tbds182));
            this.k.L(R.dimen.tbfontsize33);
            this.k.F(R.color.CAM_X0110);
            this.k.J(SkinManager.getColor(R.color.CAM_X0110));
            this.k.s(SkinManager.getColor(R.color.CAM_X0201));
            this.k.A(SkinManager.getColor(R.color.CAM_X0204));
            this.k.H(getResources().getString(R.string.list_has_no_more));
            this.k.c().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            if (this.z == null) {
                f78 f78Var = new f78(this);
                this.z = f78Var;
                f78Var.f(this.b.getUniqueId());
            }
        }
    }

    public void z() {
        int skinType;
        NoNetworkView noNetworkView;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048601, this) != null) || (skinType = TbadkCoreApplication.getInst().getSkinType()) == this.a) {
            return;
        }
        this.a = skinType;
        H();
        SkinManager.setViewTextColor(this.d.mCenterText, (int) R.color.CAM_X0101);
        SkinManager.setBackgroundResource(this.p, R.color.CAM_X0207);
        SkinManager.setViewTextColor(this.q, (int) R.color.CAM_X0109);
        this.q.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(BdUtilHelper.getDimens(this.b.getPageActivity(), R.dimen.tbds47), SkinManager.getColor(R.color.CAM_X0209)));
        I(this.y);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        if (this.g != null) {
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.g, R.drawable.icon_pure_topbar_share44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        TbPageContext<?> tbPageContext = this.b;
        if (tbPageContext != null && (noNetworkView = this.l) != null) {
            noNetworkView.onChangeSkinType(tbPageContext, this.a);
        }
        LoadingView loadingView = this.m;
        if (loadingView != null) {
            loadingView.onChangeSkinType();
        }
        om5 om5Var = this.n;
        if (om5Var != null) {
            om5Var.onChangeSkinType();
        }
        g78 g78Var = this.s;
        if (g78Var != null && g78Var.b() != null) {
            this.s.b().z(this.a);
        }
        PbListView pbListView = this.k;
        if (pbListView != null) {
            pbListView.F(R.color.CAM_X0110);
            this.k.J(SkinManager.getColor(R.color.CAM_X0110));
            this.k.s(SkinManager.getColor(R.color.CAM_X0201));
            this.k.A(SkinManager.getColor(R.color.CAM_X0204));
        }
        TopicDetailHeadView topicDetailHeadView = this.h;
        if (topicDetailHeadView != null) {
            topicDetailHeadView.b();
        }
        x68 x68Var = this.j;
        if (x68Var != null) {
            x68Var.b();
        }
        SkinManager.setBackgroundColor(this.i, R.color.CAM_X0205);
    }
}
