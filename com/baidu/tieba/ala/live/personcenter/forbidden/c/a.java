package com.baidu.tieba.ala.live.personcenter.forbidden.c;

import android.os.Bundle;
import android.view.View;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.widget.listview.BdListView;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.dialog.BdAlertDialog;
import com.baidu.live.tbadk.core.view.TbListCommonPullView;
import com.baidu.live.u.a;
import com.baidu.tieba.ala.live.personcenter.forbidden.c.b;
/* loaded from: classes3.dex */
public class a {
    private com.baidu.live.n.b fDL;
    private b fFe;
    private c fFf;
    public TbPageContext pageContext;
    private CustomMessageListener fDM = new CustomMessageListener(2913051, true) { // from class: com.baidu.tieba.ala.live.personcenter.forbidden.c.a.1
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
                        a.this.fDL.q(bVar.getUserId(), null, null);
                        a.this.fFe.a(bVar);
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
    private b.a fFg = new b.a() { // from class: com.baidu.tieba.ala.live.personcenter.forbidden.c.a.2
        @Override // com.baidu.tieba.ala.live.personcenter.forbidden.c.b.a
        public void jz(boolean z) {
            a.this.fFf.completePullRefresh();
            a.this.fFf.hideNoDataView();
            if (a.this.fFe.getUserList().size() == 0) {
                a.this.fFf.bvN();
                a.this.fFf.buy();
                a.this.fFf.showNoDataView();
                return;
            }
            a.this.fFf.bqO();
            a.this.fFf.bvM();
            a.this.fFf.e(a.this.fFe.getUserList(), a.this.fFe.getTotalCount());
            if (z) {
                a.this.fFf.bud();
            } else {
                a.this.fFf.buy();
            }
        }

        @Override // com.baidu.tieba.ala.live.personcenter.forbidden.c.b.a
        public void al(int i, String str) {
            a.this.fFf.completePullRefresh();
            a.this.fFf.hideNoDataView();
            if (a.this.fFe.getUserList().size() > 0) {
                if (a.this.fFe.hasMore()) {
                    a.this.fFf.bud();
                } else {
                    a.this.fFf.bqJ();
                }
                a.this.getPageContext().showToast(str, true);
                return;
            }
            a.this.fFf.buy();
            a.this.fFf.bvN();
            a.this.fFf.a(a.i.sdk_network_not_available, new View.OnClickListener() { // from class: com.baidu.tieba.ala.live.personcenter.forbidden.c.a.2.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.fFf.bqO();
                    a.this.fFe.bvL();
                }
            });
        }
    };

    public TbPageContext getPageContext() {
        return this.pageContext;
    }

    public a(TbPageContext tbPageContext, View view) {
        this.pageContext = tbPageContext;
        by(view);
    }

    private void by(View view) {
        this.fFe = new b(getPageContext());
        this.fFe.a(this.fFg);
        this.fDL = new com.baidu.live.n.b(getPageContext());
        this.fFf = new c(getPageContext(), view);
        this.fFf.setListPullRefreshListener(new TbListCommonPullView.ListPullRefreshListener() { // from class: com.baidu.tieba.ala.live.personcenter.forbidden.c.a.3
            @Override // com.baidu.live.tbadk.core.view.TbListCommonPullView.ListPullRefreshListener
            public void onListPullRefresh(boolean z) {
                a.this.fFe.bvL();
            }
        });
        this.fFf.setOnSrollToBottomListener(new BdListView.OnScrollToBottomListener() { // from class: com.baidu.tieba.ala.live.personcenter.forbidden.c.a.4
            @Override // com.baidu.live.adp.widget.listview.BdListView.OnScrollToBottomListener
            public void onScrollToBottom() {
                if (a.this.fFe.hasMore()) {
                    a.this.fFe.buF();
                    a.this.fFf.bqK();
                }
            }
        });
    }

    public void onCreate(Bundle bundle) {
        getPageContext().registerListener(this.fDM);
        this.fFe.bvL();
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
        if (this.fFf != null) {
            this.fFf.onChangeSkinType(i);
        }
    }
}
