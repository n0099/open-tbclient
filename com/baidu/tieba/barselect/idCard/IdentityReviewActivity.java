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
    private com.baidu.tieba.barselect.data.c eGM;
    private TbImageView eIA;
    private TextView eIB;
    private TextView eIC;
    private com.baidu.tieba.barselect.view.a eID;
    private com.baidu.tieba.barselect.data.b eIr;
    public String eIs;
    public String eIt;
    private View eIu;
    private TextView eIv;
    private TextView eIw;
    private TextView eIx;
    private TextView eIy;
    private TbImageView eIz;
    private long forumId;
    private NavigationBar mNavigationBar;
    private boolean needRetry = false;
    private int eIE = 0;
    private int eIF = 0;
    private View.OnClickListener czV = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.IdentityReviewActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == R.id.identity_card_positive) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2921412, new CameraActivityConfig(IdentityReviewActivity.this, IdentityReviewActivity.this.eIs, CameraActivityConfig.CONTENT_TYPE_ID_CARD_FRONT, 101)));
            } else if (view.getId() == R.id.identity_card_negative) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2921412, new CameraActivityConfig(IdentityReviewActivity.this, IdentityReviewActivity.this.eIt, CameraActivityConfig.CONTENT_TYPE_ID_CARD_BACK, 102)));
            } else if (view.getId() == R.id.bottom_next_button) {
                new a(IdentityReviewActivity.this.eIs, 1, IdentityReviewActivity.this.eGM).execute(new Void[0]);
                IdentityReviewActivity.this.needRetry = true;
                IdentityReviewActivity.this.eID = new com.baidu.tieba.barselect.view.a(IdentityReviewActivity.this);
                IdentityReviewActivity.this.eID.setCancelable(true);
                IdentityReviewActivity.this.eID.setCanceledOnTouchOutside(false);
                IdentityReviewActivity.this.eID.setMessage(TbadkCoreApplication.getInst().getString(R.string.check_id_card));
                g.showDialog(IdentityReviewActivity.this.eID, IdentityReviewActivity.this);
            }
        }
    };
    com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a> cIV = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.barselect.idCard.IdentityReviewActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.f.b
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            super.onLoaded((AnonymousClass2) aVar, str, i);
            if (str != null && aVar != null) {
                if (str.equals(IdentityReviewActivity.this.eIs)) {
                    aVar.drawImageTo(IdentityReviewActivity.this.eIz);
                    IdentityReviewActivity.this.eIB.setVisibility(0);
                } else if (str.equals(IdentityReviewActivity.this.eIt)) {
                    aVar.drawImageTo(IdentityReviewActivity.this.eIA);
                    IdentityReviewActivity.this.eIC.setVisibility(0);
                }
            }
            if (str != null) {
                com.baidu.tbadk.imageManager.c.avu().deletePic(str + 32);
            }
        }
    };
    com.baidu.adp.framework.listener.a bSf = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_COMMIT_CARD_INFO, 309643) { // from class: com.baidu.tieba.barselect.idCard.IdentityReviewActivity.3
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage != null && responsedMessage.getOrginalMessage() != null) {
                int error = responsedMessage.getError();
                Object extra = responsedMessage.getOrginalMessage().getExtra();
                if (extra instanceof CommitCardInfoReqMsg) {
                    if (error == 0) {
                        if (((CommitCardInfoReqMsg) extra).card_type == 1) {
                            IdentityReviewActivity.this.eIE = 2;
                        } else if (((CommitCardInfoReqMsg) extra).card_type == 2) {
                            IdentityReviewActivity.this.eIF = 2;
                        }
                        if (IdentityReviewActivity.this.eIE < 2 || IdentityReviewActivity.this.eIF < 2) {
                            if (IdentityReviewActivity.this.eIF == 1) {
                                if (IdentityReviewActivity.this.eGM == null) {
                                    if (IdentityReviewActivity.this.eID != null) {
                                        g.dismissDialog(IdentityReviewActivity.this.eID, IdentityReviewActivity.this);
                                        return;
                                    }
                                    return;
                                }
                                new a(IdentityReviewActivity.this.eIt, 2, IdentityReviewActivity.this.eGM).execute(new Void[0]);
                            }
                        } else if (IdentityReviewActivity.this.eIr != null) {
                            IdentityReviewActivity.this.eIr.cr(IdentityReviewActivity.this.forumId);
                        } else if (IdentityReviewActivity.this.eID != null) {
                            g.dismissDialog(IdentityReviewActivity.this.eID, IdentityReviewActivity.this);
                        }
                    } else if (error != -100000303 || !IdentityReviewActivity.this.needRetry) {
                        if (IdentityReviewActivity.this.eID != null && IdentityReviewActivity.this.eID.isShowing()) {
                            g.dismissDialog(IdentityReviewActivity.this.eID, IdentityReviewActivity.this);
                        }
                        l.showLongToast(TbadkCoreApplication.getInst(), responsedMessage.getErrorString());
                        IdentityReviewActivity.this.eIE = 1;
                        IdentityReviewActivity.this.eIF = 1;
                    } else {
                        IdentityReviewActivity.this.eIE = 1;
                        IdentityReviewActivity.this.eIF = 1;
                        if (IdentityReviewActivity.this.eGM != null) {
                            IdentityReviewActivity.this.needRetry = false;
                            new a(IdentityReviewActivity.this.eIs, 1, IdentityReviewActivity.this.eGM).execute(new Void[0]);
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
                if (IdentityReviewActivity.this.eID != null && IdentityReviewActivity.this.eID.isShowing()) {
                    g.dismissDialog(IdentityReviewActivity.this.eID, IdentityReviewActivity.this);
                }
                String str = "https://tieba.baidu.com/mo/q/newmanagerapplyresult?passIDCert=1&nomenu=1&forum_id=" + IdentityReviewActivity.this.forumId;
                if (error == 0) {
                    ba.amQ().b(IdentityReviewActivity.this.getPageContext(), new String[]{str});
                    IdentityReviewActivity.this.setResult(-1);
                    IdentityReviewActivity.this.finish();
                    return;
                }
                l.showLongToast(TbadkCoreApplication.getInst(), httpResponsedMessage.getErrorString());
                IdentityReviewActivity.this.eIE = 1;
                IdentityReviewActivity.this.eIF = 1;
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.identity_review_activity);
        this.forumId = getIntent().getLongExtra("fid", 0L);
        this.eGM = new com.baidu.tieba.barselect.data.c(getPageContext());
        this.eIr = new com.baidu.tieba.barselect.data.b(getPageContext());
        this.eIs = new File(TbadkCoreApplication.getInst().getFilesDir(), "positive.jpg").getAbsolutePath();
        this.eIt = new File(TbadkCoreApplication.getInst().getFilesDir(), "negative.jpg").getAbsolutePath();
        this.eIu = findViewById(R.id.id_card_view);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.id_review_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(getResources().getString(R.string.bar_manager_apply));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eIv = (TextView) findViewById(R.id.bottom_next_button);
        this.eIv.setEnabled(false);
        this.eIw = (TextView) findViewById(R.id.identity_view_title);
        this.eIx = (TextView) findViewById(R.id.positive_card_coloct_tip);
        this.eIy = (TextView) findViewById(R.id.negative_card_coloct_tip);
        this.eIz = (TbImageView) findViewById(R.id.identity_card_positive);
        this.eIA = (TbImageView) findViewById(R.id.identity_card_negative);
        this.eIB = (TextView) findViewById(R.id.identity_card_positive_logo);
        this.eIC = (TextView) findViewById(R.id.identity_card_negative_logo);
        MessageManager.getInstance().registerListener(this.bSf);
        MessageManager.getInstance().registerListener(this.mHttpMessageListener);
        this.eIz.setOnClickListener(this.czV);
        this.eIA.setOnClickListener(this.czV);
        this.eIv.setOnClickListener(this.czV);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        }
        am.setViewTextColor(this.eIv, R.color.cp_cont_a, 1, i);
        am.setBackgroundResource(this.eIv, R.drawable.bg_id_card_button, i);
        am.setViewTextColor(this.eIw, R.color.cp_cont_b, 1, i);
        am.setViewTextColor(this.eIx, R.color.cp_cont_d, 1, i);
        am.setViewTextColor(this.eIy, R.color.cp_cont_d, 1, i);
        int dimens = l.getDimens(this, R.dimen.tbds10);
        am.setViewTextColor(this.eIB, R.color.cp_cont_a, 1, i);
        am.setViewTextColor(this.eIC, R.color.cp_cont_a, 1, i);
        am.c(this.eIB, dimens, (int) R.color.cp_cont_b_alpha42, (int) R.color.cp_cont_b_alpha42, i);
        am.c(this.eIC, dimens, (int) R.color.cp_cont_b_alpha42, (int) R.color.cp_cont_b_alpha42, i);
        if (this.eIE < 1) {
            am.setImageResource(this.eIz, R.drawable.pic_id_front, i);
        }
        if (this.eIF < 1) {
            am.setImageResource(this.eIA, R.drawable.pic_id_back, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if (i == 101) {
                com.baidu.adp.lib.f.c.fT().a(this.eIs, 32, this.cIV, getUniqueId());
                this.eIE = 1;
            } else if (i == 102) {
                com.baidu.adp.lib.f.c.fT().a(this.eIt, 32, this.cIV, getUniqueId());
                this.eIF = 1;
            }
            if (this.eIv != null) {
                if (this.eIF >= 1 && this.eIE >= 1) {
                    this.eIv.setEnabled(true);
                } else {
                    this.eIv.setEnabled(false);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.bSf);
        MessageManager.getInstance().unRegisterListener(this.mHttpMessageListener);
        if (this.eID != null && this.eID.isShowing()) {
            g.dismissDialog(this.eID, this);
        }
        super.onDestroy();
    }
}
