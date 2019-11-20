package com.baidu.tieba.ala.live.personcenter.admin.c;

import android.os.Bundle;
import android.view.View;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.k.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.dialog.BdAlertDialog;
import com.baidu.live.tbadk.core.view.TbListCommonPullView;
import com.baidu.tieba.ala.live.personcenter.admin.c.b;
/* loaded from: classes6.dex */
public class a {
    private b dQb;
    private c dQc;
    private com.baidu.live.g.b dQd;
    private CustomMessageListener dQe = new CustomMessageListener(2913050, true) { // from class: com.baidu.tieba.ala.live.personcenter.admin.c.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof com.baidu.tieba.ala.live.personcenter.admin.b.b) {
                final com.baidu.tieba.ala.live.personcenter.admin.b.b bVar = (com.baidu.tieba.ala.live.personcenter.admin.b.b) customResponsedMessage.getData();
                BdAlertDialog bdAlertDialog = new BdAlertDialog(a.this.getPageContext().getPageActivity());
                bdAlertDialog.setTitle(a.i.sdk_prc_person_adminlist_manage_title);
                bdAlertDialog.setMessageId(a.i.sdk_prc_person_adminlist_manage_content);
                bdAlertDialog.setNegativeButton(a.i.sdk_cancel, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.live.personcenter.admin.c.a.1.1
                    @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                    public void onClick(BdAlertDialog bdAlertDialog2) {
                        bdAlertDialog2.dismiss();
                    }
                });
                bdAlertDialog.setPositiveButton(a.i.sdk_confirm, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.live.personcenter.admin.c.a.1.2
                    @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                    public void onClick(BdAlertDialog bdAlertDialog2) {
                        bdAlertDialog2.dismiss();
                        a.this.dQd.P(bVar.getUserId(), a.this.mLiveId);
                        a.this.dQb.a(bVar);
                    }
                });
                bdAlertDialog.create(a.this.getPageContext());
                bdAlertDialog.show();
            }
        }
    };
    private b.a dQf = new b.a() { // from class: com.baidu.tieba.ala.live.personcenter.admin.c.a.2
        @Override // com.baidu.tieba.ala.live.personcenter.admin.c.b.a
        public void gI(boolean z) {
            a.this.dQc.completePullRefresh();
            a.this.dQc.hideNoDataView();
            if (a.this.dQb.getUserList().size() == 0) {
                a.this.dQc.aLp();
                a.this.dQc.aMp();
                a.this.dQc.showNoDataView();
                return;
            }
            a.this.dQc.aJm();
            a.this.dQc.aMo();
            a.this.dQc.bz(a.this.dQb.getUserList());
            if (z) {
                a.this.dQc.aKU();
            } else {
                a.this.dQc.aLp();
            }
        }

        @Override // com.baidu.tieba.ala.live.personcenter.admin.c.b.a
        public void O(int i, String str) {
            a.this.dQc.completePullRefresh();
            a.this.dQc.hideNoDataView();
            if (a.this.dQb.getUserList().size() <= 0) {
                a.this.dQc.aLp();
                a.this.dQc.aMp();
                a.this.dQc.a(a.i.sdk_network_not_available, new View.OnClickListener() { // from class: com.baidu.tieba.ala.live.personcenter.admin.c.a.2.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.dQc.aJm();
                        a.this.dQb.aMn();
                    }
                });
                return;
            }
            a.this.getPageContext().showToast(str, true);
        }
    };
    public String mLiveId;
    public TbPageContext pageContext;

    public TbPageContext getPageContext() {
        return this.pageContext;
    }

    public a(TbPageContext tbPageContext, View view, String str) {
        this.pageContext = tbPageContext;
        this.mLiveId = str;
        bv(view);
    }

    private void bv(View view) {
        this.dQb = new b(getPageContext());
        this.dQb.a(this.dQf);
        this.dQd = new com.baidu.live.g.b(getPageContext());
        this.dQc = new c(getPageContext(), view);
        this.dQc.setListPullRefreshListener(new TbListCommonPullView.ListPullRefreshListener() { // from class: com.baidu.tieba.ala.live.personcenter.admin.c.a.3
            @Override // com.baidu.live.tbadk.core.view.TbListCommonPullView.ListPullRefreshListener
            public void onListPullRefresh(boolean z) {
                a.this.dQb.aMn();
            }
        });
        this.dQc.aLp();
    }

    public void onCreate(Bundle bundle) {
        getPageContext().registerListener(this.dQe);
        this.dQb.aMn();
    }

    public void onChangeSkinType(int i) {
        if (this.dQc != null) {
            this.dQc.onChangeSkinType(i);
        }
    }
}
