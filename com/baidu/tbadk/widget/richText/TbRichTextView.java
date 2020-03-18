package com.baidu.tbadk.widget.richText;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.support.v4.app.Fragment;
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
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tbadk.switchs.DuiSwitch;
import com.baidu.tbadk.widget.ForeDrawableImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.TbListTextView;
import com.baidu.tbadk.widget.layout.GridImageLayout;
import com.baidu.tieba.R;
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
public class TbRichTextView extends LinearLayout implements com.baidu.adp.newwidget.ImageView.h {
    private static final float dOf = l.getEquipmentDensity(TbadkCoreApplication.getInst());
    private GridImageLayout OC;
    private final com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a> cYN;
    private final com.baidu.tieba.pb.a.c dIQ;
    private com.baidu.adp.lib.d.b<ImageView> dMQ;
    private com.baidu.adp.lib.d.b<GifView> dMR;
    private com.baidu.tbadk.widget.richText.a dMS;
    private int dMX;
    private i dNb;
    private com.baidu.tieba.pb.a<ImageView> dPE;
    private com.baidu.adp.lib.d.b<TextView> dPF;
    private com.baidu.adp.lib.d.b<View> dPG;
    private com.baidu.adp.lib.d.b<LinearLayout> dPH;
    private com.baidu.adp.lib.d.b<RelativeLayout> dPI;
    private boolean dPJ;
    private TextUtils.TruncateAt dPK;
    private k dPL;
    private j dPM;
    private View.OnClickListener dPN;
    private View.OnClickListener dPO;
    private boolean dPP;
    private int dPQ;
    private View.OnClickListener dPR;
    private boolean dPS;
    private Runnable dPT;
    private boolean dPU;
    private h dPV;
    private TbRichText dPW;
    private boolean dPX;
    private boolean dPY;
    private boolean dPZ;
    private boolean dQa;
    private boolean dQb;
    private boolean dQc;
    private f dQd;
    public final View.OnClickListener dQe;
    private final g dQf;
    private boolean dQg;
    private Drawable dQh;
    private CustomMessageListener dQi;
    private com.baidu.tieba.pb.a.c drk;
    private boolean isHost;
    private boolean mHasPerformedLongPress;
    private boolean mIsFromCDN;
    private int mMaxLines;
    private int mMaxWidth;
    private final View.OnClickListener mOnClickListener;
    private BdUniqueId mPageId;
    private final int mType;
    private String mUrl;
    private View.OnLongClickListener onLongClickListener;

    /* loaded from: classes.dex */
    public interface c {
        void a(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView);
    }

    /* loaded from: classes.dex */
    public interface f {
        void aUT();
    }

    /* loaded from: classes.dex */
    public interface g {
        void x(MotionEvent motionEvent);
    }

    /* loaded from: classes.dex */
    public interface h {
        void a(View view, String str, String str2, String str3, String str4, String str5, String str6, int i, int i2);
    }

    /* loaded from: classes.dex */
    public interface i {
        void a(View view, String str, int i, boolean z, boolean z2);
    }

    /* loaded from: classes.dex */
    public interface j {
        void e(View view, String str);
    }

    public void setSubPbPost(boolean z) {
        this.dPZ = z;
        aUO();
    }

    public void setIsHost(boolean z) {
        this.isHost = z;
        if (this.OC != null) {
            this.OC.setIsHost(z);
        }
    }

    public void setIsUseGridImage(boolean z) {
        this.dQb = z;
    }

    public void setmIsGridImageSupportLongPress(boolean z) {
        this.dQc = z;
    }

    public boolean aUN() {
        return this.dPU;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
        if (this.dMS != null) {
            this.dMS.mIsFromCDN = z;
        }
    }

    public void setMaxWidth(int i2) {
        this.mMaxWidth = i2;
    }

    public void setMaxLines(int i2) {
        this.mMaxLines = i2;
    }

    public void setTextEllipsize(TextUtils.TruncateAt truncateAt) {
        this.dPK = truncateAt;
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
        super.setOnLongClickListener(onLongClickListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class e {
        public String url;

        public e(String str) {
            this.url = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bk(View view) {
        if (view instanceof ImageView) {
            if (view instanceof GifView) {
                return view.getTag(R.id.tag_rich_text_view_gif_view) != null && (view.getTag(R.id.tag_rich_text_view_gif_view) instanceof b) && ((b) view.getTag(R.id.tag_rich_text_view_gif_view)).dQm;
            }
            if ((view instanceof TbImageView) && view.getTag() != null) {
                if (view.getTag() instanceof e) {
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

    public static TbRichText a(Context context, JSONArray jSONArray, int i2) {
        return new TbRichText(context, jSONArray, i2);
    }

    public static TbRichText a(Context context, JSONArray jSONArray, boolean z) {
        return new TbRichText(context, jSONArray, z);
    }

    public static TbRichText a(Context context, List<PbContent> list, boolean z) {
        return new TbRichText(context, list, z);
    }

    public static com.baidu.adp.lib.d.b<TextView> z(final Context context, int i2) {
        return new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<TextView>() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: aUS */
            public TextView makeObject() {
                return new TbListTextView(context);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: a */
            public void destroyObject(TextView textView) {
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
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: b */
            public TextView activateObject(TextView textView) {
                return textView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: c */
            public TextView passivateObject(TextView textView) {
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
        }, i2, 0);
    }

    public TbRichTextView(Context context) {
        super(context);
        this.dMS = new com.baidu.tbadk.widget.richText.a();
        this.dPE = null;
        this.dMQ = null;
        this.dPF = null;
        this.dPG = null;
        this.dPH = null;
        this.dPI = null;
        this.dMR = null;
        this.dPJ = true;
        this.dPK = null;
        this.dPL = null;
        this.dNb = null;
        this.drk = null;
        this.dPM = null;
        this.dPN = null;
        this.dPO = null;
        this.dPP = true;
        this.mIsFromCDN = true;
        this.dPQ = -1;
        this.dPS = false;
        this.mHasPerformedLongPress = false;
        this.dPT = null;
        this.dPU = false;
        this.dPX = false;
        this.mMaxWidth = -1;
        this.mMaxLines = -1;
        this.dPY = true;
        this.dPZ = false;
        this.isHost = false;
        this.dQa = false;
        this.dQb = false;
        this.dQc = false;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                String str2 = null;
                int i2 = -1;
                if (TbRichTextView.this.dNb != null && (view instanceof ImageView)) {
                    Object tag = view.getTag();
                    if (tag != null && (tag instanceof TbRichText)) {
                        int childCount = TbRichTextView.this.getChildCount();
                        for (int i3 = 0; i3 < childCount; i3++) {
                            i2++;
                            if (view.getParent() == TbRichTextView.this.getChildAt(i3)) {
                                break;
                            }
                        }
                        TbRichTextView.this.dNb.a(view, null, i2, TbRichTextView.this.isHost, false);
                        return;
                    }
                    if (tag != null && (tag instanceof String)) {
                        str2 = (String) tag;
                    } else if ((view instanceof TbImageView) && (view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextMemeInfo)) {
                        TbRichTextMemeInfo tbRichTextMemeInfo = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                        if (tbRichTextMemeInfo != null && tbRichTextMemeInfo.memeInfo != null) {
                            str = tbRichTextMemeInfo.memeInfo.pic_url;
                        } else {
                            str = "";
                        }
                        int childCount2 = TbRichTextView.this.getChildCount();
                        for (int i4 = 0; i4 < childCount2; i4++) {
                            i2++;
                            if (view.getParent() == TbRichTextView.this.getChildAt(i4)) {
                                break;
                            }
                        }
                        TbRichTextView.this.dNb.a(view, str, i2, TbRichTextView.this.isHost, false);
                        return;
                    } else if (view instanceof TbImageView) {
                        str2 = ((TbImageView) view).getUrl();
                    } else if (view instanceof GifView) {
                        str2 = ((GifView) view).getUrl();
                    }
                    int childCount3 = TbRichTextView.this.getChildCount();
                    for (int i5 = 0; i5 < childCount3; i5++) {
                        View childAt = TbRichTextView.this.getChildAt(i5);
                        if (TbRichTextView.this.bk(childAt)) {
                            i2++;
                        }
                        if (view == childAt) {
                            break;
                        }
                    }
                    TbRichTextView.this.dNb.a(view, str2, i2, TbRichTextView.this.isHost, false);
                }
            }
        };
        this.dIQ = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.6
            @Override // com.baidu.tieba.pb.a.c.a
            public boolean onDoubleTap(View view, MotionEvent motionEvent) {
                if (TbRichTextView.this.drk != null) {
                    TbRichTextView.this.drk.Q(view);
                    return TbRichTextView.this.drk.onDoubleTap(motionEvent);
                }
                return false;
            }

            @Override // com.baidu.tieba.pb.a.c.a
            public boolean onDoubleTapEvent(View view, MotionEvent motionEvent) {
                return false;
            }

            @Override // com.baidu.tieba.pb.a.c.a
            public boolean onSingleTapConfirmed(View view, MotionEvent motionEvent) {
                if (TbRichTextView.this.mOnClickListener != null) {
                    TbRichTextView.this.mOnClickListener.onClick(view);
                    return true;
                }
                return false;
            }
        });
        this.dQe = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                if (TbRichTextView.this.dPM != null && (view instanceof TbImageView)) {
                    Object tag = view.getTag();
                    if (tag == null || !(tag instanceof e)) {
                        str = null;
                    } else {
                        str = ((e) tag).url;
                    }
                    TbRichTextView.this.dPM.e(view, str);
                }
            }
        };
        this.dQf = new g() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.13
            @Override // com.baidu.tbadk.widget.richText.TbRichTextView.g
            public void x(MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    TbRichTextView.this.dQa = true;
                } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                    TbRichTextView.this.dQa = false;
                }
            }
        };
        this.mType = 19;
        this.cYN = new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i2) {
                TbRichTextView.this.h(aVar);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.b
            public void onProgressUpdate(Object... objArr) {
                super.onProgressUpdate(objArr);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.b
            public void onCancelled(String str) {
                super.onCancelled(str);
            }
        };
        this.dQi = new CustomMessageListener(CmdConfigCustom.PB_RICHTEXT_CHANGE_CMD) { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int contentSizeOfLzl = TbRichTextView.this.dPZ ? TbConfig.getContentSizeOfLzl() : TbConfig.getContentSize();
                if (TbRichTextView.this.dPW != null && !v.isEmpty(TbRichTextView.this.dPW.aTX())) {
                    Iterator<TbRichTextData> it = TbRichTextView.this.dPW.aTX().iterator();
                    while (it.hasNext()) {
                        TbRichTextData next = it.next();
                        if (next != null) {
                            next.aV(contentSizeOfLzl, contentSizeOfLzl);
                        }
                    }
                }
                TbRichTextView.this.setTextSize(contentSizeOfLzl);
            }
        };
        init();
    }

