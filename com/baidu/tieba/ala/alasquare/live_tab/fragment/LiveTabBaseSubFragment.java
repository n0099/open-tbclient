package com.baidu.tieba.ala.alasquare.live_tab.fragment;

import android.content.Context;
import android.widget.LinearLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.l.h;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public abstract class LiveTabBaseSubFragment extends BaseFragment {
    protected String fOD;
    protected LinearLayout gCZ;
    private h gDa;
    protected String gDc;
    protected Context mContext;
    public final String gCY = "c13008";
    protected boolean gCv = false;
    protected boolean gDb = false;
    protected CustomMessageListener gDd = new CustomMessageListener(2921442) { // from class: com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Boolean bool = (Boolean) customResponsedMessage.getData();
            if (bool != null && bool.booleanValue()) {
                LiveTabBaseSubFragment.this.gDb = false;
            }
        }
    };

    public abstract void Uw();

    public abstract void bRN();

    public abstract void loadData();

    /* JADX INFO: Access modifiers changed from: protected */
    public void bRL() {
        this.gCZ.setVisibility(0);
        if (this.gDa == null) {
            this.gDa = new h(this.mContext, null);
        }
        this.gDa.hideRefreshButton();
        this.gDa.ro(R.drawable.new_pic_emotion_03);
        this.gDa.Dr(this.mContext.getResources().getString(R.string.no_data_common_txt));
        this.gDa.onChangeSkinType();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        if (this.gDa.getAttachedView() != null && this.gDa.getAttachedView().getParent() == null) {
            this.gCZ.addView(this.gDa.getAttachedView(), layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void hideEmptyView() {
        this.gCZ.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bRM() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921441, false));
        this.gDb = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.gDa != null) {
            this.gDa.onChangeSkinType();
        }
    }

    public void eg(String str, String str2) {
        this.fOD = str;
        this.gDc = str2;
    }

    public boolean blw() {
        return (au.isEmpty(this.fOD) || au.isEmpty(this.gDc)) ? false : true;
    }
}
