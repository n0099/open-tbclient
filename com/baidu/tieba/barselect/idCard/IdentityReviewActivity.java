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
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.barselect.data.CommitCardInfoReqMsg;
import java.io.File;
/* loaded from: classes8.dex */
public class IdentityReviewActivity extends BaseActivity {
    private long forumId;
    private com.baidu.tieba.barselect.data.c ipH;
    private com.baidu.tieba.barselect.data.b irl;
    public String irm;
    public String irn;
    private View iro;
    private TextView irp;
    private TextView irq;
    private TextView irr;
    private TextView irs;
    private TbImageView irt;
    private TbImageView iru;
    private TextView irv;
    private TextView irw;
    private com.baidu.tieba.barselect.view.a irx;
    private NavigationBar mNavigationBar;
    private boolean needRetry = false;
    private int iry = 0;
    private int irz = 0;
    private View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.IdentityReviewActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == R.id.identity_card_positive) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2921412, new CameraActivityConfig(IdentityReviewActivity.this, IdentityReviewActivity.this.irm, CameraActivityConfig.CONTENT_TYPE_ID_CARD_FRONT, 101)));
            } else if (view.getId() == R.id.identity_card_negative) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2921412, new CameraActivityConfig(IdentityReviewActivity.this, IdentityReviewActivity.this.irn, CameraActivityConfig.CONTENT_TYPE_ID_CARD_BACK, 102)));
            } else if (view.getId() == R.id.bottom_next_button) {
                new a(IdentityReviewActivity.this.irm, 1, IdentityReviewActivity.this.ipH).execute(new Void[0]);
                IdentityReviewActivity.this.needRetry = true;
                IdentityReviewActivity.this.irx = new com.baidu.tieba.barselect.view.a(IdentityReviewActivity.this);
                IdentityReviewActivity.this.irx.setCancelable(true);
                IdentityReviewActivity.this.irx.setCanceledOnTouchOutside(false);
                IdentityReviewActivity.this.irx.setMessage(TbadkCoreApplication.getInst().getString(R.string.check_id_card));
                g.showDialog(IdentityReviewActivity.this.irx, IdentityReviewActivity.this);
            }
        }
    };
    com.baidu.adp.lib.e.c<com.baidu.adp.widget.ImageView.a> fIn = new com.baidu.adp.lib.e.c<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.barselect.idCard.IdentityReviewActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.e.c
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            super.onLoaded((AnonymousClass2) aVar, str, i);
            if (str != null && aVar != null) {
                if (str.equals(IdentityReviewActivity.this.irm)) {
                    aVar.drawImageTo(IdentityReviewActivity.this.irt);
                    IdentityReviewActivity.this.irv.setVisibility(0);
                } else if (str.equals(IdentityReviewActivity.this.irn)) {
                    aVar.drawImageTo(IdentityReviewActivity.this.iru);
                    IdentityReviewActivity.this.irw.setVisibility(0);
                }
            }
            if (str != null) {
                com.baidu.tbadk.imageManager.c.bGp().deletePic(str + 32);
            }
        }
    };
    com.baidu.adp.framework.listener.a eFZ = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_COMMIT_CARD_INFO, 309643) { // from class: com.baidu.tieba.barselect.idCard.IdentityReviewActivity.3
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage != null && responsedMessage.getOrginalMessage() != null) {
                int error = responsedMessage.getError();
                Object extra = responsedMessage.getOrginalMessage().getExtra();
                if (extra instanceof CommitCardInfoReqMsg) {
                    if (error == 0) {
                        if (((CommitCardInfoReqMsg) extra).card_type == 1) {
                            IdentityReviewActivity.this.iry = 2;
                        } else if (((CommitCardInfoReqMsg) extra).card_type == 2) {
                            IdentityReviewActivity.this.irz = 2;
                        }
                        if (IdentityReviewActivity.this.iry < 2 || IdentityReviewActivity.this.irz < 2) {
                            if (IdentityReviewActivity.this.irz == 1) {
                                if (IdentityReviewActivity.this.ipH == null) {
                                    if (IdentityReviewActivity.this.irx != null) {
                                        g.dismissDialog(IdentityReviewActivity.this.irx, IdentityReviewActivity.this);
                                        return;
                                    }
                                    return;
                                }
                                new a(IdentityReviewActivity.this.irn, 2, IdentityReviewActivity.this.ipH).execute(new Void[0]);
                            }
                        } else if (IdentityReviewActivity.this.irl != null) {
                            IdentityReviewActivity.this.irl.fV(IdentityReviewActivity.this.forumId);
                        } else if (IdentityReviewActivity.this.irx != null) {
                            g.dismissDialog(IdentityReviewActivity.this.irx, IdentityReviewActivity.this);
                        }
                    } else if (error != -100000303 || !IdentityReviewActivity.this.needRetry) {
                        if (IdentityReviewActivity.this.irx != null && IdentityReviewActivity.this.irx.isShowing()) {
                            g.dismissDialog(IdentityReviewActivity.this.irx, IdentityReviewActivity.this);
                        }
                        l.showLongToast(TbadkCoreApplication.getInst(), responsedMessage.getErrorString());
                        IdentityReviewActivity.this.iry = 1;
                        IdentityReviewActivity.this.irz = 1;
                    } else {
                        IdentityReviewActivity.this.iry = 1;
                        IdentityReviewActivity.this.irz = 1;
                        if (IdentityReviewActivity.this.ipH != null) {
                            IdentityReviewActivity.this.needRetry = false;
                            new a(IdentityReviewActivity.this.irm, 1, IdentityReviewActivity.this.ipH).execute(new Void[0]);
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
                if (IdentityReviewActivity.this.irx != null && IdentityReviewActivity.this.irx.isShowing()) {
                    g.dismissDialog(IdentityReviewActivity.this.irx, IdentityReviewActivity.this);
                }
                String str = "https://tieba.baidu.com/mo/q/newmanagerapplyresult?passIDCert=1&nomenu=1&forum_id=" + IdentityReviewActivity.this.forumId;
                if (error == 0) {
                    be.bwu().b(IdentityReviewActivity.this.getPageContext(), new String[]{str});
                    IdentityReviewActivity.this.setResult(-1);
                    IdentityReviewActivity.this.finish();
                    return;
                }
                l.showLongToast(TbadkCoreApplication.getInst(), httpResponsedMessage.getErrorString());
                IdentityReviewActivity.this.iry = 1;
                IdentityReviewActivity.this.irz = 1;
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.identity_review_activity);
        this.forumId = getIntent().getLongExtra("fid", 0L);
        this.ipH = new com.baidu.tieba.barselect.data.c(getPageContext());
        this.irl = new com.baidu.tieba.barselect.data.b(getPageContext());
        this.irm = new File(TbadkCoreApplication.getInst().getFilesDir(), "positive.jpg").getAbsolutePath();
        this.irn = new File(TbadkCoreApplication.getInst().getFilesDir(), "negative.jpg").getAbsolutePath();
        this.iro = findViewById(R.id.id_card_view);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.id_review_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(getResources().getString(R.string.bar_manager_apply));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.irp = (TextView) findViewById(R.id.bottom_next_button);
        this.irp.setEnabled(false);
        this.irq = (TextView) findViewById(R.id.identity_view_title);
        this.irr = (TextView) findViewById(R.id.positive_card_coloct_tip);
        this.irs = (TextView) findViewById(R.id.negative_card_coloct_tip);
        this.irt = (TbImageView) findViewById(R.id.identity_card_positive);
        this.iru = (TbImageView) findViewById(R.id.identity_card_negative);
        this.irv = (TextView) findViewById(R.id.identity_card_positive_logo);
        this.irw = (TextView) findViewById(R.id.identity_card_negative_logo);
        MessageManager.getInstance().registerListener(this.eFZ);
        MessageManager.getInstance().registerListener(this.mHttpMessageListener);
        this.irt.setOnClickListener(this.onClickListener);
        this.iru.setOnClickListener(this.onClickListener);
        this.irp.setOnClickListener(this.onClickListener);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        }
        ao.setViewTextColor(this.irp, R.color.CAM_X0101, 1, i);
        ao.setBackgroundResource(this.irp, R.drawable.bg_id_card_button, i);
        ao.setViewTextColor(this.irq, R.color.CAM_X0105, 1, i);
        ao.setViewTextColor(this.irr, R.color.CAM_X0109, 1, i);
        ao.setViewTextColor(this.irs, R.color.CAM_X0109, 1, i);
        int dimens = l.getDimens(this, R.dimen.tbds10);
        ao.setViewTextColor(this.irv, R.color.CAM_X0101, 1, i);
        ao.setViewTextColor(this.irw, R.color.CAM_X0101, 1, i);
        ao.e(this.irv, dimens, R.color.cp_cont_b_alpha42, R.color.cp_cont_b_alpha42, i);
        ao.e(this.irw, dimens, R.color.cp_cont_b_alpha42, R.color.cp_cont_b_alpha42, i);
        if (this.iry < 1) {
            ao.setImageResource(this.irt, R.drawable.pic_id_front, i);
        }
        if (this.irz < 1) {
            ao.setImageResource(this.iru, R.drawable.pic_id_back, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if (i == 101) {
                com.baidu.adp.lib.e.d.mx().a(this.irm, 32, this.fIn, getUniqueId());
                this.iry = 1;
            } else if (i == 102) {
                com.baidu.adp.lib.e.d.mx().a(this.irn, 32, this.fIn, getUniqueId());
                this.irz = 1;
            }
            if (this.irp != null) {
                if (this.irz >= 1 && this.iry >= 1) {
                    this.irp.setEnabled(true);
                } else {
                    this.irp.setEnabled(false);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.eFZ);
        MessageManager.getInstance().unRegisterListener(this.mHttpMessageListener);
        if (this.irx != null && this.irx.isShowing()) {
            g.dismissDialog(this.irx, this);
        }
        super.onDestroy();
    }
}
