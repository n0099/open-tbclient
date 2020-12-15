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
/* loaded from: classes4.dex */
public class a {
    private c gYA;
    private e gYB;
    private CustomMessageListener gYC = new CustomMessageListener(2913050, true) { // from class: com.baidu.tieba.ala.live.personcenter.admin.c.a.1
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
                        a.this.gYB.aK(bVar.getUserId(), a.this.mLiveId);
                        a.this.gYz.a(bVar);
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
    private b.a gYD = new b.a() { // from class: com.baidu.tieba.ala.live.personcenter.admin.c.a.2
        @Override // com.baidu.tieba.ala.live.personcenter.admin.c.b.a
        public void mn(boolean z) {
            a.this.gYA.completePullRefresh();
            a.this.gYA.hideNoDataView();
            if (a.this.gYz.getUserList().size() == 0) {
                a.this.gYA.bWl();
                a.this.gYA.bYu();
                a.this.gYA.showNoDataView();
                return;
            }
            a.this.gYA.Yb();
            a.this.gYA.bYt();
            a.this.gYA.f(a.this.gYz.getUserList(), a.this.gYz.bYq());
            if (z) {
                a.this.gYA.bVQ();
            } else {
                a.this.gYA.bWl();
            }
        }

        @Override // com.baidu.tieba.ala.live.personcenter.admin.c.b.a
        public void aC(int i, String str) {
            a.this.gYA.completePullRefresh();
            a.this.gYA.hideNoDataView();
            if (a.this.gYz.getUserList().size() <= 0) {
                a.this.gYA.bWl();
                a.this.gYA.bYu();
                a.this.gYA.a(a.h.sdk_network_not_available, new View.OnClickListener() { // from class: com.baidu.tieba.ala.live.personcenter.admin.c.a.2.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.gYA.Yb();
                        a.this.gYz.bYs();
                    }
                });
                return;
            }
            a.this.getPageContext().showToast(str, true);
        }
    };
    private b gYz;
    public String mLiveId;
    public TbPageContext pageContext;

    public TbPageContext getPageContext() {
        return this.pageContext;
    }

    public a(TbPageContext tbPageContext, View view, String str) {
        this.pageContext = tbPageContext;
        this.mLiveId = str;
        ci(view);
    }

    private void ci(View view) {
        this.gYz = new b(getPageContext());
        this.gYz.a(this.gYD);
        this.gYB = new e(getPageContext());
        this.gYA = new c(getPageContext(), view);
        this.gYA.setListPullRefreshListener(new TbListCommonPullView.ListPullRefreshListener() { // from class: com.baidu.tieba.ala.live.personcenter.admin.c.a.3
            @Override // com.baidu.live.tbadk.core.view.TbListCommonPullView.ListPullRefreshListener
            public void onListPullRefresh(boolean z) {
                a.this.gYz.bYs();
            }
        });
        this.gYA.bWl();
    }

    public void onCreate(Bundle bundle) {
        getPageContext().registerListener(this.gYC);
        this.gYz.bYs();
    }

    public void onChangeSkinType(int i) {
        if (this.gYA != null) {
            this.gYA.onChangeSkinType(i);
        }
    }
}
