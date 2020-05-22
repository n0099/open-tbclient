package com.baidu.tieba.ala.alasquare.special_forum.subtab;

import android.os.Bundle;
import android.os.Handler;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.BaseFragment;
/* loaded from: classes3.dex */
public abstract class SpecialForumTabBaseFragment extends BaseFragment {
    private Handler mHandler = new Handler();
    private Runnable fhR = new Runnable() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment.1
        @Override // java.lang.Runnable
        public void run() {
            SpecialForumTabBaseFragment.this.notifyDataSetChanged();
        }
    };
    private CustomMessageListener dzH = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            SpecialForumTabBaseFragment.this.mHandler.removeCallbacks(SpecialForumTabBaseFragment.this.fhR);
            SpecialForumTabBaseFragment.this.mHandler.postDelayed(SpecialForumTabBaseFragment.this.fhR, 500L);
        }
    };

    protected abstract void notifyDataSetChanged();

    public void brJ() {
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        MessageManager.getInstance().registerListener(this.dzH);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterListener(this.dzH);
    }
}
