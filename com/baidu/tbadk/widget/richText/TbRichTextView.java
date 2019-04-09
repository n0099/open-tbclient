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
import com.baidu.tbadk.s.s;
import com.baidu.tbadk.widget.ForeDrawableImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.TbListTextView;
import com.baidu.tbadk.widget.layout.GridImageLayout;
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
    private static final float cBR = l.aR(TbadkCoreApplication.getInst());
    private int aNv;
    private int cAC;
    private h cAE;
    private com.baidu.adp.lib.e.b<ImageView> cAv;
    private com.baidu.adp.lib.e.b<GifView> cAw;
    private com.baidu.tbadk.widget.richText.a cAx;
    private boolean cDA;
    private g cDB;
    private TbRichText cDC;
    private boolean cDD;
    private boolean cDE;
    private boolean cDF;
    private boolean cDG;
    private boolean cDH;
    private e cDI;
    public final View.OnClickListener cDJ;
    private final f cDK;
    private boolean cDL;
    private Drawable cDM;
    private CustomMessageListener cDN;
    private com.baidu.adp.lib.e.b<TextView> cDk;
    private com.baidu.adp.lib.e.b<View> cDl;
    private com.baidu.adp.lib.e.b<LinearLayout> cDm;
    private com.baidu.adp.lib.e.b<RelativeLayout> cDn;
    private GridImageLayout cDo;
    private boolean cDp;
    private TextUtils.TruncateAt cDq;
    private j cDr;
    private i cDs;
    private View.OnClickListener cDt;
    private boolean cDu;
    private int cDv;
    private View.OnClickListener cDw;
    private boolean cDx;
    private boolean cDy;
    private Runnable cDz;
    private com.baidu.tieba.pb.a.c ccb;
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
        void ato();
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
        this.cDF = z;
        atk();
    }

    public void setIsHost(boolean z) {
        this.isHost = z;
        if (this.cDo != null) {
            this.cDo.setIsHost(z);
        }
    }

    public void setIsUseGridImage(boolean z) {
        this.cDH = z;
    }

    public boolean atj() {
        return this.cDA;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
        if (this.cAx != null) {
            this.cAx.mIsFromCDN = z;
        }
    }

    public void setMaxWidth(int i2) {
        this.mMaxWidth = i2;
    }

    public void setMaxLines(int i2) {
        this.aNv = i2;
    }

    public void setTextEllipsize(TextUtils.TruncateAt truncateAt) {
        this.cDq = truncateAt;
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
    public boolean bb(View view) {
        if (view instanceof ImageView) {
            if (view instanceof GifView) {
                return view.getTag() != null && (view.getTag() instanceof b) && ((b) view.getTag()).cDR;
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
            /* renamed from: atn */
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
        this.cAx = new com.baidu.tbadk.widget.richText.a();
        this.cAv = null;
        this.cDk = null;
        this.cDl = null;
        this.cDm = null;
        this.cDn = null;
        this.cAw = null;
        this.cDp = true;
        this.cDq = null;
        this.cDr = null;
        this.cAE = null;
        this.ccb = null;
        this.cDs = null;
        this.cDt = null;
        this.cDu = true;
        this.mIsFromCDN = true;
        this.cDv = -1;
        this.cDx = false;
        this.cDy = false;
        this.cDz = null;
        this.cDA = false;
        this.cDD = false;
        this.mMaxWidth = -1;
        this.aNv = -1;
        this.cDE = true;
        this.cDF = false;
        this.isHost = false;
        this.cDG = false;
        this.cDH = false;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                String str2 = null;
                int i2 = -1;
                if (TbRichTextView.this.cAE != null && (view instanceof ImageView)) {
                    Object tag = view.getTag();
                    if (tag != null && (tag instanceof TbRichText)) {
                        int childCount = TbRichTextView.this.getChildCount();
                        for (int i3 = 0; i3 < childCount; i3++) {
                            i2++;
                            if (view.getParent() == TbRichTextView.this.getChildAt(i3)) {
                                break;
                            }
                        }
                        TbRichTextView.this.cAE.a(view, null, i2, TbRichTextView.this.isHost, false);
                        return;
                    }
                    if (tag != null && (tag instanceof String)) {
                        str2 = (String) tag;
                    } else if ((view instanceof TbImageView) && (view.getTag(d.g.tag_rich_text_meme_info) instanceof TbRichTextMemeInfo)) {
                        TbRichTextMemeInfo tbRichTextMemeInfo = (TbRichTextMemeInfo) view.getTag(d.g.tag_rich_text_meme_info);
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
                        TbRichTextView.this.cAE.a(view, str, i2, TbRichTextView.this.isHost, false);
                        return;
                    } else if (view instanceof TbImageView) {
                        str2 = ((TbImageView) view).getUrl();
                    } else if (view instanceof GifView) {
                        str2 = ((GifView) view).getUrl();
                    }
                    int childCount3 = TbRichTextView.this.getChildCount();
                    for (int i5 = 0; i5 < childCount3; i5++) {
                        View childAt = TbRichTextView.this.getChildAt(i5);
                        if (TbRichTextView.this.bb(childAt)) {
                            i2++;
                        }
                        if (view == childAt) {
                            break;
                        }
                    }
                    TbRichTextView.this.cAE.a(view, str2, i2, TbRichTextView.this.isHost, false);
                }
            }
        };
        this.mInternalGestureDetector = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.4
            @Override // com.baidu.tieba.pb.a.c.a
            public boolean b(View view, MotionEvent motionEvent) {
                if (TbRichTextView.this.ccb != null) {
                    TbRichTextView.this.ccb.ci(view);
                    return TbRichTextView.this.ccb.onDoubleTap(motionEvent);
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
        this.cDJ = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                if (TbRichTextView.this.cDs != null && (view instanceof TbImageView)) {
                    Object tag = view.getTag();
                    if (tag == null || !(tag instanceof d)) {
                        str = null;
                    } else {
                        str = ((d) tag).url;
                    }
                    TbRichTextView.this.cDs.f(view, str);
                }
            }
        };
        this.cDK = new f() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.11
            @Override // com.baidu.tbadk.widget.richText.TbRichTextView.f
            public void D(MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    TbRichTextView.this.cDG = true;
                } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                    TbRichTextView.this.cDG = false;
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
        this.cDN = new CustomMessageListener(2004018) { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int contentSizeOfLzl = TbRichTextView.this.cDF ? TbConfig.getContentSizeOfLzl() : TbConfig.getContentSize();
                if (TbRichTextView.this.cDC != null && !v.T(TbRichTextView.this.cDC.ast())) {
                    Iterator<TbRichTextData> it = TbRichTextView.this.cDC.ast().iterator();
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
        this.cAx = new com.baidu.tbadk.widget.richText.a();
        this.cAv = null;
        this.cDk = null;
        this.cDl = null;
        this.cDm = null;
        this.cDn = null;
        this.cAw = null;
        this.cDp = true;
        this.cDq = null;
        this.cDr = null;
        this.cAE = null;
        this.ccb = null;
        this.cDs = null;
        this.cDt = null;
        this.cDu = true;
        this.mIsFromCDN = true;
        this.cDv = -1;
        this.cDx = false;
        this.cDy = false;
        this.cDz = null;
        this.cDA = false;
        this.cDD = false;
        this.mMaxWidth = -1;
        this.aNv = -1;
        this.cDE = true;
        this.cDF = false;
        this.isHost = false;
        this.cDG = false;
        this.cDH = false;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                String str2 = null;
                int i2 = -1;
                if (TbRichTextView.this.cAE != null && (view instanceof ImageView)) {
                    Object tag = view.getTag();
                    if (tag != null && (tag instanceof TbRichText)) {
                        int childCount = TbRichTextView.this.getChildCount();
                        for (int i3 = 0; i3 < childCount; i3++) {
                            i2++;
                            if (view.getParent() == TbRichTextView.this.getChildAt(i3)) {
                                break;
                            }
                        }
                        TbRichTextView.this.cAE.a(view, null, i2, TbRichTextView.this.isHost, false);
                        return;
                    }
                    if (tag != null && (tag instanceof String)) {
                        str2 = (String) tag;
                    } else if ((view instanceof TbImageView) && (view.getTag(d.g.tag_rich_text_meme_info) instanceof TbRichTextMemeInfo)) {
                        TbRichTextMemeInfo tbRichTextMemeInfo = (TbRichTextMemeInfo) view.getTag(d.g.tag_rich_text_meme_info);
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
                        TbRichTextView.this.cAE.a(view, str, i2, TbRichTextView.this.isHost, false);
                        return;
                    } else if (view instanceof TbImageView) {
                        str2 = ((TbImageView) view).getUrl();
                    } else if (view instanceof GifView) {
                        str2 = ((GifView) view).getUrl();
                    }
                    int childCount3 = TbRichTextView.this.getChildCount();
                    for (int i5 = 0; i5 < childCount3; i5++) {
                        View childAt = TbRichTextView.this.getChildAt(i5);
                        if (TbRichTextView.this.bb(childAt)) {
                            i2++;
                        }
                        if (view == childAt) {
                            break;
                        }
                    }
                    TbRichTextView.this.cAE.a(view, str2, i2, TbRichTextView.this.isHost, false);
                }
            }
        };
        this.mInternalGestureDetector = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.4
            @Override // com.baidu.tieba.pb.a.c.a
            public boolean b(View view, MotionEvent motionEvent) {
                if (TbRichTextView.this.ccb != null) {
                    TbRichTextView.this.ccb.ci(view);
                    return TbRichTextView.this.ccb.onDoubleTap(motionEvent);
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
        this.cDJ = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                if (TbRichTextView.this.cDs != null && (view instanceof TbImageView)) {
                    Object tag = view.getTag();
                    if (tag == null || !(tag instanceof d)) {
                        str = null;
                    } else {
                        str = ((d) tag).url;
                    }
                    TbRichTextView.this.cDs.f(view, str);
                }
            }
        };
        this.cDK = new f() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.11
            @Override // com.baidu.tbadk.widget.richText.TbRichTextView.f
            public void D(MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    TbRichTextView.this.cDG = true;
                } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                    TbRichTextView.this.cDG = false;
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
        this.cDN = new CustomMessageListener(2004018) { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int contentSizeOfLzl = TbRichTextView.this.cDF ? TbConfig.getContentSizeOfLzl() : TbConfig.getContentSize();
                if (TbRichTextView.this.cDC != null && !v.T(TbRichTextView.this.cDC.ast())) {
                    Iterator<TbRichTextData> it = TbRichTextView.this.cDC.ast().iterator();
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
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.l.TbRichTextView);
        this.cAx.b(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        atk();
    }

    public com.baidu.tbadk.widget.richText.a getLayoutStrategy() {
        return this.cAx;
    }

    public void setLayoutStrategy(com.baidu.tbadk.widget.richText.a aVar) {
        if (aVar != null) {
            this.cAx.release();
            this.cAx = aVar;
            atk();
            if (this.cDo != null) {
                this.cDo.setLayoutStrategy(this.cAx);
            }
        }
    }

    private void atk() {
        int contentSizeOfLzl = this.cDF ? TbConfig.getContentSizeOfLzl() : TbConfig.getContentSize();
        this.cAx.cBX = contentSizeOfLzl;
        this.cAx.cBW = contentSizeOfLzl;
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
            aK.registerListener(this.cDN);
        }
        if (eVar != null) {
            this.cAv = eVar.atb();
            this.cDk = eVar.atc();
            this.cDl = eVar.ate();
            this.cDm = eVar.atf();
            this.cAw = eVar.atd();
            this.cDn = eVar.atg();
            if (eVar.getListView() != null && this.cDr == null) {
                this.cDr = new j(eVar.ata());
                eVar.getListView().setRecyclerListener(this.cDr);
            }
        }
        this.cAC = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds20);
        setOrientation(1);
        setOnHierarchyChangeListener(new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.7
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof GifView) && TbRichTextView.this.cAw != null) {
                    TbRichTextView.this.cAw.t((GifView) view2);
                } else if ((view2 instanceof ImageView) && TbRichTextView.this.cAv != null) {
                    TbRichTextView.this.cAv.t((ImageView) view2);
                } else if ((view2 instanceof TextView) && TbRichTextView.this.cDk != null) {
                    TbRichTextView.this.cDk.t((TextView) view2);
                } else if ((view2 instanceof PlayVoiceBnt) && TbRichTextView.this.cDl != null) {
                    TbRichTextView.this.cDl.t(view2);
                } else if ((view2 instanceof PlayVoiceBntNew) && TbRichTextView.this.cDl != null) {
                    TbRichTextView.this.cDl.t(view2);
                } else if (view2 instanceof GridImageLayout) {
                    int childCount = ((GridImageLayout) view2).getChildCount();
                    for (int i2 = 0; i2 < childCount; i2++) {
                        View childAt = ((GridImageLayout) view2).getChildAt(i2);
                        if ((childAt instanceof GifView) && TbRichTextView.this.cAw != null) {
                            TbRichTextView.this.cAw.t((GifView) childAt);
                        } else if ((childAt instanceof ImageView) && TbRichTextView.this.cAv != null) {
                            TbRichTextView.this.cAv.t((ImageView) childAt);
                        }
                    }
                    ((GridImageLayout) view2).removeAllViews();
                    ((GridImageLayout) view2).clearData();
                } else if ((view2 instanceof RelativeLayout) && TbRichTextView.this.cDn != null) {
                    TbRichTextView.this.cDn.t((RelativeLayout) view2);
                }
                if (view2 instanceof LinearLayout) {
                    Object tag = view2.getTag();
                    if (tag == null || !(tag instanceof String) || !"VideoView".equals(tag)) {
                        if (TbRichTextView.this.cDm != null) {
                            int childCount2 = ((LinearLayout) view2).getChildCount();
                            for (int i3 = 0; i3 < childCount2; i3++) {
                                View childAt2 = ((LinearLayout) view2).getChildAt(i3);
                                if (childAt2 != null) {
                                    if ((childAt2 instanceof TextView) && TbRichTextView.this.cDk != null) {
                                        TbRichTextView.this.cDk.t((TextView) childAt2);
                                    } else if ((childAt2 instanceof PlayVoiceBnt) && TbRichTextView.this.cDl != null) {
                                        TbRichTextView.this.cDl.t(childAt2);
                                    } else if ((childAt2 instanceof PlayVoiceBntNew) && TbRichTextView.this.cDl != null) {
                                        TbRichTextView.this.cDl.t(childAt2);
                                    }
                                }
                            }
                            ((LinearLayout) view2).removeAllViews();
                            TbRichTextView.this.cDm.t((LinearLayout) view2);
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
        ArrayList<TbRichTextData> ast;
        int i2;
        int i3;
        RelativeLayout relativeLayout;
        boolean z2;
        SpannableStringBuilder asB;
        boolean z3;
        View view;
        KeyEvent.Callback a2;
        boolean z4;
        int i4;
        int i5;
        if (this.cDC != tbRichText || (tbRichText != null && tbRichText.isChanged)) {
            if (tbRichText != null) {
                tbRichText.isChanged = false;
            }
            this.cDC = tbRichText;
            removeAllViews();
            if (tbRichText != null && (ast = tbRichText.ast()) != null) {
                View view2 = null;
                boolean z5 = true;
                Iterator<TbRichTextData> it = ast.iterator();
                boolean z6 = false;
                int i6 = 0;
                int i7 = 0;
                View view3 = null;
                while (it.hasNext()) {
                    TbRichTextData next = it.next();
                    boolean z7 = false;
                    if (next != null) {
                        if (next.getType() == 1) {
                            TextView dl = dl(getContext());
                            boolean a3 = a(next, dl, true, cVar);
                            if (z && !this.cDA && (asB = next.asB()) != null) {
                                this.cDA = asB.length() >= 200;
                            }
                            if (this.ccb != null) {
                                dl.setOnTouchListener(this.mInternalGestureDetector);
                            } else {
                                dl.setOnClickListener(this.cDt);
                            }
                            z7 = a3;
                            i2 = i7;
                            i3 = i6;
                            relativeLayout = dl;
                            z2 = z6;
                        } else if (next.getType() == 8) {
                            if (!this.cDH) {
                                if (i6 < 10) {
                                    i6++;
                                    if (next.asA() != null) {
                                        if (TbadkCoreApplication.getInst().isGifAutoPlay() && !next.asA().asT()) {
                                            GifView gifView = getGifView();
                                            b bVar = new b();
                                            bVar.cDR = true;
                                            gifView.setTag(bVar);
                                            z7 = b(next, gifView);
                                            z2 = z6;
                                            i2 = i7;
                                            i3 = i6;
                                            relativeLayout = gifView;
                                        } else {
                                            ?? dk = dk(getContext());
                                            z7 = c(next, dk, this.cAx.cBY, this.cAx.cBZ);
                                            z2 = z6;
                                            i2 = i7;
                                            i3 = i6;
                                            relativeLayout = dk;
                                        }
                                    }
                                    z2 = z6;
                                    i2 = i7;
                                    i3 = i6;
                                    relativeLayout = view3;
                                }
                            } else if (!z6) {
                                GridImageLayout gridImageView = getGridImageView();
                                gridImageView.setData(tbRichText.asu());
                                z7 = true;
                                z2 = true;
                                i2 = i7;
                                i3 = i6;
                                relativeLayout = gridImageView;
                            }
                        } else if (next.getType() == 32) {
                            com.baidu.tbadk.widget.richText.f asE = next.asE();
                            if (asE != null && asE.ati()) {
                                a2 = b(asE);
                            } else {
                                a2 = a(next);
                            }
                            z2 = z6;
                            i2 = i7;
                            i3 = i6;
                            relativeLayout = a2;
                            z7 = true;
                        } else if (next.getType() == 512) {
                            View bc = bc(view2);
                            if (bc == null) {
                                view3 = bc;
                            } else {
                                z2 = z6;
                                i2 = i7;
                                i3 = i6;
                                relativeLayout = bc;
                                z7 = a(next, bc);
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
                                if (next == null || next.asG() == null || next.asG().memeInfo == null || StringUtils.isNull(next.asG().memeInfo.pic_url)) {
                                    z4 = false;
                                } else {
                                    z4 = true;
                                }
                                if (z4) {
                                    RelativeLayout jA = this.cDn.jA();
                                    jA.removeAllViews();
                                    jA.setLayoutParams(new LinearLayout.LayoutParams(next.asG().memeInfo.width.intValue(), next.asG().memeInfo.height.intValue()));
                                    if (s.apD() && this.cDp) {
                                        b(jA, next.asG().memeInfo.width.intValue(), next.asG().memeInfo.height.intValue(), this.cAx.cBY, this.cAx.cBZ);
                                    } else {
                                        a(jA, next.asG().memeInfo.width.intValue(), next.asG().memeInfo.height.intValue(), this.cAx.cBY, this.cAx.cBZ);
                                    }
                                    ImageView jA2 = this.cAv.jA();
                                    b(next, jA2, this.cAx.cBY, this.cAx.cBZ);
                                    if (s.apD() && this.cDp) {
                                        ImageView jA3 = this.cAv.jA();
                                        jA3.setTag(this.cDC);
                                        if (jA3 instanceof TbImageView) {
                                            TbImageView tbImageView = (TbImageView) jA3;
                                            tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds1));
                                            tbImageView.setBorderColor(al.getColor(d.C0277d.black_alpha8));
                                            tbImageView.setBorderSurroundContent(true);
                                            tbImageView.setDrawCorner(true);
                                            tbImageView.setDrawBorder(true);
                                            tbImageView.setLongIconSupport(true);
                                            tbImageView.setGifIconSupport(true);
                                            tbImageView.setConrers(15);
                                            tbImageView.setRadius(this.cAC);
                                            tbImageView.setAdjustViewBounds(false);
                                            tbImageView.setDefaultBgResource(com.baidu.tbadk.util.e.get());
                                        }
                                        jA3.setScaleType(ImageView.ScaleType.FIT_XY);
                                        int h2 = l.h(getContext(), d.e.ds78);
                                        int h3 = l.h(getContext(), d.e.ds78);
                                        jA2.setId(d.g.meme_image_view);
                                        c(jA2, next.asG().memeInfo.width.intValue(), next.asG().memeInfo.height.intValue(), this.cAx.cBY, this.cAx.cBZ, this.mOnClickListener);
                                        jA.addView(jA2);
                                        if (h3 > next.asG().memeInfo.height.intValue()) {
                                            i5 = h2 / 2;
                                            i4 = h3 / 2;
                                        } else {
                                            i4 = h3;
                                            i5 = h2;
                                        }
                                        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i5, i4);
                                        layoutParams.addRule(8, d.g.meme_image_view);
                                        layoutParams.addRule(11);
                                        jA3.setOnClickListener(this.mOnClickListener);
                                        if (jA.getLeft() > 0) {
                                            layoutParams.rightMargin = l.h(getContext(), d.e.ds6);
                                        }
                                        al.c(jA3, d.f.icon_emotion_dui_n);
                                        jA.addView(jA3, layoutParams);
                                    } else {
                                        b(jA2, next.asG().memeInfo.width.intValue(), next.asG().memeInfo.height.intValue(), this.cAx.cBY, this.cAx.cBZ, this.mOnClickListener);
                                        jA.addView(jA2);
                                    }
                                    z7 = z4;
                                    z2 = z6;
                                    i2 = i8;
                                    i3 = i6;
                                    relativeLayout = jA;
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
                                ImageView dk2 = dk(getContext());
                                z7 = a(next, dk2, (this.cAx.cBY - getPaddingLeft()) - getPaddingRight(), this.cAx.cBZ);
                                z2 = z6;
                                i2 = i7;
                                i3 = i6 + 1;
                                relativeLayout = dk2;
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
                            if (z5 && this.cAx.cCo >= 0) {
                                z5 = false;
                                if (layoutParams2 != null) {
                                    layoutParams2.topMargin = this.cAx.cCo;
                                    relativeLayout.setLayoutParams(layoutParams2);
                                    z3 = false;
                                    view = relativeLayout;
                                }
                                z3 = z5;
                                view = relativeLayout;
                            } else if (relativeLayout instanceof TbListTextView) {
                                if ((view2 instanceof ImageView) || (view2 instanceof RelativeLayout)) {
                                    layoutParams2.topMargin = this.cAx.cCk;
                                } else {
                                    layoutParams2.topMargin = this.cAx.cBU;
                                }
                                relativeLayout.setLayoutParams(layoutParams2);
                                z3 = z5;
                                view = relativeLayout;
                            } else {
                                if (((relativeLayout instanceof ImageView) || (relativeLayout instanceof RelativeLayout)) && (next.getType() == 8 || next.getType() == 20 || next.getType() == 17)) {
                                    if (view2 instanceof TbListTextView) {
                                        layoutParams2.topMargin = this.cAx.cCi;
                                    } else if ((view2 instanceof ImageView) || (relativeLayout instanceof RelativeLayout)) {
                                        layoutParams2.topMargin = this.cAx.cCh;
                                    } else {
                                        layoutParams2.topMargin = this.cAx.cBU;
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
                    layoutParams3.bottomMargin = this.cAx.cCn;
                    view2.setLayoutParams(layoutParams3);
                } else if (view2 != null && this.cAx.cCm >= 0) {
                    LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) view2.getLayoutParams();
                    layoutParams4.bottomMargin = this.cAx.cCm;
                    view2.setLayoutParams(layoutParams4);
                }
            }
        }
    }

    private GridImageLayout getGridImageView() {
        if (this.cDo == null || this.cDo.getParent() != null) {
            this.cDo = new GridImageLayout(getContext());
            this.cDo.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        }
        this.cDo.setLayoutStrategy(this.cAx);
        this.cDo.setObjectPool(this.cAv, this.cAw);
        this.cDo.setOnImageClickListener(this.cAE);
        this.cDo.setIsHost(this.isHost);
        return this.cDo;
    }

    public void setCommonTextViewOnClickListener(View.OnClickListener onClickListener) {
        this.cDt = onClickListener;
    }

    private View b(final com.baidu.tbadk.widget.richText.f fVar) {
        if (fVar == null || !fVar.isAvaliable()) {
            return null;
        }
        ImageView jA = this.cAv.jA();
        if (jA instanceof ForeDrawableImageView) {
            ForeDrawableImageView foreDrawableImageView = (ForeDrawableImageView) jA;
            foreDrawableImageView.setForegroundDrawable(d.f.icon_play_video);
            foreDrawableImageView.setNoImageBottomTextColor(d.C0277d.cp_cont_c);
            foreDrawableImageView.setNoImageBottomTextPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds32));
            foreDrawableImageView.setNoImageBottomTextSize(TbadkCoreApplication.getInst().getResources().getDimension(d.e.fontsize28));
            foreDrawableImageView.setNoImageBottomText("点击播放视频");
            foreDrawableImageView.setInterceptOnClick(false);
            foreDrawableImageView.setTag("VideoView");
            b(foreDrawableImageView, fVar.getWidth(), fVar.getHeight(), (this.cAx.cBY - getPaddingLeft()) - getPaddingRight(), this.cAx.cBZ, new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log("c10643");
                    XiaoyingUtil.startPlayXiaoyingVideo(TbRichTextView.this.getContext(), fVar.getVideoUrl(), fVar.getWidth(), fVar.getHeight(), fVar.getThumbUrl());
                }
            });
            foreDrawableImageView.setDefaultResource(0);
            foreDrawableImageView.setSupportNoImage(this.cAx.cCf);
            if (com.baidu.tbadk.core.i.Wv().Wz()) {
                foreDrawableImageView.setDefaultBgResource(d.f.pic_bg_video_frs);
            } else {
                foreDrawableImageView.setDefaultBgResource(d.C0277d.cp_bg_line_c);
            }
            foreDrawableImageView.startLoad(fVar.getThumbUrl(), 17, false);
            return jA;
        }
        return jA;
    }

    private boolean a(ImageView imageView, int i2, int i3, int i4, int i5, View.OnClickListener onClickListener) {
        int[] o = this.cAx.o(i2, i3, i4, i5);
        if (o == null) {
            return false;
        }
        int i6 = o[0];
        int i7 = o[1];
        if (imageView instanceof TbImageView) {
            TbImageView tbImageView = (TbImageView) imageView;
            tbImageView.setDefaultResource(this.cAx.cCa);
            if (tbImageView.getGifIconWidth() >= i6 || tbImageView.getGifIconHeight() >= i7) {
                tbImageView.setGifIconSupport(false);
            } else {
                tbImageView.setGifIconSupport(true);
            }
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i6, i7);
        if (this.cAx.cCg) {
            imageView.setScaleType(this.cAx.cCe);
            if (imageView instanceof TbImageView) {
                ((TbImageView) imageView).setOnDrawListener(this.cAx.mOnDrawListener);
            }
        } else {
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        }
        imageView.setClickable(true);
        imageView.setFocusable(false);
        if (this.ccb != null && (imageView instanceof TbImageView)) {
            ((TbImageView) imageView).setTbGestureDetector(this.mInternalGestureDetector);
            imageView.setClickable(true);
        } else {
            imageView.setOnClickListener(onClickListener);
        }
        imageView.setLayoutParams(layoutParams);
        if (imageView instanceof TbImageView) {
            if (this.onLongClickListener != null) {
                ((TbImageView) imageView).setDispatchTouchListener(this.cDK);
                imageView.setOnLongClickListener(this.onLongClickListener);
            }
        } else if ((imageView instanceof GifView) && this.onLongClickListener != null) {
            ((GifView) imageView).setDispatchTouchListener(this.cDK);
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
        if (!this.cAx.cCg || i4 <= i7 || cBR <= 1.0f) {
            i4 = i7;
            i6 = i8;
        } else {
            if (i7 * cBR <= i4) {
                if (i7 * cBR > i4 * 0.68f) {
                    i4 = (int) (i4 * 0.68f);
                } else {
                    i4 = (int) (i7 * cBR);
                }
            }
            i6 = iArr[0] > 0 ? (iArr[1] * i4) / iArr[0] : i8;
        }
        if (imageView instanceof TbImageView) {
            TbImageView tbImageView = (TbImageView) imageView;
            tbImageView.setDefaultResource(this.cAx.cCa);
            if (tbImageView.getGifIconWidth() >= i4 || tbImageView.getGifIconHeight() >= i6) {
                tbImageView.setGifIconSupport(false);
            } else {
                tbImageView.setGifIconSupport(true);
            }
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i4, i6);
        if (this.cAx.cCg) {
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        } else {
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        }
        imageView.setClickable(true);
        imageView.setFocusable(false);
        if (this.ccb != null && (imageView instanceof TbImageView)) {
            ((TbImageView) imageView).setTbGestureDetector(this.mInternalGestureDetector);
            imageView.setClickable(true);
        } else {
            imageView.setOnClickListener(onClickListener);
        }
        imageView.setLayoutParams(layoutParams);
        if (imageView instanceof TbImageView) {
            if (this.onLongClickListener != null) {
                ((TbImageView) imageView).setDispatchTouchListener(this.cDK);
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
        if (this.cAx.cCg && i4 > i8 && cBR > 1.0f) {
            if (i8 * cBR > i4) {
                i8 = (i4 - l.h(getContext(), d.e.ds78)) - l.h(getContext(), d.e.ds16);
            } else if (i8 * cBR > i4 * 0.68f) {
                i8 = ((int) (i4 * 0.68f)) - l.h(getContext(), d.e.ds78);
            } else {
                i8 = (int) (i8 * cBR);
            }
            if (iArr[0] > 0) {
                i6 = (iArr[1] * i8) / iArr[0];
                i7 = i8;
                if (imageView instanceof TbImageView) {
                    TbImageView tbImageView = (TbImageView) imageView;
                    tbImageView.setDefaultResource(this.cAx.cCa);
                    if (tbImageView.getGifIconWidth() >= i7 || tbImageView.getGifIconHeight() >= i6) {
                        tbImageView.setGifIconSupport(false);
                    } else {
                        tbImageView.setGifIconSupport(true);
                    }
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i7, i6);
                if (!this.cAx.cCg) {
                    imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                } else {
                    imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                }
                imageView.setClickable(true);
                imageView.setFocusable(false);
                if (this.ccb == null && (imageView instanceof TbImageView)) {
                    ((TbImageView) imageView).setTbGestureDetector(this.mInternalGestureDetector);
                    imageView.setClickable(true);
                } else {
                    imageView.setOnClickListener(onClickListener);
                }
                imageView.setLayoutParams(layoutParams);
                if (!(imageView instanceof TbImageView)) {
                    if (this.onLongClickListener != null) {
                        ((TbImageView) imageView).setDispatchTouchListener(this.cDK);
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
        if (!this.cAx.cCg) {
        }
        imageView.setClickable(true);
        imageView.setFocusable(false);
        if (this.ccb == null) {
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
            if (!this.cAx.cCg || i4 <= i6 || cBR <= 1.0f) {
                i4 = i6;
            } else {
                if (i6 * cBR <= i4) {
                    if (i6 * cBR > i4 * 0.68f) {
                        i4 = (int) (i4 * 0.68f);
                    } else {
                        i4 = (int) (i6 * cBR);
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
            if (this.cAx.cCg && i4 > i8 && cBR > 1.0f) {
                if (i8 * cBR > i4) {
                    i7 = (i4 - l.h(getContext(), d.e.ds78)) - l.h(getContext(), d.e.ds16);
                } else if (i8 * cBR > i4 * 0.68f) {
                    i7 = ((int) (i4 * 0.68f)) - l.h(getContext(), d.e.ds78);
                } else {
                    i7 = (int) (i8 * cBR);
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
        if (this.cAx.cCb <= 0 || tbRichTextData == null) {
            return null;
        }
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setTag("VideoView");
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = this.cAx.cBU;
        linearLayout.setClickable(true);
        Bitmap hp = al.hp(this.cAx.cCb);
        if (hp != null) {
            linearLayout.setBackgroundDrawable(new BitmapDrawable(getContext().getResources(), hp));
        }
        linearLayout.setFocusable(false);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (tbRichTextData.asB() != null) {
                    if (TbRichTextView.this.getContext() instanceof com.baidu.tbadk.widget.richText.e) {
                        ((com.baidu.tbadk.widget.richText.e) TbRichTextView.this.getContext()).az(TbRichTextView.this.getContext(), tbRichTextData.asB().toString());
                        return;
                    }
                    com.baidu.adp.base.e<?> aK = com.baidu.adp.base.i.aK(TbRichTextView.this.getContext());
                    if (aK != null && (aK.getOrignalPage() instanceof com.baidu.tbadk.widget.richText.e)) {
                        ((com.baidu.tbadk.widget.richText.e) aK.getOrignalPage()).az(TbRichTextView.this.getContext(), tbRichTextData.asB().toString());
                    }
                }
            }
        });
        return linearLayout;
    }

    private ImageView dk(Context context) {
        ImageView jA = this.cAv != null ? this.cAv.jA() : null;
        if (jA == null || jA.getParent() != null) {
            jA = null;
        }
        if (jA != null) {
            jA.setContentDescription(context.getString(d.j.editor_image));
        }
        return jA;
    }

    private boolean a(TbRichTextData tbRichTextData, ImageView imageView, int i2, int i3) {
        if (tbRichTextData == null || imageView == null) {
            return false;
        }
        TbRichTextLinkImageInfo asI = tbRichTextData.asI();
        if (asI != null && asI.getLink() != null) {
            if (imageView instanceof TbImageView) {
                TbImageView tbImageView = (TbImageView) imageView;
                if (this.cAx.cCf) {
                    tbImageView.setSupportNoImage(true);
                }
                tbImageView.startLoad(asI.asZ(), this.mIsFromCDN ? 17 : 18, false);
                tbImageView.setTag(new d(asI.getLink()));
                if (!asI.asQ()) {
                    tbImageView.setAdjustViewBounds(false);
                }
            }
            return b(imageView, asI.getWidth(), asI.getHeight(), i2, i3, this.cDJ);
        }
        return false;
    }

    private boolean b(TbRichTextData tbRichTextData, ImageView imageView, int i2, int i3) {
        if (tbRichTextData == null || imageView == null) {
            return false;
        }
        if (tbRichTextData.asG() == null) {
            return false;
        }
        if (imageView instanceof TbImageView) {
            TbImageView tbImageView = (TbImageView) imageView;
            tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds1));
            tbImageView.setBorderColor(al.getColor(d.C0277d.black_alpha8));
            tbImageView.setBorderSurroundContent(true);
            tbImageView.setDrawCorner(true);
            tbImageView.setDrawBorder(true);
            tbImageView.setLongIconSupport(true);
            tbImageView.setGifIconSupport(true);
            tbImageView.setConrers(15);
            tbImageView.setRadius(this.cAC);
            tbImageView.setDefaultBgResource(com.baidu.tbadk.util.e.get());
            if (this.cAx.cCf) {
                tbImageView.setSupportNoImage(true);
            }
            tbImageView.startLoad(tbRichTextData.asG().memeInfo.pic_url, this.mIsFromCDN ? 17 : 18, false);
            tbImageView.setAdjustViewBounds(false);
            tbImageView.setTag(d.g.tag_rich_text_meme_info, tbRichTextData.asG());
        }
        return b(imageView, tbRichTextData.asG().memeInfo.width.intValue(), tbRichTextData.asG().memeInfo.height.intValue(), i2, i3, this.mOnClickListener);
    }

    private boolean c(TbRichTextData tbRichTextData, ImageView imageView, int i2, int i3) {
        if (tbRichTextData == null || imageView == null) {
            return false;
        }
        if (tbRichTextData.asA() == null) {
            return false;
        }
        if (imageView instanceof TbImageView) {
            TbImageView tbImageView = (TbImageView) imageView;
            tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds1));
            tbImageView.setBorderColor(al.getColor(d.C0277d.black_alpha8));
            tbImageView.setBorderSurroundContent(true);
            tbImageView.setDrawCorner(true);
            tbImageView.setDrawBorder(true);
            tbImageView.setLongIconSupport(true);
            tbImageView.setGifIconSupport(true);
            tbImageView.setConrers(15);
            tbImageView.setRadius(this.cAC);
            tbImageView.setDefaultBgResource(com.baidu.tbadk.util.e.get());
            if (this.cAx.cCf) {
                tbImageView.setSupportNoImage(true);
            }
            tbImageView.startLoad(this.cAx.ass() ? tbRichTextData.asA().asL() : tbRichTextData.asA().asO(), this.mIsFromCDN ? 17 : 18, false);
            if (!tbRichTextData.asA().asQ()) {
                tbImageView.setAdjustViewBounds(false);
            }
            tbImageView.setTag(d.g.tag_rich_text_meme_info, null);
        }
        return a(imageView, tbRichTextData.asA().getWidth(), tbRichTextData.asA().getHeight(), i2, i3, this.mOnClickListener);
    }

    private TextView dl(Context context) {
        TextView textView = null;
        if (this.cDk != null) {
            textView = this.cDk.jA();
        }
        if (textView == null || textView.getParent() != null) {
            textView = new TbListTextView(context);
        }
        textView.setPadding(this.cAx.bOC, 0, this.cAx.bOC, 0);
        return textView;
    }

    private boolean a(TbRichTextData tbRichTextData, TextView textView, boolean z, c cVar) {
        LinearLayout.LayoutParams layoutParams;
        if (z) {
            layoutParams = new LinearLayout.LayoutParams(-1, -2);
        } else {
            layoutParams = new LinearLayout.LayoutParams(-2, -2);
        }
        if (this.cDD) {
            layoutParams.gravity = 16;
            textView.setGravity(16);
        } else {
            layoutParams.topMargin = this.cAx.cBU;
        }
        textView.setLineSpacing(this.cAx.cBT, this.cAx.cBS);
        textView.setTextSize(0, this.cAx.cBV);
        textView.setTextColor(this.cAx.mTextColor);
        textView.setLinkTextColor(al.getColor(d.C0277d.cp_link_tip_c));
        textView.setHighlightColor(getContext().getResources().getColor(d.C0277d.transparent));
        textView.setSingleLine(this.cAx.cCc);
        if (this.cDq != null) {
            textView.setEllipsize(this.cDq);
        }
        if (this.mMaxWidth > 0) {
            textView.setMaxWidth(this.mMaxWidth);
        }
        if (this.aNv > 0) {
            textView.setMaxLines(this.aNv);
        }
        if (tbRichTextData == null) {
            return false;
        }
        SpannableStringBuilder asB = tbRichTextData.asB();
        if (asB == null || asB.length() <= 0) {
            return false;
        }
        if (this.cAx.cBX > 0 && this.cAx.cBW > 0) {
            tbRichTextData.at(this.cAx.cBW, this.cAx.cBX);
        }
        if (cVar != null) {
            cVar.a(asB, textView, this);
        }
        try {
            textView.setText(asB);
        } catch (Exception e2) {
            textView.setText("");
        }
        if (this.cDE) {
            if (tbRichTextData.asK()) {
                textView.setMovementMethod(com.baidu.tieba.view.c.cmY());
            } else {
                textView.setMovementMethod(LinkMovementMethod.getInstance());
            }
        }
        textView.setFocusable(false);
        textView.setLayoutParams(layoutParams);
        textView.setTag(tbRichTextData);
        if (tbRichTextData != null && tbRichTextData.asD() != null) {
            tbRichTextData.asD().needRecompute = this.cDL;
        }
        return true;
    }

    private GifView getGifView() {
        GifView gifView = null;
        if (this.cAw != null) {
            gifView = this.cAw.jA();
        }
        GifView gifView2 = (gifView == null || gifView.getParent() != null) ? new GifView(getContext()) : gifView;
        gifView2.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds1));
        gifView2.setBorderColor(al.getColor(d.C0277d.black_alpha8));
        gifView2.setBorderSurroundContent(true);
        gifView2.setDrawCorner(true);
        gifView2.setDrawBorder(true);
        gifView2.setConrers(15);
        gifView2.setDrawBorder(true);
        gifView2.setRadius(this.cAC);
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
        if (layoutParams == null || layoutParams.width != tbRichTextData.asF().mGifInfo.mGifWidth || layoutParams.height != tbRichTextData.asF().mGifInfo.mGifHeight) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(tbRichTextData.asF().mGifInfo.mGifWidth, tbRichTextData.asF().mGifInfo.mGifHeight);
            layoutParams2.gravity = 3;
            gifView.setLayoutParams(layoutParams2);
        } else {
            layoutParams.bottomMargin = 0;
        }
        gifView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (TbRichTextView.this.cDB != null) {
                    TbRichTextEmotionInfo asF = tbRichTextData.asF();
                    TbRichTextView.this.cDB.a(view, asF.mGifInfo.mGid, asF.mGifInfo.mPackageName, asF.mGifInfo.mIcon, asF.mGifInfo.mStaticUrl, asF.mGifInfo.mDynamicUrl, asF.mGifInfo.mSharpText, asF.mGifInfo.mGifWidth, asF.mGifInfo.mGifHeight);
                }
            }
        });
        gifView.a(tbRichTextData.asF().mGifInfo);
        return true;
    }

    private boolean b(TbRichTextData tbRichTextData, GifView gifView) {
        if (gifView == null) {
            return false;
        }
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            gifView.setDefaultNoImageDay(al.a(getContext().getResources(), d.f.icon_click));
        } else {
            gifView.setDefaultNoImageDay(d.f.icon_click);
        }
        Drawable drawable = al.getDrawable(com.baidu.tbadk.util.e.get());
        if (drawable != null) {
            gifView.setBackgroundDrawable(drawable);
        } else {
            gifView.setBackgroundDrawable(al.getDrawable(d.C0277d.common_color_10220));
        }
        String asP = tbRichTextData.asA().asP();
        if (StringUtils.isNull(asP)) {
            if (this.cAx.cCp) {
                asP = this.cAx.mIsFromCDN ? tbRichTextData.asA().asL() : tbRichTextData.asA().asN();
            }
            if (StringUtils.isNull(asP)) {
                asP = this.cAx.mIsFromCDN ? tbRichTextData.asA().asO() : tbRichTextData.asA().Nv();
            }
        }
        gifView.setShowStaticDrawable(false);
        gifView.ad(asP, 38);
        return a(gifView, tbRichTextData.asA().getWidth(), tbRichTextData.asA().getHeight(), this.cAx.cBY, this.cAx.cBZ, this.mOnClickListener);
    }

    private View bc(View view) {
        View jA = this.cDl != null ? this.cDl.jA() : null;
        if ((jA == null || jA.getParent() != null) && this.cDv != -1) {
            jA = LayoutInflater.from(getContext()).inflate(this.cDv, (ViewGroup) null);
        }
        if (jA != null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            if ((view instanceof TbListTextView) && this.cAx.cCj >= 0) {
                layoutParams.topMargin = this.cAx.cCj;
            } else {
                layoutParams.topMargin = this.cAx.cBU;
            }
            layoutParams.bottomMargin = this.cAx.cCl;
            jA.setLayoutParams(layoutParams);
            if (jA instanceof PlayVoiceBntNew) {
                ((PlayVoiceBntNew) jA).setAfterClickListener(this.cDw);
                return jA;
            }
            return jA;
        }
        return null;
    }

    private boolean a(TbRichTextData tbRichTextData, View view) {
        view.setTag(tbRichTextData.asC());
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LinearLayout.LayoutParams(-2, -2);
        }
        view.setLayoutParams(layoutParams);
        return true;
    }

    private View getTextVoiceView() {
        LinearLayout jA = this.cDm.jA();
        if (jA != null) {
            TextView dl = dl(getContext());
            if (dl == null) {
                this.cDm.t(jA);
                return null;
            }
            jA.addView(dl);
            View bc = bc(null);
            if (bc == null) {
                this.cDk.t(dl);
                this.cDm.t(jA);
                return null;
            }
            jA.addView(bc);
            return jA;
        }
        return jA;
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
        if (f2 != this.cAx.cBV) {
            this.cAx.cBV = f2;
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
        if (i2 != this.cAx.mTextColor) {
            this.cAx.mTextColor = i2;
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
        if (this.cAx.bOC != i2) {
            this.cAx.bOC = i2;
            int childCount = getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                if (childAt != null && (childAt instanceof TextView)) {
                    ((TextView) childAt).setPadding(this.cAx.bOC, 0, 0, this.cAx.bOC);
                }
            }
        }
    }

    public void setLinkTextColor(int i2) {
        if (i2 != this.cAx.cCd) {
            this.cAx.cCd = i2;
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
        this.cDp = z;
    }

    public h getOnImageClickListener() {
        return this.cAE;
    }

    public void setOnImageClickListener(h hVar) {
        this.cAE = hVar;
        if (this.cDo != null) {
            this.cDo.setOnImageClickListener(this.cAE);
        }
    }

    public void setOnImageTouchListener(com.baidu.tieba.pb.a.c cVar) {
        this.ccb = cVar;
    }

    public void setOnEmotionClickListener(g gVar) {
        this.cDB = gVar;
    }

    public void setDisplayImage(boolean z, boolean z2) {
        if (this.cDu != z) {
            this.cDu = z;
            if (z2) {
                requestLayout();
            }
            if (!this.cDu && this.cAv != null) {
                this.cAv.clear();
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
        this.cDx = false;
        switch (motionEvent.getAction()) {
            case 1:
            case 3:
                if (!this.cDy) {
                    atm();
                    break;
                }
                break;
        }
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        switch (motionEvent.getAction()) {
            case 0:
                if (!this.cDx) {
                    atl();
                    break;
                }
                break;
        }
        return dispatchTouchEvent;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.cDy && (motionEvent.getAction() == 3 || motionEvent.getAction() == 1)) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.cDx = true;
        return super.onTouchEvent(motionEvent);
    }

    private void atl() {
        this.cDy = false;
        if (this.cDz == null) {
            this.cDz = new a();
        }
        postDelayed(this.cDz, ViewConfiguration.getLongPressTimeout());
    }

    private void atm() {
        if (this.cDz != null) {
            removeCallbacks(this.cDz);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!TbRichTextView.this.cDG && TbRichTextView.this.performLongClick()) {
                TbRichTextView.this.cDy = true;
            }
        }
    }

    public void setVoiceViewRes(int i2) {
        this.cDv = i2;
    }

    public void setOnVoiceAfterClickListener(View.OnClickListener onClickListener) {
        this.cDw = onClickListener;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.cDM != drawable) {
            this.cDL = true;
            this.cDM = drawable;
        }
        setText(this.cDC);
        this.cDL = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.cAx != null) {
            this.cAx.release();
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
        this.cDI = eVar;
        qc(str);
    }

    public void qc(String str) {
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
        com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) com.baidu.adp.lib.f.c.jB().a(this.mUrl, 19, new Object[0]);
        if (aVar != null) {
            f(aVar);
        } else if (z) {
            invalidate();
        } else if (!com.baidu.adp.lib.f.c.jB().aq(19)) {
            invalidate();
        } else {
            com.baidu.adp.lib.f.c.jB().a(this.mUrl, 19, this.mCallback, 0, 0, this.mPageId, new Object[0]);
        }
    }

    public void stopLoad() {
        if (!TextUtils.isEmpty(this.mUrl)) {
            com.baidu.adp.lib.f.c.jB().a(this.mUrl, 19, this.mCallback);
            setBackgroundDrawable(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null) {
            try {
                NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(getResources(), aVar.oy(), aVar.oy().getNinePatchChunk(), aVar.oC(), null);
                if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                    ninePatchDrawable.getPaint().setAlpha(80);
                }
                setBackgroundDrawable(ninePatchDrawable);
                if (this.cDI != null) {
                    this.cDI.ato();
                }
            } catch (Exception e2) {
            }
        }
    }

    @Override // com.baidu.adp.newwidget.ImageView.h
    public void refresh() {
        qc(this.mUrl);
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
        return this.cDs;
    }

    public void setOnLinkImageClickListener(i iVar) {
        this.cDs = iVar;
    }

    public void setHasMovementMethod(boolean z) {
        this.cDE = z;
    }

    public void setTextCenter(boolean z) {
        this.cDD = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        boolean cDR;

        private b() {
        }
    }
}
