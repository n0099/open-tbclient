package com.baidu.tieba.im.model;

import android.graphics.Bitmap;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.b9;
import java.io.Serializable;
/* loaded from: classes3.dex */
public class LocalPicModel extends BdBaseModel implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = -339604626740227228L;
    public transient /* synthetic */ FieldHolder $fh;
    public String mDName;
    public String mDPath;
    public GetImageTask mImageTask;
    public String mSName;
    public String mSPath;

    /* renamed from: com.baidu.tieba.im.model.LocalPicModel$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes3.dex */
    public class GetImageTask extends BdAsyncTask<Object, Integer, ResponseData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LocalPicModel this$0;

        public GetImageTask(LocalPicModel localPicModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {localPicModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = localPicModel;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                super.cancel(true);
                this.this$0.mImageTask = null;
            }
        }

        public /* synthetic */ GetImageTask(LocalPicModel localPicModel, AnonymousClass1 anonymousClass1) {
            this(localPicModel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public ResponseData doInBackground(Object... objArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, objArr)) == null) {
                String str = "im_" + String.valueOf(System.currentTimeMillis());
                String renameTo = FileHelper.renameTo(this.this$0.mSPath, this.this$0.mSName, TiebaIMConfig.POST_IMAGE_PATH, str + "_send");
                String str2 = str + "_display";
                String renameTo2 = FileHelper.renameTo(this.this$0.mDPath, this.this$0.mDName, TiebaIMConfig.POST_IMAGE_PATH, str2);
                Bitmap image = FileHelper.getImage(TiebaIMConfig.POST_IMAGE_PATH, str2);
                if (renameTo == null || renameTo2 == null || image == null) {
                    return null;
                }
                return new ResponseData(image, renameTo, renameTo2);
            }
            return (ResponseData) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(ResponseData responseData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, responseData) == null) {
                super.onPostExecute((GetImageTask) responseData);
                this.this$0.mImageTask = null;
                if (this.this$0.mLoadDataCallBack != null) {
                    this.this$0.mLoadDataCallBack.c(responseData);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class ResponseData implements Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -9099542245580007084L;
        public transient /* synthetic */ FieldHolder $fh;
        public Bitmap mBitmap;
        public String mDPathGen;
        public String mSPathGen;

        public ResponseData(Bitmap bitmap, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bitmap, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mBitmap = null;
            this.mSPathGen = null;
            this.mDPathGen = null;
            this.mBitmap = bitmap;
            this.mSPathGen = str;
            this.mDPathGen = str2;
        }

        public Bitmap getBitmap() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mBitmap : (Bitmap) invokeV.objValue;
        }

        public String getDPathGen() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mDPathGen : (String) invokeV.objValue;
        }

        public String getSPathGen() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mSPathGen : (String) invokeV.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LocalPicModel(String str, String str2, String str3, String str4) {
        super(null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, str3, str4};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((b9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mImageTask = null;
        this.mSPath = null;
        this.mSName = null;
        this.mDPath = null;
        this.mDName = null;
        this.mSPath = str;
        this.mSName = str2;
        this.mDPath = str3;
        this.mDName = str4;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            GetImageTask getImageTask = this.mImageTask;
            if (getImageTask != null) {
                getImageTask.cancel();
                return true;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.mImageTask != null) {
                return false;
            }
            GetImageTask getImageTask = new GetImageTask(this, null);
            this.mImageTask = getImageTask;
            getImageTask.setSelfExecute(true);
            this.mImageTask.execute(new Object[0]);
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }
}
