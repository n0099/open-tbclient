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
import android.view.KeyEvent;
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
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.o.q;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tbadk.widget.ForeDrawableImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.TbListTextView;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.a.c;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBnt;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import tbclient.PbContent;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes.dex */
public class TbRichTextView extends LinearLayout implements com.baidu.adp.newwidget.ImageView.h {
    private static final float bdc = l.ak(TbadkCoreApplication.getInst());
    private boolean beA;
    private TextUtils.TruncateAt beB;
    private j beC;
    private h beD;
    private com.baidu.tieba.pb.a.c beE;
    private i beF;
    private View.OnClickListener beG;
    private boolean beH;
    private int beI;
    private boolean beJ;
    private boolean beK;
    private Runnable beL;
    private boolean beM;
    private g beN;
    private TbRichText beO;
    private boolean beP;
    private int beQ;
    private boolean beR;
    private boolean beS;
    private boolean beT;
    private e beU;
    public final View.OnClickListener beV;
    private final f beW;
    private boolean beX;
    private Drawable beY;
    private CustomMessageListener beZ;
    private com.baidu.tbadk.widget.richText.a bes;
    private com.baidu.adp.lib.e.b<ImageView> beu;
    private com.baidu.adp.lib.e.b<TextView> bev;
    private com.baidu.adp.lib.e.b<View> bew;
    private com.baidu.adp.lib.e.b<LinearLayout> bex;
    private com.baidu.adp.lib.e.b<RelativeLayout> bey;
    private com.baidu.adp.lib.e.b<GifView> bez;
    private boolean isHost;
    private final com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a> mCallback;
    private final com.baidu.tieba.pb.a.c mInternalGestureDetector;
    private boolean mIsFromCDN;
    private int mMaxWidth;
    private final View.OnClickListener mOnClickListener;
    private BdUniqueId mPageId;
    private final int mType;
    private String mUrl;
    private View.OnLongClickListener onLongClickListener;

    /* loaded from: classes.dex */
    public interface c {
        void a(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView);
    }

    /* loaded from: classes.dex */
    public interface e {
        void NZ();
    }

    /* loaded from: classes.dex */
    public interface f {
        void y(MotionEvent motionEvent);
    }

    /* loaded from: classes.dex */
    public interface g {
        void a(View view, String str, String str2, String str3, String str4, String str5, String str6, int i, int i2);
    }

    /* loaded from: classes.dex */
    public interface h {
        void a(View view, String str, int i, boolean z);
    }

    /* loaded from: classes.dex */
    public interface i {
        void b(View view, String str);
    }

    public void setSubPbPost(boolean z) {
        this.beS = z;
        NV();
    }

    public void setIsHost(boolean z) {
        this.isHost = z;
    }

    public boolean NU() {
        return this.beM;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
        if (this.bes != null) {
            this.bes.mIsFromCDN = z;
        }
    }

    public void setMaxWidth(int i2) {
        this.mMaxWidth = i2;
    }

    public void setMaxLines(int i2) {
        this.beQ = i2;
    }

    public void setTextEllipsize(TextUtils.TruncateAt truncateAt) {
        this.beB = truncateAt;
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
        super.setOnLongClickListener(onLongClickListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class d {
        public String url;

        public d(String str) {
            this.url = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean T(View view) {
        if (view instanceof ImageView) {
            if (view instanceof GifView) {
                return view.getTag() != null && (view.getTag() instanceof b) && ((b) view.getTag()).bfe;
            }
            if ((view instanceof TbImageView) && view.getTag() != null) {
                if (view.getTag() instanceof d) {
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

    public static TbRichText a(Context context, JSONArray jSONArray, int i2) {
        return new TbRichText(context, jSONArray, i2);
    }

    public static TbRichText a(Context context, JSONArray jSONArray, boolean z) {
        return new TbRichText(context, jSONArray, z);
    }

    public static TbRichText a(Context context, List<PbContent> list, boolean z) {
        return new TbRichText(context, list, z);
    }

    public static com.baidu.adp.lib.e.b<TextView> j(final Context context, int i2) {
        return new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<TextView>() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: NY */
            public TextView mo9if() {
                return new TbListTextView(context);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: d */
            public void q(TextView textView) {
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
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: e */
            public TextView r(TextView textView) {
                return textView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: f */
            public TextView s(TextView textView) {
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
        }, i2, 0);
    }

    public TbRichTextView(Context context) {
        super(context);
        this.bes = new com.baidu.tbadk.widget.richText.a();
        this.beu = null;
        this.bev = null;
        this.bew = null;
        this.bex = null;
        this.bey = null;
        this.bez = null;
        this.beA = true;
        this.beB = null;
        this.beC = null;
        this.beD = null;
        this.beE = null;
        this.beF = null;
        this.beG = null;
        this.beH = true;
        this.mIsFromCDN = true;
        this.beI = -1;
        this.beJ = false;
        this.beK = false;
        this.beL = null;
        this.beM = false;
        this.beP = false;
        this.mMaxWidth = -1;
        this.beQ = -1;
        this.beR = true;
        this.beS = false;
        this.isHost = false;
        this.beT = false;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                String str;
                int i2 = 0;
                if (TbRichTextView.this.beD != null && (view instanceof ImageView)) {
                    Object tag = view.getTag();
                    if (tag != null && (tag instanceof TbRichText)) {
                        int childCount = TbRichTextView.this.getChildCount();
                        int i3 = -1;
                        while (i2 < childCount) {
                            i3++;
                            if (view.getParent() == TbRichTextView.this.getChildAt(i2)) {
                                break;
                            }
                            i2++;
                        }
                        TbRichTextView.this.beD.a(view, null, i3, TbRichTextView.this.isHost);
                        return;
                    }
                    if (tag != null && (tag instanceof String)) {
                        url = (String) tag;
                    } else if ((view instanceof TbImageView) && (view.getTag(d.g.tag_rich_text_meme_info) instanceof TbRichTextMemeInfo)) {
                        TbRichTextMemeInfo tbRichTextMemeInfo = (TbRichTextMemeInfo) view.getTag(d.g.tag_rich_text_meme_info);
                        if (tbRichTextMemeInfo != null && tbRichTextMemeInfo.memeInfo != null) {
                            str = tbRichTextMemeInfo.memeInfo.pic_url;
                        } else {
                            str = "";
                        }
                        int childCount2 = TbRichTextView.this.getChildCount();
                        int i4 = -1;
                        while (i2 < childCount2) {
                            i4++;
                            if (view.getParent() == TbRichTextView.this.getChildAt(i2)) {
                                break;
                            }
                            i2++;
                        }
                        TbRichTextView.this.beD.a(view, str, i4, TbRichTextView.this.isHost);
                        return;
                    } else if (view instanceof TbImageView) {
                        url = ((TbImageView) view).getUrl();
                    } else {
                        url = view instanceof GifView ? ((GifView) view).getUrl() : null;
                    }
                    int childCount3 = TbRichTextView.this.getChildCount();
                    int i5 = -1;
                    while (i2 < childCount3) {
                        View childAt = TbRichTextView.this.getChildAt(i2);
                        if (TbRichTextView.this.T(childAt)) {
                            i5++;
                        }
                        if (view == childAt) {
                            break;
                        }
                        i2++;
                    }
                    TbRichTextView.this.beD.a(view, url, i5, TbRichTextView.this.isHost);
                }
            }
        };
        this.mInternalGestureDetector = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.4
            @Override // com.baidu.tieba.pb.a.c.a
            public boolean a(View view, MotionEvent motionEvent) {
                if (TbRichTextView.this.beE != null) {
                    TbRichTextView.this.beE.aW(view);
                    return TbRichTextView.this.beE.onDoubleTap(motionEvent);
                }
                return false;
            }

            @Override // com.baidu.tieba.pb.a.c.a
            public boolean b(View view, MotionEvent motionEvent) {
                return false;
            }

            @Override // com.baidu.tieba.pb.a.c.a
            public boolean c(View view, MotionEvent motionEvent) {
                if (TbRichTextView.this.mOnClickListener != null) {
                    TbRichTextView.this.mOnClickListener.onClick(view);
                    return true;
                }
                return false;
            }
        });
        this.beV = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                if (TbRichTextView.this.beF != null && (view instanceof TbImageView)) {
                    Object tag = view.getTag();
                    if (tag == null || !(tag instanceof d)) {
                        str = null;
                    } else {
                        str = ((d) tag).url;
                    }
                    TbRichTextView.this.beF.b(view, str);
                }
            }
        };
        this.beW = new f() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.11
            @Override // com.baidu.tbadk.widget.richText.TbRichTextView.f
            public void y(MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    TbRichTextView.this.beT = true;
                } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                    TbRichTextView.this.beT = false;
                }
            }
        };
        this.mType = 19;
        this.mCallback = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i2) {
                TbRichTextView.this.f(aVar);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onProgressUpdate(Object... objArr) {
                super.onProgressUpdate(objArr);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onCancelled(String str) {
                super.onCancelled(str);
            }
        };
        this.beZ = new CustomMessageListener(2004018) { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int contentSizeOfLzl = TbRichTextView.this.beS ? TbConfig.getContentSizeOfLzl() : TbConfig.getContentSize();
                if (TbRichTextView.this.beO != null && !w.z(TbRichTextView.this.beO.Ng())) {
                    Iterator<TbRichTextData> it = TbRichTextView.this.beO.Ng().iterator();
                    while (it.hasNext()) {
                        TbRichTextData next = it.next();
                        if (next != null) {
                            next.Q(contentSizeOfLzl, contentSizeOfLzl);
                        }
                    }
                }
                TbRichTextView.this.setTextSize(contentSizeOfLzl);
            }
        };
        init();
    }

