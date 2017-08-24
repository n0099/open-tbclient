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
    private static final int aRq = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds32);
    private static final int aRr = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds48);
    private static final float aRs = k.ai(TbadkCoreApplication.getInst());
    private static final float aRt;
    static int aRu;
    private final View.OnTouchListener aMU;
    private final com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> aMn;
    private final com.baidu.tieba.pb.a.c aOE;
    private com.baidu.adp.lib.e.b<GifView> aRA;
    private float aRB;
    private int aRC;
    private int aRD;
    private float aRE;
    private int aRF;
    private int aRG;
    private int aRH;
    private int aRI;
    private int aRJ;
    private int aRK;
    private boolean aRL;
    private TextUtils.TruncateAt aRM;
    private g aRN;
    private e aRO;
    private com.baidu.tieba.pb.a.c aRP;
    private f aRQ;
    private View.OnClickListener aRR;
    private boolean aRS;
    private int aRT;
    private boolean aRU;
    private boolean aRV;
    private Runnable aRW;
    private boolean aRX;
    private d aRY;
    private boolean aRZ;
    private com.baidu.adp.lib.e.b<ImageView> aRv;
    private com.baidu.adp.lib.e.b<TextView> aRw;
    private com.baidu.adp.lib.e.b<View> aRx;
    private com.baidu.adp.lib.e.b<View> aRy;
    private com.baidu.adp.lib.e.b<LinearLayout> aRz;
    private TbRichText aSa;
    private String aSb;
    private boolean aSc;
    private boolean aSd;
    private boolean aSe;
    private int aSf;
    private boolean aSg;
    private boolean aSh;
    private boolean aSi;
    private boolean aSj;
    private int aSk;
    private int aSl;
    private boolean aSm;
    private boolean aSn;
    private boolean aSo;
    public final View.OnClickListener aSp;
    private final TbImageView.b aSq;
    private boolean aSr;
    private Drawable aSs;
    private CustomMessageListener aSt;
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
        aRt = aRs > 0.0f ? 1.0f / aRs : 0.3f;
        aRu = 174;
    }

    public void setSubPbPost(boolean z) {
        this.aSm = z;
    }

    public void setShowGraffitiSaveBtn(boolean z) {
        this.aSo = z;
    }

    public boolean Jb() {
        return this.aRX;
    }

    public void Jc() {
        this.aSc = true;
    }

    public String getBackgroundImageUrl() {
        return this.aSb;
    }

    public void setBackgroundImageUrl(String str) {
        this.aSb = str;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public void setMaxWidth(int i) {
        this.mp = i;
    }

    public void setMaxLines(int i) {
        this.aSf = i;
    }

    public void setTextEllipsize(TextUtils.TruncateAt truncateAt) {
        this.aRM = truncateAt;
    }

    public void setIsSupportVitality(boolean z) {
        this.aSi = z;
    }

    public boolean getIsSupportVitality() {
        return this.aSi;
    }

    public void setIsSupportNewFirstFloor(boolean z) {
        this.aSj = z;
    }

    public void setPbFirstFloorLastTextToBottom(int i) {
        this.aSk = i;
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
        super.setOnLongClickListener(onLongClickListener);
    }

    public float getLineSpacing() {
        return this.aRB;
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

    public static TbRichText a(Context context, List<PbContent> list, boolean z) {
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
        this.aRv = null;
        this.aRw = null;
        this.aRx = null;
        this.aRy = null;
        this.aRz = null;
        this.aRA = null;
        this.aRB = 0.0f;
        this.aRC = 0;
        this.aRD = 0;
        this.aRE = 15.0f;
        this.aRF = -1;
        this.aRG = -1;
        this.mTextColor = ViewCompat.MEASURED_STATE_MASK;
        this.aRH = -9989158;
        this.aRI = 200;
        this.aRJ = 200;
        this.mq = null;
        this.mDefaultImageId = 0;
        this.aRK = 0;
        this.aRL = false;
        this.aRM = null;
        this.aRN = null;
        this.aRO = null;
        this.aRP = null;
        this.aRQ = null;
        this.aRR = null;
        this.aRS = true;
        this.mIsFromCDN = true;
        this.aRT = -1;
        this.aRU = false;
        this.aRV = false;
        this.aRW = null;
        this.aRX = false;
        this.aRZ = true;
        this.aSb = null;
        this.aSc = false;
        this.aSd = false;
        this.mp = -1;
        this.aSf = -1;
        this.aSg = true;
        this.aSh = false;
        this.aSi = false;
        this.aSj = false;
        this.aSk = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds34);
        this.aSm = false;
        this.aSn = false;
        this.aSo = true;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                if (TbRichTextView.this.aRO != null && (view instanceof ImageView)) {
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
                    TbRichTextView.this.aRO.a(view, str, i);
                }
            }
        };
        this.aOE = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.5
            @Override // com.baidu.tieba.pb.a.c.a
            public boolean a(View view, MotionEvent motionEvent) {
                if (TbRichTextView.this.aRP != null) {
                    TbRichTextView.this.aRP.aY(view);
                    return TbRichTextView.this.aRP.onDoubleTap(motionEvent);
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
        this.aSp = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                if (TbRichTextView.this.aRQ != null && (view instanceof TbImageView)) {
                    Object tag = view.getTag();
                    if (tag == null || !(tag instanceof c)) {
                        str = null;
                    } else {
                        str = ((c) tag).url;
                    }
                    TbRichTextView.this.aRQ.b(view, str);
                }
            }
        };
        this.aMU = new View.OnTouchListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.12
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    TbRichTextView.this.aSh = true;
                } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                    TbRichTextView.this.aSh = false;
                }
                return false;
            }
        };
        this.aSq = new TbImageView.b() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.2
            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void n(MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    TbRichTextView.this.aSn = true;
                } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                    TbRichTextView.this.aSn = false;
                }
            }
        };
        this.mType = 19;
        this.aMn = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.3
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
        this.aSt = new CustomMessageListener(CmdConfigCustom.PB_RICHTEXT_CHANGE_CMD) { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (TbRichTextView.this.aSm) {
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
        this.aRv = null;
        this.aRw = null;
        this.aRx = null;
        this.aRy = null;
        this.aRz = null;
        this.aRA = null;
        this.aRB = 0.0f;
        this.aRC = 0;
        this.aRD = 0;
        this.aRE = 15.0f;
        this.aRF = -1;
        this.aRG = -1;
        this.mTextColor = ViewCompat.MEASURED_STATE_MASK;
        this.aRH = -9989158;
        this.aRI = 200;
        this.aRJ = 200;
        this.mq = null;
        this.mDefaultImageId = 0;
        this.aRK = 0;
        this.aRL = false;
        this.aRM = null;
        this.aRN = null;
        this.aRO = null;
        this.aRP = null;
        this.aRQ = null;
        this.aRR = null;
        this.aRS = true;
        this.mIsFromCDN = true;
        this.aRT = -1;
        this.aRU = false;
        this.aRV = false;
        this.aRW = null;
        this.aRX = false;
        this.aRZ = true;
        this.aSb = null;
        this.aSc = false;
        this.aSd = false;
        this.mp = -1;
        this.aSf = -1;
        this.aSg = true;
        this.aSh = false;
        this.aSi = false;
        this.aSj = false;
        this.aSk = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds34);
        this.aSm = false;
        this.aSn = false;
        this.aSo = true;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                if (TbRichTextView.this.aRO != null && (view instanceof ImageView)) {
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
                    TbRichTextView.this.aRO.a(view, str, i);
                }
            }
        };
        this.aOE = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.5
            @Override // com.baidu.tieba.pb.a.c.a
            public boolean a(View view, MotionEvent motionEvent) {
                if (TbRichTextView.this.aRP != null) {
                    TbRichTextView.this.aRP.aY(view);
                    return TbRichTextView.this.aRP.onDoubleTap(motionEvent);
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
        this.aSp = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                if (TbRichTextView.this.aRQ != null && (view instanceof TbImageView)) {
                    Object tag = view.getTag();
                    if (tag == null || !(tag instanceof c)) {
                        str = null;
                    } else {
                        str = ((c) tag).url;
                    }
                    TbRichTextView.this.aRQ.b(view, str);
                }
            }
        };
        this.aMU = new View.OnTouchListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.12
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    TbRichTextView.this.aSh = true;
                } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                    TbRichTextView.this.aSh = false;
                }
                return false;
            }
        };
        this.aSq = new TbImageView.b() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.2
            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void n(MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    TbRichTextView.this.aSn = true;
                } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                    TbRichTextView.this.aSn = false;
                }
            }
        };
        this.mType = 19;
        this.aMn = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.3
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
        this.aSt = new CustomMessageListener(CmdConfigCustom.PB_RICHTEXT_CHANGE_CMD) { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (TbRichTextView.this.aSm) {
                    TbRichTextView.this.setTextSize(TbConfig.getContentSizeOfLzl(TbRichTextView.this.getContext()));
                } else {
                    TbRichTextView.this.setTextSize(TbConfig.getContentSize());
                }
            }
        };
        init();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.n.TbRichTextView);
        this.aRD = obtainStyledAttributes.getDimensionPixelSize(d.n.TbRichTextView_segmentMargin, 0);
        this.aRC = obtainStyledAttributes.getDimensionPixelSize(d.n.TbRichTextView_textPadding, 0);
        this.aRB = obtainStyledAttributes.getFloat(d.n.TbRichTextView_lineSpacing, 1.12f);
        this.aRE = obtainStyledAttributes.getDimensionPixelSize(d.n.TbRichTextView_textSize, (int) this.aRE);
        this.mTextColor = obtainStyledAttributes.getColor(d.n.TbRichTextView_textColor, this.mTextColor);
        this.aRI = obtainStyledAttributes.getDimensionPixelSize(d.n.TbRichTextView_maxImageWidth, this.aRI);
        this.aRJ = obtainStyledAttributes.getDimensionPixelSize(d.n.TbRichTextView_maxImageHeight, this.aRJ);
        this.mDefaultImageId = obtainStyledAttributes.getResourceId(d.n.TbRichTextView_defaultImage, 0);
        this.aRF = obtainStyledAttributes.getDimensionPixelSize(d.n.TbRichTextView_faceWidth, this.aRF);
        this.aRG = obtainStyledAttributes.getDimensionPixelSize(d.n.TbRichTextView_faceHeight, this.aRG);
        this.aRK = obtainStyledAttributes.getResourceId(d.n.TbRichTextView_videoImage, 0);
        this.aRL = obtainStyledAttributes.getBoolean(d.n.TbRichTextView_singleLine, false);
        obtainStyledAttributes.recycle();
    }

    public void setLineSpacing(float f2) {
        this.aRB = f2;
    }

    private void init() {
        aRu = getContext().getResources().getDimensionPixelSize(d.f.ds348);
        com.baidu.tbadk.widget.richText.d dVar = null;
        com.baidu.adp.base.e<?> aa = com.baidu.adp.base.i.aa(getContext());
        if (getContext() instanceof com.baidu.tbadk.widget.richText.d) {
            dVar = (com.baidu.tbadk.widget.richText.d) getContext();
        } else if (aa != null && (aa.getOrignalPage() instanceof com.baidu.tbadk.widget.richText.d)) {
            dVar = (com.baidu.tbadk.widget.richText.d) aa.getOrignalPage();
        }
        if (aa != null) {
            aa.registerListener(this.aSt);
        }
        if (dVar != null) {
            this.aRv = dVar.IS();
            this.aRw = dVar.IT();
            this.aRy = dVar.IV();
            this.aRz = dVar.IW();
            this.aRA = dVar.IU();
            this.aRx = dVar.IX();
            if (dVar.getListView() != null && this.aRN == null) {
                this.aRN = new g(dVar.IR());
                dVar.getListView().setRecyclerListener(this.aRN);
            }
        }
        setOrientation(1);
        setOnHierarchyChangeListener(new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.8
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof GifView) && TbRichTextView.this.aRA != null) {
                    TbRichTextView.this.aRA.n((GifView) view2);
                } else if ((view2 instanceof ImageView) && TbRichTextView.this.aRv != null) {
                    TbRichTextView.this.aRv.n((ImageView) view2);
                } else if ((view2 instanceof TextView) && TbRichTextView.this.aRw != null) {
                    TbRichTextView.this.aRw.n((TextView) view2);
                } else if ((view2 instanceof PlayVoiceBnt) && TbRichTextView.this.aRy != null) {
                    TbRichTextView.this.aRy.n(view2);
                } else if ((view2 instanceof com.baidu.tieba.graffiti.c) && TbRichTextView.this.aRx != null) {
                    TbRichTextView.this.aRx.n(view2);
                } else if ((view2 instanceof PlayVoiceBntNew) && TbRichTextView.this.aRy != null) {
                    TbRichTextView.this.aRy.n(view2);
                }
                if (view2 instanceof LinearLayout) {
                    Object tag = view2.getTag();
                    if (tag == null || !(tag instanceof String) || !"VideoView".equals(tag)) {
                        if (TbRichTextView.this.aRz != null) {
                            int childCount = ((LinearLayout) view2).getChildCount();
                            for (int i = 0; i < childCount; i++) {
                                View childAt = ((LinearLayout) view2).getChildAt(i);
                                if (childAt != null) {
                                    if ((childAt instanceof TextView) && TbRichTextView.this.aRw != null) {
                                        TbRichTextView.this.aRw.n((TextView) childAt);
                                    } else if ((childAt instanceof PlayVoiceBnt) && TbRichTextView.this.aRy != null) {
                                        TbRichTextView.this.aRy.n(childAt);
                                    } else if ((childAt instanceof PlayVoiceBntNew) && TbRichTextView.this.aRy != null) {
                                        TbRichTextView.this.aRy.n(childAt);
                                    }
                                }
                            }
                            ((LinearLayout) view2).removeAllViews();
                            TbRichTextView.this.aRz.n((LinearLayout) view2);
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
        this.aSl = k.ag(getContext());
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
        if (this.aSa != tbRichText || (tbRichText != null && tbRichText.isChanged)) {
            if (tbRichText != null) {
                tbRichText.isChanged = false;
            }
            this.aSa = tbRichText;
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
                            if (z && !this.aRX && (Iu = next.Iu()) != null) {
                                this.aRX = Iu.length() >= 200;
                            }
                            if (this.aRP != null) {
                                aW.setOnTouchListener(this.aOE);
                            } else {
                                aW.setOnClickListener(this.aRR);
                            }
                            z2 = a3;
                            i = i4;
                            i2 = i3;
                            view = aW;
                        } else if (next.getType() == 8 && this.aRZ) {
                            if (i3 < 10) {
                                ImageView aV = aV(getContext());
                                z2 = b(next, aV, this.aRI, this.aRJ);
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
                        } else if (next.getType() == 20 && this.aRZ) {
                            if (i4 < 10) {
                                ImageView aV2 = aV(getContext());
                                z2 = b(next, aV2, this.aRI, this.aRJ);
                                view = aV2;
                                i = i4 + 1;
                                i2 = i3;
                            }
                        } else if (next.getType() != 1280 || !this.aRZ) {
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
                            z2 = a(next, aV3, (this.aRI - getPaddingLeft()) - getPaddingRight(), this.aRJ);
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
                        if (z4 && this.aSj) {
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
                                if (this.aSj) {
                                    g2 = aRr;
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
                    if (this.aSj) {
                        layoutParams3.bottomMargin = this.aSk;
                    } else {
                        layoutParams3.bottomMargin = this.aRD;
                    }
                    view3.setLayoutParams(layoutParams3);
                } else if (view3 != null && this.aSj) {
                    LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) view3.getLayoutParams();
                    layoutParams4.bottomMargin = k.g(getContext(), d.f.ds34);
                    view3.setLayoutParams(layoutParams4);
                }
            }
        }
    }

    public void setCommonTextViewOnClickListener(View.OnClickListener onClickListener) {
        this.aRR = onClickListener;
    }

    private View b(final com.baidu.tbadk.widget.richText.e eVar) {
        if (eVar == null || !eVar.isAvaliable()) {
            return null;
        }
        ImageView fS = this.aRv.fS();
        if (fS instanceof ForeDrawableImageView) {
            ForeDrawableImageView foreDrawableImageView = (ForeDrawableImageView) fS;
            foreDrawableImageView.setForegroundDrawable(d.g.icon_play_video);
            foreDrawableImageView.setNoImageBottomTextColor(d.e.cp_cont_c);
            foreDrawableImageView.setNoImageBottomTextPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds32));
            foreDrawableImageView.setNoImageBottomTextSize(TbadkCoreApplication.getInst().getResources().getDimension(d.f.fontsize28));
            foreDrawableImageView.setNoImageBottomText("点击播放视频");
            foreDrawableImageView.setInterceptOnClick(false);
            foreDrawableImageView.setTag("VideoView");
            a(foreDrawableImageView, eVar.getWidth(), eVar.getHeight(), (this.aRI - getPaddingLeft()) - getPaddingRight(), this.aRJ, new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.9
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log("c10643");
                    XiaoyingUtil.startPlayXiaoyingVideo(TbRichTextView.this.getContext(), eVar.getVideoUrl(), eVar.getWidth(), eVar.getHeight(), eVar.getThumbUrl());
                }
            });
            foreDrawableImageView.setDefaultResource(0);
            foreDrawableImageView.setSupportNoImage(this.aSc);
            if (h.oY().pe()) {
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
        if (this.aSi && T(i, i2) && this.aSl > 0) {
            i3 = this.aSl;
            i4 = (int) (i3 * 1.618f);
        }
        int[] d2 = k.d(i, i2, i3, i4);
        if (d2 == null) {
            return false;
        }
        int[] iArr = {d2[0], d2[1]};
        int i6 = iArr[0];
        int i7 = iArr[1];
        if (!this.aSe || i3 <= i6 || aRs <= 1.0f) {
            i3 = i6;
            i5 = i7;
        } else {
            if (i6 * aRs <= i3) {
                if (i6 * aRs > i3 * 0.68f) {
                    i3 = (int) (i3 * 0.68f);
                } else {
                    i3 = (int) (i6 * aRs);
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
        if (this.aSe) {
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        } else if (this.mq == null) {
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        } else {
            imageView.setScaleType(this.mq);
        }
        if (this.aSi) {
            if (T(i, i2)) {
                layoutParams.width = -1;
                layoutParams.leftMargin = 0;
            } else {
                layoutParams.leftMargin = aRq;
            }
        }
        imageView.setClickable(true);
        imageView.setFocusable(false);
        if (this.aRP != null && (imageView instanceof TbImageView)) {
            ((TbImageView) imageView).setTbGestureDetector(this.aOE);
            imageView.setClickable(true);
        } else {
            imageView.setOnClickListener(onClickListener);
        }
        imageView.setLayoutParams(layoutParams);
        if ((imageView instanceof TbImageView) && this.onLongClickListener != null) {
            ((TbImageView) imageView).setDispatchTouchListener(this.aSq);
            imageView.setOnLongClickListener(this.onLongClickListener);
        }
        return true;
    }

    private LinearLayout a(final TbRichTextData tbRichTextData) {
        if (this.aRK <= 0 || tbRichTextData == null) {
            return null;
        }
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setTag("VideoView");
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = this.aRD;
        linearLayout.setClickable(true);
        Bitmap cS = ai.cS(this.aRK);
        if (cS != null) {
            linearLayout.setBackgroundDrawable(new BitmapDrawable(getContext().getResources(), cS));
        }
        linearLayout.setFocusable(false);
        if (this.aSi) {
            layoutParams.leftMargin = aRq;
            layoutParams.rightMargin = aRq;
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
        return this.aRK;
    }

    public void setVideoImageId(int i) {
        this.aRK = i;
    }

    private ImageView aV(Context context) {
        ImageView fS = this.aRv != null ? this.aRv.fS() : null;
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
                if (this.aSc) {
                    tbImageView.setSupportNoImage(true);
                }
                tbImageView.c(IB.IQ(), this.mIsFromCDN ? 17 : 18, false);
                tbImageView.setTag(new c(IB.getLink()));
                if (!IB.IJ()) {
                    tbImageView.setAdjustViewBounds(false);
                }
            }
            return a(imageView, IB.getWidth(), IB.getHeight(), i, i2, this.aSp);
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
            if (this.aSc) {
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
        this.aSe = z;
    }

    private TextView aW(Context context) {
        TextView textView = null;
        if (this.aRw != null) {
            textView = this.aRw.fS();
        }
        if (textView == null || textView.getParent() != null) {
            textView = new TbListTextView(context);
        }
        textView.setPadding(this.aRC, 0, this.aRC, 0);
        return textView;
    }

    private boolean a(TbRichTextData tbRichTextData, TextView textView, boolean z, b bVar) {
        LinearLayout.LayoutParams layoutParams;
        if (z) {
            layoutParams = new LinearLayout.LayoutParams(-1, -2);
        } else {
            layoutParams = new LinearLayout.LayoutParams(-2, -2);
        }
        if (this.aSd) {
            layoutParams.gravity = 16;
            textView.setGravity(16);
        } else {
            layoutParams.topMargin = this.aRD;
        }
        textView.setLineSpacing(0.0f, this.aRB);
        textView.setTextSize(0, this.aRE);
        textView.setTextColor(this.mTextColor);
        textView.setLinkTextColor(ai.getColor(d.e.cp_link_tip_c));
        textView.setHighlightColor(getContext().getResources().getColor(d.e.transparent));
        textView.setSingleLine(this.aRL);
        if (this.aRM != null) {
            textView.setEllipsize(this.aRM);
        }
        if (this.mp > 0) {
            textView.setMaxWidth(this.mp);
        }
        if (this.aSf > 0) {
            textView.setMaxLines(this.aSf);
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
        if (this.aSj) {
            this.aRF = k.g(getContext(), d.f.ds40);
            this.aRG = k.g(getContext(), d.f.ds40);
        }
        if (this.aRG > 0 && this.aRF > 0) {
            tbRichTextData.R(this.aRF, this.aRG);
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
        if (this.aSg) {
            if (tbRichTextData.IE()) {
                textView.setMovementMethod(com.baidu.tieba.view.b.bxf());
            } else {
                textView.setMovementMethod(LinkMovementMethod.getInstance());
            }
        }
        textView.setFocusable(false);
        if (this.aSj) {
            textView.setLineSpacing(k.g(getContext(), d.f.ds8), 1.0f);
        } else if (this.aSi) {
            layoutParams.leftMargin = aRq;
            layoutParams.rightMargin = aRq;
        }
        textView.setLayoutParams(layoutParams);
        textView.setTag(tbRichTextData);
        if (tbRichTextData != null && tbRichTextData.Iw() != null) {
            tbRichTextData.Iw().needRecompute = this.aSr;
        }
        return true;
    }

    private GifView getGifView() {
        GifView gifView = null;
        if (this.aRA != null) {
            gifView = this.aRA.fS();
        }
        GifView gifView2 = (gifView == null || gifView.getParent() != null) ? new GifView(getContext()) : gifView;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) gifView2.getLayoutParams();
        if (layoutParams != null) {
            if (this.aSi) {
                layoutParams.leftMargin = aRq;
                layoutParams.rightMargin = aRq;
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
            if (this.aSi) {
                layoutParams2.leftMargin = aRq;
                layoutParams2.rightMargin = aRq;
            }
            gifView.setLayoutParams(layoutParams2);
        } else {
            layoutParams.bottomMargin = 0;
        }
        gifView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (TbRichTextView.this.aRY != null) {
                    TbRichTextEmotionInfo Iy = tbRichTextData.Iy();
                    TbRichTextView.this.aRY.a(view, Iy.mGifInfo.mGid, Iy.mGifInfo.mPackageName, Iy.mGifInfo.mIcon, Iy.mGifInfo.mStaticUrl, Iy.mGifInfo.mDynamicUrl, Iy.mGifInfo.mSharpText, Iy.mGifInfo.mGifWidth, Iy.mGifInfo.mGifHeight);
                }
            }
        });
        gifView.a(tbRichTextData.Iy().mGifInfo);
        return true;
    }

    private View getVoiceView() {
        View fS = this.aRy != null ? this.aRy.fS() : null;
        if ((fS == null || fS.getParent() != null) && this.aRT != -1) {
            fS = LayoutInflater.from(getContext()).inflate(this.aRT, (ViewGroup) null);
        }
        if (fS != null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.topMargin = this.aRD;
            if (!this.aSj) {
                layoutParams.bottomMargin = this.aRD;
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
        if (this.aRx != null) {
            cVar = this.aRx.fS();
        }
        if (cVar == null || cVar.getParent() != null) {
            cVar = new com.baidu.tieba.graffiti.c(getContext());
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = this.aRD;
        layoutParams.bottomMargin = this.aRD;
        if (this.aSi) {
            layoutParams.leftMargin = aRq;
            layoutParams.rightMargin = aRq;
        }
        cVar.setLayoutParams(layoutParams);
        if (cVar instanceof com.baidu.tieba.graffiti.c) {
            com.baidu.tieba.graffiti.c cVar2 = cVar;
            cVar2.k(this.aRS, false);
            if (cVar2.getGraffitiImageView() != null) {
                cVar2.getGraffitiImageView().setSupportNoImage(this.aSc);
                cVar2.getGraffitiImageView().setDefaultResource(this.mDefaultImageId);
            }
            if (cVar2.getSaveBtn() != null) {
                cVar2.getSaveBtn().setOnTouchListener(this.aMU);
            }
            cVar2.a(tbRichTextGraffitiInfo, i, str, this.aRI - (getPaddingLeft() + getPaddingRight()), getPaddingRight(), this.aSo);
        }
        return cVar;
    }

    private boolean a(TbRichTextData tbRichTextData, View view) {
        view.setTag(tbRichTextData.Iv());
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LinearLayout.LayoutParams(-2, -2);
        }
        if (this.aSi) {
            layoutParams.leftMargin = aRq;
            layoutParams.rightMargin = aRq;
        }
        view.setLayoutParams(layoutParams);
        return true;
    }

    private View getTextVoiceView() {
        LinearLayout fS = this.aRz.fS();
        if (fS != null) {
            TextView aW = aW(getContext());
            if (aW == null) {
                this.aRz.n(fS);
                return null;
            }
            fS.addView(aW);
            View voiceView = getVoiceView();
            if (voiceView == null) {
                this.aRw.n(aW);
                this.aRz.n(fS);
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
        if (applyDimension != this.aRE) {
            this.aRE = applyDimension;
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
        if (this.aRC != i) {
            this.aRC = i;
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (childAt != null && (childAt instanceof TextView)) {
                    ((TextView) childAt).setPadding(this.aRC, 0, 0, this.aRC);
                }
            }
        }
    }

    public void setLinkTextColor(int i) {
        if (i != this.aRH) {
            this.aRH = i;
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
        if (this.aSl <= 0) {
            return false;
        }
        return ((((float) i) / ((float) this.aSl)) > aRt ? 1 : ((((float) i) / ((float) this.aSl)) == aRt ? 0 : -1)) > 0;
    }

    public int getMaxImageWidth() {
        return this.aRI;
    }

    public void setMaxImageWidth(int i) {
        this.aRI = i;
    }

    public int getMaxImageHeight() {
        return this.aRJ;
    }

    public void setMaxImageHeight(int i) {
        this.aRJ = i;
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
        return this.aRO;
    }

    public void setOnImageClickListener(e eVar) {
        this.aRO = eVar;
    }

    public void setOnImageTouchListener(com.baidu.tieba.pb.a.c cVar) {
        this.aRP = cVar;
    }

    public void setOnEmotionClickListener(d dVar) {
        this.aRY = dVar;
    }

    public void k(boolean z, boolean z2) {
        if (this.aRS != z) {
            this.aRS = z;
            if (z2) {
                requestLayout();
            }
            if (!this.aRS && this.aRv != null) {
                this.aRv.clear();
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
        this.aRU = false;
        switch (motionEvent.getAction()) {
            case 1:
            case 3:
                if (!this.aRV) {
                    Je();
                    break;
                } else if (!this.aSh) {
                    motionEvent.setAction(3);
                    break;
                }
                break;
        }
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        switch (motionEvent.getAction()) {
            case 0:
                if (!this.aRU) {
                    Jd();
                    break;
                }
                break;
        }
        return dispatchTouchEvent;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.aRU = true;
        return super.onTouchEvent(motionEvent);
    }

    private void Jd() {
        this.aRV = false;
        if (this.aRW == null) {
            this.aRW = new a();
        }
        postDelayed(this.aRW, ViewConfiguration.getLongPressTimeout());
    }

    private void Je() {
        if (this.aRW != null) {
            removeCallbacks(this.aRW);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!TbRichTextView.this.aSh && !TbRichTextView.this.aSn && TbRichTextView.this.performLongClick()) {
                TbRichTextView.this.aRV = true;
            }
        }
    }

    public void setVoiceViewRes(int i) {
        this.aRT = i;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        this.aSb = null;
        if (this.aSs != drawable) {
            this.aSr = true;
            this.aSs = drawable;
        }
        setText(this.aSa);
        this.aSr = false;
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

    public void hd(String str) {
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
            com.baidu.adp.lib.f.c.fU().a(this.mUrl, 19, this.aMn, 0, 0, this.mPageId, new Object[0]);
        }
    }

    public void Es() {
        if (!TextUtils.isEmpty(this.mUrl)) {
            com.baidu.adp.lib.f.c.fU().a(this.mUrl, 19, this.aMn);
            setBackgroundDrawable(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(com.baidu.adp.widget.a.a aVar) {
        if (aVar != null) {
            try {
                NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(getResources(), aVar.kW(), aVar.kW().getNinePatchChunk(), aVar.la(), null);
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
        hd(this.mUrl);
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
        return this.aRQ;
    }

    public void setOnLinkImageClickListener(f fVar) {
        this.aRQ = fVar;
    }

    public void setHasMovementMethod(boolean z) {
        this.aSg = z;
    }

    public void setTextCenter(boolean z) {
        this.aSd = z;
    }

    public void setIsNeedShowImages(boolean z) {
        this.aRZ = z;
    }
}
