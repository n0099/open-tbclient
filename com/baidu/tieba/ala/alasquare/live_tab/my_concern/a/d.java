package com.baidu.tieba.ala.alasquare.live_tab.my_concern.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.ala.AlaSharedPrefConfig;
import com.baidu.ala.AlaSharedPrefHelper;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.live_tab.my_concern.view.LiveTabConcernNotificationViewHolder;
import com.baidu.tieba.card.aa;
/* loaded from: classes9.dex */
public class d extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.a, LiveTabConcernNotificationViewHolder> {
    private boolean gzA;
    private aa<com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.a> gzB;
    private TbPageContext mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public d(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.a.gzF);
        this.gzA = false;
        this.gzB = new aa<com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.a>() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.a.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            public void a(View view, com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.a aVar) {
                if (view.getId() == R.id.id_tab_live_sub_notification_close_btn) {
                    if (!d.this.gzA) {
                        d.this.gzA = true;
                        AlaSharedPrefHelper.getInstance().putLong(AlaSharedPrefConfig.ALA_LIVE_TAB_NOTIFICATION_CLOSE_LAST_TIME, System.currentTimeMillis());
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921421));
                    }
                } else if (view.getId() == R.id.id_tab_live_sub_notification_close_go_to_open) {
                    com.baidu.tieba.ala.alasquare.live_tab.my_concern.b.a.n(d.this.mPageContext);
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ab */
    public LiveTabConcernNotificationViewHolder e(ViewGroup viewGroup) {
        com.baidu.tieba.ala.alasquare.live_tab.my_concern.view.e eVar = new com.baidu.tieba.ala.alasquare.live_tab.my_concern.view.e(this.mPageContext, viewGroup);
        eVar.c(this.gzB);
        return new LiveTabConcernNotificationViewHolder(eVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.a aVar, LiveTabConcernNotificationViewHolder liveTabConcernNotificationViewHolder) {
        if (liveTabConcernNotificationViewHolder == null || liveTabConcernNotificationViewHolder.gAB == null) {
            return null;
        }
        this.gzA = false;
        liveTabConcernNotificationViewHolder.gAB.a(aVar);
        return liveTabConcernNotificationViewHolder.getView();
    }
}
