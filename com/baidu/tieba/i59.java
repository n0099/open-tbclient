package com.baidu.tieba;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.BaseWriteConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
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
/* loaded from: classes4.dex */
public class i59 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final TbPageContext<?> a;
    public final List<b49> b;
    public WriteImagesInfo c;

    /* loaded from: classes4.dex */
    public class a extends InsertGalleryAsyncTask.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i59 a;

        public a(i59 i59Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i59Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i59Var;
        }

        @Override // com.baidu.tbadk.util.InsertGalleryAsyncTask.a
        public void a(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) {
            }
        }

        @Override // com.baidu.tbadk.util.InsertGalleryAsyncTask.a
        public void b(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) && new File(str).exists()) {
                this.a.f().clear();
                ImageFileInfo imageFileInfo = new ImageFileInfo();
                imageFileInfo.setFilePath(str);
                imageFileInfo.isFromMoreForum = true;
                this.a.f().addChooseFile(imageFileInfo);
                this.a.f().setMaxImagesAllowed(1);
                i59 i59Var = this.a;
                i59Var.k(i59Var.f().toJsonString());
            }
        }
    }

    public i59(@NonNull TbPageContext<?> tbPageContext) {
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

    public ImageFileInfo b(@NonNull f49 f49Var, @NonNull r05 r05Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, f49Var, r05Var)) == null) {
            PermissionJudgePolicy t = f49Var.t();
            t.clearRequestPermissionList();
            t.appendRequestPermission(this.a.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (t.startRequestPermission(this.a.getPageActivity())) {
                return null;
            }
            if (this.c.size() >= this.c.getMaxImagesAllowed()) {
                this.a.showToast(String.format(this.a.getString(R.string.obfuscated_res_0x7f0f0abe), Integer.valueOf(this.c.getMaxImagesAllowed())));
                return null;
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setImageType(1);
            imageFileInfo.setFilePath(r05Var.d());
            imageFileInfo.width = r05Var.h();
            imageFileInfo.height = r05Var.b();
            this.c.addChooseFile(imageFileInfo);
            this.c.updateQuality();
            return imageFileInfo;
        }
        return (ImageFileInfo) invokeLL.objValue;
    }

    public void c(b49 b49Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, b49Var) == null) || this.b.contains(b49Var)) {
            return;
        }
        this.b.add(b49Var);
    }

    public void d(@NonNull WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, writeData) == null) {
            writeData.setWriteImagesInfo(this.c);
            WriteImagesInfo writeImagesInfo = this.c;
            if (writeImagesInfo == null || writeImagesInfo.size() <= 0) {
                return;
            }
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

    public void e(@NonNull f49 f49Var, @NonNull WriteData writeData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, f49Var, writeData) == null) || this.a.getPageActivity() == null || !WriteActivityConfig.FROM_FORUM_SHARE.equals(writeData.getFrom()) || StringUtils.isNull(writeData.getMoreForumImg())) {
            return;
        }
        f49Var.t().clearRequestPermissionList();
        f49Var.t().appendRequestPermission(this.a.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
        if (f49Var.t().startRequestPermission(this.a.getPageActivity())) {
            return;
        }
        InsertGalleryAsyncTask insertGalleryAsyncTask = new InsertGalleryAsyncTask(this.a.getPageActivity(), writeData.getMoreForumImg(), new a(this));
        insertGalleryAsyncTask.setFrom(1);
        insertGalleryAsyncTask.execute(new String[0]);
    }

    @NonNull
    public WriteImagesInfo f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.c : (WriteImagesInfo) invokeV.objValue;
    }

    public void g(Bundle bundle, Intent intent, @NonNull WriteData writeData) {
        WriteData writeData2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, bundle, intent, writeData) == null) {
            if (writeData.isFromErrorDialog() && (writeData2 = ro8.f) != null) {
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
            o(str);
            writeData.setWriteImagesInfo(f());
        }
    }

    public final void h(Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, intent) == null) || intent == null) {
            return;
        }
        String stringExtra = intent.getStringExtra(BaseWriteConfig.KEY_WRITE_IMAGES_INFO_STRING);
        for (b49 b49Var : this.b) {
            b49Var.t(stringExtra);
        }
    }

    public final void i(Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, intent) == null) || intent == null) {
            return;
        }
        String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
        for (b49 b49Var : this.b) {
            b49Var.s(stringExtra);
        }
    }

    public final void j(Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, intent) == null) || intent == null) {
            return;
        }
        String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
        for (b49 b49Var : this.b) {
            b49Var.i(stringExtra);
        }
    }

    public final void k(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, str) == null) || StringUtils.isNull(str)) {
            return;
        }
        for (b49 b49Var : this.b) {
            b49Var.g(str);
        }
    }

    public void l(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIL(1048586, this, i, i2, intent) == null) && intent != null && i2 == -1) {
            if (i == 12002) {
                i(intent);
            } else if (i == 12012) {
                j(intent);
            }
        }
    }

    public void m(Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, intent) == null) || intent == null) {
            return;
        }
        h(intent);
    }

    public void n(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, bundle) == null) || bundle == null) {
            return;
        }
        bundle.putString(BaseWriteConfig.KEY_WRITE_IMAGES_INFO_STRING, this.c.toJsonString());
    }

    public void o(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, str) == null) || StringUtils.isNull(str)) {
            return;
        }
        this.c.parseJson(str);
        this.c.updateQuality();
    }

    public void p(b49 b49Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, b49Var) == null) {
            this.b.remove(b49Var);
        }
    }

    public void q(@NonNull WriteImagesInfo writeImagesInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, writeImagesInfo) == null) {
            this.c = writeImagesInfo;
        }
    }
}
