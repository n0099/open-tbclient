package com.baidu.tieba;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.gif.NSGif;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.EmotionUtil;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tieba.faceshop.DiyEmotionData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
/* loaded from: classes4.dex */
public class ic6 extends m55 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<String> e;
    public Set<String> f;
    public int g;

    public ic6() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = new ArrayList<>();
        this.f = new HashSet();
        this.g = 3;
        x();
    }

    @Override // com.baidu.tieba.m55
    public String b(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            if (i >= this.e.size()) {
                return null;
            }
            return this.e.get(i);
        }
        return (String) invokeI.objValue;
    }

    @Override // com.baidu.tieba.m55
    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            ArrayList<String> arrayList = this.e;
            if (arrayList == null || arrayList.size() == 0) {
                return 1;
            }
            return this.e.size();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.m55
    public on e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? super.d() : (on) invokeV.objValue;
    }

    @Override // com.baidu.tieba.m55
    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? v75.b() : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.m55
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? "用户Diy表情" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.m55
    public EmotionGroupType h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? EmotionGroupType.USER_DIY : (EmotionGroupType) invokeV.objValue;
    }

    @Override // com.baidu.tieba.m55
    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.m55
    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.m55
    public int l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.m55
    public boolean m(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) ? this.f.contains(str) : invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.m55
    public on n(String str) {
        InterceptResult invokeL;
        ByteArrayOutputStream byteArrayOutputStream;
        Throwable th;
        FileInputStream fileInputStream;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048586, this, str)) != null) {
            return (on) invokeL.objValue;
        }
        File file = new File(u(str).getAbsolutePath().replace("_s.jpg", "_b.gif"));
        if (!file.exists()) {
            return null;
        }
        try {
            fileInputStream = new FileInputStream(file);
        } catch (Exception e) {
            e = e;
            fileInputStream = null;
            byteArrayOutputStream = null;
        } catch (Throwable th2) {
            byteArrayOutputStream = null;
            th = th2;
            fileInputStream = null;
        }
        try {
            byteArrayOutputStream = new ByteArrayOutputStream(1024);
            try {
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = fileInputStream.read(bArr, 0, 1024);
                        if (read != -1) {
                            byteArrayOutputStream.write(bArr, 0, read);
                        } else {
                            byte[] byteArray = byteArrayOutputStream.toByteArray();
                            on onVar = new on(NSGif.f(byteArray, 0, byteArray.length));
                            ch.c(fileInputStream);
                            ch.d(byteArrayOutputStream);
                            return onVar;
                        }
                    }
                } catch (Exception e2) {
                    e = e2;
                    e.printStackTrace();
                    ch.c(fileInputStream);
                    ch.d(byteArrayOutputStream);
                    return null;
                }
            } catch (Throwable th3) {
                th = th3;
                ch.c(fileInputStream);
                ch.d(byteArrayOutputStream);
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            byteArrayOutputStream = null;
        } catch (Throwable th4) {
            th = th4;
            byteArrayOutputStream = null;
            ch.c(fileInputStream);
            ch.d(byteArrayOutputStream);
            throw th;
        }
    }

    @Override // com.baidu.tieba.m55
    public on o(String str) {
        InterceptResult invokeL;
        Bitmap image;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
            if ("#(meme,diysetting)".equals(str)) {
                return new on(v(BitmapFactory.decodeResource(TbadkCoreApplication.getInst().getApp().getResources(), R.drawable.obfuscated_res_0x7f0808dc)), false);
            }
            File u = u(str);
            if (u == null || (image = FileHelper.getImage(u.getAbsolutePath())) == null) {
                return null;
            }
            return new on(image, false, str);
        }
        return (on) invokeL.objValue;
    }

    @Override // com.baidu.tieba.m55
    public void p(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048588, this, i) == null) || i == this.g) {
            return;
        }
        this.g = i;
        on onVar = new on(v(BitmapFactory.decodeResource(TbadkCoreApplication.getInst().getApp().getResources(), R.drawable.obfuscated_res_0x7f080947)), false);
        super.s(onVar);
        super.r(onVar);
        u75.k().h(zg.h().g("#(meme,diysetting)", 20));
    }

    public File u(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            String replace = str.replace(EmotionUtil.NEW_EMOTION_SHARPTEXT_PREFIX, "");
            String replace2 = replace.substring(0, replace.indexOf(",")).replace("diy_", "");
            if (replace2.contains("_")) {
                replace2 = replace2.substring(replace2.indexOf("_") + 1);
            }
            return new File(TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath() + "/.collect/" + v75.c() + "/" + replace2 + "_s.jpg");
        }
        return (File) invokeL.objValue;
    }

    public final Bitmap v(Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, bitmap)) == null) {
            if (TbadkCoreApplication.getInst().getSkinType() != 0) {
                Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
                PorterDuffColorFilter porterDuffColorFilter = new PorterDuffColorFilter(SkinManager.getColor(R.color.CAM_X0105), PorterDuff.Mode.SRC_IN);
                Paint paint = new Paint();
                paint.setColorFilter(porterDuffColorFilter);
                new Canvas(createBitmap).drawBitmap(bitmap, 0.0f, 0.0f, paint);
                return createBitmap;
            }
            return bitmap;
        }
        return (Bitmap) invokeL.objValue;
    }

    public boolean w(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, str)) == null) {
            if (this.e != null && !TextUtils.isEmpty(str)) {
                Iterator<String> it = this.e.iterator();
                while (it.hasNext()) {
                    if (it.next().contains(str)) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            t(2);
            q(4);
            on onVar = new on(v(BitmapFactory.decodeResource(TbadkCoreApplication.getInst().getApp().getResources(), R.drawable.obfuscated_res_0x7f080947)), false);
            super.s(onVar);
            super.r(onVar);
            y();
        }
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            List<DiyEmotionData> r = mc6.o().r(TbadkCoreApplication.getCurrentAccountForEmotion());
            this.e.clear();
            this.f.clear();
            for (DiyEmotionData diyEmotionData : r) {
                this.e.add(diyEmotionData.getSharpText());
                this.f.add(diyEmotionData.getSharpText());
            }
        }
    }
}
