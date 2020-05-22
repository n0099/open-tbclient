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
/* loaded from: classes8.dex */
public class IdentityReviewActivity extends BaseActivity {
    private long forumId;
    private com.baidu.tieba.barselect.data.c gya;
    private com.baidu.tieba.barselect.data.b gzD;
    public String gzE;
    public String gzF;
    private View gzG;
    private TextView gzH;
    private TextView gzI;
    private TextView gzJ;
    private TextView gzK;
    private TbImageView gzL;
    private TbImageView gzM;
    private TextView gzN;
    private TextView gzO;
    private com.baidu.tieba.barselect.view.a gzP;
    private NavigationBar mNavigationBar;
    private boolean needRetry = false;
    private int gzQ = 0;
    private int gzR = 0;
    private View.OnClickListener ege = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.IdentityReviewActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == R.id.identity_card_positive) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2921412, new CameraActivityConfig(IdentityReviewActivity.this, IdentityReviewActivity.this.gzE, CameraActivityConfig.CONTENT_TYPE_ID_CARD_FRONT, 101)));
            } else if (view.getId() == R.id.identity_card_negative) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2921412, new CameraActivityConfig(IdentityReviewActivity.this, IdentityReviewActivity.this.gzF, CameraActivityConfig.CONTENT_TYPE_ID_CARD_BACK, 102)));
            } else if (view.getId() == R.id.bottom_next_button) {
                new a(IdentityReviewActivity.this.gzE, 1, IdentityReviewActivity.this.gya).execute(new Void[0]);
                IdentityReviewActivity.this.needRetry = true;
                IdentityReviewActivity.this.gzP = new com.baidu.tieba.barselect.view.a(IdentityReviewActivity.this);
                IdentityReviewActivity.this.gzP.setCancelable(true);
                IdentityReviewActivity.this.gzP.setCanceledOnTouchOutside(false);
                IdentityReviewActivity.this.gzP.setMessage(TbadkCoreApplication.getInst().getString(R.string.check_id_card));
                g.showDialog(IdentityReviewActivity.this.gzP, IdentityReviewActivity.this);
            }
        }
    };
    com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a> eoJ = new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.barselect.idCard.IdentityReviewActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.e.b
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            super.onLoaded((AnonymousClass2) aVar, str, i);
            if (str != null && aVar != null) {
                if (str.equals(IdentityReviewActivity.this.gzE)) {
                    aVar.drawImageTo(IdentityReviewActivity.this.gzL);
                    IdentityReviewActivity.this.gzN.setVisibility(0);
                } else if (str.equals(IdentityReviewActivity.this.gzF)) {
                    aVar.drawImageTo(IdentityReviewActivity.this.gzM);
                    IdentityReviewActivity.this.gzO.setVisibility(0);
                }
            }
            if (str != null) {
                com.baidu.tbadk.imageManager.c.bet().deletePic(str + 32);
            }
        }
    };
    com.baidu.adp.framework.listener.a dve = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_COMMIT_CARD_INFO, 309643) { // from class: com.baidu.tieba.barselect.idCard.IdentityReviewActivity.3
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage != null && responsedMessage.getOrginalMessage() != null) {
                int error = responsedMessage.getError();
                Object extra = responsedMessage.getOrginalMessage().getExtra();
                if (extra instanceof CommitCardInfoReqMsg) {
                    if (error == 0) {
                        if (((CommitCardInfoReqMsg) extra).card_type == 1) {
                            IdentityReviewActivity.this.gzQ = 2;
                        } else if (((CommitCardInfoReqMsg) extra).card_type == 2) {
                            IdentityReviewActivity.this.gzR = 2;
                        }
                        if (IdentityReviewActivity.this.gzQ < 2 || IdentityReviewActivity.this.gzR < 2) {
                            if (IdentityReviewActivity.this.gzR == 1) {
                                if (IdentityReviewActivity.this.gya == null) {
                                    if (IdentityReviewActivity.this.gzP != null) {
                                        g.dismissDialog(IdentityReviewActivity.this.gzP, IdentityReviewActivity.this);
                                        return;
                                    }
                                    return;
                                }
                                new a(IdentityReviewActivity.this.gzF, 2, IdentityReviewActivity.this.gya).execute(new Void[0]);
                            }
                        } else if (IdentityReviewActivity.this.gzD != null) {
                            IdentityReviewActivity.this.gzD.dP(IdentityReviewActivity.this.forumId);
                        } else if (IdentityReviewActivity.this.gzP != null) {
                            g.dismissDialog(IdentityReviewActivity.this.gzP, IdentityReviewActivity.this);
                        }
                    } else if (error != -100000303 || !IdentityReviewActivity.this.needRetry) {
                        if (IdentityReviewActivity.this.gzP != null && IdentityReviewActivity.this.gzP.isShowing()) {
                            g.dismissDialog(IdentityReviewActivity.this.gzP, IdentityReviewActivity.this);
                        }
                        l.showLongToast(TbadkCoreApplication.getInst(), responsedMessage.getErrorString());
                        IdentityReviewActivity.this.gzQ = 1;
                        IdentityReviewActivity.this.gzR = 1;
                    } else {
                        IdentityReviewActivity.this.gzQ = 1;
                        IdentityReviewActivity.this.gzR = 1;
                        if (IdentityReviewActivity.this.gya != null) {
                            IdentityReviewActivity.this.needRetry = false;
                            new a(IdentityReviewActivity.this.gzE, 1, IdentityReviewActivity.this.gya).execute(new Void[0]);
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
                if (IdentityReviewActivity.this.gzP != null && IdentityReviewActivity.this.gzP.isShowing()) {
                    g.dismissDialog(IdentityReviewActivity.this.gzP, IdentityReviewActivity.this);
                }
                String str = "https://tieba.baidu.com/mo/q/newmanagerapplyresult?passIDCert=1&nomenu=1&forum_id=" + IdentityReviewActivity.this.forumId;
                if (error == 0) {
                    ba.aUZ().b(IdentityReviewActivity.this.getPageContext(), new String[]{str});
                    IdentityReviewActivity.this.setResult(-1);
                    IdentityReviewActivity.this.finish();
                    return;
                }
                l.showLongToast(TbadkCoreApplication.getInst(), httpResponsedMessage.getErrorString());
                IdentityReviewActivity.this.gzQ = 1;
                IdentityReviewActivity.this.gzR = 1;
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.identity_review_activity);
        this.forumId = getIntent().getLongExtra("fid", 0L);
        this.gya = new com.baidu.tieba.barselect.data.c(getPageContext());
        this.gzD = new com.baidu.tieba.barselect.data.b(getPageContext());
        this.gzE = new File(TbadkCoreApplication.getInst().getFilesDir(), "positive.jpg").getAbsolutePath();
        this.gzF = new File(TbadkCoreApplication.getInst().getFilesDir(), "negative.jpg").getAbsolutePath();
        this.gzG = findViewById(R.id.id_card_view);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.id_review_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(getResources().getString(R.string.bar_manager_apply));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.gzH = (TextView) findViewById(R.id.bottom_next_button);
        this.gzH.setEnabled(false);
        this.gzI = (TextView) findViewById(R.id.identity_view_title);
        this.gzJ = (TextView) findViewById(R.id.positive_card_coloct_tip);
        this.gzK = (TextView) findViewById(R.id.negative_card_coloct_tip);
        this.gzL = (TbImageView) findViewById(R.id.identity_card_positive);
        this.gzM = (TbImageView) findViewById(R.id.identity_card_negative);
        this.gzN = (TextView) findViewById(R.id.identity_card_positive_logo);
        this.gzO = (TextView) findViewById(R.id.identity_card_negative_logo);
        MessageManager.getInstance().registerListener(this.dve);
        MessageManager.getInstance().registerListener(this.mHttpMessageListener);
        this.gzL.setOnClickListener(this.ege);
        this.gzM.setOnClickListener(this.ege);
        this.gzH.setOnClickListener(this.ege);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        }
        am.setViewTextColor(this.gzH, R.color.cp_cont_a, 1, i);
        am.setBackgroundResource(this.gzH, R.drawable.bg_id_card_button, i);
        am.setViewTextColor(this.gzI, R.color.cp_cont_b, 1, i);
        am.setViewTextColor(this.gzJ, R.color.cp_cont_d, 1, i);
        am.setViewTextColor(this.gzK, R.color.cp_cont_d, 1, i);
        int dimens = l.getDimens(this, R.dimen.tbds10);
        am.setViewTextColor(this.gzN, R.color.cp_cont_a, 1, i);
        am.setViewTextColor(this.gzO, R.color.cp_cont_a, 1, i);
        am.c(this.gzN, dimens, (int) R.color.cp_cont_b_alpha42, (int) R.color.cp_cont_b_alpha42, i);
        am.c(this.gzO, dimens, (int) R.color.cp_cont_b_alpha42, (int) R.color.cp_cont_b_alpha42, i);
        if (this.gzQ < 1) {
            am.setImageResource(this.gzL, R.drawable.pic_id_front, i);
        }
        if (this.gzR < 1) {
            am.setImageResource(this.gzM, R.drawable.pic_id_back, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if (i == 101) {
                com.baidu.adp.lib.e.c.kX().a(this.gzE, 32, this.eoJ, getUniqueId());
                this.gzQ = 1;
            } else if (i == 102) {
                com.baidu.adp.lib.e.c.kX().a(this.gzF, 32, this.eoJ, getUniqueId());
                this.gzR = 1;
            }
            if (this.gzH != null) {
                if (this.gzR >= 1 && this.gzQ >= 1) {
                    this.gzH.setEnabled(true);
                } else {
                    this.gzH.setEnabled(false);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.dve);
        MessageManager.getInstance().unRegisterListener(this.mHttpMessageListener);
        if (this.gzP != null && this.gzP.isShowing()) {
            g.dismissDialog(this.gzP, this);
        }
        super.onDestroy();
    }
}
