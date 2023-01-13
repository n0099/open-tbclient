package com.baidu.tieba;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.widget.ImageView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class f78 extends io5 {
    public static /* synthetic */ Interceptable $ic = null;
    public static double O = 0.5d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947717154, "Lcom/baidu/tieba/f78;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947717154, "Lcom/baidu/tieba/f78;");
        }
    }

    /* loaded from: classes4.dex */
    public class a implements TbImageView.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f78 a;

        @Override // com.baidu.tbadk.widget.TbImageView.h
        public void a(TbImageView tbImageView, Canvas canvas) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, tbImageView, canvas) == null) {
            }
        }

        public a(f78 f78Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f78Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = f78Var;
        }

        @Override // com.baidu.tbadk.widget.TbImageView.h
        public void b(TbImageView tbImageView, Canvas canvas) {
            int i;
            int i2;
            float f;
            float f2;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbImageView, canvas) == null) && tbImageView != null && tbImageView.getImageMatrix() != null && tbImageView.getScaleType() == ImageView.ScaleType.MATRIX) {
                Matrix imageMatrix = tbImageView.getImageMatrix();
                if (this.a.u) {
                    i = 17;
                } else {
                    i = 18;
                }
                jn m = ba5.k().m(ug.h().g(tbImageView.getUrl(), i));
                int i3 = 0;
                if (m != null) {
                    i3 = m.r();
                    i2 = m.m();
                } else {
                    i2 = 0;
                }
                if (i3 != 0 && i2 != 0) {
                    int width = (tbImageView.getWidth() - tbImageView.getPaddingLeft()) - tbImageView.getPaddingRight();
                    int height = (tbImageView.getHeight() - tbImageView.getPaddingTop()) - tbImageView.getPaddingBottom();
                    if (i3 * height > width * i2) {
                        f = height;
                        f2 = i2;
                    } else {
                        f = width;
                        f2 = i3;
                    }
                    float f3 = f / f2;
                    imageMatrix.setScale(f3, f3);
                    imageMatrix.postTranslate(0.0f, 0.0f);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f78(io5 io5Var) {
        super(io5Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {io5Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((io5) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        l(true);
        v();
        p(TbConfig.getPostLineSpace(), 1.0f);
        A(0);
        m(zi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds30));
        n(zi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds12));
        j(zi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48), zi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48));
        t(zi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.M_H_X004), zi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.M_H_X004));
        k(zi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.M_H_X004));
        this.J = zi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds749);
        this.K = zi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds10);
        zi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds26);
        this.M = new a(this);
    }

    @Override // com.baidu.tieba.io5
    public int[] f(int i, int i2, int i3, int i4) {
        InterceptResult invokeIIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIII = interceptable.invokeIIII(1048576, this, i, i2, i3, i4)) == null) {
            if (i2 > 0 && i > 0 && i3 > 0 && i4 > 0) {
                if (this.v) {
                    float f = io5.N;
                    if (f > 1.0f) {
                        float f2 = i;
                        if (f2 * f <= i3 * O) {
                            i3 = (int) (f2 * f);
                        }
                        i2 = (i2 * i3) / i;
                        if (i2 > 4096) {
                            this.s = ImageView.ScaleType.MATRIX;
                            i = i3;
                            i2 = 4096;
                        } else {
                            this.s = ImageView.ScaleType.CENTER_CROP;
                            i = i3;
                        }
                    }
                }
                return new int[]{i, i2};
            }
            return null;
        }
        return (int[]) invokeIIII.objValue;
    }
}
