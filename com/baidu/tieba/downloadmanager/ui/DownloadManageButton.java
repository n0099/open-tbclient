package com.baidu.tieba.downloadmanager.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.downloadmanager.ui.DownloadManageButton;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0002\u0016\u0017B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\u0011\u001a\u00020\nJ\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\nR\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0018"}, d2 = {"Lcom/baidu/tieba/downloadmanager/ui/DownloadManageButton;", "Landroidx/appcompat/widget/AppCompatTextView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "currentManageType", "Lcom/baidu/tieba/downloadmanager/ui/DownloadManageButton$DownloadManageType;", "typeChangeCallback", "Lcom/baidu/tieba/downloadmanager/ui/DownloadManageButton$DownloadManageTypeChangeCallback;", "getTypeChangeCallback", "()Lcom/baidu/tieba/downloadmanager/ui/DownloadManageButton$DownloadManageTypeChangeCallback;", "setTypeChangeCallback", "(Lcom/baidu/tieba/downloadmanager/ui/DownloadManageButton$DownloadManageTypeChangeCallback;)V", "getCurrentManageType", "onChangeSkinType", "", "updateStatus", "changeManageType", "DownloadManageType", "DownloadManageTypeChangeCallback", "downloadmanager_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DownloadManageButton extends AppCompatTextView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public DownloadManageType a;
    public a b;

    /* loaded from: classes5.dex */
    public interface a {
        void a();

        void switchToNormal();
    }

    /* loaded from: classes5.dex */
    public /* synthetic */ class b {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-862235365, "Lcom/baidu/tieba/downloadmanager/ui/DownloadManageButton$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-862235365, "Lcom/baidu/tieba/downloadmanager/ui/DownloadManageButton$b;");
                    return;
                }
            }
            int[] iArr = new int[DownloadManageType.values().length];
            iArr[DownloadManageType.NONE_TASK.ordinal()] = 1;
            iArr[DownloadManageType.NORMAL.ordinal()] = 2;
            iArr[DownloadManageType.MANAGE.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DownloadManageButton(Context context) {
        this(context, null, 0, 6, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue(), (DefaultConstructorMarker) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DownloadManageButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
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
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/baidu/tieba/downloadmanager/ui/DownloadManageButton$DownloadManageType;", "", "text", "", "textColor", "", "(Ljava/lang/String;ILjava/lang/String;I)V", "getText", "()Ljava/lang/String;", "getTextColor", "()I", "NONE_INIT", "NONE_TASK", "NORMAL", "MANAGE", "downloadmanager_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class DownloadManageType {
        public static final /* synthetic */ DownloadManageType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final DownloadManageType MANAGE;
        public static final DownloadManageType NONE_INIT;
        public static final DownloadManageType NONE_TASK;
        public static final DownloadManageType NORMAL;
        public transient /* synthetic */ FieldHolder $fh;
        public final String text;
        public final int textColor;

        public static final /* synthetic */ DownloadManageType[] $values() {
            return new DownloadManageType[]{NONE_INIT, NONE_TASK, NORMAL, MANAGE};
        }

        public static DownloadManageType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (DownloadManageType) Enum.valueOf(DownloadManageType.class, str) : (DownloadManageType) invokeL.objValue;
        }

        public static DownloadManageType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (DownloadManageType[]) $VALUES.clone() : (DownloadManageType[]) invokeV.objValue;
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1535475886, "Lcom/baidu/tieba/downloadmanager/ui/DownloadManageButton$DownloadManageType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1535475886, "Lcom/baidu/tieba/downloadmanager/ui/DownloadManageButton$DownloadManageType;");
                    return;
                }
            }
            NONE_INIT = new DownloadManageType("NONE_INIT", 0, "", 0);
            String string = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0c4f);
            Intrinsics.checkNotNullExpressionValue(string, "getInst().getString(R.string.manage)");
            NONE_TASK = new DownloadManageType("NONE_TASK", 1, string, R.color.CAM_X0110);
            String string2 = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0c4f);
            Intrinsics.checkNotNullExpressionValue(string2, "getInst().getString(R.string.manage)");
            NORMAL = new DownloadManageType("NORMAL", 2, string2, R.color.CAM_X0107);
            String string3 = TbadkCoreApplication.getInst().getString(R.string.exit_manage);
            Intrinsics.checkNotNullExpressionValue(string3, "getInst().getString(R.string.exit_manage)");
            MANAGE = new DownloadManageType("MANAGE", 3, string3, R.color.CAM_X0107);
            $VALUES = $values();
        }

        public DownloadManageType(String str, int i, String str2, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i), str2, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65538, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str3 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
            this.text = str2;
            this.textColor = i2;
        }

        public final String getText() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.text;
            }
            return (String) invokeV.objValue;
        }

        public final int getTextColor() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.textColor;
            }
            return invokeV.intValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DownloadManageButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
        this.a = DownloadManageType.NONE_INIT;
        f(DownloadManageType.NONE_TASK);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.cz6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                    DownloadManageButton.d(DownloadManageButton.this, view2);
                }
            }
        });
    }

    public /* synthetic */ DownloadManageButton(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public static final void d(DownloadManageButton this$0, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, this$0, view2) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            int i = b.$EnumSwitchMapping$0[this$0.a.ordinal()];
            if (i != 2) {
                if (i == 3) {
                    this$0.f(DownloadManageType.NORMAL);
                    return;
                }
                return;
            }
            this$0.f(DownloadManageType.MANAGE);
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            setTextColor(SkinManager.getColor(this.a.getTextColor()));
        }
    }

    public final DownloadManageType getCurrentManageType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.a;
        }
        return (DownloadManageType) invokeV.objValue;
    }

    public final a getTypeChangeCallback() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.b;
        }
        return (a) invokeV.objValue;
    }

    public final void f(DownloadManageType changeManageType) {
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, changeManageType) == null) {
            Intrinsics.checkNotNullParameter(changeManageType, "changeManageType");
            if (this.a == changeManageType) {
                return;
            }
            setTextColor(SkinManager.getColor(changeManageType.getTextColor()));
            setText(changeManageType.getText());
            if (this.a == DownloadManageType.NORMAL && changeManageType == DownloadManageType.MANAGE) {
                a aVar2 = this.b;
                if (aVar2 != null) {
                    aVar2.a();
                }
            } else if (this.a == DownloadManageType.MANAGE && (aVar = this.b) != null) {
                aVar.switchToNormal();
            }
            this.a = changeManageType;
        }
    }

    public final void setTypeChangeCallback(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
            this.b = aVar;
        }
    }
}
