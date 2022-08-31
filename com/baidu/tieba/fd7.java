package com.baidu.tieba;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.imsdk.internal.Constants;
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
import com.baidu.tieba.gs4;
import com.baidu.tieba.image.ImageViewerActivity;
import com.baidu.tieba.ur8;
import com.baidu.tieba.vr4;
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
public class fd7 implements ImageViewerBottomLayout.c, ImageViewerBottomLayout.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ImageViewerActivity a;
    public MultiImageView b;
    public PermissionJudgePolicy c;
    public k d;
    public String e;
    public ur8 f;
    public es4 g;
    public gs4 h;
    public List<cs4> i;
    public cs4 j;
    public cs4 k;
    public cs4 l;
    public cs4 m;
    public cs4 n;
    public cs4 o;
    public dd7 p;
    public HashMap<String, Boolean> q;
    public CustomMessageListener r;
    public t75 s;
    public gs4.d t;
    public gs4.d u;
    public gs4.d v;
    public gs4.d w;
    public gs4.d x;
    public gs4.d y;
    public View.OnClickListener z;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fd7 a;

        public a(fd7 fd7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fd7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fd7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            UrlDragImageView currentUrlDragImageView;
            String str;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.b == null || (currentUrlDragImageView = this.a.b.getCurrentUrlDragImageView()) == null) {
                return;
            }
            ImageUrlData imageUrlData = currentUrlDragImageView.getmAssistUrlData();
            String str2 = "";
            if (imageUrlData != null) {
                str2 = imageUrlData.imageUrl;
                str = BigImageLoaderProc.getNameMd5FromUrl(str2);
            } else {
                str = "";
            }
            if (TextUtils.isEmpty(str2)) {
                str2 = this.a.b.getCurrentImageUrl();
                str = TbMd5.getNameMd5FromUrl(str2);
            }
            ShareItem shareItem = new ShareItem();
            if (imageUrlData != null) {
                long j = imageUrlData.threadId;
                if (j > 0) {
                    shareItem.w = "https://tieba.baidu.com/p/" + j + "?fr=share";
                }
            }
            if (!qi.isEmpty(str2)) {
                shareItem.y = Uri.parse(str2);
                shareItem.g0 = 2;
                shareItem.u = this.a.v(R.string.obfuscated_res_0x7f0f1091);
                shareItem.v = this.a.v(R.string.obfuscated_res_0x7f0f1091);
                shareItem.z = str2;
                Bundle bundle = new Bundle();
                bundle.putString("path", "images");
                bundle.putString("name", str);
                bundle.putBoolean("formatData", true);
                bundle.putBoolean("isSubDir", true);
                bundle.putBoolean("isSdcard", false);
                bundle.putBoolean("isSavedCache", true);
                shareItem.D = bundle;
            }
            new Bundle().putInt("obj_locate", 13);
            new i05(this.a.a, null).s(shareItem);
        }
    }

    /* loaded from: classes4.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fd7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(fd7 fd7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fd7Var, Integer.valueOf(i)};
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
            this.a = fd7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            il8 il8Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof il8) || this.a.a.isFinishing() || (il8Var = (il8) customResponsedMessage.getData()) == null) {
                return;
            }
            il8Var.c = null;
            if (TextUtils.isEmpty(il8Var.e) || TextUtils.isEmpty(il8Var.b) || !il8Var.b.equals(this.a.e)) {
                return;
            }
            this.a.b.setCurrentImageQRInfo(il8Var.e);
            this.a.u(il8Var.e);
        }
    }

    /* loaded from: classes4.dex */
    public class c extends t75<CollectEmotionEvent> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fd7 c;

        public c(fd7 fd7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fd7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = fd7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.m75
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
                if (this.c.a != null && (imageView = (ImageView) this.c.a.findViewById(R.id.obfuscated_res_0x7f091e35)) != null) {
                    WebPManager.setPureDrawable(imageView, R.drawable.obfuscated_res_0x7f080932, R.color.CAM_X0104, WebPManager.ResourceStateType.NORMAL_PRESS_DISABLE);
                }
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class d implements gs4.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fd7 a;

        public d(fd7 fd7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fd7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fd7Var;
        }

        @Override // com.baidu.tieba.gs4.c
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.w();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements gs4.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fd7 a;

        public e(fd7 fd7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fd7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fd7Var;
        }

        @Override // com.baidu.tieba.gs4.d
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.b.m(this.a.a.D2());
                this.a.w();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements gs4.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fd7 a;

        public f(fd7 fd7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fd7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fd7Var;
        }

        @Override // com.baidu.tieba.gs4.d
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                bd7.a(this.a.a.getPageContext().getPageActivity(), this.a.b.getCurrentImageUrl());
                this.a.w();
                this.a.t(1);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g implements gs4.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fd7 a;

        public g(fd7 fd7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fd7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fd7Var;
        }

        @Override // com.baidu.tieba.gs4.d
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                String currentOriginalUrl = this.a.b.getCurrentOriginalUrl();
                String currentImageUrl = this.a.b.getCurrentImageUrl();
                String currentPicId = this.a.b.getCurrentPicId();
                if (TbadkCoreApplication.getInst().isMainProcess(true)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, currentOriginalUrl));
                } else {
                    Intent intent = new Intent(n55.a);
                    intent.setPackage(TbadkCoreApplication.getInst().getPackageName());
                    intent.putExtra(n55.b, currentOriginalUrl);
                    intent.putExtra(n55.c, currentImageUrl);
                    intent.putExtra(n55.d, currentPicId);
                    TbadkCoreApplication.getInst().sendBroadcast(intent);
                }
                this.a.w();
                this.a.t(2);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h implements gs4.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fd7 a;

        public h(fd7 fd7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fd7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fd7Var;
        }

        @Override // com.baidu.tieba.gs4.d
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Activity pageActivity = this.a.a.getPageContext().getPageActivity();
                if (this.a.c == null) {
                    this.a.c = new PermissionJudgePolicy();
                }
                this.a.c.clearRequestPermissionList();
                this.a.c.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                if (this.a.c.startRequestPermission(pageActivity)) {
                    return;
                }
                this.a.E();
                this.a.w();
                this.a.t(3);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i implements gs4.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fd7 a;

        public i(fd7 fd7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fd7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fd7Var;
        }

        @Override // com.baidu.tieba.gs4.d
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
    public class j implements gs4.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fd7 a;

        /* loaded from: classes4.dex */
        public class a implements ur8.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String a;
            public final /* synthetic */ j b;

            /* renamed from: com.baidu.tieba.fd7$j$a$a  reason: collision with other inner class name */
            /* loaded from: classes4.dex */
            public class C0255a implements vr4.e {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ a a;

                public C0255a(a aVar) {
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

                @Override // com.baidu.tieba.vr4.e
                public void onClick(vr4 vr4Var) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(1048576, this, vr4Var) == null) {
                        vr4Var.dismiss();
                        a aVar = this.a;
                        aVar.b.a.B(aVar.a);
                    }
                }
            }

            /* loaded from: classes4.dex */
            public class b implements vr4.e {
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

                @Override // com.baidu.tieba.vr4.e
                public void onClick(vr4 vr4Var) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(1048576, this, vr4Var) == null) {
                        vr4Var.dismiss();
                    }
                }
            }

            /* loaded from: classes4.dex */
            public class c implements vr4.e {
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

                @Override // com.baidu.tieba.vr4.e
                public void onClick(vr4 vr4Var) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(1048576, this, vr4Var) == null) {
                        vr4Var.dismiss();
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

            @Override // com.baidu.tieba.ur8.a
            public void a() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    vr4 vr4Var = new vr4(this.b.a.a.getPageContext().getPageActivity());
                    vr4Var.setTitle((String) null);
                    vr4Var.setMessageShowCenter(true);
                    vr4Var.setMessage(this.b.a.v(R.string.obfuscated_res_0x7f0f0f69));
                    vr4Var.setPositiveButton(this.b.a.v(R.string.obfuscated_res_0x7f0f0f6a), new c(this));
                    vr4Var.setCancelable(false);
                    vr4Var.setCanceledOnTouchOutside(false);
                    vr4Var.create(this.b.a.a.getPageContext()).show();
                }
            }

            @Override // com.baidu.tieba.ur8.a
            public void b() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    vr4 vr4Var = new vr4(this.b.a.a.getPageContext().getPageActivity());
                    vr4Var.setTitleShowCenter(true);
                    vr4Var.setTitle(this.b.a.v(R.string.obfuscated_res_0x7f0f0f68));
                    vr4Var.setMessageShowCenter(true);
                    vr4Var.setMessage(this.b.a.v(R.string.obfuscated_res_0x7f0f0f67));
                    vr4Var.setPositiveButton(this.b.a.v(R.string.obfuscated_res_0x7f0f0432), new C0255a(this));
                    vr4Var.setNegativeButton(this.b.a.v(R.string.obfuscated_res_0x7f0f0371), new b(this));
                    vr4Var.setCancelable(false);
                    vr4Var.setCanceledOnTouchOutside(false);
                    vr4Var.create(this.b.a.a.getPageContext()).show();
                }
            }

            @Override // com.baidu.tieba.ur8.a
            public void c() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    this.b.a.B(this.a);
                }
            }

            @Override // com.baidu.tieba.ur8.a
            public void onError(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
                    ri.N(this.b.a.a.getPageContext().getPageActivity(), this.b.a.v(R.string.obfuscated_res_0x7f0f0f66));
                }
            }
        }

        public j(fd7 fd7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fd7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fd7Var;
        }

        @Override // com.baidu.tieba.gs4.d
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                String currentImageQRInfo = this.a.b.getCurrentImageQRInfo();
                if (TextUtils.isEmpty(currentImageQRInfo) || "qr_none".equals(currentImageQRInfo)) {
                    return;
                }
                if (!ri.D()) {
                    ri.N(this.a.a.getPageContext().getPageActivity(), this.a.v(R.string.obfuscated_res_0x7f0f0c41));
                    return;
                }
                if (this.a.f != null && !this.a.f.isCancelled()) {
                    this.a.f.cancel();
                }
                this.a.f = new ur8(currentImageQRInfo, new a(this, currentImageQRInfo));
                this.a.f.setPriority(3);
                this.a.f.execute(new String[0]);
                this.a.w();
                this.a.t(5);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class k extends BdAsyncTask<String, Integer, String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public byte[] b;
        public final /* synthetic */ fd7 c;

        public k(fd7 fd7Var, String str, byte[] bArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fd7Var, str, bArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = fd7Var;
            this.a = str;
            this.b = bArr;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.c.d = null;
                super.cancel(true);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            InterceptResult invokeL;
            byte[] bArr;
            String nameMd5FromUrl;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, strArr)) == null) {
                Map<String, ImageUrlData> H2 = this.c.a.H2();
                if (this.a != null && H2 != null) {
                    ImageUrlData imageUrlData = null;
                    Iterator<Map.Entry<String, ImageUrlData>> it = H2.entrySet().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        Map.Entry<String, ImageUrlData> next = it.next();
                        if (next != null && next.getKey() != null && next.getValue() != null && next.getKey().contains(this.a)) {
                            imageUrlData = next.getValue();
                            break;
                        }
                    }
                    if (imageUrlData != null) {
                        String str = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath() + StorageFile.getInstance().getDirectoryName(nameMd5FromUrl) + "/" + TbMd5.getNameMd5FromUrl(imageUrlData.originalUrl);
                        int[] imageFileWH = FileHelper.getImageFileWH(str);
                        if (imageFileWH != null && imageFileWH.length == 2 && imageFileWH[0] > 0 && FileHelper.copyImageFile(str, this.a, this.c.a.getPageContext().getPageActivity()) == 0) {
                            return this.c.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f108d);
                        }
                    }
                }
                String str2 = this.a;
                if (str2 != null && (bArr = this.b) != null) {
                    int saveImageFileByUser = FileHelper.saveImageFileByUser(str2, bArr, this.c.a.getPageContext().getPageActivity());
                    if (saveImageFileByUser == -2) {
                        return FileHelper.getSdErrorString();
                    }
                    if (saveImageFileByUser == 0) {
                        return this.c.v(R.string.obfuscated_res_0x7f0f108d);
                    }
                }
                return this.c.v(R.string.obfuscated_res_0x7f0f108c);
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                super.onPostExecute((k) str);
                if (!UbsABTestHelper.isImageViewerTestB() || this.c.v(R.string.obfuscated_res_0x7f0f108c).equals(str)) {
                    this.c.a.showToast(str);
                } else if (this.c.p != null) {
                    this.c.p.g(this.c.b, this.c.b.getBottomHeight(), this.c.z);
                }
                this.c.d = null;
            }
        }
    }

    public fd7(@Nullable ImageViewerActivity imageViewerActivity) {
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
        this.q = new HashMap<>();
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
        this.p = new dd7(imageViewerActivity);
        this.a.registerResponsedEventListener(CollectEmotionEvent.class, this.s);
    }

    public void A() {
        MultiImageView multiImageView;
        UrlDragImageView currentUrlDragImageView;
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (multiImageView = this.b) == null || (currentUrlDragImageView = multiImageView.getCurrentUrlDragImageView()) == null) {
            return;
        }
        ImageUrlData imageUrlData = currentUrlDragImageView.getmAssistUrlData();
        String str2 = "";
        if (imageUrlData != null) {
            str2 = imageUrlData.imageUrl;
            str = BigImageLoaderProc.getNameMd5FromUrl(str2);
        } else {
            str = "";
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = this.b.getCurrentImageUrl();
            str = TbMd5.getNameMd5FromUrl(str2);
        }
        ShareItem shareItem = new ShareItem();
        if (imageUrlData != null) {
            long j2 = imageUrlData.threadId;
            if (j2 > 0) {
                shareItem.w = "https://tieba.baidu.com/p/" + j2 + "?fr=share";
            }
        }
        boolean z = false;
        if (!qi.isEmpty(str2)) {
            shareItem.y = Uri.parse(str2);
            shareItem.g0 = 1;
            Bundle bundle = new Bundle();
            bundle.putString("path", "images");
            bundle.putString("name", str);
            bundle.putBoolean("formatData", true);
            bundle.putBoolean("isSubDir", true);
            bundle.putBoolean("isSdcard", false);
            bundle.putBoolean("isSavedCache", true);
            shareItem.D = bundle;
        }
        shareItem.j = true;
        shareItem.H = 23;
        ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.a, shareItem, false);
        if (UbsABTestHelper.isImageViewerTestA()) {
            shareDialogConfig.isImageViewerDialog = true;
            shareDialogConfig.originImgText = this.b.o(this.a.D2());
            ImageViewerActivity imageViewerActivity = this.a;
            shareDialogConfig.showAddEmotion = (imageViewerActivity == null || imageViewerActivity.Y2()) ? false : true;
            String currentImageQRInfo = this.b.getCurrentImageQRInfo();
            if (!TextUtils.isEmpty(currentImageQRInfo) && !currentImageQRInfo.equals("qr_none")) {
                z = true;
            }
            shareDialogConfig.showQRCode = z;
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

    public final void B(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(this.a.getPageContext().getPageActivity(), null, str, false)));
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
            ur8 ur8Var = this.f;
            if (ur8Var != null) {
                ur8Var.cancel();
                this.f = null;
            }
            dd7 dd7Var = this.p;
            if (dd7Var != null) {
                dd7Var.f();
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

    public final void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            try {
                k kVar = new k(this, this.b.getCurrentImageUrl(), this.b.getCurrentImageData());
                this.d = kVar;
                kVar.execute(new String[0]);
                if (ImageViewerConfig.FROM_DISCOVER_BEAUTY.equals(this.a.K2())) {
                    TiebaStatic.log("c12173");
                }
            } catch (Exception unused) {
            }
        }
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.i.clear();
            String o = this.b.o(this.a.D2());
            if (o != null) {
                cs4 cs4Var = new cs4(o, this.h);
                this.j = cs4Var;
                cs4Var.m(this.t);
                this.i.add(this.j);
            }
            cs4 cs4Var2 = new cs4(v(R.string.obfuscated_res_0x7f0f1092), this.h);
            this.l = cs4Var2;
            cs4Var2.m(this.w);
            this.i.add(this.l);
            ImageViewerActivity imageViewerActivity = this.a;
            if (imageViewerActivity != null && !imageViewerActivity.Y2()) {
                cs4 cs4Var3 = new cs4(v(R.string.obfuscated_res_0x7f0f1091), this.h);
                this.m = cs4Var3;
                cs4Var3.m(this.v);
                this.i.add(this.m);
            }
            cs4 cs4Var4 = new cs4(v(R.string.obfuscated_res_0x7f0f08b0), this.h);
            this.k = cs4Var4;
            cs4Var4.m(this.u);
            this.i.add(this.k);
            String currentImageQRInfo = this.b.getCurrentImageQRInfo();
            if (!TextUtils.isEmpty(currentImageQRInfo) && !currentImageQRInfo.equals("qr_none")) {
                cs4 cs4Var5 = new cs4(v(R.string.obfuscated_res_0x7f0f08d7), this.h);
                this.o = cs4Var5;
                cs4Var5.m(this.y);
                this.i.add(this.o);
            }
            cs4 cs4Var6 = new cs4(v(R.string.obfuscated_res_0x7f0f08da), this.h);
            this.n = cs4Var6;
            cs4Var6.m(this.x);
            this.i.add(this.n);
            this.h.m(new d(this));
            this.h.j(this.i);
        }
    }

    public void G() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || this.g == null || this.a.isFinishing()) {
            return;
        }
        this.g.k();
    }

    @Override // com.baidu.tbadk.coreExtra.view.ImageViewerBottomLayout.c
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            String currentOriginalUrl = this.b.getCurrentOriginalUrl();
            String currentImageUrl = this.b.getCurrentImageUrl();
            String currentPicId = this.b.getCurrentPicId();
            if (this.q.containsKey(currentPicId) && this.q.get(currentPicId).booleanValue()) {
                ri.M(TbadkCoreApplication.getInst(), R.string.obfuscated_res_0x7f0f1088);
                return;
            }
            if (TbadkCoreApplication.getInst().isMainProcess(true)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, currentOriginalUrl));
            } else if (FullBrowseHelper.checkAndShowFullBrowseModeDialog(this.a.getPageContext(), null)) {
                return;
            } else {
                Intent intent = new Intent(n55.a);
                intent.setPackage(TbadkCoreApplication.getInst().getPackageName());
                intent.putExtra(n55.b, currentOriginalUrl);
                intent.putExtra(n55.c, currentImageUrl);
                intent.putExtra(n55.d, currentPicId);
                TbadkCoreApplication.getInst().sendBroadcast(intent);
            }
            t(2);
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.ImageViewerBottomLayout.b
    public void m() {
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

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
        }
    }

    public final void t(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            TiebaStatic.log(new StatisticItem("c13270").param("uid", this.a.L2()).param("obj_type", i2));
            int i3 = i2 == 1 ? 22 : i2 == 2 ? 21 : i2 == 3 ? 20 : 0;
            if (i3 != 0) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("obj_type", i3));
            }
        }
    }

    public void u(String str) {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, str) == null) || this.g == null || this.a.isFinishing() || !this.g.isShowing() || TextUtils.isEmpty(str) || "qr_none".equals(str)) {
            return;
        }
        cs4 cs4Var = new cs4(v(R.string.obfuscated_res_0x7f0f08d7), this.h);
        this.o = cs4Var;
        cs4Var.m(this.y);
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

    public final String v(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i2)) == null) ? this.a.getString(i2) : (String) invokeI.objValue;
    }

    public void w() {
        es4 es4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && (es4Var = this.g) != null && es4Var.isShowing()) {
            this.g.dismiss();
        }
    }

    public void x(@Nullable MultiImageView multiImageView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, multiImageView) == null) {
            this.b = multiImageView;
            if (this.g == null) {
                this.h = new gs4(this.a);
            }
            if (this.i == null) {
                this.i = new ArrayList();
            }
            F();
            this.g = new es4(this.a.getPageContext(), this.h);
        }
    }

    public void y(View view2) {
        Bitmap imageBitmap;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048591, this, view2) == null) && view2 != null && (view2 instanceof DragImageView)) {
            DragImageView dragImageView = (DragImageView) view2;
            ImageUrlData imageUrlData = dragImageView.getImageUrlData();
            if ((imageUrlData != null && !TextUtils.isEmpty(imageUrlData.qrInfo)) || (imageBitmap = dragImageView.getImageBitmap()) == null || imageBitmap.isRecycled()) {
                return;
            }
            il8 il8Var = new il8();
            il8Var.a = 0;
            il8Var.c = imageBitmap;
            String currentImageUrl = this.b.getCurrentImageUrl();
            if (!TextUtils.isEmpty(currentImageUrl)) {
                il8Var.b = String.valueOf(System.currentTimeMillis()) + TbMd5.getNameMd5FromUrl(currentImageUrl);
            } else {
                il8Var.b = String.valueOf(BdUniqueId.gen().getId());
            }
            this.e = il8Var.b;
            this.a.sendMessage(new CustomMessage(2921403, il8Var));
        }
    }

    public void z() {
        gs4 gs4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || (gs4Var = this.h) == null) {
            return;
        }
        gs4Var.i();
    }
}
