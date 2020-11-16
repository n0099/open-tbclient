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
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.barselect.data.CommitCardInfoReqMsg;
import java.io.File;
/* loaded from: classes20.dex */
public class IdentityReviewActivity extends BaseActivity {
    private long forumId;
    private com.baidu.tieba.barselect.data.c hSn;
    private com.baidu.tieba.barselect.data.b hTR;
    public String hTS;
    public String hTT;
    private View hTU;
    private TextView hTV;
    private TextView hTW;
    private TextView hTX;
    private TextView hTY;
    private TbImageView hTZ;
    private TbImageView hUa;
    private TextView hUb;
    private TextView hUc;
    private com.baidu.tieba.barselect.view.a hUd;
    private NavigationBar mNavigationBar;
    private boolean needRetry = false;
    private int hUe = 0;
    private int hUf = 0;
    private View.OnClickListener fhp = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.IdentityReviewActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == R.id.identity_card_positive) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2921412, new CameraActivityConfig(IdentityReviewActivity.this, IdentityReviewActivity.this.hTS, CameraActivityConfig.CONTENT_TYPE_ID_CARD_FRONT, 101)));
            } else if (view.getId() == R.id.identity_card_negative) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2921412, new CameraActivityConfig(IdentityReviewActivity.this, IdentityReviewActivity.this.hTT, CameraActivityConfig.CONTENT_TYPE_ID_CARD_BACK, 102)));
            } else if (view.getId() == R.id.bottom_next_button) {
                new a(IdentityReviewActivity.this.hTS, 1, IdentityReviewActivity.this.hSn).execute(new Void[0]);
                IdentityReviewActivity.this.needRetry = true;
                IdentityReviewActivity.this.hUd = new com.baidu.tieba.barselect.view.a(IdentityReviewActivity.this);
                IdentityReviewActivity.this.hUd.setCancelable(true);
                IdentityReviewActivity.this.hUd.setCanceledOnTouchOutside(false);
                IdentityReviewActivity.this.hUd.setMessage(TbadkCoreApplication.getInst().getString(R.string.check_id_card));
                g.showDialog(IdentityReviewActivity.this.hUd, IdentityReviewActivity.this);
            }
        }
    };
    com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a> fqS = new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.barselect.idCard.IdentityReviewActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.e.b
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            super.onLoaded((AnonymousClass2) aVar, str, i);
            if (str != null && aVar != null) {
                if (str.equals(IdentityReviewActivity.this.hTS)) {
                    aVar.drawImageTo(IdentityReviewActivity.this.hTZ);
                    IdentityReviewActivity.this.hUb.setVisibility(0);
                } else if (str.equals(IdentityReviewActivity.this.hTT)) {
                    aVar.drawImageTo(IdentityReviewActivity.this.hUa);
                    IdentityReviewActivity.this.hUc.setVisibility(0);
                }
            }
            if (str != null) {
                com.baidu.tbadk.imageManager.c.bAt().deletePic(str + 32);
            }
        }
    };
    com.baidu.adp.framework.listener.a epK = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_COMMIT_CARD_INFO, 309643) { // from class: com.baidu.tieba.barselect.idCard.IdentityReviewActivity.3
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage != null && responsedMessage.getOrginalMessage() != null) {
                int error = responsedMessage.getError();
                Object extra = responsedMessage.getOrginalMessage().getExtra();
                if (extra instanceof CommitCardInfoReqMsg) {
                    if (error == 0) {
                        if (((CommitCardInfoReqMsg) extra).card_type == 1) {
                            IdentityReviewActivity.this.hUe = 2;
                        } else if (((CommitCardInfoReqMsg) extra).card_type == 2) {
                            IdentityReviewActivity.this.hUf = 2;
                        }
                        if (IdentityReviewActivity.this.hUe < 2 || IdentityReviewActivity.this.hUf < 2) {
                            if (IdentityReviewActivity.this.hUf == 1) {
                                if (IdentityReviewActivity.this.hSn == null) {
                                    if (IdentityReviewActivity.this.hUd != null) {
                                        g.dismissDialog(IdentityReviewActivity.this.hUd, IdentityReviewActivity.this);
                                        return;
                                    }
                                    return;
                                }
                                new a(IdentityReviewActivity.this.hTT, 2, IdentityReviewActivity.this.hSn).execute(new Void[0]);
                            }
                        } else if (IdentityReviewActivity.this.hTR != null) {
                            IdentityReviewActivity.this.hTR.fr(IdentityReviewActivity.this.forumId);
                        } else if (IdentityReviewActivity.this.hUd != null) {
                            g.dismissDialog(IdentityReviewActivity.this.hUd, IdentityReviewActivity.this);
                        }
                    } else if (error != -100000303 || !IdentityReviewActivity.this.needRetry) {
                        if (IdentityReviewActivity.this.hUd != null && IdentityReviewActivity.this.hUd.isShowing()) {
                            g.dismissDialog(IdentityReviewActivity.this.hUd, IdentityReviewActivity.this);
                        }
                        l.showLongToast(TbadkCoreApplication.getInst(), responsedMessage.getErrorString());
                        IdentityReviewActivity.this.hUe = 1;
                        IdentityReviewActivity.this.hUf = 1;
                    } else {
                        IdentityReviewActivity.this.hUe = 1;
                        IdentityReviewActivity.this.hUf = 1;
                        if (IdentityReviewActivity.this.hSn != null) {
                            IdentityReviewActivity.this.needRetry = false;
                            new a(IdentityReviewActivity.this.hTS, 1, IdentityReviewActivity.this.hSn).execute(new Void[0]);
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
                if (IdentityReviewActivity.this.hUd != null && IdentityReviewActivity.this.hUd.isShowing()) {
                    g.dismissDialog(IdentityReviewActivity.this.hUd, IdentityReviewActivity.this);
                }
                String str = "https://tieba.baidu.com/mo/q/newmanagerapplyresult?passIDCert=1&nomenu=1&forum_id=" + IdentityReviewActivity.this.forumId;
                if (error == 0) {
                    bf.bqF().b(IdentityReviewActivity.this.getPageContext(), new String[]{str});
                    IdentityReviewActivity.this.setResult(-1);
                    IdentityReviewActivity.this.finish();
                    return;
                }
                l.showLongToast(TbadkCoreApplication.getInst(), httpResponsedMessage.getErrorString());
                IdentityReviewActivity.this.hUe = 1;
                IdentityReviewActivity.this.hUf = 1;
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.identity_review_activity);
        this.forumId = getIntent().getLongExtra("fid", 0L);
        this.hSn = new com.baidu.tieba.barselect.data.c(getPageContext());
        this.hTR = new com.baidu.tieba.barselect.data.b(getPageContext());
        this.hTS = new File(TbadkCoreApplication.getInst().getFilesDir(), "positive.jpg").getAbsolutePath();
        this.hTT = new File(TbadkCoreApplication.getInst().getFilesDir(), "negative.jpg").getAbsolutePath();
        this.hTU = findViewById(R.id.id_card_view);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.id_review_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(getResources().getString(R.string.bar_manager_apply));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.hTV = (TextView) findViewById(R.id.bottom_next_button);
        this.hTV.setEnabled(false);
        this.hTW = (TextView) findViewById(R.id.identity_view_title);
        this.hTX = (TextView) findViewById(R.id.positive_card_coloct_tip);
        this.hTY = (TextView) findViewById(R.id.negative_card_coloct_tip);
        this.hTZ = (TbImageView) findViewById(R.id.identity_card_positive);
        this.hUa = (TbImageView) findViewById(R.id.identity_card_negative);
        this.hUb = (TextView) findViewById(R.id.identity_card_positive_logo);
        this.hUc = (TextView) findViewById(R.id.identity_card_negative_logo);
        MessageManager.getInstance().registerListener(this.epK);
        MessageManager.getInstance().registerListener(this.mHttpMessageListener);
        this.hTZ.setOnClickListener(this.fhp);
        this.hUa.setOnClickListener(this.fhp);
        this.hTV.setOnClickListener(this.fhp);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        }
        ap.setViewTextColor(this.hTV, R.color.CAM_X0101, 1, i);
        ap.setBackgroundResource(this.hTV, R.drawable.bg_id_card_button, i);
        ap.setViewTextColor(this.hTW, R.color.CAM_X0105, 1, i);
        ap.setViewTextColor(this.hTX, R.color.CAM_X0109, 1, i);
        ap.setViewTextColor(this.hTY, R.color.CAM_X0109, 1, i);
        int dimens = l.getDimens(this, R.dimen.tbds10);
        ap.setViewTextColor(this.hUb, R.color.CAM_X0101, 1, i);
        ap.setViewTextColor(this.hUc, R.color.CAM_X0101, 1, i);
        ap.c(this.hUb, dimens, R.color.cp_cont_b_alpha42, R.color.cp_cont_b_alpha42, i);
        ap.c(this.hUc, dimens, R.color.cp_cont_b_alpha42, R.color.cp_cont_b_alpha42, i);
        if (this.hUe < 1) {
            ap.setImageResource(this.hTZ, R.drawable.pic_id_front, i);
        }
        if (this.hUf < 1) {
            ap.setImageResource(this.hUa, R.drawable.pic_id_back, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if (i == 101) {
                com.baidu.adp.lib.e.c.mS().a(this.hTS, 32, this.fqS, getUniqueId());
                this.hUe = 1;
            } else if (i == 102) {
                com.baidu.adp.lib.e.c.mS().a(this.hTT, 32, this.fqS, getUniqueId());
                this.hUf = 1;
            }
            if (this.hTV != null) {
                if (this.hUf >= 1 && this.hUe >= 1) {
                    this.hTV.setEnabled(true);
                } else {
                    this.hTV.setEnabled(false);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.epK);
        MessageManager.getInstance().unRegisterListener(this.mHttpMessageListener);
        if (this.hUd != null && this.hUd.isShowing()) {
            g.dismissDialog(this.hUd, this);
        }
        super.onDestroy();
    }
}
