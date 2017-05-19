package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.PhotoLiveCardData;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.ap;
import com.baidu.tieba.w;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class PhotoLiveCardView extends FrameLayout {
    public int ane;
    private boolean auA;
    private boolean auB;
    private boolean auC;
    private boolean auD;
    private boolean auE;
    private boolean auF;
    private boolean auG;
    private boolean auH;
    private LinearLayout auI;
    private View auJ;
    private HeadImageView auK;
    private FrameLayout auL;
    private LinearLayout auM;
    private TextView auN;
    private TextView auO;
    private TextView auP;
    private TextView auQ;
    private TextView auR;
    private TextView auS;
    private LinearLayout auT;
    private TextView auU;
    private TextView auV;
    private TextView auW;
    private LinearLayout auX;
    private TextView auY;
    private RelativeLayout auZ;
    private a auu;
    private b auv;
    private boolean auw;
    private boolean aux;
    private boolean auy;
    private boolean auz;
    private int avA;
    private int avB;
    private int avC;
    private int avD;
    private int avE;
    private int avF;
    private String avG;
    private TbImageView ava;
    private TextView avb;
    private TextView avc;
    private TextView avd;
    private RelativeLayout ave;
    private TextView avf;
    private TextView avg;
    private TextView avh;
    private TextView avi;
    private int avj;
    private ArrayList<Integer> avk;
    private int avl;
    private int avm;
    private boolean avn;
    private boolean avo;
    private boolean avp;
    private boolean avq;
    private int avr;
    private int avs;
    private int avt;
    private int avu;
    private int avv;
    private int avw;
    private int avx;
    private int avy;
    private int avz;
    private Context context;
    private boolean isGod;
    private int padding;
    private int paddingBottom;
    private int paddingTop;
    private int size;

    /* loaded from: classes.dex */
    public interface a {
        void onDeleteClick(View view);
    }

    /* loaded from: classes.dex */
    public interface b {
        void onPortraitClick(View view);
    }

    /* JADX DEBUG: Marked for inline */
    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Failed to check method usage
    java.util.ConcurrentModificationException
    	at java.base/java.util.ArrayList$ArrayListSpliterator.forEachRemaining(ArrayList.java:1631)
    	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:509)
    	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:499)
    	at java.base/java.util.stream.ReduceOps$ReduceOp.evaluateSequential(ReduceOps.java:921)
    	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
    	at java.base/java.util.stream.ReferencePipeline.collect(ReferencePipeline.java:682)
    	at jadx.core.codegen.ClassGen.skipMethod(ClassGen.java:332)
    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:298)
    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:272)
    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
    	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
     */
    public static /* synthetic */ a b(PhotoLiveCardView photoLiveCardView) {
        return photoLiveCardView.auu;
    }

    public PhotoLiveCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.auw = true;
        this.aux = true;
        this.auy = true;
        this.auz = true;
        this.auA = true;
        this.auB = true;
        this.auC = false;
        this.auD = false;
        this.auE = false;
        this.auF = false;
        this.auG = false;
        this.auH = false;
        this.avj = 0;
        this.avk = new ArrayList<>();
        this.paddingBottom = 0;
        this.paddingTop = 0;
        this.avl = 0;
        this.avm = 0;
        this.avn = false;
        this.avo = true;
        this.avp = false;
        this.avq = false;
        this.isGod = false;
        this.ane = 3;
        this.padding = 0;
        this.avr = 0;
        this.avs = 0;
        this.avt = 0;
        this.avu = 0;
        this.avG = "";
        this.context = context;
        this.padding = (int) context.getResources().getDimension(w.f.ds24);
        this.avs = (int) context.getResources().getDimension(w.f.ds100);
        this.avr = (int) context.getResources().getDimension(w.f.ds70);
        this.avt = (int) context.getResources().getDimension(w.f.ds18);
        this.avu = (int) context.getResources().getDimension(w.f.ds4);
        this.avv = (int) context.getResources().getDimension(w.f.ds80);
        this.avw = (int) context.getResources().getDimension(w.f.ds280);
        this.avx = (int) context.getResources().getDimension(w.f.ds170);
        this.avy = (int) context.getResources().getDimension(w.f.ds320);
        this.avz = (int) context.getResources().getDimension(w.f.ds200);
        this.avA = (int) context.getResources().getDimension(w.f.ds60);
        this.avB = (int) context.getResources().getDimension(w.f.ds120);
        this.avC = (int) context.getResources().getDimension(w.f.ds160);
        this.avD = (int) context.getResources().getDimension(w.f.ds220);
        this.avE = (int) context.getResources().getDimension(w.f.ds240);
        this.avF = (int) context.getResources().getDimension(w.f.ds180);
        this.size = (int) context.getResources().getDimension(w.f.ds8);
        init(context);
    }

    public PhotoLiveCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PhotoLiveCardView(Context context) {
        this(context, null, 0);
    }

    private void init(Context context) {
        View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(w.j.photo_live_card_view, this);
        this.auI = (LinearLayout) inflate.findViewById(w.h.pl_card_root);
        this.auJ = inflate.findViewById(w.h.author_info);
        this.auT = (LinearLayout) inflate.findViewById(w.h.photo_live_card_title);
        this.auX = (LinearLayout) inflate.findViewById(w.h.photo_live_card_content);
        this.auZ = (RelativeLayout) inflate.findViewById(w.h.photo_live_card_cover_and_expression);
        this.ave = (RelativeLayout) inflate.findViewById(w.h.photo_live_card_bottom);
        AO();
        AP();
        AQ();
        AS();
        AR();
    }

    public void setData(PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            setIsGod(photoLiveCardData);
            c(this.auw, photoLiveCardData);
            b(this.aux, this.auC, photoLiveCardData);
            b(this.auy, photoLiveCardData);
            a(this.auz, this.auA, photoLiveCardData);
            a(this.auB, photoLiveCardData);
        }
    }

    private void setIsGod(PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null && photoLiveCardData.getGodInfo() != null) {
            this.isGod = true;
        } else {
            this.isGod = false;
        }
    }

    private void a(boolean z, boolean z2, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z && this.avo) {
                if (this.paddingBottom != 0) {
                    this.auZ.setPadding(this.padding, 0, this.padding, (int) this.context.getResources().getDimension(this.paddingBottom));
                    this.paddingBottom = 0;
                } else {
                    this.auZ.setPadding(this.padding, 0, this.padding, 0);
                }
                this.auZ.setVisibility(0);
                setCover(photoLiveCardData.getPhotoLiveCover());
                setExpression(photoLiveCardData);
            } else if (this.auZ != null) {
                this.auZ.setVisibility(8);
            }
        }
    }

    private void a(boolean z, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z) {
                this.ave.setVisibility(0);
                setBaName(photoLiveCardData.getForumName());
                p(photoLiveCardData.buildRefreshTimeWithoutPostNum(), this.auD);
                i(photoLiveCardData.getDiscussNum(), this.auG);
                return;
            }
            this.ave.setVisibility(8);
        }
    }

    private void b(boolean z, boolean z2, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z) {
                this.auT.setVisibility(0);
                if (this.avm != 0) {
                    this.auU.setMaxLines(this.avm);
                } else {
                    this.auU.setMaxLines(2);
                }
                setTitle(photoLiveCardData.getTitle());
                o(photoLiveCardData.buildRefreshTimeWithPostNum(), z2);
                setDeleteButtonVisibility(photoLiveCardData);
                a(this.auU, photoLiveCardData.getThreadId());
                return;
            }
            this.auT.setVisibility(8);
        }
    }

    private void setDeleteButtonVisibility(PhotoLiveCardData photoLiveCardData) {
        if (this.auH) {
            this.auW.setVisibility(0);
            this.auW.setTag(photoLiveCardData);
            return;
        }
        this.auW.setVisibility(8);
    }

    private void b(boolean z, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z) {
                this.auX.setVisibility(0);
                if (this.paddingBottom != 0) {
                    this.auX.setPadding(this.padding, 0, this.padding, (int) this.context.getResources().getDimension(this.paddingBottom));
                    this.paddingBottom = 0;
                } else {
                    this.auX.setPadding(this.padding, 0, this.padding, 0);
                }
                setContent(photoLiveCardData.getContent());
                a(this.auY, photoLiveCardData.getThreadId());
                return;
            }
            this.auX.setVisibility(8);
        }
    }

    private void a(TextView textView, long j) {
        if (textView != null && this.avp) {
            com.baidu.tieba.tbadkCore.util.r readThreadHistory = TbadkCoreApplication.m9getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.qi(String.valueOf(j))) {
                aq.c(textView, w.e.cp_cont_c, 1);
            } else {
                aq.c(textView, w.e.cp_cont_b, 1);
            }
        }
    }

    private void c(boolean z, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z) {
                this.auJ.setVisibility(0);
                if (this.paddingTop != 0) {
                    this.auJ.setPadding(0, (int) this.context.getResources().getDimension(this.paddingTop), 0, 0);
                } else {
                    this.auJ.setPadding(0, 0, 0, 0);
                }
                ViewGroup.LayoutParams layoutParams = this.auK.getLayoutParams();
                if (this.isGod) {
                    if (layoutParams != null) {
                        layoutParams.height = this.avs;
                        layoutParams.width = this.avs;
                    }
                    if (this.avi == null) {
                        this.avi = new TextView(this.context);
                        this.avi.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
                        this.avi.setEllipsize(TextUtils.TruncateAt.END);
                        this.avi.setTextSize(0, this.avt);
                        aq.i(this.avi, w.e.cp_cont_h);
                        aq.j(this.avi, w.g.icon_shen);
                        this.avi.setSingleLine(true);
                        this.auM.addView(this.avi);
                    }
                    if (photoLiveCardData.getGodInfo() == null || StringUtils.isNull(photoLiveCardData.getGodInfo().intro)) {
                        this.avi.setText(w.l.god_intro_default);
                    } else {
                        this.avi.setText(photoLiveCardData.getGodInfo().intro);
                    }
                } else {
                    this.auM.removeView(this.avi);
                    this.avi = null;
                    if (layoutParams != null) {
                        layoutParams.height = this.avr;
                        layoutParams.width = this.avr;
                    }
                }
                this.auK.setTag(photoLiveCardData);
                eH(photoLiveCardData.getAuthorPortrait());
                setUserName(photoLiveCardData.getAuthorName());
                setNickName(photoLiveCardData.getNickName());
                setFansNum(photoLiveCardData.getFansNum());
                setReplyNum(photoLiveCardData.getDiscussNum());
                setHeadLiveIconInHead(photoLiveCardData.isHeadLive());
                setRefreshTimeInHead(photoLiveCardData.buildRefreshTimeWithoutPostNum());
                setPortraitBackground(photoLiveCardData.isHeadLive());
                return;
            }
            this.auM.removeView(this.avi);
            this.auJ.setVisibility(8);
        }
    }

    public void setPortraitBackground(boolean z) {
        if (z) {
            this.auK.setPadding(this.avu, this.avu, this.avu, this.avu);
            if (this.isGod) {
                this.auL.setBackgroundDrawable(aq.getDrawable(w.g.pic_bg_jinbian));
                return;
            } else {
                this.auL.setBackgroundDrawable(aq.getDrawable(w.g.frs_touxiang_jinkuan));
                return;
            }
        }
        this.auL.setBackgroundDrawable(null);
        this.auK.setPadding(0, 0, 0, 0);
    }

    private void AO() {
        if (this.auJ != null) {
            this.auK = (HeadImageView) this.auJ.findViewById(w.h.author_portrait);
            this.auL = (FrameLayout) this.auJ.findViewById(w.h.author_portrait_info);
            this.auN = (TextView) this.auJ.findViewById(w.h.author_name);
            this.auO = (TextView) this.auJ.findViewById(w.h.nick_name);
            this.auP = (TextView) this.auJ.findViewById(w.h.fans_num);
            this.auQ = (TextView) this.auJ.findViewById(w.h.reply_num);
            this.auR = (TextView) this.auJ.findViewById(w.h.headlive_icon);
            this.auS = (TextView) this.auJ.findViewById(w.h.refresh_time_in_head);
            this.auM = (LinearLayout) this.auJ.findViewById(w.h.author_info_and_time);
            this.auK.setOnClickListener(new s(this));
        }
    }

    private void AP() {
        if (this.auT != null) {
            this.auU = (TextView) this.auT.findViewById(w.h.title);
            this.auV = (TextView) findViewById(w.h.refresh_time_in_title);
            this.auW = (TextView) this.auT.findViewById(w.h.card_delete_in_title);
            this.auW.setOnClickListener(new t(this));
        }
    }

    private void AQ() {
        if (this.auX != null) {
            this.auY = (TextView) this.auX.findViewById(w.h.content);
        }
    }

    private void AR() {
        if (this.ave != null) {
            this.avf = (TextView) this.ave.findViewById(w.h.ba_name);
            this.avg = (TextView) this.ave.findViewById(w.h.bottom_refresh_time);
            this.avh = (TextView) this.ave.findViewById(w.h.bottom_reply_num);
        }
    }

    private void AS() {
        if (this.auZ != null) {
            this.ava = (TbImageView) this.auZ.findViewById(w.h.live_cover);
            this.ava.setGifIconSupport(false);
            AT();
        }
    }

    private void AT() {
        if (this.auZ != null) {
            this.avb = (TextView) this.auZ.findViewById(w.h.first_style_first_expression);
            this.avc = (TextView) this.auZ.findViewById(w.h.first_style_second_expression);
            this.avd = (TextView) this.auZ.findViewById(w.h.first_style_third_expression);
        }
    }

    private void setExpression(PhotoLiveCardData photoLiveCardData) {
        this.avk.clear();
        AV();
        if (photoLiveCardData != null && photoLiveCardData.getExpressionDatas() != null) {
            int size = photoLiveCardData.getExpressionDatas().size();
            for (int i = 0; i < size && i < 3; i++) {
                int intValue = photoLiveCardData.getShowExpressionViewIndex().get(i).intValue();
                if (intValue >= 0) {
                    a(intValue, photoLiveCardData.getExpressionDatas(), i);
                }
            }
            AU();
        }
    }

    private void AU() {
        if (this.avk.size() != 0) {
            int size = this.avk.size();
            for (int i = 0; i < size; i++) {
                if (this.avk.get(i).intValue() == this.avb.getId()) {
                    this.avb.setVisibility(8);
                } else if (this.avk.get(i).intValue() == this.avc.getId()) {
                    this.avc.setVisibility(8);
                } else if (this.avk.get(i).intValue() == this.avd.getId()) {
                    this.avd.setVisibility(8);
                }
            }
        }
    }

    private void AV() {
        this.avb.setText("");
        this.avc.setText("");
        this.avd.setText("");
        if (this.avb.getVisibility() == 8) {
            this.avb.setVisibility(0);
        }
        if (this.avc.getVisibility() == 8) {
            this.avc.setVisibility(0);
        }
        if (this.avd.getVisibility() == 8) {
            this.avd.setVisibility(0);
        }
        this.avk.add(Integer.valueOf(this.avb.getId()));
        this.avk.add(Integer.valueOf(this.avc.getId()));
        this.avk.add(Integer.valueOf(this.avd.getId()));
    }

    private void a(n nVar, TextView textView) {
        if (nVar != null && textView != null) {
            if (!a(nVar)) {
                textView.setVisibility(8);
                return;
            }
            textView.setVisibility(0);
            textView.setText(nVar.aj(nVar.getLabelName(), String.valueOf(nVar.AH())));
            eg(textView.getId());
        }
    }

    private void a(int i, int i2, TextView textView) {
        if (textView != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) textView.getLayoutParams();
            marginLayoutParams.topMargin = i;
            marginLayoutParams.rightMargin = i2;
        }
    }

    private void a(int i, ArrayList<n> arrayList, int i2) {
        if (i >= 0 && i < 3) {
            switch (this.avj) {
                case 0:
                    a(this.avv, this.avw, this.avb);
                    a(this.avx, this.avy, this.avc);
                    a(this.avz, this.avA, this.avd);
                    break;
                case 1:
                    a(this.avA, this.avB, this.avb);
                    a(this.avC, this.avA, this.avc);
                    a(this.avD, this.avy, this.avd);
                    break;
                case 2:
                    a(this.avA, this.avE, this.avb);
                    a(this.avF, this.avA, this.avc);
                    a(this.avD, this.avy, this.avd);
                    break;
            }
            if (i == 0) {
                a(arrayList.get(i2), this.avb);
            } else if (i == 1) {
                a(arrayList.get(i2), this.avc);
            } else if (i == 2) {
                a(arrayList.get(i2), this.avd);
            }
        }
    }

    private void eg(int i) {
        if (this.avk.size() != 0) {
            int size = this.avk.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.avk.get(i2).intValue() == i) {
                    this.avk.remove(i2);
                    return;
                }
            }
        }
    }

    private boolean a(n nVar) {
        return (nVar == null || StringUtils.isNull(nVar.getLabelName())) ? false : true;
    }

    private void setCover(String str) {
        this.ava.setVisibility(0);
        if (!TextUtils.isEmpty(str)) {
            this.ava.c(str, 10, false);
        } else {
            this.ava.c(null, 10, false);
        }
    }

    private void setBaName(String str) {
        if (TextUtils.isEmpty(str)) {
            this.avf.setText("");
            return;
        }
        String trim = str.trim();
        this.avf.setVisibility(0);
        if (com.baidu.tbadk.util.x.go(trim) > 12) {
            trim = String.valueOf(com.baidu.tbadk.util.x.d(trim, 0, 12)) + "...";
        }
        this.avf.setText(String.valueOf(trim) + TbadkCoreApplication.m9getInst().getResources().getString(w.l.bar));
    }

    private void setContent(String str) {
        if (TextUtils.isEmpty(str)) {
            this.auY.setText("");
            this.auY.setVisibility(8);
            return;
        }
        this.auY.setVisibility(0);
        this.auY.setText(str);
    }

    private void setTitle(String str) {
        this.avG = str;
        if (this.avl != 0) {
            this.auU.setPadding(0, 0, (int) this.context.getResources().getDimension(this.avl), 0);
            this.avl = 0;
        } else {
            this.auU.setPadding(0, 0, 0, 0);
        }
        if (TextUtils.isEmpty(str)) {
            this.auU.setText("");
            return;
        }
        this.auU.setVisibility(0);
        if (this.avn) {
            if (this.avq) {
                this.auU.setText(ap.c(this.context, str, w.l.photo_live_tips));
                return;
            } else {
                this.auU.setText(e(str));
                return;
            }
        }
        this.auU.setText(str);
    }

    public static SpannableStringBuilder e(CharSequence charSequence) {
        if (charSequence == null || charSequence.length() == 0) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(String.valueOf("live") + "space" + ((Object) charSequence));
        Bitmap cL = aq.cL(w.g.icon_zhibo);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(cL);
        int height = cL.getHeight();
        bitmapDrawable.setBounds(0, 0, cL.getWidth(), height);
        spannableStringBuilder.setSpan(new com.baidu.adp.widget.d(bitmapDrawable, 1), 0, "live".length(), 33);
        ColorDrawable colorDrawable = new ColorDrawable();
        colorDrawable.setBounds(0, 0, 10, height);
        spannableStringBuilder.setSpan(new com.baidu.adp.widget.d(colorDrawable, 1), 1, "live".length() + "space".length(), 33);
        return spannableStringBuilder;
    }

    private void eH(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.auK.c(str, 12, false);
        } else {
            this.auK.c(null, 12, false);
        }
    }

    private void setUserName(String str) {
        if (TextUtils.isEmpty(str)) {
            this.auN.setText("");
            return;
        }
        this.auN.setVisibility(0);
        String trim = str.trim();
        if (com.baidu.tbadk.util.x.go(trim) > 14) {
            trim = String.valueOf(com.baidu.tbadk.util.x.d(trim, 0, 14)) + "...";
        }
        this.auN.setText(trim);
    }

    private void setNickName(String str) {
        if (TextUtils.isEmpty(str)) {
            b(this.auO, this.context.getResources().getString(w.l.fans_default_name));
        } else {
            b(this.auO, str);
        }
    }

    private void b(TextView textView, String str) {
        textView.setText(str);
        Drawable drawable = aq.getDrawable(w.g.icon_fengsi_n);
        drawable.setBounds(0, 0, this.size, this.size);
        textView.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
    }

    private void setFansNum(int i) {
        this.auP.setText(au.x(i));
    }

    private void setReplyNum(int i) {
        b(this.auQ, i);
    }

    private void b(TextView textView, long j) {
        if (j <= 0) {
            textView.setText("");
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            return;
        }
        textView.setText(au.x(j));
        Drawable drawable = aq.getDrawable(w.g.icon_comment_n);
        drawable.setBounds(0, 0, this.size, this.size);
        textView.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
    }

    private void i(int i, boolean z) {
        if (z) {
            this.avh.setVisibility(0);
            b(this.avh, i);
            return;
        }
        this.avh.setVisibility(8);
    }

    private void setHeadLiveIconInHead(boolean z) {
        if (z && this.auF) {
            this.auR.setVisibility(0);
            aq.j(this.auR, w.g.label_onthelist);
            return;
        }
        this.auR.setVisibility(8);
    }

    private void setRefreshTimeInHead(String str) {
        if (this.auE) {
            this.auS.setVisibility(0);
            this.auS.setText(str);
            return;
        }
        this.auS.setVisibility(8);
        this.auS.setText("");
    }

    private void o(String str, boolean z) {
        if (!z) {
            this.auV.setVisibility(8);
            return;
        }
        this.auV.setVisibility(0);
        this.auV.setText(str);
    }

    private void p(String str, boolean z) {
        if (!z) {
            this.avg.setVisibility(8);
            return;
        }
        this.avg.setVisibility(0);
        this.avg.setText(str);
    }

    public void setShowHead(boolean z) {
        this.auw = z;
    }

    public void setShowTitle(boolean z) {
        this.aux = z;
    }

    public void setShowRefreshTimeInTitle(boolean z) {
        this.auC = z;
    }

    public void setShowContent(boolean z) {
        this.auy = z;
    }

    public void setShowCover(boolean z) {
        this.auz = z;
    }

    public void setShowExpression(boolean z) {
        this.auA = z;
    }

    public void setShowBottom(boolean z) {
        this.auB = z;
    }

    public void setShowRefreshTimeInHead(boolean z) {
        this.auE = z;
    }

    public void setShowHeadLiveIcon(boolean z) {
        this.auF = z;
    }

    public void setShowReplyNumInButtom(boolean z) {
        this.auG = z;
    }

    public void setShowDeleteButtonInTitle(boolean z) {
        this.auH = z;
    }

    public void setChooseStyle(int i) {
        this.avj = i;
    }

    public int getShowStyle() {
        return this.avj;
    }

    public void setShowLiveIcon(boolean z) {
        this.avn = z;
    }

    public void setDeleteButtonClickListener(a aVar) {
        this.auu = aVar;
    }

    public void setPortraitClicklistener(b bVar) {
        this.auv = bVar;
    }

    public void setParentBackground(int i) {
        aq.j(this.auI, i);
    }

    public void setContentPaddingBottom(int i) {
        this.paddingBottom = i;
    }

    public void setHeadPaddingTop(int i) {
        this.paddingTop = i;
    }

    public void setShowImage(boolean z) {
        this.avo = z;
    }

    public void setShowRefreshTimeInButtom(boolean z) {
        this.auD = z;
    }

    public void setTitlePaddingRight(int i) {
        this.avl = i;
    }

    public void setTitleMaxLines(int i) {
        this.avm = i;
    }

    public void setAllowGreyState(boolean z) {
        this.avp = z;
    }

    public void bp(boolean z) {
        this.avq = z;
    }
}
