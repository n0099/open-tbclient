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
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.StringUtils;
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
import com.baidu.tieba.R;
import com.baidu.tieba.de5;
import com.baidu.tieba.dk5;
import com.baidu.tieba.dn5;
import com.baidu.tieba.en5;
import com.baidu.tieba.f48;
import com.baidu.tieba.h48;
import com.baidu.tieba.homepage.topic.topicdetail.TopicDetailActivity;
import com.baidu.tieba.homepage.topic.topictab.view.TopicPkView;
import com.baidu.tieba.in;
import com.baidu.tieba.j48;
import com.baidu.tieba.l48;
import com.baidu.tieba.ni;
import com.baidu.tieba.nka;
import com.baidu.tieba.p48;
import com.baidu.tieba.q48;
import com.baidu.tieba.r48;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.vg;
import com.baidu.tieba.xi;
import com.baidu.tieba.xn;
import com.baidu.tieba.yg;
import com.baidu.tieba.z48;
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
    public p48.b A;
    public int B;
    public int C;
    public NoNetworkView.b D;
    public dk5 E;
    public NewWriteModel.d F;
    public final RecyclerView.OnScrollListener G;
    public BdListView.p H;
    public int a;
    public TbPageContext<?> b;
    public f48 c;
    public NavigationBar d;
    public View e;
    public ImageView f;
    public ImageView g;
    public TopicDetailHeadView h;
    public BdTypeRecyclerView i;
    public h48 j;
    public PbListView k;
    public NoNetworkView l;
    public dn5 m;
    public en5 n;
    public View o;
    public View p;
    public TextView q;
    public TextView r;
    public q48 s;
    public View t;
    public nka u;
    public EditText v;
    public j48 w;
    public boolean x;
    public int y;
    public p48 z;

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
                this.a.c.a();
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
        public void i(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && z && this.a.w == null && this.a.c != null) {
                this.a.c.a();
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
    public class f implements dk5 {
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

        @Override // com.baidu.tieba.dk5
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
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, de5 de5Var, WriteData writeData, AntiData antiData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, de5Var, writeData, antiData}) == null) {
                if (z && this.a.s != null && this.a.s.b() != null) {
                    this.a.s.b().q();
                }
                if (z) {
                    this.a.u.n(null);
                    this.a.u.i(null);
                    this.a.u.k(false);
                    if (postWriteCallBackData != null) {
                        long g = vg.g(postWriteCallBackData.getPostId(), 0L);
                        long g2 = vg.g(postWriteCallBackData.getThreadId(), 0L);
                        if (g != 0 && g2 != 0) {
                            this.a.A = this.a.z.c(g, g2);
                            yg.a().postDelayed(this.a.A, 500L);
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
            if (!xi.F()) {
                this.a.q();
                return;
            }
            int size = this.a.w.f.size() - 1;
            if (this.a.w.f.get(size) instanceof l48) {
                ((TopicDetailActivity) this.a.b.getPageActivity()).z1(((l48) this.a.w.f.get(size)).a);
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
                ni.a(this.a.x);
                xi.Q(this.b.getContext(), view2.getResources().getString(R.string.copy_pb_url_success));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TopicDetailView(TbPageContext<?> tbPageContext, f48 f48Var, Bundle bundle) {
        super(tbPageContext.getPageActivity());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, f48Var, bundle};
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
        this.c = f48Var;
        t(bundle);
        z();
    }

    public void setNextData(int i2, boolean z, List<xn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048596, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), list}) == null) {
            this.x = z;
            if (!z) {
                E();
            } else {
                B();
            }
            if (i2 == 0 && list != null && !ListUtils.isEmpty(list)) {
                for (xn xnVar : list) {
                    if (xnVar instanceof l48) {
                        ((l48) xnVar).f = this.w.a();
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
            dn5 dn5Var = new dn5(getContext());
            this.m = dn5Var;
            dn5Var.onChangeSkinType();
        }
        this.m.attachView(this, z);
    }

    public void A(ThreadData threadData) {
        l48 l48Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, threadData) == null) {
            Iterator<xn> it = this.w.f.iterator();
            int i2 = 0;
            while (true) {
                if (it.hasNext()) {
                    xn next = it.next();
                    if (next instanceof l48) {
                        l48Var = (l48) next;
                        break;
                    }
                    i2++;
                } else {
                    l48Var = null;
                    break;
                }
            }
            if (l48Var != null) {
                l48 l48Var2 = new l48();
                l48Var2.a = l48Var.a;
                l48Var2.b = threadData;
                l48Var2.e = 2;
                l48Var2.d = this.y;
                j48 j48Var = this.w;
                l48Var2.c = j48Var.a;
                l48Var2.f = j48Var.a();
                this.w.f.add(i2, l48Var2);
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
            this.n = new en5(getContext(), new a(this));
        }
        this.n.k(this.b.getResources().getDimensionPixelSize(R.dimen.tbds506));
        this.n.attachView(this, z);
        this.n.p();
        this.i.setVisibility(8);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        j48 j48Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, view2) == null) {
            if (view2 == this.e) {
                this.b.getPageActivity().finish();
            } else if (view2 == this.g && (j48Var = this.w) != null && j48Var.a > 0) {
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

    public q48 getEditor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.s;
        }
        return (q48) invokeV.objValue;
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
        dn5 dn5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && (dn5Var = this.m) != null) {
            dn5Var.dettachView(this);
            this.m = null;
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            en5 en5Var = this.n;
            if (en5Var != null) {
                en5Var.dettachView(this);
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
            dn5 dn5Var = this.m;
            if (dn5Var != null) {
                return dn5Var.isViewAttached();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            en5 en5Var = this.n;
            if (en5Var != null) {
                return en5Var.isViewAttached();
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
            j48 j48Var = this.w;
            String str = j48Var.b;
            String str2 = j48Var.c;
            if (!TextUtils.isEmpty(valueOf) && !TextUtils.isEmpty(str)) {
                String str3 = TbConfig.TIEBA_ADDRESS + "mo/q/newtopic/detail?topic_id=" + valueOf + "/";
                if (StringUtils.isNull(this.w.d)) {
                    parse = null;
                } else {
                    parse = Uri.parse(this.w.d);
                }
                ShareItem shareItem = new ShareItem();
                shareItem.v = str;
                shareItem.w = str2;
                shareItem.x = str3;
                shareItem.i = true;
                shareItem.u = valueOf;
                shareItem.z = parse;
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
            in bdImage = this.h.getmBgImg().getBdImage();
            if (bdImage != null) {
                drawingCache = bdImage.p();
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
                if (this.s.b().x()) {
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
                this.r.setText(R.string.obfuscated_res_0x7f0f16a0);
                SkinManager.setBackgroundResource(this.r, R.drawable.topic_discuss_support_bg);
            } else if (i2 == 2) {
                this.r.setText(R.string.obfuscated_res_0x7f0f169f);
                SkinManager.setBackgroundResource(this.r, R.drawable.topic_discuss_oppose_bg);
            } else {
                this.r.setText(R.string.obfuscated_res_0x7f0f169e);
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
                nka nkaVar = this.u;
                if (nkaVar.b() < 0) {
                    z2 = false;
                }
                nkaVar.k(z2);
            }
        }
    }

    public final void u(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, bundle) == null) {
            q48 q48Var = (q48) new r48().a(getContext());
            this.s = q48Var;
            if (q48Var == null) {
                return;
            }
            q48Var.F(this.b);
            this.s.G(this.F);
            this.s.E(this.E);
            this.s.b().E(true);
            this.s.b().setBarBackgroundColorId(R.color.CAM_X0207);
            this.s.v((BaseActivity) getContext(), bundle);
            this.s.u();
            this.s.b().setId(R.id.obfuscated_res_0x7f0925da);
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
                noNetworkView.e(this.D);
            }
            q48 q48Var = this.s;
            if (q48Var != null) {
                q48Var.x();
            }
            if (this.A != null) {
                yg.a().removeCallbacks(this.A);
            }
            r();
            s();
        }
    }

    public void setData(j48 j48Var) {
        int g2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048594, this, j48Var) != null) || j48Var == null) {
            return;
        }
        this.w = j48Var;
        boolean z = j48Var.g;
        this.x = z;
        if (z && j48Var.f.size() <= 4) {
            this.x = false;
            E();
        } else if (!this.x) {
            E();
        } else {
            B();
        }
        if (!StringUtils.isNull(j48Var.b)) {
            this.d.setCenterTextTitle(String.format(getContext().getString(R.string.obfuscated_res_0x7f0f051a), StringHelper.cutChineseAndEnglishWithSuffix(j48Var.b, 14, "...")));
        }
        this.h.setData(j48Var.e);
        this.i.addHeaderView(this.h);
        this.j.c(j48Var.f);
        z48 z48Var = this.w.e.e;
        if (z48Var != null) {
            if (z48Var.d.e) {
                I(1);
            } else if (z48Var.e.e) {
                I(2);
            } else {
                I(0);
            }
            g2 = xi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds140);
        } else {
            g2 = xi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds50);
            this.r.setVisibility(8);
        }
        this.q.setPadding(g2, 0, 0, 0);
        H();
    }

    public final void t(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, bundle) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d005b, (ViewGroup) this, true);
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.obfuscated_res_0x7f090092);
            this.d = navigationBar;
            if (this.e == null) {
                View addSystemImageButton = navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
                this.e = addSystemImageButton;
                addSystemImageButton.setOnClickListener(this);
                this.f = (ImageView) this.e.findViewById(R.id.widget_navi_back_button);
            }
            this.g = (ImageView) this.d.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.obfuscated_res_0x7f0d0977, this);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.g, R.drawable.icon_pure_topbar_share44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SkinManager.setViewTextColor(this.d.mCenterText, (int) R.color.CAM_X0101);
            this.d.mCenterText.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.tbds52));
            this.d.mCenterText.setTypeface(Typeface.defaultFromStyle(1));
            NoNetworkView noNetworkView = (NoNetworkView) findViewById(R.id.obfuscated_res_0x7f090093);
            this.l = noNetworkView;
            noNetworkView.a(this.D);
            this.p = findViewById(R.id.obfuscated_res_0x7f091a61);
            TextView textView = (TextView) findViewById(R.id.obfuscated_res_0x7f0925db);
            this.q = textView;
            textView.setOnClickListener(new c(this));
            this.r = (TextView) findViewById(R.id.obfuscated_res_0x7f090980);
            this.o = findViewById(R.id.obfuscated_res_0x7f09008f);
            u(bundle);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            addView(this.s.b(), layoutParams);
            this.u = new nka();
            this.t = findViewById(R.id.obfuscated_res_0x7f090090);
            BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) findViewById(R.id.obfuscated_res_0x7f090091);
            this.i = bdTypeRecyclerView;
            bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            this.i.setFadingEdgeLength(0);
            this.i.setOverScrollMode(2);
            this.i.setOnSrollToBottomListener(this.H);
            this.i.addOnScrollListener(this.G);
            SkinManager.setBackgroundColor(this.i, R.color.CAM_X0201);
            this.j = new h48(this.b, this.i);
            TopicDetailHeadView topicDetailHeadView = new TopicDetailHeadView(getContext());
            this.h = topicDetailHeadView;
            topicDetailHeadView.g.setPkClickListener(new d(this));
            if (this.m == null) {
                PbListView pbListView = new PbListView(this.b.getPageActivity());
                this.k = pbListView;
                pbListView.c();
            }
            this.k.s(R.color.CAM_X0205);
            this.k.w(xi.g(this.b.getPageActivity(), R.dimen.tbds182));
            this.k.L(R.dimen.tbfontsize33);
            this.k.F(R.color.CAM_X0110);
            this.k.J(SkinManager.getColor(R.color.CAM_X0110));
            this.k.s(SkinManager.getColor(R.color.CAM_X0201));
            this.k.A(SkinManager.getColor(R.color.CAM_X0204));
            this.k.H(getResources().getString(R.string.list_has_no_more));
            this.k.c().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            if (this.z == null) {
                p48 p48Var = new p48(this);
                this.z = p48Var;
                p48Var.f(this.b.getUniqueId());
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
        this.q.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(xi.g(this.b.getPageActivity(), R.dimen.tbds47), SkinManager.getColor(R.color.CAM_X0209)));
        I(this.y);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        if (this.g != null) {
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.g, R.drawable.icon_pure_topbar_share44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        TbPageContext<?> tbPageContext = this.b;
        if (tbPageContext != null && (noNetworkView = this.l) != null) {
            noNetworkView.d(tbPageContext, this.a);
        }
        dn5 dn5Var = this.m;
        if (dn5Var != null) {
            dn5Var.onChangeSkinType();
        }
        en5 en5Var = this.n;
        if (en5Var != null) {
            en5Var.onChangeSkinType();
        }
        q48 q48Var = this.s;
        if (q48Var != null && q48Var.b() != null) {
            this.s.b().y(this.a);
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
        h48 h48Var = this.j;
        if (h48Var != null) {
            h48Var.b();
        }
        SkinManager.setBackgroundColor(this.i, R.color.CAM_X0205);
    }
}
