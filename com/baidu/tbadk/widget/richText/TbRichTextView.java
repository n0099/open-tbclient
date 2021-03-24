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
import d.b.i0.c2.i.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import tbclient.MemeInfo;
import tbclient.PbContent;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes3.dex */
public class TbRichTextView extends LinearLayout implements d.b.b.f.a.i {
    public static final float h0 = d.b.b.e.p.l.h(TbadkCoreApplication.getInst());
    public boolean A;
    public boolean B;
    public Runnable C;
    public boolean D;
    public v E;
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
    public int P;
    public TextView Q;
    public boolean R;
    public View.OnLongClickListener S;
    public t T;
    public final View.OnClickListener U;
    public final d.b.i0.c2.i.c V;
    public final View.OnClickListener W;
    public final u a0;
    public boolean b0;
    public Drawable c0;
    public String d0;

    /* renamed from: e  reason: collision with root package name */
    public d.b.h0.b1.m.a f14304e;
    public BdUniqueId e0;

    /* renamed from: f  reason: collision with root package name */
    public d.b.i0.c2.a<ImageView> f14305f;
    public final d.b.b.e.l.c<d.b.b.j.d.a> f0;

    /* renamed from: g  reason: collision with root package name */
    public d.b.b.e.k.b<ImageView> f14306g;
    public CustomMessageListener g0;

    /* renamed from: h  reason: collision with root package name */
    public d.b.b.e.k.b<TextView> f14307h;
    public d.b.b.e.k.b<View> i;
    public d.b.b.e.k.b<LinearLayout> j;
    public d.b.b.e.k.b<RelativeLayout> k;
    public d.b.b.e.k.b<GifView> l;
    public GridImageLayout m;
    public ItemCardView n;
    public boolean o;
    public TextUtils.TruncateAt p;
    public y q;
    public w r;
    public d.b.i0.c2.i.c s;
    public x t;
    public View.OnClickListener u;
    public View.OnClickListener v;
    public boolean w;
    public boolean x;
    public int y;
    public View.OnClickListener z;

