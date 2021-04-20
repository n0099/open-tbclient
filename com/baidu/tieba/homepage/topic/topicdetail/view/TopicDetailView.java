package com.baidu.tieba.homepage.topic.topicdetail.view;

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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
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
import d.b.c.e.p.l;
import d.b.c.j.e.n;
import d.b.h0.r.q.a2;
import d.b.h0.s.c.h0;
import d.b.i0.a1.j.a.d.a;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class TopicDetailView extends RelativeLayout implements View.OnClickListener {
    public d.b.i0.a1.j.a.c.a A;
    public boolean B;
    public int C;
    public d.b.i0.a1.j.a.d.a D;
    public a.b E;
    public int F;
    public int G;
    public NoNetworkView.b H;
    public d.b.h0.w.w.b I;
    public NewWriteModel.g J;
    public final RecyclerView.OnScrollListener K;
    public BdListView.p L;

    /* renamed from: e  reason: collision with root package name */
    public int f17072e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<?> f17073f;

    /* renamed from: g  reason: collision with root package name */
    public d.b.i0.a1.j.a.a f17074g;

    /* renamed from: h  reason: collision with root package name */
    public NavigationBar f17075h;
    public View i;
    public ImageView j;
    public ImageView k;
    public TopicDetailHeadView l;
    public BdTypeRecyclerView m;
    public d.b.i0.a1.j.a.b.b n;
    public PbListView o;
    public NoNetworkView p;
    public d.b.h0.d0.g q;
    public d.b.h0.d0.h r;
    public View s;
    public View t;
    public TextView u;
    public TextView v;
    public d.b.i0.a1.j.a.e.a w;
    public View x;
    public d.b.i0.v3.c y;
    public EditText z;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!d.b.c.e.p.j.A() || TopicDetailView.this.f17074g == null) {
                return;
            }
            TopicDetailView.this.f17074g.loadData();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements NoNetworkView.b {
        public b() {
        }

        @Override // com.baidu.tbadk.core.view.NoNetworkView.b
        public void b(boolean z) {
            if (z && TopicDetailView.this.A == null && TopicDetailView.this.f17074g != null) {
                TopicDetailView.this.f17074g.loadData();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TopicDetailView.this.o();
        }
    }

    /* loaded from: classes4.dex */
    public class d implements TopicPkView.f {
        public d() {
        }

        @Override // com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.f
        public void a(int i) {
            TopicDetailView.this.K(i);
        }
    }

    /* loaded from: classes4.dex */
    public class e implements TextWatcher {
        public e() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (TopicDetailView.this.y == null) {
                return;
            }
            if (!TopicDetailView.this.y.e()) {
                TopicDetailView.this.n(false);
            }
            TopicDetailView.this.y.l(false);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* loaded from: classes4.dex */
    public class f implements d.b.h0.w.w.b {
        public f() {
        }

        @Override // d.b.h0.w.w.b
        public boolean a() {
            if (TopicDetailView.this.y.d()) {
                TopicDetailView.this.f17073f.showToast(TopicDetailView.this.y.c());
                TopicDetailView.this.n(true);
                return true;
            }
            return false;
        }
    }

    /* loaded from: classes4.dex */
    public class g implements NewWriteModel.g {
        public g() {
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.g
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, h0 h0Var, WriteData writeData, AntiData antiData) {
            if (z && TopicDetailView.this.w != null && TopicDetailView.this.w.a() != null) {
                TopicDetailView.this.w.a().o();
            }
            if (z) {
                TopicDetailView.this.y.n(null);
                TopicDetailView.this.y.i(null);
                TopicDetailView.this.y.k(false);
                if (postWriteCallBackData != null) {
                    long f2 = d.b.c.e.m.b.f(postWriteCallBackData.getPostId(), 0L);
                    long f3 = d.b.c.e.m.b.f(postWriteCallBackData.getThreadId(), 0L);
                    if (f2 == 0 || f3 == 0) {
                        return;
                    }
                    TopicDetailView.this.E = TopicDetailView.this.D.c(f2, f3);
                    d.b.c.e.m.e.a().postDelayed(TopicDetailView.this.E, 500L);
                }
            } else if (postWriteCallBackData == null || !postWriteCallBackData.isSensitiveError()) {
            } else {
                TopicDetailView.this.y.i(postWriteCallBackData.getSensitiveWords());
                TopicDetailView.this.y.n(postWriteCallBackData.getErrorString());
                if (ListUtils.isEmpty(TopicDetailView.this.y.a())) {
                    return;
                }
                TopicDetailView.this.n(true);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h extends RecyclerView.OnScrollListener {
        public h() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i != 0 && TopicDetailView.this.w != null) {
                TopicDetailView.this.w.u();
                TopicDetailView.this.setEditorTopViewAboveEditor();
            }
            super.onScrollStateChanged(TopicDetailView.this.m, i);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            TopicDetailView.this.F += i2;
            TopicDetailView.this.J();
        }
    }

    /* loaded from: classes4.dex */
    public class i implements BdListView.p {
        public i() {
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            if (TopicDetailView.this.B) {
                if (!l.C()) {
                    TopicDetailView.this.q();
                    return;
                }
                int size = TopicDetailView.this.A.f52928f.size() - 1;
                if (TopicDetailView.this.A.f52928f.get(size) instanceof d.b.i0.a1.j.a.c.c) {
                    ((TopicDetailActivity) TopicDetailView.this.f17073f.getPageActivity()).requestNextPageThreadData(((d.b.i0.a1.j.a.c.c) TopicDetailView.this.A.f52928f.get(size)).f52937e);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class j implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ShareItem f17085e;

        public j(ShareItem shareItem) {
            this.f17085e = shareItem;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.b.c.e.p.a.a(this.f17085e.t);
            l.L(TopicDetailView.this.getContext(), view.getResources().getString(R.string.copy_pb_url_success));
        }
    }

    public TopicDetailView(TbPageContext<?> tbPageContext, d.b.i0.a1.j.a.a aVar, Bundle bundle) {
        super(tbPageContext.getPageActivity());
        this.f17072e = 3;
        this.t = null;
        this.u = null;
        this.v = null;
        this.B = true;
        this.F = 0;
        this.G = 44;
        this.H = new b();
        this.I = new f();
        this.J = new g();
        this.K = new h();
        this.L = new i();
        this.f17073f = tbPageContext;
        this.f17074g = aVar;
        u(bundle);
        y();
    }

    public void A() {
        this.B = true;
        this.m.setNextPage(this.o);
        this.o.O();
    }

    public void B(boolean z) {
        if (w()) {
            return;
        }
        if (this.q == null) {
            d.b.h0.d0.g gVar = new d.b.h0.d0.g(getContext());
            this.q = gVar;
            gVar.onChangeSkinType();
        }
        this.q.attachView(this, z);
    }

    public void E(boolean z) {
        if (x()) {
            return;
        }
        if (this.r == null) {
            this.r = new d.b.h0.d0.h(getContext(), new a());
        }
        this.r.j(this.f17073f.getResources().getDimensionPixelSize(R.dimen.tbds506));
        this.r.attachView(this, z);
        this.r.o();
        this.m.setVisibility(8);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.j, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void F() {
        this.m.setNextPage(this.o);
        this.o.f();
    }

    public final void G() {
        if (this.A == null || getContext() == null) {
            return;
        }
        String valueOf = String.valueOf(this.A.f52923a);
        d.b.i0.a1.j.a.c.a aVar = this.A;
        String str = aVar.f52924b;
        String str2 = aVar.f52925c;
        if (!TextUtils.isEmpty(valueOf) && !TextUtils.isEmpty(str)) {
            String str3 = "http://tieba.baidu.com/mo/q/newtopic/detail?topic_id=" + valueOf + "/";
            Uri parse = StringUtils.isNull(this.A.f52926d) ? null : Uri.parse(this.A.f52926d);
            ShareItem shareItem = new ShareItem();
            shareItem.r = str;
            shareItem.s = str2;
            shareItem.t = str3;
            shareItem.i = true;
            shareItem.q = valueOf;
            shareItem.v = parse;
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(getContext(), shareItem, true, true);
            shareDialogConfig.setIsCopyLink(true);
            shareDialogConfig.setCopyLinkListener(new j(shareItem));
            this.f17073f.sendMessage(new CustomMessage(2001276, shareDialogConfig));
            return;
        }
        this.f17073f.showToast(getContext().getString(R.string.no_hot_topic_data));
    }

    public Bitmap I() {
        Bitmap drawingCache;
        d.b.c.j.d.a bdImage = this.l.getmBgImg().getBdImage();
        if (bdImage != null) {
            drawingCache = bdImage.p();
        } else {
            drawingCache = this.l.getmBgImg().getDrawingCache();
        }
        int width = this.f17073f.getPageActivity().getWindowManager().getDefaultDisplay().getWidth();
        int height = this.f17075h.getHeight();
        return (drawingCache == null || drawingCache.getWidth() < width || drawingCache.getHeight() < height) ? drawingCache : Bitmap.createBitmap(drawingCache, 0, 0, width, height);
    }

    public final void J() {
        if (this.A == null || this.l == null) {
            return;
        }
        if (this.F > this.G) {
            this.f17075h.getBarBgView().setAlpha(1.0f);
            this.f17075h.getBarBgView().setBackgroundDrawable(new BitmapDrawable(I()));
            return;
        }
        SkinManager.setBackgroundColor(this.f17075h.getBarBgView(), R.color.transparent);
        this.f17075h.getBarBgView().setAlpha(0.0f);
    }

    public final void K(int i2) {
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
        int i3 = this.f17072e;
        if (i3 != 1 && i3 != 4) {
            SkinManager.setViewTextColor(this.v, R.color.CAM_X0101);
        } else {
            this.v.setTextColor(-2130706433);
        }
    }

    public d.b.i0.a1.j.a.e.a getEditor() {
        return this.w;
    }

    public void n(boolean z) {
        EditText editText = this.z;
        if (editText == null || editText.getText() == null) {
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
            d.b.i0.v3.c cVar = this.y;
            cVar.k(cVar.b() >= 0);
        }
    }

    public void o() {
        if (ViewHelper.checkUpIsLogin(getContext())) {
            this.w.M();
            setEditorTopViewAboveEditor();
        }
        if (this.A != null) {
            TiebaStatic.log(new StatisticItem("c13359").param("topic_id", String.valueOf(this.A.f52923a)));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        d.b.i0.a1.j.a.c.a aVar;
        if (view == this.i) {
            this.f17073f.getPageActivity().finish();
        } else if (view != this.k || (aVar = this.A) == null || aVar.f52923a <= 0) {
        } else {
            G();
            TiebaStatic.log(new StatisticItem("c13364").param("topic_id", String.valueOf(this.A.f52923a)));
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        p();
        super.onDetachedFromWindow();
    }

    public void p() {
        this.m.setOnSrollToBottomListener(null);
        NoNetworkView noNetworkView = this.p;
        if (noNetworkView != null) {
            noNetworkView.d(this.H);
        }
        d.b.i0.a1.j.a.e.a aVar = this.w;
        if (aVar != null) {
            aVar.x();
        }
        if (this.E != null) {
            d.b.c.e.m.e.a().removeCallbacks(this.E);
        }
        r();
        s();
    }

    public final void q() {
        this.m.setNextPage(null);
    }

    public void r() {
        d.b.h0.d0.g gVar = this.q;
        if (gVar != null) {
            gVar.dettachView(this);
            this.q = null;
        }
    }

    public void s() {
        d.b.h0.d0.h hVar = this.r;
        if (hVar != null) {
            hVar.dettachView(this);
            this.r = null;
        }
        this.m.setVisibility(0);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.j, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void setData(d.b.i0.a1.j.a.c.a aVar) {
        int g2;
        if (aVar == null) {
            return;
        }
        this.A = aVar;
        boolean z = aVar.f52929g;
        this.B = z;
        if (z && aVar.f52928f.size() <= 4) {
            this.B = false;
            F();
        } else if (!this.B) {
            F();
        } else {
            A();
        }
        if (!StringUtils.isNull(aVar.f52924b)) {
            this.f17075h.setCenterTextTitle(String.format(getContext().getString(R.string.daily_topic_name), StringHelper.cutChineseAndEnglishWithSuffix(aVar.f52924b, 14, StringHelper.STRING_MORE)));
        }
        this.l.setData(aVar.f52927e);
        this.m.s(this.l);
        this.n.c(aVar.f52928f);
        d.b.i0.a1.j.b.c.b bVar = this.A.f52927e.f52935e;
        if (bVar != null) {
            if (bVar.f52975d.f52982e) {
                K(1);
            } else if (bVar.f52976e.f52982e) {
                K(2);
            } else {
                K(0);
            }
            g2 = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds140);
        } else {
            g2 = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds50);
            this.v.setVisibility(8);
        }
        this.u.setPadding(g2, 0, 0, 0);
        J();
    }

    public void setEditorTopViewAboveEditor() {
        View view = this.x;
        if (view != null) {
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
    }

    public void setNextData(int i2, boolean z, List<n> list) {
        this.B = z;
        if (!z) {
            F();
        } else {
            A();
        }
        if (i2 != 0 || list == null || ListUtils.isEmpty(list)) {
            return;
        }
        for (n nVar : list) {
            if (nVar instanceof d.b.i0.a1.j.a.c.c) {
                ((d.b.i0.a1.j.a.c.c) nVar).j = this.A.a();
            }
        }
        this.A.f52928f.addAll(list);
        this.m.setData(this.A.f52928f);
    }

    public final void u(Bundle bundle) {
        LayoutInflater.from(getContext()).inflate(R.layout.activity_topic_detail_layout, (ViewGroup) this, true);
        NavigationBar navigationBar = (NavigationBar) findViewById(R.id.activity_topic_detail_navigation);
        this.f17075h = navigationBar;
        if (this.i == null) {
            View addSystemImageButton = navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.i = addSystemImageButton;
            addSystemImageButton.setOnClickListener(this);
            this.j = (ImageView) this.i.findViewById(R.id.widget_navi_back_button);
        }
        this.k = (ImageView) this.f17075h.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.topic_detail_share_layout, this);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.k, R.drawable.icon_pure_topbar_share44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SkinManager.setViewTextColor(this.f17075h.mCenterText, R.color.CAM_X0101);
        this.f17075h.mCenterText.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.tbds52));
        this.f17075h.mCenterText.setTypeface(Typeface.defaultFromStyle(1));
        NoNetworkView noNetworkView = (NoNetworkView) findViewById(R.id.activity_topic_detail_no_network_view);
        this.p = noNetworkView;
        noNetworkView.a(this.H);
        this.t = findViewById(R.id.pb_editor_tool_comment);
        TextView textView = (TextView) findViewById(R.id.topic_editor_tool_comment_reply_text);
        this.u = textView;
        textView.setOnClickListener(new c());
        this.v = (TextView) findViewById(R.id.editor_tool_opinion_text_view);
        this.s = findViewById(R.id.activity_topic_detail_editor);
        v(bundle);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        addView(this.w.a(), layoutParams);
        this.y = new d.b.i0.v3.c();
        this.x = findViewById(R.id.activity_topic_detail_editor_top);
        BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) findViewById(R.id.activity_topic_detail_list);
        this.m = bdTypeRecyclerView;
        bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        this.m.setFadingEdgeLength(0);
        this.m.setOverScrollMode(2);
        this.m.setOnSrollToBottomListener(this.L);
        this.m.addOnScrollListener(this.K);
        SkinManager.setBackgroundColor(this.m, R.color.CAM_X0201);
        this.n = new d.b.i0.a1.j.a.b.b(this.f17073f, this.m);
        TopicDetailHeadView topicDetailHeadView = new TopicDetailHeadView(getContext());
        this.l = topicDetailHeadView;
        topicDetailHeadView.k.setPkClickListener(new d());
        if (this.q == null) {
            PbListView pbListView = new PbListView(this.f17073f.getPageActivity());
            this.o = pbListView;
            pbListView.b();
        }
        this.o.o(R.color.CAM_X0205);
        this.o.r(l.g(this.f17073f.getPageActivity(), R.dimen.tbds182));
        this.o.E(R.dimen.tbfontsize33);
        this.o.y(R.color.CAM_X0110);
        this.o.C(SkinManager.getColor(R.color.CAM_X0110));
        this.o.o(SkinManager.getColor(R.color.CAM_X0201));
        this.o.u(SkinManager.getColor(R.color.CAM_X0204));
        this.o.A(getResources().getString(R.string.list_has_no_more));
        this.o.b().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        if (this.D == null) {
            d.b.i0.a1.j.a.d.a aVar = new d.b.i0.a1.j.a.d.a(this);
            this.D = aVar;
            aVar.f(this.f17073f.getUniqueId());
        }
    }

    public final void v(Bundle bundle) {
        d.b.i0.a1.j.a.e.a aVar = (d.b.i0.a1.j.a.e.a) new d.b.i0.a1.j.a.e.b().a(getContext());
        this.w = aVar;
        if (aVar == null) {
            return;
        }
        aVar.F(this.f17073f);
        this.w.G(this.J);
        this.w.E(this.I);
        this.w.a().C(true);
        this.w.a().setBarBackgroundColorId(R.color.CAM_X0207);
        this.w.v((BaseActivity) getContext(), bundle);
        this.w.u();
        this.w.a().setId(R.id.topic_editor);
        EditText g2 = this.w.o().g();
        this.z = g2;
        g2.addTextChangedListener(new e());
    }

    public boolean w() {
        d.b.h0.d0.g gVar = this.q;
        if (gVar != null) {
            return gVar.isViewAttached();
        }
        return false;
    }

    public boolean x() {
        d.b.h0.d0.h hVar = this.r;
        if (hVar != null) {
            return hVar.isViewAttached();
        }
        return false;
    }

    public void y() {
        NoNetworkView noNetworkView;
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType == this.f17072e) {
            return;
        }
        this.f17072e = skinType;
        J();
        SkinManager.setViewTextColor(this.f17075h.mCenterText, R.color.CAM_X0101);
        SkinManager.setBackgroundResource(this.t, R.color.CAM_X0207);
        SkinManager.setViewTextColor(this.u, R.color.CAM_X0109);
        this.u.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(l.g(this.f17073f.getPageActivity(), R.dimen.tbds47), SkinManager.getColor(R.color.CAM_X0209)));
        K(this.C);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.j, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        if (this.k != null) {
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.k, R.drawable.icon_pure_topbar_share44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        TbPageContext<?> tbPageContext = this.f17073f;
        if (tbPageContext != null && (noNetworkView = this.p) != null) {
            noNetworkView.c(tbPageContext, this.f17072e);
        }
        d.b.h0.d0.g gVar = this.q;
        if (gVar != null) {
            gVar.onChangeSkinType();
        }
        d.b.h0.d0.h hVar = this.r;
        if (hVar != null) {
            hVar.onChangeSkinType();
        }
        d.b.i0.a1.j.a.e.a aVar = this.w;
        if (aVar != null && aVar.a() != null) {
            this.w.a().w(this.f17072e);
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
        d.b.i0.a1.j.a.b.b bVar = this.n;
        if (bVar != null) {
            bVar.b();
        }
        SkinManager.setBackgroundColor(this.m, R.color.CAM_X0205);
    }

    public void z(a2 a2Var) {
        d.b.i0.a1.j.a.c.c cVar;
        Iterator<n> it = this.A.f52928f.iterator();
        int i2 = 0;
        while (true) {
            if (!it.hasNext()) {
                cVar = null;
                break;
            }
            n next = it.next();
            if (next instanceof d.b.i0.a1.j.a.c.c) {
                cVar = (d.b.i0.a1.j.a.c.c) next;
                break;
            }
            i2++;
        }
        if (cVar != null) {
            d.b.i0.a1.j.a.c.c cVar2 = new d.b.i0.a1.j.a.c.c();
            cVar2.f52937e = cVar.f52937e;
            cVar2.f52938f = a2Var;
            cVar2.i = 2;
            cVar2.f52940h = this.C;
            d.b.i0.a1.j.a.c.a aVar = this.A;
            cVar2.f52939g = aVar.f52923a;
            cVar2.j = aVar.a();
            this.A.f52928f.add(i2, cVar2);
            this.n.c(this.A.f52928f);
        }
    }
}
