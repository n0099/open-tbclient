package com.baidu.tieba.barselect.idCard;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import c.a.e.e.m.g;
import c.a.e.e.p.l;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
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
import com.baidu.tieba.barselect.view.ToastDialog;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes7.dex */
public class IdentityReviewActivity extends BaseActivity {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String FINISH_ID_CARD_PAGE = "https://tieba.baidu.com/mo/q/newmanagerapplyresult?passIDCert=1";
    public static final String NEGATIVE_IMAGE_NAME = "negative.jpg";
    public static final String POSITIVE_IMAGE_NAME = "positive.jpg";
    public static final int REQUEST_CODE_NEGATIVE_ID_CARD = 102;
    public static final int REQUEST_CODE_POSITIVE_ID_CARD = 101;
    public static final int STATUS_IMG_READY = 1;
    public static final int STATUS_NONE = 0;
    public static final int STATUS_UPLOAD_FINISHED = 2;
    public transient /* synthetic */ FieldHolder $fh;
    public long forumId;
    public View idCardView;
    public c.a.e.e.l.c<c.a.e.l.d.a> mCallBack;
    public c.a.r0.x.b.b mCheckModel;
    public HttpMessageListener mHttpMessageListener;
    public TextView mIdCardViewTitle;
    public c.a.r0.x.b.c mModel;
    public NavigationBar mNavigationBar;
    public TbImageView mNegativeIdCard;
    public TextView mNegativeIdCardLogo;
    public TextView mNegativeIdCardTip;
    public c.a.e.c.g.a mNetMessageListener;
    public TextView mNextButon;
    public TbImageView mPositiveIdCard;
    public TextView mPositiveIdCardLogo;
    public TextView mPositiveIdCardTip;
    public ToastDialog mToastDialog;
    public boolean needRetry;
    public String negativeImagePath;
    public int negativeStatus;
    public View.OnClickListener onClickListener;
    public String positiveImgePath;
    public int positiveStatus;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ IdentityReviewActivity f49971e;

