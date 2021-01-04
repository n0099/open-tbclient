package com.baidu.tieba.ala.live.personcenter.admin.c;

import android.os.Bundle;
import android.view.View;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.personmanager.e;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.dialog.BdAlertDialog;
import com.baidu.live.tbadk.core.view.TbListCommonPullView;
import com.baidu.tieba.ala.live.personcenter.admin.c.b;
/* loaded from: classes11.dex */
public class a {
    private b hko;
    private c hkp;
    private e hkq;
    private CustomMessageListener hkr = new CustomMessageListener(2913050, true) { // from class: com.baidu.tieba.ala.live.personcenter.admin.c.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof com.baidu.tieba.ala.live.personcenter.admin.b.b) {
                final com.baidu.tieba.ala.live.personcenter.admin.b.b bVar = (com.baidu.tieba.ala.live.personcenter.admin.b.b) customResponsedMessage.getData();
                BdAlertDialog bdAlertDialog = new BdAlertDialog(a.this.getPageContext().getPageActivity());
                bdAlertDialog.setTitle(a.h.sdk_prc_person_adminlist_manage_title);
                bdAlertDialog.setMessageId(a.h.sdk_prc_person_adminlist_manage_content);
                bdAlertDialog.setNegativeButton(a.h.sdk_cancel, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.live.personcenter.admin.c.a.1.1
                    @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                    public void onClick(BdAlertDialog bdAlertDialog2) {
                        bdAlertDialog2.dismiss();
                    }
                });
                bdAlertDialog.setPositiveButton(a.h.sdk_confirm, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.live.personcenter.admin.c.a.1.2
                    @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                    public void onClick(BdAlertDialog bdAlertDialog2) {
                        bdAlertDialog2.dismiss();
                        a.this.hkq.c(bVar.getUserId(), a.this.mLiveId, 0);
                        a.this.hko.a(bVar);
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
    private b.a hks = new b.a() { // from class: com.baidu.tieba.ala.live.personcenter.admin.c.a.2
        @Override // com.baidu.tieba.ala.live.personcenter.admin.c.b.a
        public void mK(boolean z) {
            a.this.hkp.completePullRefresh();
            a.this.hkp.hideNoDataView();
            if (a.this.hko.getUserList().size() == 0) {
                a.this.hkp.bYQ();
                a.this.hkp.caZ();
                a.this.hkp.showNoDataView();
                return;
            }
            a.this.hkp.Zi();
            a.this.hkp.caY();
            a.this.hkp.f(a.this.hko.getUserList(), a.this.hko.caV());
            if (z) {
                a.this.hkp.bYv();
            } else {
                a.this.hkp.bYQ();
            }
        }

        @Override // com.baidu.tieba.ala.live.personcenter.admin.c.b.a
        public void aE(int i, String str) {
            a.this.hkp.completePullRefresh();
            a.this.hkp.hideNoDataView();
            if (a.this.hko.getUserList().size() <= 0) {
                a.this.hkp.bYQ();
                a.this.hkp.caZ();
                a.this.hkp.a(a.h.sdk_network_not_available, new View.OnClickListener() { // from class: com.baidu.tieba.ala.live.personcenter.admin.c.a.2.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.hkp.Zi();
                        a.this.hko.caX();
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
        cr(view);
    }

    private void cr(View view) {
        this.hko = new b(getPageContext());
        this.hko.a(this.hks);
        this.hkq = new e(getPageContext());
        this.hkp = new c(getPageContext(), view);
        this.hkp.setListPullRefreshListener(new TbListCommonPullView.ListPullRefreshListener() { // from class: com.baidu.tieba.ala.live.personcenter.admin.c.a.3
            @Override // com.baidu.live.tbadk.core.view.TbListCommonPullView.ListPullRefreshListener
            public void onListPullRefresh(boolean z) {
                a.this.hko.caX();
            }
        });
        this.hkp.bYQ();
    }

    public void onCreate(Bundle bundle) {
        getPageContext().registerListener(this.hkr);
        this.hko.caX();
    }

    public void onChangeSkinType(int i) {
        if (this.hkp != null) {
            this.hkp.onChangeSkinType(i);
        }
    }
}
