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
import com.baidu.adp.widget.ListView.i;
import com.baidu.adp.widget.ListView.k;
import com.baidu.card.n;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.concern.a.o;
/* loaded from: classes9.dex */
public class ConcernRecommendLayout extends LinearLayout implements n {
    private o gZW;
    private k gbf;
    private CustomMessageListener gbh;
    private final Context mContext;
    private RecyclerView mListView;
    private int mSkinType;
    private TextView mTitleView;

    public ConcernRecommendLayout(Context context) {
        this(context, null);
    }

    public ConcernRecommendLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.gbh = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.homepage.concern.view.ConcernRecommendLayout.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (ConcernRecommendLayout.this.gbf == null) {
                            ConcernRecommendLayout.this.gbf = new k(new i());
                        }
                        ConcernRecommendLayout.this.gbf.a(ConcernRecommendLayout.this.mListView, 1);
                    } else if (ConcernRecommendLayout.this.gbf != null) {
                        ConcernRecommendLayout.this.gbf.kB();
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
        this.mListView = (RecyclerView) findViewById(R.id.thread_card_list);
        this.gZW = new o(this.mContext);
        this.mListView.setAdapter(this.gZW);
        this.mListView.setClipChildren(false);
        if (TbSingleton.getInstance().isSlideAnimEnable()) {
            this.gbf = new k(new i());
            this.gbf.a(this.mListView, 1);
        }
        int dimens = l.getDimens(this.mContext, R.dimen.tbds44);
        int dimens2 = l.getDimens(this.mContext, R.dimen.tbds44);
        this.mListView.setLayoutManager(new LinearLayoutManager(this.mContext, 0, false));
        this.mListView.setItemAnimator(new DefaultItemAnimator());
        this.mListView.addItemDecoration(new a(dimens2, dimens, dimens2));
    }

    @Override // com.baidu.card.n
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (i != this.mSkinType) {
            am.setViewTextColor(this.mTitleView, (int) R.color.cp_cont_c);
            this.gZW.onChangeSkinType(i);
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
        this.gZW.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.gZW.setData(bVar.bNC());
        this.gZW.notifyDataSetChanged();
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.gbh.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.gbh);
        this.gZW.setPageUniqueId(bdUniqueId);
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.gZW.setPageContext(tbPageContext);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class a extends RecyclerView.ItemDecoration {
        private int gbk;
        private int gbl;
        private int mEnd;

        public a(int i, int i2, int i3) {
            this.gbk = i;
            this.gbl = i2;
            this.mEnd = i3;
        }

        @Override // android.support.v7.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            super.getItemOffsets(rect, view, recyclerView, state);
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
            if (linearLayoutManager.getOrientation() == 1) {
                if (recyclerView.getChildAdapterPosition(view) == 0) {
                    rect.top = this.gbk;
                } else {
                    rect.top = this.gbl;
                }
                if (recyclerView.getChildAdapterPosition(view) == linearLayoutManager.getItemCount() - 1) {
                    rect.bottom = this.mEnd;
                    return;
                }
                return;
            }
            if (recyclerView.getChildAdapterPosition(view) == 0) {
                rect.left = this.gbk;
            } else {
                rect.left = this.gbl;
            }
            if (recyclerView.getChildAdapterPosition(view) == linearLayoutManager.getItemCount() - 1) {
                rect.right = this.mEnd;
            }
        }
    }
}
