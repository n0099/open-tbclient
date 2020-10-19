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
/* loaded from: classes21.dex */
public class IdentityReviewActivity extends BaseActivity {
    private long forumId;
    private com.baidu.tieba.barselect.data.b hAY;
    public String hAZ;
    public String hBa;
    private View hBb;
    private TextView hBc;
    private TextView hBd;
    private TextView hBe;
    private TextView hBf;
    private TbImageView hBg;
    private TbImageView hBh;
    private TextView hBi;
    private TextView hBj;
    private com.baidu.tieba.barselect.view.a hBk;
    private com.baidu.tieba.barselect.data.c hzu;
    private NavigationBar mNavigationBar;
    private boolean needRetry = false;
    private int hBl = 0;
    private int hBm = 0;
    private View.OnClickListener eTU = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.IdentityReviewActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == R.id.identity_card_positive) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2921412, new CameraActivityConfig(IdentityReviewActivity.this, IdentityReviewActivity.this.hAZ, CameraActivityConfig.CONTENT_TYPE_ID_CARD_FRONT, 101)));
            } else if (view.getId() == R.id.identity_card_negative) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2921412, new CameraActivityConfig(IdentityReviewActivity.this, IdentityReviewActivity.this.hBa, CameraActivityConfig.CONTENT_TYPE_ID_CARD_BACK, 102)));
            } else if (view.getId() == R.id.bottom_next_button) {
                new a(IdentityReviewActivity.this.hAZ, 1, IdentityReviewActivity.this.hzu).execute(new Void[0]);
                IdentityReviewActivity.this.needRetry = true;
                IdentityReviewActivity.this.hBk = new com.baidu.tieba.barselect.view.a(IdentityReviewActivity.this);
                IdentityReviewActivity.this.hBk.setCancelable(true);
                IdentityReviewActivity.this.hBk.setCanceledOnTouchOutside(false);
                IdentityReviewActivity.this.hBk.setMessage(TbadkCoreApplication.getInst().getString(R.string.check_id_card));
                g.showDialog(IdentityReviewActivity.this.hBk, IdentityReviewActivity.this);
            }
        }
    };
    com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a> fdu = new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.barselect.idCard.IdentityReviewActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.e.b
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            super.onLoaded((AnonymousClass2) aVar, str, i);
            if (str != null && aVar != null) {
                if (str.equals(IdentityReviewActivity.this.hAZ)) {
                    aVar.drawImageTo(IdentityReviewActivity.this.hBg);
                    IdentityReviewActivity.this.hBi.setVisibility(0);
                } else if (str.equals(IdentityReviewActivity.this.hBa)) {
                    aVar.drawImageTo(IdentityReviewActivity.this.hBh);
                    IdentityReviewActivity.this.hBj.setVisibility(0);
                }
            }
            if (str != null) {
                com.baidu.tbadk.imageManager.c.bwL().deletePic(str + 32);
            }
        }
    };
    com.baidu.adp.framework.listener.a edb = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_COMMIT_CARD_INFO, 309643) { // from class: com.baidu.tieba.barselect.idCard.IdentityReviewActivity.3
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage != null && responsedMessage.getOrginalMessage() != null) {
                int error = responsedMessage.getError();
                Object extra = responsedMessage.getOrginalMessage().getExtra();
                if (extra instanceof CommitCardInfoReqMsg) {
                    if (error == 0) {
                        if (((CommitCardInfoReqMsg) extra).card_type == 1) {
                            IdentityReviewActivity.this.hBl = 2;
                        } else if (((CommitCardInfoReqMsg) extra).card_type == 2) {
                            IdentityReviewActivity.this.hBm = 2;
                        }
                        if (IdentityReviewActivity.this.hBl < 2 || IdentityReviewActivity.this.hBm < 2) {
                            if (IdentityReviewActivity.this.hBm == 1) {
                                if (IdentityReviewActivity.this.hzu == null) {
                                    if (IdentityReviewActivity.this.hBk != null) {
                                        g.dismissDialog(IdentityReviewActivity.this.hBk, IdentityReviewActivity.this);
                                        return;
                                    }
                                    return;
                                }
                                new a(IdentityReviewActivity.this.hBa, 2, IdentityReviewActivity.this.hzu).execute(new Void[0]);
                            }
                        } else if (IdentityReviewActivity.this.hAY != null) {
                            IdentityReviewActivity.this.hAY.eR(IdentityReviewActivity.this.forumId);
                        } else if (IdentityReviewActivity.this.hBk != null) {
                            g.dismissDialog(IdentityReviewActivity.this.hBk, IdentityReviewActivity.this);
                        }
                    } else if (error != -100000303 || !IdentityReviewActivity.this.needRetry) {
                        if (IdentityReviewActivity.this.hBk != null && IdentityReviewActivity.this.hBk.isShowing()) {
                            g.dismissDialog(IdentityReviewActivity.this.hBk, IdentityReviewActivity.this);
                        }
                        l.showLongToast(TbadkCoreApplication.getInst(), responsedMessage.getErrorString());
                        IdentityReviewActivity.this.hBl = 1;
                        IdentityReviewActivity.this.hBm = 1;
                    } else {
                        IdentityReviewActivity.this.hBl = 1;
                        IdentityReviewActivity.this.hBm = 1;
                        if (IdentityReviewActivity.this.hzu != null) {
                            IdentityReviewActivity.this.needRetry = false;
                            new a(IdentityReviewActivity.this.hAZ, 1, IdentityReviewActivity.this.hzu).execute(new Void[0]);
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
                if (IdentityReviewActivity.this.hBk != null && IdentityReviewActivity.this.hBk.isShowing()) {
                    g.dismissDialog(IdentityReviewActivity.this.hBk, IdentityReviewActivity.this);
                }
                String str = "https://tieba.baidu.com/mo/q/newmanagerapplyresult?passIDCert=1&nomenu=1&forum_id=" + IdentityReviewActivity.this.forumId;
                if (error == 0) {
                    be.bmY().b(IdentityReviewActivity.this.getPageContext(), new String[]{str});
                    IdentityReviewActivity.this.setResult(-1);
                    IdentityReviewActivity.this.finish();
                    return;
                }
                l.showLongToast(TbadkCoreApplication.getInst(), httpResponsedMessage.getErrorString());
                IdentityReviewActivity.this.hBl = 1;
                IdentityReviewActivity.this.hBm = 1;
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.identity_review_activity);
        this.forumId = getIntent().getLongExtra("fid", 0L);
        this.hzu = new com.baidu.tieba.barselect.data.c(getPageContext());
        this.hAY = new com.baidu.tieba.barselect.data.b(getPageContext());
        this.hAZ = new File(TbadkCoreApplication.getInst().getFilesDir(), "positive.jpg").getAbsolutePath();
        this.hBa = new File(TbadkCoreApplication.getInst().getFilesDir(), "negative.jpg").getAbsolutePath();
        this.hBb = findViewById(R.id.id_card_view);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.id_review_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(getResources().getString(R.string.bar_manager_apply));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.hBc = (TextView) findViewById(R.id.bottom_next_button);
        this.hBc.setEnabled(false);
        this.hBd = (TextView) findViewById(R.id.identity_view_title);
        this.hBe = (TextView) findViewById(R.id.positive_card_coloct_tip);
        this.hBf = (TextView) findViewById(R.id.negative_card_coloct_tip);
        this.hBg = (TbImageView) findViewById(R.id.identity_card_positive);
        this.hBh = (TbImageView) findViewById(R.id.identity_card_negative);
        this.hBi = (TextView) findViewById(R.id.identity_card_positive_logo);
        this.hBj = (TextView) findViewById(R.id.identity_card_negative_logo);
        MessageManager.getInstance().registerListener(this.edb);
        MessageManager.getInstance().registerListener(this.mHttpMessageListener);
        this.hBg.setOnClickListener(this.eTU);
        this.hBh.setOnClickListener(this.eTU);
        this.hBc.setOnClickListener(this.eTU);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        }
        ap.setViewTextColor(this.hBc, R.color.cp_cont_a, 1, i);
        ap.setBackgroundResource(this.hBc, R.drawable.bg_id_card_button, i);
        ap.setViewTextColor(this.hBd, R.color.cp_cont_b, 1, i);
        ap.setViewTextColor(this.hBe, R.color.cp_cont_d, 1, i);
        ap.setViewTextColor(this.hBf, R.color.cp_cont_d, 1, i);
        int dimens = l.getDimens(this, R.dimen.tbds10);
        ap.setViewTextColor(this.hBi, R.color.cp_cont_a, 1, i);
        ap.setViewTextColor(this.hBj, R.color.cp_cont_a, 1, i);
        ap.c(this.hBi, dimens, R.color.cp_cont_b_alpha42, R.color.cp_cont_b_alpha42, i);
        ap.c(this.hBj, dimens, R.color.cp_cont_b_alpha42, R.color.cp_cont_b_alpha42, i);
        if (this.hBl < 1) {
            ap.setImageResource(this.hBg, R.drawable.pic_id_front, i);
        }
        if (this.hBm < 1) {
            ap.setImageResource(this.hBh, R.drawable.pic_id_back, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if (i == 101) {
                com.baidu.adp.lib.e.c.mS().a(this.hAZ, 32, this.fdu, getUniqueId());
                this.hBl = 1;
            } else if (i == 102) {
                com.baidu.adp.lib.e.c.mS().a(this.hBa, 32, this.fdu, getUniqueId());
                this.hBm = 1;
            }
            if (this.hBc != null) {
                if (this.hBm >= 1 && this.hBl >= 1) {
                    this.hBc.setEnabled(true);
                } else {
                    this.hBc.setEnabled(false);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.edb);
        MessageManager.getInstance().unRegisterListener(this.mHttpMessageListener);
        if (this.hBk != null && this.hBk.isShowing()) {
            g.dismissDialog(this.hBk, this);
        }
        super.onDestroy();
    }
}
