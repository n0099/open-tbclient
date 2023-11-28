package com.baidu.tieba.im.base.core.inputtool.robotfloor.adapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.bn8;
import com.baidu.tieba.im.base.core.chatbox.adapter.ChatRoomRecycleAdapter;
import com.baidu.tieba.to8;
import com.baidu.tieba.uo8;
import com.baidu.tieba.vo8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class RobotItemIm extends bn8 implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = -5589601297540632738L;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean isShowHeadView;
    public RecyclerView.Adapter mAdapter;
    public List<bn8> mSubItems;
    public String roboatName;
    public String robortAvatar;
    public String robotUk;

    @Override // com.baidu.tieba.bn8
    public int getViewType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return 4;
        }
        return invokeV.intValue;
    }

    public RobotItemIm(List<bn8> list, @NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull TbPageContext tbPageContext, to8 to8Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list, str, str2, str3, tbPageContext, to8Var, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mSubItems = new ArrayList();
        this.isShowHeadView = z;
        this.roboatName = str2;
        this.robortAvatar = str;
        this.robotUk = str3;
        uo8 uo8Var = new uo8(tbPageContext);
        if (!ListUtils.isEmpty(list)) {
            this.mSubItems.addAll(list);
        }
        this.mAdapter = new ChatRoomRecycleAdapter(new vo8(to8Var), uo8Var, tbPageContext);
        uo8Var.a(getSubItems());
    }

    public RecyclerView.Adapter getAdapter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.mAdapter;
        }
        return (RecyclerView.Adapter) invokeV.objValue;
    }

    public String getRoboatName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.roboatName;
        }
        return (String) invokeV.objValue;
    }

    public String getRobortAvatar() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.robortAvatar;
        }
        return (String) invokeV.objValue;
    }

    @NonNull
    public String getRobotUk() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.robotUk;
        }
        return (String) invokeV.objValue;
    }

    public List<bn8> getSubItems() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.mSubItems;
        }
        return (List) invokeV.objValue;
    }

    public boolean isShowHeadView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.isShowHeadView;
        }
        return invokeV.booleanValue;
    }

    public void setShowHeadView(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.isShowHeadView = z;
        }
    }
}
