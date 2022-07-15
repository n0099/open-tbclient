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
import com.baidu.tieba.homepage.topic.topicdetail.TopicDetailActivity;
import com.baidu.tieba.homepage.topic.topictab.view.TopicPkView;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.c17;
import com.repackage.e17;
import com.repackage.ei;
import com.repackage.fy4;
import com.repackage.g17;
import com.repackage.i17;
import com.repackage.j55;
import com.repackage.k35;
import com.repackage.k55;
import com.repackage.lw8;
import com.repackage.m17;
import com.repackage.n17;
import com.repackage.ng;
import com.repackage.ni;
import com.repackage.nn;
import com.repackage.o17;
import com.repackage.pi;
import com.repackage.qg;
import com.repackage.w17;
import com.repackage.ym;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class TopicDetailView extends RelativeLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public m17.b A;
    public int B;
    public int C;
    public NoNetworkView.b D;
    public k35 E;
    public NewWriteModel.e F;
    public final RecyclerView.OnScrollListener G;
    public BdListView.p H;
    public int a;
    public TbPageContext<?> b;
    public c17 c;
    public NavigationBar d;
    public View e;
    public ImageView f;
    public ImageView g;
    public TopicDetailHeadView h;
    public BdTypeRecyclerView i;
    public e17 j;
    public PbListView k;
    public NoNetworkView l;
    public j55 m;
    public k55 n;
    public View o;
    public View p;
    public TextView q;
    public TextView r;
    public n17 s;
    public View t;
    public lw8 u;
    public EditText v;
    public g17 w;
    public boolean x;
    public int y;
    public m17 z;

    /* loaded from: classes3.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && ni.A() && this.a.c != null) {
                this.a.c.a();
            }
        }
    }

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
    public class f implements k35 {
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

        @Override // com.repackage.k35
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

    /* loaded from: classes3.dex */
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
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, fy4 fy4Var, WriteData writeData, AntiData antiData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, fy4Var, writeData, antiData}) == null) {
                if (z && this.a.s != null && this.a.s.a() != null) {
                    this.a.s.a().o();
                }
                if (z) {
                    this.a.u.n(null);
                    this.a.u.i(null);
                    this.a.u.k(false);
                    if (postWriteCallBackData != null) {
                        long g = ng.g(postWriteCallBackData.getPostId(), 0L);
                        long g2 = ng.g(postWriteCallBackData.getThreadId(), 0L);
                        if (g == 0 || g2 == 0) {
                            return;
                        }
                        this.a.A = this.a.z.c(g, g2);
                        qg.a().postDelayed(this.a.A, 500L);
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

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
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
                if (!pi.D()) {
                    this.a.q();
                    return;
                }
                int size = this.a.w.f.size() - 1;
                if (this.a.w.f.get(size) instanceof i17) {
                    ((TopicDetailActivity) this.a.b.getPageActivity()).C1(((i17) this.a.w.f.get(size)).a);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
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
                ei.a(this.a.w);
                pi.O(this.b.getContext(), view2.getResources().getString(R.string.obfuscated_res_0x7f0f0446));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TopicDetailView(TbPageContext<?> tbPageContext, c17 c17Var, Bundle bundle) {
        super(tbPageContext.getPageActivity());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, c17Var, bundle};
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
        this.c = c17Var;
        t(bundle);
        x();
    }

    public void A(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || v()) {
            return;
        }
        if (this.m == null) {
            j55 j55Var = new j55(getContext());
            this.m = j55Var;
            j55Var.onChangeSkinType();
        }
        this.m.attachView(this, z);
    }

    public void B(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) || w()) {
            return;
        }
        if (this.n == null) {
            this.n = new k55(getContext(), new a(this));
        }
        this.n.k(this.b.getResources().getDimensionPixelSize(R.dimen.tbds506));
        this.n.attachView(this, z);
        this.n.p();
        this.i.setVisibility(8);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f, R.drawable.obfuscated_res_0x7f08060d, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
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
        g17 g17Var = this.w;
        String str = g17Var.b;
        String str2 = g17Var.c;
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
        this.b.showToast(getContext().getString(R.string.obfuscated_res_0x7f0f0c55));
    }

    public Bitmap E() {
        InterceptResult invokeV;
        Bitmap drawingCache;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            ym bdImage = this.h.getmBgImg().getBdImage();
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
                this.r.setText(R.string.obfuscated_res_0x7f0f144b);
                SkinManager.setBackgroundResource(this.r, R.drawable.topic_discuss_support_bg);
            } else if (i2 == 2) {
                this.r.setText(R.string.obfuscated_res_0x7f0f144a);
                SkinManager.setBackgroundResource(this.r, R.drawable.topic_discuss_oppose_bg);
            } else {
                this.r.setText(R.string.obfuscated_res_0x7f0f1449);
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

    public n17 getEditor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.s : (n17) invokeV.objValue;
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
            lw8 lw8Var = this.u;
            lw8Var.k(lw8Var.b() >= 0);
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
        g17 g17Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, view2) == null) {
            if (view2 == this.e) {
                this.b.getPageActivity().finish();
            } else if (view2 != this.g || (g17Var = this.w) == null || g17Var.a <= 0) {
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
            n17 n17Var = this.s;
            if (n17Var != null) {
                n17Var.w();
            }
            if (this.A != null) {
                qg.a().removeCallbacks(this.A);
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
        j55 j55Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || (j55Var = this.m) == null) {
            return;
        }
        j55Var.dettachView(this);
        this.m = null;
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            k55 k55Var = this.n;
            if (k55Var != null) {
                k55Var.dettachView(this);
                this.n = null;
            }
            this.i.setVisibility(0);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f, R.drawable.obfuscated_res_0x7f08060d, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public void setData(g17 g17Var) {
        int f2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048592, this, g17Var) == null) || g17Var == null) {
            return;
        }
        this.w = g17Var;
        boolean z = g17Var.g;
        this.x = z;
        if (z && g17Var.f.size() <= 4) {
            this.x = false;
            C();
        } else if (!this.x) {
            C();
        } else {
            z();
        }
        if (!StringUtils.isNull(g17Var.b)) {
            this.d.setCenterTextTitle(String.format(getContext().getString(R.string.obfuscated_res_0x7f0f0478), StringHelper.cutChineseAndEnglishWithSuffix(g17Var.b, 14, StringHelper.STRING_MORE)));
        }
        this.h.setData(g17Var.e);
        this.i.s(this.h);
        this.j.c(g17Var.f);
        w17 w17Var = this.w.e.e;
        if (w17Var != null) {
            if (w17Var.d.e) {
                G(1);
            } else if (w17Var.e.e) {
                G(2);
            } else {
                G(0);
            }
            f2 = pi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds140);
        } else {
            f2 = pi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds50);
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

    public void setNextData(int i2, boolean z, List<nn> list) {
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
            for (nn nnVar : list) {
                if (nnVar instanceof i17) {
                    ((i17) nnVar).f = this.w.a();
                }
            }
            this.w.f.addAll(list);
            this.i.setData(this.w.f);
        }
    }

    public final void t(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, bundle) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d0056, (ViewGroup) this, true);
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.obfuscated_res_0x7f09007c);
            this.d = navigationBar;
            if (this.e == null) {
                View addSystemImageButton = navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
                this.e = addSystemImageButton;
                addSystemImageButton.setOnClickListener(this);
                this.f = (ImageView) this.e.findViewById(R.id.obfuscated_res_0x7f0924ef);
            }
            this.g = (ImageView) this.d.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.obfuscated_res_0x7f0d0846, this);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.g, R.drawable.obfuscated_res_0x7f0809e6, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SkinManager.setViewTextColor(this.d.mCenterText, (int) R.color.CAM_X0101);
            this.d.mCenterText.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.tbds52));
            this.d.mCenterText.setTypeface(Typeface.defaultFromStyle(1));
            NoNetworkView noNetworkView = (NoNetworkView) findViewById(R.id.obfuscated_res_0x7f09007d);
            this.l = noNetworkView;
            noNetworkView.a(this.D);
            this.p = findViewById(R.id.obfuscated_res_0x7f091719);
            TextView textView = (TextView) findViewById(R.id.obfuscated_res_0x7f092170);
            this.q = textView;
            textView.setOnClickListener(new c(this));
            this.r = (TextView) findViewById(R.id.obfuscated_res_0x7f09083f);
            this.o = findViewById(R.id.obfuscated_res_0x7f090079);
            u(bundle);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            addView(this.s.a(), layoutParams);
            this.u = new lw8();
            this.t = findViewById(R.id.obfuscated_res_0x7f09007a);
            BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) findViewById(R.id.obfuscated_res_0x7f09007b);
            this.i = bdTypeRecyclerView;
            bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            this.i.setFadingEdgeLength(0);
            this.i.setOverScrollMode(2);
            this.i.setOnSrollToBottomListener(this.H);
            this.i.addOnScrollListener(this.G);
            SkinManager.setBackgroundColor(this.i, R.color.CAM_X0201);
            this.j = new e17(this.b, this.i);
            TopicDetailHeadView topicDetailHeadView = new TopicDetailHeadView(getContext());
            this.h = topicDetailHeadView;
            topicDetailHeadView.g.setPkClickListener(new d(this));
            if (this.m == null) {
                PbListView pbListView = new PbListView(this.b.getPageActivity());
                this.k = pbListView;
                pbListView.b();
            }
            this.k.p(R.color.CAM_X0205);
            this.k.t(pi.f(this.b.getPageActivity(), R.dimen.tbds182));
            this.k.G(R.dimen.tbfontsize33);
            this.k.A(R.color.CAM_X0110);
            this.k.E(SkinManager.getColor(R.color.CAM_X0110));
            this.k.p(SkinManager.getColor(R.color.CAM_X0201));
            this.k.w(SkinManager.getColor(R.color.CAM_X0204));
            this.k.C(getResources().getString(R.string.obfuscated_res_0x7f0f09e5));
            this.k.b().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            if (this.z == null) {
                m17 m17Var = new m17(this);
                this.z = m17Var;
                m17Var.f(this.b.getUniqueId());
            }
        }
    }

    public final void u(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, bundle) == null) {
            n17 n17Var = (n17) new o17().a(getContext());
            this.s = n17Var;
            if (n17Var == null) {
                return;
            }
            n17Var.E(this.b);
            this.s.F(this.F);
            this.s.D(this.E);
            this.s.a().C(true);
            this.s.a().setBarBackgroundColorId(R.color.CAM_X0207);
            this.s.u((BaseActivity) getContext(), bundle);
            this.s.t();
            this.s.a().setId(R.id.obfuscated_res_0x7f09216f);
            EditText g2 = this.s.n().g();
            this.v = g2;
            g2.addTextChangedListener(new e(this));
        }
    }

    public boolean v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            j55 j55Var = this.m;
            if (j55Var != null) {
                return j55Var.isViewAttached();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            k55 k55Var = this.n;
            if (k55Var != null) {
                return k55Var.isViewAttached();
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
        this.q.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(pi.f(this.b.getPageActivity(), R.dimen.tbds47), SkinManager.getColor(R.color.CAM_X0209)));
        G(this.y);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f, R.drawable.obfuscated_res_0x7f08060d, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        if (this.g != null) {
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.g, R.drawable.obfuscated_res_0x7f0809e6, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        TbPageContext<?> tbPageContext = this.b;
        if (tbPageContext != null && (noNetworkView = this.l) != null) {
            noNetworkView.d(tbPageContext, this.a);
        }
        j55 j55Var = this.m;
        if (j55Var != null) {
            j55Var.onChangeSkinType();
        }
        k55 k55Var = this.n;
        if (k55Var != null) {
            k55Var.onChangeSkinType();
        }
        n17 n17Var = this.s;
        if (n17Var != null && n17Var.a() != null) {
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
        e17 e17Var = this.j;
        if (e17Var != null) {
            e17Var.b();
        }
        SkinManager.setBackgroundColor(this.i, R.color.CAM_X0205);
    }

    public void y(ThreadData threadData) {
        i17 i17Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, threadData) == null) {
            Iterator<nn> it = this.w.f.iterator();
            int i2 = 0;
            while (true) {
                if (!it.hasNext()) {
                    i17Var = null;
                    break;
                }
                nn next = it.next();
                if (next instanceof i17) {
                    i17Var = (i17) next;
                    break;
                }
                i2++;
            }
            if (i17Var != null) {
                i17 i17Var2 = new i17();
                i17Var2.a = i17Var.a;
                i17Var2.b = threadData;
                i17Var2.e = 2;
                i17Var2.d = this.y;
                g17 g17Var = this.w;
                i17Var2.c = g17Var.a;
                i17Var2.f = g17Var.a();
                this.w.f.add(i2, i17Var2);
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
