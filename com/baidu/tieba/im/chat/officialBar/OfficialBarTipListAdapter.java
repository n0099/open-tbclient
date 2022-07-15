package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.pi;
import com.repackage.py4;
import com.repackage.v47;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes3.dex */
public class OfficialBarTipListAdapter extends v47 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OfficialBarTipListAdapter(OfficialBarTipActivity officialBarTipActivity) {
        super(officialBarTipActivity.getPageContext().getContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {officialBarTipActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.repackage.v47
    public boolean e(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, imMessageCenterShowItemData)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.repackage.v47
    public boolean f(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, imMessageCenterShowItemData)) == null) {
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.repackage.v47
    public void h(v47.a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, aVar, imMessageCenterShowItemData) == null) {
            aVar.b.setVisibility(8);
            aVar.d.setVisibility(0);
            aVar.d.setShowOval(true);
            aVar.d.setAutoChangeStyle(true);
            aVar.d.setStrokeWith(pi.f(this.a, R.dimen.tbds1));
            aVar.d.setStrokeColorResId(R.color.CAM_X0401);
            aVar.d.setTag(null);
            aVar.d.setPlaceHolder(1);
            if (TextUtils.isEmpty(imMessageCenterShowItemData.getFriendPortrait())) {
                return;
            }
            aVar.d.setTag(imMessageCenterShowItemData.getFriendPortrait());
            aVar.d.J(imMessageCenterShowItemData.getFriendPortrait(), 10, false);
        }
    }

    @Override // com.repackage.v47
    public void l(v47.a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, aVar, imMessageCenterShowItemData) == null) {
            aVar.e.setText(this.a.getString(R.string.obfuscated_res_0x7f0f03c7, imMessageCenterShowItemData.getFriendName()));
        }
    }

    @Override // com.repackage.v47
    public void p(v47.a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, aVar, imMessageCenterShowItemData) == null) {
            aVar.h.setVisibility(8);
            SkinManager.setViewTextColor(aVar.e, R.color.CAM_X0105, 1);
            SkinManager.setViewTextColor(aVar.f, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(aVar.g, R.color.CAM_X0109, 1);
        }
    }

    @Override // com.repackage.v47
    public BasicNameValuePair t(ImMessageCenterShowItemData imMessageCenterShowItemData, int i, String str) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048581, this, imMessageCenterShowItemData, i, str)) == null) {
            String str2 = "";
            int i2 = 0;
            if (!py4.d().n()) {
                str = "";
                i = 0;
            }
            if (imMessageCenterShowItemData.getGroupSetting().isAcceptNotify()) {
                i2 = i;
                str2 = str;
            }
            return new BasicNameValuePair(String.valueOf(i2), str2);
        }
        return (BasicNameValuePair) invokeLIL.objValue;
    }
}
