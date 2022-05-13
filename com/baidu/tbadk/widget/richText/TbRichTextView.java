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
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.Fragment;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
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
import com.baidu.tbadk.core.util.TiebaStatic;
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
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBnt;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.b9;
import com.repackage.bg;
import com.repackage.bg5;
import com.repackage.br7;
import com.repackage.cg;
import com.repackage.co;
import com.repackage.dt7;
import com.repackage.e9;
import com.repackage.f9;
import com.repackage.fg;
import com.repackage.gg;
import com.repackage.gs4;
import com.repackage.hv4;
import com.repackage.ln4;
import com.repackage.mi;
import com.repackage.ov8;
import com.repackage.tf5;
import com.repackage.tk;
import com.repackage.yf5;
import io.reactivex.annotations.NonNull;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import tbclient.MemeInfo;
import tbclient.PbContent;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes3.dex */
public class TbRichTextView extends LinearLayout implements tk {
    public static /* synthetic */ Interceptable $ic;
    public static final float r0;
    public transient /* synthetic */ FieldHolder $fh;
    public Runnable A;
    public boolean B;
    public x C;
    public TbRichText D;
    public boolean E;
    public int F;
    public int G;
    public boolean H;
    public boolean I;
    public boolean J;
    public boolean K;
    public boolean L;
    public boolean M;
    public boolean N;
    public boolean O;
    public int P;
    public TextView Q;
    public boolean R;
    public boolean S;
    public boolean T;
    public String U;
    public yf5 V;
    public View.OnLongClickListener W;
    public tf5 a;
    public br7<ImageView> b;
    public bg<ImageView> c;
    public bg<TextView> d;
    public bg<View> e;
    public bg<LinearLayout> f;
    public bg<RelativeLayout> g;
    public v g0;
    public bg<GifView> h;
    public final View.OnClickListener h0;
    public bg<TiebaPlusRecommendCard> i;
    public final dt7 i0;
    public GridImageLayout j;
    public final View.OnClickListener j0;
    public bg<ItemCardView> k;
    public final w k0;
    public boolean l;
    public boolean l0;
    public TextUtils.TruncateAt m;
    public Drawable m0;
    public a0 n;
    public String n0;
    public y o;
    public BdUniqueId o0;
    public dt7 p;
    public final fg<co> p0;
    public z q;
    public CustomMessageListener q0;
    public View.OnClickListener r;
    public View.OnClickListener s;
    public View.OnClickListener t;
    public boolean u;
    public boolean v;
    public int w;
    public View.OnClickListener x;
    public boolean y;
    public boolean z;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbRichTextData a;
        public final /* synthetic */ TbRichTextView b;

