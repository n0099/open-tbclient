package com.baidu.tbadk.data;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.List;
import tbclient.Loop.MemberBroadcastInfo;
import tbclient.PbContent;
/* loaded from: classes4.dex */
public class MemberBroadcastData implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static long serialVersionUID = 5874348634746288330L;
    public transient /* synthetic */ FieldHolder $fh;
    public String backgroundSrc;
    public int broadcastType;
    public String btnBackgroundColor;
    public String btnTextColor;
    public int dailyMaxNum;
    public int dailyMinStep;
    public int leftIconHeight;
    public String leftIconSrc;
    public int leftIconWidth;
    public List<PbContent> middleContent;
    public int omMaxNum;
    public int omMinStep;
    public String rightBtnText;
    public String rightBtnUrl;
    public int sceneCondition;
    public int showTime;
    public TbRichText tbRichText;
    public String textColor;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-20895476, "Lcom/baidu/tbadk/data/MemberBroadcastData;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-20895476, "Lcom/baidu/tbadk/data/MemberBroadcastData;");
        }
    }

    public MemberBroadcastData() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public String getBackgroundSrc() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.backgroundSrc;
        }
        return (String) invokeV.objValue;
    }

    public int getBroadcastType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.broadcastType;
        }
        return invokeV.intValue;
    }

    public String getBtnBackgroundColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.btnBackgroundColor;
        }
        return (String) invokeV.objValue;
    }

    public String getBtnTextColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.btnTextColor;
        }
        return (String) invokeV.objValue;
    }

    public int getDailyMaxNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.dailyMaxNum;
        }
        return invokeV.intValue;
    }

    public int getDailyMinStep() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.dailyMinStep;
        }
        return invokeV.intValue;
    }

    public int getLeftIconHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.leftIconHeight;
        }
        return invokeV.intValue;
    }

    public String getLeftIconSrc() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.leftIconSrc;
        }
        return (String) invokeV.objValue;
    }

    public int getLeftIconWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.leftIconWidth;
        }
        return invokeV.intValue;
    }

    public List<PbContent> getMiddleContent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.middleContent;
        }
        return (List) invokeV.objValue;
    }

    public int getOmMaxNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.omMaxNum;
        }
        return invokeV.intValue;
    }

    public int getOmMinStep() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.omMinStep;
        }
        return invokeV.intValue;
    }

    public String getRightBtnText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.rightBtnText;
        }
        return (String) invokeV.objValue;
    }

    public String getRightBtnUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.rightBtnUrl;
        }
        return (String) invokeV.objValue;
    }

    public int getSceneCondition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.sceneCondition;
        }
        return invokeV.intValue;
    }

    public int getShowTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.showTime;
        }
        return invokeV.intValue;
    }

    public TbRichText getTbRichText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.tbRichText;
        }
        return (TbRichText) invokeV.objValue;
    }

    public String getTextColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.textColor;
        }
        return (String) invokeV.objValue;
    }

    private void parseMiddleContent(List<PbContent> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65538, this, list) != null) || ListUtils.isEmpty(list)) {
            return;
        }
        this.tbRichText = TbRichTextView.c0(list, false);
    }

    public void setBackgroundSrc(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            this.backgroundSrc = str;
        }
    }

    public void setBroadcastType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i) == null) {
            this.broadcastType = i;
        }
    }

    public void setBtnBackgroundColor(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, str) == null) {
            this.btnBackgroundColor = str;
        }
    }

    public void setBtnTextColor(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, str) == null) {
            this.btnTextColor = str;
        }
    }

    public void setDailyMaxNum(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i) == null) {
            this.dailyMaxNum = i;
        }
    }

    public void setDailyMinStep(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i) == null) {
            this.dailyMinStep = i;
        }
    }

    public void setLeftIconHeight(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i) == null) {
            this.leftIconHeight = i;
        }
    }

    public void setLeftIconSrc(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, str) == null) {
            this.leftIconSrc = str;
        }
    }

    public void setLeftIconWidth(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048603, this, i) == null) {
            this.leftIconWidth = i;
        }
    }

    public void setMiddleContent(List<PbContent> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, list) == null) {
            this.middleContent = list;
        }
    }

    public void setOmMaxNum(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048605, this, i) == null) {
            this.omMaxNum = i;
        }
    }

    public void setOmMinStep(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048606, this, i) == null) {
            this.omMinStep = i;
        }
    }

    public void setRightBtnText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, str) == null) {
            this.rightBtnText = str;
        }
    }

    public void setRightBtnUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, str) == null) {
            this.rightBtnUrl = str;
        }
    }

    public void setSceneCondition(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048609, this, i) == null) {
            this.sceneCondition = i;
        }
    }

    public void setShowTime(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048610, this, i) == null) {
            this.showTime = i;
        }
    }

    public void setTbRichText(TbRichText tbRichText) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, tbRichText) == null) {
            this.tbRichText = tbRichText;
        }
    }

    public void setTextColor(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, str) == null) {
            this.textColor = str;
        }
    }

    public void parseProtobuf(MemberBroadcastInfo memberBroadcastInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048594, this, memberBroadcastInfo) != null) || memberBroadcastInfo == null) {
            return;
        }
        this.leftIconSrc = memberBroadcastInfo.left_icon_src;
        this.leftIconWidth = memberBroadcastInfo.left_icon_width.intValue();
        this.leftIconHeight = memberBroadcastInfo.left_icon_height.intValue();
        this.backgroundSrc = memberBroadcastInfo.background_src;
        List<PbContent> list = memberBroadcastInfo.middle_content;
        this.middleContent = list;
        parseMiddleContent(list);
        this.rightBtnText = memberBroadcastInfo.right_btn_text;
        this.rightBtnUrl = memberBroadcastInfo.right_btn_url;
        this.textColor = memberBroadcastInfo.text_color;
        this.broadcastType = memberBroadcastInfo.broadcast_type.intValue();
        this.dailyMinStep = memberBroadcastInfo.daily_min_step.intValue();
        this.dailyMaxNum = memberBroadcastInfo.daily_max_num.intValue();
        this.omMinStep = memberBroadcastInfo.om_min_step.intValue();
        this.omMaxNum = memberBroadcastInfo.om_max_num.intValue();
        this.sceneCondition = memberBroadcastInfo.scene_condition.intValue();
        this.showTime = memberBroadcastInfo.show_time.intValue();
        this.btnTextColor = memberBroadcastInfo.btn_text_color;
        this.btnBackgroundColor = memberBroadcastInfo.btn_background_color;
    }
}
