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
/* loaded from: classes10.dex */
public class a {
    private e hfJ;
    private b hgZ;
    private c hha;
    public TbPageContext pageContext;
    private CustomMessageListener hfK = new CustomMessageListener(2913051, true) { // from class: com.baidu.tieba.ala.live.personcenter.forbidden.c.a.1
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
                        a.this.hfJ.f(bVar.getUserId(), null, null, 0);
                        a.this.hgZ.a(bVar);
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
    private b.a hhb = new b.a() { // from class: com.baidu.tieba.ala.live.personcenter.forbidden.c.a.2
        @Override // com.baidu.tieba.ala.live.personcenter.forbidden.c.b.a
        public void mG(boolean z) {
            a.this.hha.completePullRefresh();
            a.this.hha.hideNoDataView();
            if (a.this.hgZ.getUserList().size() == 0) {
                a.this.hha.bXi();
                a.this.hha.bUZ();
                a.this.hha.showNoDataView();
                return;
            }
            a.this.hha.Vq();
            a.this.hha.bXh();
            a.this.hha.f(a.this.hgZ.getUserList(), a.this.hgZ.getTotalCount());
            if (z) {
                a.this.hha.bUE();
            } else {
                a.this.hha.bUZ();
            }
        }

        @Override // com.baidu.tieba.ala.live.personcenter.forbidden.c.b.a
        public void aF(int i, String str) {
            a.this.hha.completePullRefresh();
            a.this.hha.hideNoDataView();
            if (a.this.hgZ.getUserList().size() > 0) {
                if (a.this.hgZ.hasMore()) {
                    a.this.hha.bUE();
                } else {
                    a.this.hha.bQM();
                }
                a.this.getPageContext().showToast(str, true);
                return;
            }
            a.this.hha.bUZ();
            a.this.hha.bXi();
            a.this.hha.a(a.h.sdk_network_not_available, new View.OnClickListener() { // from class: com.baidu.tieba.ala.live.personcenter.forbidden.c.a.2.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.hha.Vq();
                    a.this.hgZ.bXg();
                }
            });
        }
    };

    public TbPageContext getPageContext() {
        return this.pageContext;
    }

    public a(TbPageContext tbPageContext, View view) {
        this.pageContext = tbPageContext;
        cr(view);
    }

    private void cr(View view) {
        this.hgZ = new b(getPageContext());
        this.hgZ.a(this.hhb);
        this.hfJ = new e(getPageContext());
        this.hha = new c(getPageContext(), view);
        this.hha.setListPullRefreshListener(new TbListCommonPullView.ListPullRefreshListener() { // from class: com.baidu.tieba.ala.live.personcenter.forbidden.c.a.3
            @Override // com.baidu.live.tbadk.core.view.TbListCommonPullView.ListPullRefreshListener
            public void onListPullRefresh(boolean z) {
                a.this.hgZ.bXg();
            }
        });
        this.hha.setOnSrollToBottomListener(new BdListView.OnScrollToBottomListener() { // from class: com.baidu.tieba.ala.live.personcenter.forbidden.c.a.4
            @Override // com.baidu.live.adp.widget.listview.BdListView.OnScrollToBottomListener
            public void onScrollToBottom() {
                if (a.this.hgZ.hasMore()) {
                    a.this.hgZ.bVe();
                    a.this.hha.bQN();
                }
            }
        });
    }

    public void onCreate(Bundle bundle) {
        getPageContext().registerListener(this.hfK);
        this.hgZ.bXg();
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
        if (this.hha != null) {
            this.hha.onChangeSkinType(i);
        }
    }
}
