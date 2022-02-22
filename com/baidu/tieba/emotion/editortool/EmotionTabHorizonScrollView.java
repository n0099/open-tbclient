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
import c.a.d.f.p.l;
import c.a.d.f.p.n;
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
import java.util.ArrayList;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes12.dex */
public class EmotionTabHorizonScrollView extends HorizontalCustomScrollView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public EmotionLinearLayout f42752f;

    /* renamed from: g  reason: collision with root package name */
    public int f42753g;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<c.a.t0.x.p.d> f42754h;

    /* renamed from: i  reason: collision with root package name */
    public EmotionTabWidgetView.c f42755i;

    /* renamed from: j  reason: collision with root package name */
    public int f42756j;
    public int k;
    public int l;
    public LinearLayout m;
    public ImageView n;
    public TextView o;
    public LinearLayout.LayoutParams p;
    public boolean q;
    public View r;
    public TbImageView s;
    public boolean t;
    public EditorTools u;

    /* loaded from: classes12.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ EmotionTabHorizonScrollView f42757e;

        public a(EmotionTabHorizonScrollView emotionTabHorizonScrollView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emotionTabHorizonScrollView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f42757e = emotionTabHorizonScrollView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                BdToast.c(this.f42757e.getContext(), this.f42757e.getContext().getResources().getString(R.string.emotion_cant_show)).q();
            }
        }
    }

    /* loaded from: classes12.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ EmotionTabHorizonScrollView f42758e;

        public b(EmotionTabHorizonScrollView emotionTabHorizonScrollView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emotionTabHorizonScrollView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f42758e = emotionTabHorizonScrollView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f42758e.o != null) {
                    this.f42758e.f42752f.setNewViewVisible(false);
                }
                TbadkCoreApplication.getInst().setFaceShopVersion(TbadkCoreApplication.getInst().getTempFaceShopVersion());
                TbadkCoreApplication.getInst().setFaceShopNew(false);
                if (this.f42758e.u != null) {
                    this.f42758e.u.sendAction(new c.a.t0.x.a(2, 5, null));
                }
                if (l.z()) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EmotionCenterActivityConfig(this.f42758e.getContext())));
                } else {
                    n.M(this.f42758e.getContext(), R.string.neterror);
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ EmotionTabHorizonScrollView f42759e;

        public c(EmotionTabHorizonScrollView emotionTabHorizonScrollView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emotionTabHorizonScrollView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f42759e = emotionTabHorizonScrollView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                BdToast.c(this.f42759e.getContext(), this.f42759e.getContext().getResources().getString(R.string.emotion_cant_show)).q();
            }
        }
    }

    /* loaded from: classes12.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TbImageView a;

        /* renamed from: b  reason: collision with root package name */
        public View f42760b;

        /* renamed from: c  reason: collision with root package name */
        public c.a.t0.x.p.d f42761c;

        public d() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ d(a aVar) {
            this();
        }
    }

    /* loaded from: classes12.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final String f42762e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ EmotionTabHorizonScrollView f42763f;

        public /* synthetic */ e(EmotionTabHorizonScrollView emotionTabHorizonScrollView, String str, a aVar) {
            this(emotionTabHorizonScrollView, str);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || c.a.d.f.m.b.e(this.f42762e, 0) <= 0) {
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EmotionPackageDetailActivityConfig(this.f42763f.getContext(), c.a.d.f.m.b.e(this.f42762e, 0), 0)));
        }

        public e(EmotionTabHorizonScrollView emotionTabHorizonScrollView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emotionTabHorizonScrollView, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f42763f = emotionTabHorizonScrollView;
            this.f42762e = str;
        }
    }

    /* loaded from: classes12.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final int f42764e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ EmotionTabHorizonScrollView f42765f;

        public /* synthetic */ f(EmotionTabHorizonScrollView emotionTabHorizonScrollView, int i2, a aVar) {
            this(emotionTabHorizonScrollView, i2);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TbImageView tbImageView;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (!this.f42765f.u.findToolById(5).b() && (((c.a.t0.x.p.d) this.f42765f.f42754h.get(this.f42764e)).h() == EmotionGroupType.USER_COLLECT || ((c.a.t0.x.p.d) this.f42765f.f42754h.get(this.f42764e)).h() == EmotionGroupType.BIG_EMOTION)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2921500, Boolean.TRUE));
                    return;
                }
                if ((view instanceof TbImageView) && (tbImageView = (TbImageView) view) != this.f42765f.s) {
                    tbImageView.setForegroundColor(SkinManager.getColor(R.color.common_color_10022));
                    if (this.f42765f.s != null) {
                        if (!this.f42765f.t) {
                            this.f42765f.s.setForegroundColor(SkinManager.getColor(R.color.common_color_10287));
                        } else {
                            this.f42765f.s.setForegroundColor(this.f42765f.getResources().getColor(R.color.common_color_10287));
                        }
                    }
                    this.f42765f.s = tbImageView;
                }
                this.f42765f.setCurrentTab(this.f42764e);
                this.f42765f.f42755i.onTabSelected(this.f42764e);
            }
        }

        public f(EmotionTabHorizonScrollView emotionTabHorizonScrollView, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emotionTabHorizonScrollView, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f42765f = emotionTabHorizonScrollView;
            this.f42764e = i2;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f42753g = -1;
        this.q = true;
        k();
    }

    public void addStore() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ImageView imageView = new ImageView(getContext());
            this.n = imageView;
            imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            ImageView imageView2 = this.n;
            int i2 = this.k;
            int i3 = this.f42756j;
            imageView2.setPadding(i2, i3, i2, i3);
            LinearLayout linearLayout = new LinearLayout(getContext());
            this.m = linearLayout;
            linearLayout.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.face_shop));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
            layoutParams.weight = 1.0f;
            this.n.setLayoutParams(layoutParams);
            SkinManager.setImageResource(this.n, R.drawable.face_store, this.l);
            this.m.addView(this.n);
            View view = new View(getContext());
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds2), -1);
            layoutParams2.gravity = 5;
            layoutParams2.weight = 0.0f;
            view.setLayoutParams(layoutParams2);
            SkinManager.setBackgroundColor(view, R.color.common_color_10288, this.l);
            TextView textView = new TextView(getContext());
            this.o = textView;
            textView.setGravity(17);
            this.o.setTextSize(10.0f);
            this.o.setText("N");
            this.o.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            this.f42752f.addView(this.m, new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds106), -1));
            this.f42752f.setNewView(this.o);
            boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(FaceShopActivityConfig.class);
            if (TbadkCoreApplication.getInst().isFaceShopNew() && appResponseToIntentClass) {
                this.f42752f.setNewViewVisible(true);
            } else {
                this.f42752f.setNewViewVisible(false);
            }
            this.m.setOnClickListener(new b(this));
            this.r = new View(getContext());
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -1);
            layoutParams3.weight = 1.0f;
            this.r.setLayoutParams(layoutParams3);
            this.f42752f.addView(this.r);
            if (appResponseToIntentClass) {
                return;
            }
            this.m.setVisibility(8);
        }
    }

    public void addTabWidget(c.a.t0.x.p.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar) == null) {
            i(dVar);
        }
    }

    public final TbImageView i(c.a.t0.x.p.d dVar) {
        InterceptResult invokeL;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dVar)) == null) {
            TbImageView tbImageView = new TbImageView(getContext());
            d dVar2 = new d(null);
            dVar2.f42761c = dVar;
            tbImageView.setAutoChangeStyle(false);
            dVar2.a = tbImageView;
            if (dVar.h() == EmotionGroupType.SINGLE_FORUM) {
                RelativeLayout relativeLayout = new RelativeLayout(getContext());
                tbImageView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
                relativeLayout.addView(tbImageView);
                int i4 = this.k;
                int i5 = this.f42756j;
                tbImageView.setPadding(i4, i5, i4, i5);
                ImageView imageView = new ImageView(getContext());
                SkinManager.setImageResource(imageView, R.drawable.icon_emotion_recommend);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.addRule(11);
                layoutParams.addRule(12);
                layoutParams.setMargins(0, 0, n.f(getContext(), R.dimen.ds12), n.f(getContext(), R.dimen.ds10));
                relativeLayout.addView(imageView, layoutParams);
                View view = new View(getContext());
                new RelativeLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds2), -1).addRule(11);
                relativeLayout.setClickable(true);
                relativeLayout.setFocusable(true);
                relativeLayout.setTag(dVar2);
                this.f42752f.addView(relativeLayout, this.f42752f.getChildCount() - 1, this.p);
                if (dVar.e() != null) {
                    dVar.e().h(tbImageView);
                }
                tbImageView.setOnClickListener(new e(this, dVar.f(), null));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.download_single_forum_emotion) + dVar.f());
                if (!this.t && ((i3 = this.l) == 1 || i3 == 4)) {
                    view.setBackgroundColor(SkinManager.getColor(R.color.common_color_10288));
                    tbImageView.setForegroundColor(SkinManager.getColor(R.color.common_color_10287));
                } else {
                    view.setBackgroundColor(getResources().getColor(R.color.common_color_10288));
                    tbImageView.setForegroundColor(getResources().getColor(R.color.common_color_10287));
                }
                if (this.s == null) {
                    this.s = tbImageView;
                    tbImageView.setForegroundColor(SkinManager.getColor(R.color.common_color_10022));
                }
                SkinManager.setBackgroundResource(relativeLayout, R.drawable.bg_emotion_tab_horizonscrollview, this.l);
            } else {
                LinearLayout linearLayout = new LinearLayout(getContext());
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -1);
                layoutParams2.weight = 1.0f;
                tbImageView.setLayoutParams(layoutParams2);
                linearLayout.addView(tbImageView);
                int i6 = this.k;
                int i7 = this.f42756j;
                tbImageView.setPadding(i6, i7, i6, i7);
                View view2 = new View(getContext());
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds2), -1);
                layoutParams3.gravity = 5;
                layoutParams3.weight = 0.0f;
                linearLayout.setClickable(true);
                linearLayout.setFocusable(true);
                linearLayout.setTag(dVar2);
                this.f42752f.addView(linearLayout, this.f42752f.getChildCount() - 1, this.p);
                EmotionGroupType h2 = dVar.h();
                if (h2 == EmotionGroupType.LOCAL) {
                    if (dVar.d() != null) {
                        dVar.d().h(tbImageView);
                    }
                    tbImageView.setOnClickListener(new f(this, this.f42752f.getChildCount() - 3, null));
                    tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.local_emotion));
                } else if (h2 == EmotionGroupType.PROMOTION) {
                    if (dVar.e() != null) {
                        dVar.e().h(tbImageView);
                    }
                    tbImageView.setOnClickListener(new e(this, dVar.f(), null));
                    tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.download_promotion_emotion) + dVar.f());
                } else if (h2 == EmotionGroupType.BIG_EMOTION) {
                    if (this.q) {
                        if (dVar.d() != null) {
                            dVar.d().h(tbImageView);
                        }
                        tbImageView.setOnClickListener(new f(this, this.f42752f.getChildCount() - 3, null));
                    } else {
                        if (dVar.e() != null) {
                            dVar.e().h(tbImageView);
                        }
                        tbImageView.setOnClickListener(new a(this));
                    }
                    tbImageView.setContentDescription(dVar.g());
                } else if (h2 == EmotionGroupType.USER_COLLECT) {
                    if (dVar.e() != null) {
                        dVar.e().h(tbImageView);
                    }
                    tbImageView.setOnClickListener(new f(this, this.f42752f.getChildCount() - 3, null));
                    tbImageView.setContentDescription("");
                } else if (h2 == EmotionGroupType.SINGLE_FORUM) {
                    if (dVar.e() != null) {
                        dVar.e().h(tbImageView);
                    }
                    tbImageView.setOnClickListener(new e(this, dVar.f(), null));
                    tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.download_single_forum_emotion) + dVar.f());
                }
                if (!this.t && ((i2 = this.l) == 1 || i2 == 4)) {
                    view2.setBackgroundColor(SkinManager.getColor(R.color.common_color_10288));
                    tbImageView.setForegroundColor(SkinManager.getColor(R.color.common_color_10287));
                } else {
                    view2.setBackgroundColor(getResources().getColor(R.color.common_color_10288));
                    tbImageView.setForegroundColor(getResources().getColor(R.color.common_color_10287));
                }
                if (this.s == null) {
                    this.s = tbImageView;
                    tbImageView.setForegroundColor(SkinManager.getColor(R.color.common_color_10022));
                }
                SkinManager.setBackgroundResource(linearLayout, R.drawable.bg_emotion_tab_horizonscrollview, this.l);
            }
            return tbImageView;
        }
        return (TbImageView) invokeL.objValue;
    }

    public final boolean j(c.a.t0.x.p.d dVar, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048579, this, dVar, z)) == null) {
            if (dVar == null) {
                return true;
            }
            if (z) {
                return false;
            }
            return dVar.h() == EmotionGroupType.BIG_EMOTION || dVar.h() == EmotionGroupType.PROMOTION;
        }
        return invokeLZ.booleanValue;
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            removeAllViews();
            setFillViewport(true);
            setHorizontalScrollBarEnabled(false);
            EmotionLinearLayout emotionLinearLayout = new EmotionLinearLayout(getContext());
            this.f42752f = emotionLinearLayout;
            emotionLinearLayout.setOrientation(0);
            this.f42752f.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            this.f42752f.setBaselineAligned(false);
            addView(this.f42752f);
            this.f42756j = getResources().getDimensionPixelSize(R.dimen.ds8);
            this.k = getResources().getDimensionPixelSize(R.dimen.ds10);
            this.p = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds122), -1);
            this.f42752f.setPadding(0, 0, 0, 0);
            addStore();
        }
    }

    public void onChangeSkin(int i2) {
        int color;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.l = i2;
            ImageView imageView = this.n;
            if (imageView != null) {
                SkinManager.setImageResource(imageView, R.drawable.face_store, i2);
            }
            LinearLayout linearLayout = this.m;
            if (linearLayout != null) {
                SkinManager.setBackgroundResource(linearLayout, R.drawable.bg_emotion_tab_horizonscrollview, i2);
                if (this.m.getChildCount() > 0) {
                    SkinManager.setBackgroundColor(this.m.getChildAt(1), R.color.common_color_10288, i2);
                }
            }
            View view = this.r;
            if (view != null) {
                SkinManager.setBackgroundResource(view, R.drawable.bg_emotion_tab_horizonscrollview, i2);
            }
            TextView textView = this.o;
            if (textView != null) {
                SkinManager.setBackgroundResource(textView, R.drawable.icon_news_head_prompt_one, i2);
                SkinManager.setViewTextColor(this.o, R.color.CAM_X0101, 1, i2);
            }
            int childCount = this.f42752f.getChildCount();
            for (int i3 = 1; i3 < childCount; i3++) {
                View childAt = this.f42752f.getChildAt(i3);
                if (childAt != null) {
                    SkinManager.setBackgroundResource(childAt, R.drawable.bg_emotion_tab_horizonscrollview, i2);
                    d dVar = (d) childAt.getTag();
                    if (dVar != null) {
                        if (dVar.a != null) {
                            if (i2 == 0) {
                                color = getResources().getColor(R.color.common_color_10287);
                            } else {
                                color = SkinManager.getColor(R.color.common_color_10287);
                            }
                            dVar.a.setForegroundColor(color);
                        }
                        View view2 = dVar.f42760b;
                        if (view2 != null) {
                            SkinManager.setBackgroundColor(view2, R.color.common_color_10288, i2);
                        }
                    }
                }
            }
            TbImageView tbImageView = this.s;
            if (tbImageView != null) {
                tbImageView.setForegroundColor(SkinManager.getColor(R.color.common_color_10022));
                if (this.s.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.s.getParent()).setSelected(true);
                }
            }
        }
    }

    public void removeTabWidget(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.f42752f.removeViewAt(i2 + 1);
            int i3 = this.f42753g;
            if (i3 != i2) {
                if (i3 > i2) {
                    this.f42753g = i3 - 1;
                    return;
                }
                return;
            }
            int i4 = i3 - 1;
            this.f42753g = i4;
            if (i4 < 0) {
                i4 = 0;
            }
            setCurrentTab(i4);
        }
    }

    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f42753g = -1;
            this.f42752f.removeAllViews();
            addStore();
            onChangeSkin(this.l);
        }
    }

    public void setCurrentTab(int i2) {
        int i3;
        int color;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) || i2 == (i3 = this.f42753g)) {
            return;
        }
        if (i3 != -1) {
            LinearLayout linearLayout = (LinearLayout) this.f42752f.getChildAt(i3 + 1);
            TbImageView tbImageView = (TbImageView) linearLayout.getChildAt(0);
            if (tbImageView != null) {
                if (this.l == 0) {
                    color = getResources().getColor(R.color.common_color_10287);
                } else {
                    color = SkinManager.getColor(R.color.common_color_10287);
                }
                tbImageView.setForegroundColor(color);
            }
            linearLayout.setSelected(false);
        }
        this.f42753g = i2;
        LinearLayout linearLayout2 = (LinearLayout) this.f42752f.getChildAt(i2 + 1);
        linearLayout2.setSelected(true);
        int[] iArr = new int[2];
        linearLayout2.getLocationOnScreen(iArr);
        int i4 = iArr[0];
        int width = linearLayout2.getWidth() + i4;
        if (i4 < 0) {
            scrollBy(i4, 0);
        }
        if (getParent() instanceof ViewGroup) {
            View findViewById = ((ViewGroup) getParent()).findViewById(R.id.face_tab_delete);
            int width2 = getResources().getDisplayMetrics().widthPixels - ((findViewById == null || findViewById.getVisibility() != 0) ? 0 : findViewById.getWidth() + 0);
            if (width > width2) {
                scrollBy(width - width2, 0);
            }
        }
        TbImageView tbImageView2 = (TbImageView) linearLayout2.getChildAt(0);
        c.a.t0.x.p.d dVar = this.f42754h.get(this.f42753g);
        if (dVar.d() != null) {
            dVar.d().h(tbImageView2);
        }
        if (tbImageView2 != null) {
            tbImageView2.setForegroundColor(SkinManager.getColor(R.color.common_color_10022));
            this.s = tbImageView2;
        }
    }

    public void setDatas(ArrayList<c.a.t0.x.p.d> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, arrayList) == null) {
            this.f42754h = arrayList;
        }
    }

    public void setEditorTools(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, editorTools) == null) {
            this.u = editorTools;
        }
    }

    public void setFrom(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
        }
    }

    public void setIsInChat(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.t = z;
        }
    }

    public void setOnTabSelectedListener(EmotionTabWidgetView.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, cVar) == null) {
            this.f42755i = cVar;
        }
    }

    public void setTabWidgetBigEmontionVisibility(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(FaceShopActivityConfig.class);
            int childCount = this.f42752f.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.f42752f.getChildAt(i2);
                if (childAt != null) {
                    if (j(childAt.getTag() instanceof d ? ((d) childAt.getTag()).f42761c : null, z)) {
                        childAt.setVisibility(8);
                    } else {
                        childAt.setVisibility(0);
                    }
                }
            }
            if (z && appResponseToIntentClass) {
                this.m.setVisibility(0);
            } else {
                this.m.setVisibility(8);
            }
        }
    }

    public void setTabWidgetVisibility(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            this.q = z;
            int i3 = i2 + 1;
            int childCount = this.f42752f.getChildCount();
            int i4 = i3 - 1;
            c.a.t0.x.p.d dVar = this.f42754h.get(i4);
            if (i3 < childCount) {
                if (dVar.h() == EmotionGroupType.BIG_EMOTION || dVar.h() == EmotionGroupType.USER_COLLECT) {
                    TbImageView tbImageView = (TbImageView) ((LinearLayout) this.f42752f.getChildAt(i3)).getChildAt(0);
                    if (!this.q) {
                        tbImageView.setOnClickListener(new c(this));
                        if (dVar.e() != null) {
                            dVar.e().h(tbImageView);
                            return;
                        }
                        return;
                    }
                    tbImageView.setOnClickListener(new f(this, i4, null));
                    if (dVar.d() != null) {
                        dVar.d().h(tbImageView);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f42753g = -1;
        this.q = true;
        k();
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f42753g = -1;
        this.q = true;
        k();
    }
}
