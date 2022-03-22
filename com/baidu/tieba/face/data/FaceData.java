package com.baidu.tieba.face.data;

import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
/* loaded from: classes5.dex */
public class FaceData implements Comparable<FaceData>, Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int TYPE_ADD_ICON = 4;
    public static final int TYPE_ALBUM = 3;
    public static final int TYPE_COLLECT = 1;
    public static final int TYPE_SEARCH = 2;
    public transient /* synthetic */ FieldHolder $fh;
    public EmotionImageData emotionImageData;
    public int height;
    public ImageFileInfo imageFileInfo;
    public int index;
    public String pid;
    public int type;
    public int width;

    public FaceData() {
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

    public FaceData(int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.type = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    public int compareTo(FaceData faceData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, faceData)) == null) {
            if (this == faceData) {
                return 0;
            }
            return (faceData == null || this.index <= faceData.index) ? -1 : 1;
        }
        return invokeL.intValue;
    }
}
