package com.baidu.tieba.ala.live.personcenter.admin.c;

import android.os.Bundle;
import android.view.View;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.r.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.dialog.BdAlertDialog;
import com.baidu.live.tbadk.core.view.TbListCommonPullView;
import com.baidu.tieba.ala.live.personcenter.admin.c.b;
/* loaded from: classes2.dex */
public class a {
    private b eGN;
    private c eGO;
    private com.baidu.live.l.b eGP;
    private CustomMessageListener eGQ = new CustomMessageListener(2913050, true) { // from class: com.baidu.tieba.ala.live.personcenter.admin.c.a.1
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
                        a.this.eGP.W(bVar.getUserId(), a.this.mLiveId);
                        a.this.eGN.a(bVar);
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
    private b.a eGR = new b.a() { // from class: com.baidu.tieba.ala.live.personcenter.admin.c.a.2
        @Override // com.baidu.tieba.ala.live.personcenter.admin.c.b.a
        public void hX(boolean z) {
            a.this.eGO.completePullRefresh();
            a.this.eGO.hideNoDataView();
            if (a.this.eGN.getUserList().size() == 0) {
                a.this.eGO.bcU();
                a.this.eGO.ben();
                a.this.eGO.showNoDataView();
                return;
            }
            a.this.eGO.baf();
            a.this.eGO.bem();
            a.this.eGO.by(a.this.eGN.getUserList());
            if (z) {
                a.this.eGO.bcB();
            } else {
                a.this.eGO.bcU();
            }
        }

        @Override // com.baidu.tieba.ala.live.personcenter.admin.c.b.a
        public void af(int i, String str) {
            a.this.eGO.completePullRefresh();
            a.this.eGO.hideNoDataView();
            if (a.this.eGN.getUserList().size() <= 0) {
                a.this.eGO.bcU();
                a.this.eGO.ben();
                a.this.eGO.a(a.i.sdk_network_not_available, new View.OnClickListener() { // from class: com.baidu.tieba.ala.live.personcenter.admin.c.a.2.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.eGO.baf();
                        a.this.eGN.bel();
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
        bw(view);
    }

    private void bw(View view) {
        this.eGN = new b(getPageContext());
        this.eGN.a(this.eGR);
        this.eGP = new com.baidu.live.l.b(getPageContext());
        this.eGO = new c(getPageContext(), view);
        this.eGO.setListPullRefreshListener(new TbListCommonPullView.ListPullRefreshListener() { // from class: com.baidu.tieba.ala.live.personcenter.admin.c.a.3
            @Override // com.baidu.live.tbadk.core.view.TbListCommonPullView.ListPullRefreshListener
            public void onListPullRefresh(boolean z) {
                a.this.eGN.bel();
            }
        });
        this.eGO.bcU();
    }

    public void onCreate(Bundle bundle) {
        getPageContext().registerListener(this.eGQ);
        this.eGN.bel();
    }

    public void onChangeSkinType(int i) {
        if (this.eGO != null) {
            this.eGO.onChangeSkinType(i);
        }
    }
}
