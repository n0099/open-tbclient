package com.baidu.tbadk.loading;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.ContinuousAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.im5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class LoadingView extends im5 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long DELAY_TIME = 200;
    public static final int FIRST_STAGE_FRAME = 6;
    public static final int TOTAL_FRAME = 24;
    public transient /* synthetic */ FieldHolder $fh;
    public final int arrayLength;
    public int currentIndex;
    public boolean hasFirstPeriodAnimFinished;
    public final Animator.AnimatorListener loadViewAnimListener;
    public ValueAnimator.AnimatorUpdateListener loadViewUpdateListener;
    public ImageView loadingDefault;
    public TextView loadingTextView;
    public ContinuousAnimationView mLoadingView;
    public int mSkinType;
    public Runnable runnable;
    public String[] textArray;
    public TextView textView;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LoadingView a;

        public a(LoadingView loadingView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {loadingView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = loadingView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!this.a.isViewAttached()) {
                    TbadkCoreApplication.getInst().handler.removeCallbacks(this.a.runnable);
                    return;
                }
                this.a.textView.setText(this.a.textArray[this.a.getNextIndex()]);
                TbadkCoreApplication.getInst().handler.postDelayed(this.a.runnable, 200L);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LoadingView a;

        public b(LoadingView loadingView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {loadingView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = loadingView;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                if (animatedFraction > 0.0f) {
                    this.a.loadingDefault.setVisibility(8);
                }
                if (!this.a.hasFirstPeriodAnimFinished) {
                    this.a.mLoadingView.setAlpha(Math.min(1.0f, (animatedFraction * 24.0f) / 6.0f));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LoadingView a;

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
            }
        }

        public c(LoadingView loadingView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {loadingView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = loadingView;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) != null) {
                return;
            }
            this.a.hasFirstPeriodAnimFinished = true;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048579, this, animator) != null) {
                return;
            }
            this.a.hasFirstPeriodAnimFinished = false;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LoadingView(Context context) {
        this(context, 0);
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
                this((Context) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoadingView(Context context, int i) {
        super(LayoutInflater.from(context).inflate(R.layout.loading_view_layout, (ViewGroup) null));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((View) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.currentIndex = 0;
        this.mSkinType = -1;
        this.runnable = new a(this);
        this.loadViewUpdateListener = new b(this);
        this.loadViewAnimListener = new c(this);
        ContinuousAnimationView continuousAnimationView = (ContinuousAnimationView) this.attachedView.findViewById(R.id.common_loading_view);
        this.mLoadingView = continuousAnimationView;
        if (i > 0) {
            ViewGroup.LayoutParams layoutParams = continuousAnimationView.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i;
                this.mLoadingView.setLayoutParams(marginLayoutParams);
            }
        }
        SkinManager.setLottieAnimation(this.mLoadingView, R.raw.lottie_full_screen_refresh);
        this.mLoadingView.setMinAndMaxProgress(0.0f, 1.0f);
        this.mLoadingView.setRepeatMode(1);
        this.mLoadingView.addAnimatorUpdateListener(this.loadViewUpdateListener);
        this.mLoadingView.addAnimatorListener(this.loadViewAnimListener);
        this.mLoadingView.setSpeed(1.2f);
        this.textView = (TextView) this.attachedView.findViewById(R.id.loading_anim_ellipsis);
        this.loadingTextView = (TextView) this.attachedView.findViewById(R.id.loading_text);
        ImageView imageView = (ImageView) this.attachedView.findViewById(R.id.loading_default);
        this.loadingDefault = imageView;
        imageView.setImageResource(R.drawable.icon_loading_first_frame);
        String[] stringArray = context.getResources().getStringArray(R.array.loading_anim_text_array);
        this.textArray = stringArray;
        this.arrayLength = stringArray.length;
    }

    @Override // com.baidu.tieba.im5
    public void dettachView(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) {
            ContinuousAnimationView continuousAnimationView = this.mLoadingView;
            if (continuousAnimationView != null) {
                continuousAnimationView.cancelAnimation();
            }
            TbadkCoreApplication.getInst().handler.removeCallbacks(this.runnable);
            super.dettachView(view2);
        }
    }

    public void setBackground(int i) {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048585, this, i) == null) && (view2 = this.attachedView) != null) {
            view2.setBackgroundColor(i);
        }
    }

    public void setLoadingText(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            this.loadingTextView.setText(i);
        }
    }

    public void setSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            this.mSkinType = i;
        }
    }

    public void setTextColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            this.textView.setTextColor(i);
            this.loadingTextView.setTextColor(i);
        }
    }

    public void setTopMargin(int i) {
        ContinuousAnimationView continuousAnimationView;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048591, this, i) != null) || (continuousAnimationView = this.mLoadingView) == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = continuousAnimationView.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = i;
            this.mLoadingView.setLayoutParams(marginLayoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getNextIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) {
            int i = this.currentIndex + 1;
            this.currentIndex = i;
            if (i >= this.arrayLength) {
                this.currentIndex = 0;
            }
            return this.currentIndex;
        }
        return invokeV.intValue;
    }

    private void startLoadingAnimation() {
        ContinuousAnimationView continuousAnimationView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65547, this) == null) && (continuousAnimationView = this.mLoadingView) != null) {
            continuousAnimationView.playAnimation();
        }
    }

    private void stopLoadingAnimation() {
        ContinuousAnimationView continuousAnimationView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65548, this) == null) && (continuousAnimationView = this.mLoadingView) != null) {
            continuousAnimationView.pauseAnimation();
        }
    }

    public void cancelCenterVertical() {
        ContinuousAnimationView continuousAnimationView;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || (continuousAnimationView = this.mLoadingView) == null) {
            return;
        }
        ((RelativeLayout.LayoutParams) continuousAnimationView.getLayoutParams()).addRule(15, 0);
    }

    public View getAttachedView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.attachedView;
        }
        return (View) invokeV.objValue;
    }

    public TextView getLoadingTextView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.loadingTextView;
        }
        return (TextView) invokeV.objValue;
    }

    @Override // com.baidu.tieba.im5
    public void onViewDettached() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            release();
        }
    }

    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            stopLoadingAnimation();
            TbadkCoreApplication.getInst().handler.removeCallbacks(this.runnable);
        }
    }

    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (this.mSkinType == -1) {
                this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            }
            if (isViewAttached()) {
                SkinManager.setViewTextColor(this.textView, R.color.CAM_X0108, 1, this.mSkinType);
                SkinManager.setViewTextColor(this.loadingTextView, R.color.CAM_X0108, 1, this.mSkinType);
                startLoadingAnimation();
            }
        }
    }

    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            SkinManager.setViewTextColor(this.textView, R.color.CAM_X0108, 1, i);
            SkinManager.setViewTextColor(this.loadingTextView, R.color.CAM_X0108, 1, i);
            SkinManager.setLottieAnimation(this.mLoadingView, R.raw.lottie_full_screen_refresh);
            if (isViewAttached()) {
                startLoadingAnimation();
            }
            TbadkCoreApplication.getInst().handler.removeCallbacks(this.runnable);
            TbadkCoreApplication.getInst().handler.postDelayed(this.runnable, 200L);
            this.mSkinType = i;
        }
    }

    public void setBottomMargin(int i) {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048586, this, i) == null) && this.mLoadingView != null && (textView = this.loadingTextView) != null) {
            if (textView.getVisibility() == 8) {
                ViewGroup.LayoutParams layoutParams = this.mLoadingView.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    marginLayoutParams.bottomMargin = i;
                    this.mLoadingView.setLayoutParams(marginLayoutParams);
                    return;
                }
                return;
            }
            ViewGroup.LayoutParams layoutParams2 = this.loadingTextView.getLayoutParams();
            if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams2;
                marginLayoutParams2.bottomMargin = i;
                this.loadingTextView.setLayoutParams(marginLayoutParams2);
            }
        }
    }

    @Override // com.baidu.tieba.im5
    public void onViewAttached() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (this.mSkinType == -1) {
                this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            }
            SkinManager.setLottieAnimation(this.mLoadingView, R.raw.lottie_full_screen_refresh);
            startLoadingAnimation();
            SkinManager.setViewTextColor(this.textView, R.color.CAM_X0108, 1, this.mSkinType);
            SkinManager.setViewTextColor(this.loadingTextView, R.color.CAM_X0108, 1, this.mSkinType);
            this.textView.setText(this.textArray[0]);
            TbadkCoreApplication.getInst().handler.removeCallbacks(this.runnable);
            TbadkCoreApplication.getInst().handler.postDelayed(this.runnable, 200L);
            this.attachedView.setClickable(true);
        }
    }

    public void setLayoutMarginWithHeaderHeightAndPercent(int i, float f) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Integer.valueOf(i), Float.valueOf(f)}) == null) {
            if (i < 0) {
                i = 0;
            }
            int equipmentHeight = BdUtilHelper.getEquipmentHeight(TbadkCoreApplication.getInst());
            if (equipmentHeight <= 0) {
                i2 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds200);
            } else {
                i2 = (int) (equipmentHeight * f);
            }
            cancelCenterVertical();
            setTopMargin(i2 + i);
        }
    }
}
