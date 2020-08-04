package com.baidu.tieba.homepage.concern.view;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.ac;
import com.baidu.adp.widget.ListView.l;
import com.baidu.adp.widget.ListView.n;
import com.baidu.card.o;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.a.d;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bn;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.h.f;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.concern.a.q;
/* loaded from: classes16.dex */
public class ConcernRecommendLayout extends LinearLayout implements o {
    private RecyclerView hqM;
    private n hqR;
    private CustomMessageListener hqT;
    private q itI;
    private final Context mContext;
    private int mSkinType;
    private int mTitleColorId;
    private TextView mTitleView;

    public void setOnItemCoverListener(f<MetaData> fVar) {
        this.itI.setOnItemCoverListener(fVar);
    }

    public ConcernRecommendLayout(Context context) {
        this(context, null);
    }

    public ConcernRecommendLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.mTitleColorId = R.color.cp_cont_c;
        this.hqT = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.homepage.concern.view.ConcernRecommendLayout.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (ConcernRecommendLayout.this.hqR == null) {
                            ConcernRecommendLayout.this.hqR = new n(new l());
                        }
                        ConcernRecommendLayout.this.hqR.a(ConcernRecommendLayout.this.hqM, 1);
                    } else if (ConcernRecommendLayout.this.hqR != null) {
                        ConcernRecommendLayout.this.hqR.pD();
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
        this.hqM = (RecyclerView) findViewById(R.id.thread_card_list);
        this.itI = new q(this.mContext);
        this.hqM.setAdapter(this.itI);
        this.hqM.setClipChildren(false);
        if (TbSingleton.getInstance().isSlideAnimEnable()) {
            this.hqR = new n(new l());
            this.hqR.a(this.hqM, 1);
        }
        int dimens = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds21);
        int dimens2 = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44);
        this.hqM.setLayoutManager(new LinearLayoutManager(this.mContext, 0, false));
        this.hqM.setItemAnimator(new DefaultItemAnimator());
        this.hqM.addItemDecoration(new ac(dimens2, dimens, dimens2));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hqM.getLayoutParams();
        if (d.aRL()) {
            layoutParams.bottomMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds39);
        } else {
            layoutParams.bottomMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds22);
        }
        this.hqM.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.card.o
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (i != this.mSkinType) {
            ao.setViewTextColor(this.mTitleView, this.mTitleColorId);
            this.itI.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    public void setData(bn bnVar) {
        if (bnVar == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        if (!TextUtils.isEmpty(bnVar.title) && bnVar.dQB != 0) {
            this.mTitleView.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds37));
            this.mTitleView.setText(bnVar.title);
            this.mTitleView.setTypeface(Typeface.DEFAULT_BOLD);
            this.mTitleColorId = bnVar.dQB;
        } else {
            this.mTitleView.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds37));
            this.mTitleView.setText(R.string.concern_recommend_title);
            this.mTitleView.setTypeface(Typeface.DEFAULT);
            this.mTitleColorId = R.color.cp_cont_b;
        }
        this.itI.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.itI.setData(bnVar.aVy());
        this.itI.notifyDataSetChanged();
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.hqT.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.hqT);
        this.itI.setPageUniqueId(bdUniqueId);
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.itI.setPageContext(tbPageContext);
    }

    public void setHasBorder(boolean z) {
        this.itI.setHasBorder(z);
    }
}
