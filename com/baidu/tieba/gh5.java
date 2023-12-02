package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.TBAlertBuilder;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.Glide;
/* loaded from: classes6.dex */
public class gh5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public interface c {
        void a();
    }

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;
        public final /* synthetic */ TBAlertBuilder b;

        public a(c cVar, TBAlertBuilder tBAlertBuilder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, tBAlertBuilder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
            this.b = tBAlertBuilder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                c cVar = this.a;
                if (cVar != null) {
                    cVar.a();
                }
                this.b.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TBAlertBuilder a;

        public b(TBAlertBuilder tBAlertBuilder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tBAlertBuilder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tBAlertBuilder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                gh5.b();
                this.a.dismiss();
            }
        }
    }

    public static void b() {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            try {
                if (TbadkCoreApplication.getInst().getSkinType() == 4) {
                    str = "&skin=dark";
                } else {
                    str = "";
                }
                Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
                if (currentActivity instanceof TbPageContextSupport) {
                    UrlManager.getInstance().dealOneLink(((TbPageContextSupport) currentActivity).getPageContext(), new String[]{TbConfig.VIRTUAL_IMAGE_MAIN_URL + str});
                }
            } catch (Exception e) {
                BdLog.e("openPageByUrl fail:" + e.toString());
            }
        }
    }

    public static void c(c cVar) {
        Context context;
        Activity currentActivity;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65538, null, cVar) != null) || (context = TbadkCoreApplication.getInst().getContext()) == null || (currentActivity = TbadkApplication.getInst().getCurrentActivity()) == null) {
            return;
        }
        TBAlertBuilder tBAlertBuilder = new TBAlertBuilder(currentActivity);
        View inflate = LayoutInflater.from(context).inflate(R.layout.pb_virtual_image_setting_post, (ViewGroup) null);
        EMManager.from(inflate.findViewById(R.id.virtual_image_setting_layout)).setCorner(R.string.J_X06).setBackGroundColor(R.color.CAM_X0201);
        TextView textView = (TextView) inflate.findViewById(R.id.virtual_image_setting_confirm_cancel_btn);
        EMManager.from(textView).setTextStyle(R.string.F_X01).setTextSize(R.dimen.T_X07).setTextColor(R.color.CAM_X0105).setCorner(R.string.J_X07).setBorderWidth(R.dimen.L_X02).setBorderColor(R.color.CAM_X0105).setBorderAlpha(R.string.A_X07);
        textView.setOnClickListener(new a(cVar, tBAlertBuilder));
        TextView textView2 = (TextView) inflate.findViewById(R.id.virtual_image_setting_confirm_btn);
        EMManager.from(textView2).setTextStyle(R.string.F_X01).setTextSize(R.dimen.T_X07).setTextColor(R.color.CAM_X0304).setCorner(R.string.J_X07).setBorderWidth(R.dimen.L_X02).setBorderColor(R.color.CAM_X0304).setBorderAlpha(R.string.A_X07);
        textView2.setOnClickListener(new b(tBAlertBuilder));
        tBAlertBuilder.setNeedTransparentBg(true).setCustomContentView(inflate).show();
        View findViewById = inflate.findViewById(R.id.pb_virtual_image_setting_guide_img);
        if (findViewById instanceof ImageView) {
            Glide.with(findViewById).load(kr6.b("icon_mask_post_virtual_image_pb.webp", "icon_mask_post_virtual_image_pb")).into((ImageView) findViewById);
        }
    }
}
