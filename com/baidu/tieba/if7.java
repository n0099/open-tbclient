package com.baidu.tieba;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.FullBrowseHelper;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StorageFile;
import com.baidu.tbadk.core.util.TbMd5;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.util.resourceLoaderProc.BigImageLoaderProc;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.coreExtra.view.ImageViewerBottomLayout;
import com.baidu.tbadk.coreExtra.view.MultiImageView;
import com.baidu.tbadk.coreExtra.view.UrlDragImageView;
import com.baidu.tbadk.mutiprocess.event.CollectEmotionEvent;
import com.baidu.tbadk.widget.DragImageView;
import com.baidu.tieba.av4;
import com.baidu.tieba.image.ImageViewerActivity;
import com.baidu.tieba.ju8;
import com.baidu.tieba.pu4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
public class if7 implements ImageViewerBottomLayout.c, ImageViewerBottomLayout.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ImageViewerActivity a;
    public MultiImageView b;
    public PermissionJudgePolicy c;
    public k d;
    public String e;
    public ju8 f;
    public yu4 g;
    public av4 h;
    public List i;
    public wu4 j;
    public wu4 k;
    public wu4 l;
    public wu4 m;
    public wu4 n;
    public wu4 o;
    public ff7 p;
    public HashMap q;
    public CustomMessageListener r;
    public sa5 s;
    public av4.d t;
    public av4.d u;
    public av4.d v;
    public av4.d w;
    public av4.d x;
    public av4.d y;
    public View.OnClickListener z;

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
        }
    }

    /* loaded from: classes4.dex */
    public class j implements av4.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ if7 a;

        /* loaded from: classes4.dex */
        public class a implements ju8.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String a;
            public final /* synthetic */ j b;

            /* renamed from: com.baidu.tieba.if7$j$a$a  reason: collision with other inner class name */
            /* loaded from: classes4.dex */
            public class C0272a implements pu4.e {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ a a;

                public C0272a(a aVar) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {aVar};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = aVar;
                }

                @Override // com.baidu.tieba.pu4.e
                public void onClick(pu4 pu4Var) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(1048576, this, pu4Var) == null) {
                        pu4Var.dismiss();
                        a aVar = this.a;
                        aVar.b.a.B(aVar.a);
                    }
                }
            }

            /* loaded from: classes4.dex */
            public class b implements pu4.e {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                public b(a aVar) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {aVar};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                @Override // com.baidu.tieba.pu4.e
                public void onClick(pu4 pu4Var) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(1048576, this, pu4Var) == null) {
                        pu4Var.dismiss();
                    }
                }
            }

            /* loaded from: classes4.dex */
            public class c implements pu4.e {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                public c(a aVar) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {aVar};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                @Override // com.baidu.tieba.pu4.e
                public void onClick(pu4 pu4Var) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(1048576, this, pu4Var) == null) {
                        pu4Var.dismiss();
                    }
                }
            }

            public a(j jVar, String str) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {jVar, str};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = jVar;
                this.a = str;
            }

            @Override // com.baidu.tieba.ju8.a
            public void a() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    pu4 pu4Var = new pu4(this.b.a.a.getPageContext().getPageActivity());
                    pu4Var.setTitle((String) null);
                    pu4Var.setMessageShowCenter(true);
                    pu4Var.setMessage(this.b.a.v(R.string.obfuscated_res_0x7f0f0f9a));
                    pu4Var.setPositiveButton(this.b.a.v(R.string.obfuscated_res_0x7f0f0f9b), new c(this));
                    pu4Var.setCancelable(false);
                    pu4Var.setCanceledOnTouchOutside(false);
                    pu4Var.create(this.b.a.a.getPageContext()).show();
                }
            }

            @Override // com.baidu.tieba.ju8.a
            public void b() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    pu4 pu4Var = new pu4(this.b.a.a.getPageContext().getPageActivity());
                    pu4Var.setTitleShowCenter(true);
                    pu4Var.setTitle(this.b.a.v(R.string.obfuscated_res_0x7f0f0f99));
                    pu4Var.setMessageShowCenter(true);
                    pu4Var.setMessage(this.b.a.v(R.string.obfuscated_res_0x7f0f0f98));
                    pu4Var.setPositiveButton(this.b.a.v(R.string.obfuscated_res_0x7f0f043d), new C0272a(this));
                    pu4Var.setNegativeButton(this.b.a.v(R.string.obfuscated_res_0x7f0f0375), new b(this));
                    pu4Var.setCancelable(false);
                    pu4Var.setCanceledOnTouchOutside(false);
                    pu4Var.create(this.b.a.a.getPageContext()).show();
                }
            }

            @Override // com.baidu.tieba.ju8.a
            public void c() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    this.b.a.B(this.a);
                }
            }

            @Override // com.baidu.tieba.ju8.a
            public void onError(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
                    fj.N(this.b.a.a.getPageContext().getPageActivity(), this.b.a.v(R.string.obfuscated_res_0x7f0f0f97));
                }
            }
        }

        public j(if7 if7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {if7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = if7Var;
        }

        @Override // com.baidu.tieba.av4.d
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                String currentImageQRInfo = this.a.b.getCurrentImageQRInfo();
                if (!TextUtils.isEmpty(currentImageQRInfo) && !"qr_none".equals(currentImageQRInfo)) {
                    if (!fj.D()) {
                        fj.N(this.a.a.getPageContext().getPageActivity(), this.a.v(R.string.obfuscated_res_0x7f0f0c69));
                        return;
                    }
                    if (this.a.f != null && !this.a.f.isCancelled()) {
                        this.a.f.cancel();
                    }
                    this.a.f = new ju8(currentImageQRInfo, new a(this, currentImageQRInfo));
                    this.a.f.setPriority(3);
                    this.a.f.execute(new String[0]);
                    this.a.w();
                    this.a.t(5);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ if7 a;

        public a(if7 if7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {if7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = if7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            UrlDragImageView currentUrlDragImageView;
            String str;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || this.a.b == null || (currentUrlDragImageView = this.a.b.getCurrentUrlDragImageView()) == null) {
                return;
            }
            ImageUrlData imageUrlData = currentUrlDragImageView.getmAssistUrlData();
            String str2 = "";
            if (imageUrlData == null) {
                str = "";
            } else {
                str2 = imageUrlData.imageUrl;
                str = BigImageLoaderProc.getNameMd5FromUrl(str2);
            }
            if (TextUtils.isEmpty(str2)) {
                str2 = this.a.b.getCurrentImageUrl();
                str = TbMd5.getNameMd5FromUrl(str2);
            }
            ShareItem shareItem = new ShareItem();
            if (imageUrlData != null) {
                long j = imageUrlData.threadId;
                if (j > 0) {
                    shareItem.x = TbConfig.HTTPS_PB_PREFIX + j + "?fr=share";
                }
            }
            if (!ej.isEmpty(str2)) {
                shareItem.z = Uri.parse(str2);
                shareItem.h0 = 2;
                shareItem.v = this.a.v(R.string.obfuscated_res_0x7f0f10c1);
                shareItem.w = this.a.v(R.string.obfuscated_res_0x7f0f10c1);
                shareItem.A = str2;
                Bundle bundle = new Bundle();
                bundle.putString("path", "images");
                bundle.putString("name", str);
                bundle.putBoolean("formatData", true);
                bundle.putBoolean("isSubDir", true);
                bundle.putBoolean("isSdcard", false);
                bundle.putBoolean("isSavedCache", true);
                shareItem.E = bundle;
            }
            new Bundle().putInt("obj_locate", 13);
            new k35(this.a.a, null).s(shareItem);
        }
    }

    /* loaded from: classes4.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ if7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(if7 if7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {if7Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = if7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage customResponsedMessage) {
            sn8 sn8Var;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof sn8) || this.a.a.isFinishing() || (sn8Var = (sn8) customResponsedMessage.getData()) == null) {
                return;
            }
            sn8Var.c = null;
            if (!TextUtils.isEmpty(sn8Var.e) && !TextUtils.isEmpty(sn8Var.b) && sn8Var.b.equals(this.a.e)) {
                this.a.b.setCurrentImageQRInfo(sn8Var.e);
                this.a.u(sn8Var.e);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends sa5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ if7 c;

        public c(if7 if7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {if7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = if7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.la5
        /* renamed from: a */
        public boolean onEvent(CollectEmotionEvent collectEmotionEvent) {
            InterceptResult invokeL;
            ImageView imageView;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, collectEmotionEvent)) == null) {
                String picId = collectEmotionEvent.getPicId();
                if (!TextUtils.isEmpty(picId)) {
                    this.c.q.put(picId, Boolean.TRUE);
                }
                if (this.c.a != null && (imageView = (ImageView) this.c.a.findViewById(R.id.obfuscated_res_0x7f091e84)) != null) {
                    WebPManager.setPureDrawable(imageView, R.drawable.obfuscated_res_0x7f080950, R.color.CAM_X0104, WebPManager.ResourceStateType.NORMAL_PRESS_DISABLE);
                }
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class d implements av4.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ if7 a;

        public d(if7 if7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {if7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = if7Var;
        }

        @Override // com.baidu.tieba.av4.c
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.w();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements av4.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ if7 a;

        public e(if7 if7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {if7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = if7Var;
        }

        @Override // com.baidu.tieba.av4.d
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.b.m(this.a.a.I2());
                this.a.w();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements av4.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ if7 a;

        public f(if7 if7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {if7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = if7Var;
        }

        @Override // com.baidu.tieba.av4.d
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                df7.a(this.a.a.getPageContext().getPageActivity(), this.a.b.getCurrentImageUrl());
                this.a.w();
                this.a.t(1);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g implements av4.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ if7 a;

        public g(if7 if7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {if7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = if7Var;
        }

        @Override // com.baidu.tieba.av4.d
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                String currentOriginalUrl = this.a.b.getCurrentOriginalUrl();
                String currentImageUrl = this.a.b.getCurrentImageUrl();
                String currentPicId = this.a.b.getCurrentPicId();
                if (TbadkCoreApplication.getInst().isMainProcess(true)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, currentOriginalUrl));
                } else {
                    Intent intent = new Intent(m85.a);
                    intent.setPackage(TbadkCoreApplication.getInst().getPackageName());
                    intent.putExtra(m85.b, currentOriginalUrl);
                    intent.putExtra(m85.c, currentImageUrl);
                    intent.putExtra(m85.d, currentPicId);
                    TbadkCoreApplication.getInst().sendBroadcast(intent);
                }
                this.a.w();
                this.a.t(2);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h implements av4.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ if7 a;

        public h(if7 if7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {if7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = if7Var;
        }

        @Override // com.baidu.tieba.av4.d
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Activity pageActivity = this.a.a.getPageContext().getPageActivity();
                if (this.a.c == null) {
                    this.a.c = new PermissionJudgePolicy();
                }
                this.a.c.clearRequestPermissionList();
                this.a.c.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                if (!this.a.c.startRequestPermission(pageActivity)) {
                    this.a.E();
                    this.a.w();
                    this.a.t(3);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i implements av4.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ if7 a;

        public i(if7 if7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {if7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = if7Var;
        }

        @Override // com.baidu.tieba.av4.d
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.A();
                this.a.w();
                this.a.t(4);
                this.a.s();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class k extends BdAsyncTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public byte[] b;
        public final /* synthetic */ if7 c;

        public k(if7 if7Var, String str, byte[] bArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {if7Var, str, bArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = if7Var;
            this.a = str;
            this.b = bArr;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.c.d = null;
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            InterceptResult invokeL;
            byte[] bArr;
            String nameMd5FromUrl;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, strArr)) == null) {
                Map O2 = this.c.a.O2();
                if (this.a != null && O2 != null) {
                    ImageUrlData imageUrlData = null;
                    Iterator it = O2.entrySet().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        Map.Entry entry = (Map.Entry) it.next();
                        if (entry != null && entry.getKey() != null && entry.getValue() != null && ((String) entry.getKey()).contains(this.a)) {
                            imageUrlData = (ImageUrlData) entry.getValue();
                            break;
                        }
                    }
                    if (imageUrlData != null) {
                        String str = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath() + StorageFile.getInstance().getDirectoryName(nameMd5FromUrl) + "/" + TbMd5.getNameMd5FromUrl(imageUrlData.originalUrl);
                        int[] imageFileWH = FileHelper.getImageFileWH(str);
                        if (imageFileWH != null && imageFileWH.length == 2 && imageFileWH[0] > 0 && FileHelper.copyImageFile(str, this.a, this.c.a.getPageContext().getPageActivity()) == 0) {
                            return this.c.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f10bd);
                        }
                    }
                }
                String str2 = this.a;
                if (str2 != null && (bArr = this.b) != null) {
                    int saveImageFileByUser = FileHelper.saveImageFileByUser(str2, bArr, this.c.a.getPageContext().getPageActivity());
                    if (saveImageFileByUser != -2) {
                        if (saveImageFileByUser == 0) {
                            return this.c.v(R.string.obfuscated_res_0x7f0f10bd);
                        }
                    } else {
                        return FileHelper.getSdErrorString();
                    }
                }
                return this.c.v(R.string.obfuscated_res_0x7f0f10bc);
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                super.onPostExecute((k) str);
                if (UbsABTestHelper.isImageViewerTestB() && !this.c.v(R.string.obfuscated_res_0x7f0f10bc).equals(str)) {
                    if (this.c.p != null) {
                        this.c.p.g(this.c.b, this.c.b.getBottomHeight(), this.c.z);
                    }
                } else {
                    this.c.a.showToast(str);
                }
                this.c.d = null;
            }
        }
    }

    public if7(ImageViewerActivity imageViewerActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {imageViewerActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = null;
        this.i = null;
        this.q = new HashMap();
        this.r = new b(this, 2921403);
        this.s = new c(this);
        this.t = new e(this);
        this.u = new f(this);
        this.v = new g(this);
        this.w = new h(this);
        this.x = new i(this);
        this.y = new j(this);
        this.z = new a(this);
        this.a = imageViewerActivity;
        imageViewerActivity.registerListener(this.r);
        this.p = new ff7(imageViewerActivity);
        this.a.registerResponsedEventListener(CollectEmotionEvent.class, this.s);
    }

    public void u(String str) {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, str) == null) && this.g != null && !this.a.isFinishing() && this.g.isShowing() && !TextUtils.isEmpty(str) && !"qr_none".equals(str)) {
            wu4 wu4Var = new wu4(v(R.string.obfuscated_res_0x7f0f08f7), this.h);
            this.o = wu4Var;
            wu4Var.m(this.y);
            boolean z = false;
            int i3 = 0;
            while (true) {
                if (i3 < this.i.size()) {
                    if (this.k != null && this.i.get(i3) == this.k && (i2 = i3 + 1) <= this.i.size()) {
                        this.i.add(i2, this.o);
                        z = true;
                        break;
                    }
                    i3++;
                } else {
                    break;
                }
            }
            if (!z) {
                this.i.add(this.o);
            }
            this.h.j(this.i);
        }
    }

    public void y(View view2) {
        Bitmap imageBitmap;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048591, this, view2) != null) || view2 == null || !(view2 instanceof DragImageView)) {
            return;
        }
        DragImageView dragImageView = (DragImageView) view2;
        ImageUrlData imageUrlData = dragImageView.getImageUrlData();
        if ((imageUrlData == null || TextUtils.isEmpty(imageUrlData.qrInfo)) && (imageBitmap = dragImageView.getImageBitmap()) != null && !imageBitmap.isRecycled()) {
            sn8 sn8Var = new sn8();
            sn8Var.a = 0;
            sn8Var.c = imageBitmap;
            String currentImageUrl = this.b.getCurrentImageUrl();
            if (!TextUtils.isEmpty(currentImageUrl)) {
                sn8Var.b = String.valueOf(System.currentTimeMillis()) + TbMd5.getNameMd5FromUrl(currentImageUrl);
            } else {
                sn8Var.b = String.valueOf(BdUniqueId.gen().getId());
            }
            this.e = sn8Var.b;
            this.a.sendMessage(new CustomMessage(2921403, sn8Var));
        }
    }

    public final void B(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(this.a.getPageContext().getPageActivity(), null, str, false)));
        }
    }

    public final String v(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i2)) == null) {
            return this.a.getString(i2);
        }
        return (String) invokeI.objValue;
    }

    public void A() {
        MultiImageView multiImageView;
        UrlDragImageView currentUrlDragImageView;
        String str;
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || (multiImageView = this.b) == null || (currentUrlDragImageView = multiImageView.getCurrentUrlDragImageView()) == null) {
            return;
        }
        ImageUrlData imageUrlData = currentUrlDragImageView.getmAssistUrlData();
        String str2 = "";
        if (imageUrlData == null) {
            str = "";
        } else {
            str2 = imageUrlData.imageUrl;
            str = BigImageLoaderProc.getNameMd5FromUrl(str2);
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = this.b.getCurrentImageUrl();
            str = TbMd5.getNameMd5FromUrl(str2);
        }
        ShareItem shareItem = new ShareItem();
        if (imageUrlData != null) {
            long j2 = imageUrlData.threadId;
            if (j2 > 0) {
                shareItem.x = TbConfig.HTTPS_PB_PREFIX + j2 + "?fr=share";
            }
        }
        boolean z2 = false;
        if (!ej.isEmpty(str2)) {
            shareItem.z = Uri.parse(str2);
            shareItem.h0 = 1;
            Bundle bundle = new Bundle();
            bundle.putString("path", "images");
            bundle.putString("name", str);
            bundle.putBoolean("formatData", true);
            bundle.putBoolean("isSubDir", true);
            bundle.putBoolean("isSdcard", false);
            bundle.putBoolean("isSavedCache", true);
            shareItem.E = bundle;
        }
        shareItem.j = true;
        shareItem.I = 23;
        ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.a, shareItem, false);
        if (UbsABTestHelper.isImageViewerTestA()) {
            shareDialogConfig.isImageViewerDialog = true;
            shareDialogConfig.originImgText = this.b.o(this.a.I2());
            ImageViewerActivity imageViewerActivity = this.a;
            if (imageViewerActivity != null && !imageViewerActivity.g3()) {
                z = true;
            } else {
                z = false;
            }
            shareDialogConfig.showAddEmotion = z;
            String currentImageQRInfo = this.b.getCurrentImageQRInfo();
            if (!TextUtils.isEmpty(currentImageQRInfo) && !currentImageQRInfo.equals("qr_none")) {
                z2 = true;
            }
            shareDialogConfig.showQRCode = z2;
            shareDialogConfig.dialogSaveToDiskListener = this.w;
            shareDialogConfig.dialogAddToExpressionListener = this.v;
            shareDialogConfig.dialogDownloadOriginListener = this.t;
            shareDialogConfig.dialogRecognizePicListener = this.u;
            shareDialogConfig.qrCodeClickListener = this.y;
            shareDialogConfig.onWeChatEmotionShareListener = this.z;
        }
        ImageViewerActivity imageViewerActivity2 = this.a;
        if (imageViewerActivity2 != null) {
            imageViewerActivity2.sendMessage(new CustomMessage(2001276, shareDialogConfig));
        }
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.i.clear();
            String o = this.b.o(this.a.I2());
            if (o != null) {
                wu4 wu4Var = new wu4(o, this.h);
                this.j = wu4Var;
                wu4Var.m(this.t);
                this.i.add(this.j);
            }
            wu4 wu4Var2 = new wu4(v(R.string.obfuscated_res_0x7f0f10c2), this.h);
            this.l = wu4Var2;
            wu4Var2.m(this.w);
            this.i.add(this.l);
            ImageViewerActivity imageViewerActivity = this.a;
            if (imageViewerActivity != null && !imageViewerActivity.g3()) {
                wu4 wu4Var3 = new wu4(v(R.string.obfuscated_res_0x7f0f10c1), this.h);
                this.m = wu4Var3;
                wu4Var3.m(this.v);
                this.i.add(this.m);
            }
            wu4 wu4Var4 = new wu4(v(R.string.obfuscated_res_0x7f0f08d0), this.h);
            this.k = wu4Var4;
            wu4Var4.m(this.u);
            this.i.add(this.k);
            String currentImageQRInfo = this.b.getCurrentImageQRInfo();
            if (!TextUtils.isEmpty(currentImageQRInfo) && !currentImageQRInfo.equals("qr_none")) {
                wu4 wu4Var5 = new wu4(v(R.string.obfuscated_res_0x7f0f08f7), this.h);
                this.o = wu4Var5;
                wu4Var5.m(this.y);
                this.i.add(this.o);
            }
            wu4 wu4Var6 = new wu4(v(R.string.obfuscated_res_0x7f0f08fa), this.h);
            this.n = wu4Var6;
            wu4Var6.m(this.x);
            this.i.add(this.n);
            this.h.m(new d(this));
            this.h.j(this.i);
        }
    }

    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            k kVar = this.d;
            if (kVar != null) {
                kVar.cancel();
                this.d = null;
            }
            ju8 ju8Var = this.f;
            if (ju8Var != null) {
                ju8Var.cancel();
                this.f = null;
            }
            ff7 ff7Var = this.p;
            if (ff7Var != null) {
                ff7Var.f();
            }
            ImageViewerActivity imageViewerActivity = this.a;
            if (imageViewerActivity != null) {
                imageViewerActivity.unRegisterResponsedEventListener();
            }
        }
    }

    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.e = null;
        }
    }

    public void G() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && this.g != null && !this.a.isFinishing()) {
            this.g.k();
        }
    }

    public void w() {
        yu4 yu4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && (yu4Var = this.g) != null && yu4Var.isShowing()) {
            this.g.dismiss();
        }
    }

    public void z() {
        av4 av4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && (av4Var = this.h) != null) {
            av4Var.i();
        }
    }

    public final void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            try {
                k kVar = new k(this, this.b.getCurrentImageUrl(), this.b.getCurrentImageData());
                this.d = kVar;
                kVar.execute(new String[0]);
                if (ImageViewerConfig.FROM_DISCOVER_BEAUTY.equals(this.a.R2())) {
                    TiebaStatic.log("c12173");
                }
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.ImageViewerBottomLayout.b
    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            Activity pageActivity = this.a.getPageContext().getPageActivity();
            if (this.c == null) {
                this.c = new PermissionJudgePolicy();
            }
            this.c.clearRequestPermissionList();
            this.c.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (this.c.startRequestPermission(pageActivity)) {
                return;
            }
            E();
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.ImageViewerBottomLayout.c
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            String currentOriginalUrl = this.b.getCurrentOriginalUrl();
            String currentImageUrl = this.b.getCurrentImageUrl();
            String currentPicId = this.b.getCurrentPicId();
            if (this.q.containsKey(currentPicId) && ((Boolean) this.q.get(currentPicId)).booleanValue()) {
                fj.M(TbadkCoreApplication.getInst(), R.string.obfuscated_res_0x7f0f10b8);
                return;
            }
            if (TbadkCoreApplication.getInst().isMainProcess(true)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, currentOriginalUrl));
            } else if (FullBrowseHelper.checkAndShowFullBrowseModeDialog(this.a.getPageContext(), null)) {
                return;
            } else {
                Intent intent = new Intent(m85.a);
                intent.setPackage(TbadkCoreApplication.getInst().getPackageName());
                intent.putExtra(m85.b, currentOriginalUrl);
                intent.putExtra(m85.c, currentImageUrl);
                intent.putExtra(m85.d, currentPicId);
                TbadkCoreApplication.getInst().sendBroadcast(intent);
            }
            t(2);
        }
    }

    public final void t(int i2) {
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            TiebaStatic.log(new StatisticItem("c13270").param("uid", this.a.S2()).param("obj_type", i2));
            if (i2 == 1) {
                i3 = 22;
            } else if (i2 == 2) {
                i3 = 21;
            } else if (i2 == 3) {
                i3 = 20;
            } else {
                i3 = 0;
            }
            if (i3 != 0) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("obj_type", i3));
            }
        }
    }

    public void x(MultiImageView multiImageView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, multiImageView) == null) {
            this.b = multiImageView;
            if (this.g == null) {
                this.h = new av4(this.a);
            }
            if (this.i == null) {
                this.i = new ArrayList();
            }
            F();
            this.g = new yu4(this.a.getPageContext(), this.h);
        }
    }
}
