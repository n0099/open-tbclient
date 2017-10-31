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
import com.baidu.tbadk.p.p;
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
    private static final float aQZ = l.af(TbadkCoreApplication.getInst());
    private int aSA;
    private boolean aSB;
    private boolean aSC;
    private Runnable aSD;
    private boolean aSE;
    private e aSF;
    private TbRichText aSG;
    private boolean aSH;
    private int aSI;
    private boolean aSJ;
    private boolean aSK;
    private boolean aSL;
    public final View.OnClickListener aSM;
    private final d aSN;
    private boolean aSO;
    private Drawable aSP;
    private CustomMessageListener aSQ;
    private com.baidu.tbadk.widget.richText.a aSl;
    private com.baidu.adp.lib.e.b<ImageView> aSm;
    private com.baidu.adp.lib.e.b<TextView> aSn;
    private com.baidu.adp.lib.e.b<View> aSo;
    private com.baidu.adp.lib.e.b<LinearLayout> aSp;
    private com.baidu.adp.lib.e.b<RelativeLayout> aSq;
    private com.baidu.adp.lib.e.b<GifView> aSr;
    private boolean aSs;
    private TextUtils.TruncateAt aSt;
    private h aSu;
    private f aSv;
    private com.baidu.tieba.pb.a.c aSw;
    private g aSx;
    private View.OnClickListener aSy;
    private boolean aSz;
    private final com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> mCallback;
    private final com.baidu.tieba.pb.a.c mInternalGestureDetector;
    private boolean mIsFromCDN;
    private int mMaxWidth;
    private final View.OnClickListener mOnClickListener;
    private BdUniqueId mPageId;
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

    public void setSubPbPost(boolean z) {
        this.aSK = z;
    }

    public boolean Jx() {
        return this.aSE;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public void setMaxWidth(int i) {
        this.mMaxWidth = i;
    }

    public void setMaxLines(int i) {
        this.aSI = i;
    }

    public void setTextEllipsize(TextUtils.TruncateAt truncateAt) {
        this.aSt = truncateAt;
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
        super.setOnLongClickListener(onLongClickListener);
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
    public boolean S(View view) {
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
            /* renamed from: JA */
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
        this.aSl = new com.baidu.tbadk.widget.richText.a();
        this.aSm = null;
        this.aSn = null;
        this.aSo = null;
        this.aSp = null;
        this.aSq = null;
        this.aSr = null;
        this.aSs = true;
        this.aSt = null;
        this.aSu = null;
        this.aSv = null;
        this.aSw = null;
        this.aSx = null;
        this.aSy = null;
        this.aSz = true;
        this.mIsFromCDN = true;
        this.aSA = -1;
        this.aSB = false;
        this.aSC = false;
        this.aSD = null;
        this.aSE = false;
        this.aSH = false;
        this.mMaxWidth = -1;
        this.aSI = -1;
        this.aSJ = true;
        this.aSK = false;
        this.aSL = false;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                String str;
                int i = 0;
                if (TbRichTextView.this.aSv != null && (view instanceof ImageView)) {
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
                        TbRichTextView.this.aSv.a(view, null, i2);
                        return;
                    }
                    if (tag != null && (tag instanceof String)) {
                        url = (String) tag;
                    } else if ((view instanceof TbImageView) && (view.getTag(d.g.tag_rich_text_meme_info) instanceof TbRichTextMemeInfo)) {
                        TbRichTextMemeInfo tbRichTextMemeInfo = (TbRichTextMemeInfo) view.getTag(d.g.tag_rich_text_meme_info);
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
                        TbRichTextView.this.aSv.a(view, str, i3);
                        return;
                    } else {
                        url = view instanceof TbImageView ? ((TbImageView) view).getUrl() : null;
                    }
                    int childCount3 = TbRichTextView.this.getChildCount();
                    int i4 = -1;
                    while (i < childCount3) {
                        View childAt = TbRichTextView.this.getChildAt(i);
                        if (TbRichTextView.this.S(childAt)) {
                            i4++;
                        }
                        if (view == childAt) {
                            break;
                        }
                        i++;
                    }
                    TbRichTextView.this.aSv.a(view, url, i4);
                }
            }
        };
        this.mInternalGestureDetector = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.4
            @Override // com.baidu.tieba.pb.a.c.a
            public boolean a(View view, MotionEvent motionEvent) {
                if (TbRichTextView.this.aSw != null) {
                    TbRichTextView.this.aSw.bf(view);
                    return TbRichTextView.this.aSw.onDoubleTap(motionEvent);
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
        this.aSM = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                if (TbRichTextView.this.aSx != null && (view instanceof TbImageView)) {
                    Object tag = view.getTag();
                    if (tag == null || !(tag instanceof c)) {
                        str = null;
                    } else {
                        str = ((c) tag).url;
                    }
                    TbRichTextView.this.aSx.b(view, str);
                }
            }
        };
        this.aSN = new d() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.11
            @Override // com.baidu.tbadk.widget.richText.TbRichTextView.d
            public void n(MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    TbRichTextView.this.aSL = true;
                } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                    TbRichTextView.this.aSL = false;
                }
            }
        };
        this.mType = 19;
        this.mCallback = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
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
        this.aSQ = new CustomMessageListener(CmdConfigCustom.PB_RICHTEXT_CHANGE_CMD) { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (TbRichTextView.this.aSK) {
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
        this.aSl = new com.baidu.tbadk.widget.richText.a();
        this.aSm = null;
        this.aSn = null;
        this.aSo = null;
        this.aSp = null;
        this.aSq = null;
        this.aSr = null;
        this.aSs = true;
        this.aSt = null;
        this.aSu = null;
        this.aSv = null;
        this.aSw = null;
        this.aSx = null;
        this.aSy = null;
        this.aSz = true;
        this.mIsFromCDN = true;
        this.aSA = -1;
        this.aSB = false;
        this.aSC = false;
        this.aSD = null;
        this.aSE = false;
        this.aSH = false;
        this.mMaxWidth = -1;
        this.aSI = -1;
        this.aSJ = true;
        this.aSK = false;
        this.aSL = false;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                String str;
                int i = 0;
                if (TbRichTextView.this.aSv != null && (view instanceof ImageView)) {
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
                        TbRichTextView.this.aSv.a(view, null, i2);
                        return;
                    }
                    if (tag != null && (tag instanceof String)) {
                        url = (String) tag;
                    } else if ((view instanceof TbImageView) && (view.getTag(d.g.tag_rich_text_meme_info) instanceof TbRichTextMemeInfo)) {
                        TbRichTextMemeInfo tbRichTextMemeInfo = (TbRichTextMemeInfo) view.getTag(d.g.tag_rich_text_meme_info);
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
                        TbRichTextView.this.aSv.a(view, str, i3);
                        return;
                    } else {
                        url = view instanceof TbImageView ? ((TbImageView) view).getUrl() : null;
                    }
                    int childCount3 = TbRichTextView.this.getChildCount();
                    int i4 = -1;
                    while (i < childCount3) {
                        View childAt = TbRichTextView.this.getChildAt(i);
                        if (TbRichTextView.this.S(childAt)) {
                            i4++;
                        }
                        if (view == childAt) {
                            break;
                        }
                        i++;
                    }
                    TbRichTextView.this.aSv.a(view, url, i4);
                }
            }
        };
        this.mInternalGestureDetector = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.4
            @Override // com.baidu.tieba.pb.a.c.a
            public boolean a(View view, MotionEvent motionEvent) {
                if (TbRichTextView.this.aSw != null) {
                    TbRichTextView.this.aSw.bf(view);
                    return TbRichTextView.this.aSw.onDoubleTap(motionEvent);
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
        this.aSM = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                if (TbRichTextView.this.aSx != null && (view instanceof TbImageView)) {
                    Object tag = view.getTag();
                    if (tag == null || !(tag instanceof c)) {
                        str = null;
                    } else {
                        str = ((c) tag).url;
                    }
                    TbRichTextView.this.aSx.b(view, str);
                }
            }
        };
        this.aSN = new d() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.11
            @Override // com.baidu.tbadk.widget.richText.TbRichTextView.d
            public void n(MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    TbRichTextView.this.aSL = true;
                } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                    TbRichTextView.this.aSL = false;
                }
            }
        };
        this.mType = 19;
        this.mCallback = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
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
        this.aSQ = new CustomMessageListener(CmdConfigCustom.PB_RICHTEXT_CHANGE_CMD) { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (TbRichTextView.this.aSK) {
                    TbRichTextView.this.setTextSize(TbConfig.getContentSizeOfLzl());
                } else {
                    TbRichTextView.this.setTextSize(TbConfig.getContentSize());
                }
            }
        };
        init();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.l.TbRichTextView);
        this.aSl.a(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
    }

    public com.baidu.tbadk.widget.richText.a getLayoutStrategy() {
        return this.aSl;
    }

    public void setLayoutStrategy(com.baidu.tbadk.widget.richText.a aVar) {
        if (aVar != null) {
            this.aSl.release();
            this.aSl = aVar;
        }
    }

    private void init() {
        com.baidu.tbadk.widget.richText.e eVar = null;
        com.baidu.adp.base.e<?> Y = com.baidu.adp.base.i.Y(getContext());
        if (getContext() instanceof com.baidu.tbadk.widget.richText.e) {
            eVar = (com.baidu.tbadk.widget.richText.e) getContext();
        } else if (Y != null && (Y.getOrignalPage() instanceof com.baidu.tbadk.widget.richText.e)) {
            eVar = (com.baidu.tbadk.widget.richText.e) Y.getOrignalPage();
        }
        if (Y != null) {
            Y.registerListener(this.aSQ);
        }
        if (eVar != null) {
            this.aSm = eVar.Jo();
            this.aSn = eVar.Jp();
            this.aSo = eVar.Jr();
            this.aSp = eVar.Js();
            this.aSr = eVar.Jq();
            this.aSq = eVar.Jt();
            if (eVar.getListView() != null && this.aSu == null) {
                this.aSu = new h(eVar.Jn());
                eVar.getListView().setRecyclerListener(this.aSu);
            }
        }
        setOrientation(1);
        setOnHierarchyChangeListener(new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.7
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof GifView) && TbRichTextView.this.aSr != null) {
                    TbRichTextView.this.aSr.m((GifView) view2);
                } else if ((view2 instanceof ImageView) && TbRichTextView.this.aSm != null) {
                    TbRichTextView.this.aSm.m((ImageView) view2);
                } else if ((view2 instanceof TextView) && TbRichTextView.this.aSn != null) {
                    TbRichTextView.this.aSn.m((TextView) view2);
                } else if ((view2 instanceof PlayVoiceBnt) && TbRichTextView.this.aSo != null) {
                    TbRichTextView.this.aSo.m(view2);
                } else if ((view2 instanceof PlayVoiceBntNew) && TbRichTextView.this.aSo != null) {
                    TbRichTextView.this.aSo.m(view2);
                } else if ((view2 instanceof RelativeLayout) && TbRichTextView.this.aSq != null) {
                    TbRichTextView.this.aSq.m((RelativeLayout) view2);
                }
                if (view2 instanceof LinearLayout) {
                    Object tag = view2.getTag();
                    if (tag == null || !(tag instanceof String) || !"VideoView".equals(tag)) {
                        if (TbRichTextView.this.aSp != null) {
                            int childCount = ((LinearLayout) view2).getChildCount();
                            for (int i = 0; i < childCount; i++) {
                                View childAt = ((LinearLayout) view2).getChildAt(i);
                                if (childAt != null) {
                                    if ((childAt instanceof TextView) && TbRichTextView.this.aSn != null) {
                                        TbRichTextView.this.aSn.m((TextView) childAt);
                                    } else if ((childAt instanceof PlayVoiceBnt) && TbRichTextView.this.aSo != null) {
                                        TbRichTextView.this.aSo.m(childAt);
                                    } else if ((childAt instanceof PlayVoiceBntNew) && TbRichTextView.this.aSo != null) {
                                        TbRichTextView.this.aSo.m(childAt);
                                    }
                                }
                            }
                            ((LinearLayout) view2).removeAllViews();
                            TbRichTextView.this.aSp.m((LinearLayout) view2);
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
        a(tbRichText, false);
    }

    public void a(TbRichText tbRichText, boolean z) {
        a(tbRichText, z, (b) null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r20v0, types: [com.baidu.tbadk.widget.richText.TbRichTextView] */
    /* JADX WARN: Type inference failed for: r3v22, types: [android.widget.ImageView] */
    /* JADX WARN: Type inference failed for: r7v3 */
    public void a(TbRichText tbRichText, boolean z, b bVar) {
        ArrayList<TbRichTextData> II;
        int i;
        SpannableStringBuilder IP;
        RelativeLayout relativeLayout;
        View view;
        boolean z2;
        KeyEvent.Callback a2;
        boolean z3;
        int i2;
        int i3;
        if (this.aSG != tbRichText || (tbRichText != null && tbRichText.isChanged)) {
            if (tbRichText != null) {
                tbRichText.isChanged = false;
            }
            this.aSG = tbRichText;
            removeAllViews();
            if (tbRichText != null && (II = tbRichText.II()) != null) {
                boolean z4 = true;
                Iterator<TbRichTextData> it = II.iterator();
                int i4 = 0;
                View view2 = null;
                int i5 = 0;
                View view3 = null;
                while (it.hasNext()) {
                    TbRichTextData next = it.next();
                    boolean z5 = false;
                    if (next != null) {
                        if (next.getType() == 1) {
                            TextView bb = bb(getContext());
                            boolean a3 = a(next, bb, true, bVar);
                            if (z && !this.aSE && (IP = next.IP()) != null) {
                                this.aSE = IP.length() >= 200;
                            }
                            if (this.aSw != null) {
                                bb.setOnTouchListener(this.mInternalGestureDetector);
                            } else {
                                bb.setOnClickListener(this.aSy);
                            }
                            z5 = a3;
                            i = i4;
                            relativeLayout = bb;
                        } else if (next.getType() == 8) {
                            if (i4 < 10) {
                                ?? ba = ba(getContext());
                                z5 = c(next, ba, this.aSl.aRh, this.aSl.aRi);
                                i = i4 + 1;
                                relativeLayout = ba;
                            }
                        } else if (next.getType() == 32) {
                            com.baidu.tbadk.widget.richText.f IS = next.IS();
                            if (IS != null && IS.Jv()) {
                                a2 = b(IS);
                            } else {
                                a2 = a(next);
                            }
                            i = i4;
                            relativeLayout = a2;
                            z5 = true;
                        } else if (next.getType() == 512) {
                            View voiceView = getVoiceView();
                            if (voiceView == null) {
                                view3 = voiceView;
                            } else {
                                i = i4;
                                relativeLayout = voiceView;
                                z5 = a(next, voiceView);
                            }
                        } else if (next.getType() == 768) {
                            View textVoiceView = getTextVoiceView();
                            z5 = a(next, (LinearLayout) textVoiceView, bVar);
                            i = i4;
                            relativeLayout = textVoiceView;
                        } else if (next.getType() == 17) {
                            GifView gifView = getGifView();
                            z5 = a(next, gifView);
                            i = i4;
                            relativeLayout = gifView;
                        } else if (next.getType() == 20) {
                            if (i5 < 10) {
                                int i6 = i5 + 1;
                                if (next == null || next.IU() == null || next.IU().memeInfo == null || StringUtils.isNull(next.IU().memeInfo.pic_url)) {
                                    z3 = false;
                                } else {
                                    z3 = true;
                                }
                                if (z3) {
                                    RelativeLayout fH = this.aSq.fH();
                                    fH.removeAllViews();
                                    fH.setLayoutParams(new LinearLayout.LayoutParams(next.IU().memeInfo.width.intValue(), next.IU().memeInfo.height.intValue()));
                                    if (p.GB() && this.aSs) {
                                        b(fH, next.IU().memeInfo.width.intValue(), next.IU().memeInfo.height.intValue(), this.aSl.aRh, this.aSl.aRi);
                                    } else {
                                        a(fH, next.IU().memeInfo.width.intValue(), next.IU().memeInfo.height.intValue(), this.aSl.aRh, this.aSl.aRi);
                                    }
                                    ImageView fH2 = this.aSm.fH();
                                    b(next, fH2, this.aSl.aRh, this.aSl.aRi);
                                    if (p.GB() && this.aSs) {
                                        ImageView fH3 = this.aSm.fH();
                                        fH3.setTag(this.aSG);
                                        int f2 = l.f(getContext(), d.e.ds78);
                                        int f3 = l.f(getContext(), d.e.ds78);
                                        aj.c(fH3, d.f.icon_emotion_dui_n);
                                        fH2.setId(d.g.meme_image_view);
                                        c(fH2, next.IU().memeInfo.width.intValue(), next.IU().memeInfo.height.intValue(), this.aSl.aRh, this.aSl.aRi, this.mOnClickListener);
                                        fH.addView(fH2);
                                        if (f3 > next.IU().memeInfo.height.intValue()) {
                                            i3 = f2 / 2;
                                            i2 = f3 / 2;
                                        } else {
                                            i2 = f3;
                                            i3 = f2;
                                        }
                                        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i3, i2);
                                        layoutParams.addRule(8, d.g.meme_image_view);
                                        layoutParams.addRule(11);
                                        fH3.setOnClickListener(this.mOnClickListener);
                                        if (fH.getLeft() > 0) {
                                            layoutParams.rightMargin = l.f(getContext(), d.e.ds6);
                                        }
                                        fH.addView(fH3, layoutParams);
                                    } else {
                                        b(fH2, next.IU().memeInfo.width.intValue(), next.IU().memeInfo.height.intValue(), this.aSl.aRh, this.aSl.aRi, this.mOnClickListener);
                                        fH.addView(fH2);
                                    }
                                    z5 = z3;
                                    i5 = i6;
                                    i = i4;
                                    relativeLayout = fH;
                                } else {
                                    z5 = z3;
                                    i5 = i6;
                                    i = i4;
                                    relativeLayout = view3;
                                }
                            }
                        } else if (next.getType() == 1280) {
                            ImageView ba2 = ba(getContext());
                            z5 = a(next, ba2, (this.aSl.aRh - getPaddingLeft()) - getPaddingRight(), this.aSl.aRi);
                            i = i4 + 1;
                            relativeLayout = ba2;
                        } else {
                            i = i4;
                            relativeLayout = view3;
                        }
                        if (!z5 || relativeLayout == 0) {
                            view = view2;
                        } else {
                            addView(relativeLayout);
                            view = relativeLayout;
                        }
                        if (z4 && this.aSl.aRu >= 0) {
                            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) relativeLayout.getLayoutParams();
                            if (layoutParams2 != null) {
                                layoutParams2.topMargin = this.aSl.aRu;
                                relativeLayout.setLayoutParams(layoutParams2);
                            }
                            z2 = false;
                        } else {
                            if (((relativeLayout instanceof ImageView) || (relativeLayout instanceof RelativeLayout)) && (next.getType() == 8 || next.getType() == 20 || next.getType() == 17)) {
                                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) relativeLayout.getLayoutParams();
                                view.setLayoutParams(layoutParams3);
                                if ((i == 1 && i5 == 0) || (i == 0 && i5 == 1)) {
                                    layoutParams3.topMargin = this.aSl.aRq;
                                } else if (i > 1 || i5 > 1) {
                                    layoutParams3.topMargin = this.aSl.aRp;
                                }
                                relativeLayout.setLayoutParams(layoutParams3);
                            }
                            z2 = z4;
                        }
                        z4 = z2;
                        i4 = i;
                        view2 = view;
                        view3 = relativeLayout;
                    }
                }
                if (view2 != null && !(view2 instanceof TbListTextView)) {
                    LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) view2.getLayoutParams();
                    layoutParams4.bottomMargin = this.aSl.aRt;
                    view2.setLayoutParams(layoutParams4);
                } else if (view2 != null && this.aSl.aRs >= 0) {
                    LinearLayout.LayoutParams layoutParams5 = (LinearLayout.LayoutParams) view2.getLayoutParams();
                    layoutParams5.bottomMargin = this.aSl.aRs;
                    view2.setLayoutParams(layoutParams5);
                }
            }
        }
    }

    public void setCommonTextViewOnClickListener(View.OnClickListener onClickListener) {
        this.aSy = onClickListener;
    }

    private View b(final com.baidu.tbadk.widget.richText.f fVar) {
        if (fVar == null || !fVar.isAvaliable()) {
            return null;
        }
        ImageView fH = this.aSm.fH();
        if (fH instanceof ForeDrawableImageView) {
            ForeDrawableImageView foreDrawableImageView = (ForeDrawableImageView) fH;
            foreDrawableImageView.setForegroundDrawable(d.f.icon_play_video);
            foreDrawableImageView.setNoImageBottomTextColor(d.C0080d.cp_cont_c);
            foreDrawableImageView.setNoImageBottomTextPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds32));
            foreDrawableImageView.setNoImageBottomTextSize(TbadkCoreApplication.getInst().getResources().getDimension(d.e.fontsize28));
            foreDrawableImageView.setNoImageBottomText("点击播放视频");
            foreDrawableImageView.setInterceptOnClick(false);
            foreDrawableImageView.setTag("VideoView");
            b(foreDrawableImageView, fVar.getWidth(), fVar.getHeight(), (this.aSl.aRh - getPaddingLeft()) - getPaddingRight(), this.aSl.aRi, new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log("c10643");
                    XiaoyingUtil.startPlayXiaoyingVideo(TbRichTextView.this.getContext(), fVar.getVideoUrl(), fVar.getWidth(), fVar.getHeight(), fVar.getThumbUrl());
                }
            });
            foreDrawableImageView.setDefaultResource(0);
            foreDrawableImageView.setSupportNoImage(this.aSl.aRn);
            if (com.baidu.tbadk.core.h.oT().oZ()) {
                foreDrawableImageView.setDefaultBgResource(d.f.pic_bg_video_frs);
            } else {
                foreDrawableImageView.setDefaultBgResource(d.C0080d.cp_bg_line_c);
            }
            foreDrawableImageView.startLoad(fVar.getThumbUrl(), 17, false);
            return fH;
        }
        return fH;
    }

    private boolean a(ImageView imageView, int i, int i2, int i3, int i4, View.OnClickListener onClickListener) {
        int[] l = this.aSl.l(i, i2, i3, i4);
        if (l == null) {
            return false;
        }
        int i5 = l[0];
        int i6 = l[1];
        if (imageView instanceof TbImageView) {
            TbImageView tbImageView = (TbImageView) imageView;
            tbImageView.setDefaultResource(this.aSl.VF);
            if (tbImageView.getGifIconWidth() >= i5 || tbImageView.getGifIconHeight() >= i6) {
                tbImageView.setGifIconSupport(false);
            } else {
                tbImageView.setGifIconSupport(true);
            }
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i5, i6);
        if (this.aSl.aRo) {
            imageView.setScaleType(this.aSl.aRm);
            if (imageView instanceof TbImageView) {
                ((TbImageView) imageView).setOnDrawListener(this.aSl.mOnDrawListener);
            }
        } else {
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        }
        imageView.setClickable(true);
        imageView.setFocusable(false);
        if (this.aSw != null && (imageView instanceof TbImageView)) {
            ((TbImageView) imageView).setTbGestureDetector(this.mInternalGestureDetector);
            imageView.setClickable(true);
        } else {
            imageView.setOnClickListener(onClickListener);
        }
        imageView.setLayoutParams(layoutParams);
        if (imageView instanceof TbImageView) {
            if (this.onLongClickListener != null) {
                ((TbImageView) imageView).setDispatchTouchListener(this.aSN);
                imageView.setOnLongClickListener(this.onLongClickListener);
            }
        } else if ((imageView instanceof GifView) && this.onLongClickListener != null) {
            imageView.setOnLongClickListener(this.onLongClickListener);
        }
        return true;
    }

    private boolean b(ImageView imageView, int i, int i2, int i3, int i4, View.OnClickListener onClickListener) {
        int i5;
        int[] b2 = l.b(i, i2, i3, i4);
        if (b2 == null) {
            return false;
        }
        int[] iArr = {b2[0], b2[1]};
        int i6 = iArr[0];
        int i7 = iArr[1];
        if (!this.aSl.aRo || i3 <= i6 || aQZ <= 1.0f) {
            i3 = i6;
            i5 = i7;
        } else {
            if (i6 * aQZ <= i3) {
                if (i6 * aQZ > i3 * 0.68f) {
                    i3 = (int) (i3 * 0.68f);
                } else {
                    i3 = (int) (i6 * aQZ);
                }
            }
            i5 = iArr[0] > 0 ? (iArr[1] * i3) / iArr[0] : i7;
        }
        if (imageView instanceof TbImageView) {
            TbImageView tbImageView = (TbImageView) imageView;
            tbImageView.setDefaultResource(this.aSl.VF);
            if (tbImageView.getGifIconWidth() >= i3 || tbImageView.getGifIconHeight() >= i5) {
                tbImageView.setGifIconSupport(false);
            } else {
                tbImageView.setGifIconSupport(true);
            }
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i3, i5);
        if (this.aSl.aRo) {
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        } else {
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        }
        imageView.setClickable(true);
        imageView.setFocusable(false);
        if (this.aSw != null && (imageView instanceof TbImageView)) {
            ((TbImageView) imageView).setTbGestureDetector(this.mInternalGestureDetector);
            imageView.setClickable(true);
        } else {
            imageView.setOnClickListener(onClickListener);
        }
        imageView.setLayoutParams(layoutParams);
        if (imageView instanceof TbImageView) {
            if (this.onLongClickListener != null) {
                ((TbImageView) imageView).setDispatchTouchListener(this.aSN);
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
    private boolean c(ImageView imageView, int i, int i2, int i3, int i4, View.OnClickListener onClickListener) {
        int i5;
        int i6;
        int[] b2 = l.b(i, i2, i3, i4);
        if (b2 == null) {
            return false;
        }
        int[] iArr = {b2[0], b2[1]};
        int i7 = iArr[0];
        int i8 = iArr[1];
        if (this.aSl.aRo && i3 > i7 && aQZ > 1.0f) {
            if (i7 * aQZ > i3) {
                i7 = (i3 - l.f(getContext(), d.e.ds78)) - l.f(getContext(), d.e.ds16);
            } else if (i7 * aQZ > i3 * 0.68f) {
                i7 = ((int) (i3 * 0.68f)) - l.f(getContext(), d.e.ds78);
            } else {
                i7 = (int) (i7 * aQZ);
            }
            if (iArr[0] > 0) {
                i5 = (iArr[1] * i7) / iArr[0];
                i6 = i7;
                if (imageView instanceof TbImageView) {
                    TbImageView tbImageView = (TbImageView) imageView;
                    tbImageView.setDefaultResource(this.aSl.VF);
                    if (tbImageView.getGifIconWidth() >= i6 || tbImageView.getGifIconHeight() >= i5) {
                        tbImageView.setGifIconSupport(false);
                    } else {
                        tbImageView.setGifIconSupport(true);
                    }
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i6, i5);
                if (!this.aSl.aRo) {
                    imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                } else {
                    imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                }
                imageView.setClickable(true);
                imageView.setFocusable(false);
                if (this.aSw == null && (imageView instanceof TbImageView)) {
                    ((TbImageView) imageView).setTbGestureDetector(this.mInternalGestureDetector);
                    imageView.setClickable(true);
                } else {
                    imageView.setOnClickListener(onClickListener);
                }
                imageView.setLayoutParams(layoutParams);
                if (!(imageView instanceof TbImageView)) {
                    if (this.onLongClickListener != null) {
                        ((TbImageView) imageView).setDispatchTouchListener(this.aSN);
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
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(i6, i5);
        if (!this.aSl.aRo) {
        }
        imageView.setClickable(true);
        imageView.setFocusable(false);
        if (this.aSw == null) {
        }
        imageView.setOnClickListener(onClickListener);
        imageView.setLayoutParams(layoutParams2);
        if (!(imageView instanceof TbImageView)) {
        }
        return true;
    }

    private void a(RelativeLayout relativeLayout, int i, int i2, int i3, int i4) {
        int[] b2 = l.b(i, i2, i3, i4);
        if (b2 != null) {
            int[] iArr = {b2[0], b2[1]};
            int i5 = iArr[0];
            int i6 = iArr[1];
            if (!this.aSl.aRo || i3 <= i5 || aQZ <= 1.0f) {
                i3 = i5;
            } else {
                if (i5 * aQZ <= i3) {
                    if (i5 * aQZ > i3 * 0.68f) {
                        i3 = (int) (i3 * 0.68f);
                    } else {
                        i3 = (int) (i5 * aQZ);
                    }
                }
                if (iArr[0] > 0) {
                    i6 = (iArr[1] * i3) / iArr[0];
                }
            }
            relativeLayout.setLayoutParams(new LinearLayout.LayoutParams(i3, i6));
        }
    }

    private void b(RelativeLayout relativeLayout, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int[] b2 = l.b(i, i2, i3, i4);
        if (b2 != null) {
            int[] iArr = {b2[0], b2[1]};
            int i7 = iArr[0];
            int i8 = iArr[1];
            if (this.aSl.aRo && i3 > i7 && aQZ > 1.0f) {
                if (i7 * aQZ > i3) {
                    i6 = (i3 - l.f(getContext(), d.e.ds78)) - l.f(getContext(), d.e.ds16);
                } else if (i7 * aQZ > i3 * 0.68f) {
                    i6 = ((int) (i3 * 0.68f)) - l.f(getContext(), d.e.ds78);
                } else {
                    i6 = (int) (i7 * aQZ);
                }
                if (iArr[0] > 0) {
                    i5 = (i6 * iArr[1]) / iArr[0];
                    relativeLayout.setLayoutParams(new LinearLayout.LayoutParams(i3, i5));
                }
            }
            i5 = i8;
            relativeLayout.setLayoutParams(new LinearLayout.LayoutParams(i3, i5));
        }
    }

    private LinearLayout a(final TbRichTextData tbRichTextData) {
        if (this.aSl.aRj <= 0 || tbRichTextData == null) {
            return null;
        }
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setTag("VideoView");
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = this.aSl.aRd;
        linearLayout.setClickable(true);
        Bitmap cR = aj.cR(this.aSl.aRj);
        if (cR != null) {
            linearLayout.setBackgroundDrawable(new BitmapDrawable(getContext().getResources(), cR));
        }
        linearLayout.setFocusable(false);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (tbRichTextData.IP() != null) {
                    if (TbRichTextView.this.getContext() instanceof com.baidu.tbadk.widget.richText.e) {
                        ((com.baidu.tbadk.widget.richText.e) TbRichTextView.this.getContext()).W(TbRichTextView.this.getContext(), tbRichTextData.IP().toString());
                        return;
                    }
                    com.baidu.adp.base.e<?> Y = com.baidu.adp.base.i.Y(TbRichTextView.this.getContext());
                    if (Y != null && (Y.getOrignalPage() instanceof com.baidu.tbadk.widget.richText.e)) {
                        ((com.baidu.tbadk.widget.richText.e) Y.getOrignalPage()).W(TbRichTextView.this.getContext(), tbRichTextData.IP().toString());
                    }
                }
            }
        });
        return linearLayout;
    }

    private ImageView ba(Context context) {
        ImageView fH = this.aSm != null ? this.aSm.fH() : null;
        if (fH == null || fH.getParent() != null) {
            fH = null;
        }
        if (fH != null) {
            fH.setContentDescription(context.getString(d.j.editor_image));
        }
        return fH;
    }

    private boolean a(TbRichTextData tbRichTextData, ImageView imageView, int i, int i2) {
        if (tbRichTextData == null || imageView == null) {
            return false;
        }
        TbRichTextLinkImageInfo IW = tbRichTextData.IW();
        if (IW != null && IW.getLink() != null) {
            if (imageView instanceof TbImageView) {
                TbImageView tbImageView = (TbImageView) imageView;
                if (this.aSl.aRn) {
                    tbImageView.setSupportNoImage(true);
                }
                tbImageView.startLoad(IW.Jm(), this.mIsFromCDN ? 17 : 18, false);
                tbImageView.setTag(new c(IW.getLink()));
                if (!IW.Jd()) {
                    tbImageView.setAdjustViewBounds(false);
                }
            }
            return b(imageView, IW.getWidth(), IW.getHeight(), i, i2, this.aSM);
        }
        return false;
    }

    private boolean b(TbRichTextData tbRichTextData, ImageView imageView, int i, int i2) {
        if (tbRichTextData == null || imageView == null) {
            return false;
        }
        if (tbRichTextData.IU() == null) {
            return false;
        }
        if (imageView instanceof TbImageView) {
            TbImageView tbImageView = (TbImageView) imageView;
            if (this.aSl.aRn) {
                tbImageView.setSupportNoImage(true);
            }
            tbImageView.startLoad(tbRichTextData.IU().memeInfo.pic_url, this.mIsFromCDN ? 17 : 18, false);
            tbImageView.setAdjustViewBounds(false);
            tbImageView.setTag(d.g.tag_rich_text_meme_info, tbRichTextData.IU());
        }
        return b(imageView, tbRichTextData.IU().memeInfo.width.intValue(), tbRichTextData.IU().memeInfo.height.intValue(), i, i2, this.mOnClickListener);
    }

    private boolean c(TbRichTextData tbRichTextData, ImageView imageView, int i, int i2) {
        if (tbRichTextData == null || imageView == null) {
            return false;
        }
        if (tbRichTextData.IO() == null) {
            return false;
        }
        if (imageView instanceof TbImageView) {
            TbImageView tbImageView = (TbImageView) imageView;
            if (this.aSl.aRn) {
                tbImageView.setSupportNoImage(true);
            }
            tbImageView.startLoad(tbRichTextData.IO().Jc(), this.mIsFromCDN ? 17 : 18, false);
            if (!tbRichTextData.IO().Jd()) {
                tbImageView.setAdjustViewBounds(false);
            }
            tbImageView.setTag(d.g.tag_rich_text_meme_info, null);
        }
        return a(imageView, tbRichTextData.IO().getWidth(), tbRichTextData.IO().getHeight(), i, i2, this.mOnClickListener);
    }

    private TextView bb(Context context) {
        TextView textView = null;
        if (this.aSn != null) {
            textView = this.aSn.fH();
        }
        if (textView == null || textView.getParent() != null) {
            textView = new TbListTextView(context);
        }
        textView.setPadding(this.aSl.aRc, 0, this.aSl.aRc, 0);
        return textView;
    }

    private boolean a(TbRichTextData tbRichTextData, TextView textView, boolean z, b bVar) {
        LinearLayout.LayoutParams layoutParams;
        if (z) {
            layoutParams = new LinearLayout.LayoutParams(-1, -2);
        } else {
            layoutParams = new LinearLayout.LayoutParams(-2, -2);
        }
        if (this.aSH) {
            layoutParams.gravity = 16;
            textView.setGravity(16);
        } else {
            layoutParams.topMargin = this.aSl.aRd;
        }
        textView.setLineSpacing(this.aSl.aRb, this.aSl.aRa);
        textView.setTextSize(0, this.aSl.aRe);
        textView.setTextColor(this.aSl.mTextColor);
        textView.setLinkTextColor(aj.getColor(d.C0080d.cp_link_tip_c));
        textView.setHighlightColor(getContext().getResources().getColor(d.C0080d.transparent));
        textView.setSingleLine(this.aSl.aRk);
        if (this.aSt != null) {
            textView.setEllipsize(this.aSt);
        }
        if (this.mMaxWidth > 0) {
            textView.setMaxWidth(this.mMaxWidth);
        }
        if (this.aSI > 0) {
            textView.setMaxLines(this.aSI);
        }
        if (tbRichTextData == null) {
            return false;
        }
        SpannableStringBuilder IP = tbRichTextData.IP();
        if (IP == null || IP.length() <= 0) {
            return false;
        }
        int lineHeight = textView.getLineHeight();
        int textSize = lineHeight - ((int) textView.getTextSize());
        if (this.aSl.aRg > 0 && this.aSl.aRf > 0) {
            tbRichTextData.T(this.aSl.aRf, this.aSl.aRg);
        }
        if (textSize > 0) {
            tbRichTextData.S(lineHeight, textSize);
        }
        if (bVar != null) {
            bVar.a(IP, textView, this);
        }
        try {
            textView.setText(IP);
        } catch (Exception e2) {
            textView.setText("");
        }
        if (this.aSJ) {
            if (tbRichTextData.IY()) {
                textView.setMovementMethod(com.baidu.tieba.view.c.bBh());
            } else {
                textView.setMovementMethod(LinkMovementMethod.getInstance());
            }
        }
        textView.setFocusable(false);
        textView.setLayoutParams(layoutParams);
        textView.setTag(tbRichTextData);
        if (tbRichTextData != null && tbRichTextData.IR() != null) {
            tbRichTextData.IR().needRecompute = this.aSO;
        }
        return true;
    }

    private GifView getGifView() {
        GifView gifView = null;
        if (this.aSr != null) {
            gifView = this.aSr.fH();
        }
        GifView gifView2 = (gifView == null || gifView.getParent() != null) ? new GifView(getContext()) : gifView;
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
        if (layoutParams == null || layoutParams.width != tbRichTextData.IT().mGifInfo.mGifWidth || layoutParams.height != tbRichTextData.IT().mGifInfo.mGifHeight) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(tbRichTextData.IT().mGifInfo.mGifWidth, tbRichTextData.IT().mGifInfo.mGifHeight);
            layoutParams2.gravity = 3;
            gifView.setLayoutParams(layoutParams2);
        } else {
            layoutParams.bottomMargin = 0;
        }
        gifView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (TbRichTextView.this.aSF != null) {
                    TbRichTextEmotionInfo IT = tbRichTextData.IT();
                    TbRichTextView.this.aSF.a(view, IT.mGifInfo.mGid, IT.mGifInfo.mPackageName, IT.mGifInfo.mIcon, IT.mGifInfo.mStaticUrl, IT.mGifInfo.mDynamicUrl, IT.mGifInfo.mSharpText, IT.mGifInfo.mGifWidth, IT.mGifInfo.mGifHeight);
                }
            }
        });
        gifView.a(tbRichTextData.IT().mGifInfo);
        return true;
    }

    private View getVoiceView() {
        View fH = this.aSo != null ? this.aSo.fH() : null;
        if ((fH == null || fH.getParent() != null) && this.aSA != -1) {
            fH = LayoutInflater.from(getContext()).inflate(this.aSA, (ViewGroup) null);
        }
        if (fH != null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.topMargin = this.aSl.aRd;
            layoutParams.bottomMargin = this.aSl.aRr;
            fH.setLayoutParams(layoutParams);
            return fH;
        }
        return null;
    }

    private boolean a(TbRichTextData tbRichTextData, View view) {
        view.setTag(tbRichTextData.IQ());
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LinearLayout.LayoutParams(-2, -2);
        }
        view.setLayoutParams(layoutParams);
        return true;
    }

    private View getTextVoiceView() {
        LinearLayout fH = this.aSp.fH();
        if (fH != null) {
            TextView bb = bb(getContext());
            if (bb == null) {
                this.aSp.m(fH);
                return null;
            }
            fH.addView(bb);
            View voiceView = getVoiceView();
            if (voiceView == null) {
                this.aSn.m(bb);
                this.aSp.m(fH);
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
        if (f2 != this.aSl.aRe) {
            this.aSl.aRe = f2;
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
        if (i != this.aSl.mTextColor) {
            this.aSl.mTextColor = i;
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
        if (this.aSl.aRc != i) {
            this.aSl.aRc = i;
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (childAt != null && (childAt instanceof TextView)) {
                    ((TextView) childAt).setPadding(this.aSl.aRc, 0, 0, this.aSl.aRc);
                }
            }
        }
    }

    public void setLinkTextColor(int i) {
        if (i != this.aSl.aRl) {
            this.aSl.aRl = i;
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (childAt != null && (childAt instanceof TextView)) {
                    ((TextView) childAt).setLinkTextColor(i);
                }
            }
        }
    }

    public void setDuiEnabled(boolean z) {
        this.aSs = z;
    }

    public f getOnImageClickListener() {
        return this.aSv;
    }

    public void setOnImageClickListener(f fVar) {
        this.aSv = fVar;
    }

    public void setOnImageTouchListener(com.baidu.tieba.pb.a.c cVar) {
        this.aSw = cVar;
    }

    public void setOnEmotionClickListener(e eVar) {
        this.aSF = eVar;
    }

    public void m(boolean z, boolean z2) {
        if (this.aSz != z) {
            this.aSz = z;
            if (z2) {
                requestLayout();
            }
            if (!this.aSz && this.aSm != null) {
                this.aSm.clear();
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
        this.aSB = false;
        switch (motionEvent.getAction()) {
            case 1:
            case 3:
                if (!this.aSC) {
                    Jz();
                    break;
                }
                break;
        }
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        switch (motionEvent.getAction()) {
            case 0:
                if (!this.aSB) {
                    Jy();
                    break;
                }
                break;
        }
        return dispatchTouchEvent;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.aSB = true;
        return super.onTouchEvent(motionEvent);
    }

    private void Jy() {
        this.aSC = false;
        if (this.aSD == null) {
            this.aSD = new a();
        }
        postDelayed(this.aSD, ViewConfiguration.getLongPressTimeout());
    }

    private void Jz() {
        if (this.aSD != null) {
            removeCallbacks(this.aSD);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!TbRichTextView.this.aSL && TbRichTextView.this.performLongClick()) {
                TbRichTextView.this.aSC = true;
            }
        }
    }

    public void setVoiceViewRes(int i) {
        this.aSA = i;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.aSP != drawable) {
            this.aSO = true;
            this.aSP = drawable;
        }
        setText(this.aSG);
        this.aSO = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.aSl != null) {
            this.aSl.release();
        }
        stopLoad();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        stopLoad();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 8 || i == 4) {
            stopLoad();
        } else {
            refresh();
        }
    }

    public void he(String str) {
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
            stopLoad();
        }
        this.mUrl = str;
        this.mPageId = bdUniqueId;
        setBackgroundDrawable(null);
        com.baidu.adp.widget.a.a aVar = (com.baidu.adp.widget.a.a) com.baidu.adp.lib.f.c.fJ().a(this.mUrl, 19, new Object[0]);
        if (aVar != null) {
            f(aVar);
        } else if (z) {
            invalidate();
        } else if (!com.baidu.adp.lib.f.c.fJ().ao(19)) {
            invalidate();
        } else {
            com.baidu.adp.lib.f.c.fJ().a(this.mUrl, 19, this.mCallback, 0, 0, this.mPageId, new Object[0]);
        }
    }

    public void stopLoad() {
        if (!TextUtils.isEmpty(this.mUrl)) {
            com.baidu.adp.lib.f.c.fJ().a(this.mUrl, 19, this.mCallback);
            setBackgroundDrawable(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(com.baidu.adp.widget.a.a aVar) {
        if (aVar != null) {
            try {
                NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(getResources(), aVar.kK(), aVar.kK().getNinePatchChunk(), aVar.kO(), null);
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
        he(this.mUrl);
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
        return this.aSx;
    }

    public void setOnLinkImageClickListener(g gVar) {
        this.aSx = gVar;
    }

    public void setHasMovementMethod(boolean z) {
        this.aSJ = z;
    }

    public void setTextCenter(boolean z) {
        this.aSH = z;
    }
}
