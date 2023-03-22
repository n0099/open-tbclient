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
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ItemData;
import com.baidu.tbadk.core.data.ThreadData;
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
import com.baidu.tieba.a9;
import com.baidu.tieba.bc9;
import com.baidu.tieba.bg;
import com.baidu.tieba.cg;
import com.baidu.tieba.f9;
import com.baidu.tieba.g9;
import com.baidu.tieba.hi;
import com.baidu.tieba.ih8;
import com.baidu.tieba.je9;
import com.baidu.tieba.mj8;
import com.baidu.tieba.n15;
import com.baidu.tieba.oo9;
import com.baidu.tieba.pk;
import com.baidu.tieba.pv4;
import com.baidu.tieba.qt5;
import com.baidu.tieba.rm;
import com.baidu.tieba.t45;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBnt;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.up9;
import com.baidu.tieba.view.festivalview.FestivalTipView;
import com.baidu.tieba.vt5;
import com.baidu.tieba.wp9;
import com.baidu.tieba.xf;
import com.baidu.tieba.yf;
import com.baidu.tieba.yt5;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import tbclient.MemeInfo;
import tbclient.PbContent;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes3.dex */
public class TbRichTextView extends LinearLayout implements pk {
    public static /* synthetic */ Interceptable $ic;
    public static final float v0;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public Runnable B;
    public boolean C;
    public z D;
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
    public boolean T;
    public boolean U;
    public String V;
    public String W;
    public qt5 a;
    public Position a0;
    public ih8<ImageView> b;
    public vt5 b0;
    public xf<ImageView> c;
    public View.OnLongClickListener c0;
    public xf<TextView> d;
    public x d0;
    public xf<View> e;
    public final View.OnClickListener e0;
    public xf<LinearLayout> f;
    public final mj8 f0;
    public xf<RelativeLayout> g;
    public final View.OnClickListener g0;
    public xf<GifView> h;
    public final y h0;
    public xf<TiebaPlusRecommendCard> i;
    public boolean i0;
    public GridImageLayout j;
    public Drawable j0;
    public xf<ItemCardView> k;
    public xf<FestivalTipView> l;
    public boolean m;
    public TextUtils.TruncateAt n;
    public c0 o;
    public a0 p;
    public mj8 q;
    public b0 r;
    public String r0;
    public View.OnClickListener s;
    public BdUniqueId s0;
    public View.OnClickListener t;
    public final bg<rm> t0;
    public View.OnClickListener u;
    public CustomMessageListener u0;
    public boolean v;
    public boolean w;
    public int x;
    public View.OnClickListener y;
    public boolean z;

    /* loaded from: classes3.dex */
    public interface a0 {
        void a(View view2, String str, int i, boolean z, boolean z2);
    }

    /* loaded from: classes3.dex */
    public interface b0 {
        void a(View view2, String str);
    }

    /* loaded from: classes3.dex */
    public interface u {
        void C0(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView);
    }

    /* loaded from: classes3.dex */
    public interface x {
        void a();

        void b();
    }

    /* loaded from: classes3.dex */
    public interface y {
        void dispatchTouchEvent(MotionEvent motionEvent);
    }

