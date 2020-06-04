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
    private RecyclerView gYl;
    private m gYq;
    private CustomMessageListener gYs;
    private com.baidu.tieba.homepage.concern.a.o hZc;
    private final Context mContext;
    private int mSkinType;
    private TextView mTitleView;

    public ConcernRecommendLayout(Context context) {
        this(context, null);
    }

    public ConcernRecommendLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.gYs = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.homepage.concern.view.ConcernRecommendLayout.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (ConcernRecommendLayout.this.gYq == null) {
                            ConcernRecommendLayout.this.gYq = new m(new k());
                        }
                        ConcernRecommendLayout.this.gYq.a(ConcernRecommendLayout.this.gYl, 1);
                    } else if (ConcernRecommendLayout.this.gYq != null) {
                        ConcernRecommendLayout.this.gYq.pl();
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
        this.gYl = (RecyclerView) findViewById(R.id.thread_card_list);
        this.hZc = new com.baidu.tieba.homepage.concern.a.o(this.mContext);
        this.gYl.setAdapter(this.hZc);
        this.gYl.setClipChildren(false);
        if (TbSingleton.getInstance().isSlideAnimEnable()) {
            this.gYq = new m(new k());
            this.gYq.a(this.gYl, 1);
        }
        int dimens = l.getDimens(this.mContext, R.dimen.tbds44);
        int dimens2 = l.getDimens(this.mContext, R.dimen.tbds44);
        this.gYl.setLayoutManager(new LinearLayoutManager(this.mContext, 0, false));
        this.gYl.setItemAnimator(new DefaultItemAnimator());
        this.gYl.addItemDecoration(new a(dimens2, dimens, dimens2));
    }

    @Override // com.baidu.card.o
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (i != this.mSkinType) {
            am.setViewTextColor(this.mTitleView, (int) R.color.cp_cont_c);
            this.hZc.onChangeSkinType(i);
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
        this.hZc.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.hZc.setData(bVar.ceI());
        this.hZc.notifyDataSetChanged();
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.gYs.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.gYs);
        this.hZc.setPageUniqueId(bdUniqueId);
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.hZc.setPageContext(tbPageContext);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class a extends RecyclerView.ItemDecoration {
        private int gYv;
        private int gYw;
        private int mEnd;

        public a(int i, int i2, int i3) {
            this.gYv = i;
            this.gYw = i2;
            this.mEnd = i3;
        }

        @Override // android.support.v7.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            super.getItemOffsets(rect, view, recyclerView, state);
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
            if (linearLayoutManager.getOrientation() == 1) {
                if (recyclerView.getChildAdapterPosition(view) == 0) {
                    rect.top = this.gYv;
                } else {
                    rect.top = this.gYw;
                }
                if (recyclerView.getChildAdapterPosition(view) == linearLayoutManager.getItemCount() - 1) {
                    rect.bottom = this.mEnd;
                    return;
                }
                return;
            }
            if (recyclerView.getChildAdapterPosition(view) == 0) {
                rect.left = this.gYv;
            } else {
                rect.left = this.gYw;
            }
            if (recyclerView.getChildAdapterPosition(view) == linearLayoutManager.getItemCount() - 1) {
                rect.right = this.mEnd;
            }
        }
    }
}
