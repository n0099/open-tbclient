package com.baidu.tieba.ala.live.personcenter.admin.c;

import android.os.Bundle;
import android.view.View;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.dialog.BdAlertDialog;
import com.baidu.live.tbadk.core.view.TbListCommonPullView;
import com.baidu.live.u.a;
import com.baidu.tieba.ala.live.personcenter.admin.c.b;
/* loaded from: classes3.dex */
public class a {
    private b fDJ;
    private c fDK;
    private com.baidu.live.n.b fDL;
    private CustomMessageListener fDM = new CustomMessageListener(2913050, true) { // from class: com.baidu.tieba.ala.live.personcenter.admin.c.a.1
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
                        a.this.fDL.aw(bVar.getUserId(), a.this.mLiveId);
                        a.this.fDJ.a(bVar);
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
    private b.a fDN = new b.a() { // from class: com.baidu.tieba.ala.live.personcenter.admin.c.a.2
        @Override // com.baidu.tieba.ala.live.personcenter.admin.c.b.a
        public void jz(boolean z) {
            a.this.fDK.completePullRefresh();
            a.this.fDK.hideNoDataView();
            if (a.this.fDJ.getUserList().size() == 0) {
                a.this.fDK.buy();
                a.this.fDK.bvN();
                a.this.fDK.showNoDataView();
                return;
            }
            a.this.fDK.bqO();
            a.this.fDK.bvM();
            a.this.fDK.e(a.this.fDJ.getUserList(), a.this.fDJ.bvJ());
            if (z) {
                a.this.fDK.bud();
            } else {
                a.this.fDK.buy();
            }
        }

        @Override // com.baidu.tieba.ala.live.personcenter.admin.c.b.a
        public void al(int i, String str) {
            a.this.fDK.completePullRefresh();
            a.this.fDK.hideNoDataView();
            if (a.this.fDJ.getUserList().size() <= 0) {
                a.this.fDK.buy();
                a.this.fDK.bvN();
                a.this.fDK.a(a.i.sdk_network_not_available, new View.OnClickListener() { // from class: com.baidu.tieba.ala.live.personcenter.admin.c.a.2.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.fDK.bqO();
                        a.this.fDJ.bvL();
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
        by(view);
    }

    private void by(View view) {
        this.fDJ = new b(getPageContext());
        this.fDJ.a(this.fDN);
        this.fDL = new com.baidu.live.n.b(getPageContext());
        this.fDK = new c(getPageContext(), view);
        this.fDK.setListPullRefreshListener(new TbListCommonPullView.ListPullRefreshListener() { // from class: com.baidu.tieba.ala.live.personcenter.admin.c.a.3
            @Override // com.baidu.live.tbadk.core.view.TbListCommonPullView.ListPullRefreshListener
            public void onListPullRefresh(boolean z) {
                a.this.fDJ.bvL();
            }
        });
        this.fDK.buy();
    }

    public void onCreate(Bundle bundle) {
        getPageContext().registerListener(this.fDM);
        this.fDJ.bvL();
    }

    public void onChangeSkinType(int i) {
        if (this.fDK != null) {
            this.fDK.onChangeSkinType(i);
        }
    }
}
