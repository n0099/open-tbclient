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
import com.baidu.card.p;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.a.d;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bo;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.h.f;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.concern.a.q;
/* loaded from: classes16.dex */
public class ConcernRecommendLayout extends LinearLayout implements p {
    private RecyclerView hDD;
    private n hDI;
    private CustomMessageListener hDK;
    private q iHX;
    private final Context mContext;
    private int mSkinType;
    private int mTitleColorId;
    private TextView mTitleView;

    public void setOnItemCoverListener(f<MetaData> fVar) {
        this.iHX.setOnItemCoverListener(fVar);
    }

    public ConcernRecommendLayout(Context context) {
        this(context, null);
    }

    public ConcernRecommendLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.mTitleColorId = R.color.cp_cont_c;
        this.hDK = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.homepage.concern.view.ConcernRecommendLayout.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (ConcernRecommendLayout.this.hDI == null) {
                            ConcernRecommendLayout.this.hDI = new n(new l());
                        }
                        ConcernRecommendLayout.this.hDI.a(ConcernRecommendLayout.this.hDD, 1);
                    } else if (ConcernRecommendLayout.this.hDI != null) {
                        ConcernRecommendLayout.this.hDI.rc();
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
        this.hDD = (RecyclerView) findViewById(R.id.thread_card_list);
        this.iHX = new q(this.mContext);
        this.hDD.setAdapter(this.iHX);
        this.hDD.setClipChildren(false);
        if (TbSingleton.getInstance().isSlideAnimEnable()) {
            this.hDI = new n(new l());
            this.hDI.a(this.hDD, 1);
        }
        int dimens = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds21);
        int dimens2 = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44);
        this.hDD.setLayoutManager(new LinearLayoutManager(this.mContext, 0, false));
        this.hDD.setItemAnimator(new DefaultItemAnimator());
        this.hDD.addItemDecoration(new ae(dimens2, dimens, dimens2));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hDD.getLayoutParams();
        if (d.bad()) {
            layoutParams.bottomMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds39);
        } else {
            layoutParams.bottomMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds22);
        }
        this.hDD.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.card.p
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (i != this.mSkinType) {
            ap.setViewTextColor(this.mTitleView, this.mTitleColorId);
            this.iHX.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    public void setData(bo boVar) {
        if (boVar == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        if (!TextUtils.isEmpty(boVar.title) && boVar.dZU != 0) {
            this.mTitleView.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds37));
            this.mTitleView.setText(boVar.title);
            this.mTitleView.setTypeface(Typeface.DEFAULT_BOLD);
            this.mTitleColorId = boVar.dZU;
        } else {
            this.mTitleView.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds37));
            this.mTitleView.setText(R.string.concern_recommend_title);
            this.mTitleView.setTypeface(Typeface.DEFAULT);
            this.mTitleColorId = R.color.cp_cont_b;
        }
        this.iHX.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.iHX.setData(boVar.bdR());
        this.iHX.notifyDataSetChanged();
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.hDK.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.hDK);
        this.iHX.setPageUniqueId(bdUniqueId);
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.iHX.setPageContext(tbPageContext);
    }

    public void setHasBorder(boolean z) {
        this.iHX.setHasBorder(z);
    }
}
