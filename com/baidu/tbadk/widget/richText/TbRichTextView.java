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
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tbadk.widget.ForeDrawableImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.TbListTextView;
import com.baidu.tbadk.widget.layout.GridImageLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.c;
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
    private static final float cKa = l.ai(TbadkCoreApplication.getInst());
    private int aPy;
    private com.baidu.adp.lib.e.b<ImageView> cIE;
    private com.baidu.adp.lib.e.b<GifView> cIF;
    private com.baidu.tbadk.widget.richText.a cIG;
    private int cIL;
    private h cIN;
    private j cLA;
    private i cLB;
    private View.OnClickListener cLC;
    private boolean cLD;
    private int cLE;
    private View.OnClickListener cLF;
    private boolean cLG;
    private boolean cLH;
    private Runnable cLI;
    private boolean cLJ;
    private g cLK;
    private TbRichText cLL;
    private boolean cLM;
    private boolean cLN;
    private boolean cLO;
    private boolean cLP;
    private boolean cLQ;
    private e cLR;
    public final View.OnClickListener cLS;
    private final f cLT;
    private boolean cLU;
    private Drawable cLV;
    private CustomMessageListener cLW;
    private com.baidu.adp.lib.e.b<TextView> cLt;
    private com.baidu.adp.lib.e.b<View> cLu;
    private com.baidu.adp.lib.e.b<LinearLayout> cLv;
    private com.baidu.adp.lib.e.b<RelativeLayout> cLw;
    private GridImageLayout cLx;
    private boolean cLy;
    private TextUtils.TruncateAt cLz;
    private com.baidu.tieba.pb.a.c ckh;
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
        void ayu();
    }

    /* loaded from: classes.dex */
    public interface f {
        void D(MotionEvent motionEvent);
    }

    /* loaded from: classes.dex */
    public interface g {
        void a(View view, String str, String str2, String str3, String str4, String str5, String str6, int i, int i2);
    }

    /* loaded from: classes.dex */
    public interface h {
        void a(View view, String str, int i, boolean z, boolean z2);
    }

    /* loaded from: classes.dex */
    public interface i {
        void f(View view, String str);
    }

    public void setSubPbPost(boolean z) {
        this.cLO = z;
        ayq();
    }

    public void setIsHost(boolean z) {
        this.isHost = z;
        if (this.cLx != null) {
            this.cLx.setIsHost(z);
        }
    }

    public void setIsUseGridImage(boolean z) {
        this.cLQ = z;
    }

    public boolean ayp() {
        return this.cLJ;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
        if (this.cIG != null) {
            this.cIG.mIsFromCDN = z;
        }
    }

    public void setMaxWidth(int i2) {
        this.mMaxWidth = i2;
    }

    public void setMaxLines(int i2) {
        this.aPy = i2;
    }

    public void setTextEllipsize(TextUtils.TruncateAt truncateAt) {
        this.cLz = truncateAt;
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
    public boolean bh(View view) {
        if (view instanceof ImageView) {
            if (view instanceof GifView) {
                return view.getTag() != null && (view.getTag() instanceof b) && ((b) view.getTag()).cMa;
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

    public static com.baidu.adp.lib.e.b<TextView> s(final Context context, int i2) {
        return new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<TextView>() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: ayt */
            public TextView makeObject() {
                return new TbListTextView(context);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: d */
            public void destroyObject(TextView textView) {
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
            public TextView activateObject(TextView textView) {
                return textView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: f */
            public TextView passivateObject(TextView textView) {
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
        this.cIG = new com.baidu.tbadk.widget.richText.a();
        this.cIE = null;
        this.cLt = null;
        this.cLu = null;
        this.cLv = null;
        this.cLw = null;
        this.cIF = null;
        this.cLy = true;
        this.cLz = null;
        this.cLA = null;
        this.cIN = null;
        this.ckh = null;
        this.cLB = null;
        this.cLC = null;
        this.cLD = true;
        this.mIsFromCDN = true;
        this.cLE = -1;
        this.cLG = false;
        this.cLH = false;
        this.cLI = null;
        this.cLJ = false;
        this.cLM = false;
        this.mMaxWidth = -1;
        this.aPy = -1;
        this.cLN = true;
        this.cLO = false;
        this.isHost = false;
        this.cLP = false;
        this.cLQ = false;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                String str2 = null;
                int i2 = -1;
                if (TbRichTextView.this.cIN != null && (view instanceof ImageView)) {
                    Object tag = view.getTag();
                    if (tag != null && (tag instanceof TbRichText)) {
                        int childCount = TbRichTextView.this.getChildCount();
                        for (int i3 = 0; i3 < childCount; i3++) {
                            i2++;
                            if (view.getParent() == TbRichTextView.this.getChildAt(i3)) {
                                break;
                            }
                        }
                        TbRichTextView.this.cIN.a(view, null, i2, TbRichTextView.this.isHost, false);
                        return;
                    }
                    if (tag != null && (tag instanceof String)) {
                        str2 = (String) tag;
                    } else if ((view instanceof TbImageView) && (view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextMemeInfo)) {
                        TbRichTextMemeInfo tbRichTextMemeInfo = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                        if (tbRichTextMemeInfo != null && tbRichTextMemeInfo.memeInfo != null) {
                            str = tbRichTextMemeInfo.memeInfo.pic_url;
                        } else {
                            str = "";
                        }
                        int childCount2 = TbRichTextView.this.getChildCount();
                        for (int i4 = 0; i4 < childCount2; i4++) {
                            i2++;
                            if (view.getParent() == TbRichTextView.this.getChildAt(i4)) {
                                break;
                            }
                        }
                        TbRichTextView.this.cIN.a(view, str, i2, TbRichTextView.this.isHost, false);
                        return;
                    } else if (view instanceof TbImageView) {
                        str2 = ((TbImageView) view).getUrl();
                    } else if (view instanceof GifView) {
                        str2 = ((GifView) view).getUrl();
                    }
                    int childCount3 = TbRichTextView.this.getChildCount();
                    for (int i5 = 0; i5 < childCount3; i5++) {
                        View childAt = TbRichTextView.this.getChildAt(i5);
                        if (TbRichTextView.this.bh(childAt)) {
                            i2++;
                        }
                        if (view == childAt) {
                            break;
                        }
                    }
                    TbRichTextView.this.cIN.a(view, str2, i2, TbRichTextView.this.isHost, false);
                }
            }
        };
        this.mInternalGestureDetector = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.4
            @Override // com.baidu.tieba.pb.a.c.a
            public boolean b(View view, MotionEvent motionEvent) {
                if (TbRichTextView.this.ckh != null) {
                    TbRichTextView.this.ckh.cq(view);
                    return TbRichTextView.this.ckh.onDoubleTap(motionEvent);
                }
                return false;
            }

            @Override // com.baidu.tieba.pb.a.c.a
            public boolean c(View view, MotionEvent motionEvent) {
                return false;
            }

            @Override // com.baidu.tieba.pb.a.c.a
            public boolean d(View view, MotionEvent motionEvent) {
                if (TbRichTextView.this.mOnClickListener != null) {
                    TbRichTextView.this.mOnClickListener.onClick(view);
                    return true;
                }
                return false;
            }
        });
        this.cLS = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                if (TbRichTextView.this.cLB != null && (view instanceof TbImageView)) {
                    Object tag = view.getTag();
                    if (tag == null || !(tag instanceof d)) {
                        str = null;
                    } else {
                        str = ((d) tag).url;
                    }
                    TbRichTextView.this.cLB.f(view, str);
                }
            }
        };
        this.cLT = new f() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.11
            @Override // com.baidu.tbadk.widget.richText.TbRichTextView.f
            public void D(MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    TbRichTextView.this.cLP = true;
                } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                    TbRichTextView.this.cLP = false;
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
        this.cLW = new CustomMessageListener(2004018) { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int contentSizeOfLzl = TbRichTextView.this.cLO ? TbConfig.getContentSizeOfLzl() : TbConfig.getContentSize();
                if (TbRichTextView.this.cLL != null && !v.aa(TbRichTextView.this.cLL.axz())) {
                    Iterator<TbRichTextData> it = TbRichTextView.this.cLL.axz().iterator();
                    while (it.hasNext()) {
                        TbRichTextData next = it.next();
                        if (next != null) {
                            next.at(contentSizeOfLzl, contentSizeOfLzl);
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
        this.cIG = new com.baidu.tbadk.widget.richText.a();
        this.cIE = null;
        this.cLt = null;
        this.cLu = null;
        this.cLv = null;
        this.cLw = null;
        this.cIF = null;
        this.cLy = true;
        this.cLz = null;
        this.cLA = null;
        this.cIN = null;
        this.ckh = null;
        this.cLB = null;
        this.cLC = null;
        this.cLD = true;
        this.mIsFromCDN = true;
        this.cLE = -1;
        this.cLG = false;
        this.cLH = false;
        this.cLI = null;
        this.cLJ = false;
        this.cLM = false;
        this.mMaxWidth = -1;
        this.aPy = -1;
        this.cLN = true;
        this.cLO = false;
        this.isHost = false;
        this.cLP = false;
        this.cLQ = false;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                String str2 = null;
                int i2 = -1;
                if (TbRichTextView.this.cIN != null && (view instanceof ImageView)) {
                    Object tag = view.getTag();
                    if (tag != null && (tag instanceof TbRichText)) {
                        int childCount = TbRichTextView.this.getChildCount();
                        for (int i3 = 0; i3 < childCount; i3++) {
                            i2++;
                            if (view.getParent() == TbRichTextView.this.getChildAt(i3)) {
                                break;
                            }
                        }
                        TbRichTextView.this.cIN.a(view, null, i2, TbRichTextView.this.isHost, false);
                        return;
                    }
                    if (tag != null && (tag instanceof String)) {
                        str2 = (String) tag;
                    } else if ((view instanceof TbImageView) && (view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextMemeInfo)) {
                        TbRichTextMemeInfo tbRichTextMemeInfo = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                        if (tbRichTextMemeInfo != null && tbRichTextMemeInfo.memeInfo != null) {
                            str = tbRichTextMemeInfo.memeInfo.pic_url;
                        } else {
                            str = "";
                        }
                        int childCount2 = TbRichTextView.this.getChildCount();
                        for (int i4 = 0; i4 < childCount2; i4++) {
                            i2++;
                            if (view.getParent() == TbRichTextView.this.getChildAt(i4)) {
                                break;
                            }
                        }
                        TbRichTextView.this.cIN.a(view, str, i2, TbRichTextView.this.isHost, false);
                        return;
                    } else if (view instanceof TbImageView) {
                        str2 = ((TbImageView) view).getUrl();
                    } else if (view instanceof GifView) {
                        str2 = ((GifView) view).getUrl();
                    }
                    int childCount3 = TbRichTextView.this.getChildCount();
                    for (int i5 = 0; i5 < childCount3; i5++) {
                        View childAt = TbRichTextView.this.getChildAt(i5);
                        if (TbRichTextView.this.bh(childAt)) {
                            i2++;
                        }
                        if (view == childAt) {
                            break;
                        }
                    }
                    TbRichTextView.this.cIN.a(view, str2, i2, TbRichTextView.this.isHost, false);
                }
            }
        };
        this.mInternalGestureDetector = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.4
            @Override // com.baidu.tieba.pb.a.c.a
            public boolean b(View view, MotionEvent motionEvent) {
                if (TbRichTextView.this.ckh != null) {
                    TbRichTextView.this.ckh.cq(view);
                    return TbRichTextView.this.ckh.onDoubleTap(motionEvent);
                }
                return false;
            }

            @Override // com.baidu.tieba.pb.a.c.a
            public boolean c(View view, MotionEvent motionEvent) {
                return false;
            }

            @Override // com.baidu.tieba.pb.a.c.a
            public boolean d(View view, MotionEvent motionEvent) {
                if (TbRichTextView.this.mOnClickListener != null) {
                    TbRichTextView.this.mOnClickListener.onClick(view);
                    return true;
                }
                return false;
            }
        });
        this.cLS = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                if (TbRichTextView.this.cLB != null && (view instanceof TbImageView)) {
                    Object tag = view.getTag();
                    if (tag == null || !(tag instanceof d)) {
                        str = null;
                    } else {
                        str = ((d) tag).url;
                    }
                    TbRichTextView.this.cLB.f(view, str);
                }
            }
        };
        this.cLT = new f() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.11
            @Override // com.baidu.tbadk.widget.richText.TbRichTextView.f
            public void D(MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    TbRichTextView.this.cLP = true;
                } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                    TbRichTextView.this.cLP = false;
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
        this.cLW = new CustomMessageListener(2004018) { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int contentSizeOfLzl = TbRichTextView.this.cLO ? TbConfig.getContentSizeOfLzl() : TbConfig.getContentSize();
                if (TbRichTextView.this.cLL != null && !v.aa(TbRichTextView.this.cLL.axz())) {
                    Iterator<TbRichTextData> it = TbRichTextView.this.cLL.axz().iterator();
                    while (it.hasNext()) {
                        TbRichTextData next = it.next();
                        if (next != null) {
                            next.at(contentSizeOfLzl, contentSizeOfLzl);
                        }
                    }
                }
                TbRichTextView.this.setTextSize(contentSizeOfLzl);
            }
        };
        init();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c.a.TbRichTextView);
        this.cIG.b(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        ayq();
    }

    public com.baidu.tbadk.widget.richText.a getLayoutStrategy() {
        return this.cIG;
    }

    public void setLayoutStrategy(com.baidu.tbadk.widget.richText.a aVar) {
        if (aVar != null) {
            this.cIG.release();
            this.cIG = aVar;
            ayq();
            if (this.cLx != null) {
                this.cLx.setLayoutStrategy(this.cIG);
            }
        }
    }

    private void ayq() {
        int contentSizeOfLzl = this.cLO ? TbConfig.getContentSizeOfLzl() : TbConfig.getContentSize();
        this.cIG.cKg = contentSizeOfLzl;
        this.cIG.cKf = contentSizeOfLzl;
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
            ab.registerListener(this.cLW);
        }
        if (eVar != null) {
            this.cIE = eVar.ayh();
            this.cLt = eVar.ayi();
            this.cLu = eVar.ayk();
            this.cLv = eVar.ayl();
            this.cIF = eVar.ayj();
            this.cLw = eVar.aym();
            if (eVar.getListView() != null && this.cLA == null) {
                this.cLA = new j(eVar.ayg());
                eVar.getListView().setRecyclerListener(this.cLA);
            }
        }
        this.cIL = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20);
        setOrientation(1);
        setOnHierarchyChangeListener(new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.7
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof GifView) && TbRichTextView.this.cIF != null) {
                    TbRichTextView.this.cIF.t((GifView) view2);
                } else if ((view2 instanceof ImageView) && TbRichTextView.this.cIE != null) {
                    TbRichTextView.this.cIE.t((ImageView) view2);
                } else if ((view2 instanceof TextView) && TbRichTextView.this.cLt != null) {
                    TbRichTextView.this.cLt.t((TextView) view2);
                } else if ((view2 instanceof PlayVoiceBnt) && TbRichTextView.this.cLu != null) {
                    TbRichTextView.this.cLu.t(view2);
                } else if ((view2 instanceof PlayVoiceBntNew) && TbRichTextView.this.cLu != null) {
                    TbRichTextView.this.cLu.t(view2);
                } else if (view2 instanceof GridImageLayout) {
                    int childCount = ((GridImageLayout) view2).getChildCount();
                    for (int i2 = 0; i2 < childCount; i2++) {
                        View childAt = ((GridImageLayout) view2).getChildAt(i2);
                        if ((childAt instanceof GifView) && TbRichTextView.this.cIF != null) {
                            TbRichTextView.this.cIF.t((GifView) childAt);
                        } else if ((childAt instanceof ImageView) && TbRichTextView.this.cIE != null) {
                            TbRichTextView.this.cIE.t((ImageView) childAt);
                        }
                    }
                    ((GridImageLayout) view2).removeAllViews();
                    ((GridImageLayout) view2).clearData();
                } else if ((view2 instanceof RelativeLayout) && TbRichTextView.this.cLw != null) {
                    TbRichTextView.this.cLw.t((RelativeLayout) view2);
                }
                if (view2 instanceof LinearLayout) {
                    Object tag = view2.getTag();
                    if (tag == null || !(tag instanceof String) || !"VideoView".equals(tag)) {
                        if (TbRichTextView.this.cLv != null) {
                            int childCount2 = ((LinearLayout) view2).getChildCount();
                            for (int i3 = 0; i3 < childCount2; i3++) {
                                View childAt2 = ((LinearLayout) view2).getChildAt(i3);
                                if (childAt2 != null) {
                                    if ((childAt2 instanceof TextView) && TbRichTextView.this.cLt != null) {
                                        TbRichTextView.this.cLt.t((TextView) childAt2);
                                    } else if ((childAt2 instanceof PlayVoiceBnt) && TbRichTextView.this.cLu != null) {
                                        TbRichTextView.this.cLu.t(childAt2);
                                    } else if ((childAt2 instanceof PlayVoiceBntNew) && TbRichTextView.this.cLu != null) {
                                        TbRichTextView.this.cLu.t(childAt2);
                                    }
                                }
                            }
                            ((LinearLayout) view2).removeAllViews();
                            TbRichTextView.this.cLv.t((LinearLayout) view2);
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
    /* JADX WARN: Type inference failed for: r4v11 */
    public void setText(TbRichText tbRichText, boolean z, c cVar) {
        ArrayList<TbRichTextData> axz;
        int i2;
        int i3;
        RelativeLayout relativeLayout;
        boolean z2;
        SpannableStringBuilder axH;
        boolean z3;
        View view;
        KeyEvent.Callback a2;
        boolean z4;
        int i4;
        int i5;
        if (this.cLL != tbRichText || (tbRichText != null && tbRichText.isChanged)) {
            if (tbRichText != null) {
                tbRichText.isChanged = false;
            }
            this.cLL = tbRichText;
            removeAllViews();
            if (tbRichText != null && (axz = tbRichText.axz()) != null) {
                View view2 = null;
                boolean z5 = true;
                Iterator<TbRichTextData> it = axz.iterator();
                boolean z6 = false;
                int i6 = 0;
                int i7 = 0;
                View view3 = null;
                while (it.hasNext()) {
                    TbRichTextData next = it.next();
                    boolean z7 = false;
                    if (next != null) {
                        if (next.getType() == 1) {
                            TextView cR = cR(getContext());
                            boolean a3 = a(next, cR, true, cVar);
                            if (z && !this.cLJ && (axH = next.axH()) != null) {
                                this.cLJ = axH.length() >= 200;
                            }
                            if (this.ckh != null) {
                                cR.setOnTouchListener(this.mInternalGestureDetector);
                            } else {
                                cR.setOnClickListener(this.cLC);
                            }
                            z7 = a3;
                            i2 = i7;
                            i3 = i6;
                            relativeLayout = cR;
                            z2 = z6;
                        } else if (next.getType() == 8) {
                            if (!this.cLQ) {
                                if (i6 < 10) {
                                    i6++;
                                    if (next.axG() != null) {
                                        if (TbadkCoreApplication.getInst().isGifAutoPlay() && !next.axG().axZ()) {
                                            GifView gifView = getGifView();
                                            b bVar = new b();
                                            bVar.cMa = true;
                                            gifView.setTag(bVar);
                                            z7 = b(next, gifView);
                                            z2 = z6;
                                            i2 = i7;
                                            i3 = i6;
                                            relativeLayout = gifView;
                                        } else {
                                            ?? cQ = cQ(getContext());
                                            z7 = c(next, cQ, this.cIG.cKh, this.cIG.cKi);
                                            z2 = z6;
                                            i2 = i7;
                                            i3 = i6;
                                            relativeLayout = cQ;
                                        }
                                    }
                                    z2 = z6;
                                    i2 = i7;
                                    i3 = i6;
                                    relativeLayout = view3;
                                }
                            } else if (!z6) {
                                GridImageLayout gridImageView = getGridImageView();
                                gridImageView.setData(tbRichText.axA());
                                z7 = true;
                                z2 = true;
                                i2 = i7;
                                i3 = i6;
                                relativeLayout = gridImageView;
                            }
                        } else if (next.getType() == 32) {
                            com.baidu.tbadk.widget.richText.f axK = next.axK();
                            if (axK != null && axK.ayo()) {
                                a2 = b(axK);
                            } else {
                                a2 = a(next);
                            }
                            z2 = z6;
                            i2 = i7;
                            i3 = i6;
                            relativeLayout = a2;
                            z7 = true;
                        } else if (next.getType() == 512) {
                            View bi = bi(view2);
                            if (bi == null) {
                                view3 = bi;
                            } else {
                                z2 = z6;
                                i2 = i7;
                                i3 = i6;
                                relativeLayout = bi;
                                z7 = a(next, bi);
                            }
                        } else if (next.getType() == 768) {
                            View textVoiceView = getTextVoiceView();
                            z7 = a(next, (LinearLayout) textVoiceView, cVar);
                            z2 = z6;
                            i2 = i7;
                            i3 = i6;
                            relativeLayout = textVoiceView;
                        } else if (next.getType() == 17) {
                            GifView gifView2 = getGifView();
                            z7 = a(next, gifView2);
                            z2 = z6;
                            i2 = i7;
                            i3 = i6;
                            relativeLayout = gifView2;
                        } else if (next.getType() == 20) {
                            if (i7 < 10) {
                                int i8 = i7 + 1;
                                if (next == null || next.axM() == null || next.axM().memeInfo == null || StringUtils.isNull(next.axM().memeInfo.pic_url)) {
                                    z4 = false;
                                } else {
                                    z4 = true;
                                }
                                if (z4) {
                                    RelativeLayout iu = this.cLw.iu();
                                    iu.removeAllViews();
                                    iu.setLayoutParams(new LinearLayout.LayoutParams(next.axM().memeInfo.width.intValue(), next.axM().memeInfo.height.intValue()));
                                    if (com.baidu.tbadk.t.v.auH() && this.cLy) {
                                        b(iu, next.axM().memeInfo.width.intValue(), next.axM().memeInfo.height.intValue(), this.cIG.cKh, this.cIG.cKi);
                                    } else {
                                        a(iu, next.axM().memeInfo.width.intValue(), next.axM().memeInfo.height.intValue(), this.cIG.cKh, this.cIG.cKi);
                                    }
                                    ImageView iu2 = this.cIE.iu();
                                    b(next, iu2, this.cIG.cKh, this.cIG.cKi);
                                    if (com.baidu.tbadk.t.v.auH() && this.cLy) {
                                        ImageView iu3 = this.cIE.iu();
                                        iu3.setTag(this.cLL);
                                        if (iu3 instanceof TbImageView) {
                                            TbImageView tbImageView = (TbImageView) iu3;
                                            tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
                                            tbImageView.setBorderColor(al.getColor(R.color.black_alpha8));
                                            tbImageView.setBorderSurroundContent(true);
                                            tbImageView.setDrawCorner(true);
                                            tbImageView.setDrawBorder(true);
                                            tbImageView.setLongIconSupport(true);
                                            tbImageView.setGifIconSupport(true);
                                            tbImageView.setConrers(15);
                                            tbImageView.setRadius(this.cIL);
                                            tbImageView.setAdjustViewBounds(false);
                                            tbImageView.setDefaultBgResource(com.baidu.tbadk.util.e.get());
                                        }
                                        iu3.setScaleType(ImageView.ScaleType.FIT_XY);
                                        int g2 = l.g(getContext(), R.dimen.ds78);
                                        int g3 = l.g(getContext(), R.dimen.ds78);
                                        iu2.setId(R.id.meme_image_view);
                                        c(iu2, next.axM().memeInfo.width.intValue(), next.axM().memeInfo.height.intValue(), this.cIG.cKh, this.cIG.cKi, this.mOnClickListener);
                                        iu.addView(iu2);
                                        if (g3 > next.axM().memeInfo.height.intValue()) {
                                            i5 = g2 / 2;
                                            i4 = g3 / 2;
                                        } else {
                                            i4 = g3;
                                            i5 = g2;
                                        }
                                        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i5, i4);
                                        layoutParams.addRule(8, R.id.meme_image_view);
                                        layoutParams.addRule(11);
                                        iu3.setOnClickListener(this.mOnClickListener);
                                        if (iu.getLeft() > 0) {
                                            layoutParams.rightMargin = l.g(getContext(), R.dimen.ds6);
                                        }
                                        al.c(iu3, (int) R.drawable.icon_emotion_dui_n);
                                        iu.addView(iu3, layoutParams);
                                    } else {
                                        b(iu2, next.axM().memeInfo.width.intValue(), next.axM().memeInfo.height.intValue(), this.cIG.cKh, this.cIG.cKi, this.mOnClickListener);
                                        iu.addView(iu2);
                                    }
                                    z7 = z4;
                                    z2 = z6;
                                    i2 = i8;
                                    i3 = i6;
                                    relativeLayout = iu;
                                } else {
                                    z7 = z4;
                                    z2 = z6;
                                    i2 = i8;
                                    i3 = i6;
                                    relativeLayout = view3;
                                }
                            }
                        } else {
                            if (next.getType() == 1280) {
                                ImageView cQ2 = cQ(getContext());
                                z7 = a(next, cQ2, (this.cIG.cKh - getPaddingLeft()) - getPaddingRight(), this.cIG.cKi);
                                z2 = z6;
                                i2 = i7;
                                i3 = i6 + 1;
                                relativeLayout = cQ2;
                            }
                            z2 = z6;
                            i2 = i7;
                            i3 = i6;
                            relativeLayout = view3;
                        }
                        if (!z7 || relativeLayout == null) {
                            z3 = z5;
                            view = view2;
                        } else {
                            addView(relativeLayout);
                            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) relativeLayout.getLayoutParams();
                            if (z5 && this.cIG.cKx >= 0) {
                                z5 = false;
                                if (layoutParams2 != null) {
                                    layoutParams2.topMargin = this.cIG.cKx;
                                    relativeLayout.setLayoutParams(layoutParams2);
                                    z3 = false;
                                    view = relativeLayout;
                                }
                                z3 = z5;
                                view = relativeLayout;
                            } else if (relativeLayout instanceof TbListTextView) {
                                if ((view2 instanceof ImageView) || (view2 instanceof RelativeLayout)) {
                                    layoutParams2.topMargin = this.cIG.cKt;
                                } else {
                                    layoutParams2.topMargin = this.cIG.cKd;
                                }
                                relativeLayout.setLayoutParams(layoutParams2);
                                z3 = z5;
                                view = relativeLayout;
                            } else {
                                if (((relativeLayout instanceof ImageView) || (relativeLayout instanceof RelativeLayout)) && (next.getType() == 8 || next.getType() == 20 || next.getType() == 17)) {
                                    if (view2 instanceof TbListTextView) {
                                        layoutParams2.topMargin = this.cIG.cKr;
                                    } else if ((view2 instanceof ImageView) || (relativeLayout instanceof RelativeLayout)) {
                                        layoutParams2.topMargin = this.cIG.cKq;
                                    } else {
                                        layoutParams2.topMargin = this.cIG.cKd;
                                    }
                                    relativeLayout.setLayoutParams(layoutParams2);
                                }
                                z3 = z5;
                                view = relativeLayout;
                            }
                        }
                        z6 = z2;
                        z5 = z3;
                        i6 = i3;
                        view2 = view;
                        view3 = relativeLayout;
                        i7 = i2;
                    }
                }
                if (view2 instanceof TbListTextView) {
                    LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) view2.getLayoutParams();
                    layoutParams3.bottomMargin = this.cIG.cKw;
                    view2.setLayoutParams(layoutParams3);
                } else if (view2 != null && this.cIG.cKv >= 0) {
                    LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) view2.getLayoutParams();
                    layoutParams4.bottomMargin = this.cIG.cKv;
                    view2.setLayoutParams(layoutParams4);
                }
            }
        }
    }

    private GridImageLayout getGridImageView() {
        if (this.cLx == null || this.cLx.getParent() != null) {
            this.cLx = new GridImageLayout(getContext());
            this.cLx.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        }
        this.cLx.setLayoutStrategy(this.cIG);
        this.cLx.setObjectPool(this.cIE, this.cIF);
        this.cLx.setOnImageClickListener(this.cIN);
        this.cLx.setIsHost(this.isHost);
        return this.cLx;
    }

    public void setCommonTextViewOnClickListener(View.OnClickListener onClickListener) {
        this.cLC = onClickListener;
    }

    private View b(final com.baidu.tbadk.widget.richText.f fVar) {
        if (fVar == null || !fVar.isAvaliable()) {
            return null;
        }
        ImageView iu = this.cIE.iu();
        if (iu instanceof ForeDrawableImageView) {
            ForeDrawableImageView foreDrawableImageView = (ForeDrawableImageView) iu;
            foreDrawableImageView.setForegroundDrawable(R.drawable.icon_play_video);
            foreDrawableImageView.setNoImageBottomTextColor(R.color.cp_cont_c);
            foreDrawableImageView.setNoImageBottomTextPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds32));
            foreDrawableImageView.setNoImageBottomTextSize(TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.fontsize28));
            foreDrawableImageView.setNoImageBottomText("点击播放视频");
            foreDrawableImageView.setInterceptOnClick(false);
            foreDrawableImageView.setTag("VideoView");
            b(foreDrawableImageView, fVar.getWidth(), fVar.getHeight(), (this.cIG.cKh - getPaddingLeft()) - getPaddingRight(), this.cIG.cKi, new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log("c10643");
                    XiaoyingUtil.startPlayXiaoyingVideo(TbRichTextView.this.getContext(), fVar.getVideoUrl(), fVar.getWidth(), fVar.getHeight(), fVar.getThumbUrl());
                }
            });
            foreDrawableImageView.setDefaultResource(0);
            foreDrawableImageView.setSupportNoImage(this.cIG.cKo);
            if (com.baidu.tbadk.core.i.abb().abf()) {
                foreDrawableImageView.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            } else {
                foreDrawableImageView.setDefaultBgResource(R.color.cp_bg_line_c);
            }
            foreDrawableImageView.startLoad(fVar.getThumbUrl(), 17, false);
            return iu;
        }
        return iu;
    }

    private boolean a(ImageView imageView, int i2, int i3, int i4, int i5, View.OnClickListener onClickListener) {
        int[] o = this.cIG.o(i2, i3, i4, i5);
        if (o == null) {
            return false;
        }
        int i6 = o[0];
        int i7 = o[1];
        if (imageView instanceof TbImageView) {
            TbImageView tbImageView = (TbImageView) imageView;
            tbImageView.setDefaultResource(this.cIG.cKj);
            if (tbImageView.getGifIconWidth() >= i6 || tbImageView.getGifIconHeight() >= i7) {
                tbImageView.setGifIconSupport(false);
            } else {
                tbImageView.setGifIconSupport(true);
            }
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i6, i7);
        if (this.cIG.cKp) {
            imageView.setScaleType(this.cIG.cKn);
            if (imageView instanceof TbImageView) {
                ((TbImageView) imageView).setOnDrawListener(this.cIG.mOnDrawListener);
            }
        } else {
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        }
        imageView.setClickable(true);
        imageView.setFocusable(false);
        if (this.ckh != null && (imageView instanceof TbImageView)) {
            ((TbImageView) imageView).setTbGestureDetector(this.mInternalGestureDetector);
            imageView.setClickable(true);
        } else {
            imageView.setOnClickListener(onClickListener);
        }
        imageView.setLayoutParams(layoutParams);
        if (imageView instanceof TbImageView) {
            if (this.onLongClickListener != null) {
                ((TbImageView) imageView).setDispatchTouchListener(this.cLT);
                imageView.setOnLongClickListener(this.onLongClickListener);
            }
        } else if ((imageView instanceof GifView) && this.onLongClickListener != null) {
            ((GifView) imageView).setDispatchTouchListener(this.cLT);
            imageView.setOnLongClickListener(this.onLongClickListener);
        }
        return true;
    }

    private boolean b(ImageView imageView, int i2, int i3, int i4, int i5, View.OnClickListener onClickListener) {
        int i6;
        int[] b2 = l.b(i2, i3, i4, i5);
        if (b2 == null) {
            return false;
        }
        int[] iArr = {b2[0], b2[1]};
        int i7 = iArr[0];
        int i8 = iArr[1];
        if (!this.cIG.cKp || i4 <= i7 || cKa <= 1.0f) {
            i4 = i7;
            i6 = i8;
        } else {
            if (i7 * cKa <= i4) {
                if (i7 * cKa > i4 * 0.68f) {
                    i4 = (int) (i4 * 0.68f);
                } else {
                    i4 = (int) (i7 * cKa);
                }
            }
            i6 = iArr[0] > 0 ? (iArr[1] * i4) / iArr[0] : i8;
        }
        if (imageView instanceof TbImageView) {
            TbImageView tbImageView = (TbImageView) imageView;
            tbImageView.setDefaultResource(this.cIG.cKj);
            if (tbImageView.getGifIconWidth() >= i4 || tbImageView.getGifIconHeight() >= i6) {
                tbImageView.setGifIconSupport(false);
            } else {
                tbImageView.setGifIconSupport(true);
            }
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i4, i6);
        if (this.cIG.cKp) {
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        } else {
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        }
        imageView.setClickable(true);
        imageView.setFocusable(false);
        if (this.ckh != null && (imageView instanceof TbImageView)) {
            ((TbImageView) imageView).setTbGestureDetector(this.mInternalGestureDetector);
            imageView.setClickable(true);
        } else {
            imageView.setOnClickListener(onClickListener);
        }
        imageView.setLayoutParams(layoutParams);
        if (imageView instanceof TbImageView) {
            if (this.onLongClickListener != null) {
                ((TbImageView) imageView).setDispatchTouchListener(this.cLT);
                imageView.setOnLongClickListener(this.onLongClickListener);
            }
        } else if ((imageView instanceof GifView) && this.onLongClickListener != null) {
            imageView.setOnLongClickListener(this.onLongClickListener);
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00e8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean c(ImageView imageView, int i2, int i3, int i4, int i5, View.OnClickListener onClickListener) {
        int i6;
        int i7;
        int[] b2 = l.b(i2, i3, i4, i5);
        if (b2 == null) {
            return false;
        }
        int[] iArr = {b2[0], b2[1]};
        int i8 = iArr[0];
        int i9 = iArr[1];
        if (this.cIG.cKp && i4 > i8 && cKa > 1.0f) {
            if (i8 * cKa > i4) {
                i8 = (i4 - l.g(getContext(), R.dimen.ds78)) - l.g(getContext(), R.dimen.ds16);
            } else if (i8 * cKa > i4 * 0.68f) {
                i8 = ((int) (i4 * 0.68f)) - l.g(getContext(), R.dimen.ds78);
            } else {
                i8 = (int) (i8 * cKa);
            }
            if (iArr[0] > 0) {
                i6 = (iArr[1] * i8) / iArr[0];
                i7 = i8;
                if (imageView instanceof TbImageView) {
                    TbImageView tbImageView = (TbImageView) imageView;
                    tbImageView.setDefaultResource(this.cIG.cKj);
                    if (tbImageView.getGifIconWidth() >= i7 || tbImageView.getGifIconHeight() >= i6) {
                        tbImageView.setGifIconSupport(false);
                    } else {
                        tbImageView.setGifIconSupport(true);
                    }
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i7, i6);
                if (!this.cIG.cKp) {
                    imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                } else {
                    imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                }
                imageView.setClickable(true);
                imageView.setFocusable(false);
                if (this.ckh == null && (imageView instanceof TbImageView)) {
                    ((TbImageView) imageView).setTbGestureDetector(this.mInternalGestureDetector);
                    imageView.setClickable(true);
                } else {
                    imageView.setOnClickListener(onClickListener);
                }
                imageView.setLayoutParams(layoutParams);
                if (!(imageView instanceof TbImageView)) {
                    if (this.onLongClickListener != null) {
                        ((TbImageView) imageView).setDispatchTouchListener(this.cLT);
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
        if (!this.cIG.cKp) {
        }
        imageView.setClickable(true);
        imageView.setFocusable(false);
        if (this.ckh == null) {
        }
        imageView.setOnClickListener(onClickListener);
        imageView.setLayoutParams(layoutParams2);
        if (!(imageView instanceof TbImageView)) {
        }
        return true;
    }

    private void a(RelativeLayout relativeLayout, int i2, int i3, int i4, int i5) {
        int[] b2 = l.b(i2, i3, i4, i5);
        if (b2 != null) {
            int[] iArr = {b2[0], b2[1]};
            int i6 = iArr[0];
            int i7 = iArr[1];
            if (!this.cIG.cKp || i4 <= i6 || cKa <= 1.0f) {
                i4 = i6;
            } else {
                if (i6 * cKa <= i4) {
                    if (i6 * cKa > i4 * 0.68f) {
                        i4 = (int) (i4 * 0.68f);
                    } else {
                        i4 = (int) (i6 * cKa);
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
        int[] b2 = l.b(i2, i3, i4, i5);
        if (b2 != null) {
            int[] iArr = {b2[0], b2[1]};
            int i8 = iArr[0];
            int i9 = iArr[1];
            if (this.cIG.cKp && i4 > i8 && cKa > 1.0f) {
                if (i8 * cKa > i4) {
                    i7 = (i4 - l.g(getContext(), R.dimen.ds78)) - l.g(getContext(), R.dimen.ds16);
                } else if (i8 * cKa > i4 * 0.68f) {
                    i7 = ((int) (i4 * 0.68f)) - l.g(getContext(), R.dimen.ds78);
                } else {
                    i7 = (int) (i8 * cKa);
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
        if (this.cIG.cKk <= 0 || tbRichTextData == null) {
            return null;
        }
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setTag("VideoView");
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = this.cIG.cKd;
        linearLayout.setClickable(true);
        Bitmap id = al.id(this.cIG.cKk);
        if (id != null) {
            linearLayout.setBackgroundDrawable(new BitmapDrawable(getContext().getResources(), id));
        }
        linearLayout.setFocusable(false);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (tbRichTextData.axH() != null) {
                    if (TbRichTextView.this.getContext() instanceof com.baidu.tbadk.widget.richText.e) {
                        ((com.baidu.tbadk.widget.richText.e) TbRichTextView.this.getContext()).an(TbRichTextView.this.getContext(), tbRichTextData.axH().toString());
                        return;
                    }
                    com.baidu.adp.base.e<?> ab = com.baidu.adp.base.i.ab(TbRichTextView.this.getContext());
                    if (ab != null && (ab.getOrignalPage() instanceof com.baidu.tbadk.widget.richText.e)) {
                        ((com.baidu.tbadk.widget.richText.e) ab.getOrignalPage()).an(TbRichTextView.this.getContext(), tbRichTextData.axH().toString());
                    }
                }
            }
        });
        return linearLayout;
    }

    private ImageView cQ(Context context) {
        ImageView iu = this.cIE != null ? this.cIE.iu() : null;
        if (iu == null || iu.getParent() != null) {
            iu = null;
        }
        if (iu != null) {
            iu.setContentDescription(context.getString(R.string.editor_image));
        }
        return iu;
    }

    private boolean a(TbRichTextData tbRichTextData, ImageView imageView, int i2, int i3) {
        if (tbRichTextData == null || imageView == null) {
            return false;
        }
        TbRichTextLinkImageInfo axO = tbRichTextData.axO();
        if (axO != null && axO.getLink() != null) {
            if (imageView instanceof TbImageView) {
                TbImageView tbImageView = (TbImageView) imageView;
                if (this.cIG.cKo) {
                    tbImageView.setSupportNoImage(true);
                }
                tbImageView.startLoad(axO.ayf(), this.mIsFromCDN ? 17 : 18, false);
                tbImageView.setTag(new d(axO.getLink()));
                if (!axO.axW()) {
                    tbImageView.setAdjustViewBounds(false);
                }
            }
            return b(imageView, axO.getWidth(), axO.getHeight(), i2, i3, this.cLS);
        }
        return false;
    }

    private boolean b(TbRichTextData tbRichTextData, ImageView imageView, int i2, int i3) {
        if (tbRichTextData == null || imageView == null) {
            return false;
        }
        if (tbRichTextData.axM() == null) {
            return false;
        }
        if (imageView instanceof TbImageView) {
            TbImageView tbImageView = (TbImageView) imageView;
            tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
            tbImageView.setBorderColor(al.getColor(R.color.black_alpha8));
            tbImageView.setBorderSurroundContent(true);
            tbImageView.setDrawCorner(true);
            tbImageView.setDrawBorder(true);
            tbImageView.setLongIconSupport(true);
            tbImageView.setGifIconSupport(true);
            tbImageView.setConrers(15);
            tbImageView.setRadius(this.cIL);
            tbImageView.setDefaultBgResource(com.baidu.tbadk.util.e.get());
            if (this.cIG.cKo) {
                tbImageView.setSupportNoImage(true);
            }
            tbImageView.startLoad(tbRichTextData.axM().memeInfo.pic_url, this.mIsFromCDN ? 17 : 18, false);
            tbImageView.setAdjustViewBounds(false);
            tbImageView.setTag(R.id.tag_rich_text_meme_info, tbRichTextData.axM());
        }
        return b(imageView, tbRichTextData.axM().memeInfo.width.intValue(), tbRichTextData.axM().memeInfo.height.intValue(), i2, i3, this.mOnClickListener);
    }

    private boolean c(TbRichTextData tbRichTextData, ImageView imageView, int i2, int i3) {
        if (tbRichTextData == null || imageView == null) {
            return false;
        }
        if (tbRichTextData.axG() == null) {
            return false;
        }
        if (imageView instanceof TbImageView) {
            TbImageView tbImageView = (TbImageView) imageView;
            tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
            tbImageView.setBorderColor(al.getColor(R.color.black_alpha8));
            tbImageView.setBorderSurroundContent(true);
            tbImageView.setDrawCorner(true);
            tbImageView.setDrawBorder(true);
            tbImageView.setLongIconSupport(true);
            tbImageView.setGifIconSupport(true);
            tbImageView.setConrers(15);
            tbImageView.setRadius(this.cIL);
            tbImageView.setDefaultBgResource(com.baidu.tbadk.util.e.get());
            if (this.cIG.cKo) {
                tbImageView.setSupportNoImage(true);
            }
            tbImageView.startLoad(this.cIG.axy() ? tbRichTextData.axG().axR() : tbRichTextData.axG().axU(), this.mIsFromCDN ? 17 : 18, false);
            if (!tbRichTextData.axG().axW()) {
                tbImageView.setAdjustViewBounds(false);
            }
            tbImageView.setTag(R.id.tag_rich_text_meme_info, null);
        }
        return a(imageView, tbRichTextData.axG().getWidth(), tbRichTextData.axG().getHeight(), i2, i3, this.mOnClickListener);
    }

    private TextView cR(Context context) {
        TextView textView = null;
        if (this.cLt != null) {
            textView = this.cLt.iu();
        }
        if (textView == null || textView.getParent() != null) {
            textView = new TbListTextView(context);
        }
        textView.setPadding(this.cIG.bWr, 0, this.cIG.bWr, 0);
        return textView;
    }

    private boolean a(TbRichTextData tbRichTextData, TextView textView, boolean z, c cVar) {
        LinearLayout.LayoutParams layoutParams;
        if (z) {
            layoutParams = new LinearLayout.LayoutParams(-1, -2);
        } else {
            layoutParams = new LinearLayout.LayoutParams(-2, -2);
        }
        if (this.cLM) {
            layoutParams.gravity = 16;
            textView.setGravity(16);
        } else {
            layoutParams.topMargin = this.cIG.cKd;
        }
        textView.setLineSpacing(this.cIG.cKc, this.cIG.cKb);
        textView.setTextSize(0, this.cIG.cKe);
        textView.setTextColor(this.cIG.mTextColor);
        textView.setLinkTextColor(al.getColor(R.color.cp_link_tip_c));
        textView.setHighlightColor(getContext().getResources().getColor(R.color.transparent));
        textView.setSingleLine(this.cIG.cKl);
        if (this.cLz != null) {
            textView.setEllipsize(this.cLz);
        }
        if (this.mMaxWidth > 0) {
            textView.setMaxWidth(this.mMaxWidth);
        }
        if (this.aPy > 0) {
            textView.setMaxLines(this.aPy);
        }
        if (tbRichTextData == null) {
            return false;
        }
        SpannableStringBuilder axH = tbRichTextData.axH();
        if (axH == null || axH.length() <= 0) {
            return false;
        }
        if (this.cIG.cKg > 0 && this.cIG.cKf > 0) {
            tbRichTextData.at(this.cIG.cKf, this.cIG.cKg);
        }
        if (cVar != null) {
            cVar.a(axH, textView, this);
        }
        try {
            textView.setText(axH);
        } catch (Exception e2) {
            textView.setText("");
        }
        if (this.cLN) {
            if (tbRichTextData.axQ()) {
                textView.setMovementMethod(com.baidu.tieba.view.c.cvc());
            } else {
                textView.setMovementMethod(LinkMovementMethod.getInstance());
            }
        }
        textView.setFocusable(false);
        textView.setLayoutParams(layoutParams);
        textView.setTag(tbRichTextData);
        if (tbRichTextData != null && tbRichTextData.axJ() != null) {
            tbRichTextData.axJ().needRecompute = this.cLU;
        }
        return true;
    }

    private GifView getGifView() {
        GifView gifView = null;
        if (this.cIF != null) {
            gifView = this.cIF.iu();
        }
        GifView gifView2 = (gifView == null || gifView.getParent() != null) ? new GifView(getContext()) : gifView;
        gifView2.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        gifView2.setBorderColor(al.getColor(R.color.black_alpha8));
        gifView2.setBorderSurroundContent(true);
        gifView2.setDrawCorner(true);
        gifView2.setDrawBorder(true);
        gifView2.setConrers(15);
        gifView2.setDrawBorder(true);
        gifView2.setRadius(this.cIL);
        gifView2.setDefaultBgResource(com.baidu.tbadk.util.e.get());
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
        if (layoutParams == null || layoutParams.width != tbRichTextData.axL().mGifInfo.mGifWidth || layoutParams.height != tbRichTextData.axL().mGifInfo.mGifHeight) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(tbRichTextData.axL().mGifInfo.mGifWidth, tbRichTextData.axL().mGifInfo.mGifHeight);
            layoutParams2.gravity = 3;
            gifView.setLayoutParams(layoutParams2);
        } else {
            layoutParams.bottomMargin = 0;
        }
        gifView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (TbRichTextView.this.cLK != null) {
                    TbRichTextEmotionInfo axL = tbRichTextData.axL();
                    TbRichTextView.this.cLK.a(view, axL.mGifInfo.mGid, axL.mGifInfo.mPackageName, axL.mGifInfo.mIcon, axL.mGifInfo.mStaticUrl, axL.mGifInfo.mDynamicUrl, axL.mGifInfo.mSharpText, axL.mGifInfo.mGifWidth, axL.mGifInfo.mGifHeight);
                }
            }
        });
        gifView.a(tbRichTextData.axL().mGifInfo);
        return true;
    }

    private boolean b(TbRichTextData tbRichTextData, GifView gifView) {
        if (gifView == null) {
            return false;
        }
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            gifView.setDefaultNoImageDay(al.b(getContext().getResources(), (int) R.drawable.icon_click));
        } else {
            gifView.setDefaultNoImageDay(R.drawable.icon_click);
        }
        Drawable drawable = al.getDrawable(com.baidu.tbadk.util.e.get());
        if (drawable != null) {
            gifView.setBackgroundDrawable(drawable);
        } else {
            gifView.setBackgroundDrawable(al.getDrawable(R.color.common_color_10220));
        }
        String axV = tbRichTextData.axG().axV();
        if (StringUtils.isNull(axV)) {
            if (this.cIG.cKy) {
                axV = this.cIG.mIsFromCDN ? tbRichTextData.axG().axR() : tbRichTextData.axG().axT();
            }
            if (StringUtils.isNull(axV)) {
                axV = this.cIG.mIsFromCDN ? tbRichTextData.axG().axU() : tbRichTextData.axG().getSrc();
            }
        }
        gifView.setShowStaticDrawable(false);
        gifView.Z(axV, 38);
        return a(gifView, tbRichTextData.axG().getWidth(), tbRichTextData.axG().getHeight(), this.cIG.cKh, this.cIG.cKi, this.mOnClickListener);
    }

    private View bi(View view) {
        View iu = this.cLu != null ? this.cLu.iu() : null;
        if ((iu == null || iu.getParent() != null) && this.cLE != -1) {
            iu = LayoutInflater.from(getContext()).inflate(this.cLE, (ViewGroup) null);
        }
        if (iu != null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            if ((view instanceof TbListTextView) && this.cIG.cKs >= 0) {
                layoutParams.topMargin = this.cIG.cKs;
            } else {
                layoutParams.topMargin = this.cIG.cKd;
            }
            layoutParams.bottomMargin = this.cIG.cKu;
            iu.setLayoutParams(layoutParams);
            if (iu instanceof PlayVoiceBntNew) {
                ((PlayVoiceBntNew) iu).setAfterClickListener(this.cLF);
                return iu;
            }
            return iu;
        }
        return null;
    }

    private boolean a(TbRichTextData tbRichTextData, View view) {
        view.setTag(tbRichTextData.axI());
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LinearLayout.LayoutParams(-2, -2);
        }
        view.setLayoutParams(layoutParams);
        return true;
    }

    private View getTextVoiceView() {
        LinearLayout iu = this.cLv.iu();
        if (iu != null) {
            TextView cR = cR(getContext());
            if (cR == null) {
                this.cLv.t(iu);
                return null;
            }
            iu.addView(cR);
            View bi = bi(null);
            if (bi == null) {
                this.cLt.t(cR);
                this.cLv.t(iu);
                return null;
            }
            iu.addView(bi);
            return iu;
        }
        return iu;
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
        if (f2 != this.cIG.cKe) {
            this.cIG.cKe = f2;
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
        if (i2 != this.cIG.mTextColor) {
            this.cIG.mTextColor = i2;
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
        if (this.cIG.bWr != i2) {
            this.cIG.bWr = i2;
            int childCount = getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                if (childAt != null && (childAt instanceof TextView)) {
                    ((TextView) childAt).setPadding(this.cIG.bWr, 0, 0, this.cIG.bWr);
                }
            }
        }
    }

    public void setLinkTextColor(int i2) {
        if (i2 != this.cIG.cKm) {
            this.cIG.cKm = i2;
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
        this.cLy = z;
    }

    public h getOnImageClickListener() {
        return this.cIN;
    }

    public void setOnImageClickListener(h hVar) {
        this.cIN = hVar;
        if (this.cLx != null) {
            this.cLx.setOnImageClickListener(this.cIN);
        }
    }

    public void setOnImageTouchListener(com.baidu.tieba.pb.a.c cVar) {
        this.ckh = cVar;
    }

    public void setOnEmotionClickListener(g gVar) {
        this.cLK = gVar;
    }

    public void setDisplayImage(boolean z, boolean z2) {
        if (this.cLD != z) {
            this.cLD = z;
            if (z2) {
                requestLayout();
            }
            if (!this.cLD && this.cIE != null) {
                this.cIE.clear();
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
        this.cLG = false;
        switch (motionEvent.getAction()) {
            case 1:
            case 3:
                if (!this.cLH) {
                    ays();
                    break;
                }
                break;
        }
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        switch (motionEvent.getAction()) {
            case 0:
                if (!this.cLG) {
                    ayr();
                    break;
                }
                break;
        }
        return dispatchTouchEvent;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.cLH && (motionEvent.getAction() == 3 || motionEvent.getAction() == 1)) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.cLG = true;
        return super.onTouchEvent(motionEvent);
    }

    private void ayr() {
        this.cLH = false;
        if (this.cLI == null) {
            this.cLI = new a();
        }
        postDelayed(this.cLI, ViewConfiguration.getLongPressTimeout());
    }

    private void ays() {
        if (this.cLI != null) {
            removeCallbacks(this.cLI);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!TbRichTextView.this.cLP && TbRichTextView.this.performLongClick()) {
                TbRichTextView.this.cLH = true;
            }
        }
    }

    public void setVoiceViewRes(int i2) {
        this.cLE = i2;
    }

    public void setOnVoiceAfterClickListener(View.OnClickListener onClickListener) {
        this.cLF = onClickListener;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.cLV != drawable) {
            this.cLU = true;
            this.cLV = drawable;
        }
        setText(this.cLL);
        this.cLU = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.cIG != null) {
            this.cIG.release();
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
        this.cLR = eVar;
        rk(str);
    }

    public void rk(String str) {
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
        com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) com.baidu.adp.lib.f.c.iv().b(this.mUrl, 19, new Object[0]);
        if (aVar != null) {
            f(aVar);
        } else if (z) {
            invalidate();
        } else if (!com.baidu.adp.lib.f.c.iv().aj(19)) {
            invalidate();
        } else {
            com.baidu.adp.lib.f.c.iv().a(this.mUrl, 19, this.mCallback, 0, 0, this.mPageId, new Object[0]);
        }
    }

    public void stopLoad() {
        if (!TextUtils.isEmpty(this.mUrl)) {
            com.baidu.adp.lib.f.c.iv().a(this.mUrl, 19, this.mCallback);
            setBackgroundDrawable(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null) {
            try {
                NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(getResources(), aVar.ns(), aVar.ns().getNinePatchChunk(), aVar.nw(), null);
                if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                    ninePatchDrawable.getPaint().setAlpha(80);
                }
                setBackgroundDrawable(ninePatchDrawable);
                if (this.cLR != null) {
                    this.cLR.ayu();
                }
            } catch (Exception e2) {
            }
        }
    }

    @Override // com.baidu.adp.newwidget.ImageView.h
    public void refresh() {
        rk(this.mUrl);
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
        return this.cLB;
    }

    public void setOnLinkImageClickListener(i iVar) {
        this.cLB = iVar;
    }

    public void setHasMovementMethod(boolean z) {
        this.cLN = z;
    }

    public void setTextCenter(boolean z) {
        this.cLM = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        boolean cMa;

        private b() {
        }
    }
}
