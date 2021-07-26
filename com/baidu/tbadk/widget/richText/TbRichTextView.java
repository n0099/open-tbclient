package com.baidu.tbadk.widget.richText;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.Fragment;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ItemClickJumpUtil;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.ItemCardView;
import com.baidu.tbadk.gif.GifInfo;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tbadk.switchs.DuiSwitch;
import com.baidu.tbadk.widget.ForeDrawableImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.TbListTextView;
import com.baidu.tbadk.widget.layout.GridImageLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.R$styleable;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBnt;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.h2.i.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import tbclient.MemeInfo;
import tbclient.PbContent;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes3.dex */
public class TbRichTextView extends LinearLayout implements d.a.d.f.a.i {
    public static /* synthetic */ Interceptable $ic;
    public static final float t0;
    public transient /* synthetic */ FieldHolder $fh;
    public View.OnClickListener A;
    public boolean B;
    public boolean C;
    public Runnable D;
    public boolean E;
    public y F;
    public TbRichText G;
    public boolean H;
    public int I;
    public int J;
    public boolean K;
    public boolean L;
    public boolean M;
    public boolean N;
    public boolean O;
    public boolean P;
    public boolean Q;
    public boolean R;
    public int S;
    public TextView T;
    public boolean U;
    public boolean V;
    public boolean W;
    public String a0;
    public d.a.p0.d1.m.f b0;
    public View.OnLongClickListener c0;

    /* renamed from: e  reason: collision with root package name */
    public d.a.p0.d1.m.a f13570e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.q0.h2.a<ImageView> f13571f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.d.e.k.b<ImageView> f13572g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.d.e.k.b<TextView> f13573h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.d.e.k.b<View> f13574i;
    public w i0;
    public d.a.d.e.k.b<LinearLayout> j;
    public final View.OnClickListener j0;
    public d.a.d.e.k.b<RelativeLayout> k;
    public final d.a.q0.h2.i.c k0;
    public d.a.d.e.k.b<GifView> l;
    public final View.OnClickListener l0;
    public GridImageLayout m;
    public final x m0;
    public ItemCardView n;
    public boolean n0;
    public boolean o;
    public Drawable o0;
    public TextUtils.TruncateAt p;
    public String p0;
    public b0 q;
    public BdUniqueId q0;
    public z r;
    public final d.a.d.e.l.c<d.a.d.k.d.a> r0;
    public d.a.q0.h2.i.c s;
    public CustomMessageListener s0;
    public a0 t;
    public View.OnClickListener u;
    public View.OnClickListener v;
    public View.OnClickListener w;
    public boolean x;
    public boolean y;
    public int z;

    /* loaded from: classes3.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TbRichTextView f13575e;

        public a(TbRichTextView tbRichTextView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbRichTextView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13575e = tbRichTextView;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f13575e.d0();
                this.f13575e.T.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface a0 {
        void a(View view, String str);
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TbRichTextData f13576e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ TbRichTextView f13577f;

        public b(TbRichTextView tbRichTextView, TbRichTextData tbRichTextData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbRichTextView, tbRichTextData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13577f = tbRichTextView;
            this.f13576e = tbRichTextData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f13577f.F == null) {
                return;
            }
            TbRichTextEmotionInfo y = this.f13576e.y();
            y yVar = this.f13577f.F;
            GifInfo gifInfo = y.mGifInfo;
            yVar.a(view, gifInfo.mGid, gifInfo.mPackageName, gifInfo.mIcon, gifInfo.mStaticUrl, gifInfo.mDynamicUrl, gifInfo.mSharpText, gifInfo.mGifWidth, gifInfo.mGifHeight);
        }
    }

    /* loaded from: classes3.dex */
    public static class b0 implements AbsListView.RecyclerListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public int f13578e;

        public b0(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13578e = 0;
            this.f13578e = i2;
        }

