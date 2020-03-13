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
    private com.baidu.tieba.barselect.data.c fDR;
    private TextView fFA;
    private TextView fFB;
    private TbImageView fFC;
    private TbImageView fFD;
    private TextView fFE;
    private TextView fFF;
    private com.baidu.tieba.barselect.view.a fFG;
    private com.baidu.tieba.barselect.data.b fFu;
    public String fFv;
    public String fFw;
    private View fFx;
    private TextView fFy;
    private TextView fFz;
    private long forumId;
    private NavigationBar mNavigationBar;
    private boolean needRetry = false;
    private int fFH = 0;
    private int fFI = 0;
    private View.OnClickListener drw = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.IdentityReviewActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == R.id.identity_card_positive) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2921412, new CameraActivityConfig(IdentityReviewActivity.this, IdentityReviewActivity.this.fFv, CameraActivityConfig.CONTENT_TYPE_ID_CARD_FRONT, 101)));
            } else if (view.getId() == R.id.identity_card_negative) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2921412, new CameraActivityConfig(IdentityReviewActivity.this, IdentityReviewActivity.this.fFw, CameraActivityConfig.CONTENT_TYPE_ID_CARD_BACK, 102)));
            } else if (view.getId() == R.id.bottom_next_button) {
                new a(IdentityReviewActivity.this.fFv, 1, IdentityReviewActivity.this.fDR).execute(new Void[0]);
                IdentityReviewActivity.this.needRetry = true;
                IdentityReviewActivity.this.fFG = new com.baidu.tieba.barselect.view.a(IdentityReviewActivity.this);
                IdentityReviewActivity.this.fFG.setCancelable(true);
                IdentityReviewActivity.this.fFG.setCanceledOnTouchOutside(false);
                IdentityReviewActivity.this.fFG.setMessage(TbadkCoreApplication.getInst().getString(R.string.check_id_card));
                g.showDialog(IdentityReviewActivity.this.fFG, IdentityReviewActivity.this);
            }
        }
    };
    com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a> dAw = new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.barselect.idCard.IdentityReviewActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.e.b
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            super.onLoaded((AnonymousClass2) aVar, str, i);
            if (str != null && aVar != null) {
                if (str.equals(IdentityReviewActivity.this.fFv)) {
                    aVar.drawImageTo(IdentityReviewActivity.this.fFC);
                    IdentityReviewActivity.this.fFE.setVisibility(0);
                } else if (str.equals(IdentityReviewActivity.this.fFw)) {
                    aVar.drawImageTo(IdentityReviewActivity.this.fFD);
                    IdentityReviewActivity.this.fFF.setVisibility(0);
                }
            }
            if (str != null) {
                com.baidu.tbadk.imageManager.c.aPR().deletePic(str + 32);
            }
        }
    };
    com.baidu.adp.framework.listener.a cHX = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_COMMIT_CARD_INFO, 309643) { // from class: com.baidu.tieba.barselect.idCard.IdentityReviewActivity.3
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage != null && responsedMessage.getOrginalMessage() != null) {
                int error = responsedMessage.getError();
                Object extra = responsedMessage.getOrginalMessage().getExtra();
                if (extra instanceof CommitCardInfoReqMsg) {
                    if (error == 0) {
                        if (((CommitCardInfoReqMsg) extra).card_type == 1) {
                            IdentityReviewActivity.this.fFH = 2;
                        } else if (((CommitCardInfoReqMsg) extra).card_type == 2) {
                            IdentityReviewActivity.this.fFI = 2;
                        }
                        if (IdentityReviewActivity.this.fFH < 2 || IdentityReviewActivity.this.fFI < 2) {
                            if (IdentityReviewActivity.this.fFI == 1) {
                                if (IdentityReviewActivity.this.fDR == null) {
                                    if (IdentityReviewActivity.this.fFG != null) {
                                        g.dismissDialog(IdentityReviewActivity.this.fFG, IdentityReviewActivity.this);
                                        return;
                                    }
                                    return;
                                }
                                new a(IdentityReviewActivity.this.fFw, 2, IdentityReviewActivity.this.fDR).execute(new Void[0]);
                            }
                        } else if (IdentityReviewActivity.this.fFu != null) {
                            IdentityReviewActivity.this.fFu.dg(IdentityReviewActivity.this.forumId);
                        } else if (IdentityReviewActivity.this.fFG != null) {
                            g.dismissDialog(IdentityReviewActivity.this.fFG, IdentityReviewActivity.this);
                        }
                    } else if (error != -100000303 || !IdentityReviewActivity.this.needRetry) {
                        if (IdentityReviewActivity.this.fFG != null && IdentityReviewActivity.this.fFG.isShowing()) {
                            g.dismissDialog(IdentityReviewActivity.this.fFG, IdentityReviewActivity.this);
                        }
                        l.showLongToast(TbadkCoreApplication.getInst(), responsedMessage.getErrorString());
                        IdentityReviewActivity.this.fFH = 1;
                        IdentityReviewActivity.this.fFI = 1;
                    } else {
                        IdentityReviewActivity.this.fFH = 1;
                        IdentityReviewActivity.this.fFI = 1;
                        if (IdentityReviewActivity.this.fDR != null) {
                            IdentityReviewActivity.this.needRetry = false;
                            new a(IdentityReviewActivity.this.fFv, 1, IdentityReviewActivity.this.fDR).execute(new Void[0]);
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
                if (IdentityReviewActivity.this.fFG != null && IdentityReviewActivity.this.fFG.isShowing()) {
                    g.dismissDialog(IdentityReviewActivity.this.fFG, IdentityReviewActivity.this);
                }
                String str = "https://tieba.baidu.com/mo/q/newmanagerapplyresult?passIDCert=1&nomenu=1&forum_id=" + IdentityReviewActivity.this.forumId;
                if (error == 0) {
                    ba.aGG().b(IdentityReviewActivity.this.getPageContext(), new String[]{str});
                    IdentityReviewActivity.this.setResult(-1);
                    IdentityReviewActivity.this.finish();
                    return;
                }
                l.showLongToast(TbadkCoreApplication.getInst(), httpResponsedMessage.getErrorString());
                IdentityReviewActivity.this.fFH = 1;
                IdentityReviewActivity.this.fFI = 1;
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.identity_review_activity);
        this.forumId = getIntent().getLongExtra("fid", 0L);
        this.fDR = new com.baidu.tieba.barselect.data.c(getPageContext());
        this.fFu = new com.baidu.tieba.barselect.data.b(getPageContext());
        this.fFv = new File(TbadkCoreApplication.getInst().getFilesDir(), "positive.jpg").getAbsolutePath();
        this.fFw = new File(TbadkCoreApplication.getInst().getFilesDir(), "negative.jpg").getAbsolutePath();
        this.fFx = findViewById(R.id.id_card_view);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.id_review_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(getResources().getString(R.string.bar_manager_apply));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.fFy = (TextView) findViewById(R.id.bottom_next_button);
        this.fFy.setEnabled(false);
        this.fFz = (TextView) findViewById(R.id.identity_view_title);
        this.fFA = (TextView) findViewById(R.id.positive_card_coloct_tip);
        this.fFB = (TextView) findViewById(R.id.negative_card_coloct_tip);
        this.fFC = (TbImageView) findViewById(R.id.identity_card_positive);
        this.fFD = (TbImageView) findViewById(R.id.identity_card_negative);
        this.fFE = (TextView) findViewById(R.id.identity_card_positive_logo);
        this.fFF = (TextView) findViewById(R.id.identity_card_negative_logo);
        MessageManager.getInstance().registerListener(this.cHX);
        MessageManager.getInstance().registerListener(this.mHttpMessageListener);
        this.fFC.setOnClickListener(this.drw);
        this.fFD.setOnClickListener(this.drw);
        this.fFy.setOnClickListener(this.drw);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        }
        am.setViewTextColor(this.fFy, R.color.cp_cont_a, 1, i);
        am.setBackgroundResource(this.fFy, R.drawable.bg_id_card_button, i);
        am.setViewTextColor(this.fFz, R.color.cp_cont_b, 1, i);
        am.setViewTextColor(this.fFA, R.color.cp_cont_d, 1, i);
        am.setViewTextColor(this.fFB, R.color.cp_cont_d, 1, i);
        int dimens = l.getDimens(this, R.dimen.tbds10);
        am.setViewTextColor(this.fFE, R.color.cp_cont_a, 1, i);
        am.setViewTextColor(this.fFF, R.color.cp_cont_a, 1, i);
        am.c(this.fFE, dimens, (int) R.color.cp_cont_b_alpha42, (int) R.color.cp_cont_b_alpha42, i);
        am.c(this.fFF, dimens, (int) R.color.cp_cont_b_alpha42, (int) R.color.cp_cont_b_alpha42, i);
        if (this.fFH < 1) {
            am.setImageResource(this.fFC, R.drawable.pic_id_front, i);
        }
        if (this.fFI < 1) {
            am.setImageResource(this.fFD, R.drawable.pic_id_back, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if (i == 101) {
                com.baidu.adp.lib.e.c.gr().a(this.fFv, 32, this.dAw, getUniqueId());
                this.fFH = 1;
            } else if (i == 102) {
                com.baidu.adp.lib.e.c.gr().a(this.fFw, 32, this.dAw, getUniqueId());
                this.fFI = 1;
            }
            if (this.fFy != null) {
                if (this.fFI >= 1 && this.fFH >= 1) {
                    this.fFy.setEnabled(true);
                } else {
                    this.fFy.setEnabled(false);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.cHX);
        MessageManager.getInstance().unRegisterListener(this.mHttpMessageListener);
        if (this.fFG != null && this.fFG.isShowing()) {
            g.dismissDialog(this.fFG, this);
        }
        super.onDestroy();
    }
}
