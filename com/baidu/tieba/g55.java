package com.baidu.tieba;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.GreyUtil;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes5.dex */
public class g55 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DIALOG_SIZE_BIG = 1;
    public static final int DIALOG_SIZE_FOR_FORUM_OPRATION = 10;
    public static final int DIALOG_SIZE_FOR_FRS_LIKE_POSTER = 9;
    public static final int DIALOG_SIZE_FOR_NEW_PRIVATE = 7;
    public static final int DIALOG_SIZE_FOR_PRIVACY_POLICY_GUIDE = 8;
    public static final int DIALOG_SIZE_FOR_PRIVATE = 3;
    public static final int DIALOG_SIZE_PRIVATE = 2;
    public static final int DIALOG_SIZE_SMALL = 0;
    public static final int DIALOG_SIZW_PRIVACY_BUTTON = 6;
    public static final int DIALOG_SIZW_PUSH_PERMISSION = 4;
    public static final int DIALOG_SIZW_YOUNGSTER = 5;
    public transient /* synthetic */ FieldHolder $fh;
    public int animRes;
    public View bdDialog_divider_line;
    public boolean cancelableFlag;
    public int dialogSize;
    public View dividerWithButton;
    public Handler handler;
    public TextView introTextView;
    public boolean isAutoNight;
    public boolean isMessageShowCenter;
    public boolean isOnlyMessageShowCenter;
    public boolean isTitleShowCenter;
    public final Activity mActivity;
    public int mButtonTextColorId;
    public DialogInterface.OnCancelListener mCancelListenr;
    public boolean mCancelable;
    public Button mCloseButton;
    public e mCloseButtonListener;
    public View mContentView;
    public AlertDialog mDialog;
    public boolean mDialogCreated;
    public int mDialogGravity;
    public DialogInterface.OnDismissListener mDismissListener;
    public String mMessage;
    public e mNegativeButtonListener;
    public String mNegativeButtonTip;
    public int mNegativeTextColorId;
    public DialogInterface.OnKeyListener mOnKeyListener;
    public e mPositiveButtonListener;
    public String mPositiveButtonTip;
    public ViewGroup mRealView;
    public final ViewGroup mRootView;
    public String mTitle;
    public TextView noButton;
    public TextView noTipAgain;
    public ImageView noTipAgainCheckBox;
    public boolean noTipAgainChecked;
    public TextView titleTextView;
    public boolean useNoTipAgainStyle;
    public TextView yesButton;
    public Object yesTag;

    /* loaded from: classes5.dex */
    public interface e {
        void onClick(g55 g55Var);
    }

    /* loaded from: classes5.dex */
    public interface f {
        void a();
    }

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g55 a;

        public a(g55 g55Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g55Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = g55Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                g55 g55Var = this.a;
                g55Var.noTipAgainChecked = !g55Var.noTipAgainChecked;
                this.a.setCheckBoxDrawable();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements ViewHelper.ViewCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AtomicBoolean a;

        public b(g55 g55Var, AtomicBoolean atomicBoolean) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g55Var, atomicBoolean};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = atomicBoolean;
        }

        @Override // com.baidu.tbadk.core.util.ViewHelper.ViewCallback
        public boolean onViewFound(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
                if (view2 instanceof EditText) {
                    this.a.set(true);
                    return true;
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g55 a;

        public c(g55 g55Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g55Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = g55Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.show(true);
        }
    }

    /* loaded from: classes5.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final g55 a;
        public final e b;

        public d(g55 g55Var, g55 g55Var2, e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g55Var, g55Var2, eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = g55Var2;
            this.b = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            e eVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (eVar = this.b) != null) {
                eVar.onClick(this.a);
            }
        }
    }

    public g55(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mDialogGravity = -1;
        this.isOnlyMessageShowCenter = true;
        this.isMessageShowCenter = false;
        this.isTitleShowCenter = false;
        this.mButtonTextColorId = -1;
        this.mNegativeTextColorId = -1;
        this.dialogSize = 0;
        this.mDialogCreated = false;
        this.cancelableFlag = true;
        this.mCancelable = true;
        this.isAutoNight = true;
        this.useNoTipAgainStyle = false;
        this.noTipAgainChecked = false;
        this.animRes = -1;
        this.mActivity = activity;
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(activity).inflate(R.layout.dialog_bdalert, (ViewGroup) null);
        this.mRootView = viewGroup;
        this.mRealView = (ViewGroup) viewGroup.findViewById(R.id.real_view);
    }

    public void setAnimRes(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            this.animRes = i;
        }
    }

    public void setAutoNight(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            this.isAutoNight = z;
        }
    }

    public g55 setButtonTextColor(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048593, this, i)) == null) {
            this.mButtonTextColorId = i;
            return this;
        }
        return (g55) invokeI.objValue;
    }

    public g55 setCancelable(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048594, this, z)) == null) {
            this.mCancelable = z;
            return this;
        }
        return (g55) invokeZ.objValue;
    }

    public g55 setCanceledOnTouchOutside(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048595, this, z)) == null) {
            this.cancelableFlag = z;
            return this;
        }
        return (g55) invokeZ.objValue;
    }

    public g55 setCloseButton(e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, eVar)) == null) {
            if (eVar != null) {
                this.mCloseButtonListener = eVar;
            }
            return this;
        }
        return (g55) invokeL.objValue;
    }

    public g55 setContentView(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, view2)) == null) {
            this.mContentView = view2;
            return this;
        }
        return (g55) invokeL.objValue;
    }

    public g55 setContentViewSize(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048598, this, i)) == null) {
            this.dialogSize = i;
            return this;
        }
        return (g55) invokeI.objValue;
    }

    public g55 setGravity(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048599, this, i)) == null) {
            this.mDialogGravity = i;
            return this;
        }
        return (g55) invokeI.objValue;
    }

    public g55 setMessage(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, str)) == null) {
            this.mMessage = str;
            return this;
        }
        return (g55) invokeL.objValue;
    }

    public g55 setMessageId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048601, this, i)) == null) {
            Activity activity = this.mActivity;
            if (activity != null) {
                this.mMessage = activity.getResources().getString(i);
            }
            return this;
        }
        return (g55) invokeI.objValue;
    }

    public void setMessageShowCenter(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048602, this, z) == null) {
            this.isMessageShowCenter = z;
        }
    }

    public g55 setNegativeTextColor(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048605, this, i)) == null) {
            this.mNegativeTextColorId = i;
            return this;
        }
        return (g55) invokeI.objValue;
    }

    public g55 setOnCalcelListener(DialogInterface.OnCancelListener onCancelListener) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, onCancelListener)) == null) {
            this.mCancelListenr = onCancelListener;
            return this;
        }
        return (g55) invokeL.objValue;
    }

    public g55 setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, onDismissListener)) == null) {
            this.mDismissListener = onDismissListener;
            return this;
        }
        return (g55) invokeL.objValue;
    }

    public void setOnKeyListener(DialogInterface.OnKeyListener onKeyListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, onKeyListener) == null) {
            this.mOnKeyListener = onKeyListener;
        }
    }

    public void setOnlyMessageShowCenter(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048609, this, z) == null) {
            this.isOnlyMessageShowCenter = z;
        }
    }

    public g55 setTitle(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048612, this, i)) == null) {
            setTitle(this.mActivity.getResources().getString(i));
            return this;
        }
        return (g55) invokeI.objValue;
    }

    public void setTitleShowCenter(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048614, this, z) == null) {
            this.isTitleShowCenter = z;
        }
    }

    public void setUseNoTipAgainStyle(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048615, this, z) == null) {
            this.useNoTipAgainStyle = z;
        }
    }

    public void setYesBtnClickable(boolean z) {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048616, this, z) == null) && (textView = this.yesButton) != null) {
            textView.setClickable(z);
        }
    }

    public void setYesButtonTag(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, obj) == null) {
            this.yesTag = obj;
        }
    }

    public void show(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048619, this, j) == null) {
            Handler handler = new Handler();
            this.handler = handler;
            handler.postDelayed(new c(this), j);
        }
    }

    public g55 setNegativeButton(int i, e eVar) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048603, this, i, eVar)) == null) {
            Activity activity = this.mActivity;
            if (activity != null) {
                this.mNegativeButtonTip = activity.getResources().getString(i);
                this.mNegativeButtonListener = eVar;
            }
            return this;
        }
        return (g55) invokeIL.objValue;
    }

    public g55 setPositiveButton(int i, e eVar) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048610, this, i, eVar)) == null) {
            Activity activity = this.mActivity;
            if (activity != null) {
                this.mPositiveButtonTip = activity.getResources().getString(i);
                this.mPositiveButtonListener = eVar;
            }
            return this;
        }
        return (g55) invokeIL.objValue;
    }

    private void changeContentWithNoTipAgainSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, this) == null) {
            SkinManager.setViewTextColor(this.titleTextView, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.introTextView, (int) R.color.CAM_X0107);
            setCheckBoxDrawable();
            SkinManager.setViewTextColor(this.noTipAgain, (int) R.color.CAM_X0107);
            initButtonStyle();
        }
    }

    public void dismiss() {
        AlertDialog alertDialog;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (alertDialog = this.mDialog) != null) {
            ah.a(alertDialog, this.mActivity);
        }
    }

    public Dialog getDialog() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.mDialog;
        }
        return (Dialog) invokeV.objValue;
    }

    public ViewGroup getRealView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.mRealView;
        }
        return (ViewGroup) invokeV.objValue;
    }

    public Window getWindow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.mDialog.getWindow();
        }
        return (Window) invokeV.objValue;
    }

    public Object getYesButtonTag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.yesTag;
        }
        return invokeV.objValue;
    }

    public void hide() {
        AlertDialog alertDialog;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && (alertDialog = this.mDialog) != null) {
            alertDialog.hide();
        }
    }

    public boolean isAutoNight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.isAutoNight;
        }
        return invokeV.booleanValue;
    }

    public boolean isNoTipAgainChecked() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.noTipAgainChecked;
        }
        return invokeV.booleanValue;
    }

    public boolean isShowing() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            AlertDialog alertDialog = this.mDialog;
            if (alertDialog != null) {
                return alertDialog.isShowing();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.mDialogCreated = false;
        }
    }

    public g55 show() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            return show(true);
        }
        return (g55) invokeV.objValue;
    }

    public g55 showNoCheck() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            return show(false);
        }
        return (g55) invokeV.objValue;
    }

    private void initButtonStyle() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, this) == null) {
            TextView textView = this.noButton;
            if (textView != null) {
                s75 d2 = s75.d(textView);
                d2.A(R.color.CAM_X0302);
                d2.o(R.string.J_X06);
                d2.f(R.color.CAM_X0211);
            }
            TextView textView2 = this.yesButton;
            if (textView2 != null) {
                s75 d3 = s75.d(textView2);
                d3.A(R.color.CAM_X0302);
                d3.o(R.string.J_X06);
                d3.f(R.color.CAM_X0211);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCheckBoxDrawable() {
        ImageView imageView;
        Drawable maskDrawable;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(65544, this) != null) || (imageView = this.noTipAgainCheckBox) == null) {
            return;
        }
        if (this.noTipAgainChecked) {
            maskDrawable = SvgManager.getInstance().getMaskDrawable(R.drawable.ic_icon_mask_use_complete16_svg, null);
        } else {
            maskDrawable = SvgManager.getInstance().getMaskDrawable(R.drawable.ic_icon_mask_use_check16_svg, null);
        }
        imageView.setImageDrawable(maskDrawable);
    }

    private void mouldButtons(boolean z, boolean z2) {
        View view2;
        View view3;
        View view4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if (z && z2) {
                View view5 = this.dividerWithButton;
                if (view5 != null) {
                    view5.setVisibility(0);
                }
                View view6 = this.bdDialog_divider_line;
                if (view6 != null) {
                    view6.setVisibility(0);
                    return;
                }
                return;
            }
            if (isAutoNight()) {
                TbadkCoreApplication.getInst().getSkinType();
            }
            View view7 = this.dividerWithButton;
            if (view7 != null) {
                view7.setVisibility(8);
            }
            if (!z && !z2) {
                TextView textView = this.yesButton;
                if (textView != null && this.noButton != null && this.dividerWithButton != null && this.bdDialog_divider_line != null) {
                    textView.setVisibility(8);
                    this.noButton.setVisibility(8);
                    this.dividerWithButton.setVisibility(8);
                    this.bdDialog_divider_line.setVisibility(8);
                }
            } else if (z) {
                s75 d2 = s75.d(this.yesButton);
                d2.o(R.string.J_X06);
                d2.f(R.color.CAM_X0211);
                if (this.noButton != null && this.dividerWithButton != null && (view4 = this.bdDialog_divider_line) != null) {
                    view4.setVisibility(0);
                    this.yesButton.setVisibility(0);
                    this.noButton.setVisibility(8);
                }
            } else if (z2) {
                s75 d3 = s75.d(this.noButton);
                d3.o(R.string.J_X06);
                d3.f(R.color.CAM_X0211);
                if (this.yesButton != null && this.dividerWithButton != null && (view3 = this.bdDialog_divider_line) != null) {
                    view3.setVisibility(0);
                    this.noButton.setVisibility(0);
                    this.yesButton.setVisibility(8);
                }
            } else if (this.yesButton != null && this.noButton != null && (view2 = this.bdDialog_divider_line) != null) {
                view2.setVisibility(8);
                this.yesButton.setVisibility(8);
                this.noButton.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public g55 show(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65545, this, z)) == null) {
            if (this.mDialogCreated) {
                AlertDialog alertDialog = this.mDialog;
                if (alertDialog != null) {
                    if (z) {
                        ah.i(alertDialog, this.mActivity);
                    } else {
                        alertDialog.show();
                    }
                    return this;
                }
                AlertDialog create = new AlertDialog.Builder(this.mActivity, R.style.obfuscated_res_0x7f10010d).create();
                this.mDialog = create;
                GreyUtil.grey(create);
                this.mDialog.setCanceledOnTouchOutside(this.cancelableFlag);
                this.mDialog.setCancelable(this.mCancelable);
                this.mDialog.setOnKeyListener(this.mOnKeyListener);
                DialogInterface.OnCancelListener onCancelListener = this.mCancelListenr;
                if (onCancelListener != null) {
                    this.mDialog.setOnCancelListener(onCancelListener);
                }
                DialogInterface.OnDismissListener onDismissListener = this.mDismissListener;
                if (onDismissListener != null) {
                    this.mDialog.setOnDismissListener(onDismissListener);
                }
                if (z) {
                    ah.i(this.mDialog, this.mActivity);
                } else {
                    this.mDialog.show();
                }
                if (this.mDialog.getWindow().getDecorView().getParent() == null) {
                    return this;
                }
                Window window = this.mDialog.getWindow();
                if (this.mDialogGravity == -1) {
                    this.mDialogGravity = 17;
                }
                window.setGravity(this.mDialogGravity);
                window.setBackgroundDrawable(new ColorDrawable(0));
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.dimAmount = 0.7f;
                attributes.width = -1;
                DisplayMetrics t = xi.t(this.mActivity);
                if (t != null) {
                    int dialogMargin = getDialogMargin();
                    if (UtilHelper.getRealScreenOrientation(this.mActivity) == 2) {
                        attributes.width = t.heightPixels - (dialogMargin * 2);
                    } else {
                        attributes.width = t.widthPixels - (dialogMargin * 2);
                    }
                }
                attributes.height = -2;
                window.setAttributes(attributes);
                window.setContentView(this.mRootView);
                AtomicBoolean atomicBoolean = new AtomicBoolean(false);
                ViewHelper.processAllViewsIn(this.mRootView, false, new b(this, atomicBoolean));
                if (atomicBoolean.get()) {
                    window.clearFlags(131080);
                }
                int i = this.animRes;
                if (i != -1) {
                    window.setWindowAnimations(i);
                }
                return this;
            }
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        return (g55) invokeZ.objValue;
    }

    public void autoChangeSkinType(@Nullable l9<?> l9Var) {
        int i;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, l9Var) == null) {
            try {
                boolean z2 = false;
                if (isAutoNight()) {
                    i = TbadkCoreApplication.getInst().getSkinType();
                } else {
                    i = 0;
                }
                if (l9Var instanceof TbPageContext) {
                    h05 layoutMode = ((TbPageContext) l9Var).getLayoutMode();
                    if (i == 4) {
                        z = true;
                    } else {
                        z = false;
                    }
                    layoutMode.l(z);
                    h05 layoutMode2 = ((TbPageContext) l9Var).getLayoutMode();
                    if (!isAutoNight()) {
                        z2 = true;
                    }
                    layoutMode2.e = z2;
                    ((TbPageContext) l9Var).getLayoutMode().k(this.mRootView);
                    if (this.mContentView != null) {
                        ((TbPageContext) l9Var).getLayoutMode().k(this.mContentView);
                    }
                }
                if (this.mRootView != null) {
                    this.mRootView.setBackgroundResource(R.drawable.transparent_bg);
                }
                if (this.mRealView != null && (this.dialogSize == 2 || this.dialogSize == 5 || this.dialogSize == 10 || this.dialogSize == 9)) {
                    this.mRealView.setBackgroundResource(R.drawable.dialog_private_background);
                } else {
                    SkinManager.setBackgroundResource(this.mRealView, R.drawable.dialog_background, i);
                }
                changeContentWithNoTipAgainSkinType();
            } catch (Resources.NotFoundException e2) {
                e2.printStackTrace();
            }
        }
    }

    public g55 create(@Nullable l9<?> l9Var) {
        InterceptResult invokeL;
        View isShowTitleAndMessage;
        boolean z;
        TextView textView;
        TextView textView2;
        TextView textView3;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, l9Var)) == null) {
            if (this.mDialogCreated) {
                return this;
            }
            boolean z2 = true;
            this.mDialogCreated = true;
            LinearLayout linearLayout = (LinearLayout) this.mRootView.findViewById(R.id.dialog_content);
            this.yesButton = (TextView) this.mRootView.findViewById(R.id.obfuscated_res_0x7f092a19);
            this.noButton = (TextView) this.mRootView.findViewById(R.id.obfuscated_res_0x7f091922);
            this.dividerWithButton = this.mRootView.findViewById(R.id.divider_yes_no_button);
            this.bdDialog_divider_line = this.mRootView.findViewById(R.id.bdDialog_divider_line);
            this.mCloseButton = (Button) this.mRootView.findViewById(R.id.obfuscated_res_0x7f090724);
            initButtonStyle();
            if (this.mContentView != null) {
                linearLayout.removeAllViews();
                if (this.mContentView.getParent() != null) {
                    if (this.mContentView.getParent() instanceof ViewGroup) {
                        ((ViewGroup) this.mContentView.getParent()).removeView(this.mContentView);
                        linearLayout.addView(this.mContentView);
                    }
                } else {
                    linearLayout.addView(this.mContentView);
                }
            } else {
                if (this.useNoTipAgainStyle) {
                    isShowTitleAndMessage = createContentViewWithNoTipAgain();
                } else {
                    isShowTitleAndMessage = isShowTitleAndMessage();
                }
                if (isShowTitleAndMessage != null) {
                    linearLayout.removeAllViews();
                    if (isShowTitleAndMessage.getParent() != null) {
                        if (isShowTitleAndMessage.getParent() instanceof ViewGroup) {
                            ((ViewGroup) isShowTitleAndMessage.getParent()).removeView(isShowTitleAndMessage);
                            linearLayout.addView(isShowTitleAndMessage);
                        }
                    } else {
                        linearLayout.addView(isShowTitleAndMessage);
                    }
                }
            }
            autoChangeSkinType(l9Var);
            if (this.mCloseButtonListener != null) {
                this.mCloseButton.setVisibility(0);
                this.mCloseButton.setOnClickListener(new d(this, this, this.mCloseButtonListener));
                if (isAutoNight()) {
                    i = TbadkCoreApplication.getInst().getSkinType();
                } else {
                    i = 0;
                }
                if (this.dialogSize == 10) {
                    SkinManager.setBackgroundResource(this.mCloseButton, R.drawable.icon_mask_pop_close);
                } else {
                    SkinManager.setBackgroundResource(this.mCloseButton, R.drawable.icon_popup_close_n, i);
                }
            }
            if (this.mButtonTextColorId != -1) {
                TextView textView4 = this.yesButton;
                if (textView4 != null) {
                    s75.d(textView4).A(this.mButtonTextColorId);
                }
                TextView textView5 = this.noButton;
                if (textView5 != null) {
                    s75.d(textView5).A(this.mButtonTextColorId);
                }
            }
            if (this.mNegativeTextColorId != -1 && (textView3 = this.noButton) != null) {
                s75.d(textView3).A(this.mNegativeTextColorId);
            }
            if (!TextUtils.isEmpty(this.mPositiveButtonTip) && (textView2 = this.yesButton) != null) {
                textView2.setText(this.mPositiveButtonTip);
                this.yesButton.setTag(this.yesTag);
                e eVar = this.mPositiveButtonListener;
                if (eVar != null) {
                    this.yesButton.setOnClickListener(new d(this, this, eVar));
                }
                z = true;
            } else {
                z = false;
            }
            if (!TextUtils.isEmpty(this.mNegativeButtonTip) && (textView = this.noButton) != null) {
                textView.setText(this.mNegativeButtonTip);
                e eVar2 = this.mNegativeButtonListener;
                if (eVar2 != null) {
                    this.noButton.setOnClickListener(new d(this, this, eVar2));
                }
            } else {
                z2 = false;
            }
            mouldButtons(z, z2);
            return this;
        }
        return (g55) invokeL.objValue;
    }

    public View createContentViewWithNoTipAgain() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            View inflate = LayoutInflater.from(this.mActivity).inflate(R.layout.dialog_content_with_no_tip_again, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f09250e);
            this.titleTextView = textView;
            textView.setText(this.mTitle);
            TextView textView2 = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091150);
            this.introTextView = textView2;
            textView2.setText(this.mMessage);
            this.noTipAgain = (TextView) inflate.findViewById(R.id.no_tip_again_text);
            this.noTipAgainCheckBox = (ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f0906d8);
            setCheckBoxDrawable();
            this.noTipAgainCheckBox.setOnClickListener(new a(this));
            return inflate;
        }
        return (View) invokeV.objValue;
    }

    public int getDialogMargin() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            int i2 = this.dialogSize;
            if (i2 == 0) {
                i = R.dimen.obfuscated_res_0x7f07041c;
            } else if (i2 == 1) {
                i = R.dimen.obfuscated_res_0x7f070225;
            } else if (i2 != 2 && i2 != 6) {
                if (i2 == 3) {
                    i = R.dimen.tbds45;
                } else if (i2 != 4 && i2 != 5) {
                    if (i2 == 7) {
                        i = R.dimen.tbds206;
                    } else if (i2 != 8 && i2 != 9 && i2 != 10) {
                        i = R.dimen.tbds0;
                    } else {
                        i = R.dimen.tbds120;
                    }
                } else {
                    i = R.dimen.tbds50;
                }
            } else {
                i = R.dimen.tbds44;
            }
            return xi.g(this.mActivity, i);
        }
        return invokeV.intValue;
    }

    public View isShowTitleAndMessage() {
        InterceptResult invokeV;
        LinearLayout linearLayout;
        TextView textView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            boolean z = !StringUtils.isNull(this.mTitle);
            boolean z2 = !StringUtils.isNull(this.mMessage);
            TextView textView2 = null;
            if (!z && !z2) {
                return null;
            }
            if (z && z2) {
                linearLayout = (LinearLayout) LayoutInflater.from(this.mActivity).inflate(R.layout.bdalert_two_message_view, (ViewGroup) null);
                textView2 = (TextView) linearLayout.findViewById(R.id.title_view);
                textView = (TextView) linearLayout.findViewById(R.id.message_view);
                if (this.isMessageShowCenter) {
                    textView2.setGravity(17);
                    textView.setGravity(17);
                }
                if (this.isTitleShowCenter) {
                    textView2.setGravity(17);
                }
                textView2.setText(this.mTitle);
                textView.setText(this.mMessage);
            } else {
                LinearLayout linearLayout2 = (LinearLayout) LayoutInflater.from(this.mActivity).inflate(R.layout.bdalert_one_message_view, (ViewGroup) null);
                TextView textView3 = (TextView) linearLayout2.findViewById(R.id.message_view);
                if (z) {
                    textView3.setText(this.mTitle);
                } else {
                    if (this.isOnlyMessageShowCenter) {
                        textView3.setGravity(17);
                    }
                    textView3.setText(this.mMessage);
                }
                linearLayout = linearLayout2;
                textView = textView3;
            }
            SkinManager.setViewTextColor(textView2, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0105);
            return linearLayout;
        }
        return (View) invokeV.objValue;
    }

    public g55 setNegativeButton(String str, e eVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048604, this, str, eVar)) == null) {
            this.mNegativeButtonTip = str;
            this.mNegativeButtonListener = eVar;
            return this;
        }
        return (g55) invokeLL.objValue;
    }

    public g55 setPositiveButton(String str, e eVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048611, this, str, eVar)) == null) {
            this.mPositiveButtonTip = str;
            this.mPositiveButtonListener = eVar;
            return this;
        }
        return (g55) invokeLL.objValue;
    }

    public g55 setTitle(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048613, this, str)) == null) {
            this.mTitle = str;
            return this;
        }
        return (g55) invokeL.objValue;
    }
}
