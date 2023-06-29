package com.baidu.tieba;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tieba.tbadkCore.videoupload.VideoFinishResult;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public abstract class b6a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public a6a a;
    public final String b;
    public final int c;
    public final long d;
    public final String e;
    public final int f;

    public abstract void a();

    public abstract boolean c();

    public abstract e6a g(ArrayList<Integer> arrayList, String str, int i);

    public b6a(String str, int i, int i2, long j, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), str2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = str;
        this.c = i2;
        this.d = j;
        this.e = str2;
        this.f = i;
    }

    public byte[] b(RandomAccessFile randomAccessFile, int i) {
        InterceptResult invokeLI;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, randomAccessFile, i)) == null) {
            if (randomAccessFile != null && i >= 0) {
                if (i == this.c) {
                    i2 = (int) (this.d - ((i - 1) * this.f));
                } else {
                    i2 = this.f;
                }
                byte[] bArr = new byte[i2];
                boolean z = false;
                try {
                    synchronized (randomAccessFile) {
                        randomAccessFile.seek((i - 1) * this.f);
                        if (randomAccessFile.read(bArr, 0, i2) != -1) {
                            z = true;
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (z) {
                    return bArr;
                }
            }
            return null;
        }
        return (byte[]) invokeLI.objValue;
    }

    public void d(int i) {
        a6a a6aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048579, this, i) == null) && (a6aVar = this.a) != null) {
            a6aVar.onProgressUpdate(i / 100.0f);
        }
    }

    public void f(a6a a6aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, a6aVar) == null) {
            this.a = a6aVar;
        }
    }

    public final String e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            if (StringUtils.isNull(str)) {
                return null;
            }
            try {
                JSONObject optJSONObject = new JSONObject(str).optJSONObject("data");
                if (optJSONObject != null) {
                    return optJSONObject.optString("video_url");
                }
            } catch (JSONException e) {
                BdLog.e(e);
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public e6a h(RandomAccessFile randomAccessFile, int i, long j, String str) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{randomAccessFile, Integer.valueOf(i), Long.valueOf(j), str})) == null) {
            byte[] b = b(randomAccessFile, i);
            if (b == null) {
                e6a e6aVar = new e6a();
                e6aVar.b = -1;
                e6aVar.c = "上传文件不存在";
                return e6aVar;
            } else if (c()) {
                return null;
            } else {
                NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.URL_UPLOAD_VIDEO);
                netWork.addPostData("chunk_no", String.valueOf(i));
                netWork.addPostData("chunk_sum", String.valueOf(this.c));
                netWork.addPostData("chunk_size", String.valueOf(b.length));
                netWork.addPostData("video_size", String.valueOf(this.d));
                netWork.addPostData(VideoFinishResult.KEY_VIDEO_MD5, this.e);
                netWork.addPostData("video_len", String.valueOf(j));
                netWork.addPostData("tbs", TbadkCoreApplication.getInst().getTbs());
                netWork.addPostData("video_chunk", b);
                netWork.addPostData("upload_id", str);
                if (c()) {
                    return null;
                }
                String postMultiNetData = netWork.postMultiNetData();
                if (c()) {
                    return null;
                }
                e6a e6aVar2 = new e6a();
                if (netWork.getNetContext().getResponse().isRequestSuccess()) {
                    e6aVar2.a = e(postMultiNetData);
                } else {
                    if (netWork.getNetContext().getResponse().isNetSuccess()) {
                        e6aVar2.b = netWork.getNetContext().getResponse().mServerErrorCode;
                    } else {
                        e6aVar2.b = netWork.getNetContext().getResponse().mNetErrorCode;
                    }
                    e6aVar2.c = netWork.getNetContext().getResponse().mErrorString;
                }
                return e6aVar2;
            }
        }
        return (e6a) invokeCommon.objValue;
    }
}
