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
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.ItemCardView;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tbadk.switchs.DuiSwitch;
import com.baidu.tbadk.widget.ForeDrawableImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.TbListTextView;
import com.baidu.tbadk.widget.layout.GridImageLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.a.c;
import com.baidu.tieba.tbadkCore.data.m;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBnt;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import tbclient.PbContent;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes2.dex */
public class TbRichTextView extends LinearLayout implements com.baidu.adp.newwidget.ImageView.i {
    private static final float fec = l.getEquipmentDensity(TbadkCoreApplication.getInst());
    private ItemCardView afA;
    private GridImageLayout akg;
    private com.baidu.tieba.pb.a.c eFf;
    private final com.baidu.tieba.pb.a.c eXz;
    private final com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a> eib;
    private com.baidu.adp.lib.d.b<ImageView> fcm;
    private com.baidu.adp.lib.d.b<GifView> fcn;
    private com.baidu.tbadk.widget.richText.a fco;
    private int fcu;
    private i fcy;
    private com.baidu.tieba.pb.a<ImageView> ffE;
    private com.baidu.adp.lib.d.b<TextView> ffF;
    private com.baidu.adp.lib.d.b<View> ffG;
    private com.baidu.adp.lib.d.b<LinearLayout> ffH;
    private com.baidu.adp.lib.d.b<RelativeLayout> ffI;
    private boolean ffJ;
    private TextUtils.TruncateAt ffK;
    private k ffL;
    private j ffM;
    private View.OnClickListener ffN;
    private View.OnClickListener ffO;
    private boolean ffP;
    private int ffQ;
    private View.OnClickListener ffR;
    private boolean ffS;
    private Runnable ffT;
    private boolean ffU;
    private h ffV;
    private TbRichText ffW;
    private boolean ffX;
    private boolean ffY;
    private boolean ffZ;
    private boolean fga;
    private boolean fgb;
    private boolean fgc;
    private f fgd;
    public final View.OnClickListener fge;
    private final g fgf;
    private boolean fgg;
    private Drawable fgh;
    private CustomMessageListener fgi;
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

    /* loaded from: classes2.dex */
    public interface c {
        void a(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView);
    }

    /* loaded from: classes2.dex */
    public interface f {
        void byw();
    }

    /* loaded from: classes2.dex */
    public interface g {
        void L(MotionEvent motionEvent);
    }

    /* loaded from: classes2.dex */
    public interface h {
        void a(View view, String str, String str2, String str3, String str4, String str5, String str6, int i, int i2);
    }

    /* loaded from: classes2.dex */
    public interface i {
        void a(View view, String str, int i, boolean z, boolean z2);
    }

    /* loaded from: classes2.dex */
    public interface j {
        void f(View view, String str);
    }

    public void setSubPbPost(boolean z) {
        this.ffZ = z;
        byr();
    }

    public void setIsHost(boolean z) {
        this.isHost = z;
        if (this.akg != null) {
            this.akg.setIsHost(z);
        }
    }

    public void setIsUseGridImage(boolean z) {
        this.fgb = z;
    }

    public void setmIsGridImageSupportLongPress(boolean z) {
        this.fgc = z;
    }

    public boolean byq() {
        return this.ffU;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
        if (this.fco != null) {
            this.fco.mIsFromCDN = z;
        }
    }

    public void setMaxWidth(int i2) {
        this.mMaxWidth = i2;
    }

    public void setMaxLines(int i2) {
        this.mMaxLines = i2;
    }

