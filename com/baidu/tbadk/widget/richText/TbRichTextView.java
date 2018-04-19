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
    private static final float aUX = l.ai(TbadkCoreApplication.getInst());
    private boolean aWA;
    private int aWB;
    private boolean aWC;
    private boolean aWD;
    private Runnable aWE;
    private boolean aWF;
    private g aWG;
    private TbRichText aWH;
    private boolean aWI;
    private int aWJ;
    private boolean aWK;
    private boolean aWL;
    private boolean aWM;
    private e aWN;
    public final View.OnClickListener aWO;
    private final f aWP;
    private boolean aWQ;
    private Drawable aWR;
    private CustomMessageListener aWS;
    private com.baidu.tbadk.widget.richText.a aWm;
    private com.baidu.adp.lib.e.b<ImageView> aWn;
    private com.baidu.adp.lib.e.b<TextView> aWo;
    private com.baidu.adp.lib.e.b<View> aWp;
    private com.baidu.adp.lib.e.b<LinearLayout> aWq;
    private com.baidu.adp.lib.e.b<RelativeLayout> aWr;
    private com.baidu.adp.lib.e.b<GifView> aWs;
    private boolean aWt;
    private TextUtils.TruncateAt aWu;
    private j aWv;
    private h aWw;
    private com.baidu.tieba.pb.a.c aWx;
    private i aWy;
    private View.OnClickListener aWz;
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
        void KC();
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
        this.aWL = z;
        Ky();
    }

    public void setIsHost(boolean z) {
        this.isHost = z;
    }

    public boolean Kx() {
        return this.aWF;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
        if (this.aWm != null) {
            this.aWm.mIsFromCDN = z;
        }
    }

    public void setMaxWidth(int i2) {
        this.mMaxWidth = i2;
    }

    public void setMaxLines(int i2) {
        this.aWJ = i2;
    }

    public void setTextEllipsize(TextUtils.TruncateAt truncateAt) {
        this.aWu = truncateAt;
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
                return view2.getTag() != null && (view2.getTag() instanceof b) && ((b) view2.getTag()).aWW;
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
            /* renamed from: KB */
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
        this.aWm = new com.baidu.tbadk.widget.richText.a();
        this.aWn = null;
        this.aWo = null;
        this.aWp = null;
        this.aWq = null;
        this.aWr = null;
        this.aWs = null;
        this.aWt = true;
        this.aWu = null;
        this.aWv = null;
        this.aWw = null;
        this.aWx = null;
        this.aWy = null;
        this.aWz = null;
        this.aWA = true;
        this.mIsFromCDN = true;
        this.aWB = -1;
        this.aWC = false;
        this.aWD = false;
        this.aWE = null;
        this.aWF = false;
        this.aWI = false;
        this.mMaxWidth = -1;
        this.aWJ = -1;
        this.aWK = true;
        this.aWL = false;
        this.isHost = false;
        this.aWM = false;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                String url;
                String str;
                int i2 = 0;
                if (TbRichTextView.this.aWw != null && (view2 instanceof ImageView)) {
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
                        TbRichTextView.this.aWw.a(view2, null, i3, TbRichTextView.this.isHost);
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
                        TbRichTextView.this.aWw.a(view2, str, i4, TbRichTextView.this.isHost);
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
                    TbRichTextView.this.aWw.a(view2, url, i5, TbRichTextView.this.isHost);
                }
            }
        };
        this.mInternalGestureDetector = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.4
            @Override // com.baidu.tieba.pb.a.c.a
            public boolean a(View view2, MotionEvent motionEvent) {
                if (TbRichTextView.this.aWx != null) {
                    TbRichTextView.this.aWx.aT(view2);
                    return TbRichTextView.this.aWx.onDoubleTap(motionEvent);
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
        this.aWO = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                String str;
                if (TbRichTextView.this.aWy != null && (view2 instanceof TbImageView)) {
                    Object tag = view2.getTag();
                    if (tag == null || !(tag instanceof d)) {
                        str = null;
                    } else {
                        str = ((d) tag).url;
                    }
                    TbRichTextView.this.aWy.b(view2, str);
                }
            }
        };
        this.aWP = new f() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.11
            @Override // com.baidu.tbadk.widget.richText.TbRichTextView.f
            public void x(MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    TbRichTextView.this.aWM = true;
                } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                    TbRichTextView.this.aWM = false;
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
        this.aWS = new CustomMessageListener(2004018) { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int contentSizeOfLzl = TbRichTextView.this.aWL ? TbConfig.getContentSizeOfLzl() : TbConfig.getContentSize();
                if (TbRichTextView.this.aWH != null && !v.w(TbRichTextView.this.aWH.JJ())) {
                    Iterator<TbRichTextData> it = TbRichTextView.this.aWH.JJ().iterator();
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
        this.aWm = new com.baidu.tbadk.widget.richText.a();
        this.aWn = null;
        this.aWo = null;
        this.aWp = null;
        this.aWq = null;
        this.aWr = null;
        this.aWs = null;
        this.aWt = true;
        this.aWu = null;
        this.aWv = null;
        this.aWw = null;
        this.aWx = null;
        this.aWy = null;
        this.aWz = null;
        this.aWA = true;
        this.mIsFromCDN = true;
        this.aWB = -1;
        this.aWC = false;
        this.aWD = false;
        this.aWE = null;
        this.aWF = false;
        this.aWI = false;
        this.mMaxWidth = -1;
        this.aWJ = -1;
        this.aWK = true;
        this.aWL = false;
        this.isHost = false;
        this.aWM = false;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                String url;
                String str;
                int i2 = 0;
                if (TbRichTextView.this.aWw != null && (view2 instanceof ImageView)) {
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
                        TbRichTextView.this.aWw.a(view2, null, i3, TbRichTextView.this.isHost);
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
                        TbRichTextView.this.aWw.a(view2, str, i4, TbRichTextView.this.isHost);
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
                    TbRichTextView.this.aWw.a(view2, url, i5, TbRichTextView.this.isHost);
                }
            }
        };
        this.mInternalGestureDetector = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.4
            @Override // com.baidu.tieba.pb.a.c.a
            public boolean a(View view2, MotionEvent motionEvent) {
                if (TbRichTextView.this.aWx != null) {
                    TbRichTextView.this.aWx.aT(view2);
                    return TbRichTextView.this.aWx.onDoubleTap(motionEvent);
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
        this.aWO = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                String str;
                if (TbRichTextView.this.aWy != null && (view2 instanceof TbImageView)) {
                    Object tag = view2.getTag();
                    if (tag == null || !(tag instanceof d)) {
                        str = null;
                    } else {
                        str = ((d) tag).url;
                    }
                    TbRichTextView.this.aWy.b(view2, str);
                }
            }
        };
        this.aWP = new f() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.11
            @Override // com.baidu.tbadk.widget.richText.TbRichTextView.f
            public void x(MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    TbRichTextView.this.aWM = true;
                } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                    TbRichTextView.this.aWM = false;
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
        this.aWS = new CustomMessageListener(2004018) { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int contentSizeOfLzl = TbRichTextView.this.aWL ? TbConfig.getContentSizeOfLzl() : TbConfig.getContentSize();
                if (TbRichTextView.this.aWH != null && !v.w(TbRichTextView.this.aWH.JJ())) {
                    Iterator<TbRichTextData> it = TbRichTextView.this.aWH.JJ().iterator();
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
        this.aWm.b(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        Ky();
    }

    public com.baidu.tbadk.widget.richText.a getLayoutStrategy() {
        return this.aWm;
    }

    public void setLayoutStrategy(com.baidu.tbadk.widget.richText.a aVar) {
        if (aVar != null) {
            this.aWm.release();
            this.aWm = aVar;
            Ky();
        }
    }

    private void Ky() {
        int contentSizeOfLzl = this.aWL ? TbConfig.getContentSizeOfLzl() : TbConfig.getContentSize();
        this.aWm.aVe = contentSizeOfLzl;
        this.aWm.aVd = contentSizeOfLzl;
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
            ab.registerListener(this.aWS);
        }
        if (eVar != null) {
            this.aWn = eVar.Kp();
            this.aWo = eVar.Kq();
            this.aWp = eVar.Ks();
            this.aWq = eVar.Kt();
            this.aWs = eVar.Kr();
            this.aWr = eVar.Ku();
            if (eVar.getListView() != null && this.aWv == null) {
                this.aWv = new j(eVar.Ko());
                eVar.getListView().setRecyclerListener(this.aWv);
            }
        }
        setOrientation(1);
        setOnHierarchyChangeListener(new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.7
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view2, View view3) {
                if ((view3 instanceof GifView) && TbRichTextView.this.aWs != null) {
                    TbRichTextView.this.aWs.m((GifView) view3);
                } else if ((view3 instanceof ImageView) && TbRichTextView.this.aWn != null) {
                    TbRichTextView.this.aWn.m((ImageView) view3);
                } else if ((view3 instanceof TextView) && TbRichTextView.this.aWo != null) {
                    TbRichTextView.this.aWo.m((TextView) view3);
                } else if ((view3 instanceof PlayVoiceBnt) && TbRichTextView.this.aWp != null) {
                    TbRichTextView.this.aWp.m(view3);
                } else if ((view3 instanceof PlayVoiceBntNew) && TbRichTextView.this.aWp != null) {
                    TbRichTextView.this.aWp.m(view3);
                } else if ((view3 instanceof RelativeLayout) && TbRichTextView.this.aWr != null) {
                    TbRichTextView.this.aWr.m((RelativeLayout) view3);
                }
                if (view3 instanceof LinearLayout) {
                    Object tag = view3.getTag();
                    if (tag == null || !(tag instanceof String) || !"VideoView".equals(tag)) {
                        if (TbRichTextView.this.aWq != null) {
                            int childCount = ((LinearLayout) view3).getChildCount();
                            for (int i2 = 0; i2 < childCount; i2++) {
                                View childAt = ((LinearLayout) view3).getChildAt(i2);
                                if (childAt != null) {
                                    if ((childAt instanceof TextView) && TbRichTextView.this.aWo != null) {
                                        TbRichTextView.this.aWo.m((TextView) childAt);
                                    } else if ((childAt instanceof PlayVoiceBnt) && TbRichTextView.this.aWp != null) {
                                        TbRichTextView.this.aWp.m(childAt);
                                    } else if ((childAt instanceof PlayVoiceBntNew) && TbRichTextView.this.aWp != null) {
                                        TbRichTextView.this.aWp.m(childAt);
                                    }
                                }
                            }
                            ((LinearLayout) view3).removeAllViews();
                            TbRichTextView.this.aWq.m((LinearLayout) view3);
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
        ArrayList<TbRichTextData> JJ;
        int i2;
        RelativeLayout relativeLayout;
        int i3;
        SpannableStringBuilder JQ;
        boolean z2;
        View view2;
        KeyEvent.Callback a2;
        boolean z3;
        int i4;
        int i5;
        if (this.aWH != tbRichText || (tbRichText != null && tbRichText.isChanged)) {
            if (tbRichText != null) {
                tbRichText.isChanged = false;
            }
            this.aWH = tbRichText;
            removeAllViews();
            if (tbRichText != null && (JJ = tbRichText.JJ()) != null) {
                View view3 = null;
                boolean z4 = true;
                Iterator<TbRichTextData> it = JJ.iterator();
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
                            if (z && !this.aWF && (JQ = next.JQ()) != null) {
                                this.aWF = JQ.length() >= 200;
                            }
                            if (this.aWx != null) {
                                aW.setOnTouchListener(this.mInternalGestureDetector);
                            } else {
                                aW.setOnClickListener(this.aWz);
                            }
                            z5 = a3;
                            i2 = i6;
                            int i8 = i7;
                            relativeLayout = aW;
                            i3 = i8;
                        } else if (next.getType() == 8) {
                            if (i6 < 10) {
                                i6++;
                                if (next.JP() != null) {
                                    if (TbadkCoreApplication.getInst().isGifAutoPlay() && !next.JP().Kh()) {
                                        GifView gifView = getGifView();
                                        b bVar = new b();
                                        bVar.aWW = true;
                                        gifView.setTag(bVar);
                                        z5 = b(next, gifView);
                                        i3 = i7;
                                        i2 = i6;
                                        relativeLayout = gifView;
                                    } else {
                                        ?? aV = aV(getContext());
                                        z5 = c(next, aV, this.aWm.aVf, this.aWm.aVg);
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
                            com.baidu.tbadk.widget.richText.f JT = next.JT();
                            if (JT != null && JT.Kw()) {
                                a2 = b(JT);
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
                                if (next == null || next.JV() == null || next.JV().memeInfo == null || StringUtils.isNull(next.JV().memeInfo.pic_url)) {
                                    z3 = false;
                                } else {
                                    z3 = true;
                                }
                                if (z3) {
                                    RelativeLayout fn = this.aWr.fn();
                                    fn.removeAllViews();
                                    fn.setLayoutParams(new LinearLayout.LayoutParams(next.JV().memeInfo.width.intValue(), next.JV().memeInfo.height.intValue()));
                                    if (p.Hr() && this.aWt) {
                                        b(fn, next.JV().memeInfo.width.intValue(), next.JV().memeInfo.height.intValue(), this.aWm.aVf, this.aWm.aVg);
                                    } else {
                                        a(fn, next.JV().memeInfo.width.intValue(), next.JV().memeInfo.height.intValue(), this.aWm.aVf, this.aWm.aVg);
                                    }
                                    ImageView fn2 = this.aWn.fn();
                                    b(next, fn2, this.aWm.aVf, this.aWm.aVg);
                                    if (p.Hr() && this.aWt) {
                                        ImageView fn3 = this.aWn.fn();
                                        fn3.setTag(this.aWH);
                                        if (fn3 instanceof TbImageView) {
                                            ((TbImageView) fn3).setAdjustViewBounds(false);
                                        }
                                        fn3.setScaleType(ImageView.ScaleType.FIT_XY);
                                        int e2 = l.e(getContext(), d.e.ds78);
                                        int e3 = l.e(getContext(), d.e.ds78);
                                        fn2.setId(d.g.meme_image_view);
                                        c(fn2, next.JV().memeInfo.width.intValue(), next.JV().memeInfo.height.intValue(), this.aWm.aVf, this.aWm.aVg, this.mOnClickListener);
                                        fn.addView(fn2);
                                        if (e3 > next.JV().memeInfo.height.intValue()) {
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
                                        b(fn2, next.JV().memeInfo.width.intValue(), next.JV().memeInfo.height.intValue(), this.aWm.aVf, this.aWm.aVg, this.mOnClickListener);
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
                                z5 = a(next, aV2, (this.aWm.aVf - getPaddingLeft()) - getPaddingRight(), this.aWm.aVg);
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
                            if (z4 && this.aWm.aVu >= 0) {
                                z4 = false;
                                if (layoutParams2 != null) {
                                    layoutParams2.topMargin = this.aWm.aVu;
                                    relativeLayout.setLayoutParams(layoutParams2);
                                    z2 = false;
                                    view2 = relativeLayout;
                                }
                                z2 = z4;
                                view2 = relativeLayout;
                            } else if (relativeLayout instanceof TbListTextView) {
                                if ((view3 instanceof ImageView) || (view3 instanceof RelativeLayout)) {
                                    layoutParams2.topMargin = this.aWm.aVq;
                                } else {
                                    layoutParams2.topMargin = this.aWm.aVb;
                                }
                                relativeLayout.setLayoutParams(layoutParams2);
                                z2 = z4;
                                view2 = relativeLayout;
                            } else {
                                if (((relativeLayout instanceof ImageView) || (relativeLayout instanceof RelativeLayout)) && (next.getType() == 8 || next.getType() == 20 || next.getType() == 17)) {
                                    if (view3 instanceof TbListTextView) {
                                        layoutParams2.topMargin = this.aWm.aVp;
                                    } else if ((view3 instanceof ImageView) || (relativeLayout instanceof RelativeLayout)) {
                                        layoutParams2.topMargin = this.aWm.aVo;
                                    } else {
                                        layoutParams2.topMargin = this.aWm.aVb;
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
                    layoutParams3.bottomMargin = this.aWm.aVt;
                    view3.setLayoutParams(layoutParams3);
                } else if (view3 != null && this.aWm.aVs >= 0) {
                    LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) view3.getLayoutParams();
                    layoutParams4.bottomMargin = this.aWm.aVs;
                    view3.setLayoutParams(layoutParams4);
                }
            }
        }
    }

    public void setCommonTextViewOnClickListener(View.OnClickListener onClickListener) {
        this.aWz = onClickListener;
    }

    private View b(final com.baidu.tbadk.widget.richText.f fVar) {
        if (fVar == null || !fVar.isAvaliable()) {
            return null;
        }
        ImageView fn = this.aWn.fn();
        if (fn instanceof ForeDrawableImageView) {
            ForeDrawableImageView foreDrawableImageView = (ForeDrawableImageView) fn;
            foreDrawableImageView.setForegroundDrawable(d.f.icon_play_video);
            foreDrawableImageView.setNoImageBottomTextColor(d.C0126d.cp_cont_c);
            foreDrawableImageView.setNoImageBottomTextPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds32));
            foreDrawableImageView.setNoImageBottomTextSize(TbadkCoreApplication.getInst().getResources().getDimension(d.e.fontsize28));
            foreDrawableImageView.setNoImageBottomText("点击播放视频");
            foreDrawableImageView.setInterceptOnClick(false);
            foreDrawableImageView.setTag("VideoView");
            b(foreDrawableImageView, fVar.getWidth(), fVar.getHeight(), (this.aWm.aVf - getPaddingLeft()) - getPaddingRight(), this.aWm.aVg, new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    TiebaStatic.log("c10643");
                    XiaoyingUtil.startPlayXiaoyingVideo(TbRichTextView.this.getContext(), fVar.getVideoUrl(), fVar.getWidth(), fVar.getHeight(), fVar.getThumbUrl());
                }
            });
            foreDrawableImageView.setDefaultResource(0);
            foreDrawableImageView.setSupportNoImage(this.aWm.aVm);
            if (com.baidu.tbadk.core.i.pY().qe()) {
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
        int[] k = this.aWm.k(i2, i3, i4, i5);
        if (k == null) {
            return false;
        }
        int i6 = k[0];
        int i7 = k[1];
        if (imageView instanceof TbImageView) {
            TbImageView tbImageView = (TbImageView) imageView;
            tbImageView.setDefaultResource(this.aWm.aVh);
            if (tbImageView.getGifIconWidth() >= i6 || tbImageView.getGifIconHeight() >= i7) {
                tbImageView.setGifIconSupport(false);
            } else {
                tbImageView.setGifIconSupport(true);
            }
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i6, i7);
        if (this.aWm.aVn) {
            imageView.setScaleType(this.aWm.aVl);
            if (imageView instanceof TbImageView) {
                ((TbImageView) imageView).setOnDrawListener(this.aWm.mOnDrawListener);
            }
        } else {
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        }
        imageView.setClickable(true);
        imageView.setFocusable(false);
        if (this.aWx != null && (imageView instanceof TbImageView)) {
            ((TbImageView) imageView).setTbGestureDetector(this.mInternalGestureDetector);
            imageView.setClickable(true);
        } else {
            imageView.setOnClickListener(onClickListener);
        }
        imageView.setLayoutParams(layoutParams);
        if (imageView instanceof TbImageView) {
            if (this.onLongClickListener != null) {
                ((TbImageView) imageView).setDispatchTouchListener(this.aWP);
                imageView.setOnLongClickListener(this.onLongClickListener);
            }
        } else if ((imageView instanceof GifView) && this.onLongClickListener != null) {
            ((GifView) imageView).setDispatchTouchListener(this.aWP);
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
        if (!this.aWm.aVn || i4 <= i7 || aUX <= 1.0f) {
            i4 = i7;
            i6 = i8;
        } else {
            if (i7 * aUX <= i4) {
                if (i7 * aUX > i4 * 0.68f) {
                    i4 = (int) (i4 * 0.68f);
                } else {
                    i4 = (int) (i7 * aUX);
                }
            }
            i6 = iArr[0] > 0 ? (iArr[1] * i4) / iArr[0] : i8;
        }
        if (imageView instanceof TbImageView) {
            TbImageView tbImageView = (TbImageView) imageView;
            tbImageView.setDefaultResource(this.aWm.aVh);
            if (tbImageView.getGifIconWidth() >= i4 || tbImageView.getGifIconHeight() >= i6) {
                tbImageView.setGifIconSupport(false);
            } else {
                tbImageView.setGifIconSupport(true);
            }
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i4, i6);
        if (this.aWm.aVn) {
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        } else {
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        }
        imageView.setClickable(true);
        imageView.setFocusable(false);
        if (this.aWx != null && (imageView instanceof TbImageView)) {
            ((TbImageView) imageView).setTbGestureDetector(this.mInternalGestureDetector);
            imageView.setClickable(true);
        } else {
            imageView.setOnClickListener(onClickListener);
        }
        imageView.setLayoutParams(layoutParams);
        if (imageView instanceof TbImageView) {
            if (this.onLongClickListener != null) {
                ((TbImageView) imageView).setDispatchTouchListener(this.aWP);
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
        if (this.aWm.aVn && i4 > i8 && aUX > 1.0f) {
            if (i8 * aUX > i4) {
                i8 = (i4 - l.e(getContext(), d.e.ds78)) - l.e(getContext(), d.e.ds16);
            } else if (i8 * aUX > i4 * 0.68f) {
                i8 = ((int) (i4 * 0.68f)) - l.e(getContext(), d.e.ds78);
            } else {
                i8 = (int) (i8 * aUX);
            }
            if (iArr[0] > 0) {
                i6 = (iArr[1] * i8) / iArr[0];
                i7 = i8;
                if (imageView instanceof TbImageView) {
                    TbImageView tbImageView = (TbImageView) imageView;
                    tbImageView.setDefaultResource(this.aWm.aVh);
                    if (tbImageView.getGifIconWidth() >= i7 || tbImageView.getGifIconHeight() >= i6) {
                        tbImageView.setGifIconSupport(false);
                    } else {
                        tbImageView.setGifIconSupport(true);
                    }
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i7, i6);
                if (!this.aWm.aVn) {
                    imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                } else {
                    imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                }
                imageView.setClickable(true);
                imageView.setFocusable(false);
                if (this.aWx == null && (imageView instanceof TbImageView)) {
                    ((TbImageView) imageView).setTbGestureDetector(this.mInternalGestureDetector);
                    imageView.setClickable(true);
                } else {
                    imageView.setOnClickListener(onClickListener);
                }
                imageView.setLayoutParams(layoutParams);
                if (!(imageView instanceof TbImageView)) {
                    if (this.onLongClickListener != null) {
                        ((TbImageView) imageView).setDispatchTouchListener(this.aWP);
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
        if (!this.aWm.aVn) {
        }
        imageView.setClickable(true);
        imageView.setFocusable(false);
        if (this.aWx == null) {
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
            if (!this.aWm.aVn || i4 <= i6 || aUX <= 1.0f) {
                i4 = i6;
            } else {
                if (i6 * aUX <= i4) {
                    if (i6 * aUX > i4 * 0.68f) {
                        i4 = (int) (i4 * 0.68f);
                    } else {
                        i4 = (int) (i6 * aUX);
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
            if (this.aWm.aVn && i4 > i8 && aUX > 1.0f) {
                if (i8 * aUX > i4) {
                    i7 = (i4 - l.e(getContext(), d.e.ds78)) - l.e(getContext(), d.e.ds16);
                } else if (i8 * aUX > i4 * 0.68f) {
                    i7 = ((int) (i4 * 0.68f)) - l.e(getContext(), d.e.ds78);
                } else {
                    i7 = (int) (i8 * aUX);
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
        if (this.aWm.aVi <= 0 || tbRichTextData == null) {
            return null;
        }
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setTag("VideoView");
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = this.aWm.aVb;
        linearLayout.setClickable(true);
        Bitmap cN = ak.cN(this.aWm.aVi);
        if (cN != null) {
            linearLayout.setBackgroundDrawable(new BitmapDrawable(getContext().getResources(), cN));
        }
        linearLayout.setFocusable(false);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (tbRichTextData.JQ() != null) {
                    if (TbRichTextView.this.getContext() instanceof com.baidu.tbadk.widget.richText.e) {
                        ((com.baidu.tbadk.widget.richText.e) TbRichTextView.this.getContext()).U(TbRichTextView.this.getContext(), tbRichTextData.JQ().toString());
                        return;
                    }
                    com.baidu.adp.base.e<?> ab = com.baidu.adp.base.i.ab(TbRichTextView.this.getContext());
                    if (ab != null && (ab.getOrignalPage() instanceof com.baidu.tbadk.widget.richText.e)) {
                        ((com.baidu.tbadk.widget.richText.e) ab.getOrignalPage()).U(TbRichTextView.this.getContext(), tbRichTextData.JQ().toString());
                    }
                }
            }
        });
        return linearLayout;
    }

    private ImageView aV(Context context) {
        ImageView fn = this.aWn != null ? this.aWn.fn() : null;
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
        TbRichTextLinkImageInfo JX = tbRichTextData.JX();
        if (JX != null && JX.getLink() != null) {
            if (imageView instanceof TbImageView) {
                TbImageView tbImageView = (TbImageView) imageView;
                if (this.aWm.aVm) {
                    tbImageView.setSupportNoImage(true);
                }
                tbImageView.startLoad(JX.Kn(), this.mIsFromCDN ? 17 : 18, false);
                tbImageView.setTag(new d(JX.getLink()));
                if (!JX.Ke()) {
                    tbImageView.setAdjustViewBounds(false);
                }
            }
            return b(imageView, JX.getWidth(), JX.getHeight(), i2, i3, this.aWO);
        }
        return false;
    }

    private boolean b(TbRichTextData tbRichTextData, ImageView imageView, int i2, int i3) {
        if (tbRichTextData == null || imageView == null) {
            return false;
        }
        if (tbRichTextData.JV() == null) {
            return false;
        }
        if (imageView instanceof TbImageView) {
            TbImageView tbImageView = (TbImageView) imageView;
            if (this.aWm.aVm) {
                tbImageView.setSupportNoImage(true);
            }
            tbImageView.startLoad(tbRichTextData.JV().memeInfo.pic_url, this.mIsFromCDN ? 17 : 18, false);
            tbImageView.setAdjustViewBounds(false);
            tbImageView.setTag(d.g.tag_rich_text_meme_info, tbRichTextData.JV());
        }
        return b(imageView, tbRichTextData.JV().memeInfo.width.intValue(), tbRichTextData.JV().memeInfo.height.intValue(), i2, i3, this.mOnClickListener);
    }

    private boolean c(TbRichTextData tbRichTextData, ImageView imageView, int i2, int i3) {
        if (tbRichTextData == null || imageView == null) {
            return false;
        }
        if (tbRichTextData.JP() == null) {
            return false;
        }
        if (imageView instanceof TbImageView) {
            TbImageView tbImageView = (TbImageView) imageView;
            if (this.aWm.aVm) {
                tbImageView.setSupportNoImage(true);
            }
            tbImageView.startLoad(tbRichTextData.JP().Kc(), this.mIsFromCDN ? 17 : 18, false);
            if (!tbRichTextData.JP().Ke()) {
                tbImageView.setAdjustViewBounds(false);
            }
            tbImageView.setTag(d.g.tag_rich_text_meme_info, null);
        }
        return a(imageView, tbRichTextData.JP().getWidth(), tbRichTextData.JP().getHeight(), i2, i3, this.mOnClickListener);
    }

    private TextView aW(Context context) {
        TextView textView = null;
        if (this.aWo != null) {
            textView = this.aWo.fn();
        }
        if (textView == null || textView.getParent() != null) {
            textView = new TbListTextView(context);
        }
        textView.setPadding(this.aWm.aVa, 0, this.aWm.aVa, 0);
        return textView;
    }

    private boolean a(TbRichTextData tbRichTextData, TextView textView, boolean z, c cVar) {
        LinearLayout.LayoutParams layoutParams;
        if (z) {
            layoutParams = new LinearLayout.LayoutParams(-1, -2);
        } else {
            layoutParams = new LinearLayout.LayoutParams(-2, -2);
        }
        if (this.aWI) {
            layoutParams.gravity = 16;
            textView.setGravity(16);
        } else {
            layoutParams.topMargin = this.aWm.aVb;
        }
        textView.setLineSpacing(this.aWm.aUZ, this.aWm.aUY);
        textView.setTextSize(0, this.aWm.aVc);
        textView.setTextColor(this.aWm.mTextColor);
        textView.setLinkTextColor(ak.getColor(d.C0126d.cp_link_tip_c));
        textView.setHighlightColor(getContext().getResources().getColor(d.C0126d.transparent));
        textView.setSingleLine(this.aWm.aVj);
        if (this.aWu != null) {
            textView.setEllipsize(this.aWu);
        }
        if (this.mMaxWidth > 0) {
            textView.setMaxWidth(this.mMaxWidth);
        }
        if (this.aWJ > 0) {
            textView.setMaxLines(this.aWJ);
        }
        if (tbRichTextData == null) {
            return false;
        }
        SpannableStringBuilder JQ = tbRichTextData.JQ();
        if (JQ == null || JQ.length() <= 0) {
            return false;
        }
        if (this.aWm.aVe > 0 && this.aWm.aVd > 0) {
            tbRichTextData.P(this.aWm.aVd, this.aWm.aVe);
        }
        if (cVar != null) {
            cVar.a(JQ, textView, this);
        }
        try {
            textView.setText(JQ);
        } catch (Exception e2) {
            textView.setText("");
        }
        if (this.aWK) {
            if (tbRichTextData.JZ()) {
                textView.setMovementMethod(com.baidu.tieba.view.c.bAd());
            } else {
                textView.setMovementMethod(LinkMovementMethod.getInstance());
            }
        }
        textView.setFocusable(false);
        textView.setLayoutParams(layoutParams);
        textView.setTag(tbRichTextData);
        if (tbRichTextData != null && tbRichTextData.JS() != null) {
            tbRichTextData.JS().needRecompute = this.aWQ;
        }
        return true;
    }

    private GifView getGifView() {
        GifView gifView = null;
        if (this.aWs != null) {
            gifView = this.aWs.fn();
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
        if (layoutParams == null || layoutParams.width != tbRichTextData.JU().mGifInfo.mGifWidth || layoutParams.height != tbRichTextData.JU().mGifInfo.mGifHeight) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(tbRichTextData.JU().mGifInfo.mGifWidth, tbRichTextData.JU().mGifInfo.mGifHeight);
            layoutParams2.gravity = 3;
            gifView.setLayoutParams(layoutParams2);
        } else {
            layoutParams.bottomMargin = 0;
        }
        gifView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (TbRichTextView.this.aWG != null) {
                    TbRichTextEmotionInfo JU = tbRichTextData.JU();
                    TbRichTextView.this.aWG.a(view2, JU.mGifInfo.mGid, JU.mGifInfo.mPackageName, JU.mGifInfo.mIcon, JU.mGifInfo.mStaticUrl, JU.mGifInfo.mDynamicUrl, JU.mGifInfo.mSharpText, JU.mGifInfo.mGifWidth, JU.mGifInfo.mGifHeight);
                }
            }
        });
        gifView.a(tbRichTextData.JU().mGifInfo);
        return true;
    }

    private boolean b(TbRichTextData tbRichTextData, GifView gifView) {
        if (gifView != null) {
            gifView.setDefaultNoImageDay(d.f.icon_click);
            gifView.setBackgroundDrawable(ak.getDrawable(d.C0126d.common_color_10220));
        }
        gifView.setShowStaticDrawable(false);
        gifView.E(tbRichTextData.JP().Kd(), 38);
        return a(gifView, tbRichTextData.JP().getWidth(), tbRichTextData.JP().getHeight(), this.aWm.aVf, this.aWm.aVg, this.mOnClickListener);
    }

    private View getVoiceView() {
        View fn = this.aWp != null ? this.aWp.fn() : null;
        if ((fn == null || fn.getParent() != null) && this.aWB != -1) {
            fn = LayoutInflater.from(getContext()).inflate(this.aWB, (ViewGroup) null);
        }
        if (fn != null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.topMargin = this.aWm.aVb;
            layoutParams.bottomMargin = this.aWm.aVr;
            fn.setLayoutParams(layoutParams);
            return fn;
        }
        return null;
    }

    private boolean a(TbRichTextData tbRichTextData, View view2) {
        view2.setTag(tbRichTextData.JR());
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view2.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LinearLayout.LayoutParams(-2, -2);
        }
        view2.setLayoutParams(layoutParams);
        return true;
    }

    private View getTextVoiceView() {
        LinearLayout fn = this.aWq.fn();
        if (fn != null) {
            TextView aW = aW(getContext());
            if (aW == null) {
                this.aWq.m(fn);
                return null;
            }
            fn.addView(aW);
            View voiceView = getVoiceView();
            if (voiceView == null) {
                this.aWo.m(aW);
                this.aWq.m(fn);
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
        if (f2 != this.aWm.aVc) {
            this.aWm.aVc = f2;
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
        if (i2 != this.aWm.mTextColor) {
            this.aWm.mTextColor = i2;
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
        if (this.aWm.aVa != i2) {
            this.aWm.aVa = i2;
            int childCount = getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                if (childAt != null && (childAt instanceof TextView)) {
                    ((TextView) childAt).setPadding(this.aWm.aVa, 0, 0, this.aWm.aVa);
                }
            }
        }
    }

    public void setLinkTextColor(int i2) {
        if (i2 != this.aWm.aVk) {
            this.aWm.aVk = i2;
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
        this.aWt = z;
    }

    public h getOnImageClickListener() {
        return this.aWw;
    }

    public void setOnImageClickListener(h hVar) {
        this.aWw = hVar;
    }

    public void setOnImageTouchListener(com.baidu.tieba.pb.a.c cVar) {
        this.aWx = cVar;
    }

    public void setOnEmotionClickListener(g gVar) {
        this.aWG = gVar;
    }

    public void setDisplayImage(boolean z, boolean z2) {
        if (this.aWA != z) {
            this.aWA = z;
            if (z2) {
                requestLayout();
            }
            if (!this.aWA && this.aWn != null) {
                this.aWn.clear();
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
        this.aWC = false;
        switch (motionEvent.getAction()) {
            case 1:
            case 3:
                if (!this.aWD) {
                    KA();
                    break;
                }
                break;
        }
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        switch (motionEvent.getAction()) {
            case 0:
                if (!this.aWC) {
                    Kz();
                    break;
                }
                break;
        }
        return dispatchTouchEvent;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.aWC = true;
        return super.onTouchEvent(motionEvent);
    }

    private void Kz() {
        this.aWD = false;
        if (this.aWE == null) {
            this.aWE = new a();
        }
        postDelayed(this.aWE, ViewConfiguration.getLongPressTimeout());
    }

    private void KA() {
        if (this.aWE != null) {
            removeCallbacks(this.aWE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!TbRichTextView.this.aWM && TbRichTextView.this.performLongClick()) {
                TbRichTextView.this.aWD = true;
            }
        }
    }

    public void setVoiceViewRes(int i2) {
        this.aWB = i2;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.aWR != drawable) {
            this.aWQ = true;
            this.aWR = drawable;
        }
        setText(this.aWH);
        this.aWQ = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.aWm != null) {
            this.aWm.release();
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
        this.aWN = eVar;
        hu(str);
    }

    public void hu(String str) {
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
                NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(getResources(), aVar.km(), aVar.km().getNinePatchChunk(), aVar.kq(), null);
                if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                    ninePatchDrawable.getPaint().setAlpha(80);
                }
                setBackgroundDrawable(ninePatchDrawable);
                if (this.aWN != null) {
                    this.aWN.KC();
                }
            } catch (Exception e2) {
            }
        }
    }

    @Override // com.baidu.adp.newwidget.ImageView.h
    public void refresh() {
        hu(this.mUrl);
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
        return this.aWy;
    }

    public void setOnLinkImageClickListener(i iVar) {
        this.aWy = iVar;
    }

    public void setHasMovementMethod(boolean z) {
        this.aWK = z;
    }

    public void setTextCenter(boolean z) {
        this.aWI = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        boolean aWW;

        private b() {
        }
    }
}
