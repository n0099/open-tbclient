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
    private com.baidu.tieba.barselect.data.c idi;
    private com.baidu.tieba.barselect.data.b ieQ;
    public String ieR;
    public String ieS;
    private View ieT;
    private TextView ieU;
    private TextView ieV;
    private TextView ieW;
    private TextView ieX;
    private TbImageView ieY;
    private TbImageView ieZ;
    private TextView ifa;
    private TextView ifb;
    private com.baidu.tieba.barselect.view.a ifc;
    private NavigationBar mNavigationBar;
    private boolean needRetry = false;
    private int ifd = 0;
    private int ife = 0;
    private View.OnClickListener foP = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.IdentityReviewActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == R.id.identity_card_positive) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2921412, new CameraActivityConfig(IdentityReviewActivity.this, IdentityReviewActivity.this.ieR, CameraActivityConfig.CONTENT_TYPE_ID_CARD_FRONT, 101)));
            } else if (view.getId() == R.id.identity_card_negative) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2921412, new CameraActivityConfig(IdentityReviewActivity.this, IdentityReviewActivity.this.ieS, CameraActivityConfig.CONTENT_TYPE_ID_CARD_BACK, 102)));
            } else if (view.getId() == R.id.bottom_next_button) {
                new a(IdentityReviewActivity.this.ieR, 1, IdentityReviewActivity.this.idi).execute(new Void[0]);
                IdentityReviewActivity.this.needRetry = true;
                IdentityReviewActivity.this.ifc = new com.baidu.tieba.barselect.view.a(IdentityReviewActivity.this);
                IdentityReviewActivity.this.ifc.setCancelable(true);
                IdentityReviewActivity.this.ifc.setCanceledOnTouchOutside(false);
                IdentityReviewActivity.this.ifc.setMessage(TbadkCoreApplication.getInst().getString(R.string.check_id_card));
                g.showDialog(IdentityReviewActivity.this.ifc, IdentityReviewActivity.this);
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
                if (str.equals(IdentityReviewActivity.this.ieR)) {
                    aVar.drawImageTo(IdentityReviewActivity.this.ieY);
                    IdentityReviewActivity.this.ifa.setVisibility(0);
                } else if (str.equals(IdentityReviewActivity.this.ieS)) {
                    aVar.drawImageTo(IdentityReviewActivity.this.ieZ);
                    IdentityReviewActivity.this.ifb.setVisibility(0);
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
                            IdentityReviewActivity.this.ifd = 2;
                        } else if (((CommitCardInfoReqMsg) extra).card_type == 2) {
                            IdentityReviewActivity.this.ife = 2;
                        }
                        if (IdentityReviewActivity.this.ifd < 2 || IdentityReviewActivity.this.ife < 2) {
                            if (IdentityReviewActivity.this.ife == 1) {
                                if (IdentityReviewActivity.this.idi == null) {
                                    if (IdentityReviewActivity.this.ifc != null) {
                                        g.dismissDialog(IdentityReviewActivity.this.ifc, IdentityReviewActivity.this);
                                        return;
                                    }
                                    return;
                                }
                                new a(IdentityReviewActivity.this.ieS, 2, IdentityReviewActivity.this.idi).execute(new Void[0]);
                            }
                        } else if (IdentityReviewActivity.this.ieQ != null) {
                            IdentityReviewActivity.this.ieQ.fV(IdentityReviewActivity.this.forumId);
                        } else if (IdentityReviewActivity.this.ifc != null) {
                            g.dismissDialog(IdentityReviewActivity.this.ifc, IdentityReviewActivity.this);
                        }
                    } else if (error != -100000303 || !IdentityReviewActivity.this.needRetry) {
                        if (IdentityReviewActivity.this.ifc != null && IdentityReviewActivity.this.ifc.isShowing()) {
                            g.dismissDialog(IdentityReviewActivity.this.ifc, IdentityReviewActivity.this);
                        }
                        l.showLongToast(TbadkCoreApplication.getInst(), responsedMessage.getErrorString());
                        IdentityReviewActivity.this.ifd = 1;
                        IdentityReviewActivity.this.ife = 1;
                    } else {
                        IdentityReviewActivity.this.ifd = 1;
                        IdentityReviewActivity.this.ife = 1;
                        if (IdentityReviewActivity.this.idi != null) {
                            IdentityReviewActivity.this.needRetry = false;
                            new a(IdentityReviewActivity.this.ieR, 1, IdentityReviewActivity.this.idi).execute(new Void[0]);
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
                if (IdentityReviewActivity.this.ifc != null && IdentityReviewActivity.this.ifc.isShowing()) {
                    g.dismissDialog(IdentityReviewActivity.this.ifc, IdentityReviewActivity.this);
                }
                String str = "https://tieba.baidu.com/mo/q/newmanagerapplyresult?passIDCert=1&nomenu=1&forum_id=" + IdentityReviewActivity.this.forumId;
                if (error == 0) {
                    bf.bua().b(IdentityReviewActivity.this.getPageContext(), new String[]{str});
                    IdentityReviewActivity.this.setResult(-1);
                    IdentityReviewActivity.this.finish();
                    return;
                }
                l.showLongToast(TbadkCoreApplication.getInst(), httpResponsedMessage.getErrorString());
                IdentityReviewActivity.this.ifd = 1;
                IdentityReviewActivity.this.ife = 1;
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.identity_review_activity);
        this.forumId = getIntent().getLongExtra("fid", 0L);
        this.idi = new com.baidu.tieba.barselect.data.c(getPageContext());
        this.ieQ = new com.baidu.tieba.barselect.data.b(getPageContext());
        this.ieR = new File(TbadkCoreApplication.getInst().getFilesDir(), "positive.jpg").getAbsolutePath();
        this.ieS = new File(TbadkCoreApplication.getInst().getFilesDir(), "negative.jpg").getAbsolutePath();
        this.ieT = findViewById(R.id.id_card_view);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.id_review_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(getResources().getString(R.string.bar_manager_apply));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.ieU = (TextView) findViewById(R.id.bottom_next_button);
        this.ieU.setEnabled(false);
        this.ieV = (TextView) findViewById(R.id.identity_view_title);
        this.ieW = (TextView) findViewById(R.id.positive_card_coloct_tip);
        this.ieX = (TextView) findViewById(R.id.negative_card_coloct_tip);
        this.ieY = (TbImageView) findViewById(R.id.identity_card_positive);
        this.ieZ = (TbImageView) findViewById(R.id.identity_card_negative);
        this.ifa = (TextView) findViewById(R.id.identity_card_positive_logo);
        this.ifb = (TextView) findViewById(R.id.identity_card_negative_logo);
        MessageManager.getInstance().registerListener(this.ewJ);
        MessageManager.getInstance().registerListener(this.mHttpMessageListener);
        this.ieY.setOnClickListener(this.foP);
        this.ieZ.setOnClickListener(this.foP);
        this.ieU.setOnClickListener(this.foP);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        }
        ap.setViewTextColor(this.ieU, R.color.CAM_X0101, 1, i);
        ap.setBackgroundResource(this.ieU, R.drawable.bg_id_card_button, i);
        ap.setViewTextColor(this.ieV, R.color.CAM_X0105, 1, i);
        ap.setViewTextColor(this.ieW, R.color.CAM_X0109, 1, i);
        ap.setViewTextColor(this.ieX, R.color.CAM_X0109, 1, i);
        int dimens = l.getDimens(this, R.dimen.tbds10);
        ap.setViewTextColor(this.ifa, R.color.CAM_X0101, 1, i);
        ap.setViewTextColor(this.ifb, R.color.CAM_X0101, 1, i);
        ap.c(this.ifa, dimens, R.color.cp_cont_b_alpha42, R.color.cp_cont_b_alpha42, i);
        ap.c(this.ifb, dimens, R.color.cp_cont_b_alpha42, R.color.cp_cont_b_alpha42, i);
        if (this.ifd < 1) {
            ap.setImageResource(this.ieY, R.drawable.pic_id_front, i);
        }
        if (this.ife < 1) {
            ap.setImageResource(this.ieZ, R.drawable.pic_id_back, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if (i == 101) {
                com.baidu.adp.lib.e.c.mS().a(this.ieR, 32, this.fyI, getUniqueId());
                this.ifd = 1;
            } else if (i == 102) {
                com.baidu.adp.lib.e.c.mS().a(this.ieS, 32, this.fyI, getUniqueId());
                this.ife = 1;
            }
            if (this.ieU != null) {
                if (this.ife >= 1 && this.ifd >= 1) {
                    this.ieU.setEnabled(true);
                } else {
                    this.ieU.setEnabled(false);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.ewJ);
        MessageManager.getInstance().unRegisterListener(this.mHttpMessageListener);
        if (this.ifc != null && this.ifc.isShowing()) {
            g.dismissDialog(this.ifc, this);
        }
        super.onDestroy();
    }
}
