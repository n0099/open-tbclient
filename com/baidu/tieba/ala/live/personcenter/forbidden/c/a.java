package com.baidu.tieba.ala.live.personcenter.forbidden.c;

import android.os.Bundle;
import android.view.View;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.widget.listview.BdListView;
import com.baidu.live.personmanager.e;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.dialog.BdAlertDialog;
import com.baidu.live.tbadk.core.view.TbListCommonPullView;
import com.baidu.tieba.ala.live.personcenter.forbidden.c.b;
/* loaded from: classes4.dex */
public class a {
    private e gYB;
    private b gZS;
    private c gZT;
    public TbPageContext pageContext;
    private CustomMessageListener gYC = new CustomMessageListener(2913051, true) { // from class: com.baidu.tieba.ala.live.personcenter.forbidden.c.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof com.baidu.tieba.ala.live.personcenter.forbidden.b.b) {
                final com.baidu.tieba.ala.live.personcenter.forbidden.b.b bVar = (com.baidu.tieba.ala.live.personcenter.forbidden.b.b) customResponsedMessage.getData();
                BdAlertDialog bdAlertDialog = new BdAlertDialog(a.this.getPageContext().getPageActivity());
                bdAlertDialog.setTitle(a.h.sdk_prc_person_forbiddenlist_manage_title);
                bdAlertDialog.setMessageId(a.h.sdk_prc_person_forbiddenlist_manage_content);
                bdAlertDialog.setNegativeButton(a.h.sdk_cancel, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.live.personcenter.forbidden.c.a.1.1
                    @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                    public void onClick(BdAlertDialog bdAlertDialog2) {
                        bdAlertDialog2.dismiss();
                    }
                });
                bdAlertDialog.setPositiveButton(a.h.sdk_confirm, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.live.personcenter.forbidden.c.a.1.2
                    @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                    public void onClick(BdAlertDialog bdAlertDialog2) {
                        bdAlertDialog2.dismiss();
                        a.this.gYB.y(bVar.getUserId(), null, null);
                        a.this.gZS.a(bVar);
                    }
                });
                if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                    bdAlertDialog.setPositiveButtonTextColor(a.this.getPageContext().getResources().getColorStateList(a.e.sdk_dialog_gray_button_txt_selector));
                    bdAlertDialog.setNagetiveButtonTextColor(a.this.getPageContext().getResources().getColorStateList(a.e.sdk_dialog_gray_button_txt_selector));
                }
                bdAlertDialog.create(a.this.getPageContext());
                bdAlertDialog.show();
            }
        }
    };
    private b.a gZU = new b.a() { // from class: com.baidu.tieba.ala.live.personcenter.forbidden.c.a.2
        @Override // com.baidu.tieba.ala.live.personcenter.forbidden.c.b.a
        public void mn(boolean z) {
            a.this.gZT.completePullRefresh();
            a.this.gZT.hideNoDataView();
            if (a.this.gZS.getUserList().size() == 0) {
                a.this.gZT.bYu();
                a.this.gZT.bWl();
                a.this.gZT.showNoDataView();
                return;
            }
            a.this.gZT.Yb();
            a.this.gZT.bYt();
            a.this.gZT.f(a.this.gZS.getUserList(), a.this.gZS.getTotalCount());
            if (z) {
                a.this.gZT.bVQ();
            } else {
                a.this.gZT.bWl();
            }
        }

        @Override // com.baidu.tieba.ala.live.personcenter.forbidden.c.b.a
        public void aC(int i, String str) {
            a.this.gZT.completePullRefresh();
            a.this.gZT.hideNoDataView();
            if (a.this.gZS.getUserList().size() > 0) {
                if (a.this.gZS.hasMore()) {
                    a.this.gZT.bVQ();
                } else {
                    a.this.gZT.bSb();
                }
                a.this.getPageContext().showToast(str, true);
                return;
            }
            a.this.gZT.bWl();
            a.this.gZT.bYu();
            a.this.gZT.a(a.h.sdk_network_not_available, new View.OnClickListener() { // from class: com.baidu.tieba.ala.live.personcenter.forbidden.c.a.2.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.gZT.Yb();
                    a.this.gZS.bYs();
                }
            });
        }
    };

    public TbPageContext getPageContext() {
        return this.pageContext;
    }

    public a(TbPageContext tbPageContext, View view) {
        this.pageContext = tbPageContext;
        ci(view);
    }

    private void ci(View view) {
        this.gZS = new b(getPageContext());
        this.gZS.a(this.gZU);
        this.gYB = new e(getPageContext());
        this.gZT = new c(getPageContext(), view);
        this.gZT.setListPullRefreshListener(new TbListCommonPullView.ListPullRefreshListener() { // from class: com.baidu.tieba.ala.live.personcenter.forbidden.c.a.3
            @Override // com.baidu.live.tbadk.core.view.TbListCommonPullView.ListPullRefreshListener
            public void onListPullRefresh(boolean z) {
                a.this.gZS.bYs();
            }
        });
        this.gZT.setOnSrollToBottomListener(new BdListView.OnScrollToBottomListener() { // from class: com.baidu.tieba.ala.live.personcenter.forbidden.c.a.4
            @Override // com.baidu.live.adp.widget.listview.BdListView.OnScrollToBottomListener
            public void onScrollToBottom() {
                if (a.this.gZS.hasMore()) {
                    a.this.gZS.bWq();
                    a.this.gZT.bSc();
                }
            }
        });
    }

    public void onCreate(Bundle bundle) {
        getPageContext().registerListener(this.gYC);
        this.gZS.bYs();
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
        if (this.gZT != null) {
            this.gZT.onChangeSkinType(i);
        }
    }
}
