package com.baidu.tieba;

import android.text.TextUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.view.NavigationBarCoverTip;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class g57 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsFragment a;
    public NavigationBarCoverTip b;
    public TextView c;
    public int d;

    public g57(FrsFragment frsFragment, NavigationBarCoverTip navigationBarCoverTip) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsFragment, navigationBarCoverTip};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = frsFragment;
        this.b = navigationBarCoverTip;
        b();
    }

    public void a(String str) {
        int i;
        String str2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && !dj.isEmpty(str) && this.b != null && this.a.isPrimary() && (i = this.d) <= 0) {
            this.d = i + 1;
            if (str.length() < 20) {
                str2 = this.a.getResources().getString(R.string.forum_ueg_tip) + "\n" + str;
            } else if (str.length() < 34) {
                str2 = this.a.getResources().getString(R.string.forum_ueg_tip) + str;
            } else {
                str2 = this.a.getResources().getString(R.string.forum_ueg_tip) + str.substring(0, 34);
            }
            this.c.setText(str2);
            SkinManager.setViewTextColor(this.c, (int) R.color.CAM_X0101);
            SkinManager.setBackgroundColor(this.b, R.color.cp_link_tip_a_alpha95);
            this.b.n(this.a.getActivity(), this.c, 5000);
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.d = 0;
            this.c = new TextView(this.a.getActivity());
            this.c.setLayoutParams(new LinearLayout.LayoutParams(-1, this.a.getResources().getDimensionPixelSize(R.dimen.tbds112)));
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.c.setPadding(this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07020f), this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070198), this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07020f), 0);
                this.c.setGravity(3);
            } else {
                this.c.setPadding(this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07020f), 0, this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07020f), 0);
                this.c.setGravity(19);
            }
            this.c.setTextSize(0, this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701f9));
            this.c.setLineSpacing(this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701d4), 1.0f);
            this.c.setMaxLines(2);
            this.c.setEllipsize(TextUtils.TruncateAt.END);
        }
    }

    public void c() {
        NavigationBarCoverTip navigationBarCoverTip;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (navigationBarCoverTip = this.b) != null) {
            navigationBarCoverTip.i();
        }
    }
}
