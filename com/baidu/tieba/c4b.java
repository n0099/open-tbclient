package com.baidu.tieba;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.BaseWriteConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.httpNet.WebClient;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.util.InsertGalleryAsyncTask;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes5.dex */
public class c4b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final TbPageContext<?> a;
    public final List<p2b> b;
    public WriteImagesInfo c;

    /* loaded from: classes5.dex */
    public class a extends InsertGalleryAsyncTask.InsertGalleryListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c4b a;

        @Override // com.baidu.tbadk.util.InsertGalleryAsyncTask.InsertGalleryListener
        public void onError(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) {
            }
        }

        public a(c4b c4bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c4bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = c4bVar;
        }

        @Override // com.baidu.tbadk.util.InsertGalleryAsyncTask.InsertGalleryListener
        public void onSuccess(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) && new File(str).exists()) {
                this.a.g().clear();
                ImageFileInfo imageFileInfo = new ImageFileInfo();
                imageFileInfo.setFilePath(str);
                imageFileInfo.isFromMoreForum = true;
                this.a.g().addChooseFile(imageFileInfo);
                this.a.g().setMaxImagesAllowed(1);
                c4b c4bVar = this.a;
                c4bVar.l(c4bVar.g().toJsonString());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends bx5<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteData a;

        public b(c4b c4bVar, WriteData writeData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c4bVar, writeData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = writeData;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.bx5
        public String doInBackground() {
            InterceptResult invokeV;
            byte[] downloadImageBytes;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                String str = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath() + "/imageCache" + ji.d(downloadImageBytes);
                FileHelper.saveFileByAbsolutePath(str, new WebClient().downloadImageBytes(this.a.getNetImgUrl()));
                return str;
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class c implements gw5<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c4b a;

        public c(c4b c4bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c4bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = c4bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.gw5
        /* renamed from: a */
        public void onReturnDataInUI(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && !TextUtils.isEmpty(str) && new File(str).exists()) {
                this.a.g().clear();
                ImageFileInfo imageFileInfo = new ImageFileInfo();
                imageFileInfo.setFilePath(str);
                this.a.g().addChooseFile(imageFileInfo);
                c4b c4bVar = this.a;
                c4bVar.l(c4bVar.g().toJsonString());
            }
        }
    }

    public c4b(@NonNull TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = new ArrayList();
        WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
        this.c = writeImagesInfo;
        this.a = tbPageContext;
        writeImagesInfo.setMaxImagesAllowed(9);
    }

    public void d(@NonNull WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, writeData) == null) {
            writeData.setWriteImagesInfo(this.c);
            WriteImagesInfo writeImagesInfo = this.c;
            if (writeImagesInfo != null && writeImagesInfo.size() > 0) {
                Iterator<ImageFileInfo> it = this.c.getChosedFiles().iterator();
                int i = 0;
                while (it.hasNext()) {
                    ImageFileInfo next = it.next();
                    if (next != null && next.isFromCamera()) {
                        i++;
                    }
                }
                writeData.setTakePhotoNum(i);
            }
        }
    }

    public void f(@NonNull t2b t2bVar, @NonNull WriteData writeData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048580, this, t2bVar, writeData) != null) || this.a.getPageActivity() == null || StringUtils.isNull(writeData.getNetImgUrl())) {
            return;
        }
        fx5.b(new b(this, writeData), new c(this));
    }

    public ImageFileInfo b(@NonNull t2b t2bVar, @NonNull uc5 uc5Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, t2bVar, uc5Var)) == null) {
            PermissionJudgePolicy t = t2bVar.t();
            t.clearRequestPermissionList();
            t.appendRequestPermission(this.a.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (t.startRequestPermission(this.a.getPageActivity())) {
                return null;
            }
            if (this.c.size() >= this.c.getMaxImagesAllowed()) {
                this.a.showToast(String.format(this.a.getString(R.string.max_choose_image_count), Integer.valueOf(this.c.getMaxImagesAllowed())));
                return null;
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setImageType(1);
            imageFileInfo.setFilePath(uc5Var.d());
            imageFileInfo.width = uc5Var.h();
            imageFileInfo.height = uc5Var.b();
            this.c.addChooseFile(imageFileInfo);
            this.c.updateQuality();
            return imageFileInfo;
        }
        return (ImageFileInfo) invokeLL.objValue;
    }

    public void e(@NonNull t2b t2bVar, @NonNull WriteData writeData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048579, this, t2bVar, writeData) != null) || this.a.getPageActivity() == null || !WriteActivityConfig.FROM_FORUM_SHARE.equals(writeData.getFrom()) || StringUtils.isNull(writeData.getMoreForumImg())) {
            return;
        }
        t2bVar.t().clearRequestPermissionList();
        t2bVar.t().appendRequestPermission(this.a.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
        if (t2bVar.t().startRequestPermission(this.a.getPageActivity())) {
            return;
        }
        InsertGalleryAsyncTask insertGalleryAsyncTask = new InsertGalleryAsyncTask(this.a.getPageActivity(), writeData.getMoreForumImg(), new a(this));
        insertGalleryAsyncTask.setFrom(1);
        insertGalleryAsyncTask.execute(new String[0]);
    }

    public void c(p2b p2bVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, p2bVar) != null) || this.b.contains(p2bVar)) {
            return;
        }
        this.b.add(p2bVar);
    }

    public final void i(Intent intent) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048583, this, intent) != null) || intent == null) {
            return;
        }
        String stringExtra = intent.getStringExtra(BaseWriteConfig.KEY_WRITE_IMAGES_INFO_STRING);
        for (p2b p2bVar : this.b) {
            p2bVar.v(stringExtra);
        }
    }

    public final void j(Intent intent) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, intent) != null) || intent == null) {
            return;
        }
        String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
        for (p2b p2bVar : this.b) {
            p2bVar.u(stringExtra);
        }
    }

    public final void k(Intent intent) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048585, this, intent) != null) || intent == null) {
            return;
        }
        String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
        for (p2b p2bVar : this.b) {
            p2bVar.k(stringExtra);
        }
    }

    public final void l(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048586, this, str) != null) || StringUtils.isNull(str)) {
            return;
        }
        for (p2b p2bVar : this.b) {
            p2bVar.i(str);
        }
    }

    public void n(Intent intent) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048588, this, intent) != null) || intent == null) {
            return;
        }
        i(intent);
    }

    public void o(Bundle bundle) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048589, this, bundle) != null) || bundle == null) {
            return;
        }
        bundle.putString(BaseWriteConfig.KEY_WRITE_IMAGES_INFO_STRING, this.c.toJsonString());
    }

    public void p(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048590, this, str) == null) && !StringUtils.isNull(str)) {
            this.c.parseJson(str);
            this.c.updateQuality();
        }
    }

    public void q(p2b p2bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, p2bVar) == null) {
            this.b.remove(p2bVar);
        }
    }

    public void r(@NonNull WriteImagesInfo writeImagesInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, writeImagesInfo) == null) {
            this.c = writeImagesInfo;
        }
    }

    @NonNull
    public WriteImagesInfo g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.c;
        }
        return (WriteImagesInfo) invokeV.objValue;
    }

    public void h(Bundle bundle, Intent intent, @NonNull WriteData writeData) {
        WriteData writeData2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048582, this, bundle, intent, writeData) == null) {
            if (writeData.isFromErrorDialog() && (writeData2 = zha.f) != null) {
                this.c = writeData2.getWriteImagesInfo();
                return;
            }
            String str = null;
            if (bundle != null) {
                str = bundle.getString(BaseWriteConfig.KEY_WRITE_IMAGES_INFO_STRING);
            } else if (intent != null) {
                str = intent.getStringExtra(BaseWriteConfig.KEY_WRITE_IMAGES_INFO_STRING);
                intent.putExtra(BaseWriteConfig.KEY_WRITE_IMAGES_INFO_STRING, "");
            }
            p(str);
            writeData.setWriteImagesInfo(g());
        }
    }

    public void m(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeIIL(1048587, this, i, i2, intent) != null) || intent == null || i2 != -1) {
            return;
        }
        if (i == 12002) {
            j(intent);
        } else if (i == 12012) {
            k(intent);
        }
    }
}
