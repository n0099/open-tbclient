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
import androidx.fragment.app.Fragment;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
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
import d.b.j0.d2.i.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import tbclient.MemeInfo;
import tbclient.PbContent;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes3.dex */
public class TbRichTextView extends LinearLayout implements d.b.c.f.a.i {
    public static final float i0 = d.b.c.e.p.l.h(TbadkCoreApplication.getInst());
    public boolean A;
    public boolean B;
    public Runnable C;
    public boolean D;
    public w E;
    public TbRichText F;
    public boolean G;
    public int H;
    public int I;
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
    public View.OnLongClickListener T;
    public u U;
    public final View.OnClickListener V;
    public final d.b.j0.d2.i.c W;
    public final View.OnClickListener a0;
    public final v b0;
    public boolean c0;
    public Drawable d0;

    /* renamed from: e  reason: collision with root package name */
    public d.b.i0.b1.m.a f13989e;
    public String e0;

    /* renamed from: f  reason: collision with root package name */
    public d.b.j0.d2.a<ImageView> f13990f;
    public BdUniqueId f0;

    /* renamed from: g  reason: collision with root package name */
    public d.b.c.e.k.b<ImageView> f13991g;
    public final d.b.c.e.l.c<d.b.c.j.d.a> g0;

    /* renamed from: h  reason: collision with root package name */
    public d.b.c.e.k.b<TextView> f13992h;
    public CustomMessageListener h0;
    public d.b.c.e.k.b<View> i;
    public d.b.c.e.k.b<LinearLayout> j;
    public d.b.c.e.k.b<RelativeLayout> k;
    public d.b.c.e.k.b<GifView> l;
    public GridImageLayout m;
    public ItemCardView n;
    public boolean o;
    public TextUtils.TruncateAt p;
    public z q;
    public x r;
    public d.b.j0.d2.i.c s;
    public y t;
    public View.OnClickListener u;
    public View.OnClickListener v;
    public boolean w;
    public boolean x;
    public int y;
    public View.OnClickListener z;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TbRichTextData f13993e;