        @Override // android.widget.AbsListView.RecyclerListener
        public void onMovedToScrapHeap(View view) {
            View findViewById;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && (findViewById = view.findViewById(this.f13578e)) != null && (findViewById instanceof TbRichTextView)) {
                ((TbRichTextView) findViewById).setText(null);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TbRichTextData f13579e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ TbRichTextView f13580f;

        public c(TbRichTextView tbRichTextView, TbRichTextData tbRichTextData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbRichTextView, tbRichTextData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13580f = tbRichTextView;
            this.f13579e = tbRichTextData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                TiebaStatic.log(new StatisticItem("common_click").param("page_type", "a005").param(TiebaStatic.Params.GUA_TYPE, 2).param("obj_locate", 16));
                ItemClickJumpUtil.itemClickJump(this.f13579e.z().getItemForumName(), this.f13579e.z().getItemID(), 3, 3);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements x {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbRichTextView f13581a;

        public d(TbRichTextView tbRichTextView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbRichTextView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13581a = tbRichTextView;
        }

        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.x
        public void dispatchTouchEvent(MotionEvent motionEvent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, motionEvent) == null) {
                if (motionEvent.getAction() == 0) {
                    this.f13581a.P = true;
                } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                    this.f13581a.P = false;
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e extends d.a.d.e.l.c<d.a.d.k.d.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbRichTextView f13582a;

        public e(TbRichTextView tbRichTextView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbRichTextView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13582a = tbRichTextView;
        }

        @Override // d.a.d.e.l.c
        public void onCancelled(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                super.onCancelled(str);
            }
        }

        @Override // d.a.d.e.l.c
        public void onProgressUpdate(Object... objArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, objArr) == null) {
                super.onProgressUpdate(objArr);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.d.e.l.c
        public void onLoaded(d.a.d.k.d.a aVar, String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, str, i2) == null) {
                this.f13582a.y(aVar);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbRichTextView f13583a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(TbRichTextView tbRichTextView, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbRichTextView, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13583a = tbRichTextView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                int contentSizeOfLzl = this.f13583a.L ? TbConfig.getContentSizeOfLzl() : TbConfig.getContentSize();
                if (this.f13583a.G != null && !ListUtils.isEmpty(this.f13583a.G.y())) {
                    Iterator<TbRichTextData> it = this.f13583a.G.y().iterator();
                    while (it.hasNext()) {
                        TbRichTextData next = it.next();
                        if (next != null) {
                            next.M(contentSizeOfLzl, contentSizeOfLzl);
                        }
                    }
                }
                this.f13583a.setTextSize(contentSizeOfLzl);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g implements d.a.d.e.k.c<ImageView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbRichTextView f13584a;

        public g(TbRichTextView tbRichTextView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbRichTextView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13584a = tbRichTextView;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.a.d.e.k.c
        public /* bridge */ /* synthetic */ ImageView a(ImageView imageView) {
            ImageView imageView2 = imageView;
            e(imageView2);
            return imageView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.a.d.e.k.c
        public /* bridge */ /* synthetic */ ImageView c(ImageView imageView) {
            ImageView imageView2 = imageView;
            h(imageView2);
            return imageView2;
        }

        public ImageView e(ImageView imageView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, imageView)) == null) {
                if (imageView instanceof TbImageView) {
                    TbImageView tbImageView = (TbImageView) imageView;
                    tbImageView.setTag(null);
                    if (d.a.p0.s.k.c().g()) {
                        tbImageView.setAdjustViewBounds(false);
                        tbImageView.setInterceptOnClick(false);
                    } else {
                        tbImageView.setAdjustViewBounds(true);
                        tbImageView.setInterceptOnClick(true);
                    }
                }
                return imageView;
            }
            return (ImageView) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.d.e.k.c
        /* renamed from: f */
        public void b(ImageView imageView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, imageView) == null) {
                imageView.setBackgroundDrawable(null);
                imageView.setImageDrawable(null);
                imageView.setTag(null);
                imageView.setOnClickListener(null);
                if (imageView instanceof ForeDrawableImageView) {
                    ForeDrawableImageView foreDrawableImageView = (ForeDrawableImageView) imageView;
                    foreDrawableImageView.Q();
                    foreDrawableImageView.setForegroundDrawable(0);
                    foreDrawableImageView.setDefaultBgResource(R.color.common_color_10220);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.d.e.k.c
        /* renamed from: g */
        public ImageView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(d.a.d.a.j.a(this.f13584a.getContext()).getPageActivity());
                boolean g2 = d.a.p0.s.k.c().g();
                foreDrawableImageView.setDefaultBg(SkinManager.getDrawable(R.color.common_color_10220));
                if (g2) {
                    foreDrawableImageView.setAdjustViewBounds(false);
                    foreDrawableImageView.setInterceptOnClick(false);
                } else {
                    foreDrawableImageView.setDefaultResource(R.drawable.icon_click);
                    foreDrawableImageView.setAdjustViewBounds(true);
                    foreDrawableImageView.setInterceptOnClick(true);
                }
                return foreDrawableImageView;
            }
            return (ImageView) invokeV.objValue;
        }

        public ImageView h(ImageView imageView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, imageView)) == null) ? imageView : (ImageView) invokeL.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class h extends d.a.q0.h2.a<ImageView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TbRichTextView f13585e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(TbRichTextView tbRichTextView, d.a.d.e.k.c cVar, int i2, int i3) {
            super(cVar, i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbRichTextView, cVar, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((d.a.d.e.k.c) objArr2[0], ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13585e = tbRichTextView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.q0.h2.a
        /* renamed from: i */
        public ImageView h(Object obj) {
            InterceptResult invokeL;
            ImageView imageView;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
                if (obj instanceof String) {
                    Iterator it = this.f41772c.iterator();
                    while (it.hasNext()) {
                        imageView = (ImageView) it.next();
                        if ((imageView instanceof TbImageView) && obj.equals(((TbImageView) imageView).getUrl())) {
                            break;
                        }
                    }
                }
                imageView = null;
                this.f41772c.remove(imageView);
                return imageView;
            }
            return (ImageView) invokeL.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class i extends d.a.p0.d1.m.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbRichTextView l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(TbRichTextView tbRichTextView, int i2, String str) {
            super(i2, str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbRichTextView, Integer.valueOf(i2), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), (String) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.l = tbRichTextView;
        }

        @Override // d.a.p0.d1.m.f, android.text.style.ClickableSpan
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.l.setAddExpandableListener(false);
                this.l.setTextEllipsize(TextUtils.TruncateAt.END);
                this.l.setMaxLines(5);
                this.l.setAddTruncateListener(true);
                this.l.G.isChanged = true;
                TbRichTextView tbRichTextView = this.l;
                tbRichTextView.setText(tbRichTextView.G);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class j implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TbRichTextView f13586e;

        public j(TbRichTextView tbRichTextView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbRichTextView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13586e = tbRichTextView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MemeInfo memeInfo;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && this.f13586e.r != null && (view instanceof ImageView)) {
                String str = null;
                Object tag = view.getTag();
                int i2 = 0;
                int i3 = -1;
                if (tag != null && (tag instanceof TbRichText)) {
                    int childCount = this.f13586e.getChildCount();
                    while (i2 < childCount) {
                        i3++;
                        if (view.getParent() == this.f13586e.getChildAt(i2)) {
                            break;
                        }
                        i2++;
                    }
                    this.f13586e.r.a(view, null, i3, this.f13586e.M, false);
                    return;
                }
                if (tag != null && (tag instanceof String)) {
                    str = (String) tag;
                } else {
                    boolean z = view instanceof TbImageView;
                    if (z && (view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextMemeInfo)) {
                        TbRichTextMemeInfo tbRichTextMemeInfo = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                        String str2 = (tbRichTextMemeInfo == null || (memeInfo = tbRichTextMemeInfo.memeInfo) == null) ? "" : memeInfo.pic_url;
                        int childCount2 = this.f13586e.getChildCount();
                        while (i2 < childCount2) {
                            i3++;
                            if (view.getParent() == this.f13586e.getChildAt(i2)) {
                                break;
                            }
                            i2++;
                        }
                        this.f13586e.r.a(view, str2, i3, this.f13586e.M, false);
                        return;
                    } else if (z) {
                        str = ((TbImageView) view).getUrl();
                    } else if (view instanceof GifView) {
                        str = ((GifView) view).getUrl();
                    }
                }
                String str3 = str;
                int childCount3 = this.f13586e.getChildCount();
                while (i2 < childCount3) {
                    View childAt = this.f13586e.getChildAt(i2);
                    if (this.f13586e.R(childAt)) {
                        i3++;
                    }
                    if (view == childAt) {
                        break;
                    }
                    i2++;
                }
                this.f13586e.r.a(view, str3, i3, this.f13586e.M, false);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class k implements c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbRichTextView f13587a;

        public k(TbRichTextView tbRichTextView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbRichTextView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13587a = tbRichTextView;
        }

        @Override // d.a.q0.h2.i.c.a
        public boolean a(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                return false;
            }
            return invokeLL.booleanValue;
        }

        @Override // d.a.q0.h2.i.c.a
        public boolean b(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, motionEvent)) == null) {
                if (this.f13587a.j0 != null) {
                    this.f13587a.j0.onClick(view);
                    return true;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }

        @Override // d.a.q0.h2.i.c.a
        public boolean c(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view, motionEvent)) == null) {
                if (this.f13587a.s != null) {
                    this.f13587a.s.a(view);
                    return this.f13587a.s.onDoubleTap(motionEvent);
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class l implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TbRichTextView f13588e;

        public l(TbRichTextView tbRichTextView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbRichTextView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13588e = tbRichTextView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && this.f13588e.t != null && (view instanceof TbImageView)) {
                String str = null;
                Object tag = view.getTag();
                if (tag != null && (tag instanceof v)) {
                    str = ((v) tag).f13599a;
                }
                this.f13588e.t.a(view, str);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class m implements d.a.d.e.k.c<TextView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f13589a;

        public m(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13589a = context;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.a.d.e.k.c
        public /* bridge */ /* synthetic */ TextView a(TextView textView) {
            TextView textView2 = textView;
            e(textView2);
            return textView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.a.d.e.k.c
        public /* bridge */ /* synthetic */ TextView c(TextView textView) {
            TextView textView2 = textView;
            h(textView2);
            return textView2;
        }

        public TextView e(TextView textView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, textView)) == null) ? textView : (TextView) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.d.e.k.c
        /* renamed from: f */
        public void b(TextView textView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, textView) == null) {
                textView.setText((CharSequence) null);
                textView.setTag(null);
                textView.setSingleLine(false);
                textView.setEllipsize(null);
                textView.setBackgroundResource(0);
                textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                textView.setTextColor(0);
                textView.setGravity(3);
                textView.setOnClickListener(null);
                textView.setOnTouchListener(null);
                if (textView instanceof TbListTextView) {
                    ((TbListTextView) textView).setCheckSelection(true);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.d.e.k.c
        /* renamed from: g */
        public TextView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? new TbListTextView(this.f13589a) : (TextView) invokeV.objValue;
        }

        public TextView h(TextView textView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, textView)) == null) {
                textView.setText((CharSequence) null);
                textView.setTag(null);
                textView.setSingleLine(false);
                textView.setEllipsize(null);
                textView.setBackgroundResource(0);
                textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                textView.setTextColor(0);
                textView.setGravity(3);
                textView.setOnClickListener(null);
                textView.setOnTouchListener(null);
                if (textView instanceof TbListTextView) {
                    ((TbListTextView) textView).setCheckSelection(true);
                }
                return textView;
            }
            return (TextView) invokeL.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class n implements ViewGroup.OnHierarchyChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TbRichTextView f13590e;

        public n(TbRichTextView tbRichTextView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbRichTextView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13590e = tbRichTextView;
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewAdded(View view, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, view, view2) == null) {
            }
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewRemoved(View view, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, view2) == null) {
                if (view2 instanceof GifView) {
                    Object tag = view2.getTag(R.id.tag_rich_text_view_recycle);
                    if (!(tag instanceof u) || !((u) tag).f13598a) {
                        if (this.f13590e.l != null) {
                            this.f13590e.l.e((GifView) view2);
                        }
                    } else {
                        if (this.f13590e.f13571f == null) {
                            TbRichTextView tbRichTextView = this.f13590e;
                            tbRichTextView.f13571f = tbRichTextView.getRecycleImageViewPool();
                        }
                        this.f13590e.f13571f.e((ImageView) view2);
                    }
                } else if (view2 instanceof ImageView) {
                    Object tag2 = view2.getTag(R.id.tag_rich_text_view_recycle);
                    if (!(tag2 instanceof u) || !((u) tag2).f13598a) {
                        if (this.f13590e.f13572g != null) {
                            this.f13590e.f13572g.e((ImageView) view2);
                        }
                    } else {
                        if (this.f13590e.f13571f == null) {
                            TbRichTextView tbRichTextView2 = this.f13590e;
                            tbRichTextView2.f13571f = tbRichTextView2.getRecycleImageViewPool();
                        }
                        this.f13590e.f13571f.e((ImageView) view2);
                    }
                } else if ((view2 instanceof TextView) && this.f13590e.f13573h != null) {
                    this.f13590e.f13573h.e((TextView) view2);
                } else if ((view2 instanceof PlayVoiceBnt) && this.f13590e.f13574i != null) {
                    this.f13590e.f13574i.e(view2);
                } else if ((view2 instanceof PlayVoiceBntNew) && this.f13590e.f13574i != null) {
                    this.f13590e.f13574i.e(view2);
                } else if (view2 instanceof GridImageLayout) {
                    GridImageLayout gridImageLayout = (GridImageLayout) view2;
                    int childCount = gridImageLayout.getChildCount();
                    for (int i2 = 0; i2 < childCount; i2++) {
                        View childAt = gridImageLayout.getChildAt(i2);
                        if ((childAt instanceof GifView) && this.f13590e.l != null) {
                            this.f13590e.l.e((GifView) childAt);
                        } else if ((childAt instanceof ImageView) && this.f13590e.f13572g != null) {
                            this.f13590e.f13572g.e((ImageView) childAt);
                        }
                    }
                    gridImageLayout.removeAllViews();
                    gridImageLayout.g();
                } else if ((view2 instanceof RelativeLayout) && this.f13590e.k != null) {
                    this.f13590e.k.e((RelativeLayout) view2);
                }
                if (!(view2 instanceof LinearLayout) || (view2 instanceof ItemCardView)) {
                    return;
                }
                Object tag3 = view2.getTag();
                if (tag3 == null || !(tag3 instanceof String) || !"VideoView".equals(tag3)) {
                    if (this.f13590e.j != null) {
                        LinearLayout linearLayout = (LinearLayout) view2;
                        int childCount2 = linearLayout.getChildCount();
                        for (int i3 = 0; i3 < childCount2; i3++) {
                            View childAt2 = linearLayout.getChildAt(i3);
                            if (childAt2 != null) {
                                if ((childAt2 instanceof TextView) && this.f13590e.f13573h != null) {
                                    this.f13590e.f13573h.e((TextView) childAt2);
                                } else if ((childAt2 instanceof PlayVoiceBnt) && this.f13590e.f13574i != null) {
                                    this.f13590e.f13574i.e(childAt2);
                                } else if ((childAt2 instanceof PlayVoiceBntNew) && this.f13590e.f13574i != null) {
                                    this.f13590e.f13574i.e(childAt2);
                                }
                            }
                        }
                        linearLayout.removeAllViews();
                        this.f13590e.j.e(linearLayout);
                        return;
                    }
                    return;
                }
                view2.setBackgroundDrawable(null);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class o implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.p0.d1.m.i f13591e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ TbRichTextView f13592f;

        public o(TbRichTextView tbRichTextView, d.a.p0.d1.m.i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbRichTextView, iVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13592f = tbRichTextView;
            this.f13591e = iVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                TiebaStatic.log(TbadkCoreStatisticKey.KEY_RICH_TEXT_VIDEO_CLICK);
                XiaoyingUtil.startPlayXiaoyingVideo(this.f13592f.getContext(), this.f13591e.f(), this.f13591e.g(), this.f13591e.d(), this.f13591e.e());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class p implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TbRichTextData f13593e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ TbRichTextView f13594f;

        public p(TbRichTextView tbRichTextView, TbRichTextData tbRichTextData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbRichTextView, tbRichTextData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13594f = tbRichTextView;
            this.f13593e = tbRichTextData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f13593e.E() == null) {
                return;
            }
            if (this.f13594f.getContext() instanceof d.a.p0.d1.m.h) {
                ((d.a.p0.d1.m.h) this.f13594f.getContext()).onVideoClicked(this.f13594f.getContext(), this.f13593e.E().toString());
                return;
            }
            d.a.d.a.f<?> a2 = d.a.d.a.j.a(this.f13594f.getContext());
            if (a2 == null || !(a2.getOrignalPage() instanceof d.a.p0.d1.m.h)) {
                return;
            }
            ((d.a.p0.d1.m.h) a2.getOrignalPage()).onVideoClicked(this.f13594f.getContext(), this.f13593e.E().toString());
        }
    }

    /* loaded from: classes3.dex */
    public class q implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TbRichTextView f13595e;

