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
import com.baidu.adp.widget.ListView.ae;
import com.baidu.adp.widget.ListView.l;
import com.baidu.adp.widget.ListView.n;
import com.baidu.card.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.a.d;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bq;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.h.f;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.concern.adapter.t;
/* loaded from: classes22.dex */
public class ConcernRecommendLayout extends LinearLayout implements q {
    private RecyclerView iDN;
    private n iDS;
    private CustomMessageListener iDU;
    private t jMf;
    private final Context mContext;
    private int mSkinType;
    private int mTitleColorId;
    private TextView mTitleView;

    public void setOnItemCoverListener(f<MetaData> fVar) {
        this.jMf.setOnItemCoverListener(fVar);
    }

    public ConcernRecommendLayout(Context context) {
        this(context, null);
    }

    public ConcernRecommendLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.mTitleColorId = R.color.CAM_X0108;
        this.iDU = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.homepage.concern.view.ConcernRecommendLayout.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (ConcernRecommendLayout.this.iDS == null) {
                            ConcernRecommendLayout.this.iDS = new n(new l());
                        }
                        ConcernRecommendLayout.this.iDS.a(ConcernRecommendLayout.this.iDN, 1);
                    } else if (ConcernRecommendLayout.this.iDS != null) {
                        ConcernRecommendLayout.this.iDS.rj();
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
        this.iDN = (RecyclerView) findViewById(R.id.thread_card_list);
        this.jMf = new t(this.mContext);
        this.iDN.setAdapter(this.jMf);
        this.iDN.setClipChildren(false);
        if (TbSingleton.getInstance().isSlideAnimEnable()) {
            this.iDS = new n(new l());
            this.iDS.a(this.iDN, 1);
        }
        int dimens = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds21);
        int dimens2 = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44);
        if (d.bkA()) {
            this.mTitleView.setPadding(0, 0, 0, 0);
            dimens2 = 0;
        }
        this.iDN.setLayoutManager(new LinearLayoutManager(this.mContext, 0, false));
        this.iDN.setItemAnimator(new DefaultItemAnimator());
        this.iDN.addItemDecoration(new ae(dimens2, dimens, dimens2));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.iDN.getLayoutParams();
        if (d.bkq()) {
            layoutParams.bottomMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds39);
        } else {
            layoutParams.bottomMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds22);
        }
        this.iDN.setLayoutParams(layoutParams);
        d.e(this, false);
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (i != this.mSkinType) {
            ap.setViewTextColor(this.mTitleView, this.mTitleColorId);
            this.jMf.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    public void setData(bq bqVar) {
        if (bqVar == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        if (!TextUtils.isEmpty(bqVar.title) && bqVar.eHT != 0) {
            this.mTitleView.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds37));
            this.mTitleView.setText(bqVar.title);
            this.mTitleView.setTypeface(Typeface.DEFAULT_BOLD);
            this.mTitleColorId = bqVar.eHT;
        } else {
            this.mTitleView.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds37));
            this.mTitleView.setText(R.string.concern_recommend_title);
            this.mTitleView.setTypeface(Typeface.DEFAULT_BOLD);
            this.mTitleColorId = R.color.CAM_X0105;
        }
        this.jMf.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.jMf.setData(bqVar.boc());
        this.jMf.notifyDataSetChanged();
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.iDU.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.iDU);
        this.jMf.setPageUniqueId(bdUniqueId);
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.jMf.setPageContext(tbPageContext);
    }

    public void setHasBorder(boolean z) {
        this.jMf.setHasBorder(z);
    }
}
