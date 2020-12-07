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
/* loaded from: classes21.dex */
public class IdentityReviewActivity extends BaseActivity {
    private long forumId;
    private com.baidu.tieba.barselect.data.c idg;
    private com.baidu.tieba.barselect.data.b ieO;
    public String ieP;
    public String ieQ;
    private View ieR;
    private TextView ieS;
    private TextView ieT;
    private TextView ieU;
    private TextView ieV;
    private TbImageView ieW;
    private TbImageView ieX;
    private TextView ieY;
    private TextView ieZ;
    private com.baidu.tieba.barselect.view.a ifa;
    private NavigationBar mNavigationBar;
    private boolean needRetry = false;
    private int ifb = 0;
    private int ifc = 0;
    private View.OnClickListener foP = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.IdentityReviewActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == R.id.identity_card_positive) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2921412, new CameraActivityConfig(IdentityReviewActivity.this, IdentityReviewActivity.this.ieP, CameraActivityConfig.CONTENT_TYPE_ID_CARD_FRONT, 101)));
            } else if (view.getId() == R.id.identity_card_negative) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2921412, new CameraActivityConfig(IdentityReviewActivity.this, IdentityReviewActivity.this.ieQ, CameraActivityConfig.CONTENT_TYPE_ID_CARD_BACK, 102)));
            } else if (view.getId() == R.id.bottom_next_button) {
                new a(IdentityReviewActivity.this.ieP, 1, IdentityReviewActivity.this.idg).execute(new Void[0]);
                IdentityReviewActivity.this.needRetry = true;
                IdentityReviewActivity.this.ifa = new com.baidu.tieba.barselect.view.a(IdentityReviewActivity.this);
                IdentityReviewActivity.this.ifa.setCancelable(true);
                IdentityReviewActivity.this.ifa.setCanceledOnTouchOutside(false);
                IdentityReviewActivity.this.ifa.setMessage(TbadkCoreApplication.getInst().getString(R.string.check_id_card));
                g.showDialog(IdentityReviewActivity.this.ifa, IdentityReviewActivity.this);
            }
        }
    };
    com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a> fyI = new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.barselect.idCard.IdentityReviewActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.e.b
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            super.onLoaded((AnonymousClass2) aVar, str, i);
            if (str != null && aVar != null) {
                if (str.equals(IdentityReviewActivity.this.ieP)) {
                    aVar.drawImageTo(IdentityReviewActivity.this.ieW);
                    IdentityReviewActivity.this.ieY.setVisibility(0);
                } else if (str.equals(IdentityReviewActivity.this.ieQ)) {
                    aVar.drawImageTo(IdentityReviewActivity.this.ieX);
                    IdentityReviewActivity.this.ieZ.setVisibility(0);
                }
            }
            if (str != null) {
                com.baidu.tbadk.imageManager.c.bDV().deletePic(str + 32);
            }
        }
    };
    com.baidu.adp.framework.listener.a ewJ = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_COMMIT_CARD_INFO, 309643) { // from class: com.baidu.tieba.barselect.idCard.IdentityReviewActivity.3
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage != null && responsedMessage.getOrginalMessage() != null) {
                int error = responsedMessage.getError();
                Object extra = responsedMessage.getOrginalMessage().getExtra();
                if (extra instanceof CommitCardInfoReqMsg) {
                    if (error == 0) {
                        if (((CommitCardInfoReqMsg) extra).card_type == 1) {
                            IdentityReviewActivity.this.ifb = 2;
                        } else if (((CommitCardInfoReqMsg) extra).card_type == 2) {
                            IdentityReviewActivity.this.ifc = 2;
                        }
                        if (IdentityReviewActivity.this.ifb < 2 || IdentityReviewActivity.this.ifc < 2) {
                            if (IdentityReviewActivity.this.ifc == 1) {
                                if (IdentityReviewActivity.this.idg == null) {
                                    if (IdentityReviewActivity.this.ifa != null) {
                                        g.dismissDialog(IdentityReviewActivity.this.ifa, IdentityReviewActivity.this);
                                        return;
                                    }
                                    return;
                                }
                                new a(IdentityReviewActivity.this.ieQ, 2, IdentityReviewActivity.this.idg).execute(new Void[0]);
                            }
                        } else if (IdentityReviewActivity.this.ieO != null) {
                            IdentityReviewActivity.this.ieO.fV(IdentityReviewActivity.this.forumId);
                        } else if (IdentityReviewActivity.this.ifa != null) {
                            g.dismissDialog(IdentityReviewActivity.this.ifa, IdentityReviewActivity.this);
                        }
                    } else if (error != -100000303 || !IdentityReviewActivity.this.needRetry) {
                        if (IdentityReviewActivity.this.ifa != null && IdentityReviewActivity.this.ifa.isShowing()) {
                            g.dismissDialog(IdentityReviewActivity.this.ifa, IdentityReviewActivity.this);
                        }
                        l.showLongToast(TbadkCoreApplication.getInst(), responsedMessage.getErrorString());
                        IdentityReviewActivity.this.ifb = 1;
                        IdentityReviewActivity.this.ifc = 1;
                    } else {
                        IdentityReviewActivity.this.ifb = 1;
                        IdentityReviewActivity.this.ifc = 1;
                        if (IdentityReviewActivity.this.idg != null) {
                            IdentityReviewActivity.this.needRetry = false;
                            new a(IdentityReviewActivity.this.ieP, 1, IdentityReviewActivity.this.idg).execute(new Void[0]);
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
                if (IdentityReviewActivity.this.ifa != null && IdentityReviewActivity.this.ifa.isShowing()) {
                    g.dismissDialog(IdentityReviewActivity.this.ifa, IdentityReviewActivity.this);
                }
                String str = "https://tieba.baidu.com/mo/q/newmanagerapplyresult?passIDCert=1&nomenu=1&forum_id=" + IdentityReviewActivity.this.forumId;
                if (error == 0) {
                    bf.bua().b(IdentityReviewActivity.this.getPageContext(), new String[]{str});
                    IdentityReviewActivity.this.setResult(-1);
                    IdentityReviewActivity.this.finish();
                    return;
                }
                l.showLongToast(TbadkCoreApplication.getInst(), httpResponsedMessage.getErrorString());
                IdentityReviewActivity.this.ifb = 1;
                IdentityReviewActivity.this.ifc = 1;
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.identity_review_activity);
        this.forumId = getIntent().getLongExtra("fid", 0L);
        this.idg = new com.baidu.tieba.barselect.data.c(getPageContext());
        this.ieO = new com.baidu.tieba.barselect.data.b(getPageContext());
        this.ieP = new File(TbadkCoreApplication.getInst().getFilesDir(), "positive.jpg").getAbsolutePath();
        this.ieQ = new File(TbadkCoreApplication.getInst().getFilesDir(), "negative.jpg").getAbsolutePath();
        this.ieR = findViewById(R.id.id_card_view);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.id_review_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(getResources().getString(R.string.bar_manager_apply));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.ieS = (TextView) findViewById(R.id.bottom_next_button);
        this.ieS.setEnabled(false);
        this.ieT = (TextView) findViewById(R.id.identity_view_title);
        this.ieU = (TextView) findViewById(R.id.positive_card_coloct_tip);
        this.ieV = (TextView) findViewById(R.id.negative_card_coloct_tip);
        this.ieW = (TbImageView) findViewById(R.id.identity_card_positive);
        this.ieX = (TbImageView) findViewById(R.id.identity_card_negative);
        this.ieY = (TextView) findViewById(R.id.identity_card_positive_logo);
        this.ieZ = (TextView) findViewById(R.id.identity_card_negative_logo);
        MessageManager.getInstance().registerListener(this.ewJ);
        MessageManager.getInstance().registerListener(this.mHttpMessageListener);
        this.ieW.setOnClickListener(this.foP);
        this.ieX.setOnClickListener(this.foP);
        this.ieS.setOnClickListener(this.foP);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        }
        ap.setViewTextColor(this.ieS, R.color.CAM_X0101, 1, i);
        ap.setBackgroundResource(this.ieS, R.drawable.bg_id_card_button, i);
        ap.setViewTextColor(this.ieT, R.color.CAM_X0105, 1, i);
        ap.setViewTextColor(this.ieU, R.color.CAM_X0109, 1, i);
        ap.setViewTextColor(this.ieV, R.color.CAM_X0109, 1, i);
        int dimens = l.getDimens(this, R.dimen.tbds10);
        ap.setViewTextColor(this.ieY, R.color.CAM_X0101, 1, i);
        ap.setViewTextColor(this.ieZ, R.color.CAM_X0101, 1, i);
        ap.c(this.ieY, dimens, R.color.cp_cont_b_alpha42, R.color.cp_cont_b_alpha42, i);
        ap.c(this.ieZ, dimens, R.color.cp_cont_b_alpha42, R.color.cp_cont_b_alpha42, i);
        if (this.ifb < 1) {
            ap.setImageResource(this.ieW, R.drawable.pic_id_front, i);
        }
        if (this.ifc < 1) {
            ap.setImageResource(this.ieX, R.drawable.pic_id_back, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if (i == 101) {
                com.baidu.adp.lib.e.c.mS().a(this.ieP, 32, this.fyI, getUniqueId());
                this.ifb = 1;
            } else if (i == 102) {
                com.baidu.adp.lib.e.c.mS().a(this.ieQ, 32, this.fyI, getUniqueId());
                this.ifc = 1;
            }
            if (this.ieS != null) {
                if (this.ifc >= 1 && this.ifb >= 1) {
                    this.ieS.setEnabled(true);
                } else {
                    this.ieS.setEnabled(false);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.ewJ);
        MessageManager.getInstance().unRegisterListener(this.mHttpMessageListener);
        if (this.ifa != null && this.ifa.isShowing()) {
            g.dismissDialog(this.ifa, this);
        }
        super.onDestroy();
    }
}
