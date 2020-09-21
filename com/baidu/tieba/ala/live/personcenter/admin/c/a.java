package com.baidu.tieba.ala.live.personcenter.admin.c;

import android.os.Bundle;
import android.view.View;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.dialog.BdAlertDialog;
import com.baidu.live.tbadk.core.view.TbListCommonPullView;
import com.baidu.tieba.ala.live.personcenter.admin.c.b;
/* loaded from: classes4.dex */
public class a {
    private b gjK;
    private c gjL;
    private com.baidu.live.personmanager.b gjM;
    private CustomMessageListener gjN = new CustomMessageListener(2913050, true) { // from class: com.baidu.tieba.ala.live.personcenter.admin.c.a.1
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
                        a.this.gjM.aB(bVar.getUserId(), a.this.mLiveId);
                        a.this.gjK.a(bVar);
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
    private b.a gjO = new b.a() { // from class: com.baidu.tieba.ala.live.personcenter.admin.c.a.2
        @Override // com.baidu.tieba.ala.live.personcenter.admin.c.b.a
        public void kS(boolean z) {
            a.this.gjL.completePullRefresh();
            a.this.gjL.hideNoDataView();
            if (a.this.gjK.getUserList().size() == 0) {
                a.this.gjL.bLs();
                a.this.gjL.bME();
                a.this.gjL.showNoDataView();
                return;
            }
            a.this.gjL.bHn();
            a.this.gjL.bMD();
            a.this.gjL.f(a.this.gjK.getUserList(), a.this.gjK.bMA());
            if (z) {
                a.this.gjL.bKX();
            } else {
                a.this.gjL.bLs();
            }
        }

        @Override // com.baidu.tieba.ala.live.personcenter.admin.c.b.a
        public void an(int i, String str) {
            a.this.gjL.completePullRefresh();
            a.this.gjL.hideNoDataView();
            if (a.this.gjK.getUserList().size() <= 0) {
                a.this.gjL.bLs();
                a.this.gjL.bME();
                a.this.gjL.a(a.i.sdk_network_not_available, new View.OnClickListener() { // from class: com.baidu.tieba.ala.live.personcenter.admin.c.a.2.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.gjL.bHn();
                        a.this.gjK.bMC();
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
        bN(view);
    }

    private void bN(View view) {
        this.gjK = new b(getPageContext());
        this.gjK.a(this.gjO);
        this.gjM = new com.baidu.live.personmanager.b(getPageContext());
        this.gjL = new c(getPageContext(), view);
        this.gjL.setListPullRefreshListener(new TbListCommonPullView.ListPullRefreshListener() { // from class: com.baidu.tieba.ala.live.personcenter.admin.c.a.3
            @Override // com.baidu.live.tbadk.core.view.TbListCommonPullView.ListPullRefreshListener
            public void onListPullRefresh(boolean z) {
                a.this.gjK.bMC();
            }
        });
        this.gjL.bLs();
    }

    public void onCreate(Bundle bundle) {
        getPageContext().registerListener(this.gjN);
        this.gjK.bMC();
    }

    public void onChangeSkinType(int i) {
        if (this.gjL != null) {
            this.gjL.onChangeSkinType(i);
        }
    }
}
