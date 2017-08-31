package com.baidu.tbadk.widget.richText;

import android.annotation.SuppressLint;
import android.content.Context;
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
import com.baidu.tbadk.core.util.aj;
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
    private static final int aQZ = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds32);
    private static final int aRa = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds48);
    private static final float aRb = k.af(TbadkCoreApplication.getInst());
    private static final float aRc;
    static int aRd;
    private int Bn;
    private int Vl;
    private final com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> aLT;
    private final View.OnTouchListener aMA;
    private final com.baidu.tieba.pb.a.c aOn;
    private f aRA;
    private View.OnClickListener aRB;
    private boolean aRC;
    private int aRD;
    private boolean aRE;
    private boolean aRF;
    private Runnable aRG;
    private boolean aRH;
    private d aRI;
    private boolean aRJ;
    private TbRichText aRK;
    private String aRL;
    private boolean aRM;
    private boolean aRN;
    private boolean aRO;
    private int aRP;
    private boolean aRQ;
    private boolean aRR;
    private boolean aRS;
    private boolean aRT;
    private int aRU;
    private int aRV;
    private boolean aRW;
    private boolean aRX;
    private boolean aRY;
    public final View.OnClickListener aRZ;
    private com.baidu.adp.lib.e.b<ImageView> aRe;
    private com.baidu.adp.lib.e.b<TextView> aRf;
    private com.baidu.adp.lib.e.b<View> aRg;
    private com.baidu.adp.lib.e.b<View> aRh;
    private com.baidu.adp.lib.e.b<LinearLayout> aRi;
    private com.baidu.adp.lib.e.b<GifView> aRj;
    private float aRk;
    private int aRl;
    private int aRm;
    private float aRn;
    private int aRo;
    private int aRp;
    private int aRq;
    private int aRr;
    private int aRs;
    private ImageView.ScaleType aRt;
    private int aRu;
    private boolean aRv;
    private TextUtils.TruncateAt aRw;
    private g aRx;
    private e aRy;
    private com.baidu.tieba.pb.a.c aRz;
    private final TbImageView.b aSa;
    private boolean aSb;
    private Drawable aSc;
    private CustomMessageListener aSd;
    private boolean mIsFromCDN;
    private final View.OnClickListener mOnClickListener;
    private BdUniqueId mPageId;
    private int mTextColor;
    private final int mType;
    private String mUrl;
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
        aRc = aRb > 0.0f ? 1.0f / aRb : 0.3f;
        aRd = 174;
    }

    public void setSubPbPost(boolean z) {
        this.aRW = z;
    }

    public void setShowGraffitiSaveBtn(boolean z) {
        this.aRY = z;
    }

    public boolean Jj() {
        return this.aRH;
    }

    public void Jk() {
        this.aRM = true;
    }

    public String getBackgroundImageUrl() {
        return this.aRL;
    }

    public void setBackgroundImageUrl(String str) {
        this.aRL = str;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public void setMaxWidth(int i) {
        this.Bn = i;
    }

    public void setMaxLines(int i) {
        this.aRP = i;
    }

    public void setTextEllipsize(TextUtils.TruncateAt truncateAt) {
        this.aRw = truncateAt;
    }

    public void setIsSupportVitality(boolean z) {
        this.aRS = z;
    }

    public boolean getIsSupportVitality() {
        return this.aRS;
    }

    public void setIsSupportNewFirstFloor(boolean z) {
        this.aRT = z;
    }

    public void setPbFirstFloorLastTextToBottom(int i) {
        this.aRU = i;
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
        super.setOnLongClickListener(onLongClickListener);
    }

    public float getLineSpacing() {
        return this.aRk;
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
    public boolean R(View view) {
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

    public static com.baidu.adp.lib.e.b<TextView> m(final Context context, int i) {
        return new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<TextView>() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: Jn */
            public TextView fJ() {
                return new TbListTextView(context);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
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
            /* renamed from: d */
            public TextView o(TextView textView) {
                return textView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: e */
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
        }, i, 0);
    }

    public TbRichTextView(Context context) {
        super(context);
        this.aRe = null;
        this.aRf = null;
        this.aRg = null;
        this.aRh = null;
        this.aRi = null;
        this.aRj = null;
        this.aRk = 0.0f;
        this.aRl = 0;
        this.aRm = 0;
        this.aRn = 15.0f;
        this.aRo = -1;
        this.aRp = -1;
        this.mTextColor = ViewCompat.MEASURED_STATE_MASK;
        this.aRq = -9989158;
        this.aRr = 200;
        this.aRs = 200;
        this.aRt = null;
        this.Vl = 0;
        this.aRu = 0;
        this.aRv = false;
        this.aRw = null;
        this.aRx = null;
        this.aRy = null;
        this.aRz = null;
        this.aRA = null;
        this.aRB = null;
        this.aRC = true;
        this.mIsFromCDN = true;
        this.aRD = -1;
        this.aRE = false;
        this.aRF = false;
        this.aRG = null;
        this.aRH = false;
        this.aRJ = true;
        this.aRL = null;
        this.aRM = false;
        this.aRN = false;
        this.Bn = -1;
        this.aRP = -1;
        this.aRQ = true;
        this.aRR = false;
        this.aRS = false;
        this.aRT = false;
        this.aRU = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds34);
        this.aRW = false;
        this.aRX = false;
        this.aRY = true;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                if (TbRichTextView.this.aRy != null && (view instanceof ImageView)) {
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
                        if (TbRichTextView.this.R(childAt)) {
                            i++;
                        }
                        if (view == childAt) {
                            break;
                        }
                    }
                    TbRichTextView.this.aRy.a(view, str, i);
                }
            }
        };
        this.aOn = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.5
            @Override // com.baidu.tieba.pb.a.c.a
            public boolean a(View view, MotionEvent motionEvent) {
                if (TbRichTextView.this.aRz != null) {
                    TbRichTextView.this.aRz.bf(view);
                    return TbRichTextView.this.aRz.onDoubleTap(motionEvent);
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
        this.aRZ = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                if (TbRichTextView.this.aRA != null && (view instanceof TbImageView)) {
                    Object tag = view.getTag();
                    if (tag == null || !(tag instanceof c)) {
                        str = null;
                    } else {
                        str = ((c) tag).url;
                    }
                    TbRichTextView.this.aRA.b(view, str);
                }
            }
        };
        this.aMA = new View.OnTouchListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.12
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    TbRichTextView.this.aRR = true;
                } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                    TbRichTextView.this.aRR = false;
                }
                return false;
            }
        };
        this.aSa = new TbImageView.b() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.2
            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void n(MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    TbRichTextView.this.aRX = true;
                } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                    TbRichTextView.this.aRX = false;
                }
            }
        };
        this.mType = 19;
        this.aLT = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.3
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
        this.aSd = new CustomMessageListener(CmdConfigCustom.PB_RICHTEXT_CHANGE_CMD) { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (TbRichTextView.this.aRW) {
                    TbRichTextView.this.setTextSize(TbConfig.getContentSizeOfLzl());
                } else {
                    TbRichTextView.this.setTextSize(TbConfig.getContentSize());
                }
            }
        };
        init();
    }

    public TbRichTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aRe = null;
        this.aRf = null;
        this.aRg = null;
        this.aRh = null;
        this.aRi = null;
        this.aRj = null;
        this.aRk = 0.0f;
        this.aRl = 0;
        this.aRm = 0;
        this.aRn = 15.0f;
        this.aRo = -1;
        this.aRp = -1;
        this.mTextColor = ViewCompat.MEASURED_STATE_MASK;
        this.aRq = -9989158;
        this.aRr = 200;
        this.aRs = 200;
        this.aRt = null;
        this.Vl = 0;
        this.aRu = 0;
        this.aRv = false;
        this.aRw = null;
        this.aRx = null;
        this.aRy = null;
        this.aRz = null;
        this.aRA = null;
        this.aRB = null;
        this.aRC = true;
        this.mIsFromCDN = true;
        this.aRD = -1;
        this.aRE = false;
        this.aRF = false;
        this.aRG = null;
        this.aRH = false;
        this.aRJ = true;
        this.aRL = null;
        this.aRM = false;
        this.aRN = false;
        this.Bn = -1;
        this.aRP = -1;
        this.aRQ = true;
        this.aRR = false;
        this.aRS = false;
        this.aRT = false;
        this.aRU = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds34);
        this.aRW = false;
        this.aRX = false;
        this.aRY = true;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                if (TbRichTextView.this.aRy != null && (view instanceof ImageView)) {
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
                        if (TbRichTextView.this.R(childAt)) {
                            i++;
                        }
                        if (view == childAt) {
                            break;
                        }
                    }
                    TbRichTextView.this.aRy.a(view, str, i);
                }
            }
        };
        this.aOn = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.5
            @Override // com.baidu.tieba.pb.a.c.a
            public boolean a(View view, MotionEvent motionEvent) {
                if (TbRichTextView.this.aRz != null) {
                    TbRichTextView.this.aRz.bf(view);
                    return TbRichTextView.this.aRz.onDoubleTap(motionEvent);
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
        this.aRZ = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                if (TbRichTextView.this.aRA != null && (view instanceof TbImageView)) {
                    Object tag = view.getTag();
                    if (tag == null || !(tag instanceof c)) {
                        str = null;
                    } else {
                        str = ((c) tag).url;
                    }
                    TbRichTextView.this.aRA.b(view, str);
                }
            }
        };
        this.aMA = new View.OnTouchListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.12
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    TbRichTextView.this.aRR = true;
                } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                    TbRichTextView.this.aRR = false;
                }
                return false;
            }
        };
        this.aSa = new TbImageView.b() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.2
            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void n(MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    TbRichTextView.this.aRX = true;
                } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                    TbRichTextView.this.aRX = false;
                }
            }
        };
        this.mType = 19;
        this.aLT = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.3
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
        this.aSd = new CustomMessageListener(CmdConfigCustom.PB_RICHTEXT_CHANGE_CMD) { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (TbRichTextView.this.aRW) {
                    TbRichTextView.this.setTextSize(TbConfig.getContentSizeOfLzl());
                } else {
                    TbRichTextView.this.setTextSize(TbConfig.getContentSize());
                }
            }
        };
        init();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.n.TbRichTextView);
        this.aRm = obtainStyledAttributes.getDimensionPixelSize(d.n.TbRichTextView_segmentMargin, 0);
        this.aRl = obtainStyledAttributes.getDimensionPixelSize(d.n.TbRichTextView_textPadding, 0);
        this.aRk = obtainStyledAttributes.getFloat(d.n.TbRichTextView_lineSpacing, 1.12f);
        this.aRn = obtainStyledAttributes.getDimensionPixelSize(d.n.TbRichTextView_textSize, (int) this.aRn);
        this.mTextColor = obtainStyledAttributes.getColor(d.n.TbRichTextView_textColor, this.mTextColor);
        this.aRr = obtainStyledAttributes.getDimensionPixelSize(d.n.TbRichTextView_maxImageWidth, this.aRr);
        this.aRs = obtainStyledAttributes.getDimensionPixelSize(d.n.TbRichTextView_maxImageHeight, this.aRs);
        this.Vl = obtainStyledAttributes.getResourceId(d.n.TbRichTextView_defaultImage, 0);
        this.aRo = obtainStyledAttributes.getDimensionPixelSize(d.n.TbRichTextView_faceWidth, this.aRo);
        this.aRp = obtainStyledAttributes.getDimensionPixelSize(d.n.TbRichTextView_faceHeight, this.aRp);
        this.aRu = obtainStyledAttributes.getResourceId(d.n.TbRichTextView_videoImage, 0);
        this.aRv = obtainStyledAttributes.getBoolean(d.n.TbRichTextView_singleLine, false);
        obtainStyledAttributes.recycle();
    }

    public void setLineSpacing(float f2) {
        this.aRk = f2;
    }

    private void init() {
        aRd = getContext().getResources().getDimensionPixelSize(d.f.ds348);
        com.baidu.tbadk.widget.richText.d dVar = null;
        com.baidu.adp.base.e<?> X = com.baidu.adp.base.i.X(getContext());
        if (getContext() instanceof com.baidu.tbadk.widget.richText.d) {
            dVar = (com.baidu.tbadk.widget.richText.d) getContext();
        } else if (X != null && (X.getOrignalPage() instanceof com.baidu.tbadk.widget.richText.d)) {
            dVar = (com.baidu.tbadk.widget.richText.d) X.getOrignalPage();
        }
        if (X != null) {
            X.registerListener(this.aSd);
        }
        if (dVar != null) {
            this.aRe = dVar.Ja();
            this.aRf = dVar.Jb();
            this.aRh = dVar.Jd();
            this.aRi = dVar.Je();
            this.aRj = dVar.Jc();
            this.aRg = dVar.Jf();
            if (dVar.getListView() != null && this.aRx == null) {
                this.aRx = new g(dVar.IZ());
                dVar.getListView().setRecyclerListener(this.aRx);
            }
        }
        setOrientation(1);
        setOnHierarchyChangeListener(new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.8
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof GifView) && TbRichTextView.this.aRj != null) {
                    TbRichTextView.this.aRj.m((GifView) view2);
                } else if ((view2 instanceof ImageView) && TbRichTextView.this.aRe != null) {
                    TbRichTextView.this.aRe.m((ImageView) view2);
                } else if ((view2 instanceof TextView) && TbRichTextView.this.aRf != null) {
                    TbRichTextView.this.aRf.m((TextView) view2);
                } else if ((view2 instanceof PlayVoiceBnt) && TbRichTextView.this.aRh != null) {
                    TbRichTextView.this.aRh.m(view2);
                } else if ((view2 instanceof com.baidu.tieba.graffiti.c) && TbRichTextView.this.aRg != null) {
                    TbRichTextView.this.aRg.m(view2);
                } else if ((view2 instanceof PlayVoiceBntNew) && TbRichTextView.this.aRh != null) {
                    TbRichTextView.this.aRh.m(view2);
                }
                if (view2 instanceof LinearLayout) {
                    Object tag = view2.getTag();
                    if (tag == null || !(tag instanceof String) || !"VideoView".equals(tag)) {
                        if (TbRichTextView.this.aRi != null) {
                            int childCount = ((LinearLayout) view2).getChildCount();
                            for (int i = 0; i < childCount; i++) {
                                View childAt = ((LinearLayout) view2).getChildAt(i);
                                if (childAt != null) {
                                    if ((childAt instanceof TextView) && TbRichTextView.this.aRf != null) {
                                        TbRichTextView.this.aRf.m((TextView) childAt);
                                    } else if ((childAt instanceof PlayVoiceBnt) && TbRichTextView.this.aRh != null) {
                                        TbRichTextView.this.aRh.m(childAt);
                                    } else if ((childAt instanceof PlayVoiceBntNew) && TbRichTextView.this.aRh != null) {
                                        TbRichTextView.this.aRh.m(childAt);
                                    }
                                }
                            }
                            ((LinearLayout) view2).removeAllViews();
                            TbRichTextView.this.aRi.m((LinearLayout) view2);
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
        this.aRV = k.ad(getContext());
    }

    public void setText(TbRichText tbRichText) {
        a(tbRichText, false);
    }

    public void a(TbRichText tbRichText, boolean z) {
        a(tbRichText, z, (b) null);
    }

    public void a(TbRichText tbRichText, boolean z, b bVar) {
        ArrayList<TbRichTextData> Iv;
        boolean z2;
        int i;
        int i2;
        SpannableStringBuilder IC;
        View view;
        View view2;
        boolean z3;
        View a2;
        if (this.aRK != tbRichText || (tbRichText != null && tbRichText.isChanged)) {
            if (tbRichText != null) {
                tbRichText.isChanged = false;
            }
            this.aRK = tbRichText;
            removeAllViews();
            if (tbRichText != null && (Iv = tbRichText.Iv()) != null) {
                boolean z4 = true;
                Iterator<TbRichTextData> it = Iv.iterator();
                int i3 = 0;
                View view3 = null;
                View view4 = null;
                int i4 = 0;
                while (it.hasNext()) {
                    TbRichTextData next = it.next();
                    if (next != null) {
                        if (next.getType() == 1) {
                            TextView bb = bb(getContext());
                            boolean a3 = a(next, bb, true, bVar);
                            if (z && !this.aRH && (IC = next.IC()) != null) {
                                this.aRH = IC.length() >= 200;
                            }
                            if (this.aRz != null) {
                                bb.setOnTouchListener(this.aOn);
                            } else {
                                bb.setOnClickListener(this.aRB);
                            }
                            z2 = a3;
                            i = i4;
                            i2 = i3;
                            view = bb;
                        } else if (next.getType() == 8 && this.aRJ) {
                            if (i3 < 10) {
                                ImageView ba = ba(getContext());
                                z2 = b(next, ba, this.aRr, this.aRs);
                                view = ba;
                                i = i4;
                                i2 = i3 + 1;
                            }
                        } else if (next.getType() == 32) {
                            com.baidu.tbadk.widget.richText.e IF = next.IF();
                            if (IF != null && IF.Jh()) {
                                a2 = b(IF);
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
                        } else if (next.getType() == 20 && this.aRJ) {
                            if (i4 < 10) {
                                ImageView ba2 = ba(getContext());
                                z2 = b(next, ba2, this.aRr, this.aRs);
                                view = ba2;
                                i = i4 + 1;
                                i2 = i3;
                            }
                        } else if (next.getType() != 1280 || !this.aRJ) {
                            if (next.getType() == 1536) {
                                TbRichTextGraffitiInfo IL = next.IL();
                                IL.fA(tbRichText.Iu());
                                if (IL != null) {
                                    z2 = true;
                                    view = a(IL, tbRichText.Iu(), tbRichText.getAuthorId());
                                    i = i4;
                                    i2 = i3;
                                }
                            }
                            view = view4;
                            z2 = false;
                            i = i4;
                            i2 = i3;
                        } else {
                            ImageView ba3 = ba(getContext());
                            z2 = a(next, ba3, (this.aRr - getPaddingLeft()) - getPaddingRight(), this.aRs);
                            view = ba3;
                            i = i4;
                            i2 = i3 + 1;
                        }
                        if (!z2 || view == null) {
                            view2 = view3;
                        } else {
                            addView(view);
                            view2 = view;
                        }
                        if (z4 && this.aRT) {
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
                                int g3 = k.g(getContext(), d.f.ds16);
                                if (this.aRT) {
                                    g2 = k.g(getContext(), d.f.ds34);
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
                    if (this.aRT) {
                        layoutParams3.bottomMargin = this.aRU;
                    } else {
                        layoutParams3.bottomMargin = this.aRm;
                    }
                    view3.setLayoutParams(layoutParams3);
                } else if (view3 != null && this.aRT) {
                    LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) view3.getLayoutParams();
                    layoutParams4.bottomMargin = k.g(getContext(), d.f.ds34);
                    view3.setLayoutParams(layoutParams4);
                }
            }
        }
    }

    public void setCommonTextViewOnClickListener(View.OnClickListener onClickListener) {
        this.aRB = onClickListener;
    }

    private View b(final com.baidu.tbadk.widget.richText.e eVar) {
        if (eVar == null || !eVar.isAvaliable()) {
            return null;
        }
        ImageView fI = this.aRe.fI();
        if (fI instanceof ForeDrawableImageView) {
            ForeDrawableImageView foreDrawableImageView = (ForeDrawableImageView) fI;
            foreDrawableImageView.setForegroundDrawable(d.g.icon_play_video);
            foreDrawableImageView.setNoImageBottomTextColor(d.e.cp_cont_c);
            foreDrawableImageView.setNoImageBottomTextPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds32));
            foreDrawableImageView.setNoImageBottomTextSize(TbadkCoreApplication.getInst().getResources().getDimension(d.f.fontsize28));
            foreDrawableImageView.setNoImageBottomText("点击播放视频");
            foreDrawableImageView.setInterceptOnClick(false);
            foreDrawableImageView.setTag("VideoView");
            a(foreDrawableImageView, eVar.getWidth(), eVar.getHeight(), (this.aRr - getPaddingLeft()) - getPaddingRight(), this.aRs, new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.9
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log("c10643");
                    XiaoyingUtil.startPlayXiaoyingVideo(TbRichTextView.this.getContext(), eVar.getVideoUrl(), eVar.getWidth(), eVar.getHeight(), eVar.getThumbUrl());
                }
            });
            foreDrawableImageView.setDefaultResource(0);
            foreDrawableImageView.setSupportNoImage(this.aRM);
            if (h.oS().oY()) {
                foreDrawableImageView.setDefaultBgResource(d.g.pic_bg_video_frs);
            } else {
                foreDrawableImageView.setDefaultBgResource(d.e.cp_bg_line_c);
            }
            foreDrawableImageView.c(eVar.getThumbUrl(), 17, false);
            return fI;
        }
        return fI;
    }

    private boolean a(ImageView imageView, int i, int i2, int i3, int i4, View.OnClickListener onClickListener) {
        int i5;
        if (this.aRS && R(i, i2) && this.aRV > 0) {
            i3 = this.aRV;
            i4 = (int) (i3 * 1.618f);
        }
        int[] b2 = k.b(i, i2, i3, i4);
        if (b2 == null) {
            return false;
        }
        int[] iArr = {b2[0], b2[1]};
        int i6 = iArr[0];
        int i7 = iArr[1];
        if (!this.aRO || i3 <= i6 || aRb <= 1.0f) {
            i3 = i6;
            i5 = i7;
        } else {
            if (i6 * aRb <= i3) {
                if (i6 * aRb > i3 * 0.68f) {
                    i3 = (int) (i3 * 0.68f);
                } else {
                    i3 = (int) (i6 * aRb);
                }
            }
            i5 = iArr[0] > 0 ? (iArr[1] * i3) / iArr[0] : i7;
        }
        if (imageView instanceof TbImageView) {
            TbImageView tbImageView = (TbImageView) imageView;
            tbImageView.setDefaultResource(this.Vl);
            if (tbImageView.getGifIconWidth() >= i3 || tbImageView.getGifIconHeight() >= i5) {
                tbImageView.setGifIconSupport(false);
            } else {
                tbImageView.setGifIconSupport(true);
            }
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i3, i5);
        if (this.aRO) {
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        } else if (this.aRt == null) {
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        } else {
            imageView.setScaleType(this.aRt);
        }
        if (this.aRS) {
            if (R(i, i2)) {
                layoutParams.width = -1;
                layoutParams.leftMargin = 0;
            } else {
                layoutParams.leftMargin = aQZ;
            }
        }
        imageView.setClickable(true);
        imageView.setFocusable(false);
        if (this.aRz != null && (imageView instanceof TbImageView)) {
            ((TbImageView) imageView).setTbGestureDetector(this.aOn);
            imageView.setClickable(true);
        } else {
            imageView.setOnClickListener(onClickListener);
        }
        imageView.setLayoutParams(layoutParams);
        if ((imageView instanceof TbImageView) && this.onLongClickListener != null) {
            ((TbImageView) imageView).setDispatchTouchListener(this.aSa);
            imageView.setOnLongClickListener(this.onLongClickListener);
        }
        return true;
    }

    private LinearLayout a(final TbRichTextData tbRichTextData) {
        if (this.aRu <= 0 || tbRichTextData == null) {
            return null;
        }
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setTag("VideoView");
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = this.aRm;
        linearLayout.setClickable(true);
        Bitmap cT = aj.cT(this.aRu);
        if (cT != null) {
            linearLayout.setBackgroundDrawable(new BitmapDrawable(getContext().getResources(), cT));
        }
        linearLayout.setFocusable(false);
        if (this.aRS) {
            layoutParams.leftMargin = aQZ;
            layoutParams.rightMargin = aQZ;
        }
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (tbRichTextData.IC() != null) {
                    if (TbRichTextView.this.getContext() instanceof com.baidu.tbadk.widget.richText.d) {
                        ((com.baidu.tbadk.widget.richText.d) TbRichTextView.this.getContext()).ab(TbRichTextView.this.getContext(), tbRichTextData.IC().toString());
                        return;
                    }
                    com.baidu.adp.base.e<?> X = com.baidu.adp.base.i.X(TbRichTextView.this.getContext());
                    if (X != null && (X.getOrignalPage() instanceof com.baidu.tbadk.widget.richText.d)) {
                        ((com.baidu.tbadk.widget.richText.d) X.getOrignalPage()).ab(TbRichTextView.this.getContext(), tbRichTextData.IC().toString());
                    }
                }
            }
        });
        return linearLayout;
    }

    public int getVideoImageId() {
        return this.aRu;
    }

    public void setVideoImageId(int i) {
        this.aRu = i;
    }

    private ImageView ba(Context context) {
        ImageView fI = this.aRe != null ? this.aRe.fI() : null;
        if (fI == null || fI.getParent() != null) {
            fI = null;
        }
        if (fI != null) {
            fI.setContentDescription(context.getString(d.l.editor_image));
        }
        return fI;
    }

    private boolean a(TbRichTextData tbRichTextData, ImageView imageView, int i, int i2) {
        if (tbRichTextData == null || imageView == null) {
            return false;
        }
        TbRichTextLinkImageInfo IJ = tbRichTextData.IJ();
        if (IJ != null && IJ.getLink() != null) {
            if (imageView instanceof TbImageView) {
                TbImageView tbImageView = (TbImageView) imageView;
                if (this.aRM) {
                    tbImageView.setSupportNoImage(true);
                }
                tbImageView.c(IJ.IY(), this.mIsFromCDN ? 17 : 18, false);
                tbImageView.setTag(new c(IJ.getLink()));
                if (!IJ.IR()) {
                    tbImageView.setAdjustViewBounds(false);
                }
            }
            return a(imageView, IJ.getWidth(), IJ.getHeight(), i, i2, this.aRZ);
        }
        return false;
    }

    private boolean b(TbRichTextData tbRichTextData, ImageView imageView, int i, int i2) {
        if (tbRichTextData == null || imageView == null) {
            return false;
        }
        if (tbRichTextData.getType() == 20) {
            if (tbRichTextData.IH() == null) {
                return false;
            }
        } else if (tbRichTextData.IB() == null) {
            return false;
        }
        if (imageView instanceof TbImageView) {
            TbImageView tbImageView = (TbImageView) imageView;
            if (this.aRM) {
                tbImageView.setSupportNoImage(true);
            }
            if (tbRichTextData.getType() == 20) {
                tbImageView.c(tbRichTextData.IH().memeInfo.pic_url, this.mIsFromCDN ? 17 : 18, false);
                tbImageView.setAdjustViewBounds(false);
                tbImageView.setTag(d.h.tag_rich_text_meme_info, tbRichTextData.IH());
            } else {
                tbImageView.c(tbRichTextData.IB().IQ(), this.mIsFromCDN ? 17 : 18, false);
                if (!tbRichTextData.IB().IR()) {
                    tbImageView.setAdjustViewBounds(false);
                }
                tbImageView.setTag(d.h.tag_rich_text_meme_info, null);
            }
        }
        if (tbRichTextData.getType() == 20) {
            return a(imageView, tbRichTextData.IH().memeInfo.width.intValue(), tbRichTextData.IH().memeInfo.height.intValue(), i, i2, this.mOnClickListener);
        }
        return a(imageView, tbRichTextData.IB().getWidth(), tbRichTextData.IB().getHeight(), i, i2, this.mOnClickListener);
    }

    public void setImageViewStretch(boolean z) {
        this.aRO = z;
    }

    private TextView bb(Context context) {
        TextView textView = null;
        if (this.aRf != null) {
            textView = this.aRf.fI();
        }
        if (textView == null || textView.getParent() != null) {
            textView = new TbListTextView(context);
        }
        textView.setPadding(this.aRl, 0, this.aRl, 0);
        return textView;
    }

    private boolean a(TbRichTextData tbRichTextData, TextView textView, boolean z, b bVar) {
        LinearLayout.LayoutParams layoutParams;
        if (z) {
            layoutParams = new LinearLayout.LayoutParams(-1, -2);
        } else {
            layoutParams = new LinearLayout.LayoutParams(-2, -2);
        }
        if (this.aRN) {
            layoutParams.gravity = 16;
            textView.setGravity(16);
        } else {
            layoutParams.topMargin = this.aRm;
        }
        textView.setLineSpacing(0.0f, this.aRk);
        textView.setTextSize(0, this.aRn);
        textView.setTextColor(this.mTextColor);
        textView.setLinkTextColor(aj.getColor(d.e.cp_link_tip_c));
        textView.setHighlightColor(getContext().getResources().getColor(d.e.transparent));
        textView.setSingleLine(this.aRv);
        if (this.aRw != null) {
            textView.setEllipsize(this.aRw);
        }
        if (this.Bn > 0) {
            textView.setMaxWidth(this.Bn);
        }
        if (this.aRP > 0) {
            textView.setMaxLines(this.aRP);
        }
        if (tbRichTextData == null) {
            return false;
        }
        SpannableStringBuilder IC = tbRichTextData.IC();
        if (IC == null || IC.length() <= 0) {
            return false;
        }
        int lineHeight = textView.getLineHeight();
        int textSize = lineHeight - ((int) textView.getTextSize());
        if (this.aRT) {
            this.aRo = k.g(getContext(), d.f.ds40);
            this.aRp = k.g(getContext(), d.f.ds40);
        }
        if (this.aRp > 0 && this.aRo > 0) {
            tbRichTextData.P(this.aRo, this.aRp);
        }
        if (textSize > 0) {
            tbRichTextData.O(lineHeight, textSize);
        }
        if (bVar != null) {
            bVar.a(IC, textView, this);
        }
        try {
            textView.setText(IC);
        } catch (Exception e2) {
            textView.setText("");
        }
        if (this.aRQ) {
            if (tbRichTextData.IM()) {
                textView.setMovementMethod(com.baidu.tieba.view.b.bwv());
            } else {
                textView.setMovementMethod(LinkMovementMethod.getInstance());
            }
        }
        textView.setFocusable(false);
        if (this.aRT) {
            textView.setLineSpacing(k.g(getContext(), d.f.ds8), 1.0f);
        } else if (this.aRS) {
            layoutParams.leftMargin = aQZ;
            layoutParams.rightMargin = aQZ;
        }
        textView.setLayoutParams(layoutParams);
        textView.setTag(tbRichTextData);
        if (tbRichTextData != null && tbRichTextData.IE() != null) {
            tbRichTextData.IE().needRecompute = this.aSb;
        }
        return true;
    }

    private GifView getGifView() {
        GifView gifView = null;
        if (this.aRj != null) {
            gifView = this.aRj.fI();
        }
        GifView gifView2 = (gifView == null || gifView.getParent() != null) ? new GifView(getContext()) : gifView;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) gifView2.getLayoutParams();
        if (layoutParams != null) {
            if (this.aRS) {
                layoutParams.leftMargin = aQZ;
                layoutParams.rightMargin = aQZ;
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
        if (layoutParams == null || layoutParams.width != tbRichTextData.IG().mGifInfo.mGifWidth || layoutParams.height != tbRichTextData.IG().mGifInfo.mGifHeight) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(tbRichTextData.IG().mGifInfo.mGifWidth, tbRichTextData.IG().mGifInfo.mGifHeight);
            layoutParams2.gravity = 3;
            if (this.aRS) {
                layoutParams2.leftMargin = aQZ;
                layoutParams2.rightMargin = aQZ;
            }
            gifView.setLayoutParams(layoutParams2);
        } else {
            layoutParams.bottomMargin = 0;
        }
        gifView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (TbRichTextView.this.aRI != null) {
                    TbRichTextEmotionInfo IG = tbRichTextData.IG();
                    TbRichTextView.this.aRI.a(view, IG.mGifInfo.mGid, IG.mGifInfo.mPackageName, IG.mGifInfo.mIcon, IG.mGifInfo.mStaticUrl, IG.mGifInfo.mDynamicUrl, IG.mGifInfo.mSharpText, IG.mGifInfo.mGifWidth, IG.mGifInfo.mGifHeight);
                }
            }
        });
        gifView.a(tbRichTextData.IG().mGifInfo);
        return true;
    }

    private View getVoiceView() {
        View fI = this.aRh != null ? this.aRh.fI() : null;
        if ((fI == null || fI.getParent() != null) && this.aRD != -1) {
            fI = LayoutInflater.from(getContext()).inflate(this.aRD, (ViewGroup) null);
        }
        if (fI != null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.topMargin = this.aRm;
            if (!this.aRT) {
                layoutParams.bottomMargin = this.aRm;
            }
            fI.setLayoutParams(layoutParams);
            return fI;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v9, types: [android.view.View] */
    private View a(TbRichTextGraffitiInfo tbRichTextGraffitiInfo, int i, String str) {
        com.baidu.tieba.graffiti.c cVar = null;
        if (this.aRg != null) {
            cVar = this.aRg.fI();
        }
        if (cVar == null || cVar.getParent() != null) {
            cVar = new com.baidu.tieba.graffiti.c(getContext());
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = this.aRm;
        layoutParams.bottomMargin = this.aRm;
        if (this.aRS) {
            layoutParams.leftMargin = aQZ;
            layoutParams.rightMargin = aQZ;
        }
        cVar.setLayoutParams(layoutParams);
        if (cVar instanceof com.baidu.tieba.graffiti.c) {
            com.baidu.tieba.graffiti.c cVar2 = cVar;
            cVar2.l(this.aRC, false);
            if (cVar2.getGraffitiImageView() != null) {
                cVar2.getGraffitiImageView().setSupportNoImage(this.aRM);
                cVar2.getGraffitiImageView().setDefaultResource(this.Vl);
            }
            if (cVar2.getSaveBtn() != null) {
                cVar2.getSaveBtn().setOnTouchListener(this.aMA);
            }
            cVar2.a(tbRichTextGraffitiInfo, i, str, this.aRr - (getPaddingLeft() + getPaddingRight()), getPaddingRight(), this.aRY);
        }
        return cVar;
    }

    private boolean a(TbRichTextData tbRichTextData, View view) {
        view.setTag(tbRichTextData.ID());
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LinearLayout.LayoutParams(-2, -2);
        }
        if (this.aRS) {
            layoutParams.leftMargin = aQZ;
            layoutParams.rightMargin = aQZ;
        }
        view.setLayoutParams(layoutParams);
        return true;
    }

    private View getTextVoiceView() {
        LinearLayout fI = this.aRi.fI();
        if (fI != null) {
            TextView bb = bb(getContext());
            if (bb == null) {
                this.aRi.m(fI);
                return null;
            }
            fI.addView(bb);
            View voiceView = getVoiceView();
            if (voiceView == null) {
                this.aRf.m(bb);
                this.aRi.m(fI);
                return null;
            }
            fI.addView(voiceView);
            return fI;
        }
        return fI;
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
        if (f2 != this.aRn) {
            this.aRn = f2;
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = getChildAt(i);
                if (childAt instanceof TextView) {
                    ((TextView) childAt).setTextSize(0, f2);
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
        if (this.aRl != i) {
            this.aRl = i;
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (childAt != null && (childAt instanceof TextView)) {
                    ((TextView) childAt).setPadding(this.aRl, 0, 0, this.aRl);
                }
            }
        }
    }

    public void setLinkTextColor(int i) {
        if (i != this.aRq) {
            this.aRq = i;
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (childAt != null && (childAt instanceof TextView)) {
                    ((TextView) childAt).setLinkTextColor(i);
                }
            }
        }
    }

    private boolean R(int i, int i2) {
        if (this.aRV <= 0) {
            return false;
        }
        return ((((float) i) / ((float) this.aRV)) > aRc ? 1 : ((((float) i) / ((float) this.aRV)) == aRc ? 0 : -1)) > 0;
    }

    public int getMaxImageWidth() {
        return this.aRr;
    }

    public void setMaxImageWidth(int i) {
        this.aRr = i;
    }

    public int getMaxImageHeight() {
        return this.aRs;
    }

    public void setMaxImageHeight(int i) {
        this.aRs = i;
    }

    public ImageView.ScaleType getScaleType() {
        return this.aRt;
    }

    public void setScaleType(ImageView.ScaleType scaleType) {
        this.aRt = scaleType;
    }

    public int getDefaultImageId() {
        return this.Vl;
    }

    public void setDefaultImageId(int i) {
        this.Vl = i;
    }

    public e getOnImageClickListener() {
        return this.aRy;
    }

    public void setOnImageClickListener(e eVar) {
        this.aRy = eVar;
    }

    public void setOnImageTouchListener(com.baidu.tieba.pb.a.c cVar) {
        this.aRz = cVar;
    }

    public void setOnEmotionClickListener(d dVar) {
        this.aRI = dVar;
    }

    public void l(boolean z, boolean z2) {
        if (this.aRC != z) {
            this.aRC = z;
            if (z2) {
                requestLayout();
            }
            if (!this.aRC && this.aRe != null) {
                this.aRe.clear();
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
        this.aRE = false;
        switch (motionEvent.getAction()) {
            case 1:
            case 3:
                if (!this.aRF) {
                    Jm();
                    break;
                } else if (!this.aRR) {
                    motionEvent.setAction(3);
                    break;
                }
                break;
        }
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        switch (motionEvent.getAction()) {
            case 0:
                if (!this.aRE) {
                    Jl();
                    break;
                }
                break;
        }
        return dispatchTouchEvent;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.aRE = true;
        return super.onTouchEvent(motionEvent);
    }

    private void Jl() {
        this.aRF = false;
        if (this.aRG == null) {
            this.aRG = new a();
        }
        postDelayed(this.aRG, ViewConfiguration.getLongPressTimeout());
    }

    private void Jm() {
        if (this.aRG != null) {
            removeCallbacks(this.aRG);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!TbRichTextView.this.aRR && !TbRichTextView.this.aRX && TbRichTextView.this.performLongClick()) {
                TbRichTextView.this.aRF = true;
            }
        }
    }

    public void setVoiceViewRes(int i) {
        this.aRD = i;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        this.aRL = null;
        if (this.aSc != drawable) {
            this.aSb = true;
            this.aSc = drawable;
        }
        setText(this.aRK);
        this.aSb = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Eq();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        Eq();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 8 || i == 4) {
            Eq();
        } else {
            refresh();
        }
    }

    public void gZ(String str) {
        BdUniqueId bdUniqueId;
        boolean z;
        if (TextUtils.isEmpty(str)) {
            this.mUrl = str;
            return;
        }
        getContext();
        com.baidu.adp.base.h V = com.baidu.adp.base.i.V(getContext());
        if (V != null) {
            bdUniqueId = V.getUniqueId();
            z = V.isScroll();
        } else {
            bdUniqueId = null;
            z = false;
        }
        if (!(str.equals(this.mUrl) && this.mPageId == bdUniqueId)) {
            Eq();
        }
        this.mUrl = str;
        this.mPageId = bdUniqueId;
        setBackgroundDrawable(null);
        com.baidu.adp.widget.a.a aVar = (com.baidu.adp.widget.a.a) com.baidu.adp.lib.f.c.fK().a(this.mUrl, 19, new Object[0]);
        if (aVar != null) {
            e(aVar);
        } else if (z) {
            invalidate();
        } else if (!com.baidu.adp.lib.f.c.fK().al(19)) {
            invalidate();
        } else {
            com.baidu.adp.lib.f.c.fK().a(this.mUrl, 19, this.aLT, 0, 0, this.mPageId, new Object[0]);
        }
    }

    public void Eq() {
        if (!TextUtils.isEmpty(this.mUrl)) {
            com.baidu.adp.lib.f.c.fK().a(this.mUrl, 19, this.aLT);
            setBackgroundDrawable(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(com.baidu.adp.widget.a.a aVar) {
        if (aVar != null) {
            try {
                NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(getResources(), aVar.kO(), aVar.kO().getNinePatchChunk(), aVar.kS(), null);
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
        gZ(this.mUrl);
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
        return this.aRA;
    }

    public void setOnLinkImageClickListener(f fVar) {
        this.aRA = fVar;
    }

    public void setHasMovementMethod(boolean z) {
        this.aRQ = z;
    }

    public void setTextCenter(boolean z) {
        this.aRN = z;
    }

    public void setIsNeedShowImages(boolean z) {
        this.aRJ = z;
    }
}
