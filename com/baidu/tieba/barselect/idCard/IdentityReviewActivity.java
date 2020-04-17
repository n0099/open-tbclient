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
/* loaded from: classes8.dex */
public class IdentityReviewActivity extends BaseActivity {
    private long forumId;
    private com.baidu.tieba.barselect.data.c gje;
    private com.baidu.tieba.barselect.data.b gkH;
    public String gkI;
    public String gkJ;
    private View gkK;
    private TextView gkL;
    private TextView gkM;
    private TextView gkN;
    private TextView gkO;
    private TbImageView gkP;
    private TbImageView gkQ;
    private TextView gkR;
    private TextView gkS;
    private com.baidu.tieba.barselect.view.a gkT;
    private NavigationBar mNavigationBar;
    private boolean needRetry = false;
    private int gkU = 0;
    private int gkV = 0;
    private View.OnClickListener dRF = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.IdentityReviewActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == R.id.identity_card_positive) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2921412, new CameraActivityConfig(IdentityReviewActivity.this, IdentityReviewActivity.this.gkI, CameraActivityConfig.CONTENT_TYPE_ID_CARD_FRONT, 101)));
            } else if (view.getId() == R.id.identity_card_negative) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2921412, new CameraActivityConfig(IdentityReviewActivity.this, IdentityReviewActivity.this.gkJ, CameraActivityConfig.CONTENT_TYPE_ID_CARD_BACK, 102)));
            } else if (view.getId() == R.id.bottom_next_button) {
                new a(IdentityReviewActivity.this.gkI, 1, IdentityReviewActivity.this.gje).execute(new Void[0]);
                IdentityReviewActivity.this.needRetry = true;
                IdentityReviewActivity.this.gkT = new com.baidu.tieba.barselect.view.a(IdentityReviewActivity.this);
                IdentityReviewActivity.this.gkT.setCancelable(true);
                IdentityReviewActivity.this.gkT.setCanceledOnTouchOutside(false);
                IdentityReviewActivity.this.gkT.setMessage(TbadkCoreApplication.getInst().getString(R.string.check_id_card));
                g.showDialog(IdentityReviewActivity.this.gkT, IdentityReviewActivity.this);
            }
        }
    };
    com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a> eas = new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.barselect.idCard.IdentityReviewActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.e.b
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            super.onLoaded((AnonymousClass2) aVar, str, i);
            if (str != null && aVar != null) {
                if (str.equals(IdentityReviewActivity.this.gkI)) {
                    aVar.drawImageTo(IdentityReviewActivity.this.gkP);
                    IdentityReviewActivity.this.gkR.setVisibility(0);
                } else if (str.equals(IdentityReviewActivity.this.gkJ)) {
                    aVar.drawImageTo(IdentityReviewActivity.this.gkQ);
                    IdentityReviewActivity.this.gkS.setVisibility(0);
                }
            }
            if (str != null) {
                com.baidu.tbadk.imageManager.c.aYm().deletePic(str + 32);
            }
        }
    };
    com.baidu.adp.framework.listener.a dhj = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_COMMIT_CARD_INFO, 309643) { // from class: com.baidu.tieba.barselect.idCard.IdentityReviewActivity.3
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage != null && responsedMessage.getOrginalMessage() != null) {
                int error = responsedMessage.getError();
                Object extra = responsedMessage.getOrginalMessage().getExtra();
                if (extra instanceof CommitCardInfoReqMsg) {
                    if (error == 0) {
                        if (((CommitCardInfoReqMsg) extra).card_type == 1) {
                            IdentityReviewActivity.this.gkU = 2;
                        } else if (((CommitCardInfoReqMsg) extra).card_type == 2) {
                            IdentityReviewActivity.this.gkV = 2;
                        }
                        if (IdentityReviewActivity.this.gkU < 2 || IdentityReviewActivity.this.gkV < 2) {
                            if (IdentityReviewActivity.this.gkV == 1) {
                                if (IdentityReviewActivity.this.gje == null) {
                                    if (IdentityReviewActivity.this.gkT != null) {
                                        g.dismissDialog(IdentityReviewActivity.this.gkT, IdentityReviewActivity.this);
                                        return;
                                    }
                                    return;
                                }
                                new a(IdentityReviewActivity.this.gkJ, 2, IdentityReviewActivity.this.gje).execute(new Void[0]);
                            }
                        } else if (IdentityReviewActivity.this.gkH != null) {
                            IdentityReviewActivity.this.gkH.dO(IdentityReviewActivity.this.forumId);
                        } else if (IdentityReviewActivity.this.gkT != null) {
                            g.dismissDialog(IdentityReviewActivity.this.gkT, IdentityReviewActivity.this);
                        }
                    } else if (error != -100000303 || !IdentityReviewActivity.this.needRetry) {
                        if (IdentityReviewActivity.this.gkT != null && IdentityReviewActivity.this.gkT.isShowing()) {
                            g.dismissDialog(IdentityReviewActivity.this.gkT, IdentityReviewActivity.this);
                        }
                        l.showLongToast(TbadkCoreApplication.getInst(), responsedMessage.getErrorString());
                        IdentityReviewActivity.this.gkU = 1;
                        IdentityReviewActivity.this.gkV = 1;
                    } else {
                        IdentityReviewActivity.this.gkU = 1;
                        IdentityReviewActivity.this.gkV = 1;
                        if (IdentityReviewActivity.this.gje != null) {
                            IdentityReviewActivity.this.needRetry = false;
                            new a(IdentityReviewActivity.this.gkI, 1, IdentityReviewActivity.this.gje).execute(new Void[0]);
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
                if (IdentityReviewActivity.this.gkT != null && IdentityReviewActivity.this.gkT.isShowing()) {
                    g.dismissDialog(IdentityReviewActivity.this.gkT, IdentityReviewActivity.this);
                }
                String str = "https://tieba.baidu.com/mo/q/newmanagerapplyresult?passIDCert=1&nomenu=1&forum_id=" + IdentityReviewActivity.this.forumId;
                if (error == 0) {
                    ba.aOY().b(IdentityReviewActivity.this.getPageContext(), new String[]{str});
                    IdentityReviewActivity.this.setResult(-1);
                    IdentityReviewActivity.this.finish();
                    return;
                }
                l.showLongToast(TbadkCoreApplication.getInst(), httpResponsedMessage.getErrorString());
                IdentityReviewActivity.this.gkU = 1;
                IdentityReviewActivity.this.gkV = 1;
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.identity_review_activity);
        this.forumId = getIntent().getLongExtra("fid", 0L);
        this.gje = new com.baidu.tieba.barselect.data.c(getPageContext());
        this.gkH = new com.baidu.tieba.barselect.data.b(getPageContext());
        this.gkI = new File(TbadkCoreApplication.getInst().getFilesDir(), "positive.jpg").getAbsolutePath();
        this.gkJ = new File(TbadkCoreApplication.getInst().getFilesDir(), "negative.jpg").getAbsolutePath();
        this.gkK = findViewById(R.id.id_card_view);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.id_review_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(getResources().getString(R.string.bar_manager_apply));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.gkL = (TextView) findViewById(R.id.bottom_next_button);
        this.gkL.setEnabled(false);
        this.gkM = (TextView) findViewById(R.id.identity_view_title);
        this.gkN = (TextView) findViewById(R.id.positive_card_coloct_tip);
        this.gkO = (TextView) findViewById(R.id.negative_card_coloct_tip);
        this.gkP = (TbImageView) findViewById(R.id.identity_card_positive);
        this.gkQ = (TbImageView) findViewById(R.id.identity_card_negative);
        this.gkR = (TextView) findViewById(R.id.identity_card_positive_logo);
        this.gkS = (TextView) findViewById(R.id.identity_card_negative_logo);
        MessageManager.getInstance().registerListener(this.dhj);
        MessageManager.getInstance().registerListener(this.mHttpMessageListener);
        this.gkP.setOnClickListener(this.dRF);
        this.gkQ.setOnClickListener(this.dRF);
        this.gkL.setOnClickListener(this.dRF);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        }
        am.setViewTextColor(this.gkL, R.color.cp_cont_a, 1, i);
        am.setBackgroundResource(this.gkL, R.drawable.bg_id_card_button, i);
        am.setViewTextColor(this.gkM, R.color.cp_cont_b, 1, i);
        am.setViewTextColor(this.gkN, R.color.cp_cont_d, 1, i);
        am.setViewTextColor(this.gkO, R.color.cp_cont_d, 1, i);
        int dimens = l.getDimens(this, R.dimen.tbds10);
        am.setViewTextColor(this.gkR, R.color.cp_cont_a, 1, i);
        am.setViewTextColor(this.gkS, R.color.cp_cont_a, 1, i);
        am.c(this.gkR, dimens, (int) R.color.cp_cont_b_alpha42, (int) R.color.cp_cont_b_alpha42, i);
        am.c(this.gkS, dimens, (int) R.color.cp_cont_b_alpha42, (int) R.color.cp_cont_b_alpha42, i);
        if (this.gkU < 1) {
            am.setImageResource(this.gkP, R.drawable.pic_id_front, i);
        }
        if (this.gkV < 1) {
            am.setImageResource(this.gkQ, R.drawable.pic_id_back, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if (i == 101) {
                com.baidu.adp.lib.e.c.kV().a(this.gkI, 32, this.eas, getUniqueId());
                this.gkU = 1;
            } else if (i == 102) {
                com.baidu.adp.lib.e.c.kV().a(this.gkJ, 32, this.eas, getUniqueId());
                this.gkV = 1;
            }
            if (this.gkL != null) {
                if (this.gkV >= 1 && this.gkU >= 1) {
                    this.gkL.setEnabled(true);
                } else {
                    this.gkL.setEnabled(false);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.dhj);
        MessageManager.getInstance().unRegisterListener(this.mHttpMessageListener);
        if (this.gkT != null && this.gkT.isShowing()) {
            g.dismissDialog(this.gkT, this);
        }
        super.onDestroy();
    }
}
