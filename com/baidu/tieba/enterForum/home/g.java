package com.baidu.tieba.enterForum.home;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends CustomMessageListener {
    final /* synthetic */ e bGG;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(e eVar, int i) {
        super(i);
        this.bGG = eVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        boolean z;
        FragmentTabWidget fragmentTabWidget;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001378) {
            z = this.bGG.bGx;
            if (!z) {
                int i = com.baidu.tbadk.core.sharedPref.b.tS().getInt("wefan_switch", 0);
                String string = com.baidu.tbadk.core.sharedPref.b.tS().getString("wefan_tab_name", "");
                String string2 = com.baidu.tbadk.core.sharedPref.b.tS().getString("wefan_url", "");
                if (i == 1 && !StringUtils.isNull(string) && !StringUtils.isNull(string2)) {
                    this.bGG.bGx = true;
                    FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(this.bGG.getBaseFragmentActivity().getPageContext().getPageActivity());
                    fragmentTabIndicator.setTextSize(0, this.bGG.getResources().getDimension(t.e.ds28));
                    fragmentTabIndicator.setTag(3);
                    fragmentTabIndicator.setGravity(17);
                    fragmentTabIndicator.azx = t.d.s_actionbar_text_color;
                    fragmentTabIndicator.setText(string);
                    fragmentTabWidget = this.bGG.bGB;
                    fragmentTabWidget.addView(fragmentTabIndicator);
                }
            }
        }
    }
}
