package com.baidu.tieba.ala.alasquare.live_tab.my_concern.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.ala.AlaSharedPrefConfig;
import com.baidu.ala.AlaSharedPrefHelper;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.h;
import com.baidu.tieba.card.ab;
/* loaded from: classes6.dex */
public class d extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.a, h> {
    private boolean dxb;
    private ab<com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.a> dxc;
    private TbPageContext mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public d(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.a.dxg);
        this.dxb = false;
        this.dxc = new ab<com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.a>() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.a.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.a aVar) {
                if (view.getId() == R.id.id_tab_live_sub_notification_close_btn) {
                    if (!d.this.dxb) {
                        d.this.dxb = true;
                        AlaSharedPrefHelper.getInstance().putLong(AlaSharedPrefConfig.ALA_LIVE_TAB_NOTIFICATION_CLOSE_LAST_TIME, System.currentTimeMillis());
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921420));
                    }
                } else if (view.getId() == R.id.id_tab_live_sub_notification_close_go_to_open) {
                    com.baidu.tieba.ala.alasquare.live_tab.my_concern.b.a.i(d.this.mPageContext);
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: A */
    public h b(ViewGroup viewGroup) {
        com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.g gVar = new com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.g(this.mPageContext, viewGroup);
        gVar.d(this.dxc);
        return new h(gVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.a aVar, h hVar) {
        if (hVar == null || hVar.dyd == null) {
            return null;
        }
        this.dxb = false;
        hVar.dyd.a(aVar);
        return hVar.getView();
    }
}
