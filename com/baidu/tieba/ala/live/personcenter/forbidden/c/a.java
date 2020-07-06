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
/* loaded from: classes3.dex */
public class a {
    private com.baidu.live.o.b fPf;
    private CustomMessageListener fPg = new CustomMessageListener(2913051, true) { // from class: com.baidu.tieba.ala.live.personcenter.forbidden.c.a.1
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
                        a.this.fPf.r(bVar.getUserId(), null, null);
                        a.this.fQy.a(bVar);
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
    private b.a fQA = new b.a() { // from class: com.baidu.tieba.ala.live.personcenter.forbidden.c.a.2
        @Override // com.baidu.tieba.ala.live.personcenter.forbidden.c.b.a
        public void jM(boolean z) {
            a.this.fQz.completePullRefresh();
            a.this.fQz.hideNoDataView();
            if (a.this.fQy.getUserList().size() == 0) {
                a.this.fQz.byL();
                a.this.fQz.bxw();
                a.this.fQz.showNoDataView();
                return;
            }
            a.this.fQz.btO();
            a.this.fQz.byK();
            a.this.fQz.f(a.this.fQy.getUserList(), a.this.fQy.getTotalCount());
            if (z) {
                a.this.fQz.bxb();
            } else {
                a.this.fQz.bxw();
            }
        }

        @Override // com.baidu.tieba.ala.live.personcenter.forbidden.c.b.a
        public void an(int i, String str) {
            a.this.fQz.completePullRefresh();
            a.this.fQz.hideNoDataView();
            if (a.this.fQy.getUserList().size() > 0) {
                if (a.this.fQy.hasMore()) {
                    a.this.fQz.bxb();
                } else {
                    a.this.fQz.btJ();
                }
                a.this.getPageContext().showToast(str, true);
                return;
            }
            a.this.fQz.bxw();
            a.this.fQz.byL();
            a.this.fQz.a(a.i.sdk_network_not_available, new View.OnClickListener() { // from class: com.baidu.tieba.ala.live.personcenter.forbidden.c.a.2.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.fQz.btO();
                    a.this.fQy.byJ();
                }
            });
        }
    };
    private b fQy;
    private c fQz;
    public TbPageContext pageContext;

    public TbPageContext getPageContext() {
        return this.pageContext;
    }

    public a(TbPageContext tbPageContext, View view) {
        this.pageContext = tbPageContext;
        bB(view);
    }

    private void bB(View view) {
        this.fQy = new b(getPageContext());
        this.fQy.a(this.fQA);
        this.fPf = new com.baidu.live.o.b(getPageContext());
        this.fQz = new c(getPageContext(), view);
        this.fQz.setListPullRefreshListener(new TbListCommonPullView.ListPullRefreshListener() { // from class: com.baidu.tieba.ala.live.personcenter.forbidden.c.a.3
            @Override // com.baidu.live.tbadk.core.view.TbListCommonPullView.ListPullRefreshListener
            public void onListPullRefresh(boolean z) {
                a.this.fQy.byJ();
            }
        });
        this.fQz.setOnSrollToBottomListener(new BdListView.OnScrollToBottomListener() { // from class: com.baidu.tieba.ala.live.personcenter.forbidden.c.a.4
            @Override // com.baidu.live.adp.widget.listview.BdListView.OnScrollToBottomListener
            public void onScrollToBottom() {
                if (a.this.fQy.hasMore()) {
                    a.this.fQy.bxD();
                    a.this.fQz.btK();
                }
            }
        });
    }

    public void onCreate(Bundle bundle) {
        getPageContext().registerListener(this.fPg);
        this.fQy.byJ();
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
        if (this.fQz != null) {
            this.fQz.onChangeSkinType(i);
        }
    }
}
