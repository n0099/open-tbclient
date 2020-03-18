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
    private com.baidu.tieba.barselect.data.c fEz;
    private com.baidu.tieba.barselect.data.b fGc;
    public String fGd;
    public String fGe;
    private View fGf;
    private TextView fGg;
    private TextView fGh;
    private TextView fGi;
    private TextView fGj;
    private TbImageView fGk;
    private TbImageView fGl;
    private TextView fGm;
    private TextView fGn;
    private com.baidu.tieba.barselect.view.a fGo;
    private long forumId;
    private NavigationBar mNavigationBar;
    private boolean needRetry = false;
    private int fGp = 0;
    private int fGq = 0;
    private View.OnClickListener drJ = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.IdentityReviewActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == R.id.identity_card_positive) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2921412, new CameraActivityConfig(IdentityReviewActivity.this, IdentityReviewActivity.this.fGd, CameraActivityConfig.CONTENT_TYPE_ID_CARD_FRONT, 101)));
            } else if (view.getId() == R.id.identity_card_negative) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2921412, new CameraActivityConfig(IdentityReviewActivity.this, IdentityReviewActivity.this.fGe, CameraActivityConfig.CONTENT_TYPE_ID_CARD_BACK, 102)));
            } else if (view.getId() == R.id.bottom_next_button) {
                new a(IdentityReviewActivity.this.fGd, 1, IdentityReviewActivity.this.fEz).execute(new Void[0]);
                IdentityReviewActivity.this.needRetry = true;
                IdentityReviewActivity.this.fGo = new com.baidu.tieba.barselect.view.a(IdentityReviewActivity.this);
                IdentityReviewActivity.this.fGo.setCancelable(true);
                IdentityReviewActivity.this.fGo.setCanceledOnTouchOutside(false);
                IdentityReviewActivity.this.fGo.setMessage(TbadkCoreApplication.getInst().getString(R.string.check_id_card));
                g.showDialog(IdentityReviewActivity.this.fGo, IdentityReviewActivity.this);
            }
        }
    };
    com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a> dAJ = new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.barselect.idCard.IdentityReviewActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.e.b
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            super.onLoaded((AnonymousClass2) aVar, str, i);
            if (str != null && aVar != null) {
                if (str.equals(IdentityReviewActivity.this.fGd)) {
                    aVar.drawImageTo(IdentityReviewActivity.this.fGk);
                    IdentityReviewActivity.this.fGm.setVisibility(0);
                } else if (str.equals(IdentityReviewActivity.this.fGe)) {
                    aVar.drawImageTo(IdentityReviewActivity.this.fGl);
                    IdentityReviewActivity.this.fGn.setVisibility(0);
                }
            }
            if (str != null) {
                com.baidu.tbadk.imageManager.c.aPV().deletePic(str + 32);
            }
        }
    };
    com.baidu.adp.framework.listener.a cIi = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_COMMIT_CARD_INFO, 309643) { // from class: com.baidu.tieba.barselect.idCard.IdentityReviewActivity.3
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage != null && responsedMessage.getOrginalMessage() != null) {
                int error = responsedMessage.getError();
                Object extra = responsedMessage.getOrginalMessage().getExtra();
                if (extra instanceof CommitCardInfoReqMsg) {
                    if (error == 0) {
                        if (((CommitCardInfoReqMsg) extra).card_type == 1) {
                            IdentityReviewActivity.this.fGp = 2;
                        } else if (((CommitCardInfoReqMsg) extra).card_type == 2) {
                            IdentityReviewActivity.this.fGq = 2;
                        }
                        if (IdentityReviewActivity.this.fGp < 2 || IdentityReviewActivity.this.fGq < 2) {
                            if (IdentityReviewActivity.this.fGq == 1) {
                                if (IdentityReviewActivity.this.fEz == null) {
                                    if (IdentityReviewActivity.this.fGo != null) {
                                        g.dismissDialog(IdentityReviewActivity.this.fGo, IdentityReviewActivity.this);
                                        return;
                                    }
                                    return;
                                }
                                new a(IdentityReviewActivity.this.fGe, 2, IdentityReviewActivity.this.fEz).execute(new Void[0]);
                            }
                        } else if (IdentityReviewActivity.this.fGc != null) {
                            IdentityReviewActivity.this.fGc.dg(IdentityReviewActivity.this.forumId);
                        } else if (IdentityReviewActivity.this.fGo != null) {
                            g.dismissDialog(IdentityReviewActivity.this.fGo, IdentityReviewActivity.this);
                        }
                    } else if (error != -100000303 || !IdentityReviewActivity.this.needRetry) {
                        if (IdentityReviewActivity.this.fGo != null && IdentityReviewActivity.this.fGo.isShowing()) {
                            g.dismissDialog(IdentityReviewActivity.this.fGo, IdentityReviewActivity.this);
                        }
                        l.showLongToast(TbadkCoreApplication.getInst(), responsedMessage.getErrorString());
                        IdentityReviewActivity.this.fGp = 1;
                        IdentityReviewActivity.this.fGq = 1;
                    } else {
                        IdentityReviewActivity.this.fGp = 1;
                        IdentityReviewActivity.this.fGq = 1;
                        if (IdentityReviewActivity.this.fEz != null) {
                            IdentityReviewActivity.this.needRetry = false;
                            new a(IdentityReviewActivity.this.fGd, 1, IdentityReviewActivity.this.fEz).execute(new Void[0]);
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
                if (IdentityReviewActivity.this.fGo != null && IdentityReviewActivity.this.fGo.isShowing()) {
                    g.dismissDialog(IdentityReviewActivity.this.fGo, IdentityReviewActivity.this);
                }
                String str = "https://tieba.baidu.com/mo/q/newmanagerapplyresult?passIDCert=1&nomenu=1&forum_id=" + IdentityReviewActivity.this.forumId;
                if (error == 0) {
                    ba.aGK().b(IdentityReviewActivity.this.getPageContext(), new String[]{str});
                    IdentityReviewActivity.this.setResult(-1);
                    IdentityReviewActivity.this.finish();
                    return;
                }
                l.showLongToast(TbadkCoreApplication.getInst(), httpResponsedMessage.getErrorString());
                IdentityReviewActivity.this.fGp = 1;
                IdentityReviewActivity.this.fGq = 1;
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.identity_review_activity);
        this.forumId = getIntent().getLongExtra("fid", 0L);
        this.fEz = new com.baidu.tieba.barselect.data.c(getPageContext());
        this.fGc = new com.baidu.tieba.barselect.data.b(getPageContext());
        this.fGd = new File(TbadkCoreApplication.getInst().getFilesDir(), "positive.jpg").getAbsolutePath();
        this.fGe = new File(TbadkCoreApplication.getInst().getFilesDir(), "negative.jpg").getAbsolutePath();
        this.fGf = findViewById(R.id.id_card_view);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.id_review_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(getResources().getString(R.string.bar_manager_apply));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.fGg = (TextView) findViewById(R.id.bottom_next_button);
        this.fGg.setEnabled(false);
        this.fGh = (TextView) findViewById(R.id.identity_view_title);
        this.fGi = (TextView) findViewById(R.id.positive_card_coloct_tip);
        this.fGj = (TextView) findViewById(R.id.negative_card_coloct_tip);
        this.fGk = (TbImageView) findViewById(R.id.identity_card_positive);
        this.fGl = (TbImageView) findViewById(R.id.identity_card_negative);
        this.fGm = (TextView) findViewById(R.id.identity_card_positive_logo);
        this.fGn = (TextView) findViewById(R.id.identity_card_negative_logo);
        MessageManager.getInstance().registerListener(this.cIi);
        MessageManager.getInstance().registerListener(this.mHttpMessageListener);
        this.fGk.setOnClickListener(this.drJ);
        this.fGl.setOnClickListener(this.drJ);
        this.fGg.setOnClickListener(this.drJ);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        }
        am.setViewTextColor(this.fGg, R.color.cp_cont_a, 1, i);
        am.setBackgroundResource(this.fGg, R.drawable.bg_id_card_button, i);
        am.setViewTextColor(this.fGh, R.color.cp_cont_b, 1, i);
        am.setViewTextColor(this.fGi, R.color.cp_cont_d, 1, i);
        am.setViewTextColor(this.fGj, R.color.cp_cont_d, 1, i);
        int dimens = l.getDimens(this, R.dimen.tbds10);
        am.setViewTextColor(this.fGm, R.color.cp_cont_a, 1, i);
        am.setViewTextColor(this.fGn, R.color.cp_cont_a, 1, i);
        am.c(this.fGm, dimens, (int) R.color.cp_cont_b_alpha42, (int) R.color.cp_cont_b_alpha42, i);
        am.c(this.fGn, dimens, (int) R.color.cp_cont_b_alpha42, (int) R.color.cp_cont_b_alpha42, i);
        if (this.fGp < 1) {
            am.setImageResource(this.fGk, R.drawable.pic_id_front, i);
        }
        if (this.fGq < 1) {
            am.setImageResource(this.fGl, R.drawable.pic_id_back, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if (i == 101) {
                com.baidu.adp.lib.e.c.gr().a(this.fGd, 32, this.dAJ, getUniqueId());
                this.fGp = 1;
            } else if (i == 102) {
                com.baidu.adp.lib.e.c.gr().a(this.fGe, 32, this.dAJ, getUniqueId());
                this.fGq = 1;
            }
            if (this.fGg != null) {
                if (this.fGq >= 1 && this.fGp >= 1) {
                    this.fGg.setEnabled(true);
                } else {
                    this.fGg.setEnabled(false);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.cIi);
        MessageManager.getInstance().unRegisterListener(this.mHttpMessageListener);
        if (this.fGo != null && this.fGo.isShowing()) {
            g.dismissDialog(this.fGo, this);
        }
        super.onDestroy();
    }
}
