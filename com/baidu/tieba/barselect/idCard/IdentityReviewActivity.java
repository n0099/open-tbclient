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
import com.baidu.adp.lib.f.g;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.CameraActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.barselect.data.CommitCardInfoReqMsg;
import java.io.File;
/* loaded from: classes6.dex */
public class IdentityReviewActivity extends BaseActivity {
    private com.baidu.tieba.barselect.data.c fBe;
    private com.baidu.tieba.barselect.data.b fCI;
    public String fCJ;
    public String fCK;
    private View fCL;
    private TextView fCM;
    private TextView fCN;
    private TextView fCO;
    private TextView fCP;
    private TbImageView fCQ;
    private TbImageView fCR;
    private TextView fCS;
    private TextView fCT;
    private com.baidu.tieba.barselect.view.a fCU;
    private long forumId;
    private NavigationBar mNavigationBar;
    private boolean needRetry = false;
    private int fCV = 0;
    private int fCW = 0;
    private View.OnClickListener dmY = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.IdentityReviewActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == R.id.identity_card_positive) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2921412, new CameraActivityConfig(IdentityReviewActivity.this, IdentityReviewActivity.this.fCJ, CameraActivityConfig.CONTENT_TYPE_ID_CARD_FRONT, 101)));
            } else if (view.getId() == R.id.identity_card_negative) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2921412, new CameraActivityConfig(IdentityReviewActivity.this, IdentityReviewActivity.this.fCK, CameraActivityConfig.CONTENT_TYPE_ID_CARD_BACK, 102)));
            } else if (view.getId() == R.id.bottom_next_button) {
                new a(IdentityReviewActivity.this.fCJ, 1, IdentityReviewActivity.this.fBe).execute(new Void[0]);
                IdentityReviewActivity.this.needRetry = true;
                IdentityReviewActivity.this.fCU = new com.baidu.tieba.barselect.view.a(IdentityReviewActivity.this);
                IdentityReviewActivity.this.fCU.setCancelable(true);
                IdentityReviewActivity.this.fCU.setCanceledOnTouchOutside(false);
                IdentityReviewActivity.this.fCU.setMessage(TbadkCoreApplication.getInst().getString(R.string.check_id_card));
                g.showDialog(IdentityReviewActivity.this.fCU, IdentityReviewActivity.this);
            }
        }
    };
    com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a> dwc = new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.barselect.idCard.IdentityReviewActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.e.b
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            super.onLoaded((AnonymousClass2) aVar, str, i);
            if (str != null && aVar != null) {
                if (str.equals(IdentityReviewActivity.this.fCJ)) {
                    aVar.drawImageTo(IdentityReviewActivity.this.fCQ);
                    IdentityReviewActivity.this.fCS.setVisibility(0);
                } else if (str.equals(IdentityReviewActivity.this.fCK)) {
                    aVar.drawImageTo(IdentityReviewActivity.this.fCR);
                    IdentityReviewActivity.this.fCT.setVisibility(0);
                }
            }
            if (str != null) {
                com.baidu.tbadk.imageManager.c.aNs().deletePic(str + 32);
            }
        }
    };
    com.baidu.adp.framework.listener.a cDZ = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_COMMIT_CARD_INFO, 309643) { // from class: com.baidu.tieba.barselect.idCard.IdentityReviewActivity.3
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage != null && responsedMessage.getOrginalMessage() != null) {
                int error = responsedMessage.getError();
                Object extra = responsedMessage.getOrginalMessage().getExtra();
                if (extra instanceof CommitCardInfoReqMsg) {
                    if (error == 0) {
                        if (((CommitCardInfoReqMsg) extra).card_type == 1) {
                            IdentityReviewActivity.this.fCV = 2;
                        } else if (((CommitCardInfoReqMsg) extra).card_type == 2) {
                            IdentityReviewActivity.this.fCW = 2;
                        }
                        if (IdentityReviewActivity.this.fCV < 2 || IdentityReviewActivity.this.fCW < 2) {
                            if (IdentityReviewActivity.this.fCW == 1) {
                                if (IdentityReviewActivity.this.fBe == null) {
                                    if (IdentityReviewActivity.this.fCU != null) {
                                        g.dismissDialog(IdentityReviewActivity.this.fCU, IdentityReviewActivity.this);
                                        return;
                                    }
                                    return;
                                }
                                new a(IdentityReviewActivity.this.fCK, 2, IdentityReviewActivity.this.fBe).execute(new Void[0]);
                            }
                        } else if (IdentityReviewActivity.this.fCI != null) {
                            IdentityReviewActivity.this.fCI.de(IdentityReviewActivity.this.forumId);
                        } else if (IdentityReviewActivity.this.fCU != null) {
                            g.dismissDialog(IdentityReviewActivity.this.fCU, IdentityReviewActivity.this);
                        }
                    } else if (error != -100000303 || !IdentityReviewActivity.this.needRetry) {
                        if (IdentityReviewActivity.this.fCU != null && IdentityReviewActivity.this.fCU.isShowing()) {
                            g.dismissDialog(IdentityReviewActivity.this.fCU, IdentityReviewActivity.this);
                        }
                        l.showLongToast(TbadkCoreApplication.getInst(), responsedMessage.getErrorString());
                        IdentityReviewActivity.this.fCV = 1;
                        IdentityReviewActivity.this.fCW = 1;
                    } else {
                        IdentityReviewActivity.this.fCV = 1;
                        IdentityReviewActivity.this.fCW = 1;
                        if (IdentityReviewActivity.this.fBe != null) {
                            IdentityReviewActivity.this.needRetry = false;
                            new a(IdentityReviewActivity.this.fCJ, 1, IdentityReviewActivity.this.fBe).execute(new Void[0]);
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
                if (IdentityReviewActivity.this.fCU != null && IdentityReviewActivity.this.fCU.isShowing()) {
                    g.dismissDialog(IdentityReviewActivity.this.fCU, IdentityReviewActivity.this);
                }
                String str = "https://tieba.baidu.com/mo/q/newmanagerapplyresult?passIDCert=1&nomenu=1&forum_id=" + IdentityReviewActivity.this.forumId;
                if (error == 0) {
                    ba.aEt().b(IdentityReviewActivity.this.getPageContext(), new String[]{str});
                    IdentityReviewActivity.this.setResult(-1);
                    IdentityReviewActivity.this.finish();
                    return;
                }
                l.showLongToast(TbadkCoreApplication.getInst(), httpResponsedMessage.getErrorString());
                IdentityReviewActivity.this.fCV = 1;
                IdentityReviewActivity.this.fCW = 1;
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.identity_review_activity);
        this.forumId = getIntent().getLongExtra("fid", 0L);
        this.fBe = new com.baidu.tieba.barselect.data.c(getPageContext());
        this.fCI = new com.baidu.tieba.barselect.data.b(getPageContext());
        this.fCJ = new File(TbadkCoreApplication.getInst().getFilesDir(), "positive.jpg").getAbsolutePath();
        this.fCK = new File(TbadkCoreApplication.getInst().getFilesDir(), "negative.jpg").getAbsolutePath();
        this.fCL = findViewById(R.id.id_card_view);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.id_review_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(getResources().getString(R.string.bar_manager_apply));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.fCM = (TextView) findViewById(R.id.bottom_next_button);
        this.fCM.setEnabled(false);
        this.fCN = (TextView) findViewById(R.id.identity_view_title);
        this.fCO = (TextView) findViewById(R.id.positive_card_coloct_tip);
        this.fCP = (TextView) findViewById(R.id.negative_card_coloct_tip);
        this.fCQ = (TbImageView) findViewById(R.id.identity_card_positive);
        this.fCR = (TbImageView) findViewById(R.id.identity_card_negative);
        this.fCS = (TextView) findViewById(R.id.identity_card_positive_logo);
        this.fCT = (TextView) findViewById(R.id.identity_card_negative_logo);
        MessageManager.getInstance().registerListener(this.cDZ);
        MessageManager.getInstance().registerListener(this.mHttpMessageListener);
        this.fCQ.setOnClickListener(this.dmY);
        this.fCR.setOnClickListener(this.dmY);
        this.fCM.setOnClickListener(this.dmY);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        }
        am.setViewTextColor(this.fCM, R.color.cp_cont_a, 1, i);
        am.setBackgroundResource(this.fCM, R.drawable.bg_id_card_button, i);
        am.setViewTextColor(this.fCN, R.color.cp_cont_b, 1, i);
        am.setViewTextColor(this.fCO, R.color.cp_cont_d, 1, i);
        am.setViewTextColor(this.fCP, R.color.cp_cont_d, 1, i);
        int dimens = l.getDimens(this, R.dimen.tbds10);
        am.setViewTextColor(this.fCS, R.color.cp_cont_a, 1, i);
        am.setViewTextColor(this.fCT, R.color.cp_cont_a, 1, i);
        am.c(this.fCS, dimens, (int) R.color.cp_cont_b_alpha42, (int) R.color.cp_cont_b_alpha42, i);
        am.c(this.fCT, dimens, (int) R.color.cp_cont_b_alpha42, (int) R.color.cp_cont_b_alpha42, i);
        if (this.fCV < 1) {
            am.setImageResource(this.fCQ, R.drawable.pic_id_front, i);
        }
        if (this.fCW < 1) {
            am.setImageResource(this.fCR, R.drawable.pic_id_back, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if (i == 101) {
                com.baidu.adp.lib.e.c.gr().a(this.fCJ, 32, this.dwc, getUniqueId());
                this.fCV = 1;
            } else if (i == 102) {
                com.baidu.adp.lib.e.c.gr().a(this.fCK, 32, this.dwc, getUniqueId());
                this.fCW = 1;
            }
            if (this.fCM != null) {
                if (this.fCW >= 1 && this.fCV >= 1) {
                    this.fCM.setEnabled(true);
                } else {
                    this.fCM.setEnabled(false);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.cDZ);
        MessageManager.getInstance().unRegisterListener(this.mHttpMessageListener);
        if (this.fCU != null && this.fCU.isShowing()) {
            g.dismissDialog(this.fCU, this);
        }
        super.onDestroy();
    }
}