        public a(IdentityReviewActivity identityReviewActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {identityReviewActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49971e = identityReviewActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view.getId() == R.id.identity_card_positive) {
                    IdentityReviewActivity identityReviewActivity = this.f49971e;
                    MessageManager.getInstance().sendMessage(new CustomMessage(2921412, new CameraActivityConfig(identityReviewActivity, identityReviewActivity.positiveImgePath, "IDCardFront", 101)));
                } else if (view.getId() == R.id.identity_card_negative) {
                    IdentityReviewActivity identityReviewActivity2 = this.f49971e;
                    MessageManager.getInstance().sendMessage(new CustomMessage(2921412, new CameraActivityConfig(identityReviewActivity2, identityReviewActivity2.negativeImagePath, "IDCardBack", 102)));
                } else if (view.getId() == R.id.bottom_next_button) {
                    IdentityReviewActivity identityReviewActivity3 = this.f49971e;
                    new c.a.r0.x.c.a(identityReviewActivity3.positiveImgePath, 1, identityReviewActivity3.mModel).execute(new Void[0]);
                    this.f49971e.needRetry = true;
                    this.f49971e.mToastDialog = new ToastDialog(this.f49971e);
                    this.f49971e.mToastDialog.setCancelable(true);
                    this.f49971e.mToastDialog.setCanceledOnTouchOutside(false);
                    this.f49971e.mToastDialog.setMessage(TbadkCoreApplication.getInst().getString(R.string.check_id_card));
                    g.i(this.f49971e.mToastDialog, this.f49971e);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends c.a.e.e.l.c<c.a.e.l.d.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ IdentityReviewActivity f49972a;

        public b(IdentityReviewActivity identityReviewActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {identityReviewActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49972a = identityReviewActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.e.e.l.c
        public void onLoaded(c.a.e.l.d.a aVar, String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, aVar, str, i2) == null) {
                super.onLoaded((b) aVar, str, i2);
                if (str != null && aVar != null) {
                    if (str.equals(this.f49972a.positiveImgePath)) {
                        aVar.h(this.f49972a.mPositiveIdCard);
                        this.f49972a.mPositiveIdCardLogo.setVisibility(0);
                    } else if (str.equals(this.f49972a.negativeImagePath)) {
                        aVar.h(this.f49972a.mNegativeIdCard);
                        this.f49972a.mNegativeIdCardLogo.setVisibility(0);
                    }
                }
                if (str != null) {
                    c.a.q0.c0.c k = c.a.q0.c0.c.k();
                    k.h(str + 32);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c extends c.a.e.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ IdentityReviewActivity f49973a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(IdentityReviewActivity identityReviewActivity, int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {identityReviewActivity, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49973a = identityReviewActivity;
        }

        @Override // c.a.e.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || responsedMessage == null || responsedMessage.getOrginalMessage() == null) {
                return;
            }
            int error = responsedMessage.getError();
            Object extra = responsedMessage.getOrginalMessage().getExtra();
            if (extra instanceof CommitCardInfoReqMsg) {
                if (error != 0) {
                    if (error != -100000303 || !this.f49973a.needRetry) {
                        if (this.f49973a.mToastDialog != null && this.f49973a.mToastDialog.isShowing()) {
                            g.a(this.f49973a.mToastDialog, this.f49973a);
                        }
                        l.J(TbadkCoreApplication.getInst(), responsedMessage.getErrorString());
                        this.f49973a.positiveStatus = 1;
                        this.f49973a.negativeStatus = 1;
                        return;
                    }
                    this.f49973a.positiveStatus = 1;
                    this.f49973a.negativeStatus = 1;
                    if (this.f49973a.mModel != null) {
                        this.f49973a.needRetry = false;
                        IdentityReviewActivity identityReviewActivity = this.f49973a;
                        new c.a.r0.x.c.a(identityReviewActivity.positiveImgePath, 1, identityReviewActivity.mModel).execute(new Void[0]);
                        return;
                    }
                    return;
                }
                int i2 = ((CommitCardInfoReqMsg) extra).card_type;
                if (i2 == 1) {
                    this.f49973a.positiveStatus = 2;
                } else if (i2 == 2) {
                    this.f49973a.negativeStatus = 2;
                }
                if (this.f49973a.positiveStatus < 2 || this.f49973a.negativeStatus < 2) {
                    if (this.f49973a.negativeStatus == 1) {
                        if (this.f49973a.mModel == null) {
                            if (this.f49973a.mToastDialog != null) {
                                g.a(this.f49973a.mToastDialog, this.f49973a);
                                return;
                            }
                            return;
                        }
                        IdentityReviewActivity identityReviewActivity2 = this.f49973a;
                        new c.a.r0.x.c.a(identityReviewActivity2.negativeImagePath, 2, identityReviewActivity2.mModel).execute(new Void[0]);
                    }
                } else if (this.f49973a.mCheckModel != null) {
                    this.f49973a.mCheckModel.a(this.f49973a.forumId);
                } else if (this.f49973a.mToastDialog != null) {
                    g.a(this.f49973a.mToastDialog, this.f49973a);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ IdentityReviewActivity f49974a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(IdentityReviewActivity identityReviewActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {identityReviewActivity, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49974a = identityReviewActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) || httpResponsedMessage == null || httpResponsedMessage.getOrginalMessage() == null) {
                return;
            }
            int error = httpResponsedMessage.getError();
            if (this.f49974a.mToastDialog != null && this.f49974a.mToastDialog.isShowing()) {
                g.a(this.f49974a.mToastDialog, this.f49974a);
            }
            String str = "https://tieba.baidu.com/mo/q/newmanagerapplyresult?passIDCert=1&nomenu=1&forum_id=" + this.f49974a.forumId;
            if (error == 0) {
                UrlManager.getInstance().dealOneLink(this.f49974a.getPageContext(), new String[]{str});
                this.f49974a.setResult(-1);
                this.f49974a.finish();
                return;
            }
            l.J(TbadkCoreApplication.getInst(), httpResponsedMessage.getErrorString());
            this.f49974a.positiveStatus = 1;
            this.f49974a.negativeStatus = 1;
        }
    }

    public IdentityReviewActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.needRetry = false;
        this.positiveStatus = 0;
        this.negativeStatus = 0;
        this.onClickListener = new a(this);
        this.mCallBack = new b(this);
        this.mNetMessageListener = new c(this, CmdConfigHttp.CMD_COMMIT_CARD_INFO, 309643);
        this.mHttpMessageListener = new d(this, CmdConfigHttp.CMD_CHECK_CARD_INFO);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048576, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            if (i3 == -1) {
                if (i2 == 101) {
                    c.a.e.e.l.d.h().m(this.positiveImgePath, 32, this.mCallBack, getUniqueId());
                    this.positiveStatus = 1;
                } else if (i2 == 102) {
                    c.a.e.e.l.d.h().m(this.negativeImagePath, 32, this.mCallBack, getUniqueId());
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
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
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
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.identity_review_activity);
            this.forumId = getIntent().getLongExtra("fid", 0L);
            this.mModel = new c.a.r0.x.b.c(getPageContext());
            this.mCheckModel = new c.a.r0.x.b.b(getPageContext());
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
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.mNetMessageListener);
            MessageManager.getInstance().unRegisterListener(this.mHttpMessageListener);
            ToastDialog toastDialog = this.mToastDialog;
            if (toastDialog != null && toastDialog.isShowing()) {
                g.a(this.mToastDialog, this);
            }
            super.onDestroy();
        }
    }
}
