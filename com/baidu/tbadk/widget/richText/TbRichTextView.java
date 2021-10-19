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
import c.a.q0.s.q.d2;
import c.a.r0.k2.i.c;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
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
import com.baidu.tbadk.core.view.itemcard.ItemCardHelper;
import com.baidu.tbadk.gif.GifInfo;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tbadk.switchs.DuiSwitch;
import com.baidu.tbadk.widget.ForeDrawableImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.TbListTextView;
import com.baidu.tbadk.widget.layout.GridImageLayout;
import com.baidu.tbadk.widget.tiejia.TiePlusEventController;
import com.baidu.tbadk.widget.tiejia.TiebaPlusRecommendCard;
import com.baidu.tieba.R;
import com.baidu.tieba.R$styleable;
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
/* loaded from: classes6.dex */
public class TbRichTextView extends LinearLayout implements c.a.e.f.a.h {
    public static /* synthetic */ Interceptable $ic;
    public static final float s0;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public View.OnClickListener B;
    public boolean C;
    public boolean D;
    public Runnable E;
    public boolean F;
    public y G;
    public TbRichText H;
    public boolean I;
    public int J;
    public int K;
    public boolean L;
    public boolean M;
    public boolean N;
    public boolean O;
    public boolean P;
    public boolean Q;
    public boolean R;
    public boolean S;
    public int T;
    public TextView U;
    public boolean V;
    public boolean W;
    public String a0;
    public c.a.q0.f1.m.f b0;
    public View.OnLongClickListener c0;

    /* renamed from: e  reason: collision with root package name */
    public c.a.q0.f1.m.a f48919e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.r0.k2.a<ImageView> f48920f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.e.e.k.b<ImageView> f48921g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.e.e.k.b<TextView> f48922h;
    public boolean hasShadow;

    /* renamed from: i  reason: collision with root package name */
    public c.a.e.e.k.b<View> f48923i;
    public w i0;

    /* renamed from: j  reason: collision with root package name */
    public c.a.e.e.k.b<LinearLayout> f48924j;
    public final View.OnClickListener j0;
    public c.a.e.e.k.b<RelativeLayout> k;
    public final c.a.r0.k2.i.c k0;
    public c.a.e.e.k.b<GifView> l;
    public final x l0;
    public c.a.e.e.k.b<TiebaPlusRecommendCard> m;
    public boolean m0;
    public final View.OnClickListener mOnClickListenerForLinkImage;
    public GridImageLayout n;
    public Drawable n0;
    public c.a.e.e.k.b<ItemCardView> o;
    public String o0;
    public boolean p;
    public BdUniqueId p0;
    public TextUtils.TruncateAt q;
    public final c.a.e.e.l.c<c.a.e.l.d.a> q0;
    public b0 r;
    public CustomMessageListener r0;
    public z s;
    public c.a.r0.k2.i.c t;
    public a0 u;
    public View.OnClickListener v;
    public View.OnClickListener w;
    public View.OnClickListener x;
    public boolean y;
    public boolean z;

