package com.baidu.tieba.NEGFeedBack;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.OvershootInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.NegativeFeedBackData;
import com.baidu.tbadk.core.util.FullBrowseHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.R;
import com.baidu.tieba.l9;
import com.baidu.tieba.v36;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class NEGFeedBackView extends AppCompatImageView {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String KEY_TID = "tid";
    public static final int MIN_CLICK_ENABLE_DELAY = 500;
    public static final int NEG_FEEDBACK_LIST_ITEM_DYNAMIC_TIME = 300;
    public transient /* synthetic */ FieldHolder $fh;
    public RotateAnimation mACRotate;
    public RotateAnimation mCWRotate;
    public Context mContext;
    public long mLastClickTime;
    public View.OnClickListener mOnPopupWindowClickListener;
    public int mPaddingLeft;
    public int mPaddingRight;
    public int mPaddingTop;
    public v36 mViewController;
    public int mWebPColorId;
    public int mWebPResId;

    /* loaded from: classes5.dex */
    public interface NEGFeedbackEventCallback {
        void onCheckedChanged(NegativeFeedBackData negativeFeedBackData, CompoundButton compoundButton, boolean z);

        void onNEGFeedbackConfirm(ArrayList<Integer> arrayList, String str, NegativeFeedBackData negativeFeedBackData);

        void onNEGFeedbackWindowShow(NegativeFeedBackData negativeFeedBackData);
    }

    public void setACRotateAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
        }
    }

    public void setCWRotateAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
        }
    }

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NEGFeedBackView a;

        public a(NEGFeedBackView nEGFeedBackView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nEGFeedBackView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nEGFeedBackView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || FullBrowseHelper.checkAndShowFullBrowseModeDialog(l9.a(this.a.getContext()))) {
                return;
            }
            this.a.dismissPopupWindow();
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.a.mLastClickTime > 500) {
                this.a.showPopupWindow(view2);
            }
            this.a.mLastClickTime = currentTimeMillis;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NEGFeedBackView(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mLastClickTime = 0L;
        this.mWebPResId = R.drawable.icon_pure_card_more22;
        this.mWebPColorId = R.color.CAM_X0111;
        this.mOnPopupWindowClickListener = new a(this);
        this.mContext = tbPageContext.getPageActivity();
        init(tbPageContext);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NEGFeedBackView(TbPageContext tbPageContext, AttributeSet attributeSet) {
        super(tbPageContext.getPageActivity(), attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mLastClickTime = 0L;
        this.mWebPResId = R.drawable.icon_pure_card_more22;
        this.mWebPColorId = R.color.CAM_X0111;
        this.mOnPopupWindowClickListener = new a(this);
        this.mContext = tbPageContext.getPageActivity();
        init(tbPageContext);
    }

    private void init(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, this, tbPageContext) == null) {
            this.mViewController = new v36(tbPageContext, this);
            setOnClickListener(this.mOnPopupWindowClickListener);
            setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            onChangeSkinType();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showPopupWindow(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, this, view2) == null) {
            this.mViewController.A(view2);
        }
    }

    public void setAutoProcess(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.mViewController.t(z);
        }
    }

    public void setData(NegativeFeedBackData negativeFeedBackData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, negativeFeedBackData) == null) {
            this.mViewController.u(negativeFeedBackData);
        }
    }

    public void setDefaultReasonArray(String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, strArr) == null) {
            this.mViewController.v(strArr);
        }
    }

    public void setEventCallback(NEGFeedbackEventCallback nEGFeedbackEventCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, nEGFeedbackEventCallback) == null) {
            this.mViewController.w(nEGFeedbackEventCallback);
        }
    }

    public void setFirstRowSingleColumn(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.mViewController.x(z);
        }
    }

    public void setHeadText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            this.mViewController.y(str);
        }
    }

    public void setLeftPadding(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
            this.mPaddingLeft = i;
            setPadding(i, this.mPaddingTop, this.mPaddingRight, 0);
        }
    }

    public void setRightPadding(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i) == null) {
            this.mPaddingRight = i;
            setPadding(this.mPaddingLeft, this.mPaddingTop, i, 0);
        }
    }

    public void setTopPadding(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i) == null) {
            this.mPaddingTop = i;
            setPadding(this.mPaddingLeft, i, this.mPaddingRight, 0);
        }
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, bdUniqueId) == null) {
            this.mViewController.z(bdUniqueId);
        }
    }

    public void showWithNone(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
            this.mViewController.B(z);
        }
    }

    public void setWebPResId(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048596, this, i, i2) == null) {
            this.mWebPResId = i;
            this.mWebPColorId = i2;
            setImageDrawable(WebPManager.getPureDrawable(i, SkinManager.getColor(i2), WebPManager.ResourceStateType.NORMAL_PRESS));
        }
    }

    private void setRotateAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, this) == null) {
            this.mCWRotate = new RotateAnimation(0.0f, 135.0f, 1, 0.5f, 1, 0.5f);
            OvershootInterpolator overshootInterpolator = new OvershootInterpolator();
            this.mCWRotate.setInterpolator(overshootInterpolator);
            this.mCWRotate.setDuration(250L);
            this.mCWRotate.setFillAfter(true);
            RotateAnimation rotateAnimation = new RotateAnimation(135.0f, 0.0f, 1, 0.5f, 1, 0.5f);
            this.mACRotate = rotateAnimation;
            rotateAnimation.setInterpolator(overshootInterpolator);
            this.mACRotate.setDuration(250L);
            this.mACRotate.setFillAfter(true);
        }
    }

    public void attachToViewUpperRightConner(ViewGroup viewGroup, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048576, this, viewGroup, i, i2) == null) {
            setPadding(0, i2, i2, 0);
            if (viewGroup instanceof RelativeLayout) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.addRule(11);
                layoutParams.addRule(15);
                viewGroup.addView(this, layoutParams);
            } else if (viewGroup instanceof FrameLayout) {
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(i, i);
                layoutParams2.gravity = 53;
                viewGroup.addView(this, layoutParams2);
            }
        }
    }

    public void attachToViewUpperRightConner(ViewGroup viewGroup, int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup, i, i2, i3) == null) && (viewGroup instanceof FrameLayout)) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i, i);
            layoutParams.rightMargin = i2;
            layoutParams.bottomMargin = i3;
            layoutParams.gravity = 85;
            viewGroup.addView(this, layoutParams);
        }
    }

    public void attachToViewUpperRightConnerFromFrsLive(ViewGroup viewGroup, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(Constants.METHOD_SEND_USER_MSG, this, viewGroup, i, i2) == null) {
            int dimens = BdUtilHelper.getDimens(this.mContext, R.dimen.tbds24);
            setPadding(i2, 0, i2, 0);
            if (viewGroup instanceof RelativeLayout) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, i);
                layoutParams.addRule(11);
                layoutParams.addRule(15);
                layoutParams.rightMargin = dimens;
                viewGroup.addView(this, layoutParams);
            } else if (viewGroup instanceof FrameLayout) {
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(i, i);
                layoutParams2.gravity = 53;
                viewGroup.addView(this, layoutParams2);
            }
        }
    }

    public void dismissPopupWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.mViewController.k();
        }
    }

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            setImageDrawable(WebPManager.getPureDrawable(this.mWebPResId, SkinManager.getColor(this.mWebPColorId), WebPManager.ResourceStateType.NORMAL_PRESS));
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onDetachedFromWindow();
            this.mViewController.q();
        }
    }

    public void resetWebPResId() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.mWebPResId = R.drawable.icon_pure_card_more22;
            this.mWebPColorId = R.color.CAM_X0111;
            setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_card_more22, SkinManager.getColor(R.color.CAM_X0111), WebPManager.ResourceStateType.NORMAL_PRESS));
        }
    }

    public void setDefaultLayout() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            onChangeSkinType();
        }
    }
}
