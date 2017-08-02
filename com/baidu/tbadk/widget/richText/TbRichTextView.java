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
    private static final int aQb = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds32);
    private static final int aQc = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds48);
    private static final float aQd = k.ah(TbadkCoreApplication.getInst());
    private static final float aQe;
    static int aQf;
    private int BS;
    private int UH;
    private final com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> aKW;
    private final View.OnTouchListener aLD;
    private final com.baidu.tieba.pb.a.c aNo;
    private e aQA;
    private com.baidu.tieba.pb.a.c aQB;
    private f aQC;
    private View.OnClickListener aQD;
    private boolean aQE;
    private int aQF;
    private boolean aQG;
    private boolean aQH;
    private Runnable aQI;
    private boolean aQJ;
    private d aQK;
    private boolean aQL;
    private TbRichText aQM;
    private String aQN;
    private boolean aQO;
    private boolean aQP;
    private boolean aQQ;
    private int aQR;
    private boolean aQS;
    private boolean aQT;
    private boolean aQU;
    private boolean aQV;
    private int aQW;
    private int aQX;
    private boolean aQY;
    private boolean aQZ;
    private com.baidu.adp.lib.e.b<ImageView> aQg;
    private com.baidu.adp.lib.e.b<TextView> aQh;
    private com.baidu.adp.lib.e.b<View> aQi;
    private com.baidu.adp.lib.e.b<View> aQj;
    private com.baidu.adp.lib.e.b<LinearLayout> aQk;
    private com.baidu.adp.lib.e.b<GifView> aQl;
    private float aQm;
    private int aQn;
    private int aQo;
    private float aQp;
    private int aQq;
    private int aQr;
    private int aQs;
    private int aQt;
    private int aQu;
    private ImageView.ScaleType aQv;
    private int aQw;
    private boolean aQx;
    private TextUtils.TruncateAt aQy;
    private g aQz;
    private boolean aRa;
    public final View.OnClickListener aRb;
    private final TbImageView.b aRc;
    private boolean aRd;
    private Drawable aRe;
    private CustomMessageListener aRf;
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
        aQe = aQd > 0.0f ? 1.0f / aQd : 0.3f;
        aQf = 174;
    }

    public void setSubPbPost(boolean z) {
        this.aQY = z;
    }

    public void setShowGraffitiSaveBtn(boolean z) {
        this.aRa = z;
    }

    public boolean IU() {
        return this.aQJ;
    }

    public void IV() {
        this.aQO = true;
    }

    public String getBackgroundImageUrl() {
        return this.aQN;
    }

    public void setBackgroundImageUrl(String str) {
        this.aQN = str;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public void setMaxWidth(int i) {
        this.BS = i;
    }

    public void setMaxLines(int i) {
        this.aQR = i;
    }

    public void setTextEllipsize(TextUtils.TruncateAt truncateAt) {
        this.aQy = truncateAt;
    }

    public void setIsSupportVitality(boolean z) {
        this.aQU = z;
    }

    public boolean getIsSupportVitality() {
        return this.aQU;
    }

    public void setIsSupportNewFirstFloor(boolean z) {
        this.aQV = z;
    }

    public void setPbFirstFloorLastTextToBottom(int i) {
        this.aQW = i;
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
        super.setOnLongClickListener(onLongClickListener);
    }

    public float getLineSpacing() {
        return this.aQm;
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
            /* renamed from: IY */
            public TextView fI() {
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
        this.aQg = null;
        this.aQh = null;
        this.aQi = null;
        this.aQj = null;
        this.aQk = null;
        this.aQl = null;
        this.aQm = 0.0f;
        this.aQn = 0;
        this.aQo = 0;
        this.aQp = 15.0f;
        this.aQq = -1;
        this.aQr = -1;
        this.mTextColor = ViewCompat.MEASURED_STATE_MASK;
        this.aQs = -9989158;
        this.aQt = 200;
        this.aQu = 200;
        this.aQv = null;
        this.UH = 0;
        this.aQw = 0;
        this.aQx = false;
        this.aQy = null;
        this.aQz = null;
        this.aQA = null;
        this.aQB = null;
        this.aQC = null;
        this.aQD = null;
        this.aQE = true;
        this.mIsFromCDN = true;
        this.aQF = -1;
        this.aQG = false;
        this.aQH = false;
        this.aQI = null;
        this.aQJ = false;
        this.aQL = true;
        this.aQN = null;
        this.aQO = false;
        this.aQP = false;
        this.BS = -1;
        this.aQR = -1;
        this.aQS = true;
        this.aQT = false;
        this.aQU = false;
        this.aQV = false;
        this.aQW = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds34);
        this.aQY = false;
        this.aQZ = false;
        this.aRa = true;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                if (TbRichTextView.this.aQA != null && (view instanceof ImageView)) {
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
                    TbRichTextView.this.aQA.a(view, str, i);
                }
            }
        };
        this.aNo = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.5
            @Override // com.baidu.tieba.pb.a.c.a
            public boolean a(View view, MotionEvent motionEvent) {
                if (TbRichTextView.this.aQB != null) {
                    TbRichTextView.this.aQB.aX(view);
                    return TbRichTextView.this.aQB.onDoubleTap(motionEvent);
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
        this.aRb = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                if (TbRichTextView.this.aQC != null && (view instanceof TbImageView)) {
                    Object tag = view.getTag();
                    if (tag == null || !(tag instanceof c)) {
                        str = null;
                    } else {
                        str = ((c) tag).url;
                    }
                    TbRichTextView.this.aQC.b(view, str);
                }
            }
        };
        this.aLD = new View.OnTouchListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.12
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    TbRichTextView.this.aQT = true;
                } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                    TbRichTextView.this.aQT = false;
                }
                return false;
            }
        };
        this.aRc = new TbImageView.b() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.2
            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void n(MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    TbRichTextView.this.aQZ = true;
                } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                    TbRichTextView.this.aQZ = false;
                }
            }
        };
        this.mType = 19;
        this.aKW = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.3
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
        this.aRf = new CustomMessageListener(CmdConfigCustom.PB_RICHTEXT_CHANGE_CMD) { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (TbRichTextView.this.aQY) {
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
        this.aQg = null;
        this.aQh = null;
        this.aQi = null;
        this.aQj = null;
        this.aQk = null;
        this.aQl = null;
        this.aQm = 0.0f;
        this.aQn = 0;
        this.aQo = 0;
        this.aQp = 15.0f;
        this.aQq = -1;
        this.aQr = -1;
        this.mTextColor = ViewCompat.MEASURED_STATE_MASK;
        this.aQs = -9989158;
        this.aQt = 200;
        this.aQu = 200;
        this.aQv = null;
        this.UH = 0;
        this.aQw = 0;
        this.aQx = false;
        this.aQy = null;
        this.aQz = null;
        this.aQA = null;
        this.aQB = null;
        this.aQC = null;
        this.aQD = null;
        this.aQE = true;
        this.mIsFromCDN = true;
        this.aQF = -1;
        this.aQG = false;
        this.aQH = false;
        this.aQI = null;
        this.aQJ = false;
        this.aQL = true;
        this.aQN = null;
        this.aQO = false;
        this.aQP = false;
        this.BS = -1;
        this.aQR = -1;
        this.aQS = true;
        this.aQT = false;
        this.aQU = false;
        this.aQV = false;
        this.aQW = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds34);
        this.aQY = false;
        this.aQZ = false;
        this.aRa = true;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                if (TbRichTextView.this.aQA != null && (view instanceof ImageView)) {
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
                    TbRichTextView.this.aQA.a(view, str, i);
                }
            }
        };
        this.aNo = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.5
            @Override // com.baidu.tieba.pb.a.c.a
            public boolean a(View view, MotionEvent motionEvent) {
                if (TbRichTextView.this.aQB != null) {
                    TbRichTextView.this.aQB.aX(view);
                    return TbRichTextView.this.aQB.onDoubleTap(motionEvent);
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
        this.aRb = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                if (TbRichTextView.this.aQC != null && (view instanceof TbImageView)) {
                    Object tag = view.getTag();
                    if (tag == null || !(tag instanceof c)) {
                        str = null;
                    } else {
                        str = ((c) tag).url;
                    }
                    TbRichTextView.this.aQC.b(view, str);
                }
            }
        };
        this.aLD = new View.OnTouchListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.12
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    TbRichTextView.this.aQT = true;
                } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                    TbRichTextView.this.aQT = false;
                }
                return false;
            }
        };
        this.aRc = new TbImageView.b() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.2
            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void n(MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    TbRichTextView.this.aQZ = true;
                } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                    TbRichTextView.this.aQZ = false;
                }
            }
        };
        this.mType = 19;
        this.aKW = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.3
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
        this.aRf = new CustomMessageListener(CmdConfigCustom.PB_RICHTEXT_CHANGE_CMD) { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (TbRichTextView.this.aQY) {
                    TbRichTextView.this.setTextSize(TbConfig.getContentSizeOfLzl(TbRichTextView.this.getContext()));
                } else {
                    TbRichTextView.this.setTextSize(TbConfig.getContentSize());
                }
            }
        };
        init();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.n.TbRichTextView);
        this.aQo = obtainStyledAttributes.getDimensionPixelSize(d.n.TbRichTextView_segmentMargin, 0);
        this.aQn = obtainStyledAttributes.getDimensionPixelSize(d.n.TbRichTextView_textPadding, 0);
        this.aQm = obtainStyledAttributes.getFloat(d.n.TbRichTextView_lineSpacing, 1.12f);
        this.aQp = obtainStyledAttributes.getDimensionPixelSize(d.n.TbRichTextView_textSize, (int) this.aQp);
        this.mTextColor = obtainStyledAttributes.getColor(d.n.TbRichTextView_textColor, this.mTextColor);
        this.aQt = obtainStyledAttributes.getDimensionPixelSize(d.n.TbRichTextView_maxImageWidth, this.aQt);
        this.aQu = obtainStyledAttributes.getDimensionPixelSize(d.n.TbRichTextView_maxImageHeight, this.aQu);
        this.UH = obtainStyledAttributes.getResourceId(d.n.TbRichTextView_defaultImage, 0);
        this.aQq = obtainStyledAttributes.getDimensionPixelSize(d.n.TbRichTextView_faceWidth, this.aQq);
        this.aQr = obtainStyledAttributes.getDimensionPixelSize(d.n.TbRichTextView_faceHeight, this.aQr);
        this.aQw = obtainStyledAttributes.getResourceId(d.n.TbRichTextView_videoImage, 0);
        this.aQx = obtainStyledAttributes.getBoolean(d.n.TbRichTextView_singleLine, false);
        obtainStyledAttributes.recycle();
    }

    public void setLineSpacing(float f2) {
        this.aQm = f2;
    }

    private void init() {
        aQf = getContext().getResources().getDimensionPixelSize(d.f.ds348);
        com.baidu.tbadk.widget.richText.d dVar = null;
        com.baidu.adp.base.e<?> Z = com.baidu.adp.base.i.Z(getContext());
        if (getContext() instanceof com.baidu.tbadk.widget.richText.d) {
            dVar = (com.baidu.tbadk.widget.richText.d) getContext();
        } else if (Z != null && (Z.getOrignalPage() instanceof com.baidu.tbadk.widget.richText.d)) {
            dVar = (com.baidu.tbadk.widget.richText.d) Z.getOrignalPage();
        }
        if (Z != null) {
            Z.registerListener(this.aRf);
        }
        if (dVar != null) {
            this.aQg = dVar.IL();
            this.aQh = dVar.IM();
            this.aQj = dVar.IO();
            this.aQk = dVar.IP();
            this.aQl = dVar.IN();
            this.aQi = dVar.IQ();
            if (dVar.getListView() != null && this.aQz == null) {
                this.aQz = new g(dVar.IK());
                dVar.getListView().setRecyclerListener(this.aQz);
            }
        }
        setOrientation(1);
        setOnHierarchyChangeListener(new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.8
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof GifView) && TbRichTextView.this.aQl != null) {
                    TbRichTextView.this.aQl.n((GifView) view2);
                } else if ((view2 instanceof ImageView) && TbRichTextView.this.aQg != null) {
                    TbRichTextView.this.aQg.n((ImageView) view2);
                } else if ((view2 instanceof TextView) && TbRichTextView.this.aQh != null) {
                    TbRichTextView.this.aQh.n((TextView) view2);
                } else if ((view2 instanceof PlayVoiceBnt) && TbRichTextView.this.aQj != null) {
                    TbRichTextView.this.aQj.n(view2);
                } else if ((view2 instanceof com.baidu.tieba.graffiti.c) && TbRichTextView.this.aQi != null) {
                    TbRichTextView.this.aQi.n(view2);
                } else if ((view2 instanceof PlayVoiceBntNew) && TbRichTextView.this.aQj != null) {
                    TbRichTextView.this.aQj.n(view2);
                }
                if (view2 instanceof LinearLayout) {
                    Object tag = view2.getTag();
                    if (tag == null || !(tag instanceof String) || !"VideoView".equals(tag)) {
                        if (TbRichTextView.this.aQk != null) {
                            int childCount = ((LinearLayout) view2).getChildCount();
                            for (int i = 0; i < childCount; i++) {
                                View childAt = ((LinearLayout) view2).getChildAt(i);
                                if (childAt != null) {
                                    if ((childAt instanceof TextView) && TbRichTextView.this.aQh != null) {
                                        TbRichTextView.this.aQh.n((TextView) childAt);
                                    } else if ((childAt instanceof PlayVoiceBnt) && TbRichTextView.this.aQj != null) {
                                        TbRichTextView.this.aQj.n(childAt);
                                    } else if ((childAt instanceof PlayVoiceBntNew) && TbRichTextView.this.aQj != null) {
                                        TbRichTextView.this.aQj.n(childAt);
                                    }
                                }
                            }
                            ((LinearLayout) view2).removeAllViews();
                            TbRichTextView.this.aQk.n((LinearLayout) view2);
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
        this.aQX = k.af(getContext());
    }

    public void setText(TbRichText tbRichText) {
        a(tbRichText, false);
    }

    public void a(TbRichText tbRichText, boolean z) {
        a(tbRichText, z, (b) null);
    }

    public void a(TbRichText tbRichText, boolean z, b bVar) {
        ArrayList<TbRichTextData> Ig;
        boolean z2;
        int i;
        int i2;
        SpannableStringBuilder In;
        View view;
        View view2;
        boolean z3;
        View a2;
        if (this.aQM != tbRichText || (tbRichText != null && tbRichText.isChanged)) {
            if (tbRichText != null) {
                tbRichText.isChanged = false;
            }
            this.aQM = tbRichText;
            removeAllViews();
            if (tbRichText != null && (Ig = tbRichText.Ig()) != null) {
                boolean z4 = true;
                Iterator<TbRichTextData> it = Ig.iterator();
                int i3 = 0;
                View view3 = null;
                View view4 = null;
                int i4 = 0;
                while (it.hasNext()) {
                    TbRichTextData next = it.next();
                    if (next != null) {
                        if (next.getType() == 1) {
                            TextView aV = aV(getContext());
                            boolean a3 = a(next, aV, true, bVar);
                            if (z && !this.aQJ && (In = next.In()) != null) {
                                this.aQJ = In.length() >= 200;
                            }
                            if (this.aQB != null) {
                                aV.setOnTouchListener(this.aNo);
                            } else {
                                aV.setOnClickListener(this.aQD);
                            }
                            z2 = a3;
                            i = i4;
                            i2 = i3;
                            view = aV;
                        } else if (next.getType() == 8 && this.aQL) {
                            if (i3 < 10) {
                                ImageView aU = aU(getContext());
                                z2 = b(next, aU, this.aQt, this.aQu);
                                view = aU;
                                i = i4;
                                i2 = i3 + 1;
                            }
                        } else if (next.getType() == 32) {
                            com.baidu.tbadk.widget.richText.e Iq = next.Iq();
                            if (Iq != null && Iq.IS()) {
                                a2 = b(Iq);
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
                        } else if (next.getType() == 20 && this.aQL) {
                            if (i4 < 10) {
                                ImageView aU2 = aU(getContext());
                                z2 = b(next, aU2, this.aQt, this.aQu);
                                view = aU2;
                                i = i4 + 1;
                                i2 = i3;
                            }
                        } else if (next.getType() != 1280 || !this.aQL) {
                            if (next.getType() == 1536) {
                                TbRichTextGraffitiInfo Iw = next.Iw();
                                Iw.fx(tbRichText.If());
                                if (Iw != null) {
                                    z2 = true;
                                    view = a(Iw, tbRichText.If(), tbRichText.getAuthorId());
                                    i = i4;
                                    i2 = i3;
                                }
                            }
                            view = view4;
                            z2 = false;
                            i = i4;
                            i2 = i3;
                        } else {
                            ImageView aU3 = aU(getContext());
                            z2 = a(next, aU3, (this.aQt - getPaddingLeft()) - getPaddingRight(), this.aQu);
                            view = aU3;
                            i = i4;
                            i2 = i3 + 1;
                        }
                        if (!z2 || view == null) {
                            view2 = view3;
                        } else {
                            addView(view);
                            view2 = view;
                        }
                        if (z4 && this.aQV) {
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
                                if (this.aQV) {
                                    g2 = aQc;
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
                    if (this.aQV) {
                        layoutParams3.bottomMargin = this.aQW;
                    } else {
                        layoutParams3.bottomMargin = this.aQo;
                    }
                    view3.setLayoutParams(layoutParams3);
                } else if (view3 != null && this.aQV) {
                    LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) view3.getLayoutParams();
                    layoutParams4.bottomMargin = k.g(getContext(), d.f.ds34);
                    view3.setLayoutParams(layoutParams4);
                }
            }
        }
    }

    public void setCommonTextViewOnClickListener(View.OnClickListener onClickListener) {
        this.aQD = onClickListener;
    }

    private View b(final com.baidu.tbadk.widget.richText.e eVar) {
        if (eVar == null || !eVar.isAvaliable()) {
            return null;
        }
        ImageView fH = this.aQg.fH();
        if (fH instanceof ForeDrawableImageView) {
            ForeDrawableImageView foreDrawableImageView = (ForeDrawableImageView) fH;
            foreDrawableImageView.setForegroundDrawable(d.g.icon_play_video);
            foreDrawableImageView.setNoImageBottomTextColor(d.e.cp_cont_c);
            foreDrawableImageView.setNoImageBottomTextPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds32));
            foreDrawableImageView.setNoImageBottomTextSize(TbadkCoreApplication.getInst().getResources().getDimension(d.f.fontsize28));
            foreDrawableImageView.setNoImageBottomText("点击播放视频");
            foreDrawableImageView.setInterceptOnClick(false);
            foreDrawableImageView.setTag("VideoView");
            a(foreDrawableImageView, eVar.getWidth(), eVar.getHeight(), (this.aQt - getPaddingLeft()) - getPaddingRight(), this.aQu, new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.9
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log("c10643");
                    XiaoyingUtil.startPlayXiaoyingVideo(TbRichTextView.this.getContext(), eVar.getVideoUrl(), eVar.getWidth(), eVar.getHeight(), eVar.getThumbUrl());
                }
            });
            foreDrawableImageView.setDefaultResource(0);
            foreDrawableImageView.setSupportNoImage(this.aQO);
            if (h.oN().oT()) {
                foreDrawableImageView.setDefaultBgResource(d.g.pic_bg_video_frs);
            } else {
                foreDrawableImageView.setDefaultBgResource(d.e.cp_bg_line_c);
            }
            foreDrawableImageView.c(eVar.getThumbUrl(), 17, false);
            return fH;
        }
        return fH;
    }

    private boolean a(ImageView imageView, int i, int i2, int i3, int i4, View.OnClickListener onClickListener) {
        int i5;
        if (this.aQU && S(i, i2) && this.aQX > 0) {
            i3 = this.aQX;
            i4 = (int) (i3 * 1.618f);
        }
        int[] c2 = k.c(i, i2, i3, i4);
        if (c2 == null) {
            return false;
        }
        int[] iArr = {c2[0], c2[1]};
        int i6 = iArr[0];
        int i7 = iArr[1];
        if (!this.aQQ || i3 <= i6 || aQd <= 1.0f) {
            i3 = i6;
            i5 = i7;
        } else {
            if (i6 * aQd <= i3) {
                if (i6 * aQd > i3 * 0.68f) {
                    i3 = (int) (i3 * 0.68f);
                } else {
                    i3 = (int) (i6 * aQd);
                }
            }
            i5 = iArr[0] > 0 ? (iArr[1] * i3) / iArr[0] : i7;
        }
        if (imageView instanceof TbImageView) {
            TbImageView tbImageView = (TbImageView) imageView;
            tbImageView.setDefaultResource(this.UH);
            if (tbImageView.getGifIconWidth() >= i3 || tbImageView.getGifIconHeight() >= i5) {
                tbImageView.setGifIconSupport(false);
            } else {
                tbImageView.setGifIconSupport(true);
            }
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i3, i5);
        if (this.aQQ) {
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        } else if (this.aQv == null) {
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        } else {
            imageView.setScaleType(this.aQv);
        }
        if (this.aQU) {
            if (S(i, i2)) {
                layoutParams.width = -1;
                layoutParams.leftMargin = 0;
            } else {
                layoutParams.leftMargin = aQb;
            }
        }
        imageView.setClickable(true);
        imageView.setFocusable(false);
        if (this.aQB != null && (imageView instanceof TbImageView)) {
            ((TbImageView) imageView).setTbGestureDetector(this.aNo);
            imageView.setClickable(true);
        } else {
            imageView.setOnClickListener(onClickListener);
        }
        imageView.setLayoutParams(layoutParams);
        if ((imageView instanceof TbImageView) && this.onLongClickListener != null) {
            ((TbImageView) imageView).setDispatchTouchListener(this.aRc);
            imageView.setOnLongClickListener(this.onLongClickListener);
        }
        return true;
    }

    private LinearLayout a(final TbRichTextData tbRichTextData) {
        if (this.aQw <= 0 || tbRichTextData == null) {
            return null;
        }
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setTag("VideoView");
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = this.aQo;
        linearLayout.setClickable(true);
        Bitmap cQ = ai.cQ(this.aQw);
        if (cQ != null) {
            linearLayout.setBackgroundDrawable(new BitmapDrawable(getContext().getResources(), cQ));
        }
        linearLayout.setFocusable(false);
        if (this.aQU) {
            layoutParams.leftMargin = aQb;
            layoutParams.rightMargin = aQb;
        }
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (tbRichTextData.In() != null) {
                    if (TbRichTextView.this.getContext() instanceof com.baidu.tbadk.widget.richText.d) {
                        ((com.baidu.tbadk.widget.richText.d) TbRichTextView.this.getContext()).ab(TbRichTextView.this.getContext(), tbRichTextData.In().toString());
                        return;
                    }
                    com.baidu.adp.base.e<?> Z = com.baidu.adp.base.i.Z(TbRichTextView.this.getContext());
                    if (Z != null && (Z.getOrignalPage() instanceof com.baidu.tbadk.widget.richText.d)) {
                        ((com.baidu.tbadk.widget.richText.d) Z.getOrignalPage()).ab(TbRichTextView.this.getContext(), tbRichTextData.In().toString());
                    }
                }
            }
        });
        return linearLayout;
    }

    public int getVideoImageId() {
        return this.aQw;
    }

    public void setVideoImageId(int i) {
        this.aQw = i;
    }

    private ImageView aU(Context context) {
        ImageView fH = this.aQg != null ? this.aQg.fH() : null;
        if (fH == null || fH.getParent() != null) {
            fH = null;
        }
        if (fH != null) {
            fH.setContentDescription(context.getString(d.l.editor_image));
        }
        return fH;
    }

    private boolean a(TbRichTextData tbRichTextData, ImageView imageView, int i, int i2) {
        if (tbRichTextData == null || imageView == null) {
            return false;
        }
        TbRichTextLinkImageInfo Iu = tbRichTextData.Iu();
        if (Iu != null && Iu.getLink() != null) {
            if (imageView instanceof TbImageView) {
                TbImageView tbImageView = (TbImageView) imageView;
                if (this.aQO) {
                    tbImageView.setSupportNoImage(true);
                }
                tbImageView.c(Iu.IJ(), this.mIsFromCDN ? 17 : 18, false);
                tbImageView.setTag(new c(Iu.getLink()));
                if (!Iu.IC()) {
                    tbImageView.setAdjustViewBounds(false);
                }
            }
            return a(imageView, Iu.getWidth(), Iu.getHeight(), i, i2, this.aRb);
        }
        return false;
    }

    private boolean b(TbRichTextData tbRichTextData, ImageView imageView, int i, int i2) {
        if (tbRichTextData == null || imageView == null) {
            return false;
        }
        if (tbRichTextData.getType() == 20) {
            if (tbRichTextData.Is() == null) {
                return false;
            }
        } else if (tbRichTextData.Im() == null) {
            return false;
        }
        if (imageView instanceof TbImageView) {
            TbImageView tbImageView = (TbImageView) imageView;
            if (this.aQO) {
                tbImageView.setSupportNoImage(true);
            }
            if (tbRichTextData.getType() == 20) {
                tbImageView.c(tbRichTextData.Is().memeInfo.pic_url, this.mIsFromCDN ? 17 : 18, false);
                tbImageView.setAdjustViewBounds(false);
                tbImageView.setTag(d.h.tag_rich_text_meme_info, tbRichTextData.Is());
            } else {
                tbImageView.c(tbRichTextData.Im().IB(), this.mIsFromCDN ? 17 : 18, false);
                if (!tbRichTextData.Im().IC()) {
                    tbImageView.setAdjustViewBounds(false);
                }
                tbImageView.setTag(d.h.tag_rich_text_meme_info, null);
            }
        }
        if (tbRichTextData.getType() == 20) {
            return a(imageView, tbRichTextData.Is().memeInfo.width.intValue(), tbRichTextData.Is().memeInfo.height.intValue(), i, i2, this.mOnClickListener);
        }
        return a(imageView, tbRichTextData.Im().getWidth(), tbRichTextData.Im().getHeight(), i, i2, this.mOnClickListener);
    }

    public void setImageViewStretch(boolean z) {
        this.aQQ = z;
    }

    private TextView aV(Context context) {
        TextView textView = null;
        if (this.aQh != null) {
            textView = this.aQh.fH();
        }
        if (textView == null || textView.getParent() != null) {
            textView = new TbListTextView(context);
        }
        textView.setPadding(this.aQn, 0, this.aQn, 0);
        return textView;
    }

    private boolean a(TbRichTextData tbRichTextData, TextView textView, boolean z, b bVar) {
        LinearLayout.LayoutParams layoutParams;
        if (z) {
            layoutParams = new LinearLayout.LayoutParams(-1, -2);
        } else {
            layoutParams = new LinearLayout.LayoutParams(-2, -2);
        }
        if (this.aQP) {
            layoutParams.gravity = 16;
            textView.setGravity(16);
        } else {
            layoutParams.topMargin = this.aQo;
        }
        textView.setLineSpacing(0.0f, this.aQm);
        textView.setTextSize(0, this.aQp);
        textView.setTextColor(this.mTextColor);
        textView.setLinkTextColor(ai.getColor(d.e.cp_link_tip_c));
        textView.setHighlightColor(getContext().getResources().getColor(d.e.transparent));
        textView.setSingleLine(this.aQx);
        if (this.aQy != null) {
            textView.setEllipsize(this.aQy);
        }
        if (this.BS > 0) {
            textView.setMaxWidth(this.BS);
        }
        if (this.aQR > 0) {
            textView.setMaxLines(this.aQR);
        }
        if (tbRichTextData == null) {
            return false;
        }
        SpannableStringBuilder In = tbRichTextData.In();
        if (In == null || In.length() <= 0) {
            return false;
        }
        int lineHeight = textView.getLineHeight();
        int textSize = lineHeight - ((int) textView.getTextSize());
        if (this.aQV) {
            this.aQq = k.g(getContext(), d.f.ds40);
            this.aQr = k.g(getContext(), d.f.ds40);
        }
        if (this.aQr > 0 && this.aQq > 0) {
            tbRichTextData.Q(this.aQq, this.aQr);
        }
        if (textSize > 0) {
            tbRichTextData.P(lineHeight, textSize);
        }
        if (bVar != null) {
            bVar.a(In, textView, this);
        }
        try {
            textView.setText(In);
        } catch (Exception e2) {
            textView.setText("");
        }
        if (this.aQS) {
            if (tbRichTextData.Ix()) {
                textView.setMovementMethod(com.baidu.tieba.view.b.bwx());
            } else {
                textView.setMovementMethod(LinkMovementMethod.getInstance());
            }
        }
        textView.setFocusable(false);
        if (this.aQV) {
            textView.setLineSpacing(k.g(getContext(), d.f.ds8), 1.0f);
        } else if (this.aQU) {
            layoutParams.leftMargin = aQb;
            layoutParams.rightMargin = aQb;
        }
        textView.setLayoutParams(layoutParams);
        textView.setTag(tbRichTextData);
        if (tbRichTextData != null && tbRichTextData.Ip() != null) {
            tbRichTextData.Ip().needRecompute = this.aRd;
        }
        return true;
    }

    private GifView getGifView() {
        GifView gifView = null;
        if (this.aQl != null) {
            gifView = this.aQl.fH();
        }
        GifView gifView2 = (gifView == null || gifView.getParent() != null) ? new GifView(getContext()) : gifView;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) gifView2.getLayoutParams();
        if (layoutParams != null) {
            if (this.aQU) {
                layoutParams.leftMargin = aQb;
                layoutParams.rightMargin = aQb;
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
        if (layoutParams == null || layoutParams.width != tbRichTextData.Ir().mGifInfo.mGifWidth || layoutParams.height != tbRichTextData.Ir().mGifInfo.mGifHeight) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(tbRichTextData.Ir().mGifInfo.mGifWidth, tbRichTextData.Ir().mGifInfo.mGifHeight);
            layoutParams2.gravity = 3;
            if (this.aQU) {
                layoutParams2.leftMargin = aQb;
                layoutParams2.rightMargin = aQb;
            }
            gifView.setLayoutParams(layoutParams2);
        } else {
            layoutParams.bottomMargin = 0;
        }
        gifView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (TbRichTextView.this.aQK != null) {
                    TbRichTextEmotionInfo Ir = tbRichTextData.Ir();
                    TbRichTextView.this.aQK.a(view, Ir.mGifInfo.mGid, Ir.mGifInfo.mPackageName, Ir.mGifInfo.mIcon, Ir.mGifInfo.mStaticUrl, Ir.mGifInfo.mDynamicUrl, Ir.mGifInfo.mSharpText, Ir.mGifInfo.mGifWidth, Ir.mGifInfo.mGifHeight);
                }
            }
        });
        gifView.a(tbRichTextData.Ir().mGifInfo);
        return true;
    }

    private View getVoiceView() {
        View fH = this.aQj != null ? this.aQj.fH() : null;
        if ((fH == null || fH.getParent() != null) && this.aQF != -1) {
            fH = LayoutInflater.from(getContext()).inflate(this.aQF, (ViewGroup) null);
        }
        if (fH != null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.topMargin = this.aQo;
            if (!this.aQV) {
                layoutParams.bottomMargin = this.aQo;
            }
            fH.setLayoutParams(layoutParams);
            return fH;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v9, types: [android.view.View] */
    private View a(TbRichTextGraffitiInfo tbRichTextGraffitiInfo, int i, String str) {
        com.baidu.tieba.graffiti.c cVar = null;
        if (this.aQi != null) {
            cVar = this.aQi.fH();
        }
        if (cVar == null || cVar.getParent() != null) {
            cVar = new com.baidu.tieba.graffiti.c(getContext());
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = this.aQo;
        layoutParams.bottomMargin = this.aQo;
        if (this.aQU) {
            layoutParams.leftMargin = aQb;
            layoutParams.rightMargin = aQb;
        }
        cVar.setLayoutParams(layoutParams);
        if (cVar instanceof com.baidu.tieba.graffiti.c) {
            com.baidu.tieba.graffiti.c cVar2 = cVar;
            cVar2.k(this.aQE, false);
            if (cVar2.getGraffitiImageView() != null) {
                cVar2.getGraffitiImageView().setSupportNoImage(this.aQO);
                cVar2.getGraffitiImageView().setDefaultResource(this.UH);
            }
            if (cVar2.getSaveBtn() != null) {
                cVar2.getSaveBtn().setOnTouchListener(this.aLD);
            }
            cVar2.a(tbRichTextGraffitiInfo, i, str, this.aQt - (getPaddingLeft() + getPaddingRight()), getPaddingRight(), this.aRa);
        }
        return cVar;
    }

    private boolean a(TbRichTextData tbRichTextData, View view) {
        view.setTag(tbRichTextData.Io());
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LinearLayout.LayoutParams(-2, -2);
        }
        if (this.aQU) {
            layoutParams.leftMargin = aQb;
            layoutParams.rightMargin = aQb;
        }
        view.setLayoutParams(layoutParams);
        return true;
    }

    private View getTextVoiceView() {
        LinearLayout fH = this.aQk.fH();
        if (fH != null) {
            TextView aV = aV(getContext());
            if (aV == null) {
                this.aQk.n(fH);
                return null;
            }
            fH.addView(aV);
            View voiceView = getVoiceView();
            if (voiceView == null) {
                this.aQh.n(aV);
                this.aQk.n(fH);
                return null;
            }
            fH.addView(voiceView);
            return fH;
        }
        return fH;
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
        if (applyDimension != this.aQp) {
            this.aQp = applyDimension;
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
        if (this.aQn != i) {
            this.aQn = i;
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (childAt != null && (childAt instanceof TextView)) {
                    ((TextView) childAt).setPadding(this.aQn, 0, 0, this.aQn);
                }
            }
        }
    }

    public void setLinkTextColor(int i) {
        if (i != this.aQs) {
            this.aQs = i;
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (childAt != null && (childAt instanceof TextView)) {
                    ((TextView) childAt).setLinkTextColor(i);
                }
            }
        }
    }

    private boolean S(int i, int i2) {
        if (this.aQX <= 0) {
            return false;
        }
        return ((((float) i) / ((float) this.aQX)) > aQe ? 1 : ((((float) i) / ((float) this.aQX)) == aQe ? 0 : -1)) > 0;
    }

    public int getMaxImageWidth() {
        return this.aQt;
    }

    public void setMaxImageWidth(int i) {
        this.aQt = i;
    }

    public int getMaxImageHeight() {
        return this.aQu;
    }

    public void setMaxImageHeight(int i) {
        this.aQu = i;
    }

    public ImageView.ScaleType getScaleType() {
        return this.aQv;
    }

    public void setScaleType(ImageView.ScaleType scaleType) {
        this.aQv = scaleType;
    }

    public int getDefaultImageId() {
        return this.UH;
    }

    public void setDefaultImageId(int i) {
        this.UH = i;
    }

    public e getOnImageClickListener() {
        return this.aQA;
    }

    public void setOnImageClickListener(e eVar) {
        this.aQA = eVar;
    }

    public void setOnImageTouchListener(com.baidu.tieba.pb.a.c cVar) {
        this.aQB = cVar;
    }

    public void setOnEmotionClickListener(d dVar) {
        this.aQK = dVar;
    }

    public void k(boolean z, boolean z2) {
        if (this.aQE != z) {
            this.aQE = z;
            if (z2) {
                requestLayout();
            }
            if (!this.aQE && this.aQg != null) {
                this.aQg.clear();
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
        this.aQG = false;
        switch (motionEvent.getAction()) {
            case 1:
            case 3:
                if (!this.aQH) {
                    IX();
                    break;
                } else if (!this.aQT) {
                    motionEvent.setAction(3);
                    break;
                }
                break;
        }
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        switch (motionEvent.getAction()) {
            case 0:
                if (!this.aQG) {
                    IW();
                    break;
                }
                break;
        }
        return dispatchTouchEvent;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.aQG = true;
        return super.onTouchEvent(motionEvent);
    }

    private void IW() {
        this.aQH = false;
        if (this.aQI == null) {
            this.aQI = new a();
        }
        postDelayed(this.aQI, ViewConfiguration.getLongPressTimeout());
    }

    private void IX() {
        if (this.aQI != null) {
            removeCallbacks(this.aQI);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!TbRichTextView.this.aQT && !TbRichTextView.this.aQZ && TbRichTextView.this.performLongClick()) {
                TbRichTextView.this.aQH = true;
            }
        }
    }

    public void setVoiceViewRes(int i) {
        this.aQF = i;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        this.aQN = null;
        if (this.aRe != drawable) {
            this.aRd = true;
            this.aRe = drawable;
        }
        setText(this.aQM);
        this.aRd = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Ek();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        Ek();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 8 || i == 4) {
            Ek();
        } else {
            refresh();
        }
    }

    public void gV(String str) {
        BdUniqueId bdUniqueId;
        boolean z;
        if (TextUtils.isEmpty(str)) {
            this.mUrl = str;
            return;
        }
        getContext();
        com.baidu.adp.base.h X = com.baidu.adp.base.i.X(getContext());
        if (X != null) {
            bdUniqueId = X.getUniqueId();
            z = X.isScroll();
        } else {
            bdUniqueId = null;
            z = false;
        }
        if (!(str.equals(this.mUrl) && this.mPageId == bdUniqueId)) {
            Ek();
        }
        this.mUrl = str;
        this.mPageId = bdUniqueId;
        setBackgroundDrawable(null);
        com.baidu.adp.widget.a.a aVar = (com.baidu.adp.widget.a.a) com.baidu.adp.lib.f.c.fJ().a(this.mUrl, 19, new Object[0]);
        if (aVar != null) {
            e(aVar);
        } else if (z) {
            invalidate();
        } else if (!com.baidu.adp.lib.f.c.fJ().al(19)) {
            invalidate();
        } else {
            com.baidu.adp.lib.f.c.fJ().a(this.mUrl, 19, this.aKW, 0, 0, this.mPageId, new Object[0]);
        }
    }

    public void Ek() {
        if (!TextUtils.isEmpty(this.mUrl)) {
            com.baidu.adp.lib.f.c.fJ().a(this.mUrl, 19, this.aKW);
            setBackgroundDrawable(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(com.baidu.adp.widget.a.a aVar) {
        if (aVar != null) {
            try {
                NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(getResources(), aVar.kN(), aVar.kN().getNinePatchChunk(), aVar.kR(), null);
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
        gV(this.mUrl);
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
        return this.aQC;
    }

    public void setOnLinkImageClickListener(f fVar) {
        this.aQC = fVar;
    }

    public void setHasMovementMethod(boolean z) {
        this.aQS = z;
    }

    public void setTextCenter(boolean z) {
        this.aQP = z;
    }

    public void setIsNeedShowImages(boolean z) {
        this.aQL = z;
    }
}
