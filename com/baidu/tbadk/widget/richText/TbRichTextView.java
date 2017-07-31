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
    private static final int aRo = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds32);
    private static final int aRp = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds48);
    private static final float aRq = k.ai(TbadkCoreApplication.getInst());
    private static final float aRr;
    static int aRs;
    private final View.OnTouchListener aMS;
    private final com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> aMl;
    private final com.baidu.tieba.pb.a.c aOC;
    private int aRA;
    private int aRB;
    private float aRC;
    private int aRD;
    private int aRE;
    private int aRF;
    private int aRG;
    private int aRH;
    private int aRI;
    private boolean aRJ;
    private TextUtils.TruncateAt aRK;
    private g aRL;
    private e aRM;
    private com.baidu.tieba.pb.a.c aRN;
    private f aRO;
    private View.OnClickListener aRP;
    private boolean aRQ;
    private int aRR;
    private boolean aRS;
    private boolean aRT;
    private Runnable aRU;
    private boolean aRV;
    private d aRW;
    private boolean aRX;
    private TbRichText aRY;
    private String aRZ;
    private com.baidu.adp.lib.e.b<ImageView> aRt;
    private com.baidu.adp.lib.e.b<TextView> aRu;
    private com.baidu.adp.lib.e.b<View> aRv;
    private com.baidu.adp.lib.e.b<View> aRw;
    private com.baidu.adp.lib.e.b<LinearLayout> aRx;
    private com.baidu.adp.lib.e.b<GifView> aRy;
    private float aRz;
    private boolean aSa;
    private boolean aSb;
    private boolean aSc;
    private int aSd;
    private boolean aSe;
    private boolean aSf;
    private boolean aSg;
    private boolean aSh;
    private int aSi;
    private int aSj;
    private boolean aSk;
    private boolean aSl;
    private boolean aSm;
    public final View.OnClickListener aSn;
    private final TbImageView.b aSo;
    private boolean aSp;
    private Drawable aSq;
    private CustomMessageListener aSr;
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
        aRr = aRq > 0.0f ? 1.0f / aRq : 0.3f;
        aRs = 174;
    }

    public void setSubPbPost(boolean z) {
        this.aSk = z;
    }

    public void setShowGraffitiSaveBtn(boolean z) {
        this.aSm = z;
    }

    public boolean Jb() {
        return this.aRV;
    }

    public void Jc() {
        this.aSa = true;
    }

    public String getBackgroundImageUrl() {
        return this.aRZ;
    }

    public void setBackgroundImageUrl(String str) {
        this.aRZ = str;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public void setMaxWidth(int i) {
        this.mp = i;
    }

    public void setMaxLines(int i) {
        this.aSd = i;
    }

    public void setTextEllipsize(TextUtils.TruncateAt truncateAt) {
        this.aRK = truncateAt;
    }

    public void setIsSupportVitality(boolean z) {
        this.aSg = z;
    }

    public boolean getIsSupportVitality() {
        return this.aSg;
    }

    public void setIsSupportNewFirstFloor(boolean z) {
        this.aSh = z;
    }

    public void setPbFirstFloorLastTextToBottom(int i) {
        this.aSi = i;
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
        super.setOnLongClickListener(onLongClickListener);
    }

    public float getLineSpacing() {
        return this.aRz;
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
        this.aRt = null;
        this.aRu = null;
        this.aRv = null;
        this.aRw = null;
        this.aRx = null;
        this.aRy = null;
        this.aRz = 0.0f;
        this.aRA = 0;
        this.aRB = 0;
        this.aRC = 15.0f;
        this.aRD = -1;
        this.aRE = -1;
        this.mTextColor = ViewCompat.MEASURED_STATE_MASK;
        this.aRF = -9989158;
        this.aRG = 200;
        this.aRH = 200;
        this.mq = null;
        this.mDefaultImageId = 0;
        this.aRI = 0;
        this.aRJ = false;
        this.aRK = null;
        this.aRL = null;
        this.aRM = null;
        this.aRN = null;
        this.aRO = null;
        this.aRP = null;
        this.aRQ = true;
        this.mIsFromCDN = true;
        this.aRR = -1;
        this.aRS = false;
        this.aRT = false;
        this.aRU = null;
        this.aRV = false;
        this.aRX = true;
        this.aRZ = null;
        this.aSa = false;
        this.aSb = false;
        this.mp = -1;
        this.aSd = -1;
        this.aSe = true;
        this.aSf = false;
        this.aSg = false;
        this.aSh = false;
        this.aSi = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds34);
        this.aSk = false;
        this.aSl = false;
        this.aSm = true;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                if (TbRichTextView.this.aRM != null && (view instanceof ImageView)) {
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
                    TbRichTextView.this.aRM.a(view, str, i);
                }
            }
        };
        this.aOC = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.5
            @Override // com.baidu.tieba.pb.a.c.a
            public boolean a(View view, MotionEvent motionEvent) {
                if (TbRichTextView.this.aRN != null) {
                    TbRichTextView.this.aRN.aX(view);
                    return TbRichTextView.this.aRN.onDoubleTap(motionEvent);
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
        this.aSn = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                if (TbRichTextView.this.aRO != null && (view instanceof TbImageView)) {
                    Object tag = view.getTag();
                    if (tag == null || !(tag instanceof c)) {
                        str = null;
                    } else {
                        str = ((c) tag).url;
                    }
                    TbRichTextView.this.aRO.b(view, str);
                }
            }
        };
        this.aMS = new View.OnTouchListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.12
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    TbRichTextView.this.aSf = true;
                } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                    TbRichTextView.this.aSf = false;
                }
                return false;
            }
        };
        this.aSo = new TbImageView.b() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.2
            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void n(MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    TbRichTextView.this.aSl = true;
                } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                    TbRichTextView.this.aSl = false;
                }
            }
        };
        this.mType = 19;
        this.aMl = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.3
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
        this.aSr = new CustomMessageListener(CmdConfigCustom.PB_RICHTEXT_CHANGE_CMD) { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (TbRichTextView.this.aSk) {
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
        this.aRt = null;
        this.aRu = null;
        this.aRv = null;
        this.aRw = null;
        this.aRx = null;
        this.aRy = null;
        this.aRz = 0.0f;
        this.aRA = 0;
        this.aRB = 0;
        this.aRC = 15.0f;
        this.aRD = -1;
        this.aRE = -1;
        this.mTextColor = ViewCompat.MEASURED_STATE_MASK;
        this.aRF = -9989158;
        this.aRG = 200;
        this.aRH = 200;
        this.mq = null;
        this.mDefaultImageId = 0;
        this.aRI = 0;
        this.aRJ = false;
        this.aRK = null;
        this.aRL = null;
        this.aRM = null;
        this.aRN = null;
        this.aRO = null;
        this.aRP = null;
        this.aRQ = true;
        this.mIsFromCDN = true;
        this.aRR = -1;
        this.aRS = false;
        this.aRT = false;
        this.aRU = null;
        this.aRV = false;
        this.aRX = true;
        this.aRZ = null;
        this.aSa = false;
        this.aSb = false;
        this.mp = -1;
        this.aSd = -1;
        this.aSe = true;
        this.aSf = false;
        this.aSg = false;
        this.aSh = false;
        this.aSi = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds34);
        this.aSk = false;
        this.aSl = false;
        this.aSm = true;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                if (TbRichTextView.this.aRM != null && (view instanceof ImageView)) {
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
                    TbRichTextView.this.aRM.a(view, str, i);
                }
            }
        };
        this.aOC = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.5
            @Override // com.baidu.tieba.pb.a.c.a
            public boolean a(View view, MotionEvent motionEvent) {
                if (TbRichTextView.this.aRN != null) {
                    TbRichTextView.this.aRN.aX(view);
                    return TbRichTextView.this.aRN.onDoubleTap(motionEvent);
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
        this.aSn = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                if (TbRichTextView.this.aRO != null && (view instanceof TbImageView)) {
                    Object tag = view.getTag();
                    if (tag == null || !(tag instanceof c)) {
                        str = null;
                    } else {
                        str = ((c) tag).url;
                    }
                    TbRichTextView.this.aRO.b(view, str);
                }
            }
        };
        this.aMS = new View.OnTouchListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.12
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    TbRichTextView.this.aSf = true;
                } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                    TbRichTextView.this.aSf = false;
                }
                return false;
            }
        };
        this.aSo = new TbImageView.b() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.2
            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void n(MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    TbRichTextView.this.aSl = true;
                } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                    TbRichTextView.this.aSl = false;
                }
            }
        };
        this.mType = 19;
        this.aMl = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.3
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
        this.aSr = new CustomMessageListener(CmdConfigCustom.PB_RICHTEXT_CHANGE_CMD) { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (TbRichTextView.this.aSk) {
                    TbRichTextView.this.setTextSize(TbConfig.getContentSizeOfLzl(TbRichTextView.this.getContext()));
                } else {
                    TbRichTextView.this.setTextSize(TbConfig.getContentSize());
                }
            }
        };
        init();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.n.TbRichTextView);
        this.aRB = obtainStyledAttributes.getDimensionPixelSize(d.n.TbRichTextView_segmentMargin, 0);
        this.aRA = obtainStyledAttributes.getDimensionPixelSize(d.n.TbRichTextView_textPadding, 0);
        this.aRz = obtainStyledAttributes.getFloat(d.n.TbRichTextView_lineSpacing, 1.12f);
        this.aRC = obtainStyledAttributes.getDimensionPixelSize(d.n.TbRichTextView_textSize, (int) this.aRC);
        this.mTextColor = obtainStyledAttributes.getColor(d.n.TbRichTextView_textColor, this.mTextColor);
        this.aRG = obtainStyledAttributes.getDimensionPixelSize(d.n.TbRichTextView_maxImageWidth, this.aRG);
        this.aRH = obtainStyledAttributes.getDimensionPixelSize(d.n.TbRichTextView_maxImageHeight, this.aRH);
        this.mDefaultImageId = obtainStyledAttributes.getResourceId(d.n.TbRichTextView_defaultImage, 0);
        this.aRD = obtainStyledAttributes.getDimensionPixelSize(d.n.TbRichTextView_faceWidth, this.aRD);
        this.aRE = obtainStyledAttributes.getDimensionPixelSize(d.n.TbRichTextView_faceHeight, this.aRE);
        this.aRI = obtainStyledAttributes.getResourceId(d.n.TbRichTextView_videoImage, 0);
        this.aRJ = obtainStyledAttributes.getBoolean(d.n.TbRichTextView_singleLine, false);
        obtainStyledAttributes.recycle();
    }

    public void setLineSpacing(float f2) {
        this.aRz = f2;
    }

    private void init() {
        aRs = getContext().getResources().getDimensionPixelSize(d.f.ds348);
        com.baidu.tbadk.widget.richText.d dVar = null;
        com.baidu.adp.base.e<?> aa = com.baidu.adp.base.i.aa(getContext());
        if (getContext() instanceof com.baidu.tbadk.widget.richText.d) {
            dVar = (com.baidu.tbadk.widget.richText.d) getContext();
        } else if (aa != null && (aa.getOrignalPage() instanceof com.baidu.tbadk.widget.richText.d)) {
            dVar = (com.baidu.tbadk.widget.richText.d) aa.getOrignalPage();
        }
        if (aa != null) {
            aa.registerListener(this.aSr);
        }
        if (dVar != null) {
            this.aRt = dVar.IS();
            this.aRu = dVar.IT();
            this.aRw = dVar.IV();
            this.aRx = dVar.IW();
            this.aRy = dVar.IU();
            this.aRv = dVar.IX();
            if (dVar.getListView() != null && this.aRL == null) {
                this.aRL = new g(dVar.IR());
                dVar.getListView().setRecyclerListener(this.aRL);
            }
        }
        setOrientation(1);
        setOnHierarchyChangeListener(new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.8
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof GifView) && TbRichTextView.this.aRy != null) {
                    TbRichTextView.this.aRy.n((GifView) view2);
                } else if ((view2 instanceof ImageView) && TbRichTextView.this.aRt != null) {
                    TbRichTextView.this.aRt.n((ImageView) view2);
                } else if ((view2 instanceof TextView) && TbRichTextView.this.aRu != null) {
                    TbRichTextView.this.aRu.n((TextView) view2);
                } else if ((view2 instanceof PlayVoiceBnt) && TbRichTextView.this.aRw != null) {
                    TbRichTextView.this.aRw.n(view2);
                } else if ((view2 instanceof com.baidu.tieba.graffiti.c) && TbRichTextView.this.aRv != null) {
                    TbRichTextView.this.aRv.n(view2);
                } else if ((view2 instanceof PlayVoiceBntNew) && TbRichTextView.this.aRw != null) {
                    TbRichTextView.this.aRw.n(view2);
                }
                if (view2 instanceof LinearLayout) {
                    Object tag = view2.getTag();
                    if (tag == null || !(tag instanceof String) || !"VideoView".equals(tag)) {
                        if (TbRichTextView.this.aRx != null) {
                            int childCount = ((LinearLayout) view2).getChildCount();
                            for (int i = 0; i < childCount; i++) {
                                View childAt = ((LinearLayout) view2).getChildAt(i);
                                if (childAt != null) {
                                    if ((childAt instanceof TextView) && TbRichTextView.this.aRu != null) {
                                        TbRichTextView.this.aRu.n((TextView) childAt);
                                    } else if ((childAt instanceof PlayVoiceBnt) && TbRichTextView.this.aRw != null) {
                                        TbRichTextView.this.aRw.n(childAt);
                                    } else if ((childAt instanceof PlayVoiceBntNew) && TbRichTextView.this.aRw != null) {
                                        TbRichTextView.this.aRw.n(childAt);
                                    }
                                }
                            }
                            ((LinearLayout) view2).removeAllViews();
                            TbRichTextView.this.aRx.n((LinearLayout) view2);
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
        this.aSj = k.ag(getContext());
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
        if (this.aRY != tbRichText || (tbRichText != null && tbRichText.isChanged)) {
            if (tbRichText != null) {
                tbRichText.isChanged = false;
            }
            this.aRY = tbRichText;
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
                            if (z && !this.aRV && (Iu = next.Iu()) != null) {
                                this.aRV = Iu.length() >= 200;
                            }
                            if (this.aRN != null) {
                                aW.setOnTouchListener(this.aOC);
                            } else {
                                aW.setOnClickListener(this.aRP);
                            }
                            z2 = a3;
                            i = i4;
                            i2 = i3;
                            view = aW;
                        } else if (next.getType() == 8 && this.aRX) {
                            if (i3 < 10) {
                                ImageView aV = aV(getContext());
                                z2 = b(next, aV, this.aRG, this.aRH);
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
                        } else if (next.getType() == 20 && this.aRX) {
                            if (i4 < 10) {
                                ImageView aV2 = aV(getContext());
                                z2 = b(next, aV2, this.aRG, this.aRH);
                                view = aV2;
                                i = i4 + 1;
                                i2 = i3;
                            }
                        } else if (next.getType() != 1280 || !this.aRX) {
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
                            z2 = a(next, aV3, (this.aRG - getPaddingLeft()) - getPaddingRight(), this.aRH);
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
                        if (z4 && this.aSh) {
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
                                if (this.aSh) {
                                    g2 = aRp;
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
                    if (this.aSh) {
                        layoutParams3.bottomMargin = this.aSi;
                    } else {
                        layoutParams3.bottomMargin = this.aRB;
                    }
                    view3.setLayoutParams(layoutParams3);
                } else if (view3 != null && this.aSh) {
                    LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) view3.getLayoutParams();
                    layoutParams4.bottomMargin = k.g(getContext(), d.f.ds34);
                    view3.setLayoutParams(layoutParams4);
                }
            }
        }
    }

    public void setCommonTextViewOnClickListener(View.OnClickListener onClickListener) {
        this.aRP = onClickListener;
    }

    private View b(final com.baidu.tbadk.widget.richText.e eVar) {
        if (eVar == null || !eVar.isAvaliable()) {
            return null;
        }
        ImageView fS = this.aRt.fS();
        if (fS instanceof ForeDrawableImageView) {
            ForeDrawableImageView foreDrawableImageView = (ForeDrawableImageView) fS;
            foreDrawableImageView.setForegroundDrawable(d.g.icon_play_video);
            foreDrawableImageView.setNoImageBottomTextColor(d.e.cp_cont_c);
            foreDrawableImageView.setNoImageBottomTextPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds32));
            foreDrawableImageView.setNoImageBottomTextSize(TbadkCoreApplication.getInst().getResources().getDimension(d.f.fontsize28));
            foreDrawableImageView.setNoImageBottomText("点击播放视频");
            foreDrawableImageView.setInterceptOnClick(false);
            foreDrawableImageView.setTag("VideoView");
            a(foreDrawableImageView, eVar.getWidth(), eVar.getHeight(), (this.aRG - getPaddingLeft()) - getPaddingRight(), this.aRH, new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.9
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log("c10643");
                    XiaoyingUtil.startPlayXiaoyingVideo(TbRichTextView.this.getContext(), eVar.getVideoUrl(), eVar.getWidth(), eVar.getHeight(), eVar.getThumbUrl());
                }
            });
            foreDrawableImageView.setDefaultResource(0);
            foreDrawableImageView.setSupportNoImage(this.aSa);
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
        if (this.aSg && T(i, i2) && this.aSj > 0) {
            i3 = this.aSj;
            i4 = (int) (i3 * 1.618f);
        }
        int[] d2 = k.d(i, i2, i3, i4);
        if (d2 == null) {
            return false;
        }
        int[] iArr = {d2[0], d2[1]};
        int i6 = iArr[0];
        int i7 = iArr[1];
        if (!this.aSc || i3 <= i6 || aRq <= 1.0f) {
            i3 = i6;
            i5 = i7;
        } else {
            if (i6 * aRq <= i3) {
                if (i6 * aRq > i3 * 0.68f) {
                    i3 = (int) (i3 * 0.68f);
                } else {
                    i3 = (int) (i6 * aRq);
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
        if (this.aSc) {
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        } else if (this.mq == null) {
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        } else {
            imageView.setScaleType(this.mq);
        }
        if (this.aSg) {
            if (T(i, i2)) {
                layoutParams.width = -1;
                layoutParams.leftMargin = 0;
            } else {
                layoutParams.leftMargin = aRo;
            }
        }
        imageView.setClickable(true);
        imageView.setFocusable(false);
        if (this.aRN != null && (imageView instanceof TbImageView)) {
            ((TbImageView) imageView).setTbGestureDetector(this.aOC);
            imageView.setClickable(true);
        } else {
            imageView.setOnClickListener(onClickListener);
        }
        imageView.setLayoutParams(layoutParams);
        if ((imageView instanceof TbImageView) && this.onLongClickListener != null) {
            ((TbImageView) imageView).setDispatchTouchListener(this.aSo);
            imageView.setOnLongClickListener(this.onLongClickListener);
        }
        return true;
    }

    private LinearLayout a(final TbRichTextData tbRichTextData) {
        if (this.aRI <= 0 || tbRichTextData == null) {
            return null;
        }
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setTag("VideoView");
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = this.aRB;
        linearLayout.setClickable(true);
        Bitmap cS = ai.cS(this.aRI);
        if (cS != null) {
            linearLayout.setBackgroundDrawable(new BitmapDrawable(getContext().getResources(), cS));
        }
        linearLayout.setFocusable(false);
        if (this.aSg) {
            layoutParams.leftMargin = aRo;
            layoutParams.rightMargin = aRo;
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
        return this.aRI;
    }

    public void setVideoImageId(int i) {
        this.aRI = i;
    }

    private ImageView aV(Context context) {
        ImageView fS = this.aRt != null ? this.aRt.fS() : null;
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
                if (this.aSa) {
                    tbImageView.setSupportNoImage(true);
                }
                tbImageView.c(IB.IQ(), this.mIsFromCDN ? 17 : 18, false);
                tbImageView.setTag(new c(IB.getLink()));
                if (!IB.IJ()) {
                    tbImageView.setAdjustViewBounds(false);
                }
            }
            return a(imageView, IB.getWidth(), IB.getHeight(), i, i2, this.aSn);
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
            if (this.aSa) {
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
        this.aSc = z;
    }

    private TextView aW(Context context) {
        TextView textView = null;
        if (this.aRu != null) {
            textView = this.aRu.fS();
        }
        if (textView == null || textView.getParent() != null) {
            textView = new TbListTextView(context);
        }
        textView.setPadding(this.aRA, 0, this.aRA, 0);
        return textView;
    }

    private boolean a(TbRichTextData tbRichTextData, TextView textView, boolean z, b bVar) {
        LinearLayout.LayoutParams layoutParams;
        if (z) {
            layoutParams = new LinearLayout.LayoutParams(-1, -2);
        } else {
            layoutParams = new LinearLayout.LayoutParams(-2, -2);
        }
        if (this.aSb) {
            layoutParams.gravity = 16;
            textView.setGravity(16);
        } else {
            layoutParams.topMargin = this.aRB;
        }
        textView.setLineSpacing(0.0f, this.aRz);
        textView.setTextSize(0, this.aRC);
        textView.setTextColor(this.mTextColor);
        textView.setLinkTextColor(ai.getColor(d.e.cp_link_tip_c));
        textView.setHighlightColor(getContext().getResources().getColor(d.e.transparent));
        textView.setSingleLine(this.aRJ);
        if (this.aRK != null) {
            textView.setEllipsize(this.aRK);
        }
        if (this.mp > 0) {
            textView.setMaxWidth(this.mp);
        }
        if (this.aSd > 0) {
            textView.setMaxLines(this.aSd);
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
        if (this.aSh) {
            this.aRD = k.g(getContext(), d.f.ds40);
            this.aRE = k.g(getContext(), d.f.ds40);
        }
        if (this.aRE > 0 && this.aRD > 0) {
            tbRichTextData.R(this.aRD, this.aRE);
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
        if (this.aSe) {
            if (tbRichTextData.IE()) {
                textView.setMovementMethod(com.baidu.tieba.view.b.bwE());
            } else {
                textView.setMovementMethod(LinkMovementMethod.getInstance());
            }
        }
        textView.setFocusable(false);
        if (this.aSh) {
            textView.setLineSpacing(k.g(getContext(), d.f.ds8), 1.0f);
        } else if (this.aSg) {
            layoutParams.leftMargin = aRo;
            layoutParams.rightMargin = aRo;
        }
        textView.setLayoutParams(layoutParams);
        textView.setTag(tbRichTextData);
        if (tbRichTextData != null && tbRichTextData.Iw() != null) {
            tbRichTextData.Iw().needRecompute = this.aSp;
        }
        return true;
    }

    private GifView getGifView() {
        GifView gifView = null;
        if (this.aRy != null) {
            gifView = this.aRy.fS();
        }
        GifView gifView2 = (gifView == null || gifView.getParent() != null) ? new GifView(getContext()) : gifView;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) gifView2.getLayoutParams();
        if (layoutParams != null) {
            if (this.aSg) {
                layoutParams.leftMargin = aRo;
                layoutParams.rightMargin = aRo;
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
            if (this.aSg) {
                layoutParams2.leftMargin = aRo;
                layoutParams2.rightMargin = aRo;
            }
            gifView.setLayoutParams(layoutParams2);
        } else {
            layoutParams.bottomMargin = 0;
        }
        gifView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (TbRichTextView.this.aRW != null) {
                    TbRichTextEmotionInfo Iy = tbRichTextData.Iy();
                    TbRichTextView.this.aRW.a(view, Iy.mGifInfo.mGid, Iy.mGifInfo.mPackageName, Iy.mGifInfo.mIcon, Iy.mGifInfo.mStaticUrl, Iy.mGifInfo.mDynamicUrl, Iy.mGifInfo.mSharpText, Iy.mGifInfo.mGifWidth, Iy.mGifInfo.mGifHeight);
                }
            }
        });
        gifView.a(tbRichTextData.Iy().mGifInfo);
        return true;
    }

    private View getVoiceView() {
        View fS = this.aRw != null ? this.aRw.fS() : null;
        if ((fS == null || fS.getParent() != null) && this.aRR != -1) {
            fS = LayoutInflater.from(getContext()).inflate(this.aRR, (ViewGroup) null);
        }
        if (fS != null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.topMargin = this.aRB;
            if (!this.aSh) {
                layoutParams.bottomMargin = this.aRB;
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
        if (this.aRv != null) {
            cVar = this.aRv.fS();
        }
        if (cVar == null || cVar.getParent() != null) {
            cVar = new com.baidu.tieba.graffiti.c(getContext());
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = this.aRB;
        layoutParams.bottomMargin = this.aRB;
        if (this.aSg) {
            layoutParams.leftMargin = aRo;
            layoutParams.rightMargin = aRo;
        }
        cVar.setLayoutParams(layoutParams);
        if (cVar instanceof com.baidu.tieba.graffiti.c) {
            com.baidu.tieba.graffiti.c cVar2 = cVar;
            cVar2.k(this.aRQ, false);
            if (cVar2.getGraffitiImageView() != null) {
                cVar2.getGraffitiImageView().setSupportNoImage(this.aSa);
                cVar2.getGraffitiImageView().setDefaultResource(this.mDefaultImageId);
            }
            if (cVar2.getSaveBtn() != null) {
                cVar2.getSaveBtn().setOnTouchListener(this.aMS);
            }
            cVar2.a(tbRichTextGraffitiInfo, i, str, this.aRG - (getPaddingLeft() + getPaddingRight()), getPaddingRight(), this.aSm);
        }
        return cVar;
    }

    private boolean a(TbRichTextData tbRichTextData, View view) {
        view.setTag(tbRichTextData.Iv());
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LinearLayout.LayoutParams(-2, -2);
        }
        if (this.aSg) {
            layoutParams.leftMargin = aRo;
            layoutParams.rightMargin = aRo;
        }
        view.setLayoutParams(layoutParams);
        return true;
    }

    private View getTextVoiceView() {
        LinearLayout fS = this.aRx.fS();
        if (fS != null) {
            TextView aW = aW(getContext());
            if (aW == null) {
                this.aRx.n(fS);
                return null;
            }
            fS.addView(aW);
            View voiceView = getVoiceView();
            if (voiceView == null) {
                this.aRu.n(aW);
                this.aRx.n(fS);
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
        if (applyDimension != this.aRC) {
            this.aRC = applyDimension;
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
        if (this.aRA != i) {
            this.aRA = i;
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (childAt != null && (childAt instanceof TextView)) {
                    ((TextView) childAt).setPadding(this.aRA, 0, 0, this.aRA);
                }
            }
        }
    }

    public void setLinkTextColor(int i) {
        if (i != this.aRF) {
            this.aRF = i;
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
        if (this.aSj <= 0) {
            return false;
        }
        return ((((float) i) / ((float) this.aSj)) > aRr ? 1 : ((((float) i) / ((float) this.aSj)) == aRr ? 0 : -1)) > 0;
    }

    public int getMaxImageWidth() {
        return this.aRG;
    }

    public void setMaxImageWidth(int i) {
        this.aRG = i;
    }

    public int getMaxImageHeight() {
        return this.aRH;
    }

    public void setMaxImageHeight(int i) {
        this.aRH = i;
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
        return this.aRM;
    }

    public void setOnImageClickListener(e eVar) {
        this.aRM = eVar;
    }

    public void setOnImageTouchListener(com.baidu.tieba.pb.a.c cVar) {
        this.aRN = cVar;
    }

    public void setOnEmotionClickListener(d dVar) {
        this.aRW = dVar;
    }

    public void k(boolean z, boolean z2) {
        if (this.aRQ != z) {
            this.aRQ = z;
            if (z2) {
                requestLayout();
            }
            if (!this.aRQ && this.aRt != null) {
                this.aRt.clear();
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
        this.aRS = false;
        switch (motionEvent.getAction()) {
            case 1:
            case 3:
                if (!this.aRT) {
                    Je();
                    break;
                } else if (!this.aSf) {
                    motionEvent.setAction(3);
                    break;
                }
                break;
        }
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        switch (motionEvent.getAction()) {
            case 0:
                if (!this.aRS) {
                    Jd();
                    break;
                }
                break;
        }
        return dispatchTouchEvent;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.aRS = true;
        return super.onTouchEvent(motionEvent);
    }

    private void Jd() {
        this.aRT = false;
        if (this.aRU == null) {
            this.aRU = new a();
        }
        postDelayed(this.aRU, ViewConfiguration.getLongPressTimeout());
    }

    private void Je() {
        if (this.aRU != null) {
            removeCallbacks(this.aRU);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!TbRichTextView.this.aSf && !TbRichTextView.this.aSl && TbRichTextView.this.performLongClick()) {
                TbRichTextView.this.aRT = true;
            }
        }
    }

    public void setVoiceViewRes(int i) {
        this.aRR = i;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        this.aRZ = null;
        if (this.aSq != drawable) {
            this.aSp = true;
            this.aSq = drawable;
        }
        setText(this.aRY);
        this.aSp = false;
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
            com.baidu.adp.lib.f.c.fU().a(this.mUrl, 19, this.aMl, 0, 0, this.mPageId, new Object[0]);
        }
    }

    public void Es() {
        if (!TextUtils.isEmpty(this.mUrl)) {
            com.baidu.adp.lib.f.c.fU().a(this.mUrl, 19, this.aMl);
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
        return this.aRO;
    }

    public void setOnLinkImageClickListener(f fVar) {
        this.aRO = fVar;
    }

    public void setHasMovementMethod(boolean z) {
        this.aSe = z;
    }

    public void setTextCenter(boolean z) {
        this.aSb = z;
    }

    public void setIsNeedShowImages(boolean z) {
        this.aRX = z;
    }
}
