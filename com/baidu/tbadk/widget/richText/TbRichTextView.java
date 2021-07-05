package com.baidu.tbadk.widget.richText;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
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
import d.a.s0.h2.i.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import tbclient.MemeInfo;
import tbclient.PbContent;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes4.dex */
public class TbRichTextView extends LinearLayout implements d.a.c.f.a.i {
    public static /* synthetic */ Interceptable $ic;
    public static final float q0;
    public transient /* synthetic */ FieldHolder $fh;
    public View.OnClickListener A;
    public boolean B;
    public boolean C;
    public Runnable D;
    public boolean E;
    public w F;
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
    public int R;
    public TextView S;
    public boolean T;
    public boolean U;
    public boolean V;
    public View.OnLongClickListener W;
    public u a0;
    public final View.OnClickListener b0;
    public final d.a.s0.h2.i.c c0;

    /* renamed from: e  reason: collision with root package name */
    public d.a.r0.b1.m.a f13504e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.s0.h2.a<ImageView> f13505f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.c.e.k.b<ImageView> f13506g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.c.e.k.b<TextView> f13507h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.c.e.k.b<View> f13508i;
    public final View.OnClickListener i0;
    public d.a.c.e.k.b<LinearLayout> j;
    public final v j0;
    public d.a.c.e.k.b<RelativeLayout> k;
    public boolean k0;
    public d.a.c.e.k.b<GifView> l;
    public Drawable l0;
    public GridImageLayout m;
    public String m0;
    public ItemCardView n;
    public BdUniqueId n0;
    public boolean o;
    public final d.a.c.e.l.c<d.a.c.k.d.a> o0;
    public TextUtils.TruncateAt p;
    public CustomMessageListener p0;
    public z q;
    public x r;
    public d.a.s0.h2.i.c s;
    public y t;
    public View.OnClickListener u;
    public View.OnClickListener v;
    public View.OnClickListener w;
    public boolean x;
    public boolean y;
    public int z;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TbRichTextData f13509e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ TbRichTextView f13510f;

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
            this.f13510f = tbRichTextView;
            this.f13509e = tbRichTextData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                TiebaStatic.log(new StatisticItem("common_click").param("page_type", "a005").param(TiebaStatic.Params.GUA_TYPE, 2).param("obj_locate", 16));
                ItemClickJumpUtil.itemClickJump(this.f13509e.z().getItemForumName(), this.f13509e.z().getItemID(), 3, 3);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements v {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbRichTextView f13511a;

        public b(TbRichTextView tbRichTextView) {
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
            this.f13511a = tbRichTextView;
        }

        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.v
        public void dispatchTouchEvent(MotionEvent motionEvent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, motionEvent) == null) {
                if (motionEvent.getAction() == 0) {
                    this.f13511a.O = true;
                } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                    this.f13511a.O = false;
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends d.a.c.e.l.c<d.a.c.k.d.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbRichTextView f13512a;

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
            this.f13512a = tbRichTextView;
        }