        public q(TbRichTextView tbRichTextView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbRichTextView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13595e = tbRichTextView;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f13595e.g0();
                this.f13595e.T.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class r implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TbRichTextView f13596e;

        public r(TbRichTextView tbRichTextView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbRichTextView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13596e = tbRichTextView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && !this.f13596e.P && this.f13596e.performLongClick()) {
                this.f13596e.C = true;
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class s {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f13597a;

        public s() {
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

        public /* synthetic */ s(i iVar) {
            this();
        }
    }

    /* loaded from: classes3.dex */
    public interface t {
        void S(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView);
    }

    /* loaded from: classes3.dex */
    public static class u {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f13598a;

        public u() {
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

        public /* synthetic */ u(i iVar) {
            this();
        }
    }

    /* loaded from: classes3.dex */
    public static class v {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f13599a;

        public v(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13599a = str;
        }
    }

    /* loaded from: classes3.dex */
    public interface w {
        void a();
    }

    /* loaded from: classes3.dex */
    public interface x {
        void dispatchTouchEvent(MotionEvent motionEvent);
    }

    /* loaded from: classes3.dex */
    public interface y {
        void a(View view, String str, String str2, String str3, String str4, String str5, String str6, int i2, int i3);
    }

    /* loaded from: classes3.dex */
    public interface z {
        void a(View view, String str, int i2, boolean z, boolean z2);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-748262847, "Lcom/baidu/tbadk/widget/richText/TbRichTextView;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-748262847, "Lcom/baidu/tbadk/widget/richText/TbRichTextView;");
                return;
            }
        }
        t0 = d.a.d.e.p.l.h(TbadkCoreApplication.getInst());
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TbRichTextView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f13570e = new d.a.p0.d1.m.a();
        this.f13571f = null;
        this.f13572g = null;
        this.f13573h = null;
        this.f13574i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.o = true;
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = null;
        this.v = null;
        this.w = null;
        this.x = true;
        this.y = true;
        this.z = -1;
        this.B = false;
        this.C = false;
        this.D = null;
        this.E = false;
        this.H = false;
        this.I = -1;
        this.J = -1;
        this.K = true;
        this.L = false;
        this.M = false;
        this.N = false;
        this.O = false;
        this.P = false;
        this.Q = false;
        this.R = false;
        this.U = false;
        this.V = false;
        this.W = false;
        this.b0 = new i(this, 2, null);
        this.j0 = new j(this);
        this.k0 = new d.a.q0.h2.i.c(new k(this));
        this.l0 = new l(this);
        this.m0 = new d(this);
        this.r0 = new e(this);
        this.s0 = new f(this, 2004018);
        G();
    }

    public static TbRichText S(Context context, JSONArray jSONArray, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLI = interceptable.invokeLLI(65539, null, context, jSONArray, i2)) == null) ? new TbRichText(context, jSONArray, i2) : (TbRichText) invokeLLI.objValue;
    }

