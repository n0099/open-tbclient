package com.baidu.tieba.ala.alasquare.special_forum.subtab;

import android.os.Bundle;
import android.os.Handler;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.BaseFragment;
/* loaded from: classes4.dex */
public abstract class SpecialForumTabBaseFragment extends BaseFragment {

    /* renamed from: e  reason: collision with root package name */
    public Handler f14569e = new Handler();

    /* renamed from: f  reason: collision with root package name */
    public Runnable f14570f = new a();

    /* renamed from: g  reason: collision with root package name */
    public CustomMessageListener f14571g = new b(2921414);

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SpecialForumTabBaseFragment.this.G0();
        }
    }

    /* loaded from: classes4.dex */
    public class b extends CustomMessageListener {
        public b(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            SpecialForumTabBaseFragment.this.f14569e.removeCallbacks(SpecialForumTabBaseFragment.this.f14570f);
            SpecialForumTabBaseFragment.this.f14569e.postDelayed(SpecialForumTabBaseFragment.this.f14570f, 500L);
        }
    }

    public void E() {
    }

    public abstract void G0();

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        MessageManager.getInstance().registerListener(this.f14571g);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterListener(this.f14571g);
    }
}
