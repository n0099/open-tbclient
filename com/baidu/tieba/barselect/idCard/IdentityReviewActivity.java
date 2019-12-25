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
/* loaded from: classes5.dex */
public class IdentityReviewActivity extends BaseActivity {
    private long forumId;
    private com.baidu.tieba.barselect.data.c fxT;
    private View fzA;
    private TextView fzB;
    private TextView fzC;
    private TextView fzD;
    private TextView fzE;
    private TbImageView fzF;
    private TbImageView fzG;
    private TextView fzH;
    private TextView fzI;
    private com.baidu.tieba.barselect.view.a fzJ;
    private com.baidu.tieba.barselect.data.b fzx;
    public String fzy;
    public String fzz;
    private NavigationBar mNavigationBar;
    private boolean needRetry = false;
    private int fzK = 0;
    private int fzL = 0;
    private View.OnClickListener dmK = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.IdentityReviewActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == R.id.identity_card_positive) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2921412, new CameraActivityConfig(IdentityReviewActivity.this, IdentityReviewActivity.this.fzy, CameraActivityConfig.CONTENT_TYPE_ID_CARD_FRONT, 101)));
            } else if (view.getId() == R.id.identity_card_negative) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2921412, new CameraActivityConfig(IdentityReviewActivity.this, IdentityReviewActivity.this.fzz, CameraActivityConfig.CONTENT_TYPE_ID_CARD_BACK, 102)));
            } else if (view.getId() == R.id.bottom_next_button) {
                new a(IdentityReviewActivity.this.fzy, 1, IdentityReviewActivity.this.fxT).execute(new Void[0]);
                IdentityReviewActivity.this.needRetry = true;
                IdentityReviewActivity.this.fzJ = new com.baidu.tieba.barselect.view.a(IdentityReviewActivity.this);
                IdentityReviewActivity.this.fzJ.setCancelable(true);
                IdentityReviewActivity.this.fzJ.setCanceledOnTouchOutside(false);
                IdentityReviewActivity.this.fzJ.setMessage(TbadkCoreApplication.getInst().getString(R.string.check_id_card));
                g.showDialog(IdentityReviewActivity.this.fzJ, IdentityReviewActivity.this);
            }
        }
    };
    com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a> dvU = new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.barselect.idCard.IdentityReviewActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.e.b
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            super.onLoaded((AnonymousClass2) aVar, str, i);
            if (str != null && aVar != null) {
                if (str.equals(IdentityReviewActivity.this.fzy)) {
                    aVar.drawImageTo(IdentityReviewActivity.this.fzF);
                    IdentityReviewActivity.this.fzH.setVisibility(0);
                } else if (str.equals(IdentityReviewActivity.this.fzz)) {
                    aVar.drawImageTo(IdentityReviewActivity.this.fzG);
                    IdentityReviewActivity.this.fzI.setVisibility(0);
                }
            }
            if (str != null) {
                com.baidu.tbadk.imageManager.c.aMZ().deletePic(str + 32);
            }
        }
    };
    com.baidu.adp.framework.listener.a cDO = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_COMMIT_CARD_INFO, 309643) { // from class: com.baidu.tieba.barselect.idCard.IdentityReviewActivity.3
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage != null && responsedMessage.getOrginalMessage() != null) {
                int error = responsedMessage.getError();
                Object extra = responsedMessage.getOrginalMessage().getExtra();
                if (extra instanceof CommitCardInfoReqMsg) {
                    if (error == 0) {
                        if (((CommitCardInfoReqMsg) extra).card_type == 1) {
                            IdentityReviewActivity.this.fzK = 2;
                        } else if (((CommitCardInfoReqMsg) extra).card_type == 2) {
                            IdentityReviewActivity.this.fzL = 2;
                        }
                        if (IdentityReviewActivity.this.fzK < 2 || IdentityReviewActivity.this.fzL < 2) {
                            if (IdentityReviewActivity.this.fzL == 1) {
                                if (IdentityReviewActivity.this.fxT == null) {
                                    if (IdentityReviewActivity.this.fzJ != null) {
                                        g.dismissDialog(IdentityReviewActivity.this.fzJ, IdentityReviewActivity.this);
                                        return;
                                    }
                                    return;
                                }
                                new a(IdentityReviewActivity.this.fzz, 2, IdentityReviewActivity.this.fxT).execute(new Void[0]);
                            }
                        } else if (IdentityReviewActivity.this.fzx != null) {
                            IdentityReviewActivity.this.fzx.cZ(IdentityReviewActivity.this.forumId);
                        } else if (IdentityReviewActivity.this.fzJ != null) {
                            g.dismissDialog(IdentityReviewActivity.this.fzJ, IdentityReviewActivity.this);
                        }
                    } else if (error != -100000303 || !IdentityReviewActivity.this.needRetry) {
                        if (IdentityReviewActivity.this.fzJ != null && IdentityReviewActivity.this.fzJ.isShowing()) {
                            g.dismissDialog(IdentityReviewActivity.this.fzJ, IdentityReviewActivity.this);
                        }
                        l.showLongToast(TbadkCoreApplication.getInst(), responsedMessage.getErrorString());
                        IdentityReviewActivity.this.fzK = 1;
                        IdentityReviewActivity.this.fzL = 1;
                    } else {
                        IdentityReviewActivity.this.fzK = 1;
                        IdentityReviewActivity.this.fzL = 1;
                        if (IdentityReviewActivity.this.fxT != null) {
                            IdentityReviewActivity.this.needRetry = false;
                            new a(IdentityReviewActivity.this.fzy, 1, IdentityReviewActivity.this.fxT).execute(new Void[0]);
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
                if (IdentityReviewActivity.this.fzJ != null && IdentityReviewActivity.this.fzJ.isShowing()) {
                    g.dismissDialog(IdentityReviewActivity.this.fzJ, IdentityReviewActivity.this);
                }
                String str = "https://tieba.baidu.com/mo/q/newmanagerapplyresult?passIDCert=1&nomenu=1&forum_id=" + IdentityReviewActivity.this.forumId;
                if (error == 0) {
                    ba.aEa().b(IdentityReviewActivity.this.getPageContext(), new String[]{str});
                    IdentityReviewActivity.this.setResult(-1);
                    IdentityReviewActivity.this.finish();
                    return;
                }
                l.showLongToast(TbadkCoreApplication.getInst(), httpResponsedMessage.getErrorString());
                IdentityReviewActivity.this.fzK = 1;
                IdentityReviewActivity.this.fzL = 1;
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.identity_review_activity);
        this.forumId = getIntent().getLongExtra("fid", 0L);
        this.fxT = new com.baidu.tieba.barselect.data.c(getPageContext());
        this.fzx = new com.baidu.tieba.barselect.data.b(getPageContext());
        this.fzy = new File(TbadkCoreApplication.getInst().getFilesDir(), "positive.jpg").getAbsolutePath();
        this.fzz = new File(TbadkCoreApplication.getInst().getFilesDir(), "negative.jpg").getAbsolutePath();
        this.fzA = findViewById(R.id.id_card_view);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.id_review_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(getResources().getString(R.string.bar_manager_apply));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.fzB = (TextView) findViewById(R.id.bottom_next_button);
        this.fzB.setEnabled(false);
        this.fzC = (TextView) findViewById(R.id.identity_view_title);
        this.fzD = (TextView) findViewById(R.id.positive_card_coloct_tip);
        this.fzE = (TextView) findViewById(R.id.negative_card_coloct_tip);
        this.fzF = (TbImageView) findViewById(R.id.identity_card_positive);
        this.fzG = (TbImageView) findViewById(R.id.identity_card_negative);
        this.fzH = (TextView) findViewById(R.id.identity_card_positive_logo);
        this.fzI = (TextView) findViewById(R.id.identity_card_negative_logo);
        MessageManager.getInstance().registerListener(this.cDO);
        MessageManager.getInstance().registerListener(this.mHttpMessageListener);
        this.fzF.setOnClickListener(this.dmK);
        this.fzG.setOnClickListener(this.dmK);
        this.fzB.setOnClickListener(this.dmK);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        }
        am.setViewTextColor(this.fzB, R.color.cp_cont_a, 1, i);
        am.setBackgroundResource(this.fzB, R.drawable.bg_id_card_button, i);
        am.setViewTextColor(this.fzC, R.color.cp_cont_b, 1, i);
        am.setViewTextColor(this.fzD, R.color.cp_cont_d, 1, i);
        am.setViewTextColor(this.fzE, R.color.cp_cont_d, 1, i);
        int dimens = l.getDimens(this, R.dimen.tbds10);
        am.setViewTextColor(this.fzH, R.color.cp_cont_a, 1, i);
        am.setViewTextColor(this.fzI, R.color.cp_cont_a, 1, i);
        am.c(this.fzH, dimens, (int) R.color.cp_cont_b_alpha42, (int) R.color.cp_cont_b_alpha42, i);
        am.c(this.fzI, dimens, (int) R.color.cp_cont_b_alpha42, (int) R.color.cp_cont_b_alpha42, i);
        if (this.fzK < 1) {
            am.setImageResource(this.fzF, R.drawable.pic_id_front, i);
        }
        if (this.fzL < 1) {
            am.setImageResource(this.fzG, R.drawable.pic_id_back, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if (i == 101) {
                com.baidu.adp.lib.e.c.gs().a(this.fzy, 32, this.dvU, getUniqueId());
                this.fzK = 1;
            } else if (i == 102) {
                com.baidu.adp.lib.e.c.gs().a(this.fzz, 32, this.dvU, getUniqueId());
                this.fzL = 1;
            }
            if (this.fzB != null) {
                if (this.fzL >= 1 && this.fzK >= 1) {
                    this.fzB.setEnabled(true);
                } else {
                    this.fzB.setEnabled(false);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.cDO);
        MessageManager.getInstance().unRegisterListener(this.mHttpMessageListener);
        if (this.fzJ != null && this.fzJ.isShowing()) {
            g.dismissDialog(this.fzJ, this);
        }
        super.onDestroy();
    }
}
