package com.baidu.tieba.controller;

import android.location.Location;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.data.TransmitForumData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.tt6;
import com.baidu.tieba.xw5;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes5.dex */
public class TransmitShareController implements tt6.a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int FROM_ENTERFORUM = 1;
    public static final int FROM_SELECTFORUM = 2;
    public static TransmitShareController mInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean isEnterForumDataLoaded;
    public boolean isLoading;
    public boolean isSelectForumDataLoaded;
    public ArrayList<TransmitForumData> mEnterForumData;
    public ArrayList<TransmitForumData> mForumList;
    public tt6 mGetEnterForumDataController;
    public int mPrivateThread;
    public tt6 mSelectForumController;
    public ArrayList<TransmitForumData> mSelectForumData;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1857373237, "Lcom/baidu/tieba/controller/TransmitShareController;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1857373237, "Lcom/baidu/tieba/controller/TransmitShareController;");
        }
    }

    public static Location getForeverNullLocation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return null;
        }
        return (Location) invokeV.objValue;
    }

    public TransmitShareController() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mForumList = new ArrayList<>();
        this.isSelectForumDataLoaded = false;
        this.isEnterForumDataLoaded = false;
        this.isLoading = false;
        init();
    }

    private void initGetEnterForumController() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, this) == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2016562), tt6.class);
            if (runTask != null) {
                this.mGetEnterForumDataController = (tt6) runTask.getData();
            }
            tt6 tt6Var = this.mGetEnterForumDataController;
            if (tt6Var != null) {
                tt6Var.a(this);
            }
        }
    }

    private void initSelectForumController() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001449), tt6.class);
            if (runTask != null) {
                this.mSelectForumController = (tt6) runTask.getData();
            }
            tt6 tt6Var = this.mSelectForumController;
            if (tt6Var != null) {
                tt6Var.a(this);
            }
        }
    }

    public static TransmitShareController getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (mInstance == null) {
                synchronized (TransmitShareController.class) {
                    if (mInstance == null) {
                        mInstance = new TransmitShareController();
                    }
                }
            }
            return mInstance;
        }
        return (TransmitShareController) invokeV.objValue;
    }

    private Location getLocation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            return getForeverNullLocation();
        }
        return (Location) invokeV.objValue;
    }

    private void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, this) == null) {
            initSelectForumController();
            initGetEnterForumController();
            this.isLoading = false;
        }
    }

    private void sendDataLoadedMessage() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016563, this.mForumList));
        }
    }

    public void loadRepostForums() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.isLoading = true;
            tt6 tt6Var = this.mSelectForumController;
            if (tt6Var != null) {
                tt6Var.b();
            }
            tt6 tt6Var2 = this.mGetEnterForumDataController;
            if (tt6Var2 != null) {
                tt6Var2.b();
            }
        }
    }

    private boolean isForumExists(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65544, this, j)) == null) {
            ArrayList<TransmitForumData> arrayList = this.mForumList;
            if (arrayList == null) {
                return false;
            }
            Iterator<TransmitForumData> it = arrayList.iterator();
            while (it.hasNext()) {
                TransmitForumData next = it.next();
                if (next != null && next.forumId == j) {
                    return true;
                }
            }
            return false;
        }
        return invokeJ.booleanValue;
    }

    private void processData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            if (this.mSelectForumController == null || this.isSelectForumDataLoaded) {
                if (this.mGetEnterForumDataController == null || this.isEnterForumDataLoaded) {
                    this.isSelectForumDataLoaded = false;
                    this.isEnterForumDataLoaded = false;
                    this.isLoading = false;
                    this.mForumList.clear();
                    if (!ListUtils.isEmpty(this.mSelectForumData)) {
                        Iterator<TransmitForumData> it = this.mSelectForumData.iterator();
                        while (it.hasNext()) {
                            TransmitForumData next = it.next();
                            if (!isForumExists(next.forumId)) {
                                this.mForumList.add(next);
                            }
                        }
                    }
                    if (!ListUtils.isEmpty(this.mEnterForumData)) {
                        Iterator<TransmitForumData> it2 = this.mEnterForumData.iterator();
                        while (it2.hasNext()) {
                            TransmitForumData next2 = it2.next();
                            if (!isForumExists(next2.forumId)) {
                                this.mForumList.add(next2);
                            }
                        }
                    }
                    this.mSelectForumData = null;
                    this.mEnterForumData = null;
                    sendDataLoadedMessage();
                }
            }
        }
    }

    @Override // com.baidu.tieba.tt6.a
    public void callback(ArrayList<TransmitForumData> arrayList, boolean z, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{arrayList, Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2)}) == null) {
            if (i == 1) {
                if (z) {
                    this.mEnterForumData = arrayList;
                }
                this.isEnterForumDataLoaded = true;
            } else if (i == 2) {
                if (z) {
                    this.mSelectForumData = arrayList;
                    this.mPrivateThread = i2;
                }
                this.isSelectForumDataLoaded = true;
            }
            processData();
        }
    }

    public void showShareDialog(ShareDialogConfig shareDialogConfig) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, shareDialogConfig) != null) || shareDialogConfig == null || shareDialogConfig.shareItem == null || xw5.a()) {
            return;
        }
        if (shareDialogConfig.showLocation) {
            shareDialogConfig.shareItem.location = getLocation();
        }
        if (BdUtilHelper.isNetOk() && TbadkCoreApplication.isLogin() && !shareDialogConfig.mIsAlaLive && !this.isLoading && shareDialogConfig.shareItem.isShowForumShareItem()) {
            loadRepostForums();
        }
        shareDialogConfig.setIsShowTransmitShare(true);
        shareDialogConfig.setTransmitForumList(this.mForumList);
        shareDialogConfig.setPrivateThread(this.mPrivateThread);
        MessageManager.getInstance().sendMessage(new CustomMessage(2001276, shareDialogConfig));
    }
}
