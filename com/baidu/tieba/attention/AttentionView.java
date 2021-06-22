package com.baidu.tieba.attention;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.R;
import com.baidu.tieba.adapter.SelectForumItemAdapter;
import d.a.n0.d0.g;
import d.a.n0.d0.h;
import d.a.n0.t.j;
import d.a.o0.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class AttentionView extends FrameLayout implements d<String> {

    /* renamed from: e  reason: collision with root package name */
    public int f14213e;

    /* renamed from: f  reason: collision with root package name */
    public RecyclerView f14214f;

    /* renamed from: g  reason: collision with root package name */
    public SelectForumItemAdapter f14215g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayoutManager f14216h;

    /* renamed from: i  reason: collision with root package name */
    public g f14217i;
    public h j;
    public List<j> k;
    public boolean l;
    public int m;
    public HttpMessageListener n;

    /* loaded from: classes4.dex */
    public class a extends HttpMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            AttentionView.this.j();
            if (httpResponsedMessage.getError() != 0) {
                if (ListUtils.isEmpty(AttentionView.this.k)) {
                    AttentionView.this.q(false, true);
                }
            } else if (!(httpResponsedMessage instanceof AttentionResMsg)) {
                if (ListUtils.isEmpty(AttentionView.this.k)) {
                    AttentionView.this.q(false, true);
                }
            } else {
                AttentionResMsg attentionResMsg = (AttentionResMsg) httpResponsedMessage;
                List<j> selectForumDataList = attentionResMsg.getSelectForumDataList();
                if (ListUtils.isEmpty(selectForumDataList)) {
                    if (ListUtils.isEmpty(AttentionView.this.k)) {
                        AttentionView.this.q(false, false);
                        return;
                    }
                    return;
                }
                AttentionView.this.l = attentionResMsg.getHasMore();
                AttentionView.g(AttentionView.this);
                AttentionView.this.k.addAll(selectForumDataList);
                AttentionView.this.f14215g.g(AttentionView.this.k);
                AttentionView.this.f14215g.notifyDataSetChanged();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends RecyclerView.OnScrollListener {
        public b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            if (i2 == 0 && AttentionView.this.l && AttentionView.this.f14216h.findLastVisibleItemPosition() == AttentionView.this.f14215g.getItemCount() - 1) {
                AttentionView.this.c(null);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (d.a.c.e.p.j.A()) {
                AttentionView.this.c(null);
            }
        }
    }

    public AttentionView(Context context) {
        this(context, null);
    }

    public static /* synthetic */ int g(AttentionView attentionView) {
        int i2 = attentionView.m;
        attentionView.m = i2 + 1;
        return i2;
    }

    @Override // d.a.o0.d
    public void a() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType == this.f14213e) {
            return;
        }
        this.f14213e = skinType;
        g gVar = this.f14217i;
        if (gVar != null) {
            gVar.onChangeSkinType();
        }
        h hVar = this.j;
        if (hVar != null) {
            hVar.onChangeSkinType();
        }
        this.f14215g.notifyDataSetChanged();
    }

    @Override // d.a.o0.d
    public void b(String str) {
    }

    @Override // d.a.o0.d
    public String getTitle() {
        return getContext().getString(R.string.activity_select_forum_tab_attention);
    }

    public void j() {
        g gVar = this.f14217i;
        if (gVar != null) {
            gVar.dettachView(this);
            this.f14217i = null;
        }
    }

    public void k() {
        h hVar = this.j;
        if (hVar != null) {
            hVar.dettachView(this);
            this.j = null;
        }
        this.f14214f.setVisibility(0);
    }

    public final void l() {
        LayoutInflater.from(getContext()).inflate(R.layout.select_forum_lately_layout, (ViewGroup) this, true);
        this.f14214f = (RecyclerView) findViewById(R.id.select_forum_list);
        SelectForumItemAdapter selectForumItemAdapter = new SelectForumItemAdapter(this);
        this.f14215g = selectForumItemAdapter;
        selectForumItemAdapter.h(2);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        this.f14216h = linearLayoutManager;
        this.f14214f.setLayoutManager(linearLayoutManager);
        this.f14214f.setAdapter(this.f14215g);
        this.f14214f.addOnScrollListener(new b());
        MessageManager.getInstance().registerListener(this.n);
    }

    public boolean m() {
        g gVar = this.f14217i;
        if (gVar != null) {
            return gVar.isViewAttached();
        }
        return false;
    }

    public boolean n() {
        h hVar = this.j;
        if (hVar != null) {
            return hVar.isViewAttached();
        }
        return false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.o0.d
    /* renamed from: o */
    public void c(String str) {
        if (ListUtils.isEmpty(this.k)) {
            if (!d.a.c.e.p.j.A()) {
                q(false, true);
                return;
            } else {
                k();
                p(false);
            }
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_SELECT_FORUM_ATTENTION);
        httpMessage.addParam("uid", TbadkCoreApplication.getCurrentAccount());
        httpMessage.addParam("from_index", 1);
        httpMessage.addParam("page_size", 50);
        httpMessage.addParam("page_no", this.m);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    @Override // d.a.o0.d
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.n);
    }

    public void p(boolean z) {
        if (m()) {
            return;
        }
        if (this.f14217i == null) {
            g gVar = new g(getContext());
            this.f14217i = gVar;
            gVar.onChangeSkinType();
        }
        this.f14217i.attachView(this, z);
    }

    public void q(boolean z, boolean z2) {
        if (n()) {
            return;
        }
        if (this.j == null) {
            this.j = new h(getContext(), new c());
        }
        this.j.j(getResources().getDimensionPixelSize(R.dimen.tbds380));
        this.j.attachView(this, z);
        if (z2) {
            this.j.o();
        } else {
            this.j.h(R.drawable.new_pic_emotion_01);
            this.j.e();
        }
        this.j.n(getContext().getString(R.string.activity_select_forum_empty));
        this.f14214f.setVisibility(8);
    }

    public AttentionView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AttentionView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f14213e = 3;
        this.k = new ArrayList();
        this.m = 1;
        this.n = new a(CmdConfigHttp.CMD_SELECT_FORUM_ATTENTION);
        l();
    }
}
