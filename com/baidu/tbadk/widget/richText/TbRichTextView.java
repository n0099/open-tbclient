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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tbadk.widget.ForeDrawableImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.TbListTextView;
import com.baidu.tbadk.widget.layout.GridImageLayout;
import com.baidu.tieba.R;
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
    private static final float cMr = l.ai(TbadkCoreApplication.getInst());
    private int aQG;
    private com.baidu.adp.lib.e.b<ImageView> cKV;
    private com.baidu.adp.lib.e.b<GifView> cKW;
    private com.baidu.tbadk.widget.richText.a cKX;
    private int cLc;
    private h cLe;
    private com.baidu.adp.lib.e.b<TextView> cNK;
    private com.baidu.adp.lib.e.b<View> cNL;
    private com.baidu.adp.lib.e.b<LinearLayout> cNM;
    private com.baidu.adp.lib.e.b<RelativeLayout> cNN;
    private GridImageLayout cNO;
    private boolean cNP;
    private TextUtils.TruncateAt cNQ;
    private j cNR;
    private i cNS;
    private View.OnClickListener cNT;
    private boolean cNU;
    private int cNV;
    private View.OnClickListener cNW;
    private boolean cNX;
    private boolean cNY;
    private Runnable cNZ;
    private boolean cOa;
    private g cOb;
    private TbRichText cOc;
    private boolean cOd;
    private boolean cOe;
    private boolean cOf;
    private boolean cOg;
    private boolean cOh;
    private e cOi;
    public final View.OnClickListener cOj;
    private final f cOk;
    private boolean cOl;
    private Drawable cOm;
    private CustomMessageListener cOn;
    private com.baidu.tieba.pb.a.c cmw;
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
        void azU();
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
        this.cOf = z;
        azQ();
    }

    public void setIsHost(boolean z) {
        this.isHost = z;
        if (this.cNO != null) {
            this.cNO.setIsHost(z);
        }
    }

    public void setIsUseGridImage(boolean z) {
        this.cOh = z;
    }

    public boolean azP() {
        return this.cOa;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
        if (this.cKX != null) {
            this.cKX.mIsFromCDN = z;
        }
    }

    public void setMaxWidth(int i2) {
        this.mMaxWidth = i2;
    }

    public void setMaxLines(int i2) {
        this.aQG = i2;
    }

    public void setTextEllipsize(TextUtils.TruncateAt truncateAt) {
        this.cNQ = truncateAt;
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
    public boolean bj(View view) {
        if (view instanceof ImageView) {
            if (view instanceof GifView) {
                return view.getTag() != null && (view.getTag() instanceof b) && ((b) view.getTag()).cOr;
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
            /* renamed from: azT */
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
        this.cKX = new com.baidu.tbadk.widget.richText.a();
        this.cKV = null;
        this.cNK = null;
        this.cNL = null;
        this.cNM = null;
        this.cNN = null;
        this.cKW = null;
        this.cNP = true;
        this.cNQ = null;
        this.cNR = null;
        this.cLe = null;
        this.cmw = null;
        this.cNS = null;
        this.cNT = null;
        this.cNU = true;
        this.mIsFromCDN = true;
        this.cNV = -1;
        this.cNX = false;
        this.cNY = false;
        this.cNZ = null;
        this.cOa = false;
        this.cOd = false;
        this.mMaxWidth = -1;
        this.aQG = -1;
        this.cOe = true;
        this.cOf = false;
        this.isHost = false;
        this.cOg = false;
        this.cOh = false;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                String str2 = null;
                int i2 = -1;
                if (TbRichTextView.this.cLe != null && (view instanceof ImageView)) {
                    Object tag = view.getTag();
                    if (tag != null && (tag instanceof TbRichText)) {
                        int childCount = TbRichTextView.this.getChildCount();
                        for (int i3 = 0; i3 < childCount; i3++) {
                            i2++;
                            if (view.getParent() == TbRichTextView.this.getChildAt(i3)) {
                                break;
                            }
                        }
                        TbRichTextView.this.cLe.a(view, null, i2, TbRichTextView.this.isHost, false);
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
                        TbRichTextView.this.cLe.a(view, str, i2, TbRichTextView.this.isHost, false);
                        return;
                    } else if (view instanceof TbImageView) {
                        str2 = ((TbImageView) view).getUrl();
                    } else if (view instanceof GifView) {
                        str2 = ((GifView) view).getUrl();
                    }
                    int childCount3 = TbRichTextView.this.getChildCount();
                    for (int i5 = 0; i5 < childCount3; i5++) {
                        View childAt = TbRichTextView.this.getChildAt(i5);
                        if (TbRichTextView.this.bj(childAt)) {
                            i2++;
                        }
                        if (view == childAt) {
                            break;
                        }
                    }
                    TbRichTextView.this.cLe.a(view, str2, i2, TbRichTextView.this.isHost, false);
                }
            }
        };
        this.mInternalGestureDetector = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.4
            @Override // com.baidu.tieba.pb.a.c.a
            public boolean b(View view, MotionEvent motionEvent) {
                if (TbRichTextView.this.cmw != null) {
                    TbRichTextView.this.cmw.cu(view);
                    return TbRichTextView.this.cmw.onDoubleTap(motionEvent);
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
        this.cOj = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                if (TbRichTextView.this.cNS != null && (view instanceof TbImageView)) {
                    Object tag = view.getTag();
                    if (tag == null || !(tag instanceof d)) {
                        str = null;
                    } else {
                        str = ((d) tag).url;
                    }
                    TbRichTextView.this.cNS.f(view, str);
                }
            }
        };
        this.cOk = new f() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.11
            @Override // com.baidu.tbadk.widget.richText.TbRichTextView.f
            public void D(MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    TbRichTextView.this.cOg = true;
                } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                    TbRichTextView.this.cOg = false;
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
        this.cOn = new CustomMessageListener(2004018) { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int contentSizeOfLzl = TbRichTextView.this.cOf ? TbConfig.getContentSizeOfLzl() : TbConfig.getContentSize();
                if (TbRichTextView.this.cOc != null && !v.aa(TbRichTextView.this.cOc.ayZ())) {
                    Iterator<TbRichTextData> it = TbRichTextView.this.cOc.ayZ().iterator();
                    while (it.hasNext()) {
                        TbRichTextData next = it.next();
                        if (next != null) {
                            next.ax(contentSizeOfLzl, contentSizeOfLzl);
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
        this.cKX = new com.baidu.tbadk.widget.richText.a();
        this.cKV = null;
        this.cNK = null;
        this.cNL = null;
        this.cNM = null;
        this.cNN = null;
        this.cKW = null;
        this.cNP = true;
        this.cNQ = null;
        this.cNR = null;
        this.cLe = null;
        this.cmw = null;
        this.cNS = null;
        this.cNT = null;
        this.cNU = true;
        this.mIsFromCDN = true;
        this.cNV = -1;
        this.cNX = false;
        this.cNY = false;
        this.cNZ = null;
        this.cOa = false;
        this.cOd = false;
        this.mMaxWidth = -1;
        this.aQG = -1;
        this.cOe = true;
        this.cOf = false;
        this.isHost = false;
        this.cOg = false;
        this.cOh = false;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                String str2 = null;
                int i2 = -1;
                if (TbRichTextView.this.cLe != null && (view instanceof ImageView)) {
                    Object tag = view.getTag();
                    if (tag != null && (tag instanceof TbRichText)) {
                        int childCount = TbRichTextView.this.getChildCount();
                        for (int i3 = 0; i3 < childCount; i3++) {
                            i2++;
                            if (view.getParent() == TbRichTextView.this.getChildAt(i3)) {
                                break;
                            }
                        }
                        TbRichTextView.this.cLe.a(view, null, i2, TbRichTextView.this.isHost, false);
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
                        TbRichTextView.this.cLe.a(view, str, i2, TbRichTextView.this.isHost, false);
                        return;
                    } else if (view instanceof TbImageView) {
                        str2 = ((TbImageView) view).getUrl();
                    } else if (view instanceof GifView) {
                        str2 = ((GifView) view).getUrl();
                    }
                    int childCount3 = TbRichTextView.this.getChildCount();
                    for (int i5 = 0; i5 < childCount3; i5++) {
                        View childAt = TbRichTextView.this.getChildAt(i5);
                        if (TbRichTextView.this.bj(childAt)) {
                            i2++;
                        }
                        if (view == childAt) {
                            break;
                        }
                    }
                    TbRichTextView.this.cLe.a(view, str2, i2, TbRichTextView.this.isHost, false);
                }
            }
        };
        this.mInternalGestureDetector = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.4
            @Override // com.baidu.tieba.pb.a.c.a
            public boolean b(View view, MotionEvent motionEvent) {
                if (TbRichTextView.this.cmw != null) {
                    TbRichTextView.this.cmw.cu(view);
                    return TbRichTextView.this.cmw.onDoubleTap(motionEvent);
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
        this.cOj = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                if (TbRichTextView.this.cNS != null && (view instanceof TbImageView)) {
                    Object tag = view.getTag();
                    if (tag == null || !(tag instanceof d)) {
                        str = null;
                    } else {
                        str = ((d) tag).url;
                    }
                    TbRichTextView.this.cNS.f(view, str);
                }
            }
        };
        this.cOk = new f() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.11
            @Override // com.baidu.tbadk.widget.richText.TbRichTextView.f
            public void D(MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    TbRichTextView.this.cOg = true;
                } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                    TbRichTextView.this.cOg = false;
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
        this.cOn = new CustomMessageListener(2004018) { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int contentSizeOfLzl = TbRichTextView.this.cOf ? TbConfig.getContentSizeOfLzl() : TbConfig.getContentSize();
                if (TbRichTextView.this.cOc != null && !v.aa(TbRichTextView.this.cOc.ayZ())) {
                    Iterator<TbRichTextData> it = TbRichTextView.this.cOc.ayZ().iterator();
                    while (it.hasNext()) {
                        TbRichTextData next = it.next();
                        if (next != null) {
                            next.ax(contentSizeOfLzl, contentSizeOfLzl);
                        }
                    }
                }
                TbRichTextView.this.setTextSize(contentSizeOfLzl);
            }
        };
        init();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.a.TbRichTextView);
        this.cKX.b(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        azQ();
    }

    public com.baidu.tbadk.widget.richText.a getLayoutStrategy() {
        return this.cKX;
    }

    public void setLayoutStrategy(com.baidu.tbadk.widget.richText.a aVar) {
        if (aVar != null) {
            this.cKX.release();
            this.cKX = aVar;
            azQ();
            if (this.cNO != null) {
                this.cNO.setLayoutStrategy(this.cKX);
            }
        }
    }

    private void azQ() {
        int contentSizeOfLzl = this.cOf ? TbConfig.getContentSizeOfLzl() : TbConfig.getContentSize();
        this.cKX.cMx = contentSizeOfLzl;
        this.cKX.cMw = contentSizeOfLzl;
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
            ab.registerListener(this.cOn);
        }
        if (eVar != null) {
            this.cKV = eVar.azH();
            this.cNK = eVar.azI();
            this.cNL = eVar.azK();
            this.cNM = eVar.azL();
            this.cKW = eVar.azJ();
            this.cNN = eVar.azM();
            if (eVar.getListView() != null && this.cNR == null) {
                this.cNR = new j(eVar.azG());
                eVar.getListView().setRecyclerListener(this.cNR);
            }
        }
        this.cLc = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20);
        setOrientation(1);
        setOnHierarchyChangeListener(new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.7
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof GifView) && TbRichTextView.this.cKW != null) {
                    TbRichTextView.this.cKW.t((GifView) view2);
                } else if ((view2 instanceof ImageView) && TbRichTextView.this.cKV != null) {
                    TbRichTextView.this.cKV.t((ImageView) view2);
                } else if ((view2 instanceof TextView) && TbRichTextView.this.cNK != null) {
                    TbRichTextView.this.cNK.t((TextView) view2);
                } else if ((view2 instanceof PlayVoiceBnt) && TbRichTextView.this.cNL != null) {
                    TbRichTextView.this.cNL.t(view2);
                } else if ((view2 instanceof PlayVoiceBntNew) && TbRichTextView.this.cNL != null) {
                    TbRichTextView.this.cNL.t(view2);
                } else if (view2 instanceof GridImageLayout) {
                    int childCount = ((GridImageLayout) view2).getChildCount();
                    for (int i2 = 0; i2 < childCount; i2++) {
                        View childAt = ((GridImageLayout) view2).getChildAt(i2);
                        if ((childAt instanceof GifView) && TbRichTextView.this.cKW != null) {
                            TbRichTextView.this.cKW.t((GifView) childAt);
                        } else if ((childAt instanceof ImageView) && TbRichTextView.this.cKV != null) {
                            TbRichTextView.this.cKV.t((ImageView) childAt);
                        }
                    }
                    ((GridImageLayout) view2).removeAllViews();
                    ((GridImageLayout) view2).clearData();
                } else if ((view2 instanceof RelativeLayout) && TbRichTextView.this.cNN != null) {
                    TbRichTextView.this.cNN.t((RelativeLayout) view2);
                }
                if (view2 instanceof LinearLayout) {
                    Object tag = view2.getTag();
                    if (tag == null || !(tag instanceof String) || !"VideoView".equals(tag)) {
                        if (TbRichTextView.this.cNM != null) {
                            int childCount2 = ((LinearLayout) view2).getChildCount();
                            for (int i3 = 0; i3 < childCount2; i3++) {
                                View childAt2 = ((LinearLayout) view2).getChildAt(i3);
                                if (childAt2 != null) {
                                    if ((childAt2 instanceof TextView) && TbRichTextView.this.cNK != null) {
                                        TbRichTextView.this.cNK.t((TextView) childAt2);
                                    } else if ((childAt2 instanceof PlayVoiceBnt) && TbRichTextView.this.cNL != null) {
                                        TbRichTextView.this.cNL.t(childAt2);
                                    } else if ((childAt2 instanceof PlayVoiceBntNew) && TbRichTextView.this.cNL != null) {
                                        TbRichTextView.this.cNL.t(childAt2);
                                    }
                                }
                            }
                            ((LinearLayout) view2).removeAllViews();
                            TbRichTextView.this.cNM.t((LinearLayout) view2);
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
        ArrayList<TbRichTextData> ayZ;
        int i2;
        int i3;
        RelativeLayout relativeLayout;
        boolean z2;
        SpannableStringBuilder azh;
        boolean z3;
        View view;
        KeyEvent.Callback a2;
        boolean z4;
        int i4;
        int i5;
        if (this.cOc != tbRichText || (tbRichText != null && tbRichText.isChanged)) {
            if (tbRichText != null) {
                tbRichText.isChanged = false;
            }
            this.cOc = tbRichText;
            removeAllViews();
            if (tbRichText != null && (ayZ = tbRichText.ayZ()) != null) {
                View view2 = null;
                boolean z5 = true;
                Iterator<TbRichTextData> it = ayZ.iterator();
                boolean z6 = false;
                int i6 = 0;
                int i7 = 0;
                View view3 = null;
                while (it.hasNext()) {
                    TbRichTextData next = it.next();
                    boolean z7 = false;
                    if (next != null) {
                        if (next.getType() == 1) {
                            TextView cS = cS(getContext());
                            boolean a3 = a(next, cS, true, cVar);
                            if (z && !this.cOa && (azh = next.azh()) != null) {
                                this.cOa = azh.length() >= 200;
                            }
                            if (this.cmw != null) {
                                cS.setOnTouchListener(this.mInternalGestureDetector);
                            } else {
                                cS.setOnClickListener(this.cNT);
                            }
                            z7 = a3;
                            i2 = i7;
                            i3 = i6;
                            relativeLayout = cS;
                            z2 = z6;
                        } else if (next.getType() == 8) {
                            if (!this.cOh) {
                                if (i6 < 10) {
                                    i6++;
                                    if (next.azg() != null) {
                                        if (TbadkCoreApplication.getInst().isGifAutoPlay() && !next.azg().azz()) {
                                            GifView gifView = getGifView();
                                            b bVar = new b();
                                            bVar.cOr = true;
                                            gifView.setTag(bVar);
                                            z7 = b(next, gifView);
                                            z2 = z6;
                                            i2 = i7;
                                            i3 = i6;
                                            relativeLayout = gifView;
                                        } else {
                                            ?? cR = cR(getContext());
                                            z7 = c(next, cR, this.cKX.cMy, this.cKX.cMz);
                                            z2 = z6;
                                            i2 = i7;
                                            i3 = i6;
                                            relativeLayout = cR;
                                        }
                                    }
                                    z2 = z6;
                                    i2 = i7;
                                    i3 = i6;
                                    relativeLayout = view3;
                                }
                            } else if (!z6) {
                                GridImageLayout gridImageView = getGridImageView();
                                gridImageView.setData(tbRichText.aza());
                                z7 = true;
                                z2 = true;
                                i2 = i7;
                                i3 = i6;
                                relativeLayout = gridImageView;
                            }
                        } else if (next.getType() == 32) {
                            com.baidu.tbadk.widget.richText.f azk = next.azk();
                            if (azk != null && azk.azO()) {
                                a2 = b(azk);
                            } else {
                                a2 = a(next);
                            }
                            z2 = z6;
                            i2 = i7;
                            i3 = i6;
                            relativeLayout = a2;
                            z7 = true;
                        } else if (next.getType() == 512) {
                            View bk = bk(view2);
                            if (bk == null) {
                                view3 = bk;
                            } else {
                                z2 = z6;
                                i2 = i7;
                                i3 = i6;
                                relativeLayout = bk;
                                z7 = a(next, bk);
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
                                if (next == null || next.azm() == null || next.azm().memeInfo == null || StringUtils.isNull(next.azm().memeInfo.pic_url)) {
                                    z4 = false;
                                } else {
                                    z4 = true;
                                }
                                if (z4) {
                                    RelativeLayout iD = this.cNN.iD();
                                    iD.removeAllViews();
                                    iD.setLayoutParams(new LinearLayout.LayoutParams(next.azm().memeInfo.width.intValue(), next.azm().memeInfo.height.intValue()));
                                    if (com.baidu.tbadk.t.v.awe() && this.cNP) {
                                        b(iD, next.azm().memeInfo.width.intValue(), next.azm().memeInfo.height.intValue(), this.cKX.cMy, this.cKX.cMz);
                                    } else {
                                        a(iD, next.azm().memeInfo.width.intValue(), next.azm().memeInfo.height.intValue(), this.cKX.cMy, this.cKX.cMz);
                                    }
                                    ImageView iD2 = this.cKV.iD();
                                    b(next, iD2, this.cKX.cMy, this.cKX.cMz);
                                    if (com.baidu.tbadk.t.v.awe() && this.cNP) {
                                        ImageView iD3 = this.cKV.iD();
                                        iD3.setTag(this.cOc);
                                        if (iD3 instanceof TbImageView) {
                                            TbImageView tbImageView = (TbImageView) iD3;
                                            tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
                                            tbImageView.setBorderColor(am.getColor(R.color.black_alpha8));
                                            tbImageView.setBorderSurroundContent(true);
                                            tbImageView.setDrawCorner(true);
                                            tbImageView.setDrawBorder(true);
                                            tbImageView.setLongIconSupport(true);
                                            tbImageView.setGifIconSupport(true);
                                            tbImageView.setConrers(15);
                                            tbImageView.setRadius(this.cLc);
                                            tbImageView.setAdjustViewBounds(false);
                                            tbImageView.setDefaultBgResource(com.baidu.tbadk.util.e.Qv());
                                        }
                                        iD3.setScaleType(ImageView.ScaleType.FIT_XY);
                                        int g2 = l.g(getContext(), R.dimen.ds78);
                                        int g3 = l.g(getContext(), R.dimen.ds78);
                                        iD2.setId(R.id.meme_image_view);
                                        c(iD2, next.azm().memeInfo.width.intValue(), next.azm().memeInfo.height.intValue(), this.cKX.cMy, this.cKX.cMz, this.mOnClickListener);
                                        iD.addView(iD2);
                                        if (g3 > next.azm().memeInfo.height.intValue()) {
                                            i5 = g2 / 2;
                                            i4 = g3 / 2;
                                        } else {
                                            i4 = g3;
                                            i5 = g2;
                                        }
                                        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i5, i4);
                                        layoutParams.addRule(8, R.id.meme_image_view);
                                        layoutParams.addRule(11);
                                        iD3.setOnClickListener(this.mOnClickListener);
                                        if (iD.getLeft() > 0) {
                                            layoutParams.rightMargin = l.g(getContext(), R.dimen.ds6);
                                        }
                                        am.c(iD3, (int) R.drawable.icon_emotion_dui_n);
                                        iD.addView(iD3, layoutParams);
                                    } else {
                                        b(iD2, next.azm().memeInfo.width.intValue(), next.azm().memeInfo.height.intValue(), this.cKX.cMy, this.cKX.cMz, this.mOnClickListener);
                                        iD.addView(iD2);
                                    }
                                    z7 = z4;
                                    z2 = z6;
                                    i2 = i8;
                                    i3 = i6;
                                    relativeLayout = iD;
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
                                ImageView cR2 = cR(getContext());
                                z7 = a(next, cR2, (this.cKX.cMy - getPaddingLeft()) - getPaddingRight(), this.cKX.cMz);
                                z2 = z6;
                                i2 = i7;
                                i3 = i6 + 1;
                                relativeLayout = cR2;
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
                            if (z5 && this.cKX.cMO >= 0) {
                                z5 = false;
                                if (layoutParams2 != null) {
                                    layoutParams2.topMargin = this.cKX.cMO;
                                    relativeLayout.setLayoutParams(layoutParams2);
                                    z3 = false;
                                    view = relativeLayout;
                                }
                                z3 = z5;
                                view = relativeLayout;
                            } else if (relativeLayout instanceof TbListTextView) {
                                if ((view2 instanceof ImageView) || (view2 instanceof RelativeLayout)) {
                                    layoutParams2.topMargin = this.cKX.cMK;
                                } else {
                                    layoutParams2.topMargin = this.cKX.cMu;
                                }
                                relativeLayout.setLayoutParams(layoutParams2);
                                z3 = z5;
                                view = relativeLayout;
                            } else {
                                if (((relativeLayout instanceof ImageView) || (relativeLayout instanceof RelativeLayout)) && (next.getType() == 8 || next.getType() == 20 || next.getType() == 17)) {
                                    if (view2 instanceof TbListTextView) {
                                        layoutParams2.topMargin = this.cKX.cMI;
                                    } else if ((view2 instanceof ImageView) || (relativeLayout instanceof RelativeLayout)) {
                                        layoutParams2.topMargin = this.cKX.cMH;
                                    } else {
                                        layoutParams2.topMargin = this.cKX.cMu;
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
                    layoutParams3.bottomMargin = this.cKX.cMN;
                    view2.setLayoutParams(layoutParams3);
                } else if (view2 != null && this.cKX.cMM >= 0) {
                    LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) view2.getLayoutParams();
                    layoutParams4.bottomMargin = this.cKX.cMM;
                    view2.setLayoutParams(layoutParams4);
                }
            }
        }
    }

    private GridImageLayout getGridImageView() {
        if (this.cNO == null || this.cNO.getParent() != null) {
            this.cNO = new GridImageLayout(getContext());
            this.cNO.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        }
        this.cNO.setLayoutStrategy(this.cKX);
        this.cNO.setObjectPool(this.cKV, this.cKW);
        this.cNO.setOnImageClickListener(this.cLe);
        this.cNO.setIsHost(this.isHost);
        return this.cNO;
    }

    public void setCommonTextViewOnClickListener(View.OnClickListener onClickListener) {
        this.cNT = onClickListener;
    }

    private View b(final com.baidu.tbadk.widget.richText.f fVar) {
        if (fVar == null || !fVar.isAvaliable()) {
            return null;
        }
        ImageView iD = this.cKV.iD();
        if (iD instanceof ForeDrawableImageView) {
            ForeDrawableImageView foreDrawableImageView = (ForeDrawableImageView) iD;
            foreDrawableImageView.setForegroundDrawable(R.drawable.icon_play_video);
            foreDrawableImageView.setNoImageBottomTextColor(R.color.cp_cont_c);
            foreDrawableImageView.setNoImageBottomTextPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds32));
            foreDrawableImageView.setNoImageBottomTextSize(TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.fontsize28));
            foreDrawableImageView.setNoImageBottomText("点击播放视频");
            foreDrawableImageView.setInterceptOnClick(false);
            foreDrawableImageView.setTag("VideoView");
            b(foreDrawableImageView, fVar.getWidth(), fVar.getHeight(), (this.cKX.cMy - getPaddingLeft()) - getPaddingRight(), this.cKX.cMz, new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log("c10643");
                    XiaoyingUtil.startPlayXiaoyingVideo(TbRichTextView.this.getContext(), fVar.getVideoUrl(), fVar.getWidth(), fVar.getHeight(), fVar.getThumbUrl());
                }
            });
            foreDrawableImageView.setDefaultResource(0);
            foreDrawableImageView.setSupportNoImage(this.cKX.cMF);
            if (com.baidu.tbadk.core.i.ace().aci()) {
                foreDrawableImageView.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            } else {
                foreDrawableImageView.setDefaultBgResource(R.color.cp_bg_line_c);
            }
            foreDrawableImageView.startLoad(fVar.getThumbUrl(), 17, false);
            return iD;
        }
        return iD;
    }

    private boolean a(ImageView imageView, int i2, int i3, int i4, int i5, View.OnClickListener onClickListener) {
        int[] s = this.cKX.s(i2, i3, i4, i5);
        if (s == null) {
            return false;
        }
        int i6 = s[0];
        int i7 = s[1];
        if (imageView instanceof TbImageView) {
            TbImageView tbImageView = (TbImageView) imageView;
            tbImageView.setDefaultResource(this.cKX.cMA);
            if (tbImageView.getGifIconWidth() >= i6 || tbImageView.getGifIconHeight() >= i7) {
                tbImageView.setGifIconSupport(false);
            } else {
                tbImageView.setGifIconSupport(true);
            }
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i6, i7);
        if (this.cKX.cMG) {
            imageView.setScaleType(this.cKX.cME);
            if (imageView instanceof TbImageView) {
                ((TbImageView) imageView).setOnDrawListener(this.cKX.mOnDrawListener);
            }
        } else {
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        }
        imageView.setClickable(true);
        imageView.setFocusable(false);
        if (this.cmw != null && (imageView instanceof TbImageView)) {
            ((TbImageView) imageView).setTbGestureDetector(this.mInternalGestureDetector);
            imageView.setClickable(true);
        } else {
            imageView.setOnClickListener(onClickListener);
        }
        imageView.setLayoutParams(layoutParams);
        if (imageView instanceof TbImageView) {
            if (this.onLongClickListener != null) {
                ((TbImageView) imageView).setDispatchTouchListener(this.cOk);
                imageView.setOnLongClickListener(this.onLongClickListener);
            }
        } else if ((imageView instanceof GifView) && this.onLongClickListener != null) {
            ((GifView) imageView).setDispatchTouchListener(this.cOk);
            imageView.setOnLongClickListener(this.onLongClickListener);
        }
        return true;
    }

    private boolean b(ImageView imageView, int i2, int i3, int i4, int i5, View.OnClickListener onClickListener) {
        int i6;
        int[] e2 = l.e(i2, i3, i4, i5);
        if (e2 == null) {
            return false;
        }
        int[] iArr = {e2[0], e2[1]};
        int i7 = iArr[0];
        int i8 = iArr[1];
        if (!this.cKX.cMG || i4 <= i7 || cMr <= 1.0f) {
            i4 = i7;
            i6 = i8;
        } else {
            if (i7 * cMr <= i4) {
                if (i7 * cMr > i4 * 0.68f) {
                    i4 = (int) (i4 * 0.68f);
                } else {
                    i4 = (int) (i7 * cMr);
                }
            }
            i6 = iArr[0] > 0 ? (iArr[1] * i4) / iArr[0] : i8;
        }
        if (imageView instanceof TbImageView) {
            TbImageView tbImageView = (TbImageView) imageView;
            tbImageView.setDefaultResource(this.cKX.cMA);
            if (tbImageView.getGifIconWidth() >= i4 || tbImageView.getGifIconHeight() >= i6) {
                tbImageView.setGifIconSupport(false);
            } else {
                tbImageView.setGifIconSupport(true);
            }
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i4, i6);
        if (this.cKX.cMG) {
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        } else {
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        }
        imageView.setClickable(true);
        imageView.setFocusable(false);
        if (this.cmw != null && (imageView instanceof TbImageView)) {
            ((TbImageView) imageView).setTbGestureDetector(this.mInternalGestureDetector);
            imageView.setClickable(true);
        } else {
            imageView.setOnClickListener(onClickListener);
        }
        imageView.setLayoutParams(layoutParams);
        if (imageView instanceof TbImageView) {
            if (this.onLongClickListener != null) {
                ((TbImageView) imageView).setDispatchTouchListener(this.cOk);
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
        int[] e2 = l.e(i2, i3, i4, i5);
        if (e2 == null) {
            return false;
        }
        int[] iArr = {e2[0], e2[1]};
        int i8 = iArr[0];
        int i9 = iArr[1];
        if (this.cKX.cMG && i4 > i8 && cMr > 1.0f) {
            if (i8 * cMr > i4) {
                i8 = (i4 - l.g(getContext(), R.dimen.ds78)) - l.g(getContext(), R.dimen.ds16);
            } else if (i8 * cMr > i4 * 0.68f) {
                i8 = ((int) (i4 * 0.68f)) - l.g(getContext(), R.dimen.ds78);
            } else {
                i8 = (int) (i8 * cMr);
            }
            if (iArr[0] > 0) {
                i6 = (iArr[1] * i8) / iArr[0];
                i7 = i8;
                if (imageView instanceof TbImageView) {
                    TbImageView tbImageView = (TbImageView) imageView;
                    tbImageView.setDefaultResource(this.cKX.cMA);
                    if (tbImageView.getGifIconWidth() >= i7 || tbImageView.getGifIconHeight() >= i6) {
                        tbImageView.setGifIconSupport(false);
                    } else {
                        tbImageView.setGifIconSupport(true);
                    }
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i7, i6);
                if (!this.cKX.cMG) {
                    imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                } else {
                    imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                }
                imageView.setClickable(true);
                imageView.setFocusable(false);
                if (this.cmw == null && (imageView instanceof TbImageView)) {
                    ((TbImageView) imageView).setTbGestureDetector(this.mInternalGestureDetector);
                    imageView.setClickable(true);
                } else {
                    imageView.setOnClickListener(onClickListener);
                }
                imageView.setLayoutParams(layoutParams);
                if (!(imageView instanceof TbImageView)) {
                    if (this.onLongClickListener != null) {
                        ((TbImageView) imageView).setDispatchTouchListener(this.cOk);
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
        if (!this.cKX.cMG) {
        }
        imageView.setClickable(true);
        imageView.setFocusable(false);
        if (this.cmw == null) {
        }
        imageView.setOnClickListener(onClickListener);
        imageView.setLayoutParams(layoutParams2);
        if (!(imageView instanceof TbImageView)) {
        }
        return true;
    }

    private void a(RelativeLayout relativeLayout, int i2, int i3, int i4, int i5) {
        int[] e2 = l.e(i2, i3, i4, i5);
        if (e2 != null) {
            int[] iArr = {e2[0], e2[1]};
            int i6 = iArr[0];
            int i7 = iArr[1];
            if (!this.cKX.cMG || i4 <= i6 || cMr <= 1.0f) {
                i4 = i6;
            } else {
                if (i6 * cMr <= i4) {
                    if (i6 * cMr > i4 * 0.68f) {
                        i4 = (int) (i4 * 0.68f);
                    } else {
                        i4 = (int) (i6 * cMr);
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
        int[] e2 = l.e(i2, i3, i4, i5);
        if (e2 != null) {
            int[] iArr = {e2[0], e2[1]};
            int i8 = iArr[0];
            int i9 = iArr[1];
            if (this.cKX.cMG && i4 > i8 && cMr > 1.0f) {
                if (i8 * cMr > i4) {
                    i7 = (i4 - l.g(getContext(), R.dimen.ds78)) - l.g(getContext(), R.dimen.ds16);
                } else if (i8 * cMr > i4 * 0.68f) {
                    i7 = ((int) (i4 * 0.68f)) - l.g(getContext(), R.dimen.ds78);
                } else {
                    i7 = (int) (i8 * cMr);
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
        if (this.cKX.cMB <= 0 || tbRichTextData == null) {
            return null;
        }
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setTag("VideoView");
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = this.cKX.cMu;
        linearLayout.setClickable(true);
        Bitmap ij = am.ij(this.cKX.cMB);
        if (ij != null) {
            linearLayout.setBackgroundDrawable(new BitmapDrawable(getContext().getResources(), ij));
        }
        linearLayout.setFocusable(false);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (tbRichTextData.azh() != null) {
                    if (TbRichTextView.this.getContext() instanceof com.baidu.tbadk.widget.richText.e) {
                        ((com.baidu.tbadk.widget.richText.e) TbRichTextView.this.getContext()).am(TbRichTextView.this.getContext(), tbRichTextData.azh().toString());
                        return;
                    }
                    com.baidu.adp.base.e<?> ab = com.baidu.adp.base.i.ab(TbRichTextView.this.getContext());
                    if (ab != null && (ab.getOrignalPage() instanceof com.baidu.tbadk.widget.richText.e)) {
                        ((com.baidu.tbadk.widget.richText.e) ab.getOrignalPage()).am(TbRichTextView.this.getContext(), tbRichTextData.azh().toString());
                    }
                }
            }
        });
        return linearLayout;
    }

    private ImageView cR(Context context) {
        ImageView iD = this.cKV != null ? this.cKV.iD() : null;
        if (iD == null || iD.getParent() != null) {
            iD = null;
        }
        if (iD != null) {
            iD.setContentDescription(context.getString(R.string.editor_image));
        }
        return iD;
    }

    private boolean a(TbRichTextData tbRichTextData, ImageView imageView, int i2, int i3) {
        if (tbRichTextData == null || imageView == null) {
            return false;
        }
        TbRichTextLinkImageInfo azo = tbRichTextData.azo();
        if (azo != null && azo.getLink() != null) {
            if (imageView instanceof TbImageView) {
                TbImageView tbImageView = (TbImageView) imageView;
                if (this.cKX.cMF) {
                    tbImageView.setSupportNoImage(true);
                }
                tbImageView.startLoad(azo.azF(), this.mIsFromCDN ? 17 : 18, false);
                tbImageView.setTag(new d(azo.getLink()));
                if (!azo.azw()) {
                    tbImageView.setAdjustViewBounds(false);
                }
            }
            return b(imageView, azo.getWidth(), azo.getHeight(), i2, i3, this.cOj);
        }
        return false;
    }

    private boolean b(TbRichTextData tbRichTextData, ImageView imageView, int i2, int i3) {
        if (tbRichTextData == null || imageView == null) {
            return false;
        }
        if (tbRichTextData.azm() == null) {
            return false;
        }
        if (imageView instanceof TbImageView) {
            TbImageView tbImageView = (TbImageView) imageView;
            tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
            tbImageView.setBorderColor(am.getColor(R.color.black_alpha8));
            tbImageView.setBorderSurroundContent(true);
            tbImageView.setDrawCorner(true);
            tbImageView.setDrawBorder(true);
            tbImageView.setLongIconSupport(true);
            tbImageView.setGifIconSupport(true);
            tbImageView.setConrers(15);
            tbImageView.setRadius(this.cLc);
            tbImageView.setDefaultBgResource(com.baidu.tbadk.util.e.Qv());
            if (this.cKX.cMF) {
                tbImageView.setSupportNoImage(true);
            }
            tbImageView.startLoad(tbRichTextData.azm().memeInfo.pic_url, this.mIsFromCDN ? 17 : 18, false);
            tbImageView.setAdjustViewBounds(false);
            tbImageView.setTag(R.id.tag_rich_text_meme_info, tbRichTextData.azm());
        }
        return b(imageView, tbRichTextData.azm().memeInfo.width.intValue(), tbRichTextData.azm().memeInfo.height.intValue(), i2, i3, this.mOnClickListener);
    }

    private boolean c(TbRichTextData tbRichTextData, ImageView imageView, int i2, int i3) {
        if (tbRichTextData == null || imageView == null) {
            return false;
        }
        if (tbRichTextData.azg() == null) {
            return false;
        }
        if (imageView instanceof TbImageView) {
            TbImageView tbImageView = (TbImageView) imageView;
            tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
            tbImageView.setBorderColor(am.getColor(R.color.black_alpha8));
            tbImageView.setBorderSurroundContent(true);
            tbImageView.setDrawCorner(true);
            tbImageView.setDrawBorder(true);
            tbImageView.setLongIconSupport(true);
            tbImageView.setGifIconSupport(true);
            tbImageView.setConrers(15);
            tbImageView.setRadius(this.cLc);
            tbImageView.setDefaultBgResource(com.baidu.tbadk.util.e.Qv());
            if (this.cKX.cMF) {
                tbImageView.setSupportNoImage(true);
            }
            tbImageView.startLoad(this.cKX.ayY() ? tbRichTextData.azg().azr() : tbRichTextData.azg().azu(), this.mIsFromCDN ? 17 : 18, false);
            if (!tbRichTextData.azg().azw()) {
                tbImageView.setAdjustViewBounds(false);
            }
            tbImageView.setTag(R.id.tag_rich_text_meme_info, null);
        }
        return a(imageView, tbRichTextData.azg().getWidth(), tbRichTextData.azg().getHeight(), i2, i3, this.mOnClickListener);
    }

    private TextView cS(Context context) {
        TextView textView = null;
        if (this.cNK != null) {
            textView = this.cNK.iD();
        }
        if (textView == null || textView.getParent() != null) {
            textView = new TbListTextView(context);
        }
        textView.setPadding(this.cKX.bYs, 0, this.cKX.bYs, 0);
        return textView;
    }

    private boolean a(TbRichTextData tbRichTextData, TextView textView, boolean z, c cVar) {
        LinearLayout.LayoutParams layoutParams;
        if (z) {
            layoutParams = new LinearLayout.LayoutParams(-1, -2);
        } else {
            layoutParams = new LinearLayout.LayoutParams(-2, -2);
        }
        if (this.cOd) {
            layoutParams.gravity = 16;
            textView.setGravity(16);
        } else {
            layoutParams.topMargin = this.cKX.cMu;
        }
        textView.setLineSpacing(this.cKX.cMt, this.cKX.cMs);
        textView.setTextSize(0, this.cKX.cMv);
        textView.setTextColor(this.cKX.mTextColor);
        textView.setLinkTextColor(am.getColor(R.color.cp_link_tip_c));
        textView.setHighlightColor(getContext().getResources().getColor(R.color.transparent));
        textView.setSingleLine(this.cKX.cMC);
        if (this.cNQ != null) {
            textView.setEllipsize(this.cNQ);
        }
        if (this.mMaxWidth > 0) {
            textView.setMaxWidth(this.mMaxWidth);
        }
        if (this.aQG > 0) {
            textView.setMaxLines(this.aQG);
        }
        if (tbRichTextData == null) {
            return false;
        }
        SpannableStringBuilder azh = tbRichTextData.azh();
        if (azh == null || azh.length() <= 0) {
            return false;
        }
        if (this.cKX.cMx > 0 && this.cKX.cMw > 0) {
            tbRichTextData.ax(this.cKX.cMw, this.cKX.cMx);
        }
        if (cVar != null) {
            cVar.a(azh, textView, this);
        }
        try {
            textView.setText(azh);
        } catch (Exception e2) {
            textView.setText("");
        }
        if (this.cOe) {
            if (tbRichTextData.azq()) {
                textView.setMovementMethod(com.baidu.tieba.view.c.czb());
            } else {
                textView.setMovementMethod(LinkMovementMethod.getInstance());
            }
        }
        textView.setFocusable(false);
        textView.setLayoutParams(layoutParams);
        textView.setTag(tbRichTextData);
        if (tbRichTextData != null && tbRichTextData.azj() != null) {
            tbRichTextData.azj().needRecompute = this.cOl;
        }
        return true;
    }

    private GifView getGifView() {
        GifView gifView = null;
        if (this.cKW != null) {
            gifView = this.cKW.iD();
        }
        GifView gifView2 = (gifView == null || gifView.getParent() != null) ? new GifView(getContext()) : gifView;
        gifView2.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        gifView2.setBorderColor(am.getColor(R.color.black_alpha8));
        gifView2.setBorderSurroundContent(true);
        gifView2.setDrawCorner(true);
        gifView2.setDrawBorder(true);
        gifView2.setConrers(15);
        gifView2.setDrawBorder(true);
        gifView2.setRadius(this.cLc);
        gifView2.setDefaultBgResource(com.baidu.tbadk.util.e.Qv());
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
        if (layoutParams == null || layoutParams.width != tbRichTextData.azl().mGifInfo.mGifWidth || layoutParams.height != tbRichTextData.azl().mGifInfo.mGifHeight) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(tbRichTextData.azl().mGifInfo.mGifWidth, tbRichTextData.azl().mGifInfo.mGifHeight);
            layoutParams2.gravity = 3;
            gifView.setLayoutParams(layoutParams2);
        } else {
            layoutParams.bottomMargin = 0;
        }
        gifView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (TbRichTextView.this.cOb != null) {
                    TbRichTextEmotionInfo azl = tbRichTextData.azl();
                    TbRichTextView.this.cOb.a(view, azl.mGifInfo.mGid, azl.mGifInfo.mPackageName, azl.mGifInfo.mIcon, azl.mGifInfo.mStaticUrl, azl.mGifInfo.mDynamicUrl, azl.mGifInfo.mSharpText, azl.mGifInfo.mGifWidth, azl.mGifInfo.mGifHeight);
                }
            }
        });
        gifView.a(tbRichTextData.azl().mGifInfo);
        return true;
    }

    private boolean b(TbRichTextData tbRichTextData, GifView gifView) {
        if (gifView == null) {
            return false;
        }
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            gifView.setDefaultNoImageDay(am.b(getContext().getResources(), (int) R.drawable.icon_click));
        } else {
            gifView.setDefaultNoImageDay(R.drawable.icon_click);
        }
        Drawable drawable = am.getDrawable(com.baidu.tbadk.util.e.Qv());
        if (drawable != null) {
            gifView.setBackgroundDrawable(drawable);
        } else {
            gifView.setBackgroundDrawable(am.getDrawable(R.color.common_color_10220));
        }
        String azv = tbRichTextData.azg().azv();
        if (StringUtils.isNull(azv)) {
            if (this.cKX.cMP) {
                azv = this.cKX.mIsFromCDN ? tbRichTextData.azg().azr() : tbRichTextData.azg().azt();
            }
            if (StringUtils.isNull(azv)) {
                azv = this.cKX.mIsFromCDN ? tbRichTextData.azg().azu() : tbRichTextData.azg().getSrc();
            }
        }
        gifView.setShowStaticDrawable(false);
        gifView.Z(azv, 38);
        return a(gifView, tbRichTextData.azg().getWidth(), tbRichTextData.azg().getHeight(), this.cKX.cMy, this.cKX.cMz, this.mOnClickListener);
    }

    private View bk(View view) {
        View iD = this.cNL != null ? this.cNL.iD() : null;
        if ((iD == null || iD.getParent() != null) && this.cNV != -1) {
            iD = LayoutInflater.from(getContext()).inflate(this.cNV, (ViewGroup) null);
        }
        if (iD != null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            if ((view instanceof TbListTextView) && this.cKX.cMJ >= 0) {
                layoutParams.topMargin = this.cKX.cMJ;
            } else {
                layoutParams.topMargin = this.cKX.cMu;
            }
            layoutParams.bottomMargin = this.cKX.cML;
            iD.setLayoutParams(layoutParams);
            if (iD instanceof PlayVoiceBntNew) {
                ((PlayVoiceBntNew) iD).setAfterClickListener(this.cNW);
                return iD;
            }
            return iD;
        }
        return null;
    }

    private boolean a(TbRichTextData tbRichTextData, View view) {
        view.setTag(tbRichTextData.azi());
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LinearLayout.LayoutParams(-2, -2);
        }
        view.setLayoutParams(layoutParams);
        return true;
    }

    private View getTextVoiceView() {
        LinearLayout iD = this.cNM.iD();
        if (iD != null) {
            TextView cS = cS(getContext());
            if (cS == null) {
                this.cNM.t(iD);
                return null;
            }
            iD.addView(cS);
            View bk = bk(null);
            if (bk == null) {
                this.cNK.t(cS);
                this.cNM.t(iD);
                return null;
            }
            iD.addView(bk);
            return iD;
        }
        return iD;
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
        if (f2 != this.cKX.cMv) {
            this.cKX.cMv = f2;
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
        if (i2 != this.cKX.mTextColor) {
            this.cKX.mTextColor = i2;
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
        if (this.cKX.bYs != i2) {
            this.cKX.bYs = i2;
            int childCount = getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                if (childAt != null && (childAt instanceof TextView)) {
                    ((TextView) childAt).setPadding(this.cKX.bYs, 0, 0, this.cKX.bYs);
                }
            }
        }
    }

    public void setLinkTextColor(int i2) {
        if (i2 != this.cKX.cMD) {
            this.cKX.cMD = i2;
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
        this.cNP = z;
    }

    public h getOnImageClickListener() {
        return this.cLe;
    }

    public void setOnImageClickListener(h hVar) {
        this.cLe = hVar;
        if (this.cNO != null) {
            this.cNO.setOnImageClickListener(this.cLe);
        }
    }

    public void setOnImageTouchListener(com.baidu.tieba.pb.a.c cVar) {
        this.cmw = cVar;
    }

    public void setOnEmotionClickListener(g gVar) {
        this.cOb = gVar;
    }

    public void setDisplayImage(boolean z, boolean z2) {
        if (this.cNU != z) {
            this.cNU = z;
            if (z2) {
                requestLayout();
            }
            if (!this.cNU && this.cKV != null) {
                this.cKV.clear();
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
        this.cNX = false;
        switch (motionEvent.getAction()) {
            case 1:
            case 3:
                if (!this.cNY) {
                    azS();
                    break;
                }
                break;
        }
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        switch (motionEvent.getAction()) {
            case 0:
                if (!this.cNX) {
                    azR();
                    break;
                }
                break;
        }
        return dispatchTouchEvent;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.cNY && (motionEvent.getAction() == 3 || motionEvent.getAction() == 1)) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.cNX = true;
        return super.onTouchEvent(motionEvent);
    }

    private void azR() {
        this.cNY = false;
        if (this.cNZ == null) {
            this.cNZ = new a();
        }
        postDelayed(this.cNZ, ViewConfiguration.getLongPressTimeout());
    }

    private void azS() {
        if (this.cNZ != null) {
            removeCallbacks(this.cNZ);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!TbRichTextView.this.cOg && TbRichTextView.this.performLongClick()) {
                TbRichTextView.this.cNY = true;
            }
        }
    }

    public void setVoiceViewRes(int i2) {
        this.cNV = i2;
    }

    public void setOnVoiceAfterClickListener(View.OnClickListener onClickListener) {
        this.cNW = onClickListener;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.cOm != drawable) {
            this.cOl = true;
            this.cOm = drawable;
        }
        setText(this.cOc);
        this.cOl = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.cKX != null) {
            this.cKX.release();
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
        this.cOi = eVar;
        rN(str);
    }

    public void rN(String str) {
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
        com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) com.baidu.adp.lib.f.c.iE().b(this.mUrl, 19, new Object[0]);
        if (aVar != null) {
            f(aVar);
        } else if (z) {
            invalidate();
        } else if (!com.baidu.adp.lib.f.c.iE().aj(19)) {
            invalidate();
        } else {
            com.baidu.adp.lib.f.c.iE().a(this.mUrl, 19, this.mCallback, 0, 0, this.mPageId, new Object[0]);
        }
    }

    public void stopLoad() {
        if (!TextUtils.isEmpty(this.mUrl)) {
            com.baidu.adp.lib.f.c.iE().a(this.mUrl, 19, this.mCallback);
            setBackgroundDrawable(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null) {
            try {
                NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(getResources(), aVar.nK(), aVar.nK().getNinePatchChunk(), aVar.nO(), null);
                if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                    ninePatchDrawable.getPaint().setAlpha(80);
                }
                setBackgroundDrawable(ninePatchDrawable);
                if (this.cOi != null) {
                    this.cOi.azU();
                }
            } catch (Exception e2) {
            }
        }
    }

    @Override // com.baidu.adp.newwidget.ImageView.h
    public void refresh() {
        rN(this.mUrl);
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
        return this.cNS;
    }

    public void setOnLinkImageClickListener(i iVar) {
        this.cNS = iVar;
    }

    public void setHasMovementMethod(boolean z) {
        this.cOe = z;
    }

    public void setTextCenter(boolean z) {
        this.cOd = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        boolean cOr;

        private b() {
        }
    }
}
