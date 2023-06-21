package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.VideoTemplateContent;
/* loaded from: classes5.dex */
public class gda {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public int b;
    public int c;
    public int d;
    public long e;
    public long f;
    public double g;
    public double h;
    public double i;
    public double j;
    public String k;

    public gda() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public void a(VideoTemplateContent videoTemplateContent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, videoTemplateContent) == null) {
            this.a = videoTemplateContent.content;
            this.b = videoTemplateContent.type.intValue();
            this.c = videoTemplateContent.pic_width.intValue();
            this.d = videoTemplateContent.pic_height.intValue();
            this.e = videoTemplateContent.start_time.longValue();
            this.f = videoTemplateContent.end_time.longValue();
            this.g = videoTemplateContent.position_x.doubleValue();
            this.h = videoTemplateContent.position_y.doubleValue();
            this.i = videoTemplateContent.position_type.doubleValue();
            this.j = videoTemplateContent.text_size.doubleValue();
            this.k = videoTemplateContent.text_color;
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return "AnniversaryContentData{content='" + this.a + "', type=" + this.b + ", picWidth=" + this.c + ", picHeight=" + this.d + ", startTime=" + this.e + ", endTime=" + this.f + ", x=" + this.g + ", y=" + this.h + ", positionType=" + this.i + ", textSize=" + this.j + ", textColor='" + this.k + "'}";
        }
        return (String) invokeV.objValue;
    }
}
