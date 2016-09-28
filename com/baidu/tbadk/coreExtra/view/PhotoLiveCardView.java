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
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.an;
import com.baidu.tieba.r;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class PhotoLiveCardView extends FrameLayout {
    public int ahV;
    private boolean akD;
    private TextView apA;
    private LinearLayout apB;
    private TextView apC;
    private TextView apD;
    private LinearLayout apE;
    private TextView apF;
    private RelativeLayout apG;
    private TbImageView apH;
    private TextView apI;
    private TextView apJ;
    private TextView apK;
    private RelativeLayout apL;
    private TextView apM;
    private TextView apN;
    private TextView apO;
    private TextView apP;
    private int apQ;
    private ArrayList<Integer> apR;
    private int apS;
    private int apT;
    private boolean apU;
    private boolean apV;
    private boolean apW;
    private boolean apX;
    private int apY;
    private int apZ;
    private a apb;
    private b apc;
    private boolean apd;
    private boolean ape;
    private boolean apf;
    private boolean apg;
    private boolean aph;
    private boolean api;
    private boolean apj;
    private boolean apk;
    private boolean apl;
    private boolean apm;
    private boolean apn;
    private boolean apo;
    private LinearLayout apq;
    private View apr;
    private HeadImageView aps;
    private FrameLayout apt;
    private LinearLayout apu;
    private TextView apv;
    private TextView apw;
    private TextView apx;
    private TextView apy;
    private TextView apz;
    private int aqa;
    private int aqb;
    private int aqc;
    private int aqd;
    private int aqe;
    private int aqf;
    private int aqg;
    private int aqh;
    private int aqi;
    private int aqj;
    private int aqk;
    private int aql;
    private int aqm;
    private String aqn;
    private Context context;
    private int padding;
    private int paddingBottom;
    private int paddingTop;
    private int size;
    private TextView title;

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
        this.apd = true;
        this.ape = true;
        this.apf = true;
        this.apg = true;
        this.aph = true;
        this.api = true;
        this.apj = false;
        this.apk = false;
        this.apl = false;
        this.apm = false;
        this.apn = false;
        this.apo = false;
        this.apQ = 0;
        this.apR = new ArrayList<>();
        this.paddingBottom = 0;
        this.paddingTop = 0;
        this.apS = 0;
        this.apT = 0;
        this.apU = false;
        this.apV = true;
        this.apW = false;
        this.apX = false;
        this.akD = false;
        this.ahV = 3;
        this.padding = 0;
        this.apY = 0;
        this.apZ = 0;
        this.aqa = 0;
        this.aqb = 0;
        this.aqn = "";
        this.context = context;
        this.padding = (int) context.getResources().getDimension(r.e.ds24);
        this.apZ = (int) context.getResources().getDimension(r.e.ds100);
        this.apY = (int) context.getResources().getDimension(r.e.ds70);
        this.aqa = (int) context.getResources().getDimension(r.e.ds18);
        this.aqb = (int) context.getResources().getDimension(r.e.ds4);
        this.aqc = (int) context.getResources().getDimension(r.e.ds80);
        this.aqd = (int) context.getResources().getDimension(r.e.ds280);
        this.aqe = (int) context.getResources().getDimension(r.e.ds170);
        this.aqf = (int) context.getResources().getDimension(r.e.ds320);
        this.aqg = (int) context.getResources().getDimension(r.e.ds200);
        this.aqh = (int) context.getResources().getDimension(r.e.ds60);
        this.aqi = (int) context.getResources().getDimension(r.e.ds120);
        this.aqj = (int) context.getResources().getDimension(r.e.ds160);
        this.aqk = (int) context.getResources().getDimension(r.e.ds220);
        this.aql = (int) context.getResources().getDimension(r.e.ds240);
        this.aqm = (int) context.getResources().getDimension(r.e.ds180);
        this.size = (int) context.getResources().getDimension(r.e.ds8);
        init(context);
    }

    public PhotoLiveCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PhotoLiveCardView(Context context) {
        this(context, null, 0);
    }

    private void init(Context context) {
        View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(r.h.photo_live_card_view, this);
        this.apq = (LinearLayout) inflate.findViewById(r.g.pl_card_root);
        this.apr = inflate.findViewById(r.g.author_info);
        this.apB = (LinearLayout) inflate.findViewById(r.g.photo_live_card_title);
        this.apE = (LinearLayout) inflate.findViewById(r.g.photo_live_card_content);
        this.apG = (RelativeLayout) inflate.findViewById(r.g.photo_live_card_cover_and_expression);
        this.apL = (RelativeLayout) inflate.findViewById(r.g.photo_live_card_bottom);
        AW();
        AX();
        AY();
        Ba();
        AZ();
    }

    public void setData(PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            setIsGod(photoLiveCardData);
            c(this.apd, photoLiveCardData);
            b(this.ape, this.apj, photoLiveCardData);
            b(this.apf, photoLiveCardData);
            a(this.apg, this.aph, photoLiveCardData);
            a(this.api, photoLiveCardData);
        }
    }

    private void setIsGod(PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null && photoLiveCardData.getGodInfo() != null) {
            this.akD = true;
        } else {
            this.akD = false;
        }
    }

    public void wH() {
        int skinType = TbadkCoreApplication.m9getInst().getSkinType();
        if (skinType != this.ahV) {
            av.k(this.apq, r.f.frs_item_control_btn_bg);
            if (this.apd) {
                av.c(this.apv, r.d.cp_cont_f, 1);
                av.c(this.apw, r.d.cp_cont_d, 1);
                av.c(this.apx, r.d.cp_cont_d, 1);
                av.c(this.apy, r.d.cp_cont_d, 1);
                av.c(this.apA, r.d.cp_cont_d, 1);
                Drawable drawable = av.getDrawable(r.f.icon_fengsi_n);
                if (drawable != null) {
                    drawable.setBounds(0, 0, this.size, this.size);
                }
                this.apw.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
                Drawable drawable2 = av.getDrawable(r.f.icon_comment_n);
                if (drawable2 != null) {
                    drawable2.setBounds(0, 0, this.size, this.size);
                }
                this.apy.setCompoundDrawablesWithIntrinsicBounds(drawable2, (Drawable) null, (Drawable) null, (Drawable) null);
            }
            if (this.ape) {
                av.c(this.title, r.d.cp_cont_b, 1);
                av.c(this.apC, r.d.cp_cont_c, 1);
                av.c(this.apD, r.d.cp_cont_i, 1);
                av.k(this.apD, r.f.blacklist_remove_button_bg);
                this.title.setText(e(this.aqn));
            }
            if (this.api) {
                av.c(this.apM, r.d.cp_cont_i, 1);
                av.k(this.apM, r.f.label_bg_tie);
                av.c(this.apN, r.d.cp_cont_d, 1);
                av.c(this.apO, r.d.cp_cont_d, 1);
                av.c(this.apM, r.d.cp_cont_i, 1);
            }
            av.c(this.apF, r.d.cp_cont_b, 1);
            Bb();
            this.ahV = skinType;
        }
    }

    private void a(boolean z, boolean z2, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z && this.apV) {
                if (this.paddingBottom != 0) {
                    this.apG.setPadding(this.padding, 0, this.padding, (int) this.context.getResources().getDimension(this.paddingBottom));
                    this.paddingBottom = 0;
                } else {
                    this.apG.setPadding(this.padding, 0, this.padding, 0);
                }
                this.apG.setVisibility(0);
                setCover(photoLiveCardData.getPhotoLiveCover());
                setExpression(photoLiveCardData);
            } else if (this.apG != null) {
                this.apG.setVisibility(8);
            }
        }
    }

    private void a(boolean z, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z) {
                this.apL.setVisibility(0);
                setBaName(photoLiveCardData.getForumName());
                p(photoLiveCardData.buildRefreshTimeWithoutPostNum(), this.apk);
                i(photoLiveCardData.getDiscussNum(), this.apn);
                return;
            }
            this.apL.setVisibility(8);
        }
    }

    private void b(boolean z, boolean z2, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z) {
                this.apB.setVisibility(0);
                if (this.apT != 0) {
                    this.title.setMaxLines(this.apT);
                } else {
                    this.title.setMaxLines(2);
                }
                setTitle(photoLiveCardData.getTitle());
                o(photoLiveCardData.buildRefreshTimeWithPostNum(), z2);
                setDeleteButtonVisibility(photoLiveCardData);
                a(this.title, photoLiveCardData.getThreadId());
                return;
            }
            this.apB.setVisibility(8);
        }
    }

    private void setDeleteButtonVisibility(PhotoLiveCardData photoLiveCardData) {
        if (this.apo) {
            this.apD.setVisibility(0);
            this.apD.setTag(photoLiveCardData);
            return;
        }
        this.apD.setVisibility(8);
    }

    private void b(boolean z, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z) {
                this.apE.setVisibility(0);
                if (this.paddingBottom != 0) {
                    this.apE.setPadding(this.padding, 0, this.padding, (int) this.context.getResources().getDimension(this.paddingBottom));
                    this.paddingBottom = 0;
                } else {
                    this.apE.setPadding(this.padding, 0, this.padding, 0);
                }
                setContent(photoLiveCardData.getContent());
                a(this.apF, photoLiveCardData.getThreadId());
                return;
            }
            this.apE.setVisibility(8);
        }
    }

    private void a(TextView textView, long j) {
        if (textView != null && this.apW) {
            com.baidu.tieba.tbadkCore.util.s readThreadHistory = TbadkCoreApplication.m9getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.ru(String.valueOf(j))) {
                av.c(textView, r.d.cp_cont_c, 1);
            } else {
                av.c(textView, r.d.cp_cont_b, 1);
            }
        }
    }

    private void c(boolean z, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z) {
                this.apr.setVisibility(0);
                if (this.paddingTop != 0) {
                    this.apr.setPadding(0, (int) this.context.getResources().getDimension(this.paddingTop), 0, 0);
                } else {
                    this.apr.setPadding(0, 0, 0, 0);
                }
                ViewGroup.LayoutParams layoutParams = this.aps.getLayoutParams();
                if (this.akD) {
                    if (layoutParams != null) {
                        layoutParams.height = this.apZ;
                        layoutParams.width = this.apZ;
                    }
                    if (this.apP == null) {
                        this.apP = new TextView(this.context);
                        this.apP.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
                        this.apP.setEllipsize(TextUtils.TruncateAt.END);
                        this.apP.setTextSize(0, this.aqa);
                        av.j((View) this.apP, r.d.cp_cont_h);
                        av.k(this.apP, r.f.icon_shen);
                        this.apP.setSingleLine(true);
                        this.apu.addView(this.apP);
                    }
                    if (photoLiveCardData.getGodInfo() == null || StringUtils.isNull(photoLiveCardData.getGodInfo().intro)) {
                        this.apP.setText(r.j.god_intro_default);
                    } else {
                        this.apP.setText(photoLiveCardData.getGodInfo().intro);
                    }
                } else {
                    this.apu.removeView(this.apP);
                    this.apP = null;
                    if (layoutParams != null) {
                        layoutParams.height = this.apY;
                        layoutParams.width = this.apY;
                    }
                }
                this.aps.setTag(photoLiveCardData);
                eS(photoLiveCardData.getAuthorPortrait());
                setUserName(photoLiveCardData.getAuthorName());
                setNickName(photoLiveCardData.getNickName());
                setFansNum(photoLiveCardData.getFansNum());
                setReplyNum(photoLiveCardData.getDiscussNum());
                setHeadLiveIconInHead(photoLiveCardData.isHeadLive());
                setRefreshTimeInHead(photoLiveCardData.buildRefreshTimeWithoutPostNum());
                setPortraitBackground(photoLiveCardData.isHeadLive());
                return;
            }
            this.apu.removeView(this.apP);
            this.apr.setVisibility(8);
        }
    }

    public void setPortraitBackground(boolean z) {
        if (z) {
            this.aps.setPadding(this.aqb, this.aqb, this.aqb, this.aqb);
            if (this.akD) {
                this.apt.setBackgroundDrawable(av.getDrawable(r.f.pic_bg_jinbian));
                return;
            } else {
                this.apt.setBackgroundDrawable(av.getDrawable(r.f.frs_touxiang_jinkuan));
                return;
            }
        }
        this.apt.setBackgroundDrawable(null);
        this.aps.setPadding(0, 0, 0, 0);
    }

    private void AW() {
        if (this.apr != null) {
            this.aps = (HeadImageView) this.apr.findViewById(r.g.author_portrait);
            this.apt = (FrameLayout) this.apr.findViewById(r.g.author_portrait_info);
            this.apv = (TextView) this.apr.findViewById(r.g.author_name);
            this.apw = (TextView) this.apr.findViewById(r.g.nick_name);
            this.apx = (TextView) this.apr.findViewById(r.g.fans_num);
            this.apy = (TextView) this.apr.findViewById(r.g.reply_num);
            this.apz = (TextView) this.apr.findViewById(r.g.headlive_icon);
            this.apA = (TextView) this.apr.findViewById(r.g.refresh_time_in_head);
            this.apu = (LinearLayout) this.apr.findViewById(r.g.author_info_and_time);
            this.aps.setOnClickListener(new s(this));
        }
    }

    private void AX() {
        if (this.apB != null) {
            this.title = (TextView) this.apB.findViewById(r.g.title);
            this.apC = (TextView) findViewById(r.g.refresh_time_in_title);
            this.apD = (TextView) this.apB.findViewById(r.g.card_delete_in_title);
            this.apD.setOnClickListener(new t(this));
        }
    }

    private void AY() {
        if (this.apE != null) {
            this.apF = (TextView) this.apE.findViewById(r.g.content);
        }
    }

    private void AZ() {
        if (this.apL != null) {
            this.apM = (TextView) this.apL.findViewById(r.g.ba_name);
            this.apN = (TextView) this.apL.findViewById(r.g.bottom_refresh_time);
            this.apO = (TextView) this.apL.findViewById(r.g.bottom_reply_num);
        }
    }

    private void Ba() {
        if (this.apG != null) {
            this.apH = (TbImageView) this.apG.findViewById(r.g.live_cover);
            this.apH.setGifIconSupport(false);
            Bc();
        }
    }

    private void Bb() {
        av.k(this.apI, r.f.bg_tieziyingxiang);
        av.k(this.apJ, r.f.bg_tieziyingxiang);
        av.k(this.apK, r.f.bg_tieziyingxiang);
    }

    private void Bc() {
        if (this.apG != null) {
            this.apI = (TextView) this.apG.findViewById(r.g.first_style_first_expression);
            this.apJ = (TextView) this.apG.findViewById(r.g.first_style_second_expression);
            this.apK = (TextView) this.apG.findViewById(r.g.first_style_third_expression);
        }
    }

    private void setExpression(PhotoLiveCardData photoLiveCardData) {
        this.apR.clear();
        Be();
        if (photoLiveCardData != null && photoLiveCardData.getExpressionDatas() != null) {
            int size = photoLiveCardData.getExpressionDatas().size();
            for (int i = 0; i < size && i < 3; i++) {
                int intValue = photoLiveCardData.getShowExpressionViewIndex().get(i).intValue();
                if (intValue >= 0) {
                    a(intValue, photoLiveCardData.getExpressionDatas(), i);
                }
            }
            Bd();
        }
    }

    private void Bd() {
        if (this.apR.size() != 0) {
            int size = this.apR.size();
            for (int i = 0; i < size; i++) {
                if (this.apR.get(i).intValue() == this.apI.getId()) {
                    this.apI.setVisibility(8);
                } else if (this.apR.get(i).intValue() == this.apJ.getId()) {
                    this.apJ.setVisibility(8);
                } else if (this.apR.get(i).intValue() == this.apK.getId()) {
                    this.apK.setVisibility(8);
                }
            }
        }
    }

    private void Be() {
        this.apI.setText("");
        this.apJ.setText("");
        this.apK.setText("");
        if (this.apI.getVisibility() == 8) {
            this.apI.setVisibility(0);
        }
        if (this.apJ.getVisibility() == 8) {
            this.apJ.setVisibility(0);
        }
        if (this.apK.getVisibility() == 8) {
            this.apK.setVisibility(0);
        }
        this.apR.add(Integer.valueOf(this.apI.getId()));
        this.apR.add(Integer.valueOf(this.apJ.getId()));
        this.apR.add(Integer.valueOf(this.apK.getId()));
    }

    private void a(n nVar, TextView textView) {
        if (nVar != null && textView != null) {
            if (!a(nVar)) {
                textView.setVisibility(8);
                return;
            }
            textView.setVisibility(0);
            textView.setText(nVar.aj(nVar.getLabelName(), String.valueOf(nVar.AP())));
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
            switch (this.apQ) {
                case 0:
                    a(this.aqc, this.aqd, this.apI);
                    a(this.aqe, this.aqf, this.apJ);
                    a(this.aqg, this.aqh, this.apK);
                    break;
                case 1:
                    a(this.aqh, this.aqi, this.apI);
                    a(this.aqj, this.aqh, this.apJ);
                    a(this.aqk, this.aqf, this.apK);
                    break;
                case 2:
                    a(this.aqh, this.aql, this.apI);
                    a(this.aqm, this.aqh, this.apJ);
                    a(this.aqk, this.aqf, this.apK);
                    break;
            }
            if (i == 0) {
                a(arrayList.get(i2), this.apI);
            } else if (i == 1) {
                a(arrayList.get(i2), this.apJ);
            } else if (i == 2) {
                a(arrayList.get(i2), this.apK);
            }
        }
    }

    private void eg(int i) {
        if (this.apR.size() != 0) {
            int size = this.apR.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.apR.get(i2).intValue() == i) {
                    this.apR.remove(i2);
                    return;
                }
            }
        }
    }

    private boolean a(n nVar) {
        return (nVar == null || StringUtils.isNull(nVar.getLabelName())) ? false : true;
    }

    private void setCover(String str) {
        this.apH.setVisibility(0);
        if (!TextUtils.isEmpty(str)) {
            this.apH.c(str, 10, false);
        } else {
            this.apH.c(null, 10, false);
        }
    }

    private void setBaName(String str) {
        if (TextUtils.isEmpty(str)) {
            this.apM.setText("");
            return;
        }
        String trim = str.trim();
        this.apM.setVisibility(0);
        if (com.baidu.tbadk.util.v.gD(trim) > 12) {
            trim = String.valueOf(com.baidu.tbadk.util.v.d(trim, 0, 12)) + "...";
        }
        this.apM.setText(String.valueOf(trim) + TbadkCoreApplication.m9getInst().getResources().getString(r.j.bar));
    }

    private void setContent(String str) {
        if (TextUtils.isEmpty(str)) {
            this.apF.setText("");
            this.apF.setVisibility(8);
            return;
        }
        this.apF.setVisibility(0);
        this.apF.setText(str);
    }

    private void setTitle(String str) {
        this.aqn = str;
        if (this.apS != 0) {
            this.title.setPadding(0, 0, (int) this.context.getResources().getDimension(this.apS), 0);
            this.apS = 0;
        } else {
            this.title.setPadding(0, 0, 0, 0);
        }
        if (TextUtils.isEmpty(str)) {
            this.title.setText("");
            return;
        }
        this.title.setVisibility(0);
        if (this.apU) {
            if (this.apX) {
                this.title.setText(an.c(this.context, str, r.j.kn_zhibo));
                return;
            } else {
                this.title.setText(e(str));
                return;
            }
        }
        this.title.setText(str);
    }

    public static SpannableStringBuilder e(CharSequence charSequence) {
        if (charSequence == null || charSequence.length() == 0) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(String.valueOf("live") + "space" + ((Object) charSequence));
        Bitmap cN = av.cN(r.f.icon_zhibo);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(cN);
        int height = cN.getHeight();
        bitmapDrawable.setBounds(0, 0, cN.getWidth(), height);
        spannableStringBuilder.setSpan(new com.baidu.adp.widget.d(bitmapDrawable, 1), 0, "live".length(), 33);
        ColorDrawable colorDrawable = new ColorDrawable();
        colorDrawable.setBounds(0, 0, 10, height);
        spannableStringBuilder.setSpan(new com.baidu.adp.widget.d(colorDrawable, 1), 1, "live".length() + "space".length(), 33);
        return spannableStringBuilder;
    }

    private void eS(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.aps.c(str, 12, false);
        } else {
            this.aps.c(null, 12, false);
        }
    }

    private void setUserName(String str) {
        if (TextUtils.isEmpty(str)) {
            this.apv.setText("");
            return;
        }
        this.apv.setVisibility(0);
        String trim = str.trim();
        if (com.baidu.tbadk.util.v.gD(trim) > 14) {
            trim = String.valueOf(com.baidu.tbadk.util.v.d(trim, 0, 14)) + "...";
        }
        this.apv.setText(trim);
    }

    private void setNickName(String str) {
        if (TextUtils.isEmpty(str)) {
            d(this.apw, this.context.getResources().getString(r.j.fans_default_name));
        } else {
            d(this.apw, str);
        }
    }

    private void d(TextView textView, String str) {
        textView.setText(str);
        Drawable drawable = av.getDrawable(r.f.icon_fengsi_n);
        drawable.setBounds(0, 0, this.size, this.size);
        textView.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
    }

    private void setFansNum(int i) {
        this.apx.setText(az.z(i));
    }

    private void setReplyNum(int i) {
        b(this.apy, i);
    }

    private void b(TextView textView, long j) {
        if (j <= 0) {
            textView.setText("");
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            return;
        }
        textView.setText(az.z(j));
        Drawable drawable = av.getDrawable(r.f.icon_comment_n);
        drawable.setBounds(0, 0, this.size, this.size);
        textView.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
    }

    private void i(int i, boolean z) {
        if (z) {
            this.apO.setVisibility(0);
            b(this.apO, i);
            return;
        }
        this.apO.setVisibility(8);
    }

    private void setHeadLiveIconInHead(boolean z) {
        if (z && this.apm) {
            this.apz.setVisibility(0);
            av.k(this.apz, r.f.label_onthelist);
            return;
        }
        this.apz.setVisibility(8);
    }

    private void setRefreshTimeInHead(String str) {
        if (this.apl) {
            this.apA.setVisibility(0);
            this.apA.setText(str);
            return;
        }
        this.apA.setVisibility(8);
        this.apA.setText("");
    }

    private void o(String str, boolean z) {
        if (!z) {
            this.apC.setVisibility(8);
            return;
        }
        this.apC.setVisibility(0);
        this.apC.setText(str);
    }

    private void p(String str, boolean z) {
        if (!z) {
            this.apN.setVisibility(8);
            return;
        }
        this.apN.setVisibility(0);
        this.apN.setText(str);
    }

    public void setShowHead(boolean z) {
        this.apd = z;
    }

    public void setShowTitle(boolean z) {
        this.ape = z;
    }

    public void setShowRefreshTimeInTitle(boolean z) {
        this.apj = z;
    }

    public void setShowContent(boolean z) {
        this.apf = z;
    }

    public void setShowCover(boolean z) {
        this.apg = z;
    }

    public void setShowExpression(boolean z) {
        this.aph = z;
    }

    public void setShowBottom(boolean z) {
        this.api = z;
    }

    public void setShowRefreshTimeInHead(boolean z) {
        this.apl = z;
    }

    public void setShowHeadLiveIcon(boolean z) {
        this.apm = z;
    }

    public void setShowReplyNumInButtom(boolean z) {
        this.apn = z;
    }

    public void setShowDeleteButtonInTitle(boolean z) {
        this.apo = z;
    }

    public void setChooseStyle(int i) {
        this.apQ = i;
    }

    public int getShowStyle() {
        return this.apQ;
    }

    public void setShowLiveIcon(boolean z) {
        this.apU = z;
    }

    public void setDeleteButtonClickListener(a aVar) {
        this.apb = aVar;
    }

    public void setPortraitClicklistener(b bVar) {
        this.apc = bVar;
    }

    public void setParentBackground(int i) {
        av.k(this.apq, i);
    }

    public void setContentPaddingBottom(int i) {
        this.paddingBottom = i;
    }

    public void setHeadPaddingTop(int i) {
        this.paddingTop = i;
    }

    public void setShowImage(boolean z) {
        this.apV = z;
    }

    public void setShowRefreshTimeInButtom(boolean z) {
        this.apk = z;
    }

    public void setTitlePaddingRight(int i) {
        this.apS = i;
    }

    public void setTitleMaxLines(int i) {
        this.apT = i;
    }

    public void setAllowGreyState(boolean z) {
        this.apW = z;
    }

    public void bk(boolean z) {
        this.apX = z;
    }
}
