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
import com.baidu.tbadk.p.r;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tbadk.widget.ForeDrawableImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.TbListTextView;
import com.baidu.tieba.e;
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
    private static final float bqm = l.aR(TbadkCoreApplication.getInst());
    private com.baidu.tbadk.widget.richText.a brC;
    private com.baidu.adp.lib.e.b<ImageView> brD;
    private com.baidu.adp.lib.e.b<TextView> brE;
    private com.baidu.adp.lib.e.b<View> brF;
    private com.baidu.adp.lib.e.b<LinearLayout> brG;
    private com.baidu.adp.lib.e.b<RelativeLayout> brH;
    private com.baidu.adp.lib.e.b<GifView> brI;
    private boolean brJ;
    private TextUtils.TruncateAt brK;
    private j brL;
    private h brM;
    private com.baidu.tieba.pb.a.c brN;
    private i brO;
    private View.OnClickListener brP;
    private boolean brQ;
    private int brR;
    private boolean brS;
    private Runnable brT;
    private boolean brU;
    private g brV;
    private TbRichText brW;
    private boolean brX;
    private boolean brY;
    private boolean brZ;
    private boolean bsa;
    private e bsb;
    public final View.OnClickListener bsc;
    private final f bsd;
    private boolean bse;
    private Drawable bsf;
    private CustomMessageListener bsg;
    private boolean isHost;
    private final com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a> mCallback;
    private boolean mHasPerformedLongPress;
    private final com.baidu.tieba.pb.a.c mInternalGestureDetector;
    private boolean mIsFromCDN;
    private int mMaxLines;
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
        void SU();
    }

    /* loaded from: classes.dex */
    public interface f {
        void z(MotionEvent motionEvent);
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
        void e(View view, String str);
    }

    public void setSubPbPost(boolean z) {
        this.brZ = z;
        SQ();
    }

    public void setIsHost(boolean z) {
        this.isHost = z;
    }

    public boolean SP() {
        return this.brU;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
        if (this.brC != null) {
            this.brC.mIsFromCDN = z;
        }
    }

    public void setMaxWidth(int i2) {
        this.mMaxWidth = i2;
    }

    public void setMaxLines(int i2) {
        this.mMaxLines = i2;
    }

    public void setTextEllipsize(TextUtils.TruncateAt truncateAt) {
        this.brK = truncateAt;
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
    public boolean ag(View view) {
        if (view instanceof ImageView) {
            if (view instanceof GifView) {
                return view.getTag() != null && (view.getTag() instanceof b) && ((b) view.getTag()).bsk;
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

    public static com.baidu.adp.lib.e.b<TextView> n(final Context context, int i2) {
        return new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<TextView>() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: ST */
            public TextView jz() {
                return new TbListTextView(context);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: b */
            public void u(TextView textView) {
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
            /* renamed from: c */
            public TextView v(TextView textView) {
                return textView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: d */
            public TextView w(TextView textView) {
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
        this.brC = new com.baidu.tbadk.widget.richText.a();
        this.brD = null;
        this.brE = null;
        this.brF = null;
        this.brG = null;
        this.brH = null;
        this.brI = null;
        this.brJ = true;
        this.brK = null;
        this.brL = null;
        this.brM = null;
        this.brN = null;
        this.brO = null;
        this.brP = null;
        this.brQ = true;
        this.mIsFromCDN = true;
        this.brR = -1;
        this.brS = false;
        this.mHasPerformedLongPress = false;
        this.brT = null;
        this.brU = false;
        this.brX = false;
        this.mMaxWidth = -1;
        this.mMaxLines = -1;
        this.brY = true;
        this.brZ = false;
        this.isHost = false;
        this.bsa = false;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                String str;
                int i2 = 0;
                if (TbRichTextView.this.brM != null && (view instanceof ImageView)) {
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
                        TbRichTextView.this.brM.a(view, null, i3, TbRichTextView.this.isHost);
                        return;
                    }
                    if (tag != null && (tag instanceof String)) {
                        url = (String) tag;
                    } else if ((view instanceof TbImageView) && (view.getTag(e.g.tag_rich_text_meme_info) instanceof TbRichTextMemeInfo)) {
                        TbRichTextMemeInfo tbRichTextMemeInfo = (TbRichTextMemeInfo) view.getTag(e.g.tag_rich_text_meme_info);
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
                        TbRichTextView.this.brM.a(view, str, i4, TbRichTextView.this.isHost);
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
                        if (TbRichTextView.this.ag(childAt)) {
                            i5++;
                        }
                        if (view == childAt) {
                            break;
                        }
                        i2++;
                    }
                    TbRichTextView.this.brM.a(view, url, i5, TbRichTextView.this.isHost);
                }
            }
        };
        this.mInternalGestureDetector = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.4
            @Override // com.baidu.tieba.pb.a.c.a
            public boolean a(View view, MotionEvent motionEvent) {
                if (TbRichTextView.this.brN != null) {
                    TbRichTextView.this.brN.bq(view);
                    return TbRichTextView.this.brN.onDoubleTap(motionEvent);
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
        this.bsc = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                if (TbRichTextView.this.brO != null && (view instanceof TbImageView)) {
                    Object tag = view.getTag();
                    if (tag == null || !(tag instanceof d)) {
                        str = null;
                    } else {
                        str = ((d) tag).url;
                    }
                    TbRichTextView.this.brO.e(view, str);
                }
            }
        };
        this.bsd = new f() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.11
            @Override // com.baidu.tbadk.widget.richText.TbRichTextView.f
            public void z(MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    TbRichTextView.this.bsa = true;
                } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                    TbRichTextView.this.bsa = false;
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
        this.bsg = new CustomMessageListener(2004018) { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int contentSizeOfLzl = TbRichTextView.this.brZ ? TbConfig.getContentSizeOfLzl() : TbConfig.getContentSize();
                if (TbRichTextView.this.brW != null && !v.I(TbRichTextView.this.brW.RZ())) {
                    Iterator<TbRichTextData> it = TbRichTextView.this.brW.RZ().iterator();
                    while (it.hasNext()) {
                        TbRichTextData next = it.next();
                        if (next != null) {
                            next.V(contentSizeOfLzl, contentSizeOfLzl);
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
        this.brC = new com.baidu.tbadk.widget.richText.a();
        this.brD = null;
        this.brE = null;
        this.brF = null;
        this.brG = null;
        this.brH = null;
        this.brI = null;
        this.brJ = true;
        this.brK = null;
        this.brL = null;
        this.brM = null;
        this.brN = null;
        this.brO = null;
        this.brP = null;
        this.brQ = true;
        this.mIsFromCDN = true;
        this.brR = -1;
        this.brS = false;
        this.mHasPerformedLongPress = false;
        this.brT = null;
        this.brU = false;
        this.brX = false;
        this.mMaxWidth = -1;
        this.mMaxLines = -1;
        this.brY = true;
        this.brZ = false;
        this.isHost = false;
        this.bsa = false;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                String str;
                int i2 = 0;
                if (TbRichTextView.this.brM != null && (view instanceof ImageView)) {
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
                        TbRichTextView.this.brM.a(view, null, i3, TbRichTextView.this.isHost);
                        return;
                    }
                    if (tag != null && (tag instanceof String)) {
                        url = (String) tag;
                    } else if ((view instanceof TbImageView) && (view.getTag(e.g.tag_rich_text_meme_info) instanceof TbRichTextMemeInfo)) {
                        TbRichTextMemeInfo tbRichTextMemeInfo = (TbRichTextMemeInfo) view.getTag(e.g.tag_rich_text_meme_info);
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
                        TbRichTextView.this.brM.a(view, str, i4, TbRichTextView.this.isHost);
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
                        if (TbRichTextView.this.ag(childAt)) {
                            i5++;
                        }
                        if (view == childAt) {
                            break;
                        }
                        i2++;
                    }
                    TbRichTextView.this.brM.a(view, url, i5, TbRichTextView.this.isHost);
                }
            }
        };
        this.mInternalGestureDetector = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.4
            @Override // com.baidu.tieba.pb.a.c.a
            public boolean a(View view, MotionEvent motionEvent) {
                if (TbRichTextView.this.brN != null) {
                    TbRichTextView.this.brN.bq(view);
                    return TbRichTextView.this.brN.onDoubleTap(motionEvent);
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
        this.bsc = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                if (TbRichTextView.this.brO != null && (view instanceof TbImageView)) {
                    Object tag = view.getTag();
                    if (tag == null || !(tag instanceof d)) {
                        str = null;
                    } else {
                        str = ((d) tag).url;
                    }
                    TbRichTextView.this.brO.e(view, str);
                }
            }
        };
        this.bsd = new f() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.11
            @Override // com.baidu.tbadk.widget.richText.TbRichTextView.f
            public void z(MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    TbRichTextView.this.bsa = true;
                } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                    TbRichTextView.this.bsa = false;
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
        this.bsg = new CustomMessageListener(2004018) { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int contentSizeOfLzl = TbRichTextView.this.brZ ? TbConfig.getContentSizeOfLzl() : TbConfig.getContentSize();
                if (TbRichTextView.this.brW != null && !v.I(TbRichTextView.this.brW.RZ())) {
                    Iterator<TbRichTextData> it = TbRichTextView.this.brW.RZ().iterator();
                    while (it.hasNext()) {
                        TbRichTextData next = it.next();
                        if (next != null) {
                            next.V(contentSizeOfLzl, contentSizeOfLzl);
                        }
                    }
                }
                TbRichTextView.this.setTextSize(contentSizeOfLzl);
            }
        };
        init();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e.l.TbRichTextView);
        this.brC.b(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        SQ();
    }

    public com.baidu.tbadk.widget.richText.a getLayoutStrategy() {
        return this.brC;
    }

    public void setLayoutStrategy(com.baidu.tbadk.widget.richText.a aVar) {
        if (aVar != null) {
            this.brC.release();
            this.brC = aVar;
            SQ();
        }
    }

    private void SQ() {
        int contentSizeOfLzl = this.brZ ? TbConfig.getContentSizeOfLzl() : TbConfig.getContentSize();
        this.brC.bqs = contentSizeOfLzl;
        this.brC.bqr = contentSizeOfLzl;
    }

    private void init() {
        com.baidu.tbadk.widget.richText.e eVar = null;
        com.baidu.adp.base.e<?> aK = com.baidu.adp.base.i.aK(getContext());
        if (getContext() instanceof com.baidu.tbadk.widget.richText.e) {
            eVar = (com.baidu.tbadk.widget.richText.e) getContext();
        } else if (aK != null && (aK.getOrignalPage() instanceof com.baidu.tbadk.widget.richText.e)) {
            eVar = (com.baidu.tbadk.widget.richText.e) aK.getOrignalPage();
        }
        if (aK != null) {
            aK.registerListener(this.bsg);
        }
        if (eVar != null) {
            this.brD = eVar.SH();
            this.brE = eVar.SI();
            this.brF = eVar.SK();
            this.brG = eVar.SL();
            this.brI = eVar.SJ();
            this.brH = eVar.SM();
            if (eVar.getListView() != null && this.brL == null) {
                this.brL = new j(eVar.SG());
                eVar.getListView().setRecyclerListener(this.brL);
            }
        }
        setOrientation(1);
        setOnHierarchyChangeListener(new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.7
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof GifView) && TbRichTextView.this.brI != null) {
                    TbRichTextView.this.brI.t((GifView) view2);
                } else if ((view2 instanceof ImageView) && TbRichTextView.this.brD != null) {
                    TbRichTextView.this.brD.t((ImageView) view2);
                } else if ((view2 instanceof TextView) && TbRichTextView.this.brE != null) {
                    TbRichTextView.this.brE.t((TextView) view2);
                } else if ((view2 instanceof PlayVoiceBnt) && TbRichTextView.this.brF != null) {
                    TbRichTextView.this.brF.t(view2);
                } else if ((view2 instanceof PlayVoiceBntNew) && TbRichTextView.this.brF != null) {
                    TbRichTextView.this.brF.t(view2);
                } else if ((view2 instanceof RelativeLayout) && TbRichTextView.this.brH != null) {
                    TbRichTextView.this.brH.t((RelativeLayout) view2);
                }
                if (view2 instanceof LinearLayout) {
                    Object tag = view2.getTag();
                    if (tag == null || !(tag instanceof String) || !"VideoView".equals(tag)) {
                        if (TbRichTextView.this.brG != null) {
                            int childCount = ((LinearLayout) view2).getChildCount();
                            for (int i2 = 0; i2 < childCount; i2++) {
                                View childAt = ((LinearLayout) view2).getChildAt(i2);
                                if (childAt != null) {
                                    if ((childAt instanceof TextView) && TbRichTextView.this.brE != null) {
                                        TbRichTextView.this.brE.t((TextView) childAt);
                                    } else if ((childAt instanceof PlayVoiceBnt) && TbRichTextView.this.brF != null) {
                                        TbRichTextView.this.brF.t(childAt);
                                    } else if ((childAt instanceof PlayVoiceBntNew) && TbRichTextView.this.brF != null) {
                                        TbRichTextView.this.brF.t(childAt);
                                    }
                                }
                            }
                            ((LinearLayout) view2).removeAllViews();
                            TbRichTextView.this.brG.t((LinearLayout) view2);
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
        ArrayList<TbRichTextData> RZ;
        int i2;
        RelativeLayout relativeLayout;
        int i3;
        SpannableStringBuilder Sg;
        boolean z2;
        View view;
        KeyEvent.Callback a2;
        boolean z3;
        int i4;
        int i5;
        if (this.brW != tbRichText || (tbRichText != null && tbRichText.isChanged)) {
            if (tbRichText != null) {
                tbRichText.isChanged = false;
            }
            this.brW = tbRichText;
            removeAllViews();
            if (tbRichText != null && (RZ = tbRichText.RZ()) != null) {
                View view2 = null;
                boolean z4 = true;
                Iterator<TbRichTextData> it = RZ.iterator();
                int i6 = 0;
                View view3 = null;
                int i7 = 0;
                while (it.hasNext()) {
                    TbRichTextData next = it.next();
                    boolean z5 = false;
                    if (next != null) {
                        if (next.getType() == 1) {
                            TextView bU = bU(getContext());
                            boolean a3 = a(next, bU, true, cVar);
                            if (z && !this.brU && (Sg = next.Sg()) != null) {
                                this.brU = Sg.length() >= 200;
                            }
                            if (this.brN != null) {
                                bU.setOnTouchListener(this.mInternalGestureDetector);
                            } else {
                                bU.setOnClickListener(this.brP);
                            }
                            z5 = a3;
                            i2 = i6;
                            int i8 = i7;
                            relativeLayout = bU;
                            i3 = i8;
                        } else if (next.getType() == 8) {
                            if (i6 < 10) {
                                i6++;
                                if (next.Sf() != null) {
                                    if (TbadkCoreApplication.getInst().isGifAutoPlay() && !next.Sf().Sz()) {
                                        GifView gifView = getGifView();
                                        b bVar = new b();
                                        bVar.bsk = true;
                                        gifView.setTag(bVar);
                                        z5 = b(next, gifView);
                                        i3 = i7;
                                        i2 = i6;
                                        relativeLayout = gifView;
                                    } else {
                                        ?? bT = bT(getContext());
                                        z5 = c(next, bT, this.brC.bqt, this.brC.bqu);
                                        i3 = i7;
                                        i2 = i6;
                                        relativeLayout = bT;
                                    }
                                }
                                i3 = i7;
                                i2 = i6;
                                relativeLayout = view3;
                            }
                        } else if (next.getType() == 32) {
                            com.baidu.tbadk.widget.richText.f Sj = next.Sj();
                            if (Sj != null && Sj.SO()) {
                                a2 = b(Sj);
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
                                if (next == null || next.Sl() == null || next.Sl().memeInfo == null || StringUtils.isNull(next.Sl().memeInfo.pic_url)) {
                                    z3 = false;
                                } else {
                                    z3 = true;
                                }
                                if (z3) {
                                    RelativeLayout jy = this.brH.jy();
                                    jy.removeAllViews();
                                    jy.setLayoutParams(new LinearLayout.LayoutParams(next.Sl().memeInfo.width.intValue(), next.Sl().memeInfo.height.intValue()));
                                    if (r.PB() && this.brJ) {
                                        b(jy, next.Sl().memeInfo.width.intValue(), next.Sl().memeInfo.height.intValue(), this.brC.bqt, this.brC.bqu);
                                    } else {
                                        a(jy, next.Sl().memeInfo.width.intValue(), next.Sl().memeInfo.height.intValue(), this.brC.bqt, this.brC.bqu);
                                    }
                                    ImageView jy2 = this.brD.jy();
                                    b(next, jy2, this.brC.bqt, this.brC.bqu);
                                    if (r.PB() && this.brJ) {
                                        ImageView jy3 = this.brD.jy();
                                        jy3.setTag(this.brW);
                                        if (jy3 instanceof TbImageView) {
                                            ((TbImageView) jy3).setAdjustViewBounds(false);
                                        }
                                        jy3.setScaleType(ImageView.ScaleType.FIT_XY);
                                        int h2 = l.h(getContext(), e.C0210e.ds78);
                                        int h3 = l.h(getContext(), e.C0210e.ds78);
                                        jy2.setId(e.g.meme_image_view);
                                        c(jy2, next.Sl().memeInfo.width.intValue(), next.Sl().memeInfo.height.intValue(), this.brC.bqt, this.brC.bqu, this.mOnClickListener);
                                        jy.addView(jy2);
                                        if (h3 > next.Sl().memeInfo.height.intValue()) {
                                            i5 = h2 / 2;
                                            i4 = h3 / 2;
                                        } else {
                                            i4 = h3;
                                            i5 = h2;
                                        }
                                        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i5, i4);
                                        layoutParams.addRule(8, e.g.meme_image_view);
                                        layoutParams.addRule(11);
                                        jy3.setOnClickListener(this.mOnClickListener);
                                        if (jy.getLeft() > 0) {
                                            layoutParams.rightMargin = l.h(getContext(), e.C0210e.ds6);
                                        }
                                        al.c(jy3, e.f.icon_emotion_dui_n);
                                        jy.addView(jy3, layoutParams);
                                    } else {
                                        b(jy2, next.Sl().memeInfo.width.intValue(), next.Sl().memeInfo.height.intValue(), this.brC.bqt, this.brC.bqu, this.mOnClickListener);
                                        jy.addView(jy2);
                                    }
                                    z5 = z3;
                                    i3 = i9;
                                    i2 = i6;
                                    relativeLayout = jy;
                                } else {
                                    z5 = z3;
                                    i3 = i9;
                                    i2 = i6;
                                    relativeLayout = view3;
                                }
                            }
                        } else {
                            if (next.getType() == 1280) {
                                ImageView bT2 = bT(getContext());
                                z5 = a(next, bT2, (this.brC.bqt - getPaddingLeft()) - getPaddingRight(), this.brC.bqu);
                                i3 = i7;
                                i2 = i6 + 1;
                                relativeLayout = bT2;
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
                            if (z4 && this.brC.bqI >= 0) {
                                z4 = false;
                                if (layoutParams2 != null) {
                                    layoutParams2.topMargin = this.brC.bqI;
                                    relativeLayout.setLayoutParams(layoutParams2);
                                    z2 = false;
                                    view = relativeLayout;
                                }
                                z2 = z4;
                                view = relativeLayout;
                            } else if (relativeLayout instanceof TbListTextView) {
                                if ((view2 instanceof ImageView) || (view2 instanceof RelativeLayout)) {
                                    layoutParams2.topMargin = this.brC.bqE;
                                } else {
                                    layoutParams2.topMargin = this.brC.bqp;
                                }
                                relativeLayout.setLayoutParams(layoutParams2);
                                z2 = z4;
                                view = relativeLayout;
                            } else {
                                if (((relativeLayout instanceof ImageView) || (relativeLayout instanceof RelativeLayout)) && (next.getType() == 8 || next.getType() == 20 || next.getType() == 17)) {
                                    if (view2 instanceof TbListTextView) {
                                        layoutParams2.topMargin = this.brC.bqD;
                                    } else if ((view2 instanceof ImageView) || (relativeLayout instanceof RelativeLayout)) {
                                        layoutParams2.topMargin = this.brC.bqC;
                                    } else {
                                        layoutParams2.topMargin = this.brC.bqp;
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
                    layoutParams3.bottomMargin = this.brC.bqH;
                    view2.setLayoutParams(layoutParams3);
                } else if (view2 != null && this.brC.bqG >= 0) {
                    LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) view2.getLayoutParams();
                    layoutParams4.bottomMargin = this.brC.bqG;
                    view2.setLayoutParams(layoutParams4);
                }
            }
        }
    }

    public void setCommonTextViewOnClickListener(View.OnClickListener onClickListener) {
        this.brP = onClickListener;
    }

    private View b(final com.baidu.tbadk.widget.richText.f fVar) {
        if (fVar == null || !fVar.isAvaliable()) {
            return null;
        }
        ImageView jy = this.brD.jy();
        if (jy instanceof ForeDrawableImageView) {
            ForeDrawableImageView foreDrawableImageView = (ForeDrawableImageView) jy;
            foreDrawableImageView.setForegroundDrawable(e.f.icon_play_video);
            foreDrawableImageView.setNoImageBottomTextColor(e.d.cp_cont_c);
            foreDrawableImageView.setNoImageBottomTextPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0210e.ds32));
            foreDrawableImageView.setNoImageBottomTextSize(TbadkCoreApplication.getInst().getResources().getDimension(e.C0210e.fontsize28));
            foreDrawableImageView.setNoImageBottomText("点击播放视频");
            foreDrawableImageView.setInterceptOnClick(false);
            foreDrawableImageView.setTag("VideoView");
            b(foreDrawableImageView, fVar.getWidth(), fVar.getHeight(), (this.brC.bqt - getPaddingLeft()) - getPaddingRight(), this.brC.bqu, new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log("c10643");
                    XiaoyingUtil.startPlayXiaoyingVideo(TbRichTextView.this.getContext(), fVar.getVideoUrl(), fVar.getWidth(), fVar.getHeight(), fVar.getThumbUrl());
                }
            });
            foreDrawableImageView.setDefaultResource(0);
            foreDrawableImageView.setSupportNoImage(this.brC.bqA);
            if (com.baidu.tbadk.core.i.xE().xI()) {
                foreDrawableImageView.setDefaultBgResource(e.f.pic_bg_video_frs);
            } else {
                foreDrawableImageView.setDefaultBgResource(e.d.cp_bg_line_c);
            }
            foreDrawableImageView.startLoad(fVar.getThumbUrl(), 17, false);
            return jy;
        }
        return jy;
    }

    private boolean a(ImageView imageView, int i2, int i3, int i4, int i5, View.OnClickListener onClickListener) {
        int[] k = this.brC.k(i2, i3, i4, i5);
        if (k == null) {
            return false;
        }
        int i6 = k[0];
        int i7 = k[1];
        if (imageView instanceof TbImageView) {
            TbImageView tbImageView = (TbImageView) imageView;
            tbImageView.setDefaultResource(this.brC.bqv);
            if (tbImageView.getGifIconWidth() >= i6 || tbImageView.getGifIconHeight() >= i7) {
                tbImageView.setGifIconSupport(false);
            } else {
                tbImageView.setGifIconSupport(true);
            }
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i6, i7);
        if (this.brC.bqB) {
            imageView.setScaleType(this.brC.bqz);
            if (imageView instanceof TbImageView) {
                ((TbImageView) imageView).setOnDrawListener(this.brC.mOnDrawListener);
            }
        } else {
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        }
        imageView.setClickable(true);
        imageView.setFocusable(false);
        if (this.brN != null && (imageView instanceof TbImageView)) {
            ((TbImageView) imageView).setTbGestureDetector(this.mInternalGestureDetector);
            imageView.setClickable(true);
        } else {
            imageView.setOnClickListener(onClickListener);
        }
        imageView.setLayoutParams(layoutParams);
        if (imageView instanceof TbImageView) {
            if (this.onLongClickListener != null) {
                ((TbImageView) imageView).setDispatchTouchListener(this.bsd);
                imageView.setOnLongClickListener(this.onLongClickListener);
            }
        } else if ((imageView instanceof GifView) && this.onLongClickListener != null) {
            ((GifView) imageView).setDispatchTouchListener(this.bsd);
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
        if (!this.brC.bqB || i4 <= i7 || bqm <= 1.0f) {
            i4 = i7;
            i6 = i8;
        } else {
            if (i7 * bqm <= i4) {
                if (i7 * bqm > i4 * 0.68f) {
                    i4 = (int) (i4 * 0.68f);
                } else {
                    i4 = (int) (i7 * bqm);
                }
            }
            i6 = iArr[0] > 0 ? (iArr[1] * i4) / iArr[0] : i8;
        }
        if (imageView instanceof TbImageView) {
            TbImageView tbImageView = (TbImageView) imageView;
            tbImageView.setDefaultResource(this.brC.bqv);
            if (tbImageView.getGifIconWidth() >= i4 || tbImageView.getGifIconHeight() >= i6) {
                tbImageView.setGifIconSupport(false);
            } else {
                tbImageView.setGifIconSupport(true);
            }
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i4, i6);
        if (this.brC.bqB) {
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        } else {
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        }
        imageView.setClickable(true);
        imageView.setFocusable(false);
        if (this.brN != null && (imageView instanceof TbImageView)) {
            ((TbImageView) imageView).setTbGestureDetector(this.mInternalGestureDetector);
            imageView.setClickable(true);
        } else {
            imageView.setOnClickListener(onClickListener);
        }
        imageView.setLayoutParams(layoutParams);
        if (imageView instanceof TbImageView) {
            if (this.onLongClickListener != null) {
                ((TbImageView) imageView).setDispatchTouchListener(this.bsd);
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
        if (this.brC.bqB && i4 > i8 && bqm > 1.0f) {
            if (i8 * bqm > i4) {
                i8 = (i4 - l.h(getContext(), e.C0210e.ds78)) - l.h(getContext(), e.C0210e.ds16);
            } else if (i8 * bqm > i4 * 0.68f) {
                i8 = ((int) (i4 * 0.68f)) - l.h(getContext(), e.C0210e.ds78);
            } else {
                i8 = (int) (i8 * bqm);
            }
            if (iArr[0] > 0) {
                i6 = (iArr[1] * i8) / iArr[0];
                i7 = i8;
                if (imageView instanceof TbImageView) {
                    TbImageView tbImageView = (TbImageView) imageView;
                    tbImageView.setDefaultResource(this.brC.bqv);
                    if (tbImageView.getGifIconWidth() >= i7 || tbImageView.getGifIconHeight() >= i6) {
                        tbImageView.setGifIconSupport(false);
                    } else {
                        tbImageView.setGifIconSupport(true);
                    }
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i7, i6);
                if (!this.brC.bqB) {
                    imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                } else {
                    imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                }
                imageView.setClickable(true);
                imageView.setFocusable(false);
                if (this.brN == null && (imageView instanceof TbImageView)) {
                    ((TbImageView) imageView).setTbGestureDetector(this.mInternalGestureDetector);
                    imageView.setClickable(true);
                } else {
                    imageView.setOnClickListener(onClickListener);
                }
                imageView.setLayoutParams(layoutParams);
                if (!(imageView instanceof TbImageView)) {
                    if (this.onLongClickListener != null) {
                        ((TbImageView) imageView).setDispatchTouchListener(this.bsd);
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
        if (!this.brC.bqB) {
        }
        imageView.setClickable(true);
        imageView.setFocusable(false);
        if (this.brN == null) {
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
            if (!this.brC.bqB || i4 <= i6 || bqm <= 1.0f) {
                i4 = i6;
            } else {
                if (i6 * bqm <= i4) {
                    if (i6 * bqm > i4 * 0.68f) {
                        i4 = (int) (i4 * 0.68f);
                    } else {
                        i4 = (int) (i6 * bqm);
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
            if (this.brC.bqB && i4 > i8 && bqm > 1.0f) {
                if (i8 * bqm > i4) {
                    i7 = (i4 - l.h(getContext(), e.C0210e.ds78)) - l.h(getContext(), e.C0210e.ds16);
                } else if (i8 * bqm > i4 * 0.68f) {
                    i7 = ((int) (i4 * 0.68f)) - l.h(getContext(), e.C0210e.ds78);
                } else {
                    i7 = (int) (i8 * bqm);
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
        if (this.brC.bqw <= 0 || tbRichTextData == null) {
            return null;
        }
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setTag("VideoView");
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = this.brC.bqp;
        linearLayout.setClickable(true);
        Bitmap dO = al.dO(this.brC.bqw);
        if (dO != null) {
            linearLayout.setBackgroundDrawable(new BitmapDrawable(getContext().getResources(), dO));
        }
        linearLayout.setFocusable(false);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (tbRichTextData.Sg() != null) {
                    if (TbRichTextView.this.getContext() instanceof com.baidu.tbadk.widget.richText.e) {
                        ((com.baidu.tbadk.widget.richText.e) TbRichTextView.this.getContext()).ao(TbRichTextView.this.getContext(), tbRichTextData.Sg().toString());
                        return;
                    }
                    com.baidu.adp.base.e<?> aK = com.baidu.adp.base.i.aK(TbRichTextView.this.getContext());
                    if (aK != null && (aK.getOrignalPage() instanceof com.baidu.tbadk.widget.richText.e)) {
                        ((com.baidu.tbadk.widget.richText.e) aK.getOrignalPage()).ao(TbRichTextView.this.getContext(), tbRichTextData.Sg().toString());
                    }
                }
            }
        });
        return linearLayout;
    }

    private ImageView bT(Context context) {
        ImageView jy = this.brD != null ? this.brD.jy() : null;
        if (jy == null || jy.getParent() != null) {
            jy = null;
        }
        if (jy != null) {
            jy.setContentDescription(context.getString(e.j.editor_image));
        }
        return jy;
    }

    private boolean a(TbRichTextData tbRichTextData, ImageView imageView, int i2, int i3) {
        if (tbRichTextData == null || imageView == null) {
            return false;
        }
        TbRichTextLinkImageInfo Sn = tbRichTextData.Sn();
        if (Sn != null && Sn.getLink() != null) {
            if (imageView instanceof TbImageView) {
                TbImageView tbImageView = (TbImageView) imageView;
                if (this.brC.bqA) {
                    tbImageView.setSupportNoImage(true);
                }
                tbImageView.startLoad(Sn.SF(), this.mIsFromCDN ? 17 : 18, false);
                tbImageView.setTag(new d(Sn.getLink()));
                if (!Sn.Sw()) {
                    tbImageView.setAdjustViewBounds(false);
                }
            }
            return b(imageView, Sn.getWidth(), Sn.getHeight(), i2, i3, this.bsc);
        }
        return false;
    }

    private boolean b(TbRichTextData tbRichTextData, ImageView imageView, int i2, int i3) {
        if (tbRichTextData == null || imageView == null) {
            return false;
        }
        if (tbRichTextData.Sl() == null) {
            return false;
        }
        if (imageView instanceof TbImageView) {
            TbImageView tbImageView = (TbImageView) imageView;
            if (this.brC.bqA) {
                tbImageView.setSupportNoImage(true);
            }
            tbImageView.startLoad(tbRichTextData.Sl().memeInfo.pic_url, this.mIsFromCDN ? 17 : 18, false);
            tbImageView.setAdjustViewBounds(false);
            tbImageView.setTag(e.g.tag_rich_text_meme_info, tbRichTextData.Sl());
        }
        return b(imageView, tbRichTextData.Sl().memeInfo.width.intValue(), tbRichTextData.Sl().memeInfo.height.intValue(), i2, i3, this.mOnClickListener);
    }

    private boolean c(TbRichTextData tbRichTextData, ImageView imageView, int i2, int i3) {
        if (tbRichTextData == null || imageView == null) {
            return false;
        }
        if (tbRichTextData.Sf() == null) {
            return false;
        }
        if (imageView instanceof TbImageView) {
            TbImageView tbImageView = (TbImageView) imageView;
            if (this.brC.bqA) {
                tbImageView.setSupportNoImage(true);
            }
            tbImageView.startLoad(this.brC.RY() ? tbRichTextData.Sf().Sq() : tbRichTextData.Sf().Su(), this.mIsFromCDN ? 17 : 18, false);
            if (!tbRichTextData.Sf().Sw()) {
                tbImageView.setAdjustViewBounds(false);
            }
            tbImageView.setTag(e.g.tag_rich_text_meme_info, null);
        }
        return a(imageView, tbRichTextData.Sf().getWidth(), tbRichTextData.Sf().getHeight(), i2, i3, this.mOnClickListener);
    }

    private TextView bU(Context context) {
        TextView textView = null;
        if (this.brE != null) {
            textView = this.brE.jy();
        }
        if (textView == null || textView.getParent() != null) {
            textView = new TbListTextView(context);
        }
        textView.setPadding(this.brC.aFN, 0, this.brC.aFN, 0);
        return textView;
    }

    private boolean a(TbRichTextData tbRichTextData, TextView textView, boolean z, c cVar) {
        LinearLayout.LayoutParams layoutParams;
        if (z) {
            layoutParams = new LinearLayout.LayoutParams(-1, -2);
        } else {
            layoutParams = new LinearLayout.LayoutParams(-2, -2);
        }
        if (this.brX) {
            layoutParams.gravity = 16;
            textView.setGravity(16);
        } else {
            layoutParams.topMargin = this.brC.bqp;
        }
        textView.setLineSpacing(this.brC.bqo, this.brC.bqn);
        textView.setTextSize(0, this.brC.bqq);
        textView.setTextColor(this.brC.mTextColor);
        textView.setLinkTextColor(al.getColor(e.d.cp_link_tip_c));
        textView.setHighlightColor(getContext().getResources().getColor(e.d.transparent));
        textView.setSingleLine(this.brC.bqx);
        if (this.brK != null) {
            textView.setEllipsize(this.brK);
        }
        if (this.mMaxWidth > 0) {
            textView.setMaxWidth(this.mMaxWidth);
        }
        if (this.mMaxLines > 0) {
            textView.setMaxLines(this.mMaxLines);
        }
        if (tbRichTextData == null) {
            return false;
        }
        SpannableStringBuilder Sg = tbRichTextData.Sg();
        if (Sg == null || Sg.length() <= 0) {
            return false;
        }
        if (this.brC.bqs > 0 && this.brC.bqr > 0) {
            tbRichTextData.V(this.brC.bqr, this.brC.bqs);
        }
        if (cVar != null) {
            cVar.a(Sg, textView, this);
        }
        try {
            textView.setText(Sg);
        } catch (Exception e2) {
            textView.setText("");
        }
        if (this.brY) {
            if (tbRichTextData.Sp()) {
                textView.setMovementMethod(com.baidu.tieba.view.c.bMa());
            } else {
                textView.setMovementMethod(LinkMovementMethod.getInstance());
            }
        }
        textView.setFocusable(false);
        textView.setLayoutParams(layoutParams);
        textView.setTag(tbRichTextData);
        if (tbRichTextData != null && tbRichTextData.Si() != null) {
            tbRichTextData.Si().needRecompute = this.bse;
        }
        return true;
    }

    private GifView getGifView() {
        GifView gifView = null;
        if (this.brI != null) {
            gifView = this.brI.jy();
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
        if (layoutParams == null || layoutParams.width != tbRichTextData.Sk().mGifInfo.mGifWidth || layoutParams.height != tbRichTextData.Sk().mGifInfo.mGifHeight) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(tbRichTextData.Sk().mGifInfo.mGifWidth, tbRichTextData.Sk().mGifInfo.mGifHeight);
            layoutParams2.gravity = 3;
            gifView.setLayoutParams(layoutParams2);
        } else {
            layoutParams.bottomMargin = 0;
        }
        gifView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (TbRichTextView.this.brV != null) {
                    TbRichTextEmotionInfo Sk = tbRichTextData.Sk();
                    TbRichTextView.this.brV.a(view, Sk.mGifInfo.mGid, Sk.mGifInfo.mPackageName, Sk.mGifInfo.mIcon, Sk.mGifInfo.mStaticUrl, Sk.mGifInfo.mDynamicUrl, Sk.mGifInfo.mSharpText, Sk.mGifInfo.mGifWidth, Sk.mGifInfo.mGifHeight);
                }
            }
        });
        gifView.a(tbRichTextData.Sk().mGifInfo);
        return true;
    }

    private boolean b(TbRichTextData tbRichTextData, GifView gifView) {
        if (gifView == null) {
            return false;
        }
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            gifView.setDefaultNoImageDay(al.a(getContext().getResources(), e.f.icon_click));
        } else {
            gifView.setDefaultNoImageDay(e.f.icon_click);
        }
        gifView.setBackgroundDrawable(al.getDrawable(e.d.common_color_10220));
        String Sv = tbRichTextData.Sf().Sv();
        if (StringUtils.isNull(Sv)) {
            if (this.brC.bqJ) {
                Sv = this.brC.mIsFromCDN ? tbRichTextData.Sf().Sq() : tbRichTextData.Sf().St();
            }
            if (StringUtils.isNull(Sv)) {
                Sv = this.brC.mIsFromCDN ? tbRichTextData.Sf().Su() : tbRichTextData.Sf().Ss();
            }
        }
        gifView.setShowStaticDrawable(false);
        gifView.G(Sv, 38);
        return a(gifView, tbRichTextData.Sf().getWidth(), tbRichTextData.Sf().getHeight(), this.brC.bqt, this.brC.bqu, this.mOnClickListener);
    }

    private View getVoiceView() {
        View jy = this.brF != null ? this.brF.jy() : null;
        if ((jy == null || jy.getParent() != null) && this.brR != -1) {
            jy = LayoutInflater.from(getContext()).inflate(this.brR, (ViewGroup) null);
        }
        if (jy != null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.topMargin = this.brC.bqp;
            layoutParams.bottomMargin = this.brC.bqF;
            jy.setLayoutParams(layoutParams);
            return jy;
        }
        return null;
    }

    private boolean a(TbRichTextData tbRichTextData, View view) {
        view.setTag(tbRichTextData.Sh());
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LinearLayout.LayoutParams(-2, -2);
        }
        view.setLayoutParams(layoutParams);
        return true;
    }

    private View getTextVoiceView() {
        LinearLayout jy = this.brG.jy();
        if (jy != null) {
            TextView bU = bU(getContext());
            if (bU == null) {
                this.brG.t(jy);
                return null;
            }
            jy.addView(bU);
            View voiceView = getVoiceView();
            if (voiceView == null) {
                this.brE.t(bU);
                this.brG.t(jy);
                return null;
            }
            jy.addView(voiceView);
            return jy;
        }
        return jy;
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
        if (f2 != this.brC.bqq) {
            this.brC.bqq = f2;
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
        if (i2 != this.brC.mTextColor) {
            this.brC.mTextColor = i2;
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
        if (this.brC.aFN != i2) {
            this.brC.aFN = i2;
            int childCount = getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                if (childAt != null && (childAt instanceof TextView)) {
                    ((TextView) childAt).setPadding(this.brC.aFN, 0, 0, this.brC.aFN);
                }
            }
        }
    }

    public void setLinkTextColor(int i2) {
        if (i2 != this.brC.bqy) {
            this.brC.bqy = i2;
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
        this.brJ = z;
    }

    public h getOnImageClickListener() {
        return this.brM;
    }

    public void setOnImageClickListener(h hVar) {
        this.brM = hVar;
    }

    public void setOnImageTouchListener(com.baidu.tieba.pb.a.c cVar) {
        this.brN = cVar;
    }

    public void setOnEmotionClickListener(g gVar) {
        this.brV = gVar;
    }

    public void setDisplayImage(boolean z, boolean z2) {
        if (this.brQ != z) {
            this.brQ = z;
            if (z2) {
                requestLayout();
            }
            if (!this.brQ && this.brD != null) {
                this.brD.clear();
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
        this.brS = false;
        switch (motionEvent.getAction()) {
            case 1:
            case 3:
                if (!this.mHasPerformedLongPress) {
                    SS();
                    break;
                }
                break;
        }
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        switch (motionEvent.getAction()) {
            case 0:
                if (!this.brS) {
                    SR();
                    break;
                }
                break;
        }
        return dispatchTouchEvent;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.mHasPerformedLongPress && (motionEvent.getAction() == 3 || motionEvent.getAction() == 1)) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.brS = true;
        return super.onTouchEvent(motionEvent);
    }

    private void SR() {
        this.mHasPerformedLongPress = false;
        if (this.brT == null) {
            this.brT = new a();
        }
        postDelayed(this.brT, ViewConfiguration.getLongPressTimeout());
    }

    private void SS() {
        if (this.brT != null) {
            removeCallbacks(this.brT);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!TbRichTextView.this.bsa && TbRichTextView.this.performLongClick()) {
                TbRichTextView.this.mHasPerformedLongPress = true;
            }
        }
    }

    public void setVoiceViewRes(int i2) {
        this.brR = i2;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.bsf != drawable) {
            this.bse = true;
            this.bsf = drawable;
        }
        setText(this.brW);
        this.bse = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.brC != null) {
            this.brC.release();
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
        this.bsb = eVar;
        ja(str);
    }

    public void ja(String str) {
        BdUniqueId bdUniqueId;
        boolean z;
        if (TextUtils.isEmpty(str)) {
            this.mUrl = str;
            return;
        }
        getContext();
        com.baidu.adp.base.h aI = com.baidu.adp.base.i.aI(getContext());
        if (aI != null) {
            bdUniqueId = aI.getUniqueId();
            z = aI.isScroll();
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
        com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) com.baidu.adp.lib.f.c.jA().a(this.mUrl, 19, new Object[0]);
        if (aVar != null) {
            f(aVar);
        } else if (z) {
            invalidate();
        } else if (!com.baidu.adp.lib.f.c.jA().aI(19)) {
            invalidate();
        } else {
            com.baidu.adp.lib.f.c.jA().a(this.mUrl, 19, this.mCallback, 0, 0, this.mPageId, new Object[0]);
        }
    }

    public void stopLoad() {
        if (!TextUtils.isEmpty(this.mUrl)) {
            com.baidu.adp.lib.f.c.jA().a(this.mUrl, 19, this.mCallback);
            setBackgroundDrawable(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null) {
            try {
                NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(getResources(), aVar.op(), aVar.op().getNinePatchChunk(), aVar.ot(), null);
                if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                    ninePatchDrawable.getPaint().setAlpha(80);
                }
                setBackgroundDrawable(ninePatchDrawable);
                if (this.bsb != null) {
                    this.bsb.SU();
                }
            } catch (Exception e2) {
            }
        }
    }

    @Override // com.baidu.adp.newwidget.ImageView.h
    public void refresh() {
        ja(this.mUrl);
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
        return this.brO;
    }

    public void setOnLinkImageClickListener(i iVar) {
        this.brO = iVar;
    }

    public void setHasMovementMethod(boolean z) {
        this.brY = z;
    }

    public void setTextCenter(boolean z) {
        this.brX = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        boolean bsk;

        private b() {
        }
    }
}
