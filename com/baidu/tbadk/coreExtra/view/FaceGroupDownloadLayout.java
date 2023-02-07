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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.EmotionPackageDetailActivityConfig;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.ej;
import com.baidu.tieba.p15;
import com.baidu.tieba.r95;
import com.baidu.tieba.tbadkCore.data.FaceGroupInfoData;
import com.baidu.tieba.y9;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@RequiresApi(api = 21)
/* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
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
                    this.a.k();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
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

    public void l(boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048585, this, z) != null) || this.f == null) {
            return;
        }
        this.h = z;
        g();
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
        if (interceptable == null || interceptable.invokeL(1048586, this, view2) == null) {
            if (view2.getId() == R.id.face_group_download_root_layout) {
                e();
            } else if (view2.getId() == R.id.face_group_download_btn) {
                f();
            }
        }
    }

    public void setFloorImageTextViewVisible(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.g = z;
            g();
        }
    }

    public final void c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            LayoutInflater.from(context).inflate(R.layout.face_group_download_layout, (ViewGroup) this, true);
            setPadding(ej.g(getContext(), R.dimen.M_H_X009), 0, ej.g(getContext(), R.dimen.M_H_X009), ej.g(getContext(), R.dimen.M_H_X005));
            this.a = findViewById(R.id.face_group_download_root_layout);
            this.b = (TbImageView) findViewById(R.id.face_group_download_cover);
            this.c = (TextView) findViewById(R.id.face_group_download_name);
            this.d = (ImageView) findViewById(R.id.face_group_download_arrow);
            this.e = (FaceGroupDownloadButton) findViewById(R.id.face_group_download_btn);
            this.a.setOnClickListener(this);
            this.e.setOnClickListener(this);
            setVisibility(8);
            h();
            d();
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            p15 d = p15.d(this.a);
            d.n(R.string.J_X05);
            d.f(R.color.CAM_X0215);
            p15 d2 = p15.d(this.e);
            d2.v(R.color.CAM_X0101);
            d2.z(R.dimen.T_X08);
            d2.A(R.string.F_X01);
            p15 d3 = p15.d(this.c);
            d3.v(R.color.CAM_X0101);
            d3.z(R.dimen.T_X06);
            d3.A(R.string.F_X01);
            p15.d(this.b).v(R.string.J_X04);
            WebPManager.setPureDrawable(this.d, R.drawable.icon_emotion_arrow, R.color.CAM_X0101, null);
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.f != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EmotionPackageDetailActivityConfig(getContext(), Integer.parseInt(this.f.getId()), 25024)));
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (this.g && !this.h) {
                ((ViewGroup.MarginLayoutParams) getLayoutParams()).bottomMargin = -ej.g(TbadkApplication.getInst(), R.dimen.tbds174);
                return;
            }
            ((ViewGroup.MarginLayoutParams) getLayoutParams()).bottomMargin = 0;
        }
    }

    public final void f() {
        FaceGroupInfoData faceGroupInfoData;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048579, this) != null) || (faceGroupInfoData = this.f) == null) {
            return;
        }
        if (faceGroupInfoData.getStatus() == FaceGroupInfoData.Status.FAIL || this.f.getStatus() == FaceGroupInfoData.Status.NEW) {
            i();
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (getContext() instanceof y9)) {
            ((y9) getContext()).getPageContext().registerListener(this.i);
        }
    }

    public final void i() {
        FaceGroupInfoData faceGroupInfoData;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048582, this) != null) || (faceGroupInfoData = this.f) == null) {
            return;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2921702, faceGroupInfoData));
    }

    public void j(ImageUrlData imageUrlData) {
        FaceGroupInfoData faceGroupInfoData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, imageUrlData) == null) {
            if (imageUrlData != null && (faceGroupInfoData = imageUrlData.faceGroupInfoData) != null) {
                this.f = faceGroupInfoData;
                setVisibility(0);
                if (!TextUtils.isEmpty(this.f.getCover())) {
                    this.b.K(this.f.getCover(), 10, false);
                } else {
                    this.b.setDefaultBgResource(R.drawable.icon_pic_datu);
                }
                int g = (((getResources().getDisplayMetrics().widthPixels - ej.g(TbadkApplication.getInst(), R.dimen.tbds94)) - ej.g(TbadkApplication.getInst(), R.dimen.tbds180)) - ej.g(TbadkApplication.getInst(), R.dimen.tbds75)) - ej.g(TbadkApplication.getInst(), R.dimen.tbds200);
                TextPaint paint = this.c.getPaint();
                String name = this.f.getName();
                this.c.setText(r95.a(name, StringHelper.STRING_MORE + j, g, paint));
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921699, Boolean.class, this.f.getId());
                if (runTask != null && ((Boolean) runTask.getData()).booleanValue()) {
                    this.f.updateStatus(FaceGroupInfoData.Status.FINISH);
                }
                k();
                return;
            }
            this.f = null;
            setVisibility(8);
        }
    }

    public final void k() {
        FaceGroupInfoData faceGroupInfoData;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) != null) || (faceGroupInfoData = this.f) == null) {
            return;
        }
        this.e.setStatus(faceGroupInfoData.getStatus());
        int i = b.a[this.f.getStatus().ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    this.e.setText(getResources().getString(R.string.obfuscated_res_0x7f0f0530));
                    return;
                }
                this.e.setProgress(this.f.getProgress());
                this.e.setText(String.format(getResources().getString(R.string.item_download_progress), Integer.valueOf(this.f.getProgress())));
                return;
            }
            this.e.setText(getResources().getString(R.string.obfuscated_res_0x7f0f0648));
            return;
        }
        this.e.setText(getResources().getString(R.string.obfuscated_res_0x7f0f00db));
    }
}
