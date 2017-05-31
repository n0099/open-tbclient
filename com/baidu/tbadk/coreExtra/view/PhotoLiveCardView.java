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
import com.baidu.tieba.card.at;
import com.baidu.tieba.w;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class PhotoLiveCardView extends FrameLayout {
    public int ana;
    private TextView auA;
    private TextView auB;
    private TextView auC;
    private LinearLayout auD;
    private TextView auE;
    private TextView auF;
    private TextView auG;
    private LinearLayout auH;
    private TextView auI;
    private RelativeLayout auJ;
    private TbImageView auK;
    private TextView auL;
    private TextView auM;
    private TextView auN;
    private RelativeLayout auO;
    private TextView auP;
    private TextView auQ;
    private TextView auR;
    private TextView auS;
    private int auT;
    private ArrayList<Integer> auU;
    private int auV;
    private int auW;
    private boolean auX;
    private boolean auY;
    private boolean auZ;
    private a aue;
    private b auf;
    private boolean aug;
    private boolean auh;
    private boolean aui;
    private boolean auj;
    private boolean auk;
    private boolean aul;
    private boolean aum;
    private boolean aun;
    private boolean auo;
    private boolean aup;
    private boolean auq;
    private boolean aur;
    private LinearLayout aus;
    private View aut;
    private HeadImageView auu;
    private FrameLayout auv;
    private LinearLayout auw;
    private TextView aux;
    private TextView auy;
    private TextView auz;
    private boolean ava;
    private int avb;
    private int avc;
    private int avd;
    private int ave;
    private int avf;
    private int avg;
    private int avh;
    private int avi;
    private int avj;
    private int avk;
    private int avl;
    private int avm;
    private int avn;
    private int avo;
    private int avp;
    private String avq;
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

    public PhotoLiveCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aug = true;
        this.auh = true;
        this.aui = true;
        this.auj = true;
        this.auk = true;
        this.aul = true;
        this.aum = false;
        this.aun = false;
        this.auo = false;
        this.aup = false;
        this.auq = false;
        this.aur = false;
        this.auT = 0;
        this.auU = new ArrayList<>();
        this.paddingBottom = 0;
        this.paddingTop = 0;
        this.auV = 0;
        this.auW = 0;
        this.auX = false;
        this.auY = true;
        this.auZ = false;
        this.ava = false;
        this.isGod = false;
        this.ana = 3;
        this.padding = 0;
        this.avb = 0;
        this.avc = 0;
        this.avd = 0;
        this.ave = 0;
        this.avq = "";
        this.context = context;
        this.padding = (int) context.getResources().getDimension(w.f.ds24);
        this.avc = (int) context.getResources().getDimension(w.f.ds100);
        this.avb = (int) context.getResources().getDimension(w.f.ds70);
        this.avd = (int) context.getResources().getDimension(w.f.ds18);
        this.ave = (int) context.getResources().getDimension(w.f.ds4);
        this.avf = (int) context.getResources().getDimension(w.f.ds80);
        this.avg = (int) context.getResources().getDimension(w.f.ds280);
        this.avh = (int) context.getResources().getDimension(w.f.ds170);
        this.avi = (int) context.getResources().getDimension(w.f.ds320);
        this.avj = (int) context.getResources().getDimension(w.f.ds200);
        this.avk = (int) context.getResources().getDimension(w.f.ds60);
        this.avl = (int) context.getResources().getDimension(w.f.ds120);
        this.avm = (int) context.getResources().getDimension(w.f.ds160);
        this.avn = (int) context.getResources().getDimension(w.f.ds220);
        this.avo = (int) context.getResources().getDimension(w.f.ds240);
        this.avp = (int) context.getResources().getDimension(w.f.ds180);
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
        this.aus = (LinearLayout) inflate.findViewById(w.h.pl_card_root);
        this.aut = inflate.findViewById(w.h.author_info);
        this.auD = (LinearLayout) inflate.findViewById(w.h.photo_live_card_title);
        this.auH = (LinearLayout) inflate.findViewById(w.h.photo_live_card_content);
        this.auJ = (RelativeLayout) inflate.findViewById(w.h.photo_live_card_cover_and_expression);
        this.auO = (RelativeLayout) inflate.findViewById(w.h.photo_live_card_bottom);
        AH();
        AI();
        AJ();
        AL();
        AK();
    }

    public void setData(PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            setIsGod(photoLiveCardData);
            c(this.aug, photoLiveCardData);
            b(this.auh, this.aum, photoLiveCardData);
            b(this.aui, photoLiveCardData);
            a(this.auj, this.auk, photoLiveCardData);
            a(this.aul, photoLiveCardData);
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
            if (z && this.auY) {
                if (this.paddingBottom != 0) {
                    this.auJ.setPadding(this.padding, 0, this.padding, (int) this.context.getResources().getDimension(this.paddingBottom));
                    this.paddingBottom = 0;
                } else {
                    this.auJ.setPadding(this.padding, 0, this.padding, 0);
                }
                this.auJ.setVisibility(0);
                setCover(photoLiveCardData.getPhotoLiveCover());
                setExpression(photoLiveCardData);
            } else if (this.auJ != null) {
                this.auJ.setVisibility(8);
            }
        }
    }

    private void a(boolean z, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z) {
                this.auO.setVisibility(0);
                setBaName(photoLiveCardData.getForumName());
                m(photoLiveCardData.buildRefreshTimeWithoutPostNum(), this.aun);
                i(photoLiveCardData.getDiscussNum(), this.auq);
                return;
            }
            this.auO.setVisibility(8);
        }
    }

    private void b(boolean z, boolean z2, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z) {
                this.auD.setVisibility(0);
                if (this.auW != 0) {
                    this.auE.setMaxLines(this.auW);
                } else {
                    this.auE.setMaxLines(2);
                }
                setTitle(photoLiveCardData.getTitle());
                l(photoLiveCardData.buildRefreshTimeWithPostNum(), z2);
                setDeleteButtonVisibility(photoLiveCardData);
                a(this.auE, photoLiveCardData.getThreadId());
                return;
            }
            this.auD.setVisibility(8);
        }
    }

    private void setDeleteButtonVisibility(PhotoLiveCardData photoLiveCardData) {
        if (this.aur) {
            this.auG.setVisibility(0);
            this.auG.setTag(photoLiveCardData);
            return;
        }
        this.auG.setVisibility(8);
    }

    private void b(boolean z, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z) {
                this.auH.setVisibility(0);
                if (this.paddingBottom != 0) {
                    this.auH.setPadding(this.padding, 0, this.padding, (int) this.context.getResources().getDimension(this.paddingBottom));
                    this.paddingBottom = 0;
                } else {
                    this.auH.setPadding(this.padding, 0, this.padding, 0);
                }
                setContent(photoLiveCardData.getContent());
                a(this.auI, photoLiveCardData.getThreadId());
                return;
            }
            this.auH.setVisibility(8);
        }
    }

    private void a(TextView textView, long j) {
        if (textView != null && this.auZ) {
            com.baidu.tieba.tbadkCore.util.r readThreadHistory = TbadkCoreApplication.m9getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.qw(String.valueOf(j))) {
                aq.c(textView, w.e.cp_cont_c, 1);
            } else {
                aq.c(textView, w.e.cp_cont_b, 1);
            }
        }
    }

    private void c(boolean z, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z) {
                this.aut.setVisibility(0);
                if (this.paddingTop != 0) {
                    this.aut.setPadding(0, (int) this.context.getResources().getDimension(this.paddingTop), 0, 0);
                } else {
                    this.aut.setPadding(0, 0, 0, 0);
                }
                ViewGroup.LayoutParams layoutParams = this.auu.getLayoutParams();
                if (this.isGod) {
                    if (layoutParams != null) {
                        layoutParams.height = this.avc;
                        layoutParams.width = this.avc;
                    }
                    if (this.auS == null) {
                        this.auS = new TextView(this.context);
                        this.auS.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
                        this.auS.setEllipsize(TextUtils.TruncateAt.END);
                        this.auS.setTextSize(0, this.avd);
                        aq.i(this.auS, w.e.cp_cont_h);
                        aq.j(this.auS, w.g.icon_shen);
                        this.auS.setSingleLine(true);
                        this.auw.addView(this.auS);
                    }
                    if (photoLiveCardData.getGodInfo() == null || StringUtils.isNull(photoLiveCardData.getGodInfo().intro)) {
                        this.auS.setText(w.l.god_intro_default);
                    } else {
                        this.auS.setText(photoLiveCardData.getGodInfo().intro);
                    }
                } else {
                    this.auw.removeView(this.auS);
                    this.auS = null;
                    if (layoutParams != null) {
                        layoutParams.height = this.avb;
                        layoutParams.width = this.avb;
                    }
                }
                this.auu.setTag(photoLiveCardData);
                eF(photoLiveCardData.getAuthorPortrait());
                setUserName(photoLiveCardData.getAuthorName());
                setNickName(photoLiveCardData.getNickName());
                setFansNum(photoLiveCardData.getFansNum());
                setReplyNum(photoLiveCardData.getDiscussNum());
                setHeadLiveIconInHead(photoLiveCardData.isHeadLive());
                setRefreshTimeInHead(photoLiveCardData.buildRefreshTimeWithoutPostNum());
                setPortraitBackground(photoLiveCardData.isHeadLive());
                return;
            }
            this.auw.removeView(this.auS);
            this.aut.setVisibility(8);
        }
    }

    public void setPortraitBackground(boolean z) {
        if (z) {
            this.auu.setPadding(this.ave, this.ave, this.ave, this.ave);
            if (this.isGod) {
                this.auv.setBackgroundDrawable(aq.getDrawable(w.g.pic_bg_jinbian));
                return;
            } else {
                this.auv.setBackgroundDrawable(aq.getDrawable(w.g.frs_touxiang_jinkuan));
                return;
            }
        }
        this.auv.setBackgroundDrawable(null);
        this.auu.setPadding(0, 0, 0, 0);
    }

    private void AH() {
        if (this.aut != null) {
            this.auu = (HeadImageView) this.aut.findViewById(w.h.author_portrait);
            this.auv = (FrameLayout) this.aut.findViewById(w.h.author_portrait_info);
            this.aux = (TextView) this.aut.findViewById(w.h.author_name);
            this.auy = (TextView) this.aut.findViewById(w.h.nick_name);
            this.auz = (TextView) this.aut.findViewById(w.h.fans_num);
            this.auA = (TextView) this.aut.findViewById(w.h.reply_num);
            this.auB = (TextView) this.aut.findViewById(w.h.headlive_icon);
            this.auC = (TextView) this.aut.findViewById(w.h.refresh_time_in_head);
            this.auw = (LinearLayout) this.aut.findViewById(w.h.author_info_and_time);
            this.auu.setOnClickListener(new s(this));
        }
    }

    private void AI() {
        if (this.auD != null) {
            this.auE = (TextView) this.auD.findViewById(w.h.title);
            this.auF = (TextView) findViewById(w.h.refresh_time_in_title);
            this.auG = (TextView) this.auD.findViewById(w.h.card_delete_in_title);
            this.auG.setOnClickListener(new t(this));
        }
    }

    private void AJ() {
        if (this.auH != null) {
            this.auI = (TextView) this.auH.findViewById(w.h.content);
        }
    }

    private void AK() {
        if (this.auO != null) {
            this.auP = (TextView) this.auO.findViewById(w.h.ba_name);
            this.auQ = (TextView) this.auO.findViewById(w.h.bottom_refresh_time);
            this.auR = (TextView) this.auO.findViewById(w.h.bottom_reply_num);
        }
    }

    private void AL() {
        if (this.auJ != null) {
            this.auK = (TbImageView) this.auJ.findViewById(w.h.live_cover);
            this.auK.setGifIconSupport(false);
            AM();
        }
    }

    private void AM() {
        if (this.auJ != null) {
            this.auL = (TextView) this.auJ.findViewById(w.h.first_style_first_expression);
            this.auM = (TextView) this.auJ.findViewById(w.h.first_style_second_expression);
            this.auN = (TextView) this.auJ.findViewById(w.h.first_style_third_expression);
        }
    }

    private void setExpression(PhotoLiveCardData photoLiveCardData) {
        this.auU.clear();
        AO();
        if (photoLiveCardData != null && photoLiveCardData.getExpressionDatas() != null) {
            int size = photoLiveCardData.getExpressionDatas().size();
            for (int i = 0; i < size && i < 3; i++) {
                int intValue = photoLiveCardData.getShowExpressionViewIndex().get(i).intValue();
                if (intValue >= 0) {
                    a(intValue, photoLiveCardData.getExpressionDatas(), i);
                }
            }
            AN();
        }
    }

    private void AN() {
        if (this.auU.size() != 0) {
            int size = this.auU.size();
            for (int i = 0; i < size; i++) {
                if (this.auU.get(i).intValue() == this.auL.getId()) {
                    this.auL.setVisibility(8);
                } else if (this.auU.get(i).intValue() == this.auM.getId()) {
                    this.auM.setVisibility(8);
                } else if (this.auU.get(i).intValue() == this.auN.getId()) {
                    this.auN.setVisibility(8);
                }
            }
        }
    }

    private void AO() {
        this.auL.setText("");
        this.auM.setText("");
        this.auN.setText("");
        if (this.auL.getVisibility() == 8) {
            this.auL.setVisibility(0);
        }
        if (this.auM.getVisibility() == 8) {
            this.auM.setVisibility(0);
        }
        if (this.auN.getVisibility() == 8) {
            this.auN.setVisibility(0);
        }
        this.auU.add(Integer.valueOf(this.auL.getId()));
        this.auU.add(Integer.valueOf(this.auM.getId()));
        this.auU.add(Integer.valueOf(this.auN.getId()));
    }

    private void a(n nVar, TextView textView) {
        if (nVar != null && textView != null) {
            if (!a(nVar)) {
                textView.setVisibility(8);
                return;
            }
            textView.setVisibility(0);
            textView.setText(nVar.ai(nVar.getLabelName(), String.valueOf(nVar.AA())));
            eh(textView.getId());
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
            switch (this.auT) {
                case 0:
                    a(this.avf, this.avg, this.auL);
                    a(this.avh, this.avi, this.auM);
                    a(this.avj, this.avk, this.auN);
                    break;
                case 1:
                    a(this.avk, this.avl, this.auL);
                    a(this.avm, this.avk, this.auM);
                    a(this.avn, this.avi, this.auN);
                    break;
                case 2:
                    a(this.avk, this.avo, this.auL);
                    a(this.avp, this.avk, this.auM);
                    a(this.avn, this.avi, this.auN);
                    break;
            }
            if (i == 0) {
                a(arrayList.get(i2), this.auL);
            } else if (i == 1) {
                a(arrayList.get(i2), this.auM);
            } else if (i == 2) {
                a(arrayList.get(i2), this.auN);
            }
        }
    }

    private void eh(int i) {
        if (this.auU.size() != 0) {
            int size = this.auU.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.auU.get(i2).intValue() == i) {
                    this.auU.remove(i2);
                    return;
                }
            }
        }
    }

    private boolean a(n nVar) {
        return (nVar == null || StringUtils.isNull(nVar.getLabelName())) ? false : true;
    }

    private void setCover(String str) {
        this.auK.setVisibility(0);
        if (!TextUtils.isEmpty(str)) {
            this.auK.c(str, 10, false);
        } else {
            this.auK.c(null, 10, false);
        }
    }

    private void setBaName(String str) {
        if (TextUtils.isEmpty(str)) {
            this.auP.setText("");
            return;
        }
        String trim = str.trim();
        this.auP.setVisibility(0);
        if (com.baidu.tbadk.util.x.gn(trim) > 12) {
            trim = String.valueOf(com.baidu.tbadk.util.x.d(trim, 0, 12)) + "...";
        }
        this.auP.setText(String.valueOf(trim) + TbadkCoreApplication.m9getInst().getResources().getString(w.l.bar));
    }

    private void setContent(String str) {
        if (TextUtils.isEmpty(str)) {
            this.auI.setText("");
            this.auI.setVisibility(8);
            return;
        }
        this.auI.setVisibility(0);
        this.auI.setText(str);
    }

    private void setTitle(String str) {
        this.avq = str;
        if (this.auV != 0) {
            this.auE.setPadding(0, 0, (int) this.context.getResources().getDimension(this.auV), 0);
            this.auV = 0;
        } else {
            this.auE.setPadding(0, 0, 0, 0);
        }
        if (TextUtils.isEmpty(str)) {
            this.auE.setText("");
            return;
        }
        this.auE.setVisibility(0);
        if (this.auX) {
            if (this.ava) {
                this.auE.setText(at.c(this.context, str, w.l.photo_live_tips));
                return;
            } else {
                this.auE.setText(e(str));
                return;
            }
        }
        this.auE.setText(str);
    }

    public static SpannableStringBuilder e(CharSequence charSequence) {
        if (charSequence == null || charSequence.length() == 0) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(String.valueOf("live") + "space" + ((Object) charSequence));
        Bitmap cM = aq.cM(w.g.icon_zhibo);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(cM);
        int height = cM.getHeight();
        bitmapDrawable.setBounds(0, 0, cM.getWidth(), height);
        spannableStringBuilder.setSpan(new com.baidu.adp.widget.d(bitmapDrawable, 1), 0, "live".length(), 33);
        ColorDrawable colorDrawable = new ColorDrawable();
        colorDrawable.setBounds(0, 0, 10, height);
        spannableStringBuilder.setSpan(new com.baidu.adp.widget.d(colorDrawable, 1), 1, "live".length() + "space".length(), 33);
        return spannableStringBuilder;
    }

    private void eF(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.auu.c(str, 12, false);
        } else {
            this.auu.c(null, 12, false);
        }
    }

    private void setUserName(String str) {
        if (TextUtils.isEmpty(str)) {
            this.aux.setText("");
            return;
        }
        this.aux.setVisibility(0);
        String trim = str.trim();
        if (com.baidu.tbadk.util.x.gn(trim) > 14) {
            trim = String.valueOf(com.baidu.tbadk.util.x.d(trim, 0, 14)) + "...";
        }
        this.aux.setText(trim);
    }

    private void setNickName(String str) {
        if (TextUtils.isEmpty(str)) {
            b(this.auy, this.context.getResources().getString(w.l.fans_default_name));
        } else {
            b(this.auy, str);
        }
    }

    private void b(TextView textView, String str) {
        textView.setText(str);
        Drawable drawable = aq.getDrawable(w.g.icon_fengsi_n);
        drawable.setBounds(0, 0, this.size, this.size);
        textView.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
    }

    private void setFansNum(int i) {
        this.auz.setText(au.x(i));
    }

    private void setReplyNum(int i) {
        b(this.auA, i);
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
            this.auR.setVisibility(0);
            b(this.auR, i);
            return;
        }
        this.auR.setVisibility(8);
    }

    private void setHeadLiveIconInHead(boolean z) {
        if (z && this.aup) {
            this.auB.setVisibility(0);
            aq.j(this.auB, w.g.label_onthelist);
            return;
        }
        this.auB.setVisibility(8);
    }

    private void setRefreshTimeInHead(String str) {
        if (this.auo) {
            this.auC.setVisibility(0);
            this.auC.setText(str);
            return;
        }
        this.auC.setVisibility(8);
        this.auC.setText("");
    }

    private void l(String str, boolean z) {
        if (!z) {
            this.auF.setVisibility(8);
            return;
        }
        this.auF.setVisibility(0);
        this.auF.setText(str);
    }

    private void m(String str, boolean z) {
        if (!z) {
            this.auQ.setVisibility(8);
            return;
        }
        this.auQ.setVisibility(0);
        this.auQ.setText(str);
    }

    public void setShowHead(boolean z) {
        this.aug = z;
    }

    public void setShowTitle(boolean z) {
        this.auh = z;
    }

    public void setShowRefreshTimeInTitle(boolean z) {
        this.aum = z;
    }

    public void setShowContent(boolean z) {
        this.aui = z;
    }

    public void setShowCover(boolean z) {
        this.auj = z;
    }

    public void setShowExpression(boolean z) {
        this.auk = z;
    }

    public void setShowBottom(boolean z) {
        this.aul = z;
    }

    public void setShowRefreshTimeInHead(boolean z) {
        this.auo = z;
    }

    public void setShowHeadLiveIcon(boolean z) {
        this.aup = z;
    }

    public void setShowReplyNumInButtom(boolean z) {
        this.auq = z;
    }

    public void setShowDeleteButtonInTitle(boolean z) {
        this.aur = z;
    }

    public void setChooseStyle(int i) {
        this.auT = i;
    }

    public int getShowStyle() {
        return this.auT;
    }

    public void setShowLiveIcon(boolean z) {
        this.auX = z;
    }

    public void setDeleteButtonClickListener(a aVar) {
        this.aue = aVar;
    }

    public void setPortraitClicklistener(b bVar) {
        this.auf = bVar;
    }

    public void setParentBackground(int i) {
        aq.j(this.aus, i);
    }

    public void setContentPaddingBottom(int i) {
        this.paddingBottom = i;
    }

    public void setHeadPaddingTop(int i) {
        this.paddingTop = i;
    }

    public void setShowImage(boolean z) {
        this.auY = z;
    }

    public void setShowRefreshTimeInButtom(boolean z) {
        this.aun = z;
    }

    public void setTitlePaddingRight(int i) {
        this.auV = i;
    }

    public void setTitleMaxLines(int i) {
        this.auW = i;
    }

    public void setAllowGreyState(boolean z) {
        this.auZ = z;
    }

    public void bm(boolean z) {
        this.ava = z;
    }
}
