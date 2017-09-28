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
    private static final int aRY = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds32);
    private static final int aRZ = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds48);
    private static final float aSa = l.ag(TbadkCoreApplication.getInst());
    private static final float aSb;
    static int aSc;
    private int Bp;
    private ImageView.ScaleType GN;
    private int Vz;
    private final com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a> aLs;
    private final com.baidu.tieba.pb.a.c aOa;
    private boolean aSA;
    private int aSB;
    private boolean aSC;
    private boolean aSD;
    private Runnable aSE;
    private boolean aSF;
    private e aSG;
    private boolean aSH;
    private TbRichText aSI;
    private String aSJ;
    private boolean aSK;
    private boolean aSL;
    private boolean aSM;
    private int aSN;
    private boolean aSO;
    private boolean aSP;
    private boolean aSQ;
    private int aSR;
    private int aSS;
    private boolean aST;
    private boolean aSU;
    public final View.OnClickListener aSV;
    private final d aSW;
    private boolean aSX;
    private Drawable aSY;
    private CustomMessageListener aSZ;
    private com.baidu.adp.lib.e.b<ImageView> aSd;
    private com.baidu.adp.lib.e.b<TextView> aSe;
    private com.baidu.adp.lib.e.b<View> aSf;
    private com.baidu.adp.lib.e.b<LinearLayout> aSg;
    private com.baidu.adp.lib.e.b<RelativeLayout> aSh;
    private com.baidu.adp.lib.e.b<GifView> aSi;
    private float aSj;
    private int aSk;
    private int aSl;
    private float aSm;
    private int aSn;
    private int aSo;
    private int aSp;
    private int aSq;
    private int aSr;
    private int aSs;
    private boolean aSt;
    private TextUtils.TruncateAt aSu;
    private h aSv;
    private f aSw;
    private com.baidu.tieba.pb.a.c aSx;
    private g aSy;
    private View.OnClickListener aSz;
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
        aSb = aSa > 0.0f ? 1.0f / aSa : 0.3f;
        aSc = 174;
    }

    public void setSubPbPost(boolean z) {
        this.aST = z;
    }

    public boolean Js() {
        return this.aSF;
    }

    public void Jt() {
        this.aSK = true;
    }

    public String getBackgroundImageUrl() {
        return this.aSJ;
    }

    public void setBackgroundImageUrl(String str) {
        this.aSJ = str;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public void setMaxWidth(int i) {
        this.Bp = i;
    }

    public void setMaxLines(int i) {
        this.aSN = i;
    }

    public void setTextEllipsize(TextUtils.TruncateAt truncateAt) {
        this.aSu = truncateAt;
    }

    public void setIsSupportVitality(boolean z) {
        this.aSP = z;
    }

    public boolean getIsSupportVitality() {
        return this.aSP;
    }

    public void setIsSupportNewFirstFloor(boolean z) {
        this.aSQ = z;
    }

    public void setPbFirstFloorLastTextToBottom(int i) {
        this.aSR = i;
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
        super.setOnLongClickListener(onLongClickListener);
    }

    public float getLineSpacing() {
        return this.aSj;
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
        return new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<TextView>() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: Jw */
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
        this.aSd = null;
        this.aSe = null;
        this.aSf = null;
        this.aSg = null;
        this.aSh = null;
        this.aSi = null;
        this.aSj = 0.0f;
        this.aSk = 0;
        this.aSl = 0;
        this.aSm = 15.0f;
        this.aSn = -1;
        this.aSo = -1;
        this.mTextColor = ViewCompat.MEASURED_STATE_MASK;
        this.aSp = -9989158;
        this.aSq = 200;
        this.aSr = 200;
        this.GN = null;
        this.Vz = 0;
        this.aSs = 0;
        this.aSt = false;
        this.aSu = null;
        this.aSv = null;
        this.aSw = null;
        this.aSx = null;
        this.aSy = null;
        this.aSz = null;
        this.aSA = true;
        this.mIsFromCDN = true;
        this.aSB = -1;
        this.aSC = false;
        this.aSD = false;
        this.aSE = null;
        this.aSF = false;
        this.aSH = true;
        this.aSJ = null;
        this.aSK = false;
        this.aSL = false;
        this.Bp = -1;
        this.aSN = -1;
        this.aSO = true;
        this.aSP = false;
        this.aSQ = false;
        this.aSR = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds34);
        this.aST = false;
        this.aSU = false;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                String str;
                int i = 0;
                if (TbRichTextView.this.aSw != null && (view instanceof ImageView)) {
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
                        TbRichTextView.this.aSw.a(view, null, i2);
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
                        TbRichTextView.this.aSw.a(view, str, i3);
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
                    TbRichTextView.this.aSw.a(view, url, i4);
                }
            }
        };
        this.aOa = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.4
            @Override // com.baidu.tieba.pb.a.c.a
            public boolean a(View view, MotionEvent motionEvent) {
                if (TbRichTextView.this.aSx != null) {
                    TbRichTextView.this.aSx.bb(view);
                    return TbRichTextView.this.aSx.onDoubleTap(motionEvent);
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
        this.aSV = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                if (TbRichTextView.this.aSy != null && (view instanceof TbImageView)) {
                    Object tag = view.getTag();
                    if (tag == null || !(tag instanceof c)) {
                        str = null;
                    } else {
                        str = ((c) tag).url;
                    }
                    TbRichTextView.this.aSy.b(view, str);
                }
            }
        };
        this.aSW = new d() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.11
            @Override // com.baidu.tbadk.widget.richText.TbRichTextView.d
            public void n(MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    TbRichTextView.this.aSU = true;
                } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                    TbRichTextView.this.aSU = false;
                }
            }
        };
        this.mType = 19;
        this.aLs = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.2
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
        this.aSZ = new CustomMessageListener(CmdConfigCustom.PB_RICHTEXT_CHANGE_CMD) { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (TbRichTextView.this.aST) {
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
        this.aSd = null;
        this.aSe = null;
        this.aSf = null;
        this.aSg = null;
        this.aSh = null;
        this.aSi = null;
        this.aSj = 0.0f;
        this.aSk = 0;
        this.aSl = 0;
        this.aSm = 15.0f;
        this.aSn = -1;
        this.aSo = -1;
        this.mTextColor = ViewCompat.MEASURED_STATE_MASK;
        this.aSp = -9989158;
        this.aSq = 200;
        this.aSr = 200;
        this.GN = null;
        this.Vz = 0;
        this.aSs = 0;
        this.aSt = false;
        this.aSu = null;
        this.aSv = null;
        this.aSw = null;
        this.aSx = null;
        this.aSy = null;
        this.aSz = null;
        this.aSA = true;
        this.mIsFromCDN = true;
        this.aSB = -1;
        this.aSC = false;
        this.aSD = false;
        this.aSE = null;
        this.aSF = false;
        this.aSH = true;
        this.aSJ = null;
        this.aSK = false;
        this.aSL = false;
        this.Bp = -1;
        this.aSN = -1;
        this.aSO = true;
        this.aSP = false;
        this.aSQ = false;
        this.aSR = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds34);
        this.aST = false;
        this.aSU = false;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                String str;
                int i = 0;
                if (TbRichTextView.this.aSw != null && (view instanceof ImageView)) {
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
                        TbRichTextView.this.aSw.a(view, null, i2);
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
                        TbRichTextView.this.aSw.a(view, str, i3);
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
                    TbRichTextView.this.aSw.a(view, url, i4);
                }
            }
        };
        this.aOa = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.4
            @Override // com.baidu.tieba.pb.a.c.a
            public boolean a(View view, MotionEvent motionEvent) {
                if (TbRichTextView.this.aSx != null) {
                    TbRichTextView.this.aSx.bb(view);
                    return TbRichTextView.this.aSx.onDoubleTap(motionEvent);
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
        this.aSV = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                if (TbRichTextView.this.aSy != null && (view instanceof TbImageView)) {
                    Object tag = view.getTag();
                    if (tag == null || !(tag instanceof c)) {
                        str = null;
                    } else {
                        str = ((c) tag).url;
                    }
                    TbRichTextView.this.aSy.b(view, str);
                }
            }
        };
        this.aSW = new d() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.11
            @Override // com.baidu.tbadk.widget.richText.TbRichTextView.d
            public void n(MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    TbRichTextView.this.aSU = true;
                } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                    TbRichTextView.this.aSU = false;
                }
            }
        };
        this.mType = 19;
        this.aLs = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.2
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
        this.aSZ = new CustomMessageListener(CmdConfigCustom.PB_RICHTEXT_CHANGE_CMD) { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (TbRichTextView.this.aST) {
                    TbRichTextView.this.setTextSize(TbConfig.getContentSizeOfLzl());
                } else {
                    TbRichTextView.this.setTextSize(TbConfig.getContentSize());
                }
            }
        };
        init();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.n.TbRichTextView);
        this.aSl = obtainStyledAttributes.getDimensionPixelSize(d.n.TbRichTextView_segmentMargin, 0);
        this.aSk = obtainStyledAttributes.getDimensionPixelSize(d.n.TbRichTextView_textPadding, 0);
        this.aSj = obtainStyledAttributes.getFloat(d.n.TbRichTextView_lineSpacing, 1.12f);
        this.aSm = obtainStyledAttributes.getDimensionPixelSize(d.n.TbRichTextView_textSize, (int) this.aSm);
        this.mTextColor = obtainStyledAttributes.getColor(d.n.TbRichTextView_textColor, this.mTextColor);
        this.aSq = obtainStyledAttributes.getDimensionPixelSize(d.n.TbRichTextView_maxImageWidth, this.aSq);
        this.aSr = obtainStyledAttributes.getDimensionPixelSize(d.n.TbRichTextView_maxImageHeight, this.aSr);
        this.Vz = obtainStyledAttributes.getResourceId(d.n.TbRichTextView_defaultImage, 0);
        this.aSn = obtainStyledAttributes.getDimensionPixelSize(d.n.TbRichTextView_faceWidth, this.aSn);
        this.aSo = obtainStyledAttributes.getDimensionPixelSize(d.n.TbRichTextView_faceHeight, this.aSo);
        this.aSs = obtainStyledAttributes.getResourceId(d.n.TbRichTextView_videoImage, 0);
        this.aSt = obtainStyledAttributes.getBoolean(d.n.TbRichTextView_singleLine, false);
        obtainStyledAttributes.recycle();
    }

    public void setLineSpacing(float f2) {
        this.aSj = f2;
    }

    private void init() {
        aSc = getContext().getResources().getDimensionPixelSize(d.f.ds348);
        com.baidu.tbadk.widget.richText.d dVar = null;
        com.baidu.adp.base.e<?> Y = com.baidu.adp.base.i.Y(getContext());
        if (getContext() instanceof com.baidu.tbadk.widget.richText.d) {
            dVar = (com.baidu.tbadk.widget.richText.d) getContext();
        } else if (Y != null && (Y.getOrignalPage() instanceof com.baidu.tbadk.widget.richText.d)) {
            dVar = (com.baidu.tbadk.widget.richText.d) Y.getOrignalPage();
        }
        if (Y != null) {
            Y.registerListener(this.aSZ);
        }
        if (dVar != null) {
            this.aSd = dVar.Jj();
            this.aSe = dVar.Jk();
            this.aSf = dVar.Jm();
            this.aSg = dVar.Jn();
            this.aSi = dVar.Jl();
            this.aSh = dVar.Jo();
            if (dVar.getListView() != null && this.aSv == null) {
                this.aSv = new h(dVar.Ji());
                dVar.getListView().setRecyclerListener(this.aSv);
            }
        }
        setOrientation(1);
        setOnHierarchyChangeListener(new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.7
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof GifView) && TbRichTextView.this.aSi != null) {
                    TbRichTextView.this.aSi.m((GifView) view2);
                } else if ((view2 instanceof ImageView) && TbRichTextView.this.aSd != null) {
                    TbRichTextView.this.aSd.m((ImageView) view2);
                } else if ((view2 instanceof TextView) && TbRichTextView.this.aSe != null) {
                    TbRichTextView.this.aSe.m((TextView) view2);
                } else if ((view2 instanceof PlayVoiceBnt) && TbRichTextView.this.aSf != null) {
                    TbRichTextView.this.aSf.m(view2);
                } else if ((view2 instanceof PlayVoiceBntNew) && TbRichTextView.this.aSf != null) {
                    TbRichTextView.this.aSf.m(view2);
                } else if ((view2 instanceof RelativeLayout) && TbRichTextView.this.aSh != null) {
                    TbRichTextView.this.aSh.m((RelativeLayout) view2);
                }
                if (view2 instanceof LinearLayout) {
                    Object tag = view2.getTag();
                    if (tag == null || !(tag instanceof String) || !"VideoView".equals(tag)) {
                        if (TbRichTextView.this.aSg != null) {
                            int childCount = ((LinearLayout) view2).getChildCount();
                            for (int i = 0; i < childCount; i++) {
                                View childAt = ((LinearLayout) view2).getChildAt(i);
                                if (childAt != null) {
                                    if ((childAt instanceof TextView) && TbRichTextView.this.aSe != null) {
                                        TbRichTextView.this.aSe.m((TextView) childAt);
                                    } else if ((childAt instanceof PlayVoiceBnt) && TbRichTextView.this.aSf != null) {
                                        TbRichTextView.this.aSf.m(childAt);
                                    } else if ((childAt instanceof PlayVoiceBntNew) && TbRichTextView.this.aSf != null) {
                                        TbRichTextView.this.aSf.m(childAt);
                                    }
                                }
                            }
                            ((LinearLayout) view2).removeAllViews();
                            TbRichTextView.this.aSg.m((LinearLayout) view2);
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
        this.aSS = l.ad(getContext());
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
        ArrayList<TbRichTextData> ID;
        ?? bc;
        int i;
        SpannableStringBuilder IK;
        View view;
        boolean z2;
        KeyEvent.Callback callback;
        boolean z3;
        if (this.aSI != tbRichText || (tbRichText != null && tbRichText.isChanged)) {
            if (tbRichText != null) {
                tbRichText.isChanged = false;
            }
            this.aSI = tbRichText;
            removeAllViews();
            if (tbRichText != null && (ID = tbRichText.ID()) != null) {
                boolean z4 = true;
                Iterator<TbRichTextData> it = ID.iterator();
                int i2 = 0;
                View view2 = null;
                int i3 = 0;
                View view3 = null;
                while (it.hasNext()) {
                    TbRichTextData next = it.next();
                    boolean z5 = false;
                    if (next != null) {
                        if (next.getType() == 1) {
                            bc = bc(getContext());
                            boolean a2 = a(next, bc, true, bVar);
                            if (z && !this.aSF && (IK = next.IK()) != null) {
                                this.aSF = IK.length() >= 200;
                            }
                            if (this.aSx != null) {
                                bc.setOnTouchListener(this.aOa);
                            } else {
                                bc.setOnClickListener(this.aSz);
                            }
                            z5 = a2;
                            i = i2;
                        } else if (next.getType() == 8 && this.aSH) {
                            if (i2 < 10) {
                                ImageView bb = bb(getContext());
                                z5 = b(next, bb, this.aSq, this.aSr);
                                i = i2 + 1;
                                bc = bb;
                            }
                        } else if (next.getType() == 32) {
                            com.baidu.tbadk.widget.richText.e IN = next.IN();
                            if (IN != null && IN.Jq()) {
                                callback = b(IN);
                            } else {
                                callback = a(next);
                            }
                            i = i2;
                            bc = callback;
                            z5 = true;
                        } else if (next.getType() == 512) {
                            View voiceView = getVoiceView();
                            if (voiceView == null) {
                                view3 = voiceView;
                            } else {
                                i = i2;
                                bc = voiceView;
                                z5 = a(next, voiceView);
                            }
                        } else if (next.getType() == 768) {
                            View textVoiceView = getTextVoiceView();
                            z5 = a(next, (LinearLayout) textVoiceView, bVar);
                            i = i2;
                            bc = textVoiceView;
                        } else if (next.getType() == 17) {
                            GifView gifView = getGifView();
                            z5 = a(next, gifView);
                            i = i2;
                            bc = gifView;
                        } else if (next.getType() == 20 && this.aSH) {
                            if (i3 < 10) {
                                int i4 = i3 + 1;
                                if (next == null || next.IP() == null || next.IP().memeInfo == null || StringUtils.isNull(next.IP().memeInfo.pic_url)) {
                                    z3 = false;
                                } else {
                                    z3 = true;
                                }
                                if (z3) {
                                    RelativeLayout fH = this.aSh.fH();
                                    fH.removeAllViews();
                                    fH.setLayoutParams(new LinearLayout.LayoutParams(next.IP().memeInfo.width.intValue(), next.IP().memeInfo.height.intValue()));
                                    if (p.Gv()) {
                                        b(fH, next.IP().memeInfo.width.intValue(), next.IP().memeInfo.height.intValue(), this.aSq, this.aSr);
                                    } else {
                                        a(fH, next.IP().memeInfo.width.intValue(), next.IP().memeInfo.height.intValue(), this.aSq, this.aSr);
                                    }
                                    ImageView fH2 = this.aSd.fH();
                                    b(next, fH2, this.aSq, this.aSr);
                                    if (p.Gv()) {
                                        ImageView fH3 = this.aSd.fH();
                                        fH3.setTag(this.aSI);
                                        int f2 = l.f(getContext(), d.f.ds78);
                                        int f3 = l.f(getContext(), d.f.ds78);
                                        aj.c(fH3, d.g.icon_emotion_dui_n);
                                        fH2.setId(d.h.meme_image_view);
                                        b(fH2, next.IP().memeInfo.width.intValue(), next.IP().memeInfo.height.intValue(), this.aSq, this.aSr, this.mOnClickListener);
                                        fH.addView(fH2);
                                        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(f2, f3);
                                        layoutParams.addRule(8, d.h.meme_image_view);
                                        layoutParams.addRule(11);
                                        fH3.setOnClickListener(this.mOnClickListener);
                                        fH.addView(fH3, layoutParams);
                                    } else {
                                        a(fH2, next.IP().memeInfo.width.intValue(), next.IP().memeInfo.height.intValue(), this.aSq, this.aSr, this.mOnClickListener);
                                        fH.addView(fH2);
                                    }
                                    z5 = z3;
                                    i3 = i4;
                                    i = i2;
                                    bc = fH;
                                } else {
                                    z5 = z3;
                                    i3 = i4;
                                    i = i2;
                                    bc = view3;
                                }
                            }
                        } else if (next.getType() == 1280 && this.aSH) {
                            ImageView bb2 = bb(getContext());
                            z5 = a(next, bb2, (this.aSq - getPaddingLeft()) - getPaddingRight(), this.aSr);
                            i = i2 + 1;
                            bc = bb2;
                        } else {
                            i = i2;
                            bc = view3;
                        }
                        if (!z5 || bc == null) {
                            view = view2;
                        } else {
                            addView(bc);
                            view = bc;
                        }
                        if (z4 && this.aSQ) {
                            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) bc.getLayoutParams();
                            if (layoutParams2 != null) {
                                layoutParams2.topMargin = l.f(getContext(), d.f.ds0);
                                bc.setLayoutParams(layoutParams2);
                            }
                            z2 = false;
                        } else {
                            if (((bc instanceof ImageView) || (bc instanceof RelativeLayout)) && (next.getType() == 8 || next.getType() == 20 || next.getType() == 17)) {
                                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) bc.getLayoutParams();
                                view.setLayoutParams(layoutParams3);
                                int f4 = l.f(getContext(), d.f.ds20);
                                int f5 = l.f(getContext(), d.f.ds16);
                                if (this.aSQ) {
                                    f4 = l.f(getContext(), d.f.ds34);
                                    f5 = l.f(getContext(), d.f.ds16);
                                }
                                if ((i == 1 && i3 == 0) || (i == 0 && i3 == 1)) {
                                    layoutParams3.topMargin = f4;
                                } else if (i > 1 || i3 > 1) {
                                    layoutParams3.topMargin = f5;
                                }
                                bc.setLayoutParams(layoutParams3);
                            }
                            z2 = z4;
                        }
                        z4 = z2;
                        i2 = i;
                        view2 = view;
                        view3 = bc;
                    }
                }
                if (view2 != null && !(view2 instanceof TbListTextView)) {
                    LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) view2.getLayoutParams();
                    if (this.aSQ) {
                        layoutParams4.bottomMargin = this.aSR;
                    } else {
                        layoutParams4.bottomMargin = this.aSl;
                    }
                    view2.setLayoutParams(layoutParams4);
                } else if (view2 != null && this.aSQ) {
                    LinearLayout.LayoutParams layoutParams5 = (LinearLayout.LayoutParams) view2.getLayoutParams();
                    layoutParams5.bottomMargin = l.f(getContext(), d.f.ds34);
                    view2.setLayoutParams(layoutParams5);
                }
            }
        }
    }

    public void setCommonTextViewOnClickListener(View.OnClickListener onClickListener) {
        this.aSz = onClickListener;
    }

    private View b(final com.baidu.tbadk.widget.richText.e eVar) {
        if (eVar == null || !eVar.isAvaliable()) {
            return null;
        }
        ImageView fH = this.aSd.fH();
        if (fH instanceof ForeDrawableImageView) {
            ForeDrawableImageView foreDrawableImageView = (ForeDrawableImageView) fH;
            foreDrawableImageView.setForegroundDrawable(d.g.icon_play_video);
            foreDrawableImageView.setNoImageBottomTextColor(d.e.cp_cont_c);
            foreDrawableImageView.setNoImageBottomTextPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds32));
            foreDrawableImageView.setNoImageBottomTextSize(TbadkCoreApplication.getInst().getResources().getDimension(d.f.fontsize28));
            foreDrawableImageView.setNoImageBottomText("点击播放视频");
            foreDrawableImageView.setInterceptOnClick(false);
            foreDrawableImageView.setTag("VideoView");
            a(foreDrawableImageView, eVar.getWidth(), eVar.getHeight(), (this.aSq - getPaddingLeft()) - getPaddingRight(), this.aSr, new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log("c10643");
                    XiaoyingUtil.startPlayXiaoyingVideo(TbRichTextView.this.getContext(), eVar.getVideoUrl(), eVar.getWidth(), eVar.getHeight(), eVar.getThumbUrl());
                }
            });
            foreDrawableImageView.setDefaultResource(0);
            foreDrawableImageView.setSupportNoImage(this.aSK);
            if (com.baidu.tbadk.core.h.oT().oZ()) {
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
        if (this.aSP && V(i, i2) && this.aSS > 0) {
            i3 = this.aSS;
            i4 = (int) (i3 * 1.618f);
        }
        int[] b2 = l.b(i, i2, i3, i4);
        if (b2 == null) {
            return false;
        }
        int[] iArr = {b2[0], b2[1]};
        int i6 = iArr[0];
        int i7 = iArr[1];
        if (!this.aSM || i3 <= i6 || aSa <= 1.0f) {
            i3 = i6;
            i5 = i7;
        } else {
            if (i6 * aSa <= i3) {
                if (i6 * aSa > i3 * 0.68f) {
                    i3 = (int) (i3 * 0.68f);
                } else {
                    i3 = (int) (i6 * aSa);
                }
            }
            i5 = iArr[0] > 0 ? (iArr[1] * i3) / iArr[0] : i7;
        }
        if (imageView instanceof TbImageView) {
            TbImageView tbImageView = (TbImageView) imageView;
            tbImageView.setDefaultResource(this.Vz);
            if (tbImageView.getGifIconWidth() >= i3 || tbImageView.getGifIconHeight() >= i5) {
                tbImageView.setGifIconSupport(false);
            } else {
                tbImageView.setGifIconSupport(true);
            }
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i3, i5);
        if (this.aSM) {
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        } else if (this.GN == null) {
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        } else {
            imageView.setScaleType(this.GN);
        }
        if (this.aSP) {
            if (V(i, i2)) {
                layoutParams.width = -1;
                layoutParams.leftMargin = 0;
            } else {
                layoutParams.leftMargin = aRY;
            }
        }
        imageView.setClickable(true);
        imageView.setFocusable(false);
        if (this.aSx != null && (imageView instanceof TbImageView)) {
            ((TbImageView) imageView).setTbGestureDetector(this.aOa);
            imageView.setClickable(true);
        } else {
            imageView.setOnClickListener(onClickListener);
        }
        imageView.setLayoutParams(layoutParams);
        if (imageView instanceof TbImageView) {
            if (this.onLongClickListener != null) {
                ((TbImageView) imageView).setDispatchTouchListener(this.aSW);
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
        if (this.aSP && V(i, i2) && this.aSS > 0) {
            i3 = this.aSS;
            i4 = (int) (i3 * 1.618f);
        }
        int[] b2 = l.b(i, i2, i3, i4);
        if (b2 == null) {
            return false;
        }
        int[] iArr = {b2[0], b2[1]};
        int i7 = iArr[0];
        int i8 = iArr[1];
        if (this.aSM && i3 > i7 && aSa > 1.0f) {
            if (i7 * aSa > i3) {
                i7 = (i3 - l.f(getContext(), d.f.ds78)) - l.f(getContext(), d.f.ds16);
            } else if (i7 * aSa > i3 * 0.68f) {
                i7 = ((int) (i3 * 0.68f)) - l.f(getContext(), d.f.ds78);
            } else {
                i7 = (int) (i7 * aSa);
            }
            if (iArr[0] > 0) {
                i5 = (iArr[1] * i7) / iArr[0];
                i6 = i7;
                if (imageView instanceof TbImageView) {
                    TbImageView tbImageView = (TbImageView) imageView;
                    tbImageView.setDefaultResource(this.Vz);
                    if (tbImageView.getGifIconWidth() >= i6 || tbImageView.getGifIconHeight() >= i5) {
                        tbImageView.setGifIconSupport(false);
                    } else {
                        tbImageView.setGifIconSupport(true);
                    }
                }
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i6, i5);
                if (!this.aSM) {
                    imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                } else if (this.GN == null) {
                    imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                } else {
                    imageView.setScaleType(this.GN);
                }
                if (this.aSP) {
                    if (V(i, i2)) {
                        layoutParams.width = -1;
                        layoutParams.leftMargin = 0;
                    } else {
                        layoutParams.leftMargin = aRY;
                    }
                }
                imageView.setClickable(true);
                imageView.setFocusable(false);
                if (this.aSx == null && (imageView instanceof TbImageView)) {
                    ((TbImageView) imageView).setTbGestureDetector(this.aOa);
                    imageView.setClickable(true);
                } else {
                    imageView.setOnClickListener(onClickListener);
                }
                imageView.setLayoutParams(layoutParams);
                if (!(imageView instanceof TbImageView)) {
                    if (this.onLongClickListener != null) {
                        ((TbImageView) imageView).setDispatchTouchListener(this.aSW);
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
        if (!this.aSM) {
        }
        if (this.aSP) {
        }
        imageView.setClickable(true);
        imageView.setFocusable(false);
        if (this.aSx == null) {
        }
        imageView.setOnClickListener(onClickListener);
        imageView.setLayoutParams(layoutParams2);
        if (!(imageView instanceof TbImageView)) {
        }
        return true;
    }

    private void a(RelativeLayout relativeLayout, int i, int i2, int i3, int i4) {
        if (this.aSP && V(i, i2) && this.aSS > 0) {
            i3 = this.aSS;
            i4 = (int) (i3 * 1.618f);
        }
        int[] b2 = l.b(i, i2, i3, i4);
        if (b2 != null) {
            int[] iArr = {b2[0], b2[1]};
            int i5 = iArr[0];
            int i6 = iArr[1];
            if (!this.aSM || i3 <= i5 || aSa <= 1.0f) {
                i3 = i5;
            } else {
                if (i5 * aSa <= i3) {
                    if (i5 * aSa > i3 * 0.68f) {
                        i3 = (int) (i3 * 0.68f);
                    } else {
                        i3 = (int) (i5 * aSa);
                    }
                }
                if (iArr[0] > 0) {
                    i6 = (iArr[1] * i3) / iArr[0];
                }
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i3, i6);
            if (this.aSP) {
                if (V(i, i2)) {
                    layoutParams.width = -1;
                    layoutParams.leftMargin = 0;
                } else {
                    layoutParams.leftMargin = aRY;
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
        if (this.aSP && V(i, i2) && this.aSS > 0) {
            i3 = this.aSS;
            i4 = (int) (i3 * 1.618f);
        }
        int[] b2 = l.b(i, i2, i3, i4);
        if (b2 != null) {
            int[] iArr = {b2[0], b2[1]};
            int i7 = iArr[0];
            int i8 = iArr[1];
            if (this.aSM && i3 > i7 && aSa > 1.0f) {
                if (i7 * aSa > i3) {
                    i6 = (i3 - l.f(getContext(), d.f.ds78)) - l.f(getContext(), d.f.ds16);
                } else if (i7 * aSa > i3 * 0.68f) {
                    i6 = ((int) (i3 * 0.68f)) - l.f(getContext(), d.f.ds78);
                } else {
                    i6 = (int) (i7 * aSa);
                }
                if (iArr[0] > 0) {
                    i5 = (i6 * iArr[1]) / iArr[0];
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i3, i5);
                    if (this.aSP) {
                        if (V(i, i2)) {
                            layoutParams.width = -1;
                            layoutParams.leftMargin = 0;
                        } else {
                            layoutParams.leftMargin = aRY;
                        }
                    }
                    relativeLayout.setLayoutParams(layoutParams);
                }
            }
            i5 = i8;
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(i3, i5);
            if (this.aSP) {
            }
            relativeLayout.setLayoutParams(layoutParams2);
        }
    }

    private LinearLayout a(final TbRichTextData tbRichTextData) {
        if (this.aSs <= 0 || tbRichTextData == null) {
            return null;
        }
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setTag("VideoView");
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = this.aSl;
        linearLayout.setClickable(true);
        Bitmap cR = aj.cR(this.aSs);
        if (cR != null) {
            linearLayout.setBackgroundDrawable(new BitmapDrawable(getContext().getResources(), cR));
        }
        linearLayout.setFocusable(false);
        if (this.aSP) {
            layoutParams.leftMargin = aRY;
            layoutParams.rightMargin = aRY;
        }
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (tbRichTextData.IK() != null) {
                    if (TbRichTextView.this.getContext() instanceof com.baidu.tbadk.widget.richText.d) {
                        ((com.baidu.tbadk.widget.richText.d) TbRichTextView.this.getContext()).ab(TbRichTextView.this.getContext(), tbRichTextData.IK().toString());
                        return;
                    }
                    com.baidu.adp.base.e<?> Y = com.baidu.adp.base.i.Y(TbRichTextView.this.getContext());
                    if (Y != null && (Y.getOrignalPage() instanceof com.baidu.tbadk.widget.richText.d)) {
                        ((com.baidu.tbadk.widget.richText.d) Y.getOrignalPage()).ab(TbRichTextView.this.getContext(), tbRichTextData.IK().toString());
                    }
                }
            }
        });
        return linearLayout;
    }

    public int getVideoImageId() {
        return this.aSs;
    }

    public void setVideoImageId(int i) {
        this.aSs = i;
    }

    private ImageView bb(Context context) {
        ImageView fH = this.aSd != null ? this.aSd.fH() : null;
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
        TbRichTextLinkImageInfo IR = tbRichTextData.IR();
        if (IR != null && IR.getLink() != null) {
            if (imageView instanceof TbImageView) {
                TbImageView tbImageView = (TbImageView) imageView;
                if (this.aSK) {
                    tbImageView.setSupportNoImage(true);
                }
                tbImageView.c(IR.Jh(), this.mIsFromCDN ? 17 : 18, false);
                tbImageView.setTag(new c(IR.getLink()));
                if (!IR.IY()) {
                    tbImageView.setAdjustViewBounds(false);
                }
            }
            return a(imageView, IR.getWidth(), IR.getHeight(), i, i2, this.aSV);
        }
        return false;
    }

    private boolean b(TbRichTextData tbRichTextData, ImageView imageView, int i, int i2) {
        if (tbRichTextData == null || imageView == null) {
            return false;
        }
        if (tbRichTextData.getType() == 20) {
            if (tbRichTextData.IP() == null) {
                return false;
            }
        } else if (tbRichTextData.IJ() == null) {
            return false;
        }
        if (imageView instanceof TbImageView) {
            TbImageView tbImageView = (TbImageView) imageView;
            if (this.aSK) {
                tbImageView.setSupportNoImage(true);
            }
            if (tbRichTextData.getType() == 20) {
                tbImageView.c(tbRichTextData.IP().memeInfo.pic_url, this.mIsFromCDN ? 17 : 18, false);
                tbImageView.setAdjustViewBounds(false);
                tbImageView.setTag(d.h.tag_rich_text_meme_info, tbRichTextData.IP());
            } else {
                tbImageView.c(tbRichTextData.IJ().IX(), this.mIsFromCDN ? 17 : 18, false);
                if (!tbRichTextData.IJ().IY()) {
                    tbImageView.setAdjustViewBounds(false);
                }
                tbImageView.setTag(d.h.tag_rich_text_meme_info, null);
            }
        }
        if (tbRichTextData.getType() == 20) {
            return a(imageView, tbRichTextData.IP().memeInfo.width.intValue(), tbRichTextData.IP().memeInfo.height.intValue(), i, i2, this.mOnClickListener);
        }
        return a(imageView, tbRichTextData.IJ().getWidth(), tbRichTextData.IJ().getHeight(), i, i2, this.mOnClickListener);
    }

    public void setImageViewStretch(boolean z) {
        this.aSM = z;
    }

    private TextView bc(Context context) {
        TextView textView = null;
        if (this.aSe != null) {
            textView = this.aSe.fH();
        }
        if (textView == null || textView.getParent() != null) {
            textView = new TbListTextView(context);
        }
        textView.setPadding(this.aSk, 0, this.aSk, 0);
        return textView;
    }

    private boolean a(TbRichTextData tbRichTextData, TextView textView, boolean z, b bVar) {
        LinearLayout.LayoutParams layoutParams;
        if (z) {
            layoutParams = new LinearLayout.LayoutParams(-1, -2);
        } else {
            layoutParams = new LinearLayout.LayoutParams(-2, -2);
        }
        if (this.aSL) {
            layoutParams.gravity = 16;
            textView.setGravity(16);
        } else {
            layoutParams.topMargin = this.aSl;
        }
        textView.setLineSpacing(0.0f, this.aSj);
        textView.setTextSize(0, this.aSm);
        textView.setTextColor(this.mTextColor);
        textView.setLinkTextColor(aj.getColor(d.e.cp_link_tip_c));
        textView.setHighlightColor(getContext().getResources().getColor(d.e.transparent));
        textView.setSingleLine(this.aSt);
        if (this.aSu != null) {
            textView.setEllipsize(this.aSu);
        }
        if (this.Bp > 0) {
            textView.setMaxWidth(this.Bp);
        }
        if (this.aSN > 0) {
            textView.setMaxLines(this.aSN);
        }
        if (tbRichTextData == null) {
            return false;
        }
        SpannableStringBuilder IK = tbRichTextData.IK();
        if (IK == null || IK.length() <= 0) {
            return false;
        }
        int lineHeight = textView.getLineHeight();
        int textSize = lineHeight - ((int) textView.getTextSize());
        if (this.aSQ) {
            this.aSn = l.f(getContext(), d.f.ds40);
            this.aSo = l.f(getContext(), d.f.ds40);
        }
        if (this.aSo > 0 && this.aSn > 0) {
            tbRichTextData.T(this.aSn, this.aSo);
        }
        if (textSize > 0) {
            tbRichTextData.S(lineHeight, textSize);
        }
        if (bVar != null) {
            bVar.a(IK, textView, this);
        }
        try {
            textView.setText(IK);
        } catch (Exception e2) {
            textView.setText("");
        }
        if (this.aSO) {
            if (tbRichTextData.IT()) {
                textView.setMovementMethod(com.baidu.tieba.view.b.bxX());
            } else {
                textView.setMovementMethod(LinkMovementMethod.getInstance());
            }
        }
        textView.setFocusable(false);
        if (this.aSQ) {
            textView.setLineSpacing(l.f(getContext(), d.f.ds8), 1.0f);
        } else if (this.aSP) {
            layoutParams.leftMargin = aRY;
            layoutParams.rightMargin = aRY;
        }
        textView.setLayoutParams(layoutParams);
        textView.setTag(tbRichTextData);
        if (tbRichTextData != null && tbRichTextData.IM() != null) {
            tbRichTextData.IM().needRecompute = this.aSX;
        }
        return true;
    }

    private GifView getGifView() {
        GifView gifView = null;
        if (this.aSi != null) {
            gifView = this.aSi.fH();
        }
        GifView gifView2 = (gifView == null || gifView.getParent() != null) ? new GifView(getContext()) : gifView;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) gifView2.getLayoutParams();
        if (layoutParams != null) {
            if (this.aSP) {
                layoutParams.leftMargin = aRY;
                layoutParams.rightMargin = aRY;
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
        if (layoutParams == null || layoutParams.width != tbRichTextData.IO().mGifInfo.mGifWidth || layoutParams.height != tbRichTextData.IO().mGifInfo.mGifHeight) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(tbRichTextData.IO().mGifInfo.mGifWidth, tbRichTextData.IO().mGifInfo.mGifHeight);
            layoutParams2.gravity = 3;
            if (this.aSP) {
                layoutParams2.leftMargin = aRY;
                layoutParams2.rightMargin = aRY;
            }
            gifView.setLayoutParams(layoutParams2);
        } else {
            layoutParams.bottomMargin = 0;
        }
        gifView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (TbRichTextView.this.aSG != null) {
                    TbRichTextEmotionInfo IO = tbRichTextData.IO();
                    TbRichTextView.this.aSG.a(view, IO.mGifInfo.mGid, IO.mGifInfo.mPackageName, IO.mGifInfo.mIcon, IO.mGifInfo.mStaticUrl, IO.mGifInfo.mDynamicUrl, IO.mGifInfo.mSharpText, IO.mGifInfo.mGifWidth, IO.mGifInfo.mGifHeight);
                }
            }
        });
        gifView.a(tbRichTextData.IO().mGifInfo);
        return true;
    }

    private View getVoiceView() {
        View fH = this.aSf != null ? this.aSf.fH() : null;
        if ((fH == null || fH.getParent() != null) && this.aSB != -1) {
            fH = LayoutInflater.from(getContext()).inflate(this.aSB, (ViewGroup) null);
        }
        if (fH != null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.topMargin = this.aSl;
            if (!this.aSQ) {
                layoutParams.bottomMargin = this.aSl;
            }
            fH.setLayoutParams(layoutParams);
            return fH;
        }
        return null;
    }

    private boolean a(TbRichTextData tbRichTextData, View view) {
        view.setTag(tbRichTextData.IL());
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LinearLayout.LayoutParams(-2, -2);
        }
        if (this.aSP) {
            layoutParams.leftMargin = aRY;
            layoutParams.rightMargin = aRY;
        }
        view.setLayoutParams(layoutParams);
        return true;
    }

    private View getTextVoiceView() {
        LinearLayout fH = this.aSg.fH();
        if (fH != null) {
            TextView bc = bc(getContext());
            if (bc == null) {
                this.aSg.m(fH);
                return null;
            }
            fH.addView(bc);
            View voiceView = getVoiceView();
            if (voiceView == null) {
                this.aSe.m(bc);
                this.aSg.m(fH);
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
        if (f2 != this.aSm) {
            this.aSm = f2;
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
        if (this.aSk != i) {
            this.aSk = i;
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (childAt != null && (childAt instanceof TextView)) {
                    ((TextView) childAt).setPadding(this.aSk, 0, 0, this.aSk);
                }
            }
        }
    }

    public void setLinkTextColor(int i) {
        if (i != this.aSp) {
            this.aSp = i;
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
        if (this.aSS <= 0) {
            return false;
        }
        return ((((float) i) / ((float) this.aSS)) > aSb ? 1 : ((((float) i) / ((float) this.aSS)) == aSb ? 0 : -1)) > 0;
    }

    public int getMaxImageWidth() {
        return this.aSq;
    }

    public void setMaxImageWidth(int i) {
        this.aSq = i;
    }

    public int getMaxImageHeight() {
        return this.aSr;
    }

    public void setMaxImageHeight(int i) {
        this.aSr = i;
    }

    public ImageView.ScaleType getScaleType() {
        return this.GN;
    }

    public void setScaleType(ImageView.ScaleType scaleType) {
        this.GN = scaleType;
    }

    public int getDefaultImageId() {
        return this.Vz;
    }

    public void setDefaultImageId(int i) {
        this.Vz = i;
    }

    public f getOnImageClickListener() {
        return this.aSw;
    }

    public void setOnImageClickListener(f fVar) {
        this.aSw = fVar;
    }

    public void setOnImageTouchListener(com.baidu.tieba.pb.a.c cVar) {
        this.aSx = cVar;
    }

    public void setOnEmotionClickListener(e eVar) {
        this.aSG = eVar;
    }

    public void m(boolean z, boolean z2) {
        if (this.aSA != z) {
            this.aSA = z;
            if (z2) {
                requestLayout();
            }
            if (!this.aSA && this.aSd != null) {
                this.aSd.clear();
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
        this.aSC = false;
        switch (motionEvent.getAction()) {
            case 1:
            case 3:
                if (!this.aSD) {
                    Jv();
                    break;
                }
                break;
        }
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        switch (motionEvent.getAction()) {
            case 0:
                if (!this.aSC) {
                    Ju();
                    break;
                }
                break;
        }
        return dispatchTouchEvent;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.aSC = true;
        return super.onTouchEvent(motionEvent);
    }

    private void Ju() {
        this.aSD = false;
        if (this.aSE == null) {
            this.aSE = new a();
        }
        postDelayed(this.aSE, ViewConfiguration.getLongPressTimeout());
    }

    private void Jv() {
        if (this.aSE != null) {
            removeCallbacks(this.aSE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!TbRichTextView.this.aSU && TbRichTextView.this.performLongClick()) {
                TbRichTextView.this.aSD = true;
            }
        }
    }

    public void setVoiceViewRes(int i) {
        this.aSB = i;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        this.aSJ = null;
        if (this.aSY != drawable) {
            this.aSX = true;
            this.aSY = drawable;
        }
        setText(this.aSI);
        this.aSX = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        DU();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        DU();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 8 || i == 4) {
            DU();
        } else {
            refresh();
        }
    }

    public void gX(String str) {
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
            DU();
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
            com.baidu.adp.lib.f.c.fJ().a(this.mUrl, 19, this.aLs, 0, 0, this.mPageId, new Object[0]);
        }
    }

    public void DU() {
        if (!TextUtils.isEmpty(this.mUrl)) {
            com.baidu.adp.lib.f.c.fJ().a(this.mUrl, 19, this.aLs);
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
        gX(this.mUrl);
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
        return this.aSy;
    }

    public void setOnLinkImageClickListener(g gVar) {
        this.aSy = gVar;
    }

    public void setHasMovementMethod(boolean z) {
        this.aSO = z;
    }

    public void setTextCenter(boolean z) {
        this.aSL = z;
    }

    public void setIsNeedShowImages(boolean z) {
        this.aSH = z;
    }
}
