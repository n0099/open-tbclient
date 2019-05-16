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
import com.baidu.adp.lib.g.g;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.CameraActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.barselect.data.CommitCardInfoReqMsg;
import java.io.File;
/* loaded from: classes3.dex */
public class IdentityReviewActivity extends BaseActivity {
    private com.baidu.tieba.barselect.data.c ern;
    private com.baidu.tieba.barselect.data.b esT;
    public String esU;
    public String esV;
    private View esW;
    private TextView esX;
    private TextView esY;
    private TextView esZ;
    private TextView eta;
    private TbImageView etb;
    private TbImageView etd;
    private TextView ete;
    private TextView etf;
    private com.baidu.tieba.barselect.view.a etg;
    private long forumId;
    private NavigationBar mNavigationBar;
    private boolean needRetry = false;
    private int eth = 0;
    private int eti = 0;
    private View.OnClickListener ckH = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.IdentityReviewActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == R.id.identity_card_positive) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2921412, new CameraActivityConfig(IdentityReviewActivity.this, IdentityReviewActivity.this.esU, CameraActivityConfig.CONTENT_TYPE_ID_CARD_FRONT, 101)));
            } else if (view.getId() == R.id.identity_card_negative) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2921412, new CameraActivityConfig(IdentityReviewActivity.this, IdentityReviewActivity.this.esV, CameraActivityConfig.CONTENT_TYPE_ID_CARD_BACK, 102)));
            } else if (view.getId() == R.id.bottom_next_button) {
                new a(IdentityReviewActivity.this.esU, 1, IdentityReviewActivity.this.ern).execute(new Void[0]);
                IdentityReviewActivity.this.needRetry = true;
                IdentityReviewActivity.this.etg = new com.baidu.tieba.barselect.view.a(IdentityReviewActivity.this);
                IdentityReviewActivity.this.etg.setCancelable(true);
                IdentityReviewActivity.this.etg.setCanceledOnTouchOutside(false);
                IdentityReviewActivity.this.etg.setMessage(TbadkCoreApplication.getInst().getString(R.string.check_id_card));
                g.a(IdentityReviewActivity.this.etg, IdentityReviewActivity.this);
            }
        }
    };
    com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a> cuu = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.barselect.idCard.IdentityReviewActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.f.b
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            super.onLoaded((AnonymousClass2) aVar, str, i);
            if (str != null && aVar != null) {
                if (str.equals(IdentityReviewActivity.this.esU)) {
                    aVar.a(IdentityReviewActivity.this.etb);
                    IdentityReviewActivity.this.ete.setVisibility(0);
                } else if (str.equals(IdentityReviewActivity.this.esV)) {
                    aVar.a(IdentityReviewActivity.this.etd);
                    IdentityReviewActivity.this.etf.setVisibility(0);
                }
            }
            if (str != null) {
                com.baidu.tbadk.imageManager.c.asp().qp(str + 32);
            }
        }
    };
    com.baidu.adp.framework.listener.a byk = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_COMMIT_CARD_INFO, 309643) { // from class: com.baidu.tieba.barselect.idCard.IdentityReviewActivity.3
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage != null && responsedMessage.getOrginalMessage() != null) {
                int error = responsedMessage.getError();
                Object extra = responsedMessage.getOrginalMessage().getExtra();
                if (extra instanceof CommitCardInfoReqMsg) {
                    if (error == 0) {
                        if (((CommitCardInfoReqMsg) extra).card_type == 1) {
                            IdentityReviewActivity.this.eth = 2;
                        } else if (((CommitCardInfoReqMsg) extra).card_type == 2) {
                            IdentityReviewActivity.this.eti = 2;
                        }
                        if (IdentityReviewActivity.this.eth < 2 || IdentityReviewActivity.this.eti < 2) {
                            if (IdentityReviewActivity.this.eti == 1) {
                                if (IdentityReviewActivity.this.ern == null) {
                                    if (IdentityReviewActivity.this.etg != null) {
                                        g.b(IdentityReviewActivity.this.etg, IdentityReviewActivity.this);
                                        return;
                                    }
                                    return;
                                }
                                new a(IdentityReviewActivity.this.esV, 2, IdentityReviewActivity.this.ern).execute(new Void[0]);
                            }
                        } else if (IdentityReviewActivity.this.esT != null) {
                            IdentityReviewActivity.this.esT.cv(IdentityReviewActivity.this.forumId);
                        } else if (IdentityReviewActivity.this.etg != null) {
                            g.b(IdentityReviewActivity.this.etg, IdentityReviewActivity.this);
                        }
                    } else if (error != -100000303 || !IdentityReviewActivity.this.needRetry) {
                        if (IdentityReviewActivity.this.etg != null && IdentityReviewActivity.this.etg.isShowing()) {
                            g.b(IdentityReviewActivity.this.etg, IdentityReviewActivity.this);
                        }
                        l.E(TbadkCoreApplication.getInst(), responsedMessage.getErrorString());
                        IdentityReviewActivity.this.eth = 1;
                        IdentityReviewActivity.this.eti = 1;
                    } else {
                        IdentityReviewActivity.this.eth = 1;
                        IdentityReviewActivity.this.eti = 1;
                        if (IdentityReviewActivity.this.ern != null) {
                            IdentityReviewActivity.this.needRetry = false;
                            new a(IdentityReviewActivity.this.esU, 1, IdentityReviewActivity.this.ern).execute(new Void[0]);
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
                if (IdentityReviewActivity.this.etg != null && IdentityReviewActivity.this.etg.isShowing()) {
                    g.b(IdentityReviewActivity.this.etg, IdentityReviewActivity.this);
                }
                String str = "https://tieba.baidu.com/mo/q/newmanagerapplyresult?passIDCert=1&nomenu=1&forum_id=" + IdentityReviewActivity.this.forumId;
                if (error == 0) {
                    ba.aiz().c(IdentityReviewActivity.this.getPageContext(), new String[]{str});
                    IdentityReviewActivity.this.setResult(-1);
                    IdentityReviewActivity.this.finish();
                    return;
                }
                l.E(TbadkCoreApplication.getInst(), httpResponsedMessage.getErrorString());
                IdentityReviewActivity.this.eth = 1;
                IdentityReviewActivity.this.eti = 1;
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.identity_review_activity);
        this.forumId = getIntent().getLongExtra("fid", 0L);
        this.ern = new com.baidu.tieba.barselect.data.c(getPageContext());
        this.esT = new com.baidu.tieba.barselect.data.b(getPageContext());
        this.esU = new File(TbadkCoreApplication.getInst().getFilesDir(), "positive.jpg").getAbsolutePath();
        this.esV = new File(TbadkCoreApplication.getInst().getFilesDir(), "negative.jpg").getAbsolutePath();
        this.esW = findViewById(R.id.id_card_view);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.id_review_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(getResources().getString(R.string.bar_manager_apply));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.esX = (TextView) findViewById(R.id.bottom_next_button);
        this.esX.setEnabled(false);
        this.esY = (TextView) findViewById(R.id.identity_view_title);
        this.esZ = (TextView) findViewById(R.id.positive_card_coloct_tip);
        this.eta = (TextView) findViewById(R.id.negative_card_coloct_tip);
        this.etb = (TbImageView) findViewById(R.id.identity_card_positive);
        this.etd = (TbImageView) findViewById(R.id.identity_card_negative);
        this.ete = (TextView) findViewById(R.id.identity_card_positive_logo);
        this.etf = (TextView) findViewById(R.id.identity_card_negative_logo);
        MessageManager.getInstance().registerListener(this.byk);
        MessageManager.getInstance().registerListener(this.mHttpMessageListener);
        this.etb.setOnClickListener(this.ckH);
        this.etd.setOnClickListener(this.ckH);
        this.esX.setOnClickListener(this.ckH);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        }
        al.c(this.esX, R.color.cp_btn_a, 1, i);
        al.g(this.esX, R.drawable.bg_id_card_button, i);
        al.c(this.esY, R.color.cp_cont_b, 1, i);
        al.c(this.esZ, R.color.cp_cont_d, 1, i);
        al.c(this.eta, R.color.cp_cont_d, 1, i);
        int g = l.g(this, R.dimen.tbds10);
        al.c(this.ete, R.color.cp_btn_a, 1, i);
        al.c(this.etf, R.color.cp_btn_a, 1, i);
        al.b(this.ete, g, (int) R.color.cp_cont_b_alpha42, (int) R.color.cp_cont_b_alpha42, i);
        al.b(this.etf, g, (int) R.color.cp_cont_b_alpha42, (int) R.color.cp_cont_b_alpha42, i);
        if (this.eth < 1) {
            al.b(this.etb, (int) R.drawable.pic_id_front, i);
        }
        if (this.eti < 1) {
            al.b(this.etd, (int) R.drawable.pic_id_back, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if (i == 101) {
                com.baidu.adp.lib.f.c.iv().a(this.esU, 32, this.cuu, getUniqueId());
                this.eth = 1;
            } else if (i == 102) {
                com.baidu.adp.lib.f.c.iv().a(this.esV, 32, this.cuu, getUniqueId());
                this.eti = 1;
            }
            if (this.esX != null) {
                if (this.eti >= 1 && this.eth >= 1) {
                    this.esX.setEnabled(true);
                } else {
                    this.esX.setEnabled(false);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.byk);
        MessageManager.getInstance().unRegisterListener(this.mHttpMessageListener);
        if (this.etg != null && this.etg.isShowing()) {
            g.b(this.etg, this);
        }
        super.onDestroy();
    }
}
