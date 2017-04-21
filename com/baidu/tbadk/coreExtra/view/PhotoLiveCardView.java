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
    public int amZ;
    private boolean auA;
    private boolean auB;
    private boolean auC;
    private boolean auD;
    private LinearLayout auE;
    private View auF;
    private HeadImageView auG;
    private FrameLayout auH;
    private LinearLayout auI;
    private TextView auJ;
    private TextView auK;
    private TextView auL;
    private TextView auM;
    private TextView auN;
    private TextView auO;
    private LinearLayout auP;
    private TextView auQ;
    private TextView auR;
    private TextView auS;
    private LinearLayout auT;
    private TextView auU;
    private RelativeLayout auV;
    private TbImageView auW;
    private TextView auX;
    private TextView auY;
    private TextView auZ;
    private a auq;
    private b aur;
    private boolean aus;
    private boolean aut;
    private boolean auu;
    private boolean auv;
    private boolean auw;
    private boolean aux;
    private boolean auy;
    private boolean auz;
    private int avA;
    private int avB;
    private String avC;
    private RelativeLayout ava;
    private TextView avb;
    private TextView avc;
    private TextView avd;
    private TextView ave;
    private int avf;
    private ArrayList<Integer> avg;
    private int avh;
    private int avi;
    private boolean avj;
    private boolean avk;
    private boolean avl;
    private boolean avm;
    private int avn;
    private int avo;
    private int avp;
    private int avq;
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

    public PhotoLiveCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aus = true;
        this.aut = true;
        this.auu = true;
        this.auv = true;
        this.auw = true;
        this.aux = true;
        this.auy = false;
        this.auz = false;
        this.auA = false;
        this.auB = false;
        this.auC = false;
        this.auD = false;
        this.avf = 0;
        this.avg = new ArrayList<>();
        this.paddingBottom = 0;
        this.paddingTop = 0;
        this.avh = 0;
        this.avi = 0;
        this.avj = false;
        this.avk = true;
        this.avl = false;
        this.avm = false;
        this.isGod = false;
        this.amZ = 3;
        this.padding = 0;
        this.avn = 0;
        this.avo = 0;
        this.avp = 0;
        this.avq = 0;
        this.avC = "";
        this.context = context;
        this.padding = (int) context.getResources().getDimension(w.f.ds24);
        this.avo = (int) context.getResources().getDimension(w.f.ds100);
        this.avn = (int) context.getResources().getDimension(w.f.ds70);
        this.avp = (int) context.getResources().getDimension(w.f.ds18);
        this.avq = (int) context.getResources().getDimension(w.f.ds4);
        this.avr = (int) context.getResources().getDimension(w.f.ds80);
        this.avs = (int) context.getResources().getDimension(w.f.ds280);
        this.avt = (int) context.getResources().getDimension(w.f.ds170);
        this.avu = (int) context.getResources().getDimension(w.f.ds320);
        this.avv = (int) context.getResources().getDimension(w.f.ds200);
        this.avw = (int) context.getResources().getDimension(w.f.ds60);
        this.avx = (int) context.getResources().getDimension(w.f.ds120);
        this.avy = (int) context.getResources().getDimension(w.f.ds160);
        this.avz = (int) context.getResources().getDimension(w.f.ds220);
        this.avA = (int) context.getResources().getDimension(w.f.ds240);
        this.avB = (int) context.getResources().getDimension(w.f.ds180);
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
        this.auE = (LinearLayout) inflate.findViewById(w.h.pl_card_root);
        this.auF = inflate.findViewById(w.h.author_info);
        this.auP = (LinearLayout) inflate.findViewById(w.h.photo_live_card_title);
        this.auT = (LinearLayout) inflate.findViewById(w.h.photo_live_card_content);
        this.auV = (RelativeLayout) inflate.findViewById(w.h.photo_live_card_cover_and_expression);
        this.ava = (RelativeLayout) inflate.findViewById(w.h.photo_live_card_bottom);
        BD();
        BE();
        BF();
        BH();
        BG();
    }

    public void setData(PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            setIsGod(photoLiveCardData);
            c(this.aus, photoLiveCardData);
            b(this.aut, this.auy, photoLiveCardData);
            b(this.auu, photoLiveCardData);
            a(this.auv, this.auw, photoLiveCardData);
            a(this.aux, photoLiveCardData);
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
            if (z && this.avk) {
                if (this.paddingBottom != 0) {
                    this.auV.setPadding(this.padding, 0, this.padding, (int) this.context.getResources().getDimension(this.paddingBottom));
                    this.paddingBottom = 0;
                } else {
                    this.auV.setPadding(this.padding, 0, this.padding, 0);
                }
                this.auV.setVisibility(0);
                setCover(photoLiveCardData.getPhotoLiveCover());
                setExpression(photoLiveCardData);
            } else if (this.auV != null) {
                this.auV.setVisibility(8);
            }
        }
    }

    private void a(boolean z, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z) {
                this.ava.setVisibility(0);
                setBaName(photoLiveCardData.getForumName());
                p(photoLiveCardData.buildRefreshTimeWithoutPostNum(), this.auz);
                i(photoLiveCardData.getDiscussNum(), this.auC);
                return;
            }
            this.ava.setVisibility(8);
        }
    }

    private void b(boolean z, boolean z2, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z) {
                this.auP.setVisibility(0);
                if (this.avi != 0) {
                    this.auQ.setMaxLines(this.avi);
                } else {
                    this.auQ.setMaxLines(2);
                }
                setTitle(photoLiveCardData.getTitle());
                o(photoLiveCardData.buildRefreshTimeWithPostNum(), z2);
                setDeleteButtonVisibility(photoLiveCardData);
                a(this.auQ, photoLiveCardData.getThreadId());
                return;
            }
            this.auP.setVisibility(8);
        }
    }

    private void setDeleteButtonVisibility(PhotoLiveCardData photoLiveCardData) {
        if (this.auD) {
            this.auS.setVisibility(0);
            this.auS.setTag(photoLiveCardData);
            return;
        }
        this.auS.setVisibility(8);
    }

    private void b(boolean z, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z) {
                this.auT.setVisibility(0);
                if (this.paddingBottom != 0) {
                    this.auT.setPadding(this.padding, 0, this.padding, (int) this.context.getResources().getDimension(this.paddingBottom));
                    this.paddingBottom = 0;
                } else {
                    this.auT.setPadding(this.padding, 0, this.padding, 0);
                }
                setContent(photoLiveCardData.getContent());
                a(this.auU, photoLiveCardData.getThreadId());
                return;
            }
            this.auT.setVisibility(8);
        }
    }

    private void a(TextView textView, long j) {
        if (textView != null && this.avl) {
            com.baidu.tieba.tbadkCore.util.r readThreadHistory = TbadkCoreApplication.m9getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.qp(String.valueOf(j))) {
                aq.c(textView, w.e.cp_cont_c, 1);
            } else {
                aq.c(textView, w.e.cp_cont_b, 1);
            }
        }
    }

    private void c(boolean z, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z) {
                this.auF.setVisibility(0);
                if (this.paddingTop != 0) {
                    this.auF.setPadding(0, (int) this.context.getResources().getDimension(this.paddingTop), 0, 0);
                } else {
                    this.auF.setPadding(0, 0, 0, 0);
                }
                ViewGroup.LayoutParams layoutParams = this.auG.getLayoutParams();
                if (this.isGod) {
                    if (layoutParams != null) {
                        layoutParams.height = this.avo;
                        layoutParams.width = this.avo;
                    }
                    if (this.ave == null) {
                        this.ave = new TextView(this.context);
                        this.ave.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
                        this.ave.setEllipsize(TextUtils.TruncateAt.END);
                        this.ave.setTextSize(0, this.avp);
                        aq.i(this.ave, w.e.cp_cont_h);
                        aq.j(this.ave, w.g.icon_shen);
                        this.ave.setSingleLine(true);
                        this.auI.addView(this.ave);
                    }
                    if (photoLiveCardData.getGodInfo() == null || StringUtils.isNull(photoLiveCardData.getGodInfo().intro)) {
                        this.ave.setText(w.l.god_intro_default);
                    } else {
                        this.ave.setText(photoLiveCardData.getGodInfo().intro);
                    }
                } else {
                    this.auI.removeView(this.ave);
                    this.ave = null;
                    if (layoutParams != null) {
                        layoutParams.height = this.avn;
                        layoutParams.width = this.avn;
                    }
                }
                this.auG.setTag(photoLiveCardData);
                eI(photoLiveCardData.getAuthorPortrait());
                setUserName(photoLiveCardData.getAuthorName());
                setNickName(photoLiveCardData.getNickName());
                setFansNum(photoLiveCardData.getFansNum());
                setReplyNum(photoLiveCardData.getDiscussNum());
                setHeadLiveIconInHead(photoLiveCardData.isHeadLive());
                setRefreshTimeInHead(photoLiveCardData.buildRefreshTimeWithoutPostNum());
                setPortraitBackground(photoLiveCardData.isHeadLive());
                return;
            }
            this.auI.removeView(this.ave);
            this.auF.setVisibility(8);
        }
    }

    public void setPortraitBackground(boolean z) {
        if (z) {
            this.auG.setPadding(this.avq, this.avq, this.avq, this.avq);
            if (this.isGod) {
                this.auH.setBackgroundDrawable(aq.getDrawable(w.g.pic_bg_jinbian));
                return;
            } else {
                this.auH.setBackgroundDrawable(aq.getDrawable(w.g.frs_touxiang_jinkuan));
                return;
            }
        }
        this.auH.setBackgroundDrawable(null);
        this.auG.setPadding(0, 0, 0, 0);
    }

    private void BD() {
        if (this.auF != null) {
            this.auG = (HeadImageView) this.auF.findViewById(w.h.author_portrait);
            this.auH = (FrameLayout) this.auF.findViewById(w.h.author_portrait_info);
            this.auJ = (TextView) this.auF.findViewById(w.h.author_name);
            this.auK = (TextView) this.auF.findViewById(w.h.nick_name);
            this.auL = (TextView) this.auF.findViewById(w.h.fans_num);
            this.auM = (TextView) this.auF.findViewById(w.h.reply_num);
            this.auN = (TextView) this.auF.findViewById(w.h.headlive_icon);
            this.auO = (TextView) this.auF.findViewById(w.h.refresh_time_in_head);
            this.auI = (LinearLayout) this.auF.findViewById(w.h.author_info_and_time);
            this.auG.setOnClickListener(new s(this));
        }
    }

    private void BE() {
        if (this.auP != null) {
            this.auQ = (TextView) this.auP.findViewById(w.h.title);
            this.auR = (TextView) findViewById(w.h.refresh_time_in_title);
            this.auS = (TextView) this.auP.findViewById(w.h.card_delete_in_title);
            this.auS.setOnClickListener(new t(this));
        }
    }

    private void BF() {
        if (this.auT != null) {
            this.auU = (TextView) this.auT.findViewById(w.h.content);
        }
    }

    private void BG() {
        if (this.ava != null) {
            this.avb = (TextView) this.ava.findViewById(w.h.ba_name);
            this.avc = (TextView) this.ava.findViewById(w.h.bottom_refresh_time);
            this.avd = (TextView) this.ava.findViewById(w.h.bottom_reply_num);
        }
    }

    private void BH() {
        if (this.auV != null) {
            this.auW = (TbImageView) this.auV.findViewById(w.h.live_cover);
            this.auW.setGifIconSupport(false);
            BI();
        }
    }

    private void BI() {
        if (this.auV != null) {
            this.auX = (TextView) this.auV.findViewById(w.h.first_style_first_expression);
            this.auY = (TextView) this.auV.findViewById(w.h.first_style_second_expression);
            this.auZ = (TextView) this.auV.findViewById(w.h.first_style_third_expression);
        }
    }

    private void setExpression(PhotoLiveCardData photoLiveCardData) {
        this.avg.clear();
        BK();
        if (photoLiveCardData != null && photoLiveCardData.getExpressionDatas() != null) {
            int size = photoLiveCardData.getExpressionDatas().size();
            for (int i = 0; i < size && i < 3; i++) {
                int intValue = photoLiveCardData.getShowExpressionViewIndex().get(i).intValue();
                if (intValue >= 0) {
                    a(intValue, photoLiveCardData.getExpressionDatas(), i);
                }
            }
            BJ();
        }
    }

    private void BJ() {
        if (this.avg.size() != 0) {
            int size = this.avg.size();
            for (int i = 0; i < size; i++) {
                if (this.avg.get(i).intValue() == this.auX.getId()) {
                    this.auX.setVisibility(8);
                } else if (this.avg.get(i).intValue() == this.auY.getId()) {
                    this.auY.setVisibility(8);
                } else if (this.avg.get(i).intValue() == this.auZ.getId()) {
                    this.auZ.setVisibility(8);
                }
            }
        }
    }

    private void BK() {
        this.auX.setText("");
        this.auY.setText("");
        this.auZ.setText("");
        if (this.auX.getVisibility() == 8) {
            this.auX.setVisibility(0);
        }
        if (this.auY.getVisibility() == 8) {
            this.auY.setVisibility(0);
        }
        if (this.auZ.getVisibility() == 8) {
            this.auZ.setVisibility(0);
        }
        this.avg.add(Integer.valueOf(this.auX.getId()));
        this.avg.add(Integer.valueOf(this.auY.getId()));
        this.avg.add(Integer.valueOf(this.auZ.getId()));
    }

    private void a(n nVar, TextView textView) {
        if (nVar != null && textView != null) {
            if (!a(nVar)) {
                textView.setVisibility(8);
                return;
            }
            textView.setVisibility(0);
            textView.setText(nVar.aj(nVar.getLabelName(), String.valueOf(nVar.Bw())));
            ei(textView.getId());
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
            switch (this.avf) {
                case 0:
                    a(this.avr, this.avs, this.auX);
                    a(this.avt, this.avu, this.auY);
                    a(this.avv, this.avw, this.auZ);
                    break;
                case 1:
                    a(this.avw, this.avx, this.auX);
                    a(this.avy, this.avw, this.auY);
                    a(this.avz, this.avu, this.auZ);
                    break;
                case 2:
                    a(this.avw, this.avA, this.auX);
                    a(this.avB, this.avw, this.auY);
                    a(this.avz, this.avu, this.auZ);
                    break;
            }
            if (i == 0) {
                a(arrayList.get(i2), this.auX);
            } else if (i == 1) {
                a(arrayList.get(i2), this.auY);
            } else if (i == 2) {
                a(arrayList.get(i2), this.auZ);
            }
        }
    }

    private void ei(int i) {
        if (this.avg.size() != 0) {
            int size = this.avg.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.avg.get(i2).intValue() == i) {
                    this.avg.remove(i2);
                    return;
                }
            }
        }
    }

    private boolean a(n nVar) {
        return (nVar == null || StringUtils.isNull(nVar.getLabelName())) ? false : true;
    }

    private void setCover(String str) {
        this.auW.setVisibility(0);
        if (!TextUtils.isEmpty(str)) {
            this.auW.c(str, 10, false);
        } else {
            this.auW.c(null, 10, false);
        }
    }

    private void setBaName(String str) {
        if (TextUtils.isEmpty(str)) {
            this.avb.setText("");
            return;
        }
        String trim = str.trim();
        this.avb.setVisibility(0);
        if (com.baidu.tbadk.util.u.gq(trim) > 12) {
            trim = String.valueOf(com.baidu.tbadk.util.u.d(trim, 0, 12)) + "...";
        }
        this.avb.setText(String.valueOf(trim) + TbadkCoreApplication.m9getInst().getResources().getString(w.l.bar));
    }

    private void setContent(String str) {
        if (TextUtils.isEmpty(str)) {
            this.auU.setText("");
            this.auU.setVisibility(8);
            return;
        }
        this.auU.setVisibility(0);
        this.auU.setText(str);
    }

    private void setTitle(String str) {
        this.avC = str;
        if (this.avh != 0) {
            this.auQ.setPadding(0, 0, (int) this.context.getResources().getDimension(this.avh), 0);
            this.avh = 0;
        } else {
            this.auQ.setPadding(0, 0, 0, 0);
        }
        if (TextUtils.isEmpty(str)) {
            this.auQ.setText("");
            return;
        }
        this.auQ.setVisibility(0);
        if (this.avj) {
            if (this.avm) {
                this.auQ.setText(at.c(this.context, str, w.l.photo_live_tips));
                return;
            } else {
                this.auQ.setText(e(str));
                return;
            }
        }
        this.auQ.setText(str);
    }

    public static SpannableStringBuilder e(CharSequence charSequence) {
        if (charSequence == null || charSequence.length() == 0) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(String.valueOf("live") + "space" + ((Object) charSequence));
        Bitmap cO = aq.cO(w.g.icon_zhibo);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(cO);
        int height = cO.getHeight();
        bitmapDrawable.setBounds(0, 0, cO.getWidth(), height);
        spannableStringBuilder.setSpan(new com.baidu.adp.widget.d(bitmapDrawable, 1), 0, "live".length(), 33);
        ColorDrawable colorDrawable = new ColorDrawable();
        colorDrawable.setBounds(0, 0, 10, height);
        spannableStringBuilder.setSpan(new com.baidu.adp.widget.d(colorDrawable, 1), 1, "live".length() + "space".length(), 33);
        return spannableStringBuilder;
    }

    private void eI(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.auG.c(str, 12, false);
        } else {
            this.auG.c(null, 12, false);
        }
    }

    private void setUserName(String str) {
        if (TextUtils.isEmpty(str)) {
            this.auJ.setText("");
            return;
        }
        this.auJ.setVisibility(0);
        String trim = str.trim();
        if (com.baidu.tbadk.util.u.gq(trim) > 14) {
            trim = String.valueOf(com.baidu.tbadk.util.u.d(trim, 0, 14)) + "...";
        }
        this.auJ.setText(trim);
    }

    private void setNickName(String str) {
        if (TextUtils.isEmpty(str)) {
            b(this.auK, this.context.getResources().getString(w.l.fans_default_name));
        } else {
            b(this.auK, str);
        }
    }

    private void b(TextView textView, String str) {
        textView.setText(str);
        Drawable drawable = aq.getDrawable(w.g.icon_fengsi_n);
        drawable.setBounds(0, 0, this.size, this.size);
        textView.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
    }

    private void setFansNum(int i) {
        this.auL.setText(au.w(i));
    }

    private void setReplyNum(int i) {
        b(this.auM, i);
    }

    private void b(TextView textView, long j) {
        if (j <= 0) {
            textView.setText("");
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            return;
        }
        textView.setText(au.w(j));
        Drawable drawable = aq.getDrawable(w.g.icon_comment_n);
        drawable.setBounds(0, 0, this.size, this.size);
        textView.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
    }

    private void i(int i, boolean z) {
        if (z) {
            this.avd.setVisibility(0);
            b(this.avd, i);
            return;
        }
        this.avd.setVisibility(8);
    }

    private void setHeadLiveIconInHead(boolean z) {
        if (z && this.auB) {
            this.auN.setVisibility(0);
            aq.j(this.auN, w.g.label_onthelist);
            return;
        }
        this.auN.setVisibility(8);
    }

    private void setRefreshTimeInHead(String str) {
        if (this.auA) {
            this.auO.setVisibility(0);
            this.auO.setText(str);
            return;
        }
        this.auO.setVisibility(8);
        this.auO.setText("");
    }

    private void o(String str, boolean z) {
        if (!z) {
            this.auR.setVisibility(8);
            return;
        }
        this.auR.setVisibility(0);
        this.auR.setText(str);
    }

    private void p(String str, boolean z) {
        if (!z) {
            this.avc.setVisibility(8);
            return;
        }
        this.avc.setVisibility(0);
        this.avc.setText(str);
    }

    public void setShowHead(boolean z) {
        this.aus = z;
    }

    public void setShowTitle(boolean z) {
        this.aut = z;
    }

    public void setShowRefreshTimeInTitle(boolean z) {
        this.auy = z;
    }

    public void setShowContent(boolean z) {
        this.auu = z;
    }

    public void setShowCover(boolean z) {
        this.auv = z;
    }

    public void setShowExpression(boolean z) {
        this.auw = z;
    }

    public void setShowBottom(boolean z) {
        this.aux = z;
    }

    public void setShowRefreshTimeInHead(boolean z) {
        this.auA = z;
    }

    public void setShowHeadLiveIcon(boolean z) {
        this.auB = z;
    }

    public void setShowReplyNumInButtom(boolean z) {
        this.auC = z;
    }

    public void setShowDeleteButtonInTitle(boolean z) {
        this.auD = z;
    }

    public void setChooseStyle(int i) {
        this.avf = i;
    }

    public int getShowStyle() {
        return this.avf;
    }

    public void setShowLiveIcon(boolean z) {
        this.avj = z;
    }

    public void setDeleteButtonClickListener(a aVar) {
        this.auq = aVar;
    }

    public void setPortraitClicklistener(b bVar) {
        this.aur = bVar;
    }

    public void setParentBackground(int i) {
        aq.j(this.auE, i);
    }

    public void setContentPaddingBottom(int i) {
        this.paddingBottom = i;
    }

    public void setHeadPaddingTop(int i) {
        this.paddingTop = i;
    }

    public void setShowImage(boolean z) {
        this.avk = z;
    }

    public void setShowRefreshTimeInButtom(boolean z) {
        this.auz = z;
    }

    public void setTitlePaddingRight(int i) {
        this.avh = i;
    }

    public void setTitleMaxLines(int i) {
        this.avi = i;
    }

    public void setAllowGreyState(boolean z) {
        this.avl = z;
    }

    public void bp(boolean z) {
        this.avm = z;
    }
}
