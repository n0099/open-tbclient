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
import com.baidu.adp.widget.ListView.j;
import com.baidu.adp.widget.ListView.l;
import com.baidu.card.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.a.d;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.br;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.h.f;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.concern.adapter.ConcernRecommendListAdapter;
/* loaded from: classes2.dex */
public class ConcernRecommendLayout extends LinearLayout implements q {
    private int amY;
    private RecyclerView iPZ;
    private l iQe;
    private CustomMessageListener iQg;
    private ConcernRecommendListAdapter jZt;
    private final Context mContext;
    private int mSkinType;
    private TextView mTitleView;

    public void setOnItemCoverListener(f<MetaData> fVar) {
        this.jZt.setOnItemCoverListener(fVar);
    }

    public ConcernRecommendLayout(Context context) {
        this(context, null);
    }

    public ConcernRecommendLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.amY = R.color.CAM_X0108;
        this.iQg = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.homepage.concern.view.ConcernRecommendLayout.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (ConcernRecommendLayout.this.iQe == null) {
                            ConcernRecommendLayout.this.iQe = new l(new j());
                        }
                        ConcernRecommendLayout.this.iQe.a(ConcernRecommendLayout.this.iPZ, 1);
                    } else if (ConcernRecommendLayout.this.iQe != null) {
                        ConcernRecommendLayout.this.iQe.qL();
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
        this.iPZ = (RecyclerView) findViewById(R.id.thread_card_list);
        this.jZt = new ConcernRecommendListAdapter(this.mContext);
        this.iPZ.setAdapter(this.jZt);
        this.iPZ.setClipChildren(false);
        if (TbSingleton.getInstance().isSlideAnimEnable()) {
            this.iQe = new l(new j());
            this.iQe.a(this.iPZ, 1);
        }
        int dimens = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds21);
        int dimens2 = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44);
        this.iPZ.setLayoutManager(new LinearLayoutManager(this.mContext, 0, false));
        this.iPZ.setItemAnimator(new DefaultItemAnimator());
        this.iPZ.addItemDecoration(new SpaceItemDecoration(dimens2, dimens, dimens2));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.iPZ.getLayoutParams();
        if (d.bmF()) {
            layoutParams.bottomMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds39);
        } else {
            layoutParams.bottomMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds22);
        }
        this.iPZ.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (i != this.mSkinType) {
            ao.setViewTextColor(this.mTitleView, this.amY);
            this.jZt.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    public void setData(br brVar) {
        if (brVar == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        if (!TextUtils.isEmpty(brVar.title) && brVar.eRL != 0) {
            this.mTitleView.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds37));
            this.mTitleView.setText(brVar.title);
            this.mTitleView.setTypeface(Typeface.DEFAULT_BOLD);
            this.amY = brVar.eRL;
        } else {
            this.mTitleView.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds37));
            this.mTitleView.setText(R.string.concern_recommend_title);
            this.mTitleView.setTypeface(Typeface.DEFAULT_BOLD);
            this.amY = R.color.CAM_X0105;
        }
        this.jZt.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.jZt.setData(brVar.bqE());
        this.jZt.notifyDataSetChanged();
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.iQg.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.iQg);
        this.jZt.setPageUniqueId(bdUniqueId);
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.jZt.setPageContext(tbPageContext);
    }

    public void setHasBorder(boolean z) {
        this.jZt.setHasBorder(z);
    }
}
