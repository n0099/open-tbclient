package com.baidu.tieba.ala.live.personcenter.forbidden.c;

import android.os.Bundle;
import android.view.View;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.widget.listview.BdListView;
import com.baidu.live.k.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.dialog.BdAlertDialog;
import com.baidu.live.tbadk.core.view.TbListCommonPullView;
import com.baidu.tieba.ala.live.personcenter.forbidden.c.b;
/* loaded from: classes6.dex */
public class a {
    private com.baidu.live.g.b dQd;
    private b dRs;
    private c dRt;
    public TbPageContext pageContext;
    private CustomMessageListener dQe = new CustomMessageListener(2913051, true) { // from class: com.baidu.tieba.ala.live.personcenter.forbidden.c.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof com.baidu.tieba.ala.live.personcenter.forbidden.b.b) {
                final com.baidu.tieba.ala.live.personcenter.forbidden.b.b bVar = (com.baidu.tieba.ala.live.personcenter.forbidden.b.b) customResponsedMessage.getData();
                BdAlertDialog bdAlertDialog = new BdAlertDialog(a.this.getPageContext().getPageActivity());
                bdAlertDialog.setTitle(a.i.sdk_prc_person_forbiddenlist_manage_title);
                bdAlertDialog.setMessageId(a.i.sdk_prc_person_forbiddenlist_manage_content);
                bdAlertDialog.setNegativeButton(a.i.sdk_cancel, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.live.personcenter.forbidden.c.a.1.1
                    @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                    public void onClick(BdAlertDialog bdAlertDialog2) {
                        bdAlertDialog2.dismiss();
                    }
                });
                bdAlertDialog.setPositiveButton(a.i.sdk_confirm, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.live.personcenter.forbidden.c.a.1.2
                    @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                    public void onClick(BdAlertDialog bdAlertDialog2) {
                        bdAlertDialog2.dismiss();
                        a.this.dQd.m(bVar.getUserId(), null, null);
                        a.this.dRs.a(bVar);
                    }
                });
                bdAlertDialog.create(a.this.getPageContext());
                bdAlertDialog.show();
            }
        }
    };
    private b.a dRu = new b.a() { // from class: com.baidu.tieba.ala.live.personcenter.forbidden.c.a.2
        @Override // com.baidu.tieba.ala.live.personcenter.forbidden.c.b.a
        public void gI(boolean z) {
            a.this.dRt.completePullRefresh();
            a.this.dRt.hideNoDataView();
            if (a.this.dRs.getUserList().size() == 0) {
                a.this.dRt.aMp();
                a.this.dRt.aLp();
                a.this.dRt.showNoDataView();
                return;
            }
            a.this.dRt.aJm();
            a.this.dRt.aMo();
            a.this.dRt.e(a.this.dRs.getUserList(), a.this.dRs.getTotalCount());
            if (z) {
                a.this.dRt.aKU();
            } else {
                a.this.dRt.aLp();
            }
        }

        @Override // com.baidu.tieba.ala.live.personcenter.forbidden.c.b.a
        public void O(int i, String str) {
            a.this.dRt.completePullRefresh();
            a.this.dRt.hideNoDataView();
            if (a.this.dRs.getUserList().size() > 0) {
                if (a.this.dRs.hasMore()) {
                    a.this.dRt.aKU();
                } else {
                    a.this.dRt.aJi();
                }
                a.this.getPageContext().showToast(str, true);
                return;
            }
            a.this.dRt.aLp();
            a.this.dRt.aMp();
            a.this.dRt.a(a.i.sdk_network_not_available, new View.OnClickListener() { // from class: com.baidu.tieba.ala.live.personcenter.forbidden.c.a.2.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.dRt.aJm();
                    a.this.dRs.aMn();
                }
            });
        }
    };

    public TbPageContext getPageContext() {
        return this.pageContext;
    }

    public a(TbPageContext tbPageContext, View view) {
        this.pageContext = tbPageContext;
        bv(view);
    }

    private void bv(View view) {
        this.dRs = new b(getPageContext());
        this.dRs.a(this.dRu);
        this.dQd = new com.baidu.live.g.b(getPageContext());
        this.dRt = new c(getPageContext(), view);
        this.dRt.setListPullRefreshListener(new TbListCommonPullView.ListPullRefreshListener() { // from class: com.baidu.tieba.ala.live.personcenter.forbidden.c.a.3
            @Override // com.baidu.live.tbadk.core.view.TbListCommonPullView.ListPullRefreshListener
            public void onListPullRefresh(boolean z) {
                a.this.dRs.aMn();
            }
        });
        this.dRt.setOnSrollToBottomListener(new BdListView.OnScrollToBottomListener() { // from class: com.baidu.tieba.ala.live.personcenter.forbidden.c.a.4
            @Override // com.baidu.live.adp.widget.listview.BdListView.OnScrollToBottomListener
            public void onScrollToBottom() {
                if (a.this.dRs.hasMore()) {
                    a.this.dRs.aLE();
                    a.this.dRt.aJj();
                }
            }
        });
    }

    public void onCreate(Bundle bundle) {
        getPageContext().registerListener(this.dQe);
        this.dRs.aMn();
    }

    public void onPause() {
    }

    public void onStop() {
    }

    public void onResume() {
    }

    public void onStart() {
    }

    public void onDestroy() {
    }

    public void onChangeSkinType(int i) {
        if (this.dRt != null) {
            this.dRt.onChangeSkinType(i);
        }
    }
}
