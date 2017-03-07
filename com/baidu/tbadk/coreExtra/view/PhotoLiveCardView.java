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
    public int amL;
    private a atY;
    private b atZ;
    private TextView auA;
    private LinearLayout auB;
    private TextView auC;
    private RelativeLayout auD;
    private TbImageView auE;
    private TextView auF;
    private TextView auG;
    private TextView auH;
    private RelativeLayout auI;
    private TextView auJ;
    private TextView auK;
    private TextView auL;
    private TextView auM;
    private int auN;
    private ArrayList<Integer> auO;
    private int auP;
    private int auQ;
    private boolean auR;
    private boolean auS;
    private boolean auT;
    private boolean auU;
    private int auV;
    private int auW;
    private int auX;
    private int auY;
    private int auZ;
    private boolean aua;
    private boolean aub;
    private boolean auc;
    private boolean aud;
    private boolean aue;
    private boolean auf;
    private boolean aug;
    private boolean auh;
    private boolean aui;
    private boolean auj;
    private boolean auk;
    private boolean aul;
    private LinearLayout aum;
    private View aun;
    private HeadImageView auo;
    private FrameLayout aup;
    private LinearLayout auq;
    private TextView aur;
    private TextView aus;
    private TextView aut;
    private TextView auu;
    private TextView auv;
    private TextView auw;
    private LinearLayout aux;
    private TextView auy;
    private TextView auz;
    private int ava;
    private int avb;
    private int avc;
    private int avd;
    private int ave;
    private int avf;
    private int avg;
    private int avh;
    private int avi;
    private int avj;
    private String avk;
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
        this.aua = true;
        this.aub = true;
        this.auc = true;
        this.aud = true;
        this.aue = true;
        this.auf = true;
        this.aug = false;
        this.auh = false;
        this.aui = false;
        this.auj = false;
        this.auk = false;
        this.aul = false;
        this.auN = 0;
        this.auO = new ArrayList<>();
        this.paddingBottom = 0;
        this.paddingTop = 0;
        this.auP = 0;
        this.auQ = 0;
        this.auR = false;
        this.auS = true;
        this.auT = false;
        this.auU = false;
        this.isGod = false;
        this.amL = 3;
        this.padding = 0;
        this.auV = 0;
        this.auW = 0;
        this.auX = 0;
        this.auY = 0;
        this.avk = "";
        this.context = context;
        this.padding = (int) context.getResources().getDimension(w.f.ds24);
        this.auW = (int) context.getResources().getDimension(w.f.ds100);
        this.auV = (int) context.getResources().getDimension(w.f.ds70);
        this.auX = (int) context.getResources().getDimension(w.f.ds18);
        this.auY = (int) context.getResources().getDimension(w.f.ds4);
        this.auZ = (int) context.getResources().getDimension(w.f.ds80);
        this.ava = (int) context.getResources().getDimension(w.f.ds280);
        this.avb = (int) context.getResources().getDimension(w.f.ds170);
        this.avc = (int) context.getResources().getDimension(w.f.ds320);
        this.avd = (int) context.getResources().getDimension(w.f.ds200);
        this.ave = (int) context.getResources().getDimension(w.f.ds60);
        this.avf = (int) context.getResources().getDimension(w.f.ds120);
        this.avg = (int) context.getResources().getDimension(w.f.ds160);
        this.avh = (int) context.getResources().getDimension(w.f.ds220);
        this.avi = (int) context.getResources().getDimension(w.f.ds240);
        this.avj = (int) context.getResources().getDimension(w.f.ds180);
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
        this.aum = (LinearLayout) inflate.findViewById(w.h.pl_card_root);
        this.aun = inflate.findViewById(w.h.author_info);
        this.aux = (LinearLayout) inflate.findViewById(w.h.photo_live_card_title);
        this.auB = (LinearLayout) inflate.findViewById(w.h.photo_live_card_content);
        this.auD = (RelativeLayout) inflate.findViewById(w.h.photo_live_card_cover_and_expression);
        this.auI = (RelativeLayout) inflate.findViewById(w.h.photo_live_card_bottom);
        Be();
        Bf();
        Bg();
        Bi();
        Bh();
    }

    public void setData(PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            setIsGod(photoLiveCardData);
            c(this.aua, photoLiveCardData);
            b(this.aub, this.aug, photoLiveCardData);
            b(this.auc, photoLiveCardData);
            a(this.aud, this.aue, photoLiveCardData);
            a(this.auf, photoLiveCardData);
        }
    }

    private void setIsGod(PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null && photoLiveCardData.getGodInfo() != null) {
            this.isGod = true;
        } else {
            this.isGod = false;
        }
    }

    public void wP() {
        int skinType = TbadkCoreApplication.m9getInst().getSkinType();
        if (skinType != this.amL) {
            aq.j(this.aum, w.g.frs_item_control_btn_bg);
            if (this.aua) {
                aq.c(this.aur, w.e.cp_cont_f, 1);
                aq.c(this.aus, w.e.cp_cont_d, 1);
                aq.c(this.aut, w.e.cp_cont_d, 1);
                aq.c(this.auu, w.e.cp_cont_d, 1);
                aq.c(this.auw, w.e.cp_cont_d, 1);
                Drawable drawable = aq.getDrawable(w.g.icon_fengsi_n);
                if (drawable != null) {
                    drawable.setBounds(0, 0, this.size, this.size);
                }
                this.aus.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
                Drawable drawable2 = aq.getDrawable(w.g.icon_comment_n);
                if (drawable2 != null) {
                    drawable2.setBounds(0, 0, this.size, this.size);
                }
                this.auu.setCompoundDrawablesWithIntrinsicBounds(drawable2, (Drawable) null, (Drawable) null, (Drawable) null);
            }
            if (this.aub) {
                aq.c(this.auy, w.e.cp_cont_b, 1);
                aq.c(this.auz, w.e.cp_cont_c, 1);
                aq.c(this.auA, w.e.cp_cont_i, 1);
                aq.j(this.auA, w.g.blacklist_remove_button_bg);
                this.auy.setText(e(this.avk));
            }
            if (this.auf) {
                aq.c(this.auJ, w.e.cp_cont_i, 1);
                aq.j(this.auJ, w.g.label_bg_tie);
                aq.c(this.auK, w.e.cp_cont_d, 1);
                aq.c(this.auL, w.e.cp_cont_d, 1);
                aq.c(this.auJ, w.e.cp_cont_i, 1);
            }
            aq.c(this.auC, w.e.cp_cont_b, 1);
            Bj();
            this.amL = skinType;
        }
    }

    private void a(boolean z, boolean z2, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z && this.auS) {
                if (this.paddingBottom != 0) {
                    this.auD.setPadding(this.padding, 0, this.padding, (int) this.context.getResources().getDimension(this.paddingBottom));
                    this.paddingBottom = 0;
                } else {
                    this.auD.setPadding(this.padding, 0, this.padding, 0);
                }
                this.auD.setVisibility(0);
                setCover(photoLiveCardData.getPhotoLiveCover());
                setExpression(photoLiveCardData);
            } else if (this.auD != null) {
                this.auD.setVisibility(8);
            }
        }
    }

    private void a(boolean z, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z) {
                this.auI.setVisibility(0);
                setBaName(photoLiveCardData.getForumName());
                p(photoLiveCardData.buildRefreshTimeWithoutPostNum(), this.auh);
                i(photoLiveCardData.getDiscussNum(), this.auk);
                return;
            }
            this.auI.setVisibility(8);
        }
    }

    private void b(boolean z, boolean z2, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z) {
                this.aux.setVisibility(0);
                if (this.auQ != 0) {
                    this.auy.setMaxLines(this.auQ);
                } else {
                    this.auy.setMaxLines(2);
                }
                setTitle(photoLiveCardData.getTitle());
                o(photoLiveCardData.buildRefreshTimeWithPostNum(), z2);
                setDeleteButtonVisibility(photoLiveCardData);
                a(this.auy, photoLiveCardData.getThreadId());
                return;
            }
            this.aux.setVisibility(8);
        }
    }

    private void setDeleteButtonVisibility(PhotoLiveCardData photoLiveCardData) {
        if (this.aul) {
            this.auA.setVisibility(0);
            this.auA.setTag(photoLiveCardData);
            return;
        }
        this.auA.setVisibility(8);
    }

    private void b(boolean z, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z) {
                this.auB.setVisibility(0);
                if (this.paddingBottom != 0) {
                    this.auB.setPadding(this.padding, 0, this.padding, (int) this.context.getResources().getDimension(this.paddingBottom));
                    this.paddingBottom = 0;
                } else {
                    this.auB.setPadding(this.padding, 0, this.padding, 0);
                }
                setContent(photoLiveCardData.getContent());
                a(this.auC, photoLiveCardData.getThreadId());
                return;
            }
            this.auB.setVisibility(8);
        }
    }

    private void a(TextView textView, long j) {
        if (textView != null && this.auT) {
            com.baidu.tieba.tbadkCore.util.r readThreadHistory = TbadkCoreApplication.m9getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.pX(String.valueOf(j))) {
                aq.c(textView, w.e.cp_cont_c, 1);
            } else {
                aq.c(textView, w.e.cp_cont_b, 1);
            }
        }
    }

    private void c(boolean z, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z) {
                this.aun.setVisibility(0);
                if (this.paddingTop != 0) {
                    this.aun.setPadding(0, (int) this.context.getResources().getDimension(this.paddingTop), 0, 0);
                } else {
                    this.aun.setPadding(0, 0, 0, 0);
                }
                ViewGroup.LayoutParams layoutParams = this.auo.getLayoutParams();
                if (this.isGod) {
                    if (layoutParams != null) {
                        layoutParams.height = this.auW;
                        layoutParams.width = this.auW;
                    }
                    if (this.auM == null) {
                        this.auM = new TextView(this.context);
                        this.auM.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
                        this.auM.setEllipsize(TextUtils.TruncateAt.END);
                        this.auM.setTextSize(0, this.auX);
                        aq.i((View) this.auM, w.e.cp_cont_h);
                        aq.j(this.auM, w.g.icon_shen);
                        this.auM.setSingleLine(true);
                        this.auq.addView(this.auM);
                    }
                    if (photoLiveCardData.getGodInfo() == null || StringUtils.isNull(photoLiveCardData.getGodInfo().intro)) {
                        this.auM.setText(w.l.god_intro_default);
                    } else {
                        this.auM.setText(photoLiveCardData.getGodInfo().intro);
                    }
                } else {
                    this.auq.removeView(this.auM);
                    this.auM = null;
                    if (layoutParams != null) {
                        layoutParams.height = this.auV;
                        layoutParams.width = this.auV;
                    }
                }
                this.auo.setTag(photoLiveCardData);
                eC(photoLiveCardData.getAuthorPortrait());
                setUserName(photoLiveCardData.getAuthorName());
                setNickName(photoLiveCardData.getNickName());
                setFansNum(photoLiveCardData.getFansNum());
                setReplyNum(photoLiveCardData.getDiscussNum());
                setHeadLiveIconInHead(photoLiveCardData.isHeadLive());
                setRefreshTimeInHead(photoLiveCardData.buildRefreshTimeWithoutPostNum());
                setPortraitBackground(photoLiveCardData.isHeadLive());
                return;
            }
            this.auq.removeView(this.auM);
            this.aun.setVisibility(8);
        }
    }

    public void setPortraitBackground(boolean z) {
        if (z) {
            this.auo.setPadding(this.auY, this.auY, this.auY, this.auY);
            if (this.isGod) {
                this.aup.setBackgroundDrawable(aq.getDrawable(w.g.pic_bg_jinbian));
                return;
            } else {
                this.aup.setBackgroundDrawable(aq.getDrawable(w.g.frs_touxiang_jinkuan));
                return;
            }
        }
        this.aup.setBackgroundDrawable(null);
        this.auo.setPadding(0, 0, 0, 0);
    }

    private void Be() {
        if (this.aun != null) {
            this.auo = (HeadImageView) this.aun.findViewById(w.h.author_portrait);
            this.aup = (FrameLayout) this.aun.findViewById(w.h.author_portrait_info);
            this.aur = (TextView) this.aun.findViewById(w.h.author_name);
            this.aus = (TextView) this.aun.findViewById(w.h.nick_name);
            this.aut = (TextView) this.aun.findViewById(w.h.fans_num);
            this.auu = (TextView) this.aun.findViewById(w.h.reply_num);
            this.auv = (TextView) this.aun.findViewById(w.h.headlive_icon);
            this.auw = (TextView) this.aun.findViewById(w.h.refresh_time_in_head);
            this.auq = (LinearLayout) this.aun.findViewById(w.h.author_info_and_time);
            this.auo.setOnClickListener(new s(this));
        }
    }

    private void Bf() {
        if (this.aux != null) {
            this.auy = (TextView) this.aux.findViewById(w.h.title);
            this.auz = (TextView) findViewById(w.h.refresh_time_in_title);
            this.auA = (TextView) this.aux.findViewById(w.h.card_delete_in_title);
            this.auA.setOnClickListener(new t(this));
        }
    }

    private void Bg() {
        if (this.auB != null) {
            this.auC = (TextView) this.auB.findViewById(w.h.content);
        }
    }

    private void Bh() {
        if (this.auI != null) {
            this.auJ = (TextView) this.auI.findViewById(w.h.ba_name);
            this.auK = (TextView) this.auI.findViewById(w.h.bottom_refresh_time);
            this.auL = (TextView) this.auI.findViewById(w.h.bottom_reply_num);
        }
    }

    private void Bi() {
        if (this.auD != null) {
            this.auE = (TbImageView) this.auD.findViewById(w.h.live_cover);
            this.auE.setGifIconSupport(false);
            Bk();
        }
    }

    private void Bj() {
        aq.j(this.auF, w.g.bg_tieziyingxiang);
        aq.j(this.auG, w.g.bg_tieziyingxiang);
        aq.j(this.auH, w.g.bg_tieziyingxiang);
    }

    private void Bk() {
        if (this.auD != null) {
            this.auF = (TextView) this.auD.findViewById(w.h.first_style_first_expression);
            this.auG = (TextView) this.auD.findViewById(w.h.first_style_second_expression);
            this.auH = (TextView) this.auD.findViewById(w.h.first_style_third_expression);
        }
    }

    private void setExpression(PhotoLiveCardData photoLiveCardData) {
        this.auO.clear();
        Bm();
        if (photoLiveCardData != null && photoLiveCardData.getExpressionDatas() != null) {
            int size = photoLiveCardData.getExpressionDatas().size();
            for (int i = 0; i < size && i < 3; i++) {
                int intValue = photoLiveCardData.getShowExpressionViewIndex().get(i).intValue();
                if (intValue >= 0) {
                    a(intValue, photoLiveCardData.getExpressionDatas(), i);
                }
            }
            Bl();
        }
    }

    private void Bl() {
        if (this.auO.size() != 0) {
            int size = this.auO.size();
            for (int i = 0; i < size; i++) {
                if (this.auO.get(i).intValue() == this.auF.getId()) {
                    this.auF.setVisibility(8);
                } else if (this.auO.get(i).intValue() == this.auG.getId()) {
                    this.auG.setVisibility(8);
                } else if (this.auO.get(i).intValue() == this.auH.getId()) {
                    this.auH.setVisibility(8);
                }
            }
        }
    }

    private void Bm() {
        this.auF.setText("");
        this.auG.setText("");
        this.auH.setText("");
        if (this.auF.getVisibility() == 8) {
            this.auF.setVisibility(0);
        }
        if (this.auG.getVisibility() == 8) {
            this.auG.setVisibility(0);
        }
        if (this.auH.getVisibility() == 8) {
            this.auH.setVisibility(0);
        }
        this.auO.add(Integer.valueOf(this.auF.getId()));
        this.auO.add(Integer.valueOf(this.auG.getId()));
        this.auO.add(Integer.valueOf(this.auH.getId()));
    }

    private void a(n nVar, TextView textView) {
        if (nVar != null && textView != null) {
            if (!a(nVar)) {
                textView.setVisibility(8);
                return;
            }
            textView.setVisibility(0);
            textView.setText(nVar.ai(nVar.getLabelName(), String.valueOf(nVar.AX())));
            ef(textView.getId());
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
            switch (this.auN) {
                case 0:
                    a(this.auZ, this.ava, this.auF);
                    a(this.avb, this.avc, this.auG);
                    a(this.avd, this.ave, this.auH);
                    break;
                case 1:
                    a(this.ave, this.avf, this.auF);
                    a(this.avg, this.ave, this.auG);
                    a(this.avh, this.avc, this.auH);
                    break;
                case 2:
                    a(this.ave, this.avi, this.auF);
                    a(this.avj, this.ave, this.auG);
                    a(this.avh, this.avc, this.auH);
                    break;
            }
            if (i == 0) {
                a(arrayList.get(i2), this.auF);
            } else if (i == 1) {
                a(arrayList.get(i2), this.auG);
            } else if (i == 2) {
                a(arrayList.get(i2), this.auH);
            }
        }
    }

    private void ef(int i) {
        if (this.auO.size() != 0) {
            int size = this.auO.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.auO.get(i2).intValue() == i) {
                    this.auO.remove(i2);
                    return;
                }
            }
        }
    }

    private boolean a(n nVar) {
        return (nVar == null || StringUtils.isNull(nVar.getLabelName())) ? false : true;
    }

    private void setCover(String str) {
        this.auE.setVisibility(0);
        if (!TextUtils.isEmpty(str)) {
            this.auE.c(str, 10, false);
        } else {
            this.auE.c(null, 10, false);
        }
    }

    private void setBaName(String str) {
        if (TextUtils.isEmpty(str)) {
            this.auJ.setText("");
            return;
        }
        String trim = str.trim();
        this.auJ.setVisibility(0);
        if (com.baidu.tbadk.util.u.gk(trim) > 12) {
            trim = String.valueOf(com.baidu.tbadk.util.u.d(trim, 0, 12)) + "...";
        }
        this.auJ.setText(String.valueOf(trim) + TbadkCoreApplication.m9getInst().getResources().getString(w.l.bar));
    }

    private void setContent(String str) {
        if (TextUtils.isEmpty(str)) {
            this.auC.setText("");
            this.auC.setVisibility(8);
            return;
        }
        this.auC.setVisibility(0);
        this.auC.setText(str);
    }

    private void setTitle(String str) {
        this.avk = str;
        if (this.auP != 0) {
            this.auy.setPadding(0, 0, (int) this.context.getResources().getDimension(this.auP), 0);
            this.auP = 0;
        } else {
            this.auy.setPadding(0, 0, 0, 0);
        }
        if (TextUtils.isEmpty(str)) {
            this.auy.setText("");
            return;
        }
        this.auy.setVisibility(0);
        if (this.auR) {
            if (this.auU) {
                this.auy.setText(at.c(this.context, str, w.l.kn_zhibo));
                return;
            } else {
                this.auy.setText(e(str));
                return;
            }
        }
        this.auy.setText(str);
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

    private void eC(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.auo.c(str, 12, false);
        } else {
            this.auo.c(null, 12, false);
        }
    }

    private void setUserName(String str) {
        if (TextUtils.isEmpty(str)) {
            this.aur.setText("");
            return;
        }
        this.aur.setVisibility(0);
        String trim = str.trim();
        if (com.baidu.tbadk.util.u.gk(trim) > 14) {
            trim = String.valueOf(com.baidu.tbadk.util.u.d(trim, 0, 14)) + "...";
        }
        this.aur.setText(trim);
    }

    private void setNickName(String str) {
        if (TextUtils.isEmpty(str)) {
            c(this.aus, this.context.getResources().getString(w.l.fans_default_name));
        } else {
            c(this.aus, str);
        }
    }

    private void c(TextView textView, String str) {
        textView.setText(str);
        Drawable drawable = aq.getDrawable(w.g.icon_fengsi_n);
        drawable.setBounds(0, 0, this.size, this.size);
        textView.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
    }

    private void setFansNum(int i) {
        this.aut.setText(au.w(i));
    }

    private void setReplyNum(int i) {
        b(this.auu, i);
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
            this.auL.setVisibility(0);
            b(this.auL, i);
            return;
        }
        this.auL.setVisibility(8);
    }

    private void setHeadLiveIconInHead(boolean z) {
        if (z && this.auj) {
            this.auv.setVisibility(0);
            aq.j(this.auv, w.g.label_onthelist);
            return;
        }
        this.auv.setVisibility(8);
    }

    private void setRefreshTimeInHead(String str) {
        if (this.aui) {
            this.auw.setVisibility(0);
            this.auw.setText(str);
            return;
        }
        this.auw.setVisibility(8);
        this.auw.setText("");
    }

    private void o(String str, boolean z) {
        if (!z) {
            this.auz.setVisibility(8);
            return;
        }
        this.auz.setVisibility(0);
        this.auz.setText(str);
    }

    private void p(String str, boolean z) {
        if (!z) {
            this.auK.setVisibility(8);
            return;
        }
        this.auK.setVisibility(0);
        this.auK.setText(str);
    }

    public void setShowHead(boolean z) {
        this.aua = z;
    }

    public void setShowTitle(boolean z) {
        this.aub = z;
    }

    public void setShowRefreshTimeInTitle(boolean z) {
        this.aug = z;
    }

    public void setShowContent(boolean z) {
        this.auc = z;
    }

    public void setShowCover(boolean z) {
        this.aud = z;
    }

    public void setShowExpression(boolean z) {
        this.aue = z;
    }

    public void setShowBottom(boolean z) {
        this.auf = z;
    }

    public void setShowRefreshTimeInHead(boolean z) {
        this.aui = z;
    }

    public void setShowHeadLiveIcon(boolean z) {
        this.auj = z;
    }

    public void setShowReplyNumInButtom(boolean z) {
        this.auk = z;
    }

    public void setShowDeleteButtonInTitle(boolean z) {
        this.aul = z;
    }

    public void setChooseStyle(int i) {
        this.auN = i;
    }

    public int getShowStyle() {
        return this.auN;
    }

    public void setShowLiveIcon(boolean z) {
        this.auR = z;
    }

    public void setDeleteButtonClickListener(a aVar) {
        this.atY = aVar;
    }

    public void setPortraitClicklistener(b bVar) {
        this.atZ = bVar;
    }

    public void setParentBackground(int i) {
        aq.j(this.aum, i);
    }

    public void setContentPaddingBottom(int i) {
        this.paddingBottom = i;
    }

    public void setHeadPaddingTop(int i) {
        this.paddingTop = i;
    }

    public void setShowImage(boolean z) {
        this.auS = z;
    }

    public void setShowRefreshTimeInButtom(boolean z) {
        this.auh = z;
    }

    public void setTitlePaddingRight(int i) {
        this.auP = i;
    }

    public void setTitleMaxLines(int i) {
        this.auQ = i;
    }

    public void setAllowGreyState(boolean z) {
        this.auT = z;
    }

    public void bn(boolean z) {
        this.auU = z;
    }
}
