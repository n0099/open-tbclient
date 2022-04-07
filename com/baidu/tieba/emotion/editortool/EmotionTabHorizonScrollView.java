package com.baidu.tieba.emotion.editortool;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.EmotionCenterActivityConfig;
import com.baidu.tbadk.core.atomData.EmotionPackageDetailActivityConfig;
import com.baidu.tbadk.core.atomData.FaceShopActivityConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.HorizontalCustomScrollView;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.emotion.editortool.EmotionTabWidgetView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.a15;
import com.repackage.i05;
import com.repackage.mg;
import com.repackage.mi;
import com.repackage.oi;
import java.util.ArrayList;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes3.dex */
public class EmotionTabHorizonScrollView extends HorizontalCustomScrollView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public EmotionLinearLayout b;
    public int c;
    public ArrayList<a15> d;
    public EmotionTabWidgetView.c e;
    public int f;
    public int g;
    public int h;
    public LinearLayout i;
    public ImageView j;
    public TextView k;
    public LinearLayout.LayoutParams l;
    public boolean m;
    public View n;
    public TbImageView o;
    public boolean p;
    public EditorTools q;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EmotionTabHorizonScrollView a;

        public a(EmotionTabHorizonScrollView emotionTabHorizonScrollView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emotionTabHorizonScrollView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = emotionTabHorizonScrollView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                BdToast.c(this.a.getContext(), this.a.getContext().getResources().getString(R.string.obfuscated_res_0x7f0f052e)).q();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EmotionTabHorizonScrollView a;

        public b(EmotionTabHorizonScrollView emotionTabHorizonScrollView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emotionTabHorizonScrollView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = emotionTabHorizonScrollView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.k != null) {
                    this.a.b.setNewViewVisible(false);
                }
                TbadkCoreApplication.getInst().setFaceShopVersion(TbadkCoreApplication.getInst().getTempFaceShopVersion());
                TbadkCoreApplication.getInst().setFaceShopNew(false);
                if (this.a.q != null) {
                    this.a.q.A(new i05(2, 5, null));
                }
                if (mi.z()) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EmotionCenterActivityConfig(this.a.getContext())));
                } else {
                    oi.M(this.a.getContext(), R.string.obfuscated_res_0x7f0f0c18);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EmotionTabHorizonScrollView a;

        public c(EmotionTabHorizonScrollView emotionTabHorizonScrollView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emotionTabHorizonScrollView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = emotionTabHorizonScrollView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                BdToast.c(this.a.getContext(), this.a.getContext().getResources().getString(R.string.obfuscated_res_0x7f0f052e)).q();
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TbImageView a;
        public View b;
        public a15 c;

        public d() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ d(a aVar) {
            this();
        }
    }

    /* loaded from: classes3.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final String a;
        public final /* synthetic */ EmotionTabHorizonScrollView b;

        public /* synthetic */ e(EmotionTabHorizonScrollView emotionTabHorizonScrollView, String str, a aVar) {
            this(emotionTabHorizonScrollView, str);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || mg.e(this.a, 0) <= 0) {
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EmotionPackageDetailActivityConfig(this.b.getContext(), mg.e(this.a, 0), 0)));
        }

        public e(EmotionTabHorizonScrollView emotionTabHorizonScrollView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emotionTabHorizonScrollView, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = emotionTabHorizonScrollView;
            this.a = str;
        }
    }

    /* loaded from: classes3.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int a;
        public final /* synthetic */ EmotionTabHorizonScrollView b;

        public /* synthetic */ f(EmotionTabHorizonScrollView emotionTabHorizonScrollView, int i, a aVar) {
            this(emotionTabHorizonScrollView, i);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            TbImageView tbImageView;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (!this.b.q.n(5).b() && (((a15) this.b.d.get(this.a)).h() == EmotionGroupType.USER_COLLECT || ((a15) this.b.d.get(this.a)).h() == EmotionGroupType.BIG_EMOTION)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2921500, Boolean.TRUE));
                    return;
                }
                if ((view2 instanceof TbImageView) && (tbImageView = (TbImageView) view2) != this.b.o) {
                    tbImageView.setForegroundColor(SkinManager.getColor(R.color.common_color_10022));
                    if (this.b.o != null) {
                        if (!this.b.p) {
                            this.b.o.setForegroundColor(SkinManager.getColor(R.color.common_color_10287));
                        } else {
                            this.b.o.setForegroundColor(this.b.getResources().getColor(R.color.common_color_10287));
                        }
                    }
                    this.b.o = tbImageView;
                }
                this.b.setCurrentTab(this.a);
                this.b.e.a(this.a);
            }
        }

        public f(EmotionTabHorizonScrollView emotionTabHorizonScrollView, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emotionTabHorizonScrollView, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = emotionTabHorizonScrollView;
            this.a = i;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
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
        this.c = -1;
        this.m = true;
        m();
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ImageView imageView = new ImageView(getContext());
            this.j = imageView;
            imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            ImageView imageView2 = this.j;
            int i = this.g;
            int i2 = this.f;
            imageView2.setPadding(i, i2, i, i2);
            LinearLayout linearLayout = new LinearLayout(getContext());
            this.i = linearLayout;
            linearLayout.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f05e5));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
            layoutParams.weight = 1.0f;
            this.j.setLayoutParams(layoutParams);
            SkinManager.setImageResource(this.j, R.drawable.face_store, this.h);
            this.i.addView(this.j);
            View view2 = new View(getContext());
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701d4), -1);
            layoutParams2.gravity = 5;
            layoutParams2.weight = 0.0f;
            view2.setLayoutParams(layoutParams2);
            SkinManager.setBackgroundColor(view2, R.color.common_color_10288, this.h);
            TextView textView = new TextView(getContext());
            this.k = textView;
            textView.setGravity(17);
            this.k.setTextSize(10.0f);
            this.k.setText("N");
            this.k.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            this.b.addView(this.i, new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070236), -1));
            this.b.setNewView(this.k);
            boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(FaceShopActivityConfig.class);
            if (TbadkCoreApplication.getInst().isFaceShopNew() && appResponseToIntentClass) {
                this.b.setNewViewVisible(true);
            } else {
                this.b.setNewViewVisible(false);
            }
            this.i.setOnClickListener(new b(this));
            this.n = new View(getContext());
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -1);
            layoutParams3.weight = 1.0f;
            this.n.setLayoutParams(layoutParams3);
            this.b.addView(this.n);
            if (appResponseToIntentClass) {
                return;
            }
            this.i.setVisibility(8);
        }
    }

    public void j(a15 a15Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, a15Var) == null) {
            k(a15Var);
        }
    }

    public final TbImageView k(a15 a15Var) {
        InterceptResult invokeL;
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, a15Var)) == null) {
            TbImageView tbImageView = new TbImageView(getContext());
            d dVar = new d(null);
            dVar.c = a15Var;
            tbImageView.setAutoChangeStyle(false);
            dVar.a = tbImageView;
            if (a15Var.h() == EmotionGroupType.SINGLE_FORUM) {
                RelativeLayout relativeLayout = new RelativeLayout(getContext());
                tbImageView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
                relativeLayout.addView(tbImageView);
                int i3 = this.g;
                int i4 = this.f;
                tbImageView.setPadding(i3, i4, i3, i4);
                ImageView imageView = new ImageView(getContext());
                SkinManager.setImageResource(imageView, R.drawable.icon_emotion_recommend);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.addRule(11);
                layoutParams.addRule(12);
                layoutParams.setMargins(0, 0, oi.f(getContext(), R.dimen.obfuscated_res_0x7f07023e), oi.f(getContext(), R.dimen.obfuscated_res_0x7f070234));
                relativeLayout.addView(imageView, layoutParams);
                View view2 = new View(getContext());
                new RelativeLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701d4), -1).addRule(11);
                relativeLayout.setClickable(true);
                relativeLayout.setFocusable(true);
                relativeLayout.setTag(dVar);
                this.b.addView(relativeLayout, this.b.getChildCount() - 1, this.l);
                if (a15Var.e() != null) {
                    a15Var.e().h(tbImageView);
                }
                tbImageView.setOnClickListener(new e(this, a15Var.f(), null));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f04fd) + a15Var.f());
                if (!this.p && ((i2 = this.h) == 1 || i2 == 4)) {
                    view2.setBackgroundColor(SkinManager.getColor(R.color.common_color_10288));
                    tbImageView.setForegroundColor(SkinManager.getColor(R.color.common_color_10287));
                } else {
                    view2.setBackgroundColor(getResources().getColor(R.color.common_color_10288));
                    tbImageView.setForegroundColor(getResources().getColor(R.color.common_color_10287));
                }
                if (this.o == null) {
                    this.o = tbImageView;
                    tbImageView.setForegroundColor(SkinManager.getColor(R.color.common_color_10022));
                }
                SkinManager.setBackgroundResource(relativeLayout, R.drawable.bg_emotion_tab_horizonscrollview, this.h);
            } else {
                LinearLayout linearLayout = new LinearLayout(getContext());
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -1);
                layoutParams2.weight = 1.0f;
                tbImageView.setLayoutParams(layoutParams2);
                linearLayout.addView(tbImageView);
                int i5 = this.g;
                int i6 = this.f;
                tbImageView.setPadding(i5, i6, i5, i6);
                View view3 = new View(getContext());
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701d4), -1);
                layoutParams3.gravity = 5;
                layoutParams3.weight = 0.0f;
                linearLayout.setClickable(true);
                linearLayout.setFocusable(true);
                linearLayout.setTag(dVar);
                this.b.addView(linearLayout, this.b.getChildCount() - 1, this.l);
                EmotionGroupType h = a15Var.h();
                if (h == EmotionGroupType.LOCAL) {
                    if (a15Var.d() != null) {
                        a15Var.d().h(tbImageView);
                    }
                    tbImageView.setOnClickListener(new f(this, this.b.getChildCount() - 3, null));
                    tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0a3b));
                } else if (h == EmotionGroupType.PROMOTION) {
                    if (a15Var.e() != null) {
                        a15Var.e().h(tbImageView);
                    }
                    tbImageView.setOnClickListener(new e(this, a15Var.f(), null));
                    tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f04fc) + a15Var.f());
                } else if (h == EmotionGroupType.BIG_EMOTION) {
                    if (this.m) {
                        if (a15Var.d() != null) {
                            a15Var.d().h(tbImageView);
                        }
                        tbImageView.setOnClickListener(new f(this, this.b.getChildCount() - 3, null));
                    } else {
                        if (a15Var.e() != null) {
                            a15Var.e().h(tbImageView);
                        }
                        tbImageView.setOnClickListener(new a(this));
                    }
                    tbImageView.setContentDescription(a15Var.g());
                } else if (h == EmotionGroupType.USER_COLLECT) {
                    if (a15Var.e() != null) {
                        a15Var.e().h(tbImageView);
                    }
                    tbImageView.setOnClickListener(new f(this, this.b.getChildCount() - 3, null));
                    tbImageView.setContentDescription("");
                } else if (h == EmotionGroupType.SINGLE_FORUM) {
                    if (a15Var.e() != null) {
                        a15Var.e().h(tbImageView);
                    }
                    tbImageView.setOnClickListener(new e(this, a15Var.f(), null));
                    tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f04fd) + a15Var.f());
                }
                if (!this.p && ((i = this.h) == 1 || i == 4)) {
                    view3.setBackgroundColor(SkinManager.getColor(R.color.common_color_10288));
                    tbImageView.setForegroundColor(SkinManager.getColor(R.color.common_color_10287));
                } else {
                    view3.setBackgroundColor(getResources().getColor(R.color.common_color_10288));
                    tbImageView.setForegroundColor(getResources().getColor(R.color.common_color_10287));
                }
                if (this.o == null) {
                    this.o = tbImageView;
                    tbImageView.setForegroundColor(SkinManager.getColor(R.color.common_color_10022));
                }
                SkinManager.setBackgroundResource(linearLayout, R.drawable.bg_emotion_tab_horizonscrollview, this.h);
            }
            return tbImageView;
        }
        return (TbImageView) invokeL.objValue;
    }

    public final boolean l(a15 a15Var, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048579, this, a15Var, z)) == null) {
            if (a15Var == null) {
                return true;
            }
            if (z) {
                return false;
            }
            return a15Var.h() == EmotionGroupType.BIG_EMOTION || a15Var.h() == EmotionGroupType.PROMOTION;
        }
        return invokeLZ.booleanValue;
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            removeAllViews();
            setFillViewport(true);
            setHorizontalScrollBarEnabled(false);
            EmotionLinearLayout emotionLinearLayout = new EmotionLinearLayout(getContext());
            this.b = emotionLinearLayout;
            emotionLinearLayout.setOrientation(0);
            this.b.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            this.b.setBaselineAligned(false);
            addView(this.b);
            this.f = getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070305);
            this.g = getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070234);
            this.l = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070240), -1);
            this.b.setPadding(0, 0, 0, 0);
            i();
        }
    }

    public void n(int i) {
        int color;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.h = i;
            ImageView imageView = this.j;
            if (imageView != null) {
                SkinManager.setImageResource(imageView, R.drawable.face_store, i);
            }
            LinearLayout linearLayout = this.i;
            if (linearLayout != null) {
                SkinManager.setBackgroundResource(linearLayout, R.drawable.bg_emotion_tab_horizonscrollview, i);
                if (this.i.getChildCount() > 0) {
                    SkinManager.setBackgroundColor(this.i.getChildAt(1), R.color.common_color_10288, i);
                }
            }
            View view2 = this.n;
            if (view2 != null) {
                SkinManager.setBackgroundResource(view2, R.drawable.bg_emotion_tab_horizonscrollview, i);
            }
            TextView textView = this.k;
            if (textView != null) {
                SkinManager.setBackgroundResource(textView, R.drawable.icon_news_head_prompt_one, i);
                SkinManager.setViewTextColor(this.k, R.color.CAM_X0101, 1, i);
            }
            int childCount = this.b.getChildCount();
            for (int i2 = 1; i2 < childCount; i2++) {
                View childAt = this.b.getChildAt(i2);
                if (childAt != null) {
                    SkinManager.setBackgroundResource(childAt, R.drawable.bg_emotion_tab_horizonscrollview, i);
                    d dVar = (d) childAt.getTag();
                    if (dVar != null) {
                        if (dVar.a != null) {
                            if (i == 0) {
                                color = getResources().getColor(R.color.common_color_10287);
                            } else {
                                color = SkinManager.getColor(R.color.common_color_10287);
                            }
                            dVar.a.setForegroundColor(color);
                        }
                        View view3 = dVar.b;
                        if (view3 != null) {
                            SkinManager.setBackgroundColor(view3, R.color.common_color_10288, i);
                        }
                    }
                }
            }
            TbImageView tbImageView = this.o;
            if (tbImageView != null) {
                tbImageView.setForegroundColor(SkinManager.getColor(R.color.common_color_10022));
                if (this.o.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.o.getParent()).setSelected(true);
                }
            }
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.c = -1;
            this.b.removeAllViews();
            i();
            n(this.h);
        }
    }

    public void setCurrentTab(int i) {
        int i2;
        int color;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048583, this, i) == null) || i == (i2 = this.c)) {
            return;
        }
        if (i2 != -1) {
            LinearLayout linearLayout = (LinearLayout) this.b.getChildAt(i2 + 1);
            TbImageView tbImageView = (TbImageView) linearLayout.getChildAt(0);
            if (tbImageView != null) {
                if (this.h == 0) {
                    color = getResources().getColor(R.color.common_color_10287);
                } else {
                    color = SkinManager.getColor(R.color.common_color_10287);
                }
                tbImageView.setForegroundColor(color);
            }
            linearLayout.setSelected(false);
        }
        this.c = i;
        LinearLayout linearLayout2 = (LinearLayout) this.b.getChildAt(i + 1);
        linearLayout2.setSelected(true);
        int[] iArr = new int[2];
        linearLayout2.getLocationOnScreen(iArr);
        int i3 = iArr[0];
        int width = linearLayout2.getWidth() + i3;
        if (i3 < 0) {
            scrollBy(i3, 0);
        }
        if (getParent() instanceof ViewGroup) {
            View findViewById = ((ViewGroup) getParent()).findViewById(R.id.obfuscated_res_0x7f090962);
            int width2 = getResources().getDisplayMetrics().widthPixels - ((findViewById == null || findViewById.getVisibility() != 0) ? 0 : findViewById.getWidth() + 0);
            if (width > width2) {
                scrollBy(width - width2, 0);
            }
        }
        TbImageView tbImageView2 = (TbImageView) linearLayout2.getChildAt(0);
        a15 a15Var = this.d.get(this.c);
        if (a15Var.d() != null) {
            a15Var.d().h(tbImageView2);
        }
        if (tbImageView2 != null) {
            tbImageView2.setForegroundColor(SkinManager.getColor(R.color.common_color_10022));
            this.o = tbImageView2;
        }
    }

    public void setDatas(ArrayList<a15> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, arrayList) == null) {
            this.d = arrayList;
        }
    }

    public void setEditorTools(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, editorTools) == null) {
            this.q = editorTools;
        }
    }

    public void setFrom(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
        }
    }

    public void setIsInChat(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.p = z;
        }
    }

    public void setOnTabSelectedListener(EmotionTabWidgetView.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, cVar) == null) {
            this.e = cVar;
        }
    }

    public void setTabWidgetBigEmontionVisibility(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(FaceShopActivityConfig.class);
            int childCount = this.b.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.b.getChildAt(i);
                if (childAt != null) {
                    if (l(childAt.getTag() instanceof d ? ((d) childAt.getTag()).c : null, z)) {
                        childAt.setVisibility(8);
                    } else {
                        childAt.setVisibility(0);
                    }
                }
            }
            if (z && appResponseToIntentClass) {
                this.i.setVisibility(0);
            } else {
                this.i.setVisibility(8);
            }
        }
    }

    public void setTabWidgetVisibility(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            this.m = z;
            int i2 = i + 1;
            int childCount = this.b.getChildCount();
            int i3 = i2 - 1;
            a15 a15Var = this.d.get(i3);
            if (i2 < childCount) {
                if (a15Var.h() == EmotionGroupType.BIG_EMOTION || a15Var.h() == EmotionGroupType.USER_COLLECT) {
                    TbImageView tbImageView = (TbImageView) ((LinearLayout) this.b.getChildAt(i2)).getChildAt(0);
                    if (!this.m) {
                        tbImageView.setOnClickListener(new c(this));
                        if (a15Var.e() != null) {
                            a15Var.e().h(tbImageView);
                            return;
                        }
                        return;
                    }
                    tbImageView.setOnClickListener(new f(this, i3, null));
                    if (a15Var.d() != null) {
                        a15Var.d().h(tbImageView);
                    }
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
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
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = -1;
        this.m = true;
        m();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmotionTabHorizonScrollView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
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
        this.c = -1;
        this.m = true;
        m();
    }
}
