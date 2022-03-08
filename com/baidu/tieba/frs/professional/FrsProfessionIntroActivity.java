package com.baidu.tieba.frs.professional;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsProfessionIntroActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.util.DeviceInfoUtil;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.widget.LinearGradientView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class FrsProfessionIntroActivity extends BaseActivity<FrsProfessionIntroActivity> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String PROFESSION_THREAD_ID = "5977226324";
    public transient /* synthetic */ FieldHolder $fh;
    public View mBack;
    public TbImageView mBackgroundContent;
    public View mBottomView;
    public View mContainer;
    public View mFirstIndex;
    public View mFirstIntro;
    public View mFirstTitle;
    public TextView mGoPublishButton;
    public View mGotItButton;
    public LinearGradientView mGradientView;
    public RelativeLayout mHeaderContainer;
    public NavigationBar mNavigationBar;
    public View mProfessionDesc;
    public View mSecondIndex;
    public View mSecondIntro;
    public View mSecondTitle;
    public View mTopCorner;
    public View.OnClickListener onClickListener;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsProfessionIntroActivity f42338e;

        public a(FrsProfessionIntroActivity frsProfessionIntroActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsProfessionIntroActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f42338e = frsProfessionIntroActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view != this.f42338e.mBack) {
                    if (view != this.f42338e.mGoPublishButton) {
                        if (view == this.f42338e.mGotItButton) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.f42338e.getActivity()).createNormalCfg(FrsProfessionIntroActivity.PROFESSION_THREAD_ID, null, "frs")));
                            Intent intent = new Intent();
                            intent.putExtra(FrsProfessionIntroActivityConfig.KEY_RESULT, -1);
                            this.f42338e.setResult(-1, intent);
                            this.f42338e.finish();
                            return;
                        }
                        return;
                    }
                    Intent intent2 = new Intent();
                    intent2.putExtra(FrsProfessionIntroActivityConfig.KEY_RESULT, 1);
                    this.f42338e.setResult(-1, intent2);
                    this.f42338e.finish();
                    return;
                }
                Intent intent3 = new Intent();
                intent3.putExtra(FrsProfessionIntroActivityConfig.KEY_RESULT, -1);
                this.f42338e.setResult(-1, intent3);
                this.f42338e.finish();
            }
        }
    }

    public FrsProfessionIntroActivity() {
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
        this.onClickListener = new a(this);
    }

    private void handleNotchScreen() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            boolean z = true;
            if (!DeviceInfoUtil.isMiNotchDevice() && !DeviceInfoUtil.isHonor30NotchDevice() && !DeviceInfoUtil.isHuaWeiP40() && !DeviceInfoUtil.isHuaWeiP40Pro()) {
                z = false;
            }
            if (z) {
                int f2 = n.f(TbadkCoreApplication.getInst(), R.dimen.tbds690);
                ViewGroup.LayoutParams layoutParams = this.mHeaderContainer.getLayoutParams();
                if (layoutParams instanceof LinearLayout.LayoutParams) {
                    ((LinearLayout.LayoutParams) layoutParams).height = f2;
                    ViewGroup.LayoutParams layoutParams2 = this.mGradientView.getLayoutParams();
                    if (layoutParams2 instanceof RelativeLayout.LayoutParams) {
                        ((RelativeLayout.LayoutParams) layoutParams2).height = f2;
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            super.onChangeSkinType(i2);
            SkinManager.setViewTextColor(this.mNavigationBar.mCenterText, (int) R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.mProfessionDesc, (int) R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.mFirstIndex, (int) R.color.CAM_X0111);
            SkinManager.setViewTextColor(this.mFirstTitle, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.mFirstIntro, (int) R.color.CAM_X0106);
            SkinManager.setViewTextColor(this.mSecondIndex, (int) R.color.CAM_X0111);
            SkinManager.setViewTextColor(this.mSecondTitle, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.mSecondIntro, (int) R.color.CAM_X0106);
            SkinManager.setViewTextColor(this.mGotItButton, (int) R.color.CAM_X0101);
            SkinManager.setBackgroundColor(this.mContainer, R.color.CAM_X0201);
            SkinManager.setBackgroundResource(this.mTopCorner, R.drawable.bg_top_corner_white);
            SkinManager.setImageResource(this.mNavigationBar.getBackImageView(), R.drawable.btn_sml_back_selector_s);
            SkinManager.setBackgroundResource(this.mGotItButton, R.drawable.frs_profession_button_bg);
            SkinManager.setViewTextColor(this.mGoPublishButton, (int) R.color.CAM_X0302);
            SkinManager.setBackgroundColor(this.mBottomView, R.color.CAM_X0201);
            this.mGradientView.changeSkinType(i2);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.layout_frs_profession);
            this.mHeaderContainer = (RelativeLayout) findViewById(R.id.profession_header_container);
            this.mNavigationBar = (NavigationBar) findViewById(R.id.profession_intro_navigation_bar);
            this.mGradientView = (LinearGradientView) findViewById(R.id.profession_intro_background);
            this.mGoPublishButton = (TextView) findViewById(R.id.profession_intro_go_publish);
            this.mGotItButton = findViewById(R.id.profession_intro_got_it);
            this.mBottomView = findViewById(R.id.bottom_view);
            this.mProfessionDesc = findViewById(R.id.profession_intro_desc);
            this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.onClickListener);
            this.mNavigationBar.setCenterTextTitle(getString(R.string.profession_intro_title));
            TbImageView tbImageView = (TbImageView) findViewById(R.id.profession_intro_content);
            this.mBackgroundContent = tbImageView;
            tbImageView.setDefaultBgResource(R.color.transparent);
            this.mBackgroundContent.setDefaultResource(R.drawable.pic_frs_head_default);
            this.mContainer = findViewById(R.id.profession_intro_container);
            this.mTopCorner = findViewById(R.id.profession_intro_top_corner);
            this.mFirstIndex = findViewById(R.id.profession_intro_first_index);
            this.mFirstIntro = findViewById(R.id.profession_intro_first_intro);
            this.mFirstTitle = findViewById(R.id.profession_intro_first_title);
            this.mSecondIndex = findViewById(R.id.profession_intro_second_index);
            this.mSecondIntro = findViewById(R.id.profession_intro_second_intro);
            this.mSecondTitle = findViewById(R.id.profession_intro_second_title);
            this.mGoPublishButton.setEnabled(true);
            this.mGoPublishButton.setOnClickListener(this.onClickListener);
            this.mGotItButton.setOnClickListener(this.onClickListener);
            handleNotchScreen();
            String stringExtra = getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_PATTEN_BACKGROUND);
            this.mGradientView.setGradientColor(getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_DAY_LIGHT_COLOR), getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_DAY_DARK_COLOR), getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_NIGHT_LIGHT_COLOR), getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_NIGHT_DARK_COLOR), getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_DARK_LIGHT_COLOR), getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_DARK_DARK_COLOR));
            this.mBackgroundContent.startLoad(stringExtra, 10, false);
        }
    }
}
