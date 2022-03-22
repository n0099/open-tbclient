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
import c.a.p0.w2.j.c;
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
import io.reactivex.annotations.NonNull;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import tbclient.MemeInfo;
import tbclient.PbContent;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes5.dex */
public class TbRichTextView extends LinearLayout implements c.a.d.h.a.h {
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
    public c.a.o0.e1.n.f V;
    public View.OnLongClickListener W;
    public c.a.o0.e1.n.a a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.p0.w2.a<ImageView> f30968b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.d.f.k.b<ImageView> f30969c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.d.f.k.b<TextView> f30970d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.d.f.k.b<View> f30971e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.d.f.k.b<LinearLayout> f30972f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.d.f.k.b<RelativeLayout> f30973g;
    public v g0;

    /* renamed from: h  reason: collision with root package name */
    public c.a.d.f.k.b<GifView> f30974h;
    public final View.OnClickListener h0;
    public c.a.d.f.k.b<TiebaPlusRecommendCard> i;
    public final c.a.p0.w2.j.c i0;
    public GridImageLayout j;
    public final View.OnClickListener j0;
    public c.a.d.f.k.b<ItemCardView> k;
    public final w k0;
    public boolean l;
    public boolean l0;
    public TextUtils.TruncateAt m;
    public Drawable m0;
    public a0 n;
    public String n0;
    public y o;
    public BdUniqueId o0;
    public c.a.p0.w2.j.c p;
    public final c.a.d.f.l.c<c.a.d.o.d.a> p0;
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

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbRichTextData a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ TbRichTextView f30975b;

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
            this.f30975b = tbRichTextView;
            this.a = tbRichTextData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f30975b.C == null) {
                return;
            }
            TbRichTextEmotionInfo B = this.a.B();
            x xVar = this.f30975b.C;
            GifInfo gifInfo = B.mGifInfo;
            xVar.a(view, gifInfo.mGid, gifInfo.mPackageName, gifInfo.mIcon, gifInfo.mStaticUrl, gifInfo.mDynamicUrl, gifInfo.mSharpText, gifInfo.mGifWidth, gifInfo.mGifHeight);
        }
    }

    /* loaded from: classes5.dex */
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
        public void onMovedToScrapHeap(View view) {
            View findViewById;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && (findViewById = view.findViewById(this.a)) != null && (findViewById instanceof TbRichTextView)) {
                ((TbRichTextView) findViewById).setText(null);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbRichTextData a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ItemCardView f30976b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ TbRichTextView f30977c;

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
            this.f30977c = tbRichTextView;
            this.a = tbRichTextData;
            this.f30976b = itemCardView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.a.getType() == 37) {
                    TiebaStatic.log(new StatisticItem("common_click").param("page_type", "a005").param(TiebaStatic.Params.GUA_TYPE, 4).param("obj_locate", 16));
                    ItemCardHelper.q(this.f30976b.getPosition(), this.a.F().a().itemId, this.f30976b.z(this.a.F().a()), this.f30977c.U, c.a.o0.r.l0.p.c.a(this.a.F().a().buttonLinkType.intValue(), this.a.F().a().apkDetail != null ? this.a.F().a().apkDetail.pkg_source.intValue() : 0), "", 2);
                    ItemClickJumpUtil.itemClickJump(this.a.F().a().forumName, String.valueOf(this.a.F().a().itemId), 3, 3);
                } else if (this.a.getType() == 1281) {
                    TiebaStatic.log(new StatisticItem("common_click").param("page_type", "a005").param(TiebaStatic.Params.GUA_TYPE, 2).param("obj_locate", 16));
                    int a = c.a.o0.r.l0.p.c.a(this.a.C().getItem().button_link_type.intValue(), this.a.C().getItem().apk_detail != null ? this.a.C().getItem().apk_detail.pkg_source.intValue() : 0);
                    ItemData itemData = new ItemData();
                    itemData.parseProto(this.a.C().getItem());
                    ItemCardHelper.q(this.f30976b.getPosition(), this.a.C().getItem().item_id.longValue(), this.f30976b.z(itemData), this.f30977c.U, a, "", 2);
                    ItemClickJumpUtil.itemClickJump(this.a.C().getItemForumName(), this.a.C().getItemID(), 3, 3);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
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

    /* loaded from: classes5.dex */
    public class d extends c.a.d.f.l.c<c.a.d.o.d.a> {
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

        @Override // c.a.d.f.l.c
        public void onCancelled(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                super.onCancelled(str);
            }
        }

        @Override // c.a.d.f.l.c
        public void onProgressUpdate(Object... objArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, objArr) == null) {
                super.onProgressUpdate(objArr);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.d.f.l.c
        public void onLoaded(c.a.d.o.d.a aVar, String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, str, i) == null) {
                this.a.B(aVar);
            }
        }
    }

    /* loaded from: classes5.dex */
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

    /* loaded from: classes5.dex */
    public class f implements c.a.d.f.k.c<ImageView> {
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
        @Override // c.a.d.f.k.c
        public /* bridge */ /* synthetic */ ImageView a(ImageView imageView) {
            ImageView imageView2 = imageView;
            e(imageView2);
            return imageView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // c.a.d.f.k.c
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
                    if (c.a.o0.r.l.c().g()) {
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
        @Override // c.a.d.f.k.c
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
                    foreDrawableImageView.N();
                    foreDrawableImageView.setForegroundDrawable(0);
                    foreDrawableImageView.setDefaultBgResource(R.color.common_color_10220);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.d.f.k.c
        /* renamed from: g */
        public ImageView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(c.a.d.a.j.a(this.a.getContext()).getPageActivity());
                boolean g2 = c.a.o0.r.l.c().g();
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

    /* loaded from: classes5.dex */
    public class g extends c.a.p0.w2.a<ImageView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TbRichTextView f30978e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(TbRichTextView tbRichTextView, c.a.d.f.k.c cVar, int i, int i2) {
            super(cVar, i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbRichTextView, cVar, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((c.a.d.f.k.c) objArr2[0], ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f30978e = tbRichTextView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.w2.a
        /* renamed from: i */
        public ImageView h(Object obj) {
            InterceptResult invokeL;
            ImageView imageView;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
                if (obj instanceof String) {
                    Iterator it = this.f2202c.iterator();
                    while (it.hasNext()) {
                        imageView = (ImageView) it.next();
                        if ((imageView instanceof TbImageView) && obj.equals(((TbImageView) imageView).getUrl())) {
                            break;
                        }
                    }
                }
                imageView = null;
                this.f2202c.remove(imageView);
                return imageView;
            }
            return (ImageView) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class h extends c.a.o0.e1.n.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ TbRichTextView f30979h;

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
            this.f30979h = tbRichTextView;
        }

        @Override // c.a.o0.e1.n.f, android.text.style.ClickableSpan
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f30979h.setAddExpandableListener(false);
                this.f30979h.setTextEllipsize(TextUtils.TruncateAt.END);
                this.f30979h.setMaxLines(5);
                this.f30979h.setAddTruncateListener(true);
                this.f30979h.D.isChanged = true;
                TbRichTextView tbRichTextView = this.f30979h;
                tbRichTextView.setText(tbRichTextView.D);
            }
        }
    }

    /* loaded from: classes5.dex */
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
        public void onClick(View view) {
            MemeInfo memeInfo;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && this.a.o != null && (view instanceof ImageView)) {
                String str = null;
                Object tag = view.getTag();
                int i = 0;
                int i2 = -1;
                if (tag != null && (tag instanceof TbRichText)) {
                    int childCount = this.a.getChildCount();
                    while (i < childCount) {
                        i2++;
                        if (view.getParent() == this.a.getChildAt(i)) {
                            break;
                        }
                        i++;
                    }
                    this.a.o.a(view, null, i2, this.a.J, false);
                    return;
                }
                if (tag != null && (tag instanceof String)) {
                    str = (String) tag;
                } else {
                    boolean z = view instanceof TbImageView;
                    if (z && (view.getTag(R.id.obfuscated_res_0x7f091e9f) instanceof TbRichTextMemeInfo)) {
                        TbRichTextMemeInfo tbRichTextMemeInfo = (TbRichTextMemeInfo) view.getTag(R.id.obfuscated_res_0x7f091e9f);
                        String str2 = (tbRichTextMemeInfo == null || (memeInfo = tbRichTextMemeInfo.memeInfo) == null) ? "" : memeInfo.pic_url;
                        int childCount2 = this.a.getChildCount();
                        while (i < childCount2) {
                            i2++;
                            if (view.getParent() == this.a.getChildAt(i)) {
                                break;
                            }
                            i++;
                        }
                        this.a.o.a(view, str2, i2, this.a.J, false);
                        return;
                    } else if (z) {
                        str = ((TbImageView) view).getUrl();
                    } else if (view instanceof GifView) {
                        str = ((GifView) view).getUrl();
                    }
                }
                String str3 = str;
                int childCount3 = this.a.getChildCount();
                while (i < childCount3) {
                    View childAt = this.a.getChildAt(i);
                    if (this.a.S(childAt)) {
                        i2++;
                    }
                    if (view == childAt) {
                        break;
                    }
                    i++;
                }
                this.a.o.a(view, str3, i2, this.a.J, false);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class j implements c.a {
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

        @Override // c.a.p0.w2.j.c.a
        public boolean a(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                return false;
            }
            return invokeLL.booleanValue;
        }

        @Override // c.a.p0.w2.j.c.a
        public boolean b(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, motionEvent)) == null) {
                if (this.a.h0 != null) {
                    this.a.h0.onClick(view);
                    return true;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }

        @Override // c.a.p0.w2.j.c.a
        public boolean c(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view, motionEvent)) == null) {
                if (this.a.p != null) {
                    this.a.p.a(view);
                    return this.a.p.onDoubleTap(motionEvent);
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
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
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && this.a.q != null && (view instanceof TbImageView)) {
                String str = null;
                Object tag = view.getTag();
                if (tag != null && (tag instanceof u)) {
                    str = ((u) tag).a;
                }
                this.a.q.a(view, str);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class l implements c.a.d.f.k.c<TextView> {
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
        @Override // c.a.d.f.k.c
        public /* bridge */ /* synthetic */ TextView a(TextView textView) {
            TextView textView2 = textView;
            e(textView2);
            return textView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // c.a.d.f.k.c
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
        @Override // c.a.d.f.k.c
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
        @Override // c.a.d.f.k.c
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

    /* loaded from: classes5.dex */
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
                    Object tag = view2.getTag(R.id.obfuscated_res_0x7f091ea1);
                    if (!(tag instanceof t) || !((t) tag).a) {
                        if (this.a.f30974h != null) {
                            this.a.f30974h.e((GifView) view2);
                        }
                    } else {
                        if (this.a.f30968b == null) {
                            TbRichTextView tbRichTextView = this.a;
                            tbRichTextView.f30968b = tbRichTextView.getRecycleImageViewPool();
                        }
                        this.a.f30968b.e((ImageView) view2);
                    }
                } else if (view2 instanceof ImageView) {
                    Object tag2 = view2.getTag(R.id.obfuscated_res_0x7f091ea1);
                    if (!(tag2 instanceof t) || !((t) tag2).a) {
                        if (this.a.f30969c != null) {
                            this.a.f30969c.e((ImageView) view2);
                        }
                    } else {
                        if (this.a.f30968b == null) {
                            TbRichTextView tbRichTextView2 = this.a;
                            tbRichTextView2.f30968b = tbRichTextView2.getRecycleImageViewPool();
                        }
                        this.a.f30968b.e((ImageView) view2);
                    }
                } else if ((view2 instanceof TextView) && this.a.f30970d != null) {
                    this.a.f30970d.e((TextView) view2);
                } else if ((view2 instanceof PlayVoiceBnt) && this.a.f30971e != null) {
                    this.a.f30971e.e(view2);
                } else if ((view2 instanceof PlayVoiceBntNew) && this.a.f30971e != null) {
                    this.a.f30971e.e(view2);
                } else if (view2 instanceof GridImageLayout) {
                    GridImageLayout gridImageLayout = (GridImageLayout) view2;
                    int childCount = gridImageLayout.getChildCount();
                    for (int i = 0; i < childCount; i++) {
                        View childAt = gridImageLayout.getChildAt(i);
                        if ((childAt instanceof GifView) && this.a.f30974h != null) {
                            this.a.f30974h.e((GifView) childAt);
                        } else if ((childAt instanceof ImageView) && this.a.f30969c != null) {
                            this.a.f30969c.e((ImageView) childAt);
                        }
                    }
                    gridImageLayout.removeAllViews();
                    gridImageLayout.g();
                } else if ((view2 instanceof TiebaPlusRecommendCard) && this.a.i != null) {
                    this.a.i.e((TiebaPlusRecommendCard) view2);
                } else if ((view2 instanceof RelativeLayout) && this.a.f30973g != null) {
                    this.a.f30973g.e((RelativeLayout) view2);
                } else if ((view2 instanceof ItemCardView) && this.a.k != null) {
                    this.a.k.e((ItemCardView) view2);
                }
                if (!(view2 instanceof LinearLayout) || (view2 instanceof ItemCardView)) {
                    return;
                }
                Object tag3 = view2.getTag();
                if (tag3 == null || !(tag3 instanceof String) || !"VideoView".equals(tag3)) {
                    if (this.a.f30972f != null) {
                        LinearLayout linearLayout = (LinearLayout) view2;
                        int childCount2 = linearLayout.getChildCount();
                        for (int i2 = 0; i2 < childCount2; i2++) {
                            View childAt2 = linearLayout.getChildAt(i2);
                            if (childAt2 != null) {
                                if ((childAt2 instanceof TextView) && this.a.f30970d != null) {
                                    this.a.f30970d.e((TextView) childAt2);
                                } else if ((childAt2 instanceof PlayVoiceBnt) && this.a.f30971e != null) {
                                    this.a.f30971e.e(childAt2);
                                } else if ((childAt2 instanceof PlayVoiceBntNew) && this.a.f30971e != null) {
                                    this.a.f30971e.e(childAt2);
                                }
                            }
                        }
                        linearLayout.removeAllViews();
                        this.a.f30972f.e(linearLayout);
                        return;
                    }
                    return;
                }
                view2.setBackgroundDrawable(null);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class n implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbRichTextData a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ TbRichTextView f30980b;

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
            this.f30980b = tbRichTextView;
            this.a = tbRichTextData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.a.I() == null) {
                return;
            }
            if (this.f30980b.getContext() instanceof c.a.o0.e1.n.i) {
                ((c.a.o0.e1.n.i) this.f30980b.getContext()).onVideoClicked(this.f30980b.getContext(), this.a.I().toString());
                return;
            }
            c.a.d.a.f<?> a = c.a.d.a.j.a(this.f30980b.getContext());
            if (a == null || !(a.getOrignalPage() instanceof c.a.o0.e1.n.i)) {
                return;
            }
            ((c.a.o0.e1.n.i) a.getOrignalPage()).onVideoClicked(this.f30980b.getContext(), this.a.I().toString());
        }
    }

    /* loaded from: classes5.dex */
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

    /* loaded from: classes5.dex */
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

    /* loaded from: classes5.dex */
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

    /* loaded from: classes5.dex */
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

    /* loaded from: classes5.dex */
    public interface s {
        void decorateText(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView);
    }

    /* loaded from: classes5.dex */
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

    /* loaded from: classes5.dex */
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

    /* loaded from: classes5.dex */
    public interface v {
        void a();
    }

    /* loaded from: classes5.dex */
    public interface w {
        void dispatchTouchEvent(MotionEvent motionEvent);
    }

    /* loaded from: classes5.dex */
    public interface x {
        void a(View view, String str, String str2, String str3, String str4, String str5, String str6, int i, int i2);
    }

    /* loaded from: classes5.dex */
    public interface y {
        void a(View view, String str, int i, boolean z, boolean z2);
    }

    /* loaded from: classes5.dex */
    public interface z {
        void a(View view, String str);
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
        r0 = c.a.d.f.p.n.h(TbadkCoreApplication.getInst());
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
        this.a = new c.a.o0.e1.n.a();
        this.f30968b = null;
        this.f30969c = null;
        this.f30970d = null;
        this.f30971e = null;
        this.f30972f = null;
        this.f30973g = null;
        this.f30974h = null;
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
        this.i0 = new c.a.p0.w2.j.c(new j(this));
        this.j0 = new k(this);
        this.k0 = new c(this);
        this.p0 = new d(this);
        this.q0 = new e(this, 2004018);
        H();
    }

    public static c.a.d.f.k.b<TextView> C(Context context, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, context, i2)) == null) ? new c.a.d.f.k.b<>(new l(context), i2, 0) : (c.a.d.f.k.b) invokeLI.objValue;
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
            c.a.d.f.k.b<GifView> bVar = this.f30974h;
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
            this.j.setObjectPool(this.f30969c, this.f30974h);
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
            c.a.d.f.k.b<ImageView> bVar = this.f30969c;
            ImageView imageView = null;
            ImageView b2 = bVar != null ? bVar.b() : null;
            if (b2 != null && b2.getParent() == null) {
                imageView = b2;
            }
            if (imageView != null) {
                imageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f051b));
            }
            return imageView;
        }
        return (ImageView) invokeV.objValue;
    }

    private ItemCardView getItemCardView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65557, this)) == null) {
            c.a.d.f.k.b<ItemCardView> bVar = this.k;
            ItemCardView b2 = bVar != null ? bVar.b() : null;
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
            LinearLayout b2 = this.f30972f.b();
            if (b2 != null) {
                TextView D = D(getContext());
                if (D == null) {
                    this.f30972f.e(b2);
                    return null;
                }
                b2.addView(D);
                View F = F(null);
                if (F == null) {
                    this.f30970d.e(D);
                    this.f30972f.e(b2);
                    return null;
                }
                b2.addView(F);
            }
            return b2;
        }
        return (View) invokeV.objValue;
    }

    private void setFaceSize(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(65571, this, f2) == null) {
            if (this.S && UbsABTestHelper.isResizeEmotionABTest()) {
                int emotionContentSizeOfLzl = this.I ? TbConfig.getEmotionContentSizeOfLzl() : TbConfig.getEmotionContentSize();
                c.a.o0.e1.n.a aVar = this.a;
                aVar.f10151g = emotionContentSizeOfLzl;
                aVar.f10152h = emotionContentSizeOfLzl;
                return;
            }
            c.a.o0.e1.n.a aVar2 = this.a;
            int i2 = (int) f2;
            aVar2.f10151g = i2;
            aVar2.f10152h = i2;
        }
    }

    public final void B(c.a.d.o.d.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null) {
            return;
        }
        try {
            NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(getResources(), aVar.p(), aVar.p().getNinePatchChunk(), aVar.o(), null);
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
            c.a.d.f.k.b<TextView> bVar = this.f30970d;
            TextView b2 = bVar != null ? bVar.b() : null;
            if (b2 == null || b2.getParent() != null) {
                b2 = new TbListTextView(context);
            }
            int i2 = this.a.f10147c;
            b2.setPadding(i2, 0, i2, 0);
            return b2;
        }
        return (TextView) invokeL.objValue;
    }

    public final LinearLayout E(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, tbRichTextData)) == null) {
            if (this.a.m <= 0 || tbRichTextData == null) {
                return null;
            }
            LinearLayout linearLayout = new LinearLayout(getContext());
            linearLayout.setTag("VideoView");
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.topMargin = this.a.f10148d;
            linearLayout.setClickable(true);
            Bitmap bitmap = SkinManager.getBitmap(this.a.m);
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

    public final View F(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, view)) == null) {
            c.a.d.f.k.b<View> bVar = this.f30971e;
            View b2 = bVar != null ? bVar.b() : null;
            if ((b2 == null || b2.getParent() != null) && this.w != -1) {
                b2 = LayoutInflater.from(getContext()).inflate(this.w, (ViewGroup) null);
            }
            if (b2 != null) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                if (view instanceof TbListTextView) {
                    layoutParams.topMargin = this.a.v;
                } else {
                    layoutParams.topMargin = this.a.f10148d;
                }
                layoutParams.bottomMargin = this.a.A;
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
        c.a.o0.e1.n.i iVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            c.a.d.a.f<?> a2 = c.a.d.a.j.a(getContext());
            if (getContext() instanceof c.a.o0.e1.n.i) {
                iVar = (c.a.o0.e1.n.i) getContext();
            } else {
                iVar = (a2 == null || !(a2.getOrignalPage() instanceof c.a.o0.e1.n.i)) ? null : (c.a.o0.e1.n.i) a2.getOrignalPage();
            }
            if (iVar == null && (getContext() instanceof BaseFragmentActivity)) {
                List<Fragment> fragments = ((BaseFragmentActivity) getContext()).getSupportFragmentManager().getFragments();
                if (!ListUtils.isEmpty(fragments) && (fragments.get(0) instanceof c.a.o0.e1.n.i)) {
                    iVar = (c.a.o0.e1.n.i) fragments.get(0);
                }
            }
            if (a2 != null) {
                a2.registerListener(this.q0);
            }
            if (iVar != null) {
                this.f30969c = iVar.getImageViewPool();
                this.f30970d = iVar.getTextViewPool();
                this.f30971e = iVar.getVoiceViewPool();
                this.f30972f = iVar.getTextVoiceViewPool();
                this.f30974h = iVar.getGifViewPool();
                this.i = iVar.getTiejiaRecommendPool();
                this.f30973g = iVar.getRelativeLayoutPool();
                this.k = iVar.getItemCardViewPool();
                if (iVar.getListView() != null && this.n == null) {
                    this.n = new a0(iVar.getRichTextViewId());
                    iVar.getListView().setRecyclerListener(this.n);
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
            gifView.f0(tbRichTextData.B().mGifInfo);
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
                if (this.a.q) {
                    tbImageView.setSupportNoImage(true);
                }
                String y2 = this.a.c() ? tbRichTextData.E().y() : tbRichTextData.E().A();
                if (!z2 || tbImageView.getUrl() == null || !tbImageView.getUrl().equals(y2)) {
                    tbImageView.J(y2, this.v ? 17 : 18, false);
                }
                if (!tbRichTextData.E().E()) {
                    tbImageView.setAdjustViewBounds(false);
                }
                tbImageView.setTag(R.id.obfuscated_res_0x7f091e9f, null);
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
                if (this.a.q) {
                    tbImageView.setSupportNoImage(true);
                }
                tbImageView.J(G.y(), this.v ? 17 : 18, false);
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
                if (this.a.q) {
                    tbImageView.setSupportNoImage(true);
                }
                tbImageView.J(tbRichTextData.H().memeInfo.pic_url, this.v ? 17 : 18, false);
                tbImageView.setAdjustViewBounds(false);
                tbImageView.setTag(R.id.obfuscated_res_0x7f091e9f, tbRichTextData.H());
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
                c.a.o0.e1.n.a aVar = this.a;
                if (aVar.F) {
                    B = aVar.r ? tbRichTextData.E().y() : tbRichTextData.E().z();
                }
                if (StringUtils.isNull(B)) {
                    B = this.a.r ? tbRichTextData.E().A() : tbRichTextData.E().D();
                }
            }
            gifView.setShowStaticDrawable(false);
            if (!z2 || gifView.getUrl() == null || !gifView.getUrl().equals(B)) {
                gifView.g0(B, 38);
            }
            int width = tbRichTextData.E().getWidth();
            int height = tbRichTextData.E().getHeight();
            c.a.o0.e1.n.a aVar2 = this.a;
            return e0(gifView, width, height, aVar2.j, aVar2.k, this.h0);
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
                layoutParams.topMargin = this.a.f10148d;
            }
            c.a.o0.e1.n.a aVar = this.a;
            textView.setLineSpacing(aVar.f10146b, aVar.a);
            textView.setTextSize(0, this.a.f10149e);
            if (this.a.f10150f) {
                c.a.o0.r.v.c.d(textView).A(R.string.F_X02);
            }
            textView.setTextColor(this.a.i);
            textView.setLinkTextColor(SkinManager.getColor(R.color.CAM_X0304));
            textView.setHighlightColor(getContext().getResources().getColor(R.color.transparent));
            textView.setSingleLine(this.a.n);
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
                c.a.o0.r.v.c.d(textView).y(R.array.S_O_X001);
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
            c.a.o0.e1.n.a aVar2 = this.a;
            int i5 = aVar2.f10152h;
            if (i5 > 0 && (i2 = aVar2.f10151g) > 0) {
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
                    textView.setMovementMethod(c.a.p0.q4.c.a());
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

    public final boolean R(TbRichTextData tbRichTextData, View view) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048591, this, tbRichTextData, view)) == null) {
            view.setTag(tbRichTextData.O());
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
            }
            view.setLayoutParams(layoutParams);
            if (view instanceof PlayVoiceBntNew) {
                ((PlayVoiceBntNew) view).d();
                return true;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public final boolean S(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, view)) == null) {
            if (view instanceof ImageView) {
                if (view instanceof GifView) {
                    return view.getTag(R.id.obfuscated_res_0x7f091ea0) != null && (view.getTag(R.id.obfuscated_res_0x7f091ea0) instanceof r) && ((r) view.getTag(R.id.obfuscated_res_0x7f091ea0)).a;
                }
                if ((view instanceof TbImageView) && view.getTag() != null) {
                    if (view.getTag() instanceof u) {
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
        if (!(interceptable == null || interceptable.invokeCommon(1048595, this, new Object[]{relativeLayout, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) || (l2 = c.a.d.f.p.n.l(i2, i3, i4, i5)) == null) {
            return;
        }
        int[] iArr = {l2[0], l2[1]};
        int i6 = iArr[0];
        int i7 = iArr[1];
        if (this.a.s && i4 > i6) {
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
        if (!(interceptable == null || interceptable.invokeCommon(1048596, this, new Object[]{relativeLayout, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) || (l2 = c.a.d.f.p.n.l(i2, i3, i4, i5)) == null) {
            return;
        }
        int[] iArr = {l2[0], l2[1]};
        int i8 = iArr[0];
        int i9 = iArr[1];
        if (this.a.s && i4 > i8) {
            float f3 = r0;
            if (f3 > 1.0f) {
                float f4 = i8;
                float f5 = i4;
                if (f4 * f3 > f5) {
                    i7 = i4 - c.a.d.f.p.n.f(getContext(), R.dimen.obfuscated_res_0x7f0702f9);
                    f2 = c.a.d.f.p.n.f(getContext(), R.dimen.obfuscated_res_0x7f0701be);
                } else {
                    float f6 = f5 * 0.68f;
                    if (f4 * f3 > f6) {
                        i7 = (int) f6;
                        f2 = c.a.d.f.p.n.f(getContext(), R.dimen.obfuscated_res_0x7f0702f9);
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
            int[] l2 = c.a.d.f.p.n.l(i2, i3, i4, i5);
            if (l2 == null) {
                return false;
            }
            int[] iArr = {l2[0], l2[1]};
            int i6 = iArr[0];
            int i7 = iArr[1];
            if (this.a.s && i4 > i6) {
                float f2 = r0;
                if (f2 > 1.0f) {
                    float f3 = i6;
                    float f4 = i4;
                    if (f3 * f2 > f4) {
                        i6 = (i4 - c.a.d.f.p.n.f(getContext(), R.dimen.obfuscated_res_0x7f0702f9)) - c.a.d.f.p.n.f(getContext(), R.dimen.obfuscated_res_0x7f0701be);
                    } else {
                        float f5 = f4 * 0.68f;
                        i6 = f3 * f2 > f5 ? ((int) f5) - c.a.d.f.p.n.f(getContext(), R.dimen.obfuscated_res_0x7f0702f9) : (int) (f3 * f2);
                    }
                    if (iArr[0] > 0) {
                        i7 = (iArr[1] * i6) / iArr[0];
                    }
                }
            }
            boolean z2 = imageView instanceof TbImageView;
            if (z2) {
                TbImageView tbImageView = (TbImageView) imageView;
                tbImageView.setDefaultResource(this.a.l);
                if (tbImageView.getGifIconWidth() < i6 && tbImageView.getGifIconHeight() < i7) {
                    tbImageView.setGifIconSupport(true);
                } else {
                    tbImageView.setGifIconSupport(false);
                }
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i6, i7);
            if (this.a.s) {
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
            c.a.o0.e1.n.a aVar = this.a;
            if (aVar.s) {
                imageView.setScaleType(aVar.p);
                if (z2) {
                    ((TbImageView) imageView).setOnDrawListener(this.a.I);
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
            int[] l2 = c.a.d.f.p.n.l(i2, i3, i4, i5);
            if (l2 == null) {
                return false;
            }
            int[] iArr = {l2[0], l2[1]};
            int i6 = iArr[0];
            int i7 = iArr[1];
            if (this.a.s && i4 > i6) {
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
                tbImageView.setDefaultResource(this.a.l);
                if (tbImageView.getGifIconWidth() < i6 && tbImageView.getGifIconHeight() < i7) {
                    tbImageView.setGifIconSupport(true);
                } else {
                    tbImageView.setGifIconSupport(false);
                }
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i6, i7);
            if (this.a.s) {
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

    public c.a.o0.e1.n.a getLayoutStrategy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.a : (c.a.o0.e1.n.a) invokeV.objValue;
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

    public c.a.p0.w2.a<ImageView> getRecycleImageViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            if (this.f30968b == null) {
                this.f30968b = new g(this, new f(this), 10, 0);
            }
            return this.f30968b;
        }
        return (c.a.p0.w2.a) invokeV.objValue;
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
            c.a.d.a.i c2 = c.a.d.a.j.c(getContext());
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
            c.a.d.o.d.a aVar = (c.a.d.o.d.a) c.a.d.f.l.d.h().n(this.n0, 19, new Object[0]);
            if (aVar != null) {
                B(aVar);
            } else if (z2) {
                invalidate();
            } else if (!c.a.d.f.l.d.h().j(19)) {
                invalidate();
            } else {
                c.a.d.f.l.d.h().k(this.n0, 19, this.p0, 0, 0, this.o0, new Object[0]);
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
        c.a.d.f.l.d.h().d(this.n0, 19, this.p0);
        setBackgroundDrawable(null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            super.onDetachedFromWindow();
            c.a.o0.e1.n.a aVar = this.a;
            if (aVar != null) {
                aVar.d();
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

    @Override // c.a.d.h.a.h
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
        c.a.d.f.k.b<ImageView> bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048624, this, new Object[]{Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) || this.u == z2) {
            return;
        }
        this.u = z2;
        if (z3) {
            requestLayout();
        }
        if (this.u || (bVar = this.f30969c) == null) {
            return;
        }
        bVar.c();
    }

    public void setDuiEnabled(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048625, this, z2) == null) {
            this.l = z2;
        }
    }

    public void setHasMovementMethod(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048626, this, z2) == null) {
            this.H = z2;
        }
    }

    public void setIsFromCDN(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048627, this, z2) == null) {
            this.v = z2;
            c.a.o0.e1.n.a aVar = this.a;
            if (aVar != null) {
                aVar.r = z2;
            }
        }
    }

    public void setIsHost(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048628, this, z2) == null) {
            this.J = z2;
            GridImageLayout gridImageLayout = this.j;
            if (gridImageLayout != null) {
                gridImageLayout.setIsHost(z2);
            }
        }
    }

    public void setIsNeedResizeEmotion(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048629, this, z2) == null) {
            this.S = z2;
        }
    }

    public void setIsShowOrderOrDownloadBtn(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048630, this, z2) == null) {
            this.T = z2;
        }
    }

    public void setIsUseGridImage(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048631, this, z2) == null) {
            this.N = z2;
        }
    }

    public void setItemOrderOrDownloadListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048632, this, onClickListener) == null) {
            this.t = onClickListener;
        }
    }

    public void setLayoutStrategy(c.a.o0.e1.n.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048633, this, aVar) == null) || aVar == null) {
            return;
        }
        this.a.d();
        this.a = aVar;
        I();
        GridImageLayout gridImageLayout = this.j;
        if (gridImageLayout != null) {
            gridImageLayout.setLayoutStrategy(this.a);
        }
    }

    public void setLinkTextColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048634, this, i2) == null) {
            c.a.o0.e1.n.a aVar = this.a;
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
        if (interceptable == null || interceptable.invokeI(1048635, this, i2) == null) {
            this.G = i2;
            TextView textView = this.Q;
            if (textView != null) {
                textView.setMaxLines(i2);
            }
        }
    }

    public void setMaxWidth(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048636, this, i2) == null) {
            this.F = i2;
        }
    }

    public void setOnEmotionClickListener(x xVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048637, this, xVar) == null) {
            this.C = xVar;
        }
    }

    public void setOnImageClickListener(y yVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048638, this, yVar) == null) {
            this.o = yVar;
            GridImageLayout gridImageLayout = this.j;
            if (gridImageLayout != null) {
                gridImageLayout.setOnImageClickListener(yVar);
            }
        }
    }

    public void setOnImageTouchListener(c.a.p0.w2.j.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048639, this, cVar) == null) {
            this.p = cVar;
        }
    }

    public void setOnLinkImageClickListener(z zVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048640, this, zVar) == null) {
            this.q = zVar;
        }
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048641, this, onLongClickListener) == null) {
            this.W = onLongClickListener;
            super.setOnLongClickListener(onLongClickListener);
        }
    }

    public void setOnVoiceAfterClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048642, this, onClickListener) == null) {
            this.x = onClickListener;
        }
    }

    public void setSubPbPost(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048643, this, z2) == null) {
            this.I = z2;
            I();
        }
    }

    public void setText(TbRichText tbRichText) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048644, this, tbRichText) == null) {
            setText(tbRichText, false);
        }
    }

    public void setTextBold() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048648, this) == null) {
            this.a.f10150f = true;
        }
    }

    public void setTextCenter(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048649, this, z2) == null) {
            this.E = z2;
        }
    }

    public void setTextColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048650, this, i2) == null) {
            c.a.o0.e1.n.a aVar = this.a;
            if (i2 == aVar.i) {
                return;
            }
            aVar.i = i2;
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
        if (interceptable == null || interceptable.invokeL(1048651, this, truncateAt) == null) {
            this.m = truncateAt;
            TextView textView = this.Q;
            if (textView != null) {
                textView.setEllipsize(truncateAt);
            }
        }
    }

    public void setTextPadding(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048652, this, i2) == null) {
            c.a.o0.e1.n.a aVar = this.a;
            if (aVar.f10147c == i2) {
                return;
            }
            aVar.f10147c = i2;
            int childCount = getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                if (childAt != null && (childAt instanceof TextView)) {
                    int i4 = this.a.f10147c;
                    ((TextView) childAt).setPadding(i4, 0, 0, i4);
                }
            }
        }
    }

    public void setTextSize(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048653, this, f2) == null) {
            setFaceSize(f2);
            c.a.o0.e1.n.a aVar = this.a;
            if (f2 == aVar.f10149e) {
                return;
            }
            aVar.f10149e = f2;
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
        if (interceptable == null || interceptable.invokeZ(1048654, this, z2) == null) {
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
        if (interceptable == null || interceptable.invokeL(1048655, this, onClickListener) == null) {
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
        if (interceptable == null || interceptable.invokeL(1048656, this, onTouchListener) == null) {
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
        if (interceptable == null || interceptable.invokeL(1048657, this, str) == null) {
            this.U = str;
        }
    }

    public void setVoiceViewRes(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048658, this, i2) == null) {
            this.w = i2;
        }
    }

    public void setmGridEmptyClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048659, this, onClickListener) == null) {
            this.s = onClickListener;
        }
    }

    public void setmIsGridImageSupportLongPress(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048660, this, z2) == null) {
            this.O = z2;
        }
    }

    public void setText(TbRichText tbRichText, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048645, this, tbRichText, z2) == null) {
            setText(tbRichText, z2, null);
        }
    }

    public void setText(TbRichText tbRichText, boolean z2, s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048646, this, new Object[]{tbRichText, Boolean.valueOf(z2), sVar}) == null) {
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
        c.a.p0.w2.a<ImageView> aVar;
        boolean P;
        SpannableStringBuilder I;
        Iterator<TbRichTextData> it;
        TbRichTextData tbRichTextData;
        LinearLayout linearLayout;
        int i2;
        GifView gifView;
        TextView textView;
        int i3;
        c.a.d.f.k.b<TiebaPlusRecommendCard> bVar;
        ImageView imageView;
        View view;
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
        if (interceptable == null || interceptable.invokeCommon(1048647, this, new Object[]{tbRichText, Boolean.valueOf(z2), sVar, Boolean.valueOf(z3), Boolean.valueOf(z4)}) == null) {
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
                View view2 = null;
                View view3 = null;
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
                            TiePlusEventController.h(next.L());
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
                                    view2 = gridImageView;
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
                                view2 = view2;
                                if (P) {
                                    addView(view2);
                                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view2.getLayoutParams();
                                    if (!z10) {
                                    }
                                    if (!(view2 instanceof TbListTextView)) {
                                    }
                                    view3 = view2;
                                }
                                sVar2 = sVar;
                                it2 = it;
                                hVar = null;
                                z8 = true;
                            } else if (TbadkCoreApplication.getInst().isGifAutoPlay() && !next.E().G()) {
                                if (z4) {
                                    String B = next.E().B();
                                    if (StringUtils.isNull(B)) {
                                        c.a.o0.e1.n.a aVar2 = this.a;
                                        if (aVar2.F) {
                                            B = aVar2.r ? next.E().y() : next.E().z();
                                        }
                                        if (StringUtils.isNull(B)) {
                                            B = this.a.r ? next.E().A() : next.E().D();
                                        }
                                    }
                                    c.a.p0.w2.a<ImageView> aVar3 = this.f30968b;
                                    if (aVar3 != null) {
                                        Object obj3 = (ImageView) aVar3.h(B);
                                        if (obj3 instanceof GifView) {
                                            obj2 = (GifView) obj3;
                                            if (obj2 != null) {
                                                gifView3 = getGifView();
                                            } else {
                                                z7 = true;
                                                gifView2 = obj2;
                                                r rVar = new r(hVar);
                                                rVar.a = z8;
                                                gifView2.setTag(R.id.obfuscated_res_0x7f091ea0, rVar);
                                                P = O(next, gifView2, z7);
                                                textView = gifView2;
                                                if (z3) {
                                                    t tVar = new t(hVar);
                                                    tVar.a = z8;
                                                    gifView2.setTag(R.id.obfuscated_res_0x7f091ea1, tVar);
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
                                gifView2.setTag(R.id.obfuscated_res_0x7f091ea0, rVar2);
                                P = O(next, gifView2, z7);
                                textView = gifView2;
                                if (z3) {
                                }
                            } else {
                                if (z4) {
                                    String y2 = this.a.c() ? next.E().y() : next.E().A();
                                    c.a.p0.w2.a<ImageView> aVar4 = this.f30968b;
                                    Object obj4 = aVar4 != null ? (ImageView) aVar4.h(y2) : hVar;
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
                                c.a.o0.e1.n.a aVar5 = this.a;
                                ?? r10 = imageView2;
                                P = K(next, imageView2, aVar5.j, aVar5.k, z5);
                                if (z3) {
                                    t tVar2 = new t(hVar);
                                    tVar2.a = z8;
                                    r10.setTag(R.id.obfuscated_res_0x7f091ea1, tVar2);
                                }
                                linearLayout = r10;
                                it = it2;
                                tbRichTextData = next;
                                i2 = 8;
                                view2 = linearLayout;
                                if (P && view2 != null) {
                                    addView(view2);
                                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) view2.getLayoutParams();
                                    if (!z10 && (i3 = this.a.D) >= 0) {
                                        if (layoutParams2 != null) {
                                            layoutParams2.topMargin = i3;
                                            view2.setLayoutParams(layoutParams2);
                                        }
                                        z10 = false;
                                    } else if (!(view2 instanceof TbListTextView)) {
                                        if (!(view3 instanceof ImageView) && !(view3 instanceof RelativeLayout)) {
                                            layoutParams2.topMargin = this.a.f10148d;
                                        } else {
                                            layoutParams2.topMargin = this.a.z;
                                        }
                                        view2.setLayoutParams(layoutParams2);
                                    } else if ((!(view2 instanceof ImageView) && !(view2 instanceof RelativeLayout)) || (tbRichTextData.getType() != i2 && tbRichTextData.getType() != 20 && tbRichTextData.getType() != 17)) {
                                        if ((view2 instanceof ItemCardView) && !z10) {
                                            layoutParams2.topMargin = this.a.E;
                                            view2.setLayoutParams(layoutParams2);
                                        }
                                    } else {
                                        if (view3 instanceof TbListTextView) {
                                            layoutParams2.topMargin = this.a.u;
                                        } else if (!(view3 instanceof ImageView) && !(view2 instanceof RelativeLayout)) {
                                            layoutParams2.topMargin = this.a.f10148d;
                                        } else {
                                            layoutParams2.topMargin = this.a.t;
                                        }
                                        view2.setLayoutParams(layoutParams2);
                                    }
                                    view3 = view2;
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
                            view2 = linearLayout;
                            if (P) {
                            }
                            sVar2 = sVar;
                            it2 = it;
                            hVar = null;
                            z8 = true;
                        } else {
                            tbRichTextData = next;
                            if (tbRichTextData.getType() == 512) {
                                view2 = F(view3);
                                if (view2 != null) {
                                    P = R(tbRichTextData, view2);
                                    gifView = view2;
                                    it = it2;
                                    linearLayout = gifView;
                                    i2 = 8;
                                    view2 = linearLayout;
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
                                            P = M(tbRichTextData, imageView3, (this.a.j - getPaddingLeft()) - getPaddingRight(), this.a.k);
                                            imageView = imageView3;
                                        } else if (tbRichTextData.getType() != 37 && tbRichTextData.getType() != 1281) {
                                            if (tbRichTextData.getType() != 36 || tbRichTextData.M() == null || tbRichTextData.M().B() == null || (bVar = this.i) == null) {
                                                P = false;
                                                view2 = view2;
                                            } else {
                                                TiebaPlusRecommendCard b2 = bVar.b();
                                                b2.w(tbRichTextData.M());
                                                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) b2.getLayoutParams();
                                                c.a.o0.e1.n.a aVar6 = this.a;
                                                marginLayoutParams.setMargins(0, aVar6.w, 0, aVar6.x);
                                                b2.setLayoutParams(marginLayoutParams);
                                                P = true;
                                                view2 = b2;
                                            }
                                        } else {
                                            ItemCardView itemCardView = getItemCardView();
                                            P = L(itemCardView, tbRichTextData);
                                            view2 = itemCardView;
                                        }
                                    } else if (i5 < 10) {
                                        int i6 = i5 + 1;
                                        boolean z11 = (tbRichTextData == null || tbRichTextData.H() == null || tbRichTextData.H().memeInfo == null || StringUtils.isNull(tbRichTextData.H().memeInfo.pic_url)) ? false : true;
                                        if (z11) {
                                            RelativeLayout b3 = this.f30973g.b();
                                            b3.removeAllViews();
                                            b3.setLayoutParams(new LinearLayout.LayoutParams(tbRichTextData.H().memeInfo.width.intValue(), tbRichTextData.H().memeInfo.height.intValue()));
                                            if (DuiSwitch.getInOn() && this.l) {
                                                int intValue = tbRichTextData.H().memeInfo.width.intValue();
                                                int intValue2 = tbRichTextData.H().memeInfo.height.intValue();
                                                c.a.o0.e1.n.a aVar7 = this.a;
                                                c0(b3, intValue, intValue2, aVar7.j, aVar7.k);
                                            } else {
                                                int intValue3 = tbRichTextData.H().memeInfo.width.intValue();
                                                int intValue4 = tbRichTextData.H().memeInfo.height.intValue();
                                                c.a.o0.e1.n.a aVar8 = this.a;
                                                b0(b3, intValue3, intValue4, aVar8.j, aVar8.k);
                                            }
                                            ImageView b4 = this.f30969c.b();
                                            c.a.o0.e1.n.a aVar9 = this.a;
                                            N(tbRichTextData, b4, aVar9.j, aVar9.k);
                                            if (DuiSwitch.getInOn() && this.l) {
                                                ImageView b5 = this.f30969c.b();
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
                                                int f2 = c.a.d.f.p.n.f(getContext(), R.dimen.obfuscated_res_0x7f0702f9);
                                                int f3 = c.a.d.f.p.n.f(getContext(), R.dimen.obfuscated_res_0x7f0702f9);
                                                b4.setId(R.id.obfuscated_res_0x7f0913e8);
                                                int intValue5 = tbRichTextData.H().memeInfo.width.intValue();
                                                int intValue6 = tbRichTextData.H().memeInfo.height.intValue();
                                                c.a.o0.e1.n.a aVar10 = this.a;
                                                it = it2;
                                                relativeLayout = b3;
                                                d0(b4, intValue5, intValue6, aVar10.j, aVar10.k, this.h0);
                                                relativeLayout.addView(b4);
                                                if (f3 > tbRichTextData.H().memeInfo.height.intValue()) {
                                                    f2 /= 2;
                                                    i4 = f3 / 2;
                                                } else {
                                                    i4 = f3;
                                                }
                                                RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(f2, i4);
                                                i2 = 8;
                                                layoutParams3.addRule(8, R.id.obfuscated_res_0x7f0913e8);
                                                layoutParams3.addRule(11);
                                                b5.setOnClickListener(this.h0);
                                                if (relativeLayout.getLeft() > 0) {
                                                    layoutParams3.rightMargin = c.a.d.f.p.n.f(getContext(), R.dimen.obfuscated_res_0x7f0702df);
                                                }
                                                SkinManager.setImageResource(b5, R.drawable.icon_emotion_dui_n);
                                                relativeLayout.addView(b5, layoutParams3);
                                            } else {
                                                it = it2;
                                                i2 = 8;
                                                relativeLayout = b3;
                                                int intValue7 = tbRichTextData.H().memeInfo.width.intValue();
                                                int intValue8 = tbRichTextData.H().memeInfo.height.intValue();
                                                c.a.o0.e1.n.a aVar11 = this.a;
                                                f0(b4, intValue7, intValue8, aVar11.j, aVar11.k, this.h0);
                                                relativeLayout.addView(b4);
                                            }
                                            view = relativeLayout;
                                        } else {
                                            it = it2;
                                            i2 = 8;
                                            view = view2;
                                        }
                                        i5 = i6;
                                        P = z11;
                                        imageView = view;
                                    }
                                    view2 = imageView;
                                }
                                it = it2;
                                linearLayout = gifView;
                                i2 = 8;
                                view2 = linearLayout;
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
                        view2 = linearLayout;
                        if (P) {
                        }
                        sVar2 = sVar;
                        it2 = it;
                        hVar = null;
                        z8 = true;
                    }
                }
                if (view3 instanceof TbListTextView) {
                    LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) view3.getLayoutParams();
                    layoutParams4.bottomMargin = this.a.C;
                    view3.setLayoutParams(layoutParams4);
                } else if (view3 != null && this.a.B >= 0) {
                    LinearLayout.LayoutParams layoutParams5 = (LinearLayout.LayoutParams) view3.getLayoutParams();
                    layoutParams5.bottomMargin = this.a.B;
                    view3.setLayoutParams(layoutParams5);
                }
                if (z3 || (aVar = this.f30968b) == null) {
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
        this.a = new c.a.o0.e1.n.a();
        this.f30968b = null;
        this.f30969c = null;
        this.f30970d = null;
        this.f30971e = null;
        this.f30972f = null;
        this.f30973g = null;
        this.f30974h = null;
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
        this.i0 = new c.a.p0.w2.j.c(new j(this));
        this.j0 = new k(this);
        this.k0 = new c(this);
        this.p0 = new d(this);
        this.q0 = new e(this, 2004018);
        H();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.obfuscated_res_0x7f0401a6, R.attr.obfuscated_res_0x7f040202, R.attr.obfuscated_res_0x7f040203, R.attr.obfuscated_res_0x7f0403a7, R.attr.obfuscated_res_0x7f04041d, R.attr.obfuscated_res_0x7f04041f, R.attr.obfuscated_res_0x7f04053c, R.attr.obfuscated_res_0x7f04055f, R.attr.obfuscated_res_0x7f0405d4, R.attr.obfuscated_res_0x7f040611, R.attr.obfuscated_res_0x7f04061d, R.attr.obfuscated_res_0x7f04061e, R.attr.obfuscated_res_0x7f040685});
        this.a.b(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        I();
    }
}
