package com.baidu.tbadk.data;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.ri6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import tbclient.CardLinkInfo;
/* loaded from: classes3.dex */
public class CardLinkInfoData extends ri6 implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ARROW_BTN_STYLE = "2";
    public static final String DEL_BTN_STYLE = "3";
    public static final String NO_BTN_STYLE = "0";
    public static final String TEXT_BTN_DISABLE_STATUS = "2";
    public static final String TEXT_BTN_NORMAL_STATUS = "0";
    public static final String TEXT_BTN_STALE_STATUS = "1";
    public static final String TEXT_BTN_STYLE = "1";
    public transient /* synthetic */ FieldHolder $fh;
    public String btnStyle;
    public String btnText;
    public String content1;
    public String content2;
    public String imageUrl;
    public String tagColor;
    public String tagText;
    public String textBtnStatus;
    public String title;
    public String type;
    public String url;

    @Override // com.baidu.tieba.ri6
    public int sort() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return Integer.MAX_VALUE;
        }
        return invokeV.intValue;
    }

    public CardLinkInfoData() {
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

    public String getBtnStyle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.btnStyle;
        }
        return (String) invokeV.objValue;
    }

    public String getBtnText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.btnText;
        }
        return (String) invokeV.objValue;
    }

    public String getContent1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.content1;
        }
        return (String) invokeV.objValue;
    }

    public String getContent2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.content2;
        }
        return (String) invokeV.objValue;
    }

    public String getImageUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.imageUrl;
        }
        return (String) invokeV.objValue;
    }

    public String getTagColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.tagColor;
        }
        return (String) invokeV.objValue;
    }

    public String getTagText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.tagText;
        }
        return (String) invokeV.objValue;
    }

    public String getTextBtnStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.textBtnStatus;
        }
        return (String) invokeV.objValue;
    }

    public String getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.title;
        }
        return (String) invokeV.objValue;
    }

    public String getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.type;
        }
        return (String) invokeV.objValue;
    }

    public String getUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.url;
        }
        return (String) invokeV.objValue;
    }

    public void parse(CardLinkInfo cardLinkInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048587, this, cardLinkInfo) != null) || cardLinkInfo == null) {
            return;
        }
        this.type = cardLinkInfo.type;
        this.imageUrl = cardLinkInfo.image_url;
        this.tagText = cardLinkInfo.tag_text;
        this.tagColor = cardLinkInfo.tag_color;
        this.title = cardLinkInfo.title;
        this.content1 = cardLinkInfo.content1;
        this.content2 = cardLinkInfo.content2;
        this.btnStyle = cardLinkInfo.btn_style;
        this.btnText = cardLinkInfo.btn_text;
        this.textBtnStatus = cardLinkInfo.text_btn_status;
        this.url = cardLinkInfo.url;
    }

    public void setBtnStyle(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            this.btnStyle = str;
        }
    }

    public void setBtnText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            this.btnText = str;
        }
    }

    public void setContent1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            this.content1 = str;
        }
    }

    public void setContent2(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            this.content2 = str;
        }
    }

    public void setImageUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            this.imageUrl = str;
        }
    }

    public void setTagColor(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            this.tagColor = str;
        }
    }

    public void setTagText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            this.tagText = str;
        }
    }

    public void setTextBtnStatus(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            this.textBtnStatus = str;
        }
    }

    public void setTitle(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            this.title = str;
        }
    }

    public void setType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, str) == null) {
            this.type = str;
        }
    }

    public void setUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, str) == null) {
            this.url = str;
        }
    }
}
