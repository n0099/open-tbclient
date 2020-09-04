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
/* loaded from: classes7.dex */
public class a {
    private c ggA;
    private com.baidu.live.o.b ggB;
    private CustomMessageListener ggC = new CustomMessageListener(2913050, true) { // from class: com.baidu.tieba.ala.live.personcenter.admin.c.a.1
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
                        a.this.ggB.aB(bVar.getUserId(), a.this.mLiveId);
                        a.this.ggz.a(bVar);
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
    private b.a ggD = new b.a() { // from class: com.baidu.tieba.ala.live.personcenter.admin.c.a.2
        @Override // com.baidu.tieba.ala.live.personcenter.admin.c.b.a
        public void kQ(boolean z) {
            a.this.ggA.completePullRefresh();
            a.this.ggA.hideNoDataView();
            if (a.this.ggz.getUserList().size() == 0) {
                a.this.ggA.bKi();
                a.this.ggA.bLu();
                a.this.ggA.showNoDataView();
                return;
            }
            a.this.ggA.bFX();
            a.this.ggA.bLt();
            a.this.ggA.f(a.this.ggz.getUserList(), a.this.ggz.bLq());
            if (z) {
                a.this.ggA.bJN();
            } else {
                a.this.ggA.bKi();
            }
        }

        @Override // com.baidu.tieba.ala.live.personcenter.admin.c.b.a
        public void am(int i, String str) {
            a.this.ggA.completePullRefresh();
            a.this.ggA.hideNoDataView();
            if (a.this.ggz.getUserList().size() <= 0) {
                a.this.ggA.bKi();
                a.this.ggA.bLu();
                a.this.ggA.a(a.i.sdk_network_not_available, new View.OnClickListener() { // from class: com.baidu.tieba.ala.live.personcenter.admin.c.a.2.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.ggA.bFX();
                        a.this.ggz.bLs();
                    }
                });
                return;
            }
            a.this.getPageContext().showToast(str, true);
        }
    };
    private b ggz;
    public String mLiveId;
    public TbPageContext pageContext;

    public TbPageContext getPageContext() {
        return this.pageContext;
    }

    public a(TbPageContext tbPageContext, View view, String str) {
        this.pageContext = tbPageContext;
        this.mLiveId = str;
        bJ(view);
    }

    private void bJ(View view) {
        this.ggz = new b(getPageContext());
        this.ggz.a(this.ggD);
        this.ggB = new com.baidu.live.o.b(getPageContext());
        this.ggA = new c(getPageContext(), view);
        this.ggA.setListPullRefreshListener(new TbListCommonPullView.ListPullRefreshListener() { // from class: com.baidu.tieba.ala.live.personcenter.admin.c.a.3
            @Override // com.baidu.live.tbadk.core.view.TbListCommonPullView.ListPullRefreshListener
            public void onListPullRefresh(boolean z) {
                a.this.ggz.bLs();
            }
        });
        this.ggA.bKi();
    }

    public void onCreate(Bundle bundle) {
        getPageContext().registerListener(this.ggC);
        this.ggz.bLs();
    }

    public void onChangeSkinType(int i) {
        if (this.ggA != null) {
            this.ggA.onChangeSkinType(i);
        }
    }
}