        public a(TbRichTextView tbRichTextView, TbRichTextData tbRichTextData) {
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.b.C == null) {
                return;
            }
            TbRichTextEmotionInfo B = this.a.B();
            x xVar = this.b.C;
            GifInfo gifInfo = B.mGifInfo;
            xVar.a(view2, gifInfo.mGid, gifInfo.mPackageName, gifInfo.mIcon, gifInfo.mStaticUrl, gifInfo.mDynamicUrl, gifInfo.mSharpText, gifInfo.mGifWidth, gifInfo.mGifHeight);
        }
    }

    /* loaded from: classes3.dex */
    public static class a0 implements AbsListView.RecyclerListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        public a0(int i) {
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
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbRichTextData a;
        public final /* synthetic */ ItemCardView b;
        public final /* synthetic */ TbRichTextView c;

        public b(TbRichTextView tbRichTextView, TbRichTextData tbRichTextData, ItemCardView itemCardView) {
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
                if (this.a.getType() == 37) {
                    TiebaStatic.log(new StatisticItem("common_click").param("page_type", "a005").param(TiebaStatic.Params.GUA_TYPE, 4).param("obj_locate", 16));
                    ItemCardHelper.q(this.b.getPosition(), this.a.F().a().itemId, this.b.z(this.a.F().a()), this.c.U, hv4.a(this.a.F().a().buttonLinkType.intValue(), this.a.F().a().apkDetail != null ? this.a.F().a().apkDetail.pkg_source.intValue() : 0), "", 2);
                    ItemClickJumpUtil.itemClickJump(this.a.F().a().forumName, String.valueOf(this.a.F().a().itemId), 3, 3);
                } else if (this.a.getType() == 1281) {
                    TiebaStatic.log(new StatisticItem("common_click").param("page_type", "a005").param(TiebaStatic.Params.GUA_TYPE, 2).param("obj_locate", 16));
                    int a = hv4.a(this.a.C().getItem().button_link_type.intValue(), this.a.C().getItem().apk_detail != null ? this.a.C().getItem().apk_detail.pkg_source.intValue() : 0);
                    ItemData itemData = new ItemData();
                    itemData.parseProto(this.a.C().getItem());
                    ItemCardHelper.q(this.b.getPosition(), this.a.C().getItem().item_id.longValue(), this.b.z(itemData), this.c.U, a, "", 2);
                    ItemClickJumpUtil.itemClickJump(this.a.C().getItemForumName(), this.a.C().getItemID(), 3, 3);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbRichTextView a;

        public c(TbRichTextView tbRichTextView) {
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

        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.w
        public void dispatchTouchEvent(MotionEvent motionEvent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, motionEvent) == null) {
                if (motionEvent.getAction() == 0) {
                    this.a.M = true;
                } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                    this.a.M = false;
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d extends fg<co> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbRichTextView a;

        public d(TbRichTextView tbRichTextView) {
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

        @Override // com.repackage.fg
        public void onCancelled(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                super.onCancelled(str);
            }
        }

        @Override // com.repackage.fg
        public void onProgressUpdate(Object... objArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, objArr) == null) {
                super.onProgressUpdate(objArr);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.fg
        public void onLoaded(co coVar, String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, coVar, str, i) == null) {
                this.a.B(coVar);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbRichTextView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(TbRichTextView tbRichTextView, int i) {
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
                if (this.a.I) {
                    contentSize = TbConfig.getOutterSubpbContentSize();
                } else {
                    contentSize = TbConfig.getContentSize();
                }
                if (this.a.D != null && !ListUtils.isEmpty(this.a.D.A())) {
                    Iterator<TbRichTextData> it = this.a.D.A().iterator();
                    while (it.hasNext()) {
                        TbRichTextData next = it.next();
                        if (next != null) {
                            next.S(contentSize, contentSize);
                        }
                    }
                }
                this.a.setTextSize(contentSize);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements cg<ImageView> {
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

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.repackage.cg
        public /* bridge */ /* synthetic */ ImageView a(ImageView imageView) {
            ImageView imageView2 = imageView;
            e(imageView2);
            return imageView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.repackage.cg
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
                    if (ln4.c().g()) {
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
        @Override // com.repackage.cg
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
                    foreDrawableImageView.O();
                    foreDrawableImageView.setForegroundDrawable(0);
                    foreDrawableImageView.setDefaultBgResource(R.color.common_color_10220);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.cg
        /* renamed from: g */
        public ImageView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(f9.a(this.a.getContext()).getPageActivity());
                boolean g = ln4.c().g();
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

        public ImageView h(ImageView imageView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, imageView)) == null) ? imageView : (ImageView) invokeL.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class g extends br7<ImageView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbRichTextView e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(TbRichTextView tbRichTextView, cg cgVar, int i, int i2) {
            super(cgVar, i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbRichTextView, cgVar, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((cg) objArr2[0], ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = tbRichTextView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.br7
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
    public class h extends yf5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbRichTextView h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(TbRichTextView tbRichTextView, int i, String str) {
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
            this.h = tbRichTextView;
        }

        @Override // com.repackage.yf5, android.text.style.ClickableSpan
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.h.setAddExpandableListener(false);
                this.h.setTextEllipsize(TextUtils.TruncateAt.END);
                this.h.setMaxLines(5);
                this.h.setAddTruncateListener(true);
                this.h.D.isChanged = true;
                TbRichTextView tbRichTextView = this.h;
                tbRichTextView.setText(tbRichTextView.D);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbRichTextView a;

        public i(TbRichTextView tbRichTextView) {
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
            MemeInfo memeInfo;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.o != null && (view2 instanceof ImageView)) {
                String str = null;
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
                    this.a.o.a(view2, null, i2, this.a.J, false);
                    return;
                }
                if (tag != null && (tag instanceof String)) {
                    str = (String) tag;
                } else {
                    boolean z = view2 instanceof TbImageView;
                    if (z && (view2.getTag(R.id.obfuscated_res_0x7f091ee4) instanceof TbRichTextMemeInfo)) {
                        TbRichTextMemeInfo tbRichTextMemeInfo = (TbRichTextMemeInfo) view2.getTag(R.id.obfuscated_res_0x7f091ee4);
                        String str2 = (tbRichTextMemeInfo == null || (memeInfo = tbRichTextMemeInfo.memeInfo) == null) ? "" : memeInfo.pic_url;
                        int childCount2 = this.a.getChildCount();
                        while (i < childCount2) {
                            i2++;
                            if (view2.getParent() == this.a.getChildAt(i)) {
                                break;
                            }
                            i++;
                        }
                        this.a.o.a(view2, str2, i2, this.a.J, false);
                        return;
                    } else if (z) {
                        str = ((TbImageView) view2).getUrl();
                    } else if (view2 instanceof GifView) {
                        str = ((GifView) view2).getUrl();
                    }
                }
                String str3 = str;
                int childCount3 = this.a.getChildCount();
                while (i < childCount3) {
                    View childAt = this.a.getChildAt(i);
                    if (this.a.S(childAt)) {
                        i2++;
                    }
                    if (view2 == childAt) {
                        break;
                    }
                    i++;
                }
                this.a.o.a(view2, str3, i2, this.a.J, false);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class j implements dt7.a {
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

        @Override // com.repackage.dt7.a
        public boolean a(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                return false;
            }
            return invokeLL.booleanValue;
        }

        @Override // com.repackage.dt7.a
        public boolean b(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, motionEvent)) == null) {
                if (this.a.h0 != null) {
                    this.a.h0.onClick(view2);
                    return true;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }

        @Override // com.repackage.dt7.a
        public boolean c(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view2, motionEvent)) == null) {
                if (this.a.p != null) {
                    this.a.p.a(view2);
                    return this.a.p.onDoubleTap(motionEvent);
                }
                return false;
            }
            return invokeLL.booleanValue;
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
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.q != null && (view2 instanceof TbImageView)) {
                String str = null;
                Object tag = view2.getTag();
                if (tag != null && (tag instanceof u)) {
                    str = ((u) tag).a;
                }
                this.a.q.a(view2, str);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class l implements cg<TextView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;

        public l(Context context) {
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
        @Override // com.repackage.cg
        public /* bridge */ /* synthetic */ TextView a(TextView textView) {
            TextView textView2 = textView;
            e(textView2);
            return textView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.repackage.cg
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
        @Override // com.repackage.cg
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
        @Override // com.repackage.cg
        /* renamed from: g */
        public TextView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? new TbListTextView(this.a) : (TextView) invokeV.objValue;
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
    public class m implements ViewGroup.OnHierarchyChangeListener {
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

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewAdded(View view2, View view3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, view2, view3) == null) {
            }
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewRemoved(View view2, View view3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, view3) == null) {
                if (view3 instanceof GifView) {
                    Object tag = view3.getTag(R.id.obfuscated_res_0x7f091ee6);
                    if (!(tag instanceof t) || !((t) tag).a) {
                        if (this.a.h != null) {
                            this.a.h.e((GifView) view3);
                        }
                    } else {
                        if (this.a.b == null) {
                            TbRichTextView tbRichTextView = this.a;
                            tbRichTextView.b = tbRichTextView.getRecycleImageViewPool();
                        }
                        this.a.b.e((ImageView) view3);
                    }
                } else if (view3 instanceof ImageView) {
                    Object tag2 = view3.getTag(R.id.obfuscated_res_0x7f091ee6);
                    if (!(tag2 instanceof t) || !((t) tag2).a) {
                        if (this.a.c != null) {
                            this.a.c.e((ImageView) view3);
                        }
                    } else {
                        if (this.a.b == null) {
                            TbRichTextView tbRichTextView2 = this.a;
                            tbRichTextView2.b = tbRichTextView2.getRecycleImageViewPool();
                        }
                        this.a.b.e((ImageView) view3);
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
                }
                if (!(view3 instanceof LinearLayout) || (view3 instanceof ItemCardView)) {
                    return;
                }
                Object tag3 = view3.getTag();
                if (tag3 == null || !(tag3 instanceof String) || !"VideoView".equals(tag3)) {
                    if (this.a.f != null) {
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
                        return;
                    }
                    return;
                }
                view3.setBackgroundDrawable(null);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class n implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbRichTextData a;
        public final /* synthetic */ TbRichTextView b;

        public n(TbRichTextView tbRichTextView, TbRichTextData tbRichTextData) {
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.I() == null) {
                return;
            }
            if (this.b.getContext() instanceof bg5) {
                ((bg5) this.b.getContext()).onVideoClicked(this.b.getContext(), this.a.I().toString());
                return;
            }
            b9<?> a = f9.a(this.b.getContext());
            if (a == null || !(a.getOrignalPage() instanceof bg5)) {
                return;
            }
            ((bg5) a.getOrignalPage()).onVideoClicked(this.b.getContext(), this.a.I().toString());
        }
    }

    /* loaded from: classes3.dex */
    public class o implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbRichTextView a;

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

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.j0();
                this.a.Q.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class p implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbRichTextView a;

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

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.g0();
                this.a.Q.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class q implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbRichTextView a;

        public q(TbRichTextView tbRichTextView) {
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
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && !this.a.M && this.a.performLongClick()) {
                this.a.z = true;
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class r {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;

        public r() {
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

        public /* synthetic */ r(h hVar) {
            this();
        }
    }

    /* loaded from: classes3.dex */
    public interface s {
        void decorateText(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView);
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

        public /* synthetic */ t(h hVar) {
            this();
        }
    }

    /* loaded from: classes3.dex */
    public static class u {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        public u(String str) {
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

    /* loaded from: classes3.dex */
    public interface v {
        void a();
    }

    /* loaded from: classes3.dex */
    public interface w {
        void dispatchTouchEvent(MotionEvent motionEvent);
    }

    /* loaded from: classes3.dex */
    public interface x {
        void a(View view2, String str, String str2, String str3, String str4, String str5, String str6, int i, int i2);
    }

    /* loaded from: classes3.dex */
    public interface y {
        void a(View view2, String str, int i, boolean z, boolean z2);
    }

    /* loaded from: classes3.dex */
    public interface z {
        void a(View view2, String str);
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
        r0 = mi.h(TbadkCoreApplication.getInst());
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
        this.a = new tf5();
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.k = null;
        this.l = true;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = true;
        this.v = true;
        this.w = -1;
        this.y = false;
        this.z = false;
        this.A = null;
        this.B = false;
        this.E = false;
        this.F = -1;
        this.G = -1;
        this.H = true;
        this.I = false;
        this.J = false;
        this.K = false;
        this.L = false;
        this.M = false;
        this.N = false;
        this.O = false;
        this.R = false;
        this.S = false;
        this.T = false;
        this.V = new h(this, 2, null);
        this.h0 = new i(this);
        this.i0 = new dt7(new j(this));
        this.j0 = new k(this);
        this.k0 = new c(this);
        this.p0 = new d(this);
        this.q0 = new e(this, 2004018);
        H();
    }

    public static bg<TextView> C(Context context, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, context, i2)) == null) ? new bg<>(new l(context), i2, 0) : (bg) invokeLI.objValue;
    }

    public static TbRichText T(JSONArray jSONArray, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65541, null, jSONArray, i2)) == null) ? new TbRichText(jSONArray, i2) : (TbRichText) invokeLI.objValue;
    }

    public static TbRichText U(JSONArray jSONArray, boolean z2) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(65542, null, jSONArray, z2)) == null) ? new TbRichText(jSONArray, z2) : (TbRichText) invokeLZ.objValue;
    }

    public static TbRichText V(List<PbContent> list, String str, boolean z2) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65543, null, list, str, z2)) == null) ? W(list, str, z2, null, null, -1) : (TbRichText) invokeLLZ.objValue;
    }

    public static TbRichText W(List<PbContent> list, String str, boolean z2, @Nullable PostData postData, @Nullable ThreadData threadData, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65544, null, new Object[]{list, str, Boolean.valueOf(z2), postData, threadData, Integer.valueOf(i2)})) == null) ? new TbRichText(list, str, z2, postData, threadData, i2) : (TbRichText) invokeCommon.objValue;
    }

    public static TbRichText X(List<PbContent> list, boolean z2) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(65545, null, list, z2)) == null) ? new TbRichText(list, null, z2) : (TbRichText) invokeLZ.objValue;
    }

    public static TbRichText Y(List<PbContent> list, boolean z2, @NonNull ThreadData threadData) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65546, null, new Object[]{list, Boolean.valueOf(z2), threadData})) == null) ? new TbRichText(list, null, z2, null, threadData, -1) : (TbRichText) invokeCommon.objValue;
    }

    private GifView getGifView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65554, this)) == null) {
            bg<GifView> bgVar = this.h;
            GifView b2 = bgVar != null ? bgVar.b() : null;
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
            b2.setRadius(this.P);
            if (this.N) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(65555, this)) == null) {
            GridImageLayout gridImageLayout = this.j;
            if (gridImageLayout == null || gridImageLayout.getParent() != null) {
                this.j = new GridImageLayout(getContext());
                this.j.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            }
            this.j.setLayoutStrategy(this.a);
            this.j.setObjectPool(this.c, this.h);
            this.j.setOnImageClickListener(this.o);
            View.OnClickListener onClickListener = this.s;
            if (onClickListener != null) {
                this.j.setOnClickListener(onClickListener);
            }
            this.j.setIsHost(this.J);
            if (this.O) {
                this.j.setOnLongClickListener(this.W);
            }
            return this.j;
        }
        return (GridImageLayout) invokeV.objValue;
    }

    private ImageView getImageView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65556, this)) == null) {
            bg<ImageView> bgVar = this.c;
            ImageView imageView = null;
            ImageView b2 = bgVar != null ? bgVar.b() : null;
            if (b2 != null && b2.getParent() == null) {
                imageView = b2;
            }
            if (imageView != null) {
                imageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0528));
            }
            return imageView;
        }
        return (ImageView) invokeV.objValue;
    }

    private ItemCardView getItemCardView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65557, this)) == null) {
            bg<ItemCardView> bgVar = this.k;
            ItemCardView b2 = bgVar != null ? bgVar.b() : null;
            if (b2 != null) {
                b2.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            }
            return b2;
        }
        return (ItemCardView) invokeV.objValue;
    }

    private View getTextVoiceView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65558, this)) == null) {
            LinearLayout b2 = this.f.b();
            if (b2 != null) {
                TextView D = D(getContext());
                if (D == null) {
                    this.f.e(b2);
                    return null;
                }
                b2.addView(D);
                View F = F(null);
                if (F == null) {
                    this.d.e(D);
                    this.f.e(b2);
                    return null;
                }
                b2.addView(F);
            }
            return b2;
        }
        return (View) invokeV.objValue;
    }

    public final void B(co coVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, coVar) == null) || coVar == null) {
            return;
        }
        try {
            NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(getResources(), coVar.p(), coVar.p().getNinePatchChunk(), coVar.o(), null);
            if (TbadkCoreApplication.getInst().getSkinType() == 1 || TbadkCoreApplication.getInst().getSkinType() == 4) {
                ninePatchDrawable.getPaint().setAlpha(80);
            }
            setBackgroundDrawable(ninePatchDrawable);
            v vVar = this.g0;
            if (vVar != null) {
                vVar.a();
            }
        } catch (Exception unused) {
        }
    }

    public final TextView D(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            bg<TextView> bgVar = this.d;
            TextView b2 = bgVar != null ? bgVar.b() : null;
            if (b2 == null || b2.getParent() != null) {
                b2 = new TbListTextView(context);
            }
            int i2 = this.a.d;
            b2.setPadding(i2, 0, i2, 0);
            return b2;
        }
        return (TextView) invokeL.objValue;
    }

    public final LinearLayout E(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, tbRichTextData)) == null) {
            if (this.a.n <= 0 || tbRichTextData == null) {
                return null;
            }
            LinearLayout linearLayout = new LinearLayout(getContext());
            linearLayout.setTag("VideoView");
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.topMargin = this.a.e;
            linearLayout.setClickable(true);
            Bitmap bitmap = SkinManager.getBitmap(this.a.n);
            if (bitmap != null) {
                linearLayout.setBackgroundDrawable(new BitmapDrawable(getContext().getResources(), bitmap));
            }
            linearLayout.setFocusable(false);
            linearLayout.setLayoutParams(layoutParams);
            linearLayout.setOnClickListener(new n(this, tbRichTextData));
            return linearLayout;
        }
        return (LinearLayout) invokeL.objValue;
    }

    public final View F(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, view2)) == null) {
            bg<View> bgVar = this.e;
            View b2 = bgVar != null ? bgVar.b() : null;
            if ((b2 == null || b2.getParent() != null) && this.w != -1) {
                b2 = LayoutInflater.from(getContext()).inflate(this.w, (ViewGroup) null);
            }
            if (b2 != null) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                if (view2 instanceof TbListTextView) {
                    layoutParams.topMargin = this.a.w;
                } else {
                    layoutParams.topMargin = this.a.e;
                }
                layoutParams.bottomMargin = this.a.B;
                b2.setLayoutParams(layoutParams);
                if (b2 instanceof PlayVoiceBntNew) {
                    ((PlayVoiceBntNew) b2).setAfterClickListener(this.x);
                }
                return b2;
            }
            return null;
        }
        return (View) invokeL.objValue;
    }

    public boolean G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.B : invokeV.booleanValue;
    }

    public final void H() {
        bg5 bg5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            b9<?> a2 = f9.a(getContext());
            if (getContext() instanceof bg5) {
                bg5Var = (bg5) getContext();
            } else {
                bg5Var = (a2 == null || !(a2.getOrignalPage() instanceof bg5)) ? null : (bg5) a2.getOrignalPage();
            }
            if (bg5Var == null && (getContext() instanceof BaseFragmentActivity)) {
                List<Fragment> fragments = ((BaseFragmentActivity) getContext()).getSupportFragmentManager().getFragments();
                if (!ListUtils.isEmpty(fragments) && (fragments.get(0) instanceof bg5)) {
                    bg5Var = (bg5) fragments.get(0);
                }
            }
            if (a2 != null) {
                a2.registerListener(this.q0);
            }
            if (bg5Var != null) {
                this.c = bg5Var.getImageViewPool();
                this.d = bg5Var.getTextViewPool();
                this.e = bg5Var.getVoiceViewPool();
                this.f = bg5Var.getTextVoiceViewPool();
                this.h = bg5Var.getGifViewPool();
                this.i = bg5Var.getTiejiaRecommendPool();
                this.g = bg5Var.getRelativeLayoutPool();
                this.k = bg5Var.getItemCardViewPool();
                if (bg5Var.getListView() != null && this.n == null) {
                    this.n = new a0(bg5Var.getRichTextViewId());
                    bg5Var.getListView().setRecyclerListener(this.n);
                }
            }
            this.P = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds21);
            setOrientation(1);
            setOnHierarchyChangeListener(new m(this));
        }
    }

    public final void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            setFaceSize(this.I ? TbConfig.getContentSizeOfLzl() : TbConfig.getContentSize());
        }
    }

    public final boolean J(TbRichTextData tbRichTextData, GifView gifView) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, tbRichTextData, gifView)) == null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) gifView.getLayoutParams();
            if (layoutParams != null && layoutParams.width == tbRichTextData.B().mGifInfo.mGifWidth && layoutParams.height == tbRichTextData.B().mGifInfo.mGifHeight) {
                layoutParams.bottomMargin = 0;
            } else {
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(tbRichTextData.B().mGifInfo.mGifWidth, tbRichTextData.B().mGifInfo.mGifHeight);
                layoutParams2.gravity = 3;
                gifView.setLayoutParams(layoutParams2);
            }
            gifView.setOnClickListener(new a(this, tbRichTextData));
            gifView.i0(tbRichTextData.B().mGifInfo);
            return true;
        }
        return invokeLL.booleanValue;
    }

    public final boolean K(TbRichTextData tbRichTextData, ImageView imageView, int i2, int i3, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{tbRichTextData, imageView, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z2)})) == null) {
            if (tbRichTextData == null || imageView == null || tbRichTextData.E() == null) {
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
                tbImageView.setTLIconType(tbRichTextData.D());
                tbImageView.setConrers(15);
                tbImageView.setRadius(this.P);
                if (this.N) {
                    tbImageView.setPlaceHolder(2);
                } else {
                    tbImageView.setPlaceHolder(3);
                }
                if (this.a.r) {
                    tbImageView.setSupportNoImage(true);
                }
                String y2 = this.a.c() ? tbRichTextData.E().y() : tbRichTextData.E().A();
                if (!z2 || tbImageView.getUrl() == null || !tbImageView.getUrl().equals(y2)) {
                    tbImageView.K(y2, this.v ? 17 : 18, false);
                }
                if (!tbRichTextData.E().E()) {
                    tbImageView.setAdjustViewBounds(false);
                }
                tbImageView.setTag(R.id.obfuscated_res_0x7f091ee4, null);
            }
            return e0(imageView, tbRichTextData.E().getWidth(), tbRichTextData.E().getHeight(), i2, i3, this.h0);
        }
        return invokeCommon.booleanValue;
    }

    public final boolean L(ItemCardView itemCardView, TbRichTextData tbRichTextData) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, itemCardView, tbRichTextData)) == null) {
            if (tbRichTextData != null) {
                if (tbRichTextData.F() == null && tbRichTextData.C() == null) {
                    return false;
                }
                if (tbRichTextData.getType() == 37) {
                    itemCardView.setPosition(9);
                } else if (tbRichTextData.getType() == 1281) {
                    itemCardView.setPosition(4);
                }
                itemCardView.setOnClickListener(new b(this, tbRichTextData, itemCardView));
                itemCardView.setOnClickListenerOfRightBtn(this.t);
                itemCardView.setIsShowRightBtn(this.T);
                if (tbRichTextData.getType() == 37) {
                    itemCardView.setData(tbRichTextData.F().a(), 17, this.U);
                } else if (tbRichTextData.getType() == 1281) {
                    itemCardView.setData(tbRichTextData.C(), 17, this.U);
                }
                itemCardView.G();
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final boolean M(TbRichTextData tbRichTextData, ImageView imageView, int i2, int i3) {
        InterceptResult invokeLLII;
        TbRichTextLinkImageInfo G;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(1048586, this, tbRichTextData, imageView, i2, i3)) == null) {
            if (tbRichTextData == null || imageView == null || (G = tbRichTextData.G()) == null || G.getLink() == null) {
                return false;
            }
            if (imageView instanceof TbImageView) {
                TbImageView tbImageView = (TbImageView) imageView;
                if (this.a.r) {
                    tbImageView.setSupportNoImage(true);
                }
                tbImageView.K(G.y(), this.v ? 17 : 18, false);
                tbImageView.setTag(new u(G.getLink()));
                if (!G.z()) {
                    tbImageView.setAdjustViewBounds(false);
                }
            }
            return f0(imageView, G.getWidth(), G.getHeight(), i2, i3, this.j0);
        }
        return invokeLLII.booleanValue;
    }

    public final boolean N(TbRichTextData tbRichTextData, ImageView imageView, int i2, int i3) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(1048587, this, tbRichTextData, imageView, i2, i3)) == null) {
            if (tbRichTextData == null || imageView == null || tbRichTextData.H() == null) {
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
                tbImageView.setRadius(this.P);
                if (this.N) {
                    tbImageView.setPlaceHolder(2);
                } else {
                    tbImageView.setPlaceHolder(3);
                }
                if (this.a.r) {
                    tbImageView.setSupportNoImage(true);
                }
                tbImageView.K(tbRichTextData.H().memeInfo.pic_url, this.v ? 17 : 18, false);
                tbImageView.setAdjustViewBounds(false);
                tbImageView.setTag(R.id.obfuscated_res_0x7f091ee4, tbRichTextData.H());
            }
            return f0(imageView, tbRichTextData.H().memeInfo.width.intValue(), tbRichTextData.H().memeInfo.height.intValue(), i2, i3, this.h0);
        }
        return invokeLLII.booleanValue;
    }

    public final boolean O(TbRichTextData tbRichTextData, GifView gifView, boolean z2) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048588, this, tbRichTextData, gifView, z2)) == null) {
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
            String B = tbRichTextData.E().B();
            if (StringUtils.isNull(B)) {
                tf5 tf5Var = this.a;
                if (tf5Var.G) {
                    B = tf5Var.s ? tbRichTextData.E().y() : tbRichTextData.E().z();
                }
                if (StringUtils.isNull(B)) {
                    B = this.a.s ? tbRichTextData.E().A() : tbRichTextData.E().D();
                }
            }
            gifView.setShowStaticDrawable(false);
            if (!z2 || gifView.getUrl() == null || !gifView.getUrl().equals(B)) {
                gifView.j0(B, 38);
            }
            int width = tbRichTextData.E().getWidth();
            int height = tbRichTextData.E().getHeight();
            tf5 tf5Var2 = this.a;
            return e0(gifView, width, height, tf5Var2.k, tf5Var2.l, this.h0);
        }
        return invokeLLZ.booleanValue;
    }

    public final boolean P(TbRichTextData tbRichTextData, TextView textView, boolean z2, s sVar) {
        InterceptResult invokeCommon;
        LinearLayout.LayoutParams layoutParams;
        SpannableStringBuilder I;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{tbRichTextData, textView, Boolean.valueOf(z2), sVar})) == null) {
            this.Q = textView;
            if (z2) {
                layoutParams = new LinearLayout.LayoutParams(-1, -2);
            } else {
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
            }
            if (this.E) {
                layoutParams.gravity = 16;
                textView.setGravity(16);
            } else {
                layoutParams.topMargin = this.a.e;
            }
            textView.setIncludeFontPadding(this.a.b);
            tf5 tf5Var = this.a;
            textView.setLineSpacing(tf5Var.c, tf5Var.a);
            textView.setTextSize(0, this.a.f);
            if (this.a.g) {
                gs4.d(textView).A(R.string.F_X02);
            }
            textView.setTextColor(this.a.j);
            textView.setLinkTextColor(SkinManager.getColor(R.color.CAM_X0304));
            textView.setHighlightColor(getContext().getResources().getColor(R.color.transparent));
            textView.setSingleLine(this.a.o);
            if (this.K) {
                i0();
            }
            if (this.L) {
                h0();
            }
            TextUtils.TruncateAt truncateAt = this.m;
            if (truncateAt != null) {
                textView.setEllipsize(truncateAt);
            }
            if (this.R) {
                gs4.d(textView).y(R.array.S_O_X001);
            }
            int i3 = this.F;
            if (i3 > 0) {
                textView.setMaxWidth(i3);
            }
            int i4 = this.G;
            if (i4 > 0) {
                textView.setMaxLines(i4);
            }
            if (tbRichTextData == null || (I = tbRichTextData.I()) == null || I.length() <= 0) {
                return false;
            }
            tf5 tf5Var2 = this.a;
            int i5 = tf5Var2.i;
            if (i5 > 0 && (i2 = tf5Var2.h) > 0) {
                tbRichTextData.S(i2, i5);
            }
            if (sVar != null) {
                sVar.decorateText(I, textView, this);
            }
            try {
                textView.setText(I);
            } catch (Exception unused) {
                textView.setText("");
            }
            if (this.H) {
                if (tbRichTextData.P()) {
                    textView.setMovementMethod(ov8.a());
                } else {
                    textView.setMovementMethod(LinkMovementMethod.getInstance());
                }
            }
            textView.setFocusable(false);
            textView.setLayoutParams(layoutParams);
            textView.setTag(tbRichTextData);
            if (tbRichTextData == null || tbRichTextData.K() == null) {
                return true;
            }
            tbRichTextData.K().needRecompute = this.l0;
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public final boolean Q(TbRichTextData tbRichTextData, LinearLayout linearLayout, s sVar) {
        InterceptResult invokeLLL;
        boolean R;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048590, this, tbRichTextData, linearLayout, sVar)) == null) {
            if (linearLayout == null) {
                return false;
            }
            int childCount = linearLayout.getChildCount();
            boolean z2 = true;
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = linearLayout.getChildAt(i2);
                if (childAt != null) {
                    if (childAt instanceof TextView) {
                        R = P(tbRichTextData, (TextView) childAt, false, sVar);
                    } else if (childAt.getClass().getSimpleName().equals("PlayVoiceBnt")) {
                        R = R(tbRichTextData, childAt);
                    } else if (childAt.getClass().getSimpleName().equals("PlayVoiceBntNew")) {
                        R = R(tbRichTextData, childAt);
                    }
                    z2 &= R;
                }
            }
            return z2;
        }
        return invokeLLL.booleanValue;
    }

    public final boolean R(TbRichTextData tbRichTextData, View view2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048591, this, tbRichTextData, view2)) == null) {
            view2.setTag(tbRichTextData.O());
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

    public final boolean S(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, view2)) == null) {
            if (view2 instanceof ImageView) {
                if (view2 instanceof GifView) {
                    return view2.getTag(R.id.obfuscated_res_0x7f091ee5) != null && (view2.getTag(R.id.obfuscated_res_0x7f091ee5) instanceof r) && ((r) view2.getTag(R.id.obfuscated_res_0x7f091ee5)).a;
                }
                if ((view2 instanceof TbImageView) && view2.getTag() != null) {
                    if (view2.getTag() instanceof u) {
                        return false;
                    }
                    if ((view2.getTag() instanceof String) && TextUtils.equals("VideoView", (String) view2.getTag())) {
                        return false;
                    }
                }
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void Z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.z = false;
            if (this.A == null) {
                this.A = new q(this);
            }
            postDelayed(this.A, ViewConfiguration.getLongPressTimeout());
        }
    }

    public final void a0() {
        Runnable runnable;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || (runnable = this.A) == null) {
            return;
        }
        removeCallbacks(runnable);
    }

    public final void b0(RelativeLayout relativeLayout, int i2, int i3, int i4, int i5) {
        int[] l2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048595, this, new Object[]{relativeLayout, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) || (l2 = mi.l(i2, i3, i4, i5)) == null) {
            return;
        }
        int[] iArr = {l2[0], l2[1]};
        int i6 = iArr[0];
        int i7 = iArr[1];
        if (this.a.t && i4 > i6) {
            float f2 = r0;
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
    public final void c0(RelativeLayout relativeLayout, int i2, int i3, int i4, int i5) {
        int[] l2;
        int i6;
        int i7;
        int f2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048596, this, new Object[]{relativeLayout, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) || (l2 = mi.l(i2, i3, i4, i5)) == null) {
            return;
        }
        int[] iArr = {l2[0], l2[1]};
        int i8 = iArr[0];
        int i9 = iArr[1];
        if (this.a.t && i4 > i8) {
            float f3 = r0;
            if (f3 > 1.0f) {
                float f4 = i8;
                float f5 = i4;
                if (f4 * f3 > f5) {
                    i7 = i4 - mi.f(getContext(), R.dimen.obfuscated_res_0x7f070303);
                    f2 = mi.f(getContext(), R.dimen.obfuscated_res_0x7f0701be);
                } else {
                    float f6 = f5 * 0.68f;
                    if (f4 * f3 > f6) {
                        i7 = (int) f6;
                        f2 = mi.f(getContext(), R.dimen.obfuscated_res_0x7f070303);
                    } else {
                        i6 = (int) (f4 * f3);
                        if (iArr[0] > 0) {
                            i9 = (i6 * iArr[1]) / iArr[0];
                        }
                    }
                }
                i6 = i7 - f2;
                if (iArr[0] > 0) {
                }
            }
        }
        relativeLayout.setLayoutParams(new LinearLayout.LayoutParams(i4, i9));
    }

    public final boolean d0(ImageView imageView, int i2, int i3, int i4, int i5, View.OnClickListener onClickListener) {
        InterceptResult invokeCommon;
        View.OnLongClickListener onLongClickListener;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048597, this, new Object[]{imageView, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), onClickListener})) == null) {
            int[] l2 = mi.l(i2, i3, i4, i5);
            if (l2 == null) {
                return false;
            }
            int[] iArr = {l2[0], l2[1]};
            int i6 = iArr[0];
            int i7 = iArr[1];
            if (this.a.t && i4 > i6) {
                float f2 = r0;
                if (f2 > 1.0f) {
                    float f3 = i6;
                    float f4 = i4;
                    if (f3 * f2 > f4) {
                        i6 = (i4 - mi.f(getContext(), R.dimen.obfuscated_res_0x7f070303)) - mi.f(getContext(), R.dimen.obfuscated_res_0x7f0701be);
                    } else {
                        float f5 = f4 * 0.68f;
                        i6 = f3 * f2 > f5 ? ((int) f5) - mi.f(getContext(), R.dimen.obfuscated_res_0x7f070303) : (int) (f3 * f2);
                    }
                    if (iArr[0] > 0) {
                        i7 = (iArr[1] * i6) / iArr[0];
                    }
                }
            }
            boolean z2 = imageView instanceof TbImageView;
            if (z2) {
                TbImageView tbImageView = (TbImageView) imageView;
                tbImageView.setDefaultResource(this.a.m);
                if (tbImageView.getGifIconWidth() < i6 && tbImageView.getGifIconHeight() < i7) {
                    tbImageView.setGifIconSupport(true);
                } else {
                    tbImageView.setGifIconSupport(false);
                }
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i6, i7);
            if (this.a.t) {
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            } else {
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            }
            imageView.setClickable(true);
            imageView.setFocusable(false);
            if (this.p != null && z2) {
                ((TbImageView) imageView).setTbGestureDetector(this.i0);
                imageView.setClickable(true);
            } else {
                imageView.setOnClickListener(onClickListener);
            }
            imageView.setLayoutParams(layoutParams);
            if (z2) {
                if (this.W != null) {
                    ((TbImageView) imageView).setDispatchTouchListener(this.k0);
                    imageView.setOnLongClickListener(this.W);
                }
            } else if ((imageView instanceof GifView) && (onLongClickListener = this.W) != null) {
                imageView.setOnLongClickListener(onLongClickListener);
            }
            return true;
        }
        return invokeCommon.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, motionEvent)) == null) {
            this.y = false;
            int action = motionEvent.getAction();
            if ((action == 1 || action == 3) && !this.z) {
                a0();
            }
            boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
            if (motionEvent.getAction() == 0 && !this.y) {
                Z();
            }
            return dispatchTouchEvent;
        }
        return invokeL.booleanValue;
    }

    public final boolean e0(ImageView imageView, int i2, int i3, int i4, int i5, View.OnClickListener onClickListener) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048599, this, new Object[]{imageView, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), onClickListener})) == null) {
            int[] e2 = this.a.e(i2, i3, i4, i5);
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
            tf5 tf5Var = this.a;
            if (tf5Var.t) {
                imageView.setScaleType(tf5Var.q);
                if (z2) {
                    ((TbImageView) imageView).setOnDrawListener(this.a.J);
                }
            } else {
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            }
            imageView.setClickable(true);
            imageView.setFocusable(false);
            if (this.p != null && z2) {
                ((TbImageView) imageView).setTbGestureDetector(this.i0);
                imageView.setClickable(true);
            } else {
                imageView.setOnClickListener(onClickListener);
            }
            imageView.setLayoutParams(layoutParams);
            if (z2) {
                if (this.W != null) {
                    ((TbImageView) imageView).setDispatchTouchListener(this.k0);
                    imageView.setOnLongClickListener(this.W);
                }
            } else if ((imageView instanceof GifView) && this.W != null) {
                ((GifView) imageView).setDispatchTouchListener(this.k0);
                imageView.setOnLongClickListener(this.W);
            }
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public final boolean f0(ImageView imageView, int i2, int i3, int i4, int i5, View.OnClickListener onClickListener) {
        InterceptResult invokeCommon;
        View.OnLongClickListener onLongClickListener;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048600, this, new Object[]{imageView, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), onClickListener})) == null) {
            int[] l2 = mi.l(i2, i3, i4, i5);
            if (l2 == null) {
                return false;
            }
            int[] iArr = {l2[0], l2[1]};
            int i6 = iArr[0];
            int i7 = iArr[1];
            if (this.a.t && i4 > i6) {
                float f2 = r0;
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
                tbImageView.setDefaultResource(this.a.m);
                if (tbImageView.getGifIconWidth() < i6 && tbImageView.getGifIconHeight() < i7) {
                    tbImageView.setGifIconSupport(true);
                } else {
                    tbImageView.setGifIconSupport(false);
                }
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i6, i7);
            if (this.a.t) {
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            } else {
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            }
            imageView.setClickable(true);
            imageView.setFocusable(false);
            if (this.p != null && z2) {
                ((TbImageView) imageView).setTbGestureDetector(this.i0);
                imageView.setClickable(true);
            } else {
                imageView.setOnClickListener(onClickListener);
            }
            imageView.setLayoutParams(layoutParams);
            if (z2) {
                if (this.W != null) {
                    ((TbImageView) imageView).setDispatchTouchListener(this.k0);
                    imageView.setOnLongClickListener(this.W);
                }
            } else if ((imageView instanceof GifView) && (onLongClickListener = this.W) != null) {
                imageView.setOnLongClickListener(onLongClickListener);
            }
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public final void g0() {
        TextView textView;
        CharSequence subSequence;
        Object[] spans;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048601, this) == null) || this.G <= 1 || (textView = this.Q) == null || textView.getLineCount() <= this.G) {
            return;
        }
        try {
            CharSequence subSequence2 = this.Q.getText().subSequence(0, this.Q.getLayout().getLineEnd(this.G - 1));
            Layout layout = this.Q.getLayout();
            int lineStart = layout.getLineStart(this.G - 1);
            int lineEnd = layout.getLineEnd(this.G - 1);
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
            spannableString.setSpan(this.V, 0, spannableString.length(), 17);
            spannableStringBuilder.append((CharSequence) spannableString);
            this.Q.setText(spannableStringBuilder);
        } catch (Exception unused) {
            this.Q.setText(this.Q.getText());
        }
    }

    public tf5 getLayoutStrategy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.a : (tf5) invokeV.objValue;
    }

    public y getOnImageClickListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.o : (y) invokeV.objValue;
    }

    public z getOnLinkImageClickListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.q : (z) invokeV.objValue;
    }

    public br7<ImageView> getRecycleImageViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            if (this.b == null) {
                this.b = new g(this, new f(this), 10, 0);
            }
            return this.b;
        }
        return (br7) invokeV.objValue;
    }

    public TbRichText getRichText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.D : (TbRichText) invokeV.objValue;
    }

    public TextView getTextView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
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

    public final void h0() {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048608, this) == null) || (textView = this.Q) == null) {
            return;
        }
        textView.getViewTreeObserver().addOnGlobalLayoutListener(new p(this));
    }

    public final void i0() {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048609, this) == null) || (textView = this.Q) == null) {
            return;
        }
        textView.getViewTreeObserver().addOnGlobalLayoutListener(new o(this));
    }

    public final void j0() {
        TextView textView;
        CharSequence text;
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048610, this) == null) || this.G <= 0 || (textView = this.Q) == null || textView.getLineCount() <= this.G) {
            return;
        }
        try {
            text = this.Q.getText().subSequence(0, this.Q.getLayout().getLineEnd(this.G - 1) - 1);
            str = StringHelper.STRING_MORE;
        } catch (Exception unused) {
            text = this.Q.getText();
            str = "";
        }
        TextUtils.TruncateAt ellipsize = this.Q.getEllipsize();
        if (ellipsize == TextUtils.TruncateAt.START) {
            this.Q.setText(str);
            this.Q.append(text);
        } else if (ellipsize == TextUtils.TruncateAt.MIDDLE) {
            this.Q.setText(text.subSequence(0, text.length() / 2));
            this.Q.append(str);
            this.Q.append(text.subSequence(text.length() / 2, text.length()));
        } else if (ellipsize == TextUtils.TruncateAt.END) {
            this.Q.setText(text);
            this.Q.append(str);
        }
    }

    public void k0(String str) {
        BdUniqueId bdUniqueId;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, str) == null) {
            if (TextUtils.isEmpty(str)) {
                this.n0 = str;
                return;
            }
            e9 c2 = f9.c(getContext());
            if (c2 != null) {
                bdUniqueId = c2.getUniqueId();
                z2 = c2.isScroll();
            } else {
                bdUniqueId = null;
                z2 = false;
            }
            if (!(str.equals(this.n0) && this.o0 == bdUniqueId)) {
                m0();
            }
            this.n0 = str;
            this.o0 = bdUniqueId;
            setBackgroundDrawable(null);
            co coVar = (co) gg.h().n(this.n0, 19, new Object[0]);
            if (coVar != null) {
                B(coVar);
            } else if (z2) {
                invalidate();
            } else if (!gg.h().j(19)) {
                invalidate();
            } else {
                gg.h().k(this.n0, 19, this.p0, 0, 0, this.o0, new Object[0]);
            }
        }
    }

    public void l0(String str, v vVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048612, this, str, vVar) == null) {
            this.g0 = vVar;
            k0(str);
        }
    }

    public void m0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048613, this) == null) || TextUtils.isEmpty(this.n0)) {
            return;
        }
        gg.h().d(this.n0, 19, this.p0);
        setBackgroundDrawable(null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            super.onDetachedFromWindow();
            tf5 tf5Var = this.a;
            if (tf5Var != null) {
                tf5Var.d();
            }
            m0();
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048615, this, motionEvent)) == null) {
            if (this.z && (motionEvent.getAction() == 3 || motionEvent.getAction() == 1)) {
                return true;
            }
            return super.onInterceptTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            super.onStartTemporaryDetach();
            m0();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048617, this, motionEvent)) == null) {
            this.y = true;
            return super.onTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048618, this, i2) == null) {
            super.onWindowVisibilityChanged(i2);
            if (i2 != 8 && i2 != 4) {
                refresh();
            } else {
                m0();
            }
        }
    }

    @Override // com.repackage.tk
    public void refresh() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            k0(this.n0);
        }
    }

    public void setAddExpandableListener(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048620, this, z2) == null) {
            this.L = z2;
        }
    }

    public void setAddTruncateListener(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048621, this, z2) == null) {
            this.K = z2;
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, drawable) == null) {
            super.setBackgroundDrawable(drawable);
            if (this.m0 != drawable) {
                this.l0 = true;
                this.m0 = drawable;
            }
            setText(this.D);
            this.l0 = false;
        }
    }

    public void setCommonTextViewOnClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, onClickListener) == null) {
            this.r = onClickListener;
        }
    }

    public void setDisplayImage(boolean z2, boolean z3) {
        bg<ImageView> bgVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048624, this, new Object[]{Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) || this.u == z2) {
            return;
        }
        this.u = z2;
        if (z3) {
            requestLayout();
        }
        if (this.u || (bgVar = this.c) == null) {
            return;
        }
        bgVar.c();
    }

    public void setDuiEnabled(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048625, this, z2) == null) {
            this.l = z2;
        }
    }

    public void setFaceSize(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048626, this, f2) == null) {
            if (this.S && UbsABTestHelper.isResizeEmotionABTest()) {
                int emotionContentSizeOfLzl = this.I ? TbConfig.getEmotionContentSizeOfLzl() : TbConfig.getEmotionContentSize();
                tf5 tf5Var = this.a;
                tf5Var.h = emotionContentSizeOfLzl;
                tf5Var.i = emotionContentSizeOfLzl;
                return;
            }
            tf5 tf5Var2 = this.a;
            int i2 = (int) f2;
            tf5Var2.h = i2;
            tf5Var2.i = i2;
        }
    }

    public void setHasMovementMethod(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048627, this, z2) == null) {
            this.H = z2;
        }
    }

    public void setIsFromCDN(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048628, this, z2) == null) {
            this.v = z2;
            tf5 tf5Var = this.a;
            if (tf5Var != null) {
                tf5Var.s = z2;
            }
        }
    }

    public void setIsHost(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048629, this, z2) == null) {
            this.J = z2;
            GridImageLayout gridImageLayout = this.j;
            if (gridImageLayout != null) {
                gridImageLayout.setIsHost(z2);
            }
        }
    }

    public void setIsNeedResizeEmotion(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048630, this, z2) == null) {
            this.S = z2;
        }
    }

    public void setIsShowOrderOrDownloadBtn(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048631, this, z2) == null) {
            this.T = z2;
        }
    }

    public void setIsUseGridImage(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048632, this, z2) == null) {
            this.N = z2;
        }
    }

    public void setItemOrderOrDownloadListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048633, this, onClickListener) == null) {
            this.t = onClickListener;
        }
    }

    public void setLayoutStrategy(tf5 tf5Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048634, this, tf5Var) == null) || tf5Var == null) {
            return;
        }
        this.a.d();
        this.a = tf5Var;
        I();
        GridImageLayout gridImageLayout = this.j;
        if (gridImageLayout != null) {
            gridImageLayout.setLayoutStrategy(this.a);
        }
    }

    public void setLinkTextColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048635, this, i2) == null) {
            tf5 tf5Var = this.a;
            if (i2 == tf5Var.p) {
                return;
            }
            tf5Var.p = i2;
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
            this.G = i2;
            TextView textView = this.Q;
            if (textView != null) {
                textView.setMaxLines(i2);
            }
        }
    }

    public void setMaxWidth(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048637, this, i2) == null) {
            this.F = i2;
        }
    }

    public void setOnEmotionClickListener(x xVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048638, this, xVar) == null) {
            this.C = xVar;
        }
    }

    public void setOnImageClickListener(y yVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048639, this, yVar) == null) {
            this.o = yVar;
            GridImageLayout gridImageLayout = this.j;
            if (gridImageLayout != null) {
                gridImageLayout.setOnImageClickListener(yVar);
            }
        }
    }

    public void setOnImageTouchListener(dt7 dt7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048640, this, dt7Var) == null) {
            this.p = dt7Var;
        }
    }

    public void setOnLinkImageClickListener(z zVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048641, this, zVar) == null) {
            this.q = zVar;
        }
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048642, this, onLongClickListener) == null) {
            this.W = onLongClickListener;
            super.setOnLongClickListener(onLongClickListener);
        }
    }

    public void setOnVoiceAfterClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048643, this, onClickListener) == null) {
            this.x = onClickListener;
        }
    }

    public void setSubPbPost(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048644, this, z2) == null) {
            this.I = z2;
            I();
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
            this.a.g = true;
        }
    }

    public void setTextCenter(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048650, this, z2) == null) {
            this.E = z2;
        }
    }

    public void setTextColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048651, this, i2) == null) {
            tf5 tf5Var = this.a;
            if (i2 == tf5Var.j) {
                return;
            }
            tf5Var.j = i2;
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
            this.m = truncateAt;
            TextView textView = this.Q;
            if (textView != null) {
                textView.setEllipsize(truncateAt);
            }
        }
    }

    public void setTextPadding(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048653, this, i2) == null) {
            tf5 tf5Var = this.a;
            if (tf5Var.d == i2) {
                return;
            }
            tf5Var.d = i2;
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
        if (interceptable == null || interceptable.invokeF(1048654, this, f2) == null) {
            setFaceSize(f2);
            tf5 tf5Var = this.a;
            if (f2 == tf5Var.f) {
                return;
            }
            tf5Var.f = f2;
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
            this.U = str;
        }
    }

    public void setVoiceViewRes(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048659, this, i2) == null) {
            this.w = i2;
        }
    }

    public void setmGridEmptyClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048660, this, onClickListener) == null) {
            this.s = onClickListener;
        }
    }

    public void setmIsGridImageSupportLongPress(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048661, this, z2) == null) {
            this.O = z2;
        }
    }

    public void setText(TbRichText tbRichText, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048646, this, tbRichText, z2) == null) {
            setText(tbRichText, z2, null);
        }
    }

    public void setText(TbRichText tbRichText, boolean z2, s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048647, this, new Object[]{tbRichText, Boolean.valueOf(z2), sVar}) == null) {
            setText(tbRichText, z2, sVar, false, false);
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:251:0x022c */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:263:0x0036 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:264:0x0036 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:188:0x04bf A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:198:0x04e1  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x04fb  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0131  */
    /* JADX WARN: Type inference failed for: r0v122, types: [com.baidu.tbadk.gif.GifView, android.view.View] */
    /* JADX WARN: Type inference failed for: r0v157 */
    /* JADX WARN: Type inference failed for: r10v11, types: [android.widget.ImageView] */
    /* JADX WARN: Type inference failed for: r11v5 */
    /* JADX WARN: Type inference failed for: r25v0, types: [android.widget.LinearLayout, com.baidu.tbadk.widget.richText.TbRichTextView, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v56, types: [android.widget.ImageView] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void setText(TbRichText tbRichText, boolean z2, s sVar, boolean z3, boolean z4) {
        ArrayList<TbRichTextData> A;
        br7<ImageView> br7Var;
        boolean P;
        SpannableStringBuilder I;
        Iterator<TbRichTextData> it;
        TbRichTextData tbRichTextData;
        LinearLayout linearLayout;
        int i2;
        GifView gifView;
        TextView textView;
        int i3;
        bg<TiebaPlusRecommendCard> bgVar;
        ImageView imageView;
        View view2;
        RelativeLayout relativeLayout;
        int i4;
        Object imageView2;
        boolean z5;
        boolean z6;
        Object obj;
        boolean z7;
        GifView gifView2;
        GifView gifView3;
        Object obj2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048648, this, new Object[]{tbRichText, Boolean.valueOf(z2), sVar, Boolean.valueOf(z3), Boolean.valueOf(z4)}) == null) {
            s sVar2 = sVar;
            if (this.D != tbRichText || (tbRichText != null && tbRichText.isChanged)) {
                if (tbRichText != null) {
                    tbRichText.isChanged = false;
                }
                this.D = tbRichText;
                removeAllViews();
                if (tbRichText == null || (A = tbRichText.A()) == null) {
                    return;
                }
                Iterator<TbRichTextData> it2 = A.iterator();
                h hVar = null;
                boolean z8 = true;
                View view3 = null;
                View view4 = null;
                int i5 = 0;
                boolean z9 = false;
                boolean z10 = true;
                while (it2.hasNext()) {
                    TbRichTextData next = it2.next();
                    if (next != null) {
                        if (next.getType() == z8) {
                            TextView D = D(getContext());
                            P = P(next, D, z8, sVar2);
                            if (z2 && !this.B && (I = next.I()) != null) {
                                this.B = I.length() >= 200;
                            }
                            TiePlusEventController.p(next.L());
                            if (this.p != null) {
                                D.setOnTouchListener(this.i0);
                                textView = D;
                            } else {
                                D.setOnClickListener(this.r);
                                textView = D;
                            }
                        } else if (next.getType() == 8) {
                            if (this.N) {
                                if (!z9) {
                                    GridImageLayout gridImageView = getGridImageView();
                                    gridImageView.setData(tbRichText.C());
                                    it = it2;
                                    tbRichTextData = next;
                                    P = true;
                                    i2 = 8;
                                    z9 = true;
                                    view3 = gridImageView;
                                    if (P) {
                                    }
                                    sVar2 = sVar;
                                    it2 = it;
                                    hVar = null;
                                    z8 = true;
                                }
                            } else if (next.E() == null) {
                                tbRichTextData = next;
                                it = it2;
                                i2 = 8;
                                P = false;
                                view3 = view3;
                                if (P) {
                                    addView(view3);
                                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view3.getLayoutParams();
                                    if (!z10) {
                                    }
                                    if (!(view3 instanceof TbListTextView)) {
                                    }
                                    view4 = view3;
                                }
                                sVar2 = sVar;
                                it2 = it;
                                hVar = null;
                                z8 = true;
                            } else if (TbadkCoreApplication.getInst().isGifAutoPlay() && !next.E().G()) {
                                if (z4) {
                                    String B = next.E().B();
                                    if (StringUtils.isNull(B)) {
                                        tf5 tf5Var = this.a;
                                        if (tf5Var.G) {
                                            B = tf5Var.s ? next.E().y() : next.E().z();
                                        }
                                        if (StringUtils.isNull(B)) {
                                            B = this.a.s ? next.E().A() : next.E().D();
                                        }
                                    }
                                    br7<ImageView> br7Var2 = this.b;
                                    if (br7Var2 != null) {
                                        Object obj3 = (ImageView) br7Var2.h(B);
                                        if (obj3 instanceof GifView) {
                                            obj2 = (GifView) obj3;
                                            if (obj2 != null) {
                                                gifView3 = getGifView();
                                            } else {
                                                z7 = true;
                                                gifView2 = obj2;
                                                r rVar = new r(hVar);
                                                rVar.a = z8;
                                                gifView2.setTag(R.id.obfuscated_res_0x7f091ee5, rVar);
                                                P = O(next, gifView2, z7);
                                                textView = gifView2;
                                                if (z3) {
                                                    t tVar = new t(hVar);
                                                    tVar.a = z8;
                                                    gifView2.setTag(R.id.obfuscated_res_0x7f091ee6, tVar);
                                                    textView = gifView2;
                                                }
                                            }
                                        }
                                    }
                                    obj2 = hVar;
                                    if (obj2 != null) {
                                    }
                                } else {
                                    gifView3 = getGifView();
                                }
                                z7 = false;
                                gifView2 = gifView3;
                                r rVar2 = new r(hVar);
                                rVar2.a = z8;
                                gifView2.setTag(R.id.obfuscated_res_0x7f091ee5, rVar2);
                                P = O(next, gifView2, z7);
                                textView = gifView2;
                                if (z3) {
                                }
                            } else {
                                if (z4) {
                                    String y2 = this.a.c() ? next.E().y() : next.E().A();
                                    br7<ImageView> br7Var3 = this.b;
                                    Object obj4 = br7Var3 != null ? (ImageView) br7Var3.h(y2) : hVar;
                                    if (obj4 == null) {
                                        z6 = false;
                                        obj = getImageView();
                                    } else {
                                        z6 = true;
                                        obj = obj4;
                                    }
                                    imageView2 = obj;
                                    z5 = z6;
                                } else {
                                    imageView2 = getImageView();
                                    z5 = false;
                                }
                                tf5 tf5Var2 = this.a;
                                ?? r10 = imageView2;
                                P = K(next, imageView2, tf5Var2.k, tf5Var2.l, z5);
                                if (z3) {
                                    t tVar2 = new t(hVar);
                                    tVar2.a = z8;
                                    r10.setTag(R.id.obfuscated_res_0x7f091ee6, tVar2);
                                }
                                linearLayout = r10;
                                it = it2;
                                tbRichTextData = next;
                                i2 = 8;
                                view3 = linearLayout;
                                if (P && view3 != null) {
                                    addView(view3);
                                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) view3.getLayoutParams();
                                    if (!z10 && (i3 = this.a.E) >= 0) {
                                        if (layoutParams2 != null) {
                                            layoutParams2.topMargin = i3;
                                            view3.setLayoutParams(layoutParams2);
                                        }
                                        z10 = false;
                                    } else if (!(view3 instanceof TbListTextView)) {
                                        if (!(view4 instanceof ImageView) && !(view4 instanceof RelativeLayout)) {
                                            layoutParams2.topMargin = this.a.e;
                                        } else {
                                            layoutParams2.topMargin = this.a.A;
                                        }
                                        view3.setLayoutParams(layoutParams2);
                                    } else if ((!(view3 instanceof ImageView) && !(view3 instanceof RelativeLayout)) || (tbRichTextData.getType() != i2 && tbRichTextData.getType() != 20 && tbRichTextData.getType() != 17)) {
                                        if ((view3 instanceof ItemCardView) && !z10) {
                                            layoutParams2.topMargin = this.a.F;
                                            view3.setLayoutParams(layoutParams2);
                                        }
                                    } else {
                                        if (view4 instanceof TbListTextView) {
                                            layoutParams2.topMargin = this.a.v;
                                        } else if (!(view4 instanceof ImageView) && !(view3 instanceof RelativeLayout)) {
                                            layoutParams2.topMargin = this.a.e;
                                        } else {
                                            layoutParams2.topMargin = this.a.u;
                                        }
                                        view3.setLayoutParams(layoutParams2);
                                    }
                                    view4 = view3;
                                }
                                sVar2 = sVar;
                                it2 = it;
                                hVar = null;
                                z8 = true;
                            }
                        } else if (next.getType() == 32) {
                            tbRichTextData = next;
                            it = it2;
                            P = true;
                            linearLayout = E(tbRichTextData);
                            i2 = 8;
                            view3 = linearLayout;
                            if (P) {
                            }
                            sVar2 = sVar;
                            it2 = it;
                            hVar = null;
                            z8 = true;
                        } else {
                            tbRichTextData = next;
                            if (tbRichTextData.getType() == 512) {
                                view3 = F(view4);
                                if (view3 != null) {
                                    P = R(tbRichTextData, view3);
                                    gifView = view3;
                                    it = it2;
                                    linearLayout = gifView;
                                    i2 = 8;
                                    view3 = linearLayout;
                                }
                            } else {
                                if (tbRichTextData.getType() == 768) {
                                    View textVoiceView = getTextVoiceView();
                                    P = Q(tbRichTextData, (LinearLayout) textVoiceView, sVar2);
                                    gifView = textVoiceView;
                                } else if (tbRichTextData.getType() == 17) {
                                    GifView gifView4 = getGifView();
                                    P = J(tbRichTextData, gifView4);
                                    gifView = gifView4;
                                } else {
                                    if (tbRichTextData.getType() != 20) {
                                        it = it2;
                                        i2 = 8;
                                        if (tbRichTextData.getType() == 1280) {
                                            ImageView imageView3 = getImageView();
                                            P = M(tbRichTextData, imageView3, (this.a.k - getPaddingLeft()) - getPaddingRight(), this.a.l);
                                            imageView = imageView3;
                                        } else if (tbRichTextData.getType() != 37 && tbRichTextData.getType() != 1281) {
                                            if (tbRichTextData.getType() != 36 || tbRichTextData.M() == null || tbRichTextData.M().A() == null || (bgVar = this.i) == null) {
                                                P = false;
                                                view3 = view3;
                                            } else {
                                                TiebaPlusRecommendCard b2 = bgVar.b();
                                                b2.x(tbRichTextData.M());
                                                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) b2.getLayoutParams();
                                                tf5 tf5Var3 = this.a;
                                                marginLayoutParams.setMargins(0, tf5Var3.x, 0, tf5Var3.y);
                                                b2.setLayoutParams(marginLayoutParams);
                                                P = true;
                                                view3 = b2;
                                            }
                                        } else {
                                            ItemCardView itemCardView = getItemCardView();
                                            P = L(itemCardView, tbRichTextData);
                                            view3 = itemCardView;
                                        }
                                    } else if (i5 < 10) {
                                        int i6 = i5 + 1;
                                        boolean z11 = (tbRichTextData == null || tbRichTextData.H() == null || tbRichTextData.H().memeInfo == null || StringUtils.isNull(tbRichTextData.H().memeInfo.pic_url)) ? false : true;
                                        if (z11) {
                                            RelativeLayout b3 = this.g.b();
                                            b3.removeAllViews();
                                            b3.setLayoutParams(new LinearLayout.LayoutParams(tbRichTextData.H().memeInfo.width.intValue(), tbRichTextData.H().memeInfo.height.intValue()));
                                            if (DuiSwitch.getInOn() && this.l) {
                                                int intValue = tbRichTextData.H().memeInfo.width.intValue();
                                                int intValue2 = tbRichTextData.H().memeInfo.height.intValue();
                                                tf5 tf5Var4 = this.a;
                                                c0(b3, intValue, intValue2, tf5Var4.k, tf5Var4.l);
                                            } else {
                                                int intValue3 = tbRichTextData.H().memeInfo.width.intValue();
                                                int intValue4 = tbRichTextData.H().memeInfo.height.intValue();
                                                tf5 tf5Var5 = this.a;
                                                b0(b3, intValue3, intValue4, tf5Var5.k, tf5Var5.l);
                                            }
                                            ImageView b4 = this.c.b();
                                            tf5 tf5Var6 = this.a;
                                            N(tbRichTextData, b4, tf5Var6.k, tf5Var6.l);
                                            if (DuiSwitch.getInOn() && this.l) {
                                                ImageView b5 = this.c.b();
                                                b5.setTag(this.D);
                                                if (b5 instanceof TbImageView) {
                                                    TbImageView tbImageView = (TbImageView) b5;
                                                    tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
                                                    tbImageView.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
                                                    tbImageView.setBorderSurroundContent(z8);
                                                    tbImageView.setDrawCorner(z8);
                                                    tbImageView.setDrawBorder(z8);
                                                    tbImageView.setLongIconSupport(z8);
                                                    tbImageView.setGifIconSupport(z8);
                                                    tbImageView.setConrers(15);
                                                    tbImageView.setRadius(this.P);
                                                    tbImageView.setAdjustViewBounds(false);
                                                    if (this.N) {
                                                        tbImageView.setPlaceHolder(2);
                                                    } else {
                                                        tbImageView.setPlaceHolder(3);
                                                    }
                                                }
                                                b5.setScaleType(ImageView.ScaleType.FIT_XY);
                                                int f2 = mi.f(getContext(), R.dimen.obfuscated_res_0x7f070303);
                                                int f3 = mi.f(getContext(), R.dimen.obfuscated_res_0x7f070303);
                                                b4.setId(R.id.obfuscated_res_0x7f0913f7);
                                                int intValue5 = tbRichTextData.H().memeInfo.width.intValue();
                                                int intValue6 = tbRichTextData.H().memeInfo.height.intValue();
                                                tf5 tf5Var7 = this.a;
                                                it = it2;
                                                relativeLayout = b3;
                                                d0(b4, intValue5, intValue6, tf5Var7.k, tf5Var7.l, this.h0);
                                                relativeLayout.addView(b4);
                                                if (f3 > tbRichTextData.H().memeInfo.height.intValue()) {
                                                    f2 /= 2;
                                                    i4 = f3 / 2;
                                                } else {
                                                    i4 = f3;
                                                }
                                                RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(f2, i4);
                                                i2 = 8;
                                                layoutParams3.addRule(8, R.id.obfuscated_res_0x7f0913f7);
                                                layoutParams3.addRule(11);
                                                b5.setOnClickListener(this.h0);
                                                if (relativeLayout.getLeft() > 0) {
                                                    layoutParams3.rightMargin = mi.f(getContext(), R.dimen.obfuscated_res_0x7f0702e9);
                                                }
                                                SkinManager.setImageResource(b5, R.drawable.icon_emotion_dui_n);
                                                relativeLayout.addView(b5, layoutParams3);
                                            } else {
                                                it = it2;
                                                i2 = 8;
                                                relativeLayout = b3;
                                                int intValue7 = tbRichTextData.H().memeInfo.width.intValue();
                                                int intValue8 = tbRichTextData.H().memeInfo.height.intValue();
                                                tf5 tf5Var8 = this.a;
                                                f0(b4, intValue7, intValue8, tf5Var8.k, tf5Var8.l, this.h0);
                                                relativeLayout.addView(b4);
                                            }
                                            view2 = relativeLayout;
                                        } else {
                                            it = it2;
                                            i2 = 8;
                                            view2 = view3;
                                        }
                                        i5 = i6;
                                        P = z11;
                                        imageView = view2;
                                    }
                                    view3 = imageView;
                                }
                                it = it2;
                                linearLayout = gifView;
                                i2 = 8;
                                view3 = linearLayout;
                            }
                            if (P) {
                            }
                            sVar2 = sVar;
                            it2 = it;
                            hVar = null;
                            z8 = true;
                        }
                        tbRichTextData = next;
                        gifView = textView;
                        it = it2;
                        linearLayout = gifView;
                        i2 = 8;
                        view3 = linearLayout;
                        if (P) {
                        }
                        sVar2 = sVar;
                        it2 = it;
                        hVar = null;
                        z8 = true;
                    }
                }
                if (view4 instanceof TbListTextView) {
                    LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) view4.getLayoutParams();
                    layoutParams4.bottomMargin = this.a.D;
                    view4.setLayoutParams(layoutParams4);
                } else if (view4 != null && this.a.C >= 0) {
                    LinearLayout.LayoutParams layoutParams5 = (LinearLayout.LayoutParams) view4.getLayoutParams();
                    layoutParams5.bottomMargin = this.a.C;
                    view4.setLayoutParams(layoutParams5);
                }
                if (z3 || (br7Var = this.b) == null) {
                    return;
                }
                br7Var.c();
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
        this.a = new tf5();
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.k = null;
        this.l = true;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = true;
        this.v = true;
        this.w = -1;
        this.y = false;
        this.z = false;
        this.A = null;
        this.B = false;
        this.E = false;
        this.F = -1;
        this.G = -1;
        this.H = true;
        this.I = false;
        this.J = false;
        this.K = false;
        this.L = false;
        this.M = false;
        this.N = false;
        this.O = false;
        this.R = false;
        this.S = false;
        this.T = false;
        this.V = new h(this, 2, null);
        this.h0 = new i(this);
        this.i0 = new dt7(new j(this));
        this.j0 = new k(this);
        this.k0 = new c(this);
        this.p0 = new d(this);
        this.q0 = new e(this, 2004018);
        H();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.obfuscated_res_0x7f0401e5, R.attr.obfuscated_res_0x7f040273, R.attr.obfuscated_res_0x7f040280, R.attr.obfuscated_res_0x7f0402fe, R.attr.obfuscated_res_0x7f0403e9, R.attr.obfuscated_res_0x7f040462, R.attr.obfuscated_res_0x7f040464, R.attr.obfuscated_res_0x7f04057f, R.attr.obfuscated_res_0x7f0405a3, R.attr.obfuscated_res_0x7f04061a, R.attr.obfuscated_res_0x7f040657, R.attr.obfuscated_res_0x7f040663, R.attr.obfuscated_res_0x7f040664, R.attr.obfuscated_res_0x7f0406cb});
        this.a.b(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        I();
    }
}
