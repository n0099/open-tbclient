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
    private e gPF;
    private b gQW;
    private c gQX;
    public TbPageContext pageContext;
    private CustomMessageListener gPG = new CustomMessageListener(2913051, true) { // from class: com.baidu.tieba.ala.live.personcenter.forbidden.c.a.1
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
                        a.this.gPF.t(bVar.getUserId(), null, null);
                        a.this.gQW.a(bVar);
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
    private b.a gQY = new b.a() { // from class: com.baidu.tieba.ala.live.personcenter.forbidden.c.a.2
        @Override // com.baidu.tieba.ala.live.personcenter.forbidden.c.b.a
        public void lR(boolean z) {
            a.this.gQX.completePullRefresh();
            a.this.gQX.hideNoDataView();
            if (a.this.gQW.getUserList().size() == 0) {
                a.this.gQX.bVr();
                a.this.gQX.bTh();
                a.this.gQX.showNoDataView();
                return;
            }
            a.this.gQX.Wk();
            a.this.gQX.bVq();
            a.this.gQX.f(a.this.gQW.getUserList(), a.this.gQW.getTotalCount());
            if (z) {
                a.this.gQX.bSM();
            } else {
                a.this.gQX.bTh();
            }
        }

        @Override // com.baidu.tieba.ala.live.personcenter.forbidden.c.b.a
        public void aE(int i, String str) {
            a.this.gQX.completePullRefresh();
            a.this.gQX.hideNoDataView();
            if (a.this.gQW.getUserList().size() > 0) {
                if (a.this.gQW.hasMore()) {
                    a.this.gQX.bSM();
                } else {
                    a.this.gQX.bOW();
                }
                a.this.getPageContext().showToast(str, true);
                return;
            }
            a.this.gQX.bTh();
            a.this.gQX.bVr();
            a.this.gQX.a(a.h.sdk_network_not_available, new View.OnClickListener() { // from class: com.baidu.tieba.ala.live.personcenter.forbidden.c.a.2.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.gQX.Wk();
                    a.this.gQW.bVp();
                }
            });
        }
    };

    public TbPageContext getPageContext() {
        return this.pageContext;
    }

    public a(TbPageContext tbPageContext, View view) {
        this.pageContext = tbPageContext;
        bY(view);
    }

    private void bY(View view) {
        this.gQW = new b(getPageContext());
        this.gQW.a(this.gQY);
        this.gPF = new e(getPageContext());
        this.gQX = new c(getPageContext(), view);
        this.gQX.setListPullRefreshListener(new TbListCommonPullView.ListPullRefreshListener() { // from class: com.baidu.tieba.ala.live.personcenter.forbidden.c.a.3
            @Override // com.baidu.live.tbadk.core.view.TbListCommonPullView.ListPullRefreshListener
            public void onListPullRefresh(boolean z) {
                a.this.gQW.bVp();
            }
        });
        this.gQX.setOnSrollToBottomListener(new BdListView.OnScrollToBottomListener() { // from class: com.baidu.tieba.ala.live.personcenter.forbidden.c.a.4
            @Override // com.baidu.live.adp.widget.listview.BdListView.OnScrollToBottomListener
            public void onScrollToBottom() {
                if (a.this.gQW.hasMore()) {
                    a.this.gQW.bTm();
                    a.this.gQX.bOX();
                }
            }
        });
    }

    public void onCreate(Bundle bundle) {
        getPageContext().registerListener(this.gPG);
        this.gQW.bVp();
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
        if (this.gQX != null) {
            this.gQX.onChangeSkinType(i);
        }
    }
}
