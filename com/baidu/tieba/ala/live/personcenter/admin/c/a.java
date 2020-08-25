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
    private b ggv;
    private c ggw;
    private com.baidu.live.o.b ggx;
    private CustomMessageListener ggy = new CustomMessageListener(2913050, true) { // from class: com.baidu.tieba.ala.live.personcenter.admin.c.a.1
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
                        a.this.ggx.aB(bVar.getUserId(), a.this.mLiveId);
                        a.this.ggv.a(bVar);
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
    private b.a ggz = new b.a() { // from class: com.baidu.tieba.ala.live.personcenter.admin.c.a.2
        @Override // com.baidu.tieba.ala.live.personcenter.admin.c.b.a
        public void kO(boolean z) {
            a.this.ggw.completePullRefresh();
            a.this.ggw.hideNoDataView();
            if (a.this.ggv.getUserList().size() == 0) {
                a.this.ggw.bKh();
                a.this.ggw.bLt();
                a.this.ggw.showNoDataView();
                return;
            }
            a.this.ggw.bFW();
            a.this.ggw.bLs();
            a.this.ggw.f(a.this.ggv.getUserList(), a.this.ggv.bLp());
            if (z) {
                a.this.ggw.bJM();
            } else {
                a.this.ggw.bKh();
            }
        }

        @Override // com.baidu.tieba.ala.live.personcenter.admin.c.b.a
        public void am(int i, String str) {
            a.this.ggw.completePullRefresh();
            a.this.ggw.hideNoDataView();
            if (a.this.ggv.getUserList().size() <= 0) {
                a.this.ggw.bKh();
                a.this.ggw.bLt();
                a.this.ggw.a(a.i.sdk_network_not_available, new View.OnClickListener() { // from class: com.baidu.tieba.ala.live.personcenter.admin.c.a.2.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.ggw.bFW();
                        a.this.ggv.bLr();
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
        bJ(view);
    }

    private void bJ(View view) {
        this.ggv = new b(getPageContext());
        this.ggv.a(this.ggz);
        this.ggx = new com.baidu.live.o.b(getPageContext());
        this.ggw = new c(getPageContext(), view);
        this.ggw.setListPullRefreshListener(new TbListCommonPullView.ListPullRefreshListener() { // from class: com.baidu.tieba.ala.live.personcenter.admin.c.a.3
            @Override // com.baidu.live.tbadk.core.view.TbListCommonPullView.ListPullRefreshListener
            public void onListPullRefresh(boolean z) {
                a.this.ggv.bLr();
            }
        });
        this.ggw.bKh();
    }

    public void onCreate(Bundle bundle) {
        getPageContext().registerListener(this.ggy);
        this.ggv.bLr();
    }

    public void onChangeSkinType(int i) {
        if (this.ggw != null) {
            this.ggw.onChangeSkinType(i);
        }
    }
}
