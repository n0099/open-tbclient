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
import d.b.b.j.e.j;
import d.b.b.j.e.l;
import d.b.h0.b.d;
import d.b.h0.m.f;
import d.b.h0.r.q.s1;
import d.b.i.q;
/* loaded from: classes3.dex */
public class ConcernRecommendLayout extends LinearLayout implements q {

    /* renamed from: e  reason: collision with root package name */
    public final Context f17048e;

    /* renamed from: f  reason: collision with root package name */
    public int f17049f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f17050g;

    /* renamed from: h  reason: collision with root package name */
    public RecyclerView f17051h;
    public ConcernRecommendListAdapter i;
    public l j;
    public int k;
    public CustomMessageListener l;

    /* loaded from: classes3.dex */
    public class a extends CustomMessageListener {
        public a(int i) {
            super(i);
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
                ConcernRecommendLayout.this.j.q(ConcernRecommendLayout.this.f17051h, 1);
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
        this.f17050g = (TextView) findViewById(R.id.title);
        this.f17051h = (RecyclerView) findViewById(R.id.thread_card_list);
        ConcernRecommendListAdapter concernRecommendListAdapter = new ConcernRecommendListAdapter(this.f17048e);
        this.i = concernRecommendListAdapter;
        this.f17051h.setAdapter(concernRecommendListAdapter);
        this.f17051h.setClipChildren(false);
        if (TbSingleton.getInstance().isSlideAnimEnable()) {
            l lVar = new l(new j());
            this.j = lVar;
            lVar.q(this.f17051h, 1);
        }
        int g2 = d.b.b.e.p.l.g(this.f17048e, R.dimen.tbds21);
        int g3 = d.b.b.e.p.l.g(this.f17048e, R.dimen.tbds44);
        this.f17051h.setLayoutManager(new LinearLayoutManager(this.f17048e, 0, false));
        this.f17051h.setItemAnimator(new DefaultItemAnimator());
        this.f17051h.addItemDecoration(new SpaceItemDecoration(g3, g2, g3));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f17051h.getLayoutParams();
        if (d.R()) {
            layoutParams.bottomMargin = d.b.b.e.p.l.g(this.f17048e, R.dimen.tbds39);
        } else {
            layoutParams.bottomMargin = d.b.b.e.p.l.g(this.f17048e, R.dimen.tbds22);
        }
        this.f17051h.setLayoutParams(layoutParams);
    }

    @Override // d.b.i.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (i != this.f17049f) {
            SkinManager.setViewTextColor(this.f17050g, this.k);
            this.i.g(i);
        }
        this.f17049f = i;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    public void setData(s1 s1Var) {
        if (s1Var == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        if (!TextUtils.isEmpty(s1Var.f50882e) && s1Var.f50883f != 0) {
            this.f17050g.setTextSize(0, d.b.b.e.p.l.g(this.f17048e, R.dimen.tbds37));
            this.f17050g.setText(s1Var.f50882e);
            this.f17050g.setTypeface(Typeface.DEFAULT_BOLD);
            this.k = s1Var.f50883f;
        } else {
            this.f17050g.setTextSize(0, d.b.b.e.p.l.g(this.f17048e, R.dimen.tbds37));
            this.f17050g.setText(R.string.concern_recommend_title);
            this.f17050g.setTypeface(Typeface.DEFAULT_BOLD);
            this.k = R.color.CAM_X0105;
        }
        this.i.g(TbadkCoreApplication.getInst().getSkinType());
        this.i.setData(s1Var.z());
        this.i.notifyDataSetChanged();
    }

    public void setHasBorder(boolean z) {
        this.i.j(z);
    }

    public void setOnItemCoverListener(f<MetaData> fVar) {
        this.i.k(fVar);
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.i.l(tbPageContext);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.l.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.l);
        this.i.m(bdUniqueId);
    }

    public ConcernRecommendLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f17049f = 3;
        this.k = R.color.CAM_X0108;
        this.l = new a(2156674);
        this.f17048e = context;
        d();
    }
}
