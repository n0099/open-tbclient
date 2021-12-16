package com.baidu.tieba.flutter.plugin.imagePicker;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
/* loaded from: classes12.dex */
public class PostAsyncTask extends BdAsyncTask<String, Object, ResultData> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String barId;
    public PostCallback callback;
    public String url;

    /* loaded from: classes12.dex */
    public interface PostCallback {
        void onFailure(ResultData resultData);

        void onSuccess(ResultData resultData);
    }

    /* loaded from: classes12.dex */
    public static class ResultData extends OrmObject implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int error_code;
        public String error_msg;
        public String url;

        public ResultData() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.error_code = 0;
            this.error_msg = "";
            this.url = "";
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return "ResultData{error_code=" + this.error_code + ", error_msg='" + this.error_msg + ExtendedMessageFormat.QUOTE + ExtendedMessageFormat.END_FE;
            }
            return (String) invokeV.objValue;
        }
    }

    public PostAsyncTask(String str, String str2, PostCallback postCallback) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, postCallback};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.url = str;
        this.barId = str2;
        this.callback = postCallback;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public ResultData doInBackground(String... strArr) {
        InterceptResult invokeL;
        ResultData resultData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, strArr)) == null) {
            NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + "c/c/bawu/updateAvatar");
            netWork.addPostData("forum_id", this.barId);
            netWork.addPostData("avatar", this.url);
            netWork.addPostData(HttpRequest.TBS, TbadkCoreApplication.getInst().getTbs());
            String postNetData = netWork.postNetData();
            if (netWork.getNetContext().getResponse().isRequestSuccess()) {
                try {
                    resultData = (ResultData) OrmObject.objectWithJsonStr(postNetData, ResultData.class);
                } catch (Exception e2) {
                    BdLog.detailException(e2);
                    resultData = new ResultData();
                    resultData.error_code = -1000;
                }
            } else {
                ResultData resultData2 = new ResultData();
                resultData2.error_code = netWork.getServerErrorCode();
                resultData2.error_msg = netWork.getErrorString();
                resultData = resultData2;
            }
            resultData.url = this.url;
            return resultData;
        }
        return (ResultData) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPostExecute(ResultData resultData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, resultData) == null) {
            super.onPostExecute((PostAsyncTask) resultData);
            if (resultData.error_code == 0) {
                this.callback.onSuccess(resultData);
            } else {
                this.callback.onFailure(resultData);
            }
        }
    }
}
