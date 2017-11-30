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
    private static final float aUe = l.af(TbadkCoreApplication.getInst());
    private com.baidu.adp.lib.e.b<GifView> aVA;
    private boolean aVB;
    private TextUtils.TruncateAt aVC;
    private h aVD;
    private f aVE;
    private com.baidu.tieba.pb.a.c aVF;
    private g aVG;
    private View.OnClickListener aVH;
    private boolean aVI;
    private int aVJ;
    private boolean aVK;
    private boolean aVL;
    private Runnable aVM;
    private boolean aVN;
    private e aVO;
    private TbRichText aVP;
    private boolean aVQ;
    private int aVR;
    private boolean aVS;
    private boolean aVT;
    private boolean aVU;
    public final View.OnClickListener aVV;
    private final d aVW;
    private boolean aVX;
    private Drawable aVY;
    private CustomMessageListener aVZ;
    private com.baidu.tbadk.widget.richText.a aVu;
    private com.baidu.adp.lib.e.b<ImageView> aVv;
    private com.baidu.adp.lib.e.b<TextView> aVw;
    private com.baidu.adp.lib.e.b<View> aVx;
    private com.baidu.adp.lib.e.b<LinearLayout> aVy;
    private com.baidu.adp.lib.e.b<RelativeLayout> aVz;
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
        void s(MotionEvent motionEvent);
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
        this.aVT = z;
    }

    public boolean Kf() {
        return this.aVN;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public void setMaxWidth(int i) {
        this.mMaxWidth = i;
    }

    public void setMaxLines(int i) {
        this.aVR = i;
    }

    public void setTextEllipsize(TextUtils.TruncateAt truncateAt) {
        this.aVC = truncateAt;
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
    public boolean T(View view) {
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
            /* renamed from: Ki */
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
        this.aVu = new com.baidu.tbadk.widget.richText.a();
        this.aVv = null;
        this.aVw = null;
        this.aVx = null;
        this.aVy = null;
        this.aVz = null;
        this.aVA = null;
        this.aVB = true;
        this.aVC = null;
        this.aVD = null;
        this.aVE = null;
        this.aVF = null;
        this.aVG = null;
        this.aVH = null;
        this.aVI = true;
        this.mIsFromCDN = true;
        this.aVJ = -1;
        this.aVK = false;
        this.aVL = false;
        this.aVM = null;
        this.aVN = false;
        this.aVQ = false;
        this.mMaxWidth = -1;
        this.aVR = -1;
        this.aVS = true;
        this.aVT = false;
        this.aVU = false;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                String str;
                int i = 0;
                if (TbRichTextView.this.aVE != null && (view instanceof ImageView)) {
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
                        TbRichTextView.this.aVE.a(view, null, i2);
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
                        TbRichTextView.this.aVE.a(view, str, i3);
                        return;
                    } else {
                        url = view instanceof TbImageView ? ((TbImageView) view).getUrl() : null;
                    }
                    int childCount3 = TbRichTextView.this.getChildCount();
                    int i4 = -1;
                    while (i < childCount3) {
                        View childAt = TbRichTextView.this.getChildAt(i);
                        if (TbRichTextView.this.T(childAt)) {
                            i4++;
                        }
                        if (view == childAt) {
                            break;
                        }
                        i++;
                    }
                    TbRichTextView.this.aVE.a(view, url, i4);
                }
            }
        };
        this.mInternalGestureDetector = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.4
            @Override // com.baidu.tieba.pb.a.c.a
            public boolean a(View view, MotionEvent motionEvent) {
                if (TbRichTextView.this.aVF != null) {
                    TbRichTextView.this.aVF.aX(view);
                    return TbRichTextView.this.aVF.onDoubleTap(motionEvent);
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
        this.aVV = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                if (TbRichTextView.this.aVG != null && (view instanceof TbImageView)) {
                    Object tag = view.getTag();
                    if (tag == null || !(tag instanceof c)) {
                        str = null;
                    } else {
                        str = ((c) tag).url;
                    }
                    TbRichTextView.this.aVG.b(view, str);
                }
            }
        };
        this.aVW = new d() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.11
            @Override // com.baidu.tbadk.widget.richText.TbRichTextView.d
            public void s(MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    TbRichTextView.this.aVU = true;
                } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                    TbRichTextView.this.aVU = false;
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
        this.aVZ = new CustomMessageListener(CmdConfigCustom.PB_RICHTEXT_CHANGE_CMD) { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (TbRichTextView.this.aVT) {
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
        this.aVu = new com.baidu.tbadk.widget.richText.a();
        this.aVv = null;
        this.aVw = null;
        this.aVx = null;
        this.aVy = null;
        this.aVz = null;
        this.aVA = null;
        this.aVB = true;
        this.aVC = null;
        this.aVD = null;
        this.aVE = null;
        this.aVF = null;
        this.aVG = null;
        this.aVH = null;
        this.aVI = true;
        this.mIsFromCDN = true;
        this.aVJ = -1;
        this.aVK = false;
        this.aVL = false;
        this.aVM = null;
        this.aVN = false;
        this.aVQ = false;
        this.mMaxWidth = -1;
        this.aVR = -1;
        this.aVS = true;
        this.aVT = false;
        this.aVU = false;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                String str;
                int i = 0;
                if (TbRichTextView.this.aVE != null && (view instanceof ImageView)) {
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
                        TbRichTextView.this.aVE.a(view, null, i2);
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
                        TbRichTextView.this.aVE.a(view, str, i3);
                        return;
                    } else {
                        url = view instanceof TbImageView ? ((TbImageView) view).getUrl() : null;
                    }
                    int childCount3 = TbRichTextView.this.getChildCount();
                    int i4 = -1;
                    while (i < childCount3) {
                        View childAt = TbRichTextView.this.getChildAt(i);
                        if (TbRichTextView.this.T(childAt)) {
                            i4++;
                        }
                        if (view == childAt) {
                            break;
                        }
                        i++;
                    }
                    TbRichTextView.this.aVE.a(view, url, i4);
                }
            }
        };
        this.mInternalGestureDetector = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.4
            @Override // com.baidu.tieba.pb.a.c.a
            public boolean a(View view, MotionEvent motionEvent) {
                if (TbRichTextView.this.aVF != null) {
                    TbRichTextView.this.aVF.aX(view);
                    return TbRichTextView.this.aVF.onDoubleTap(motionEvent);
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
        this.aVV = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                if (TbRichTextView.this.aVG != null && (view instanceof TbImageView)) {
                    Object tag = view.getTag();
                    if (tag == null || !(tag instanceof c)) {
                        str = null;
                    } else {
                        str = ((c) tag).url;
                    }
                    TbRichTextView.this.aVG.b(view, str);
                }
            }
        };
        this.aVW = new d() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.11
            @Override // com.baidu.tbadk.widget.richText.TbRichTextView.d
            public void s(MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    TbRichTextView.this.aVU = true;
                } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                    TbRichTextView.this.aVU = false;
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
        this.aVZ = new CustomMessageListener(CmdConfigCustom.PB_RICHTEXT_CHANGE_CMD) { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (TbRichTextView.this.aVT) {
                    TbRichTextView.this.setTextSize(TbConfig.getContentSizeOfLzl());
                } else {
                    TbRichTextView.this.setTextSize(TbConfig.getContentSize());
                }
            }
        };
        init();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.l.TbRichTextView);
        this.aVu.a(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
    }

    public com.baidu.tbadk.widget.richText.a getLayoutStrategy() {
        return this.aVu;
    }

    public void setLayoutStrategy(com.baidu.tbadk.widget.richText.a aVar) {
        if (aVar != null) {
            this.aVu.release();
            this.aVu = aVar;
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
            Y.registerListener(this.aVZ);
        }
        if (eVar != null) {
            this.aVv = eVar.JW();
            this.aVw = eVar.JX();
            this.aVx = eVar.JZ();
            this.aVy = eVar.Ka();
            this.aVA = eVar.JY();
            this.aVz = eVar.Kb();
            if (eVar.getListView() != null && this.aVD == null) {
                this.aVD = new h(eVar.JV());
                eVar.getListView().setRecyclerListener(this.aVD);
            }
        }
        setOrientation(1);
        setOnHierarchyChangeListener(new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.7
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof GifView) && TbRichTextView.this.aVA != null) {
                    TbRichTextView.this.aVA.m((GifView) view2);
                } else if ((view2 instanceof ImageView) && TbRichTextView.this.aVv != null) {
                    TbRichTextView.this.aVv.m((ImageView) view2);
                } else if ((view2 instanceof TextView) && TbRichTextView.this.aVw != null) {
                    TbRichTextView.this.aVw.m((TextView) view2);
                } else if ((view2 instanceof PlayVoiceBnt) && TbRichTextView.this.aVx != null) {
                    TbRichTextView.this.aVx.m(view2);
                } else if ((view2 instanceof PlayVoiceBntNew) && TbRichTextView.this.aVx != null) {
                    TbRichTextView.this.aVx.m(view2);
                } else if ((view2 instanceof RelativeLayout) && TbRichTextView.this.aVz != null) {
                    TbRichTextView.this.aVz.m((RelativeLayout) view2);
                }
                if (view2 instanceof LinearLayout) {
                    Object tag = view2.getTag();
                    if (tag == null || !(tag instanceof String) || !"VideoView".equals(tag)) {
                        if (TbRichTextView.this.aVy != null) {
                            int childCount = ((LinearLayout) view2).getChildCount();
                            for (int i = 0; i < childCount; i++) {
                                View childAt = ((LinearLayout) view2).getChildAt(i);
                                if (childAt != null) {
                                    if ((childAt instanceof TextView) && TbRichTextView.this.aVw != null) {
                                        TbRichTextView.this.aVw.m((TextView) childAt);
                                    } else if ((childAt instanceof PlayVoiceBnt) && TbRichTextView.this.aVx != null) {
                                        TbRichTextView.this.aVx.m(childAt);
                                    } else if ((childAt instanceof PlayVoiceBntNew) && TbRichTextView.this.aVx != null) {
                                        TbRichTextView.this.aVx.m(childAt);
                                    }
                                }
                            }
                            ((LinearLayout) view2).removeAllViews();
                            TbRichTextView.this.aVy.m((LinearLayout) view2);
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
    /* JADX WARN: Type inference failed for: r21v0, types: [com.baidu.tbadk.widget.richText.TbRichTextView] */
    /* JADX WARN: Type inference failed for: r3v38, types: [android.widget.ImageView] */
    /* JADX WARN: Type inference failed for: r4v8 */
    public void a(TbRichText tbRichText, boolean z, b bVar) {
        ArrayList<TbRichTextData> Jq;
        int i;
        RelativeLayout relativeLayout;
        int i2;
        SpannableStringBuilder Jx;
        boolean z2;
        View view;
        KeyEvent.Callback a2;
        boolean z3;
        int i3;
        int i4;
        if (this.aVP != tbRichText || (tbRichText != null && tbRichText.isChanged)) {
            if (tbRichText != null) {
                tbRichText.isChanged = false;
            }
            this.aVP = tbRichText;
            removeAllViews();
            if (tbRichText != null && (Jq = tbRichText.Jq()) != null) {
                View view2 = null;
                boolean z4 = true;
                Iterator<TbRichTextData> it = Jq.iterator();
                int i5 = 0;
                View view3 = null;
                int i6 = 0;
                while (it.hasNext()) {
                    TbRichTextData next = it.next();
                    boolean z5 = false;
                    if (next != null) {
                        if (next.getType() == 1) {
                            TextView bg = bg(getContext());
                            boolean a3 = a(next, bg, true, bVar);
                            if (z && !this.aVN && (Jx = next.Jx()) != null) {
                                this.aVN = Jx.length() >= 200;
                            }
                            if (this.aVF != null) {
                                bg.setOnTouchListener(this.mInternalGestureDetector);
                            } else {
                                bg.setOnClickListener(this.aVH);
                            }
                            z5 = a3;
                            i = i5;
                            int i7 = i6;
                            relativeLayout = bg;
                            i2 = i7;
                        } else if (next.getType() == 8) {
                            if (i5 < 10) {
                                ?? bf = bf(getContext());
                                z5 = c(next, bf, this.aVu.aUm, this.aVu.aUn);
                                i2 = i6;
                                i = i5 + 1;
                                relativeLayout = bf;
                            }
                        } else if (next.getType() == 32) {
                            com.baidu.tbadk.widget.richText.f JA = next.JA();
                            if (JA != null && JA.Kd()) {
                                a2 = b(JA);
                            } else {
                                a2 = a(next);
                            }
                            i2 = i6;
                            i = i5;
                            relativeLayout = a2;
                            z5 = true;
                        } else if (next.getType() == 512) {
                            View voiceView = getVoiceView();
                            if (voiceView == null) {
                                view3 = voiceView;
                            } else {
                                i2 = i6;
                                i = i5;
                                relativeLayout = voiceView;
                                z5 = a(next, voiceView);
                            }
                        } else if (next.getType() == 768) {
                            View textVoiceView = getTextVoiceView();
                            z5 = a(next, (LinearLayout) textVoiceView, bVar);
                            i2 = i6;
                            i = i5;
                            relativeLayout = textVoiceView;
                        } else if (next.getType() == 17) {
                            GifView gifView = getGifView();
                            z5 = a(next, gifView);
                            i2 = i6;
                            i = i5;
                            relativeLayout = gifView;
                        } else if (next.getType() == 20) {
                            if (i6 < 10) {
                                int i8 = i6 + 1;
                                if (next == null || next.JC() == null || next.JC().memeInfo == null || StringUtils.isNull(next.JC().memeInfo.pic_url)) {
                                    z3 = false;
                                } else {
                                    z3 = true;
                                }
                                if (z3) {
                                    RelativeLayout fH = this.aVz.fH();
                                    fH.removeAllViews();
                                    fH.setLayoutParams(new LinearLayout.LayoutParams(next.JC().memeInfo.width.intValue(), next.JC().memeInfo.height.intValue()));
                                    if (p.GT() && this.aVB) {
                                        b(fH, next.JC().memeInfo.width.intValue(), next.JC().memeInfo.height.intValue(), this.aVu.aUm, this.aVu.aUn);
                                    } else {
                                        a(fH, next.JC().memeInfo.width.intValue(), next.JC().memeInfo.height.intValue(), this.aVu.aUm, this.aVu.aUn);
                                    }
                                    ImageView fH2 = this.aVv.fH();
                                    b(next, fH2, this.aVu.aUm, this.aVu.aUn);
                                    if (p.GT() && this.aVB) {
                                        ImageView fH3 = this.aVv.fH();
                                        fH3.setTag(this.aVP);
                                        if (fH3 instanceof TbImageView) {
                                            ((TbImageView) fH3).setAdjustViewBounds(false);
                                        }
                                        fH3.setScaleType(ImageView.ScaleType.FIT_XY);
                                        int f2 = l.f(getContext(), d.e.ds78);
                                        int f3 = l.f(getContext(), d.e.ds78);
                                        fH2.setId(d.g.meme_image_view);
                                        c(fH2, next.JC().memeInfo.width.intValue(), next.JC().memeInfo.height.intValue(), this.aVu.aUm, this.aVu.aUn, this.mOnClickListener);
                                        fH.addView(fH2);
                                        if (f3 > next.JC().memeInfo.height.intValue()) {
                                            i4 = f2 / 2;
                                            i3 = f3 / 2;
                                        } else {
                                            i3 = f3;
                                            i4 = f2;
                                        }
                                        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i4, i3);
                                        layoutParams.addRule(8, d.g.meme_image_view);
                                        layoutParams.addRule(11);
                                        fH3.setOnClickListener(this.mOnClickListener);
                                        if (fH.getLeft() > 0) {
                                            layoutParams.rightMargin = l.f(getContext(), d.e.ds6);
                                        }
                                        aj.c(fH3, d.f.icon_emotion_dui_n);
                                        fH.addView(fH3, layoutParams);
                                    } else {
                                        b(fH2, next.JC().memeInfo.width.intValue(), next.JC().memeInfo.height.intValue(), this.aVu.aUm, this.aVu.aUn, this.mOnClickListener);
                                        fH.addView(fH2);
                                    }
                                    z5 = z3;
                                    i2 = i8;
                                    i = i5;
                                    relativeLayout = fH;
                                } else {
                                    z5 = z3;
                                    i2 = i8;
                                    i = i5;
                                    relativeLayout = view3;
                                }
                            }
                        } else if (next.getType() == 1280) {
                            ImageView bf2 = bf(getContext());
                            z5 = a(next, bf2, (this.aVu.aUm - getPaddingLeft()) - getPaddingRight(), this.aVu.aUn);
                            i2 = i6;
                            i = i5 + 1;
                            relativeLayout = bf2;
                        } else {
                            i2 = i6;
                            i = i5;
                            relativeLayout = view3;
                        }
                        if (!z5 || relativeLayout == null) {
                            z2 = z4;
                            view = view2;
                        } else {
                            addView(relativeLayout);
                            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) relativeLayout.getLayoutParams();
                            if (z4 && this.aVu.aUB >= 0) {
                                z4 = false;
                                if (layoutParams2 != null) {
                                    layoutParams2.topMargin = this.aVu.aUB;
                                    relativeLayout.setLayoutParams(layoutParams2);
                                    z2 = false;
                                    view = relativeLayout;
                                }
                                z2 = z4;
                                view = relativeLayout;
                            } else if (relativeLayout instanceof TbListTextView) {
                                if ((view2 instanceof ImageView) || (view2 instanceof RelativeLayout)) {
                                    layoutParams2.topMargin = this.aVu.aUx;
                                } else {
                                    layoutParams2.topMargin = this.aVu.aUi;
                                }
                                relativeLayout.setLayoutParams(layoutParams2);
                                z2 = z4;
                                view = relativeLayout;
                            } else {
                                if (((relativeLayout instanceof ImageView) || (relativeLayout instanceof RelativeLayout)) && (next.getType() == 8 || next.getType() == 20 || next.getType() == 17)) {
                                    if (view2 instanceof TbListTextView) {
                                        layoutParams2.topMargin = this.aVu.aUw;
                                    } else if ((view2 instanceof ImageView) || (relativeLayout instanceof RelativeLayout)) {
                                        layoutParams2.topMargin = this.aVu.aUv;
                                    } else {
                                        layoutParams2.topMargin = this.aVu.aUi;
                                    }
                                    relativeLayout.setLayoutParams(layoutParams2);
                                }
                                z2 = z4;
                                view = relativeLayout;
                            }
                        }
                        z4 = z2;
                        i5 = i;
                        view2 = view;
                        view3 = relativeLayout;
                        i6 = i2;
                    }
                }
                if (view2 instanceof TbListTextView) {
                    LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) view2.getLayoutParams();
                    layoutParams3.bottomMargin = this.aVu.aUA;
                    view2.setLayoutParams(layoutParams3);
                } else if (view2 != null && this.aVu.aUz >= 0) {
                    LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) view2.getLayoutParams();
                    layoutParams4.bottomMargin = this.aVu.aUz;
                    view2.setLayoutParams(layoutParams4);
                }
            }
        }
    }

    public void setCommonTextViewOnClickListener(View.OnClickListener onClickListener) {
        this.aVH = onClickListener;
    }

    private View b(final com.baidu.tbadk.widget.richText.f fVar) {
        if (fVar == null || !fVar.isAvaliable()) {
            return null;
        }
        ImageView fH = this.aVv.fH();
        if (fH instanceof ForeDrawableImageView) {
            ForeDrawableImageView foreDrawableImageView = (ForeDrawableImageView) fH;
            foreDrawableImageView.setForegroundDrawable(d.f.icon_play_video);
            foreDrawableImageView.setNoImageBottomTextColor(d.C0082d.cp_cont_c);
            foreDrawableImageView.setNoImageBottomTextPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds32));
            foreDrawableImageView.setNoImageBottomTextSize(TbadkCoreApplication.getInst().getResources().getDimension(d.e.fontsize28));
            foreDrawableImageView.setNoImageBottomText("点击播放视频");
            foreDrawableImageView.setInterceptOnClick(false);
            foreDrawableImageView.setTag("VideoView");
            b(foreDrawableImageView, fVar.getWidth(), fVar.getHeight(), (this.aVu.aUm - getPaddingLeft()) - getPaddingRight(), this.aVu.aUn, new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log("c10643");
                    XiaoyingUtil.startPlayXiaoyingVideo(TbRichTextView.this.getContext(), fVar.getVideoUrl(), fVar.getWidth(), fVar.getHeight(), fVar.getThumbUrl());
                }
            });
            foreDrawableImageView.setDefaultResource(0);
            foreDrawableImageView.setSupportNoImage(this.aVu.aUt);
            if (com.baidu.tbadk.core.h.pa().pg()) {
                foreDrawableImageView.setDefaultBgResource(d.f.pic_bg_video_frs);
            } else {
                foreDrawableImageView.setDefaultBgResource(d.C0082d.cp_bg_line_c);
            }
            foreDrawableImageView.startLoad(fVar.getThumbUrl(), 17, false);
            return fH;
        }
        return fH;
    }

    private boolean a(ImageView imageView, int i, int i2, int i3, int i4, View.OnClickListener onClickListener) {
        int[] l = this.aVu.l(i, i2, i3, i4);
        if (l == null) {
            return false;
        }
        int i5 = l[0];
        int i6 = l[1];
        if (imageView instanceof TbImageView) {
            TbImageView tbImageView = (TbImageView) imageView;
            tbImageView.setDefaultResource(this.aVu.aUo);
            if (tbImageView.getGifIconWidth() >= i5 || tbImageView.getGifIconHeight() >= i6) {
                tbImageView.setGifIconSupport(false);
            } else {
                tbImageView.setGifIconSupport(true);
            }
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i5, i6);
        if (this.aVu.aUu) {
            imageView.setScaleType(this.aVu.aUs);
            if (imageView instanceof TbImageView) {
                ((TbImageView) imageView).setOnDrawListener(this.aVu.mOnDrawListener);
            }
        } else {
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        }
        imageView.setClickable(true);
        imageView.setFocusable(false);
        if (this.aVF != null && (imageView instanceof TbImageView)) {
            ((TbImageView) imageView).setTbGestureDetector(this.mInternalGestureDetector);
            imageView.setClickable(true);
        } else {
            imageView.setOnClickListener(onClickListener);
        }
        imageView.setLayoutParams(layoutParams);
        if (imageView instanceof TbImageView) {
            if (this.onLongClickListener != null) {
                ((TbImageView) imageView).setDispatchTouchListener(this.aVW);
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
        if (!this.aVu.aUu || i3 <= i6 || aUe <= 1.0f) {
            i3 = i6;
            i5 = i7;
        } else {
            if (i6 * aUe <= i3) {
                if (i6 * aUe > i3 * 0.68f) {
                    i3 = (int) (i3 * 0.68f);
                } else {
                    i3 = (int) (i6 * aUe);
                }
            }
            i5 = iArr[0] > 0 ? (iArr[1] * i3) / iArr[0] : i7;
        }
        if (imageView instanceof TbImageView) {
            TbImageView tbImageView = (TbImageView) imageView;
            tbImageView.setDefaultResource(this.aVu.aUo);
            if (tbImageView.getGifIconWidth() >= i3 || tbImageView.getGifIconHeight() >= i5) {
                tbImageView.setGifIconSupport(false);
            } else {
                tbImageView.setGifIconSupport(true);
            }
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i3, i5);
        if (this.aVu.aUu) {
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        } else {
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        }
        imageView.setClickable(true);
        imageView.setFocusable(false);
        if (this.aVF != null && (imageView instanceof TbImageView)) {
            ((TbImageView) imageView).setTbGestureDetector(this.mInternalGestureDetector);
            imageView.setClickable(true);
        } else {
            imageView.setOnClickListener(onClickListener);
        }
        imageView.setLayoutParams(layoutParams);
        if (imageView instanceof TbImageView) {
            if (this.onLongClickListener != null) {
                ((TbImageView) imageView).setDispatchTouchListener(this.aVW);
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
        if (this.aVu.aUu && i3 > i7 && aUe > 1.0f) {
            if (i7 * aUe > i3) {
                i7 = (i3 - l.f(getContext(), d.e.ds78)) - l.f(getContext(), d.e.ds16);
            } else if (i7 * aUe > i3 * 0.68f) {
                i7 = ((int) (i3 * 0.68f)) - l.f(getContext(), d.e.ds78);
            } else {
                i7 = (int) (i7 * aUe);
            }
            if (iArr[0] > 0) {
                i5 = (iArr[1] * i7) / iArr[0];
                i6 = i7;
                if (imageView instanceof TbImageView) {
                    TbImageView tbImageView = (TbImageView) imageView;
                    tbImageView.setDefaultResource(this.aVu.aUo);
                    if (tbImageView.getGifIconWidth() >= i6 || tbImageView.getGifIconHeight() >= i5) {
                        tbImageView.setGifIconSupport(false);
                    } else {
                        tbImageView.setGifIconSupport(true);
                    }
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i6, i5);
                if (!this.aVu.aUu) {
                    imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                } else {
                    imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                }
                imageView.setClickable(true);
                imageView.setFocusable(false);
                if (this.aVF == null && (imageView instanceof TbImageView)) {
                    ((TbImageView) imageView).setTbGestureDetector(this.mInternalGestureDetector);
                    imageView.setClickable(true);
                } else {
                    imageView.setOnClickListener(onClickListener);
                }
                imageView.setLayoutParams(layoutParams);
                if (!(imageView instanceof TbImageView)) {
                    if (this.onLongClickListener != null) {
                        ((TbImageView) imageView).setDispatchTouchListener(this.aVW);
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
        if (!this.aVu.aUu) {
        }
        imageView.setClickable(true);
        imageView.setFocusable(false);
        if (this.aVF == null) {
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
            if (!this.aVu.aUu || i3 <= i5 || aUe <= 1.0f) {
                i3 = i5;
            } else {
                if (i5 * aUe <= i3) {
                    if (i5 * aUe > i3 * 0.68f) {
                        i3 = (int) (i3 * 0.68f);
                    } else {
                        i3 = (int) (i5 * aUe);
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
            if (this.aVu.aUu && i3 > i7 && aUe > 1.0f) {
                if (i7 * aUe > i3) {
                    i6 = (i3 - l.f(getContext(), d.e.ds78)) - l.f(getContext(), d.e.ds16);
                } else if (i7 * aUe > i3 * 0.68f) {
                    i6 = ((int) (i3 * 0.68f)) - l.f(getContext(), d.e.ds78);
                } else {
                    i6 = (int) (i7 * aUe);
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
        if (this.aVu.aUp <= 0 || tbRichTextData == null) {
            return null;
        }
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setTag("VideoView");
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = this.aVu.aUi;
        linearLayout.setClickable(true);
        Bitmap cR = aj.cR(this.aVu.aUp);
        if (cR != null) {
            linearLayout.setBackgroundDrawable(new BitmapDrawable(getContext().getResources(), cR));
        }
        linearLayout.setFocusable(false);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (tbRichTextData.Jx() != null) {
                    if (TbRichTextView.this.getContext() instanceof com.baidu.tbadk.widget.richText.e) {
                        ((com.baidu.tbadk.widget.richText.e) TbRichTextView.this.getContext()).X(TbRichTextView.this.getContext(), tbRichTextData.Jx().toString());
                        return;
                    }
                    com.baidu.adp.base.e<?> Y = com.baidu.adp.base.i.Y(TbRichTextView.this.getContext());
                    if (Y != null && (Y.getOrignalPage() instanceof com.baidu.tbadk.widget.richText.e)) {
                        ((com.baidu.tbadk.widget.richText.e) Y.getOrignalPage()).X(TbRichTextView.this.getContext(), tbRichTextData.Jx().toString());
                    }
                }
            }
        });
        return linearLayout;
    }

    private ImageView bf(Context context) {
        ImageView fH = this.aVv != null ? this.aVv.fH() : null;
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
        TbRichTextLinkImageInfo JE = tbRichTextData.JE();
        if (JE != null && JE.getLink() != null) {
            if (imageView instanceof TbImageView) {
                TbImageView tbImageView = (TbImageView) imageView;
                if (this.aVu.aUt) {
                    tbImageView.setSupportNoImage(true);
                }
                tbImageView.startLoad(JE.JU(), this.mIsFromCDN ? 17 : 18, false);
                tbImageView.setTag(new c(JE.getLink()));
                if (!JE.JL()) {
                    tbImageView.setAdjustViewBounds(false);
                }
            }
            return b(imageView, JE.getWidth(), JE.getHeight(), i, i2, this.aVV);
        }
        return false;
    }

    private boolean b(TbRichTextData tbRichTextData, ImageView imageView, int i, int i2) {
        if (tbRichTextData == null || imageView == null) {
            return false;
        }
        if (tbRichTextData.JC() == null) {
            return false;
        }
        if (imageView instanceof TbImageView) {
            TbImageView tbImageView = (TbImageView) imageView;
            if (this.aVu.aUt) {
                tbImageView.setSupportNoImage(true);
            }
            tbImageView.startLoad(tbRichTextData.JC().memeInfo.pic_url, this.mIsFromCDN ? 17 : 18, false);
            tbImageView.setAdjustViewBounds(false);
            tbImageView.setTag(d.g.tag_rich_text_meme_info, tbRichTextData.JC());
        }
        return b(imageView, tbRichTextData.JC().memeInfo.width.intValue(), tbRichTextData.JC().memeInfo.height.intValue(), i, i2, this.mOnClickListener);
    }

    private boolean c(TbRichTextData tbRichTextData, ImageView imageView, int i, int i2) {
        if (tbRichTextData == null || imageView == null) {
            return false;
        }
        if (tbRichTextData.Jw() == null) {
            return false;
        }
        if (imageView instanceof TbImageView) {
            TbImageView tbImageView = (TbImageView) imageView;
            if (this.aVu.aUt) {
                tbImageView.setSupportNoImage(true);
            }
            tbImageView.startLoad(tbRichTextData.Jw().JK(), this.mIsFromCDN ? 17 : 18, false);
            if (!tbRichTextData.Jw().JL()) {
                tbImageView.setAdjustViewBounds(false);
            }
            tbImageView.setTag(d.g.tag_rich_text_meme_info, null);
        }
        return a(imageView, tbRichTextData.Jw().getWidth(), tbRichTextData.Jw().getHeight(), i, i2, this.mOnClickListener);
    }

    private TextView bg(Context context) {
        TextView textView = null;
        if (this.aVw != null) {
            textView = this.aVw.fH();
        }
        if (textView == null || textView.getParent() != null) {
            textView = new TbListTextView(context);
        }
        textView.setPadding(this.aVu.aUh, 0, this.aVu.aUh, 0);
        return textView;
    }

    private boolean a(TbRichTextData tbRichTextData, TextView textView, boolean z, b bVar) {
        LinearLayout.LayoutParams layoutParams;
        if (z) {
            layoutParams = new LinearLayout.LayoutParams(-1, -2);
        } else {
            layoutParams = new LinearLayout.LayoutParams(-2, -2);
        }
        if (this.aVQ) {
            layoutParams.gravity = 16;
            textView.setGravity(16);
        } else {
            layoutParams.topMargin = this.aVu.aUi;
        }
        textView.setLineSpacing(this.aVu.aUg, this.aVu.aUf);
        textView.setTextSize(0, this.aVu.aUj);
        textView.setTextColor(this.aVu.mTextColor);
        textView.setLinkTextColor(aj.getColor(d.C0082d.cp_link_tip_c));
        textView.setHighlightColor(getContext().getResources().getColor(d.C0082d.transparent));
        textView.setSingleLine(this.aVu.aUq);
        if (this.aVC != null) {
            textView.setEllipsize(this.aVC);
        }
        if (this.mMaxWidth > 0) {
            textView.setMaxWidth(this.mMaxWidth);
        }
        if (this.aVR > 0) {
            textView.setMaxLines(this.aVR);
        }
        if (tbRichTextData == null) {
            return false;
        }
        SpannableStringBuilder Jx = tbRichTextData.Jx();
        if (Jx == null || Jx.length() <= 0) {
            return false;
        }
        if (this.aVu.aUl > 0 && this.aVu.aUk > 0) {
            tbRichTextData.T(this.aVu.aUk, this.aVu.aUl);
        }
        if (bVar != null) {
            bVar.a(Jx, textView, this);
        }
        try {
            textView.setText(Jx);
        } catch (Exception e2) {
            textView.setText("");
        }
        if (this.aVS) {
            if (tbRichTextData.JG()) {
                textView.setMovementMethod(com.baidu.tieba.view.d.bEa());
            } else {
                textView.setMovementMethod(LinkMovementMethod.getInstance());
            }
        }
        textView.setFocusable(false);
        textView.setLayoutParams(layoutParams);
        textView.setTag(tbRichTextData);
        if (tbRichTextData != null && tbRichTextData.Jz() != null) {
            tbRichTextData.Jz().needRecompute = this.aVX;
        }
        return true;
    }

    private GifView getGifView() {
        GifView gifView = null;
        if (this.aVA != null) {
            gifView = this.aVA.fH();
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
        if (layoutParams == null || layoutParams.width != tbRichTextData.JB().mGifInfo.mGifWidth || layoutParams.height != tbRichTextData.JB().mGifInfo.mGifHeight) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(tbRichTextData.JB().mGifInfo.mGifWidth, tbRichTextData.JB().mGifInfo.mGifHeight);
            layoutParams2.gravity = 3;
            gifView.setLayoutParams(layoutParams2);
        } else {
            layoutParams.bottomMargin = 0;
        }
        gifView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (TbRichTextView.this.aVO != null) {
                    TbRichTextEmotionInfo JB = tbRichTextData.JB();
                    TbRichTextView.this.aVO.a(view, JB.mGifInfo.mGid, JB.mGifInfo.mPackageName, JB.mGifInfo.mIcon, JB.mGifInfo.mStaticUrl, JB.mGifInfo.mDynamicUrl, JB.mGifInfo.mSharpText, JB.mGifInfo.mGifWidth, JB.mGifInfo.mGifHeight);
                }
            }
        });
        gifView.a(tbRichTextData.JB().mGifInfo);
        return true;
    }

    private View getVoiceView() {
        View fH = this.aVx != null ? this.aVx.fH() : null;
        if ((fH == null || fH.getParent() != null) && this.aVJ != -1) {
            fH = LayoutInflater.from(getContext()).inflate(this.aVJ, (ViewGroup) null);
        }
        if (fH != null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.topMargin = this.aVu.aUi;
            layoutParams.bottomMargin = this.aVu.aUy;
            fH.setLayoutParams(layoutParams);
            return fH;
        }
        return null;
    }

    private boolean a(TbRichTextData tbRichTextData, View view) {
        view.setTag(tbRichTextData.Jy());
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LinearLayout.LayoutParams(-2, -2);
        }
        view.setLayoutParams(layoutParams);
        return true;
    }

    private View getTextVoiceView() {
        LinearLayout fH = this.aVy.fH();
        if (fH != null) {
            TextView bg = bg(getContext());
            if (bg == null) {
                this.aVy.m(fH);
                return null;
            }
            fH.addView(bg);
            View voiceView = getVoiceView();
            if (voiceView == null) {
                this.aVw.m(bg);
                this.aVy.m(fH);
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
        if (f2 != this.aVu.aUj) {
            this.aVu.aUj = f2;
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
        if (i != this.aVu.mTextColor) {
            this.aVu.mTextColor = i;
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
        if (this.aVu.aUh != i) {
            this.aVu.aUh = i;
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (childAt != null && (childAt instanceof TextView)) {
                    ((TextView) childAt).setPadding(this.aVu.aUh, 0, 0, this.aVu.aUh);
                }
            }
        }
    }

    public void setLinkTextColor(int i) {
        if (i != this.aVu.aUr) {
            this.aVu.aUr = i;
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
        this.aVB = z;
    }

    public f getOnImageClickListener() {
        return this.aVE;
    }

    public void setOnImageClickListener(f fVar) {
        this.aVE = fVar;
    }

    public void setOnImageTouchListener(com.baidu.tieba.pb.a.c cVar) {
        this.aVF = cVar;
    }

    public void setOnEmotionClickListener(e eVar) {
        this.aVO = eVar;
    }

    public void m(boolean z, boolean z2) {
        if (this.aVI != z) {
            this.aVI = z;
            if (z2) {
                requestLayout();
            }
            if (!this.aVI && this.aVv != null) {
                this.aVv.clear();
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
        this.aVK = false;
        switch (motionEvent.getAction()) {
            case 1:
            case 3:
                if (!this.aVL) {
                    Kh();
                    break;
                }
                break;
        }
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        switch (motionEvent.getAction()) {
            case 0:
                if (!this.aVK) {
                    Kg();
                    break;
                }
                break;
        }
        return dispatchTouchEvent;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.aVK = true;
        return super.onTouchEvent(motionEvent);
    }

    private void Kg() {
        this.aVL = false;
        if (this.aVM == null) {
            this.aVM = new a();
        }
        postDelayed(this.aVM, ViewConfiguration.getLongPressTimeout());
    }

    private void Kh() {
        if (this.aVM != null) {
            removeCallbacks(this.aVM);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!TbRichTextView.this.aVU && TbRichTextView.this.performLongClick()) {
                TbRichTextView.this.aVL = true;
            }
        }
    }

    public void setVoiceViewRes(int i) {
        this.aVJ = i;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.aVY != drawable) {
            this.aVX = true;
            this.aVY = drawable;
        }
        setText(this.aVP);
        this.aVX = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.aVu != null) {
            this.aVu.release();
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

    public void hi(String str) {
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
        hi(this.mUrl);
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
        return this.aVG;
    }

    public void setOnLinkImageClickListener(g gVar) {
        this.aVG = gVar;
    }

    public void setHasMovementMethod(boolean z) {
        this.aVS = z;
    }

    public void setTextCenter(boolean z) {
        this.aVQ = z;
    }
}
