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
    private static final int aQW = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds32);
    private static final int aQX = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds48);
    private static final float aQY = k.ag(TbadkCoreApplication.getInst());
    private static final float aQZ;
    static int aRa;
    private int Bn;
    private int Vl;
    private final com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> aLQ;
    private final View.OnTouchListener aMx;
    private final com.baidu.tieba.pb.a.c aOk;
    private int aRA;
    private boolean aRB;
    private boolean aRC;
    private Runnable aRD;
    private boolean aRE;
    private d aRF;
    private boolean aRG;
    private TbRichText aRH;
    private String aRI;
    private boolean aRJ;
    private boolean aRK;
    private boolean aRL;
    private int aRM;
    private boolean aRN;
    private boolean aRO;
    private boolean aRP;
    private boolean aRQ;
    private int aRR;
    private int aRS;
    private boolean aRT;
    private boolean aRU;
    private boolean aRV;
    public final View.OnClickListener aRW;
    private final TbImageView.b aRX;
    private boolean aRY;
    private Drawable aRZ;
    private com.baidu.adp.lib.e.b<ImageView> aRb;
    private com.baidu.adp.lib.e.b<TextView> aRc;
    private com.baidu.adp.lib.e.b<View> aRd;
    private com.baidu.adp.lib.e.b<View> aRe;
    private com.baidu.adp.lib.e.b<LinearLayout> aRf;
    private com.baidu.adp.lib.e.b<GifView> aRg;
    private float aRh;
    private int aRi;
    private int aRj;
    private float aRk;
    private int aRl;
    private int aRm;
    private int aRn;
    private int aRo;
    private int aRp;
    private ImageView.ScaleType aRq;
    private int aRr;
    private boolean aRs;
    private TextUtils.TruncateAt aRt;
    private g aRu;
    private e aRv;
    private com.baidu.tieba.pb.a.c aRw;
    private f aRx;
    private View.OnClickListener aRy;
    private boolean aRz;
    private CustomMessageListener aSa;
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
        aQZ = aQY > 0.0f ? 1.0f / aQY : 0.3f;
        aRa = 174;
    }

    public void setSubPbPost(boolean z) {
        this.aRT = z;
    }

    public void setShowGraffitiSaveBtn(boolean z) {
        this.aRV = z;
    }

    public boolean Jj() {
        return this.aRE;
    }

    public void Jk() {
        this.aRJ = true;
    }

    public String getBackgroundImageUrl() {
        return this.aRI;
    }

    public void setBackgroundImageUrl(String str) {
        this.aRI = str;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public void setMaxWidth(int i) {
        this.Bn = i;
    }

    public void setMaxLines(int i) {
        this.aRM = i;
    }

    public void setTextEllipsize(TextUtils.TruncateAt truncateAt) {
        this.aRt = truncateAt;
    }

    public void setIsSupportVitality(boolean z) {
        this.aRP = z;
    }

    public boolean getIsSupportVitality() {
        return this.aRP;
    }

    public void setIsSupportNewFirstFloor(boolean z) {
        this.aRQ = z;
    }

    public void setPbFirstFloorLastTextToBottom(int i) {
        this.aRR = i;
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
        super.setOnLongClickListener(onLongClickListener);
    }

    public float getLineSpacing() {
        return this.aRh;
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

    public static com.baidu.adp.lib.e.b<TextView> l(final Context context, int i) {
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
        this.aRb = null;
        this.aRc = null;
        this.aRd = null;
        this.aRe = null;
        this.aRf = null;
        this.aRg = null;
        this.aRh = 0.0f;
        this.aRi = 0;
        this.aRj = 0;
        this.aRk = 15.0f;
        this.aRl = -1;
        this.aRm = -1;
        this.mTextColor = ViewCompat.MEASURED_STATE_MASK;
        this.aRn = -9989158;
        this.aRo = 200;
        this.aRp = 200;
        this.aRq = null;
        this.Vl = 0;
        this.aRr = 0;
        this.aRs = false;
        this.aRt = null;
        this.aRu = null;
        this.aRv = null;
        this.aRw = null;
        this.aRx = null;
        this.aRy = null;
        this.aRz = true;
        this.mIsFromCDN = true;
        this.aRA = -1;
        this.aRB = false;
        this.aRC = false;
        this.aRD = null;
        this.aRE = false;
        this.aRG = true;
        this.aRI = null;
        this.aRJ = false;
        this.aRK = false;
        this.Bn = -1;
        this.aRM = -1;
        this.aRN = true;
        this.aRO = false;
        this.aRP = false;
        this.aRQ = false;
        this.aRR = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds34);
        this.aRT = false;
        this.aRU = false;
        this.aRV = true;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                if (TbRichTextView.this.aRv != null && (view instanceof ImageView)) {
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
                    TbRichTextView.this.aRv.a(view, str, i);
                }
            }
        };
        this.aOk = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.5
            @Override // com.baidu.tieba.pb.a.c.a
            public boolean a(View view, MotionEvent motionEvent) {
                if (TbRichTextView.this.aRw != null) {
                    TbRichTextView.this.aRw.bf(view);
                    return TbRichTextView.this.aRw.onDoubleTap(motionEvent);
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
        this.aRW = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                if (TbRichTextView.this.aRx != null && (view instanceof TbImageView)) {
                    Object tag = view.getTag();
                    if (tag == null || !(tag instanceof c)) {
                        str = null;
                    } else {
                        str = ((c) tag).url;
                    }
                    TbRichTextView.this.aRx.b(view, str);
                }
            }
        };
        this.aMx = new View.OnTouchListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.12
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    TbRichTextView.this.aRO = true;
                } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                    TbRichTextView.this.aRO = false;
                }
                return false;
            }
        };
        this.aRX = new TbImageView.b() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.2
            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void n(MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    TbRichTextView.this.aRU = true;
                } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                    TbRichTextView.this.aRU = false;
                }
            }
        };
        this.mType = 19;
        this.aLQ = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.3
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
        this.aSa = new CustomMessageListener(CmdConfigCustom.PB_RICHTEXT_CHANGE_CMD) { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (TbRichTextView.this.aRT) {
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
        this.aRb = null;
        this.aRc = null;
        this.aRd = null;
        this.aRe = null;
        this.aRf = null;
        this.aRg = null;
        this.aRh = 0.0f;
        this.aRi = 0;
        this.aRj = 0;
        this.aRk = 15.0f;
        this.aRl = -1;
        this.aRm = -1;
        this.mTextColor = ViewCompat.MEASURED_STATE_MASK;
        this.aRn = -9989158;
        this.aRo = 200;
        this.aRp = 200;
        this.aRq = null;
        this.Vl = 0;
        this.aRr = 0;
        this.aRs = false;
        this.aRt = null;
        this.aRu = null;
        this.aRv = null;
        this.aRw = null;
        this.aRx = null;
        this.aRy = null;
        this.aRz = true;
        this.mIsFromCDN = true;
        this.aRA = -1;
        this.aRB = false;
        this.aRC = false;
        this.aRD = null;
        this.aRE = false;
        this.aRG = true;
        this.aRI = null;
        this.aRJ = false;
        this.aRK = false;
        this.Bn = -1;
        this.aRM = -1;
        this.aRN = true;
        this.aRO = false;
        this.aRP = false;
        this.aRQ = false;
        this.aRR = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds34);
        this.aRT = false;
        this.aRU = false;
        this.aRV = true;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                if (TbRichTextView.this.aRv != null && (view instanceof ImageView)) {
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
                    TbRichTextView.this.aRv.a(view, str, i);
                }
            }
        };
        this.aOk = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.5
            @Override // com.baidu.tieba.pb.a.c.a
            public boolean a(View view, MotionEvent motionEvent) {
                if (TbRichTextView.this.aRw != null) {
                    TbRichTextView.this.aRw.bf(view);
                    return TbRichTextView.this.aRw.onDoubleTap(motionEvent);
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
        this.aRW = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                if (TbRichTextView.this.aRx != null && (view instanceof TbImageView)) {
                    Object tag = view.getTag();
                    if (tag == null || !(tag instanceof c)) {
                        str = null;
                    } else {
                        str = ((c) tag).url;
                    }
                    TbRichTextView.this.aRx.b(view, str);
                }
            }
        };
        this.aMx = new View.OnTouchListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.12
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    TbRichTextView.this.aRO = true;
                } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                    TbRichTextView.this.aRO = false;
                }
                return false;
            }
        };
        this.aRX = new TbImageView.b() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.2
            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void n(MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    TbRichTextView.this.aRU = true;
                } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                    TbRichTextView.this.aRU = false;
                }
            }
        };
        this.mType = 19;
        this.aLQ = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.3
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
        this.aSa = new CustomMessageListener(CmdConfigCustom.PB_RICHTEXT_CHANGE_CMD) { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (TbRichTextView.this.aRT) {
                    TbRichTextView.this.setTextSize(TbConfig.getContentSizeOfLzl());
                } else {
                    TbRichTextView.this.setTextSize(TbConfig.getContentSize());
                }
            }
        };
        init();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.n.TbRichTextView);
        this.aRj = obtainStyledAttributes.getDimensionPixelSize(d.n.TbRichTextView_segmentMargin, 0);
        this.aRi = obtainStyledAttributes.getDimensionPixelSize(d.n.TbRichTextView_textPadding, 0);
        this.aRh = obtainStyledAttributes.getFloat(d.n.TbRichTextView_lineSpacing, 1.12f);
        this.aRk = obtainStyledAttributes.getDimensionPixelSize(d.n.TbRichTextView_textSize, (int) this.aRk);
        this.mTextColor = obtainStyledAttributes.getColor(d.n.TbRichTextView_textColor, this.mTextColor);
        this.aRo = obtainStyledAttributes.getDimensionPixelSize(d.n.TbRichTextView_maxImageWidth, this.aRo);
        this.aRp = obtainStyledAttributes.getDimensionPixelSize(d.n.TbRichTextView_maxImageHeight, this.aRp);
        this.Vl = obtainStyledAttributes.getResourceId(d.n.TbRichTextView_defaultImage, 0);
        this.aRl = obtainStyledAttributes.getDimensionPixelSize(d.n.TbRichTextView_faceWidth, this.aRl);
        this.aRm = obtainStyledAttributes.getDimensionPixelSize(d.n.TbRichTextView_faceHeight, this.aRm);
        this.aRr = obtainStyledAttributes.getResourceId(d.n.TbRichTextView_videoImage, 0);
        this.aRs = obtainStyledAttributes.getBoolean(d.n.TbRichTextView_singleLine, false);
        obtainStyledAttributes.recycle();
    }

    public void setLineSpacing(float f2) {
        this.aRh = f2;
    }

    private void init() {
        aRa = getContext().getResources().getDimensionPixelSize(d.f.ds348);
        com.baidu.tbadk.widget.richText.d dVar = null;
        com.baidu.adp.base.e<?> Y = com.baidu.adp.base.i.Y(getContext());
        if (getContext() instanceof com.baidu.tbadk.widget.richText.d) {
            dVar = (com.baidu.tbadk.widget.richText.d) getContext();
        } else if (Y != null && (Y.getOrignalPage() instanceof com.baidu.tbadk.widget.richText.d)) {
            dVar = (com.baidu.tbadk.widget.richText.d) Y.getOrignalPage();
        }
        if (Y != null) {
            Y.registerListener(this.aSa);
        }
        if (dVar != null) {
            this.aRb = dVar.Ja();
            this.aRc = dVar.Jb();
            this.aRe = dVar.Jd();
            this.aRf = dVar.Je();
            this.aRg = dVar.Jc();
            this.aRd = dVar.Jf();
            if (dVar.getListView() != null && this.aRu == null) {
                this.aRu = new g(dVar.IZ());
                dVar.getListView().setRecyclerListener(this.aRu);
            }
        }
        setOrientation(1);
        setOnHierarchyChangeListener(new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.8
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof GifView) && TbRichTextView.this.aRg != null) {
                    TbRichTextView.this.aRg.m((GifView) view2);
                } else if ((view2 instanceof ImageView) && TbRichTextView.this.aRb != null) {
                    TbRichTextView.this.aRb.m((ImageView) view2);
                } else if ((view2 instanceof TextView) && TbRichTextView.this.aRc != null) {
                    TbRichTextView.this.aRc.m((TextView) view2);
                } else if ((view2 instanceof PlayVoiceBnt) && TbRichTextView.this.aRe != null) {
                    TbRichTextView.this.aRe.m(view2);
                } else if ((view2 instanceof com.baidu.tieba.graffiti.c) && TbRichTextView.this.aRd != null) {
                    TbRichTextView.this.aRd.m(view2);
                } else if ((view2 instanceof PlayVoiceBntNew) && TbRichTextView.this.aRe != null) {
                    TbRichTextView.this.aRe.m(view2);
                }
                if (view2 instanceof LinearLayout) {
                    Object tag = view2.getTag();
                    if (tag == null || !(tag instanceof String) || !"VideoView".equals(tag)) {
                        if (TbRichTextView.this.aRf != null) {
                            int childCount = ((LinearLayout) view2).getChildCount();
                            for (int i = 0; i < childCount; i++) {
                                View childAt = ((LinearLayout) view2).getChildAt(i);
                                if (childAt != null) {
                                    if ((childAt instanceof TextView) && TbRichTextView.this.aRc != null) {
                                        TbRichTextView.this.aRc.m((TextView) childAt);
                                    } else if ((childAt instanceof PlayVoiceBnt) && TbRichTextView.this.aRe != null) {
                                        TbRichTextView.this.aRe.m(childAt);
                                    } else if ((childAt instanceof PlayVoiceBntNew) && TbRichTextView.this.aRe != null) {
                                        TbRichTextView.this.aRe.m(childAt);
                                    }
                                }
                            }
                            ((LinearLayout) view2).removeAllViews();
                            TbRichTextView.this.aRf.m((LinearLayout) view2);
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
        this.aRS = k.ae(getContext());
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
        if (this.aRH != tbRichText || (tbRichText != null && tbRichText.isChanged)) {
            if (tbRichText != null) {
                tbRichText.isChanged = false;
            }
            this.aRH = tbRichText;
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
                            TextView bc = bc(getContext());
                            boolean a3 = a(next, bc, true, bVar);
                            if (z && !this.aRE && (IC = next.IC()) != null) {
                                this.aRE = IC.length() >= 200;
                            }
                            if (this.aRw != null) {
                                bc.setOnTouchListener(this.aOk);
                            } else {
                                bc.setOnClickListener(this.aRy);
                            }
                            z2 = a3;
                            i = i4;
                            i2 = i3;
                            view = bc;
                        } else if (next.getType() == 8 && this.aRG) {
                            if (i3 < 10) {
                                ImageView bb = bb(getContext());
                                z2 = b(next, bb, this.aRo, this.aRp);
                                view = bb;
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
                        } else if (next.getType() == 20 && this.aRG) {
                            if (i4 < 10) {
                                ImageView bb2 = bb(getContext());
                                z2 = b(next, bb2, this.aRo, this.aRp);
                                view = bb2;
                                i = i4 + 1;
                                i2 = i3;
                            }
                        } else if (next.getType() != 1280 || !this.aRG) {
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
                            ImageView bb3 = bb(getContext());
                            z2 = a(next, bb3, (this.aRo - getPaddingLeft()) - getPaddingRight(), this.aRp);
                            view = bb3;
                            i = i4;
                            i2 = i3 + 1;
                        }
                        if (!z2 || view == null) {
                            view2 = view3;
                        } else {
                            addView(view);
                            view2 = view;
                        }
                        if (z4 && this.aRQ) {
                            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
                            if (layoutParams != null) {
                                layoutParams.topMargin = k.f(getContext(), d.f.ds0);
                                view.setLayoutParams(layoutParams);
                            }
                            z3 = false;
                        } else {
                            if ((view instanceof ImageView) && (next.getType() == 8 || next.getType() == 20 || next.getType() == 17)) {
                                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) view.getLayoutParams();
                                view2.setLayoutParams(layoutParams2);
                                int f2 = k.f(getContext(), d.f.ds20);
                                int f3 = k.f(getContext(), d.f.ds16);
                                if (this.aRQ) {
                                    f2 = k.f(getContext(), d.f.ds34);
                                    f3 = k.f(getContext(), d.f.ds16);
                                }
                                if ((i2 == 1 && i == 0) || (i2 == 0 && i == 1)) {
                                    layoutParams2.topMargin = f2;
                                } else if (i2 > 1 || i > 1) {
                                    layoutParams2.topMargin = f3;
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
                    if (this.aRQ) {
                        layoutParams3.bottomMargin = this.aRR;
                    } else {
                        layoutParams3.bottomMargin = this.aRj;
                    }
                    view3.setLayoutParams(layoutParams3);
                } else if (view3 != null && this.aRQ) {
                    LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) view3.getLayoutParams();
                    layoutParams4.bottomMargin = k.f(getContext(), d.f.ds34);
                    view3.setLayoutParams(layoutParams4);
                }
            }
        }
    }

    public void setCommonTextViewOnClickListener(View.OnClickListener onClickListener) {
        this.aRy = onClickListener;
    }

    private View b(final com.baidu.tbadk.widget.richText.e eVar) {
        if (eVar == null || !eVar.isAvaliable()) {
            return null;
        }
        ImageView fI = this.aRb.fI();
        if (fI instanceof ForeDrawableImageView) {
            ForeDrawableImageView foreDrawableImageView = (ForeDrawableImageView) fI;
            foreDrawableImageView.setForegroundDrawable(d.g.icon_play_video);
            foreDrawableImageView.setNoImageBottomTextColor(d.e.cp_cont_c);
            foreDrawableImageView.setNoImageBottomTextPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds32));
            foreDrawableImageView.setNoImageBottomTextSize(TbadkCoreApplication.getInst().getResources().getDimension(d.f.fontsize28));
            foreDrawableImageView.setNoImageBottomText("点击播放视频");
            foreDrawableImageView.setInterceptOnClick(false);
            foreDrawableImageView.setTag("VideoView");
            a(foreDrawableImageView, eVar.getWidth(), eVar.getHeight(), (this.aRo - getPaddingLeft()) - getPaddingRight(), this.aRp, new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.9
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log("c10643");
                    XiaoyingUtil.startPlayXiaoyingVideo(TbRichTextView.this.getContext(), eVar.getVideoUrl(), eVar.getWidth(), eVar.getHeight(), eVar.getThumbUrl());
                }
            });
            foreDrawableImageView.setDefaultResource(0);
            foreDrawableImageView.setSupportNoImage(this.aRJ);
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
        if (this.aRP && R(i, i2) && this.aRS > 0) {
            i3 = this.aRS;
            i4 = (int) (i3 * 1.618f);
        }
        int[] b2 = k.b(i, i2, i3, i4);
        if (b2 == null) {
            return false;
        }
        int[] iArr = {b2[0], b2[1]};
        int i6 = iArr[0];
        int i7 = iArr[1];
        if (!this.aRL || i3 <= i6 || aQY <= 1.0f) {
            i3 = i6;
            i5 = i7;
        } else {
            if (i6 * aQY <= i3) {
                if (i6 * aQY > i3 * 0.68f) {
                    i3 = (int) (i3 * 0.68f);
                } else {
                    i3 = (int) (i6 * aQY);
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
        if (this.aRL) {
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        } else if (this.aRq == null) {
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        } else {
            imageView.setScaleType(this.aRq);
        }
        if (this.aRP) {
            if (R(i, i2)) {
                layoutParams.width = -1;
                layoutParams.leftMargin = 0;
            } else {
                layoutParams.leftMargin = aQW;
            }
        }
        imageView.setClickable(true);
        imageView.setFocusable(false);
        if (this.aRw != null && (imageView instanceof TbImageView)) {
            ((TbImageView) imageView).setTbGestureDetector(this.aOk);
            imageView.setClickable(true);
        } else {
            imageView.setOnClickListener(onClickListener);
        }
        imageView.setLayoutParams(layoutParams);
        if ((imageView instanceof TbImageView) && this.onLongClickListener != null) {
            ((TbImageView) imageView).setDispatchTouchListener(this.aRX);
            imageView.setOnLongClickListener(this.onLongClickListener);
        }
        return true;
    }

    private LinearLayout a(final TbRichTextData tbRichTextData) {
        if (this.aRr <= 0 || tbRichTextData == null) {
            return null;
        }
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setTag("VideoView");
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = this.aRj;
        linearLayout.setClickable(true);
        Bitmap cT = aj.cT(this.aRr);
        if (cT != null) {
            linearLayout.setBackgroundDrawable(new BitmapDrawable(getContext().getResources(), cT));
        }
        linearLayout.setFocusable(false);
        if (this.aRP) {
            layoutParams.leftMargin = aQW;
            layoutParams.rightMargin = aQW;
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
                    com.baidu.adp.base.e<?> Y = com.baidu.adp.base.i.Y(TbRichTextView.this.getContext());
                    if (Y != null && (Y.getOrignalPage() instanceof com.baidu.tbadk.widget.richText.d)) {
                        ((com.baidu.tbadk.widget.richText.d) Y.getOrignalPage()).ab(TbRichTextView.this.getContext(), tbRichTextData.IC().toString());
                    }
                }
            }
        });
        return linearLayout;
    }

    public int getVideoImageId() {
        return this.aRr;
    }

    public void setVideoImageId(int i) {
        this.aRr = i;
    }

    private ImageView bb(Context context) {
        ImageView fI = this.aRb != null ? this.aRb.fI() : null;
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
                if (this.aRJ) {
                    tbImageView.setSupportNoImage(true);
                }
                tbImageView.c(IJ.IY(), this.mIsFromCDN ? 17 : 18, false);
                tbImageView.setTag(new c(IJ.getLink()));
                if (!IJ.IR()) {
                    tbImageView.setAdjustViewBounds(false);
                }
            }
            return a(imageView, IJ.getWidth(), IJ.getHeight(), i, i2, this.aRW);
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
            if (this.aRJ) {
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
        this.aRL = z;
    }

    private TextView bc(Context context) {
        TextView textView = null;
        if (this.aRc != null) {
            textView = this.aRc.fI();
        }
        if (textView == null || textView.getParent() != null) {
            textView = new TbListTextView(context);
        }
        textView.setPadding(this.aRi, 0, this.aRi, 0);
        return textView;
    }

    private boolean a(TbRichTextData tbRichTextData, TextView textView, boolean z, b bVar) {
        LinearLayout.LayoutParams layoutParams;
        if (z) {
            layoutParams = new LinearLayout.LayoutParams(-1, -2);
        } else {
            layoutParams = new LinearLayout.LayoutParams(-2, -2);
        }
        if (this.aRK) {
            layoutParams.gravity = 16;
            textView.setGravity(16);
        } else {
            layoutParams.topMargin = this.aRj;
        }
        textView.setLineSpacing(0.0f, this.aRh);
        textView.setTextSize(0, this.aRk);
        textView.setTextColor(this.mTextColor);
        textView.setLinkTextColor(aj.getColor(d.e.cp_link_tip_c));
        textView.setHighlightColor(getContext().getResources().getColor(d.e.transparent));
        textView.setSingleLine(this.aRs);
        if (this.aRt != null) {
            textView.setEllipsize(this.aRt);
        }
        if (this.Bn > 0) {
            textView.setMaxWidth(this.Bn);
        }
        if (this.aRM > 0) {
            textView.setMaxLines(this.aRM);
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
        if (this.aRQ) {
            this.aRl = k.f(getContext(), d.f.ds40);
            this.aRm = k.f(getContext(), d.f.ds40);
        }
        if (this.aRm > 0 && this.aRl > 0) {
            tbRichTextData.P(this.aRl, this.aRm);
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
        if (this.aRN) {
            if (tbRichTextData.IM()) {
                textView.setMovementMethod(com.baidu.tieba.view.b.bwG());
            } else {
                textView.setMovementMethod(LinkMovementMethod.getInstance());
            }
        }
        textView.setFocusable(false);
        if (this.aRQ) {
            textView.setLineSpacing(k.f(getContext(), d.f.ds8), 1.0f);
        } else if (this.aRP) {
            layoutParams.leftMargin = aQW;
            layoutParams.rightMargin = aQW;
        }
        textView.setLayoutParams(layoutParams);
        textView.setTag(tbRichTextData);
        if (tbRichTextData != null && tbRichTextData.IE() != null) {
            tbRichTextData.IE().needRecompute = this.aRY;
        }
        return true;
    }

    private GifView getGifView() {
        GifView gifView = null;
        if (this.aRg != null) {
            gifView = this.aRg.fI();
        }
        GifView gifView2 = (gifView == null || gifView.getParent() != null) ? new GifView(getContext()) : gifView;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) gifView2.getLayoutParams();
        if (layoutParams != null) {
            if (this.aRP) {
                layoutParams.leftMargin = aQW;
                layoutParams.rightMargin = aQW;
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
            if (this.aRP) {
                layoutParams2.leftMargin = aQW;
                layoutParams2.rightMargin = aQW;
            }
            gifView.setLayoutParams(layoutParams2);
        } else {
            layoutParams.bottomMargin = 0;
        }
        gifView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (TbRichTextView.this.aRF != null) {
                    TbRichTextEmotionInfo IG = tbRichTextData.IG();
                    TbRichTextView.this.aRF.a(view, IG.mGifInfo.mGid, IG.mGifInfo.mPackageName, IG.mGifInfo.mIcon, IG.mGifInfo.mStaticUrl, IG.mGifInfo.mDynamicUrl, IG.mGifInfo.mSharpText, IG.mGifInfo.mGifWidth, IG.mGifInfo.mGifHeight);
                }
            }
        });
        gifView.a(tbRichTextData.IG().mGifInfo);
        return true;
    }

    private View getVoiceView() {
        View fI = this.aRe != null ? this.aRe.fI() : null;
        if ((fI == null || fI.getParent() != null) && this.aRA != -1) {
            fI = LayoutInflater.from(getContext()).inflate(this.aRA, (ViewGroup) null);
        }
        if (fI != null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.topMargin = this.aRj;
            if (!this.aRQ) {
                layoutParams.bottomMargin = this.aRj;
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
        if (this.aRd != null) {
            cVar = this.aRd.fI();
        }
        if (cVar == null || cVar.getParent() != null) {
            cVar = new com.baidu.tieba.graffiti.c(getContext());
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = this.aRj;
        layoutParams.bottomMargin = this.aRj;
        if (this.aRP) {
            layoutParams.leftMargin = aQW;
            layoutParams.rightMargin = aQW;
        }
        cVar.setLayoutParams(layoutParams);
        if (cVar instanceof com.baidu.tieba.graffiti.c) {
            com.baidu.tieba.graffiti.c cVar2 = cVar;
            cVar2.l(this.aRz, false);
            if (cVar2.getGraffitiImageView() != null) {
                cVar2.getGraffitiImageView().setSupportNoImage(this.aRJ);
                cVar2.getGraffitiImageView().setDefaultResource(this.Vl);
            }
            if (cVar2.getSaveBtn() != null) {
                cVar2.getSaveBtn().setOnTouchListener(this.aMx);
            }
            cVar2.a(tbRichTextGraffitiInfo, i, str, this.aRo - (getPaddingLeft() + getPaddingRight()), getPaddingRight(), this.aRV);
        }
        return cVar;
    }

    private boolean a(TbRichTextData tbRichTextData, View view) {
        view.setTag(tbRichTextData.ID());
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LinearLayout.LayoutParams(-2, -2);
        }
        if (this.aRP) {
            layoutParams.leftMargin = aQW;
            layoutParams.rightMargin = aQW;
        }
        view.setLayoutParams(layoutParams);
        return true;
    }

    private View getTextVoiceView() {
        LinearLayout fI = this.aRf.fI();
        if (fI != null) {
            TextView bc = bc(getContext());
            if (bc == null) {
                this.aRf.m(fI);
                return null;
            }
            fI.addView(bc);
            View voiceView = getVoiceView();
            if (voiceView == null) {
                this.aRc.m(bc);
                this.aRf.m(fI);
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
        if (f2 != this.aRk) {
            this.aRk = f2;
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
        if (this.aRi != i) {
            this.aRi = i;
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (childAt != null && (childAt instanceof TextView)) {
                    ((TextView) childAt).setPadding(this.aRi, 0, 0, this.aRi);
                }
            }
        }
    }

    public void setLinkTextColor(int i) {
        if (i != this.aRn) {
            this.aRn = i;
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
        if (this.aRS <= 0) {
            return false;
        }
        return ((((float) i) / ((float) this.aRS)) > aQZ ? 1 : ((((float) i) / ((float) this.aRS)) == aQZ ? 0 : -1)) > 0;
    }

    public int getMaxImageWidth() {
        return this.aRo;
    }

    public void setMaxImageWidth(int i) {
        this.aRo = i;
    }

    public int getMaxImageHeight() {
        return this.aRp;
    }

    public void setMaxImageHeight(int i) {
        this.aRp = i;
    }

    public ImageView.ScaleType getScaleType() {
        return this.aRq;
    }

    public void setScaleType(ImageView.ScaleType scaleType) {
        this.aRq = scaleType;
    }

    public int getDefaultImageId() {
        return this.Vl;
    }

    public void setDefaultImageId(int i) {
        this.Vl = i;
    }

    public e getOnImageClickListener() {
        return this.aRv;
    }

    public void setOnImageClickListener(e eVar) {
        this.aRv = eVar;
    }

    public void setOnImageTouchListener(com.baidu.tieba.pb.a.c cVar) {
        this.aRw = cVar;
    }

    public void setOnEmotionClickListener(d dVar) {
        this.aRF = dVar;
    }

    public void l(boolean z, boolean z2) {
        if (this.aRz != z) {
            this.aRz = z;
            if (z2) {
                requestLayout();
            }
            if (!this.aRz && this.aRb != null) {
                this.aRb.clear();
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
        this.aRB = false;
        switch (motionEvent.getAction()) {
            case 1:
            case 3:
                if (!this.aRC) {
                    Jm();
                    break;
                } else if (!this.aRO) {
                    motionEvent.setAction(3);
                    break;
                }
                break;
        }
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        switch (motionEvent.getAction()) {
            case 0:
                if (!this.aRB) {
                    Jl();
                    break;
                }
                break;
        }
        return dispatchTouchEvent;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.aRB = true;
        return super.onTouchEvent(motionEvent);
    }

    private void Jl() {
        this.aRC = false;
        if (this.aRD == null) {
            this.aRD = new a();
        }
        postDelayed(this.aRD, ViewConfiguration.getLongPressTimeout());
    }

    private void Jm() {
        if (this.aRD != null) {
            removeCallbacks(this.aRD);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!TbRichTextView.this.aRO && !TbRichTextView.this.aRU && TbRichTextView.this.performLongClick()) {
                TbRichTextView.this.aRC = true;
            }
        }
    }

    public void setVoiceViewRes(int i) {
        this.aRA = i;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        this.aRI = null;
        if (this.aRZ != drawable) {
            this.aRY = true;
            this.aRZ = drawable;
        }
        setText(this.aRH);
        this.aRY = false;
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
        com.baidu.adp.base.h W = com.baidu.adp.base.i.W(getContext());
        if (W != null) {
            bdUniqueId = W.getUniqueId();
            z = W.isScroll();
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
            com.baidu.adp.lib.f.c.fK().a(this.mUrl, 19, this.aLQ, 0, 0, this.mPageId, new Object[0]);
        }
    }

    public void Eq() {
        if (!TextUtils.isEmpty(this.mUrl)) {
            com.baidu.adp.lib.f.c.fK().a(this.mUrl, 19, this.aLQ);
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
        return this.aRx;
    }

    public void setOnLinkImageClickListener(f fVar) {
        this.aRx = fVar;
    }

    public void setHasMovementMethod(boolean z) {
        this.aRN = z;
    }

    public void setTextCenter(boolean z) {
        this.aRK = z;
    }

    public void setIsNeedShowImages(boolean z) {
        this.aRG = z;
    }
}
