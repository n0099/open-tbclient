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
    private com.baidu.tieba.barselect.data.c eyd;
    private com.baidu.tieba.barselect.data.b ezJ;
    public String ezK;
    public String ezL;
    private View ezM;
    private TextView ezN;
    private TextView ezO;
    private TextView ezP;
    private TextView ezQ;
    private TbImageView ezR;
    private TbImageView ezS;
    private TextView ezT;
    private TextView ezU;
    private com.baidu.tieba.barselect.view.a ezV;
    private long forumId;
    private NavigationBar mNavigationBar;
    private boolean needRetry = false;
    private int ezW = 0;
    private int ezX = 0;
    private View.OnClickListener cmX = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.IdentityReviewActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == R.id.identity_card_positive) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2921412, new CameraActivityConfig(IdentityReviewActivity.this, IdentityReviewActivity.this.ezK, CameraActivityConfig.CONTENT_TYPE_ID_CARD_FRONT, 101)));
            } else if (view.getId() == R.id.identity_card_negative) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2921412, new CameraActivityConfig(IdentityReviewActivity.this, IdentityReviewActivity.this.ezL, CameraActivityConfig.CONTENT_TYPE_ID_CARD_BACK, 102)));
            } else if (view.getId() == R.id.bottom_next_button) {
                new a(IdentityReviewActivity.this.ezK, 1, IdentityReviewActivity.this.eyd).execute(new Void[0]);
                IdentityReviewActivity.this.needRetry = true;
                IdentityReviewActivity.this.ezV = new com.baidu.tieba.barselect.view.a(IdentityReviewActivity.this);
                IdentityReviewActivity.this.ezV.setCancelable(true);
                IdentityReviewActivity.this.ezV.setCanceledOnTouchOutside(false);
                IdentityReviewActivity.this.ezV.setMessage(TbadkCoreApplication.getInst().getString(R.string.check_id_card));
                g.a(IdentityReviewActivity.this.ezV, IdentityReviewActivity.this);
            }
        }
    };
    com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a> cwM = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.barselect.idCard.IdentityReviewActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.f.b
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            super.onLoaded((AnonymousClass2) aVar, str, i);
            if (str != null && aVar != null) {
                if (str.equals(IdentityReviewActivity.this.ezK)) {
                    aVar.a(IdentityReviewActivity.this.ezR);
                    IdentityReviewActivity.this.ezT.setVisibility(0);
                } else if (str.equals(IdentityReviewActivity.this.ezL)) {
                    aVar.a(IdentityReviewActivity.this.ezS);
                    IdentityReviewActivity.this.ezU.setVisibility(0);
                }
            }
            if (str != null) {
                com.baidu.tbadk.imageManager.c.atK().qQ(str + 32);
            }
        }
    };
    com.baidu.adp.framework.listener.a bzz = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_COMMIT_CARD_INFO, 309643) { // from class: com.baidu.tieba.barselect.idCard.IdentityReviewActivity.3
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage != null && responsedMessage.getOrginalMessage() != null) {
                int error = responsedMessage.getError();
                Object extra = responsedMessage.getOrginalMessage().getExtra();
                if (extra instanceof CommitCardInfoReqMsg) {
                    if (error == 0) {
                        if (((CommitCardInfoReqMsg) extra).card_type == 1) {
                            IdentityReviewActivity.this.ezW = 2;
                        } else if (((CommitCardInfoReqMsg) extra).card_type == 2) {
                            IdentityReviewActivity.this.ezX = 2;
                        }
                        if (IdentityReviewActivity.this.ezW < 2 || IdentityReviewActivity.this.ezX < 2) {
                            if (IdentityReviewActivity.this.ezX == 1) {
                                if (IdentityReviewActivity.this.eyd == null) {
                                    if (IdentityReviewActivity.this.ezV != null) {
                                        g.b(IdentityReviewActivity.this.ezV, IdentityReviewActivity.this);
                                        return;
                                    }
                                    return;
                                }
                                new a(IdentityReviewActivity.this.ezL, 2, IdentityReviewActivity.this.eyd).execute(new Void[0]);
                            }
                        } else if (IdentityReviewActivity.this.ezJ != null) {
                            IdentityReviewActivity.this.ezJ.cD(IdentityReviewActivity.this.forumId);
                        } else if (IdentityReviewActivity.this.ezV != null) {
                            g.b(IdentityReviewActivity.this.ezV, IdentityReviewActivity.this);
                        }
                    } else if (error != -100000303 || !IdentityReviewActivity.this.needRetry) {
                        if (IdentityReviewActivity.this.ezV != null && IdentityReviewActivity.this.ezV.isShowing()) {
                            g.b(IdentityReviewActivity.this.ezV, IdentityReviewActivity.this);
                        }
                        l.E(TbadkCoreApplication.getInst(), responsedMessage.getErrorString());
                        IdentityReviewActivity.this.ezW = 1;
                        IdentityReviewActivity.this.ezX = 1;
                    } else {
                        IdentityReviewActivity.this.ezW = 1;
                        IdentityReviewActivity.this.ezX = 1;
                        if (IdentityReviewActivity.this.eyd != null) {
                            IdentityReviewActivity.this.needRetry = false;
                            new a(IdentityReviewActivity.this.ezK, 1, IdentityReviewActivity.this.eyd).execute(new Void[0]);
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
                if (IdentityReviewActivity.this.ezV != null && IdentityReviewActivity.this.ezV.isShowing()) {
                    g.b(IdentityReviewActivity.this.ezV, IdentityReviewActivity.this);
                }
                String str = "https://tieba.baidu.com/mo/q/newmanagerapplyresult?passIDCert=1&nomenu=1&forum_id=" + IdentityReviewActivity.this.forumId;
                if (error == 0) {
                    ba.ajK().c(IdentityReviewActivity.this.getPageContext(), new String[]{str});
                    IdentityReviewActivity.this.setResult(-1);
                    IdentityReviewActivity.this.finish();
                    return;
                }
                l.E(TbadkCoreApplication.getInst(), httpResponsedMessage.getErrorString());
                IdentityReviewActivity.this.ezW = 1;
                IdentityReviewActivity.this.ezX = 1;
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.identity_review_activity);
        this.forumId = getIntent().getLongExtra("fid", 0L);
        this.eyd = new com.baidu.tieba.barselect.data.c(getPageContext());
        this.ezJ = new com.baidu.tieba.barselect.data.b(getPageContext());
        this.ezK = new File(TbadkCoreApplication.getInst().getFilesDir(), "positive.jpg").getAbsolutePath();
        this.ezL = new File(TbadkCoreApplication.getInst().getFilesDir(), "negative.jpg").getAbsolutePath();
        this.ezM = findViewById(R.id.id_card_view);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.id_review_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(getResources().getString(R.string.bar_manager_apply));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.ezN = (TextView) findViewById(R.id.bottom_next_button);
        this.ezN.setEnabled(false);
        this.ezO = (TextView) findViewById(R.id.identity_view_title);
        this.ezP = (TextView) findViewById(R.id.positive_card_coloct_tip);
        this.ezQ = (TextView) findViewById(R.id.negative_card_coloct_tip);
        this.ezR = (TbImageView) findViewById(R.id.identity_card_positive);
        this.ezS = (TbImageView) findViewById(R.id.identity_card_negative);
        this.ezT = (TextView) findViewById(R.id.identity_card_positive_logo);
        this.ezU = (TextView) findViewById(R.id.identity_card_negative_logo);
        MessageManager.getInstance().registerListener(this.bzz);
        MessageManager.getInstance().registerListener(this.mHttpMessageListener);
        this.ezR.setOnClickListener(this.cmX);
        this.ezS.setOnClickListener(this.cmX);
        this.ezN.setOnClickListener(this.cmX);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        }
        am.d(this.ezN, R.color.cp_cont_a, 1, i);
        am.g(this.ezN, R.drawable.bg_id_card_button, i);
        am.d(this.ezO, R.color.cp_cont_b, 1, i);
        am.d(this.ezP, R.color.cp_cont_d, 1, i);
        am.d(this.ezQ, R.color.cp_cont_d, 1, i);
        int g = l.g(this, R.dimen.tbds10);
        am.d(this.ezT, R.color.cp_cont_a, 1, i);
        am.d(this.ezU, R.color.cp_cont_a, 1, i);
        am.b(this.ezT, g, (int) R.color.cp_cont_b_alpha42, (int) R.color.cp_cont_b_alpha42, i);
        am.b(this.ezU, g, (int) R.color.cp_cont_b_alpha42, (int) R.color.cp_cont_b_alpha42, i);
        if (this.ezW < 1) {
            am.b(this.ezR, (int) R.drawable.pic_id_front, i);
        }
        if (this.ezX < 1) {
            am.b(this.ezS, (int) R.drawable.pic_id_back, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if (i == 101) {
                com.baidu.adp.lib.f.c.iE().a(this.ezK, 32, this.cwM, getUniqueId());
                this.ezW = 1;
            } else if (i == 102) {
                com.baidu.adp.lib.f.c.iE().a(this.ezL, 32, this.cwM, getUniqueId());
                this.ezX = 1;
            }
            if (this.ezN != null) {
                if (this.ezX >= 1 && this.ezW >= 1) {
                    this.ezN.setEnabled(true);
                } else {
                    this.ezN.setEnabled(false);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.bzz);
        MessageManager.getInstance().unRegisterListener(this.mHttpMessageListener);
        if (this.ezV != null && this.ezV.isShowing()) {
            g.b(this.ezV, this);
        }
        super.onDestroy();
    }
}
