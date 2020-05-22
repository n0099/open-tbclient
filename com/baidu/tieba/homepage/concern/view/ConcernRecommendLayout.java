package com.baidu.tieba.homepage.concern.view;

import android.content.Context;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.k;
import com.baidu.adp.widget.ListView.m;
import com.baidu.card.o;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class ConcernRecommendLayout extends LinearLayout implements o {
    private RecyclerView gYa;
    private m gYf;
    private CustomMessageListener gYh;
    private com.baidu.tieba.homepage.concern.a.o hYp;
    private final Context mContext;
    private int mSkinType;
    private TextView mTitleView;

    public ConcernRecommendLayout(Context context) {
        this(context, null);
    }

    public ConcernRecommendLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.gYh = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.homepage.concern.view.ConcernRecommendLayout.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (ConcernRecommendLayout.this.gYf == null) {
                            ConcernRecommendLayout.this.gYf = new m(new k());
                        }
                        ConcernRecommendLayout.this.gYf.a(ConcernRecommendLayout.this.gYa, 1);
                    } else if (ConcernRecommendLayout.this.gYf != null) {
                        ConcernRecommendLayout.this.gYf.pl();
                    }
                }
            }
        };
        this.mContext = context;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.concern_recommend_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.mTitleView = (TextView) findViewById(R.id.title);
        this.gYa = (RecyclerView) findViewById(R.id.thread_card_list);
        this.hYp = new com.baidu.tieba.homepage.concern.a.o(this.mContext);
        this.gYa.setAdapter(this.hYp);
        this.gYa.setClipChildren(false);
        if (TbSingleton.getInstance().isSlideAnimEnable()) {
            this.gYf = new m(new k());
            this.gYf.a(this.gYa, 1);
        }
        int dimens = l.getDimens(this.mContext, R.dimen.tbds44);
        int dimens2 = l.getDimens(this.mContext, R.dimen.tbds44);
        this.gYa.setLayoutManager(new LinearLayoutManager(this.mContext, 0, false));
        this.gYa.setItemAnimator(new DefaultItemAnimator());
        this.gYa.addItemDecoration(new a(dimens2, dimens, dimens2));
    }

    @Override // com.baidu.card.o
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (i != this.mSkinType) {
            am.setViewTextColor(this.mTitleView, (int) R.color.cp_cont_c);
            this.hYp.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    public void setData(com.baidu.tieba.homepage.concern.b.b bVar) {
        if (bVar == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        am.setViewTextColor(this.mTitleView, (int) R.color.cp_cont_c);
        this.mTitleView.setText(R.string.concern_recommend_title);
        this.hYp.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.hYp.setData(bVar.ceA());
        this.hYp.notifyDataSetChanged();
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.gYh.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.gYh);
        this.hYp.setPageUniqueId(bdUniqueId);
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.hYp.setPageContext(tbPageContext);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class a extends RecyclerView.ItemDecoration {
        private int gYk;
        private int gYl;
        private int mEnd;

        public a(int i, int i2, int i3) {
            this.gYk = i;
            this.gYl = i2;
            this.mEnd = i3;
        }

        @Override // android.support.v7.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            super.getItemOffsets(rect, view, recyclerView, state);
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
            if (linearLayoutManager.getOrientation() == 1) {
                if (recyclerView.getChildAdapterPosition(view) == 0) {
                    rect.top = this.gYk;
                } else {
                    rect.top = this.gYl;
                }
                if (recyclerView.getChildAdapterPosition(view) == linearLayoutManager.getItemCount() - 1) {
                    rect.bottom = this.mEnd;
                    return;
                }
                return;
            }
            if (recyclerView.getChildAdapterPosition(view) == 0) {
                rect.left = this.gYk;
            } else {
                rect.left = this.gYl;
            }
            if (recyclerView.getChildAdapterPosition(view) == linearLayoutManager.getItemCount() - 1) {
                rect.right = this.mEnd;
            }
        }
    }
}
