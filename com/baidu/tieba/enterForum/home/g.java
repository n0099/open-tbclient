package com.baidu.tieba.enterForum.home;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends CustomMessageListener {
    final /* synthetic */ f bxz;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(f fVar, int i) {
        super(i);
        this.bxz = fVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        boolean z;
        FragmentTabWidget fragmentTabWidget;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001371) {
            if (com.baidu.tieba.enterForum.model.f.UZ()) {
                com.baidu.tieba.enterForum.model.f.Va();
            }
            z = this.bxz.bxr;
            if (!z) {
                int i = com.baidu.tbadk.core.sharedPref.b.tQ().getInt("wefan_switch", 0);
                String string = com.baidu.tbadk.core.sharedPref.b.tQ().getString("wefan_tab_name", "");
                String string2 = com.baidu.tbadk.core.sharedPref.b.tQ().getString("wefan_url", "");
                if (i == 1 && !StringUtils.isNull(string) && !StringUtils.isNull(string2)) {
                    this.bxz.bxr = true;
                    FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(this.bxz.getBaseFragmentActivity().getPageContext().getPageActivity());
                    fragmentTabIndicator.setTextSize(0, this.bxz.getResources().getDimension(r.f.ds28));
                    fragmentTabIndicator.setTag(1);
                    fragmentTabIndicator.setGravity(17);
                    fragmentTabIndicator.ayk = r.e.s_actionbar_text_color;
                    fragmentTabIndicator.setText(string);
                    fragmentTabWidget = this.bxz.bxw;
                    fragmentTabWidget.addView(fragmentTabIndicator);
                }
            }
        }
    }
}
