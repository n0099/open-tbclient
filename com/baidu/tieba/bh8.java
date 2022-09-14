package com.baidu.tieba;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.content.FileProvider;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.WXEntryActivityConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.resourceLoaderProc.EmotionShareLoaderProc;
import com.baidu.tbadk.switchs.WeChatShareSmallAppToH5Switch;
import com.baidu.tieba.sharesdk.bean.ShareEntity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX;
import com.tencent.mm.opensdk.modelmsg.WXEmojiObject;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMiniProgramObject;
import com.tencent.mm.opensdk.modelmsg.WXTextObject;
import com.tencent.mm.opensdk.modelmsg.WXVideoObject;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.net.URLEncoder;
/* loaded from: classes3.dex */
public class bh8 extends wg8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int k;
    public dh8 l;
    public IWXAPI m;
    public d n;
    public final yg<EmotionShareLoaderProc.EmotionShare> o;
    public final c p;

    /* loaded from: classes3.dex */
    public class a extends yg<EmotionShareLoaderProc.EmotionShare> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bh8 a;

        public a(bh8 bh8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bh8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bh8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yg
        /* renamed from: a */
        public void onLoaded(EmotionShareLoaderProc.EmotionShare emotionShare, String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, emotionShare, str, i) == null) {
                super.onLoaded(emotionShare, str, i);
                if (emotionShare != null && emotionShare.image != null) {
                    bh8 bh8Var = this.a;
                    if (bh8Var.h0(bh8Var.e, emotionShare)) {
                        return;
                    }
                }
                this.a.p.onLoaded((on) null, str, i);
            }
        }

        @Override // com.baidu.tieba.yg
        public void onCancelled(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                super.onCancelled(str);
                this.a.p.onCancelled(str);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends BdAsyncTask<Bitmap, Void, Bitmap> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bh8 a;

        public b(bh8 bh8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bh8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bh8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Bitmap doInBackground(Bitmap... bitmapArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bitmapArr)) == null) {
                if (bitmapArr.length <= 0 || bitmapArr[0] == null) {
                    return null;
                }
                bh8 bh8Var = this.a;
                return bh8Var.v(bitmapArr[0], bh8Var.e, false);
            }
            return (Bitmap) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bitmap) == null) {
                super.onPostExecute((b) bitmap);
                bh8 bh8Var = this.a;
                bh8Var.n0(bh8Var.e, bitmap);
            }
        }
    }

    /* loaded from: classes3.dex */
    public final class c extends yg<on> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bh8 a;

        public c(bh8 bh8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bh8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bh8Var;
        }

        @Override // com.baidu.tieba.yg
        public void onCancelled(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                super.onCancelled(str);
                if (this.a.l != null) {
                    this.a.l.d1(this.a.k, 3);
                }
                bh8 bh8Var = this.a;
                bh8Var.u(3, bh8Var.k);
            }
        }

        public /* synthetic */ c(bh8 bh8Var, a aVar) {
            this(bh8Var);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yg
        public void onLoaded(on onVar, String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, onVar, str, i) == null) {
                super.onLoaded((c) onVar, str, i);
                if (onVar == null) {
                    this.a.p0();
                    return;
                }
                Bitmap p = onVar.p();
                if (!TextUtils.isEmpty(this.a.e.getLinkUrl())) {
                    if (this.a.k == 2) {
                        bh8 bh8Var = this.a;
                        bh8Var.o0(bh8Var.e, p);
                        return;
                    }
                    String tid = this.a.e.getTid();
                    int typeShareToSmallApp = this.a.e.getTypeShareToSmallApp();
                    if ((typeShareToSmallApp == 2 || typeShareToSmallApp == 4 || (!StringUtils.isNull(tid) && !tid.equals("0"))) && this.a.e.canShareBySmartApp && !WeChatShareSmallAppToH5Switch.isOn()) {
                        bh8 bh8Var2 = this.a;
                        bh8Var2.k0(bh8Var2.e, p);
                        return;
                    }
                    bh8 bh8Var3 = this.a;
                    bh8Var3.o0(bh8Var3.e, p);
                } else if (!TextUtils.isEmpty(this.a.e.getVideoUrl())) {
                    bh8 bh8Var4 = this.a;
                    bh8Var4.m0(bh8Var4.e, p);
                } else if (!TextUtils.isEmpty(this.a.e.getContent())) {
                    this.a.p0();
                } else {
                    bh8 bh8Var5 = this.a;
                    bh8Var5.i0(bh8Var5.e, p);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bh8 this$0;

        public d(bh8 bh8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bh8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = bh8Var;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) && intent.hasExtra("weixin_result_errCode")) {
                int intExtra = intent.getIntExtra("weixin_result_errCode", 0);
                if (intExtra == 0) {
                    if (this.this$0.l != null) {
                        this.this$0.l.d1(this.this$0.k, 1);
                    }
                    bh8 bh8Var = this.this$0;
                    bh8Var.u(1, bh8Var.k);
                } else if (intExtra == -2) {
                    if (this.this$0.l != null) {
                        this.this$0.l.d1(this.this$0.k, 3);
                    }
                    bh8 bh8Var2 = this.this$0;
                    bh8Var2.u(3, bh8Var2.k);
                } else {
                    this.this$0.s0(intExtra, intent.getStringExtra("weixin_result_errMsg"));
                    if (this.this$0.l != null) {
                        this.this$0.l.d1(this.this$0.k, 2);
                    }
                    bh8 bh8Var3 = this.this$0;
                    bh8Var3.u(2, bh8Var3.k);
                }
                this.this$0.a0();
            }
        }

        public /* synthetic */ d(bh8 bh8Var, a aVar) {
            this(bh8Var);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bh8(Context context, int i) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.o = new a(this);
        this.p = new c(this, null);
        this.b = context.getApplicationContext();
        this.k = i;
        this.m = WXAPIFactory.createWXAPI(context.getApplicationContext(), TbConfig.WEIXIN_SHARE_APP_ID);
    }

    public byte[] T(Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bitmap)) == null) {
            try {
                Bitmap k = k(bitmap, 120);
                if (k == null) {
                    k = e();
                }
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                k.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                return byteArray;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return (byte[]) invokeL.objValue;
    }

    public byte[] U(Bitmap bitmap, int i, boolean z) {
        InterceptResult invokeCommon;
        Bitmap k;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{bitmap, Integer.valueOf(i), Boolean.valueOf(z)})) == null) {
            try {
                if (z) {
                    k = f(R.drawable.obfuscated_res_0x7f080d73);
                } else {
                    k = k(bitmap, i);
                }
                if (k == null) {
                    k = f(R.drawable.obfuscated_res_0x7f080d73);
                }
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                k.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                return byteArray;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return (byte[]) invokeCommon.objValue;
    }

    public final int V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            int i = this.k;
            if (i == 3) {
                return 0;
            }
            return i == 2 ? 1 : -1;
        }
        return invokeV.intValue;
    }

    public final String W(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            if (str == null) {
                return String.valueOf(System.currentTimeMillis());
            }
            return str + System.currentTimeMillis();
        }
        return (String) invokeL.objValue;
    }

    public boolean X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? Build.VERSION.SDK_INT >= 24 : invokeV.booleanValue;
    }

    public boolean Y(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, context)) == null) ? this.m.getWXAppSupportAPI() >= 654314752 : invokeL.booleanValue;
    }

    public byte[] Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            try {
                Bitmap f = f(R.drawable.obfuscated_res_0x7f080d73);
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                f.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                return byteArray;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return (byte[]) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ch8
    public void a(ShareEntity shareEntity, dh8 dh8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, shareEntity, dh8Var) == null) {
            if (shareEntity != null && this.m != null) {
                this.e = shareEntity;
                this.l = dh8Var;
                this.k = shareEntity.getShareTo();
                if (!this.m.isWXAppInstalled()) {
                    dh8 dh8Var2 = this.l;
                    if (dh8Var2 != null) {
                        dh8Var2.d1(this.k, 2);
                    }
                    BdToast.b(d(), d().getText(R.string.obfuscated_res_0x7f0f1190)).i();
                    return;
                }
                on r = r(shareEntity);
                if (r != null && r.p() != null) {
                    if (this.e.getShareType() == 2) {
                        g0(this.e, r.p());
                        return;
                    } else {
                        i0(this.e, r.p());
                        return;
                    }
                } else if (q(shareEntity.getLocalFile())) {
                    q0(shareEntity.getLocalFile());
                    return;
                } else {
                    String imgUrl = shareEntity.getImgUrl();
                    if (!TextUtils.isEmpty(imgUrl) && (imgUrl.startsWith("http://") || imgUrl.startsWith("https://"))) {
                        if (this.e.getShareType() != 0) {
                            zg.h().k(imgUrl, 34, this.o, 0, 0, j(), new Object[0]);
                            return;
                        } else {
                            zg.h().k(imgUrl, 10, this.p, 0, 0, j(), new Object[0]);
                            return;
                        }
                    } else if (p(shareEntity.getImageUri())) {
                        q0(shareEntity.getImageUri().getPath());
                        return;
                    } else {
                        p0();
                        return;
                    }
                }
            }
            u(2, this.k);
            if (dh8Var != null) {
                dh8Var.d1(0, 2);
            }
        }
    }

    public final void a0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            FileHelper.deleteFile(new File(wg8.h + wg8.j));
        }
    }

    public String b0(Context context, File file) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, context, file)) == null) {
            if (file == null || !file.exists()) {
                return null;
            }
            Uri uriForFile = FileProvider.getUriForFile(context, context.getPackageName() + ".fileprovider", file);
            context.grantUriPermission("com.tencent.mm", uriForFile, 1);
            return uriForFile.toString();
        }
        return (String) invokeLL.objValue;
    }

    public final boolean c0(WXImageObject wXImageObject, Bitmap bitmap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, wXImageObject, bitmap)) == null) {
            Context context = this.b;
            if (context != null && wXImageObject != null && bitmap != null && Y(context) && X()) {
                try {
                    e0(wXImageObject, FileHelper.saveFileAsPNG(wg8.h, wg8.j, bitmap, 100), bitmap);
                    return true;
                } catch (Exception e) {
                    BdLog.e(e);
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final void d0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || this.b == null) {
            return;
        }
        this.n = new d(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(WXEntryActivityConfig.ACTION_WX_SHARE_RESULT);
        this.b.registerReceiver(this.n, intentFilter);
    }

    public final void e0(@NonNull WXImageObject wXImageObject, @NonNull String str, @NonNull Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048588, this, wXImageObject, str, bitmap) == null) {
            wXImageObject.setImagePath(b0(this.b, new File(str)));
            WXMediaMessage wXMediaMessage = new WXMediaMessage();
            wXMediaMessage.mediaObject = wXImageObject;
            wXMediaMessage.thumbData = T(bitmap);
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = W("imageShare");
            req.message = wXMediaMessage;
            req.scene = V();
            this.m.sendReq(req);
        }
    }

    public final boolean f0(ShareEntity shareEntity, EmotionShareLoaderProc.EmotionShare emotionShare) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, shareEntity, emotionShare)) == null) {
            if (shareEntity == null || this.m == null || emotionShare == null || emotionShare.image == null || StringUtils.isNull(emotionShare.path)) {
                return false;
            }
            WXEmojiObject wXEmojiObject = new WXEmojiObject();
            wXEmojiObject.emojiPath = emotionShare.path;
            WXMediaMessage wXMediaMessage = new WXMediaMessage();
            wXMediaMessage.mediaObject = wXEmojiObject;
            wXMediaMessage.thumbData = T(emotionShare.image.p());
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = W("imageShare");
            req.message = wXMediaMessage;
            req.scene = V();
            this.m.sendReq(req);
            return true;
        }
        return invokeLL.booleanValue;
    }

    public final void g0(ShareEntity shareEntity, Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048590, this, shareEntity, bitmap) == null) || shareEntity == null || this.m == null || bitmap == null) {
            return;
        }
        WXEmojiObject wXEmojiObject = new WXEmojiObject();
        wXEmojiObject.emojiData = U(bitmap, 512, false);
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.mediaObject = wXEmojiObject;
        wXMediaMessage.thumbData = T(bitmap);
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = W("imageShare");
        req.message = wXMediaMessage;
        req.scene = V();
        this.m.sendReq(req);
    }

    public final boolean h0(ShareEntity shareEntity, EmotionShareLoaderProc.EmotionShare emotionShare) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048591, this, shareEntity, emotionShare)) == null) {
            if (this.k != 2 && this.e.getShareType() != 1) {
                return f0(shareEntity, emotionShare);
            }
            return j0(shareEntity, emotionShare);
        }
        return invokeLL.booleanValue;
    }

    public final void i0(ShareEntity shareEntity, Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048592, this, shareEntity, bitmap) == null) || shareEntity == null || this.m == null || bitmap == null) {
            return;
        }
        WXImageObject wXImageObject = new WXImageObject(bitmap);
        if (c0(wXImageObject, bitmap)) {
            return;
        }
        wXImageObject.imageData = xi.d().a(bitmap, 85);
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.mediaObject = wXImageObject;
        wXMediaMessage.thumbData = T(bitmap);
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = W("imageShare");
        req.message = wXMediaMessage;
        req.scene = V();
        this.m.sendReq(req);
    }

    public final boolean j0(ShareEntity shareEntity, EmotionShareLoaderProc.EmotionShare emotionShare) {
        InterceptResult invokeLL;
        on onVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048593, this, shareEntity, emotionShare)) == null) {
            if (shareEntity == null || this.m == null || emotionShare == null || StringUtils.isNull(emotionShare.path) || (onVar = emotionShare.image) == null || onVar.p() == null) {
                return false;
            }
            WXImageObject wXImageObject = new WXImageObject();
            wXImageObject.setImagePath(emotionShare.path);
            if (c0(wXImageObject, emotionShare.image.p())) {
                return false;
            }
            WXMediaMessage wXMediaMessage = new WXMediaMessage();
            wXMediaMessage.mediaObject = wXImageObject;
            wXMediaMessage.thumbData = T(emotionShare.image.p());
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = W("imageShare");
            req.message = wXMediaMessage;
            req.scene = V();
            this.m.sendReq(req);
            return true;
        }
        return invokeLL.booleanValue;
    }

    public final void k0(ShareEntity shareEntity, Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048594, this, shareEntity, bitmap) == null) || shareEntity == null || this.m == null) {
            return;
        }
        WXMiniProgramObject wXMiniProgramObject = new WXMiniProgramObject();
        wXMiniProgramObject.webpageUrl = shareEntity.getLinkUrl();
        wXMiniProgramObject.miniprogramType = 0;
        wXMiniProgramObject.userName = "gh_213e5678c5bf";
        if (shareEntity.getTypeShareToSmallApp() != 2 && shareEntity.getTypeShareToSmallApp() != 4) {
            String tid = shareEntity.getTid();
            wXMiniProgramObject.path = "/pages/pb/pb?tid=" + tid;
        } else {
            String str = shareEntity.getfName();
            if (dj.isEmpty(str)) {
                str = "";
            }
            String encode = URLEncoder.encode(str);
            wXMiniProgramObject.path = "/pages/frs/frs?kw=" + encode;
        }
        WXMediaMessage wXMediaMessage = new WXMediaMessage(wXMiniProgramObject);
        String title = shareEntity.getTitle();
        if (StringUtils.isNull(title)) {
            title = shareEntity.getContent();
        }
        wXMediaMessage.title = title;
        wXMediaMessage.description = shareEntity.getContent();
        if ("https://tb5.bdstatic.com/yunying/tieba_logo.jpg".equals(shareEntity.getImgUrl())) {
            wXMediaMessage.thumbData = t0(bitmap, true);
        } else {
            wXMediaMessage.thumbData = t0(bitmap, false);
        }
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = W("miniProgram");
        req.message = wXMediaMessage;
        req.scene = 0;
        this.m.sendReq(req);
    }

    public final void l0(ShareEntity shareEntity) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048595, this, shareEntity) == null) || shareEntity == null || this.m == null) {
            return;
        }
        String content = shareEntity.getContent();
        WXTextObject wXTextObject = new WXTextObject();
        wXTextObject.text = content;
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.mediaObject = wXTextObject;
        wXMediaMessage.description = content;
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = W("textShare");
        req.message = wXMediaMessage;
        req.scene = V();
        this.m.sendReq(req);
    }

    public final void m0(ShareEntity shareEntity, Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048596, this, shareEntity, bitmap) == null) || shareEntity == null || this.m == null) {
            return;
        }
        WXVideoObject wXVideoObject = new WXVideoObject();
        wXVideoObject.videoUrl = shareEntity.getVideoUrl();
        WXMediaMessage wXMediaMessage = new WXMediaMessage(wXVideoObject);
        wXMediaMessage.title = shareEntity.getTitle();
        wXMediaMessage.description = shareEntity.getContent();
        wXMediaMessage.thumbData = T(bitmap);
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = W("videoShare");
        req.message = wXMediaMessage;
        req.scene = V();
        this.m.sendReq(req);
    }

    public final void n0(ShareEntity shareEntity, Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048597, this, shareEntity, bitmap) == null) || shareEntity == null || this.m == null) {
            return;
        }
        WXWebpageObject wXWebpageObject = new WXWebpageObject();
        wXWebpageObject.webpageUrl = shareEntity.getLinkUrl();
        WXMediaMessage wXMediaMessage = new WXMediaMessage(wXWebpageObject);
        wXMediaMessage.title = shareEntity.getTitle();
        wXMediaMessage.description = shareEntity.getContent();
        wXMediaMessage.thumbData = T(bitmap);
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = W("webpageShare");
        req.message = wXMediaMessage;
        req.scene = V();
        this.m.sendReq(req);
    }

    public final void o0(ShareEntity shareEntity, Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048598, this, shareEntity, bitmap) == null) {
            if (shareEntity.getIsVideoThread()) {
                b bVar = new b(this);
                bVar.setPriority(3);
                bVar.execute(bitmap);
                return;
            }
            n0(this.e, bitmap);
        }
    }

    public final void p0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            Bitmap e = e();
            if (e != null) {
                i0(this.e, e);
            } else {
                l0(this.e);
            }
        }
    }

    public final void q0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, str) == null) {
            Bitmap i = i(str);
            if (i == null) {
                i = e();
            }
            if (i != null) {
                i0(this.e, i);
            } else {
                l0(this.e);
            }
        }
    }

    public final void r0() {
        Context context;
        d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048601, this) == null) || (context = this.b) == null || (dVar = this.n) == null) {
            return;
        }
        context.unregisterReceiver(dVar);
    }

    @Override // com.baidu.tieba.wg8
    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            r0();
            super.s();
        }
    }

    public final void s0(int i, String str) {
        ShareEntity shareEntity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048603, this, i, str) == null) || (shareEntity = this.e) == null || StringUtils.isNull(shareEntity.getImgUrl())) {
            return;
        }
        qw4.a("socail_share", -1L, 0, WXEntryActivityConfig.WX_SHARE_FAIL, i, "", "share_fail_exception", str + "&" + this.e.getImgUrl());
    }

    @Override // com.baidu.tieba.wg8
    public void t(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, bdUniqueId) == null) {
            super.t(bdUniqueId);
            d0();
        }
    }

    public byte[] t0(Bitmap bitmap, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048605, this, bitmap, z)) == null) {
            try {
                int width = bitmap.getWidth();
                int height = bitmap.getHeight();
                if (!z && bitmap != null) {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    double length = byteArray.length / 1024;
                    if (length <= 125.0d) {
                        return byteArray;
                    }
                    while (length > 125.0d) {
                        Double valueOf = Double.valueOf(length / 125.0d);
                        Double valueOf2 = Double.valueOf(width / Math.sqrt(valueOf.doubleValue()));
                        Double valueOf3 = Double.valueOf(height / Math.sqrt(valueOf.doubleValue()));
                        width = valueOf2.intValue();
                        height = valueOf3.intValue();
                        bitmap = l(bitmap, width, height);
                        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream2);
                        byteArray = byteArrayOutputStream2.toByteArray();
                        length = byteArray.length / 1024;
                    }
                    byteArrayOutputStream.close();
                    return bitmap == null ? Z() : byteArray;
                }
                return Z();
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return (byte[]) invokeLZ.objValue;
    }
}
