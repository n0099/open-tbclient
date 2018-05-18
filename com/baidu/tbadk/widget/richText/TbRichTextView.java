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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.o.p;
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
    private static final float aUY = l.ai(TbadkCoreApplication.getInst());
    private View.OnClickListener aWA;
    private boolean aWB;
    private int aWC;
    private boolean aWD;
    private boolean aWE;
    private Runnable aWF;
    private boolean aWG;
    private g aWH;
    private TbRichText aWI;
    private boolean aWJ;
    private int aWK;
    private boolean aWL;
    private boolean aWM;
    private boolean aWN;
    private e aWO;
    public final View.OnClickListener aWP;
    private final f aWQ;
    private boolean aWR;
    private Drawable aWS;
    private CustomMessageListener aWT;
    private com.baidu.tbadk.widget.richText.a aWn;
    private com.baidu.adp.lib.e.b<ImageView> aWo;
    private com.baidu.adp.lib.e.b<TextView> aWp;
    private com.baidu.adp.lib.e.b<View> aWq;
    private com.baidu.adp.lib.e.b<LinearLayout> aWr;
    private com.baidu.adp.lib.e.b<RelativeLayout> aWs;
    private com.baidu.adp.lib.e.b<GifView> aWt;
    private boolean aWu;
    private TextUtils.TruncateAt aWv;
    private j aWw;
    private h aWx;
    private com.baidu.tieba.pb.a.c aWy;
    private i aWz;
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
        void KA();
    }

    /* loaded from: classes.dex */
    public interface f {
        void x(MotionEvent motionEvent);
    }

    /* loaded from: classes.dex */
    public interface g {
        void a(View view2, String str, String str2, String str3, String str4, String str5, String str6, int i, int i2);
    }

    /* loaded from: classes.dex */
    public interface h {
        void a(View view2, String str, int i, boolean z);
    }

    /* loaded from: classes.dex */
    public interface i {
        void b(View view2, String str);
    }

    public void setSubPbPost(boolean z) {
        this.aWM = z;
        Kw();
    }

    public void setIsHost(boolean z) {
        this.isHost = z;
    }

    public boolean Kv() {
        return this.aWG;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
        if (this.aWn != null) {
            this.aWn.mIsFromCDN = z;
        }
    }

    public void setMaxWidth(int i2) {
        this.mMaxWidth = i2;
    }

    public void setMaxLines(int i2) {
        this.aWK = i2;
    }

    public void setTextEllipsize(TextUtils.TruncateAt truncateAt) {
        this.aWv = truncateAt;
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
    public boolean T(View view2) {
        if (view2 instanceof ImageView) {
            if (view2 instanceof GifView) {
                return view2.getTag() != null && (view2.getTag() instanceof b) && ((b) view2.getTag()).aWX;
            }
            if ((view2 instanceof TbImageView) && view2.getTag() != null) {
                if (view2.getTag() instanceof d) {
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
            /* renamed from: Kz */
            public TextView fo() {
                return new TbListTextView(context);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: d */
            public void n(TextView textView) {
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
            public TextView o(TextView textView) {
                return textView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: f */
            public TextView p(TextView textView) {
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
        this.aWn = new com.baidu.tbadk.widget.richText.a();
        this.aWo = null;
        this.aWp = null;
        this.aWq = null;
        this.aWr = null;
        this.aWs = null;
        this.aWt = null;
        this.aWu = true;
        this.aWv = null;
        this.aWw = null;
        this.aWx = null;
        this.aWy = null;
        this.aWz = null;
        this.aWA = null;
        this.aWB = true;
        this.mIsFromCDN = true;
        this.aWC = -1;
        this.aWD = false;
        this.aWE = false;
        this.aWF = null;
        this.aWG = false;
        this.aWJ = false;
        this.mMaxWidth = -1;
        this.aWK = -1;
        this.aWL = true;
        this.aWM = false;
        this.isHost = false;
        this.aWN = false;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                String url;
                String str;
                int i2 = 0;
                if (TbRichTextView.this.aWx != null && (view2 instanceof ImageView)) {
                    Object tag = view2.getTag();
                    if (tag != null && (tag instanceof TbRichText)) {
                        int childCount = TbRichTextView.this.getChildCount();
                        int i3 = -1;
                        while (i2 < childCount) {
                            i3++;
                            if (view2.getParent() == TbRichTextView.this.getChildAt(i2)) {
                                break;
                            }
                            i2++;
                        }
                        TbRichTextView.this.aWx.a(view2, null, i3, TbRichTextView.this.isHost);
                        return;
                    }
                    if (tag != null && (tag instanceof String)) {
                        url = (String) tag;
                    } else if ((view2 instanceof TbImageView) && (view2.getTag(d.g.tag_rich_text_meme_info) instanceof TbRichTextMemeInfo)) {
                        TbRichTextMemeInfo tbRichTextMemeInfo = (TbRichTextMemeInfo) view2.getTag(d.g.tag_rich_text_meme_info);
                        if (tbRichTextMemeInfo != null && tbRichTextMemeInfo.memeInfo != null) {
                            str = tbRichTextMemeInfo.memeInfo.pic_url;
                        } else {
                            str = "";
                        }
                        int childCount2 = TbRichTextView.this.getChildCount();
                        int i4 = -1;
                        while (i2 < childCount2) {
                            i4++;
                            if (view2.getParent() == TbRichTextView.this.getChildAt(i2)) {
                                break;
                            }
                            i2++;
                        }
                        TbRichTextView.this.aWx.a(view2, str, i4, TbRichTextView.this.isHost);
                        return;
                    } else if (view2 instanceof TbImageView) {
                        url = ((TbImageView) view2).getUrl();
                    } else {
                        url = view2 instanceof GifView ? ((GifView) view2).getUrl() : null;
                    }
                    int childCount3 = TbRichTextView.this.getChildCount();
                    int i5 = -1;
                    while (i2 < childCount3) {
                        View childAt = TbRichTextView.this.getChildAt(i2);
                        if (TbRichTextView.this.T(childAt)) {
                            i5++;
                        }
                        if (view2 == childAt) {
                            break;
                        }
                        i2++;
                    }
                    TbRichTextView.this.aWx.a(view2, url, i5, TbRichTextView.this.isHost);
                }
            }
        };
        this.mInternalGestureDetector = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.4
            @Override // com.baidu.tieba.pb.a.c.a
            public boolean a(View view2, MotionEvent motionEvent) {
                if (TbRichTextView.this.aWy != null) {
                    TbRichTextView.this.aWy.aT(view2);
                    return TbRichTextView.this.aWy.onDoubleTap(motionEvent);
                }
                return false;
            }

            @Override // com.baidu.tieba.pb.a.c.a
            public boolean b(View view2, MotionEvent motionEvent) {
                return false;
            }

            @Override // com.baidu.tieba.pb.a.c.a
            public boolean c(View view2, MotionEvent motionEvent) {
                if (TbRichTextView.this.mOnClickListener != null) {
                    TbRichTextView.this.mOnClickListener.onClick(view2);
                    return true;
                }
                return false;
            }
        });
        this.aWP = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                String str;
                if (TbRichTextView.this.aWz != null && (view2 instanceof TbImageView)) {
                    Object tag = view2.getTag();
                    if (tag == null || !(tag instanceof d)) {
                        str = null;
                    } else {
                        str = ((d) tag).url;
                    }
                    TbRichTextView.this.aWz.b(view2, str);
                }
            }
        };
        this.aWQ = new f() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.11
            @Override // com.baidu.tbadk.widget.richText.TbRichTextView.f
            public void x(MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    TbRichTextView.this.aWN = true;
                } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                    TbRichTextView.this.aWN = false;
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
        this.aWT = new CustomMessageListener(2004018) { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int contentSizeOfLzl = TbRichTextView.this.aWM ? TbConfig.getContentSizeOfLzl() : TbConfig.getContentSize();
                if (TbRichTextView.this.aWI != null && !v.w(TbRichTextView.this.aWI.JH())) {
                    Iterator<TbRichTextData> it = TbRichTextView.this.aWI.JH().iterator();
                    while (it.hasNext()) {
                        TbRichTextData next = it.next();
                        if (next != null) {
                            next.P(contentSizeOfLzl, contentSizeOfLzl);
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
        this.aWn = new com.baidu.tbadk.widget.richText.a();
        this.aWo = null;
        this.aWp = null;
        this.aWq = null;
        this.aWr = null;
        this.aWs = null;
        this.aWt = null;
        this.aWu = true;
        this.aWv = null;
        this.aWw = null;
        this.aWx = null;
        this.aWy = null;
        this.aWz = null;
        this.aWA = null;
        this.aWB = true;
        this.mIsFromCDN = true;
        this.aWC = -1;
        this.aWD = false;
        this.aWE = false;
        this.aWF = null;
        this.aWG = false;
        this.aWJ = false;
        this.mMaxWidth = -1;
        this.aWK = -1;
        this.aWL = true;
        this.aWM = false;
        this.isHost = false;
        this.aWN = false;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                String url;
                String str;
                int i2 = 0;
                if (TbRichTextView.this.aWx != null && (view2 instanceof ImageView)) {
                    Object tag = view2.getTag();
                    if (tag != null && (tag instanceof TbRichText)) {
                        int childCount = TbRichTextView.this.getChildCount();
                        int i3 = -1;
                        while (i2 < childCount) {
                            i3++;
                            if (view2.getParent() == TbRichTextView.this.getChildAt(i2)) {
                                break;
                            }
                            i2++;
                        }
                        TbRichTextView.this.aWx.a(view2, null, i3, TbRichTextView.this.isHost);
                        return;
                    }
                    if (tag != null && (tag instanceof String)) {
                        url = (String) tag;
                    } else if ((view2 instanceof TbImageView) && (view2.getTag(d.g.tag_rich_text_meme_info) instanceof TbRichTextMemeInfo)) {
                        TbRichTextMemeInfo tbRichTextMemeInfo = (TbRichTextMemeInfo) view2.getTag(d.g.tag_rich_text_meme_info);
                        if (tbRichTextMemeInfo != null && tbRichTextMemeInfo.memeInfo != null) {
                            str = tbRichTextMemeInfo.memeInfo.pic_url;
                        } else {
                            str = "";
                        }
                        int childCount2 = TbRichTextView.this.getChildCount();
                        int i4 = -1;
                        while (i2 < childCount2) {
                            i4++;
                            if (view2.getParent() == TbRichTextView.this.getChildAt(i2)) {
                                break;
                            }
                            i2++;
                        }
                        TbRichTextView.this.aWx.a(view2, str, i4, TbRichTextView.this.isHost);
                        return;
                    } else if (view2 instanceof TbImageView) {
                        url = ((TbImageView) view2).getUrl();
                    } else {
                        url = view2 instanceof GifView ? ((GifView) view2).getUrl() : null;
                    }
                    int childCount3 = TbRichTextView.this.getChildCount();
                    int i5 = -1;
                    while (i2 < childCount3) {
                        View childAt = TbRichTextView.this.getChildAt(i2);
                        if (TbRichTextView.this.T(childAt)) {
                            i5++;
                        }
                        if (view2 == childAt) {
                            break;
                        }
                        i2++;
                    }
                    TbRichTextView.this.aWx.a(view2, url, i5, TbRichTextView.this.isHost);
                }
            }
        };
        this.mInternalGestureDetector = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.4
            @Override // com.baidu.tieba.pb.a.c.a
            public boolean a(View view2, MotionEvent motionEvent) {
                if (TbRichTextView.this.aWy != null) {
                    TbRichTextView.this.aWy.aT(view2);
                    return TbRichTextView.this.aWy.onDoubleTap(motionEvent);
                }
                return false;
            }

            @Override // com.baidu.tieba.pb.a.c.a
            public boolean b(View view2, MotionEvent motionEvent) {
                return false;
            }

            @Override // com.baidu.tieba.pb.a.c.a
            public boolean c(View view2, MotionEvent motionEvent) {
                if (TbRichTextView.this.mOnClickListener != null) {
                    TbRichTextView.this.mOnClickListener.onClick(view2);
                    return true;
                }
                return false;
            }
        });
        this.aWP = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                String str;
                if (TbRichTextView.this.aWz != null && (view2 instanceof TbImageView)) {
                    Object tag = view2.getTag();
                    if (tag == null || !(tag instanceof d)) {
                        str = null;
                    } else {
                        str = ((d) tag).url;
                    }
                    TbRichTextView.this.aWz.b(view2, str);
                }
            }
        };
        this.aWQ = new f() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.11
            @Override // com.baidu.tbadk.widget.richText.TbRichTextView.f
            public void x(MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    TbRichTextView.this.aWN = true;
                } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                    TbRichTextView.this.aWN = false;
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
        this.aWT = new CustomMessageListener(2004018) { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int contentSizeOfLzl = TbRichTextView.this.aWM ? TbConfig.getContentSizeOfLzl() : TbConfig.getContentSize();
                if (TbRichTextView.this.aWI != null && !v.w(TbRichTextView.this.aWI.JH())) {
                    Iterator<TbRichTextData> it = TbRichTextView.this.aWI.JH().iterator();
                    while (it.hasNext()) {
                        TbRichTextData next = it.next();
                        if (next != null) {
                            next.P(contentSizeOfLzl, contentSizeOfLzl);
                        }
                    }
                }
                TbRichTextView.this.setTextSize(contentSizeOfLzl);
            }
        };
        init();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.m.TbRichTextView);
        this.aWn.b(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        Kw();
    }

    public com.baidu.tbadk.widget.richText.a getLayoutStrategy() {
        return this.aWn;
    }

    public void setLayoutStrategy(com.baidu.tbadk.widget.richText.a aVar) {
        if (aVar != null) {
            this.aWn.release();
            this.aWn = aVar;
            Kw();
        }
    }

    private void Kw() {
        int contentSizeOfLzl = this.aWM ? TbConfig.getContentSizeOfLzl() : TbConfig.getContentSize();
        this.aWn.aVf = contentSizeOfLzl;
        this.aWn.aVe = contentSizeOfLzl;
    }

    private void init() {
        com.baidu.tbadk.widget.richText.e eVar = null;
        com.baidu.adp.base.e<?> ab = com.baidu.adp.base.i.ab(getContext());
        if (getContext() instanceof com.baidu.tbadk.widget.richText.e) {
            eVar = (com.baidu.tbadk.widget.richText.e) getContext();
        } else if (ab != null && (ab.getOrignalPage() instanceof com.baidu.tbadk.widget.richText.e)) {
            eVar = (com.baidu.tbadk.widget.richText.e) ab.getOrignalPage();
        }
        if (ab != null) {
            ab.registerListener(this.aWT);
        }
        if (eVar != null) {
            this.aWo = eVar.Kn();
            this.aWp = eVar.Ko();
            this.aWq = eVar.Kq();
            this.aWr = eVar.Kr();
            this.aWt = eVar.Kp();
            this.aWs = eVar.Ks();
            if (eVar.getListView() != null && this.aWw == null) {
                this.aWw = new j(eVar.Km());
                eVar.getListView().setRecyclerListener(this.aWw);
            }
        }
        setOrientation(1);
        setOnHierarchyChangeListener(new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.7
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view2, View view3) {
                if ((view3 instanceof GifView) && TbRichTextView.this.aWt != null) {
                    TbRichTextView.this.aWt.m((GifView) view3);
                } else if ((view3 instanceof ImageView) && TbRichTextView.this.aWo != null) {
                    TbRichTextView.this.aWo.m((ImageView) view3);
                } else if ((view3 instanceof TextView) && TbRichTextView.this.aWp != null) {
                    TbRichTextView.this.aWp.m((TextView) view3);
                } else if ((view3 instanceof PlayVoiceBnt) && TbRichTextView.this.aWq != null) {
                    TbRichTextView.this.aWq.m(view3);
                } else if ((view3 instanceof PlayVoiceBntNew) && TbRichTextView.this.aWq != null) {
                    TbRichTextView.this.aWq.m(view3);
                } else if ((view3 instanceof RelativeLayout) && TbRichTextView.this.aWs != null) {
                    TbRichTextView.this.aWs.m((RelativeLayout) view3);
                }
                if (view3 instanceof LinearLayout) {
                    Object tag = view3.getTag();
                    if (tag == null || !(tag instanceof String) || !"VideoView".equals(tag)) {
                        if (TbRichTextView.this.aWr != null) {
                            int childCount = ((LinearLayout) view3).getChildCount();
                            for (int i2 = 0; i2 < childCount; i2++) {
                                View childAt = ((LinearLayout) view3).getChildAt(i2);
                                if (childAt != null) {
                                    if ((childAt instanceof TextView) && TbRichTextView.this.aWp != null) {
                                        TbRichTextView.this.aWp.m((TextView) childAt);
                                    } else if ((childAt instanceof PlayVoiceBnt) && TbRichTextView.this.aWq != null) {
                                        TbRichTextView.this.aWq.m(childAt);
                                    } else if ((childAt instanceof PlayVoiceBntNew) && TbRichTextView.this.aWq != null) {
                                        TbRichTextView.this.aWq.m(childAt);
                                    }
                                }
                            }
                            ((LinearLayout) view3).removeAllViews();
                            TbRichTextView.this.aWr.m((LinearLayout) view3);
                            return;
                        }
                        return;
                    }
                    view3.setBackgroundDrawable(null);
                }
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view2, View view3) {
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
        ArrayList<TbRichTextData> JH;
        int i2;
        RelativeLayout relativeLayout;
        int i3;
        SpannableStringBuilder JO;
        boolean z2;
        View view2;
        KeyEvent.Callback a2;
        boolean z3;
        int i4;
        int i5;
        if (this.aWI != tbRichText || (tbRichText != null && tbRichText.isChanged)) {
            if (tbRichText != null) {
                tbRichText.isChanged = false;
            }
            this.aWI = tbRichText;
            removeAllViews();
            if (tbRichText != null && (JH = tbRichText.JH()) != null) {
                View view3 = null;
                boolean z4 = true;
                Iterator<TbRichTextData> it = JH.iterator();
                int i6 = 0;
                View view4 = null;
                int i7 = 0;
                while (it.hasNext()) {
                    TbRichTextData next = it.next();
                    boolean z5 = false;
                    if (next != null) {
                        if (next.getType() == 1) {
                            TextView aW = aW(getContext());
                            boolean a3 = a(next, aW, true, cVar);
                            if (z && !this.aWG && (JO = next.JO()) != null) {
                                this.aWG = JO.length() >= 200;
                            }
                            if (this.aWy != null) {
                                aW.setOnTouchListener(this.mInternalGestureDetector);
                            } else {
                                aW.setOnClickListener(this.aWA);
                            }
                            z5 = a3;
                            i2 = i6;
                            int i8 = i7;
                            relativeLayout = aW;
                            i3 = i8;
                        } else if (next.getType() == 8) {
                            if (i6 < 10) {
                                i6++;
                                if (next.JN() != null) {
                                    if (TbadkCoreApplication.getInst().isGifAutoPlay() && !next.JN().Kf()) {
                                        GifView gifView = getGifView();
                                        b bVar = new b();
                                        bVar.aWX = true;
                                        gifView.setTag(bVar);
                                        z5 = b(next, gifView);
                                        i3 = i7;
                                        i2 = i6;
                                        relativeLayout = gifView;
                                    } else {
                                        ?? aV = aV(getContext());
                                        z5 = c(next, aV, this.aWn.aVg, this.aWn.aVh);
                                        i3 = i7;
                                        i2 = i6;
                                        relativeLayout = aV;
                                    }
                                }
                                i3 = i7;
                                i2 = i6;
                                relativeLayout = view4;
                            }
                        } else if (next.getType() == 32) {
                            com.baidu.tbadk.widget.richText.f JR = next.JR();
                            if (JR != null && JR.Ku()) {
                                a2 = b(JR);
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
                                view4 = voiceView;
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
                                if (next == null || next.JT() == null || next.JT().memeInfo == null || StringUtils.isNull(next.JT().memeInfo.pic_url)) {
                                    z3 = false;
                                } else {
                                    z3 = true;
                                }
                                if (z3) {
                                    RelativeLayout fn = this.aWs.fn();
                                    fn.removeAllViews();
                                    fn.setLayoutParams(new LinearLayout.LayoutParams(next.JT().memeInfo.width.intValue(), next.JT().memeInfo.height.intValue()));
                                    if (p.Hp() && this.aWu) {
                                        b(fn, next.JT().memeInfo.width.intValue(), next.JT().memeInfo.height.intValue(), this.aWn.aVg, this.aWn.aVh);
                                    } else {
                                        a(fn, next.JT().memeInfo.width.intValue(), next.JT().memeInfo.height.intValue(), this.aWn.aVg, this.aWn.aVh);
                                    }
                                    ImageView fn2 = this.aWo.fn();
                                    b(next, fn2, this.aWn.aVg, this.aWn.aVh);
                                    if (p.Hp() && this.aWu) {
                                        ImageView fn3 = this.aWo.fn();
                                        fn3.setTag(this.aWI);
                                        if (fn3 instanceof TbImageView) {
                                            ((TbImageView) fn3).setAdjustViewBounds(false);
                                        }
                                        fn3.setScaleType(ImageView.ScaleType.FIT_XY);
                                        int e2 = l.e(getContext(), d.e.ds78);
                                        int e3 = l.e(getContext(), d.e.ds78);
                                        fn2.setId(d.g.meme_image_view);
                                        c(fn2, next.JT().memeInfo.width.intValue(), next.JT().memeInfo.height.intValue(), this.aWn.aVg, this.aWn.aVh, this.mOnClickListener);
                                        fn.addView(fn2);
                                        if (e3 > next.JT().memeInfo.height.intValue()) {
                                            i5 = e2 / 2;
                                            i4 = e3 / 2;
                                        } else {
                                            i4 = e3;
                                            i5 = e2;
                                        }
                                        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i5, i4);
                                        layoutParams.addRule(8, d.g.meme_image_view);
                                        layoutParams.addRule(11);
                                        fn3.setOnClickListener(this.mOnClickListener);
                                        if (fn.getLeft() > 0) {
                                            layoutParams.rightMargin = l.e(getContext(), d.e.ds6);
                                        }
                                        ak.c(fn3, d.f.icon_emotion_dui_n);
                                        fn.addView(fn3, layoutParams);
                                    } else {
                                        b(fn2, next.JT().memeInfo.width.intValue(), next.JT().memeInfo.height.intValue(), this.aWn.aVg, this.aWn.aVh, this.mOnClickListener);
                                        fn.addView(fn2);
                                    }
                                    z5 = z3;
                                    i3 = i9;
                                    i2 = i6;
                                    relativeLayout = fn;
                                } else {
                                    z5 = z3;
                                    i3 = i9;
                                    i2 = i6;
                                    relativeLayout = view4;
                                }
                            }
                        } else {
                            if (next.getType() == 1280) {
                                ImageView aV2 = aV(getContext());
                                z5 = a(next, aV2, (this.aWn.aVg - getPaddingLeft()) - getPaddingRight(), this.aWn.aVh);
                                i3 = i7;
                                i2 = i6 + 1;
                                relativeLayout = aV2;
                            }
                            i3 = i7;
                            i2 = i6;
                            relativeLayout = view4;
                        }
                        if (!z5 || relativeLayout == null) {
                            z2 = z4;
                            view2 = view3;
                        } else {
                            addView(relativeLayout);
                            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) relativeLayout.getLayoutParams();
                            if (z4 && this.aWn.aVv >= 0) {
                                z4 = false;
                                if (layoutParams2 != null) {
                                    layoutParams2.topMargin = this.aWn.aVv;
                                    relativeLayout.setLayoutParams(layoutParams2);
                                    z2 = false;
                                    view2 = relativeLayout;
                                }
                                z2 = z4;
                                view2 = relativeLayout;
                            } else if (relativeLayout instanceof TbListTextView) {
                                if ((view3 instanceof ImageView) || (view3 instanceof RelativeLayout)) {
                                    layoutParams2.topMargin = this.aWn.aVr;
                                } else {
                                    layoutParams2.topMargin = this.aWn.aVc;
                                }
                                relativeLayout.setLayoutParams(layoutParams2);
                                z2 = z4;
                                view2 = relativeLayout;
                            } else {
                                if (((relativeLayout instanceof ImageView) || (relativeLayout instanceof RelativeLayout)) && (next.getType() == 8 || next.getType() == 20 || next.getType() == 17)) {
                                    if (view3 instanceof TbListTextView) {
                                        layoutParams2.topMargin = this.aWn.aVq;
                                    } else if ((view3 instanceof ImageView) || (relativeLayout instanceof RelativeLayout)) {
                                        layoutParams2.topMargin = this.aWn.aVp;
                                    } else {
                                        layoutParams2.topMargin = this.aWn.aVc;
                                    }
                                    relativeLayout.setLayoutParams(layoutParams2);
                                }
                                z2 = z4;
                                view2 = relativeLayout;
                            }
                        }
                        z4 = z2;
                        i6 = i2;
                        view3 = view2;
                        view4 = relativeLayout;
                        i7 = i3;
                    }
                }
                if (view3 instanceof TbListTextView) {
                    LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) view3.getLayoutParams();
                    layoutParams3.bottomMargin = this.aWn.aVu;
                    view3.setLayoutParams(layoutParams3);
                } else if (view3 != null && this.aWn.aVt >= 0) {
                    LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) view3.getLayoutParams();
                    layoutParams4.bottomMargin = this.aWn.aVt;
                    view3.setLayoutParams(layoutParams4);
                }
            }
        }
    }

    public void setCommonTextViewOnClickListener(View.OnClickListener onClickListener) {
        this.aWA = onClickListener;
    }

    private View b(final com.baidu.tbadk.widget.richText.f fVar) {
        if (fVar == null || !fVar.isAvaliable()) {
            return null;
        }
        ImageView fn = this.aWo.fn();
        if (fn instanceof ForeDrawableImageView) {
            ForeDrawableImageView foreDrawableImageView = (ForeDrawableImageView) fn;
            foreDrawableImageView.setForegroundDrawable(d.f.icon_play_video);
            foreDrawableImageView.setNoImageBottomTextColor(d.C0126d.cp_cont_c);
            foreDrawableImageView.setNoImageBottomTextPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds32));
            foreDrawableImageView.setNoImageBottomTextSize(TbadkCoreApplication.getInst().getResources().getDimension(d.e.fontsize28));
            foreDrawableImageView.setNoImageBottomText("点击播放视频");
            foreDrawableImageView.setInterceptOnClick(false);
            foreDrawableImageView.setTag("VideoView");
            b(foreDrawableImageView, fVar.getWidth(), fVar.getHeight(), (this.aWn.aVg - getPaddingLeft()) - getPaddingRight(), this.aWn.aVh, new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    TiebaStatic.log("c10643");
                    XiaoyingUtil.startPlayXiaoyingVideo(TbRichTextView.this.getContext(), fVar.getVideoUrl(), fVar.getWidth(), fVar.getHeight(), fVar.getThumbUrl());
                }
            });
            foreDrawableImageView.setDefaultResource(0);
            foreDrawableImageView.setSupportNoImage(this.aWn.aVn);
            if (com.baidu.tbadk.core.i.pX().qd()) {
                foreDrawableImageView.setDefaultBgResource(d.f.pic_bg_video_frs);
            } else {
                foreDrawableImageView.setDefaultBgResource(d.C0126d.cp_bg_line_c);
            }
            foreDrawableImageView.startLoad(fVar.getThumbUrl(), 17, false);
            return fn;
        }
        return fn;
    }

    private boolean a(ImageView imageView, int i2, int i3, int i4, int i5, View.OnClickListener onClickListener) {
        int[] k = this.aWn.k(i2, i3, i4, i5);
        if (k == null) {
            return false;
        }
        int i6 = k[0];
        int i7 = k[1];
        if (imageView instanceof TbImageView) {
            TbImageView tbImageView = (TbImageView) imageView;
            tbImageView.setDefaultResource(this.aWn.aVi);
            if (tbImageView.getGifIconWidth() >= i6 || tbImageView.getGifIconHeight() >= i7) {
                tbImageView.setGifIconSupport(false);
            } else {
                tbImageView.setGifIconSupport(true);
            }
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i6, i7);
        if (this.aWn.aVo) {
            imageView.setScaleType(this.aWn.aVm);
            if (imageView instanceof TbImageView) {
                ((TbImageView) imageView).setOnDrawListener(this.aWn.mOnDrawListener);
            }
        } else {
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        }
        imageView.setClickable(true);
        imageView.setFocusable(false);
        if (this.aWy != null && (imageView instanceof TbImageView)) {
            ((TbImageView) imageView).setTbGestureDetector(this.mInternalGestureDetector);
            imageView.setClickable(true);
        } else {
            imageView.setOnClickListener(onClickListener);
        }
        imageView.setLayoutParams(layoutParams);
        if (imageView instanceof TbImageView) {
            if (this.onLongClickListener != null) {
                ((TbImageView) imageView).setDispatchTouchListener(this.aWQ);
                imageView.setOnLongClickListener(this.onLongClickListener);
            }
        } else if ((imageView instanceof GifView) && this.onLongClickListener != null) {
            ((GifView) imageView).setDispatchTouchListener(this.aWQ);
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
        if (!this.aWn.aVo || i4 <= i7 || aUY <= 1.0f) {
            i4 = i7;
            i6 = i8;
        } else {
            if (i7 * aUY <= i4) {
                if (i7 * aUY > i4 * 0.68f) {
                    i4 = (int) (i4 * 0.68f);
                } else {
                    i4 = (int) (i7 * aUY);
                }
            }
            i6 = iArr[0] > 0 ? (iArr[1] * i4) / iArr[0] : i8;
        }
        if (imageView instanceof TbImageView) {
            TbImageView tbImageView = (TbImageView) imageView;
            tbImageView.setDefaultResource(this.aWn.aVi);
            if (tbImageView.getGifIconWidth() >= i4 || tbImageView.getGifIconHeight() >= i6) {
                tbImageView.setGifIconSupport(false);
            } else {
                tbImageView.setGifIconSupport(true);
            }
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i4, i6);
        if (this.aWn.aVo) {
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        } else {
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        }
        imageView.setClickable(true);
        imageView.setFocusable(false);
        if (this.aWy != null && (imageView instanceof TbImageView)) {
            ((TbImageView) imageView).setTbGestureDetector(this.mInternalGestureDetector);
            imageView.setClickable(true);
        } else {
            imageView.setOnClickListener(onClickListener);
        }
        imageView.setLayoutParams(layoutParams);
        if (imageView instanceof TbImageView) {
            if (this.onLongClickListener != null) {
                ((TbImageView) imageView).setDispatchTouchListener(this.aWQ);
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
        if (this.aWn.aVo && i4 > i8 && aUY > 1.0f) {
            if (i8 * aUY > i4) {
                i8 = (i4 - l.e(getContext(), d.e.ds78)) - l.e(getContext(), d.e.ds16);
            } else if (i8 * aUY > i4 * 0.68f) {
                i8 = ((int) (i4 * 0.68f)) - l.e(getContext(), d.e.ds78);
            } else {
                i8 = (int) (i8 * aUY);
            }
            if (iArr[0] > 0) {
                i6 = (iArr[1] * i8) / iArr[0];
                i7 = i8;
                if (imageView instanceof TbImageView) {
                    TbImageView tbImageView = (TbImageView) imageView;
                    tbImageView.setDefaultResource(this.aWn.aVi);
                    if (tbImageView.getGifIconWidth() >= i7 || tbImageView.getGifIconHeight() >= i6) {
                        tbImageView.setGifIconSupport(false);
                    } else {
                        tbImageView.setGifIconSupport(true);
                    }
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i7, i6);
                if (!this.aWn.aVo) {
                    imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                } else {
                    imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                }
                imageView.setClickable(true);
                imageView.setFocusable(false);
                if (this.aWy == null && (imageView instanceof TbImageView)) {
                    ((TbImageView) imageView).setTbGestureDetector(this.mInternalGestureDetector);
                    imageView.setClickable(true);
                } else {
                    imageView.setOnClickListener(onClickListener);
                }
                imageView.setLayoutParams(layoutParams);
                if (!(imageView instanceof TbImageView)) {
                    if (this.onLongClickListener != null) {
                        ((TbImageView) imageView).setDispatchTouchListener(this.aWQ);
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
        if (!this.aWn.aVo) {
        }
        imageView.setClickable(true);
        imageView.setFocusable(false);
        if (this.aWy == null) {
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
            if (!this.aWn.aVo || i4 <= i6 || aUY <= 1.0f) {
                i4 = i6;
            } else {
                if (i6 * aUY <= i4) {
                    if (i6 * aUY > i4 * 0.68f) {
                        i4 = (int) (i4 * 0.68f);
                    } else {
                        i4 = (int) (i6 * aUY);
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
            if (this.aWn.aVo && i4 > i8 && aUY > 1.0f) {
                if (i8 * aUY > i4) {
                    i7 = (i4 - l.e(getContext(), d.e.ds78)) - l.e(getContext(), d.e.ds16);
                } else if (i8 * aUY > i4 * 0.68f) {
                    i7 = ((int) (i4 * 0.68f)) - l.e(getContext(), d.e.ds78);
                } else {
                    i7 = (int) (i8 * aUY);
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
        if (this.aWn.aVj <= 0 || tbRichTextData == null) {
            return null;
        }
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setTag("VideoView");
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = this.aWn.aVc;
        linearLayout.setClickable(true);
        Bitmap cO = ak.cO(this.aWn.aVj);
        if (cO != null) {
            linearLayout.setBackgroundDrawable(new BitmapDrawable(getContext().getResources(), cO));
        }
        linearLayout.setFocusable(false);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (tbRichTextData.JO() != null) {
                    if (TbRichTextView.this.getContext() instanceof com.baidu.tbadk.widget.richText.e) {
                        ((com.baidu.tbadk.widget.richText.e) TbRichTextView.this.getContext()).U(TbRichTextView.this.getContext(), tbRichTextData.JO().toString());
                        return;
                    }
                    com.baidu.adp.base.e<?> ab = com.baidu.adp.base.i.ab(TbRichTextView.this.getContext());
                    if (ab != null && (ab.getOrignalPage() instanceof com.baidu.tbadk.widget.richText.e)) {
                        ((com.baidu.tbadk.widget.richText.e) ab.getOrignalPage()).U(TbRichTextView.this.getContext(), tbRichTextData.JO().toString());
                    }
                }
            }
        });
        return linearLayout;
    }

    private ImageView aV(Context context) {
        ImageView fn = this.aWo != null ? this.aWo.fn() : null;
        if (fn == null || fn.getParent() != null) {
            fn = null;
        }
        if (fn != null) {
            fn.setContentDescription(context.getString(d.k.editor_image));
        }
        return fn;
    }

    private boolean a(TbRichTextData tbRichTextData, ImageView imageView, int i2, int i3) {
        if (tbRichTextData == null || imageView == null) {
            return false;
        }
        TbRichTextLinkImageInfo JV = tbRichTextData.JV();
        if (JV != null && JV.getLink() != null) {
            if (imageView instanceof TbImageView) {
                TbImageView tbImageView = (TbImageView) imageView;
                if (this.aWn.aVn) {
                    tbImageView.setSupportNoImage(true);
                }
                tbImageView.startLoad(JV.Kl(), this.mIsFromCDN ? 17 : 18, false);
                tbImageView.setTag(new d(JV.getLink()));
                if (!JV.Kc()) {
                    tbImageView.setAdjustViewBounds(false);
                }
            }
            return b(imageView, JV.getWidth(), JV.getHeight(), i2, i3, this.aWP);
        }
        return false;
    }

    private boolean b(TbRichTextData tbRichTextData, ImageView imageView, int i2, int i3) {
        if (tbRichTextData == null || imageView == null) {
            return false;
        }
        if (tbRichTextData.JT() == null) {
            return false;
        }
        if (imageView instanceof TbImageView) {
            TbImageView tbImageView = (TbImageView) imageView;
            if (this.aWn.aVn) {
                tbImageView.setSupportNoImage(true);
            }
            tbImageView.startLoad(tbRichTextData.JT().memeInfo.pic_url, this.mIsFromCDN ? 17 : 18, false);
            tbImageView.setAdjustViewBounds(false);
            tbImageView.setTag(d.g.tag_rich_text_meme_info, tbRichTextData.JT());
        }
        return b(imageView, tbRichTextData.JT().memeInfo.width.intValue(), tbRichTextData.JT().memeInfo.height.intValue(), i2, i3, this.mOnClickListener);
    }

    private boolean c(TbRichTextData tbRichTextData, ImageView imageView, int i2, int i3) {
        if (tbRichTextData == null || imageView == null) {
            return false;
        }
        if (tbRichTextData.JN() == null) {
            return false;
        }
        if (imageView instanceof TbImageView) {
            TbImageView tbImageView = (TbImageView) imageView;
            if (this.aWn.aVn) {
                tbImageView.setSupportNoImage(true);
            }
            tbImageView.startLoad(tbRichTextData.JN().Ka(), this.mIsFromCDN ? 17 : 18, false);
            if (!tbRichTextData.JN().Kc()) {
                tbImageView.setAdjustViewBounds(false);
            }
            tbImageView.setTag(d.g.tag_rich_text_meme_info, null);
        }
        return a(imageView, tbRichTextData.JN().getWidth(), tbRichTextData.JN().getHeight(), i2, i3, this.mOnClickListener);
    }

    private TextView aW(Context context) {
        TextView textView = null;
        if (this.aWp != null) {
            textView = this.aWp.fn();
        }
        if (textView == null || textView.getParent() != null) {
            textView = new TbListTextView(context);
        }
        textView.setPadding(this.aWn.aVb, 0, this.aWn.aVb, 0);
        return textView;
    }

    private boolean a(TbRichTextData tbRichTextData, TextView textView, boolean z, c cVar) {
        LinearLayout.LayoutParams layoutParams;
        if (z) {
            layoutParams = new LinearLayout.LayoutParams(-1, -2);
        } else {
            layoutParams = new LinearLayout.LayoutParams(-2, -2);
        }
        if (this.aWJ) {
            layoutParams.gravity = 16;
            textView.setGravity(16);
        } else {
            layoutParams.topMargin = this.aWn.aVc;
        }
        textView.setLineSpacing(this.aWn.aVa, this.aWn.aUZ);
        textView.setTextSize(0, this.aWn.aVd);
        textView.setTextColor(this.aWn.mTextColor);
        textView.setLinkTextColor(ak.getColor(d.C0126d.cp_link_tip_c));
        textView.setHighlightColor(getContext().getResources().getColor(d.C0126d.transparent));
        textView.setSingleLine(this.aWn.aVk);
        if (this.aWv != null) {
            textView.setEllipsize(this.aWv);
        }
        if (this.mMaxWidth > 0) {
            textView.setMaxWidth(this.mMaxWidth);
        }
        if (this.aWK > 0) {
            textView.setMaxLines(this.aWK);
        }
        if (tbRichTextData == null) {
            return false;
        }
        SpannableStringBuilder JO = tbRichTextData.JO();
        if (JO == null || JO.length() <= 0) {
            return false;
        }
        if (this.aWn.aVf > 0 && this.aWn.aVe > 0) {
            tbRichTextData.P(this.aWn.aVe, this.aWn.aVf);
        }
        if (cVar != null) {
            cVar.a(JO, textView, this);
        }
        try {
            textView.setText(JO);
        } catch (Exception e2) {
            textView.setText("");
        }
        if (this.aWL) {
            if (tbRichTextData.JX()) {
                textView.setMovementMethod(com.baidu.tieba.view.c.bAb());
            } else {
                textView.setMovementMethod(LinkMovementMethod.getInstance());
            }
        }
        textView.setFocusable(false);
        textView.setLayoutParams(layoutParams);
        textView.setTag(tbRichTextData);
        if (tbRichTextData != null && tbRichTextData.JQ() != null) {
            tbRichTextData.JQ().needRecompute = this.aWR;
        }
        return true;
    }

    private GifView getGifView() {
        GifView gifView = null;
        if (this.aWt != null) {
            gifView = this.aWt.fn();
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
        if (layoutParams == null || layoutParams.width != tbRichTextData.JS().mGifInfo.mGifWidth || layoutParams.height != tbRichTextData.JS().mGifInfo.mGifHeight) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(tbRichTextData.JS().mGifInfo.mGifWidth, tbRichTextData.JS().mGifInfo.mGifHeight);
            layoutParams2.gravity = 3;
            gifView.setLayoutParams(layoutParams2);
        } else {
            layoutParams.bottomMargin = 0;
        }
        gifView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (TbRichTextView.this.aWH != null) {
                    TbRichTextEmotionInfo JS = tbRichTextData.JS();
                    TbRichTextView.this.aWH.a(view2, JS.mGifInfo.mGid, JS.mGifInfo.mPackageName, JS.mGifInfo.mIcon, JS.mGifInfo.mStaticUrl, JS.mGifInfo.mDynamicUrl, JS.mGifInfo.mSharpText, JS.mGifInfo.mGifWidth, JS.mGifInfo.mGifHeight);
                }
            }
        });
        gifView.a(tbRichTextData.JS().mGifInfo);
        return true;
    }

    private boolean b(TbRichTextData tbRichTextData, GifView gifView) {
        if (gifView != null) {
            gifView.setDefaultNoImageDay(d.f.icon_click);
            gifView.setBackgroundDrawable(ak.getDrawable(d.C0126d.common_color_10220));
        }
        gifView.setShowStaticDrawable(false);
        gifView.E(tbRichTextData.JN().Kb(), 38);
        return a(gifView, tbRichTextData.JN().getWidth(), tbRichTextData.JN().getHeight(), this.aWn.aVg, this.aWn.aVh, this.mOnClickListener);
    }

    private View getVoiceView() {
        View fn = this.aWq != null ? this.aWq.fn() : null;
        if ((fn == null || fn.getParent() != null) && this.aWC != -1) {
            fn = LayoutInflater.from(getContext()).inflate(this.aWC, (ViewGroup) null);
        }
        if (fn != null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.topMargin = this.aWn.aVc;
            layoutParams.bottomMargin = this.aWn.aVs;
            fn.setLayoutParams(layoutParams);
            return fn;
        }
        return null;
    }

    private boolean a(TbRichTextData tbRichTextData, View view2) {
        view2.setTag(tbRichTextData.JP());
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view2.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LinearLayout.LayoutParams(-2, -2);
        }
        view2.setLayoutParams(layoutParams);
        return true;
    }

    private View getTextVoiceView() {
        LinearLayout fn = this.aWr.fn();
        if (fn != null) {
            TextView aW = aW(getContext());
            if (aW == null) {
                this.aWr.m(fn);
                return null;
            }
            fn.addView(aW);
            View voiceView = getVoiceView();
            if (voiceView == null) {
                this.aWp.m(aW);
                this.aWr.m(fn);
                return null;
            }
            fn.addView(voiceView);
            return fn;
        }
        return fn;
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
        if (f2 != this.aWn.aVd) {
            this.aWn.aVd = f2;
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
        if (i2 != this.aWn.mTextColor) {
            this.aWn.mTextColor = i2;
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
        if (this.aWn.aVb != i2) {
            this.aWn.aVb = i2;
            int childCount = getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                if (childAt != null && (childAt instanceof TextView)) {
                    ((TextView) childAt).setPadding(this.aWn.aVb, 0, 0, this.aWn.aVb);
                }
            }
        }
    }

    public void setLinkTextColor(int i2) {
        if (i2 != this.aWn.aVl) {
            this.aWn.aVl = i2;
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
        this.aWu = z;
    }

    public h getOnImageClickListener() {
        return this.aWx;
    }

    public void setOnImageClickListener(h hVar) {
        this.aWx = hVar;
    }

    public void setOnImageTouchListener(com.baidu.tieba.pb.a.c cVar) {
        this.aWy = cVar;
    }

    public void setOnEmotionClickListener(g gVar) {
        this.aWH = gVar;
    }

    public void setDisplayImage(boolean z, boolean z2) {
        if (this.aWB != z) {
            this.aWB = z;
            if (z2) {
                requestLayout();
            }
            if (!this.aWB && this.aWo != null) {
                this.aWo.clear();
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
        public void onMovedToScrapHeap(View view2) {
            View findViewById = view2.findViewById(this.mId);
            if (findViewById != null && (findViewById instanceof TbRichTextView)) {
                ((TbRichTextView) findViewById).setText(null);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        this.aWD = false;
        switch (motionEvent.getAction()) {
            case 1:
            case 3:
                if (!this.aWE) {
                    Ky();
                    break;
                }
                break;
        }
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        switch (motionEvent.getAction()) {
            case 0:
                if (!this.aWD) {
                    Kx();
                    break;
                }
                break;
        }
        return dispatchTouchEvent;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.aWD = true;
        return super.onTouchEvent(motionEvent);
    }

    private void Kx() {
        this.aWE = false;
        if (this.aWF == null) {
            this.aWF = new a();
        }
        postDelayed(this.aWF, ViewConfiguration.getLongPressTimeout());
    }

    private void Ky() {
        if (this.aWF != null) {
            removeCallbacks(this.aWF);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!TbRichTextView.this.aWN && TbRichTextView.this.performLongClick()) {
                TbRichTextView.this.aWE = true;
            }
        }
    }

    public void setVoiceViewRes(int i2) {
        this.aWC = i2;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.aWS != drawable) {
            this.aWR = true;
            this.aWS = drawable;
        }
        setText(this.aWI);
        this.aWR = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.aWn != null) {
            this.aWn.release();
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
        this.aWO = eVar;
        hv(str);
    }

    public void hv(String str) {
        BdUniqueId bdUniqueId;
        boolean z;
        if (TextUtils.isEmpty(str)) {
            this.mUrl = str;
            return;
        }
        getContext();
        com.baidu.adp.base.h Z = com.baidu.adp.base.i.Z(getContext());
        if (Z != null) {
            bdUniqueId = Z.getUniqueId();
            z = Z.isScroll();
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
        com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) com.baidu.adp.lib.f.c.fp().a(this.mUrl, 19, new Object[0]);
        if (aVar != null) {
            f(aVar);
        } else if (z) {
            invalidate();
        } else if (!com.baidu.adp.lib.f.c.fp().ah(19)) {
            invalidate();
        } else {
            com.baidu.adp.lib.f.c.fp().a(this.mUrl, 19, this.mCallback, 0, 0, this.mPageId, new Object[0]);
        }
    }

    public void stopLoad() {
        if (!TextUtils.isEmpty(this.mUrl)) {
            com.baidu.adp.lib.f.c.fp().a(this.mUrl, 19, this.mCallback);
            setBackgroundDrawable(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null) {
            try {
                NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(getResources(), aVar.kl(), aVar.kl().getNinePatchChunk(), aVar.kp(), null);
                if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                    ninePatchDrawable.getPaint().setAlpha(80);
                }
                setBackgroundDrawable(ninePatchDrawable);
                if (this.aWO != null) {
                    this.aWO.KA();
                }
            } catch (Exception e2) {
            }
        }
    }

    @Override // com.baidu.adp.newwidget.ImageView.h
    public void refresh() {
        hv(this.mUrl);
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
        return this.aWz;
    }

    public void setOnLinkImageClickListener(i iVar) {
        this.aWz = iVar;
    }

    public void setHasMovementMethod(boolean z) {
        this.aWL = z;
    }

    public void setTextCenter(boolean z) {
        this.aWJ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        boolean aWX;

        private b() {
        }
    }
}
