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
    private com.baidu.tieba.barselect.data.c iqG;
    private com.baidu.tieba.barselect.data.b isi;
    public String isj;
    public String isk;
    private View isl;
    private TextView ism;
    private TextView isn;
    private TextView iso;
    private TextView isp;
    private TbImageView isq;
    private TbImageView isr;
    private TextView iss;
    private TextView ist;
    private com.baidu.tieba.barselect.view.a isu;
    private NavigationBar mNavigationBar;
    private boolean needRetry = false;
    private int isv = 0;
    private int isw = 0;
    private View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.IdentityReviewActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == R.id.identity_card_positive) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2921412, new CameraActivityConfig(IdentityReviewActivity.this, IdentityReviewActivity.this.isj, CameraActivityConfig.CONTENT_TYPE_ID_CARD_FRONT, 101)));
            } else if (view.getId() == R.id.identity_card_negative) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2921412, new CameraActivityConfig(IdentityReviewActivity.this, IdentityReviewActivity.this.isk, CameraActivityConfig.CONTENT_TYPE_ID_CARD_BACK, 102)));
            } else if (view.getId() == R.id.bottom_next_button) {
                new a(IdentityReviewActivity.this.isj, 1, IdentityReviewActivity.this.iqG).execute(new Void[0]);
                IdentityReviewActivity.this.needRetry = true;
                IdentityReviewActivity.this.isu = new com.baidu.tieba.barselect.view.a(IdentityReviewActivity.this);
                IdentityReviewActivity.this.isu.setCancelable(true);
                IdentityReviewActivity.this.isu.setCanceledOnTouchOutside(false);
                IdentityReviewActivity.this.isu.setMessage(TbadkCoreApplication.getInst().getString(R.string.check_id_card));
                g.showDialog(IdentityReviewActivity.this.isu, IdentityReviewActivity.this);
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
                if (str.equals(IdentityReviewActivity.this.isj)) {
                    aVar.drawImageTo(IdentityReviewActivity.this.isq);
                    IdentityReviewActivity.this.iss.setVisibility(0);
                } else if (str.equals(IdentityReviewActivity.this.isk)) {
                    aVar.drawImageTo(IdentityReviewActivity.this.isr);
                    IdentityReviewActivity.this.ist.setVisibility(0);
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
                            IdentityReviewActivity.this.isv = 2;
                        } else if (((CommitCardInfoReqMsg) extra).card_type == 2) {
                            IdentityReviewActivity.this.isw = 2;
                        }
                        if (IdentityReviewActivity.this.isv < 2 || IdentityReviewActivity.this.isw < 2) {
                            if (IdentityReviewActivity.this.isw == 1) {
                                if (IdentityReviewActivity.this.iqG == null) {
                                    if (IdentityReviewActivity.this.isu != null) {
                                        g.dismissDialog(IdentityReviewActivity.this.isu, IdentityReviewActivity.this);
                                        return;
                                    }
                                    return;
                                }
                                new a(IdentityReviewActivity.this.isk, 2, IdentityReviewActivity.this.iqG).execute(new Void[0]);
                            }
                        } else if (IdentityReviewActivity.this.isi != null) {
                            IdentityReviewActivity.this.isi.ga(IdentityReviewActivity.this.forumId);
                        } else if (IdentityReviewActivity.this.isu != null) {
                            g.dismissDialog(IdentityReviewActivity.this.isu, IdentityReviewActivity.this);
                        }
                    } else if (error != -100000303 || !IdentityReviewActivity.this.needRetry) {
                        if (IdentityReviewActivity.this.isu != null && IdentityReviewActivity.this.isu.isShowing()) {
                            g.dismissDialog(IdentityReviewActivity.this.isu, IdentityReviewActivity.this);
                        }
                        l.showLongToast(TbadkCoreApplication.getInst(), responsedMessage.getErrorString());
                        IdentityReviewActivity.this.isv = 1;
                        IdentityReviewActivity.this.isw = 1;
                    } else {
                        IdentityReviewActivity.this.isv = 1;
                        IdentityReviewActivity.this.isw = 1;
                        if (IdentityReviewActivity.this.iqG != null) {
                            IdentityReviewActivity.this.needRetry = false;
                            new a(IdentityReviewActivity.this.isj, 1, IdentityReviewActivity.this.iqG).execute(new Void[0]);
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
                if (IdentityReviewActivity.this.isu != null && IdentityReviewActivity.this.isu.isShowing()) {
                    g.dismissDialog(IdentityReviewActivity.this.isu, IdentityReviewActivity.this);
                }
                String str = "https://tieba.baidu.com/mo/q/newmanagerapplyresult?passIDCert=1&nomenu=1&forum_id=" + IdentityReviewActivity.this.forumId;
                if (error == 0) {
                    bf.bsV().b(IdentityReviewActivity.this.getPageContext(), new String[]{str});
                    IdentityReviewActivity.this.setResult(-1);
                    IdentityReviewActivity.this.finish();
                    return;
                }
                l.showLongToast(TbadkCoreApplication.getInst(), httpResponsedMessage.getErrorString());
                IdentityReviewActivity.this.isv = 1;
                IdentityReviewActivity.this.isw = 1;
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.identity_review_activity);
        this.forumId = getIntent().getLongExtra("fid", 0L);
        this.iqG = new com.baidu.tieba.barselect.data.c(getPageContext());
        this.isi = new com.baidu.tieba.barselect.data.b(getPageContext());
        this.isj = new File(TbadkCoreApplication.getInst().getFilesDir(), "positive.jpg").getAbsolutePath();
        this.isk = new File(TbadkCoreApplication.getInst().getFilesDir(), "negative.jpg").getAbsolutePath();
        this.isl = findViewById(R.id.id_card_view);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.id_review_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(getResources().getString(R.string.bar_manager_apply));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.ism = (TextView) findViewById(R.id.bottom_next_button);
        this.ism.setEnabled(false);
        this.isn = (TextView) findViewById(R.id.identity_view_title);
        this.iso = (TextView) findViewById(R.id.positive_card_coloct_tip);
        this.isp = (TextView) findViewById(R.id.negative_card_coloct_tip);
        this.isq = (TbImageView) findViewById(R.id.identity_card_positive);
        this.isr = (TbImageView) findViewById(R.id.identity_card_negative);
        this.iss = (TextView) findViewById(R.id.identity_card_positive_logo);
        this.ist = (TextView) findViewById(R.id.identity_card_negative_logo);
        MessageManager.getInstance().registerListener(this.eDt);
        MessageManager.getInstance().registerListener(this.mHttpMessageListener);
        this.isq.setOnClickListener(this.onClickListener);
        this.isr.setOnClickListener(this.onClickListener);
        this.ism.setOnClickListener(this.onClickListener);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        }
        ap.setViewTextColor(this.ism, R.color.CAM_X0101, 1, i);
        ap.setBackgroundResource(this.ism, R.drawable.bg_id_card_button, i);
        ap.setViewTextColor(this.isn, R.color.CAM_X0105, 1, i);
        ap.setViewTextColor(this.iso, R.color.CAM_X0109, 1, i);
        ap.setViewTextColor(this.isp, R.color.CAM_X0109, 1, i);
        int dimens = l.getDimens(this, R.dimen.tbds10);
        ap.setViewTextColor(this.iss, R.color.CAM_X0101, 1, i);
        ap.setViewTextColor(this.ist, R.color.CAM_X0101, 1, i);
        ap.e(this.iss, dimens, R.color.cp_cont_b_alpha42, R.color.cp_cont_b_alpha42, i);
        ap.e(this.ist, dimens, R.color.cp_cont_b_alpha42, R.color.cp_cont_b_alpha42, i);
        if (this.isv < 1) {
            ap.setImageResource(this.isq, R.drawable.pic_id_front, i);
        }
        if (this.isw < 1) {
            ap.setImageResource(this.isr, R.drawable.pic_id_back, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if (i == 101) {
                com.baidu.adp.lib.e.d.mw().a(this.isj, 32, this.fFS, getUniqueId());
                this.isv = 1;
            } else if (i == 102) {
                com.baidu.adp.lib.e.d.mw().a(this.isk, 32, this.fFS, getUniqueId());
                this.isw = 1;
            }
            if (this.ism != null) {
                if (this.isw >= 1 && this.isv >= 1) {
                    this.ism.setEnabled(true);
                } else {
                    this.ism.setEnabled(false);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.eDt);
        MessageManager.getInstance().unRegisterListener(this.mHttpMessageListener);
        if (this.isu != null && this.isu.isShowing()) {
            g.dismissDialog(this.isu, this);
        }
        super.onDestroy();
    }
}