        public a(TbRichTextData tbRichTextData) {
            this.f13993e = tbRichTextData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            HashMap hashMap = new HashMap();
            hashMap.put("itemID", this.f13993e.v().getItemID());
            hashMap.put("source", 3);
            TiebaStatic.log(new StatisticItem("common_click").param("page_type", "a005").param(TiebaStatic.Params.GUA_TYPE, 2).param("obj_locate", 16));
            MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new d.b.j0.d3.h0.m(TbadkApplication.getInst().getApplicationContext(), "GameItemDetailsPage", hashMap)));
        }
    }

    /* loaded from: classes3.dex */
    public class b implements v {
        public b() {
        }

        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.v
        public void dispatchTouchEvent(MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                TbRichTextView.this.N = true;
            } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                TbRichTextView.this.N = false;
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c extends d.b.c.e.l.c<d.b.c.j.d.a> {
        public c() {
        }

        @Override // d.b.c.e.l.c
        public void onCancelled(String str) {
            super.onCancelled(str);
        }

        @Override // d.b.c.e.l.c
        public void onProgressUpdate(Object... objArr) {
            super.onProgressUpdate(objArr);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.c.e.l.c
        public void onLoaded(d.b.c.j.d.a aVar, String str, int i) {
            TbRichTextView.this.x(aVar);
        }
    }

    /* loaded from: classes3.dex */
    public class d extends CustomMessageListener {
        public d(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int contentSizeOfLzl = TbRichTextView.this.K ? TbConfig.getContentSizeOfLzl() : TbConfig.getContentSize();
            if (TbRichTextView.this.F != null && !ListUtils.isEmpty(TbRichTextView.this.F.u())) {
                Iterator<TbRichTextData> it = TbRichTextView.this.F.u().iterator();
                while (it.hasNext()) {
                    TbRichTextData next = it.next();
                    if (next != null) {
                        next.I(contentSizeOfLzl, contentSizeOfLzl);
                    }
                }
            }
            TbRichTextView.this.setTextSize(contentSizeOfLzl);
        }
    }

    /* loaded from: classes3.dex */
    public class e implements d.b.c.e.k.c<ImageView> {
        public e() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.b.c.e.k.c
        public /* bridge */ /* synthetic */ ImageView a(ImageView imageView) {
            ImageView imageView2 = imageView;
            e(imageView2);
            return imageView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.b.c.e.k.c
        public /* bridge */ /* synthetic */ ImageView c(ImageView imageView) {
            ImageView imageView2 = imageView;
            h(imageView2);
            return imageView2;
        }

        public ImageView e(ImageView imageView) {
            if (imageView instanceof TbImageView) {
                TbImageView tbImageView = (TbImageView) imageView;
                tbImageView.setTag(null);
                if (d.b.i0.r.k.c().g()) {
                    tbImageView.setAdjustViewBounds(false);
                    tbImageView.setInterceptOnClick(false);
                } else {
                    tbImageView.setAdjustViewBounds(true);
                    tbImageView.setInterceptOnClick(true);
                }
            }
            return imageView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.c.e.k.c
        /* renamed from: f */
        public void b(ImageView imageView) {
            imageView.setBackgroundDrawable(null);
            imageView.setImageDrawable(null);
            imageView.setTag(null);
            imageView.setOnClickListener(null);
            if (imageView instanceof ForeDrawableImageView) {
                ForeDrawableImageView foreDrawableImageView = (ForeDrawableImageView) imageView;
                foreDrawableImageView.c0();
                foreDrawableImageView.setForegroundDrawable(0);
                foreDrawableImageView.setDefaultBgResource(R.color.common_color_10220);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.c.e.k.c
        /* renamed from: g */
        public ImageView d() {
            ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(d.b.c.a.j.a(TbRichTextView.this.getContext()).getPageActivity());
            boolean g2 = d.b.i0.r.k.c().g();
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

        public ImageView h(ImageView imageView) {
            return imageView;
        }
    }

    /* loaded from: classes3.dex */
    public class f extends d.b.j0.d2.a<ImageView> {
        public f(d.b.c.e.k.c cVar, int i, int i2) {
            super(cVar, i, i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.j0.d2.a
        /* renamed from: i */
        public ImageView h(Object obj) {
            ImageView imageView;
            if (obj instanceof String) {
                Iterator it = this.f42577c.iterator();
                while (it.hasNext()) {
                    imageView = (ImageView) it.next();
                    if ((imageView instanceof TbImageView) && obj.equals(((TbImageView) imageView).getUrl())) {
                        break;
                    }
                }
            }
            imageView = null;
            this.f42577c.remove(imageView);
            return imageView;
        }
    }

    /* loaded from: classes3.dex */
    public class g implements View.OnClickListener {
        public g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MemeInfo memeInfo;
            if (TbRichTextView.this.r == null || !(view instanceof ImageView)) {
                return;
            }
            String str = null;
            Object tag = view.getTag();
            int i = 0;
            int i2 = -1;
            if (tag != null && (tag instanceof TbRichText)) {
                int childCount = TbRichTextView.this.getChildCount();
                while (i < childCount) {
                    i2++;
                    if (view.getParent() == TbRichTextView.this.getChildAt(i)) {
                        break;
                    }
                    i++;
                }
                TbRichTextView.this.r.a(view, null, i2, TbRichTextView.this.L, false);
                return;
            }
            if (tag != null && (tag instanceof String)) {
                str = (String) tag;
            } else {
                boolean z = view instanceof TbImageView;
                if (z && (view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextMemeInfo)) {
                    TbRichTextMemeInfo tbRichTextMemeInfo = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                    String str2 = (tbRichTextMemeInfo == null || (memeInfo = tbRichTextMemeInfo.memeInfo) == null) ? "" : memeInfo.pic_url;
                    int childCount2 = TbRichTextView.this.getChildCount();
                    while (i < childCount2) {
                        i2++;
                        if (view.getParent() == TbRichTextView.this.getChildAt(i)) {
                            break;
                        }
                        i++;
                    }
                    TbRichTextView.this.r.a(view, str2, i2, TbRichTextView.this.L, false);
                    return;
                } else if (z) {
                    str = ((TbImageView) view).getUrl();
                } else if (view instanceof GifView) {
                    str = ((GifView) view).getUrl();
                }
            }
            String str3 = str;
            int childCount3 = TbRichTextView.this.getChildCount();
            while (i < childCount3) {
                View childAt = TbRichTextView.this.getChildAt(i);
                if (TbRichTextView.this.Q(childAt)) {
                    i2++;
                }
                if (view == childAt) {
                    break;
                }
                i++;
            }
            TbRichTextView.this.r.a(view, str3, i2, TbRichTextView.this.L, false);
        }
    }

    /* loaded from: classes3.dex */
    public class h implements c.a {
        public h() {
        }

        @Override // d.b.j0.d2.i.c.a
        public boolean a(View view, MotionEvent motionEvent) {
            if (TbRichTextView.this.V != null) {
                TbRichTextView.this.V.onClick(view);
                return true;
            }
            return false;
        }

        @Override // d.b.j0.d2.i.c.a
        public boolean b(View view, MotionEvent motionEvent) {
            if (TbRichTextView.this.s != null) {
                TbRichTextView.this.s.a(view);
                return TbRichTextView.this.s.onDoubleTap(motionEvent);
            }
            return false;
        }

        @Override // d.b.j0.d2.i.c.a
        public boolean c(View view, MotionEvent motionEvent) {
            return false;
        }
    }

    /* loaded from: classes3.dex */
    public class i implements View.OnClickListener {
        public i() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (TbRichTextView.this.t == null || !(view instanceof TbImageView)) {
                return;
            }
            String str = null;
            Object tag = view.getTag();
            if (tag != null && (tag instanceof t)) {
                str = ((t) tag).f14015a;
            }
            TbRichTextView.this.t.a(view, str);
        }
    }

    /* loaded from: classes3.dex */
    public static class j implements d.b.c.e.k.c<TextView> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f14003a;

        public j(Context context) {
            this.f14003a = context;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.b.c.e.k.c
        public /* bridge */ /* synthetic */ TextView a(TextView textView) {
            TextView textView2 = textView;
            e(textView2);
            return textView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.b.c.e.k.c
        public /* bridge */ /* synthetic */ TextView c(TextView textView) {
            TextView textView2 = textView;
            h(textView2);
            return textView2;
        }

        public TextView e(TextView textView) {
            return textView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.c.e.k.c
        /* renamed from: f */
        public void b(TextView textView) {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.c.e.k.c
        /* renamed from: g */
        public TextView d() {
            return new TbListTextView(this.f14003a);
        }

        public TextView h(TextView textView) {
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
    }

    /* loaded from: classes3.dex */
    public class k implements ViewGroup.OnHierarchyChangeListener {
        public k() {
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewAdded(View view, View view2) {
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewRemoved(View view, View view2) {
            if (view2 instanceof GifView) {
                Object tag = view2.getTag(R.id.tag_rich_text_view_recycle);
                if (!(tag instanceof s) || !((s) tag).f14014a) {
                    if (TbRichTextView.this.l != null) {
                        TbRichTextView.this.l.e((GifView) view2);
                    }
                } else {
                    if (TbRichTextView.this.f13990f == null) {
                        TbRichTextView tbRichTextView = TbRichTextView.this;
                        tbRichTextView.f13990f = tbRichTextView.getRecycleImageViewPool();
                    }
                    TbRichTextView.this.f13990f.e((ImageView) view2);
                }
            } else if (view2 instanceof ImageView) {
                Object tag2 = view2.getTag(R.id.tag_rich_text_view_recycle);
                if (!(tag2 instanceof s) || !((s) tag2).f14014a) {
                    if (TbRichTextView.this.f13991g != null) {
                        TbRichTextView.this.f13991g.e((ImageView) view2);
                    }
                } else {
                    if (TbRichTextView.this.f13990f == null) {
                        TbRichTextView tbRichTextView2 = TbRichTextView.this;
                        tbRichTextView2.f13990f = tbRichTextView2.getRecycleImageViewPool();
                    }
                    TbRichTextView.this.f13990f.e((ImageView) view2);
                }
            } else if ((view2 instanceof TextView) && TbRichTextView.this.f13992h != null) {
                TbRichTextView.this.f13992h.e((TextView) view2);
            } else if ((view2 instanceof PlayVoiceBnt) && TbRichTextView.this.i != null) {
                TbRichTextView.this.i.e(view2);
            } else if ((view2 instanceof PlayVoiceBntNew) && TbRichTextView.this.i != null) {
                TbRichTextView.this.i.e(view2);
            } else if (view2 instanceof GridImageLayout) {
                GridImageLayout gridImageLayout = (GridImageLayout) view2;
                int childCount = gridImageLayout.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = gridImageLayout.getChildAt(i);
                    if ((childAt instanceof GifView) && TbRichTextView.this.l != null) {
                        TbRichTextView.this.l.e((GifView) childAt);
                    } else if ((childAt instanceof ImageView) && TbRichTextView.this.f13991g != null) {
                        TbRichTextView.this.f13991g.e((ImageView) childAt);
                    }
                }
                gridImageLayout.removeAllViews();
                gridImageLayout.f();
            } else if ((view2 instanceof RelativeLayout) && TbRichTextView.this.k != null) {
                TbRichTextView.this.k.e((RelativeLayout) view2);
            }
            if (view2 instanceof LinearLayout) {
                Object tag3 = view2.getTag();
                if (tag3 == null || !(tag3 instanceof String) || !"VideoView".equals(tag3)) {
                    if (TbRichTextView.this.j != null) {
                        LinearLayout linearLayout = (LinearLayout) view2;
                        int childCount2 = linearLayout.getChildCount();
                        for (int i2 = 0; i2 < childCount2; i2++) {
                            View childAt2 = linearLayout.getChildAt(i2);
                            if (childAt2 != null) {
                                if ((childAt2 instanceof TextView) && TbRichTextView.this.f13992h != null) {
                                    TbRichTextView.this.f13992h.e((TextView) childAt2);
                                } else if ((childAt2 instanceof PlayVoiceBnt) && TbRichTextView.this.i != null) {
                                    TbRichTextView.this.i.e(childAt2);
                                } else if ((childAt2 instanceof PlayVoiceBntNew) && TbRichTextView.this.i != null) {
                                    TbRichTextView.this.i.e(childAt2);
                                }
                            }
                        }
                        linearLayout.removeAllViews();
                        TbRichTextView.this.j.e(linearLayout);
                        return;
                    }
                    return;
                }
                view2.setBackgroundDrawable(null);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class l implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.i0.b1.m.i f14005e;

        public l(d.b.i0.b1.m.i iVar) {
            this.f14005e = iVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.log(TbadkCoreStatisticKey.KEY_RICH_TEXT_VIDEO_CLICK);
            XiaoyingUtil.startPlayXiaoyingVideo(TbRichTextView.this.getContext(), this.f14005e.f(), this.f14005e.g(), this.f14005e.d(), this.f14005e.e());
        }
    }

    /* loaded from: classes3.dex */
    public class m implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TbRichTextData f14007e;

        public m(TbRichTextData tbRichTextData) {
            this.f14007e = tbRichTextData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.f14007e.A() != null) {
                if (TbRichTextView.this.getContext() instanceof d.b.i0.b1.m.h) {
                    ((d.b.i0.b1.m.h) TbRichTextView.this.getContext()).onVideoClicked(TbRichTextView.this.getContext(), this.f14007e.A().toString());
                    return;
                }
                d.b.c.a.f<?> a2 = d.b.c.a.j.a(TbRichTextView.this.getContext());
                if (a2 == null || !(a2.getOrignalPage() instanceof d.b.i0.b1.m.h)) {
                    return;
                }
                ((d.b.i0.b1.m.h) a2.getOrignalPage()).onVideoClicked(TbRichTextView.this.getContext(), this.f14007e.A().toString());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class n implements ViewTreeObserver.OnGlobalLayoutListener {
        public n() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            TbRichTextView.this.d0();
            TbRichTextView.this.R.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }
    }

    /* loaded from: classes3.dex */
    public class o implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TbRichTextData f14010e;

        public o(TbRichTextData tbRichTextData) {
            this.f14010e = tbRichTextData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (TbRichTextView.this.E != null) {
                TbRichTextEmotionInfo u = this.f14010e.u();
                w wVar = TbRichTextView.this.E;
                GifInfo gifInfo = u.mGifInfo;
                wVar.a(view, gifInfo.mGid, gifInfo.mPackageName, gifInfo.mIcon, gifInfo.mStaticUrl, gifInfo.mDynamicUrl, gifInfo.mSharpText, gifInfo.mGifWidth, gifInfo.mGifHeight);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class p implements Runnable {
        public p() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!TbRichTextView.this.N && TbRichTextView.this.performLongClick()) {
                TbRichTextView.this.B = true;
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class q {

        /* renamed from: a  reason: collision with root package name */
        public boolean f14013a;

        public q() {
        }

        public /* synthetic */ q(g gVar) {
            this();
        }
    }

    /* loaded from: classes3.dex */
    public interface r {
        void A0(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView);
    }

    /* loaded from: classes3.dex */
    public static class s {

        /* renamed from: a  reason: collision with root package name */
        public boolean f14014a;

        public s() {
        }

        public /* synthetic */ s(g gVar) {
            this();
        }
    }

    /* loaded from: classes3.dex */
    public static class t {

        /* renamed from: a  reason: collision with root package name */
        public String f14015a;

        public t(String str) {
            this.f14015a = str;
        }
    }

    /* loaded from: classes3.dex */
    public interface u {
        void a();
    }

    /* loaded from: classes3.dex */
    public interface v {
        void dispatchTouchEvent(MotionEvent motionEvent);
    }

    /* loaded from: classes3.dex */
    public interface w {
        void a(View view, String str, String str2, String str3, String str4, String str5, String str6, int i, int i2);
    }

    /* loaded from: classes3.dex */
    public interface x {
        void a(View view, String str, int i, boolean z, boolean z2);
    }

    /* loaded from: classes3.dex */
    public interface y {
        void a(View view, String str);
    }

    /* loaded from: classes3.dex */
    public static class z implements AbsListView.RecyclerListener {

        /* renamed from: e  reason: collision with root package name */
        public int f14016e;

        public z(int i) {
            this.f14016e = 0;
            this.f14016e = i;
        }

        @Override // android.widget.AbsListView.RecyclerListener
        public void onMovedToScrapHeap(View view) {
            View findViewById = view.findViewById(this.f14016e);
            if (findViewById == null || !(findViewById instanceof TbRichTextView)) {
                return;
            }
            ((TbRichTextView) findViewById).setText(null);
        }
    }

    public TbRichTextView(Context context) {
        super(context);
        this.f13989e = new d.b.i0.b1.m.a();
        this.f13990f = null;
        this.f13991g = null;
        this.f13992h = null;
        this.i = null;
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
        this.w = true;
        this.x = true;
        this.y = -1;
        this.A = false;
        this.B = false;
        this.C = null;
        this.D = false;
        this.G = false;
        this.H = -1;
        this.I = -1;
        this.J = true;
        this.K = false;
        this.L = false;
        this.M = false;
        this.N = false;
        this.O = false;
        this.P = false;
        this.S = false;
        this.V = new g();
        this.W = new d.b.j0.d2.i.c(new h());
        this.a0 = new i();
        this.b0 = new b();
        this.g0 = new c();
        this.h0 = new d(2004018);
        F();
    }

    public static TbRichText R(Context context, JSONArray jSONArray, int i2) {
        return new TbRichText(context, jSONArray, i2);
    }

    public static TbRichText S(Context context, JSONArray jSONArray, boolean z2) {
        return new TbRichText(context, jSONArray, z2);
    }

    public static TbRichText T(Context context, List<PbContent> list, String str, boolean z2) {
        return new TbRichText(context, list, str, z2);
    }

    public static TbRichText U(Context context, List<PbContent> list, boolean z2) {
        return new TbRichText(context, list, null, z2);
    }

    private GifView getGifView() {
        d.b.c.e.k.b<GifView> bVar = this.l;
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
        b2.setRadius(this.Q);
        if (this.O) {
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

    private GridImageLayout getGridImageView() {
        GridImageLayout gridImageLayout = this.m;
        if (gridImageLayout == null || gridImageLayout.getParent() != null) {
            this.m = new GridImageLayout(getContext());
            this.m.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        }
        this.m.setLayoutStrategy(this.f13989e);
        this.m.setObjectPool(this.f13991g, this.l);
        this.m.setOnImageClickListener(this.r);
        View.OnClickListener onClickListener = this.v;
        if (onClickListener != null) {
            this.m.setOnClickListener(onClickListener);
        }
        this.m.setIsHost(this.L);
        if (this.P) {
            this.m.setOnLongClickListener(this.T);
        }
        return this.m;
    }

    private View getTextVoiceView() {
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
                this.f13992h.e(A);
                this.j.e(b2);
                return null;
            }
            b2.addView(C);
        }
        return b2;
    }

    public static d.b.c.e.k.b<TextView> y(Context context, int i2) {
        return new d.b.c.e.k.b<>(new j(context), i2, 0);
    }

    public final TextView A(Context context) {
        d.b.c.e.k.b<TextView> bVar = this.f13992h;
        TextView b2 = bVar != null ? bVar.b() : null;
        if (b2 == null || b2.getParent() != null) {
            b2 = new TbListTextView(context);
        }
        int i2 = this.f13989e.f50678c;
        b2.setPadding(i2, 0, i2, 0);
        return b2;
    }

    public final LinearLayout B(TbRichTextData tbRichTextData) {
        if (this.f13989e.m <= 0 || tbRichTextData == null) {
            return null;
        }
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setTag("VideoView");
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = this.f13989e.f50679d;
        linearLayout.setClickable(true);
        Bitmap bitmap = SkinManager.getBitmap(this.f13989e.m);
        if (bitmap != null) {
            linearLayout.setBackgroundDrawable(new BitmapDrawable(getContext().getResources(), bitmap));
        }
        linearLayout.setFocusable(false);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOnClickListener(new m(tbRichTextData));
        return linearLayout;
    }

    public final View C(View view) {
        int i2;
        d.b.c.e.k.b<View> bVar = this.i;
        View b2 = bVar != null ? bVar.b() : null;
        if ((b2 == null || b2.getParent() != null) && this.y != -1) {
            b2 = LayoutInflater.from(getContext()).inflate(this.y, (ViewGroup) null);
        }
        if (b2 != null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            if ((view instanceof TbListTextView) && (i2 = this.f13989e.v) >= 0) {
                layoutParams.topMargin = i2;
            } else {
                layoutParams.topMargin = this.f13989e.f50679d;
            }
            layoutParams.bottomMargin = this.f13989e.x;
            b2.setLayoutParams(layoutParams);
            if (b2 instanceof PlayVoiceBntNew) {
                ((PlayVoiceBntNew) b2).setAfterClickListener(this.z);
            }
            return b2;
        }
        return null;
    }

    public final View D(d.b.i0.b1.m.i iVar) {
        if (iVar == null || !iVar.h()) {
            return null;
        }
        ImageView b2 = this.f13991g.b();
        if (b2 instanceof ForeDrawableImageView) {
            ForeDrawableImageView foreDrawableImageView = (ForeDrawableImageView) b2;
            foreDrawableImageView.setForegroundDrawable(R.drawable.icon_play_video);
            foreDrawableImageView.setNoImageBottomTextColor(R.color.CAM_X0108);
            foreDrawableImageView.setNoImageBottomTextPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds32));
            foreDrawableImageView.setNoImageBottomTextSize(TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.fontsize28));
            foreDrawableImageView.setNoImageBottomText("点击播放视频");
            foreDrawableImageView.setInterceptOnClick(false);
            foreDrawableImageView.setTag("VideoView");
            b0(foreDrawableImageView, iVar.g(), iVar.d(), (this.f13989e.j - getPaddingLeft()) - getPaddingRight(), this.f13989e.k, new l(iVar));
            foreDrawableImageView.setDefaultResource(0);
            foreDrawableImageView.setSupportNoImage(this.f13989e.q);
            if (d.b.i0.r.k.c().g()) {
                foreDrawableImageView.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            } else {
                foreDrawableImageView.setDefaultBgResource(R.color.CAM_X0204);
            }
            foreDrawableImageView.W(iVar.e(), 17, false);
        }
        return b2;
    }

    public boolean E() {
        return this.D;
    }

    public final void F() {
        d.b.i0.b1.m.h hVar;
        d.b.c.a.f<?> a2 = d.b.c.a.j.a(getContext());
        if (getContext() instanceof d.b.i0.b1.m.h) {
            hVar = (d.b.i0.b1.m.h) getContext();
        } else {
            hVar = (a2 == null || !(a2.getOrignalPage() instanceof d.b.i0.b1.m.h)) ? null : (d.b.i0.b1.m.h) a2.getOrignalPage();
        }
        if (hVar == null && (getContext() instanceof BaseFragmentActivity)) {
            List<Fragment> fragments = ((BaseFragmentActivity) getContext()).getSupportFragmentManager().getFragments();
            if (!ListUtils.isEmpty(fragments) && (fragments.get(0) instanceof d.b.i0.b1.m.h)) {
                hVar = (d.b.i0.b1.m.h) fragments.get(0);
            }
        }
        if (a2 != null) {
            a2.registerListener(this.h0);
        }
        if (hVar != null) {
            this.f13991g = hVar.getImageViewPool();
            this.f13992h = hVar.getTextViewPool();
            this.i = hVar.getVoiceViewPool();
            this.j = hVar.getTextVoiceViewPool();
            this.l = hVar.getGifViewPool();
            this.k = hVar.getRelativeLayoutPool();
            if (hVar.getListView() != null && this.q == null) {
                this.q = new z(hVar.getRichTextViewId());
                hVar.getListView().setRecyclerListener(this.q);
            }
        }
        this.Q = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds21);
        setOrientation(1);
        setOnHierarchyChangeListener(new k());
    }

    public final void G() {
        int contentSizeOfLzl = this.K ? TbConfig.getContentSizeOfLzl() : TbConfig.getContentSize();
        d.b.i0.b1.m.a aVar = this.f13989e;
        aVar.f50683h = contentSizeOfLzl;
        aVar.f50682g = contentSizeOfLzl;
    }

    public final boolean H(TbRichTextData tbRichTextData, GifView gifView) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) gifView.getLayoutParams();
        if (layoutParams != null && layoutParams.width == tbRichTextData.u().mGifInfo.mGifWidth && layoutParams.height == tbRichTextData.u().mGifInfo.mGifHeight) {
            layoutParams.bottomMargin = 0;
        } else {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(tbRichTextData.u().mGifInfo.mGifWidth, tbRichTextData.u().mGifInfo.mGifHeight);
            layoutParams2.gravity = 3;
            gifView.setLayoutParams(layoutParams2);
        }
        gifView.setOnClickListener(new o(tbRichTextData));
        gifView.w0(tbRichTextData.u().mGifInfo);
        return true;
    }

    public final boolean I(TbRichTextData tbRichTextData, ImageView imageView, int i2, int i3, boolean z2) {
        if (tbRichTextData == null || imageView == null || tbRichTextData.x() == null) {
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
            tbImageView.setTLIconType(tbRichTextData.w());
            tbImageView.setConrers(15);
            tbImageView.setRadius(this.Q);
            if (this.O) {
                tbImageView.setPlaceHolder(2);
            } else {
                tbImageView.setPlaceHolder(3);
            }
            if (this.f13989e.q) {
                tbImageView.setSupportNoImage(true);
            }
            String s2 = this.f13989e.c() ? tbRichTextData.x().s() : tbRichTextData.x().u();
            if (!z2 || tbImageView.getUrl() == null || !tbImageView.getUrl().equals(s2)) {
                tbImageView.W(s2, this.x ? 17 : 18, false);
            }
            if (!tbRichTextData.x().y()) {
                tbImageView.setAdjustViewBounds(false);
            }
            tbImageView.setTag(R.id.tag_rich_text_meme_info, null);
        }
        return a0(imageView, tbRichTextData.x().getWidth(), tbRichTextData.x().getHeight(), i2, i3, this.V);
    }

    public final boolean J(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.v() == null) {
            return false;
        }
        if (this.n == null) {
            ItemCardView itemCardView = new ItemCardView(getContext());
            this.n = itemCardView;
            itemCardView.setOnClickListener(new a(tbRichTextData));
        }
        this.n.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.n.setData(tbRichTextData.v(), 17);
        this.n.b();
        return true;
    }

    public final boolean K(TbRichTextData tbRichTextData, ImageView imageView, int i2, int i3) {
        TbRichTextLinkImageInfo y2;
        if (tbRichTextData == null || imageView == null || (y2 = tbRichTextData.y()) == null || y2.getLink() == null) {
            return false;
        }
        if (imageView instanceof TbImageView) {
            TbImageView tbImageView = (TbImageView) imageView;
            if (this.f13989e.q) {
                tbImageView.setSupportNoImage(true);
            }
            tbImageView.W(y2.s(), this.x ? 17 : 18, false);
            tbImageView.setTag(new t(y2.getLink()));
            if (!y2.t()) {
                tbImageView.setAdjustViewBounds(false);
            }
        }
        return b0(imageView, y2.getWidth(), y2.getHeight(), i2, i3, this.a0);
    }

    public final boolean L(TbRichTextData tbRichTextData, ImageView imageView, int i2, int i3) {
        if (tbRichTextData == null || imageView == null || tbRichTextData.z() == null) {
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
            if (this.f13989e.q) {
                tbImageView.setSupportNoImage(true);
            }
            tbImageView.W(tbRichTextData.z().memeInfo.pic_url, this.x ? 17 : 18, false);
            tbImageView.setAdjustViewBounds(false);
            tbImageView.setTag(R.id.tag_rich_text_meme_info, tbRichTextData.z());
        }
        return b0(imageView, tbRichTextData.z().memeInfo.width.intValue(), tbRichTextData.z().memeInfo.height.intValue(), i2, i3, this.V);
    }

    public final boolean M(TbRichTextData tbRichTextData, GifView gifView, boolean z2) {
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
        String v2 = tbRichTextData.x().v();
        if (StringUtils.isNull(v2)) {
            d.b.i0.b1.m.a aVar = this.f13989e;
            if (aVar.C) {
                v2 = aVar.r ? tbRichTextData.x().s() : tbRichTextData.x().t();
            }
            if (StringUtils.isNull(v2)) {
                v2 = this.f13989e.r ? tbRichTextData.x().u() : tbRichTextData.x().x();
            }
        }
        gifView.setShowStaticDrawable(false);
        if (!z2 || gifView.getUrl() == null || !gifView.getUrl().equals(v2)) {
            gifView.x0(v2, 38);
        }
        int width = tbRichTextData.x().getWidth();
        int height = tbRichTextData.x().getHeight();
        d.b.i0.b1.m.a aVar2 = this.f13989e;
        return a0(gifView, width, height, aVar2.j, aVar2.k, this.V);
    }

    public final boolean N(TbRichTextData tbRichTextData, TextView textView, boolean z2, r rVar) {
        LinearLayout.LayoutParams layoutParams;
        SpannableStringBuilder A;
        int i2;
        this.R = textView;
        if (z2) {
            layoutParams = new LinearLayout.LayoutParams(-1, -2);
        } else {
            layoutParams = new LinearLayout.LayoutParams(-2, -2);
        }
        if (this.G) {
            layoutParams.gravity = 16;
            textView.setGravity(16);
        } else {
            layoutParams.topMargin = this.f13989e.f50679d;
        }
        d.b.i0.b1.m.a aVar = this.f13989e;
        textView.setLineSpacing(aVar.f50677b, aVar.f50676a);
        textView.setTextSize(0, this.f13989e.f50680e);
        if (this.f13989e.f50681f) {
            d.b.i0.r.u.c.d(textView).v(R.string.F_X02);
        }
        textView.setTextColor(this.f13989e.i);
        textView.setLinkTextColor(SkinManager.getColor(R.color.CAM_X0304));
        textView.setHighlightColor(getContext().getResources().getColor(R.color.transparent));
        textView.setSingleLine(this.f13989e.n);
        if (this.M) {
            c0();
        }
        TextUtils.TruncateAt truncateAt = this.p;
        if (truncateAt != null) {
            textView.setEllipsize(truncateAt);
        }
        if (this.S) {
            d.b.i0.r.u.c.d(textView).t(R.array.S_O_X001);
        }
        int i3 = this.H;
        if (i3 > 0) {
            textView.setMaxWidth(i3);
        }
        int i4 = this.I;
        if (i4 > 0) {
            textView.setMaxLines(i4);
        }
        if (tbRichTextData == null || (A = tbRichTextData.A()) == null || A.length() <= 0) {
            return false;
        }
        d.b.i0.b1.m.a aVar2 = this.f13989e;
        int i5 = aVar2.f50683h;
        if (i5 > 0 && (i2 = aVar2.f50682g) > 0) {
            tbRichTextData.I(i2, i5);
        }
        if (rVar != null) {
            rVar.A0(A, textView, this);
        }
        try {
            textView.setText(A);
        } catch (Exception unused) {
            textView.setText("");
        }
        if (this.J) {
            if (tbRichTextData.F()) {
                textView.setMovementMethod(d.b.j0.u3.c.a());
            } else {
                textView.setMovementMethod(LinkMovementMethod.getInstance());
            }
        }
        textView.setFocusable(false);
        textView.setLayoutParams(layoutParams);
        textView.setTag(tbRichTextData);
        if (tbRichTextData == null || tbRichTextData.C() == null) {
            return true;
        }
        tbRichTextData.C().needRecompute = this.c0;
        return true;
    }

    public final boolean O(TbRichTextData tbRichTextData, LinearLayout linearLayout, r rVar) {
        boolean P;
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

    public final boolean P(TbRichTextData tbRichTextData, View view) {
        view.setTag(tbRichTextData.E());
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

    public final boolean Q(View view) {
        if (view instanceof ImageView) {
            if (view instanceof GifView) {
                return view.getTag(R.id.tag_rich_text_view_gif_view) != null && (view.getTag(R.id.tag_rich_text_view_gif_view) instanceof q) && ((q) view.getTag(R.id.tag_rich_text_view_gif_view)).f14013a;
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

    public final void V() {
        this.B = false;
        if (this.C == null) {
            this.C = new p();
        }
        postDelayed(this.C, ViewConfiguration.getLongPressTimeout());
    }

    public final void W() {
        Runnable runnable = this.C;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
    }

    public final void X(RelativeLayout relativeLayout, int i2, int i3, int i4, int i5) {
        int[] l2 = d.b.c.e.p.l.l(i2, i3, i4, i5);
        if (l2 == null) {
            return;
        }
        int[] iArr = {l2[0], l2[1]};
        int i6 = iArr[0];
        int i7 = iArr[1];
        if (this.f13989e.s && i4 > i6) {
            float f2 = i0;
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

    /* JADX WARN: Removed duplicated region for block: B:20:0x0066  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void Y(RelativeLayout relativeLayout, int i2, int i3, int i4, int i5) {
        int i6;
        int i7;
        int g2;
        int[] l2 = d.b.c.e.p.l.l(i2, i3, i4, i5);
        if (l2 == null) {
            return;
        }
        int[] iArr = {l2[0], l2[1]};
        int i8 = iArr[0];
        int i9 = iArr[1];
        if (this.f13989e.s && i4 > i8) {
            float f2 = i0;
            if (f2 > 1.0f) {
                float f3 = i8;
                float f4 = i4;
                if (f3 * f2 > f4) {
                    i7 = i4 - d.b.c.e.p.l.g(getContext(), R.dimen.ds78);
                    g2 = d.b.c.e.p.l.g(getContext(), R.dimen.ds16);
                } else {
                    float f5 = f4 * 0.68f;
                    if (f3 * f2 > f5) {
                        i7 = (int) f5;
                        g2 = d.b.c.e.p.l.g(getContext(), R.dimen.ds78);
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
        View.OnLongClickListener onLongClickListener;
        int[] l2 = d.b.c.e.p.l.l(i2, i3, i4, i5);
        if (l2 == null) {
            return false;
        }
        int[] iArr = {l2[0], l2[1]};
        int i6 = iArr[0];
        int i7 = iArr[1];
        if (this.f13989e.s && i4 > i6) {
            float f2 = i0;
            if (f2 > 1.0f) {
                float f3 = i6;
                float f4 = i4;
                if (f3 * f2 > f4) {
                    i6 = (i4 - d.b.c.e.p.l.g(getContext(), R.dimen.ds78)) - d.b.c.e.p.l.g(getContext(), R.dimen.ds16);
                } else {
                    float f5 = f4 * 0.68f;
                    i6 = f3 * f2 > f5 ? ((int) f5) - d.b.c.e.p.l.g(getContext(), R.dimen.ds78) : (int) (f3 * f2);
                }
                if (iArr[0] > 0) {
                    i7 = (iArr[1] * i6) / iArr[0];
                }
            }
        }
        boolean z2 = imageView instanceof TbImageView;
        if (z2) {
            TbImageView tbImageView = (TbImageView) imageView;
            tbImageView.setDefaultResource(this.f13989e.l);
            if (tbImageView.getGifIconWidth() < i6 && tbImageView.getGifIconHeight() < i7) {
                tbImageView.setGifIconSupport(true);
            } else {
                tbImageView.setGifIconSupport(false);
            }
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i6, i7);
        if (this.f13989e.s) {
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        } else {
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        }
        imageView.setClickable(true);
        imageView.setFocusable(false);
        if (this.s != null && z2) {
            ((TbImageView) imageView).setTbGestureDetector(this.W);
            imageView.setClickable(true);
        } else {
            imageView.setOnClickListener(onClickListener);
        }
        imageView.setLayoutParams(layoutParams);
        if (z2) {
            if (this.T != null) {
                ((TbImageView) imageView).setDispatchTouchListener(this.b0);
                imageView.setOnLongClickListener(this.T);
            }
        } else if ((imageView instanceof GifView) && (onLongClickListener = this.T) != null) {
            imageView.setOnLongClickListener(onLongClickListener);
        }
        return true;
    }

    public final boolean a0(ImageView imageView, int i2, int i3, int i4, int i5, View.OnClickListener onClickListener) {
        int[] e2 = this.f13989e.e(i2, i3, i4, i5);
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
        d.b.i0.b1.m.a aVar = this.f13989e;
        if (aVar.s) {
            imageView.setScaleType(aVar.p);
            if (z2) {
                ((TbImageView) imageView).setOnDrawListener(this.f13989e.F);
            }
        } else {
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        }
        imageView.setClickable(true);
        imageView.setFocusable(false);
        if (this.s != null && z2) {
            ((TbImageView) imageView).setTbGestureDetector(this.W);
            imageView.setClickable(true);
        } else {
            imageView.setOnClickListener(onClickListener);
        }
        imageView.setLayoutParams(layoutParams);
        if (z2) {
            if (this.T != null) {
                ((TbImageView) imageView).setDispatchTouchListener(this.b0);
                imageView.setOnLongClickListener(this.T);
            }
        } else if ((imageView instanceof GifView) && this.T != null) {
            ((GifView) imageView).setDispatchTouchListener(this.b0);
            imageView.setOnLongClickListener(this.T);
        }
        return true;
    }

    public final boolean b0(ImageView imageView, int i2, int i3, int i4, int i5, View.OnClickListener onClickListener) {
        View.OnLongClickListener onLongClickListener;
        int[] l2 = d.b.c.e.p.l.l(i2, i3, i4, i5);
        if (l2 == null) {
            return false;
        }
        int[] iArr = {l2[0], l2[1]};
        int i6 = iArr[0];
        int i7 = iArr[1];
        if (this.f13989e.s && i4 > i6) {
            float f2 = i0;
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
            tbImageView.setDefaultResource(this.f13989e.l);
            if (tbImageView.getGifIconWidth() < i6 && tbImageView.getGifIconHeight() < i7) {
                tbImageView.setGifIconSupport(true);
            } else {
                tbImageView.setGifIconSupport(false);
            }
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i6, i7);
        if (this.f13989e.s) {
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        } else {
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        }
        imageView.setClickable(true);
        imageView.setFocusable(false);
        if (this.s != null && z2) {
            ((TbImageView) imageView).setTbGestureDetector(this.W);
            imageView.setClickable(true);
        } else {
            imageView.setOnClickListener(onClickListener);
        }
        imageView.setLayoutParams(layoutParams);
        if (z2) {
            if (this.T != null) {
                ((TbImageView) imageView).setDispatchTouchListener(this.b0);
                imageView.setOnLongClickListener(this.T);
            }
        } else if ((imageView instanceof GifView) && (onLongClickListener = this.T) != null) {
            imageView.setOnLongClickListener(onLongClickListener);
        }
        return true;
    }

    public final void c0() {
        TextView textView = this.R;
        if (textView != null) {
            textView.getViewTreeObserver().addOnGlobalLayoutListener(new n());
        }
    }

    public final void d0() {
        TextView textView;
        CharSequence text;
        String str;
        if (this.I <= 0 || (textView = this.R) == null || textView.getLineCount() <= this.I) {
            return;
        }
        try {
            text = this.R.getText().subSequence(0, this.R.getLayout().getLineEnd(this.I - 1) - 1);
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

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        this.A = false;
        int action = motionEvent.getAction();
        if ((action == 1 || action == 3) && !this.B) {
            W();
        }
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        if (motionEvent.getAction() == 0 && !this.A) {
            V();
        }
        return dispatchTouchEvent;
    }

    public void e0(String str) {
        BdUniqueId bdUniqueId;
        boolean z2;
        if (TextUtils.isEmpty(str)) {
            this.e0 = str;
            return;
        }
        getContext();
        d.b.c.a.i c2 = d.b.c.a.j.c(getContext());
        if (c2 != null) {
            bdUniqueId = c2.getUniqueId();
            z2 = c2.isScroll();
        } else {
            bdUniqueId = null;
            z2 = false;
        }
        if (!(str.equals(this.e0) && this.f0 == bdUniqueId)) {
            g0();
        }
        this.e0 = str;
        this.f0 = bdUniqueId;
        setBackgroundDrawable(null);
        d.b.c.j.d.a aVar = (d.b.c.j.d.a) d.b.c.e.l.d.h().n(this.e0, 19, new Object[0]);
        if (aVar != null) {
            x(aVar);
        } else if (z2) {
            invalidate();
        } else if (!d.b.c.e.l.d.h().j(19)) {
            invalidate();
        } else {
            d.b.c.e.l.d.h().k(this.e0, 19, this.g0, 0, 0, this.f0, new Object[0]);
        }
    }

    public void f0(String str, u uVar) {
        this.U = uVar;
        e0(str);
    }

    public void g0() {
        if (TextUtils.isEmpty(this.e0)) {
            return;
        }
        d.b.c.e.l.d.h().d(this.e0, 19, this.g0);
        setBackgroundDrawable(null);
    }

    public d.b.i0.b1.m.a getLayoutStrategy() {
        return this.f13989e;
    }

    public x getOnImageClickListener() {
        return this.r;
    }

    public y getOnLinkImageClickListener() {
        return this.t;
    }

    public d.b.j0.d2.a<ImageView> getRecycleImageViewPool() {
        if (this.f13990f == null) {
            this.f13990f = new f(new e(), 10, 0);
        }
        return this.f13990f;
    }

    public TbRichText getRichText() {
        return this.F;
    }

    public TextView getTextView() {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt instanceof TbListTextView) {
                return (TbListTextView) childAt;
            }
        }
        return null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        d.b.i0.b1.m.a aVar = this.f13989e;
        if (aVar != null) {
            aVar.d();
        }
        g0();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.B && (motionEvent.getAction() == 3 || motionEvent.getAction() == 1)) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        g0();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.A = true;
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i2) {
        super.onWindowVisibilityChanged(i2);
        if (i2 != 8 && i2 != 4) {
            refresh();
        } else {
            g0();
        }
    }

    @Override // d.b.c.f.a.i
    public void refresh() {
        e0(this.e0);
    }

    public void setAddTruncateListener(boolean z2) {
        this.M = z2;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.d0 != drawable) {
            this.c0 = true;
            this.d0 = drawable;
        }
        setText(this.F);
        this.c0 = false;
    }

    public void setCommonTextViewOnClickListener(View.OnClickListener onClickListener) {
        this.u = onClickListener;
    }

    public void setDisplayImage(boolean z2, boolean z3) {
        d.b.c.e.k.b<ImageView> bVar;
        if (this.w == z2) {
            return;
        }
        this.w = z2;
        if (z3) {
            requestLayout();
        }
        if (this.w || (bVar = this.f13991g) == null) {
            return;
        }
        bVar.c();
    }

    public void setDuiEnabled(boolean z2) {
        this.o = z2;
    }

    public void setHasMovementMethod(boolean z2) {
        this.J = z2;
    }

    public void setIsFromCDN(boolean z2) {
        this.x = z2;
        d.b.i0.b1.m.a aVar = this.f13989e;
        if (aVar != null) {
            aVar.r = z2;
        }
    }

    public void setIsHost(boolean z2) {
        this.L = z2;
        GridImageLayout gridImageLayout = this.m;
        if (gridImageLayout != null) {
            gridImageLayout.setIsHost(z2);
        }
    }

    public void setIsUseGridImage(boolean z2) {
        this.O = z2;
    }

    public void setLayoutStrategy(d.b.i0.b1.m.a aVar) {
        if (aVar != null) {
            this.f13989e.d();
            this.f13989e = aVar;
            G();
            GridImageLayout gridImageLayout = this.m;
            if (gridImageLayout != null) {
                gridImageLayout.setLayoutStrategy(this.f13989e);
            }
        }
    }

    public void setLinkTextColor(int i2) {
        d.b.i0.b1.m.a aVar = this.f13989e;
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

    public void setMaxLines(int i2) {
        this.I = i2;
        TextView textView = this.R;
        if (textView != null) {
            textView.setMaxLines(i2);
        }
    }

    public void setMaxWidth(int i2) {
        this.H = i2;
    }

    public void setOnEmotionClickListener(w wVar) {
        this.E = wVar;
    }

    public void setOnImageClickListener(x xVar) {
        this.r = xVar;
        GridImageLayout gridImageLayout = this.m;
        if (gridImageLayout != null) {
            gridImageLayout.setOnImageClickListener(xVar);
        }
    }

    public void setOnImageTouchListener(d.b.j0.d2.i.c cVar) {
        this.s = cVar;
    }

    public void setOnLinkImageClickListener(y yVar) {
        this.t = yVar;
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.T = onLongClickListener;
        super.setOnLongClickListener(onLongClickListener);
    }

    public void setOnVoiceAfterClickListener(View.OnClickListener onClickListener) {
        this.z = onClickListener;
    }

    public void setSubPbPost(boolean z2) {
        this.K = z2;
        G();
    }

    public void setText(TbRichText tbRichText) {
        setText(tbRichText, false);
    }

    public void setTextBold() {
        this.f13989e.f50681f = true;
    }

    public void setTextCenter(boolean z2) {
        this.G = z2;
    }

    public void setTextColor(int i2) {
        d.b.i0.b1.m.a aVar = this.f13989e;
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

    public void setTextEllipsize(TextUtils.TruncateAt truncateAt) {
        this.p = truncateAt;
        TextView textView = this.R;
        if (textView != null) {
            textView.setEllipsize(truncateAt);
        }
    }

    public void setTextPadding(int i2) {
        d.b.i0.b1.m.a aVar = this.f13989e;
        if (aVar.f50678c == i2) {
            return;
        }
        aVar.f50678c = i2;
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (childAt != null && (childAt instanceof TextView)) {
                int i4 = this.f13989e.f50678c;
                ((TextView) childAt).setPadding(i4, 0, 0, i4);
            }
        }
    }

    public void setTextSize(float f2) {
        d.b.i0.b1.m.a aVar = this.f13989e;
        if (f2 == aVar.f50680e) {
            return;
        }
        aVar.f50680e = f2;
        int i2 = (int) f2;
        aVar.f50682g = i2;
        aVar.f50683h = i2;
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (childAt instanceof TextView) {
                ((TextView) childAt).setTextSize(0, f2);
            }
        }
    }

    public void setTextViewCheckSelection(boolean z2) {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt instanceof TbListTextView) {
                ((TbListTextView) childAt).setCheckSelection(z2);
            }
        }
    }

    public void setTextViewOnClickListener(View.OnClickListener onClickListener) {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt instanceof TbListTextView) {
                ((TbListTextView) childAt).setOnClickListener(onClickListener);
            }
        }
    }

    public void setTextViewOnTouchListener(View.OnTouchListener onTouchListener) {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt instanceof TbListTextView) {
                ((TbListTextView) childAt).setOnTouchListener(onTouchListener);
            }
        }
    }

    public void setVoiceViewRes(int i2) {
        this.y = i2;
    }

    public void setmGridEmptyClickListener(View.OnClickListener onClickListener) {
        this.v = onClickListener;
    }

    public void setmIsGridImageSupportLongPress(boolean z2) {
        this.P = z2;
    }

    public final void x(d.b.c.j.d.a aVar) {
        if (aVar == null) {
            return;
        }
        try {
            NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(getResources(), aVar.p(), aVar.p().getNinePatchChunk(), aVar.o(), null);
            if (TbadkCoreApplication.getInst().getSkinType() == 1 || TbadkCoreApplication.getInst().getSkinType() == 4) {
                ninePatchDrawable.getPaint().setAlpha(80);
            }
            setBackgroundDrawable(ninePatchDrawable);
            u uVar = this.U;
            if (uVar != null) {
                uVar.a();
            }
        } catch (Exception unused) {
        }
    }

    public final ImageView z(Context context) {
        d.b.c.e.k.b<ImageView> bVar = this.f13991g;
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

    public void setText(TbRichText tbRichText, boolean z2) {
        setText(tbRichText, z2, null);
    }

    public void setText(TbRichText tbRichText, boolean z2, r rVar) {
        setText(tbRichText, z2, rVar, false, false);
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:255:0x0033 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:257:0x0033 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:182:0x04a7 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:192:0x04c9  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x04e3  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0129  */
    /* JADX WARN: Type inference failed for: r0v125, types: [com.baidu.tbadk.gif.GifView, android.view.View] */
    /* JADX WARN: Type inference failed for: r0v153 */
    /* JADX WARN: Type inference failed for: r10v15, types: [android.widget.ImageView] */
    /* JADX WARN: Type inference failed for: r13v5 */
    /* JADX WARN: Type inference failed for: r26v0, types: [android.widget.LinearLayout, com.baidu.tbadk.widget.richText.TbRichTextView] */
    /* JADX WARN: Type inference failed for: r2v60, types: [android.widget.ImageView] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void setText(TbRichText tbRichText, boolean z2, r rVar, boolean z3, boolean z4) {
        ArrayList<TbRichTextData> u2;
        d.b.j0.d2.a<ImageView> aVar;
        int i2;
        boolean N;
        SpannableStringBuilder A;
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
        r rVar2 = rVar;
        if (this.F != tbRichText || (tbRichText != null && tbRichText.isChanged)) {
            if (tbRichText != null) {
                tbRichText.isChanged = false;
            }
            this.F = tbRichText;
            removeAllViews();
            if (tbRichText == null || (u2 = tbRichText.u()) == null) {
                return;
            }
            Iterator<TbRichTextData> it = u2.iterator();
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
                        TextView A2 = A(getContext());
                        N = N(next, A2, z9, rVar2);
                        if (z2 && !this.D && (A = next.A()) != null) {
                            this.D = A.length() >= 200;
                        }
                        if (this.s != null) {
                            A2.setOnTouchListener(this.W);
                            textView = A2;
                        } else {
                            A2.setOnClickListener(this.u);
                            textView = A2;
                        }
                    } else if (next.getType() == 8) {
                        if (this.O) {
                            int i9 = i7;
                            if (z10) {
                                i2 = i9;
                                i7 = i2;
                                view = view;
                            } else {
                                GridImageLayout gridImageView = getGridImageView();
                                gridImageView.setData(tbRichText.w());
                                tbRichTextData = next;
                                i7 = i9;
                                N = true;
                                z10 = true;
                                gridImageLayout = gridImageView;
                            }
                        } else if (i8 < 10) {
                            i8++;
                            if (next.x() == null) {
                                tbRichTextData = next;
                                N = false;
                                gridImageLayout = view;
                            } else if (TbadkCoreApplication.getInst().isGifAutoPlay() && !next.x().A()) {
                                if (z4) {
                                    String v2 = next.x().v();
                                    if (StringUtils.isNull(v2)) {
                                        d.b.i0.b1.m.a aVar2 = this.f13989e;
                                        if (aVar2.C) {
                                            v2 = aVar2.r ? next.x().s() : next.x().t();
                                        }
                                        if (StringUtils.isNull(v2)) {
                                            v2 = this.f13989e.r ? next.x().u() : next.x().x();
                                        }
                                    }
                                    d.b.j0.d2.a<ImageView> aVar3 = this.f13990f;
                                    if (aVar3 != null) {
                                        ImageView h2 = aVar3.h(v2);
                                        if (h2 instanceof GifView) {
                                            onClickListener = (GifView) h2;
                                            if (onClickListener != null) {
                                                gifView3 = getGifView();
                                            } else {
                                                z8 = true;
                                                gifView2 = onClickListener;
                                                q qVar = new q(gVar);
                                                qVar.f14013a = z9;
                                                gifView2.setTag(R.id.tag_rich_text_view_gif_view, qVar);
                                                N = M(next, gifView2, z8);
                                                textView = gifView2;
                                                if (z3) {
                                                    s sVar = new s(gVar);
                                                    sVar.f14014a = z9;
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
                                qVar2.f14013a = z9;
                                gifView2.setTag(R.id.tag_rich_text_view_gif_view, qVar2);
                                N = M(next, gifView2, z8);
                                textView = gifView2;
                                if (z3) {
                                }
                            } else {
                                if (z4) {
                                    String s2 = this.f13989e.c() ? next.x().s() : next.x().u();
                                    d.b.j0.d2.a<ImageView> aVar4 = this.f13990f;
                                    Object obj2 = aVar4 != null ? (ImageView) aVar4.h(s2) : gVar;
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
                                d.b.i0.b1.m.a aVar5 = this.f13989e;
                                ?? r10 = z5;
                                i4 = i7;
                                N = I(next, z5, aVar5.j, aVar5.k, z6);
                                if (z3) {
                                    s sVar2 = new s(gVar);
                                    sVar2.f14014a = z9;
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
                            if (!z11 && (i3 = this.f13989e.A) >= 0) {
                                if (layoutParams != null) {
                                    layoutParams.topMargin = i3;
                                    view.setLayoutParams(layoutParams);
                                }
                                z11 = false;
                            } else if (!(view instanceof TbListTextView)) {
                                if (!(view2 instanceof ImageView) && !(view2 instanceof RelativeLayout)) {
                                    layoutParams.topMargin = this.f13989e.f50679d;
                                } else {
                                    layoutParams.topMargin = this.f13989e.w;
                                }
                                view.setLayoutParams(layoutParams);
                            } else if ((!(view instanceof ImageView) && !(view instanceof RelativeLayout)) || (tbRichTextData.getType() != 8 && tbRichTextData.getType() != 20 && tbRichTextData.getType() != 17)) {
                                if ((view instanceof ItemCardView) && !z11) {
                                    layoutParams.topMargin = this.f13989e.B;
                                    view.setLayoutParams(layoutParams);
                                }
                            } else {
                                if (view2 instanceof TbListTextView) {
                                    layoutParams.topMargin = this.f13989e.u;
                                } else if (!(view2 instanceof ImageView) && !(view instanceof RelativeLayout)) {
                                    layoutParams.topMargin = this.f13989e.f50679d;
                                } else {
                                    layoutParams.topMargin = this.f13989e.t;
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
                            d.b.i0.b1.m.i D = next.D();
                            if (D != null && D.i()) {
                                tbRichTextData = next;
                                linearLayout = D(D);
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
                                        boolean z12 = (tbRichTextData == null || tbRichTextData.z() == null || tbRichTextData.z().memeInfo == null || StringUtils.isNull(tbRichTextData.z().memeInfo.pic_url)) ? false : true;
                                        if (z12) {
                                            RelativeLayout b2 = this.k.b();
                                            b2.removeAllViews();
                                            b2.setLayoutParams(new LinearLayout.LayoutParams(tbRichTextData.z().memeInfo.width.intValue(), tbRichTextData.z().memeInfo.height.intValue()));
                                            if (DuiSwitch.getInOn() && this.o) {
                                                int intValue = tbRichTextData.z().memeInfo.width.intValue();
                                                int intValue2 = tbRichTextData.z().memeInfo.height.intValue();
                                                d.b.i0.b1.m.a aVar6 = this.f13989e;
                                                relativeLayout = b2;
                                                Y(b2, intValue, intValue2, aVar6.j, aVar6.k);
                                            } else {
                                                relativeLayout = b2;
                                                int intValue3 = tbRichTextData.z().memeInfo.width.intValue();
                                                int intValue4 = tbRichTextData.z().memeInfo.height.intValue();
                                                d.b.i0.b1.m.a aVar7 = this.f13989e;
                                                X(relativeLayout, intValue3, intValue4, aVar7.j, aVar7.k);
                                            }
                                            ImageView b3 = this.f13991g.b();
                                            d.b.i0.b1.m.a aVar8 = this.f13989e;
                                            L(tbRichTextData, b3, aVar8.j, aVar8.k);
                                            if (DuiSwitch.getInOn() && this.o) {
                                                ImageView b4 = this.f13991g.b();
                                                b4.setTag(this.F);
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
                                                    tbImageView.setRadius(this.Q);
                                                    tbImageView.setAdjustViewBounds(false);
                                                    if (this.O) {
                                                        tbImageView.setPlaceHolder(2);
                                                    } else {
                                                        tbImageView.setPlaceHolder(3);
                                                    }
                                                }
                                                b4.setScaleType(ImageView.ScaleType.FIT_XY);
                                                int g2 = d.b.c.e.p.l.g(getContext(), R.dimen.ds78);
                                                int g3 = d.b.c.e.p.l.g(getContext(), R.dimen.ds78);
                                                b3.setId(R.id.meme_image_view);
                                                int intValue5 = tbRichTextData.z().memeInfo.width.intValue();
                                                int intValue6 = tbRichTextData.z().memeInfo.height.intValue();
                                                d.b.i0.b1.m.a aVar9 = this.f13989e;
                                                i5 = i8;
                                                Z(b3, intValue5, intValue6, aVar9.j, aVar9.k, this.V);
                                                relativeLayout2 = relativeLayout;
                                                relativeLayout2.addView(b3);
                                                if (g3 > tbRichTextData.z().memeInfo.height.intValue()) {
                                                    g2 /= 2;
                                                    i6 = g3 / 2;
                                                } else {
                                                    i6 = g3;
                                                }
                                                RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(g2, i6);
                                                layoutParams3.addRule(8, R.id.meme_image_view);
                                                layoutParams3.addRule(11);
                                                b4.setOnClickListener(this.V);
                                                if (relativeLayout2.getLeft() > 0) {
                                                    layoutParams3.rightMargin = d.b.c.e.p.l.g(getContext(), R.dimen.ds6);
                                                }
                                                SkinManager.setImageResource(b4, R.drawable.icon_emotion_dui_n);
                                                relativeLayout2.addView(b4, layoutParams3);
                                            } else {
                                                i5 = i8;
                                                relativeLayout2 = relativeLayout;
                                                int intValue7 = tbRichTextData.z().memeInfo.width.intValue();
                                                int intValue8 = tbRichTextData.z().memeInfo.height.intValue();
                                                d.b.i0.b1.m.a aVar10 = this.f13989e;
                                                b0(b3, intValue7, intValue8, aVar10.j, aVar10.k, this.V);
                                                relativeLayout2.addView(b3);
                                            }
                                            view = relativeLayout2;
                                            i7 = i10;
                                            N = z12;
                                            i8 = i5;
                                        } else {
                                            i7 = i10;
                                            N = z12;
                                            view = view;
                                        }
                                    }
                                } else {
                                    int i11 = i8;
                                    if (tbRichTextData.getType() == 1280) {
                                        ImageView z13 = z(getContext());
                                        i8 = i11 + 1;
                                        i7 = i4;
                                        N = K(tbRichTextData, z13, (this.f13989e.j - getPaddingLeft()) - getPaddingRight(), this.f13989e.k);
                                        view = z13;
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
                layoutParams4.bottomMargin = this.f13989e.z;
                view2.setLayoutParams(layoutParams4);
            } else if (view2 != null && this.f13989e.y >= 0) {
                LinearLayout.LayoutParams layoutParams5 = (LinearLayout.LayoutParams) view2.getLayoutParams();
                layoutParams5.bottomMargin = this.f13989e.y;
                view2.setLayoutParams(layoutParams5);
            }
            if (z3 || (aVar = this.f13990f) == null) {
                return;
            }
            aVar.c();
        }
    }

    public TbRichTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f13989e = new d.b.i0.b1.m.a();
        this.f13990f = null;
        this.f13991g = null;
        this.f13992h = null;
        this.i = null;
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
        this.w = true;
        this.x = true;
        this.y = -1;
        this.A = false;
        this.B = false;
        this.C = null;
        this.D = false;
        this.G = false;
        this.H = -1;
        this.I = -1;
        this.J = true;
        this.K = false;
        this.L = false;
        this.M = false;
        this.N = false;
        this.O = false;
        this.P = false;
        this.S = false;
        this.V = new g();
        this.W = new d.b.j0.d2.i.c(new h());
        this.a0 = new i();
        this.b0 = new b();
        this.g0 = new c();
        this.h0 = new d(2004018);
        F();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.TbRichTextView);
        this.f13989e.b(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        G();
    }
}
