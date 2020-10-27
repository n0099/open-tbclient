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
    private com.baidu.tieba.barselect.data.c hLQ;
    private TextView hNA;
    private TextView hNB;
    private TbImageView hNC;
    private TbImageView hND;
    private TextView hNE;
    private TextView hNF;
    private com.baidu.tieba.barselect.view.a hNG;
    private com.baidu.tieba.barselect.data.b hNu;
    public String hNv;
    public String hNw;
    private View hNx;
    private TextView hNy;
    private TextView hNz;
    private NavigationBar mNavigationBar;
    private boolean needRetry = false;
    private int hNH = 0;
    private int hNI = 0;
    private View.OnClickListener fcr = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.IdentityReviewActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == R.id.identity_card_positive) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2921412, new CameraActivityConfig(IdentityReviewActivity.this, IdentityReviewActivity.this.hNv, CameraActivityConfig.CONTENT_TYPE_ID_CARD_FRONT, 101)));
            } else if (view.getId() == R.id.identity_card_negative) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2921412, new CameraActivityConfig(IdentityReviewActivity.this, IdentityReviewActivity.this.hNw, CameraActivityConfig.CONTENT_TYPE_ID_CARD_BACK, 102)));
            } else if (view.getId() == R.id.bottom_next_button) {
                new a(IdentityReviewActivity.this.hNv, 1, IdentityReviewActivity.this.hLQ).execute(new Void[0]);
                IdentityReviewActivity.this.needRetry = true;
                IdentityReviewActivity.this.hNG = new com.baidu.tieba.barselect.view.a(IdentityReviewActivity.this);
                IdentityReviewActivity.this.hNG.setCancelable(true);
                IdentityReviewActivity.this.hNG.setCanceledOnTouchOutside(false);
                IdentityReviewActivity.this.hNG.setMessage(TbadkCoreApplication.getInst().getString(R.string.check_id_card));
                g.showDialog(IdentityReviewActivity.this.hNG, IdentityReviewActivity.this);
            }
        }
    };
    com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a> flS = new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.barselect.idCard.IdentityReviewActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.e.b
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            super.onLoaded((AnonymousClass2) aVar, str, i);
            if (str != null && aVar != null) {
                if (str.equals(IdentityReviewActivity.this.hNv)) {
                    aVar.drawImageTo(IdentityReviewActivity.this.hNC);
                    IdentityReviewActivity.this.hNE.setVisibility(0);
                } else if (str.equals(IdentityReviewActivity.this.hNw)) {
                    aVar.drawImageTo(IdentityReviewActivity.this.hND);
                    IdentityReviewActivity.this.hNF.setVisibility(0);
                }
            }
            if (str != null) {
                com.baidu.tbadk.imageManager.c.byE().deletePic(str + 32);
            }
        }
    };
    com.baidu.adp.framework.listener.a elx = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_COMMIT_CARD_INFO, 309643) { // from class: com.baidu.tieba.barselect.idCard.IdentityReviewActivity.3
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage != null && responsedMessage.getOrginalMessage() != null) {
                int error = responsedMessage.getError();
                Object extra = responsedMessage.getOrginalMessage().getExtra();
                if (extra instanceof CommitCardInfoReqMsg) {
                    if (error == 0) {
                        if (((CommitCardInfoReqMsg) extra).card_type == 1) {
                            IdentityReviewActivity.this.hNH = 2;
                        } else if (((CommitCardInfoReqMsg) extra).card_type == 2) {
                            IdentityReviewActivity.this.hNI = 2;
                        }
                        if (IdentityReviewActivity.this.hNH < 2 || IdentityReviewActivity.this.hNI < 2) {
                            if (IdentityReviewActivity.this.hNI == 1) {
                                if (IdentityReviewActivity.this.hLQ == null) {
                                    if (IdentityReviewActivity.this.hNG != null) {
                                        g.dismissDialog(IdentityReviewActivity.this.hNG, IdentityReviewActivity.this);
                                        return;
                                    }
                                    return;
                                }
                                new a(IdentityReviewActivity.this.hNw, 2, IdentityReviewActivity.this.hLQ).execute(new Void[0]);
                            }
                        } else if (IdentityReviewActivity.this.hNu != null) {
                            IdentityReviewActivity.this.hNu.eS(IdentityReviewActivity.this.forumId);
                        } else if (IdentityReviewActivity.this.hNG != null) {
                            g.dismissDialog(IdentityReviewActivity.this.hNG, IdentityReviewActivity.this);
                        }
                    } else if (error != -100000303 || !IdentityReviewActivity.this.needRetry) {
                        if (IdentityReviewActivity.this.hNG != null && IdentityReviewActivity.this.hNG.isShowing()) {
                            g.dismissDialog(IdentityReviewActivity.this.hNG, IdentityReviewActivity.this);
                        }
                        l.showLongToast(TbadkCoreApplication.getInst(), responsedMessage.getErrorString());
                        IdentityReviewActivity.this.hNH = 1;
                        IdentityReviewActivity.this.hNI = 1;
                    } else {
                        IdentityReviewActivity.this.hNH = 1;
                        IdentityReviewActivity.this.hNI = 1;
                        if (IdentityReviewActivity.this.hLQ != null) {
                            IdentityReviewActivity.this.needRetry = false;
                            new a(IdentityReviewActivity.this.hNv, 1, IdentityReviewActivity.this.hLQ).execute(new Void[0]);
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
                if (IdentityReviewActivity.this.hNG != null && IdentityReviewActivity.this.hNG.isShowing()) {
                    g.dismissDialog(IdentityReviewActivity.this.hNG, IdentityReviewActivity.this);
                }
                String str = "https://tieba.baidu.com/mo/q/newmanagerapplyresult?passIDCert=1&nomenu=1&forum_id=" + IdentityReviewActivity.this.forumId;
                if (error == 0) {
                    be.boR().b(IdentityReviewActivity.this.getPageContext(), new String[]{str});
                    IdentityReviewActivity.this.setResult(-1);
                    IdentityReviewActivity.this.finish();
                    return;
                }
                l.showLongToast(TbadkCoreApplication.getInst(), httpResponsedMessage.getErrorString());
                IdentityReviewActivity.this.hNH = 1;
                IdentityReviewActivity.this.hNI = 1;
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.identity_review_activity);
        this.forumId = getIntent().getLongExtra("fid", 0L);
        this.hLQ = new com.baidu.tieba.barselect.data.c(getPageContext());
        this.hNu = new com.baidu.tieba.barselect.data.b(getPageContext());
        this.hNv = new File(TbadkCoreApplication.getInst().getFilesDir(), "positive.jpg").getAbsolutePath();
        this.hNw = new File(TbadkCoreApplication.getInst().getFilesDir(), "negative.jpg").getAbsolutePath();
        this.hNx = findViewById(R.id.id_card_view);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.id_review_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(getResources().getString(R.string.bar_manager_apply));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.hNy = (TextView) findViewById(R.id.bottom_next_button);
        this.hNy.setEnabled(false);
        this.hNz = (TextView) findViewById(R.id.identity_view_title);
        this.hNA = (TextView) findViewById(R.id.positive_card_coloct_tip);
        this.hNB = (TextView) findViewById(R.id.negative_card_coloct_tip);
        this.hNC = (TbImageView) findViewById(R.id.identity_card_positive);
        this.hND = (TbImageView) findViewById(R.id.identity_card_negative);
        this.hNE = (TextView) findViewById(R.id.identity_card_positive_logo);
        this.hNF = (TextView) findViewById(R.id.identity_card_negative_logo);
        MessageManager.getInstance().registerListener(this.elx);
        MessageManager.getInstance().registerListener(this.mHttpMessageListener);
        this.hNC.setOnClickListener(this.fcr);
        this.hND.setOnClickListener(this.fcr);
        this.hNy.setOnClickListener(this.fcr);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        }
        ap.setViewTextColor(this.hNy, R.color.cp_cont_a, 1, i);
        ap.setBackgroundResource(this.hNy, R.drawable.bg_id_card_button, i);
        ap.setViewTextColor(this.hNz, R.color.cp_cont_b, 1, i);
        ap.setViewTextColor(this.hNA, R.color.cp_cont_d, 1, i);
        ap.setViewTextColor(this.hNB, R.color.cp_cont_d, 1, i);
        int dimens = l.getDimens(this, R.dimen.tbds10);
        ap.setViewTextColor(this.hNE, R.color.cp_cont_a, 1, i);
        ap.setViewTextColor(this.hNF, R.color.cp_cont_a, 1, i);
        ap.c(this.hNE, dimens, R.color.cp_cont_b_alpha42, R.color.cp_cont_b_alpha42, i);
        ap.c(this.hNF, dimens, R.color.cp_cont_b_alpha42, R.color.cp_cont_b_alpha42, i);
        if (this.hNH < 1) {
            ap.setImageResource(this.hNC, R.drawable.pic_id_front, i);
        }
        if (this.hNI < 1) {
            ap.setImageResource(this.hND, R.drawable.pic_id_back, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if (i == 101) {
                com.baidu.adp.lib.e.c.mS().a(this.hNv, 32, this.flS, getUniqueId());
                this.hNH = 1;
            } else if (i == 102) {
                com.baidu.adp.lib.e.c.mS().a(this.hNw, 32, this.flS, getUniqueId());
                this.hNI = 1;
            }
            if (this.hNy != null) {
                if (this.hNI >= 1 && this.hNH >= 1) {
                    this.hNy.setEnabled(true);
                } else {
                    this.hNy.setEnabled(false);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.elx);
        MessageManager.getInstance().unRegisterListener(this.mHttpMessageListener);
        if (this.hNG != null && this.hNG.isShowing()) {
            g.dismissDialog(this.hNG, this);
        }
        super.onDestroy();
    }
}
