package com.baidu.tieba.ala.live.personcenter.forbidden.c;

import android.os.Bundle;
import android.view.View;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.widget.listview.BdListView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.dialog.BdAlertDialog;
import com.baidu.live.tbadk.core.view.TbListCommonPullView;
import com.baidu.tieba.ala.live.personcenter.forbidden.c.b;
/* loaded from: classes7.dex */
public class a {
    private com.baidu.live.o.b ggx;
    private b ghQ;
    private c ghR;
    public TbPageContext pageContext;
    private CustomMessageListener ggy = new CustomMessageListener(2913051, true) { // from class: com.baidu.tieba.ala.live.personcenter.forbidden.c.a.1
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
                        a.this.ggx.s(bVar.getUserId(), null, null);
                        a.this.ghQ.a(bVar);
                    }
                });
                if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                    bdAlertDialog.setPositiveButtonTextColor(a.this.getPageContext().getResources().getColorStateList(a.f.sdk_dialog_gray_button_txt_selector));
                    bdAlertDialog.setNagetiveButtonTextColor(a.this.getPageContext().getResources().getColorStateList(a.f.sdk_dialog_gray_button_txt_selector));
                }
                bdAlertDialog.create(a.this.getPageContext());
                bdAlertDialog.show();
            }
        }
    };
    private b.a ghS = new b.a() { // from class: com.baidu.tieba.ala.live.personcenter.forbidden.c.a.2
        @Override // com.baidu.tieba.ala.live.personcenter.forbidden.c.b.a
        public void kO(boolean z) {
            a.this.ghR.completePullRefresh();
            a.this.ghR.hideNoDataView();
            if (a.this.ghQ.getUserList().size() == 0) {
                a.this.ghR.bLt();
                a.this.ghR.bKh();
                a.this.ghR.showNoDataView();
                return;
            }
            a.this.ghR.bFW();
            a.this.ghR.bLs();
            a.this.ghR.f(a.this.ghQ.getUserList(), a.this.ghQ.getTotalCount());
            if (z) {
                a.this.ghR.bJM();
            } else {
                a.this.ghR.bKh();
            }
        }

        @Override // com.baidu.tieba.ala.live.personcenter.forbidden.c.b.a
        public void am(int i, String str) {
            a.this.ghR.completePullRefresh();
            a.this.ghR.hideNoDataView();
            if (a.this.ghQ.getUserList().size() > 0) {
                if (a.this.ghQ.hasMore()) {
                    a.this.ghR.bJM();
                } else {
                    a.this.ghR.bFR();
                }
                a.this.getPageContext().showToast(str, true);
                return;
            }
            a.this.ghR.bKh();
            a.this.ghR.bLt();
            a.this.ghR.a(a.i.sdk_network_not_available, new View.OnClickListener() { // from class: com.baidu.tieba.ala.live.personcenter.forbidden.c.a.2.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.ghR.bFW();
                    a.this.ghQ.bLr();
                }
            });
        }
    };

    public TbPageContext getPageContext() {
        return this.pageContext;
    }

    public a(TbPageContext tbPageContext, View view) {
        this.pageContext = tbPageContext;
        bJ(view);
    }

    private void bJ(View view) {
        this.ghQ = new b(getPageContext());
        this.ghQ.a(this.ghS);
        this.ggx = new com.baidu.live.o.b(getPageContext());
        this.ghR = new c(getPageContext(), view);
        this.ghR.setListPullRefreshListener(new TbListCommonPullView.ListPullRefreshListener() { // from class: com.baidu.tieba.ala.live.personcenter.forbidden.c.a.3
            @Override // com.baidu.live.tbadk.core.view.TbListCommonPullView.ListPullRefreshListener
            public void onListPullRefresh(boolean z) {
                a.this.ghQ.bLr();
            }
        });
        this.ghR.setOnSrollToBottomListener(new BdListView.OnScrollToBottomListener() { // from class: com.baidu.tieba.ala.live.personcenter.forbidden.c.a.4
            @Override // com.baidu.live.adp.widget.listview.BdListView.OnScrollToBottomListener
            public void onScrollToBottom() {
                if (a.this.ghQ.hasMore()) {
                    a.this.ghQ.bKn();
                    a.this.ghR.bFS();
                }
            }
        });
    }

    public void onCreate(Bundle bundle) {
        getPageContext().registerListener(this.ggy);
        this.ghQ.bLr();
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
        if (this.ghR != null) {
            this.ghR.onChangeSkinType(i);
        }
    }
}
