package com.baidu.tbadk.widget.ad;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.widget.ad.DownloadGuideFull;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tbclient.TiebaPlusInfo;
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u000b\u001a\u00020\fH\u0002J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\fH\u0016J\u0010\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\fH\u0016R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006\u0019"}, d2 = {"Lcom/baidu/tbadk/widget/ad/DownloadGuideFull;", "Lcom/baidu/tbadk/widget/ad/AbsDownloadGuide;", "mContext", "Landroid/content/Context;", "(Landroid/content/Context;)V", "guideProgressView", "Lcom/baidu/tbadk/widget/ad/GuideProgressView;", "getGuideProgressView", "()Lcom/baidu/tbadk/widget/ad/GuideProgressView;", "guideProgressView$delegate", "Lkotlin/Lazy;", "initView", "", "installOrUnUpdateInfo", "installOrUnType", "", "onSkinChanged", "setData", "data", "Lcom/baidu/tbadk/core/data/ThreadData;", "updateInfo", "downloadData", "Lcom/baidu/tbadk/download/DownloadData;", "updateJustStart", "Companion", "tbadkcore_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DownloadGuideFull extends AbsDownloadGuide {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int m = 2131167453;
    public transient /* synthetic */ FieldHolder $fh;
    public final Lazy l;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1303777948, "Lcom/baidu/tbadk/widget/ad/DownloadGuideFull;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1303777948, "Lcom/baidu/tbadk/widget/ad/DownloadGuideFull;");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DownloadGuideFull(final Context mContext) {
        super(mContext, null, 0, 6, null);
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
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue(), (DefaultConstructorMarker) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        this.l = LazyKt__LazyJVMKt.lazy(new Function0<GuideProgressView>(mContext) { // from class: com.baidu.tbadk.widget.ad.DownloadGuideFull$guideProgressView$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Context $mContext;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {mContext};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.$mContext = mContext;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final GuideProgressView invoke() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    return new GuideProgressView(this.$mContext, null, 0, 6, null);
                }
                return (GuideProgressView) invokeV.objValue;
            }
        });
        v();
    }

    private final GuideProgressView getGuideProgressView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            return (GuideProgressView) this.l.getValue();
        }
        return (GuideProgressView) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.widget.ad.AbsDownloadGuide
    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            getGuideProgressView().d();
        }
    }

    @Override // com.baidu.tbadk.widget.ad.AbsDownloadGuide
    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            int progress = getProgress();
            getGuideProgressView().setMIsShowArrow(false);
            GuideProgressView guideProgressView = getGuideProgressView();
            if (progress <= 0) {
                progress = 1;
            }
            guideProgressView.g(progress);
        }
    }

    public static final void w(DownloadGuideFull this$0, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, this$0, view2) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.p();
        }
    }

    @Override // com.baidu.tbadk.widget.ad.AbsDownloadGuide
    public void j(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            if (i != 1) {
                if (i == 2) {
                    getGuideProgressView().setMLeftIconType(1);
                }
            } else {
                getGuideProgressView().setMLeftIconType(2);
            }
            getGuideProgressView().setMIsShowArrow(true);
            getGuideProgressView().setProgress(getProgress());
            getGuideProgressView().setText(getDescInfo());
        }
    }

    @Override // com.baidu.tbadk.widget.ad.AbsDownloadGuide
    public void setData(ThreadData data) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, data) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            super.setData(data);
            setMThreadData(data);
            TiebaPlusInfo tiebaPlusInfo = getTiebaPlusInfo();
            if (tiebaPlusInfo == null) {
                return;
            }
            if (!n() && !k()) {
                getGuideProgressView().setMLeftIconType(1);
                if (l()) {
                    getGuideProgressView().setMIsShowArrow(false);
                    if (m()) {
                        getGuideProgressView().g(getProgress());
                        return;
                    }
                    getGuideProgressView().setProgress(getProgress());
                    getGuideProgressView().setText(getDescInfo());
                    return;
                }
                getGuideProgressView().setMIsShowArrow(true);
                GuideProgressView guideProgressView = getGuideProgressView();
                String str = tiebaPlusInfo.desc;
                if (str == null) {
                    str = "";
                }
                guideProgressView.setText(str);
                return;
            }
            getGuideProgressView().setMLeftIconType(2);
            getGuideProgressView().setMIsShowArrow(true);
            getGuideProgressView().setProgress(getProgress());
            getGuideProgressView().setText(getDescInfo());
        }
    }

    @Override // com.baidu.tbadk.widget.ad.AbsDownloadGuide
    public void t(DownloadData downloadData) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, downloadData) == null) {
            Intrinsics.checkNotNullParameter(downloadData, "downloadData");
            int i = 1;
            getGuideProgressView().setMLeftIconType(1);
            String url = downloadData.getUrl();
            TiebaPlusInfo tiebaPlusInfo = getTiebaPlusInfo();
            String str2 = null;
            if (tiebaPlusInfo != null) {
                str = tiebaPlusInfo.download_url;
            } else {
                str = null;
            }
            if (!Intrinsics.areEqual(url, str)) {
                DownloadData downloadData2 = getDownloadData();
                if (downloadData2 != null) {
                    str2 = downloadData2.getId();
                }
                if (!Intrinsics.areEqual(str2, downloadData.getId())) {
                    return;
                }
            }
            int status = downloadData.getStatus();
            if (status != 0) {
                if (status != 1) {
                    if (status != 4) {
                        if (status != 5) {
                            getGuideProgressView().setMIsShowArrow(true);
                            getGuideProgressView().setProgress(getProgress());
                            getGuideProgressView().setText(getDescInfo());
                            return;
                        }
                        u();
                        return;
                    }
                    getGuideProgressView().setMIsShowArrow(false);
                    getGuideProgressView().setProgress(getProgress());
                    getGuideProgressView().setText(getDescInfo());
                    return;
                }
                getGuideProgressView().setMIsShowArrow(false);
                int length = (int) ((downloadData.getLength() * 100) / downloadData.getSize());
                GuideProgressView guideProgressView = getGuideProgressView();
                if (length > 0) {
                    i = length;
                }
                guideProgressView.g(i);
                return;
            }
            getGuideProgressView().setMLeftIconType(2);
            getGuideProgressView().setMIsShowArrow(true);
            getGuideProgressView().setProgress(100);
            getGuideProgressView().setText(getDescInfo());
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            setMConvertBtnType("b");
            addView(getGuideProgressView());
            ViewGroup.LayoutParams layoutParams = getGuideProgressView().getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = UtilHelper.getDimenPixelSize(m);
            setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.rv5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        DownloadGuideFull.w(DownloadGuideFull.this, view2);
                    }
                }
            });
            r();
        }
    }
}
