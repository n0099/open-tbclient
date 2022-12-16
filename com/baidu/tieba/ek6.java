package com.baidu.tieba;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class ek6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lv4 a;

        public a(lv4 lv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lv4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lv4Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.dismiss();
            }
        }
    }

    public static void a(Activity activity, TbPageContext<?> tbPageContext) {
        int l;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65536, null, activity, tbPageContext) == null) && activity != null && tbPageContext != null) {
            View inflate = LayoutInflater.from(activity).inflate(R.layout.frs_general_tab_notify_dialog_layout, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R.id.general_title);
            TextView textView2 = (TextView) inflate.findViewById(R.id.general_content_1);
            TextView textView3 = (TextView) inflate.findViewById(R.id.general_content_2);
            TextView textView4 = (TextView) inflate.findViewById(R.id.general_content_3);
            TextView textView5 = (TextView) inflate.findViewById(R.id.general_btn);
            TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.top_general_image);
            lv4 lv4Var = new lv4(activity);
            lv4Var.setContentView(inflate);
            lv4Var.setContentViewSize(2);
            lv4Var.setCanceledOnTouchOutside(true);
            lv4Var.setAutoNight(true);
            lv4Var.setCancelable(true);
            int g = yi.g(activity, R.dimen.tbds31);
            SkinManager.setBackgroundShapeDrawable(inflate, g, R.color.CAM_X0201, R.color.CAM_X0101);
            tbImageView.setRadius(g);
            tbImageView.setConrers(3);
            tbImageView.setIsBitmapPic(true);
            int g2 = yi.g(activity, R.dimen.tbds44);
            if (UtilHelper.getRealScreenOrientation(activity) == 2) {
                l = yi.j(activity);
            } else {
                l = yi.l(activity);
            }
            int i = l - (g2 * 2);
            ViewGroup.LayoutParams layoutParams = tbImageView.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = (i * 556) / 988;
            tbImageView.setLayoutParams(layoutParams);
            SkinManager.setImageResource(tbImageView, R.drawable.frs_general_tab_notify_pic);
            SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(textView2, (int) R.color.CAM_X0107);
            SkinManager.setViewTextColor(textView3, (int) R.color.CAM_X0107);
            SkinManager.setViewTextColor(textView4, (int) R.color.CAM_X0107);
            SkinManager.setViewTextColor(textView5, (int) R.color.CAM_X0302);
            textView5.setOnClickListener(new a(lv4Var));
            lv4Var.create(tbPageContext).show();
        }
    }
}
