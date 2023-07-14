package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.pf5;
import com.baidu.tieba.vc8;
import com.baidu.tieba.yi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes6.dex */
public class OfficialBarTipListAdapter extends vc8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.vc8
    public boolean g(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, imMessageCenterShowItemData)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.vc8
    public boolean h(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, imMessageCenterShowItemData)) == null) {
            return true;
        }
        return invokeL.booleanValue;
    }

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

    @Override // com.baidu.tieba.vc8
    public void k(vc8.a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, aVar, imMessageCenterShowItemData) == null) {
            aVar.b.setVisibility(8);
            aVar.d.setVisibility(0);
            aVar.d.setShowOval(true);
            aVar.d.setAutoChangeStyle(true);
            aVar.d.setStrokeWith(yi.g(this.a, R.dimen.tbds1));
            aVar.d.setStrokeColorResId(R.color.CAM_X0401);
            aVar.d.setTag(null);
            aVar.d.setPlaceHolder(1);
            if (!TextUtils.isEmpty(imMessageCenterShowItemData.getFriendPortrait())) {
                aVar.d.setTag(imMessageCenterShowItemData.getFriendPortrait());
                aVar.d.N(imMessageCenterShowItemData.getFriendPortrait(), 10, false);
            }
        }
    }

    @Override // com.baidu.tieba.vc8
    public void o(vc8.a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, aVar, imMessageCenterShowItemData) == null) {
            aVar.e.setText(this.a.getString(R.string.chosen_pb_original_bar, imMessageCenterShowItemData.getFriendName()));
        }
    }

    @Override // com.baidu.tieba.vc8
    public void s(vc8.a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, aVar, imMessageCenterShowItemData) == null) {
            aVar.i.setVisibility(8);
            SkinManager.setViewTextColor(aVar.e, R.color.CAM_X0105, 1);
            SkinManager.setViewTextColor(aVar.g, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(aVar.h, R.color.CAM_X0109, 1);
        }
    }

    @Override // com.baidu.tieba.vc8
    public void v(vc8.a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, aVar, imMessageCenterShowItemData) == null) {
            aVar.f.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.vc8
    public BasicNameValuePair z(ImMessageCenterShowItemData imMessageCenterShowItemData, int i, String str) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048582, this, imMessageCenterShowItemData, i, str)) == null) {
            String str2 = "";
            int i2 = 0;
            if (!pf5.d().o()) {
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
