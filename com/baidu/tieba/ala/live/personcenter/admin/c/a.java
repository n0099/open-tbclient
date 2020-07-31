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
    private b fUw;
    private c fUx;
    private com.baidu.live.o.b fUy;
    public String mLiveId;
    public TbPageContext pageContext;
    private CustomMessageListener fUz = new CustomMessageListener(2913050, true) { // from class: com.baidu.tieba.ala.live.personcenter.admin.c.a.1
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
                        a.this.fUy.ax(bVar.getUserId(), a.this.mLiveId);
                        a.this.fUw.a(bVar);
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
    private b.a fUA = new b.a() { // from class: com.baidu.tieba.ala.live.personcenter.admin.c.a.2
        @Override // com.baidu.tieba.ala.live.personcenter.admin.c.b.a
        public void kq(boolean z) {
            a.this.fUx.completePullRefresh();
            a.this.fUx.hideNoDataView();
            if (a.this.fUw.getUserList().size() == 0) {
                a.this.fUx.bAM();
                a.this.fUx.bBZ();
                a.this.fUx.showNoDataView();
                return;
            }
            a.this.fUx.bwX();
            a.this.fUx.bBY();
            a.this.fUx.f(a.this.fUw.getUserList(), a.this.fUw.bBV());
            if (z) {
                a.this.fUx.bAr();
            } else {
                a.this.fUx.bAM();
            }
        }

        @Override // com.baidu.tieba.ala.live.personcenter.admin.c.b.a
        public void ao(int i, String str) {
            a.this.fUx.completePullRefresh();
            a.this.fUx.hideNoDataView();
            if (a.this.fUw.getUserList().size() <= 0) {
                a.this.fUx.bAM();
                a.this.fUx.bBZ();
                a.this.fUx.a(a.i.sdk_network_not_available, new View.OnClickListener() { // from class: com.baidu.tieba.ala.live.personcenter.admin.c.a.2.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.fUx.bwX();
                        a.this.fUw.bBX();
                    }
                });
                return;
            }
            a.this.getPageContext().showToast(str, true);
        }
    };

    public TbPageContext getPageContext() {
        return this.pageContext;
    }

    public a(TbPageContext tbPageContext, View view, String str) {
        this.pageContext = tbPageContext;
        this.mLiveId = str;
        bH(view);
    }

    private void bH(View view) {
        this.fUw = new b(getPageContext());
        this.fUw.a(this.fUA);
        this.fUy = new com.baidu.live.o.b(getPageContext());
        this.fUx = new c(getPageContext(), view);
        this.fUx.setListPullRefreshListener(new TbListCommonPullView.ListPullRefreshListener() { // from class: com.baidu.tieba.ala.live.personcenter.admin.c.a.3
            @Override // com.baidu.live.tbadk.core.view.TbListCommonPullView.ListPullRefreshListener
            public void onListPullRefresh(boolean z) {
                a.this.fUw.bBX();
            }
        });
        this.fUx.bAM();
    }

    public void onCreate(Bundle bundle) {
        getPageContext().registerListener(this.fUz);
        this.fUw.bBX();
    }

    public void onChangeSkinType(int i) {
        if (this.fUx != null) {
            this.fUx.onChangeSkinType(i);
        }
    }
}
