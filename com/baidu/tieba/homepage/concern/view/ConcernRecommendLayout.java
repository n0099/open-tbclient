package com.baidu.tieba.homepage.concern.view;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.SpaceItemDecoration;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.concern.adapter.ConcernRecommendListAdapter;
import d.a.c.j.e.j;
import d.a.c.j.e.l;
import d.a.i.q;
import d.a.m0.b.d;
import d.a.m0.m.f;
import d.a.m0.r.q.s1;
/* loaded from: classes4.dex */
public class ConcernRecommendLayout extends LinearLayout implements q {

    /* renamed from: e  reason: collision with root package name */
    public final Context f16201e;

    /* renamed from: f  reason: collision with root package name */
    public int f16202f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f16203g;

    /* renamed from: h  reason: collision with root package name */
    public RecyclerView f16204h;

    /* renamed from: i  reason: collision with root package name */
    public ConcernRecommendListAdapter f16205i;
    public l j;
    public int k;
    public CustomMessageListener l;

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof Boolean)) {
                return;
            }
            if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                if (ConcernRecommendLayout.this.j == null) {
                    ConcernRecommendLayout.this.j = new l(new j());
                }
                ConcernRecommendLayout.this.j.q(ConcernRecommendLayout.this.f16204h, 1);
            } else if (ConcernRecommendLayout.this.j != null) {
                ConcernRecommendLayout.this.j.w();
            }
        }
    }

    public ConcernRecommendLayout(Context context) {
        this(context, null);
    }

    public final void d() {
        LayoutInflater.from(getContext()).inflate(R.layout.concern_recommend_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.f16203g = (TextView) findViewById(R.id.title);
        this.f16204h = (RecyclerView) findViewById(R.id.thread_card_list);
        ConcernRecommendListAdapter concernRecommendListAdapter = new ConcernRecommendListAdapter(this.f16201e);
        this.f16205i = concernRecommendListAdapter;
        this.f16204h.setAdapter(concernRecommendListAdapter);
        this.f16204h.setClipChildren(false);
        if (TbSingleton.getInstance().isSlideAnimEnable()) {
            l lVar = new l(new j());
            this.j = lVar;
            lVar.q(this.f16204h, 1);
        }
        int g2 = d.a.c.e.p.l.g(this.f16201e, R.dimen.tbds21);
        int g3 = d.a.c.e.p.l.g(this.f16201e, R.dimen.tbds44);
        this.f16204h.setLayoutManager(new LinearLayoutManager(this.f16201e, 0, false));
        this.f16204h.setItemAnimator(new DefaultItemAnimator());
        this.f16204h.addItemDecoration(new SpaceItemDecoration(g3, g2, g3));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f16204h.getLayoutParams();
        if (d.V()) {
            layoutParams.bottomMargin = d.a.c.e.p.l.g(this.f16201e, R.dimen.tbds39);
        } else {
            layoutParams.bottomMargin = d.a.c.e.p.l.g(this.f16201e, R.dimen.tbds22);
        }
        this.f16204h.setLayoutParams(layoutParams);
    }

    @Override // d.a.i.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i2) {
        if (i2 != this.f16202f) {
            SkinManager.setViewTextColor(this.f16203g, this.k);
            this.f16205i.g(i2);
        }
        this.f16202f = i2;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
    }

    public void setData(s1 s1Var) {
        if (s1Var == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        if (!TextUtils.isEmpty(s1Var.f50121e) && s1Var.f50122f != 0) {
            this.f16203g.setTextSize(0, d.a.c.e.p.l.g(this.f16201e, R.dimen.tbds37));
            this.f16203g.setText(s1Var.f50121e);
            this.f16203g.setTypeface(Typeface.DEFAULT_BOLD);
            this.k = s1Var.f50122f;
        } else {
            this.f16203g.setTextSize(0, d.a.c.e.p.l.g(this.f16201e, R.dimen.tbds37));
            this.f16203g.setText(R.string.concern_recommend_title);
            this.f16203g.setTypeface(Typeface.DEFAULT_BOLD);
            this.k = R.color.CAM_X0105;
        }
        this.f16205i.g(TbadkCoreApplication.getInst().getSkinType());
        this.f16205i.setData(s1Var.z());
        this.f16205i.notifyDataSetChanged();
    }

    public void setHasBorder(boolean z) {
        this.f16205i.j(z);
    }

    public void setOnItemCoverListener(f<MetaData> fVar) {
        this.f16205i.k(fVar);
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.f16205i.l(tbPageContext);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.l.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.l);
        this.f16205i.m(bdUniqueId);
    }

    public ConcernRecommendLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f16202f = 3;
        this.k = R.color.CAM_X0108;
        this.l = new a(2156674);
        this.f16201e = context;
        d();
    }
}
