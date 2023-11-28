package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.EmotionPackageDetailActivityConfig;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.data.FaceGroupInfoData;
import com.baidu.tieba.wb5;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@RequiresApi(api = 21)
/* loaded from: classes5.dex */
public class FaceGroupDownloadLayout extends RelativeLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static String j = "表情包";
    public transient /* synthetic */ FieldHolder $fh;
    public View a;
    public TbImageView b;
    public TextView c;
    public ImageView d;
    public FaceGroupDownloadButton e;
    public FaceGroupInfoData f;
    public boolean g;
    public boolean h;
    public final CustomMessageListener i;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1550527824, "Lcom/baidu/tbadk/coreExtra/view/FaceGroupDownloadLayout;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1550527824, "Lcom/baidu/tbadk/coreExtra/view/FaceGroupDownloadLayout;");
        }
    }

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FaceGroupDownloadLayout a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(FaceGroupDownloadLayout faceGroupDownloadLayout, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {faceGroupDownloadLayout, Integer.valueOf(i)};
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
            this.a = faceGroupDownloadLayout;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && this.a.f != null && (customResponsedMessage.getData() instanceof FaceGroupInfoData)) {
                FaceGroupInfoData faceGroupInfoData = (FaceGroupInfoData) customResponsedMessage.getData();
                if (this.a.f.getId().equals(faceGroupInfoData.getId())) {
                    this.a.f.updateStatus(faceGroupInfoData.getStatus());
                    this.a.f.setProgress(faceGroupInfoData.getProgress());
                    this.a.n();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static /* synthetic */ class b {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(296393842, "Lcom/baidu/tbadk/coreExtra/view/FaceGroupDownloadLayout$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(296393842, "Lcom/baidu/tbadk/coreExtra/view/FaceGroupDownloadLayout$b;");
                    return;
                }
            }
            int[] iArr = new int[FaceGroupInfoData.Status.values().length];
            a = iArr;
            try {
                iArr[FaceGroupInfoData.Status.FINISH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[FaceGroupInfoData.Status.FAIL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[FaceGroupInfoData.Status.DOWNLOADING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FaceGroupDownloadLayout(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.i = new a(this, 2921703);
        c(context);
    }

    public void o(boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048587, this, z) != null) || this.f == null) {
            return;
        }
        this.h = z;
        h();
        if (z) {
            i = 8;
        } else {
            i = 0;
        }
        setVisibility(i);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, view2) == null) {
            if (view2.getId() == R.id.face_group_download_root_layout) {
                e();
            } else if (view2.getId() == R.id.face_group_download_btn) {
                g();
            }
        }
    }

    public void setFloorImageTextViewVisible(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.g = z;
            h();
        }
    }

    public final void c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            LayoutInflater.from(context).inflate(R.layout.face_group_download_layout, (ViewGroup) this, true);
            setPadding(BdUtilHelper.getDimens(getContext(), R.dimen.M_H_X009), 0, BdUtilHelper.getDimens(getContext(), R.dimen.M_H_X009), BdUtilHelper.getDimens(getContext(), R.dimen.M_H_X005));
            this.a = findViewById(R.id.face_group_download_root_layout);
            this.b = (TbImageView) findViewById(R.id.face_group_download_cover);
            this.c = (TextView) findViewById(R.id.face_group_download_name);
            this.d = (ImageView) findViewById(R.id.face_group_download_arrow);
            this.e = (FaceGroupDownloadButton) findViewById(R.id.face_group_download_btn);
            this.a.setOnClickListener(this);
            this.e.setOnClickListener(this);
            setVisibility(8);
            i();
            d();
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            EMManager.from(this.a).setCorner(R.string.J_X05).setBackGroundColor(R.color.CAM_X0215);
            EMManager.from(this.e).setTextColor(R.color.CAM_X0101).setTextSize(R.dimen.T_X08).setTextStyle(R.string.F_X01);
            EMManager.from(this.c).setTextColor(R.color.CAM_X0101).setTextSize(R.dimen.T_X06).setTextStyle(R.string.F_X01);
            EMManager.from(this.b).setTextColor(R.string.J_X04);
            WebPManager.setPureDrawable(this.d, R.drawable.icon_emotion_arrow, R.color.CAM_X0101, null);
        }
    }

    public final void n() {
        FaceGroupInfoData faceGroupInfoData;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048586, this) != null) || (faceGroupInfoData = this.f) == null) {
            return;
        }
        this.e.setStatus(faceGroupInfoData.getStatus());
        int i = b.a[this.f.getStatus().ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    this.e.setText(getResources().getString(R.string.obfuscated_res_0x7f0f05c0));
                    return;
                }
                this.e.setProgress(this.f.getProgress());
                this.e.setText(String.format(getResources().getString(R.string.item_download_progress), Integer.valueOf(this.f.getProgress())));
                return;
            }
            this.e.setText(getResources().getString(R.string.obfuscated_res_0x7f0f0722));
            return;
        }
        this.e.setText(getResources().getString(R.string.obfuscated_res_0x7f0f0106));
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.f != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EmotionPackageDetailActivityConfig(getContext(), Integer.parseInt(this.f.getId()), 25024)));
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (this.g && !this.h) {
                ((ViewGroup.MarginLayoutParams) getLayoutParams()).bottomMargin = -BdUtilHelper.getDimens(TbadkApplication.getInst(), R.dimen.tbds174);
                return;
            }
            ((ViewGroup.MarginLayoutParams) getLayoutParams()).bottomMargin = 0;
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            k();
        }
    }

    public final void g() {
        FaceGroupInfoData faceGroupInfoData;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048580, this) != null) || (faceGroupInfoData = this.f) == null) {
            return;
        }
        if (faceGroupInfoData.getStatus() == FaceGroupInfoData.Status.FAIL || this.f.getStatus() == FaceGroupInfoData.Status.NEW) {
            j();
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            MessageManager.getInstance().registerListener(this.i);
        }
    }

    public final void j() {
        FaceGroupInfoData faceGroupInfoData;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048583, this) != null) || (faceGroupInfoData = this.f) == null) {
            return;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2921702, faceGroupInfoData));
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.i);
        }
    }

    public void l(ImageUrlData imageUrlData) {
        FaceGroupInfoData faceGroupInfoData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, imageUrlData) == null) {
            if (imageUrlData != null && (faceGroupInfoData = imageUrlData.faceGroupInfoData) != null) {
                this.f = faceGroupInfoData;
                setVisibility(0);
                if (!TextUtils.isEmpty(this.f.getCover())) {
                    this.b.startLoad(this.f.getCover(), 10, false);
                } else {
                    this.b.setDefaultBgResource(R.drawable.icon_pic_datu);
                }
                int dimens = (((getResources().getDisplayMetrics().widthPixels - BdUtilHelper.getDimens(TbadkApplication.getInst(), R.dimen.tbds94)) - BdUtilHelper.getDimens(TbadkApplication.getInst(), R.dimen.tbds180)) - BdUtilHelper.getDimens(TbadkApplication.getInst(), R.dimen.tbds75)) - BdUtilHelper.getDimens(TbadkApplication.getInst(), R.dimen.tbds200);
                TextPaint paint = this.c.getPaint();
                String name = this.f.getName();
                this.c.setText(wb5.a(name, "..." + j, dimens, paint));
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921699, Boolean.class, this.f.getId());
                if (runTask != null && ((Boolean) runTask.getData()).booleanValue()) {
                    this.f.updateStatus(FaceGroupInfoData.Status.FINISH);
                }
                n();
                return;
            }
            this.f = null;
            setVisibility(8);
        }
    }
}
