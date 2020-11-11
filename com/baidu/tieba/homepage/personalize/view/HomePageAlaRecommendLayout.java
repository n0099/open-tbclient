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
import java.util.List;
import tbclient.AlaLiveInfo;
/* loaded from: classes22.dex */
public class HomePageAlaRecommendLayout extends LinearLayout {
    private CustomMessageListener eNv;
    private BdRecyclerView hQz;
    private com.baidu.tieba.homepage.personalize.a.a jGQ;
    private Context mContext;
    private List<AlaLiveInfo> mData;
    private int mSkinType;

    public HomePageAlaRecommendLayout(Context context) {
        this(context, null);
    }

    public HomePageAlaRecommendLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.eNv = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.homepage.personalize.view.HomePageAlaRecommendLayout.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                UpdateAttentionMessage.a data;
                if ((customResponsedMessage instanceof UpdateAttentionMessage) && (data = ((UpdateAttentionMessage) customResponsedMessage).getData()) != null && !data.isAttention && !StringUtils.isNull(data.toUid) && HomePageAlaRecommendLayout.this.mData != null) {
                    for (AlaLiveInfo alaLiveInfo : HomePageAlaRecommendLayout.this.mData) {
                        if (alaLiveInfo != null && alaLiveInfo.user_info != null && alaLiveInfo.user_info.user_id != null && data.toUid.equals(alaLiveInfo.user_info.user_id.toString())) {
                            HomePageAlaRecommendLayout.this.mData.remove(alaLiveInfo);
                            HomePageAlaRecommendLayout.this.cLF();
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
        this.hQz = (BdRecyclerView) findViewById(R.id.ala_recommend_list);
        this.jGQ = new com.baidu.tieba.homepage.personalize.a.a(this.mContext);
        this.hQz.setAdapter(this.jGQ);
        this.hQz.setLayoutManager(new LinearLayoutManager(this.mContext, 0, false));
        this.hQz.setItemAnimator(new DefaultItemAnimator());
        int dimens = l.getDimens(this.mContext, R.dimen.tbds20);
        this.hQz.addItemDecoration(new a(dimens, 0, dimens));
        this.hQz.setPadding(this.hQz.getLeft(), this.hQz.getTop(), this.hQz.getRight(), l.getDimens(this.hQz.getContext(), com.baidu.tbadk.a.b.a.aL(R.dimen.tbds0, R.dimen.tbds51)));
    }

    public void setData(com.baidu.tieba.homepage.personalize.data.f fVar) {
        if (fVar == null || y.isEmpty(fVar.cLt())) {
            setVisibility(8);
            return;
        }
        this.mData = fVar.cLt();
        setVisibility(0);
        cLF();
    }

    public void cLF() {
        if (y.isEmpty(this.mData)) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.jGQ.setData(this.mData);
        this.jGQ.notifyDataSetChanged();
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        MessageManager.getInstance().registerListener(this.eNv);
        super.onAttachedToWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        MessageManager.getInstance().unRegisterListener(this.eNv);
        super.onDetachedFromWindow();
    }
}
