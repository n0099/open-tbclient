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
/* loaded from: classes4.dex */
public class gr8 extends br8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int k;
    public ir8 l;
    public IWXAPI m;
    public d n;
    public final tg<EmotionShareLoaderProc.EmotionShare> o;
    public final c p;

    /* loaded from: classes4.dex */
    public class a extends tg<EmotionShareLoaderProc.EmotionShare> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gr8 a;

        public a(gr8 gr8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gr8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gr8Var;
        }

        @Override // com.baidu.tieba.tg
        public void onCancelled(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                super.onCancelled(str);
                this.a.p.onCancelled(str);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.tg
        /* renamed from: a */
        public void onLoaded(EmotionShareLoaderProc.EmotionShare emotionShare, String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, emotionShare, str, i) == null) {
                super.onLoaded(emotionShare, str, i);
                if (emotionShare != null && emotionShare.image != null) {
                    gr8 gr8Var = this.a;
                    if (gr8Var.i0(gr8Var.e, emotionShare)) {
                        return;
                    }
                }
                this.a.p.onLoaded((jn) null, str, i);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends BdAsyncTask<Bitmap, Void, Bitmap> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gr8 a;

        public b(gr8 gr8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gr8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gr8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Bitmap doInBackground(Bitmap... bitmapArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bitmapArr)) == null) {
                if (bitmapArr.length > 0 && bitmapArr[0] != null) {
                    gr8 gr8Var = this.a;
                    return gr8Var.v(bitmapArr[0], gr8Var.e, false);
                }
                return null;
            }
            return (Bitmap) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bitmap) == null) {
                super.onPostExecute((b) bitmap);
                gr8 gr8Var = this.a;
                gr8Var.o0(gr8Var.e, bitmap);
            }
        }
    }

    /* loaded from: classes4.dex */
    public final class c extends tg<jn> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gr8 a;

        public c(gr8 gr8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gr8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gr8Var;
        }

        public /* synthetic */ c(gr8 gr8Var, a aVar) {
            this(gr8Var);
        }

        @Override // com.baidu.tieba.tg
        public void onCancelled(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                super.onCancelled(str);
                if (this.a.l != null) {
                    this.a.l.b1(this.a.k, 3);
                }
                gr8 gr8Var = this.a;
                gr8Var.u(3, gr8Var.k);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.tg
        public void onLoaded(jn jnVar, String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jnVar, str, i) == null) {
                super.onLoaded((c) jnVar, str, i);
                if (jnVar == null) {
                    this.a.q0();
                    return;
                }
                Bitmap p = jnVar.p();
                if (!TextUtils.isEmpty(this.a.e.getLinkUrl())) {
                    if (this.a.k == 2) {
                        gr8 gr8Var = this.a;
                        gr8Var.p0(gr8Var.e, p);
                        return;
                    }
                    String tid = this.a.e.getTid();
                    int typeShareToSmallApp = this.a.e.getTypeShareToSmallApp();
                    if ((typeShareToSmallApp == 2 || typeShareToSmallApp == 4 || (!StringUtils.isNull(tid) && !tid.equals("0"))) && this.a.e.canShareBySmartApp && !WeChatShareSmallAppToH5Switch.isOn()) {
                        gr8 gr8Var2 = this.a;
                        gr8Var2.l0(gr8Var2.e, p);
                        return;
                    }
                    gr8 gr8Var3 = this.a;
                    gr8Var3.p0(gr8Var3.e, p);
                } else if (!TextUtils.isEmpty(this.a.e.getVideoUrl())) {
                    gr8 gr8Var4 = this.a;
                    gr8Var4.n0(gr8Var4.e, p);
                } else if (!TextUtils.isEmpty(this.a.e.getContent())) {
                    this.a.q0();
                } else {
                    gr8 gr8Var5 = this.a;
                    gr8Var5.j0(gr8Var5.e, p);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gr8 this$0;

        public d(gr8 gr8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gr8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = gr8Var;
        }

        public /* synthetic */ d(gr8 gr8Var, a aVar) {
            this(gr8Var);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) && intent.hasExtra("weixin_result_errCode")) {
                int intExtra = intent.getIntExtra("weixin_result_errCode", 0);
                if (intExtra == 0) {
                    if (this.this$0.l != null) {
                        this.this$0.l.b1(this.this$0.k, 1);
                    }
                    gr8 gr8Var = this.this$0;
                    gr8Var.u(1, gr8Var.k);
                } else if (intExtra == -2) {
                    if (this.this$0.l != null) {
                        this.this$0.l.b1(this.this$0.k, 3);
                    }
                    gr8 gr8Var2 = this.this$0;
                    gr8Var2.u(3, gr8Var2.k);
                } else {
                    this.this$0.t0(intExtra, intent.getStringExtra("weixin_result_errMsg"));
                    if (this.this$0.l != null) {
                        this.this$0.l.b1(this.this$0.k, 2);
                    }
                    gr8 gr8Var3 = this.this$0;
                    gr8Var3.u(2, gr8Var3.k);
                }
                this.this$0.b0();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gr8(Context context, int i) {
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

    public final boolean g0(ShareEntity shareEntity, EmotionShareLoaderProc.EmotionShare emotionShare) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, shareEntity, emotionShare)) == null) {
            if (shareEntity != null && this.m != null && emotionShare != null && emotionShare.image != null && !StringUtils.isNull(emotionShare.path)) {
                WXEmojiObject wXEmojiObject = new WXEmojiObject();
                wXEmojiObject.emojiPath = emotionShare.path;
                WXMediaMessage wXMediaMessage = new WXMediaMessage();
                wXMediaMessage.mediaObject = wXEmojiObject;
                wXMediaMessage.thumbData = U(emotionShare.image.p());
                SendMessageToWX.Req req = new SendMessageToWX.Req();
                req.transaction = X("imageShare");
                req.message = wXMediaMessage;
                req.scene = W();
                this.m.sendReq(req);
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final void h0(ShareEntity shareEntity, Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048590, this, shareEntity, bitmap) == null) && shareEntity != null && this.m != null && bitmap != null) {
            WXEmojiObject wXEmojiObject = new WXEmojiObject();
            wXEmojiObject.emojiData = V(bitmap, 512, false);
            WXMediaMessage wXMediaMessage = new WXMediaMessage();
            wXMediaMessage.mediaObject = wXEmojiObject;
            wXMediaMessage.thumbData = U(bitmap);
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = X("imageShare");
            req.message = wXMediaMessage;
            req.scene = W();
            this.m.sendReq(req);
        }
    }

    public final void j0(ShareEntity shareEntity, Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048592, this, shareEntity, bitmap) == null) && shareEntity != null && this.m != null && bitmap != null) {
            WXImageObject wXImageObject = new WXImageObject(bitmap);
            if (d0(wXImageObject, bitmap)) {
                return;
            }
            wXImageObject.imageData = si.d().a(bitmap, 85);
            WXMediaMessage wXMediaMessage = new WXMediaMessage();
            wXMediaMessage.mediaObject = wXImageObject;
            wXMediaMessage.thumbData = U(bitmap);
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = X("imageShare");
            req.message = wXMediaMessage;
            req.scene = W();
            this.m.sendReq(req);
        }
    }

    public final void n0(ShareEntity shareEntity, Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048596, this, shareEntity, bitmap) == null) && shareEntity != null && this.m != null) {
            WXVideoObject wXVideoObject = new WXVideoObject();
            wXVideoObject.videoUrl = shareEntity.getVideoUrl();
            WXMediaMessage wXMediaMessage = new WXMediaMessage(wXVideoObject);
            wXMediaMessage.title = shareEntity.getTitle();
            wXMediaMessage.description = shareEntity.getContent();
            wXMediaMessage.thumbData = U(bitmap);
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = X("videoShare");
            req.message = wXMediaMessage;
            req.scene = W();
            this.m.sendReq(req);
        }
    }

    public final void o0(ShareEntity shareEntity, Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048597, this, shareEntity, bitmap) == null) && shareEntity != null && this.m != null) {
            WXWebpageObject wXWebpageObject = new WXWebpageObject();
            wXWebpageObject.webpageUrl = shareEntity.getLinkUrl();
            WXMediaMessage wXMediaMessage = new WXMediaMessage(wXWebpageObject);
            wXMediaMessage.title = shareEntity.getTitle();
            wXMediaMessage.description = shareEntity.getContent();
            wXMediaMessage.thumbData = U(bitmap);
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = X("webpageShare");
            req.message = wXMediaMessage;
            req.scene = W();
            this.m.sendReq(req);
        }
    }

    public final void t0(int i, String str) {
        ShareEntity shareEntity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048604, this, i, str) == null) && (shareEntity = this.e) != null && !StringUtils.isNull(shareEntity.getImgUrl())) {
            ry4.a("socail_share", -1L, 0, WXEntryActivityConfig.WX_SHARE_FAIL, i, "", "share_fail_exception", str + "&" + this.e.getImgUrl());
        }
    }

    public final String X(String str) {
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

    public boolean Z(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, context)) == null) {
            if (this.m.getWXAppSupportAPI() >= 654314752) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void r0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, str) == null) {
            Bitmap i = i(str);
            if (i == null) {
                i = e();
            }
            if (i != null) {
                j0(this.e, i);
            } else {
                m0(this.e);
            }
        }
    }

    @Override // com.baidu.tieba.br8
    public void t(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, bdUniqueId) == null) {
            super.t(bdUniqueId);
            e0();
        }
    }

    public byte[] U(Bitmap bitmap) {
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

    public final void m0(ShareEntity shareEntity) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048595, this, shareEntity) == null) && shareEntity != null && this.m != null) {
            String content = shareEntity.getContent();
            WXTextObject wXTextObject = new WXTextObject();
            wXTextObject.text = content;
            WXMediaMessage wXMediaMessage = new WXMediaMessage();
            wXMediaMessage.mediaObject = wXTextObject;
            wXMediaMessage.description = content;
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = X("textShare");
            req.message = wXMediaMessage;
            req.scene = W();
            this.m.sendReq(req);
        }
    }

    public byte[] V(Bitmap bitmap, int i, boolean z) {
        InterceptResult invokeCommon;
        Bitmap k;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{bitmap, Integer.valueOf(i), Boolean.valueOf(z)})) == null) {
            try {
                if (z) {
                    k = f(R.drawable.obfuscated_res_0x7f080ddf);
                } else {
                    k = k(bitmap, i);
                }
                if (k == null) {
                    k = f(R.drawable.obfuscated_res_0x7f080ddf);
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

    public final int W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            int i = this.k;
            if (i == 3) {
                return 0;
            }
            if (i == 2) {
                return 1;
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public boolean Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (Build.VERSION.SDK_INT >= 24) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void b0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            FileHelper.deleteFile(new File(br8.h + br8.j));
        }
    }

    public final void e0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && this.b != null) {
            this.n = new d(this, null);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(WXEntryActivityConfig.ACTION_WX_SHARE_RESULT);
            this.b.registerReceiver(this.n, intentFilter);
        }
    }

    public final void q0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            Bitmap e = e();
            if (e != null) {
                j0(this.e, e);
            } else {
                m0(this.e);
            }
        }
    }

    @Override // com.baidu.tieba.br8
    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            s0();
            super.s();
        }
    }

    public final void s0() {
        Context context;
        d dVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048602, this) == null) && (context = this.b) != null && (dVar = this.n) != null) {
            context.unregisterReceiver(dVar);
        }
    }

    @Override // com.baidu.tieba.hr8
    public void a(ShareEntity shareEntity, ir8 ir8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, shareEntity, ir8Var) == null) {
            if (shareEntity != null && this.m != null) {
                this.e = shareEntity;
                this.l = ir8Var;
                this.k = shareEntity.getShareTo();
                if (!this.m.isWXAppInstalled()) {
                    ir8 ir8Var2 = this.l;
                    if (ir8Var2 != null) {
                        ir8Var2.b1(this.k, 2);
                    }
                    BdToast.b(d(), d().getText(R.string.obfuscated_res_0x7f0f1213)).k();
                    return;
                }
                jn r = r(shareEntity);
                if (r != null && r.p() != null) {
                    if (this.e.getShareType() == 2) {
                        h0(this.e, r.p());
                        return;
                    } else {
                        j0(this.e, r.p());
                        return;
                    }
                } else if (q(shareEntity.getLocalFile())) {
                    r0(shareEntity.getLocalFile());
                    return;
                } else {
                    String imgUrl = shareEntity.getImgUrl();
                    if (!TextUtils.isEmpty(imgUrl) && (imgUrl.startsWith("http://") || imgUrl.startsWith("https://"))) {
                        if (this.e.getShareType() != 0) {
                            ug.h().k(imgUrl, 34, this.o, 0, 0, j(), new Object[0]);
                            return;
                        } else {
                            ug.h().k(imgUrl, 10, this.p, 0, 0, j(), new Object[0]);
                            return;
                        }
                    } else if (p(shareEntity.getImageUri())) {
                        r0(shareEntity.getImageUri().getPath());
                        return;
                    } else {
                        q0();
                        return;
                    }
                }
            }
            u(2, this.k);
            if (ir8Var != null) {
                ir8Var.b1(0, 2);
            }
        }
    }

    public byte[] a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            try {
                Bitmap f = f(R.drawable.obfuscated_res_0x7f080ddf);
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

    public String c0(Context context, File file) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, context, file)) == null) {
            if (file != null && file.exists()) {
                Uri uriForFile = FileProvider.getUriForFile(context, context.getPackageName() + ".fileprovider", file);
                context.grantUriPermission("com.tencent.mm", uriForFile, 1);
                return uriForFile.toString();
            }
            return null;
        }
        return (String) invokeLL.objValue;
    }

    public final boolean d0(WXImageObject wXImageObject, Bitmap bitmap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, wXImageObject, bitmap)) == null) {
            Context context = this.b;
            if (context != null && wXImageObject != null && bitmap != null && Z(context) && Y()) {
                try {
                    f0(wXImageObject, FileHelper.saveFileAsPNG(br8.h, br8.j, bitmap, 100), bitmap);
                    return true;
                } catch (Exception e) {
                    BdLog.e(e);
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final void f0(@NonNull WXImageObject wXImageObject, @NonNull String str, @NonNull Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048588, this, wXImageObject, str, bitmap) == null) {
            wXImageObject.setImagePath(c0(this.b, new File(str)));
            WXMediaMessage wXMediaMessage = new WXMediaMessage();
            wXMediaMessage.mediaObject = wXImageObject;
            wXMediaMessage.thumbData = U(bitmap);
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = X("imageShare");
            req.message = wXMediaMessage;
            req.scene = W();
            this.m.sendReq(req);
        }
    }

    public final boolean i0(ShareEntity shareEntity, EmotionShareLoaderProc.EmotionShare emotionShare) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048591, this, shareEntity, emotionShare)) == null) {
            if (this.k != 2 && this.e.getShareType() != 1) {
                return g0(shareEntity, emotionShare);
            }
            return k0(shareEntity, emotionShare);
        }
        return invokeLL.booleanValue;
    }

    public final void p0(ShareEntity shareEntity, Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048598, this, shareEntity, bitmap) == null) {
            if (shareEntity.getIsVideoThread()) {
                b bVar = new b(this);
                bVar.setPriority(3);
                bVar.execute(bitmap);
                return;
            }
            o0(this.e, bitmap);
        }
    }

    public final boolean k0(ShareEntity shareEntity, EmotionShareLoaderProc.EmotionShare emotionShare) {
        InterceptResult invokeLL;
        jn jnVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048593, this, shareEntity, emotionShare)) == null) {
            if (shareEntity != null && this.m != null && emotionShare != null && !StringUtils.isNull(emotionShare.path) && (jnVar = emotionShare.image) != null && jnVar.p() != null) {
                WXImageObject wXImageObject = new WXImageObject();
                wXImageObject.setImagePath(emotionShare.path);
                if (d0(wXImageObject, emotionShare.image.p())) {
                    return true;
                }
                WXMediaMessage wXMediaMessage = new WXMediaMessage();
                wXMediaMessage.mediaObject = wXImageObject;
                wXMediaMessage.thumbData = U(emotionShare.image.p());
                SendMessageToWX.Req req = new SendMessageToWX.Req();
                req.transaction = X("imageShare");
                req.message = wXMediaMessage;
                req.scene = W();
                this.m.sendReq(req);
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final void l0(ShareEntity shareEntity, Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048594, this, shareEntity, bitmap) == null) && shareEntity != null && this.m != null) {
            WXMiniProgramObject wXMiniProgramObject = new WXMiniProgramObject();
            wXMiniProgramObject.webpageUrl = shareEntity.getLinkUrl();
            wXMiniProgramObject.miniprogramType = 0;
            wXMiniProgramObject.userName = "gh_213e5678c5bf";
            if (shareEntity.getTypeShareToSmallApp() != 2 && shareEntity.getTypeShareToSmallApp() != 4) {
                String tid = shareEntity.getTid();
                wXMiniProgramObject.path = "/pages/pb/pb?tid=" + tid;
            } else {
                String str = shareEntity.getfName();
                if (yi.isEmpty(str)) {
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
                wXMediaMessage.thumbData = u0(bitmap, true);
            } else {
                wXMediaMessage.thumbData = u0(bitmap, false);
            }
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = X("miniProgram");
            req.message = wXMediaMessage;
            req.scene = 0;
            this.m.sendReq(req);
        }
    }

    public byte[] u0(Bitmap bitmap, boolean z) {
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
                    if (bitmap == null) {
                        return a0();
                    }
                    return byteArray;
                }
                return a0();
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return (byte[]) invokeLZ.objValue;
    }
}
