package com.baidu.tieba.homepage.personalize.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.personalize.data.f;
import java.util.List;
import tbclient.AlaLiveInfo;
/* loaded from: classes22.dex */
public class HomePageAlaRecommendLayout extends LinearLayout {
    private CustomMessageListener eTG;
    private BdRecyclerView ibV;
    private com.baidu.tieba.homepage.personalize.a.a jVu;
    private Context mContext;
    private List<AlaLiveInfo> mData;
    private int mSkinType;

    public HomePageAlaRecommendLayout(Context context) {
        this(context, null);
    }

    public HomePageAlaRecommendLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.eTG = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.homepage.personalize.view.HomePageAlaRecommendLayout.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                UpdateAttentionMessage.a data;
                if ((customResponsedMessage instanceof UpdateAttentionMessage) && (data = ((UpdateAttentionMessage) customResponsedMessage).getData()) != null && !data.isAttention && !StringUtils.isNull(data.toUid) && HomePageAlaRecommendLayout.this.mData != null) {
                    for (AlaLiveInfo alaLiveInfo : HomePageAlaRecommendLayout.this.mData) {
                        if (alaLiveInfo != null && alaLiveInfo.user_info != null && alaLiveInfo.user_info.user_id != null && data.toUid.equals(alaLiveInfo.user_info.user_id.toString())) {
                            HomePageAlaRecommendLayout.this.mData.remove(alaLiveInfo);
                            HomePageAlaRecommendLayout.this.cQA();
                            return;
                        }
                    }
                }
            }
        };
        this.mContext = context;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.home_page_ala_recommend_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.ibV = (BdRecyclerView) findViewById(R.id.ala_recommend_list);
        this.jVu = new com.baidu.tieba.homepage.personalize.a.a(this.mContext);
        this.ibV.setAdapter(this.jVu);
        this.ibV.setLayoutManager(new LinearLayoutManager(this.mContext, 0, false));
        this.ibV.setItemAnimator(new DefaultItemAnimator());
        int dimens = l.getDimens(this.mContext, R.dimen.tbds20);
        this.ibV.addItemDecoration(new a(dimens, 0, dimens));
        this.ibV.setPadding(this.ibV.getPaddingLeft(), this.ibV.getPaddingTop(), this.ibV.getPaddingRight(), l.getDimens(this.ibV.getContext(), com.baidu.tbadk.a.b.a.aN(R.dimen.tbds0, R.dimen.tbds51)));
    }

    public void setData(f fVar) {
        if (fVar == null || y.isEmpty(fVar.cQo())) {
            setVisibility(8);
            return;
        }
        this.mData = fVar.cQo();
        setVisibility(0);
        cQA();
    }

    public void cQA() {
        if (y.isEmpty(this.mData)) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.jVu.setData(this.mData);
        this.jVu.notifyDataSetChanged();
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        MessageManager.getInstance().registerListener(this.eTG);
        super.onAttachedToWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        MessageManager.getInstance().unRegisterListener(this.eTG);
        super.onDetachedFromWindow();
    }
}
