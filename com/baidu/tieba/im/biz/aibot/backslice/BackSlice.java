package com.baidu.tieba.im.biz.aibot.backslice;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.renderscript.Allocation;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.module.imaibot.AibotArgs;
import com.baidu.tieba.R;
import com.baidu.tieba.im.base.core.slice.Slice;
import com.baidu.tieba.impersonal.databinding.BackSliceBinding;
import com.baidu.tieba.yq8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.WebChromeClient;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\u0011J\u0010\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J$\u0010\u0015\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0017J\u0010\u0010\u001c\u001a\u00020\u000f2\b\u0010\u001d\u001a\u0004\u0018\u00010\nJ\u0018\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\n2\u0006\u0010 \u001a\u00020!H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/baidu/tieba/im/biz/aibot/backslice/BackSlice;", "Lcom/baidu/tieba/im/base/core/slice/Slice;", "wrapper", "Lcom/baidu/tieba/im/biz/aibot/AibotChatPageWrapper;", WebChromeClient.KEY_ARG_ARRAY, "Lcom/baidu/tbadk/module/imaibot/AibotArgs;", "(Lcom/baidu/tieba/im/biz/aibot/AibotChatPageWrapper;Lcom/baidu/tbadk/module/imaibot/AibotArgs;)V", "rootView", "Lcom/baidu/tieba/impersonal/databinding/BackSliceBinding;", "getDstArea", "Landroid/graphics/Bitmap;", "bitmap", "view", "Landroid/view/View;", "hide", "", "isHide", "", "onChangeSkinType", WriteMulitImageActivityConfig.SKIN_TYPE, "", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "setBlurBg", "bg", "zoomImage", "srcBitmap", "scale", "", "im-personal_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class BackSlice extends Slice {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final yq8 j;
    public final AibotArgs k;
    public BackSliceBinding l;

    /* loaded from: classes6.dex */
    public static final class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BackSlice a;

        public a(BackSlice backSlice) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {backSlice};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = backSlice;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.j.G();
                this.a.f0();
            }
        }
    }

    public BackSlice(yq8 wrapper, AibotArgs aibotArgs) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {wrapper, aibotArgs};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(wrapper, "wrapper");
        this.j = wrapper;
        this.k = aibotArgs;
    }

    public final Bitmap e0(Bitmap bitmap, View view2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bitmap, view2)) == null) {
            Bitmap dstArea = Bitmap.createBitmap(view2.getMeasuredWidth(), view2.getMeasuredHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(dstArea);
            int[] iArr = new int[2];
            view2.getLocationOnScreen(iArr);
            canvas.translate(0.0f, -iArr[1]);
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
            Intrinsics.checkNotNullExpressionValue(dstArea, "dstArea");
            return dstArea;
        }
        return (Bitmap) invokeLL.objValue;
    }

    public final Bitmap i0(Bitmap bitmap, float f) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(1048581, this, bitmap, f)) == null) {
            Matrix matrix = new Matrix();
            matrix.postScale(f, f);
            Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            Intrinsics.checkNotNullExpressionValue(createBitmap, "createBitmap(srcBitmap, …ht.toInt(), matrix, true)");
            return createBitmap;
        }
        return (Bitmap) invokeLF.objValue;
    }

    @Override // com.baidu.tieba.im.base.core.slice.Slice
    @SuppressLint({"SetTextI18n"})
    public View U(LayoutInflater inflater, ViewGroup container, Bundle bundle) {
        InterceptResult invokeLLL;
        String str;
        Integer pageSource;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, inflater, container, bundle)) == null) {
            Intrinsics.checkNotNullParameter(inflater, "inflater");
            Intrinsics.checkNotNullParameter(container, "container");
            BackSliceBinding it = BackSliceBinding.c(inflater, container, false);
            Intrinsics.checkNotNullExpressionValue(it, "it");
            this.l = it;
            boolean z = true;
            it.c.setShowOval(true);
            it.c.setAutoChangeStyle(true);
            it.c.setShowInnerBorder(true);
            it.c.setStrokeWith(BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds2));
            it.c.setStrokeColorResId(R.color.CAM_X0614);
            it.c.setScaleType(ImageView.ScaleType.CENTER_CROP);
            it.c.setPlaceHolder(1);
            BarImageView barImageView = it.c;
            AibotArgs aibotArgs = this.k;
            String str2 = null;
            if (aibotArgs != null) {
                str = aibotArgs.getForumPortrait();
            } else {
                str = null;
            }
            barImageView.startLoad(str);
            TextView textView = it.b;
            StringBuilder sb = new StringBuilder();
            AibotArgs aibotArgs2 = this.k;
            if (aibotArgs2 != null) {
                str2 = aibotArgs2.getForumName();
            }
            sb.append(StringHelper.cutChineseAndEnglishWithEmoji(str2, 24, "...", true));
            sb.append((char) 21543);
            textView.setText(sb.toString());
            ConstraintLayout root = it.getRoot();
            root.setOnClickListener(new a(this));
            AibotArgs aibotArgs3 = this.k;
            if ((aibotArgs3 == null || (pageSource = aibotArgs3.getPageSource()) == null || pageSource.intValue() != 1) ? false : false) {
                root.setVisibility(0);
            } else {
                root.setVisibility(8);
            }
            return root;
        }
        return (View) invokeLLL.objValue;
    }

    public final void f0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            BackSliceBinding backSliceBinding = this.l;
            BackSliceBinding backSliceBinding2 = null;
            if (backSliceBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rootView");
                backSliceBinding = null;
            }
            backSliceBinding.getRoot().setVisibility(8);
            yq8 yq8Var = this.j;
            BackSliceBinding backSliceBinding3 = this.l;
            if (backSliceBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rootView");
            } else {
                backSliceBinding2 = backSliceBinding3;
            }
            yq8Var.R1(backSliceBinding2.getRoot().getHeight());
        }
    }

    public final boolean g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            BackSliceBinding backSliceBinding = this.l;
            if (backSliceBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rootView");
                backSliceBinding = null;
            }
            if (backSliceBinding.getRoot().getVisibility() == 8) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void h0(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048580, this, bitmap) != null) || bitmap == null) {
            return;
        }
        BackSliceBinding backSliceBinding = this.l;
        BackSliceBinding backSliceBinding2 = null;
        if (backSliceBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rootView");
            backSliceBinding = null;
        }
        ConstraintLayout root = backSliceBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "rootView.root");
        Bitmap i0 = i0(e0(bitmap, root), 1.0f);
        BackSliceBinding backSliceBinding3 = this.l;
        if (backSliceBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rootView");
            backSliceBinding3 = null;
        }
        RenderScript create = RenderScript.create(backSliceBinding3.getRoot().getContext());
        Allocation createFromBitmap = Allocation.createFromBitmap(create, i0);
        Intrinsics.checkNotNullExpressionValue(createFromBitmap, "createFromBitmap(rs, dstArea)");
        ScriptIntrinsicBlur create2 = ScriptIntrinsicBlur.create(create, createFromBitmap.getElement());
        create2.setInput(createFromBitmap);
        create2.setRadius(25.0f);
        create2.forEach(createFromBitmap);
        createFromBitmap.copyTo(i0);
        BackSliceBinding backSliceBinding4 = this.l;
        if (backSliceBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rootView");
            backSliceBinding4 = null;
        }
        ConstraintLayout root2 = backSliceBinding4.getRoot();
        BackSliceBinding backSliceBinding5 = this.l;
        if (backSliceBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rootView");
        } else {
            backSliceBinding2 = backSliceBinding5;
        }
        root2.setBackground(new BitmapDrawable(backSliceBinding2.getRoot().getContext().getResources(), i0));
    }

    @Override // com.baidu.tieba.im.base.core.slice.Slice
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            super.onChangeSkinType(i);
            BackSliceBinding backSliceBinding = this.l;
            BackSliceBinding backSliceBinding2 = null;
            if (backSliceBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rootView");
                backSliceBinding = null;
            }
            EMManager.from(backSliceBinding.b).setTextColor(R.color.CAM_X0618);
            BackSliceBinding backSliceBinding3 = this.l;
            if (backSliceBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rootView");
            } else {
                backSliceBinding2 = backSliceBinding3;
            }
            EMManager.from(backSliceBinding2.d).setCardType(1).setCorner(R.string.J_X18).setBackGroundColor(R.color.CAM_X0606);
        }
    }
}
