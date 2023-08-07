package com.baidu.tieba;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ImageView.BdImage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.message.FestivalTaskRequestMessage;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.mutiprocess.MutiProcessManager;
import com.baidu.tbadk.mutiprocess.share.ShareEvent;
import com.baidu.tieba.sharesdk.bean.ShareEntity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public abstract class e3a implements k3a {
    public static /* synthetic */ Interceptable $ic;
    public static String h;
    public static String i;
    public static String j;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public Context b;
    public String c;
    public String d;
    public ShareEntity e;
    public boolean f;
    public String g;

    public void n(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, intent) == null) {
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947684790, "Lcom/baidu/tieba/e3a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947684790, "Lcom/baidu/tieba/e3a;");
                return;
            }
        }
        h = FileHelper.EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/share";
        i = "temp_video_thumb.png";
        j = "_temp_share_pic.png";
    }

    public e3a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = context;
    }

    public void A(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            this.c = str;
        }
    }

    public void B(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            E(str, BdToast.ToastIcon.FAILURE);
        }
    }

    public void C(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            E(str, BdToast.ToastIcon.SUCCESS);
        }
    }

    public Bitmap f(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i2)) == null) {
            return BitmapHelper.getCashBitmap(i2);
        }
        return (Bitmap) invokeI.objValue;
    }

    public Bitmap h(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, uri)) == null) {
            return BitmapHelper.loadBitmap(uri.getPath());
        }
        return (Bitmap) invokeL.objValue;
    }

    public Bitmap i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
            return BitmapHelper.loadBitmap(str);
        }
        return (Bitmap) invokeL.objValue;
    }

    public boolean o(Uri uri) {
        InterceptResult invokeL;
        File file;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, uri)) == null) {
            if (uri == null) {
                return false;
            }
            try {
                file = new File(new URI(uri.toString()));
            } catch (IllegalArgumentException | URISyntaxException unused) {
            }
            if (!file.isFile() || !file.exists()) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public boolean p(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            File file = new File(str);
            if (!file.isFile() || !file.exists()) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void s(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, bdUniqueId) == null) {
            this.a = bdUniqueId;
        }
    }

    public void x(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048603, this, z) == null) {
            this.f = z;
        }
    }

    public void y(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, str) == null) {
            this.d = str;
        }
    }

    public void z(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, str) == null) {
            this.g = str;
        }
    }

    public void D(int i2, String str, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3)}) == null) {
            if (i2 == 1) {
                if (TextUtils.isEmpty(str)) {
                    str = m(R.string.share_success, new Object[0]);
                }
                ShareEntity shareEntity = this.e;
                if (shareEntity != null && !TextUtils.isEmpty(shareEntity.getFestivalTaskType())) {
                    v();
                    return;
                }
                JSONObject jSONObject = new JSONObject();
                ShareEntity shareEntity2 = this.e;
                if (shareEntity2 != null) {
                    try {
                        jSONObject.put("thread_id", shareEntity2.getTid());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                if (this.f && ht4.d().c("share_thread", jSONObject.toString())) {
                    return;
                }
                C(str);
                w();
            } else if (i2 == 3) {
                if (TextUtils.isEmpty(str)) {
                    str = m(R.string.share_cancel, new Object[0]);
                }
                B(str);
            } else if (i2 == 2) {
                if (TextUtils.isEmpty(str)) {
                    str = m(R.string.share_failed, new Object[0]);
                }
                B(str);
            }
        }
    }

    public void E(String str, BdToast.ToastIcon toastIcon) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, str, toastIcon) == null) {
            BdToast.makeText(d(), str).setIcon(toastIcon).show();
        }
    }

    public Bitmap k(Bitmap bitmap, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048590, this, bitmap, i2)) == null) {
            return BitmapHelper.resizeBitmap(bitmap, i2, i2, false);
        }
        return (Bitmap) invokeLI.objValue;
    }

    public String m(int i2, Object... objArr) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048592, this, i2, objArr)) == null) {
            return d().getString(i2, objArr);
        }
        return (String) invokeIL.objValue;
    }

    public void t(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048599, this, i2, i3) == null) {
            D(i2, null, i3);
            c(i2, i3);
        }
    }

    public void b(int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048581, this, i2, i3, i4) == null) {
            ShareEvent shareEvent = new ShareEvent();
            shareEvent.status = i2;
            shareEvent.tid = this.c;
            shareEvent.channel = i3;
            shareEvent.extLiveInfo = this.d;
            shareEvent.from = i4;
            MutiProcessManager.publishEvent(shareEvent);
        }
    }

    public Bitmap l(Bitmap bitmap, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048591, this, bitmap, i2, i3)) == null) {
            return BitmapHelper.resizeBitmap(bitmap, i2, i3, false);
        }
        return (Bitmap) invokeLII.objValue;
    }

    public final void c(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048582, this, i2, i3) == null) {
            if (!TextUtils.isEmpty(this.c)) {
                b(i2, i3, 0);
            } else if (!StringUtils.isNull(this.d)) {
                b(i2, i3, 0);
            } else {
                ShareEntity shareEntity = this.e;
                if (shareEntity != null && shareEntity.isFromDuXiaoMan()) {
                    b(i2, i3, 1);
                }
            }
        }
    }

    public Context d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return TbadkCoreApplication.getInst().getContext();
        }
        return (Context) invokeV.objValue;
    }

    public Bitmap e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return BitmapHelper.getCashBitmap(R.drawable.tb_launcher_icon);
        }
        return (Bitmap) invokeV.objValue;
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.g;
        }
        return (String) invokeV.objValue;
    }

    public BdUniqueId j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            BdUniqueId bdUniqueId = this.a;
            if (bdUniqueId != null) {
                return bdUniqueId;
            }
            k9 c = l9.c(this.b);
            if (c != null) {
                return c.getUniqueId();
            }
            return bdUniqueId;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048602, this) == null) && g() != null) {
            StatisticItem statisticItem = new StatisticItem("c14390");
            statisticItem.addParam("topic_id", g());
            statisticItem.addParam("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(statisticItem);
        }
    }

    public BdImage q(ShareEntity shareEntity) {
        InterceptResult invokeL;
        Bundle bundle;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, shareEntity)) == null) {
            if (shareEntity == null || (bundle = shareEntity.diskPicOperate) == null) {
                return null;
            }
            String string = bundle.getString("path");
            String string2 = bundle.getString("name");
            if (TextUtils.isEmpty(string) || TextUtils.isEmpty(string2)) {
                return null;
            }
            boolean z = bundle.getBoolean(ShareItem.KEY_DISK_PIC_OP_SUBDIR, true);
            boolean z2 = bundle.getBoolean(ShareItem.KEY_DISK_PIC_OP_SDCARD, false);
            boolean z3 = bundle.getBoolean(ShareItem.KEY_DISK_PIC_OP_SAVEDCACHE, true);
            boolean z4 = bundle.getBoolean(ShareItem.KEY_DISK_PIC_OP_FORMATDATA, true);
            yb ybVar = new yb(string, string2, DiskFileOperate.Action.READ);
            ybVar.setOperateType(DiskFileOperate.OperateType.MUST_SUCCESS);
            ybVar.setSubFolder(z);
            ybVar.setIsFormatData(z4);
            ybVar.setSdCard(z2);
            ybVar.setSavedCache(z3);
            if (!ub.f().call(ybVar) || !ybVar.isSuccess()) {
                return null;
            }
            ybVar.formatData(ybVar.getData());
            Bitmap bitmap = ybVar.getBitmap();
            if (bitmap == null) {
                return null;
            }
            return new BdImage(bitmap, ybVar.isGif());
        }
        return (BdImage) invokeL.objValue;
    }

    public Bitmap u(Bitmap bitmap, ShareEntity shareEntity, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048600, this, bitmap, shareEntity, z)) == null) {
            if (bitmap == null) {
                return null;
            }
            Bitmap k = k(bitmap, (BdUtilHelper.getDimens(this.b, R.dimen.tbds113) * Math.max(bitmap.getWidth(), bitmap.getHeight())) / Math.min(bitmap.getWidth(), bitmap.getHeight()));
            Bitmap createBitmap = Bitmap.createBitmap(k.getWidth(), k.getHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            canvas.drawBitmap(k, 0.0f, 0.0f, (Paint) null);
            LinearGradient linearGradient = new LinearGradient(0.0f, 0.0f, 0.0f, k.getHeight(), this.b.getResources().getColor(R.color.CAM_X0601), this.b.getResources().getColor(R.color.CAM_X0605), Shader.TileMode.CLAMP);
            Paint paint = new Paint();
            paint.setShader(linearGradient);
            canvas.drawRect(0.0f, 0.0f, k.getWidth(), k.getHeight(), paint);
            Drawable pureDrawable = SvgManager.getInstance().getPureDrawable(R.drawable.obfuscated_res_0x7f0807b9, R.color.CAM_X0101, null, false);
            if (pureDrawable != null) {
                int min = (int) (Math.min(k.getWidth(), k.getHeight()) * 0.3f);
                int width = (k.getWidth() - min) / 2;
                int height = (k.getHeight() - min) / 2;
                pureDrawable.setBounds(width, height, width + min, min + height);
                pureDrawable.draw(canvas);
            }
            if (z) {
                String saveFileAsPNG = FileHelper.saveFileAsPNG(h, i, createBitmap, 100);
                if (!StringUtils.isNull(saveFileAsPNG)) {
                    shareEntity.setImageUri(Uri.parse(saveFileAsPNG));
                }
            }
            return createBitmap;
        }
        return (Bitmap) invokeLLZ.objValue;
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048601, this) != null) || this.e == null) {
            return;
        }
        MessageManager.getInstance().sendMessage(new FestivalTaskRequestMessage(this.e.getFestivalTaskType()).tid(this.e.getFestivalTaskTid()).sharedUid(this.e.getFloorAuthorUid()));
    }
}
