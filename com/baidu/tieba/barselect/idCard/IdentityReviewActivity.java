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
import com.baidu.tbadk.core.util.bd;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.barselect.data.CommitCardInfoReqMsg;
import java.io.File;
/* loaded from: classes15.dex */
public class IdentityReviewActivity extends BaseActivity {
    private long forumId;
    private com.baidu.tieba.barselect.data.c gQD;
    private com.baidu.tieba.barselect.data.b gSg;
    public String gSh;
    public String gSi;
    private View gSj;
    private TextView gSk;
    private TextView gSl;
    private TextView gSm;
    private TextView gSn;
    private TbImageView gSo;
    private TbImageView gSp;
    private TextView gSq;
    private TextView gSr;
    private com.baidu.tieba.barselect.view.a gSs;
    private NavigationBar mNavigationBar;
    private boolean needRetry = false;
    private int gSt = 0;
    private int gSu = 0;
    private View.OnClickListener eve = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.IdentityReviewActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == R.id.identity_card_positive) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2921412, new CameraActivityConfig(IdentityReviewActivity.this, IdentityReviewActivity.this.gSh, CameraActivityConfig.CONTENT_TYPE_ID_CARD_FRONT, 101)));
            } else if (view.getId() == R.id.identity_card_negative) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2921412, new CameraActivityConfig(IdentityReviewActivity.this, IdentityReviewActivity.this.gSi, CameraActivityConfig.CONTENT_TYPE_ID_CARD_BACK, 102)));
            } else if (view.getId() == R.id.bottom_next_button) {
                new a(IdentityReviewActivity.this.gSh, 1, IdentityReviewActivity.this.gQD).execute(new Void[0]);
                IdentityReviewActivity.this.needRetry = true;
                IdentityReviewActivity.this.gSs = new com.baidu.tieba.barselect.view.a(IdentityReviewActivity.this);
                IdentityReviewActivity.this.gSs.setCancelable(true);
                IdentityReviewActivity.this.gSs.setCanceledOnTouchOutside(false);
                IdentityReviewActivity.this.gSs.setMessage(TbadkCoreApplication.getInst().getString(R.string.check_id_card));
                g.showDialog(IdentityReviewActivity.this.gSs, IdentityReviewActivity.this);
            }
        }
    };
    com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a> eDQ = new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.barselect.idCard.IdentityReviewActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.e.b
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            super.onLoaded((AnonymousClass2) aVar, str, i);
            if (str != null && aVar != null) {
                if (str.equals(IdentityReviewActivity.this.gSh)) {
                    aVar.drawImageTo(IdentityReviewActivity.this.gSo);
                    IdentityReviewActivity.this.gSq.setVisibility(0);
                } else if (str.equals(IdentityReviewActivity.this.gSi)) {
                    aVar.drawImageTo(IdentityReviewActivity.this.gSp);
                    IdentityReviewActivity.this.gSr.setVisibility(0);
                }
            }
            if (str != null) {
                com.baidu.tbadk.imageManager.c.bkk().deletePic(str + 32);
            }
        }
    };
    com.baidu.adp.framework.listener.a dFJ = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_COMMIT_CARD_INFO, 309643) { // from class: com.baidu.tieba.barselect.idCard.IdentityReviewActivity.3
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage != null && responsedMessage.getOrginalMessage() != null) {
                int error = responsedMessage.getError();
                Object extra = responsedMessage.getOrginalMessage().getExtra();
                if (extra instanceof CommitCardInfoReqMsg) {
                    if (error == 0) {
                        if (((CommitCardInfoReqMsg) extra).card_type == 1) {
                            IdentityReviewActivity.this.gSt = 2;
                        } else if (((CommitCardInfoReqMsg) extra).card_type == 2) {
                            IdentityReviewActivity.this.gSu = 2;
                        }
                        if (IdentityReviewActivity.this.gSt < 2 || IdentityReviewActivity.this.gSu < 2) {
                            if (IdentityReviewActivity.this.gSu == 1) {
                                if (IdentityReviewActivity.this.gQD == null) {
                                    if (IdentityReviewActivity.this.gSs != null) {
                                        g.dismissDialog(IdentityReviewActivity.this.gSs, IdentityReviewActivity.this);
                                        return;
                                    }
                                    return;
                                }
                                new a(IdentityReviewActivity.this.gSi, 2, IdentityReviewActivity.this.gQD).execute(new Void[0]);
                            }
                        } else if (IdentityReviewActivity.this.gSg != null) {
                            IdentityReviewActivity.this.gSg.ef(IdentityReviewActivity.this.forumId);
                        } else if (IdentityReviewActivity.this.gSs != null) {
                            g.dismissDialog(IdentityReviewActivity.this.gSs, IdentityReviewActivity.this);
                        }
                    } else if (error != -100000303 || !IdentityReviewActivity.this.needRetry) {
                        if (IdentityReviewActivity.this.gSs != null && IdentityReviewActivity.this.gSs.isShowing()) {
                            g.dismissDialog(IdentityReviewActivity.this.gSs, IdentityReviewActivity.this);
                        }
                        l.showLongToast(TbadkCoreApplication.getInst(), responsedMessage.getErrorString());
                        IdentityReviewActivity.this.gSt = 1;
                        IdentityReviewActivity.this.gSu = 1;
                    } else {
                        IdentityReviewActivity.this.gSt = 1;
                        IdentityReviewActivity.this.gSu = 1;
                        if (IdentityReviewActivity.this.gQD != null) {
                            IdentityReviewActivity.this.needRetry = false;
                            new a(IdentityReviewActivity.this.gSh, 1, IdentityReviewActivity.this.gQD).execute(new Void[0]);
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
                if (IdentityReviewActivity.this.gSs != null && IdentityReviewActivity.this.gSs.isShowing()) {
                    g.dismissDialog(IdentityReviewActivity.this.gSs, IdentityReviewActivity.this);
                }
                String str = "https://tieba.baidu.com/mo/q/newmanagerapplyresult?passIDCert=1&nomenu=1&forum_id=" + IdentityReviewActivity.this.forumId;
                if (error == 0) {
                    bd.baV().b(IdentityReviewActivity.this.getPageContext(), new String[]{str});
                    IdentityReviewActivity.this.setResult(-1);
                    IdentityReviewActivity.this.finish();
                    return;
                }
                l.showLongToast(TbadkCoreApplication.getInst(), httpResponsedMessage.getErrorString());
                IdentityReviewActivity.this.gSt = 1;
                IdentityReviewActivity.this.gSu = 1;
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.identity_review_activity);
        this.forumId = getIntent().getLongExtra("fid", 0L);
        this.gQD = new com.baidu.tieba.barselect.data.c(getPageContext());
        this.gSg = new com.baidu.tieba.barselect.data.b(getPageContext());
        this.gSh = new File(TbadkCoreApplication.getInst().getFilesDir(), "positive.jpg").getAbsolutePath();
        this.gSi = new File(TbadkCoreApplication.getInst().getFilesDir(), "negative.jpg").getAbsolutePath();
        this.gSj = findViewById(R.id.id_card_view);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.id_review_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(getResources().getString(R.string.bar_manager_apply));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.gSk = (TextView) findViewById(R.id.bottom_next_button);
        this.gSk.setEnabled(false);
        this.gSl = (TextView) findViewById(R.id.identity_view_title);
        this.gSm = (TextView) findViewById(R.id.positive_card_coloct_tip);
        this.gSn = (TextView) findViewById(R.id.negative_card_coloct_tip);
        this.gSo = (TbImageView) findViewById(R.id.identity_card_positive);
        this.gSp = (TbImageView) findViewById(R.id.identity_card_negative);
        this.gSq = (TextView) findViewById(R.id.identity_card_positive_logo);
        this.gSr = (TextView) findViewById(R.id.identity_card_negative_logo);
        MessageManager.getInstance().registerListener(this.dFJ);
        MessageManager.getInstance().registerListener(this.mHttpMessageListener);
        this.gSo.setOnClickListener(this.eve);
        this.gSp.setOnClickListener(this.eve);
        this.gSk.setOnClickListener(this.eve);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        }
        ao.setViewTextColor(this.gSk, R.color.cp_cont_a, 1, i);
        ao.setBackgroundResource(this.gSk, R.drawable.bg_id_card_button, i);
        ao.setViewTextColor(this.gSl, R.color.cp_cont_b, 1, i);
        ao.setViewTextColor(this.gSm, R.color.cp_cont_d, 1, i);
        ao.setViewTextColor(this.gSn, R.color.cp_cont_d, 1, i);
        int dimens = l.getDimens(this, R.dimen.tbds10);
        ao.setViewTextColor(this.gSq, R.color.cp_cont_a, 1, i);
        ao.setViewTextColor(this.gSr, R.color.cp_cont_a, 1, i);
        ao.c(this.gSq, dimens, R.color.cp_cont_b_alpha42, R.color.cp_cont_b_alpha42, i);
        ao.c(this.gSr, dimens, R.color.cp_cont_b_alpha42, R.color.cp_cont_b_alpha42, i);
        if (this.gSt < 1) {
            ao.setImageResource(this.gSo, R.drawable.pic_id_front, i);
        }
        if (this.gSu < 1) {
            ao.setImageResource(this.gSp, R.drawable.pic_id_back, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if (i == 101) {
                com.baidu.adp.lib.e.c.ln().a(this.gSh, 32, this.eDQ, getUniqueId());
                this.gSt = 1;
            } else if (i == 102) {
                com.baidu.adp.lib.e.c.ln().a(this.gSi, 32, this.eDQ, getUniqueId());
                this.gSu = 1;
            }
            if (this.gSk != null) {
                if (this.gSu >= 1 && this.gSt >= 1) {
                    this.gSk.setEnabled(true);
                } else {
                    this.gSk.setEnabled(false);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.dFJ);
        MessageManager.getInstance().unRegisterListener(this.mHttpMessageListener);
        if (this.gSs != null && this.gSs.isShowing()) {
            g.dismissDialog(this.gSs, this);
        }
        super.onDestroy();
    }
}
