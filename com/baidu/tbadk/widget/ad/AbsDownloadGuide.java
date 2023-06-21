package com.baidu.tbadk.widget.ad;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nps.utils.Constant;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ItemData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.view.itemcard.ItemCardHelper;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.widget.ad.AbsDownloadGuide;
import com.baidu.tbadk.widget.tiejia.TiePlusStat;
import com.baidu.tieba.R;
import com.baidu.tieba.co9;
import com.baidu.tieba.ew6;
import com.baidu.tieba.ma7;
import com.baidu.tieba.pa7;
import com.baidu.tieba.ug;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import tbclient.ApkDetail;
import tbclient.PbContent;
import tbclient.TiebaPlusInfo;
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0015\b&\u0018\u0000 U2\u00020\u0001:\u0001UB%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u00102\u001a\u000203H\u0002J\u000e\u00104\u001a\u0002032\u0006\u00105\u001a\u00020\fJ\u0010\u00106\u001a\u0002032\u0006\u00107\u001a\u000208H\u0002J\u0006\u00109\u001a\u00020\fJ\n\u0010:\u001a\u0004\u0018\u00010\u0012H\u0002J\b\u0010;\u001a\u00020\fH\u0002J\u0006\u0010<\u001a\u00020\u0007J\b\u0010=\u001a\u0004\u0018\u000100J\u0006\u0010>\u001a\u000203J\u001c\u0010?\u001a\u0002032\n\u0010@\u001a\u0006\u0012\u0002\b\u00030A2\u0006\u0010B\u001a\u00020\u0007H\u0002J\u0010\u0010C\u001a\u0002032\u0006\u0010B\u001a\u00020\u0007H&J\u0006\u0010D\u001a\u00020\u0017J\u0006\u0010E\u001a\u00020\u0017J\u0006\u0010F\u001a\u00020\u0017J\u0006\u0010G\u001a\u00020\u0017J\b\u0010H\u001a\u000203H\u0002J\b\u0010I\u001a\u000203H\u0014J\b\u0010J\u001a\u000203H\u0014J\u0006\u0010K\u001a\u000203J\u0006\u0010L\u001a\u000203J\b\u0010M\u001a\u000203H&J\b\u0010N\u001a\u000203H\u0002J\b\u0010O\u001a\u000203H\u0002J\u0010\u0010P\u001a\u0002032\u0006\u0010Q\u001a\u00020*H\u0016J\u0010\u0010R\u001a\u0002032\u0006\u0010S\u001a\u00020\u0012H&J\b\u0010T\u001a\u000203H&R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001b\u0010\u001c\u001a\u00020\u001d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\u001e\u0010\u001fR\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010$\u001a\u00020%8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b(\u0010!\u001a\u0004\b&\u0010'R\u001c\u0010)\u001a\u0004\u0018\u00010*X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u0010\u0010/\u001a\u0004\u0018\u000100X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00101\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006V"}, d2 = {"Lcom/baidu/tbadk/widget/ad/AbsDownloadGuide;", "Landroid/widget/RelativeLayout;", "mContext", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "getMContext", "()Landroid/content/Context;", "mConvertBtnType", "", "getMConvertBtnType", "()Ljava/lang/String;", "setMConvertBtnType", "(Ljava/lang/String;)V", "mDownloadData", "Lcom/baidu/tbadk/download/DownloadData;", "mDownloadUrl", "mInstallListener", "Lcom/baidu/adp/framework/listener/CustomMessageListener;", "mIsShowed", "", "getMIsShowed", "()Z", "setMIsShowed", "(Z)V", "mPermissionJudgePolicy", "Lcom/baidu/tbadk/core/util/permission/PermissionJudgePolicy;", "getMPermissionJudgePolicy", "()Lcom/baidu/tbadk/core/util/permission/PermissionJudgePolicy;", "mPermissionJudgePolicy$delegate", "Lkotlin/Lazy;", "mStatusCallback", "Lcom/baidu/tieba/filedownloader/interfaces/IStatusCallback;", "mTbDownloadManager", "Lcom/baidu/tieba/filedownloader/TbDownloadManager;", "getMTbDownloadManager", "()Lcom/baidu/tieba/filedownloader/TbDownloadManager;", "mTbDownloadManager$delegate", "mThreadData", "Lcom/baidu/tbadk/core/data/ThreadData;", "getMThreadData", "()Lcom/baidu/tbadk/core/data/ThreadData;", "setMThreadData", "(Lcom/baidu/tbadk/core/data/ThreadData;)V", "mTiebaPlusInfo", "Ltbclient/TiebaPlusInfo;", "mUnInstallListener", "download", "", "downloadStatistic", "key", "exposureAndClickStatistic", "stateType", "Lcom/baidu/tbadk/widget/tiejia/TiePlusStat$StatType;", "getDescInfo", "getDownloadData", "getDownloadDataId", "getProgress", "getTiebaPlusInfo", "install", "installOrUnResult", "responsedMessage", "Lcom/baidu/adp/framework/message/CustomResponsedMessage;", "installOrUnType", "installOrUnUpdateInfo", "isDownloadComplete", "isDownloadStatus", "isDownloading", "isInstalled", "launchApk", "onAttachedToWindow", "onDetachedFromWindow", "onDownloadClick", "onJudgeClick", "onSkinChanged", "operationDownloadFlow", "saveDb", "setData", "data", "updateInfo", "downloadData", "updateJustStart", "Companion", "tbadkcore_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public abstract class AbsDownloadGuide extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context a;
    public ThreadData b;
    public TiebaPlusInfo c;
    public pa7 d;
    public DownloadData e;
    public CustomMessageListener f;
    public CustomMessageListener g;
    public String h;
    public boolean i;
    public final Lazy j;
    public final Lazy k;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(617947637, "Lcom/baidu/tbadk/widget/ad/AbsDownloadGuide;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(617947637, "Lcom/baidu/tbadk/widget/ad/AbsDownloadGuide;");
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AbsDownloadGuide(Context mContext) {
        this(mContext, null, 0, 6, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mContext};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue(), (DefaultConstructorMarker) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(mContext, "mContext");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AbsDownloadGuide(Context mContext, AttributeSet attributeSet) {
        this(mContext, attributeSet, 0, 4, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mContext, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue(), (DefaultConstructorMarker) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(mContext, "mContext");
    }

    public abstract void i(int i);

    public abstract void q();

    public abstract void t(DownloadData downloadData);

    public abstract void u();

    /* loaded from: classes4.dex */
    public static final class a implements pa7 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsDownloadGuide a;

        @Override // com.baidu.tieba.pa7
        public void b(DownloadData data) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, data) == null) {
                Intrinsics.checkNotNullParameter(data, "data");
            }
        }

        public a(AbsDownloadGuide absDownloadGuide) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absDownloadGuide};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absDownloadGuide;
        }

        @Override // com.baidu.tieba.pa7
        public void a(DownloadData data) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, data) == null) {
                Intrinsics.checkNotNullParameter(data, "data");
                this.a.u();
            }
        }

        @Override // com.baidu.tieba.pa7
        public void c(DownloadData data) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, data) == null) {
                Intrinsics.checkNotNullParameter(data, "data");
                this.a.t(data);
                this.a.d(CommonStatisticKey.KEY_TIE_PLUS_DOWNLOAD_FINISHED);
            }
        }

        @Override // com.baidu.tieba.pa7
        public void d(DownloadData data) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, data) == null) {
                Intrinsics.checkNotNullParameter(data, "data");
                this.a.t(data);
            }
        }

        @Override // com.baidu.tieba.pa7
        public void e(DownloadData data) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, data) == null) {
                Intrinsics.checkNotNullParameter(data, "data");
                this.a.t(data);
            }
        }

        @Override // com.baidu.tieba.pa7
        public void f(DownloadData data) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, data) == null) {
                Intrinsics.checkNotNullParameter(data, "data");
                this.a.t(data);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsDownloadGuide a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(AbsDownloadGuide absDownloadGuide) {
            super(2002501);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absDownloadGuide};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absDownloadGuide;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                Intrinsics.checkNotNullParameter(responsedMessage, "responsedMessage");
                this.a.h(responsedMessage, 1);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsDownloadGuide a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(AbsDownloadGuide absDownloadGuide) {
            super(2002502);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absDownloadGuide};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absDownloadGuide;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                Intrinsics.checkNotNullParameter(responsedMessage, "responsedMessage");
                this.a.h(responsedMessage, 2);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AbsDownloadGuide(Context mContext, AttributeSet attributeSet, int i) {
        super(mContext, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mContext, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        this.a = mContext;
        this.h = "a";
        this.j = LazyKt__LazyJVMKt.lazy(AbsDownloadGuide$mTbDownloadManager$2.INSTANCE);
        this.k = LazyKt__LazyJVMKt.lazy(AbsDownloadGuide$mPermissionJudgePolicy$2.INSTANCE);
        this.d = new a(this);
        this.f = new b(this);
        this.g = new c(this);
    }

    public /* synthetic */ AbsDownloadGuide(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public static final void c(AbsDownloadGuide this$0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            DownloadData downloadData = this$0.getDownloadData();
            if (downloadData != null && this$0.getMTbDownloadManager().h(downloadData)) {
                this$0.u();
                this$0.d(CommonStatisticKey.KEY_DXX_GUIDE_START_DOWNLOAD);
                this$0.s();
            }
        }
    }

    public static final void g(AbsDownloadGuide this$0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (!StringsKt__StringsJVMKt.isBlank(this$0.getDownloadDataId())) {
                Application app = TbadkCoreApplication.getInst().getApp();
                UtilHelper.install_apk(app, StringsKt__StringsJVMKt.replace$default(this$0.getDownloadDataId(), ".", "_", false, 4, (Object) null) + Constant.FILE.SUFFIX.BUNDLE_SUFFIX);
            }
        }
    }

    private final DownloadData getDownloadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) {
            DownloadData downloadData = this.e;
            if (downloadData != null) {
                return downloadData;
            }
            TiebaPlusInfo tiebaPlusInfo = getTiebaPlusInfo();
            if (tiebaPlusInfo == null) {
                return null;
            }
            String downloadDataId = getDownloadDataId();
            if (!(!StringsKt__StringsJVMKt.isBlank(getDownloadDataId()))) {
                return null;
            }
            DownloadData downloadData2 = new DownloadData(downloadDataId);
            this.e = downloadData2;
            if (downloadData2 != null) {
                downloadData2.setName(tiebaPlusInfo.title);
            }
            DownloadData downloadData3 = this.e;
            if (downloadData3 != null) {
                downloadData3.setUrl(tiebaPlusInfo.download_url);
            }
            DownloadData downloadData4 = this.e;
            if (downloadData4 != null) {
                downloadData4.setSource(2);
            }
            DownloadData downloadData5 = this.e;
            if (downloadData5 != null) {
                downloadData5.setType(12);
            }
            return this.e;
        }
        return (DownloadData) invokeV.objValue;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            getMPermissionJudgePolicy().setOnPermissionsGrantedListener(new PermissionJudgePolicy.OnPermissionsGrantedListener() { // from class: com.baidu.tieba.bz5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tbadk.core.util.permission.PermissionJudgePolicy.OnPermissionsGrantedListener
                public final void onPermissionsGranted() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        AbsDownloadGuide.c(AbsDownloadGuide.this);
                    }
                }
            });
            if (getContext() instanceof Activity) {
                getMPermissionJudgePolicy().clearRequestPermissionList();
                PermissionJudgePolicy mPermissionJudgePolicy = getMPermissionJudgePolicy();
                Context context = getContext();
                if (context != null) {
                    mPermissionJudgePolicy.appendRequestPermission((Activity) context, "android.permission.WRITE_EXTERNAL_STORAGE");
                    PermissionJudgePolicy mPermissionJudgePolicy2 = getMPermissionJudgePolicy();
                    Context context2 = getContext();
                    if (context2 != null) {
                        mPermissionJudgePolicy2.startRequestPermission((Activity) context2);
                        return;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
                }
                throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
            }
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            getMPermissionJudgePolicy().setOnPermissionsGrantedListener(new PermissionJudgePolicy.OnPermissionsGrantedListener() { // from class: com.baidu.tieba.yy5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tbadk.core.util.permission.PermissionJudgePolicy.OnPermissionsGrantedListener
                public final void onPermissionsGranted() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        AbsDownloadGuide.g(AbsDownloadGuide.this);
                    }
                }
            });
            if (getContext() instanceof Activity) {
                getMPermissionJudgePolicy().clearRequestPermissionList();
                PermissionJudgePolicy mPermissionJudgePolicy = getMPermissionJudgePolicy();
                Context context = getContext();
                if (context != null) {
                    mPermissionJudgePolicy.appendRequestPermission((Activity) context, "android.permission.WRITE_EXTERNAL_STORAGE");
                    PermissionJudgePolicy mPermissionJudgePolicy2 = getMPermissionJudgePolicy();
                    Context context2 = getContext();
                    if (context2 != null) {
                        mPermissionJudgePolicy2.startRequestPermission((Activity) context2);
                        return;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
                }
                throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
            }
        }
    }

    public final TiebaPlusInfo getTiebaPlusInfo() {
        InterceptResult invokeV;
        List<PbContent> richAbstractList;
        TiebaPlusInfo tiebaPlusInfo;
        Integer num;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            TiebaPlusInfo tiebaPlusInfo2 = this.c;
            if (tiebaPlusInfo2 != null) {
                return tiebaPlusInfo2;
            }
            ThreadData threadData = this.b;
            if (threadData != null && threadData != null && (richAbstractList = threadData.getRichAbstractList()) != null) {
                for (PbContent pbContent : richAbstractList) {
                    boolean z = false;
                    if (pbContent != null && (num = pbContent.type) != null && num.intValue() == 35) {
                        z = true;
                    }
                    if (z) {
                        if (pbContent != null) {
                            tiebaPlusInfo = pbContent.tiebaplus_info;
                        } else {
                            tiebaPlusInfo = null;
                        }
                        if (tiebaPlusInfo != null) {
                            TiebaPlusInfo tiebaPlusInfo3 = pbContent.tiebaplus_info;
                            this.c = tiebaPlusInfo3;
                            if (tiebaPlusInfo3 != null) {
                                String str = tiebaPlusInfo3.download_url;
                            }
                            return this.c;
                        }
                    }
                }
            }
            return null;
        }
        return (TiebaPlusInfo) invokeV.objValue;
    }

    public final boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            DownloadData downloadData = getDownloadData();
            if (downloadData == null) {
                return false;
            }
            if (getMTbDownloadManager().e(downloadData) != 1 && getMTbDownloadManager().e(downloadData) != 5 && getMTbDownloadManager().e(downloadData) != 3 && getMTbDownloadManager().e(downloadData) != 0 && getMTbDownloadManager().e(downloadData) != 7) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void p() {
        TiebaPlusInfo tiebaPlusInfo;
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048597, this) != null) || (tiebaPlusInfo = getTiebaPlusInfo()) == null) {
            return;
        }
        String str = tiebaPlusInfo.jump_url;
        if (str != null && !StringsKt__StringsJVMKt.isBlank(str)) {
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            TbPageContext<?> currentPageContext = TbadkCoreApplication.getInst().getCurrentPageContext(this.a);
            if (currentPageContext != null) {
                UrlManager.getInstance().dealOneLink(currentPageContext, new String[]{tiebaPlusInfo.jump_url});
            }
        } else {
            r();
        }
        e(TiePlusStat.StatType.CLICK);
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            TiebaPlusInfo tiebaPlusInfo = getTiebaPlusInfo();
            if (tiebaPlusInfo != null && co9.i(tiebaPlusInfo.app_package)) {
                n();
                return;
            }
            DownloadData downloadData = getDownloadData();
            if (downloadData != null) {
                int e = getMTbDownloadManager().e(downloadData);
                if (e != 0) {
                    if (e != 1) {
                        if (e != 3) {
                            if (e != 5) {
                                if (e != 6 && e != 7) {
                                    if (e == 8) {
                                        n();
                                        return;
                                    }
                                    return;
                                }
                                b();
                                return;
                            }
                        }
                    }
                    getMTbDownloadManager().f(downloadData);
                    return;
                }
                f();
            }
        }
    }

    private final String getDownloadDataId() {
        InterceptResult invokeV;
        TiebaPlusInfo tiebaPlusInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) {
            if (getTiebaPlusInfo() == null) {
                return "";
            }
            String str = tiebaPlusInfo.app_package + ".v" + tiebaPlusInfo.app_version;
            Intrinsics.checkNotNullExpressionValue(str, "sb.toString()");
            return str;
        }
        return (String) invokeV.objValue;
    }

    private final PermissionJudgePolicy getMPermissionJudgePolicy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) {
            return (PermissionJudgePolicy) this.k.getValue();
        }
        return (PermissionJudgePolicy) invokeV.objValue;
    }

    private final ma7 getMTbDownloadManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, this)) == null) {
            return (ma7) this.j.getValue();
        }
        return (ma7) invokeV.objValue;
    }

    public final Context getMContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.a;
        }
        return (Context) invokeV.objValue;
    }

    public final String getMConvertBtnType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.h;
        }
        return (String) invokeV.objValue;
    }

    public final boolean getMIsShowed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.i;
        }
        return invokeV.booleanValue;
    }

    public final ThreadData getMThreadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.b;
        }
        return (ThreadData) invokeV.objValue;
    }

    public final int getProgress() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            DownloadData downloadData = getDownloadData();
            if (downloadData != null) {
                return getMTbDownloadManager().d(downloadData);
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public final boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            DownloadData downloadData = getDownloadData();
            if (downloadData == null) {
                return false;
            }
            if (getMTbDownloadManager().e(downloadData) != 3 && getMTbDownloadManager().e(downloadData) != 0) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            DownloadData downloadData = getDownloadData();
            if (downloadData == null || getMTbDownloadManager().e(downloadData) != 1) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            TiebaPlusInfo tiebaPlusInfo = getTiebaPlusInfo();
            if (tiebaPlusInfo != null && co9.i(tiebaPlusInfo.app_package)) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void n() {
        TiebaPlusInfo tiebaPlusInfo;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048593, this) != null) || (tiebaPlusInfo = getTiebaPlusInfo()) == null) {
            return;
        }
        UtilHelper.startAppByPkgName(tiebaPlusInfo.app_package);
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            r();
            e(TiePlusStat.StatType.CLICK);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            super.onAttachedToWindow();
            pa7 pa7Var = this.d;
            if (pa7Var != null) {
                getMTbDownloadManager().a(pa7Var);
            }
            MessageManager.getInstance().registerListener(this.f);
            MessageManager.getInstance().registerListener(this.g);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            super.onDetachedFromWindow();
            MessageManager.getInstance().unRegisterListener(this.f);
            MessageManager.getInstance().unRegisterListener(this.g);
        }
    }

    public final void d(String key) {
        String str;
        String str2;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, key) == null) {
            Intrinsics.checkNotNullParameter(key, "key");
            ThreadData threadData = this.b;
            boolean z = false;
            int i = 1;
            if (threadData != null && threadData.isTiebaPlusAdThread) {
                z = true;
            }
            String str4 = null;
            if (z) {
                ThreadData threadData2 = this.b;
                if (threadData2 != null) {
                    str3 = threadData2.tiebaPlusOrderId;
                } else {
                    str3 = null;
                }
                str = String.valueOf(str3);
            } else {
                str = "";
            }
            if (!Intrinsics.areEqual(key, CommonStatisticKey.KEY_TIE_PLUS_DOWNLOAD_FINISHED)) {
                if (Intrinsics.areEqual(this.h, "a")) {
                    i = 5;
                } else {
                    i = 6;
                }
            }
            StatisticItem statisticItem = new StatisticItem(key);
            ThreadData threadData3 = this.b;
            if (threadData3 != null) {
                str2 = threadData3.getTid();
            } else {
                str2 = null;
            }
            StatisticItem addParam = statisticItem.addParam("tid", String.valueOf(str2)).addParam("order_id", str).addParam(TiePlusStat.RichTextType.STAT_KEY, i);
            TiebaPlusInfo tiebaPlusInfo = getTiebaPlusInfo();
            if (tiebaPlusInfo != null) {
                str4 = tiebaPlusInfo.app_package;
            }
            TiebaStatic.log(addParam.addParam("packageName", str4));
        }
    }

    public final void e(TiePlusStat.StatType statType) {
        String str;
        TiePlusStat.RichTextType richTextType;
        String str2;
        Long l;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, statType) == null) {
            ThreadData threadData = this.b;
            boolean z = true;
            z = (threadData == null || !threadData.isTiebaPlusAdThread) ? false : false;
            Long l2 = null;
            if (z) {
                ThreadData threadData2 = this.b;
                if (threadData2 != null) {
                    str3 = threadData2.tiebaPlusOrderId;
                } else {
                    str3 = null;
                }
                str = String.valueOf(str3);
            } else {
                str = "";
            }
            String str4 = str;
            TiebaPlusInfo tiebaPlusInfo = getTiebaPlusInfo();
            if (tiebaPlusInfo != null) {
                String str5 = this.h;
                if (Intrinsics.areEqual(str5, "a")) {
                    richTextType = TiePlusStat.RichTextType.CONVERSION_BAR_PART;
                } else if (Intrinsics.areEqual(str5, "b")) {
                    richTextType = TiePlusStat.RichTextType.CONVERSION_BAR_FULL;
                } else {
                    richTextType = TiePlusStat.RichTextType.CONVERSION_BAR_FULL;
                }
                TiePlusStat.RichTextType richTextType2 = richTextType;
                int a2 = TiePlusStat.a(tiebaPlusInfo, this);
                TiePlusStat.Locate locate = TiePlusStat.Locate.HOME;
                TiePlusStat.ThreadType threadType = TiePlusStat.ThreadType.VIDEO_NORMAL;
                Integer num = tiebaPlusInfo.target_type;
                Intrinsics.checkNotNullExpressionValue(num, "it.target_type");
                int intValue = num.intValue();
                TiePlusStat.LandingType landingType = TiePlusStat.LandingType.DIALOG_DOWNLOAD;
                ThreadData threadData3 = this.b;
                if (threadData3 != null) {
                    str2 = threadData3.getTid();
                } else {
                    str2 = null;
                }
                String valueOf = String.valueOf(str2);
                ThreadData threadData4 = this.b;
                if (threadData4 != null) {
                    l = Long.valueOf(threadData4.getFid());
                } else {
                    l = null;
                }
                String valueOf2 = String.valueOf(l);
                ThreadData threadData5 = this.b;
                if (threadData5 != null) {
                    l2 = Long.valueOf(threadData5.getDispatchedForumId());
                }
                TiePlusStat.b(a2, statType, locate, threadType, richTextType2, intValue, landingType, valueOf, valueOf2, String.valueOf(l2), str4, TiePlusStat.CardBtnType.DOWNLOAD);
            }
        }
    }

    public final String getDescInfo() {
        InterceptResult invokeV;
        String string;
        String string2;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (m()) {
                String string3 = TbadkCoreApplication.getInst().getApp().getString(R.string.item_download_open);
                Intrinsics.checkNotNullExpressionValue(string3, "getInst().app.getString(…tring.item_download_open)");
                return string3;
            } else if (getDownloadData() == null) {
                return "";
            } else {
                ma7 mTbDownloadManager = getMTbDownloadManager();
                DownloadData downloadData = getDownloadData();
                Intrinsics.checkNotNull(downloadData);
                int e = mTbDownloadManager.e(downloadData);
                if (e != 0) {
                    if (e != 7) {
                        if (e != 3) {
                            if (e != 4) {
                                TiebaPlusInfo tiebaPlusInfo = getTiebaPlusInfo();
                                if (tiebaPlusInfo != null) {
                                    str = tiebaPlusInfo.desc;
                                } else {
                                    str = null;
                                }
                                if (str == null) {
                                    return "";
                                }
                                Intrinsics.checkNotNullExpressionValue(str, "getTiebaPlusInfo()?.desc ?: \"\"");
                                return str;
                            }
                        }
                    }
                    if (Intrinsics.areEqual(this.h, "a")) {
                        string2 = TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f08e5);
                    } else {
                        string2 = TbadkCoreApplication.getInst().getApp().getString(R.string.go_on_download);
                    }
                    String str2 = string2;
                    Intrinsics.checkNotNullExpressionValue(str2, "{\n                    if…      }\n                }");
                    return str2;
                }
                if (Intrinsics.areEqual(this.h, "a")) {
                    string = TbadkCoreApplication.getInst().getApp().getString(R.string.item_download_install);
                } else {
                    string = TbadkCoreApplication.getInst().getApp().getString(R.string.install_remind);
                }
                String str3 = string;
                Intrinsics.checkNotNullExpressionValue(str3, "{\n                    if…      }\n                }");
                return str3;
            }
        }
        return (String) invokeV.objValue;
    }

    public final void h(CustomResponsedMessage<?> customResponsedMessage, int i) {
        Uri data;
        String str;
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048587, this, customResponsedMessage, i) == null) && customResponsedMessage != null && customResponsedMessage.getData() != null) {
            Object data2 = customResponsedMessage.getData();
            if ((data2 instanceof Intent) && (data = ((Intent) data2).getData()) != null) {
                TiebaPlusInfo tiebaPlusInfo = getTiebaPlusInfo();
                String str2 = null;
                if (tiebaPlusInfo != null) {
                    str = tiebaPlusInfo.app_package;
                } else {
                    str = null;
                }
                if (str != null && !StringsKt__StringsJVMKt.isBlank(str)) {
                    z = false;
                } else {
                    z = true;
                }
                if (!z) {
                    TiebaPlusInfo tiebaPlusInfo2 = getTiebaPlusInfo();
                    if (tiebaPlusInfo2 != null) {
                        str2 = tiebaPlusInfo2.app_package;
                    }
                    if (Intrinsics.areEqual(str2, data.getSchemeSpecificPart())) {
                        i(i);
                    }
                }
            }
        }
    }

    public final void s() {
        TiebaPlusInfo tiebaPlusInfo;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048600, this) == null) && (tiebaPlusInfo = getTiebaPlusInfo()) != null) {
            ew6 ew6Var = new ew6();
            ItemData itemData = new ItemData();
            itemData.buttonLink = tiebaPlusInfo.download_url;
            itemData.buttonName = ItemCardHelper.b;
            itemData.mTitle = tiebaPlusInfo.title;
            itemData.pkgName = tiebaPlusInfo.app_package;
            itemData.mIconUrl = tiebaPlusInfo.app_icon;
            itemData.mIconSize = 1.0d;
            itemData.buttonLinkType = 1;
            itemData.forumName = tiebaPlusInfo.forum_name;
            ApkDetail.Builder builder = new ApkDetail.Builder();
            builder.authority_url = tiebaPlusInfo.app_power;
            builder.developer = tiebaPlusInfo.app_company;
            builder.privacy_url = tiebaPlusInfo.app_privacy;
            builder.version = tiebaPlusInfo.app_version;
            builder.version_code = 1;
            builder.pkg_source = 2;
            itemData.itemId = ug.g(tiebaPlusInfo.app_id, 0L);
            itemData.apkDetail = builder.build(true);
            ew6Var.a = itemData;
            ew6Var.b = 1;
            MessageManager.getInstance().sendMessage(new CustomMessage(2921627, ew6Var));
        }
    }

    public void setData(ThreadData data) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, data) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            this.b = data;
            if (!this.i) {
                e(TiePlusStat.StatType.EXPOSE);
                this.i = true;
            }
        }
    }

    public final void setMConvertBtnType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, str) == null) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.h = str;
        }
    }

    public final void setMIsShowed(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048603, this, z) == null) {
            this.i = z;
        }
    }

    public final void setMThreadData(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, threadData) == null) {
            this.b = threadData;
        }
    }
}
