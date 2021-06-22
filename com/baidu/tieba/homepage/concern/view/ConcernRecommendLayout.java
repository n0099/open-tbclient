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
import d.a.c.k.e.j;
import d.a.c.k.e.l;
import d.a.i.q;
import d.a.n0.b.d;
import d.a.n0.m.f;
import d.a.n0.r.q.s1;
/* loaded from: classes4.dex */
public class ConcernRecommendLayout extends LinearLayout implements q {

    /* renamed from: e  reason: collision with root package name */
    public final Context f16351e;

    /* renamed from: f  reason: collision with root package name */
    public int f16352f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f16353g;

    /* renamed from: h  reason: collision with root package name */
    public RecyclerView f16354h;

    /* renamed from: i  reason: collision with root package name */
    public ConcernRecommendListAdapter f16355i;
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
                ConcernRecommendLayout.this.j.q(ConcernRecommendLayout.this.f16354h, 1);
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
        this.f16353g = (TextView) findViewById(R.id.title);
        this.f16354h = (RecyclerView) findViewById(R.id.thread_card_list);
        ConcernRecommendListAdapter concernRecommendListAdapter = new ConcernRecommendListAdapter(this.f16351e);
        this.f16355i = concernRecommendListAdapter;
        this.f16354h.setAdapter(concernRecommendListAdapter);
        this.f16354h.setClipChildren(false);
        if (TbSingleton.getInstance().isSlideAnimEnable()) {
            l lVar = new l(new j());
            this.j = lVar;
            lVar.q(this.f16354h, 1);
        }
        int g2 = d.a.c.e.p.l.g(this.f16351e, R.dimen.tbds21);
        int g3 = d.a.c.e.p.l.g(this.f16351e, R.dimen.tbds44);
        this.f16354h.setLayoutManager(new LinearLayoutManager(this.f16351e, 0, false));
        this.f16354h.setItemAnimator(new DefaultItemAnimator());
        this.f16354h.addItemDecoration(new SpaceItemDecoration(g3, g2, g3));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f16354h.getLayoutParams();
        if (d.V()) {
            layoutParams.bottomMargin = d.a.c.e.p.l.g(this.f16351e, R.dimen.tbds39);
        } else {
            layoutParams.bottomMargin = d.a.c.e.p.l.g(this.f16351e, R.dimen.tbds22);
        }
        this.f16354h.setLayoutParams(layoutParams);
    }

    @Override // d.a.i.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i2) {
        if (i2 != this.f16352f) {
            SkinManager.setViewTextColor(this.f16353g, this.k);
            this.f16355i.g(i2);
        }
        this.f16352f = i2;
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
        if (!TextUtils.isEmpty(s1Var.f53904e) && s1Var.f53905f != 0) {
            this.f16353g.setTextSize(0, d.a.c.e.p.l.g(this.f16351e, R.dimen.tbds37));
            this.f16353g.setText(s1Var.f53904e);
            this.f16353g.setTypeface(Typeface.DEFAULT_BOLD);
            this.k = s1Var.f53905f;
        } else {
            this.f16353g.setTextSize(0, d.a.c.e.p.l.g(this.f16351e, R.dimen.tbds37));
            this.f16353g.setText(R.string.concern_recommend_title);
            this.f16353g.setTypeface(Typeface.DEFAULT_BOLD);
            this.k = R.color.CAM_X0105;
        }
        this.f16355i.g(TbadkCoreApplication.getInst().getSkinType());
        this.f16355i.setData(s1Var.z());
        this.f16355i.notifyDataSetChanged();
    }

    public void setHasBorder(boolean z) {
        this.f16355i.j(z);
    }

    public void setOnItemCoverListener(f<MetaData> fVar) {
        this.f16355i.k(fVar);
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.f16355i.l(tbPageContext);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.l.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.l);
        this.f16355i.m(bdUniqueId);
    }

    public ConcernRecommendLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f16352f = 3;
        this.k = R.color.CAM_X0108;
        this.l = new a(2156674);
        this.f16351e = context;
        d();
    }
}
