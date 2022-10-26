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
import com.baidu.tieba.faceshop.EmotionData;
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
/* loaded from: classes3.dex */
public class cd6 extends d65 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList e;
    public Set f;
    public int g;

    @Override // com.baidu.tieba.d65
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? "用户Diy表情" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.d65
    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.d65
    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.d65
    public int l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    public cd6() {
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
        this.e = new ArrayList();
        this.f = new HashSet();
        this.g = 3;
        x();
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            t(2);
            q(4);
            pn pnVar = new pn(v(BitmapFactory.decodeResource(TbadkCoreApplication.getInst().getApp().getResources(), R.drawable.obfuscated_res_0x7f080949)), false);
            super.s(pnVar);
            super.r(pnVar);
            y();
        }
    }

    @Override // com.baidu.tieba.d65
    public String b(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            if (i >= this.e.size()) {
                return null;
            }
            return (String) this.e.get(i);
        }
        return (String) invokeI.objValue;
    }

    @Override // com.baidu.tieba.d65
    public boolean m(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            return this.f.contains(str);
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.d65
    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            ArrayList arrayList = this.e;
            if (arrayList != null && arrayList.size() != 0) {
                return this.e.size();
            }
            return 1;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.d65
    public pn e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return super.d();
        }
        return (pn) invokeV.objValue;
    }

    @Override // com.baidu.tieba.d65
    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return m85.b();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.d65
    public EmotionGroupType h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return EmotionGroupType.USER_DIY;
        }
        return (EmotionGroupType) invokeV.objValue;
    }

    @Override // com.baidu.tieba.d65
    public pn n(String str) {
        InterceptResult invokeL;
        ByteArrayOutputStream byteArrayOutputStream;
        Throwable th;
        FileInputStream fileInputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
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
                                pn pnVar = new pn(NSGif.f(byteArray, 0, byteArray.length));
                                dh.c(fileInputStream);
                                dh.d(byteArrayOutputStream);
                                return pnVar;
                            }
                        }
                    } catch (Exception e2) {
                        e = e2;
                        e.printStackTrace();
                        dh.c(fileInputStream);
                        dh.d(byteArrayOutputStream);
                        return null;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    dh.c(fileInputStream);
                    dh.d(byteArrayOutputStream);
                    throw th;
                }
            } catch (Exception e3) {
                e = e3;
                byteArrayOutputStream = null;
            } catch (Throwable th4) {
                th = th4;
                byteArrayOutputStream = null;
                dh.c(fileInputStream);
                dh.d(byteArrayOutputStream);
                throw th;
            }
        } else {
            return (pn) invokeL.objValue;
        }
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
            return new File(TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath() + "/.collect/" + m85.c() + "/" + replace2 + "_s.jpg");
        }
        return (File) invokeL.objValue;
    }

    @Override // com.baidu.tieba.d65
    public pn o(String str) {
        InterceptResult invokeL;
        Bitmap image;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
            if ("#(meme,diysetting)".equals(str)) {
                return new pn(v(BitmapFactory.decodeResource(TbadkCoreApplication.getInst().getApp().getResources(), R.drawable.obfuscated_res_0x7f0808db)), false);
            }
            File u = u(str);
            if (u == null || (image = FileHelper.getImage(u.getAbsolutePath())) == null) {
                return null;
            }
            return new pn(image, false, str);
        }
        return (pn) invokeL.objValue;
    }

    @Override // com.baidu.tieba.d65
    public void p(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048588, this, i) != null) || i == this.g) {
            return;
        }
        this.g = i;
        pn pnVar = new pn(v(BitmapFactory.decodeResource(TbadkCoreApplication.getInst().getApp().getResources(), R.drawable.obfuscated_res_0x7f080949)), false);
        super.s(pnVar);
        super.r(pnVar);
        l85.k().h(ah.h().g("#(meme,diysetting)", 20));
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
                Iterator it = this.e.iterator();
                while (it.hasNext()) {
                    if (((String) it.next()).contains(str)) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            List<EmotionData> r = gd6.o().r(TbadkCoreApplication.getCurrentAccountForEmotion());
            this.e.clear();
            this.f.clear();
            for (EmotionData emotionData : r) {
                this.e.add(emotionData.getSharpText());
                this.f.add(emotionData.getSharpText());
            }
        }
    }
}
