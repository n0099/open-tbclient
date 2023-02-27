package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.swan.apps.media.chooser.model.MediaModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class dx2 {
    public static /* synthetic */ Interceptable $ic;
    public static ArrayList<MediaModel> a;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a() {
        ArrayList<MediaModel> arrayList;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65536, null) == null) && (arrayList = a) != null) {
            arrayList.clear();
            a = null;
        }
    }

    public static int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            ArrayList<MediaModel> arrayList = a;
            if (arrayList == null) {
                return 0;
            }
            return arrayList.size();
        }
        return invokeV.intValue;
    }

    public static ArrayList<MediaModel> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            return a;
        }
        return (ArrayList) invokeV.objValue;
    }

    public static String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            ArrayList<MediaModel> arrayList = a;
            if (arrayList != null && arrayList.size() != 0 && a.get(0) != null) {
                return a.get(0).getType();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public static int c(MediaModel mediaModel) {
        InterceptResult invokeL;
        ArrayList<MediaModel> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, mediaModel)) == null) {
            if (mediaModel == null || (arrayList = a) == null) {
                return -1;
            }
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                if (mediaModel.equals(a.get(i))) {
                    return i;
                }
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public static boolean f(MediaModel mediaModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, mediaModel)) == null) {
            ArrayList<MediaModel> arrayList = a;
            if (arrayList == null) {
                return false;
            }
            return arrayList.contains(mediaModel);
        }
        return invokeL.booleanValue;
    }

    public static boolean g(MediaModel mediaModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, mediaModel)) == null) {
            ArrayList<MediaModel> arrayList = a;
            if (arrayList != null && arrayList.size() != 0) {
                return a.contains(mediaModel);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void h(MediaModel mediaModel) {
        ArrayList<MediaModel> arrayList;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65543, null, mediaModel) == null) && (arrayList = a) != null) {
            arrayList.remove(mediaModel);
        }
    }

    public static void i(MediaModel mediaModel) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65544, null, mediaModel) != null) || mediaModel == null) {
            return;
        }
        if (a == null) {
            a = new ArrayList<>();
        }
        a.add(mediaModel);
    }
}
