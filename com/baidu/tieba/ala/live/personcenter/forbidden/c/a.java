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
    private com.baidu.live.g.b dQU;
    private b dSj;
    private c dSk;
    public TbPageContext pageContext;
    private CustomMessageListener dQV = new CustomMessageListener(2913051, true) { // from class: com.baidu.tieba.ala.live.personcenter.forbidden.c.a.1
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
                        a.this.dQU.m(bVar.getUserId(), null, null);
                        a.this.dSj.a(bVar);
                    }
                });
                bdAlertDialog.create(a.this.getPageContext());
                bdAlertDialog.show();
            }
        }
    };
    private b.a dSl = new b.a() { // from class: com.baidu.tieba.ala.live.personcenter.forbidden.c.a.2
        @Override // com.baidu.tieba.ala.live.personcenter.forbidden.c.b.a
        public void gI(boolean z) {
            a.this.dSk.completePullRefresh();
            a.this.dSk.hideNoDataView();
            if (a.this.dSj.getUserList().size() == 0) {
                a.this.dSk.aMr();
                a.this.dSk.aLr();
                a.this.dSk.showNoDataView();
                return;
            }
            a.this.dSk.aJo();
            a.this.dSk.aMq();
            a.this.dSk.e(a.this.dSj.getUserList(), a.this.dSj.getTotalCount());
            if (z) {
                a.this.dSk.aKW();
            } else {
                a.this.dSk.aLr();
            }
        }

        @Override // com.baidu.tieba.ala.live.personcenter.forbidden.c.b.a
        public void P(int i, String str) {
            a.this.dSk.completePullRefresh();
            a.this.dSk.hideNoDataView();
            if (a.this.dSj.getUserList().size() > 0) {
                if (a.this.dSj.hasMore()) {
                    a.this.dSk.aKW();
                } else {
                    a.this.dSk.aJk();
                }
                a.this.getPageContext().showToast(str, true);
                return;
            }
            a.this.dSk.aLr();
            a.this.dSk.aMr();
            a.this.dSk.a(a.i.sdk_network_not_available, new View.OnClickListener() { // from class: com.baidu.tieba.ala.live.personcenter.forbidden.c.a.2.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.dSk.aJo();
                    a.this.dSj.aMp();
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
        this.dSj = new b(getPageContext());
        this.dSj.a(this.dSl);
        this.dQU = new com.baidu.live.g.b(getPageContext());
        this.dSk = new c(getPageContext(), view);
        this.dSk.setListPullRefreshListener(new TbListCommonPullView.ListPullRefreshListener() { // from class: com.baidu.tieba.ala.live.personcenter.forbidden.c.a.3
            @Override // com.baidu.live.tbadk.core.view.TbListCommonPullView.ListPullRefreshListener
            public void onListPullRefresh(boolean z) {
                a.this.dSj.aMp();
            }
        });
        this.dSk.setOnSrollToBottomListener(new BdListView.OnScrollToBottomListener() { // from class: com.baidu.tieba.ala.live.personcenter.forbidden.c.a.4
            @Override // com.baidu.live.adp.widget.listview.BdListView.OnScrollToBottomListener
            public void onScrollToBottom() {
                if (a.this.dSj.hasMore()) {
                    a.this.dSj.aLG();
                    a.this.dSk.aJl();
                }
            }
        });
    }

    public void onCreate(Bundle bundle) {
        getPageContext().registerListener(this.dQV);
        this.dSj.aMp();
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
        if (this.dSk != null) {
            this.dSk.onChangeSkinType(i);
        }
    }
}
