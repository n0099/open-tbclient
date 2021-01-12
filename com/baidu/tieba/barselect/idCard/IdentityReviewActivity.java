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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.barselect.data.CommitCardInfoReqMsg;
import java.io.File;
/* loaded from: classes7.dex */
public class IdentityReviewActivity extends BaseActivity {
    private long forumId;
    private com.baidu.tieba.barselect.data.c ikY;
    private com.baidu.tieba.barselect.data.b imD;
    public String imE;
    public String imF;
    private View imG;
    private TextView imH;
    private TextView imI;
    private TextView imJ;
    private TextView imK;
    private TbImageView imL;
    private TbImageView imM;
    private TextView imN;
    private TextView imO;
    private com.baidu.tieba.barselect.view.a imP;
    private NavigationBar mNavigationBar;
    private boolean needRetry = false;
    private int imQ = 0;
    private int imR = 0;
    private View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.IdentityReviewActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == R.id.identity_card_positive) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2921412, new CameraActivityConfig(IdentityReviewActivity.this, IdentityReviewActivity.this.imE, CameraActivityConfig.CONTENT_TYPE_ID_CARD_FRONT, 101)));
            } else if (view.getId() == R.id.identity_card_negative) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2921412, new CameraActivityConfig(IdentityReviewActivity.this, IdentityReviewActivity.this.imF, CameraActivityConfig.CONTENT_TYPE_ID_CARD_BACK, 102)));
            } else if (view.getId() == R.id.bottom_next_button) {
                new a(IdentityReviewActivity.this.imE, 1, IdentityReviewActivity.this.ikY).execute(new Void[0]);
                IdentityReviewActivity.this.needRetry = true;
                IdentityReviewActivity.this.imP = new com.baidu.tieba.barselect.view.a(IdentityReviewActivity.this);
                IdentityReviewActivity.this.imP.setCancelable(true);
                IdentityReviewActivity.this.imP.setCanceledOnTouchOutside(false);
                IdentityReviewActivity.this.imP.setMessage(TbadkCoreApplication.getInst().getString(R.string.check_id_card));
                g.showDialog(IdentityReviewActivity.this.imP, IdentityReviewActivity.this);
            }
        }
    };
    com.baidu.adp.lib.e.c<com.baidu.adp.widget.ImageView.a> fDG = new com.baidu.adp.lib.e.c<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.barselect.idCard.IdentityReviewActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.e.c
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            super.onLoaded((AnonymousClass2) aVar, str, i);
            if (str != null && aVar != null) {
                if (str.equals(IdentityReviewActivity.this.imE)) {
                    aVar.drawImageTo(IdentityReviewActivity.this.imL);
                    IdentityReviewActivity.this.imN.setVisibility(0);
                } else if (str.equals(IdentityReviewActivity.this.imF)) {
                    aVar.drawImageTo(IdentityReviewActivity.this.imM);
                    IdentityReviewActivity.this.imO.setVisibility(0);
                }
            }
            if (str != null) {
                com.baidu.tbadk.imageManager.c.bCx().deletePic(str + 32);
            }
        }
    };
    com.baidu.adp.framework.listener.a eBn = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_COMMIT_CARD_INFO, 309643) { // from class: com.baidu.tieba.barselect.idCard.IdentityReviewActivity.3
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage != null && responsedMessage.getOrginalMessage() != null) {
                int error = responsedMessage.getError();
                Object extra = responsedMessage.getOrginalMessage().getExtra();
                if (extra instanceof CommitCardInfoReqMsg) {
                    if (error == 0) {
                        if (((CommitCardInfoReqMsg) extra).card_type == 1) {
                            IdentityReviewActivity.this.imQ = 2;
                        } else if (((CommitCardInfoReqMsg) extra).card_type == 2) {
                            IdentityReviewActivity.this.imR = 2;
                        }
                        if (IdentityReviewActivity.this.imQ < 2 || IdentityReviewActivity.this.imR < 2) {
                            if (IdentityReviewActivity.this.imR == 1) {
                                if (IdentityReviewActivity.this.ikY == null) {
                                    if (IdentityReviewActivity.this.imP != null) {
                                        g.dismissDialog(IdentityReviewActivity.this.imP, IdentityReviewActivity.this);
                                        return;
                                    }
                                    return;
                                }
                                new a(IdentityReviewActivity.this.imF, 2, IdentityReviewActivity.this.ikY).execute(new Void[0]);
                            }
                        } else if (IdentityReviewActivity.this.imD != null) {
                            IdentityReviewActivity.this.imD.fV(IdentityReviewActivity.this.forumId);
                        } else if (IdentityReviewActivity.this.imP != null) {
                            g.dismissDialog(IdentityReviewActivity.this.imP, IdentityReviewActivity.this);
                        }
                    } else if (error != -100000303 || !IdentityReviewActivity.this.needRetry) {
                        if (IdentityReviewActivity.this.imP != null && IdentityReviewActivity.this.imP.isShowing()) {
                            g.dismissDialog(IdentityReviewActivity.this.imP, IdentityReviewActivity.this);
                        }
                        l.showLongToast(TbadkCoreApplication.getInst(), responsedMessage.getErrorString());
                        IdentityReviewActivity.this.imQ = 1;
                        IdentityReviewActivity.this.imR = 1;
                    } else {
                        IdentityReviewActivity.this.imQ = 1;
                        IdentityReviewActivity.this.imR = 1;
                        if (IdentityReviewActivity.this.ikY != null) {
                            IdentityReviewActivity.this.needRetry = false;
                            new a(IdentityReviewActivity.this.imE, 1, IdentityReviewActivity.this.ikY).execute(new Void[0]);
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
                if (IdentityReviewActivity.this.imP != null && IdentityReviewActivity.this.imP.isShowing()) {
                    g.dismissDialog(IdentityReviewActivity.this.imP, IdentityReviewActivity.this);
                }
                String str = "https://tieba.baidu.com/mo/q/newmanagerapplyresult?passIDCert=1&nomenu=1&forum_id=" + IdentityReviewActivity.this.forumId;
                if (error == 0) {
                    be.bsB().b(IdentityReviewActivity.this.getPageContext(), new String[]{str});
                    IdentityReviewActivity.this.setResult(-1);
                    IdentityReviewActivity.this.finish();
                    return;
                }
                l.showLongToast(TbadkCoreApplication.getInst(), httpResponsedMessage.getErrorString());
                IdentityReviewActivity.this.imQ = 1;
                IdentityReviewActivity.this.imR = 1;
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.identity_review_activity);
        this.forumId = getIntent().getLongExtra("fid", 0L);
        this.ikY = new com.baidu.tieba.barselect.data.c(getPageContext());
        this.imD = new com.baidu.tieba.barselect.data.b(getPageContext());
        this.imE = new File(TbadkCoreApplication.getInst().getFilesDir(), "positive.jpg").getAbsolutePath();
        this.imF = new File(TbadkCoreApplication.getInst().getFilesDir(), "negative.jpg").getAbsolutePath();
        this.imG = findViewById(R.id.id_card_view);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.id_review_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(getResources().getString(R.string.bar_manager_apply));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.imH = (TextView) findViewById(R.id.bottom_next_button);
        this.imH.setEnabled(false);
        this.imI = (TextView) findViewById(R.id.identity_view_title);
        this.imJ = (TextView) findViewById(R.id.positive_card_coloct_tip);
        this.imK = (TextView) findViewById(R.id.negative_card_coloct_tip);
        this.imL = (TbImageView) findViewById(R.id.identity_card_positive);
        this.imM = (TbImageView) findViewById(R.id.identity_card_negative);
        this.imN = (TextView) findViewById(R.id.identity_card_positive_logo);
        this.imO = (TextView) findViewById(R.id.identity_card_negative_logo);
        MessageManager.getInstance().registerListener(this.eBn);
        MessageManager.getInstance().registerListener(this.mHttpMessageListener);
        this.imL.setOnClickListener(this.onClickListener);
        this.imM.setOnClickListener(this.onClickListener);
        this.imH.setOnClickListener(this.onClickListener);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        }
        ao.setViewTextColor(this.imH, R.color.CAM_X0101, 1, i);
        ao.setBackgroundResource(this.imH, R.drawable.bg_id_card_button, i);
        ao.setViewTextColor(this.imI, R.color.CAM_X0105, 1, i);
        ao.setViewTextColor(this.imJ, R.color.CAM_X0109, 1, i);
        ao.setViewTextColor(this.imK, R.color.CAM_X0109, 1, i);
        int dimens = l.getDimens(this, R.dimen.tbds10);
        ao.setViewTextColor(this.imN, R.color.CAM_X0101, 1, i);
        ao.setViewTextColor(this.imO, R.color.CAM_X0101, 1, i);
        ao.e(this.imN, dimens, R.color.cp_cont_b_alpha42, R.color.cp_cont_b_alpha42, i);
        ao.e(this.imO, dimens, R.color.cp_cont_b_alpha42, R.color.cp_cont_b_alpha42, i);
        if (this.imQ < 1) {
            ao.setImageResource(this.imL, R.drawable.pic_id_front, i);
        }
        if (this.imR < 1) {
            ao.setImageResource(this.imM, R.drawable.pic_id_back, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if (i == 101) {
                com.baidu.adp.lib.e.d.mx().a(this.imE, 32, this.fDG, getUniqueId());
                this.imQ = 1;
            } else if (i == 102) {
                com.baidu.adp.lib.e.d.mx().a(this.imF, 32, this.fDG, getUniqueId());
                this.imR = 1;
            }
            if (this.imH != null) {
                if (this.imR >= 1 && this.imQ >= 1) {
                    this.imH.setEnabled(true);
                } else {
                    this.imH.setEnabled(false);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.eBn);
        MessageManager.getInstance().unRegisterListener(this.mHttpMessageListener);
        if (this.imP != null && this.imP.isShowing()) {
            g.dismissDialog(this.imP, this);
        }
        super.onDestroy();
    }
}
