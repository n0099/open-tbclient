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
    public c auf() {
        c cVar = new c();
        cVar.cyG = new DiscoverFragment();
        cVar.type = 10;
        cVar.bXX = R.string.home_discover;
        cVar.bXY = R.drawable.s_icon_tabbar_discover;
        return cVar;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public TbFragmentTabIndicator cP(Context context) {
        this.cys = (FragmentTabIndicator) LayoutInflater.from(context).inflate(R.layout.fragmenttabindicator, (ViewGroup) null);
        TbFragmentTabIndicator.a aVar = new TbFragmentTabIndicator.a();
        aVar.czd = this.cys;
        aVar.zQ = l.dip2px(context, 3.0f);
        aVar.czb = R.drawable.icon_news_down_bar_one;
        this.cys.a("emotion", aVar);
        return this.cys;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void aue() {
        isAdded = true;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void fv() {
    }
}
