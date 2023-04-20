package com.baidu.tbadk.widget.ad;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.widget.ProgressButton;
import com.baidu.tbadk.widget.ad.DownloadGuidePart;
import com.baidu.tieba.R;
import com.baidu.tieba.r25;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.StringsKt__StringsKt;
import tbclient.TiebaPlusInfo;
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u000b\u001a\u00020\fH\u0002J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\fH\u0016J\u0010\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0010\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\fH\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/baidu/tbadk/widget/ad/DownloadGuidePart;", "Lcom/baidu/tbadk/widget/ad/AbsDownloadGuide;", "mContext", "Landroid/content/Context;", "(Landroid/content/Context;)V", "mGuideContent", "Landroid/widget/TextView;", "mGuideProgress", "Lcom/baidu/tbadk/widget/ProgressButton;", "mRootView", "Landroid/view/View;", "initView", "", "installOrUnUpdateInfo", "installOrUnType", "", "onSkinChanged", "setData", "data", "Lcom/baidu/tbadk/core/data/ThreadData;", "setProgressText", "info", "", "updateInfo", "downloadData", "Lcom/baidu/tbadk/download/DownloadData;", "updateJustStart", "Companion", "tbadkcore_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DownloadGuidePart extends AbsDownloadGuide {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View l;
    public TextView m;
    public ProgressButton n;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1312423352, "Lcom/baidu/tbadk/widget/ad/DownloadGuidePart;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1312423352, "Lcom/baidu/tbadk/widget/ad/DownloadGuidePart;");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DownloadGuidePart(Context mContext) {
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
        v();
    }

    @Override // com.baidu.tbadk.widget.ad.AbsDownloadGuide
    public void t(DownloadData downloadData) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, downloadData) == null) {
            Intrinsics.checkNotNullParameter(downloadData, "downloadData");
            ProgressButton progressButton = this.n;
            int i = 1;
            if (progressButton != null) {
                progressButton.setColorStyle(1);
            }
            ProgressButton progressButton2 = this.n;
            if (progressButton2 != null) {
                progressButton2.e();
            }
            String url = downloadData.getUrl();
            TiebaPlusInfo tiebaPlusInfo = getTiebaPlusInfo();
            if (tiebaPlusInfo != null) {
                str = tiebaPlusInfo.download_url;
            } else {
                str = null;
            }
            if (Intrinsics.areEqual(url, str)) {
                int status = downloadData.getStatus();
                if (status != 0) {
                    if (status != 1) {
                        if (status != 5) {
                            ProgressButton progressButton3 = this.n;
                            if (progressButton3 != null) {
                                progressButton3.setCurProgress(getProgress());
                            }
                            setProgressText(getDescInfo());
                            return;
                        }
                        u();
                        return;
                    }
                    int length = (int) ((downloadData.getLength() * 100) / downloadData.getSize());
                    ProgressButton progressButton4 = this.n;
                    if (progressButton4 != null) {
                        if (length > 0) {
                            i = length;
                        }
                        progressButton4.j(i);
                        return;
                    }
                    return;
                }
                ProgressButton progressButton5 = this.n;
                if (progressButton5 != null) {
                    progressButton5.setCurProgress(100);
                }
                setProgressText(getDescInfo());
            }
        }
    }

    private final void setProgressText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, str) == null) {
            if (str.length() > 4) {
                str = StringsKt__StringsKt.substring(str, RangesKt___RangesKt.until(0, 4));
            }
            ProgressButton progressButton = this.n;
            if (progressButton != null) {
                progressButton.setText(str);
            }
        }
    }

    public static final void w(DownloadGuidePart this$0, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, this$0, view2) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.p();
        }
    }

    public static final void x(DownloadGuidePart this$0, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, this$0, view2) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.o();
        }
    }

    @Override // com.baidu.tbadk.widget.ad.AbsDownloadGuide
    public void i(int i) {
        ProgressButton progressButton;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            if (i != 1) {
                if (i == 2 && (progressButton = this.n) != null) {
                    progressButton.setColorStyle(1);
                }
            } else {
                ProgressButton progressButton2 = this.n;
                if (progressButton2 != null) {
                    progressButton2.setColorStyle(0);
                }
            }
            ProgressButton progressButton3 = this.n;
            if (progressButton3 != null) {
                progressButton3.e();
            }
            ProgressButton progressButton4 = this.n;
            if (progressButton4 != null) {
                progressButton4.setCurProgress(-1);
            }
            setProgressText(getDescInfo());
        }
    }

    @Override // com.baidu.tbadk.widget.ad.AbsDownloadGuide
    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            r25.d(this).f(R.color.CAM_X0905);
            TextView textView = this.m;
            if (textView != null) {
                r25.d(textView).w(R.color.CAM_X0304);
            }
            ProgressButton progressButton = this.n;
            if (progressButton != null) {
                progressButton.i();
            }
        }
    }

    @Override // com.baidu.tbadk.widget.ad.AbsDownloadGuide
    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            int progress = getProgress();
            ProgressButton progressButton = this.n;
            if (progressButton != null) {
                if (progress <= 0) {
                    progress = 1;
                }
                progressButton.j(progress);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.ad.AbsDownloadGuide
    public void setData(ThreadData data) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, data) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            super.setData(data);
            TiebaPlusInfo tiebaPlusInfo = getTiebaPlusInfo();
            if (tiebaPlusInfo == null) {
                return;
            }
            TextView textView = this.m;
            String str = "";
            if (textView != null) {
                String str2 = tiebaPlusInfo.button_desc;
                if (str2 == null) {
                    str2 = "";
                }
                textView.setText(str2);
            }
            ProgressButton progressButton = this.n;
            if (progressButton != null) {
                progressButton.setColorStyle(1);
            }
            ProgressButton progressButton2 = this.n;
            if (progressButton2 != null) {
                progressButton2.e();
            }
            if (m()) {
                ProgressButton progressButton3 = this.n;
                if (progressButton3 != null) {
                    progressButton3.setColorStyle(0);
                }
                ProgressButton progressButton4 = this.n;
                if (progressButton4 != null) {
                    progressButton4.e();
                }
                ProgressButton progressButton5 = this.n;
                if (progressButton5 != null) {
                    progressButton5.setCurProgress(-1);
                }
                setProgressText(getDescInfo());
            } else if (j()) {
                ProgressButton progressButton6 = this.n;
                if (progressButton6 != null) {
                    progressButton6.setCurProgress(100);
                }
                setProgressText(getDescInfo());
            } else if (k()) {
                if (l()) {
                    ProgressButton progressButton7 = this.n;
                    if (progressButton7 != null) {
                        progressButton7.j(getProgress());
                        return;
                    }
                    return;
                }
                ProgressButton progressButton8 = this.n;
                if (progressButton8 != null) {
                    progressButton8.setCurProgress(getProgress());
                }
                setProgressText(getDescInfo());
            } else {
                ProgressButton progressButton9 = this.n;
                if (progressButton9 != null) {
                    progressButton9.setCurProgress(-1);
                }
                String str3 = tiebaPlusInfo.desc;
                if (str3 != null) {
                    str = str3;
                }
                setProgressText(str);
            }
        }
    }

    public final void v() {
        TextView textView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            setMConvertBtnType("a");
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.download_guide_part, (ViewGroup) this, true);
            this.l = inflate;
            ProgressButton progressButton = null;
            if (inflate != null) {
                textView = (TextView) inflate.findViewById(R.id.guide_content);
            } else {
                textView = null;
            }
            this.m = textView;
            View view2 = this.l;
            if (view2 != null) {
                progressButton = (ProgressButton) view2.findViewById(R.id.guide_progress);
            }
            this.n = progressButton;
            setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ls5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view3) == null) {
                        DownloadGuidePart.w(DownloadGuidePart.this, view3);
                    }
                }
            });
            ProgressButton progressButton2 = this.n;
            if (progressButton2 != null) {
                progressButton2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ns5
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view3) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view3) == null) {
                            DownloadGuidePart.x(DownloadGuidePart.this, view3);
                        }
                    }
                });
            }
            q();
        }
    }
}