    /* loaded from: classes3.dex */
    public interface z {
        void a(View view2, String str, String str2, String str3, String str4, String str5, String str6, int i, int i2);
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
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
                TbRichTextEmotionInfo U = this.a.U();
                z zVar = this.b.D;
                GifInfo gifInfo = U.mGifInfo;
                zVar.a(view2, gifInfo.mGid, gifInfo.mPackageName, gifInfo.mIcon, gifInfo.mStaticUrl, gifInfo.mDynamicUrl, gifInfo.mSharpText, gifInfo.mGifWidth, gifInfo.mGifHeight);
            }
        }
    }

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
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
                    int intValue = this.a.a0().a().buttonLinkType.intValue();
                    if (this.a.a0().a().apkDetail != null) {
                        i = this.a.a0().a().apkDetail.pkg_source.intValue();
                    }
                    ItemCardHelper.q(this.b.getPosition(), this.a.a0().a().itemId, this.b.z(this.a.a0().a()), this.c.V, t45.a(intValue, i), "", 2);
                    ItemClickJumpUtil.itemClickJump(this.a.a0().a().forumName, String.valueOf(this.a.a0().a().itemId), 3, 3);
                } else if (this.a.getType() == 1281) {
                    TiebaStatic.log(new StatisticItem("common_click").param("page_type", "a005").param(TiebaStatic.Params.GUA_TYPE, 2).param("obj_locate", 16));
                    int intValue2 = this.a.V().getItem().button_link_type.intValue();
                    if (this.a.V().getItem().apk_detail != null) {
                        i = this.a.V().getItem().apk_detail.pkg_source.intValue();
                    }
                    int a = t45.a(intValue2, i);
                    ItemData itemData = new ItemData();
                    itemData.parseProto(this.a.V().getItem());
                    ItemCardHelper.q(this.b.getPosition(), this.a.V().getItem().item_id.longValue(), this.b.z(itemData), this.c.V, a, "", 2);
                    ItemClickJumpUtil.itemClickJump(this.a.V().getItemForumName(), this.a.V().getItemID(), 3, 3);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements y {
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

        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.y
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

    /* loaded from: classes3.dex */
    public class f extends bg<rm> {
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

        @Override // com.baidu.tieba.bg
        public void onCancelled(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                super.onCancelled(str);
            }
        }

        @Override // com.baidu.tieba.bg
        public void onProgressUpdate(Object... objArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, objArr) == null) {
                super.onProgressUpdate(objArr);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.bg
        public void onLoaded(rm rmVar, String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, rmVar, str, i) == null) {
                if (rmVar == null) {
                    if (this.a.d0 != null) {
                        this.a.d0.a();
                    }
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.PB_FIRST_FLOOR_BUBBLE_LOAD_FAIL).param("tid", this.a.V).param(TiebaStatic.Params.OBJ_URL, str));
                    return;
                }
                this.a.F(rmVar);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbRichTextView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(TbRichTextView tbRichTextView, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbRichTextView, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbRichTextView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int contentSize;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                if (this.a.J) {
                    contentSize = TbConfig.getOutterSubpbContentSize();
                } else {
                    contentSize = TbConfig.getContentSize();
                }
                if (this.a.E != null && !ListUtils.isEmpty(this.a.E.T())) {
                    Iterator<TbRichTextData> it = this.a.E.T().iterator();
                    while (it.hasNext()) {
                        TbRichTextData next = it.next();
                        if (next != null) {
                            next.o0(contentSize, contentSize);
                        }
                    }
                }
                this.a.setTextSize(contentSize);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class h implements yf<ImageView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbRichTextView a;

        public ImageView h(ImageView imageView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, imageView)) == null) ? imageView : (ImageView) invokeL.objValue;
        }

        public h(TbRichTextView tbRichTextView) {
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
        @Override // com.baidu.tieba.yf
        public /* bridge */ /* synthetic */ ImageView a(ImageView imageView) {
            ImageView imageView2 = imageView;
            e(imageView2);
            return imageView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.yf
        public /* bridge */ /* synthetic */ ImageView c(ImageView imageView) {
            ImageView imageView2 = imageView;
            h(imageView2);
            return imageView2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yf
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

        public ImageView e(ImageView imageView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, imageView)) == null) {
                if (imageView instanceof TbImageView) {
                    TbImageView tbImageView = (TbImageView) imageView;
                    tbImageView.setTag(null);
                    if (pv4.c().g()) {
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
        @Override // com.baidu.tieba.yf
        /* renamed from: g */
        public ImageView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(g9.a(this.a.getContext()).getPageActivity());
                boolean g = pv4.c().g();
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

    /* loaded from: classes3.dex */
    public class i extends ih8<ImageView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbRichTextView e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(TbRichTextView tbRichTextView, yf yfVar, int i, int i2) {
            super(yfVar, i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbRichTextView, yfVar, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((yf) objArr2[0], ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = tbRichTextView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ih8
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

    /* loaded from: classes3.dex */
    public class j extends vt5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbRichTextView i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(TbRichTextView tbRichTextView, int i, String str) {
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
            this.i = tbRichTextView;
        }

        @Override // com.baidu.tieba.vt5, android.text.style.ClickableSpan
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.i.setAddExpandableListener(false);
                this.i.setTextEllipsize(TextUtils.TruncateAt.END);
                this.i.setMaxLines(5);
                this.i.setAddTruncateListener(true);
                this.i.E.isChanged = true;
                TbRichTextView tbRichTextView = this.i;
                tbRichTextView.setText(tbRichTextView.E);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class k implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbRichTextView a;

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

    /* loaded from: classes3.dex */
    public class l implements mj8.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbRichTextView a;

        @Override // com.baidu.tieba.mj8.a
        public boolean a(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                return false;
            }
            return invokeLL.booleanValue;
        }

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

        @Override // com.baidu.tieba.mj8.a
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

        @Override // com.baidu.tieba.mj8.a
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

    /* loaded from: classes3.dex */
    public class m implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbRichTextView a;

        public m(TbRichTextView tbRichTextView) {
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
                if (tag != null && (tag instanceof w)) {
                    str = ((w) tag).a;
                }
                this.a.r.a(view2, str);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class n implements yf<TextView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;

        public TextView e(TextView textView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, textView)) == null) ? textView : (TextView) invokeL.objValue;
        }

        public n(Context context) {
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
        @Override // com.baidu.tieba.yf
        public /* bridge */ /* synthetic */ TextView a(TextView textView) {
            TextView textView2 = textView;
            e(textView2);
            return textView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.yf
        public /* bridge */ /* synthetic */ TextView c(TextView textView) {
            TextView textView2 = textView;
            h(textView2);
            return textView2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yf
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
        @Override // com.baidu.tieba.yf
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

    /* loaded from: classes3.dex */
    public static class o implements yf<FestivalTipView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ int b;

        public FestivalTipView e(FestivalTipView festivalTipView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, festivalTipView)) == null) ? festivalTipView : (FestivalTipView) invokeL.objValue;
        }

        public o(Context context, int i) {
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
        @Override // com.baidu.tieba.yf
        public /* bridge */ /* synthetic */ FestivalTipView a(FestivalTipView festivalTipView) {
            FestivalTipView festivalTipView2 = festivalTipView;
            e(festivalTipView2);
            return festivalTipView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.yf
        public /* bridge */ /* synthetic */ FestivalTipView c(FestivalTipView festivalTipView) {
            FestivalTipView festivalTipView2 = festivalTipView;
            h(festivalTipView2);
            return festivalTipView2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yf
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
        @Override // com.baidu.tieba.yf
        /* renamed from: g */
        public FestivalTipView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                FestivalTipView festivalTipView = new FestivalTipView(this.a);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                layoutParams.topMargin = hi.g(TbadkCoreApplication.getInst(), this.b);
                festivalTipView.setLayoutParams(layoutParams);
                return festivalTipView;
            }
            return (FestivalTipView) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class p implements ViewGroup.OnHierarchyChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbRichTextView a;

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewAdded(View view2, View view3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, view2, view3) == null) {
            }
        }

        public p(TbRichTextView tbRichTextView) {
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
                    if ((tag instanceof v) && ((v) tag).a) {
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
                    if ((tag2 instanceof v) && ((v) tag2).a) {
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

    /* loaded from: classes3.dex */
    public class q implements up9 {
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

        @Override // com.baidu.tieba.up9
        public void onClick(@NonNull View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.W() != null && !TextUtils.isEmpty(this.a.W().c()) && (this.b.getContext() instanceof TbPageContextSupport)) {
                    TbPageContext<?> pageContext = ((TbPageContextSupport) this.b.getContext()).getPageContext();
                    if (pageContext == null) {
                        return;
                    }
                    UrlManager.getInstance().dealOneLink(pageContext, new String[]{this.a.W().c()});
                }
                wp9.a(this.b.V, this.b.W, this.b.a0);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class r implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbRichTextData a;
        public final /* synthetic */ TbRichTextView b;

        public r(TbRichTextView tbRichTextView, TbRichTextData tbRichTextData) {
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.d0() != null) {
                if (this.b.getContext() instanceof yt5) {
                    ((yt5) this.b.getContext()).J(this.b.getContext(), this.a.d0().toString());
                    return;
                }
                a9<?> a = g9.a(this.b.getContext());
                if (a != null && (a.getOrignalPage() instanceof yt5)) {
                    ((yt5) a.getOrignalPage()).J(this.b.getContext(), this.a.d0().toString());
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class s implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbRichTextView a;

        public s(TbRichTextView tbRichTextView) {
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

    /* loaded from: classes3.dex */
    public static class t {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;

        public t() {
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

        public /* synthetic */ t(j jVar) {
            this();
        }
    }

    /* loaded from: classes3.dex */
    public static class v {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;

        public v() {
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

        public /* synthetic */ v(j jVar) {
            this();
        }
    }

    /* loaded from: classes3.dex */
    public static class w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        public w(String str) {
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
        v0 = hi.i(TbadkCoreApplication.getInst());
    }

    private ItemCardView getItemCardView() {
        InterceptResult invokeV;
        ItemCardView itemCardView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65562, this)) == null) {
            xf<ItemCardView> xfVar = this.k;
            if (xfVar != null) {
                itemCardView = xfVar.b();
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
                this.B = new s(this);
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

    public qt5 getLayoutStrategy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.a;
        }
        return (qt5) invokeV.objValue;
    }

    public a0 getOnImageClickListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.p;
        }
        return (a0) invokeV.objValue;
    }

    public b0 getOnLinkImageClickListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.r;
        }
        return (b0) invokeV.objValue;
    }

    public ih8<ImageView> getRecycleImageViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            if (this.b == null) {
                this.b = new i(this, new h(this), 10, 0);
            }
            return this.b;
        }
        return (ih8) invokeV.objValue;
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
            qt5 qt5Var = this.a;
            if (qt5Var != null) {
                qt5Var.e();
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
        cg.h().d(this.r0, 19, this.t0);
        setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.pk
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
        this.a = new qt5();
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
        this.T = false;
        this.U = false;
        this.b0 = new j(this, 2, null);
        this.e0 = new k(this);
        this.f0 = new mj8(new l(this));
        this.g0 = new m(this);
        this.h0 = new e(this);
        this.t0 = new f(this);
        this.u0 = new g(this, 2004018);
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
        this.a = new qt5();
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
        this.T = false;
        this.U = false;
        this.b0 = new j(this, 2, null);
        this.e0 = new k(this);
        this.f0 = new mj8(new l(this));
        this.g0 = new m(this);
        this.h0 = new e(this);
        this.t0 = new f(this);
        this.u0 = new g(this, 2004018);
        M();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, je9.TbRichTextView);
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
            qt5 qt5Var = this.a;
            if (qt5Var != null) {
                qt5Var.u = z2;
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
            this.T = z2;
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

    public void setLayoutStrategy(qt5 qt5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048635, this, qt5Var) == null) && qt5Var != null) {
            this.a.e();
            this.a = qt5Var;
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
            qt5 qt5Var = this.a;
            if (i2 == qt5Var.r) {
                return;
            }
            qt5Var.r = i2;
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

    public void setOnEmotionClickListener(z zVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048639, this, zVar) == null) {
            this.D = zVar;
        }
    }

    public void setOnImageClickListener(a0 a0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048640, this, a0Var) == null) {
            this.p = a0Var;
            GridImageLayout gridImageLayout = this.j;
            if (gridImageLayout != null) {
                gridImageLayout.setOnImageClickListener(a0Var);
            }
        }
    }

    public void setOnImageTouchListener(mj8 mj8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048641, this, mj8Var) == null) {
            this.q = mj8Var;
        }
    }

    public void setOnLinkImageClickListener(b0 b0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048642, this, b0Var) == null) {
            this.r = b0Var;
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
            qt5 qt5Var = this.a;
            if (i2 == qt5Var.l) {
                return;
            }
            qt5Var.l = i2;
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

    public static xf<FestivalTipView> G(Context context, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65544, null, context, i2)) == null) {
            return new xf<>(new o(context, i2), 10, 0);
        }
        return (xf) invokeLI.objValue;
    }

    public static xf<TextView> H(Context context, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65545, null, context, i2)) == null) {
            return new xf<>(new n(context), i2, 0);
        }
        return (xf) invokeLI.objValue;
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

    public void q0(String str, x xVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048617, this, str, xVar) == null) {
            this.d0 = xVar;
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

    public void setText(TbRichText tbRichText, boolean z2, u uVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048650, this, new Object[]{tbRichText, Boolean.valueOf(z2), uVar}) == null) {
            setText(tbRichText, z2, uVar, false, false);
        }
    }

    public static TbRichText b0(List<PbContent> list, String str, boolean z2, @Nullable bc9 bc9Var, @Nullable ThreadData threadData, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65551, null, new Object[]{list, str, Boolean.valueOf(z2), bc9Var, threadData, Integer.valueOf(i2)})) == null) {
            return new TbRichText(list, str, z2, bc9Var, threadData, i2);
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
            xf<GifView> xfVar = this.h;
            if (xfVar != null) {
                gifView = xfVar.b();
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
                str = StringHelper.STRING_MORE;
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
            xf<ImageView> xfVar = this.c;
            ImageView imageView2 = null;
            if (xfVar != null) {
                imageView = xfVar.b();
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

    public final void F(rm rmVar) {
        int i2;
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, rmVar) != null) || rmVar == null) {
            return;
        }
        try {
            if (this.a.b() != null) {
                Rect b2 = this.a.b();
                if (b2.left != -1) {
                    i2 = b2.left;
                } else {
                    i2 = rmVar.j.left;
                }
                if (b2.top != -1) {
                    i3 = b2.top;
                } else {
                    i3 = rmVar.j.top;
                }
                if (b2.right != -1) {
                    i4 = b2.right;
                } else {
                    i4 = rmVar.j.right;
                }
                if (b2.bottom == -1) {
                    b2 = rmVar.j;
                }
                rmVar.j = new Rect(i2, i3, i4, b2.bottom);
            }
            NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(getResources(), rmVar.p(), rmVar.p().getNinePatchChunk(), rmVar.o(), null);
            if (TbadkCoreApplication.getInst().getSkinType() == 4) {
                ninePatchDrawable.getPaint().setAlpha(80);
            }
            setBackgroundDrawable(ninePatchDrawable);
            x xVar = this.d0;
            if (xVar != null) {
                xVar.b();
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
                linearLayout.setOnClickListener(new r(this, tbRichTextData));
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
            xf<View> xfVar = this.e;
            if (xfVar != null) {
                view3 = xfVar.b();
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
            f9 c2 = g9.c(getContext());
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
            rm rmVar = (rm) cg.h().n(this.r0, 19, new Object[0]);
            if (rmVar != null) {
                F(rmVar);
            } else if (z2) {
                invalidate();
            } else if (!cg.h().j(19)) {
                invalidate();
            } else {
                cg.h().k(this.r0, 19, this.t0, 0, 0, this.s0, new Object[0]);
            }
        }
    }

    public TextView I(Context context) {
        InterceptResult invokeL;
        TextView textView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            xf<TextView> xfVar = this.d;
            if (xfVar != null) {
                textView = xfVar.b();
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

    public void setFaceSize(float f2) {
        int emotionContentSize;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048626, this, f2) == null) {
            if (this.T && UbsABTestHelper.isResizeEmotionABTest()) {
                if (this.J) {
                    emotionContentSize = TbConfig.getEmotionContentSizeOfLzl();
                } else {
                    emotionContentSize = TbConfig.getEmotionContentSize();
                }
                qt5 qt5Var = this.a;
                qt5Var.h = emotionContentSize;
                qt5Var.i = emotionContentSize;
                return;
            }
            qt5 qt5Var2 = this.a;
            int i2 = (int) f2;
            qt5Var2.h = i2;
            qt5Var2.i = i2;
        }
    }

    public void setTextPadding(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048656, this, i2) == null) {
            qt5 qt5Var = this.a;
            if (qt5Var.d == i2) {
                return;
            }
            qt5Var.d = i2;
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
            qt5 qt5Var = this.a;
            if (f2 == qt5Var.f) {
                return;
            }
            qt5Var.f = f2;
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
        yt5 yt5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            a9<?> a2 = g9.a(getContext());
            if (getContext() instanceof yt5) {
                yt5Var = (yt5) getContext();
            } else if (a2 != null && (a2.getOrignalPage() instanceof yt5)) {
                yt5Var = (yt5) a2.getOrignalPage();
            } else {
                yt5Var = null;
            }
            if (yt5Var == null && (getContext() instanceof BaseFragmentActivity)) {
                List<Fragment> fragments = ((BaseFragmentActivity) getContext()).getSupportFragmentManager().getFragments();
                if (!ListUtils.isEmpty(fragments) && (fragments.get(0) instanceof yt5)) {
                    yt5Var = (yt5) fragments.get(0);
                }
            }
            if (a2 != null) {
                a2.registerListener(this.u0);
            }
            if (yt5Var != null) {
                this.c = yt5Var.V();
                this.d = yt5Var.Y0();
                this.e = yt5Var.W();
                this.f = yt5Var.A();
                this.h = yt5Var.x();
                this.i = yt5Var.D1();
                this.g = yt5Var.R();
                this.k = yt5Var.n0();
                this.l = yt5Var.T();
                if (yt5Var.getListView() != null && this.o == null) {
                    this.o = new c0(yt5Var.E());
                    yt5Var.getListView().setRecyclerListener(this.o);
                }
            }
            this.Q = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds21);
            setOrientation(1);
            setOnHierarchyChangeListener(new p(this));
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
                spannableStringBuilder.append((CharSequence) StringHelper.STRING_MORE);
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
            if (layoutParams != null && layoutParams.width == tbRichTextData.U().mGifInfo.mGifWidth && layoutParams.height == tbRichTextData.U().mGifInfo.mGifHeight) {
                layoutParams.bottomMargin = 0;
            } else {
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(tbRichTextData.U().mGifInfo.mGifWidth, tbRichTextData.U().mGifInfo.mGifHeight);
                layoutParams2.gravity = 3;
                gifView.setLayoutParams(layoutParams2);
            }
            gifView.setOnClickListener(new c(this, tbRichTextData));
            gifView.k0(tbRichTextData.U().mGifInfo);
            return true;
        }
        return invokeLL.booleanValue;
    }

    public final boolean P(TbRichTextData tbRichTextData, ImageView imageView, int i2, int i3, boolean z2) {
        InterceptResult invokeCommon;
        String S;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{tbRichTextData, imageView, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z2)})) == null) {
            if (tbRichTextData == null || imageView == null || tbRichTextData.Z() == null) {
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
                tbImageView.setTLIconType(tbRichTextData.Y());
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
                    S = tbRichTextData.Z().R();
                } else {
                    S = tbRichTextData.Z().S();
                }
                if (!z2 || tbImageView.getUrl() == null || !tbImageView.getUrl().equals(S)) {
                    if (this.w) {
                        i4 = 17;
                    } else {
                        i4 = 18;
                    }
                    tbImageView.M(S, i4, false);
                }
                if (!tbRichTextData.Z().W()) {
                    tbImageView.setAdjustViewBounds(false);
                }
                tbImageView.setTag(R.id.tag_rich_text_meme_info, null);
            }
            return j0(imageView, tbRichTextData.Z().getWidth(), tbRichTextData.Z().getHeight(), i2, i3, this.e0);
        }
        return invokeCommon.booleanValue;
    }

    public final boolean Q(ItemCardView itemCardView, TbRichTextData tbRichTextData) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, itemCardView, tbRichTextData)) == null) {
            if (tbRichTextData != null) {
                if (tbRichTextData.a0() != null || tbRichTextData.V() != null) {
                    if (tbRichTextData.getType() == 37) {
                        itemCardView.setPosition(9);
                    } else if (tbRichTextData.getType() == 1281) {
                        itemCardView.setPosition(4);
                    }
                    itemCardView.setOnClickListener(new d(this, tbRichTextData, itemCardView));
                    itemCardView.setOnClickListenerOfRightBtn(this.u);
                    itemCardView.setIsShowRightBtn(this.U);
                    if (tbRichTextData.getType() == 37) {
                        itemCardView.setData(tbRichTextData.a0().a(), 17, this.V);
                    } else if (tbRichTextData.getType() == 1281) {
                        itemCardView.setData(tbRichTextData.V(), 17, this.V);
                    }
                    itemCardView.G();
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
        TbRichTextLinkImageInfo b02;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(1048586, this, tbRichTextData, imageView, i2, i3)) == null) {
            if (tbRichTextData == null || imageView == null || (b02 = tbRichTextData.b0()) == null || b02.getLink() == null) {
                return false;
            }
            if (imageView instanceof TbImageView) {
                TbImageView tbImageView = (TbImageView) imageView;
                if (this.a.t) {
                    tbImageView.setSupportNoImage(true);
                }
                String R = b02.R();
                if (this.w) {
                    i4 = 17;
                } else {
                    i4 = 18;
                }
                tbImageView.M(R, i4, false);
                tbImageView.setTag(new w(b02.getLink()));
                if (!b02.S()) {
                    tbImageView.setAdjustViewBounds(false);
                }
            }
            return k0(imageView, b02.getWidth(), b02.getHeight(), i2, i3, this.g0);
        }
        return invokeLLII.booleanValue;
    }

    public final boolean S(TbRichTextData tbRichTextData, ImageView imageView, int i2, int i3) {
        InterceptResult invokeLLII;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(1048587, this, tbRichTextData, imageView, i2, i3)) == null) {
            if (tbRichTextData == null || imageView == null || tbRichTextData.c0() == null) {
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
                String str = tbRichTextData.c0().memeInfo.pic_url;
                if (this.w) {
                    i4 = 17;
                } else {
                    i4 = 18;
                }
                tbImageView.M(str, i4, false);
                tbImageView.setAdjustViewBounds(false);
                tbImageView.setTag(R.id.tag_rich_text_meme_info, tbRichTextData.c0());
            }
            return k0(imageView, tbRichTextData.c0().memeInfo.width.intValue(), tbRichTextData.c0().memeInfo.height.intValue(), i2, i3, this.e0);
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
            String T = tbRichTextData.Z().T();
            if (StringUtils.isNull(T)) {
                qt5 qt5Var = this.a;
                if (qt5Var.I) {
                    if (qt5Var.u) {
                        T = tbRichTextData.Z().R();
                    } else {
                        T = tbRichTextData.Z().getBigSrc();
                    }
                }
                if (StringUtils.isNull(T)) {
                    if (this.a.u) {
                        T = tbRichTextData.Z().S();
                    } else {
                        T = tbRichTextData.Z().getSrc();
                    }
                }
            }
            gifView.setShowStaticDrawable(false);
            if (!z2 || gifView.getUrl() == null || !gifView.getUrl().equals(T)) {
                gifView.l0(T, 38);
            }
            int width = tbRichTextData.Z().getWidth();
            int height = tbRichTextData.Z().getHeight();
            qt5 qt5Var2 = this.a;
            return j0(gifView, width, height, qt5Var2.m, qt5Var2.n, this.e0);
        }
        return invokeLLZ.booleanValue;
    }

    public final boolean U(TbRichTextData tbRichTextData, TextView textView, boolean z2, u uVar) {
        InterceptResult invokeCommon;
        LinearLayout.LayoutParams layoutParams;
        SpannableStringBuilder d0;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{tbRichTextData, textView, Boolean.valueOf(z2), uVar})) == null) {
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
            qt5 qt5Var = this.a;
            textView.setLineSpacing(qt5Var.c, qt5Var.a);
            textView.setTextSize(0, this.a.f);
            if (this.a.g) {
                n15.d(textView).B(R.string.F_X02);
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
                n15.d(textView).z(R.array.S_O_X001);
            }
            int i3 = this.G;
            if (i3 > 0) {
                textView.setMaxWidth(i3);
            }
            int i4 = this.H;
            if (i4 > 0) {
                textView.setMaxLines(i4);
            }
            if (tbRichTextData == null || (d0 = tbRichTextData.d0()) == null || d0.length() <= 0) {
                return false;
            }
            qt5 qt5Var2 = this.a;
            int i5 = qt5Var2.i;
            if (i5 > 0 && (i2 = qt5Var2.h) > 0) {
                tbRichTextData.o0(i2, i5);
            }
            qt5 qt5Var3 = this.a;
            if (qt5Var3.j > 0 || qt5Var3.k > 0) {
                qt5 qt5Var4 = this.a;
                tbRichTextData.n0(qt5Var4.j, qt5Var4.k);
            }
            tbRichTextData.n0(8, 0);
            if (uVar != null) {
                uVar.C0(d0, textView, this);
            }
            try {
                textView.setText(d0);
            } catch (Exception unused) {
                textView.setText("");
            }
            if (this.I) {
                if (tbRichTextData.k0()) {
                    textView.setMovementMethod(oo9.a());
                } else {
                    textView.setMovementMethod(LinkMovementMethod.getInstance());
                }
            }
            textView.setFocusable(false);
            textView.setLayoutParams(layoutParams);
            textView.setTag(tbRichTextData);
            if (tbRichTextData != null && tbRichTextData.f0() != null) {
                tbRichTextData.f0().needRecompute = this.i0;
                return true;
            }
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public final boolean V(TbRichTextData tbRichTextData, LinearLayout linearLayout, u uVar) {
        InterceptResult invokeLLL;
        boolean W;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048590, this, tbRichTextData, linearLayout, uVar)) == null) {
            if (linearLayout == null) {
                return false;
            }
            int childCount = linearLayout.getChildCount();
            boolean z2 = true;
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = linearLayout.getChildAt(i2);
                if (childAt != null) {
                    if (childAt instanceof TextView) {
                        W = U(tbRichTextData, (TextView) childAt, false, uVar);
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
            view2.setTag(tbRichTextData.j0());
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view2.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
            }
            view2.setLayoutParams(layoutParams);
            if (view2 instanceof PlayVoiceBntNew) {
                ((PlayVoiceBntNew) view2).e();
                return true;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public void setDisplayImage(boolean z2, boolean z3) {
        xf<ImageView> xfVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048624, this, new Object[]{Boolean.valueOf(z2), Boolean.valueOf(z3)}) != null) || this.v == z2) {
            return;
        }
        this.v = z2;
        if (z3) {
            requestLayout();
        }
        if (!this.v && (xfVar = this.c) != null) {
            xfVar.c();
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
                if (view2.getTag(R.id.tag_rich_text_view_gif_view) == null || !(view2.getTag(R.id.tag_rich_text_view_gif_view) instanceof t) || !((t) view2.getTag(R.id.tag_rich_text_view_gif_view)).a) {
                    return false;
                }
                return true;
            }
            if ((view2 instanceof TbImageView) && view2.getTag() != null) {
                if (view2.getTag() instanceof w) {
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
        int[] n2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048596, this, new Object[]{relativeLayout, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) != null) || (n2 = hi.n(i2, i3, i4, i5)) == null) {
            return;
        }
        int[] iArr = {n2[0], n2[1]};
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
        int[] n2;
        int i6;
        int i7;
        int g2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048603, this, new Object[]{relativeLayout, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) != null) || (n2 = hi.n(i2, i3, i4, i5)) == null) {
            return;
        }
        int[] iArr = {n2[0], n2[1]};
        int i8 = iArr[0];
        int i9 = iArr[1];
        if (this.a.v && i4 > i8) {
            float f2 = v0;
            if (f2 > 1.0f) {
                float f3 = i8;
                float f4 = i4;
                if (f3 * f2 > f4) {
                    i7 = i4 - hi.g(getContext(), R.dimen.obfuscated_res_0x7f070301);
                    g2 = hi.g(getContext(), R.dimen.obfuscated_res_0x7f0701be);
                } else {
                    float f5 = f4 * 0.68f;
                    if (f3 * f2 > f5) {
                        i7 = (int) f5;
                        g2 = hi.g(getContext(), R.dimen.obfuscated_res_0x7f070301);
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

    public final boolean i0(ImageView imageView, int i2, int i3, int i4, int i5, View.OnClickListener onClickListener) {
        InterceptResult invokeCommon;
        View.OnLongClickListener onLongClickListener;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048604, this, new Object[]{imageView, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), onClickListener})) == null) {
            int[] n2 = hi.n(i2, i3, i4, i5);
            if (n2 == null) {
                return false;
            }
            int[] iArr = {n2[0], n2[1]};
            int i6 = iArr[0];
            int i7 = iArr[1];
            if (this.a.v && i4 > i6) {
                float f2 = v0;
                if (f2 > 1.0f) {
                    float f3 = i6;
                    float f4 = i4;
                    if (f3 * f2 > f4) {
                        i6 = (i4 - hi.g(getContext(), R.dimen.obfuscated_res_0x7f070301)) - hi.g(getContext(), R.dimen.obfuscated_res_0x7f0701be);
                    } else {
                        float f5 = f4 * 0.68f;
                        if (f3 * f2 > f5) {
                            i6 = ((int) f5) - hi.g(getContext(), R.dimen.obfuscated_res_0x7f070301);
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
            qt5 qt5Var = this.a;
            if (qt5Var.v) {
                imageView.setScaleType(qt5Var.s);
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
            int[] n2 = hi.n(i2, i3, i4, i5);
            if (n2 == null) {
                return false;
            }
            int[] iArr = {n2[0], n2[1]};
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
    public void setText(TbRichText tbRichText, boolean z2, u uVar, boolean z3, boolean z4) {
        ArrayList<TbRichTextData> T;
        ih8<ImageView> ih8Var;
        boolean U;
        TbRichTextData tbRichTextData;
        SpannableStringBuilder d0;
        boolean z5;
        Iterator<TbRichTextData> it;
        LinearLayout linearLayout;
        int i2;
        GifView gifView;
        int i3;
        xf<FestivalTipView> xfVar;
        FestivalTipView festivalTipView;
        xf<TiebaPlusRecommendCard> xfVar2;
        ImageView imageView;
        boolean z6;
        View view2;
        RelativeLayout relativeLayout;
        int i4;
        TbRichTextData tbRichTextData2;
        View view3;
        Object imageView2;
        boolean z7;
        String S;
        Object obj;
        boolean z8;
        Object obj2;
        boolean z9;
        GifView gifView2;
        GifView gifView3;
        Object obj3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048651, this, new Object[]{tbRichText, Boolean.valueOf(z2), uVar, Boolean.valueOf(z3), Boolean.valueOf(z4)}) == null) {
            u uVar2 = uVar;
            if (this.E == tbRichText && (tbRichText == null || !tbRichText.isChanged)) {
                return;
            }
            if (tbRichText != null) {
                tbRichText.isChanged = false;
            }
            this.E = tbRichText;
            removeAllViews();
            if (tbRichText != null && (T = tbRichText.T()) != null) {
                Iterator<TbRichTextData> it2 = T.iterator();
                j jVar = null;
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
                            U = U(next, I, z10, uVar2);
                            if (z2 && !this.C && (d0 = next.d0()) != null) {
                                if (d0.length() >= 200) {
                                    z5 = true;
                                } else {
                                    z5 = false;
                                }
                                this.C = z5;
                            }
                            TiePlusEventController.l(next.g0());
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
                                    if (next.Z() != null) {
                                        if (TbadkCoreApplication.getInst().isGifAutoPlay() && !next.Z().Y()) {
                                            if (z4) {
                                                String T2 = next.Z().T();
                                                if (StringUtils.isNull(T2)) {
                                                    qt5 qt5Var = this.a;
                                                    if (qt5Var.I) {
                                                        if (qt5Var.u) {
                                                            T2 = next.Z().R();
                                                        } else {
                                                            T2 = next.Z().getBigSrc();
                                                        }
                                                    }
                                                    if (StringUtils.isNull(T2)) {
                                                        if (this.a.u) {
                                                            T2 = next.Z().S();
                                                        } else {
                                                            T2 = next.Z().getSrc();
                                                        }
                                                    }
                                                }
                                                ih8<ImageView> ih8Var2 = this.b;
                                                if (ih8Var2 != null) {
                                                    Object obj4 = (ImageView) ih8Var2.h(T2);
                                                    if (obj4 instanceof GifView) {
                                                        obj3 = (GifView) obj4;
                                                        if (obj3 != null) {
                                                            gifView3 = getGifView();
                                                        } else {
                                                            z9 = true;
                                                            gifView2 = obj3;
                                                            t tVar = new t(jVar);
                                                            tVar.a = z10;
                                                            gifView2.setTag(R.id.tag_rich_text_view_gif_view, tVar);
                                                            U = T(next, gifView2, z9);
                                                            if (z3) {
                                                                v vVar = new v(jVar);
                                                                vVar.a = z10;
                                                                gifView2.setTag(R.id.tag_rich_text_view_recycle, vVar);
                                                            }
                                                            tbRichTextData2 = next;
                                                            view3 = gifView2;
                                                        }
                                                    }
                                                }
                                                obj3 = jVar;
                                                if (obj3 != null) {
                                                }
                                            } else {
                                                gifView3 = getGifView();
                                            }
                                            z9 = false;
                                            gifView2 = gifView3;
                                            t tVar2 = new t(jVar);
                                            tVar2.a = z10;
                                            gifView2.setTag(R.id.tag_rich_text_view_gif_view, tVar2);
                                            U = T(next, gifView2, z9);
                                            if (z3) {
                                            }
                                            tbRichTextData2 = next;
                                            view3 = gifView2;
                                        } else {
                                            if (z4) {
                                                if (this.a.d()) {
                                                    S = next.Z().R();
                                                } else {
                                                    S = next.Z().S();
                                                }
                                                ih8<ImageView> ih8Var3 = this.b;
                                                if (ih8Var3 != null) {
                                                    obj = (ImageView) ih8Var3.h(S);
                                                } else {
                                                    obj = jVar;
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
                                            qt5 qt5Var2 = this.a;
                                            ?? r10 = imageView2;
                                            tbRichTextData2 = next;
                                            boolean P = P(next, imageView2, qt5Var2.m, qt5Var2.n, z7);
                                            if (z3) {
                                                v vVar2 = new v(jVar);
                                                vVar2.a = z10;
                                                r10.setTag(R.id.tag_rich_text_view_recycle, vVar2);
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
                                        view3.setTag(R.id.tag_rich_text_image_info, tbRichTextData.Z());
                                        gifView = view3;
                                    }
                                } else {
                                    tbRichTextData = next;
                                    if (!z11) {
                                        GridImageLayout gridImageView = getGridImageView();
                                        gridImageView.setData(tbRichText.V());
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
                                    U = V(tbRichTextData, (LinearLayout) textVoiceView, uVar2);
                                    gifView = textVoiceView;
                                } else if (tbRichTextData.getType() == 17) {
                                    GifView gifView4 = getGifView();
                                    U = O(tbRichTextData, gifView4);
                                    gifView = gifView4;
                                } else {
                                    if (tbRichTextData.getType() == 20) {
                                        if (i5 < 10) {
                                            int i6 = i5 + 1;
                                            if (tbRichTextData != null && tbRichTextData.c0() != null && tbRichTextData.c0().memeInfo != null && !StringUtils.isNull(tbRichTextData.c0().memeInfo.pic_url)) {
                                                z6 = true;
                                            } else {
                                                z6 = false;
                                            }
                                            if (z6) {
                                                RelativeLayout b2 = this.g.b();
                                                b2.removeAllViews();
                                                b2.setLayoutParams(new LinearLayout.LayoutParams(tbRichTextData.c0().memeInfo.width.intValue(), tbRichTextData.c0().memeInfo.height.intValue()));
                                                if (DuiSwitch.getInOn() && this.m) {
                                                    int intValue = tbRichTextData.c0().memeInfo.width.intValue();
                                                    int intValue2 = tbRichTextData.c0().memeInfo.height.intValue();
                                                    qt5 qt5Var3 = this.a;
                                                    h0(b2, intValue, intValue2, qt5Var3.m, qt5Var3.n);
                                                } else {
                                                    int intValue3 = tbRichTextData.c0().memeInfo.width.intValue();
                                                    int intValue4 = tbRichTextData.c0().memeInfo.height.intValue();
                                                    qt5 qt5Var4 = this.a;
                                                    g0(b2, intValue3, intValue4, qt5Var4.m, qt5Var4.n);
                                                }
                                                ImageView b3 = this.c.b();
                                                qt5 qt5Var5 = this.a;
                                                S(tbRichTextData, b3, qt5Var5.m, qt5Var5.n);
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
                                                    int g2 = hi.g(getContext(), R.dimen.obfuscated_res_0x7f070301);
                                                    int g3 = hi.g(getContext(), R.dimen.obfuscated_res_0x7f070301);
                                                    b3.setId(R.id.meme_image_view);
                                                    int intValue5 = tbRichTextData.c0().memeInfo.width.intValue();
                                                    int intValue6 = tbRichTextData.c0().memeInfo.height.intValue();
                                                    qt5 qt5Var6 = this.a;
                                                    it = it2;
                                                    relativeLayout = b2;
                                                    i0(b3, intValue5, intValue6, qt5Var6.m, qt5Var6.n, this.e0);
                                                    relativeLayout.addView(b3);
                                                    if (g3 > tbRichTextData.c0().memeInfo.height.intValue()) {
                                                        g2 /= 2;
                                                        i4 = g3 / 2;
                                                    } else {
                                                        i4 = g3;
                                                    }
                                                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(g2, i4);
                                                    i2 = 8;
                                                    layoutParams.addRule(8, R.id.meme_image_view);
                                                    layoutParams.addRule(11);
                                                    b4.setOnClickListener(this.e0);
                                                    if (relativeLayout.getLeft() > 0) {
                                                        layoutParams.rightMargin = hi.g(getContext(), R.dimen.obfuscated_res_0x7f0702e7);
                                                    }
                                                    SkinManager.setImageResource(b4, R.drawable.icon_emotion_dui_n);
                                                    relativeLayout.addView(b4, layoutParams);
                                                } else {
                                                    it = it2;
                                                    i2 = 8;
                                                    relativeLayout = b2;
                                                    int intValue7 = tbRichTextData.c0().memeInfo.width.intValue();
                                                    int intValue8 = tbRichTextData.c0().memeInfo.height.intValue();
                                                    qt5 qt5Var7 = this.a;
                                                    k0(b3, intValue7, intValue8, qt5Var7.m, qt5Var7.n, this.e0);
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
                                                if (tbRichTextData.h0() != null && tbRichTextData.h0().T() != null && (xfVar2 = this.i) != null) {
                                                    TiebaPlusRecommendCard b5 = xfVar2.b();
                                                    b5.y(tbRichTextData.h0());
                                                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) b5.getLayoutParams();
                                                    qt5 qt5Var8 = this.a;
                                                    marginLayoutParams.setMargins(0, qt5Var8.z, 0, qt5Var8.A);
                                                    b5.setLayoutParams(marginLayoutParams);
                                                    festivalTipView = b5;
                                                    U = true;
                                                    view4 = festivalTipView;
                                                } else {
                                                    U = false;
                                                    view4 = view4;
                                                }
                                            } else {
                                                if (tbRichTextData.getType() == 1282 && (xfVar = this.l) != null) {
                                                    FestivalTipView b6 = xfVar.b();
                                                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                                                    layoutParams2.topMargin = hi.g(TbadkCoreApplication.getInst(), R.dimen.M_H_X004);
                                                    b6.setLayoutParams(layoutParams2);
                                                    b6.setFestivalTipViewData(tbRichTextData.W());
                                                    b6.setFestivalTipViewStyle(tbRichTextData.X());
                                                    b6.a();
                                                    b6.setFestivalTipViewClickCallBack(new q(this, tbRichTextData));
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
                            uVar2 = uVar;
                            it2 = it;
                            jVar = null;
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
                        uVar2 = uVar;
                        it2 = it;
                        jVar = null;
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
                if (!z3 && (ih8Var = this.b) != null) {
                    ih8Var.c();
                }
            }
        }
    }
}
