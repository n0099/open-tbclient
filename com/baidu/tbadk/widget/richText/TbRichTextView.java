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
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
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
    private static final float bHX = l.ar(TbadkCoreApplication.getInst());
    private View.OnClickListener bJA;
    private boolean bJB;
    private int bJC;
    private boolean bJD;
    private boolean bJE;
    private Runnable bJF;
    private boolean bJG;
    private g bJH;
    private TbRichText bJI;
    private boolean bJJ;
    private int bJK;
    private boolean bJL;
    private boolean bJM;
    private boolean bJN;
    private e bJO;
    public final View.OnClickListener bJP;
    private final f bJQ;
    private boolean bJR;
    private Drawable bJS;
    private CustomMessageListener bJT;
    private com.baidu.tbadk.widget.richText.a bJn;
    private com.baidu.adp.lib.e.b<ImageView> bJo;
    private com.baidu.adp.lib.e.b<TextView> bJp;
    private com.baidu.adp.lib.e.b<View> bJq;
    private com.baidu.adp.lib.e.b<LinearLayout> bJr;
    private com.baidu.adp.lib.e.b<RelativeLayout> bJs;
    private com.baidu.adp.lib.e.b<GifView> bJt;
    private boolean bJu;
    private TextUtils.TruncateAt bJv;
    private j bJw;
    private h bJx;
    private com.baidu.tieba.pb.a.c bJy;
    private i bJz;
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
        void RI();
    }

    /* loaded from: classes.dex */
    public interface f {
        void B(MotionEvent motionEvent);
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
        this.bJM = z;
        RE();
    }

    public void setIsHost(boolean z) {
        this.isHost = z;
    }

    public boolean RD() {
        return this.bJG;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
        if (this.bJn != null) {
            this.bJn.mIsFromCDN = z;
        }
    }

    public void setMaxWidth(int i2) {
        this.mMaxWidth = i2;
    }

    public void setMaxLines(int i2) {
        this.bJK = i2;
    }

    public void setTextEllipsize(TextUtils.TruncateAt truncateAt) {
        this.bJv = truncateAt;
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
    public boolean bm(View view) {
        if (view instanceof ImageView) {
            if (view instanceof GifView) {
                return view.getTag() != null && (view.getTag() instanceof b) && ((b) view.getTag()).bJX;
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

    public static com.baidu.adp.lib.e.b<TextView> x(final Context context, int i2) {
        return new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<TextView>() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: RH */
            public TextView nk() {
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
        this.bJn = new com.baidu.tbadk.widget.richText.a();
        this.bJo = null;
        this.bJp = null;
        this.bJq = null;
        this.bJr = null;
        this.bJs = null;
        this.bJt = null;
        this.bJu = true;
        this.bJv = null;
        this.bJw = null;
        this.bJx = null;
        this.bJy = null;
        this.bJz = null;
        this.bJA = null;
        this.bJB = true;
        this.mIsFromCDN = true;
        this.bJC = -1;
        this.bJD = false;
        this.bJE = false;
        this.bJF = null;
        this.bJG = false;
        this.bJJ = false;
        this.mMaxWidth = -1;
        this.bJK = -1;
        this.bJL = true;
        this.bJM = false;
        this.isHost = false;
        this.bJN = false;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                String str;
                int i2 = 0;
                if (TbRichTextView.this.bJx != null && (view instanceof ImageView)) {
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
                        TbRichTextView.this.bJx.a(view, null, i3, TbRichTextView.this.isHost);
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
                        TbRichTextView.this.bJx.a(view, str, i4, TbRichTextView.this.isHost);
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
                        if (TbRichTextView.this.bm(childAt)) {
                            i5++;
                        }
                        if (view == childAt) {
                            break;
                        }
                        i2++;
                    }
                    TbRichTextView.this.bJx.a(view, url, i5, TbRichTextView.this.isHost);
                }
            }
        };
        this.mInternalGestureDetector = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.4
            @Override // com.baidu.tieba.pb.a.c.a
            public boolean c(View view, MotionEvent motionEvent) {
                if (TbRichTextView.this.bJy != null) {
                    TbRichTextView.this.bJy.cm(view);
                    return TbRichTextView.this.bJy.onDoubleTap(motionEvent);
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
        this.bJP = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                if (TbRichTextView.this.bJz != null && (view instanceof TbImageView)) {
                    Object tag = view.getTag();
                    if (tag == null || !(tag instanceof d)) {
                        str = null;
                    } else {
                        str = ((d) tag).url;
                    }
                    TbRichTextView.this.bJz.b(view, str);
                }
            }
        };
        this.bJQ = new f() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.11
            @Override // com.baidu.tbadk.widget.richText.TbRichTextView.f
            public void B(MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    TbRichTextView.this.bJN = true;
                } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                    TbRichTextView.this.bJN = false;
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
        this.bJT = new CustomMessageListener(CmdConfigCustom.PB_RICHTEXT_CHANGE_CMD) { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int contentSizeOfLzl = TbRichTextView.this.bJM ? TbConfig.getContentSizeOfLzl() : TbConfig.getContentSize();
                if (TbRichTextView.this.bJI != null && !v.G(TbRichTextView.this.bJI.QN())) {
                    Iterator<TbRichTextData> it = TbRichTextView.this.bJI.QN().iterator();
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
        this.bJn = new com.baidu.tbadk.widget.richText.a();
        this.bJo = null;
        this.bJp = null;
        this.bJq = null;
        this.bJr = null;
        this.bJs = null;
        this.bJt = null;
        this.bJu = true;
        this.bJv = null;
        this.bJw = null;
        this.bJx = null;
        this.bJy = null;
        this.bJz = null;
        this.bJA = null;
        this.bJB = true;
        this.mIsFromCDN = true;
        this.bJC = -1;
        this.bJD = false;
        this.bJE = false;
        this.bJF = null;
        this.bJG = false;
        this.bJJ = false;
        this.mMaxWidth = -1;
        this.bJK = -1;
        this.bJL = true;
        this.bJM = false;
        this.isHost = false;
        this.bJN = false;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                String str;
                int i2 = 0;
                if (TbRichTextView.this.bJx != null && (view instanceof ImageView)) {
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
                        TbRichTextView.this.bJx.a(view, null, i3, TbRichTextView.this.isHost);
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
                        TbRichTextView.this.bJx.a(view, str, i4, TbRichTextView.this.isHost);
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
                        if (TbRichTextView.this.bm(childAt)) {
                            i5++;
                        }
                        if (view == childAt) {
                            break;
                        }
                        i2++;
                    }
                    TbRichTextView.this.bJx.a(view, url, i5, TbRichTextView.this.isHost);
                }
            }
        };
        this.mInternalGestureDetector = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.4
            @Override // com.baidu.tieba.pb.a.c.a
            public boolean c(View view, MotionEvent motionEvent) {
                if (TbRichTextView.this.bJy != null) {
                    TbRichTextView.this.bJy.cm(view);
                    return TbRichTextView.this.bJy.onDoubleTap(motionEvent);
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
        this.bJP = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                if (TbRichTextView.this.bJz != null && (view instanceof TbImageView)) {
                    Object tag = view.getTag();
                    if (tag == null || !(tag instanceof d)) {
                        str = null;
                    } else {
                        str = ((d) tag).url;
                    }
                    TbRichTextView.this.bJz.b(view, str);
                }
            }
        };
        this.bJQ = new f() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.11
            @Override // com.baidu.tbadk.widget.richText.TbRichTextView.f
            public void B(MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    TbRichTextView.this.bJN = true;
                } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                    TbRichTextView.this.bJN = false;
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
        this.bJT = new CustomMessageListener(CmdConfigCustom.PB_RICHTEXT_CHANGE_CMD) { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int contentSizeOfLzl = TbRichTextView.this.bJM ? TbConfig.getContentSizeOfLzl() : TbConfig.getContentSize();
                if (TbRichTextView.this.bJI != null && !v.G(TbRichTextView.this.bJI.QN())) {
                    Iterator<TbRichTextData> it = TbRichTextView.this.bJI.QN().iterator();
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
        this.bJn.b(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        RE();
    }

    public com.baidu.tbadk.widget.richText.a getLayoutStrategy() {
        return this.bJn;
    }

    public void setLayoutStrategy(com.baidu.tbadk.widget.richText.a aVar) {
        if (aVar != null) {
            this.bJn.release();
            this.bJn = aVar;
            RE();
        }
    }

    private void RE() {
        int contentSizeOfLzl = this.bJM ? TbConfig.getContentSizeOfLzl() : TbConfig.getContentSize();
        this.bJn.bIe = contentSizeOfLzl;
        this.bJn.bId = contentSizeOfLzl;
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
            ak.registerListener(this.bJT);
        }
        if (eVar != null) {
            this.bJo = eVar.Ru();
            this.bJp = eVar.Rv();
            this.bJq = eVar.Rx();
            this.bJr = eVar.Ry();
            this.bJt = eVar.Rw();
            this.bJs = eVar.Rz();
            if (eVar.getListView() != null && this.bJw == null) {
                this.bJw = new j(eVar.Rt());
                eVar.getListView().setRecyclerListener(this.bJw);
            }
        }
        setOrientation(1);
        setOnHierarchyChangeListener(new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.7
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof GifView) && TbRichTextView.this.bJt != null) {
                    TbRichTextView.this.bJt.ar((GifView) view2);
                } else if ((view2 instanceof ImageView) && TbRichTextView.this.bJo != null) {
                    TbRichTextView.this.bJo.ar((ImageView) view2);
                } else if ((view2 instanceof TextView) && TbRichTextView.this.bJp != null) {
                    TbRichTextView.this.bJp.ar((TextView) view2);
                } else if ((view2 instanceof PlayVoiceBnt) && TbRichTextView.this.bJq != null) {
                    TbRichTextView.this.bJq.ar(view2);
                } else if ((view2 instanceof PlayVoiceBntNew) && TbRichTextView.this.bJq != null) {
                    TbRichTextView.this.bJq.ar(view2);
                } else if ((view2 instanceof RelativeLayout) && TbRichTextView.this.bJs != null) {
                    TbRichTextView.this.bJs.ar((RelativeLayout) view2);
                }
                if (view2 instanceof LinearLayout) {
                    Object tag = view2.getTag();
                    if (tag == null || !(tag instanceof String) || !"VideoView".equals(tag)) {
                        if (TbRichTextView.this.bJr != null) {
                            int childCount = ((LinearLayout) view2).getChildCount();
                            for (int i2 = 0; i2 < childCount; i2++) {
                                View childAt = ((LinearLayout) view2).getChildAt(i2);
                                if (childAt != null) {
                                    if ((childAt instanceof TextView) && TbRichTextView.this.bJp != null) {
                                        TbRichTextView.this.bJp.ar((TextView) childAt);
                                    } else if ((childAt instanceof PlayVoiceBnt) && TbRichTextView.this.bJq != null) {
                                        TbRichTextView.this.bJq.ar(childAt);
                                    } else if ((childAt instanceof PlayVoiceBntNew) && TbRichTextView.this.bJq != null) {
                                        TbRichTextView.this.bJq.ar(childAt);
                                    }
                                }
                            }
                            ((LinearLayout) view2).removeAllViews();
                            TbRichTextView.this.bJr.ar((LinearLayout) view2);
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
        ArrayList<TbRichTextData> QN;
        int i2;
        RelativeLayout relativeLayout;
        int i3;
        SpannableStringBuilder QU;
        boolean z2;
        View view;
        KeyEvent.Callback a2;
        boolean z3;
        int i4;
        int i5;
        if (this.bJI != tbRichText || (tbRichText != null && tbRichText.isChanged)) {
            if (tbRichText != null) {
                tbRichText.isChanged = false;
            }
            this.bJI = tbRichText;
            removeAllViews();
            if (tbRichText != null && (QN = tbRichText.QN()) != null) {
                View view2 = null;
                boolean z4 = true;
                Iterator<TbRichTextData> it = QN.iterator();
                int i6 = 0;
                View view3 = null;
                int i7 = 0;
                while (it.hasNext()) {
                    TbRichTextData next = it.next();
                    boolean z5 = false;
                    if (next != null) {
                        if (next.getType() == 1) {
                            TextView bp = bp(getContext());
                            boolean a3 = a(next, bp, true, cVar);
                            if (z && !this.bJG && (QU = next.QU()) != null) {
                                this.bJG = QU.length() >= 200;
                            }
                            if (this.bJy != null) {
                                bp.setOnTouchListener(this.mInternalGestureDetector);
                            } else {
                                bp.setOnClickListener(this.bJA);
                            }
                            z5 = a3;
                            i2 = i6;
                            int i8 = i7;
                            relativeLayout = bp;
                            i3 = i8;
                        } else if (next.getType() == 8) {
                            if (i6 < 10) {
                                i6++;
                                if (next.QT() != null) {
                                    if (TbadkCoreApplication.getInst().isGifAutoPlay() && !next.QT().Rm()) {
                                        GifView gifView = getGifView();
                                        b bVar = new b();
                                        bVar.bJX = true;
                                        gifView.setTag(bVar);
                                        z5 = b(next, gifView);
                                        i3 = i7;
                                        i2 = i6;
                                        relativeLayout = gifView;
                                    } else {
                                        ?? bo = bo(getContext());
                                        z5 = c(next, bo, this.bJn.bIf, this.bJn.bIg);
                                        i3 = i7;
                                        i2 = i6;
                                        relativeLayout = bo;
                                    }
                                }
                                i3 = i7;
                                i2 = i6;
                                relativeLayout = view3;
                            }
                        } else if (next.getType() == 32) {
                            com.baidu.tbadk.widget.richText.f QX = next.QX();
                            if (QX != null && QX.RB()) {
                                a2 = b(QX);
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
                                if (next == null || next.QZ() == null || next.QZ().memeInfo == null || StringUtils.isNull(next.QZ().memeInfo.pic_url)) {
                                    z3 = false;
                                } else {
                                    z3 = true;
                                }
                                if (z3) {
                                    RelativeLayout nj = this.bJs.nj();
                                    nj.removeAllViews();
                                    nj.setLayoutParams(new LinearLayout.LayoutParams(next.QZ().memeInfo.width.intValue(), next.QZ().memeInfo.height.intValue()));
                                    if (p.Ot() && this.bJu) {
                                        b(nj, next.QZ().memeInfo.width.intValue(), next.QZ().memeInfo.height.intValue(), this.bJn.bIf, this.bJn.bIg);
                                    } else {
                                        a(nj, next.QZ().memeInfo.width.intValue(), next.QZ().memeInfo.height.intValue(), this.bJn.bIf, this.bJn.bIg);
                                    }
                                    ImageView nj2 = this.bJo.nj();
                                    b(next, nj2, this.bJn.bIf, this.bJn.bIg);
                                    if (p.Ot() && this.bJu) {
                                        ImageView nj3 = this.bJo.nj();
                                        nj3.setTag(this.bJI);
                                        if (nj3 instanceof TbImageView) {
                                            ((TbImageView) nj3).setAdjustViewBounds(false);
                                        }
                                        nj3.setScaleType(ImageView.ScaleType.FIT_XY);
                                        int s = l.s(getContext(), d.e.ds78);
                                        int s2 = l.s(getContext(), d.e.ds78);
                                        nj2.setId(d.g.meme_image_view);
                                        c(nj2, next.QZ().memeInfo.width.intValue(), next.QZ().memeInfo.height.intValue(), this.bJn.bIf, this.bJn.bIg, this.mOnClickListener);
                                        nj.addView(nj2);
                                        if (s2 > next.QZ().memeInfo.height.intValue()) {
                                            i5 = s / 2;
                                            i4 = s2 / 2;
                                        } else {
                                            i4 = s2;
                                            i5 = s;
                                        }
                                        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i5, i4);
                                        layoutParams.addRule(8, d.g.meme_image_view);
                                        layoutParams.addRule(11);
                                        nj3.setOnClickListener(this.mOnClickListener);
                                        if (nj.getLeft() > 0) {
                                            layoutParams.rightMargin = l.s(getContext(), d.e.ds6);
                                        }
                                        aj.c(nj3, d.f.icon_emotion_dui_n);
                                        nj.addView(nj3, layoutParams);
                                    } else {
                                        b(nj2, next.QZ().memeInfo.width.intValue(), next.QZ().memeInfo.height.intValue(), this.bJn.bIf, this.bJn.bIg, this.mOnClickListener);
                                        nj.addView(nj2);
                                    }
                                    z5 = z3;
                                    i3 = i9;
                                    i2 = i6;
                                    relativeLayout = nj;
                                } else {
                                    z5 = z3;
                                    i3 = i9;
                                    i2 = i6;
                                    relativeLayout = view3;
                                }
                            }
                        } else {
                            if (next.getType() == 1280) {
                                ImageView bo2 = bo(getContext());
                                z5 = a(next, bo2, (this.bJn.bIf - getPaddingLeft()) - getPaddingRight(), this.bJn.bIg);
                                i3 = i7;
                                i2 = i6 + 1;
                                relativeLayout = bo2;
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
                            if (z4 && this.bJn.bIu >= 0) {
                                z4 = false;
                                if (layoutParams2 != null) {
                                    layoutParams2.topMargin = this.bJn.bIu;
                                    relativeLayout.setLayoutParams(layoutParams2);
                                    z2 = false;
                                    view = relativeLayout;
                                }
                                z2 = z4;
                                view = relativeLayout;
                            } else if (relativeLayout instanceof TbListTextView) {
                                if ((view2 instanceof ImageView) || (view2 instanceof RelativeLayout)) {
                                    layoutParams2.topMargin = this.bJn.bIq;
                                } else {
                                    layoutParams2.topMargin = this.bJn.bIb;
                                }
                                relativeLayout.setLayoutParams(layoutParams2);
                                z2 = z4;
                                view = relativeLayout;
                            } else {
                                if (((relativeLayout instanceof ImageView) || (relativeLayout instanceof RelativeLayout)) && (next.getType() == 8 || next.getType() == 20 || next.getType() == 17)) {
                                    if (view2 instanceof TbListTextView) {
                                        layoutParams2.topMargin = this.bJn.bIp;
                                    } else if ((view2 instanceof ImageView) || (relativeLayout instanceof RelativeLayout)) {
                                        layoutParams2.topMargin = this.bJn.bIo;
                                    } else {
                                        layoutParams2.topMargin = this.bJn.bIb;
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
                    layoutParams3.bottomMargin = this.bJn.bIt;
                    view2.setLayoutParams(layoutParams3);
                } else if (view2 != null && this.bJn.bIs >= 0) {
                    LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) view2.getLayoutParams();
                    layoutParams4.bottomMargin = this.bJn.bIs;
                    view2.setLayoutParams(layoutParams4);
                }
            }
        }
    }

    public void setCommonTextViewOnClickListener(View.OnClickListener onClickListener) {
        this.bJA = onClickListener;
    }

    private View b(final com.baidu.tbadk.widget.richText.f fVar) {
        if (fVar == null || !fVar.isAvaliable()) {
            return null;
        }
        ImageView nj = this.bJo.nj();
        if (nj instanceof ForeDrawableImageView) {
            ForeDrawableImageView foreDrawableImageView = (ForeDrawableImageView) nj;
            foreDrawableImageView.setForegroundDrawable(d.f.icon_play_video);
            foreDrawableImageView.setNoImageBottomTextColor(d.C0108d.cp_cont_c);
            foreDrawableImageView.setNoImageBottomTextPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds32));
            foreDrawableImageView.setNoImageBottomTextSize(TbadkCoreApplication.getInst().getResources().getDimension(d.e.fontsize28));
            foreDrawableImageView.setNoImageBottomText("点击播放视频");
            foreDrawableImageView.setInterceptOnClick(false);
            foreDrawableImageView.setTag("VideoView");
            b(foreDrawableImageView, fVar.getWidth(), fVar.getHeight(), (this.bJn.bIf - getPaddingLeft()) - getPaddingRight(), this.bJn.bIg, new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log("c10643");
                    XiaoyingUtil.startPlayXiaoyingVideo(TbRichTextView.this.getContext(), fVar.getVideoUrl(), fVar.getWidth(), fVar.getHeight(), fVar.getThumbUrl());
                }
            });
            foreDrawableImageView.setDefaultResource(0);
            foreDrawableImageView.setSupportNoImage(this.bJn.bIm);
            if (com.baidu.tbadk.core.i.wB().wH()) {
                foreDrawableImageView.setDefaultBgResource(d.f.pic_bg_video_frs);
            } else {
                foreDrawableImageView.setDefaultBgResource(d.C0108d.cp_bg_line_c);
            }
            foreDrawableImageView.startLoad(fVar.getThumbUrl(), 17, false);
            return nj;
        }
        return nj;
    }

    private boolean a(ImageView imageView, int i2, int i3, int i4, int i5, View.OnClickListener onClickListener) {
        int[] t = this.bJn.t(i2, i3, i4, i5);
        if (t == null) {
            return false;
        }
        int i6 = t[0];
        int i7 = t[1];
        if (imageView instanceof TbImageView) {
            TbImageView tbImageView = (TbImageView) imageView;
            tbImageView.setDefaultResource(this.bJn.bIh);
            if (tbImageView.getGifIconWidth() >= i6 || tbImageView.getGifIconHeight() >= i7) {
                tbImageView.setGifIconSupport(false);
            } else {
                tbImageView.setGifIconSupport(true);
            }
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i6, i7);
        if (this.bJn.bIn) {
            imageView.setScaleType(this.bJn.bIl);
            if (imageView instanceof TbImageView) {
                ((TbImageView) imageView).setOnDrawListener(this.bJn.mOnDrawListener);
            }
        } else {
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        }
        imageView.setClickable(true);
        imageView.setFocusable(false);
        if (this.bJy != null && (imageView instanceof TbImageView)) {
            ((TbImageView) imageView).setTbGestureDetector(this.mInternalGestureDetector);
            imageView.setClickable(true);
        } else {
            imageView.setOnClickListener(onClickListener);
        }
        imageView.setLayoutParams(layoutParams);
        if (imageView instanceof TbImageView) {
            if (this.onLongClickListener != null) {
                ((TbImageView) imageView).setDispatchTouchListener(this.bJQ);
                imageView.setOnLongClickListener(this.onLongClickListener);
            }
        } else if ((imageView instanceof GifView) && this.onLongClickListener != null) {
            ((GifView) imageView).setDispatchTouchListener(this.bJQ);
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
        if (!this.bJn.bIn || i4 <= i7 || bHX <= 1.0f) {
            i4 = i7;
            i6 = i8;
        } else {
            if (i7 * bHX <= i4) {
                if (i7 * bHX > i4 * 0.68f) {
                    i4 = (int) (i4 * 0.68f);
                } else {
                    i4 = (int) (i7 * bHX);
                }
            }
            i6 = iArr[0] > 0 ? (iArr[1] * i4) / iArr[0] : i8;
        }
        if (imageView instanceof TbImageView) {
            TbImageView tbImageView = (TbImageView) imageView;
            tbImageView.setDefaultResource(this.bJn.bIh);
            if (tbImageView.getGifIconWidth() >= i4 || tbImageView.getGifIconHeight() >= i6) {
                tbImageView.setGifIconSupport(false);
            } else {
                tbImageView.setGifIconSupport(true);
            }
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i4, i6);
        if (this.bJn.bIn) {
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        } else {
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        }
        imageView.setClickable(true);
        imageView.setFocusable(false);
        if (this.bJy != null && (imageView instanceof TbImageView)) {
            ((TbImageView) imageView).setTbGestureDetector(this.mInternalGestureDetector);
            imageView.setClickable(true);
        } else {
            imageView.setOnClickListener(onClickListener);
        }
        imageView.setLayoutParams(layoutParams);
        if (imageView instanceof TbImageView) {
            if (this.onLongClickListener != null) {
                ((TbImageView) imageView).setDispatchTouchListener(this.bJQ);
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
        if (this.bJn.bIn && i4 > i8 && bHX > 1.0f) {
            if (i8 * bHX > i4) {
                i8 = (i4 - l.s(getContext(), d.e.ds78)) - l.s(getContext(), d.e.ds16);
            } else if (i8 * bHX > i4 * 0.68f) {
                i8 = ((int) (i4 * 0.68f)) - l.s(getContext(), d.e.ds78);
            } else {
                i8 = (int) (i8 * bHX);
            }
            if (iArr[0] > 0) {
                i6 = (iArr[1] * i8) / iArr[0];
                i7 = i8;
                if (imageView instanceof TbImageView) {
                    TbImageView tbImageView = (TbImageView) imageView;
                    tbImageView.setDefaultResource(this.bJn.bIh);
                    if (tbImageView.getGifIconWidth() >= i7 || tbImageView.getGifIconHeight() >= i6) {
                        tbImageView.setGifIconSupport(false);
                    } else {
                        tbImageView.setGifIconSupport(true);
                    }
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i7, i6);
                if (!this.bJn.bIn) {
                    imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                } else {
                    imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                }
                imageView.setClickable(true);
                imageView.setFocusable(false);
                if (this.bJy == null && (imageView instanceof TbImageView)) {
                    ((TbImageView) imageView).setTbGestureDetector(this.mInternalGestureDetector);
                    imageView.setClickable(true);
                } else {
                    imageView.setOnClickListener(onClickListener);
                }
                imageView.setLayoutParams(layoutParams);
                if (!(imageView instanceof TbImageView)) {
                    if (this.onLongClickListener != null) {
                        ((TbImageView) imageView).setDispatchTouchListener(this.bJQ);
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
        if (!this.bJn.bIn) {
        }
        imageView.setClickable(true);
        imageView.setFocusable(false);
        if (this.bJy == null) {
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
            if (!this.bJn.bIn || i4 <= i6 || bHX <= 1.0f) {
                i4 = i6;
            } else {
                if (i6 * bHX <= i4) {
                    if (i6 * bHX > i4 * 0.68f) {
                        i4 = (int) (i4 * 0.68f);
                    } else {
                        i4 = (int) (i6 * bHX);
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
            if (this.bJn.bIn && i4 > i8 && bHX > 1.0f) {
                if (i8 * bHX > i4) {
                    i7 = (i4 - l.s(getContext(), d.e.ds78)) - l.s(getContext(), d.e.ds16);
                } else if (i8 * bHX > i4 * 0.68f) {
                    i7 = ((int) (i4 * 0.68f)) - l.s(getContext(), d.e.ds78);
                } else {
                    i7 = (int) (i8 * bHX);
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
        if (this.bJn.bIi <= 0 || tbRichTextData == null) {
            return null;
        }
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setTag("VideoView");
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = this.bJn.bIb;
        linearLayout.setClickable(true);
        Bitmap fQ = aj.fQ(this.bJn.bIi);
        if (fQ != null) {
            linearLayout.setBackgroundDrawable(new BitmapDrawable(getContext().getResources(), fQ));
        }
        linearLayout.setFocusable(false);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (tbRichTextData.QU() != null) {
                    if (TbRichTextView.this.getContext() instanceof com.baidu.tbadk.widget.richText.e) {
                        ((com.baidu.tbadk.widget.richText.e) TbRichTextView.this.getContext()).Z(TbRichTextView.this.getContext(), tbRichTextData.QU().toString());
                        return;
                    }
                    com.baidu.adp.base.e<?> ak = com.baidu.adp.base.i.ak(TbRichTextView.this.getContext());
                    if (ak != null && (ak.getOrignalPage() instanceof com.baidu.tbadk.widget.richText.e)) {
                        ((com.baidu.tbadk.widget.richText.e) ak.getOrignalPage()).Z(TbRichTextView.this.getContext(), tbRichTextData.QU().toString());
                    }
                }
            }
        });
        return linearLayout;
    }

    private ImageView bo(Context context) {
        ImageView nj = this.bJo != null ? this.bJo.nj() : null;
        if (nj == null || nj.getParent() != null) {
            nj = null;
        }
        if (nj != null) {
            nj.setContentDescription(context.getString(d.j.editor_image));
        }
        return nj;
    }

    private boolean a(TbRichTextData tbRichTextData, ImageView imageView, int i2, int i3) {
        if (tbRichTextData == null || imageView == null) {
            return false;
        }
        TbRichTextLinkImageInfo Rb = tbRichTextData.Rb();
        if (Rb != null && Rb.getLink() != null) {
            if (imageView instanceof TbImageView) {
                TbImageView tbImageView = (TbImageView) imageView;
                if (this.bJn.bIm) {
                    tbImageView.setSupportNoImage(true);
                }
                tbImageView.startLoad(Rb.Rs(), this.mIsFromCDN ? 17 : 18, false);
                tbImageView.setTag(new d(Rb.getLink()));
                if (!Rb.Rj()) {
                    tbImageView.setAdjustViewBounds(false);
                }
            }
            return b(imageView, Rb.getWidth(), Rb.getHeight(), i2, i3, this.bJP);
        }
        return false;
    }

    private boolean b(TbRichTextData tbRichTextData, ImageView imageView, int i2, int i3) {
        if (tbRichTextData == null || imageView == null) {
            return false;
        }
        if (tbRichTextData.QZ() == null) {
            return false;
        }
        if (imageView instanceof TbImageView) {
            TbImageView tbImageView = (TbImageView) imageView;
            if (this.bJn.bIm) {
                tbImageView.setSupportNoImage(true);
            }
            tbImageView.startLoad(tbRichTextData.QZ().memeInfo.pic_url, this.mIsFromCDN ? 17 : 18, false);
            tbImageView.setAdjustViewBounds(false);
            tbImageView.setTag(d.g.tag_rich_text_meme_info, tbRichTextData.QZ());
        }
        return b(imageView, tbRichTextData.QZ().memeInfo.width.intValue(), tbRichTextData.QZ().memeInfo.height.intValue(), i2, i3, this.mOnClickListener);
    }

    private boolean c(TbRichTextData tbRichTextData, ImageView imageView, int i2, int i3) {
        if (tbRichTextData == null || imageView == null) {
            return false;
        }
        if (tbRichTextData.QT() == null) {
            return false;
        }
        if (imageView instanceof TbImageView) {
            TbImageView tbImageView = (TbImageView) imageView;
            if (this.bJn.bIm) {
                tbImageView.setSupportNoImage(true);
            }
            tbImageView.startLoad(tbRichTextData.QT().Rh(), this.mIsFromCDN ? 17 : 18, false);
            if (!tbRichTextData.QT().Rj()) {
                tbImageView.setAdjustViewBounds(false);
            }
            tbImageView.setTag(d.g.tag_rich_text_meme_info, null);
        }
        return a(imageView, tbRichTextData.QT().getWidth(), tbRichTextData.QT().getHeight(), i2, i3, this.mOnClickListener);
    }

    private TextView bp(Context context) {
        TextView textView = null;
        if (this.bJp != null) {
            textView = this.bJp.nj();
        }
        if (textView == null || textView.getParent() != null) {
            textView = new TbListTextView(context);
        }
        textView.setPadding(this.bJn.bIa, 0, this.bJn.bIa, 0);
        return textView;
    }

    private boolean a(TbRichTextData tbRichTextData, TextView textView, boolean z, c cVar) {
        LinearLayout.LayoutParams layoutParams;
        if (z) {
            layoutParams = new LinearLayout.LayoutParams(-1, -2);
        } else {
            layoutParams = new LinearLayout.LayoutParams(-2, -2);
        }
        if (this.bJJ) {
            layoutParams.gravity = 16;
            textView.setGravity(16);
        } else {
            layoutParams.topMargin = this.bJn.bIb;
        }
        textView.setLineSpacing(this.bJn.bHZ, this.bJn.bHY);
        textView.setTextSize(0, this.bJn.bIc);
        textView.setTextColor(this.bJn.mTextColor);
        textView.setLinkTextColor(aj.getColor(d.C0108d.cp_link_tip_c));
        textView.setHighlightColor(getContext().getResources().getColor(d.C0108d.transparent));
        textView.setSingleLine(this.bJn.bIj);
        if (this.bJv != null) {
            textView.setEllipsize(this.bJv);
        }
        if (this.mMaxWidth > 0) {
            textView.setMaxWidth(this.mMaxWidth);
        }
        if (this.bJK > 0) {
            textView.setMaxLines(this.bJK);
        }
        if (tbRichTextData == null) {
            return false;
        }
        SpannableStringBuilder QU = tbRichTextData.QU();
        if (QU == null || QU.length() <= 0) {
            return false;
        }
        if (this.bJn.bIe > 0 && this.bJn.bId > 0) {
            tbRichTextData.aT(this.bJn.bId, this.bJn.bIe);
        }
        if (cVar != null) {
            cVar.a(QU, textView, this);
        }
        try {
            textView.setText(QU);
        } catch (Exception e2) {
            textView.setText("");
        }
        if (this.bJL) {
            if (tbRichTextData.Rd()) {
                textView.setMovementMethod(com.baidu.tieba.view.e.bKu());
            } else {
                textView.setMovementMethod(LinkMovementMethod.getInstance());
            }
        }
        textView.setFocusable(false);
        textView.setLayoutParams(layoutParams);
        textView.setTag(tbRichTextData);
        if (tbRichTextData != null && tbRichTextData.QW() != null) {
            tbRichTextData.QW().needRecompute = this.bJR;
        }
        return true;
    }

    private GifView getGifView() {
        GifView gifView = null;
        if (this.bJt != null) {
            gifView = this.bJt.nj();
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
        if (layoutParams == null || layoutParams.width != tbRichTextData.QY().mGifInfo.mGifWidth || layoutParams.height != tbRichTextData.QY().mGifInfo.mGifHeight) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(tbRichTextData.QY().mGifInfo.mGifWidth, tbRichTextData.QY().mGifInfo.mGifHeight);
            layoutParams2.gravity = 3;
            gifView.setLayoutParams(layoutParams2);
        } else {
            layoutParams.bottomMargin = 0;
        }
        gifView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (TbRichTextView.this.bJH != null) {
                    TbRichTextEmotionInfo QY = tbRichTextData.QY();
                    TbRichTextView.this.bJH.a(view, QY.mGifInfo.mGid, QY.mGifInfo.mPackageName, QY.mGifInfo.mIcon, QY.mGifInfo.mStaticUrl, QY.mGifInfo.mDynamicUrl, QY.mGifInfo.mSharpText, QY.mGifInfo.mGifWidth, QY.mGifInfo.mGifHeight);
                }
            }
        });
        gifView.a(tbRichTextData.QY().mGifInfo);
        return true;
    }

    private boolean b(TbRichTextData tbRichTextData, GifView gifView) {
        if (gifView != null) {
            gifView.setDefaultNoImageDay(d.f.icon_click);
            gifView.setBackgroundDrawable(aj.getDrawable(d.C0108d.common_color_10220));
        }
        gifView.setShowStaticDrawable(false);
        gifView.E(tbRichTextData.QT().Ri(), 38);
        return a(gifView, tbRichTextData.QT().getWidth(), tbRichTextData.QT().getHeight(), this.bJn.bIf, this.bJn.bIg, this.mOnClickListener);
    }

    private View getVoiceView() {
        View nj = this.bJq != null ? this.bJq.nj() : null;
        if ((nj == null || nj.getParent() != null) && this.bJC != -1) {
            nj = LayoutInflater.from(getContext()).inflate(this.bJC, (ViewGroup) null);
        }
        if (nj != null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.topMargin = this.bJn.bIb;
            layoutParams.bottomMargin = this.bJn.bIr;
            nj.setLayoutParams(layoutParams);
            return nj;
        }
        return null;
    }

    private boolean a(TbRichTextData tbRichTextData, View view) {
        view.setTag(tbRichTextData.QV());
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LinearLayout.LayoutParams(-2, -2);
        }
        view.setLayoutParams(layoutParams);
        return true;
    }

    private View getTextVoiceView() {
        LinearLayout nj = this.bJr.nj();
        if (nj != null) {
            TextView bp = bp(getContext());
            if (bp == null) {
                this.bJr.ar(nj);
                return null;
            }
            nj.addView(bp);
            View voiceView = getVoiceView();
            if (voiceView == null) {
                this.bJp.ar(bp);
                this.bJr.ar(nj);
                return null;
            }
            nj.addView(voiceView);
            return nj;
        }
        return nj;
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
        if (f2 != this.bJn.bIc) {
            this.bJn.bIc = f2;
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
        if (i2 != this.bJn.mTextColor) {
            this.bJn.mTextColor = i2;
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
        if (this.bJn.bIa != i2) {
            this.bJn.bIa = i2;
            int childCount = getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                if (childAt != null && (childAt instanceof TextView)) {
                    ((TextView) childAt).setPadding(this.bJn.bIa, 0, 0, this.bJn.bIa);
                }
            }
        }
    }

    public void setLinkTextColor(int i2) {
        if (i2 != this.bJn.bIk) {
            this.bJn.bIk = i2;
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
        this.bJu = z;
    }

    public h getOnImageClickListener() {
        return this.bJx;
    }

    public void setOnImageClickListener(h hVar) {
        this.bJx = hVar;
    }

    public void setOnImageTouchListener(com.baidu.tieba.pb.a.c cVar) {
        this.bJy = cVar;
    }

    public void setOnEmotionClickListener(g gVar) {
        this.bJH = gVar;
    }

    public void o(boolean z, boolean z2) {
        if (this.bJB != z) {
            this.bJB = z;
            if (z2) {
                requestLayout();
            }
            if (!this.bJB && this.bJo != null) {
                this.bJo.clear();
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
        this.bJD = false;
        switch (motionEvent.getAction()) {
            case 1:
            case 3:
                if (!this.bJE) {
                    RG();
                    break;
                }
                break;
        }
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        switch (motionEvent.getAction()) {
            case 0:
                if (!this.bJD) {
                    RF();
                    break;
                }
                break;
        }
        return dispatchTouchEvent;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.bJD = true;
        return super.onTouchEvent(motionEvent);
    }

    private void RF() {
        this.bJE = false;
        if (this.bJF == null) {
            this.bJF = new a();
        }
        postDelayed(this.bJF, ViewConfiguration.getLongPressTimeout());
    }

    private void RG() {
        if (this.bJF != null) {
            removeCallbacks(this.bJF);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!TbRichTextView.this.bJN && TbRichTextView.this.performLongClick()) {
                TbRichTextView.this.bJE = true;
            }
        }
    }

    public void setVoiceViewRes(int i2) {
        this.bJC = i2;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.bJS != drawable) {
            this.bJR = true;
            this.bJS = drawable;
        }
        setText(this.bJI);
        this.bJR = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.bJn != null) {
            this.bJn.release();
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
        this.bJO = eVar;
        hj(str);
    }

    public void hj(String str) {
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
        com.baidu.adp.widget.a.a aVar = (com.baidu.adp.widget.a.a) com.baidu.adp.lib.f.c.nl().a(this.mUrl, 19, new Object[0]);
        if (aVar != null) {
            f(aVar);
        } else if (z) {
            invalidate();
        } else if (!com.baidu.adp.lib.f.c.nl().dh(19)) {
            invalidate();
        } else {
            com.baidu.adp.lib.f.c.nl().a(this.mUrl, 19, this.mCallback, 0, 0, this.mPageId, new Object[0]);
        }
    }

    public void stopLoad() {
        if (!TextUtils.isEmpty(this.mUrl)) {
            com.baidu.adp.lib.f.c.nl().a(this.mUrl, 19, this.mCallback);
            setBackgroundDrawable(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(com.baidu.adp.widget.a.a aVar) {
        if (aVar != null) {
            try {
                NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(getResources(), aVar.si(), aVar.si().getNinePatchChunk(), aVar.sm(), null);
                if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                    ninePatchDrawable.getPaint().setAlpha(80);
                }
                setBackgroundDrawable(ninePatchDrawable);
                if (this.bJO != null) {
                    this.bJO.RI();
                }
            } catch (Exception e2) {
            }
        }
    }

    @Override // com.baidu.adp.b.a.i
    public void refresh() {
        hj(this.mUrl);
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
        return this.bJz;
    }

    public void setOnLinkImageClickListener(i iVar) {
        this.bJz = iVar;
    }

    public void setHasMovementMethod(boolean z) {
        this.bJL = z;
    }

    public void setTextCenter(boolean z) {
        this.bJJ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        boolean bJX;

        private b() {
        }
    }
}
