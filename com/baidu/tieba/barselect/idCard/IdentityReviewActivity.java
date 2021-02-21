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
/* loaded from: classes8.dex */
public class IdentityReviewActivity extends BaseActivity {
    private long forumId;
    private com.baidu.tieba.barselect.data.c iqU;
    private TextView isA;
    private TextView isB;
    private TextView isC;
    private TextView isD;
    private TbImageView isE;
    private TbImageView isF;
    private TextView isG;
    private TextView isH;
    private com.baidu.tieba.barselect.view.a isI;
    private com.baidu.tieba.barselect.data.b isw;
    public String isx;
    public String isy;
    private View isz;
    private NavigationBar mNavigationBar;
    private boolean needRetry = false;
    private int isJ = 0;
    private int isK = 0;
    private View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.IdentityReviewActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == R.id.identity_card_positive) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2921412, new CameraActivityConfig(IdentityReviewActivity.this, IdentityReviewActivity.this.isx, CameraActivityConfig.CONTENT_TYPE_ID_CARD_FRONT, 101)));
            } else if (view.getId() == R.id.identity_card_negative) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2921412, new CameraActivityConfig(IdentityReviewActivity.this, IdentityReviewActivity.this.isy, CameraActivityConfig.CONTENT_TYPE_ID_CARD_BACK, 102)));
            } else if (view.getId() == R.id.bottom_next_button) {
                new a(IdentityReviewActivity.this.isx, 1, IdentityReviewActivity.this.iqU).execute(new Void[0]);
                IdentityReviewActivity.this.needRetry = true;
                IdentityReviewActivity.this.isI = new com.baidu.tieba.barselect.view.a(IdentityReviewActivity.this);
                IdentityReviewActivity.this.isI.setCancelable(true);
                IdentityReviewActivity.this.isI.setCanceledOnTouchOutside(false);
                IdentityReviewActivity.this.isI.setMessage(TbadkCoreApplication.getInst().getString(R.string.check_id_card));
                g.showDialog(IdentityReviewActivity.this.isI, IdentityReviewActivity.this);
            }
        }
    };
    com.baidu.adp.lib.e.c<com.baidu.adp.widget.ImageView.a> fFS = new com.baidu.adp.lib.e.c<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.barselect.idCard.IdentityReviewActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.e.c
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            super.onLoaded((AnonymousClass2) aVar, str, i);
            if (str != null && aVar != null) {
                if (str.equals(IdentityReviewActivity.this.isx)) {
                    aVar.drawImageTo(IdentityReviewActivity.this.isE);
                    IdentityReviewActivity.this.isG.setVisibility(0);
                } else if (str.equals(IdentityReviewActivity.this.isy)) {
                    aVar.drawImageTo(IdentityReviewActivity.this.isF);
                    IdentityReviewActivity.this.isH.setVisibility(0);
                }
            }
            if (str != null) {
                com.baidu.tbadk.imageManager.c.bCP().deletePic(str + 32);
            }
        }
    };
    com.baidu.adp.framework.listener.a eDt = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_COMMIT_CARD_INFO, 309643) { // from class: com.baidu.tieba.barselect.idCard.IdentityReviewActivity.3
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage != null && responsedMessage.getOrginalMessage() != null) {
                int error = responsedMessage.getError();
                Object extra = responsedMessage.getOrginalMessage().getExtra();
                if (extra instanceof CommitCardInfoReqMsg) {
                    if (error == 0) {
                        if (((CommitCardInfoReqMsg) extra).card_type == 1) {
                            IdentityReviewActivity.this.isJ = 2;
                        } else if (((CommitCardInfoReqMsg) extra).card_type == 2) {
                            IdentityReviewActivity.this.isK = 2;
                        }
                        if (IdentityReviewActivity.this.isJ < 2 || IdentityReviewActivity.this.isK < 2) {
                            if (IdentityReviewActivity.this.isK == 1) {
                                if (IdentityReviewActivity.this.iqU == null) {
                                    if (IdentityReviewActivity.this.isI != null) {
                                        g.dismissDialog(IdentityReviewActivity.this.isI, IdentityReviewActivity.this);
                                        return;
                                    }
                                    return;
                                }
                                new a(IdentityReviewActivity.this.isy, 2, IdentityReviewActivity.this.iqU).execute(new Void[0]);
                            }
                        } else if (IdentityReviewActivity.this.isw != null) {
                            IdentityReviewActivity.this.isw.ga(IdentityReviewActivity.this.forumId);
                        } else if (IdentityReviewActivity.this.isI != null) {
                            g.dismissDialog(IdentityReviewActivity.this.isI, IdentityReviewActivity.this);
                        }
                    } else if (error != -100000303 || !IdentityReviewActivity.this.needRetry) {
                        if (IdentityReviewActivity.this.isI != null && IdentityReviewActivity.this.isI.isShowing()) {
                            g.dismissDialog(IdentityReviewActivity.this.isI, IdentityReviewActivity.this);
                        }
                        l.showLongToast(TbadkCoreApplication.getInst(), responsedMessage.getErrorString());
                        IdentityReviewActivity.this.isJ = 1;
                        IdentityReviewActivity.this.isK = 1;
                    } else {
                        IdentityReviewActivity.this.isJ = 1;
                        IdentityReviewActivity.this.isK = 1;
                        if (IdentityReviewActivity.this.iqU != null) {
                            IdentityReviewActivity.this.needRetry = false;
                            new a(IdentityReviewActivity.this.isx, 1, IdentityReviewActivity.this.iqU).execute(new Void[0]);
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
                if (IdentityReviewActivity.this.isI != null && IdentityReviewActivity.this.isI.isShowing()) {
                    g.dismissDialog(IdentityReviewActivity.this.isI, IdentityReviewActivity.this);
                }
                String str = "https://tieba.baidu.com/mo/q/newmanagerapplyresult?passIDCert=1&nomenu=1&forum_id=" + IdentityReviewActivity.this.forumId;
                if (error == 0) {
                    bf.bsV().b(IdentityReviewActivity.this.getPageContext(), new String[]{str});
                    IdentityReviewActivity.this.setResult(-1);
                    IdentityReviewActivity.this.finish();
                    return;
                }
                l.showLongToast(TbadkCoreApplication.getInst(), httpResponsedMessage.getErrorString());
                IdentityReviewActivity.this.isJ = 1;
                IdentityReviewActivity.this.isK = 1;
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.identity_review_activity);
        this.forumId = getIntent().getLongExtra("fid", 0L);
        this.iqU = new com.baidu.tieba.barselect.data.c(getPageContext());
        this.isw = new com.baidu.tieba.barselect.data.b(getPageContext());
        this.isx = new File(TbadkCoreApplication.getInst().getFilesDir(), "positive.jpg").getAbsolutePath();
        this.isy = new File(TbadkCoreApplication.getInst().getFilesDir(), "negative.jpg").getAbsolutePath();
        this.isz = findViewById(R.id.id_card_view);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.id_review_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(getResources().getString(R.string.bar_manager_apply));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.isA = (TextView) findViewById(R.id.bottom_next_button);
        this.isA.setEnabled(false);
        this.isB = (TextView) findViewById(R.id.identity_view_title);
        this.isC = (TextView) findViewById(R.id.positive_card_coloct_tip);
        this.isD = (TextView) findViewById(R.id.negative_card_coloct_tip);
        this.isE = (TbImageView) findViewById(R.id.identity_card_positive);
        this.isF = (TbImageView) findViewById(R.id.identity_card_negative);
        this.isG = (TextView) findViewById(R.id.identity_card_positive_logo);
        this.isH = (TextView) findViewById(R.id.identity_card_negative_logo);
        MessageManager.getInstance().registerListener(this.eDt);
        MessageManager.getInstance().registerListener(this.mHttpMessageListener);
        this.isE.setOnClickListener(this.onClickListener);
        this.isF.setOnClickListener(this.onClickListener);
        this.isA.setOnClickListener(this.onClickListener);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        }
        ap.setViewTextColor(this.isA, R.color.CAM_X0101, 1, i);
        ap.setBackgroundResource(this.isA, R.drawable.bg_id_card_button, i);
        ap.setViewTextColor(this.isB, R.color.CAM_X0105, 1, i);
        ap.setViewTextColor(this.isC, R.color.CAM_X0109, 1, i);
        ap.setViewTextColor(this.isD, R.color.CAM_X0109, 1, i);
        int dimens = l.getDimens(this, R.dimen.tbds10);
        ap.setViewTextColor(this.isG, R.color.CAM_X0101, 1, i);
        ap.setViewTextColor(this.isH, R.color.CAM_X0101, 1, i);
        ap.e(this.isG, dimens, R.color.cp_cont_b_alpha42, R.color.cp_cont_b_alpha42, i);
        ap.e(this.isH, dimens, R.color.cp_cont_b_alpha42, R.color.cp_cont_b_alpha42, i);
        if (this.isJ < 1) {
            ap.setImageResource(this.isE, R.drawable.pic_id_front, i);
        }
        if (this.isK < 1) {
            ap.setImageResource(this.isF, R.drawable.pic_id_back, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if (i == 101) {
                com.baidu.adp.lib.e.d.mw().a(this.isx, 32, this.fFS, getUniqueId());
                this.isJ = 1;
            } else if (i == 102) {
                com.baidu.adp.lib.e.d.mw().a(this.isy, 32, this.fFS, getUniqueId());
                this.isK = 1;
            }
            if (this.isA != null) {
                if (this.isK >= 1 && this.isJ >= 1) {
                    this.isA.setEnabled(true);
                } else {
                    this.isA.setEnabled(false);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.eDt);
        MessageManager.getInstance().unRegisterListener(this.mHttpMessageListener);
        if (this.isI != null && this.isI.isShowing()) {
            g.dismissDialog(this.isI, this);
        }
        super.onDestroy();
    }
}
