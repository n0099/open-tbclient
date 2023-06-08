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
/* loaded from: classes5.dex */
public class gi8 {
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

    public gi8(InvatateAnswerSettingActivity invatateAnswerSettingActivity) {
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
        invatateAnswerSettingActivity.setContentView(R.layout.obfuscated_res_0x7f0d072b);
        View findViewById = this.a.findViewById(R.id.obfuscated_res_0x7f091b96);
        this.c = findViewById;
        NavigationBar navigationBar = (NavigationBar) findViewById.findViewById(R.id.view_navigation_bar);
        this.b = navigationBar;
        navigationBar.setCenterTextTitle(this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f159d));
        this.b.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        PersonalTalkSettingViewSettingView personalTalkSettingViewSettingView = (PersonalTalkSettingViewSettingView) this.a.findViewById(R.id.obfuscated_res_0x7f0920c0);
        this.n = personalTalkSettingViewSettingView;
        personalTalkSettingViewSettingView.a.setVisibility(0);
        c(n95.m().i("key_question_msg_no_remind", false));
        this.n.b.setVisibility(8);
        this.l = (RelativeLayout) this.a.findViewById(R.id.obfuscated_res_0x7f092763);
        TbSettingTextTipView tbSettingTextTipView = (TbSettingTextTipView) this.a.findViewById(R.id.obfuscated_res_0x7f0921df);
        this.j = tbSettingTextTipView;
        tbSettingTextTipView.setVisibility(8);
        TbSettingTextTipView tbSettingTextTipView2 = (TbSettingTextTipView) this.a.findViewById(R.id.obfuscated_res_0x7f09013d);
        this.k = tbSettingTextTipView2;
        tbSettingTextTipView2.setVisibility(8);
        TbSettingTextTipView tbSettingTextTipView3 = (TbSettingTextTipView) this.a.findViewById(R.id.obfuscated_res_0x7f0921de);
        this.i = tbSettingTextTipView3;
        tbSettingTextTipView3.setVisibility(8);
        HeadImageView headImageView = (HeadImageView) this.a.findViewById(R.id.obfuscated_res_0x7f091bd3);
        this.d = headImageView;
        headImageView.setIsRound(true);
        this.d.setGodIconWidth(R.dimen.tbds47);
        TextView textView = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f091015);
        this.e = textView;
        textView.setText(this.a.getString(R.string.obfuscated_res_0x7f0f0ad7));
        ImageView imageView = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f091013);
        this.h = imageView;
        imageView.setVisibility(8);
        this.f = (UserIconBox) this.a.findViewById(R.id.user_icon_box);
        TextView textView2 = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f092744);
        this.g = textView2;
        textView2.setText(this.a.getString(R.string.obfuscated_res_0x7f0f0e94));
        this.m = this.a.findViewById(R.id.obfuscated_res_0x7f090909);
    }

    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            this.a.getLayoutMode().k(this.c);
            this.b.onChangeSkinType(this.a.getPageContext(), i);
            this.d.setImageDrawable(SkinManager.getDrawable(R.drawable.obfuscated_res_0x7f0809c4));
            o75 d = o75.d(this.e);
            d.C(R.string.F_X02);
            d.B(R.dimen.T_X04);
            d.w(R.color.CAM_X0105);
            o75 d2 = o75.d(this.g);
            d2.C(R.string.F_X01);
            d2.B(R.dimen.T_X08);
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