    public static TbRichText T(Context context, JSONArray jSONArray, boolean z2) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(InputDeviceCompat.SOURCE_TRACKBALL, null, context, jSONArray, z2)) == null) ? new TbRichText(context, jSONArray, z2) : (TbRichText) invokeLLZ.objValue;
    }

    public static TbRichText U(Context context, List<PbContent> list, String str, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, null, new Object[]{context, list, str, Boolean.valueOf(z2)})) == null) ? new TbRichText(context, list, str, z2) : (TbRichText) invokeCommon.objValue;
    }

    public static TbRichText V(Context context, List<PbContent> list, boolean z2) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(AdIconUtil.BAIDU_LOGO_ID, null, context, list, z2)) == null) ? new TbRichText(context, list, null, z2) : (TbRichText) invokeLLZ.objValue;
    }

    private GifView getGifView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, this)) == null) {
            d.a.d.e.k.b<GifView> bVar = this.l;
            GifView b2 = bVar != null ? bVar.b() : null;
            if (b2 == null || b2.getParent() != null) {
                b2 = new GifView(getContext());
            }
            b2.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
            b2.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
            b2.setBorderSurroundContent(true);
            b2.setDrawCorner(true);
            b2.setDrawBorder(true);
            b2.setConrers(15);
            b2.setDrawBorder(true);
            b2.setRadius(this.S);
            if (this.Q) {
                b2.setPlaceHolder(2);
            } else {
                b2.setPlaceHolder(3);
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) b2.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.leftMargin = 0;
                layoutParams.rightMargin = 0;
                b2.setLayoutParams(layoutParams);
            }
            return b2;
        }
        return (GifView) invokeV.objValue;
    }

    private GridImageLayout getGridImageView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65551, this)) == null) {
            GridImageLayout gridImageLayout = this.m;
            if (gridImageLayout == null || gridImageLayout.getParent() != null) {
                this.m = new GridImageLayout(getContext());
                this.m.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            }
            this.m.setLayoutStrategy(this.f13570e);
            this.m.setObjectPool(this.f13572g, this.l);
            this.m.setOnImageClickListener(this.r);
            View.OnClickListener onClickListener = this.v;
            if (onClickListener != null) {
                this.m.setOnClickListener(onClickListener);
            }
            this.m.setIsHost(this.M);
            if (this.R) {
                this.m.setOnLongClickListener(this.c0);
            }
            return this.m;
        }
        return (GridImageLayout) invokeV.objValue;
    }

    private View getTextVoiceView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65552, this)) == null) {
            LinearLayout b2 = this.j.b();
            if (b2 != null) {
                TextView B = B(getContext());
                if (B == null) {
                    this.j.e(b2);
                    return null;
                }
                b2.addView(B);
                View D = D(null);
                if (D == null) {
                    this.f13573h.e(B);
                    this.j.e(b2);
                    return null;
                }
                b2.addView(D);
            }
            return b2;
        }
        return (View) invokeV.objValue;
    }

    private void setFaceSize(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(65565, this, f2) == null) {
            if (this.V && d.a.p0.b.d.V()) {
                int emotionContentSizeOfLzl = this.L ? TbConfig.getEmotionContentSizeOfLzl() : TbConfig.getEmotionContentSize();
                d.a.p0.d1.m.a aVar = this.f13570e;
                aVar.f52384g = emotionContentSizeOfLzl;
                aVar.f52385h = emotionContentSizeOfLzl;
                return;
            }
            d.a.p0.d1.m.a aVar2 = this.f13570e;
            int i2 = (int) f2;
            aVar2.f52384g = i2;
            aVar2.f52385h = i2;
        }
    }

    public static d.a.d.e.k.b<TextView> z(Context context, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65571, null, context, i2)) == null) ? new d.a.d.e.k.b<>(new m(context), i2, 0) : (d.a.d.e.k.b) invokeLI.objValue;
    }

    public final ImageView A(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            d.a.d.e.k.b<ImageView> bVar = this.f13572g;
            ImageView imageView = null;
            ImageView b2 = bVar != null ? bVar.b() : null;
            if (b2 != null && b2.getParent() == null) {
                imageView = b2;
            }
            if (imageView != null) {
                imageView.setContentDescription(context.getString(R.string.editor_image));
            }
            return imageView;
        }
        return (ImageView) invokeL.objValue;
    }

    public final TextView B(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            d.a.d.e.k.b<TextView> bVar = this.f13573h;
            TextView b2 = bVar != null ? bVar.b() : null;
            if (b2 == null || b2.getParent() != null) {
                b2 = new TbListTextView(context);
            }
            int i2 = this.f13570e.f52380c;
            b2.setPadding(i2, 0, i2, 0);
            return b2;
        }
        return (TextView) invokeL.objValue;
    }

    public final LinearLayout C(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, tbRichTextData)) == null) {
            if (this.f13570e.m <= 0 || tbRichTextData == null) {
                return null;
            }
            LinearLayout linearLayout = new LinearLayout(getContext());
            linearLayout.setTag("VideoView");
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.topMargin = this.f13570e.f52381d;
            linearLayout.setClickable(true);
            Bitmap bitmap = SkinManager.getBitmap(this.f13570e.m);
            if (bitmap != null) {
                linearLayout.setBackgroundDrawable(new BitmapDrawable(getContext().getResources(), bitmap));
            }
            linearLayout.setFocusable(false);
            linearLayout.setLayoutParams(layoutParams);
            linearLayout.setOnClickListener(new p(this, tbRichTextData));
            return linearLayout;
        }
        return (LinearLayout) invokeL.objValue;
    }

    public final View D(View view) {
        InterceptResult invokeL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, view)) == null) {
            d.a.d.e.k.b<View> bVar = this.f13574i;
            View b2 = bVar != null ? bVar.b() : null;
            if ((b2 == null || b2.getParent() != null) && this.z != -1) {
                b2 = LayoutInflater.from(getContext()).inflate(this.z, (ViewGroup) null);
            }
            if (b2 != null) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                if ((view instanceof TbListTextView) && (i2 = this.f13570e.v) >= 0) {
                    layoutParams.topMargin = i2;
                } else {
                    layoutParams.topMargin = this.f13570e.f52381d;
                }
                layoutParams.bottomMargin = this.f13570e.x;
                b2.setLayoutParams(layoutParams);
                if (b2 instanceof PlayVoiceBntNew) {
                    ((PlayVoiceBntNew) b2).setAfterClickListener(this.A);
                }
                return b2;
            }
            return null;
        }
        return (View) invokeL.objValue;
    }

    public final View E(d.a.p0.d1.m.i iVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, iVar)) == null) {
            if (iVar == null || !iVar.h()) {
                return null;
            }
            ImageView b2 = this.f13572g.b();
            if (b2 instanceof ForeDrawableImageView) {
                ForeDrawableImageView foreDrawableImageView = (ForeDrawableImageView) b2;
                foreDrawableImageView.setForegroundDrawable(R.drawable.icon_play_video);
                foreDrawableImageView.setNoImageBottomTextColor(R.color.CAM_X0108);
                foreDrawableImageView.setNoImageBottomTextPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds32));
                foreDrawableImageView.setNoImageBottomTextSize(TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.fontsize28));
                foreDrawableImageView.setNoImageBottomText("点击播放视频");
                foreDrawableImageView.setInterceptOnClick(false);
                foreDrawableImageView.setTag("VideoView");
                c0(foreDrawableImageView, iVar.g(), iVar.d(), (this.f13570e.j - getPaddingLeft()) - getPaddingRight(), this.f13570e.k, new o(this, iVar));
                foreDrawableImageView.setDefaultResource(0);
                foreDrawableImageView.setSupportNoImage(this.f13570e.q);
                if (d.a.p0.s.k.c().g()) {
                    foreDrawableImageView.setDefaultBgResource(R.drawable.pic_bg_video_frs);
                } else {
                    foreDrawableImageView.setDefaultBgResource(R.color.CAM_X0204);
                }
                foreDrawableImageView.M(iVar.e(), 17, false);
            }
            return b2;
        }
        return (View) invokeL.objValue;
    }

    public boolean F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.E : invokeV.booleanValue;
    }

    public final void G() {
        d.a.p0.d1.m.h hVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            d.a.d.a.f<?> a2 = d.a.d.a.j.a(getContext());
            if (getContext() instanceof d.a.p0.d1.m.h) {
                hVar = (d.a.p0.d1.m.h) getContext();
            } else {
                hVar = (a2 == null || !(a2.getOrignalPage() instanceof d.a.p0.d1.m.h)) ? null : (d.a.p0.d1.m.h) a2.getOrignalPage();
            }
            if (hVar == null && (getContext() instanceof BaseFragmentActivity)) {
                List<Fragment> fragments = ((BaseFragmentActivity) getContext()).getSupportFragmentManager().getFragments();
                if (!ListUtils.isEmpty(fragments) && (fragments.get(0) instanceof d.a.p0.d1.m.h)) {
                    hVar = (d.a.p0.d1.m.h) fragments.get(0);
                }
            }
            if (a2 != null) {
                a2.registerListener(this.s0);
            }
            if (hVar != null) {
                this.f13572g = hVar.getImageViewPool();
                this.f13573h = hVar.getTextViewPool();
                this.f13574i = hVar.getVoiceViewPool();
                this.j = hVar.getTextVoiceViewPool();
                this.l = hVar.getGifViewPool();
                this.k = hVar.getRelativeLayoutPool();
                if (hVar.getListView() != null && this.q == null) {
                    this.q = new b0(hVar.getRichTextViewId());
                    hVar.getListView().setRecyclerListener(this.q);
                }
            }
            this.S = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds21);
            setOrientation(1);
            setOnHierarchyChangeListener(new n(this));
        }
    }

    public final void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            setFaceSize(this.L ? TbConfig.getContentSizeOfLzl() : TbConfig.getContentSize());
        }
    }

    public final boolean I(TbRichTextData tbRichTextData, GifView gifView) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, tbRichTextData, gifView)) == null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) gifView.getLayoutParams();
            if (layoutParams != null && layoutParams.width == tbRichTextData.y().mGifInfo.mGifWidth && layoutParams.height == tbRichTextData.y().mGifInfo.mGifHeight) {
                layoutParams.bottomMargin = 0;
            } else {
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(tbRichTextData.y().mGifInfo.mGifWidth, tbRichTextData.y().mGifInfo.mGifHeight);
                layoutParams2.gravity = 3;
                gifView.setLayoutParams(layoutParams2);
            }
            gifView.setOnClickListener(new b(this, tbRichTextData));
            gifView.k0(tbRichTextData.y().mGifInfo);
            return true;
        }
        return invokeLL.booleanValue;
    }

    public final boolean J(TbRichTextData tbRichTextData, ImageView imageView, int i2, int i3, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{tbRichTextData, imageView, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z2)})) == null) {
            if (tbRichTextData == null || imageView == null || tbRichTextData.B() == null) {
                return false;
            }
            if (imageView instanceof TbImageView) {
                TbImageView tbImageView = (TbImageView) imageView;
                tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
                tbImageView.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
                tbImageView.setBorderSurroundContent(true);
                tbImageView.setDrawCorner(true);
                tbImageView.setDrawBorder(true);
                tbImageView.setLongIconSupport(true);
                tbImageView.setGifIconSupport(true);
                tbImageView.setTLIconType(tbRichTextData.A());
                tbImageView.setConrers(15);
                tbImageView.setRadius(this.S);
                if (this.Q) {
                    tbImageView.setPlaceHolder(2);
                } else {
                    tbImageView.setPlaceHolder(3);
                }
                if (this.f13570e.q) {
                    tbImageView.setSupportNoImage(true);
                }
                String w2 = this.f13570e.c() ? tbRichTextData.B().w() : tbRichTextData.B().y();
                if (!z2 || tbImageView.getUrl() == null || !tbImageView.getUrl().equals(w2)) {
                    tbImageView.M(w2, this.y ? 17 : 18, false);
                }
                if (!tbRichTextData.B().C()) {
                    tbImageView.setAdjustViewBounds(false);
                }
                tbImageView.setTag(R.id.tag_rich_text_meme_info, null);
            }
            return b0(imageView, tbRichTextData.B().getWidth(), tbRichTextData.B().getHeight(), i2, i3, this.j0);
        }
        return invokeCommon.booleanValue;
    }

    public final boolean K(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, tbRichTextData)) == null) {
            if (tbRichTextData == null || tbRichTextData.z() == null) {
                return false;
            }
            if (this.n == null) {
                ItemCardView itemCardView = new ItemCardView(getContext());
                this.n = itemCardView;
                itemCardView.setPosition(4);
                this.n.setOnClickListener(new c(this, tbRichTextData));
            }
            this.n.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            this.n.setOnClickListenerOfRightBtn(this.w);
            this.n.setIsShowRightBtn(this.W);
            this.n.setData(tbRichTextData.z(), 17, this.a0);
            this.n.x();
            return true;
        }
        return invokeL.booleanValue;
    }

    public final boolean L(TbRichTextData tbRichTextData, ImageView imageView, int i2, int i3) {
        InterceptResult invokeLLII;
        TbRichTextLinkImageInfo C;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(1048587, this, tbRichTextData, imageView, i2, i3)) == null) {
            if (tbRichTextData == null || imageView == null || (C = tbRichTextData.C()) == null || C.getLink() == null) {
                return false;
            }
            if (imageView instanceof TbImageView) {
                TbImageView tbImageView = (TbImageView) imageView;
                if (this.f13570e.q) {
                    tbImageView.setSupportNoImage(true);
                }
                tbImageView.M(C.w(), this.y ? 17 : 18, false);
                tbImageView.setTag(new v(C.getLink()));
                if (!C.x()) {
                    tbImageView.setAdjustViewBounds(false);
                }
            }
            return c0(imageView, C.getWidth(), C.getHeight(), i2, i3, this.l0);
        }
        return invokeLLII.booleanValue;
    }

    public final boolean M(TbRichTextData tbRichTextData, ImageView imageView, int i2, int i3) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(1048588, this, tbRichTextData, imageView, i2, i3)) == null) {
            if (tbRichTextData == null || imageView == null || tbRichTextData.D() == null) {
                return false;
            }
            if (imageView instanceof TbImageView) {
                TbImageView tbImageView = (TbImageView) imageView;
                tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
                tbImageView.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
                tbImageView.setBorderSurroundContent(true);
                tbImageView.setDrawCorner(true);
                tbImageView.setDrawBorder(true);
                tbImageView.setLongIconSupport(true);
                tbImageView.setGifIconSupport(true);
                tbImageView.setConrers(15);
                tbImageView.setRadius(this.S);
                if (this.Q) {
                    tbImageView.setPlaceHolder(2);
                } else {
                    tbImageView.setPlaceHolder(3);
                }
                if (this.f13570e.q) {
                    tbImageView.setSupportNoImage(true);
                }
                tbImageView.M(tbRichTextData.D().memeInfo.pic_url, this.y ? 17 : 18, false);
                tbImageView.setAdjustViewBounds(false);
                tbImageView.setTag(R.id.tag_rich_text_meme_info, tbRichTextData.D());
            }
            return c0(imageView, tbRichTextData.D().memeInfo.width.intValue(), tbRichTextData.D().memeInfo.height.intValue(), i2, i3, this.j0);
        }
        return invokeLLII.booleanValue;
    }

    public final boolean N(TbRichTextData tbRichTextData, GifView gifView, boolean z2) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048589, this, tbRichTextData, gifView, z2)) == null) {
            if (gifView == null) {
                return false;
            }
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                gifView.setDefaultNoImageDay(SkinManager.getNightResouceId(getContext().getResources(), R.drawable.icon_click));
            } else {
                gifView.setDefaultNoImageDay(R.drawable.icon_click);
            }
            Drawable drawable = SkinManager.getDrawable(R.color.CAM_X0209);
            if (drawable != null) {
                gifView.setBackgroundDrawable(drawable);
            } else {
                gifView.setBackgroundDrawable(SkinManager.getDrawable(R.color.common_color_10220));
            }
            String z3 = tbRichTextData.B().z();
            if (StringUtils.isNull(z3)) {
                d.a.p0.d1.m.a aVar = this.f13570e;
                if (aVar.C) {
                    z3 = aVar.r ? tbRichTextData.B().w() : tbRichTextData.B().x();
                }
                if (StringUtils.isNull(z3)) {
                    z3 = this.f13570e.r ? tbRichTextData.B().y() : tbRichTextData.B().B();
                }
            }
            gifView.setShowStaticDrawable(false);
            if (!z2 || gifView.getUrl() == null || !gifView.getUrl().equals(z3)) {
                gifView.l0(z3, 38);
            }
            int width = tbRichTextData.B().getWidth();
            int height = tbRichTextData.B().getHeight();
            d.a.p0.d1.m.a aVar2 = this.f13570e;
            return b0(gifView, width, height, aVar2.j, aVar2.k, this.j0);
        }
        return invokeLLZ.booleanValue;
    }

    public final boolean O(TbRichTextData tbRichTextData, TextView textView, boolean z2, t tVar) {
        InterceptResult invokeCommon;
        LinearLayout.LayoutParams layoutParams;
        SpannableStringBuilder E;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048590, this, new Object[]{tbRichTextData, textView, Boolean.valueOf(z2), tVar})) == null) {
            this.T = textView;
            if (z2) {
                layoutParams = new LinearLayout.LayoutParams(-1, -2);
            } else {
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
            }
            if (this.H) {
                layoutParams.gravity = 16;
                textView.setGravity(16);
            } else {
                layoutParams.topMargin = this.f13570e.f52381d;
            }
            d.a.p0.d1.m.a aVar = this.f13570e;
            textView.setLineSpacing(aVar.f52379b, aVar.f52378a);
            textView.setTextSize(0, this.f13570e.f52382e);
            if (this.f13570e.f52383f) {
                d.a.p0.s.u.c.d(textView).y(R.string.F_X02);
            }
            textView.setTextColor(this.f13570e.f52386i);
            textView.setLinkTextColor(SkinManager.getColor(R.color.CAM_X0304));
            textView.setHighlightColor(getContext().getResources().getColor(R.color.transparent));
            textView.setSingleLine(this.f13570e.n);
            if (this.N) {
                f0();
            }
            if (this.O) {
                e0();
            }
            TextUtils.TruncateAt truncateAt = this.p;
            if (truncateAt != null) {
                textView.setEllipsize(truncateAt);
            }
            if (this.U) {
                d.a.p0.s.u.c.d(textView).w(R.array.S_O_X001);
            }
            int i3 = this.I;
            if (i3 > 0) {
                textView.setMaxWidth(i3);
            }
            int i4 = this.J;
            if (i4 > 0) {
                textView.setMaxLines(i4);
            }
            if (tbRichTextData == null || (E = tbRichTextData.E()) == null || E.length() <= 0) {
                return false;
            }
            d.a.p0.d1.m.a aVar2 = this.f13570e;
            int i5 = aVar2.f52385h;
            if (i5 > 0 && (i2 = aVar2.f52384g) > 0) {
                tbRichTextData.M(i2, i5);
            }
            if (tVar != null) {
                tVar.S(E, textView, this);
            }
            try {
                textView.setText(E);
            } catch (Exception unused) {
                textView.setText("");
            }
            if (this.K) {
                if (tbRichTextData.J()) {
                    textView.setMovementMethod(d.a.q0.z3.c.a());
                } else {
                    textView.setMovementMethod(LinkMovementMethod.getInstance());
                }
            }
            textView.setFocusable(false);
            textView.setLayoutParams(layoutParams);
            textView.setTag(tbRichTextData);
            if (tbRichTextData == null || tbRichTextData.G() == null) {
                return true;
            }
            tbRichTextData.G().needRecompute = this.n0;
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public final boolean P(TbRichTextData tbRichTextData, LinearLayout linearLayout, t tVar) {
        InterceptResult invokeLLL;
        boolean Q;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048591, this, tbRichTextData, linearLayout, tVar)) == null) {
            if (linearLayout == null) {
                return false;
            }
            int childCount = linearLayout.getChildCount();
            boolean z2 = true;
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = linearLayout.getChildAt(i2);
                if (childAt != null) {
                    if (childAt instanceof TextView) {
                        Q = O(tbRichTextData, (TextView) childAt, false, tVar);
                    } else if (childAt.getClass().getSimpleName().equals("PlayVoiceBnt")) {
                        Q = Q(tbRichTextData, childAt);
                    } else if (childAt.getClass().getSimpleName().equals("PlayVoiceBntNew")) {
                        Q = Q(tbRichTextData, childAt);
                    }
                    z2 &= Q;
                }
            }
            return z2;
        }
        return invokeLLL.booleanValue;
    }

    public final boolean Q(TbRichTextData tbRichTextData, View view) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048592, this, tbRichTextData, view)) == null) {
            view.setTag(tbRichTextData.I());
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
            }
            view.setLayoutParams(layoutParams);
            if (view instanceof PlayVoiceBntNew) {
                ((PlayVoiceBntNew) view).b();
                return true;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public final boolean R(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, view)) == null) {
            if (view instanceof ImageView) {
                if (view instanceof GifView) {
                    return view.getTag(R.id.tag_rich_text_view_gif_view) != null && (view.getTag(R.id.tag_rich_text_view_gif_view) instanceof s) && ((s) view.getTag(R.id.tag_rich_text_view_gif_view)).f13597a;
                }
                if ((view instanceof TbImageView) && view.getTag() != null) {
                    if (view.getTag() instanceof v) {
                        return false;
                    }
                    if ((view.getTag() instanceof String) && TextUtils.equals("VideoView", (String) view.getTag())) {
                        return false;
                    }
                }
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void W() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.C = false;
            if (this.D == null) {
                this.D = new r(this);
            }
            postDelayed(this.D, ViewConfiguration.getLongPressTimeout());
        }
    }

    public final void X() {
        Runnable runnable;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048595, this) == null) || (runnable = this.D) == null) {
            return;
        }
        removeCallbacks(runnable);
    }

    public final void Y(RelativeLayout relativeLayout, int i2, int i3, int i4, int i5) {
        int[] l2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048596, this, new Object[]{relativeLayout, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) || (l2 = d.a.d.e.p.l.l(i2, i3, i4, i5)) == null) {
            return;
        }
        int[] iArr = {l2[0], l2[1]};
        int i6 = iArr[0];
        int i7 = iArr[1];
        if (this.f13570e.s && i4 > i6) {
            float f2 = t0;
            if (f2 > 1.0f) {
                float f3 = i6;
                float f4 = i4;
                if (f3 * f2 <= f4) {
                    float f5 = f4 * 0.68f;
                    i4 = f3 * f2 > f5 ? (int) f5 : (int) (f3 * f2);
                }
                if (iArr[0] > 0) {
                    i7 = (iArr[1] * i4) / iArr[0];
                }
                i6 = i4;
            }
        }
        relativeLayout.setLayoutParams(new LinearLayout.LayoutParams(i6, i7));
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x006a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void Z(RelativeLayout relativeLayout, int i2, int i3, int i4, int i5) {
        int[] l2;
        int i6;
        int i7;
        int g2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048597, this, new Object[]{relativeLayout, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) || (l2 = d.a.d.e.p.l.l(i2, i3, i4, i5)) == null) {
            return;
        }
        int[] iArr = {l2[0], l2[1]};
        int i8 = iArr[0];
        int i9 = iArr[1];
        if (this.f13570e.s && i4 > i8) {
            float f2 = t0;
            if (f2 > 1.0f) {
                float f3 = i8;
                float f4 = i4;
                if (f3 * f2 > f4) {
                    i7 = i4 - d.a.d.e.p.l.g(getContext(), R.dimen.ds78);
                    g2 = d.a.d.e.p.l.g(getContext(), R.dimen.ds16);
                } else {
                    float f5 = f4 * 0.68f;
                    if (f3 * f2 > f5) {
                        i7 = (int) f5;
                        g2 = d.a.d.e.p.l.g(getContext(), R.dimen.ds78);
                    } else {
                        i6 = (int) (f3 * f2);
                        if (iArr[0] > 0) {
                            i9 = (i6 * iArr[1]) / iArr[0];
                        }
                    }
                }
                i6 = i7 - g2;
                if (iArr[0] > 0) {
                }
            }
        }
        relativeLayout.setLayoutParams(new LinearLayout.LayoutParams(i4, i9));
    }

    public final boolean a0(ImageView imageView, int i2, int i3, int i4, int i5, View.OnClickListener onClickListener) {
        InterceptResult invokeCommon;
        View.OnLongClickListener onLongClickListener;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048598, this, new Object[]{imageView, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), onClickListener})) == null) {
            int[] l2 = d.a.d.e.p.l.l(i2, i3, i4, i5);
            if (l2 == null) {
                return false;
            }
            int[] iArr = {l2[0], l2[1]};
            int i6 = iArr[0];
            int i7 = iArr[1];
            if (this.f13570e.s && i4 > i6) {
                float f2 = t0;
                if (f2 > 1.0f) {
                    float f3 = i6;
                    float f4 = i4;
                    if (f3 * f2 > f4) {
                        i6 = (i4 - d.a.d.e.p.l.g(getContext(), R.dimen.ds78)) - d.a.d.e.p.l.g(getContext(), R.dimen.ds16);
                    } else {
                        float f5 = f4 * 0.68f;
                        i6 = f3 * f2 > f5 ? ((int) f5) - d.a.d.e.p.l.g(getContext(), R.dimen.ds78) : (int) (f3 * f2);
                    }
                    if (iArr[0] > 0) {
                        i7 = (iArr[1] * i6) / iArr[0];
                    }
                }
            }
            boolean z2 = imageView instanceof TbImageView;
            if (z2) {
                TbImageView tbImageView = (TbImageView) imageView;
                tbImageView.setDefaultResource(this.f13570e.l);
                if (tbImageView.getGifIconWidth() < i6 && tbImageView.getGifIconHeight() < i7) {
                    tbImageView.setGifIconSupport(true);
                } else {
                    tbImageView.setGifIconSupport(false);
                }
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i6, i7);
            if (this.f13570e.s) {
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            } else {
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            }
            imageView.setClickable(true);
            imageView.setFocusable(false);
            if (this.s != null && z2) {
                ((TbImageView) imageView).setTbGestureDetector(this.k0);
                imageView.setClickable(true);
            } else {
                imageView.setOnClickListener(onClickListener);
            }
            imageView.setLayoutParams(layoutParams);
            if (z2) {
                if (this.c0 != null) {
                    ((TbImageView) imageView).setDispatchTouchListener(this.m0);
                    imageView.setOnLongClickListener(this.c0);
                }
            } else if ((imageView instanceof GifView) && (onLongClickListener = this.c0) != null) {
                imageView.setOnLongClickListener(onLongClickListener);
            }
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public final boolean b0(ImageView imageView, int i2, int i3, int i4, int i5, View.OnClickListener onClickListener) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048599, this, new Object[]{imageView, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), onClickListener})) == null) {
            int[] e2 = this.f13570e.e(i2, i3, i4, i5);
            if (e2 == null) {
                return false;
            }
            int i6 = e2[0];
            int i7 = e2[1];
            boolean z2 = imageView instanceof TbImageView;
            if (z2) {
                TbImageView tbImageView = (TbImageView) imageView;
                if (tbImageView.getGifIconWidth() < i6 && tbImageView.getGifIconHeight() < i7) {
                    tbImageView.setGifIconSupport(true);
                } else {
                    tbImageView.setGifIconSupport(false);
                }
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i6, i7);
            d.a.p0.d1.m.a aVar = this.f13570e;
            if (aVar.s) {
                imageView.setScaleType(aVar.p);
                if (z2) {
                    ((TbImageView) imageView).setOnDrawListener(this.f13570e.F);
                }
            } else {
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            }
            imageView.setClickable(true);
            imageView.setFocusable(false);
            if (this.s != null && z2) {
                ((TbImageView) imageView).setTbGestureDetector(this.k0);
                imageView.setClickable(true);
            } else {
                imageView.setOnClickListener(onClickListener);
            }
            imageView.setLayoutParams(layoutParams);
            if (z2) {
                if (this.c0 != null) {
                    ((TbImageView) imageView).setDispatchTouchListener(this.m0);
                    imageView.setOnLongClickListener(this.c0);
                }
            } else if ((imageView instanceof GifView) && this.c0 != null) {
                ((GifView) imageView).setDispatchTouchListener(this.m0);
                imageView.setOnLongClickListener(this.c0);
            }
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public final boolean c0(ImageView imageView, int i2, int i3, int i4, int i5, View.OnClickListener onClickListener) {
        InterceptResult invokeCommon;
        View.OnLongClickListener onLongClickListener;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048600, this, new Object[]{imageView, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), onClickListener})) == null) {
            int[] l2 = d.a.d.e.p.l.l(i2, i3, i4, i5);
            if (l2 == null) {
                return false;
            }
            int[] iArr = {l2[0], l2[1]};
            int i6 = iArr[0];
            int i7 = iArr[1];
            if (this.f13570e.s && i4 > i6) {
                float f2 = t0;
                if (f2 > 1.0f) {
                    float f3 = i6;
                    float f4 = i4;
                    if (f3 * f2 <= f4) {
                        float f5 = f4 * 0.68f;
                        i4 = f3 * f2 > f5 ? (int) f5 : (int) (f3 * f2);
                    }
                    if (iArr[0] > 0) {
                        i7 = (iArr[1] * i4) / iArr[0];
                    }
                    i6 = i4;
                }
            }
            boolean z2 = imageView instanceof TbImageView;
            if (z2) {
                TbImageView tbImageView = (TbImageView) imageView;
                tbImageView.setDefaultResource(this.f13570e.l);
                if (tbImageView.getGifIconWidth() < i6 && tbImageView.getGifIconHeight() < i7) {
                    tbImageView.setGifIconSupport(true);
                } else {
                    tbImageView.setGifIconSupport(false);
                }
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i6, i7);
            if (this.f13570e.s) {
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            } else {
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            }
            imageView.setClickable(true);
            imageView.setFocusable(false);
            if (this.s != null && z2) {
                ((TbImageView) imageView).setTbGestureDetector(this.k0);
                imageView.setClickable(true);
            } else {
                imageView.setOnClickListener(onClickListener);
            }
            imageView.setLayoutParams(layoutParams);
            if (z2) {
                if (this.c0 != null) {
                    ((TbImageView) imageView).setDispatchTouchListener(this.m0);
                    imageView.setOnLongClickListener(this.c0);
                }
            } else if ((imageView instanceof GifView) && (onLongClickListener = this.c0) != null) {
                imageView.setOnLongClickListener(onLongClickListener);
            }
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public final void d0() {
        TextView textView;
        CharSequence subSequence;
        Object[] spans;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048601, this) == null) || this.J <= 1 || (textView = this.T) == null || textView.getLineCount() <= this.J) {
            return;
        }
        try {
            CharSequence subSequence2 = this.T.getText().subSequence(0, this.T.getLayout().getLineEnd(this.J - 1));
            Layout layout = this.T.getLayout();
            int lineStart = layout.getLineStart(this.J - 1);
            int lineEnd = layout.getLineEnd(this.J - 1);
            CharSequence subSequence3 = subSequence2.subSequence(0, lineStart);
            CharSequence cutChineseAndEnglishWithSuffix = StringHelper.cutChineseAndEnglishWithSuffix(subSequence2.subSequence(lineStart, lineEnd), StringHelper.getChineseAndEnglishLength(subSequence) - 6, "");
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder();
            spannableStringBuilder.append(subSequence3);
            spannableStringBuilder.append(cutChineseAndEnglishWithSuffix);
            int length = spannableStringBuilder.length();
            for (Object obj : spannableStringBuilder2.getSpans(length, subSequence2.length(), Object.class)) {
                int spanStart = spannableStringBuilder2.getSpanStart(obj);
                int spanEnd = spannableStringBuilder2.getSpanEnd(obj);
                if (spanStart < length && spanEnd >= length) {
                    break;
                }
                if (obj instanceof SpannableString) {
                    spannableStringBuilder.setSpan(obj, spanStart, spanEnd, ((SpannableString) obj).getSpanFlags(obj));
                }
            }
            spannableStringBuilder.append((CharSequence) StringHelper.STRING_MORE);
            SpannableString spannableString = new SpannableString("展开");
            spannableString.setSpan(this.b0, 0, spannableString.length(), 17);
            spannableStringBuilder.append((CharSequence) spannableString);
            this.T.setText(spannableStringBuilder);
        } catch (Exception unused) {
            this.T.setText(this.T.getText());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, motionEvent)) == null) {
            this.B = false;
            int action = motionEvent.getAction();
            if ((action == 1 || action == 3) && !this.C) {
                X();
            }
            boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
            if (motionEvent.getAction() == 0 && !this.B) {
                W();
            }
            return dispatchTouchEvent;
        }
        return invokeL.booleanValue;
    }

    public final void e0() {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048603, this) == null) || (textView = this.T) == null) {
            return;
        }
        textView.getViewTreeObserver().addOnGlobalLayoutListener(new a(this));
    }

    public final void f0() {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048604, this) == null) || (textView = this.T) == null) {
            return;
        }
        textView.getViewTreeObserver().addOnGlobalLayoutListener(new q(this));
    }

    public final void g0() {
        TextView textView;
        CharSequence text;
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048605, this) == null) || this.J <= 0 || (textView = this.T) == null || textView.getLineCount() <= this.J) {
            return;
        }
        try {
            text = this.T.getText().subSequence(0, this.T.getLayout().getLineEnd(this.J - 1) - 1);
            str = StringHelper.STRING_MORE;
        } catch (Exception unused) {
            text = this.T.getText();
            str = "";
        }
        TextUtils.TruncateAt ellipsize = this.T.getEllipsize();
        if (ellipsize == TextUtils.TruncateAt.START) {
            this.T.setText(str);
            this.T.append(text);
        } else if (ellipsize == TextUtils.TruncateAt.MIDDLE) {
            this.T.setText(text.subSequence(0, text.length() / 2));
            this.T.append(str);
            this.T.append(text.subSequence(text.length() / 2, text.length()));
        } else if (ellipsize == TextUtils.TruncateAt.END) {
            this.T.setText(text);
            this.T.append(str);
        }
    }

    public d.a.p0.d1.m.a getLayoutStrategy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.f13570e : (d.a.p0.d1.m.a) invokeV.objValue;
    }

    public z getOnImageClickListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.r : (z) invokeV.objValue;
    }

    public a0 getOnLinkImageClickListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.t : (a0) invokeV.objValue;
    }

    public d.a.q0.h2.a<ImageView> getRecycleImageViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            if (this.f13571f == null) {
                this.f13571f = new h(this, new g(this), 10, 0);
            }
            return this.f13571f;
        }
        return (d.a.q0.h2.a) invokeV.objValue;
    }

    public TbRichText getRichText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.G : (TbRichText) invokeV.objValue;
    }

    public TextView getTextView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (childAt instanceof TbListTextView) {
                    return (TbListTextView) childAt;
                }
            }
            return null;
        }
        return (TextView) invokeV.objValue;
    }

    public void h0(String str) {
        BdUniqueId bdUniqueId;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, str) == null) {
            if (TextUtils.isEmpty(str)) {
                this.p0 = str;
                return;
            }
            getContext();
            d.a.d.a.i c2 = d.a.d.a.j.c(getContext());
            if (c2 != null) {
                bdUniqueId = c2.getUniqueId();
                z2 = c2.isScroll();
            } else {
                bdUniqueId = null;
                z2 = false;
            }
            if (!(str.equals(this.p0) && this.q0 == bdUniqueId)) {
                j0();
            }
            this.p0 = str;
            this.q0 = bdUniqueId;
            setBackgroundDrawable(null);
            d.a.d.k.d.a aVar = (d.a.d.k.d.a) d.a.d.e.l.d.h().n(this.p0, 19, new Object[0]);
            if (aVar != null) {
                y(aVar);
            } else if (z2) {
                invalidate();
            } else if (!d.a.d.e.l.d.h().j(19)) {
                invalidate();
            } else {
                d.a.d.e.l.d.h().k(this.p0, 19, this.r0, 0, 0, this.q0, new Object[0]);
            }
        }
    }

    public void i0(String str, w wVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048613, this, str, wVar) == null) {
            this.i0 = wVar;
            h0(str);
        }
    }

    public void j0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048614, this) == null) || TextUtils.isEmpty(this.p0)) {
            return;
        }
        d.a.d.e.l.d.h().d(this.p0, 19, this.r0);
        setBackgroundDrawable(null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            super.onDetachedFromWindow();
            d.a.p0.d1.m.a aVar = this.f13570e;
            if (aVar != null) {
                aVar.d();
            }
            j0();
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048616, this, motionEvent)) == null) {
            if (this.C && (motionEvent.getAction() == 3 || motionEvent.getAction() == 1)) {
                return true;
            }
            return super.onInterceptTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            super.onStartTemporaryDetach();
            j0();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048618, this, motionEvent)) == null) {
            this.B = true;
            return super.onTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048619, this, i2) == null) {
            super.onWindowVisibilityChanged(i2);
            if (i2 != 8 && i2 != 4) {
                refresh();
            } else {
                j0();
            }
        }
    }

    @Override // d.a.d.f.a.i
    public void refresh() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            h0(this.p0);
        }
    }

    public void setAddExpandableListener(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048621, this, z2) == null) {
            this.O = z2;
        }
    }

    public void setAddTruncateListener(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048622, this, z2) == null) {
            this.N = z2;
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, drawable) == null) {
            super.setBackgroundDrawable(drawable);
            if (this.o0 != drawable) {
                this.n0 = true;
                this.o0 = drawable;
            }
            setText(this.G);
            this.n0 = false;
        }
    }

    public void setCommonTextViewOnClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, onClickListener) == null) {
            this.u = onClickListener;
        }
    }

    public void setDisplayImage(boolean z2, boolean z3) {
        d.a.d.e.k.b<ImageView> bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048625, this, new Object[]{Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) || this.x == z2) {
            return;
        }
        this.x = z2;
        if (z3) {
            requestLayout();
        }
        if (this.x || (bVar = this.f13572g) == null) {
            return;
        }
        bVar.c();
    }

    public void setDuiEnabled(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048626, this, z2) == null) {
            this.o = z2;
        }
    }

    public void setHasMovementMethod(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048627, this, z2) == null) {
            this.K = z2;
        }
    }

    public void setIsFromCDN(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048628, this, z2) == null) {
            this.y = z2;
            d.a.p0.d1.m.a aVar = this.f13570e;
            if (aVar != null) {
                aVar.r = z2;
            }
        }
    }

    public void setIsHost(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048629, this, z2) == null) {
            this.M = z2;
            GridImageLayout gridImageLayout = this.m;
            if (gridImageLayout != null) {
                gridImageLayout.setIsHost(z2);
            }
        }
    }

    public void setIsNeedResizeEmotion(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048630, this, z2) == null) {
            this.V = z2;
        }
    }

    public void setIsShowOrderOrDownloadBtn(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048631, this, z2) == null) {
            this.W = z2;
        }
    }

    public void setIsUseGridImage(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048632, this, z2) == null) {
            this.Q = z2;
        }
    }

    public void setItemOrderOrDownloadListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048633, this, onClickListener) == null) {
            this.w = onClickListener;
        }
    }

    public void setLayoutStrategy(d.a.p0.d1.m.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048634, this, aVar) == null) || aVar == null) {
            return;
        }
        this.f13570e.d();
        this.f13570e = aVar;
        H();
        GridImageLayout gridImageLayout = this.m;
        if (gridImageLayout != null) {
            gridImageLayout.setLayoutStrategy(this.f13570e);
        }
    }

    public void setLinkTextColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048635, this, i2) == null) {
            d.a.p0.d1.m.a aVar = this.f13570e;
            if (i2 == aVar.o) {
                return;
            }
            aVar.o = i2;
            int childCount = getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                if (childAt != null && (childAt instanceof TextView)) {
                    ((TextView) childAt).setLinkTextColor(i2);
                }
            }
        }
    }

    public void setMaxLines(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048636, this, i2) == null) {
            this.J = i2;
            TextView textView = this.T;
            if (textView != null) {
                textView.setMaxLines(i2);
            }
        }
    }

    public void setMaxWidth(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048637, this, i2) == null) {
            this.I = i2;
        }
    }

    public void setOnEmotionClickListener(y yVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048638, this, yVar) == null) {
            this.F = yVar;
        }
    }

    public void setOnImageClickListener(z zVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048639, this, zVar) == null) {
            this.r = zVar;
            GridImageLayout gridImageLayout = this.m;
            if (gridImageLayout != null) {
                gridImageLayout.setOnImageClickListener(zVar);
            }
        }
    }

    public void setOnImageTouchListener(d.a.q0.h2.i.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048640, this, cVar) == null) {
            this.s = cVar;
        }
    }

    public void setOnLinkImageClickListener(a0 a0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048641, this, a0Var) == null) {
            this.t = a0Var;
        }
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048642, this, onLongClickListener) == null) {
            this.c0 = onLongClickListener;
            super.setOnLongClickListener(onLongClickListener);
        }
    }

    public void setOnVoiceAfterClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048643, this, onClickListener) == null) {
            this.A = onClickListener;
        }
    }

    public void setSubPbPost(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048644, this, z2) == null) {
            this.L = z2;
            H();
        }
    }

    public void setText(TbRichText tbRichText) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048645, this, tbRichText) == null) {
            setText(tbRichText, false);
        }
    }

    public void setTextBold() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048649, this) == null) {
            this.f13570e.f52383f = true;
        }
    }

    public void setTextCenter(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048650, this, z2) == null) {
            this.H = z2;
        }
    }

    public void setTextColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048651, this, i2) == null) {
            d.a.p0.d1.m.a aVar = this.f13570e;
            if (i2 == aVar.f52386i) {
                return;
            }
            aVar.f52386i = i2;
            int childCount = getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                if (childAt != null && (childAt instanceof TextView)) {
                    ((TextView) childAt).setTextColor(i2);
                }
            }
        }
    }

    public void setTextEllipsize(TextUtils.TruncateAt truncateAt) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048652, this, truncateAt) == null) {
            this.p = truncateAt;
            TextView textView = this.T;
            if (textView != null) {
                textView.setEllipsize(truncateAt);
            }
        }
    }

    public void setTextPadding(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048653, this, i2) == null) {
            d.a.p0.d1.m.a aVar = this.f13570e;
            if (aVar.f52380c == i2) {
                return;
            }
            aVar.f52380c = i2;
            int childCount = getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                if (childAt != null && (childAt instanceof TextView)) {
                    int i4 = this.f13570e.f52380c;
                    ((TextView) childAt).setPadding(i4, 0, 0, i4);
                }
            }
        }
    }

    public void setTextSize(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048654, this, f2) == null) {
            setFaceSize(f2);
            d.a.p0.d1.m.a aVar = this.f13570e;
            if (f2 == aVar.f52382e) {
                return;
            }
            aVar.f52382e = f2;
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (childAt instanceof TextView) {
                    ((TextView) childAt).setTextSize(0, f2);
                }
            }
        }
    }

    public void setTextViewCheckSelection(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048655, this, z2) == null) {
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (childAt instanceof TbListTextView) {
                    ((TbListTextView) childAt).setCheckSelection(z2);
                }
            }
        }
    }

    public void setTextViewOnClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048656, this, onClickListener) == null) {
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (childAt instanceof TbListTextView) {
                    ((TbListTextView) childAt).setOnClickListener(onClickListener);
                }
            }
        }
    }

    public void setTextViewOnTouchListener(View.OnTouchListener onTouchListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048657, this, onTouchListener) == null) {
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (childAt instanceof TbListTextView) {
                    ((TbListTextView) childAt).setOnTouchListener(onTouchListener);
                }
            }
        }
    }

    public void setTid(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048658, this, str) == null) {
            this.a0 = str;
        }
    }

    public void setVoiceViewRes(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048659, this, i2) == null) {
            this.z = i2;
        }
    }

    public void setmGridEmptyClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048660, this, onClickListener) == null) {
            this.v = onClickListener;
        }
    }

    public void setmIsGridImageSupportLongPress(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048661, this, z2) == null) {
            this.R = z2;
        }
    }

    public final void y(d.a.d.k.d.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048662, this, aVar) == null) || aVar == null) {
            return;
        }
        try {
            NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(getResources(), aVar.p(), aVar.p().getNinePatchChunk(), aVar.o(), null);
            if (TbadkCoreApplication.getInst().getSkinType() == 1 || TbadkCoreApplication.getInst().getSkinType() == 4) {
                ninePatchDrawable.getPaint().setAlpha(80);
            }
            setBackgroundDrawable(ninePatchDrawable);
            w wVar = this.i0;
            if (wVar != null) {
                wVar.a();
            }
        } catch (Exception unused) {
        }
    }

    public void setText(TbRichText tbRichText, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048646, this, tbRichText, z2) == null) {
            setText(tbRichText, z2, null);
        }
    }

    public void setText(TbRichText tbRichText, boolean z2, t tVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048647, this, new Object[]{tbRichText, Boolean.valueOf(z2), tVar}) == null) {
            setText(tbRichText, z2, tVar, false, false);
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:260:0x0037 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:262:0x0037 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:184:0x04ab A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:194:0x04cd  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x04e7  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x012d  */
    /* JADX WARN: Type inference failed for: r0v127, types: [com.baidu.tbadk.gif.GifView, android.view.View] */
    /* JADX WARN: Type inference failed for: r0v155 */
    /* JADX WARN: Type inference failed for: r10v15, types: [android.widget.ImageView] */
    /* JADX WARN: Type inference failed for: r13v5 */
    /* JADX WARN: Type inference failed for: r26v0, types: [android.widget.LinearLayout, com.baidu.tbadk.widget.richText.TbRichTextView, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v64, types: [android.widget.ImageView] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void setText(TbRichText tbRichText, boolean z2, t tVar, boolean z3, boolean z4) {
        ArrayList<TbRichTextData> y2;
        d.a.q0.h2.a<ImageView> aVar;
        int i2;
        boolean O;
        SpannableStringBuilder E;
        TbRichTextData tbRichTextData;
        int i3;
        GridImageLayout gridImageLayout;
        TextView textView;
        int i4;
        LinearLayout linearLayout;
        RelativeLayout relativeLayout;
        int i5;
        RelativeLayout relativeLayout2;
        int i6;
        GifView gifView;
        Object A;
        boolean z5;
        boolean z6;
        Object obj;
        boolean z7;
        GifView gifView2;
        GifView gifView3;
        Object obj2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048648, this, new Object[]{tbRichText, Boolean.valueOf(z2), tVar, Boolean.valueOf(z3), Boolean.valueOf(z4)}) == null) {
            t tVar2 = tVar;
            if (this.G != tbRichText || (tbRichText != null && tbRichText.isChanged)) {
                if (tbRichText != null) {
                    tbRichText.isChanged = false;
                }
                this.G = tbRichText;
                removeAllViews();
                if (tbRichText == null || (y2 = tbRichText.y()) == null) {
                    return;
                }
                Iterator<TbRichTextData> it = y2.iterator();
                i iVar = null;
                boolean z8 = true;
                View view = null;
                View view2 = null;
                int i7 = 0;
                int i8 = 0;
                boolean z9 = false;
                boolean z10 = true;
                while (it.hasNext()) {
                    TbRichTextData next = it.next();
                    if (next != null) {
                        if (next.getType() == z8) {
                            TextView B = B(getContext());
                            O = O(next, B, z8, tVar2);
                            if (z2 && !this.E && (E = next.E()) != null) {
                                this.E = E.length() >= 200;
                            }
                            if (this.s != null) {
                                B.setOnTouchListener(this.k0);
                                textView = B;
                            } else {
                                B.setOnClickListener(this.u);
                                textView = B;
                            }
                        } else if (next.getType() == 8) {
                            if (this.Q) {
                                int i9 = i7;
                                if (z9) {
                                    i2 = i9;
                                    i7 = i2;
                                    view = view;
                                } else {
                                    GridImageLayout gridImageView = getGridImageView();
                                    gridImageView.setData(tbRichText.A());
                                    tbRichTextData = next;
                                    i7 = i9;
                                    O = true;
                                    z9 = true;
                                    gridImageLayout = gridImageView;
                                }
                            } else if (i8 < 10) {
                                i8++;
                                if (next.B() == null) {
                                    tbRichTextData = next;
                                    O = false;
                                    gridImageLayout = view;
                                } else if (TbadkCoreApplication.getInst().isGifAutoPlay() && !next.B().E()) {
                                    if (z4) {
                                        String z11 = next.B().z();
                                        if (StringUtils.isNull(z11)) {
                                            d.a.p0.d1.m.a aVar2 = this.f13570e;
                                            if (aVar2.C) {
                                                z11 = aVar2.r ? next.B().w() : next.B().x();
                                            }
                                            if (StringUtils.isNull(z11)) {
                                                z11 = this.f13570e.r ? next.B().y() : next.B().B();
                                            }
                                        }
                                        d.a.q0.h2.a<ImageView> aVar3 = this.f13571f;
                                        if (aVar3 != null) {
                                            Object obj3 = (ImageView) aVar3.h(z11);
                                            if (obj3 instanceof GifView) {
                                                obj2 = (GifView) obj3;
                                                if (obj2 != null) {
                                                    gifView3 = getGifView();
                                                } else {
                                                    z7 = true;
                                                    gifView2 = obj2;
                                                    s sVar = new s(iVar);
                                                    sVar.f13597a = z8;
                                                    gifView2.setTag(R.id.tag_rich_text_view_gif_view, sVar);
                                                    O = N(next, gifView2, z7);
                                                    textView = gifView2;
                                                    if (z3) {
                                                        u uVar = new u(iVar);
                                                        uVar.f13598a = z8;
                                                        gifView2.setTag(R.id.tag_rich_text_view_recycle, uVar);
                                                        textView = gifView2;
                                                    }
                                                }
                                            }
                                        }
                                        obj2 = iVar;
                                        if (obj2 != null) {
                                        }
                                    } else {
                                        gifView3 = getGifView();
                                    }
                                    z7 = false;
                                    gifView2 = gifView3;
                                    s sVar2 = new s(iVar);
                                    sVar2.f13597a = z8;
                                    gifView2.setTag(R.id.tag_rich_text_view_gif_view, sVar2);
                                    O = N(next, gifView2, z7);
                                    textView = gifView2;
                                    if (z3) {
                                    }
                                } else {
                                    if (z4) {
                                        String w2 = this.f13570e.c() ? next.B().w() : next.B().y();
                                        d.a.q0.h2.a<ImageView> aVar4 = this.f13571f;
                                        Object obj4 = aVar4 != null ? (ImageView) aVar4.h(w2) : iVar;
                                        if (obj4 == null) {
                                            z6 = false;
                                            obj = A(getContext());
                                        } else {
                                            z6 = true;
                                            obj = obj4;
                                        }
                                        A = obj;
                                        z5 = z6;
                                    } else {
                                        A = A(getContext());
                                        z5 = false;
                                    }
                                    d.a.p0.d1.m.a aVar5 = this.f13570e;
                                    ?? r10 = A;
                                    i4 = i7;
                                    O = J(next, A, aVar5.j, aVar5.k, z5);
                                    if (z3) {
                                        u uVar2 = new u(iVar);
                                        uVar2.f13598a = z8;
                                        r10.setTag(R.id.tag_rich_text_view_recycle, uVar2);
                                    }
                                    gifView = r10;
                                    tbRichTextData = next;
                                    i7 = i4;
                                    gridImageLayout = gifView;
                                }
                            }
                            view = gridImageLayout;
                            if (O && view != null) {
                                addView(view);
                                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
                                if (!z10 && (i3 = this.f13570e.A) >= 0) {
                                    if (layoutParams != null) {
                                        layoutParams.topMargin = i3;
                                        view.setLayoutParams(layoutParams);
                                    }
                                    z10 = false;
                                } else if (!(view instanceof TbListTextView)) {
                                    if (!(view2 instanceof ImageView) && !(view2 instanceof RelativeLayout)) {
                                        layoutParams.topMargin = this.f13570e.f52381d;
                                    } else {
                                        layoutParams.topMargin = this.f13570e.w;
                                    }
                                    view.setLayoutParams(layoutParams);
                                } else if ((!(view instanceof ImageView) && !(view instanceof RelativeLayout)) || (tbRichTextData.getType() != 8 && tbRichTextData.getType() != 20 && tbRichTextData.getType() != 17)) {
                                    if ((view instanceof ItemCardView) && !z10) {
                                        layoutParams.topMargin = this.f13570e.B;
                                        view.setLayoutParams(layoutParams);
                                    }
                                } else {
                                    if (view2 instanceof TbListTextView) {
                                        layoutParams.topMargin = this.f13570e.u;
                                    } else if (!(view2 instanceof ImageView) && !(view instanceof RelativeLayout)) {
                                        layoutParams.topMargin = this.f13570e.f52381d;
                                    } else {
                                        layoutParams.topMargin = this.f13570e.t;
                                    }
                                    view.setLayoutParams(layoutParams);
                                }
                                view2 = view;
                            }
                            tVar2 = tVar;
                            iVar = null;
                            z8 = true;
                        } else {
                            i4 = i7;
                            if (next.getType() == 32) {
                                d.a.p0.d1.m.i H = next.H();
                                if (H != null && H.i()) {
                                    tbRichTextData = next;
                                    linearLayout = E(H);
                                } else {
                                    tbRichTextData = next;
                                    linearLayout = C(tbRichTextData);
                                }
                                i7 = i4;
                                O = true;
                                gridImageLayout = linearLayout;
                                view = gridImageLayout;
                                if (O) {
                                    addView(view);
                                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) view.getLayoutParams();
                                    if (!z10) {
                                    }
                                    if (!(view instanceof TbListTextView)) {
                                    }
                                    view2 = view;
                                }
                                tVar2 = tVar;
                                iVar = null;
                                z8 = true;
                            } else {
                                tbRichTextData = next;
                                if (tbRichTextData.getType() == 512) {
                                    View D = D(view2);
                                    if (D == null) {
                                        i7 = i4;
                                        view = D;
                                    } else {
                                        O = Q(tbRichTextData, D);
                                        gifView = D;
                                    }
                                } else if (tbRichTextData.getType() == 768) {
                                    View textVoiceView = getTextVoiceView();
                                    O = P(tbRichTextData, (LinearLayout) textVoiceView, tVar2);
                                    gifView = textVoiceView;
                                } else if (tbRichTextData.getType() == 17) {
                                    GifView gifView4 = getGifView();
                                    O = I(tbRichTextData, gifView4);
                                    gifView = gifView4;
                                } else {
                                    if (tbRichTextData.getType() == 20) {
                                        i2 = i4;
                                        if (i2 >= 10) {
                                            i7 = i2;
                                            view = view;
                                        } else {
                                            int i10 = i2 + 1;
                                            boolean z12 = (tbRichTextData == null || tbRichTextData.D() == null || tbRichTextData.D().memeInfo == null || StringUtils.isNull(tbRichTextData.D().memeInfo.pic_url)) ? false : true;
                                            if (z12) {
                                                RelativeLayout b2 = this.k.b();
                                                b2.removeAllViews();
                                                b2.setLayoutParams(new LinearLayout.LayoutParams(tbRichTextData.D().memeInfo.width.intValue(), tbRichTextData.D().memeInfo.height.intValue()));
                                                if (DuiSwitch.getInOn() && this.o) {
                                                    int intValue = tbRichTextData.D().memeInfo.width.intValue();
                                                    int intValue2 = tbRichTextData.D().memeInfo.height.intValue();
                                                    d.a.p0.d1.m.a aVar6 = this.f13570e;
                                                    relativeLayout = b2;
                                                    Z(b2, intValue, intValue2, aVar6.j, aVar6.k);
                                                } else {
                                                    relativeLayout = b2;
                                                    int intValue3 = tbRichTextData.D().memeInfo.width.intValue();
                                                    int intValue4 = tbRichTextData.D().memeInfo.height.intValue();
                                                    d.a.p0.d1.m.a aVar7 = this.f13570e;
                                                    Y(relativeLayout, intValue3, intValue4, aVar7.j, aVar7.k);
                                                }
                                                ImageView b3 = this.f13572g.b();
                                                d.a.p0.d1.m.a aVar8 = this.f13570e;
                                                M(tbRichTextData, b3, aVar8.j, aVar8.k);
                                                if (DuiSwitch.getInOn() && this.o) {
                                                    ImageView b4 = this.f13572g.b();
                                                    b4.setTag(this.G);
                                                    if (b4 instanceof TbImageView) {
                                                        TbImageView tbImageView = (TbImageView) b4;
                                                        tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
                                                        tbImageView.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
                                                        tbImageView.setBorderSurroundContent(z8);
                                                        tbImageView.setDrawCorner(z8);
                                                        tbImageView.setDrawBorder(z8);
                                                        tbImageView.setLongIconSupport(z8);
                                                        tbImageView.setGifIconSupport(z8);
                                                        tbImageView.setConrers(15);
                                                        tbImageView.setRadius(this.S);
                                                        tbImageView.setAdjustViewBounds(false);
                                                        if (this.Q) {
                                                            tbImageView.setPlaceHolder(2);
                                                        } else {
                                                            tbImageView.setPlaceHolder(3);
                                                        }
                                                    }
                                                    b4.setScaleType(ImageView.ScaleType.FIT_XY);
                                                    int g2 = d.a.d.e.p.l.g(getContext(), R.dimen.ds78);
                                                    int g3 = d.a.d.e.p.l.g(getContext(), R.dimen.ds78);
                                                    b3.setId(R.id.meme_image_view);
                                                    int intValue5 = tbRichTextData.D().memeInfo.width.intValue();
                                                    int intValue6 = tbRichTextData.D().memeInfo.height.intValue();
                                                    d.a.p0.d1.m.a aVar9 = this.f13570e;
                                                    i5 = i8;
                                                    a0(b3, intValue5, intValue6, aVar9.j, aVar9.k, this.j0);
                                                    relativeLayout2 = relativeLayout;
                                                    relativeLayout2.addView(b3);
                                                    if (g3 > tbRichTextData.D().memeInfo.height.intValue()) {
                                                        g2 /= 2;
                                                        i6 = g3 / 2;
                                                    } else {
                                                        i6 = g3;
                                                    }
                                                    RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(g2, i6);
                                                    layoutParams3.addRule(8, R.id.meme_image_view);
                                                    layoutParams3.addRule(11);
                                                    b4.setOnClickListener(this.j0);
                                                    if (relativeLayout2.getLeft() > 0) {
                                                        layoutParams3.rightMargin = d.a.d.e.p.l.g(getContext(), R.dimen.ds6);
                                                    }
                                                    SkinManager.setImageResource(b4, R.drawable.icon_emotion_dui_n);
                                                    relativeLayout2.addView(b4, layoutParams3);
                                                } else {
                                                    i5 = i8;
                                                    relativeLayout2 = relativeLayout;
                                                    int intValue7 = tbRichTextData.D().memeInfo.width.intValue();
                                                    int intValue8 = tbRichTextData.D().memeInfo.height.intValue();
                                                    d.a.p0.d1.m.a aVar10 = this.f13570e;
                                                    c0(b3, intValue7, intValue8, aVar10.j, aVar10.k, this.j0);
                                                    relativeLayout2.addView(b3);
                                                }
                                                view = relativeLayout2;
                                                i7 = i10;
                                                O = z12;
                                                i8 = i5;
                                            } else {
                                                i7 = i10;
                                                O = z12;
                                                view = view;
                                            }
                                        }
                                    } else {
                                        int i11 = i8;
                                        if (tbRichTextData.getType() == 1280) {
                                            ImageView A2 = A(getContext());
                                            i8 = i11 + 1;
                                            i7 = i4;
                                            O = L(tbRichTextData, A2, (this.f13570e.j - getPaddingLeft()) - getPaddingRight(), this.f13570e.k);
                                            view = A2;
                                        } else if (tbRichTextData.getType() == 1281) {
                                            i7 = i4;
                                            i8 = i11;
                                            O = K(tbRichTextData);
                                            view = this.n;
                                        } else {
                                            i7 = i4;
                                            i8 = i11;
                                            O = false;
                                            view = view;
                                        }
                                    }
                                    if (O) {
                                    }
                                    tVar2 = tVar;
                                    iVar = null;
                                    z8 = true;
                                }
                                i7 = i4;
                                gridImageLayout = gifView;
                                view = gridImageLayout;
                                if (O) {
                                }
                                tVar2 = tVar;
                                iVar = null;
                                z8 = true;
                            }
                        }
                        tbRichTextData = next;
                        gridImageLayout = textView;
                        view = gridImageLayout;
                        if (O) {
                        }
                        tVar2 = tVar;
                        iVar = null;
                        z8 = true;
                    }
                    i2 = i7;
                    i7 = i2;
                    view = view;
                }
                if (view2 instanceof TbListTextView) {
                    LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) view2.getLayoutParams();
                    layoutParams4.bottomMargin = this.f13570e.z;
                    view2.setLayoutParams(layoutParams4);
                } else if (view2 != null && this.f13570e.y >= 0) {
                    LinearLayout.LayoutParams layoutParams5 = (LinearLayout.LayoutParams) view2.getLayoutParams();
                    layoutParams5.bottomMargin = this.f13570e.y;
                    view2.setLayoutParams(layoutParams5);
                }
                if (z3 || (aVar = this.f13571f) == null) {
                    return;
                }
                aVar.c();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TbRichTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f13570e = new d.a.p0.d1.m.a();
        this.f13571f = null;
        this.f13572g = null;
        this.f13573h = null;
        this.f13574i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.o = true;
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = null;
        this.v = null;
        this.w = null;
        this.x = true;
        this.y = true;
        this.z = -1;
        this.B = false;
        this.C = false;
        this.D = null;
        this.E = false;
        this.H = false;
        this.I = -1;
        this.J = -1;
        this.K = true;
        this.L = false;
        this.M = false;
        this.N = false;
        this.O = false;
        this.P = false;
        this.Q = false;
        this.R = false;
        this.U = false;
        this.V = false;
        this.W = false;
        this.b0 = new i(this, 2, null);
        this.j0 = new j(this);
        this.k0 = new d.a.q0.h2.i.c(new k(this));
        this.l0 = new l(this);
        this.m0 = new d(this);
        this.r0 = new e(this);
        this.s0 = new f(this, 2004018);
        G();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.TbRichTextView);
        this.f13570e.b(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        H();
    }
}
