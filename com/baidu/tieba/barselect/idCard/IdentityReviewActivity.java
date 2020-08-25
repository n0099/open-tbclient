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
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.barselect.data.CommitCardInfoReqMsg;
import java.io.File;
/* loaded from: classes15.dex */
public class IdentityReviewActivity extends BaseActivity {
    private long forumId;
    private com.baidu.tieba.barselect.data.c hdt;
    private com.baidu.tieba.barselect.data.b heZ;
    public String hfa;
    public String hfb;
    private View hfc;
    private TextView hfd;
    private TextView hfe;
    private TextView hff;
    private TextView hfg;
    private TbImageView hfh;
    private TbImageView hfi;
    private TextView hfj;
    private TextView hfk;
    private com.baidu.tieba.barselect.view.a hfl;
    private NavigationBar mNavigationBar;
    private boolean needRetry = false;
    private int hfm = 0;
    private int hfn = 0;
    private View.OnClickListener eFC = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.IdentityReviewActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == R.id.identity_card_positive) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2921412, new CameraActivityConfig(IdentityReviewActivity.this, IdentityReviewActivity.this.hfa, CameraActivityConfig.CONTENT_TYPE_ID_CARD_FRONT, 101)));
            } else if (view.getId() == R.id.identity_card_negative) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2921412, new CameraActivityConfig(IdentityReviewActivity.this, IdentityReviewActivity.this.hfb, CameraActivityConfig.CONTENT_TYPE_ID_CARD_BACK, 102)));
            } else if (view.getId() == R.id.bottom_next_button) {
                new a(IdentityReviewActivity.this.hfa, 1, IdentityReviewActivity.this.hdt).execute(new Void[0]);
                IdentityReviewActivity.this.needRetry = true;
                IdentityReviewActivity.this.hfl = new com.baidu.tieba.barselect.view.a(IdentityReviewActivity.this);
                IdentityReviewActivity.this.hfl.setCancelable(true);
                IdentityReviewActivity.this.hfl.setCanceledOnTouchOutside(false);
                IdentityReviewActivity.this.hfl.setMessage(TbadkCoreApplication.getInst().getString(R.string.check_id_card));
                g.showDialog(IdentityReviewActivity.this.hfl, IdentityReviewActivity.this);
            }
        }
    };
    com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a> eOr = new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.barselect.idCard.IdentityReviewActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.e.b
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            super.onLoaded((AnonymousClass2) aVar, str, i);
            if (str != null && aVar != null) {
                if (str.equals(IdentityReviewActivity.this.hfa)) {
                    aVar.drawImageTo(IdentityReviewActivity.this.hfh);
                    IdentityReviewActivity.this.hfj.setVisibility(0);
                } else if (str.equals(IdentityReviewActivity.this.hfb)) {
                    aVar.drawImageTo(IdentityReviewActivity.this.hfi);
                    IdentityReviewActivity.this.hfk.setVisibility(0);
                }
            }
            if (str != null) {
                com.baidu.tbadk.imageManager.c.bsW().deletePic(str + 32);
            }
        }
    };
    com.baidu.adp.framework.listener.a dOR = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_COMMIT_CARD_INFO, 309643) { // from class: com.baidu.tieba.barselect.idCard.IdentityReviewActivity.3
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage != null && responsedMessage.getOrginalMessage() != null) {
                int error = responsedMessage.getError();
                Object extra = responsedMessage.getOrginalMessage().getExtra();
                if (extra instanceof CommitCardInfoReqMsg) {
                    if (error == 0) {
                        if (((CommitCardInfoReqMsg) extra).card_type == 1) {
                            IdentityReviewActivity.this.hfm = 2;
                        } else if (((CommitCardInfoReqMsg) extra).card_type == 2) {
                            IdentityReviewActivity.this.hfn = 2;
                        }
                        if (IdentityReviewActivity.this.hfm < 2 || IdentityReviewActivity.this.hfn < 2) {
                            if (IdentityReviewActivity.this.hfn == 1) {
                                if (IdentityReviewActivity.this.hdt == null) {
                                    if (IdentityReviewActivity.this.hfl != null) {
                                        g.dismissDialog(IdentityReviewActivity.this.hfl, IdentityReviewActivity.this);
                                        return;
                                    }
                                    return;
                                }
                                new a(IdentityReviewActivity.this.hfb, 2, IdentityReviewActivity.this.hdt).execute(new Void[0]);
                            }
                        } else if (IdentityReviewActivity.this.heZ != null) {
                            IdentityReviewActivity.this.heZ.eq(IdentityReviewActivity.this.forumId);
                        } else if (IdentityReviewActivity.this.hfl != null) {
                            g.dismissDialog(IdentityReviewActivity.this.hfl, IdentityReviewActivity.this);
                        }
                    } else if (error != -100000303 || !IdentityReviewActivity.this.needRetry) {
                        if (IdentityReviewActivity.this.hfl != null && IdentityReviewActivity.this.hfl.isShowing()) {
                            g.dismissDialog(IdentityReviewActivity.this.hfl, IdentityReviewActivity.this);
                        }
                        l.showLongToast(TbadkCoreApplication.getInst(), responsedMessage.getErrorString());
                        IdentityReviewActivity.this.hfm = 1;
                        IdentityReviewActivity.this.hfn = 1;
                    } else {
                        IdentityReviewActivity.this.hfm = 1;
                        IdentityReviewActivity.this.hfn = 1;
                        if (IdentityReviewActivity.this.hdt != null) {
                            IdentityReviewActivity.this.needRetry = false;
                            new a(IdentityReviewActivity.this.hfa, 1, IdentityReviewActivity.this.hdt).execute(new Void[0]);
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
                if (IdentityReviewActivity.this.hfl != null && IdentityReviewActivity.this.hfl.isShowing()) {
                    g.dismissDialog(IdentityReviewActivity.this.hfl, IdentityReviewActivity.this);
                }
                String str = "https://tieba.baidu.com/mo/q/newmanagerapplyresult?passIDCert=1&nomenu=1&forum_id=" + IdentityReviewActivity.this.forumId;
                if (error == 0) {
                    be.bju().b(IdentityReviewActivity.this.getPageContext(), new String[]{str});
                    IdentityReviewActivity.this.setResult(-1);
                    IdentityReviewActivity.this.finish();
                    return;
                }
                l.showLongToast(TbadkCoreApplication.getInst(), httpResponsedMessage.getErrorString());
                IdentityReviewActivity.this.hfm = 1;
                IdentityReviewActivity.this.hfn = 1;
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.identity_review_activity);
        this.forumId = getIntent().getLongExtra("fid", 0L);
        this.hdt = new com.baidu.tieba.barselect.data.c(getPageContext());
        this.heZ = new com.baidu.tieba.barselect.data.b(getPageContext());
        this.hfa = new File(TbadkCoreApplication.getInst().getFilesDir(), "positive.jpg").getAbsolutePath();
        this.hfb = new File(TbadkCoreApplication.getInst().getFilesDir(), "negative.jpg").getAbsolutePath();
        this.hfc = findViewById(R.id.id_card_view);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.id_review_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(getResources().getString(R.string.bar_manager_apply));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.hfd = (TextView) findViewById(R.id.bottom_next_button);
        this.hfd.setEnabled(false);
        this.hfe = (TextView) findViewById(R.id.identity_view_title);
        this.hff = (TextView) findViewById(R.id.positive_card_coloct_tip);
        this.hfg = (TextView) findViewById(R.id.negative_card_coloct_tip);
        this.hfh = (TbImageView) findViewById(R.id.identity_card_positive);
        this.hfi = (TbImageView) findViewById(R.id.identity_card_negative);
        this.hfj = (TextView) findViewById(R.id.identity_card_positive_logo);
        this.hfk = (TextView) findViewById(R.id.identity_card_negative_logo);
        MessageManager.getInstance().registerListener(this.dOR);
        MessageManager.getInstance().registerListener(this.mHttpMessageListener);
        this.hfh.setOnClickListener(this.eFC);
        this.hfi.setOnClickListener(this.eFC);
        this.hfd.setOnClickListener(this.eFC);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        }
        ap.setViewTextColor(this.hfd, R.color.cp_cont_a, 1, i);
        ap.setBackgroundResource(this.hfd, R.drawable.bg_id_card_button, i);
        ap.setViewTextColor(this.hfe, R.color.cp_cont_b, 1, i);
        ap.setViewTextColor(this.hff, R.color.cp_cont_d, 1, i);
        ap.setViewTextColor(this.hfg, R.color.cp_cont_d, 1, i);
        int dimens = l.getDimens(this, R.dimen.tbds10);
        ap.setViewTextColor(this.hfj, R.color.cp_cont_a, 1, i);
        ap.setViewTextColor(this.hfk, R.color.cp_cont_a, 1, i);
        ap.c(this.hfj, dimens, R.color.cp_cont_b_alpha42, R.color.cp_cont_b_alpha42, i);
        ap.c(this.hfk, dimens, R.color.cp_cont_b_alpha42, R.color.cp_cont_b_alpha42, i);
        if (this.hfm < 1) {
            ap.setImageResource(this.hfh, R.drawable.pic_id_front, i);
        }
        if (this.hfn < 1) {
            ap.setImageResource(this.hfi, R.drawable.pic_id_back, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if (i == 101) {
                com.baidu.adp.lib.e.c.mM().a(this.hfa, 32, this.eOr, getUniqueId());
                this.hfm = 1;
            } else if (i == 102) {
                com.baidu.adp.lib.e.c.mM().a(this.hfb, 32, this.eOr, getUniqueId());
                this.hfn = 1;
            }
            if (this.hfd != null) {
                if (this.hfn >= 1 && this.hfm >= 1) {
                    this.hfd.setEnabled(true);
                } else {
                    this.hfd.setEnabled(false);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.dOR);
        MessageManager.getInstance().unRegisterListener(this.mHttpMessageListener);
        if (this.hfl != null && this.hfl.isShowing()) {
            g.dismissDialog(this.hfl, this);
        }
        super.onDestroy();
    }
}