    /* loaded from: classes3.dex */
    public class a implements u {
        public a() {
        }

        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.u
        public void dispatchTouchEvent(MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                TbRichTextView.this.M = true;
            } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                TbRichTextView.this.M = false;
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends d.b.b.e.l.c<d.b.b.j.d.a> {
        public b() {
        }

        @Override // d.b.b.e.l.c
        public void onCancelled(String str) {
            super.onCancelled(str);
        }

        @Override // d.b.b.e.l.c
        public void onProgressUpdate(Object... objArr) {
            super.onProgressUpdate(objArr);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.b.e.l.c
        public void onLoaded(d.b.b.j.d.a aVar, String str, int i) {
            TbRichTextView.this.v(aVar);
        }
    }

    /* loaded from: classes3.dex */
    public class c extends CustomMessageListener {
        public c(int i) {
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
    public class d implements d.b.b.e.k.c<ImageView> {
        public d() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.b.b.e.k.c
        public /* bridge */ /* synthetic */ ImageView a(ImageView imageView) {
            ImageView imageView2 = imageView;
            e(imageView2);
            return imageView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.b.b.e.k.c
        public /* bridge */ /* synthetic */ ImageView c(ImageView imageView) {
            ImageView imageView2 = imageView;
            h(imageView2);
            return imageView2;
        }

        public ImageView e(ImageView imageView) {
            if (imageView instanceof TbImageView) {
                TbImageView tbImageView = (TbImageView) imageView;
                tbImageView.setTag(null);
                if (d.b.h0.r.k.c().g()) {
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
        @Override // d.b.b.e.k.c
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
        @Override // d.b.b.e.k.c
        /* renamed from: g */
        public ImageView d() {
            ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(d.b.b.a.j.a(TbRichTextView.this.getContext()).getPageActivity());
            boolean g2 = d.b.h0.r.k.c().g();
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
    public class e extends d.b.i0.c2.a<ImageView> {
        public e(d.b.b.e.k.c cVar, int i, int i2) {
            super(cVar, i, i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.i0.c2.a
        /* renamed from: i */
        public ImageView h(Object obj) {
            ImageView imageView;
            if (obj instanceof String) {
                Iterator it = this.f41839c.iterator();
                while (it.hasNext()) {
                    imageView = (ImageView) it.next();
                    if ((imageView instanceof TbImageView) && obj.equals(((TbImageView) imageView).getUrl())) {
                        break;
                    }
                }
            }
            imageView = null;
            this.f41839c.remove(imageView);
            return imageView;
        }
    }

    /* loaded from: classes3.dex */
    public class f implements View.OnClickListener {
        public f() {
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
                if (TbRichTextView.this.O(childAt)) {
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
    public class g implements c.a {
        public g() {
        }

        @Override // d.b.i0.c2.i.c.a
        public boolean a(View view, MotionEvent motionEvent) {
            if (TbRichTextView.this.U != null) {
                TbRichTextView.this.U.onClick(view);
                return true;
            }
            return false;
        }

        @Override // d.b.i0.c2.i.c.a
        public boolean b(View view, MotionEvent motionEvent) {
            if (TbRichTextView.this.s != null) {
                TbRichTextView.this.s.a(view);
                return TbRichTextView.this.s.onDoubleTap(motionEvent);
            }
            return false;
        }

        @Override // d.b.i0.c2.i.c.a
        public boolean c(View view, MotionEvent motionEvent) {
            return false;
        }
    }

    /* loaded from: classes3.dex */
    public class h implements View.OnClickListener {
        public h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (TbRichTextView.this.t == null || !(view instanceof TbImageView)) {
                return;
            }
            String str = null;
            Object tag = view.getTag();
            if (tag != null && (tag instanceof s)) {
                str = ((s) tag).f14329a;
            }
            TbRichTextView.this.t.a(view, str);
        }
    }

    /* loaded from: classes3.dex */
    public static class i implements d.b.b.e.k.c<TextView> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f14316a;

        public i(Context context) {
            this.f14316a = context;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.b.b.e.k.c
        public /* bridge */ /* synthetic */ TextView a(TextView textView) {
            TextView textView2 = textView;
            e(textView2);
            return textView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.b.b.e.k.c
        public /* bridge */ /* synthetic */ TextView c(TextView textView) {
            TextView textView2 = textView;
            h(textView2);
            return textView2;
        }

        public TextView e(TextView textView) {
            return textView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.b.e.k.c
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
        @Override // d.b.b.e.k.c
        /* renamed from: g */
        public TextView d() {
            return new TbListTextView(this.f14316a);
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
    public class j implements ViewGroup.OnHierarchyChangeListener {
        public j() {
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewAdded(View view, View view2) {
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewRemoved(View view, View view2) {
            if (view2 instanceof GifView) {
                Object tag = view2.getTag(R.id.tag_rich_text_view_recycle);
                if (!(tag instanceof r) || !((r) tag).f14328a) {
                    if (TbRichTextView.this.l != null) {
                        TbRichTextView.this.l.e((GifView) view2);
                    }
                } else {
                    if (TbRichTextView.this.f14305f == null) {
                        TbRichTextView tbRichTextView = TbRichTextView.this;
                        tbRichTextView.f14305f = tbRichTextView.getRecycleImageViewPool();
                    }
                    TbRichTextView.this.f14305f.e((ImageView) view2);
                }
            } else if (view2 instanceof ImageView) {
                Object tag2 = view2.getTag(R.id.tag_rich_text_view_recycle);
                if (!(tag2 instanceof r) || !((r) tag2).f14328a) {
                    if (TbRichTextView.this.f14306g != null) {
                        TbRichTextView.this.f14306g.e((ImageView) view2);
                    }
                } else {
                    if (TbRichTextView.this.f14305f == null) {
                        TbRichTextView tbRichTextView2 = TbRichTextView.this;
                        tbRichTextView2.f14305f = tbRichTextView2.getRecycleImageViewPool();
                    }
                    TbRichTextView.this.f14305f.e((ImageView) view2);
                }
            } else if ((view2 instanceof TextView) && TbRichTextView.this.f14307h != null) {
                TbRichTextView.this.f14307h.e((TextView) view2);
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
                    } else if ((childAt instanceof ImageView) && TbRichTextView.this.f14306g != null) {
                        TbRichTextView.this.f14306g.e((ImageView) childAt);
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
                                if ((childAt2 instanceof TextView) && TbRichTextView.this.f14307h != null) {
                                    TbRichTextView.this.f14307h.e((TextView) childAt2);
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
    public class k implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.b1.m.i f14318e;

        public k(d.b.h0.b1.m.i iVar) {
            this.f14318e = iVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.log(TbadkCoreStatisticKey.KEY_RICH_TEXT_VIDEO_CLICK);
            XiaoyingUtil.startPlayXiaoyingVideo(TbRichTextView.this.getContext(), this.f14318e.f(), this.f14318e.g(), this.f14318e.d(), this.f14318e.e());
        }
    }

    /* loaded from: classes3.dex */
    public class l implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TbRichTextData f14320e;

        public l(TbRichTextData tbRichTextData) {
            this.f14320e = tbRichTextData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.f14320e.A() != null) {
                if (TbRichTextView.this.getContext() instanceof d.b.h0.b1.m.h) {
                    ((d.b.h0.b1.m.h) TbRichTextView.this.getContext()).onVideoClicked(TbRichTextView.this.getContext(), this.f14320e.A().toString());
                    return;
                }
                d.b.b.a.f<?> a2 = d.b.b.a.j.a(TbRichTextView.this.getContext());
                if (a2 == null || !(a2.getOrignalPage() instanceof d.b.h0.b1.m.h)) {
                    return;
                }
                ((d.b.h0.b1.m.h) a2.getOrignalPage()).onVideoClicked(TbRichTextView.this.getContext(), this.f14320e.A().toString());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class m implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TbRichTextData f14322e;

        public m(TbRichTextData tbRichTextData) {
            this.f14322e = tbRichTextData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (TbRichTextView.this.E != null) {
                TbRichTextEmotionInfo u = this.f14322e.u();
                v vVar = TbRichTextView.this.E;
                GifInfo gifInfo = u.mGifInfo;
                vVar.a(view, gifInfo.mGid, gifInfo.mPackageName, gifInfo.mIcon, gifInfo.mStaticUrl, gifInfo.mDynamicUrl, gifInfo.mSharpText, gifInfo.mGifWidth, gifInfo.mGifHeight);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class n implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TbRichTextData f14324e;

        public n(TbRichTextData tbRichTextData) {
            this.f14324e = tbRichTextData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            HashMap hashMap = new HashMap();
            hashMap.put("itemID", this.f14324e.v().getItemID());
            hashMap.put("source", 3);
            TiebaStatic.log(new StatisticItem("common_click").param("page_type", "a005").param(TiebaStatic.Params.GUA_TYPE, 2).param("obj_locate", 16));
            MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new d.b.i0.c3.h0.m(TbadkApplication.getInst().getApplicationContext(), "GameItemDetailsPage", hashMap)));
        }
    }

    /* loaded from: classes3.dex */
    public class o implements Runnable {
        public o() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!TbRichTextView.this.M && TbRichTextView.this.performLongClick()) {
                TbRichTextView.this.B = true;
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class p {

        /* renamed from: a  reason: collision with root package name */
        public boolean f14327a;

        public p() {
        }

        public /* synthetic */ p(f fVar) {
            this();
        }
    }

    /* loaded from: classes3.dex */
    public interface q {
        void A0(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView);
    }

    /* loaded from: classes3.dex */
    public static class r {

        /* renamed from: a  reason: collision with root package name */
        public boolean f14328a;

        public r() {
        }

        public /* synthetic */ r(f fVar) {
            this();
        }
    }

    /* loaded from: classes3.dex */
    public static class s {

        /* renamed from: a  reason: collision with root package name */
        public String f14329a;

        public s(String str) {
            this.f14329a = str;
        }
    }

    /* loaded from: classes3.dex */
    public interface t {
        void a();
    }

    /* loaded from: classes3.dex */
    public interface u {
        void dispatchTouchEvent(MotionEvent motionEvent);
    }

    /* loaded from: classes3.dex */
    public interface v {
        void a(View view, String str, String str2, String str3, String str4, String str5, String str6, int i, int i2);
    }

    /* loaded from: classes3.dex */
    public interface w {
        void a(View view, String str, int i, boolean z, boolean z2);
    }

    /* loaded from: classes3.dex */
    public interface x {
        void a(View view, String str);
    }

    /* loaded from: classes3.dex */
    public static class y implements AbsListView.RecyclerListener {

        /* renamed from: e  reason: collision with root package name */
        public int f14330e;

        public y(int i) {
            this.f14330e = 0;
            this.f14330e = i;
        }

        @Override // android.widget.AbsListView.RecyclerListener
        public void onMovedToScrapHeap(View view) {
            View findViewById = view.findViewById(this.f14330e);
            if (findViewById == null || !(findViewById instanceof TbRichTextView)) {
                return;
            }
            ((TbRichTextView) findViewById).setText(null);
        }
    }

    public TbRichTextView(Context context) {
        super(context);
        this.f14304e = new d.b.h0.b1.m.a();
        this.f14305f = null;
        this.f14306g = null;
        this.f14307h = null;
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
        this.R = false;
        this.U = new f();
        this.V = new d.b.i0.c2.i.c(new g());
        this.W = new h();
        this.a0 = new a();
        this.f0 = new b();
        this.g0 = new c(2004018);
        D();
    }

    public static TbRichText P(Context context, JSONArray jSONArray, int i2) {
        return new TbRichText(context, jSONArray, i2);
    }

    public static TbRichText Q(Context context, JSONArray jSONArray, boolean z) {
        return new TbRichText(context, jSONArray, z);
    }

    public static TbRichText R(Context context, List<PbContent> list, String str, boolean z) {
        return new TbRichText(context, list, str, z);
    }

    public static TbRichText S(Context context, List<PbContent> list, boolean z) {
        return new TbRichText(context, list, null, z);
    }

    private GifView getGifView() {
        d.b.b.e.k.b<GifView> bVar = this.l;
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

    private GridImageLayout getGridImageView() {
        GridImageLayout gridImageLayout = this.m;
        if (gridImageLayout == null || gridImageLayout.getParent() != null) {
            this.m = new GridImageLayout(getContext());
            this.m.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        }
        this.m.setLayoutStrategy(this.f14304e);
        this.m.setObjectPool(this.f14306g, this.l);
        this.m.setOnImageClickListener(this.r);
        View.OnClickListener onClickListener = this.v;
        if (onClickListener != null) {
            this.m.setOnClickListener(onClickListener);
        }
        this.m.setIsHost(this.L);
        if (this.O) {
            this.m.setOnLongClickListener(this.S);
        }
        return this.m;
    }

    private View getTextVoiceView() {
        LinearLayout b2 = this.j.b();
        if (b2 != null) {
            TextView y2 = y(getContext());
            if (y2 == null) {
                this.j.e(b2);
                return null;
            }
            b2.addView(y2);
            View A = A(null);
            if (A == null) {
                this.f14307h.e(y2);
                this.j.e(b2);
                return null;
            }
            b2.addView(A);
        }
        return b2;
    }

    public static d.b.b.e.k.b<TextView> w(Context context, int i2) {
        return new d.b.b.e.k.b<>(new i(context), i2, 0);
    }

    public final View A(View view) {
        int i2;
        d.b.b.e.k.b<View> bVar = this.i;
        View b2 = bVar != null ? bVar.b() : null;
        if ((b2 == null || b2.getParent() != null) && this.y != -1) {
            b2 = LayoutInflater.from(getContext()).inflate(this.y, (ViewGroup) null);
        }
        if (b2 != null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            if ((view instanceof TbListTextView) && (i2 = this.f14304e.v) >= 0) {
                layoutParams.topMargin = i2;
            } else {
                layoutParams.topMargin = this.f14304e.f49949d;
            }
            layoutParams.bottomMargin = this.f14304e.x;
            b2.setLayoutParams(layoutParams);
            if (b2 instanceof PlayVoiceBntNew) {
                ((PlayVoiceBntNew) b2).setAfterClickListener(this.z);
            }
            return b2;
        }
        return null;
    }

    public final View B(d.b.h0.b1.m.i iVar) {
        if (iVar == null || !iVar.h()) {
            return null;
        }
        ImageView b2 = this.f14306g.b();
        if (b2 instanceof ForeDrawableImageView) {
            ForeDrawableImageView foreDrawableImageView = (ForeDrawableImageView) b2;
            foreDrawableImageView.setForegroundDrawable(R.drawable.icon_play_video);
            foreDrawableImageView.setNoImageBottomTextColor(R.color.CAM_X0108);
            foreDrawableImageView.setNoImageBottomTextPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds32));
            foreDrawableImageView.setNoImageBottomTextSize(TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.fontsize28));
            foreDrawableImageView.setNoImageBottomText("点击播放视频");
            foreDrawableImageView.setInterceptOnClick(false);
            foreDrawableImageView.setTag("VideoView");
            Z(foreDrawableImageView, iVar.g(), iVar.d(), (this.f14304e.j - getPaddingLeft()) - getPaddingRight(), this.f14304e.k, new k(iVar));
            foreDrawableImageView.setDefaultResource(0);
            foreDrawableImageView.setSupportNoImage(this.f14304e.q);
            if (d.b.h0.r.k.c().g()) {
                foreDrawableImageView.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            } else {
                foreDrawableImageView.setDefaultBgResource(R.color.CAM_X0204);
            }
            foreDrawableImageView.W(iVar.e(), 17, false);
        }
        return b2;
    }

    public boolean C() {
        return this.D;
    }

    public final void D() {
        d.b.h0.b1.m.h hVar;
        d.b.b.a.f<?> a2 = d.b.b.a.j.a(getContext());
        if (getContext() instanceof d.b.h0.b1.m.h) {
            hVar = (d.b.h0.b1.m.h) getContext();
        } else {
            hVar = (a2 == null || !(a2.getOrignalPage() instanceof d.b.h0.b1.m.h)) ? null : (d.b.h0.b1.m.h) a2.getOrignalPage();
        }
        if (hVar == null && (getContext() instanceof BaseFragmentActivity)) {
            List<Fragment> fragments = ((BaseFragmentActivity) getContext()).getSupportFragmentManager().getFragments();
            if (!ListUtils.isEmpty(fragments) && (fragments.get(0) instanceof d.b.h0.b1.m.h)) {
                hVar = (d.b.h0.b1.m.h) fragments.get(0);
            }
        }
        if (a2 != null) {
            a2.registerListener(this.g0);
        }
        if (hVar != null) {
            this.f14306g = hVar.getImageViewPool();
            this.f14307h = hVar.getTextViewPool();
            this.i = hVar.getVoiceViewPool();
            this.j = hVar.getTextVoiceViewPool();
            this.l = hVar.getGifViewPool();
            this.k = hVar.getRelativeLayoutPool();
            if (hVar.getListView() != null && this.q == null) {
                this.q = new y(hVar.getRichTextViewId());
                hVar.getListView().setRecyclerListener(this.q);
            }
        }
        this.P = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds21);
        setOrientation(1);
        setOnHierarchyChangeListener(new j());
    }

    public final void E() {
        int contentSizeOfLzl = this.K ? TbConfig.getContentSizeOfLzl() : TbConfig.getContentSize();
        d.b.h0.b1.m.a aVar = this.f14304e;
        aVar.f49953h = contentSizeOfLzl;
        aVar.f49952g = contentSizeOfLzl;
    }

    public final boolean F(TbRichTextData tbRichTextData, GifView gifView) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) gifView.getLayoutParams();
        if (layoutParams != null && layoutParams.width == tbRichTextData.u().mGifInfo.mGifWidth && layoutParams.height == tbRichTextData.u().mGifInfo.mGifHeight) {
            layoutParams.bottomMargin = 0;
        } else {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(tbRichTextData.u().mGifInfo.mGifWidth, tbRichTextData.u().mGifInfo.mGifHeight);
            layoutParams2.gravity = 3;
            gifView.setLayoutParams(layoutParams2);
        }
        gifView.setOnClickListener(new m(tbRichTextData));
        gifView.w0(tbRichTextData.u().mGifInfo);
        return true;
    }

    public final boolean G(TbRichTextData tbRichTextData, ImageView imageView, int i2, int i3, boolean z) {
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
            tbImageView.setRadius(this.P);
            if (this.N) {
                tbImageView.setPlaceHolder(2);
            } else {
                tbImageView.setPlaceHolder(3);
            }
            if (this.f14304e.q) {
                tbImageView.setSupportNoImage(true);
            }
            String s2 = this.f14304e.c() ? tbRichTextData.x().s() : tbRichTextData.x().u();
            if (!z || tbImageView.getUrl() == null || !tbImageView.getUrl().equals(s2)) {
                tbImageView.W(s2, this.x ? 17 : 18, false);
            }
            if (!tbRichTextData.x().y()) {
                tbImageView.setAdjustViewBounds(false);
            }
            tbImageView.setTag(R.id.tag_rich_text_meme_info, null);
        }
        return Y(imageView, tbRichTextData.x().getWidth(), tbRichTextData.x().getHeight(), i2, i3, this.U);
    }

    public final boolean H(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.v() == null) {
            return false;
        }
        if (this.n == null) {
            ItemCardView itemCardView = new ItemCardView(getContext());
            this.n = itemCardView;
            itemCardView.setOnClickListener(new n(tbRichTextData));
        }
        this.n.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.n.setData(tbRichTextData.v(), 17);
        this.n.b();
        return true;
    }

    public final boolean I(TbRichTextData tbRichTextData, ImageView imageView, int i2, int i3) {
        TbRichTextLinkImageInfo y2;
        if (tbRichTextData == null || imageView == null || (y2 = tbRichTextData.y()) == null || y2.getLink() == null) {
            return false;
        }
        if (imageView instanceof TbImageView) {
            TbImageView tbImageView = (TbImageView) imageView;
            if (this.f14304e.q) {
                tbImageView.setSupportNoImage(true);
            }
            tbImageView.W(y2.s(), this.x ? 17 : 18, false);
            tbImageView.setTag(new s(y2.getLink()));
            if (!y2.t()) {
                tbImageView.setAdjustViewBounds(false);
            }
        }
        return Z(imageView, y2.getWidth(), y2.getHeight(), i2, i3, this.W);
    }

    public final boolean J(TbRichTextData tbRichTextData, ImageView imageView, int i2, int i3) {
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
            tbImageView.setRadius(this.P);
            if (this.N) {
                tbImageView.setPlaceHolder(2);
            } else {
                tbImageView.setPlaceHolder(3);
            }
            if (this.f14304e.q) {
                tbImageView.setSupportNoImage(true);
            }
            tbImageView.W(tbRichTextData.z().memeInfo.pic_url, this.x ? 17 : 18, false);
            tbImageView.setAdjustViewBounds(false);
            tbImageView.setTag(R.id.tag_rich_text_meme_info, tbRichTextData.z());
        }
        return Z(imageView, tbRichTextData.z().memeInfo.width.intValue(), tbRichTextData.z().memeInfo.height.intValue(), i2, i3, this.U);
    }

    public final boolean K(TbRichTextData tbRichTextData, GifView gifView, boolean z) {
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
            d.b.h0.b1.m.a aVar = this.f14304e;
            if (aVar.C) {
                v2 = aVar.r ? tbRichTextData.x().s() : tbRichTextData.x().t();
            }
            if (StringUtils.isNull(v2)) {
                v2 = this.f14304e.r ? tbRichTextData.x().u() : tbRichTextData.x().x();
            }
        }
        gifView.setShowStaticDrawable(false);
        if (!z || gifView.getUrl() == null || !gifView.getUrl().equals(v2)) {
            gifView.x0(v2, 38);
        }
        int width = tbRichTextData.x().getWidth();
        int height = tbRichTextData.x().getHeight();
        d.b.h0.b1.m.a aVar2 = this.f14304e;
        return Y(gifView, width, height, aVar2.j, aVar2.k, this.U);
    }

    public final boolean L(TbRichTextData tbRichTextData, TextView textView, boolean z, q qVar) {
        LinearLayout.LayoutParams layoutParams;
        SpannableStringBuilder A;
        int i2;
        this.Q = textView;
        if (z) {
            layoutParams = new LinearLayout.LayoutParams(-1, -2);
        } else {
            layoutParams = new LinearLayout.LayoutParams(-2, -2);
        }
        if (this.G) {
            layoutParams.gravity = 16;
            textView.setGravity(16);
        } else {
            layoutParams.topMargin = this.f14304e.f49949d;
        }
        d.b.h0.b1.m.a aVar = this.f14304e;
        textView.setLineSpacing(aVar.f49947b, aVar.f49946a);
        textView.setTextSize(0, this.f14304e.f49950e);
        if (this.f14304e.f49951f) {
            d.b.h0.r.u.c.a(textView).s(R.string.F_X02);
        }
        textView.setTextColor(this.f14304e.i);
        textView.setLinkTextColor(SkinManager.getColor(R.color.CAM_X0304));
        textView.setHighlightColor(getContext().getResources().getColor(R.color.transparent));
        textView.setSingleLine(this.f14304e.n);
        TextUtils.TruncateAt truncateAt = this.p;
        if (truncateAt != null) {
            textView.setEllipsize(truncateAt);
        }
        if (this.R) {
            d.b.h0.r.u.c.a(textView).q(R.array.S_O_X001);
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
        d.b.h0.b1.m.a aVar2 = this.f14304e;
        int i5 = aVar2.f49953h;
        if (i5 > 0 && (i2 = aVar2.f49952g) > 0) {
            tbRichTextData.I(i2, i5);
        }
        if (qVar != null) {
            qVar.A0(A, textView, this);
        }
        try {
            textView.setText(A);
        } catch (Exception unused) {
            textView.setText("");
        }
        if (this.J) {
            if (tbRichTextData.F()) {
                textView.setMovementMethod(d.b.i0.t3.c.a());
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
        tbRichTextData.C().needRecompute = this.b0;
        return true;
    }

    public final boolean M(TbRichTextData tbRichTextData, LinearLayout linearLayout, q qVar) {
        boolean N;
        if (linearLayout == null) {
            return false;
        }
        int childCount = linearLayout.getChildCount();
        boolean z = true;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = linearLayout.getChildAt(i2);
            if (childAt != null) {
                if (childAt instanceof TextView) {
                    N = L(tbRichTextData, (TextView) childAt, false, qVar);
                } else if (childAt.getClass().getSimpleName().equals("PlayVoiceBnt")) {
                    N = N(tbRichTextData, childAt);
                } else if (childAt.getClass().getSimpleName().equals("PlayVoiceBntNew")) {
                    N = N(tbRichTextData, childAt);
                }
                z &= N;
            }
        }
        return z;
    }

    public final boolean N(TbRichTextData tbRichTextData, View view) {
        view.setTag(tbRichTextData.E());
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

    public final boolean O(View view) {
        if (view instanceof ImageView) {
            if (view instanceof GifView) {
                return view.getTag(R.id.tag_rich_text_view_gif_view) != null && (view.getTag(R.id.tag_rich_text_view_gif_view) instanceof p) && ((p) view.getTag(R.id.tag_rich_text_view_gif_view)).f14327a;
            }
            if ((view instanceof TbImageView) && view.getTag() != null) {
                if (view.getTag() instanceof s) {
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

    public final void T() {
        this.B = false;
        if (this.C == null) {
            this.C = new o();
        }
        postDelayed(this.C, ViewConfiguration.getLongPressTimeout());
    }

    public final void U() {
        Runnable runnable = this.C;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
    }

    public final void V(RelativeLayout relativeLayout, int i2, int i3, int i4, int i5) {
        int[] l2 = d.b.b.e.p.l.l(i2, i3, i4, i5);
        if (l2 == null) {
            return;
        }
        int[] iArr = {l2[0], l2[1]};
        int i6 = iArr[0];
        int i7 = iArr[1];
        if (this.f14304e.s && i4 > i6) {
            float f2 = h0;
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
    public final void W(RelativeLayout relativeLayout, int i2, int i3, int i4, int i5) {
        int i6;
        int i7;
        int g2;
        int[] l2 = d.b.b.e.p.l.l(i2, i3, i4, i5);
        if (l2 == null) {
            return;
        }
        int[] iArr = {l2[0], l2[1]};
        int i8 = iArr[0];
        int i9 = iArr[1];
        if (this.f14304e.s && i4 > i8) {
            float f2 = h0;
            if (f2 > 1.0f) {
                float f3 = i8;
                float f4 = i4;
                if (f3 * f2 > f4) {
                    i7 = i4 - d.b.b.e.p.l.g(getContext(), R.dimen.ds78);
                    g2 = d.b.b.e.p.l.g(getContext(), R.dimen.ds16);
                } else {
                    float f5 = f4 * 0.68f;
                    if (f3 * f2 > f5) {
                        i7 = (int) f5;
                        g2 = d.b.b.e.p.l.g(getContext(), R.dimen.ds78);
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
        View.OnLongClickListener onLongClickListener;
        int[] l2 = d.b.b.e.p.l.l(i2, i3, i4, i5);
        if (l2 == null) {
            return false;
        }
        int[] iArr = {l2[0], l2[1]};
        int i6 = iArr[0];
        int i7 = iArr[1];
        if (this.f14304e.s && i4 > i6) {
            float f2 = h0;
            if (f2 > 1.0f) {
                float f3 = i6;
                float f4 = i4;
                if (f3 * f2 > f4) {
                    i6 = (i4 - d.b.b.e.p.l.g(getContext(), R.dimen.ds78)) - d.b.b.e.p.l.g(getContext(), R.dimen.ds16);
                } else {
                    float f5 = f4 * 0.68f;
                    i6 = f3 * f2 > f5 ? ((int) f5) - d.b.b.e.p.l.g(getContext(), R.dimen.ds78) : (int) (f3 * f2);
                }
                if (iArr[0] > 0) {
                    i7 = (iArr[1] * i6) / iArr[0];
                }
            }
        }
        boolean z = imageView instanceof TbImageView;
        if (z) {
            TbImageView tbImageView = (TbImageView) imageView;
            tbImageView.setDefaultResource(this.f14304e.l);
            if (tbImageView.getGifIconWidth() < i6 && tbImageView.getGifIconHeight() < i7) {
                tbImageView.setGifIconSupport(true);
            } else {
                tbImageView.setGifIconSupport(false);
            }
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i6, i7);
        if (this.f14304e.s) {
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        } else {
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        }
        imageView.setClickable(true);
        imageView.setFocusable(false);
        if (this.s != null && z) {
            ((TbImageView) imageView).setTbGestureDetector(this.V);
            imageView.setClickable(true);
        } else {
            imageView.setOnClickListener(onClickListener);
        }
        imageView.setLayoutParams(layoutParams);
        if (z) {
            if (this.S != null) {
                ((TbImageView) imageView).setDispatchTouchListener(this.a0);
                imageView.setOnLongClickListener(this.S);
            }
        } else if ((imageView instanceof GifView) && (onLongClickListener = this.S) != null) {
            imageView.setOnLongClickListener(onLongClickListener);
        }
        return true;
    }

    public final boolean Y(ImageView imageView, int i2, int i3, int i4, int i5, View.OnClickListener onClickListener) {
        int[] e2 = this.f14304e.e(i2, i3, i4, i5);
        if (e2 == null) {
            return false;
        }
        int i6 = e2[0];
        int i7 = e2[1];
        boolean z = imageView instanceof TbImageView;
        if (z) {
            TbImageView tbImageView = (TbImageView) imageView;
            if (tbImageView.getGifIconWidth() < i6 && tbImageView.getGifIconHeight() < i7) {
                tbImageView.setGifIconSupport(true);
            } else {
                tbImageView.setGifIconSupport(false);
            }
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i6, i7);
        d.b.h0.b1.m.a aVar = this.f14304e;
        if (aVar.s) {
            imageView.setScaleType(aVar.p);
            if (z) {
                ((TbImageView) imageView).setOnDrawListener(this.f14304e.F);
            }
        } else {
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        }
        imageView.setClickable(true);
        imageView.setFocusable(false);
        if (this.s != null && z) {
            ((TbImageView) imageView).setTbGestureDetector(this.V);
            imageView.setClickable(true);
        } else {
            imageView.setOnClickListener(onClickListener);
        }
        imageView.setLayoutParams(layoutParams);
        if (z) {
            if (this.S != null) {
                ((TbImageView) imageView).setDispatchTouchListener(this.a0);
                imageView.setOnLongClickListener(this.S);
            }
        } else if ((imageView instanceof GifView) && this.S != null) {
            ((GifView) imageView).setDispatchTouchListener(this.a0);
            imageView.setOnLongClickListener(this.S);
        }
        return true;
    }

    public final boolean Z(ImageView imageView, int i2, int i3, int i4, int i5, View.OnClickListener onClickListener) {
        View.OnLongClickListener onLongClickListener;
        int[] l2 = d.b.b.e.p.l.l(i2, i3, i4, i5);
        if (l2 == null) {
            return false;
        }
        int[] iArr = {l2[0], l2[1]};
        int i6 = iArr[0];
        int i7 = iArr[1];
        if (this.f14304e.s && i4 > i6) {
            float f2 = h0;
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
        boolean z = imageView instanceof TbImageView;
        if (z) {
            TbImageView tbImageView = (TbImageView) imageView;
            tbImageView.setDefaultResource(this.f14304e.l);
            if (tbImageView.getGifIconWidth() < i6 && tbImageView.getGifIconHeight() < i7) {
                tbImageView.setGifIconSupport(true);
            } else {
                tbImageView.setGifIconSupport(false);
            }
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i6, i7);
        if (this.f14304e.s) {
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        } else {
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        }
        imageView.setClickable(true);
        imageView.setFocusable(false);
        if (this.s != null && z) {
            ((TbImageView) imageView).setTbGestureDetector(this.V);
            imageView.setClickable(true);
        } else {
            imageView.setOnClickListener(onClickListener);
        }
        imageView.setLayoutParams(layoutParams);
        if (z) {
            if (this.S != null) {
                ((TbImageView) imageView).setDispatchTouchListener(this.a0);
                imageView.setOnLongClickListener(this.S);
            }
        } else if ((imageView instanceof GifView) && (onLongClickListener = this.S) != null) {
            imageView.setOnLongClickListener(onLongClickListener);
        }
        return true;
    }

    public void a0(String str) {
        BdUniqueId bdUniqueId;
        boolean z;
        if (TextUtils.isEmpty(str)) {
            this.d0 = str;
            return;
        }
        getContext();
        d.b.b.a.i c2 = d.b.b.a.j.c(getContext());
        if (c2 != null) {
            bdUniqueId = c2.getUniqueId();
            z = c2.isScroll();
        } else {
            bdUniqueId = null;
            z = false;
        }
        if (!(str.equals(this.d0) && this.e0 == bdUniqueId)) {
            c0();
        }
        this.d0 = str;
        this.e0 = bdUniqueId;
        setBackgroundDrawable(null);
        d.b.b.j.d.a aVar = (d.b.b.j.d.a) d.b.b.e.l.d.h().n(this.d0, 19, new Object[0]);
        if (aVar != null) {
            v(aVar);
        } else if (z) {
            invalidate();
        } else if (!d.b.b.e.l.d.h().j(19)) {
            invalidate();
        } else {
            d.b.b.e.l.d.h().k(this.d0, 19, this.f0, 0, 0, this.e0, new Object[0]);
        }
    }

    public void b0(String str, t tVar) {
        this.T = tVar;
        a0(str);
    }

    public void c0() {
        if (TextUtils.isEmpty(this.d0)) {
            return;
        }
        d.b.b.e.l.d.h().d(this.d0, 19, this.f0);
        setBackgroundDrawable(null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        this.A = false;
        int action = motionEvent.getAction();
        if ((action == 1 || action == 3) && !this.B) {
            U();
        }
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        if (motionEvent.getAction() == 0 && !this.A) {
            T();
        }
        return dispatchTouchEvent;
    }

    public d.b.h0.b1.m.a getLayoutStrategy() {
        return this.f14304e;
    }

    public w getOnImageClickListener() {
        return this.r;
    }

    public x getOnLinkImageClickListener() {
        return this.t;
    }

    public d.b.i0.c2.a<ImageView> getRecycleImageViewPool() {
        if (this.f14305f == null) {
            this.f14305f = new e(new d(), 10, 0);
        }
        return this.f14305f;
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
        d.b.h0.b1.m.a aVar = this.f14304e;
        if (aVar != null) {
            aVar.d();
        }
        c0();
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
        c0();
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
            c0();
        }
    }

    @Override // d.b.b.f.a.i
    public void refresh() {
        a0(this.d0);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.c0 != drawable) {
            this.b0 = true;
            this.c0 = drawable;
        }
        setText(this.F);
        this.b0 = false;
    }

    public void setCommonTextViewOnClickListener(View.OnClickListener onClickListener) {
        this.u = onClickListener;
    }

    public void setDisplayImage(boolean z, boolean z2) {
        d.b.b.e.k.b<ImageView> bVar;
        if (this.w == z) {
            return;
        }
        this.w = z;
        if (z2) {
            requestLayout();
        }
        if (this.w || (bVar = this.f14306g) == null) {
            return;
        }
        bVar.c();
    }

    public void setDuiEnabled(boolean z) {
        this.o = z;
    }

    public void setHasMovementMethod(boolean z) {
        this.J = z;
    }

    public void setIsFromCDN(boolean z) {
        this.x = z;
        d.b.h0.b1.m.a aVar = this.f14304e;
        if (aVar != null) {
            aVar.r = z;
        }
    }

    public void setIsHost(boolean z) {
        this.L = z;
        GridImageLayout gridImageLayout = this.m;
        if (gridImageLayout != null) {
            gridImageLayout.setIsHost(z);
        }
    }

    public void setIsUseGridImage(boolean z) {
        this.N = z;
    }

    public void setLayoutStrategy(d.b.h0.b1.m.a aVar) {
        if (aVar != null) {
            this.f14304e.d();
            this.f14304e = aVar;
            E();
            GridImageLayout gridImageLayout = this.m;
            if (gridImageLayout != null) {
                gridImageLayout.setLayoutStrategy(this.f14304e);
            }
        }
    }

    public void setLinkTextColor(int i2) {
        d.b.h0.b1.m.a aVar = this.f14304e;
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
        TextView textView = this.Q;
        if (textView != null) {
            textView.setMaxLines(i2);
        }
    }

    public void setMaxWidth(int i2) {
        this.H = i2;
    }

    public void setOnEmotionClickListener(v vVar) {
        this.E = vVar;
    }

    public void setOnImageClickListener(w wVar) {
        this.r = wVar;
        GridImageLayout gridImageLayout = this.m;
        if (gridImageLayout != null) {
            gridImageLayout.setOnImageClickListener(wVar);
        }
    }

    public void setOnImageTouchListener(d.b.i0.c2.i.c cVar) {
        this.s = cVar;
    }

    public void setOnLinkImageClickListener(x xVar) {
        this.t = xVar;
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.S = onLongClickListener;
        super.setOnLongClickListener(onLongClickListener);
    }

    public void setOnVoiceAfterClickListener(View.OnClickListener onClickListener) {
        this.z = onClickListener;
    }

    public void setSubPbPost(boolean z) {
        this.K = z;
        E();
    }

    public void setText(TbRichText tbRichText) {
        setText(tbRichText, false);
    }

    public void setTextBold() {
        this.f14304e.f49951f = true;
    }

    public void setTextCenter(boolean z) {
        this.G = z;
    }

    public void setTextColor(int i2) {
        d.b.h0.b1.m.a aVar = this.f14304e;
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
        TextView textView = this.Q;
        if (textView != null) {
            textView.setEllipsize(truncateAt);
        }
    }

    public void setTextPadding(int i2) {
        d.b.h0.b1.m.a aVar = this.f14304e;
        if (aVar.f49948c == i2) {
            return;
        }
        aVar.f49948c = i2;
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (childAt != null && (childAt instanceof TextView)) {
                int i4 = this.f14304e.f49948c;
                ((TextView) childAt).setPadding(i4, 0, 0, i4);
            }
        }
    }

    public void setTextSize(float f2) {
        d.b.h0.b1.m.a aVar = this.f14304e;
        if (f2 == aVar.f49950e) {
            return;
        }
        aVar.f49950e = f2;
        int i2 = (int) f2;
        aVar.f49952g = i2;
        aVar.f49953h = i2;
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (childAt instanceof TextView) {
                ((TextView) childAt).setTextSize(0, f2);
            }
        }
    }

    public void setTextViewCheckSelection(boolean z) {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt instanceof TbListTextView) {
                ((TbListTextView) childAt).setCheckSelection(z);
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

    public void setmIsGridImageSupportLongPress(boolean z) {
        this.O = z;
    }

    public final void v(d.b.b.j.d.a aVar) {
        if (aVar == null) {
            return;
        }
        try {
            NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(getResources(), aVar.p(), aVar.p().getNinePatchChunk(), aVar.o(), null);
            if (TbadkCoreApplication.getInst().getSkinType() == 1 || TbadkCoreApplication.getInst().getSkinType() == 4) {
                ninePatchDrawable.getPaint().setAlpha(80);
            }
            setBackgroundDrawable(ninePatchDrawable);
            t tVar = this.T;
            if (tVar != null) {
                tVar.a();
            }
        } catch (Exception unused) {
        }
    }

    public final ImageView x(Context context) {
        d.b.b.e.k.b<ImageView> bVar = this.f14306g;
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

    public final TextView y(Context context) {
        d.b.b.e.k.b<TextView> bVar = this.f14307h;
        TextView b2 = bVar != null ? bVar.b() : null;
        if (b2 == null || b2.getParent() != null) {
            b2 = new TbListTextView(context);
        }
        int i2 = this.f14304e.f49948c;
        b2.setPadding(i2, 0, i2, 0);
        return b2;
    }

    public final LinearLayout z(TbRichTextData tbRichTextData) {
        if (this.f14304e.m <= 0 || tbRichTextData == null) {
            return null;
        }
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setTag("VideoView");
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = this.f14304e.f49949d;
        linearLayout.setClickable(true);
        Bitmap bitmap = SkinManager.getBitmap(this.f14304e.m);
        if (bitmap != null) {
            linearLayout.setBackgroundDrawable(new BitmapDrawable(getContext().getResources(), bitmap));
        }
        linearLayout.setFocusable(false);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOnClickListener(new l(tbRichTextData));
        return linearLayout;
    }

    public void setText(TbRichText tbRichText, boolean z) {
        setText(tbRichText, z, null);
    }

    public void setText(TbRichText tbRichText, boolean z, q qVar) {
        setText(tbRichText, z, qVar, false, false);
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
    public void setText(TbRichText tbRichText, boolean z, q qVar, boolean z2, boolean z3) {
        ArrayList<TbRichTextData> u2;
        d.b.i0.c2.a<ImageView> aVar;
        int i2;
        boolean L;
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
        Object x2;
        boolean z4;
        boolean z5;
        Object obj;
        boolean z6;
        GifView gifView2;
        GifView gifView3;
        View.OnClickListener onClickListener;
        q qVar2 = qVar;
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
            f fVar = null;
            boolean z7 = true;
            View view = null;
            View view2 = null;
            int i7 = 0;
            int i8 = 0;
            boolean z8 = false;
            boolean z9 = true;
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null) {
                    if (next.getType() == z7) {
                        TextView y2 = y(getContext());
                        L = L(next, y2, z7, qVar2);
                        if (z && !this.D && (A = next.A()) != null) {
                            this.D = A.length() >= 200;
                        }
                        if (this.s != null) {
                            y2.setOnTouchListener(this.V);
                            textView = y2;
                        } else {
                            y2.setOnClickListener(this.u);
                            textView = y2;
                        }
                    } else if (next.getType() == 8) {
                        if (this.N) {
                            int i9 = i7;
                            if (z8) {
                                i2 = i9;
                                i7 = i2;
                                view = view;
                            } else {
                                GridImageLayout gridImageView = getGridImageView();
                                gridImageView.setData(tbRichText.w());
                                tbRichTextData = next;
                                i7 = i9;
                                L = true;
                                z8 = true;
                                gridImageLayout = gridImageView;
                            }
                        } else if (i8 < 10) {
                            i8++;
                            if (next.x() == null) {
                                tbRichTextData = next;
                                L = false;
                                gridImageLayout = view;
                            } else if (TbadkCoreApplication.getInst().isGifAutoPlay() && !next.x().A()) {
                                if (z3) {
                                    String v2 = next.x().v();
                                    if (StringUtils.isNull(v2)) {
                                        d.b.h0.b1.m.a aVar2 = this.f14304e;
                                        if (aVar2.C) {
                                            v2 = aVar2.r ? next.x().s() : next.x().t();
                                        }
                                        if (StringUtils.isNull(v2)) {
                                            v2 = this.f14304e.r ? next.x().u() : next.x().x();
                                        }
                                    }
                                    d.b.i0.c2.a<ImageView> aVar3 = this.f14305f;
                                    if (aVar3 != null) {
                                        ImageView h2 = aVar3.h(v2);
                                        if (h2 instanceof GifView) {
                                            onClickListener = (GifView) h2;
                                            if (onClickListener != null) {
                                                gifView3 = getGifView();
                                            } else {
                                                z6 = true;
                                                gifView2 = onClickListener;
                                                p pVar = new p(fVar);
                                                pVar.f14327a = z7;
                                                gifView2.setTag(R.id.tag_rich_text_view_gif_view, pVar);
                                                L = K(next, gifView2, z6);
                                                textView = gifView2;
                                                if (z2) {
                                                    r rVar = new r(fVar);
                                                    rVar.f14328a = z7;
                                                    gifView2.setTag(R.id.tag_rich_text_view_recycle, rVar);
                                                    textView = gifView2;
                                                }
                                            }
                                        }
                                    }
                                    onClickListener = fVar;
                                    if (onClickListener != null) {
                                    }
                                } else {
                                    gifView3 = getGifView();
                                }
                                z6 = false;
                                gifView2 = gifView3;
                                p pVar2 = new p(fVar);
                                pVar2.f14327a = z7;
                                gifView2.setTag(R.id.tag_rich_text_view_gif_view, pVar2);
                                L = K(next, gifView2, z6);
                                textView = gifView2;
                                if (z2) {
                                }
                            } else {
                                if (z3) {
                                    String s2 = this.f14304e.c() ? next.x().s() : next.x().u();
                                    d.b.i0.c2.a<ImageView> aVar4 = this.f14305f;
                                    Object obj2 = aVar4 != null ? (ImageView) aVar4.h(s2) : fVar;
                                    if (obj2 == null) {
                                        z5 = false;
                                        obj = x(getContext());
                                    } else {
                                        z5 = true;
                                        obj = obj2;
                                    }
                                    x2 = obj;
                                    z4 = z5;
                                } else {
                                    x2 = x(getContext());
                                    z4 = false;
                                }
                                d.b.h0.b1.m.a aVar5 = this.f14304e;
                                ?? r10 = x2;
                                i4 = i7;
                                L = G(next, x2, aVar5.j, aVar5.k, z4);
                                if (z2) {
                                    r rVar2 = new r(fVar);
                                    rVar2.f14328a = z7;
                                    r10.setTag(R.id.tag_rich_text_view_recycle, rVar2);
                                }
                                gifView = r10;
                                tbRichTextData = next;
                                i7 = i4;
                                gridImageLayout = gifView;
                            }
                        }
                        view = gridImageLayout;
                        if (L && view != null) {
                            addView(view);
                            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
                            if (!z9 && (i3 = this.f14304e.A) >= 0) {
                                if (layoutParams != null) {
                                    layoutParams.topMargin = i3;
                                    view.setLayoutParams(layoutParams);
                                }
                                z9 = false;
                            } else if (!(view instanceof TbListTextView)) {
                                if (!(view2 instanceof ImageView) && !(view2 instanceof RelativeLayout)) {
                                    layoutParams.topMargin = this.f14304e.f49949d;
                                } else {
                                    layoutParams.topMargin = this.f14304e.w;
                                }
                                view.setLayoutParams(layoutParams);
                            } else if ((!(view instanceof ImageView) && !(view instanceof RelativeLayout)) || (tbRichTextData.getType() != 8 && tbRichTextData.getType() != 20 && tbRichTextData.getType() != 17)) {
                                if ((view instanceof ItemCardView) && !z9) {
                                    layoutParams.topMargin = this.f14304e.B;
                                    view.setLayoutParams(layoutParams);
                                }
                            } else {
                                if (view2 instanceof TbListTextView) {
                                    layoutParams.topMargin = this.f14304e.u;
                                } else if (!(view2 instanceof ImageView) && !(view instanceof RelativeLayout)) {
                                    layoutParams.topMargin = this.f14304e.f49949d;
                                } else {
                                    layoutParams.topMargin = this.f14304e.t;
                                }
                                view.setLayoutParams(layoutParams);
                            }
                            view2 = view;
                        }
                        qVar2 = qVar;
                        fVar = null;
                        z7 = true;
                    } else {
                        i4 = i7;
                        if (next.getType() == 32) {
                            d.b.h0.b1.m.i D = next.D();
                            if (D != null && D.i()) {
                                tbRichTextData = next;
                                linearLayout = B(D);
                            } else {
                                tbRichTextData = next;
                                linearLayout = z(tbRichTextData);
                            }
                            i7 = i4;
                            L = true;
                            gridImageLayout = linearLayout;
                            view = gridImageLayout;
                            if (L) {
                                addView(view);
                                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) view.getLayoutParams();
                                if (!z9) {
                                }
                                if (!(view instanceof TbListTextView)) {
                                }
                                view2 = view;
                            }
                            qVar2 = qVar;
                            fVar = null;
                            z7 = true;
                        } else {
                            tbRichTextData = next;
                            if (tbRichTextData.getType() == 512) {
                                View A2 = A(view2);
                                if (A2 == null) {
                                    i7 = i4;
                                    view = A2;
                                } else {
                                    L = N(tbRichTextData, A2);
                                    gifView = A2;
                                }
                            } else if (tbRichTextData.getType() == 768) {
                                View textVoiceView = getTextVoiceView();
                                L = M(tbRichTextData, (LinearLayout) textVoiceView, qVar2);
                                gifView = textVoiceView;
                            } else if (tbRichTextData.getType() == 17) {
                                GifView gifView4 = getGifView();
                                L = F(tbRichTextData, gifView4);
                                gifView = gifView4;
                            } else {
                                if (tbRichTextData.getType() == 20) {
                                    i2 = i4;
                                    if (i2 >= 10) {
                                        i7 = i2;
                                        view = view;
                                    } else {
                                        int i10 = i2 + 1;
                                        boolean z10 = (tbRichTextData == null || tbRichTextData.z() == null || tbRichTextData.z().memeInfo == null || StringUtils.isNull(tbRichTextData.z().memeInfo.pic_url)) ? false : true;
                                        if (z10) {
                                            RelativeLayout b2 = this.k.b();
                                            b2.removeAllViews();
                                            b2.setLayoutParams(new LinearLayout.LayoutParams(tbRichTextData.z().memeInfo.width.intValue(), tbRichTextData.z().memeInfo.height.intValue()));
                                            if (DuiSwitch.getInOn() && this.o) {
                                                int intValue = tbRichTextData.z().memeInfo.width.intValue();
                                                int intValue2 = tbRichTextData.z().memeInfo.height.intValue();
                                                d.b.h0.b1.m.a aVar6 = this.f14304e;
                                                relativeLayout = b2;
                                                W(b2, intValue, intValue2, aVar6.j, aVar6.k);
                                            } else {
                                                relativeLayout = b2;
                                                int intValue3 = tbRichTextData.z().memeInfo.width.intValue();
                                                int intValue4 = tbRichTextData.z().memeInfo.height.intValue();
                                                d.b.h0.b1.m.a aVar7 = this.f14304e;
                                                V(relativeLayout, intValue3, intValue4, aVar7.j, aVar7.k);
                                            }
                                            ImageView b3 = this.f14306g.b();
                                            d.b.h0.b1.m.a aVar8 = this.f14304e;
                                            J(tbRichTextData, b3, aVar8.j, aVar8.k);
                                            if (DuiSwitch.getInOn() && this.o) {
                                                ImageView b4 = this.f14306g.b();
                                                b4.setTag(this.F);
                                                if (b4 instanceof TbImageView) {
                                                    TbImageView tbImageView = (TbImageView) b4;
                                                    tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
                                                    tbImageView.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
                                                    tbImageView.setBorderSurroundContent(z7);
                                                    tbImageView.setDrawCorner(z7);
                                                    tbImageView.setDrawBorder(z7);
                                                    tbImageView.setLongIconSupport(z7);
                                                    tbImageView.setGifIconSupport(z7);
                                                    tbImageView.setConrers(15);
                                                    tbImageView.setRadius(this.P);
                                                    tbImageView.setAdjustViewBounds(false);
                                                    if (this.N) {
                                                        tbImageView.setPlaceHolder(2);
                                                    } else {
                                                        tbImageView.setPlaceHolder(3);
                                                    }
                                                }
                                                b4.setScaleType(ImageView.ScaleType.FIT_XY);
                                                int g2 = d.b.b.e.p.l.g(getContext(), R.dimen.ds78);
                                                int g3 = d.b.b.e.p.l.g(getContext(), R.dimen.ds78);
                                                b3.setId(R.id.meme_image_view);
                                                int intValue5 = tbRichTextData.z().memeInfo.width.intValue();
                                                int intValue6 = tbRichTextData.z().memeInfo.height.intValue();
                                                d.b.h0.b1.m.a aVar9 = this.f14304e;
                                                i5 = i8;
                                                X(b3, intValue5, intValue6, aVar9.j, aVar9.k, this.U);
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
                                                b4.setOnClickListener(this.U);
                                                if (relativeLayout2.getLeft() > 0) {
                                                    layoutParams3.rightMargin = d.b.b.e.p.l.g(getContext(), R.dimen.ds6);
                                                }
                                                SkinManager.setImageResource(b4, R.drawable.icon_emotion_dui_n);
                                                relativeLayout2.addView(b4, layoutParams3);
                                            } else {
                                                i5 = i8;
                                                relativeLayout2 = relativeLayout;
                                                int intValue7 = tbRichTextData.z().memeInfo.width.intValue();
                                                int intValue8 = tbRichTextData.z().memeInfo.height.intValue();
                                                d.b.h0.b1.m.a aVar10 = this.f14304e;
                                                Z(b3, intValue7, intValue8, aVar10.j, aVar10.k, this.U);
                                                relativeLayout2.addView(b3);
                                            }
                                            view = relativeLayout2;
                                            i7 = i10;
                                            L = z10;
                                            i8 = i5;
                                        } else {
                                            i7 = i10;
                                            L = z10;
                                            view = view;
                                        }
                                    }
                                } else {
                                    int i11 = i8;
                                    if (tbRichTextData.getType() == 1280) {
                                        ImageView x3 = x(getContext());
                                        i8 = i11 + 1;
                                        i7 = i4;
                                        L = I(tbRichTextData, x3, (this.f14304e.j - getPaddingLeft()) - getPaddingRight(), this.f14304e.k);
                                        view = x3;
                                    } else if (tbRichTextData.getType() == 1281) {
                                        i7 = i4;
                                        i8 = i11;
                                        L = H(tbRichTextData);
                                        view = this.n;
                                    } else {
                                        i7 = i4;
                                        i8 = i11;
                                        L = false;
                                        view = view;
                                    }
                                }
                                if (L) {
                                }
                                qVar2 = qVar;
                                fVar = null;
                                z7 = true;
                            }
                            i7 = i4;
                            gridImageLayout = gifView;
                            view = gridImageLayout;
                            if (L) {
                            }
                            qVar2 = qVar;
                            fVar = null;
                            z7 = true;
                        }
                    }
                    tbRichTextData = next;
                    gridImageLayout = textView;
                    view = gridImageLayout;
                    if (L) {
                    }
                    qVar2 = qVar;
                    fVar = null;
                    z7 = true;
                }
                i2 = i7;
                i7 = i2;
                view = view;
            }
            if (view2 instanceof TbListTextView) {
                LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) view2.getLayoutParams();
                layoutParams4.bottomMargin = this.f14304e.z;
                view2.setLayoutParams(layoutParams4);
            } else if (view2 != null && this.f14304e.y >= 0) {
                LinearLayout.LayoutParams layoutParams5 = (LinearLayout.LayoutParams) view2.getLayoutParams();
                layoutParams5.bottomMargin = this.f14304e.y;
                view2.setLayoutParams(layoutParams5);
            }
            if (z2 || (aVar = this.f14305f) == null) {
                return;
            }
            aVar.c();
        }
    }

    public TbRichTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f14304e = new d.b.h0.b1.m.a();
        this.f14305f = null;
        this.f14306g = null;
        this.f14307h = null;
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
        this.R = false;
        this.U = new f();
        this.V = new d.b.i0.c2.i.c(new g());
        this.W = new h();
        this.a0 = new a();
        this.f0 = new b();
        this.g0 = new c(2004018);
        D();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.TbRichTextView);
        this.f14304e.b(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        E();
    }
}
