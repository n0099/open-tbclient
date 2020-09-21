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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.barselect.data.CommitCardInfoReqMsg;
import java.io.File;
/* loaded from: classes20.dex */
public class IdentityReviewActivity extends BaseActivity {
    private long forumId;
    private com.baidu.tieba.barselect.data.c hkz;
    private com.baidu.tieba.barselect.data.b hme;
    public String hmf;
    public String hmg;
    private View hmh;
    private TextView hmi;
    private TextView hmj;
    private TextView hmk;
    private TextView hml;
    private TbImageView hmm;
    private TbImageView hmn;
    private TextView hmo;
    private TextView hmp;
    private com.baidu.tieba.barselect.view.a hmq;
    private NavigationBar mNavigationBar;
    private boolean needRetry = false;
    private int hmr = 0;
    private int hms = 0;
    private View.OnClickListener eHN = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.IdentityReviewActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == R.id.identity_card_positive) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2921412, new CameraActivityConfig(IdentityReviewActivity.this, IdentityReviewActivity.this.hmf, CameraActivityConfig.CONTENT_TYPE_ID_CARD_FRONT, 101)));
            } else if (view.getId() == R.id.identity_card_negative) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2921412, new CameraActivityConfig(IdentityReviewActivity.this, IdentityReviewActivity.this.hmg, CameraActivityConfig.CONTENT_TYPE_ID_CARD_BACK, 102)));
            } else if (view.getId() == R.id.bottom_next_button) {
                new a(IdentityReviewActivity.this.hmf, 1, IdentityReviewActivity.this.hkz).execute(new Void[0]);
                IdentityReviewActivity.this.needRetry = true;
                IdentityReviewActivity.this.hmq = new com.baidu.tieba.barselect.view.a(IdentityReviewActivity.this);
                IdentityReviewActivity.this.hmq.setCancelable(true);
                IdentityReviewActivity.this.hmq.setCanceledOnTouchOutside(false);
                IdentityReviewActivity.this.hmq.setMessage(TbadkCoreApplication.getInst().getString(R.string.check_id_card));
                g.showDialog(IdentityReviewActivity.this.hmq, IdentityReviewActivity.this);
            }
        }
    };
    com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a> eRm = new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.barselect.idCard.IdentityReviewActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.e.b
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            super.onLoaded((AnonymousClass2) aVar, str, i);
            if (str != null && aVar != null) {
                if (str.equals(IdentityReviewActivity.this.hmf)) {
                    aVar.drawImageTo(IdentityReviewActivity.this.hmm);
                    IdentityReviewActivity.this.hmo.setVisibility(0);
                } else if (str.equals(IdentityReviewActivity.this.hmg)) {
                    aVar.drawImageTo(IdentityReviewActivity.this.hmn);
                    IdentityReviewActivity.this.hmp.setVisibility(0);
                }
            }
            if (str != null) {
                com.baidu.tbadk.imageManager.c.bub().deletePic(str + 32);
            }
        }
    };
    com.baidu.adp.framework.listener.a dRa = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_COMMIT_CARD_INFO, 309643) { // from class: com.baidu.tieba.barselect.idCard.IdentityReviewActivity.3
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage != null && responsedMessage.getOrginalMessage() != null) {
                int error = responsedMessage.getError();
                Object extra = responsedMessage.getOrginalMessage().getExtra();
                if (extra instanceof CommitCardInfoReqMsg) {
                    if (error == 0) {
                        if (((CommitCardInfoReqMsg) extra).card_type == 1) {
                            IdentityReviewActivity.this.hmr = 2;
                        } else if (((CommitCardInfoReqMsg) extra).card_type == 2) {
                            IdentityReviewActivity.this.hms = 2;
                        }
                        if (IdentityReviewActivity.this.hmr < 2 || IdentityReviewActivity.this.hms < 2) {
                            if (IdentityReviewActivity.this.hms == 1) {
                                if (IdentityReviewActivity.this.hkz == null) {
                                    if (IdentityReviewActivity.this.hmq != null) {
                                        g.dismissDialog(IdentityReviewActivity.this.hmq, IdentityReviewActivity.this);
                                        return;
                                    }
                                    return;
                                }
                                new a(IdentityReviewActivity.this.hmg, 2, IdentityReviewActivity.this.hkz).execute(new Void[0]);
                            }
                        } else if (IdentityReviewActivity.this.hme != null) {
                            IdentityReviewActivity.this.hme.eA(IdentityReviewActivity.this.forumId);
                        } else if (IdentityReviewActivity.this.hmq != null) {
                            g.dismissDialog(IdentityReviewActivity.this.hmq, IdentityReviewActivity.this);
                        }
                    } else if (error != -100000303 || !IdentityReviewActivity.this.needRetry) {
                        if (IdentityReviewActivity.this.hmq != null && IdentityReviewActivity.this.hmq.isShowing()) {
                            g.dismissDialog(IdentityReviewActivity.this.hmq, IdentityReviewActivity.this);
                        }
                        l.showLongToast(TbadkCoreApplication.getInst(), responsedMessage.getErrorString());
                        IdentityReviewActivity.this.hmr = 1;
                        IdentityReviewActivity.this.hms = 1;
                    } else {
                        IdentityReviewActivity.this.hmr = 1;
                        IdentityReviewActivity.this.hms = 1;
                        if (IdentityReviewActivity.this.hkz != null) {
                            IdentityReviewActivity.this.needRetry = false;
                            new a(IdentityReviewActivity.this.hmf, 1, IdentityReviewActivity.this.hkz).execute(new Void[0]);
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
                if (IdentityReviewActivity.this.hmq != null && IdentityReviewActivity.this.hmq.isShowing()) {
                    g.dismissDialog(IdentityReviewActivity.this.hmq, IdentityReviewActivity.this);
                }
                String str = "https://tieba.baidu.com/mo/q/newmanagerapplyresult?passIDCert=1&nomenu=1&forum_id=" + IdentityReviewActivity.this.forumId;
                if (error == 0) {
                    be.bkp().b(IdentityReviewActivity.this.getPageContext(), new String[]{str});
                    IdentityReviewActivity.this.setResult(-1);
                    IdentityReviewActivity.this.finish();
                    return;
                }
                l.showLongToast(TbadkCoreApplication.getInst(), httpResponsedMessage.getErrorString());
                IdentityReviewActivity.this.hmr = 1;
                IdentityReviewActivity.this.hms = 1;
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.identity_review_activity);
        this.forumId = getIntent().getLongExtra("fid", 0L);
        this.hkz = new com.baidu.tieba.barselect.data.c(getPageContext());
        this.hme = new com.baidu.tieba.barselect.data.b(getPageContext());
        this.hmf = new File(TbadkCoreApplication.getInst().getFilesDir(), "positive.jpg").getAbsolutePath();
        this.hmg = new File(TbadkCoreApplication.getInst().getFilesDir(), "negative.jpg").getAbsolutePath();
        this.hmh = findViewById(R.id.id_card_view);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.id_review_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(getResources().getString(R.string.bar_manager_apply));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.hmi = (TextView) findViewById(R.id.bottom_next_button);
        this.hmi.setEnabled(false);
        this.hmj = (TextView) findViewById(R.id.identity_view_title);
        this.hmk = (TextView) findViewById(R.id.positive_card_coloct_tip);
        this.hml = (TextView) findViewById(R.id.negative_card_coloct_tip);
        this.hmm = (TbImageView) findViewById(R.id.identity_card_positive);
        this.hmn = (TbImageView) findViewById(R.id.identity_card_negative);
        this.hmo = (TextView) findViewById(R.id.identity_card_positive_logo);
        this.hmp = (TextView) findViewById(R.id.identity_card_negative_logo);
        MessageManager.getInstance().registerListener(this.dRa);
        MessageManager.getInstance().registerListener(this.mHttpMessageListener);
        this.hmm.setOnClickListener(this.eHN);
        this.hmn.setOnClickListener(this.eHN);
        this.hmi.setOnClickListener(this.eHN);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        }
        ap.setViewTextColor(this.hmi, R.color.cp_cont_a, 1, i);
        ap.setBackgroundResource(this.hmi, R.drawable.bg_id_card_button, i);
        ap.setViewTextColor(this.hmj, R.color.cp_cont_b, 1, i);
        ap.setViewTextColor(this.hmk, R.color.cp_cont_d, 1, i);
        ap.setViewTextColor(this.hml, R.color.cp_cont_d, 1, i);
        int dimens = l.getDimens(this, R.dimen.tbds10);
        ap.setViewTextColor(this.hmo, R.color.cp_cont_a, 1, i);
        ap.setViewTextColor(this.hmp, R.color.cp_cont_a, 1, i);
        ap.c(this.hmo, dimens, R.color.cp_cont_b_alpha42, R.color.cp_cont_b_alpha42, i);
        ap.c(this.hmp, dimens, R.color.cp_cont_b_alpha42, R.color.cp_cont_b_alpha42, i);
        if (this.hmr < 1) {
            ap.setImageResource(this.hmm, R.drawable.pic_id_front, i);
        }
        if (this.hms < 1) {
            ap.setImageResource(this.hmn, R.drawable.pic_id_back, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if (i == 101) {
                com.baidu.adp.lib.e.c.mR().a(this.hmf, 32, this.eRm, getUniqueId());
                this.hmr = 1;
            } else if (i == 102) {
                com.baidu.adp.lib.e.c.mR().a(this.hmg, 32, this.eRm, getUniqueId());
                this.hms = 1;
            }
            if (this.hmi != null) {
                if (this.hms >= 1 && this.hmr >= 1) {
                    this.hmi.setEnabled(true);
                } else {
                    this.hmi.setEnabled(false);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.dRa);
        MessageManager.getInstance().unRegisterListener(this.mHttpMessageListener);
        if (this.hmq != null && this.hmq.isShowing()) {
            g.dismissDialog(this.hmq, this);
        }
        super.onDestroy();
    }
}
