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
import c.a.s0.s.q.e2;
import c.a.t0.t2.s.c;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ItemData;
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
/* loaded from: classes11.dex */
public class TbRichTextView extends LinearLayout implements c.a.d.g.a.h {
    public static /* synthetic */ Interceptable $ic;
    public static final float t0;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public View.OnClickListener B;
    public boolean C;
    public boolean D;
    public Runnable E;
    public boolean F;
    public x G;
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
    public c.a.s0.f1.n.f b0;
    public View.OnLongClickListener c0;
    public v d0;

    /* renamed from: e  reason: collision with root package name */
    public c.a.s0.f1.n.a f41510e;
    public final View.OnClickListener e0;

    /* renamed from: f  reason: collision with root package name */
    public c.a.t0.t2.a<ImageView> f41511f;
    public final c.a.t0.t2.s.c f0;

    /* renamed from: g  reason: collision with root package name */
    public c.a.d.f.k.b<ImageView> f41512g;
    public final w g0;

    /* renamed from: h  reason: collision with root package name */
    public c.a.d.f.k.b<TextView> f41513h;
    public boolean h0;
    public boolean hasShadow;

    /* renamed from: i  reason: collision with root package name */
    public c.a.d.f.k.b<View> f41514i;
    public Drawable i0;

    /* renamed from: j  reason: collision with root package name */
    public c.a.d.f.k.b<LinearLayout> f41515j;
    public c.a.d.f.k.b<RelativeLayout> k;
    public String k0;
    public c.a.d.f.k.b<GifView> l;
    public c.a.d.f.k.b<TiebaPlusRecommendCard> m;
    public final View.OnClickListener mOnClickListenerForLinkImage;
    public GridImageLayout n;
    public c.a.d.f.k.b<ItemCardView> o;
    public boolean p;
    public TextUtils.TruncateAt q;
    public BdUniqueId q0;
    public a0 r;
    public final c.a.d.f.l.c<c.a.d.n.d.a> r0;
    public y s;
    public CustomMessageListener s0;
    public c.a.t0.t2.s.c t;
    public z u;
    public View.OnClickListener v;
    public View.OnClickListener w;
    public View.OnClickListener x;
    public boolean y;
    public boolean z;

    /* loaded from: classes11.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TbRichTextData f41516e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ TbRichTextView f41517f;

        public a(TbRichTextView tbRichTextView, TbRichTextData tbRichTextData) {
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
            this.f41517f = tbRichTextView;
            this.f41516e = tbRichTextData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f41517f.G == null) {
                return;
            }
            TbRichTextEmotionInfo z = this.f41516e.z();
            x xVar = this.f41517f.G;
            GifInfo gifInfo = z.mGifInfo;
            xVar.a(view, gifInfo.mGid, gifInfo.mPackageName, gifInfo.mIcon, gifInfo.mStaticUrl, gifInfo.mDynamicUrl, gifInfo.mSharpText, gifInfo.mGifWidth, gifInfo.mGifHeight);
        }
    }

    /* loaded from: classes11.dex */
    public static class a0 implements AbsListView.RecyclerListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public int f41518e;

        public a0(int i2) {
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
            this.f41518e = 0;
            this.f41518e = i2;
        }

