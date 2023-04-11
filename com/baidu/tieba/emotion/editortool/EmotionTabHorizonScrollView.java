package com.baidu.tieba.emotion.editortool;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
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
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.EmotionCenterActivityConfig;
import com.baidu.tbadk.core.atomData.EmotionPackageDetailActivityConfig;
import com.baidu.tbadk.core.atomData.NewFaceShopActivityConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.HorizontalCustomScrollView;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.emotion.editortool.EmotionTabWidgetView;
import com.baidu.tieba.gg;
import com.baidu.tieba.hd5;
import com.baidu.tieba.ii;
import com.baidu.tieba.p45;
import com.baidu.tieba.pc5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes4.dex */
public class EmotionTabHorizonScrollView extends HorizontalCustomScrollView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public EmotionLinearLayout b;
    public LinearLayout c;
    public ImageView d;
    public TextView e;
    public int f;
    public int g;
    public int h;
    public LinearLayout.LayoutParams i;
    public int j;
    public TbImageView k;
    public EmotionTabWidgetView.b l;
    public ArrayList<hd5> m;
    public boolean n;
    public View o;
    public EditorTools p;
    public ImageView q;
    public LinearLayout r;

    /* loaded from: classes4.dex */
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
                BdToast.b(this.a.getContext(), this.a.getContext().getResources().getString(R.string.emotion_cant_show)).o();
            }
        }
    }

    /* loaded from: classes4.dex */
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
                if (this.a.e != null) {
                    this.a.b.setNewViewVisible(false);
                }
                TbadkCoreApplication.getInst().setFaceShopVersion(TbadkCoreApplication.getInst().getTempFaceShopVersion());
                TbadkCoreApplication.getInst().setFaceShopNew(false);
                if (this.a.p != null) {
                    this.a.p.C(new pc5(2, 5, null));
                }
                if (BdNetTypeUtil.isNetWorkAvailable()) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EmotionCenterActivityConfig(this.a.getContext())));
                } else {
                    ii.P(this.a.getContext(), R.string.obfuscated_res_0x7f0f0d1b);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
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
                BdToast.b(this.a.getContext(), this.a.getContext().getResources().getString(R.string.emotion_cant_show)).o();
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TbImageView a;
        public View b;
        public hd5 c;

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

        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                this.c.p(i);
                this.c.e().h(this.a);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final String a;
        public final /* synthetic */ EmotionTabHorizonScrollView b;

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

        public /* synthetic */ e(EmotionTabHorizonScrollView emotionTabHorizonScrollView, String str, a aVar) {
            this(emotionTabHorizonScrollView, str);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && gg.e(this.a, 0) > 0) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EmotionPackageDetailActivityConfig(this.b.getContext(), gg.e(this.a, 0), 0)));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int a;
        public final /* synthetic */ EmotionTabHorizonScrollView b;

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

        public /* synthetic */ f(EmotionTabHorizonScrollView emotionTabHorizonScrollView, int i, a aVar) {
            this(emotionTabHorizonScrollView, i);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            TbImageView tbImageView;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (!this.b.p.p(5).b() && EmotionGroupType.isSendAsPic(((hd5) this.b.m.get(this.a)).h())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2921500, Boolean.TRUE));
                    return;
                }
                if (EmotionGroupType.USER_DIY.equals(((hd5) this.b.m.get(this.a)).h())) {
                    p45.m().A("key_diy_emotion_last_click_t", System.currentTimeMillis());
                    if (this.b.r != null && this.b.q != null) {
                        this.b.r.setVisibility(8);
                        this.b.q.setVisibility(8);
                        int n = p45.m().n("key_emotion_red_dot_disappear_c", 0);
                        int i = 3;
                        if (n <= 3) {
                            int i2 = n + 1;
                            int n2 = p45.m().n("key_emotion_red_dot_show_gap", 0);
                            if (n2 > 0) {
                                i = n2 * 2;
                            }
                            p45.m().z("key_emotion_red_dot_disappear_c", i2);
                            p45.m().z("key_emotion_red_dot_show_gap", i);
                        }
                    }
                }
                if ((view2 instanceof TbImageView) && (tbImageView = (TbImageView) view2) != this.b.k) {
                    tbImageView.setForegroundColor(SkinManager.getColor(R.color.common_color_10022));
                    if (this.b.k != null) {
                        this.b.k.setForegroundColor(SkinManager.getColor(R.color.common_color_10287));
                    }
                    this.b.k = tbImageView;
                }
                this.b.setCurrentTab(this.a);
                this.b.l.a(this.a);
            }
        }
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
        this.j = -1;
        this.n = true;
        n();
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
        this.j = -1;
        this.n = true;
        n();
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
        this.j = -1;
        this.n = true;
        n();
    }

    public void k(hd5 hd5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hd5Var) == null) {
            l(hd5Var);
        }
    }

    public void setDatas(ArrayList<hd5> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, arrayList) == null) {
            this.m = arrayList;
        }
    }

    public void setEditorTools(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, editorTools) == null) {
            this.p = editorTools;
        }
    }

    public void setOnTabSelectedListener(EmotionTabWidgetView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bVar) == null) {
            this.l = bVar;
        }
    }

    public final boolean m(hd5 hd5Var, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048579, this, hd5Var, z)) == null) {
            if (hd5Var == null) {
                return true;
            }
            if (!z) {
                if (hd5Var.h() == EmotionGroupType.BIG_EMOTION || hd5Var.h() == EmotionGroupType.PROMOTION) {
                    return true;
                }
                return false;
            }
            return false;
        }
        return invokeLZ.booleanValue;
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ImageView imageView = new ImageView(getContext());
            this.d = imageView;
            imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            ImageView imageView2 = this.d;
            int i = this.g;
            int i2 = this.f;
            imageView2.setPadding(i, i2, i, i2);
            LinearLayout linearLayout = new LinearLayout(getContext());
            this.c = linearLayout;
            linearLayout.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f064e));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
            layoutParams.weight = 1.0f;
            this.d.setLayoutParams(layoutParams);
            SkinManager.setImageResource(this.d, R.drawable.face_store, this.h);
            this.c.addView(this.d);
            TextView textView = new TextView(getContext());
            this.e = textView;
            textView.setGravity(17);
            this.e.setTextSize(10.0f);
            this.e.setText("N");
            this.e.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            this.b.addView(this.c, new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070234), -1));
            this.b.setNewView(this.e);
            boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(NewFaceShopActivityConfig.class);
            if (TbadkCoreApplication.getInst().isFaceShopNew() && appResponseToIntentClass) {
                this.b.setNewViewVisible(true);
            } else {
                this.b.setNewViewVisible(false);
            }
            this.c.setOnClickListener(new b(this));
            this.o = new View(getContext());
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -1);
            layoutParams2.weight = 1.0f;
            this.o.setLayoutParams(layoutParams2);
            this.b.addView(this.o);
            if (!appResponseToIntentClass) {
                this.c.setVisibility(8);
            }
        }
    }

    public final TbImageView l(hd5 hd5Var) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, hd5Var)) == null) {
            TbImageView tbImageView = new TbImageView(getContext());
            d dVar = new d(null);
            dVar.c = hd5Var;
            tbImageView.setAutoChangeStyle(false);
            dVar.a = tbImageView;
            if (hd5Var.h() == EmotionGroupType.SINGLE_FORUM) {
                RelativeLayout relativeLayout = new RelativeLayout(getContext());
                tbImageView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
                relativeLayout.addView(tbImageView);
                int i = this.g;
                int i2 = this.f;
                tbImageView.setPadding(i, i2, i, i2);
                ImageView imageView = new ImageView(getContext());
                SkinManager.setImageResource(imageView, R.drawable.icon_emotion_recommend);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.addRule(11);
                layoutParams.addRule(12);
                layoutParams.setMargins(0, 0, ii.g(getContext(), R.dimen.obfuscated_res_0x7f07023c), ii.g(getContext(), R.dimen.obfuscated_res_0x7f070231));
                relativeLayout.addView(imageView, layoutParams);
                relativeLayout.setClickable(true);
                relativeLayout.setFocusable(true);
                relativeLayout.setTag(dVar);
                this.b.addView(relativeLayout, this.b.getChildCount() - 1, this.i);
                if (hd5Var.e() != null) {
                    hd5Var.e().h(tbImageView);
                }
                tbImageView.setOnClickListener(new e(this, hd5Var.f(), null));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f054b) + hd5Var.f());
                if (this.k == null) {
                    this.k = tbImageView;
                    tbImageView.setForegroundColor(SkinManager.getColor(R.color.common_color_10022));
                }
                SkinManager.setBackgroundColor(relativeLayout, R.color.CAM_X0206, this.h);
            } else {
                RelativeLayout relativeLayout2 = new RelativeLayout(getContext());
                tbImageView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
                relativeLayout2.addView(tbImageView);
                int i3 = this.g;
                int i4 = this.f;
                tbImageView.setPadding(i3, i4, i3, i4);
                relativeLayout2.setClickable(true);
                relativeLayout2.setFocusable(true);
                relativeLayout2.setTag(dVar);
                this.b.addView(relativeLayout2, this.b.getChildCount() - 1, this.i);
                EmotionGroupType h = hd5Var.h();
                if (h == EmotionGroupType.LOCAL) {
                    if (hd5Var.d() != null) {
                        hd5Var.d().h(tbImageView);
                    }
                    tbImageView.setOnClickListener(new f(this, this.b.getChildCount() - 3, null));
                    tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0b0f));
                } else if (h == EmotionGroupType.PROMOTION) {
                    if (hd5Var.e() != null) {
                        hd5Var.e().h(tbImageView);
                    }
                    tbImageView.setOnClickListener(new e(this, hd5Var.f(), null));
                    tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f054a) + hd5Var.f());
                } else if (h == EmotionGroupType.BIG_EMOTION) {
                    if (this.n) {
                        if (hd5Var.d() != null) {
                            hd5Var.d().h(tbImageView);
                        }
                        tbImageView.setOnClickListener(new f(this, this.b.getChildCount() - 3, null));
                    } else {
                        if (hd5Var.e() != null) {
                            hd5Var.e().h(tbImageView);
                        }
                        tbImageView.setOnClickListener(new a(this));
                    }
                    tbImageView.setContentDescription(hd5Var.g());
                } else if (h == EmotionGroupType.USER_COLLECT) {
                    if (hd5Var.e() != null) {
                        hd5Var.e().h(tbImageView);
                    }
                    tbImageView.setOnClickListener(new f(this, this.b.getChildCount() - 3, null));
                    tbImageView.setContentDescription("收藏表情");
                } else if (h == EmotionGroupType.SINGLE_FORUM) {
                    if (hd5Var.e() != null) {
                        hd5Var.e().h(tbImageView);
                    }
                    tbImageView.setOnClickListener(new e(this, hd5Var.f(), null));
                    tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f054b) + hd5Var.f());
                } else if (h == EmotionGroupType.USER_DIY) {
                    long o = p45.m().o("key_diy_emotion_last_click_t", 0L);
                    int n = p45.m().n("key_emotion_red_dot_disappear_c", 0);
                    int n2 = p45.m().n("key_emotion_red_dot_show_gap", 0);
                    if (n <= 3 && System.currentTimeMillis() - o > n2 * 86400000) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        this.q = new ImageView(getContext());
                        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(getContext().getResources().getDimensionPixelSize(R.dimen.tbds62), getContext().getResources().getDimensionPixelSize(R.dimen.tbds26));
                        SkinManager.setImageResource(this.q, R.drawable.obfuscated_res_0x7f0808ea);
                        LinearLayout linearLayout = new LinearLayout(getContext());
                        this.r = linearLayout;
                        linearLayout.addView(this.q, layoutParams2);
                        this.r.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
                        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
                        layoutParams3.addRule(11);
                        layoutParams3.addRule(10);
                        layoutParams3.setMargins(0, ii.g(getContext(), R.dimen.obfuscated_res_0x7f070231), ii.g(getContext(), R.dimen.obfuscated_res_0x7f07023c), 0);
                        relativeLayout2.addView(this.r, layoutParams3);
                    }
                    if (hd5Var.e() != null) {
                        hd5Var.e().h(tbImageView);
                    }
                    tbImageView.setOnClickListener(new f(this, this.b.getChildCount() - 3, null));
                    tbImageView.setContentDescription("diy表情");
                } else {
                    Log.d(FileHelper.FILE_CACHE_EMOTION_PACKAGE, "emotion类型错误");
                }
                if (this.k == null) {
                    this.k = tbImageView;
                    tbImageView.setForegroundColor(SkinManager.getColor(R.color.common_color_10022));
                }
                SkinManager.setBackgroundColor(relativeLayout2, R.color.CAM_X0206, this.h);
            }
            return tbImageView;
        }
        return (TbImageView) invokeL.objValue;
    }

    public final void n() {
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
            this.f = getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070303);
            this.g = getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070231);
            this.i = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07023e), -1);
            this.b.setPadding(0, 0, 0, 0);
            j();
        }
    }

    public void o(int i) {
        int color;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.h = i;
            ImageView imageView = this.d;
            if (imageView != null) {
                SkinManager.setImageResource(imageView, R.drawable.face_store, i);
            }
            if (this.c != null) {
                SkinManager.setBackgroundColor(this.d, R.color.CAM_X0206, i);
                if (this.c.getChildCount() > 0) {
                    SkinManager.setBackgroundColor(this.c.getChildAt(1), R.color.common_color_10288, i);
                }
            }
            View view2 = this.o;
            if (view2 != null) {
                SkinManager.setBackgroundColor(view2, R.color.CAM_X0206, i);
            }
            TextView textView = this.e;
            if (textView != null) {
                SkinManager.setBackgroundResource(textView, R.drawable.icon_news_head_prompt_one, i);
                SkinManager.setViewTextColor(this.e, R.color.CAM_X0101, 1, i);
            }
            int childCount = this.b.getChildCount();
            for (int i2 = 1; i2 < childCount; i2++) {
                View childAt = this.b.getChildAt(i2);
                if (childAt != null) {
                    SkinManager.setBackgroundColor(childAt, R.color.CAM_X0206, i);
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
                        dVar.a(i);
                    }
                }
            }
            TbImageView tbImageView = this.k;
            if (tbImageView != null) {
                tbImageView.setForegroundColor(SkinManager.getColor(R.color.common_color_10022));
                if (this.k.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.k.getParent()).setSelected(true);
                }
            }
        }
    }

    public void setCurrentTab(int i) {
        int i2;
        int i3;
        int color;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048583, this, i) != null) || i == (i2 = this.j)) {
            return;
        }
        if (i2 != -1) {
            RelativeLayout relativeLayout = (RelativeLayout) this.b.getChildAt(i2 + 1);
            TbImageView tbImageView = (TbImageView) relativeLayout.getChildAt(0);
            if (tbImageView != null) {
                if (this.h == 0) {
                    color = getResources().getColor(R.color.common_color_10287);
                } else {
                    color = SkinManager.getColor(R.color.common_color_10287);
                }
                tbImageView.setForegroundColor(color);
            }
            relativeLayout.setSelected(false);
        }
        this.j = i;
        RelativeLayout relativeLayout2 = (RelativeLayout) this.b.getChildAt(i + 1);
        relativeLayout2.setSelected(true);
        int[] iArr = new int[2];
        relativeLayout2.getLocationOnScreen(iArr);
        int i4 = iArr[0];
        int width = relativeLayout2.getWidth() + i4;
        if (i4 < 0) {
            scrollBy(i4, 0);
        }
        if (getParent() instanceof ViewGroup) {
            View findViewById = ((ViewGroup) getParent()).findViewById(R.id.obfuscated_res_0x7f090a72);
            if (findViewById != null && findViewById.getVisibility() == 0) {
                i3 = findViewById.getWidth() + 0;
            } else {
                i3 = 0;
            }
            int i5 = getResources().getDisplayMetrics().widthPixels - i3;
            if (width > i5) {
                scrollBy(width - i5, 0);
            }
        }
        TbImageView tbImageView2 = (TbImageView) relativeLayout2.getChildAt(0);
        hd5 hd5Var = this.m.get(this.j);
        if (hd5Var.d() != null) {
            hd5Var.d().h(tbImageView2);
        }
        if (tbImageView2 != null) {
            tbImageView2.setForegroundColor(SkinManager.getColor(R.color.common_color_10022));
            this.k = tbImageView2;
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.j = -1;
            this.b.removeAllViews();
            j();
            o(this.h);
        }
    }

    public void setTabWidgetBigEmontionVisibility(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(NewFaceShopActivityConfig.class);
            int childCount = this.b.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.b.getChildAt(i);
                if (childAt != null) {
                    hd5 hd5Var = null;
                    if (childAt.getTag() instanceof d) {
                        hd5Var = ((d) childAt.getTag()).c;
                    }
                    if (m(hd5Var, z)) {
                        childAt.setVisibility(8);
                    } else {
                        childAt.setVisibility(0);
                    }
                }
            }
            if (z && appResponseToIntentClass) {
                this.c.setVisibility(0);
            } else {
                this.c.setVisibility(8);
            }
        }
    }

    public void setTabWidgetVisibility(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            this.n = z;
            int i2 = i + 1;
            int childCount = this.b.getChildCount();
            int i3 = i2 - 1;
            hd5 hd5Var = this.m.get(i3);
            if (i2 < childCount) {
                if (hd5Var.h() == EmotionGroupType.BIG_EMOTION || hd5Var.h() == EmotionGroupType.USER_COLLECT || hd5Var.h() == EmotionGroupType.USER_DIY) {
                    TbImageView tbImageView = (TbImageView) ((RelativeLayout) this.b.getChildAt(i2)).getChildAt(0);
                    if (!this.n) {
                        tbImageView.setOnClickListener(new c(this));
                        if (hd5Var.e() != null) {
                            hd5Var.e().h(tbImageView);
                            return;
                        }
                        return;
                    }
                    tbImageView.setOnClickListener(new f(this, i3, null));
                    if (hd5Var.d() != null) {
                        hd5Var.d().h(tbImageView);
                    }
                }
            }
        }
    }
}
