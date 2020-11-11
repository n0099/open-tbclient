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
import com.baidu.tbadk.core.data.bo;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.h.f;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.concern.adapter.s;
/* loaded from: classes22.dex */
public class ConcernRecommendLayout extends LinearLayout implements q {
    private RecyclerView isf;
    private n isk;
    private CustomMessageListener ism;
    private s jxK;
    private final Context mContext;
    private int mSkinType;
    private int mTitleColorId;
    private TextView mTitleView;

    public void setOnItemCoverListener(f<MetaData> fVar) {
        this.jxK.setOnItemCoverListener(fVar);
    }

    public ConcernRecommendLayout(Context context) {
        this(context, null);
    }

    public ConcernRecommendLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.mTitleColorId = R.color.cp_cont_c;
        this.ism = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.homepage.concern.view.ConcernRecommendLayout.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (ConcernRecommendLayout.this.isk == null) {
                            ConcernRecommendLayout.this.isk = new n(new l());
                        }
                        ConcernRecommendLayout.this.isk.a(ConcernRecommendLayout.this.isf, 1);
                    } else if (ConcernRecommendLayout.this.isk != null) {
                        ConcernRecommendLayout.this.isk.rh();
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
        this.isf = (RecyclerView) findViewById(R.id.thread_card_list);
        this.jxK = new s(this.mContext);
        this.isf.setAdapter(this.jxK);
        this.isf.setClipChildren(false);
        if (TbSingleton.getInstance().isSlideAnimEnable()) {
            this.isk = new n(new l());
            this.isk.a(this.isf, 1);
        }
        int dimens = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds21);
        int dimens2 = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44);
        this.isf.setLayoutManager(new LinearLayoutManager(this.mContext, 0, false));
        this.isf.setItemAnimator(new DefaultItemAnimator());
        this.isf.addItemDecoration(new ae(dimens2, dimens, dimens2));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.isf.getLayoutParams();
        if (d.bhU()) {
            layoutParams.bottomMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds39);
        } else {
            layoutParams.bottomMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds22);
        }
        this.isf.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (i != this.mSkinType) {
            ap.setViewTextColor(this.mTitleView, this.mTitleColorId);
            this.jxK.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    public void setData(bo boVar) {
        if (boVar == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        if (!TextUtils.isEmpty(boVar.title) && boVar.eCC != 0) {
            this.mTitleView.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds37));
            this.mTitleView.setText(boVar.title);
            this.mTitleView.setTypeface(Typeface.DEFAULT_BOLD);
            this.mTitleColorId = boVar.eCC;
        } else {
            this.mTitleView.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds37));
            this.mTitleView.setText(R.string.concern_recommend_title);
            this.mTitleView.setTypeface(Typeface.DEFAULT);
            this.mTitleColorId = R.color.cp_cont_b;
        }
        this.jxK.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.jxK.setData(boVar.blN());
        this.jxK.notifyDataSetChanged();
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.ism.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.ism);
        this.jxK.setPageUniqueId(bdUniqueId);
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.jxK.setPageContext(tbPageContext);
    }

    public void setHasBorder(boolean z) {
        this.jxK.setHasBorder(z);
    }
}
