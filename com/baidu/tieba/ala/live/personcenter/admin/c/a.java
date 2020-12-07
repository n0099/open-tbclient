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
    private CustomMessageListener gYA = new CustomMessageListener(2913050, true) { // from class: com.baidu.tieba.ala.live.personcenter.admin.c.a.1
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
                        a.this.gYz.aK(bVar.getUserId(), a.this.mLiveId);
                        a.this.gYx.a(bVar);
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
    private b.a gYB = new b.a() { // from class: com.baidu.tieba.ala.live.personcenter.admin.c.a.2
        @Override // com.baidu.tieba.ala.live.personcenter.admin.c.b.a
        public void mn(boolean z) {
            a.this.gYy.completePullRefresh();
            a.this.gYy.hideNoDataView();
            if (a.this.gYx.getUserList().size() == 0) {
                a.this.gYy.bWk();
                a.this.gYy.bYt();
                a.this.gYy.showNoDataView();
                return;
            }
            a.this.gYy.Yb();
            a.this.gYy.bYs();
            a.this.gYy.f(a.this.gYx.getUserList(), a.this.gYx.bYp());
            if (z) {
                a.this.gYy.bVP();
            } else {
                a.this.gYy.bWk();
            }
        }

        @Override // com.baidu.tieba.ala.live.personcenter.admin.c.b.a
        public void aC(int i, String str) {
            a.this.gYy.completePullRefresh();
            a.this.gYy.hideNoDataView();
            if (a.this.gYx.getUserList().size() <= 0) {
                a.this.gYy.bWk();
                a.this.gYy.bYt();
                a.this.gYy.a(a.h.sdk_network_not_available, new View.OnClickListener() { // from class: com.baidu.tieba.ala.live.personcenter.admin.c.a.2.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.gYy.Yb();
                        a.this.gYx.bYr();
                    }
                });
                return;
            }
            a.this.getPageContext().showToast(str, true);
        }
    };
    private b gYx;
    private c gYy;
    private e gYz;
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
        this.gYx = new b(getPageContext());
        this.gYx.a(this.gYB);
        this.gYz = new e(getPageContext());
        this.gYy = new c(getPageContext(), view);
        this.gYy.setListPullRefreshListener(new TbListCommonPullView.ListPullRefreshListener() { // from class: com.baidu.tieba.ala.live.personcenter.admin.c.a.3
            @Override // com.baidu.live.tbadk.core.view.TbListCommonPullView.ListPullRefreshListener
            public void onListPullRefresh(boolean z) {
                a.this.gYx.bYr();
            }
        });
        this.gYy.bWk();
    }

    public void onCreate(Bundle bundle) {
        getPageContext().registerListener(this.gYA);
        this.gYx.bYr();
    }

    public void onChangeSkinType(int i) {
        if (this.gYy != null) {
            this.gYy.onChangeSkinType(i);
        }
    }
}
