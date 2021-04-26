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
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.CameraActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.barselect.data.CommitCardInfoReqMsg;
import d.a.c.e.m.g;
import d.a.c.e.p.l;
import java.io.File;
/* loaded from: classes4.dex */
public class IdentityReviewActivity extends BaseActivity {
    public static final String FINISH_ID_CARD_PAGE = "https://tieba.baidu.com/mo/q/newmanagerapplyresult?passIDCert=1";
    public static final String NEGATIVE_IMAGE_NAME = "negative.jpg";
    public static final String POSITIVE_IMAGE_NAME = "positive.jpg";
    public static final int REQUEST_CODE_NEGATIVE_ID_CARD = 102;
    public static final int REQUEST_CODE_POSITIVE_ID_CARD = 101;
    public static final int STATUS_IMG_READY = 1;
    public static final int STATUS_NONE = 0;
    public static final int STATUS_UPLOAD_FINISHED = 2;
    public long forumId;
    public View idCardView;
    public d.a.j0.v.b.b mCheckModel;
    public TextView mIdCardViewTitle;
    public d.a.j0.v.b.c mModel;
    public NavigationBar mNavigationBar;
    public TbImageView mNegativeIdCard;
    public TextView mNegativeIdCardLogo;
    public TextView mNegativeIdCardTip;
    public TextView mNextButon;
    public TbImageView mPositiveIdCard;
    public TextView mPositiveIdCardLogo;
    public TextView mPositiveIdCardTip;
    public d.a.j0.v.f.a mToastDialog;
    public String negativeImagePath;
    public String positiveImgePath;
    public boolean needRetry = false;
    public int positiveStatus = 0;
    public int negativeStatus = 0;
    public View.OnClickListener onClickListener = new a();
    public d.a.c.e.l.c<d.a.c.j.d.a> mCallBack = new b();
    public d.a.c.c.g.a mNetMessageListener = new c(CmdConfigHttp.CMD_COMMIT_CARD_INFO, 309643);
    public HttpMessageListener mHttpMessageListener = new d(CmdConfigHttp.CMD_CHECK_CARD_INFO);

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == R.id.identity_card_positive) {
                IdentityReviewActivity identityReviewActivity = IdentityReviewActivity.this;
                MessageManager.getInstance().sendMessage(new CustomMessage(2921412, new CameraActivityConfig(identityReviewActivity, identityReviewActivity.positiveImgePath, "IDCardFront", 101)));
            } else if (view.getId() == R.id.identity_card_negative) {
                IdentityReviewActivity identityReviewActivity2 = IdentityReviewActivity.this;
                MessageManager.getInstance().sendMessage(new CustomMessage(2921412, new CameraActivityConfig(identityReviewActivity2, identityReviewActivity2.negativeImagePath, "IDCardBack", 102)));
            } else if (view.getId() == R.id.bottom_next_button) {
                IdentityReviewActivity identityReviewActivity3 = IdentityReviewActivity.this;
                new d.a.j0.v.c.a(identityReviewActivity3.positiveImgePath, 1, identityReviewActivity3.mModel).execute(new Void[0]);
                IdentityReviewActivity.this.needRetry = true;
                IdentityReviewActivity.this.mToastDialog = new d.a.j0.v.f.a(IdentityReviewActivity.this);
                IdentityReviewActivity.this.mToastDialog.setCancelable(true);
                IdentityReviewActivity.this.mToastDialog.setCanceledOnTouchOutside(false);
                IdentityReviewActivity.this.mToastDialog.setMessage(TbadkCoreApplication.getInst().getString(R.string.check_id_card));
                g.i(IdentityReviewActivity.this.mToastDialog, IdentityReviewActivity.this);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends d.a.c.e.l.c<d.a.c.j.d.a> {
        public b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.l.c
        public void onLoaded(d.a.c.j.d.a aVar, String str, int i2) {
            super.onLoaded((b) aVar, str, i2);
            if (str != null && aVar != null) {
                if (str.equals(IdentityReviewActivity.this.positiveImgePath)) {
                    aVar.h(IdentityReviewActivity.this.mPositiveIdCard);
                    IdentityReviewActivity.this.mPositiveIdCardLogo.setVisibility(0);
                } else if (str.equals(IdentityReviewActivity.this.negativeImagePath)) {
                    aVar.h(IdentityReviewActivity.this.mNegativeIdCard);
                    IdentityReviewActivity.this.mNegativeIdCardLogo.setVisibility(0);
                }
            }
            if (str != null) {
                d.a.i0.a0.c k = d.a.i0.a0.c.k();
                k.h(str + 32);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends d.a.c.c.g.a {
        public c(int i2, int i3) {
            super(i2, i3);
        }

        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage == null || responsedMessage.getOrginalMessage() == null) {
                return;
            }
            int error = responsedMessage.getError();
            Object extra = responsedMessage.getOrginalMessage().getExtra();
            if (extra instanceof CommitCardInfoReqMsg) {
                if (error != 0) {
                    if (error != -100000303 || !IdentityReviewActivity.this.needRetry) {
                        if (IdentityReviewActivity.this.mToastDialog != null && IdentityReviewActivity.this.mToastDialog.isShowing()) {
                            g.a(IdentityReviewActivity.this.mToastDialog, IdentityReviewActivity.this);
                        }
                        l.J(TbadkCoreApplication.getInst(), responsedMessage.getErrorString());
                        IdentityReviewActivity.this.positiveStatus = 1;
                        IdentityReviewActivity.this.negativeStatus = 1;
                        return;
                    }
                    IdentityReviewActivity.this.positiveStatus = 1;
                    IdentityReviewActivity.this.negativeStatus = 1;
                    if (IdentityReviewActivity.this.mModel != null) {
                        IdentityReviewActivity.this.needRetry = false;
                        IdentityReviewActivity identityReviewActivity = IdentityReviewActivity.this;
                        new d.a.j0.v.c.a(identityReviewActivity.positiveImgePath, 1, identityReviewActivity.mModel).execute(new Void[0]);
                        return;
                    }
                    return;
                }
                int i2 = ((CommitCardInfoReqMsg) extra).card_type;
                if (i2 == 1) {
                    IdentityReviewActivity.this.positiveStatus = 2;
                } else if (i2 == 2) {
                    IdentityReviewActivity.this.negativeStatus = 2;
                }
                if (IdentityReviewActivity.this.positiveStatus < 2 || IdentityReviewActivity.this.negativeStatus < 2) {
                    if (IdentityReviewActivity.this.negativeStatus == 1) {
                        if (IdentityReviewActivity.this.mModel == null) {
                            if (IdentityReviewActivity.this.mToastDialog != null) {
                                g.a(IdentityReviewActivity.this.mToastDialog, IdentityReviewActivity.this);
                                return;
                            }
                            return;
                        }
                        IdentityReviewActivity identityReviewActivity2 = IdentityReviewActivity.this;
                        new d.a.j0.v.c.a(identityReviewActivity2.negativeImagePath, 2, identityReviewActivity2.mModel).execute(new Void[0]);
                    }
                } else if (IdentityReviewActivity.this.mCheckModel != null) {
                    IdentityReviewActivity.this.mCheckModel.a(IdentityReviewActivity.this.forumId);
                } else if (IdentityReviewActivity.this.mToastDialog != null) {
                    g.a(IdentityReviewActivity.this.mToastDialog, IdentityReviewActivity.this);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d extends HttpMessageListener {
        public d(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage == null || httpResponsedMessage.getOrginalMessage() == null) {
                return;
            }
            int error = httpResponsedMessage.getError();
            if (IdentityReviewActivity.this.mToastDialog != null && IdentityReviewActivity.this.mToastDialog.isShowing()) {
                g.a(IdentityReviewActivity.this.mToastDialog, IdentityReviewActivity.this);
            }
            String str = "https://tieba.baidu.com/mo/q/newmanagerapplyresult?passIDCert=1&nomenu=1&forum_id=" + IdentityReviewActivity.this.forumId;
            if (error == 0) {
                UrlManager.getInstance().dealOneLink(IdentityReviewActivity.this.getPageContext(), new String[]{str});
                IdentityReviewActivity.this.setResult(-1);
                IdentityReviewActivity.this.finish();
                return;
            }
            l.J(TbadkCoreApplication.getInst(), httpResponsedMessage.getErrorString());
            IdentityReviewActivity.this.positiveStatus = 1;
            IdentityReviewActivity.this.negativeStatus = 1;
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i3 == -1) {
            if (i2 == 101) {
                d.a.c.e.l.d.h().m(this.positiveImgePath, 32, this.mCallBack, getUniqueId());
                this.positiveStatus = 1;
            } else if (i2 == 102) {
                d.a.c.e.l.d.h().m(this.negativeImagePath, 32, this.mCallBack, getUniqueId());
                this.negativeStatus = 1;
            }
            TextView textView = this.mNextButon;
            if (textView != null) {
                if (this.negativeStatus >= 1 && this.positiveStatus >= 1) {
                    textView.setEnabled(true);
                } else {
                    this.mNextButon.setEnabled(false);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        NavigationBar navigationBar = this.mNavigationBar;
        if (navigationBar != null) {
            navigationBar.onChangeSkinType(getPageContext(), i2);
        }
        SkinManager.setViewTextColor(this.mNextButon, R.color.CAM_X0101, 1, i2);
        SkinManager.setBackgroundResource(this.mNextButon, R.drawable.bg_id_card_button, i2);
        SkinManager.setViewTextColor(this.mIdCardViewTitle, R.color.CAM_X0105, 1, i2);
        SkinManager.setViewTextColor(this.mPositiveIdCardTip, R.color.CAM_X0109, 1, i2);
        SkinManager.setViewTextColor(this.mNegativeIdCardTip, R.color.CAM_X0109, 1, i2);
        int g2 = l.g(this, R.dimen.tbds10);
        SkinManager.setViewTextColor(this.mPositiveIdCardLogo, R.color.CAM_X0101, 1, i2);
        SkinManager.setViewTextColor(this.mNegativeIdCardLogo, R.color.CAM_X0101, 1, i2);
        TextView textView = this.mPositiveIdCardLogo;
        int i3 = R.color.cp_cont_b_alpha42;
        SkinManager.setBackgroundShapeDrawable(textView, g2, i3, i3, i2);
        TextView textView2 = this.mNegativeIdCardLogo;
        int i4 = R.color.cp_cont_b_alpha42;
        SkinManager.setBackgroundShapeDrawable(textView2, g2, i4, i4, i2);
        if (this.positiveStatus < 1) {
            SkinManager.setImageResource(this.mPositiveIdCard, R.drawable.pic_id_front, i2);
        }
        if (this.negativeStatus < 1) {
            SkinManager.setImageResource(this.mNegativeIdCard, R.drawable.pic_id_back, i2);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.identity_review_activity);
        this.forumId = getIntent().getLongExtra("fid", 0L);
        this.mModel = new d.a.j0.v.b.c(getPageContext());
        this.mCheckModel = new d.a.j0.v.b.b(getPageContext());
        this.positiveImgePath = new File(TbadkCoreApplication.getInst().getFilesDir(), POSITIVE_IMAGE_NAME).getAbsolutePath();
        this.negativeImagePath = new File(TbadkCoreApplication.getInst().getFilesDir(), NEGATIVE_IMAGE_NAME).getAbsolutePath();
        this.idCardView = findViewById(R.id.id_card_view);
        NavigationBar navigationBar = (NavigationBar) findViewById(R.id.id_review_navigation_bar);
        this.mNavigationBar = navigationBar;
        navigationBar.setCenterTextTitle(getResources().getString(R.string.bar_manager_apply));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        TextView textView = (TextView) findViewById(R.id.bottom_next_button);
        this.mNextButon = textView;
        textView.setEnabled(false);
        this.mIdCardViewTitle = (TextView) findViewById(R.id.identity_view_title);
        this.mPositiveIdCardTip = (TextView) findViewById(R.id.positive_card_coloct_tip);
        this.mNegativeIdCardTip = (TextView) findViewById(R.id.negative_card_coloct_tip);
        this.mPositiveIdCard = (TbImageView) findViewById(R.id.identity_card_positive);
        this.mNegativeIdCard = (TbImageView) findViewById(R.id.identity_card_negative);
        this.mPositiveIdCardLogo = (TextView) findViewById(R.id.identity_card_positive_logo);
        this.mNegativeIdCardLogo = (TextView) findViewById(R.id.identity_card_negative_logo);
        MessageManager.getInstance().registerListener(this.mNetMessageListener);
        MessageManager.getInstance().registerListener(this.mHttpMessageListener);
        this.mPositiveIdCard.setOnClickListener(this.onClickListener);
        this.mNegativeIdCard.setOnClickListener(this.onClickListener);
        this.mNextButon.setOnClickListener(this.onClickListener);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.mNetMessageListener);
        MessageManager.getInstance().unRegisterListener(this.mHttpMessageListener);
        d.a.j0.v.f.a aVar = this.mToastDialog;
        if (aVar != null && aVar.isShowing()) {
            g.a(this.mToastDialog, this);
        }
        super.onDestroy();
    }
}
