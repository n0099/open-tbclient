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
import com.baidu.tbadk.core.util.aj;
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
public class TbRichTextView extends LinearLayout implements com.baidu.adp.b.a.i {
    private static final float bKi = l.ar(TbadkCoreApplication.getInst());
    private com.baidu.adp.lib.e.b<TextView> bLA;
    private com.baidu.adp.lib.e.b<View> bLB;
    private com.baidu.adp.lib.e.b<LinearLayout> bLC;
    private com.baidu.adp.lib.e.b<RelativeLayout> bLD;
    private com.baidu.adp.lib.e.b<GifView> bLE;
    private boolean bLF;
    private TextUtils.TruncateAt bLG;
    private j bLH;
    private h bLI;
    private com.baidu.tieba.pb.a.c bLJ;
    private i bLK;
    private View.OnClickListener bLL;
    private boolean bLM;
    private int bLN;
    private boolean bLO;
    private boolean bLP;
    private Runnable bLQ;
    private boolean bLR;
    private g bLS;
    private TbRichText bLT;
    private boolean bLU;
    private int bLV;
    private boolean bLW;
    private boolean bLX;
    private boolean bLY;
    private e bLZ;
    private com.baidu.tbadk.widget.richText.a bLy;
    private com.baidu.adp.lib.e.b<ImageView> bLz;
    public final View.OnClickListener bMa;
    private final f bMb;
    private boolean bMc;
    private Drawable bMd;
    private CustomMessageListener bMe;
    private boolean isHost;
    private final com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> mCallback;
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
        void Sc();
    }

    /* loaded from: classes.dex */
    public interface f {
        void F(MotionEvent motionEvent);
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
        this.bLX = z;
        RY();
    }

    public void setIsHost(boolean z) {
        this.isHost = z;
    }

    public boolean RX() {
        return this.bLR;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
        if (this.bLy != null) {
            this.bLy.mIsFromCDN = z;
        }
    }

    public void setMaxWidth(int i2) {
        this.mMaxWidth = i2;
    }

    public void setMaxLines(int i2) {
        this.bLV = i2;
    }

    public void setTextEllipsize(TextUtils.TruncateAt truncateAt) {
        this.bLG = truncateAt;
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
    public boolean bo(View view) {
        if (view instanceof ImageView) {
            if (view instanceof GifView) {
                return view.getTag() != null && (view.getTag() instanceof b) && ((b) view.getTag()).bMi;
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

    public static com.baidu.adp.lib.e.b<TextView> y(final Context context, int i2) {
        return new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<TextView>() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: Sb */
            public TextView nl() {
                return new TbListTextView(context);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: f */
            public void as(TextView textView) {
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
            /* renamed from: g */
            public TextView at(TextView textView) {
                return textView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: h */
            public TextView au(TextView textView) {
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
        this.bLy = new com.baidu.tbadk.widget.richText.a();
        this.bLz = null;
        this.bLA = null;
        this.bLB = null;
        this.bLC = null;
        this.bLD = null;
        this.bLE = null;
        this.bLF = true;
        this.bLG = null;
        this.bLH = null;
        this.bLI = null;
        this.bLJ = null;
        this.bLK = null;
        this.bLL = null;
        this.bLM = true;
        this.mIsFromCDN = true;
        this.bLN = -1;
        this.bLO = false;
        this.bLP = false;
        this.bLQ = null;
        this.bLR = false;
        this.bLU = false;
        this.mMaxWidth = -1;
        this.bLV = -1;
        this.bLW = true;
        this.bLX = false;
        this.isHost = false;
        this.bLY = false;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                String str;
                int i2 = 0;
                if (TbRichTextView.this.bLI != null && (view instanceof ImageView)) {
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
                        TbRichTextView.this.bLI.a(view, null, i3, TbRichTextView.this.isHost);
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
                        TbRichTextView.this.bLI.a(view, str, i4, TbRichTextView.this.isHost);
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
                        if (TbRichTextView.this.bo(childAt)) {
                            i5++;
                        }
                        if (view == childAt) {
                            break;
                        }
                        i2++;
                    }
                    TbRichTextView.this.bLI.a(view, url, i5, TbRichTextView.this.isHost);
                }
            }
        };
        this.mInternalGestureDetector = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.4
            @Override // com.baidu.tieba.pb.a.c.a
            public boolean c(View view, MotionEvent motionEvent) {
                if (TbRichTextView.this.bLJ != null) {
                    TbRichTextView.this.bLJ.cn(view);
                    return TbRichTextView.this.bLJ.onDoubleTap(motionEvent);
                }
                return false;
            }

            @Override // com.baidu.tieba.pb.a.c.a
            public boolean d(View view, MotionEvent motionEvent) {
                return false;
            }

            @Override // com.baidu.tieba.pb.a.c.a
            public boolean e(View view, MotionEvent motionEvent) {
                if (TbRichTextView.this.mOnClickListener != null) {
                    TbRichTextView.this.mOnClickListener.onClick(view);
                    return true;
                }
                return false;
            }
        });
        this.bMa = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                if (TbRichTextView.this.bLK != null && (view instanceof TbImageView)) {
                    Object tag = view.getTag();
                    if (tag == null || !(tag instanceof d)) {
                        str = null;
                    } else {
                        str = ((d) tag).url;
                    }
                    TbRichTextView.this.bLK.b(view, str);
                }
            }
        };
        this.bMb = new f() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.11
            @Override // com.baidu.tbadk.widget.richText.TbRichTextView.f
            public void F(MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    TbRichTextView.this.bLY = true;
                } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                    TbRichTextView.this.bLY = false;
                }
            }
        };
        this.mType = 19;
        this.mCallback = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i2) {
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
        this.bMe = new CustomMessageListener(2004018) { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int contentSizeOfLzl = TbRichTextView.this.bLX ? TbConfig.getContentSizeOfLzl() : TbConfig.getContentSize();
                if (TbRichTextView.this.bLT != null && !v.E(TbRichTextView.this.bLT.Ri())) {
                    Iterator<TbRichTextData> it = TbRichTextView.this.bLT.Ri().iterator();
                    while (it.hasNext()) {
                        TbRichTextData next = it.next();
                        if (next != null) {
                            next.aT(contentSizeOfLzl, contentSizeOfLzl);
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
        this.bLy = new com.baidu.tbadk.widget.richText.a();
        this.bLz = null;
        this.bLA = null;
        this.bLB = null;
        this.bLC = null;
        this.bLD = null;
        this.bLE = null;
        this.bLF = true;
        this.bLG = null;
        this.bLH = null;
        this.bLI = null;
        this.bLJ = null;
        this.bLK = null;
        this.bLL = null;
        this.bLM = true;
        this.mIsFromCDN = true;
        this.bLN = -1;
        this.bLO = false;
        this.bLP = false;
        this.bLQ = null;
        this.bLR = false;
        this.bLU = false;
        this.mMaxWidth = -1;
        this.bLV = -1;
        this.bLW = true;
        this.bLX = false;
        this.isHost = false;
        this.bLY = false;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                String str;
                int i2 = 0;
                if (TbRichTextView.this.bLI != null && (view instanceof ImageView)) {
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
                        TbRichTextView.this.bLI.a(view, null, i3, TbRichTextView.this.isHost);
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
                        TbRichTextView.this.bLI.a(view, str, i4, TbRichTextView.this.isHost);
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
                        if (TbRichTextView.this.bo(childAt)) {
                            i5++;
                        }
                        if (view == childAt) {
                            break;
                        }
                        i2++;
                    }
                    TbRichTextView.this.bLI.a(view, url, i5, TbRichTextView.this.isHost);
                }
            }
        };
        this.mInternalGestureDetector = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.4
            @Override // com.baidu.tieba.pb.a.c.a
            public boolean c(View view, MotionEvent motionEvent) {
                if (TbRichTextView.this.bLJ != null) {
                    TbRichTextView.this.bLJ.cn(view);
                    return TbRichTextView.this.bLJ.onDoubleTap(motionEvent);
                }
                return false;
            }

            @Override // com.baidu.tieba.pb.a.c.a
            public boolean d(View view, MotionEvent motionEvent) {
                return false;
            }

            @Override // com.baidu.tieba.pb.a.c.a
            public boolean e(View view, MotionEvent motionEvent) {
                if (TbRichTextView.this.mOnClickListener != null) {
                    TbRichTextView.this.mOnClickListener.onClick(view);
                    return true;
                }
                return false;
            }
        });
        this.bMa = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                if (TbRichTextView.this.bLK != null && (view instanceof TbImageView)) {
                    Object tag = view.getTag();
                    if (tag == null || !(tag instanceof d)) {
                        str = null;
                    } else {
                        str = ((d) tag).url;
                    }
                    TbRichTextView.this.bLK.b(view, str);
                }
            }
        };
        this.bMb = new f() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.11
            @Override // com.baidu.tbadk.widget.richText.TbRichTextView.f
            public void F(MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    TbRichTextView.this.bLY = true;
                } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                    TbRichTextView.this.bLY = false;
                }
            }
        };
        this.mType = 19;
        this.mCallback = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i2) {
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
        this.bMe = new CustomMessageListener(2004018) { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int contentSizeOfLzl = TbRichTextView.this.bLX ? TbConfig.getContentSizeOfLzl() : TbConfig.getContentSize();
                if (TbRichTextView.this.bLT != null && !v.E(TbRichTextView.this.bLT.Ri())) {
                    Iterator<TbRichTextData> it = TbRichTextView.this.bLT.Ri().iterator();
                    while (it.hasNext()) {
                        TbRichTextData next = it.next();
                        if (next != null) {
                            next.aT(contentSizeOfLzl, contentSizeOfLzl);
                        }
                    }
                }
                TbRichTextView.this.setTextSize(contentSizeOfLzl);
            }
        };
        init();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.l.TbRichTextView);
        this.bLy.b(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        RY();
    }

    public com.baidu.tbadk.widget.richText.a getLayoutStrategy() {
        return this.bLy;
    }

    public void setLayoutStrategy(com.baidu.tbadk.widget.richText.a aVar) {
        if (aVar != null) {
            this.bLy.release();
            this.bLy = aVar;
            RY();
        }
    }

    private void RY() {
        int contentSizeOfLzl = this.bLX ? TbConfig.getContentSizeOfLzl() : TbConfig.getContentSize();
        this.bLy.bKp = contentSizeOfLzl;
        this.bLy.bKo = contentSizeOfLzl;
    }

    private void init() {
        com.baidu.tbadk.widget.richText.e eVar = null;
        com.baidu.adp.base.e<?> ak = com.baidu.adp.base.i.ak(getContext());
        if (getContext() instanceof com.baidu.tbadk.widget.richText.e) {
            eVar = (com.baidu.tbadk.widget.richText.e) getContext();
        } else if (ak != null && (ak.getOrignalPage() instanceof com.baidu.tbadk.widget.richText.e)) {
            eVar = (com.baidu.tbadk.widget.richText.e) ak.getOrignalPage();
        }
        if (ak != null) {
            ak.registerListener(this.bMe);
        }
        if (eVar != null) {
            this.bLz = eVar.RP();
            this.bLA = eVar.RQ();
            this.bLB = eVar.RS();
            this.bLC = eVar.RT();
            this.bLE = eVar.RR();
            this.bLD = eVar.RU();
            if (eVar.getListView() != null && this.bLH == null) {
                this.bLH = new j(eVar.RO());
                eVar.getListView().setRecyclerListener(this.bLH);
            }
        }
        setOrientation(1);
        setOnHierarchyChangeListener(new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.7
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof GifView) && TbRichTextView.this.bLE != null) {
                    TbRichTextView.this.bLE.ar((GifView) view2);
                } else if ((view2 instanceof ImageView) && TbRichTextView.this.bLz != null) {
                    TbRichTextView.this.bLz.ar((ImageView) view2);
                } else if ((view2 instanceof TextView) && TbRichTextView.this.bLA != null) {
                    TbRichTextView.this.bLA.ar((TextView) view2);
                } else if ((view2 instanceof PlayVoiceBnt) && TbRichTextView.this.bLB != null) {
                    TbRichTextView.this.bLB.ar(view2);
                } else if ((view2 instanceof PlayVoiceBntNew) && TbRichTextView.this.bLB != null) {
                    TbRichTextView.this.bLB.ar(view2);
                } else if ((view2 instanceof RelativeLayout) && TbRichTextView.this.bLD != null) {
                    TbRichTextView.this.bLD.ar((RelativeLayout) view2);
                }
                if (view2 instanceof LinearLayout) {
                    Object tag = view2.getTag();
                    if (tag == null || !(tag instanceof String) || !"VideoView".equals(tag)) {
                        if (TbRichTextView.this.bLC != null) {
                            int childCount = ((LinearLayout) view2).getChildCount();
                            for (int i2 = 0; i2 < childCount; i2++) {
                                View childAt = ((LinearLayout) view2).getChildAt(i2);
                                if (childAt != null) {
                                    if ((childAt instanceof TextView) && TbRichTextView.this.bLA != null) {
                                        TbRichTextView.this.bLA.ar((TextView) childAt);
                                    } else if ((childAt instanceof PlayVoiceBnt) && TbRichTextView.this.bLB != null) {
                                        TbRichTextView.this.bLB.ar(childAt);
                                    } else if ((childAt instanceof PlayVoiceBntNew) && TbRichTextView.this.bLB != null) {
                                        TbRichTextView.this.bLB.ar(childAt);
                                    }
                                }
                            }
                            ((LinearLayout) view2).removeAllViews();
                            TbRichTextView.this.bLC.ar((LinearLayout) view2);
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
        a(tbRichText, false);
    }

    public void a(TbRichText tbRichText, boolean z) {
        a(tbRichText, z, (c) null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r21v0, types: [com.baidu.tbadk.widget.richText.TbRichTextView] */
    /* JADX WARN: Type inference failed for: r3v38, types: [android.widget.ImageView] */
    /* JADX WARN: Type inference failed for: r4v10 */
    public void a(TbRichText tbRichText, boolean z, c cVar) {
        ArrayList<TbRichTextData> Ri;
        int i2;
        RelativeLayout relativeLayout;
        int i3;
        SpannableStringBuilder Rp;
        boolean z2;
        View view;
        KeyEvent.Callback a2;
        boolean z3;
        int i4;
        int i5;
        if (this.bLT != tbRichText || (tbRichText != null && tbRichText.isChanged)) {
            if (tbRichText != null) {
                tbRichText.isChanged = false;
            }
            this.bLT = tbRichText;
            removeAllViews();
            if (tbRichText != null && (Ri = tbRichText.Ri()) != null) {
                View view2 = null;
                boolean z4 = true;
                Iterator<TbRichTextData> it = Ri.iterator();
                int i6 = 0;
                View view3 = null;
                int i7 = 0;
                while (it.hasNext()) {
                    TbRichTextData next = it.next();
                    boolean z5 = false;
                    if (next != null) {
                        if (next.getType() == 1) {
                            TextView bl = bl(getContext());
                            boolean a3 = a(next, bl, true, cVar);
                            if (z && !this.bLR && (Rp = next.Rp()) != null) {
                                this.bLR = Rp.length() >= 200;
                            }
                            if (this.bLJ != null) {
                                bl.setOnTouchListener(this.mInternalGestureDetector);
                            } else {
                                bl.setOnClickListener(this.bLL);
                            }
                            z5 = a3;
                            i2 = i6;
                            int i8 = i7;
                            relativeLayout = bl;
                            i3 = i8;
                        } else if (next.getType() == 8) {
                            if (i6 < 10) {
                                i6++;
                                if (next.Ro() != null) {
                                    if (TbadkCoreApplication.getInst().isGifAutoPlay() && !next.Ro().RH()) {
                                        GifView gifView = getGifView();
                                        b bVar = new b();
                                        bVar.bMi = true;
                                        gifView.setTag(bVar);
                                        z5 = b(next, gifView);
                                        i3 = i7;
                                        i2 = i6;
                                        relativeLayout = gifView;
                                    } else {
                                        ?? bk = bk(getContext());
                                        z5 = c(next, bk, this.bLy.bKq, this.bLy.bKr);
                                        i3 = i7;
                                        i2 = i6;
                                        relativeLayout = bk;
                                    }
                                }
                                i3 = i7;
                                i2 = i6;
                                relativeLayout = view3;
                            }
                        } else if (next.getType() == 32) {
                            com.baidu.tbadk.widget.richText.f Rs = next.Rs();
                            if (Rs != null && Rs.RW()) {
                                a2 = b(Rs);
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
                                if (next == null || next.Ru() == null || next.Ru().memeInfo == null || StringUtils.isNull(next.Ru().memeInfo.pic_url)) {
                                    z3 = false;
                                } else {
                                    z3 = true;
                                }
                                if (z3) {
                                    RelativeLayout nk = this.bLD.nk();
                                    nk.removeAllViews();
                                    nk.setLayoutParams(new LinearLayout.LayoutParams(next.Ru().memeInfo.width.intValue(), next.Ru().memeInfo.height.intValue()));
                                    if (p.OO() && this.bLF) {
                                        b(nk, next.Ru().memeInfo.width.intValue(), next.Ru().memeInfo.height.intValue(), this.bLy.bKq, this.bLy.bKr);
                                    } else {
                                        a(nk, next.Ru().memeInfo.width.intValue(), next.Ru().memeInfo.height.intValue(), this.bLy.bKq, this.bLy.bKr);
                                    }
                                    ImageView nk2 = this.bLz.nk();
                                    b(next, nk2, this.bLy.bKq, this.bLy.bKr);
                                    if (p.OO() && this.bLF) {
                                        ImageView nk3 = this.bLz.nk();
                                        nk3.setTag(this.bLT);
                                        if (nk3 instanceof TbImageView) {
                                            ((TbImageView) nk3).setAdjustViewBounds(false);
                                        }
                                        nk3.setScaleType(ImageView.ScaleType.FIT_XY);
                                        int t = l.t(getContext(), d.e.ds78);
                                        int t2 = l.t(getContext(), d.e.ds78);
                                        nk2.setId(d.g.meme_image_view);
                                        c(nk2, next.Ru().memeInfo.width.intValue(), next.Ru().memeInfo.height.intValue(), this.bLy.bKq, this.bLy.bKr, this.mOnClickListener);
                                        nk.addView(nk2);
                                        if (t2 > next.Ru().memeInfo.height.intValue()) {
                                            i5 = t / 2;
                                            i4 = t2 / 2;
                                        } else {
                                            i4 = t2;
                                            i5 = t;
                                        }
                                        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i5, i4);
                                        layoutParams.addRule(8, d.g.meme_image_view);
                                        layoutParams.addRule(11);
                                        nk3.setOnClickListener(this.mOnClickListener);
                                        if (nk.getLeft() > 0) {
                                            layoutParams.rightMargin = l.t(getContext(), d.e.ds6);
                                        }
                                        aj.c(nk3, d.f.icon_emotion_dui_n);
                                        nk.addView(nk3, layoutParams);
                                    } else {
                                        b(nk2, next.Ru().memeInfo.width.intValue(), next.Ru().memeInfo.height.intValue(), this.bLy.bKq, this.bLy.bKr, this.mOnClickListener);
                                        nk.addView(nk2);
                                    }
                                    z5 = z3;
                                    i3 = i9;
                                    i2 = i6;
                                    relativeLayout = nk;
                                } else {
                                    z5 = z3;
                                    i3 = i9;
                                    i2 = i6;
                                    relativeLayout = view3;
                                }
                            }
                        } else {
                            if (next.getType() == 1280) {
                                ImageView bk2 = bk(getContext());
                                z5 = a(next, bk2, (this.bLy.bKq - getPaddingLeft()) - getPaddingRight(), this.bLy.bKr);
                                i3 = i7;
                                i2 = i6 + 1;
                                relativeLayout = bk2;
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
                            if (z4 && this.bLy.bKF >= 0) {
                                z4 = false;
                                if (layoutParams2 != null) {
                                    layoutParams2.topMargin = this.bLy.bKF;
                                    relativeLayout.setLayoutParams(layoutParams2);
                                    z2 = false;
                                    view = relativeLayout;
                                }
                                z2 = z4;
                                view = relativeLayout;
                            } else if (relativeLayout instanceof TbListTextView) {
                                if ((view2 instanceof ImageView) || (view2 instanceof RelativeLayout)) {
                                    layoutParams2.topMargin = this.bLy.bKB;
                                } else {
                                    layoutParams2.topMargin = this.bLy.bKm;
                                }
                                relativeLayout.setLayoutParams(layoutParams2);
                                z2 = z4;
                                view = relativeLayout;
                            } else {
                                if (((relativeLayout instanceof ImageView) || (relativeLayout instanceof RelativeLayout)) && (next.getType() == 8 || next.getType() == 20 || next.getType() == 17)) {
                                    if (view2 instanceof TbListTextView) {
                                        layoutParams2.topMargin = this.bLy.bKA;
                                    } else if ((view2 instanceof ImageView) || (relativeLayout instanceof RelativeLayout)) {
                                        layoutParams2.topMargin = this.bLy.bKz;
                                    } else {
                                        layoutParams2.topMargin = this.bLy.bKm;
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
                    layoutParams3.bottomMargin = this.bLy.bKE;
                    view2.setLayoutParams(layoutParams3);
                } else if (view2 != null && this.bLy.bKD >= 0) {
                    LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) view2.getLayoutParams();
                    layoutParams4.bottomMargin = this.bLy.bKD;
                    view2.setLayoutParams(layoutParams4);
                }
            }
        }
    }

    public void setCommonTextViewOnClickListener(View.OnClickListener onClickListener) {
        this.bLL = onClickListener;
    }

    private View b(final com.baidu.tbadk.widget.richText.f fVar) {
        if (fVar == null || !fVar.isAvaliable()) {
            return null;
        }
        ImageView nk = this.bLz.nk();
        if (nk instanceof ForeDrawableImageView) {
            ForeDrawableImageView foreDrawableImageView = (ForeDrawableImageView) nk;
            foreDrawableImageView.setForegroundDrawable(d.f.icon_play_video);
            foreDrawableImageView.setNoImageBottomTextColor(d.C0141d.cp_cont_c);
            foreDrawableImageView.setNoImageBottomTextPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds32));
            foreDrawableImageView.setNoImageBottomTextSize(TbadkCoreApplication.getInst().getResources().getDimension(d.e.fontsize28));
            foreDrawableImageView.setNoImageBottomText("点击播放视频");
            foreDrawableImageView.setInterceptOnClick(false);
            foreDrawableImageView.setTag("VideoView");
            b(foreDrawableImageView, fVar.getWidth(), fVar.getHeight(), (this.bLy.bKq - getPaddingLeft()) - getPaddingRight(), this.bLy.bKr, new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log("c10643");
                    XiaoyingUtil.startPlayXiaoyingVideo(TbRichTextView.this.getContext(), fVar.getVideoUrl(), fVar.getWidth(), fVar.getHeight(), fVar.getThumbUrl());
                }
            });
            foreDrawableImageView.setDefaultResource(0);
            foreDrawableImageView.setSupportNoImage(this.bLy.bKx);
            if (com.baidu.tbadk.core.i.xo().xu()) {
                foreDrawableImageView.setDefaultBgResource(d.f.pic_bg_video_frs);
            } else {
                foreDrawableImageView.setDefaultBgResource(d.C0141d.cp_bg_line_c);
            }
            foreDrawableImageView.startLoad(fVar.getThumbUrl(), 17, false);
            return nk;
        }
        return nk;
    }

    private boolean a(ImageView imageView, int i2, int i3, int i4, int i5, View.OnClickListener onClickListener) {
        int[] t = this.bLy.t(i2, i3, i4, i5);
        if (t == null) {
            return false;
        }
        int i6 = t[0];
        int i7 = t[1];
        if (imageView instanceof TbImageView) {
            TbImageView tbImageView = (TbImageView) imageView;
            tbImageView.setDefaultResource(this.bLy.bKs);
            if (tbImageView.getGifIconWidth() >= i6 || tbImageView.getGifIconHeight() >= i7) {
                tbImageView.setGifIconSupport(false);
            } else {
                tbImageView.setGifIconSupport(true);
            }
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i6, i7);
        if (this.bLy.bKy) {
            imageView.setScaleType(this.bLy.bKw);
            if (imageView instanceof TbImageView) {
                ((TbImageView) imageView).setOnDrawListener(this.bLy.mOnDrawListener);
            }
        } else {
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        }
        imageView.setClickable(true);
        imageView.setFocusable(false);
        if (this.bLJ != null && (imageView instanceof TbImageView)) {
            ((TbImageView) imageView).setTbGestureDetector(this.mInternalGestureDetector);
            imageView.setClickable(true);
        } else {
            imageView.setOnClickListener(onClickListener);
        }
        imageView.setLayoutParams(layoutParams);
        if (imageView instanceof TbImageView) {
            if (this.onLongClickListener != null) {
                ((TbImageView) imageView).setDispatchTouchListener(this.bMb);
                imageView.setOnLongClickListener(this.onLongClickListener);
            }
        } else if ((imageView instanceof GifView) && this.onLongClickListener != null) {
            ((GifView) imageView).setDispatchTouchListener(this.bMb);
            imageView.setOnLongClickListener(this.onLongClickListener);
        }
        return true;
    }

    private boolean b(ImageView imageView, int i2, int i3, int i4, int i5, View.OnClickListener onClickListener) {
        int i6;
        int[] j2 = l.j(i2, i3, i4, i5);
        if (j2 == null) {
            return false;
        }
        int[] iArr = {j2[0], j2[1]};
        int i7 = iArr[0];
        int i8 = iArr[1];
        if (!this.bLy.bKy || i4 <= i7 || bKi <= 1.0f) {
            i4 = i7;
            i6 = i8;
        } else {
            if (i7 * bKi <= i4) {
                if (i7 * bKi > i4 * 0.68f) {
                    i4 = (int) (i4 * 0.68f);
                } else {
                    i4 = (int) (i7 * bKi);
                }
            }
            i6 = iArr[0] > 0 ? (iArr[1] * i4) / iArr[0] : i8;
        }
        if (imageView instanceof TbImageView) {
            TbImageView tbImageView = (TbImageView) imageView;
            tbImageView.setDefaultResource(this.bLy.bKs);
            if (tbImageView.getGifIconWidth() >= i4 || tbImageView.getGifIconHeight() >= i6) {
                tbImageView.setGifIconSupport(false);
            } else {
                tbImageView.setGifIconSupport(true);
            }
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i4, i6);
        if (this.bLy.bKy) {
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        } else {
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        }
        imageView.setClickable(true);
        imageView.setFocusable(false);
        if (this.bLJ != null && (imageView instanceof TbImageView)) {
            ((TbImageView) imageView).setTbGestureDetector(this.mInternalGestureDetector);
            imageView.setClickable(true);
        } else {
            imageView.setOnClickListener(onClickListener);
        }
        imageView.setLayoutParams(layoutParams);
        if (imageView instanceof TbImageView) {
            if (this.onLongClickListener != null) {
                ((TbImageView) imageView).setDispatchTouchListener(this.bMb);
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
        int[] j2 = l.j(i2, i3, i4, i5);
        if (j2 == null) {
            return false;
        }
        int[] iArr = {j2[0], j2[1]};
        int i8 = iArr[0];
        int i9 = iArr[1];
        if (this.bLy.bKy && i4 > i8 && bKi > 1.0f) {
            if (i8 * bKi > i4) {
                i8 = (i4 - l.t(getContext(), d.e.ds78)) - l.t(getContext(), d.e.ds16);
            } else if (i8 * bKi > i4 * 0.68f) {
                i8 = ((int) (i4 * 0.68f)) - l.t(getContext(), d.e.ds78);
            } else {
                i8 = (int) (i8 * bKi);
            }
            if (iArr[0] > 0) {
                i6 = (iArr[1] * i8) / iArr[0];
                i7 = i8;
                if (imageView instanceof TbImageView) {
                    TbImageView tbImageView = (TbImageView) imageView;
                    tbImageView.setDefaultResource(this.bLy.bKs);
                    if (tbImageView.getGifIconWidth() >= i7 || tbImageView.getGifIconHeight() >= i6) {
                        tbImageView.setGifIconSupport(false);
                    } else {
                        tbImageView.setGifIconSupport(true);
                    }
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i7, i6);
                if (!this.bLy.bKy) {
                    imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                } else {
                    imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                }
                imageView.setClickable(true);
                imageView.setFocusable(false);
                if (this.bLJ == null && (imageView instanceof TbImageView)) {
                    ((TbImageView) imageView).setTbGestureDetector(this.mInternalGestureDetector);
                    imageView.setClickable(true);
                } else {
                    imageView.setOnClickListener(onClickListener);
                }
                imageView.setLayoutParams(layoutParams);
                if (!(imageView instanceof TbImageView)) {
                    if (this.onLongClickListener != null) {
                        ((TbImageView) imageView).setDispatchTouchListener(this.bMb);
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
        if (!this.bLy.bKy) {
        }
        imageView.setClickable(true);
        imageView.setFocusable(false);
        if (this.bLJ == null) {
        }
        imageView.setOnClickListener(onClickListener);
        imageView.setLayoutParams(layoutParams2);
        if (!(imageView instanceof TbImageView)) {
        }
        return true;
    }

    private void a(RelativeLayout relativeLayout, int i2, int i3, int i4, int i5) {
        int[] j2 = l.j(i2, i3, i4, i5);
        if (j2 != null) {
            int[] iArr = {j2[0], j2[1]};
            int i6 = iArr[0];
            int i7 = iArr[1];
            if (!this.bLy.bKy || i4 <= i6 || bKi <= 1.0f) {
                i4 = i6;
            } else {
                if (i6 * bKi <= i4) {
                    if (i6 * bKi > i4 * 0.68f) {
                        i4 = (int) (i4 * 0.68f);
                    } else {
                        i4 = (int) (i6 * bKi);
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
        int[] j2 = l.j(i2, i3, i4, i5);
        if (j2 != null) {
            int[] iArr = {j2[0], j2[1]};
            int i8 = iArr[0];
            int i9 = iArr[1];
            if (this.bLy.bKy && i4 > i8 && bKi > 1.0f) {
                if (i8 * bKi > i4) {
                    i7 = (i4 - l.t(getContext(), d.e.ds78)) - l.t(getContext(), d.e.ds16);
                } else if (i8 * bKi > i4 * 0.68f) {
                    i7 = ((int) (i4 * 0.68f)) - l.t(getContext(), d.e.ds78);
                } else {
                    i7 = (int) (i8 * bKi);
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
        if (this.bLy.bKt <= 0 || tbRichTextData == null) {
            return null;
        }
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setTag("VideoView");
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = this.bLy.bKm;
        linearLayout.setClickable(true);
        Bitmap fO = aj.fO(this.bLy.bKt);
        if (fO != null) {
            linearLayout.setBackgroundDrawable(new BitmapDrawable(getContext().getResources(), fO));
        }
        linearLayout.setFocusable(false);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (tbRichTextData.Rp() != null) {
                    if (TbRichTextView.this.getContext() instanceof com.baidu.tbadk.widget.richText.e) {
                        ((com.baidu.tbadk.widget.richText.e) TbRichTextView.this.getContext()).Z(TbRichTextView.this.getContext(), tbRichTextData.Rp().toString());
                        return;
                    }
                    com.baidu.adp.base.e<?> ak = com.baidu.adp.base.i.ak(TbRichTextView.this.getContext());
                    if (ak != null && (ak.getOrignalPage() instanceof com.baidu.tbadk.widget.richText.e)) {
                        ((com.baidu.tbadk.widget.richText.e) ak.getOrignalPage()).Z(TbRichTextView.this.getContext(), tbRichTextData.Rp().toString());
                    }
                }
            }
        });
        return linearLayout;
    }

    private ImageView bk(Context context) {
        ImageView nk = this.bLz != null ? this.bLz.nk() : null;
        if (nk == null || nk.getParent() != null) {
            nk = null;
        }
        if (nk != null) {
            nk.setContentDescription(context.getString(d.j.editor_image));
        }
        return nk;
    }

    private boolean a(TbRichTextData tbRichTextData, ImageView imageView, int i2, int i3) {
        if (tbRichTextData == null || imageView == null) {
            return false;
        }
        TbRichTextLinkImageInfo Rw = tbRichTextData.Rw();
        if (Rw != null && Rw.getLink() != null) {
            if (imageView instanceof TbImageView) {
                TbImageView tbImageView = (TbImageView) imageView;
                if (this.bLy.bKx) {
                    tbImageView.setSupportNoImage(true);
                }
                tbImageView.startLoad(Rw.RN(), this.mIsFromCDN ? 17 : 18, false);
                tbImageView.setTag(new d(Rw.getLink()));
                if (!Rw.RE()) {
                    tbImageView.setAdjustViewBounds(false);
                }
            }
            return b(imageView, Rw.getWidth(), Rw.getHeight(), i2, i3, this.bMa);
        }
        return false;
    }

    private boolean b(TbRichTextData tbRichTextData, ImageView imageView, int i2, int i3) {
        if (tbRichTextData == null || imageView == null) {
            return false;
        }
        if (tbRichTextData.Ru() == null) {
            return false;
        }
        if (imageView instanceof TbImageView) {
            TbImageView tbImageView = (TbImageView) imageView;
            if (this.bLy.bKx) {
                tbImageView.setSupportNoImage(true);
            }
            tbImageView.startLoad(tbRichTextData.Ru().memeInfo.pic_url, this.mIsFromCDN ? 17 : 18, false);
            tbImageView.setAdjustViewBounds(false);
            tbImageView.setTag(d.g.tag_rich_text_meme_info, tbRichTextData.Ru());
        }
        return b(imageView, tbRichTextData.Ru().memeInfo.width.intValue(), tbRichTextData.Ru().memeInfo.height.intValue(), i2, i3, this.mOnClickListener);
    }

    private boolean c(TbRichTextData tbRichTextData, ImageView imageView, int i2, int i3) {
        if (tbRichTextData == null || imageView == null) {
            return false;
        }
        if (tbRichTextData.Ro() == null) {
            return false;
        }
        if (imageView instanceof TbImageView) {
            TbImageView tbImageView = (TbImageView) imageView;
            if (this.bLy.bKx) {
                tbImageView.setSupportNoImage(true);
            }
            tbImageView.startLoad(tbRichTextData.Ro().RC(), this.mIsFromCDN ? 17 : 18, false);
            if (!tbRichTextData.Ro().RE()) {
                tbImageView.setAdjustViewBounds(false);
            }
            tbImageView.setTag(d.g.tag_rich_text_meme_info, null);
        }
        return a(imageView, tbRichTextData.Ro().getWidth(), tbRichTextData.Ro().getHeight(), i2, i3, this.mOnClickListener);
    }

    private TextView bl(Context context) {
        TextView textView = null;
        if (this.bLA != null) {
            textView = this.bLA.nk();
        }
        if (textView == null || textView.getParent() != null) {
            textView = new TbListTextView(context);
        }
        textView.setPadding(this.bLy.bKl, 0, this.bLy.bKl, 0);
        return textView;
    }

    private boolean a(TbRichTextData tbRichTextData, TextView textView, boolean z, c cVar) {
        LinearLayout.LayoutParams layoutParams;
        if (z) {
            layoutParams = new LinearLayout.LayoutParams(-1, -2);
        } else {
            layoutParams = new LinearLayout.LayoutParams(-2, -2);
        }
        if (this.bLU) {
            layoutParams.gravity = 16;
            textView.setGravity(16);
        } else {
            layoutParams.topMargin = this.bLy.bKm;
        }
        textView.setLineSpacing(this.bLy.bKk, this.bLy.bKj);
        textView.setTextSize(0, this.bLy.bKn);
        textView.setTextColor(this.bLy.mTextColor);
        textView.setLinkTextColor(aj.getColor(d.C0141d.cp_link_tip_c));
        textView.setHighlightColor(getContext().getResources().getColor(d.C0141d.transparent));
        textView.setSingleLine(this.bLy.bKu);
        if (this.bLG != null) {
            textView.setEllipsize(this.bLG);
        }
        if (this.mMaxWidth > 0) {
            textView.setMaxWidth(this.mMaxWidth);
        }
        if (this.bLV > 0) {
            textView.setMaxLines(this.bLV);
        }
        if (tbRichTextData == null) {
            return false;
        }
        SpannableStringBuilder Rp = tbRichTextData.Rp();
        if (Rp == null || Rp.length() <= 0) {
            return false;
        }
        if (this.bLy.bKp > 0 && this.bLy.bKo > 0) {
            tbRichTextData.aT(this.bLy.bKo, this.bLy.bKp);
        }
        if (cVar != null) {
            cVar.a(Rp, textView, this);
        }
        try {
            textView.setText(Rp);
        } catch (Exception e2) {
            textView.setText("");
        }
        if (this.bLW) {
            if (tbRichTextData.Ry()) {
                textView.setMovementMethod(com.baidu.tieba.view.e.bEQ());
            } else {
                textView.setMovementMethod(LinkMovementMethod.getInstance());
            }
        }
        textView.setFocusable(false);
        textView.setLayoutParams(layoutParams);
        textView.setTag(tbRichTextData);
        if (tbRichTextData != null && tbRichTextData.Rr() != null) {
            tbRichTextData.Rr().needRecompute = this.bMc;
        }
        return true;
    }

    private GifView getGifView() {
        GifView gifView = null;
        if (this.bLE != null) {
            gifView = this.bLE.nk();
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
        if (layoutParams == null || layoutParams.width != tbRichTextData.Rt().mGifInfo.mGifWidth || layoutParams.height != tbRichTextData.Rt().mGifInfo.mGifHeight) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(tbRichTextData.Rt().mGifInfo.mGifWidth, tbRichTextData.Rt().mGifInfo.mGifHeight);
            layoutParams2.gravity = 3;
            gifView.setLayoutParams(layoutParams2);
        } else {
            layoutParams.bottomMargin = 0;
        }
        gifView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (TbRichTextView.this.bLS != null) {
                    TbRichTextEmotionInfo Rt = tbRichTextData.Rt();
                    TbRichTextView.this.bLS.a(view, Rt.mGifInfo.mGid, Rt.mGifInfo.mPackageName, Rt.mGifInfo.mIcon, Rt.mGifInfo.mStaticUrl, Rt.mGifInfo.mDynamicUrl, Rt.mGifInfo.mSharpText, Rt.mGifInfo.mGifWidth, Rt.mGifInfo.mGifHeight);
                }
            }
        });
        gifView.a(tbRichTextData.Rt().mGifInfo);
        return true;
    }

    private boolean b(TbRichTextData tbRichTextData, GifView gifView) {
        if (gifView != null) {
            gifView.setDefaultNoImageDay(d.f.icon_click);
            gifView.setBackgroundDrawable(aj.getDrawable(d.C0141d.common_color_10220));
        }
        gifView.setShowStaticDrawable(false);
        gifView.E(tbRichTextData.Ro().RD(), 38);
        return a(gifView, tbRichTextData.Ro().getWidth(), tbRichTextData.Ro().getHeight(), this.bLy.bKq, this.bLy.bKr, this.mOnClickListener);
    }

    private View getVoiceView() {
        View nk = this.bLB != null ? this.bLB.nk() : null;
        if ((nk == null || nk.getParent() != null) && this.bLN != -1) {
            nk = LayoutInflater.from(getContext()).inflate(this.bLN, (ViewGroup) null);
        }
        if (nk != null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.topMargin = this.bLy.bKm;
            layoutParams.bottomMargin = this.bLy.bKC;
            nk.setLayoutParams(layoutParams);
            return nk;
        }
        return null;
    }

    private boolean a(TbRichTextData tbRichTextData, View view) {
        view.setTag(tbRichTextData.Rq());
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LinearLayout.LayoutParams(-2, -2);
        }
        view.setLayoutParams(layoutParams);
        return true;
    }

    private View getTextVoiceView() {
        LinearLayout nk = this.bLC.nk();
        if (nk != null) {
            TextView bl = bl(getContext());
            if (bl == null) {
                this.bLC.ar(nk);
                return null;
            }
            nk.addView(bl);
            View voiceView = getVoiceView();
            if (voiceView == null) {
                this.bLA.ar(bl);
                this.bLC.ar(nk);
                return null;
            }
            nk.addView(voiceView);
            return nk;
        }
        return nk;
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
        if (f2 != this.bLy.bKn) {
            this.bLy.bKn = f2;
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
        if (i2 != this.bLy.mTextColor) {
            this.bLy.mTextColor = i2;
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
        if (this.bLy.bKl != i2) {
            this.bLy.bKl = i2;
            int childCount = getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                if (childAt != null && (childAt instanceof TextView)) {
                    ((TextView) childAt).setPadding(this.bLy.bKl, 0, 0, this.bLy.bKl);
                }
            }
        }
    }

    public void setLinkTextColor(int i2) {
        if (i2 != this.bLy.bKv) {
            this.bLy.bKv = i2;
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
        this.bLF = z;
    }

    public h getOnImageClickListener() {
        return this.bLI;
    }

    public void setOnImageClickListener(h hVar) {
        this.bLI = hVar;
    }

    public void setOnImageTouchListener(com.baidu.tieba.pb.a.c cVar) {
        this.bLJ = cVar;
    }

    public void setOnEmotionClickListener(g gVar) {
        this.bLS = gVar;
    }

    public void o(boolean z, boolean z2) {
        if (this.bLM != z) {
            this.bLM = z;
            if (z2) {
                requestLayout();
            }
            if (!this.bLM && this.bLz != null) {
                this.bLz.clear();
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
        this.bLO = false;
        switch (motionEvent.getAction()) {
            case 1:
            case 3:
                if (!this.bLP) {
                    Sa();
                    break;
                }
                break;
        }
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        switch (motionEvent.getAction()) {
            case 0:
                if (!this.bLO) {
                    RZ();
                    break;
                }
                break;
        }
        return dispatchTouchEvent;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.bLO = true;
        return super.onTouchEvent(motionEvent);
    }

    private void RZ() {
        this.bLP = false;
        if (this.bLQ == null) {
            this.bLQ = new a();
        }
        postDelayed(this.bLQ, ViewConfiguration.getLongPressTimeout());
    }

    private void Sa() {
        if (this.bLQ != null) {
            removeCallbacks(this.bLQ);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!TbRichTextView.this.bLY && TbRichTextView.this.performLongClick()) {
                TbRichTextView.this.bLP = true;
            }
        }
    }

    public void setVoiceViewRes(int i2) {
        this.bLN = i2;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.bMd != drawable) {
            this.bMc = true;
            this.bMd = drawable;
        }
        setText(this.bLT);
        this.bMc = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.bLy != null) {
            this.bLy.release();
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
        this.bLZ = eVar;
        hB(str);
    }

    public void hB(String str) {
        BdUniqueId bdUniqueId;
        boolean z;
        if (TextUtils.isEmpty(str)) {
            this.mUrl = str;
            return;
        }
        getContext();
        com.baidu.adp.base.h ai = com.baidu.adp.base.i.ai(getContext());
        if (ai != null) {
            bdUniqueId = ai.getUniqueId();
            z = ai.isScroll();
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
        com.baidu.adp.widget.a.a aVar = (com.baidu.adp.widget.a.a) com.baidu.adp.lib.f.c.nm().a(this.mUrl, 19, new Object[0]);
        if (aVar != null) {
            f(aVar);
        } else if (z) {
            invalidate();
        } else if (!com.baidu.adp.lib.f.c.nm().dh(19)) {
            invalidate();
        } else {
            com.baidu.adp.lib.f.c.nm().a(this.mUrl, 19, this.mCallback, 0, 0, this.mPageId, new Object[0]);
        }
    }

    public void stopLoad() {
        if (!TextUtils.isEmpty(this.mUrl)) {
            com.baidu.adp.lib.f.c.nm().a(this.mUrl, 19, this.mCallback);
            setBackgroundDrawable(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(com.baidu.adp.widget.a.a aVar) {
        if (aVar != null) {
            try {
                NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(getResources(), aVar.sh(), aVar.sh().getNinePatchChunk(), aVar.sl(), null);
                if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                    ninePatchDrawable.getPaint().setAlpha(80);
                }
                setBackgroundDrawable(ninePatchDrawable);
                if (this.bLZ != null) {
                    this.bLZ.Sc();
                }
            } catch (Exception e2) {
            }
        }
    }

    @Override // com.baidu.adp.b.a.i
    public void refresh() {
        hB(this.mUrl);
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
        return this.bLK;
    }

    public void setOnLinkImageClickListener(i iVar) {
        this.bLK = iVar;
    }

    public void setHasMovementMethod(boolean z) {
        this.bLW = z;
    }

    public void setTextCenter(boolean z) {
        this.bLU = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        boolean bMi;

        private b() {
        }
    }
}
