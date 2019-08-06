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
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.barselect.data.CommitCardInfoReqMsg;
import java.io.File;
/* loaded from: classes3.dex */
public class IdentityReviewActivity extends BaseActivity {
    private com.baidu.tieba.barselect.data.c ewt;
    private com.baidu.tieba.barselect.data.b exZ;
    public String eya;
    public String eyb;
    private View eyc;
    private TextView eyd;
    private TextView eye;
    private TextView eyf;
    private TextView eyg;
    private TbImageView eyh;
    private TbImageView eyi;
    private TextView eyj;
    private TextView eyk;
    private com.baidu.tieba.barselect.view.a eyl;
    private long forumId;
    private NavigationBar mNavigationBar;
    private boolean needRetry = false;
    private int eyn = 0;
    private int eyo = 0;
    private View.OnClickListener cmb = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.IdentityReviewActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == R.id.identity_card_positive) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2921412, new CameraActivityConfig(IdentityReviewActivity.this, IdentityReviewActivity.this.eya, CameraActivityConfig.CONTENT_TYPE_ID_CARD_FRONT, 101)));
            } else if (view.getId() == R.id.identity_card_negative) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2921412, new CameraActivityConfig(IdentityReviewActivity.this, IdentityReviewActivity.this.eyb, CameraActivityConfig.CONTENT_TYPE_ID_CARD_BACK, 102)));
            } else if (view.getId() == R.id.bottom_next_button) {
                new a(IdentityReviewActivity.this.eya, 1, IdentityReviewActivity.this.ewt).execute(new Void[0]);
                IdentityReviewActivity.this.needRetry = true;
                IdentityReviewActivity.this.eyl = new com.baidu.tieba.barselect.view.a(IdentityReviewActivity.this);
                IdentityReviewActivity.this.eyl.setCancelable(true);
                IdentityReviewActivity.this.eyl.setCanceledOnTouchOutside(false);
                IdentityReviewActivity.this.eyl.setMessage(TbadkCoreApplication.getInst().getString(R.string.check_id_card));
                g.a(IdentityReviewActivity.this.eyl, IdentityReviewActivity.this);
            }
        }
    };
    com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a> cvQ = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.barselect.idCard.IdentityReviewActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.f.b
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            super.onLoaded((AnonymousClass2) aVar, str, i);
            if (str != null && aVar != null) {
                if (str.equals(IdentityReviewActivity.this.eya)) {
                    aVar.a(IdentityReviewActivity.this.eyh);
                    IdentityReviewActivity.this.eyj.setVisibility(0);
                } else if (str.equals(IdentityReviewActivity.this.eyb)) {
                    aVar.a(IdentityReviewActivity.this.eyi);
                    IdentityReviewActivity.this.eyk.setVisibility(0);
                }
            }
            if (str != null) {
                com.baidu.tbadk.imageManager.c.aty().qF(str + 32);
            }
        }
    };
    com.baidu.adp.framework.listener.a bzb = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_COMMIT_CARD_INFO, 309643) { // from class: com.baidu.tieba.barselect.idCard.IdentityReviewActivity.3
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage != null && responsedMessage.getOrginalMessage() != null) {
                int error = responsedMessage.getError();
                Object extra = responsedMessage.getOrginalMessage().getExtra();
                if (extra instanceof CommitCardInfoReqMsg) {
                    if (error == 0) {
                        if (((CommitCardInfoReqMsg) extra).card_type == 1) {
                            IdentityReviewActivity.this.eyn = 2;
                        } else if (((CommitCardInfoReqMsg) extra).card_type == 2) {
                            IdentityReviewActivity.this.eyo = 2;
                        }
                        if (IdentityReviewActivity.this.eyn < 2 || IdentityReviewActivity.this.eyo < 2) {
                            if (IdentityReviewActivity.this.eyo == 1) {
                                if (IdentityReviewActivity.this.ewt == null) {
                                    if (IdentityReviewActivity.this.eyl != null) {
                                        g.b(IdentityReviewActivity.this.eyl, IdentityReviewActivity.this);
                                        return;
                                    }
                                    return;
                                }
                                new a(IdentityReviewActivity.this.eyb, 2, IdentityReviewActivity.this.ewt).execute(new Void[0]);
                            }
                        } else if (IdentityReviewActivity.this.exZ != null) {
                            IdentityReviewActivity.this.exZ.cA(IdentityReviewActivity.this.forumId);
                        } else if (IdentityReviewActivity.this.eyl != null) {
                            g.b(IdentityReviewActivity.this.eyl, IdentityReviewActivity.this);
                        }
                    } else if (error != -100000303 || !IdentityReviewActivity.this.needRetry) {
                        if (IdentityReviewActivity.this.eyl != null && IdentityReviewActivity.this.eyl.isShowing()) {
                            g.b(IdentityReviewActivity.this.eyl, IdentityReviewActivity.this);
                        }
                        l.E(TbadkCoreApplication.getInst(), responsedMessage.getErrorString());
                        IdentityReviewActivity.this.eyn = 1;
                        IdentityReviewActivity.this.eyo = 1;
                    } else {
                        IdentityReviewActivity.this.eyn = 1;
                        IdentityReviewActivity.this.eyo = 1;
                        if (IdentityReviewActivity.this.ewt != null) {
                            IdentityReviewActivity.this.needRetry = false;
                            new a(IdentityReviewActivity.this.eya, 1, IdentityReviewActivity.this.ewt).execute(new Void[0]);
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
                if (IdentityReviewActivity.this.eyl != null && IdentityReviewActivity.this.eyl.isShowing()) {
                    g.b(IdentityReviewActivity.this.eyl, IdentityReviewActivity.this);
                }
                String str = "https://tieba.baidu.com/mo/q/newmanagerapplyresult?passIDCert=1&nomenu=1&forum_id=" + IdentityReviewActivity.this.forumId;
                if (error == 0) {
                    bb.ajE().c(IdentityReviewActivity.this.getPageContext(), new String[]{str});
                    IdentityReviewActivity.this.setResult(-1);
                    IdentityReviewActivity.this.finish();
                    return;
                }
                l.E(TbadkCoreApplication.getInst(), httpResponsedMessage.getErrorString());
                IdentityReviewActivity.this.eyn = 1;
                IdentityReviewActivity.this.eyo = 1;
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.identity_review_activity);
        this.forumId = getIntent().getLongExtra("fid", 0L);
        this.ewt = new com.baidu.tieba.barselect.data.c(getPageContext());
        this.exZ = new com.baidu.tieba.barselect.data.b(getPageContext());
        this.eya = new File(TbadkCoreApplication.getInst().getFilesDir(), "positive.jpg").getAbsolutePath();
        this.eyb = new File(TbadkCoreApplication.getInst().getFilesDir(), "negative.jpg").getAbsolutePath();
        this.eyc = findViewById(R.id.id_card_view);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.id_review_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(getResources().getString(R.string.bar_manager_apply));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eyd = (TextView) findViewById(R.id.bottom_next_button);
        this.eyd.setEnabled(false);
        this.eye = (TextView) findViewById(R.id.identity_view_title);
        this.eyf = (TextView) findViewById(R.id.positive_card_coloct_tip);
        this.eyg = (TextView) findViewById(R.id.negative_card_coloct_tip);
        this.eyh = (TbImageView) findViewById(R.id.identity_card_positive);
        this.eyi = (TbImageView) findViewById(R.id.identity_card_negative);
        this.eyj = (TextView) findViewById(R.id.identity_card_positive_logo);
        this.eyk = (TextView) findViewById(R.id.identity_card_negative_logo);
        MessageManager.getInstance().registerListener(this.bzb);
        MessageManager.getInstance().registerListener(this.mHttpMessageListener);
        this.eyh.setOnClickListener(this.cmb);
        this.eyi.setOnClickListener(this.cmb);
        this.eyd.setOnClickListener(this.cmb);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        }
        am.d(this.eyd, R.color.cp_btn_a, 1, i);
        am.g(this.eyd, R.drawable.bg_id_card_button, i);
        am.d(this.eye, R.color.cp_cont_b, 1, i);
        am.d(this.eyf, R.color.cp_cont_d, 1, i);
        am.d(this.eyg, R.color.cp_cont_d, 1, i);
        int g = l.g(this, R.dimen.tbds10);
        am.d(this.eyj, R.color.cp_btn_a, 1, i);
        am.d(this.eyk, R.color.cp_btn_a, 1, i);
        am.b(this.eyj, g, (int) R.color.cp_cont_b_alpha42, (int) R.color.cp_cont_b_alpha42, i);
        am.b(this.eyk, g, (int) R.color.cp_cont_b_alpha42, (int) R.color.cp_cont_b_alpha42, i);
        if (this.eyn < 1) {
            am.b(this.eyh, (int) R.drawable.pic_id_front, i);
        }
        if (this.eyo < 1) {
            am.b(this.eyi, (int) R.drawable.pic_id_back, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if (i == 101) {
                com.baidu.adp.lib.f.c.iE().a(this.eya, 32, this.cvQ, getUniqueId());
                this.eyn = 1;
            } else if (i == 102) {
                com.baidu.adp.lib.f.c.iE().a(this.eyb, 32, this.cvQ, getUniqueId());
                this.eyo = 1;
            }
            if (this.eyd != null) {
                if (this.eyo >= 1 && this.eyn >= 1) {
                    this.eyd.setEnabled(true);
                } else {
                    this.eyd.setEnabled(false);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.bzb);
        MessageManager.getInstance().unRegisterListener(this.mHttpMessageListener);
        if (this.eyl != null && this.eyl.isShowing()) {
            g.b(this.eyl, this);
        }
        super.onDestroy();
    }
}
