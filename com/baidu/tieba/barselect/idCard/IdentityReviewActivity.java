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
    private com.baidu.tieba.barselect.data.c hRN;
    private TbImageView hTA;
    private TextView hTB;
    private TextView hTC;
    private com.baidu.tieba.barselect.view.a hTD;
    private com.baidu.tieba.barselect.data.b hTr;
    public String hTs;
    public String hTt;
    private View hTu;
    private TextView hTv;
    private TextView hTw;
    private TextView hTx;
    private TextView hTy;
    private TbImageView hTz;
    private NavigationBar mNavigationBar;
    private boolean needRetry = false;
    private int hTE = 0;
    private int hTF = 0;
    private View.OnClickListener fii = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.IdentityReviewActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == R.id.identity_card_positive) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2921412, new CameraActivityConfig(IdentityReviewActivity.this, IdentityReviewActivity.this.hTs, CameraActivityConfig.CONTENT_TYPE_ID_CARD_FRONT, 101)));
            } else if (view.getId() == R.id.identity_card_negative) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2921412, new CameraActivityConfig(IdentityReviewActivity.this, IdentityReviewActivity.this.hTt, CameraActivityConfig.CONTENT_TYPE_ID_CARD_BACK, 102)));
            } else if (view.getId() == R.id.bottom_next_button) {
                new a(IdentityReviewActivity.this.hTs, 1, IdentityReviewActivity.this.hRN).execute(new Void[0]);
                IdentityReviewActivity.this.needRetry = true;
                IdentityReviewActivity.this.hTD = new com.baidu.tieba.barselect.view.a(IdentityReviewActivity.this);
                IdentityReviewActivity.this.hTD.setCancelable(true);
                IdentityReviewActivity.this.hTD.setCanceledOnTouchOutside(false);
                IdentityReviewActivity.this.hTD.setMessage(TbadkCoreApplication.getInst().getString(R.string.check_id_card));
                g.showDialog(IdentityReviewActivity.this.hTD, IdentityReviewActivity.this);
            }
        }
    };
    com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a> frM = new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.barselect.idCard.IdentityReviewActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.e.b
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            super.onLoaded((AnonymousClass2) aVar, str, i);
            if (str != null && aVar != null) {
                if (str.equals(IdentityReviewActivity.this.hTs)) {
                    aVar.drawImageTo(IdentityReviewActivity.this.hTz);
                    IdentityReviewActivity.this.hTB.setVisibility(0);
                } else if (str.equals(IdentityReviewActivity.this.hTt)) {
                    aVar.drawImageTo(IdentityReviewActivity.this.hTA);
                    IdentityReviewActivity.this.hTC.setVisibility(0);
                }
            }
            if (str != null) {
                com.baidu.tbadk.imageManager.c.bBd().deletePic(str + 32);
            }
        }
    };
    com.baidu.adp.framework.listener.a ers = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_COMMIT_CARD_INFO, 309643) { // from class: com.baidu.tieba.barselect.idCard.IdentityReviewActivity.3
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage != null && responsedMessage.getOrginalMessage() != null) {
                int error = responsedMessage.getError();
                Object extra = responsedMessage.getOrginalMessage().getExtra();
                if (extra instanceof CommitCardInfoReqMsg) {
                    if (error == 0) {
                        if (((CommitCardInfoReqMsg) extra).card_type == 1) {
                            IdentityReviewActivity.this.hTE = 2;
                        } else if (((CommitCardInfoReqMsg) extra).card_type == 2) {
                            IdentityReviewActivity.this.hTF = 2;
                        }
                        if (IdentityReviewActivity.this.hTE < 2 || IdentityReviewActivity.this.hTF < 2) {
                            if (IdentityReviewActivity.this.hTF == 1) {
                                if (IdentityReviewActivity.this.hRN == null) {
                                    if (IdentityReviewActivity.this.hTD != null) {
                                        g.dismissDialog(IdentityReviewActivity.this.hTD, IdentityReviewActivity.this);
                                        return;
                                    }
                                    return;
                                }
                                new a(IdentityReviewActivity.this.hTt, 2, IdentityReviewActivity.this.hRN).execute(new Void[0]);
                            }
                        } else if (IdentityReviewActivity.this.hTr != null) {
                            IdentityReviewActivity.this.hTr.fo(IdentityReviewActivity.this.forumId);
                        } else if (IdentityReviewActivity.this.hTD != null) {
                            g.dismissDialog(IdentityReviewActivity.this.hTD, IdentityReviewActivity.this);
                        }
                    } else if (error != -100000303 || !IdentityReviewActivity.this.needRetry) {
                        if (IdentityReviewActivity.this.hTD != null && IdentityReviewActivity.this.hTD.isShowing()) {
                            g.dismissDialog(IdentityReviewActivity.this.hTD, IdentityReviewActivity.this);
                        }
                        l.showLongToast(TbadkCoreApplication.getInst(), responsedMessage.getErrorString());
                        IdentityReviewActivity.this.hTE = 1;
                        IdentityReviewActivity.this.hTF = 1;
                    } else {
                        IdentityReviewActivity.this.hTE = 1;
                        IdentityReviewActivity.this.hTF = 1;
                        if (IdentityReviewActivity.this.hRN != null) {
                            IdentityReviewActivity.this.needRetry = false;
                            new a(IdentityReviewActivity.this.hTs, 1, IdentityReviewActivity.this.hRN).execute(new Void[0]);
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
                if (IdentityReviewActivity.this.hTD != null && IdentityReviewActivity.this.hTD.isShowing()) {
                    g.dismissDialog(IdentityReviewActivity.this.hTD, IdentityReviewActivity.this);
                }
                String str = "https://tieba.baidu.com/mo/q/newmanagerapplyresult?passIDCert=1&nomenu=1&forum_id=" + IdentityReviewActivity.this.forumId;
                if (error == 0) {
                    be.brr().b(IdentityReviewActivity.this.getPageContext(), new String[]{str});
                    IdentityReviewActivity.this.setResult(-1);
                    IdentityReviewActivity.this.finish();
                    return;
                }
                l.showLongToast(TbadkCoreApplication.getInst(), httpResponsedMessage.getErrorString());
                IdentityReviewActivity.this.hTE = 1;
                IdentityReviewActivity.this.hTF = 1;
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.identity_review_activity);
        this.forumId = getIntent().getLongExtra("fid", 0L);
        this.hRN = new com.baidu.tieba.barselect.data.c(getPageContext());
        this.hTr = new com.baidu.tieba.barselect.data.b(getPageContext());
        this.hTs = new File(TbadkCoreApplication.getInst().getFilesDir(), "positive.jpg").getAbsolutePath();
        this.hTt = new File(TbadkCoreApplication.getInst().getFilesDir(), "negative.jpg").getAbsolutePath();
        this.hTu = findViewById(R.id.id_card_view);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.id_review_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(getResources().getString(R.string.bar_manager_apply));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.hTv = (TextView) findViewById(R.id.bottom_next_button);
        this.hTv.setEnabled(false);
        this.hTw = (TextView) findViewById(R.id.identity_view_title);
        this.hTx = (TextView) findViewById(R.id.positive_card_coloct_tip);
        this.hTy = (TextView) findViewById(R.id.negative_card_coloct_tip);
        this.hTz = (TbImageView) findViewById(R.id.identity_card_positive);
        this.hTA = (TbImageView) findViewById(R.id.identity_card_negative);
        this.hTB = (TextView) findViewById(R.id.identity_card_positive_logo);
        this.hTC = (TextView) findViewById(R.id.identity_card_negative_logo);
        MessageManager.getInstance().registerListener(this.ers);
        MessageManager.getInstance().registerListener(this.mHttpMessageListener);
        this.hTz.setOnClickListener(this.fii);
        this.hTA.setOnClickListener(this.fii);
        this.hTv.setOnClickListener(this.fii);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        }
        ap.setViewTextColor(this.hTv, R.color.cp_cont_a, 1, i);
        ap.setBackgroundResource(this.hTv, R.drawable.bg_id_card_button, i);
        ap.setViewTextColor(this.hTw, R.color.cp_cont_b, 1, i);
        ap.setViewTextColor(this.hTx, R.color.cp_cont_d, 1, i);
        ap.setViewTextColor(this.hTy, R.color.cp_cont_d, 1, i);
        int dimens = l.getDimens(this, R.dimen.tbds10);
        ap.setViewTextColor(this.hTB, R.color.cp_cont_a, 1, i);
        ap.setViewTextColor(this.hTC, R.color.cp_cont_a, 1, i);
        ap.c(this.hTB, dimens, R.color.cp_cont_b_alpha42, R.color.cp_cont_b_alpha42, i);
        ap.c(this.hTC, dimens, R.color.cp_cont_b_alpha42, R.color.cp_cont_b_alpha42, i);
        if (this.hTE < 1) {
            ap.setImageResource(this.hTz, R.drawable.pic_id_front, i);
        }
        if (this.hTF < 1) {
            ap.setImageResource(this.hTA, R.drawable.pic_id_back, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if (i == 101) {
                com.baidu.adp.lib.e.c.mS().a(this.hTs, 32, this.frM, getUniqueId());
                this.hTE = 1;
            } else if (i == 102) {
                com.baidu.adp.lib.e.c.mS().a(this.hTt, 32, this.frM, getUniqueId());
                this.hTF = 1;
            }
            if (this.hTv != null) {
                if (this.hTF >= 1 && this.hTE >= 1) {
                    this.hTv.setEnabled(true);
                } else {
                    this.hTv.setEnabled(false);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.ers);
        MessageManager.getInstance().unRegisterListener(this.mHttpMessageListener);
        if (this.hTD != null && this.hTD.isShowing()) {
            g.dismissDialog(this.hTD, this);
        }
        super.onDestroy();
    }
}
