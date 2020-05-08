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
    private com.baidu.tieba.barselect.data.c gjk;
    private com.baidu.tieba.barselect.data.b gkN;
    public String gkO;
    public String gkP;
    private View gkQ;
    private TextView gkR;
    private TextView gkS;
    private TextView gkT;
    private TextView gkU;
    private TbImageView gkV;
    private TbImageView gkW;
    private TextView gkX;
    private TextView gkY;
    private com.baidu.tieba.barselect.view.a gkZ;
    private NavigationBar mNavigationBar;
    private boolean needRetry = false;
    private int gla = 0;
    private int glb = 0;
    private View.OnClickListener dRK = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.IdentityReviewActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == R.id.identity_card_positive) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2921412, new CameraActivityConfig(IdentityReviewActivity.this, IdentityReviewActivity.this.gkO, CameraActivityConfig.CONTENT_TYPE_ID_CARD_FRONT, 101)));
            } else if (view.getId() == R.id.identity_card_negative) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2921412, new CameraActivityConfig(IdentityReviewActivity.this, IdentityReviewActivity.this.gkP, CameraActivityConfig.CONTENT_TYPE_ID_CARD_BACK, 102)));
            } else if (view.getId() == R.id.bottom_next_button) {
                new a(IdentityReviewActivity.this.gkO, 1, IdentityReviewActivity.this.gjk).execute(new Void[0]);
                IdentityReviewActivity.this.needRetry = true;
                IdentityReviewActivity.this.gkZ = new com.baidu.tieba.barselect.view.a(IdentityReviewActivity.this);
                IdentityReviewActivity.this.gkZ.setCancelable(true);
                IdentityReviewActivity.this.gkZ.setCanceledOnTouchOutside(false);
                IdentityReviewActivity.this.gkZ.setMessage(TbadkCoreApplication.getInst().getString(R.string.check_id_card));
                g.showDialog(IdentityReviewActivity.this.gkZ, IdentityReviewActivity.this);
            }
        }
    };
    com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a> eax = new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.barselect.idCard.IdentityReviewActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.e.b
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            super.onLoaded((AnonymousClass2) aVar, str, i);
            if (str != null && aVar != null) {
                if (str.equals(IdentityReviewActivity.this.gkO)) {
                    aVar.drawImageTo(IdentityReviewActivity.this.gkV);
                    IdentityReviewActivity.this.gkX.setVisibility(0);
                } else if (str.equals(IdentityReviewActivity.this.gkP)) {
                    aVar.drawImageTo(IdentityReviewActivity.this.gkW);
                    IdentityReviewActivity.this.gkY.setVisibility(0);
                }
            }
            if (str != null) {
                com.baidu.tbadk.imageManager.c.aYk().deletePic(str + 32);
            }
        }
    };
    com.baidu.adp.framework.listener.a dho = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_COMMIT_CARD_INFO, 309643) { // from class: com.baidu.tieba.barselect.idCard.IdentityReviewActivity.3
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage != null && responsedMessage.getOrginalMessage() != null) {
                int error = responsedMessage.getError();
                Object extra = responsedMessage.getOrginalMessage().getExtra();
                if (extra instanceof CommitCardInfoReqMsg) {
                    if (error == 0) {
                        if (((CommitCardInfoReqMsg) extra).card_type == 1) {
                            IdentityReviewActivity.this.gla = 2;
                        } else if (((CommitCardInfoReqMsg) extra).card_type == 2) {
                            IdentityReviewActivity.this.glb = 2;
                        }
                        if (IdentityReviewActivity.this.gla < 2 || IdentityReviewActivity.this.glb < 2) {
                            if (IdentityReviewActivity.this.glb == 1) {
                                if (IdentityReviewActivity.this.gjk == null) {
                                    if (IdentityReviewActivity.this.gkZ != null) {
                                        g.dismissDialog(IdentityReviewActivity.this.gkZ, IdentityReviewActivity.this);
                                        return;
                                    }
                                    return;
                                }
                                new a(IdentityReviewActivity.this.gkP, 2, IdentityReviewActivity.this.gjk).execute(new Void[0]);
                            }
                        } else if (IdentityReviewActivity.this.gkN != null) {
                            IdentityReviewActivity.this.gkN.dO(IdentityReviewActivity.this.forumId);
                        } else if (IdentityReviewActivity.this.gkZ != null) {
                            g.dismissDialog(IdentityReviewActivity.this.gkZ, IdentityReviewActivity.this);
                        }
                    } else if (error != -100000303 || !IdentityReviewActivity.this.needRetry) {
                        if (IdentityReviewActivity.this.gkZ != null && IdentityReviewActivity.this.gkZ.isShowing()) {
                            g.dismissDialog(IdentityReviewActivity.this.gkZ, IdentityReviewActivity.this);
                        }
                        l.showLongToast(TbadkCoreApplication.getInst(), responsedMessage.getErrorString());
                        IdentityReviewActivity.this.gla = 1;
                        IdentityReviewActivity.this.glb = 1;
                    } else {
                        IdentityReviewActivity.this.gla = 1;
                        IdentityReviewActivity.this.glb = 1;
                        if (IdentityReviewActivity.this.gjk != null) {
                            IdentityReviewActivity.this.needRetry = false;
                            new a(IdentityReviewActivity.this.gkO, 1, IdentityReviewActivity.this.gjk).execute(new Void[0]);
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
                if (IdentityReviewActivity.this.gkZ != null && IdentityReviewActivity.this.gkZ.isShowing()) {
                    g.dismissDialog(IdentityReviewActivity.this.gkZ, IdentityReviewActivity.this);
                }
                String str = "https://tieba.baidu.com/mo/q/newmanagerapplyresult?passIDCert=1&nomenu=1&forum_id=" + IdentityReviewActivity.this.forumId;
                if (error == 0) {
                    ba.aOV().b(IdentityReviewActivity.this.getPageContext(), new String[]{str});
                    IdentityReviewActivity.this.setResult(-1);
                    IdentityReviewActivity.this.finish();
                    return;
                }
                l.showLongToast(TbadkCoreApplication.getInst(), httpResponsedMessage.getErrorString());
                IdentityReviewActivity.this.gla = 1;
                IdentityReviewActivity.this.glb = 1;
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.identity_review_activity);
        this.forumId = getIntent().getLongExtra("fid", 0L);
        this.gjk = new com.baidu.tieba.barselect.data.c(getPageContext());
        this.gkN = new com.baidu.tieba.barselect.data.b(getPageContext());
        this.gkO = new File(TbadkCoreApplication.getInst().getFilesDir(), "positive.jpg").getAbsolutePath();
        this.gkP = new File(TbadkCoreApplication.getInst().getFilesDir(), "negative.jpg").getAbsolutePath();
        this.gkQ = findViewById(R.id.id_card_view);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.id_review_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(getResources().getString(R.string.bar_manager_apply));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.gkR = (TextView) findViewById(R.id.bottom_next_button);
        this.gkR.setEnabled(false);
        this.gkS = (TextView) findViewById(R.id.identity_view_title);
        this.gkT = (TextView) findViewById(R.id.positive_card_coloct_tip);
        this.gkU = (TextView) findViewById(R.id.negative_card_coloct_tip);
        this.gkV = (TbImageView) findViewById(R.id.identity_card_positive);
        this.gkW = (TbImageView) findViewById(R.id.identity_card_negative);
        this.gkX = (TextView) findViewById(R.id.identity_card_positive_logo);
        this.gkY = (TextView) findViewById(R.id.identity_card_negative_logo);
        MessageManager.getInstance().registerListener(this.dho);
        MessageManager.getInstance().registerListener(this.mHttpMessageListener);
        this.gkV.setOnClickListener(this.dRK);
        this.gkW.setOnClickListener(this.dRK);
        this.gkR.setOnClickListener(this.dRK);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        }
        am.setViewTextColor(this.gkR, R.color.cp_cont_a, 1, i);
        am.setBackgroundResource(this.gkR, R.drawable.bg_id_card_button, i);
        am.setViewTextColor(this.gkS, R.color.cp_cont_b, 1, i);
        am.setViewTextColor(this.gkT, R.color.cp_cont_d, 1, i);
        am.setViewTextColor(this.gkU, R.color.cp_cont_d, 1, i);
        int dimens = l.getDimens(this, R.dimen.tbds10);
        am.setViewTextColor(this.gkX, R.color.cp_cont_a, 1, i);
        am.setViewTextColor(this.gkY, R.color.cp_cont_a, 1, i);
        am.c(this.gkX, dimens, (int) R.color.cp_cont_b_alpha42, (int) R.color.cp_cont_b_alpha42, i);
        am.c(this.gkY, dimens, (int) R.color.cp_cont_b_alpha42, (int) R.color.cp_cont_b_alpha42, i);
        if (this.gla < 1) {
            am.setImageResource(this.gkV, R.drawable.pic_id_front, i);
        }
        if (this.glb < 1) {
            am.setImageResource(this.gkW, R.drawable.pic_id_back, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if (i == 101) {
                com.baidu.adp.lib.e.c.kV().a(this.gkO, 32, this.eax, getUniqueId());
                this.gla = 1;
            } else if (i == 102) {
                com.baidu.adp.lib.e.c.kV().a(this.gkP, 32, this.eax, getUniqueId());
                this.glb = 1;
            }
            if (this.gkR != null) {
                if (this.glb >= 1 && this.gla >= 1) {
                    this.gkR.setEnabled(true);
                } else {
                    this.gkR.setEnabled(false);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.dho);
        MessageManager.getInstance().unRegisterListener(this.mHttpMessageListener);
        if (this.gkZ != null && this.gkZ.isShowing()) {
            g.dismissDialog(this.gkZ, this);
        }
        super.onDestroy();
    }
}
