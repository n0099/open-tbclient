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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.barselect.data.CommitCardInfoReqMsg;
import java.io.File;
/* loaded from: classes8.dex */
public class IdentityReviewActivity extends BaseActivity {
    private long forumId;
    private com.baidu.tieba.barselect.data.c gKX;
    private com.baidu.tieba.barselect.data.b gMA;
    public String gMB;
    public String gMC;
    private View gMD;
    private TextView gME;
    private TextView gMF;
    private TextView gMG;
    private TextView gMH;
    private TbImageView gMI;
    private TbImageView gMJ;
    private TextView gMK;
    private TextView gML;
    private com.baidu.tieba.barselect.view.a gMM;
    private NavigationBar mNavigationBar;
    private boolean needRetry = false;
    private int gMN = 0;
    private int gMO = 0;
    private View.OnClickListener eoP = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.IdentityReviewActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == R.id.identity_card_positive) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2921412, new CameraActivityConfig(IdentityReviewActivity.this, IdentityReviewActivity.this.gMB, CameraActivityConfig.CONTENT_TYPE_ID_CARD_FRONT, 101)));
            } else if (view.getId() == R.id.identity_card_negative) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2921412, new CameraActivityConfig(IdentityReviewActivity.this, IdentityReviewActivity.this.gMC, CameraActivityConfig.CONTENT_TYPE_ID_CARD_BACK, 102)));
            } else if (view.getId() == R.id.bottom_next_button) {
                new a(IdentityReviewActivity.this.gMB, 1, IdentityReviewActivity.this.gKX).execute(new Void[0]);
                IdentityReviewActivity.this.needRetry = true;
                IdentityReviewActivity.this.gMM = new com.baidu.tieba.barselect.view.a(IdentityReviewActivity.this);
                IdentityReviewActivity.this.gMM.setCancelable(true);
                IdentityReviewActivity.this.gMM.setCanceledOnTouchOutside(false);
                IdentityReviewActivity.this.gMM.setMessage(TbadkCoreApplication.getInst().getString(R.string.check_id_card));
                g.showDialog(IdentityReviewActivity.this.gMM, IdentityReviewActivity.this);
            }
        }
    };
    com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a> exy = new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.barselect.idCard.IdentityReviewActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.e.b
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            super.onLoaded((AnonymousClass2) aVar, str, i);
            if (str != null && aVar != null) {
                if (str.equals(IdentityReviewActivity.this.gMB)) {
                    aVar.drawImageTo(IdentityReviewActivity.this.gMI);
                    IdentityReviewActivity.this.gMK.setVisibility(0);
                } else if (str.equals(IdentityReviewActivity.this.gMC)) {
                    aVar.drawImageTo(IdentityReviewActivity.this.gMJ);
                    IdentityReviewActivity.this.gML.setVisibility(0);
                }
            }
            if (str != null) {
                com.baidu.tbadk.imageManager.c.bgz().deletePic(str + 32);
            }
        }
    };
    com.baidu.adp.framework.listener.a dzN = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_COMMIT_CARD_INFO, 309643) { // from class: com.baidu.tieba.barselect.idCard.IdentityReviewActivity.3
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage != null && responsedMessage.getOrginalMessage() != null) {
                int error = responsedMessage.getError();
                Object extra = responsedMessage.getOrginalMessage().getExtra();
                if (extra instanceof CommitCardInfoReqMsg) {
                    if (error == 0) {
                        if (((CommitCardInfoReqMsg) extra).card_type == 1) {
                            IdentityReviewActivity.this.gMN = 2;
                        } else if (((CommitCardInfoReqMsg) extra).card_type == 2) {
                            IdentityReviewActivity.this.gMO = 2;
                        }
                        if (IdentityReviewActivity.this.gMN < 2 || IdentityReviewActivity.this.gMO < 2) {
                            if (IdentityReviewActivity.this.gMO == 1) {
                                if (IdentityReviewActivity.this.gKX == null) {
                                    if (IdentityReviewActivity.this.gMM != null) {
                                        g.dismissDialog(IdentityReviewActivity.this.gMM, IdentityReviewActivity.this);
                                        return;
                                    }
                                    return;
                                }
                                new a(IdentityReviewActivity.this.gMC, 2, IdentityReviewActivity.this.gKX).execute(new Void[0]);
                            }
                        } else if (IdentityReviewActivity.this.gMA != null) {
                            IdentityReviewActivity.this.gMA.dS(IdentityReviewActivity.this.forumId);
                        } else if (IdentityReviewActivity.this.gMM != null) {
                            g.dismissDialog(IdentityReviewActivity.this.gMM, IdentityReviewActivity.this);
                        }
                    } else if (error != -100000303 || !IdentityReviewActivity.this.needRetry) {
                        if (IdentityReviewActivity.this.gMM != null && IdentityReviewActivity.this.gMM.isShowing()) {
                            g.dismissDialog(IdentityReviewActivity.this.gMM, IdentityReviewActivity.this);
                        }
                        l.showLongToast(TbadkCoreApplication.getInst(), responsedMessage.getErrorString());
                        IdentityReviewActivity.this.gMN = 1;
                        IdentityReviewActivity.this.gMO = 1;
                    } else {
                        IdentityReviewActivity.this.gMN = 1;
                        IdentityReviewActivity.this.gMO = 1;
                        if (IdentityReviewActivity.this.gKX != null) {
                            IdentityReviewActivity.this.needRetry = false;
                            new a(IdentityReviewActivity.this.gMB, 1, IdentityReviewActivity.this.gKX).execute(new Void[0]);
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
                if (IdentityReviewActivity.this.gMM != null && IdentityReviewActivity.this.gMM.isShowing()) {
                    g.dismissDialog(IdentityReviewActivity.this.gMM, IdentityReviewActivity.this);
                }
                String str = "https://tieba.baidu.com/mo/q/newmanagerapplyresult?passIDCert=1&nomenu=1&forum_id=" + IdentityReviewActivity.this.forumId;
                if (error == 0) {
                    bc.aWU().b(IdentityReviewActivity.this.getPageContext(), new String[]{str});
                    IdentityReviewActivity.this.setResult(-1);
                    IdentityReviewActivity.this.finish();
                    return;
                }
                l.showLongToast(TbadkCoreApplication.getInst(), httpResponsedMessage.getErrorString());
                IdentityReviewActivity.this.gMN = 1;
                IdentityReviewActivity.this.gMO = 1;
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.identity_review_activity);
        this.forumId = getIntent().getLongExtra("fid", 0L);
        this.gKX = new com.baidu.tieba.barselect.data.c(getPageContext());
        this.gMA = new com.baidu.tieba.barselect.data.b(getPageContext());
        this.gMB = new File(TbadkCoreApplication.getInst().getFilesDir(), "positive.jpg").getAbsolutePath();
        this.gMC = new File(TbadkCoreApplication.getInst().getFilesDir(), "negative.jpg").getAbsolutePath();
        this.gMD = findViewById(R.id.id_card_view);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.id_review_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(getResources().getString(R.string.bar_manager_apply));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.gME = (TextView) findViewById(R.id.bottom_next_button);
        this.gME.setEnabled(false);
        this.gMF = (TextView) findViewById(R.id.identity_view_title);
        this.gMG = (TextView) findViewById(R.id.positive_card_coloct_tip);
        this.gMH = (TextView) findViewById(R.id.negative_card_coloct_tip);
        this.gMI = (TbImageView) findViewById(R.id.identity_card_positive);
        this.gMJ = (TbImageView) findViewById(R.id.identity_card_negative);
        this.gMK = (TextView) findViewById(R.id.identity_card_positive_logo);
        this.gML = (TextView) findViewById(R.id.identity_card_negative_logo);
        MessageManager.getInstance().registerListener(this.dzN);
        MessageManager.getInstance().registerListener(this.mHttpMessageListener);
        this.gMI.setOnClickListener(this.eoP);
        this.gMJ.setOnClickListener(this.eoP);
        this.gME.setOnClickListener(this.eoP);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        }
        an.setViewTextColor(this.gME, R.color.cp_cont_a, 1, i);
        an.setBackgroundResource(this.gME, R.drawable.bg_id_card_button, i);
        an.setViewTextColor(this.gMF, R.color.cp_cont_b, 1, i);
        an.setViewTextColor(this.gMG, R.color.cp_cont_d, 1, i);
        an.setViewTextColor(this.gMH, R.color.cp_cont_d, 1, i);
        int dimens = l.getDimens(this, R.dimen.tbds10);
        an.setViewTextColor(this.gMK, R.color.cp_cont_a, 1, i);
        an.setViewTextColor(this.gML, R.color.cp_cont_a, 1, i);
        an.c(this.gMK, dimens, (int) R.color.cp_cont_b_alpha42, (int) R.color.cp_cont_b_alpha42, i);
        an.c(this.gML, dimens, (int) R.color.cp_cont_b_alpha42, (int) R.color.cp_cont_b_alpha42, i);
        if (this.gMN < 1) {
            an.setImageResource(this.gMI, R.drawable.pic_id_front, i);
        }
        if (this.gMO < 1) {
            an.setImageResource(this.gMJ, R.drawable.pic_id_back, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if (i == 101) {
                com.baidu.adp.lib.e.c.ln().a(this.gMB, 32, this.exy, getUniqueId());
                this.gMN = 1;
            } else if (i == 102) {
                com.baidu.adp.lib.e.c.ln().a(this.gMC, 32, this.exy, getUniqueId());
                this.gMO = 1;
            }
            if (this.gME != null) {
                if (this.gMO >= 1 && this.gMN >= 1) {
                    this.gME.setEnabled(true);
                } else {
                    this.gME.setEnabled(false);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.dzN);
        MessageManager.getInstance().unRegisterListener(this.mHttpMessageListener);
        if (this.gMM != null && this.gMM.isShowing()) {
            g.dismissDialog(this.gMM, this);
        }
        super.onDestroy();
    }
}
