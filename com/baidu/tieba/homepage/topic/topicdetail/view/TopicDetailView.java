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
import com.baidu.tieba.an;
import com.baidu.tieba.d37;
import com.baidu.tieba.dz4;
import com.baidu.tieba.f37;
import com.baidu.tieba.gi;
import com.baidu.tieba.h37;
import com.baidu.tieba.homepage.topic.topicdetail.TopicDetailActivity;
import com.baidu.tieba.homepage.topic.topictab.view.TopicPkView;
import com.baidu.tieba.j37;
import com.baidu.tieba.kz8;
import com.baidu.tieba.m65;
import com.baidu.tieba.n37;
import com.baidu.tieba.n45;
import com.baidu.tieba.n65;
import com.baidu.tieba.o37;
import com.baidu.tieba.p37;
import com.baidu.tieba.pg;
import com.baidu.tieba.pi;
import com.baidu.tieba.pn;
import com.baidu.tieba.ri;
import com.baidu.tieba.sg;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.x37;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class TopicDetailView extends RelativeLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public n37.b A;
    public int B;
    public int C;
    public NoNetworkView.b D;
    public n45 E;
    public NewWriteModel.e F;
    public final RecyclerView.OnScrollListener G;
    public BdListView.p H;
    public int a;
    public TbPageContext<?> b;
    public d37 c;
    public NavigationBar d;
    public View e;
    public ImageView f;
    public ImageView g;
    public TopicDetailHeadView h;
    public BdTypeRecyclerView i;
    public f37 j;
    public PbListView k;
    public NoNetworkView l;
    public m65 m;
    public n65 n;
    public View o;
    public View p;
    public TextView q;
    public TextView r;
    public o37 s;
    public View t;
    public kz8 u;
    public EditText v;
    public h37 w;
    public boolean x;
    public int y;
    public n37 z;

    /* loaded from: classes4.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && pi.A() && this.a.c != null) {
                this.a.c.a();
            }
        }
    }

    /* loaded from: classes4.dex */
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
        public void g(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && z && this.a.w == null && this.a.c != null) {
                this.a.c.a();
            }
        }
    }

    /* loaded from: classes4.dex */
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

    /* loaded from: classes4.dex */
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

    /* loaded from: classes4.dex */
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

    /* loaded from: classes4.dex */
    public class f implements n45 {
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

        @Override // com.baidu.tieba.n45
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

    /* loaded from: classes4.dex */
    public class g implements NewWriteModel.e {
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

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.e
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, dz4 dz4Var, WriteData writeData, AntiData antiData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, dz4Var, writeData, antiData}) == null) {
                if (z && this.a.s != null && this.a.s.a() != null) {
                    this.a.s.a().o();
                }
                if (z) {
                    this.a.u.n(null);
                    this.a.u.i(null);
                    this.a.u.k(false);
                    if (postWriteCallBackData != null) {
                        long g = pg.g(postWriteCallBackData.getPostId(), 0L);
                        long g2 = pg.g(postWriteCallBackData.getThreadId(), 0L);
                        if (g == 0 || g2 == 0) {
                            return;
                        }
                        this.a.A = this.a.z.c(g, g2);
                        sg.a().postDelayed(this.a.A, 500L);
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

    /* loaded from: classes4.dex */
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

    /* loaded from: classes4.dex */
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
                if (!ri.D()) {
                    this.a.q();
                    return;
                }
                int size = this.a.w.f.size() - 1;
                if (this.a.w.f.get(size) instanceof j37) {
                    ((TopicDetailActivity) this.a.b.getPageActivity()).B1(((j37) this.a.w.f.get(size)).a);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
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
                gi.a(this.a.w);
                ri.N(this.b.getContext(), view2.getResources().getString(R.string.obfuscated_res_0x7f0f0451));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TopicDetailView(TbPageContext<?> tbPageContext, d37 d37Var, Bundle bundle) {
        super(tbPageContext.getPageActivity());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, d37Var, bundle};
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
        this.c = d37Var;
        t(bundle);
        x();
    }

    public void A(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || v()) {
            return;
        }
        if (this.m == null) {
            m65 m65Var = new m65(getContext());
            this.m = m65Var;
            m65Var.onChangeSkinType();
        }
        this.m.attachView(this, z);
    }

    public void B(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) || w()) {
            return;
        }
        if (this.n == null) {
            this.n = new n65(getContext(), new a(this));
        }
        this.n.k(this.b.getResources().getDimensionPixelSize(R.dimen.tbds506));
        this.n.attachView(this, z);
        this.n.p();
        this.i.setVisibility(8);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f, R.drawable.obfuscated_res_0x7f080613, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
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
        h37 h37Var = this.w;
        String str = h37Var.b;
        String str2 = h37Var.c;
        if (!TextUtils.isEmpty(valueOf) && !TextUtils.isEmpty(str)) {
            String str3 = "https://tieba.baidu.com/mo/q/newtopic/detail?topic_id=" + valueOf + "/";
            Uri parse = StringUtils.isNull(this.w.d) ? null : Uri.parse(this.w.d);
            ShareItem shareItem = new ShareItem();
            shareItem.u = str;
            shareItem.v = str2;
            shareItem.w = str3;
            shareItem.i = true;
            shareItem.t = valueOf;
            shareItem.y = parse;
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(getContext(), shareItem, true, true);
            shareDialogConfig.setIsCopyLink(true);
            shareDialogConfig.setCopyLinkListener(new j(this, shareItem));
            this.b.sendMessage(new CustomMessage(2001276, shareDialogConfig));
            return;
        }
        this.b.showToast(getContext().getString(R.string.obfuscated_res_0x7f0f0c6a));
    }

    public Bitmap E() {
        InterceptResult invokeV;
        Bitmap drawingCache;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            an bdImage = this.h.getmBgImg().getBdImage();
            if (bdImage != null) {
                drawingCache = bdImage.p();
            } else {
                drawingCache = this.h.getmBgImg().getDrawingCache();
            }
            int width = this.b.getPageActivity().getWindowManager().getDefaultDisplay().getWidth();
            int height = this.d.getHeight();
            return (drawingCache == null || drawingCache.getWidth() < width || drawingCache.getHeight() < height) ? drawingCache : Bitmap.createBitmap(drawingCache, 0, 0, width, height);
        }
        return (Bitmap) invokeV.objValue;
    }

    public final void F() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.w == null || this.h == null) {
            return;
        }
        if (this.B > this.C) {
            this.d.getBarBgView().setAlpha(1.0f);
            this.d.getBarBgView().setBackgroundDrawable(new BitmapDrawable(E()));
            return;
        }
        SkinManager.setBackgroundColor(this.d.getBarBgView(), R.color.transparent);
        this.d.getBarBgView().setAlpha(0.0f);
    }

    public final void G(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.y = i2;
            this.r.setVisibility(0);
            if (i2 == 1) {
                this.r.setText(R.string.obfuscated_res_0x7f0f143d);
                SkinManager.setBackgroundResource(this.r, R.drawable.topic_discuss_support_bg);
            } else if (i2 == 2) {
                this.r.setText(R.string.obfuscated_res_0x7f0f143c);
                SkinManager.setBackgroundResource(this.r, R.drawable.topic_discuss_oppose_bg);
            } else {
                this.r.setText(R.string.obfuscated_res_0x7f0f143b);
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

    public o37 getEditor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.s : (o37) invokeV.objValue;
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
            kz8 kz8Var = this.u;
            kz8Var.k(kz8Var.b() >= 0);
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
    public void onClick(View view2) {
        h37 h37Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, view2) == null) {
            if (view2 == this.e) {
                this.b.getPageActivity().finish();
            } else if (view2 != this.g || (h37Var = this.w) == null || h37Var.a <= 0) {
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
                noNetworkView.e(this.D);
            }
            o37 o37Var = this.s;
            if (o37Var != null) {
                o37Var.w();
            }
            if (this.A != null) {
                sg.a().removeCallbacks(this.A);
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
        m65 m65Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || (m65Var = this.m) == null) {
            return;
        }
        m65Var.dettachView(this);
        this.m = null;
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            n65 n65Var = this.n;
            if (n65Var != null) {
                n65Var.dettachView(this);
                this.n = null;
            }
            this.i.setVisibility(0);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f, R.drawable.obfuscated_res_0x7f080613, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public void setData(h37 h37Var) {
        int f2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048592, this, h37Var) == null) || h37Var == null) {
            return;
        }
        this.w = h37Var;
        boolean z = h37Var.g;
        this.x = z;
        if (z && h37Var.f.size() <= 4) {
            this.x = false;
            C();
        } else if (!this.x) {
            C();
        } else {
            z();
        }
        if (!StringUtils.isNull(h37Var.b)) {
            this.d.setCenterTextTitle(String.format(getContext().getString(R.string.obfuscated_res_0x7f0f0485), StringHelper.cutChineseAndEnglishWithSuffix(h37Var.b, 14, StringHelper.STRING_MORE)));
        }
        this.h.setData(h37Var.e);
        this.i.s(this.h);
        this.j.c(h37Var.f);
        x37 x37Var = this.w.e.e;
        if (x37Var != null) {
            if (x37Var.d.e) {
                G(1);
            } else if (x37Var.e.e) {
                G(2);
            } else {
                G(0);
            }
            f2 = ri.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds140);
        } else {
            f2 = ri.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds50);
            this.r.setVisibility(8);
        }
        this.q.setPadding(f2, 0, 0, 0);
        F();
    }

    public void setEditorTopViewAboveEditor() {
        View view2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (view2 = this.t) == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
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

    public void setNextData(int i2, boolean z, List<pn> list) {
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
            for (pn pnVar : list) {
                if (pnVar instanceof j37) {
                    ((j37) pnVar).f = this.w.a();
                }
            }
            this.w.f.addAll(list);
            this.i.setData(this.w.f);
        }
    }

    public final void t(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, bundle) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d0057, (ViewGroup) this, true);
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.obfuscated_res_0x7f090081);
            this.d = navigationBar;
            if (this.e == null) {
                View addSystemImageButton = navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
                this.e = addSystemImageButton;
                addSystemImageButton.setOnClickListener(this);
                this.f = (ImageView) this.e.findViewById(R.id.obfuscated_res_0x7f09261f);
            }
            this.g = (ImageView) this.d.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.obfuscated_res_0x7f0d087c, this);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.g, R.drawable.obfuscated_res_0x7f080a0a, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SkinManager.setViewTextColor(this.d.mCenterText, (int) R.color.CAM_X0101);
            this.d.mCenterText.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.tbds52));
            this.d.mCenterText.setTypeface(Typeface.defaultFromStyle(1));
            NoNetworkView noNetworkView = (NoNetworkView) findViewById(R.id.obfuscated_res_0x7f090082);
            this.l = noNetworkView;
            noNetworkView.a(this.D);
            this.p = findViewById(R.id.obfuscated_res_0x7f0917c1);
            TextView textView = (TextView) findViewById(R.id.obfuscated_res_0x7f09227b);
            this.q = textView;
            textView.setOnClickListener(new c(this));
            this.r = (TextView) findViewById(R.id.obfuscated_res_0x7f090875);
            this.o = findViewById(R.id.obfuscated_res_0x7f09007e);
            u(bundle);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            addView(this.s.a(), layoutParams);
            this.u = new kz8();
            this.t = findViewById(R.id.obfuscated_res_0x7f09007f);
            BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) findViewById(R.id.obfuscated_res_0x7f090080);
            this.i = bdTypeRecyclerView;
            bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            this.i.setFadingEdgeLength(0);
            this.i.setOverScrollMode(2);
            this.i.setOnSrollToBottomListener(this.H);
            this.i.addOnScrollListener(this.G);
            SkinManager.setBackgroundColor(this.i, R.color.CAM_X0201);
            this.j = new f37(this.b, this.i);
            TopicDetailHeadView topicDetailHeadView = new TopicDetailHeadView(getContext());
            this.h = topicDetailHeadView;
            topicDetailHeadView.g.setPkClickListener(new d(this));
            if (this.m == null) {
                PbListView pbListView = new PbListView(this.b.getPageActivity());
                this.k = pbListView;
                pbListView.b();
            }
            this.k.p(R.color.CAM_X0205);
            this.k.t(ri.f(this.b.getPageActivity(), R.dimen.tbds182));
            this.k.G(R.dimen.tbfontsize33);
            this.k.A(R.color.CAM_X0110);
            this.k.E(SkinManager.getColor(R.color.CAM_X0110));
            this.k.p(SkinManager.getColor(R.color.CAM_X0201));
            this.k.w(SkinManager.getColor(R.color.CAM_X0204));
            this.k.C(getResources().getString(R.string.obfuscated_res_0x7f0f09ec));
            this.k.b().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            if (this.z == null) {
                n37 n37Var = new n37(this);
                this.z = n37Var;
                n37Var.f(this.b.getUniqueId());
            }
        }
    }

    public final void u(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, bundle) == null) {
            o37 o37Var = (o37) new p37().a(getContext());
            this.s = o37Var;
            if (o37Var == null) {
                return;
            }
            o37Var.E(this.b);
            this.s.F(this.F);
            this.s.D(this.E);
            this.s.a().C(true);
            this.s.a().setBarBackgroundColorId(R.color.CAM_X0207);
            this.s.u((BaseActivity) getContext(), bundle);
            this.s.t();
            this.s.a().setId(R.id.obfuscated_res_0x7f09227a);
            EditText g2 = this.s.n().g();
            this.v = g2;
            g2.addTextChangedListener(new e(this));
        }
    }

    public boolean v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            m65 m65Var = this.m;
            if (m65Var != null) {
                return m65Var.isViewAttached();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            n65 n65Var = this.n;
            if (n65Var != null) {
                return n65Var.isViewAttached();
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
        SkinManager.setViewTextColor(this.d.mCenterText, (int) R.color.CAM_X0101);
        SkinManager.setBackgroundResource(this.p, R.color.CAM_X0207);
        SkinManager.setViewTextColor(this.q, (int) R.color.CAM_X0109);
        this.q.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(ri.f(this.b.getPageActivity(), R.dimen.tbds47), SkinManager.getColor(R.color.CAM_X0209)));
        G(this.y);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f, R.drawable.obfuscated_res_0x7f080613, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        if (this.g != null) {
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.g, R.drawable.obfuscated_res_0x7f080a0a, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        TbPageContext<?> tbPageContext = this.b;
        if (tbPageContext != null && (noNetworkView = this.l) != null) {
            noNetworkView.d(tbPageContext, this.a);
        }
        m65 m65Var = this.m;
        if (m65Var != null) {
            m65Var.onChangeSkinType();
        }
        n65 n65Var = this.n;
        if (n65Var != null) {
            n65Var.onChangeSkinType();
        }
        o37 o37Var = this.s;
        if (o37Var != null && o37Var.a() != null) {
            this.s.a().w(this.a);
        }
        PbListView pbListView = this.k;
        if (pbListView != null) {
            pbListView.A(R.color.CAM_X0110);
            this.k.E(SkinManager.getColor(R.color.CAM_X0110));
            this.k.p(SkinManager.getColor(R.color.CAM_X0201));
            this.k.w(SkinManager.getColor(R.color.CAM_X0204));
        }
        TopicDetailHeadView topicDetailHeadView = this.h;
        if (topicDetailHeadView != null) {
            topicDetailHeadView.b();
        }
        f37 f37Var = this.j;
        if (f37Var != null) {
            f37Var.b();
        }
        SkinManager.setBackgroundColor(this.i, R.color.CAM_X0205);
    }

    public void y(ThreadData threadData) {
        j37 j37Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, threadData) == null) {
            Iterator<pn> it = this.w.f.iterator();
            int i2 = 0;
            while (true) {
                if (!it.hasNext()) {
                    j37Var = null;
                    break;
                }
                pn next = it.next();
                if (next instanceof j37) {
                    j37Var = (j37) next;
                    break;
                }
                i2++;
            }
            if (j37Var != null) {
                j37 j37Var2 = new j37();
                j37Var2.a = j37Var.a;
                j37Var2.b = threadData;
                j37Var2.e = 2;
                j37Var2.d = this.y;
                h37 h37Var = this.w;
                j37Var2.c = h37Var.a;
                j37Var2.f = h37Var.a();
                this.w.f.add(i2, j37Var2);
                this.j.c(this.w.f);
            }
        }
    }

    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            this.x = true;
            this.i.setNextPage(this.k);
            this.k.Q();
        }
    }
}
