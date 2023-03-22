package com.baidu.tieba;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.immessagecenter.im.chat.personaltalk.InvatateAnswerSettingActivity;
import com.baidu.tieba.immessagecenter.im.chat.personaltalk.PersonalTalkSettingViewSettingView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class ey7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final InvatateAnswerSettingActivity a;
    public final NavigationBar b;
    public final View c;
    public final HeadImageView d;
    public final TextView e;
    public final UserIconBox f;
    public final TextView g;
    public ImageView h;
    public TbSettingTextTipView i;
    public TbSettingTextTipView j;
    public TbSettingTextTipView k;
    public RelativeLayout l;
    public View m;
    public PersonalTalkSettingViewSettingView n;

    public ey7(InvatateAnswerSettingActivity invatateAnswerSettingActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {invatateAnswerSettingActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = invatateAnswerSettingActivity;
        invatateAnswerSettingActivity.setContentView(R.layout.obfuscated_res_0x7f0d06ef);
        View findViewById = this.a.findViewById(R.id.obfuscated_res_0x7f091b1b);
        this.c = findViewById;
        NavigationBar navigationBar = (NavigationBar) findViewById.findViewById(R.id.view_navigation_bar);
        this.b = navigationBar;
        navigationBar.setCenterTextTitle(this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f1469));
        this.b.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        PersonalTalkSettingViewSettingView personalTalkSettingViewSettingView = (PersonalTalkSettingViewSettingView) this.a.findViewById(R.id.obfuscated_res_0x7f092033);
        this.n = personalTalkSettingViewSettingView;
        personalTalkSettingViewSettingView.a.setVisibility(0);
        c(m35.m().i("key_question_msg_no_remind", false));
        this.n.b.setVisibility(8);
        this.l = (RelativeLayout) this.a.findViewById(R.id.obfuscated_res_0x7f0926ae);
        TbSettingTextTipView tbSettingTextTipView = (TbSettingTextTipView) this.a.findViewById(R.id.obfuscated_res_0x7f092147);
        this.j = tbSettingTextTipView;
        tbSettingTextTipView.setVisibility(8);
        TbSettingTextTipView tbSettingTextTipView2 = (TbSettingTextTipView) this.a.findViewById(R.id.obfuscated_res_0x7f090132);
        this.k = tbSettingTextTipView2;
        tbSettingTextTipView2.setVisibility(8);
        TbSettingTextTipView tbSettingTextTipView3 = (TbSettingTextTipView) this.a.findViewById(R.id.obfuscated_res_0x7f092146);
        this.i = tbSettingTextTipView3;
        tbSettingTextTipView3.setVisibility(8);
        HeadImageView headImageView = (HeadImageView) this.a.findViewById(R.id.obfuscated_res_0x7f091b55);
        this.d = headImageView;
        headImageView.setIsRound(true);
        this.d.setGodIconWidth(R.dimen.tbds47);
        TextView textView = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f090fba);
        this.e = textView;
        textView.setText(this.a.getString(R.string.obfuscated_res_0x7f0f0a15));
        ImageView imageView = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f090fb8);
        this.h = imageView;
        imageView.setVisibility(8);
        this.f = (UserIconBox) this.a.findViewById(R.id.user_icon_box);
        TextView textView2 = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f092690);
        this.g = textView2;
        textView2.setText(this.a.getString(R.string.obfuscated_res_0x7f0f0dbc));
        this.m = this.a.findViewById(R.id.obfuscated_res_0x7f0908d6);
    }

    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            this.a.getLayoutMode().k(this.c);
            this.b.onChangeSkinType(this.a.getPageContext(), i);
            this.d.setImageDrawable(SkinManager.getDrawable(R.drawable.obfuscated_res_0x7f080859));
            n15 d = n15.d(this.e);
            d.B(R.string.F_X02);
            d.A(R.dimen.T_X04);
            d.w(R.color.CAM_X0105);
            n15 d2 = n15.d(this.g);
            d2.B(R.string.F_X01);
            d2.A(R.dimen.T_X08);
            d2.w(R.color.CAM_X0109);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.h, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
            SkinManager.setBackgroundColor(this.k, R.color.CAM_X0201);
            SkinManager.setBackgroundColor(this.j, R.color.CAM_X0201);
        }
    }

    public void b(BdSwitchView.b bVar) {
        PersonalTalkSettingViewSettingView personalTalkSettingViewSettingView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) && (personalTalkSettingViewSettingView = this.n) != null) {
            personalTalkSettingViewSettingView.setSwitchStateChangeListener(bVar);
        }
    }

    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            if (z) {
                this.n.a.g();
            } else {
                this.n.a.e();
            }
        }
    }
}
