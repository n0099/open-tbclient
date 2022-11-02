package com.baidu.tieba.im.mygroup;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.im.message.GroupsByUidLocalMessage;
import com.baidu.tieba.im.message.GroupsByUidMessage;
import com.baidu.tieba.im.message.RequestUserPermissionMessage;
import com.baidu.tieba.r9;
import com.baidu.tieba.xi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class PersonGroupModel extends BdBaseModel<BaseFragmentActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public RequestUserPermissionMessage a;
    public boolean b;
    public long friendUid;
    public int mImageHeight;
    public int mImageWidth;

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PersonGroupModel(PersonGroupActivity personGroupActivity) {
        super(personGroupActivity.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {personGroupActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((r9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = false;
        this.mImageWidth = xi.d(TbadkApplication.getInst().getContext(), 70.0f);
        this.mImageHeight = xi.d(TbadkApplication.getInst().getContext(), 70.0f);
        this.friendUid = 0L;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PersonGroupModel(PersonGroupActivity personGroupActivity, long j) {
        super(personGroupActivity.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {personGroupActivity, Long.valueOf(j)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((r9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = false;
        this.mImageWidth = xi.d(TbadkApplication.getInst().getContext(), 70.0f);
        this.mImageHeight = xi.d(TbadkApplication.getInst().getContext(), 70.0f);
        this.friendUid = j;
    }

    public void A(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
            RequestUserPermissionMessage z = z(j);
            this.a = z;
            super.sendMessage(z);
        }
    }

    public final RequestUserPermissionMessage z(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048581, this, j)) == null) {
            RequestUserPermissionMessage requestUserPermissionMessage = new RequestUserPermissionMessage();
            requestUserPermissionMessage.setForumId(j);
            return requestUserPermissionMessage;
        }
        return (RequestUserPermissionMessage) invokeJ.objValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void cancelMessage() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.cancelMessage();
            this.a = null;
        }
    }

    public void update() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (this.friendUid == 0) {
                if (this.b) {
                    super.sendMessage(new GroupsByUidMessage(this.mImageWidth, this.mImageHeight));
                    return;
                }
                this.b = true;
                super.sendMessage(new GroupsByUidLocalMessage());
                return;
            }
            super.sendMessage(new GroupsByUidMessage(this.friendUid, this.mImageWidth, this.mImageHeight));
        }
    }
}
