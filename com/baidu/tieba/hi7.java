package com.baidu.tieba;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class hi7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ y45 a;

        public a(y45 y45Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y45Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = y45Var;
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
        int equipmentWidth;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65536, null, activity, tbPageContext) == null) && activity != null && tbPageContext != null) {
            View inflate = LayoutInflater.from(activity).inflate(R.layout.frs_general_tab_notify_dialog_layout, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R.id.general_title);
            TextView textView2 = (TextView) inflate.findViewById(R.id.general_content_1);
            TextView textView3 = (TextView) inflate.findViewById(R.id.general_content_2);
            TextView textView4 = (TextView) inflate.findViewById(R.id.general_content_3);
            TextView textView5 = (TextView) inflate.findViewById(R.id.general_btn);
            TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.top_general_image);
            y45 y45Var = new y45(activity);
            y45Var.setContentView(inflate);
            y45Var.setContentViewSize(2);
            y45Var.setCanceledOnTouchOutside(true);
            y45Var.setAutoNight(true);
            y45Var.setCancelable(true);
            int dimens = BdUtilHelper.getDimens(activity, R.dimen.tbds31);
            SkinManager.setBackgroundShapeDrawable(inflate, dimens, R.color.CAM_X0201, R.color.CAM_X0101);
            tbImageView.setRadius(dimens);
            tbImageView.setConrers(3);
            tbImageView.setIsBitmapPic(true);
            int dimens2 = BdUtilHelper.getDimens(activity, R.dimen.tbds44);
            if (UtilHelper.getRealScreenOrientation(activity) == 2) {
                equipmentWidth = BdUtilHelper.getEquipmentHeight(activity);
            } else {
                equipmentWidth = BdUtilHelper.getEquipmentWidth(activity);
            }
            int i = equipmentWidth - (dimens2 * 2);
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
            textView5.setOnClickListener(new a(y45Var));
            y45Var.create(tbPageContext).show();
        }
    }
}
