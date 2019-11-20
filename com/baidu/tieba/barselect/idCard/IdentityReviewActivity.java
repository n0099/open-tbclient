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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.barselect.data.CommitCardInfoReqMsg;
import java.io.File;
/* loaded from: classes3.dex */
public class IdentityReviewActivity extends BaseActivity {
    private com.baidu.tieba.barselect.data.c eFV;
    private com.baidu.tieba.barselect.data.b eHA;
    public String eHB;
    public String eHC;
    private View eHD;
    private TextView eHE;
    private TextView eHF;
    private TextView eHG;
    private TextView eHH;
    private TbImageView eHI;
    private TbImageView eHJ;
    private TextView eHK;
    private TextView eHL;
    private com.baidu.tieba.barselect.view.a eHM;
    private long forumId;
    private NavigationBar mNavigationBar;
    private boolean needRetry = false;
    private int eHN = 0;
    private int eHO = 0;
    private View.OnClickListener cze = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.IdentityReviewActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == R.id.identity_card_positive) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2921412, new CameraActivityConfig(IdentityReviewActivity.this, IdentityReviewActivity.this.eHB, CameraActivityConfig.CONTENT_TYPE_ID_CARD_FRONT, 101)));
            } else if (view.getId() == R.id.identity_card_negative) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2921412, new CameraActivityConfig(IdentityReviewActivity.this, IdentityReviewActivity.this.eHC, CameraActivityConfig.CONTENT_TYPE_ID_CARD_BACK, 102)));
            } else if (view.getId() == R.id.bottom_next_button) {
                new a(IdentityReviewActivity.this.eHB, 1, IdentityReviewActivity.this.eFV).execute(new Void[0]);
                IdentityReviewActivity.this.needRetry = true;
                IdentityReviewActivity.this.eHM = new com.baidu.tieba.barselect.view.a(IdentityReviewActivity.this);
                IdentityReviewActivity.this.eHM.setCancelable(true);
                IdentityReviewActivity.this.eHM.setCanceledOnTouchOutside(false);
                IdentityReviewActivity.this.eHM.setMessage(TbadkCoreApplication.getInst().getString(R.string.check_id_card));
                g.showDialog(IdentityReviewActivity.this.eHM, IdentityReviewActivity.this);
            }
        }
    };
    com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a> cIe = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.barselect.idCard.IdentityReviewActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.f.b
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            super.onLoaded((AnonymousClass2) aVar, str, i);
            if (str != null && aVar != null) {
                if (str.equals(IdentityReviewActivity.this.eHB)) {
                    aVar.drawImageTo(IdentityReviewActivity.this.eHI);
                    IdentityReviewActivity.this.eHK.setVisibility(0);
                } else if (str.equals(IdentityReviewActivity.this.eHC)) {
                    aVar.drawImageTo(IdentityReviewActivity.this.eHJ);
                    IdentityReviewActivity.this.eHL.setVisibility(0);
                }
            }
            if (str != null) {
                com.baidu.tbadk.imageManager.c.avs().deletePic(str + 32);
            }
        }
    };
    com.baidu.adp.framework.listener.a bRo = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_COMMIT_CARD_INFO, 309643) { // from class: com.baidu.tieba.barselect.idCard.IdentityReviewActivity.3
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage != null && responsedMessage.getOrginalMessage() != null) {
                int error = responsedMessage.getError();
                Object extra = responsedMessage.getOrginalMessage().getExtra();
                if (extra instanceof CommitCardInfoReqMsg) {
                    if (error == 0) {
                        if (((CommitCardInfoReqMsg) extra).card_type == 1) {
                            IdentityReviewActivity.this.eHN = 2;
                        } else if (((CommitCardInfoReqMsg) extra).card_type == 2) {
                            IdentityReviewActivity.this.eHO = 2;
                        }
                        if (IdentityReviewActivity.this.eHN < 2 || IdentityReviewActivity.this.eHO < 2) {
                            if (IdentityReviewActivity.this.eHO == 1) {
                                if (IdentityReviewActivity.this.eFV == null) {
                                    if (IdentityReviewActivity.this.eHM != null) {
                                        g.dismissDialog(IdentityReviewActivity.this.eHM, IdentityReviewActivity.this);
                                        return;
                                    }
                                    return;
                                }
                                new a(IdentityReviewActivity.this.eHC, 2, IdentityReviewActivity.this.eFV).execute(new Void[0]);
                            }
                        } else if (IdentityReviewActivity.this.eHA != null) {
                            IdentityReviewActivity.this.eHA.cq(IdentityReviewActivity.this.forumId);
                        } else if (IdentityReviewActivity.this.eHM != null) {
                            g.dismissDialog(IdentityReviewActivity.this.eHM, IdentityReviewActivity.this);
                        }
                    } else if (error != -100000303 || !IdentityReviewActivity.this.needRetry) {
                        if (IdentityReviewActivity.this.eHM != null && IdentityReviewActivity.this.eHM.isShowing()) {
                            g.dismissDialog(IdentityReviewActivity.this.eHM, IdentityReviewActivity.this);
                        }
                        l.showLongToast(TbadkCoreApplication.getInst(), responsedMessage.getErrorString());
                        IdentityReviewActivity.this.eHN = 1;
                        IdentityReviewActivity.this.eHO = 1;
                    } else {
                        IdentityReviewActivity.this.eHN = 1;
                        IdentityReviewActivity.this.eHO = 1;
                        if (IdentityReviewActivity.this.eFV != null) {
                            IdentityReviewActivity.this.needRetry = false;
                            new a(IdentityReviewActivity.this.eHB, 1, IdentityReviewActivity.this.eFV).execute(new Void[0]);
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
                if (IdentityReviewActivity.this.eHM != null && IdentityReviewActivity.this.eHM.isShowing()) {
                    g.dismissDialog(IdentityReviewActivity.this.eHM, IdentityReviewActivity.this);
                }
                String str = "https://tieba.baidu.com/mo/q/newmanagerapplyresult?passIDCert=1&nomenu=1&forum_id=" + IdentityReviewActivity.this.forumId;
                if (error == 0) {
                    ba.amO().b(IdentityReviewActivity.this.getPageContext(), new String[]{str});
                    IdentityReviewActivity.this.setResult(-1);
                    IdentityReviewActivity.this.finish();
                    return;
                }
                l.showLongToast(TbadkCoreApplication.getInst(), httpResponsedMessage.getErrorString());
                IdentityReviewActivity.this.eHN = 1;
                IdentityReviewActivity.this.eHO = 1;
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.identity_review_activity);
        this.forumId = getIntent().getLongExtra("fid", 0L);
        this.eFV = new com.baidu.tieba.barselect.data.c(getPageContext());
        this.eHA = new com.baidu.tieba.barselect.data.b(getPageContext());
        this.eHB = new File(TbadkCoreApplication.getInst().getFilesDir(), "positive.jpg").getAbsolutePath();
        this.eHC = new File(TbadkCoreApplication.getInst().getFilesDir(), "negative.jpg").getAbsolutePath();
        this.eHD = findViewById(R.id.id_card_view);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.id_review_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(getResources().getString(R.string.bar_manager_apply));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eHE = (TextView) findViewById(R.id.bottom_next_button);
        this.eHE.setEnabled(false);
        this.eHF = (TextView) findViewById(R.id.identity_view_title);
        this.eHG = (TextView) findViewById(R.id.positive_card_coloct_tip);
        this.eHH = (TextView) findViewById(R.id.negative_card_coloct_tip);
        this.eHI = (TbImageView) findViewById(R.id.identity_card_positive);
        this.eHJ = (TbImageView) findViewById(R.id.identity_card_negative);
        this.eHK = (TextView) findViewById(R.id.identity_card_positive_logo);
        this.eHL = (TextView) findViewById(R.id.identity_card_negative_logo);
        MessageManager.getInstance().registerListener(this.bRo);
        MessageManager.getInstance().registerListener(this.mHttpMessageListener);
        this.eHI.setOnClickListener(this.cze);
        this.eHJ.setOnClickListener(this.cze);
        this.eHE.setOnClickListener(this.cze);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        }
        am.setViewTextColor(this.eHE, R.color.cp_cont_a, 1, i);
        am.setBackgroundResource(this.eHE, R.drawable.bg_id_card_button, i);
        am.setViewTextColor(this.eHF, R.color.cp_cont_b, 1, i);
        am.setViewTextColor(this.eHG, R.color.cp_cont_d, 1, i);
        am.setViewTextColor(this.eHH, R.color.cp_cont_d, 1, i);
        int dimens = l.getDimens(this, R.dimen.tbds10);
        am.setViewTextColor(this.eHK, R.color.cp_cont_a, 1, i);
        am.setViewTextColor(this.eHL, R.color.cp_cont_a, 1, i);
        am.c(this.eHK, dimens, (int) R.color.cp_cont_b_alpha42, (int) R.color.cp_cont_b_alpha42, i);
        am.c(this.eHL, dimens, (int) R.color.cp_cont_b_alpha42, (int) R.color.cp_cont_b_alpha42, i);
        if (this.eHN < 1) {
            am.setImageResource(this.eHI, R.drawable.pic_id_front, i);
        }
        if (this.eHO < 1) {
            am.setImageResource(this.eHJ, R.drawable.pic_id_back, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if (i == 101) {
                com.baidu.adp.lib.f.c.fT().a(this.eHB, 32, this.cIe, getUniqueId());
                this.eHN = 1;
            } else if (i == 102) {
                com.baidu.adp.lib.f.c.fT().a(this.eHC, 32, this.cIe, getUniqueId());
                this.eHO = 1;
            }
            if (this.eHE != null) {
                if (this.eHO >= 1 && this.eHN >= 1) {
                    this.eHE.setEnabled(true);
                } else {
                    this.eHE.setEnabled(false);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.bRo);
        MessageManager.getInstance().unRegisterListener(this.mHttpMessageListener);
        if (this.eHM != null && this.eHM.isShowing()) {
            g.dismissDialog(this.eHM, this);
        }
        super.onDestroy();
    }
}
