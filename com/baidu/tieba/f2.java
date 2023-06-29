package com.baidu.tieba;

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import com.badlogic.gdx.Files;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes5.dex */
public class f2 extends c3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final AssetManager c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f2(AssetManager assetManager, File file, Files.FileType fileType) {
        super(file, fileType);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {assetManager, file, fileType};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((File) objArr2[0], (Files.FileType) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = assetManager;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f2(AssetManager assetManager, String str, Files.FileType fileType) {
        super(str.replace('\\', WebvttCueParser.CHAR_SLASH), fileType);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {assetManager, str, fileType};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((String) objArr2[0], (Files.FileType) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = assetManager;
    }

    @Override // com.baidu.tieba.c3
    public c3 a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            String replace = str.replace('\\', WebvttCueParser.CHAR_SLASH);
            if (this.a.getPath().length() == 0) {
                return new f2(this.c, new File(replace), this.b);
            }
            return new f2(this.c, new File(this.a, replace), this.b);
        }
        return (c3) invokeL.objValue;
    }

    @Override // com.baidu.tieba.c3
    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.b == Files.FileType.Internal) {
                String path = this.a.getPath();
                try {
                    this.c.open(path).close();
                    return true;
                } catch (Exception unused) {
                    try {
                        if (this.c.list(path).length > 0) {
                            return true;
                        }
                        return false;
                    } catch (Exception unused2) {
                        return false;
                    }
                }
            }
            return super.c();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.c3
    public long f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.b == Files.FileType.Internal) {
                AssetFileDescriptor assetFileDescriptor = null;
                try {
                    assetFileDescriptor = this.c.openFd(this.a.getPath());
                    long length = assetFileDescriptor.getLength();
                    if (assetFileDescriptor != null) {
                        try {
                            assetFileDescriptor.close();
                        } catch (IOException unused) {
                        }
                    }
                    return length;
                } catch (IOException unused2) {
                    if (assetFileDescriptor != null) {
                        try {
                            assetFileDescriptor.close();
                        } catch (IOException unused3) {
                        }
                    }
                } catch (Throwable th) {
                    if (assetFileDescriptor != null) {
                        try {
                            assetFileDescriptor.close();
                        } catch (IOException unused4) {
                        }
                    }
                    throw th;
                }
            }
            return super.f();
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.tieba.c3
    public c3 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            File parentFile = this.a.getParentFile();
            if (parentFile == null) {
                if (this.b == Files.FileType.Absolute) {
                    parentFile = new File("/");
                } else {
                    parentFile = new File("");
                }
            }
            return new f2(this.c, parentFile, this.b);
        }
        return (c3) invokeV.objValue;
    }

    @Override // com.baidu.tieba.c3
    public File e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.b == Files.FileType.Local) {
                return new File(x0.d.b(), this.a.getPath());
            }
            return super.e();
        }
        return (File) invokeV.objValue;
    }

    public AssetFileDescriptor u() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            AssetManager assetManager = this.c;
            if (assetManager != null) {
                return assetManager.openFd(j());
            }
            return null;
        }
        return (AssetFileDescriptor) invokeV.objValue;
    }

    @Override // com.baidu.tieba.c3
    public InputStream m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.b == Files.FileType.Internal) {
                try {
                    return this.c.open(this.a.getPath());
                } catch (IOException e) {
                    throw new GdxRuntimeException("Error reading file: " + this.a + " (" + this.b + SmallTailInfo.EMOTION_SUFFIX, e);
                }
            }
            return super.m();
        }
        return (InputStream) invokeV.objValue;
    }

    @Override // com.baidu.tieba.c3
    public c3 s(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            String replace = str.replace('\\', WebvttCueParser.CHAR_SLASH);
            if (this.a.getPath().length() != 0) {
                return x0.d.d(new File(this.a.getParent(), replace).getPath(), this.b);
            }
            throw new GdxRuntimeException("Cannot get the sibling of the root.");
        }
        return (c3) invokeL.objValue;
    }
}