    /* loaded from: classes6.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TbRichTextView f48925e;

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
            this.f48925e = tbRichTextView;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f48925e.a0();
                this.f48925e.U.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface a0 {
        void a(View view, String str);
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TbRichTextData f48926e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ TbRichTextView f48927f;

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
            this.f48927f = tbRichTextView;
            this.f48926e = tbRichTextData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f48927f.G == null) {
                return;
            }
            TbRichTextEmotionInfo z = this.f48926e.z();
            y yVar = this.f48927f.G;
            GifInfo gifInfo = z.mGifInfo;
            yVar.a(view, gifInfo.mGid, gifInfo.mPackageName, gifInfo.mIcon, gifInfo.mStaticUrl, gifInfo.mDynamicUrl, gifInfo.mSharpText, gifInfo.mGifWidth, gifInfo.mGifHeight);
        }
    }

    /* loaded from: classes6.dex */
    public static class b0 implements AbsListView.RecyclerListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public int f48928e;

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
            this.f48928e = 0;
            this.f48928e = i2;
        }

        @Override // android.widget.AbsListView.RecyclerListener
        public void onMovedToScrapHeap(View view) {
            View findViewById;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && (findViewById = view.findViewById(this.f48928e)) != null && (findViewById instanceof TbRichTextView)) {
                ((TbRichTextView) findViewById).setText(null);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TbRichTextData f48929e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ItemCardView f48930f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ TbRichTextView f48931g;

        public c(TbRichTextView tbRichTextView, TbRichTextData tbRichTextData, ItemCardView itemCardView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbRichTextView, tbRichTextData, itemCardView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48931g = tbRichTextView;
            this.f48929e = tbRichTextData;
            this.f48930f = itemCardView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f48929e.getType() == 37) {
                    TiebaStatic.log(new StatisticItem("common_click").param("page_type", "a005").param(TiebaStatic.Params.GUA_TYPE, 4).param("obj_locate", 16));
                    ItemCardHelper.q(this.f48930f.getPosition(), this.f48929e.D().a().itemId, this.f48930f.getButtonType(), this.f48931g.a0, c.a.q0.s.f0.p.c.a(this.f48929e.D().a().buttonLinkType.intValue(), this.f48929e.D().a().apkDetail != null ? this.f48929e.D().a().apkDetail.pkg_source.intValue() : 0), "", 2);
                    ItemClickJumpUtil.itemClickJump(this.f48929e.D().a().forumName, String.valueOf(this.f48929e.D().a().itemId), 3, 3);
                } else if (this.f48929e.getType() == 1281) {
                    TiebaStatic.log(new StatisticItem("common_click").param("page_type", "a005").param(TiebaStatic.Params.GUA_TYPE, 2).param("obj_locate", 16));
                    ItemCardHelper.q(this.f48930f.getPosition(), this.f48929e.A().getItem().item_id.longValue(), this.f48930f.getButtonType(), this.f48931g.a0, c.a.q0.s.f0.p.c.a(this.f48929e.A().getItem().button_link_type.intValue(), this.f48929e.A().getItem().apk_detail != null ? this.f48929e.A().getItem().apk_detail.pkg_source.intValue() : 0), "", 2);
                    ItemClickJumpUtil.itemClickJump(this.f48929e.A().getItemForumName(), this.f48929e.A().getItemID(), 3, 3);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements x {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbRichTextView f48932a;

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
            this.f48932a = tbRichTextView;
        }

        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.x
        public void dispatchTouchEvent(MotionEvent motionEvent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, motionEvent) == null) {
                if (motionEvent.getAction() == 0) {
                    this.f48932a.Q = true;
                } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                    this.f48932a.Q = false;
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e extends c.a.e.e.l.c<c.a.e.l.d.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbRichTextView f48933a;

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
            this.f48933a = tbRichTextView;
        }

        @Override // c.a.e.e.l.c
        public void onCancelled(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                super.onCancelled(str);
            }
        }

        @Override // c.a.e.e.l.c
        public void onProgressUpdate(Object... objArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, objArr) == null) {
                super.onProgressUpdate(objArr);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.e.e.l.c
        public void onLoaded(c.a.e.l.d.a aVar, String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, str, i2) == null) {
                this.f48933a.B(aVar);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbRichTextView f48934a;

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
            this.f48934a = tbRichTextView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int contentSize;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                if (this.f48934a.M) {
                    contentSize = TbConfig.getOutterSubpbContentSize();
                } else {
                    contentSize = TbConfig.getContentSize();
                }
                if (this.f48934a.H != null && !ListUtils.isEmpty(this.f48934a.H.y())) {
                    Iterator<TbRichTextData> it = this.f48934a.H.y().iterator();
                    while (it.hasNext()) {
                        TbRichTextData next = it.next();
                        if (next != null) {
                            next.Q(contentSize, contentSize);
                        }
                    }
                }
                this.f48934a.setTextSize(contentSize);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g implements c.a.e.e.k.c<ImageView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbRichTextView f48935a;

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
            this.f48935a = tbRichTextView;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // c.a.e.e.k.c
        public /* bridge */ /* synthetic */ ImageView a(ImageView imageView) {
            ImageView imageView2 = imageView;
            e(imageView2);
            return imageView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // c.a.e.e.k.c
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
                    if (c.a.q0.s.k.c().g()) {
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
        @Override // c.a.e.e.k.c
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.e.e.k.c
        /* renamed from: g */
        public ImageView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(c.a.e.a.j.a(this.f48935a.getContext()).getPageActivity());
                boolean g2 = c.a.q0.s.k.c().g();
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

    /* loaded from: classes6.dex */
    public class h extends c.a.r0.k2.a<ImageView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TbRichTextView f48936e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(TbRichTextView tbRichTextView, c.a.e.e.k.c cVar, int i2, int i3) {
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
                    super((c.a.e.e.k.c) objArr2[0], ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48936e = tbRichTextView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.r0.k2.a
        /* renamed from: i */
        public ImageView h(Object obj) {
            InterceptResult invokeL;
            ImageView imageView;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
                if (obj instanceof String) {
                    Iterator it = this.f2374c.iterator();
                    while (it.hasNext()) {
                        imageView = (ImageView) it.next();
                        if ((imageView instanceof TbImageView) && obj.equals(((TbImageView) imageView).getUrl())) {
                            break;
                        }
                    }
                }
                imageView = null;
                this.f2374c.remove(imageView);
                return imageView;
            }
            return (ImageView) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class i extends c.a.q0.f1.m.f {
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

        @Override // c.a.q0.f1.m.f, android.text.style.ClickableSpan
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.l.setAddExpandableListener(false);
                this.l.setTextEllipsize(TextUtils.TruncateAt.END);
                this.l.setMaxLines(5);
                this.l.setAddTruncateListener(true);
                this.l.H.isChanged = true;
                TbRichTextView tbRichTextView = this.l;
                tbRichTextView.setText(tbRichTextView.H);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class j implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TbRichTextView f48937e;

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
            this.f48937e = tbRichTextView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MemeInfo memeInfo;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && this.f48937e.s != null && (view instanceof ImageView)) {
                String str = null;
                Object tag = view.getTag();
                int i2 = 0;
                int i3 = -1;
                if (tag != null && (tag instanceof TbRichText)) {
                    int childCount = this.f48937e.getChildCount();
                    while (i2 < childCount) {
                        i3++;
                        if (view.getParent() == this.f48937e.getChildAt(i2)) {
                            break;
                        }
                        i2++;
                    }
                    this.f48937e.s.a(view, null, i3, this.f48937e.N, false);
                    return;
                }
                if (tag != null && (tag instanceof String)) {
                    str = (String) tag;
                } else {
                    boolean z = view instanceof TbImageView;
                    if (z && (view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextMemeInfo)) {
                        TbRichTextMemeInfo tbRichTextMemeInfo = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                        String str2 = (tbRichTextMemeInfo == null || (memeInfo = tbRichTextMemeInfo.memeInfo) == null) ? "" : memeInfo.pic_url;
                        int childCount2 = this.f48937e.getChildCount();
                        while (i2 < childCount2) {
                            i3++;
                            if (view.getParent() == this.f48937e.getChildAt(i2)) {
                                break;
                            }
                            i2++;
                        }
                        this.f48937e.s.a(view, str2, i3, this.f48937e.N, false);
                        return;
                    } else if (z) {
                        str = ((TbImageView) view).getUrl();
                    } else if (view instanceof GifView) {
                        str = ((GifView) view).getUrl();
                    }
                }
                String str3 = str;
                int childCount3 = this.f48937e.getChildCount();
                while (i2 < childCount3) {
                    View childAt = this.f48937e.getChildAt(i2);
                    if (this.f48937e.S(childAt)) {
                        i3++;
                    }
                    if (view == childAt) {
                        break;
                    }
                    i2++;
                }
                this.f48937e.s.a(view, str3, i3, this.f48937e.N, false);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class k implements c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbRichTextView f48938a;

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
            this.f48938a = tbRichTextView;
        }

        @Override // c.a.r0.k2.i.c.a
        public boolean a(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                return false;
            }
            return invokeLL.booleanValue;
        }

        @Override // c.a.r0.k2.i.c.a
        public boolean b(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, motionEvent)) == null) {
                if (this.f48938a.j0 != null) {
                    this.f48938a.j0.onClick(view);
                    return true;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }

        @Override // c.a.r0.k2.i.c.a
        public boolean c(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view, motionEvent)) == null) {
                if (this.f48938a.t != null) {
                    this.f48938a.t.a(view);
                    return this.f48938a.t.onDoubleTap(motionEvent);
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class l implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TbRichTextView f48939e;

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
            this.f48939e = tbRichTextView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && this.f48939e.u != null && (view instanceof TbImageView)) {
                String str = null;
                Object tag = view.getTag();
                if (tag != null && (tag instanceof v)) {
                    str = ((v) tag).f48950a;
                }
                this.f48939e.u.a(view, str);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class m implements c.a.e.e.k.c<TextView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f48940a;

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
            this.f48940a = context;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // c.a.e.e.k.c
        public /* bridge */ /* synthetic */ TextView a(TextView textView) {
            TextView textView2 = textView;
            e(textView2);
            return textView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // c.a.e.e.k.c
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
        @Override // c.a.e.e.k.c
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
        @Override // c.a.e.e.k.c
        /* renamed from: g */
        public TextView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? new TbListTextView(this.f48940a) : (TextView) invokeV.objValue;
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

    /* loaded from: classes6.dex */
    public class n implements ViewGroup.OnHierarchyChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TbRichTextView f48941e;

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
            this.f48941e = tbRichTextView;
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
                    if (!(tag instanceof u) || !((u) tag).f48949a) {
                        if (this.f48941e.l != null) {
                            this.f48941e.l.e((GifView) view2);
                        }
                    } else {
                        if (this.f48941e.f48920f == null) {
                            TbRichTextView tbRichTextView = this.f48941e;
                            tbRichTextView.f48920f = tbRichTextView.getRecycleImageViewPool();
                        }
                        this.f48941e.f48920f.e((ImageView) view2);
                    }
                } else if (view2 instanceof ImageView) {
                    Object tag2 = view2.getTag(R.id.tag_rich_text_view_recycle);
                    if (!(tag2 instanceof u) || !((u) tag2).f48949a) {
                        if (this.f48941e.f48921g != null) {
                            this.f48941e.f48921g.e((ImageView) view2);
                        }
                    } else {
                        if (this.f48941e.f48920f == null) {
                            TbRichTextView tbRichTextView2 = this.f48941e;
                            tbRichTextView2.f48920f = tbRichTextView2.getRecycleImageViewPool();
                        }
                        this.f48941e.f48920f.e((ImageView) view2);
                    }
                } else if ((view2 instanceof TextView) && this.f48941e.f48922h != null) {
                    this.f48941e.f48922h.e((TextView) view2);
                } else if ((view2 instanceof PlayVoiceBnt) && this.f48941e.f48923i != null) {
                    this.f48941e.f48923i.e(view2);
                } else if ((view2 instanceof PlayVoiceBntNew) && this.f48941e.f48923i != null) {
                    this.f48941e.f48923i.e(view2);
                } else if (view2 instanceof GridImageLayout) {
                    GridImageLayout gridImageLayout = (GridImageLayout) view2;
                    int childCount = gridImageLayout.getChildCount();
                    for (int i2 = 0; i2 < childCount; i2++) {
                        View childAt = gridImageLayout.getChildAt(i2);
                        if ((childAt instanceof GifView) && this.f48941e.l != null) {
                            this.f48941e.l.e((GifView) childAt);
                        } else if ((childAt instanceof ImageView) && this.f48941e.f48921g != null) {
                            this.f48941e.f48921g.e((ImageView) childAt);
                        }
                    }
                    gridImageLayout.removeAllViews();
                    gridImageLayout.clearData();
                } else if ((view2 instanceof TiebaPlusRecommendCard) && this.f48941e.m != null) {
                    this.f48941e.m.e((TiebaPlusRecommendCard) view2);
                } else if ((view2 instanceof RelativeLayout) && this.f48941e.k != null) {
                    this.f48941e.k.e((RelativeLayout) view2);
                } else if ((view2 instanceof ItemCardView) && this.f48941e.o != null) {
                    this.f48941e.o.e((ItemCardView) view2);
                }
                if (!(view2 instanceof LinearLayout) || (view2 instanceof ItemCardView)) {
                    return;
                }
                Object tag3 = view2.getTag();
                if (tag3 == null || !(tag3 instanceof String) || !"VideoView".equals(tag3)) {
                    if (this.f48941e.f48924j != null) {
                        LinearLayout linearLayout = (LinearLayout) view2;
                        int childCount2 = linearLayout.getChildCount();
                        for (int i3 = 0; i3 < childCount2; i3++) {
                            View childAt2 = linearLayout.getChildAt(i3);
                            if (childAt2 != null) {
                                if ((childAt2 instanceof TextView) && this.f48941e.f48922h != null) {
                                    this.f48941e.f48922h.e((TextView) childAt2);
                                } else if ((childAt2 instanceof PlayVoiceBnt) && this.f48941e.f48923i != null) {
                                    this.f48941e.f48923i.e(childAt2);
                                } else if ((childAt2 instanceof PlayVoiceBntNew) && this.f48941e.f48923i != null) {
                                    this.f48941e.f48923i.e(childAt2);
                                }
                            }
                        }
                        linearLayout.removeAllViews();
                        this.f48941e.f48924j.e(linearLayout);
                        return;
                    }
                    return;
                }
                view2.setBackgroundDrawable(null);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class o implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.f1.m.j f48942e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ TbRichTextView f48943f;

        public o(TbRichTextView tbRichTextView, c.a.q0.f1.m.j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbRichTextView, jVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48943f = tbRichTextView;
            this.f48942e = jVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                TiebaStatic.log(TbadkCoreStatisticKey.KEY_RICH_TEXT_VIDEO_CLICK);
                XiaoyingUtil.startPlayXiaoyingVideo(this.f48943f.getContext(), this.f48942e.g(), this.f48942e.h(), this.f48942e.d(), this.f48942e.f());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class p implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TbRichTextData f48944e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ TbRichTextView f48945f;

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
            this.f48945f = tbRichTextView;
            this.f48944e = tbRichTextData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f48944e.G() == null) {
                return;
            }
            if (this.f48945f.getContext() instanceof c.a.q0.f1.m.i) {
                ((c.a.q0.f1.m.i) this.f48945f.getContext()).onVideoClicked(this.f48945f.getContext(), this.f48944e.G().toString());
                return;
            }
            c.a.e.a.f<?> a2 = c.a.e.a.j.a(this.f48945f.getContext());
            if (a2 == null || !(a2.getOrignalPage() instanceof c.a.q0.f1.m.i)) {
                return;
            }
            ((c.a.q0.f1.m.i) a2.getOrignalPage()).onVideoClicked(this.f48945f.getContext(), this.f48944e.G().toString());
        }
    }

    /* loaded from: classes6.dex */
    public class q implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TbRichTextView f48946e;

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
            this.f48946e = tbRichTextView;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f48946e.d0();
                this.f48946e.U.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class r implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TbRichTextView f48947e;

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
            this.f48947e = tbRichTextView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && !this.f48947e.Q && this.f48947e.performLongClick()) {
                this.f48947e.D = true;
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class s {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f48948a;

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

    /* loaded from: classes6.dex */
    public interface t {
        void decorateText(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView);
    }

    /* loaded from: classes6.dex */
    public static class u {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f48949a;

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

    /* loaded from: classes6.dex */
    public static class v {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f48950a;

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
            this.f48950a = str;
        }
    }

    /* loaded from: classes6.dex */
    public interface w {
        void a();
    }

    /* loaded from: classes6.dex */
    public interface x {
        void dispatchTouchEvent(MotionEvent motionEvent);
    }

    /* loaded from: classes6.dex */
    public interface y {
        void a(View view, String str, String str2, String str3, String str4, String str5, String str6, int i2, int i3);
    }

    /* loaded from: classes6.dex */
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
        s0 = c.a.e.e.p.l.h(TbadkCoreApplication.getInst());
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
        this.f48919e = new c.a.q0.f1.m.a();
        this.f48920f = null;
        this.f48921g = null;
        this.f48922h = null;
        this.f48923i = null;
        this.f48924j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.o = null;
        this.p = true;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = null;
        this.v = null;
        this.w = null;
        this.x = null;
        this.y = true;
        this.z = true;
        this.A = -1;
        this.C = false;
        this.D = false;
        this.E = null;
        this.F = false;
        this.I = false;
        this.J = -1;
        this.K = -1;
        this.L = true;
        this.M = false;
        this.N = false;
        this.O = false;
        this.P = false;
        this.Q = false;
        this.R = false;
        this.S = false;
        this.hasShadow = false;
        this.V = false;
        this.W = false;
        this.b0 = new i(this, 2, null);
        this.j0 = new j(this);
        this.k0 = new c.a.r0.k2.i.c(new k(this));
        this.mOnClickListenerForLinkImage = new l(this);
        this.l0 = new d(this);
        this.q0 = new e(this);
        this.r0 = new f(this, 2004018);
        H();
    }

    public static c.a.e.e.k.b<TextView> createTextViewPool(Context context, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65543, null, context, i2)) == null) ? new c.a.e.e.k.b<>(new m(context), i2, 0) : (c.a.e.e.k.b) invokeLI.objValue;
    }

    private GifView getGifView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, this)) == null) {
            c.a.e.e.k.b<GifView> bVar = this.l;
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
            b2.setRadius(this.T);
            if (this.R) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, this)) == null) {
            GridImageLayout gridImageLayout = this.n;
            if (gridImageLayout == null || gridImageLayout.getParent() != null) {
                this.n = new GridImageLayout(getContext());
                this.n.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            }
            this.n.setLayoutStrategy(this.f48919e);
            this.n.setObjectPool(this.f48921g, this.l);
            this.n.setOnImageClickListener(this.s);
            View.OnClickListener onClickListener = this.w;
            if (onClickListener != null) {
                this.n.setOnClickListener(onClickListener);
            }
            this.n.setIsHost(this.N);
            if (this.S) {
                this.n.setOnLongClickListener(this.c0);
            }
            return this.n;
        }
        return (GridImageLayout) invokeV.objValue;
    }

    private ItemCardView getItemCardView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, this)) == null) {
            c.a.e.e.k.b<ItemCardView> bVar = this.o;
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
        if (interceptable == null || (invokeV = interceptable.invokeV(65551, this)) == null) {
            LinearLayout b2 = this.f48924j.b();
            if (b2 != null) {
                TextView D = D(getContext());
                if (D == null) {
                    this.f48924j.e(b2);
                    return null;
                }
                b2.addView(D);
                View F = F(null);
                if (F == null) {
                    this.f48922h.e(D);
                    this.f48924j.e(b2);
                    return null;
                }
                b2.addView(F);
            }
            return b2;
        }
        return (View) invokeV.objValue;
    }

    public static TbRichText parse(Context context, JSONArray jSONArray, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLI = interceptable.invokeLLI(65561, null, context, jSONArray, i2)) == null) ? new TbRichText(context, jSONArray, i2) : (TbRichText) invokeLLI.objValue;
    }

    public static TbRichText parser(Context context, List<PbContent> list, boolean z2) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65565, null, context, list, z2)) == null) ? new TbRichText(context, list, null, z2) : (TbRichText) invokeLLZ.objValue;
    }

    private void setFaceSize(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(65570, this, f2) == null) {
            if (this.V && c.a.q0.b.d.R()) {
                int emotionContentSizeOfLzl = this.M ? TbConfig.getEmotionContentSizeOfLzl() : TbConfig.getEmotionContentSize();
                c.a.q0.f1.m.a aVar = this.f48919e;
                aVar.f13252g = emotionContentSizeOfLzl;
                aVar.f13253h = emotionContentSizeOfLzl;
                return;
            }
            c.a.q0.f1.m.a aVar2 = this.f48919e;
            int i2 = (int) f2;
            aVar2.f13252g = i2;
            aVar2.f13253h = i2;
        }
    }

    public final void B(c.a.e.l.d.a aVar) {
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
            w wVar = this.i0;
            if (wVar != null) {
                wVar.a();
            }
        } catch (Exception unused) {
        }
    }

    public final ImageView C(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            c.a.e.e.k.b<ImageView> bVar = this.f48921g;
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

    public final TextView D(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context)) == null) {
            c.a.e.e.k.b<TextView> bVar = this.f48922h;
            TextView b2 = bVar != null ? bVar.b() : null;
            if (b2 == null || b2.getParent() != null) {
                b2 = new TbListTextView(context);
            }
            int i2 = this.f48919e.f13248c;
            b2.setPadding(i2, 0, i2, 0);
            return b2;
        }
        return (TextView) invokeL.objValue;
    }

    public final LinearLayout E(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, tbRichTextData)) == null) {
            if (this.f48919e.m <= 0 || tbRichTextData == null) {
                return null;
            }
            LinearLayout linearLayout = new LinearLayout(getContext());
            linearLayout.setTag("VideoView");
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.topMargin = this.f48919e.f13249d;
            linearLayout.setClickable(true);
            Bitmap bitmap = SkinManager.getBitmap(this.f48919e.m);
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

    public final View F(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, view)) == null) {
            c.a.e.e.k.b<View> bVar = this.f48923i;
            View b2 = bVar != null ? bVar.b() : null;
            if ((b2 == null || b2.getParent() != null) && this.A != -1) {
                b2 = LayoutInflater.from(getContext()).inflate(this.A, (ViewGroup) null);
            }
            if (b2 != null) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                if (view instanceof TbListTextView) {
                    layoutParams.topMargin = this.f48919e.v;
                } else {
                    layoutParams.topMargin = this.f48919e.f13249d;
                }
                layoutParams.bottomMargin = this.f48919e.A;
                b2.setLayoutParams(layoutParams);
                if (b2 instanceof PlayVoiceBntNew) {
                    ((PlayVoiceBntNew) b2).setAfterClickListener(this.B);
                }
                return b2;
            }
            return null;
        }
        return (View) invokeL.objValue;
    }

    public final View G(c.a.q0.f1.m.j jVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, jVar)) == null) {
            if (jVar == null || !jVar.i()) {
                return null;
            }
            ImageView b2 = this.f48921g.b();
            if (b2 instanceof ForeDrawableImageView) {
                ForeDrawableImageView foreDrawableImageView = (ForeDrawableImageView) b2;
                foreDrawableImageView.setForegroundDrawable(R.drawable.icon_play_video);
                foreDrawableImageView.setNoImageBottomTextColor(R.color.CAM_X0108);
                foreDrawableImageView.setNoImageBottomTextPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds32));
                foreDrawableImageView.setNoImageBottomTextSize(TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.fontsize28));
                foreDrawableImageView.setNoImageBottomText("点击播放视频");
                foreDrawableImageView.setInterceptOnClick(false);
                foreDrawableImageView.setTag("VideoView");
                Z(foreDrawableImageView, jVar.h(), jVar.d(), (this.f48919e.f13255j - getPaddingLeft()) - getPaddingRight(), this.f48919e.k, new o(this, jVar));
                foreDrawableImageView.setDefaultResource(0);
                foreDrawableImageView.setSupportNoImage(this.f48919e.q);
                if (c.a.q0.s.k.c().g()) {
                    foreDrawableImageView.setDefaultBgResource(R.drawable.pic_bg_video_frs);
                } else {
                    foreDrawableImageView.setDefaultBgResource(R.color.CAM_X0204);
                }
                foreDrawableImageView.startLoad(jVar.f(), 17, false);
            }
            return b2;
        }
        return (View) invokeL.objValue;
    }

    public final void H() {
        c.a.q0.f1.m.i iVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            c.a.e.a.f<?> a2 = c.a.e.a.j.a(getContext());
            if (getContext() instanceof c.a.q0.f1.m.i) {
                iVar = (c.a.q0.f1.m.i) getContext();
            } else {
                iVar = (a2 == null || !(a2.getOrignalPage() instanceof c.a.q0.f1.m.i)) ? null : (c.a.q0.f1.m.i) a2.getOrignalPage();
            }
            if (iVar == null && (getContext() instanceof BaseFragmentActivity)) {
                List<Fragment> fragments = ((BaseFragmentActivity) getContext()).getSupportFragmentManager().getFragments();
                if (!ListUtils.isEmpty(fragments) && (fragments.get(0) instanceof c.a.q0.f1.m.i)) {
                    iVar = (c.a.q0.f1.m.i) fragments.get(0);
                }
            }
            if (a2 != null) {
                a2.registerListener(this.r0);
            }
            if (iVar != null) {
                this.f48921g = iVar.getImageViewPool();
                this.f48922h = iVar.getTextViewPool();
                this.f48923i = iVar.getVoiceViewPool();
                this.f48924j = iVar.getTextVoiceViewPool();
                this.l = iVar.getGifViewPool();
                this.m = iVar.getTiejiaRecommendPool();
                this.k = iVar.getRelativeLayoutPool();
                this.o = iVar.getItemCardViewPool();
                if (iVar.getListView() != null && this.r == null) {
                    this.r = new b0(iVar.getRichTextViewId());
                    iVar.getListView().setRecyclerListener(this.r);
                }
            }
            this.T = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds21);
            setOrientation(1);
            setOnHierarchyChangeListener(new n(this));
        }
    }

    public final void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            setFaceSize(this.M ? TbConfig.getContentSizeOfLzl() : TbConfig.getContentSize());
        }
    }

    public final boolean J(TbRichTextData tbRichTextData, GifView gifView) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, tbRichTextData, gifView)) == null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) gifView.getLayoutParams();
            if (layoutParams != null && layoutParams.width == tbRichTextData.z().mGifInfo.mGifWidth && layoutParams.height == tbRichTextData.z().mGifInfo.mGifHeight) {
                layoutParams.bottomMargin = 0;
            } else {
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(tbRichTextData.z().mGifInfo.mGifWidth, tbRichTextData.z().mGifInfo.mGifHeight);
                layoutParams2.gravity = 3;
                gifView.setLayoutParams(layoutParams2);
            }
            gifView.setOnClickListener(new b(this, tbRichTextData));
            gifView.startLoad(tbRichTextData.z().mGifInfo);
            return true;
        }
        return invokeLL.booleanValue;
    }

    public final boolean K(TbRichTextData tbRichTextData, ImageView imageView, int i2, int i3, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{tbRichTextData, imageView, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z2)})) == null) {
            if (tbRichTextData == null || imageView == null || tbRichTextData.C() == null) {
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
                tbImageView.setTLIconType(tbRichTextData.B());
                tbImageView.setConrers(15);
                tbImageView.setRadius(this.T);
                if (this.R) {
                    tbImageView.setPlaceHolder(2);
                } else {
                    tbImageView.setPlaceHolder(3);
                }
                if (this.f48919e.q) {
                    tbImageView.setSupportNoImage(true);
                }
                String w2 = this.f48919e.c() ? tbRichTextData.C().w() : tbRichTextData.C().y();
                if (!z2 || tbImageView.getUrl() == null || !tbImageView.getUrl().equals(w2)) {
                    tbImageView.startLoad(w2, this.z ? 17 : 18, false);
                }
                if (!tbRichTextData.C().C()) {
                    tbImageView.setAdjustViewBounds(false);
                }
                tbImageView.setTag(R.id.tag_rich_text_meme_info, null);
            }
            return Y(imageView, tbRichTextData.C().getWidth(), tbRichTextData.C().getHeight(), i2, i3, this.j0);
        }
        return invokeCommon.booleanValue;
    }

    public final boolean L(ItemCardView itemCardView, TbRichTextData tbRichTextData) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, itemCardView, tbRichTextData)) == null) {
            if (tbRichTextData != null) {
                if (tbRichTextData.D() == null && tbRichTextData.A() == null) {
                    return false;
                }
                if (tbRichTextData.getType() == 37) {
                    itemCardView.setPosition(9);
                } else if (tbRichTextData.getType() == 1281) {
                    itemCardView.setPosition(4);
                }
                itemCardView.setOnClickListener(new c(this, tbRichTextData, itemCardView));
                itemCardView.setOnClickListenerOfRightBtn(this.x);
                itemCardView.setIsShowRightBtn(this.W);
                if (tbRichTextData.getType() == 37) {
                    itemCardView.setData(tbRichTextData.D().a(), 17, this.a0);
                } else if (tbRichTextData.getType() == 1281) {
                    itemCardView.setData(tbRichTextData.A(), 17, this.a0);
                }
                itemCardView.onChangeSkinType();
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final boolean M(TbRichTextData tbRichTextData, ImageView imageView, int i2, int i3) {
        InterceptResult invokeLLII;
        TbRichTextLinkImageInfo E;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(1048587, this, tbRichTextData, imageView, i2, i3)) == null) {
            if (tbRichTextData == null || imageView == null || (E = tbRichTextData.E()) == null || E.getLink() == null) {
                return false;
            }
            if (imageView instanceof TbImageView) {
                TbImageView tbImageView = (TbImageView) imageView;
                if (this.f48919e.q) {
                    tbImageView.setSupportNoImage(true);
                }
                tbImageView.startLoad(E.w(), this.z ? 17 : 18, false);
                tbImageView.setTag(new v(E.getLink()));
                if (!E.x()) {
                    tbImageView.setAdjustViewBounds(false);
                }
            }
            return Z(imageView, E.getWidth(), E.getHeight(), i2, i3, this.mOnClickListenerForLinkImage);
        }
        return invokeLLII.booleanValue;
    }

    public final boolean N(TbRichTextData tbRichTextData, ImageView imageView, int i2, int i3) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(1048588, this, tbRichTextData, imageView, i2, i3)) == null) {
            if (tbRichTextData == null || imageView == null || tbRichTextData.F() == null) {
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
                tbImageView.setRadius(this.T);
                if (this.R) {
                    tbImageView.setPlaceHolder(2);
                } else {
                    tbImageView.setPlaceHolder(3);
                }
                if (this.f48919e.q) {
                    tbImageView.setSupportNoImage(true);
                }
                tbImageView.startLoad(tbRichTextData.F().memeInfo.pic_url, this.z ? 17 : 18, false);
                tbImageView.setAdjustViewBounds(false);
                tbImageView.setTag(R.id.tag_rich_text_meme_info, tbRichTextData.F());
            }
            return Z(imageView, tbRichTextData.F().memeInfo.width.intValue(), tbRichTextData.F().memeInfo.height.intValue(), i2, i3, this.j0);
        }
        return invokeLLII.booleanValue;
    }

    public final boolean O(TbRichTextData tbRichTextData, GifView gifView, boolean z2) {
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
            String z3 = tbRichTextData.C().z();
            if (StringUtils.isNull(z3)) {
                c.a.q0.f1.m.a aVar = this.f48919e;
                if (aVar.F) {
                    z3 = aVar.r ? tbRichTextData.C().w() : tbRichTextData.C().x();
                }
                if (StringUtils.isNull(z3)) {
                    z3 = this.f48919e.r ? tbRichTextData.C().y() : tbRichTextData.C().B();
                }
            }
            gifView.setShowStaticDrawable(false);
            if (!z2 || gifView.getUrl() == null || !gifView.getUrl().equals(z3)) {
                gifView.startLoad(z3, 38);
            }
            int width = tbRichTextData.C().getWidth();
            int height = tbRichTextData.C().getHeight();
            c.a.q0.f1.m.a aVar2 = this.f48919e;
            return Y(gifView, width, height, aVar2.f13255j, aVar2.k, this.j0);
        }
        return invokeLLZ.booleanValue;
    }

    public final boolean P(TbRichTextData tbRichTextData, TextView textView, boolean z2, t tVar) {
        InterceptResult invokeCommon;
        LinearLayout.LayoutParams layoutParams;
        SpannableStringBuilder G;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048590, this, new Object[]{tbRichTextData, textView, Boolean.valueOf(z2), tVar})) == null) {
            this.U = textView;
            if (z2) {
                layoutParams = new LinearLayout.LayoutParams(-1, -2);
            } else {
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
            }
            if (this.I) {
                layoutParams.gravity = 16;
                textView.setGravity(16);
            } else {
                layoutParams.topMargin = this.f48919e.f13249d;
            }
            c.a.q0.f1.m.a aVar = this.f48919e;
            textView.setLineSpacing(aVar.f13247b, aVar.f13246a);
            textView.setTextSize(0, this.f48919e.f13250e);
            if (this.f48919e.f13251f) {
                c.a.q0.s.u.c.d(textView).A(R.string.F_X02);
            }
            textView.setTextColor(this.f48919e.f13254i);
            textView.setLinkTextColor(SkinManager.getColor(R.color.CAM_X0304));
            textView.setHighlightColor(getContext().getResources().getColor(R.color.transparent));
            textView.setSingleLine(this.f48919e.n);
            if (this.O) {
                c0();
            }
            if (this.P) {
                b0();
            }
            TextUtils.TruncateAt truncateAt = this.q;
            if (truncateAt != null) {
                textView.setEllipsize(truncateAt);
            }
            if (this.hasShadow) {
                c.a.q0.s.u.c.d(textView).y(R.array.S_O_X001);
            }
            int i3 = this.J;
            if (i3 > 0) {
                textView.setMaxWidth(i3);
            }
            int i4 = this.K;
            if (i4 > 0) {
                textView.setMaxLines(i4);
            }
            if (tbRichTextData == null || (G = tbRichTextData.G()) == null || G.length() <= 0) {
                return false;
            }
            c.a.q0.f1.m.a aVar2 = this.f48919e;
            int i5 = aVar2.f13253h;
            if (i5 > 0 && (i2 = aVar2.f13252g) > 0) {
                tbRichTextData.Q(i2, i5);
            }
            if (tVar != null) {
                tVar.decorateText(G, textView, this);
            }
            try {
                textView.setText(G);
            } catch (Exception unused) {
                textView.setText("");
            }
            if (this.L) {
                if (tbRichTextData.N()) {
                    textView.setMovementMethod(c.a.r0.c4.b.a());
                } else {
                    textView.setMovementMethod(LinkMovementMethod.getInstance());
                }
            }
            textView.setFocusable(false);
            textView.setLayoutParams(layoutParams);
            textView.setTag(tbRichTextData);
            if (tbRichTextData == null || tbRichTextData.I() == null) {
                return true;
            }
            tbRichTextData.I().needRecompute = this.m0;
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public final boolean Q(TbRichTextData tbRichTextData, LinearLayout linearLayout, t tVar) {
        InterceptResult invokeLLL;
        boolean R;
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
                        R = P(tbRichTextData, (TextView) childAt, false, tVar);
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
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048592, this, tbRichTextData, view)) == null) {
            view.setTag(tbRichTextData.M());
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
            }
            view.setLayoutParams(layoutParams);
            if (view instanceof PlayVoiceBntNew) {
                ((PlayVoiceBntNew) view).changeSkin();
                return true;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public final boolean S(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, view)) == null) {
            if (view instanceof ImageView) {
                if (view instanceof GifView) {
                    return view.getTag(R.id.tag_rich_text_view_gif_view) != null && (view.getTag(R.id.tag_rich_text_view_gif_view) instanceof s) && ((s) view.getTag(R.id.tag_rich_text_view_gif_view)).f48948a;
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

    public final void T() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.D = false;
            if (this.E == null) {
                this.E = new r(this);
            }
            postDelayed(this.E, ViewConfiguration.getLongPressTimeout());
        }
    }

    public final void U() {
        Runnable runnable;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048595, this) == null) || (runnable = this.E) == null) {
            return;
        }
        removeCallbacks(runnable);
    }

    public final void V(RelativeLayout relativeLayout, int i2, int i3, int i4, int i5) {
        int[] l2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048596, this, new Object[]{relativeLayout, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) || (l2 = c.a.e.e.p.l.l(i2, i3, i4, i5)) == null) {
            return;
        }
        int[] iArr = {l2[0], l2[1]};
        int i6 = iArr[0];
        int i7 = iArr[1];
        if (this.f48919e.s && i4 > i6) {
            float f2 = s0;
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
    public final void W(RelativeLayout relativeLayout, int i2, int i3, int i4, int i5) {
        int[] l2;
        int i6;
        int i7;
        int g2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048597, this, new Object[]{relativeLayout, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) || (l2 = c.a.e.e.p.l.l(i2, i3, i4, i5)) == null) {
            return;
        }
        int[] iArr = {l2[0], l2[1]};
        int i8 = iArr[0];
        int i9 = iArr[1];
        if (this.f48919e.s && i4 > i8) {
            float f2 = s0;
            if (f2 > 1.0f) {
                float f3 = i8;
                float f4 = i4;
                if (f3 * f2 > f4) {
                    i7 = i4 - c.a.e.e.p.l.g(getContext(), R.dimen.ds78);
                    g2 = c.a.e.e.p.l.g(getContext(), R.dimen.ds16);
                } else {
                    float f5 = f4 * 0.68f;
                    if (f3 * f2 > f5) {
                        i7 = (int) f5;
                        g2 = c.a.e.e.p.l.g(getContext(), R.dimen.ds78);
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

    public final boolean X(ImageView imageView, int i2, int i3, int i4, int i5, View.OnClickListener onClickListener) {
        InterceptResult invokeCommon;
        View.OnLongClickListener onLongClickListener;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048598, this, new Object[]{imageView, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), onClickListener})) == null) {
            int[] l2 = c.a.e.e.p.l.l(i2, i3, i4, i5);
            if (l2 == null) {
                return false;
            }
            int[] iArr = {l2[0], l2[1]};
            int i6 = iArr[0];
            int i7 = iArr[1];
            if (this.f48919e.s && i4 > i6) {
                float f2 = s0;
                if (f2 > 1.0f) {
                    float f3 = i6;
                    float f4 = i4;
                    if (f3 * f2 > f4) {
                        i6 = (i4 - c.a.e.e.p.l.g(getContext(), R.dimen.ds78)) - c.a.e.e.p.l.g(getContext(), R.dimen.ds16);
                    } else {
                        float f5 = f4 * 0.68f;
                        i6 = f3 * f2 > f5 ? ((int) f5) - c.a.e.e.p.l.g(getContext(), R.dimen.ds78) : (int) (f3 * f2);
                    }
                    if (iArr[0] > 0) {
                        i7 = (iArr[1] * i6) / iArr[0];
                    }
                }
            }
            boolean z2 = imageView instanceof TbImageView;
            if (z2) {
                TbImageView tbImageView = (TbImageView) imageView;
                tbImageView.setDefaultResource(this.f48919e.l);
                if (tbImageView.getGifIconWidth() < i6 && tbImageView.getGifIconHeight() < i7) {
                    tbImageView.setGifIconSupport(true);
                } else {
                    tbImageView.setGifIconSupport(false);
                }
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i6, i7);
            if (this.f48919e.s) {
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            } else {
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            }
            imageView.setClickable(true);
            imageView.setFocusable(false);
            if (this.t != null && z2) {
                ((TbImageView) imageView).setTbGestureDetector(this.k0);
                imageView.setClickable(true);
            } else {
                imageView.setOnClickListener(onClickListener);
            }
            imageView.setLayoutParams(layoutParams);
            if (z2) {
                if (this.c0 != null) {
                    ((TbImageView) imageView).setDispatchTouchListener(this.l0);
                    imageView.setOnLongClickListener(this.c0);
                }
            } else if ((imageView instanceof GifView) && (onLongClickListener = this.c0) != null) {
                imageView.setOnLongClickListener(onLongClickListener);
            }
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public final boolean Y(ImageView imageView, int i2, int i3, int i4, int i5, View.OnClickListener onClickListener) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048599, this, new Object[]{imageView, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), onClickListener})) == null) {
            int[] e2 = this.f48919e.e(i2, i3, i4, i5);
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
            c.a.q0.f1.m.a aVar = this.f48919e;
            if (aVar.s) {
                imageView.setScaleType(aVar.p);
                if (z2) {
                    ((TbImageView) imageView).setOnDrawListener(this.f48919e.I);
                }
            } else {
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            }
            imageView.setClickable(true);
            imageView.setFocusable(false);
            if (this.t != null && z2) {
                ((TbImageView) imageView).setTbGestureDetector(this.k0);
                imageView.setClickable(true);
            } else {
                imageView.setOnClickListener(onClickListener);
            }
            imageView.setLayoutParams(layoutParams);
            if (z2) {
                if (this.c0 != null) {
                    ((TbImageView) imageView).setDispatchTouchListener(this.l0);
                    imageView.setOnLongClickListener(this.c0);
                }
            } else if ((imageView instanceof GifView) && this.c0 != null) {
                ((GifView) imageView).setDispatchTouchListener(this.l0);
                imageView.setOnLongClickListener(this.c0);
            }
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public final boolean Z(ImageView imageView, int i2, int i3, int i4, int i5, View.OnClickListener onClickListener) {
        InterceptResult invokeCommon;
        View.OnLongClickListener onLongClickListener;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048600, this, new Object[]{imageView, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), onClickListener})) == null) {
            int[] l2 = c.a.e.e.p.l.l(i2, i3, i4, i5);
            if (l2 == null) {
                return false;
            }
            int[] iArr = {l2[0], l2[1]};
            int i6 = iArr[0];
            int i7 = iArr[1];
            if (this.f48919e.s && i4 > i6) {
                float f2 = s0;
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
                tbImageView.setDefaultResource(this.f48919e.l);
                if (tbImageView.getGifIconWidth() < i6 && tbImageView.getGifIconHeight() < i7) {
                    tbImageView.setGifIconSupport(true);
                } else {
                    tbImageView.setGifIconSupport(false);
                }
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i6, i7);
            if (this.f48919e.s) {
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            } else {
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            }
            imageView.setClickable(true);
            imageView.setFocusable(false);
            if (this.t != null && z2) {
                ((TbImageView) imageView).setTbGestureDetector(this.k0);
                imageView.setClickable(true);
            } else {
                imageView.setOnClickListener(onClickListener);
            }
            imageView.setLayoutParams(layoutParams);
            if (z2) {
                if (this.c0 != null) {
                    ((TbImageView) imageView).setDispatchTouchListener(this.l0);
                    imageView.setOnLongClickListener(this.c0);
                }
            } else if ((imageView instanceof GifView) && (onLongClickListener = this.c0) != null) {
                imageView.setOnLongClickListener(onLongClickListener);
            }
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public final void a0() {
        TextView textView;
        CharSequence subSequence;
        Object[] spans;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048601, this) == null) || this.K <= 1 || (textView = this.U) == null || textView.getLineCount() <= this.K) {
            return;
        }
        try {
            CharSequence subSequence2 = this.U.getText().subSequence(0, this.U.getLayout().getLineEnd(this.K - 1));
            Layout layout = this.U.getLayout();
            int lineStart = layout.getLineStart(this.K - 1);
            int lineEnd = layout.getLineEnd(this.K - 1);
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
            this.U.setText(spannableStringBuilder);
        } catch (Exception unused) {
            this.U.setText(this.U.getText());
        }
    }

    public final void b0() {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048602, this) == null) || (textView = this.U) == null) {
            return;
        }
        textView.getViewTreeObserver().addOnGlobalLayoutListener(new a(this));
    }

    public final void c0() {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048603, this) == null) || (textView = this.U) == null) {
            return;
        }
        textView.getViewTreeObserver().addOnGlobalLayoutListener(new q(this));
    }

    public final void d0() {
        TextView textView;
        CharSequence text;
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048604, this) == null) || this.K <= 0 || (textView = this.U) == null || textView.getLineCount() <= this.K) {
            return;
        }
        try {
            text = this.U.getText().subSequence(0, this.U.getLayout().getLineEnd(this.K - 1) - 1);
            str = "...";
        } catch (Exception unused) {
            text = this.U.getText();
            str = "";
        }
        TextUtils.TruncateAt ellipsize = this.U.getEllipsize();
        if (ellipsize == TextUtils.TruncateAt.START) {
            this.U.setText(str);
            this.U.append(text);
        } else if (ellipsize == TextUtils.TruncateAt.MIDDLE) {
            this.U.setText(text.subSequence(0, text.length() / 2));
            this.U.append(str);
            this.U.append(text.subSequence(text.length() / 2, text.length()));
        } else if (ellipsize == TextUtils.TruncateAt.END) {
            this.U.setText(text);
            this.U.append(str);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, motionEvent)) == null) {
            this.C = false;
            int action = motionEvent.getAction();
            if ((action == 1 || action == 3) && !this.D) {
                U();
            }
            boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
            if (motionEvent.getAction() == 0 && !this.C) {
                T();
            }
            return dispatchTouchEvent;
        }
        return invokeL.booleanValue;
    }

    public c.a.q0.f1.m.a getLayoutStrategy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.f48919e : (c.a.q0.f1.m.a) invokeV.objValue;
    }

    public z getOnImageClickListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.s : (z) invokeV.objValue;
    }

    public a0 getOnLinkImageClickListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.u : (a0) invokeV.objValue;
    }

    public c.a.r0.k2.a<ImageView> getRecycleImageViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            if (this.f48920f == null) {
                this.f48920f = new h(this, new g(this), 10, 0);
            }
            return this.f48920f;
        }
        return (c.a.r0.k2.a) invokeV.objValue;
    }

    public TbRichText getRichText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.H : (TbRichText) invokeV.objValue;
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

    public boolean hasLongText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.F : invokeV.booleanValue;
    }

    public boolean isDisplayImage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) ? this.y : invokeV.booleanValue;
    }

    public boolean isFromCDN() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? this.z : invokeV.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            super.onDetachedFromWindow();
            c.a.q0.f1.m.a aVar = this.f48919e;
            if (aVar != null) {
                aVar.d();
            }
            stopLoad();
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048616, this, motionEvent)) == null) {
            if (this.D && (motionEvent.getAction() == 3 || motionEvent.getAction() == 1)) {
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
            stopLoad();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048618, this, motionEvent)) == null) {
            this.C = true;
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
                stopLoad();
            }
        }
    }

    @Override // c.a.e.f.a.h
    public void refresh() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            startLoad(this.o0);
        }
    }

    public void setAddExpandableListener(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048621, this, z2) == null) {
            this.P = z2;
        }
    }

    public void setAddTruncateListener(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048622, this, z2) == null) {
            this.O = z2;
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, drawable) == null) {
            super.setBackgroundDrawable(drawable);
            if (this.n0 != drawable) {
                this.m0 = true;
                this.n0 = drawable;
            }
            setText(this.H);
            this.m0 = false;
        }
    }

    public void setCommonTextViewOnClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, onClickListener) == null) {
            this.v = onClickListener;
        }
    }

    public void setDisplayImage(boolean z2, boolean z3) {
        c.a.e.e.k.b<ImageView> bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048625, this, new Object[]{Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) || this.y == z2) {
            return;
        }
        this.y = z2;
        if (z3) {
            requestLayout();
        }
        if (this.y || (bVar = this.f48921g) == null) {
            return;
        }
        bVar.c();
    }

    public void setDuiEnabled(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048626, this, z2) == null) {
            this.p = z2;
        }
    }

    public void setHasMovementMethod(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048627, this, z2) == null) {
            this.L = z2;
        }
    }

    public void setIsFromCDN(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048628, this, z2) == null) {
            this.z = z2;
            c.a.q0.f1.m.a aVar = this.f48919e;
            if (aVar != null) {
                aVar.r = z2;
            }
        }
    }

    public void setIsHost(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048629, this, z2) == null) {
            this.N = z2;
            GridImageLayout gridImageLayout = this.n;
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
            this.R = z2;
        }
    }

    public void setItemOrderOrDownloadListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048633, this, onClickListener) == null) {
            this.x = onClickListener;
        }
    }

    public void setLayoutStrategy(c.a.q0.f1.m.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048634, this, aVar) == null) || aVar == null) {
            return;
        }
        this.f48919e.d();
        this.f48919e = aVar;
        I();
        GridImageLayout gridImageLayout = this.n;
        if (gridImageLayout != null) {
            gridImageLayout.setLayoutStrategy(this.f48919e);
        }
    }

    public void setLinkTextColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048635, this, i2) == null) {
            c.a.q0.f1.m.a aVar = this.f48919e;
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
            this.K = i2;
            TextView textView = this.U;
            if (textView != null) {
                textView.setMaxLines(i2);
            }
        }
    }

    public void setMaxWidth(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048637, this, i2) == null) {
            this.J = i2;
        }
    }

    public void setOnEmotionClickListener(y yVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048638, this, yVar) == null) {
            this.G = yVar;
        }
    }

    public void setOnImageClickListener(z zVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048639, this, zVar) == null) {
            this.s = zVar;
            GridImageLayout gridImageLayout = this.n;
            if (gridImageLayout != null) {
                gridImageLayout.setOnImageClickListener(zVar);
            }
        }
    }

    public void setOnImageTouchListener(c.a.r0.k2.i.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048640, this, cVar) == null) {
            this.t = cVar;
        }
    }

    public void setOnLinkImageClickListener(a0 a0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048641, this, a0Var) == null) {
            this.u = a0Var;
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
            this.B = onClickListener;
        }
    }

    public void setSubPbPost(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048644, this, z2) == null) {
            this.M = z2;
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
            this.f48919e.f13251f = true;
        }
    }

    public void setTextCenter(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048650, this, z2) == null) {
            this.I = z2;
        }
    }

    public void setTextColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048651, this, i2) == null) {
            c.a.q0.f1.m.a aVar = this.f48919e;
            if (i2 == aVar.f13254i) {
                return;
            }
            aVar.f13254i = i2;
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
            this.q = truncateAt;
            TextView textView = this.U;
            if (textView != null) {
                textView.setEllipsize(truncateAt);
            }
        }
    }

    public void setTextPadding(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048653, this, i2) == null) {
            c.a.q0.f1.m.a aVar = this.f48919e;
            if (aVar.f13248c == i2) {
                return;
            }
            aVar.f13248c = i2;
            int childCount = getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                if (childAt != null && (childAt instanceof TextView)) {
                    int i4 = this.f48919e.f13248c;
                    ((TextView) childAt).setPadding(i4, 0, 0, i4);
                }
            }
        }
    }

    public void setTextSize(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048654, this, f2) == null) {
            setFaceSize(f2);
            c.a.q0.f1.m.a aVar = this.f48919e;
            if (f2 == aVar.f13250e) {
                return;
            }
            aVar.f13250e = f2;
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
            this.A = i2;
        }
    }

    public void setmGridEmptyClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048660, this, onClickListener) == null) {
            this.w = onClickListener;
        }
    }

    public void setmIsGridImageSupportLongPress(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048661, this, z2) == null) {
            this.S = z2;
        }
    }

    public void startLoad(String str, w wVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048663, this, str, wVar) == null) {
            this.i0 = wVar;
            startLoad(str);
        }
    }

    public void stopLoad() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048664, this) == null) || TextUtils.isEmpty(this.o0)) {
            return;
        }
        c.a.e.e.l.d.h().d(this.o0, 19, this.q0);
        setBackgroundDrawable(null);
    }

    public static TbRichText parse(Context context, JSONArray jSONArray, boolean z2) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65562, null, context, jSONArray, z2)) == null) ? new TbRichText(context, jSONArray, z2) : (TbRichText) invokeLLZ.objValue;
    }

    public static TbRichText parser(Context context, List<PbContent> list, boolean z2, @NonNull d2 d2Var) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65566, null, new Object[]{context, list, Boolean.valueOf(z2), d2Var})) == null) ? new TbRichText(context, list, null, z2, null, d2Var, -1) : (TbRichText) invokeCommon.objValue;
    }

    public void setText(TbRichText tbRichText, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048646, this, tbRichText, z2) == null) {
            setText(tbRichText, z2, null);
        }
    }

    public static TbRichText parser(Context context, List<PbContent> list, String str, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65563, null, new Object[]{context, list, str, Boolean.valueOf(z2)})) == null) ? parser(context, list, str, z2, null, null, -1) : (TbRichText) invokeCommon.objValue;
    }

    public void setText(TbRichText tbRichText, boolean z2, t tVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048647, this, new Object[]{tbRichText, Boolean.valueOf(z2), tVar}) == null) {
            setText(tbRichText, z2, tVar, false, false);
        }
    }

    public void startLoad(String str) {
        BdUniqueId bdUniqueId;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048662, this, str) == null) {
            if (TextUtils.isEmpty(str)) {
                this.o0 = str;
                return;
            }
            getContext();
            c.a.e.a.i c2 = c.a.e.a.j.c(getContext());
            if (c2 != null) {
                bdUniqueId = c2.getUniqueId();
                z2 = c2.isScroll();
            } else {
                bdUniqueId = null;
                z2 = false;
            }
            if (!(str.equals(this.o0) && this.p0 == bdUniqueId)) {
                stopLoad();
            }
            this.o0 = str;
            this.p0 = bdUniqueId;
            setBackgroundDrawable(null);
            c.a.e.l.d.a aVar = (c.a.e.l.d.a) c.a.e.e.l.d.h().n(this.o0, 19, new Object[0]);
            if (aVar != null) {
                B(aVar);
            } else if (z2) {
                invalidate();
            } else if (!c.a.e.e.l.d.h().j(19)) {
                invalidate();
            } else {
                c.a.e.e.l.d.h().k(this.o0, 19, this.q0, 0, 0, this.p0, new Object[0]);
            }
        }
    }

    public static TbRichText parser(Context context, List<PbContent> list, String str, boolean z2, @Nullable PostData postData, @Nullable d2 d2Var, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65564, null, new Object[]{context, list, str, Boolean.valueOf(z2), postData, d2Var, Integer.valueOf(i2)})) == null) ? new TbRichText(context, list, str, z2, postData, d2Var, i2) : (TbRichText) invokeCommon.objValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:273:0x0037 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:275:0x0037 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:197:0x04fe A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:207:0x0520  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x053a  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0134  */
    /* JADX WARN: Type inference failed for: r0v129, types: [com.baidu.tbadk.gif.GifView, android.view.View] */
    /* JADX WARN: Type inference failed for: r0v157 */
    /* JADX WARN: Type inference failed for: r10v15, types: [android.widget.ImageView] */
    /* JADX WARN: Type inference failed for: r13v5 */
    /* JADX WARN: Type inference failed for: r26v0, types: [android.widget.LinearLayout, com.baidu.tbadk.widget.richText.TbRichTextView, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v74, types: [android.widget.ImageView] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void setText(TbRichText tbRichText, boolean z2, t tVar, boolean z3, boolean z4) {
        ArrayList<TbRichTextData> y2;
        c.a.r0.k2.a<ImageView> aVar;
        int i2;
        boolean P;
        SpannableStringBuilder G;
        TbRichTextData tbRichTextData;
        int i3;
        GridImageLayout gridImageLayout;
        TextView textView;
        int i4;
        LinearLayout linearLayout;
        int i5;
        c.a.e.e.k.b<TiebaPlusRecommendCard> bVar;
        ItemCardView itemCardView;
        RelativeLayout relativeLayout;
        RelativeLayout relativeLayout2;
        int i6;
        GifView gifView;
        Object C;
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
            if (this.H != tbRichText || (tbRichText != null && tbRichText.isChanged)) {
                if (tbRichText != null) {
                    tbRichText.isChanged = false;
                }
                this.H = tbRichText;
                removeAllViews();
                if (tbRichText == null || (y2 = tbRichText.y()) == null) {
                    return;
                }
                Iterator<TbRichTextData> it = y2.iterator();
                i iVar = null;
                boolean z8 = true;
                TiebaPlusRecommendCard tiebaPlusRecommendCard = null;
                View view = null;
                int i7 = 0;
                int i8 = 0;
                boolean z9 = false;
                boolean z10 = true;
                while (it.hasNext()) {
                    TbRichTextData next = it.next();
                    if (next != null) {
                        if (next.getType() == z8) {
                            TextView D = D(getContext());
                            P = P(next, D, z8, tVar2);
                            if (z2 && !this.F && (G = next.G()) != null) {
                                this.F = G.length() >= 200;
                            }
                            TiePlusEventController.tryExposeTiePlusLinkEvent(next.J());
                            if (this.t != null) {
                                D.setOnTouchListener(this.k0);
                                textView = D;
                            } else {
                                D.setOnClickListener(this.v);
                                textView = D;
                            }
                        } else if (next.getType() == 8) {
                            if (this.R) {
                                int i9 = i7;
                                if (z9) {
                                    i2 = i9;
                                    i7 = i2;
                                    tiebaPlusRecommendCard = tiebaPlusRecommendCard;
                                } else {
                                    GridImageLayout gridImageView = getGridImageView();
                                    gridImageView.setData(tbRichText.A());
                                    tbRichTextData = next;
                                    i7 = i9;
                                    P = true;
                                    z9 = true;
                                    gridImageLayout = gridImageView;
                                }
                            } else if (i8 < 10) {
                                i8++;
                                if (next.C() == null) {
                                    tbRichTextData = next;
                                    P = false;
                                    gridImageLayout = tiebaPlusRecommendCard;
                                } else if (TbadkCoreApplication.getInst().isGifAutoPlay() && !next.C().E()) {
                                    if (z4) {
                                        String z11 = next.C().z();
                                        if (StringUtils.isNull(z11)) {
                                            c.a.q0.f1.m.a aVar2 = this.f48919e;
                                            if (aVar2.F) {
                                                z11 = aVar2.r ? next.C().w() : next.C().x();
                                            }
                                            if (StringUtils.isNull(z11)) {
                                                z11 = this.f48919e.r ? next.C().y() : next.C().B();
                                            }
                                        }
                                        c.a.r0.k2.a<ImageView> aVar3 = this.f48920f;
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
                                                    sVar.f48948a = z8;
                                                    gifView2.setTag(R.id.tag_rich_text_view_gif_view, sVar);
                                                    P = O(next, gifView2, z7);
                                                    textView = gifView2;
                                                    if (z3) {
                                                        u uVar = new u(iVar);
                                                        uVar.f48949a = z8;
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
                                    sVar2.f48948a = z8;
                                    gifView2.setTag(R.id.tag_rich_text_view_gif_view, sVar2);
                                    P = O(next, gifView2, z7);
                                    textView = gifView2;
                                    if (z3) {
                                    }
                                } else {
                                    if (z4) {
                                        String w2 = this.f48919e.c() ? next.C().w() : next.C().y();
                                        c.a.r0.k2.a<ImageView> aVar4 = this.f48920f;
                                        Object obj4 = aVar4 != null ? (ImageView) aVar4.h(w2) : iVar;
                                        if (obj4 == null) {
                                            z6 = false;
                                            obj = C(getContext());
                                        } else {
                                            z6 = true;
                                            obj = obj4;
                                        }
                                        C = obj;
                                        z5 = z6;
                                    } else {
                                        C = C(getContext());
                                        z5 = false;
                                    }
                                    c.a.q0.f1.m.a aVar5 = this.f48919e;
                                    ?? r10 = C;
                                    i4 = i7;
                                    P = K(next, C, aVar5.f13255j, aVar5.k, z5);
                                    if (z3) {
                                        u uVar2 = new u(iVar);
                                        uVar2.f48949a = z8;
                                        r10.setTag(R.id.tag_rich_text_view_recycle, uVar2);
                                    }
                                    gifView = r10;
                                    tbRichTextData = next;
                                    i7 = i4;
                                    gridImageLayout = gifView;
                                }
                            }
                            tiebaPlusRecommendCard = gridImageLayout;
                            if (P && tiebaPlusRecommendCard != null) {
                                addView(tiebaPlusRecommendCard);
                                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tiebaPlusRecommendCard.getLayoutParams();
                                if (!z10 && (i3 = this.f48919e.D) >= 0) {
                                    if (layoutParams != null) {
                                        layoutParams.topMargin = i3;
                                        tiebaPlusRecommendCard.setLayoutParams(layoutParams);
                                    }
                                    z10 = false;
                                } else if (!(tiebaPlusRecommendCard instanceof TbListTextView)) {
                                    if (!(view instanceof ImageView) && !(view instanceof RelativeLayout)) {
                                        layoutParams.topMargin = this.f48919e.f13249d;
                                    } else {
                                        layoutParams.topMargin = this.f48919e.z;
                                    }
                                    tiebaPlusRecommendCard.setLayoutParams(layoutParams);
                                } else if ((!(tiebaPlusRecommendCard instanceof ImageView) && !(tiebaPlusRecommendCard instanceof RelativeLayout)) || (tbRichTextData.getType() != 8 && tbRichTextData.getType() != 20 && tbRichTextData.getType() != 17)) {
                                    if ((tiebaPlusRecommendCard instanceof ItemCardView) && !z10) {
                                        layoutParams.topMargin = this.f48919e.E;
                                        tiebaPlusRecommendCard.setLayoutParams(layoutParams);
                                    }
                                } else {
                                    if (view instanceof TbListTextView) {
                                        layoutParams.topMargin = this.f48919e.u;
                                    } else if (!(view instanceof ImageView) && !(tiebaPlusRecommendCard instanceof RelativeLayout)) {
                                        layoutParams.topMargin = this.f48919e.f13249d;
                                    } else {
                                        layoutParams.topMargin = this.f48919e.t;
                                    }
                                    tiebaPlusRecommendCard.setLayoutParams(layoutParams);
                                }
                                view = tiebaPlusRecommendCard;
                            }
                            tVar2 = tVar;
                            iVar = null;
                            z8 = true;
                        } else {
                            i4 = i7;
                            if (next.getType() == 32) {
                                c.a.q0.f1.m.j L = next.L();
                                if (L != null && L.j()) {
                                    tbRichTextData = next;
                                    linearLayout = G(L);
                                } else {
                                    tbRichTextData = next;
                                    linearLayout = E(tbRichTextData);
                                }
                                i7 = i4;
                                P = true;
                                gridImageLayout = linearLayout;
                                tiebaPlusRecommendCard = gridImageLayout;
                                if (P) {
                                    addView(tiebaPlusRecommendCard);
                                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) tiebaPlusRecommendCard.getLayoutParams();
                                    if (!z10) {
                                    }
                                    if (!(tiebaPlusRecommendCard instanceof TbListTextView)) {
                                    }
                                    view = tiebaPlusRecommendCard;
                                }
                                tVar2 = tVar;
                                iVar = null;
                                z8 = true;
                            } else {
                                tbRichTextData = next;
                                if (tbRichTextData.getType() == 512) {
                                    View F = F(view);
                                    if (F == null) {
                                        i7 = i4;
                                        tiebaPlusRecommendCard = F;
                                    } else {
                                        P = R(tbRichTextData, F);
                                        gifView = F;
                                    }
                                } else if (tbRichTextData.getType() == 768) {
                                    View textVoiceView = getTextVoiceView();
                                    P = Q(tbRichTextData, (LinearLayout) textVoiceView, tVar2);
                                    gifView = textVoiceView;
                                } else if (tbRichTextData.getType() == 17) {
                                    GifView gifView4 = getGifView();
                                    P = J(tbRichTextData, gifView4);
                                    gifView = gifView4;
                                } else if (tbRichTextData.getType() == 20) {
                                    i2 = i4;
                                    if (i2 >= 10) {
                                        i7 = i2;
                                        tiebaPlusRecommendCard = tiebaPlusRecommendCard;
                                    } else {
                                        int i10 = i2 + 1;
                                        boolean z12 = (tbRichTextData == null || tbRichTextData.F() == null || tbRichTextData.F().memeInfo == null || StringUtils.isNull(tbRichTextData.F().memeInfo.pic_url)) ? false : true;
                                        if (z12) {
                                            RelativeLayout b2 = this.k.b();
                                            b2.removeAllViews();
                                            b2.setLayoutParams(new LinearLayout.LayoutParams(tbRichTextData.F().memeInfo.width.intValue(), tbRichTextData.F().memeInfo.height.intValue()));
                                            if (DuiSwitch.getInOn() && this.p) {
                                                int intValue = tbRichTextData.F().memeInfo.width.intValue();
                                                int intValue2 = tbRichTextData.F().memeInfo.height.intValue();
                                                c.a.q0.f1.m.a aVar6 = this.f48919e;
                                                relativeLayout = b2;
                                                W(b2, intValue, intValue2, aVar6.f13255j, aVar6.k);
                                            } else {
                                                relativeLayout = b2;
                                                int intValue3 = tbRichTextData.F().memeInfo.width.intValue();
                                                int intValue4 = tbRichTextData.F().memeInfo.height.intValue();
                                                c.a.q0.f1.m.a aVar7 = this.f48919e;
                                                V(relativeLayout, intValue3, intValue4, aVar7.f13255j, aVar7.k);
                                            }
                                            ImageView b3 = this.f48921g.b();
                                            c.a.q0.f1.m.a aVar8 = this.f48919e;
                                            N(tbRichTextData, b3, aVar8.f13255j, aVar8.k);
                                            if (DuiSwitch.getInOn() && this.p) {
                                                ImageView b4 = this.f48921g.b();
                                                b4.setTag(this.H);
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
                                                    tbImageView.setRadius(this.T);
                                                    tbImageView.setAdjustViewBounds(false);
                                                    if (this.R) {
                                                        tbImageView.setPlaceHolder(2);
                                                    } else {
                                                        tbImageView.setPlaceHolder(3);
                                                    }
                                                }
                                                b4.setScaleType(ImageView.ScaleType.FIT_XY);
                                                int g2 = c.a.e.e.p.l.g(getContext(), R.dimen.ds78);
                                                int g3 = c.a.e.e.p.l.g(getContext(), R.dimen.ds78);
                                                b3.setId(R.id.meme_image_view);
                                                int intValue5 = tbRichTextData.F().memeInfo.width.intValue();
                                                int intValue6 = tbRichTextData.F().memeInfo.height.intValue();
                                                c.a.q0.f1.m.a aVar9 = this.f48919e;
                                                i5 = i8;
                                                X(b3, intValue5, intValue6, aVar9.f13255j, aVar9.k, this.j0);
                                                relativeLayout2 = relativeLayout;
                                                relativeLayout2.addView(b3);
                                                if (g3 > tbRichTextData.F().memeInfo.height.intValue()) {
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
                                                    layoutParams3.rightMargin = c.a.e.e.p.l.g(getContext(), R.dimen.ds6);
                                                }
                                                SkinManager.setImageResource(b4, R.drawable.icon_emotion_dui_n);
                                                relativeLayout2.addView(b4, layoutParams3);
                                            } else {
                                                i5 = i8;
                                                relativeLayout2 = relativeLayout;
                                                int intValue7 = tbRichTextData.F().memeInfo.width.intValue();
                                                int intValue8 = tbRichTextData.F().memeInfo.height.intValue();
                                                c.a.q0.f1.m.a aVar10 = this.f48919e;
                                                Z(b3, intValue7, intValue8, aVar10.f13255j, aVar10.k, this.j0);
                                                relativeLayout2.addView(b3);
                                            }
                                            itemCardView = relativeLayout2;
                                            i7 = i10;
                                            P = z12;
                                            i8 = i5;
                                            tiebaPlusRecommendCard = itemCardView;
                                            if (P) {
                                            }
                                            tVar2 = tVar;
                                            iVar = null;
                                            z8 = true;
                                        } else {
                                            i7 = i10;
                                            P = z12;
                                            tiebaPlusRecommendCard = tiebaPlusRecommendCard;
                                            if (P) {
                                            }
                                            tVar2 = tVar;
                                            iVar = null;
                                            z8 = true;
                                        }
                                    }
                                } else {
                                    i5 = i8;
                                    if (tbRichTextData.getType() == 1280) {
                                        ImageView C2 = C(getContext());
                                        i8 = i5 + 1;
                                        i7 = i4;
                                        P = M(tbRichTextData, C2, (this.f48919e.f13255j - getPaddingLeft()) - getPaddingRight(), this.f48919e.k);
                                        tiebaPlusRecommendCard = C2;
                                    } else if (tbRichTextData.getType() != 37 && tbRichTextData.getType() != 1281) {
                                        if (tbRichTextData.getType() != 36 || tbRichTextData.K() == null || tbRichTextData.K().z() == null || (bVar = this.m) == null) {
                                            i7 = i4;
                                            i8 = i5;
                                            P = false;
                                            tiebaPlusRecommendCard = tiebaPlusRecommendCard;
                                        } else {
                                            TiebaPlusRecommendCard b5 = bVar.b();
                                            b5.updateCardView(tbRichTextData.K());
                                            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) b5.getLayoutParams();
                                            c.a.q0.f1.m.a aVar11 = this.f48919e;
                                            int i11 = aVar11.y;
                                            marginLayoutParams.setMargins(i11, aVar11.w, i11, aVar11.x);
                                            b5.setLayoutParams(marginLayoutParams);
                                            i7 = i4;
                                            i8 = i5;
                                            P = true;
                                            tiebaPlusRecommendCard = b5;
                                        }
                                    } else {
                                        ItemCardView itemCardView2 = getItemCardView();
                                        i7 = i4;
                                        P = L(itemCardView2, tbRichTextData);
                                        itemCardView = itemCardView2;
                                        i8 = i5;
                                        tiebaPlusRecommendCard = itemCardView;
                                    }
                                    if (P) {
                                    }
                                    tVar2 = tVar;
                                    iVar = null;
                                    z8 = true;
                                }
                                i7 = i4;
                                gridImageLayout = gifView;
                                tiebaPlusRecommendCard = gridImageLayout;
                                if (P) {
                                }
                                tVar2 = tVar;
                                iVar = null;
                                z8 = true;
                            }
                        }
                        tbRichTextData = next;
                        gridImageLayout = textView;
                        tiebaPlusRecommendCard = gridImageLayout;
                        if (P) {
                        }
                        tVar2 = tVar;
                        iVar = null;
                        z8 = true;
                    }
                    i2 = i7;
                    i7 = i2;
                    tiebaPlusRecommendCard = tiebaPlusRecommendCard;
                }
                if (view instanceof TbListTextView) {
                    LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) view.getLayoutParams();
                    layoutParams4.bottomMargin = this.f48919e.C;
                    view.setLayoutParams(layoutParams4);
                } else if (view != null && this.f48919e.B >= 0) {
                    LinearLayout.LayoutParams layoutParams5 = (LinearLayout.LayoutParams) view.getLayoutParams();
                    layoutParams5.bottomMargin = this.f48919e.B;
                    view.setLayoutParams(layoutParams5);
                }
                if (z3 || (aVar = this.f48920f) == null) {
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
        this.f48919e = new c.a.q0.f1.m.a();
        this.f48920f = null;
        this.f48921g = null;
        this.f48922h = null;
        this.f48923i = null;
        this.f48924j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.o = null;
        this.p = true;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = null;
        this.v = null;
        this.w = null;
        this.x = null;
        this.y = true;
        this.z = true;
        this.A = -1;
        this.C = false;
        this.D = false;
        this.E = null;
        this.F = false;
        this.I = false;
        this.J = -1;
        this.K = -1;
        this.L = true;
        this.M = false;
        this.N = false;
        this.O = false;
        this.P = false;
        this.Q = false;
        this.R = false;
        this.S = false;
        this.hasShadow = false;
        this.V = false;
        this.W = false;
        this.b0 = new i(this, 2, null);
        this.j0 = new j(this);
        this.k0 = new c.a.r0.k2.i.c(new k(this));
        this.mOnClickListenerForLinkImage = new l(this);
        this.l0 = new d(this);
        this.q0 = new e(this);
        this.r0 = new f(this, 2004018);
        H();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.TbRichTextView);
        this.f48919e.b(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        I();
    }
}
