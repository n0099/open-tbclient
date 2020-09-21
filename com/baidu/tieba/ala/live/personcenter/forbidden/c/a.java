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
/* loaded from: classes4.dex */
public class a {
    private com.baidu.live.personmanager.b gjM;
    private b gld;
    private c gle;
    public TbPageContext pageContext;
    private CustomMessageListener gjN = new CustomMessageListener(2913051, true) { // from class: com.baidu.tieba.ala.live.personcenter.forbidden.c.a.1
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
                        a.this.gjM.s(bVar.getUserId(), null, null);
                        a.this.gld.a(bVar);
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
    private b.a glf = new b.a() { // from class: com.baidu.tieba.ala.live.personcenter.forbidden.c.a.2
        @Override // com.baidu.tieba.ala.live.personcenter.forbidden.c.b.a
        public void kS(boolean z) {
            a.this.gle.completePullRefresh();
            a.this.gle.hideNoDataView();
            if (a.this.gld.getUserList().size() == 0) {
                a.this.gle.bME();
                a.this.gle.bLs();
                a.this.gle.showNoDataView();
                return;
            }
            a.this.gle.bHn();
            a.this.gle.bMD();
            a.this.gle.f(a.this.gld.getUserList(), a.this.gld.getTotalCount());
            if (z) {
                a.this.gle.bKX();
            } else {
                a.this.gle.bLs();
            }
        }

        @Override // com.baidu.tieba.ala.live.personcenter.forbidden.c.b.a
        public void an(int i, String str) {
            a.this.gle.completePullRefresh();
            a.this.gle.hideNoDataView();
            if (a.this.gld.getUserList().size() > 0) {
                if (a.this.gld.hasMore()) {
                    a.this.gle.bKX();
                } else {
                    a.this.gle.bHi();
                }
                a.this.getPageContext().showToast(str, true);
                return;
            }
            a.this.gle.bLs();
            a.this.gle.bME();
            a.this.gle.a(a.i.sdk_network_not_available, new View.OnClickListener() { // from class: com.baidu.tieba.ala.live.personcenter.forbidden.c.a.2.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.gle.bHn();
                    a.this.gld.bMC();
                }
            });
        }
    };

    public TbPageContext getPageContext() {
        return this.pageContext;
    }

    public a(TbPageContext tbPageContext, View view) {
        this.pageContext = tbPageContext;
        bN(view);
    }

    private void bN(View view) {
        this.gld = new b(getPageContext());
        this.gld.a(this.glf);
        this.gjM = new com.baidu.live.personmanager.b(getPageContext());
        this.gle = new c(getPageContext(), view);
        this.gle.setListPullRefreshListener(new TbListCommonPullView.ListPullRefreshListener() { // from class: com.baidu.tieba.ala.live.personcenter.forbidden.c.a.3
            @Override // com.baidu.live.tbadk.core.view.TbListCommonPullView.ListPullRefreshListener
            public void onListPullRefresh(boolean z) {
                a.this.gld.bMC();
            }
        });
        this.gle.setOnSrollToBottomListener(new BdListView.OnScrollToBottomListener() { // from class: com.baidu.tieba.ala.live.personcenter.forbidden.c.a.4
            @Override // com.baidu.live.adp.widget.listview.BdListView.OnScrollToBottomListener
            public void onScrollToBottom() {
                if (a.this.gld.hasMore()) {
                    a.this.gld.bLy();
                    a.this.gle.bHj();
                }
            }
        });
    }

    public void onCreate(Bundle bundle) {
        getPageContext().registerListener(this.gjN);
        this.gld.bMC();
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
        if (this.gle != null) {
            this.gle.onChangeSkinType(i);
        }
    }
}
