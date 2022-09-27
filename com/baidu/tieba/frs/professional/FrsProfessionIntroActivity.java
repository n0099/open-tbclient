package com.baidu.tieba.frs.professional;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
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
import com.baidu.tieba.ej;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class FrsProfessionIntroActivity extends BaseActivity<FrsProfessionIntroActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public NavigationBar a;
    public TextView b;
    public View c;
    public View d;
    public View e;
    public View f;
    public View g;
    public View h;
    public TbImageView i;
    public LinearGradientView j;
    public RelativeLayout k;
    public View l;
    public View m;
    public View n;
    public View o;
    public View p;
    public View q;
    public View.OnClickListener r;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsProfessionIntroActivity a;

        public a(FrsProfessionIntroActivity frsProfessionIntroActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsProfessionIntroActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = frsProfessionIntroActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (view2 != this.a.e) {
                    if (view2 != this.a.b) {
                        if (view2 == this.a.c) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.a.getActivity()).createNormalCfg("5977226324", null, "frs")));
                            Intent intent = new Intent();
                            intent.putExtra(FrsProfessionIntroActivityConfig.KEY_RESULT, -1);
                            this.a.setResult(-1, intent);
                            this.a.finish();
                            return;
                        }
                        return;
                    }
                    Intent intent2 = new Intent();
                    intent2.putExtra(FrsProfessionIntroActivityConfig.KEY_RESULT, 1);
                    this.a.setResult(-1, intent2);
                    this.a.finish();
                    return;
                }
                Intent intent3 = new Intent();
                intent3.putExtra(FrsProfessionIntroActivityConfig.KEY_RESULT, -1);
                this.a.setResult(-1, intent3);
                this.a.finish();
            }
        }
    }

    public FrsProfessionIntroActivity() {
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
        this.r = new a(this);
    }

    public final void C1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            boolean z = true;
            if (!DeviceInfoUtil.isMiNotchDevice() && !DeviceInfoUtil.isHonor30NotchDevice() && !DeviceInfoUtil.isHuaWeiP40() && !DeviceInfoUtil.isHuaWeiP40Pro()) {
                z = false;
            }
            if (z) {
                int f = ej.f(TbadkCoreApplication.getInst(), R.dimen.tbds690);
                ViewGroup.LayoutParams layoutParams = this.k.getLayoutParams();
                if (layoutParams instanceof LinearLayout.LayoutParams) {
                    ((LinearLayout.LayoutParams) layoutParams).height = f;
                    ViewGroup.LayoutParams layoutParams2 = this.j.getLayoutParams();
                    if (layoutParams2 instanceof RelativeLayout.LayoutParams) {
                        ((RelativeLayout.LayoutParams) layoutParams2).height = f;
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
            SkinManager.setViewTextColor(this.a.mCenterText, (int) R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.f, (int) R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.l, (int) R.color.CAM_X0111);
            SkinManager.setViewTextColor(this.n, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.p, (int) R.color.CAM_X0106);
            SkinManager.setViewTextColor(this.m, (int) R.color.CAM_X0111);
            SkinManager.setViewTextColor(this.o, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.q, (int) R.color.CAM_X0106);
            SkinManager.setViewTextColor(this.c, (int) R.color.CAM_X0101);
            SkinManager.setBackgroundColor(this.h, R.color.CAM_X0201);
            SkinManager.setBackgroundResource(this.g, R.drawable.bg_top_corner_white);
            SkinManager.setImageResource(this.a.getBackImageView(), R.drawable.btn_sml_back_selector_s);
            SkinManager.setBackgroundResource(this.c, R.drawable.frs_profession_button_bg);
            SkinManager.setViewTextColor(this.b, (int) R.color.CAM_X0302);
            SkinManager.setBackgroundColor(this.d, R.color.CAM_X0201);
            this.j.a(i);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d04a2);
            this.k = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f091aa9);
            this.a = (NavigationBar) findViewById(R.id.obfuscated_res_0x7f091ab4);
            this.j = (LinearGradientView) findViewById(R.id.obfuscated_res_0x7f091aaa);
            this.b = (TextView) findViewById(R.id.obfuscated_res_0x7f091ab1);
            this.c = findViewById(R.id.obfuscated_res_0x7f091ab2);
            this.d = findViewById(R.id.obfuscated_res_0x7f090403);
            this.f = findViewById(R.id.obfuscated_res_0x7f091aad);
            this.e = this.a.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.r);
            this.a.setCenterTextTitle(getString(R.string.obfuscated_res_0x7f0f0f3e));
            TbImageView tbImageView = (TbImageView) findViewById(R.id.obfuscated_res_0x7f091aac);
            this.i = tbImageView;
            tbImageView.setDefaultBgResource(R.color.transparent);
            this.i.setDefaultResource(R.drawable.obfuscated_res_0x7f080f39);
            this.h = findViewById(R.id.obfuscated_res_0x7f091aab);
            this.g = findViewById(R.id.obfuscated_res_0x7f091ab8);
            this.l = findViewById(R.id.obfuscated_res_0x7f091aae);
            this.p = findViewById(R.id.obfuscated_res_0x7f091aaf);
            this.n = findViewById(R.id.obfuscated_res_0x7f091ab0);
            this.m = findViewById(R.id.obfuscated_res_0x7f091ab5);
            this.q = findViewById(R.id.obfuscated_res_0x7f091ab6);
            this.o = findViewById(R.id.obfuscated_res_0x7f091ab7);
            this.b.setEnabled(true);
            this.b.setOnClickListener(this.r);
            this.c.setOnClickListener(this.r);
            C1();
            String stringExtra = getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_PATTEN_BACKGROUND);
            this.j.setGradientColor(getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_DAY_LIGHT_COLOR), getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_DAY_DARK_COLOR), getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_NIGHT_LIGHT_COLOR), getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_NIGHT_DARK_COLOR), getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_DARK_LIGHT_COLOR), getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_DARK_DARK_COLOR));
            this.i.K(stringExtra, 10, false);
        }
    }
}
