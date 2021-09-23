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
import c.a.e.e.p.l;
import c.a.e.l.e.n;
import c.a.q0.s.q.d2;
import c.a.q0.t.c.k0;
import c.a.r0.g1.k.a.d.a;
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
import java.util.Iterator;
import java.util.List;
/* loaded from: classes7.dex */
public class TopicDetailView extends RelativeLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.r0.g1.k.a.c.a A;
    public boolean B;
    public int C;
    public c.a.r0.g1.k.a.d.a D;
    public a.b E;
    public int F;
    public int G;
    public NoNetworkView.b H;
    public c.a.q0.x.w.b I;
    public NewWriteModel.g J;
    public final RecyclerView.OnScrollListener K;
    public BdListView.p L;

    /* renamed from: e  reason: collision with root package name */
    public int f52633e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<?> f52634f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.r0.g1.k.a.a f52635g;

    /* renamed from: h  reason: collision with root package name */
    public NavigationBar f52636h;

    /* renamed from: i  reason: collision with root package name */
    public View f52637i;

    /* renamed from: j  reason: collision with root package name */
    public ImageView f52638j;
    public ImageView k;
    public TopicDetailHeadView l;
    public BdTypeRecyclerView m;
    public c.a.r0.g1.k.a.b.b n;
    public PbListView o;
    public NoNetworkView p;
    public c.a.q0.g0.g q;
    public c.a.q0.g0.h r;
    public View s;
    public View t;
    public TextView u;
    public TextView v;
    public c.a.r0.g1.k.a.e.a w;
    public View x;
    public c.a.r0.c4.c y;
    public EditText z;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TopicDetailView f52639e;

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
            this.f52639e = topicDetailView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && c.a.e.e.p.j.A() && this.f52639e.f52635g != null) {
                this.f52639e.f52635g.loadData();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements NoNetworkView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TopicDetailView f52640e;

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
            this.f52640e = topicDetailView;
        }

        @Override // com.baidu.tbadk.core.view.NoNetworkView.b
        public void onNetworkChange(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && z && this.f52640e.A == null && this.f52640e.f52635g != null) {
                this.f52640e.f52635g.loadData();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TopicDetailView f52641e;

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
            this.f52641e = topicDetailView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f52641e.clickCommentReply();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements TopicPkView.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TopicDetailView f52642a;

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
            this.f52642a = topicDetailView;
        }

        @Override // com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.f
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                this.f52642a.s(i2);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TopicDetailView f52643e;

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
            this.f52643e = topicDetailView;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, editable) == null) || this.f52643e.y == null) {
                return;
            }
            if (!this.f52643e.y.e()) {
                this.f52643e.checkContentSensitiveWord(false);
            }
            this.f52643e.y.l(false);
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

    /* loaded from: classes7.dex */
    public class f implements c.a.q0.x.w.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TopicDetailView f52644a;

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
            this.f52644a = topicDetailView;
        }

        @Override // c.a.q0.x.w.b
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.f52644a.y.d()) {
                    this.f52644a.f52634f.showToast(this.f52644a.y.c());
                    this.f52644a.checkContentSensitiveWord(true);
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class g implements NewWriteModel.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TopicDetailView f52645a;

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
            this.f52645a = topicDetailView;
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.g
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, k0 k0Var, WriteData writeData, AntiData antiData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, k0Var, writeData, antiData}) == null) {
                if (z && this.f52645a.w != null && this.f52645a.w.a() != null) {
                    this.f52645a.w.a().hide();
                }
                if (z) {
                    this.f52645a.y.n(null);
                    this.f52645a.y.i(null);
                    this.f52645a.y.k(false);
                    if (postWriteCallBackData != null) {
                        long g2 = c.a.e.e.m.b.g(postWriteCallBackData.getPostId(), 0L);
                        long g3 = c.a.e.e.m.b.g(postWriteCallBackData.getThreadId(), 0L);
                        if (g2 == 0 || g3 == 0) {
                            return;
                        }
                        this.f52645a.E = this.f52645a.D.c(g2, g3);
                        c.a.e.e.m.e.a().postDelayed(this.f52645a.E, 500L);
                    }
                } else if (postWriteCallBackData == null || !postWriteCallBackData.isSensitiveError()) {
                } else {
                    this.f52645a.y.i(postWriteCallBackData.getSensitiveWords());
                    this.f52645a.y.n(postWriteCallBackData.getErrorString());
                    if (ListUtils.isEmpty(this.f52645a.y.a())) {
                        return;
                    }
                    this.f52645a.checkContentSensitiveWord(true);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TopicDetailView f52646a;

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
            this.f52646a = topicDetailView;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i2) == null) {
                if (i2 != 0 && this.f52646a.w != null) {
                    this.f52646a.w.u();
                    this.f52646a.setEditorTopViewAboveEditor();
                }
                super.onScrollStateChanged(this.f52646a.m, i2);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i2, i3) == null) {
                super.onScrolled(recyclerView, i2, i3);
                this.f52646a.F += i3;
                this.f52646a.r();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TopicDetailView f52647e;

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
            this.f52647e = topicDetailView;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f52647e.B) {
                if (!l.D()) {
                    this.f52647e.n();
                    return;
                }
                int size = this.f52647e.A.f18486f.size() - 1;
                if (this.f52647e.A.f18486f.get(size) instanceof c.a.r0.g1.k.a.c.c) {
                    ((TopicDetailActivity) this.f52647e.f52634f.getPageActivity()).requestNextPageThreadData(((c.a.r0.g1.k.a.c.c) this.f52647e.A.f18486f.get(size)).f18496e);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class j implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ShareItem f52648e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ TopicDetailView f52649f;

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
            this.f52649f = topicDetailView;
            this.f52648e = shareItem;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                c.a.e.e.p.a.a(this.f52648e.t);
                l.M(this.f52649f.getContext(), view.getResources().getString(R.string.copy_pb_url_success));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TopicDetailView(TbPageContext<?> tbPageContext, c.a.r0.g1.k.a.a aVar, Bundle bundle) {
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
        this.f52633e = 3;
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
        this.f52634f = tbPageContext;
        this.f52635g = aVar;
        o(bundle);
        onChangeSkinType();
    }

    public void checkContentSensitiveWord(boolean z) {
        EditText editText;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || (editText = this.z) == null || editText.getText() == null) {
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
            c.a.r0.c4.c cVar = this.y;
            cVar.k(cVar.b() >= 0);
        }
    }

    public void clickCommentReply() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (ViewHelper.checkUpIsLogin(getContext())) {
                this.w.M();
                setEditorTopViewAboveEditor();
            }
            if (this.A != null) {
                TiebaStatic.log(new StatisticItem("c13359").param("topic_id", String.valueOf(this.A.f18481a)));
            }
        }
    }

    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.m.setOnSrollToBottomListener(null);
            NoNetworkView noNetworkView = this.p;
            if (noNetworkView != null) {
                noNetworkView.removeNetworkChangeListener(this.H);
            }
            c.a.r0.g1.k.a.e.a aVar = this.w;
            if (aVar != null) {
                aVar.x();
            }
            if (this.E != null) {
                c.a.e.e.m.e.a().removeCallbacks(this.E);
            }
            hideLoadingView();
            hideNetRefreshView();
        }
    }

    public c.a.r0.g1.k.a.e.a getEditor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.w : (c.a.r0.g1.k.a.e.a) invokeV.objValue;
    }

    public void hideLoadingView() {
        c.a.q0.g0.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (gVar = this.q) == null) {
            return;
        }
        gVar.dettachView(this);
        this.q = null;
    }

    public void hideNetRefreshView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            c.a.q0.g0.h hVar = this.r;
            if (hVar != null) {
                hVar.dettachView(this);
                this.r = null;
            }
            this.m.setVisibility(0);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f52638j, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public boolean isLoadingViewShowing() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            c.a.q0.g0.g gVar = this.q;
            if (gVar != null) {
                return gVar.isViewAttached();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isRefreshViewShowing() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            c.a.q0.g0.h hVar = this.r;
            if (hVar != null) {
                return hVar.isViewAttached();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.m.setNextPage(null);
        }
    }

    public final void o(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bundle) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.activity_topic_detail_layout, (ViewGroup) this, true);
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.activity_topic_detail_navigation);
            this.f52636h = navigationBar;
            if (this.f52637i == null) {
                View addSystemImageButton = navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
                this.f52637i = addSystemImageButton;
                addSystemImageButton.setOnClickListener(this);
                this.f52638j = (ImageView) this.f52637i.findViewById(R.id.widget_navi_back_button);
            }
            this.k = (ImageView) this.f52636h.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.topic_detail_share_layout, this);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.k, R.drawable.icon_pure_topbar_share44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SkinManager.setViewTextColor(this.f52636h.mCenterText, R.color.CAM_X0101);
            this.f52636h.mCenterText.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.tbds52));
            this.f52636h.mCenterText.setTypeface(Typeface.defaultFromStyle(1));
            NoNetworkView noNetworkView = (NoNetworkView) findViewById(R.id.activity_topic_detail_no_network_view);
            this.p = noNetworkView;
            noNetworkView.addNetworkChangeListener(this.H);
            this.t = findViewById(R.id.pb_editor_tool_comment);
            TextView textView = (TextView) findViewById(R.id.topic_editor_tool_comment_reply_text);
            this.u = textView;
            textView.setOnClickListener(new c(this));
            this.v = (TextView) findViewById(R.id.editor_tool_opinion_text_view);
            this.s = findViewById(R.id.activity_topic_detail_editor);
            p(bundle);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            addView(this.w.a(), layoutParams);
            this.y = new c.a.r0.c4.c();
            this.x = findViewById(R.id.activity_topic_detail_editor_top);
            BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) findViewById(R.id.activity_topic_detail_list);
            this.m = bdTypeRecyclerView;
            bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            this.m.setFadingEdgeLength(0);
            this.m.setOverScrollMode(2);
            this.m.setOnSrollToBottomListener(this.L);
            this.m.addOnScrollListener(this.K);
            SkinManager.setBackgroundColor(this.m, R.color.CAM_X0201);
            this.n = new c.a.r0.g1.k.a.b.b(this.f52634f, this.m);
            TopicDetailHeadView topicDetailHeadView = new TopicDetailHeadView(getContext());
            this.l = topicDetailHeadView;
            topicDetailHeadView.mPkView.setPkClickListener(new d(this));
            if (this.q == null) {
                PbListView pbListView = new PbListView(this.f52634f.getPageActivity());
                this.o = pbListView;
                pbListView.b();
            }
            this.o.o(R.color.CAM_X0205);
            this.o.r(l.g(this.f52634f.getPageActivity(), R.dimen.tbds182));
            this.o.E(R.dimen.tbfontsize33);
            this.o.y(R.color.CAM_X0110);
            this.o.C(SkinManager.getColor(R.color.CAM_X0110));
            this.o.o(SkinManager.getColor(R.color.CAM_X0201));
            this.o.u(SkinManager.getColor(R.color.CAM_X0204));
            this.o.A(getResources().getString(R.string.list_has_no_more));
            this.o.b().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            if (this.D == null) {
                c.a.r0.g1.k.a.d.a aVar = new c.a.r0.g1.k.a.d.a(this);
                this.D = aVar;
                aVar.f(this.f52634f.getUniqueId());
            }
        }
    }

    public void onChangeSkinType() {
        int skinType;
        NoNetworkView noNetworkView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (skinType = TbadkCoreApplication.getInst().getSkinType()) == this.f52633e) {
            return;
        }
        this.f52633e = skinType;
        r();
        SkinManager.setViewTextColor(this.f52636h.mCenterText, R.color.CAM_X0101);
        SkinManager.setBackgroundResource(this.t, R.color.CAM_X0207);
        SkinManager.setViewTextColor(this.u, R.color.CAM_X0109);
        this.u.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(l.g(this.f52634f.getPageActivity(), R.dimen.tbds47), SkinManager.getColor(R.color.CAM_X0209)));
        s(this.C);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f52638j, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        if (this.k != null) {
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.k, R.drawable.icon_pure_topbar_share44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        TbPageContext<?> tbPageContext = this.f52634f;
        if (tbPageContext != null && (noNetworkView = this.p) != null) {
            noNetworkView.onChangeSkinType(tbPageContext, this.f52633e);
        }
        c.a.q0.g0.g gVar = this.q;
        if (gVar != null) {
            gVar.onChangeSkinType();
        }
        c.a.q0.g0.h hVar = this.r;
        if (hVar != null) {
            hVar.onChangeSkinType();
        }
        c.a.r0.g1.k.a.e.a aVar = this.w;
        if (aVar != null && aVar.a() != null) {
            this.w.a().onChangeSkinType(this.f52633e);
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
            topicDetailHeadView.onChangeSkinType();
        }
        c.a.r0.g1.k.a.b.b bVar = this.n;
        if (bVar != null) {
            bVar.b();
        }
        SkinManager.setBackgroundColor(this.m, R.color.CAM_X0205);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        c.a.r0.g1.k.a.c.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, view) == null) {
            if (view == this.f52637i) {
                this.f52634f.getPageActivity().finish();
            } else if (view != this.k || (aVar = this.A) == null || aVar.f18481a <= 0) {
            } else {
                q();
                TiebaStatic.log(new StatisticItem("c13364").param("topic_id", String.valueOf(this.A.f18481a)));
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            destroy();
            super.onDetachedFromWindow();
        }
    }

    public final void p(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, bundle) == null) {
            c.a.r0.g1.k.a.e.a aVar = (c.a.r0.g1.k.a.e.a) new c.a.r0.g1.k.a.e.b().a(getContext());
            this.w = aVar;
            if (aVar == null) {
                return;
            }
            aVar.F(this.f52634f);
            this.w.G(this.J);
            this.w.E(this.I);
            this.w.a().showLinePositionBottom(true);
            this.w.a().setBarBackgroundColorId(R.color.CAM_X0207);
            this.w.v((BaseActivity) getContext(), bundle);
            this.w.u();
            this.w.a().setId(R.id.topic_editor);
            EditText g2 = this.w.o().g();
            this.z = g2;
            g2.addTextChangedListener(new e(this));
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || this.A == null || getContext() == null) {
            return;
        }
        String valueOf = String.valueOf(this.A.f18481a);
        c.a.r0.g1.k.a.c.a aVar = this.A;
        String str = aVar.f18482b;
        String str2 = aVar.f18483c;
        if (!TextUtils.isEmpty(valueOf) && !TextUtils.isEmpty(str)) {
            String str3 = "http://tieba.baidu.com/mo/q/newtopic/detail?topic_id=" + valueOf + "/";
            Uri parse = StringUtils.isNull(this.A.f18484d) ? null : Uri.parse(this.A.f18484d);
            ShareItem shareItem = new ShareItem();
            shareItem.r = str;
            shareItem.s = str2;
            shareItem.t = str3;
            shareItem.f48221i = true;
            shareItem.q = valueOf;
            shareItem.v = parse;
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(getContext(), shareItem, true, true);
            shareDialogConfig.setIsCopyLink(true);
            shareDialogConfig.setCopyLinkListener(new j(this, shareItem));
            this.f52634f.sendMessage(new CustomMessage(2001276, shareDialogConfig));
            return;
        }
        this.f52634f.showToast(getContext().getString(R.string.no_hot_topic_data));
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || this.A == null || this.l == null) {
            return;
        }
        if (this.F > this.G) {
            this.f52636h.getBarBgView().setAlpha(1.0f);
            this.f52636h.getBarBgView().setBackgroundDrawable(new BitmapDrawable(takeScreenShotForNavigationBar()));
            return;
        }
        SkinManager.setBackgroundColor(this.f52636h.getBarBgView(), R.color.transparent);
        this.f52636h.getBarBgView().setAlpha(0.0f);
    }

    public final void s(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
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
            int i3 = this.f52633e;
            if (i3 != 1 && i3 != 4) {
                SkinManager.setViewTextColor(this.v, R.color.CAM_X0101);
            } else {
                this.v.setTextColor(-2130706433);
            }
        }
    }

    public void sendThreadFakeUpdateList(d2 d2Var) {
        c.a.r0.g1.k.a.c.c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, d2Var) == null) {
            Iterator<n> it = this.A.f18486f.iterator();
            int i2 = 0;
            while (true) {
                if (!it.hasNext()) {
                    cVar = null;
                    break;
                }
                n next = it.next();
                if (next instanceof c.a.r0.g1.k.a.c.c) {
                    cVar = (c.a.r0.g1.k.a.c.c) next;
                    break;
                }
                i2++;
            }
            if (cVar != null) {
                c.a.r0.g1.k.a.c.c cVar2 = new c.a.r0.g1.k.a.c.c();
                cVar2.f18496e = cVar.f18496e;
                cVar2.f18497f = d2Var;
                cVar2.f18500i = 2;
                cVar2.f18499h = this.C;
                c.a.r0.g1.k.a.c.a aVar = this.A;
                cVar2.f18498g = aVar.f18481a;
                cVar2.f18501j = aVar.a();
                this.A.f18486f.add(i2, cVar2);
                this.n.c(this.A.f18486f);
            }
        }
    }

    public void setData(c.a.r0.g1.k.a.c.a aVar) {
        int g2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, aVar) == null) || aVar == null) {
            return;
        }
        this.A = aVar;
        boolean z = aVar.f18487g;
        this.B = z;
        if (z && aVar.f18486f.size() <= 4) {
            this.B = false;
            showNoMoreView();
        } else if (!this.B) {
            showNoMoreView();
        } else {
            showLoadMoreView();
        }
        if (!StringUtils.isNull(aVar.f18482b)) {
            this.f52636h.setCenterTextTitle(String.format(getContext().getString(R.string.daily_topic_name), StringHelper.cutChineseAndEnglishWithSuffix(aVar.f18482b, 14, "...")));
        }
        this.l.setData(aVar.f18485e);
        this.m.addHeaderView(this.l);
        this.n.c(aVar.f18486f);
        c.a.r0.g1.k.b.c.b bVar = this.A.f18485e.f18494e;
        if (bVar != null) {
            if (bVar.f18545d.f18552e) {
                s(1);
            } else if (bVar.f18546e.f18552e) {
                s(2);
            } else {
                s(0);
            }
            g2 = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds140);
        } else {
            g2 = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds50);
            this.v.setVisibility(8);
        }
        this.u.setPadding(g2, 0, 0, 0);
        r();
    }

    public void setEditorTopViewAboveEditor() {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048595, this) == null) || (view = this.x) == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            if (this.w.a().isVisible()) {
                layoutParams2.addRule(2, this.w.a().getId());
            } else {
                layoutParams2.addRule(2, this.s.getId());
            }
            this.x.setLayoutParams(layoutParams2);
        }
    }

    public void setNextData(int i2, boolean z, List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048596, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), list}) == null) {
            this.B = z;
            if (!z) {
                showNoMoreView();
            } else {
                showLoadMoreView();
            }
            if (i2 != 0 || list == null || ListUtils.isEmpty(list)) {
                return;
            }
            for (n nVar : list) {
                if (nVar instanceof c.a.r0.g1.k.a.c.c) {
                    ((c.a.r0.g1.k.a.c.c) nVar).f18501j = this.A.a();
                }
            }
            this.A.f18486f.addAll(list);
            this.m.setData(this.A.f18486f);
        }
    }

    public void showLoadMoreView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            this.B = true;
            this.m.setNextPage(this.o);
            this.o.O();
        }
    }

    public void showLoadingView(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048598, this, z) == null) || isLoadingViewShowing()) {
            return;
        }
        if (this.q == null) {
            c.a.q0.g0.g gVar = new c.a.q0.g0.g(getContext());
            this.q = gVar;
            gVar.onChangeSkinType();
        }
        this.q.attachView(this, z);
    }

    public void showNetRefreshView(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048599, this, z) == null) || isRefreshViewShowing()) {
            return;
        }
        if (this.r == null) {
            this.r = new c.a.q0.g0.h(getContext(), new a(this));
        }
        this.r.j(this.f52634f.getResources().getDimensionPixelSize(R.dimen.tbds506));
        this.r.attachView(this, z);
        this.r.o();
        this.m.setVisibility(8);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f52638j, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void showNoMoreView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            this.m.setNextPage(this.o);
            this.o.f();
        }
    }

    public Bitmap takeScreenShotForNavigationBar() {
        InterceptResult invokeV;
        Bitmap drawingCache;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            c.a.e.l.d.a bdImage = this.l.getmBgImg().getBdImage();
            if (bdImage != null) {
                drawingCache = bdImage.p();
            } else {
                drawingCache = this.l.getmBgImg().getDrawingCache();
            }
            int width = this.f52634f.getPageActivity().getWindowManager().getDefaultDisplay().getWidth();
            int height = this.f52636h.getHeight();
            return (drawingCache == null || drawingCache.getWidth() < width || drawingCache.getHeight() < height) ? drawingCache : Bitmap.createBitmap(drawingCache, 0, 0, width, height);
        }
        return (Bitmap) invokeV.objValue;
    }
}
