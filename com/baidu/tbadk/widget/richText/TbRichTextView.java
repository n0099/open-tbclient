package com.baidu.tbadk.widget.richText;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.support.v4.view.ViewCompat;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.b.a.i;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.h;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.gif.GifView;
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
public class TbRichTextView extends LinearLayout implements i {
    private static final int aRp = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds32);
    private static final int aRq = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds48);
    private static final float aRr = k.ai(TbadkCoreApplication.getInst());
    private static final float aRs;
    static int aRt;
    private final View.OnTouchListener aMT;
    private final com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> aMm;
    private final com.baidu.tieba.pb.a.c aOD;
    private float aRA;
    private int aRB;
    private int aRC;
    private float aRD;
    private int aRE;
    private int aRF;
    private int aRG;
    private int aRH;
    private int aRI;
    private int aRJ;
    private boolean aRK;
    private TextUtils.TruncateAt aRL;
    private g aRM;
    private e aRN;
    private com.baidu.tieba.pb.a.c aRO;
    private f aRP;
    private View.OnClickListener aRQ;
    private boolean aRR;
    private int aRS;
    private boolean aRT;
    private boolean aRU;
    private Runnable aRV;
    private boolean aRW;
    private d aRX;
    private boolean aRY;
    private TbRichText aRZ;
    private com.baidu.adp.lib.e.b<ImageView> aRu;
    private com.baidu.adp.lib.e.b<TextView> aRv;
    private com.baidu.adp.lib.e.b<View> aRw;
    private com.baidu.adp.lib.e.b<View> aRx;
    private com.baidu.adp.lib.e.b<LinearLayout> aRy;
    private com.baidu.adp.lib.e.b<GifView> aRz;
    private String aSa;
    private boolean aSb;
    private boolean aSc;
    private boolean aSd;
    private int aSe;
    private boolean aSf;
    private boolean aSg;
    private boolean aSh;
    private boolean aSi;
    private int aSj;
    private int aSk;
    private boolean aSl;
    private boolean aSm;
    private boolean aSn;
    public final View.OnClickListener aSo;
    private final TbImageView.b aSp;
    private boolean aSq;
    private Drawable aSr;
    private CustomMessageListener aSs;
    private int mDefaultImageId;
    private boolean mIsFromCDN;
    private final View.OnClickListener mOnClickListener;
    private BdUniqueId mPageId;
    private int mTextColor;
    private final int mType;
    private String mUrl;
    private int mp;
    private ImageView.ScaleType mq;
    private View.OnLongClickListener onLongClickListener;

    /* loaded from: classes.dex */
    public interface b {
        void a(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView);
    }

    /* loaded from: classes.dex */
    public interface d {
        void a(View view, String str, String str2, String str3, String str4, String str5, String str6, int i, int i2);
    }

    /* loaded from: classes.dex */
    public interface e {
        void a(View view, String str, int i);
    }

    /* loaded from: classes.dex */
    public interface f {
        void b(View view, String str);
    }

    static {
        aRs = aRr > 0.0f ? 1.0f / aRr : 0.3f;
        aRt = 174;
    }

    public void setSubPbPost(boolean z) {
        this.aSl = z;
    }

    public void setShowGraffitiSaveBtn(boolean z) {
        this.aSn = z;
    }

    public boolean Jb() {
        return this.aRW;
    }

    public void Jc() {
        this.aSb = true;
    }

    public String getBackgroundImageUrl() {
        return this.aSa;
    }

    public void setBackgroundImageUrl(String str) {
        this.aSa = str;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public void setMaxWidth(int i) {
        this.mp = i;
    }

    public void setMaxLines(int i) {
        this.aSe = i;
    }

    public void setTextEllipsize(TextUtils.TruncateAt truncateAt) {
        this.aRL = truncateAt;
    }

    public void setIsSupportVitality(boolean z) {
        this.aSh = z;
    }

    public boolean getIsSupportVitality() {
        return this.aSh;
    }

    public void setIsSupportNewFirstFloor(boolean z) {
        this.aSi = z;
    }

    public void setPbFirstFloorLastTextToBottom(int i) {
        this.aSj = i;
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
        super.setOnLongClickListener(onLongClickListener);
    }

    public float getLineSpacing() {
        return this.aRA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c {
        public String url;

        public c(String str) {
            this.url = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean M(View view) {
        if ((view instanceof ImageView) && !(view instanceof GifView)) {
            if ((view instanceof TbImageView) && view.getTag() != null) {
                if (view.getTag() instanceof c) {
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

    public static TbRichText a(Context context, JSONArray jSONArray, int i) {
        return new TbRichText(context, jSONArray, i);
    }

    public static TbRichText a(Context context, JSONArray jSONArray, boolean z) {
        return new TbRichText(context, jSONArray, z);
    }

    public static TbRichText b(Context context, List<PbContent> list, boolean z) {
        return new TbRichText(context, list, z);
    }

    public static com.baidu.adp.lib.e.b<TextView> l(final Context context, int i) {
        return new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<TextView>() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: Jf */
            public TextView fT() {
                return new TbListTextView(context);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public void o(TextView textView) {
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
            /* renamed from: d */
            public TextView p(TextView textView) {
                return textView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: e */
            public TextView q(TextView textView) {
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
        }, i, 0);
    }

    public TbRichTextView(Context context) {
        super(context);
        this.aRu = null;
        this.aRv = null;
        this.aRw = null;
        this.aRx = null;
        this.aRy = null;
        this.aRz = null;
        this.aRA = 0.0f;
        this.aRB = 0;
        this.aRC = 0;
        this.aRD = 15.0f;
        this.aRE = -1;
        this.aRF = -1;
        this.mTextColor = ViewCompat.MEASURED_STATE_MASK;
        this.aRG = -9989158;
        this.aRH = 200;
        this.aRI = 200;
        this.mq = null;
        this.mDefaultImageId = 0;
        this.aRJ = 0;
        this.aRK = false;
        this.aRL = null;
        this.aRM = null;
        this.aRN = null;
        this.aRO = null;
        this.aRP = null;
        this.aRQ = null;
        this.aRR = true;
        this.mIsFromCDN = true;
        this.aRS = -1;
        this.aRT = false;
        this.aRU = false;
        this.aRV = null;
        this.aRW = false;
        this.aRY = true;
        this.aSa = null;
        this.aSb = false;
        this.aSc = false;
        this.mp = -1;
        this.aSe = -1;
        this.aSf = true;
        this.aSg = false;
        this.aSh = false;
        this.aSi = false;
        this.aSj = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds34);
        this.aSl = false;
        this.aSm = false;
        this.aSn = true;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                if (TbRichTextView.this.aRN != null && (view instanceof ImageView)) {
                    Object tag = view.getTag();
                    if (tag != null && (tag instanceof String)) {
                        str = (String) tag;
                    } else if (!(view instanceof TbImageView)) {
                        str = null;
                    } else {
                        str = ((TbImageView) view).getUrl();
                    }
                    int childCount = TbRichTextView.this.getChildCount();
                    int i = -1;
                    for (int i2 = 0; i2 < childCount; i2++) {
                        View childAt = TbRichTextView.this.getChildAt(i2);
                        if (TbRichTextView.this.M(childAt)) {
                            i++;
                        }
                        if (view == childAt) {
                            break;
                        }
                    }
                    TbRichTextView.this.aRN.a(view, str, i);
                }
            }
        };
        this.aOD = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.5
            @Override // com.baidu.tieba.pb.a.c.a
            public boolean a(View view, MotionEvent motionEvent) {
                if (TbRichTextView.this.aRO != null) {
                    TbRichTextView.this.aRO.aZ(view);
                    return TbRichTextView.this.aRO.onDoubleTap(motionEvent);
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
        this.aSo = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                if (TbRichTextView.this.aRP != null && (view instanceof TbImageView)) {
                    Object tag = view.getTag();
                    if (tag == null || !(tag instanceof c)) {
                        str = null;
                    } else {
                        str = ((c) tag).url;
                    }
                    TbRichTextView.this.aRP.b(view, str);
                }
            }
        };
        this.aMT = new View.OnTouchListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.12
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    TbRichTextView.this.aSg = true;
                } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                    TbRichTextView.this.aSg = false;
                }
                return false;
            }
        };
        this.aSp = new TbImageView.b() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.2
            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void n(MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    TbRichTextView.this.aSm = true;
                } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                    TbRichTextView.this.aSm = false;
                }
            }
        };
        this.mType = 19;
        this.aMm = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.3
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
                TbRichTextView.this.e(aVar);
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
        this.aSs = new CustomMessageListener(CmdConfigCustom.PB_RICHTEXT_CHANGE_CMD) { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (TbRichTextView.this.aSl) {
                    TbRichTextView.this.setTextSize(TbConfig.getContentSizeOfLzl(TbRichTextView.this.getContext()));
                } else {
                    TbRichTextView.this.setTextSize(TbConfig.getContentSize());
                }
            }
        };
        init();
    }

    public TbRichTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aRu = null;
        this.aRv = null;
        this.aRw = null;
        this.aRx = null;
        this.aRy = null;
        this.aRz = null;
        this.aRA = 0.0f;
        this.aRB = 0;
        this.aRC = 0;
        this.aRD = 15.0f;
        this.aRE = -1;
        this.aRF = -1;
        this.mTextColor = ViewCompat.MEASURED_STATE_MASK;
        this.aRG = -9989158;
        this.aRH = 200;
        this.aRI = 200;
        this.mq = null;
        this.mDefaultImageId = 0;
        this.aRJ = 0;
        this.aRK = false;
        this.aRL = null;
        this.aRM = null;
        this.aRN = null;
        this.aRO = null;
        this.aRP = null;
        this.aRQ = null;
        this.aRR = true;
        this.mIsFromCDN = true;
        this.aRS = -1;
        this.aRT = false;
        this.aRU = false;
        this.aRV = null;
        this.aRW = false;
        this.aRY = true;
        this.aSa = null;
        this.aSb = false;
        this.aSc = false;
        this.mp = -1;
        this.aSe = -1;
        this.aSf = true;
        this.aSg = false;
        this.aSh = false;
        this.aSi = false;
        this.aSj = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds34);
        this.aSl = false;
        this.aSm = false;
        this.aSn = true;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                if (TbRichTextView.this.aRN != null && (view instanceof ImageView)) {
                    Object tag = view.getTag();
                    if (tag != null && (tag instanceof String)) {
                        str = (String) tag;
                    } else if (!(view instanceof TbImageView)) {
                        str = null;
                    } else {
                        str = ((TbImageView) view).getUrl();
                    }
                    int childCount = TbRichTextView.this.getChildCount();
                    int i = -1;
                    for (int i2 = 0; i2 < childCount; i2++) {
                        View childAt = TbRichTextView.this.getChildAt(i2);
                        if (TbRichTextView.this.M(childAt)) {
                            i++;
                        }
                        if (view == childAt) {
                            break;
                        }
                    }
                    TbRichTextView.this.aRN.a(view, str, i);
                }
            }
        };
        this.aOD = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.5
            @Override // com.baidu.tieba.pb.a.c.a
            public boolean a(View view, MotionEvent motionEvent) {
                if (TbRichTextView.this.aRO != null) {
                    TbRichTextView.this.aRO.aZ(view);
                    return TbRichTextView.this.aRO.onDoubleTap(motionEvent);
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
        this.aSo = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                if (TbRichTextView.this.aRP != null && (view instanceof TbImageView)) {
                    Object tag = view.getTag();
                    if (tag == null || !(tag instanceof c)) {
                        str = null;
                    } else {
                        str = ((c) tag).url;
                    }
                    TbRichTextView.this.aRP.b(view, str);
                }
            }
        };
        this.aMT = new View.OnTouchListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.12
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    TbRichTextView.this.aSg = true;
                } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                    TbRichTextView.this.aSg = false;
                }
                return false;
            }
        };
        this.aSp = new TbImageView.b() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.2
            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void n(MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    TbRichTextView.this.aSm = true;
                } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                    TbRichTextView.this.aSm = false;
                }
            }
        };
        this.mType = 19;
        this.aMm = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.3
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
                TbRichTextView.this.e(aVar);
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
        this.aSs = new CustomMessageListener(CmdConfigCustom.PB_RICHTEXT_CHANGE_CMD) { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (TbRichTextView.this.aSl) {
                    TbRichTextView.this.setTextSize(TbConfig.getContentSizeOfLzl(TbRichTextView.this.getContext()));
                } else {
                    TbRichTextView.this.setTextSize(TbConfig.getContentSize());
                }
            }
        };
        init();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.n.TbRichTextView);
        this.aRC = obtainStyledAttributes.getDimensionPixelSize(d.n.TbRichTextView_segmentMargin, 0);
        this.aRB = obtainStyledAttributes.getDimensionPixelSize(d.n.TbRichTextView_textPadding, 0);
        this.aRA = obtainStyledAttributes.getFloat(d.n.TbRichTextView_lineSpacing, 1.12f);
        this.aRD = obtainStyledAttributes.getDimensionPixelSize(d.n.TbRichTextView_textSize, (int) this.aRD);
        this.mTextColor = obtainStyledAttributes.getColor(d.n.TbRichTextView_textColor, this.mTextColor);
        this.aRH = obtainStyledAttributes.getDimensionPixelSize(d.n.TbRichTextView_maxImageWidth, this.aRH);
        this.aRI = obtainStyledAttributes.getDimensionPixelSize(d.n.TbRichTextView_maxImageHeight, this.aRI);
        this.mDefaultImageId = obtainStyledAttributes.getResourceId(d.n.TbRichTextView_defaultImage, 0);
        this.aRE = obtainStyledAttributes.getDimensionPixelSize(d.n.TbRichTextView_faceWidth, this.aRE);
        this.aRF = obtainStyledAttributes.getDimensionPixelSize(d.n.TbRichTextView_faceHeight, this.aRF);
        this.aRJ = obtainStyledAttributes.getResourceId(d.n.TbRichTextView_videoImage, 0);
        this.aRK = obtainStyledAttributes.getBoolean(d.n.TbRichTextView_singleLine, false);
        obtainStyledAttributes.recycle();
    }

    public void setLineSpacing(float f2) {
        this.aRA = f2;
    }

    private void init() {
        aRt = getContext().getResources().getDimensionPixelSize(d.f.ds348);
        com.baidu.tbadk.widget.richText.d dVar = null;
        com.baidu.adp.base.e<?> aa = com.baidu.adp.base.i.aa(getContext());
        if (getContext() instanceof com.baidu.tbadk.widget.richText.d) {
            dVar = (com.baidu.tbadk.widget.richText.d) getContext();
        } else if (aa != null && (aa.getOrignalPage() instanceof com.baidu.tbadk.widget.richText.d)) {
            dVar = (com.baidu.tbadk.widget.richText.d) aa.getOrignalPage();
        }
        if (aa != null) {
            aa.registerListener(this.aSs);
        }
        if (dVar != null) {
            this.aRu = dVar.IS();
            this.aRv = dVar.IT();
            this.aRx = dVar.IV();
            this.aRy = dVar.IW();
            this.aRz = dVar.IU();
            this.aRw = dVar.IX();
            if (dVar.getListView() != null && this.aRM == null) {
                this.aRM = new g(dVar.IR());
                dVar.getListView().setRecyclerListener(this.aRM);
            }
        }
        setOrientation(1);
        setOnHierarchyChangeListener(new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.8
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof GifView) && TbRichTextView.this.aRz != null) {
                    TbRichTextView.this.aRz.n((GifView) view2);
                } else if ((view2 instanceof ImageView) && TbRichTextView.this.aRu != null) {
                    TbRichTextView.this.aRu.n((ImageView) view2);
                } else if ((view2 instanceof TextView) && TbRichTextView.this.aRv != null) {
                    TbRichTextView.this.aRv.n((TextView) view2);
                } else if ((view2 instanceof PlayVoiceBnt) && TbRichTextView.this.aRx != null) {
                    TbRichTextView.this.aRx.n(view2);
                } else if ((view2 instanceof com.baidu.tieba.graffiti.c) && TbRichTextView.this.aRw != null) {
                    TbRichTextView.this.aRw.n(view2);
                } else if ((view2 instanceof PlayVoiceBntNew) && TbRichTextView.this.aRx != null) {
                    TbRichTextView.this.aRx.n(view2);
                }
                if (view2 instanceof LinearLayout) {
                    Object tag = view2.getTag();
                    if (tag == null || !(tag instanceof String) || !"VideoView".equals(tag)) {
                        if (TbRichTextView.this.aRy != null) {
                            int childCount = ((LinearLayout) view2).getChildCount();
                            for (int i = 0; i < childCount; i++) {
                                View childAt = ((LinearLayout) view2).getChildAt(i);
                                if (childAt != null) {
                                    if ((childAt instanceof TextView) && TbRichTextView.this.aRv != null) {
                                        TbRichTextView.this.aRv.n((TextView) childAt);
                                    } else if ((childAt instanceof PlayVoiceBnt) && TbRichTextView.this.aRx != null) {
                                        TbRichTextView.this.aRx.n(childAt);
                                    } else if ((childAt instanceof PlayVoiceBntNew) && TbRichTextView.this.aRx != null) {
                                        TbRichTextView.this.aRx.n(childAt);
                                    }
                                }
                            }
                            ((LinearLayout) view2).removeAllViews();
                            TbRichTextView.this.aRy.n((LinearLayout) view2);
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
        this.aSk = k.ag(getContext());
    }

    public void setText(TbRichText tbRichText) {
        a(tbRichText, false);
    }

    public void a(TbRichText tbRichText, boolean z) {
        a(tbRichText, z, (b) null);
    }

    public void a(TbRichText tbRichText, boolean z, b bVar) {
        ArrayList<TbRichTextData> Io;
        boolean z2;
        int i;
        int i2;
        SpannableStringBuilder Iu;
        View view;
        View view2;
        boolean z3;
        View a2;
        if (this.aRZ != tbRichText || (tbRichText != null && tbRichText.isChanged)) {
            if (tbRichText != null) {
                tbRichText.isChanged = false;
            }
            this.aRZ = tbRichText;
            removeAllViews();
            if (tbRichText != null && (Io = tbRichText.Io()) != null) {
                boolean z4 = true;
                Iterator<TbRichTextData> it = Io.iterator();
                int i3 = 0;
                View view3 = null;
                View view4 = null;
                int i4 = 0;
                while (it.hasNext()) {
                    TbRichTextData next = it.next();
                    if (next != null) {
                        if (next.getType() == 1) {
                            TextView aW = aW(getContext());
                            boolean a3 = a(next, aW, true, bVar);
                            if (z && !this.aRW && (Iu = next.Iu()) != null) {
                                this.aRW = Iu.length() >= 200;
                            }
                            if (this.aRO != null) {
                                aW.setOnTouchListener(this.aOD);
                            } else {
                                aW.setOnClickListener(this.aRQ);
                            }
                            z2 = a3;
                            i = i4;
                            i2 = i3;
                            view = aW;
                        } else if (next.getType() == 8 && this.aRY) {
                            if (i3 < 10) {
                                ImageView aV = aV(getContext());
                                z2 = b(next, aV, this.aRH, this.aRI);
                                view = aV;
                                i = i4;
                                i2 = i3 + 1;
                            }
                        } else if (next.getType() == 32) {
                            com.baidu.tbadk.widget.richText.e Ix = next.Ix();
                            if (Ix != null && Ix.IZ()) {
                                a2 = b(Ix);
                            } else {
                                a2 = a(next);
                            }
                            view = a2;
                            z2 = true;
                            i = i4;
                            i2 = i3;
                        } else if (next.getType() == 512) {
                            view4 = getVoiceView();
                            if (view4 != null) {
                                view = view4;
                                z2 = a(next, view4);
                                i = i4;
                                i2 = i3;
                            }
                        } else if (next.getType() == 768) {
                            View textVoiceView = getTextVoiceView();
                            z2 = a(next, (LinearLayout) textVoiceView, bVar);
                            view = textVoiceView;
                            i = i4;
                            i2 = i3;
                        } else if (next.getType() == 17) {
                            View gifView = getGifView();
                            z2 = a(next, (GifView) gifView);
                            view = gifView;
                            i = i4;
                            i2 = i3;
                        } else if (next.getType() == 20 && this.aRY) {
                            if (i4 < 10) {
                                ImageView aV2 = aV(getContext());
                                z2 = b(next, aV2, this.aRH, this.aRI);
                                view = aV2;
                                i = i4 + 1;
                                i2 = i3;
                            }
                        } else if (next.getType() != 1280 || !this.aRY) {
                            if (next.getType() == 1536) {
                                TbRichTextGraffitiInfo ID = next.ID();
                                ID.fz(tbRichText.In());
                                if (ID != null) {
                                    z2 = true;
                                    view = a(ID, tbRichText.In(), tbRichText.getAuthorId());
                                    i = i4;
                                    i2 = i3;
                                }
                            }
                            view = view4;
                            z2 = false;
                            i = i4;
                            i2 = i3;
                        } else {
                            ImageView aV3 = aV(getContext());
                            z2 = a(next, aV3, (this.aRH - getPaddingLeft()) - getPaddingRight(), this.aRI);
                            view = aV3;
                            i = i4;
                            i2 = i3 + 1;
                        }
                        if (!z2 || view == null) {
                            view2 = view3;
                        } else {
                            addView(view);
                            view2 = view;
                        }
                        if (z4 && this.aSi) {
                            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
                            if (layoutParams != null) {
                                layoutParams.topMargin = k.g(getContext(), d.f.ds0);
                                view.setLayoutParams(layoutParams);
                            }
                            z3 = false;
                        } else {
                            if ((view instanceof ImageView) && (next.getType() == 8 || next.getType() == 20 || next.getType() == 17)) {
                                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) view.getLayoutParams();
                                view2.setLayoutParams(layoutParams2);
                                int g2 = k.g(getContext(), d.f.ds20);
                                int g3 = k.g(getContext(), d.f.ds4);
                                if (this.aSi) {
                                    g2 = aRq;
                                    g3 = k.g(getContext(), d.f.ds16);
                                }
                                if ((i2 == 1 && i == 0) || (i2 == 0 && i == 1)) {
                                    layoutParams2.topMargin = g2;
                                } else if (i2 > 1 || i > 1) {
                                    layoutParams2.topMargin = g3;
                                }
                                view.setLayoutParams(layoutParams2);
                            }
                            z3 = z4;
                        }
                        z4 = z3;
                        view3 = view2;
                        view4 = view;
                        i3 = i2;
                        i4 = i;
                    }
                }
                if (view3 != null && !(view3 instanceof TbListTextView)) {
                    LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) view3.getLayoutParams();
                    if (this.aSi) {
                        layoutParams3.bottomMargin = this.aSj;
                    } else {
                        layoutParams3.bottomMargin = this.aRC;
                    }
                    view3.setLayoutParams(layoutParams3);
                } else if (view3 != null && this.aSi) {
                    LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) view3.getLayoutParams();
                    layoutParams4.bottomMargin = k.g(getContext(), d.f.ds34);
                    view3.setLayoutParams(layoutParams4);
                }
            }
        }
    }

    public void setCommonTextViewOnClickListener(View.OnClickListener onClickListener) {
        this.aRQ = onClickListener;
    }

    private View b(final com.baidu.tbadk.widget.richText.e eVar) {
        if (eVar == null || !eVar.isAvaliable()) {
            return null;
        }
        ImageView fS = this.aRu.fS();
        if (fS instanceof ForeDrawableImageView) {
            ForeDrawableImageView foreDrawableImageView = (ForeDrawableImageView) fS;
            foreDrawableImageView.setForegroundDrawable(d.g.icon_play_video);
            foreDrawableImageView.setNoImageBottomTextColor(d.e.cp_cont_c);
            foreDrawableImageView.setNoImageBottomTextPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds32));
            foreDrawableImageView.setNoImageBottomTextSize(TbadkCoreApplication.getInst().getResources().getDimension(d.f.fontsize28));
            foreDrawableImageView.setNoImageBottomText("点击播放视频");
            foreDrawableImageView.setInterceptOnClick(false);
            foreDrawableImageView.setTag("VideoView");
            a(foreDrawableImageView, eVar.getWidth(), eVar.getHeight(), (this.aRH - getPaddingLeft()) - getPaddingRight(), this.aRI, new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.9
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log("c10643");
                    XiaoyingUtil.startPlayXiaoyingVideo(TbRichTextView.this.getContext(), eVar.getVideoUrl(), eVar.getWidth(), eVar.getHeight(), eVar.getThumbUrl());
                }
            });
            foreDrawableImageView.setDefaultResource(0);
            foreDrawableImageView.setSupportNoImage(this.aSb);
            if (h.oX().pd()) {
                foreDrawableImageView.setDefaultBgResource(d.g.pic_bg_video_frs);
            } else {
                foreDrawableImageView.setDefaultBgResource(d.e.cp_bg_line_c);
            }
            foreDrawableImageView.c(eVar.getThumbUrl(), 17, false);
            return fS;
        }
        return fS;
    }

    private boolean a(ImageView imageView, int i, int i2, int i3, int i4, View.OnClickListener onClickListener) {
        int i5;
        if (this.aSh && T(i, i2) && this.aSk > 0) {
            i3 = this.aSk;
            i4 = (int) (i3 * 1.618f);
        }
        int[] d2 = k.d(i, i2, i3, i4);
        if (d2 == null) {
            return false;
        }
        int[] iArr = {d2[0], d2[1]};
        int i6 = iArr[0];
        int i7 = iArr[1];
        if (!this.aSd || i3 <= i6 || aRr <= 1.0f) {
            i3 = i6;
            i5 = i7;
        } else {
            if (i6 * aRr <= i3) {
                if (i6 * aRr > i3 * 0.68f) {
                    i3 = (int) (i3 * 0.68f);
                } else {
                    i3 = (int) (i6 * aRr);
                }
            }
            i5 = iArr[0] > 0 ? (iArr[1] * i3) / iArr[0] : i7;
        }
        if (imageView instanceof TbImageView) {
            TbImageView tbImageView = (TbImageView) imageView;
            tbImageView.setDefaultResource(this.mDefaultImageId);
            if (tbImageView.getGifIconWidth() >= i3 || tbImageView.getGifIconHeight() >= i5) {
                tbImageView.setGifIconSupport(false);
            } else {
                tbImageView.setGifIconSupport(true);
            }
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i3, i5);
        if (this.aSd) {
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        } else if (this.mq == null) {
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        } else {
            imageView.setScaleType(this.mq);
        }
        if (this.aSh) {
            if (T(i, i2)) {
                layoutParams.width = -1;
                layoutParams.leftMargin = 0;
            } else {
                layoutParams.leftMargin = aRp;
            }
        }
        imageView.setClickable(true);
        imageView.setFocusable(false);
        if (this.aRO != null && (imageView instanceof TbImageView)) {
            ((TbImageView) imageView).setTbGestureDetector(this.aOD);
            imageView.setClickable(true);
        } else {
            imageView.setOnClickListener(onClickListener);
        }
        imageView.setLayoutParams(layoutParams);
        if ((imageView instanceof TbImageView) && this.onLongClickListener != null) {
            ((TbImageView) imageView).setDispatchTouchListener(this.aSp);
            imageView.setOnLongClickListener(this.onLongClickListener);
        }
        return true;
    }

    private LinearLayout a(final TbRichTextData tbRichTextData) {
        if (this.aRJ <= 0 || tbRichTextData == null) {
            return null;
        }
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setTag("VideoView");
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = this.aRC;
        linearLayout.setClickable(true);
        Bitmap cS = ai.cS(this.aRJ);
        if (cS != null) {
            linearLayout.setBackgroundDrawable(new BitmapDrawable(getContext().getResources(), cS));
        }
        linearLayout.setFocusable(false);
        if (this.aSh) {
            layoutParams.leftMargin = aRp;
            layoutParams.rightMargin = aRp;
        }
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (tbRichTextData.Iu() != null) {
                    if (TbRichTextView.this.getContext() instanceof com.baidu.tbadk.widget.richText.d) {
                        ((com.baidu.tbadk.widget.richText.d) TbRichTextView.this.getContext()).ab(TbRichTextView.this.getContext(), tbRichTextData.Iu().toString());
                        return;
                    }
                    com.baidu.adp.base.e<?> aa = com.baidu.adp.base.i.aa(TbRichTextView.this.getContext());
                    if (aa != null && (aa.getOrignalPage() instanceof com.baidu.tbadk.widget.richText.d)) {
                        ((com.baidu.tbadk.widget.richText.d) aa.getOrignalPage()).ab(TbRichTextView.this.getContext(), tbRichTextData.Iu().toString());
                    }
                }
            }
        });
        return linearLayout;
    }

    public int getVideoImageId() {
        return this.aRJ;
    }

    public void setVideoImageId(int i) {
        this.aRJ = i;
    }

    private ImageView aV(Context context) {
        ImageView fS = this.aRu != null ? this.aRu.fS() : null;
        if (fS == null || fS.getParent() != null) {
            fS = null;
        }
        if (fS != null) {
            fS.setContentDescription(context.getString(d.l.editor_image));
        }
        return fS;
    }

    private boolean a(TbRichTextData tbRichTextData, ImageView imageView, int i, int i2) {
        if (tbRichTextData == null || imageView == null) {
            return false;
        }
        TbRichTextLinkImageInfo IB = tbRichTextData.IB();
        if (IB != null && IB.getLink() != null) {
            if (imageView instanceof TbImageView) {
                TbImageView tbImageView = (TbImageView) imageView;
                if (this.aSb) {
                    tbImageView.setSupportNoImage(true);
                }
                tbImageView.c(IB.IQ(), this.mIsFromCDN ? 17 : 18, false);
                tbImageView.setTag(new c(IB.getLink()));
                if (!IB.IJ()) {
                    tbImageView.setAdjustViewBounds(false);
                }
            }
            return a(imageView, IB.getWidth(), IB.getHeight(), i, i2, this.aSo);
        }
        return false;
    }

    private boolean b(TbRichTextData tbRichTextData, ImageView imageView, int i, int i2) {
        if (tbRichTextData == null || imageView == null) {
            return false;
        }
        if (tbRichTextData.getType() == 20) {
            if (tbRichTextData.Iz() == null) {
                return false;
            }
        } else if (tbRichTextData.It() == null) {
            return false;
        }
        if (imageView instanceof TbImageView) {
            TbImageView tbImageView = (TbImageView) imageView;
            if (this.aSb) {
                tbImageView.setSupportNoImage(true);
            }
            if (tbRichTextData.getType() == 20) {
                tbImageView.c(tbRichTextData.Iz().memeInfo.pic_url, this.mIsFromCDN ? 17 : 18, false);
                tbImageView.setAdjustViewBounds(false);
                tbImageView.setTag(d.h.tag_rich_text_meme_info, tbRichTextData.Iz());
            } else {
                tbImageView.c(tbRichTextData.It().II(), this.mIsFromCDN ? 17 : 18, false);
                if (!tbRichTextData.It().IJ()) {
                    tbImageView.setAdjustViewBounds(false);
                }
                tbImageView.setTag(d.h.tag_rich_text_meme_info, null);
            }
        }
        if (tbRichTextData.getType() == 20) {
            return a(imageView, tbRichTextData.Iz().memeInfo.width.intValue(), tbRichTextData.Iz().memeInfo.height.intValue(), i, i2, this.mOnClickListener);
        }
        return a(imageView, tbRichTextData.It().getWidth(), tbRichTextData.It().getHeight(), i, i2, this.mOnClickListener);
    }

    public void setImageViewStretch(boolean z) {
        this.aSd = z;
    }

    private TextView aW(Context context) {
        TextView textView = null;
        if (this.aRv != null) {
            textView = this.aRv.fS();
        }
        if (textView == null || textView.getParent() != null) {
            textView = new TbListTextView(context);
        }
        textView.setPadding(this.aRB, 0, this.aRB, 0);
        return textView;
    }

    private boolean a(TbRichTextData tbRichTextData, TextView textView, boolean z, b bVar) {
        LinearLayout.LayoutParams layoutParams;
        if (z) {
            layoutParams = new LinearLayout.LayoutParams(-1, -2);
        } else {
            layoutParams = new LinearLayout.LayoutParams(-2, -2);
        }
        if (this.aSc) {
            layoutParams.gravity = 16;
            textView.setGravity(16);
        } else {
            layoutParams.topMargin = this.aRC;
        }
        textView.setLineSpacing(0.0f, this.aRA);
        textView.setTextSize(0, this.aRD);
        textView.setTextColor(this.mTextColor);
        textView.setLinkTextColor(ai.getColor(d.e.cp_link_tip_c));
        textView.setHighlightColor(getContext().getResources().getColor(d.e.transparent));
        textView.setSingleLine(this.aRK);
        if (this.aRL != null) {
            textView.setEllipsize(this.aRL);
        }
        if (this.mp > 0) {
            textView.setMaxWidth(this.mp);
        }
        if (this.aSe > 0) {
            textView.setMaxLines(this.aSe);
        }
        if (tbRichTextData == null) {
            return false;
        }
        SpannableStringBuilder Iu = tbRichTextData.Iu();
        if (Iu == null || Iu.length() <= 0) {
            return false;
        }
        int lineHeight = textView.getLineHeight();
        int textSize = lineHeight - ((int) textView.getTextSize());
        if (this.aSi) {
            this.aRE = k.g(getContext(), d.f.ds40);
            this.aRF = k.g(getContext(), d.f.ds40);
        }
        if (this.aRF > 0 && this.aRE > 0) {
            tbRichTextData.R(this.aRE, this.aRF);
        }
        if (textSize > 0) {
            tbRichTextData.Q(lineHeight, textSize);
        }
        if (bVar != null) {
            bVar.a(Iu, textView, this);
        }
        try {
            textView.setText(Iu);
        } catch (Exception e2) {
            textView.setText("");
        }
        if (this.aSf) {
            if (tbRichTextData.IE()) {
                textView.setMovementMethod(com.baidu.tieba.view.b.bxm());
            } else {
                textView.setMovementMethod(LinkMovementMethod.getInstance());
            }
        }
        textView.setFocusable(false);
        if (this.aSi) {
            textView.setLineSpacing(k.g(getContext(), d.f.ds8), 1.0f);
        } else if (this.aSh) {
            layoutParams.leftMargin = aRp;
            layoutParams.rightMargin = aRp;
        }
        textView.setLayoutParams(layoutParams);
        textView.setTag(tbRichTextData);
        if (tbRichTextData != null && tbRichTextData.Iw() != null) {
            tbRichTextData.Iw().needRecompute = this.aSq;
        }
        return true;
    }

    private GifView getGifView() {
        GifView gifView = null;
        if (this.aRz != null) {
            gifView = this.aRz.fS();
        }
        GifView gifView2 = (gifView == null || gifView.getParent() != null) ? new GifView(getContext()) : gifView;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) gifView2.getLayoutParams();
        if (layoutParams != null) {
            if (this.aSh) {
                layoutParams.leftMargin = aRp;
                layoutParams.rightMargin = aRp;
            } else {
                layoutParams.leftMargin = 0;
                layoutParams.rightMargin = 0;
            }
            gifView2.setLayoutParams(layoutParams);
        }
        return gifView2;
    }

    private boolean a(final TbRichTextData tbRichTextData, GifView gifView) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) gifView.getLayoutParams();
        if (layoutParams == null || layoutParams.width != tbRichTextData.Iy().mGifInfo.mGifWidth || layoutParams.height != tbRichTextData.Iy().mGifInfo.mGifHeight) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(tbRichTextData.Iy().mGifInfo.mGifWidth, tbRichTextData.Iy().mGifInfo.mGifHeight);
            layoutParams2.gravity = 3;
            if (this.aSh) {
                layoutParams2.leftMargin = aRp;
                layoutParams2.rightMargin = aRp;
            }
            gifView.setLayoutParams(layoutParams2);
        } else {
            layoutParams.bottomMargin = 0;
        }
        gifView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (TbRichTextView.this.aRX != null) {
                    TbRichTextEmotionInfo Iy = tbRichTextData.Iy();
                    TbRichTextView.this.aRX.a(view, Iy.mGifInfo.mGid, Iy.mGifInfo.mPackageName, Iy.mGifInfo.mIcon, Iy.mGifInfo.mStaticUrl, Iy.mGifInfo.mDynamicUrl, Iy.mGifInfo.mSharpText, Iy.mGifInfo.mGifWidth, Iy.mGifInfo.mGifHeight);
                }
            }
        });
        gifView.a(tbRichTextData.Iy().mGifInfo);
        return true;
    }

    private View getVoiceView() {
        View fS = this.aRx != null ? this.aRx.fS() : null;
        if ((fS == null || fS.getParent() != null) && this.aRS != -1) {
            fS = LayoutInflater.from(getContext()).inflate(this.aRS, (ViewGroup) null);
        }
        if (fS != null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.topMargin = this.aRC;
            if (!this.aSi) {
                layoutParams.bottomMargin = this.aRC;
            }
            fS.setLayoutParams(layoutParams);
            return fS;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v9, types: [android.view.View] */
    private View a(TbRichTextGraffitiInfo tbRichTextGraffitiInfo, int i, String str) {
        com.baidu.tieba.graffiti.c cVar = null;
        if (this.aRw != null) {
            cVar = this.aRw.fS();
        }
        if (cVar == null || cVar.getParent() != null) {
            cVar = new com.baidu.tieba.graffiti.c(getContext());
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = this.aRC;
        layoutParams.bottomMargin = this.aRC;
        if (this.aSh) {
            layoutParams.leftMargin = aRp;
            layoutParams.rightMargin = aRp;
        }
        cVar.setLayoutParams(layoutParams);
        if (cVar instanceof com.baidu.tieba.graffiti.c) {
            com.baidu.tieba.graffiti.c cVar2 = cVar;
            cVar2.k(this.aRR, false);
            if (cVar2.getGraffitiImageView() != null) {
                cVar2.getGraffitiImageView().setSupportNoImage(this.aSb);
                cVar2.getGraffitiImageView().setDefaultResource(this.mDefaultImageId);
            }
            if (cVar2.getSaveBtn() != null) {
                cVar2.getSaveBtn().setOnTouchListener(this.aMT);
            }
            cVar2.a(tbRichTextGraffitiInfo, i, str, this.aRH - (getPaddingLeft() + getPaddingRight()), getPaddingRight(), this.aSn);
        }
        return cVar;
    }

    private boolean a(TbRichTextData tbRichTextData, View view) {
        view.setTag(tbRichTextData.Iv());
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LinearLayout.LayoutParams(-2, -2);
        }
        if (this.aSh) {
            layoutParams.leftMargin = aRp;
            layoutParams.rightMargin = aRp;
        }
        view.setLayoutParams(layoutParams);
        return true;
    }

    private View getTextVoiceView() {
        LinearLayout fS = this.aRy.fS();
        if (fS != null) {
            TextView aW = aW(getContext());
            if (aW == null) {
                this.aRy.n(fS);
                return null;
            }
            fS.addView(aW);
            View voiceView = getVoiceView();
            if (voiceView == null) {
                this.aRv.n(aW);
                this.aRy.n(fS);
                return null;
            }
            fS.addView(voiceView);
            return fS;
        }
        return fS;
    }

    private boolean a(TbRichTextData tbRichTextData, LinearLayout linearLayout, b bVar) {
        boolean a2;
        boolean z = true;
        if (linearLayout == null) {
            return false;
        }
        int childCount = linearLayout.getChildCount();
        int i = 0;
        while (i < childCount) {
            View childAt = linearLayout.getChildAt(i);
            if (childAt == null) {
                a2 = z;
            } else if (childAt instanceof TextView) {
                a2 = a(tbRichTextData, (TextView) childAt, false, bVar) & z;
            } else if (childAt.getClass().getSimpleName().equals("PlayVoiceBnt")) {
                a2 = a(tbRichTextData, childAt) & z;
            } else {
                a2 = childAt.getClass().getSimpleName().equals("PlayVoiceBntNew") ? a(tbRichTextData, childAt) & z : z;
            }
            i++;
            z = a2;
        }
        return z;
    }

    public void setTextSize(float f2) {
        Resources resources;
        Context context = getContext();
        if (context == null) {
            resources = Resources.getSystem();
        } else {
            resources = context.getResources();
        }
        float applyDimension = TypedValue.applyDimension(2, f2, resources.getDisplayMetrics());
        if (applyDimension != this.aRD) {
            this.aRD = applyDimension;
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = getChildAt(i);
                if (childAt instanceof TextView) {
                    ((TextView) childAt).setTextSize(0, applyDimension);
                }
            }
        }
    }

    public void setTextColor(int i) {
        if (i != this.mTextColor) {
            this.mTextColor = i;
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (childAt != null && (childAt instanceof TextView)) {
                    ((TextView) childAt).setTextColor(i);
                }
            }
        }
    }

    public void setTextPadding(int i) {
        if (this.aRB != i) {
            this.aRB = i;
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (childAt != null && (childAt instanceof TextView)) {
                    ((TextView) childAt).setPadding(this.aRB, 0, 0, this.aRB);
                }
            }
        }
    }

    public void setLinkTextColor(int i) {
        if (i != this.aRG) {
            this.aRG = i;
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (childAt != null && (childAt instanceof TextView)) {
                    ((TextView) childAt).setLinkTextColor(i);
                }
            }
        }
    }

    private boolean T(int i, int i2) {
        if (this.aSk <= 0) {
            return false;
        }
        return ((((float) i) / ((float) this.aSk)) > aRs ? 1 : ((((float) i) / ((float) this.aSk)) == aRs ? 0 : -1)) > 0;
    }

    public int getMaxImageWidth() {
        return this.aRH;
    }

    public void setMaxImageWidth(int i) {
        this.aRH = i;
    }

    public int getMaxImageHeight() {
        return this.aRI;
    }

    public void setMaxImageHeight(int i) {
        this.aRI = i;
    }

    public ImageView.ScaleType getScaleType() {
        return this.mq;
    }

    public void setScaleType(ImageView.ScaleType scaleType) {
        this.mq = scaleType;
    }

    public int getDefaultImageId() {
        return this.mDefaultImageId;
    }

    public void setDefaultImageId(int i) {
        this.mDefaultImageId = i;
    }

    public e getOnImageClickListener() {
        return this.aRN;
    }

    public void setOnImageClickListener(e eVar) {
        this.aRN = eVar;
    }

    public void setOnImageTouchListener(com.baidu.tieba.pb.a.c cVar) {
        this.aRO = cVar;
    }

    public void setOnEmotionClickListener(d dVar) {
        this.aRX = dVar;
    }

    public void k(boolean z, boolean z2) {
        if (this.aRR != z) {
            this.aRR = z;
            if (z2) {
                requestLayout();
            }
            if (!this.aRR && this.aRu != null) {
                this.aRu.clear();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class g implements AbsListView.RecyclerListener {
        private int mId;

        public g(int i) {
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
        this.aRT = false;
        switch (motionEvent.getAction()) {
            case 1:
            case 3:
                if (!this.aRU) {
                    Je();
                    break;
                } else if (!this.aSg) {
                    motionEvent.setAction(3);
                    break;
                }
                break;
        }
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        switch (motionEvent.getAction()) {
            case 0:
                if (!this.aRT) {
                    Jd();
                    break;
                }
                break;
        }
        return dispatchTouchEvent;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.aRT = true;
        return super.onTouchEvent(motionEvent);
    }

    private void Jd() {
        this.aRU = false;
        if (this.aRV == null) {
            this.aRV = new a();
        }
        postDelayed(this.aRV, ViewConfiguration.getLongPressTimeout());
    }

    private void Je() {
        if (this.aRV != null) {
            removeCallbacks(this.aRV);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!TbRichTextView.this.aSg && !TbRichTextView.this.aSm && TbRichTextView.this.performLongClick()) {
                TbRichTextView.this.aRU = true;
            }
        }
    }

    public void setVoiceViewRes(int i) {
        this.aRS = i;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        this.aSa = null;
        if (this.aSr != drawable) {
            this.aSq = true;
            this.aSr = drawable;
        }
        setText(this.aRZ);
        this.aSq = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Es();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        Es();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 8 || i == 4) {
            Es();
        } else {
            refresh();
        }
    }

    public void ha(String str) {
        BdUniqueId bdUniqueId;
        boolean z;
        if (TextUtils.isEmpty(str)) {
            this.mUrl = str;
            return;
        }
        getContext();
        com.baidu.adp.base.h Y = com.baidu.adp.base.i.Y(getContext());
        if (Y != null) {
            bdUniqueId = Y.getUniqueId();
            z = Y.isScroll();
        } else {
            bdUniqueId = null;
            z = false;
        }
        if (!(str.equals(this.mUrl) && this.mPageId == bdUniqueId)) {
            Es();
        }
        this.mUrl = str;
        this.mPageId = bdUniqueId;
        setBackgroundDrawable(null);
        com.baidu.adp.widget.a.a aVar = (com.baidu.adp.widget.a.a) com.baidu.adp.lib.f.c.fU().a(this.mUrl, 19, new Object[0]);
        if (aVar != null) {
            e(aVar);
        } else if (z) {
            invalidate();
        } else if (!com.baidu.adp.lib.f.c.fU().ao(19)) {
            invalidate();
        } else {
            com.baidu.adp.lib.f.c.fU().a(this.mUrl, 19, this.aMm, 0, 0, this.mPageId, new Object[0]);
        }
    }

    public void Es() {
        if (!TextUtils.isEmpty(this.mUrl)) {
            com.baidu.adp.lib.f.c.fU().a(this.mUrl, 19, this.aMm);
            setBackgroundDrawable(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(com.baidu.adp.widget.a.a aVar) {
        if (aVar != null) {
            try {
                NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(getResources(), aVar.kX(), aVar.kX().getNinePatchChunk(), aVar.lb(), null);
                if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                    ninePatchDrawable.getPaint().setAlpha(80);
                }
                setBackgroundDrawable(ninePatchDrawable);
            } catch (Exception e2) {
            }
        }
    }

    @Override // com.baidu.adp.b.a.i
    public void refresh() {
        ha(this.mUrl);
    }

    public void setTextViewOnClickListener(View.OnClickListener onClickListener) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof TbListTextView) {
                ((TbListTextView) childAt).setOnClickListener(onClickListener);
            }
        }
    }

    public void setTextViewCheckSelection(boolean z) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof TbListTextView) {
                ((TbListTextView) childAt).setCheckSelection(z);
            }
        }
    }

    public void setTextViewOnTouchListener(View.OnTouchListener onTouchListener) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof TbListTextView) {
                ((TbListTextView) childAt).setOnTouchListener(onTouchListener);
            }
        }
    }

    public TextView getTextView() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof TbListTextView) {
                return (TbListTextView) childAt;
            }
        }
        return null;
    }

    public f getOnLinkImageClickListener() {
        return this.aRP;
    }

    public void setOnLinkImageClickListener(f fVar) {
        this.aRP = fVar;
    }

    public void setHasMovementMethod(boolean z) {
        this.aSf = z;
    }

    public void setTextCenter(boolean z) {
        this.aSc = z;
    }

    public void setIsNeedShowImages(boolean z) {
        this.aRY = z;
    }
}
