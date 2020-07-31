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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.x;
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
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBnt;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import tbclient.PbContent;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes.dex */
public class TbRichTextView extends LinearLayout implements com.baidu.adp.newwidget.ImageView.i {
    private static final float eTv = l.getEquipmentDensity(TbadkCoreApplication.getInst());
    private ItemCardView aer;
    private GridImageLayout aiR;
    private final com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a> dYv;
    private final com.baidu.tieba.pb.a.c eMT;
    private com.baidu.adp.lib.d.b<ImageView> eRG;
    private com.baidu.adp.lib.d.b<GifView> eRH;
    private com.baidu.tbadk.widget.richText.a eRI;
    private int eRN;
    private i eRR;
    private com.baidu.tieba.pb.a<ImageView> eUW;
    private com.baidu.adp.lib.d.b<TextView> eUX;
    private com.baidu.adp.lib.d.b<View> eUY;
    private com.baidu.adp.lib.d.b<LinearLayout> eUZ;
    private CustomMessageListener eVA;
    private com.baidu.adp.lib.d.b<RelativeLayout> eVa;
    private boolean eVb;
    private TextUtils.TruncateAt eVc;
    private k eVd;
    private j eVe;
    private View.OnClickListener eVf;
    private View.OnClickListener eVg;
    private boolean eVh;
    private int eVi;
    private View.OnClickListener eVj;
    private boolean eVk;
    private Runnable eVl;
    private boolean eVm;
    private h eVn;
    private TbRichText eVo;
    private boolean eVp;
    private boolean eVq;
    private boolean eVr;
    private boolean eVs;
    private boolean eVt;
    private boolean eVu;
    private f eVv;
    public final View.OnClickListener eVw;
    private final g eVx;
    private boolean eVy;
    private Drawable eVz;
    private com.baidu.tieba.pb.a.c euG;
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
        void bpI();
    }

    /* loaded from: classes.dex */
    public interface g {
        void w(MotionEvent motionEvent);
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
        void f(View view, String str);
    }

    public void setSubPbPost(boolean z) {
        this.eVr = z;
        bpD();
    }

    public void setIsHost(boolean z) {
        this.isHost = z;
        if (this.aiR != null) {
            this.aiR.setIsHost(z);
        }
    }

    public void setIsUseGridImage(boolean z) {
        this.eVt = z;
    }

    public void setmIsGridImageSupportLongPress(boolean z) {
        this.eVu = z;
    }

    public boolean bpC() {
        return this.eVm;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
        if (this.eRI != null) {
            this.eRI.mIsFromCDN = z;
        }
    }

    public void setMaxWidth(int i2) {
        this.mMaxWidth = i2;
    }

    public void setMaxLines(int i2) {
        this.mMaxLines = i2;
    }

    public void setTextEllipsize(TextUtils.TruncateAt truncateAt) {
        this.eVc = truncateAt;
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
    public boolean bv(View view) {
        if (view instanceof ImageView) {
            if (view instanceof GifView) {
                return view.getTag(R.id.tag_rich_text_view_gif_view) != null && (view.getTag(R.id.tag_rich_text_view_gif_view) instanceof b) && ((b) view.getTag(R.id.tag_rich_text_view_gif_view)).eVE;
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

    public static com.baidu.adp.lib.d.b<TextView> w(final Context context, int i2) {
        return new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<TextView>() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: bpH */
            public TextView makeObject() {
                return new TbListTextView(context);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: d */
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
            /* renamed from: e */
            public TextView activateObject(TextView textView) {
                return textView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: f */
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
        this.eRI = new com.baidu.tbadk.widget.richText.a();
        this.eUW = null;
        this.eRG = null;
        this.eUX = null;
        this.eUY = null;
        this.eUZ = null;
        this.eVa = null;
        this.eRH = null;
        this.eVb = true;
        this.eVc = null;
        this.eVd = null;
        this.eRR = null;
        this.euG = null;
        this.eVe = null;
        this.eVf = null;
        this.eVg = null;
        this.eVh = true;
        this.mIsFromCDN = true;
        this.eVi = -1;
        this.eVk = false;
        this.mHasPerformedLongPress = false;
        this.eVl = null;
        this.eVm = false;
        this.eVp = false;
        this.mMaxWidth = -1;
        this.mMaxLines = -1;
        this.eVq = true;
        this.eVr = false;
        this.isHost = false;
        this.eVs = false;
        this.eVt = false;
        this.eVu = false;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                String str2 = null;
                int i2 = -1;
                if (TbRichTextView.this.eRR != null && (view instanceof ImageView)) {
                    Object tag = view.getTag();
                    if (tag != null && (tag instanceof TbRichText)) {
                        int childCount = TbRichTextView.this.getChildCount();
                        for (int i3 = 0; i3 < childCount; i3++) {
                            i2++;
                            if (view.getParent() == TbRichTextView.this.getChildAt(i3)) {
                                break;
                            }
                        }
                        TbRichTextView.this.eRR.a(view, null, i2, TbRichTextView.this.isHost, false);
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
                        TbRichTextView.this.eRR.a(view, str, i2, TbRichTextView.this.isHost, false);
                        return;
                    } else if (view instanceof TbImageView) {
                        str2 = ((TbImageView) view).getUrl();
                    } else if (view instanceof GifView) {
                        str2 = ((GifView) view).getUrl();
                    }
                    int childCount3 = TbRichTextView.this.getChildCount();
                    for (int i5 = 0; i5 < childCount3; i5++) {
                        View childAt = TbRichTextView.this.getChildAt(i5);
                        if (TbRichTextView.this.bv(childAt)) {
                            i2++;
                        }
                        if (view == childAt) {
                            break;
                        }
                    }
                    TbRichTextView.this.eRR.a(view, str2, i2, TbRichTextView.this.isHost, false);
                }
            }
        };
        this.eMT = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.7
            @Override // com.baidu.tieba.pb.a.c.a
            public boolean onDoubleTap(View view, MotionEvent motionEvent) {
                if (TbRichTextView.this.euG != null) {
                    TbRichTextView.this.euG.W(view);
                    return TbRichTextView.this.euG.onDoubleTap(motionEvent);
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
        this.eVw = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                if (TbRichTextView.this.eVe != null && (view instanceof TbImageView)) {
                    Object tag = view.getTag();
                    if (tag == null || !(tag instanceof e)) {
                        str = null;
                    } else {
                        str = ((e) tag).url;
                    }
                    TbRichTextView.this.eVe.f(view, str);
                }
            }
        };
        this.eVx = new g() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.2
            @Override // com.baidu.tbadk.widget.richText.TbRichTextView.g
            public void w(MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    TbRichTextView.this.eVs = true;
                } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                    TbRichTextView.this.eVs = false;
                }
            }
        };
        this.mType = 19;
        this.dYv = new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.3
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
        this.eVA = new CustomMessageListener(CmdConfigCustom.PB_RICHTEXT_CHANGE_CMD) { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int contentSizeOfLzl = TbRichTextView.this.eVr ? TbConfig.getContentSizeOfLzl() : TbConfig.getContentSize();
                if (TbRichTextView.this.eVo != null && !x.isEmpty(TbRichTextView.this.eVo.boJ())) {
                    Iterator<TbRichTextData> it = TbRichTextView.this.eVo.boJ().iterator();
                    while (it.hasNext()) {
                        TbRichTextData next = it.next();
                        if (next != null) {
                            next.bk(contentSizeOfLzl, contentSizeOfLzl);
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
        this.eRI = new com.baidu.tbadk.widget.richText.a();
        this.eUW = null;
        this.eRG = null;
        this.eUX = null;
        this.eUY = null;
        this.eUZ = null;
        this.eVa = null;
        this.eRH = null;
        this.eVb = true;
        this.eVc = null;
        this.eVd = null;
        this.eRR = null;
        this.euG = null;
        this.eVe = null;
        this.eVf = null;
        this.eVg = null;
        this.eVh = true;
        this.mIsFromCDN = true;
        this.eVi = -1;
        this.eVk = false;
        this.mHasPerformedLongPress = false;
        this.eVl = null;
        this.eVm = false;
        this.eVp = false;
        this.mMaxWidth = -1;
        this.mMaxLines = -1;
        this.eVq = true;
        this.eVr = false;
        this.isHost = false;
        this.eVs = false;
        this.eVt = false;
        this.eVu = false;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                String str2 = null;
                int i2 = -1;
                if (TbRichTextView.this.eRR != null && (view instanceof ImageView)) {
                    Object tag = view.getTag();
                    if (tag != null && (tag instanceof TbRichText)) {
                        int childCount = TbRichTextView.this.getChildCount();
                        for (int i3 = 0; i3 < childCount; i3++) {
                            i2++;
                            if (view.getParent() == TbRichTextView.this.getChildAt(i3)) {
                                break;
                            }
                        }
                        TbRichTextView.this.eRR.a(view, null, i2, TbRichTextView.this.isHost, false);
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
                        TbRichTextView.this.eRR.a(view, str, i2, TbRichTextView.this.isHost, false);
                        return;
                    } else if (view instanceof TbImageView) {
                        str2 = ((TbImageView) view).getUrl();
                    } else if (view instanceof GifView) {
                        str2 = ((GifView) view).getUrl();
                    }
                    int childCount3 = TbRichTextView.this.getChildCount();
                    for (int i5 = 0; i5 < childCount3; i5++) {
                        View childAt = TbRichTextView.this.getChildAt(i5);
                        if (TbRichTextView.this.bv(childAt)) {
                            i2++;
                        }
                        if (view == childAt) {
                            break;
                        }
                    }
                    TbRichTextView.this.eRR.a(view, str2, i2, TbRichTextView.this.isHost, false);
                }
            }
        };
        this.eMT = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.7
            @Override // com.baidu.tieba.pb.a.c.a
            public boolean onDoubleTap(View view, MotionEvent motionEvent) {
                if (TbRichTextView.this.euG != null) {
                    TbRichTextView.this.euG.W(view);
                    return TbRichTextView.this.euG.onDoubleTap(motionEvent);
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
        this.eVw = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                if (TbRichTextView.this.eVe != null && (view instanceof TbImageView)) {
                    Object tag = view.getTag();
                    if (tag == null || !(tag instanceof e)) {
                        str = null;
                    } else {
                        str = ((e) tag).url;
                    }
                    TbRichTextView.this.eVe.f(view, str);
                }
            }
        };
        this.eVx = new g() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.2
            @Override // com.baidu.tbadk.widget.richText.TbRichTextView.g
            public void w(MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    TbRichTextView.this.eVs = true;
                } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                    TbRichTextView.this.eVs = false;
                }
            }
        };
        this.mType = 19;
        this.dYv = new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.3
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
        this.eVA = new CustomMessageListener(CmdConfigCustom.PB_RICHTEXT_CHANGE_CMD) { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int contentSizeOfLzl = TbRichTextView.this.eVr ? TbConfig.getContentSizeOfLzl() : TbConfig.getContentSize();
                if (TbRichTextView.this.eVo != null && !x.isEmpty(TbRichTextView.this.eVo.boJ())) {
                    Iterator<TbRichTextData> it = TbRichTextView.this.eVo.boJ().iterator();
                    while (it.hasNext()) {
                        TbRichTextData next = it.next();
                        if (next != null) {
                            next.bk(contentSizeOfLzl, contentSizeOfLzl);
                        }
                    }
                }
                TbRichTextView.this.setTextSize(contentSizeOfLzl);
            }
        };
        init();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.TbRichTextView);
        this.eRI.b(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        bpD();
    }

    public com.baidu.tbadk.widget.richText.a getLayoutStrategy() {
        return this.eRI;
    }

    public void setLayoutStrategy(com.baidu.tbadk.widget.richText.a aVar) {
        if (aVar != null) {
            this.eRI.release();
            this.eRI = aVar;
            bpD();
            if (this.aiR != null) {
                this.aiR.setLayoutStrategy(this.eRI);
            }
        }
    }

    private void bpD() {
        int contentSizeOfLzl = this.eVr ? TbConfig.getContentSizeOfLzl() : TbConfig.getContentSize();
        this.eRI.eTA = contentSizeOfLzl;
        this.eRI.eTz = contentSizeOfLzl;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x004e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void init() {
        com.baidu.tbadk.widget.richText.i iVar;
        com.baidu.tbadk.widget.richText.i iVar2;
        com.baidu.adp.base.e<?> G = com.baidu.adp.base.i.G(getContext());
        if (getContext() instanceof com.baidu.tbadk.widget.richText.i) {
            iVar = (com.baidu.tbadk.widget.richText.i) getContext();
        } else if (G == null || !(G.getOrignalPage() instanceof com.baidu.tbadk.widget.richText.i)) {
            iVar = null;
        } else {
            iVar = (com.baidu.tbadk.widget.richText.i) G.getOrignalPage();
        }
        if (iVar == null && (getContext() instanceof BaseFragmentActivity)) {
            List<Fragment> fragments = ((BaseFragmentActivity) getContext()).getSupportFragmentManager().getFragments();
            if (!x.isEmpty(fragments) && (fragments.get(0) instanceof com.baidu.tbadk.widget.richText.i)) {
                iVar2 = (com.baidu.tbadk.widget.richText.i) fragments.get(0);
                if (G != null) {
                    G.registerListener(this.eVA);
                }
                if (iVar2 != null) {
                    this.eRG = iVar2.bpu();
                    this.eUX = iVar2.bpv();
                    this.eUY = iVar2.bpx();
                    this.eUZ = iVar2.bpy();
                    this.eRH = iVar2.bpw();
                    this.eVa = iVar2.bpz();
                    if (iVar2.getListView() != null && this.eVd == null) {
                        this.eVd = new k(iVar2.bpt());
                        iVar2.getListView().setRecyclerListener(this.eVd);
                    }
                }
                this.eRN = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10);
                setOrientation(1);
                setOnHierarchyChangeListener(new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.10
                    @Override // android.view.ViewGroup.OnHierarchyChangeListener
                    public void onChildViewRemoved(View view, View view2) {
                        if (view2 instanceof GifView) {
                            Object tag = view2.getTag(R.id.tag_rich_text_view_recycle);
                            if (!(tag instanceof d) || !((d) tag).eVF) {
                                if (TbRichTextView.this.eRH != null) {
                                    TbRichTextView.this.eRH.returnObject((GifView) view2);
                                }
                            } else {
                                if (TbRichTextView.this.eUW == null) {
                                    TbRichTextView.this.eUW = TbRichTextView.this.getRecycleImageViewPool();
                                }
                                TbRichTextView.this.eUW.returnObject((ImageView) view2);
                            }
                        } else if (view2 instanceof ImageView) {
                            Object tag2 = view2.getTag(R.id.tag_rich_text_view_recycle);
                            if (!(tag2 instanceof d) || !((d) tag2).eVF) {
                                if (TbRichTextView.this.eRG != null) {
                                    TbRichTextView.this.eRG.returnObject((ImageView) view2);
                                }
                            } else {
                                if (TbRichTextView.this.eUW == null) {
                                    TbRichTextView.this.eUW = TbRichTextView.this.getRecycleImageViewPool();
                                }
                                TbRichTextView.this.eUW.returnObject((ImageView) view2);
                            }
                        } else if ((view2 instanceof TextView) && TbRichTextView.this.eUX != null) {
                            TbRichTextView.this.eUX.returnObject((TextView) view2);
                        } else if ((view2 instanceof PlayVoiceBnt) && TbRichTextView.this.eUY != null) {
                            TbRichTextView.this.eUY.returnObject(view2);
                        } else if ((view2 instanceof PlayVoiceBntNew) && TbRichTextView.this.eUY != null) {
                            TbRichTextView.this.eUY.returnObject(view2);
                        } else if (view2 instanceof GridImageLayout) {
                            int childCount = ((GridImageLayout) view2).getChildCount();
                            for (int i2 = 0; i2 < childCount; i2++) {
                                View childAt = ((GridImageLayout) view2).getChildAt(i2);
                                if ((childAt instanceof GifView) && TbRichTextView.this.eRH != null) {
                                    TbRichTextView.this.eRH.returnObject((GifView) childAt);
                                } else if ((childAt instanceof ImageView) && TbRichTextView.this.eRG != null) {
                                    TbRichTextView.this.eRG.returnObject((ImageView) childAt);
                                }
                            }
                            ((GridImageLayout) view2).removeAllViews();
                            ((GridImageLayout) view2).clearData();
                        } else if ((view2 instanceof RelativeLayout) && TbRichTextView.this.eVa != null) {
                            TbRichTextView.this.eVa.returnObject((RelativeLayout) view2);
                        }
                        if (view2 instanceof LinearLayout) {
                            Object tag3 = view2.getTag();
                            if (tag3 == null || !(tag3 instanceof String) || !"VideoView".equals(tag3)) {
                                if (TbRichTextView.this.eUZ != null) {
                                    int childCount2 = ((LinearLayout) view2).getChildCount();
                                    for (int i3 = 0; i3 < childCount2; i3++) {
                                        View childAt2 = ((LinearLayout) view2).getChildAt(i3);
                                        if (childAt2 != null) {
                                            if ((childAt2 instanceof TextView) && TbRichTextView.this.eUX != null) {
                                                TbRichTextView.this.eUX.returnObject((TextView) childAt2);
                                            } else if ((childAt2 instanceof PlayVoiceBnt) && TbRichTextView.this.eUY != null) {
                                                TbRichTextView.this.eUY.returnObject(childAt2);
                                            } else if ((childAt2 instanceof PlayVoiceBntNew) && TbRichTextView.this.eUY != null) {
                                                TbRichTextView.this.eUY.returnObject(childAt2);
                                            }
                                        }
                                    }
                                    ((LinearLayout) view2).removeAllViews();
                                    TbRichTextView.this.eUZ.returnObject((LinearLayout) view2);
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
        if (G != null) {
        }
        if (iVar2 != null) {
        }
        this.eRN = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10);
        setOrientation(1);
        setOnHierarchyChangeListener(new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.10
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if (view2 instanceof GifView) {
                    Object tag = view2.getTag(R.id.tag_rich_text_view_recycle);
                    if (!(tag instanceof d) || !((d) tag).eVF) {
                        if (TbRichTextView.this.eRH != null) {
                            TbRichTextView.this.eRH.returnObject((GifView) view2);
                        }
                    } else {
                        if (TbRichTextView.this.eUW == null) {
                            TbRichTextView.this.eUW = TbRichTextView.this.getRecycleImageViewPool();
                        }
                        TbRichTextView.this.eUW.returnObject((ImageView) view2);
                    }
                } else if (view2 instanceof ImageView) {
                    Object tag2 = view2.getTag(R.id.tag_rich_text_view_recycle);
                    if (!(tag2 instanceof d) || !((d) tag2).eVF) {
                        if (TbRichTextView.this.eRG != null) {
                            TbRichTextView.this.eRG.returnObject((ImageView) view2);
                        }
                    } else {
                        if (TbRichTextView.this.eUW == null) {
                            TbRichTextView.this.eUW = TbRichTextView.this.getRecycleImageViewPool();
                        }
                        TbRichTextView.this.eUW.returnObject((ImageView) view2);
                    }
                } else if ((view2 instanceof TextView) && TbRichTextView.this.eUX != null) {
                    TbRichTextView.this.eUX.returnObject((TextView) view2);
                } else if ((view2 instanceof PlayVoiceBnt) && TbRichTextView.this.eUY != null) {
                    TbRichTextView.this.eUY.returnObject(view2);
                } else if ((view2 instanceof PlayVoiceBntNew) && TbRichTextView.this.eUY != null) {
                    TbRichTextView.this.eUY.returnObject(view2);
                } else if (view2 instanceof GridImageLayout) {
                    int childCount = ((GridImageLayout) view2).getChildCount();
                    for (int i2 = 0; i2 < childCount; i2++) {
                        View childAt = ((GridImageLayout) view2).getChildAt(i2);
                        if ((childAt instanceof GifView) && TbRichTextView.this.eRH != null) {
                            TbRichTextView.this.eRH.returnObject((GifView) childAt);
                        } else if ((childAt instanceof ImageView) && TbRichTextView.this.eRG != null) {
                            TbRichTextView.this.eRG.returnObject((ImageView) childAt);
                        }
                    }
                    ((GridImageLayout) view2).removeAllViews();
                    ((GridImageLayout) view2).clearData();
                } else if ((view2 instanceof RelativeLayout) && TbRichTextView.this.eVa != null) {
                    TbRichTextView.this.eVa.returnObject((RelativeLayout) view2);
                }
                if (view2 instanceof LinearLayout) {
                    Object tag3 = view2.getTag();
                    if (tag3 == null || !(tag3 instanceof String) || !"VideoView".equals(tag3)) {
                        if (TbRichTextView.this.eUZ != null) {
                            int childCount2 = ((LinearLayout) view2).getChildCount();
                            for (int i3 = 0; i3 < childCount2; i3++) {
                                View childAt2 = ((LinearLayout) view2).getChildAt(i3);
                                if (childAt2 != null) {
                                    if ((childAt2 instanceof TextView) && TbRichTextView.this.eUX != null) {
                                        TbRichTextView.this.eUX.returnObject((TextView) childAt2);
                                    } else if ((childAt2 instanceof PlayVoiceBnt) && TbRichTextView.this.eUY != null) {
                                        TbRichTextView.this.eUY.returnObject(childAt2);
                                    } else if ((childAt2 instanceof PlayVoiceBntNew) && TbRichTextView.this.eUY != null) {
                                        TbRichTextView.this.eUY.returnObject(childAt2);
                                    }
                                }
                            }
                            ((LinearLayout) view2).removeAllViews();
                            TbRichTextView.this.eUZ.returnObject((LinearLayout) view2);
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
        ArrayList<TbRichTextData> boJ;
        int i2;
        int i3;
        boolean z4;
        SpannableStringBuilder boQ;
        boolean z5;
        View view;
        boolean z6;
        ImageView ei;
        boolean z7;
        ImageView imageView;
        boolean z8;
        GifView gifView;
        boolean z9;
        GifView gifView2;
        View a2;
        boolean z10;
        int i4;
        if (this.eVo != tbRichText || (tbRichText != null && tbRichText.isChanged)) {
            if (tbRichText != null) {
                tbRichText.isChanged = false;
            }
            this.eVo = tbRichText;
            removeAllViews();
            if (tbRichText != null && (boJ = tbRichText.boJ()) != null) {
                View view2 = null;
                boolean z11 = true;
                Iterator<TbRichTextData> it = boJ.iterator();
                boolean z12 = false;
                int i5 = 0;
                int i6 = 0;
                View view3 = null;
                while (it.hasNext()) {
                    TbRichTextData next = it.next();
                    boolean z13 = false;
                    if (next != null) {
                        if (next.getType() == 1) {
                            TextView ej = ej(getContext());
                            boolean a3 = a(next, ej, true, cVar);
                            if (z && !this.eVm && (boQ = next.boQ()) != null) {
                                this.eVm = boQ.length() >= 200;
                            }
                            if (this.euG != null) {
                                ej.setOnTouchListener(this.eMT);
                            } else {
                                ej.setOnClickListener(this.eVf);
                            }
                            z13 = a3;
                            i2 = i5;
                            i3 = i6;
                            view3 = ej;
                            z4 = z12;
                        } else if (next.getType() == 8) {
                            if (!this.eVt) {
                                if (i6 < 10) {
                                    i6++;
                                    if (next.boP() != null) {
                                        if (TbadkCoreApplication.getInst().isGifAutoPlay() && !next.boP().bpj()) {
                                            GifView gifView3 = null;
                                            if (!z3) {
                                                z8 = false;
                                                gifView = getGifView();
                                            } else {
                                                String bpf = next.boP().bpf();
                                                if (StringUtils.isNull(bpf)) {
                                                    if (this.eRI.eTT) {
                                                        bpf = this.eRI.mIsFromCDN ? next.boP().bpb() : next.boP().bpd();
                                                    }
                                                    if (StringUtils.isNull(bpf)) {
                                                        bpf = this.eRI.mIsFromCDN ? next.boP().bpe() : next.boP().getSrc();
                                                    }
                                                }
                                                if (this.eUW != null) {
                                                    ImageView aq = this.eUW.aq(bpf);
                                                    if (aq instanceof GifView) {
                                                        gifView3 = (GifView) aq;
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
                                            bVar.eVE = true;
                                            gifView.setTag(R.id.tag_rich_text_view_gif_view, bVar);
                                            z13 = a(next, gifView, z8);
                                            if (z2) {
                                                d dVar = new d();
                                                dVar.eVF = true;
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
                                                ei = ei(getContext());
                                            } else {
                                                String bpb = this.eRI.boI() ? next.boP().bpb() : next.boP().bpe();
                                                if (this.eUW != null) {
                                                    imageView2 = this.eUW.aq(bpb);
                                                }
                                                if (imageView2 == null) {
                                                    imageView = ei(getContext());
                                                    z7 = false;
                                                } else {
                                                    z7 = true;
                                                    imageView = imageView2;
                                                }
                                                z6 = z7;
                                                ei = imageView;
                                            }
                                            z13 = a(next, ei, this.eRI.eTB, this.eRI.eTC, z6);
                                            if (z2) {
                                                d dVar2 = new d();
                                                dVar2.eVF = true;
                                                ei.setTag(R.id.tag_rich_text_view_recycle, dVar2);
                                            }
                                            z4 = z12;
                                            i2 = i5;
                                            i3 = i6;
                                            view3 = ei;
                                        }
                                    }
                                    z4 = z12;
                                    i2 = i5;
                                    i3 = i6;
                                    view3 = view3;
                                }
                            } else if (!z12) {
                                GridImageLayout gridImageView = getGridImageView();
                                gridImageView.setData(tbRichText.boK());
                                z13 = true;
                                z4 = true;
                                i2 = i5;
                                i3 = i6;
                                view3 = gridImageView;
                            }
                        } else if (next.getType() == 32) {
                            com.baidu.tbadk.widget.richText.j boT = next.boT();
                            if (boT != null && boT.bpB()) {
                                a2 = b(boT);
                            } else {
                                a2 = a(next);
                            }
                            z4 = z12;
                            i2 = i5;
                            i3 = i6;
                            view3 = a2;
                            z13 = true;
                        } else if (next.getType() == 512) {
                            view3 = bw(view2);
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
                                if (next == null || next.boV() == null || next.boV().memeInfo == null || StringUtils.isNull(next.boV().memeInfo.pic_url)) {
                                    z10 = false;
                                } else {
                                    z10 = true;
                                }
                                if (z10) {
                                    RelativeLayout borrowObject = this.eVa.borrowObject();
                                    borrowObject.removeAllViews();
                                    borrowObject.setLayoutParams(new LinearLayout.LayoutParams(next.boV().memeInfo.width.intValue(), next.boV().memeInfo.height.intValue()));
                                    if (DuiSwitch.getInOn() && this.eVb) {
                                        b(borrowObject, next.boV().memeInfo.width.intValue(), next.boV().memeInfo.height.intValue(), this.eRI.eTB, this.eRI.eTC);
                                    } else {
                                        a(borrowObject, next.boV().memeInfo.width.intValue(), next.boV().memeInfo.height.intValue(), this.eRI.eTB, this.eRI.eTC);
                                    }
                                    ImageView borrowObject2 = this.eRG.borrowObject();
                                    b(next, borrowObject2, this.eRI.eTB, this.eRI.eTC);
                                    if (DuiSwitch.getInOn() && this.eVb) {
                                        ImageView borrowObject3 = this.eRG.borrowObject();
                                        borrowObject3.setTag(this.eVo);
                                        if (borrowObject3 instanceof TbImageView) {
                                            TbImageView tbImageView = (TbImageView) borrowObject3;
                                            tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
                                            tbImageView.setBorderColor(ao.getColor(R.color.cp_border_a));
                                            tbImageView.setBorderSurroundContent(true);
                                            tbImageView.setDrawCorner(true);
                                            tbImageView.setDrawBorder(true);
                                            tbImageView.setLongIconSupport(true);
                                            tbImageView.setGifIconSupport(true);
                                            tbImageView.setConrers(15);
                                            tbImageView.setRadius(this.eRN);
                                            tbImageView.setAdjustViewBounds(false);
                                            if (this.eVt) {
                                                tbImageView.setPlaceHolder(2);
                                            } else {
                                                tbImageView.setPlaceHolder(3);
                                            }
                                        }
                                        borrowObject3.setScaleType(ImageView.ScaleType.FIT_XY);
                                        int dimens = l.getDimens(getContext(), R.dimen.ds78);
                                        int dimens2 = l.getDimens(getContext(), R.dimen.ds78);
                                        borrowObject2.setId(R.id.meme_image_view);
                                        c(borrowObject2, next.boV().memeInfo.width.intValue(), next.boV().memeInfo.height.intValue(), this.eRI.eTB, this.eRI.eTC, this.mOnClickListener);
                                        borrowObject.addView(borrowObject2);
                                        if (dimens2 > next.boV().memeInfo.height.intValue()) {
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
                                        ao.setImageResource(borrowObject3, R.drawable.icon_emotion_dui_n);
                                        borrowObject.addView(borrowObject3, layoutParams);
                                    } else {
                                        b(borrowObject2, next.boV().memeInfo.width.intValue(), next.boV().memeInfo.height.intValue(), this.eRI.eTB, this.eRI.eTC, this.mOnClickListener);
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
                            ImageView ei2 = ei(getContext());
                            z13 = a(next, ei2, (this.eRI.eTB - getPaddingLeft()) - getPaddingRight(), this.eRI.eTC);
                            z4 = z12;
                            i2 = i5;
                            i3 = i6 + 1;
                            view3 = ei2;
                        } else {
                            if (next.getType() == 1281) {
                                z13 = b(next);
                                z4 = z12;
                                i2 = i5;
                                i3 = i6;
                                view3 = this.aer;
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
                            if (z11 && this.eRI.eTR >= 0) {
                                z11 = false;
                                if (layoutParams2 != null) {
                                    layoutParams2.topMargin = this.eRI.eTR;
                                    view3.setLayoutParams(layoutParams2);
                                    z5 = false;
                                    view = view3;
                                }
                                z5 = z11;
                                view = view3;
                            } else {
                                if (view3 instanceof TbListTextView) {
                                    if ((view2 instanceof ImageView) || (view2 instanceof RelativeLayout)) {
                                        layoutParams2.topMargin = this.eRI.eTN;
                                    } else {
                                        layoutParams2.topMargin = this.eRI.eTy;
                                    }
                                    view3.setLayoutParams(layoutParams2);
                                    z5 = z11;
                                } else if (((view3 instanceof ImageView) || (view3 instanceof RelativeLayout)) && (next.getType() == 8 || next.getType() == 20 || next.getType() == 17)) {
                                    if (view2 instanceof TbListTextView) {
                                        layoutParams2.topMargin = this.eRI.eTL;
                                    } else if ((view2 instanceof ImageView) || (view3 instanceof RelativeLayout)) {
                                        layoutParams2.topMargin = this.eRI.eTK;
                                    } else {
                                        layoutParams2.topMargin = this.eRI.eTy;
                                    }
                                    view3.setLayoutParams(layoutParams2);
                                    z5 = z11;
                                } else {
                                    if ((view3 instanceof ItemCardView) && !z11) {
                                        layoutParams2.topMargin = this.eRI.eTS;
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
                    layoutParams3.bottomMargin = this.eRI.eTQ;
                    view2.setLayoutParams(layoutParams3);
                } else if (view2 != null && this.eRI.eTP >= 0) {
                    LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) view2.getLayoutParams();
                    layoutParams4.bottomMargin = this.eRI.eTP;
                    view2.setLayoutParams(layoutParams4);
                }
                if (!z2 && this.eUW != null) {
                    this.eUW.clear();
                }
            }
        }
    }

    private GridImageLayout getGridImageView() {
        if (this.aiR == null || this.aiR.getParent() != null) {
            this.aiR = new GridImageLayout(getContext());
            this.aiR.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        }
        this.aiR.setLayoutStrategy(this.eRI);
        this.aiR.setObjectPool(this.eRG, this.eRH);
        this.aiR.setOnImageClickListener(this.eRR);
        if (this.eVg != null) {
            this.aiR.setOnClickListener(this.eVg);
        }
        this.aiR.setIsHost(this.isHost);
        if (this.eVu) {
            this.aiR.setOnLongClickListener(this.onLongClickListener);
        }
        return this.aiR;
    }

    public void setCommonTextViewOnClickListener(View.OnClickListener onClickListener) {
        this.eVf = onClickListener;
    }

    private View b(final com.baidu.tbadk.widget.richText.j jVar) {
        if (jVar == null || !jVar.isAvaliable()) {
            return null;
        }
        ImageView borrowObject = this.eRG.borrowObject();
        if (borrowObject instanceof ForeDrawableImageView) {
            ForeDrawableImageView foreDrawableImageView = (ForeDrawableImageView) borrowObject;
            foreDrawableImageView.setForegroundDrawable(R.drawable.icon_play_video);
            foreDrawableImageView.setNoImageBottomTextColor(R.color.cp_cont_c);
            foreDrawableImageView.setNoImageBottomTextPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds32));
            foreDrawableImageView.setNoImageBottomTextSize(TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.fontsize28));
            foreDrawableImageView.setNoImageBottomText("点击播放视频");
            foreDrawableImageView.setInterceptOnClick(false);
            foreDrawableImageView.setTag("VideoView");
            b(foreDrawableImageView, jVar.getWidth(), jVar.getHeight(), (this.eRI.eTB - getPaddingLeft()) - getPaddingRight(), this.eRI.eTC, new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.11
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(TbadkCoreStatisticKey.KEY_RICH_TEXT_VIDEO_CLICK);
                    XiaoyingUtil.startPlayXiaoyingVideo(TbRichTextView.this.getContext(), jVar.getVideoUrl(), jVar.getWidth(), jVar.getHeight(), jVar.getThumbUrl());
                }
            });
            foreDrawableImageView.setDefaultResource(0);
            foreDrawableImageView.setSupportNoImage(this.eRI.eTI);
            if (com.baidu.tbadk.core.k.aTv().isShowImages()) {
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
        int[] v = this.eRI.v(i2, i3, i4, i5);
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
        if (this.eRI.eTJ) {
            imageView.setScaleType(this.eRI.eTH);
            if (imageView instanceof TbImageView) {
                ((TbImageView) imageView).setOnDrawListener(this.eRI.aik);
            }
        } else {
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        }
        imageView.setClickable(true);
        imageView.setFocusable(false);
        if (this.euG != null && (imageView instanceof TbImageView)) {
            ((TbImageView) imageView).setTbGestureDetector(this.eMT);
            imageView.setClickable(true);
        } else {
            imageView.setOnClickListener(onClickListener);
        }
        imageView.setLayoutParams(layoutParams);
        if (imageView instanceof TbImageView) {
            if (this.onLongClickListener != null) {
                ((TbImageView) imageView).setDispatchTouchListener(this.eVx);
                imageView.setOnLongClickListener(this.onLongClickListener);
            }
        } else if ((imageView instanceof GifView) && this.onLongClickListener != null) {
            ((GifView) imageView).setDispatchTouchListener(this.eVx);
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
        if (!this.eRI.eTJ || i4 <= i7 || eTv <= 1.0f) {
            i4 = i7;
            i6 = i8;
        } else {
            if (i7 * eTv <= i4) {
                if (i7 * eTv > i4 * 0.68f) {
                    i4 = (int) (i4 * 0.68f);
                } else {
                    i4 = (int) (i7 * eTv);
                }
            }
            i6 = iArr[0] > 0 ? (iArr[1] * i4) / iArr[0] : i8;
        }
        if (imageView instanceof TbImageView) {
            TbImageView tbImageView = (TbImageView) imageView;
            tbImageView.setDefaultResource(this.eRI.eTD);
            if (tbImageView.getGifIconWidth() >= i4 || tbImageView.getGifIconHeight() >= i6) {
                tbImageView.setGifIconSupport(false);
            } else {
                tbImageView.setGifIconSupport(true);
            }
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i4, i6);
        if (this.eRI.eTJ) {
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        } else {
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        }
        imageView.setClickable(true);
        imageView.setFocusable(false);
        if (this.euG != null && (imageView instanceof TbImageView)) {
            ((TbImageView) imageView).setTbGestureDetector(this.eMT);
            imageView.setClickable(true);
        } else {
            imageView.setOnClickListener(onClickListener);
        }
        imageView.setLayoutParams(layoutParams);
        if (imageView instanceof TbImageView) {
            if (this.onLongClickListener != null) {
                ((TbImageView) imageView).setDispatchTouchListener(this.eVx);
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
        if (this.eRI.eTJ && i4 > i8 && eTv > 1.0f) {
            if (i8 * eTv > i4) {
                i8 = (i4 - l.getDimens(getContext(), R.dimen.ds78)) - l.getDimens(getContext(), R.dimen.ds16);
            } else if (i8 * eTv > i4 * 0.68f) {
                i8 = ((int) (i4 * 0.68f)) - l.getDimens(getContext(), R.dimen.ds78);
            } else {
                i8 = (int) (i8 * eTv);
            }
            if (iArr[0] > 0) {
                i6 = (iArr[1] * i8) / iArr[0];
                i7 = i8;
                if (imageView instanceof TbImageView) {
                    TbImageView tbImageView = (TbImageView) imageView;
                    tbImageView.setDefaultResource(this.eRI.eTD);
                    if (tbImageView.getGifIconWidth() >= i7 || tbImageView.getGifIconHeight() >= i6) {
                        tbImageView.setGifIconSupport(false);
                    } else {
                        tbImageView.setGifIconSupport(true);
                    }
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i7, i6);
                if (!this.eRI.eTJ) {
                    imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                } else {
                    imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                }
                imageView.setClickable(true);
                imageView.setFocusable(false);
                if (this.euG == null && (imageView instanceof TbImageView)) {
                    ((TbImageView) imageView).setTbGestureDetector(this.eMT);
                    imageView.setClickable(true);
                } else {
                    imageView.setOnClickListener(onClickListener);
                }
                imageView.setLayoutParams(layoutParams);
                if (!(imageView instanceof TbImageView)) {
                    if (this.onLongClickListener != null) {
                        ((TbImageView) imageView).setDispatchTouchListener(this.eVx);
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
        if (!this.eRI.eTJ) {
        }
        imageView.setClickable(true);
        imageView.setFocusable(false);
        if (this.euG == null) {
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
            if (!this.eRI.eTJ || i4 <= i6 || eTv <= 1.0f) {
                i4 = i6;
            } else {
                if (i6 * eTv <= i4) {
                    if (i6 * eTv > i4 * 0.68f) {
                        i4 = (int) (i4 * 0.68f);
                    } else {
                        i4 = (int) (i6 * eTv);
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
            if (this.eRI.eTJ && i4 > i8 && eTv > 1.0f) {
                if (i8 * eTv > i4) {
                    i7 = (i4 - l.getDimens(getContext(), R.dimen.ds78)) - l.getDimens(getContext(), R.dimen.ds16);
                } else if (i8 * eTv > i4 * 0.68f) {
                    i7 = ((int) (i4 * 0.68f)) - l.getDimens(getContext(), R.dimen.ds78);
                } else {
                    i7 = (int) (i8 * eTv);
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
        if (this.eRI.eTE <= 0 || tbRichTextData == null) {
            return null;
        }
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setTag("VideoView");
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = this.eRI.eTy;
        linearLayout.setClickable(true);
        Bitmap bitmap = ao.getBitmap(this.eRI.eTE);
        if (bitmap != null) {
            linearLayout.setBackgroundDrawable(new BitmapDrawable(getContext().getResources(), bitmap));
        }
        linearLayout.setFocusable(false);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (tbRichTextData.boQ() != null) {
                    if (TbRichTextView.this.getContext() instanceof com.baidu.tbadk.widget.richText.i) {
                        ((com.baidu.tbadk.widget.richText.i) TbRichTextView.this.getContext()).an(TbRichTextView.this.getContext(), tbRichTextData.boQ().toString());
                        return;
                    }
                    com.baidu.adp.base.e<?> G = com.baidu.adp.base.i.G(TbRichTextView.this.getContext());
                    if (G != null && (G.getOrignalPage() instanceof com.baidu.tbadk.widget.richText.i)) {
                        ((com.baidu.tbadk.widget.richText.i) G.getOrignalPage()).an(TbRichTextView.this.getContext(), tbRichTextData.boQ().toString());
                    }
                }
            }
        });
        return linearLayout;
    }

    private ImageView ei(Context context) {
        ImageView borrowObject = this.eRG != null ? this.eRG.borrowObject() : null;
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
        TbRichTextLinkImageInfo boX = tbRichTextData.boX();
        if (boX != null && boX.getLink() != null) {
            if (imageView instanceof TbImageView) {
                TbImageView tbImageView = (TbImageView) imageView;
                if (this.eRI.eTI) {
                    tbImageView.setSupportNoImage(true);
                }
                tbImageView.startLoad(boX.bps(), this.mIsFromCDN ? 17 : 18, false);
                tbImageView.setTag(new e(boX.getLink()));
                if (!boX.bpg()) {
                    tbImageView.setAdjustViewBounds(false);
                }
            }
            return b(imageView, boX.getWidth(), boX.getHeight(), i2, i3, this.eVw);
        }
        return false;
    }

    private boolean b(TbRichTextData tbRichTextData, ImageView imageView, int i2, int i3) {
        if (tbRichTextData == null || imageView == null) {
            return false;
        }
        if (tbRichTextData.boV() == null) {
            return false;
        }
        if (imageView instanceof TbImageView) {
            TbImageView tbImageView = (TbImageView) imageView;
            tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
            tbImageView.setBorderColor(ao.getColor(R.color.cp_border_a));
            tbImageView.setBorderSurroundContent(true);
            tbImageView.setDrawCorner(true);
            tbImageView.setDrawBorder(true);
            tbImageView.setLongIconSupport(true);
            tbImageView.setGifIconSupport(true);
            tbImageView.setConrers(15);
            tbImageView.setRadius(this.eRN);
            if (this.eVt) {
                tbImageView.setPlaceHolder(2);
            } else {
                tbImageView.setPlaceHolder(3);
            }
            if (this.eRI.eTI) {
                tbImageView.setSupportNoImage(true);
            }
            tbImageView.startLoad(tbRichTextData.boV().memeInfo.pic_url, this.mIsFromCDN ? 17 : 18, false);
            tbImageView.setAdjustViewBounds(false);
            tbImageView.setTag(R.id.tag_rich_text_meme_info, tbRichTextData.boV());
        }
        return b(imageView, tbRichTextData.boV().memeInfo.width.intValue(), tbRichTextData.boV().memeInfo.height.intValue(), i2, i3, this.mOnClickListener);
    }

    private boolean a(TbRichTextData tbRichTextData, ImageView imageView, int i2, int i3, boolean z) {
        if (tbRichTextData == null || imageView == null) {
            return false;
        }
        if (tbRichTextData.boP() == null) {
            return false;
        }
        if (imageView instanceof TbImageView) {
            TbImageView tbImageView = (TbImageView) imageView;
            tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
            tbImageView.setBorderColor(ao.getColor(R.color.cp_border_a));
            tbImageView.setBorderSurroundContent(true);
            tbImageView.setDrawCorner(true);
            tbImageView.setDrawBorder(true);
            tbImageView.setLongIconSupport(true);
            tbImageView.setGifIconSupport(true);
            tbImageView.setTLIconType(tbRichTextData.getIconType());
            tbImageView.setConrers(15);
            tbImageView.setRadius(this.eRN);
            if (this.eVt) {
                tbImageView.setPlaceHolder(2);
            } else {
                tbImageView.setPlaceHolder(3);
            }
            if (this.eRI.eTI) {
                tbImageView.setSupportNoImage(true);
            }
            String bpb = this.eRI.boI() ? tbRichTextData.boP().bpb() : tbRichTextData.boP().bpe();
            if (!z || tbImageView.getUrl() == null || !tbImageView.getUrl().equals(bpb)) {
                tbImageView.startLoad(bpb, this.mIsFromCDN ? 17 : 18, false);
            }
            if (!tbRichTextData.boP().bpg()) {
                tbImageView.setAdjustViewBounds(false);
            }
            tbImageView.setTag(R.id.tag_rich_text_meme_info, null);
        }
        return a(imageView, tbRichTextData.boP().getWidth(), tbRichTextData.boP().getHeight(), i2, i3, this.mOnClickListener);
    }

    private TextView ej(Context context) {
        TextView textView = null;
        if (this.eUX != null) {
            textView = this.eUX.borrowObject();
        }
        if (textView == null || textView.getParent() != null) {
            textView = new TbListTextView(context);
        }
        textView.setPadding(this.eRI.efu, 0, this.eRI.efu, 0);
        return textView;
    }

    private boolean a(TbRichTextData tbRichTextData, TextView textView, boolean z, c cVar) {
        LinearLayout.LayoutParams layoutParams;
        if (z) {
            layoutParams = new LinearLayout.LayoutParams(-1, -2);
        } else {
            layoutParams = new LinearLayout.LayoutParams(-2, -2);
        }
        if (this.eVp) {
            layoutParams.gravity = 16;
            textView.setGravity(16);
        } else {
            layoutParams.topMargin = this.eRI.eTy;
        }
        textView.setLineSpacing(this.eRI.eTx, this.eRI.eTw);
        textView.setTextSize(0, this.eRI.mTextSize);
        textView.setTextColor(this.eRI.mTextColor);
        textView.setLinkTextColor(ao.getColor(R.color.cp_link_tip_c));
        textView.setHighlightColor(getContext().getResources().getColor(R.color.transparent));
        textView.setSingleLine(this.eRI.eTF);
        if (this.eVc != null) {
            textView.setEllipsize(this.eVc);
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
        SpannableStringBuilder boQ = tbRichTextData.boQ();
        if (boQ == null || boQ.length() <= 0) {
            return false;
        }
        if (this.eRI.eTA > 0 && this.eRI.eTz > 0) {
            tbRichTextData.bk(this.eRI.eTz, this.eRI.eTA);
        }
        if (cVar != null) {
            cVar.a(boQ, textView, this);
        }
        try {
            textView.setText(boQ);
        } catch (Exception e2) {
            textView.setText("");
        }
        if (this.eVq) {
            if (tbRichTextData.boZ()) {
                textView.setMovementMethod(com.baidu.tieba.view.c.dtD());
            } else {
                textView.setMovementMethod(LinkMovementMethod.getInstance());
            }
        }
        textView.setFocusable(false);
        textView.setLayoutParams(layoutParams);
        textView.setTag(tbRichTextData);
        if (tbRichTextData != null && tbRichTextData.boS() != null) {
            tbRichTextData.boS().needRecompute = this.eVy;
        }
        return true;
    }

    private GifView getGifView() {
        GifView gifView = null;
        if (this.eRH != null) {
            gifView = this.eRH.borrowObject();
        }
        GifView gifView2 = (gifView == null || gifView.getParent() != null) ? new GifView(getContext()) : gifView;
        gifView2.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        gifView2.setBorderColor(ao.getColor(R.color.cp_border_a));
        gifView2.setBorderSurroundContent(true);
        gifView2.setDrawCorner(true);
        gifView2.setDrawBorder(true);
        gifView2.setConrers(15);
        gifView2.setDrawBorder(true);
        gifView2.setRadius(this.eRN);
        if (this.eVt) {
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
        if (layoutParams == null || layoutParams.width != tbRichTextData.boU().mGifInfo.mGifWidth || layoutParams.height != tbRichTextData.boU().mGifInfo.mGifHeight) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(tbRichTextData.boU().mGifInfo.mGifWidth, tbRichTextData.boU().mGifInfo.mGifHeight);
            layoutParams2.gravity = 3;
            gifView.setLayoutParams(layoutParams2);
        } else {
            layoutParams.bottomMargin = 0;
        }
        gifView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (TbRichTextView.this.eVn != null) {
                    TbRichTextEmotionInfo boU = tbRichTextData.boU();
                    TbRichTextView.this.eVn.a(view, boU.mGifInfo.mGid, boU.mGifInfo.mPackageName, boU.mGifInfo.mIcon, boU.mGifInfo.mStaticUrl, boU.mGifInfo.mDynamicUrl, boU.mGifInfo.mSharpText, boU.mGifInfo.mGifWidth, boU.mGifInfo.mGifHeight);
                }
            }
        });
        gifView.a(tbRichTextData.boU().mGifInfo);
        return true;
    }

    private boolean a(TbRichTextData tbRichTextData, GifView gifView, boolean z) {
        if (gifView == null) {
            return false;
        }
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            gifView.setDefaultNoImageDay(ao.c(getContext().getResources(), R.drawable.icon_click));
        } else {
            gifView.setDefaultNoImageDay(R.drawable.icon_click);
        }
        Drawable drawable = ao.getDrawable(R.color.cp_bg_line_j);
        if (drawable != null) {
            gifView.setBackgroundDrawable(drawable);
        } else {
            gifView.setBackgroundDrawable(ao.getDrawable(R.color.common_color_10220));
        }
        String bpf = tbRichTextData.boP().bpf();
        if (StringUtils.isNull(bpf)) {
            if (this.eRI.eTT) {
                bpf = this.eRI.mIsFromCDN ? tbRichTextData.boP().bpb() : tbRichTextData.boP().bpd();
            }
            if (StringUtils.isNull(bpf)) {
                bpf = this.eRI.mIsFromCDN ? tbRichTextData.boP().bpe() : tbRichTextData.boP().getSrc();
            }
        }
        gifView.setShowStaticDrawable(false);
        if (!z || gifView.getUrl() == null || !gifView.getUrl().equals(bpf)) {
            gifView.ap(bpf, 38);
        }
        return a(gifView, tbRichTextData.boP().getWidth(), tbRichTextData.boP().getHeight(), this.eRI.eTB, this.eRI.eTC, this.mOnClickListener);
    }

    private View bw(View view) {
        View borrowObject = this.eUY != null ? this.eUY.borrowObject() : null;
        if ((borrowObject == null || borrowObject.getParent() != null) && this.eVi != -1) {
            borrowObject = LayoutInflater.from(getContext()).inflate(this.eVi, (ViewGroup) null);
        }
        if (borrowObject != null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            if ((view instanceof TbListTextView) && this.eRI.eTM >= 0) {
                layoutParams.topMargin = this.eRI.eTM;
            } else {
                layoutParams.topMargin = this.eRI.eTy;
            }
            layoutParams.bottomMargin = this.eRI.eTO;
            borrowObject.setLayoutParams(layoutParams);
            if (borrowObject instanceof PlayVoiceBntNew) {
                ((PlayVoiceBntNew) borrowObject).setAfterClickListener(this.eVj);
                return borrowObject;
            }
            return borrowObject;
        }
        return null;
    }

    private boolean a(TbRichTextData tbRichTextData, View view) {
        view.setTag(tbRichTextData.boR());
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LinearLayout.LayoutParams(-2, -2);
        }
        view.setLayoutParams(layoutParams);
        return true;
    }

    private View getTextVoiceView() {
        LinearLayout borrowObject = this.eUZ.borrowObject();
        if (borrowObject != null) {
            TextView ej = ej(getContext());
            if (ej == null) {
                this.eUZ.returnObject(borrowObject);
                return null;
            }
            borrowObject.addView(ej);
            View bw = bw(null);
            if (bw == null) {
                this.eUX.returnObject(ej);
                this.eUZ.returnObject(borrowObject);
                return null;
            }
            borrowObject.addView(bw);
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

    private boolean b(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.boY() == null) {
            return false;
        }
        if (this.aer == null) {
            this.aer = new ItemCardView(getContext());
            this.aer.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.14
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                }
            });
        }
        this.aer.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.aer.setData(tbRichTextData.boY(), 17);
        this.aer.onChangeSkinType();
        return true;
    }

    public void setTextSize(float f2) {
        if (f2 != this.eRI.mTextSize) {
            this.eRI.mTextSize = f2;
            this.eRI.eTz = (int) f2;
            this.eRI.eTA = (int) f2;
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
        if (i2 != this.eRI.mTextColor) {
            this.eRI.mTextColor = i2;
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
        if (this.eRI.efu != i2) {
            this.eRI.efu = i2;
            int childCount = getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                if (childAt != null && (childAt instanceof TextView)) {
                    ((TextView) childAt).setPadding(this.eRI.efu, 0, 0, this.eRI.efu);
                }
            }
        }
    }

    public void setLinkTextColor(int i2) {
        if (i2 != this.eRI.eTG) {
            this.eRI.eTG = i2;
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
        this.eVb = z;
    }

    public i getOnImageClickListener() {
        return this.eRR;
    }

    public void setOnImageClickListener(i iVar) {
        this.eRR = iVar;
        if (this.aiR != null) {
            this.aiR.setOnImageClickListener(this.eRR);
        }
    }

    public void setOnImageTouchListener(com.baidu.tieba.pb.a.c cVar) {
        this.euG = cVar;
    }

    public void setOnEmotionClickListener(h hVar) {
        this.eVn = hVar;
    }

    public void setDisplayImage(boolean z, boolean z2) {
        if (this.eVh != z) {
            this.eVh = z;
            if (z2) {
                requestLayout();
            }
            if (!this.eVh && this.eRG != null) {
                this.eRG.clear();
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
        this.eVk = false;
        switch (motionEvent.getAction()) {
            case 1:
            case 3:
                if (!this.mHasPerformedLongPress) {
                    bpF();
                    break;
                }
                break;
        }
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        switch (motionEvent.getAction()) {
            case 0:
                if (!this.eVk) {
                    bpE();
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
        this.eVk = true;
        return super.onTouchEvent(motionEvent);
    }

    private void bpE() {
        this.mHasPerformedLongPress = false;
        if (this.eVl == null) {
            this.eVl = new a();
        }
        postDelayed(this.eVl, ViewConfiguration.getLongPressTimeout());
    }

    private void bpF() {
        if (this.eVl != null) {
            removeCallbacks(this.eVl);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!TbRichTextView.this.eVs && TbRichTextView.this.performLongClick()) {
                TbRichTextView.this.mHasPerformedLongPress = true;
            }
        }
    }

    public void setVoiceViewRes(int i2) {
        this.eVi = i2;
    }

    public void setOnVoiceAfterClickListener(View.OnClickListener onClickListener) {
        this.eVj = onClickListener;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.eVz != drawable) {
            this.eVy = true;
            this.eVz = drawable;
        }
        setText(this.eVo);
        this.eVy = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.eRI != null) {
            this.eRI.release();
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
        this.eVv = fVar;
        AF(str);
    }

    public void AF(String str) {
        BdUniqueId bdUniqueId;
        boolean z;
        if (TextUtils.isEmpty(str)) {
            this.mUrl = str;
            return;
        }
        getContext();
        com.baidu.adp.base.h E = com.baidu.adp.base.i.E(getContext());
        if (E != null) {
            bdUniqueId = E.getUniqueId();
            z = E.isScroll();
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
        com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) com.baidu.adp.lib.e.c.ln().loadResourceFromMemery(this.mUrl, 19, new Object[0]);
        if (aVar != null) {
            h(aVar);
        } else if (z) {
            invalidate();
        } else if (!com.baidu.adp.lib.e.c.ln().ao(19)) {
            invalidate();
        } else {
            com.baidu.adp.lib.e.c.ln().a(this.mUrl, 19, this.dYv, 0, 0, this.mPageId, new Object[0]);
        }
    }

    public void stopLoad() {
        if (!TextUtils.isEmpty(this.mUrl)) {
            com.baidu.adp.lib.e.c.ln().a(this.mUrl, 19, this.dYv);
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
                if (this.eVv != null) {
                    this.eVv.bpI();
                }
            } catch (Exception e2) {
            }
        }
    }

    @Override // com.baidu.adp.newwidget.ImageView.i
    public void refresh() {
        AF(this.mUrl);
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
        return this.eVe;
    }

    public void setOnLinkImageClickListener(j jVar) {
        this.eVe = jVar;
    }

    public void setHasMovementMethod(boolean z) {
        this.eVq = z;
    }

    public void setTextCenter(boolean z) {
        this.eVp = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        boolean eVE;

        private b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class d {
        boolean eVF;

        private d() {
        }
    }

    public com.baidu.tieba.pb.a<ImageView> getRecycleImageViewPool() {
        if (this.eUW == null) {
            this.eUW = new com.baidu.tieba.pb.a<ImageView>(new com.baidu.adp.lib.d.c<ImageView>() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: bpG */
                public ImageView makeObject() {
                    ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(com.baidu.adp.base.i.G(TbRichTextView.this.getContext()).getPageActivity());
                    boolean isShowImages = com.baidu.tbadk.core.k.aTv().isShowImages();
                    foreDrawableImageView.setDefaultBg(ao.getDrawable(R.color.common_color_10220));
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
                        if (com.baidu.tbadk.core.k.aTv().isShowImages()) {
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
                /* renamed from: ap */
                public ImageView aq(Object obj) {
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
        return this.eUW;
    }

    public TbRichText getRichText() {
        return this.eVo;
    }

    public void setmGridEmptyClickListener(View.OnClickListener onClickListener) {
        this.eVg = onClickListener;
    }
}
