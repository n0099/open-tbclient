package com.baidu.tieba;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.cloudcontrol.utils.CloudStabilityUBCUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.ChunkUploadDatabaseService;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.coreExtra.data.AudioInfoData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class b75 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public NetWork a;
    public a b;
    public a85 c;
    public String d;
    public String e;
    public List<b> f;

    /* loaded from: classes3.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public String b;
        public z75 c;
        public NetWork d;
        public boolean e;
        public String f;

        public a(b75 b75Var, String str, z75 z75Var, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b75Var, str, z75Var, str2, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = null;
            this.b = null;
            this.c = null;
            this.e = false;
            this.f = null;
            this.a = str;
            this.c = z75Var;
            this.b = str2;
            this.f = str3;
        }

        /* JADX WARN: Removed duplicated region for block: B:44:0x00f6 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:46:0x0111 A[SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public a85 a() throws IOException {
            InterceptResult invokeV;
            int i;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                a85 a85Var = new a85();
                long c = this.c.c();
                long j = 30720;
                long j2 = c / 30720;
                if (c % 30720 != 0) {
                    j2++;
                }
                int a = this.c.a();
                if (a < j2) {
                    RandomAccessFile randomAccessFile = new RandomAccessFile(new File(this.a), "r");
                    int i2 = a * TbConfig.VOICE_CHUNK_UPLOAD_SIZE;
                    if (randomAccessFile.skipBytes(i2) >= i2) {
                        while (true) {
                            long j3 = a;
                            if (j3 < j2) {
                                long j4 = j2 - 1;
                                if (j3 == j4) {
                                    i = (int) (c - (j4 * j));
                                } else {
                                    i = TbConfig.VOICE_CHUNK_UPLOAD_SIZE;
                                }
                                byte[] bArr = new byte[i];
                                int read = randomAccessFile.read(bArr, 0, i);
                                if (read != -1) {
                                    NetWork netWork = new NetWork(this.b);
                                    this.d = netWork;
                                    netWork.addPostData("voice_chunk", bArr);
                                    this.d.addPostData("chunk_md5", this.c.b());
                                    this.d.addPostData(CloudStabilityUBCUtils.KEY_LENGTH, String.valueOf(read));
                                    this.d.addPostData("offset", String.valueOf(a * TbConfig.VOICE_CHUNK_UPLOAD_SIZE));
                                    this.d.addPostData("total_length", String.valueOf(c));
                                    this.d.addPostData("chunk_no", String.valueOf(a + 1));
                                    this.d.addPostData("total_num", String.valueOf(j2));
                                    this.d.addPostData("voice_md5", this.f);
                                    if (!this.e) {
                                        if (this.d.postMultiNetData() != null && this.d.getNetContext().getResponse().isRequestSuccess()) {
                                            z = false;
                                            if (!z) {
                                                a85Var.f(this.d.getServerErrorCode());
                                                a85Var.g(this.d.getErrorString());
                                                a85Var.e(this.c);
                                                a85Var.h(false);
                                                return a85Var;
                                            }
                                        } else {
                                            this.c.d(a);
                                            ChunkUploadDatabaseService.saveChunkUploadData(this.c);
                                            randomAccessFile.close();
                                        }
                                    }
                                    z = true;
                                    if (!z) {
                                    }
                                }
                                a++;
                                j = 30720;
                            } else {
                                randomAccessFile.close();
                                break;
                            }
                        }
                    } else {
                        a85Var.h(false);
                        randomAccessFile.close();
                        return a85Var;
                    }
                }
                a85Var.h(true);
                return a85Var;
            }
            return (a85) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public String b;

        public b(b75 b75Var, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b75Var, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.b = str2;
        }

        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.a;
            }
            return (String) invokeV.objValue;
        }

        public String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.b;
            }
            return (String) invokeV.objValue;
        }
    }

    public b75(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f = new ArrayList();
        this.d = str;
        this.e = str2;
    }

    public void a(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, str, i) == null) {
            this.f.add(new b(this, str, String.valueOf(i)));
        }
    }

    public final long b(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j)) == null) {
            int i = ((j % 30720) > 0L ? 1 : ((j % 30720) == 0L ? 0 : -1));
            long j2 = j / 30720;
            if (i != 0) {
                return j2 + 1;
            }
            return j2;
        }
        return invokeJ.longValue;
    }

    public final String c(String str, z75 z75Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, z75Var)) == null) {
            NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + this.e);
            this.a = netWork;
            netWork.addPostData("voice_md5", z75Var.b());
            if (ListUtils.getCount(this.f) != 0) {
                for (b bVar : this.f) {
                    if (bVar != null) {
                        this.a.addPostData(bVar.a(), bVar.b());
                    }
                }
            }
            String postNetData = this.a.postNetData();
            if (postNetData != null && this.a.getNetContext().getResponse().isRequestSuccess()) {
                ChunkUploadDatabaseService.delChunkUploadData(str);
                return postNetData;
            }
            z75Var.d((int) b(z75Var.c()));
            ChunkUploadDatabaseService.saveChunkUploadData(z75Var);
            this.c.f(this.a.getServerErrorCode());
            this.c.g(this.a.getErrorString());
            this.c.h(false);
            return null;
        }
        return (String) invokeLL.objValue;
    }

    public final a85 e(String str, File file) throws IOException {
        InterceptResult invokeLL;
        String c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, file)) == null) {
            String b2 = pi.b(FileHelper.GetStreamFromFile(file));
            if (b2 != null && b2.length() > 0) {
                b2 = b2.toLowerCase();
            }
            z75 chunkUploadDataByMd5 = ChunkUploadDatabaseService.getChunkUploadDataByMd5(b2);
            if (chunkUploadDataByMd5 == null) {
                chunkUploadDataByMd5 = new z75();
                chunkUploadDataByMd5.e(b2);
                chunkUploadDataByMd5.d(0);
                chunkUploadDataByMd5.f(file.length());
            }
            z75 z75Var = chunkUploadDataByMd5;
            a aVar = new a(this, str, z75Var, TbConfig.SERVER_ADDRESS + this.d, b2);
            this.b = aVar;
            a85 a2 = aVar.a();
            this.c = a2;
            if (a2.d() && (c = c(b2, z75Var)) != null && !c.equals("")) {
                AudioInfoData audioInfoData = new AudioInfoData();
                audioInfoData.parserJson(c);
                if (audioInfoData.getErrorCode() <= 0 && audioInfoData.getVoiceId() != null) {
                    z75Var.e(audioInfoData.getVoiceId());
                    this.c.e(z75Var);
                } else {
                    this.c.f(audioInfoData.getErrorCode());
                    this.c.g(audioInfoData.getErrorUserMsg());
                    this.c.h(false);
                }
            }
            return this.c;
        }
        return (a85) invokeLL.objValue;
    }

    public a85 d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            try {
                File file = new File(str);
                if (!file.exists()) {
                    return null;
                }
                this.a = new NetWork(TbConfig.SERVER_ADDRESS + this.d);
                return e(str, file);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                return null;
            }
        }
        return (a85) invokeL.objValue;
    }
}
