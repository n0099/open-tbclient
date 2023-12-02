package com.baidu.tbadk.widget.ad;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.BusinessMixHelper;
import com.baidu.tbadk.core.data.ItemData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.itemcard.ItemCardHelper;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.widget.tiejia.TiePlusEventController;
import com.baidu.tbadk.widget.tiejia.TiePlusStat;
import com.baidu.tieba.R;
import com.baidu.tieba.bz5;
import com.baidu.tieba.filedownloader.TbDownloadManager;
import com.baidu.tieba.filedownloader.utils.PermissionUtil;
import com.baidu.tieba.oe7;
import com.baidu.tieba.util.AdApkInstallHelper;
import com.baidu.tieba.wha;
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
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.json.JSONObject;
import tbclient.ApkDetail;
import tbclient.PbContent;
import tbclient.TiebaPlusInfo;
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0011\b&\u0018\u0000 N2\u00020\u0001:\u0001NB%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010)\u001a\u00020*H\u0002J\b\u0010+\u001a\u00020*H\u0002J\u0010\u0010,\u001a\u00020*2\u0006\u0010-\u001a\u00020\fH\u0002J\u0010\u0010.\u001a\u00020*2\u0006\u0010/\u001a\u000200H\u0002J\u0006\u00101\u001a\u00020\fJ\b\u00102\u001a\u0004\u0018\u00010\u0012J\b\u00103\u001a\u00020\fH\u0002J\b\u00104\u001a\u00020\fH\u0002J\u0006\u00105\u001a\u00020\u0007J\b\u00106\u001a\u0004\u0018\u00010&J\u0006\u00107\u001a\u00020*J\u001c\u00108\u001a\u00020*2\n\u00109\u001a\u0006\u0012\u0002\b\u00030:2\u0006\u0010;\u001a\u00020\u0007H\u0002J\u0010\u0010<\u001a\u00020*2\u0006\u0010;\u001a\u00020\u0007H&J\u0006\u0010=\u001a\u00020>J\u0006\u0010?\u001a\u00020>J\u0006\u0010@\u001a\u00020>J\u0006\u0010A\u001a\u00020>J\b\u0010B\u001a\u00020*H\u0002J\b\u0010C\u001a\u00020*H\u0014J\b\u0010D\u001a\u00020*H\u0014J\u0006\u0010E\u001a\u00020*J\u0006\u0010F\u001a\u00020*J\b\u0010G\u001a\u00020*H&J\b\u0010H\u001a\u00020*H\u0002J\u0010\u0010I\u001a\u00020*2\u0006\u0010J\u001a\u00020 H\u0016J\u0010\u0010K\u001a\u00020*2\u0006\u0010L\u001a\u00020\u0012H&J\b\u0010M\u001a\u00020*H&R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0019\u001a\u00020\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001f\u001a\u0004\u0018\u00010 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006O"}, d2 = {"Lcom/baidu/tbadk/widget/ad/AbsDownloadGuide;", "Landroid/widget/RelativeLayout;", "mContext", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "getMContext", "()Landroid/content/Context;", "mConvertBtnType", "", "getMConvertBtnType", "()Ljava/lang/String;", "setMConvertBtnType", "(Ljava/lang/String;)V", "mDownloadData", "Lcom/baidu/tbadk/download/DownloadData;", "mDownloadUrl", "mInstallListener", "Lcom/baidu/adp/framework/listener/CustomMessageListener;", "mJumpType", "mStatusCallback", "Lcom/baidu/tieba/filedownloader/interfaces/IStatusCallback;", "mTbDownloadManager", "Lcom/baidu/tieba/filedownloader/TbDownloadManager;", "getMTbDownloadManager", "()Lcom/baidu/tieba/filedownloader/TbDownloadManager;", "mTbDownloadManager$delegate", "Lkotlin/Lazy;", "mThreadData", "Lcom/baidu/tbadk/core/data/ThreadData;", "getMThreadData", "()Lcom/baidu/tbadk/core/data/ThreadData;", "setMThreadData", "(Lcom/baidu/tbadk/core/data/ThreadData;)V", "mTiebaPlusInfo", "Ltbclient/TiebaPlusInfo;", "mType", "mUnInstallListener", "clearInfo", "", "download", "downloadStatistic", "key", "exposureAndClickStatistic", "stateType", "Lcom/baidu/tbadk/widget/tiejia/TiePlusStat$StatType;", "getDescInfo", "getDownloadData", "getDownloadDataId", "getExtraDataForDb", "getProgress", "getTiebaPlusInfo", "install", "installOrUnResult", "responsedMessage", "Lcom/baidu/adp/framework/message/CustomResponsedMessage;", "installOrUnType", "installOrUnUpdateInfo", "isDownloadComplete", "", "isDownloadStatus", "isDownloading", "isInstalled", "launchApk", "onAttachedToWindow", "onDetachedFromWindow", "onDownloadClick", "onJudgeClick", "onSkinChanged", "operationFlow", "setData", "data", "updateInfo", "downloadData", "updateJustStart", "Companion", "tbadkcore_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class AbsDownloadGuide extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context a;
    public ThreadData b;
    public TiebaPlusInfo c;
    public oe7 d;
    public DownloadData e;
    public CustomMessageListener f;
    public CustomMessageListener g;
    public int h;
    public int i;
    public String j;
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

    public abstract void j(int i);

    public abstract void r();

    public abstract void t(DownloadData downloadData);

    public abstract void u();

    /* loaded from: classes5.dex */
    public static final class a implements oe7 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsDownloadGuide a;

        @Override // com.baidu.tieba.oe7
        public void a(DownloadData data) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, data) == null) {
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

        @Override // com.baidu.tieba.oe7
        public void b(DownloadData data) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, data) == null) {
                Intrinsics.checkNotNullParameter(data, "data");
                this.a.t(data);
            }
        }

        @Override // com.baidu.tieba.oe7
        public void c(DownloadData data) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, data) == null) {
                Intrinsics.checkNotNullParameter(data, "data");
                this.a.t(data);
            }
        }

        @Override // com.baidu.tieba.oe7
        public void d(DownloadData data) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, data) == null) {
                Intrinsics.checkNotNullParameter(data, "data");
                this.a.t(data);
            }
        }

        @Override // com.baidu.tieba.oe7
        public void e(DownloadData data) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, data) == null) {
                Intrinsics.checkNotNullParameter(data, "data");
                this.a.t(data);
            }
        }

        @Override // com.baidu.tieba.oe7
        public void f(DownloadData data, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048581, this, data, i) == null) {
                Intrinsics.checkNotNullParameter(data, "data");
                this.a.u();
            }
        }
    }

    /* loaded from: classes5.dex */
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
                this.a.i(responsedMessage, 1);
            }
        }
    }

    /* loaded from: classes5.dex */
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
                this.a.i(responsedMessage, 2);
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
        this.j = "a";
        this.k = LazyKt__LazyJVMKt.lazy(AbsDownloadGuide$mTbDownloadManager$2.INSTANCE);
        this.d = new a(this);
        this.f = new b(this);
        this.g = new c(this);
    }

    public /* synthetic */ AbsDownloadGuide(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public void setData(ThreadData data) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, data) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            this.b = data;
            d();
            g(TiePlusStat.StatType.EXPOSE);
        }
    }

    public final void setMConvertBtnType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, str) == null) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.j = str;
        }
    }

    public final void setMThreadData(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, threadData) == null) {
            this.b = threadData;
        }
    }

    private final String getDownloadDataId() {
        InterceptResult invokeV;
        TiebaPlusInfo tiebaPlusInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) {
            if (getTiebaPlusInfo() == null) {
                return "";
            }
            String str = tiebaPlusInfo.app_package + ".v" + tiebaPlusInfo.app_version;
            Intrinsics.checkNotNullExpressionValue(str, "sb.toString()");
            return str;
        }
        return (String) invokeV.objValue;
    }

    private final String getExtraDataForDb() {
        InterceptResult invokeV;
        String str;
        int i;
        String str2;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) {
            ThreadData threadData = this.b;
            boolean z = true;
            z = (threadData == null || !threadData.isTiebaPlusAdThread) ? false : false;
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
            if (Intrinsics.areEqual(this.j, "a")) {
                i = 5;
            } else {
                i = 6;
            }
            JSONObject jSONObject = new JSONObject();
            ThreadData threadData3 = this.b;
            if (threadData3 != null) {
                str2 = threadData3.getTid();
            } else {
                str2 = null;
            }
            jSONObject.putOpt("tid", String.valueOf(str2));
            jSONObject.putOpt("order_id", str);
            jSONObject.putOpt(TiePlusStat.RichTextType.STAT_KEY, Integer.valueOf(i));
            String str5 = "1";
            jSONObject.putOpt("obj_locate", "1");
            TiebaPlusInfo tiebaPlusInfo = getTiebaPlusInfo();
            if (tiebaPlusInfo != null) {
                str4 = tiebaPlusInfo.app_package;
            }
            jSONObject.putOpt("obj_name", str4);
            if (!ThreadCardUtils.isBusinessMixCard(this.b)) {
                str5 = "0";
            }
            jSONObject.putOpt("obj_type", str5);
            String jSONObject2 = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject2, "dbExtraJsonObj.toString()");
            return jSONObject2;
        }
        return (String) invokeV.objValue;
    }

    public final TiebaPlusInfo getTiebaPlusInfo() {
        InterceptResult invokeV;
        List<PbContent> richAbstractList;
        boolean z;
        TiebaPlusInfo tiebaPlusInfo;
        Integer num;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            TiebaPlusInfo tiebaPlusInfo2 = this.c;
            if (tiebaPlusInfo2 != null) {
                return tiebaPlusInfo2;
            }
            ThreadData threadData = this.b;
            Integer num2 = null;
            if (threadData != null && threadData != null && (richAbstractList = threadData.getRichAbstractList()) != null) {
                for (PbContent pbContent : richAbstractList) {
                    int i = 0;
                    if (pbContent != null && (num = pbContent.type) != null && num.intValue() == 35) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        if (pbContent != null) {
                            tiebaPlusInfo = pbContent.tiebaplus_info;
                        } else {
                            tiebaPlusInfo = null;
                        }
                        if (tiebaPlusInfo != null) {
                            Integer num3 = pbContent.type;
                            Intrinsics.checkNotNullExpressionValue(num3, "i.type");
                            this.h = num3.intValue();
                            TiebaPlusInfo tiebaPlusInfo3 = pbContent.tiebaplus_info;
                            this.c = tiebaPlusInfo3;
                            if (tiebaPlusInfo3 != null) {
                                String str = tiebaPlusInfo3.download_url;
                            }
                            TiebaPlusInfo tiebaPlusInfo4 = this.c;
                            if (tiebaPlusInfo4 != null) {
                                num2 = tiebaPlusInfo4.jump_type;
                            }
                            if (num2 != null) {
                                Intrinsics.checkNotNullExpressionValue(num2, "mTiebaPlusInfo?.jump_type ?: 0");
                                i = num2.intValue();
                            }
                            this.i = i;
                            return this.c;
                        }
                    }
                }
            }
            return null;
        }
        return (TiebaPlusInfo) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TbDownloadManager getMTbDownloadManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) {
            return (TbDownloadManager) this.k.getValue();
        }
        return (TbDownloadManager) invokeV.objValue;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.c = null;
            this.e = null;
            this.h = 0;
            this.i = 0;
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            PermissionUtil.a.b(new Function0<Unit>(this) { // from class: com.baidu.tbadk.widget.ad.AbsDownloadGuide$download$1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AbsDownloadGuide this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            super(((Integer) newInitContext.callArgs[0]).intValue());
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX DEBUG: Possible override for method kotlin.jvm.functions.Function0.invoke()Ljava/lang/Object; */
                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    DownloadData downloadData;
                    TbDownloadManager mTbDownloadManager;
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (downloadData = this.this$0.getDownloadData()) != null) {
                        AbsDownloadGuide absDownloadGuide = this.this$0;
                        mTbDownloadManager = absDownloadGuide.getMTbDownloadManager();
                        if (mTbDownloadManager.y(downloadData)) {
                            absDownloadGuide.u();
                            absDownloadGuide.f(CommonStatisticKey.KEY_DXX_GUIDE_START_DOWNLOAD);
                        }
                    }
                }
            });
        }
    }

    public final Context getMContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.a;
        }
        return (Context) invokeV.objValue;
    }

    public final String getMConvertBtnType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.j;
        }
        return (String) invokeV.objValue;
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
                return getMTbDownloadManager().p(downloadData);
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public final void h() {
        DownloadData downloadData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && (downloadData = getDownloadData()) != null) {
            AdApkInstallHelper.a.c(getMTbDownloadManager().o(downloadData), downloadData);
        }
    }

    public final boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            DownloadData downloadData = getDownloadData();
            if (downloadData == null) {
                return false;
            }
            if (getMTbDownloadManager().q(downloadData) != 3 && getMTbDownloadManager().q(downloadData) != 0) {
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
            DownloadData downloadData = getDownloadData();
            if (downloadData == null || getMTbDownloadManager().q(downloadData) != 1) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            TiebaPlusInfo tiebaPlusInfo = getTiebaPlusInfo();
            if (tiebaPlusInfo != null && wha.i(tiebaPlusInfo.app_package)) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void o() {
        TiebaPlusInfo tiebaPlusInfo;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048594, this) != null) || (tiebaPlusInfo = getTiebaPlusInfo()) == null) {
            return;
        }
        UtilHelper.startAppByPkgName(tiebaPlusInfo.app_package);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            super.onAttachedToWindow();
            oe7 oe7Var = this.d;
            if (oe7Var != null) {
                getMTbDownloadManager().g(oe7Var);
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

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            s();
            g(TiePlusStat.StatType.CLICK);
        }
    }

    public final void f(String str) {
        String str2;
        int i;
        String str3;
        String str4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            ThreadData threadData = this.b;
            boolean z = true;
            z = (threadData == null || !threadData.isTiebaPlusAdThread) ? false : false;
            String str5 = null;
            if (z) {
                ThreadData threadData2 = this.b;
                if (threadData2 != null) {
                    str4 = threadData2.tiebaPlusOrderId;
                } else {
                    str4 = null;
                }
                str2 = String.valueOf(str4);
            } else {
                str2 = "";
            }
            if (Intrinsics.areEqual(this.j, "a")) {
                i = 5;
            } else {
                i = 6;
            }
            StatisticItem statisticItem = new StatisticItem(str);
            ThreadData threadData3 = this.b;
            if (threadData3 != null) {
                str3 = threadData3.getTid();
            } else {
                str3 = null;
            }
            StatisticItem addParam = statisticItem.addParam("tid", String.valueOf(str3)).addParam("order_id", str2).addParam(TiePlusStat.RichTextType.STAT_KEY, i);
            TiebaPlusInfo tiebaPlusInfo = getTiebaPlusInfo();
            if (tiebaPlusInfo != null) {
                str5 = tiebaPlusInfo.app_package;
            }
            String str6 = "1";
            StatisticItem addParam2 = addParam.addParam("obj_name", str5).addParam("obj_locate", "1");
            if (!ThreadCardUtils.isBusinessMixCard(this.b)) {
                str6 = "0";
            }
            TiebaStatic.log(addParam2.addParam("obj_type", str6));
        }
    }

    public final void g(TiePlusStat.StatType statType) {
        boolean z;
        String str;
        TiePlusStat.RichTextType richTextType;
        String str2;
        String str3;
        Long l;
        String str4;
        String str5;
        String str6;
        String str7;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, statType) == null) {
            ThreadData threadData = this.b;
            boolean z2 = true;
            if (threadData != null && threadData.isTiebaPlusAdThread) {
                z = true;
            } else {
                z = false;
            }
            Long l2 = null;
            if (!z) {
                str = "";
            } else {
                ThreadData threadData2 = this.b;
                if (threadData2 != null) {
                    str7 = threadData2.tiebaPlusOrderId;
                } else {
                    str7 = null;
                }
                str = String.valueOf(str7);
            }
            TiebaPlusInfo tiebaPlusInfo = getTiebaPlusInfo();
            if (tiebaPlusInfo != null) {
                if (statType == TiePlusStat.StatType.EXPOSE) {
                    ThreadData threadData3 = this.b;
                    if (threadData3 != null) {
                        str4 = threadData3.getTid();
                    } else {
                        str4 = null;
                    }
                    if (str4 != null && !StringsKt__StringsJVMKt.isBlank(str4)) {
                        z2 = false;
                    }
                    if (!z2) {
                        List<String> c2 = BusinessMixHelper.c.a().c();
                        ThreadData threadData4 = this.b;
                        if (threadData4 != null) {
                            str5 = threadData4.getTid();
                        } else {
                            str5 = null;
                        }
                        if (CollectionsKt___CollectionsKt.contains(c2, str5)) {
                            return;
                        }
                        List<String> c3 = BusinessMixHelper.c.a().c();
                        ThreadData threadData5 = this.b;
                        if (threadData5 != null) {
                            str6 = threadData5.getTid();
                        } else {
                            str6 = null;
                        }
                        Intrinsics.checkNotNull(str6);
                        c3.add(str6);
                    }
                }
                String str8 = this.j;
                if (Intrinsics.areEqual(str8, "a")) {
                    richTextType = TiePlusStat.RichTextType.CONVERSION_BAR_PART;
                } else if (Intrinsics.areEqual(str8, "b")) {
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
                ThreadData threadData6 = this.b;
                if (threadData6 != null) {
                    str2 = threadData6.getTid();
                } else {
                    str2 = null;
                }
                if (str2 == null) {
                    str3 = "";
                } else {
                    Intrinsics.checkNotNullExpressionValue(str2, "mThreadData?.getTid() ?: \"\"");
                    str3 = str2;
                }
                ThreadData threadData7 = this.b;
                if (threadData7 != null) {
                    l = Long.valueOf(threadData7.getFid());
                } else {
                    l = null;
                }
                String valueOf = String.valueOf(l);
                ThreadData threadData8 = this.b;
                if (threadData8 != null) {
                    l2 = Long.valueOf(threadData8.getDispatchedForumId());
                }
                TiePlusStat.b(a2, statType, locate, threadType, richTextType2, intValue, landingType, str3, valueOf, String.valueOf(l2), str, TiePlusStat.CardBtnType.DOWNLOAD);
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
            if (n()) {
                String string3 = TbadkCoreApplication.getInst().getApp().getString(R.string.item_download_open);
                Intrinsics.checkNotNullExpressionValue(string3, "getInst().app.getString(…tring.item_download_open)");
                return string3;
            } else if (getDownloadData() == null) {
                return "";
            } else {
                TbDownloadManager mTbDownloadManager = getMTbDownloadManager();
                DownloadData downloadData = getDownloadData();
                Intrinsics.checkNotNull(downloadData);
                int q = mTbDownloadManager.q(downloadData);
                if (q != 0) {
                    if (q != 7) {
                        if (q != 3) {
                            if (q != 4) {
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
                    if (Intrinsics.areEqual(this.j, "a")) {
                        string2 = TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f091e);
                    } else {
                        string2 = TbadkCoreApplication.getInst().getApp().getString(R.string.go_on_download);
                    }
                    String str2 = string2;
                    Intrinsics.checkNotNullExpressionValue(str2, "{\n                    if…      }\n                }");
                    return str2;
                }
                if (Intrinsics.areEqual(this.j, "a")) {
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

    public final void s() {
        bz5 bz5Var;
        TiePlusStat.RichTextType richTextType;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            if (this.i == 2) {
                TiebaPlusInfo tiebaPlusInfo = getTiebaPlusInfo();
                if (tiebaPlusInfo != null && wha.i(tiebaPlusInfo.app_package)) {
                    o();
                    return;
                }
                DownloadData downloadData = getDownloadData();
                if (downloadData != null) {
                    int q = getMTbDownloadManager().q(downloadData);
                    if (q != 0) {
                        if (q != 1) {
                            if (q != 3) {
                                if (q != 5) {
                                    if (q != 6 && q != 7) {
                                        if (q == 8) {
                                            o();
                                            return;
                                        }
                                        return;
                                    }
                                    e();
                                    return;
                                }
                            }
                        }
                        getMTbDownloadManager().s(downloadData);
                        return;
                    }
                    h();
                    return;
                }
                return;
            }
            if (getTiebaPlusInfo() != null && this.b != null) {
                int i = this.h;
                TiebaPlusInfo tiebaPlusInfo2 = getTiebaPlusInfo();
                Intrinsics.checkNotNull(tiebaPlusInfo2);
                ThreadData threadData = this.b;
                Intrinsics.checkNotNull(threadData);
                bz5Var = bz5.c(i, tiebaPlusInfo2, threadData);
            } else {
                bz5Var = null;
            }
            if (bz5Var != null) {
                bz5Var.q(TiePlusStat.StatType.CLICK);
            }
            if (bz5Var != null) {
                String str = this.j;
                if (Intrinsics.areEqual(str, "a")) {
                    richTextType = TiePlusStat.RichTextType.CONVERSION_BAR_PART;
                } else if (Intrinsics.areEqual(str, "b")) {
                    richTextType = TiePlusStat.RichTextType.CONVERSION_BAR_FULL;
                } else {
                    richTextType = TiePlusStat.RichTextType.CONVERSION_BAR_FULL;
                }
                bz5Var.p(richTextType);
            }
            if (bz5Var != null) {
                TiePlusEventController.onEvent(bz5Var);
            }
        }
    }

    public final DownloadData getDownloadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
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
            ApkDetail.Builder builder = new ApkDetail.Builder();
            builder.authority_url = tiebaPlusInfo.app_power;
            builder.developer = tiebaPlusInfo.app_company;
            builder.privacy_url = tiebaPlusInfo.app_privacy;
            builder.version = tiebaPlusInfo.app_version;
            builder.version_code = 1;
            builder.pkg_source = 2;
            ItemData itemData = new ItemData();
            itemData.buttonLink = tiebaPlusInfo.download_url;
            itemData.buttonName = ItemCardHelper.b;
            itemData.mTitle = tiebaPlusInfo.title;
            String str = tiebaPlusInfo.app_package;
            itemData.pkgName = str;
            itemData.packageName = str;
            itemData.mIconUrl = tiebaPlusInfo.app_icon;
            itemData.mIconSize = 1.0d;
            itemData.buttonLinkType = 1;
            itemData.forumName = tiebaPlusInfo.forum_name;
            itemData.itemId = JavaTypesHelper.toLong(tiebaPlusInfo.app_id, 0L);
            itemData.apkDetail = builder.build(true);
            itemData.fileType = "app";
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
            DownloadData downloadData6 = this.e;
            if (downloadData6 != null) {
                downloadData6.setItemData(itemData);
            }
            DownloadData downloadData7 = this.e;
            if (downloadData7 != null) {
                downloadData7.mDbExtraData = getExtraDataForDb();
            }
            return this.e;
        }
        return (DownloadData) invokeV.objValue;
    }

    public final void i(CustomResponsedMessage<?> customResponsedMessage, int i) {
        Uri data;
        String str;
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048588, this, customResponsedMessage, i) == null) && customResponsedMessage != null && customResponsedMessage.getData() != null) {
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
                        j(i);
                    }
                }
            }
        }
    }

    public final boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            DownloadData downloadData = getDownloadData();
            if (downloadData == null) {
                return false;
            }
            if (getMTbDownloadManager().q(downloadData) != 1 && getMTbDownloadManager().q(downloadData) != 5 && getMTbDownloadManager().q(downloadData) != 3 && getMTbDownloadManager().q(downloadData) != 0 && getMTbDownloadManager().q(downloadData) != 7) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void q() {
        TiebaPlusInfo tiebaPlusInfo;
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048598, this) != null) || (tiebaPlusInfo = getTiebaPlusInfo()) == null) {
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
            s();
        }
        g(TiePlusStat.StatType.CLICK);
    }
}
