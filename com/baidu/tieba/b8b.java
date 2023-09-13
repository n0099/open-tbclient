package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.data.VideoCategoryClassData;
import com.baidu.tieba.write.write.work.classdialog.model.GetSelectClassReqMessage;
import com.baidu.tieba.write.write.work.selecttag.model.GetSelectTagReqMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class b8b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<String> a;
    public List<List<String>> b;
    public VideoCategoryClassData c;
    public BdUniqueId d;

    public b8b(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new ArrayList();
        this.b = new ArrayList();
        this.c = new VideoCategoryClassData();
        this.d = bdUniqueId;
    }

    public VideoCategoryClassData a(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048576, this, i, i2)) == null) {
            this.c.setFirstClass(this.a.get(i));
            this.c.setSecondClass(this.b.get(i).get(i2));
            this.c.getTags().clear();
            return this.c;
        }
        return (VideoCategoryClassData) invokeII.objValue;
    }

    public List<String> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.a;
        }
        return (List) invokeV.objValue;
    }

    public List<List<String>> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.b;
        }
        return (List) invokeV.objValue;
    }

    public ArrayList<String> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.c.getTags();
        }
        return (ArrayList) invokeV.objValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            GetSelectClassReqMessage getSelectClassReqMessage = new GetSelectClassReqMessage();
            getSelectClassReqMessage.setTag(this.d);
            MessageManager.getInstance().sendMessage(getSelectClassReqMessage);
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            GetSelectTagReqMessage getSelectTagReqMessage = new GetSelectTagReqMessage();
            getSelectTagReqMessage.setTag(this.d);
            getSelectTagReqMessage.setFirstClass(this.c.getFirstClass());
            getSelectTagReqMessage.setSecondClass(this.c.getSecondClass());
            MessageManager.getInstance().sendMessage(getSelectTagReqMessage);
        }
    }

    public void g(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, list) == null) {
            this.a.clear();
            this.a.addAll(list);
        }
    }

    public void h(List<List<String>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
            this.b.clear();
            this.b.addAll(list);
        }
    }

    public void i(VideoCategoryClassData videoCategoryClassData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, videoCategoryClassData) == null) {
            this.c = videoCategoryClassData;
        }
    }
}
