package com.baidu.tieba;

import com.baidu.tbadk.core.data.BdToastData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import tbclient.Toast;
import tbclient.ToastContent;
/* loaded from: classes4.dex */
public class gl9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static BdToastData a(Toast toast) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, toast)) == null) {
            if (toast == null) {
                return null;
            }
            BdToastData bdToastData = new BdToastData();
            bdToastData.setIconType(toast.icon_type.intValue());
            ArrayList arrayList = new ArrayList();
            for (ToastContent toastContent : toast.content) {
                if (toastContent != null) {
                    BdToastData.ContentBean contentBean = new BdToastData.ContentBean();
                    contentBean.setText(toastContent.text);
                    contentBean.setHasColor(toastContent.has_color.intValue());
                    arrayList.add(contentBean);
                }
            }
            bdToastData.setContent(arrayList);
            bdToastData.setUrl(toast.url);
            bdToastData.setBackground(toast.background);
            return bdToastData;
        }
        return (BdToastData) invokeL.objValue;
    }
}