    public TbRichTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dMS = new com.baidu.tbadk.widget.richText.a();
        this.dPE = null;
        this.dMQ = null;
        this.dPF = null;
        this.dPG = null;
        this.dPH = null;
        this.dPI = null;
        this.dMR = null;
        this.dPJ = true;
        this.dPK = null;
        this.dPL = null;
        this.dNb = null;
        this.drk = null;
        this.dPM = null;
        this.dPN = null;
        this.dPO = null;
        this.dPP = true;
        this.mIsFromCDN = true;
        this.dPQ = -1;
        this.dPS = false;
        this.mHasPerformedLongPress = false;
        this.dPT = null;
        this.dPU = false;
        this.dPX = false;
        this.mMaxWidth = -1;
        this.mMaxLines = -1;
        this.dPY = true;
        this.dPZ = false;
        this.isHost = false;
        this.dQa = false;
        this.dQb = false;
        this.dQc = false;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                String str2 = null;
                int i2 = -1;
                if (TbRichTextView.this.dNb != null && (view instanceof ImageView)) {
                    Object tag = view.getTag();
                    if (tag != null && (tag instanceof TbRichText)) {
                        int childCount = TbRichTextView.this.getChildCount();
                        for (int i3 = 0; i3 < childCount; i3++) {
                            i2++;
                            if (view.getParent() == TbRichTextView.this.getChildAt(i3)) {
                                break;
                            }
                        }
                        TbRichTextView.this.dNb.a(view, null, i2, TbRichTextView.this.isHost, false);
                        return;
                    }
                    if (tag != null && (tag instanceof String)) {
                        str2 = (String) tag;
                    } else if ((view instanceof TbImageView) && (view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextMemeInfo)) {
                        TbRichTextMemeInfo tbRichTextMemeInfo = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                        if (tbRichTextMemeInfo != null && tbRichTextMemeInfo.memeInfo != null) {
                            str = tbRichTextMemeInfo.memeInfo.pic_url;
                        } else {
                            str = "";
                        }
                        int childCount2 = TbRichTextView.this.getChildCount();
                        for (int i4 = 0; i4 < childCount2; i4++) {
                            i2++;
                            if (view.getParent() == TbRichTextView.this.getChildAt(i4)) {
                                break;
                            }
                        }
                        TbRichTextView.this.dNb.a(view, str, i2, TbRichTextView.this.isHost, false);
                        return;
                    } else if (view instanceof TbImageView) {
                        str2 = ((TbImageView) view).getUrl();
                    } else if (view instanceof GifView) {
                        str2 = ((GifView) view).getUrl();
                    }
                    int childCount3 = TbRichTextView.this.getChildCount();
                    for (int i5 = 0; i5 < childCount3; i5++) {
                        View childAt = TbRichTextView.this.getChildAt(i5);
                        if (TbRichTextView.this.bk(childAt)) {
                            i2++;
                        }
                        if (view == childAt) {
                            break;
                        }
                    }
                    TbRichTextView.this.dNb.a(view, str2, i2, TbRichTextView.this.isHost, false);
                }
            }
        };
        this.dIQ = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.6
            @Override // com.baidu.tieba.pb.a.c.a
            public boolean onDoubleTap(View view, MotionEvent motionEvent) {
                if (TbRichTextView.this.drk != null) {
                    TbRichTextView.this.drk.Q(view);
                    return TbRichTextView.this.drk.onDoubleTap(motionEvent);
                }
                return false;
            }

            @Override // com.baidu.tieba.pb.a.c.a
            public boolean onDoubleTapEvent(View view, MotionEvent motionEvent) {
                return false;
            }

            @Override // com.baidu.tieba.pb.a.c.a
            public boolean onSingleTapConfirmed(View view, MotionEvent motionEvent) {
                if (TbRichTextView.this.mOnClickListener != null) {
                    TbRichTextView.this.mOnClickListener.onClick(view);
                    return true;
                }
                return false;
            }
        });
        this.dQe = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                if (TbRichTextView.this.dPM != null && (view instanceof TbImageView)) {
                    Object tag = view.getTag();
                    if (tag == null || !(tag instanceof e)) {
                        str = null;
                    } else {
                        str = ((e) tag).url;
                    }
                    TbRichTextView.this.dPM.e(view, str);
                }
            }
        };
        this.dQf = new g() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.13
            @Override // com.baidu.tbadk.widget.richText.TbRichTextView.g
            public void x(MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    TbRichTextView.this.dQa = true;
                } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                    TbRichTextView.this.dQa = false;
                }
            }
        };
        this.mType = 19;
        this.cYN = new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i2) {
                TbRichTextView.this.h(aVar);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.b
            public void onProgressUpdate(Object... objArr) {
                super.onProgressUpdate(objArr);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.b
            public void onCancelled(String str) {
                super.onCancelled(str);
            }
        };
        this.dQi = new CustomMessageListener(CmdConfigCustom.PB_RICHTEXT_CHANGE_CMD) { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int contentSizeOfLzl = TbRichTextView.this.dPZ ? TbConfig.getContentSizeOfLzl() : TbConfig.getContentSize();
                if (TbRichTextView.this.dPW != null && !v.isEmpty(TbRichTextView.this.dPW.aTX())) {
                    Iterator<TbRichTextData> it = TbRichTextView.this.dPW.aTX().iterator();
                    while (it.hasNext()) {
                        TbRichTextData next = it.next();
                        if (next != null) {
                            next.aV(contentSizeOfLzl, contentSizeOfLzl);
                        }
                    }
                }
                TbRichTextView.this.setTextSize(contentSizeOfLzl);
            }
        };
        init();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.TbRichTextView);
        this.dMS.b(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        aUO();
    }

    public com.baidu.tbadk.widget.richText.a getLayoutStrategy() {
        return this.dMS;
    }

    public void setLayoutStrategy(com.baidu.tbadk.widget.richText.a aVar) {
        if (aVar != null) {
            this.dMS.release();
            this.dMS = aVar;
            aUO();
            if (this.OC != null) {
                this.OC.setLayoutStrategy(this.dMS);
            }
        }
    }

    private void aUO() {
        int contentSizeOfLzl = this.dPZ ? TbConfig.getContentSizeOfLzl() : TbConfig.getContentSize();
        this.dMS.dOk = contentSizeOfLzl;
        this.dMS.dOj = contentSizeOfLzl;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x004e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void init() {
        com.baidu.tbadk.widget.richText.h hVar;
        com.baidu.tbadk.widget.richText.h hVar2;
        com.baidu.adp.base.e<?> ab = com.baidu.adp.base.i.ab(getContext());
        if (getContext() instanceof com.baidu.tbadk.widget.richText.h) {
            hVar = (com.baidu.tbadk.widget.richText.h) getContext();
        } else if (ab == null || !(ab.getOrignalPage() instanceof com.baidu.tbadk.widget.richText.h)) {
            hVar = null;
        } else {
            hVar = (com.baidu.tbadk.widget.richText.h) ab.getOrignalPage();
        }
        if (hVar == null && (getContext() instanceof BaseFragmentActivity)) {
            List<Fragment> fragments = ((BaseFragmentActivity) getContext()).getSupportFragmentManager().getFragments();
            if (!v.isEmpty(fragments) && (fragments.get(0) instanceof com.baidu.tbadk.widget.richText.h)) {
                hVar2 = (com.baidu.tbadk.widget.richText.h) fragments.get(0);
                if (ab != null) {
                    ab.registerListener(this.dQi);
                }
                if (hVar2 != null) {
                    this.dMQ = hVar2.aUF();
                    this.dPF = hVar2.aUG();
                    this.dPG = hVar2.aUI();
                    this.dPH = hVar2.aUJ();
                    this.dMR = hVar2.aUH();
                    this.dPI = hVar2.aUK();
                    if (hVar2.getListView() != null && this.dPL == null) {
                        this.dPL = new k(hVar2.aUE());
                        hVar2.getListView().setRecyclerListener(this.dPL);
                    }
                }
                this.dMX = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10);
                setOrientation(1);
                setOnHierarchyChangeListener(new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.9
                    @Override // android.view.ViewGroup.OnHierarchyChangeListener
                    public void onChildViewRemoved(View view, View view2) {
                        if (view2 instanceof GifView) {
                            Object tag = view2.getTag(R.id.tag_rich_text_view_recycle);
                            if (!(tag instanceof d) || !((d) tag).dQn) {
                                if (TbRichTextView.this.dMR != null) {
                                    TbRichTextView.this.dMR.returnObject((GifView) view2);
                                }
                            } else {
                                if (TbRichTextView.this.dPE == null) {
                                    TbRichTextView.this.dPE = TbRichTextView.this.getRecycleImageViewPool();
                                }
                                TbRichTextView.this.dPE.returnObject((ImageView) view2);
                            }
                        } else if (view2 instanceof ImageView) {
                            Object tag2 = view2.getTag(R.id.tag_rich_text_view_recycle);
                            if (!(tag2 instanceof d) || !((d) tag2).dQn) {
                                if (TbRichTextView.this.dMQ != null) {
                                    TbRichTextView.this.dMQ.returnObject((ImageView) view2);
                                }
                            } else {
                                if (TbRichTextView.this.dPE == null) {
                                    TbRichTextView.this.dPE = TbRichTextView.this.getRecycleImageViewPool();
                                }
                                TbRichTextView.this.dPE.returnObject((ImageView) view2);
                            }
                        } else if ((view2 instanceof TextView) && TbRichTextView.this.dPF != null) {
                            TbRichTextView.this.dPF.returnObject((TextView) view2);
                        } else if ((view2 instanceof PlayVoiceBnt) && TbRichTextView.this.dPG != null) {
                            TbRichTextView.this.dPG.returnObject(view2);
                        } else if ((view2 instanceof PlayVoiceBntNew) && TbRichTextView.this.dPG != null) {
                            TbRichTextView.this.dPG.returnObject(view2);
                        } else if (view2 instanceof GridImageLayout) {
                            int childCount = ((GridImageLayout) view2).getChildCount();
                            for (int i2 = 0; i2 < childCount; i2++) {
                                View childAt = ((GridImageLayout) view2).getChildAt(i2);
                                if ((childAt instanceof GifView) && TbRichTextView.this.dMR != null) {
                                    TbRichTextView.this.dMR.returnObject((GifView) childAt);
                                } else if ((childAt instanceof ImageView) && TbRichTextView.this.dMQ != null) {
                                    TbRichTextView.this.dMQ.returnObject((ImageView) childAt);
                                }
                            }
                            ((GridImageLayout) view2).removeAllViews();
                            ((GridImageLayout) view2).clearData();
                        } else if ((view2 instanceof RelativeLayout) && TbRichTextView.this.dPI != null) {
                            TbRichTextView.this.dPI.returnObject((RelativeLayout) view2);
                        }
                        if (view2 instanceof LinearLayout) {
                            Object tag3 = view2.getTag();
                            if (tag3 == null || !(tag3 instanceof String) || !"VideoView".equals(tag3)) {
                                if (TbRichTextView.this.dPH != null) {
                                    int childCount2 = ((LinearLayout) view2).getChildCount();
                                    for (int i3 = 0; i3 < childCount2; i3++) {
                                        View childAt2 = ((LinearLayout) view2).getChildAt(i3);
                                        if (childAt2 != null) {
                                            if ((childAt2 instanceof TextView) && TbRichTextView.this.dPF != null) {
                                                TbRichTextView.this.dPF.returnObject((TextView) childAt2);
                                            } else if ((childAt2 instanceof PlayVoiceBnt) && TbRichTextView.this.dPG != null) {
                                                TbRichTextView.this.dPG.returnObject(childAt2);
                                            } else if ((childAt2 instanceof PlayVoiceBntNew) && TbRichTextView.this.dPG != null) {
                                                TbRichTextView.this.dPG.returnObject(childAt2);
                                            }
                                        }
                                    }
                                    ((LinearLayout) view2).removeAllViews();
                                    TbRichTextView.this.dPH.returnObject((LinearLayout) view2);
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
        }
        hVar2 = hVar;
        if (ab != null) {
        }
        if (hVar2 != null) {
        }
        this.dMX = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10);
        setOrientation(1);
        setOnHierarchyChangeListener(new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.9
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if (view2 instanceof GifView) {
                    Object tag = view2.getTag(R.id.tag_rich_text_view_recycle);
                    if (!(tag instanceof d) || !((d) tag).dQn) {
                        if (TbRichTextView.this.dMR != null) {
                            TbRichTextView.this.dMR.returnObject((GifView) view2);
                        }
                    } else {
                        if (TbRichTextView.this.dPE == null) {
                            TbRichTextView.this.dPE = TbRichTextView.this.getRecycleImageViewPool();
                        }
                        TbRichTextView.this.dPE.returnObject((ImageView) view2);
                    }
                } else if (view2 instanceof ImageView) {
                    Object tag2 = view2.getTag(R.id.tag_rich_text_view_recycle);
                    if (!(tag2 instanceof d) || !((d) tag2).dQn) {
                        if (TbRichTextView.this.dMQ != null) {
                            TbRichTextView.this.dMQ.returnObject((ImageView) view2);
                        }
                    } else {
                        if (TbRichTextView.this.dPE == null) {
                            TbRichTextView.this.dPE = TbRichTextView.this.getRecycleImageViewPool();
                        }
                        TbRichTextView.this.dPE.returnObject((ImageView) view2);
                    }
                } else if ((view2 instanceof TextView) && TbRichTextView.this.dPF != null) {
                    TbRichTextView.this.dPF.returnObject((TextView) view2);
                } else if ((view2 instanceof PlayVoiceBnt) && TbRichTextView.this.dPG != null) {
                    TbRichTextView.this.dPG.returnObject(view2);
                } else if ((view2 instanceof PlayVoiceBntNew) && TbRichTextView.this.dPG != null) {
                    TbRichTextView.this.dPG.returnObject(view2);
                } else if (view2 instanceof GridImageLayout) {
                    int childCount = ((GridImageLayout) view2).getChildCount();
                    for (int i2 = 0; i2 < childCount; i2++) {
                        View childAt = ((GridImageLayout) view2).getChildAt(i2);
                        if ((childAt instanceof GifView) && TbRichTextView.this.dMR != null) {
                            TbRichTextView.this.dMR.returnObject((GifView) childAt);
                        } else if ((childAt instanceof ImageView) && TbRichTextView.this.dMQ != null) {
                            TbRichTextView.this.dMQ.returnObject((ImageView) childAt);
                        }
                    }
                    ((GridImageLayout) view2).removeAllViews();
                    ((GridImageLayout) view2).clearData();
                } else if ((view2 instanceof RelativeLayout) && TbRichTextView.this.dPI != null) {
                    TbRichTextView.this.dPI.returnObject((RelativeLayout) view2);
                }
                if (view2 instanceof LinearLayout) {
                    Object tag3 = view2.getTag();
                    if (tag3 == null || !(tag3 instanceof String) || !"VideoView".equals(tag3)) {
                        if (TbRichTextView.this.dPH != null) {
                            int childCount2 = ((LinearLayout) view2).getChildCount();
                            for (int i3 = 0; i3 < childCount2; i3++) {
                                View childAt2 = ((LinearLayout) view2).getChildAt(i3);
                                if (childAt2 != null) {
                                    if ((childAt2 instanceof TextView) && TbRichTextView.this.dPF != null) {
                                        TbRichTextView.this.dPF.returnObject((TextView) childAt2);
                                    } else if ((childAt2 instanceof PlayVoiceBnt) && TbRichTextView.this.dPG != null) {
                                        TbRichTextView.this.dPG.returnObject(childAt2);
                                    } else if ((childAt2 instanceof PlayVoiceBntNew) && TbRichTextView.this.dPG != null) {
                                        TbRichTextView.this.dPG.returnObject(childAt2);
                                    }
                                }
                            }
                            ((LinearLayout) view2).removeAllViews();
                            TbRichTextView.this.dPH.returnObject((LinearLayout) view2);
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
        setText(tbRichText, false);
    }

    public void setText(TbRichText tbRichText, boolean z) {
        setText(tbRichText, z, null);
    }

    public void setText(TbRichText tbRichText, boolean z, c cVar) {
        setText(tbRichText, z, cVar, false, false);
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:235:0x0038 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:236:0x0038 */
    public void setText(TbRichText tbRichText, boolean z, c cVar, boolean z2, boolean z3) {
        ArrayList<TbRichTextData> aTX;
        int i2;
        int i3;
        boolean z4;
        SpannableStringBuilder aUe;
        boolean z5;
        View view;
        boolean z6;
        ImageView ej;
        boolean z7;
        ImageView imageView;
        boolean z8;
        GifView gifView;
        boolean z9;
        GifView gifView2;
        View a2;
        boolean z10;
        int i4;
        if (this.dPW != tbRichText || (tbRichText != null && tbRichText.isChanged)) {
            if (tbRichText != null) {
                tbRichText.isChanged = false;
            }
            this.dPW = tbRichText;
            removeAllViews();
            if (tbRichText != null && (aTX = tbRichText.aTX()) != null) {
                View view2 = null;
                boolean z11 = true;
                Iterator<TbRichTextData> it = aTX.iterator();
                boolean z12 = false;
                int i5 = 0;
                int i6 = 0;
                View view3 = null;
                while (it.hasNext()) {
                    TbRichTextData next = it.next();
                    boolean z13 = false;
                    if (next != null) {
                        if (next.getType() == 1) {
                            TextView ek = ek(getContext());
                            boolean a3 = a(next, ek, true, cVar);
                            if (z && !this.dPU && (aUe = next.aUe()) != null) {
                                this.dPU = aUe.length() >= 200;
                            }
                            if (this.drk != null) {
                                ek.setOnTouchListener(this.dIQ);
                            } else {
                                ek.setOnClickListener(this.dPN);
                            }
                            z13 = a3;
                            i2 = i5;
                            i3 = i6;
                            view3 = ek;
                            z4 = z12;
                        } else if (next.getType() == 8) {
                            if (!this.dQb) {
                                if (i6 < 10) {
                                    i6++;
                                    if (next.aUd() != null) {
                                        if (TbadkCoreApplication.getInst().isGifAutoPlay() && !next.aUd().aUv()) {
                                            GifView gifView3 = null;
                                            if (!z3) {
                                                z8 = false;
                                                gifView = getGifView();
                                            } else {
                                                String aUr = next.aUd().aUr();
                                                if (StringUtils.isNull(aUr)) {
                                                    if (this.dMS.dOC) {
                                                        aUr = this.dMS.mIsFromCDN ? next.aUd().aUn() : next.aUd().aUp();
                                                    }
                                                    if (StringUtils.isNull(aUr)) {
                                                        aUr = this.dMS.mIsFromCDN ? next.aUd().aUq() : next.aUd().getSrc();
                                                    }
                                                }
                                                if (this.dPE != null) {
                                                    ImageView ak = this.dPE.ak(aUr);
                                                    if (ak instanceof GifView) {
                                                        gifView3 = (GifView) ak;
                                                    }
                                                }
                                                if (gifView3 == null) {
                                                    gifView2 = getGifView();
                                                    z9 = false;
                                                } else {
                                                    z9 = true;
                                                    gifView2 = gifView3;
                                                }
                                                z8 = z9;
                                                gifView = gifView2;
                                            }
                                            b bVar = new b();
                                            bVar.dQm = true;
                                            gifView.setTag(R.id.tag_rich_text_view_gif_view, bVar);
                                            z13 = a(next, gifView, z8);
                                            if (z2) {
                                                d dVar = new d();
                                                dVar.dQn = true;
                                                gifView.setTag(R.id.tag_rich_text_view_recycle, dVar);
                                            }
                                            z4 = z12;
                                            i2 = i5;
                                            i3 = i6;
                                            view3 = gifView;
                                        } else {
                                            ImageView imageView2 = null;
                                            if (!z3) {
                                                z6 = false;
                                                ej = ej(getContext());
                                            } else {
                                                String aUn = this.dMS.aTW() ? next.aUd().aUn() : next.aUd().aUq();
                                                if (this.dPE != null) {
                                                    imageView2 = this.dPE.ak(aUn);
                                                }
                                                if (imageView2 == null) {
                                                    imageView = ej(getContext());
                                                    z7 = false;
                                                } else {
                                                    z7 = true;
                                                    imageView = imageView2;
                                                }
                                                z6 = z7;
                                                ej = imageView;
                                            }
                                            z13 = a(next, ej, this.dMS.dOl, this.dMS.dOm, z6);
                                            if (z2) {
                                                d dVar2 = new d();
                                                dVar2.dQn = true;
                                                ej.setTag(R.id.tag_rich_text_view_recycle, dVar2);
                                            }
                                            z4 = z12;
                                            i2 = i5;
                                            i3 = i6;
                                            view3 = ej;
                                        }
                                    }
                                    z4 = z12;
                                    i2 = i5;
                                    i3 = i6;
                                    view3 = view3;
                                }
                            } else if (!z12) {
                                GridImageLayout gridImageView = getGridImageView();
                                gridImageView.setData(tbRichText.aTY());
                                z13 = true;
                                z4 = true;
                                i2 = i5;
                                i3 = i6;
                                view3 = gridImageView;
                            }
                        } else if (next.getType() == 32) {
                            com.baidu.tbadk.widget.richText.i aUh = next.aUh();
                            if (aUh != null && aUh.aUM()) {
                                a2 = b(aUh);
                            } else {
                                a2 = a(next);
                            }
                            z4 = z12;
                            i2 = i5;
                            i3 = i6;
                            view3 = a2;
                            z13 = true;
                        } else if (next.getType() == 512) {
                            view3 = bl(view2);
                            if (view3 != null) {
                                z13 = a(next, view3);
                                z4 = z12;
                                i2 = i5;
                                i3 = i6;
                                view3 = view3;
                            }
                        } else if (next.getType() == 768) {
                            View textVoiceView = getTextVoiceView();
                            z13 = a(next, (LinearLayout) textVoiceView, cVar);
                            z4 = z12;
                            i2 = i5;
                            i3 = i6;
                            view3 = textVoiceView;
                        } else if (next.getType() == 17) {
                            View gifView4 = getGifView();
                            z13 = a(next, (GifView) gifView4);
                            z4 = z12;
                            i2 = i5;
                            i3 = i6;
                            view3 = gifView4;
                        } else if (next.getType() == 20) {
                            if (i5 < 10) {
                                int i7 = i5 + 1;
                                if (next == null || next.aUj() == null || next.aUj().memeInfo == null || StringUtils.isNull(next.aUj().memeInfo.pic_url)) {
                                    z10 = false;
                                } else {
                                    z10 = true;
                                }
                                if (z10) {
                                    RelativeLayout borrowObject = this.dPI.borrowObject();
                                    borrowObject.removeAllViews();
                                    borrowObject.setLayoutParams(new LinearLayout.LayoutParams(next.aUj().memeInfo.width.intValue(), next.aUj().memeInfo.height.intValue()));
                                    if (DuiSwitch.getInOn() && this.dPJ) {
                                        b(borrowObject, next.aUj().memeInfo.width.intValue(), next.aUj().memeInfo.height.intValue(), this.dMS.dOl, this.dMS.dOm);
                                    } else {
                                        a(borrowObject, next.aUj().memeInfo.width.intValue(), next.aUj().memeInfo.height.intValue(), this.dMS.dOl, this.dMS.dOm);
                                    }
                                    ImageView borrowObject2 = this.dMQ.borrowObject();
                                    b(next, borrowObject2, this.dMS.dOl, this.dMS.dOm);
                                    if (DuiSwitch.getInOn() && this.dPJ) {
                                        ImageView borrowObject3 = this.dMQ.borrowObject();
                                        borrowObject3.setTag(this.dPW);
                                        if (borrowObject3 instanceof TbImageView) {
                                            TbImageView tbImageView = (TbImageView) borrowObject3;
                                            tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
                                            tbImageView.setBorderColor(am.getColor(R.color.cp_border_a));
                                            tbImageView.setBorderSurroundContent(true);
                                            tbImageView.setDrawCorner(true);
                                            tbImageView.setDrawBorder(true);
                                            tbImageView.setLongIconSupport(true);
                                            tbImageView.setGifIconSupport(true);
                                            tbImageView.setConrers(15);
                                            tbImageView.setRadius(this.dMX);
                                            tbImageView.setAdjustViewBounds(false);
                                            if (this.dQb) {
                                                tbImageView.setPlaceHolder(2);
                                            } else {
                                                tbImageView.setPlaceHolder(3);
                                            }
                                        }
                                        borrowObject3.setScaleType(ImageView.ScaleType.FIT_XY);
                                        int dimens = l.getDimens(getContext(), R.dimen.ds78);
                                        int dimens2 = l.getDimens(getContext(), R.dimen.ds78);
                                        borrowObject2.setId(R.id.meme_image_view);
                                        c(borrowObject2, next.aUj().memeInfo.width.intValue(), next.aUj().memeInfo.height.intValue(), this.dMS.dOl, this.dMS.dOm, this.mOnClickListener);
                                        borrowObject.addView(borrowObject2);
                                        if (dimens2 > next.aUj().memeInfo.height.intValue()) {
                                            i4 = dimens / 2;
                                            dimens2 /= 2;
                                        } else {
                                            i4 = dimens;
                                        }
                                        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i4, dimens2);
                                        layoutParams.addRule(8, R.id.meme_image_view);
                                        layoutParams.addRule(11);
                                        borrowObject3.setOnClickListener(this.mOnClickListener);
                                        if (borrowObject.getLeft() > 0) {
                                            layoutParams.rightMargin = l.getDimens(getContext(), R.dimen.ds6);
                                        }
                                        am.setImageResource(borrowObject3, R.drawable.icon_emotion_dui_n);
                                        borrowObject.addView(borrowObject3, layoutParams);
                                    } else {
                                        b(borrowObject2, next.aUj().memeInfo.width.intValue(), next.aUj().memeInfo.height.intValue(), this.dMS.dOl, this.dMS.dOm, this.mOnClickListener);
                                        borrowObject.addView(borrowObject2);
                                    }
                                    z13 = z10;
                                    i2 = i7;
                                    i3 = i6;
                                    view3 = borrowObject;
                                    z4 = z12;
                                } else {
                                    z13 = z10;
                                    z4 = z12;
                                    i2 = i7;
                                    i3 = i6;
                                    view3 = view3;
                                }
                            }
                        } else {
                            if (next.getType() == 1280) {
                                ImageView ej2 = ej(getContext());
                                z13 = a(next, ej2, (this.dMS.dOl - getPaddingLeft()) - getPaddingRight(), this.dMS.dOm);
                                z4 = z12;
                                i2 = i5;
                                i3 = i6 + 1;
                                view3 = ej2;
                            }
                            z4 = z12;
                            i2 = i5;
                            i3 = i6;
                            view3 = view3;
                        }
                        if (!z13 || view3 == null) {
                            z5 = z11;
                            view = view2;
                        } else {
                            addView(view3);
                            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) view3.getLayoutParams();
                            if (z11 && this.dMS.dOB >= 0) {
                                z11 = false;
                                if (layoutParams2 != null) {
                                    layoutParams2.topMargin = this.dMS.dOB;
                                    view3.setLayoutParams(layoutParams2);
                                    z5 = false;
                                    view = view3;
                                }
                                z5 = z11;
                                view = view3;
                            } else if (view3 instanceof TbListTextView) {
                                if ((view2 instanceof ImageView) || (view2 instanceof RelativeLayout)) {
                                    layoutParams2.topMargin = this.dMS.dOx;
                                } else {
                                    layoutParams2.topMargin = this.dMS.dOi;
                                }
                                view3.setLayoutParams(layoutParams2);
                                z5 = z11;
                                view = view3;
                            } else {
                                if (((view3 instanceof ImageView) || (view3 instanceof RelativeLayout)) && (next.getType() == 8 || next.getType() == 20 || next.getType() == 17)) {
                                    if (view2 instanceof TbListTextView) {
                                        layoutParams2.topMargin = this.dMS.dOv;
                                    } else if ((view2 instanceof ImageView) || (view3 instanceof RelativeLayout)) {
                                        layoutParams2.topMargin = this.dMS.dOu;
                                    } else {
                                        layoutParams2.topMargin = this.dMS.dOi;
                                    }
                                    view3.setLayoutParams(layoutParams2);
                                }
                                z5 = z11;
                                view = view3;
                            }
                        }
                        z12 = z4;
                        z11 = z5;
                        i5 = i2;
                        i6 = i3;
                        view2 = view;
                    }
                }
                if (view2 instanceof TbListTextView) {
                    LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) view2.getLayoutParams();
                    layoutParams3.bottomMargin = this.dMS.dOA;
                    view2.setLayoutParams(layoutParams3);
                } else if (view2 != null && this.dMS.dOz >= 0) {
                    LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) view2.getLayoutParams();
                    layoutParams4.bottomMargin = this.dMS.dOz;
                    view2.setLayoutParams(layoutParams4);
                }
                if (!z2 && this.dPE != null) {
                    this.dPE.clear();
                }
            }
        }
    }

    private GridImageLayout getGridImageView() {
        if (this.OC == null || this.OC.getParent() != null) {
            this.OC = new GridImageLayout(getContext());
            this.OC.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        }
        this.OC.setLayoutStrategy(this.dMS);
        this.OC.setObjectPool(this.dMQ, this.dMR);
        this.OC.setOnImageClickListener(this.dNb);
        if (this.dPO != null) {
            this.OC.setOnClickListener(this.dPO);
        }
        this.OC.setIsHost(this.isHost);
        if (this.dQc) {
            this.OC.setOnLongClickListener(this.onLongClickListener);
        }
        return this.OC;
    }

    public void setCommonTextViewOnClickListener(View.OnClickListener onClickListener) {
        this.dPN = onClickListener;
    }

    private View b(final com.baidu.tbadk.widget.richText.i iVar) {
        if (iVar == null || !iVar.isAvaliable()) {
            return null;
        }
        ImageView borrowObject = this.dMQ.borrowObject();
        if (borrowObject instanceof ForeDrawableImageView) {
            ForeDrawableImageView foreDrawableImageView = (ForeDrawableImageView) borrowObject;
            foreDrawableImageView.setForegroundDrawable(R.drawable.icon_play_video);
            foreDrawableImageView.setNoImageBottomTextColor(R.color.cp_cont_c);
            foreDrawableImageView.setNoImageBottomTextPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds32));
            foreDrawableImageView.setNoImageBottomTextSize(TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.fontsize28));
            foreDrawableImageView.setNoImageBottomText("点击播放视频");
            foreDrawableImageView.setInterceptOnClick(false);
            foreDrawableImageView.setTag("VideoView");
            b(foreDrawableImageView, iVar.getWidth(), iVar.getHeight(), (this.dMS.dOl - getPaddingLeft()) - getPaddingRight(), this.dMS.dOm, new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.10
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(TbadkCoreStatisticKey.KEY_RICH_TEXT_VIDEO_CLICK);
                    XiaoyingUtil.startPlayXiaoyingVideo(TbRichTextView.this.getContext(), iVar.getVideoUrl(), iVar.getWidth(), iVar.getHeight(), iVar.getThumbUrl());
                }
            });
            foreDrawableImageView.setDefaultResource(0);
            foreDrawableImageView.setSupportNoImage(this.dMS.dOs);
            if (com.baidu.tbadk.core.i.azR().isShowImages()) {
                foreDrawableImageView.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            } else {
                foreDrawableImageView.setDefaultBgResource(R.color.cp_bg_line_c);
            }
            foreDrawableImageView.startLoad(iVar.getThumbUrl(), 17, false);
            return borrowObject;
        }
        return borrowObject;
    }

    private boolean a(ImageView imageView, int i2, int i3, int i4, int i5, View.OnClickListener onClickListener) {
        int[] u = this.dMS.u(i2, i3, i4, i5);
        if (u == null) {
            return false;
        }
        int i6 = u[0];
        int i7 = u[1];
        if (imageView instanceof TbImageView) {
            TbImageView tbImageView = (TbImageView) imageView;
            if (tbImageView.getGifIconWidth() >= i6 || tbImageView.getGifIconHeight() >= i7) {
                tbImageView.setGifIconSupport(false);
            } else {
                tbImageView.setGifIconSupport(true);
            }
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i6, i7);
        if (this.dMS.dOt) {
            imageView.setScaleType(this.dMS.dOr);
            if (imageView instanceof TbImageView) {
                ((TbImageView) imageView).setOnDrawListener(this.dMS.NU);
            }
        } else {
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        }
        imageView.setClickable(true);
        imageView.setFocusable(false);
        if (this.drk != null && (imageView instanceof TbImageView)) {
            ((TbImageView) imageView).setTbGestureDetector(this.dIQ);
            imageView.setClickable(true);
        } else {
            imageView.setOnClickListener(onClickListener);
        }
        imageView.setLayoutParams(layoutParams);
        if (imageView instanceof TbImageView) {
            if (this.onLongClickListener != null) {
                ((TbImageView) imageView).setDispatchTouchListener(this.dQf);
                imageView.setOnLongClickListener(this.onLongClickListener);
            }
        } else if ((imageView instanceof GifView) && this.onLongClickListener != null) {
            ((GifView) imageView).setDispatchTouchListener(this.dQf);
            imageView.setOnLongClickListener(this.onLongClickListener);
        }
        return true;
    }

    private boolean b(ImageView imageView, int i2, int i3, int i4, int i5, View.OnClickListener onClickListener) {
        int i6;
        int[] imageResize = l.getImageResize(i2, i3, i4, i5);
        if (imageResize == null) {
            return false;
        }
        int[] iArr = {imageResize[0], imageResize[1]};
        int i7 = iArr[0];
        int i8 = iArr[1];
        if (!this.dMS.dOt || i4 <= i7 || dOf <= 1.0f) {
            i4 = i7;
            i6 = i8;
        } else {
            if (i7 * dOf <= i4) {
                if (i7 * dOf > i4 * 0.68f) {
                    i4 = (int) (i4 * 0.68f);
                } else {
                    i4 = (int) (i7 * dOf);
                }
            }
            i6 = iArr[0] > 0 ? (iArr[1] * i4) / iArr[0] : i8;
        }
        if (imageView instanceof TbImageView) {
            TbImageView tbImageView = (TbImageView) imageView;
            tbImageView.setDefaultResource(this.dMS.dOn);
            if (tbImageView.getGifIconWidth() >= i4 || tbImageView.getGifIconHeight() >= i6) {
                tbImageView.setGifIconSupport(false);
            } else {
                tbImageView.setGifIconSupport(true);
            }
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i4, i6);
        if (this.dMS.dOt) {
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        } else {
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        }
        imageView.setClickable(true);
        imageView.setFocusable(false);
        if (this.drk != null && (imageView instanceof TbImageView)) {
            ((TbImageView) imageView).setTbGestureDetector(this.dIQ);
            imageView.setClickable(true);
        } else {
            imageView.setOnClickListener(onClickListener);
        }
        imageView.setLayoutParams(layoutParams);
        if (imageView instanceof TbImageView) {
            if (this.onLongClickListener != null) {
                ((TbImageView) imageView).setDispatchTouchListener(this.dQf);
                imageView.setOnLongClickListener(this.onLongClickListener);
            }
        } else if ((imageView instanceof GifView) && this.onLongClickListener != null) {
            imageView.setOnLongClickListener(this.onLongClickListener);
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00e8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean c(ImageView imageView, int i2, int i3, int i4, int i5, View.OnClickListener onClickListener) {
        int i6;
        int i7;
        int[] imageResize = l.getImageResize(i2, i3, i4, i5);
        if (imageResize == null) {
            return false;
        }
        int[] iArr = {imageResize[0], imageResize[1]};
        int i8 = iArr[0];
        int i9 = iArr[1];
        if (this.dMS.dOt && i4 > i8 && dOf > 1.0f) {
            if (i8 * dOf > i4) {
                i8 = (i4 - l.getDimens(getContext(), R.dimen.ds78)) - l.getDimens(getContext(), R.dimen.ds16);
            } else if (i8 * dOf > i4 * 0.68f) {
                i8 = ((int) (i4 * 0.68f)) - l.getDimens(getContext(), R.dimen.ds78);
            } else {
                i8 = (int) (i8 * dOf);
            }
            if (iArr[0] > 0) {
                i6 = (iArr[1] * i8) / iArr[0];
                i7 = i8;
                if (imageView instanceof TbImageView) {
                    TbImageView tbImageView = (TbImageView) imageView;
                    tbImageView.setDefaultResource(this.dMS.dOn);
                    if (tbImageView.getGifIconWidth() >= i7 || tbImageView.getGifIconHeight() >= i6) {
                        tbImageView.setGifIconSupport(false);
                    } else {
                        tbImageView.setGifIconSupport(true);
                    }
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i7, i6);
                if (!this.dMS.dOt) {
                    imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                } else {
                    imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                }
                imageView.setClickable(true);
                imageView.setFocusable(false);
                if (this.drk == null && (imageView instanceof TbImageView)) {
                    ((TbImageView) imageView).setTbGestureDetector(this.dIQ);
                    imageView.setClickable(true);
                } else {
                    imageView.setOnClickListener(onClickListener);
                }
                imageView.setLayoutParams(layoutParams);
                if (!(imageView instanceof TbImageView)) {
                    if (this.onLongClickListener != null) {
                        ((TbImageView) imageView).setDispatchTouchListener(this.dQf);
                        imageView.setOnLongClickListener(this.onLongClickListener);
                    }
                } else if ((imageView instanceof GifView) && this.onLongClickListener != null) {
                    imageView.setOnLongClickListener(this.onLongClickListener);
                }
                return true;
            }
        }
        i6 = i9;
        i7 = i8;
        if (imageView instanceof TbImageView) {
        }
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(i7, i6);
        if (!this.dMS.dOt) {
        }
        imageView.setClickable(true);
        imageView.setFocusable(false);
        if (this.drk == null) {
        }
        imageView.setOnClickListener(onClickListener);
        imageView.setLayoutParams(layoutParams2);
        if (!(imageView instanceof TbImageView)) {
        }
        return true;
    }

    private void a(RelativeLayout relativeLayout, int i2, int i3, int i4, int i5) {
        int[] imageResize = l.getImageResize(i2, i3, i4, i5);
        if (imageResize != null) {
            int[] iArr = {imageResize[0], imageResize[1]};
            int i6 = iArr[0];
            int i7 = iArr[1];
            if (!this.dMS.dOt || i4 <= i6 || dOf <= 1.0f) {
                i4 = i6;
            } else {
                if (i6 * dOf <= i4) {
                    if (i6 * dOf > i4 * 0.68f) {
                        i4 = (int) (i4 * 0.68f);
                    } else {
                        i4 = (int) (i6 * dOf);
                    }
                }
                if (iArr[0] > 0) {
                    i7 = (iArr[1] * i4) / iArr[0];
                }
            }
            relativeLayout.setLayoutParams(new LinearLayout.LayoutParams(i4, i7));
        }
    }

    private void b(RelativeLayout relativeLayout, int i2, int i3, int i4, int i5) {
        int i6;
        int i7;
        int[] imageResize = l.getImageResize(i2, i3, i4, i5);
        if (imageResize != null) {
            int[] iArr = {imageResize[0], imageResize[1]};
            int i8 = iArr[0];
            int i9 = iArr[1];
            if (this.dMS.dOt && i4 > i8 && dOf > 1.0f) {
                if (i8 * dOf > i4) {
                    i7 = (i4 - l.getDimens(getContext(), R.dimen.ds78)) - l.getDimens(getContext(), R.dimen.ds16);
                } else if (i8 * dOf > i4 * 0.68f) {
                    i7 = ((int) (i4 * 0.68f)) - l.getDimens(getContext(), R.dimen.ds78);
                } else {
                    i7 = (int) (i8 * dOf);
                }
                if (iArr[0] > 0) {
                    i6 = (i7 * iArr[1]) / iArr[0];
                    relativeLayout.setLayoutParams(new LinearLayout.LayoutParams(i4, i6));
                }
            }
            i6 = i9;
            relativeLayout.setLayoutParams(new LinearLayout.LayoutParams(i4, i6));
        }
    }

    private LinearLayout a(final TbRichTextData tbRichTextData) {
        if (this.dMS.dOo <= 0 || tbRichTextData == null) {
            return null;
        }
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setTag("VideoView");
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = this.dMS.dOi;
        linearLayout.setClickable(true);
        Bitmap bitmap = am.getBitmap(this.dMS.dOo);
        if (bitmap != null) {
            linearLayout.setBackgroundDrawable(new BitmapDrawable(getContext().getResources(), bitmap));
        }
        linearLayout.setFocusable(false);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (tbRichTextData.aUe() != null) {
                    if (TbRichTextView.this.getContext() instanceof com.baidu.tbadk.widget.richText.h) {
                        ((com.baidu.tbadk.widget.richText.h) TbRichTextView.this.getContext()).aD(TbRichTextView.this.getContext(), tbRichTextData.aUe().toString());
                        return;
                    }
                    com.baidu.adp.base.e<?> ab = com.baidu.adp.base.i.ab(TbRichTextView.this.getContext());
                    if (ab != null && (ab.getOrignalPage() instanceof com.baidu.tbadk.widget.richText.h)) {
                        ((com.baidu.tbadk.widget.richText.h) ab.getOrignalPage()).aD(TbRichTextView.this.getContext(), tbRichTextData.aUe().toString());
                    }
                }
            }
        });
        return linearLayout;
    }

    private ImageView ej(Context context) {
        ImageView borrowObject = this.dMQ != null ? this.dMQ.borrowObject() : null;
        if (borrowObject == null || borrowObject.getParent() != null) {
            borrowObject = null;
        }
        if (borrowObject != null) {
            borrowObject.setContentDescription(context.getString(R.string.editor_image));
        }
        return borrowObject;
    }

    private boolean a(TbRichTextData tbRichTextData, ImageView imageView, int i2, int i3) {
        if (tbRichTextData == null || imageView == null) {
            return false;
        }
        TbRichTextLinkImageInfo aUl = tbRichTextData.aUl();
        if (aUl != null && aUl.getLink() != null) {
            if (imageView instanceof TbImageView) {
                TbImageView tbImageView = (TbImageView) imageView;
                if (this.dMS.dOs) {
                    tbImageView.setSupportNoImage(true);
                }
                tbImageView.startLoad(aUl.aUD(), this.mIsFromCDN ? 17 : 18, false);
                tbImageView.setTag(new e(aUl.getLink()));
                if (!aUl.aUs()) {
                    tbImageView.setAdjustViewBounds(false);
                }
            }
            return b(imageView, aUl.getWidth(), aUl.getHeight(), i2, i3, this.dQe);
        }
        return false;
    }

    private boolean b(TbRichTextData tbRichTextData, ImageView imageView, int i2, int i3) {
        if (tbRichTextData == null || imageView == null) {
            return false;
        }
        if (tbRichTextData.aUj() == null) {
            return false;
        }
        if (imageView instanceof TbImageView) {
            TbImageView tbImageView = (TbImageView) imageView;
            tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
            tbImageView.setBorderColor(am.getColor(R.color.cp_border_a));
            tbImageView.setBorderSurroundContent(true);
            tbImageView.setDrawCorner(true);
            tbImageView.setDrawBorder(true);
            tbImageView.setLongIconSupport(true);
            tbImageView.setGifIconSupport(true);
            tbImageView.setConrers(15);
            tbImageView.setRadius(this.dMX);
            if (this.dQb) {
                tbImageView.setPlaceHolder(2);
            } else {
                tbImageView.setPlaceHolder(3);
            }
            if (this.dMS.dOs) {
                tbImageView.setSupportNoImage(true);
            }
            tbImageView.startLoad(tbRichTextData.aUj().memeInfo.pic_url, this.mIsFromCDN ? 17 : 18, false);
            tbImageView.setAdjustViewBounds(false);
            tbImageView.setTag(R.id.tag_rich_text_meme_info, tbRichTextData.aUj());
        }
        return b(imageView, tbRichTextData.aUj().memeInfo.width.intValue(), tbRichTextData.aUj().memeInfo.height.intValue(), i2, i3, this.mOnClickListener);
    }

    private boolean a(TbRichTextData tbRichTextData, ImageView imageView, int i2, int i3, boolean z) {
        if (tbRichTextData == null || imageView == null) {
            return false;
        }
        if (tbRichTextData.aUd() == null) {
            return false;
        }
        if (imageView instanceof TbImageView) {
            TbImageView tbImageView = (TbImageView) imageView;
            tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
            tbImageView.setBorderColor(am.getColor(R.color.cp_border_a));
            tbImageView.setBorderSurroundContent(true);
            tbImageView.setDrawCorner(true);
            tbImageView.setDrawBorder(true);
            tbImageView.setLongIconSupport(true);
            tbImageView.setGifIconSupport(true);
            tbImageView.setConrers(15);
            tbImageView.setRadius(this.dMX);
            if (this.dQb) {
                tbImageView.setPlaceHolder(2);
            } else {
                tbImageView.setPlaceHolder(3);
            }
            if (this.dMS.dOs) {
                tbImageView.setSupportNoImage(true);
            }
            String aUn = this.dMS.aTW() ? tbRichTextData.aUd().aUn() : tbRichTextData.aUd().aUq();
            if (!z || tbImageView.getUrl() == null || !tbImageView.getUrl().equals(aUn)) {
                tbImageView.startLoad(aUn, this.mIsFromCDN ? 17 : 18, false);
            }
            if (!tbRichTextData.aUd().aUs()) {
                tbImageView.setAdjustViewBounds(false);
            }
            tbImageView.setTag(R.id.tag_rich_text_meme_info, null);
        }
        return a(imageView, tbRichTextData.aUd().getWidth(), tbRichTextData.aUd().getHeight(), i2, i3, this.mOnClickListener);
    }

    private TextView ek(Context context) {
        TextView textView = null;
        if (this.dPF != null) {
            textView = this.dPF.borrowObject();
        }
        if (textView == null || textView.getParent() != null) {
            textView = new TbListTextView(context);
        }
        textView.setPadding(this.dMS.deB, 0, this.dMS.deB, 0);
        return textView;
    }

    private boolean a(TbRichTextData tbRichTextData, TextView textView, boolean z, c cVar) {
        LinearLayout.LayoutParams layoutParams;
        if (z) {
            layoutParams = new LinearLayout.LayoutParams(-1, -2);
        } else {
            layoutParams = new LinearLayout.LayoutParams(-2, -2);
        }
        if (this.dPX) {
            layoutParams.gravity = 16;
            textView.setGravity(16);
        } else {
            layoutParams.topMargin = this.dMS.dOi;
        }
        textView.setLineSpacing(this.dMS.dOh, this.dMS.dOg);
        textView.setTextSize(0, this.dMS.mTextSize);
        textView.setTextColor(this.dMS.mTextColor);
        textView.setLinkTextColor(am.getColor(R.color.cp_link_tip_c));
        textView.setHighlightColor(getContext().getResources().getColor(R.color.transparent));
        textView.setSingleLine(this.dMS.dOp);
        if (this.dPK != null) {
            textView.setEllipsize(this.dPK);
        }
        if (this.mMaxWidth > 0) {
            textView.setMaxWidth(this.mMaxWidth);
        }
        if (this.mMaxLines > 0) {
            textView.setMaxLines(this.mMaxLines);
        }
        if (tbRichTextData == null) {
            return false;
        }
        SpannableStringBuilder aUe = tbRichTextData.aUe();
        if (aUe == null || aUe.length() <= 0) {
            return false;
        }
        if (this.dMS.dOk > 0 && this.dMS.dOj > 0) {
            tbRichTextData.aV(this.dMS.dOj, this.dMS.dOk);
        }
        if (cVar != null) {
            cVar.a(aUe, textView, this);
        }
        try {
            textView.setText(aUe);
        } catch (Exception e2) {
            textView.setText("");
        }
        if (this.dPY) {
            if (tbRichTextData.aUm()) {
                textView.setMovementMethod(com.baidu.tieba.view.c.cTP());
            } else {
                textView.setMovementMethod(LinkMovementMethod.getInstance());
            }
        }
        textView.setFocusable(false);
        textView.setLayoutParams(layoutParams);
        textView.setTag(tbRichTextData);
        if (tbRichTextData != null && tbRichTextData.aUg() != null) {
            tbRichTextData.aUg().needRecompute = this.dQg;
        }
        return true;
    }

    private GifView getGifView() {
        GifView gifView = null;
        if (this.dMR != null) {
            gifView = this.dMR.borrowObject();
        }
        GifView gifView2 = (gifView == null || gifView.getParent() != null) ? new GifView(getContext()) : gifView;
        gifView2.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        gifView2.setBorderColor(am.getColor(R.color.cp_border_a));
        gifView2.setBorderSurroundContent(true);
        gifView2.setDrawCorner(true);
        gifView2.setDrawBorder(true);
        gifView2.setConrers(15);
        gifView2.setDrawBorder(true);
        gifView2.setRadius(this.dMX);
        if (this.dQb) {
            gifView2.setPlaceHolder(2);
        } else {
            gifView2.setPlaceHolder(3);
        }
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
        if (layoutParams == null || layoutParams.width != tbRichTextData.aUi().mGifInfo.mGifWidth || layoutParams.height != tbRichTextData.aUi().mGifInfo.mGifHeight) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(tbRichTextData.aUi().mGifInfo.mGifWidth, tbRichTextData.aUi().mGifInfo.mGifHeight);
            layoutParams2.gravity = 3;
            gifView.setLayoutParams(layoutParams2);
        } else {
            layoutParams.bottomMargin = 0;
        }
        gifView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (TbRichTextView.this.dPV != null) {
                    TbRichTextEmotionInfo aUi = tbRichTextData.aUi();
                    TbRichTextView.this.dPV.a(view, aUi.mGifInfo.mGid, aUi.mGifInfo.mPackageName, aUi.mGifInfo.mIcon, aUi.mGifInfo.mStaticUrl, aUi.mGifInfo.mDynamicUrl, aUi.mGifInfo.mSharpText, aUi.mGifInfo.mGifWidth, aUi.mGifInfo.mGifHeight);
                }
            }
        });
        gifView.a(tbRichTextData.aUi().mGifInfo);
        return true;
    }

    private boolean a(TbRichTextData tbRichTextData, GifView gifView, boolean z) {
        if (gifView == null) {
            return false;
        }
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            gifView.setDefaultNoImageDay(am.c(getContext().getResources(), R.drawable.icon_click));
        } else {
            gifView.setDefaultNoImageDay(R.drawable.icon_click);
        }
        Drawable drawable = am.getDrawable(R.color.cp_bg_line_j);
        if (drawable != null) {
            gifView.setBackgroundDrawable(drawable);
        } else {
            gifView.setBackgroundDrawable(am.getDrawable(R.color.common_color_10220));
        }
        String aUr = tbRichTextData.aUd().aUr();
        if (StringUtils.isNull(aUr)) {
            if (this.dMS.dOC) {
                aUr = this.dMS.mIsFromCDN ? tbRichTextData.aUd().aUn() : tbRichTextData.aUd().aUp();
            }
            if (StringUtils.isNull(aUr)) {
                aUr = this.dMS.mIsFromCDN ? tbRichTextData.aUd().aUq() : tbRichTextData.aUd().getSrc();
            }
        }
        gifView.setShowStaticDrawable(false);
        if (!z || gifView.getUrl() == null || !gifView.getUrl().equals(aUr)) {
            gifView.ae(aUr, 38);
        }
        return a(gifView, tbRichTextData.aUd().getWidth(), tbRichTextData.aUd().getHeight(), this.dMS.dOl, this.dMS.dOm, this.mOnClickListener);
    }

    private View bl(View view) {
        View borrowObject = this.dPG != null ? this.dPG.borrowObject() : null;
        if ((borrowObject == null || borrowObject.getParent() != null) && this.dPQ != -1) {
            borrowObject = LayoutInflater.from(getContext()).inflate(this.dPQ, (ViewGroup) null);
        }
        if (borrowObject != null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            if ((view instanceof TbListTextView) && this.dMS.dOw >= 0) {
                layoutParams.topMargin = this.dMS.dOw;
            } else {
                layoutParams.topMargin = this.dMS.dOi;
            }
            layoutParams.bottomMargin = this.dMS.dOy;
            borrowObject.setLayoutParams(layoutParams);
            if (borrowObject instanceof PlayVoiceBntNew) {
                ((PlayVoiceBntNew) borrowObject).setAfterClickListener(this.dPR);
                return borrowObject;
            }
            return borrowObject;
        }
        return null;
    }

    private boolean a(TbRichTextData tbRichTextData, View view) {
        view.setTag(tbRichTextData.aUf());
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LinearLayout.LayoutParams(-2, -2);
        }
        view.setLayoutParams(layoutParams);
        return true;
    }

    private View getTextVoiceView() {
        LinearLayout borrowObject = this.dPH.borrowObject();
        if (borrowObject != null) {
            TextView ek = ek(getContext());
            if (ek == null) {
                this.dPH.returnObject(borrowObject);
                return null;
            }
            borrowObject.addView(ek);
            View bl = bl(null);
            if (bl == null) {
                this.dPF.returnObject(ek);
                this.dPH.returnObject(borrowObject);
                return null;
            }
            borrowObject.addView(bl);
            return borrowObject;
        }
        return borrowObject;
    }

    private boolean a(TbRichTextData tbRichTextData, LinearLayout linearLayout, c cVar) {
        boolean a2;
        boolean z = true;
        if (linearLayout == null) {
            return false;
        }
        int childCount = linearLayout.getChildCount();
        int i2 = 0;
        while (i2 < childCount) {
            View childAt = linearLayout.getChildAt(i2);
            if (childAt == null) {
                a2 = z;
            } else if (childAt instanceof TextView) {
                a2 = a(tbRichTextData, (TextView) childAt, false, cVar) & z;
            } else if (childAt.getClass().getSimpleName().equals("PlayVoiceBnt")) {
                a2 = a(tbRichTextData, childAt) & z;
            } else {
                a2 = childAt.getClass().getSimpleName().equals("PlayVoiceBntNew") ? a(tbRichTextData, childAt) & z : z;
            }
            i2++;
            z = a2;
        }
        return z;
    }

    public void setTextSize(float f2) {
        if (f2 != this.dMS.mTextSize) {
            this.dMS.mTextSize = f2;
            this.dMS.dOj = (int) f2;
            this.dMS.dOk = (int) f2;
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (childAt instanceof TextView) {
                    ((TextView) childAt).setTextSize(0, f2);
                }
            }
        }
    }

    public void setTextColor(int i2) {
        if (i2 != this.dMS.mTextColor) {
            this.dMS.mTextColor = i2;
            int childCount = getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                if (childAt != null && (childAt instanceof TextView)) {
                    ((TextView) childAt).setTextColor(i2);
                }
            }
        }
    }

    public void setTextPadding(int i2) {
        if (this.dMS.deB != i2) {
            this.dMS.deB = i2;
            int childCount = getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                if (childAt != null && (childAt instanceof TextView)) {
                    ((TextView) childAt).setPadding(this.dMS.deB, 0, 0, this.dMS.deB);
                }
            }
        }
    }

    public void setLinkTextColor(int i2) {
        if (i2 != this.dMS.dOq) {
            this.dMS.dOq = i2;
            int childCount = getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                if (childAt != null && (childAt instanceof TextView)) {
                    ((TextView) childAt).setLinkTextColor(i2);
                }
            }
        }
    }

    public void setDuiEnabled(boolean z) {
        this.dPJ = z;
    }

    public i getOnImageClickListener() {
        return this.dNb;
    }

    public void setOnImageClickListener(i iVar) {
        this.dNb = iVar;
        if (this.OC != null) {
            this.OC.setOnImageClickListener(this.dNb);
        }
    }

    public void setOnImageTouchListener(com.baidu.tieba.pb.a.c cVar) {
        this.drk = cVar;
    }

    public void setOnEmotionClickListener(h hVar) {
        this.dPV = hVar;
    }

    public void setDisplayImage(boolean z, boolean z2) {
        if (this.dPP != z) {
            this.dPP = z;
            if (z2) {
                requestLayout();
            }
            if (!this.dPP && this.dMQ != null) {
                this.dMQ.clear();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class k implements AbsListView.RecyclerListener {
        private int mId;

        public k(int i) {
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
        this.dPS = false;
        switch (motionEvent.getAction()) {
            case 1:
            case 3:
                if (!this.mHasPerformedLongPress) {
                    aUQ();
                    break;
                }
                break;
        }
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        switch (motionEvent.getAction()) {
            case 0:
                if (!this.dPS) {
                    aUP();
                    break;
                }
                break;
        }
        return dispatchTouchEvent;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.mHasPerformedLongPress && (motionEvent.getAction() == 3 || motionEvent.getAction() == 1)) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.dPS = true;
        return super.onTouchEvent(motionEvent);
    }

    private void aUP() {
        this.mHasPerformedLongPress = false;
        if (this.dPT == null) {
            this.dPT = new a();
        }
        postDelayed(this.dPT, ViewConfiguration.getLongPressTimeout());
    }

    private void aUQ() {
        if (this.dPT != null) {
            removeCallbacks(this.dPT);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!TbRichTextView.this.dQa && TbRichTextView.this.performLongClick()) {
                TbRichTextView.this.mHasPerformedLongPress = true;
            }
        }
    }

    public void setVoiceViewRes(int i2) {
        this.dPQ = i2;
    }

    public void setOnVoiceAfterClickListener(View.OnClickListener onClickListener) {
        this.dPR = onClickListener;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.dQh != drawable) {
            this.dQg = true;
            this.dQh = drawable;
        }
        setText(this.dPW);
        this.dQg = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.dMS != null) {
            this.dMS.release();
        }
        stopLoad();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        stopLoad();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i2) {
        super.onWindowVisibilityChanged(i2);
        if (i2 == 8 || i2 == 4) {
            stopLoad();
        } else {
            refresh();
        }
    }

    public void a(String str, f fVar) {
        this.dQd = fVar;
        wi(str);
    }

    public void wi(String str) {
        BdUniqueId bdUniqueId;
        boolean z;
        if (TextUtils.isEmpty(str)) {
            this.mUrl = str;
            return;
        }
        getContext();
        com.baidu.adp.base.h Z = com.baidu.adp.base.i.Z(getContext());
        if (Z != null) {
            bdUniqueId = Z.getUniqueId();
            z = Z.isScroll();
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
        com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) com.baidu.adp.lib.e.c.gr().loadResourceFromMemery(this.mUrl, 19, new Object[0]);
        if (aVar != null) {
            h(aVar);
        } else if (z) {
            invalidate();
        } else if (!com.baidu.adp.lib.e.c.gr().T(19)) {
            invalidate();
        } else {
            com.baidu.adp.lib.e.c.gr().a(this.mUrl, 19, this.cYN, 0, 0, this.mPageId, new Object[0]);
        }
    }

    public void stopLoad() {
        if (!TextUtils.isEmpty(this.mUrl)) {
            com.baidu.adp.lib.e.c.gr().a(this.mUrl, 19, this.cYN);
            setBackgroundDrawable(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null) {
            try {
                NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(getResources(), aVar.getRawBitmap(), aVar.getRawBitmap().getNinePatchChunk(), aVar.getPadding(), null);
                if (TbadkCoreApplication.getInst().getSkinType() == 1 || TbadkCoreApplication.getInst().getSkinType() == 4) {
                    ninePatchDrawable.getPaint().setAlpha(80);
                }
                setBackgroundDrawable(ninePatchDrawable);
                if (this.dQd != null) {
                    this.dQd.aUT();
                }
            } catch (Exception e2) {
            }
        }
    }

    @Override // com.baidu.adp.newwidget.ImageView.h
    public void refresh() {
        wi(this.mUrl);
    }

    public void setTextViewOnClickListener(View.OnClickListener onClickListener) {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt instanceof TbListTextView) {
                ((TbListTextView) childAt).setOnClickListener(onClickListener);
            }
        }
    }

    public void setTextViewCheckSelection(boolean z) {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt instanceof TbListTextView) {
                ((TbListTextView) childAt).setCheckSelection(z);
            }
        }
    }

    public void setTextViewOnTouchListener(View.OnTouchListener onTouchListener) {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt instanceof TbListTextView) {
                ((TbListTextView) childAt).setOnTouchListener(onTouchListener);
            }
        }
    }

    public TextView getTextView() {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt instanceof TbListTextView) {
                return (TbListTextView) childAt;
            }
        }
        return null;
    }

    public j getOnLinkImageClickListener() {
        return this.dPM;
    }

    public void setOnLinkImageClickListener(j jVar) {
        this.dPM = jVar;
    }

    public void setHasMovementMethod(boolean z) {
        this.dPY = z;
    }

    public void setTextCenter(boolean z) {
        this.dPX = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        boolean dQm;

        private b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class d {
        boolean dQn;

        private d() {
        }
    }

    public com.baidu.tieba.pb.a<ImageView> getRecycleImageViewPool() {
        if (this.dPE == null) {
            this.dPE = new com.baidu.tieba.pb.a<ImageView>(new com.baidu.adp.lib.d.c<ImageView>() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: aUR */
                public ImageView makeObject() {
                    ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(com.baidu.adp.base.i.ab(TbRichTextView.this.getContext()).getPageActivity());
                    boolean isShowImages = com.baidu.tbadk.core.i.azR().isShowImages();
                    foreDrawableImageView.setDefaultBg(am.getDrawable(R.color.common_color_10220));
                    if (isShowImages) {
                        foreDrawableImageView.setAdjustViewBounds(false);
                        foreDrawableImageView.setInterceptOnClick(false);
                    } else {
                        foreDrawableImageView.setDefaultResource(R.drawable.icon_click);
                        foreDrawableImageView.setAdjustViewBounds(true);
                        foreDrawableImageView.setInterceptOnClick(true);
                    }
                    return foreDrawableImageView;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: a */
                public void destroyObject(ImageView imageView) {
                    imageView.setBackgroundDrawable(null);
                    imageView.setImageDrawable(null);
                    imageView.setTag(null);
                    imageView.setOnClickListener(null);
                    if (imageView instanceof ForeDrawableImageView) {
                        ForeDrawableImageView foreDrawableImageView = (ForeDrawableImageView) imageView;
                        ((ForeDrawableImageView) imageView).stopLoading();
                        foreDrawableImageView.setForegroundDrawable(0);
                        foreDrawableImageView.setDefaultBgResource(R.color.common_color_10220);
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: b */
                public ImageView activateObject(ImageView imageView) {
                    if (imageView instanceof TbImageView) {
                        TbImageView tbImageView = (TbImageView) imageView;
                        tbImageView.setTag(null);
                        if (com.baidu.tbadk.core.i.azR().isShowImages()) {
                            tbImageView.setAdjustViewBounds(false);
                            tbImageView.setInterceptOnClick(false);
                        } else {
                            tbImageView.setAdjustViewBounds(true);
                            tbImageView.setInterceptOnClick(true);
                        }
                    }
                    return imageView;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: c */
                public ImageView passivateObject(ImageView imageView) {
                    return imageView;
                }
            }, 10, 0) { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tieba.pb.a
                /* renamed from: aj */
                public ImageView ak(Object obj) {
                    ImageView imageView;
                    if (obj instanceof String) {
                        Iterator it = this._pool.iterator();
                        while (it.hasNext()) {
                            imageView = (ImageView) it.next();
                            if ((imageView instanceof TbImageView) && obj.equals(((TbImageView) imageView).getUrl())) {
                                break;
                            }
                        }
                    }
                    imageView = null;
                    this._pool.remove(imageView);
                    return imageView;
                }
            };
        }
        return this.dPE;
    }

    public TbRichText getRichText() {
        return this.dPW;
    }

    public void setmGridEmptyClickListener(View.OnClickListener onClickListener) {
        this.dPO = onClickListener;
    }
}
