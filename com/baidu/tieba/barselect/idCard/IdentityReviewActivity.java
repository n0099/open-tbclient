package com.baidu.tieba.barselect.idCard;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.g.g;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.CameraActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.barselect.data.CommitCardInfoReqMsg;
import java.io.File;
/* loaded from: classes3.dex */
public class IdentityReviewActivity extends BaseActivity {
    private com.baidu.tieba.barselect.data.c ero;
    private com.baidu.tieba.barselect.data.b esU;
    public String esV;
    public String esW;
    private View esX;
    private TextView esY;
    private TextView esZ;
    private TextView eta;
    private TextView etb;
    private TbImageView etd;
    private TbImageView ete;
    private TextView etf;
    private TextView etg;
    private com.baidu.tieba.barselect.view.a eth;
    private long forumId;
    private NavigationBar mNavigationBar;
    private boolean needRetry = false;
    private int eti = 0;
    private int etj = 0;
    private View.OnClickListener ckH = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.IdentityReviewActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == R.id.identity_card_positive) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2921412, new CameraActivityConfig(IdentityReviewActivity.this, IdentityReviewActivity.this.esV, CameraActivityConfig.CONTENT_TYPE_ID_CARD_FRONT, 101)));
            } else if (view.getId() == R.id.identity_card_negative) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2921412, new CameraActivityConfig(IdentityReviewActivity.this, IdentityReviewActivity.this.esW, CameraActivityConfig.CONTENT_TYPE_ID_CARD_BACK, 102)));
            } else if (view.getId() == R.id.bottom_next_button) {
                new a(IdentityReviewActivity.this.esV, 1, IdentityReviewActivity.this.ero).execute(new Void[0]);
                IdentityReviewActivity.this.needRetry = true;
                IdentityReviewActivity.this.eth = new com.baidu.tieba.barselect.view.a(IdentityReviewActivity.this);
                IdentityReviewActivity.this.eth.setCancelable(true);
                IdentityReviewActivity.this.eth.setCanceledOnTouchOutside(false);
                IdentityReviewActivity.this.eth.setMessage(TbadkCoreApplication.getInst().getString(R.string.check_id_card));
                g.a(IdentityReviewActivity.this.eth, IdentityReviewActivity.this);
            }
        }
    };
    com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a> cuu = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.barselect.idCard.IdentityReviewActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.f.b
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            super.onLoaded((AnonymousClass2) aVar, str, i);
            if (str != null && aVar != null) {
                if (str.equals(IdentityReviewActivity.this.esV)) {
                    aVar.a(IdentityReviewActivity.this.etd);
                    IdentityReviewActivity.this.etf.setVisibility(0);
                } else if (str.equals(IdentityReviewActivity.this.esW)) {
                    aVar.a(IdentityReviewActivity.this.ete);
                    IdentityReviewActivity.this.etg.setVisibility(0);
                }
            }
            if (str != null) {
                com.baidu.tbadk.imageManager.c.asp().qp(str + 32);
            }
        }
    };
    com.baidu.adp.framework.listener.a byk = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_COMMIT_CARD_INFO, 309643) { // from class: com.baidu.tieba.barselect.idCard.IdentityReviewActivity.3
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage != null && responsedMessage.getOrginalMessage() != null) {
                int error = responsedMessage.getError();
                Object extra = responsedMessage.getOrginalMessage().getExtra();
                if (extra instanceof CommitCardInfoReqMsg) {
                    if (error == 0) {
                        if (((CommitCardInfoReqMsg) extra).card_type == 1) {
                            IdentityReviewActivity.this.eti = 2;
                        } else if (((CommitCardInfoReqMsg) extra).card_type == 2) {
                            IdentityReviewActivity.this.etj = 2;
                        }
                        if (IdentityReviewActivity.this.eti < 2 || IdentityReviewActivity.this.etj < 2) {
                            if (IdentityReviewActivity.this.etj == 1) {
                                if (IdentityReviewActivity.this.ero == null) {
                                    if (IdentityReviewActivity.this.eth != null) {
                                        g.b(IdentityReviewActivity.this.eth, IdentityReviewActivity.this);
                                        return;
                                    }
                                    return;
                                }
                                new a(IdentityReviewActivity.this.esW, 2, IdentityReviewActivity.this.ero).execute(new Void[0]);
                            }
                        } else if (IdentityReviewActivity.this.esU != null) {
                            IdentityReviewActivity.this.esU.cv(IdentityReviewActivity.this.forumId);
                        } else if (IdentityReviewActivity.this.eth != null) {
                            g.b(IdentityReviewActivity.this.eth, IdentityReviewActivity.this);
                        }
                    } else if (error != -100000303 || !IdentityReviewActivity.this.needRetry) {
                        if (IdentityReviewActivity.this.eth != null && IdentityReviewActivity.this.eth.isShowing()) {
                            g.b(IdentityReviewActivity.this.eth, IdentityReviewActivity.this);
                        }
                        l.E(TbadkCoreApplication.getInst(), responsedMessage.getErrorString());
                        IdentityReviewActivity.this.eti = 1;
                        IdentityReviewActivity.this.etj = 1;
                    } else {
                        IdentityReviewActivity.this.eti = 1;
                        IdentityReviewActivity.this.etj = 1;
                        if (IdentityReviewActivity.this.ero != null) {
                            IdentityReviewActivity.this.needRetry = false;
                            new a(IdentityReviewActivity.this.esV, 1, IdentityReviewActivity.this.ero).execute(new Void[0]);
                        }
                    }
                }
            }
        }
    };
    HttpMessageListener mHttpMessageListener = new HttpMessageListener(CmdConfigHttp.CMD_CHECK_CARD_INFO) { // from class: com.baidu.tieba.barselect.idCard.IdentityReviewActivity.4
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX DEBUG: Multi-variable search result rejected for r2v3, resolved type: com.baidu.tieba.barselect.idCard.IdentityReviewActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getOrginalMessage() != null) {
                int error = httpResponsedMessage.getError();
                if (IdentityReviewActivity.this.eth != null && IdentityReviewActivity.this.eth.isShowing()) {
                    g.b(IdentityReviewActivity.this.eth, IdentityReviewActivity.this);
                }
                String str = "https://tieba.baidu.com/mo/q/newmanagerapplyresult?passIDCert=1&nomenu=1&forum_id=" + IdentityReviewActivity.this.forumId;
                if (error == 0) {
                    ba.aiz().c(IdentityReviewActivity.this.getPageContext(), new String[]{str});
                    IdentityReviewActivity.this.setResult(-1);
                    IdentityReviewActivity.this.finish();
                    return;
                }
                l.E(TbadkCoreApplication.getInst(), httpResponsedMessage.getErrorString());
                IdentityReviewActivity.this.eti = 1;
                IdentityReviewActivity.this.etj = 1;
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.identity_review_activity);
        this.forumId = getIntent().getLongExtra("fid", 0L);
        this.ero = new com.baidu.tieba.barselect.data.c(getPageContext());
        this.esU = new com.baidu.tieba.barselect.data.b(getPageContext());
        this.esV = new File(TbadkCoreApplication.getInst().getFilesDir(), "positive.jpg").getAbsolutePath();
        this.esW = new File(TbadkCoreApplication.getInst().getFilesDir(), "negative.jpg").getAbsolutePath();
        this.esX = findViewById(R.id.id_card_view);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.id_review_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(getResources().getString(R.string.bar_manager_apply));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.esY = (TextView) findViewById(R.id.bottom_next_button);
        this.esY.setEnabled(false);
        this.esZ = (TextView) findViewById(R.id.identity_view_title);
        this.eta = (TextView) findViewById(R.id.positive_card_coloct_tip);
        this.etb = (TextView) findViewById(R.id.negative_card_coloct_tip);
        this.etd = (TbImageView) findViewById(R.id.identity_card_positive);
        this.ete = (TbImageView) findViewById(R.id.identity_card_negative);
        this.etf = (TextView) findViewById(R.id.identity_card_positive_logo);
        this.etg = (TextView) findViewById(R.id.identity_card_negative_logo);
        MessageManager.getInstance().registerListener(this.byk);
        MessageManager.getInstance().registerListener(this.mHttpMessageListener);
        this.etd.setOnClickListener(this.ckH);
        this.ete.setOnClickListener(this.ckH);
        this.esY.setOnClickListener(this.ckH);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        }
        al.c(this.esY, R.color.cp_btn_a, 1, i);
        al.g(this.esY, R.drawable.bg_id_card_button, i);
        al.c(this.esZ, R.color.cp_cont_b, 1, i);
        al.c(this.eta, R.color.cp_cont_d, 1, i);
        al.c(this.etb, R.color.cp_cont_d, 1, i);
        int g = l.g(this, R.dimen.tbds10);
        al.c(this.etf, R.color.cp_btn_a, 1, i);
        al.c(this.etg, R.color.cp_btn_a, 1, i);
        al.b(this.etf, g, (int) R.color.cp_cont_b_alpha42, (int) R.color.cp_cont_b_alpha42, i);
        al.b(this.etg, g, (int) R.color.cp_cont_b_alpha42, (int) R.color.cp_cont_b_alpha42, i);
        if (this.eti < 1) {
            al.b(this.etd, (int) R.drawable.pic_id_front, i);
        }
        if (this.etj < 1) {
            al.b(this.ete, (int) R.drawable.pic_id_back, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if (i == 101) {
                com.baidu.adp.lib.f.c.iv().a(this.esV, 32, this.cuu, getUniqueId());
                this.eti = 1;
            } else if (i == 102) {
                com.baidu.adp.lib.f.c.iv().a(this.esW, 32, this.cuu, getUniqueId());
                this.etj = 1;
            }
            if (this.esY != null) {
                if (this.etj >= 1 && this.eti >= 1) {
                    this.esY.setEnabled(true);
                } else {
                    this.esY.setEnabled(false);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.byk);
        MessageManager.getInstance().unRegisterListener(this.mHttpMessageListener);
        if (this.eth != null && this.eth.isShowing()) {
            g.b(this.eth, this);
        }
        super.onDestroy();
    }
}
