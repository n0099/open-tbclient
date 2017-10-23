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
import com.baidu.adp.b.a.i;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
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
public class TbRichTextView extends LinearLayout implements i {
    private static final int aRL = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds32);
    private static final int aRM = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds48);
    private static final float aRN = l.ag(TbadkCoreApplication.getInst());
    private static final float aRO;
    static int aRP;
    private int Bq;
    private ImageView.ScaleType GO;
    private int Vn;
    private final com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a> aLf;
    private final com.baidu.tieba.pb.a.c aNN;
    private com.baidu.adp.lib.e.b<ImageView> aRQ;
    private com.baidu.adp.lib.e.b<TextView> aRR;
    private com.baidu.adp.lib.e.b<View> aRS;
    private com.baidu.adp.lib.e.b<LinearLayout> aRT;
    private com.baidu.adp.lib.e.b<RelativeLayout> aRU;
    private com.baidu.adp.lib.e.b<GifView> aRV;
    private float aRW;
    private int aRX;
    private int aRY;
    private float aRZ;
    private int aSA;
    private boolean aSB;
    private boolean aSC;
    private boolean aSD;
    private int aSE;
    private int aSF;
    private boolean aSG;
    private boolean aSH;
    public final View.OnClickListener aSI;
    private final d aSJ;
    private boolean aSK;
    private Drawable aSL;
    private CustomMessageListener aSM;
    private int aSa;
    private int aSb;
    private int aSc;
    private int aSd;
    private int aSe;
    private int aSf;
    private boolean aSg;
    private TextUtils.TruncateAt aSh;
    private h aSi;
    private f aSj;
    private com.baidu.tieba.pb.a.c aSk;
    private g aSl;
    private View.OnClickListener aSm;
    private boolean aSn;
    private int aSo;
    private boolean aSp;
    private boolean aSq;
    private Runnable aSr;
    private boolean aSs;
    private e aSt;
    private boolean aSu;
    private TbRichText aSv;
    private String aSw;
    private boolean aSx;
    private boolean aSy;
    private boolean aSz;
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
        void n(MotionEvent motionEvent);
    }

    /* loaded from: classes.dex */
    public interface e {
        void a(View view, String str, String str2, String str3, String str4, String str5, String str6, int i, int i2);
    }

    /* loaded from: classes.dex */
    public interface f {
        void a(View view, String str, int i);
    }

    /* loaded from: classes.dex */
    public interface g {
        void b(View view, String str);
    }

    static {
        aRO = aRN > 0.0f ? 1.0f / aRN : 0.3f;
        aRP = 174;
    }

    public void setSubPbPost(boolean z) {
        this.aSG = z;
    }

    public boolean Jm() {
        return this.aSs;
    }

    public void Jn() {
        this.aSx = true;
    }

    public String getBackgroundImageUrl() {
        return this.aSw;
    }

    public void setBackgroundImageUrl(String str) {
        this.aSw = str;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public void setMaxWidth(int i) {
        this.Bq = i;
    }

    public void setMaxLines(int i) {
        this.aSA = i;
    }

    public void setTextEllipsize(TextUtils.TruncateAt truncateAt) {
        this.aSh = truncateAt;
    }

    public void setIsSupportVitality(boolean z) {
        this.aSC = z;
    }

    public boolean getIsSupportVitality() {
        return this.aSC;
    }

    public void setIsSupportNewFirstFloor(boolean z) {
        this.aSD = z;
    }

    public void setPbFirstFloorLastTextToBottom(int i) {
        this.aSE = i;
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
        super.setOnLongClickListener(onLongClickListener);
    }

    public float getLineSpacing() {
        return this.aRW;
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

    public static com.baidu.adp.lib.e.b<TextView> k(final Context context, int i) {
        return new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<TextView>() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: Jq */
            public TextView fI() {
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
        this.aRQ = null;
        this.aRR = null;
        this.aRS = null;
        this.aRT = null;
        this.aRU = null;
        this.aRV = null;
        this.aRW = 0.0f;
        this.aRX = 0;
        this.aRY = 0;
        this.aRZ = 15.0f;
        this.aSa = -1;
        this.aSb = -1;
        this.mTextColor = ViewCompat.MEASURED_STATE_MASK;
        this.aSc = -9989158;
        this.aSd = 200;
        this.aSe = 200;
        this.GO = null;
        this.Vn = 0;
        this.aSf = 0;
        this.aSg = false;
        this.aSh = null;
        this.aSi = null;
        this.aSj = null;
        this.aSk = null;
        this.aSl = null;
        this.aSm = null;
        this.aSn = true;
        this.mIsFromCDN = true;
        this.aSo = -1;
        this.aSp = false;
        this.aSq = false;
        this.aSr = null;
        this.aSs = false;
        this.aSu = true;
        this.aSw = null;
        this.aSx = false;
        this.aSy = false;
        this.Bq = -1;
        this.aSA = -1;
        this.aSB = true;
        this.aSC = false;
        this.aSD = false;
        this.aSE = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds34);
        this.aSG = false;
        this.aSH = false;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                String str;
                int i = 0;
                if (TbRichTextView.this.aSj != null && (view instanceof ImageView)) {
                    Object tag = view.getTag();
                    if (tag != null && (tag instanceof TbRichText)) {
                        int childCount = TbRichTextView.this.getChildCount();
                        int i2 = -1;
                        while (i < childCount) {
                            i2++;
                            if (view.getParent() == TbRichTextView.this.getChildAt(i)) {
                                break;
                            }
                            i++;
                        }
                        TbRichTextView.this.aSj.a(view, null, i2);
                        return;
                    }
                    if (tag != null && (tag instanceof String)) {
                        url = (String) tag;
                    } else if ((view instanceof TbImageView) && (view.getTag(d.h.tag_rich_text_meme_info) instanceof TbRichTextMemeInfo)) {
                        TbRichTextMemeInfo tbRichTextMemeInfo = (TbRichTextMemeInfo) view.getTag(d.h.tag_rich_text_meme_info);
                        if (tbRichTextMemeInfo != null && tbRichTextMemeInfo.memeInfo != null) {
                            str = tbRichTextMemeInfo.memeInfo.pic_url;
                        } else {
                            str = "";
                        }
                        int childCount2 = TbRichTextView.this.getChildCount();
                        int i3 = -1;
                        while (i < childCount2) {
                            i3++;
                            if (view.getParent() == TbRichTextView.this.getChildAt(i)) {
                                break;
                            }
                            i++;
                        }
                        TbRichTextView.this.aSj.a(view, str, i3);
                        return;
                    } else {
                        url = view instanceof TbImageView ? ((TbImageView) view).getUrl() : null;
                    }
                    int childCount3 = TbRichTextView.this.getChildCount();
                    int i4 = -1;
                    while (i < childCount3) {
                        View childAt = TbRichTextView.this.getChildAt(i);
                        if (TbRichTextView.this.R(childAt)) {
                            i4++;
                        }
                        if (view == childAt) {
                            break;
                        }
                        i++;
                    }
                    TbRichTextView.this.aSj.a(view, url, i4);
                }
            }
        };
        this.aNN = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.4
            @Override // com.baidu.tieba.pb.a.c.a
            public boolean a(View view, MotionEvent motionEvent) {
                if (TbRichTextView.this.aSk != null) {
                    TbRichTextView.this.aSk.bb(view);
                    return TbRichTextView.this.aSk.onDoubleTap(motionEvent);
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
        this.aSI = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                if (TbRichTextView.this.aSl != null && (view instanceof TbImageView)) {
                    Object tag = view.getTag();
                    if (tag == null || !(tag instanceof c)) {
                        str = null;
                    } else {
                        str = ((c) tag).url;
                    }
                    TbRichTextView.this.aSl.b(view, str);
                }
            }
        };
        this.aSJ = new d() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.11
            @Override // com.baidu.tbadk.widget.richText.TbRichTextView.d
            public void n(MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    TbRichTextView.this.aSH = true;
                } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                    TbRichTextView.this.aSH = false;
                }
            }
        };
        this.mType = 19;
        this.aLf = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                TbRichTextView.this.g(aVar);
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
        this.aSM = new CustomMessageListener(CmdConfigCustom.PB_RICHTEXT_CHANGE_CMD) { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (TbRichTextView.this.aSG) {
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
        this.aRQ = null;
        this.aRR = null;
        this.aRS = null;
        this.aRT = null;
        this.aRU = null;
        this.aRV = null;
        this.aRW = 0.0f;
        this.aRX = 0;
        this.aRY = 0;
        this.aRZ = 15.0f;
        this.aSa = -1;
        this.aSb = -1;
        this.mTextColor = ViewCompat.MEASURED_STATE_MASK;
        this.aSc = -9989158;
        this.aSd = 200;
        this.aSe = 200;
        this.GO = null;
        this.Vn = 0;
        this.aSf = 0;
        this.aSg = false;
        this.aSh = null;
        this.aSi = null;
        this.aSj = null;
        this.aSk = null;
        this.aSl = null;
        this.aSm = null;
        this.aSn = true;
        this.mIsFromCDN = true;
        this.aSo = -1;
        this.aSp = false;
        this.aSq = false;
        this.aSr = null;
        this.aSs = false;
        this.aSu = true;
        this.aSw = null;
        this.aSx = false;
        this.aSy = false;
        this.Bq = -1;
        this.aSA = -1;
        this.aSB = true;
        this.aSC = false;
        this.aSD = false;
        this.aSE = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds34);
        this.aSG = false;
        this.aSH = false;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                String str;
                int i = 0;
                if (TbRichTextView.this.aSj != null && (view instanceof ImageView)) {
                    Object tag = view.getTag();
                    if (tag != null && (tag instanceof TbRichText)) {
                        int childCount = TbRichTextView.this.getChildCount();
                        int i2 = -1;
                        while (i < childCount) {
                            i2++;
                            if (view.getParent() == TbRichTextView.this.getChildAt(i)) {
                                break;
                            }
                            i++;
                        }
                        TbRichTextView.this.aSj.a(view, null, i2);
                        return;
                    }
                    if (tag != null && (tag instanceof String)) {
                        url = (String) tag;
                    } else if ((view instanceof TbImageView) && (view.getTag(d.h.tag_rich_text_meme_info) instanceof TbRichTextMemeInfo)) {
                        TbRichTextMemeInfo tbRichTextMemeInfo = (TbRichTextMemeInfo) view.getTag(d.h.tag_rich_text_meme_info);
                        if (tbRichTextMemeInfo != null && tbRichTextMemeInfo.memeInfo != null) {
                            str = tbRichTextMemeInfo.memeInfo.pic_url;
                        } else {
                            str = "";
                        }
                        int childCount2 = TbRichTextView.this.getChildCount();
                        int i3 = -1;
                        while (i < childCount2) {
                            i3++;
                            if (view.getParent() == TbRichTextView.this.getChildAt(i)) {
                                break;
                            }
                            i++;
                        }
                        TbRichTextView.this.aSj.a(view, str, i3);
                        return;
                    } else {
                        url = view instanceof TbImageView ? ((TbImageView) view).getUrl() : null;
                    }
                    int childCount3 = TbRichTextView.this.getChildCount();
                    int i4 = -1;
                    while (i < childCount3) {
                        View childAt = TbRichTextView.this.getChildAt(i);
                        if (TbRichTextView.this.R(childAt)) {
                            i4++;
                        }
                        if (view == childAt) {
                            break;
                        }
                        i++;
                    }
                    TbRichTextView.this.aSj.a(view, url, i4);
                }
            }
        };
        this.aNN = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.4
            @Override // com.baidu.tieba.pb.a.c.a
            public boolean a(View view, MotionEvent motionEvent) {
                if (TbRichTextView.this.aSk != null) {
                    TbRichTextView.this.aSk.bb(view);
                    return TbRichTextView.this.aSk.onDoubleTap(motionEvent);
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
        this.aSI = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                if (TbRichTextView.this.aSl != null && (view instanceof TbImageView)) {
                    Object tag = view.getTag();
                    if (tag == null || !(tag instanceof c)) {
                        str = null;
                    } else {
                        str = ((c) tag).url;
                    }
                    TbRichTextView.this.aSl.b(view, str);
                }
            }
        };
        this.aSJ = new d() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.11
            @Override // com.baidu.tbadk.widget.richText.TbRichTextView.d
            public void n(MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    TbRichTextView.this.aSH = true;
                } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                    TbRichTextView.this.aSH = false;
                }
            }
        };
        this.mType = 19;
        this.aLf = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                TbRichTextView.this.g(aVar);
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
        this.aSM = new CustomMessageListener(CmdConfigCustom.PB_RICHTEXT_CHANGE_CMD) { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (TbRichTextView.this.aSG) {
                    TbRichTextView.this.setTextSize(TbConfig.getContentSizeOfLzl());
                } else {
                    TbRichTextView.this.setTextSize(TbConfig.getContentSize());
                }
            }
        };
        init();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.n.TbRichTextView);
        this.aRY = obtainStyledAttributes.getDimensionPixelSize(d.n.TbRichTextView_segmentMargin, 0);
        this.aRX = obtainStyledAttributes.getDimensionPixelSize(d.n.TbRichTextView_textPadding, 0);
        this.aRW = obtainStyledAttributes.getFloat(d.n.TbRichTextView_lineSpacing, 1.12f);
        this.aRZ = obtainStyledAttributes.getDimensionPixelSize(d.n.TbRichTextView_textSize, (int) this.aRZ);
        this.mTextColor = obtainStyledAttributes.getColor(d.n.TbRichTextView_textColor, this.mTextColor);
        this.aSd = obtainStyledAttributes.getDimensionPixelSize(d.n.TbRichTextView_maxImageWidth, this.aSd);
        this.aSe = obtainStyledAttributes.getDimensionPixelSize(d.n.TbRichTextView_maxImageHeight, this.aSe);
        this.Vn = obtainStyledAttributes.getResourceId(d.n.TbRichTextView_defaultImage, 0);
        this.aSa = obtainStyledAttributes.getDimensionPixelSize(d.n.TbRichTextView_faceWidth, this.aSa);
        this.aSb = obtainStyledAttributes.getDimensionPixelSize(d.n.TbRichTextView_faceHeight, this.aSb);
        this.aSf = obtainStyledAttributes.getResourceId(d.n.TbRichTextView_videoImage, 0);
        this.aSg = obtainStyledAttributes.getBoolean(d.n.TbRichTextView_singleLine, false);
        obtainStyledAttributes.recycle();
    }

    public void setLineSpacing(float f2) {
        this.aRW = f2;
    }

    private void init() {
        aRP = getContext().getResources().getDimensionPixelSize(d.f.ds348);
        com.baidu.tbadk.widget.richText.d dVar = null;
        com.baidu.adp.base.e<?> Y = com.baidu.adp.base.i.Y(getContext());
        if (getContext() instanceof com.baidu.tbadk.widget.richText.d) {
            dVar = (com.baidu.tbadk.widget.richText.d) getContext();
        } else if (Y != null && (Y.getOrignalPage() instanceof com.baidu.tbadk.widget.richText.d)) {
            dVar = (com.baidu.tbadk.widget.richText.d) Y.getOrignalPage();
        }
        if (Y != null) {
            Y.registerListener(this.aSM);
        }
        if (dVar != null) {
            this.aRQ = dVar.Jd();
            this.aRR = dVar.Je();
            this.aRS = dVar.Jg();
            this.aRT = dVar.Jh();
            this.aRV = dVar.Jf();
            this.aRU = dVar.Ji();
            if (dVar.getListView() != null && this.aSi == null) {
                this.aSi = new h(dVar.Jc());
                dVar.getListView().setRecyclerListener(this.aSi);
            }
        }
        setOrientation(1);
        setOnHierarchyChangeListener(new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.7
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof GifView) && TbRichTextView.this.aRV != null) {
                    TbRichTextView.this.aRV.m((GifView) view2);
                } else if ((view2 instanceof ImageView) && TbRichTextView.this.aRQ != null) {
                    TbRichTextView.this.aRQ.m((ImageView) view2);
                } else if ((view2 instanceof TextView) && TbRichTextView.this.aRR != null) {
                    TbRichTextView.this.aRR.m((TextView) view2);
                } else if ((view2 instanceof PlayVoiceBnt) && TbRichTextView.this.aRS != null) {
                    TbRichTextView.this.aRS.m(view2);
                } else if ((view2 instanceof PlayVoiceBntNew) && TbRichTextView.this.aRS != null) {
                    TbRichTextView.this.aRS.m(view2);
                } else if ((view2 instanceof RelativeLayout) && TbRichTextView.this.aRU != null) {
                    TbRichTextView.this.aRU.m((RelativeLayout) view2);
                }
                if (view2 instanceof LinearLayout) {
                    Object tag = view2.getTag();
                    if (tag == null || !(tag instanceof String) || !"VideoView".equals(tag)) {
                        if (TbRichTextView.this.aRT != null) {
                            int childCount = ((LinearLayout) view2).getChildCount();
                            for (int i = 0; i < childCount; i++) {
                                View childAt = ((LinearLayout) view2).getChildAt(i);
                                if (childAt != null) {
                                    if ((childAt instanceof TextView) && TbRichTextView.this.aRR != null) {
                                        TbRichTextView.this.aRR.m((TextView) childAt);
                                    } else if ((childAt instanceof PlayVoiceBnt) && TbRichTextView.this.aRS != null) {
                                        TbRichTextView.this.aRS.m(childAt);
                                    } else if ((childAt instanceof PlayVoiceBntNew) && TbRichTextView.this.aRS != null) {
                                        TbRichTextView.this.aRS.m(childAt);
                                    }
                                }
                            }
                            ((LinearLayout) view2).removeAllViews();
                            TbRichTextView.this.aRT.m((LinearLayout) view2);
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
        this.aSF = l.ad(getContext());
    }

    public void setText(TbRichText tbRichText) {
        a(tbRichText, false);
    }

    public void a(TbRichText tbRichText, boolean z) {
        a(tbRichText, z, (b) null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r20v0, types: [com.baidu.tbadk.widget.richText.TbRichTextView] */
    /* JADX WARN: Type inference failed for: r7v0, types: [android.widget.TextView, android.view.View] */
    /* JADX WARN: Type inference failed for: r7v1, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v14 */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* JADX WARN: Type inference failed for: r7v6 */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r7v8 */
    public void a(TbRichText tbRichText, boolean z, b bVar) {
        ArrayList<TbRichTextData> Ix;
        ?? bb;
        int i;
        SpannableStringBuilder IE;
        View view;
        boolean z2;
        KeyEvent.Callback callback;
        boolean z3;
        if (this.aSv != tbRichText || (tbRichText != null && tbRichText.isChanged)) {
            if (tbRichText != null) {
                tbRichText.isChanged = false;
            }
            this.aSv = tbRichText;
            removeAllViews();
            if (tbRichText != null && (Ix = tbRichText.Ix()) != null) {
                boolean z4 = true;
                Iterator<TbRichTextData> it = Ix.iterator();
                int i2 = 0;
                View view2 = null;
                int i3 = 0;
                View view3 = null;
                while (it.hasNext()) {
                    TbRichTextData next = it.next();
                    boolean z5 = false;
                    if (next != null) {
                        if (next.getType() == 1) {
                            bb = bb(getContext());
                            boolean a2 = a(next, bb, true, bVar);
                            if (z && !this.aSs && (IE = next.IE()) != null) {
                                this.aSs = IE.length() >= 200;
                            }
                            if (this.aSk != null) {
                                bb.setOnTouchListener(this.aNN);
                            } else {
                                bb.setOnClickListener(this.aSm);
                            }
                            z5 = a2;
                            i = i2;
                        } else if (next.getType() == 8 && this.aSu) {
                            if (i2 < 10) {
                                ImageView ba = ba(getContext());
                                z5 = b(next, ba, this.aSd, this.aSe);
                                i = i2 + 1;
                                bb = ba;
                            }
                        } else if (next.getType() == 32) {
                            com.baidu.tbadk.widget.richText.e IH = next.IH();
                            if (IH != null && IH.Jk()) {
                                callback = b(IH);
                            } else {
                                callback = a(next);
                            }
                            i = i2;
                            bb = callback;
                            z5 = true;
                        } else if (next.getType() == 512) {
                            View voiceView = getVoiceView();
                            if (voiceView == null) {
                                view3 = voiceView;
                            } else {
                                i = i2;
                                bb = voiceView;
                                z5 = a(next, voiceView);
                            }
                        } else if (next.getType() == 768) {
                            View textVoiceView = getTextVoiceView();
                            z5 = a(next, (LinearLayout) textVoiceView, bVar);
                            i = i2;
                            bb = textVoiceView;
                        } else if (next.getType() == 17) {
                            GifView gifView = getGifView();
                            z5 = a(next, gifView);
                            i = i2;
                            bb = gifView;
                        } else if (next.getType() == 20 && this.aSu) {
                            if (i3 < 10) {
                                int i4 = i3 + 1;
                                if (next == null || next.IJ() == null || next.IJ().memeInfo == null || StringUtils.isNull(next.IJ().memeInfo.pic_url)) {
                                    z3 = false;
                                } else {
                                    z3 = true;
                                }
                                if (z3) {
                                    RelativeLayout fH = this.aRU.fH();
                                    fH.removeAllViews();
                                    fH.setLayoutParams(new LinearLayout.LayoutParams(next.IJ().memeInfo.width.intValue(), next.IJ().memeInfo.height.intValue()));
                                    if (p.Gp()) {
                                        b(fH, next.IJ().memeInfo.width.intValue(), next.IJ().memeInfo.height.intValue(), this.aSd, this.aSe);
                                    } else {
                                        a(fH, next.IJ().memeInfo.width.intValue(), next.IJ().memeInfo.height.intValue(), this.aSd, this.aSe);
                                    }
                                    ImageView fH2 = this.aRQ.fH();
                                    b(next, fH2, this.aSd, this.aSe);
                                    if (p.Gp()) {
                                        ImageView fH3 = this.aRQ.fH();
                                        fH3.setTag(this.aSv);
                                        int f2 = l.f(getContext(), d.f.ds78);
                                        int f3 = l.f(getContext(), d.f.ds78);
                                        aj.c(fH3, d.g.icon_emotion_dui_n);
                                        fH2.setId(d.h.meme_image_view);
                                        b(fH2, next.IJ().memeInfo.width.intValue(), next.IJ().memeInfo.height.intValue(), this.aSd, this.aSe, this.mOnClickListener);
                                        fH.addView(fH2);
                                        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(f2, f3);
                                        layoutParams.addRule(8, d.h.meme_image_view);
                                        layoutParams.addRule(11);
                                        fH3.setOnClickListener(this.mOnClickListener);
                                        fH.addView(fH3, layoutParams);
                                    } else {
                                        a(fH2, next.IJ().memeInfo.width.intValue(), next.IJ().memeInfo.height.intValue(), this.aSd, this.aSe, this.mOnClickListener);
                                        fH.addView(fH2);
                                    }
                                    z5 = z3;
                                    i3 = i4;
                                    i = i2;
                                    bb = fH;
                                } else {
                                    z5 = z3;
                                    i3 = i4;
                                    i = i2;
                                    bb = view3;
                                }
                            }
                        } else if (next.getType() == 1280 && this.aSu) {
                            ImageView ba2 = ba(getContext());
                            z5 = a(next, ba2, (this.aSd - getPaddingLeft()) - getPaddingRight(), this.aSe);
                            i = i2 + 1;
                            bb = ba2;
                        } else {
                            i = i2;
                            bb = view3;
                        }
                        if (!z5 || bb == null) {
                            view = view2;
                        } else {
                            addView(bb);
                            view = bb;
                        }
                        if (z4 && this.aSD) {
                            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) bb.getLayoutParams();
                            if (layoutParams2 != null) {
                                layoutParams2.topMargin = l.f(getContext(), d.f.ds0);
                                bb.setLayoutParams(layoutParams2);
                            }
                            z2 = false;
                        } else {
                            if (((bb instanceof ImageView) || (bb instanceof RelativeLayout)) && (next.getType() == 8 || next.getType() == 20 || next.getType() == 17)) {
                                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) bb.getLayoutParams();
                                view.setLayoutParams(layoutParams3);
                                int f4 = l.f(getContext(), d.f.ds20);
                                int f5 = l.f(getContext(), d.f.ds16);
                                if (this.aSD) {
                                    f4 = l.f(getContext(), d.f.ds34);
                                    f5 = l.f(getContext(), d.f.ds16);
                                }
                                if ((i == 1 && i3 == 0) || (i == 0 && i3 == 1)) {
                                    layoutParams3.topMargin = f4;
                                } else if (i > 1 || i3 > 1) {
                                    layoutParams3.topMargin = f5;
                                }
                                bb.setLayoutParams(layoutParams3);
                            }
                            z2 = z4;
                        }
                        z4 = z2;
                        i2 = i;
                        view2 = view;
                        view3 = bb;
                    }
                }
                if (view2 != null && !(view2 instanceof TbListTextView)) {
                    LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) view2.getLayoutParams();
                    if (this.aSD) {
                        layoutParams4.bottomMargin = this.aSE;
                    } else {
                        layoutParams4.bottomMargin = this.aRY;
                    }
                    view2.setLayoutParams(layoutParams4);
                } else if (view2 != null && this.aSD) {
                    LinearLayout.LayoutParams layoutParams5 = (LinearLayout.LayoutParams) view2.getLayoutParams();
                    layoutParams5.bottomMargin = l.f(getContext(), d.f.ds34);
                    view2.setLayoutParams(layoutParams5);
                }
            }
        }
    }

    public void setCommonTextViewOnClickListener(View.OnClickListener onClickListener) {
        this.aSm = onClickListener;
    }

    private View b(final com.baidu.tbadk.widget.richText.e eVar) {
        if (eVar == null || !eVar.isAvaliable()) {
            return null;
        }
        ImageView fH = this.aRQ.fH();
        if (fH instanceof ForeDrawableImageView) {
            ForeDrawableImageView foreDrawableImageView = (ForeDrawableImageView) fH;
            foreDrawableImageView.setForegroundDrawable(d.g.icon_play_video);
            foreDrawableImageView.setNoImageBottomTextColor(d.e.cp_cont_c);
            foreDrawableImageView.setNoImageBottomTextPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds32));
            foreDrawableImageView.setNoImageBottomTextSize(TbadkCoreApplication.getInst().getResources().getDimension(d.f.fontsize28));
            foreDrawableImageView.setNoImageBottomText("点击播放视频");
            foreDrawableImageView.setInterceptOnClick(false);
            foreDrawableImageView.setTag("VideoView");
            a(foreDrawableImageView, eVar.getWidth(), eVar.getHeight(), (this.aSd - getPaddingLeft()) - getPaddingRight(), this.aSe, new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log("c10643");
                    XiaoyingUtil.startPlayXiaoyingVideo(TbRichTextView.this.getContext(), eVar.getVideoUrl(), eVar.getWidth(), eVar.getHeight(), eVar.getThumbUrl());
                }
            });
            foreDrawableImageView.setDefaultResource(0);
            foreDrawableImageView.setSupportNoImage(this.aSx);
            if (com.baidu.tbadk.core.h.oM().oS()) {
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
        if (this.aSC && V(i, i2) && this.aSF > 0) {
            i3 = this.aSF;
            i4 = (int) (i3 * 1.618f);
        }
        int[] b2 = l.b(i, i2, i3, i4);
        if (b2 == null) {
            return false;
        }
        int[] iArr = {b2[0], b2[1]};
        int i6 = iArr[0];
        int i7 = iArr[1];
        if (!this.aSz || i3 <= i6 || aRN <= 1.0f) {
            i3 = i6;
            i5 = i7;
        } else {
            if (i6 * aRN <= i3) {
                if (i6 * aRN > i3 * 0.68f) {
                    i3 = (int) (i3 * 0.68f);
                } else {
                    i3 = (int) (i6 * aRN);
                }
            }
            i5 = iArr[0] > 0 ? (iArr[1] * i3) / iArr[0] : i7;
        }
        if (imageView instanceof TbImageView) {
            TbImageView tbImageView = (TbImageView) imageView;
            tbImageView.setDefaultResource(this.Vn);
            if (tbImageView.getGifIconWidth() >= i3 || tbImageView.getGifIconHeight() >= i5) {
                tbImageView.setGifIconSupport(false);
            } else {
                tbImageView.setGifIconSupport(true);
            }
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i3, i5);
        if (this.aSz) {
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        } else if (this.GO == null) {
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        } else {
            imageView.setScaleType(this.GO);
        }
        if (this.aSC) {
            if (V(i, i2)) {
                layoutParams.width = -1;
                layoutParams.leftMargin = 0;
            } else {
                layoutParams.leftMargin = aRL;
            }
        }
        imageView.setClickable(true);
        imageView.setFocusable(false);
        if (this.aSk != null && (imageView instanceof TbImageView)) {
            ((TbImageView) imageView).setTbGestureDetector(this.aNN);
            imageView.setClickable(true);
        } else {
            imageView.setOnClickListener(onClickListener);
        }
        imageView.setLayoutParams(layoutParams);
        if (imageView instanceof TbImageView) {
            if (this.onLongClickListener != null) {
                ((TbImageView) imageView).setDispatchTouchListener(this.aSJ);
                imageView.setOnLongClickListener(this.onLongClickListener);
            }
        } else if ((imageView instanceof GifView) && this.onLongClickListener != null) {
            imageView.setOnLongClickListener(this.onLongClickListener);
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0116  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean b(ImageView imageView, int i, int i2, int i3, int i4, View.OnClickListener onClickListener) {
        int i5;
        int i6;
        if (this.aSC && V(i, i2) && this.aSF > 0) {
            i3 = this.aSF;
            i4 = (int) (i3 * 1.618f);
        }
        int[] b2 = l.b(i, i2, i3, i4);
        if (b2 == null) {
            return false;
        }
        int[] iArr = {b2[0], b2[1]};
        int i7 = iArr[0];
        int i8 = iArr[1];
        if (this.aSz && i3 > i7 && aRN > 1.0f) {
            if (i7 * aRN > i3) {
                i7 = (i3 - l.f(getContext(), d.f.ds78)) - l.f(getContext(), d.f.ds16);
            } else if (i7 * aRN > i3 * 0.68f) {
                i7 = ((int) (i3 * 0.68f)) - l.f(getContext(), d.f.ds78);
            } else {
                i7 = (int) (i7 * aRN);
            }
            if (iArr[0] > 0) {
                i5 = (iArr[1] * i7) / iArr[0];
                i6 = i7;
                if (imageView instanceof TbImageView) {
                    TbImageView tbImageView = (TbImageView) imageView;
                    tbImageView.setDefaultResource(this.Vn);
                    if (tbImageView.getGifIconWidth() >= i6 || tbImageView.getGifIconHeight() >= i5) {
                        tbImageView.setGifIconSupport(false);
                    } else {
                        tbImageView.setGifIconSupport(true);
                    }
                }
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i6, i5);
                if (!this.aSz) {
                    imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                } else if (this.GO == null) {
                    imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                } else {
                    imageView.setScaleType(this.GO);
                }
                if (this.aSC) {
                    if (V(i, i2)) {
                        layoutParams.width = -1;
                        layoutParams.leftMargin = 0;
                    } else {
                        layoutParams.leftMargin = aRL;
                    }
                }
                imageView.setClickable(true);
                imageView.setFocusable(false);
                if (this.aSk == null && (imageView instanceof TbImageView)) {
                    ((TbImageView) imageView).setTbGestureDetector(this.aNN);
                    imageView.setClickable(true);
                } else {
                    imageView.setOnClickListener(onClickListener);
                }
                imageView.setLayoutParams(layoutParams);
                if (!(imageView instanceof TbImageView)) {
                    if (this.onLongClickListener != null) {
                        ((TbImageView) imageView).setDispatchTouchListener(this.aSJ);
                        imageView.setOnLongClickListener(this.onLongClickListener);
                    }
                } else if ((imageView instanceof GifView) && this.onLongClickListener != null) {
                    imageView.setOnLongClickListener(this.onLongClickListener);
                }
                return true;
            }
        }
        i5 = i8;
        i6 = i7;
        if (imageView instanceof TbImageView) {
        }
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(i6, i5);
        if (!this.aSz) {
        }
        if (this.aSC) {
        }
        imageView.setClickable(true);
        imageView.setFocusable(false);
        if (this.aSk == null) {
        }
        imageView.setOnClickListener(onClickListener);
        imageView.setLayoutParams(layoutParams2);
        if (!(imageView instanceof TbImageView)) {
        }
        return true;
    }

    private void a(RelativeLayout relativeLayout, int i, int i2, int i3, int i4) {
        if (this.aSC && V(i, i2) && this.aSF > 0) {
            i3 = this.aSF;
            i4 = (int) (i3 * 1.618f);
        }
        int[] b2 = l.b(i, i2, i3, i4);
        if (b2 != null) {
            int[] iArr = {b2[0], b2[1]};
            int i5 = iArr[0];
            int i6 = iArr[1];
            if (!this.aSz || i3 <= i5 || aRN <= 1.0f) {
                i3 = i5;
            } else {
                if (i5 * aRN <= i3) {
                    if (i5 * aRN > i3 * 0.68f) {
                        i3 = (int) (i3 * 0.68f);
                    } else {
                        i3 = (int) (i5 * aRN);
                    }
                }
                if (iArr[0] > 0) {
                    i6 = (iArr[1] * i3) / iArr[0];
                }
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i3, i6);
            if (this.aSC) {
                if (V(i, i2)) {
                    layoutParams.width = -1;
                    layoutParams.leftMargin = 0;
                } else {
                    layoutParams.leftMargin = aRL;
                }
            }
            relativeLayout.setLayoutParams(layoutParams);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0072  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void b(RelativeLayout relativeLayout, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        if (this.aSC && V(i, i2) && this.aSF > 0) {
            i3 = this.aSF;
            i4 = (int) (i3 * 1.618f);
        }
        int[] b2 = l.b(i, i2, i3, i4);
        if (b2 != null) {
            int[] iArr = {b2[0], b2[1]};
            int i7 = iArr[0];
            int i8 = iArr[1];
            if (this.aSz && i3 > i7 && aRN > 1.0f) {
                if (i7 * aRN > i3) {
                    i6 = (i3 - l.f(getContext(), d.f.ds78)) - l.f(getContext(), d.f.ds16);
                } else if (i7 * aRN > i3 * 0.68f) {
                    i6 = ((int) (i3 * 0.68f)) - l.f(getContext(), d.f.ds78);
                } else {
                    i6 = (int) (i7 * aRN);
                }
                if (iArr[0] > 0) {
                    i5 = (i6 * iArr[1]) / iArr[0];
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i3, i5);
                    if (this.aSC) {
                        if (V(i, i2)) {
                            layoutParams.width = -1;
                            layoutParams.leftMargin = 0;
                        } else {
                            layoutParams.leftMargin = aRL;
                        }
                    }
                    relativeLayout.setLayoutParams(layoutParams);
                }
            }
            i5 = i8;
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(i3, i5);
            if (this.aSC) {
            }
            relativeLayout.setLayoutParams(layoutParams2);
        }
    }

    private LinearLayout a(final TbRichTextData tbRichTextData) {
        if (this.aSf <= 0 || tbRichTextData == null) {
            return null;
        }
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setTag("VideoView");
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = this.aRY;
        linearLayout.setClickable(true);
        Bitmap cQ = aj.cQ(this.aSf);
        if (cQ != null) {
            linearLayout.setBackgroundDrawable(new BitmapDrawable(getContext().getResources(), cQ));
        }
        linearLayout.setFocusable(false);
        if (this.aSC) {
            layoutParams.leftMargin = aRL;
            layoutParams.rightMargin = aRL;
        }
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (tbRichTextData.IE() != null) {
                    if (TbRichTextView.this.getContext() instanceof com.baidu.tbadk.widget.richText.d) {
                        ((com.baidu.tbadk.widget.richText.d) TbRichTextView.this.getContext()).W(TbRichTextView.this.getContext(), tbRichTextData.IE().toString());
                        return;
                    }
                    com.baidu.adp.base.e<?> Y = com.baidu.adp.base.i.Y(TbRichTextView.this.getContext());
                    if (Y != null && (Y.getOrignalPage() instanceof com.baidu.tbadk.widget.richText.d)) {
                        ((com.baidu.tbadk.widget.richText.d) Y.getOrignalPage()).W(TbRichTextView.this.getContext(), tbRichTextData.IE().toString());
                    }
                }
            }
        });
        return linearLayout;
    }

    public int getVideoImageId() {
        return this.aSf;
    }

    public void setVideoImageId(int i) {
        this.aSf = i;
    }

    private ImageView ba(Context context) {
        ImageView fH = this.aRQ != null ? this.aRQ.fH() : null;
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
        TbRichTextLinkImageInfo IL = tbRichTextData.IL();
        if (IL != null && IL.getLink() != null) {
            if (imageView instanceof TbImageView) {
                TbImageView tbImageView = (TbImageView) imageView;
                if (this.aSx) {
                    tbImageView.setSupportNoImage(true);
                }
                tbImageView.c(IL.Jb(), this.mIsFromCDN ? 17 : 18, false);
                tbImageView.setTag(new c(IL.getLink()));
                if (!IL.IS()) {
                    tbImageView.setAdjustViewBounds(false);
                }
            }
            return a(imageView, IL.getWidth(), IL.getHeight(), i, i2, this.aSI);
        }
        return false;
    }

    private boolean b(TbRichTextData tbRichTextData, ImageView imageView, int i, int i2) {
        if (tbRichTextData == null || imageView == null) {
            return false;
        }
        if (tbRichTextData.getType() == 20) {
            if (tbRichTextData.IJ() == null) {
                return false;
            }
        } else if (tbRichTextData.ID() == null) {
            return false;
        }
        if (imageView instanceof TbImageView) {
            TbImageView tbImageView = (TbImageView) imageView;
            if (this.aSx) {
                tbImageView.setSupportNoImage(true);
            }
            if (tbRichTextData.getType() == 20) {
                tbImageView.c(tbRichTextData.IJ().memeInfo.pic_url, this.mIsFromCDN ? 17 : 18, false);
                tbImageView.setAdjustViewBounds(false);
                tbImageView.setTag(d.h.tag_rich_text_meme_info, tbRichTextData.IJ());
            } else {
                tbImageView.c(tbRichTextData.ID().IR(), this.mIsFromCDN ? 17 : 18, false);
                if (!tbRichTextData.ID().IS()) {
                    tbImageView.setAdjustViewBounds(false);
                }
                tbImageView.setTag(d.h.tag_rich_text_meme_info, null);
            }
        }
        if (tbRichTextData.getType() == 20) {
            return a(imageView, tbRichTextData.IJ().memeInfo.width.intValue(), tbRichTextData.IJ().memeInfo.height.intValue(), i, i2, this.mOnClickListener);
        }
        return a(imageView, tbRichTextData.ID().getWidth(), tbRichTextData.ID().getHeight(), i, i2, this.mOnClickListener);
    }

    public void setImageViewStretch(boolean z) {
        this.aSz = z;
    }

    private TextView bb(Context context) {
        TextView textView = null;
        if (this.aRR != null) {
            textView = this.aRR.fH();
        }
        if (textView == null || textView.getParent() != null) {
            textView = new TbListTextView(context);
        }
        textView.setPadding(this.aRX, 0, this.aRX, 0);
        return textView;
    }

    private boolean a(TbRichTextData tbRichTextData, TextView textView, boolean z, b bVar) {
        LinearLayout.LayoutParams layoutParams;
        if (z) {
            layoutParams = new LinearLayout.LayoutParams(-1, -2);
        } else {
            layoutParams = new LinearLayout.LayoutParams(-2, -2);
        }
        if (this.aSy) {
            layoutParams.gravity = 16;
            textView.setGravity(16);
        } else {
            layoutParams.topMargin = this.aRY;
        }
        textView.setLineSpacing(0.0f, this.aRW);
        textView.setTextSize(0, this.aRZ);
        textView.setTextColor(this.mTextColor);
        textView.setLinkTextColor(aj.getColor(d.e.cp_link_tip_c));
        textView.setHighlightColor(getContext().getResources().getColor(d.e.transparent));
        textView.setSingleLine(this.aSg);
        if (this.aSh != null) {
            textView.setEllipsize(this.aSh);
        }
        if (this.Bq > 0) {
            textView.setMaxWidth(this.Bq);
        }
        if (this.aSA > 0) {
            textView.setMaxLines(this.aSA);
        }
        if (tbRichTextData == null) {
            return false;
        }
        SpannableStringBuilder IE = tbRichTextData.IE();
        if (IE == null || IE.length() <= 0) {
            return false;
        }
        int lineHeight = textView.getLineHeight();
        int textSize = lineHeight - ((int) textView.getTextSize());
        if (this.aSD) {
            this.aSa = l.f(getContext(), d.f.ds40);
            this.aSb = l.f(getContext(), d.f.ds40);
        }
        if (this.aSb > 0 && this.aSa > 0) {
            tbRichTextData.T(this.aSa, this.aSb);
        }
        if (textSize > 0) {
            tbRichTextData.S(lineHeight, textSize);
        }
        if (bVar != null) {
            bVar.a(IE, textView, this);
        }
        try {
            textView.setText(IE);
        } catch (Exception e2) {
            textView.setText("");
        }
        if (this.aSB) {
            if (tbRichTextData.IN()) {
                textView.setMovementMethod(com.baidu.tieba.view.b.bxO());
            } else {
                textView.setMovementMethod(LinkMovementMethod.getInstance());
            }
        }
        textView.setFocusable(false);
        if (this.aSD) {
            textView.setLineSpacing(l.f(getContext(), d.f.ds8), 1.0f);
        } else if (this.aSC) {
            layoutParams.leftMargin = aRL;
            layoutParams.rightMargin = aRL;
        }
        textView.setLayoutParams(layoutParams);
        textView.setTag(tbRichTextData);
        if (tbRichTextData != null && tbRichTextData.IG() != null) {
            tbRichTextData.IG().needRecompute = this.aSK;
        }
        return true;
    }

    private GifView getGifView() {
        GifView gifView = null;
        if (this.aRV != null) {
            gifView = this.aRV.fH();
        }
        GifView gifView2 = (gifView == null || gifView.getParent() != null) ? new GifView(getContext()) : gifView;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) gifView2.getLayoutParams();
        if (layoutParams != null) {
            if (this.aSC) {
                layoutParams.leftMargin = aRL;
                layoutParams.rightMargin = aRL;
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
        if (layoutParams == null || layoutParams.width != tbRichTextData.II().mGifInfo.mGifWidth || layoutParams.height != tbRichTextData.II().mGifInfo.mGifHeight) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(tbRichTextData.II().mGifInfo.mGifWidth, tbRichTextData.II().mGifInfo.mGifHeight);
            layoutParams2.gravity = 3;
            if (this.aSC) {
                layoutParams2.leftMargin = aRL;
                layoutParams2.rightMargin = aRL;
            }
            gifView.setLayoutParams(layoutParams2);
        } else {
            layoutParams.bottomMargin = 0;
        }
        gifView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (TbRichTextView.this.aSt != null) {
                    TbRichTextEmotionInfo II = tbRichTextData.II();
                    TbRichTextView.this.aSt.a(view, II.mGifInfo.mGid, II.mGifInfo.mPackageName, II.mGifInfo.mIcon, II.mGifInfo.mStaticUrl, II.mGifInfo.mDynamicUrl, II.mGifInfo.mSharpText, II.mGifInfo.mGifWidth, II.mGifInfo.mGifHeight);
                }
            }
        });
        gifView.a(tbRichTextData.II().mGifInfo);
        return true;
    }

    private View getVoiceView() {
        View fH = this.aRS != null ? this.aRS.fH() : null;
        if ((fH == null || fH.getParent() != null) && this.aSo != -1) {
            fH = LayoutInflater.from(getContext()).inflate(this.aSo, (ViewGroup) null);
        }
        if (fH != null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.topMargin = this.aRY;
            if (!this.aSD) {
                layoutParams.bottomMargin = this.aRY;
            }
            fH.setLayoutParams(layoutParams);
            return fH;
        }
        return null;
    }

    private boolean a(TbRichTextData tbRichTextData, View view) {
        view.setTag(tbRichTextData.IF());
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LinearLayout.LayoutParams(-2, -2);
        }
        if (this.aSC) {
            layoutParams.leftMargin = aRL;
            layoutParams.rightMargin = aRL;
        }
        view.setLayoutParams(layoutParams);
        return true;
    }

    private View getTextVoiceView() {
        LinearLayout fH = this.aRT.fH();
        if (fH != null) {
            TextView bb = bb(getContext());
            if (bb == null) {
                this.aRT.m(fH);
                return null;
            }
            fH.addView(bb);
            View voiceView = getVoiceView();
            if (voiceView == null) {
                this.aRR.m(bb);
                this.aRT.m(fH);
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
        if (f2 != this.aRZ) {
            this.aRZ = f2;
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
        if (this.aRX != i) {
            this.aRX = i;
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (childAt != null && (childAt instanceof TextView)) {
                    ((TextView) childAt).setPadding(this.aRX, 0, 0, this.aRX);
                }
            }
        }
    }

    public void setLinkTextColor(int i) {
        if (i != this.aSc) {
            this.aSc = i;
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (childAt != null && (childAt instanceof TextView)) {
                    ((TextView) childAt).setLinkTextColor(i);
                }
            }
        }
    }

    private boolean V(int i, int i2) {
        if (this.aSF <= 0) {
            return false;
        }
        return ((((float) i) / ((float) this.aSF)) > aRO ? 1 : ((((float) i) / ((float) this.aSF)) == aRO ? 0 : -1)) > 0;
    }

    public int getMaxImageWidth() {
        return this.aSd;
    }

    public void setMaxImageWidth(int i) {
        this.aSd = i;
    }

    public int getMaxImageHeight() {
        return this.aSe;
    }

    public void setMaxImageHeight(int i) {
        this.aSe = i;
    }

    public ImageView.ScaleType getScaleType() {
        return this.GO;
    }

    public void setScaleType(ImageView.ScaleType scaleType) {
        this.GO = scaleType;
    }

    public int getDefaultImageId() {
        return this.Vn;
    }

    public void setDefaultImageId(int i) {
        this.Vn = i;
    }

    public f getOnImageClickListener() {
        return this.aSj;
    }

    public void setOnImageClickListener(f fVar) {
        this.aSj = fVar;
    }

    public void setOnImageTouchListener(com.baidu.tieba.pb.a.c cVar) {
        this.aSk = cVar;
    }

    public void setOnEmotionClickListener(e eVar) {
        this.aSt = eVar;
    }

    public void m(boolean z, boolean z2) {
        if (this.aSn != z) {
            this.aSn = z;
            if (z2) {
                requestLayout();
            }
            if (!this.aSn && this.aRQ != null) {
                this.aRQ.clear();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class h implements AbsListView.RecyclerListener {
        private int mId;

        public h(int i) {
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
        this.aSp = false;
        switch (motionEvent.getAction()) {
            case 1:
            case 3:
                if (!this.aSq) {
                    Jp();
                    break;
                }
                break;
        }
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        switch (motionEvent.getAction()) {
            case 0:
                if (!this.aSp) {
                    Jo();
                    break;
                }
                break;
        }
        return dispatchTouchEvent;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.aSp = true;
        return super.onTouchEvent(motionEvent);
    }

    private void Jo() {
        this.aSq = false;
        if (this.aSr == null) {
            this.aSr = new a();
        }
        postDelayed(this.aSr, ViewConfiguration.getLongPressTimeout());
    }

    private void Jp() {
        if (this.aSr != null) {
            removeCallbacks(this.aSr);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!TbRichTextView.this.aSH && TbRichTextView.this.performLongClick()) {
                TbRichTextView.this.aSq = true;
            }
        }
    }

    public void setVoiceViewRes(int i) {
        this.aSo = i;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        this.aSw = null;
        if (this.aSL != drawable) {
            this.aSK = true;
            this.aSL = drawable;
        }
        setText(this.aSv);
        this.aSK = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        DO();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        DO();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 8 || i == 4) {
            DO();
        } else {
            refresh();
        }
    }

    public void gW(String str) {
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
            DO();
        }
        this.mUrl = str;
        this.mPageId = bdUniqueId;
        setBackgroundDrawable(null);
        com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) com.baidu.adp.lib.f.c.fJ().a(this.mUrl, 19, new Object[0]);
        if (aVar != null) {
            g(aVar);
        } else if (z) {
            invalidate();
        } else if (!com.baidu.adp.lib.f.c.fJ().ao(19)) {
            invalidate();
        } else {
            com.baidu.adp.lib.f.c.fJ().a(this.mUrl, 19, this.aLf, 0, 0, this.mPageId, new Object[0]);
        }
    }

    public void DO() {
        if (!TextUtils.isEmpty(this.mUrl)) {
            com.baidu.adp.lib.f.c.fJ().a(this.mUrl, 19, this.aLf);
            setBackgroundDrawable(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(com.baidu.adp.widget.ImageView.a aVar) {
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
        gW(this.mUrl);
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

    public g getOnLinkImageClickListener() {
        return this.aSl;
    }

    public void setOnLinkImageClickListener(g gVar) {
        this.aSl = gVar;
    }

    public void setHasMovementMethod(boolean z) {
        this.aSB = z;
    }

    public void setTextCenter(boolean z) {
        this.aSy = z;
    }

    public void setIsNeedShowImages(boolean z) {
        this.aSu = z;
    }
}
