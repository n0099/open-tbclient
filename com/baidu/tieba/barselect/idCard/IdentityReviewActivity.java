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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.fo;
import com.repackage.gw5;
import com.repackage.h35;
import com.repackage.hg;
import com.repackage.ig;
import com.repackage.oi;
import com.repackage.rg;
import com.repackage.sv5;
import com.repackage.tv5;
import com.repackage.wa;
import com.repackage.xv5;
import java.io.File;
/* loaded from: classes3.dex */
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
    public hg<fo> mCallBack;
    public sv5 mCheckModel;
    public HttpMessageListener mHttpMessageListener;
    public TextView mIdCardViewTitle;
    public tv5 mModel;
    public NavigationBar mNavigationBar;
    public TbImageView mNegativeIdCard;
    public TextView mNegativeIdCardLogo;
    public TextView mNegativeIdCardTip;
    public wa mNetMessageListener;
    public TextView mNextButon;
    public TbImageView mPositiveIdCard;
    public TextView mPositiveIdCardLogo;
    public TextView mPositiveIdCardTip;
    public gw5 mToastDialog;
    public boolean needRetry;
    public String negativeImagePath;
    public int negativeStatus;
    public View.OnClickListener onClickListener;
    public String positiveImgePath;
    public int positiveStatus;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ IdentityReviewActivity a;

        public a(IdentityReviewActivity identityReviewActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {identityReviewActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = identityReviewActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (view2.getId() == R.id.obfuscated_res_0x7f090e51) {
                    IdentityReviewActivity identityReviewActivity = this.a;
                    MessageManager.getInstance().sendMessage(new CustomMessage(2921412, new CameraActivityConfig(identityReviewActivity, identityReviewActivity.positiveImgePath, "IDCardFront", 101)));
                } else if (view2.getId() == R.id.obfuscated_res_0x7f090e4f) {
                    IdentityReviewActivity identityReviewActivity2 = this.a;
                    MessageManager.getInstance().sendMessage(new CustomMessage(2921412, new CameraActivityConfig(identityReviewActivity2, identityReviewActivity2.negativeImagePath, "IDCardBack", 102)));
                } else if (view2.getId() == R.id.obfuscated_res_0x7f0903da) {
                    IdentityReviewActivity identityReviewActivity3 = this.a;
                    new xv5(identityReviewActivity3.positiveImgePath, 1, identityReviewActivity3.mModel).execute(new Void[0]);
                    this.a.needRetry = true;
                    this.a.mToastDialog = new gw5(this.a);
                    this.a.mToastDialog.setCancelable(true);
                    this.a.mToastDialog.setCanceledOnTouchOutside(false);
                    this.a.mToastDialog.setMessage(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f03ad));
                    rg.i(this.a.mToastDialog, this.a);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends hg<fo> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ IdentityReviewActivity a;

        public b(IdentityReviewActivity identityReviewActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {identityReviewActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = identityReviewActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.hg
        public void onLoaded(fo foVar, String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, foVar, str, i) == null) {
                super.onLoaded((b) foVar, str, i);
                if (str != null && foVar != null) {
                    if (str.equals(this.a.positiveImgePath)) {
                        foVar.h(this.a.mPositiveIdCard);
                        this.a.mPositiveIdCardLogo.setVisibility(0);
                    } else if (str.equals(this.a.negativeImagePath)) {
                        foVar.h(this.a.mNegativeIdCard);
                        this.a.mNegativeIdCardLogo.setVisibility(0);
                    }
                }
                if (str != null) {
                    h35 k = h35.k();
                    k.h(str + 32);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c extends wa {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ IdentityReviewActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(IdentityReviewActivity identityReviewActivity, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {identityReviewActivity, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = identityReviewActivity;
        }

        @Override // com.repackage.wa
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || responsedMessage == null || responsedMessage.getOrginalMessage() == null) {
                return;
            }
            int error = responsedMessage.getError();
            Object extra = responsedMessage.getOrginalMessage().getExtra();
            if (extra instanceof CommitCardInfoReqMsg) {
                if (error != 0) {
                    if (error != -100000303 || !this.a.needRetry) {
                        if (this.a.mToastDialog != null && this.a.mToastDialog.isShowing()) {
                            rg.a(this.a.mToastDialog, this.a);
                        }
                        oi.K(TbadkCoreApplication.getInst(), responsedMessage.getErrorString());
                        this.a.positiveStatus = 1;
                        this.a.negativeStatus = 1;
                        return;
                    }
                    this.a.positiveStatus = 1;
                    this.a.negativeStatus = 1;
                    if (this.a.mModel != null) {
                        this.a.needRetry = false;
                        IdentityReviewActivity identityReviewActivity = this.a;
                        new xv5(identityReviewActivity.positiveImgePath, 1, identityReviewActivity.mModel).execute(new Void[0]);
                        return;
                    }
                    return;
                }
                int i = ((CommitCardInfoReqMsg) extra).card_type;
                if (i == 1) {
                    this.a.positiveStatus = 2;
                } else if (i == 2) {
                    this.a.negativeStatus = 2;
                }
                if (this.a.positiveStatus < 2 || this.a.negativeStatus < 2) {
                    if (this.a.negativeStatus == 1) {
                        if (this.a.mModel == null) {
                            if (this.a.mToastDialog != null) {
                                rg.a(this.a.mToastDialog, this.a);
                                return;
                            }
                            return;
                        }
                        IdentityReviewActivity identityReviewActivity2 = this.a;
                        new xv5(identityReviewActivity2.negativeImagePath, 2, identityReviewActivity2.mModel).execute(new Void[0]);
                    }
                } else if (this.a.mCheckModel != null) {
                    this.a.mCheckModel.a(this.a.forumId);
                } else if (this.a.mToastDialog != null) {
                    rg.a(this.a.mToastDialog, this.a);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ IdentityReviewActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(IdentityReviewActivity identityReviewActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {identityReviewActivity, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = identityReviewActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) || httpResponsedMessage == null || httpResponsedMessage.getOrginalMessage() == null) {
                return;
            }
            int error = httpResponsedMessage.getError();
            if (this.a.mToastDialog != null && this.a.mToastDialog.isShowing()) {
                rg.a(this.a.mToastDialog, this.a);
            }
            String str = "https://tieba.baidu.com/mo/q/newmanagerapplyresult?passIDCert=1&nomenu=1&forum_id=" + this.a.forumId;
            if (error == 0) {
                UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{str});
                this.a.setResult(-1);
                this.a.finish();
                return;
            }
            oi.K(TbadkCoreApplication.getInst(), httpResponsedMessage.getErrorString());
            this.a.positiveStatus = 1;
            this.a.negativeStatus = 1;
        }
    }

    public IdentityReviewActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
    public void onActivityResult(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048576, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
            if (i2 == -1) {
                if (i == 101) {
                    ig.h().m(this.positiveImgePath, 32, this.mCallBack, getUniqueId());
                    this.positiveStatus = 1;
                } else if (i == 102) {
                    ig.h().m(this.negativeImagePath, 32, this.mCallBack, getUniqueId());
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
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            super.onChangeSkinType(i);
            NavigationBar navigationBar = this.mNavigationBar;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(getPageContext(), i);
            }
            SkinManager.setViewTextColor(this.mNextButon, R.color.CAM_X0101, 1, i);
            SkinManager.setBackgroundResource(this.mNextButon, R.drawable.bg_id_card_button, i);
            SkinManager.setViewTextColor(this.mIdCardViewTitle, R.color.CAM_X0105, 1, i);
            SkinManager.setViewTextColor(this.mPositiveIdCardTip, R.color.CAM_X0109, 1, i);
            SkinManager.setViewTextColor(this.mNegativeIdCardTip, R.color.CAM_X0109, 1, i);
            int f = oi.f(this, R.dimen.tbds10);
            SkinManager.setViewTextColor(this.mPositiveIdCardLogo, R.color.CAM_X0101, 1, i);
            SkinManager.setViewTextColor(this.mNegativeIdCardLogo, R.color.CAM_X0101, 1, i);
            SkinManager.setBackgroundShapeDrawable(this.mPositiveIdCardLogo, f, R.color.cp_cont_b_alpha42, R.color.cp_cont_b_alpha42, i);
            SkinManager.setBackgroundShapeDrawable(this.mNegativeIdCardLogo, f, R.color.cp_cont_b_alpha42, R.color.cp_cont_b_alpha42, i);
            if (this.positiveStatus < 1) {
                SkinManager.setImageResource(this.mPositiveIdCard, R.drawable.pic_id_front, i);
            }
            if (this.negativeStatus < 1) {
                SkinManager.setImageResource(this.mNegativeIdCard, R.drawable.pic_id_back, i);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d03c5);
            this.forumId = getIntent().getLongExtra("fid", 0L);
            this.mModel = new tv5(getPageContext());
            this.mCheckModel = new sv5(getPageContext());
            this.positiveImgePath = new File(TbadkCoreApplication.getInst().getFilesDir(), POSITIVE_IMAGE_NAME).getAbsolutePath();
            this.negativeImagePath = new File(TbadkCoreApplication.getInst().getFilesDir(), NEGATIVE_IMAGE_NAME).getAbsolutePath();
            this.idCardView = findViewById(R.id.obfuscated_res_0x7f090e23);
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.obfuscated_res_0x7f090e3c);
            this.mNavigationBar = navigationBar;
            navigationBar.setCenterTextTitle(getResources().getString(R.string.obfuscated_res_0x7f0f02d5));
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            TextView textView = (TextView) findViewById(R.id.obfuscated_res_0x7f0903da);
            this.mNextButon = textView;
            textView.setEnabled(false);
            this.mIdCardViewTitle = (TextView) findViewById(R.id.obfuscated_res_0x7f090e54);
            this.mPositiveIdCardTip = (TextView) findViewById(R.id.obfuscated_res_0x7f09189d);
            this.mNegativeIdCardTip = (TextView) findViewById(R.id.obfuscated_res_0x7f091531);
            this.mPositiveIdCard = (TbImageView) findViewById(R.id.obfuscated_res_0x7f090e51);
            this.mNegativeIdCard = (TbImageView) findViewById(R.id.obfuscated_res_0x7f090e4f);
            this.mPositiveIdCardLogo = (TextView) findViewById(R.id.obfuscated_res_0x7f090e52);
            this.mNegativeIdCardLogo = (TextView) findViewById(R.id.obfuscated_res_0x7f090e50);
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
            gw5 gw5Var = this.mToastDialog;
            if (gw5Var != null && gw5Var.isShowing()) {
                rg.a(this.mToastDialog, this);
            }
            super.onDestroy();
        }
    }
}
