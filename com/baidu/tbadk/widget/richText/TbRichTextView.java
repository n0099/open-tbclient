package com.baidu.tbadk.widget.richText;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Rect;
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
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.Fragment;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdPageContext;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.resourceLoader.BdResourceCallback;
import com.baidu.adp.lib.resourceLoader.BdResourceLoader;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ImageView.BdImage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ItemData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.ItemClickJumpUtil;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.view.ItemCardView;
import com.baidu.tbadk.core.view.itemcard.ItemCardHelper;
import com.baidu.tbadk.gif.GifInfo;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.switchs.DuiSwitch;
import com.baidu.tbadk.widget.ForeDrawableImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.TbListTextView;
import com.baidu.tbadk.widget.layout.GridImageLayout;
import com.baidu.tbadk.widget.tiejia.TiePlusEventController;
import com.baidu.tbadk.widget.tiejia.TiebaPlusRecommendCard;
import com.baidu.tieba.R;
import com.baidu.tieba.a5;
import com.baidu.tieba.abb;
import com.baidu.tieba.au9;
import com.baidu.tieba.m65;
import com.baidu.tieba.nwa;
import com.baidu.tieba.pb;
import com.baidu.tieba.py5;
import com.baidu.tieba.qb;
import com.baidu.tieba.qv4;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBnt;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.ux9;
import com.baidu.tieba.uy5;
import com.baidu.tieba.v9b;
import com.baidu.tieba.view.festivalview.FestivalTipView;
import com.baidu.tieba.wya;
import com.baidu.tieba.xy5;
import com.baidu.tieba.yab;
import com.baidu.tieba.yf;
import com.baidu.tieba.z4;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import tbclient.MemeInfo;
import tbclient.PbContent;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes5.dex */
public class TbRichTextView extends LinearLayout implements yf {
    public static /* synthetic */ Interceptable $ic;
    public static final float v0;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public Runnable B;
    public boolean C;
    public y D;
    public TbRichText E;
    public boolean F;
    public int G;
    public int H;
    public boolean I;
    public boolean J;
    public boolean K;
    public boolean L;
    public boolean M;
    public boolean N;
    public boolean O;
    public boolean P;
    public int Q;
    public TextView R;
    public boolean S;

    /* renamed from: T  reason: collision with root package name */
    public boolean f1081T;
    public boolean U;
    public String V;
    public String W;
    public py5 a;
    public Position a0;
    public au9<ImageView> b;
    public uy5 b0;
    public pb<ImageView> c;
    public View.OnLongClickListener c0;
    public pb<TextView> d;
    public w d0;
    public pb<View> e;
    public final View.OnClickListener e0;
    public pb<LinearLayout> f;
    public final ux9 f0;
    public pb<RelativeLayout> g;
    public final View.OnClickListener g0;
    public pb<GifView> h;
    public final x h0;
    public pb<TiebaPlusRecommendCard> i;
    public boolean i0;
    public GridImageLayout j;
    public Drawable j0;
    public pb<ItemCardView> k;
    public pb<FestivalTipView> l;
    public boolean m;
    public TextUtils.TruncateAt n;
    public c0 o;
    public z p;
    public ux9 q;
    public a0 r;
    public String r0;
    public View.OnClickListener s;
    public BdUniqueId s0;
    public View.OnClickListener t;
    public final BdResourceCallback<BdImage> t0;
    public View.OnClickListener u;
    public CustomMessageListener u0;
    public boolean v;
    public boolean w;
    public int x;
    public View.OnClickListener y;
    public boolean z;

    /* loaded from: classes5.dex */
    public interface a0 {
        void a(View view2, String str);
    }

    /* loaded from: classes5.dex */
    public interface t {
        void h1(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView);
    }

    /* loaded from: classes5.dex */
    public interface w {
        void a();

        void b();
    }

    /* loaded from: classes5.dex */
    public interface x {
        void dispatchTouchEvent(MotionEvent motionEvent);
    }

    /* loaded from: classes5.dex */
    public interface y {
        void a(View view2, String str, String str2, String str3, String str4, String str5, String str6, int i, int i2);
    }

    /* loaded from: classes5.dex */
    public interface z {
        void a(View view2, String str, int i, boolean z, boolean z2);
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes5.dex */
    public static final class Position {
        public static final /* synthetic */ Position[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final Position PB_COMMENT_FLOOR;
        public static final Position PB_FIRST_FLOOR;
        public static final Position SUB_PB;
        public transient /* synthetic */ FieldHolder $fh;
        public int index;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-110096088, "Lcom/baidu/tbadk/widget/richText/TbRichTextView$Position;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-110096088, "Lcom/baidu/tbadk/widget/richText/TbRichTextView$Position;");
                    return;
                }
            }
            PB_FIRST_FLOOR = new Position("PB_FIRST_FLOOR", 0, 1);
            PB_COMMENT_FLOOR = new Position("PB_COMMENT_FLOOR", 1, 2);
            Position position = new Position("SUB_PB", 2, 3);
            SUB_PB = position;
            $VALUES = new Position[]{PB_FIRST_FLOOR, PB_COMMENT_FLOOR, position};
        }

        public Position(String str, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.index = i2;
        }

