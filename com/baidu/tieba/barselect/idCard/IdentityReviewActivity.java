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
/* loaded from: classes7.dex */
public class IdentityReviewActivity extends BaseActivity {
    private long forumId;
    private com.baidu.tieba.barselect.data.c isD;
    private com.baidu.tieba.barselect.data.b iuf;
    public String iug;
    public String iuh;
    private View iui;
    private TextView iuj;
    private TextView iuk;
    private TextView iul;
    private TextView ium;
    private TbImageView iun;
    private TbImageView iuo;
    private TextView iup;
    private TextView iuq;
    private com.baidu.tieba.barselect.view.a iur;
    private NavigationBar mNavigationBar;
    private boolean needRetry = false;
    private int ius = 0;
    private int iut = 0;
    private View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.IdentityReviewActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == R.id.identity_card_positive) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2921412, new CameraActivityConfig(IdentityReviewActivity.this, IdentityReviewActivity.this.iug, CameraActivityConfig.CONTENT_TYPE_ID_CARD_FRONT, 101)));
            } else if (view.getId() == R.id.identity_card_negative) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2921412, new CameraActivityConfig(IdentityReviewActivity.this, IdentityReviewActivity.this.iuh, CameraActivityConfig.CONTENT_TYPE_ID_CARD_BACK, 102)));
            } else if (view.getId() == R.id.bottom_next_button) {
                new a(IdentityReviewActivity.this.iug, 1, IdentityReviewActivity.this.isD).execute(new Void[0]);
                IdentityReviewActivity.this.needRetry = true;
                IdentityReviewActivity.this.iur = new com.baidu.tieba.barselect.view.a(IdentityReviewActivity.this);
                IdentityReviewActivity.this.iur.setCancelable(true);
                IdentityReviewActivity.this.iur.setCanceledOnTouchOutside(false);
                IdentityReviewActivity.this.iur.setMessage(TbadkCoreApplication.getInst().getString(R.string.check_id_card));
                g.showDialog(IdentityReviewActivity.this.iur, IdentityReviewActivity.this);
            }
        }
    };
    com.baidu.adp.lib.e.c<com.baidu.adp.widget.ImageView.a> fHr = new com.baidu.adp.lib.e.c<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.barselect.idCard.IdentityReviewActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.e.c
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            super.onLoaded((AnonymousClass2) aVar, str, i);
            if (str != null && aVar != null) {
                if (str.equals(IdentityReviewActivity.this.iug)) {
                    aVar.drawImageTo(IdentityReviewActivity.this.iun);
                    IdentityReviewActivity.this.iup.setVisibility(0);
                } else if (str.equals(IdentityReviewActivity.this.iuh)) {
                    aVar.drawImageTo(IdentityReviewActivity.this.iuo);
                    IdentityReviewActivity.this.iuq.setVisibility(0);
                }
            }
            if (str != null) {
                com.baidu.tbadk.imageManager.c.bCS().deletePic(str + 32);
            }
        }
    };
    com.baidu.adp.framework.listener.a eEU = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_COMMIT_CARD_INFO, 309643) { // from class: com.baidu.tieba.barselect.idCard.IdentityReviewActivity.3
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage != null && responsedMessage.getOrginalMessage() != null) {
                int error = responsedMessage.getError();
                Object extra = responsedMessage.getOrginalMessage().getExtra();
                if (extra instanceof CommitCardInfoReqMsg) {
                    if (error == 0) {
                        if (((CommitCardInfoReqMsg) extra).card_type == 1) {
                            IdentityReviewActivity.this.ius = 2;
                        } else if (((CommitCardInfoReqMsg) extra).card_type == 2) {
                            IdentityReviewActivity.this.iut = 2;
                        }
                        if (IdentityReviewActivity.this.ius < 2 || IdentityReviewActivity.this.iut < 2) {
                            if (IdentityReviewActivity.this.iut == 1) {
                                if (IdentityReviewActivity.this.isD == null) {
                                    if (IdentityReviewActivity.this.iur != null) {
                                        g.dismissDialog(IdentityReviewActivity.this.iur, IdentityReviewActivity.this);
                                        return;
                                    }
                                    return;
                                }
                                new a(IdentityReviewActivity.this.iuh, 2, IdentityReviewActivity.this.isD).execute(new Void[0]);
                            }
                        } else if (IdentityReviewActivity.this.iuf != null) {
                            IdentityReviewActivity.this.iuf.ga(IdentityReviewActivity.this.forumId);
                        } else if (IdentityReviewActivity.this.iur != null) {
                            g.dismissDialog(IdentityReviewActivity.this.iur, IdentityReviewActivity.this);
                        }
                    } else if (error != -100000303 || !IdentityReviewActivity.this.needRetry) {
                        if (IdentityReviewActivity.this.iur != null && IdentityReviewActivity.this.iur.isShowing()) {
                            g.dismissDialog(IdentityReviewActivity.this.iur, IdentityReviewActivity.this);
                        }
                        l.showLongToast(TbadkCoreApplication.getInst(), responsedMessage.getErrorString());
                        IdentityReviewActivity.this.ius = 1;
                        IdentityReviewActivity.this.iut = 1;
                    } else {
                        IdentityReviewActivity.this.ius = 1;
                        IdentityReviewActivity.this.iut = 1;
                        if (IdentityReviewActivity.this.isD != null) {
                            IdentityReviewActivity.this.needRetry = false;
                            new a(IdentityReviewActivity.this.iug, 1, IdentityReviewActivity.this.isD).execute(new Void[0]);
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
                if (IdentityReviewActivity.this.iur != null && IdentityReviewActivity.this.iur.isShowing()) {
                    g.dismissDialog(IdentityReviewActivity.this.iur, IdentityReviewActivity.this);
                }
                String str = "https://tieba.baidu.com/mo/q/newmanagerapplyresult?passIDCert=1&nomenu=1&forum_id=" + IdentityReviewActivity.this.forumId;
                if (error == 0) {
                    bf.bsY().b(IdentityReviewActivity.this.getPageContext(), new String[]{str});
                    IdentityReviewActivity.this.setResult(-1);
                    IdentityReviewActivity.this.finish();
                    return;
                }
                l.showLongToast(TbadkCoreApplication.getInst(), httpResponsedMessage.getErrorString());
                IdentityReviewActivity.this.ius = 1;
                IdentityReviewActivity.this.iut = 1;
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.identity_review_activity);
        this.forumId = getIntent().getLongExtra("fid", 0L);
        this.isD = new com.baidu.tieba.barselect.data.c(getPageContext());
        this.iuf = new com.baidu.tieba.barselect.data.b(getPageContext());
        this.iug = new File(TbadkCoreApplication.getInst().getFilesDir(), "positive.jpg").getAbsolutePath();
        this.iuh = new File(TbadkCoreApplication.getInst().getFilesDir(), "negative.jpg").getAbsolutePath();
        this.iui = findViewById(R.id.id_card_view);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.id_review_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(getResources().getString(R.string.bar_manager_apply));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.iuj = (TextView) findViewById(R.id.bottom_next_button);
        this.iuj.setEnabled(false);
        this.iuk = (TextView) findViewById(R.id.identity_view_title);
        this.iul = (TextView) findViewById(R.id.positive_card_coloct_tip);
        this.ium = (TextView) findViewById(R.id.negative_card_coloct_tip);
        this.iun = (TbImageView) findViewById(R.id.identity_card_positive);
        this.iuo = (TbImageView) findViewById(R.id.identity_card_negative);
        this.iup = (TextView) findViewById(R.id.identity_card_positive_logo);
        this.iuq = (TextView) findViewById(R.id.identity_card_negative_logo);
        MessageManager.getInstance().registerListener(this.eEU);
        MessageManager.getInstance().registerListener(this.mHttpMessageListener);
        this.iun.setOnClickListener(this.onClickListener);
        this.iuo.setOnClickListener(this.onClickListener);
        this.iuj.setOnClickListener(this.onClickListener);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        }
        ap.setViewTextColor(this.iuj, R.color.CAM_X0101, 1, i);
        ap.setBackgroundResource(this.iuj, R.drawable.bg_id_card_button, i);
        ap.setViewTextColor(this.iuk, R.color.CAM_X0105, 1, i);
        ap.setViewTextColor(this.iul, R.color.CAM_X0109, 1, i);
        ap.setViewTextColor(this.ium, R.color.CAM_X0109, 1, i);
        int dimens = l.getDimens(this, R.dimen.tbds10);
        ap.setViewTextColor(this.iup, R.color.CAM_X0101, 1, i);
        ap.setViewTextColor(this.iuq, R.color.CAM_X0101, 1, i);
        ap.e(this.iup, dimens, R.color.cp_cont_b_alpha42, R.color.cp_cont_b_alpha42, i);
        ap.e(this.iuq, dimens, R.color.cp_cont_b_alpha42, R.color.cp_cont_b_alpha42, i);
        if (this.ius < 1) {
            ap.setImageResource(this.iun, R.drawable.pic_id_front, i);
        }
        if (this.iut < 1) {
            ap.setImageResource(this.iuo, R.drawable.pic_id_back, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if (i == 101) {
                com.baidu.adp.lib.e.d.mw().a(this.iug, 32, this.fHr, getUniqueId());
                this.ius = 1;
            } else if (i == 102) {
                com.baidu.adp.lib.e.d.mw().a(this.iuh, 32, this.fHr, getUniqueId());
                this.iut = 1;
            }
            if (this.iuj != null) {
                if (this.iut >= 1 && this.ius >= 1) {
                    this.iuj.setEnabled(true);
                } else {
                    this.iuj.setEnabled(false);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.eEU);
        MessageManager.getInstance().unRegisterListener(this.mHttpMessageListener);
        if (this.iur != null && this.iur.isShowing()) {
            g.dismissDialog(this.iur, this);
        }
        super.onDestroy();
    }
}
