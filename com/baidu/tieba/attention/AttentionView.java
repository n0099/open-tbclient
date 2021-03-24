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
import d.b.b.e.p.j;
import d.b.h0.d0.g;
import d.b.h0.d0.h;
import d.b.h0.t.i;
import d.b.i0.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class AttentionView extends FrameLayout implements d<String> {

    /* renamed from: e  reason: collision with root package name */
    public int f15099e;

    /* renamed from: f  reason: collision with root package name */
    public RecyclerView f15100f;

    /* renamed from: g  reason: collision with root package name */
    public SelectForumItemAdapter f15101g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayoutManager f15102h;
    public g i;
    public h j;
    public List<i> k;
    public boolean l;
    public int m;
    public HttpMessageListener n;

    /* loaded from: classes4.dex */
    public class a extends HttpMessageListener {
        public a(int i) {
            super(i);
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
                List<i> selectForumDataList = attentionResMsg.getSelectForumDataList();
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
                AttentionView.this.f15101g.g(AttentionView.this.k);
                AttentionView.this.f15101g.notifyDataSetChanged();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends RecyclerView.OnScrollListener {
        public b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i == 0 && AttentionView.this.l && AttentionView.this.f15102h.findLastVisibleItemPosition() == AttentionView.this.f15101g.getItemCount() - 1) {
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
            if (j.A()) {
                AttentionView.this.c(null);
            }
        }
    }

    public AttentionView(Context context) {
        this(context, null);
    }

    public static /* synthetic */ int g(AttentionView attentionView) {
        int i = attentionView.m;
        attentionView.m = i + 1;
        return i;
    }

    @Override // d.b.i0.d
    public void a() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType == this.f15099e) {
            return;
        }
        this.f15099e = skinType;
        g gVar = this.i;
        if (gVar != null) {
            gVar.onChangeSkinType();
        }
        h hVar = this.j;
        if (hVar != null) {
            hVar.onChangeSkinType();
        }
        this.f15101g.notifyDataSetChanged();
    }

    @Override // d.b.i0.d
    public void b(String str) {
    }

    @Override // d.b.i0.d
    public String getTitle() {
        return getContext().getString(R.string.activity_select_forum_tab_attention);
    }

    public void j() {
        g gVar = this.i;
        if (gVar != null) {
            gVar.dettachView(this);
            this.i = null;
        }
    }

    public void k() {
        h hVar = this.j;
        if (hVar != null) {
            hVar.dettachView(this);
            this.j = null;
        }
        this.f15100f.setVisibility(0);
    }

    public final void l() {
        LayoutInflater.from(getContext()).inflate(R.layout.select_forum_lately_layout, (ViewGroup) this, true);
        this.f15100f = (RecyclerView) findViewById(R.id.select_forum_list);
        SelectForumItemAdapter selectForumItemAdapter = new SelectForumItemAdapter(this);
        this.f15101g = selectForumItemAdapter;
        selectForumItemAdapter.h(2);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        this.f15102h = linearLayoutManager;
        this.f15100f.setLayoutManager(linearLayoutManager);
        this.f15100f.setAdapter(this.f15101g);
        this.f15100f.addOnScrollListener(new b());
        MessageManager.getInstance().registerListener(this.n);
    }

    public boolean m() {
        g gVar = this.i;
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
    @Override // d.b.i0.d
    /* renamed from: o */
    public void c(String str) {
        if (ListUtils.isEmpty(this.k)) {
            if (!j.A()) {
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

    @Override // d.b.i0.d
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.n);
    }

    public void p(boolean z) {
        if (m()) {
            return;
        }
        if (this.i == null) {
            g gVar = new g(getContext());
            this.i = gVar;
            gVar.onChangeSkinType();
        }
        this.i.attachView(this, z);
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
        this.f15100f.setVisibility(8);
    }

    public AttentionView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AttentionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f15099e = 3;
        this.k = new ArrayList();
        this.m = 1;
        this.n = new a(CmdConfigHttp.CMD_SELECT_FORUM_ATTENTION);
        l();
    }
}
