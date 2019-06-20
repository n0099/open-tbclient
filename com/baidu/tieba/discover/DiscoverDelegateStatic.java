package com.baidu.tieba.discover;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tbadk.mainTab.b;
import com.baidu.tbadk.mainTab.c;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class DiscoverDelegateStatic extends b {
    private static boolean isAdded = false;

    static {
        if (!isAdded) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007013));
        }
        CustomMessageTask customMessageTask = new CustomMessageTask(2921010, new CustomMessageTask.CustomRunnable<BaseFragment>() { // from class: com.baidu.tieba.discover.DiscoverDelegateStatic.1
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.CustomMessage] */
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<BaseFragment> run(CustomMessage<BaseFragment> customMessage) {
                return new CustomResponsedMessage<>(2921010, new DiscoverFragment());
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    @Override // com.baidu.tbadk.mainTab.b
    public boolean isAvailable() {
        return true;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public c asJ() {
        c cVar = new c();
        cVar.cwo = new DiscoverFragment();
        cVar.type = 10;
        cVar.bVW = R.string.home_discover;
        cVar.bVX = R.drawable.s_icon_tabbar_discover;
        return cVar;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public TbFragmentTabIndicator cO(Context context) {
        this.cwa = (FragmentTabIndicator) LayoutInflater.from(context).inflate(R.layout.fragmenttabindicator, (ViewGroup) null);
        TbFragmentTabIndicator.a aVar = new TbFragmentTabIndicator.a();
        aVar.cwL = this.cwa;
        aVar.zK = l.dip2px(context, 3.0f);
        aVar.cwJ = R.drawable.icon_news_down_bar_one;
        this.cwa.a("emotion", aVar);
        return this.cwa;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void asI() {
        isAdded = true;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void fn() {
    }
}
