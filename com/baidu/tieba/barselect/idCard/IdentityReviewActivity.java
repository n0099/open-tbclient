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
    private com.baidu.tieba.barselect.data.c fDC;
    private com.baidu.tieba.barselect.data.b fFf;
    public String fFg;
    public String fFh;
    private View fFi;
    private TextView fFj;
    private TextView fFk;
    private TextView fFl;
    private TextView fFm;
    private TbImageView fFn;
    private TbImageView fFo;
    private TextView fFp;
    private TextView fFq;
    private com.baidu.tieba.barselect.view.a fFr;
    private long forumId;
    private NavigationBar mNavigationBar;
    private boolean needRetry = false;
    private int fFs = 0;
    private int fFt = 0;
    private View.OnClickListener drh = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.IdentityReviewActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == R.id.identity_card_positive) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2921412, new CameraActivityConfig(IdentityReviewActivity.this, IdentityReviewActivity.this.fFg, CameraActivityConfig.CONTENT_TYPE_ID_CARD_FRONT, 101)));
            } else if (view.getId() == R.id.identity_card_negative) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2921412, new CameraActivityConfig(IdentityReviewActivity.this, IdentityReviewActivity.this.fFh, CameraActivityConfig.CONTENT_TYPE_ID_CARD_BACK, 102)));
            } else if (view.getId() == R.id.bottom_next_button) {
                new a(IdentityReviewActivity.this.fFg, 1, IdentityReviewActivity.this.fDC).execute(new Void[0]);
                IdentityReviewActivity.this.needRetry = true;
                IdentityReviewActivity.this.fFr = new com.baidu.tieba.barselect.view.a(IdentityReviewActivity.this);
                IdentityReviewActivity.this.fFr.setCancelable(true);
                IdentityReviewActivity.this.fFr.setCanceledOnTouchOutside(false);
                IdentityReviewActivity.this.fFr.setMessage(TbadkCoreApplication.getInst().getString(R.string.check_id_card));
                g.showDialog(IdentityReviewActivity.this.fFr, IdentityReviewActivity.this);
            }
        }
    };
    com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a> dAi = new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.barselect.idCard.IdentityReviewActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.e.b
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            super.onLoaded((AnonymousClass2) aVar, str, i);
            if (str != null && aVar != null) {
                if (str.equals(IdentityReviewActivity.this.fFg)) {
                    aVar.drawImageTo(IdentityReviewActivity.this.fFn);
                    IdentityReviewActivity.this.fFp.setVisibility(0);
                } else if (str.equals(IdentityReviewActivity.this.fFh)) {
                    aVar.drawImageTo(IdentityReviewActivity.this.fFo);
                    IdentityReviewActivity.this.fFq.setVisibility(0);
                }
            }
            if (str != null) {
                com.baidu.tbadk.imageManager.c.aPO().deletePic(str + 32);
            }
        }
    };
    com.baidu.adp.framework.listener.a cHV = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_COMMIT_CARD_INFO, 309643) { // from class: com.baidu.tieba.barselect.idCard.IdentityReviewActivity.3
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage != null && responsedMessage.getOrginalMessage() != null) {
                int error = responsedMessage.getError();
                Object extra = responsedMessage.getOrginalMessage().getExtra();
                if (extra instanceof CommitCardInfoReqMsg) {
                    if (error == 0) {
                        if (((CommitCardInfoReqMsg) extra).card_type == 1) {
                            IdentityReviewActivity.this.fFs = 2;
                        } else if (((CommitCardInfoReqMsg) extra).card_type == 2) {
                            IdentityReviewActivity.this.fFt = 2;
                        }
                        if (IdentityReviewActivity.this.fFs < 2 || IdentityReviewActivity.this.fFt < 2) {
                            if (IdentityReviewActivity.this.fFt == 1) {
                                if (IdentityReviewActivity.this.fDC == null) {
                                    if (IdentityReviewActivity.this.fFr != null) {
                                        g.dismissDialog(IdentityReviewActivity.this.fFr, IdentityReviewActivity.this);
                                        return;
                                    }
                                    return;
                                }
                                new a(IdentityReviewActivity.this.fFh, 2, IdentityReviewActivity.this.fDC).execute(new Void[0]);
                            }
                        } else if (IdentityReviewActivity.this.fFf != null) {
                            IdentityReviewActivity.this.fFf.dg(IdentityReviewActivity.this.forumId);
                        } else if (IdentityReviewActivity.this.fFr != null) {
                            g.dismissDialog(IdentityReviewActivity.this.fFr, IdentityReviewActivity.this);
                        }
                    } else if (error != -100000303 || !IdentityReviewActivity.this.needRetry) {
                        if (IdentityReviewActivity.this.fFr != null && IdentityReviewActivity.this.fFr.isShowing()) {
                            g.dismissDialog(IdentityReviewActivity.this.fFr, IdentityReviewActivity.this);
                        }
                        l.showLongToast(TbadkCoreApplication.getInst(), responsedMessage.getErrorString());
                        IdentityReviewActivity.this.fFs = 1;
                        IdentityReviewActivity.this.fFt = 1;
                    } else {
                        IdentityReviewActivity.this.fFs = 1;
                        IdentityReviewActivity.this.fFt = 1;
                        if (IdentityReviewActivity.this.fDC != null) {
                            IdentityReviewActivity.this.needRetry = false;
                            new a(IdentityReviewActivity.this.fFg, 1, IdentityReviewActivity.this.fDC).execute(new Void[0]);
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
                if (IdentityReviewActivity.this.fFr != null && IdentityReviewActivity.this.fFr.isShowing()) {
                    g.dismissDialog(IdentityReviewActivity.this.fFr, IdentityReviewActivity.this);
                }
                String str = "https://tieba.baidu.com/mo/q/newmanagerapplyresult?passIDCert=1&nomenu=1&forum_id=" + IdentityReviewActivity.this.forumId;
                if (error == 0) {
                    ba.aGE().b(IdentityReviewActivity.this.getPageContext(), new String[]{str});
                    IdentityReviewActivity.this.setResult(-1);
                    IdentityReviewActivity.this.finish();
                    return;
                }
                l.showLongToast(TbadkCoreApplication.getInst(), httpResponsedMessage.getErrorString());
                IdentityReviewActivity.this.fFs = 1;
                IdentityReviewActivity.this.fFt = 1;
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.identity_review_activity);
        this.forumId = getIntent().getLongExtra("fid", 0L);
        this.fDC = new com.baidu.tieba.barselect.data.c(getPageContext());
        this.fFf = new com.baidu.tieba.barselect.data.b(getPageContext());
        this.fFg = new File(TbadkCoreApplication.getInst().getFilesDir(), "positive.jpg").getAbsolutePath();
        this.fFh = new File(TbadkCoreApplication.getInst().getFilesDir(), "negative.jpg").getAbsolutePath();
        this.fFi = findViewById(R.id.id_card_view);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.id_review_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(getResources().getString(R.string.bar_manager_apply));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.fFj = (TextView) findViewById(R.id.bottom_next_button);
        this.fFj.setEnabled(false);
        this.fFk = (TextView) findViewById(R.id.identity_view_title);
        this.fFl = (TextView) findViewById(R.id.positive_card_coloct_tip);
        this.fFm = (TextView) findViewById(R.id.negative_card_coloct_tip);
        this.fFn = (TbImageView) findViewById(R.id.identity_card_positive);
        this.fFo = (TbImageView) findViewById(R.id.identity_card_negative);
        this.fFp = (TextView) findViewById(R.id.identity_card_positive_logo);
        this.fFq = (TextView) findViewById(R.id.identity_card_negative_logo);
        MessageManager.getInstance().registerListener(this.cHV);
        MessageManager.getInstance().registerListener(this.mHttpMessageListener);
        this.fFn.setOnClickListener(this.drh);
        this.fFo.setOnClickListener(this.drh);
        this.fFj.setOnClickListener(this.drh);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        }
        am.setViewTextColor(this.fFj, R.color.cp_cont_a, 1, i);
        am.setBackgroundResource(this.fFj, R.drawable.bg_id_card_button, i);
        am.setViewTextColor(this.fFk, R.color.cp_cont_b, 1, i);
        am.setViewTextColor(this.fFl, R.color.cp_cont_d, 1, i);
        am.setViewTextColor(this.fFm, R.color.cp_cont_d, 1, i);
        int dimens = l.getDimens(this, R.dimen.tbds10);
        am.setViewTextColor(this.fFp, R.color.cp_cont_a, 1, i);
        am.setViewTextColor(this.fFq, R.color.cp_cont_a, 1, i);
        am.c(this.fFp, dimens, (int) R.color.cp_cont_b_alpha42, (int) R.color.cp_cont_b_alpha42, i);
        am.c(this.fFq, dimens, (int) R.color.cp_cont_b_alpha42, (int) R.color.cp_cont_b_alpha42, i);
        if (this.fFs < 1) {
            am.setImageResource(this.fFn, R.drawable.pic_id_front, i);
        }
        if (this.fFt < 1) {
            am.setImageResource(this.fFo, R.drawable.pic_id_back, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if (i == 101) {
                com.baidu.adp.lib.e.c.gr().a(this.fFg, 32, this.dAi, getUniqueId());
                this.fFs = 1;
            } else if (i == 102) {
                com.baidu.adp.lib.e.c.gr().a(this.fFh, 32, this.dAi, getUniqueId());
                this.fFt = 1;
            }
            if (this.fFj != null) {
                if (this.fFt >= 1 && this.fFs >= 1) {
                    this.fFj.setEnabled(true);
                } else {
                    this.fFj.setEnabled(false);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.cHV);
        MessageManager.getInstance().unRegisterListener(this.mHttpMessageListener);
        if (this.fFr != null && this.fFr.isShowing()) {
            g.dismissDialog(this.fFr, this);
        }
        super.onDestroy();
    }
}
