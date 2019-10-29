package com.baidu.tieba.ala.live.personcenter.admin.c;

import android.os.Bundle;
import android.view.View;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.k.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.dialog.BdAlertDialog;
import com.baidu.live.tbadk.core.view.TbListCommonPullView;
import com.baidu.tieba.ala.live.personcenter.admin.c.b;
/* loaded from: classes6.dex */
public class a {
    private b dQS;
    private c dQT;
    private com.baidu.live.g.b dQU;
    private CustomMessageListener dQV = new CustomMessageListener(2913050, true) { // from class: com.baidu.tieba.ala.live.personcenter.admin.c.a.1
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
                        a.this.dQU.P(bVar.getUserId(), a.this.mLiveId);
                        a.this.dQS.a(bVar);
                    }
                });
                bdAlertDialog.create(a.this.getPageContext());
                bdAlertDialog.show();
            }
        }
    };
    private b.a dQW = new b.a() { // from class: com.baidu.tieba.ala.live.personcenter.admin.c.a.2
        @Override // com.baidu.tieba.ala.live.personcenter.admin.c.b.a
        public void gI(boolean z) {
            a.this.dQT.completePullRefresh();
            a.this.dQT.hideNoDataView();
            if (a.this.dQS.getUserList().size() == 0) {
                a.this.dQT.aLr();
                a.this.dQT.aMr();
                a.this.dQT.showNoDataView();
                return;
            }
            a.this.dQT.aJo();
            a.this.dQT.aMq();
            a.this.dQT.bz(a.this.dQS.getUserList());
            if (z) {
                a.this.dQT.aKW();
            } else {
                a.this.dQT.aLr();
            }
        }

        @Override // com.baidu.tieba.ala.live.personcenter.admin.c.b.a
        public void P(int i, String str) {
            a.this.dQT.completePullRefresh();
            a.this.dQT.hideNoDataView();
            if (a.this.dQS.getUserList().size() <= 0) {
                a.this.dQT.aLr();
                a.this.dQT.aMr();
                a.this.dQT.a(a.i.sdk_network_not_available, new View.OnClickListener() { // from class: com.baidu.tieba.ala.live.personcenter.admin.c.a.2.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.dQT.aJo();
                        a.this.dQS.aMp();
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
        bv(view);
    }

    private void bv(View view) {
        this.dQS = new b(getPageContext());
        this.dQS.a(this.dQW);
        this.dQU = new com.baidu.live.g.b(getPageContext());
        this.dQT = new c(getPageContext(), view);
        this.dQT.setListPullRefreshListener(new TbListCommonPullView.ListPullRefreshListener() { // from class: com.baidu.tieba.ala.live.personcenter.admin.c.a.3
            @Override // com.baidu.live.tbadk.core.view.TbListCommonPullView.ListPullRefreshListener
            public void onListPullRefresh(boolean z) {
                a.this.dQS.aMp();
            }
        });
        this.dQT.aLr();
    }

    public void onCreate(Bundle bundle) {
        getPageContext().registerListener(this.dQV);
        this.dQS.aMp();
    }

    public void onChangeSkinType(int i) {
        if (this.dQT != null) {
            this.dQT.onChangeSkinType(i);
        }
    }
}
