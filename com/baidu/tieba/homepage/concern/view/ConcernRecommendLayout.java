package com.baidu.tieba.homepage.concern.view;

import android.content.Context;
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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bm;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.h.f;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.concern.a.q;
/* loaded from: classes9.dex */
public class ConcernRecommendLayout extends LinearLayout implements o {
    private RecyclerView hlb;
    private n hlg;
    private CustomMessageListener hli;
    private q inE;
    private final Context mContext;
    private int mSkinType;
    private int mTitleColorId;
    private TextView mTitleView;

    public void setOnItemCoverListener(f<MetaData> fVar) {
        this.inE.setOnItemCoverListener(fVar);
    }

    public ConcernRecommendLayout(Context context) {
        this(context, null);
    }

    public ConcernRecommendLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.mTitleColorId = R.color.cp_cont_c;
        this.hli = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.homepage.concern.view.ConcernRecommendLayout.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (ConcernRecommendLayout.this.hlg == null) {
                            ConcernRecommendLayout.this.hlg = new n(new l());
                        }
                        ConcernRecommendLayout.this.hlg.a(ConcernRecommendLayout.this.hlb, 1);
                    } else if (ConcernRecommendLayout.this.hlg != null) {
                        ConcernRecommendLayout.this.hlg.pC();
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
        this.hlb = (RecyclerView) findViewById(R.id.thread_card_list);
        this.inE = new q(this.mContext);
        this.hlb.setAdapter(this.inE);
        this.hlb.setClipChildren(false);
        if (TbSingleton.getInstance().isSlideAnimEnable()) {
            this.hlg = new n(new l());
            this.hlg.a(this.hlb, 1);
        }
        int dimens = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44);
        int dimens2 = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44);
        this.hlb.setLayoutManager(new LinearLayoutManager(this.mContext, 0, false));
        this.hlb.setItemAnimator(new DefaultItemAnimator());
        this.hlb.addItemDecoration(new ac(dimens2, dimens, dimens2));
    }

    @Override // com.baidu.card.o
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (i != this.mSkinType) {
            an.setViewTextColor(this.mTitleView, this.mTitleColorId);
            this.inE.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    public void setData(bm bmVar) {
        if (bmVar == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        if (!TextUtils.isEmpty(bmVar.title) && bmVar.dKp != 0) {
            this.mTitleView.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds37));
            this.mTitleView.setText(bmVar.title);
            this.mTitleColorId = bmVar.dKp;
        } else {
            this.mTitleView.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds37));
            this.mTitleView.setText(R.string.concern_recommend_title);
            this.mTitleColorId = R.color.cp_cont_c;
        }
        this.inE.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.inE.setData(bmVar.aRC());
        this.inE.notifyDataSetChanged();
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.hli.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.hli);
        this.inE.setPageUniqueId(bdUniqueId);
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.inE.setPageContext(tbPageContext);
    }
}
