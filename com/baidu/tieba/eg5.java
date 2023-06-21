package com.baidu.tieba;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.coreExtra.view.AbsFloorImageTextView;
import com.baidu.tbadk.coreExtra.view.FaceGroupDownloadLayout;
import com.baidu.tbadk.coreExtra.view.FloorImageTextViewNew;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.coreExtra.view.ImageViewerBottomLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class eg5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public ImageViewerBottomLayout b;
    public AbsFloorImageTextView c;
    public LinearLayout d;
    public FaceGroupDownloadLayout e;
    public boolean f;
    public final ImageViewerBottomLayout.a g;

    /* loaded from: classes5.dex */
    public class a implements ImageViewerBottomLayout.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ eg5 a;

        public a(eg5 eg5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eg5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eg5Var;
        }

        @Override // com.baidu.tbadk.coreExtra.view.ImageViewerBottomLayout.a
        public void a(ImageViewerBottomLayout imageViewerBottomLayout, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeLZ(1048576, this, imageViewerBottomLayout, z) != null) {
                return;
            }
            this.a.f = z;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016496, Boolean.valueOf(this.a.f)));
            this.a.r(z);
        }
    }

    public eg5(@NonNull Context context, @NonNull RelativeLayout relativeLayout) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, relativeLayout};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f = true;
        this.g = new a(this);
        this.a = context;
        LinearLayout linearLayout = new LinearLayout(context);
        this.d = linearLayout;
        linearLayout.setOrientation(1);
        this.d.setVisibility(8);
        SkinManager.setBackgroundColorToTransparent(this.d, R.color.CAM_X0607, GradientDrawable.Orientation.BOTTOM_TOP);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        relativeLayout.addView(this.d, layoutParams);
        d();
        e();
        f();
    }

    public final boolean i(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, view2)) == null) {
            if (view2 != null && view2.getVisibility() == 0) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void k(ImageViewerBottomLayout.b bVar) {
        ImageViewerBottomLayout imageViewerBottomLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar) == null) && (imageViewerBottomLayout = this.b) != null) {
            imageViewerBottomLayout.setOnDownloadImageListener(bVar);
        }
    }

    public void l(View.OnClickListener onClickListener) {
        ImageViewerBottomLayout imageViewerBottomLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, onClickListener) == null) && (imageViewerBottomLayout = this.b) != null) {
            imageViewerBottomLayout.setOnReplyClickListener(onClickListener);
        }
    }

    public void m(ImageViewerBottomLayout.c cVar) {
        ImageViewerBottomLayout imageViewerBottomLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, cVar) == null) && (imageViewerBottomLayout = this.b) != null) {
            imageViewerBottomLayout.setOnShareImageListener(cVar);
        }
    }

    public void n(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            AbsFloorImageTextView absFloorImageTextView = this.c;
            if (absFloorImageTextView != null) {
                absFloorImageTextView.setUserId(str);
            }
            ImageViewerBottomLayout imageViewerBottomLayout = this.b;
            if (imageViewerBottomLayout != null) {
                imageViewerBottomLayout.setUserId(str);
            }
        }
    }

    public void o(int i) {
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048588, this, i) == null) && (linearLayout = this.d) != null) {
            linearLayout.clearAnimation();
            this.d.setVisibility(i);
        }
    }

    public void q(boolean z) {
        ImageViewerBottomLayout imageViewerBottomLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048590, this, z) == null) && (imageViewerBottomLayout = this.b) != null) {
            imageViewerBottomLayout.setYoungterCoverSomeView(z);
        }
    }

    public void r(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            AbsFloorImageTextView absFloorImageTextView = this.c;
            if (absFloorImageTextView != null) {
                absFloorImageTextView.e(z);
            }
            ImageViewerBottomLayout imageViewerBottomLayout = this.b;
            if (imageViewerBottomLayout != null) {
                imageViewerBottomLayout.e(!z);
            }
            FaceGroupDownloadLayout faceGroupDownloadLayout = this.e;
            if (faceGroupDownloadLayout != null) {
                faceGroupDownloadLayout.l(!z);
            }
        }
    }

    public void p(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048589, this, i, i2) == null) {
            if (i == 0) {
                x7a.d(this.d, i2);
            } else {
                x7a.b(this.d, i2);
            }
        }
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ImageViewerBottomLayout imageViewerBottomLayout = this.b;
            if (imageViewerBottomLayout != null && this.c != null) {
                return imageViewerBottomLayout.getHeight() + AbsFloorImageTextView.i;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            FaceGroupDownloadLayout faceGroupDownloadLayout = new FaceGroupDownloadLayout(this.a);
            this.e = faceGroupDownloadLayout;
            this.d.addView(faceGroupDownloadLayout, layoutParams);
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            FloorImageTextViewNew floorImageTextViewNew = new FloorImageTextViewNew(this.a);
            this.c = floorImageTextViewNew;
            this.d.addView(floorImageTextViewNew, layoutParams);
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, ImageViewerBottomLayout.r);
            ImageViewerBottomLayout imageViewerBottomLayout = new ImageViewerBottomLayout(this.a);
            this.b = imageViewerBottomLayout;
            this.d.addView(imageViewerBottomLayout, layoutParams);
            this.b.setExpandButtonListener(this.g);
        }
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.f;
        }
        return invokeV.booleanValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return i(this.d);
        }
        return invokeV.booleanValue;
    }

    public void j(ImageUrlData imageUrlData) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, imageUrlData) == null) {
            AbsFloorImageTextView absFloorImageTextView = this.c;
            if (absFloorImageTextView != null) {
                absFloorImageTextView.f(imageUrlData);
            }
            ImageViewerBottomLayout imageViewerBottomLayout = this.b;
            if (imageViewerBottomLayout != null) {
                imageViewerBottomLayout.d(imageUrlData);
            }
            FaceGroupDownloadLayout faceGroupDownloadLayout = this.e;
            if (faceGroupDownloadLayout != null) {
                faceGroupDownloadLayout.j(imageUrlData);
                AbsFloorImageTextView absFloorImageTextView2 = this.c;
                if (absFloorImageTextView2 != null) {
                    FaceGroupDownloadLayout faceGroupDownloadLayout2 = this.e;
                    if (absFloorImageTextView2.getVisibility() == 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    faceGroupDownloadLayout2.setFloorImageTextViewVisible(z);
                }
            }
        }
    }
}