        public static Position valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (Position) Enum.valueOf(Position.class, str);
            }
            return (Position) invokeL.objValue;
        }

        public static Position[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (Position[]) $VALUES.clone();
            }
            return (Position[]) invokeV.objValue;
        }

        public int getIndex() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.index;
            }
            return invokeV.intValue;
        }
    }

    /* loaded from: classes5.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbRichTextView a;

        public a(TbRichTextView tbRichTextView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbRichTextView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbRichTextView;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.o0();
            this.a.R.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }
    }

    /* loaded from: classes5.dex */
    public class b implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbRichTextView a;

        public b(TbRichTextView tbRichTextView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbRichTextView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbRichTextView;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.l0();
            this.a.R.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }
    }

    /* loaded from: classes5.dex */
    public static class b0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final WeakReference<TbRichTextView> a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b0(TbRichTextView tbRichTextView) {
            super(2004018);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbRichTextView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new WeakReference<>(tbRichTextView);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            TbRichTextView tbRichTextView;
            int contentSize;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || (tbRichTextView = this.a.get()) == null) {
                return;
            }
            if (tbRichTextView.J) {
                contentSize = TbConfig.getOutterSubpbContentSize();
            } else {
                contentSize = TbConfig.getContentSize();
            }
            if (tbRichTextView.E != null && !ListUtils.isEmpty(tbRichTextView.E.Q())) {
                Iterator<TbRichTextData> it = tbRichTextView.E.Q().iterator();
                while (it.hasNext()) {
                    TbRichTextData next = it.next();
                    if (next != null) {
                        next.k0(contentSize, contentSize);
                    }
                }
            }
            tbRichTextView.setTextSize(contentSize);
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbRichTextData a;
        public final /* synthetic */ TbRichTextView b;

        public c(TbRichTextView tbRichTextView, TbRichTextData tbRichTextData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbRichTextView, tbRichTextData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = tbRichTextView;
            this.a = tbRichTextData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.b.D != null) {
                TbRichTextEmotionInfo R = this.a.R();
                y yVar = this.b.D;
                GifInfo gifInfo = R.mGifInfo;
                yVar.a(view2, gifInfo.mGid, gifInfo.mPackageName, gifInfo.mIcon, gifInfo.mStaticUrl, gifInfo.mDynamicUrl, gifInfo.mSharpText, gifInfo.mGifWidth, gifInfo.mGifHeight);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class c0 implements AbsListView.RecyclerListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        public c0(int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = 0;
            this.a = i;
        }

        @Override // android.widget.AbsListView.RecyclerListener
        public void onMovedToScrapHeap(View view2) {
            View findViewById;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (findViewById = view2.findViewById(this.a)) != null && (findViewById instanceof TbRichTextView)) {
                ((TbRichTextView) findViewById).setText(null);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbRichTextData a;
        public final /* synthetic */ ItemCardView b;
        public final /* synthetic */ TbRichTextView c;

        public d(TbRichTextView tbRichTextView, TbRichTextData tbRichTextData, ItemCardView itemCardView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbRichTextView, tbRichTextData, itemCardView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = tbRichTextView;
            this.a = tbRichTextData;
            this.b = itemCardView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                int i = 0;
                if (this.a.getType() == 37) {
                    TiebaStatic.log(new StatisticItem("common_click").param("page_type", "a005").param(TiebaStatic.Params.GUA_TYPE, 4).param("obj_locate", 16));
                    int intValue = this.a.W().a().buttonLinkType.intValue();
                    if (this.a.W().a().apkDetail != null) {
                        i = this.a.W().a().apkDetail.pkg_source.intValue();
                    }
                    ItemCardHelper.q(this.b.getPosition(), this.a.W().a().itemId, this.b.D(this.a.W().a()), this.c.V, m65.a(intValue, i), "", 2);
                    ItemClickJumpUtil.itemClickJump(this.a.W().a().forumName, String.valueOf(this.a.W().a().itemId), 3, 3);
                } else if (this.a.getType() == 1281) {
                    TiebaStatic.log(new StatisticItem("common_click").param("page_type", "a005").param(TiebaStatic.Params.GUA_TYPE, 2).param("obj_locate", 16));
                    int intValue2 = this.a.S().getItem().button_link_type.intValue();
                    if (this.a.S().getItem().apk_detail != null) {
                        i = this.a.S().getItem().apk_detail.pkg_source.intValue();
                    }
                    int a = m65.a(intValue2, i);
                    ItemData itemData = new ItemData();
                    itemData.parseProto(this.a.S().getItem());
                    ItemCardHelper.q(this.b.getPosition(), this.a.S().getItem().item_id.longValue(), this.b.D(itemData), this.c.V, a, "", 2);
                    ItemClickJumpUtil.itemClickJump(this.a.S().getItemForumName(), this.a.S().getItemID(), 3, 3);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements x {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbRichTextView a;

        public e(TbRichTextView tbRichTextView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbRichTextView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbRichTextView;
        }

        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.x
        public void dispatchTouchEvent(MotionEvent motionEvent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, motionEvent) == null) {
                if (motionEvent.getAction() != 0) {
                    if (motionEvent.getAction() != 1 && motionEvent.getAction() != 3) {
                        return;
                    }
                    this.a.N = false;
                    return;
                }
                this.a.N = true;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f extends BdResourceCallback<BdImage> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbRichTextView a;

        public f(TbRichTextView tbRichTextView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbRichTextView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbRichTextView;
        }

        @Override // com.baidu.adp.lib.resourceLoader.BdResourceCallback
        public void onCancelled(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                super.onCancelled(str);
            }
        }

        @Override // com.baidu.adp.lib.resourceLoader.BdResourceCallback
        public void onProgressUpdate(Object... objArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, objArr) == null) {
                super.onProgressUpdate(objArr);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.resourceLoader.BdResourceCallback
        public void onLoaded(BdImage bdImage, String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdImage, str, i) == null) {
                if (bdImage == null) {
                    if (this.a.d0 != null) {
                        this.a.d0.a();
                    }
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.PB_FIRST_FLOOR_BUBBLE_LOAD_FAIL).param("tid", this.a.V).param(TiebaStatic.Params.OBJ_URL, str));
                    return;
                }
                this.a.F(bdImage);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements qb<ImageView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbRichTextView a;

        public ImageView h(ImageView imageView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, imageView)) == null) ? imageView : (ImageView) invokeL.objValue;
        }

        public g(TbRichTextView tbRichTextView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbRichTextView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbRichTextView;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.qb
        public /* bridge */ /* synthetic */ ImageView a(ImageView imageView) {
            ImageView imageView2 = imageView;
            e(imageView2);
            return imageView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.qb
        public /* bridge */ /* synthetic */ ImageView c(ImageView imageView) {
            ImageView imageView2 = imageView;
            h(imageView2);
            return imageView2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.qb
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
                    foreDrawableImageView.stopLoading();
                    foreDrawableImageView.setForegroundDrawable(0);
                    foreDrawableImageView.setDefaultBgResource(R.color.common_color_10220);
                }
            }
        }

        public ImageView e(ImageView imageView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, imageView)) == null) {
                if (imageView instanceof TbImageView) {
                    TbImageView tbImageView = (TbImageView) imageView;
                    tbImageView.setTag(null);
                    if (qv4.c().g()) {
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
        @Override // com.baidu.tieba.qb
        /* renamed from: g */
        public ImageView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(a5.a(this.a.getContext()).getPageActivity());
                boolean g = qv4.c().g();
                foreDrawableImageView.setDefaultBg(SkinManager.getDrawable(R.color.common_color_10220));
                if (g) {
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
    }

    /* loaded from: classes5.dex */
    public class h extends au9<ImageView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbRichTextView e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(TbRichTextView tbRichTextView, qb qbVar, int i, int i2) {
            super(qbVar, i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbRichTextView, qbVar, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((qb) objArr2[0], ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = tbRichTextView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.au9
        /* renamed from: i */
        public ImageView h(Object obj) {
            InterceptResult invokeL;
            ImageView imageView;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
                if (obj instanceof String) {
                    Iterator it = this.c.iterator();
                    while (it.hasNext()) {
                        imageView = (ImageView) it.next();
                        if ((imageView instanceof TbImageView) && obj.equals(((TbImageView) imageView).getUrl())) {
                            break;
                        }
                    }
                }
                imageView = null;
                this.c.remove(imageView);
                return imageView;
            }
            return (ImageView) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class i extends uy5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbRichTextView n;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(TbRichTextView tbRichTextView, int i, String str) {
            super(i, str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbRichTextView, Integer.valueOf(i), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), (String) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.n = tbRichTextView;
        }

        @Override // com.baidu.tieba.uy5, android.text.style.ClickableSpan
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.n.setAddExpandableListener(false);
                this.n.setTextEllipsize(TextUtils.TruncateAt.END);
                this.n.setMaxLines(5);
                this.n.setAddTruncateListener(true);
                this.n.E.isChanged = true;
                TbRichTextView tbRichTextView = this.n;
                tbRichTextView.setText(tbRichTextView.E);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class j implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbRichTextView a;

        public j(TbRichTextView tbRichTextView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbRichTextView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbRichTextView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            String str;
            MemeInfo memeInfo;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.p != null && (view2 instanceof ImageView)) {
                String str2 = null;
                Object tag = view2.getTag();
                int i = 0;
                int i2 = -1;
                if (tag != null && (tag instanceof TbRichText)) {
                    int childCount = this.a.getChildCount();
                    while (i < childCount) {
                        i2++;
                        if (view2.getParent() == this.a.getChildAt(i)) {
                            break;
                        }
                        i++;
                    }
                    this.a.p.a(view2, null, i2, this.a.K, false);
                    return;
                }
                if (tag != null && (tag instanceof String)) {
                    str2 = (String) tag;
                } else {
                    boolean z = view2 instanceof TbImageView;
                    if (z && (view2.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextMemeInfo)) {
                        TbRichTextMemeInfo tbRichTextMemeInfo = (TbRichTextMemeInfo) view2.getTag(R.id.tag_rich_text_meme_info);
                        if (tbRichTextMemeInfo != null && (memeInfo = tbRichTextMemeInfo.memeInfo) != null) {
                            str = memeInfo.pic_url;
                        } else {
                            str = "";
                        }
                        String str3 = str;
                        int childCount2 = this.a.getChildCount();
                        while (i < childCount2) {
                            i2++;
                            if (view2.getParent() == this.a.getChildAt(i)) {
                                break;
                            }
                            i++;
                        }
                        this.a.p.a(view2, str3, i2, this.a.K, false);
                        return;
                    } else if (z) {
                        str2 = ((TbImageView) view2).getUrl();
                    } else if (view2 instanceof GifView) {
                        str2 = ((GifView) view2).getUrl();
                    }
                }
                String str4 = str2;
                int childCount3 = this.a.getChildCount();
                while (i < childCount3) {
                    View childAt = this.a.getChildAt(i);
                    if (this.a.X(childAt)) {
                        i2++;
                    }
                    if (view2 == childAt) {
                        break;
                    }
                    i++;
                }
                this.a.p.a(view2, str4, i2, this.a.K, false);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class k implements ux9.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbRichTextView a;

        @Override // com.baidu.tieba.ux9.a
        public boolean a(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                return false;
            }
            return invokeLL.booleanValue;
        }

        public k(TbRichTextView tbRichTextView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbRichTextView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbRichTextView;
        }

        @Override // com.baidu.tieba.ux9.a
        public boolean b(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, motionEvent)) == null) {
                if (this.a.e0 != null) {
                    this.a.e0.onClick(view2);
                    return true;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }

        @Override // com.baidu.tieba.ux9.a
        public boolean c(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view2, motionEvent)) == null) {
                if (this.a.q != null) {
                    this.a.q.a(view2);
                    return this.a.q.onDoubleTap(motionEvent);
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class l implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbRichTextView a;

        public l(TbRichTextView tbRichTextView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbRichTextView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbRichTextView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.r != null && (view2 instanceof TbImageView)) {
                String str = null;
                Object tag = view2.getTag();
                if (tag != null && (tag instanceof v)) {
                    str = ((v) tag).a;
                }
                this.a.r.a(view2, str);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class m implements qb<TextView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;

        public TextView e(TextView textView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, textView)) == null) ? textView : (TextView) invokeL.objValue;
        }

        public m(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = context;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.qb
        public /* bridge */ /* synthetic */ TextView a(TextView textView) {
            TextView textView2 = textView;
            e(textView2);
            return textView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.qb
        public /* bridge */ /* synthetic */ TextView c(TextView textView) {
            TextView textView2 = textView;
            h(textView2);
            return textView2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.qb
        /* renamed from: g */
        public TextView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return new TbListTextView(this.a);
            }
            return (TextView) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.qb
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

    /* loaded from: classes5.dex */
    public class n implements qb<FestivalTipView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ int b;

        public FestivalTipView e(FestivalTipView festivalTipView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, festivalTipView)) == null) ? festivalTipView : (FestivalTipView) invokeL.objValue;
        }

        public n(Context context, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = context;
            this.b = i;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.qb
        public /* bridge */ /* synthetic */ FestivalTipView a(FestivalTipView festivalTipView) {
            FestivalTipView festivalTipView2 = festivalTipView;
            e(festivalTipView2);
            return festivalTipView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.qb
        public /* bridge */ /* synthetic */ FestivalTipView c(FestivalTipView festivalTipView) {
            FestivalTipView festivalTipView2 = festivalTipView;
            h(festivalTipView2);
            return festivalTipView2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.qb
        /* renamed from: f */
        public void b(FestivalTipView festivalTipView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, festivalTipView) == null) {
                festivalTipView.h();
            }
        }

        public FestivalTipView h(FestivalTipView festivalTipView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, festivalTipView)) == null) {
                festivalTipView.h();
                return festivalTipView;
            }
            return (FestivalTipView) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.qb
        /* renamed from: g */
        public FestivalTipView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                FestivalTipView festivalTipView = new FestivalTipView(this.a);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                layoutParams.topMargin = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), this.b);
                festivalTipView.setLayoutParams(layoutParams);
                return festivalTipView;
            }
            return (FestivalTipView) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class o implements ViewGroup.OnHierarchyChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbRichTextView a;

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewAdded(View view2, View view3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, view2, view3) == null) {
            }
        }

        public o(TbRichTextView tbRichTextView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbRichTextView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbRichTextView;
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewRemoved(View view2, View view3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, view3) == null) {
                if (view3 instanceof GifView) {
                    Object tag = view3.getTag(R.id.tag_rich_text_view_recycle);
                    if ((tag instanceof u) && ((u) tag).a) {
                        if (this.a.b == null) {
                            TbRichTextView tbRichTextView = this.a;
                            tbRichTextView.b = tbRichTextView.getRecycleImageViewPool();
                        }
                        this.a.b.e((ImageView) view3);
                    } else if (this.a.h != null) {
                        this.a.h.e((GifView) view3);
                    }
                } else if (view3 instanceof ImageView) {
                    Object tag2 = view3.getTag(R.id.tag_rich_text_view_recycle);
                    if ((tag2 instanceof u) && ((u) tag2).a) {
                        if (this.a.b == null) {
                            TbRichTextView tbRichTextView2 = this.a;
                            tbRichTextView2.b = tbRichTextView2.getRecycleImageViewPool();
                        }
                        this.a.b.e((ImageView) view3);
                    } else if (this.a.c != null) {
                        this.a.c.e((ImageView) view3);
                    }
                } else if ((view3 instanceof TextView) && this.a.d != null) {
                    this.a.d.e((TextView) view3);
                } else if ((view3 instanceof PlayVoiceBnt) && this.a.e != null) {
                    this.a.e.e(view3);
                } else if ((view3 instanceof PlayVoiceBntNew) && this.a.e != null) {
                    this.a.e.e(view3);
                } else if (view3 instanceof GridImageLayout) {
                    GridImageLayout gridImageLayout = (GridImageLayout) view3;
                    int childCount = gridImageLayout.getChildCount();
                    for (int i = 0; i < childCount; i++) {
                        View childAt = gridImageLayout.getChildAt(i);
                        if ((childAt instanceof GifView) && this.a.h != null) {
                            this.a.h.e((GifView) childAt);
                        } else if ((childAt instanceof ImageView) && this.a.c != null) {
                            this.a.c.e((ImageView) childAt);
                        }
                    }
                    gridImageLayout.removeAllViews();
                    gridImageLayout.g();
                } else if ((view3 instanceof TiebaPlusRecommendCard) && this.a.i != null) {
                    this.a.i.e((TiebaPlusRecommendCard) view3);
                } else if ((view3 instanceof RelativeLayout) && this.a.g != null) {
                    this.a.g.e((RelativeLayout) view3);
                } else if ((view3 instanceof ItemCardView) && this.a.k != null) {
                    this.a.k.e((ItemCardView) view3);
                } else if ((view3 instanceof FestivalTipView) && this.a.l != null) {
                    this.a.l.e((FestivalTipView) view3);
                }
                if ((view3 instanceof LinearLayout) && !(view3 instanceof ItemCardView) && !(view3 instanceof FestivalTipView)) {
                    Object tag3 = view3.getTag();
                    if (tag3 != null && (tag3 instanceof String) && "VideoView".equals(tag3)) {
                        view3.setBackgroundDrawable(null);
                    } else if (this.a.f != null) {
                        LinearLayout linearLayout = (LinearLayout) view3;
                        int childCount2 = linearLayout.getChildCount();
                        for (int i2 = 0; i2 < childCount2; i2++) {
                            View childAt2 = linearLayout.getChildAt(i2);
                            if (childAt2 != null) {
                                if ((childAt2 instanceof TextView) && this.a.d != null) {
                                    this.a.d.e((TextView) childAt2);
                                } else if ((childAt2 instanceof PlayVoiceBnt) && this.a.e != null) {
                                    this.a.e.e(childAt2);
                                } else if ((childAt2 instanceof PlayVoiceBntNew) && this.a.e != null) {
                                    this.a.e.e(childAt2);
                                }
                            }
                        }
                        linearLayout.removeAllViews();
                        this.a.f.e(linearLayout);
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class p implements yab {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbRichTextData a;
        public final /* synthetic */ TbRichTextView b;

        public p(TbRichTextView tbRichTextView, TbRichTextData tbRichTextData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbRichTextView, tbRichTextData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = tbRichTextView;
            this.a = tbRichTextData;
        }

        @Override // com.baidu.tieba.yab
        public void onClick(@NonNull View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.T() != null && !TextUtils.isEmpty(this.a.T().c()) && (this.b.getContext() instanceof TbPageContextSupport)) {
                    TbPageContext<?> pageContext = ((TbPageContextSupport) this.b.getContext()).getPageContext();
                    if (pageContext == null) {
                        return;
                    }
                    UrlManager.getInstance().dealOneLink(pageContext, new String[]{this.a.T().c()});
                }
                abb.a(this.b.V, this.b.W, this.b.a0);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class q implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbRichTextData a;
        public final /* synthetic */ TbRichTextView b;

        public q(TbRichTextView tbRichTextView, TbRichTextData tbRichTextData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbRichTextView, tbRichTextData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = tbRichTextView;
            this.a = tbRichTextData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.Z() != null) {
                if (this.b.getContext() instanceof xy5) {
                    ((xy5) this.b.getContext()).d0(this.b.getContext(), this.a.Z().toString());
                    return;
                }
                BdPageContext<?> a = a5.a(this.b.getContext());
                if (a != null && (a.getOrignalPage() instanceof xy5)) {
                    ((xy5) a.getOrignalPage()).d0(this.b.getContext(), this.a.Z().toString());
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class r implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbRichTextView a;

        public r(TbRichTextView tbRichTextView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbRichTextView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbRichTextView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.a.N || !this.a.performLongClick()) {
                return;
            }
            this.a.A = true;
        }
    }

    /* loaded from: classes5.dex */
    public static class s {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;

        public s() {
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

        public /* synthetic */ s(i iVar) {
            this();
        }
    }

    /* loaded from: classes5.dex */
    public static class u {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;

        public u() {
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

        public /* synthetic */ u(i iVar) {
            this();
        }
    }

    /* loaded from: classes5.dex */
    public static class v {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        public v(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
        }
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
        v0 = BdUtilHelper.getEquipmentDensity(TbadkCoreApplication.getInst());
    }

    private ItemCardView getItemCardView() {
        InterceptResult invokeV;
        ItemCardView itemCardView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65562, this)) == null) {
            pb<ItemCardView> pbVar = this.k;
            if (pbVar != null) {
                itemCardView = pbVar.b();
            } else {
                itemCardView = null;
            }
            if (itemCardView != null) {
                itemCardView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            }
            return itemCardView;
        }
        return (ItemCardView) invokeV.objValue;
    }

    public boolean L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.C;
        }
        return invokeV.booleanValue;
    }

    public final void N() {
        int contentSize;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (this.J) {
                contentSize = TbConfig.getContentSizeOfLzl();
            } else {
                contentSize = TbConfig.getContentSize();
            }
            setFaceSize(contentSize);
        }
    }

    public final void e0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.A = false;
            if (this.B == null) {
                this.B = new r(this);
            }
            postDelayed(this.B, ViewConfiguration.getLongPressTimeout());
        }
    }

    public final void f0() {
        Runnable runnable;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048595, this) == null) && (runnable = this.B) != null) {
            removeCallbacks(runnable);
        }
    }

    public py5 getLayoutStrategy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.a;
        }
        return (py5) invokeV.objValue;
    }

    public z getOnImageClickListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.p;
        }
        return (z) invokeV.objValue;
    }

    public a0 getOnLinkImageClickListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.r;
        }
        return (a0) invokeV.objValue;
    }

    public au9<ImageView> getRecycleImageViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            if (this.b == null) {
                this.b = new h(this, new g(this), 10, 0);
            }
            return this.b;
        }
        return (au9) invokeV.objValue;
    }

    public TbRichText getRichText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return this.E;
        }
        return (TbRichText) invokeV.objValue;
    }

    public TextView getTextView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
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

    public final void m0() {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048608, this) == null) && (textView = this.R) != null) {
            textView.getViewTreeObserver().addOnGlobalLayoutListener(new b(this));
        }
    }

    public final void n0() {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048609, this) == null) && (textView = this.R) != null) {
            textView.getViewTreeObserver().addOnGlobalLayoutListener(new a(this));
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            super.onDetachedFromWindow();
            py5 py5Var = this.a;
            if (py5Var != null) {
                py5Var.e();
            }
            r0();
        }
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            super.onStartTemporaryDetach();
            r0();
        }
    }

    public void r0() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048618, this) != null) || TextUtils.isEmpty(this.r0)) {
            return;
        }
        BdResourceLoader.getInstance().cancelLoad(this.r0, 19, this.t0);
        setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.yf
    public void refresh() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            p0(this.r0);
        }
    }

    public void setFestivalTipViewSkin() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048627, this) == null) {
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (childAt instanceof FestivalTipView) {
                    ((FestivalTipView) childAt).b(true);
                }
            }
        }
    }

    public void setTextBold() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048652, this) == null) {
            this.a.g = true;
        }
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
        this.a = new py5();
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.k = null;
        this.m = true;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = null;
        this.v = true;
        this.w = true;
        this.x = -1;
        this.z = false;
        this.A = false;
        this.B = null;
        this.C = false;
        this.F = false;
        this.G = -1;
        this.H = -1;
        this.I = true;
        this.J = false;
        this.K = false;
        this.L = false;
        this.M = false;
        this.N = false;
        this.O = false;
        this.P = false;
        this.S = false;
        this.f1081T = false;
        this.U = false;
        this.b0 = new i(this, 2, null);
        this.e0 = new j(this);
        this.f0 = new ux9(new k(this));
        this.g0 = new l(this);
        this.h0 = new e(this);
        this.t0 = new f(this);
        this.u0 = new b0(this);
        M();
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
        this.a = new py5();
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.k = null;
        this.m = true;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = null;
        this.v = true;
        this.w = true;
        this.x = -1;
        this.z = false;
        this.A = false;
        this.B = null;
        this.C = false;
        this.F = false;
        this.G = -1;
        this.H = -1;
        this.I = true;
        this.J = false;
        this.K = false;
        this.L = false;
        this.M = false;
        this.N = false;
        this.O = false;
        this.P = false;
        this.S = false;
        this.f1081T = false;
        this.U = false;
        this.b0 = new i(this, 2, null);
        this.e0 = new j(this);
        this.f0 = new ux9(new k(this));
        this.g0 = new l(this);
        this.h0 = new e(this);
        this.t0 = new f(this);
        this.u0 = new b0(this);
        M();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, wya.TbRichTextView);
        this.a.c(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        N();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048612, this, motionEvent)) == null) {
            if (this.A && (motionEvent.getAction() == 3 || motionEvent.getAction() == 1)) {
                return true;
            }
            return super.onInterceptTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048614, this, motionEvent)) == null) {
            this.z = true;
            return super.onTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048615, this, i2) == null) {
            super.onWindowVisibilityChanged(i2);
            if (i2 != 8 && i2 != 4) {
                refresh();
            } else {
                r0();
            }
        }
    }

    public void setAddExpandableListener(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048620, this, z2) == null) {
            this.M = z2;
        }
    }

    public void setAddTruncateListener(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048621, this, z2) == null) {
            this.L = z2;
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, drawable) == null) {
            super.setBackgroundDrawable(drawable);
            if (this.j0 != drawable) {
                this.i0 = true;
                this.j0 = drawable;
            }
            setText(this.E);
            this.i0 = false;
        }
    }

    public void setCommonTextViewOnClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, onClickListener) == null) {
            this.s = onClickListener;
        }
    }

    public void setDuiEnabled(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048625, this, z2) == null) {
            this.m = z2;
        }
    }

    public void setFaceSize(float f2) {
        int emotionContentSize;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048626, this, f2) == null) {
            if (this.f1081T) {
                if (this.J) {
                    emotionContentSize = TbConfig.getEmotionContentSizeOfLzl();
                } else {
                    emotionContentSize = TbConfig.getEmotionContentSize();
                }
                py5 py5Var = this.a;
                py5Var.h = emotionContentSize;
                py5Var.i = emotionContentSize;
                return;
            }
            py5 py5Var2 = this.a;
            int i2 = (int) f2;
            py5Var2.h = i2;
            py5Var2.i = i2;
        }
    }

    public void setHasMovementMethod(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048628, this, z2) == null) {
            this.I = z2;
        }
    }

    public void setIsFromCDN(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048629, this, z2) == null) {
            this.w = z2;
            py5 py5Var = this.a;
            if (py5Var != null) {
                py5Var.u = z2;
            }
        }
    }

    public void setIsHost(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048630, this, z2) == null) {
            this.K = z2;
            GridImageLayout gridImageLayout = this.j;
            if (gridImageLayout != null) {
                gridImageLayout.setIsHost(z2);
            }
        }
    }

    public void setIsNeedResizeEmotion(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048631, this, z2) == null) {
            this.f1081T = z2;
        }
    }

    public void setIsShowOrderOrDownloadBtn(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048632, this, z2) == null) {
            this.U = z2;
        }
    }

    public void setIsUseGridImage(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048633, this, z2) == null) {
            this.O = z2;
        }
    }

    public void setItemOrderOrDownloadListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048634, this, onClickListener) == null) {
            this.u = onClickListener;
        }
    }

    public void setLayoutStrategy(py5 py5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048635, this, py5Var) == null) && py5Var != null) {
            this.a.e();
            this.a = py5Var;
            N();
            GridImageLayout gridImageLayout = this.j;
            if (gridImageLayout != null) {
                gridImageLayout.setLayoutStrategy(this.a);
            }
        }
    }

    public void setLinkTextColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048636, this, i2) == null) {
            py5 py5Var = this.a;
            if (i2 == py5Var.r) {
                return;
            }
            py5Var.r = i2;
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
        if (interceptable == null || interceptable.invokeI(1048637, this, i2) == null) {
            this.H = i2;
            TextView textView = this.R;
            if (textView != null) {
                textView.setMaxLines(i2);
            }
        }
    }

    public void setMaxWidth(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048638, this, i2) == null) {
            this.G = i2;
        }
    }

    public void setOnEmotionClickListener(y yVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048639, this, yVar) == null) {
            this.D = yVar;
        }
    }

    public void setOnImageClickListener(z zVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048640, this, zVar) == null) {
            this.p = zVar;
            GridImageLayout gridImageLayout = this.j;
            if (gridImageLayout != null) {
                gridImageLayout.setOnImageClickListener(zVar);
            }
        }
    }

    public void setOnImageTouchListener(ux9 ux9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048641, this, ux9Var) == null) {
            this.q = ux9Var;
        }
    }

    public void setOnLinkImageClickListener(a0 a0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048642, this, a0Var) == null) {
            this.r = a0Var;
        }
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048643, this, onLongClickListener) == null) {
            this.c0 = onLongClickListener;
            super.setOnLongClickListener(onLongClickListener);
        }
    }

    public void setOnVoiceAfterClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048644, this, onClickListener) == null) {
            this.y = onClickListener;
        }
    }

    public void setPid(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048645, this, str) == null) {
            this.W = str;
        }
    }

    public void setPosition(Position position) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048646, this, position) == null) {
            this.a0 = position;
        }
    }

    public void setSubPbPost(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048647, this, z2) == null) {
            this.J = z2;
            N();
        }
    }

    public void setText(TbRichText tbRichText) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048648, this, tbRichText) == null) {
            setText(tbRichText, false);
        }
    }

    public void setTextCenter(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048653, this, z2) == null) {
            this.F = z2;
        }
    }

    public void setTextColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048654, this, i2) == null) {
            py5 py5Var = this.a;
            if (i2 == py5Var.l) {
                return;
            }
            py5Var.l = i2;
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
        if (interceptable == null || interceptable.invokeL(1048655, this, truncateAt) == null) {
            this.n = truncateAt;
            TextView textView = this.R;
            if (textView != null) {
                textView.setEllipsize(truncateAt);
            }
        }
    }

    public void setTextViewCheckSelection(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048658, this, z2) == null) {
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
        if (interceptable == null || interceptable.invokeL(1048659, this, onClickListener) == null) {
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
        if (interceptable == null || interceptable.invokeL(1048660, this, onTouchListener) == null) {
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
        if (interceptable == null || interceptable.invokeL(1048661, this, str) == null) {
            this.V = str;
        }
    }

    public void setVoiceViewRes(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048662, this, i2) == null) {
            this.x = i2;
        }
    }

    public void setmGridEmptyClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048663, this, onClickListener) == null) {
            this.t = onClickListener;
        }
    }

    public void setmIsGridImageSupportLongPress(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048664, this, z2) == null) {
            this.P = z2;
        }
    }

    public static pb<FestivalTipView> G(Context context, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65544, null, context, i2)) == null) {
            return new pb<>(new n(context, i2), 10, 0);
        }
        return (pb) invokeLI.objValue;
    }

    public static pb<TextView> H(Context context, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65545, null, context, i2)) == null) {
            return new pb<>(new m(context), i2, 0);
        }
        return (pb) invokeLI.objValue;
    }

    public static TbRichText Y(JSONArray jSONArray, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65546, null, jSONArray, i2)) == null) {
            return new TbRichText(jSONArray, i2);
        }
        return (TbRichText) invokeLI.objValue;
    }

    public static TbRichText Z(JSONArray jSONArray, boolean z2) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65547, null, jSONArray, z2)) == null) {
            return new TbRichText(jSONArray, z2);
        }
        return (TbRichText) invokeLZ.objValue;
    }

    public static TbRichText c0(List<PbContent> list, boolean z2) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65553, null, list, z2)) == null) {
            return new TbRichText(list, null, z2);
        }
        return (TbRichText) invokeLZ.objValue;
    }

    public void q0(String str, w wVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048617, this, str, wVar) == null) {
            this.d0 = wVar;
            p0(str);
        }
    }

    public void setText(TbRichText tbRichText, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048649, this, tbRichText, z2) == null) {
            setText(tbRichText, z2, null);
        }
    }

    public static TbRichText a0(List<PbContent> list, String str, boolean z2) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65549, null, list, str, z2)) == null) {
            return b0(list, str, z2, null, null, -1);
        }
        return (TbRichText) invokeLLZ.objValue;
    }

    public void setText(TbRichText tbRichText, boolean z2, t tVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048650, this, new Object[]{tbRichText, Boolean.valueOf(z2), tVar}) == null) {
            setText(tbRichText, z2, tVar, false, false);
        }
    }

    public static TbRichText b0(List<PbContent> list, String str, boolean z2, @Nullable nwa nwaVar, @Nullable ThreadData threadData, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65551, null, new Object[]{list, str, Boolean.valueOf(z2), nwaVar, threadData, Integer.valueOf(i2)})) == null) {
            return new TbRichText(list, str, z2, nwaVar, threadData, i2);
        }
        return (TbRichText) invokeCommon.objValue;
    }

    public static TbRichText d0(List<PbContent> list, boolean z2, @NonNull ThreadData threadData) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65555, null, new Object[]{list, Boolean.valueOf(z2), threadData})) == null) {
            return new TbRichText(list, null, z2, null, threadData, -1);
        }
        return (TbRichText) invokeCommon.objValue;
    }

    private GifView getGifView() {
        InterceptResult invokeV;
        GifView gifView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65559, this)) == null) {
            pb<GifView> pbVar = this.h;
            if (pbVar != null) {
                gifView = pbVar.b();
            } else {
                gifView = null;
            }
            if (gifView == null || gifView.getParent() != null) {
                gifView = new GifView(getContext());
            }
            gifView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
            gifView.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
            gifView.setBorderSurroundContent(true);
            gifView.setDrawCorner(true);
            gifView.setDrawBorder(true);
            gifView.setConrers(15);
            gifView.setDrawBorder(true);
            gifView.setRadius(this.Q);
            if (this.O) {
                gifView.setPlaceHolder(2);
            } else {
                gifView.setPlaceHolder(3);
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) gifView.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.leftMargin = 0;
                layoutParams.rightMargin = 0;
                gifView.setLayoutParams(layoutParams);
            }
            return gifView;
        }
        return (GifView) invokeV.objValue;
    }

    private GridImageLayout getGridImageView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65560, this)) == null) {
            GridImageLayout gridImageLayout = this.j;
            if (gridImageLayout == null || gridImageLayout.getParent() != null) {
                this.j = new GridImageLayout(getContext());
                this.j.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            }
            this.j.setLayoutStrategy(this.a);
            this.j.setObjectPool(this.c, this.h);
            this.j.setOnImageClickListener(this.p);
            View.OnClickListener onClickListener = this.t;
            if (onClickListener != null) {
                this.j.setOnClickListener(onClickListener);
            }
            this.j.setIsHost(this.K);
            if (this.P) {
                this.j.setOnLongClickListener(this.c0);
            }
            return this.j;
        }
        return (GridImageLayout) invokeV.objValue;
    }

    public final void o0() {
        TextView textView;
        CharSequence text;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048610, this) == null) && this.H > 0 && (textView = this.R) != null && textView.getLineCount() > this.H) {
            try {
                text = this.R.getText().subSequence(0, this.R.getLayout().getLineEnd(this.H - 1) - 1);
                str = "...";
            } catch (Exception unused) {
                text = this.R.getText();
                str = "";
            }
            TextUtils.TruncateAt ellipsize = this.R.getEllipsize();
            if (ellipsize == TextUtils.TruncateAt.START) {
                this.R.setText(str);
                this.R.append(text);
            } else if (ellipsize == TextUtils.TruncateAt.MIDDLE) {
                this.R.setText(text.subSequence(0, text.length() / 2));
                this.R.append(str);
                this.R.append(text.subSequence(text.length() / 2, text.length()));
            } else if (ellipsize == TextUtils.TruncateAt.END) {
                this.R.setText(text);
                this.R.append(str);
            }
        }
    }

    private ImageView getImageView() {
        InterceptResult invokeV;
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65561, this)) == null) {
            pb<ImageView> pbVar = this.c;
            ImageView imageView2 = null;
            if (pbVar != null) {
                imageView = pbVar.b();
            } else {
                imageView = null;
            }
            if (imageView != null && imageView.getParent() == null) {
                imageView2 = imageView;
            }
            if (imageView2 != null) {
                imageView2.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.editor_image));
            }
            return imageView2;
        }
        return (ImageView) invokeV.objValue;
    }

    private View getTextVoiceView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65563, this)) == null) {
            LinearLayout b2 = this.f.b();
            if (b2 != null) {
                TextView I = I(getContext());
                if (I == null) {
                    this.f.e(b2);
                    return null;
                }
                b2.addView(I);
                View K = K(null);
                if (K == null) {
                    this.d.e(I);
                    this.f.e(b2);
                    return null;
                }
                b2.addView(K);
            }
            return b2;
        }
        return (View) invokeV.objValue;
    }

    public final void F(BdImage bdImage) {
        int i2;
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, bdImage) != null) || bdImage == null) {
            return;
        }
        try {
            if (this.a.b() != null) {
                Rect b2 = this.a.b();
                if (b2.left != -1) {
                    i2 = b2.left;
                } else {
                    i2 = bdImage.mPadding.left;
                }
                if (b2.top != -1) {
                    i3 = b2.top;
                } else {
                    i3 = bdImage.mPadding.top;
                }
                if (b2.right != -1) {
                    i4 = b2.right;
                } else {
                    i4 = bdImage.mPadding.right;
                }
                if (b2.bottom == -1) {
                    b2 = bdImage.mPadding;
                }
                bdImage.mPadding = new Rect(i2, i3, i4, b2.bottom);
            }
            NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(getResources(), bdImage.getRawBitmap(), bdImage.getRawBitmap().getNinePatchChunk(), bdImage.getPadding(), null);
            if (TbadkCoreApplication.getInst().getSkinType() == 4) {
                ninePatchDrawable.getPaint().setAlpha(80);
            }
            setBackgroundDrawable(ninePatchDrawable);
            w wVar = this.d0;
            if (wVar != null) {
                wVar.b();
            }
        } catch (Exception unused) {
        }
    }

    public final LinearLayout J(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, tbRichTextData)) == null) {
            if (this.a.p > 0 && tbRichTextData != null) {
                LinearLayout linearLayout = new LinearLayout(getContext());
                linearLayout.setTag("VideoView");
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                layoutParams.topMargin = this.a.e;
                linearLayout.setClickable(true);
                Bitmap bitmap = SkinManager.getBitmap(this.a.p);
                if (bitmap != null) {
                    linearLayout.setBackgroundDrawable(new BitmapDrawable(getContext().getResources(), bitmap));
                }
                linearLayout.setFocusable(false);
                linearLayout.setLayoutParams(layoutParams);
                linearLayout.setOnClickListener(new q(this, tbRichTextData));
                return linearLayout;
            }
            return null;
        }
        return (LinearLayout) invokeL.objValue;
    }

    public final View K(View view2) {
        InterceptResult invokeL;
        View view3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, view2)) == null) {
            pb<View> pbVar = this.e;
            if (pbVar != null) {
                view3 = pbVar.b();
            } else {
                view3 = null;
            }
            if ((view3 == null || view3.getParent() != null) && this.x != -1) {
                view3 = LayoutInflater.from(getContext()).inflate(this.x, (ViewGroup) null);
            }
            if (view3 == null) {
                return null;
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            if (view2 instanceof TbListTextView) {
                layoutParams.topMargin = this.a.y;
            } else {
                layoutParams.topMargin = this.a.e;
            }
            layoutParams.bottomMargin = this.a.D;
            view3.setLayoutParams(layoutParams);
            if (view3 instanceof PlayVoiceBntNew) {
                ((PlayVoiceBntNew) view3).setAfterClickListener(this.y);
            }
            return view3;
        }
        return (View) invokeL.objValue;
    }

    public void p0(String str) {
        BdUniqueId bdUniqueId;
        boolean z2;
        boolean z3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, str) == null) {
            if (TextUtils.isEmpty(str)) {
                this.r0 = str;
                return;
            }
            z4 c2 = a5.c(getContext());
            if (c2 != null) {
                bdUniqueId = c2.getUniqueId();
                z2 = c2.isScroll();
            } else {
                bdUniqueId = null;
                z2 = false;
            }
            if (str.equals(this.r0) && this.s0 == bdUniqueId) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (!z3) {
                r0();
            }
            this.r0 = str;
            this.s0 = bdUniqueId;
            setBackgroundDrawable(null);
            BdImage bdImage = (BdImage) BdResourceLoader.getInstance().loadResourceFromMemery(this.r0, 19, new Object[0]);
            if (bdImage != null) {
                F(bdImage);
            } else if (z2) {
                invalidate();
            } else if (!BdResourceLoader.getInstance().isNeedLoad(19)) {
                invalidate();
            } else {
                BdResourceLoader.getInstance().loadResource(this.r0, 19, this.t0, 0, 0, this.s0, new Object[0]);
            }
        }
    }

    public TextView I(Context context) {
        InterceptResult invokeL;
        TextView textView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            pb<TextView> pbVar = this.d;
            if (pbVar != null) {
                textView = pbVar.b();
            } else {
                textView = null;
            }
            if (textView == null || textView.getParent() != null) {
                textView = new TbListTextView(context);
            }
            int i2 = this.a.d;
            textView.setPadding(i2, 0, i2, 0);
            return textView;
        }
        return (TextView) invokeL.objValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, motionEvent)) == null) {
            this.z = false;
            int action = motionEvent.getAction();
            if ((action == 1 || action == 3) && !this.A) {
                f0();
            }
            boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
            if (motionEvent.getAction() == 0 && !this.z) {
                e0();
            }
            return dispatchTouchEvent;
        }
        return invokeL.booleanValue;
    }

    public void setTextPadding(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048656, this, i2) == null) {
            py5 py5Var = this.a;
            if (py5Var.d == i2) {
                return;
            }
            py5Var.d = i2;
            int childCount = getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                if (childAt != null && (childAt instanceof TextView)) {
                    int i4 = this.a.d;
                    ((TextView) childAt).setPadding(i4, 0, 0, i4);
                }
            }
        }
    }

    public void setTextSize(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048657, this, f2) == null) {
            setFaceSize(f2);
            py5 py5Var = this.a;
            if (f2 == py5Var.f) {
                return;
            }
            py5Var.f = f2;
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (childAt instanceof TextView) {
                    ((TextView) childAt).setTextSize(0, f2);
                }
            }
        }
    }

    public final void M() {
        xy5 xy5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            BdPageContext<?> a2 = a5.a(getContext());
            if (getContext() instanceof xy5) {
                xy5Var = (xy5) getContext();
            } else if (a2 != null && (a2.getOrignalPage() instanceof xy5)) {
                xy5Var = (xy5) a2.getOrignalPage();
            } else {
                xy5Var = null;
            }
            if (xy5Var == null && (getContext() instanceof BaseFragmentActivity)) {
                List<Fragment> fragments = ((BaseFragmentActivity) getContext()).getSupportFragmentManager().getFragments();
                if (!ListUtils.isEmpty(fragments) && (fragments.get(0) instanceof xy5)) {
                    xy5Var = (xy5) fragments.get(0);
                }
            }
            if (a2 != null) {
                a2.registerListener(this.u0);
            }
            if (xy5Var != null) {
                this.c = xy5Var.r0();
                this.d = xy5Var.N1();
                this.e = xy5Var.t0();
                this.f = xy5Var.Q();
                this.h = xy5Var.M();
                this.i = xy5Var.F2();
                this.g = xy5Var.n0();
                this.k = xy5Var.P0();
                this.l = xy5Var.q0();
                if (xy5Var.getListView() != null && this.o == null) {
                    this.o = new c0(xy5Var.V());
                    xy5Var.getListView().setRecyclerListener(this.o);
                }
            }
            this.Q = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds21);
            setOrientation(1);
            setOnHierarchyChangeListener(new o(this));
        }
    }

    public final void l0() {
        TextView textView;
        CharSequence subSequence;
        Object[] spans;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048607, this) == null) && this.H > 1 && (textView = this.R) != null && textView.getLineCount() > this.H) {
            try {
                CharSequence subSequence2 = this.R.getText().subSequence(0, this.R.getLayout().getLineEnd(this.H - 1));
                Layout layout = this.R.getLayout();
                int lineStart = layout.getLineStart(this.H - 1);
                int lineEnd = layout.getLineEnd(this.H - 1);
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
                spannableStringBuilder.append((CharSequence) "...");
                SpannableString spannableString = new SpannableString("展开");
                spannableString.setSpan(this.b0, 0, spannableString.length(), 17);
                spannableStringBuilder.append((CharSequence) spannableString);
                this.R.setText(spannableStringBuilder);
            } catch (Exception unused) {
                this.R.setText(this.R.getText());
            }
        }
    }

    public final boolean O(TbRichTextData tbRichTextData, GifView gifView) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, tbRichTextData, gifView)) == null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) gifView.getLayoutParams();
            if (layoutParams != null && layoutParams.width == tbRichTextData.R().mGifInfo.mGifWidth && layoutParams.height == tbRichTextData.R().mGifInfo.mGifHeight) {
                layoutParams.bottomMargin = 0;
            } else {
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(tbRichTextData.R().mGifInfo.mGifWidth, tbRichTextData.R().mGifInfo.mGifHeight);
                layoutParams2.gravity = 3;
                gifView.setLayoutParams(layoutParams2);
            }
            gifView.setOnClickListener(new c(this, tbRichTextData));
            gifView.p(tbRichTextData.R().mGifInfo);
            return true;
        }
        return invokeLL.booleanValue;
    }

    public final boolean P(TbRichTextData tbRichTextData, ImageView imageView, int i2, int i3, boolean z2) {
        InterceptResult invokeCommon;
        String Q;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{tbRichTextData, imageView, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z2)})) == null) {
            if (tbRichTextData == null || imageView == null || tbRichTextData.V() == null) {
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
                tbImageView.setTLIconType(tbRichTextData.getIconType());
                tbImageView.setConrers(15);
                tbImageView.setRadius(this.Q);
                if (this.O) {
                    tbImageView.setPlaceHolder(2);
                } else {
                    tbImageView.setPlaceHolder(3);
                }
                if (this.a.t) {
                    tbImageView.setSupportNoImage(true);
                }
                if (this.a.d()) {
                    Q = tbRichTextData.V().O();
                } else {
                    Q = tbRichTextData.V().Q();
                }
                if (!z2 || tbImageView.getUrl() == null || !tbImageView.getUrl().equals(Q)) {
                    if (this.w) {
                        i4 = 17;
                    } else {
                        i4 = 18;
                    }
                    tbImageView.startLoad(Q, i4, false);
                }
                if (!tbRichTextData.V().V()) {
                    tbImageView.setAdjustViewBounds(false);
                }
                tbImageView.setTag(R.id.tag_rich_text_meme_info, null);
            }
            return j0(imageView, tbRichTextData.V().getWidth(), tbRichTextData.V().getHeight(), i2, i3, this.e0);
        }
        return invokeCommon.booleanValue;
    }

    public final boolean Q(ItemCardView itemCardView, TbRichTextData tbRichTextData) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, itemCardView, tbRichTextData)) == null) {
            if (tbRichTextData != null) {
                if ((tbRichTextData.W() != null || tbRichTextData.S() != null) && itemCardView != null) {
                    if (tbRichTextData.getType() == 37) {
                        itemCardView.setPosition(9);
                    } else if (tbRichTextData.getType() == 1281) {
                        itemCardView.setPosition(4);
                    }
                    itemCardView.setOnClickListener(new d(this, tbRichTextData, itemCardView));
                    itemCardView.setOnClickListenerOfRightBtn(this.u);
                    itemCardView.setIsShowRightBtn(this.U);
                    if (tbRichTextData.getType() == 37) {
                        itemCardView.setData(tbRichTextData.W().a(), 17, this.V);
                    } else if (tbRichTextData.getType() == 1281) {
                        itemCardView.setData(tbRichTextData.S(), 17, this.V);
                    }
                    itemCardView.M();
                    return true;
                }
                return false;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final boolean R(TbRichTextData tbRichTextData, ImageView imageView, int i2, int i3) {
        InterceptResult invokeLLII;
        TbRichTextLinkImageInfo X;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(1048586, this, tbRichTextData, imageView, i2, i3)) == null) {
            if (tbRichTextData == null || imageView == null || (X = tbRichTextData.X()) == null || X.getLink() == null) {
                return false;
            }
            if (imageView instanceof TbImageView) {
                TbImageView tbImageView = (TbImageView) imageView;
                if (this.a.t) {
                    tbImageView.setSupportNoImage(true);
                }
                String O = X.O();
                if (this.w) {
                    i4 = 17;
                } else {
                    i4 = 18;
                }
                tbImageView.startLoad(O, i4, false);
                tbImageView.setTag(new v(X.getLink()));
                if (!X.P()) {
                    tbImageView.setAdjustViewBounds(false);
                }
            }
            return k0(imageView, X.getWidth(), X.getHeight(), i2, i3, this.g0);
        }
        return invokeLLII.booleanValue;
    }

    public final boolean S(TbRichTextData tbRichTextData, ImageView imageView, int i2, int i3) {
        InterceptResult invokeLLII;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(1048587, this, tbRichTextData, imageView, i2, i3)) == null) {
            if (tbRichTextData == null || imageView == null || tbRichTextData.Y() == null) {
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
                tbImageView.setRadius(this.Q);
                if (this.O) {
                    tbImageView.setPlaceHolder(2);
                } else {
                    tbImageView.setPlaceHolder(3);
                }
                if (this.a.t) {
                    tbImageView.setSupportNoImage(true);
                }
                String str = tbRichTextData.Y().memeInfo.pic_url;
                if (this.w) {
                    i4 = 17;
                } else {
                    i4 = 18;
                }
                tbImageView.startLoad(str, i4, false);
                tbImageView.setAdjustViewBounds(false);
                tbImageView.setTag(R.id.tag_rich_text_meme_info, tbRichTextData.Y());
            }
            return k0(imageView, tbRichTextData.Y().memeInfo.width.intValue(), tbRichTextData.Y().memeInfo.height.intValue(), i2, i3, this.e0);
        }
        return invokeLLII.booleanValue;
    }

    public final boolean T(TbRichTextData tbRichTextData, GifView gifView, boolean z2) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048588, this, tbRichTextData, gifView, z2)) == null) {
            if (gifView == null) {
                return false;
            }
            gifView.setDefaultNoImageDay(R.drawable.icon_click);
            Drawable drawable = SkinManager.getDrawable(R.color.CAM_X0209);
            if (drawable != null) {
                gifView.setBackgroundDrawable(drawable);
            } else {
                gifView.setBackgroundDrawable(SkinManager.getDrawable(R.color.common_color_10220));
            }
            String R = tbRichTextData.V().R();
            if (StringUtils.isNull(R)) {
                py5 py5Var = this.a;
                if (py5Var.I) {
                    if (py5Var.u) {
                        R = tbRichTextData.V().O();
                    } else {
                        R = tbRichTextData.V().P();
                    }
                }
                if (StringUtils.isNull(R)) {
                    if (this.a.u) {
                        R = tbRichTextData.V().Q();
                    } else {
                        R = tbRichTextData.V().U();
                    }
                }
            }
            gifView.setShowStaticDrawable(false);
            if (!z2 || gifView.getUrl() == null || !gifView.getUrl().equals(R)) {
                gifView.q(R, 38);
            }
            int width = tbRichTextData.V().getWidth();
            int height = tbRichTextData.V().getHeight();
            py5 py5Var2 = this.a;
            return j0(gifView, width, height, py5Var2.m, py5Var2.n, this.e0);
        }
        return invokeLLZ.booleanValue;
    }

    public final boolean U(TbRichTextData tbRichTextData, TextView textView, boolean z2, t tVar) {
        InterceptResult invokeCommon;
        LinearLayout.LayoutParams layoutParams;
        SpannableStringBuilder Z;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{tbRichTextData, textView, Boolean.valueOf(z2), tVar})) == null) {
            this.R = textView;
            if (z2) {
                layoutParams = new LinearLayout.LayoutParams(-1, -2);
            } else {
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
            }
            if (this.F) {
                layoutParams.gravity = 16;
                textView.setGravity(16);
            } else {
                layoutParams.topMargin = this.a.e;
            }
            textView.setIncludeFontPadding(this.a.b);
            py5 py5Var = this.a;
            textView.setLineSpacing(py5Var.c, py5Var.a);
            textView.setTextSize(0, this.a.f);
            if (this.a.g) {
                EMManager.from(textView).setTextStyle(R.string.F_X02);
            }
            textView.setTextColor(this.a.l);
            textView.setLinkTextColor(SkinManager.getColor(R.color.CAM_X0304));
            textView.setHighlightColor(getContext().getResources().getColor(R.color.transparent));
            textView.setSingleLine(this.a.q);
            if (this.L) {
                n0();
            }
            if (this.M) {
                m0();
            }
            TextUtils.TruncateAt truncateAt = this.n;
            if (truncateAt != null) {
                textView.setEllipsize(truncateAt);
            }
            if (this.S) {
                EMManager.from(textView).setTextShadow(R.array.S_O_X001);
            }
            int i3 = this.G;
            if (i3 > 0) {
                textView.setMaxWidth(i3);
            }
            int i4 = this.H;
            if (i4 > 0) {
                textView.setMaxLines(i4);
            }
            if (tbRichTextData == null || (Z = tbRichTextData.Z()) == null || Z.length() <= 0) {
                return false;
            }
            py5 py5Var2 = this.a;
            int i5 = py5Var2.i;
            if (i5 > 0 && (i2 = py5Var2.h) > 0) {
                tbRichTextData.k0(i2, i5);
            }
            py5 py5Var3 = this.a;
            if (py5Var3.j > 0 || py5Var3.k > 0) {
                py5 py5Var4 = this.a;
                tbRichTextData.j0(py5Var4.j, py5Var4.k);
            }
            tbRichTextData.j0(8, 0);
            if (tVar != null) {
                tVar.h1(Z, textView, this);
            }
            try {
                textView.setText(Z);
            } catch (Exception unused) {
                textView.setText("");
            }
            if (this.I) {
                if (tbRichTextData.g0()) {
                    textView.setMovementMethod(v9b.a());
                } else {
                    textView.setMovementMethod(LinkMovementMethod.getInstance());
                }
            }
            textView.setFocusable(false);
            textView.setLayoutParams(layoutParams);
            textView.setTag(tbRichTextData);
            if (tbRichTextData != null && tbRichTextData.b0() != null) {
                tbRichTextData.b0().needRecompute = this.i0;
                return true;
            }
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public final boolean V(TbRichTextData tbRichTextData, LinearLayout linearLayout, t tVar) {
        InterceptResult invokeLLL;
        boolean W;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048590, this, tbRichTextData, linearLayout, tVar)) == null) {
            if (linearLayout == null) {
                return false;
            }
            int childCount = linearLayout.getChildCount();
            boolean z2 = true;
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = linearLayout.getChildAt(i2);
                if (childAt != null) {
                    if (childAt instanceof TextView) {
                        W = U(tbRichTextData, (TextView) childAt, false, tVar);
                    } else if (childAt.getClass().getSimpleName().equals("PlayVoiceBnt")) {
                        W = W(tbRichTextData, childAt);
                    } else if (childAt.getClass().getSimpleName().equals("PlayVoiceBntNew")) {
                        W = W(tbRichTextData, childAt);
                    }
                    z2 &= W;
                }
            }
            return z2;
        }
        return invokeLLL.booleanValue;
    }

    public final boolean W(TbRichTextData tbRichTextData, View view2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048591, this, tbRichTextData, view2)) == null) {
            view2.setTag(tbRichTextData.f0());
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view2.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
            }
            view2.setLayoutParams(layoutParams);
            if (view2 instanceof PlayVoiceBntNew) {
                ((PlayVoiceBntNew) view2).b();
                return true;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public void setDisplayImage(boolean z2, boolean z3) {
        pb<ImageView> pbVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048624, this, new Object[]{Boolean.valueOf(z2), Boolean.valueOf(z3)}) != null) || this.v == z2) {
            return;
        }
        this.v = z2;
        if (z3) {
            requestLayout();
        }
        if (!this.v && (pbVar = this.c) != null) {
            pbVar.c();
        }
    }

    public final boolean X(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, view2)) == null) {
            if (!(view2 instanceof ImageView)) {
                return false;
            }
            if (view2 instanceof GifView) {
                if (view2.getTag(R.id.tag_rich_text_view_gif_view) == null || !(view2.getTag(R.id.tag_rich_text_view_gif_view) instanceof s) || !((s) view2.getTag(R.id.tag_rich_text_view_gif_view)).a) {
                    return false;
                }
                return true;
            }
            if ((view2 instanceof TbImageView) && view2.getTag() != null) {
                if (view2.getTag() instanceof v) {
                    return false;
                }
                if ((view2.getTag() instanceof String) && TextUtils.equals("VideoView", (String) view2.getTag())) {
                    return false;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void g0(RelativeLayout relativeLayout, int i2, int i3, int i4, int i5) {
        int[] imageResize;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048596, this, new Object[]{relativeLayout, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) != null) || (imageResize = BdUtilHelper.getImageResize(i2, i3, i4, i5)) == null) {
            return;
        }
        int[] iArr = {imageResize[0], imageResize[1]};
        int i6 = iArr[0];
        int i7 = iArr[1];
        if (this.a.v && i4 > i6) {
            float f2 = v0;
            if (f2 > 1.0f) {
                float f3 = i6;
                float f4 = i4;
                if (f3 * f2 <= f4) {
                    float f5 = f4 * 0.68f;
                    if (f3 * f2 > f5) {
                        i4 = (int) f5;
                    } else {
                        i4 = (int) (f3 * f2);
                    }
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
    public final void h0(RelativeLayout relativeLayout, int i2, int i3, int i4, int i5) {
        int[] imageResize;
        int i6;
        int i7;
        int dimens;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048603, this, new Object[]{relativeLayout, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) != null) || (imageResize = BdUtilHelper.getImageResize(i2, i3, i4, i5)) == null) {
            return;
        }
        int[] iArr = {imageResize[0], imageResize[1]};
        int i8 = iArr[0];
        int i9 = iArr[1];
        if (this.a.v && i4 > i8) {
            float f2 = v0;
            if (f2 > 1.0f) {
                float f3 = i8;
                float f4 = i4;
                if (f3 * f2 > f4) {
                    i7 = i4 - BdUtilHelper.getDimens(getContext(), R.dimen.obfuscated_res_0x7f07041b);
                    dimens = BdUtilHelper.getDimens(getContext(), R.dimen.obfuscated_res_0x7f0701be);
                } else {
                    float f5 = f4 * 0.68f;
                    if (f3 * f2 > f5) {
                        i7 = (int) f5;
                        dimens = BdUtilHelper.getDimens(getContext(), R.dimen.obfuscated_res_0x7f07041b);
                    } else {
                        i6 = (int) (f3 * f2);
                        if (iArr[0] > 0) {
                            i9 = (i6 * iArr[1]) / iArr[0];
                        }
                    }
                }
                i6 = i7 - dimens;
                if (iArr[0] > 0) {
                }
            }
        }
        relativeLayout.setLayoutParams(new LinearLayout.LayoutParams(i4, i9));
    }

    public final boolean i0(ImageView imageView, int i2, int i3, int i4, int i5, View.OnClickListener onClickListener) {
        InterceptResult invokeCommon;
        View.OnLongClickListener onLongClickListener;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048604, this, new Object[]{imageView, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), onClickListener})) == null) {
            int[] imageResize = BdUtilHelper.getImageResize(i2, i3, i4, i5);
            if (imageResize == null) {
                return false;
            }
            int[] iArr = {imageResize[0], imageResize[1]};
            int i6 = iArr[0];
            int i7 = iArr[1];
            if (this.a.v && i4 > i6) {
                float f2 = v0;
                if (f2 > 1.0f) {
                    float f3 = i6;
                    float f4 = i4;
                    if (f3 * f2 > f4) {
                        i6 = (i4 - BdUtilHelper.getDimens(getContext(), R.dimen.obfuscated_res_0x7f07041b)) - BdUtilHelper.getDimens(getContext(), R.dimen.obfuscated_res_0x7f0701be);
                    } else {
                        float f5 = f4 * 0.68f;
                        if (f3 * f2 > f5) {
                            i6 = ((int) f5) - BdUtilHelper.getDimens(getContext(), R.dimen.obfuscated_res_0x7f07041b);
                        } else {
                            i6 = (int) (f3 * f2);
                        }
                    }
                    if (iArr[0] > 0) {
                        i7 = (iArr[1] * i6) / iArr[0];
                    }
                }
            }
            boolean z2 = imageView instanceof TbImageView;
            if (z2) {
                TbImageView tbImageView = (TbImageView) imageView;
                tbImageView.setDefaultResource(this.a.o);
                if (tbImageView.getGifIconWidth() < i6 && tbImageView.getGifIconHeight() < i7) {
                    tbImageView.setGifIconSupport(true);
                } else {
                    tbImageView.setGifIconSupport(false);
                }
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i6, i7);
            if (this.a.v) {
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            } else {
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            }
            imageView.setClickable(true);
            imageView.setFocusable(false);
            if (this.q != null && z2) {
                ((TbImageView) imageView).setTbGestureDetector(this.f0);
                imageView.setClickable(true);
            } else {
                imageView.setOnClickListener(onClickListener);
            }
            imageView.setLayoutParams(layoutParams);
            if (z2) {
                if (this.c0 != null) {
                    ((TbImageView) imageView).setDispatchTouchListener(this.h0);
                    imageView.setOnLongClickListener(this.c0);
                }
            } else if ((imageView instanceof GifView) && (onLongClickListener = this.c0) != null) {
                imageView.setOnLongClickListener(onLongClickListener);
            }
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public final boolean j0(ImageView imageView, int i2, int i3, int i4, int i5, View.OnClickListener onClickListener) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048605, this, new Object[]{imageView, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), onClickListener})) == null) {
            int[] f2 = this.a.f(i2, i3, i4, i5);
            if (f2 == null) {
                return false;
            }
            int i6 = f2[0];
            int i7 = f2[1];
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
            py5 py5Var = this.a;
            if (py5Var.v) {
                imageView.setScaleType(py5Var.s);
                if (z2) {
                    ((TbImageView) imageView).setOnDrawListener(this.a.M);
                }
            } else {
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            }
            imageView.setClickable(true);
            imageView.setFocusable(false);
            if (this.q != null && z2) {
                ((TbImageView) imageView).setTbGestureDetector(this.f0);
                imageView.setClickable(true);
            } else {
                imageView.setOnClickListener(onClickListener);
            }
            imageView.setLayoutParams(layoutParams);
            if (z2) {
                if (this.c0 != null) {
                    ((TbImageView) imageView).setDispatchTouchListener(this.h0);
                    imageView.setOnLongClickListener(this.c0);
                }
            } else if ((imageView instanceof GifView) && this.c0 != null) {
                ((GifView) imageView).setDispatchTouchListener(this.h0);
                imageView.setOnLongClickListener(this.c0);
            }
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public final boolean k0(ImageView imageView, int i2, int i3, int i4, int i5, View.OnClickListener onClickListener) {
        InterceptResult invokeCommon;
        View.OnLongClickListener onLongClickListener;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048606, this, new Object[]{imageView, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), onClickListener})) == null) {
            int[] imageResize = BdUtilHelper.getImageResize(i2, i3, i4, i5);
            if (imageResize == null) {
                return false;
            }
            int[] iArr = {imageResize[0], imageResize[1]};
            int i6 = iArr[0];
            int i7 = iArr[1];
            if (this.a.v && i4 > i6) {
                float f2 = v0;
                if (f2 > 1.0f) {
                    float f3 = i6;
                    float f4 = i4;
                    if (f3 * f2 <= f4) {
                        float f5 = f4 * 0.68f;
                        if (f3 * f2 > f5) {
                            i4 = (int) f5;
                        } else {
                            i4 = (int) (f3 * f2);
                        }
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
                tbImageView.setDefaultResource(this.a.o);
                if (tbImageView.getGifIconWidth() < i6 && tbImageView.getGifIconHeight() < i7) {
                    tbImageView.setGifIconSupport(true);
                } else {
                    tbImageView.setGifIconSupport(false);
                }
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i6, i7);
            if (this.a.v) {
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            } else {
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            }
            imageView.setClickable(true);
            imageView.setFocusable(false);
            if (this.q != null && z2) {
                ((TbImageView) imageView).setTbGestureDetector(this.f0);
                imageView.setClickable(true);
            } else {
                imageView.setOnClickListener(onClickListener);
            }
            imageView.setLayoutParams(layoutParams);
            if (z2) {
                if (this.c0 != null) {
                    ((TbImageView) imageView).setDispatchTouchListener(this.h0);
                    imageView.setOnLongClickListener(this.c0);
                }
            } else if ((imageView instanceof GifView) && (onLongClickListener = this.c0) != null) {
                imageView.setOnLongClickListener(onLongClickListener);
            }
            return true;
        }
        return invokeCommon.booleanValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:262:0x022c */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:274:0x0036 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:275:0x0036 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:209:0x0527  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x0541  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x012f  */
    /* JADX WARN: Type inference failed for: r0v125, types: [com.baidu.tbadk.gif.GifView, android.view.View] */
    /* JADX WARN: Type inference failed for: r0v160 */
    /* JADX WARN: Type inference failed for: r0v29, types: [android.widget.RelativeLayout, com.baidu.tbadk.widget.tiejia.TiebaPlusRecommendCard] */
    /* JADX WARN: Type inference failed for: r10v9, types: [android.widget.ImageView] */
    /* JADX WARN: Type inference failed for: r11v5 */
    /* JADX WARN: Type inference failed for: r25v0, types: [android.widget.LinearLayout, com.baidu.tbadk.widget.richText.TbRichTextView, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v61, types: [android.widget.ImageView] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void setText(TbRichText tbRichText, boolean z2, t tVar, boolean z3, boolean z4) {
        ArrayList<TbRichTextData> Q;
        au9<ImageView> au9Var;
        boolean U;
        TbRichTextData tbRichTextData;
        SpannableStringBuilder Z;
        boolean z5;
        Iterator<TbRichTextData> it;
        LinearLayout linearLayout;
        int i2;
        GifView gifView;
        int i3;
        pb<FestivalTipView> pbVar;
        FestivalTipView festivalTipView;
        pb<TiebaPlusRecommendCard> pbVar2;
        ImageView imageView;
        boolean z6;
        View view2;
        RelativeLayout relativeLayout;
        int i4;
        TbRichTextData tbRichTextData2;
        View view3;
        Object imageView2;
        boolean z7;
        String Q2;
        Object obj;
        boolean z8;
        Object obj2;
        boolean z9;
        GifView gifView2;
        GifView gifView3;
        Object obj3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048651, this, new Object[]{tbRichText, Boolean.valueOf(z2), tVar, Boolean.valueOf(z3), Boolean.valueOf(z4)}) == null) {
            t tVar2 = tVar;
            if (this.E == tbRichText && (tbRichText == null || !tbRichText.isChanged)) {
                return;
            }
            if (tbRichText != null) {
                tbRichText.isChanged = false;
            }
            this.E = tbRichText;
            removeAllViews();
            if (tbRichText != null && (Q = tbRichText.Q()) != null) {
                Iterator<TbRichTextData> it2 = Q.iterator();
                i iVar = null;
                boolean z10 = true;
                View view4 = null;
                View view5 = null;
                int i5 = 0;
                boolean z11 = false;
                boolean z12 = true;
                while (it2.hasNext()) {
                    TbRichTextData next = it2.next();
                    if (next != null) {
                        if (next.getType() == z10) {
                            TextView I = I(getContext());
                            U = U(next, I, z10, tVar2);
                            if (z2 && !this.C && (Z = next.Z()) != null) {
                                if (Z.length() >= 200) {
                                    z5 = true;
                                } else {
                                    z5 = false;
                                }
                                this.C = z5;
                            }
                            TiePlusEventController.v(next.c0());
                            if (this.q != null) {
                                I.setOnTouchListener(this.f0);
                            } else {
                                I.setOnClickListener(this.s);
                            }
                            tbRichTextData = next;
                            gifView = I;
                        } else {
                            if (next.getType() == 8) {
                                if (!this.O) {
                                    if (next.V() != null) {
                                        if (TbadkCoreApplication.getInst().isGifAutoPlay() && !next.V().X()) {
                                            if (z4) {
                                                String R = next.V().R();
                                                if (StringUtils.isNull(R)) {
                                                    py5 py5Var = this.a;
                                                    if (py5Var.I) {
                                                        if (py5Var.u) {
                                                            R = next.V().O();
                                                        } else {
                                                            R = next.V().P();
                                                        }
                                                    }
                                                    if (StringUtils.isNull(R)) {
                                                        if (this.a.u) {
                                                            R = next.V().Q();
                                                        } else {
                                                            R = next.V().U();
                                                        }
                                                    }
                                                }
                                                au9<ImageView> au9Var2 = this.b;
                                                if (au9Var2 != null) {
                                                    Object obj4 = (ImageView) au9Var2.h(R);
                                                    if (obj4 instanceof GifView) {
                                                        obj3 = (GifView) obj4;
                                                        if (obj3 != null) {
                                                            gifView3 = getGifView();
                                                        } else {
                                                            z9 = true;
                                                            gifView2 = obj3;
                                                            s sVar = new s(iVar);
                                                            sVar.a = z10;
                                                            gifView2.setTag(R.id.tag_rich_text_view_gif_view, sVar);
                                                            U = T(next, gifView2, z9);
                                                            if (z3) {
                                                                u uVar = new u(iVar);
                                                                uVar.a = z10;
                                                                gifView2.setTag(R.id.tag_rich_text_view_recycle, uVar);
                                                            }
                                                            tbRichTextData2 = next;
                                                            view3 = gifView2;
                                                        }
                                                    }
                                                }
                                                obj3 = iVar;
                                                if (obj3 != null) {
                                                }
                                            } else {
                                                gifView3 = getGifView();
                                            }
                                            z9 = false;
                                            gifView2 = gifView3;
                                            s sVar2 = new s(iVar);
                                            sVar2.a = z10;
                                            gifView2.setTag(R.id.tag_rich_text_view_gif_view, sVar2);
                                            U = T(next, gifView2, z9);
                                            if (z3) {
                                            }
                                            tbRichTextData2 = next;
                                            view3 = gifView2;
                                        } else {
                                            if (z4) {
                                                if (this.a.d()) {
                                                    Q2 = next.V().O();
                                                } else {
                                                    Q2 = next.V().Q();
                                                }
                                                au9<ImageView> au9Var3 = this.b;
                                                if (au9Var3 != null) {
                                                    obj = (ImageView) au9Var3.h(Q2);
                                                } else {
                                                    obj = iVar;
                                                }
                                                if (obj == null) {
                                                    z8 = false;
                                                    obj2 = getImageView();
                                                } else {
                                                    z8 = true;
                                                    obj2 = obj;
                                                }
                                                imageView2 = obj2;
                                                z7 = z8;
                                            } else {
                                                imageView2 = getImageView();
                                                z7 = false;
                                            }
                                            py5 py5Var2 = this.a;
                                            ?? r10 = imageView2;
                                            tbRichTextData2 = next;
                                            boolean P = P(next, imageView2, py5Var2.m, py5Var2.n, z7);
                                            if (z3) {
                                                u uVar2 = new u(iVar);
                                                uVar2.a = z10;
                                                r10.setTag(R.id.tag_rich_text_view_recycle, uVar2);
                                            }
                                            U = P;
                                            view3 = r10;
                                        }
                                    } else {
                                        tbRichTextData2 = next;
                                        U = false;
                                        view3 = view4;
                                    }
                                    tbRichTextData = tbRichTextData2;
                                    gifView = view3;
                                    gifView = view3;
                                    if (view3 != null && tbRichTextData != null) {
                                        view3.setTag(R.id.tag_rich_text_image_info, tbRichTextData.V());
                                        gifView = view3;
                                    }
                                } else {
                                    tbRichTextData = next;
                                    if (!z11) {
                                        GridImageLayout gridImageView = getGridImageView();
                                        gridImageView.setData(tbRichText.S());
                                        it = it2;
                                        U = true;
                                        i2 = 8;
                                        z11 = true;
                                        view4 = gridImageView;
                                    }
                                }
                            } else {
                                tbRichTextData = next;
                                if (tbRichTextData.getType() == 32) {
                                    it = it2;
                                    U = true;
                                    linearLayout = J(tbRichTextData);
                                    i2 = 8;
                                    view4 = linearLayout;
                                } else if (tbRichTextData.getType() == 512) {
                                    view4 = K(view5);
                                    if (view4 != null) {
                                        U = W(tbRichTextData, view4);
                                        gifView = view4;
                                    }
                                } else if (tbRichTextData.getType() == 768) {
                                    View textVoiceView = getTextVoiceView();
                                    U = V(tbRichTextData, (LinearLayout) textVoiceView, tVar2);
                                    gifView = textVoiceView;
                                } else if (tbRichTextData.getType() == 17) {
                                    GifView gifView4 = getGifView();
                                    U = O(tbRichTextData, gifView4);
                                    gifView = gifView4;
                                } else {
                                    if (tbRichTextData.getType() == 20) {
                                        if (i5 < 10) {
                                            int i6 = i5 + 1;
                                            if (tbRichTextData != null && tbRichTextData.Y() != null && tbRichTextData.Y().memeInfo != null && !StringUtils.isNull(tbRichTextData.Y().memeInfo.pic_url)) {
                                                z6 = true;
                                            } else {
                                                z6 = false;
                                            }
                                            if (z6) {
                                                RelativeLayout b2 = this.g.b();
                                                b2.removeAllViews();
                                                b2.setLayoutParams(new LinearLayout.LayoutParams(tbRichTextData.Y().memeInfo.width.intValue(), tbRichTextData.Y().memeInfo.height.intValue()));
                                                if (DuiSwitch.getInOn() && this.m) {
                                                    int intValue = tbRichTextData.Y().memeInfo.width.intValue();
                                                    int intValue2 = tbRichTextData.Y().memeInfo.height.intValue();
                                                    py5 py5Var3 = this.a;
                                                    h0(b2, intValue, intValue2, py5Var3.m, py5Var3.n);
                                                } else {
                                                    int intValue3 = tbRichTextData.Y().memeInfo.width.intValue();
                                                    int intValue4 = tbRichTextData.Y().memeInfo.height.intValue();
                                                    py5 py5Var4 = this.a;
                                                    g0(b2, intValue3, intValue4, py5Var4.m, py5Var4.n);
                                                }
                                                ImageView b3 = this.c.b();
                                                py5 py5Var5 = this.a;
                                                S(tbRichTextData, b3, py5Var5.m, py5Var5.n);
                                                if (DuiSwitch.getInOn() && this.m) {
                                                    ImageView b4 = this.c.b();
                                                    b4.setTag(this.E);
                                                    if (b4 instanceof TbImageView) {
                                                        TbImageView tbImageView = (TbImageView) b4;
                                                        tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
                                                        tbImageView.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
                                                        tbImageView.setBorderSurroundContent(z10);
                                                        tbImageView.setDrawCorner(z10);
                                                        tbImageView.setDrawBorder(z10);
                                                        tbImageView.setLongIconSupport(z10);
                                                        tbImageView.setGifIconSupport(z10);
                                                        tbImageView.setConrers(15);
                                                        tbImageView.setRadius(this.Q);
                                                        tbImageView.setAdjustViewBounds(false);
                                                        if (this.O) {
                                                            tbImageView.setPlaceHolder(2);
                                                        } else {
                                                            tbImageView.setPlaceHolder(3);
                                                        }
                                                    }
                                                    b4.setScaleType(ImageView.ScaleType.FIT_XY);
                                                    int dimens = BdUtilHelper.getDimens(getContext(), R.dimen.obfuscated_res_0x7f07041b);
                                                    int dimens2 = BdUtilHelper.getDimens(getContext(), R.dimen.obfuscated_res_0x7f07041b);
                                                    b3.setId(R.id.meme_image_view);
                                                    int intValue5 = tbRichTextData.Y().memeInfo.width.intValue();
                                                    int intValue6 = tbRichTextData.Y().memeInfo.height.intValue();
                                                    py5 py5Var6 = this.a;
                                                    it = it2;
                                                    relativeLayout = b2;
                                                    i0(b3, intValue5, intValue6, py5Var6.m, py5Var6.n, this.e0);
                                                    relativeLayout.addView(b3);
                                                    if (dimens2 > tbRichTextData.Y().memeInfo.height.intValue()) {
                                                        dimens /= 2;
                                                        i4 = dimens2 / 2;
                                                    } else {
                                                        i4 = dimens2;
                                                    }
                                                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dimens, i4);
                                                    i2 = 8;
                                                    layoutParams.addRule(8, R.id.meme_image_view);
                                                    layoutParams.addRule(11);
                                                    b4.setOnClickListener(this.e0);
                                                    if (relativeLayout.getLeft() > 0) {
                                                        layoutParams.rightMargin = BdUtilHelper.getDimens(getContext(), R.dimen.obfuscated_res_0x7f070401);
                                                    }
                                                    SkinManager.setImageResource(b4, R.drawable.icon_emotion_dui_n);
                                                    relativeLayout.addView(b4, layoutParams);
                                                } else {
                                                    it = it2;
                                                    i2 = 8;
                                                    relativeLayout = b2;
                                                    int intValue7 = tbRichTextData.Y().memeInfo.width.intValue();
                                                    int intValue8 = tbRichTextData.Y().memeInfo.height.intValue();
                                                    py5 py5Var7 = this.a;
                                                    k0(b3, intValue7, intValue8, py5Var7.m, py5Var7.n, this.e0);
                                                    relativeLayout.addView(b3);
                                                }
                                                view2 = relativeLayout;
                                            } else {
                                                it = it2;
                                                i2 = 8;
                                                view2 = view4;
                                            }
                                            i5 = i6;
                                            U = z6;
                                            imageView = view2;
                                        }
                                    } else {
                                        it = it2;
                                        i2 = 8;
                                        if (tbRichTextData.getType() == 1280) {
                                            ImageView imageView3 = getImageView();
                                            U = R(tbRichTextData, imageView3, (this.a.m - getPaddingLeft()) - getPaddingRight(), this.a.n);
                                            imageView = imageView3;
                                        } else if (tbRichTextData.getType() != 37 && tbRichTextData.getType() != 1281) {
                                            if (tbRichTextData.getType() == 36) {
                                                if (tbRichTextData.d0() != null && tbRichTextData.d0().Q() != null && (pbVar2 = this.i) != null) {
                                                    TiebaPlusRecommendCard b5 = pbVar2.b();
                                                    b5.s(tbRichTextData.d0());
                                                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) b5.getLayoutParams();
                                                    py5 py5Var8 = this.a;
                                                    marginLayoutParams.setMargins(0, py5Var8.z, 0, py5Var8.A);
                                                    b5.setLayoutParams(marginLayoutParams);
                                                    festivalTipView = b5;
                                                    U = true;
                                                    view4 = festivalTipView;
                                                } else {
                                                    U = false;
                                                    view4 = view4;
                                                }
                                            } else {
                                                if (tbRichTextData.getType() == 1282 && (pbVar = this.l) != null) {
                                                    FestivalTipView b6 = pbVar.b();
                                                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                                                    layoutParams2.topMargin = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_H_X004);
                                                    b6.setLayoutParams(layoutParams2);
                                                    b6.setFestivalTipViewData(tbRichTextData.T());
                                                    b6.setFestivalTipViewStyle(tbRichTextData.U());
                                                    b6.a();
                                                    b6.setFestivalTipViewClickCallBack(new p(this, tbRichTextData));
                                                    festivalTipView = b6;
                                                    U = true;
                                                    view4 = festivalTipView;
                                                }
                                                U = false;
                                                view4 = view4;
                                            }
                                        } else {
                                            ItemCardView itemCardView = getItemCardView();
                                            U = Q(itemCardView, tbRichTextData);
                                            view4 = itemCardView;
                                        }
                                    }
                                    view4 = imageView;
                                }
                            }
                            if (U && view4 != null) {
                                addView(view4);
                                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) view4.getLayoutParams();
                                if (!z12 && (i3 = this.a.G) >= 0) {
                                    if (layoutParams3 != null) {
                                        layoutParams3.topMargin = i3;
                                        view4.setLayoutParams(layoutParams3);
                                    }
                                    z12 = false;
                                } else if (!(view4 instanceof TbListTextView)) {
                                    if (!(view5 instanceof ImageView) && !(view5 instanceof RelativeLayout)) {
                                        layoutParams3.topMargin = this.a.e;
                                    } else {
                                        layoutParams3.topMargin = this.a.C;
                                    }
                                    view4.setLayoutParams(layoutParams3);
                                } else if ((!(view4 instanceof ImageView) && !(view4 instanceof RelativeLayout)) || (tbRichTextData.getType() != i2 && tbRichTextData.getType() != 20 && tbRichTextData.getType() != 17)) {
                                    if ((view4 instanceof ItemCardView) && !z12) {
                                        layoutParams3.topMargin = this.a.H;
                                        view4.setLayoutParams(layoutParams3);
                                    }
                                } else {
                                    if (view5 instanceof TbListTextView) {
                                        layoutParams3.topMargin = this.a.x;
                                    } else if (!(view5 instanceof ImageView) && !(view4 instanceof RelativeLayout)) {
                                        layoutParams3.topMargin = this.a.e;
                                    } else {
                                        layoutParams3.topMargin = this.a.w;
                                    }
                                    view4.setLayoutParams(layoutParams3);
                                }
                                view5 = view4;
                            }
                            tVar2 = tVar;
                            it2 = it;
                            iVar = null;
                            z10 = true;
                        }
                        it = it2;
                        linearLayout = gifView;
                        i2 = 8;
                        view4 = linearLayout;
                        if (U) {
                            addView(view4);
                            LinearLayout.LayoutParams layoutParams32 = (LinearLayout.LayoutParams) view4.getLayoutParams();
                            if (!z12) {
                            }
                            if (!(view4 instanceof TbListTextView)) {
                            }
                            view5 = view4;
                        }
                        tVar2 = tVar;
                        it2 = it;
                        iVar = null;
                        z10 = true;
                    }
                }
                if (view5 instanceof TbListTextView) {
                    LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) view5.getLayoutParams();
                    layoutParams4.bottomMargin = this.a.F;
                    view5.setLayoutParams(layoutParams4);
                } else if (view5 != null && this.a.E >= 0) {
                    LinearLayout.LayoutParams layoutParams5 = (LinearLayout.LayoutParams) view5.getLayoutParams();
                    layoutParams5.bottomMargin = this.a.E;
                    view5.setLayoutParams(layoutParams5);
                }
                if (!z3 && (au9Var = this.b) != null) {
                    au9Var.c();
                }
            }
        }
    }
}
