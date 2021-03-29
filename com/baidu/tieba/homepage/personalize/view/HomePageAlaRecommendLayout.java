package com.baidu.tieba.homepage.personalize.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.personalize.adapter.AlaRecommendListAdapter;
import d.b.b.e.p.l;
import d.b.h0.b.g.b;
import d.b.i0.z0.g.j.f;
import java.util.List;
import tbclient.AlaLiveInfo;
import tbclient.AlaUserInfo;
/* loaded from: classes3.dex */
public class HomePageAlaRecommendLayout extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public Context f17292e;

    /* renamed from: f  reason: collision with root package name */
    public int f17293f;

    /* renamed from: g  reason: collision with root package name */
    public BdRecyclerView f17294g;

    /* renamed from: h  reason: collision with root package name */
    public AlaRecommendListAdapter f17295h;
    public List<AlaLiveInfo> i;
    public CustomMessageListener j;

    /* loaded from: classes3.dex */
    public class a extends CustomMessageListener {
        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage.a data;
            AlaUserInfo alaUserInfo;
            Long l;
            if (!(customResponsedMessage instanceof UpdateAttentionMessage) || (data = ((UpdateAttentionMessage) customResponsedMessage).getData()) == null || data.f13696d || StringUtils.isNull(data.f13695c) || HomePageAlaRecommendLayout.this.i == null) {
                return;
            }
            for (AlaLiveInfo alaLiveInfo : HomePageAlaRecommendLayout.this.i) {
                if (alaLiveInfo != null && (alaUserInfo = alaLiveInfo.user_info) != null && (l = alaUserInfo.user_id) != null && data.f13695c.equals(l.toString())) {
                    HomePageAlaRecommendLayout.this.i.remove(alaLiveInfo);
                    HomePageAlaRecommendLayout.this.d();
                    return;
                }
            }
        }
    }

    public HomePageAlaRecommendLayout(Context context) {
        this(context, null);
    }

    public final void b() {
        LayoutInflater.from(getContext()).inflate(R.layout.home_page_ala_recommend_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.f17294g = (BdRecyclerView) findViewById(R.id.ala_recommend_list);
        AlaRecommendListAdapter alaRecommendListAdapter = new AlaRecommendListAdapter(this.f17292e);
        this.f17295h = alaRecommendListAdapter;
        this.f17294g.setAdapter(alaRecommendListAdapter);
        this.f17294g.setLayoutManager(new LinearLayoutManager(this.f17292e, 0, false));
        this.f17294g.setItemAnimator(new DefaultItemAnimator());
        int g2 = l.g(this.f17292e, R.dimen.tbds20);
        this.f17294g.addItemDecoration(new CommonSpaceItemDecoration(g2, 0, g2));
        BdRecyclerView bdRecyclerView = this.f17294g;
        bdRecyclerView.setPadding(bdRecyclerView.getPaddingLeft(), this.f17294g.getPaddingTop(), this.f17294g.getPaddingRight(), l.g(this.f17294g.getContext(), b.c(R.dimen.tbds0, R.dimen.tbds51)));
    }

    public void c(int i) {
        if (this.f17293f == i) {
            return;
        }
        this.f17293f = i;
    }

    public void d() {
        if (ListUtils.isEmpty(this.i)) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.f17295h.setData(this.i);
        this.f17295h.notifyDataSetChanged();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        MessageManager.getInstance().registerListener(this.j);
        super.onAttachedToWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        MessageManager.getInstance().unRegisterListener(this.j);
        super.onDetachedFromWindow();
    }

    public void setData(f fVar) {
        if (fVar != null && !ListUtils.isEmpty(fVar.z())) {
            this.i = fVar.z();
            setVisibility(0);
            d();
            return;
        }
        setVisibility(8);
    }

    public HomePageAlaRecommendLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f17293f = 3;
        this.j = new a(2001115);
        this.f17292e = context;
        b();
    }
}