        @Override // d.a.c.e.l.c
        public void onCancelled(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                super.onCancelled(str);
            }
        }

        @Override // d.a.c.e.l.c
        public void onProgressUpdate(Object... objArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, objArr) == null) {
                super.onProgressUpdate(objArr);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.l.c
        public void onLoaded(d.a.c.k.d.a aVar, String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, str, i2) == null) {
                this.f13512a.x(aVar);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbRichTextView f13513a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(TbRichTextView tbRichTextView, int i2) {
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
            this.f13513a = tbRichTextView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                int contentSizeOfLzl = this.f13513a.L ? TbConfig.getContentSizeOfLzl() : TbConfig.getContentSize();
                if (this.f13513a.G != null && !ListUtils.isEmpty(this.f13513a.G.y())) {
                    Iterator<TbRichTextData> it = this.f13513a.G.y().iterator();
                    while (it.hasNext()) {
                        TbRichTextData next = it.next();
                        if (next != null) {
                            next.M(contentSizeOfLzl, contentSizeOfLzl);
                        }
                    }
                }
                this.f13513a.setTextSize(contentSizeOfLzl);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements d.a.c.e.k.c<ImageView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbRichTextView f13514a;

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
            this.f13514a = tbRichTextView;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.a.c.e.k.c
        public /* bridge */ /* synthetic */ ImageView a(ImageView imageView) {
            ImageView imageView2 = imageView;
            e(imageView2);
            return imageView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.a.c.e.k.c
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
                    if (d.a.r0.r.k.c().g()) {
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
        @Override // d.a.c.e.k.c
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
        @Override // d.a.c.e.k.c
        /* renamed from: g */
        public ImageView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(d.a.c.a.j.a(this.f13514a.getContext()).getPageActivity());
                boolean g2 = d.a.r0.r.k.c().g();
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

    /* loaded from: classes4.dex */
    public class f extends d.a.s0.h2.a<ImageView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TbRichTextView f13515e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(TbRichTextView tbRichTextView, d.a.c.e.k.c cVar, int i2, int i3) {
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
                    super((d.a.c.e.k.c) objArr2[0], ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13515e = tbRichTextView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.s0.h2.a
        /* renamed from: i */
        public ImageView h(Object obj) {
            InterceptResult invokeL;
            ImageView imageView;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
                if (obj instanceof String) {
                    Iterator it = this.f44252c.iterator();
                    while (it.hasNext()) {
                        imageView = (ImageView) it.next();
                        if ((imageView instanceof TbImageView) && obj.equals(((TbImageView) imageView).getUrl())) {
                            break;
                        }
                    }
                }
                imageView = null;
                this.f44252c.remove(imageView);
                return imageView;
            }
            return (ImageView) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TbRichTextView f13516e;

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
            this.f13516e = tbRichTextView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MemeInfo memeInfo;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && this.f13516e.r != null && (view instanceof ImageView)) {
                String str = null;
                Object tag = view.getTag();
                int i2 = 0;
                int i3 = -1;
                if (tag != null && (tag instanceof TbRichText)) {
                    int childCount = this.f13516e.getChildCount();
                    while (i2 < childCount) {
                        i3++;
                        if (view.getParent() == this.f13516e.getChildAt(i2)) {
                            break;
                        }
                        i2++;
                    }
                    this.f13516e.r.a(view, null, i3, this.f13516e.M, false);
                    return;
                }
                if (tag != null && (tag instanceof String)) {
                    str = (String) tag;
                } else {
                    boolean z = view instanceof TbImageView;
                    if (z && (view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextMemeInfo)) {
                        TbRichTextMemeInfo tbRichTextMemeInfo = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                        String str2 = (tbRichTextMemeInfo == null || (memeInfo = tbRichTextMemeInfo.memeInfo) == null) ? "" : memeInfo.pic_url;
                        int childCount2 = this.f13516e.getChildCount();
                        while (i2 < childCount2) {
                            i3++;
                            if (view.getParent() == this.f13516e.getChildAt(i2)) {
                                break;
                            }
                            i2++;
                        }
                        this.f13516e.r.a(view, str2, i3, this.f13516e.M, false);
                        return;
                    } else if (z) {
                        str = ((TbImageView) view).getUrl();
                    } else if (view instanceof GifView) {
                        str = ((GifView) view).getUrl();
                    }
                }
                String str3 = str;
                int childCount3 = this.f13516e.getChildCount();
                while (i2 < childCount3) {
                    View childAt = this.f13516e.getChildAt(i2);
                    if (this.f13516e.Q(childAt)) {
                        i3++;
                    }
                    if (view == childAt) {
                        break;
                    }
                    i2++;
                }
                this.f13516e.r.a(view, str3, i3, this.f13516e.M, false);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h implements c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbRichTextView f13517a;

        public h(TbRichTextView tbRichTextView) {
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
            this.f13517a = tbRichTextView;
        }

        @Override // d.a.s0.h2.i.c.a
        public boolean a(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                return false;
            }
            return invokeLL.booleanValue;
        }

        @Override // d.a.s0.h2.i.c.a
        public boolean b(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, motionEvent)) == null) {
                if (this.f13517a.b0 != null) {
                    this.f13517a.b0.onClick(view);
                    return true;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }

        @Override // d.a.s0.h2.i.c.a
        public boolean c(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view, motionEvent)) == null) {
                if (this.f13517a.s != null) {
                    this.f13517a.s.a(view);
                    return this.f13517a.s.onDoubleTap(motionEvent);
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TbRichTextView f13518e;

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
            this.f13518e = tbRichTextView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && this.f13518e.t != null && (view instanceof TbImageView)) {
                String str = null;
                Object tag = view.getTag();
                if (tag != null && (tag instanceof t)) {
                    str = ((t) tag).f13531a;
                }
                this.f13518e.t.a(view, str);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class j implements d.a.c.e.k.c<TextView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f13519a;

        public j(Context context) {
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
            this.f13519a = context;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.a.c.e.k.c
        public /* bridge */ /* synthetic */ TextView a(TextView textView) {
            TextView textView2 = textView;
            e(textView2);
            return textView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.a.c.e.k.c
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
        @Override // d.a.c.e.k.c
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
        @Override // d.a.c.e.k.c
        /* renamed from: g */
        public TextView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? new TbListTextView(this.f13519a) : (TextView) invokeV.objValue;
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

    /* loaded from: classes4.dex */
    public class k implements ViewGroup.OnHierarchyChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TbRichTextView f13520e;

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
            this.f13520e = tbRichTextView;
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
                    if (!(tag instanceof s) || !((s) tag).f13530a) {
                        if (this.f13520e.l != null) {
                            this.f13520e.l.e((GifView) view2);
                        }
                    } else {
                        if (this.f13520e.f13505f == null) {
                            TbRichTextView tbRichTextView = this.f13520e;
                            tbRichTextView.f13505f = tbRichTextView.getRecycleImageViewPool();
                        }
                        this.f13520e.f13505f.e((ImageView) view2);
                    }
                } else if (view2 instanceof ImageView) {
                    Object tag2 = view2.getTag(R.id.tag_rich_text_view_recycle);
                    if (!(tag2 instanceof s) || !((s) tag2).f13530a) {
                        if (this.f13520e.f13506g != null) {
                            this.f13520e.f13506g.e((ImageView) view2);
                        }
                    } else {
                        if (this.f13520e.f13505f == null) {
                            TbRichTextView tbRichTextView2 = this.f13520e;
                            tbRichTextView2.f13505f = tbRichTextView2.getRecycleImageViewPool();
                        }
                        this.f13520e.f13505f.e((ImageView) view2);
                    }
                } else if ((view2 instanceof TextView) && this.f13520e.f13507h != null) {
                    this.f13520e.f13507h.e((TextView) view2);
                } else if ((view2 instanceof PlayVoiceBnt) && this.f13520e.f13508i != null) {
                    this.f13520e.f13508i.e(view2);
                } else if ((view2 instanceof PlayVoiceBntNew) && this.f13520e.f13508i != null) {
                    this.f13520e.f13508i.e(view2);
                } else if (view2 instanceof GridImageLayout) {
                    GridImageLayout gridImageLayout = (GridImageLayout) view2;
                    int childCount = gridImageLayout.getChildCount();
                    for (int i2 = 0; i2 < childCount; i2++) {
                        View childAt = gridImageLayout.getChildAt(i2);
                        if ((childAt instanceof GifView) && this.f13520e.l != null) {
                            this.f13520e.l.e((GifView) childAt);
                        } else if ((childAt instanceof ImageView) && this.f13520e.f13506g != null) {
                            this.f13520e.f13506g.e((ImageView) childAt);
                        }
                    }
                    gridImageLayout.removeAllViews();
                    gridImageLayout.f();
                } else if ((view2 instanceof RelativeLayout) && this.f13520e.k != null) {
                    this.f13520e.k.e((RelativeLayout) view2);
                }
                if (view2 instanceof LinearLayout) {
                    Object tag3 = view2.getTag();
                    if (tag3 == null || !(tag3 instanceof String) || !"VideoView".equals(tag3)) {
                        if (this.f13520e.j != null) {
                            LinearLayout linearLayout = (LinearLayout) view2;
                            int childCount2 = linearLayout.getChildCount();
                            for (int i3 = 0; i3 < childCount2; i3++) {
                                View childAt2 = linearLayout.getChildAt(i3);
                                if (childAt2 != null) {
                                    if ((childAt2 instanceof TextView) && this.f13520e.f13507h != null) {
                                        this.f13520e.f13507h.e((TextView) childAt2);
                                    } else if ((childAt2 instanceof PlayVoiceBnt) && this.f13520e.f13508i != null) {
                                        this.f13520e.f13508i.e(childAt2);
                                    } else if ((childAt2 instanceof PlayVoiceBntNew) && this.f13520e.f13508i != null) {
                                        this.f13520e.f13508i.e(childAt2);
                                    }
                                }
                            }
                            linearLayout.removeAllViews();
                            this.f13520e.j.e(linearLayout);
                            return;
                        }
                        return;
                    }
                    view2.setBackgroundDrawable(null);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class l implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.r0.b1.m.i f13521e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ TbRichTextView f13522f;

        public l(TbRichTextView tbRichTextView, d.a.r0.b1.m.i iVar) {
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
            this.f13522f = tbRichTextView;
            this.f13521e = iVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                TiebaStatic.log(TbadkCoreStatisticKey.KEY_RICH_TEXT_VIDEO_CLICK);
                XiaoyingUtil.startPlayXiaoyingVideo(this.f13522f.getContext(), this.f13521e.f(), this.f13521e.g(), this.f13521e.d(), this.f13521e.e());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class m implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TbRichTextData f13523e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ TbRichTextView f13524f;

        public m(TbRichTextView tbRichTextView, TbRichTextData tbRichTextData) {
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
            this.f13524f = tbRichTextView;
            this.f13523e = tbRichTextData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f13523e.E() == null) {
                return;
            }
            if (this.f13524f.getContext() instanceof d.a.r0.b1.m.h) {
                ((d.a.r0.b1.m.h) this.f13524f.getContext()).onVideoClicked(this.f13524f.getContext(), this.f13523e.E().toString());
                return;
            }
            d.a.c.a.f<?> a2 = d.a.c.a.j.a(this.f13524f.getContext());
            if (a2 == null || !(a2.getOrignalPage() instanceof d.a.r0.b1.m.h)) {
                return;
            }
            ((d.a.r0.b1.m.h) a2.getOrignalPage()).onVideoClicked(this.f13524f.getContext(), this.f13523e.E().toString());
        }
    }

    /* loaded from: classes4.dex */
    public class n implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TbRichTextView f13525e;

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
            this.f13525e = tbRichTextView;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f13525e.d0();
                this.f13525e.S.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class o implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TbRichTextData f13526e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ TbRichTextView f13527f;

        public o(TbRichTextView tbRichTextView, TbRichTextData tbRichTextData) {
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
            this.f13527f = tbRichTextView;
            this.f13526e = tbRichTextData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f13527f.F == null) {
                return;
            }
            TbRichTextEmotionInfo y = this.f13526e.y();
            w wVar = this.f13527f.F;
            GifInfo gifInfo = y.mGifInfo;
            wVar.a(view, gifInfo.mGid, gifInfo.mPackageName, gifInfo.mIcon, gifInfo.mStaticUrl, gifInfo.mDynamicUrl, gifInfo.mSharpText, gifInfo.mGifWidth, gifInfo.mGifHeight);
        }
    }

    /* loaded from: classes4.dex */
    public class p implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TbRichTextView f13528e;

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
            this.f13528e = tbRichTextView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && !this.f13528e.O && this.f13528e.performLongClick()) {
                this.f13528e.C = true;
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class q {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f13529a;

        public q() {
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

        public /* synthetic */ q(g gVar) {
            this();
        }
    }

    /* loaded from: classes4.dex */
    public interface r {
        void R(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView);
    }

    /* loaded from: classes4.dex */
    public static class s {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f13530a;

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

        public /* synthetic */ s(g gVar) {
            this();
        }
    }

    /* loaded from: classes4.dex */
    public static class t {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f13531a;

        public t(String str) {
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
            this.f13531a = str;
        }
    }

    /* loaded from: classes4.dex */
    public interface u {
        void a();
    }

    /* loaded from: classes4.dex */
    public interface v {
        void dispatchTouchEvent(MotionEvent motionEvent);
    }

    /* loaded from: classes4.dex */
    public interface w {
        void a(View view, String str, String str2, String str3, String str4, String str5, String str6, int i2, int i3);
    }

    /* loaded from: classes4.dex */
    public interface x {
        void a(View view, String str, int i2, boolean z, boolean z2);
    }

    /* loaded from: classes4.dex */
    public interface y {
        void a(View view, String str);
    }

    /* loaded from: classes4.dex */
    public static class z implements AbsListView.RecyclerListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public int f13532e;

        public z(int i2) {
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
            this.f13532e = 0;
            this.f13532e = i2;
        }

        @Override // android.widget.AbsListView.RecyclerListener
        public void onMovedToScrapHeap(View view) {
            View findViewById;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && (findViewById = view.findViewById(this.f13532e)) != null && (findViewById instanceof TbRichTextView)) {
                ((TbRichTextView) findViewById).setText(null);
            }
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
        q0 = d.a.c.e.p.l.h(TbadkCoreApplication.getInst());
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
        this.f13504e = new d.a.r0.b1.m.a();
        this.f13505f = null;
        this.f13506g = null;
        this.f13507h = null;
        this.f13508i = null;
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
        this.T = false;
        this.U = false;
        this.V = false;
        this.b0 = new g(this);
        this.c0 = new d.a.s0.h2.i.c(new h(this));
        this.i0 = new i(this);
        this.j0 = new b(this);
        this.o0 = new c(this);
        this.p0 = new d(this, 2004018);
        F();
    }

    public static TbRichText R(Context context, JSONArray jSONArray, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLI = interceptable.invokeLLI(65539, null, context, jSONArray, i2)) == null) ? new TbRichText(context, jSONArray, i2) : (TbRichText) invokeLLI.objValue;
    }

    public static TbRichText S(Context context, JSONArray jSONArray, boolean z2) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65540, null, context, jSONArray, z2)) == null) ? new TbRichText(context, jSONArray, z2) : (TbRichText) invokeLLZ.objValue;
    }

    public static TbRichText T(Context context, List<PbContent> list, String str, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, null, new Object[]{context, list, str, Boolean.valueOf(z2)})) == null) ? new TbRichText(context, list, str, z2) : (TbRichText) invokeCommon.objValue;
    }

    public static TbRichText U(Context context, List<PbContent> list, boolean z2) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(AdIconUtil.BAIDU_LOGO_ID, null, context, list, z2)) == null) ? new TbRichText(context, list, null, z2) : (TbRichText) invokeLLZ.objValue;
    }

    private GifView getGifView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, this)) == null) {
            d.a.c.e.k.b<GifView> bVar = this.l;
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
            b2.setRadius(this.R);
            if (this.P) {
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
            this.m.setLayoutStrategy(this.f13504e);
            this.m.setObjectPool(this.f13506g, this.l);
            this.m.setOnImageClickListener(this.r);
            View.OnClickListener onClickListener = this.v;
            if (onClickListener != null) {
                this.m.setOnClickListener(onClickListener);
            }
            this.m.setIsHost(this.M);
            if (this.Q) {
                this.m.setOnLongClickListener(this.W);
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
                TextView A = A(getContext());
                if (A == null) {
                    this.j.e(b2);
                    return null;
                }
                b2.addView(A);
                View C = C(null);
                if (C == null) {
                    this.f13507h.e(A);
                    this.j.e(b2);
                    return null;
                }
                b2.addView(C);
            }
            return b2;
        }
        return (View) invokeV.objValue;
    }

    private void setFaceSize(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(65565, this, f2) == null) {
            if (this.U && d.a.r0.b.d.G()) {
                int emotionContentSizeOfLzl = this.L ? TbConfig.getEmotionContentSizeOfLzl() : TbConfig.getEmotionContentSize();
                d.a.r0.b1.m.a aVar = this.f13504e;
                aVar.f55016g = emotionContentSizeOfLzl;
                aVar.f55017h = emotionContentSizeOfLzl;
                return;
            }
            d.a.r0.b1.m.a aVar2 = this.f13504e;
            int i2 = (int) f2;
            aVar2.f55016g = i2;
            aVar2.f55017h = i2;
        }
    }

    public static d.a.c.e.k.b<TextView> y(Context context, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65570, null, context, i2)) == null) ? new d.a.c.e.k.b<>(new j(context), i2, 0) : (d.a.c.e.k.b) invokeLI.objValue;
    }

    public final TextView A(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            d.a.c.e.k.b<TextView> bVar = this.f13507h;
            TextView b2 = bVar != null ? bVar.b() : null;
            if (b2 == null || b2.getParent() != null) {
                b2 = new TbListTextView(context);
            }
            int i2 = this.f13504e.f55012c;
            b2.setPadding(i2, 0, i2, 0);
            return b2;
        }
        return (TextView) invokeL.objValue;
    }

    public final LinearLayout B(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbRichTextData)) == null) {
            if (this.f13504e.m <= 0 || tbRichTextData == null) {
                return null;
            }
            LinearLayout linearLayout = new LinearLayout(getContext());
            linearLayout.setTag("VideoView");
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.topMargin = this.f13504e.f55013d;
            linearLayout.setClickable(true);
            Bitmap bitmap = SkinManager.getBitmap(this.f13504e.m);
            if (bitmap != null) {
                linearLayout.setBackgroundDrawable(new BitmapDrawable(getContext().getResources(), bitmap));
            }
            linearLayout.setFocusable(false);
            linearLayout.setLayoutParams(layoutParams);
            linearLayout.setOnClickListener(new m(this, tbRichTextData));
            return linearLayout;
        }
        return (LinearLayout) invokeL.objValue;
    }

    public final View C(View view) {
        InterceptResult invokeL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view)) == null) {
            d.a.c.e.k.b<View> bVar = this.f13508i;
            View b2 = bVar != null ? bVar.b() : null;
            if ((b2 == null || b2.getParent() != null) && this.z != -1) {
                b2 = LayoutInflater.from(getContext()).inflate(this.z, (ViewGroup) null);
            }
            if (b2 != null) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                if ((view instanceof TbListTextView) && (i2 = this.f13504e.v) >= 0) {
                    layoutParams.topMargin = i2;
                } else {
                    layoutParams.topMargin = this.f13504e.f55013d;
                }
                layoutParams.bottomMargin = this.f13504e.x;
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

    public final View D(d.a.r0.b1.m.i iVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, iVar)) == null) {
            if (iVar == null || !iVar.h()) {
                return null;
            }
            ImageView b2 = this.f13506g.b();
            if (b2 instanceof ForeDrawableImageView) {
                ForeDrawableImageView foreDrawableImageView = (ForeDrawableImageView) b2;
                foreDrawableImageView.setForegroundDrawable(R.drawable.icon_play_video);
                foreDrawableImageView.setNoImageBottomTextColor(R.color.CAM_X0108);
                foreDrawableImageView.setNoImageBottomTextPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds32));
                foreDrawableImageView.setNoImageBottomTextSize(TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.fontsize28));
                foreDrawableImageView.setNoImageBottomText("点击播放视频");
                foreDrawableImageView.setInterceptOnClick(false);
                foreDrawableImageView.setTag("VideoView");
                b0(foreDrawableImageView, iVar.g(), iVar.d(), (this.f13504e.j - getPaddingLeft()) - getPaddingRight(), this.f13504e.k, new l(this, iVar));
                foreDrawableImageView.setDefaultResource(0);
                foreDrawableImageView.setSupportNoImage(this.f13504e.q);
                if (d.a.r0.r.k.c().g()) {
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

    public boolean E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.E : invokeV.booleanValue;
    }

    public final void F() {
        d.a.r0.b1.m.h hVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            d.a.c.a.f<?> a2 = d.a.c.a.j.a(getContext());
            if (getContext() instanceof d.a.r0.b1.m.h) {
                hVar = (d.a.r0.b1.m.h) getContext();
            } else {
                hVar = (a2 == null || !(a2.getOrignalPage() instanceof d.a.r0.b1.m.h)) ? null : (d.a.r0.b1.m.h) a2.getOrignalPage();
            }
            if (hVar == null && (getContext() instanceof BaseFragmentActivity)) {
                List<Fragment> fragments = ((BaseFragmentActivity) getContext()).getSupportFragmentManager().getFragments();
                if (!ListUtils.isEmpty(fragments) && (fragments.get(0) instanceof d.a.r0.b1.m.h)) {
                    hVar = (d.a.r0.b1.m.h) fragments.get(0);
                }
            }
            if (a2 != null) {
                a2.registerListener(this.p0);
            }
            if (hVar != null) {
                this.f13506g = hVar.getImageViewPool();
                this.f13507h = hVar.getTextViewPool();
                this.f13508i = hVar.getVoiceViewPool();
                this.j = hVar.getTextVoiceViewPool();
                this.l = hVar.getGifViewPool();
                this.k = hVar.getRelativeLayoutPool();
                if (hVar.getListView() != null && this.q == null) {
                    this.q = new z(hVar.getRichTextViewId());
                    hVar.getListView().setRecyclerListener(this.q);
                }
            }
            this.R = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds21);
            setOrientation(1);
            setOnHierarchyChangeListener(new k(this));
        }
    }

    public final void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            setFaceSize(this.L ? TbConfig.getContentSizeOfLzl() : TbConfig.getContentSize());
        }
    }

    public final boolean H(TbRichTextData tbRichTextData, GifView gifView) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, tbRichTextData, gifView)) == null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) gifView.getLayoutParams();
            if (layoutParams != null && layoutParams.width == tbRichTextData.y().mGifInfo.mGifWidth && layoutParams.height == tbRichTextData.y().mGifInfo.mGifHeight) {
                layoutParams.bottomMargin = 0;
            } else {
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(tbRichTextData.y().mGifInfo.mGifWidth, tbRichTextData.y().mGifInfo.mGifHeight);
                layoutParams2.gravity = 3;
                gifView.setLayoutParams(layoutParams2);
            }
            gifView.setOnClickListener(new o(this, tbRichTextData));
            gifView.k0(tbRichTextData.y().mGifInfo);
            return true;
        }
        return invokeLL.booleanValue;
    }

    public final boolean I(TbRichTextData tbRichTextData, ImageView imageView, int i2, int i3, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{tbRichTextData, imageView, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z2)})) == null) {
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
                tbImageView.setRadius(this.R);
                if (this.P) {
                    tbImageView.setPlaceHolder(2);
                } else {
                    tbImageView.setPlaceHolder(3);
                }
                if (this.f13504e.q) {
                    tbImageView.setSupportNoImage(true);
                }
                String w2 = this.f13504e.c() ? tbRichTextData.B().w() : tbRichTextData.B().y();
                if (!z2 || tbImageView.getUrl() == null || !tbImageView.getUrl().equals(w2)) {
                    tbImageView.M(w2, this.y ? 17 : 18, false);
                }
                if (!tbRichTextData.B().C()) {
                    tbImageView.setAdjustViewBounds(false);
                }
                tbImageView.setTag(R.id.tag_rich_text_meme_info, null);
            }
            return a0(imageView, tbRichTextData.B().getWidth(), tbRichTextData.B().getHeight(), i2, i3, this.b0);
        }
        return invokeCommon.booleanValue;
    }

    public final boolean J(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, tbRichTextData)) == null) {
            if (tbRichTextData == null || tbRichTextData.z() == null) {
                return false;
            }
            if (this.n == null) {
                ItemCardView itemCardView = new ItemCardView(getContext());
                this.n = itemCardView;
                itemCardView.setPosition(4);
                this.n.setOnClickListener(new a(this, tbRichTextData));
            }
            this.n.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            this.n.setOnClickListenerOfRightBtn(this.w);
            this.n.setIsShowRightBtn(this.V);
            this.n.setData(tbRichTextData.z(), 17);
            this.n.b();
            return true;
        }
        return invokeL.booleanValue;
    }

    public final boolean K(TbRichTextData tbRichTextData, ImageView imageView, int i2, int i3) {
        InterceptResult invokeLLII;
        TbRichTextLinkImageInfo C;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(1048586, this, tbRichTextData, imageView, i2, i3)) == null) {
            if (tbRichTextData == null || imageView == null || (C = tbRichTextData.C()) == null || C.getLink() == null) {
                return false;
            }
            if (imageView instanceof TbImageView) {
                TbImageView tbImageView = (TbImageView) imageView;
                if (this.f13504e.q) {
                    tbImageView.setSupportNoImage(true);
                }
                tbImageView.M(C.w(), this.y ? 17 : 18, false);
                tbImageView.setTag(new t(C.getLink()));
                if (!C.x()) {
                    tbImageView.setAdjustViewBounds(false);
                }
            }
            return b0(imageView, C.getWidth(), C.getHeight(), i2, i3, this.i0);
        }
        return invokeLLII.booleanValue;
    }

    public final boolean L(TbRichTextData tbRichTextData, ImageView imageView, int i2, int i3) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(1048587, this, tbRichTextData, imageView, i2, i3)) == null) {
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
                tbImageView.setRadius(this.R);
                if (this.P) {
                    tbImageView.setPlaceHolder(2);
                } else {
                    tbImageView.setPlaceHolder(3);
                }
                if (this.f13504e.q) {
                    tbImageView.setSupportNoImage(true);
                }
                tbImageView.M(tbRichTextData.D().memeInfo.pic_url, this.y ? 17 : 18, false);
                tbImageView.setAdjustViewBounds(false);
                tbImageView.setTag(R.id.tag_rich_text_meme_info, tbRichTextData.D());
            }
            return b0(imageView, tbRichTextData.D().memeInfo.width.intValue(), tbRichTextData.D().memeInfo.height.intValue(), i2, i3, this.b0);
        }
        return invokeLLII.booleanValue;
    }

    public final boolean M(TbRichTextData tbRichTextData, GifView gifView, boolean z2) {
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
            String z3 = tbRichTextData.B().z();
            if (StringUtils.isNull(z3)) {
                d.a.r0.b1.m.a aVar = this.f13504e;
                if (aVar.C) {
                    z3 = aVar.r ? tbRichTextData.B().w() : tbRichTextData.B().x();
                }
                if (StringUtils.isNull(z3)) {
                    z3 = this.f13504e.r ? tbRichTextData.B().y() : tbRichTextData.B().B();
                }
            }
            gifView.setShowStaticDrawable(false);
            if (!z2 || gifView.getUrl() == null || !gifView.getUrl().equals(z3)) {
                gifView.l0(z3, 38);
            }
            int width = tbRichTextData.B().getWidth();
            int height = tbRichTextData.B().getHeight();
            d.a.r0.b1.m.a aVar2 = this.f13504e;
            return a0(gifView, width, height, aVar2.j, aVar2.k, this.b0);
        }
        return invokeLLZ.booleanValue;
    }

    public final boolean N(TbRichTextData tbRichTextData, TextView textView, boolean z2, r rVar) {
        InterceptResult invokeCommon;
        LinearLayout.LayoutParams layoutParams;
        SpannableStringBuilder E;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{tbRichTextData, textView, Boolean.valueOf(z2), rVar})) == null) {
            this.S = textView;
            if (z2) {
                layoutParams = new LinearLayout.LayoutParams(-1, -2);
            } else {
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
            }
            if (this.H) {
                layoutParams.gravity = 16;
                textView.setGravity(16);
            } else {
                layoutParams.topMargin = this.f13504e.f55013d;
            }
            d.a.r0.b1.m.a aVar = this.f13504e;
            textView.setLineSpacing(aVar.f55011b, aVar.f55010a);
            textView.setTextSize(0, this.f13504e.f55014e);
            if (this.f13504e.f55015f) {
                d.a.r0.r.u.c.d(textView).y(R.string.F_X02);
            }
            textView.setTextColor(this.f13504e.f55018i);
            textView.setLinkTextColor(SkinManager.getColor(R.color.CAM_X0304));
            textView.setHighlightColor(getContext().getResources().getColor(R.color.transparent));
            textView.setSingleLine(this.f13504e.n);
            if (this.N) {
                c0();
            }
            TextUtils.TruncateAt truncateAt = this.p;
            if (truncateAt != null) {
                textView.setEllipsize(truncateAt);
            }
            if (this.T) {
                d.a.r0.r.u.c.d(textView).w(R.array.S_O_X001);
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
            d.a.r0.b1.m.a aVar2 = this.f13504e;
            int i5 = aVar2.f55017h;
            if (i5 > 0 && (i2 = aVar2.f55016g) > 0) {
                tbRichTextData.M(i2, i5);
            }
            if (rVar != null) {
                rVar.R(E, textView, this);
            }
            try {
                textView.setText(E);
            } catch (Exception unused) {
                textView.setText("");
            }
            if (this.K) {
                if (tbRichTextData.J()) {
                    textView.setMovementMethod(d.a.s0.z3.c.a());
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
            tbRichTextData.G().needRecompute = this.k0;
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public final boolean O(TbRichTextData tbRichTextData, LinearLayout linearLayout, r rVar) {
        InterceptResult invokeLLL;
        boolean P;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048590, this, tbRichTextData, linearLayout, rVar)) == null) {
            if (linearLayout == null) {
                return false;
            }
            int childCount = linearLayout.getChildCount();
            boolean z2 = true;
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = linearLayout.getChildAt(i2);
                if (childAt != null) {
                    if (childAt instanceof TextView) {
                        P = N(tbRichTextData, (TextView) childAt, false, rVar);
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
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048591, this, tbRichTextData, view)) == null) {
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

    public final boolean Q(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, view)) == null) {
            if (view instanceof ImageView) {
                if (view instanceof GifView) {
                    return view.getTag(R.id.tag_rich_text_view_gif_view) != null && (view.getTag(R.id.tag_rich_text_view_gif_view) instanceof q) && ((q) view.getTag(R.id.tag_rich_text_view_gif_view)).f13529a;
                }
                if ((view instanceof TbImageView) && view.getTag() != null) {
                    if (view.getTag() instanceof t) {
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

    public final void V() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.C = false;
            if (this.D == null) {
                this.D = new p(this);
            }
            postDelayed(this.D, ViewConfiguration.getLongPressTimeout());
        }
    }

    public final void W() {
        Runnable runnable;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || (runnable = this.D) == null) {
            return;
        }
        removeCallbacks(runnable);
    }

    public final void X(RelativeLayout relativeLayout, int i2, int i3, int i4, int i5) {
        int[] l2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048595, this, new Object[]{relativeLayout, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) || (l2 = d.a.c.e.p.l.l(i2, i3, i4, i5)) == null) {
            return;
        }
        int[] iArr = {l2[0], l2[1]};
        int i6 = iArr[0];
        int i7 = iArr[1];
        if (this.f13504e.s && i4 > i6) {
            float f2 = q0;
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
    public final void Y(RelativeLayout relativeLayout, int i2, int i3, int i4, int i5) {
        int[] l2;
        int i6;
        int i7;
        int g2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048596, this, new Object[]{relativeLayout, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) || (l2 = d.a.c.e.p.l.l(i2, i3, i4, i5)) == null) {
            return;
        }
        int[] iArr = {l2[0], l2[1]};
        int i8 = iArr[0];
        int i9 = iArr[1];
        if (this.f13504e.s && i4 > i8) {
            float f2 = q0;
            if (f2 > 1.0f) {
                float f3 = i8;
                float f4 = i4;
                if (f3 * f2 > f4) {
                    i7 = i4 - d.a.c.e.p.l.g(getContext(), R.dimen.ds78);
                    g2 = d.a.c.e.p.l.g(getContext(), R.dimen.ds16);
                } else {
                    float f5 = f4 * 0.68f;
                    if (f3 * f2 > f5) {
                        i7 = (int) f5;
                        g2 = d.a.c.e.p.l.g(getContext(), R.dimen.ds78);
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

    public final boolean Z(ImageView imageView, int i2, int i3, int i4, int i5, View.OnClickListener onClickListener) {
        InterceptResult invokeCommon;
        View.OnLongClickListener onLongClickListener;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048597, this, new Object[]{imageView, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), onClickListener})) == null) {
            int[] l2 = d.a.c.e.p.l.l(i2, i3, i4, i5);
            if (l2 == null) {
                return false;
            }
            int[] iArr = {l2[0], l2[1]};
            int i6 = iArr[0];
            int i7 = iArr[1];
            if (this.f13504e.s && i4 > i6) {
                float f2 = q0;
                if (f2 > 1.0f) {
                    float f3 = i6;
                    float f4 = i4;
                    if (f3 * f2 > f4) {
                        i6 = (i4 - d.a.c.e.p.l.g(getContext(), R.dimen.ds78)) - d.a.c.e.p.l.g(getContext(), R.dimen.ds16);
                    } else {
                        float f5 = f4 * 0.68f;
                        i6 = f3 * f2 > f5 ? ((int) f5) - d.a.c.e.p.l.g(getContext(), R.dimen.ds78) : (int) (f3 * f2);
                    }
                    if (iArr[0] > 0) {
                        i7 = (iArr[1] * i6) / iArr[0];
                    }
                }
            }
            boolean z2 = imageView instanceof TbImageView;
            if (z2) {
                TbImageView tbImageView = (TbImageView) imageView;
                tbImageView.setDefaultResource(this.f13504e.l);
                if (tbImageView.getGifIconWidth() < i6 && tbImageView.getGifIconHeight() < i7) {
                    tbImageView.setGifIconSupport(true);
                } else {
                    tbImageView.setGifIconSupport(false);
                }
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i6, i7);
            if (this.f13504e.s) {
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            } else {
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            }
            imageView.setClickable(true);
            imageView.setFocusable(false);
            if (this.s != null && z2) {
                ((TbImageView) imageView).setTbGestureDetector(this.c0);
                imageView.setClickable(true);
            } else {
                imageView.setOnClickListener(onClickListener);
            }
            imageView.setLayoutParams(layoutParams);
            if (z2) {
                if (this.W != null) {
                    ((TbImageView) imageView).setDispatchTouchListener(this.j0);
                    imageView.setOnLongClickListener(this.W);
                }
            } else if ((imageView instanceof GifView) && (onLongClickListener = this.W) != null) {
                imageView.setOnLongClickListener(onLongClickListener);
            }
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public final boolean a0(ImageView imageView, int i2, int i3, int i4, int i5, View.OnClickListener onClickListener) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048598, this, new Object[]{imageView, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), onClickListener})) == null) {
            int[] e2 = this.f13504e.e(i2, i3, i4, i5);
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
            d.a.r0.b1.m.a aVar = this.f13504e;
            if (aVar.s) {
                imageView.setScaleType(aVar.p);
                if (z2) {
                    ((TbImageView) imageView).setOnDrawListener(this.f13504e.F);
                }
            } else {
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            }
            imageView.setClickable(true);
            imageView.setFocusable(false);
            if (this.s != null && z2) {
                ((TbImageView) imageView).setTbGestureDetector(this.c0);
                imageView.setClickable(true);
            } else {
                imageView.setOnClickListener(onClickListener);
            }
            imageView.setLayoutParams(layoutParams);
            if (z2) {
                if (this.W != null) {
                    ((TbImageView) imageView).setDispatchTouchListener(this.j0);
                    imageView.setOnLongClickListener(this.W);
                }
            } else if ((imageView instanceof GifView) && this.W != null) {
                ((GifView) imageView).setDispatchTouchListener(this.j0);
                imageView.setOnLongClickListener(this.W);
            }
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public final boolean b0(ImageView imageView, int i2, int i3, int i4, int i5, View.OnClickListener onClickListener) {
        InterceptResult invokeCommon;
        View.OnLongClickListener onLongClickListener;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048599, this, new Object[]{imageView, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), onClickListener})) == null) {
            int[] l2 = d.a.c.e.p.l.l(i2, i3, i4, i5);
            if (l2 == null) {
                return false;
            }
            int[] iArr = {l2[0], l2[1]};
            int i6 = iArr[0];
            int i7 = iArr[1];
            if (this.f13504e.s && i4 > i6) {
                float f2 = q0;
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
                tbImageView.setDefaultResource(this.f13504e.l);
                if (tbImageView.getGifIconWidth() < i6 && tbImageView.getGifIconHeight() < i7) {
                    tbImageView.setGifIconSupport(true);
                } else {
                    tbImageView.setGifIconSupport(false);
                }
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i6, i7);
            if (this.f13504e.s) {
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            } else {
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            }
            imageView.setClickable(true);
            imageView.setFocusable(false);
            if (this.s != null && z2) {
                ((TbImageView) imageView).setTbGestureDetector(this.c0);
                imageView.setClickable(true);
            } else {
                imageView.setOnClickListener(onClickListener);
            }
            imageView.setLayoutParams(layoutParams);
            if (z2) {
                if (this.W != null) {
                    ((TbImageView) imageView).setDispatchTouchListener(this.j0);
                    imageView.setOnLongClickListener(this.W);
                }
            } else if ((imageView instanceof GifView) && (onLongClickListener = this.W) != null) {
                imageView.setOnLongClickListener(onLongClickListener);
            }
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public final void c0() {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048600, this) == null) || (textView = this.S) == null) {
            return;
        }
        textView.getViewTreeObserver().addOnGlobalLayoutListener(new n(this));
    }

    public final void d0() {
        TextView textView;
        CharSequence text;
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048601, this) == null) || this.J <= 0 || (textView = this.S) == null || textView.getLineCount() <= this.J) {
            return;
        }
        try {
            text = this.S.getText().subSequence(0, this.S.getLayout().getLineEnd(this.J - 1) - 1);
            str = StringHelper.STRING_MORE;
        } catch (Exception unused) {
            text = this.S.getText();
            str = "";
        }
        TextUtils.TruncateAt ellipsize = this.S.getEllipsize();
        if (ellipsize == TextUtils.TruncateAt.START) {
            this.S.setText(str);
            this.S.append(text);
        } else if (ellipsize == TextUtils.TruncateAt.MIDDLE) {
            this.S.setText(text.subSequence(0, text.length() / 2));
            this.S.append(str);
            this.S.append(text.subSequence(text.length() / 2, text.length()));
        } else if (ellipsize == TextUtils.TruncateAt.END) {
            this.S.setText(text);
            this.S.append(str);
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
                W();
            }
            boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
            if (motionEvent.getAction() == 0 && !this.B) {
                V();
            }
            return dispatchTouchEvent;
        }
        return invokeL.booleanValue;
    }

    public void e0(String str) {
        BdUniqueId bdUniqueId;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, str) == null) {
            if (TextUtils.isEmpty(str)) {
                this.m0 = str;
                return;
            }
            getContext();
            d.a.c.a.i c2 = d.a.c.a.j.c(getContext());
            if (c2 != null) {
                bdUniqueId = c2.getUniqueId();
                z2 = c2.isScroll();
            } else {
                bdUniqueId = null;
                z2 = false;
            }
            if (!(str.equals(this.m0) && this.n0 == bdUniqueId)) {
                g0();
            }
            this.m0 = str;
            this.n0 = bdUniqueId;
            setBackgroundDrawable(null);
            d.a.c.k.d.a aVar = (d.a.c.k.d.a) d.a.c.e.l.d.h().n(this.m0, 19, new Object[0]);
            if (aVar != null) {
                x(aVar);
            } else if (z2) {
                invalidate();
            } else if (!d.a.c.e.l.d.h().j(19)) {
                invalidate();
            } else {
                d.a.c.e.l.d.h().k(this.m0, 19, this.o0, 0, 0, this.n0, new Object[0]);
            }
        }
    }

    public void f0(String str, u uVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048604, this, str, uVar) == null) {
            this.a0 = uVar;
            e0(str);
        }
    }

    public void g0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048605, this) == null) || TextUtils.isEmpty(this.m0)) {
            return;
        }
        d.a.c.e.l.d.h().d(this.m0, 19, this.o0);
        setBackgroundDrawable(null);
    }

    public d.a.r0.b1.m.a getLayoutStrategy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.f13504e : (d.a.r0.b1.m.a) invokeV.objValue;
    }

    public x getOnImageClickListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.r : (x) invokeV.objValue;
    }

    public y getOnLinkImageClickListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.t : (y) invokeV.objValue;
    }

    public d.a.s0.h2.a<ImageView> getRecycleImageViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            if (this.f13505f == null) {
                this.f13505f = new f(this, new e(this), 10, 0);
            }
            return this.f13505f;
        }
        return (d.a.s0.h2.a) invokeV.objValue;
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

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            super.onDetachedFromWindow();
            d.a.r0.b1.m.a aVar = this.f13504e;
            if (aVar != null) {
                aVar.d();
            }
            g0();
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048613, this, motionEvent)) == null) {
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
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            super.onStartTemporaryDetach();
            g0();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048615, this, motionEvent)) == null) {
            this.B = true;
            return super.onTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048616, this, i2) == null) {
            super.onWindowVisibilityChanged(i2);
            if (i2 != 8 && i2 != 4) {
                refresh();
            } else {
                g0();
            }
        }
    }

    @Override // d.a.c.f.a.i
    public void refresh() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            e0(this.m0);
        }
    }

    public void setAddTruncateListener(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048618, this, z2) == null) {
            this.N = z2;
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, drawable) == null) {
            super.setBackgroundDrawable(drawable);
            if (this.l0 != drawable) {
                this.k0 = true;
                this.l0 = drawable;
            }
            setText(this.G);
            this.k0 = false;
        }
    }

    public void setCommonTextViewOnClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, onClickListener) == null) {
            this.u = onClickListener;
        }
    }

    public void setDisplayImage(boolean z2, boolean z3) {
        d.a.c.e.k.b<ImageView> bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048621, this, new Object[]{Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) || this.x == z2) {
            return;
        }
        this.x = z2;
        if (z3) {
            requestLayout();
        }
        if (this.x || (bVar = this.f13506g) == null) {
            return;
        }
        bVar.c();
    }

    public void setDuiEnabled(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048622, this, z2) == null) {
            this.o = z2;
        }
    }

    public void setHasMovementMethod(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048623, this, z2) == null) {
            this.K = z2;
        }
    }

    public void setIsFromCDN(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048624, this, z2) == null) {
            this.y = z2;
            d.a.r0.b1.m.a aVar = this.f13504e;
            if (aVar != null) {
                aVar.r = z2;
            }
        }
    }

    public void setIsHost(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048625, this, z2) == null) {
            this.M = z2;
            GridImageLayout gridImageLayout = this.m;
            if (gridImageLayout != null) {
                gridImageLayout.setIsHost(z2);
            }
        }
    }

    public void setIsNeedResizeEmotion(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048626, this, z2) == null) {
            this.U = z2;
        }
    }

    public void setIsShowOrderOrDownloadBtn(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048627, this, z2) == null) {
            this.V = z2;
        }
    }

    public void setIsUseGridImage(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048628, this, z2) == null) {
            this.P = z2;
        }
    }

    public void setItemOrderOrDownloadListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048629, this, onClickListener) == null) {
            this.w = onClickListener;
        }
    }

    public void setLayoutStrategy(d.a.r0.b1.m.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048630, this, aVar) == null) || aVar == null) {
            return;
        }
        this.f13504e.d();
        this.f13504e = aVar;
        G();
        GridImageLayout gridImageLayout = this.m;
        if (gridImageLayout != null) {
            gridImageLayout.setLayoutStrategy(this.f13504e);
        }
    }

    public void setLinkTextColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048631, this, i2) == null) {
            d.a.r0.b1.m.a aVar = this.f13504e;
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
        if (interceptable == null || interceptable.invokeI(1048632, this, i2) == null) {
            this.J = i2;
            TextView textView = this.S;
            if (textView != null) {
                textView.setMaxLines(i2);
            }
        }
    }

    public void setMaxWidth(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048633, this, i2) == null) {
            this.I = i2;
        }
    }

    public void setOnEmotionClickListener(w wVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048634, this, wVar) == null) {
            this.F = wVar;
        }
    }

    public void setOnImageClickListener(x xVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048635, this, xVar) == null) {
            this.r = xVar;
            GridImageLayout gridImageLayout = this.m;
            if (gridImageLayout != null) {
                gridImageLayout.setOnImageClickListener(xVar);
            }
        }
    }

    public void setOnImageTouchListener(d.a.s0.h2.i.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048636, this, cVar) == null) {
            this.s = cVar;
        }
    }

    public void setOnLinkImageClickListener(y yVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048637, this, yVar) == null) {
            this.t = yVar;
        }
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048638, this, onLongClickListener) == null) {
            this.W = onLongClickListener;
            super.setOnLongClickListener(onLongClickListener);
        }
    }

    public void setOnVoiceAfterClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048639, this, onClickListener) == null) {
            this.A = onClickListener;
        }
    }

    public void setSubPbPost(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048640, this, z2) == null) {
            this.L = z2;
            G();
        }
    }

    public void setText(TbRichText tbRichText) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048641, this, tbRichText) == null) {
            setText(tbRichText, false);
        }
    }

    public void setTextBold() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048645, this) == null) {
            this.f13504e.f55015f = true;
        }
    }

    public void setTextCenter(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048646, this, z2) == null) {
            this.H = z2;
        }
    }

    public void setTextColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048647, this, i2) == null) {
            d.a.r0.b1.m.a aVar = this.f13504e;
            if (i2 == aVar.f55018i) {
                return;
            }
            aVar.f55018i = i2;
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
        if (interceptable == null || interceptable.invokeL(1048648, this, truncateAt) == null) {
            this.p = truncateAt;
            TextView textView = this.S;
            if (textView != null) {
                textView.setEllipsize(truncateAt);
            }
        }
    }

    public void setTextPadding(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048649, this, i2) == null) {
            d.a.r0.b1.m.a aVar = this.f13504e;
            if (aVar.f55012c == i2) {
                return;
            }
            aVar.f55012c = i2;
            int childCount = getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                if (childAt != null && (childAt instanceof TextView)) {
                    int i4 = this.f13504e.f55012c;
                    ((TextView) childAt).setPadding(i4, 0, 0, i4);
                }
            }
        }
    }

    public void setTextSize(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048650, this, f2) == null) {
            setFaceSize(f2);
            d.a.r0.b1.m.a aVar = this.f13504e;
            if (f2 == aVar.f55014e) {
                return;
            }
            aVar.f55014e = f2;
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
        if (interceptable == null || interceptable.invokeZ(1048651, this, z2) == null) {
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
        if (interceptable == null || interceptable.invokeL(1048652, this, onClickListener) == null) {
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
        if (interceptable == null || interceptable.invokeL(1048653, this, onTouchListener) == null) {
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (childAt instanceof TbListTextView) {
                    ((TbListTextView) childAt).setOnTouchListener(onTouchListener);
                }
            }
        }
    }

    public void setVoiceViewRes(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048654, this, i2) == null) {
            this.z = i2;
        }
    }

    public void setmGridEmptyClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048655, this, onClickListener) == null) {
            this.v = onClickListener;
        }
    }

    public void setmIsGridImageSupportLongPress(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048656, this, z2) == null) {
            this.Q = z2;
        }
    }

    public final void x(d.a.c.k.d.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048657, this, aVar) == null) || aVar == null) {
            return;
        }
        try {
            NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(getResources(), aVar.p(), aVar.p().getNinePatchChunk(), aVar.o(), null);
            if (TbadkCoreApplication.getInst().getSkinType() == 1 || TbadkCoreApplication.getInst().getSkinType() == 4) {
                ninePatchDrawable.getPaint().setAlpha(80);
            }
            setBackgroundDrawable(ninePatchDrawable);
            u uVar = this.a0;
            if (uVar != null) {
                uVar.a();
            }
        } catch (Exception unused) {
        }
    }

    public final ImageView z(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048658, this, context)) == null) {
            d.a.c.e.k.b<ImageView> bVar = this.f13506g;
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

    public void setText(TbRichText tbRichText, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048642, this, tbRichText, z2) == null) {
            setText(tbRichText, z2, null);
        }
    }

    public void setText(TbRichText tbRichText, boolean z2, r rVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048643, this, new Object[]{tbRichText, Boolean.valueOf(z2), rVar}) == null) {
            setText(tbRichText, z2, rVar, false, false);
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
    public void setText(TbRichText tbRichText, boolean z2, r rVar, boolean z3, boolean z4) {
        ArrayList<TbRichTextData> y2;
        d.a.s0.h2.a<ImageView> aVar;
        int i2;
        boolean N;
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
        Object z5;
        boolean z6;
        boolean z7;
        Object obj;
        boolean z8;
        GifView gifView2;
        GifView gifView3;
        View.OnClickListener onClickListener;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048644, this, new Object[]{tbRichText, Boolean.valueOf(z2), rVar, Boolean.valueOf(z3), Boolean.valueOf(z4)}) == null) {
            r rVar2 = rVar;
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
                g gVar = null;
                boolean z9 = true;
                View view = null;
                View view2 = null;
                int i7 = 0;
                int i8 = 0;
                boolean z10 = false;
                boolean z11 = true;
                while (it.hasNext()) {
                    TbRichTextData next = it.next();
                    if (next != null) {
                        if (next.getType() == z9) {
                            TextView A = A(getContext());
                            N = N(next, A, z9, rVar2);
                            if (z2 && !this.E && (E = next.E()) != null) {
                                this.E = E.length() >= 200;
                            }
                            if (this.s != null) {
                                A.setOnTouchListener(this.c0);
                                textView = A;
                            } else {
                                A.setOnClickListener(this.u);
                                textView = A;
                            }
                        } else if (next.getType() == 8) {
                            if (this.P) {
                                int i9 = i7;
                                if (z10) {
                                    i2 = i9;
                                    i7 = i2;
                                    view = view;
                                } else {
                                    GridImageLayout gridImageView = getGridImageView();
                                    gridImageView.setData(tbRichText.A());
                                    tbRichTextData = next;
                                    i7 = i9;
                                    N = true;
                                    z10 = true;
                                    gridImageLayout = gridImageView;
                                }
                            } else if (i8 < 10) {
                                i8++;
                                if (next.B() == null) {
                                    tbRichTextData = next;
                                    N = false;
                                    gridImageLayout = view;
                                } else if (TbadkCoreApplication.getInst().isGifAutoPlay() && !next.B().E()) {
                                    if (z4) {
                                        String z12 = next.B().z();
                                        if (StringUtils.isNull(z12)) {
                                            d.a.r0.b1.m.a aVar2 = this.f13504e;
                                            if (aVar2.C) {
                                                z12 = aVar2.r ? next.B().w() : next.B().x();
                                            }
                                            if (StringUtils.isNull(z12)) {
                                                z12 = this.f13504e.r ? next.B().y() : next.B().B();
                                            }
                                        }
                                        d.a.s0.h2.a<ImageView> aVar3 = this.f13505f;
                                        if (aVar3 != null) {
                                            ImageView h2 = aVar3.h(z12);
                                            if (h2 instanceof GifView) {
                                                onClickListener = (GifView) h2;
                                                if (onClickListener != null) {
                                                    gifView3 = getGifView();
                                                } else {
                                                    z8 = true;
                                                    gifView2 = onClickListener;
                                                    q qVar = new q(gVar);
                                                    qVar.f13529a = z9;
                                                    gifView2.setTag(R.id.tag_rich_text_view_gif_view, qVar);
                                                    N = M(next, gifView2, z8);
                                                    textView = gifView2;
                                                    if (z3) {
                                                        s sVar = new s(gVar);
                                                        sVar.f13530a = z9;
                                                        gifView2.setTag(R.id.tag_rich_text_view_recycle, sVar);
                                                        textView = gifView2;
                                                    }
                                                }
                                            }
                                        }
                                        onClickListener = gVar;
                                        if (onClickListener != null) {
                                        }
                                    } else {
                                        gifView3 = getGifView();
                                    }
                                    z8 = false;
                                    gifView2 = gifView3;
                                    q qVar2 = new q(gVar);
                                    qVar2.f13529a = z9;
                                    gifView2.setTag(R.id.tag_rich_text_view_gif_view, qVar2);
                                    N = M(next, gifView2, z8);
                                    textView = gifView2;
                                    if (z3) {
                                    }
                                } else {
                                    if (z4) {
                                        String w2 = this.f13504e.c() ? next.B().w() : next.B().y();
                                        d.a.s0.h2.a<ImageView> aVar4 = this.f13505f;
                                        Object obj2 = aVar4 != null ? (ImageView) aVar4.h(w2) : gVar;
                                        if (obj2 == null) {
                                            z7 = false;
                                            obj = z(getContext());
                                        } else {
                                            z7 = true;
                                            obj = obj2;
                                        }
                                        z5 = obj;
                                        z6 = z7;
                                    } else {
                                        z5 = z(getContext());
                                        z6 = false;
                                    }
                                    d.a.r0.b1.m.a aVar5 = this.f13504e;
                                    ?? r10 = z5;
                                    i4 = i7;
                                    N = I(next, z5, aVar5.j, aVar5.k, z6);
                                    if (z3) {
                                        s sVar2 = new s(gVar);
                                        sVar2.f13530a = z9;
                                        r10.setTag(R.id.tag_rich_text_view_recycle, sVar2);
                                    }
                                    gifView = r10;
                                    tbRichTextData = next;
                                    i7 = i4;
                                    gridImageLayout = gifView;
                                }
                            }
                            view = gridImageLayout;
                            if (N && view != null) {
                                addView(view);
                                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
                                if (!z11 && (i3 = this.f13504e.A) >= 0) {
                                    if (layoutParams != null) {
                                        layoutParams.topMargin = i3;
                                        view.setLayoutParams(layoutParams);
                                    }
                                    z11 = false;
                                } else if (!(view instanceof TbListTextView)) {
                                    if (!(view2 instanceof ImageView) && !(view2 instanceof RelativeLayout)) {
                                        layoutParams.topMargin = this.f13504e.f55013d;
                                    } else {
                                        layoutParams.topMargin = this.f13504e.w;
                                    }
                                    view.setLayoutParams(layoutParams);
                                } else if ((!(view instanceof ImageView) && !(view instanceof RelativeLayout)) || (tbRichTextData.getType() != 8 && tbRichTextData.getType() != 20 && tbRichTextData.getType() != 17)) {
                                    if ((view instanceof ItemCardView) && !z11) {
                                        layoutParams.topMargin = this.f13504e.B;
                                        view.setLayoutParams(layoutParams);
                                    }
                                } else {
                                    if (view2 instanceof TbListTextView) {
                                        layoutParams.topMargin = this.f13504e.u;
                                    } else if (!(view2 instanceof ImageView) && !(view instanceof RelativeLayout)) {
                                        layoutParams.topMargin = this.f13504e.f55013d;
                                    } else {
                                        layoutParams.topMargin = this.f13504e.t;
                                    }
                                    view.setLayoutParams(layoutParams);
                                }
                                view2 = view;
                            }
                            rVar2 = rVar;
                            gVar = null;
                            z9 = true;
                        } else {
                            i4 = i7;
                            if (next.getType() == 32) {
                                d.a.r0.b1.m.i H = next.H();
                                if (H != null && H.i()) {
                                    tbRichTextData = next;
                                    linearLayout = D(H);
                                } else {
                                    tbRichTextData = next;
                                    linearLayout = B(tbRichTextData);
                                }
                                i7 = i4;
                                N = true;
                                gridImageLayout = linearLayout;
                                view = gridImageLayout;
                                if (N) {
                                    addView(view);
                                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) view.getLayoutParams();
                                    if (!z11) {
                                    }
                                    if (!(view instanceof TbListTextView)) {
                                    }
                                    view2 = view;
                                }
                                rVar2 = rVar;
                                gVar = null;
                                z9 = true;
                            } else {
                                tbRichTextData = next;
                                if (tbRichTextData.getType() == 512) {
                                    View C = C(view2);
                                    if (C == null) {
                                        i7 = i4;
                                        view = C;
                                    } else {
                                        N = P(tbRichTextData, C);
                                        gifView = C;
                                    }
                                } else if (tbRichTextData.getType() == 768) {
                                    View textVoiceView = getTextVoiceView();
                                    N = O(tbRichTextData, (LinearLayout) textVoiceView, rVar2);
                                    gifView = textVoiceView;
                                } else if (tbRichTextData.getType() == 17) {
                                    GifView gifView4 = getGifView();
                                    N = H(tbRichTextData, gifView4);
                                    gifView = gifView4;
                                } else {
                                    if (tbRichTextData.getType() == 20) {
                                        i2 = i4;
                                        if (i2 >= 10) {
                                            i7 = i2;
                                            view = view;
                                        } else {
                                            int i10 = i2 + 1;
                                            boolean z13 = (tbRichTextData == null || tbRichTextData.D() == null || tbRichTextData.D().memeInfo == null || StringUtils.isNull(tbRichTextData.D().memeInfo.pic_url)) ? false : true;
                                            if (z13) {
                                                RelativeLayout b2 = this.k.b();
                                                b2.removeAllViews();
                                                b2.setLayoutParams(new LinearLayout.LayoutParams(tbRichTextData.D().memeInfo.width.intValue(), tbRichTextData.D().memeInfo.height.intValue()));
                                                if (DuiSwitch.getInOn() && this.o) {
                                                    int intValue = tbRichTextData.D().memeInfo.width.intValue();
                                                    int intValue2 = tbRichTextData.D().memeInfo.height.intValue();
                                                    d.a.r0.b1.m.a aVar6 = this.f13504e;
                                                    relativeLayout = b2;
                                                    Y(b2, intValue, intValue2, aVar6.j, aVar6.k);
                                                } else {
                                                    relativeLayout = b2;
                                                    int intValue3 = tbRichTextData.D().memeInfo.width.intValue();
                                                    int intValue4 = tbRichTextData.D().memeInfo.height.intValue();
                                                    d.a.r0.b1.m.a aVar7 = this.f13504e;
                                                    X(relativeLayout, intValue3, intValue4, aVar7.j, aVar7.k);
                                                }
                                                ImageView b3 = this.f13506g.b();
                                                d.a.r0.b1.m.a aVar8 = this.f13504e;
                                                L(tbRichTextData, b3, aVar8.j, aVar8.k);
                                                if (DuiSwitch.getInOn() && this.o) {
                                                    ImageView b4 = this.f13506g.b();
                                                    b4.setTag(this.G);
                                                    if (b4 instanceof TbImageView) {
                                                        TbImageView tbImageView = (TbImageView) b4;
                                                        tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
                                                        tbImageView.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
                                                        tbImageView.setBorderSurroundContent(z9);
                                                        tbImageView.setDrawCorner(z9);
                                                        tbImageView.setDrawBorder(z9);
                                                        tbImageView.setLongIconSupport(z9);
                                                        tbImageView.setGifIconSupport(z9);
                                                        tbImageView.setConrers(15);
                                                        tbImageView.setRadius(this.R);
                                                        tbImageView.setAdjustViewBounds(false);
                                                        if (this.P) {
                                                            tbImageView.setPlaceHolder(2);
                                                        } else {
                                                            tbImageView.setPlaceHolder(3);
                                                        }
                                                    }
                                                    b4.setScaleType(ImageView.ScaleType.FIT_XY);
                                                    int g2 = d.a.c.e.p.l.g(getContext(), R.dimen.ds78);
                                                    int g3 = d.a.c.e.p.l.g(getContext(), R.dimen.ds78);
                                                    b3.setId(R.id.meme_image_view);
                                                    int intValue5 = tbRichTextData.D().memeInfo.width.intValue();
                                                    int intValue6 = tbRichTextData.D().memeInfo.height.intValue();
                                                    d.a.r0.b1.m.a aVar9 = this.f13504e;
                                                    i5 = i8;
                                                    Z(b3, intValue5, intValue6, aVar9.j, aVar9.k, this.b0);
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
                                                    b4.setOnClickListener(this.b0);
                                                    if (relativeLayout2.getLeft() > 0) {
                                                        layoutParams3.rightMargin = d.a.c.e.p.l.g(getContext(), R.dimen.ds6);
                                                    }
                                                    SkinManager.setImageResource(b4, R.drawable.icon_emotion_dui_n);
                                                    relativeLayout2.addView(b4, layoutParams3);
                                                } else {
                                                    i5 = i8;
                                                    relativeLayout2 = relativeLayout;
                                                    int intValue7 = tbRichTextData.D().memeInfo.width.intValue();
                                                    int intValue8 = tbRichTextData.D().memeInfo.height.intValue();
                                                    d.a.r0.b1.m.a aVar10 = this.f13504e;
                                                    b0(b3, intValue7, intValue8, aVar10.j, aVar10.k, this.b0);
                                                    relativeLayout2.addView(b3);
                                                }
                                                view = relativeLayout2;
                                                i7 = i10;
                                                N = z13;
                                                i8 = i5;
                                            } else {
                                                i7 = i10;
                                                N = z13;
                                                view = view;
                                            }
                                        }
                                    } else {
                                        int i11 = i8;
                                        if (tbRichTextData.getType() == 1280) {
                                            ImageView z14 = z(getContext());
                                            i8 = i11 + 1;
                                            i7 = i4;
                                            N = K(tbRichTextData, z14, (this.f13504e.j - getPaddingLeft()) - getPaddingRight(), this.f13504e.k);
                                            view = z14;
                                        } else if (tbRichTextData.getType() == 1281) {
                                            i7 = i4;
                                            i8 = i11;
                                            N = J(tbRichTextData);
                                            view = this.n;
                                        } else {
                                            i7 = i4;
                                            i8 = i11;
                                            N = false;
                                            view = view;
                                        }
                                    }
                                    if (N) {
                                    }
                                    rVar2 = rVar;
                                    gVar = null;
                                    z9 = true;
                                }
                                i7 = i4;
                                gridImageLayout = gifView;
                                view = gridImageLayout;
                                if (N) {
                                }
                                rVar2 = rVar;
                                gVar = null;
                                z9 = true;
                            }
                        }
                        tbRichTextData = next;
                        gridImageLayout = textView;
                        view = gridImageLayout;
                        if (N) {
                        }
                        rVar2 = rVar;
                        gVar = null;
                        z9 = true;
                    }
                    i2 = i7;
                    i7 = i2;
                    view = view;
                }
                if (view2 instanceof TbListTextView) {
                    LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) view2.getLayoutParams();
                    layoutParams4.bottomMargin = this.f13504e.z;
                    view2.setLayoutParams(layoutParams4);
                } else if (view2 != null && this.f13504e.y >= 0) {
                    LinearLayout.LayoutParams layoutParams5 = (LinearLayout.LayoutParams) view2.getLayoutParams();
                    layoutParams5.bottomMargin = this.f13504e.y;
                    view2.setLayoutParams(layoutParams5);
                }
                if (z3 || (aVar = this.f13505f) == null) {
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
        this.f13504e = new d.a.r0.b1.m.a();
        this.f13505f = null;
        this.f13506g = null;
        this.f13507h = null;
        this.f13508i = null;
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
        this.T = false;
        this.U = false;
        this.V = false;
        this.b0 = new g(this);
        this.c0 = new d.a.s0.h2.i.c(new h(this));
        this.i0 = new i(this);
        this.j0 = new b(this);
        this.o0 = new c(this);
        this.p0 = new d(this, 2004018);
        F();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.TbRichTextView);
        this.f13504e.b(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        G();
    }
}
