package com.baidu.tbadk.mainTab.dynamicIcon;

import android.app.Activity;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.toolbar.CommonToolbarStatisticConstants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.jk5;
import com.baidu.tieba.kk5;
import com.baidu.tieba.ny0;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class MainTabBottomDynamicIconManager implements kk5 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG_CHANNEL = "channel";
    public static final String TAG_ENTER_FORUM = "enterForum";
    public static final String TAG_HOME_PAGE = "homePage";
    public static final String TAG_MESSAGE = "message";
    public static final String TAG_PERSON = "person";
    public static final String TAG_STYLE = "style";
    public static final String TAG_WRITE = "write";
    public transient /* synthetic */ FieldHolder $fh;
    public int hasShowHashCode;
    public ConcurrentHashMap<String, DynamicIconData> mIconDataMap;
    public boolean mIsAllIconLoadedFinished;
    public long mShowEndTime;
    public long mShowStartTime;

    /* loaded from: classes5.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public static final MainTabBottomDynamicIconManager a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(78558575, "Lcom/baidu/tbadk/mainTab/dynamicIcon/MainTabBottomDynamicIconManager$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(78558575, "Lcom/baidu/tbadk/mainTab/dynamicIcon/MainTabBottomDynamicIconManager$a;");
                    return;
                }
            }
            a = new MainTabBottomDynamicIconManager();
        }
    }

    public MainTabBottomDynamicIconManager() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mIconDataMap = new ConcurrentHashMap<>();
    }

    public static final MainTabBottomDynamicIconManager getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return a.a;
        }
        return (MainTabBottomDynamicIconManager) invokeV.objValue;
    }

    public boolean canShowDynamicIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            if (this.mIsAllIconLoadedFinished && currentTimeMillis > getShowStartTime() && currentTimeMillis < getShowEndTime()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean checkIsHasShowIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (ny0.c(this.mIconDataMap) || this.hasShowHashCode != this.mIconDataMap.hashCode()) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public Map<String, DynamicIconData> getIconDataMap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.mIconDataMap;
        }
        return (Map) invokeV.objValue;
    }

    public long getShowEndTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.mShowEndTime;
        }
        return invokeV.longValue;
    }

    public long getShowStartTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.mShowStartTime;
        }
        return invokeV.longValue;
    }

    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.mIconDataMap.clear();
            this.hasShowHashCode = 0;
            this.mShowStartTime = 0L;
            this.mShowEndTime = 0L;
            this.mIsAllIconLoadedFinished = false;
        }
    }

    public DynamicIconData getIconData(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            return this.mIconDataMap.get(str);
        }
        return (DynamicIconData) invokeL.objValue;
    }

    public void setHasShowIconHash(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            this.hasShowHashCode = i;
        }
    }

    public jk5 getValidDynamicStyle() {
        InterceptResult invokeV;
        jk5 dynamicStyleData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            DynamicIconData iconData = getInstance().getIconData("style");
            if (iconData != null && (dynamicStyleData = iconData.getDynamicStyleData()) != null && StringUtils.isNotNull(dynamicStyleData.b()) && StringUtils.isNotNull(dynamicStyleData.c()) && StringUtils.isNotNull(dynamicStyleData.a())) {
                return dynamicStyleData;
            }
            return null;
        }
        return (jk5) invokeV.objValue;
    }

    public void loadImages() {
        BdUniqueId bdUniqueId;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            if (currentActivity instanceof BaseActivity) {
                bdUniqueId = ((BaseActivity) currentActivity).getUniqueId();
            } else if (currentActivity instanceof BaseFragmentActivity) {
                bdUniqueId = ((BaseFragmentActivity) currentActivity).getUniqueId();
            } else {
                bdUniqueId = null;
            }
            for (Map.Entry<String, DynamicIconData> entry : this.mIconDataMap.entrySet()) {
                if (entry.getValue() != null) {
                    entry.getValue().setMainTabPageId(bdUniqueId);
                    entry.getValue().setIconLoadedFinishCallback(this);
                    entry.getValue().loadImages();
                }
            }
        }
    }

    @Override // com.baidu.tieba.kk5
    public void onIconLoadedFinish() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            Iterator<Map.Entry<String, DynamicIconData>> it = this.mIconDataMap.entrySet().iterator();
            while (true) {
                if (it.hasNext()) {
                    Map.Entry<String, DynamicIconData> next = it.next();
                    if (next.getValue() != null && !next.getValue().isAllStatusIconLoadedFinish()) {
                        z = false;
                        break;
                    }
                } else {
                    z = true;
                    break;
                }
            }
            this.mIsAllIconLoadedFinished = z;
            if (z) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921551, Boolean.TRUE));
            }
        }
    }

    public void parseJson(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, jSONObject) == null) {
            this.mIconDataMap.clear();
            this.mShowStartTime = jSONObject.optLong("start_time");
            this.mShowEndTime = jSONObject.optLong("end_time");
            JSONObject optJSONObject = jSONObject.optJSONObject("feed");
            if (optJSONObject != null) {
                DynamicIconData dynamicIconData = new DynamicIconData();
                dynamicIconData.parse(optJSONObject);
                this.mIconDataMap.put("homePage", dynamicIconData);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("forum");
            if (optJSONObject2 != null) {
                DynamicIconData dynamicIconData2 = new DynamicIconData();
                dynamicIconData2.parse(optJSONObject2);
                this.mIconDataMap.put(TAG_ENTER_FORUM, dynamicIconData2);
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("channel");
            if (optJSONObject3 != null) {
                DynamicIconData dynamicIconData3 = new DynamicIconData();
                dynamicIconData3.parse(optJSONObject3);
                this.mIconDataMap.put("channel", dynamicIconData3);
            }
            JSONObject optJSONObject4 = jSONObject.optJSONObject(CommonToolbarStatisticConstants.TOOLBAR_MENU_NEW_DETAIL_BROWSER);
            if (optJSONObject4 != null) {
                DynamicIconData dynamicIconData4 = new DynamicIconData();
                dynamicIconData4.parse(optJSONObject4);
                this.mIconDataMap.put("message", dynamicIconData4);
            }
            JSONObject optJSONObject5 = jSONObject.optJSONObject("personal");
            if (optJSONObject5 != null) {
                DynamicIconData dynamicIconData5 = new DynamicIconData();
                dynamicIconData5.parse(optJSONObject5);
                this.mIconDataMap.put("person", dynamicIconData5);
            }
            JSONObject optJSONObject6 = jSONObject.optJSONObject("write");
            if (optJSONObject6 != null) {
                DynamicIconData dynamicIconData6 = new DynamicIconData();
                dynamicIconData6.parse(optJSONObject6);
                this.mIconDataMap.put("write", dynamicIconData6);
            }
            JSONObject optJSONObject7 = jSONObject.optJSONObject("style");
            if (optJSONObject7 != null) {
                DynamicIconData dynamicIconData7 = new DynamicIconData();
                dynamicIconData7.parse(optJSONObject7);
                this.mIconDataMap.put("style", dynamicIconData7);
            }
        }
    }
}