    public TbRichTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bes = new com.baidu.tbadk.widget.richText.a();
        this.beu = null;
        this.bev = null;
        this.bew = null;
        this.bex = null;
        this.bey = null;
        this.bez = null;
        this.beA = true;
        this.beB = null;
        this.beC = null;
        this.beD = null;
        this.beE = null;
        this.beF = null;
        this.beG = null;
        this.beH = true;
        this.mIsFromCDN = true;
        this.beI = -1;
        this.beJ = false;
        this.beK = false;
        this.beL = null;
        this.beM = false;
        this.beP = false;
        this.mMaxWidth = -1;
        this.beQ = -1;
        this.beR = true;
        this.beS = false;
        this.isHost = false;
        this.beT = false;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                String str;
                int i2 = 0;
                if (TbRichTextView.this.beD != null && (view instanceof ImageView)) {
                    Object tag = view.getTag();
                    if (tag != null && (tag instanceof TbRichText)) {
                        int childCount = TbRichTextView.this.getChildCount();
                        int i3 = -1;
                        while (i2 < childCount) {
                            i3++;
                            if (view.getParent() == TbRichTextView.this.getChildAt(i2)) {
                                break;
                            }
                            i2++;
                        }
                        TbRichTextView.this.beD.a(view, null, i3, TbRichTextView.this.isHost);
                        return;
                    }
                    if (tag != null && (tag instanceof String)) {
                        url = (String) tag;
                    } else if ((view instanceof TbImageView) && (view.getTag(d.g.tag_rich_text_meme_info) instanceof TbRichTextMemeInfo)) {
                        TbRichTextMemeInfo tbRichTextMemeInfo = (TbRichTextMemeInfo) view.getTag(d.g.tag_rich_text_meme_info);
                        if (tbRichTextMemeInfo != null && tbRichTextMemeInfo.memeInfo != null) {
                            str = tbRichTextMemeInfo.memeInfo.pic_url;
                        } else {
                            str = "";
                        }
                        int childCount2 = TbRichTextView.this.getChildCount();
                        int i4 = -1;
                        while (i2 < childCount2) {
                            i4++;
                            if (view.getParent() == TbRichTextView.this.getChildAt(i2)) {
                                break;
                            }
                            i2++;
                        }
                        TbRichTextView.this.beD.a(view, str, i4, TbRichTextView.this.isHost);
                        return;
                    } else if (view instanceof TbImageView) {
                        url = ((TbImageView) view).getUrl();
                    } else {
                        url = view instanceof GifView ? ((GifView) view).getUrl() : null;
                    }
                    int childCount3 = TbRichTextView.this.getChildCount();
                    int i5 = -1;
                    while (i2 < childCount3) {
                        View childAt = TbRichTextView.this.getChildAt(i2);
                        if (TbRichTextView.this.T(childAt)) {
                            i5++;
                        }
                        if (view == childAt) {
                            break;
                        }
                        i2++;
                    }
                    TbRichTextView.this.beD.a(view, url, i5, TbRichTextView.this.isHost);
                }
            }
        };
        this.mInternalGestureDetector = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.4
            @Override // com.baidu.tieba.pb.a.c.a
            public boolean a(View view, MotionEvent motionEvent) {
                if (TbRichTextView.this.beE != null) {
                    TbRichTextView.this.beE.aW(view);
                    return TbRichTextView.this.beE.onDoubleTap(motionEvent);
                }
                return false;
            }

            @Override // com.baidu.tieba.pb.a.c.a
            public boolean b(View view, MotionEvent motionEvent) {
                return false;
            }

            @Override // com.baidu.tieba.pb.a.c.a
            public boolean c(View view, MotionEvent motionEvent) {
                if (TbRichTextView.this.mOnClickListener != null) {
                    TbRichTextView.this.mOnClickListener.onClick(view);
                    return true;
                }
                return false;
            }
        });
        this.beV = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                if (TbRichTextView.this.beF != null && (view instanceof TbImageView)) {
                    Object tag = view.getTag();
                    if (tag == null || !(tag instanceof d)) {
                        str = null;
                    } else {
                        str = ((d) tag).url;
                    }
                    TbRichTextView.this.beF.b(view, str);
                }
            }
        };
        this.beW = new f() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.11
            @Override // com.baidu.tbadk.widget.richText.TbRichTextView.f
            public void y(MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    TbRichTextView.this.beT = true;
                } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                    TbRichTextView.this.beT = false;
                }
            }
        };
        this.mType = 19;
        this.mCallback = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i2) {
                TbRichTextView.this.f(aVar);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onProgressUpdate(Object... objArr) {
                super.onProgressUpdate(objArr);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onCancelled(String str) {
                super.onCancelled(str);
            }
        };
        this.beZ = new CustomMessageListener(2004018) { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int contentSizeOfLzl = TbRichTextView.this.beS ? TbConfig.getContentSizeOfLzl() : TbConfig.getContentSize();
                if (TbRichTextView.this.beO != null && !w.z(TbRichTextView.this.beO.Ng())) {
                    Iterator<TbRichTextData> it = TbRichTextView.this.beO.Ng().iterator();
                    while (it.hasNext()) {
                        TbRichTextData next = it.next();
                        if (next != null) {
                            next.Q(contentSizeOfLzl, contentSizeOfLzl);
                        }
                    }
                }
                TbRichTextView.this.setTextSize(contentSizeOfLzl);
            }
        };
        init();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.m.TbRichTextView);
        this.bes.b(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        NV();
    }

    public com.baidu.tbadk.widget.richText.a getLayoutStrategy() {
        return this.bes;
    }

    public void setLayoutStrategy(com.baidu.tbadk.widget.richText.a aVar) {
        if (aVar != null) {
            this.bes.release();
            this.bes = aVar;
            NV();
        }
    }

    private void NV() {
        int contentSizeOfLzl = this.beS ? TbConfig.getContentSizeOfLzl() : TbConfig.getContentSize();
        this.bes.bdj = contentSizeOfLzl;
        this.bes.bdi = contentSizeOfLzl;
    }

    private void init() {
        com.baidu.tbadk.widget.richText.e eVar = null;
        com.baidu.adp.base.e<?> ad = com.baidu.adp.base.i.ad(getContext());
        if (getContext() instanceof com.baidu.tbadk.widget.richText.e) {
            eVar = (com.baidu.tbadk.widget.richText.e) getContext();
        } else if (ad != null && (ad.getOrignalPage() instanceof com.baidu.tbadk.widget.richText.e)) {
            eVar = (com.baidu.tbadk.widget.richText.e) ad.getOrignalPage();
        }
        if (ad != null) {
            ad.registerListener(this.beZ);
        }
        if (eVar != null) {
            this.beu = eVar.NM();
            this.bev = eVar.NN();
            this.bew = eVar.NP();
            this.bex = eVar.NQ();
            this.bez = eVar.NO();
            this.bey = eVar.NR();
            if (eVar.getListView() != null && this.beC == null) {
                this.beC = new j(eVar.NL());
                eVar.getListView().setRecyclerListener(this.beC);
            }
        }
        setOrientation(1);
        setOnHierarchyChangeListener(new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.7
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof GifView) && TbRichTextView.this.bez != null) {
                    TbRichTextView.this.bez.p((GifView) view2);
                } else if ((view2 instanceof ImageView) && TbRichTextView.this.beu != null) {
                    TbRichTextView.this.beu.p((ImageView) view2);
                } else if ((view2 instanceof TextView) && TbRichTextView.this.bev != null) {
                    TbRichTextView.this.bev.p((TextView) view2);
                } else if ((view2 instanceof PlayVoiceBnt) && TbRichTextView.this.bew != null) {
                    TbRichTextView.this.bew.p(view2);
                } else if ((view2 instanceof PlayVoiceBntNew) && TbRichTextView.this.bew != null) {
                    TbRichTextView.this.bew.p(view2);
                } else if ((view2 instanceof RelativeLayout) && TbRichTextView.this.bey != null) {
                    TbRichTextView.this.bey.p((RelativeLayout) view2);
                }
                if (view2 instanceof LinearLayout) {
                    Object tag = view2.getTag();
                    if (tag == null || !(tag instanceof String) || !"VideoView".equals(tag)) {
                        if (TbRichTextView.this.bex != null) {
                            int childCount = ((LinearLayout) view2).getChildCount();
                            for (int i2 = 0; i2 < childCount; i2++) {
                                View childAt = ((LinearLayout) view2).getChildAt(i2);
                                if (childAt != null) {
                                    if ((childAt instanceof TextView) && TbRichTextView.this.bev != null) {
                                        TbRichTextView.this.bev.p((TextView) childAt);
                                    } else if ((childAt instanceof PlayVoiceBnt) && TbRichTextView.this.bew != null) {
                                        TbRichTextView.this.bew.p(childAt);
                                    } else if ((childAt instanceof PlayVoiceBntNew) && TbRichTextView.this.bew != null) {
                                        TbRichTextView.this.bew.p(childAt);
                                    }
                                }
                            }
                            ((LinearLayout) view2).removeAllViews();
                            TbRichTextView.this.bex.p((LinearLayout) view2);
                            return;
                        }
                        return;
                    }
                    view2.setBackgroundDrawable(null);
                }
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }
        });
    }

    public void setText(TbRichText tbRichText) {
        setText(tbRichText, false);
    }

    public void setText(TbRichText tbRichText, boolean z) {
        setText(tbRichText, z, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r21v0, types: [com.baidu.tbadk.widget.richText.TbRichTextView] */
    /* JADX WARN: Type inference failed for: r3v38, types: [android.widget.ImageView] */
    /* JADX WARN: Type inference failed for: r4v10 */
    public void setText(TbRichText tbRichText, boolean z, c cVar) {
        ArrayList<TbRichTextData> Ng;
        int i2;
        RelativeLayout relativeLayout;
        int i3;
        SpannableStringBuilder Nn;
        boolean z2;
        View view;
        KeyEvent.Callback a2;
        boolean z3;
        int i4;
        int i5;
        if (this.beO != tbRichText || (tbRichText != null && tbRichText.isChanged)) {
            if (tbRichText != null) {
                tbRichText.isChanged = false;
            }
            this.beO = tbRichText;
            removeAllViews();
            if (tbRichText != null && (Ng = tbRichText.Ng()) != null) {
                View view2 = null;
                boolean z4 = true;
                Iterator<TbRichTextData> it = Ng.iterator();
                int i6 = 0;
                View view3 = null;
                int i7 = 0;
                while (it.hasNext()) {
                    TbRichTextData next = it.next();
                    boolean z5 = false;
                    if (next != null) {
                        if (next.getType() == 1) {
                            TextView bg = bg(getContext());
                            boolean a3 = a(next, bg, true, cVar);
                            if (z && !this.beM && (Nn = next.Nn()) != null) {
                                this.beM = Nn.length() >= 200;
                            }
                            if (this.beE != null) {
                                bg.setOnTouchListener(this.mInternalGestureDetector);
                            } else {
                                bg.setOnClickListener(this.beG);
                            }
                            z5 = a3;
                            i2 = i6;
                            int i8 = i7;
                            relativeLayout = bg;
                            i3 = i8;
                        } else if (next.getType() == 8) {
                            if (i6 < 10) {
                                i6++;
                                if (next.Nm() != null) {
                                    if (TbadkCoreApplication.getInst().isGifAutoPlay() && !next.Nm().NE()) {
                                        GifView gifView = getGifView();
                                        b bVar = new b();
                                        bVar.bfe = true;
                                        gifView.setTag(bVar);
                                        z5 = b(next, gifView);
                                        i3 = i7;
                                        i2 = i6;
                                        relativeLayout = gifView;
                                    } else {
                                        ?? bf = bf(getContext());
                                        z5 = c(next, bf, this.bes.bdk, this.bes.bdl);
                                        i3 = i7;
                                        i2 = i6;
                                        relativeLayout = bf;
                                    }
                                }
                                i3 = i7;
                                i2 = i6;
                                relativeLayout = view3;
                            }
                        } else if (next.getType() == 32) {
                            com.baidu.tbadk.widget.richText.f Nq = next.Nq();
                            if (Nq != null && Nq.NT()) {
                                a2 = b(Nq);
                            } else {
                                a2 = a(next);
                            }
                            i3 = i7;
                            i2 = i6;
                            relativeLayout = a2;
                            z5 = true;
                        } else if (next.getType() == 512) {
                            View voiceView = getVoiceView();
                            if (voiceView == null) {
                                view3 = voiceView;
                            } else {
                                i3 = i7;
                                i2 = i6;
                                relativeLayout = voiceView;
                                z5 = a(next, voiceView);
                            }
                        } else if (next.getType() == 768) {
                            View textVoiceView = getTextVoiceView();
                            z5 = a(next, (LinearLayout) textVoiceView, cVar);
                            i3 = i7;
                            i2 = i6;
                            relativeLayout = textVoiceView;
                        } else if (next.getType() == 17) {
                            GifView gifView2 = getGifView();
                            z5 = a(next, gifView2);
                            i3 = i7;
                            i2 = i6;
                            relativeLayout = gifView2;
                        } else if (next.getType() == 20) {
                            if (i7 < 10) {
                                int i9 = i7 + 1;
                                if (next == null || next.Ns() == null || next.Ns().memeInfo == null || StringUtils.isNull(next.Ns().memeInfo.pic_url)) {
                                    z3 = false;
                                } else {
                                    z3 = true;
                                }
                                if (z3) {
                                    RelativeLayout ie = this.bey.ie();
                                    ie.removeAllViews();
                                    ie.setLayoutParams(new LinearLayout.LayoutParams(next.Ns().memeInfo.width.intValue(), next.Ns().memeInfo.height.intValue()));
                                    if (q.KJ() && this.beA) {
                                        b(ie, next.Ns().memeInfo.width.intValue(), next.Ns().memeInfo.height.intValue(), this.bes.bdk, this.bes.bdl);
                                    } else {
                                        a(ie, next.Ns().memeInfo.width.intValue(), next.Ns().memeInfo.height.intValue(), this.bes.bdk, this.bes.bdl);
                                    }
                                    ImageView ie2 = this.beu.ie();
                                    b(next, ie2, this.bes.bdk, this.bes.bdl);
                                    if (q.KJ() && this.beA) {
                                        ImageView ie3 = this.beu.ie();
                                        ie3.setTag(this.beO);
                                        if (ie3 instanceof TbImageView) {
                                            ((TbImageView) ie3).setAdjustViewBounds(false);
                                        }
                                        ie3.setScaleType(ImageView.ScaleType.FIT_XY);
                                        int e2 = l.e(getContext(), d.e.ds78);
                                        int e3 = l.e(getContext(), d.e.ds78);
                                        ie2.setId(d.g.meme_image_view);
                                        c(ie2, next.Ns().memeInfo.width.intValue(), next.Ns().memeInfo.height.intValue(), this.bes.bdk, this.bes.bdl, this.mOnClickListener);
                                        ie.addView(ie2);
                                        if (e3 > next.Ns().memeInfo.height.intValue()) {
                                            i5 = e2 / 2;
                                            i4 = e3 / 2;
                                        } else {
                                            i4 = e3;
                                            i5 = e2;
                                        }
                                        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i5, i4);
                                        layoutParams.addRule(8, d.g.meme_image_view);
                                        layoutParams.addRule(11);
                                        ie3.setOnClickListener(this.mOnClickListener);
                                        if (ie.getLeft() > 0) {
                                            layoutParams.rightMargin = l.e(getContext(), d.e.ds6);
                                        }
                                        al.c(ie3, d.f.icon_emotion_dui_n);
                                        ie.addView(ie3, layoutParams);
                                    } else {
                                        b(ie2, next.Ns().memeInfo.width.intValue(), next.Ns().memeInfo.height.intValue(), this.bes.bdk, this.bes.bdl, this.mOnClickListener);
                                        ie.addView(ie2);
                                    }
                                    z5 = z3;
                                    i3 = i9;
                                    i2 = i6;
                                    relativeLayout = ie;
                                } else {
                                    z5 = z3;
                                    i3 = i9;
                                    i2 = i6;
                                    relativeLayout = view3;
                                }
                            }
                        } else {
                            if (next.getType() == 1280) {
                                ImageView bf2 = bf(getContext());
                                z5 = a(next, bf2, (this.bes.bdk - getPaddingLeft()) - getPaddingRight(), this.bes.bdl);
                                i3 = i7;
                                i2 = i6 + 1;
                                relativeLayout = bf2;
                            }
                            i3 = i7;
                            i2 = i6;
                            relativeLayout = view3;
                        }
                        if (!z5 || relativeLayout == null) {
                            z2 = z4;
                            view = view2;
                        } else {
                            addView(relativeLayout);
                            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) relativeLayout.getLayoutParams();
                            if (z4 && this.bes.bdz >= 0) {
                                z4 = false;
                                if (layoutParams2 != null) {
                                    layoutParams2.topMargin = this.bes.bdz;
                                    relativeLayout.setLayoutParams(layoutParams2);
                                    z2 = false;
                                    view = relativeLayout;
                                }
                                z2 = z4;
                                view = relativeLayout;
                            } else if (relativeLayout instanceof TbListTextView) {
                                if ((view2 instanceof ImageView) || (view2 instanceof RelativeLayout)) {
                                    layoutParams2.topMargin = this.bes.bdv;
                                } else {
                                    layoutParams2.topMargin = this.bes.bdg;
                                }
                                relativeLayout.setLayoutParams(layoutParams2);
                                z2 = z4;
                                view = relativeLayout;
                            } else {
                                if (((relativeLayout instanceof ImageView) || (relativeLayout instanceof RelativeLayout)) && (next.getType() == 8 || next.getType() == 20 || next.getType() == 17)) {
                                    if (view2 instanceof TbListTextView) {
                                        layoutParams2.topMargin = this.bes.bdu;
                                    } else if ((view2 instanceof ImageView) || (relativeLayout instanceof RelativeLayout)) {
                                        layoutParams2.topMargin = this.bes.bdt;
                                    } else {
                                        layoutParams2.topMargin = this.bes.bdg;
                                    }
                                    relativeLayout.setLayoutParams(layoutParams2);
                                }
                                z2 = z4;
                                view = relativeLayout;
                            }
                        }
                        z4 = z2;
                        i6 = i2;
                        view2 = view;
                        view3 = relativeLayout;
                        i7 = i3;
                    }
                }
                if (view2 instanceof TbListTextView) {
                    LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) view2.getLayoutParams();
                    layoutParams3.bottomMargin = this.bes.bdy;
                    view2.setLayoutParams(layoutParams3);
                } else if (view2 != null && this.bes.bdx >= 0) {
                    LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) view2.getLayoutParams();
                    layoutParams4.bottomMargin = this.bes.bdx;
                    view2.setLayoutParams(layoutParams4);
                }
            }
        }
    }

    public void setCommonTextViewOnClickListener(View.OnClickListener onClickListener) {
        this.beG = onClickListener;
    }

    private View b(final com.baidu.tbadk.widget.richText.f fVar) {
        if (fVar == null || !fVar.isAvaliable()) {
            return null;
        }
        ImageView ie = this.beu.ie();
        if (ie instanceof ForeDrawableImageView) {
            ForeDrawableImageView foreDrawableImageView = (ForeDrawableImageView) ie;
            foreDrawableImageView.setForegroundDrawable(d.f.icon_play_video);
            foreDrawableImageView.setNoImageBottomTextColor(d.C0141d.cp_cont_c);
            foreDrawableImageView.setNoImageBottomTextPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds32));
            foreDrawableImageView.setNoImageBottomTextSize(TbadkCoreApplication.getInst().getResources().getDimension(d.e.fontsize28));
            foreDrawableImageView.setNoImageBottomText("点击播放视频");
            foreDrawableImageView.setInterceptOnClick(false);
            foreDrawableImageView.setTag("VideoView");
            b(foreDrawableImageView, fVar.getWidth(), fVar.getHeight(), (this.bes.bdk - getPaddingLeft()) - getPaddingRight(), this.bes.bdl, new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log("c10643");
                    XiaoyingUtil.startPlayXiaoyingVideo(TbRichTextView.this.getContext(), fVar.getVideoUrl(), fVar.getWidth(), fVar.getHeight(), fVar.getThumbUrl());
                }
            });
            foreDrawableImageView.setDefaultResource(0);
            foreDrawableImageView.setSupportNoImage(this.bes.bdr);
            if (com.baidu.tbadk.core.i.tt().tz()) {
                foreDrawableImageView.setDefaultBgResource(d.f.pic_bg_video_frs);
            } else {
                foreDrawableImageView.setDefaultBgResource(d.C0141d.cp_bg_line_c);
            }
            foreDrawableImageView.startLoad(fVar.getThumbUrl(), 17, false);
            return ie;
        }
        return ie;
    }

    private boolean a(ImageView imageView, int i2, int i3, int i4, int i5, View.OnClickListener onClickListener) {
        int[] k = this.bes.k(i2, i3, i4, i5);
        if (k == null) {
            return false;
        }
        int i6 = k[0];
        int i7 = k[1];
        if (imageView instanceof TbImageView) {
            TbImageView tbImageView = (TbImageView) imageView;
            tbImageView.setDefaultResource(this.bes.bdm);
            if (tbImageView.getGifIconWidth() >= i6 || tbImageView.getGifIconHeight() >= i7) {
                tbImageView.setGifIconSupport(false);
            } else {
                tbImageView.setGifIconSupport(true);
            }
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i6, i7);
        if (this.bes.bds) {
            imageView.setScaleType(this.bes.bdq);
            if (imageView instanceof TbImageView) {
                ((TbImageView) imageView).setOnDrawListener(this.bes.mOnDrawListener);
            }
        } else {
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        }
        imageView.setClickable(true);
        imageView.setFocusable(false);
        if (this.beE != null && (imageView instanceof TbImageView)) {
            ((TbImageView) imageView).setTbGestureDetector(this.mInternalGestureDetector);
            imageView.setClickable(true);
        } else {
            imageView.setOnClickListener(onClickListener);
        }
        imageView.setLayoutParams(layoutParams);
        if (imageView instanceof TbImageView) {
            if (this.onLongClickListener != null) {
                ((TbImageView) imageView).setDispatchTouchListener(this.beW);
                imageView.setOnLongClickListener(this.onLongClickListener);
            }
        } else if ((imageView instanceof GifView) && this.onLongClickListener != null) {
            ((GifView) imageView).setDispatchTouchListener(this.beW);
            imageView.setOnLongClickListener(this.onLongClickListener);
        }
        return true;
    }

    private boolean b(ImageView imageView, int i2, int i3, int i4, int i5, View.OnClickListener onClickListener) {
        int i6;
        int[] c2 = l.c(i2, i3, i4, i5);
        if (c2 == null) {
            return false;
        }
        int[] iArr = {c2[0], c2[1]};
        int i7 = iArr[0];
        int i8 = iArr[1];
        if (!this.bes.bds || i4 <= i7 || bdc <= 1.0f) {
            i4 = i7;
            i6 = i8;
        } else {
            if (i7 * bdc <= i4) {
                if (i7 * bdc > i4 * 0.68f) {
                    i4 = (int) (i4 * 0.68f);
                } else {
                    i4 = (int) (i7 * bdc);
                }
            }
            i6 = iArr[0] > 0 ? (iArr[1] * i4) / iArr[0] : i8;
        }
        if (imageView instanceof TbImageView) {
            TbImageView tbImageView = (TbImageView) imageView;
            tbImageView.setDefaultResource(this.bes.bdm);
            if (tbImageView.getGifIconWidth() >= i4 || tbImageView.getGifIconHeight() >= i6) {
                tbImageView.setGifIconSupport(false);
            } else {
                tbImageView.setGifIconSupport(true);
            }
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i4, i6);
        if (this.bes.bds) {
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        } else {
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        }
        imageView.setClickable(true);
        imageView.setFocusable(false);
        if (this.beE != null && (imageView instanceof TbImageView)) {
            ((TbImageView) imageView).setTbGestureDetector(this.mInternalGestureDetector);
            imageView.setClickable(true);
        } else {
            imageView.setOnClickListener(onClickListener);
        }
        imageView.setLayoutParams(layoutParams);
        if (imageView instanceof TbImageView) {
            if (this.onLongClickListener != null) {
                ((TbImageView) imageView).setDispatchTouchListener(this.beW);
                imageView.setOnLongClickListener(this.onLongClickListener);
            }
        } else if ((imageView instanceof GifView) && this.onLongClickListener != null) {
            imageView.setOnLongClickListener(this.onLongClickListener);
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00e8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean c(ImageView imageView, int i2, int i3, int i4, int i5, View.OnClickListener onClickListener) {
        int i6;
        int i7;
        int[] c2 = l.c(i2, i3, i4, i5);
        if (c2 == null) {
            return false;
        }
        int[] iArr = {c2[0], c2[1]};
        int i8 = iArr[0];
        int i9 = iArr[1];
        if (this.bes.bds && i4 > i8 && bdc > 1.0f) {
            if (i8 * bdc > i4) {
                i8 = (i4 - l.e(getContext(), d.e.ds78)) - l.e(getContext(), d.e.ds16);
            } else if (i8 * bdc > i4 * 0.68f) {
                i8 = ((int) (i4 * 0.68f)) - l.e(getContext(), d.e.ds78);
            } else {
                i8 = (int) (i8 * bdc);
            }
            if (iArr[0] > 0) {
                i6 = (iArr[1] * i8) / iArr[0];
                i7 = i8;
                if (imageView instanceof TbImageView) {
                    TbImageView tbImageView = (TbImageView) imageView;
                    tbImageView.setDefaultResource(this.bes.bdm);
                    if (tbImageView.getGifIconWidth() >= i7 || tbImageView.getGifIconHeight() >= i6) {
                        tbImageView.setGifIconSupport(false);
                    } else {
                        tbImageView.setGifIconSupport(true);
                    }
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i7, i6);
                if (!this.bes.bds) {
                    imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                } else {
                    imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                }
                imageView.setClickable(true);
                imageView.setFocusable(false);
                if (this.beE == null && (imageView instanceof TbImageView)) {
                    ((TbImageView) imageView).setTbGestureDetector(this.mInternalGestureDetector);
                    imageView.setClickable(true);
                } else {
                    imageView.setOnClickListener(onClickListener);
                }
                imageView.setLayoutParams(layoutParams);
                if (!(imageView instanceof TbImageView)) {
                    if (this.onLongClickListener != null) {
                        ((TbImageView) imageView).setDispatchTouchListener(this.beW);
                        imageView.setOnLongClickListener(this.onLongClickListener);
                    }
                } else if ((imageView instanceof GifView) && this.onLongClickListener != null) {
                    imageView.setOnLongClickListener(this.onLongClickListener);
                }
                return true;
            }
        }
        i6 = i9;
        i7 = i8;
        if (imageView instanceof TbImageView) {
        }
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(i7, i6);
        if (!this.bes.bds) {
        }
        imageView.setClickable(true);
        imageView.setFocusable(false);
        if (this.beE == null) {
        }
        imageView.setOnClickListener(onClickListener);
        imageView.setLayoutParams(layoutParams2);
        if (!(imageView instanceof TbImageView)) {
        }
        return true;
    }

    private void a(RelativeLayout relativeLayout, int i2, int i3, int i4, int i5) {
        int[] c2 = l.c(i2, i3, i4, i5);
        if (c2 != null) {
            int[] iArr = {c2[0], c2[1]};
            int i6 = iArr[0];
            int i7 = iArr[1];
            if (!this.bes.bds || i4 <= i6 || bdc <= 1.0f) {
                i4 = i6;
            } else {
                if (i6 * bdc <= i4) {
                    if (i6 * bdc > i4 * 0.68f) {
                        i4 = (int) (i4 * 0.68f);
                    } else {
                        i4 = (int) (i6 * bdc);
                    }
                }
                if (iArr[0] > 0) {
                    i7 = (iArr[1] * i4) / iArr[0];
                }
            }
            relativeLayout.setLayoutParams(new LinearLayout.LayoutParams(i4, i7));
        }
    }

    private void b(RelativeLayout relativeLayout, int i2, int i3, int i4, int i5) {
        int i6;
        int i7;
        int[] c2 = l.c(i2, i3, i4, i5);
        if (c2 != null) {
            int[] iArr = {c2[0], c2[1]};
            int i8 = iArr[0];
            int i9 = iArr[1];
            if (this.bes.bds && i4 > i8 && bdc > 1.0f) {
                if (i8 * bdc > i4) {
                    i7 = (i4 - l.e(getContext(), d.e.ds78)) - l.e(getContext(), d.e.ds16);
                } else if (i8 * bdc > i4 * 0.68f) {
                    i7 = ((int) (i4 * 0.68f)) - l.e(getContext(), d.e.ds78);
                } else {
                    i7 = (int) (i8 * bdc);
                }
                if (iArr[0] > 0) {
                    i6 = (i7 * iArr[1]) / iArr[0];
                    relativeLayout.setLayoutParams(new LinearLayout.LayoutParams(i4, i6));
                }
            }
            i6 = i9;
            relativeLayout.setLayoutParams(new LinearLayout.LayoutParams(i4, i6));
        }
    }

    private LinearLayout a(final TbRichTextData tbRichTextData) {
        if (this.bes.bdn <= 0 || tbRichTextData == null) {
            return null;
        }
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setTag("VideoView");
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = this.bes.bdg;
        linearLayout.setClickable(true);
        Bitmap cQ = al.cQ(this.bes.bdn);
        if (cQ != null) {
            linearLayout.setBackgroundDrawable(new BitmapDrawable(getContext().getResources(), cQ));
        }
        linearLayout.setFocusable(false);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (tbRichTextData.Nn() != null) {
                    if (TbRichTextView.this.getContext() instanceof com.baidu.tbadk.widget.richText.e) {
                        ((com.baidu.tbadk.widget.richText.e) TbRichTextView.this.getContext()).W(TbRichTextView.this.getContext(), tbRichTextData.Nn().toString());
                        return;
                    }
                    com.baidu.adp.base.e<?> ad = com.baidu.adp.base.i.ad(TbRichTextView.this.getContext());
                    if (ad != null && (ad.getOrignalPage() instanceof com.baidu.tbadk.widget.richText.e)) {
                        ((com.baidu.tbadk.widget.richText.e) ad.getOrignalPage()).W(TbRichTextView.this.getContext(), tbRichTextData.Nn().toString());
                    }
                }
            }
        });
        return linearLayout;
    }

    private ImageView bf(Context context) {
        ImageView ie = this.beu != null ? this.beu.ie() : null;
        if (ie == null || ie.getParent() != null) {
            ie = null;
        }
        if (ie != null) {
            ie.setContentDescription(context.getString(d.k.editor_image));
        }
        return ie;
    }

    private boolean a(TbRichTextData tbRichTextData, ImageView imageView, int i2, int i3) {
        if (tbRichTextData == null || imageView == null) {
            return false;
        }
        TbRichTextLinkImageInfo Nu = tbRichTextData.Nu();
        if (Nu != null && Nu.getLink() != null) {
            if (imageView instanceof TbImageView) {
                TbImageView tbImageView = (TbImageView) imageView;
                if (this.bes.bdr) {
                    tbImageView.setSupportNoImage(true);
                }
                tbImageView.startLoad(Nu.NK(), this.mIsFromCDN ? 17 : 18, false);
                tbImageView.setTag(new d(Nu.getLink()));
                if (!Nu.NB()) {
                    tbImageView.setAdjustViewBounds(false);
                }
            }
            return b(imageView, Nu.getWidth(), Nu.getHeight(), i2, i3, this.beV);
        }
        return false;
    }

    private boolean b(TbRichTextData tbRichTextData, ImageView imageView, int i2, int i3) {
        if (tbRichTextData == null || imageView == null) {
            return false;
        }
        if (tbRichTextData.Ns() == null) {
            return false;
        }
        if (imageView instanceof TbImageView) {
            TbImageView tbImageView = (TbImageView) imageView;
            if (this.bes.bdr) {
                tbImageView.setSupportNoImage(true);
            }
            tbImageView.startLoad(tbRichTextData.Ns().memeInfo.pic_url, this.mIsFromCDN ? 17 : 18, false);
            tbImageView.setAdjustViewBounds(false);
            tbImageView.setTag(d.g.tag_rich_text_meme_info, tbRichTextData.Ns());
        }
        return b(imageView, tbRichTextData.Ns().memeInfo.width.intValue(), tbRichTextData.Ns().memeInfo.height.intValue(), i2, i3, this.mOnClickListener);
    }

    private boolean c(TbRichTextData tbRichTextData, ImageView imageView, int i2, int i3) {
        if (tbRichTextData == null || imageView == null) {
            return false;
        }
        if (tbRichTextData.Nm() == null) {
            return false;
        }
        if (imageView instanceof TbImageView) {
            TbImageView tbImageView = (TbImageView) imageView;
            if (this.bes.bdr) {
                tbImageView.setSupportNoImage(true);
            }
            tbImageView.startLoad(tbRichTextData.Nm().Nz(), this.mIsFromCDN ? 17 : 18, false);
            if (!tbRichTextData.Nm().NB()) {
                tbImageView.setAdjustViewBounds(false);
            }
            tbImageView.setTag(d.g.tag_rich_text_meme_info, null);
        }
        return a(imageView, tbRichTextData.Nm().getWidth(), tbRichTextData.Nm().getHeight(), i2, i3, this.mOnClickListener);
    }

    private TextView bg(Context context) {
        TextView textView = null;
        if (this.bev != null) {
            textView = this.bev.ie();
        }
        if (textView == null || textView.getParent() != null) {
            textView = new TbListTextView(context);
        }
        textView.setPadding(this.bes.bdf, 0, this.bes.bdf, 0);
        return textView;
    }

    private boolean a(TbRichTextData tbRichTextData, TextView textView, boolean z, c cVar) {
        LinearLayout.LayoutParams layoutParams;
        if (z) {
            layoutParams = new LinearLayout.LayoutParams(-1, -2);
        } else {
            layoutParams = new LinearLayout.LayoutParams(-2, -2);
        }
        if (this.beP) {
            layoutParams.gravity = 16;
            textView.setGravity(16);
        } else {
            layoutParams.topMargin = this.bes.bdg;
        }
        textView.setLineSpacing(this.bes.bde, this.bes.bdd);
        textView.setTextSize(0, this.bes.bdh);
        textView.setTextColor(this.bes.mTextColor);
        textView.setLinkTextColor(al.getColor(d.C0141d.cp_link_tip_c));
        textView.setHighlightColor(getContext().getResources().getColor(d.C0141d.transparent));
        textView.setSingleLine(this.bes.bdo);
        if (this.beB != null) {
            textView.setEllipsize(this.beB);
        }
        if (this.mMaxWidth > 0) {
            textView.setMaxWidth(this.mMaxWidth);
        }
        if (this.beQ > 0) {
            textView.setMaxLines(this.beQ);
        }
        if (tbRichTextData == null) {
            return false;
        }
        SpannableStringBuilder Nn = tbRichTextData.Nn();
        if (Nn == null || Nn.length() <= 0) {
            return false;
        }
        if (this.bes.bdj > 0 && this.bes.bdi > 0) {
            tbRichTextData.Q(this.bes.bdi, this.bes.bdj);
        }
        if (cVar != null) {
            cVar.a(Nn, textView, this);
        }
        try {
            textView.setText(Nn);
        } catch (Exception e2) {
            textView.setText("");
        }
        if (this.beR) {
            if (tbRichTextData.Nw()) {
                textView.setMovementMethod(com.baidu.tieba.view.c.bFg());
            } else {
                textView.setMovementMethod(LinkMovementMethod.getInstance());
            }
        }
        textView.setFocusable(false);
        textView.setLayoutParams(layoutParams);
        textView.setTag(tbRichTextData);
        if (tbRichTextData != null && tbRichTextData.Np() != null) {
            tbRichTextData.Np().needRecompute = this.beX;
        }
        return true;
    }

    private GifView getGifView() {
        GifView gifView = null;
        if (this.bez != null) {
            gifView = this.bez.ie();
        }
        GifView gifView2 = (gifView == null || gifView.getParent() != null) ? new GifView(getContext()) : gifView;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) gifView2.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.leftMargin = 0;
            layoutParams.rightMargin = 0;
            gifView2.setLayoutParams(layoutParams);
        }
        return gifView2;
    }

    private boolean a(final TbRichTextData tbRichTextData, GifView gifView) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) gifView.getLayoutParams();
        if (layoutParams == null || layoutParams.width != tbRichTextData.Nr().mGifInfo.mGifWidth || layoutParams.height != tbRichTextData.Nr().mGifInfo.mGifHeight) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(tbRichTextData.Nr().mGifInfo.mGifWidth, tbRichTextData.Nr().mGifInfo.mGifHeight);
            layoutParams2.gravity = 3;
            gifView.setLayoutParams(layoutParams2);
        } else {
            layoutParams.bottomMargin = 0;
        }
        gifView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (TbRichTextView.this.beN != null) {
                    TbRichTextEmotionInfo Nr = tbRichTextData.Nr();
                    TbRichTextView.this.beN.a(view, Nr.mGifInfo.mGid, Nr.mGifInfo.mPackageName, Nr.mGifInfo.mIcon, Nr.mGifInfo.mStaticUrl, Nr.mGifInfo.mDynamicUrl, Nr.mGifInfo.mSharpText, Nr.mGifInfo.mGifWidth, Nr.mGifInfo.mGifHeight);
                }
            }
        });
        gifView.a(tbRichTextData.Nr().mGifInfo);
        return true;
    }

    private boolean b(TbRichTextData tbRichTextData, GifView gifView) {
        if (gifView != null) {
            gifView.setDefaultNoImageDay(d.f.icon_click);
            gifView.setBackgroundDrawable(al.getDrawable(d.C0141d.common_color_10220));
        }
        gifView.setShowStaticDrawable(false);
        gifView.E(tbRichTextData.Nm().NA(), 38);
        return a(gifView, tbRichTextData.Nm().getWidth(), tbRichTextData.Nm().getHeight(), this.bes.bdk, this.bes.bdl, this.mOnClickListener);
    }

    private View getVoiceView() {
        View ie = this.bew != null ? this.bew.ie() : null;
        if ((ie == null || ie.getParent() != null) && this.beI != -1) {
            ie = LayoutInflater.from(getContext()).inflate(this.beI, (ViewGroup) null);
        }
        if (ie != null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.topMargin = this.bes.bdg;
            layoutParams.bottomMargin = this.bes.bdw;
            ie.setLayoutParams(layoutParams);
            return ie;
        }
        return null;
    }

    private boolean a(TbRichTextData tbRichTextData, View view) {
        view.setTag(tbRichTextData.No());
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LinearLayout.LayoutParams(-2, -2);
        }
        view.setLayoutParams(layoutParams);
        return true;
    }

    private View getTextVoiceView() {
        LinearLayout ie = this.bex.ie();
        if (ie != null) {
            TextView bg = bg(getContext());
            if (bg == null) {
                this.bex.p(ie);
                return null;
            }
            ie.addView(bg);
            View voiceView = getVoiceView();
            if (voiceView == null) {
                this.bev.p(bg);
                this.bex.p(ie);
                return null;
            }
            ie.addView(voiceView);
            return ie;
        }
        return ie;
    }

    private boolean a(TbRichTextData tbRichTextData, LinearLayout linearLayout, c cVar) {
        boolean a2;
        boolean z = true;
        if (linearLayout == null) {
            return false;
        }
        int childCount = linearLayout.getChildCount();
        int i2 = 0;
        while (i2 < childCount) {
            View childAt = linearLayout.getChildAt(i2);
            if (childAt == null) {
                a2 = z;
            } else if (childAt instanceof TextView) {
                a2 = a(tbRichTextData, (TextView) childAt, false, cVar) & z;
            } else if (childAt.getClass().getSimpleName().equals("PlayVoiceBnt")) {
                a2 = a(tbRichTextData, childAt) & z;
            } else {
                a2 = childAt.getClass().getSimpleName().equals("PlayVoiceBntNew") ? a(tbRichTextData, childAt) & z : z;
            }
            i2++;
            z = a2;
        }
        return z;
    }

    public void setTextSize(float f2) {
        if (f2 != this.bes.bdh) {
            this.bes.bdh = f2;
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (childAt instanceof TextView) {
                    ((TextView) childAt).setTextSize(0, f2);
                }
            }
        }
    }

    public void setTextColor(int i2) {
        if (i2 != this.bes.mTextColor) {
            this.bes.mTextColor = i2;
            int childCount = getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                if (childAt != null && (childAt instanceof TextView)) {
                    ((TextView) childAt).setTextColor(i2);
                }
            }
        }
    }

    public void setTextPadding(int i2) {
        if (this.bes.bdf != i2) {
            this.bes.bdf = i2;
            int childCount = getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                if (childAt != null && (childAt instanceof TextView)) {
                    ((TextView) childAt).setPadding(this.bes.bdf, 0, 0, this.bes.bdf);
                }
            }
        }
    }

    public void setLinkTextColor(int i2) {
        if (i2 != this.bes.bdp) {
            this.bes.bdp = i2;
            int childCount = getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                if (childAt != null && (childAt instanceof TextView)) {
                    ((TextView) childAt).setLinkTextColor(i2);
                }
            }
        }
    }

    public void setDuiEnabled(boolean z) {
        this.beA = z;
    }

    public h getOnImageClickListener() {
        return this.beD;
    }

    public void setOnImageClickListener(h hVar) {
        this.beD = hVar;
    }

    public void setOnImageTouchListener(com.baidu.tieba.pb.a.c cVar) {
        this.beE = cVar;
    }

    public void setOnEmotionClickListener(g gVar) {
        this.beN = gVar;
    }

    public void setDisplayImage(boolean z, boolean z2) {
        if (this.beH != z) {
            this.beH = z;
            if (z2) {
                requestLayout();
            }
            if (!this.beH && this.beu != null) {
                this.beu.clear();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class j implements AbsListView.RecyclerListener {
        private int mId;

        public j(int i) {
            this.mId = 0;
            this.mId = i;
        }

        @Override // android.widget.AbsListView.RecyclerListener
        public void onMovedToScrapHeap(View view) {
            View findViewById = view.findViewById(this.mId);
            if (findViewById != null && (findViewById instanceof TbRichTextView)) {
                ((TbRichTextView) findViewById).setText(null);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        this.beJ = false;
        switch (motionEvent.getAction()) {
            case 1:
            case 3:
                if (!this.beK) {
                    NX();
                    break;
                }
                break;
        }
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        switch (motionEvent.getAction()) {
            case 0:
                if (!this.beJ) {
                    NW();
                    break;
                }
                break;
        }
        return dispatchTouchEvent;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.beJ = true;
        return super.onTouchEvent(motionEvent);
    }

    private void NW() {
        this.beK = false;
        if (this.beL == null) {
            this.beL = new a();
        }
        postDelayed(this.beL, ViewConfiguration.getLongPressTimeout());
    }

    private void NX() {
        if (this.beL != null) {
            removeCallbacks(this.beL);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!TbRichTextView.this.beT && TbRichTextView.this.performLongClick()) {
                TbRichTextView.this.beK = true;
            }
        }
    }

    public void setVoiceViewRes(int i2) {
        this.beI = i2;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.beY != drawable) {
            this.beX = true;
            this.beY = drawable;
        }
        setText(this.beO);
        this.beX = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.bes != null) {
            this.bes.release();
        }
        stopLoad();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        stopLoad();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i2) {
        super.onWindowVisibilityChanged(i2);
        if (i2 == 8 || i2 == 4) {
            stopLoad();
        } else {
            refresh();
        }
    }

    public void a(String str, e eVar) {
        this.beU = eVar;
        hT(str);
    }

    public void hT(String str) {
        BdUniqueId bdUniqueId;
        boolean z;
        if (TextUtils.isEmpty(str)) {
            this.mUrl = str;
            return;
        }
        getContext();
        com.baidu.adp.base.h ab = com.baidu.adp.base.i.ab(getContext());
        if (ab != null) {
            bdUniqueId = ab.getUniqueId();
            z = ab.isScroll();
        } else {
            bdUniqueId = null;
            z = false;
        }
        if (!(str.equals(this.mUrl) && this.mPageId == bdUniqueId)) {
            stopLoad();
        }
        this.mUrl = str;
        this.mPageId = bdUniqueId;
        setBackgroundDrawable(null);
        com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) com.baidu.adp.lib.f.c.ig().a(this.mUrl, 19, new Object[0]);
        if (aVar != null) {
            f(aVar);
        } else if (z) {
            invalidate();
        } else if (!com.baidu.adp.lib.f.c.ig().ai(19)) {
            invalidate();
        } else {
            com.baidu.adp.lib.f.c.ig().a(this.mUrl, 19, this.mCallback, 0, 0, this.mPageId, new Object[0]);
        }
    }

    public void stopLoad() {
        if (!TextUtils.isEmpty(this.mUrl)) {
            com.baidu.adp.lib.f.c.ig().a(this.mUrl, 19, this.mCallback);
            setBackgroundDrawable(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null) {
            try {
                NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(getResources(), aVar.mZ(), aVar.mZ().getNinePatchChunk(), aVar.nd(), null);
                if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                    ninePatchDrawable.getPaint().setAlpha(80);
                }
                setBackgroundDrawable(ninePatchDrawable);
                if (this.beU != null) {
                    this.beU.NZ();
                }
            } catch (Exception e2) {
            }
        }
    }

    @Override // com.baidu.adp.newwidget.ImageView.h
    public void refresh() {
        hT(this.mUrl);
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

    public void setTextViewCheckSelection(boolean z) {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt instanceof TbListTextView) {
                ((TbListTextView) childAt).setCheckSelection(z);
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

    public i getOnLinkImageClickListener() {
        return this.beF;
    }

    public void setOnLinkImageClickListener(i iVar) {
        this.beF = iVar;
    }

    public void setHasMovementMethod(boolean z) {
        this.beR = z;
    }

    public void setTextCenter(boolean z) {
        this.beP = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        boolean bfe;

        private b() {
        }
    }
}