        @Override // android.widget.AbsListView.RecyclerListener
        public void onMovedToScrapHeap(View view) {
            View findViewById;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && (findViewById = view.findViewById(this.f41518e)) != null && (findViewById instanceof TbRichTextView)) {
                ((TbRichTextView) findViewById).setText(null);
            }
        }
    }

    /* loaded from: classes11.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TbRichTextData f41519e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ItemCardView f41520f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ TbRichTextView f41521g;

        public b(TbRichTextView tbRichTextView, TbRichTextData tbRichTextData, ItemCardView itemCardView) {
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
            this.f41521g = tbRichTextView;
            this.f41519e = tbRichTextData;
            this.f41520f = itemCardView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f41519e.getType() == 37) {
                    TiebaStatic.log(new StatisticItem("common_click").param("page_type", "a005").param(TiebaStatic.Params.GUA_TYPE, 4).param("obj_locate", 16));
                    ItemCardHelper.q(this.f41520f.getPosition(), this.f41519e.D().a().itemId, this.f41520f.getButtonState(this.f41519e.D().a()), this.f41521g.a0, c.a.s0.s.k0.p.c.a(this.f41519e.D().a().buttonLinkType.intValue(), this.f41519e.D().a().apkDetail != null ? this.f41519e.D().a().apkDetail.pkg_source.intValue() : 0), "", 2);
                    ItemClickJumpUtil.itemClickJump(this.f41519e.D().a().forumName, String.valueOf(this.f41519e.D().a().itemId), 3, 3);
                } else if (this.f41519e.getType() == 1281) {
                    TiebaStatic.log(new StatisticItem("common_click").param("page_type", "a005").param(TiebaStatic.Params.GUA_TYPE, 2).param("obj_locate", 16));
                    int a = c.a.s0.s.k0.p.c.a(this.f41519e.A().getItem().button_link_type.intValue(), this.f41519e.A().getItem().apk_detail != null ? this.f41519e.A().getItem().apk_detail.pkg_source.intValue() : 0);
                    ItemData itemData = new ItemData();
                    itemData.parseProto(this.f41519e.A().getItem());
                    ItemCardHelper.q(this.f41520f.getPosition(), this.f41519e.A().getItem().item_id.longValue(), this.f41520f.getButtonState(itemData), this.f41521g.a0, a, "", 2);
                    ItemClickJumpUtil.itemClickJump(this.f41519e.A().getItemForumName(), this.f41519e.A().getItemID(), 3, 3);
                }
            }
        }
    }

    /* loaded from: classes11.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
                    this.a.Q = true;
                } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                    this.a.Q = false;
                }
            }
        }
    }

    /* loaded from: classes11.dex */
    public class d extends c.a.d.f.l.c<c.a.d.n.d.a> {
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
        public void onLoaded(c.a.d.n.d.a aVar, String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, str, i2) == null) {
                this.a.B(aVar);
            }
        }
    }

    /* loaded from: classes11.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbRichTextView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(TbRichTextView tbRichTextView, int i2) {
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
            this.a = tbRichTextView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int contentSize;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                if (this.a.M) {
                    contentSize = TbConfig.getOutterSubpbContentSize();
                } else {
                    contentSize = TbConfig.getContentSize();
                }
                if (this.a.H != null && !ListUtils.isEmpty(this.a.H.y())) {
                    Iterator<TbRichTextData> it = this.a.H.y().iterator();
                    while (it.hasNext()) {
                        TbRichTextData next = it.next();
                        if (next != null) {
                            next.Q(contentSize, contentSize);
                        }
                    }
                }
                this.a.setTextSize(contentSize);
            }
        }
    }

    /* loaded from: classes11.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
                    if (c.a.s0.s.k.c().g()) {
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
                    foreDrawableImageView.stopLoading();
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
                boolean g2 = c.a.s0.s.k.c().g();
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

    /* loaded from: classes11.dex */
    public class g extends c.a.t0.t2.a<ImageView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TbRichTextView f41522e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(TbRichTextView tbRichTextView, c.a.d.f.k.c cVar, int i2, int i3) {
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
                    super((c.a.d.f.k.c) objArr2[0], ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f41522e = tbRichTextView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.t0.t2.a
        /* renamed from: i */
        public ImageView h(Object obj) {
            InterceptResult invokeL;
            ImageView imageView;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
                if (obj instanceof String) {
                    Iterator it = this.f2951c.iterator();
                    while (it.hasNext()) {
                        imageView = (ImageView) it.next();
                        if ((imageView instanceof TbImageView) && obj.equals(((TbImageView) imageView).getUrl())) {
                            break;
                        }
                    }
                }
                imageView = null;
                this.f2951c.remove(imageView);
                return imageView;
            }
            return (ImageView) invokeL.objValue;
        }
    }

    /* loaded from: classes11.dex */
    public class h extends c.a.s0.f1.n.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbRichTextView l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(TbRichTextView tbRichTextView, int i2, String str) {
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

        @Override // c.a.s0.f1.n.f, android.text.style.ClickableSpan
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

    /* loaded from: classes11.dex */
    public class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TbRichTextView f41523e;

        public i(TbRichTextView tbRichTextView) {
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
            this.f41523e = tbRichTextView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MemeInfo memeInfo;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && this.f41523e.s != null && (view instanceof ImageView)) {
                String str = null;
                Object tag = view.getTag();
                int i2 = 0;
                int i3 = -1;
                if (tag != null && (tag instanceof TbRichText)) {
                    int childCount = this.f41523e.getChildCount();
                    while (i2 < childCount) {
                        i3++;
                        if (view.getParent() == this.f41523e.getChildAt(i2)) {
                            break;
                        }
                        i2++;
                    }
                    this.f41523e.s.a(view, null, i3, this.f41523e.N, false);
                    return;
                }
                if (tag != null && (tag instanceof String)) {
                    str = (String) tag;
                } else {
                    boolean z = view instanceof TbImageView;
                    if (z && (view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextMemeInfo)) {
                        TbRichTextMemeInfo tbRichTextMemeInfo = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                        String str2 = (tbRichTextMemeInfo == null || (memeInfo = tbRichTextMemeInfo.memeInfo) == null) ? "" : memeInfo.pic_url;
                        int childCount2 = this.f41523e.getChildCount();
                        while (i2 < childCount2) {
                            i3++;
                            if (view.getParent() == this.f41523e.getChildAt(i2)) {
                                break;
                            }
                            i2++;
                        }
                        this.f41523e.s.a(view, str2, i3, this.f41523e.N, false);
                        return;
                    } else if (z) {
                        str = ((TbImageView) view).getUrl();
                    } else if (view instanceof GifView) {
                        str = ((GifView) view).getUrl();
                    }
                }
                String str3 = str;
                int childCount3 = this.f41523e.getChildCount();
                while (i2 < childCount3) {
                    View childAt = this.f41523e.getChildAt(i2);
                    if (this.f41523e.Q(childAt)) {
                        i3++;
                    }
                    if (view == childAt) {
                        break;
                    }
                    i2++;
                }
                this.f41523e.s.a(view, str3, i3, this.f41523e.N, false);
            }
        }
    }

    /* loaded from: classes11.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbRichTextView;
        }

        @Override // c.a.t0.t2.s.c.a
        public boolean a(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                return false;
            }
            return invokeLL.booleanValue;
        }

        @Override // c.a.t0.t2.s.c.a
        public boolean b(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, motionEvent)) == null) {
                if (this.a.e0 != null) {
                    this.a.e0.onClick(view);
                    return true;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }

        @Override // c.a.t0.t2.s.c.a
        public boolean c(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view, motionEvent)) == null) {
                if (this.a.t != null) {
                    this.a.t.a(view);
                    return this.a.t.onDoubleTap(motionEvent);
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes11.dex */
    public class k implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TbRichTextView f41524e;

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
            this.f41524e = tbRichTextView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && this.f41524e.u != null && (view instanceof TbImageView)) {
                String str = null;
                Object tag = view.getTag();
                if (tag != null && (tag instanceof u)) {
                    str = ((u) tag).a;
                }
                this.f41524e.u.a(view, str);
            }
        }
    }

    /* loaded from: classes11.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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

    /* loaded from: classes11.dex */
    public class m implements ViewGroup.OnHierarchyChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TbRichTextView f41525e;

        public m(TbRichTextView tbRichTextView) {
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
            this.f41525e = tbRichTextView;
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
                    if (!(tag instanceof t) || !((t) tag).a) {
                        if (this.f41525e.l != null) {
                            this.f41525e.l.e((GifView) view2);
                        }
                    } else {
                        if (this.f41525e.f41511f == null) {
                            TbRichTextView tbRichTextView = this.f41525e;
                            tbRichTextView.f41511f = tbRichTextView.getRecycleImageViewPool();
                        }
                        this.f41525e.f41511f.e((ImageView) view2);
                    }
                } else if (view2 instanceof ImageView) {
                    Object tag2 = view2.getTag(R.id.tag_rich_text_view_recycle);
                    if (!(tag2 instanceof t) || !((t) tag2).a) {
                        if (this.f41525e.f41512g != null) {
                            this.f41525e.f41512g.e((ImageView) view2);
                        }
                    } else {
                        if (this.f41525e.f41511f == null) {
                            TbRichTextView tbRichTextView2 = this.f41525e;
                            tbRichTextView2.f41511f = tbRichTextView2.getRecycleImageViewPool();
                        }
                        this.f41525e.f41511f.e((ImageView) view2);
                    }
                } else if ((view2 instanceof TextView) && this.f41525e.f41513h != null) {
                    this.f41525e.f41513h.e((TextView) view2);
                } else if ((view2 instanceof PlayVoiceBnt) && this.f41525e.f41514i != null) {
                    this.f41525e.f41514i.e(view2);
                } else if ((view2 instanceof PlayVoiceBntNew) && this.f41525e.f41514i != null) {
                    this.f41525e.f41514i.e(view2);
                } else if (view2 instanceof GridImageLayout) {
                    GridImageLayout gridImageLayout = (GridImageLayout) view2;
                    int childCount = gridImageLayout.getChildCount();
                    for (int i2 = 0; i2 < childCount; i2++) {
                        View childAt = gridImageLayout.getChildAt(i2);
                        if ((childAt instanceof GifView) && this.f41525e.l != null) {
                            this.f41525e.l.e((GifView) childAt);
                        } else if ((childAt instanceof ImageView) && this.f41525e.f41512g != null) {
                            this.f41525e.f41512g.e((ImageView) childAt);
                        }
                    }
                    gridImageLayout.removeAllViews();
                    gridImageLayout.clearData();
                } else if ((view2 instanceof TiebaPlusRecommendCard) && this.f41525e.m != null) {
                    this.f41525e.m.e((TiebaPlusRecommendCard) view2);
                } else if ((view2 instanceof RelativeLayout) && this.f41525e.k != null) {
                    this.f41525e.k.e((RelativeLayout) view2);
                } else if ((view2 instanceof ItemCardView) && this.f41525e.o != null) {
                    this.f41525e.o.e((ItemCardView) view2);
                }
                if (!(view2 instanceof LinearLayout) || (view2 instanceof ItemCardView)) {
                    return;
                }
                Object tag3 = view2.getTag();
                if (tag3 == null || !(tag3 instanceof String) || !"VideoView".equals(tag3)) {
                    if (this.f41525e.f41515j != null) {
                        LinearLayout linearLayout = (LinearLayout) view2;
                        int childCount2 = linearLayout.getChildCount();
                        for (int i3 = 0; i3 < childCount2; i3++) {
                            View childAt2 = linearLayout.getChildAt(i3);
                            if (childAt2 != null) {
                                if ((childAt2 instanceof TextView) && this.f41525e.f41513h != null) {
                                    this.f41525e.f41513h.e((TextView) childAt2);
                                } else if ((childAt2 instanceof PlayVoiceBnt) && this.f41525e.f41514i != null) {
                                    this.f41525e.f41514i.e(childAt2);
                                } else if ((childAt2 instanceof PlayVoiceBntNew) && this.f41525e.f41514i != null) {
                                    this.f41525e.f41514i.e(childAt2);
                                }
                            }
                        }
                        linearLayout.removeAllViews();
                        this.f41525e.f41515j.e(linearLayout);
                        return;
                    }
                    return;
                }
                view2.setBackgroundDrawable(null);
            }
        }
    }

    /* loaded from: classes11.dex */
    public class n implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TbRichTextData f41526e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ TbRichTextView f41527f;

        public n(TbRichTextView tbRichTextView, TbRichTextData tbRichTextData) {
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
            this.f41527f = tbRichTextView;
            this.f41526e = tbRichTextData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f41526e.G() == null) {
                return;
            }
            if (this.f41527f.getContext() instanceof c.a.s0.f1.n.i) {
                ((c.a.s0.f1.n.i) this.f41527f.getContext()).onVideoClicked(this.f41527f.getContext(), this.f41526e.G().toString());
                return;
            }
            c.a.d.a.f<?> a = c.a.d.a.j.a(this.f41527f.getContext());
            if (a == null || !(a.getOrignalPage() instanceof c.a.s0.f1.n.i)) {
                return;
            }
            ((c.a.s0.f1.n.i) a.getOrignalPage()).onVideoClicked(this.f41527f.getContext(), this.f41526e.G().toString());
        }
    }

    /* loaded from: classes11.dex */
    public class o implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TbRichTextView f41528e;

        public o(TbRichTextView tbRichTextView) {
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
            this.f41528e = tbRichTextView;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f41528e.b0();
                this.f41528e.U.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        }
    }

    /* loaded from: classes11.dex */
    public class p implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TbRichTextView f41529e;

        public p(TbRichTextView tbRichTextView) {
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
            this.f41529e = tbRichTextView;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f41529e.Y();
                this.f41529e.U.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        }
    }

    /* loaded from: classes11.dex */
    public class q implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TbRichTextView f41530e;

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
            this.f41530e = tbRichTextView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && !this.f41530e.Q && this.f41530e.performLongClick()) {
                this.f41530e.D = true;
            }
        }
    }

    /* loaded from: classes11.dex */
    public static class r {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;

        public r() {
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

        public /* synthetic */ r(h hVar) {
            this();
        }
    }

    /* loaded from: classes11.dex */
    public interface s {
        void decorateText(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView);
    }

    /* loaded from: classes11.dex */
    public static class t {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;

        public t() {
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

        public /* synthetic */ t(h hVar) {
            this();
        }
    }

    /* loaded from: classes11.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
        }
    }

    /* loaded from: classes11.dex */
    public interface v {
        void a();
    }

    /* loaded from: classes11.dex */
    public interface w {
        void dispatchTouchEvent(MotionEvent motionEvent);
    }

    /* loaded from: classes11.dex */
    public interface x {
        void a(View view, String str, String str2, String str3, String str4, String str5, String str6, int i2, int i3);
    }

    /* loaded from: classes11.dex */
    public interface y {
        void a(View view, String str, int i2, boolean z, boolean z2);
    }

    /* loaded from: classes11.dex */
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
        t0 = c.a.d.f.p.n.h(TbadkCoreApplication.getInst());
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
        this.f41510e = new c.a.s0.f1.n.a();
        this.f41511f = null;
        this.f41512g = null;
        this.f41513h = null;
        this.f41514i = null;
        this.f41515j = null;
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
        this.b0 = new h(this, 2, null);
        this.e0 = new i(this);
        this.f0 = new c.a.t0.t2.s.c(new j(this));
        this.mOnClickListenerForLinkImage = new k(this);
        this.g0 = new c(this);
        this.r0 = new d(this);
        this.s0 = new e(this, 2004018);
        F();
    }

    public static c.a.d.f.k.b<TextView> createTextViewPool(Context context, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65543, null, context, i2)) == null) ? new c.a.d.f.k.b<>(new l(context), i2, 0) : (c.a.d.f.k.b) invokeLI.objValue;
    }

    private GifView getGifView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, this)) == null) {
            c.a.d.f.k.b<GifView> bVar = this.l;
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
            this.n.setLayoutStrategy(this.f41510e);
            this.n.setObjectPool(this.f41512g, this.l);
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

    private ImageView getImageView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, this)) == null) {
            c.a.d.f.k.b<ImageView> bVar = this.f41512g;
            ImageView imageView = null;
            ImageView b2 = bVar != null ? bVar.b() : null;
            if (b2 != null && b2.getParent() == null) {
                imageView = b2;
            }
            if (imageView != null) {
                imageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.editor_image));
            }
            return imageView;
        }
        return (ImageView) invokeV.objValue;
    }

    private ItemCardView getItemCardView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65551, this)) == null) {
            c.a.d.f.k.b<ItemCardView> bVar = this.o;
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
        if (interceptable == null || (invokeV = interceptable.invokeV(65552, this)) == null) {
            LinearLayout b2 = this.f41515j.b();
            if (b2 != null) {
                TextView C = C(getContext());
                if (C == null) {
                    this.f41515j.e(b2);
                    return null;
                }
                b2.addView(C);
                View E = E(null);
                if (E == null) {
                    this.f41513h.e(C);
                    this.f41515j.e(b2);
                    return null;
                }
                b2.addView(E);
            }
            return b2;
        }
        return (View) invokeV.objValue;
    }

    public static TbRichText parse(JSONArray jSONArray, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65562, null, jSONArray, i2)) == null) ? new TbRichText(jSONArray, i2) : (TbRichText) invokeLI.objValue;
    }

    public static TbRichText parser(List<PbContent> list, boolean z2) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(65566, null, list, z2)) == null) ? new TbRichText(list, null, z2) : (TbRichText) invokeLZ.objValue;
    }

    private void setFaceSize(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(65571, this, f2) == null) {
            if (this.V && c.a.s0.b.d.e0()) {
                int emotionContentSizeOfLzl = this.M ? TbConfig.getEmotionContentSizeOfLzl() : TbConfig.getEmotionContentSize();
                c.a.s0.f1.n.a aVar = this.f41510e;
                aVar.f12754g = emotionContentSizeOfLzl;
                aVar.f12755h = emotionContentSizeOfLzl;
                return;
            }
            c.a.s0.f1.n.a aVar2 = this.f41510e;
            int i2 = (int) f2;
            aVar2.f12754g = i2;
            aVar2.f12755h = i2;
        }
    }

    public final void B(c.a.d.n.d.a aVar) {
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
            v vVar = this.d0;
            if (vVar != null) {
                vVar.a();
            }
        } catch (Exception unused) {
        }
    }

    public final TextView C(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            c.a.d.f.k.b<TextView> bVar = this.f41513h;
            TextView b2 = bVar != null ? bVar.b() : null;
            if (b2 == null || b2.getParent() != null) {
                b2 = new TbListTextView(context);
            }
            int i2 = this.f41510e.f12750c;
            b2.setPadding(i2, 0, i2, 0);
            return b2;
        }
        return (TextView) invokeL.objValue;
    }

    public final LinearLayout D(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, tbRichTextData)) == null) {
            if (this.f41510e.m <= 0 || tbRichTextData == null) {
                return null;
            }
            LinearLayout linearLayout = new LinearLayout(getContext());
            linearLayout.setTag("VideoView");
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.topMargin = this.f41510e.f12751d;
            linearLayout.setClickable(true);
            Bitmap bitmap = SkinManager.getBitmap(this.f41510e.m);
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

    public final View E(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, view)) == null) {
            c.a.d.f.k.b<View> bVar = this.f41514i;
            View b2 = bVar != null ? bVar.b() : null;
            if ((b2 == null || b2.getParent() != null) && this.A != -1) {
                b2 = LayoutInflater.from(getContext()).inflate(this.A, (ViewGroup) null);
            }
            if (b2 != null) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                if (view instanceof TbListTextView) {
                    layoutParams.topMargin = this.f41510e.v;
                } else {
                    layoutParams.topMargin = this.f41510e.f12751d;
                }
                layoutParams.bottomMargin = this.f41510e.A;
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

    public final void F() {
        c.a.s0.f1.n.i iVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            c.a.d.a.f<?> a2 = c.a.d.a.j.a(getContext());
            if (getContext() instanceof c.a.s0.f1.n.i) {
                iVar = (c.a.s0.f1.n.i) getContext();
            } else {
                iVar = (a2 == null || !(a2.getOrignalPage() instanceof c.a.s0.f1.n.i)) ? null : (c.a.s0.f1.n.i) a2.getOrignalPage();
            }
            if (iVar == null && (getContext() instanceof BaseFragmentActivity)) {
                List<Fragment> fragments = ((BaseFragmentActivity) getContext()).getSupportFragmentManager().getFragments();
                if (!ListUtils.isEmpty(fragments) && (fragments.get(0) instanceof c.a.s0.f1.n.i)) {
                    iVar = (c.a.s0.f1.n.i) fragments.get(0);
                }
            }
            if (a2 != null) {
                a2.registerListener(this.s0);
            }
            if (iVar != null) {
                this.f41512g = iVar.getImageViewPool();
                this.f41513h = iVar.getTextViewPool();
                this.f41514i = iVar.getVoiceViewPool();
                this.f41515j = iVar.getTextVoiceViewPool();
                this.l = iVar.getGifViewPool();
                this.m = iVar.getTiejiaRecommendPool();
                this.k = iVar.getRelativeLayoutPool();
                this.o = iVar.getItemCardViewPool();
                if (iVar.getListView() != null && this.r == null) {
                    this.r = new a0(iVar.getRichTextViewId());
                    iVar.getListView().setRecyclerListener(this.r);
                }
            }
            this.T = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds21);
            setOrientation(1);
            setOnHierarchyChangeListener(new m(this));
        }
    }

    public final void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            setFaceSize(this.M ? TbConfig.getContentSizeOfLzl() : TbConfig.getContentSize());
        }
    }

    public final boolean H(TbRichTextData tbRichTextData, GifView gifView) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, tbRichTextData, gifView)) == null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) gifView.getLayoutParams();
            if (layoutParams != null && layoutParams.width == tbRichTextData.z().mGifInfo.mGifWidth && layoutParams.height == tbRichTextData.z().mGifInfo.mGifHeight) {
                layoutParams.bottomMargin = 0;
            } else {
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(tbRichTextData.z().mGifInfo.mGifWidth, tbRichTextData.z().mGifInfo.mGifHeight);
                layoutParams2.gravity = 3;
                gifView.setLayoutParams(layoutParams2);
            }
            gifView.setOnClickListener(new a(this, tbRichTextData));
            gifView.startLoad(tbRichTextData.z().mGifInfo);
            return true;
        }
        return invokeLL.booleanValue;
    }

    public final boolean I(TbRichTextData tbRichTextData, ImageView imageView, int i2, int i3, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{tbRichTextData, imageView, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z2)})) == null) {
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
                if (this.f41510e.q) {
                    tbImageView.setSupportNoImage(true);
                }
                String w2 = this.f41510e.c() ? tbRichTextData.C().w() : tbRichTextData.C().y();
                if (!z2 || tbImageView.getUrl() == null || !tbImageView.getUrl().equals(w2)) {
                    tbImageView.startLoad(w2, this.z ? 17 : 18, false);
                }
                if (!tbRichTextData.C().C()) {
                    tbImageView.setAdjustViewBounds(false);
                }
                tbImageView.setTag(R.id.tag_rich_text_meme_info, null);
            }
            return W(imageView, tbRichTextData.C().getWidth(), tbRichTextData.C().getHeight(), i2, i3, this.e0);
        }
        return invokeCommon.booleanValue;
    }

    public final boolean J(ItemCardView itemCardView, TbRichTextData tbRichTextData) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, itemCardView, tbRichTextData)) == null) {
            if (tbRichTextData != null) {
                if (tbRichTextData.D() == null && tbRichTextData.A() == null) {
                    return false;
                }
                if (tbRichTextData.getType() == 37) {
                    itemCardView.setPosition(9);
                } else if (tbRichTextData.getType() == 1281) {
                    itemCardView.setPosition(4);
                }
                itemCardView.setOnClickListener(new b(this, tbRichTextData, itemCardView));
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

    public final boolean K(TbRichTextData tbRichTextData, ImageView imageView, int i2, int i3) {
        InterceptResult invokeLLII;
        TbRichTextLinkImageInfo E;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(1048585, this, tbRichTextData, imageView, i2, i3)) == null) {
            if (tbRichTextData == null || imageView == null || (E = tbRichTextData.E()) == null || E.getLink() == null) {
                return false;
            }
            if (imageView instanceof TbImageView) {
                TbImageView tbImageView = (TbImageView) imageView;
                if (this.f41510e.q) {
                    tbImageView.setSupportNoImage(true);
                }
                tbImageView.startLoad(E.w(), this.z ? 17 : 18, false);
                tbImageView.setTag(new u(E.getLink()));
                if (!E.x()) {
                    tbImageView.setAdjustViewBounds(false);
                }
            }
            return X(imageView, E.getWidth(), E.getHeight(), i2, i3, this.mOnClickListenerForLinkImage);
        }
        return invokeLLII.booleanValue;
    }

    public final boolean L(TbRichTextData tbRichTextData, ImageView imageView, int i2, int i3) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(1048586, this, tbRichTextData, imageView, i2, i3)) == null) {
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
                if (this.f41510e.q) {
                    tbImageView.setSupportNoImage(true);
                }
                tbImageView.startLoad(tbRichTextData.F().memeInfo.pic_url, this.z ? 17 : 18, false);
                tbImageView.setAdjustViewBounds(false);
                tbImageView.setTag(R.id.tag_rich_text_meme_info, tbRichTextData.F());
            }
            return X(imageView, tbRichTextData.F().memeInfo.width.intValue(), tbRichTextData.F().memeInfo.height.intValue(), i2, i3, this.e0);
        }
        return invokeLLII.booleanValue;
    }

    public final boolean M(TbRichTextData tbRichTextData, GifView gifView, boolean z2) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048587, this, tbRichTextData, gifView, z2)) == null) {
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
                c.a.s0.f1.n.a aVar = this.f41510e;
                if (aVar.F) {
                    z3 = aVar.r ? tbRichTextData.C().w() : tbRichTextData.C().x();
                }
                if (StringUtils.isNull(z3)) {
                    z3 = this.f41510e.r ? tbRichTextData.C().y() : tbRichTextData.C().B();
                }
            }
            gifView.setShowStaticDrawable(false);
            if (!z2 || gifView.getUrl() == null || !gifView.getUrl().equals(z3)) {
                gifView.startLoad(z3, 38);
            }
            int width = tbRichTextData.C().getWidth();
            int height = tbRichTextData.C().getHeight();
            c.a.s0.f1.n.a aVar2 = this.f41510e;
            return W(gifView, width, height, aVar2.f12757j, aVar2.k, this.e0);
        }
        return invokeLLZ.booleanValue;
    }

    public final boolean N(TbRichTextData tbRichTextData, TextView textView, boolean z2, s sVar) {
        InterceptResult invokeCommon;
        LinearLayout.LayoutParams layoutParams;
        SpannableStringBuilder G;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048588, this, new Object[]{tbRichTextData, textView, Boolean.valueOf(z2), sVar})) == null) {
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
                layoutParams.topMargin = this.f41510e.f12751d;
            }
            c.a.s0.f1.n.a aVar = this.f41510e;
            textView.setLineSpacing(aVar.f12749b, aVar.a);
            textView.setTextSize(0, this.f41510e.f12752e);
            if (this.f41510e.f12753f) {
                c.a.s0.s.u.c.d(textView).A(R.string.F_X02);
            }
            textView.setTextColor(this.f41510e.f12756i);
            textView.setLinkTextColor(SkinManager.getColor(R.color.CAM_X0304));
            textView.setHighlightColor(getContext().getResources().getColor(R.color.transparent));
            textView.setSingleLine(this.f41510e.n);
            if (this.O) {
                a0();
            }
            if (this.P) {
                Z();
            }
            TextUtils.TruncateAt truncateAt = this.q;
            if (truncateAt != null) {
                textView.setEllipsize(truncateAt);
            }
            if (this.hasShadow) {
                c.a.s0.s.u.c.d(textView).y(R.array.S_O_X001);
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
            c.a.s0.f1.n.a aVar2 = this.f41510e;
            int i5 = aVar2.f12755h;
            if (i5 > 0 && (i2 = aVar2.f12754g) > 0) {
                tbRichTextData.Q(i2, i5);
            }
            if (sVar != null) {
                sVar.decorateText(G, textView, this);
            }
            try {
                textView.setText(G);
            } catch (Exception unused) {
                textView.setText("");
            }
            if (this.L) {
                if (tbRichTextData.N()) {
                    textView.setMovementMethod(c.a.t0.n4.b.a());
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
            tbRichTextData.I().needRecompute = this.h0;
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public final boolean O(TbRichTextData tbRichTextData, LinearLayout linearLayout, s sVar) {
        InterceptResult invokeLLL;
        boolean P;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048589, this, tbRichTextData, linearLayout, sVar)) == null) {
            if (linearLayout == null) {
                return false;
            }
            int childCount = linearLayout.getChildCount();
            boolean z2 = true;
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = linearLayout.getChildAt(i2);
                if (childAt != null) {
                    if (childAt instanceof TextView) {
                        P = N(tbRichTextData, (TextView) childAt, false, sVar);
                    } else if (childAt.getClass().getSimpleName().equals("PlayVoiceBnt")) {
                        P = P(tbRichTextData, childAt);
                    } else if (childAt.getClass().getSimpleName().equals("PlayVoiceBntNew")) {
                        P = P(tbRichTextData, childAt);
                    }
                    z2 &= P;
                }
            }
            return z2;
        }
        return invokeLLL.booleanValue;
    }

    public final boolean P(TbRichTextData tbRichTextData, View view) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048590, this, tbRichTextData, view)) == null) {
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

    public final boolean Q(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, view)) == null) {
            if (view instanceof ImageView) {
                if (view instanceof GifView) {
                    return view.getTag(R.id.tag_rich_text_view_gif_view) != null && (view.getTag(R.id.tag_rich_text_view_gif_view) instanceof r) && ((r) view.getTag(R.id.tag_rich_text_view_gif_view)).a;
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

    public final void R() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.D = false;
            if (this.E == null) {
                this.E = new q(this);
            }
            postDelayed(this.E, ViewConfiguration.getLongPressTimeout());
        }
    }

    public final void S() {
        Runnable runnable;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (runnable = this.E) == null) {
            return;
        }
        removeCallbacks(runnable);
    }

    public final void T(RelativeLayout relativeLayout, int i2, int i3, int i4, int i5) {
        int[] l2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{relativeLayout, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) || (l2 = c.a.d.f.p.n.l(i2, i3, i4, i5)) == null) {
            return;
        }
        int[] iArr = {l2[0], l2[1]};
        int i6 = iArr[0];
        int i7 = iArr[1];
        if (this.f41510e.s && i4 > i6) {
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
    public final void U(RelativeLayout relativeLayout, int i2, int i3, int i4, int i5) {
        int[] l2;
        int i6;
        int i7;
        int f2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048595, this, new Object[]{relativeLayout, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) || (l2 = c.a.d.f.p.n.l(i2, i3, i4, i5)) == null) {
            return;
        }
        int[] iArr = {l2[0], l2[1]};
        int i8 = iArr[0];
        int i9 = iArr[1];
        if (this.f41510e.s && i4 > i8) {
            float f3 = t0;
            if (f3 > 1.0f) {
                float f4 = i8;
                float f5 = i4;
                if (f4 * f3 > f5) {
                    i7 = i4 - c.a.d.f.p.n.f(getContext(), R.dimen.ds78);
                    f2 = c.a.d.f.p.n.f(getContext(), R.dimen.ds16);
                } else {
                    float f6 = f5 * 0.68f;
                    if (f4 * f3 > f6) {
                        i7 = (int) f6;
                        f2 = c.a.d.f.p.n.f(getContext(), R.dimen.ds78);
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

    public final boolean V(ImageView imageView, int i2, int i3, int i4, int i5, View.OnClickListener onClickListener) {
        InterceptResult invokeCommon;
        View.OnLongClickListener onLongClickListener;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048596, this, new Object[]{imageView, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), onClickListener})) == null) {
            int[] l2 = c.a.d.f.p.n.l(i2, i3, i4, i5);
            if (l2 == null) {
                return false;
            }
            int[] iArr = {l2[0], l2[1]};
            int i6 = iArr[0];
            int i7 = iArr[1];
            if (this.f41510e.s && i4 > i6) {
                float f2 = t0;
                if (f2 > 1.0f) {
                    float f3 = i6;
                    float f4 = i4;
                    if (f3 * f2 > f4) {
                        i6 = (i4 - c.a.d.f.p.n.f(getContext(), R.dimen.ds78)) - c.a.d.f.p.n.f(getContext(), R.dimen.ds16);
                    } else {
                        float f5 = f4 * 0.68f;
                        i6 = f3 * f2 > f5 ? ((int) f5) - c.a.d.f.p.n.f(getContext(), R.dimen.ds78) : (int) (f3 * f2);
                    }
                    if (iArr[0] > 0) {
                        i7 = (iArr[1] * i6) / iArr[0];
                    }
                }
            }
            boolean z2 = imageView instanceof TbImageView;
            if (z2) {
                TbImageView tbImageView = (TbImageView) imageView;
                tbImageView.setDefaultResource(this.f41510e.l);
                if (tbImageView.getGifIconWidth() < i6 && tbImageView.getGifIconHeight() < i7) {
                    tbImageView.setGifIconSupport(true);
                } else {
                    tbImageView.setGifIconSupport(false);
                }
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i6, i7);
            if (this.f41510e.s) {
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            } else {
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            }
            imageView.setClickable(true);
            imageView.setFocusable(false);
            if (this.t != null && z2) {
                ((TbImageView) imageView).setTbGestureDetector(this.f0);
                imageView.setClickable(true);
            } else {
                imageView.setOnClickListener(onClickListener);
            }
            imageView.setLayoutParams(layoutParams);
            if (z2) {
                if (this.c0 != null) {
                    ((TbImageView) imageView).setDispatchTouchListener(this.g0);
                    imageView.setOnLongClickListener(this.c0);
                }
            } else if ((imageView instanceof GifView) && (onLongClickListener = this.c0) != null) {
                imageView.setOnLongClickListener(onLongClickListener);
            }
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public final boolean W(ImageView imageView, int i2, int i3, int i4, int i5, View.OnClickListener onClickListener) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048597, this, new Object[]{imageView, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), onClickListener})) == null) {
            int[] e2 = this.f41510e.e(i2, i3, i4, i5);
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
            c.a.s0.f1.n.a aVar = this.f41510e;
            if (aVar.s) {
                imageView.setScaleType(aVar.p);
                if (z2) {
                    ((TbImageView) imageView).setOnDrawListener(this.f41510e.I);
                }
            } else {
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            }
            imageView.setClickable(true);
            imageView.setFocusable(false);
            if (this.t != null && z2) {
                ((TbImageView) imageView).setTbGestureDetector(this.f0);
                imageView.setClickable(true);
            } else {
                imageView.setOnClickListener(onClickListener);
            }
            imageView.setLayoutParams(layoutParams);
            if (z2) {
                if (this.c0 != null) {
                    ((TbImageView) imageView).setDispatchTouchListener(this.g0);
                    imageView.setOnLongClickListener(this.c0);
                }
            } else if ((imageView instanceof GifView) && this.c0 != null) {
                ((GifView) imageView).setDispatchTouchListener(this.g0);
                imageView.setOnLongClickListener(this.c0);
            }
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public final boolean X(ImageView imageView, int i2, int i3, int i4, int i5, View.OnClickListener onClickListener) {
        InterceptResult invokeCommon;
        View.OnLongClickListener onLongClickListener;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048598, this, new Object[]{imageView, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), onClickListener})) == null) {
            int[] l2 = c.a.d.f.p.n.l(i2, i3, i4, i5);
            if (l2 == null) {
                return false;
            }
            int[] iArr = {l2[0], l2[1]};
            int i6 = iArr[0];
            int i7 = iArr[1];
            if (this.f41510e.s && i4 > i6) {
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
                tbImageView.setDefaultResource(this.f41510e.l);
                if (tbImageView.getGifIconWidth() < i6 && tbImageView.getGifIconHeight() < i7) {
                    tbImageView.setGifIconSupport(true);
                } else {
                    tbImageView.setGifIconSupport(false);
                }
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i6, i7);
            if (this.f41510e.s) {
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            } else {
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            }
            imageView.setClickable(true);
            imageView.setFocusable(false);
            if (this.t != null && z2) {
                ((TbImageView) imageView).setTbGestureDetector(this.f0);
                imageView.setClickable(true);
            } else {
                imageView.setOnClickListener(onClickListener);
            }
            imageView.setLayoutParams(layoutParams);
            if (z2) {
                if (this.c0 != null) {
                    ((TbImageView) imageView).setDispatchTouchListener(this.g0);
                    imageView.setOnLongClickListener(this.c0);
                }
            } else if ((imageView instanceof GifView) && (onLongClickListener = this.c0) != null) {
                imageView.setOnLongClickListener(onLongClickListener);
            }
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public final void Y() {
        TextView textView;
        CharSequence subSequence;
        Object[] spans;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048599, this) == null) || this.K <= 1 || (textView = this.U) == null || textView.getLineCount() <= this.K) {
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

    public final void Z() {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048600, this) == null) || (textView = this.U) == null) {
            return;
        }
        textView.getViewTreeObserver().addOnGlobalLayoutListener(new p(this));
    }

    public final void a0() {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048601, this) == null) || (textView = this.U) == null) {
            return;
        }
        textView.getViewTreeObserver().addOnGlobalLayoutListener(new o(this));
    }

    public final void b0() {
        TextView textView;
        CharSequence text;
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048602, this) == null) || this.K <= 0 || (textView = this.U) == null || textView.getLineCount() <= this.K) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, motionEvent)) == null) {
            this.C = false;
            int action = motionEvent.getAction();
            if ((action == 1 || action == 3) && !this.D) {
                S();
            }
            boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
            if (motionEvent.getAction() == 0 && !this.C) {
                R();
            }
            return dispatchTouchEvent;
        }
        return invokeL.booleanValue;
    }

    public c.a.s0.f1.n.a getLayoutStrategy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.f41510e : (c.a.s0.f1.n.a) invokeV.objValue;
    }

    public y getOnImageClickListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.s : (y) invokeV.objValue;
    }

    public z getOnLinkImageClickListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.u : (z) invokeV.objValue;
    }

    public c.a.t0.t2.a<ImageView> getRecycleImageViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            if (this.f41511f == null) {
                this.f41511f = new g(this, new f(this), 10, 0);
            }
            return this.f41511f;
        }
        return (c.a.t0.t2.a) invokeV.objValue;
    }

    public TbRichText getRichText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.H : (TbRichText) invokeV.objValue;
    }

    public TextView getTextView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.F : invokeV.booleanValue;
    }

    public boolean isDisplayImage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? this.y : invokeV.booleanValue;
    }

    public boolean isFromCDN() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.z : invokeV.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            super.onDetachedFromWindow();
            c.a.s0.f1.n.a aVar = this.f41510e;
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
        if (interceptable == null || (invokeL = interceptable.invokeL(1048614, this, motionEvent)) == null) {
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
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            super.onStartTemporaryDetach();
            stopLoad();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048616, this, motionEvent)) == null) {
            this.C = true;
            return super.onTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048617, this, i2) == null) {
            super.onWindowVisibilityChanged(i2);
            if (i2 != 8 && i2 != 4) {
                refresh();
            } else {
                stopLoad();
            }
        }
    }

    @Override // c.a.d.g.a.h
    public void refresh() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            startLoad(this.k0);
        }
    }

    public void setAddExpandableListener(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048619, this, z2) == null) {
            this.P = z2;
        }
    }

    public void setAddTruncateListener(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048620, this, z2) == null) {
            this.O = z2;
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, drawable) == null) {
            super.setBackgroundDrawable(drawable);
            if (this.i0 != drawable) {
                this.h0 = true;
                this.i0 = drawable;
            }
            setText(this.H);
            this.h0 = false;
        }
    }

    public void setCommonTextViewOnClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, onClickListener) == null) {
            this.v = onClickListener;
        }
    }

    public void setDisplayImage(boolean z2, boolean z3) {
        c.a.d.f.k.b<ImageView> bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048623, this, new Object[]{Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) || this.y == z2) {
            return;
        }
        this.y = z2;
        if (z3) {
            requestLayout();
        }
        if (this.y || (bVar = this.f41512g) == null) {
            return;
        }
        bVar.c();
    }

    public void setDuiEnabled(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048624, this, z2) == null) {
            this.p = z2;
        }
    }

    public void setHasMovementMethod(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048625, this, z2) == null) {
            this.L = z2;
        }
    }

    public void setIsFromCDN(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048626, this, z2) == null) {
            this.z = z2;
            c.a.s0.f1.n.a aVar = this.f41510e;
            if (aVar != null) {
                aVar.r = z2;
            }
        }
    }

    public void setIsHost(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048627, this, z2) == null) {
            this.N = z2;
            GridImageLayout gridImageLayout = this.n;
            if (gridImageLayout != null) {
                gridImageLayout.setIsHost(z2);
            }
        }
    }

    public void setIsNeedResizeEmotion(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048628, this, z2) == null) {
            this.V = z2;
        }
    }

    public void setIsShowOrderOrDownloadBtn(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048629, this, z2) == null) {
            this.W = z2;
        }
    }

    public void setIsUseGridImage(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048630, this, z2) == null) {
            this.R = z2;
        }
    }

    public void setItemOrderOrDownloadListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048631, this, onClickListener) == null) {
            this.x = onClickListener;
        }
    }

    public void setLayoutStrategy(c.a.s0.f1.n.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048632, this, aVar) == null) || aVar == null) {
            return;
        }
        this.f41510e.d();
        this.f41510e = aVar;
        G();
        GridImageLayout gridImageLayout = this.n;
        if (gridImageLayout != null) {
            gridImageLayout.setLayoutStrategy(this.f41510e);
        }
    }

    public void setLinkTextColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048633, this, i2) == null) {
            c.a.s0.f1.n.a aVar = this.f41510e;
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
        if (interceptable == null || interceptable.invokeI(1048634, this, i2) == null) {
            this.K = i2;
            TextView textView = this.U;
            if (textView != null) {
                textView.setMaxLines(i2);
            }
        }
    }

    public void setMaxWidth(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048635, this, i2) == null) {
            this.J = i2;
        }
    }

    public void setOnEmotionClickListener(x xVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048636, this, xVar) == null) {
            this.G = xVar;
        }
    }

    public void setOnImageClickListener(y yVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048637, this, yVar) == null) {
            this.s = yVar;
            GridImageLayout gridImageLayout = this.n;
            if (gridImageLayout != null) {
                gridImageLayout.setOnImageClickListener(yVar);
            }
        }
    }

    public void setOnImageTouchListener(c.a.t0.t2.s.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048638, this, cVar) == null) {
            this.t = cVar;
        }
    }

    public void setOnLinkImageClickListener(z zVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048639, this, zVar) == null) {
            this.u = zVar;
        }
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048640, this, onLongClickListener) == null) {
            this.c0 = onLongClickListener;
            super.setOnLongClickListener(onLongClickListener);
        }
    }

    public void setOnVoiceAfterClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048641, this, onClickListener) == null) {
            this.B = onClickListener;
        }
    }

    public void setSubPbPost(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048642, this, z2) == null) {
            this.M = z2;
            G();
        }
    }

    public void setText(TbRichText tbRichText) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048643, this, tbRichText) == null) {
            setText(tbRichText, false);
        }
    }

    public void setTextBold() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048647, this) == null) {
            this.f41510e.f12753f = true;
        }
    }

    public void setTextCenter(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048648, this, z2) == null) {
            this.I = z2;
        }
    }

    public void setTextColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048649, this, i2) == null) {
            c.a.s0.f1.n.a aVar = this.f41510e;
            if (i2 == aVar.f12756i) {
                return;
            }
            aVar.f12756i = i2;
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
        if (interceptable == null || interceptable.invokeL(1048650, this, truncateAt) == null) {
            this.q = truncateAt;
            TextView textView = this.U;
            if (textView != null) {
                textView.setEllipsize(truncateAt);
            }
        }
    }

    public void setTextPadding(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048651, this, i2) == null) {
            c.a.s0.f1.n.a aVar = this.f41510e;
            if (aVar.f12750c == i2) {
                return;
            }
            aVar.f12750c = i2;
            int childCount = getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                if (childAt != null && (childAt instanceof TextView)) {
                    int i4 = this.f41510e.f12750c;
                    ((TextView) childAt).setPadding(i4, 0, 0, i4);
                }
            }
        }
    }

    public void setTextSize(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048652, this, f2) == null) {
            setFaceSize(f2);
            c.a.s0.f1.n.a aVar = this.f41510e;
            if (f2 == aVar.f12752e) {
                return;
            }
            aVar.f12752e = f2;
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
        if (interceptable == null || interceptable.invokeZ(1048653, this, z2) == null) {
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
        if (interceptable == null || interceptable.invokeL(1048654, this, onClickListener) == null) {
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
        if (interceptable == null || interceptable.invokeL(1048655, this, onTouchListener) == null) {
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
        if (interceptable == null || interceptable.invokeL(1048656, this, str) == null) {
            this.a0 = str;
        }
    }

    public void setVoiceViewRes(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048657, this, i2) == null) {
            this.A = i2;
        }
    }

    public void setmGridEmptyClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048658, this, onClickListener) == null) {
            this.w = onClickListener;
        }
    }

    public void setmIsGridImageSupportLongPress(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048659, this, z2) == null) {
            this.S = z2;
        }
    }

    public void startLoad(String str, v vVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048661, this, str, vVar) == null) {
            this.d0 = vVar;
            startLoad(str);
        }
    }

    public void stopLoad() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048662, this) == null) || TextUtils.isEmpty(this.k0)) {
            return;
        }
        c.a.d.f.l.d.h().d(this.k0, 19, this.r0);
        setBackgroundDrawable(null);
    }

    public static TbRichText parse(JSONArray jSONArray, boolean z2) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(65563, null, jSONArray, z2)) == null) ? new TbRichText(jSONArray, z2) : (TbRichText) invokeLZ.objValue;
    }

    public static TbRichText parser(List<PbContent> list, boolean z2, @NonNull e2 e2Var) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65567, null, new Object[]{list, Boolean.valueOf(z2), e2Var})) == null) ? new TbRichText(list, null, z2, null, e2Var, -1) : (TbRichText) invokeCommon.objValue;
    }

    public void setText(TbRichText tbRichText, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048644, this, tbRichText, z2) == null) {
            setText(tbRichText, z2, null);
        }
    }

    public static TbRichText parser(List<PbContent> list, String str, boolean z2) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65564, null, list, str, z2)) == null) ? parser(list, str, z2, null, null, -1) : (TbRichText) invokeLLZ.objValue;
    }

    public void setText(TbRichText tbRichText, boolean z2, s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048645, this, new Object[]{tbRichText, Boolean.valueOf(z2), sVar}) == null) {
            setText(tbRichText, z2, sVar, false, false);
        }
    }

    public void startLoad(String str) {
        BdUniqueId bdUniqueId;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048660, this, str) == null) {
            if (TextUtils.isEmpty(str)) {
                this.k0 = str;
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
            if (!(str.equals(this.k0) && this.q0 == bdUniqueId)) {
                stopLoad();
            }
            this.k0 = str;
            this.q0 = bdUniqueId;
            setBackgroundDrawable(null);
            c.a.d.n.d.a aVar = (c.a.d.n.d.a) c.a.d.f.l.d.h().n(this.k0, 19, new Object[0]);
            if (aVar != null) {
                B(aVar);
            } else if (z2) {
                invalidate();
            } else if (!c.a.d.f.l.d.h().j(19)) {
                invalidate();
            } else {
                c.a.d.f.l.d.h().k(this.k0, 19, this.r0, 0, 0, this.q0, new Object[0]);
            }
        }
    }

    public static TbRichText parser(List<PbContent> list, String str, boolean z2, @Nullable PostData postData, @Nullable e2 e2Var, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65565, null, new Object[]{list, str, Boolean.valueOf(z2), postData, e2Var, Integer.valueOf(i2)})) == null) ? new TbRichText(list, str, z2, postData, e2Var, i2) : (TbRichText) invokeCommon.objValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:267:0x0037 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:269:0x0037 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:191:0x04de A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:201:0x0500  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x051a  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0134  */
    /* JADX WARN: Type inference failed for: r0v123, types: [com.baidu.tbadk.gif.GifView, android.view.View] */
    /* JADX WARN: Type inference failed for: r0v151 */
    /* JADX WARN: Type inference failed for: r10v13, types: [android.widget.ImageView] */
    /* JADX WARN: Type inference failed for: r13v5 */
    /* JADX WARN: Type inference failed for: r26v0, types: [android.widget.LinearLayout, com.baidu.tbadk.widget.richText.TbRichTextView, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v74, types: [android.widget.ImageView] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void setText(TbRichText tbRichText, boolean z2, s sVar, boolean z3, boolean z4) {
        ArrayList<TbRichTextData> y2;
        c.a.t0.t2.a<ImageView> aVar;
        int i2;
        boolean N;
        SpannableStringBuilder G;
        TbRichTextData tbRichTextData;
        int i3;
        GridImageLayout gridImageLayout;
        TextView textView;
        int i4;
        int i5;
        c.a.d.f.k.b<TiebaPlusRecommendCard> bVar;
        ItemCardView itemCardView;
        RelativeLayout relativeLayout;
        RelativeLayout relativeLayout2;
        int i6;
        GifView gifView;
        Object imageView;
        boolean z5;
        boolean z6;
        Object obj;
        boolean z7;
        GifView gifView2;
        GifView gifView3;
        Object obj2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048646, this, new Object[]{tbRichText, Boolean.valueOf(z2), sVar, Boolean.valueOf(z3), Boolean.valueOf(z4)}) == null) {
            s sVar2 = sVar;
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
                h hVar = null;
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
                            TextView C = C(getContext());
                            N = N(next, C, z8, sVar2);
                            if (z2 && !this.F && (G = next.G()) != null) {
                                this.F = G.length() >= 200;
                            }
                            TiePlusEventController.tryExposeTiePlusLinkEvent(next.J());
                            if (this.t != null) {
                                C.setOnTouchListener(this.f0);
                                textView = C;
                            } else {
                                C.setOnClickListener(this.v);
                                textView = C;
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
                                    N = true;
                                    z9 = true;
                                    gridImageLayout = gridImageView;
                                }
                            } else if (i8 < 10) {
                                i8++;
                                if (next.C() == null) {
                                    tbRichTextData = next;
                                    N = false;
                                    gridImageLayout = tiebaPlusRecommendCard;
                                } else if (TbadkCoreApplication.getInst().isGifAutoPlay() && !next.C().E()) {
                                    if (z4) {
                                        String z11 = next.C().z();
                                        if (StringUtils.isNull(z11)) {
                                            c.a.s0.f1.n.a aVar2 = this.f41510e;
                                            if (aVar2.F) {
                                                z11 = aVar2.r ? next.C().w() : next.C().x();
                                            }
                                            if (StringUtils.isNull(z11)) {
                                                z11 = this.f41510e.r ? next.C().y() : next.C().B();
                                            }
                                        }
                                        c.a.t0.t2.a<ImageView> aVar3 = this.f41511f;
                                        if (aVar3 != null) {
                                            Object obj3 = (ImageView) aVar3.h(z11);
                                            if (obj3 instanceof GifView) {
                                                obj2 = (GifView) obj3;
                                                if (obj2 != null) {
                                                    gifView3 = getGifView();
                                                } else {
                                                    z7 = true;
                                                    gifView2 = obj2;
                                                    r rVar = new r(hVar);
                                                    rVar.a = z8;
                                                    gifView2.setTag(R.id.tag_rich_text_view_gif_view, rVar);
                                                    N = M(next, gifView2, z7);
                                                    textView = gifView2;
                                                    if (z3) {
                                                        t tVar = new t(hVar);
                                                        tVar.a = z8;
                                                        gifView2.setTag(R.id.tag_rich_text_view_recycle, tVar);
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
                                    gifView2.setTag(R.id.tag_rich_text_view_gif_view, rVar2);
                                    N = M(next, gifView2, z7);
                                    textView = gifView2;
                                    if (z3) {
                                    }
                                } else {
                                    if (z4) {
                                        String w2 = this.f41510e.c() ? next.C().w() : next.C().y();
                                        c.a.t0.t2.a<ImageView> aVar4 = this.f41511f;
                                        Object obj4 = aVar4 != null ? (ImageView) aVar4.h(w2) : hVar;
                                        if (obj4 == null) {
                                            z6 = false;
                                            obj = getImageView();
                                        } else {
                                            z6 = true;
                                            obj = obj4;
                                        }
                                        imageView = obj;
                                        z5 = z6;
                                    } else {
                                        imageView = getImageView();
                                        z5 = false;
                                    }
                                    c.a.s0.f1.n.a aVar5 = this.f41510e;
                                    ?? r10 = imageView;
                                    i4 = i7;
                                    N = I(next, imageView, aVar5.f12757j, aVar5.k, z5);
                                    if (z3) {
                                        t tVar2 = new t(hVar);
                                        tVar2.a = z8;
                                        r10.setTag(R.id.tag_rich_text_view_recycle, tVar2);
                                    }
                                    gifView = r10;
                                    tbRichTextData = next;
                                    i7 = i4;
                                    gridImageLayout = gifView;
                                }
                            }
                            tiebaPlusRecommendCard = gridImageLayout;
                            if (N && tiebaPlusRecommendCard != null) {
                                addView(tiebaPlusRecommendCard);
                                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tiebaPlusRecommendCard.getLayoutParams();
                                if (!z10 && (i3 = this.f41510e.D) >= 0) {
                                    if (layoutParams != null) {
                                        layoutParams.topMargin = i3;
                                        tiebaPlusRecommendCard.setLayoutParams(layoutParams);
                                    }
                                    z10 = false;
                                } else if (!(tiebaPlusRecommendCard instanceof TbListTextView)) {
                                    if (!(view instanceof ImageView) && !(view instanceof RelativeLayout)) {
                                        layoutParams.topMargin = this.f41510e.f12751d;
                                    } else {
                                        layoutParams.topMargin = this.f41510e.z;
                                    }
                                    tiebaPlusRecommendCard.setLayoutParams(layoutParams);
                                } else if ((!(tiebaPlusRecommendCard instanceof ImageView) && !(tiebaPlusRecommendCard instanceof RelativeLayout)) || (tbRichTextData.getType() != 8 && tbRichTextData.getType() != 20 && tbRichTextData.getType() != 17)) {
                                    if ((tiebaPlusRecommendCard instanceof ItemCardView) && !z10) {
                                        layoutParams.topMargin = this.f41510e.E;
                                        tiebaPlusRecommendCard.setLayoutParams(layoutParams);
                                    }
                                } else {
                                    if (view instanceof TbListTextView) {
                                        layoutParams.topMargin = this.f41510e.u;
                                    } else if (!(view instanceof ImageView) && !(tiebaPlusRecommendCard instanceof RelativeLayout)) {
                                        layoutParams.topMargin = this.f41510e.f12751d;
                                    } else {
                                        layoutParams.topMargin = this.f41510e.t;
                                    }
                                    tiebaPlusRecommendCard.setLayoutParams(layoutParams);
                                }
                                view = tiebaPlusRecommendCard;
                            }
                            sVar2 = sVar;
                            hVar = null;
                            z8 = true;
                        } else {
                            i4 = i7;
                            if (next.getType() == 32) {
                                tbRichTextData = next;
                                i7 = i4;
                                N = true;
                                gridImageLayout = D(tbRichTextData);
                                tiebaPlusRecommendCard = gridImageLayout;
                                if (N) {
                                    addView(tiebaPlusRecommendCard);
                                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) tiebaPlusRecommendCard.getLayoutParams();
                                    if (!z10) {
                                    }
                                    if (!(tiebaPlusRecommendCard instanceof TbListTextView)) {
                                    }
                                    view = tiebaPlusRecommendCard;
                                }
                                sVar2 = sVar;
                                hVar = null;
                                z8 = true;
                            } else {
                                tbRichTextData = next;
                                if (tbRichTextData.getType() == 512) {
                                    View E = E(view);
                                    if (E == null) {
                                        i7 = i4;
                                        tiebaPlusRecommendCard = E;
                                    } else {
                                        N = P(tbRichTextData, E);
                                        gifView = E;
                                    }
                                } else if (tbRichTextData.getType() == 768) {
                                    View textVoiceView = getTextVoiceView();
                                    N = O(tbRichTextData, (LinearLayout) textVoiceView, sVar2);
                                    gifView = textVoiceView;
                                } else if (tbRichTextData.getType() == 17) {
                                    GifView gifView4 = getGifView();
                                    N = H(tbRichTextData, gifView4);
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
                                                c.a.s0.f1.n.a aVar6 = this.f41510e;
                                                relativeLayout = b2;
                                                U(b2, intValue, intValue2, aVar6.f12757j, aVar6.k);
                                            } else {
                                                relativeLayout = b2;
                                                int intValue3 = tbRichTextData.F().memeInfo.width.intValue();
                                                int intValue4 = tbRichTextData.F().memeInfo.height.intValue();
                                                c.a.s0.f1.n.a aVar7 = this.f41510e;
                                                T(relativeLayout, intValue3, intValue4, aVar7.f12757j, aVar7.k);
                                            }
                                            ImageView b3 = this.f41512g.b();
                                            c.a.s0.f1.n.a aVar8 = this.f41510e;
                                            L(tbRichTextData, b3, aVar8.f12757j, aVar8.k);
                                            if (DuiSwitch.getInOn() && this.p) {
                                                ImageView b4 = this.f41512g.b();
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
                                                int f2 = c.a.d.f.p.n.f(getContext(), R.dimen.ds78);
                                                int f3 = c.a.d.f.p.n.f(getContext(), R.dimen.ds78);
                                                b3.setId(R.id.meme_image_view);
                                                int intValue5 = tbRichTextData.F().memeInfo.width.intValue();
                                                int intValue6 = tbRichTextData.F().memeInfo.height.intValue();
                                                c.a.s0.f1.n.a aVar9 = this.f41510e;
                                                i5 = i8;
                                                V(b3, intValue5, intValue6, aVar9.f12757j, aVar9.k, this.e0);
                                                relativeLayout2 = relativeLayout;
                                                relativeLayout2.addView(b3);
                                                if (f3 > tbRichTextData.F().memeInfo.height.intValue()) {
                                                    f2 /= 2;
                                                    i6 = f3 / 2;
                                                } else {
                                                    i6 = f3;
                                                }
                                                RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(f2, i6);
                                                layoutParams3.addRule(8, R.id.meme_image_view);
                                                layoutParams3.addRule(11);
                                                b4.setOnClickListener(this.e0);
                                                if (relativeLayout2.getLeft() > 0) {
                                                    layoutParams3.rightMargin = c.a.d.f.p.n.f(getContext(), R.dimen.ds6);
                                                }
                                                SkinManager.setImageResource(b4, R.drawable.icon_emotion_dui_n);
                                                relativeLayout2.addView(b4, layoutParams3);
                                            } else {
                                                i5 = i8;
                                                relativeLayout2 = relativeLayout;
                                                int intValue7 = tbRichTextData.F().memeInfo.width.intValue();
                                                int intValue8 = tbRichTextData.F().memeInfo.height.intValue();
                                                c.a.s0.f1.n.a aVar10 = this.f41510e;
                                                X(b3, intValue7, intValue8, aVar10.f12757j, aVar10.k, this.e0);
                                                relativeLayout2.addView(b3);
                                            }
                                            itemCardView = relativeLayout2;
                                            i7 = i10;
                                            N = z12;
                                            i8 = i5;
                                            tiebaPlusRecommendCard = itemCardView;
                                            if (N) {
                                            }
                                            sVar2 = sVar;
                                            hVar = null;
                                            z8 = true;
                                        } else {
                                            i7 = i10;
                                            N = z12;
                                            tiebaPlusRecommendCard = tiebaPlusRecommendCard;
                                            if (N) {
                                            }
                                            sVar2 = sVar;
                                            hVar = null;
                                            z8 = true;
                                        }
                                    }
                                } else {
                                    i5 = i8;
                                    if (tbRichTextData.getType() == 1280) {
                                        ImageView imageView2 = getImageView();
                                        i8 = i5 + 1;
                                        i7 = i4;
                                        N = K(tbRichTextData, imageView2, (this.f41510e.f12757j - getPaddingLeft()) - getPaddingRight(), this.f41510e.k);
                                        tiebaPlusRecommendCard = imageView2;
                                    } else if (tbRichTextData.getType() != 37 && tbRichTextData.getType() != 1281) {
                                        if (tbRichTextData.getType() != 36 || tbRichTextData.K() == null || tbRichTextData.K().z() == null || (bVar = this.m) == null) {
                                            i7 = i4;
                                            i8 = i5;
                                            N = false;
                                            tiebaPlusRecommendCard = tiebaPlusRecommendCard;
                                        } else {
                                            TiebaPlusRecommendCard b5 = bVar.b();
                                            b5.updateCardView(tbRichTextData.K());
                                            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) b5.getLayoutParams();
                                            c.a.s0.f1.n.a aVar11 = this.f41510e;
                                            int i11 = aVar11.y;
                                            marginLayoutParams.setMargins(i11, aVar11.w, i11, aVar11.x);
                                            b5.setLayoutParams(marginLayoutParams);
                                            i7 = i4;
                                            i8 = i5;
                                            N = true;
                                            tiebaPlusRecommendCard = b5;
                                        }
                                    } else {
                                        ItemCardView itemCardView2 = getItemCardView();
                                        i7 = i4;
                                        N = J(itemCardView2, tbRichTextData);
                                        itemCardView = itemCardView2;
                                        i8 = i5;
                                        tiebaPlusRecommendCard = itemCardView;
                                    }
                                    if (N) {
                                    }
                                    sVar2 = sVar;
                                    hVar = null;
                                    z8 = true;
                                }
                                i7 = i4;
                                gridImageLayout = gifView;
                                tiebaPlusRecommendCard = gridImageLayout;
                                if (N) {
                                }
                                sVar2 = sVar;
                                hVar = null;
                                z8 = true;
                            }
                        }
                        tbRichTextData = next;
                        gridImageLayout = textView;
                        tiebaPlusRecommendCard = gridImageLayout;
                        if (N) {
                        }
                        sVar2 = sVar;
                        hVar = null;
                        z8 = true;
                    }
                    i2 = i7;
                    i7 = i2;
                    tiebaPlusRecommendCard = tiebaPlusRecommendCard;
                }
                if (view instanceof TbListTextView) {
                    LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) view.getLayoutParams();
                    layoutParams4.bottomMargin = this.f41510e.C;
                    view.setLayoutParams(layoutParams4);
                } else if (view != null && this.f41510e.B >= 0) {
                    LinearLayout.LayoutParams layoutParams5 = (LinearLayout.LayoutParams) view.getLayoutParams();
                    layoutParams5.bottomMargin = this.f41510e.B;
                    view.setLayoutParams(layoutParams5);
                }
                if (z3 || (aVar = this.f41511f) == null) {
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
        this.f41510e = new c.a.s0.f1.n.a();
        this.f41511f = null;
        this.f41512g = null;
        this.f41513h = null;
        this.f41514i = null;
        this.f41515j = null;
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
        this.b0 = new h(this, 2, null);
        this.e0 = new i(this);
        this.f0 = new c.a.t0.t2.s.c(new j(this));
        this.mOnClickListenerForLinkImage = new k(this);
        this.g0 = new c(this);
        this.r0 = new d(this);
        this.s0 = new e(this, 2004018);
        F();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.TbRichTextView);
        this.f41510e.b(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        G();
    }
}
