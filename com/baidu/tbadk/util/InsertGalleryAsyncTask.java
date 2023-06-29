package com.baidu.tbadk.util;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Base64;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tieba.si;
import com.baidu.tieba.tb;
import com.baidu.tieba.ug;
import com.baidu.tieba.vg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.SevenZipUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketException;
import java.net.URL;
import java.util.UUID;
/* loaded from: classes4.dex */
public class InsertGalleryAsyncTask extends BdAsyncTask<String, String, b> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int FROM_ANNIVERSARY = 3;
    public static final int FROM_DEFAULT = 0;
    public static final int FROM_SHARE_DIALOG = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean careHeaderContentLength;
    public String dir;
    public int from;
    public File imageFile;
    public String imagePath;
    public a insertGalleryListener;
    public boolean isBase64Type;
    public boolean renameGif;
    public String url;

    /* loaded from: classes4.dex */
    public static abstract class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public abstract void a(int i, String str);

        public abstract void b(String str);

        public a() {
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
    }

    /* loaded from: classes4.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;
        public String b;

        public b(InsertGalleryAsyncTask insertGalleryAsyncTask, boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {insertGalleryAsyncTask, Boolean.valueOf(z), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z;
            this.b = str;
        }

        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.b;
            }
            return (String) invokeV.objValue;
        }

        public boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.a;
            }
            return invokeV.booleanValue;
        }
    }

    public InsertGalleryAsyncTask(Activity activity, String str, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, str, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.from = 0;
        this.careHeaderContentLength = true;
        this.renameGif = false;
        this.url = str;
        this.insertGalleryListener = aVar;
    }

    private boolean download(String str, String str2, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65538, this, str, str2, i)) == null) {
            int b2 = tb.d().b().b();
            int b3 = tb.d().c().b();
            boolean z = false;
            for (int i2 = 0; i2 < i; i2++) {
                try {
                    z = realDownload(str, str2, b3, b2);
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return z;
        }
        return invokeLLI.booleanValue;
    }

    private void deleteNoMediaFile(File file) {
        File[] listFiles;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, file) == null) {
            try {
                for (File file2 : file.listFiles()) {
                    if (file2.isDirectory()) {
                        deleteNoMediaFile(file2);
                    } else if (file2.isFile() && file2.getName().equals(".nomedia")) {
                        file2.delete();
                    }
                }
                file.delete();
            } catch (Exception unused) {
            }
        }
    }

    private boolean downloadFile() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            return download(this.url, this.imagePath, 3);
        }
        return invokeV.booleanValue;
    }

    private void notifyGallery() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65545, this) == null) && this.imageFile != null) {
            TbadkCoreApplication.getInst().sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile(this.imageFile)));
        }
    }

    private HttpURLConnection getConnect(URL url, int i, int i2) throws SocketException, ProtocolException {
        InterceptResult invokeLII;
        String curMobileProxyHost;
        HttpURLConnection httpURLConnection;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(InputDeviceCompat.SOURCE_TRACKBALL, this, url, i, i2)) == null) {
            HttpURLConnection httpURLConnection2 = null;
            try {
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                return null;
            }
            if (BdNetTypeUtil.isMobileNet() && (curMobileProxyHost = BdNetTypeUtil.curMobileProxyHost()) != null && curMobileProxyHost.length() > 0) {
                if (BdNetTypeUtil.isWap(curMobileProxyHost) && BdNetTypeUtil.isSupportWap()) {
                    StringBuilder sb = new StringBuilder(80);
                    sb.append("http://");
                    sb.append(curMobileProxyHost);
                    String file = url.getFile();
                    if (file != null && file.startsWith("?")) {
                        sb.append("/");
                    }
                    sb.append(file);
                    httpURLConnection = (HttpURLConnection) new URL(sb.toString()).openConnection();
                } else {
                    httpURLConnection = (HttpURLConnection) url.openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(curMobileProxyHost, BdNetTypeUtil.curMobileProxyPort())));
                }
                httpURLConnection2 = httpURLConnection;
            }
            if (httpURLConnection2 == null) {
                httpURLConnection2 = (HttpURLConnection) url.openConnection();
            }
            if (httpURLConnection2 != null) {
                httpURLConnection2.setRequestMethod("GET");
                httpURLConnection2.setConnectTimeout(i);
                httpURLConnection2.setReadTimeout(i2);
                return httpURLConnection2;
            }
            throw new SocketException();
        }
        return (HttpURLConnection) invokeLII.objValue;
    }

    private String getImageSuffix(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return ".jpg";
            }
            if (str.endsWith(".png")) {
                return ".png";
            }
            if (str.endsWith(".PNG")) {
                return ".PNG";
            }
            if (str.endsWith(".jpg")) {
                return ".jpg";
            }
            if (str.endsWith(".jpeg")) {
                return ".jpeg";
            }
            if (str.endsWith(".JPEG")) {
                return ".JPEG";
            }
            if (str.endsWith(".gif")) {
                return ".gif";
            }
            if (str.endsWith(".GIF")) {
                return ".GIF";
            }
            String[] split = str.split("\\.");
            if (split != null && split.length > 0) {
                String str2 = split[split.length - 1];
                if (str2.startsWith("png")) {
                    return ".png";
                }
                if (str2.startsWith("PNG")) {
                    return ".PNG";
                }
                if (str2.startsWith("jpg")) {
                    return ".jpg";
                }
                if (str2.startsWith("jpeg")) {
                    return ".jpeg";
                }
                if (str2.startsWith("JPEG")) {
                    return ".JPEG";
                }
                if (str2.startsWith(NativeConstants.TYPE_GIF)) {
                    return ".gif";
                }
                if (str2.startsWith("GIF")) {
                    return ".GIF";
                }
            }
            return ".jpg";
        }
        return (String) invokeL.objValue;
    }

    private File handleFile(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, this, str)) == null) {
            si.k(str);
            return new File(str);
        }
        return (File) invokeL.objValue;
    }

    public InsertGalleryAsyncTask isBase64Type(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z)) == null) {
            this.isBase64Type = z;
            return this;
        }
        return (InsertGalleryAsyncTask) invokeZ.objValue;
    }

    public void setCareHeaderContentLength(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.careHeaderContentLength = z;
        }
    }

    public void setFrom(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            this.from = i;
        }
    }

    public void setRenameGif(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.renameGif = z;
        }
    }

    private boolean isGifFile(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, this, file)) == null) {
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                fileInputStream.skip(fileInputStream.available() - 1);
                int[] iArr = {fileInputStream.read(), fileInputStream.read(), fileInputStream.read(), fileInputStream.read(), fileInputStream.read()};
                fileInputStream.close();
                if (iArr[0] != 71 || iArr[1] != 73 || iArr[2] != 70 || iArr[3] != 56) {
                    return false;
                }
                if (iArr[4] != 59) {
                    return false;
                }
                return true;
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return false;
            } catch (IOException e2) {
                e2.printStackTrace();
                return false;
            } catch (Exception e3) {
                e3.printStackTrace();
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPostExecute(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) {
            super.onPostExecute((InsertGalleryAsyncTask) bVar);
            if (bVar == null) {
                a aVar = this.insertGalleryListener;
                if (aVar != null) {
                    aVar.a(-2, "error");
                }
            } else if (!bVar.b()) {
                a aVar2 = this.insertGalleryListener;
                if (aVar2 != null) {
                    aVar2.a(-1, bVar.a());
                }
            } else {
                if (this.renameGif && isGifFile(new File(this.imagePath))) {
                    String replace = this.imagePath.replace(getImageSuffix(this.imagePath), ".gif");
                    this.imageFile.renameTo(new File(replace));
                    this.imagePath = replace;
                    this.imageFile = new File(this.imagePath);
                }
                notifyGallery();
                a aVar3 = this.insertGalleryListener;
                if (aVar3 != null) {
                    aVar3.b(this.imagePath);
                }
            }
        }
    }

    private boolean makePath() {
        InterceptResult invokeV;
        File externalStoragePublicDirectory;
        String lowerCase;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) {
            try {
                if (this.from == 1) {
                    FileHelper.CheckTempDir(FileHelper.EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/");
                    FileHelper.CheckTempDir(FileHelper.EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/" + SevenZipUtils.FILE_NAME_TEMP + "/");
                    FileHelper.CheckTempDir(FileHelper.EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/" + SevenZipUtils.FILE_NAME_TEMP + "/.nomedia/");
                    externalStoragePublicDirectory = new File(FileHelper.EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/" + SevenZipUtils.FILE_NAME_TEMP + "/.nomedia/");
                } else if (this.from == 3) {
                    FileHelper.CheckTempDir(FileHelper.EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/");
                    FileHelper.CheckTempDir(FileHelper.EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/" + SevenZipUtils.FILE_NAME_TEMP + "/");
                    FileHelper.CheckTempDir(FileHelper.EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/" + SevenZipUtils.FILE_NAME_TEMP + "/.anniver/");
                    externalStoragePublicDirectory = new File(FileHelper.EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/" + SevenZipUtils.FILE_NAME_TEMP + "/.anniver/");
                } else {
                    externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
                }
                if (externalStoragePublicDirectory != null && externalStoragePublicDirectory.exists()) {
                    String absolutePath = externalStoragePublicDirectory.getAbsolutePath();
                    this.dir = absolutePath;
                    if (!TextUtils.isEmpty(absolutePath) && !this.dir.endsWith("/")) {
                        this.dir += "/";
                    }
                } else {
                    this.dir = Environment.getExternalStorageDirectory().getPath() + "/tieba/";
                }
                File file = new File(this.dir);
                if (!file.exists()) {
                    file.mkdir();
                }
                if (this.from == 1) {
                    lowerCase = "shareDialogTempImg";
                } else if (this.from == 3) {
                    lowerCase = "userPortrait";
                } else {
                    lowerCase = UUID.randomUUID().toString().replace("-", "").toLowerCase();
                }
                this.imagePath = this.dir + lowerCase + getImageSuffix(this.url);
                File file2 = new File(this.imagePath);
                this.imageFile = file2;
                if (file2.exists()) {
                    this.imageFile.delete();
                }
                if (this.imageFile.exists()) {
                    return true;
                }
                this.imageFile.createNewFile();
                return true;
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    private boolean realDownload(String str, String str2, int i, int i2) throws Exception {
        InterceptResult invokeLLII;
        HttpURLConnection httpURLConnection;
        FileOutputStream fileOutputStream;
        int responseCode;
        int i3;
        String lowerCase;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(65546, this, str, str2, i, i2)) == null) {
            InputStream inputStream = null;
            try {
                httpURLConnection = getConnect(new URL(str), i, i2);
                try {
                    fileOutputStream = new FileOutputStream(handleFile(str2), true);
                    try {
                        httpURLConnection.connect();
                        responseCode = httpURLConnection.getResponseCode();
                        if (responseCode == 302) {
                            String headerField = httpURLConnection.getHeaderField("Location");
                            ug.f(httpURLConnection);
                            try {
                                if (this.imageFile != null) {
                                    this.imageFile.delete();
                                }
                            } catch (Exception unused) {
                            }
                            if (this.from == 1) {
                                lowerCase = "shareDialogTempImg";
                            } else if (this.from == 3) {
                                lowerCase = "userPortrait";
                            } else {
                                lowerCase = UUID.randomUUID().toString().replace("-", "").toLowerCase();
                            }
                            this.imagePath = this.dir + lowerCase + getImageSuffix(headerField);
                            File file = new File(this.imagePath);
                            this.imageFile = file;
                            if (file.exists()) {
                                this.imageFile.delete();
                            }
                            if (!this.imageFile.exists()) {
                                this.imageFile.createNewFile();
                            }
                            ug.d(fileOutputStream);
                            FileOutputStream fileOutputStream2 = new FileOutputStream(this.imageFile, true);
                            try {
                                httpURLConnection = getConnect(new URL(headerField), i, i2);
                                httpURLConnection.connect();
                                responseCode = httpURLConnection.getResponseCode();
                                fileOutputStream = fileOutputStream2;
                            } catch (Throwable th) {
                                th = th;
                                fileOutputStream = fileOutputStream2;
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    fileOutputStream = null;
                }
            } catch (Throwable th4) {
                th = th4;
                httpURLConnection = null;
                fileOutputStream = null;
            }
            if (responseCode == 200) {
                String headerField2 = httpURLConnection.getHeaderField("Content-Length");
                if (headerField2 != null) {
                    i3 = vg.e(headerField2, 0);
                } else {
                    i3 = 0;
                }
                if (i3 != 0 || !this.careHeaderContentLength) {
                    inputStream = httpURLConnection.getInputStream();
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read != -1) {
                            try {
                                fileOutputStream.write(bArr, 0, read);
                            } catch (Exception unused2) {
                                throw new FileNotFoundException();
                            }
                        } else {
                            try {
                                fileOutputStream.flush();
                                ug.c(inputStream);
                                ug.f(httpURLConnection);
                                ug.d(fileOutputStream);
                                return true;
                            } catch (Exception unused3) {
                                throw new FileNotFoundException();
                            }
                        }
                        th = th2;
                        ug.c(inputStream);
                        ug.f(httpURLConnection);
                        ug.d(fileOutputStream);
                        throw th;
                    }
                }
            }
            ug.c(null);
            ug.f(httpURLConnection);
            ug.d(fileOutputStream);
            return false;
        }
        return invokeLLII.booleanValue;
    }

    private boolean saveBase64Img() {
        InterceptResult invokeV;
        FileOutputStream fileOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, this)) == null) {
            String str = this.url;
            byte[] decode = Base64.decode(str.substring(str.indexOf(",") + 1, this.url.length()), 0);
            for (int i = 0; i < decode.length; i++) {
                if (decode[i] < 0) {
                    decode[i] = (byte) (decode[i] + 256);
                }
            }
            FileOutputStream fileOutputStream2 = null;
            try {
                try {
                    fileOutputStream = new FileOutputStream(this.imageFile, true);
                } catch (Exception e) {
                    e = e;
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                fileOutputStream.write(decode);
                fileOutputStream.flush();
                ug.d(fileOutputStream);
                return true;
            } catch (Exception e2) {
                e = e2;
                fileOutputStream2 = fileOutputStream;
                e.printStackTrace();
                ug.d(fileOutputStream2);
                return false;
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream2 = fileOutputStream;
                ug.d(fileOutputStream2);
                throw th;
            }
        }
        return invokeV.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public b doInBackground(String... strArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, strArr)) == null) {
            if (TextUtils.isEmpty(this.url)) {
                return new b(this, false, "url is null");
            }
            if (!makePath()) {
                return new b(this, false, "make file error");
            }
            if (!this.isBase64Type) {
                if (!downloadFile()) {
                    return new b(this, false, "download error");
                }
            } else if (!saveBase64Img()) {
                return new b(this, false, "decode base64 error");
            }
            return new b(this, true, null);
        }
        return (b) invokeL.objValue;
    }
}