    public void setTextEllipsize(TextUtils.TruncateAt truncateAt) {
        this.ffK = truncateAt;
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
        super.setOnLongClickListener(onLongClickListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class e {
        public String url;

        public e(String str) {
            this.url = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bx(View view) {
        if (view instanceof ImageView) {
            if (view instanceof GifView) {
                return view.getTag(R.id.tag_rich_text_view_gif_view) != null && (view.getTag(R.id.tag_rich_text_view_gif_view) instanceof b) && ((b) view.getTag(R.id.tag_rich_text_view_gif_view)).fgm;
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

    public static com.baidu.adp.lib.d.b<TextView> y(final Context context, int i2) {
        return new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<TextView>() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: byv */
            public TextView makeObject() {
                return new TbListTextView(context);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: c */
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
            /* renamed from: d */
            public TextView activateObject(TextView textView) {
                return textView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: e */
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
        this.fco = new com.baidu.tbadk.widget.richText.a();
        this.ffE = null;
        this.fcm = null;
        this.ffF = null;
        this.ffG = null;
        this.ffH = null;
        this.ffI = null;
        this.fcn = null;
        this.ffJ = true;
        this.ffK = null;
        this.ffL = null;
        this.fcy = null;
        this.eFf = null;
        this.ffM = null;
        this.ffN = null;
        this.ffO = null;
        this.ffP = true;
        this.mIsFromCDN = true;
        this.ffQ = -1;
        this.ffS = false;
        this.mHasPerformedLongPress = false;
        this.ffT = null;
        this.ffU = false;
        this.ffX = false;
        this.mMaxWidth = -1;
        this.mMaxLines = -1;
        this.ffY = true;
        this.ffZ = false;
        this.isHost = false;
        this.fga = false;
        this.fgb = false;
        this.fgc = false;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                String str2 = null;
                int i2 = -1;
                if (TbRichTextView.this.fcy != null && (view instanceof ImageView)) {
                    Object tag = view.getTag();
                    if (tag != null && (tag instanceof TbRichText)) {
                        int childCount = TbRichTextView.this.getChildCount();
                        for (int i3 = 0; i3 < childCount; i3++) {
                            i2++;
                            if (view.getParent() == TbRichTextView.this.getChildAt(i3)) {
                                break;
                            }
                        }
                        TbRichTextView.this.fcy.a(view, null, i2, TbRichTextView.this.isHost, false);
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
                        TbRichTextView.this.fcy.a(view, str, i2, TbRichTextView.this.isHost, false);
                        return;
                    } else if (view instanceof TbImageView) {
                        str2 = ((TbImageView) view).getUrl();
                    } else if (view instanceof GifView) {
                        str2 = ((GifView) view).getUrl();
                    }
                    int childCount3 = TbRichTextView.this.getChildCount();
                    for (int i5 = 0; i5 < childCount3; i5++) {
                        View childAt = TbRichTextView.this.getChildAt(i5);
                        if (TbRichTextView.this.bx(childAt)) {
                            i2++;
                        }
                        if (view == childAt) {
                            break;
                        }
                    }
                    TbRichTextView.this.fcy.a(view, str2, i2, TbRichTextView.this.isHost, false);
                }
            }
        };
        this.eXz = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.7
            @Override // com.baidu.tieba.pb.a.c.a
            public boolean onDoubleTap(View view, MotionEvent motionEvent) {
                if (TbRichTextView.this.eFf != null) {
                    TbRichTextView.this.eFf.X(view);
                    return TbRichTextView.this.eFf.onDoubleTap(motionEvent);
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
        this.fge = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                if (TbRichTextView.this.ffM != null && (view instanceof TbImageView)) {
                    Object tag = view.getTag();
                    if (tag == null || !(tag instanceof e)) {
                        str = null;
                    } else {
                        str = ((e) tag).url;
                    }
                    TbRichTextView.this.ffM.f(view, str);
                }
            }
        };
        this.fgf = new g() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.2
            @Override // com.baidu.tbadk.widget.richText.TbRichTextView.g
            public void L(MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    TbRichTextView.this.fga = true;
                } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                    TbRichTextView.this.fga = false;
                }
            }
        };
        this.mType = 19;
        this.eib = new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.3
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
        this.fgi = new CustomMessageListener(CmdConfigCustom.PB_RICHTEXT_CHANGE_CMD) { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int contentSizeOfLzl = TbRichTextView.this.ffZ ? TbConfig.getContentSizeOfLzl() : TbConfig.getContentSize();
                if (TbRichTextView.this.ffW != null && !y.isEmpty(TbRichTextView.this.ffW.bxw())) {
                    Iterator<TbRichTextData> it = TbRichTextView.this.ffW.bxw().iterator();
                    while (it.hasNext()) {
                        TbRichTextData next = it.next();
                        if (next != null) {
                            next.bt(contentSizeOfLzl, contentSizeOfLzl);
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
        this.fco = new com.baidu.tbadk.widget.richText.a();
        this.ffE = null;
        this.fcm = null;
        this.ffF = null;
        this.ffG = null;
        this.ffH = null;
        this.ffI = null;
        this.fcn = null;
        this.ffJ = true;
        this.ffK = null;
        this.ffL = null;
        this.fcy = null;
        this.eFf = null;
        this.ffM = null;
        this.ffN = null;
        this.ffO = null;
        this.ffP = true;
        this.mIsFromCDN = true;
        this.ffQ = -1;
        this.ffS = false;
        this.mHasPerformedLongPress = false;
        this.ffT = null;
        this.ffU = false;
        this.ffX = false;
        this.mMaxWidth = -1;
        this.mMaxLines = -1;
        this.ffY = true;
        this.ffZ = false;
        this.isHost = false;
        this.fga = false;
        this.fgb = false;
        this.fgc = false;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                String str2 = null;
                int i2 = -1;
                if (TbRichTextView.this.fcy != null && (view instanceof ImageView)) {
                    Object tag = view.getTag();
                    if (tag != null && (tag instanceof TbRichText)) {
                        int childCount = TbRichTextView.this.getChildCount();
                        for (int i3 = 0; i3 < childCount; i3++) {
                            i2++;
                            if (view.getParent() == TbRichTextView.this.getChildAt(i3)) {
                                break;
                            }
                        }
                        TbRichTextView.this.fcy.a(view, null, i2, TbRichTextView.this.isHost, false);
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
                        TbRichTextView.this.fcy.a(view, str, i2, TbRichTextView.this.isHost, false);
                        return;
                    } else if (view instanceof TbImageView) {
                        str2 = ((TbImageView) view).getUrl();
                    } else if (view instanceof GifView) {
                        str2 = ((GifView) view).getUrl();
                    }
                    int childCount3 = TbRichTextView.this.getChildCount();
                    for (int i5 = 0; i5 < childCount3; i5++) {
                        View childAt = TbRichTextView.this.getChildAt(i5);
                        if (TbRichTextView.this.bx(childAt)) {
                            i2++;
                        }
                        if (view == childAt) {
                            break;
                        }
                    }
                    TbRichTextView.this.fcy.a(view, str2, i2, TbRichTextView.this.isHost, false);
                }
            }
        };
        this.eXz = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.7
            @Override // com.baidu.tieba.pb.a.c.a
            public boolean onDoubleTap(View view, MotionEvent motionEvent) {
                if (TbRichTextView.this.eFf != null) {
                    TbRichTextView.this.eFf.X(view);
                    return TbRichTextView.this.eFf.onDoubleTap(motionEvent);
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
        this.fge = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                if (TbRichTextView.this.ffM != null && (view instanceof TbImageView)) {
                    Object tag = view.getTag();
                    if (tag == null || !(tag instanceof e)) {
                        str = null;
                    } else {
                        str = ((e) tag).url;
                    }
                    TbRichTextView.this.ffM.f(view, str);
                }
            }
        };
        this.fgf = new g() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.2
            @Override // com.baidu.tbadk.widget.richText.TbRichTextView.g
            public void L(MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    TbRichTextView.this.fga = true;
                } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                    TbRichTextView.this.fga = false;
                }
            }
        };
        this.mType = 19;
        this.eib = new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.3
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
        this.fgi = new CustomMessageListener(CmdConfigCustom.PB_RICHTEXT_CHANGE_CMD) { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int contentSizeOfLzl = TbRichTextView.this.ffZ ? TbConfig.getContentSizeOfLzl() : TbConfig.getContentSize();
                if (TbRichTextView.this.ffW != null && !y.isEmpty(TbRichTextView.this.ffW.bxw())) {
                    Iterator<TbRichTextData> it = TbRichTextView.this.ffW.bxw().iterator();
                    while (it.hasNext()) {
                        TbRichTextData next = it.next();
                        if (next != null) {
                            next.bt(contentSizeOfLzl, contentSizeOfLzl);
                        }
                    }
                }
                TbRichTextView.this.setTextSize(contentSizeOfLzl);
            }
        };
        init();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.TbRichTextView);
        this.fco.b(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        byr();
    }

    public com.baidu.tbadk.widget.richText.a getLayoutStrategy() {
        return this.fco;
    }

    public void setLayoutStrategy(com.baidu.tbadk.widget.richText.a aVar) {
        if (aVar != null) {
            this.fco.release();
            this.fco = aVar;
            byr();
            if (this.akg != null) {
                this.akg.setLayoutStrategy(this.fco);
            }
        }
    }

    private void byr() {
        int contentSizeOfLzl = this.ffZ ? TbConfig.getContentSizeOfLzl() : TbConfig.getContentSize();
        this.fco.feh = contentSizeOfLzl;
        this.fco.feg = contentSizeOfLzl;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x004e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void init() {
        com.baidu.tbadk.widget.richText.i iVar;
        com.baidu.tbadk.widget.richText.i iVar2;
        com.baidu.adp.base.e<?> I = com.baidu.adp.base.i.I(getContext());
        if (getContext() instanceof com.baidu.tbadk.widget.richText.i) {
            iVar = (com.baidu.tbadk.widget.richText.i) getContext();
        } else if (I == null || !(I.getOrignalPage() instanceof com.baidu.tbadk.widget.richText.i)) {
            iVar = null;
        } else {
            iVar = (com.baidu.tbadk.widget.richText.i) I.getOrignalPage();
        }
        if (iVar == null && (getContext() instanceof BaseFragmentActivity)) {
            List<Fragment> fragments = ((BaseFragmentActivity) getContext()).getSupportFragmentManager().getFragments();
            if (!y.isEmpty(fragments) && (fragments.get(0) instanceof com.baidu.tbadk.widget.richText.i)) {
                iVar2 = (com.baidu.tbadk.widget.richText.i) fragments.get(0);
                if (I != null) {
                    I.registerListener(this.fgi);
                }
                if (iVar2 != null) {
                    this.fcm = iVar2.byi();
                    this.ffF = iVar2.byj();
                    this.ffG = iVar2.byl();
                    this.ffH = iVar2.bym();
                    this.fcn = iVar2.byk();
                    this.ffI = iVar2.byn();
                    if (iVar2.getListView() != null && this.ffL == null) {
                        this.ffL = new k(iVar2.byh());
                        iVar2.getListView().setRecyclerListener(this.ffL);
                    }
                }
                this.fcu = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10);
                setOrientation(1);
                setOnHierarchyChangeListener(new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.10
                    @Override // android.view.ViewGroup.OnHierarchyChangeListener
                    public void onChildViewRemoved(View view, View view2) {
                        if (view2 instanceof GifView) {
                            Object tag = view2.getTag(R.id.tag_rich_text_view_recycle);
                            if (!(tag instanceof d) || !((d) tag).fgn) {
                                if (TbRichTextView.this.fcn != null) {
                                    TbRichTextView.this.fcn.returnObject((GifView) view2);
                                }
                            } else {
                                if (TbRichTextView.this.ffE == null) {
                                    TbRichTextView.this.ffE = TbRichTextView.this.getRecycleImageViewPool();
                                }
                                TbRichTextView.this.ffE.returnObject((ImageView) view2);
                            }
                        } else if (view2 instanceof ImageView) {
                            Object tag2 = view2.getTag(R.id.tag_rich_text_view_recycle);
                            if (!(tag2 instanceof d) || !((d) tag2).fgn) {
                                if (TbRichTextView.this.fcm != null) {
                                    TbRichTextView.this.fcm.returnObject((ImageView) view2);
                                }
                            } else {
                                if (TbRichTextView.this.ffE == null) {
                                    TbRichTextView.this.ffE = TbRichTextView.this.getRecycleImageViewPool();
                                }
                                TbRichTextView.this.ffE.returnObject((ImageView) view2);
                            }
                        } else if ((view2 instanceof TextView) && TbRichTextView.this.ffF != null) {
                            TbRichTextView.this.ffF.returnObject((TextView) view2);
                        } else if ((view2 instanceof PlayVoiceBnt) && TbRichTextView.this.ffG != null) {
                            TbRichTextView.this.ffG.returnObject(view2);
                        } else if ((view2 instanceof PlayVoiceBntNew) && TbRichTextView.this.ffG != null) {
                            TbRichTextView.this.ffG.returnObject(view2);
                        } else if (view2 instanceof GridImageLayout) {
                            int childCount = ((GridImageLayout) view2).getChildCount();
                            for (int i2 = 0; i2 < childCount; i2++) {
                                View childAt = ((GridImageLayout) view2).getChildAt(i2);
                                if ((childAt instanceof GifView) && TbRichTextView.this.fcn != null) {
                                    TbRichTextView.this.fcn.returnObject((GifView) childAt);
                                } else if ((childAt instanceof ImageView) && TbRichTextView.this.fcm != null) {
                                    TbRichTextView.this.fcm.returnObject((ImageView) childAt);
                                }
                            }
                            ((GridImageLayout) view2).removeAllViews();
                            ((GridImageLayout) view2).clearData();
                        } else if ((view2 instanceof RelativeLayout) && TbRichTextView.this.ffI != null) {
                            TbRichTextView.this.ffI.returnObject((RelativeLayout) view2);
                        }
                        if (view2 instanceof LinearLayout) {
                            Object tag3 = view2.getTag();
                            if (tag3 == null || !(tag3 instanceof String) || !"VideoView".equals(tag3)) {
                                if (TbRichTextView.this.ffH != null) {
                                    int childCount2 = ((LinearLayout) view2).getChildCount();
                                    for (int i3 = 0; i3 < childCount2; i3++) {
                                        View childAt2 = ((LinearLayout) view2).getChildAt(i3);
                                        if (childAt2 != null) {
                                            if ((childAt2 instanceof TextView) && TbRichTextView.this.ffF != null) {
                                                TbRichTextView.this.ffF.returnObject((TextView) childAt2);
                                            } else if ((childAt2 instanceof PlayVoiceBnt) && TbRichTextView.this.ffG != null) {
                                                TbRichTextView.this.ffG.returnObject(childAt2);
                                            } else if ((childAt2 instanceof PlayVoiceBntNew) && TbRichTextView.this.ffG != null) {
                                                TbRichTextView.this.ffG.returnObject(childAt2);
                                            }
                                        }
                                    }
                                    ((LinearLayout) view2).removeAllViews();
                                    TbRichTextView.this.ffH.returnObject((LinearLayout) view2);
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
        iVar2 = iVar;
        if (I != null) {
        }
        if (iVar2 != null) {
        }
        this.fcu = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10);
        setOrientation(1);
        setOnHierarchyChangeListener(new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.10
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if (view2 instanceof GifView) {
                    Object tag = view2.getTag(R.id.tag_rich_text_view_recycle);
                    if (!(tag instanceof d) || !((d) tag).fgn) {
                        if (TbRichTextView.this.fcn != null) {
                            TbRichTextView.this.fcn.returnObject((GifView) view2);
                        }
                    } else {
                        if (TbRichTextView.this.ffE == null) {
                            TbRichTextView.this.ffE = TbRichTextView.this.getRecycleImageViewPool();
                        }
                        TbRichTextView.this.ffE.returnObject((ImageView) view2);
                    }
                } else if (view2 instanceof ImageView) {
                    Object tag2 = view2.getTag(R.id.tag_rich_text_view_recycle);
                    if (!(tag2 instanceof d) || !((d) tag2).fgn) {
                        if (TbRichTextView.this.fcm != null) {
                            TbRichTextView.this.fcm.returnObject((ImageView) view2);
                        }
                    } else {
                        if (TbRichTextView.this.ffE == null) {
                            TbRichTextView.this.ffE = TbRichTextView.this.getRecycleImageViewPool();
                        }
                        TbRichTextView.this.ffE.returnObject((ImageView) view2);
                    }
                } else if ((view2 instanceof TextView) && TbRichTextView.this.ffF != null) {
                    TbRichTextView.this.ffF.returnObject((TextView) view2);
                } else if ((view2 instanceof PlayVoiceBnt) && TbRichTextView.this.ffG != null) {
                    TbRichTextView.this.ffG.returnObject(view2);
                } else if ((view2 instanceof PlayVoiceBntNew) && TbRichTextView.this.ffG != null) {
                    TbRichTextView.this.ffG.returnObject(view2);
                } else if (view2 instanceof GridImageLayout) {
                    int childCount = ((GridImageLayout) view2).getChildCount();
                    for (int i2 = 0; i2 < childCount; i2++) {
                        View childAt = ((GridImageLayout) view2).getChildAt(i2);
                        if ((childAt instanceof GifView) && TbRichTextView.this.fcn != null) {
                            TbRichTextView.this.fcn.returnObject((GifView) childAt);
                        } else if ((childAt instanceof ImageView) && TbRichTextView.this.fcm != null) {
                            TbRichTextView.this.fcm.returnObject((ImageView) childAt);
                        }
                    }
                    ((GridImageLayout) view2).removeAllViews();
                    ((GridImageLayout) view2).clearData();
                } else if ((view2 instanceof RelativeLayout) && TbRichTextView.this.ffI != null) {
                    TbRichTextView.this.ffI.returnObject((RelativeLayout) view2);
                }
                if (view2 instanceof LinearLayout) {
                    Object tag3 = view2.getTag();
                    if (tag3 == null || !(tag3 instanceof String) || !"VideoView".equals(tag3)) {
                        if (TbRichTextView.this.ffH != null) {
                            int childCount2 = ((LinearLayout) view2).getChildCount();
                            for (int i3 = 0; i3 < childCount2; i3++) {
                                View childAt2 = ((LinearLayout) view2).getChildAt(i3);
                                if (childAt2 != null) {
                                    if ((childAt2 instanceof TextView) && TbRichTextView.this.ffF != null) {
                                        TbRichTextView.this.ffF.returnObject((TextView) childAt2);
                                    } else if ((childAt2 instanceof PlayVoiceBnt) && TbRichTextView.this.ffG != null) {
                                        TbRichTextView.this.ffG.returnObject(childAt2);
                                    } else if ((childAt2 instanceof PlayVoiceBntNew) && TbRichTextView.this.ffG != null) {
                                        TbRichTextView.this.ffG.returnObject(childAt2);
                                    }
                                }
                            }
                            ((LinearLayout) view2).removeAllViews();
                            TbRichTextView.this.ffH.returnObject((LinearLayout) view2);
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

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:242:0x0038 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:243:0x0038 */
    public void setText(TbRichText tbRichText, boolean z, c cVar, boolean z2, boolean z3) {
        ArrayList<TbRichTextData> bxw;
        int i2;
        int i3;
        boolean z4;
        SpannableStringBuilder bxD;
        boolean z5;
        View view;
        boolean z6;
        ImageView eq;
        boolean z7;
        ImageView imageView;
        boolean z8;
        GifView gifView;
        boolean z9;
        GifView gifView2;
        View a2;
        boolean z10;
        int i4;
        if (this.ffW != tbRichText || (tbRichText != null && tbRichText.isChanged)) {
            if (tbRichText != null) {
                tbRichText.isChanged = false;
            }
            this.ffW = tbRichText;
            removeAllViews();
            if (tbRichText != null && (bxw = tbRichText.bxw()) != null) {
                View view2 = null;
                boolean z11 = true;
                Iterator<TbRichTextData> it = bxw.iterator();
                boolean z12 = false;
                int i5 = 0;
                int i6 = 0;
                View view3 = null;
                while (it.hasNext()) {
                    TbRichTextData next = it.next();
                    boolean z13 = false;
                    if (next != null) {
                        if (next.getType() == 1) {
                            TextView er = er(getContext());
                            boolean a3 = a(next, er, true, cVar);
                            if (z && !this.ffU && (bxD = next.bxD()) != null) {
                                this.ffU = bxD.length() >= 200;
                            }
                            if (this.eFf != null) {
                                er.setOnTouchListener(this.eXz);
                            } else {
                                er.setOnClickListener(this.ffN);
                            }
                            z13 = a3;
                            i2 = i5;
                            i3 = i6;
                            view3 = er;
                            z4 = z12;
                        } else if (next.getType() == 8) {
                            if (!this.fgb) {
                                if (i6 < 10) {
                                    i6++;
                                    if (next.bxC() != null) {
                                        if (TbadkCoreApplication.getInst().isGifAutoPlay() && !next.bxC().bxX()) {
                                            GifView gifView3 = null;
                                            if (!z3) {
                                                z8 = false;
                                                gifView = getGifView();
                                            } else {
                                                String bxT = next.bxC().bxT();
                                                if (StringUtils.isNull(bxT)) {
                                                    if (this.fco.feA) {
                                                        bxT = this.fco.mIsFromCDN ? next.bxC().bxP() : next.bxC().bxR();
                                                    }
                                                    if (StringUtils.isNull(bxT)) {
                                                        bxT = this.fco.mIsFromCDN ? next.bxC().bxS() : next.bxC().getSrc();
                                                    }
                                                }
                                                if (this.ffE != null) {
                                                    ImageView as = this.ffE.as(bxT);
                                                    if (as instanceof GifView) {
                                                        gifView3 = (GifView) as;
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
                                            bVar.fgm = true;
                                            gifView.setTag(R.id.tag_rich_text_view_gif_view, bVar);
                                            z13 = a(next, gifView, z8);
                                            if (z2) {
                                                d dVar = new d();
                                                dVar.fgn = true;
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
                                                eq = eq(getContext());
                                            } else {
                                                String bxP = this.fco.bxv() ? next.bxC().bxP() : next.bxC().bxS();
                                                if (this.ffE != null) {
                                                    imageView2 = this.ffE.as(bxP);
                                                }
                                                if (imageView2 == null) {
                                                    imageView = eq(getContext());
                                                    z7 = false;
                                                } else {
                                                    z7 = true;
                                                    imageView = imageView2;
                                                }
                                                z6 = z7;
                                                eq = imageView;
                                            }
                                            z13 = a(next, eq, this.fco.fei, this.fco.fej, z6);
                                            if (z2) {
                                                d dVar2 = new d();
                                                dVar2.fgn = true;
                                                eq.setTag(R.id.tag_rich_text_view_recycle, dVar2);
                                            }
                                            z4 = z12;
                                            i2 = i5;
                                            i3 = i6;
                                            view3 = eq;
                                        }
                                    }
                                    z4 = z12;
                                    i2 = i5;
                                    i3 = i6;
                                    view3 = view3;
                                }
                            } else if (!z12) {
                                GridImageLayout gridImageView = getGridImageView();
                                gridImageView.setData(tbRichText.bxx());
                                z13 = true;
                                z4 = true;
                                i2 = i5;
                                i3 = i6;
                                view3 = gridImageView;
                            }
                        } else if (next.getType() == 32) {
                            com.baidu.tbadk.widget.richText.j bxG = next.bxG();
                            if (bxG != null && bxG.byp()) {
                                a2 = b(bxG);
                            } else {
                                a2 = a(next);
                            }
                            z4 = z12;
                            i2 = i5;
                            i3 = i6;
                            view3 = a2;
                            z13 = true;
                        } else if (next.getType() == 512) {
                            view3 = by(view2);
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
                                if (next == null || next.bxI() == null || next.bxI().memeInfo == null || StringUtils.isNull(next.bxI().memeInfo.pic_url)) {
                                    z10 = false;
                                } else {
                                    z10 = true;
                                }
                                if (z10) {
                                    RelativeLayout borrowObject = this.ffI.borrowObject();
                                    borrowObject.removeAllViews();
                                    borrowObject.setLayoutParams(new LinearLayout.LayoutParams(next.bxI().memeInfo.width.intValue(), next.bxI().memeInfo.height.intValue()));
                                    if (DuiSwitch.getInOn() && this.ffJ) {
                                        b(borrowObject, next.bxI().memeInfo.width.intValue(), next.bxI().memeInfo.height.intValue(), this.fco.fei, this.fco.fej);
                                    } else {
                                        a(borrowObject, next.bxI().memeInfo.width.intValue(), next.bxI().memeInfo.height.intValue(), this.fco.fei, this.fco.fej);
                                    }
                                    ImageView borrowObject2 = this.fcm.borrowObject();
                                    b(next, borrowObject2, this.fco.fei, this.fco.fej);
                                    if (DuiSwitch.getInOn() && this.ffJ) {
                                        ImageView borrowObject3 = this.fcm.borrowObject();
                                        borrowObject3.setTag(this.ffW);
                                        if (borrowObject3 instanceof TbImageView) {
                                            TbImageView tbImageView = (TbImageView) borrowObject3;
                                            tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
                                            tbImageView.setBorderColor(ap.getColor(R.color.cp_border_a));
                                            tbImageView.setBorderSurroundContent(true);
                                            tbImageView.setDrawCorner(true);
                                            tbImageView.setDrawBorder(true);
                                            tbImageView.setLongIconSupport(true);
                                            tbImageView.setGifIconSupport(true);
                                            tbImageView.setConrers(15);
                                            tbImageView.setRadius(this.fcu);
                                            tbImageView.setAdjustViewBounds(false);
                                            if (this.fgb) {
                                                tbImageView.setPlaceHolder(2);
                                            } else {
                                                tbImageView.setPlaceHolder(3);
                                            }
                                        }
                                        borrowObject3.setScaleType(ImageView.ScaleType.FIT_XY);
                                        int dimens = l.getDimens(getContext(), R.dimen.ds78);
                                        int dimens2 = l.getDimens(getContext(), R.dimen.ds78);
                                        borrowObject2.setId(R.id.meme_image_view);
                                        c(borrowObject2, next.bxI().memeInfo.width.intValue(), next.bxI().memeInfo.height.intValue(), this.fco.fei, this.fco.fej, this.mOnClickListener);
                                        borrowObject.addView(borrowObject2);
                                        if (dimens2 > next.bxI().memeInfo.height.intValue()) {
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
                                        ap.setImageResource(borrowObject3, R.drawable.icon_emotion_dui_n);
                                        borrowObject.addView(borrowObject3, layoutParams);
                                    } else {
                                        b(borrowObject2, next.bxI().memeInfo.width.intValue(), next.bxI().memeInfo.height.intValue(), this.fco.fei, this.fco.fej, this.mOnClickListener);
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
                        } else if (next.getType() == 1280) {
                            ImageView eq2 = eq(getContext());
                            z13 = a(next, eq2, (this.fco.fei - getPaddingLeft()) - getPaddingRight(), this.fco.fej);
                            z4 = z12;
                            i2 = i5;
                            i3 = i6 + 1;
                            view3 = eq2;
                        } else {
                            if (next.getType() == 1281) {
                                z13 = b(next);
                                z4 = z12;
                                i2 = i5;
                                i3 = i6;
                                view3 = this.afA;
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
                            if (z11 && this.fco.fey >= 0) {
                                z11 = false;
                                if (layoutParams2 != null) {
                                    layoutParams2.topMargin = this.fco.fey;
                                    view3.setLayoutParams(layoutParams2);
                                    z5 = false;
                                    view = view3;
                                }
                                z5 = z11;
                                view = view3;
                            } else {
                                if (view3 instanceof TbListTextView) {
                                    if ((view2 instanceof ImageView) || (view2 instanceof RelativeLayout)) {
                                        layoutParams2.topMargin = this.fco.feu;
                                    } else {
                                        layoutParams2.topMargin = this.fco.fef;
                                    }
                                    view3.setLayoutParams(layoutParams2);
                                    z5 = z11;
                                } else if (((view3 instanceof ImageView) || (view3 instanceof RelativeLayout)) && (next.getType() == 8 || next.getType() == 20 || next.getType() == 17)) {
                                    if (view2 instanceof TbListTextView) {
                                        layoutParams2.topMargin = this.fco.fes;
                                    } else if ((view2 instanceof ImageView) || (view3 instanceof RelativeLayout)) {
                                        layoutParams2.topMargin = this.fco.fer;
                                    } else {
                                        layoutParams2.topMargin = this.fco.fef;
                                    }
                                    view3.setLayoutParams(layoutParams2);
                                    z5 = z11;
                                } else {
                                    if ((view3 instanceof ItemCardView) && !z11) {
                                        layoutParams2.topMargin = this.fco.fez;
                                        view3.setLayoutParams(layoutParams2);
                                    }
                                    z5 = z11;
                                }
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
                    layoutParams3.bottomMargin = this.fco.fex;
                    view2.setLayoutParams(layoutParams3);
                } else if (view2 != null && this.fco.few >= 0) {
                    LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) view2.getLayoutParams();
                    layoutParams4.bottomMargin = this.fco.few;
                    view2.setLayoutParams(layoutParams4);
                }
                if (!z2 && this.ffE != null) {
                    this.ffE.clear();
                }
            }
        }
    }

    private GridImageLayout getGridImageView() {
        if (this.akg == null || this.akg.getParent() != null) {
            this.akg = new GridImageLayout(getContext());
            this.akg.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        }
        this.akg.setLayoutStrategy(this.fco);
        this.akg.setObjectPool(this.fcm, this.fcn);
        this.akg.setOnImageClickListener(this.fcy);
        if (this.ffO != null) {
            this.akg.setOnClickListener(this.ffO);
        }
        this.akg.setIsHost(this.isHost);
        if (this.fgc) {
            this.akg.setOnLongClickListener(this.onLongClickListener);
        }
        return this.akg;
    }

    public void setCommonTextViewOnClickListener(View.OnClickListener onClickListener) {
        this.ffN = onClickListener;
    }

    private View b(final com.baidu.tbadk.widget.richText.j jVar) {
        if (jVar == null || !jVar.isAvaliable()) {
            return null;
        }
        ImageView borrowObject = this.fcm.borrowObject();
        if (borrowObject instanceof ForeDrawableImageView) {
            ForeDrawableImageView foreDrawableImageView = (ForeDrawableImageView) borrowObject;
            foreDrawableImageView.setForegroundDrawable(R.drawable.icon_play_video);
            foreDrawableImageView.setNoImageBottomTextColor(R.color.cp_cont_c);
            foreDrawableImageView.setNoImageBottomTextPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds32));
            foreDrawableImageView.setNoImageBottomTextSize(TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.fontsize28));
            foreDrawableImageView.setNoImageBottomText("点击播放视频");
            foreDrawableImageView.setInterceptOnClick(false);
            foreDrawableImageView.setTag("VideoView");
            b(foreDrawableImageView, jVar.getWidth(), jVar.getHeight(), (this.fco.fei - getPaddingLeft()) - getPaddingRight(), this.fco.fej, new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.11
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(TbadkCoreStatisticKey.KEY_RICH_TEXT_VIDEO_CLICK);
                    XiaoyingUtil.startPlayXiaoyingVideo(TbRichTextView.this.getContext(), jVar.getVideoUrl(), jVar.getWidth(), jVar.getHeight(), jVar.getThumbUrl());
                }
            });
            foreDrawableImageView.setDefaultResource(0);
            foreDrawableImageView.setSupportNoImage(this.fco.fep);
            if (com.baidu.tbadk.core.k.bbM().isShowImages()) {
                foreDrawableImageView.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            } else {
                foreDrawableImageView.setDefaultBgResource(R.color.cp_bg_line_c);
            }
            foreDrawableImageView.startLoad(jVar.getThumbUrl(), 17, false);
            return borrowObject;
        }
        return borrowObject;
    }

    private boolean a(ImageView imageView, int i2, int i3, int i4, int i5, View.OnClickListener onClickListener) {
        int[] v = this.fco.v(i2, i3, i4, i5);
        if (v == null) {
            return false;
        }
        int i6 = v[0];
        int i7 = v[1];
        if (imageView instanceof TbImageView) {
            TbImageView tbImageView = (TbImageView) imageView;
            if (tbImageView.getGifIconWidth() >= i6 || tbImageView.getGifIconHeight() >= i7) {
                tbImageView.setGifIconSupport(false);
            } else {
                tbImageView.setGifIconSupport(true);
            }
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i6, i7);
        if (this.fco.feq) {
            imageView.setScaleType(this.fco.feo);
            if (imageView instanceof TbImageView) {
                ((TbImageView) imageView).setOnDrawListener(this.fco.ajz);
            }
        } else {
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        }
        imageView.setClickable(true);
        imageView.setFocusable(false);
        if (this.eFf != null && (imageView instanceof TbImageView)) {
            ((TbImageView) imageView).setTbGestureDetector(this.eXz);
            imageView.setClickable(true);
        } else {
            imageView.setOnClickListener(onClickListener);
        }
        imageView.setLayoutParams(layoutParams);
        if (imageView instanceof TbImageView) {
            if (this.onLongClickListener != null) {
                ((TbImageView) imageView).setDispatchTouchListener(this.fgf);
                imageView.setOnLongClickListener(this.onLongClickListener);
            }
        } else if ((imageView instanceof GifView) && this.onLongClickListener != null) {
            ((GifView) imageView).setDispatchTouchListener(this.fgf);
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
        if (!this.fco.feq || i4 <= i7 || fec <= 1.0f) {
            i4 = i7;
            i6 = i8;
        } else {
            if (i7 * fec <= i4) {
                if (i7 * fec > i4 * 0.68f) {
                    i4 = (int) (i4 * 0.68f);
                } else {
                    i4 = (int) (i7 * fec);
                }
            }
            i6 = iArr[0] > 0 ? (iArr[1] * i4) / iArr[0] : i8;
        }
        if (imageView instanceof TbImageView) {
            TbImageView tbImageView = (TbImageView) imageView;
            tbImageView.setDefaultResource(this.fco.fek);
            if (tbImageView.getGifIconWidth() >= i4 || tbImageView.getGifIconHeight() >= i6) {
                tbImageView.setGifIconSupport(false);
            } else {
                tbImageView.setGifIconSupport(true);
            }
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i4, i6);
        if (this.fco.feq) {
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        } else {
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        }
        imageView.setClickable(true);
        imageView.setFocusable(false);
        if (this.eFf != null && (imageView instanceof TbImageView)) {
            ((TbImageView) imageView).setTbGestureDetector(this.eXz);
            imageView.setClickable(true);
        } else {
            imageView.setOnClickListener(onClickListener);
        }
        imageView.setLayoutParams(layoutParams);
        if (imageView instanceof TbImageView) {
            if (this.onLongClickListener != null) {
                ((TbImageView) imageView).setDispatchTouchListener(this.fgf);
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
        if (this.fco.feq && i4 > i8 && fec > 1.0f) {
            if (i8 * fec > i4) {
                i8 = (i4 - l.getDimens(getContext(), R.dimen.ds78)) - l.getDimens(getContext(), R.dimen.ds16);
            } else if (i8 * fec > i4 * 0.68f) {
                i8 = ((int) (i4 * 0.68f)) - l.getDimens(getContext(), R.dimen.ds78);
            } else {
                i8 = (int) (i8 * fec);
            }
            if (iArr[0] > 0) {
                i6 = (iArr[1] * i8) / iArr[0];
                i7 = i8;
                if (imageView instanceof TbImageView) {
                    TbImageView tbImageView = (TbImageView) imageView;
                    tbImageView.setDefaultResource(this.fco.fek);
                    if (tbImageView.getGifIconWidth() >= i7 || tbImageView.getGifIconHeight() >= i6) {
                        tbImageView.setGifIconSupport(false);
                    } else {
                        tbImageView.setGifIconSupport(true);
                    }
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i7, i6);
                if (!this.fco.feq) {
                    imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                } else {
                    imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                }
                imageView.setClickable(true);
                imageView.setFocusable(false);
                if (this.eFf == null && (imageView instanceof TbImageView)) {
                    ((TbImageView) imageView).setTbGestureDetector(this.eXz);
                    imageView.setClickable(true);
                } else {
                    imageView.setOnClickListener(onClickListener);
                }
                imageView.setLayoutParams(layoutParams);
                if (!(imageView instanceof TbImageView)) {
                    if (this.onLongClickListener != null) {
                        ((TbImageView) imageView).setDispatchTouchListener(this.fgf);
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
        if (!this.fco.feq) {
        }
        imageView.setClickable(true);
        imageView.setFocusable(false);
        if (this.eFf == null) {
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
            if (!this.fco.feq || i4 <= i6 || fec <= 1.0f) {
                i4 = i6;
            } else {
                if (i6 * fec <= i4) {
                    if (i6 * fec > i4 * 0.68f) {
                        i4 = (int) (i4 * 0.68f);
                    } else {
                        i4 = (int) (i6 * fec);
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
            if (this.fco.feq && i4 > i8 && fec > 1.0f) {
                if (i8 * fec > i4) {
                    i7 = (i4 - l.getDimens(getContext(), R.dimen.ds78)) - l.getDimens(getContext(), R.dimen.ds16);
                } else if (i8 * fec > i4 * 0.68f) {
                    i7 = ((int) (i4 * 0.68f)) - l.getDimens(getContext(), R.dimen.ds78);
                } else {
                    i7 = (int) (i8 * fec);
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
        if (this.fco.fel <= 0 || tbRichTextData == null) {
            return null;
        }
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setTag("VideoView");
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = this.fco.fef;
        linearLayout.setClickable(true);
        Bitmap bitmap = ap.getBitmap(this.fco.fel);
        if (bitmap != null) {
            linearLayout.setBackgroundDrawable(new BitmapDrawable(getContext().getResources(), bitmap));
        }
        linearLayout.setFocusable(false);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (tbRichTextData.bxD() != null) {
                    if (TbRichTextView.this.getContext() instanceof com.baidu.tbadk.widget.richText.i) {
                        ((com.baidu.tbadk.widget.richText.i) TbRichTextView.this.getContext()).ar(TbRichTextView.this.getContext(), tbRichTextData.bxD().toString());
                        return;
                    }
                    com.baidu.adp.base.e<?> I = com.baidu.adp.base.i.I(TbRichTextView.this.getContext());
                    if (I != null && (I.getOrignalPage() instanceof com.baidu.tbadk.widget.richText.i)) {
                        ((com.baidu.tbadk.widget.richText.i) I.getOrignalPage()).ar(TbRichTextView.this.getContext(), tbRichTextData.bxD().toString());
                    }
                }
            }
        });
        return linearLayout;
    }

    private ImageView eq(Context context) {
        ImageView borrowObject = this.fcm != null ? this.fcm.borrowObject() : null;
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
        TbRichTextLinkImageInfo bxK = tbRichTextData.bxK();
        if (bxK != null && bxK.getLink() != null) {
            if (imageView instanceof TbImageView) {
                TbImageView tbImageView = (TbImageView) imageView;
                if (this.fco.fep) {
                    tbImageView.setSupportNoImage(true);
                }
                tbImageView.startLoad(bxK.byg(), this.mIsFromCDN ? 17 : 18, false);
                tbImageView.setTag(new e(bxK.getLink()));
                if (!bxK.bxU()) {
                    tbImageView.setAdjustViewBounds(false);
                }
            }
            return b(imageView, bxK.getWidth(), bxK.getHeight(), i2, i3, this.fge);
        }
        return false;
    }

    private boolean b(TbRichTextData tbRichTextData, ImageView imageView, int i2, int i3) {
        if (tbRichTextData == null || imageView == null) {
            return false;
        }
        if (tbRichTextData.bxI() == null) {
            return false;
        }
        if (imageView instanceof TbImageView) {
            TbImageView tbImageView = (TbImageView) imageView;
            tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
            tbImageView.setBorderColor(ap.getColor(R.color.cp_border_a));
            tbImageView.setBorderSurroundContent(true);
            tbImageView.setDrawCorner(true);
            tbImageView.setDrawBorder(true);
            tbImageView.setLongIconSupport(true);
            tbImageView.setGifIconSupport(true);
            tbImageView.setConrers(15);
            tbImageView.setRadius(this.fcu);
            if (this.fgb) {
                tbImageView.setPlaceHolder(2);
            } else {
                tbImageView.setPlaceHolder(3);
            }
            if (this.fco.fep) {
                tbImageView.setSupportNoImage(true);
            }
            tbImageView.startLoad(tbRichTextData.bxI().memeInfo.pic_url, this.mIsFromCDN ? 17 : 18, false);
            tbImageView.setAdjustViewBounds(false);
            tbImageView.setTag(R.id.tag_rich_text_meme_info, tbRichTextData.bxI());
        }
        return b(imageView, tbRichTextData.bxI().memeInfo.width.intValue(), tbRichTextData.bxI().memeInfo.height.intValue(), i2, i3, this.mOnClickListener);
    }

    private boolean a(TbRichTextData tbRichTextData, ImageView imageView, int i2, int i3, boolean z) {
        if (tbRichTextData == null || imageView == null) {
            return false;
        }
        if (tbRichTextData.bxC() == null) {
            return false;
        }
        if (imageView instanceof TbImageView) {
            TbImageView tbImageView = (TbImageView) imageView;
            tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
            tbImageView.setBorderColor(ap.getColor(R.color.cp_border_a));
            tbImageView.setBorderSurroundContent(true);
            tbImageView.setDrawCorner(true);
            tbImageView.setDrawBorder(true);
            tbImageView.setLongIconSupport(true);
            tbImageView.setGifIconSupport(true);
            tbImageView.setTLIconType(tbRichTextData.getIconType());
            tbImageView.setConrers(15);
            tbImageView.setRadius(this.fcu);
            if (this.fgb) {
                tbImageView.setPlaceHolder(2);
            } else {
                tbImageView.setPlaceHolder(3);
            }
            if (this.fco.fep) {
                tbImageView.setSupportNoImage(true);
            }
            String bxP = this.fco.bxv() ? tbRichTextData.bxC().bxP() : tbRichTextData.bxC().bxS();
            if (!z || tbImageView.getUrl() == null || !tbImageView.getUrl().equals(bxP)) {
                tbImageView.startLoad(bxP, this.mIsFromCDN ? 17 : 18, false);
            }
            if (!tbRichTextData.bxC().bxU()) {
                tbImageView.setAdjustViewBounds(false);
            }
            tbImageView.setTag(R.id.tag_rich_text_meme_info, null);
        }
        return a(imageView, tbRichTextData.bxC().getWidth(), tbRichTextData.bxC().getHeight(), i2, i3, this.mOnClickListener);
    }

    private TextView er(Context context) {
        TextView textView = null;
        if (this.ffF != null) {
            textView = this.ffF.borrowObject();
        }
        if (textView == null || textView.getParent() != null) {
            textView = new TbListTextView(context);
        }
        textView.setPadding(this.fco.cLR, 0, this.fco.cLR, 0);
        return textView;
    }

    private boolean a(TbRichTextData tbRichTextData, TextView textView, boolean z, c cVar) {
        LinearLayout.LayoutParams layoutParams;
        if (z) {
            layoutParams = new LinearLayout.LayoutParams(-1, -2);
        } else {
            layoutParams = new LinearLayout.LayoutParams(-2, -2);
        }
        if (this.ffX) {
            layoutParams.gravity = 16;
            textView.setGravity(16);
        } else {
            layoutParams.topMargin = this.fco.fef;
        }
        textView.setLineSpacing(this.fco.fee, this.fco.fed);
        textView.setTextSize(0, this.fco.mTextSize);
        textView.setTextColor(this.fco.mTextColor);
        textView.setLinkTextColor(ap.getColor(R.color.cp_link_tip_c));
        textView.setHighlightColor(getContext().getResources().getColor(R.color.transparent));
        textView.setSingleLine(this.fco.fem);
        if (this.ffK != null) {
            textView.setEllipsize(this.ffK);
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
        SpannableStringBuilder bxD = tbRichTextData.bxD();
        if (bxD == null || bxD.length() <= 0) {
            return false;
        }
        if (this.fco.feh > 0 && this.fco.feg > 0) {
            tbRichTextData.bt(this.fco.feg, this.fco.feh);
        }
        if (cVar != null) {
            cVar.a(bxD, textView, this);
        }
        try {
            textView.setText(bxD);
        } catch (Exception e2) {
            textView.setText("");
        }
        if (this.ffY) {
            if (tbRichTextData.bxM()) {
                textView.setMovementMethod(com.baidu.tieba.view.c.dEZ());
            } else {
                textView.setMovementMethod(LinkMovementMethod.getInstance());
            }
        }
        textView.setFocusable(false);
        textView.setLayoutParams(layoutParams);
        textView.setTag(tbRichTextData);
        if (tbRichTextData != null && tbRichTextData.bxF() != null) {
            tbRichTextData.bxF().needRecompute = this.fgg;
        }
        return true;
    }

    private GifView getGifView() {
        GifView gifView = null;
        if (this.fcn != null) {
            gifView = this.fcn.borrowObject();
        }
        GifView gifView2 = (gifView == null || gifView.getParent() != null) ? new GifView(getContext()) : gifView;
        gifView2.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        gifView2.setBorderColor(ap.getColor(R.color.cp_border_a));
        gifView2.setBorderSurroundContent(true);
        gifView2.setDrawCorner(true);
        gifView2.setDrawBorder(true);
        gifView2.setConrers(15);
        gifView2.setDrawBorder(true);
        gifView2.setRadius(this.fcu);
        if (this.fgb) {
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
        if (layoutParams == null || layoutParams.width != tbRichTextData.bxH().mGifInfo.mGifWidth || layoutParams.height != tbRichTextData.bxH().mGifInfo.mGifHeight) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(tbRichTextData.bxH().mGifInfo.mGifWidth, tbRichTextData.bxH().mGifInfo.mGifHeight);
            layoutParams2.gravity = 3;
            gifView.setLayoutParams(layoutParams2);
        } else {
            layoutParams.bottomMargin = 0;
        }
        gifView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (TbRichTextView.this.ffV != null) {
                    TbRichTextEmotionInfo bxH = tbRichTextData.bxH();
                    TbRichTextView.this.ffV.a(view, bxH.mGifInfo.mGid, bxH.mGifInfo.mPackageName, bxH.mGifInfo.mIcon, bxH.mGifInfo.mStaticUrl, bxH.mGifInfo.mDynamicUrl, bxH.mGifInfo.mSharpText, bxH.mGifInfo.mGifWidth, bxH.mGifInfo.mGifHeight);
                }
            }
        });
        gifView.a(tbRichTextData.bxH().mGifInfo);
        return true;
    }

    private boolean a(TbRichTextData tbRichTextData, GifView gifView, boolean z) {
        if (gifView == null) {
            return false;
        }
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            gifView.setDefaultNoImageDay(ap.c(getContext().getResources(), R.drawable.icon_click));
        } else {
            gifView.setDefaultNoImageDay(R.drawable.icon_click);
        }
        Drawable drawable = ap.getDrawable(R.color.cp_bg_line_j);
        if (drawable != null) {
            gifView.setBackgroundDrawable(drawable);
        } else {
            gifView.setBackgroundDrawable(ap.getDrawable(R.color.common_color_10220));
        }
        String bxT = tbRichTextData.bxC().bxT();
        if (StringUtils.isNull(bxT)) {
            if (this.fco.feA) {
                bxT = this.fco.mIsFromCDN ? tbRichTextData.bxC().bxP() : tbRichTextData.bxC().bxR();
            }
            if (StringUtils.isNull(bxT)) {
                bxT = this.fco.mIsFromCDN ? tbRichTextData.bxC().bxS() : tbRichTextData.bxC().getSrc();
            }
        }
        gifView.setShowStaticDrawable(false);
        if (!z || gifView.getUrl() == null || !gifView.getUrl().equals(bxT)) {
            gifView.as(bxT, 38);
        }
        return a(gifView, tbRichTextData.bxC().getWidth(), tbRichTextData.bxC().getHeight(), this.fco.fei, this.fco.fej, this.mOnClickListener);
    }

    private View by(View view) {
        View borrowObject = this.ffG != null ? this.ffG.borrowObject() : null;
        if ((borrowObject == null || borrowObject.getParent() != null) && this.ffQ != -1) {
            borrowObject = LayoutInflater.from(getContext()).inflate(this.ffQ, (ViewGroup) null);
        }
        if (borrowObject != null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            if ((view instanceof TbListTextView) && this.fco.fet >= 0) {
                layoutParams.topMargin = this.fco.fet;
            } else {
                layoutParams.topMargin = this.fco.fef;
            }
            layoutParams.bottomMargin = this.fco.fev;
            borrowObject.setLayoutParams(layoutParams);
            if (borrowObject instanceof PlayVoiceBntNew) {
                ((PlayVoiceBntNew) borrowObject).setAfterClickListener(this.ffR);
                return borrowObject;
            }
            return borrowObject;
        }
        return null;
    }

    private boolean a(TbRichTextData tbRichTextData, View view) {
        view.setTag(tbRichTextData.bxE());
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LinearLayout.LayoutParams(-2, -2);
        }
        view.setLayoutParams(layoutParams);
        return true;
    }

    private View getTextVoiceView() {
        LinearLayout borrowObject = this.ffH.borrowObject();
        if (borrowObject != null) {
            TextView er = er(getContext());
            if (er == null) {
                this.ffH.returnObject(borrowObject);
                return null;
            }
            borrowObject.addView(er);
            View by = by(null);
            if (by == null) {
                this.ffF.returnObject(er);
                this.ffH.returnObject(borrowObject);
                return null;
            }
            borrowObject.addView(by);
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

    private boolean b(final TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.bxL() == null) {
            return false;
        }
        if (this.afA == null) {
            this.afA = new ItemCardView(getContext());
            this.afA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.14
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("itemID", tbRichTextData.bxL().bxO());
                    hashMap.put("source", 3);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new m(TbadkApplication.getInst().getApplicationContext(), "GameItemDetailsPage", hashMap)));
                }
            });
        }
        this.afA.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.afA.setData(tbRichTextData.bxL(), 17);
        this.afA.onChangeSkinType();
        return true;
    }

    public void setTextSize(float f2) {
        if (f2 != this.fco.mTextSize) {
            this.fco.mTextSize = f2;
            this.fco.feg = (int) f2;
            this.fco.feh = (int) f2;
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
        if (i2 != this.fco.mTextColor) {
            this.fco.mTextColor = i2;
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
        if (this.fco.cLR != i2) {
            this.fco.cLR = i2;
            int childCount = getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                if (childAt != null && (childAt instanceof TextView)) {
                    ((TextView) childAt).setPadding(this.fco.cLR, 0, 0, this.fco.cLR);
                }
            }
        }
    }

    public void setLinkTextColor(int i2) {
        if (i2 != this.fco.fen) {
            this.fco.fen = i2;
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
        this.ffJ = z;
    }

    public i getOnImageClickListener() {
        return this.fcy;
    }

    public void setOnImageClickListener(i iVar) {
        this.fcy = iVar;
        if (this.akg != null) {
            this.akg.setOnImageClickListener(this.fcy);
        }
    }

    public void setOnImageTouchListener(com.baidu.tieba.pb.a.c cVar) {
        this.eFf = cVar;
    }

    public void setOnEmotionClickListener(h hVar) {
        this.ffV = hVar;
    }

    public void setDisplayImage(boolean z, boolean z2) {
        if (this.ffP != z) {
            this.ffP = z;
            if (z2) {
                requestLayout();
            }
            if (!this.ffP && this.fcm != null) {
                this.fcm.clear();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
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
        this.ffS = false;
        switch (motionEvent.getAction()) {
            case 1:
            case 3:
                if (!this.mHasPerformedLongPress) {
                    byt();
                    break;
                }
                break;
        }
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        switch (motionEvent.getAction()) {
            case 0:
                if (!this.ffS) {
                    bys();
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
        this.ffS = true;
        return super.onTouchEvent(motionEvent);
    }

    private void bys() {
        this.mHasPerformedLongPress = false;
        if (this.ffT == null) {
            this.ffT = new a();
        }
        postDelayed(this.ffT, ViewConfiguration.getLongPressTimeout());
    }

    private void byt() {
        if (this.ffT != null) {
            removeCallbacks(this.ffT);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!TbRichTextView.this.fga && TbRichTextView.this.performLongClick()) {
                TbRichTextView.this.mHasPerformedLongPress = true;
            }
        }
    }

    public void setVoiceViewRes(int i2) {
        this.ffQ = i2;
    }

    public void setOnVoiceAfterClickListener(View.OnClickListener onClickListener) {
        this.ffR = onClickListener;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.fgh != drawable) {
            this.fgg = true;
            this.fgh = drawable;
        }
        setText(this.ffW);
        this.fgg = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.fco != null) {
            this.fco.release();
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
        this.fgd = fVar;
        CU(str);
    }

    public void CU(String str) {
        BdUniqueId bdUniqueId;
        boolean z;
        if (TextUtils.isEmpty(str)) {
            this.mUrl = str;
            return;
        }
        getContext();
        com.baidu.adp.base.h G = com.baidu.adp.base.i.G(getContext());
        if (G != null) {
            bdUniqueId = G.getUniqueId();
            z = G.isScroll();
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
        com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) com.baidu.adp.lib.e.c.mM().loadResourceFromMemery(this.mUrl, 19, new Object[0]);
        if (aVar != null) {
            h(aVar);
        } else if (z) {
            invalidate();
        } else if (!com.baidu.adp.lib.e.c.mM().aq(19)) {
            invalidate();
        } else {
            com.baidu.adp.lib.e.c.mM().a(this.mUrl, 19, this.eib, 0, 0, this.mPageId, new Object[0]);
        }
    }

    public void stopLoad() {
        if (!TextUtils.isEmpty(this.mUrl)) {
            com.baidu.adp.lib.e.c.mM().a(this.mUrl, 19, this.eib);
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
                if (this.fgd != null) {
                    this.fgd.byw();
                }
            } catch (Exception e2) {
            }
        }
    }

    @Override // com.baidu.adp.newwidget.ImageView.i
    public void refresh() {
        CU(this.mUrl);
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
        return this.ffM;
    }

    public void setOnLinkImageClickListener(j jVar) {
        this.ffM = jVar;
    }

    public void setHasMovementMethod(boolean z) {
        this.ffY = z;
    }

    public void setTextCenter(boolean z) {
        this.ffX = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class b {
        boolean fgm;

        private b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class d {
        boolean fgn;

        private d() {
        }
    }

    public com.baidu.tieba.pb.a<ImageView> getRecycleImageViewPool() {
        if (this.ffE == null) {
            this.ffE = new com.baidu.tieba.pb.a<ImageView>(new com.baidu.adp.lib.d.c<ImageView>() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: byu */
                public ImageView makeObject() {
                    ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(com.baidu.adp.base.i.I(TbRichTextView.this.getContext()).getPageActivity());
                    boolean isShowImages = com.baidu.tbadk.core.k.bbM().isShowImages();
                    foreDrawableImageView.setDefaultBg(ap.getDrawable(R.color.common_color_10220));
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
                        if (com.baidu.tbadk.core.k.bbM().isShowImages()) {
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
            }, 10, 0) { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.6
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tieba.pb.a
                /* renamed from: ar */
                public ImageView as(Object obj) {
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
        return this.ffE;
    }

    public TbRichText getRichText() {
        return this.ffW;
    }

    public void setmGridEmptyClickListener(View.OnClickListener onClickListener) {
        this.ffO = onClickListener;
    }
}
